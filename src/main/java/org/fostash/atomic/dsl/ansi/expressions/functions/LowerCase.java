package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.metamodel.ColumnMeta;

public class LowerCase extends SqlFunction {

    public <T extends ColumnMeta> LowerCase(final T argument) {
        super("lower", argument);
    }
}
