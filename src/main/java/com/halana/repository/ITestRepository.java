package com.halana.repository;

import com.halana.model.quizz.Level;
import com.halana.model.quizz.Question;
import com.halana.model.quizz.Test;
import com.halana.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Test, Long> {
    @Query(value = "select *\n" +
            "from tests order by date desc ;",nativeQuery = true)
    Iterable<Test> findAllOrderByDate();
    Iterable<Test> findAllByUser (User user);
    Iterable<Test> findAllByNameContaining(String name);
    Iterable<Test> findAllByLevel (Level level);
    Iterable<Test> findAllByQuestions (Question question);
//    @Query(value = "select q.*\n" +
//            "from questions q left join test_ques tq on tq.ques_id = q.id group by q.id having q.id\n" +
//            " in (select ques_id from test_ques where test_id = :test_id);",nativeQuery = true)
//    Iterable<Question> getListQuestionByTest(Long test_id);
}
