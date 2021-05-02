package com.arnaugarcia.ArduinoRotateScreenClient.service.impl;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Display;
import com.arnaugarcia.ArduinoRotateScreenClient.domain.ScreenOrientation;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.CoreGraphicsRepository;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGDirectDisplayID;
import com.arnaugarcia.ArduinoRotateScreenClient.repository.types.CGError;
import com.arnaugarcia.ArduinoRotateScreenClient.service.CoreGraphicsService;
import com.arnaugarcia.ArduinoRotateScreenClient.service.exception.EmptyDisplayException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return new ArrayList<>();
    }

    @Override
    public ScreenOrientation getScreenOrientation(Display display) {
        return null;
    }
}
