package org.fostash.atomic.storer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * Created by Fausto on 17/03/16.
 */
@FunctionalInterface
public interface StatementPerformer<T> {

    T perform(PreparedStatement t) throws SQLException;
}
