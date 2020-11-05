package com.PZ.AnkietBud.MainControllers;

import com.PZ.AnkietBud.MainClasses.Survey;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

    @GetMapping("/get/{name}")
    public String getSurvey(@PathVariable(value = "name") String name)
    {
        Survey survey = new Survey();
        survey.setName(name);
        return survey.getName();
    }

    @PostMapping(value = "/set", consumes = "application/json", produces = "application/json")
//    @PostMapping("/set")
    public String setSurvey(@RequestBody Map<String, String> object)
    {
        Survey survey = new Survey(
                Integer.parseInt(object.get("id")),
                object.get("name"),
                object.get("description"),
                LocalDateTime.parse(object.get("creation_date")),
                LocalDateTime.parse(object.get("end_date")));
        return survey.toString();
    }

}
