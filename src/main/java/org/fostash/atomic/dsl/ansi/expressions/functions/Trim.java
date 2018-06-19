package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public class Trim extends SqlFunction {

    public <T extends IExpression> Trim(final T argument) {
        super("trim", argument);
    }

    @Override
    public void extractBindVariables(Map vars) {
        for (final IExpression<?> arg : this.arguments) {
            arg.extractBindVariables(vars);
        }
    }
}
