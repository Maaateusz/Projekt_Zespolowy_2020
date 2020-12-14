package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    List<Survey> findAll();

    //    Optional<Survey> findById(Integer id);
    Survey findById(Integer id);
    List<Survey> findByOrderByCreationDateDesc();
    @Query(value = "select * from survey order by creation_date desc limit ?1", nativeQuery = true)
    List<Survey> findXSortedDesc(Integer count);

//    List<Survey> findByStatus(Survey.Status status);
//    List<Survey> surveys = surveyRepository.findByStatus(Survey.Status.open);


//    @Query("select * from survey where name=:name")
//    List<Survey> findByName(@Param("name") String name);
//
//    @Modifying
//    @Query("UPDATE person SET first_name = :name WHERE id = :id")
//    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);
}
