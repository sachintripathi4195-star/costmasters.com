package com.helper;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoggerUtil {
    public static final Logger logger = LogManager.getLogger(LoggerUtil.class);
    private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();
    private static ThreadLocal<Long> lastStepTime = new ThreadLocal<>();
  
    private static int stepIndex = 1; 
    private static ExtentTest test;

    public static void setTest(ExtentTest extentTest) {
        test = extentTest;
        stepIndex = 1; // reset counter for new test
    }
    
    
    public static void setExtentTest(ExtentTest test) {
        extentTestThread.set(test);
        lastStepTime.set(System.currentTimeMillis()); // reset timer for each test
    }

    public static ExtentTest getExtentTest() {
        return extentTestThread.get();
    }

    public static void info(String message) {
    	
    	
        long now = System.currentTimeMillis();

        Long prev = lastStepTime.get();
        if (prev != null) {
            long durationMs = now - prev;
            double durationSec = durationMs / 1000.0;
            String timeMsg = String.format("Execution time since last step: %.2f sec", durationSec);

           
            if (durationSec > 5.0) {
                String warnMsg = " " + timeMsg + " (Took longer than expected!)";
  
                logger.warn(warnMsg);

              
                if (getExtentTest() != null) {
                    getExtentTest().log(Status.WARNING,
                            "<span style='color:darkblue; font-weight:bold;'>" + warnMsg + "</span>");
                }
            } else {
                // Normal log
                logger.info(timeMsg);
                if (getExtentTest() != null) {
                    getExtentTest().info(timeMsg);
                }
            }
        }

        // Step ka main message log karo
        logger.info(message);
        if (getExtentTest() != null) {
            getExtentTest().info(message);
        }

        // Update last step time
        lastStepTime.set(now);
    }


    public static void error(String message) {
        logger.error(message);
        if (getExtentTest() != null) {
            getExtentTest().fail(message);
        }
    }

    public static void warn(String message) {
        logger.warn(message);
        if (getExtentTest() != null) {
            getExtentTest().warning(message);
        }
    }

    public static void pass(String message) {
        logger.info("PASS: " + message);
        if (getExtentTest() != null) {
            getExtentTest().pass(message);
        }
    }

    public static void mismatch(String message) {
        logger.error("Mismatch: " + message);
        if (getExtentTest() != null) {
            getExtentTest().log(Status.FAIL,
                "<span style='color:red; font-weight:bold;'>Mismatch:</span> " + message);
        }
    }

    public static void fail(String message) {
        logger.error("fail: " + message);
        if (getExtentTest() != null) {
            getExtentTest().log(Status.FAIL,
                "<span style='color:red; font-weight:bold;'>Mismatch:</span> " + message);
        }
    }

    public static void logException(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        LoggerUtil.error("Exception occurred: " + e.getMessage() + "\nStack Trace:\n" + exceptionAsString);
    }

    public static void mismatch(String title, String expected, String actual) {
        getExtentTest().fail("❌ " + title +
                "<br><b>Expected:</b> " + expected +
                "<br><b>Actual:</b> " + actual);

        logger.error("Mismatch - {} | Expected: {} | Actual: {}", title, expected, actual);
    }
    
    private static void logWithIndex(Status status, String details) {
        String indexedMessage = "<b>" + stepIndex++ + ".</b> " + details;
        test.log(status, indexedMessage);
    }
}
