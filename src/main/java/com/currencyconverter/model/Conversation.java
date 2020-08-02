package com.currencyconverter.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "conversations")
public class Conversation extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "in_currency_code", referencedColumnName = "code")
    private Currency inCurrency;

    @OneToOne
    @JoinColumn(name = "out_currency_code", referencedColumnName = "code")
    private Currency outCurrency;

    @Column(name = "in_value")
    private Double inValue;

    @Column(name = "out_value")
    private Double outValue;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Conversation() {
    }

    public Conversation(Currency inCurrency, Currency outCurrency,
                        Double inValue, Double outValue) {
        this.inCurrency = inCurrency;
        this.outCurrency = outCurrency;
        this.inValue = inValue;
        this.outValue = outValue;
        this.date = LocalDate.now();
    }

    public Conversation(Currency inCurrency, Currency outCurrency,
                        Double inValue, Double outValue, LocalDate date) {
        this.inCurrency = inCurrency;
        this.outCurrency = outCurrency;
        this.inValue = inValue;
        this.outValue = outValue;
        this.date = date;
    }

    public Currency getInCurrency() {
        return inCurrency;
    }

    public void setInCurrency(Currency inCurrency) {
        this.inCurrency = inCurrency;
    }

    public Currency getOutCurrency() {
        return outCurrency;
    }

    public void setOutCurrency(Currency outCurrency) {
        this.outCurrency = outCurrency;
    }

    public Double getInValue() {
        return inValue;
    }

    public void setInValue(Double inValue) {
        this.inValue = inValue;
    }

    public Double getOutValue() {
        return outValue;
    }

    public void setOutValue(Double outValue) {
        this.outValue = outValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
