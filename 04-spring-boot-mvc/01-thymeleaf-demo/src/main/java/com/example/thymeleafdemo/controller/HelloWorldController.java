package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HelloWorldController {

    @GetMapping("/show-form")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/process-form")
    public String processForm(Model model) {
        model.addAttribute("theDate", new Date());

        return "helloworld";
    }

    @GetMapping("/process-form-2")
    public String processForm2(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        String message = "Hello, "  + studentName.toUpperCase() + "!";

        model.addAttribute("message", message);
        model.addAttribute("theDate", new Date());

        return "helloworld";
    }

    @PostMapping("/process-form-3")
    public String processForm3(@RequestParam("studentName") String studentName, Model model) {
        String message = "Hello, "  + studentName.toUpperCase() + "!";

        model.addAttribute("message", message);
        model.addAttribute("theDate", new Date());

        return "helloworld";
    }
}
