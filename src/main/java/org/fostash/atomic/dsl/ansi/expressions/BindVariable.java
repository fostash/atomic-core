package org.fostash.atomic.dsl.ansi.expressions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Map;

public class BindVariable<T> implements IExpression<T> {

    private final String name;
    private final T value;

    public BindVariable(final String name, final T value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getRepresentation() {
        if (this.name.startsWith(":")) {
            return this.name;
        }

        return ":".concat(this.name);
    }

    @Override
    public void extractBindVariables(final Map<String, ? super Object> vars) {
        vars.put(this.name, this.value);
    }

    @Override
    public String toString() {
        return this.getRepresentation();
    }
}
