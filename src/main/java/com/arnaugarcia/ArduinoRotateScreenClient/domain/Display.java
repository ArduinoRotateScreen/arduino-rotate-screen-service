package com.arnaugarcia.ArduinoRotateScreenClient.domain;

import lombok.Builder;

@Builder
public class Display {
    private final String id;
    private final Integer height;
    private final Integer wide;
    private final Integer orientation;
    private final Boolean main;
    private final Boolean active;

    public String formattedResolution() {
        return this.height + "x" + this.wide;
    }

    @Override
    public String toString() {
        return "Display{" +
                "id='" + id + '\'' +
                ", resolution=" + formattedResolution() +
                ", orientation=" + orientation +
                ", main=" + main +
                ", active=" + active +
                '}';
    }
}
