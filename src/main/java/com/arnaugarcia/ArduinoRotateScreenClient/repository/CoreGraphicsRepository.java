package com.arnaugarcia.ArduinoRotateScreenClient.repository;

import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGError;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.mac.CoreFoundation;

public interface CoreGraphicsRepository extends Library {
    CoreGraphicsRepository INSTANCE = Native.load("CoreGraphics", CoreGraphicsRepository.class);

    CoreFoundation.CFArrayRef CGWindowListCopyWindowInfo(int option, int relativeToWindow);

    CGError CGGetOnlineDisplayList(Integer maxDisplays, CGDirectDisplayID[] onlineDisplays, Integer displayCount);

    Double CGDisplayRotation(CGDirectDisplayID display);
}
