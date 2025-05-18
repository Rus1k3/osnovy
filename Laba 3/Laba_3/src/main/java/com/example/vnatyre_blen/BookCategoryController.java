package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}