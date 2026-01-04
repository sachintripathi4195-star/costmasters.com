package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
 // if using older ExtentReports

 // ✅ your custom logger utility


import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.helper.Base;
import com.helper.ExcelFiller;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

public class CurrencyPage extends Base {
	
	DashboardPage dashboard = new DashboardPage();
	
	public static final By converttocurrency = By.xpath("//*[@id='select2-CurrencyId-container']");
	public static final By datasource = By.xpath("//*[@id='Idd']");
	public static final By savebtn = By.xpath("//button[@onclick='SaveSubgroups()']");
	public static final By toastmsg = By.xpath("//*[@id='toast-container']/div/div[2]");
	
	public static final By toastmsgforspecific = By.xpath("//*[@id='toast-container']/div/div");
	public static final By searchinputconverttocurrency = By.xpath("//input[@class='select2-search__field']");
	public void verifysavedataandfetch(String value) throws InterruptedException {
	    LoggerUtil.info("Step 1: Clicking on Data Source dropdown...");
	    clickOnElement(datasource);

	    LoggerUtil.info("Step 2: Fetching data source options and selecting: " + value);
	    List<WebElement> datasourcelist = driver.findElements(By.xpath("//*[@id='Idd']/option"));
	    selectBootStrapDropDown(datasourcelist, value);

	    Thread.sleep(2000); // Ideally replace with wait

	    LoggerUtil.info("Step 3: Clicking on Save button...");
	    clickOnElement(savebtn);

	    LoggerUtil.info("Step 4: Waiting for toast message...");
	    WebElement toast = waitForExpectedElement(toastmsgforspecific);
	    String actualmsg = toast.getText().trim();
	    String expectedmsg = "Required Convert to Currency factor.!";

	    LoggerUtil.info("Step 5: Verifying toast message.");
	    LoggerUtil.info("Expected Message: '" + expectedmsg + "'");
	    LoggerUtil.info("Actual Message:   '" + actualmsg + "'");

	    if (actualmsg.equals(expectedmsg)) {
	        LoggerUtil.info("✅ Toast message verification passed.");
	    } else {
	        LoggerUtil.error("❌ Toast message verification failed. Mismatch found!");
	    }

	    // Optional assertion (if failure should stop test)
	    Assert.assertEquals(actualmsg, expectedmsg, "Toast message mismatch!");
	}

	public void verifysavedataandfetchWithoutDataSource() throws InterruptedException {
	    LoggerUtil.info("Step 1: Opening 'Convert to Currency' dropdown.");
	    clickOnElement(converttocurrency);

	    LoggerUtil.info("Step 2: Selecting currency: 'Afghanistan-Afghanis'.");
	    WebElement search = driver.findElement(searchinputconverttocurrency);
	    search.sendKeys("Afghanistan-Afghanis");
	    search.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);

	    LoggerUtil.info("Step 3: Attempting to save without selecting Data Source.");
	    clickOnElement(savebtn);
	    Thread.sleep(5000);

	    String actualMsg = waitForExpectedElement(toastmsgforspecific).getText().trim();
	    String expectedMsg = "Required Data Source.!";

	    LoggerUtil.info("Expected Toast Message: '" + expectedMsg + "'");
	    LoggerUtil.info("Actual Toast Message:   '" + actualMsg + "'");

	    if (actualMsg.equals(expectedMsg)) {
	        LoggerUtil.pass("✅ Proper validation triggered for missing Data Source.");
	    } else {
	        LoggerUtil.error("❌ Validation failed. Expected: '" + expectedMsg + "', but got: '" + actualMsg + "'");
	    }

