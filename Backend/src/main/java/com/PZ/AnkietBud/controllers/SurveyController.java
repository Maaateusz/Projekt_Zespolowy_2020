package com.PZ.AnkietBud.controllers;

import com.PZ.AnkietBud.classes.Survey;
import com.PZ.AnkietBud.repositories.SurveyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/set", consumes = "application/json", produces = "application/json")
//    @GetMapping(value = "/set", consumes = "application/json", produces = "application/json")
    public Survey setSurvey(@RequestBody Map<String, String> object) throws JsonProcessingException {
//        Survey survey = new Survey(
//                object.get("name"),
//                object.get("description"),
//                Survey.Status.open,
//                LocalDateTime.now(),
//                LocalDateTime.parse(object.get("end_date")));
//        survey.setCreation_date(LocalDateTime.now());

        String s = "{\"id\":1,\"name\":\"Ankieta_1\",\"description\":\"Opis_1\",\"status\":\"open\",\"creation_date\":{\"month\":\"DECEMBER\",\"dayOfWeek\":\"FRIDAY\",\"dayOfYear\":346,\"nano\":821223000,\"year\":2020,\"monthValue\":12,\"dayOfMonth\":11,\"hour\":22,\"minute\":18,\"second\":39,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"end_date\":{\"month\":\"DECEMBER\",\"dayOfWeek\":\"FRIDAY\",\"dayOfYear\":346,\"nano\":822220000,\"year\":2020,\"monthValue\":12,\"dayOfMonth\":11,\"hour\":22,\"minute\":18,\"second\":39,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}}";
        Survey survey = objectMapper.readValue(s, Survey.class);
        System.out.println(objectMapper.writeValueAsString(survey));
        System.out.println(objectMapper.writeValueAsString(object));
        return survey;
    }

    @PostMapping(value = "/set2", consumes = "application/json", produces = "application/json")
    public Survey setSurvey(@RequestBody Survey survey) throws JsonProcessingException {
        Survey survey2 = survey;
        System.out.println(objectMapper.writeValueAsString(survey));
        System.out.println(objectMapper.writeValueAsString(survey2));
        return survey2;
    }

    @PostMapping(value = "/get", consumes = "application/json", produces = "application/json")
    public Survey getSurvey(@RequestBody Map<String, String> object)
    {
        Survey survey = new Survey();
        survey.setId(Integer.parseInt(object.get("id")));

        return survey;
    }

    @GetMapping(value = "/get", produces = "application/json")
    public Survey getSurvey2(@RequestParam String id)
    {
        Survey survey = new Survey();
        survey.setId(Integer.parseInt(id));

        return survey;
    }

    @GetMapping(value = "/{URL}", produces = "application/json")
    public Survey getSurveyURL(@PathVariable("URL") String URL)
    {
        Survey survey = new Survey();
        survey.setDescription(URL);
        return survey;
    }

//    Return id's of {number} surveys
    @GetMapping("/get/{number}")
    public List<Integer> getSurveys(@PathVariable("number") String number)
    {
        List<Integer> id = new ArrayList<>();
        for(int i=0; i < Integer.parseInt(number); i++){
            id.add(i);
        }
        return id;
    }

}
