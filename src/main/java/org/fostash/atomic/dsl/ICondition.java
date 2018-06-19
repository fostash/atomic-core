package org.fostash.atomic.dsl;

import org.fostash.atomic.metamodel.ColumnMeta;

/**
 * InExpressions PostgreSQL you can select a condition. So it must be an expression
 *
 * Vale la pena tenere questa interfaccia ?!?
 *
 * Created by Fausto on 09/03/16.
 */
public interface ICondition<L, R> extends IExpression<Boolean> {

//    /**
//     * equals condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//    ICondition eq(final ColumnMeta<L> f, final R v);
//
//    /**
//     * not equals condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//    ICondition notEq(final ColumnMeta<L> f, final R v);
//
//    /**
//     * greater than condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//    ICondition gt(final ColumnMeta<L> f, final R v);
//
//    /**
//     * less than condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//
//    ICondition lt(final ColumnMeta<L> f, final R v);
//
//    /**
//     * greater or equal than condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//
//    ICondition ge(final ColumnMeta<L> f, final R v);
//
//    /**
//     * less or equal than condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//    ICondition le(final ColumnMeta<L> f, final R v);
//
//    /**
//     * in condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//    ICondition in(final ColumnMeta<L> f, final R...v);
//
//    /**
//     * not in condition.
//     * @param f column name
//     * @param v value
//     * @return IJoint interface condition.
//     */
//    ICondition notIn(final ColumnMeta<L> f, final R[] v);
//
//    /**
//     * exists condition.
//     * @param select IQuery interface
//     * @return IJoint interface condition.
//     */
//    ICondition exists(final R select);
//
//    /**
//     * not exists condition.
//     * @param select IQuery interface
//     * @return IJoint interface condition.
//     */
//    ICondition notExists(final R select);
//
//    /**
//     * is null condition.
//     * @param f column name
//     * @return IJoint interface condition.
//     */
//    ICondition isNull(final ColumnMeta<L> f);
//
//    /**
//     * is not null condition.
//     * @param f column name
//     * @return IJoint interface condition.
//     */
//    ICondition isNotNull(final ColumnMeta<L> f);
//
//    /**
//     * limit result to lim value
//     * @param lim limit
//     * @return ISql interface
//     */
//    ISql limit(int lim);
}
