package com.arnaugarcia.ArduinoRotateScreen.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Display {
    private final Integer id;
    private final Integer height;
    private final Integer wide;
    private final Integer orientation;
    private final Boolean main;
    private final Boolean active;

    public String formattedResolution() {
        return this.height + "x" + this.wide;
    }

    public Boolean isMainScreen() {
        return main;
    }

    public Boolean isRotated() {
        return orientation != 0;
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
