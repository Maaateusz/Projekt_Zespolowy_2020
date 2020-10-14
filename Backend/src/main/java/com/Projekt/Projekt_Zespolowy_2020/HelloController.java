package com.Projekt.Projekt_Zespolowy_2020;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Projekt_Zespolowy_2020";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}