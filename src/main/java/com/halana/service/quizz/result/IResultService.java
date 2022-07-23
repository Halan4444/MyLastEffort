package com.halana.service.quizz.result;


import com.halana.model.quizz.Result;
import com.halana.model.quizz.Test;
import com.halana.model.user.User;
import com.halana.service.quizz.IGeneralService;

public interface IResultService extends IGeneralService<Result> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);

}
