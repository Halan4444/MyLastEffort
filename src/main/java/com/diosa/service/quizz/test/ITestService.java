package com.diosa.service.quizz.test;


import com.diosa.model.quizz.Level;
import com.diosa.model.quizz.Question;
import com.diosa.model.quizz.Test;
import com.diosa.model.user.User;
import com.diosa.service.quizz.IGeneralService;

public interface ITestService extends IGeneralService<Test> {
    Iterable<Test> findAllByUser (User user);
    Iterable<Test> findAllByNameContaining(String name);
    Iterable<Test> findAllByLevel (Level level);
    Iterable<Test> findAllByQuestions (Question question);
    Iterable<Test> findAllOrderByDate();

}
