package com.codegym.md6casequizz.service.test;

import com.codegym.md6casequizz.model.Level;
import com.codegym.md6casequizz.model.Question;
import com.codegym.md6casequizz.model.Test;
import com.codegym.md6casequizz.model.User;
import com.codegym.md6casequizz.service.IGeneralService;

public interface ITestService extends IGeneralService<Test> {
    Iterable<Test> findAllByUser (User user);
    Iterable<Test> findAllByNameContaining(String name);
    Iterable<Test> findAllByLevel (Level level);
    Iterable<Test> findAllByQuestions (Question question);
    Iterable<Test> findAllOrderByDate();

}
