package com.pz.ankietBud.repositories.subQuestion;

import com.pz.ankietBud.classes.subQuestion.Rating;
import com.pz.ankietBud.repositories.QuestionBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends QuestionBaseRepository<Rating> {
    List<Rating> findAll();

    Rating findById(Integer id);
}
