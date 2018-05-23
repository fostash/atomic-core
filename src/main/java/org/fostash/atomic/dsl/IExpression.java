package org.fostash.atomic.dsl;

import java.util.Map;

public interface IExpression<T> {
    String getRepresentation();
    void extractBindVariables(final Map<String, ? super Object> vars);

    default String getAlias() {
        return null;
    }
}
