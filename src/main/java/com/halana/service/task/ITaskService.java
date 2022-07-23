package com.halana.service.task;

import com.halana.model.task.Task;
import com.halana.service.IBaseService;

import java.util.List;

public interface ITaskService extends IBaseService<Task> {
    List<Task> findAllByStatusIdOrderByPositionAsc(Long statusId);

    void deleteAllByStatusId(Long id);

    List<Task> findAllByStatusIdAndTitleContainsOrderByPositionAsc(Long statusId, String title);
}
