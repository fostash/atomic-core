package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.dsl.IExpression;

public class UpperCase<T> extends SqlFunction<T> {
    public UpperCase(final IExpression<?> argument) {
        super("upper", argument);
    }

    public UpperCase(final String alias, final IExpression<?> argument) {
        super(alias, "upper", argument);
    }
}
