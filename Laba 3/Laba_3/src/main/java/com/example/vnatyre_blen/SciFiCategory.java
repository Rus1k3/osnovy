package com.example.vnatyre_blen;

public class SciFiCategory implements BookCategory {
    public String getName() {
        return "Научная фантастика";
    }    
    
    public void init() {
        System.out.println("Инициализация SciFiCategory");
    }

    public void cleanup() {
        System.out.println("Очистка SciFiCategory");
    }


}