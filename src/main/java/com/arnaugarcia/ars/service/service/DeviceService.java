package com.arnaugarcia.ars.service.service;

import com.arnaugarcia.ars.service.domain.Device;
import com.fazecast.jSerialComm.SerialPortDataListener;

import java.util.List;

public interface DeviceService {
    List<Device> getDeviceList();

    void attachListener(Device device, SerialPortDataListener listener);

    void removeListener(Device device);
}
