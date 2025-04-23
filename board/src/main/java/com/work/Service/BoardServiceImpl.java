package com.work.Service;

import com.work.DAO.BoardDAO;
import com.work.DTO.Board;

public class BoardServiceImpl implements BoardService {

    BoardDAO boardDAO = new BoardDAO();

    @Override
    public int insert(Board board) {
        return boardDAO.insert(board);
    }
    
}
