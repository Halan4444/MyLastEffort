package com.codegym.md6casequizz.service.answer;

import com.codegym.md6casequizz.model.Answer;
import com.codegym.md6casequizz.model.Question;
import com.codegym.md6casequizz.service.IGeneralService;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAllByQuestion(Question question);
    Iterable<Answer> getWrongAnswer(Long test_id, Long result_id);
    Iterable<Answer> getListQuestionByTest(Long test_id);

}
