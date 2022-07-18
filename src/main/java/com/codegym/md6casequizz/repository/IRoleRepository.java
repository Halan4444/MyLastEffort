package com.codegym.md6casequizz.repository;

import com.codegym.md6casequizz.model.Role;
import com.codegym.md6casequizz.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}
