package com.demo.pages;

import com.codeborne.selenide.Condition;
import com.demo.actions.Actions;
import com.demo.actions.BookActions;
import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class BookPage extends PageTools {
    private final By name = By.xpath("//span[@id = \"productTitle\"]");
    private final By author = By.xpath("//div[@id=\"bylineInfo\"]//span[1]//a");
    private final By price = By.xpath("//div[@id=\"tmm-grid-swatch-PAPERBACK\"]//span[@class=\"slot-price\"]//span");
    private final By bestSeller = By.xpath("//div[@id=\"zeitgeistBadge_feature_div\"]");

    public BookActions getBook() {
        System.out.println("3");
        BookActions book = Actions.bookActions();
        book.setName(getElementText(name));
        book.setAuthor(getElementText(author));
        book.setPrice(getElementText(price));
        book.setBestSeller(isCondition(Condition.exist, bestSeller) ? "Yes" : "No");
        return book;
    }
}
