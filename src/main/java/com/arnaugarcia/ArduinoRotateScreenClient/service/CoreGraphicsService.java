package com.arnaugarcia.ArduinoRotateScreenClient.service;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Display;

import java.util.List;

public interface CoreGraphicsService {
    List<Display> findDisplays();

    void rotateScreen(Display display, Integer orientation);
}
