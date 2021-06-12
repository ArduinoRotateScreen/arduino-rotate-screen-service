package com.arnaugarcia.ars.service.service.dto;

import com.arnaugarcia.ars.service.domain.DisplayOrientation;
import com.arnaugarcia.ars.service.service.exception.DeviceDataException;
import lombok.Getter;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static com.arnaugarcia.ars.service.constants.DeviceConstants.PIPE_AND_HASHTAG;
import static java.lang.Double.parseDouble;
import static java.lang.Math.abs;
import static java.util.Arrays.stream;
import static org.springframework.util.ObjectUtils.isEmpty;

@Getter
public class DeviceData {
    private double pitch;
    private double roll;

    public DeviceData(String data) {
        String[] result = data.split(PIPE_AND_HASHTAG);
        try {
            if (!isEmpty(result)) {
                this.pitch = parseDouble(result[0]);
                this.roll = parseDouble(result[1]);
            }
        } catch (NumberFormatException exception) {
            throw new DeviceDataException();
        }

    }

    public Optional<DisplayOrientation> getDisplayOrientation(int threshold) {
        final int deviceValue = (int) (abs(roll));
        return stream(DisplayOrientation.values())
                .map(convertByThreshold(threshold, deviceValue))
                .filter(Objects::nonNull)
                .findFirst();
    }

    private Function<DisplayOrientation, DisplayOrientation> convertByThreshold(int threshold, int deviceValue) {
        return displayOrientation -> {
            final int maxOrientation = displayOrientation.getOrientation() + threshold;
            final int minOrientation = displayOrientation.getOrientation() - threshold;
            if (between(deviceValue, maxOrientation, minOrientation)) {
                return displayOrientation;
            } else {
                return null;
            }
        };
    }

    private boolean between(int value, int max, int min) {
        return value >= min && value <= max;
    }

    @Override
    public String toString() {
        return pitch + "|" + roll + "\n";
    }
}
