package org.fostash.atomic.dsl;

import org.fostash.atomic.exception.SqlBuilderException;

import java.util.Map;

public interface IExpression<T> extends IRepresentable {
    void extractBindVariables(final Map<String, ? super Object> vars);

    default IExpression as(final String alias) {
        throw new SqlBuilderException("feature you are using not override this method");
    }

    default String getAlias() {
        return null;
    }

    default String buildAlias() {
        if (getAlias() != null) {
            return String.format("as %s", getAlias());
        }
        return "";
    }
}
