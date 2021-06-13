package com.arnaugarcia.ars.service.service;

import com.arnaugarcia.ars.service.domain.Display;
import com.arnaugarcia.ars.service.domain.DisplayRotation;

import java.util.List;
import java.util.Optional;

public interface DisplayService {
    List<Display> findDisplays();

    void rotateDisplay(Display display, DisplayRotation rotation);

    Optional<Display> findById(String displayId);
}
