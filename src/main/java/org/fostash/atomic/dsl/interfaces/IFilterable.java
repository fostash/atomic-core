package org.fostash.atomic.dsl.interfaces;

public interface IFilterable {
    IFilterChain where(final ICondition condition);
}
