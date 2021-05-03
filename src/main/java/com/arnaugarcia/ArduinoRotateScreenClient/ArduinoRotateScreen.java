package com.arnaugarcia.ArduinoRotateScreenClient;

import com.arnaugarcia.ArduinoRotateScreenClient.domain.Display;
import com.arnaugarcia.ArduinoRotateScreenClient.service.CoreGraphicsService;
import com.arnaugarcia.ArduinoRotateScreenClient.service.DeviceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.arnaugarcia.ArduinoRotateScreenClient.domain.ScreenRotation.ROTATE_90;

@SpringBootApplication
public class ArduinoRotateScreen implements CommandLineRunner {

    private final DeviceService deviceService;
    private final CoreGraphicsService coreGraphicsService;

    public ArduinoRotateScreen(DeviceService deviceService, CoreGraphicsService coreGraphicsService) {
        this.deviceService = deviceService;
        this.coreGraphicsService = coreGraphicsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArduinoRotateScreen.class, args);
    }

    @Override
    public void run(String... args) {
        deviceService.getDeviceList();
        final List<Display> displays = coreGraphicsService.findDisplays();
        displays.stream()
                .filter(display -> display.getId().equals(188940595))
                .findFirst()
                .ifPresent(display -> {
                    coreGraphicsService.rotateScreen(display, ROTATE_90);
                    System.out.println(display);
                });
    }
}
