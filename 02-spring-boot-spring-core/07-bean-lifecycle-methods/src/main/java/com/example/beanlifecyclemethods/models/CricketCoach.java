package com.example.beanlifecyclemethods.models;

import org.springframework.stereotype.Component;

@Component("cricketCoach")

public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
