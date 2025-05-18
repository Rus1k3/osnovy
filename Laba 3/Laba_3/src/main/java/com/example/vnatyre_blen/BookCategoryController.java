package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BookCategoryController {
    private final BookCategoryViewer viewer;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookCategoryController(BookCategoryViewer viewer, CategoryRepository categoryRepository) {
        this.viewer = viewer;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
        Map<String, String> categoryDisplays = new HashMap<>();
        categoryRepository.getAllCategories().forEach((key, category) ->
                categoryDisplays.put(key, viewer.getDisplayPrefix() + category.getName()));
        model.addAttribute("categoryDisplays", categoryDisplays);
        model.addAttribute("viewerPrefix", viewer.getDisplayPrefix());
        return "categories";
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam("first") int first,
            @RequestParam("second") int second,
            @RequestParam("operation") String operation,
            Model model) {
        String result;
        try {
            switch (operation.toLowerCase()) {
                case "add":
                    result = String.valueOf(first + second);
                    break;
                case "subtract":
                    result = String.valueOf(first - second);
                    break;
                case "multiply":
                    result = String.valueOf(first * second);
                    break;
                case "divide":
                    if (second == 0) {
                        throw new IllegalArgumentException("Деление на ноль невозможно");
                    }
                    result = String.valueOf((double) first / second);
                    break;
                default:
                    throw new IllegalArgumentException("Некорректная операция: " + operation);
            }
            model.addAttribute("result", result);
            model.addAttribute("first", first);
            model.addAttribute("second", second);
            model.addAttribute("operation", operation);
            model.addAttribute("error", null);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("result", null);
            model.addAttribute("first", first);
            model.addAttribute("second", second);
            model.addAttribute("operation", operation);
        }
        return "calculate";
    }

    @GetMapping("/categories/list")
    public String listCategories(Model model) {
        Map<String, String> categoryDisplays = new HashMap<>();
        categoryRepository.getAllCategories().forEach((key, category) ->
                categoryDisplays.put(key, viewer.getDisplayPrefix() + category.getName()));
        model.addAttribute("categories", categoryDisplays);
        return "category-list";
    }

    @GetMapping("/categories/detail")
    public String showCategoryDetail(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("error", "Параметр name не указан");
            model.addAttribute("category", null);
            return "category-detail";
        }
        BookCategory category = categoryRepository.getCategory(name);
        if (category == null) {
            model.addAttribute("error", "Категория не найдена: " + name);
            model.addAttribute("category", null);
        } else {
            model.addAttribute("category", Map.of("name", name, "displayName", viewer.getDisplayPrefix() + category.getName()));
            model.addAttribute("error", null);
        }
        return "category-detail";
    }

    @GetMapping("/categories/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("categoryName", "");
        return "category-add";
    }

    @PostMapping("/categories/add")
    public String addCategory(@RequestParam("name") String name, Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("error", "Название категории не может быть пустым");
            model.addAttribute("categoryName", "");
            return "category-add";
        }
        if (categoryRepository.getCategory(name.toLowerCase()) != null) {
            model.addAttribute("error", "Категория с таким именем уже существует");
            model.addAttribute("categoryName", name);
            return "category-add";
        }
        categoryRepository.addCategory(name);
        return "redirect:/categories/list";
    }

    @GetMapping("/categories/update")
    public String showUpdateCategoryForm(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name == null || name.trim().isEmpty() || categoryRepository.getCategory(name) == null) {
            model.addAttribute("error", name == null ? "Параметр name не указан" : "Категория не найдена: " + name);
            model.addAttribute("oldName", "");
            model.addAttribute("newName", "");
            return "category-update";
        }
        model.addAttribute("oldName", name);
        model.addAttribute("newName", categoryRepository.getCategory(name).getName());
        model.addAttribute("error", null);
        return "category-update";
    }

    @PostMapping("/categories/update")
    public String updateCategory(
            @RequestParam("oldName") String oldName,
            @RequestParam("newName") String newName,
            Model model) {
        if (oldName == null || oldName.trim().isEmpty() || newName == null || newName.trim().isEmpty()) {
            model.addAttribute("error", "Имена не могут быть пустыми");
            model.addAttribute("oldName", oldName);
            model.addAttribute("newName", newName);
            return "category-update";
        }
        if (categoryRepository.getCategory(oldName) == null) {
            model.addAttribute("error", "Категория не найдена: " + oldName);
            model.addAttribute("oldName", oldName);
            model.addAttribute("newName", newName);
            return "category-update";
        }
        if (categoryRepository.getCategory(newName) != null) {
            model.addAttribute("error", "Категория с именем уже существует: " + newName);
            model.addAttribute("oldName", oldName);
            model.addAttribute("newName", newName);
            return "category-update";
        }
        categoryRepository.updateCategory(oldName, newName);
        return "redirect:/categories/list";
    }

    @PostMapping("/categories/delete")
    public String deleteCategory(@RequestParam("name") String name, Model model) {
        if (name == null || name.trim().isEmpty()) {
            model.addAttribute("error", "Имя не может быть пустым");
            model.addAttribute("categories", new HashMap<>());
            return "category-list";
        }
        if (categoryRepository.getCategory(name) == null) {
            model.addAttribute("error", "Категория не найдена: " + name);
            model.addAttribute("categories", new HashMap<>());
            return "category-list";
        }
        categoryRepository.deleteCategory(name);
        return "redirect:/categories/list";
    }
}