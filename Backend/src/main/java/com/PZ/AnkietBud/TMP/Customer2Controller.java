package com.PZ.AnkietBud.TMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Customer2Controller {

    @Autowired
    Customer2Repository customer2Repository;

    @GetMapping("/add2")
    public void add(){
        customer2Repository.save(new Customer2("Adam", "Mickiewicz"));
        customer2Repository.save(new Customer2("123", "321"));
        customer2Repository.save(new Customer2("qweqw", "ewqeqw"));
        Customer2 c = new Customer2("@#2231", "ASDASD");
        customer2Repository.save(c);
//        Customer2 c2 =
//        customer2Repository.delete(c);
    }

    @GetMapping("/all2")
    public List<Customer> getAll(){
        List<Customer> customers2 = customer2Repository.findAll();
        System.out.println(customers2);
        return customers2;
    }

    @GetMapping("/get2")
    public Customer2 get(){
        Customer2 c = customer2Repository.findById(2);
        System.out.println(c);
        return c;
    }

    @GetMapping("/set2")
    public Customer2 set(){
        Customer2 c = customer2Repository.findById(1);
        c.setLastName("****");
        c.setFirstName("####");
        customer2Repository.save(c);
        System.out.println(c);
        return c;
    }
}
