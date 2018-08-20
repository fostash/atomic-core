package org.fostash.atomic.dsl.interfaces;

public interface IExpression<T> {
    IExpression<T> as(final String alias);
}
