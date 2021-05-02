package com.arnaugarcia.ArduinoRotateScreenClient.repository.types;

public enum ScalerFlags {
    kIOScaleStretchToFit(0x00000001),

    kIOScaleRotateFlags(0x000000f0),

    kIOScaleSwapAxes(0x00000010),
    kIOScaleInvertX(0x00000020),
    kIOScaleInvertY(0x00000040);


    ScalerFlags(int i) {

    }
}
