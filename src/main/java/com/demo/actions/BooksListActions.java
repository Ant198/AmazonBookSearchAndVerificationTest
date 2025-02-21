package com.demo.actions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demo.pages.ResultPage;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import com.demo.pages.Pages;

public class BooksListActions {
    private final List<BookActions> booksList;

    public BooksListActions() {
        this.booksList = new ArrayList<>();
    }

    public void setBooksList() {
        ResultPage resultPage = Pages.resultPage();
        List<SelenideElement> books = resultPage.getResultElements();

        for(SelenideElement book : books) {
            BookActions bookInfo = Actions.bookActions();
            String title;
            String author = "";
            String price;
            String bestSeller;
            title = book.$(By.xpath(".//h2//span")).text();
            bookInfo.setTitle(title);
            ElementsCollection elements = book.$$(By.className("a-size-base"));
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().equals("by")) {
                    author = elements.get(i + 1).text();
                    break;
                }
            }
            bookInfo.setAuthor(author);
            price = book.$$(By.xpath(".//span[@class=\"a-offscreen\"]")).texts().get(0);
            bookInfo.setPrice(price);
            if (book.$(By.xpath(".//span[@class=\"a-badge-text\"]")).exists()) {
                bestSeller = "yes";
            } else {
                bestSeller = "no";
            }
            bookInfo.setBestSeller(bestSeller);
            booksList.add(bookInfo);
        }
    }
    public List<BookActions> getBooksList() {
        return booksList;
    }
}