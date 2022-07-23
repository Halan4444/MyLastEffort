package com.halana.model.status;

import com.halana.model.task.Task;
import lombok.Data;

import java.util.List;

@Data
public class StatusResponse {
    private Long id;

    private String title;

    private int position;

    private List<Task> tasks;
}
