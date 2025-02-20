package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    private static HomePage homePage;
    private static ResultPage resultPage;
    private static BookPage bookPage;

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public static ResultPage resultPage() {
        if (resultPage == null) {
            resultPage = new ResultPage();
        }
        return resultPage;
    }

    public static BookPage bookPage() {
        if (bookPage == null) {
            bookPage = new BookPage();
        }
        return bookPage;
    }
}