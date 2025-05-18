package com.example.vnatyre_blen;

public class BookCategoryViewer {
    private BookCategory category;
    private String displayPrefix;

    public BookCategoryViewer(BookCategory category) {
        this.category = category;
    }

    public void setDisplayPrefix(String displayPrefix) {
        this.displayPrefix = displayPrefix;
    }

    public String getDisplayPrefix() {
        return displayPrefix;
    }

    public void displayCategory(BookCategory category) {
        System.out.println(displayPrefix + category.getName());
    }

    public void init() {
        System.out.println("Инициализация BookCategoryViewer с категорией: " + category.getName());
    }

    public void cleanup() {
        System.out.println("Очистка BookCategoryViewer для категории: " + category.getName());
    }
}