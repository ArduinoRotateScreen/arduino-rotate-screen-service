package com.arnaugarcia.ars.service.domain;

import lombok.Getter;

import static java.lang.Double.parseDouble;
import static org.springframework.util.ObjectUtils.isEmpty;

@Getter
public class DeviceData {
    private Double pitch;
    private Double roll;

    public DeviceData(String data) {
        String[] result = data.split("\\|");
        if (!isEmpty(result)) {
          this.pitch = parseDouble(result[0]);
          this.roll = parseDouble(result[1]);
        }
    }
}
