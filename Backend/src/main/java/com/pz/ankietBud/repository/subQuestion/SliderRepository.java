package com.pz.ankietBud.repository.subQuestion;

import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SliderRepository extends QuestionBaseRepository<Slider> {
    List<Slider> findAll();

    Optional<Slider> findById(Integer id);
}
