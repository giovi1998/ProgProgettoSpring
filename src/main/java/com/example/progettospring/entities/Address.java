package com.example.progettospring.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Address {

    private String name;
    private Integer number;

    public Address(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Address setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Address setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
