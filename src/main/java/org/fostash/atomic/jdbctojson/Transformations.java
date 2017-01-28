package org.fostash.atomic.jdbctojson;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * A Utility class for various type transformations
 */
public class Transformations {

    static boolean toBoolean(String name, Optional<Object> val) {
        return (boolean) val.map(o -> {
            if ((o instanceof Boolean) || (o.getClass().isAssignableFrom(Boolean.TYPE))) {
                return o;
            } else {
                boolean isAllowedType = o instanceof Character;
                isAllowedType |= o.getClass().isAssignableFrom(Character.TYPE);
                isAllowedType |= o instanceof String;
                isAllowedType |= o instanceof Integer;
                isAllowedType |= o.getClass().isAssignableFrom(Integer.TYPE);
                isAllowedType |= o instanceof Long;
                isAllowedType |= o.getClass().isAssignableFrom(Long.TYPE);

                if (!isAllowedType) {
                    throw new IllegalArgumentException("name cannot be converted to boolean as it is a " + val.get().getClass());
                }

                return o.toString().equalsIgnoreCase("1") ||
                        o.toString().equalsIgnoreCase("yes") ||
                        o.toString().equalsIgnoreCase("true") ||
                        o.toString().equalsIgnoreCase("y");

            }
        }).orElse(false);
    }

    public static <T extends Number> T toNumber(Number number, Class<T> target) {
        if (number == null) {
            return null;
        }
        try {
            return target.getConstructor(String.class).newInstance(number.toString());
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }

    public static BigDecimal toBigDecimal(Number number) {
        if (number == null) {
            return null;
        }
        return new BigDecimal(number.toString());
    }

    public static Boolean toBoolean(String o) {
        return o != null && (o.equalsIgnoreCase("1") || o.equalsIgnoreCase("yes")
                || o.equalsIgnoreCase("true") || o.equalsIgnoreCase("y"));

    }

    public static Boolean toBoolean(Character o) {
        return o != null && (o == '1' || o == 'y' || o == 'Y');
    }

    public static Boolean toBoolean(Number o) {
        return o != null && o.intValue() == 1;
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(final Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static LocalDate stringToDate(final String date) {
        return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    }
}
