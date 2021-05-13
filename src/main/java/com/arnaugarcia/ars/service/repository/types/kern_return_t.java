package com.arnaugarcia.ars.service.repository.types;

import com.sun.jna.IntegerType;

public class kern_return_t extends IntegerType {
    public static final int SIZE = 4;
    public kern_return_t() {
        this(0);
    }
    public kern_return_t(long value) {
        super(SIZE, value, false);
    }
};
