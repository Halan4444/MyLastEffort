package com.halana.service.quizz.role;



import com.halana.model.user.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);

}
