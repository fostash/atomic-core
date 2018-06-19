package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.dsl.IRepresentable;
import org.fostash.atomic.metamodel.TableMeta;

public class From implements IRepresentable {

    private final TableMeta table;

    From(final TableMeta table) {
        this.table = table;
    }

    public static From of(final TableMeta table) {
        return new From(table);
    }

    @Override
    public String getRepresentation() {
        return String.format("%s%s", table.getName(), table.getAlias());
    }
}
