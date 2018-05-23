package org.fostash.atomic.dsl.ansi.functions;

import org.fostash.atomic.dsl.IExpression;

import java.util.Arrays;
import java.util.Map;

public class SqlFunction<T> implements IExpression<T> {

    private final String alias;
    private final String function;
    private final IExpression<?>[] arguments;

    public SqlFunction(final String function, final IExpression<?>... arguments) {
        this(null, function, arguments);
    }

    public SqlFunction(final String alias, final String function, final IExpression<?>... arguments) {
        if (function == null || function.isEmpty()) {
            throw new IllegalArgumentException("'function' cannot be empty.");
        }

        this.alias = alias;
        this.function = function;
        this.arguments = Arrays.copyOf(arguments, arguments.length);
    }

    @Override
    public void extractBindVariables(final Map<String, ? super Object> vars) {
        for (final IExpression<?> arg : this.arguments) {
            arg.extractBindVariables(vars);
        }
    }

    @Override
    public String getRepresentation() {
        final StringBuilder args = new StringBuilder();
        for (final IExpression<?> arg : this.arguments) {
            if (args.length() > 0) {
                args.append(", ");
            }

            args.append(arg.getRepresentation());
        }

        return String.format("%s(%s)", this.function, args.toString());
    }

    @Override
    public String getAlias() {
        return this.alias;
    }
}
