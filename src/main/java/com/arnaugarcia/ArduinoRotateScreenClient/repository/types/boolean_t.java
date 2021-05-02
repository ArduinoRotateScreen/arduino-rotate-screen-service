package com.arnaugarcia.ArduinoRotateScreenClient.repository.types;

import com.sun.jna.IntegerType;

public class boolean_t extends IntegerType {
    private static final int SIZE = 1;


    public boolean_t() {
        this(0);
    }
    public boolean_t(int value) {
        super(SIZE, value, false);
    }

    public Boolean isTrue() {
        return this.intValue() == 1;
    }

    public Boolean isFalse() {
        return this.intValue() == 0;
    }
}
