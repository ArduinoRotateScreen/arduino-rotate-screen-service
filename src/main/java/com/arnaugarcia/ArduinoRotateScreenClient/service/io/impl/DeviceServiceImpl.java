package com.arnaugarcia.ArduinoRotateScreenClient.service.io.impl;

import com.arnaugarcia.ArduinoRotateScreenClient.service.io.DeviceService;
import com.arnaugarcia.ArduinoRotateScreenClient.service.io.model.Device;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Override
    public List<Device> getDeviceList() {
        return stream(SerialPort.getCommPorts())
                .map(toDevice())
                .collect(toList());
    }

    private Function<SerialPort, Device> toDevice() {
        return serialPort -> Device.builder()
                .name(serialPort.getSystemPortName())
                .baudRate(serialPort.getBaudRate())
                .port(serialPort.getSystemPortName())
                .description(serialPort.getPortDescription())
                .build();
    }
}
