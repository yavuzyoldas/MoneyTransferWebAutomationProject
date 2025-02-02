package org.testinium.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.uiElements.HomePageUIElements;
import org.testinium.sample.uiElements.MoneyAppPageUIElements;
import org.testinium.sample.util.ElementHelper;
import org.testinium.sample.util.Log;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;

public class StartPage {

    HomePageUIElements homePageUIElements;
    MoneyAppPageUIElements moneyAppPageUIElements;
    ElementHelper elementHelper;

    WebDriver driver;


    public StartPage() {
        driver = DriverFactory.getDriver();
        //driver.navigate().to("https://catchylabs-webclient.testinium.com/");
        this.moneyAppPageUIElements = new MoneyAppPageUIElements();
        this.homePageUIElements = new HomePageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

    }




    public void homePageCheck(){

        boolean check =  elementHelper.isDisplayedElement(elementHelper.findElement(homePageUIElements.homePageChallengeName));
        if (check) Log.info("Home page available!");
        else Log.error("Home page not available!");

    }

    public void OpenMoneyTransferApp(){

        elementHelper.click(homePageUIElements.openMoneyTransferButton);

        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.transactionsText);

        assertTrue(elementHelper.isDisplayedElement(moneyAppPageUIElements.transactionsText));

    }

}
