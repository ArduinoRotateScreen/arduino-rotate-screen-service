package com.arnaugarcia.ars.service.service.exception;

public abstract class DeviceException extends RuntimeException {
    public DeviceException(String message) {
        super(message);
    }
}
