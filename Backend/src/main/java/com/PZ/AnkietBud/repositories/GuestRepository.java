package com.PZ.AnkietBud.repositories;

import com.PZ.AnkietBud.classes.Guest;
import com.PZ.AnkietBud.classes.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();
    Guest findById(Integer id);
}
