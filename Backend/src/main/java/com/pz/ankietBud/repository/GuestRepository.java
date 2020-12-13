package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();

    Guest findById(Integer id);
}
