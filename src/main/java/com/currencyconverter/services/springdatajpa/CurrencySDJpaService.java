package com.currencyconverter.services.springdatajpa;

import com.currencyconverter.model.Currency;
import com.currencyconverter.repositories.CurrencyRepository;
import com.currencyconverter.services.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CurrencySDJpaService implements CurrencyService {

    CurrencyRepository currencyRepository;

    public CurrencySDJpaService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency findCurrencyByCode(String code) {
        return currencyRepository.findCurrencyByCode(code);
    }

    @Override
    public Currency findById(Long aLong) {
        return currencyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Currency save(Currency object) {
        return currencyRepository.save(object);
    }

    @Override
    public void delete(Currency object) {
        currencyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        currencyRepository.deleteById(aLong);
    }

    @Override
    public Set<Currency> findAll() {
        Set<Currency> currencies = new HashSet<>();
        currencyRepository.findAll().forEach(currencies::add);
        return currencies;
    }
}
