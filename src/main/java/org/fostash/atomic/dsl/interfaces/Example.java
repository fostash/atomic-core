package org.fostash.atomic.dsl.interfaces;

import static org.fostash.atomic.dsl.interfaces.IOrderable.SortDirection.ASCENDING;
import static org.fostash.atomic.dsl.interfaces.IOrderable.SortDirection.DESCENDING;
import static org.fostash.atomic.dsl.interfaces.IOrderable.sort;

public class Example {
    public Example() {
        final IQuery q = null;
        q.select((IExpression[]) null)
                .from(null)
                .innerJoin(null).on(null)
                .crossJoin(null)
                .where(null).and(null).and(null).or(null)
                .groupBy((IExpression[]) null)
                .orderBy((IExpression) null)                // Solution #1
                .orderBy((IExpression) null, DESCENDING)    // Solution #1
                .orderBy((IExpression) null, ASCENDING)     // Solution #1
                .orderBy(sort((IExpression) null), sort((IExpression) null, ASCENDING), sort((IExpression) null, DESCENDING)); // Solution #2
                //.orderBy((IExpression[]) null);
                //.asc(null).desc(null).desc(null);
    }
}
