package com.pz.ankietBud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.*;
import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.*;
import com.pz.ankietBud.repository.subQuestion.ChoiceRepository;
import com.pz.ankietBud.repository.subQuestion.RatingRepository;
import com.pz.ankietBud.repository.subQuestion.ScaleRepository;
import com.pz.ankietBud.repository.subQuestion.SliderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private Guest_Survey_CreatorRepository guest_survey_creatorRepository;
    @Autowired
    private Survey_QuestionRepository survey_questionRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public SurveyService createSurvey(@RequestBody SurveyService surveyService) throws JsonProcessingException {

        log.info(shortDateObjectMapper.writeValueAsString(surveyService));

        Survey surveyNew = surveyService.getSurvey();
        surveyRepository.save(surveyNew);
        log.info(shortDateObjectMapper.writeValueAsString(surveyNew));

        //powinno dodać tylko jeśli nie istnieje!
        //guest dodawany przy odwiedzaniu strony!
        Guest guestNew = surveyService.getGuest();
        if(guestNew.getId() == null) guestRepository.save(guestNew);

        guest_survey_creatorRepository.save(new Guest_Survey_Creator(surveyNew.getId(), guestNew.getId()));
        log.info(shortDateObjectMapper.writeValueAsString(guestNew));

        List<Survey_Question> survey_questions = new ArrayList<>();

        List<Choice> choices = surveyService.getChoices();
        for (Choice element : choices) {
            choiceRepository.save(element);
//            survey_questionRepository.save(new Survey_Question(surveyNew.getId(), element.getId()));
            survey_questions.add(new Survey_Question(surveyNew.getId(), element.getId()));
            log.info("-Choice: " + shortDateObjectMapper.writeValueAsString(element));
        }

        List<Rating> ratings = surveyService.getRatings();
        for (Rating element : ratings) {
            ratingRepository.save(element);
//            survey_questionRepository.save(new Survey_Question(surveyNew.getId(), element.getId()));
            survey_questions.add(new Survey_Question(surveyNew.getId(), element.getId()));
            log.info("-Rating: " + shortDateObjectMapper.writeValueAsString(element));
        }

        List<Scale> scales = surveyService.getScales();
        for (Scale element : scales) {
            scaleRepository.save(element);
//            survey_questionRepository.save(new Survey_Question(surveyNew.getId(), element.getId()));
            survey_questions.add(new Survey_Question(surveyNew.getId(), element.getId()));
            log.info("-Scale: " + shortDateObjectMapper.writeValueAsString(element));
        }

        List<Slider> sliders = surveyService.getSliders();
        for (Slider element : sliders) {
            sliderRepository.save(element);
//            survey_questionRepository.save(new Survey_Question(surveyNew.getId(), element.getId()));
            survey_questions.add(new Survey_Question(surveyNew.getId(), element.getId()));
            log.info("-Slider: " + shortDateObjectMapper.writeValueAsString(element));
        }

        survey_questionRepository.saveAll(survey_questions);

        surveyService.setQuestions();
        log.info(shortDateObjectMapper.writeValueAsString(surveyService.getQuestions()));

//        return shortDateObjectMapper.writeValueAsString(surveyService);
        return surveyService;
    }

    @GetMapping("/get/{id}")
    public SurveyService getSurveyService(@PathVariable("id") Long id) throws JsonProcessingException {

        SurveyService surveyService = new SurveyService();
        surveyRepository.findById(id).ifPresentOrElse(surveyService::setSurvey,
                ()-> log.info("X- No Survey id: " + id.toString()));

        Optional<Guest_Survey_Creator> guest_survey_creator = guest_survey_creatorRepository.findById(surveyService.getSurvey().getId());
        guestRepository.findById(guest_survey_creator.get().getId_guest()).ifPresentOrElse(surveyService::setGuest,
                ()-> log.info("X- No Guest id: " + guest_survey_creator.get().getId_guest().toString()));

        List<Survey_Question> survey_questions  = survey_questionRepository.findAllBySurveyId(surveyService.getSurvey().getId());
        log.info(shortDateObjectMapper.writeValueAsString(survey_questions));

        List<Question> questions = new ArrayList<>();
        for(Survey_Question survey_question : survey_questions){
            questionRepository.findById(survey_question.getId_question()).ifPresent(
                    questions::add);
//            Choice choice = choiceRepository.findById(id);
        }
//        log.info(shortDateObjectMapper.writeValueAsString(questions));
        List<Choice> choices = new ArrayList<>();
        List<Slider> sliders = new ArrayList<>();
        List<Rating> ratings = new ArrayList<>();
        List<Scale> scales = new ArrayList<>();
        for(Question question : questions){
            choices.add(question);
        }
        surveyService.setChoices(choices);
        surveyService.setRatings(ratings);
        surveyService.setScales(scales);
        surveyService.setSliders(sliders);

        surveyService.setQuestions();
        log.info(shortDateObjectMapper.writeValueAsString(surveyService));
        return surveyService;
    }
}
