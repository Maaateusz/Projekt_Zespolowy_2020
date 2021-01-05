package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Guest_Survey_Participate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Guest_Survey_ParticipateRepository extends CrudRepository<Guest_Survey_Participate, Long> {

    @Query(value = "SELECT * FROM guest_survey_participate WHERE id_survey=:id_survey", nativeQuery = true)
    List<Guest_Survey_Participate> findAllBySurveyId(@Param("id_survey") Long id_survey);

    @Query(value = "SELECT * FROM guest_survey_participate WHERE id_guest=:id_guest", nativeQuery = true)
    List<Guest_Survey_Participate> findAllByGusetId(@Param("id_guest") Long id_guest);

    @Query(value = "SELECT * FROM guest_survey_participate WHERE id_guest=:id_guest AND id_survey=:id_survey", nativeQuery = true)
    Optional<Guest_Survey_Participate> findByOtherId(@Param("id_survey") Long id_survey, @Param("id_guest") Long id_guest);
}
