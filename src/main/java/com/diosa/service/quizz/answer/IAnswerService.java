package com.diosa.service.quizz.answer;


import com.diosa.model.quizz.Answer;
import com.diosa.model.quizz.Question;
import com.diosa.service.quizz.IGeneralService;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAllByQuestion(Question question);
    Iterable<Answer> getWrongAnswer(Long test_id, Long result_id);
    Iterable<Answer> getListQuestionByTest(Long test_id);

}
