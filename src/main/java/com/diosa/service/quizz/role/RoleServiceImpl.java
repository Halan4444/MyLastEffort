package com.diosa.service.quizz.role;

import com.diosa.model.user.Role;
import com.diosa.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
