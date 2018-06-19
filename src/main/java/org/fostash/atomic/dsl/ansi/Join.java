package org.fostash.atomic.dsl.ansi;

import org.fostash.atomic.metamodel.TableMeta;

public class Join extends From {

    private final From other;
    private final JoinType type;

    protected Join(final TableMeta left, final TableMeta right, final JoinType type) {
        super(left);
        this.other = From.of(right);
        this.type = type;
    }

    public static Join of(final TableMeta left, final TableMeta right, final JoinType type) {
        return new Join(left, right, type);
    }

    @Override
    public String getRepresentation() {
        return String.format(type.value(), super.getRepresentation(), other.getRepresentation());
    }

    public enum JoinType {
        /** inner join type. */
        INNER {
            @Override
            public String value() {
                return "%s INNER JOIN %s";
            }
        },
        /** left outer join type. */
        LEFT {
            @Override
            public String value() {
                return "%s LEFT OUTER JOIN %s";
            }
        },
        /** right outer join type. */
        RIGHT {
            @Override
            public String value() {
                return "%s RIGHT OUTER JOIN %s";
            }
        },
        CROSS {
            @Override
            public String value() {
                return "%s CROSS JOIN %s";
            }
        };

        /**
         * @return join type value.
         */
        public abstract String value();
    }
}
