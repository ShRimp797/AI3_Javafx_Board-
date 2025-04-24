package com.work.Service;

import java.util.List;

import com.work.DTO.Board;

public interface BoardService {

    // 게시글 목록
    List<Board> list();
    
    // 게시글 등록
    public int insert(Board board);


}
