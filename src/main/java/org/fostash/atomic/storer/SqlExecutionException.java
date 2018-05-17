package org.fostash.atomic.storer;

import java.sql.SQLException;

public class SqlExecutionException extends SQLException {

    public SqlExecutionException(final Throwable t) {
        super(t);
    }
}
