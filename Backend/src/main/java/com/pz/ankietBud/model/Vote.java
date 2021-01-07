package com.pz.ankietBud.model;

import java.util.List;

public class Vote {

    private Long id_survey;
    private List<Long> id_questions;
    private List<Integer> id_answers;

    public Vote() {
    }

    public Vote(Long id_survey, List<Long> id_questions, List<Integer> id_answer) {
        this.id_survey = id_survey;
        this.id_questions = id_questions;
        this.id_answers = id_answer;
    }

    public Long getId_survey() {
        return id_survey;
    }

    public void setId_survey(Long id_survey) {
        this.id_survey = id_survey;
    }

    public List<Long> getId_questions() {
        return id_questions;
    }

    public void setId_questions(List<Long> id_questions) {
        this.id_questions = id_questions;
    }

    public List<Integer> getId_answers() {
        return id_answers;
    }

    public void setId_answers(List<Integer> id_answers) {
        this.id_answers = id_answers;
    }
}
