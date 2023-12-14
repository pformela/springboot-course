package com.example.devtoolsdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

    @GetMapping("/")
    public String getHome() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5 km!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }
}
