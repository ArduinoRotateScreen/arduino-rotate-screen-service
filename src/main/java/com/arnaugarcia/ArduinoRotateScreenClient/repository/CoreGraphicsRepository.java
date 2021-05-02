package com.arnaugarcia.ArduinoRotateScreenClient.repository;

import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.*;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.IOKit;

public interface CoreGraphicsRepository extends Library {
    CoreGraphicsRepository INSTANCE = Native.load("CoreGraphics", CoreGraphicsRepository.class);

    CGError CGGetOnlineDisplayList(Integer maxDisplays, CGDirectDisplayID[] onlineDisplays, Integer displayCount);

    Double CGDisplayRotation(CGDirectDisplayID displayID);

    size_t CGDisplayPixelsWide(CGDirectDisplayID displayID);

    size_t CGDisplayPixelsHigh(CGDirectDisplayID displayID);

    CGDirectDisplayID CGMainDisplayID();

    boolean_t CGDisplayIsActive(CGDirectDisplayID displayID);

    IOKit.IOService CGDisplayIOServicePort(CGDirectDisplayID displayID);

    kern_return_t IOServiceRequestProbe(IOKit.IOService service, int32_t options);
}
