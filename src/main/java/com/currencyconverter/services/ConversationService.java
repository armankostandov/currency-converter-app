package com.currencyconverter.services;

import com.currencyconverter.model.Conversation;
import com.currencyconverter.model.User;

import java.time.LocalDate;
import java.util.List;

public interface ConversationService extends CrudService<Conversation, Long> {

    List<Conversation> findAllByDateIsBetweenAndUserOrderByDate(
            LocalDate dateStarting, LocalDate dateEnding, User user);

    List<Conversation> findAllByUser(User user);
}
