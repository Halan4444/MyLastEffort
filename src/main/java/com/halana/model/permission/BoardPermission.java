package com.halana.model.permission;

import com.halana.model.board.Board;
import com.halana.model.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BoardPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Board board;

    @ManyToOne
    private Permission permission;
}
