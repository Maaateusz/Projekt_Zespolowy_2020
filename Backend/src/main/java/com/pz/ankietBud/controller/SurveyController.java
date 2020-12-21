package com.pz.ankietBud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pz.ankietBud.MyResourceNotFoundException;
import com.pz.ankietBud.model.Guest;
import com.pz.ankietBud.model.Question;
import com.pz.ankietBud.model.Survey;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.SurveyService;
import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.GuestRepository;
import com.pz.ankietBud.repository.SurveyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.repository.subQuestion.ChoiceRepository;
import com.pz.ankietBud.repository.subQuestion.RatingRepository;
import com.pz.ankietBud.repository.subQuestion.ScaleRepository;
import com.pz.ankietBud.repository.subQuestion.SliderRepository;
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
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private ChoiceRepository choiceRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ScaleRepository scaleRepository;
    @Autowired
    private SliderRepository sliderRepository;

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
        }).orElseThrow(() -> new MyResourceNotFoundException("Question not found!"));
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

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public SurveyService createSurvey(@RequestBody SurveyService surveyService) throws JsonProcessingException {

        log.info(shortDateObjectMapper.writeValueAsString(surveyService));

        Survey surveyNew = surveyService.getSurvey();
        surveyRepository.save(surveyNew);
        log.info(shortDateObjectMapper.writeValueAsString(surveyNew));

        Guest guestNew = surveyService.getGuest();
        guestRepository.save(guestNew);
        log.info(shortDateObjectMapper.writeValueAsString(guestNew));

        List<Choice> choices = surveyService.getChoices();
        for (Choice element : choices) {
            choiceRepository.save(element);
            log.info("-Choice: " + shortDateObjectMapper.writeValueAsString(element));
        }

        List<Rating> ratings = surveyService.getRatings();
        for (Rating element : ratings) {
            ratingRepository.save(element);
            log.info("-Rating: " + shortDateObjectMapper.writeValueAsString(element));
        }

        List<Scale> scales = surveyService.getScales();
        for (Scale element : scales) {
            scaleRepository.save(element);
            log.info("-Scale: " + shortDateObjectMapper.writeValueAsString(element));
        }

        List<Slider> sliders = surveyService.getSliders();
        for (Slider element : sliders) {
            sliderRepository.save(element);
            log.info("-Slider: " + shortDateObjectMapper.writeValueAsString(element));
        }

        surveyService.setQuestions();
        log.info(shortDateObjectMapper.writeValueAsString(surveyService.getQuestions()));

//        return shortDateObjectMapper.writeValueAsString(surveyService);
        return surveyService;
    }

}
