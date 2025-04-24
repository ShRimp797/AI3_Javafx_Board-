package com.work.Service;

import com.work.DTO.Board;

public interface BoardService {
    
    // 게시글 등록
    public int insert(Board board);
    // 게시글 조회
    public Board select(int no);

}
