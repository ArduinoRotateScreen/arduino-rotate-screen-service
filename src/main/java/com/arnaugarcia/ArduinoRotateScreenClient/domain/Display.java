package com.arnaugarcia.ArduinoRotateScreenClient.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Display {
    private final String id;
    private final String resolution;
    private final ScreenOrientation orientation;
    private final Boolean main;
    private final Boolean active;
}
