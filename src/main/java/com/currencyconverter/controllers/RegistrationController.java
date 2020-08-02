package com.currencyconverter.controllers;

import com.currencyconverter.model.User;
import com.currencyconverter.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    @Transactional
    public String addUser(@RequestParam String username,
                          @RequestParam String password, Model model) {

        User userFromDB = userService.findByUsername(username);

        if (userFromDB != null) {
            model.addAttribute("message", "Пользователь c ником " +
                    username + " уже существует");
            return "registration";
        }
        else {
            model.addAttribute("message", "");
        }
        User user = new User(username, password);

        userService.save(user);
        return "redirect:/login";
    }
}
