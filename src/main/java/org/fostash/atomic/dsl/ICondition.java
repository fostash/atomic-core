package org.fostash.atomic.dsl;

import org.json.JSONObject;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface ICondition extends ISql {

    /**
     * equals condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */
    IJoint eq(String f, Object v);

    /**
     * not equals condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */
    IJoint notEq(String f, Object v);

    /**
     * greater than condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */
    IJoint gt(String f, Object v);

    /**
     * less than condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */

    IJoint lt(String f, Object v);

    /**
     * greater or equal than condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */

    IJoint ge(String f, Object v);

    /**
     * less or equal than condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */
    IJoint le(String f, Object v);

    /**
     * in condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */
    IJoint in(String f, Object[] v);

    /**
     * not in condition.
     * @param f column name
     * @param v value
     * @return IJoint interface condition.
     */
    IJoint notIn(String f, Object[] v);

    /**
     * exists condition.
     * @param select ISelect interface
     * @return IJoint interface condition.
     */
    IJoint exists(ISelect select);

    /**
     * not exists condition.
     * @param select ISelect interface
     * @return IJoint interface condition.
     */
    IJoint notExists(ISelect select);

    /**
     * is null condition.
     * @param f column name
     * @return IJoint interface condition.
     */
    IJoint isNull(String f);

    /**
     * is not null condition.
     * @param f column name
     * @return IJoint interface condition.
     */
    IJoint isNotNull(String f);

    /**
     * limit result to lim value
     * @param lim limit
     * @return ISql interface
     */
    ISql limit(int lim);
}
