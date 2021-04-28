package com.arnaugarcia.ArduinoRotateScreenClient;

import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.CoreGraphics;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.types.CGError;

public class ArduinoRotateScreen {
    static final int MAX_DISPLAYS = 20;

    public static void main(String[] args) {
        Integer displayCount = 0;
        CGDirectDisplayID[] displayIDS = new CGDirectDisplayID[MAX_DISPLAYS];
        if (!CGError.Success.equals(CoreGraphics.INSTANCE.CGGetOnlineDisplayList(MAX_DISPLAYS, displayIDS, displayCount))) {
            System.exit(2);
        }

    }
}
