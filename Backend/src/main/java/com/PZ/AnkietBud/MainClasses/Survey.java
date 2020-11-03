package com.PZ.AnkietBud.MainClasses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Survey {

    private Integer id;
    private String name;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creation_date;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date end_date;

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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
