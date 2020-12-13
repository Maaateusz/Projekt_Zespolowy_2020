package com.PZ.AnkietBud.database;

import com.PZ.AnkietBud.AnkietBudApplication;
import com.PZ.AnkietBud.TMP.Customer;
import com.PZ.AnkietBud.TMP.Customer2;
import com.PZ.AnkietBud.TMP.Customer2Repository;
import com.PZ.AnkietBud.classes.Guest;
import com.PZ.AnkietBud.classes.Question;
import com.PZ.AnkietBud.classes.Survey;
import com.PZ.AnkietBud.classes.subQuestion.Choice;
import com.PZ.AnkietBud.classes.subQuestion.Rating;
import com.PZ.AnkietBud.classes.subQuestion.Scale;
import com.PZ.AnkietBud.classes.subQuestion.Slider;
import com.PZ.AnkietBud.repositories.GuestRepository;
import com.PZ.AnkietBud.repositories.QuestionRepository;
import com.PZ.AnkietBud.repositories.SurveyRepository;
import com.PZ.AnkietBud.repositories.subQuestion.ChoiceRepository;
import com.PZ.AnkietBud.repositories.subQuestion.RatingRepository;
import com.PZ.AnkietBud.repositories.subQuestion.ScaleRepository;
import com.PZ.AnkietBud.repositories.subQuestion.SliderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;

//set database before the server starts
@Component
public class DatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger(AnkietBudApplication.class);

//    triggered after bean creation, but before the server starts
    @EventListener(ContextRefreshedEvent.class)
    public void onStart() throws Exception {
        System.out.println("| | /------------------------------------------------------------------------------------");
        System.out.println("|_|/");
//        System.out.println("Hello world, server have just started up");
//        log.info("Hello world, server have just started up");
        setDB();
    }

//    @Value("${spring.datasource.url}")
//    private String dbUrl;

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

    private void setDB() throws JsonProcessingException {
//        surveyRepository.save(new Survey("Ankieta_1", "Opis_1", Survey.Status.open, LocalDateTime.now(), LocalDateTime.now()));
//        guestRepository.save(new Guest("ID93dp81j9o238jd29p8jdp32"));
//        choiceRepository.save(new Choice("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, new ArrayList<>(List.of("pytanie_1", "pytanie_2", "pytanie_3")), Choice.Type.single));
//        ratingRepository.save(new Rating("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, 1, 6, Rating.Type.stars));
//        scaleRepository.save(new Scale("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, "left", "right", "center", 1, 10));
//        sliderRepository.save(new Slider("Opis_1", new ArrayList<>(List.of(100, 20, 3)), 123, 10, 100, 10));
//        questionRepository.save(new Choice("Choice content", new ArrayList<>(List.of(1, 2, 3)), 6, new ArrayList<>(List.of("3v21", "54v3", "c12c3")), Choice.Type.multiple));

        List<Survey> surveys = surveyRepository.findAll();
        for (Survey item : surveys) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }

        List<Guest> guests = guestRepository.findAll();
        for (Guest item : guests) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }

        Iterable<Choice> choices = choiceRepository.findAll();
        for (Choice item : choices) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }

        Iterable<Rating> ratings = ratingRepository.findAll();
        for (Rating item : ratings) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }

        Iterable<Scale> scales = scaleRepository.findAll();
        for (Scale item : scales) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }

        Iterable<Slider> sliders = sliderRepository.findAll();
        for (Slider item : sliders) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }

        Choice c = choiceRepository.findById(3);
        System.out.println(shortDateObjectMapper.writeValueAsString(c));

//        Question q = questionRepository.findById(3);
//        System.out.println(objectMapper.writeValueAsString(q));

//        List<Question> ratings = ratingRepository.findAll();
//        for (Question item : ratings) {
//            System.out.println(item);
//        }

//        Iterable<Question> questions = questionRepository.findAll();
//        for (Question item : questions) {
//            System.out.println(item);
//        }

    }

}
