package org.fostash.atomic.metamodel;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public interface ColumnMeta<T> {

    String getName();

    default String getAlias(){
        return null;
    }

    default String build() {
        return Optional.ofNullable(getAlias())
                .map(alias -> getName() + " " + alias)
                .orElse(getName());
    }

    @SuppressWarnings("unchecked")
    default Class<T> getType() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}