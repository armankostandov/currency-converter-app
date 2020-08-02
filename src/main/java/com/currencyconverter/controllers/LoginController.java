package com.currencyconverter.controllers;

import com.currencyconverter.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    CurrencyService currencyService;

    public LoginController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public String index(){
        if (currencyService.findAll().size() < 34) {
            currencyService.updateCurrencyValues();
        }
        return "redirect:/index";
    }
    @GetMapping
    public String login(){
        if (currencyService.findAll().size() < 34) {
            currencyService.updateCurrencyValues();
        }
        return "login";
    }

}
