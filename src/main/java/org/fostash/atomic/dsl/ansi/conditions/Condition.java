package org.fostash.atomic.dsl.ansi.conditions;

import org.fostash.atomic.dsl.ICondition;
import org.fostash.atomic.dsl.IExpression;

public abstract class Condition implements ICondition {
    private final String alias;

    protected Condition() {
        this.alias = null;
    }

    protected Condition(String alias) {
        this.alias = alias;
    }

    @Override
    public String getAlias() {
        return this.alias;
    }
}
