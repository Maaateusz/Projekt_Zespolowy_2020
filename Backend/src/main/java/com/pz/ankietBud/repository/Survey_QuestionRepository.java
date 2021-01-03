package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Guest_Survey_Creator;
import com.pz.ankietBud.model.Survey_Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Survey_QuestionRepository extends CrudRepository<Survey_Question, Long> {
}
