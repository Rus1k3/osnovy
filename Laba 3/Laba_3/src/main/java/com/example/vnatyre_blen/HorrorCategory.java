package com.example.vnatyre_blen;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("horrorCategory")
public class HorrorCategory implements BookCategory {
    public String getName() {
        return "Хоррор";
    }

    @PostConstruct
    public void init() {
        System.out.println("Инициализация HorrorCategory");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Очистка HorrorCategory");
    }
}