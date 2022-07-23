package com.halana.service.project;

import com.halana.model.project.Project;
import com.halana.model.project.ProjectResponse;
import com.halana.model.user.User;
import com.halana.service.IBaseService;

import java.util.List;

public interface IProjectService extends IBaseService<Project> {
    List<Project> findProjectByUserId(Long userId);

    ProjectResponse findProjectById(Long id);

    List<Project> findProjectByProjectOwner(User user);


}
