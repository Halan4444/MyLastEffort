package com.halana.repository;


import com.halana.model.quizz.Result;
import com.halana.model.quizz.Test;
import com.halana.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result, Long> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);
}
