package org.testinium.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.uiElements.MoneyAppPageUIElements;
import org.testinium.sample.util.ElementHelper;

import java.time.Duration;


public class MoneyAppPAge {


    MoneyAppPageUIElements detailPageUIElements;
    MyBasketPageUIElements myBasketPageUIElements;
    ElementHelper elementHelper;
    public static String price;
    WebDriver driver;

    public MoneyAppPAge() {
        this.driver = DriverFactory.getDriver();
        //this.driver.navigate().to("https://www.beymen.com");

        this.detailPageUIElements = new MoneyAppPageUIElements();
        this.myBasketPageUIElements = new MyBasketPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

    }



}
