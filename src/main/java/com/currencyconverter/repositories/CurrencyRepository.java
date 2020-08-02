package com.currencyconverter.repositories;

import com.currencyconverter.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {

}
