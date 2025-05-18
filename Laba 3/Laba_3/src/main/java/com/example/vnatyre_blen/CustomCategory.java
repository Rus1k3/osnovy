package com.example.vnatyre_blen;

public class CustomCategory implements BookCategory {
    private final String name;

    public CustomCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}