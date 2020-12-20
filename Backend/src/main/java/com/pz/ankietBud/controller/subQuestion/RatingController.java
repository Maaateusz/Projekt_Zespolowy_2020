package com.pz.ankietBud.controller.subQuestion;


import com.pz.ankietBud.model.subQuestion.Rating;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.repository.subQuestion.RatingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/rating")
@CrossOrigin
public class RatingController {

    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Rating addRating(@RequestBody Rating rating) throws JsonProcessingException {
        Rating ratingNew = rating;
        ratingRepository.save(ratingNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(ratingNew));
        return ratingNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Rating> getAllRating() throws JsonProcessingException {
        List<Rating> ratings = ratingRepository.findAll();
        for (Rating item : ratings) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        return ratings;
    }

    @GetMapping("/get/{id}")
    public Rating getRating(@PathVariable("id") Integer id) throws JsonProcessingException {
        Rating rating = ratingRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(rating));
        return rating;
    }

    @GetMapping("/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id) throws JsonProcessingException {
        Rating rating = ratingRepository.findById(id);
        ratingRepository.delete(rating);
        System.out.println(shortDateObjectMapper.writeValueAsString(rating));
        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(rating);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Rating updateRating(@RequestBody Rating rating) throws JsonProcessingException {
        Rating ratingUpdated = rating;
        ratingRepository.save(ratingUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(ratingUpdated));
        return ratingUpdated;
    }
}