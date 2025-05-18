package com.example.vnatyre_blen;

public class HorrorCategory implements BookCategory {
    public String getName() {
        return "Хоррор";
    }

    public void init() {
        System.out.println("Инициализация HorrorCategory");
    }

    public void cleanup() {
        System.out.println("Очистка HorrorCategory");
    }
}