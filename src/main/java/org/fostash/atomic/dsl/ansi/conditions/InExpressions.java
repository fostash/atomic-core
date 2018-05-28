package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public class InExpressions<T> extends Condition {

    private final IExpression<T> expression;
    private final IExpression<T>[] expressions;
    private final boolean inversion;

    public InExpressions(final IExpression<T> expression, final boolean inversion, final IExpression<T> ... expressions) {
        this(null, expression, inversion, expressions);
    }

    public InExpressions(final String alias, final IExpression<T> expression, final boolean inversion, final IExpression<T> ... expressions) {
        if (expression == null) {
            throw new IllegalArgumentException("expression is null.");
        }

        if (expressions == null) {
            throw new IllegalArgumentException("expressions is null.");
        }

        if (expressions.length == 0) {
            throw new IllegalArgumentException("expressions is empty.");
        }

        this.inversion = inversion;
        this.expression = expression;
        this.expressions = expressions;
    }

    @Override
    public void extractBindVariables(Map<String, ? super Object> vars) {
        this.expression.extractBindVariables(vars);

        for (final IExpression<T> expression : this.expressions) {
            expression.extractBindVariables(vars);
        }
    }

    @Override
    public String getRepresentation() {
        final StringBuilder sbExpressions = new StringBuilder();
        for (final IExpression<T> expression : this.expressions) {
            if (sbExpressions.length() > 0) {
                sbExpressions.append(", ");
            }

            sbExpressions.append(expression.getRepresentation());
        }

        return String.format("(%s %s in (%s))", this.expression.getRepresentation(), this.inversion ? "not" : "", sbExpressions.toString());
    }
}
