package com.pz.ankietBud.controller.subQuestion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.subQuestion.Slider;
import com.pz.ankietBud.repository.subQuestion.SliderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        sliderRepository.save(slider);
        log.info(shortDateObjectMapper.writeValueAsString(slider));
        return slider;
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
    public Optional<Slider> getSlider(@PathVariable("id") Long id) throws JsonProcessingException {
        Optional<Slider> slider = sliderRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(slider));
        return slider;
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteSlider(@PathVariable("id") Long id) throws JsonProcessingException {
//        sliderRepository.findById(id).ifPresent(x -> sliderRepository.delete(x));
////        log.info(shortDateObjectMapper.writeValueAsString(slider));
////        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(slider);
//        return "x--- Deleted Slider ";
//    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Slider updateSlider(@RequestBody Slider slider) throws JsonProcessingException {
        sliderRepository.save(slider);
        log.info(shortDateObjectMapper.writeValueAsString(slider));
        return slider;
    }
}
