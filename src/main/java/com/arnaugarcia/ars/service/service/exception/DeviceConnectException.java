package com.arnaugarcia.ars.service.service.exception;

import com.arnaugarcia.ars.service.domain.Device;

public class DeviceConnectException extends DeviceException {
    public DeviceConnectException(Device device) {
        super("Unable to connect to device (" + device.getPort() + ")");
    }
}
