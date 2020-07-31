package com.currencyconverter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "currencies")
public class Currency extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
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
}
