package com.nexusy.mina.serializer;

/**
 * @author lan
 * @since 2016-04-01
 */
public class SerializerFactory {

    public static <T> Serializer<T> createSerializer(int type) {
        if (type == 0) {
            return new JsonSerializer<>();
        } else if (type == 1) {
            return new AvroSerializer<>();
        }
        return new JsonSerializer<>();
    }
}
