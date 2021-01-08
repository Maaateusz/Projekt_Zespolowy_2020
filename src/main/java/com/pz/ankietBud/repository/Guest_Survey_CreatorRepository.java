package com.pz.ankietBud.repository;

import com.pz.ankietBud.model.Guest_Survey_Creator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Guest_Survey_CreatorRepository extends CrudRepository<Guest_Survey_Creator, Long> {
}
