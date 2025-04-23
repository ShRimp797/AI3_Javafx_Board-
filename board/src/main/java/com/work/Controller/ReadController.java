package com.work.Controller;

import java.io.IOException;

import com.work.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ReadController {

    @FXML
    private Button btnList;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField content;

    @FXML
    private TextField title;

    @FXML
    private TextField writer;

    @FXML
    void toList(ActionEvent event) throws IOException {
        Main.setRoot("UI/List");
    }   

    @FXML
    void toUpdate(ActionEvent event) throws IOException {
        Main.setRoot("UI/Update");
    }

    @FXML
    void writer(ActionEvent event) {

    }

}
