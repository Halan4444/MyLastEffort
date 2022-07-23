package com.halana.model.project;

import com.halana.model.board.Board;
import com.halana.model.user.User;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProjectResponse {
    private Long id;

    private String title;

    private Long type;

    private User projectOwner;

    private Set<User> users;

    private List<Board> boards;
}
