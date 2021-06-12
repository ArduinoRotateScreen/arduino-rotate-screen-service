package com.arnaugarcia.ars.service.domain;

public enum DisplayRotation {

    ROTATE_0(1024), // (1024 | 0) * 2^16
    ROTATE_90(3146752), // (1024 | 48) * 2^16
    ROTATE_180(6292480), // (1024 | 96) * 2^16
    ROTATE_270(5243904); // (1024 | 80) * 2^16

    private final Integer value;

    DisplayRotation(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
