package org.fostash.atomic.dsl;

import java.util.Optional;

/**
 *
 * Created by Fausto on 16/03/16.
 */
public interface IInsert extends ISql {

    /**
     * @param table table
     * @param columns array of column
     * @return IInsert interface
     */
    IInsert into(final IFrom.ITable table, final ISelect.IColumn...columns);

    /**
     * @param objects values
     * @return IInsert interface
     */
    IInsert values(final Object... objects);
}
