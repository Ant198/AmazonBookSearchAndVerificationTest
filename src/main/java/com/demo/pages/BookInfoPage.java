package com.demo.pages;

import com.codeborne.selenide.Condition;
import com.demo.core.base.PageTools;
import com.demo.models.BookModels;
import com.demo.models.Models;
import org.openqa.selenium.By;

public class BookInfoPage extends PageTools {
    private final By name = By.xpath("//span[@id=\"productTitle\"]");
    private final By author = By.xpath("//div[@id=\"bylineInfo\"]//span[1]//a");
    private final By price = By.xpath("(//div[@id=\"Northstar-Buybox\"]//div[@role=\"listitem\"])[2]//span[contains(@class, \"slot-price\")]//span");
    private final By bestSeller = By.xpath("//span[contains(@class, \"p13n-best-seller-badge\")]");
    BookModels book = Models.bookModels();

    public void setBook() {
        book.setTitle(getElementText(name));
        book.setAuthor(getElementText(author));
        System.out.println(getElementText(price));
        book.setPrice(getElementText(price));
        System.out.println(isCondition(Condition.exist, bestSeller));
        book.setBestSeller(isCondition(Condition.exist, bestSeller) ? "Yes" : "No");
    }

    public BookModels getBook() {
        return book;
    }
}
