package com.example.vnatyre_blen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private final BookCategoryViewer viewer;
    private final BookCategory scifiCategory;

    @Autowired
    public Main(BookCategoryViewer viewer, @Qualifier("scifiCategory") BookCategory scifiCategory) {
        this.viewer = viewer;
        this.scifiCategory = scifiCategory;
    }

    public void run() {
        viewer.displayCategory(scifiCategory);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.vnatyre_blen");
        Main main = context.getBean(Main.class);
        main.run();
        context.close();
    }
}