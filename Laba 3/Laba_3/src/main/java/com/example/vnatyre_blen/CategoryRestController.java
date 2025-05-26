package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public ResponseEntity<String> addCategory(@RequestParam("name") String name) {
        try {
            categoryService.addCategory(name);
            return ResponseEntity.status(HttpStatus.CREATED).body("Категория добавлена: " + name);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка сервера");
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        try {
            return ResponseEntity.ok(categoryService.getAllCategories());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка сервера");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCategory(@PathVariable("name") String name) {
        try {
            BookCategory category = categoryService.getCategory(name);
            return ResponseEntity.ok(category);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка сервера");
        }
    }

    @PatchMapping("/{name}")
    public ResponseEntity<String> updateCategory(
            @PathVariable("name") String oldName,
            @RequestParam("newName") String newName) {
        try {
            categoryService.updateCategory(oldName, newName);
            return ResponseEntity.ok("Категория обновлена: " + newName);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка сервера");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteCategory(@PathVariable("name") String name) {
        try {
            categoryService.deleteCategory(name);
            return ResponseEntity.ok("Категория удалена: " + name);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка сервера");
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterCategories(@RequestParam(value = "minNameLength", defaultValue = "0") int minNameLength) {
        try {
            List<BookCategory> categories = categoryService.filterByMinNameLength(minNameLength);
            return ResponseEntity.ok(categories);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка сервера");
        }
    }
}