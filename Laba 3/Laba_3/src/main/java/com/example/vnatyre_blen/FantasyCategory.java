package com.example.vnatyre_blen;

public class FantasyCategory implements BookCategory {
    public String getName() {
        return "Фэнтези";
    }

    public void init() {
        System.out.println("Инициализация FantasyCategory");
    }

    public void cleanup() {
        System.out.println("Очистка FantasyCategory");
    }
}