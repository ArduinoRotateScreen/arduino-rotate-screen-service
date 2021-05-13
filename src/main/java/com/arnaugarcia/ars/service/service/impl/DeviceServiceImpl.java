package com.arnaugarcia.ars.service.service.impl;

import com.arnaugarcia.ars.service.domain.Device;
import com.arnaugarcia.ars.service.mapper.DeviceMapper;
import com.arnaugarcia.ars.service.service.DeviceService;
import com.fazecast.jSerialComm.SerialPort;

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
}
