package org.fostash.atomic.dsl.interfaces;

public interface IGroupable {

    IFilterChain groupBy(final IExpression... expressions);
}
