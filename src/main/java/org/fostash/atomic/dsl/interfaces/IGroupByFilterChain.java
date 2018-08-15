package org.fostash.atomic.dsl.interfaces;

public interface IGroupByFilterChain extends IBasicFilterChain, IOrderable {

    /**
     * Overrides {@link IBasicFilterChain#and(ICondition)}} and returns a covariant {@link IGroupByFilterChain}
     * @param condition condition to be chained
     * @return {@link IGroupByFilterChain} (covariant)
     */
    IGroupByFilterChain and(final ICondition condition);

    /**
     * Overrides {@link IBasicFilterChain#or(ICondition)}} and returns a covariant {@link IGroupByFilterChain}
     * @param condition condition to be chained
     * @return {@link IGroupByFilterChain} (covariant)
     */
    IGroupByFilterChain or(final ICondition condition);
}
