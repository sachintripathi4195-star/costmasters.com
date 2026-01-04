package com.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    //  Creates a single ExtentReport instance per class
    public static ExtentReports getInstance(Class<?> testClass) {
        if (extent == null) {
            String className = testClass.getSimpleName();
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/test-output/CurrentReport/" + className + "/ExtentReport_" + className + "_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            
            sparkReporter.config().setTheme(Theme.DARK); 
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("project", "Beri(ICE)");
            extent.setSystemInfo("Host Name", "LocalHost");
            extent.setSystemInfo("Environment", "Senior-QA");
            extent.setSystemInfo("User Name", "Sachindra Mani Tripathi");
            extent.setSystemInfo("browser", "Chrome");
        }
        return extent;
    }

    public static synchronized void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    
    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

       public static void attachScreenshotToTest(String stepName, String screenshotPath) {
        if (screenshotPath != null) {
            try {
                ExtentManager.getTest().info(stepName,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                System.out.println(" Failed to attach screenshot: " + e.getMessage());
            }
        }
    }
}
