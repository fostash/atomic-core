package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.ICondition;
import org.fostash.atomic.dsl.IDelete;
import org.fostash.atomic.dsl.IFrom;
import org.fostash.atomic.dsl.SqlStructure;

/**
 *
 * Created by Fausto on 25/04/16.
 */
public class Delete implements IDelete {

    /** table field. */
    private final IFrom.ITable table;

    /**
     * @param aTable table
     */
    public Delete(final IFrom.ITable aTable) {
        this.table = aTable;
    }

    @Override
    public final ICondition where() {
        return Factory.where(this).where();
    }

    @Override
    public final String toString() {
        return "DELETE FROM " + table;
    }

    @Override
    public SqlStructure build() {
        // TODO: implement
        return null;
    }
}
