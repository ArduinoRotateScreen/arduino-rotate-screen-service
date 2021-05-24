package com.arnaugarcia.ars.service.service.impl;

import com.arnaugarcia.ars.service.domain.Device;
import com.arnaugarcia.ars.service.mapper.DeviceMapper;
import com.arnaugarcia.ars.service.service.DeviceService;
import com.arnaugarcia.ars.service.service.exception.DeviceConnectException;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class DeviceServiceImpl implements DeviceService {

    private final DeviceMapper deviceMapper;

    public DeviceServiceImpl(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<Device> getDeviceList() {
        return stream(SerialPort.getCommPorts())
                .map(deviceMapper::toDTO)
                .collect(toList());
    }

    public void attachListener(Device device, SerialPortDataListener listener) {
        final SerialPort commPort = getSerialPort(device);
        commPort.addDataListener(listener);
        final boolean isOpen = commPort.openPort();
        if (!isOpen) {
            throw new DeviceConnectException(device);
        }
    }

    @Override
    public void removeListener(Device device) {
        final SerialPort serialPort = getSerialPort(device);
        serialPort.removeDataListener();
    }

    private SerialPort getSerialPort(Device device) {
        return SerialPort.getCommPort(device.getPort());
    }
}
