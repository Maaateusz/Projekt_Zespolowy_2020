package com.pz.ankietBud.TMP;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Customer2Repository extends CustomerRepository {

    //    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
//    List<Customer> findByLastName(String lastName);
    List<Customer> findAll();

    Customer2 findById(long id);

//    @Override
//    public int update(Book book) {
//        return jdbcTemplate.update(
//                "update books set price = ? where id = ?",
//                book.getPrice(), book.getId());
//    }
}