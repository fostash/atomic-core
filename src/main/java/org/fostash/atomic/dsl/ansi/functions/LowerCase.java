package org.fostash.atomic.dsl.ansi.functions;

import org.fostash.atomic.dsl.IExpression;

public class LowerCase<T> extends SqlFunction<T> {
    public LowerCase(final IExpression<?> argument) {
        super("lower", argument);
    }

    public LowerCase(final String alias, final IExpression<?> argument) {
        super(alias, "lower", argument);
    }
}
