package org.fostash.atomic.dsl;

import org.fostash.atomic.metamodel.ColumnMeta;

import java.util.function.Function;

public final class Aggregator {

    public static Function<ColumnMeta, String> SUM = s -> "sum(" + s.getRepresentation() + ") "; // + s.getRepresentation();
}
