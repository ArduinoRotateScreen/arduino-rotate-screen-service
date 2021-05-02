package com.arnaugarcia.ArduinoRotateScreenClient.service.impl;

import com.arnaugarcia.ArduinoRotateScreenClient.service.DeviceService;
import com.arnaugarcia.ArduinoRotateScreenClient.mapper.DeviceMapper;
import com.arnaugarcia.ArduinoRotateScreenClient.domain.Device;
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
