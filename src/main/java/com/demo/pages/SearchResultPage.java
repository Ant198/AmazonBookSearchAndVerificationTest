package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import com.demo.models.BookModels;
import com.demo.models.Models;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends PageTools {
    private final By results = By.xpath("//div[@role='listitem']");
    private final List<BookModels> booksList;

    public SearchResultPage() {
        this.booksList = new ArrayList<>();
    }

    public void setBooksList() {
        for(int i = 1; i <= getElements(results).size(); i++) {
            BookModels bookInfo = Models.bookModels();
            String title;
            String author = "";
            String price;
            String bestSeller;
            String mainPath = String.format("(//div[@role='listitem'])[%d]", i);
            By titleLocator = By.xpath(mainPath + "//h2//span");
            By authorLocator = By.xpath(mainPath + "//*[contains(@class, \"a-size-base\")]");
            By priceLocator = By.xpath(mainPath + "//span[@class=\"a-offscreen\"]");
            By bestSellerLocator = By.xpath(mainPath + "//span[@class=\"a-badge-text\"]");

            title = getElementText(titleLocator);
            bookInfo.setTitle(title);
            List<SelenideElement> elements = getElements(authorLocator);
            for (int j = 0; j < elements.size(); j++) {
                if (elements.get(j).getText().equals("by")) {
                    author = elements.get(j + 1).text();
                    break;
                }
            }
            bookInfo.setAuthor(author);
            price = getElementsText(priceLocator).get(0);
            bookInfo.setPrice(price);
            if (!getElementsWithZeroOption(bestSellerLocator).isEmpty()) {
                bestSeller = "yes";
            } else {
                bestSeller = "no";
            }
            bookInfo.setBestSeller(bestSeller);
            booksList.add(bookInfo);
        }
    }
    public List<BookModels> getBooksList() {
        return booksList;
    }
}