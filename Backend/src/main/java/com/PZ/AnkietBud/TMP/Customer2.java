package com.PZ.AnkietBud.TMP;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Customer2")
@PrimaryKeyJoinColumn(name = "id")
public class Customer2 extends Customer{

    private String lastName;

    protected Customer2() {
    }

    public Customer2(String lastName) {
        this.lastName = lastName;
    }

    public Customer2(String firstName, String lastName) {
        super(firstName);
        this.lastName = lastName;
    }

//    public Customer2(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[lastName='%s']",lastName);
    }

}