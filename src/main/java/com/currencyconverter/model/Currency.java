package com.currencyconverter.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "currencies")
public class Currency {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "value")
    private Double value;

    @Column(name = "nominal")
    private Integer nominal;

    @Column(name = "date")
    private LocalDate date;


    public Currency(String name, String code, Double value, Integer nominal, LocalDate date) {
        this.name = name;
        this.code = code;
        this.value = value;
        this.nominal = nominal;
        this.date = date;
    }

    public Currency(String name, String code, Double value, Integer nominal) {
        this.name = name;
        this.code = code;
        this.value = value;
        this.nominal = nominal;
        this.date = LocalDate.now();
    }

    public Currency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", value=" + value +
                ", nominal=" + nominal +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) &&
                Objects.equals(code, currency.code) &&
                Objects.equals(value, currency.value) &&
                Objects.equals(nominal, currency.nominal) &&
                Objects.equals(date, currency.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, value, nominal, date);
    }
}
