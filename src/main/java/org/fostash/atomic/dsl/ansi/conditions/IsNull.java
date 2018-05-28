package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.IExpression;

public class IsNull<T> extends UnaryCondition<T> {

    private final boolean inversion;

    public IsNull(final IExpression<T> expression) {
        super(expression);
        this.inversion = false;
    }

    public IsNull(final IExpression<T> expression, String alias) {
        super(expression, alias);
        this.inversion = false;
    }

    public IsNull(final IExpression<T> expression, final boolean inversion) {
        super(expression);
        this.inversion = inversion;
    }

    public IsNull(final IExpression<T> expression, final boolean inversion, String alias) {
        super(expression, alias);
        this.inversion = inversion;
    }

    @Override
    public String getRepresentation() {
        if (this.getAlias() != null && !this.getAlias().isEmpty()) {
            return String.format("(%s is %s null) as %s", this.getExpression(), this.inversion ? "not" : "", this.getAlias());
        } else {
            return String.format("(%s is %s null)", this.getExpression(), this.inversion ? "not" : "");
        }
    }
}
