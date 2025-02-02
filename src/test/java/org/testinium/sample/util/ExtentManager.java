package org.testinium.sample.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/extent-report.html";
            File reportsDir = new File(System.getProperty("user.dir") + "/reports");
            if (!reportsDir.exists()) {
                reportsDir.mkdirs(); // Klasör yoksa oluştur
            }
            System.out.println("Rapor yolu: " + reportPath);
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }


    public static ExtentTest createTest(String testName) {
        if (extent == null) {
            getInstance();  // Eğer extent null ise, başlat
        }
        test = extent.createTest(testName);
        return test;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
