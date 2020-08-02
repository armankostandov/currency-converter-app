package com.currencyconverter.repositories;

import com.currencyconverter.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    Currency findCurrencyByCode(String code);

}
