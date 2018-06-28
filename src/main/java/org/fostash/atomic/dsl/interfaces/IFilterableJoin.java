package org.fostash.atomic.dsl.interfaces;

public interface IFilterableJoin {
    IJoinFilterChain on(final ICondition condition);
}
