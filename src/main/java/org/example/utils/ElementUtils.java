package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    private final WebDriver driver;
    private Duration timeout = Duration.ofSeconds(3);

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

        public WebElement waitForElementToBeVisibleAndClickable(By by) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }


}