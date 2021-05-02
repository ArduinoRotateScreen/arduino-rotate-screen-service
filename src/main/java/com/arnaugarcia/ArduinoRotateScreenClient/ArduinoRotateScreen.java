package com.arnaugarcia.ArduinoRotateScreenClient;

import com.arnaugarcia.ArduinoRotateScreenClient.service.io.DeviceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArduinoRotateScreen implements CommandLineRunner {

    private final DeviceService deviceService;

    public ArduinoRotateScreen(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArduinoRotateScreen.class, args);
    }

    @Override
    public void run(String... args) {
        this.deviceService.getDeviceList();
    }
}
