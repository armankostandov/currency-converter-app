package com.currencyconverter.controllers;

import com.currencyconverter.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    CurrencyService currencyService;

    public IndexController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {

        model.addAttribute("currencies", currencyService.findAll());
        return "index";

    }
}

