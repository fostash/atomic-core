package org.fostash.atomic.dsl.ansi.expressions.functions;

import org.fostash.atomic.dsl.IExpression;
import org.fostash.atomic.dsl.IRepresentable;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SqlFunction implements IExpression<Object> {

    protected /*final */String alias;
    protected final String function;
    protected final IExpression<?>[] arguments;

    public <E extends IExpression> SqlFunction(final String function, final E... arguments) {
        //this(function, arguments);
        if (function == null || function.isEmpty()) {
            throw new IllegalArgumentException("'function' cannot be empty.");
        }
        this.function = function;
        this.arguments = Arrays.copyOf(arguments, arguments.length);
    }

    /*public <E extends IExpression> SqlFunction(final String alias, final String function, final E... arguments) {
        if (function == null || function.isEmpty()) {
            throw new IllegalArgumentException("'function' cannot be empty.");
        }

        this.alias = alias;
        this.function = function;
        this.arguments = Arrays.copyOf(arguments, arguments.length);
    }*/

    @Override
    public void extractBindVariables(final Map<String, ? super Object> vars) {
        for (final IExpression<?> arg : this.arguments) {
            arg.extractBindVariables(vars);
        }
    }

    @Override
    public String getRepresentation() {
        final String args = Stream.of(this.arguments)
                .map(IRepresentable::getRepresentation)
                .collect(Collectors.joining(", "));

        return String.format("%s(%s) %s", this.function, args, this.alias != null && !this.alias.isEmpty() ? alias : "");
    }

    @Override
    public IExpression<Object> as(String alias) {
        this.alias = alias;
        return this;
    }

    @Override
    public String getAlias() {
        return this.alias;
    }
}
