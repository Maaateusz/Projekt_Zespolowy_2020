package com.PZ.AnkietBud.TMP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//@Repository
@NoRepositoryBean
public interface CustomerRepository extends CrudRepository<Customer, Long> {

//    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
//    List<Customer> findByLastName(String lastName);
//    List<Customer> findAll();
//    Customer findById(long id);
}