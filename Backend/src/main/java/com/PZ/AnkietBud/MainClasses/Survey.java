package com.PZ.AnkietBud.MainClasses;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Survey {

    private Integer id;
    private String name;
    private String description;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creation_date;
//    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime end_date;

    public Survey() {}

    public Survey(Integer id, String name, String description, LocalDateTime creation_date, LocalDateTime end_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creation_date = creation_date;
        this.end_date = end_date;
    }

    public Survey(String name, String description, LocalDateTime end_date) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.creation_date = null;
        this.end_date = end_date;
    }

    public Integer getId() {
        return id;
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

    @Override
    public String toString()
    {
        return String.format("[id=%d, name='%s', description='%s', creation_date='%s', end_date='%s']", id, name, description, creation_date.toString(), end_date.toString());
    }
}
