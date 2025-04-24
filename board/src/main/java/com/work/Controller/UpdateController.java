package com.work.Controller;

import java.io.IOException;

import com.work.Main;

import com.work.DAO.BoardDAO;

import com.work.DTO.Board;
import com.work.Service.BoardService;
import com.work.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UpdateController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea content;

    @FXML
    private TextField title;

    @FXML
    private TextField writer;

    

   
    int no;
    Board board;
    BoardService boardService;
    
    @FXML
    void initialize() {
        boardService = new BoardServiceImpl();
        // boardService.select(boardNo);
    }

    @FXML
    void toUpdate(ActionEvent event) throws IOException {
        Board board = new Board(title.getText(), writer.getText(), content.getText());
        board.setNo(no); 
        int result = boardService.update(board); 
        if( result > 0 ){
            System.out.println("update data OK!");
            Main.setRoot("UI/list");
        }
    }
    @FXML
    void toDelete(ActionEvent event) throws IOException { 
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Data");
        alert.setHeaderText("Are you sure you want to delete this post? no : " + no);
        alert.setContentText("Once delete, it cannot be undone.");

        int result = 0; 
        if(alert.showAndWait().get() == ButtonType.OK){
            result = boardService.delete(no);
        }
        if( result > 0 ) {
            System.err.println("delete post OK!");
            Main.setRoot("UI/List");   
        }
    }


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
