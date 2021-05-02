package com.arnaugarcia.ArduinoRotateScreenClient;

import com.arnaugarcia.ArduinoRotateScreenClient.service.CoreGraphicsService;
import com.arnaugarcia.ArduinoRotateScreenClient.service.DeviceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        this.deviceService.getDeviceList();
        this.coreGraphicsService.findDisplays();
    }
}
