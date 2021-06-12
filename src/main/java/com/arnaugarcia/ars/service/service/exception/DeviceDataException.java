package com.arnaugarcia.ars.service.service.exception;

public class DeviceDataException extends DeviceException {
    public DeviceDataException() {
        super("Data received from device is corrupt");
    }
}
