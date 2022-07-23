package com.halana.service.status;

import com.halana.model.status.Status;
import com.halana.model.status.StatusResponse;
import com.halana.service.IBaseService;

import java.util.List;

public interface IStatusService extends IBaseService<Status> {

    List<Status> findAllByBoardIdOrderByPositionAsc(Long id);

    List<StatusResponse> findByBoardId(Long id);

    List<StatusResponse> findByBoardIdAndTitleTask(Long id, String title);

    void deleteAllByBoardId(Long boardId);

    Status saveStatusResponse(StatusResponse statusResponse, Long boardId);
}
