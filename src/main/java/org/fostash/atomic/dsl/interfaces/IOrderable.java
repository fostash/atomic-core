package org.fostash.atomic.dsl.interfaces;

public interface IOrderable {
    /*IOrderable asc(final IExpression expression);
    IOrderable desc(final IExpression expression);*/
    IFilterChain orderBy(final IExpression... expressions);
}
