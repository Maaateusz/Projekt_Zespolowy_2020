package com.pz.ankietBud.repository.subQuestion;

import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.repository.QuestionBaseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface ChoiceRepository extends QuestionBaseRepository<Choice> {
    List<Choice> findAll();

    //    List<Choice> findAll();
    Optional<Choice> findById(Integer id);
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
