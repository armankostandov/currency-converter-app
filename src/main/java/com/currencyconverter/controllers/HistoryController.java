package com.currencyconverter.controllers;

import com.currencyconverter.model.User;
import com.currencyconverter.services.ConversationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
