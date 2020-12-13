package com.pz.ankietBud.repositories.subQuestion;

import com.pz.ankietBud.classes.subQuestion.Scale;
import com.pz.ankietBud.repositories.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScaleRepository extends QuestionBaseRepository<Scale> {
    List<Scale> findAll();

    Scale findById(Integer id);
}
