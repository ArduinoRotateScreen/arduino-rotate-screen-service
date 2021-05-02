package com.arnaugarcia.ArduinoRotateScreenClient;

import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.repository.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.repository.CGError;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.repository.CoreGraphicsRepository;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.repository.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.repository.types.CGError;

public class TestCoreGraphics {
    static final int MAX_DISPLAYS = 20;

    public static void main(String[] args) {
        Integer displayCount = 0;
        CGDirectDisplayID[] displayIDS = new CGDirectDisplayID[MAX_DISPLAYS];
        if (!CGError.Success.equals(CoreGraphicsRepository.INSTANCE.CGGetOnlineDisplayList(MAX_DISPLAYS, displayIDS, displayCount))) {
            System.exit(2);
        }

    }
}
