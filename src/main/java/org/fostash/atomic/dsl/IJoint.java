package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 08/03/16.
 */
public interface IJoint extends ISql, IOrder {

    /**
     * and operator.
     *
     * @return ICondition interface
     */
    ICondition and();

    /**
     * use this method to open a parantesis for multiple OR condition
     * like AND (cml1 = val1 OR clm2 = val2). for close look at method endOr.
     *
     * @return ICondition interface
     */
    ICondition openOr();

    /**
     * or operator.
     * @return ICondition interface
     */
    ICondition or();

    /**
     * call this method to close parentesis for multiple OR condition.
     *
     * @return IJoint interface
     */
    IJoint endOr();
}
