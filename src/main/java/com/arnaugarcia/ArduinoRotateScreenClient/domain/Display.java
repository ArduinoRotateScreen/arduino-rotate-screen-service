package com.arnaugarcia.ArduinoRotateScreenClient.domain;

import lombok.Builder;

@Builder
public class Display {
    private final String id;
    private final Integer height;
    private final Integer wide;
    private final ScreenOrientation orientation;
    private final Boolean main;
    private final Boolean active;

    public String formattedResolution() {
        return this.height + "x" + this.wide;
    }
}
