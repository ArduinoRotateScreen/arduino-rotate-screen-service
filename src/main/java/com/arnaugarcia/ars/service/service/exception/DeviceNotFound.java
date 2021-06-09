package com.arnaugarcia.ars.service.service.exception;

import java.util.function.Supplier;

public class DeviceNotFound extends DeviceException {
    public DeviceNotFound(String port) {
        super("Device with port " + port + " not found.");
    }
}
