package com.diosa.repository;


import com.diosa.model.quizz.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {
}
