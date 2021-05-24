package com.arnaugarcia.ars.service.domain;

import lombok.Builder;
import lombok.Getter;

import static com.arnaugarcia.ars.service.domain.DisplayOrientation.HORIZONTAL;

@Getter
public class Display {
    private final Integer id;
    private final Integer height;
    private final Integer wide;
    private final DisplayOrientation orientation;
    private final Boolean main;
    private final Boolean active;

    @Builder
    public Display(Integer id,
                   Integer height,
                   Integer wide,
                   Integer orientation,
                   Boolean main,
                   Boolean active) {
        this.id = id;
        this.height = height;
        this.wide = wide;
        this.orientation =  DisplayOrientation.valueOf(orientation);
        this.main = main;
        this.active = active;
    }

    public String formattedResolution() {
        return this.height + "x" + this.wide;
    }

    public Boolean isMainScreen() {
        return main;
    }

    public Boolean isRotated() {
        return orientation != HORIZONTAL;
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
