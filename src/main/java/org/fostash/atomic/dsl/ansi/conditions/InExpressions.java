package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IRepresentable;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InExpressions<T> extends Condition {

    private final IExpression<T> expression;
    private final IExpression<T>[] expressions;
    private final boolean inversion;

    public InExpressions(final IExpression<T> expression, final boolean inversion, final IExpression<T> ... expressions) {
        this(null, expression, inversion, expressions);
    }

    public InExpressions(final String alias, final IExpression<T> expression, final boolean inversion, final IExpression<T> ... expressions) {
        super(alias);
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
        /*final StringBuilder sbExpressions = new StringBuilder();
        for (final IExpression<T> expression : this.expressions) {
            if (sbExpressions.length() > 0) {
                sbExpressions.append(", ");
            }

            sbExpressions.append(expression.getRepresentation());
        }*/

        final String expRepresentation = Stream.of(this.expressions)
                .map(IRepresentable::getRepresentation)
                .collect(Collectors.joining(", "));

        return String.format("(%s %s in (%s)) %s", this.expression.getRepresentation(), this.inversion ? "not " : "", expRepresentation,
                this.getAlias() != null ? "as " + getAlias() : "");
    }
}
