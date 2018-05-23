package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 16/03/16.
 */
public interface IInsert extends ISql {

//    /**
//     * @param table table
//     * @param columns array of column
//     * @return IInsert interface
//     */
//    IInsert into(final IFrom.ITable table, final IQuery.IColumn... columns);

    /**
     * @param objects values
     * @return IInsert interface
     */
    IInsert values(final Object... objects);
}
