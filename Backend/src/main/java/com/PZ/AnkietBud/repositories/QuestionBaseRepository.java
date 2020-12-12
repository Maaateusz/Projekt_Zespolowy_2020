package com.PZ.AnkietBud.repositories;

import com.PZ.AnkietBud.classes.Question;
import com.PZ.AnkietBud.classes.subQuestion.Choice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface QuestionBaseRepository<T extends Question> extends CrudRepository<T, Long> {
    T findById(Integer id);
    Iterable<T> findAll();
}
