package com.pz.ankietBud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey_question")
public class Survey_Question {

    @Column(name = "id_survey")
    private Long id_survey;

    @Id
    @Column(name = "id_question")
    private Long id_question;

    public Survey_Question() {
    }

    public Survey_Question(Long id_survey, Long id_question) {
        this.id_survey = id_survey;
        this.id_question = id_question;
    }

    public Long getId_survey() {
        return id_survey;
    }

    public void setId_survey(Long id_survey) {
        this.id_survey = id_survey;
    }

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }
}
