package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.testinium.sample.pages.StartPage;


public class StepImplementationStartPage {

    StartPage startPage;

    public StepImplementationStartPage() {
        this.startPage = new StartPage();
    }

    @Step("Para Transfer Uygulaması başlatma sayfası açılır.")
    public void implementation() {
        startPage.homePageCheck();
    }

    @Step("Para Transfer Uygulaması başarılı şekilde açıldığı doğrulanır.")
    public void implementation1() {
        startPage.OpenMoneyTransferApp();
    }
}
