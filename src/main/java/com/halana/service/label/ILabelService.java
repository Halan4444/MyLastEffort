package com.halana.service.label;

import com.halana.model.label.Label;
import com.halana.service.IBaseService;

import java.util.List;

public interface ILabelService extends IBaseService<Label> {
    List<Label> findAllByBoardId(Long id);

    void deleteAllByBoardId(Long id);

    List<Label> findAllByTaskId(Long id);
}
