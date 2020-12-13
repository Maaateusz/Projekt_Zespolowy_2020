package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface QuestionBaseRepository<T extends Question> extends CrudRepository<T, Long> {
    T findById(Integer id);

    List<T> findAll();
}
