package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    public Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Home controller");
        label.setText("Hello from Home Controller");
    }
}
