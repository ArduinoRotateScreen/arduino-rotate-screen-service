package com.arnaugarcia.ArduinoRotateScreenClient.domain;

public enum ScreenOrientation {

    STANDARD(0), VERTICAL_CLOCKWISE(90), VERTICAL_ANTI_CLOCKWISE(270), INVERTED(180);

    private final Integer orientation;

    ScreenOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Integer getOrientation() {
        return orientation;
    }
}
