package com.pz.ankietBud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.MyResourceNotFoundException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.Survey;
import com.pz.ankietBud.repository.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private SurveyRepository surveyRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Survey addSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey surveyNew = survey;
        surveyRepository.save(surveyNew);
        log.info(shortDateObjectMapper.writeValueAsString(surveyNew));
        log.info("+ ---" + shortDateObjectMapper.writeValueAsString(surveyNew));
        return surveyNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Survey> getAllSurvey() throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findAll();
        for (Survey element : surveys) {
            log.info(shortDateObjectMapper.writeValueAsString(element));
        }
        log.info("A --- get all Surveys");
        return surveys;
    }

    @GetMapping(value = "/getLastByCreation/{number}", produces = "application/json")
    public List<Survey> getXSortedByCreateionDateDesc(@PathVariable("number") Integer number) throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findXSortedByCreateionDateDesc(number);
        for (Survey element : surveys) {
            log.info(shortDateObjectMapper.writeValueAsString(element));
        }
        log.info("A --- get X Surveys");
        return surveys;
    }

    @GetMapping(value = "/getLastByEnd/{number}", produces = "application/json")
    public List<Survey> getXSortedByEndDateDesc(@PathVariable("number") Integer number) throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findXSortedByEndDateDesc(number);
        for (Survey element : surveys) {
            log.info(shortDateObjectMapper.writeValueAsString(element));
        }
        log.info("A --- get X Surveys");
        return surveys;
    }

    @GetMapping("/get/{id}")
    public Optional<Survey> getSurvey(@PathVariable("id") Long id) throws JsonProcessingException {
        Optional<Survey> survey = surveyRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(survey));
        log.info("I --- get one " + shortDateObjectMapper.writeValueAsString(survey));
        return survey;
    }

    @GetMapping("/delete/{id}")
    public String deleteSurvey(@PathVariable("id") Long id) throws JsonProcessingException {
        surveyRepository.findById(id).map(survey -> {
            surveyRepository.delete(survey);
            try {
                return shortDateObjectMapper.writeValueAsString(survey);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return "survey";
        }).orElseThrow(() -> new MyResourceNotFoundException("Survey not found!"));
        return "survey???";
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id) {
    public Survey updateSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey surveyUpdated = survey;
        surveyRepository.save(surveyUpdated);
        log.info(shortDateObjectMapper.writeValueAsString(surveyUpdated));
        log.info("= ---" + shortDateObjectMapper.writeValueAsString(surveyUpdated));
        return surveyUpdated;
    }

}
