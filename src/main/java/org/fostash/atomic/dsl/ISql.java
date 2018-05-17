package org.fostash.atomic.dsl;

/**
 *
 * Created by Fausto on 25/04/16.
 */
public interface ISql {

    /** Structure for sql string with bind parameter */
    SqlStructure build();
}
