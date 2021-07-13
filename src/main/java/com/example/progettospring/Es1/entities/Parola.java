package com.example.progettospring.Es1.entities;

import java.util.Locale;

public class Parola {
    String parola;
    int lenght;

    public Parola(String parola, int lenght) {
        this.parola = parola;
        this.lenght = lenght;
    }

    public String getParola() {
        return parola.toUpperCase(Locale.ROOT);
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = parola.length();
    }
}
