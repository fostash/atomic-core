package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.ansi.expressions.functions.LowerCase;
import org.fostash.atomic.dsl.ansi.expressions.functions.SqlFunction;
import org.fostash.atomic.dsl.ansi.expressions.functions.UpperCase;

public interface IQueryFactory {
    IQuery createQuery();
    <T> IExpression<T> bind(final String name, final T value);

    SqlFunction<?> function(final String functionName, final IExpression<?> ... arguments);
    LowerCase<String> toLowerCase(final IExpression<String> arg);
    UpperCase<String> toUpperCase(final IExpression<String> arg);

    <T> ICondition isNull(final IExpression<T> op);
    <T> ICondition isNotNull(final IExpression<T> op);
    <T> ICondition eq(final IExpression<T> op1, final IExpression<T> op2);
    <T> ICondition neq(final IExpression<T> op1, final IExpression<T> op2);
    <T> ICondition gt(final IExpression<T> op1, final IExpression<T> op2);
    <T> ICondition lt(final IExpression<T> op1, final IExpression<T> op2);
    <T> ICondition gte(final IExpression<T> op1, final IExpression<T> op2);
    <T> ICondition lte(final IExpression<T> op1, final IExpression<T> op2);
    <T> ICondition in(final IExpression<T> expression, final IExpression<T> ... expressions);
    <T> ICondition notIn(final IExpression<T> expression, final IExpression<T> ... expressions);
    <T> ICondition in(final IExpression<T> expression, final IQuery subquery);
    <T> ICondition notIn(final IExpression<T> expression, final IQuery subquery);

}
