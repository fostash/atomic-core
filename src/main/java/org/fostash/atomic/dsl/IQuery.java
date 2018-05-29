package org.fostash.atomic.dsl;

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
    IQuery from(final TableMeta table, final String alias);
    IQuery where(final ICondition ... conditions);
    IQuery where(final IJoint conditionChain);
}
