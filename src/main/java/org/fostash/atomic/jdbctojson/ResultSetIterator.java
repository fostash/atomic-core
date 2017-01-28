package org.fostash.atomic.jdbctojson;

import org.fostash.atomic.dsl.ISql;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * An implementation of an iterator which wraps a row in a result set as a Tuple
 */
public class ResultSetIterator {

    private static final Logger logger = LoggerFactory.getLogger(ResultSetIterator.class);

    public static <T> List<T> getResult(final ISql sql, Function<JSONObject, T> converter) {
        return processQuery.apply(sql).stream().map(converter).collect(Collectors.toList());
    }

    private static Function<ISql, List<JSONObject>> processQuery = sql -> {

        try (final Connection connection = DBFactoryPool.getConnection();
            final PreparedStatement ps = connection.prepareStatement(sql.toString());
            final ResultSet rs = ps.executeQuery()) {
          
          final List<JSONObject> l = new LinkedList<>();
          while(rs.next()) {
            l.add(ResultSetIterator.rowSetConverter.apply(rs));
          }
          return l;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    };

    private static Function<ResultSet, JSONObject> rowSetConverter = rs -> {

        try {
            final JSONObject row = new JSONObject();
            final ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                final String columnName = rsmd.getColumnName(i);
                logger.info("Convert " + columnName + " " + rs.getObject(i) + " to " + rsmd.getColumnClassName(i));
                try {
                    if (rsmd.getColumnType(i) == Types.CLOB) {
                        final Clob clob = rs.getClob(i);
                        row.put(columnName, clob.getSubString(1, (int) clob.length()));
                    } else {
                        final Object obj = TransformerService.convert(rs.getObject(i), columnName, Class.forName(rsmd.getColumnClassName(i)));
                        row.put(
                                columnName,
                                obj != null ? obj : JSONObject.NULL
                        );
                    }
                } catch (ClassNotFoundException e) {
                    // maybe return JsonObject with string "Invalid data format" + [original value];
                    throw new DataAccessException("Invalid data format", e);
                }
            }
            return row;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    };
}
