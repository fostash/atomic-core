package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.exception.SqlBuilderException;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public interface ISelect extends ISql {

    /**
     * @param c array of columns
     * @return IFrom interface
     */
    IFrom select(IColumn... c);

    /**
     * IColumn interface.
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
         * @return function to apply
         */
        String getFunction();

        /**
         * build sql instruction.
         *
         * @return sql instruction
         * @throws SqlBuilderException
         */
        String build() throws SqlBuilderException;
    }
}
