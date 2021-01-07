package com.pz.ankietBud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pz.ankietBud.configuration.ShortDateObjectMapper;
import com.pz.ankietBud.model.Guest;
import com.pz.ankietBud.repository.GuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest")
@CrossOrigin
public class GuestController {

    private static final Logger log = LoggerFactory.getLogger(GuestController.class);
    private final ShortDateObjectMapper shortDateObjectMapper = new ShortDateObjectMapper();
    @Autowired
    private GuestRepository guestRepository;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Guest addGuest(@RequestBody Guest guest, HttpServletRequest request) throws JsonProcessingException {
        String userIdentifier = Guest.getUserIdentifier(request);

//        guestRepository.findByIdentifier(guestNew.getIdentifier()).ifPresentOrElse(
        guestRepository.findByIdentifier(userIdentifier).ifPresentOrElse(
                x -> {
                    guest.setId(x.getId());
                    guest.setIdentifier(x.getIdentifier());
                    log.info("Guest already exist");
                },
                () -> {
                    guest.setIdentifier(userIdentifier);
                    guestRepository.save(guest);
                    log.info("Adding new Guest");
                }
        );

        log.info(shortDateObjectMapper.writeValueAsString(guest));
        return guest;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Guest> getAllGuest() throws JsonProcessingException {
        List<Guest> guests = guestRepository.findAll();
        for (Guest item : guests) {
            log.info(shortDateObjectMapper.writeValueAsString(item));
        }
        return guests;
    }

    @GetMapping("/get/{id}")
    public Optional<Guest> getGuest(@PathVariable("id") Long id) throws JsonProcessingException {
        Optional<Guest> guest = guestRepository.findById(id);
        log.info(shortDateObjectMapper.writeValueAsString(guest));
        return guest;
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteGuest(@PathVariable("id") Long id) throws JsonProcessingException {
//        guestRepository.findById(id).map(guest -> {
//            guestRepository.delete(guest);
//            try {
//                return shortDateObjectMapper.writeValueAsString(guest);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            return "guest";
//        }).orElseThrow(() -> new MyResourceNotFoundException("Guest not found!"));
//        return "guest???";
//    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Guest updateGuest(@RequestBody Guest guest) throws JsonProcessingException {
        guestRepository.save(guest);
        log.info(shortDateObjectMapper.writeValueAsString(guest));
        return guest;
    }
}
