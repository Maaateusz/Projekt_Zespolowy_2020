package com.pz.ankietBud.controllers;

import com.pz.ankietBud.classes.Survey;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.repositories.SurveyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private SurveyRepository surveyRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Survey addSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey surveyNew = survey;
//        surveyRepository.save(surveyNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyNew));
        return surveyNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Survey> getAllSurvey() throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findAll();
        for (Survey item : surveys) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        return surveys;
    }

    @GetMapping("/get/{id}")
    public Survey getSurvey(@PathVariable("id") Integer id) throws JsonProcessingException {
        Survey survey = surveyRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(survey));
        return survey;
    }

    @GetMapping("/delete/{id}")
    public String deleteSurvey(@PathVariable("id") Integer id) throws JsonProcessingException {
        Survey survey = surveyRepository.findById(id);
//        surveyRepository.delete(survey);
        System.out.println(shortDateObjectMapper.writeValueAsString(survey));
        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(survey);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Survey updateSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey surveyUpdated = survey;
//        surveyRepository.save(surveyUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyUpdated));
        return surveyUpdated;
    }

//    @GetMapping(value = "/{URL}", produces = "application/json")
//    public Survey getSurveyURL(@PathVariable("URL") String URL)
//    {
//        Survey survey = new Survey();
//        survey.setDescription(URL);
//        return survey;
//    }

}
