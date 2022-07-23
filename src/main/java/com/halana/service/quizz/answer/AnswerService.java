package com.halana.service.quizz.answer;


import com.halana.model.quizz.Answer;
import com.halana.model.quizz.Question;
import com.halana.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Iterable<Answer> findAllByQuestion(Question question) {
        return answerRepository.findAllByQuestion(question);
    }
    @Override
    public Iterable<Answer> getWrongAnswer(Long test_id, Long result_id) {
        return answerRepository.getWrongAnswer(test_id, result_id);
    }

    @Override
    public Iterable<Answer> getListQuestionByTest(Long test_id) {
        return answerRepository.getListQuestionByTest(test_id);
    }

    @Override
    public Iterable<Answer> getListAnswerByQues(Long question_id) {
        return answerRepository.getListAnswerByQues(question_id);
    }

    @Override
    public void deleteListQuestionByQues(Long question_id) {
        answerRepository.deleteByQuestion(question_id);
        System.out.println("Có Vào Không ?");

    }
}
