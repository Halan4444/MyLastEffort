package com.diosa.repository;


import com.diosa.model.quizz.Result;
import com.diosa.model.quizz.Test;
import com.diosa.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result, Long> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);
}
