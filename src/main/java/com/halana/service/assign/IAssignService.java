package com.halana.service.assign;

import com.halana.model.assign.Assign;
import com.halana.service.IBaseService;

public interface IAssignService extends IBaseService<Assign> {
    void deleteAssign(Long userId, Long taskId);

}
