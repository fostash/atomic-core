package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.IFrom;
import org.fostash.atomic.dsl.ISelect;
import org.fostash.atomic.metamodel.TableMeta;

/**
 *
 * Created by Fausto on 09/03/16.
 */
public class From implements IFrom {

    /** select field. */
    private ISelect select;
    /** sigle table field */
    private TableMeta table;

    /**
     * @param aSelect ISelect interface
     */
    public From(final ISelect aSelect) {
        this.select = aSelect;
    }

    /**
     * @param tableMeta table list
     * @return IWhere interface
     */
    @Override
    public ITable from(TableMeta tableMeta) {
        table = tableMeta;
        return null;
    }

    @Override
    public final String toString() {
        return select
                + " FROM " + table;
    }
}
