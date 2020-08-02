package com.currencyconverter.repositories;

import com.currencyconverter.model.Currency;
import com.currencyconverter.services.CurrencyService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CurrencyRepositoryTest {

    @Autowired
    CurrencyRepository currencyRepository;

    Currency currency1 = new Currency(
            "dollar", "USD", 76.89, 1, LocalDate.now());

    Currency currency2 = new Currency(
            "dram", "AMD", 15.03, 10, LocalDate.now());

/*    public CurrencyRepositoryTest(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }*/

    @BeforeEach
    void init() {
        currencyRepository.save(currency1);
        currencyRepository.save(currency2);
    }

    @Test
    void saveCurrency() {
        assertThat(currencyRepository.findById(1L).get()).isEqualTo(currency1);
        assertThat(currencyRepository.findById(2L).get()).isEqualTo(currency2);
    }

}