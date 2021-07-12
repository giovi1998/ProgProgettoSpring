package com.example.progettospring.entities;


import java.util.UUID;

public class Company {
    private UUID id;
    private String name;

    public Company() {
        id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Company setId(UUID id) {
        this.id = id;
        return this;
    }
}
