package org.testinium.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.uiElements.LoginPageUIElements;
import org.testinium.sample.util.ElementHelper;
import org.testinium.sample.util.Log;

import java.time.Duration;

import static org.testinium.sample.util.Constants.PASSWORD;
import static org.testinium.sample.util.Constants.USERNAME;

public class LoginPage {

    LoginPageUIElements loginPageUIElements;
    ElementHelper elementHelper;
    WebDriver driver;


    public LoginPage() {

        driver = DriverFactory.getDriver();
        driver.navigate().to("https://catchylabs-webclient.testinium.com/");
        this.loginPageUIElements = new LoginPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));
    }

    public void login(){

        elementHelper.waitVisibilityOfElementLocated(loginPageUIElements.username);

        elementHelper.sendKeys(loginPageUIElements.username,USERNAME);
        elementHelper.sendKeys(loginPageUIElements.password,PASSWORD);

        elementHelper.click(loginPageUIElements.loginButton);


        Log.info("pre condition -> login");

    }









}
