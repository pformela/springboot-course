package com.example.setterinjection.models;

import org.springframework.stereotype.Component;

@Component("cricketCoach")
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
