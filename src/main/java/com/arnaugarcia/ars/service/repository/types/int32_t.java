package com.arnaugarcia.ars.service.repository.types;

import com.sun.jna.IntegerType;

public class int32_t extends IntegerType {
    public static final int SIZE = 4;
    public int32_t() {
        this(0);
    }
    public int32_t(long value) {
        super(SIZE, value, false);
    }
};
