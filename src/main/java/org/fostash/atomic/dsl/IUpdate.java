package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 23/04/16.
 */
public interface IUpdate extends ISql {

    /**
     * @param sets array of set operation
     * @return IWhere interface
     */
    IWhere set(ISet... sets);

    /**
     * ISet interface.
     */
    interface ISet {
    }
}
