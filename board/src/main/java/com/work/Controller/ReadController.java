package com.work.Controller;

import java.io.IOException;

import com.work.Main;
import com.work.DTO.Board;
import com.work.Service.BoardService;
import com.work.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
        board = boardService.select(no);
        title.setText(board.getTitle());
        writer.setText(board.getWriter());
        content.setText(board.getContent());

    }

    @FXML
    void toList(ActionEvent event) throws IOException {
        Main.setRoot("UI/List");
    }   

    @FXML
    void toUpdate(ActionEvent event) throws Exception {
        // Main.setRoot("UI/Update");
        String fxml = "UI/Update";
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        UpdateController updateController = (UpdateController) fxmlLoader.getController();
        
        updateController.passData(no);
            Main.setRoot(root);


    }

    @FXML
    void writer(ActionEvent event) {

    }

    // public void passData(int boardNo) {
    //     // TODO :
    //     // board = boardService.select(no);
    //     title.setText(board.getTitle());
    //     writer.setText(board.getWriter());
    //     content.setText(board.getContent());
    // }




     /**
     * ⭐ 데이터 전달 받기
     * 게시글 번호를 전달받아 게시글 정보를 조회하여 화면에 표시
     * @param boardNo
     */
    public void passData(int boardNo) {

        no = boardNo;
        board = boardService.select(no);
        title.setText(board.getTitle());
        writer.setText(board.getWriter());
        content.setText(board.getContent());

    }
}
