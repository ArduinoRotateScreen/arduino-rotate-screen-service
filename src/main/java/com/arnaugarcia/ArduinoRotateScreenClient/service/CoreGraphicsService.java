package com.arnaugarcia.ArduinoRotateScreenClient.service;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Display;
import com.arnaugarcia.ArduinoRotateScreenClient.domain.ScreenRotation;

import java.util.List;

public interface CoreGraphicsService {
    List<Display> findDisplays();

    void rotateScreen(Display display, ScreenRotation rotation);
}
