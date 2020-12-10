package com.PZ.AnkietBud.repositories.subQuestion;

import com.PZ.AnkietBud.classes.Question;
import com.PZ.AnkietBud.classes.Survey;
import com.PZ.AnkietBud.classes.subQuestion.Rating;
import com.PZ.AnkietBud.repositories.QuestionRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends QuestionRepository {
    List<Question> findAll();
    Rating findById(long id);
}
