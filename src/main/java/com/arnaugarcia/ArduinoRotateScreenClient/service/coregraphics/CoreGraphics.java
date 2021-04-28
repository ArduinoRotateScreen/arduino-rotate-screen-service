package com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics;

import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.service.coregraphics.types.CGError;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.mac.CoreFoundation;

public interface CoreGraphics extends Library {
    CoreGraphics INSTANCE = Native.load("CoreGraphics", CoreGraphics.class);

    CoreFoundation.CFArrayRef CGWindowListCopyWindowInfo(int option, int relativeToWindow);

    CGError CGGetOnlineDisplayList(Integer maxDisplays, CGDirectDisplayID[] onlineDisplays, Integer displayCount);
}
