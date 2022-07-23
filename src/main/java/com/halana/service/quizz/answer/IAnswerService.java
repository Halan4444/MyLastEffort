package com.halana.service.quizz.answer;


import com.halana.model.quizz.Answer;
import com.halana.model.quizz.Question;
import com.halana.service.quizz.IGeneralService;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAllByQuestion(Question question);
    Iterable<Answer> getWrongAnswer(Long test_id, Long result_id);
    Iterable<Answer> getListQuestionByTest(Long test_id);
    Iterable<Answer> getListAnswerByQues(Long question_id);
    void deleteListQuestionByQues(Long question_id);
}
