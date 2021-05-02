package com.arnaugarcia.ArduinoRotateScreenClient.repository.types;

public class CGDirectDisplayID extends int32_t {
    public Boolean isEmpty() {
        return this.intValue() == 0;
    }

    public Boolean isNotEmpty() {
        return this.intValue() != 0;
    }
}
