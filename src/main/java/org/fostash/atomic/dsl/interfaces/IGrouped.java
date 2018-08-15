package org.fostash.atomic.dsl.interfaces;

public interface IGrouped extends IOrderable {
    IGroupByFilterChain having(final ICondition condition);
}
