package com.example.lazyinitialization.models;

import org.springframework.stereotype.Component;

@Component("trackCoach")
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
