package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IQuery;

import java.util.Map;

public class InSubquery extends Condition {
    private final IExpression expression;
    private final IQuery subquery;
    private final boolean inversion;

    public InSubquery(final IExpression expression, final IQuery subquery, final boolean inversion) {
        this(expression, subquery, inversion, null);
    }

    public InSubquery(final IExpression<?> expression, final IQuery subquery, final boolean inversion, final String alias) {
        super(alias);

        if (expression == null) {
            throw new IllegalArgumentException("expression is null.");
        }

        if (subquery == null) {
            throw new IllegalArgumentException("subquery is null.");
        }

        this.inversion = inversion;
        this.expression = expression;
        this.subquery = subquery;
    }

    @Override
    public void extractBindVariables(Map vars) {
        this.subquery.extractBindVariables(vars);
    }

    @Override
    public String getRepresentation() {
        return String.format("(%s %s in (%s))", this.expression.getRepresentation(), this.inversion ? "not" : "", this.subquery.getRepresentation());
    }
}
