package com.example.vnatyre_blen;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("scifiCategory")
public class SciFiCategory implements BookCategory {
    public String getName() {
        return "Научная фантастика";
    }

    @PostConstruct
    public void init() {
        System.out.println("Инициализация SciFiCategory");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Очистка SciFiCategory");
    }
}