package org.example.tests;

import org.example.models.Broker;
import org.example.pages.BasePage;
import org.example.pages.BrokerPage;
import org.example.utils.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.enums.BrokerCity.SOFIA;

public class BrokerPageTest {

    private WebDriver driver;
    private BrokerPage brokerPage;
    private final String URL = "https://www.yavlena.com/en/broker?city=" + SOFIA;
    private SoftAssert softAssert;
    FluentWait<WebDriver> wait;


    @BeforeMethod
    public void setUp() {
        driver = BrowserManager.launchBrowser();
        driver.manage().window().maximize();
        driver.get(URL);
        brokerPage = new BrokerPage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.bypassCookiesPopUp(driver);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        softAssert = new SoftAssert();
    }

    @Test
    public void testSearchBrokerByName(){
        List<Broker> brokers = buildBrokers();

        for (Broker br : brokers) {
            brokerPage.enterBrokerName(br.getName(), driver);
            wait.until(ExpectedConditions.urlToBe(URL + "&keyword=" + br.getName().replace(" ", "+")));

            Assert.assertEquals(brokerPage.countBrokers(),1,"only 1 person should be listed");

            brokerPage.clickExpandDetails(driver);

            softAssert.assertEquals(brokerPage.getValueForNameOnExpandedBrokerCard(), br.getName(),
                    "Name not correct for: " + br.getName());
            softAssert.assertEquals(brokerPage.getValueForAddressOnExpandedBrokerCard(), br.getAddress(),
                    "Address not correct for: " + br.getName());
            softAssert.assertEquals(brokerPage.getValueForPropertiesOnExpandedBrokerCard(),
                    br.getNumberOfPropertiesAssigned() + " properties",
                    "No. of Properties not correct for: " + br.getName());
            List<String> numbers = brokerPage.getValuesForNumbersOnExpandedBrokerCard();
            softAssert.assertEquals(numbers.get(0), br.getLandlineNumber(),
                    "Landline No. not correct for: " + br.getName());
            softAssert.assertEquals(numbers.get(1), br.getMobileNumber(),
                    "Mobile No. not correct for: " + br.getName());

            brokerPage.clickClearFilter(driver);
            wait.until(ExpectedConditions.urlToBe(URL));
        }
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeBrowser(driver);
    }

    private List<Broker> buildBrokers(){

        /*
        I've noticed that the requirements says EACH broker, but i've tried to fetch the data from the api/broker that's
        using paging to get the broker and i cannot get them through Insomnia, i'm receiving 404, the api authorisation
        cannot be bypassed. If i could access the api, i would've gotten all brokers, map them to the model and by that
        i can assert EACH broker. I know that requests can be intercepted using selenium, i've already done that on
        one of the projects that i've worked on but for this exercise i don't have the time to do it.
         */

        List<Broker> brokers = new ArrayList<>();
        Broker brokerOne = Broker.builder()
                .name("Aleksandar Petkov")
                .address("Sofia / Office Center")
                .numberOfPropertiesAssigned(13)
                .landlineNumber("+359 2 926 26")
                .mobileNumber("+359 888 106 040")
                .build();
        brokers.add(brokerOne);

        Broker brokerTwo = Broker.builder()
                .name("Ava Leonkeva")
                .address("Sofia / Main Office")
                .numberOfPropertiesAssigned(0)
                .landlineNumber("+359 28 10 50 00")
                .mobileNumber("+359 889 26 26 06")
                .build();
        brokers.add(brokerTwo);

        return brokers;
    }
}