package com.arnaugarcia.ArduinoRotateScreen.service.exception;

public class EmptyDisplayException extends RuntimeException {
    public EmptyDisplayException() {
        super("No displays has been found in the system");
    }
}
