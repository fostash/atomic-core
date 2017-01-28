package org.fostash.atomic.jdbctojson;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.fostash.atomic.jdbctojson.Pair.pair;

/**
 *
 */
public class TransformerService {

    static Map<Pair<Class<?>, Class<?>>, TypeTransformer<?, ?>> CONVERSION_REGISTRY;

    static {
        registerConversion(String.class, Long.class, (i, c) -> Long.valueOf(i));
        registerConversion(String.class, Long.TYPE, (i, c) -> Long.valueOf(i));
        registerConversion(String.class, Integer.class, (i, c) -> Integer.valueOf(i));
        registerConversion(String.class, Integer.TYPE, (i, c) -> Integer.valueOf(i));
        registerConversion(String.class, Byte.class, (i, c) -> Byte.valueOf(i));
        registerConversion(String.class, Byte.TYPE, (i, c) -> Byte.valueOf(i));
        registerConversion(String.class, Short.class, (i, c) -> Short.valueOf(i));
        registerConversion(String.class, Short.TYPE, (i, c) -> Short.valueOf(i));
        registerConversion(String.class, Boolean.class, (i, c) -> Transformations.toBoolean(i));
        registerConversion(String.class, Boolean.TYPE, (i, c) -> Transformations.toBoolean(i));
        registerConversion(String.class, Float.class, (i, c) -> Float.valueOf(i));
        registerConversion(String.class, Float.TYPE, (i, c) -> Float.valueOf(i));
        registerConversion(String.class, Double.class, (i, c) -> Double.valueOf(i));
        registerConversion(String.class, Double.TYPE, (i, c) -> Double.valueOf(i));
        registerConversion(String.class, Character.class, (i, c) -> (i!= null) ? i.charAt(0) : (char)(byte)0);
        registerConversion(String.class, Character.TYPE, (i, c) -> (i!= null) ? i.charAt(0) : (char)(byte)0);
        registerConversion(String.class, Double.TYPE, (i, c) -> Double.valueOf(i));
        registerConversion(String.class, BigDecimal.class, (i, c) -> new BigDecimal(i));
        registerConversion(Number.class, Long.class, (instance, c)-> Transformations.toNumber(instance, Long.class));
        registerConversion(Number.class, Long.TYPE, (instance, c)-> Transformations.toNumber(instance, Long.class));
        registerConversion(Number.class, Integer.class, (instance,c )-> Transformations.toNumber(instance, Integer.class));
        registerConversion(Number.class, Integer.TYPE, (instance, c)-> Transformations.toNumber(instance, Integer.class));
        registerConversion(Number.class, Byte.class, (instance, c)-> Transformations.toNumber(instance, Byte.class));
        registerConversion(Number.class, Byte.TYPE, (instance, c)-> Transformations.toNumber(instance, Byte.class));
        registerConversion(Number.class, Short.class, (instance, c)-> Transformations.toNumber(instance, Short.class));
        registerConversion(Number.class, Short.TYPE, (instance, c)-> Transformations.toNumber(instance, Short.class));
        registerConversion(Number.class, Boolean.class, (i, c) -> Transformations.toBoolean(i));
        registerConversion(Number.class, Boolean.TYPE, (i, c) -> Transformations.toBoolean(i));
        registerConversion(Number.class, Float.class, (instance, c)-> Transformations.toNumber(instance, Float.class));
        registerConversion(Number.class, Float.TYPE, (instance, c)-> Transformations.toNumber(instance, Float.class));
        registerConversion(Number.class, Double.class, (instance, c)-> Transformations.toNumber(instance, Double.class));
        registerConversion(Number.class, Double.TYPE, (instance, c)-> Transformations.toNumber(instance, Double.class));
        registerConversion(Number.class, BigDecimal.class, (i, c) -> Transformations.toBigDecimal(i));
        registerConversion(Object.class, String.class, (i, c) -> i.toString());
        registerConversion(Character.class, Boolean.class, (i, c) -> Transformations.toBoolean(i));
        registerConversion(Number.class, Boolean.class, (i, c) -> Transformations.toBoolean(i));
        registerConversion(Date.class, String.class, (i, c) -> Transformations.dateToString(i));
        registerConversion(java.sql.Date.class, String.class, (i, c) -> Transformations.dateToString(i));
        registerConversion(java.sql.Timestamp.class, String.class, (i, c) -> Transformations.dateToString(i));

        registerConversion(JSONObject.class, String.class, JSONObject::getString);
        registerConversion(JSONObject.class, Long.class, JSONObject::getLong);
        registerConversion(JSONObject.class, Integer.class, JSONObject::getInt);
        registerConversion(JSONObject.class, Boolean.class, JSONObject::getBoolean);
        registerConversion(JSONObject.class, BigDecimal.class, JSONObject::getBigDecimal);
        //registerConversion(JsonObject.class, Date.class, jo -> Transformations.stringToDate(jo.getAsString()));
        /*registerConversion(JsonPrimitive.class, String.class, JsonElement::getAsString);
        registerConversion(JsonPrimitive.class, Long.class, JsonElement::getAsLong);
        registerConversion(JsonPrimitive.class, Integer.class, JsonElement::getAsInt);
        registerConversion(JsonPrimitive.class, Boolean.class, JsonElement::getAsBoolean);
        registerConversion(JsonPrimitive.class, BigDecimal.class, JsonElement::getAsBigDecimal);
        registerConversion(JsonPrimitive.class, LocalDate.class, jo -> Transformations.stringToDate(jo.getAsString()));*/
    }

    static Map<Pair<Class<?>, Class<?>>, TypeTransformer<?, ?>> getConversionRegistry() {
        if (CONVERSION_REGISTRY == null) {
            CONVERSION_REGISTRY = new HashMap<>();
        }
        return CONVERSION_REGISTRY;
    }

    public static <S, T> void registerConversion(final Class<S> source,
                                                 final Class<T> target, 
                                                 final TypeTransformer<S, T> transformer) {
        getConversionRegistry().put(pair(source, target), transformer);
    }

    static TypeTransformer resolveTransformer(Class<?> source, Class<?> target) {

        TypeTransformer<?, ?> typeTransformer = findWideningTransformer(source, target);
        if (typeTransformer == null) {
            return (instance, key) -> {
                if (target.isPrimitive()) {
                    try {
                        return target.getField("TYPE").get(null);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    throw new IllegalArgumentException("No Type Transformer registered for " + source.getName() + "->" + target.getName());
                }
            };
        }
        return typeTransformer;
    }

    private static TypeTransformer<?, ?> findWideningTransformer(Class<?> source, Class<?> target) {
        TypeTransformer<?, ?> typeTransformer = getConversionRegistry().get(pair(source, target));
        if (typeTransformer != null) {
            return typeTransformer;
        }

        //do a widening search
        Pair<Class<?>, Class<?>> transformerKey = getConversionRegistry()
                .keySet()
                .stream()
                .filter(key -> {
                    boolean sourceAssignable = key.getLeft().isAssignableFrom(source);
                    boolean targetAssignable = key.getRight().isAssignableFrom(target);
                    return sourceAssignable && targetAssignable;
                })
                .findFirst().orElse(null);
        return getConversionRegistry().get(transformerKey);
    }


    public static <T> T convert(Object instance, String key, Class<T> target) {
        if (instance == null) {
            return null;//throw new IllegalArgumentException("value cannot be null");
        } else if (instance.getClass().getName().equals(target.getName())) {
            return (T) instance;
        } else {
            return (T) resolveTransformer(instance.getClass(), target).transform(instance, key);
        }
    }
}
