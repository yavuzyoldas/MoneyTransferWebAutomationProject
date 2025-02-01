package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.testinium.sample.pages.LoginPage;

public class StepImplementationLoginPage {

    LoginPage loginPage;

    public StepImplementationLoginPage() {
        this.loginPage = new LoginPage();
    }


    @Step("Money Transfer PreCondition")
    public void implementation1() {
        loginPage.login();
    }
}
