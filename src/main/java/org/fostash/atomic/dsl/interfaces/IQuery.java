package org.fostash.atomic.dsl.interfaces;

public interface IQuery extends IQuerable {
    /**
     * This method selects the specified expressions.
     * @param expressions vararg of {@link IExpression}s.
     * @return an {@link ISelectList} implementation.
     */
    ISelectList select(final IExpression ... expressions);

    /**
     * This method selects all the mapped column of {@code table}.
     * Same as calling {@link IQuery#select(IExpression...)} passing all the attributes.
     * @param table a table or view. All mapped columns will be in the select list.
     * @return an {@link ISelectList} implementation.
     */
    ISelectList select(final ITable table);
}
