package com.PZ.AnkietBud.controllers.subQuestion;

import com.PZ.AnkietBud.classes.subQuestion.Slider;
import com.PZ.AnkietBud.configuration.ShortDateObjectMapper;
import com.PZ.AnkietBud.repositories.subQuestion.SliderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/slider")
@CrossOrigin
public class SliderController {

    @Autowired
    private SliderRepository sliderRepository;
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Slider addSlider(@RequestBody Slider slider) throws JsonProcessingException {
        Slider sliderNew = slider;
        sliderRepository.save(sliderNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(sliderNew));
        return sliderNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Slider> getAllSlider() throws JsonProcessingException {
        List<Slider> sliders = sliderRepository.findAll();
        for (Slider item : sliders) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        return sliders;
    }

    @GetMapping("/get/{id}")
    public Slider getSlider(@PathVariable("id") Integer id) throws JsonProcessingException {
        Slider slider = sliderRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(slider));
        return slider;
    }

    @GetMapping("/delete/{id}")
    public String deleteSlider(@PathVariable("id") Integer id) throws JsonProcessingException {
        Slider slider = sliderRepository.findById(id);
        sliderRepository.delete(slider);
        System.out.println(shortDateObjectMapper.writeValueAsString(slider));
        return "x--- Deleted: "+ shortDateObjectMapper.writeValueAsString(slider);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Slider updateSlider(@RequestBody Slider slider) throws JsonProcessingException {
        Slider sliderUpdated = slider;
        sliderRepository.save(sliderUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(sliderUpdated));
        return sliderUpdated;
    }
}
