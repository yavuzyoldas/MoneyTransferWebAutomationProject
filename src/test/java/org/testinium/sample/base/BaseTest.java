package org.testinium.sample.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.thoughtworks.gauge.*;
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
        System.out.println("flushReport1");
        if (test != null) {
            System.out.println("flushReport2");

            test.log(Status.INFO, "Scenario completed.");
        }
        ExtentManager.flushReport();
        System.out.println("flushReport");
    }

    @AfterSpec
    public void tearDown() {

        DriverFactory.quitDriver();
    }




}
