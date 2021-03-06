package com.currencyconverter.services;

import com.currencyconverter.model.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.xpath.XPathExpressionException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class CurrencyParserServiceTest {


    @Test
    public void parser() throws XPathExpressionException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(formatter);
        Set<Currency> currencies = CurrencyParserService.getCurrency(
                "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);
        currencies.forEach(currency -> System.out.println(currency));
        System.out.println(currencies.size());
    }
}