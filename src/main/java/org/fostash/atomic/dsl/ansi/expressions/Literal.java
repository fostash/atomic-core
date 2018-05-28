package org.fostash.atomic.dsl.ansi.expressions;

import org.fostash.atomic.dsl.IExpression;

import java.math.BigDecimal;
import java.util.Map;

public class Literal<T> implements IExpression<T> {
    private final T value;
    private final String alias;

    public Literal(final T value) {
        this.value = value;
        this.alias = null;
    }

    public Literal(final T value, final String alias) {
        this.value = value;
        this.alias = alias;
    }

    @Override
    public String getRepresentation() {
        if (this.value == null) {
            return "null";

        } else if (this.value instanceof BigDecimal) {
            return ((BigDecimal) this.value).toPlainString();

        } else {
            return this.value.toString();
        }
    }

    @Override
    public void extractBindVariables(Map<String, ? super Object> vars) {
        // Nothing to do. A literal is the contrary of a bind variable.
    }

    @Override
    public String getAlias() {
        return this.alias;
    }
}
