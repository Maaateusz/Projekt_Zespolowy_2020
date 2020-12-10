package com.PZ.AnkietBud.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey")
@CrossOrigin
public class SurveyController {

//    @PostMapping(value = "/set", consumes = "application/json", produces = "application/json")
//    public Survey setSurvey(@RequestBody Map<String, String> object)
//    {
//        Survey survey = new Survey(
//                object.get("name"),
//                object.get("description"),
//                Enum.Status.open,
//                LocalDateTime.now(),
//                LocalDateTime.parse(object.get("end_date")));
//
//        survey.setCreation_date(LocalDateTime.now());
////        Random rnd = new Random();
////        survey.setId(rnd.nextInt(9999));
//        return survey;
//    }
//
//    @PostMapping(value = "/get", consumes = "application/json", produces = "application/json")
//    public Survey getSurvey(@RequestBody Map<String, String> object)
//    {
//        Survey survey = new Survey();
//        survey.setId(Integer.parseInt(object.get("id")));
//
//        return survey;
//    }
//
//    @GetMapping(value = "/get", produces = "application/json")
//    public Survey getSurvey2(@RequestParam String id)
//    {
//        Survey survey = new Survey();
//        survey.setId(Integer.parseInt(id));
//
//        return survey;
//    }
//
//    @GetMapping(value = "/{URL}", produces = "application/json")
//    public Survey getSurveyURL(@PathVariable("URL") String URL)
//    {
//        Survey survey = new Survey();
//        survey.setDescription(URL);
//        return survey;
//    }
//
////    Return id's of {number} surveys
//    @GetMapping("/get/{number}")
//    public List<Integer> getSurveys(@PathVariable("number") String number)
//    {
//        List<Integer> id = new ArrayList<>();
//        for(int i=0; i < Integer.parseInt(number); i++){
//            id.add(i);
//        }
//        return id;
//    }

}
