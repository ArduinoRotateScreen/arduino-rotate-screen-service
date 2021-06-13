package com.arnaugarcia.ars.service.domain;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    HORIZONTAL(0), VERTICAL(90), INVERTED_VERTICAL(180), INVERTED_HORIZONTAL(270);

    private final Integer orientation;
    private static final Map<Integer, Orientation> map = new HashMap<>();

    Orientation(int orientation) {
        this.orientation = orientation;
    }

    public Integer getOrientation() {
        return orientation;
    }

    static {
        for (Orientation orientation : Orientation.values()) {
            map.put(orientation.orientation, orientation);
        }
    }

    static Orientation valueOf(Integer orientation) {
        return map.get(orientation);
    }

}
