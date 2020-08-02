package com.currencyconverter.repositories;

import com.currencyconverter.model.Conversation;
import com.currencyconverter.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long> {

    List<Conversation> findAllByDateIsBetweenAndUserOrderByDate(
            LocalDate dateStarting, LocalDate dateEnding, User user);

    List<Conversation> findAllByUser(User user);
}
