package org.fostash.atomic.dsl.interfaces;

public interface IAliasableTable extends ITable, IAliasable {

    /**
     * Covariant retur type
     * @param alias
     * @return
     */
    @Override
    IAliasableTable as(final String alias);
}
