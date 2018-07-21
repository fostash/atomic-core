package org.fostash.atomic.dsl.interfaces;

public interface IComposable {

    IQuery union();
    IQuery unionAll();
    IQuery minus();
}
