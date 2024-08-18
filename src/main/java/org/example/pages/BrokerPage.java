package org.example.pages;

import org.example.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrokerPage extends BasePage {

    private final By brokerNameInput = By.id("broker-keyword");
    private final By divContainerForBrokers =
            By.xpath("//div[contains(@class, 'MuiGrid-root') and contains(@class, 'MuiGrid-container')]/div");
    private final By detailsButtonForSearchedBroker = By.xpath("//button[text()='Details']");
    private final By clearButtonForSearchedBroker = By.xpath("//button[text()='Clear']");
    private final By brokerNameOnCard =
            By.xpath("//h6[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiTypography-h6') ]");
    private final By brokerAddressOnCard =
            By.xpath("//span[contains(@class, 'MuiTypography-root') " +
                    "and contains(@class, 'MuiTypography-textSmallRegular') " +
                    "and contains(@class, 'mui-style-14x3no9')]");
    private final By brokerPropertiesOnCard =
            By.xpath("//a[contains(@class, 'MuiTypography-root') " +
                    "and contains(@class, 'MuiTypography-inherit') " +
                    "and contains(@class, 'MuiLink-root') " +
                    "and contains(@class, 'MuiLink-underlineHover') and contains(@class, 'mui-style-szaqw')]");
    private final By brokerNumbersOnCard =
            By.xpath("//*[contains(@class, 'MuiTypography-root') and" +
                    "    contains(@class, 'MuiTypography-inherit') and" +
                    "    contains(@class, 'MuiLink-root') and" +
                    "    contains(@class, 'MuiLink-underlineNone') and" +
                    "    contains(@class, 'mui-style-1ktzac6')]");
    private final ElementUtils utils = new ElementUtils(driver);

    public BrokerPage(WebDriver driver) {
        super(driver);
    }

    public void enterBrokerName(String name, WebDriver driver) {
        utils.waitForElementToBeVisibleAndClickable(brokerNameInput).sendKeys(name);
    }

    public Integer countBrokers(){
        utils.waitForElementToBeVisibleAndClickable(divContainerForBrokers);
        return driver.findElements(divContainerForBrokers).size();
    }

    public void clickExpandDetails(WebDriver driver){
        utils.waitForElementToBeVisibleAndClickable(detailsButtonForSearchedBroker);
        driver.findElement(detailsButtonForSearchedBroker).click();
    }

    public String getValueForNameOnExpandedBrokerCard(){
        utils.waitForElementToBeVisibleAndClickable(brokerNameOnCard);
        return driver.findElement(brokerNameOnCard).getText();
    }

    public String getValueForAddressOnExpandedBrokerCard(){
        utils.waitForElementToBeVisibleAndClickable(brokerAddressOnCard);
        return driver.findElement(brokerAddressOnCard).getText();
    }

    public String getValueForPropertiesOnExpandedBrokerCard(){
        utils.waitForElementToBeVisibleAndClickable(brokerPropertiesOnCard);
        return driver.findElement(brokerPropertiesOnCard).getText();
    }

    public List<String> getValuesForNumbersOnExpandedBrokerCard(){
        List<String> numbers = new ArrayList<>();
        utils.waitForElementToBeVisibleAndClickable(brokerNumbersOnCard);
        numbers.add(driver.findElements(brokerNumbersOnCard).get(0).getText());
        numbers.add(driver.findElements(brokerNumbersOnCard).get(1).getText());
        return numbers;
    }

    public void clickClearFilter(WebDriver driver){
        utils.waitForElementToBeVisibleAndClickable(clearButtonForSearchedBroker);
        driver.findElement(clearButtonForSearchedBroker).click();
    }
}
