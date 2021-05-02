package com.arnaugarcia.ArduinoRotateScreenClient.repository.types;

import com.sun.jna.IntegerType;

public class size_t extends IntegerType {
    private static final int SIZE = 4;

    public size_t() {
        this(0);
    }
    public size_t(long value) {
        super(SIZE, value, false);
    }
}
