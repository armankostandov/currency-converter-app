package com.currencyconverter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String goHome(){
        return "redirect:/index";
    }
    @GetMapping
    public String loginPage(){
        return "login";
    }

}
