package com.demo.pages;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends PageTools {
    private final By searchDropdownBox = By.xpath("//select[@id=\"searchDropdownBox\"]");
    private final By inputField = By.xpath("//input[@id=\"twotabsearchtextbox\"]");

    public WebElement getDropdownBox(String text) {
        String option = String.format("//select[@id=\"searchDropdownBox\"]/option[text()=\"%s\"]", text);
        return getWebElement(By.xpath(option));
    }

    public void setFilter(String text) {
        String option = String.format("//select[@id=\"searchDropdownBox\"]/option[text()=\"%s\"]", text);
        clickIfExist(searchDropdownBox);
        click(By.xpath(option));
    }

    public void typeText(String text) {
        typeWithEnter(text, inputField);
    }
}