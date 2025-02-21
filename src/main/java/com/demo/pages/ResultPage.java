package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import org.openqa.selenium.By;
import java.util.List;

public class ResultPage extends PageTools {

    private final By results = By.xpath("//div[@role='listitem']");

    public List<SelenideElement> getResultElements() {
        return getElements(results);
    }

    public List<String> getTexts(By by) {
        return getElementsText(by);
    }
}
