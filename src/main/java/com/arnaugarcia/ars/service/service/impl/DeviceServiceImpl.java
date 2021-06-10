package com.arnaugarcia.ars.service.service.impl;

import com.arnaugarcia.ars.service.domain.Device;
import com.arnaugarcia.ars.service.mapper.DeviceMapper;
import com.arnaugarcia.ars.service.service.DeviceService;
import com.arnaugarcia.ars.service.service.exception.DeviceConnectException;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class DeviceServiceImpl implements DeviceService {

    private final Logger logger = LoggerFactory.getLogger(DeviceService.class);
    private final DeviceMapper deviceMapper;

    public DeviceServiceImpl(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<Device> getDeviceList() {
        logger.info("Getting all system devices");
        return stream(SerialPort.getCommPorts())
                .map(deviceMapper::toDTO)
                .collect(toList());
    }

    @Override
    public Optional<Device> findDeviceByPort(String port) {
        logger.info("Getting system device by port {}", port);
        return getDeviceList().stream()
                .filter(device -> device.getPort().equals(port))
                .findFirst();
    }

    @Override
    public void attachListener(Device device, SerialPortDataListener listener) {
        logger.info("Attaching listener to device with port {}", device.getPort());
        final SerialPort commPort = getSerialPort(device);
        commPort.addDataListener(listener);
        final boolean isOpen = commPort.openPort();
        if (!isOpen) {
            throw new DeviceConnectException(device);
        }
    }

    @Override
    public void removeListener(Device device) {
        logger.info("Removing listener to device with port {}", device.getPort());
        final SerialPort serialPort = getSerialPort(device);
        serialPort.removeDataListener();
    }

    private SerialPort getSerialPort(Device device) {
        return SerialPort.getCommPort(device.getPort());
    }
}
