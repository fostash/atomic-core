package org.fostash.atomic.dsl.interfaces;

public interface IFilterableJoin extends IAliasable {
    IJoinFilterChain on(final ICondition condition);

    /**
     * Assigns an alias to this {@link IFilterableJoin} and returns a covariant of {@link IAliasable#as(String)} return type.
     * @param alias the assigned alias.
     * @return {@link IFilterableJoin}, a covariant of {@link IAliasable}.
     */
    @Override
    IFilterableJoin as(final String alias);
}
