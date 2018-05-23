package org.fostash.atomic.dsl;

import org.fostash.atomic.metamodel.TableMeta;

import java.util.Map;

public interface IQueryDefinition {
    IExpression<?>[] getSelectList();
    Map<String, TableMeta> getTableList();
    Map<String, ?> getBindVariables();
}
