package com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.types;

public class CGError extends int32_t {
    public static final CGError Success = new CGError(0);

    public CGError() { this(0); }
    public CGError(int value) { super(value); }
};
