package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    List<Survey> findAll();

    //    Optional<Survey> findById(Integer id);
    Survey findById(Integer id);

//    @Query("select * from survey where name=:name")
//    List<Survey> findByName(@Param("name") String name);
//
//    @Modifying
//    @Query("UPDATE person SET first_name = :name WHERE id = :id")
//    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);
}
