package org.fostash.atomic.dsl.interfaces;

public class Example {
    public Example() {
        final IQuery q = null;
        q.select((IExpression[]) null)
                .from(null)
                .innerJoin(null).on(null)
                .crossJoin(null)
                .where(null).and(null).and(null).or(null)
                .groupBy((IExpression[]) null)
                .orderBy((IExpression[]) null);
                //.asc(null).desc(null).desc(null);
    }
}
