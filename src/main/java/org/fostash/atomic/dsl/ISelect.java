package org.fostash.atomic.dsl;

import org.fostash.atomic.exception.SqlBuilderException;
import org.fostash.atomic.metamodel.ColumnMeta;

import java.util.List;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface ISelect extends ISql {

    /**
     * @param c array of columns
     * @return IFrom interface
     */
    IFrom select(ColumnMeta... c);
    IFrom select(Aggregator aggregator, ColumnMeta... c);
    IFrom select(List<Aggregator> aggregators, ColumnMeta... c);

    /**
     *
     * IColumn interface.
     * is implemented by generated class from class annotation
     */
    interface IColumn {

        /**
         * @return column name
         */
        String getName();

        /**
         * @return column alias
         */
        String getAlias();

        /**
         * @return aggregator function
         */
        Aggregator getFunction();

        /**
         * build sql instruction.
         *
         * @return sql instruction
         * @throws SqlBuilderException
         */
        String build() throws SqlBuilderException;
    }
}
