package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface IWhere extends ISql, IOrder {

    /**
     * @return ICondition interface.
     */
    ICondition where();
}
