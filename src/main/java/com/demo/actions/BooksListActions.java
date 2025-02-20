package com.demo.actions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demo.pages.ResultPage;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import com.demo.pages.Pages;
public class BooksListActions {

    public List<BookActions> getBooksList() {
        ResultPage resultPage = Pages.resultPage();
        List<BookActions> booksList = new ArrayList<>();
        List<SelenideElement> books = resultPage.receiveElements();

        for(SelenideElement book : books) {
            BookActions bookInfo = Actions.bookActions();
            String name;
            String author = "";
            String price;
            String bestSeller;
            name = book.$(By.xpath(".//h2//span")).text();
            bookInfo.setName(name);
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
        return booksList;
    }
}