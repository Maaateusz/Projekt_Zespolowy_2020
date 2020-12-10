package com.PZ.AnkietBud.mainClasses;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Enum.Status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creation_date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime end_date;

//    private Guest creator_guest;
//    private List<Question> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Survey() {
    }

    public Survey(String name, String description, Enum.Status status, LocalDateTime creation_date, LocalDateTime end_date) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.creation_date = creation_date;
        this.end_date = end_date;
    }

    public Survey(Integer id, String name, String description, Enum.Status status, LocalDateTime creation_date, LocalDateTime end_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.creation_date = creation_date;
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum.Status getStatus() {
        return status;
    }

    public void setStatus(Enum.Status status) {
        this.status = status;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public String toJSON()
    {
        return String.format("[id=%d, name='%s', description='%s', creation_date='%s', end_date='%s']", id, name, description, creation_date.toString(), end_date.toString());
    }
}
