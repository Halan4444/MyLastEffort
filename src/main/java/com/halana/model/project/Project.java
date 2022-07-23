package com.halana.model.project;

import com.halana.model.Common;
import com.halana.model.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
public class Project extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private Long type;

    @ManyToOne
    private User projectOwner;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;
}
