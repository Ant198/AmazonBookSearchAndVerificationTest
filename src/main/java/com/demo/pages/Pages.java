package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    private static HomePage homePage;
    private static SearchResultPage searchResultPage;
    private static BookInfoPage bookPage;

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public static SearchResultPage searchResultPage() {
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }

    public static BookInfoPage bookPage() {
        if (bookPage == null) {
            bookPage = new BookInfoPage();
        }
        return bookPage;
    }
}