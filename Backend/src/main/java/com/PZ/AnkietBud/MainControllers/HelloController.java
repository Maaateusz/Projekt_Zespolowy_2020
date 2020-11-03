package com.PZ.AnkietBud.MainControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    http://localhost:8080/
    @RequestMapping("/")
    public String index() {
        return "Hello from AnkietBud!";
    }

}
