package org.fostash.atomic.dsl;

import java.util.Map;

public interface IExpression<T> extends IRepresentable {
    void extractBindVariables(final Map<String, ? super Object> vars);

    default String getAlias() {
        return null;
    }

    default String getTableAlias() {
        return null;
    }
}
