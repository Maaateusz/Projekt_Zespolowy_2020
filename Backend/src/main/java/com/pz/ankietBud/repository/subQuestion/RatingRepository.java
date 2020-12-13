package com.pz.ankietBud.repository.subQuestion;

import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.repository.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends QuestionBaseRepository<Rating> {
    List<Rating> findAll();

    Rating findById(Integer id);
}
