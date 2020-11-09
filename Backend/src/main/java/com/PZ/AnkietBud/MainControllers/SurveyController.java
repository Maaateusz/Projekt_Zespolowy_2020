package com.PZ.AnkietBud.MainControllers;

import com.PZ.AnkietBud.MainClasses.Survey;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

    @PostMapping(value = "/set", consumes = "application/json", produces = "application/json")
    public Survey setSurvey(@RequestBody Map<String, String> object)
    {
        Survey survey = new Survey(
                object.get("name"),
                object.get("description"),
                LocalDateTime.parse(object.get("end_date")));

        survey.setCreation_date(LocalDateTime.now());
        Random rnd = new Random();
        survey.setId(rnd.nextInt(9999));
        return survey;
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

}
