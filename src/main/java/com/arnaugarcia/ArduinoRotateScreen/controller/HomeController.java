package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label applicationTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applicationTitle.setText("Hello from controller");
    }
}
