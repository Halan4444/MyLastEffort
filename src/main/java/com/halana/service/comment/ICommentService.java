package com.halana.service.comment;

import com.halana.model.comment.Comment;
import com.halana.service.IBaseService;

import java.util.List;

public interface ICommentService extends IBaseService<Comment> {
    List<Comment> findAllByTaskId(Long TaskId);

    void deleteByTaskId(Long id);
}



