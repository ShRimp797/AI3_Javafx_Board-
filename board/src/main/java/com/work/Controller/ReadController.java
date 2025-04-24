package com.work.Controller;

import java.io.IOException;

import com.work.Main;
import com.work.DTO.Board;
import com.work.Service.BoardService;
import com.work.Service.BoardServiceImpl;

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

    int no;
    Board board;
    BoardService boardService;

    @FXML
    public void initialize() {
        boardService = new BoardServiceImpl();
    }

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

    public void passData(int boardNo) {
        // TODO :
        // board = boardService.select(no);
        title.setText(board.getTitle());
        writer.setText(board.getWriter());
        content.setText(board.getContent());
    }

}
