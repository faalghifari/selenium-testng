package org.auto8id.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Common methods
    protected void click(WebElement element) {
        element.click();
    }

    protected void type(WebElement element, String text) {
        element.sendKeys(text);
    }
}