package com.halana.model.label;

import com.halana.model.board.Board;
import com.halana.model.color.Color;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private Board board;

    @OneToOne
    private Color color;
}
