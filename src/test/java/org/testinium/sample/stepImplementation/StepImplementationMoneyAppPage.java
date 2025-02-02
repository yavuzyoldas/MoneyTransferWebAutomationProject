package org.testinium.sample.stepImplementation;

import com.thoughtworks.gauge.Step;
import org.testinium.sample.pages.MoneyAppPage;

public class StepImplementationMoneyAppPage {


    MoneyAppPage moneyAppPage;

    public StepImplementationMoneyAppPage() {
        this.moneyAppPage = new MoneyAppPage();

    }


    @Step("Checking Account (Vadesiz Hesap) ismin düzenlemesi için hesap düzenleme butonuna tıklanır.")
    public void implementation1() {
        moneyAppPage.clickAccountNameEditButton();
    }

    @Step("Açılan pencerede hesap ismi yeni hesap ismi rastgele değer olarak değiştirilmek üzere metin kutusuna yazılır.")
    public void implementation2() {
        moneyAppPage.typeNewAccountNameTextBox();
    }

    @Step("Penceredeki güncelleme butonuna tıklanır.")
    public void implementation3() {
        moneyAppPage.clickUpdateButton();
    }

    @Step("Hesap isminin yeni hesap ismi olarak güncellendiği doğrulanır.")
    public void implementation4() {
        moneyAppPage.verifyUpdatedName();
    }

    @Step("Mevcut açık hesaptaki para miktarı kaydedilir ve Para Transferi butonuna tıklanır.")
    public void implementation5() {
        moneyAppPage.saveMoneyAmountAndClickMoneyTransferButton();
    }

    @Step("Açılan Para Transferi pencerisinde miktar metin kutusuna yazılır.")
    public void implementation6() {
        moneyAppPage.typeMoneyAmountToTextbox();
    }

    @Step("Gönder butonuna tıklanır.")
    public void implementation7() {
        moneyAppPage.clickSendButton();

    }

    @Step("Para Tranferi İşlemleri listesinde işlemin oluduğu ve transfer edilen miktar kadar paranın hesaptan eksildiği doğrulanır.")
    public void implementation8() {
        moneyAppPage.verifyTransactionListAndAccountMoney("Transfer");

    }

    @Step("Mevcut açık hesaptaki para miktarı kaydedilir ve Para Ekleme butonuna tıklanır.")
    public void implementation9() {
        moneyAppPage.saveMoneyAmountAndClickAddButton();
    }

    @Step("Para Ekleme penceresindeki kredi kartı numara alanı test verisi ile doldurulur.")
    public void implementation10() {

        moneyAppPage.typeCreditCardNumber();

    }

    @Step("Para Ekleme penceresindeki kredi kartı sahibi alanı doldurulur.")
    public void implementation11() {
        moneyAppPage.typeCreditCardHolder();
    }

    @Step("Para Ekleme penceresindeki kartı son kullanma tarihi alanı doldurulur.")
    public void implementation12() {
        moneyAppPage.typeCreditCardExpiryDate();
    }

    @Step("Para Ekleme penceresindeki kredi kartı CVV alanı doldurulur.")
    public void implementation13() {
        moneyAppPage.typeCreditCardCVV();
    }

    @Step("Para Ekleme penceresindeki miktar alanı doldurulur.")
    public void implementation14() {
        moneyAppPage.typeAddingAmount();
    }

    @Step("Ekle butonuna tıklanır.")
    public void implementation15() {
        moneyAppPage.clickAddButton();
    }

    @Step("Para Ekleme işleminin işlemler listesinde olduğu ve eklenen paranın hesaba eklendiği doğrulanır.")
    public void implementation16() {
        moneyAppPage.verifyTransactionListAndAccountMoney("Add");
    }

    @Step("Açılan Para Transferi pencerisinde miktar metin kutusuna mevcut para miktarında fazla bir değer yazılır.")
    public void implementation17() {

        moneyAppPage.typeAmountInExcessOfBalance();

    }

    @Step("Para Tranferinin gerçekleşmediği ve hesap miktarını aynı kaldığı görülür.")
    public void implementation18() {
        moneyAppPage.checkAccountMoney();
    }
}
