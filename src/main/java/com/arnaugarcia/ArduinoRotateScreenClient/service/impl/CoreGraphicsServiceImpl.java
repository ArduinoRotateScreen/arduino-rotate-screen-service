package com.arnaugarcia.ArduinoRotateScreenClient.service.impl;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Display;
import com.arnaugarcia.ArduinoRotateScreenClient.domain.ScreenOrientation;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.CoreGraphicsRepository;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGError;
import com.arnaugarcia.ArduinoRotateScreenClient.service.CoreGraphicsService;
import com.arnaugarcia.ArduinoRotateScreenClient.service.exception.EmptyDisplayException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Service
public class CoreGraphicsServiceImpl implements CoreGraphicsService {

    private final Integer MAX_DISPLAYS = 20;

    @Override
    public List<Display> findDisplays() {
        Integer displayCount = 0;
        CGDirectDisplayID[] displayIDS = new CGDirectDisplayID[MAX_DISPLAYS];
        if (!CGError.success.equals(CoreGraphicsRepository.INSTANCE.CGGetOnlineDisplayList(MAX_DISPLAYS, displayIDS, displayCount))) {
            throw new EmptyDisplayException();
        }
        return stream(displayIDS)
                .filter(CGDirectDisplayID::isNotEmpty)
                .map(buildDisplay())
                .collect(toList());
    }

    @Override
    public ScreenOrientation getScreenInformation(Display display) {
        return null;
    }

    private Function<CGDirectDisplayID, Display> buildDisplay() {
        CGDirectDisplayID mainScreen = getMainDisplayID();
        return displayID -> Display.builder()
                .id(displayID.toString())
                .height(CoreGraphicsRepository.INSTANCE.CGDisplayPixelsHigh(displayID).intValue())
                .wide(CoreGraphicsRepository.INSTANCE.CGDisplayPixelsWide(displayID).intValue())
                .main(mainScreen.equals(displayID))
                .build();
    }

    private CGDirectDisplayID getMainDisplayID() {
        return CoreGraphicsRepository.INSTANCE.CGMainDisplayID();
    }
}
