package org.fostash.atomic.jdbctojson;

import javaslang.control.Try;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 */
public final class DBFactoryPool {

    private static final Logger logger = LoggerFactory.getLogger(DBFactoryPool.class);

    @FunctionalInterface
    public interface SetupInformation {

        enum Keys {
            DRIVER,
            URL,
            USER,
            PASSWORD,
            POOLNAME,
            DBS_PACKAGE
        }

        Map<Keys, String> dbInfo();
    }

    private static SetupInformation si;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:apache:commons:dbcp:"
                + si.dbInfo().get(SetupInformation.Keys.POOLNAME));
    }

    public static void setupDriver(final SetupInformation si) throws SQLException {
        DBFactoryPool.si  = si;
        logger.info("setup connection driver for " + getInfo(SetupInformation.Keys.DRIVER));
        try {
            Class.forName(getInfo(SetupInformation.Keys.DRIVER));
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("Cannot find driver "
                    + getInfo(SetupInformation.Keys.DRIVER), e);
        }
        final ConnectionFactory connectionFactory =
                new DriverManagerConnectionFactory(
                        getInfo(SetupInformation.Keys.URL),
                        getInfo(SetupInformation.Keys.USER),
                        getInfo(SetupInformation.Keys.PASSWORD));

        logger.info("initialize connection pool " + getInfo(SetupInformation.Keys.POOLNAME));

        final PoolableConnectionFactory poolableConnectionFactory =
                new PoolableConnectionFactory(connectionFactory, null);

        final ObjectPool<PoolableConnection> connectionPool =
                new GenericObjectPool<>(poolableConnectionFactory);

        poolableConnectionFactory.setPool(connectionPool);

        final PoolingDriver driver =
                (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");

        driver.registerPool(getInfo(SetupInformation.Keys.POOLNAME),connectionPool);

        Try.of(() -> getInfo(SetupInformation.Keys.DBS_PACKAGE))
                .andThenTry(DBFactoryPool::createClassSchema).onSuccess(p -> System.out.println("class schema creation successful"));
    }

    public static void createClassSchema(final String packageName) throws SQLException {
        final DatabaseMetaData dbmd = getConnection().getMetaData();
        ResultSet schemas = dbmd.getSchemas();
        while(schemas.next()) {
        }
    }

    private static String getInfo(final SetupInformation.Keys key) {
        return si.dbInfo().get(key);
    }

    public static void printDriverStats() throws Exception {
        final PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
        final ObjectPool<? extends Connection> connectionPool =
                driver.getConnectionPool(getInfo(SetupInformation.Keys.POOLNAME));

        logger.info("NumActive: " + connectionPool.getNumActive());
        logger.info("NumIdle: " + connectionPool.getNumIdle());
    }

    public static void shutdownDriver() throws Exception {
        logger.info("Shutdown connection pool " + getInfo(SetupInformation.Keys.POOLNAME));
        final PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
        driver.closePool(getInfo(SetupInformation.Keys.POOLNAME));
    }

    public static Supplier<Try<Connection>> startTransaction() {
        return () -> Try.of(() -> {
                final Connection connection = getConnection();
                connection.setAutoCommit(false);
                return connection;
        });
    }

    public static void stopTransaction() throws SQLException {
        getConnection().setAutoCommit(true);
    }


}
