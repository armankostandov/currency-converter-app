package com.currencyconverter.services;

import com.currencyconverter.model.Currency;

public interface CurrencyService extends CrudService<Currency, String> {

    Integer updateCurrencyValues();

}
