package com.currencyconverter.services;

import com.currencyconverter.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<User, Long>, UserDetailsService {

    User findByUsername(String username);
}
