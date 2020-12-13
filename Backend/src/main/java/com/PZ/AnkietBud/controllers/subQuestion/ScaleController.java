package com.PZ.AnkietBud.controllers.subQuestion;


import com.PZ.AnkietBud.classes.subQuestion.Scale;
import com.PZ.AnkietBud.configuration.ShortDateObjectMapper;
import com.PZ.AnkietBud.repositories.subQuestion.ScaleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/scale")
@CrossOrigin
public class ScaleController {

    @Autowired
    private ScaleRepository scaleRepository;
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Scale addScale(@RequestBody Scale scale) throws JsonProcessingException {
        Scale scaleNew = scale;
        scaleRepository.save(scaleNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(scaleNew));
        return scaleNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Scale> getAllScale() throws JsonProcessingException {
        List<Scale> scales = scaleRepository.findAll();
        for (Scale item : scales) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        return scales;
    }

    @GetMapping("/get/{id}")
    public Scale getScale(@PathVariable("id") Integer id) throws JsonProcessingException {
        Scale scale = scaleRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(scale));
        return scale;
    }

    @GetMapping("/delete/{id}")
    public String deleteScale(@PathVariable("id") Integer id) throws JsonProcessingException {
        Scale scale = scaleRepository.findById(id);
        scaleRepository.delete(scale);
        System.out.println(shortDateObjectMapper.writeValueAsString(scale));
        return "x--- Deleted: "+ shortDateObjectMapper.writeValueAsString(scale);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Scale updateScale(@RequestBody Scale scale) throws JsonProcessingException {
        Scale scaleUpdated = scale;
        scaleRepository.save(scaleUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(scaleUpdated));
        return scaleUpdated;
    }
}
