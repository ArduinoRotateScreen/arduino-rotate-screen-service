package com.arnaugarcia.ars.service.service;

import com.arnaugarcia.ars.service.domain.Display;
import com.arnaugarcia.ars.service.domain.ScreenRotation;

import java.util.List;

public interface CoreGraphicsService {
    List<Display> findDisplays();

    void rotateScreen(Display display, ScreenRotation rotation);
}
