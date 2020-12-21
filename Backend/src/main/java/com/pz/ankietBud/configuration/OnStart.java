package com.pz.ankietBud.configuration;

import com.pz.ankietBud.model.Guest;
import com.pz.ankietBud.model.Survey;
import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.GuestRepository;
import com.pz.ankietBud.repository.QuestionRepository;
import com.pz.ankietBud.repository.SurveyRepository;
import com.pz.ankietBud.repository.subQuestion.ChoiceRepository;
import com.pz.ankietBud.repository.subQuestion.RatingRepository;
import com.pz.ankietBud.repository.subQuestion.ScaleRepository;
import com.pz.ankietBud.repository.subQuestion.SliderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//set database before the server starts
@Component
public class OnStart {

    private static final Logger log = LoggerFactory.getLogger(OnStart.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();

//    @Value("${spring.datasource.url}")
//    private String dbUrl;
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

    //    triggered after bean creation, but before the server starts
    @EventListener(ContextRefreshedEvent.class)
    public void onStart() throws Exception {
        log.info("|   /------------------------------------------------------------------------------------");
        log.info("|  /");
        log.info("| /");
        log.info("|/");
        log.info("Server has started");

//        setDB();
    }

    private void setDB() throws JsonProcessingException {
        surveyRepository.save(new Survey("Ankieta_1", "Opis_1", Survey.Status.open, LocalDateTime.now(), LocalDateTime.now()));
        guestRepository.save(new Guest("ID93dp81j9o238jd29p8jdp32"));
        choiceRepository.save(new Choice("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, new ArrayList<>(List.of("pytanie_1", "pytanie_2", "pytanie_3")), Choice.Type.single));
        ratingRepository.save(new Rating("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, 1, 6, Rating.Type.stars));
        scaleRepository.save(new Scale("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, "left", "right", "center", 1, 10));
        sliderRepository.save(new Slider("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, 10, 100, 10));
//        questionRepository.save(new Choice("Opis_1", new ArrayList<>(List.of(1, 2, 3)), 6, new ArrayList<>(List.of("3v21", "54v3", "c12c3")), Choice.Type.multiple));

//        List<Survey> surveys = surveyRepository.findAll();
//        for (Survey item : surveys) {
//            log.info(shortDateObjectMapper.writeValueAsString(item));
//        }
//
//        List<Guest> guests = guestRepository.findAll();
//        for (Guest item : guests) {
//            log.info(shortDateObjectMapper.writeValueAsString(item));
//        }
//
//        Iterable<Choice> choices = choiceRepository.findAll();
//        for (Choice item : choices) {
//            log.info(shortDateObjectMapper.writeValueAsString(item));
//        }
//
//        Iterable<Rating> ratings = ratingRepository.findAll();
//        for (Rating item : ratings) {
//            log.info(shortDateObjectMapper.writeValueAsString(item));
//        }
//
//        Iterable<Scale> scales = scaleRepository.findAll();
//        for (Scale item : scales) {
//            log.info(shortDateObjectMapper.writeValueAsString(item));
//        }
//
//        Iterable<Slider> sliders = sliderRepository.findAll();
//        for (Slider item : sliders) {
//            log.info(shortDateObjectMapper.writeValueAsString(item));
//        }
//
//        Choice c = choiceRepository.findById(3);
//        log.info(shortDateObjectMapper.writeValueAsString(c));

//        Question q = questionRepository.findById(3);
//        log.info(objectMapper.writeValueAsString(q));

//        List<Question> ratings = ratingRepository.findAll();
//        for (Question item : ratings) {
//            log.info(item);
//        }

//        Iterable<Question> questions = questionRepository.findAll();
//        for (Question item : questions) {
//            log.info(item);
//        }

    }

}
