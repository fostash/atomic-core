package org.fostash.atomic.dsl;

import org.fostash.atomic.metamodel.TableMeta;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface IQuery extends ISql {

    /**
     *
     * @param selectList array of expressions
     * @return {@link IFrom} interface
     */
    IQuery select(final IExpression<?>... selectList);

    IQuery from(final TableMeta table);
    IQuery from(final TableMeta table, final String alias);
    IQuery where(final IJoint conditionChain);

//    /**
//     * @param c array of columns
//     * @return {@link IFrom} interface
//     */
//    IFrom select(ColumnMeta... c);
//    IFrom select(Aggregator aggregator, ColumnMeta... c);
//    IFrom select(List<Aggregator> aggregators, ColumnMeta... c);

//    /**
//     *
//     * IColumn interface.
//     * is implemented by generated class from class annotation
//     */
//    interface IColumn {
//
//        /**
//         * @return column name
//         */
//        String getName();
//
//        /**
//         * @return column alias
//         */
//        String getAlias();
//
//        /**
//         * @return aggregator function
//         */
//        Aggregator getFunction();
//
//        /**
//         * build sql instruction.
//         *
//         * @return sql instruction
//         * @throws SqlBuilderException
//         */
//        String build() throws SqlBuilderException;
//    }
}
