package com.halana.model.task;

import com.halana.model.Common;
import com.halana.model.label.Label;
import com.halana.model.status.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Task extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String deadline;

    private String image;

    private int position;

    @ManyToOne
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Label> labels;
}
