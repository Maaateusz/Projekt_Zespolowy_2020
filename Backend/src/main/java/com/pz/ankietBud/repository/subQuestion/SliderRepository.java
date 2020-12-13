package com.pz.ankietBud.repository.subQuestion;

import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderRepository extends QuestionBaseRepository<Slider> {
    List<Slider> findAll();

    Slider findById(Integer id);
}
