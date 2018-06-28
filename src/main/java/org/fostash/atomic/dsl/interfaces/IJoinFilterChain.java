package org.fostash.atomic.dsl.interfaces;

public interface IJoinFilterChain extends IJoinable, IOrderable {
    IJoinFilterChain and(final ICondition condition);
}
