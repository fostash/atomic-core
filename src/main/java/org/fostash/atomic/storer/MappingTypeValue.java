package org.fostash.atomic.storer;

/**
 *
 * Created by Fausto on 04/05/16.
 */
public class MappingTypeValue<T> {

    /** name field. */
    private final String name;
    /** type field. */
    private final Class<T> type;
    /** optional field. */
    private final boolean optional;

    /**
     *
     * @param aName field name
     * @param aType field class type
     * @param isOptional is optional
     */
    public MappingTypeValue(final String aName, final Class<T> aType,
                            final boolean isOptional) {
        this.name = aName;
        this.type = aType;
        this.optional = isOptional;
    }

    /**
     *
     * @param aName field name
     * @param aType field class type
     */
    public MappingTypeValue(final String aName, final Class<T> aType) {
        this(aName, aType, false);
    }

    /**
     * getter for field name.
     * @return name value
     */
    public final String getName() {
        return name;
    }

    /**
     * getter for field type.
     * @return type class
     */
    public final Class<T> getType() {
        return type;
    }

    /**
     * getter method for optional field.
     * @return optional value
     */
    public final boolean isOptional() {
        return this.optional;
    }
}
