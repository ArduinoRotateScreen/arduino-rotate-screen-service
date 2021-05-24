package com.arnaugarcia.ars.service.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Device {
    private final String name;
    private final String description;
    private final Integer baudRate;
    private final String port;

    @Override
    public String toString() {
        return name + " (" + port + ")";
    }
}
