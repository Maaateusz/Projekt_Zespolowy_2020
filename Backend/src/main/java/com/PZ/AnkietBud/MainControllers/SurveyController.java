package com.PZ.AnkietBud.MainControllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

    @GetMapping("/get")
    public String getSurvey()
    {
        return "Hello from AnkietBud/survey/get";
    }

    @PostMapping("/set")
    public String setSurvey()
    {
        return "Hello from AnkietBud/survey/set";
    }

}
