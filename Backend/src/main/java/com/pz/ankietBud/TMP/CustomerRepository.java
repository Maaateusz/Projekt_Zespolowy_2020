package com.pz.ankietBud.TMP;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@Repository
@NoRepositoryBean
public interface CustomerRepository extends CrudRepository<Customer, Long> {

//    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
//    List<Customer> findByLastName(String lastName);
//    List<Customer> findAll();
//    Customer findById(long id);
}