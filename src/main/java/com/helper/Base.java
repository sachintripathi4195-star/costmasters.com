package com.helper;
 
import static org.testng.Assert.assertEquals;
 
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.openqa.selenium.WebDriver;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.PrintWriter;
import java.io.StringWriter;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
 
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.logging.FileHandler;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import com.aventstack.extentreports.MediaEntityBuilder;
 
public class Base  {
 
	
	public static Properties prop;
	public static WebDriver driver;
	public static String DOWNLOAD_PATH;
	public WebDriverWait wait;
	
	public static Properties DataProp;
	
	
 
	static {
 
	    // 🔹 Load env.properties
	    try {
	        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/env.properties");
	        prop = new Properties();
	        prop.load(file);
	        LoggerUtil.info("✅ env.properties loaded successfully.");
	    } catch (FileNotFoundException e) {
	        LoggerUtil.error("❌ env.properties file not found → " + e.getMessage());
	    } catch (IOException e) {
	        LoggerUtil.error("❌ Failed to load env.properties → " + e.getMessage());
	    }
 
	    // 🔹 Load SystemData.properties
	    try {
	        FileInputStream sysFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/SystemData.properties");
	        DataProp = new Properties();
	        DataProp.load(sysFile);
	        LoggerUtil.info("✅ SystemData.properties loaded successfully.");
	    } catch (FileNotFoundException e) {
	        LoggerUtil.error("❌ SystemData.properties file not found → " + e.getMessage());
	    } catch (IOException e) {
	        LoggerUtil.error("❌ Failed to load SystemData.properties → " + e.getMessage());
	    }
	}
 
 
	public static void launchApplication() {
	    String browserName = prop.getProperty("browser");
	    switch (browserName.toLowerCase()) {
	        case "chrome":
	        	String downloadFilepath = System.getProperty("user.dir") + File.separator + "downloads";
	        	new File(downloadFilepath).mkdirs();
 
	        	System.out.print(downloadFilepath);
	        	HashMap<String, Object> chromePrefs = new HashMap<>();
	            chromePrefs.put("download.default_directory", downloadFilepath);
	            chromePrefs.put("download.prompt_for_download", false);
	            
	            chromePrefs.put("safebrowsing.enabled", true);
	            chromePrefs.put("credentials_enable_service", false);
	            chromePrefs.put("profile.password_manager_enabled", false);
 
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.setExperimentalOption("prefs", chromePrefs);
 
	          
	            
	          
	            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
	            chromeOptions.addArguments("--start-maximized");
 
	            driver = new ChromeDriver(chromeOptions);
	            break;
 
	        case "firefox":
	            FirefoxOptions fireOption = new FirefoxOptions();
	            fireOption.addArguments("--incognito");
	            fireOption.addArguments("--disable-notifications");
	            driver = new FirefoxDriver(fireOption);
	            break;
 
	        case "edge":
	            EdgeOptions edgeOption = new EdgeOptions();
	            edgeOption.addArguments("--disable-notifications");
	            driver = new EdgeDriver(edgeOption);
	            break;
	    }
 
	    driver.get(prop.getProperty("url"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
	}
	public static File getLatestFile() {
		String downloadPath = System.getProperty("user.dir") + "\\downloads";
		File dir = new File(downloadPath);

		File[] files = dir.listFiles((dir1, name) -> name.contains("Process List") && name.endsWith(".xlsx"));

		if (files == null || files.length == 0) {
		return null;
		}

		// Sort files by last modified date (newest first)
		File latestFile = files[0];
		for (File file : files) {
		if (file.lastModified() > latestFile.lastModified()) {
		latestFile = file;
		}
		}
		return latestFile;
		}


		public static void clearAndEnterText(WebElement ele, String value) {
		    try {
		        ele.clear();
		        ele.sendKeys(Keys.CONTROL + "a");
		        ele.sendKeys(Keys.DELETE);
		        // JS fallback for stubborn UI
		        if (!ele.getAttribute("value").isEmpty()) {
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            js.executeScript("arguments[0].value='';", ele);
		        }
		        ele.sendKeys(value);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	

		public static void clickOnElement(By by) {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(55));

		    try {
		        // Wait for clickability
		        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

		        // Normal Selenium click
		        element.click();
		       

		    } catch (Exception e) {
		        LoggerUtil.info(" trying JavaScript click for: " );

		        try {
		            WebElement element = waitForExpectedElement(by);

		            // Scroll to element first (important)
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            js.executeScript("arguments[0].scrollIntoView(true);", element);
		            Thread.sleep(300);

		            // JavaScript click fallback
		            js.executeScript("arguments[0].click();", element);
		          

		        } catch (Exception ex) {
		            LoggerUtil.error("JavaScript click also FAILED for: ");
		        }
		    }
		}

public static WebElement fluentWait(By locator, int timeoutSeconds, int pollingMillis) {
    Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(pollingMillis))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);
    
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

  public void enterValueAndPressEnter(By locator, String value) {
    WebElement element = waitForExpectedElement(locator);
    clearAndEnterText(element, value);
    element.sendKeys(Keys.ENTER);
}


	public void handleAlertPopup(String method) {

		Alert a = driver.switchTo().alert();

		switch (method) {
		case "select":
			a.accept();
			break;
		case "cancel":
			a.dismiss();
			break;

		}

	}

	public static void selectDropDownValue(By by, String value, String type) {

		Select s = new Select(waitForExpectedElement(by));

		switch (type) {
		case "visibleText":
			s.selectByVisibleText(value);
			break;
		case "index":
			s.selectByIndex(Integer.parseInt(value));
			break;
		case "selectValue":
			s.selectByValue(value);
			break;
		
		}

	}

	public void switchWindow(String title) {

		Set<String> allWindows = driver.getWindowHandles();

		for (String s : allWindows) {

			driver.switchTo().window(s);

			String actualTitle = driver.getTitle();

			if (actualTitle.equals(title)) {
				break;
			}

		}

	}

	public static void selectBootStrapDropDown(List<WebElement> list, String value) {
	    boolean found = false;

	    for (WebElement ele : list) {
	        String actualValue = ele.getText().trim();
	        if (actualValue.equalsIgnoreCase(value.trim())) {
	            try {
	                ele.click();
	                LoggerUtil.pass(" Clicked on option: " + actualValue);
	            } catch (Exception e) {
	                LoggerUtil.info(" Normal click failed, trying JS click for: " + actualValue);
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                js.executeScript("arguments[0].scrollIntoView(true);", ele);
	                js.executeScript("arguments[0].click();", ele);
	                LoggerUtil.pass(" Clicked on option using JS fallback: " + actualValue);
	            }
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        LoggerUtil.info(" Option '" + value + "' not found in dropdown list.");
	    }
	}


	public void switchFrame(String value) {
		driver.switchTo().frame(value);

	}

	public void mouseHover(By by) {

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(by)).build().perform();
	}

	public String getValue(WebElement ele) {

		String value = ele.getText();

		return value;

		}

		public String getTitleValue() {
		return driver.getTitle();
		}

		public void pressTab() {

		Actions a = new Actions(driver);

		a.sendKeys(Keys.TAB).build().perform();
		}
		public void pressBackSpace() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.BACK_SPACE).build().perform();
		}

