package org.fostash.atomic.storer;

import org.fostash.atomic.dsl.*;
import org.fostash.atomic.dsl.exception.SqlBuilderException;
import org.fostash.atomic.jdbctojson.DBFactoryPool;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 *
 * Created by Fausto on 18/05/16.
 */
public class StorerTest {

    @BeforeClass
    public static void setUp() throws Exception {

        DBFactoryPool.setupDriver(() -> new HashMap<DBFactoryPool.SetupInformation.Keys, String>() {
            { put(DBFactoryPool.SetupInformation.Keys.DRIVER, "org.h2.jdbcx.JdbcDataSource"); }
            { put(DBFactoryPool.SetupInformation.Keys.URL, "jdbc:h2:mem:Storer;MODE=MySQL;DB_CLOSE_ON_EXIT=TRUE;"); }
            { put(DBFactoryPool.SetupInformation.Keys.USER, "sa"); }
            { put(DBFactoryPool.SetupInformation.Keys.PASSWORD, ""); }
            { put(DBFactoryPool.SetupInformation.Keys.POOLNAME, "h2"); }
        });

        Storer.processStatement(new ISql() {
            @Override
            public String toString() {
                return "CREATE TABLE t1 (clm1 integer, clm2 integer, clm3 clob);";
            }
        }, (p) -> {
            final JSONObject JSONObject = new JSONObject();
            JSONObject.put("execute", p.execute());
            final Optional<JSONObject> j = Optional.of(JSONObject);
            return j;
        });
    }

    Function<Integer, IInsert> t = v -> new IInsert() {
        @Override
        public IInsert into(IFrom.ITable table, ISelect.IColumn... columns) {
            return null;
        }

        @Override
        public IInsert values(Object... objects) {
            return null;
        }

        @Override
        public String toString() {
            return "insert into t1 (clm1, clm2) values (" + v + "," + v + ")";
        }
    };

    Function<Long, ISql> t1 = v -> new ISql() {
        @Override
        public String toString() {
            return "select * from t1 where clm1 = " + v;
        }
    };

    @Test
    public void testCreate() {

        //JSONObject apply = t.andThen(Storer::create).andThen(t1).andThen(Storer::singleResult).apply(1);
    }

    @Test
    public void testRead() throws Exception {
        List<String> read = Storer.read(new ISql() {
            @Override
            public String toString() {
                return "select * from t1 where clm1 = 1";
            }
        }, JSONObject::toString);
        System.out.println(read);
    }

    @Test
    public void testWriteClob() throws Exception {
        Storer.create(t.apply(1)).get();
        System.out.println(
        Storer.writeClob("test", new IFrom.ITable() {
            @Override
            public IFrom.IJoin innerJoin(String name, String alias) {
                return null;
            }

            @Override
            public IFrom.IJoin leftJoin(String name, String alias) {
                return null;
            }

            @Override
            public IFrom.IJoin rightJoin(String name, String alias) {
                return null;
            }

            @Override
            public String toString() {
                return "t1";
            }
        }, new ISelect.IColumn() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getAlias() {
                return null;
            }

            @Override
            public String getFunction() {
                return null;
            }

            @Override
            public String build() throws SqlBuilderException {
                return null;
            }

            @Override
            public String toString() {
                return "clm3";
            }
        }, new IWhere() {
            @Override
            public ICondition where() {
                return null;
            }

            @Override
            public ISql orderBy(ISelect.IColumn... c) {
                return null;
            }

            @Override
            public String toString() {
                return " clm1 = 1";
            }
        }).get().getSubString(1, 4)
        );
    }
}