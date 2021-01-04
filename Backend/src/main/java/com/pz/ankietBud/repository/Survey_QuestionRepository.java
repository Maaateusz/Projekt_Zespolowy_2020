package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Survey_Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Survey_QuestionRepository extends CrudRepository<Survey_Question, Long> {

    @Query(value = "SELECT * FROM survey_question WHERE id_survey=:id_survey", nativeQuery = true)
    List<Survey_Question> findAllBySurveyId(@Param("id_survey") Long id_survey);

}
