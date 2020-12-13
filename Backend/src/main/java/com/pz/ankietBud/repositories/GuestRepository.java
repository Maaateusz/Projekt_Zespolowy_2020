package com.pz.ankietBud.repositories;

import com.pz.ankietBud.classes.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();

    Guest findById(Integer id);
}
