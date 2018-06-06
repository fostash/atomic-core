package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public class LowerCase extends SqlFunction {

    public <T extends IExpression> LowerCase(final T argument) {
        super("lower", argument);
    }

    @Override
    public void extractBindVariables(Map vars) {
        for (final IExpression<?> arg : this.arguments) {
            arg.extractBindVariables(vars);
        }
    }
}
