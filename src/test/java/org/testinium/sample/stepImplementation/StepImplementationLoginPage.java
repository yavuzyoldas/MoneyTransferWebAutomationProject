package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.testinium.sample.pages.LoginPage;

public class StepImplementationLoginPage {

    LoginPage loginPage;

    public StepImplementationLoginPage() {
        this.loginPage = new LoginPage();
    }


    @Step("Para Transfer Uygulaması başlatma işlemi için oturum açma ön koşulu sağlanır.")
    public void implementation1() {
        loginPage.login();
    }
}
