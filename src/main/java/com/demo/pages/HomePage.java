package com.demo.pages;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends PageTools {
    private final By searchDropdownBox = By.xpath("//select[@id='searchDropdownBox']");
    private final By inputField = By.xpath("//input[@id='twotabsearchtextbox']");

    public WebElement getDropdownBox(String text) {
        return getWebElement(By.xpath("//select[@id='searchDropdownBox']/option[text()='" + text + "']"));
    }

    public WebElement getInputField() {
        return getWebElement(inputField);
    }

    public void setFilter(String text) {
        clickIfExist(searchDropdownBox);
        click(By.xpath("//select[@id='searchDropdownBox']//option[text()='" + text + "']"));
    }

    public void typeText(String text) {
        typeWithEnter(text, inputField);
    }
}