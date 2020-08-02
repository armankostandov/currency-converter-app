package com.currencyconverter.services.springdatajpa;

import com.currencyconverter.model.Conversation;
import com.currencyconverter.repositories.ConversationRepository;
import com.currencyconverter.services.ConversationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ConversationSDJpaService implements ConversationService {

    ConversationRepository conversationRepository;

    public ConversationSDJpaService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public Conversation findById(Long aLong) {
        return conversationRepository.findById(aLong).orElse(null);
    }

    @Override
    public Conversation save(Conversation object) {
        return conversationRepository.save(object);
    }

    @Override
    public void delete(Conversation object) {
        conversationRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        conversationRepository.deleteById(aLong);
    }

    @Override
    public Set<Conversation> findAll() {
        Set<Conversation> conversations = new HashSet<>();
        conversationRepository.findAll().forEach(conversations::add);
        return conversations;
    }

    @Override
    public List<Conversation> findConversationByDateBetweenOrderByDate(
            LocalDate dateStarting, LocalDate dateEnding) {
        return conversationRepository.findConversationByDateBetweenOrderByDate(
                dateStarting, dateEnding);
    }
}
