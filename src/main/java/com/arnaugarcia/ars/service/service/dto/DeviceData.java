package com.arnaugarcia.ars.service.service.dto;

import com.arnaugarcia.ars.service.domain.Orientation;
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

    public Optional<Orientation> getOrientation(int threshold) {
        final int deviceValue = (int) (abs(roll));
        return stream(Orientation.values())
                .map(convertByThreshold(threshold, deviceValue))
                .filter(Objects::nonNull)
                .findFirst();
    }

    private Function<Orientation, Orientation> convertByThreshold(int threshold, int deviceValue) {
        return orientation -> {
            final int maxOrientation = orientation.getOrientation() + threshold;
            final int minOrientation = orientation.getOrientation() - threshold;
            if (between(deviceValue, maxOrientation, minOrientation)) {
                return orientation;
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
