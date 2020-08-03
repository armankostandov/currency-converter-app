package com.currencyconverter.controllers;

import com.currencyconverter.model.Conversation;
import com.currencyconverter.model.Currency;
import com.currencyconverter.model.User;
import com.currencyconverter.services.ConversationService;
import com.currencyconverter.services.CurrencyService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class IndexController {

    CurrencyService currencyService;
    ConversationService conversationService;

    public IndexController(CurrencyService currencyService, ConversationService conversationService) {
        this.currencyService = currencyService;
        this.conversationService = conversationService;
    }


    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {

        model.addAttribute("currencies", currencyService.findAll());
        model.addAttribute("out_value", 0);

        return "index";
    }

    @PostMapping("convert")
    public String convert(@RequestParam String in_currency,
                          @RequestParam String out_currency,
                          @RequestParam String source_value,
                          Model model) {

        String inCurrencyCode = in_currency.split(" ")[0];
        String outCurrencyCode = out_currency.split(" ")[0];
        Double sourceValue = Double.parseDouble(source_value);

        Currency inCurrency = currencyService.findById(inCurrencyCode);
        Currency outCurrency = currencyService.findById(outCurrencyCode);

        Double outValue = sourceValue/inCurrency.getNominal()*
                inCurrency.getValue()*outCurrency.getNominal()/
                outCurrency.getValue();

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Conversation conversation = new Conversation();
        conversation.setInCurrency(inCurrency);
        conversation.setOutCurrency(outCurrency);
        conversation.setInValue(sourceValue);
        conversation.setOutValue(outValue);
        conversation.setDate(LocalDate.now());
        conversation.setUser(user);

        conversationService.save(conversation);

        model.addAttribute("currencies", currencyService.findAll());
        model.addAttribute("out_value", outValue);

        return "index";
    }
}

