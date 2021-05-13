package com.arnaugarcia.ars.service.repository.types;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CGDirectDisplayID extends int32_t {

    public CGDirectDisplayID(int value) {
        super(value);
    }

    public Boolean isEmpty() {
        return this.intValue() == 0;
    }

    public Boolean isNotEmpty() {
        return this.intValue() != 0;
    }
}
