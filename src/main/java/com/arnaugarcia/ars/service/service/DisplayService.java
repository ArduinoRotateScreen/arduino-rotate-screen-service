package com.arnaugarcia.ars.service.service;

import com.arnaugarcia.ars.service.domain.Display;
import com.arnaugarcia.ars.service.domain.DisplayRotation;

import java.util.List;

public interface DisplayService {
    List<Display> findDisplays();

    void rotateDisplay(Display display, DisplayRotation rotation);
}
