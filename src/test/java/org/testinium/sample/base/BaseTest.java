package org.testinium.sample.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.thoughtworks.gauge.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.testinium.sample.util.ExtentManager;

import java.util.Locale;


public class BaseTest {

    static {
        Locale.setDefault(Locale.ENGLISH);
    }
    public WebDriver driver;

    protected ExtentTest test;
    private ExtentReports extent;

    //@ParameterizedTest
    //@ValueSource(strings = {"chrome", "firefox", "safari","mobile-chrome})


    @BeforeSpec
    public void beforeSpec()  {

        driver = DriverFactory.getDriver("chrome");

    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext context) {
        extent = ExtentManager.getInstance();  // Önce ExtentReports başlat
        String scenarioName = context.getCurrentScenario().getName();

        test = ExtentManager.createTest("Scenario is started" + scenarioName);  // Test oluştur

        if (test == null) {
            System.out.println("HATA: ExtentTest nesnesi null!");
        } else {
            test.log(Status.INFO, "Scenario started.");
        }

    }

    @AfterScenario
    public void afterScenario( ) {

        if (test != null) {

            ExtentManager.flushReport();
            test.log(Status.INFO, "Scenario completed.");
        }


    }

    @AfterSpec
    public void tearDown() {

        DriverFactory.quitDriver();
    }




}
