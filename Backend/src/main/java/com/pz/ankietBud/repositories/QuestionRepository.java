package com.pz.ankietBud.repositories;

import com.pz.ankietBud.classes.Question;

import javax.transaction.Transactional;

@Transactional
public interface QuestionRepository extends QuestionBaseRepository<Question> {
}
