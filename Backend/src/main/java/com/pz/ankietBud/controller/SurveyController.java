package com.pz.ankietBud.controller;

import com.pz.ankietBud.MyResourceNotFoundException;
import com.pz.ankietBud.model.Survey;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.repository.SurveyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyNew));
        log.info("+ ---" + shortDateObjectMapper.writeValueAsString(surveyNew));
        return surveyNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Survey> getAllSurvey() throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findAll();
        for (Survey item : surveys) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        log.info("A --- get all Surveys");
        return surveys;
    }

    @GetMapping(value = "/getSorted/{number}", produces = "application/json")
    public List<Survey> getXSortedDesc(@PathVariable("number") Integer number) throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findXSortedDesc(number);
        for (Survey item : surveys) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        log.info("A --- get X Surveys");
        return surveys;
    }

    @GetMapping("/get/{id}")
    public Optional<Survey> getSurvey(@PathVariable("id") Long id) throws JsonProcessingException {
        Optional<Survey> survey = surveyRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(survey));
        log.info("I --- get one " + shortDateObjectMapper.writeValueAsString(survey));
        return survey;
    }

    @GetMapping("/delete/{id}")
    public String deleteSurvey(@PathVariable("id") Long id) throws JsonProcessingException {
//        Optional<Survey> survey = surveyRepository.findById(id);
//        if(!survey.isPresent()) return "null";
//        surveyRepository.delete(survey);
//        System.out.println(shortDateObjectMapper.writeValueAsString(survey));
//        log.info("x ---" + shortDateObjectMapper.writeValueAsString(survey));
//        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(survey);

        surveyRepository.findById(id).map(survey -> {
            surveyRepository.delete(survey);
            try {
                return shortDateObjectMapper.writeValueAsString(survey);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return "survey";
        }).orElseThrow(() -> new MyResourceNotFoundException("Question not found!"));
        return "survey???";
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Survey updateSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey surveyUpdated = survey;
        surveyRepository.save(surveyUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyUpdated));
        log.info("= ---" + shortDateObjectMapper.writeValueAsString(surveyUpdated));
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
