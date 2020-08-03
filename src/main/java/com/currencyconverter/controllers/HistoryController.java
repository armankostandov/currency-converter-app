package com.currencyconverter.controllers;

import com.currencyconverter.model.User;
import com.currencyconverter.services.ConversationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HistoryController {

    ConversationService conversationService;

    public HistoryController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @RequestMapping({"history", "history.html"})
    public String index(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("conversations", conversationService.findAllByUser(user));

        return "history";
    }

    @PostMapping("history")
    public String convert(@RequestParam String date_starting,
                          @RequestParam String date_ending,
                          Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dateStarting = LocalDate.parse(date_starting, formatter);
        LocalDate dateEnding = LocalDate.parse(date_ending, formatter);

        model.addAttribute("conversations",
                conversationService.findAllByDateIsBetweenAndUserOrderByDate(
                        dateStarting, dateEnding, user));

        return "history";
    }
}
