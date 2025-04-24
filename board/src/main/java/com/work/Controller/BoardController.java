package com.work.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.work.DAO.BoardDAO;
import com.work.DTO.Board;
import com.work.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BoardController implements Initializable {

    @FXML
    private TableView<Board> board;

    @FXML
    private TableColumn<Board, Integer> no;

    @FXML
    private TableColumn<Board, String> title;

    @FXML
    private TableColumn<Board, String> writer;

    @FXML
    private TableColumn<Board, String> createdAt;

    @FXML
    private TableColumn<Board, String> updatedAt;

    @FXML
    private Button write;

    @FXML
    private Button close;

    @FXML
    private Button delete;

    private BoardDAO boardDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardDAO = new BoardDAO();

        // 테이블 컬럼 매핑
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        writer.setCellValueFactory(new PropertyValueFactory<>("writer"));
        createdAt.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        updatedAt.setCellValueFactory(new PropertyValueFactory<>("updatedAt"));

        // DB에서 게시글 목록 불러오기
        List<Board> boardList = boardDAO.selectAll(); // selectAll 메서드는 DAO에서 작성 필요
        ObservableList<Board> observableList = FXCollections.observableArrayList(boardList);
        board.setItems(observableList);

        // 글쓰기 버튼 클릭 → Insert 페이지로 이동
        write.setOnAction(e -> {
            try {
                Main.setRoot("Insert");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 종료 버튼 클릭 → 애플리케이션 종료
        close.setOnAction(e -> System.exit(0));

        // 삭제 버튼 (구현 예정)
        delete.setOnAction(e -> {
            System.out.println("선택된 게시글 삭제 기능 추가 예정");
        });
    }
}
