package com.pz.ankietBud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.Guest;
import com.pz.ankietBud.model.Survey;
import com.pz.ankietBud.model.SurveyService;
import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.GuestRepository;
import com.pz.ankietBud.repository.SurveyRepository;
import com.pz.ankietBud.repository.subQuestion.ChoiceRepository;
import com.pz.ankietBud.repository.subQuestion.RatingRepository;
import com.pz.ankietBud.repository.subQuestion.ScaleRepository;
import com.pz.ankietBud.repository.subQuestion.SliderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surveyService")
@CrossOrigin
public class SurveyServiceController {

    private static final Logger log = LoggerFactory.getLogger(SurveyServiceController.class);
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

    @GetMapping("/get/{id}")
    public SurveyService getSurveyService(@PathVariable("id") Long id) throws JsonProcessingException {

        SurveyService surveyService = new SurveyService();
//        surveyRepository.findById(id).ifPresentOrElse(survey -> surveyService.setSurvey(survey),
        surveyRepository.findById(id).ifPresentOrElse(surveyService::setSurvey,
                ()-> log.info("X- No Survey id: " + id.toString()));

        //add to guest_survey_participate, guest_survey_creator



        log.info(shortDateObjectMapper.writeValueAsString(surveyService));
        return surveyService;
    }
}
