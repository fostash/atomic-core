package org.fostash.atomic.dsl.interfaces;

public interface IOrderable {
    IToBeDefined orderBy(final IExpression ... expressions);
}
