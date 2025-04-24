package com.work.Service;

import com.work.DAO.BoardDAO;
import com.work.DTO.Board;

public class BoardServiceImpl implements BoardService {

    BoardDAO boardDAO = new BoardDAO();

    @Override
    public int insert(Board board) {
        return boardDAO.insert(board);
    }

    @Override
    public Board select(int no) {
        // 게시글 번호 no 를 DB 로 넘겨주고 게시글 정보 요청
		Board board = boardDAO.select(no);
		// 게시글 정보 반환
		return board;
    }
    
}
