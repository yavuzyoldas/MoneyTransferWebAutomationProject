package org.testinium.sample.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testinium.sample.base.BaseTest;
import org.testinium.sample.base.DriverFactory;
import org.testinium.sample.uiElements.MoneyAppPageUIElements;
import org.testinium.sample.util.ElementHelper;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;
import static org.testinium.sample.util.Constants.*;
import static org.testinium.sample.util.UtilFunctions.convertStringToDouble;
import static org.testinium.sample.util.UtilFunctions.generateRandomString;


public class MoneyAppPage extends BaseTest {


    MoneyAppPageUIElements moneyAppPageUIElements;
    ElementHelper elementHelper;
    WebDriver driver;
    private final String newAccountName;
    private String myAccountAmount;


    public MoneyAppPage() {

        this.driver = DriverFactory.getDriver();
        this.moneyAppPageUIElements = new MoneyAppPageUIElements();
        this.elementHelper = new ElementHelper(driver,new WebDriverWait(driver, Duration.ofSeconds(60)));

        newAccountName = generateRandomString();

    }

    public void clickAccountNameEditButton() {


        try {
            elementHelper.click(moneyAppPageUIElements.editAccountButton);
            //test.pass("Add money button clicked successfully");
        } catch (Exception e) {
            test.fail("Failed to click the Add money button: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        }
    }


    public void typeNewAccountNameTextBox() {

        elementHelper.clearInputText(moneyAppPageUIElements.accountNameEditingInput);
        elementHelper.sendKeys(moneyAppPageUIElements.accountNameEditingInput, newAccountName);

    }

    public void clickUpdateButton() {
        elementHelper.click(moneyAppPageUIElements.accountNameUpdateButton);
    }

    public void verifyUpdatedName() {
        String xpath = "//div[contains(text(), '" + newAccountName + "')]";
        By newAccountName = By.xpath(xpath);

        elementHelper.waitVisibilityOfElementLocated(newAccountName);

        Assert.assertTrue(elementHelper.isDisplayedElement(newAccountName));

    }

    public void saveMoneyAmountAndClickMoneyTransferButton() {

        myAccountAmount = elementHelper.getText(moneyAppPageUIElements.myAccountAmount);



        elementHelper.click(moneyAppPageUIElements.transferMoneyButton);


    }

    public void typeMoneyAmountToTextbox() {

        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.moneyAmountInput);

        elementHelper.sendKeys(moneyAppPageUIElements.moneyAmountInput,"100");
    }

    public void clickSendButton() {

        try {
            elementHelper.interactionWithJS(moneyAppPageUIElements.moneyTransferSendButton);
            elementHelper.clickWithJS(moneyAppPageUIElements.moneyTransferSendButton);
        } catch (Exception e) {
            test.fail("clickSendButton " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
        }





    }

    public void verifyTransactionListAndAccountMoney(String data) {



        boolean check1 = false;
        boolean check2= false;

        String moneyAmountAfterTransfer = elementHelper.getText(moneyAppPageUIElements.myAccountAmount);
        String lastTransactionAmount = elementHelper.getText(moneyAppPageUIElements.transactionsAmount);
        if(0 == data.compareTo("Transfer")){
            System.out.println("Transfer Money Check");

            double numericMoneyAmountAfterTransfer = convertStringToDouble(moneyAmountAfterTransfer);
            double numericMyAccountAmount = convertStringToDouble(myAccountAmount);

            if(numericMoneyAmountAfterTransfer == (numericMyAccountAmount- 100)){
                check1 = true;
                System.out.println("Transfer Money First Check");
            }


            double numericLastTransactionAmount = convertStringToDouble(lastTransactionAmount);

            if(100.00 == numericLastTransactionAmount){
                System.out.println("Transfer Money Second Check");
                check2 = true;
            }

        }else if(0 == data.compareTo("Add")){

            System.out.println("Add Money Check");
            double numericMoneyAmountAfterTransfer = convertStringToDouble(moneyAmountAfterTransfer);
            double numericMyAccountAmount = convertStringToDouble(myAccountAmount);

            if(numericMoneyAmountAfterTransfer == (numericMyAccountAmount + 100)){
                check1 = true;
                System.out.println("Add Money First Check");
            }


            double numericLastTransactionAmount = convertStringToDouble(lastTransactionAmount);

            if(100.00 == numericLastTransactionAmount){
                check2 = true;
                System.out.println("Add Money Second Check");
            }

        }




        Assert.assertTrue(check1 && check2);


    }

    public void saveMoneyAmountAndClickAddButton() {

        myAccountAmount = elementHelper.getText(moneyAppPageUIElements.myAccountAmount);

        elementHelper.click(moneyAppPageUIElements.addMoneyButton);

    }

    public void typeCreditCardNumber() {
        elementHelper.waitDocumentReady();
        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.creditCardNumberInput);
        WebElement element = driver.findElement(moneyAppPageUIElements.creditCardNumberInput);
        if (element.isDisplayed() && element.isEnabled()) {
            System.out.println("Element görünür veya etkileşime açık!");
        } else {
            System.out.println("Element görünür veya etkileşime açık değil!");
        }
        elementHelper.interactionWithJS(moneyAppPageUIElements.creditCardNumberInput);
        elementHelper.setValueWithJS(moneyAppPageUIElements.creditCardNumberInput,CreditCardNumber);
        elementHelper.clearInputText(moneyAppPageUIElements.creditCardNumberInput);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardNumberInput,CreditCardNumber);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardNumberInput, Keys.TAB);
    }

    public void typeCreditCardHolder() {
        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.creditCardHolderInput);
        elementHelper.interactionWithJS(moneyAppPageUIElements.creditCardHolderInput);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardHolderInput,CreditCardHolder);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardHolderInput, Keys.TAB);
    }

    public void typeCreditCardExpiryDate() {

        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.creditCardExpiryDateInput);
        //elementHelper.clickWithJS(moneyAppPageUIElements.creditCardExpiryDateInput);
        elementHelper.interactionWithJS(moneyAppPageUIElements.creditCardExpiryDateInput);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardExpiryDateInput,CreditCardExpiryDate);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardExpiryDateInput, Keys.TAB);
    }

    public void typeCreditCardCVV() {

        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.creditCardCVVInput);
        //elementHelper.clickWithJS(moneyAppPageUIElements.creditCardCVVInput);
        elementHelper.interactionWithJS(moneyAppPageUIElements.creditCardCVVInput);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardCVVInput,CreditCardCVV);
        elementHelper.sendKeys(moneyAppPageUIElements.creditCardCVVInput, Keys.TAB);
    }

    public void typeAddingAmount() {
        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.amountInput);
        //elementHelper.clickWithJS(moneyAppPageUIElements.amountInput);
        elementHelper.interactionWithJS(moneyAppPageUIElements.amountInput);
        elementHelper.sendKeys(moneyAppPageUIElements.amountInput,"100");
        elementHelper.sendKeys(moneyAppPageUIElements.amountInput, Keys.TAB);
    }

    public void clickAddButton() {
        elementHelper.click(moneyAppPageUIElements.addButton);

    }

    public void typeAmountInExcessOfBalance() {

         double amount = convertStringToDouble(myAccountAmount);
         double amountInExcessOfBalance = amount +100;
         String stringAmountInExcessOfBalance = String.valueOf(amountInExcessOfBalance);

         stringAmountInExcessOfBalance = stringAmountInExcessOfBalance.replaceAll("\\..*", "");
        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.moneyAmountInput);
        System.out.println("Transfer Money Check" + stringAmountInExcessOfBalance);
        elementHelper.isDisplayedElement(moneyAppPageUIElements.moneyAmountInput);
        elementHelper.sendKeys(moneyAppPageUIElements.moneyAmountInput,stringAmountInExcessOfBalance);
        elementHelper.sendKeys(moneyAppPageUIElements.moneyAmountInput,Keys.TAB);


    }

    public void checkAccountMoney() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean check = false;

        elementHelper.waitVisibilityOfElementLocated(moneyAppPageUIElements.myAccountAmount);
        String moneyAmountAfterTransfer = elementHelper.getText(moneyAppPageUIElements.myAccountAmount);

        System.out.println("Transfer Money Check");

        double numericMoneyAmountAfterTransfer = convertStringToDouble(moneyAmountAfterTransfer);
        double numericMyAccountAmount = convertStringToDouble(myAccountAmount);

        System.out.println("check Account Money for negative account ");
        if(numericMoneyAmountAfterTransfer == numericMyAccountAmount){
                check = true;
            System.out.println("check true ");

        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(check);




    }
}
