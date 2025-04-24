package com.work.Controller;

import java.io.IOException;
import java.util.List;

import com.work.Main;
import com.work.DTO.Board;
import com.work.Service.BoardService;
import com.work.Service.BoardServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListController {

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

    private BoardService boardService;
    
    @FXML
    void insert(ActionEvent event) throws IOException {
        Main.setRoot("UI/Insert");
    }


    @FXML
    public void initialize() {
        boardService = new BoardServiceImpl();

        // 테이블 컬럼 매핑
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        writer.setCellValueFactory(new PropertyValueFactory<>("writer"));
        createdAt.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        updatedAt.setCellValueFactory(new PropertyValueFactory<>("updatedAt"));

        // DB에서 게시글 목록 불러오기
        List<Board> boardList = boardService.list(); // selectAll 메서드는 DAO에서 작성 필요
        ObservableList<Board> observableList = FXCollections.observableArrayList(boardList);
        board.setItems(observableList);

        // 글쓰기 버튼 클릭 → Insert 페이지로 이동
        write.setOnAction(e -> {
            try {
                Main.setRoot("UI/Insert");
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

        board.setOnMouseClicked( new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				// double clicked
				if( event.getClickCount() == 2 && board.getSelectionModel().getSelectedItem() != null ) {
					int boardNo = board.getSelectionModel().getSelectedItem().getNo();
					
					try {
						String fxml = "UI/Read";
						FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
						Parent root = fxmlLoader.load();
						ReadController readController = (ReadController) fxmlLoader.getController();
                        // TODO: ReadContro passData 다 짜면 주석 해제
						// readController.passData(boardNo);
						// Main.setRoot(root);


					} catch (Exception e) {
						System.err.println("List -> Read Error...");
					}
				}
			}
    		
		});


    }
    
}
