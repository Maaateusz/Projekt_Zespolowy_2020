package com.PZ.AnkietBud.repositories.subQuestion;

import com.PZ.AnkietBud.classes.Question;
import com.PZ.AnkietBud.classes.Survey;
import com.PZ.AnkietBud.classes.subQuestion.Choice;
import com.PZ.AnkietBud.classes.subQuestion.Scale;
import com.PZ.AnkietBud.repositories.QuestionBaseRepository;
import com.PZ.AnkietBud.repositories.QuestionRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScaleRepository extends QuestionBaseRepository<Scale> {
    List<Scale> findAll();
    Scale findById(Integer id);
}
