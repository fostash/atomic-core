package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 23/04/16.
 */
public interface IDelete extends ISql {

    /**
     * dsl where method.
     * @return ICondition interface
     */
    ICondition where();
}
