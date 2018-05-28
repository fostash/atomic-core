package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public class BinaryCondition extends Condition {
    private final IExpression<?> expression1;
    private final IExpression<?> expression2;
//    private final boolean inversion;
    private final String operator;

    public BinaryCondition(final IExpression<?> expression1, final IExpression<?> expression2, /*final boolean inversion, */final String operator) {
        this(expression1, expression2, /*inversion, */operator, null);
    }

    public BinaryCondition(final IExpression<?> expression1, final IExpression<?> expression2, /*final boolean inversion, */final String operator, final String alias) {
        super(alias);

        if (expression1 == null) {
            throw new IllegalArgumentException("expression1 was null.");
        }

        if (expression2 == null) {
            throw new IllegalArgumentException("expression2 was null.");
        }

        if (operator == null) {
            throw new IllegalArgumentException("operator was null.");
        }

        this.expression1 = expression1;
        this.expression2 = expression2;
//        this.inversion = inversion;
        this.operator = operator;
    }

    protected IExpression<?> getExpression1() {
        return expression1;
    }

    protected IExpression<?> getExpression2() {
        return expression2;
    }

    protected String getOperator() {
        return operator;
    }

    @Override
    public void extractBindVariables(final Map<String, ? super Object> vars) {
        this.expression1.extractBindVariables(vars);
        this.expression2.extractBindVariables(vars);
    }

    @Override
    public String getRepresentation() {
        if (this.getAlias() != null && !this.getAlias().isEmpty()) {
            return String.format("(%s %s %s) as %s", this.expression1.getRepresentation(), this.operator, this.expression2.getRepresentation(), this.getAlias());
        } else {
            return String.format("(%s %s %s)", this.expression1.getRepresentation(), this.operator, this.expression2.getRepresentation());
        }
    }
}
