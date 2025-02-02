package org.testinium.sample.uiElements;

import org.openqa.selenium.By;

public class MoneyAppPageUIElements {

    public By transactionsText= By.xpath("//div[contains(text(), 'Transactions')]");
    //------------------------------------------- Edit Account ---------------------------------------------------
    public By editAccountButton= By.xpath("//div[contains(text(), 'Edit account')]");

    public By accountNameEditingInput= By.xpath("//input[contains(@class, 'css-11aywtz')]");

    public By accountNameUpdateButton= By.xpath("//div[contains(text(), 'UPDATE')]");
    //------------------------------------------- Transfer Money ---------------------------------------------------
    public By transferMoneyButton = By.xpath("//div[contains(text(), 'Transfer money')]");

    public By myAccountAmount = By.xpath("//div[.='My account']/following-sibling::div//div[contains(text(),'Amount')]/following-sibling::div");

    public By transactionsAmount = By.xpath("//div[.='Transactions']/following-sibling::div//div[contains(text(),'Amount')]/following-sibling::div[last()]");

    public By moneyAmountInput = By.xpath("//input[contains(@class, 'css-11aywtz')]");

    public By moneyTransferSendButton = By.xpath("//div[contains(text(), 'Send')]");
    //------------------------------------------- Add Money ---------------------------------------------------
    public By addMoneyButton = By.xpath("//div[contains(text(), 'Add money')]");

    public By creditCardNumberInput = By.xpath("//div[.='Card number']/following-sibling::input");

    public By creditCardHolderInput = By.xpath("//div[.='Card holder']/following-sibling::input");

    public By creditCardExpiryDateInput = By.xpath("//div[.='Expiry date']/following-sibling::input");

    public By creditCardCVVInput = By.xpath("//div[.='CVV']/following-sibling::input");

    public By amountInput = By.xpath("//div[.='Amount']/following-sibling::input");

    public By addButton = By.xpath("//div[.='Add']/parent::div[@tabindex='0']");

}
