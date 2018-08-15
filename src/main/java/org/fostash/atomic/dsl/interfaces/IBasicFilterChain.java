package org.fostash.atomic.dsl.interfaces;

public interface IBasicFilterChain {
    IBasicFilterChain and(final ICondition condition);
    IBasicFilterChain or(final ICondition condition);

}
