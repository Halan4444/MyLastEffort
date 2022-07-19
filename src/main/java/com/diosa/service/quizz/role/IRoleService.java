package com.diosa.service.quizz.role;



import com.diosa.model.user.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);

}
