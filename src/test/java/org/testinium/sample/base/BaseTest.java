package org.testinium.sample.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;
import org.testinium.sample.util.ExtentManager;

import static com.thoughtworks.gauge.Specification.*;


public class BaseTest {

    public WebDriver driver;

    private ExtentTest test;

    @BeforeSpec
    public void setUp()  {

        driver = DriverFactory.getDriver("chrome");




    }
    @BeforeScenario
    public void beforeScenario( ) {


        /*test = ExtentManager.createTest("Scenario: " + scenario.getName());
        test.log(Status.INFO, "Scenario started.");*/
    }

    @AfterScenario
    public void afterScenario( ) {
        /*if (test != null) {
            test.log(Status.INFO, "Scenario completed.");
            ExtentManager.flushReport();
        }*/
    }

    @AfterSpec
    public void tearDown() {
        DriverFactory.quitDriver();
    }




}
