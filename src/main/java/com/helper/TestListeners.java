package com.helper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListeners extends Base implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String className = context.getAllTestMethods()[0].getRealClass().getSimpleName();
        extent = ExtentManager.getInstance(context.getAllTestMethods()[0].getRealClass());
        System.out.println("Test Execution Started: " + className);
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName().replaceAll("([a-z])([A-Z])", "$1 $2");
        ExtentTest test = extent.createTest(testName);
        testThread.set(test);
        LoggerUtil.setExtentTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = testThread.get();
        test.log(Status.PASS, " Test Passed");

        String className = result.getTestClass().getRealClass().getSimpleName();
        String relPath = Base.takeScreenshot(result.getName(), className);

        if (relPath != null) {
            test.pass("Screenshot on Success",
                    MediaEntityBuilder.createScreenCaptureFromPath(relPath).build());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = testThread.get();
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());

        String className = result.getTestClass().getRealClass().getSimpleName();
        String relPath = Base.takeScreenshot(result.getName(), className);

        if (relPath != null) {
            test.fail("Screenshot on Failure",
                    MediaEntityBuilder.createScreenCaptureFromPath(relPath).build());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Test Execution Completed: " + context.getName());

        try {
            addIndexColumnToExtentReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addIndexColumnToExtentReport() throws IOException {
        //  Dynamic latest ExtentReport file under test-output
        File currentDir = new File(System.getProperty("user.dir") + "\\test-output\\CurrentReport\\QuickMastersTest");
        File[] reportFiles = currentDir.listFiles((dir, name) -> name.startsWith("ExtentReport_") && name.endsWith(".html"));
        
        if (reportFiles == null || reportFiles.length == 0) {
            System.out.println(" No Extent report file found in: " + currentDir.getAbsolutePath());
            return;
        }

        //  Find latest report file
        File latestFile = reportFiles[0];
        for (File file : reportFiles) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println(" Adding Index column to: " + latestFile.getName());

        String html = new String(Files.readAllBytes(latestFile.toPath()), StandardCharsets.UTF_8);

        //  JavaScript to insert INDEX column dynamically before STATUS
        String script = """
        <script>
        document.addEventListener('DOMContentLoaded', function() {
            const tables = document.querySelectorAll('table.table');
            tables.forEach((table) => {
                if (!table.querySelector('thead')) return;
                const headerRow = table.querySelector('thead tr');
                if (headerRow && !headerRow.innerHTML.includes('INDEX')) {
                    const th = document.createElement('th');
                    th.innerText = 'INDEX';
                    th.style.textAlign = 'center';
                    th.style.color = '#FFFFFF';
                    headerRow.insertBefore(th, headerRow.firstChild);
                }
                const rows = table.querySelectorAll('tbody tr');
                let i = 1;
                rows.forEach((row) => {
                    const td = document.createElement('td');
                    td.innerHTML = "<b style='color:#00BFFF;'>#" + (i++) + "</b>";
                    td.style.textAlign = 'center';
                    row.insertBefore(td, row.firstChild);
                });
            });
        });
        </script>
        """;

        if (!html.contains("INDEX")) {
            html = html.replace("</body>", script + "</body>");
            Files.write(latestFile.toPath(), html.getBytes(StandardCharsets.UTF_8));
            
        } else {
            System.out.println(" Index column already exists — skipping injection.");
        }
    }
}
