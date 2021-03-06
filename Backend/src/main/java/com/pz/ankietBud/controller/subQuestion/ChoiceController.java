package com.pz.ankietBud.controller.subQuestion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.subQuestion.Choice;
import com.pz.ankietBud.repository.subQuestion.ChoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question/choice")
@CrossOrigin
public class ChoiceController {

    private static final Logger log = LoggerFactory.getLogger(ChoiceController.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private ChoiceRepository choiceRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Choice addChoice(@RequestBody Choice choice) throws JsonProcessingException {
        choiceRepository.save(choice);
        log.info(shortDateObjectMapper.writeValueAsString(choice));
        return choice;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Choice> getAllChoice() throws JsonProcessingException {
        List<Choice> choices = choiceRepository.findAll();
        for (Choice item : choices) {
            log.info(shortDateObjectMapper.writeValueAsString(item));
        }
        return choices;
    }

    @GetMapping("/get/{id}")
    public Optional<Choice> getChoice(@PathVariable("id") Long id) throws JsonProcessingException {
        Optional<Choice> choice = choiceRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(choice));
        return choice;
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteChoice(@PathVariable("id") Long id) throws JsonProcessingException {
//        choiceRepository.findById(id).ifPresent(x -> choiceRepository.delete(x));
////        log.info(shortDateObjectMapper.writeValueAsString(choice));
////        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(choice);
//        return "x--- Deleted Choice";
//    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Choice updateChoice(@RequestBody Choice choice) throws JsonProcessingException {
        choiceRepository.save(choice);
        log.info(shortDateObjectMapper.writeValueAsString(choice));
        return choice;
    }
}
