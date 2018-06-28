package org.fostash.atomic.dsl.interfaces;

/**
 * Everything I can call .join on
 */
public interface IJoinable {
    IFilterableJoin innerJoin(final IJoinable joinable);
    IJoinable crossJoin(final IJoinable joinable);
    IFilterableJoin leftJoin(final IJoinable joinable);
    IFilterableJoin rightJoin(final IJoinable joinable);
    IFilterableJoin fullJoin(final IJoinable joinable);
}
