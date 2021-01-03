package com.pz.ankietBud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="guest", schema = "public")
@Table(name="guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    //    @Column(name="identifier", nullable=false, length=200)
//    @NotNull
    @Column(name = "identifier")
    private String identifier;

    @ManyToMany(mappedBy = "guests")
    private Set<Survey> surveys = new HashSet<>();

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }

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
