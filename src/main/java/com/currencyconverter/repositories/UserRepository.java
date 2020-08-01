package com.currencyconverter.repositories;

import com.currencyconverter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
