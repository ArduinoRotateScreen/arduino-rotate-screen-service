package com.arnaugarcia.ArduinoRotateScreen.service.impl;

import com.arnaugarcia.ArduinoRotateScreen.service.DeviceService;
import com.arnaugarcia.ArduinoRotateScreen.mapper.DeviceMapper;
import com.arnaugarcia.ArduinoRotateScreen.domain.Device;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Service
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
