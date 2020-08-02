package com.currencyconverter.services.springdatajpa;

import com.currencyconverter.model.User;
import com.currencyconverter.repositories.UserRepository;
import com.currencyconverter.services.UserService;

import java.util.HashSet;
import java.util.Set;

public class UserSDJpaService implements UserService {

    UserRepository userRepository;

    public UserSDJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
