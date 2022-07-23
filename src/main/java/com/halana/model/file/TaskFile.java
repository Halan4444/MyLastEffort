package com.halana.model.file;

import com.halana.model.Common;
import com.halana.model.task.Task;
import com.halana.model.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaskFile extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;
}
