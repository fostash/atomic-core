package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.metamodel.ColumnMeta;

public class UpperCase extends SqlFunction {

    public <T extends ColumnMeta> UpperCase(final T argument) {
        super("lower", argument);
    }
}
