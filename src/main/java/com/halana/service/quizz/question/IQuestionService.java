package com.halana.service.quizz.question;



import com.halana.model.quizz.Category;
import com.halana.model.quizz.Question;
import com.halana.service.quizz.IGeneralService;

import java.util.Optional;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> searchQuestion(String contents,Long type_id,Long category_id, Long level_id);
    Iterable<Question> findAllByCategory(Category category);
    Optional<Question> findNeweastQuestion();
    Iterable<Question> findAllOrderByDate();

}
