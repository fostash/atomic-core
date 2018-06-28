package org.fostash.atomic.dsl.interfaces;

public interface IFilterChain extends IOrderable {
    IFilterChain and(final ICondition condition);
    IFilterChain or(final ICondition condition);
}
