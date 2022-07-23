package com.halana.service.board;

import com.halana.model.board.Board;
import com.halana.model.board.BoardResponse;
import com.halana.service.IBaseService;

import java.util.List;

public interface IBoardService extends IBaseService<Board> {
    BoardResponse findBoardById(Long boardId);

    List<Board> findAllByProjectId(Long projectId);

    Board saveBoardResponse(BoardResponse boardResponse, Long projectId);

    BoardResponse findByBoardIdAndTitleTask(Long boardId, String title);
}
