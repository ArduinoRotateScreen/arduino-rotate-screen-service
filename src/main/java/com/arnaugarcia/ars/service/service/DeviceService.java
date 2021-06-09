package com.arnaugarcia.ars.service.service;

import com.arnaugarcia.ars.service.domain.Device;
import com.fazecast.jSerialComm.SerialPortDataListener;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> getDeviceList();

    Optional<Device> findDeviceByPort(String port);

    void attachListener(Device device, SerialPortDataListener listener);

    void removeListener(Device device);
}
