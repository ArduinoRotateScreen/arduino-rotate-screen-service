package com.arnaugarcia.ars.service.repository.types;

public class CGError extends int32_t {
    public CGError() { this(0); }
    public CGError(int value) { super(value); }

    public Boolean isError() {
        return this.intValue() != 0;
    }
};
