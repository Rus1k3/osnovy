package com.example.vnatyre_blen;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("fantasyCategory")
public class FantasyCategory implements BookCategory {
    public String getName() {
        return "Фэнтези";
    }

    @PostConstruct
    public void init() {
        System.out.println("Инициализация FantasyCategory");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Очистка FantasyCategory");
    }
}