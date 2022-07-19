package com.diosa.service.quizz.result;


import com.diosa.model.quizz.Result;
import com.diosa.model.quizz.Test;
import com.diosa.model.user.User;
import com.diosa.repository.IResultRepository;
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
