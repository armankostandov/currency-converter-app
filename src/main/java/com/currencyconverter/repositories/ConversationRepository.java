package com.currencyconverter.repositories;

import com.currencyconverter.model.Conversation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long> {

    List<Conversation> findConversationByDateBetweenOrderByDate(
            LocalDate dateStarting, LocalDate dateEnding);
}