	    Assert.assertEquals(actualMsg, expectedMsg, "Validation toast message mismatch.");
	}



	public static final By fetchingconvertTocurrencydata = By.xpath("//table[@id='example1']/tbody/tr/td[2]");
	public static final By deletebtn = By.xpath("//*[@id='example1']/tbody/tr/td[5]/a/span/i");
	public static final By searchinput = By.xpath("//*[@id='example1_filter']/label/input");
	public void savevalidcurrency(String enetrsearchvalue) throws InterruptedException {
	    LoggerUtil.info("Step 1: Clicking on 'Convert to Currency' dropdown.");
	    clickOnElement(converttocurrency);

	    LoggerUtil.info("Step 2: Searching and selecting currency value: Singapore-Dollar");
	    WebElement search = driver.findElement(searchinputconverttocurrency);
	    search.sendKeys("Singapore-Dollar");
	    search.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);

	    Thread.sleep(4000); // Wait for dropdown to populate

	    LoggerUtil.info("Step 3: Setting Data Source to value '1' (e.g. RBI) using JavaScript.");
	    WebElement dropdown = driver.findElement(By.id("Idd"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	        "let select = arguments[0];" +
	        "select.value = '1';" +
	        "select.dispatchEvent(new Event('input', { bubbles: true }));" +
	        "select.dispatchEvent(new Event('change', { bubbles: true }));" +
	        "select.dispatchEvent(new Event('blur', { bubbles: true }));",
	        dropdown
	    );

	    Thread.sleep(1000);
	    Select s = new Select(driver.findElement(By.id("Idd")));
	    LoggerUtil.info("Selected Data Source option: " + s.getFirstSelectedOption().getText());

	    Thread.sleep(2000);

	    LoggerUtil.info("Step 4: Clicking Save button to save currency data.");
	    clickOnElement(savebtn);
	    Thread.sleep(3000);

	    LoggerUtil.info("Step 5: Refreshing page to verify saved value.");
	    driver.navigate().refresh();
	    Thread.sleep(2000);

	    LoggerUtil.info("Step 6: Searching for saved currency: " + enetrsearchvalue);
	    clearAndEnterText(waitForExpectedElement(searchinput), enetrsearchvalue);
	    Thread.sleep(2000);

	    String actualvalue = waitForExpectedElement(fetchingconvertTocurrencydata).getText().trim();
	    LoggerUtil.info("Expected Currency: '" + enetrsearchvalue + "'");
	    LoggerUtil.info("Actual Currency:   '" + actualvalue + "'");

	    if (enetrsearchvalue.equals(actualvalue)) {
	        LoggerUtil.pass("✅ Data has been saved and verified successfully.");
	    } else {
	        LoggerUtil.error("❌ Mismatch found! Expected: '" + enetrsearchvalue + "', but got: '" + actualvalue + "'");
	    }

	    Assert.assertEquals(enetrsearchvalue, actualvalue, "Saved currency value mismatch!");

	    LoggerUtil.info("Step 7: Deleting the saved currency entry for cleanup.");
	    clickOnElement(deletebtn);
	    driver.switchTo().alert().accept();
	}

	
	
	
	public void verifyduplicatedata(String enetrsearchvalue) throws InterruptedException {
	    LoggerUtil.info("Step 1: Opening 'Convert to Currency' dropdown.");
	    clickOnElement(converttocurrency);

	    LoggerUtil.info("Step 2: Searching and selecting 'Singapore-Dollar'.");
	    WebElement search = driver.findElement(searchinputconverttocurrency);
	    search.sendKeys("Singapore-Dollar");
	    search.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);

	    Thread.sleep(4000); // wait for dropdown population

	    LoggerUtil.info("Step 3: Setting Data Source to '1' using JavaScript.");
	    WebElement dropdown = driver.findElement(By.id("Idd"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	        "let select = arguments[0];" +
	        "select.value = '1';" +
	        "select.dispatchEvent(new Event('input', { bubbles: true }));" +
	        "select.dispatchEvent(new Event('change', { bubbles: true }));" +
	        "select.dispatchEvent(new Event('blur', { bubbles: true }));",
	        dropdown
	    );
	    Thread.sleep(1000);

	    Select s = new Select(driver.findElement(By.id("Idd")));
	    LoggerUtil.info("Selected Data Source: " + s.getFirstSelectedOption().getText());

	    LoggerUtil.info("Step 4: Saving first currency entry.");
	    clickOnElement(savebtn);
	    Thread.sleep(3000);

	    LoggerUtil.info("Step 5: Refreshing and trying to save duplicate currency entry.");
	    driver.navigate().refresh();
	    Thread.sleep(3000);

	    clickOnElement(converttocurrency);
	    WebElement search1 = driver.findElement(searchinputconverttocurrency);
	    search1.sendKeys("Singapore-Dollar");
	    search1.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);

	    WebElement dropdown1 = driver.findElement(By.id("Idd"));
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript(
	        "let select = arguments[0];" +
	        "select.value = '1';" +
	        "select.dispatchEvent(new Event('input', { bubbles: true }));" +
	        "select.dispatchEvent(new Event('change', { bubbles: true }));" +
	        "select.dispatchEvent(new Event('blur', { bubbles: true }));",
	        dropdown1
	    );

	    LoggerUtil.info("Step 6: Clicking Save again to verify duplicate handling.");
	    clickOnElement(savebtn);

	    String actualDuplicatePopup = waitForExpectedElement(toastmsg).getText().trim();
	    String expectedPopup = "Currency details already exist.!";

	    LoggerUtil.info("Expected Toast Message: '" + expectedPopup + "'");
	    LoggerUtil.info("Actual Toast Message:   '" + actualDuplicatePopup + "'");

	    if (actualDuplicatePopup.equals(expectedPopup)) {
	        LoggerUtil.pass("✅ Duplicate currency message appeared correctly.");
	    } else {
	        LoggerUtil.error("❌ Duplicate message mismatch! Expected: '" + expectedPopup + "', but got: '" + actualDuplicatePopup + "'");
	    }

	    Assert.assertEquals(actualDuplicatePopup, expectedPopup, "Duplicate toast message mismatch!");

	    LoggerUtil.info("Step 7: Refreshing to validate the saved value via search.");
	    driver.navigate().refresh();
	    Thread.sleep(3000);

	    clearAndEnterText(waitForExpectedElement(searchinput), enetrsearchvalue);
	    Thread.sleep(2000);

	    String actualValue = waitForExpectedElement(fetchingconvertTocurrencydata).getText().trim();

	    LoggerUtil.info("Expected Search Result: '" + enetrsearchvalue + "'");
	    LoggerUtil.info("Actual Search Result:   '" + actualValue + "'");

	    if (actualValue.equals(enetrsearchvalue)) {
	        LoggerUtil.pass("✅ Saved value appears correctly in the table.");
	    } else {
	        LoggerUtil.error("❌ Table value mismatch after save!");
	    }

	    Assert.assertEquals(enetrsearchvalue, actualValue, "Saved currency value not found in table!");

	    LoggerUtil.info("Step 8: Cleaning up the saved entry by deleting it.");
	    clickOnElement(deletebtn);
	    driver.switchTo().alert().accept();

	    
	}

	
	
	
	
	public static final By Basecurrency = By.xpath("//input[@id='BaseCurrency']");
	
	public void verifybasecurrencyisreadable() {
	    LoggerUtil.info("Step 1: Waiting for Base Currency field to be clickable.");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.elementToBeClickable(Basecurrency));

	    LoggerUtil.info("Step 2: Checking if Base Currency field is readonly.");
	    String actualValue = waitForExpectedElement(Basecurrency).getAttribute("readonly");

	    try {
	        if (actualValue != null) {
	            LoggerUtil.info("Base Currency 'readonly' attribute found: " + actualValue);
	            LoggerUtil.pass("✅ Base Currency field is not writable (readonly is present).");
	        } else {
	            LoggerUtil.error("❌ Base Currency field is writable! 'readonly' attribute not present.");
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("⚠️ Exception occurred while verifying readonly status: " + e.getMessage());
	    }
	}

	
	public void searchchfunctionality() throws InterruptedException {
	    LoggerUtil.info("Step 1: Entering search keyword 'America-Dollars' into search input.");
	    clearAndEnterText(waitForExpectedElement(searchinput), "America-Dollars");

	    Thread.sleep(6000);
	    LoggerUtil.info("Step 2: Fetching result from 'Convert to Currency' table.");
	    String actualData = waitForExpectedElement(fetchingconvertTocurrencydata).getText().trim();
	    String expectedData = "America-Dollars";

	    LoggerUtil.info("Expected Result: '" + expectedData + "'");
	    LoggerUtil.info("Actual Result:   '" + actualData + "'");

	    if (actualData.equals(expectedData)) {
	        LoggerUtil.pass("✅ Search functionality working correctly. Matching result found.");
	    } else {
	        LoggerUtil.error("❌ Search result mismatch. Expected: '" + expectedData + "', but found: '" + actualData + "'");
	    }

	    Assert.assertEquals(actualData, expectedData, "Search functionality is not working as expected.");
	}

	
	
	public static final By fiscalyeardropdown = By.xpath("//*[@id='year']");
	public void findingplaceholdervalueforfiscalyear() throws InterruptedException {
		
		clickOnElement(fiscalyeardropdown);
		Thread.sleep(2000);
	    List<WebElement> fiscaldropdowns = driver.findElements(By.xpath("//*[@id='year']/option"));	
	   
	     WebElement firstOption = fiscaldropdowns.get(0);
	     
	     String placeholdervalue = firstOption.getText();
	     
	     if(placeholdervalue.equals("Select")) {
	    	 
	    	 LoggerUtil.info("Placeholder value is visible = " + placeholdervalue);
	    	 
	     }
	     else {
	    	 
	    	 LoggerUtil.error("place holder value is not visible..");
	     }
   
	}
	  
	
	public void verifyyearareinassendingornot() throws InterruptedException {
	    LoggerUtil.info("Step 1: Waiting for year dropdown to become visible.");
	    Thread.sleep(5000); // optional - can be replaced with wait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));

	    LoggerUtil.info("Step 2: Retrieving all options from year dropdown.");
	    Select selectYear = new Select(dropdown);
	    List<WebElement> options = selectYear.getOptions();

	    List<Integer> years = new ArrayList<>();
	    LoggerUtil.info("Step 3: Extracting year values (excluding placeholder).");

	    for (WebElement option : options) {
	        String optionText = option.getText().trim();
	        if (!optionText.equalsIgnoreCase("Select")) {
	            int yearValue = Integer.parseInt(optionText.split("-")[0].trim());
	            years.add(yearValue);
	        }
	    }

	    LoggerUtil.info("Extracted Years: " + years);

	    LoggerUtil.info("Step 4: Verifying if the years are in ascending order.");
	    boolean isAscending = true;
	    for (int i = 1; i < years.size(); i++) {
	        if (years.get(i) < years.get(i - 1)) {
	            isAscending = false;
	            LoggerUtil.error("Year order issue found at index " + i + ": " + years.get(i - 1) + " > " + years.get(i));
	            break;
	        }
	    }

	    if (isAscending) {
	        LoggerUtil.pass("✅ The years are displayed in ascending order.");
	    } else {
	        LoggerUtil.error("❌ The years are NOT in ascending order.");
	    }
	}

	
	
	 public static final By fetchingBasecurrencycellvalue = By.xpath("//*[@id='BaseCurrency']");
	 public void verifyBaseCurrencyCell() {
		    LoggerUtil.info("Step 1: Fetching value from Base Currency cell.");
		    String actualValue = waitForExpectedElement(fetchingBasecurrencycellvalue).getAttribute("value").trim();
		    String expectedValue = "India-Rupees";

		    LoggerUtil.info("Expected Base Currency: '" + expectedValue + "'");
		    LoggerUtil.info("Actual Base Currency:   '" + actualValue + "'");

		    if (actualValue.equals(expectedValue)) {
		        LoggerUtil.pass("✅ Base Currency cell contains correct value: " + actualValue);
		    } else {
		        LoggerUtil.error("❌ Base Currency mismatch! Expected: '" + expectedValue + "', but found: '" + actualValue + "'");
		    }

		    Assert.assertEquals(actualValue, expectedValue, "Base Currency cell value mismatch!");
		}

	 
	 public static final By listdrop = By.xpath("//*[@id='Idd']/option");
	 public void verifydatasourcelist() {
		    LoggerUtil.info("Step 1: Fetching all dropdown options from Data Source list.");
		    List<WebElement> numberOfOptions = driver.findElements(listdrop);
		    int totalOptions = numberOfOptions.size();

		    LoggerUtil.info("Total options found in Data Source dropdown: " + totalOptions);

		    for (WebElement value : numberOfOptions) {
		        String optionText = value.getText().trim();
		        LoggerUtil.info("Dropdown Option Found: " + optionText);

		        switch (optionText) {
		            case "RBI":
		                LoggerUtil.pass("✅ 'RBI' option is present in the Data Source dropdown.");
		                break;
		            case "Misc":
		                LoggerUtil.pass("✅ 'Misc' option is present in the Data Source dropdown.");
		                break;
		            case "Select":
		                LoggerUtil.pass("✅ 'Select' option is present in the Data Source dropdown.");
		                break;
		            default:
		                LoggerUtil.mismatch("⚠️ Unexpected option found in dropdown: '" + optionText + "'");
		        }
		    }
		}

	 
	 public static final By converttocurrencylistname = By.xpath("//table[@id='example1']/tbody/tr/td[2]"); // For the first table's currency column
	 public static final By secondtabheadername = By.xpath("//table[@id='tableV2']/thead/tr/th/following-sibling::th"); // For second table headers

	 public void verifyheadermatchedornot() throws InterruptedException {
		    LoggerUtil.info("Step 1: Fetching currency names from the first table.");
		    List<WebElement> currencyList = driver.findElements(converttocurrencylistname);
		    int currencyCount = currencyList.size();
		    LoggerUtil.info("Number of currency entries found: " + currencyCount);

		    List<String> currencyNames = new ArrayList<>();
		    for (WebElement currency : currencyList) {
		        String currencyText = currency.getText().trim();
		        currencyNames.add(currencyText);
		        LoggerUtil.info("Currency Found: " + currencyText);
		    }

		    LoggerUtil.info("Step 2: Navigating to Currency Data Addition tab.");
		    Thread.sleep(7000); // Optional: Can be replaced with wait
		    dashboard.currencydataadditiontab();
		    Thread.sleep(2000);

		    LoggerUtil.info("Step 3: Fetching header values from the second tab.");
		    List<WebElement> secondTabHeaders = driver.findElements(secondtabheadername);
		    int headerCount = secondTabHeaders.size();
		    LoggerUtil.info("Number of headers found: " + headerCount);

		    List<String> headerNames = new ArrayList<>();
		    for (WebElement header : secondTabHeaders) {
		        String headerText = header.getText().trim();
		        headerNames.add(headerText);
		        LoggerUtil.info("Header Found: " + headerText);
		    }

		    LoggerUtil.info("Step 4: Validating currency names vs header names.");
		    if (currencyNames.equals(headerNames)) {
		        LoggerUtil.pass("✅ Currency list and second tab headers are identical and matched.");
		    } else {
		        LoggerUtil.error("❌ Currency list and second tab headers do NOT match.");
		        LoggerUtil.mismatch("Currency List: " + currencyNames.toString());
		        LoggerUtil.mismatch("Header List:   " + headerNames.toString());
		    }
		}

		 
		 
	 public static final By clickforassendingorder = By.xpath("//table[@id='example1']/thead/tr/th[2]");
	 public static final By convertTocurrencyData = By.xpath("//table[@id='example1']/tbody/tr/td[2]");

	 public void verifySortingConvertToCurrency() throws InterruptedException {
		    LoggerUtil.info("Step 1: Clicking on the column header to trigger sorting.");
		    clickOnElement(clickforassendingorder);

		    LoggerUtil.info("Waiting for table to update after first click (descending sort).");
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example1']/tbody/tr/td[2]")));

		    WebElement sortingElement = driver.findElement(clickforassendingorder);
		    wait.until(ExpectedConditions.elementToBeClickable(sortingElement));

		    LoggerUtil.info("Step 2: Clicking on the header multiple times to reach ascending order state.");
		    for (int i = 0; i < 4; i++) {
		        sortingElement.click();
		        Thread.sleep(500); // Small pause to allow UI to catch up
		    }

		    LoggerUtil.info("Waiting for table to update after ascending sort.");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example1']/tbody/tr/td[2]")));

		    LoggerUtil.info("Step 3: Reading currency values from the sorted column.");
		    List<WebElement> listOfConvertToCurrency = driver.findElements(convertTocurrencyData);
		    List<String> actualCurrencyList = new ArrayList<>();

		    for (WebElement currency : listOfConvertToCurrency) {
		        actualCurrencyList.add(currency.getText().trim());
		    }

		    LoggerUtil.info("Original (actual UI) currency list: " + actualCurrencyList);

		    List<String> expectedSortedList = new ArrayList<>(actualCurrencyList);
		    Collections.sort(expectedSortedList);

		    LoggerUtil.info("Expected (sorted) currency list: " + expectedSortedList);

		    LoggerUtil.info("Step 4: Comparing actual vs expected currency order.");
		    if (actualCurrencyList.equals(expectedSortedList)) {
		        LoggerUtil.pass("✅ The currency column is correctly sorted in ascending order.");
		    } else {
		        LoggerUtil.mismatch("❌ The currency column is NOT sorted correctly in ascending order.");
		    }
		}



	 public static final By clickforbaseheaderassending = By.xpath("//*[@id='example1']/thead/tr/th[4]"); // XPath for the column header
	 public static final By BaseSourceData = By.xpath("//table[@id='example1']/tbody/tr/td[4]"); // XPath for the column data

	 public void verifySortingForBaseSource() throws InterruptedException {
		    LoggerUtil.info("Step 1: Clicking on the 'Base Source' column header to trigger sorting.");
		    clickOnElement(clickforbaseheaderassending);

		    LoggerUtil.info("Waiting for the table data under Base Source column to become visible.");
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example1']/tbody/tr/td[4]")));

		    LoggerUtil.info("Step 2: Reading all values from the 'Base Source' column.");
		    List<WebElement> listOfBaseSourceData = driver.findElements(BaseSourceData);
		    List<String> actualBaseSourceList = new ArrayList<>();

		    for (WebElement baseSource : listOfBaseSourceData) {
		        actualBaseSourceList.add(baseSource.getText().trim());
		    }

		    LoggerUtil.info("Actual Base Source Values from UI: " + actualBaseSourceList);

		    List<String> expectedSortedList = new ArrayList<>(actualBaseSourceList);
		    Collections.sort(expectedSortedList);

		    LoggerUtil.info("Expected Sorted Base Source Values: " + expectedSortedList);

		    LoggerUtil.info("Step 3: Comparing actual vs expected sorted list.");
		    if (actualBaseSourceList.equals(expectedSortedList)) {
		        LoggerUtil.pass("✅ The 'Base Source' column is correctly sorted in ascending order.");
		    } else {
		        LoggerUtil.mismatch("❌ The 'Base Source' column is NOT sorted correctly in ascending order.");
		    }
		}

	 
	 public static final By searchfunctionality = By.xpath("//*[@id='example1_filter']/label/input");
	 public void verifysearchfunctionality() {
		    LoggerUtil.info("Step 1: Entering 'America-Dollars' into the search input field.");
		    clearAndEnterText(waitForExpectedElement(searchfunctionality), "America-Dollars");

		    LoggerUtil.info("Step 2: Fetching the result displayed after search.");
		    String actualSearchData = waitForExpectedElement(fetchingconvertTocurrencydata).getText().trim();
		    String expectedData = "America-Dollars";

		    LoggerUtil.info("Expected Search Result: '" + expectedData + "'");
		    LoggerUtil.info("Actual Search Result:   '" + actualSearchData + "'");

		    if (actualSearchData.equals(expectedData)) {
		        LoggerUtil.pass("✅ Search functionality is working as expected. Matching result found.");
		    } else {
		        LoggerUtil.error("❌ Search functionality failed. Expected: '" + expectedData + "', but found: '" + actualSearchData + "'");
		    }

		    Assert.assertEquals(actualSearchData, expectedData, "Search functionality is not working well...");
		}

	 
	 public void deletebtn(String enetrsearchvalue) throws InterruptedException {
		    LoggerUtil.info("Step 1: Opening 'Convert to Currency' dropdown.");
		    clickOnElement(converttocurrency);

		    LoggerUtil.info("Step 2: Searching and selecting currency value: Singapore-Dollar");
		    WebElement search = driver.findElement(searchinputconverttocurrency);
		    search.sendKeys("Singapore-Dollar");
		    search.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);

		    Thread.sleep(4000); // wait for dropdown to populate

		    LoggerUtil.info("Step 3: Setting Data Source using JavaScript to value '1' (RBI).");
		    WebElement dropdown = driver.findElement(By.id("Idd"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "let select = arguments[0];" +
		        "select.value = '1';" +
		        "select.dispatchEvent(new Event('input', { bubbles: true }));" +
		        "select.dispatchEvent(new Event('change', { bubbles: true }));" +
		        "select.dispatchEvent(new Event('blur', { bubbles: true }));",
		        dropdown
		    );
		    Thread.sleep(1000);

		    Select s = new Select(driver.findElement(By.id("Idd")));
		    LoggerUtil.info("Selected Data Source option: " + s.getFirstSelectedOption().getText());

		    Thread.sleep(2000);
		    LoggerUtil.info("Step 4: Clicking Save to store currency entry.");
		    clickOnElement(savebtn);
		    Thread.sleep(3000);

		    LoggerUtil.info("Step 5: Refreshing page to validate saved value.");
		    driver.navigate().refresh();
		    Thread.sleep(2000);

		    LoggerUtil.info("Step 6: Searching with value: " + enetrsearchvalue);
		    clearAndEnterText(waitForExpectedElement(searchinput), enetrsearchvalue);
		    Thread.sleep(2000);

		    String actualValue = waitForExpectedElement(fetchingconvertTocurrencydata).getText().trim();
		    LoggerUtil.info("Expected: " + enetrsearchvalue + " | Actual: " + actualValue);

		    Assert.assertEquals(actualValue, enetrsearchvalue, "Saved value does not match expected!");

		    LoggerUtil.info("Step 7: Deleting the saved currency entry.");
		    clickOnElement(deletebtn);
		    driver.switchTo().alert().accept();

		    LoggerUtil.info("Step 8: Verifying deletion confirmation toast.");
		    String actualMsg = waitForExpectedElement(toastmsgforspecific).getText().trim();
		    String expectedMsg = "Currency details Successfully deleted";

		    LoggerUtil.info("Expected Toast: " + expectedMsg);
		    LoggerUtil.info("Actual Toast:   " + actualMsg);

		    if (actualMsg.equals(expectedMsg)) {
		        LoggerUtil.pass("✅ Data has been deleted successfully.");
		    } else {
		        LoggerUtil.error("❌ Data was not deleted. Toast mismatch.");
		    }
		}

	 
	 public static final By secondtabtoast = By.xpath("//*[@id='toast-container']/div/div");
	 public static final By viewbtnsecondtab =By.xpath("//button[@id='viewbtn']");

	 public void missingpromptcheck() throws InterruptedException {
		    LoggerUtil.info("Step 1: Clicking on 'View' button in the second tab without selecting year.");
		    clickOnElement(viewbtnsecondtab);
		    Thread.sleep(2000);

		    LoggerUtil.info("Step 2: Fetching toast/prompt message.");
		    String actualPopupMsg = waitForExpectedElement(secondtabtoast).getText().trim();
		    String expectedPopupMsg = "Required Select Year.!";

		    LoggerUtil.info("Expected Prompt Message: '" + expectedPopupMsg + "'");
		    LoggerUtil.info("Actual Prompt Message:   '" + actualPopupMsg + "'");

		    if (actualPopupMsg.equals(expectedPopupMsg)) {
		        LoggerUtil.pass("✅ Prompt message displayed correctly: " + actualPopupMsg);
		    } else {
		        LoggerUtil.error("❌ Prompt message mismatch. Expected: '" + expectedPopupMsg + "', but found: '" + actualPopupMsg + "'");
		    }
		}

	 
	 
		public static final By Fiscalyearsecondtab = By.xpath("//select[@id='year']");
		public static final By listofyear = By.xpath("//select[@id='year']/option");
        public static final By fethingwholetable = By.xpath("//table[@id='tableV2']");
        public void loadingtable() throws InterruptedException {
            LoggerUtil.info("Step 1: Clicking on the 'Fiscal Year' second tab.");
            clickOnElement(Fiscalyearsecondtab);

            LoggerUtil.info("Step 2: Searching for year option '2026-2027' in the dropdown.");
            List<WebElement> optionsOfYear = driver.findElements(listofyear);
            boolean yearSelected = false;

            for (WebElement flagYear : optionsOfYear) {
                String flagValue = flagYear.getText().trim();
                if (flagValue.contains("2026-2027")) {
                    LoggerUtil.info("Year found and selected: " + flagValue);
                    flagYear.click();
                    yearSelected = true;
                    break;
                }
            }

            if (!yearSelected) {
                LoggerUtil.error("❌ Year '2026-2027' not found in the dropdown.");
                return;
            }

            LoggerUtil.info("Step 3: Clicking on 'View' button to load data table.");
            clickOnElement(viewbtnsecondtab);
            Thread.sleep(2000);

            LoggerUtil.info("Step 4: Checking if the data table is displayed after loading.");
            WebElement fetchForVerify = driver.findElement(fethingwholetable);

            if (fetchForVerify.isDisplayed()) {
                LoggerUtil.pass("✅ Table loaded successfully for year 2026-2027.");
            } else {
                LoggerUtil.error("❌ Table failed to load for year 2026-2027.");
            }
        }

		
		
	public static final By entervalueintable = By.xpath("//table[@id='tableV2']/tbody/tr[1]/td[2]/input[1]");	
	public static final By savebtnscondtab = By.xpath("//button[@id='tabcncySave']");
	
	public void verifynumericinputinsecondtabletab() throws InterruptedException {
	    LoggerUtil.info("Step 1: Navigating to 'Fiscal Year' second tab.");
	    clickOnElement(Fiscalyearsecondtab);

	    LoggerUtil.info("Step 2: Selecting fiscal year '2026-2027'.");
	    List<WebElement> optionsOfYear = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            LoggerUtil.info("Year selected: " + flagValue);
	            flagYear.click();
	            break;
	        }
	    }

	    LoggerUtil.info("Step 3: Clicking on 'View' to open the table.");
	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 4: Entering numeric value '54.999' into input cell.");
	    clearAndEnterText(waitForExpectedElement(entervalueintable), "54.999");
	    Thread.sleep(2000);

	    LoggerUtil.info("Step 5: Saving the entered value.");
	    clickOnElement(savebtnscondtab);
	    Thread.sleep(4000);

	    LoggerUtil.info("Step 6: Refreshing tab to re-verify saved value.");
	    clickOnElement(Fiscalyearsecondtab);
	    List<WebElement> optionsOfYear2 = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear2) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            flagYear.click();
	            break;
	        }
	    }

	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 7: Fetching value from cell after reload for verification.");
	    String actualValue = waitForExpectedElement(entervalueintable).getAttribute("value").trim();
	    String expectedValue = "54.999";

	    LoggerUtil.info("Expected Value: '" + expectedValue + "'");
	    LoggerUtil.info("Actual Value:   '" + actualValue + "'");

	    if (actualValue.equals(expectedValue)) {
	        LoggerUtil.pass("✅ Numeric value saved and verified successfully: " + expectedValue);
	    } else {
	        LoggerUtil.error("❌ Numeric value mismatch! Expected: '" + expectedValue + "', but got: '" + actualValue + "'");
	    }
	}

		
		
	public void verifyalphabetic() throws InterruptedException {
	    LoggerUtil.info("Step 1: Navigating to 'Fiscal Year' second tab.");
	    clickOnElement(Fiscalyearsecondtab);

	    LoggerUtil.info("Step 2: Selecting fiscal year '2026-2027'.");
	    List<WebElement> optionsOfYear = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            LoggerUtil.info("Year selected: " + flagValue);
	            flagYear.click();
	            break;
	        }
	    }

	    LoggerUtil.info("Step 3: Clicking 'View' to display the table.");
	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 4: Attempting to enter alphabetic value 'ABs' into numeric cell.");
	    clearAndEnterText(waitForExpectedElement(entervalueintable), "ABs");
	    Thread.sleep(2000);

	    LoggerUtil.info("Step 5: Saving the invalid alphabetic input.");
	    clickOnElement(savebtnscondtab);
	    Thread.sleep(4000);

	    LoggerUtil.info("Step 6: Reopening tab and fiscal year to verify saved value.");
	    clickOnElement(Fiscalyearsecondtab);
	    List<WebElement> optionsOfYear2 = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear2) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            flagYear.click();
	            break;
	        }
	    }

	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 7: Verifying the cell value after entering alphabetic input.");
	    String actualValue = waitForExpectedElement(entervalueintable).getAttribute("value").trim();
	    String expectedValue = "0.000";

	    LoggerUtil.info("Expected Value (defaulted due to invalid input): '" + expectedValue + "'");
	    LoggerUtil.info("Actual Value from UI: '" + actualValue + "'");

	    if (actualValue.equals(expectedValue)) {
	        LoggerUtil.pass("✅ Alphabetic input was not accepted. Field defaulted to: " + expectedValue);
	    } else {
	        LoggerUtil.error("❌ Alphabetic input was accepted! Actual value stored: " + actualValue);
	    }
	}

	public void verifynegativenumber() throws InterruptedException {
	    LoggerUtil.info("Step 1: Navigating to 'Fiscal Year' second tab.");
	    clickOnElement(Fiscalyearsecondtab);

	    LoggerUtil.info("Step 2: Selecting fiscal year '2026-2027'.");
	    List<WebElement> optionsOfYear = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            LoggerUtil.info("Year selected: " + flagValue);
	            flagYear.click();
	            break;
	        }
	    }

	    LoggerUtil.info("Step 3: Clicking on 'View' to load the table.");
	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 4: Entering negative value '-9835' into input field.");
	    clearAndEnterText(waitForExpectedElement(entervalueintable), "-9835");
	    Thread.sleep(2000);

	    LoggerUtil.info("Step 5: Saving the value.");
	    clickOnElement(savebtnscondtab);
	    Thread.sleep(4000);

	    LoggerUtil.info("Step 6: Re-selecting the same year and verifying saved value.");
	    clickOnElement(Fiscalyearsecondtab);
	    List<WebElement> optionsOfYear2 = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear2) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            flagYear.click();
	            break;
	        }
	    }

	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 7: Reading value from table after save.");
	    String actualValue = waitForExpectedElement(entervalueintable).getAttribute("value").trim();
	    String expectedValue = "9835"; // Assuming negative sign gets stripped

	    LoggerUtil.info("Expected Value (absolute): '" + expectedValue + "'");
	    LoggerUtil.info("Actual Value from UI:       '" + actualValue + "'");

	    try {
	        double actual = Double.parseDouble(actualValue);
	        double expected = Double.parseDouble(expectedValue);

	        if (actual == expected) {
	            LoggerUtil.pass("✅ Negative value was not accepted. Value saved as positive: " + expected);
	        } else {
	            LoggerUtil.error("❌ Negative value seems to have been saved directly: " + actual);
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("❌ Exception occurred during numeric comparison: " + e.getMessage());
	    }
	}

		
		
	public void ThreeDecimalupto() throws InterruptedException {
	    LoggerUtil.info("Step 1: Navigating to 'Fiscal Year' second tab.");
	    clickOnElement(Fiscalyearsecondtab);

	    LoggerUtil.info("Step 2: Selecting fiscal year '2026-2027'.");
	    List<WebElement> optionsOfYear = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            LoggerUtil.info("Year selected: " + flagValue);
	            flagYear.click();
	            break;
	        }
	    }

	    LoggerUtil.info("Step 3: Clicking on 'View' to open the data entry table.");
	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 4: Entering value with more than 3 decimal places: 9835.46858386");
	    clearAndEnterText(waitForExpectedElement(entervalueintable), "9835.46858386");
	    Thread.sleep(2000);

	    LoggerUtil.info("Step 5: Saving the value.");
	    clickOnElement(savebtnscondtab);
	    Thread.sleep(4000);

	    LoggerUtil.info("Step 6: Reloading fiscal year '2026-2027' to verify the saved value.");
	    clickOnElement(Fiscalyearsecondtab);
	    List<WebElement> optionsOfYear2 = driver.findElements(listofyear);
	    for (WebElement flagYear : optionsOfYear2) {
	        String flagValue = flagYear.getText().trim();
	        if (flagValue.contains("2026-2027")) {
	            flagYear.click();
	            break;
	        }
	    }

	    clickOnElement(viewbtnsecondtab);

	    LoggerUtil.info("Step 7: Fetching saved value from table for validation.");
	    String actualValue = waitForExpectedElement(entervalueintable).getAttribute("value").trim();
	    String expectedValue = "9835.468";

	    LoggerUtil.info("Expected Rounded Value (3 decimals): " + expectedValue);
	    LoggerUtil.info("Actual UI Value: " + actualValue);

	    try {
	        BigDecimal actual = new BigDecimal(actualValue).setScale(3, RoundingMode.HALF_UP);
	        BigDecimal expected = new BigDecimal(expectedValue).setScale(3, RoundingMode.HALF_UP);

	        if (actual.compareTo(expected) == 0) {
	            LoggerUtil.pass("✅ The value has been correctly rounded and saved: " + actual);
	        } else {
	            LoggerUtil.error("❌ Incorrect rounding. Actual: " + actual + ", Expected: " + expected);
	        }
	    } catch (NumberFormatException e) {
	        LoggerUtil.error("❌ Parsing error occurred. Actual: " + actualValue + ", Expected: " + expectedValue);
	    }
	}

		
		public static final By resetbtnsecondtab = By.xpath("//button[@id='resetyear']");
		public static final By tablesecondtab = By.xpath("//table[@id='tableV2']");
	
		public void verifyResetButtonFunctionality() throws InterruptedException {
		    LoggerUtil.info("Step 1: Navigating to 'Fiscal Year' second tab.");
		    clickOnElement(Fiscalyearsecondtab);

		    LoggerUtil.info("Step 2: Selecting fiscal year '2026-2027'.");
		    List<WebElement> optionsOfYear = driver.findElements(listofyear);
		    for (WebElement flagYear : optionsOfYear) {
		        String flagValue = flagYear.getText().trim();
		        if (flagValue.contains("2026-2027")) {
		            LoggerUtil.info("Year selected: " + flagValue);
		            flagYear.click();
		            break;
		        }
		    }

		    LoggerUtil.info("Step 3: Clicking on 'View' button to load the table.");
		    clickOnElement(viewbtnsecondtab);
		    Thread.sleep(3000); // Prefer replacing with proper wait

		    LoggerUtil.info("Step 4: Clicking on 'Reset' button.");
		    clickOnElement(resetbtnsecondtab);
		    Thread.sleep(2000);

		    LoggerUtil.info("Step 5: Verifying if the table has been removed/reset.");

		    try {
		        WebElement tableData = driver.findElement(tablesecondtab);

		        if (!tableData.isDisplayed()) {
		            LoggerUtil.info("Reset button successfully cleared the table.");
		            LoggerUtil.pass("✅ Table has been removed from the page after reset.");
		        } else {
		            LoggerUtil.error("❌ Table is still visible. Reset functionality failed.");
		        }
		    } catch (Exception e) {
		        LoggerUtil.pass("✅ Table element not found after reset, indicating successful reset.");
		        LoggerUtil.info("Table was removed completely from the DOM: " + e.getMessage());
		    }
		}

		
		
		
		public void verifySaveButtonIsVisible() {
		    LoggerUtil.info("Step 1: Clicking on 'Fiscal Year' second tab.");
		    clickOnElement(Fiscalyearsecondtab);

		    LoggerUtil.info("Step 2: Selecting year '2026-2027' from dropdown.");
		    List<WebElement> optionsOfYear = driver.findElements(listofyear);
		    for (WebElement flagYear : optionsOfYear) {
		        String flagValue = flagYear.getText().trim();
		        if (flagValue.contains("2026-2027")) {
		            LoggerUtil.info("Year selected: " + flagValue);
		            flagYear.click();
		            break;
		        }
		    }

		    LoggerUtil.info("Step 3: Checking if 'Save' button is visible after valid year selection.");
		    WebElement saveButtonFirstState = driver.findElement(savebtnscondtab);

		    if (saveButtonFirstState.isDisplayed()) {
		        LoggerUtil.pass("✅ Save button is visible after selecting valid year.");
		    } else {
		        LoggerUtil.fail("❌ Save button is NOT visible after selecting valid year.");
		    }

		    LoggerUtil.info("Step 4: Clicking on 'Fiscal Year' tab again to recheck with 'Select' value.");
		    clickOnElement(Fiscalyearsecondtab);

		    LoggerUtil.info("Step 5: Selecting 'Select' placeholder from year dropdown.");
		    for (WebElement flagYear : optionsOfYear) {
		        String flagValue = flagYear.getText().trim();
		        if (flagValue.equalsIgnoreCase("Select")) {
		            LoggerUtil.info("Selected option: " + flagValue);
		            flagYear.click();
		            break;
		        }
		    }

		    LoggerUtil.info("Step 6: Verifying Save button visibility when no year is selected.");
		    WebElement saveButtonSecondState = driver.findElement(savebtnscondtab);

		    if (saveButtonSecondState.isDisplayed()) {
		        LoggerUtil.pass("✅ Save button is still visible even when 'Select' year is chosen.");
		    } else {
		        LoggerUtil.fail("❌ Save button is not visible after changing to 'Select'. Expected visibility failed.");
		    }
		}

		
		public static final By clickingimportbtn = By.xpath("//input[@id='AttachmentFile']");
		public static final By clickingExportButton = By.xpath("//button[@id='tab1Export']");	
		public void ExportDataEnterValue() throws InterruptedException {
			
			clickOnElement(Fiscalyearsecondtab);
			List<WebElement> optionsofyear = driver.findElements(listofyear);
			
			for(WebElement flagyear:optionsofyear) {
				
	               String flagvalue = flagyear.getText().trim();			
				if(flagvalue.contains("2025-2026")) {
					
					flagyear.click();
					break;
				}
			}
			Thread.sleep(3000);
			clickOnElement(clickingExportButton);
			Thread.sleep(8000);
			
			EneterValueCurrencyAddition();
			File latestFile = Base.getLatestExportedExcelFileForCurrencyDataAddition();  
			uploadAttachmentFile(latestFile);
			
		}
		
		public void EneterValueCurrencyAddition() {
		    File latestFile = getLatestExportedExcelFileForCurrencyDataAddition();
		    if (latestFile == null) {
		        System.err.println("❌ Latest Currency Excel file not found.");
		        return;
		    }

		    String filePath = latestFile.getAbsolutePath();
		    int sheetIndex = 0;       // First sheet
		    int columnIndex = 8;      // Column 'I'
		    int startRow = 2;         // Excel Row 3
		    int endRow = 14;          // Excel Row 15

		    for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
		        String value = "10.84" + (rowIndex + 1); // Or use actual currency names
		        ExcelFiller.writeExactCellValue(filePath, sheetIndex, rowIndex, columnIndex, value);
		    }

		    System.out.println("✅ Currency values written in Column I from row 3 to 15 of: " + latestFile.getName());
		}

		
		
		
		public static final By attachmentFileInput = By.xpath("//input[@id='AttachmentFile']");

		public void uploadAttachmentFile(File fileToUpload) {
		    try {
		        WebElement fileInput = driver.findElement(attachmentFileInput);

		        // Ensure file input is visible (in case it's hidden)
		        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		        // Upload the file
		        fileInput.sendKeys(fileToUpload.getAbsolutePath());

		        // Optional: Wait for the file name to appear in UI (adjust as per your DOM)
		        new WebDriverWait(driver, Duration.ofSeconds(10))
		                .until(ExpectedConditions.attributeToBeNotEmpty(fileInput, "value"));

		        LoggerUtil.pass("✅ Attachment file uploaded successfully: " + fileToUpload.getName());
		    } catch (Exception e) {
		        LoggerUtil.mismatch("❌ Failed to upload attachment: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

	
		
		By fetchinguidata = By.xpath("//table[@id='tableV2']/tbody/tr/td[8]/input");

		public void verifyuiandexceldata() throws InterruptedException {
		    Thread.sleep(6000);
		    clickOnElement(Fiscalyearsecondtab);
		    List<WebElement> optionsofyear = driver.findElements(listofyear);

		    for (WebElement flagyear : optionsofyear) {
		        String flagvalue = flagyear.getText().trim();
		        if (flagvalue.contains("2025-2026")) {
		            flagyear.click();
		            break;
		        }
		    }

		    clickOnElement(viewbtnsecondtab);
		    Thread.sleep(3000);

		    List<WebElement> fetchui = driver.findElements(fetchinguidata);
		    File latestFile = getLatestExportedExcelFileForCurrencyDataAddition();
		    if (latestFile == null) {
		        LoggerUtil.mismatch("❌ Excel file not found for verification.");
		        return;
		    }

		    String filePath = latestFile.getAbsolutePath();
		    int sheetIndex = 0;
		    int columnIndex = 8; // Column 'I'
		    int startRow = 2;    // Excel Row 3 (0-based index)

		    try (FileInputStream fis = new FileInputStream(filePath);
		         Workbook workbook = new XSSFWorkbook(fis)) {

		        Sheet sheet = workbook.getSheetAt(sheetIndex);

		        for (int i = 0; i < fetchui.size(); i++) {
		            WebElement tabdata = fetchui.get(i);
		            String uiVal = tabdata.getAttribute("value");

		            Row excelRow = sheet.getRow(startRow + i);
		            if (excelRow == null) continue;

		            Cell excelCell = excelRow.getCell(columnIndex);
		            String excelVal = (excelCell != null) ? excelCell.toString().trim() : "";

		            if (uiVal == null || uiVal.trim().isEmpty()) {
		                LoggerUtil.mismatch("⚠️ Null or empty value encountered in UI input field.");
		            } else {
		                uiVal = uiVal.trim();
		                try {
		                    double uiRounded = Math.round(Double.parseDouble(uiVal) * 1000.0) / 1000.0;
		                    double excelRounded = Math.round(Double.parseDouble(excelVal) * 1000.0) / 1000.0;

		                    if (Double.compare(uiRounded, excelRounded) == 0) {
		                        LoggerUtil.pass("✅ Row " + (i + 3) + ": UI matches Excel → " + uiRounded);
		                    } else {
		                        LoggerUtil.mismatch("❌ Mismatch at row " + (i + 3) + ": UI = " + uiRounded + ", Excel = " + excelRounded);
		                    }
		                } catch (Exception e) {
		                    LoggerUtil.mismatch("❌ Parsing error at row " + (i + 3) + ": UI = " + uiVal + ", Excel = " + excelVal);
		                }
		            }
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		        LoggerUtil.mismatch("❌ Error during Excel comparison: " + e.getMessage());
		    }
		}
		
		
		
		
		
		public void verifyexportdataandvalidatewithui() throws InterruptedException {
		    clickOnElement(Fiscalyearsecondtab);
		    List<WebElement> optionsofyear = driver.findElements(listofyear);

		    for (WebElement flagyear : optionsofyear) {
		        String flagvalue = flagyear.getText().trim();
		        if (flagvalue.contains("2025-2026")) {
		            flagyear.click();
		            break;
		        }
		    }

		    Thread.sleep(3000);
		    clickOnElement(clickingExportButton);
		    Thread.sleep(8000);

		    File latestFile = getLatestExportedExcelFileForCurrencyDataAddition();
		    if (latestFile == null) {
		        LoggerUtil.mismatch("❌ Currency Excel file not found.");
		        return;
		    }

		    List<String> excelMonthList = readMonthColumnFromExcel(latestFile);
		    List<String> uiMonthList = readMonthColumnFromUi();

		    for (int i = 0; i < excelMonthList.size(); i++) {
		        String excelVal = excelMonthList.get(i).trim();
		        String uiVal = (i < uiMonthList.size()) ? uiMonthList.get(i).trim() : "";

		        if (excelVal.equalsIgnoreCase(uiVal)) {
		            LoggerUtil.pass("✅ Row " + (i + 3) + ": Excel matches UI → " + uiVal);
		        } else {
		            LoggerUtil.mismatch("❌ Row " + (i + 3) + ": Excel = '" + excelVal + "', UI = '" + uiVal + "'");
		        }
		    }
		}

		public static final By monthcolomUI = By.xpath("//table[@id='tableV2']//tr/td[1]") ;// pseudo-XPath to locate exact node

	 
		public List<String> readMonthColumnFromUi() throws InterruptedException {
		    clickOnElement(Fiscalyearsecondtab);

		    List<WebElement> optionsofyear = driver.findElements(listofyear);
		    for (WebElement flagyear : optionsofyear) {
		        String flagvalue = flagyear.getText().trim();
		        if (flagvalue.contains("2025-2026")) {
		            flagyear.click();
		            break;
		        }
		    }

		    Thread.sleep(4000);
		    clickOnElement(viewbtnsecondtab);
		    Thread.sleep(3000);

		    List<String> uiMonthList = new ArrayList<>();
		    List<WebElement> monthUilist = driver.findElements(monthcolomUI);

		    for (int i = 0; i < monthUilist.size(); i++) {
		        WebElement tdElement = monthUilist.get(i);

		        // ✅ Use text, not attribute
		        String value = tdElement.getText();
		        value = (value != null) ? value.trim() : "";

		        if (!value.isEmpty()) {
		            LoggerUtil.info("UI Row " + (i + 3) + " → Month: " + value);
		        } else {
		            LoggerUtil.mismatch("⚠️ Row " + (i + 3) + " → UI month value is empty/null.");
		        }

		        uiMonthList.add(value);
		    }

		    return uiMonthList;
		}


		public List<String> readMonthColumnFromExcel(File file) {
		    List<String> excelMonths = new ArrayList<>();
		    try (FileInputStream fis = new FileInputStream(file);
		         Workbook workbook = new XSSFWorkbook(fis)) {

		        Sheet sheet = workbook.getSheetAt(0); // First sheet
		        int startRow = 2; // Row 3
		        int endRow = 13;  // Row 14

		        for (int i = startRow; i <= endRow; i++) {
		            Row row = sheet.getRow(i);
		            if (row != null) {
		                Cell cell = row.getCell(1); // Column B = index 1
		                String value = (cell != null) ? cell.toString().trim() : "";
		                LoggerUtil.info("Excel Row " + (i + 1) + " → Month: " + value);
		                excelMonths.add(value);
		            }
		        }
		    } catch (Exception e) {
		        LoggerUtil.mismatch("❌ Failed to read Excel file: " + e.getMessage());
		    }
		    return excelMonths;
		}

		
		
		public void verifyDataHasBeenSavedAndVerifyExcelHeader(String value) throws InterruptedException {
			
			clickOnElement(converttocurrency);

			WebElement search = driver.findElement(searchinputconverttocurrency);
			search.sendKeys("Afghanistan-Afghanis");
			search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			clickOnElement(datasource);
			
			List<WebElement> datasourcelist = driver.findElements(By.xpath("//*[@id='Idd']/option"));
			
			
			selectBootStrapDropDown(datasourcelist, value);
			
			Thread.sleep(2000);
			
			
			clickOnElement(savebtn);
			
			
			
			
			
			
			
		}
		
		
		public void verifyexportdataandvalidatewithuiAndCompareColomDataWithHeaderName(String value) throws InterruptedException, IOException {
		    clickOnElement(Fiscalyearsecondtab);
		    List<WebElement> optionsofyear = driver.findElements(listofyear);

		    for (WebElement flagyear : optionsofyear) {
		        String flagvalue = flagyear.getText().trim();
		        if (flagvalue.contains("2025-2026")) {
		            flagyear.click();
		            break;
		        }
		    }

		    Thread.sleep(3000);
		    clickOnElement(clickingExportButton);
		   Thread.sleep(7000);
		    getLatestExportedExcelFileForCurrencyDataAddition();
		
		// Step: Read Excel and validate header
		File file = getLatestExportedExcelFileForCurrencyDataAddition();
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1); // Row 2 in Excel (0-indexed)

		String expectedHeader = "Afghanistan-Afghanis-"+value; // This must match UI selection

		boolean isHeaderFound = false;

		// Start from Column B (index 1)
		for (int colIndex = 1; colIndex <= row.getLastCellNum(); colIndex++) {
		    Cell cell = row.getCell(colIndex);
		    if (cell != null) {
		        String cellValue = cell.getStringCellValue().trim();
		        if (cellValue.equals(expectedHeader)) {
		            System.out.println("✅ Header matched: " + cellValue + " at column index: " + colIndex);
		            isHeaderFound = true;
		            break;
		        }
		    }
		}

		workbook.close();
		fis.close();

		if (!isHeaderFound) {
		    throw new AssertionError("❌ Expected header '" + expectedHeader + "' not found in row 2 starting from column B.");
		}

		
		
		
		
		
		
		
		
		}
		
		
		public static final By deletebtndataAddition  = By.xpath("//*[@id='example1']/tbody/tr/td[5]/a/span/i");
		public void DeletedDataForMatching(String value) throws InterruptedException {
			
		clearAndEnterText(waitForExpectedElement(searchinput), "Afghanistan-Afghanis-"+value);	
		Thread.sleep(3000);
		clickOnElement(deletebtndataAddition);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
		
		}
		
		
		
		
		
		
                      	 
}
















