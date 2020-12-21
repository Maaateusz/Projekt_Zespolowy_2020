package com.pz.ankietBud.controller.subQuestion;


import com.pz.ankietBud.controller.SurveyController;
import com.pz.ankietBud.model.subQuestion.Scale;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.repository.subQuestion.ScaleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/scale")
@CrossOrigin
public class ScaleController {

    private static final Logger log = LoggerFactory.getLogger(ScaleController.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private ScaleRepository scaleRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Scale addScale(@RequestBody Scale scale) throws JsonProcessingException {
        Scale scaleNew = scale;
        scaleRepository.save(scaleNew);
        log.info(shortDateObjectMapper.writeValueAsString(scaleNew));
        return scaleNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Scale> getAllScale() throws JsonProcessingException {
        List<Scale> scales = scaleRepository.findAll();
        for (Scale item : scales) {
            log.info(shortDateObjectMapper.writeValueAsString(item));
        }
        return scales;
    }

    @GetMapping("/get/{id}")
    public Scale getScale(@PathVariable("id") Integer id) throws JsonProcessingException {
        Scale scale = scaleRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(scale));
        return scale;
    }

    @GetMapping("/delete/{id}")
    public String deleteScale(@PathVariable("id") Integer id) throws JsonProcessingException {
        Scale scale = scaleRepository.findById(id);
        scaleRepository.delete(scale);
        log.info(shortDateObjectMapper.writeValueAsString(scale));
        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(scale);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Scale updateScale(@RequestBody Scale scale) throws JsonProcessingException {
        Scale scaleUpdated = scale;
        scaleRepository.save(scaleUpdated);
        log.info(shortDateObjectMapper.writeValueAsString(scaleUpdated));
        return scaleUpdated;
    }
}
