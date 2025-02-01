package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.pages.HomePage;


public class StepImplementationHomePage {

    HomePage homePage;

    public StepImplementationHomePage() {
        this.homePage = new HomePage();
    }

    @Step("Money Transfer HomePage Check")
    public void implementation() {
        homePage.homePageCheck();
    }

    @Step("Open the Money Transfer App")
    public void implementation1() {
        homePage.OpenMoneyTransferApp();
    }
}
