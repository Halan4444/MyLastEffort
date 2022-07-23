package com.halana.service.file;

import com.halana.model.file.TaskFile;
import com.halana.service.IBaseService;

import java.util.List;

public interface ITaskFileService extends IBaseService<TaskFile> {
    List<TaskFile> findAllByTaskId(Long taskId);

    void deleteByTaskId(Long id);

}
