package com.codegym.md6casequizz.service.role;

import com.codegym.md6casequizz.model.Role;
import com.codegym.md6casequizz.model.RoleName;
import com.codegym.md6casequizz.repository.IRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
