package org.testinium.sample.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;

    public ElementHelper(WebDriver webDriver,WebDriverWait wait){
        this.driver = webDriver;
        this.wait = wait;

    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public void sendKeys (By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void sendKeys (By by, Keys keys) {
        findElement(by).sendKeys(keys);
    }

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickWithJS(By by) {
        WebElement element = findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public String getText(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement (by).getText();
    }


    public Boolean isDisplayedElement(By by){

        return driver.findElement(by).isDisplayed();
    }

    public Boolean isDisplayedElement(WebElement webElement){

        return webElement.isDisplayed();
    }

    public void waitElements(long wait){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

    }

    public void waitVisibilityOfElementLocated(By by){

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clearInputText(By by){
        WebElement inputField = driver.findElement(by);
        inputField.clear();
    }

    public void waitDocumentReady(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
    }

    public void interactionWithJS(By by){
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public void setValueWithJS(By by,String cardNumber){
        WebElement element = driver.findElement(by);
        // JavascriptExecutor oluştur
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // JavaScript kodunu çalıştırarak input alanına değer gönder
        jsExecutor.executeScript(
                "arguments[0].value = '" + cardNumber + "';" +
                        "arguments[0].dispatchEvent(new Event('input'));",
                element
        );

    }
}
