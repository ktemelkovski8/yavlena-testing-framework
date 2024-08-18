package org.example.pages;

import org.example.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    private final By understoodButton = By.xpath("//button[text()='Understood']");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void bypassCookiesPopUp (WebDriver driver){
        driver.findElement(understoodButton).click();
    }
}