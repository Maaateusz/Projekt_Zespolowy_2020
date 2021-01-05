package com.pz.ankietBud.model;

import javax.persistence.*;

@Entity
@Table(name = "guest_survey_participate")
public class Guest_Survey_Participate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_survey")
    private Long id_survey;
    @Column(name = "id_guest")
    private Long id_guest;

    public Guest_Survey_Participate(Long id, Long id_survey, Long id_guest) {
        this.id = id;
        this.id_survey = id_survey;
        this.id_guest = id_guest;
    }

    public Guest_Survey_Participate() {
    }

    public Guest_Survey_Participate(Long id_survey, Long id_guest) {
        this.id_survey = id_survey;
        this.id_guest = id_guest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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