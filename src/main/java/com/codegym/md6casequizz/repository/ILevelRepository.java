package com.codegym.md6casequizz.repository;

import com.codegym.md6casequizz.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {
}
