package com.arnaugarcia.ArduinoRotateScreen.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public VBox sidebarMenu;
    public SubScene content;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sidebarMenu.getChildren().forEach(System.out::println);
    }

    public void onHomeClick(MouseEvent mouseEvent) {
        System.out.println("Home button clicked!");
    }
}
