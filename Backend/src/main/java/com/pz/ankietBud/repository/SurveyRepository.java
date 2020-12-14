package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

    List<Survey> findAll();

    Optional<Survey> findById(Long id);

    //fetch first 10 rows only
    @Query(value = "SELECT * FROM survey ORDER BY creation_date DESC LIMIT ?1", nativeQuery = true)
    List<Survey> findXSortedDesc(Integer number);


//    List<Survey> findByStatus(Survey.Status status);
//    List<Survey> surveys = surveyRepository.findByStatus(Survey.Status.open);

//    @Query("select * from survey where name=:name")
//    List<Survey> findByName(@Param("name") String name);
//
//    @Modifying
//    @Query("UPDATE person SET first_name = :name WHERE id = :id")
//    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);
}
