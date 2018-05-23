package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.ansi.functions.LowerCase;
import org.fostash.atomic.dsl.ansi.functions.SqlFunction;
import org.fostash.atomic.dsl.ansi.functions.UpperCase;

public interface IQueryFactory {
    IQuery createQuery();
    <T> IExpression<T> bind(final String name, final T value);

    SqlFunction<?> function(final String functionName, final IExpression<?> ... arguments);
    LowerCase<String> toLowerCase(final IExpression<String> arg);
    UpperCase<String> toUpperCase(final IExpression<String> arg);

}
