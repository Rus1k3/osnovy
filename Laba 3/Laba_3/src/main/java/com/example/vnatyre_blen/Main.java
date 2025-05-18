package com.example.vnatyre_blen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BookCategoryViewer viewer = context.getBean("bookCategoryViewer", BookCategoryViewer.class);
        viewer.displayCategory(context.getBean("scifiCategory", BookCategory.class));
        ((ClassPathXmlApplicationContext) context).close();
    }
}