package com.halana.service.task;

import com.halana.model.task.Task;
import com.halana.repository.ITaskRepository;
import com.halana.service.comment.ICommentService;
import com.halana.service.file.ITaskFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService{
    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private ITaskFileService taskFileService;

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAllByOrderByPositionAsc();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void remove(Long id) {
        commentService.deleteByTaskId(id);
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAllByStatusIdOrderByPositionAsc(Long statusId) {
        return taskRepository.findAllByStatusIdOrderByPositionAsc(statusId);
    }

    @Override
    public void deleteAllByStatusId(Long id) {
        List<Task> tasks = taskRepository.findAllByStatusIdOrderByPositionAsc(id);
        for (int i = 0; i < tasks.size(); i++) {
            commentService.deleteByTaskId(tasks.get(i).getId());
            taskFileService.deleteByTaskId(tasks.get(i).getId());
        }
        taskRepository.deleteAllByStatusId(id);
    }

    @Override
    public List<Task> findAllByStatusIdAndTitleContainsOrderByPositionAsc(Long statusId, String title) {
        return taskRepository.findAllByStatusIdAndTitleContainsOrderByPositionAsc(statusId, title);
    }
}
