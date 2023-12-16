package com.example.securitydemo.controller;

import com.example.securitydemo.entity.User;
import com.example.securitydemo.model.WebUser;
import com.example.securitydemo.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, ste);
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        WebUser webUser = new WebUser();

        model.addAttribute("webUser", webUser);

        return "registration-form";
    }

    @PostMapping("/register/save")
    public String processRegistrationForm(
            @Valid @ModelAttribute("webUser") WebUser webUser,
            BindingResult bindingResult,
            HttpSession session,
            Model model
    ) {
        String username = webUser.getUsername();
        System.out.println("Processing registration form for: " + username);

        if (bindingResult.hasErrors()) return "registration-form";

        User existing = userService.findByUsername(username);

        if (existing != null) {
            model.addAttribute("webUser", new WebUser());
            model.addAttribute("registrationError", "Username already exists.");

            System.out.println("Username already exists.");

            return "registration-form";
        }

        userService.save(webUser);

        System.out.println("Successfully created user: " + username);
        session.setAttribute("webUser", webUser);

        return "registration-confirmation";
    }

}
