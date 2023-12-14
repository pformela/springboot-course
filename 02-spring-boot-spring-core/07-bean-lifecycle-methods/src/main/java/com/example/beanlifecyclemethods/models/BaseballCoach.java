package com.example.beanlifecyclemethods.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("baseballCoach")
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor: " + this.getClass().getName());
    }

    @PostConstruct
    public void doStartupStuff() {
        System.out.println("In doStartupStuff: " + this.getClass().getSimpleName());
    }

    // not called for prototype scope
    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("In doCleanupStuff: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
