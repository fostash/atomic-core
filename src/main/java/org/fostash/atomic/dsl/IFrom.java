package org.fostash.atomic.dsl;

import org.fostash.atomic.metamodel.ColumnMeta;
import org.fostash.atomic.metamodel.TableMeta;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface IFrom extends ISql {

    /**
     *
     * @param table single table
     * @return ITable interface
     */
    ITable from(TableMeta table);

    /**
     * ITable interface.
     */
    interface ITable {

        ICondition where();

        IJoin innerJoin(TableMeta table);
        IJoin leftJoin(TableMeta table);
        IJoin rightJoin(TableMeta table);
    }

    interface IJoin {

        /**
         * call this method after all join condition.
         *
         * @return ICondition interface
         */

        ITable on(ColumnMeta left, ColumnMeta right);
        ITable on(ColumnMeta[] left, ColumnMeta[] right);
    }

}
