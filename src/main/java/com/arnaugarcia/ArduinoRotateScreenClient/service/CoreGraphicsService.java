package com.arnaugarcia.ArduinoRotateScreenClient.service;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Display;
import com.arnaugarcia.ArduinoRotateScreenClient.domain.ScreenOrientation;

import java.util.List;

public interface CoreGraphicsService {

    List<Display> findDisplays();

    ScreenOrientation getScreenOrientation(Display display);
}
