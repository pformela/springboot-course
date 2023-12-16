package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class StudentController {

    @Value("${countries}")
    ArrayList<String> countries;

    @Value("${languages}")
    ArrayList<String> languages;

    @Value("${operating_systems}")
    ArrayList<String> operatingSystems;

    @GetMapping("/show-student-form")
    public String showForm(Model model) {
        Student newStudent = new Student();

        model.addAttribute("student", newStudent);
        model.addAttribute("countries", this.countries);
        model.addAttribute("languages", this.languages);
        model.addAttribute("operatingSystems", this.operatingSystems);

        return "student-form";
    }

    @PostMapping("/process-student-form")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println(student);

        return "student-confirmation";
    }

}
