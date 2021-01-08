package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Question;

import javax.transaction.Transactional;

@Transactional
public interface QuestionRepository extends QuestionBaseRepository<Question> {
}
