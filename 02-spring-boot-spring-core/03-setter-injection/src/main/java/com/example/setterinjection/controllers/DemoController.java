package com.example.setterinjection.controllers;

import com.example.setterinjection.models.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // field injection is not recommended
    private Coach myCoach;

    // any method name works
    @Autowired
    public void setMyCoach(Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
