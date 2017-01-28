package org.fostash.atomic.jdbctojson;

/**
 *
 * Pair class
 */
public final class Pair<L, R> {

    /** l field */
    private final L l;
    /** r field */
    private final R r;

    /**
     * private constructor
     * @param left left value
     * @param right right value
     */
    private Pair(final L left, final R right) {
        this.l = left;
        this.r = right;
    }

    /**
     * static method for create pair
     * @param l left value
     * @param r right value
     * @return a new pair
     */
    public static <L, R> Pair pair(L l, R r) {
        return new Pair<>(l, r);
    }

    /**
     * @return left pair value
     */
    public L getLeft() {
        return l;
    }

    /**
     * @return right pair value
     */
    public R getRight() {
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.l.equals(pairo.getLeft()) &&
                this.r.equals(pairo.getRight());
    }

    @Override
    public int hashCode() {
        return l.hashCode() ^ r.hashCode();
    }
}
