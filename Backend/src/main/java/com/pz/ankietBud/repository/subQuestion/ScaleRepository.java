package com.pz.ankietBud.repository.subQuestion;

import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.repository.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScaleRepository extends QuestionBaseRepository<Scale> {
    List<Scale> findAll();

    Scale findById(Integer id);
}
