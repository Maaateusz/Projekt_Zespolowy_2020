package com.pz.ankietBud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey")
//@NamedQuery(name = "Survey.findX",
//        query = "select * from survey order by creation_date desc limit 2")
//fetch first 10 rows only
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    //    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    //    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime end_date;
    public Survey() {
    }

    public Survey(Integer id, String name, String description, Status status, LocalDateTime creationDate, LocalDateTime end_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.end_date = end_date;
    }

    public Survey(String name, String description, Status status, LocalDateTime creationDate, LocalDateTime end_date) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.end_date = end_date;
    }

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", creation_date=" + creationDate +
                ", end_date=" + end_date +
                '}';
    }


    public enum Status {
        open,
        close
    }

}
