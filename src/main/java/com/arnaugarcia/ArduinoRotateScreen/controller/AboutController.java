package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {

    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onHomeClick(MouseEvent mouseEvent) {
        //mainController.loadScene(new Scene());
    }

    public void init(MainController mainController) {
        this.mainController = mainController;
    }
}
