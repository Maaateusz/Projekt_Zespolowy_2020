package com.pz.ankietBud.controller.subQuestion;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.repository.subQuestion.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question/rating")
@CrossOrigin
public class RatingController {

    private static final Logger log = LoggerFactory.getLogger(RatingController.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Rating addRating(@RequestBody Rating rating) throws JsonProcessingException {
        Rating ratingNew = rating;
        ratingRepository.save(ratingNew);
        log.info(shortDateObjectMapper.writeValueAsString(ratingNew));
        return ratingNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Rating> getAllRating() throws JsonProcessingException {
        List<Rating> ratings = ratingRepository.findAll();
        for (Rating item : ratings) {
            log.info(shortDateObjectMapper.writeValueAsString(item));
        }
        return ratings;
    }

    @GetMapping("/get/{id}")
    public Optional<Rating> getRating(@PathVariable("id") Long id) throws JsonProcessingException {
        Optional<Rating> rating = ratingRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(rating));
        return rating;
    }

    @GetMapping("/delete/{id}")
    public String deleteRating(@PathVariable("id") Long id) throws JsonProcessingException {
        ratingRepository.findById(id).ifPresent(x -> ratingRepository.delete(x));
//        log.info(shortDateObjectMapper.writeValueAsString(rating));
//        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(rating);
        return "x--- Deleted Rating";
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Rating updateRating(@RequestBody Rating rating) throws JsonProcessingException {
        Rating ratingUpdated = rating;
        ratingRepository.save(ratingUpdated);
        log.info(shortDateObjectMapper.writeValueAsString(ratingUpdated));
        return ratingUpdated;
    }
}
