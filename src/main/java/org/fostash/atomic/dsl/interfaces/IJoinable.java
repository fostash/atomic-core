package org.fostash.atomic.dsl.interfaces;

/**
 * Everything I can call .join on
 */
public interface IJoinable extends IQuerable, IFilterable, IAliasable {
    IFilterableJoin innerJoin(final IQuerable joinable);
    IJoinable crossJoin(final IQuerable joinable);
    IFilterableJoin leftJoin(final IQuerable joinable);
    IFilterableJoin rightJoin(final IQuerable joinable);
    IFilterableJoin fullJoin(final IQuerable joinable);

    /**
     * Assigns an alias to this {@link IJoinable} and returns a covariant of {@link IAliasable#as(String)} return type.
     * @param alias the assigned alias.
     * @return {@link IJoinable}, a covariant of {@link IAliasable}.
     */
    @Override
    IJoinable as(final String alias);

}
