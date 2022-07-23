package com.halana.service.quizz.result;


import com.halana.model.quizz.Result;
import com.halana.model.quizz.Test;
import com.halana.model.user.User;
import com.halana.repository.IResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService implements IResultService{
    @Autowired
    IResultRepository resultRepository;


    @Override
    public Iterable<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    public Iterable<Result> findAllByUser(User user) {
        return resultRepository.findAllByUser(user);
    }

    @Override
    public Iterable<Result> findAllByTest(Test test) {
        return resultRepository.findAllByTest(test);
    }


}
