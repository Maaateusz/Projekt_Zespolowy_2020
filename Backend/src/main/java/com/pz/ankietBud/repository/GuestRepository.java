package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findAll();
    Optional<Guest> findByIdentifier(String identifier);
}
