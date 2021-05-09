package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private HomeController homeController;

    @FXML
    private AboutController aboutController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.homeController.init(this);
        this.aboutController.init(this);
    }

    public void loadScene() {

    }
}
