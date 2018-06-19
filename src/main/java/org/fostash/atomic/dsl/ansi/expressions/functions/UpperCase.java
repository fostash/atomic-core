package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public class UpperCase extends SqlFunction {

    public <T extends IExpression> UpperCase(final T argument) {
        super("upper", argument);
    }

    @Override
    public void extractBindVariables(Map vars) {
        for (final IExpression<?> arg : this.arguments) {
            arg.extractBindVariables(vars);
        }
    }
}
