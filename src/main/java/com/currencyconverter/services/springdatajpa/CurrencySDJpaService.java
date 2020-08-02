package com.currencyconverter.services.springdatajpa;

import com.currencyconverter.model.Currency;
import com.currencyconverter.repositories.CurrencyRepository;
import com.currencyconverter.services.CurrencyParserService;
import com.currencyconverter.services.CurrencyService;
import org.springframework.stereotype.Service;

import javax.xml.xpath.XPathExpressionException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class CurrencySDJpaService implements CurrencyService {

    CurrencyRepository currencyRepository;

    public CurrencySDJpaService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency findById(String code) {
        return currencyRepository.findById(code).orElse(null);
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
    public void deleteById(String code) {
        currencyRepository.deleteById(code);
    }

    @Override
    public Set<Currency> findAll() {
        Set<Currency> currencies = new HashSet<>();
        currencyRepository.findAll().forEach(currencies::add);
        return currencies;
    }

    @Override
    public Integer updateCurrencyValues() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(formatter);
        Set<Currency> currencies = new HashSet<>();
        try {
            currencies = CurrencyParserService.getCurrency(
                    "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        currencies.forEach(currency -> currencyRepository.save(currency));
        return currencies.size();
    }

}
