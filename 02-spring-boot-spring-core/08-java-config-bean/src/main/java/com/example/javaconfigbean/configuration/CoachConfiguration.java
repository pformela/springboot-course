package com.example.javaconfigbean.configuration;

import com.example.javaconfigbean.models.Coach;
import com.example.javaconfigbean.models.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfiguration {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
