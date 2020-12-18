package com.pz.ankietBud.model;

import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.model.subQuestion.Slider;

import java.util.ArrayList;
import java.util.List;

public class SurveyService {
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List<Object> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Object> questions) {
        this.questions = questions;
    }

    public SurveyService(Survey survey, Guest guest, List<Object> questions) {
        this.survey = survey;
        this.guest = guest;
        this.questions = questions;
    }

    public SurveyService(Survey survey, Guest guest) {
        this.survey = survey;
        this.guest = guest;
    }

    public SurveyService() {
    }

    private Survey survey;
    private Guest guest;
    private List<Object> questions;
    public List<Question> q = new ArrayList<>();
    public void add(){
        q.add(new Slider());
        q.add(new Choice());
    }

//    private MyList<Question> questionMyList = MyList<>();

    public void foo(List<? extends Question> questions) {
        Question question = questions.get(0);
        Integer id = question.getId();
    }
}

class MyList<T>{
    private T[] elements;
    public void addElement(T element) {
    }
    public T getElementAtIndex(int index) {
        return elements[index];
    }
}