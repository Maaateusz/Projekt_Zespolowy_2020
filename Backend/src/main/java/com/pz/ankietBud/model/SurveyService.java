package com.pz.ankietBud.model;

import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.model.subQuestion.Slider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyService {
    private Survey survey;
    private Guest guest;
    private List<Choice> choices;
    private List<Rating> ratings;
    private List<Scale> scales;
    private List<Slider> sliders;
    private Map<String, Integer> questions = new HashMap<>();

    public SurveyService(Survey survey, Guest guest, List<Choice> choices, List<Rating> ratings, List<Scale> scales, List<Slider> sliders, Map<String, Integer> questions) {
        this.survey = survey;
        this.guest = guest;
        this.choices = choices;
        this.ratings = ratings;
        this.scales = scales;
        this.sliders = sliders;
        this.questions = questions;
    }

    public SurveyService(Survey survey, Guest guest) {
        this.survey = survey;
        this.guest = guest;
    }

    public SurveyService() {
    }

    public SurveyService(Survey survey, Guest guest, List<Choice> choices, List<Rating> ratings, List<Scale> scales, List<Slider> sliders) {
        this.survey = survey;
        this.guest = guest;
        this.choices = choices;
        this.ratings = ratings;
        this.scales = scales;
        this.sliders = sliders;

        setQuestions();
    }

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

    public SurveyService(Survey survey, List<Choice> choices, List<Rating> ratings, List<Scale> scales, List<Slider> sliders, Map<String, Integer> questions) {
        this.survey = survey;
        this.choices = choices;
        this.ratings = ratings;
        this.scales = scales;
        this.sliders = sliders;
        this.questions = questions;
    }

    public void setQuestions() {
        questions.put(Choice.class.getSimpleName(), choices.size());
        questions.put(Rating.class.getSimpleName(), ratings.size());
        questions.put(Scale.class.getSimpleName(), scales.size());
        questions.put(Slider.class.getSimpleName(), sliders.size());
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Scale> getScales() {
        return scales;
    }

    public void setScales(List<Scale> scales) {
        this.scales = scales;
    }

    public List<Slider> getSliders() {
        return sliders;
    }

    public void setSliders(List<Slider> sliders) {
        this.sliders = sliders;
    }

    public Map<String, Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(HashMap<String, Integer> questions) {
        this.questions = questions;
    }


}