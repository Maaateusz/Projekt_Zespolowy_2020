package com.pz.ankietBud.repositories.subQuestion;

import com.pz.ankietBud.classes.subQuestion.Slider;
import com.pz.ankietBud.repositories.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderRepository extends QuestionBaseRepository<Slider> {
    List<Slider> findAll();

    Slider findById(Integer id);
}
