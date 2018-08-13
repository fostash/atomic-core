package org.fostash.atomic.dsl.interfaces;

import java.util.Map;

public interface IOrderable {
    /*IOrderable asc(final IExpression expression);
    IOrderable desc(final IExpression expression);*/
    //IFilterChain orderBy(final IExpression... expressions);

    //////////////////////////////////////////////////////
    //
    //  SOLUTION #1
    //
    IOrderable orderBy(final IExpression expression, final SortDirection direction);

    default IOrderable orderBy(final IExpression expression) {
        return this.orderBy(expression, SortDirection.ASCENDING);
    }
    //////////////////////////////////////////////////////


    //////////////////////////////////////////////////////
    //
    //  SOLUTION #2
    //
    void orderBy(final Map.Entry<IExpression, SortDirection> ... expressions);

    static Map.Entry<IExpression, SortDirection> sort(final IExpression expression) {
        return sort(expression, SortDirection.ASCENDING);
    }

    static Map.Entry<IExpression, SortDirection> sort(final IExpression expression, final SortDirection direction) {
        return new Map.Entry<IExpression, SortDirection>() {
            @Override
            public IExpression getKey() {
                return expression;
            }

            @Override
            public SortDirection getValue() {
                return direction;
            }

            @Override
            public SortDirection setValue(SortDirection value) {
                throw new UnsupportedOperationException("Changing this value is not supported.");
            }
        };
    }
    //////////////////////////////////////////////////////


    enum SortDirection {
        ASCENDING, DESCENDING
    }
}
