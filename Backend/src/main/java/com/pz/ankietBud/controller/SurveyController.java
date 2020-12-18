package com.pz.ankietBud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pz.ankietBud.MyResourceNotFoundException;
import com.pz.ankietBud.model.Guest;
import com.pz.ankietBud.model.Question;
import com.pz.ankietBud.model.Survey;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.SurveyService;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.SurveyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping(value = "/getLastByCreation/{number}", produces = "application/json")
    public List<Survey> getXSortedByCreateionDateDesc(@PathVariable("number") Integer number) throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findXSortedByCreateionDateDesc(number);
        for (Survey item : surveys) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        log.info("A --- get X Surveys");
        return surveys;
    }

    @GetMapping(value = "/getLastByEnd/{number}", produces = "application/json")
    public List<Survey> getXSortedByEndDateDesc(@PathVariable("number") Integer number) throws JsonProcessingException {
        List<Survey> surveys = surveyRepository.findXSortedByEndDateDesc(number);
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
//    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id) {
    public Survey updateSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey surveyUpdated = survey;
        surveyRepository.save(surveyUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyUpdated));
        log.info("= ---" + shortDateObjectMapper.writeValueAsString(surveyUpdated));
        return surveyUpdated;
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public String createSurvey(@RequestBody SurveyService surveyService) throws JsonProcessingException {

        System.out.println(shortDateObjectMapper.writeValueAsString(surveyService));

        Survey surveyNew = surveyService.getSurvey();
//        surveyRepository.save(surveyNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyNew));
        System.out.println(surveyNew.getClass());

        Guest guestNew = surveyService.getGuest();
//        guestRepository.save(guestNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(guestNew));
        System.out.println(guestNew.getClass());

        List<Object> slidersNew = surveyService.getQuestions();
        System.out.println(slidersNew.getClass());
        for (Object question : slidersNew) {
            System.out.println(shortDateObjectMapper.writeValueAsString(question));
            System.out.println(question.getClass());
//            Question q = ((Slider) question);
        }

        List<Object> objects = surveyService.getQuestions();
        for (Object question : objects) {

//            surveyService.q.add((Question) question);
//            Slider s = castTo(Slider.class, question);
//            Question q = (Question) question;
//            System.out.println(shortDateObjectMapper.writeValueAsString(s));
//            System.out.println(s.getClass());
            String type = checkType(question);
            System.out.println(type);
//            ObjectMapper mapper = new ObjectMapper();
//            Map<String,Object> map = mapper.readValue(question, Map.class);
        }
//        surveyService.add();
        System.out.println(shortDateObjectMapper.writeValueAsString(surveyService.q));

        return shortDateObjectMapper.writeValueAsString(surveyService);
    }

    private String checkType(Object object) throws JsonProcessingException {
        HashMap result = new ObjectMapper().readValue(shortDateObjectMapper.writeValueAsString(object), HashMap.class);
        if(result.containsKey("value_min")){
            return "Slider";
        }
        else if(result.containsKey("anchor_left") ){
            return "Scale";
        }
        else return "null";
    }

    private <T> T castTo(Class<T> cls, Object o) {
//        Object o = cls;
        return cls.cast(o);
    }
}
