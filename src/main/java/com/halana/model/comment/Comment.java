package com.halana.model.comment;

import com.halana.model.Common;
import com.halana.model.task.Task;
import com.halana.model.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String date;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Task task;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;
}
