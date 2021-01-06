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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

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
    private Guest_Survey_ParticipateRepository guest_survey_participateRepository;
    @Autowired
    private Survey_QuestionRepository survey_questionRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public SurveyService createSurveyService(@RequestBody SurveyService surveyService, HttpServletRequest request) throws JsonProcessingException {

        Survey surveyNew = surveyService.getSurvey();
        surveyRepository.save(surveyNew);
        log.info(shortDateObjectMapper.writeValueAsString(surveyNew));

        //powinno dodać tylko jeśli nie istnieje!
        //guest dodawany przy odwiedzaniu strony!
        String userIdentifier = Guest.getUserIdentifier(request);
        Guest guestNew = new Guest();
//        if(guestNew.getId() == null) guestRepository.save(guestNew);
        guestRepository.findByIdentifier(userIdentifier).ifPresentOrElse(
                x -> {
                    guestNew.setId(x.getId());
                    guestNew.setIdentifier(x.getIdentifier());
                    surveyService.setGuest(guestNew);
                },
                () -> {
                    guestNew.setIdentifier(userIdentifier);
                    guestRepository.save(guestNew);
                    surveyService.setGuest(guestNew);
                }
        );

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
//        log.info(shortDateObjectMapper.writeValueAsString(surveyService.getQuestions()));

        log.info(shortDateObjectMapper.writeValueAsString(surveyService));
        return surveyService;
    }

    @GetMapping("/get/{id}")
    public SurveyService getSurveyService(@PathVariable("id") Long id) throws JsonProcessingException {

        SurveyService surveyService = new SurveyService();
        surveyRepository.findById(id).ifPresentOrElse(
                surveyService::setSurvey,
                () -> log.info("X- No Survey id: " + id.toString()));

        Optional<Guest_Survey_Creator> guest_survey_creator = guest_survey_creatorRepository.findById(surveyService.getSurvey().getId());
        guestRepository.findById(guest_survey_creator.get().getId_guest()).ifPresentOrElse(
                surveyService::setGuest,
                () -> log.info("X- No Guest id: " + guest_survey_creator.get().getId_guest().toString()));

        List<Survey_Question> survey_questions = survey_questionRepository.findAllBySurveyId(surveyService.getSurvey().getId());
        log.info(shortDateObjectMapper.writeValueAsString(survey_questions));

        List<Question> questions = new ArrayList<>();
        for (Survey_Question survey_question : survey_questions) {
            questionRepository.findById(survey_question.getId_question()).ifPresent(
                    questions::add);
//            Choice choice = choiceRepository.findById(id);
        }
//        log.info(shortDateObjectMapper.writeValueAsString(questions));
        List<Choice> choices = new ArrayList<>();
        List<Slider> sliders = new ArrayList<>();
        List<Rating> ratings = new ArrayList<>();
        List<Scale> scales = new ArrayList<>();
        for (Question question : questions) {
            if (question instanceof Choice) choices.add((Choice) question);
            if (question instanceof Slider) sliders.add((Slider) question);
            if (question instanceof Rating) ratings.add((Rating) question);
            if (question instanceof Scale) scales.add((Scale) question);
        }
        surveyService.setChoices(choices);
        surveyService.setRatings(ratings);
        surveyService.setScales(scales);
        surveyService.setSliders(sliders);

        surveyService.setQuestions();
        log.info(shortDateObjectMapper.writeValueAsString(surveyService));
        return surveyService;
    }

    @PostMapping(value = "/vote", consumes = "application/json", produces = "application/json")
    public SurveyService voteSurveyService(@RequestBody Vote vote, HttpServletRequest request) throws JsonProcessingException {

        AtomicBoolean isSurveyOK = new AtomicBoolean(true);

        surveyRepository.findById(vote.getId_survey()).ifPresentOrElse(
                x -> {},
                () -> {
                    log.info("X- No Survey id: " + vote.getId_survey().toString());
                    isSurveyOK.set(false);
                });

        if (!isSurveyOK.get()) return null;

        for (int i = 0; i<vote.getId_questions().size(); i++){
            final int answer_id = vote.getId_answers().get(i);
            questionRepository.findById(vote.getId_questions().get(i)).ifPresentOrElse(
                    question -> {
                        question.getVotes().set( answer_id, question.getVotes().get(answer_id) + 1L );
                        question.setSum(question.getSum() + 1L);
                        questionRepository.save(question);
                    },
                    () -> log.info("Error in Voting!"));
        }

        SurveyService surveyServiceFinal = getSurveyService(vote.getId_survey());

        surveyServiceFinal.setGuest(new Guest());
        String userIdentifier = Guest.getUserIdentifier(request);
        guestRepository.findByIdentifier(userIdentifier).ifPresentOrElse(
                x -> {
                    surveyServiceFinal.getGuest().setId(x.getId());
                    surveyServiceFinal.getGuest().setIdentifier(x.getIdentifier());
                },
                () -> {
                    surveyServiceFinal.getGuest().setIdentifier(userIdentifier);
                    guestRepository.save(surveyServiceFinal.getGuest());
                }
        );

        Guest_Survey_Participate guest_survey_participate = new Guest_Survey_Participate(surveyServiceFinal.getSurvey().getId(), surveyServiceFinal.getGuest().getId());
        guest_survey_participateRepository.findByOtherId(surveyServiceFinal.getSurvey().getId(), surveyServiceFinal.getGuest().getId()).ifPresentOrElse(
                x -> guest_survey_participate.setId(x.getId()),
                () -> guest_survey_participateRepository.save(guest_survey_participate)
        );

        return surveyServiceFinal;
    }
}
