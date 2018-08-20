package org.fostash.atomic.dsl.interfaces;

import static org.fostash.atomic.dsl.interfaces.IOrderable.SortDirection.ASCENDING;
import static org.fostash.atomic.dsl.interfaces.IOrderable.SortDirection.DESCENDING;
import static org.fostash.atomic.dsl.interfaces.IOrderable.sort;

public class Example {

    private void example01() {
        // UNSAFE alias system (alias could be misspelled)
        // These WILL be singletons and will be instantiated somehow by the metamodel system.
        final SingletonEmployeeTableMeta EMP = new SingletonEmployeeTableMeta();
        final SingletonDepartmentTableMeta DEPT = new SingletonDepartmentTableMeta();

        final IQuery q = null;
        q.select(EMP.EMPID.qualifiedBy("e").as("employee_id"), EMP.FIRST_NAME.qualifiedBy("e").as("name"), EMP.LAST_NAME.qualifiedBy("e").as("surname"), DEPT.DESCR.qualifiedBy("d").as("department"))
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
    }

    private void exampleSafeAlias() {
        // SAFE alias system (alias is written just once; no possible misspelling).

        // These WILL NOT be singletons. Table meta classes will be instantiated when needed (with an alias or without an alias)
        final EmployeeTableMeta EMP_1 = new EmployeeTableMeta();
        final DepartmentTableMeta DEPT_1 = new DepartmentTableMeta();

        final IQuery q1 = null;
        q1.select(EMP_1.EMPID.as("employee_id"), EMP_1.FIRST_NAME.as("name"), EMP_1.LAST_NAME.as("surname"), DEPT_1.DESCR.as("department"))
                .from(EMP_1.as("e"))
                .innerJoin(DEPT_1.as("d")).on(null);


        // Alternate syntax #1
        final EmployeeTableMeta EMP_2 = new EmployeeTableMeta().as("e");
        final DepartmentTableMeta DEPT_2 = new DepartmentTableMeta().as("d");

        final IQuery q2 = null;
        q2.select(EMP_2.EMPID.as("employee_id"), EMP_2.FIRST_NAME.as("name"), EMP_2.LAST_NAME.as("surname"), DEPT_2.DESCR.as("department"))
                .from(EMP_2)
                .innerJoin(DEPT_2).on(null);


        // Alternate syntax #2 (constructor based alias)
        final EmployeeTableMeta EMP_3 = new EmployeeTableMeta("e");
        final DepartmentTableMeta DEPT_3 = new DepartmentTableMeta("d");

        final IQuery q3 = null;
        q3.select(EMP_3.EMPID.as("employee_id"), EMP_3.FIRST_NAME.as("name"), EMP_3.LAST_NAME.as("surname"), DEPT_3.DESCR.as("department"))
                .from(EMP_2)
                .innerJoin(DEPT_2).on(null);

        // Self join example
        final EmployeeTableMeta EMP_4_1 = new EmployeeTableMeta("e1");
        final EmployeeTableMeta EMP_4_2 = new EmployeeTableMeta("e2");
        final IQuery q4 = null;
        q4.select(EMP_4_1.EMPID.as("id1"), EMP_4_2.EMPID.as("id2"))
                .from(EMP_4_1)
                .innerJoin(EMP_4_2).on(null);
    }


    ////////////////////////////////////////////////////////
    //
    //  Table metadata draft classes. Should be generated.
    //
    private static final class SingletonEmployeeTableMeta implements ITable {
        public final ISelectable<Long> EMPID = null;
        public final ISelectable<String> FIRST_NAME = null;
        public final ISelectable<String> LAST_NAME = null;
        public final ISelectable<String> DEPTID = null;
    }

    private static final class SingletonDepartmentTableMeta implements ITable {
        public final ISelectable<String> DEPTID = null;
        public final ISelectable<String> DESCR = null;
    }

    private static final class EmployeeTableMeta implements IAliasableTable {
        public final ISelectable<Long> EMPID = null;
        public final ISelectable<String> FIRST_NAME = null;
        public final ISelectable<String> LAST_NAME = null;
        public final ISelectable<String> DEPTID = null;

        private String alias = null;

        public EmployeeTableMeta() {
        }

        public EmployeeTableMeta(final String alias) {
            this.alias = alias;
        }

        // Further covariant return type
        @Override
        public EmployeeTableMeta as(final String alias) {
            this.alias = alias;
            return this;
        }
    }

    private static final class DepartmentTableMeta implements IAliasableTable {
        public final ISelectable<String> DEPTID = null;
        public final ISelectable<String> DESCR = null;

        private String alias = null;

        public DepartmentTableMeta() {
        }

        public DepartmentTableMeta(final String alias) {
            this.alias = alias;
        }

        // Further covariant return type
        @Override
        public DepartmentTableMeta as(final String alias) {
            this.alias = alias;
            return this;
        }
    }
    ////////////////////////////////////////////////////////
}
