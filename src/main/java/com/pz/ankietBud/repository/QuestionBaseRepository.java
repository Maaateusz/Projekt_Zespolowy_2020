package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface QuestionBaseRepository<T extends Question> extends CrudRepository<T, Long> {

    Optional<T> findById(Long id);

    List<T> findAll();
}
