package com.example.setterinjection.models;

import org.springframework.stereotype.Component;

@Component("baseballCoach")
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
