package org.fostash.atomic.dsl.interfaces;

/**
 * Everything I can call .join on
 */
public interface IJoinable extends IQuerable, IFilterable {
    IFilterableJoin innerJoin(final IQuerable joinable);
    IJoinable crossJoin(final IQuerable joinable);
    IFilterableJoin leftJoin(final IQuerable joinable);
    IFilterableJoin rightJoin(final IQuerable joinable);
    IFilterableJoin fullJoin(final IQuerable joinable);
}
