package com.halana.model.status;

import com.halana.model.Common;
import com.halana.model.board.Board;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Status extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   

    private int position;

    @ManyToOne
    private Board board;
}
