package org.fostash.atomic.metamodel;

import org.fostash.atomic.dsl.IExpression;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

public interface ColumnMeta<T> extends IExpression<T> {

    String getName();

    @Override
    default String getRepresentation() {
        return this.getName();
    }

    @Override
    default void extractBindVariables(final Map<String, ? super Object> vars) {
        // No bind variables allowed in this context
    }

    @SuppressWarnings("unchecked")
    default Class<T> getType() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}