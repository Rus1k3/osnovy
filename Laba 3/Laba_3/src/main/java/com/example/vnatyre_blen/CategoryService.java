package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя категории не может быть пустым");
        }
        if (categoryRepository.getCategory(name.toLowerCase()) != null) {
            throw new IllegalArgumentException("Категория с именем уже существует: " + name);
        }
        categoryRepository.addCategory(name);
    }

    public void updateCategory(String oldName, String newName) {
        if (oldName == null || oldName.trim().isEmpty() || newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имена не могут быть пустыми");
        }
        if (categoryRepository.getCategory(oldName.toLowerCase()) == null) {
            throw new IllegalArgumentException("Категория не найдена: " + oldName);
        }
        if (categoryRepository.getCategory(newName.toLowerCase()) != null) {
            throw new IllegalArgumentException("Категория с именем уже существует: " + newName);
        }
        categoryRepository.updateCategory(oldName, newName);
    }

    public void deleteCategory(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (categoryRepository.getCategory(name.toLowerCase()) == null) {
            throw new IllegalArgumentException("Категория не найдена: " + name);
        }
        categoryRepository.deleteCategory(name);
    }

    public BookCategory getCategory(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        BookCategory category = categoryRepository.getCategory(name.toLowerCase());
        if (category == null) {
            throw new IllegalArgumentException("Категория не найдена: " + name);
        }
        return category;
    }

    public Map<String, BookCategory> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public List<BookCategory> filterByMinNameLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длина имени не может быть отрицательной");
        }
        return categoryRepository.filterByMinNameLength(minLength);
    }
}