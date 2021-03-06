package com.arnaugarcia.ars.service.mapper;

import com.arnaugarcia.ars.service.domain.Device;
import com.fazecast.jSerialComm.SerialPort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeviceMapper extends EntityMapper<SerialPort, Device> {

    @Mapping(target = "port", source = "systemPortName")
    @Mapping(target = "name", source = "systemPortName")
    @Mapping(target = "description", source = "portDescription")
    Device toDTO(SerialPort entity);
}