	public static WebElement waitForElement(By by, int timeout) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		return w.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public static WebElement waitForExpectedElement(By by) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(60));

		return w.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public static String getRandomDecimalWithPrecision(int decimalPlaces, int min, int max) {
	    double value = min + Math.random() * (max - min);
	    return String.format("%." + decimalPlaces + "f", value);
	}
	
	public static  WebElement WaitForElementClickable(By by, int timeout) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return w.until(ExpectedConditions.elementToBeClickable(by));

	}

	public void waitForAlertPopup(int timeout) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		w.until(ExpectedConditions.alertIsPresent());
	}

	public void textValidation(By by, String expected) {
		String actualText = driver.findElement(by).getText();
		assertEquals(actualText, expected);

	}
	public static String takeScreenshot(String testName, String testClassName) {
	    if (driver == null) {
	        System.out.println("WebDriver is null, can't take screenshot");
	        return null;
	    }

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	   
	    String destDir = "test-output/CurrentReport/" + testClassName + "/Screenshots";  
	    new File(destDir).mkdirs(); 

	    String destFile = testName + "_" + timeStamp + ".png";
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    try {
	        Path destinationPath = Path.of(destDir, destFile);
	        Files.copy(src.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);  
	        System.out.println("Screenshot saved at: " + destinationPath.toString());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    
	    return "Screenshots/" + destFile;  
	}
	public int extractStartNumber(String text) {
	    
	    try {
	        String[] parts = text.split(" ");
	        return Integer.parseInt(parts[1].replace(",", ""));
	    } catch (Exception e) {
	        LoggerUtil.error(" Failed to extract start number from pagination text: " + text);
	        return -1;
	    }
	}


	public static File getLatestFileProcessMasterForSupplier() {
	    String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
	    File dir = new File(downloadPath);

	    // Ensure folder exists
	    if (!dir.exists()) {
	        dir.mkdirs();
	        System.out.println(" Downloads directory was missing — created: " + dir.getAbsolutePath());
	    }

	    // Filter only matching Excel files
	    File[] files = dir.listFiles((d, name) -> name.contains("Process Master_") && name.toLowerCase().endsWith(".xlsx"));

	    if (files == null || files.length == 0) {
	        System.out.println(" No 'Process Master' Excel files found in: " + downloadPath);
	        return null;
	    }

	    // Find the most recently modified file
	    File latestFile = Arrays.stream(files)
	            .max(Comparator.comparingLong(File::lastModified))
	            .orElse(null);

	    if (latestFile != null) {
	        System.out.println(" Latest 'Process Master' Excel file found: " + latestFile.getName());
	        System.out.println(" Last Modified: " + new Date(latestFile.lastModified()));
	    } else {
	        System.out.println(" No valid 'Process Master' file found after filtering.");
	    }

	    return latestFile;
	}

	
	public File getLatestExportedExcelFileForBopImported() {
	    String downloadDir = "F:\\ICE-PROJECT\\CostMasters-ICE-V5.0\\downloads";
	    File dir = new File(downloadDir);

	    File[] files = dir.listFiles((d, name) -> 
	        name.startsWith("BOP_Procurement_Imported") && name.endsWith(".xlsx"));

	    if (files == null || files.length == 0) {
	        LoggerUtil.fail("❌ No Imported BOP export files found in: " + downloadDir);
	        return null;
	    }

	    File latestFile = Arrays.stream(files)
	            .max(Comparator.comparingLong(File::lastModified))
	            .orElse(null);

	    if (latestFile != null) {
	        LoggerUtil.info("✅ Latest Imported BOP file found: " + latestFile.getAbsolutePath());
	    } else {
	        LoggerUtil.fail("❌ Could not determine latest Imported BOP file.");
	    }

	    return latestFile;
	}


	public static String getTodayWithCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
        return now.format(formatter);
    }
	public static File getLatestBOPProcurementInhouseFile() {
	    String downloadPath = System.getProperty("user.dir") + "\\downloads";
	    File dir = new File(downloadPath);

	    File[] files = dir.listFiles((dir1, name) ->
	        name.contains("BOP_Procurement_InHouse") && name.endsWith(".xlsx"));

	    if (files == null || files.length == 0) {
	        return null;
	    }

	    // Sort files by last modified date
	    File latestFile = files[0];
	    for (File file : files) {
	        if (file.lastModified() > latestFile.lastModified()) {
	            latestFile = file;
	        }
	    }
	    return latestFile;
	}

	public static File getLatestBOPProcurementInhouseFileForCustomer() {
	    String downloadPath = System.getProperty("user.dir") + "\\downloads";
	    File dir = new File(downloadPath);

	    File[] files = dir.listFiles((dir1, name) ->
	        name.contains("BOP_Sale_InHouse") && name.endsWith(".xlsx"));

	    if (files == null || files.length == 0) {
	        return null;
	    }

	    // Sort files by last modified date
	    File latestFile = files[0];
	    for (File file : files) {
	        if (file.lastModified() > latestFile.lastModified()) {
	            latestFile = file;
	        }
	    }
	    return latestFile;
	}





	// Method to delete file after processing
	public static void deleteFile(File file) {
		if (file != null && file.exists()) {
			if (file.delete()) {
				System.out.println("File deleted successfully: " + file.getName());

			} else {
				System.out.println("File Deleted Successfully" + file.getName());
			}

		}
	}
	
	public static File getLatestSupplierMasterFile() {
		String downloadPath = System.getProperty("user.dir") + "\\downloads";
		File dir = new File(downloadPath);

		File[] files = dir.listFiles((dir1, name) -> name.contains("SupplierMaster") && name.endsWith(".xlsx"));

		if (files == null || files.length == 0) {
		return null;
		}

		// Sort files by last modified date (newest first)
		File latestFile = files[0];
		for (File file : files) {
		if (file.lastModified() > latestFile.lastModified()) {
		latestFile = file;
		}
		}
		return latestFile;
		}

	
	
    public static File getLatestCustomerMasterFIle() {
    	String downloadPath = System.getProperty("user.dir") + "\\downloads";
		File dir = new File(downloadPath);
		File[] files = dir.listFiles((dir1, name) -> name.contains("CustomerMaster") && name.endsWith(".xlsx"));

		if (files == null || files.length == 0) {
		return null;
		}

	
		File latestFile = files[0];
		for (File file : files) {
		if (file.lastModified() > latestFile.lastModified()) {
		latestFile = file;
		}
		}
		return latestFile;
		}
   
    
    
    public static File getLatestNewSpecificGradeFileForCommodityGroup1() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);
        File[] files = dir.listFiles((dir1, name) -> name.contains("CommodityMaster") || name.contains("New specific grade addition") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            return null;
        }

        // Sort files by last modified date (newest first)
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }

    	
    public static void captureStepScreenshot(String stepName) {
        try {
            // Get test class from current thread if needed
            String className = LoggerUtil.getExtentTest() != null
                ? LoggerUtil.getExtentTest().getModel().getName().split(" ")[0].trim()
                : "Default";

            String screenshotPath = takeScreenshot(stepName, className);
            LoggerUtil.info("Screenshot captured for step: " + stepName + " | Path: " + screenshotPath);
            System.out.println(" Step Screenshot saved at: " + screenshotPath);

            ExtentTest test = LoggerUtil.getExtentTest();
            if (test != null && screenshotPath != null && !screenshotPath.isEmpty()) {
                test.info("Step: " + stepName,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }

        } catch (Exception ex) {
            LoggerUtil.info("Unexpected error in captureStepScreenshot for step '" + stepName + "': " + ex.getMessage());
        }
    }


    public  void safeAcceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String msg = alert.getText();

            System.out.println("Alert Message: " + msg);
            LoggerUtil.getExtentTest().info("Alert detected and accepted: " + msg);

            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert found to accept.");
            LoggerUtil.getExtentTest().info("No alert appeared.");
        }
    }

    	
    
    
    public static boolean waitForPageLoadAfterLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            LoggerUtil.info("Waiting for URL to contain 'login' after logout...");
            wait.until(ExpectedConditions.urlContains("login"));

            Thread.sleep(1000); // Small wait to ensure page load transition

            LoggerUtil.info("Waiting for Email input field to become visible...");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));

            LoggerUtil.info("Clearing cookies after successful logout...");
            driver.manage().deleteAllCookies();

            return true; // Logout completed successfully
        } catch (Exception e) {
            LoggerUtil.info("Timeout occurred while waiting for logout to complete. Error: " + e.getMessage());
            return false; // Logout incomplete
        }
    }

    public static void forceClick(By by) {
        WebElement element = waitForExpectedElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
       
    }


    
    protected void logAndAssert(String month, String type, String expected, String actual, SoftAssert softAssert) {
        String message = String.format("%s %s - Expected: %s, Actual: %s", month, type, expected, actual);
        LoggerUtil.info(" " + message);

        // Extent Report me bhi yahi log jaayega
        if (!expected.equals(actual)) {
            LoggerUtil.info(" Mismatch Found -> " + message);
        } else {
            LoggerUtil.info(" Match Found -> " + message);
        }

        softAssert.assertEquals(actual, expected, message);
    }
    
    
    public static void softAssertBigDecimalZeroOrExact(SoftAssert softAssert, BigDecimal expected, BigDecimal actual, String message) {
        BigDecimal expRounded = expected.setScale(3, RoundingMode.HALF_UP);
        BigDecimal actRounded = actual.setScale(3, RoundingMode.HALF_UP);

        if (expRounded.compareTo(actRounded) == 0) {
            LoggerUtil.info(" Assertion Passed: " + message + " Value: " + expRounded);
        } else {
            LoggerUtil.info(" Assertion Failed: " + message + " Expected: " + expRounded + " Found: " + actRounded);
            softAssert.fail(message + " Expected: " + expRounded + " Found: " + actRounded);
        }
    }
    
    	
    
    public static void logException(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        LoggerUtil.error("Exception occurred: " + e.getMessage() + "\nStack Trace:\n" + exceptionAsString);
    }
    
    
    
 
    public static File getLatestCommodityDetailsTabFile() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        File[] files = dir.listFiles((dir1, name) -> name.contains("Commodity Type") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            System.out.println(" No matching 'Commodity Type' files found in: " + downloadPath);
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println(" Latest Commodity File: " + latestFile.getName());
        return latestFile;
    }

   
    public static File getLatestCommodityDetailsTabFileGroupDelta() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        File[] files = dir.listFiles((d, name) ->
                name.endsWith(".xlsx") &&
                !name.startsWith("~$") &&             
                name.contains("Commodity Type Yearly-Delta"));

        if (files == null || files.length == 0) {
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println("Latest Commodity File: " + latestFile.getName());
        return latestFile;
    }

    public static File getLatestCommodityDetailsTabFileDirectCost() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        File[] files = dir.listFiles((dir1, name) -> name.contains("Commodity Type Yearly-DirectPrice") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            System.out.println(" No matching 'Commodity Type Yearly-DirectPrice' files found in: " + downloadPath);
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println(" Latest Commodity File: " + latestFile.getName());
        return latestFile;
    }
    
    public static File getLatestCommodityDetailsTabFileNewGrade() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        File[] files = dir.listFiles((dir1, name) -> name.contains("Commodity master yearly-New grades") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            System.out.println(" No matching 'Commodity Type Yearly-DirectPrice' files found in: " + downloadPath);
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println(" Latest Commodity File: " + latestFile.getName());
        return latestFile;
    }
    
    public static File getLatestExportedExcelFile() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        File[] files = dir.listFiles((file, name) ->
            name.contains("Commodity Type Yearly-Whole") &&
            name.endsWith(".xlsx") &&                   // Must be Excel
            !name.endsWith(".crdownload") &&            // Skip incomplete
            !name.endsWith(".tmp")
        );

        if (files == null || files.length == 0) {
            System.out.println("❌ No matching exported file found.");
            return null;
        }

        // Sort by last modified
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println("✅ Using file: " + latestFile.getAbsolutePath());
        return latestFile;

    }
	
    
    
    
    public static String getExpectedValueFromExcel(String filePath, int sheetIndex, int rowIndex, int columnIndex) {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            return cell.getStringCellValue();
                        case NUMERIC:
                            return String.valueOf((int) cell.getNumericCellValue());
                        case BOOLEAN:
                            return String.valueOf(cell.getBooleanCellValue());
                        default:
                            return "";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    
    
    public void jsScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    
    
    
    public String getLatestCommodityDomesticWholeFilePath() {
        String downloadPath = System.getProperty("user.home") + "F:\\ICE-PROJECT\\CostMasters-ICE-V5.0\\downloads";
        File downloadDir = new File(downloadPath);

        File[] files = downloadDir.listFiles((dir, name) -> 
            name.startsWith("Commodity_type_Domestic-Whole") && name.endsWith(".xlsx")
        );

        if (files == null || files.length == 0) {
            LoggerUtil.info("❌ No file found with prefix 'Commodity_type_Domestic-Whole'");
            return null;
        }

        File latestFile = Arrays.stream(files)
            .max(Comparator.comparingLong(File::lastModified))
            .orElse(null);

        if (latestFile != null) {
            LoggerUtil.info("✅ Latest file found: " + latestFile.getName());
            return latestFile.getAbsolutePath();
        } else {
            LoggerUtil.info("❌ No recent file matched.");
            return null;
        }
    }

    private static final String DOWNLOAD_DIR = "F:\\ICE-PROJECT\\CostMasters-ICE-V5.0\\downloads";
    private static final String FILE_PREFIX = "Commodity_type_Domestic-Whole";
    private static final String FILE_SUFFIX = ".xlsx";

    public static void main(String[] args) {
        try {
            String latestFilePath = getLatestFilePath(DOWNLOAD_DIR, FILE_PREFIX, FILE_SUFFIX);
            System.out.println("Latest file detected: " + latestFilePath);

            String sheetName = "Commodity domestic";  

            updateCellValue(latestFilePath, sheetName, 1, 10, "TestValue123");

            System.out.println("Excel file updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLatestFilePath(String folderPath, String prefix, String suffix) {
        File dir = new File(folderPath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid folder path: " + folderPath);
        }

        File[] files = dir.listFiles((d, name) -> name.startsWith(prefix) && name.endsWith(suffix));

        if (files == null || files.length == 0) {
            throw new RuntimeException("No matching files found");
        }

        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        return files[0].getAbsolutePath();
    }

    public static void updateCellValue(String filePath, String sheetName, int rowNum, int colNum, String value) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " not found");
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) row = sheet.createRow(rowNum);

            Cell cell = row.getCell(colNum);
            if (cell == null) cell = row.createCell(colNum);

            cell.setCellValue(value);

            fis.close(); // close before writing

            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
        }
    }

    
    public static File getLatestExportedExcelFileForCommoditytypedelta() {
    	String DOWNLOADS_PATH =System.getProperty("user.dir") + "\\downloads";
        File dir = new File(DOWNLOADS_PATH);

        // Check if directory exists
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println(" Directory not found or not a directory: " + DOWNLOADS_PATH);
            return null;
        }

        // Filter files that match the pattern "Commodity Type Yearly-Delta<date>_<time>.xlsx"
        FilenameFilter filter = (dir1, name) -> name.startsWith("Commodity Type Yearly-Delta") && name.endsWith(".xlsx");

        // Get all files that match the pattern
        File[] files = dir.listFiles(filter);

        if (files == null || files.length == 0) {
            System.out.println(" No matching files found in directory: " + DOWNLOADS_PATH);
            return null;
        }

        // Sort files by last modified time (descending order)
        Arrays.sort(files, (file1, file2) -> Long.compare(file2.lastModified(), file1.lastModified()));

        // The first file in the sorted array is the latest one
        File latestFile = files[0];

        // Log and return the latest file
        System.out.println(" Latest file found: " + latestFile.getAbsolutePath());
        return latestFile;
    }
    
    public static File getLatestExportedExcelFileForCurrencyDataAddition() {
        String downloadDirPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadDirPath);
        File[] matchingFiles = dir.listFiles((d, name) -> name.startsWith("CurrencyDataAddition_") && name.endsWith(".xlsx"));

        if (matchingFiles == null || matchingFiles.length == 0) {
            System.err.println("❌ No CurrencyDataAddition Excel files found in the directory.");
            return null;
        }

        File latestFile = Arrays.stream(matchingFiles)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);

        if (latestFile != null) {
            System.out.println(" Latest file found: " + latestFile.getAbsolutePath());
        }

        return latestFile;
    }

    
    public void pressCtrlSAndRefreshUI() {
	  
	    Actions actions = new Actions(driver);
	    actions.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
	    System.out.println(" Ctrl + S triggered via Actions.");

	  
	    driver.navigate().refresh();  // This refreshes the UI
	    System.out.println(" UI refreshed to reflect the saved data.");
	}


    public static File getLatestBOPProcurementStandardFile() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        // Wait for file download to complete (adjust time as needed)
        long startTime = System.currentTimeMillis();
        long maxWaitTime = 10000; // Maximum wait time (10 seconds)
        File[] files = dir.listFiles((dir1, name) -> 
            name.startsWith("BOP_Procurement_Standard") && name.endsWith(".xlsx"));

        // Wait until the latest file appears or max wait time is reached
        while (files == null || files.length == 0) {
            if (System.currentTimeMillis() - startTime > maxWaitTime) {
                LoggerUtil.error("No new BOP_Procurement_Standard file found after waiting.");
                return null;
            }
            try {
                Thread.sleep(500);  // Wait for half a second before retrying
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            files = dir.listFiles((dir1, name) -> 
                name.startsWith("BOP_Procurement_Standard") && name.endsWith(".xlsx"));
        }

        // Find the latest file based on last modified time
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        LoggerUtil.info("Latest BOP_Procurement_Standard file: " + latestFile.getName());
        return latestFile;
    }

	public static String captureScreenshot(WebDriver driver, String name) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/test-output/currentReport/Screenshots/" + name + "_"
					+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
			File dest = new File(path);
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
			return path;
		} catch (Exception e) {
			System.out.println("⚠️ Screenshot failed: " + e.getMessage());
			return null;
		}
	}

    public void closeChromeAlertWithRobot() {
        try {
            Robot robot = new Robot();
            robot.delay(3000); // wait for popup
            robot.keyPress(KeyEvent.VK_ESCAPE);  // ESC key se close karega
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static final By clickgofirstbtn = By.xpath("//div/button[normalize-space()='Go']");
    public static final By mailcustomername = By.xpath("//*[@id='UniqueMessageBody_24']/div/div/div/div/div/div[2]/table/tbody/tr/td[3]");
    public static String approveOutlookMail(String username, String password) throws InterruptedException {
        
        driver.get("https://outlook.office365.com/"); 
        
        // Enter the username (email)
        clearAndEnterText(waitForExpectedElement(By.id("i0116")), username);
        
        // Click next button
        clickOnElement(By.id("idSIButton9"));
        
        // Wait for password field to appear
        Thread.sleep(3000);
        
        // Enter the password
        clearAndEnterText(waitForExpectedElement(By.id("i0118")), password);
        
        
        clickOnElement(By.id("idSIButton9"));
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased wait time
        WebElement staySignedInCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        
        
        if (!staySignedInCheckbox.isSelected()) {
            clickOnElement(By.id("idSIButton9"));
        }
        
        
        Thread.sleep(5000);
        
        
        List<WebElement> emails = driver.findElements(By.xpath("//span[contains(text(),'Approval Mail')]"));

         
        if (!emails.isEmpty()) {
            WebElement latestEmail = emails.get(0); // The first email in the list is the latest
            // Wait for the email to be clickable
            WebDriverWait emailWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            emailWait.until(ExpectedConditions.elementToBeClickable(latestEmail));
            
            // Forcefully click the latest email using JavaScript (ensure it's in view and clickable)
            JavascriptExecutor js = (JavascriptExecutor) driver;
          //  js.executeScript("arguments[0].scrollIntoView(true);", latestEmail); // Scroll to the email if it's not in view
            js.executeScript("arguments[0].click();", latestEmail); // Force click the email
        }
        
        // Wait for the email to load
        Thread.sleep(3000);
        
        // Get the current window handle (the original window)
        String originalWindow = driver.getWindowHandle();
        
        // Switch to the new tab (there should now be at least 2 windows)
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);  // Switch to the new window
                break;
            }
        }

        // Wait for the "Approve" button to be visible and clickable
        WebElement approveButton = driver.findElement(By.xpath("//div/a[normalize-space()='Approve']"));
        WebDriverWait approveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        approveWait.until(ExpectedConditions.elementToBeClickable(approveButton));
        
        // Force click the "Approve" button using JavaScript
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
     
        jsExec.executeScript("arguments[0].click();", approveButton);

        // Wait for the approval process to finish
        Thread.sleep(3000);
        
        // Switch back to the original window (Inbox)
        driver.switchTo().window(originalWindow);
        
        // Wait for the inbox to reload after navigating back
        Thread.sleep(15000);
        
        // Wait for the email list to reload and ensure the second email is clickable
        List<WebElement> emails1 = driver.findElements(By.xpath("//span[contains(text(),'Commodity-Workflow')]"));
        
        // Ensure the email list is loaded and the emails are clickable
        WebDriverWait waitForEmails = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitForEmails.until(ExpectedConditions.visibilityOfAllElements(emails1));

        // Now, check if there are emails and select the latest one
        if (!emails1.isEmpty()) {
            WebElement latestEmail1 = emails1.get(0); // The first email in the list is the latest
            // Wait for the email to be clickable
            WebDriverWait emailWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
            emailWait1.until(ExpectedConditions.elementToBeClickable(latestEmail1));
            
            // Forcefully click the latest email using JavaScript
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
         
            js1.executeScript("arguments[0].click();", latestEmail1);
        }
        
        // Wait for the email to load
        Thread.sleep(12000);
        
        // Perform actions on the second mail (Approve it)
        WebElement approveButton1 = driver.findElement(By.xpath("//div/a[normalize-space()='Approve']"));
        WebDriverWait approveWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        approveWait1.until(ExpectedConditions.elementToBeClickable(approveButton1));
        
        // Force click the "Approve" button using JavaScript
        JavascriptExecutor jsExec1 = (JavascriptExecutor) driver;
    
        jsExec1.executeScript("arguments[0].click();", approveButton1);

        // Wait for the approval process to finish
        Thread.sleep(21000);
        
        driver.switchTo().window(originalWindow);
   
        
        // After the second approval, check for the final approval (confirmation) email
        List<WebElement> finalApprovalEmails = driver.findElements(By.xpath("//span[contains(text(),'Commodity Workflow')]"));
        
        if (!finalApprovalEmails.isEmpty()) {
            WebElement finalEmail = finalApprovalEmails.get(0);
            WebDriverWait finalEmailWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            finalEmailWait.until(ExpectedConditions.elementToBeClickable(finalEmail));
            
            // Force click the final approval email using JavaScript
            JavascriptExecutor jsFinal = (JavascriptExecutor) driver;
            
            jsFinal.executeScript("arguments[0].click();", finalEmail);
            Thread.sleep(4000);
            String customermailname = waitForExpectedElement(mailcustomername).getText();
            
            
            return customermailname;
        }
		return originalWindow;

 
    }

    public void pressEnterToConfirmSave() throws AWTException, InterruptedException {
    	 StringSelection path = new StringSelection("F:\\ICE-PROJECT\\CostMasters-ICE-V5.0\\downloads\\exported.xlsx");
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

         Robot robot = new Robot();
         Thread.sleep(2000);

         // Focus filename input
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_L);
         robot.keyRelease(KeyEvent.VK_L);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         Thread.sleep(500);

         // Paste full path
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         Thread.sleep(500);

         // Press Enter to save
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void handleSaveAsDialogToDownloadsFolder(String expectedFileName) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(2000); // Wait for Save As to appear

        // Step 1: Copy path + filename to clipboard
        String fullPath = "F:\\ICE-PROJECT\\CostMasters-ICE-V5.0\\downloads" + expectedFileName;
        StringSelection selection = new StringSelection(fullPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Step 2: Focus filename input (Alt + N or Ctrl + L + Tab for Windows 10/11)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);

        // Step 3: Paste path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);

        // Step 4: Confirm save
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000); // Wait for download to complete
    }

    public static void clickWithRetry(By locator, int maxTries) {
        int tries = 0;
        while (true) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(10))
                    .ignoring(org.openqa.selenium.StaleElementReferenceException.class)
                    .until(org.openqa.selenium.support.ui.ExpectedConditions
                        .refreshed(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(locator))) .click();
                   
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                if (++tries >= maxTries) throw e;
            }
        }
    }
    public void selectBootstrapDropdownValue(List<WebElement> dropdownOptions, String valueToSelect) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean isSelected = false;

	    for (WebElement option : dropdownOptions) {
	        String text = option.getText().trim();

	        if (text.equalsIgnoreCase(valueToSelect.trim())) {
	            try {
	                // Scroll into view
	                js.executeScript("arguments[0].scrollIntoView(true);", option);
	                Thread.sleep(300); // small wait to stabilize scroll

	                // Attempt JS click first
	                js.executeScript("arguments[0].click();", option);
	                isSelected = true;
	                break;

	            } catch (Exception e) {
	                try {
	                    // Fallback to normal click
	                    option.click();
	                    isSelected = true;
	                    break;
	                } catch (Exception ex) {
	                    System.out.println("Unable to click option: " + ex.getMessage());
	                }
	            }
	        }
	    }

	    if (!isSelected) {
	        throw new RuntimeException("Value '" + valueToSelect + "' not found in dropdown options.");
	    }
	}
    
    public void selectBootStrapDropDownAdvanced(List<WebElement> list, String value) {
	    boolean found = false;
 
	    for (WebElement ele : list) {
	        String actualValue = ele.getText().trim();
	        if (actualValue.equalsIgnoreCase(value.trim())) {
	            try {
	          
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	               
	                js.executeScript("arguments[0].click();", ele);
	                LoggerUtil.pass(" Clicked on option using JS fallback: " + actualValue);
	            }catch(Exception e) {
	            	
	            	e.printStackTrace();
	            	
	            }
	            found = true;
	            break;
	        }
	    }
 
	    if (!found) {
	        LoggerUtil.error(" Option '" + value + "' not found in dropdown list.");
	    }
	}
    private WebElement waitClickable(By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(locator)));
    }
    public void clickOnElement1(By locator) {
        long timeoutSeconds = 8;
        WebElement weObj = null;
        try {
            weObj = driver.findElement(locator);
            weObj.click();
           // System.out.println("Element clicked successfully.");
        } catch (ElementClickInterceptedException | NoSuchElementException e) {
            System.out.println("Standard click failed: " + e.getMessage());
            waitClickable(locator, timeoutSeconds);
            if (weObj != null) {
                try {
                    // Scroll into view
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", weObj);
                    Thread.sleep(300); // Small wait for animation/frame to settle
                    weObj.click();
                    System.out.println("Element clicked after scroll using explicit wait.");
                } catch (Exception ex) {
                    try {
                        // JavaScript click fallback
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", weObj);
                        System.out.println("Element clicked using JavaScript fallback.");
                    } catch (Exception jsEx) {
                        System.out.println("Element found but all click attempts failed: " + jsEx.getMessage());
                    }
                }try {
                	weObj.click();
				} catch (StaleElementReferenceException e2) {
					
				}
            } else {
                System.out.println("Unable to click. Element not found even after wait.");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error during click: " + e.getMessage());
        }
    }
    
    public void sendKeysToTextBox(By locator, String text) {
        long timeoutSeconds = 1;
        try {
            WebElement weObj = driver.findElement(locator);
            cleanTestBox(locator);
           // weObj.clear();
            weObj.sendKeys(text);
            System.out.println("Text entered successfully: " + text);
        } catch (NoSuchElementException e) {
            WebElement weObj = waitForVisibility(locator, timeoutSeconds);
            if (weObj != null) {
                weObj.clear();
                weObj.sendKeys(text);
                System.out.println("Text entered using explicit wait: " + text);
            } else {
                System.out.println("Unable to enter text. Element not found.");
            }
        }
    }
    
    public WebElement waitForVisibility(By locator, long timeoutSeconds) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("[ERROR] Element not visible: " + e.getMessage());
            return null;
        }
    }
    
   
    
    
    public List<WebElement> visibilityOfAllElementsLocated(By locator, long timeoutSeconds) {
        LoggerUtil.info("Waiting visibility of all: " + locator);
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		List<WebElement> els = wait.until(
		    ExpectedConditions.refreshed(
		        ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
		    )
		);
		LoggerUtil.info("Visible elements: " + els.size() + " for " + locator);
		return els;
    }

    public  WebElement elementToBeClickable(By locator,long timeoutSeconds) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return elementToBeClickable(locator,timeoutSeconds);
    }
    
    public void cleanTestBox(By locator) {
        long timeoutSeconds = 1;
        try {
            WebElement weObj = driver.findElement(locator);
            weObj.clear();
            //System.out.println("Textbox cleared successfully.");
        } catch (NoSuchElementException e) {
            WebElement weObj = waitForVisibility(locator, timeoutSeconds);
            if (weObj != null) {
                weObj.clear();
                System.out.println("Textbox cleared using explicit wait.");
            } else {
                System.out.println("Textbox could not be cleared.");
            }
        }
    }
    
    public String verifyDropdownPlaceholder(By locator, String expectedText) {
        long timeoutSeconds = 1;
        String actualText = "";

        try {
            WebElement dropdownElement = driver.findElement(locator);
            actualText = dropdownElement.getText().trim();

            if (actualText.equals(expectedText)) {
                System.out.println(" Placeholder verified: '" + actualText + "'");
            } else {
                System.out.println(" Placeholder mismatch. Expected: '" + expectedText + "', Found: '" + actualText + "'");
            }

        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("Initial fetch failed: " + e.getMessage());
            WebElement dropdownElement = waitForVisibility(locator, timeoutSeconds);

            if (dropdownElement != null) {
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
                    Thread.sleep(300);

                    actualText = dropdownElement.getText().trim();
                    if (actualText.equals(expectedText)) {
                        System.out.println(" Placeholder verified after wait: '" + actualText + "'");
                    } else {
                        System.out.println(" Placeholder mismatch after wait. Expected: '" + expectedText + "', Found: '" + actualText + "'");
                    }

                } catch (Exception ex) {
                    System.out.println("Error verifying placeholder after scroll: " + ex.getMessage());
                }
            } else {
                System.out.println("Element not found even after explicit wait.");
            }

        } catch (Exception ex) {
            System.out.println("Unexpected error during placeholder verification: " + ex.getMessage());
        }

        return actualText;
    }

    public String getAttributeValue(WebElement we,String expectedValue) {
    	String actualValue = null;
    	try {
    		 actualValue=we.getAttribute(expectedValue);
    		 System.out.println("Placeholder is correct: " + expectedValue);
        	
		} catch (Exception e) {
			 System.out.println("Placeholder is incorrect: " + expectedValue);
		}
		return actualValue;
    	
    }
    
    private List<WebElement> waitAllVisible(By locator, long timeoutSeconds) throws TimeoutException {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
		        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    private String normalize(String s) {
        if (s == null) return "";
        return s.replace('\u2013','-')     
                .replace('\u2014','-')      
                .replace('\u2212','-')      
                .replace('\u2011','-')      
                .replace('\u00A0',' ')      
                .replaceAll("[\\r\\n\\t]+"," ")
                .replaceAll("\\s+", " ")
                .trim();
    }
    
    public List<String> getVisibleTexts(By locator, long timeoutSeconds) throws TimeoutException {
        List<WebElement> nodes;
        try {
            nodes = driver.findElements(locator);
            if (nodes.isEmpty()) {
                LoggerUtil.info("getVisibleTexts: initial find returned 0; waiting up to " + timeoutSeconds + "s");
                nodes = waitAllVisible(locator, timeoutSeconds);
            }
        } catch (Exception e) {
            LoggerUtil.info("getVisibleTexts: initial find failed (" + e.getMessage() + "), waiting up to " + timeoutSeconds + "s");
            nodes = waitAllVisible(locator, timeoutSeconds);
        }

        if (nodes == null || nodes.isEmpty()) {
            LoggerUtil.info("getVisibleTexts: no elements found after wait.");
            return Collections.emptyList();
        }

        List<String> out = new ArrayList<>();
        int idx = 0;
        for (WebElement el : nodes) {
            try {
                if (!el.isDisplayed()) { idx++; continue; }

                // Bring into view (helps with virtualized lists)
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
                try { Thread.sleep(60); } catch (InterruptedException ignored) {}

                String text = normalize(el.getText());
                if (text.isBlank()) {
                    // Fallback to innerText/textContent via JS
                    text = normalize((String)((JavascriptExecutor) driver)
                            .executeScript("return (arguments[0].innerText||arguments[0].textContent||'').toString();", el));
                }

                if (!text.isBlank()) {
                    out.add(text);
                    LoggerUtil.info("getVisibleTexts[" + idx + "]: '" + text + "'");
                }
            } catch (StaleElementReferenceException sere) {
                LoggerUtil.info("getVisibleTexts[" + idx + "]: stale, skipping.");
            } catch (Exception ex) {
                LoggerUtil.info("getVisibleTexts[" + idx + "]: error -> " + ex.getMessage());
            }
            idx++;
        }

        // Deduplicate while preserving order
        List<String> unique = out.stream().distinct().collect(Collectors.toList());
        LoggerUtil.info("getVisibleTexts: total=" + unique.size() + " -> " + unique);
        return unique;
    }
    
    public String VerifyGetLatestFileForDirectPriceComGroupDetailsTab() {
	    String downloadPath = System.getProperty("user.dir") + "\\downloads";
	    File dir = new File(downloadPath);

	    // Filter files
	    File[] files = dir.listFiles((d, name) -> 
	        name.startsWith("Commodity Type Yearly-DirectPrice") && name.endsWith(".xlsx"));

	    if (files == null || files.length == 0) {
	        throw new RuntimeException("No DirectPrice excel files found in downloads folder!");
	    }

	    // Get the latest file
	    File latestFile = Arrays.stream(files)
	            .max(Comparator.comparingLong(File::lastModified))
	            .orElseThrow(() -> new RuntimeException("Unable to find latest DirectPrice excel file!"));

	    System.out.println("Latest DirectPrice Excel File → " + latestFile.getAbsolutePath());

	  
	    return latestFile.getAbsolutePath();
	}

    
    public static File getLatestNewSpecificGradeFileForCommodityGroup() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        // Filter only files starting with "New Specific Grade Addition" and ending with .xlsx
        File[] files = dir.listFiles((dir1, name) -> name.startsWith("New Specific Grade Addition") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            LoggerUtil.fail("No 'New Specific Grade Addition' Excel file found in downloads folder.");
            return null;
        }

        // Sort files by last modified date (pick latest)
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        LoggerUtil.pass("Latest 'New Specific Grade Addition' Excel file fetched: " + latestFile.getName());
        return latestFile;
    }

    
    public static String getLatestOHPFile() {
	    String downloadPath = System.getProperty("user.dir") + "\\downloads";
	    File dir = new File(downloadPath);

	    // Filter files
	    File[] files = dir.listFiles((d, name) -> 
	        name.startsWith("OHP") && name.endsWith(".xlsx"));

	    if (files == null || files.length == 0) {
	        throw new RuntimeException("No OHP excel files found in downloads folder!");
	    }

	    // Get the latest file
	    File latestFile = Arrays.stream(files)
	            .max(Comparator.comparingLong(File::lastModified))
	            .orElseThrow(() -> new RuntimeException("Unable to find latest OHP excel file!"));

	    System.out.println("Latest OHP Excel File → " + latestFile.getAbsolutePath());

	  
	    return latestFile.getAbsolutePath();
	}
    
    
    public static File getLatestOldCostingFile() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        // Filter only files that contain 'Old_Costing' and end with .xlsx
        File[] files = dir.listFiles((dir1, name) -> name.contains("Old_Costing") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            LoggerUtil.error("❌ No Old_Costing Excel file found in: " + downloadPath);
            return null;
        }

        // Sort by last modified date — newest first
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        LoggerUtil.info("✅ Latest Old_Costing Excel file detected: " + latestFile.getName());
        return latestFile;
    }
    
    
    
    
    
    public static File getLatestFilePartMasterForDetailCostingFile() {
		String downloadPath = System.getProperty("user.dir") + "\\downloads";
		File dir = new File(downloadPath);
 
		File[] files = dir.listFiles((dir1, name) -> name.contains("Detail Costing Sheet") && name.endsWith(".xlsx"));
 
		if (files == null || files.length == 0) {
		return null;
		}
 
		
		File latestFile = files[0];
		for (File file : files) {
		if (file.lastModified() > latestFile.lastModified()) {
		latestFile = file;
		}
		}
		return latestFile;
		}
    
    
    
    
    public static File getLatestBOMFile() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        // Filter files that start with "BOM_" and end with ".xlsx"
        File[] files = dir.listFiles((dir1, name) -> name.startsWith("BOM_") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            System.out.println("No BOM Excel file found in downloads folder.");
            return null;
        }

        // Sort files by last modified time (latest first)
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println("Latest BOM file found: " + latestFile.getName());
        return latestFile;
    }

    
    
    
    
    
    
    public void scrollDownToUpUntilElement(By locator) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {
            try {
                WebElement ele = driver.findElement(locator);
                if (ele.isDisplayed()) {
                    js.executeScript("arguments[0].scrollIntoView(true);", ele);
                    break;  // STOP scrolling once element is visible
                }
            } catch (Exception ignored) {}

            // Scroll UP (down → up)
            js.executeScript("window.scrollBy(0, -400);");
            Thread.sleep(200);
        }
    }

    
    
    
    
    public static File getLatestCustomExcelFileForging() {

        // Correct download folder (confirmed from your logs)
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File dir = new File(downloadPath);

        if (!dir.exists()) {
            LoggerUtil.error("❌ Download directory does not exist: " + downloadPath);
            return null;
        }

        // Match filenames like: _18-11-2025_11_38_09.xlsx
        File[] files = dir.listFiles((d, name) ->
                name.matches("^_\\d{2}-\\d{2}-\\d{4}_\\d{2}_\\d{2}_\\d{2}\\.xlsx$")
        );

        if (files == null || files.length == 0) {
            LoggerUtil.error("❌ No Excel files found matching pattern: _dd-MM-yyyy_HH_mm_ss.xlsx");
            return null;
        }

        // Pick the latest file
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        LoggerUtil.info("✅ Latest Excel File Found: " + latestFile.getAbsolutePath());
        return latestFile;
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }

    
    
}
    
    
    
	


