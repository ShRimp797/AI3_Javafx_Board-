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
    public int update(Board board) {
        return boardDAO.update(board); 
    }

    // @Override
    // public int delete(int no){ 
    //     int result = boardDAO.delete(no); 
    //     if (result > 0) System.out.println("delete data succeeded");
    //     else System.err.println("delete data failed");
    //     return result; 
    // }
    
}
