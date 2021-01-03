package com.pz.ankietBud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
//@Table(name="guest", schema = "public")
@Table(name="guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //    @Column(name="identifier", nullable=false, length=200)
//    @NotNull
    @Column(name = "identifier")
    private String identifier;

    public Guest() {
    }

    public Guest(String identifier) {
        this.identifier = identifier;
    }

    public Guest(Long id, String identifier) {
        this.id = id;
        this.identifier = identifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
