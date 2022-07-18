package com.codegym.md6casequizz.service.role;

import com.codegym.md6casequizz.model.Role;
import com.codegym.md6casequizz.model.RoleName;


import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
