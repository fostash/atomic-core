package org.fostash.atomic.storer;

import javaslang.control.Try;
import org.fostash.atomic.dsl.*;
import org.fostash.atomic.jdbctojson.ResultSetIterator;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.fostash.atomic.jdbctojson.DBFactoryPool.getConnection;

/**
 *
 * Created by Fausto on 17/03/16.
 */
public final class Storer {

    private static final Logger logger = LoggerFactory.getLogger(Storer.class);

    public static final Long NO_KEY_GENERATED = 0x1L;

    private static Function<Throwable, Long> mapExceptionToCode = t -> 0L;
    private static Function<Throwable, JSONObject> mapExceptionToJsonCode = JSONObject::new;

    /**
     * private constructor.
     */
    private Storer() {
    }

    /**
     * @param sql sql to process
     * @param performer operation to performer on result set
     * @return T as JSONObject from ResultSet or Exception
     */
    public static <T> Try<T> processStatement(final ISql sql, final StatementPerformer<T> performer) {
        return Try.of(() -> {
                final Connection connection = getConnection();
                final PreparedStatement statement = connection.prepareStatement(
                        String.valueOf(sql),
                        Statement.RETURN_GENERATED_KEYS
                );
            return performer.perform(statement);
        });
    }

    /**
     * @param sql sql to process
     * @return entity id if present, optional.empty if no id present or an exception
     */
    public static Try<Long> create(final IInsert sql) {
        return processStatement(sql, statement -> {

            logger.info("executing sql statement: " + sql);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating failed, no rows affected.");
            }

            try (final ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    return NO_KEY_GENERATED;
                }
            }
        });
    }

    /**
     * @param sql update sql expression
     * @return updated rows number
     */
    public static Try update(final ISql sql) {

        return processStatement(sql, statement -> {

            logger.info("executing sql statement: " + sql);
            return Try.success(statement.executeUpdate());
        });
    }

    /**
     * @param sql delete sql expression
     * @return json object from supplier
     */
    public static Try delete(final ISql sql) {
        return processStatement(sql, statement -> {

            logger.info("executing sql statement: " + sql);
            return Try.success(statement.executeUpdate());
        });
    }

    public static Try<Clob> writeClob(final String clob, IFrom.ITable table, ISelect.IColumn column, IWhere where) {
        return Try.of(() -> {
            final Connection connection = getConnection();
            final Clob myClob = connection.createClob();
            myClob.setString(1, clob);
            final String sql = "UPDATE " + table + " SET " + column + "= ? WHERE " + where;
            final PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setClob(1, myClob);
            pstmt.executeUpdate();
            return myClob;
        });
    }

    /**
     * @param sql sql expression
     * @return Stream of json object
     */
    public static List<JSONObject> read(final ISql sql) {

        logger.info("executing sql statement: " + sql);
        return ResultSetIterator.getResult(sql, Function.identity());
    }

    /**
     * @param sql sql expression
     * @return Stream of json object
     */
    public static <T> List<T> read(final ISql sql, final Function<JSONObject, T> c) {

        logger.info("executing sql statement: " + sql);
        return ResultSetIterator.getResult(sql, c);
    }

    /**
     * @param sql sql expression
     * @return Stream of json object
     */
    public static Try<JSONObject> singleResult(final ISql sql) {

        logger.info("executing sql statement: " + sql);
        return singleResult(sql, Function.identity());
    }

    /**
     * @param sql sql expression
     * @return Stream of json object
     */
    public static <T> Try<T> singleResult(final ISql sql, final Function<JSONObject, T> c) {

        logger.info("executing sql statement: " + sql);
        final List<T> res = ResultSetIterator.getResult(sql, c);
        if (res.isEmpty()) {
            return Try.failure(new SQLException("no result found"));
        } else if (res.size() > 1) {
            return  Try.failure(new SQLException("multiple result found"));
        }
        return Try.success(res.get(0));
    }

    private final List<ISql> batches = new LinkedList<>();

    public static Storer inTransaction() {
        return new Storer();
    }

    public Storer execute(final ISql sql) {
        batches.add(sql);
        return this;
    }

    public Try collect() {
        return Try.of(() -> {
                final Connection connection = getConnection();
                connection.setAutoCommit(false);
                List<Long> collect = new LinkedList<>();
                for (final ISql sql: batches) {
                    final PreparedStatement statement = connection.prepareStatement(
                            String.valueOf(sql),
                            Statement.RETURN_GENERATED_KEYS
                    );

                    try (final ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            collect.add(generatedKeys.getLong(1));
                        } else {
                            collect.add(NO_KEY_GENERATED);
                        }
                    }
                }
                connection.setAutoCommit(false);
                return collect;
            });
    }


}