package com.halana.service.quizz.test;

import com.halana.model.quizz.Level;
import com.halana.model.quizz.Question;
import com.halana.model.quizz.Test;
import com.halana.model.user.User;
import com.halana.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService implements ITestService{
    @Autowired
    ITestRepository testRepository;

    @Override
    public Iterable<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public Iterable<Test> findAllByUser(User user) {
        return testRepository.findAllByUser(user);
    }

    @Override
    public Iterable<Test> findAllByNameContaining(String name) {
        return testRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Test> findAllByLevel(Level level) {
        return testRepository.findAllByLevel(level);
    }

    @Override
    public Iterable<Test> findAllByQuestions(Question question) {
        return testRepository.findAllByQuestions(question);
    }

    @Override
    public Iterable<Test> findAllOrderByDate() {
        return testRepository.findAllOrderByDate();
    }


}
