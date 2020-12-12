package com.PZ.AnkietBud.repositories.subQuestion;

import com.PZ.AnkietBud.classes.Question;
import com.PZ.AnkietBud.classes.subQuestion.Choice;
import com.PZ.AnkietBud.repositories.QuestionBaseRepository;
import com.PZ.AnkietBud.repositories.QuestionRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface ChoiceRepository extends QuestionBaseRepository<Choice> {
    Iterable<Choice> findAll();
//    List<Choice> findAll();
    Choice findById(Integer id);
//    Question findById(Integer id);

//    @Override
//    public List<Choice> findAll() {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Choice> criteria = builder
//                .createQuery( Choice.class );
//        criteria.from( Question.class );
//
//        return entityManager
//                .createQuery( criteria )
//                .getResultList();
//    }
}