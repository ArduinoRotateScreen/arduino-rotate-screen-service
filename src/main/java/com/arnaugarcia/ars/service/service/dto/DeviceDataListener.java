package com.arnaugarcia.ars.service.service.dto;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import static com.fazecast.jSerialComm.SerialPort.LISTENING_EVENT_DATA_AVAILABLE;

public interface DeviceDataListener extends SerialPortDataListener {

    @Override
    default int getListeningEvents() {
        return LISTENING_EVENT_DATA_AVAILABLE;
    }

    void event(DeviceData deviceData);

    @Override
    default void serialEvent(SerialPortEvent event) {
        if (event.getEventType() != LISTENING_EVENT_DATA_AVAILABLE)
            return;
        final SerialPort serialPort = event.getSerialPort();
        byte[] newData = new byte[serialPort.bytesAvailable()];
        serialPort.readBytes(newData, newData.length);
        final String data = new String(newData);
        event(new DeviceData(data));
    }
}
