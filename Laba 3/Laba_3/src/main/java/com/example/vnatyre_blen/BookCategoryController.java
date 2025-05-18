package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BookCategoryController {
    private final BookCategoryViewer viewer;
    private final BookCategory fantasyCategory;
    private final BookCategory horrorCategory;
    private final BookCategory scifiCategory;

    @Autowired
    public BookCategoryController(
            BookCategoryViewer viewer,
            @Qualifier("fantasyCategory") BookCategory fantasyCategory,
            @Qualifier("horrorCategory") BookCategory horrorCategory,
            @Qualifier("scifiCategory") BookCategory scifiCategory) {
        this.viewer = viewer;
        this.fantasyCategory = fantasyCategory;
        this.horrorCategory = horrorCategory;
        this.scifiCategory = scifiCategory;
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
        Map<String, String> categoryDisplays = new HashMap<>();
        categoryDisplays.put("Фэнтези", viewer.getDisplayPrefix() + fantasyCategory.getName());
        categoryDisplays.put("Хоррор", viewer.getDisplayPrefix() + horrorCategory.getName());
        categoryDisplays.put("Научная фантастика", viewer.getDisplayPrefix() + scifiCategory.getName());

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
}