package org.fostash.atomic.dsl.interfaces;

import static org.fostash.atomic.dsl.interfaces.IOrderable.SortDirection.ASCENDING;
import static org.fostash.atomic.dsl.interfaces.IOrderable.SortDirection.DESCENDING;
import static org.fostash.atomic.dsl.interfaces.IOrderable.sort;

public class Example {

    // These will be singletons and will be instantiated somehow by the metamodel system.
    private static final Employee EMP = new Employee();
    private static final Department DEPT = new Department();

    public Example() {
        final IQuery q = null;
        q.select((IExpression[]) null)
                .from(EMP).as("e")
                .innerJoin(DEPT).as("d").on(null)
                .crossJoin(null)
                .where(null).and(null).and(null).or(null)
                .groupBy((IExpression[]) null)
                .having(null).and(null).or(null)
                .orderBy((IExpression) null)                // Solution #1
                .orderBy((IExpression) null, DESCENDING)    // Solution #1
                .orderBy((IExpression) null, ASCENDING)     // Solution #1
                .orderBy(sort((IExpression) null), sort((IExpression) null, ASCENDING), sort((IExpression) null, DESCENDING)); // Solution #2
                //.orderBy((IExpression[]) null);
                //.asc(null).desc(null).desc(null);
    }



    private static final class Employee implements ITable {
    }

    private static final class Department implements ITable {
    }
}
