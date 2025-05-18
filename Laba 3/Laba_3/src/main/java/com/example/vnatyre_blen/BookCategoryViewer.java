package com.example.vnatyre_blen;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BookCategoryViewer {
    private BookCategory category;

    @Value("Книга в жанре: ")
    private String displayPrefix;

    @Autowired
    public BookCategoryViewer(@Qualifier("fantasyCategory") BookCategory category) {
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

    @PostConstruct
    public void init() {
        System.out.println("Инициализация BookCategoryViewer с категорией: " + category.getName());
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Очистка BookCategoryViewer для категории: " + category.getName());
    }
}