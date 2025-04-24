package com.work.Controller;

import java.io.IOException;

import com.work.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    void toList(ActionEvent event) throws IOException {
        Main.setRoot("UI/List");
    }

}