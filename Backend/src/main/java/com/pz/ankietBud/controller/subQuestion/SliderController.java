package com.pz.ankietBud.controller.subQuestion;

import com.pz.ankietBud.controller.SurveyController;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.repository.subQuestion.SliderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/slider")
@CrossOrigin
public class SliderController {

    private static final Logger log = LoggerFactory.getLogger(SliderController.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private SliderRepository sliderRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Slider addSlider(@RequestBody Slider slider) throws JsonProcessingException {
        Slider sliderNew = slider;
        sliderRepository.save(sliderNew);
        log.info(shortDateObjectMapper.writeValueAsString(sliderNew));
        return sliderNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Slider> getAllSlider() throws JsonProcessingException {
        List<Slider> sliders = sliderRepository.findAll();
        for (Slider item : sliders) {
            log.info(shortDateObjectMapper.writeValueAsString(item));
        }
        return sliders;
    }

    @GetMapping("/get/{id}")
    public Slider getSlider(@PathVariable("id") Integer id) throws JsonProcessingException {
        Slider slider = sliderRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(slider));
        return slider;
    }

    @GetMapping("/delete/{id}")
    public String deleteSlider(@PathVariable("id") Integer id) throws JsonProcessingException {
        Slider slider = sliderRepository.findById(id);
        sliderRepository.delete(slider);
        log.info(shortDateObjectMapper.writeValueAsString(slider));
        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(slider);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Slider updateSlider(@RequestBody Slider slider) throws JsonProcessingException {
        Slider sliderUpdated = slider;
        sliderRepository.save(sliderUpdated);
        log.info(shortDateObjectMapper.writeValueAsString(sliderUpdated));
        return sliderUpdated;
    }
}
