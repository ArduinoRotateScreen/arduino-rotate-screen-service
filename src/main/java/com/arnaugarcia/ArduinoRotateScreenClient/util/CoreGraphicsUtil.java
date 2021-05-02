package com.arnaugarcia.ArduinoRotateScreenClient.util;

import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.boolean_t;

public class CoreGraphicsUtil {
    /*public static <T> Optional<T> wrapError(CGError expression) {
        return Stream.of(expression).map(cgError -> {
            if (cgError == null) {

            }
        });
    }*/

    public static Boolean isTrue(boolean_t value) {
        return value.intValue() == 1;
    }
}
