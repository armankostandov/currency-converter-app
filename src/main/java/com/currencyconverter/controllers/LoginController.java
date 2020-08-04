package com.currencyconverter.controllers;

import com.currencyconverter.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    CurrencyService currencyService;

    public LoginController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public String index(){
        return "redirect:/index";
    }

    @GetMapping
    public String login(@RequestParam(defaultValue = "false") String error, Model model){

        if (Boolean.parseBoolean(error)) {
            model.addAttribute("message", "* Такого пользователя нет в базе");
        } else {
            model.addAttribute("message", "");
        }

        if (currencyService.findAll().size() < 34) {
            currencyService.updateCurrencyValues();
        }
        return "login";
    }

}
