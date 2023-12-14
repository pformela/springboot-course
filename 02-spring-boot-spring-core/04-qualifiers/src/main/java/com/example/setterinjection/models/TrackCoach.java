package com.example.setterinjection.models;

import org.springframework.stereotype.Component;

@Component("trackCoach")
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
