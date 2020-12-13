package com.pz.ankietBud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //    @Column(name="identifier", nullable=false, length=200)
//    @NotNull
    private String identifier;

    public Guest() {
    }

    public Guest(String identifier) {
        this.identifier = identifier;
    }

    public Guest(Integer id, String identifier) {
        this.id = id;
        this.identifier = identifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
