package com.PZ.AnkietBud.repositories;

import com.PZ.AnkietBud.TMP.Customer;
import com.PZ.AnkietBud.TMP.Customer2;
import com.PZ.AnkietBud.classes.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    List<Survey> findAll();
    Survey findById(long id);
}
