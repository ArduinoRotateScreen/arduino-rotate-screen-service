package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public AnchorPane menuFXML;
    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void init(MainController mainController) {
        this.mainController = mainController;
    }
}
