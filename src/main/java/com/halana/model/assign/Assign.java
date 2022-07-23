package com.halana.model.assign;

import com.halana.model.Common;
import com.halana.model.task.Task;
import com.halana.model.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Assign extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;
}
