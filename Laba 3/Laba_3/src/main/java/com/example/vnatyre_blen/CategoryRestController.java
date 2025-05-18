package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryRestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateCategory(
            @RequestParam("oldName") String oldName,
            @RequestParam("newName") String newName) {
        if (oldName == null || oldName.trim().isEmpty() || newName == null || newName.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Имена не могут быть пустыми");
        }
        if (categoryRepository.getCategory(oldName) == null) {
            return ResponseEntity.badRequest().body("Категория не найдена: " + oldName);
        }
        if (categoryRepository.getCategory(newName) != null) {
            return ResponseEntity.badRequest().body("Категория с именем уже существует: " + newName);
        }
        categoryRepository.updateCategory(oldName, newName);
        return ResponseEntity.ok("Категория обновлена: " + newName);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestParam("name") String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Имя не может быть пустым");
        }
        if (categoryRepository.getCategory(name) == null) {
            return ResponseEntity.badRequest().body("Категория не найдена: " + name);
        }
        categoryRepository.deleteCategory(name);
        return ResponseEntity.ok("Категория удалена: " + name);
    }
}