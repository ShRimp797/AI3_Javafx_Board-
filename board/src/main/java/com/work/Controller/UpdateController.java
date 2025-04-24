package com.work.Controller;

import com.work.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;
    
    @FXML
    void toUpdate(ActionEvent event) {
        //Main.setRoot("list");
    }
    @FXML
    void toDelete(ActionEvent event) {
        // Main.setRoot("list");
    }


}
