package com.arnaugarcia.ArduinoRotateScreen.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Device {
    private final String name;
    private final String description;
    private final Integer baudRate;
    private final String port;
}
