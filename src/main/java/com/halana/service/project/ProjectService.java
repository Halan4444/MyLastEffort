package com.halana.service.project;

import com.halana.model.board.Board;
import com.halana.model.project.Project;
import com.halana.model.project.ProjectResponse;
import com.halana.model.user.User;
import com.halana.repository.IProjectRepository;
import com.halana.service.board.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService{
    @Autowired
    private IBoardService boardService;

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void remove(Long id) {
        List<Board> boards = boardService.findAllByProjectId(id);
        for (Board board : boards) {
            boardService.remove(board.getId());
        }
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findProjectByUserId(Long userId) {
        return projectRepository.findProjectByUserId(userId);
    }

    @Override
    public ProjectResponse findProjectById(Long id) {
        Project project = projectRepository.findById(id).get();
        return convertProjectToProjectResponse(project);
    }

    private ProjectResponse convertProjectToProjectResponse (Project project) {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setId(project.getId());
        projectResponse.setTitle(project.getTitle());
        projectResponse.setProjectOwner(project.getProjectOwner());
        projectResponse.setUsers(project.getUsers());
        projectResponse.setBoards(boardService.findAllByProjectId(project.getId()));
        return projectResponse;
    }

    @Override
    public List<Project> findProjectByProjectOwner(User user) {
        return projectRepository.findAllByProjectOwner(user);
    }

}
