package org.example.tests;

import org.example.pages.BasePage;
import org.example.pages.BrokerPage;
import org.example.utils.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.enums.BrokerCity.SOFIA;

public class BrokerPageTest {

    private WebDriver driver;
    private BrokerPage brokerPage;
    private final String URL = "https://www.yavlena.com/en/broker?city=" + SOFIA;

    @BeforeMethod
    public void setUp() {
        driver = BrowserManager.launchBrowser();
        driver.manage().window().maximize();
        driver.get(URL);
        brokerPage = new BrokerPage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.bypassCookiesPopUp(driver);
    }

    @Test
    public void testSearchBrokerByName() {
        brokerPage.enterBrokerName("Aleksandar Petkov");
        // Add assertions to verify the search result
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeBrowser(driver);
    }
}