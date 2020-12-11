package com.PZ.AnkietBud.classes;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey")
public class Survey {

    public Survey() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creation_date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime end_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Survey(Integer id, String name, String description, Status status, LocalDateTime creation_date, LocalDateTime end_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.creation_date = creation_date;
        this.end_date = end_date;
    }

    public Survey(String name, String description, Status status, LocalDateTime creation_date, LocalDateTime end_date) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.creation_date = creation_date;
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", creation_date=" + creation_date +
                ", end_date=" + end_date +
                '}';
    }


    public enum Status{
        open,
        close;
    }

}
