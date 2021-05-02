package com.arnaugarcia.ArduinoRotateScreenClient.service;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Device;
import com.arnaugarcia.ArduinoRotateScreenClient.domain.ScreenOrientation;

import java.util.List;

public interface DeviceService {
    List<Device> getDeviceList();
}
