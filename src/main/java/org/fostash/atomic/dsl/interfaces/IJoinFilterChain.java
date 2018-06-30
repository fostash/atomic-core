package org.fostash.atomic.dsl.interfaces;

public interface IJoinFilterChain extends IJoinable, IFilterable, IOrderable {
    IJoinFilterChain and(final ICondition condition);
}
