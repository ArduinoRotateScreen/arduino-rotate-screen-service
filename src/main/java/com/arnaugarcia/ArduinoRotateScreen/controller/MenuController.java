package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    public VBox sidebarMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sidebarMenu.getChildren().forEach(System.out::println);
    }
}
