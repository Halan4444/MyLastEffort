package com.diosa.service.quizz.question;



import com.diosa.model.quizz.Category;
import com.diosa.model.quizz.Question;
import com.diosa.service.quizz.IGeneralService;

import java.util.Optional;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> searchQuestion(String contents,Long type_id,Long category_id, Long level_id);
    Iterable<Question> findAllByCategory(Category category);
    Optional<Question> findNeweastQuestion();
    Iterable<Question> findAllOrderByDate();

}
