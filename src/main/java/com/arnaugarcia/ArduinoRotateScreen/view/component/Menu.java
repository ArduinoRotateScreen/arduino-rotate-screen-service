package com.arnaugarcia.ArduinoRotateScreen.view.component;

import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Menu extends Pane {

    private ObservableMap<String, String> routes;

    public Menu() {
        System.out.println(routes);
    }

    public ObservableMap<String, String> getRoutes() {
        return routes;
    }
}
