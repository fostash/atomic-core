package org.fostash.atomic.dsl.interfaces;

public interface ISelectable<T> extends IExpression<T> {
    ISelectable qualifiedBy(final String qualifier);
}
