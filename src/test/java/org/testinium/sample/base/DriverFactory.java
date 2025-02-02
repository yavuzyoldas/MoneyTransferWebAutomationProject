package org.testinium.sample.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {


    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            System.out.println("driver == null");
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions1 = new ChromeOptions();
                    chromeOptions1.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions1);
                    break;
                case "chrome-mobile":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions2 = new ChromeOptions();

                    // Samsung Galaxy S23 mobile emülasyonu için ayarlar
                    chromeOptions2.addArguments("--disable-extensions");
                    chromeOptions2.addArguments("--no-sandbox");
                    chromeOptions2.addArguments("--disable-dev-shm-usage");
                    chromeOptions2.addArguments("user-agent=Mozilla/5.0 (Linux; Android 13.0; Galaxy S23) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.0.0 Mobile Safari/537.36");
                    chromeOptions2.addArguments("window-size=360,800"); // Galaxy S23 boyutu

                    driver = new ChromeDriver(chromeOptions2);
                    break;

                case "firefox":

                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                    break;

                case "safari":

                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();

                    break;


                default:
                    throw new IllegalArgumentException("Browser " + browser + " not supported.");
            }
        }
        return driver;
    }



    public static WebDriver getDriver(){
        return driver;
    }

    // Quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
