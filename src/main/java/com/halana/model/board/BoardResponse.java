package com.halana.model.board;

import com.halana.model.status.StatusResponse;
import lombok.Data;

import java.util.Set;


@Data
public class BoardResponse {
    private Long id;

    private String title;

    private Long project;

    private Set<StatusResponse> statuses;
}
