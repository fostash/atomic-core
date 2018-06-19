package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.ansi.Join;
import org.fostash.atomic.metamodel.TableMeta;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface IQuery extends IExpression<Object> {

    /**
     *
     * @param selectList array of expressions
     * @return {@link IFrom} interface
     */
    IQuery select(final IExpression<?>... selectList);

    IQuery from(final TableMeta table);
    IQuery from(final Join join);
    //IQuery where(final ICondition condition);
    /*IQuery and(final ICondition condition);
    IQuery or(final ICondition condition);
    IQuery groupBy(final ColumnMeta... columns);
    IQuery orderBy(final IExpression<?>... columns);*/
}
