package com.PZ.AnkietBud.controllers.subQuestion;

import com.PZ.AnkietBud.classes.subQuestion.Choice;
import com.PZ.AnkietBud.configuration.ShortDateObjectMapper;
import com.PZ.AnkietBud.repositories.subQuestion.ChoiceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/choice")
@CrossOrigin
public class ChoiceController {

    @Autowired
    private ChoiceRepository choiceRepository;
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Choice addChoice(@RequestBody Choice choice) throws JsonProcessingException {
        Choice choiceNew = choice;
        choiceRepository.save(choiceNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(choiceNew));
        return choiceNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Choice> getAllChoice() throws JsonProcessingException {
        List<Choice> choices = choiceRepository.findAll();
        for (Choice item : choices) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        return choices;
    }

    @GetMapping("/get/{id}")
    public Choice getChoice(@PathVariable("id") Integer id) throws JsonProcessingException {
        Choice choice = choiceRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(choice));
        return choice;
    }

    @GetMapping("/delete/{id}")
    public String deleteChoice(@PathVariable("id") Integer id) throws JsonProcessingException {
        Choice choice = choiceRepository.findById(id);
        choiceRepository.delete(choice);
        System.out.println(shortDateObjectMapper.writeValueAsString(choice));
        return "x--- Deleted: "+ shortDateObjectMapper.writeValueAsString(choice);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Choice updateChoice(@RequestBody Choice choice) throws JsonProcessingException {
        Choice choiceUpdated = choice;
        choiceRepository.save(choiceUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(choiceUpdated));
        return choiceUpdated;
    }
}