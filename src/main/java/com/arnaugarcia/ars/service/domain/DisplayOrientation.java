package com.arnaugarcia.ars.service.domain;

import java.util.HashMap;
import java.util.Map;

public enum DisplayOrientation {
    HORIZONTAL(0), VERTICAL(90), INVERTED_VERTICAL(180), INVERTED_HORIZONTAL(270);

    private final Integer orientation;
    private static final Map<Integer, DisplayOrientation> map = new HashMap<>();

    DisplayOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Integer getOrientation() {
        return orientation;
    }

    static {
        for (DisplayOrientation displayOrientation : DisplayOrientation.values()) {
            map.put(displayOrientation.orientation, displayOrientation);
        }
    }

    static DisplayOrientation valueOf(Integer orientation) {
        return map.get(orientation);
    }

}
