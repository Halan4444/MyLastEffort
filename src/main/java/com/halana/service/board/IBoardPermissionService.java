package com.halana.service.board;

import com.halana.model.permission.BoardPermission;
import com.halana.service.IBaseService;

public interface IBoardPermissionService extends IBaseService<BoardPermission> {
    BoardPermission findByUserIdAndBoardId(Long userId, Long boardId);

    void deleteByUserIdAndBoardId(Long userId, Long boardId);

}
