package com.halana.service.quizz.test;


import com.halana.model.quizz.Level;
import com.halana.model.quizz.Question;
import com.halana.model.quizz.Test;
import com.halana.model.user.User;
import com.halana.service.quizz.IGeneralService;

public interface ITestService extends IGeneralService<Test> {
    Iterable<Test> findAllByUser (User user);
    Iterable<Test> findAllByNameContaining(String name);
    Iterable<Test> findAllByLevel (Level level);
    Iterable<Test> findAllByQuestions (Question question);
    Iterable<Test> findAllOrderByDate();

}
