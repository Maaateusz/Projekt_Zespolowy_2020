package com.pz.ankietBud.TMP;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

//    private String lastName;

    protected Customer() {
    }

    public Customer(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s']", id,
                firstName);
    }

}