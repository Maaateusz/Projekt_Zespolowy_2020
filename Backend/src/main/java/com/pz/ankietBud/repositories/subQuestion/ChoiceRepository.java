package com.pz.ankietBud.repositories.subQuestion;

import com.pz.ankietBud.classes.subQuestion.Choice;
import com.pz.ankietBud.repositories.QuestionBaseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ChoiceRepository extends QuestionBaseRepository<Choice> {
    List<Choice> findAll();

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
