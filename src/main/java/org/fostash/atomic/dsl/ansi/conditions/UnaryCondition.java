package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public abstract class UnaryCondition<T> extends Condition {

    private final IExpression<T> expression;

    protected UnaryCondition(final IExpression<T> expression) {
        this(expression, null);
    }

    protected UnaryCondition(final IExpression<T> expression, final String alias) {
        super(alias);

        if (expression == null) {
            throw new IllegalArgumentException("expression is null.");
        }

        this.expression = expression;
    }

    protected IExpression<T> getExpression() {
        return expression;
    }

    @Override
    public void extractBindVariables(final Map vars) {
        this.expression.extractBindVariables(vars);
    }
}
