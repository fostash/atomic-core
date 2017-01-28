package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface IFrom extends ISql {

    /**
     *
     * @param table single table
     * @return IWhere interface
     */
    IWhere from(ITable table);

    IWhere where();


    /**
     * ITable interface.
     */
    interface ITable {

        IJoin innerJoin(String name, String alias);
        IJoin leftJoin(String name, String alias);
        IJoin rightJoin(String name, String alias);
    }

    interface IJoin {

        /**
         * call this method after all join condition.
         *
         * @return ICondition interface
         */

        ITable on(String left, String right);
    }

    interface IJoinCondition {}

}
