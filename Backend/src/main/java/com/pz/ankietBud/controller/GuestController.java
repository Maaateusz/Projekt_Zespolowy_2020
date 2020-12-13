package com.pz.ankietBud.controller;

import com.pz.ankietBud.model.Guest;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.repository.GuestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
@CrossOrigin
public class GuestController {

    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private GuestRepository guestRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Guest addGuest(@RequestBody Guest guest) throws JsonProcessingException {
        Guest guestNew = guest;
//        guestRepository.save(guestNew);
        System.out.println(shortDateObjectMapper.writeValueAsString(guestNew));
        return guestNew;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Guest> getAllGuest() throws JsonProcessingException {
        List<Guest> guests = guestRepository.findAll();
        for (Guest item : guests) {
            System.out.println(shortDateObjectMapper.writeValueAsString(item));
        }
        return guests;
    }

    @GetMapping("/get/{id}")
    public Guest getGuest(@PathVariable("id") Integer id) throws JsonProcessingException {
        Guest guest = guestRepository.findById(id);
        System.out.println(shortDateObjectMapper.writeValueAsString(guest));
        return guest;
    }

    @GetMapping("/delete/{id}")
    public String deleteGuest(@PathVariable("id") Integer id) throws JsonProcessingException {
        Guest guest = guestRepository.findById(id);
//        guestRepository.delete(guest);
        System.out.println(shortDateObjectMapper.writeValueAsString(guest));
        return "x--- Deleted: " + shortDateObjectMapper.writeValueAsString(guest);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Guest updateGuest(@RequestBody Guest guest) throws JsonProcessingException {
        Guest guestUpdated = guest;
//        guestRepository.save(guestUpdated);
        System.out.println(shortDateObjectMapper.writeValueAsString(guestUpdated));
        return guestUpdated;
    }
}
