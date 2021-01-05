package com.pz.ankietBud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guest_survey_creator")
public class Guest_Survey_Creator {

    @Id
    @Column(name = "id_survey")
    private Long id_survey;
    @Column(name = "id_guest")
    private Long id_guest;

    public Guest_Survey_Creator() {
    }

    public Guest_Survey_Creator(Long id_survey, Long id_guest) {
        this.id_survey = id_survey;
        this.id_guest = id_guest;
    }

    public Long getId_survey() {
        return id_survey;
    }

    public void setId_survey(Long id_survey) {
        this.id_survey = id_survey;
    }

    public Long getId_guest() {
        return id_guest;
    }

    public void setId_guest(Long id_guest) {
        this.id_guest = id_guest;
    }
}
