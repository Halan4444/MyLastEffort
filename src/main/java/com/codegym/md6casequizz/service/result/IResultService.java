package com.codegym.md6casequizz.service.result;

import com.codegym.md6casequizz.model.Result;
import com.codegym.md6casequizz.model.Test;
import com.codegym.md6casequizz.model.User;
import com.codegym.md6casequizz.service.IGeneralService;

public interface IResultService extends IGeneralService<Result> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);

}
