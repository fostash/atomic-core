package org.fostash.atomic.dsl.interfaces;

public interface IOrderable {
    IComposable orderBy(final ISortable... expressions);
}
