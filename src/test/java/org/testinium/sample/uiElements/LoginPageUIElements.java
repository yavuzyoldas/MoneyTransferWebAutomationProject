package org.testinium.sample.uiElements;

import org.openqa.selenium.By;

public class LoginPageUIElements {

    public By username = By.cssSelector("input[placeholder='Username']");
    public By password = By.cssSelector("input[placeholder='Password']");
    public By loginButton = By.xpath("//div[text()='Login']");


}
