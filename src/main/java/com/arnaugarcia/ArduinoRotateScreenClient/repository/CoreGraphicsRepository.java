package com.arnaugarcia.ArduinoRotateScreenClient.repository;

import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGError;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.boolean_t;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.size_t;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.mac.CoreFoundation;

public interface CoreGraphicsRepository extends Library {
    CoreGraphicsRepository INSTANCE = Native.load("CoreGraphics", CoreGraphicsRepository.class);

    CoreFoundation.CFArrayRef CGWindowListCopyWindowInfo(int option, int relativeToWindow);

    CGError CGGetOnlineDisplayList(Integer maxDisplays, CGDirectDisplayID[] onlineDisplays, Integer displayCount);

    Double CGDisplayRotation(CGDirectDisplayID displayID);

    size_t CGDisplayPixelsWide(CGDirectDisplayID displayID);

    size_t CGDisplayPixelsHigh(CGDirectDisplayID displayID);

    CGDirectDisplayID CGMainDisplayID();

    boolean_t CGDisplayIsActive(CGDirectDisplayID displayID);
}
