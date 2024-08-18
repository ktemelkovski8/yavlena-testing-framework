package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokerPage extends BasePage {

    @FindBy(id = "broker-keyword")
    WebElement brokerNameInput;

    public BrokerPage(WebDriver driver) {
        super(driver);
    }

    public void enterBrokerName(String name) {
        brokerNameInput.sendKeys(name);
    }
}
