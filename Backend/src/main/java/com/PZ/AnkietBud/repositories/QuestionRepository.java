package com.PZ.AnkietBud.repositories;

import com.PZ.AnkietBud.classes.Question;
import com.PZ.AnkietBud.classes.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;

@Transactional
public interface QuestionRepository extends QuestionBaseRepository<Question> {
}
