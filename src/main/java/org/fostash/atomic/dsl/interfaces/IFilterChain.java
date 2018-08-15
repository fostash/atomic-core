package org.fostash.atomic.dsl.interfaces;

public interface IFilterChain extends IBasicFilterChain, IOrderable, IGroupable {

    /**
     * Overrides {@link IBasicFilterChain#and(ICondition)} and returns a covariant {@link IFilterChain}
     * @param condition condition to be chained
     * @return {@link IFilterChain} (covariant)
     */
    IFilterChain and(final ICondition condition);

    /**
     * Overrides {@link IBasicFilterChain#or(ICondition)}} and returns a covariant {@link IFilterChain}
     * @param condition condition to be chained
     * @return {@link IFilterChain} (covariant)
     */
    IFilterChain or(final ICondition condition);
}
