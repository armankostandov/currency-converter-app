package com.currencyconverter.services;

import com.currencyconverter.model.Conversation;

import java.time.LocalDate;
import java.util.List;

public interface ConversationService extends CrudService<Conversation, Long> {

    List<Conversation> findConversationByDateBetweenOrderByDate(
            LocalDate dateStarting, LocalDate dateEnding);
}
