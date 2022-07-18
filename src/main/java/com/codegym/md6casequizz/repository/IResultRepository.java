package com.codegym.md6casequizz.repository;

import com.codegym.md6casequizz.model.Result;
import com.codegym.md6casequizz.model.Test;
import com.codegym.md6casequizz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result, Long> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);
}
