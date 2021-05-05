package com.arnaugarcia.ArduinoRotateScreen.service;

import com.arnaugarcia.ArduinoRotateScreen.domain.Display;
import com.arnaugarcia.ArduinoRotateScreen.domain.ScreenRotation;

import java.util.List;

public interface CoreGraphicsService {
    List<Display> findDisplays();

    void rotateScreen(Display display, ScreenRotation rotation);
}
