package com.diosa.service.quizz.result;


import com.diosa.model.quizz.Result;
import com.diosa.model.quizz.Test;
import com.diosa.model.user.User;
import com.diosa.service.quizz.IGeneralService;

public interface IResultService extends IGeneralService<Result> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);

}
