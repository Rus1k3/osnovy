package com.example.vnatyre_blen;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CategoryRepository {
    private final Map<String, BookCategory> categories = new HashMap<>();

    private final BookCategory fantasyCategory;
    private final BookCategory horrorCategory;
    private final BookCategory scifiCategory;

    @Autowired
    public CategoryRepository(
            @Qualifier("fantasyCategory") BookCategory fantasyCategory,
            @Qualifier("horrorCategory") BookCategory horrorCategory,
            @Qualifier("scifiCategory") BookCategory scifiCategory) {
        this.fantasyCategory = fantasyCategory;
        this.horrorCategory = horrorCategory;
        this.scifiCategory = scifiCategory;
    }

    @PostConstruct
    public void init() {
        categories.put("fantasy", fantasyCategory);
        categories.put("horror", horrorCategory);
        categories.put("scifi", scifiCategory);
    }

    public void addCategory(String name) {
        categories.put(name.toLowerCase(), new CustomCategory(name));
    }

    public void updateCategory(String oldName, String newName) {
        BookCategory category = categories.remove(oldName.toLowerCase());
        if (category != null) {
            categories.put(newName.toLowerCase(), new CustomCategory(newName));
        }
    }

    public void deleteCategory(String name) {
        categories.remove(name.toLowerCase());
    }

    public BookCategory getCategory(String name) {
        return categories.get(name.toLowerCase());
    }

    public Map<String, BookCategory> getAllCategories() {
        return new HashMap<>(categories);
    }

    public List<BookCategory> filterByMinNameLength(int minLength) {
        return categories.values().stream()
                .filter(category -> category.getName().length() >= minLength)
                .collect(Collectors.toList());
    }
}