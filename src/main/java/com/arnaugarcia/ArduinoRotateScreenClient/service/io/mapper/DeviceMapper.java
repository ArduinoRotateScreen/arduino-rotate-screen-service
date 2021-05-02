package com.arnaugarcia.ArduinoRotateScreenClient.service.io.mapper;

import com.arnaugarcia.ArduinoRotateScreenClient.service.io.model.Device;
import com.fazecast.jSerialComm.SerialPort;
import org.mapstruct.Mapping;

public interface DeviceMapper extends EntityMapper<SerialPort, Device> {

    @Mapping(target = "port", source = "systemPortName")
    @Mapping(target = "name", source = "systemPortName")
    @Mapping(target = "description", source = "portDescription")
    Device toDTO(SerialPort entity);
}
