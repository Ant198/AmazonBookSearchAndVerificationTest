package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import org.openqa.selenium.By;
import java.util.List;

public class ResultPage extends PageTools {

    public ResultPage() {
        super();
    }

    private final By results = By.xpath("//div[@role='listitem']");

    public List<SelenideElement> receiveElements() {
        return getElements(results);
    }
    public String getText(By by) {
        return getElementsText(by).get(0);
    }
}
