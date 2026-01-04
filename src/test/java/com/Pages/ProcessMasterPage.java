package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelFiller;
import com.helper.LoggerUtil;

public class ProcessMasterPage extends Base {

	Faker faker = new Faker();
	// Generate random string data
	String randomName = faker.name().firstName();

	public static String prName;
	public static String wfactor;
	public static String udropdown;
	public static String module1;
	public static String bserate;
	public static int CustomerAllocation;
	DashboardPage dashboard = new DashboardPage();

	public static final By EnterProcessNameValue = By.xpath("//input[@id='processName']");
	public static final By EnterProcessRate = By.xpath("//input[@id='Rate']");
	public static final By dateselection = By.xpath("//input[@id='date']");
	public static final By EnterEfficiencyrate = By.xpath("//input[@id='Efficiency']");
	public static final By ClickingCavitiesCheckbox = By.xpath("//input[@id='processcst']");
	public static final By ohpnotapplicablecheckbox = By.xpath("//input[@id='Prefix']");
	public static final By Mctonnage = By.xpath("//*[@id='Tonnage']");
	public static final By weightfactorDropdown = By.xpath("//select[@id='selectionWeight']");
	public static final By rmInputCheckboxAll = By.xpath("//input[@id='rmAll']");
	public static final By Rm_ExtrusionRubberCheckbox = By.xpath("//input[@name='rmListCheckbox']");
	public static final By SaveBtn = By.xpath("//button[@id='processSave']");
	public static final By ViewBtn = By.xpath("//button[@onclick='processList(1)']/i");
	public static final By ResetButton = By.xpath("//button[@id='processReset']");
	public static final By unitDropDown = By.xpath("//select[@id='uomDrop']");
	public static final By businessSegmentCheckbox = By.xpath("//select[@id='SupplierSegment']");
	public static final By SearchboxProcess = By.xpath("//input[@id='searchBoxProcess1']");
	public static final By searchboxprocesslistbtn = By.xpath("//button[@id='btnSearchProcess']");
	public static final By fetchingDataProcessNameTable = By.xpath("//table[@id='unitTable1']/tbody/tr/td[3]/span");
	public static final By toastMessage = By.xpath("//div[@class='toast-message']");
	public static final By customerselectioncheckbox = By.xpath("//*[@id='costomerList']/tr[1]/td/div/label/input");
	public static final By addcustomerbutton = By.xpath("//button[@onclick='addNewCustomerprocess()']");
	public static final By addnewcustomercode = By.xpath("//input[@id='CustomerCode']");
	public static final By addnewcustomername = By.xpath("//input[@id='CustomerName']");
	public static final By addnewcustomerbusinesssegment = By.xpath("//select[@id='cusBusinessSegments']");
	public static final By savenewcustomer = By.xpath("//button[@id='customerSave']");
	public static final By clickoneditbtn = By.xpath(
			"//a[@onclick=\"return editProcess(9141, 33, 'SAchindra Mani Tripathi', '12345.000', '15-03-2025', '0.000', '', 'onclick', '0', 'Foredit');\"]");
	public static final By clicksaveasnewbutton = By.xpath("//button[@id='processSaveAsNew']");
	public static final By newcustomersearchingbutton = By.xpath("//*[@id='example1_filter']/label/input");
	public static final By searchresultnewcustomername = By.xpath("//*[@id='example1']/tbody/tr/td[3]");
	public static final By backtotopbtn = By.xpath("//div[@id='back-to-top']");
//	public static final By clcikexportbutton = By.xpath("//button[@data-target=\" #iddpopupexp\"]");
	// public static final By exportbutton =
	// By.xpath("//button[@id=\"exportButton\"]");
	// public static final By exportnewdatapopupbutton =
	// By.xpath("//input[@id=\"flexRadioDefault2\"]");
	public static final By exportnewdatasuppclickfordropdown = By.xpath("//select[@id='suppdropdown']");
	public static final By exportnewdataselectdropdownsupplier = By.xpath("//*[@id='suppdropdown']/option[1]");
	public static final By exportnewdataselectiondropdowncustomer = By
			.xpath("//input[@id='multiselect_nawy3wv6go_0_1']");
	public static final By tableData = By.xpath("//input[@value='12661']");
	public static final By clickupdatebutton = By.xpath("//button[@id='processSave']");
	public static final By exportnew = By.xpath("//button[@id='exportnewButton']");
	public static final By ExportButton = By.xpath("//button[@onClick='popupforexport()']");
	public static final By customerselectallcheckbox = By.xpath("//*[@id='custAll']");
	public static final By supplierselectallcheckbox = By.xpath("//*[@id='supAll']");
	public static final By deltabox = By.xpath(
			"//tbody[@id='DeltaTableBodyCustomer']//input[contains(@class, 'deltaRMAprCustomer') and string-length(@value) > 0]");
	public static final By customerspecifideltabox = By.xpath("//*[@id='rmDiv']/div[1]/div/div/span");
	public static final By selectallcustomerspecificdeltabox = By.xpath("//input[@id='multiselect_nt4a1bpdczi_0_0']");
	public static final By customerselectcheckboxsecondrow = By
			.xpath("//*[@id='costomerList']/tr[2]/td/div/label/input");
	public static final By landedpricebox = By.xpath(
			"//input[@class='form-control deltaRMAprCustomer' and @value!='']/ancestor::td/following-sibling::td[@class='finalDelta']/input");
	public static final By customerrowxpath = By
			.xpath("//tbody[@id='DeltaTableBodyCustomer']//tr[td/input[@value='{customer_name}']]");
	public static final By DeltaInputField = By.xpath(

			"//table[@id='comodityRMDeltaTableCustomer']/tbody/tr/td/input[@class='form-control deltaRMAprCustomer']");

	public static final By customerSearchBox = By.xpath("//input[@id='myInputCustomer']");

	public static final By customerCheckBox = By.xpath("//*[@id='costomerList']/tr[1]/td/div/label/input");

	public static final By customerSpecificDeltaDropDown = By

			.xpath("//select[@id='CustomerSpecificDelta']/following-sibling::div/button");

	public static final By customerSpecificDeltaSelectAll = By.xpath(

			"//select[@id='CustomerSpecificDelta']/following-sibling::div/button/following-sibling::div/button[@title=' Select all']");

	public static final By landedPrice = By.xpath("//*[@id='DeltaTableBodyCustomer']/tr/td[3]/input[1]");
	public static final By uploadInput = By.id("\"excelupload\"");
	public static final By firstImportButton = By.xpath("//*[@id='partAttributeDiv']/div[4]/div/div/div/button[4]");
	public static final By checkboxforimportexsistingfile = By.xpath("//input[@id='flexRadioDefault11']");
	public static final By secondImportButton = By.id("Import");
	public static final By importButton = By.xpath("//button[@onclick='popupforimp()']");

	public static final By importRadiobtn = By.xpath("//input[@id='flexRadioDefault22']");

	public static final By importNewBtn = By
			.xpath("//button[@onclick='document.getElementById('fileUploadnewdata').click()']");
	public static final By supplierDropdown = By.xpath("//select[@id='suppdropdown']/following-sibling::div/button");

	public static final By supplieroptionExport = By
			.xpath("//div[@class='multiselect-container dropdown-menu show']/button[2]/span/input");
	public static final By clcikexportbutton = By.xpath("//button[@data-target=' #iddpopupexp']");

	public static final By exportbutton = By.xpath("//button[@id='exportButton']");
	public static final By exportduplicate = By.xpath("//button[@onclick='exportDetailnew();']");
	public static final By exportnewdatapopupbutton = By.xpath("//input[@id='flexRadioDefault2']");

	public static final By CustomerDropdowntBtnInExportPopUp = By
			.xpath("//select[@id='custdropdown']/following-sibling::div/button");
	public static final By customerDropdownselectionExportpopup = By
			.xpath("//div[@class='multiselect-container dropdown-menu show']/button[2]/span/input");
	public static final By DeleteBtnProcessMasterViewTable = By
			.xpath("//table[@id='unitTable1']//tbody/tr[1]/td[2]/a[2]");

	public void enterProcessDetailInformation(String processName, String processRate, String dateSelection,
			String efficiencyRate, String mcTonnage) {

		LoggerUtil.info("Starting to enter Process Detail information.");

		try {
			clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);
			LoggerUtil.pass("Entered process name: " + processName);

			clearAndEnterText(waitForExpectedElement(EnterProcessRate), processRate);
			LoggerUtil.pass("Entered process rate: " + processRate);

			selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
			LoggerUtil.pass("Selected Unit (index 17).");

			clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
			LoggerUtil.pass("Entered date selection: " + dateSelection);

			clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);
			LoggerUtil.pass("Entered efficiency rate: " + efficiencyRate);

			clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);
			LoggerUtil.pass("Entered MC tonnage: " + mcTonnage);

			LoggerUtil.info("All Process Detail fields entered successfully.");

		} catch (Exception e) {

			try {

			} catch (Exception ss) {
				LoggerUtil.error("Screenshot capture failed: " + ss.getMessage());
			}
			LoggerUtil.fail("Failed while entering Process Detail information.");

		}
	}

	public void enterProcessDetailInformationForVerifyingEfficiencyRatePopupMessage(String processName,
			String processRate, String dateSelection, String efficiencyRate, String message, String mcTonnage) {

		LoggerUtil.info("Starting process detail entry for efficiency rate popup verification.");

		try {
			clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);
			LoggerUtil.pass("Entered process name: " + processName);

			clearAndEnterText(waitForExpectedElement(EnterProcessRate), processRate);
			LoggerUtil.pass("Entered process rate: " + processRate);

			selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
			LoggerUtil.pass("Selected Unit dropdown (index 17).");

			clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
			LoggerUtil.pass("Entered date: " + dateSelection);

			clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);
			LoggerUtil.pass("Entered efficiency rate: " + efficiencyRate);

			String actualToast = waitForExpectedElement(toastMessage).getText();
			Assert.assertTrue(actualToast.contains(message),
					"Expected toast message not found. Actual: " + actualToast);
			LoggerUtil.pass("Verified toast message contains: " + message);

			clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);
			LoggerUtil.pass("Entered MC tonnage: " + mcTonnage);

			LoggerUtil.info("Completed process detail entry for efficiency rate popup verification.");

		} catch (Exception e) {
			LoggerUtil.fail("Failed during process detail entry for efficiency popup verification: " + e.getMessage());
			throw new RuntimeException("Error while verifying efficiency rate popup", e);
		}
	}

	public void enterSpecificApplicabilityCustomerInformation(String message) {
		LoggerUtil.info("Starting specific applicability customer information entry.");

		try {
			clickOnElement(ClickingCavitiesCheckbox);
			LoggerUtil.pass("Clicked on Cavities checkbox.");

			clickOnElement(ohpnotapplicablecheckbox);
			LoggerUtil.pass("Clicked on OHP Not Applicable checkbox.");

			selectDropDownValue(weightfactorDropdown, "1", "index");
			LoggerUtil.pass("Selected Weight Factor dropdown by index 1.");

			clickOnElement(rmInputCheckboxAll);
			LoggerUtil.pass("Clicked on RM Input Checkbox (All).");

			clickOnElement(customerselectioncheckbox);
			LoggerUtil.pass("Clicked on Customer Selection checkbox.");

			clickOnElement(saveprocessbtn);
			LoggerUtil.pass("Clicked on Save Process button.");

			String actualToast = waitForExpectedElement(toastMessage).getText();
			Assert.assertTrue(actualToast.contains(message),
					"Expected toast message not found. Actual: " + actualToast);
			LoggerUtil.pass("Verified toast message contains: " + message);

			LoggerUtil.info("Specific applicability customer information entry completed successfully.");

		} catch (Exception e) {
			LoggerUtil.fail("Failed during specific applicability customer info entry: " + e.getMessage());
			throw new RuntimeException("Error in enterSpecificApplicabilityCustomerInformation", e);
		}
	}

	public void enterSpecificApplicabilityCustomerInformationAgain(String message) {
		LoggerUtil.info("Starting specific applicability customer information entry.");

		try {
			clickOnElement(ClickingCavitiesCheckbox);
			LoggerUtil.pass("Clicked on Cavities checkbox.");

			clickOnElement(ohpnotapplicablecheckbox);
			LoggerUtil.pass("Clicked on OHP Not Applicable checkbox.");

			selectDropDownValue(weightfactorDropdown, "1", "index");
			LoggerUtil.pass("Selected Weight Factor dropdown by index 1.");

			clickOnElement(rmInputCheckboxAll);
			LoggerUtil.pass("Clicked on RM Input Checkbox (All).");

			clickOnElement(customerselectioncheckbox);
			LoggerUtil.pass("Clicked on Customer Selection checkbox.");

			clickOnElement(saveprocessbtn);
			LoggerUtil.pass("Clicked on Save Process button.");

			String actualToast = waitForExpectedElement(toastMessage).getText();
			Assert.assertTrue(actualToast.contains(message),
					"Expected toast message not found. Actual: " + actualToast);
			LoggerUtil.pass("Verified toast message contains: " + message);

			LoggerUtil.info("Specific applicability customer information entry completed successfully.");

		} catch (Exception e) {
			LoggerUtil.fail("Failed during specific applicability customer info entry: " + e.getMessage());
			throw new RuntimeException("Error in enterSpecificApplicabilityCustomerInformation", e);
		}
	}

	public void searchProcessName(String searchprocessname) throws InterruptedException {

		clickOnElement(ViewBtn);
		Thread.sleep(15000);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), searchprocessname);
		Thread.sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']/tbody/tr"));
		LoggerUtil.info("🟢 Total rows found: " + rows.size());

		boolean matchFound = false;

		for (WebElement row : rows) {
			String rowText = row.getText().trim();

			// ✅ Skip rows with empty text
			if (rowText.isEmpty()) {
				continue;
			}

			LoggerUtil.info("Row: " + rowText);

			if (rowText.contains(searchprocessname)) {
				LoggerUtil.pass(" Process Name found in table: " + searchprocessname);
				matchFound = true;
				Thread.sleep(3000);

				break;

			}
		}

		if (!matchFound) {
			LoggerUtil.fail("❌ Process Name not found in table after save — search failed or data not rendered.");
			Assert.fail("Process Name not found: " + searchprocessname);
		}

		DeleteProcessMasterData();

	}

	public void DeleteProcessMasterData() {
		LoggerUtil.info("🟢 Step 1: Locating delete icon for first visible process row");

		try {
			WebElement deleteIcon = driver.findElement(
					By.xpath("//table[@id='unitTable1']//tbody/tr[1]/td[2]//i[contains(@class,'fa-trash')]"));
			WebElement parentAnchor = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].parentNode;", deleteIcon);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentAnchor);
			Thread.sleep(500);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentAnchor);
			LoggerUtil.pass("✅ Step 2: Clicked on delete icon using JavaScript");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			LoggerUtil.pass("✅ Step 3: Confirmed alert popup for deletion");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Deletion failed — " + e.getMessage());
		}
	}
	

	public void verifyDateField(String expectedDate) {
		LoggerUtil.info("Verifying Date field value. Expected: " + expectedDate);

		try {
			String actualValue = waitForExpectedElement(dateselection).getDomAttribute("value");
			LoggerUtil.info("Actual Date field value: " + actualValue);

			Assert.assertEquals(actualValue, expectedDate,
					"Date field value mismatch. Expected: " + expectedDate + ", Actual: " + actualValue);

			LoggerUtil.pass("Date field verification passed. Value matched: " + expectedDate);

		} catch (AssertionError ae) {
			LoggerUtil.fail("Date field verification failed. Error: " + ae.getMessage());
			throw ae; // rethrow so TestNG marks test as failed
		} catch (Exception e) {
			LoggerUtil.fail("Exception occurred while verifying Date field: " + e.getMessage());
			throw new RuntimeException("Error in verifyDateField", e);
		}
	}

	public void enterProcessDetailsforreset(String name, String rate, String efficiency) {
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), name);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiency);
	}

	public void selectcheckboxesforreset() {
		clickOnElement(ClickingCavitiesCheckbox);
		clickOnElement(ohpnotapplicablecheckbox);
		selectDropDownValue(weightfactorDropdown, "1", "index");
		clickOnElement(rmInputCheckboxAll);
		// selectDropDownValue(businessSegmentCheckbox, "1", "index");
	}

	public void clickresetbutton() {
		LoggerUtil.info("🔄 Step: Clicking Reset Button to clear all form values.");

		clickOnElement(ResetButton);

		try {
			Thread.sleep(3000); // Wait for reset to reflect in UI
			LoggerUtil.pass("✅ Reset Button clicked and wait completed.");
		} catch (InterruptedException e) {
			LoggerUtil.fail("❌ InterruptedException while waiting after Reset Button click.");
			e.printStackTrace();
		}
	}

	public boolean arefieldscleard() {
		boolean isProcessNameCleared = waitForExpectedElement(EnterProcessNameValue).getAttribute("value").isEmpty();
		boolean isProcessRateCleared = waitForExpectedElement(EnterProcessRate).getAttribute("value").isEmpty();
		boolean isEfficiencyRateCleared = waitForExpectedElement(EnterEfficiencyrate).getAttribute("value").isEmpty();

		return isProcessNameCleared && isProcessRateCleared && isEfficiencyRateCleared;
	}

	public boolean arecheckboxiscleard() {

		LoggerUtil.info("🔎 Verifying all checkboxes and dropdowns are cleared/reset...");

		boolean isCavitiesUnchecked = !driver.findElement(ClickingCavitiesCheckbox).isSelected();
		LoggerUtil.info("Cavities Checkbox cleared: " + isCavitiesUnchecked);

		boolean isOHPUnchecked = !driver.findElement(ohpnotapplicablecheckbox).isSelected();
		LoggerUtil.info("OHP Not Applicable Checkbox cleared: " + isOHPUnchecked);

		boolean isRmUnchecked = !driver.findElement(rmInputCheckboxAll).isSelected();
		LoggerUtil.info("RM Input Checkbox cleared: " + isRmUnchecked);

		boolean isRmExtrusionUnchecked = !driver.findElement(Rm_ExtrusionRubberCheckbox).isSelected();
		LoggerUtil.info("RM Extrusion Rubber Checkbox cleared: " + isRmExtrusionUnchecked);

		// Validate Weight Factor dropdown is reset to index 0 (value = "0")
		Select weightFactorSelect = new Select(waitForExpectedElement(weightfactorDropdown));
		String weightFactorValue = weightFactorSelect.getFirstSelectedOption().getAttribute("value");
		boolean isWeightFactorReset = weightFactorValue.equals("0");
		LoggerUtil.info("Weight Factor dropdown reset to 0: " + isWeightFactorReset);

		boolean finalResult = isCavitiesUnchecked && isOHPUnchecked && isRmUnchecked && isRmExtrusionUnchecked
				&& isWeightFactorReset;

		if (finalResult) {
			LoggerUtil.pass("✅ All checkboxes are unchecked and dropdowns are reset.");
		} else {
			LoggerUtil.fail("❌ One or more checkboxes/dropdowns are not cleared as expected.");
		}

		return finalResult;
	}

	public void clickingAddCustomerButton(String newCustomerCode, String newCustomerName, String message) {
		LoggerUtil.info("Starting Add Customer operation with Code: " + newCustomerCode + ", Name: " + newCustomerName);

		try {
			clickOnElement(addcustomerbutton);
			LoggerUtil.pass("Clicked on Add Customer button.");

			clearAndEnterText(waitForExpectedElement(addnewcustomercode), newCustomerCode);
			LoggerUtil.pass("Entered new customer code: " + newCustomerCode);

			clearAndEnterText(waitForExpectedElement(addnewcustomername), newCustomerName);
			LoggerUtil.pass("Entered new customer name: " + newCustomerName);

			selectDropDownValue(addnewcustomerbusinesssegment, "1", "index");
			LoggerUtil.pass("Selected Business Segment from dropdown (index 1).");

			clickOnElement(savenewcustomer);
			LoggerUtil.pass("Clicked on Save New Customer button.");

			String actualToast = waitForExpectedElement(toastMessage).getText();
			Assert.assertTrue(actualToast.contains(message),
					"Expected toast message not found. Actual: " + actualToast);
			LoggerUtil.pass("Verified toast message contains: " + message);

			LoggerUtil.info("Add Customer operation completed successfully.");

		} catch (AssertionError ae) {
			LoggerUtil.fail("Toast message verification failed. Error: " + ae.getMessage());
			throw ae; // rethrow to mark test as failed
		} catch (Exception e) {
			LoggerUtil.fail("Exception occurred during Add Customer operation: " + e.getMessage());
			throw new RuntimeException("Error in clickingAddCustomerButton", e);
		}
	}

	public void checkingCustomerNameInCustomerMaster(String searchCustomerName) {
		LoggerUtil.info("Verifying customer name in Customer Master. Expected: " + searchCustomerName);

		try {
			// Enter search value
			clearAndEnterText(waitForExpectedElement(newcustomersearchingbutton), searchCustomerName);
			LoggerUtil.pass("Entered customer name in search: " + searchCustomerName);

			// Wait for search result instead of Thread.sleep
			String actualCustomerName = waitForExpectedElement(searchresultnewcustomername).getText();
			LoggerUtil.info("Found customer name: " + actualCustomerName);

			// Assert check
			Assert.assertEquals(actualCustomerName, searchCustomerName,
					"Customer name mismatch. Expected: " + searchCustomerName + ", Actual: " + actualCustomerName);

			LoggerUtil.pass("Customer name verification passed. Found: " + actualCustomerName);

		} catch (AssertionError ae) {
			LoggerUtil.fail("Customer name verification failed. Error: " + ae.getMessage());
			throw ae; // rethrow assertion error for TestNG
		} catch (Exception e) {
			LoggerUtil.fail("Exception while verifying customer name in Customer Master: " + e.getMessage());
			throw new RuntimeException("Error in checkingCustomerNameInCustomerMaster", e);
		}
	}

	public void verifyDuplicateDataSavedOrNot() {

	}

	public static final By editbtn3 = By.xpath("//*[@id=\"unitTable1\"]/tbody/tr[9]/td[2]/a[1]/i");

	public void checksamedataaresavedornot(String entersearchboxname, String processName, String message)
			throws InterruptedException {
		clickOnElement(ViewBtn);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), entersearchboxname);
		clickOnElement(searchboxprocesslistbtn);
		Thread.sleep(4000);
		String editbtn = "//tbody/tr[td[contains(., '" + entersearchboxname + "')]]/td[2]/a[1]";
		driver.findElement((editbtn3)).click();
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);
		clickOnElement(saveprocessbtn);
		Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));
	}

	public void SaveProcessDetailsForVerifyingSaveAsNew(String processName, String processRate, String dateSelection,
			String efficiencyRate, String mcTonnage,String message) {

		LoggerUtil.info("Starting to enter Process Detail information.");

		try {
			clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);
			LoggerUtil.pass("Entered process name: " + processName);

			clearAndEnterText(waitForExpectedElement(EnterProcessRate), processRate);
			LoggerUtil.pass("Entered process rate: " + processRate);

			selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
			LoggerUtil.pass("Selected Unit (index 17).");

			clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
			LoggerUtil.pass("Entered date selection: " + dateSelection);

			clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);
			LoggerUtil.pass("Entered efficiency rate: " + efficiencyRate);

			clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);
			LoggerUtil.pass("Entered MC tonnage: " + mcTonnage);

			clickOnElement(ClickingCavitiesCheckbox);
			LoggerUtil.pass("Clicked on Cavities checkbox.");

			clickOnElement(ohpnotapplicablecheckbox);
			LoggerUtil.pass("Clicked on OHP Not Applicable checkbox.");

			selectDropDownValue(weightfactorDropdown, "1", "index");
			LoggerUtil.pass("Selected Weight Factor dropdown by index 1.");

			clickOnElement(rmInputCheckboxAll);
			LoggerUtil.pass("Clicked on RM Input Checkbox (All).");

			clickOnElement(customerselectioncheckbox);
			LoggerUtil.pass("Clicked on Customer Selection checkbox.");

			clickOnElement(saveprocessbtn);
			LoggerUtil.pass("Clicked on Save Process button.");

			String actualToast = waitForExpectedElement(toastMessage).getText();
			Assert.assertTrue(actualToast.contains(message),
					"Expected toast message not found. Actual: " + actualToast);
			LoggerUtil.pass("Verified toast message contains: " + message);

			LoggerUtil.info("Specific applicability customer information entry completed successfully.");
			LoggerUtil.info("All Process Detail fields entered successfully.");

		} catch (Exception e) {

			try {

			} catch (Exception ss) {
				LoggerUtil.error("Screenshot capture failed: " + ss.getMessage());
			}
			LoggerUtil.fail("Failed while entering Process Detail information.");

		}
		
		
		

	}

	public void editProcessAndSaveAsNew(String searchProcessName, String newProcessName, String expectedToastText) {
	    LoggerUtil.info("Editing Process Master. Search: " + searchProcessName + " | New Name: " + newProcessName);

	    try {
	        // Open view list
	        clickOnElement(ViewBtn);
	        LoggerUtil.pass("Clicked View button.");

	        // Search existing process
	        clearAndEnterText(waitForExpectedElement(SearchboxProcess), searchProcessName);
	        LoggerUtil.pass("Entered process search text: " + searchProcessName);

	        // Perform edit action (assumes this opens edit form for given process)
	        EditProcessMasterData(searchProcessName);
	        LoggerUtil.pass("Opened Edit screen for process: " + searchProcessName);

	        // Wait for edit form field to be visible, then change name
	        clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), newProcessName);
	        LoggerUtil.pass("Updated Process Name to: " + newProcessName);

	        // Save as new (clone/save copy behavior)
	        clickOnElement(clicksaveasnewbutton);
	        LoggerUtil.pass("Clicked 'Save As New'.");

	        // Verify toast message
	        String actualToast = waitForExpectedElement(toastMessage).getText();
	        Assert.assertTrue(actualToast.contains(expectedToastText),
	            "Toast mismatch. Expected to contain: " + expectedToastText + ", Actual: " + actualToast);
	        LoggerUtil.pass("Verified toast contains expected text: " + expectedToastText);

	        LoggerUtil.info("Process edit & save-as-new completed successfully.");

	    } catch (AssertionError ae) {
	        LoggerUtil.fail("Toast verification failed: " + ae.getMessage());
	        throw ae;
	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during process edit & save-as-new: " + e.getMessage());
	       
	    }
	}
	
	
	public void searchProcessNameForSaveAsNew(String searchprocessname) throws InterruptedException {
         Thread.sleep(4000);
//		clickOnElement(ViewBtn);
		Thread.sleep(15000);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), searchprocessname);
		Thread.sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']/tbody/tr"));
		LoggerUtil.info("🟢 Total rows found: " + rows.size());

		boolean matchFound = false;

		for (WebElement row : rows) {
			String rowText = row.getText().trim();

			// ✅ Skip rows with empty text
			if (rowText.isEmpty()) {
				continue;
			}

			LoggerUtil.info("Row: " + rowText);

			if (rowText.contains(searchprocessname)) {
				LoggerUtil.pass(" Process Name found in table: " + searchprocessname);
				matchFound = true;
				Thread.sleep(3000);

				break;

			}
		}

		if (!matchFound) {
			LoggerUtil.fail("❌ Process Name not found in table after save — search failed or data not rendered.");
			Assert.fail("Process Name not found: " + searchprocessname);
		}

		DeleteProcessMasterData();

	}

	public void enterexceldatawithsupplier(String processName, String processRate, String dateSelection,

			String efficiencyRate, String mctonnage) {

		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);

		clearAndEnterText(waitForExpectedElement(EnterProcessRate), processRate);

		clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);

		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);

		clearAndEnterText(waitForExpectedElement(Mctonnage), mctonnage);
		// Required !

		// Rate required.!
	}

	public void enterexceldatawithdropdown(String weightFactor, String busniessSegment, String unit) {

		selectDropDownValue(weightfactorDropdown, weightFactor, "visibleText");

		selectDropDownValue(unitDropDown, unit, "visibleText");

		selectDropDownValue(businessSegmentCheckbox, busniessSegment, "visibleText");

		waitForExpectedElement(tableData);

	}

	public void entercheckboxbutton(String message) {

		clickOnElement(ClickingCavitiesCheckbox);
		clickOnElement(ohpnotapplicablecheckbox);
		clickOnElement(rmInputCheckboxAll);
		clickOnElement(customerselectioncheckbox);
		clickOnElement(SaveBtn);
		Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));

	}

	public void verifyWarningPopupForExportingFile(String message) {
	    LoggerUtil.info("🔹 Step 1: Clicking on Export button");
	    clickOnElement(clcikexportbutton);

	    LoggerUtil.info("🔹 Step 2: Clicking on Export New Data Popup button");
	    clickOnElement(exportnewdatapopupbutton);

	    LoggerUtil.info("🔹 Step 3: Clicking on Final Export button");
	    clickOnElement(exportbutton);

	    String toastText = waitForExpectedElement(toastMessage).getText();
	    LoggerUtil.info("🔹 Step 4: Verifying warning message: " + toastText);

	    try {
	        Assert.assertTrue(toastText.contains(message),
	                "Expected message: [" + message + "] but found: [" + toastText + "]");
	        LoggerUtil.info("✅ Warning message verified successfully: " + toastText);
	    } catch (AssertionError e) {
	        LoggerUtil.error("❌ Warning message verification failed. Expected: " + message + ", but found: " + toastText);
	        throw e;
	    }
	}

	public void verifypopwithooutcustomer(String message) {

		clickOnElement(clcikexportbutton);
		clickOnElement(exportnewdatapopupbutton);
		// clickOnElement(exportnewdatasuppclickfordropdown);
		selectDropDownValue(exportnewdatasuppclickfordropdown, "2", "index");
		clickOnElement(exportbutton);
		Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));

	}

	public void Savesameprocessforsamecustomershouldnotbesave(String processName, String porcessRate,
			String dateSelection, String efficiencyRate, String mctonnage, String message) {

		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), porcessRate);
		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
		clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);
		clearAndEnterText(waitForExpectedElement(Mctonnage), mctonnage);
		clickOnElement(ClickingCavitiesCheckbox);
		clickOnElement(ohpnotapplicablecheckbox);
		selectDropDownValue(weightfactorDropdown, "1", "index");
		clickOnElement(rmInputCheckboxAll);
		clickOnElement(customerselectioncheckbox);
		clickOnElement(SaveBtn);
		Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));
	}

	public static final By updateforclickingeditbtn = By.xpath(
			"//a[@onclick=\"return editProcess(9141, 33, 'sachindra mani', '12345.000', '22-03-2025', '0.000', '', 'onclick', '0', 'Foredit');\"]");

	public void verifafteryupdatedatingdataregettingupdateornot(String entersearchboxname, String processName,
			String message) throws InterruptedException {

		clickOnElement(ViewBtn);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), entersearchboxname);
		clickOnElement(searchboxprocesslistbtn);
		clickOnElement(updateforclickingeditbtn);
		Thread.sleep(11000);
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);
		clickOnElement(customerselectioncheckbox);
		clickOnElement(clickupdatebutton);
		Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));
		clickOnElement(ViewBtn);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), entersearchboxname);
		clickOnElement(searchboxprocesslistbtn);

	}
	public void exportFile() {


		clickOnElement(ExportButton);


		clickOnElement(exportnew);


	}

//	public List<String> fetchProcessList() {
//		clickOnElement(ViewBtn);
//		List<WebElement> processNameElements = driver.findElements(fetchingDataProcessNameTable);
//		List<String> uiData = new ArrayList<>();
//		for (WebElement ele : processNameElements) {
//
//			uiData.add(ele.getText().trim());
//
//		}
//
//		return uiData;
//	}
	public List<String> fetchProcessList() {
		
		clickOnElement(ViewBtn);
	    LoggerUtil.info("🔎 Fetching visible Process Names from Process Master table");
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']/tbody/tr"));
	    List<String> processNames = new ArrayList<>();

	    for (WebElement row : rows) {
	        String fullCellText = row.findElement(By.xpath("./td[3]")).getText().trim();
	        if (!fullCellText.isEmpty()) {
	            processNames.add(fullCellText);
	            LoggerUtil.info("✅ Row Process Name: " + fullCellText);
	        }
	    }

	    LoggerUtil.info("🔢 Total Process Names fetched: " + processNames.size());
	    return processNames;
	}


	public static List<String> readProcessNamesFromExcel(File file, int columnIndex, int startRow) throws IOException {

		List<String> processNames = new ArrayList<>();

		FileInputStream fis = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fis);


		Sheet sheet = workbook.getSheetAt(0); // Read first sheet

		int count = 0;

		for (Row row : sheet) {

			if (row.getRowNum() < startRow)

				continue; // Skip first 3 rows

			if (count >= 50)

				break;

			Cell cell = row.getCell(columnIndex); // Column index for "Process Name"


			if (cell != null) {


				processNames.add(cell.toString().trim());

				count++;
			}

		}
		workbook.close();

		fis.close();

		return processNames;
	}

	public static void deleteFile(File latestFile) {


		if (latestFile != null) {


			System.out.println("File found");

			Base.deleteFile(latestFile);

		} else {
			System.out.println("No Matching file found");

		}

	}
	
	public static final By saveasnewbtn = By.xpath("//button[@id='processSaveAsNew']");

	public static void differentcustomerwithsameprocessname(String entersearchboxname, String message)
			throws InterruptedException {
		LoggerUtil.info(" Step 1: Clicking 'View' button to open process list");
		clickOnElement(ViewBtn);

		LoggerUtil.info(" Step 2: Entering process name in search box: '" + entersearchboxname + "'");
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), entersearchboxname);

		String editbtnXpath = "//tbody/tr[td[contains(text(), '" + entersearchboxname + "')]]/td[2]/a[1]";
		LoggerUtil.info(" Step 4: Clicking Edit button using dynamic XPath: " + editbtnXpath);
		driver.findElement(By.xpath(editbtnXpath)).click();

		LoggerUtil.info(" Step 5: Waiting for customer section to load");
		Thread.sleep(19000);

		LoggerUtil.info(" Step 6: Clicking 'Save As New' button");
		clickOnElement(saveasnewbtn);

		String actualToast = waitForExpectedElement(toastMessage).getText().trim();
		LoggerUtil.info(" Step 7: Capturing toast message after Save As New: '" + actualToast + "'");

		if (actualToast.contains(message)) {
			LoggerUtil.pass(" Toast message matched: '" + message + "'");
		} else {
			LoggerUtil.fail(
					" Toast message mismatch — Expected to contain: '" + message + "' but got: '" + actualToast + "'");
		}

		Assert.assertTrue(actualToast.contains(message), " Assertion Failed: Expected toast message not found");
	}

	public static void savedatawithdifferentsupplier(String entersearchboxname, String message)
			throws InterruptedException {

		LoggerUtil.info(" Step 1: Clicking 'View' button to open the process list");
		clickOnElement(ViewBtn);

		LoggerUtil.info(" Step 2: Entering process name in search box: '" + entersearchboxname + "'");
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), entersearchboxname);

		String editbtnXpath = "//tbody/tr[td[contains(text(), '" + entersearchboxname + "')]]/td[2]/a[1]";
		LoggerUtil.info(" Step 4: Clicking Edit button using XPath: " + editbtnXpath);
		driver.findElement(By.xpath(editbtnXpath)).click();

		LoggerUtil.info(" Step 5: Waiting for supplier list to load");
		Thread.sleep(17000);

		// Uncomment below line if selecting all suppliers is required
		// LoggerUtil.info("🟢 Step 6: Selecting all suppliers");
		// clickOnElement(supplierselectallcheckbox);

		LoggerUtil.info(" Step 6: Clicking 'Save As New' button to save with different supplier");
		clickOnElement(saveasnewbtn);

		String actualToast = waitForExpectedElement(toastMessage).getText().trim();
		LoggerUtil.info(" Step 7: Captured toast message: '" + actualToast + "'");

		if (actualToast.contains(message)) {
			LoggerUtil.pass(" Toast matched expected message: '" + message + "'");
		} else {
			LoggerUtil
					.fail(" Toast mismatch — Expected to contain: '" + message + "' but found: '" + actualToast + "'");
		}

		Assert.assertTrue(actualToast.contains(message), "❌ Assertion Failed: Expected toast message not matched.");
	}

	public boolean areallcheckboxisclicked() {

		boolean isCavitiesUnchecked = !driver.findElement(ClickingCavitiesCheckbox).isSelected();
		boolean isOHPUnchecked = !driver.findElement(ohpnotapplicablecheckbox).isSelected();
		boolean isRmUnchecked = !driver.findElement(rmInputCheckboxAll).isSelected();
		boolean isRmExtrusionUnchecked = !driver.findElement(Rm_ExtrusionRubberCheckbox).isSelected();

		boolean isWeightFactorReset = waitForExpectedElement(weightfactorDropdown).getAttribute("value").equals("0");
		boolean isBusinessSegmentReset = waitForExpectedElement(businessSegmentCheckbox).getAttribute("value")
				.equals("0");

		return isCavitiesUnchecked && isOHPUnchecked && isRmUnchecked && isRmExtrusionUnchecked && isWeightFactorReset
				&& isBusinessSegmentReset;
	}

	public void clickingallcheckboxes() {

		LoggerUtil.info("🟢 Step 1: Clicking on 'Cavities' checkbox");
		clickOnElement(ClickingCavitiesCheckbox);
		LoggerUtil.pass("✅ Cavities checkbox clicked");

		LoggerUtil.info("🟢 Step 2: Clicking on 'OHP Not Applicable' checkbox");
		clickOnElement(ohpnotapplicablecheckbox);
		LoggerUtil.pass("✅ OHP Not Applicable checkbox clicked");

		LoggerUtil.info("🟢 Step 3: Selecting Weight Factor from dropdown (Index 1)");
		selectDropDownValue(weightfactorDropdown, "1", "index");
		LoggerUtil.pass("✅ Weight Factor dropdown selected with index 1");

		LoggerUtil.info("🟢 Step 4: Clicking on 'RM Input All' checkbox");
		clickOnElement(rmInputCheckboxAll);
		LoggerUtil.pass("✅ RM Input All checkbox clicked");

		LoggerUtil.info("🟢 Step 5: Clicking on 'Customer Selection' checkbox");
		clickOnElement(customerselectioncheckbox);
		LoggerUtil.pass("✅ Customer Selection checkbox clicked");
	}

	public void ValidateDeltaValue(String processRate, String deltaValue) throws InterruptedException {

		LoggerUtil.info("🟢 Step 1: Entering Process Rate: " + processRate);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), processRate);
		int processRateNumberValue = Integer.parseInt(processRate);
		LoggerUtil.pass("✅ Process Rate entered: " + processRateNumberValue);

		LoggerUtil.info("🟢 Step 2: Selecting Customer checkbox");
		clickOnElement(customerCheckBox);

		Thread.sleep(3000);
		LoggerUtil.info("🟢 Step 3: Expanding Customer Specific Delta dropdown");
		clickOnElement(customerSpecificDeltaDropDown);

		Thread.sleep(3000);
		LoggerUtil.info("🟢 Step 4: Selecting 'Select All' inside Delta dropdown");
		clickOnElement(customerSpecificDeltaSelectAll);

		LoggerUtil.info("🟢 Step 5: Entering Delta Value: " + deltaValue);
		clearAndEnterText(waitForExpectedElement(DeltaInputField), deltaValue);
		int deltaNumberValue = Integer.parseInt(deltaValue);
		LoggerUtil.pass("✅ Delta Value entered: " + deltaNumberValue);

		LoggerUtil.info("🟢 Step 6: Fetching calculated Landed Price from UI using JavaScript");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String landedValue = (String) js.executeScript(
				"return document.querySelector('#DeltaTableBodyCustomer > tr > td.finalDelta > input:nth-child(1)').value;");

		double d = Double.parseDouble(landedValue);
		int landedNumberValue = (int) d;
		LoggerUtil.info("🔎 Captured Landed Price: " + landedNumberValue);

		int expectedTotal = processRateNumberValue + deltaNumberValue;
		LoggerUtil.info("🧮 Expected Total (ProcessRate + Delta): " + expectedTotal);

		if (landedNumberValue == expectedTotal) {
			LoggerUtil.pass("✅ Landed Price matches expected total — " + landedNumberValue);
		} else {
			LoggerUtil.fail("❌ Landed Price mismatch — Expected: " + expectedTotal + ", Actual: " + landedNumberValue);
		}

		Assert.assertEquals(landedNumberValue, expectedTotal, "❌ Assertion Failed: Landed Price calculation mismatch.");
	}

/////////////	////////////	//Exporting Excel File 	With Customer And Supplier////////////

	public void exportNewDataWithSupplier(String message) throws InterruptedException {

		clickOnElement(clcikexportbutton);

		clickOnElement(exportnewdatapopupbutton);

		clickOnElement(supplierDropdown);

		Thread.sleep(4000);

		clickOnElement(supplieroptionExport);

		Thread.sleep(8000);

		clickOnElement(exportbutton);

		Thread.sleep(9000);

		Thread.sleep(6000);
		;
		clickOnElement(importButton);

		clickOnElement(importRadiobtn);

		fillProcessMasterSheet();

		importNewProcessMasterWithCustomerFromExcel();

	}

	public void exportnewfilewithcustomer() throws InterruptedException {

		clickOnElement(clcikexportbutton);

		clickOnElement(exportnewdatapopupbutton);

		Thread.sleep(3000);
		clickOnElement(CustomerDropdowntBtnInExportPopUp);
		clickOnElement(customerDropdownselectionExportpopup);
		Thread.sleep(20000);
		clickOnElement(exportbutton);
		Thread.sleep(15000);

		clickOnElement(importButton);

		clickOnElement(importRadiobtn);

		fillProcessMasterSheet();
		Thread.sleep(10000);
		importNewProcessMasterWithCustomerFromExcel();

	}

	public String fillProcessMasterSheet() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestFileProcessMasterForSupplier();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Values to write
		prName = faker.name().lastName();
		udropdown = "Hourly";
		wfactor = "Cast Wt";
		module1 = "Ferrous Casting";
		bserate = "50";
		CustomerAllocation = faker.number().numberBetween(10, 99);
		String CustomAllocation = String.valueOf(CustomerAllocation);
		// Fill Excel
		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.STRING, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(udropdown));
		ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(wfactor));
		ExcelFiller.setCellValue(filePath, 0, 9, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(module1));
		ExcelFiller.setCellValue(filePath, 0, 17, 1, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 18, 1, ExcelFiller.ValueType.INTEGER, null);
		System.out.println("Process Master data filled successfully in: " + filePath);
		return latestFile.getAbsolutePath();

	}

	public void importNewProcessMasterWithCustomerFromExcel() throws InterruptedException {

		String fullPath = fillProcessMasterSheet(); // ✅ already full absolute path

		WebElement fileInput = driver.findElement(By.id("fileUploadnewdata"));

		// Make it visible via JS
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath); // 🧾 for debug

		fileInput.sendKeys(fullPath); // ✅ correctly sending full path

		Thread.sleep(11000);

		clickOnElement(ViewBtn);
	}

	public void exportNewDataWithSupplierAndImportWithoutProcessName() throws InterruptedException {

		clickOnElement(clcikexportbutton);

		clickOnElement(exportnewdatapopupbutton);

		clickOnElement(supplierDropdown);

		Thread.sleep(4000);

		clickOnElement(supplieroptionExport);

		Thread.sleep(8000);

		clickOnElement(exportbutton);

		Thread.sleep(9000);
		fillProcessMasterSheetWithoutProcessName();
		clickOnElement(importButton);

		clickOnElement(importRadiobtn);
		Thread.sleep(4000);
		// Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));

	}

	public String fillProcessMasterSheetWithoutProcessName() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestFileProcessMasterForSupplier();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();

		udropdown = "Hourly";
		wfactor = "Cast Wt";
		module1 = "Ferrous Casting";
		bserate = "50";
		CustomerAllocation = faker.number().numberBetween(10, 99);
		// Leave Process Name EMPTY (column 2, row 1)
		// ✅ Correct (writes to Row 4 – where actual import data should be)

		ExcelFiller.setCellValue(filePath, 0, 3, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(udropdown));
		ExcelFiller.setCellValue(filePath, 0, 8, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(wfactor));
		ExcelFiller.setCellValue(filePath, 0, 9, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(module1));
		ExcelFiller.setCellValue(filePath, 0, 17, 3, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 18, 3, ExcelFiller.ValueType.INTEGER, null);
		System.out.println("Excel filled without Process Name: " + filePath);
		return filePath;
	}

	public void importNewProcessMasterWithsupplierFromExcelWithoutprocessName() throws InterruptedException {
		String fullPath = fillProcessMasterSheetWithoutProcessName();

		WebElement fileInput = driver.findElement(By.id("fileUploadnewdata"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
		fileInput.sendKeys(fullPath);

		Thread.sleep(11000); // Keep for buffer if necessary

		clickOnElement(ViewBtn);

		// ✅ Toast Message Handling
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));

		String actualMessage = toast.getText();
		String expectedMessage = "Please enter Process Name"; // <-- use your app's actual message

		System.out.println("Toast: " + actualMessage);
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected toast message not displayed!");
	}

	public void exportNewDataWithSupplierAndImportWithoutUnitDropdown() throws InterruptedException {

		clickOnElement(clcikexportbutton);

		clickOnElement(exportnewdatapopupbutton);

		clickOnElement(supplierDropdown);

		Thread.sleep(4000);

		clickOnElement(supplieroptionExport);

		Thread.sleep(8000);

		clickOnElement(exportbutton);

		Thread.sleep(9000);
		fillProcessMasterSheetWithoutProcessName();
		clickOnElement(importButton);

		clickOnElement(importRadiobtn);
		Thread.sleep(4000);
		// Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));

	}

	public String fillProcessMasterSheetWithoutUnitDropdown() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();

		// Values to write except Process Name (we're skipping it)
		prName = faker.name().lastName();
		String weightfactor = "Cast Wt";
		String module1 = "Ferrous Casting";
		String bserate = "50";
		CustomerAllocation = faker.number().numberBetween(10, 99);
		// Leave Process Name EMPTY (column 2, row 1)
		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.STRING, Arrays.asList(randomName));

		// Rest fields
		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.STRING, null);
		ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(weightfactor));
		ExcelFiller.setCellValue(filePath, 0, 9, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(module1));
		ExcelFiller.setCellValue(filePath, 0, 17, 1, ExcelFiller.ValueType.INTEGER, null);

		System.out.println("Excel filled without Process Name: " + filePath);
		return filePath;
	}

	public void importNewProcessMasterWithsupplierFromExcelWithoutUnitDropdown() throws InterruptedException {

		String fullPath = fillProcessMasterSheetWithoutProcessName(); // ✅ already full absolute path

		WebElement fileInput = driver.findElement(By.id("fileUploadnewdata"));

		// Make it visible via JS
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath); // 🧾 for debug

		fileInput.sendKeys(fullPath); // ✅ correctly sending full path

		System.out.println(waitForExpectedElement(toastMessage).getText());
		String actualpoup = waitForExpectedElement(toastMessage).getText();
		String expectedpopup = "Invalid Excel File.";
		Assert.assertEquals(actualpoup, expectedpopup, "Invalid File has been Imported");

		Thread.sleep(11000);

		clickOnElement(ViewBtn);
	}

	public void importNewProcessMasterWithCustomerFromExcel1(String fileName) throws InterruptedException {

		String fullPath = System.getProperty("user.dir") + "/downloads/" + fileName;

		WebElement fileInput = driver.findElement(By.id("fileUploadnewdata"));

		// Make it visible via JS

		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		// Send file path

		fileInput.sendKeys(fullPath);

	}

	public void importexcelfilewithsamesupplier(String fileName) throws InterruptedException {

		clickOnElement(importButton);

		Thread.sleep(6000);

		importNewProcessMasterWithCustomerFromExcel1(fileName);

	}

	By uomDropdown = By.xpath("//span[@id='select2-uomDrop-container']");
	By dropdownOptions = By.xpath("//ul[@id='select2-uomDrop-results']/li");

	public static final By weightfactordropdownplaceholder = By
			.xpath("//span[@id='select2-selectionWeight-container']");

	public void selectUnitValue(String value) {

		Base.clickOnElement(uomDropdown); // click to open the dropdown
		List<WebElement> options = driver.findElements(dropdownOptions);
		selectBootStrapDropDown(options, value);

	}

	public void verifyweightfactordrop() {
		String Actualplaceholdervalue = waitForExpectedElement(weightfactordropdownplaceholder).getAttribute("title");
		String Expectedplaceholdervalue = "Select";

		if (Actualplaceholdervalue.equals(Expectedplaceholdervalue)) {

			LoggerUtil.pass("WeightFactor Place Holder Value is Available There..");
		} else {
			LoggerUtil.fail("The Weight Factor Place Holder Value is = "
					+ waitForExpectedElement(weightfactordropdownplaceholder).getAttribute("title"));

		}

	}

	public static final By suplliersegmentPlaceholdervalue = By.xpath(
			"//select[@id='SupplierSegment']/following-sibling::div/button[@class='multiselect dropdown-toggle custom-select text-center']");

	public void verifySuppplaceholder() {

		String actualsuppPlaceholder = waitForExpectedElement(suplliersegmentPlaceholdervalue).getAttribute("title");
		String expectedsuppPlaceholder = "None selected";
		if (actualsuppPlaceholder.equals(expectedsuppPlaceholder)) {
			LoggerUtil.pass("Supplier Place-holder Value is Available There ..");
		} else {
			LoggerUtil.fail("Supplier place-holder is not Available = "
					+ waitForExpectedElement(suplliersegmentPlaceholdervalue).getAttribute("title"));
		}

	}

	public static final By supplierspecificdeltapalceholdervlaue = By
			.xpath("//select[@id='SupplierSpecificDelta']/following-sibling::div/button/span");

	public void verifySuppspecificdeltaplaceholderValue() {
		String actualValue = waitForExpectedElement(supplierspecificdeltapalceholdervlaue).getText().trim();
		String expectedValue = "None selected";

		System.out.println("Actual Placeholder: [" + actualValue + "]");

		if (actualValue.equalsIgnoreCase(expectedValue)) {
			LoggerUtil.pass("✅ Supplier specific delta placeholder value is correct: " + actualValue);
		} else {
			LoggerUtil.fail("❌ Supplier specific delta placeholder value mismatch. Expected: " + expectedValue
					+ ", but Found: " + actualValue);
		}
	}

	public void enterProcessRate(String rate) {
		WebElement rateField = waitForExpectedElement(EnterProcessRate);
		clearAndEnterText(rateField, rate); // Using your Base method
	}

	public String getProcessRateFieldValue() {
		return waitForExpectedElement(EnterProcessRate).getAttribute("value");
	}

	// Top-right cross button in purple Process List header
	private static final By topRightCloseBtn = By.xpath("//button[@onclick='hideView()']");
	private static final By processmasterheader = By.xpath("(//h3[@class='box-title '])[1]");

	// The actual process list grid or section
	private static final By processListSection = By.xpath("//h4[contains(text(),'Process List')]"); // Or any unique
																									// identifier for
																									// landing list

	public void clickTopRightCrossButton() {

		clickOnElement(ViewBtn);
		clickOnElement(topRightCloseBtn);
		if (waitForExpectedElement(processmasterheader).isDisplayed())
			;
		{

			System.out.println("hmara code chll hai hr hr mahadev");

		}
	}

	public boolean isProcessListSectionVisible() {
		try {
			return waitForExpectedElement(processListSection).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static final By nextbtn = By.xpath("//ul[@class='pagination']/li[11]/a");
	public static final By verifynextpage = By.xpath("(//table[@id='unitTable1']/tbody/tr/td)[1]");

	public void nextbtn() throws InterruptedException {
		clickOnElement(ViewBtn);
		Thread.sleep(3000);
		clickOnElement(nextbtn);
		String actualvalue = waitForExpectedElement(verifynextpage).getText();
		Assert.assertEquals(actualvalue, "51");
	}

	public void EditProcessMasterData(String targetProcessName) {
		LoggerUtil.info("🟢 Step 1: Searching for process row matching: " + targetProcessName);

		try {
			// Locate all rows in the process table
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']//tbody/tr"));

			boolean found = false;

			for (WebElement row : rows) {
				String rowText = row.getText();

				if (rowText.contains(targetProcessName)) {
					LoggerUtil.info("✅ Matching row found for process: " + targetProcessName);

					// Find the edit icon inside this row
					WebElement editIcon = row.findElement(By.xpath(".//td[2]//i[contains(@class,'fas fa-edit')]"));
					WebElement parentAnchor = (WebElement) ((JavascriptExecutor) driver)
							.executeScript("return arguments[0].parentNode;", editIcon);

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentAnchor);
					Thread.sleep(500);

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentAnchor);
					LoggerUtil.pass("✅ Edit icon clicked for process: " + targetProcessName);

					Thread.sleep(2000); // optional
					found = true;
					break;
				}
			}

			if (!found) {
				LoggerUtil.fail("❌ No matching row found for process: " + targetProcessName);
			}

		} catch (Exception e) {
			// LoggerUtil.logException(e);
			LoggerUtil.fail("❌ Edit action failed due to exception: " + e.getMessage());
		}
	}

	public static final By editbtn = By
			.xpath("//table[@id='unitTable1']//tbody/tr[1]/td[2]//i[contains(@class,'fas fa-edit')]");
	// public static final By deltavalue =
	// By.xpath("//table[@id=\"comodityRMDeltaTableCustomer\"]/tbody/tr/td[2]/input");
	public static final By updatebtn = By.xpath("//button[@id='processSave']");
	public static final By fetchValueprocessrate = By.xpath("//table[@id='unitTable1']/tbody/tr/td[4]");

	public void updateprocessRateWithcustomer(String prate, String searchname) throws InterruptedException {
		LoggerUtil.info("🟢 Step 1: Viewing existing process records");
		clickOnElement(ViewBtn);
		Thread.sleep(3000);

		LoggerUtil.info("🔍 Step 2: Searching for process name: " + searchname);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), searchname);

		try {
			LoggerUtil.info("✏️ Step 3: Clicking Edit on process: " + searchname);
			EditProcessMasterData(searchname);
		} catch (Exception e) {
			// LoggerUtil.logException(e);
			LoggerUtil.fail("❌ Failed to click Edit for process: " + searchname);
			throw e;
		}

		LoggerUtil.info("🔢 Step 4: Entering new Process Rate: " + prate);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), prate);

		LoggerUtil.info("💾 Step 5: Clicking Update Button to save changes");
		clickOnElement(updatebtn);
		Thread.sleep(15000);

		LoggerUtil.info("🔁 Step 6: Reopening view and re-searching for process to verify update");
		clickOnElement(ViewBtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), searchname);

		LoggerUtil.info("🧮 Step 7: Counting rows after search");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']/tbody/tr"));
		LoggerUtil.info("Total rows in table after search: " + rows.size());

		LoggerUtil.info("🔍 Step 8: Fetching updated Process Rate value");
		WebElement rateCell;
		String actualvalue;
		// First try the original locator (tr[2])
		rateCell = waitForExpectedElement(fetchValueprocessrate);
		actualvalue = rateCell.getText();

		String actualValueUpdate = actualvalue.replace(".000", "").trim();

		LoggerUtil.info("✅ Step 9: Comparing expected and actual values");
		LoggerUtil.info("Expected Process Rate: " + prate);
		LoggerUtil.info("Actual Process Rate: " + actualValueUpdate);

		if (actualValueUpdate.equals(prate)) {
			LoggerUtil.pass("✅ Process Rate updated successfully for: " + searchname);
		} else {
			LoggerUtil.fail("❌ Process Rate mismatch. Expected: " + prate + ", Found: " + actualValueUpdate);
		}

		Assert.assertEquals(actualValueUpdate, prate, "❌ Process Rate value mismatch after update.");
	}

	public static final By iButton = By.xpath("(//div[@class='box-body pt-2'])[1]/div[6]/button/i");
	public static final By popupverifyibutton = By
			.xpath("//h5[@id='exampleModalLabel' and @class='modal-title' and contains(text(),'Instructions')]");

	public void clickIButton() throws InterruptedException {
		LoggerUtil.info("🟢 Step 1: Clicking on 'i' (info) button");
		clickOnElement(iButton);
		Thread.sleep(3000);

		LoggerUtil.info("🔍 Step 2: Validating header text is 'Instructions'");

		String expectedValue = "Instructions";
		String actualValue = waitForExpectedElement(popupverifyibutton).getText().trim();

		LoggerUtil.info("Expected Value: " + expectedValue);
		LoggerUtil.info("Actual Value: " + actualValue);

		if (actualValue.equals(expectedValue)) {
			LoggerUtil.pass("✅ Instructions header matched successfully.");
		} else {
			LoggerUtil
					.fail("❌ Mismatch in Instructions header. Expected: " + expectedValue + ", Found: " + actualValue);
		}

		Assert.assertEquals(actualValue, expectedValue, "Mismatch in Instructions popup title.");
	}

	public void clickSaveButtonSecondTime(String processName, String processRate, String dateSelection,
			String efficiencyRate, String mcTonnage, String expectedMessage) throws InterruptedException {

		LoggerUtil.info("🟢 Step 1: Entering Process Name: " + processName);
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);

		LoggerUtil.info("🟢 Step 2: Entering Process Rate: " + processRate);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), processRate);

		LoggerUtil.info("🟢 Step 3: Selecting Unit from dropdown (Index 18)");
		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

		LoggerUtil.info("🟢 Step 4: Entering Effective From Date: " + dateSelection);
		clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);

		LoggerUtil.info("🟢 Step 5: Entering Efficiency Rate: " + efficiencyRate);
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);

		LoggerUtil.info("🟢 Step 6: Entering MC Tonnage: " + mcTonnage);
		clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);

		LoggerUtil.info(
				"🟢 Step 7: Clicking checkboxes - Cavities, OHP Not Applicable, RM Input All, Customer Selection");
		clickOnElement(ClickingCavitiesCheckbox);
		clickOnElement(ohpnotapplicablecheckbox);
		clickOnElement(rmInputCheckboxAll);
		clickOnElement(customerselectioncheckbox);

		LoggerUtil.info("🟢 Step 8: Selecting Weight Factor dropdown (Index 1)");
		selectDropDownValue(weightfactorDropdown, "1", "index");

		LoggerUtil.info("💾 Step 9: Clicking Save button first time");
		clickOnElement(SaveBtn);
		Thread.sleep(4000);

		LoggerUtil.info("💾 Step 10: Clicking Save button second time to trigger duplicate validation");
		clickOnElement(SaveBtn);

		LoggerUtil.info("🔍 Step 11: Validating toast message after second save");
		String actualToast = waitForExpectedElement(toastMessage).getText().trim();

		LoggerUtil.info("Expected Toast: " + expectedMessage);
		LoggerUtil.info("Actual Toast: " + actualToast);

		if (actualToast.contains(expectedMessage)) {
			LoggerUtil.pass("✅ Toast message matched successfully on second save.");
		} else {
			LoggerUtil.fail("❌ Toast mismatch. Expected: " + expectedMessage + ", Found: " + actualToast);
		}

		Assert.assertTrue(actualToast.contains(expectedMessage), "❌ Toast message validation failed.");
	}

	public static final By deletebtn = By.xpath("//table[@id='unitTable1']/tbody/tr[1]/td[2]/a[2]/i");

	public void clickDeleteButtonAndProcessListShouldNotDelete(String expectedMessage) throws InterruptedException {
		LoggerUtil.info("🟢 Step 1: Clicking on View Button to load existing process records");
		clickOnElement(ViewBtn);
		Thread.sleep(3000);

		LoggerUtil.info("🗑️ Step 2: Clicking on Delete icon");
		WebElement deleteIcon = driver
				.findElement(By.xpath("//table[@id='unitTable1']//tbody/tr[1]/td[2]//i[contains(@class,'fa-trash')]"));
		WebElement parentAnchor = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].parentNode;", deleteIcon);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentAnchor);
		Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentAnchor);
		LoggerUtil.pass("✅ Step 2: Clicked on delete icon using JavaScript");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		LoggerUtil.info("🔍 Step 4: Validating toast message after delete attempt");
		String actualToast = waitForExpectedElement(toastMessage).getText().trim();

		System.out.println(actualToast);

		LoggerUtil.info("Expected Toast Message: " + expectedMessage);
		LoggerUtil.info("Actual Toast Message: " + actualToast);

		if (actualToast.contains(expectedMessage)) {
			LoggerUtil.pass("✅ Toast message matched: " + actualToast);
		} else {
			LoggerUtil.fail("❌ Toast mismatch. Expected: " + expectedMessage + ", Found: " + actualToast);
		}

		Assert.assertTrue(actualToast.contains(expectedMessage),
				"❌ Toast message after delete did not match expected.");
	}

	public void verifyprocessmasterOpen(String prate) throws InterruptedException {

		dashboard.clickOnProcessItem();
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), prate);

	}

	public void enterspecialcharacterInEfficiencyrate(String prname, String prorate, String dateSelection,
			String efficiencyRate, String mctonnage, String message) {

		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), prname);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), prorate);
		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

		clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);
		clearAndEnterText(waitForExpectedElement(Mctonnage), mctonnage);

		clickOnElement(rmInputCheckboxAll);
		clickOnElement(customerselectioncheckbox);
		clickOnElement(SaveBtn);
		Assert.assertTrue(waitForExpectedElement(toastMessage).getText().contains(message));

	}

	public static final By BusinessSegBox = By
			.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/button");
	public static final By BusinessSegcheckboxfirst = By
			.xpath("//label[normalize-space()='141235']/preceding-sibling::input[@type='checkbox']");
	public static final By BusinessSegcheckboxsecond = By
			.xpath("//label[normalize-space()='Ai']/preceding-sibling::input[@type='checkbox']");
	public static final By BusinessSegcheckboxthird = By
			.xpath("//label[normalize-space()='Brant']/preceding-sibling::input[@type='checkbox']");
	public static final By allSupplierCheckboxes = By.xpath("//div[@id='supplierList']//input[@type='checkbox']");
	public static final By SupplierSpecificDeltaBox = By.xpath(
			"//select[@id='SupplierSpecificDelta']/following-sibling::div[contains(@class,'btn-group')]//button[contains(@class,'multiselect')]");
	public static final By ListDropdownOfSpecificDelta = By.xpath(
			"//div[contains(@class,'multiselect-container') and contains(@class,'show')]//button[contains(@class,'multiselect-option')]");
	public static final By selectallbox = By.xpath("//input[@id=\"supAll\"]");
	public static final By supplierSpecificdeltaoption = By.xpath("//select[@id='SupplierSpecificDelta']/option");

	public static final By supplieroption = By.xpath("//table[@id='rmSupplier']/tbody/tr/td/div/label/input");

	public void verifyNumberOfDeltaPopulationIsVerifiedToSupplierCheckbox() throws InterruptedException {
		LoggerUtil.info("🟢 Step 1: Clicking on Business Segment checkboxes");
		clickOnElement(BusinessSegBox);
		clickOnElement(BusinessSegcheckboxfirst);
		clickOnElement(BusinessSegcheckboxsecond);
		clickOnElement(BusinessSegcheckboxthird);

		Thread.sleep(6000); // Wait for supplier options to load

		LoggerUtil.info("🔍 Step 2: Fetching number of Supplier options");
		List<WebElement> supplierList = driver.findElements(supplieroption);
		int totalSuppliers = supplierList.size();
		LoggerUtil.info("Total Suppliers Found: " + totalSuppliers);

		Thread.sleep(3000);

		LoggerUtil.info("🟢 Step 3: Clicking on Supplier Specific Delta Box");
		clickOnElement(SupplierSpecificDeltaBox);

		LoggerUtil.info("🔍 Step 4: Fetching number of Supplier-Specific Delta options");
		List<WebElement> deltaList = driver.findElements(supplierSpecificdeltaoption);
		int totalDeltas = deltaList.size();
		LoggerUtil.info("Total Supplier-Specific Delta Options Found: " + totalDeltas);

		LoggerUtil.info("🔍 Step 5: Comparing Supplier count with Delta count");
		if (totalSuppliers == totalDeltas) {
			LoggerUtil.pass("✅ Supplier-Specific Delta population matched with total suppliers: " + totalSuppliers);
		} else {
			LoggerUtil.fail("❌ Mismatch: Expected Delta Count = " + totalSuppliers + ", but Found = " + totalDeltas);
		}

		Assert.assertEquals(totalDeltas, totalSuppliers, "Mismatch in Supplier vs Delta option counts.");
	}

	public static final By specificdeltaboxsupplier = By.xpath(
			"//select[@id='SupplierSpecificDelta']/following-sibling::div//button[contains(@class,'multiselect dropdown-toggle custom-select text-center')]");
	public static final By supplierdeltaselctcheckbox = By.xpath(
			"(//div[contains(@class,'multiselect-container') and contains(@class,'show')]//input[@type='checkbox'])[2]\r\n"
					+ "");
	public static final By saveprocessbtn = By.xpath("//button[@id='processSave']");
	public static final By enterdeltavalue = By.xpath("//input[@id='deltaRMApr']");
	public static final By rminputcategorycheckboxfirst = By.xpath("//div[@id='rmData']/div/label/input");

	public void clickSupplierSpecificDeltaDropdown() {
		LoggerUtil.info("🟢 Attempting to click Supplier Specific Delta dropdown");

		try {
			WebElement dropdownButton = waitForExpectedElement(By.xpath(
					"//select[@id='SupplierSpecificDelta']/following-sibling::div//button[contains(@class,'dropdown-toggle')]"));
			WebElement dropdownMenu = driver
					.findElement(By.xpath("//div[@class='multiselect-container dropdown-menu']"));

			// Check if dropdown is already open (visible)
			boolean isOpen = dropdownMenu.isDisplayed();

			if (!isOpen) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownButton);
				Thread.sleep(300);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownButton);
				LoggerUtil.pass("✅ Supplier Specific Delta dropdown clicked successfully.");
			} else {
				LoggerUtil.info("⚠️ Dropdown already open — skipping click.");
			}

		} catch (Exception e) {

			LoggerUtil.fail("❌ Failed to click Supplier Specific Delta dropdown.");
		}
	}

	public void saveProcessWithSupplierSpecificDeltaOnly(String processName, String rate, String date,
			String efficiency, String supplierName, String deltaName) throws InterruptedException {

		LoggerUtil.info("Step 1: Entering Process Name.");
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), "AB" + processName);

		LoggerUtil.info("Step 2: Entering Process Rate.");
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);

		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

		LoggerUtil.info("Step 3: Selecting Date.");
		clearAndEnterText(waitForExpectedElement(dateselection), date);

		LoggerUtil.info("Step 4: Entering Efficiency %.");
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiency);

		clickOnElement(BusinessSegBox);
		Thread.sleep(3000);
		clickOnElement(BusinessSegcheckboxfirst);
		clickOnElement(BusinessSegcheckboxsecond);
		clickOnElement(BusinessSegcheckboxthird);
		Thread.sleep(50000);
		clickSupplierSpecificDeltaDropdown();
		Thread.sleep(8000);
		clickOnElement(supplierdeltaselctcheckbox);
		Thread.sleep(20000);
		clickOnElement(rminputcategorycheckboxfirst);

		clickOnElement(saveprocessbtn);
		System.out.println(waitForExpectedElement(toastMessage).getText());
		String actualmsg = waitForExpectedElement(toastMessage).getText();
		String expectedmsg = "Process Details Saved successfully.";
		Assert.assertEquals(actualmsg, expectedmsg);
		clickOnElement(ViewBtn);
		Thread.sleep(16000);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), "AB" + processName);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']/tbody/tr"));
		LoggerUtil.info("🟢 Total rows found: " + rows.size());

		boolean matchFound = false;

		for (WebElement row : rows) {
			String rowText = row.getText().trim();

			// ✅ Skip rows with empty text
			if (rowText.isEmpty()) {
				continue;
			}

			LoggerUtil.info("Row: " + rowText);

			if (rowText.contains("AB" + processName)) {
				LoggerUtil.pass(" Process Name found in table: " + "AB" + processName);
				matchFound = true;
				Thread.sleep(3000);

				break;

			}
		}

		try {
			WebElement deleteIcon = driver.findElement(
					By.xpath("//table[@id='unitTable1']//tbody/tr[1]/td[2]//i[contains(@class,'fa-trash')]"));
			WebElement parentAnchor = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].parentNode;", deleteIcon);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentAnchor);
			Thread.sleep(500);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentAnchor);
			LoggerUtil.pass("✅ Step 2: Clicked on delete icon using JavaScript");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			LoggerUtil.pass("✅ Step 3: Confirmed alert popup for deletion");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Deletion failed — " + e.getMessage());
		}

	}

	public void saveProcessWithEnterPossitiveValueInSupplierSpecificDeltaOnly(String processName, String rate,
			String date, String efficiency, String supplierName, String possitivedeltavalue)
			throws InterruptedException {

		LoggerUtil.info("Step 1: Entering Process Name.");
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);

		LoggerUtil.info("Step 2: Entering Process Rate.");
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);

		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

		LoggerUtil.info("Step 3: Selecting Date.");
		clearAndEnterText(waitForExpectedElement(dateselection), date);

		LoggerUtil.info("Step 4: Entering Efficiency %.");
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiency);
		clickOnElement(rminputcategorycheckboxfirst);

		clickOnElement(BusinessSegBox);
		Thread.sleep(3000);
		clickOnElement(BusinessSegcheckboxfirst);
		clickOnElement(BusinessSegcheckboxsecond);
		clickOnElement(BusinessSegcheckboxthird);
		Thread.sleep(50000);
		clickSupplierSpecificDeltaDropdown();
		Thread.sleep(4000);
		clickOnElement(supplierdeltaselctcheckbox);
		Thread.sleep(8000);
		clearAndEnterText(waitForExpectedElement(enterdeltavalue), possitivedeltavalue);
		clickOnElement(saveprocessbtn);
		System.out.println(waitForExpectedElement(toastMessage).getText());
		String actualmsg = waitForExpectedElement(toastMessage).getText();
		String expectedmsg = "Process Details Saved successfully.";
		Assert.assertEquals(actualmsg, expectedmsg);
		clickOnElement(ViewBtn);
		Thread.sleep(16000);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), "AB" + processName);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='unitTable1']/tbody/tr"));
		LoggerUtil.info("🟢 Total rows found: " + rows.size());

		boolean matchFound = false;

		for (WebElement row : rows) {
			String rowText = row.getText().trim();

			// ✅ Skip rows with empty text
			if (rowText.isEmpty()) {
				continue;
			}

			LoggerUtil.info("Row: " + rowText);

			if (rowText.contains("AB" + processName)) {
				LoggerUtil.pass(" Process Name found in table: " + "AB" + processName);
				matchFound = true;
				Thread.sleep(3000);

				break;

			}
		}

		try {
			WebElement deleteIcon = driver.findElement(
					By.xpath("//table[@id='unitTable1']//tbody/tr[1]/td[2]//i[contains(@class,'fa-trash')]"));
			WebElement parentAnchor = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].parentNode;", deleteIcon);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentAnchor);
			Thread.sleep(500);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentAnchor);
			LoggerUtil.pass("✅ Step 2: Clicked on delete icon using JavaScript");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			LoggerUtil.pass("✅ Step 3: Confirmed alert popup for deletion");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Deletion failed — " + e.getMessage());
		}

	}

	public void saveProcessWithEnterNegativeValueInSupplierSpecificDeltaOnly(String processName, String rate,
			String date, String efficiency, String supplierName, String possitivedeltavalue)
			throws InterruptedException {

		LoggerUtil.info("Step 1: Entering Process Name.");
		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);

		LoggerUtil.info("Step 2: Entering Process Rate.");
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);

		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

		LoggerUtil.info("Step 3: Selecting Date.");
		clearAndEnterText(waitForExpectedElement(dateselection), date);

		LoggerUtil.info("Step 4: Entering Efficiency %.");
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiency);
		clickOnElement(rmInputCheckboxAll);

		clickOnElement(BusinessSegBox);
		Thread.sleep(3000);
		clickOnElement(BusinessSegcheckboxfirst);
		clickOnElement(BusinessSegcheckboxsecond);
		clickOnElement(BusinessSegcheckboxthird);
		Thread.sleep(50000);
		clickSupplierSpecificDeltaDropdown();
		Thread.sleep(4000);
		clickOnElement(supplierdeltaselctcheckbox);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(enterdeltavalue), possitivedeltavalue);
		clickOnElement(saveprocessbtn);
		Thread.sleep(5000);
		clickOnElement(ViewBtn);
		Thread.sleep(7000);
		clearAndEnterText(waitForExpectedElement(SearchboxProcess), processName);
		Thread.sleep(4000);
        
		
	}

	public void verifyeditsupplierdeltaandnewchange(String processName, String rate, String date, String efficiency,
            String supplierName, String possitivedeltavalue,
            String entername, String enterdelavalueagain)
throws InterruptedException {

LoggerUtil.info("Step 1: Entering Process Name.");
clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), processName);

LoggerUtil.info("Step 2: Entering Process Rate.");
clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);

LoggerUtil.info("Step 3: Selecting Unit (Index 17).");
selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

LoggerUtil.info("Step 4: Entering Date.");
clearAndEnterText(waitForExpectedElement(dateselection), date);

LoggerUtil.info("Step 5: Entering Efficiency %.");
clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiency);

LoggerUtil.info("Step 6: Clicking RM Input Checkbox All.");
clickOnElement(rmInputCheckboxAll);

LoggerUtil.info("Step 7: Selecting Business Segments.");
clickOnElement(BusinessSegBox);
Thread.sleep(3000);
clickOnElement(BusinessSegcheckboxfirst);
clickOnElement(BusinessSegcheckboxsecond);
clickOnElement(BusinessSegcheckboxthird);

LoggerUtil.info("Step 8: Clicking Supplier Specific Delta Dropdown.");
Thread.sleep(50000);
clickSupplierSpecificDeltaDropdown();

LoggerUtil.info("Step 9: Selecting Supplier Delta Checkbox.");
Thread.sleep(4000);
clickOnElement(supplierdeltaselctcheckbox);

LoggerUtil.info("Step 10: Entering Positive Delta Value: " + possitivedeltavalue);
Thread.sleep(3000);
clearAndEnterText(waitForExpectedElement(enterdeltavalue), possitivedeltavalue);

LoggerUtil.info("Step 11: Saving Process.");
clickOnElement(saveprocessbtn);

LoggerUtil.info("Step 12: Searching Process Name: " + entername);
Thread.sleep(6000);
clickOnElement(ViewBtn);
clearAndEnterText(waitForExpectedElement(SearchboxProcess), entername);

LoggerUtil.info("Step 13: Editing Process Master Data.");
Thread.sleep(3000);
EditProcessMasterData(entername);

LoggerUtil.info("Step 14: Updating Delta Value to: " + enterdelavalueagain);
clearAndEnterText(waitForExpectedElement(enterdeltavalue), enterdelavalueagain);

LoggerUtil.info("Step 15: Saving Updated Process.");
clickOnElement(saveprocessbtn);

LoggerUtil.info("Step 16: Searching Process Again for Verification.");
Thread.sleep(7000);
clickOnElement(ViewBtn);
clearAndEnterText(waitForExpectedElement(SearchboxProcess), entername);

LoggerUtil.info("Step 17: Editing Process Master Data Again.");
Thread.sleep(3000);
EditProcessMasterData(entername);

LoggerUtil.info("Step 18: Verifying Delta Value.");
String actualdeltavalue = waitForExpectedElement(enterdeltavalue).getAttribute("value");
String expecteddelvalue = enterdelavalueagain;

LoggerUtil.info("Actual Delta Value from UI: " + actualdeltavalue);
LoggerUtil.info("Expected Delta Value: " + expecteddelvalue);

BigDecimal bigvalueactual = new BigDecimal(actualdeltavalue).setScale(3, RoundingMode.HALF_UP);
BigDecimal bigvalueexpected = new BigDecimal(expecteddelvalue).setScale(3, RoundingMode.HALF_UP);

Assert.assertEquals(bigvalueactual, bigvalueexpected, "Values Are Mismatched");

LoggerUtil.info("✅ Delta value verification successful: " + bigvalueactual);
}


	public static final By AddSupplierBtn = By.xpath("//button[@onclick='addNewSupplierprocess()']");
	public static final By suppliercode = By.xpath("//input[@id='SupplierCode']");
	public static final By suppliername = By.xpath("//input[@id='SupplierName']");
	public static final By businessSegBox = By
			.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/button/span");
	public static final By BusinessSegcheckboxfirst1 = By
			.xpath("//label[normalize-space(text())='141235']/preceding-sibling::input[@type='checkbox']");
	public static final By saveprocesspopup = By.xpath("//button[@id='SaveSupplier']");
	public static final By searchboxinsuppliermaster = By.xpath("(//input[@type='search'])[3]");
	public static final By BusinessSegBox3 = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/button");
	public static final By BusinessSegcheckboxfirst3 = By
			.xpath("//label[normalize-space()='141235']/preceding-sibling::input[@type='checkbox']");
	public static final By searchbusinessSearchbarpop = By
			.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/div/div/input");

	public static final By fetchsuppliername = By.xpath("//table[@id='example1']/tbody/tr/td[3]");
	public static final By DeleteBtnforSupplierMaster = By.xpath("//table[@id='example1']/tbody/tr/td[7]/a[2]/span/i");
	public void addsupplier(String scode, String sname, String bsearch) {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Add Supplier button.");
	        clickOnElement(AddSupplierBtn);

	        LoggerUtil.info("Step 2: Entering Supplier Code: " + scode);
	        clearAndEnterText(waitForExpectedElement(suppliercode), scode);

	        LoggerUtil.info("Step 3: Entering Supplier Name: " + sname);
	        clearAndEnterText(waitForExpectedElement(suppliername), sname);

	        LoggerUtil.info("Step 4: Opening Business Segment selection popup.");
	        clickOnElement(businessSegBox);
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 5: Searching Business Segment with keyword: " + bsearch);
	        clearAndEnterText(waitForExpectedElement(searchbusinessSearchbarpop), bsearch);
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 6: Selecting all business segment checkboxes.");
	        clickOnElement(By.xpath("(//input[@value='multiselect-all'])[3]"));

	        LoggerUtil.info("Step 7: Saving Supplier details.");
	        clickOnElement(saveprocesspopup);
	        Thread.sleep(7000);

	        LoggerUtil.info("Step 8: Navigating back to Supplier Master dashboard.");
	        dashboard.clickonsuppliermaster();
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 9: Searching for newly added supplier: " + sname);
	        clearAndEnterText(waitForExpectedElement(searchboxinsuppliermaster), sname);

	        String actualValue = waitForExpectedElement(fetchsuppliername).getText();
	        LoggerUtil.info("Step 10: Verifying supplier name. Expected: " + sname + ", Actual: " + actualValue);
	        Assert.assertEquals(actualValue, sname, "Supplier Name does not match!");

	        LoggerUtil.pass("Supplier added successfully and verified: " + sname);

	        LoggerUtil.info("Step 11: Deleting the added supplier (cleanup).");
	        Thread.sleep(3000);
	        clickOnElement(DeleteBtnforSupplierMaster);
	        driver.switchTo().alert().accept();
	        LoggerUtil.pass("Supplier deleted successfully for cleanup.");
	        Thread.sleep(3000);
	    } catch (Exception e) {
	        LoggerUtil.fail("❌ Failed while adding supplier: " + e.getMessage());
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    }
	}


	public static final By BusinessSegBox2 = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/button");
	public static final By BusinessSegcheckboxfirst2 = By
			.xpath("//label[normalize-space()='141235']/preceding-sibling::input[@type='checkbox']");
	public static final By BusinessSegcheckboxsecond2 = By
			.xpath("//label[normalize-space()='Ai']/preceding-sibling::input[@type='checkbox']");
	public static final By BusinessSegcheckboxthird2 = By
			.xpath("//label[normalize-space()='Brant']/preceding-sibling::input[@type='checkbox']");

	public void saveExistingDataWithSameSupplierMultipleTime(String name, String rate, String tareek)
			throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), name);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);
		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
		clearAndEnterText(waitForExpectedElement(dateselection), tareek);
		clickOnElement(rmInputCheckboxAll);
		clickOnElement(BusinessSegBox2);
		clickOnElement(BusinessSegcheckboxfirst2);
		clickOnElement(BusinessSegcheckboxsecond2);
		clickOnElement(BusinessSegcheckboxthird2);
		Thread.sleep(15000);
		clickOnElement(saveprocessbtn);
		System.out.println(waitForExpectedElement(toastMessage).getText());
		String actualmsg = waitForExpectedElement(toastMessage).getText();
		String expectedmsg = "Process Details Saved successfully.";
		Assert.assertEquals(actualmsg, expectedmsg);
		

	}
	public void VerifySaveAgainWithSameSupplier(String name, String rate, String tareek)
			throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), name);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);
		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
		clearAndEnterText(waitForExpectedElement(dateselection), tareek);
		clickOnElement(rmInputCheckboxAll);
		clickOnElement(BusinessSegBox2);
		clickOnElement(BusinessSegcheckboxfirst2);
		clickOnElement(BusinessSegcheckboxsecond2);
		clickOnElement(BusinessSegcheckboxthird2);
		Thread.sleep(15000);
		clickOnElement(saveprocessbtn);
		System.out.println(waitForExpectedElement(toastMessage).getText());
		String actualmsg = waitForExpectedElement(toastMessage).getText();
		String expectedmsg = "Process Already Exist";
		Assert.assertEquals(actualmsg, expectedmsg,"Duplicate message mismatch");
		
		

	}

	public void VerifyExisitingDataDoesNotSaveExistingDataWithSameCustomer(String name,
            String rate,
            String tareek) throws InterruptedException {

LoggerUtil.info("Step 1: Entering Process Name -> " + name);
clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), name);

LoggerUtil.info("Step 2: Entering Process Rate -> " + rate);
clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);

LoggerUtil.info("Step 3: Selecting Unit (index 17).");
selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

LoggerUtil.info("Step 4: Entering Date -> " + tareek);
clearAndEnterText(waitForExpectedElement(dateselection), tareek);

LoggerUtil.info("Step 5: Selecting RM Input All.");
clickOnElement(rmInputCheckboxAll);

LoggerUtil.info("Step 6: Selecting Customer (second row).");
clickOnElement(customerselectcheckboxsecondrow);

LoggerUtil.info("Step 7: Saving Process (expect success save).");
Thread.sleep(3000);
clickOnElement(saveprocessbtn);

String actualMsg = waitForExpectedElement(toastMessage).getText();
String expectedMsg = "Process Details Saved successfully.";

LoggerUtil.info("Toast Received: " + actualMsg);
Assert.assertEquals(actualMsg, expectedMsg, "The Popup Message Are Mismatched..");

LoggerUtil.pass("Process saved successfully with customer (as expected).");
}

	public void VerifySameProcessWithSameCustomerShouldNotSaveAgain(String name,
            String rate,
            String tareek) throws InterruptedException {

LoggerUtil.info("Re-Create Attempt: Trying to save SAME Process again for duplicate validation.");

LoggerUtil.info("Step 1: Entering Process Name -> " + name);
clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), name);

LoggerUtil.info("Step 2: Entering Process Rate -> " + rate);
clearAndEnterText(waitForExpectedElement(EnterProcessRate), rate);

LoggerUtil.info("Step 3: Selecting Unit (index 17).");
selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

LoggerUtil.info("Step 4: Entering Date -> " + tareek);
clearAndEnterText(waitForExpectedElement(dateselection), tareek);

LoggerUtil.info("Step 5: Selecting RM Input All.");
clickOnElement(rmInputCheckboxAll);

LoggerUtil.info("Step 6: Selecting Customer (second row).");
clickOnElement(customerselectcheckboxsecondrow);

LoggerUtil.info("Step 7: Saving Process (expect DUPLICATE validation).");
Thread.sleep(5000);
clickOnElement(saveprocessbtn);

String actualMsg = waitForExpectedElement(toastMessage).getText();
String expectedMsg = "Process Already Exist";

LoggerUtil.info("Toast Received: " + actualMsg);
Assert.assertEquals(actualMsg, expectedMsg, "Expected duplicate warning toast.");

LoggerUtil.pass("Duplicate save correctly blocked. Toast matched: " + expectedMsg);

Thread.sleep(5000);

}


	public static final By takeheadingforverifyviewbtn = By.xpath("//h3[contains(text(),'Process List')]");
	public void clickviewbtn() {
	    LoggerUtil.info("Step 1: Checking if View Button is enabled.");

	    if (waitForExpectedElement(ViewBtn).isEnabled()) {
	        LoggerUtil.info("Step 2: Clicking on View Button.");
	        clickOnElement(ViewBtn);

	        String actualHeading = waitForExpectedElement(takeheadingforverifyviewbtn).getText();
	        String expectedHeading = "Process List";

	        LoggerUtil.info("Step 3: Verifying View Button action. Expected Heading: " + expectedHeading + " | Actual Heading: " + actualHeading);

	        if (actualHeading.equals(expectedHeading)) {
	            LoggerUtil.pass("✅ View Button is working correctly.");
	        } else {
	            LoggerUtil.fail("❌ View Button clicked but heading mismatch! Expected: " + expectedHeading + ", Found: " + actualHeading);
	            Assert.fail("View Button clicked but heading mismatch! Expected: " + expectedHeading + ", Found: " + actualHeading);
	        }
	    } else {
	        LoggerUtil.fail("❌ View Button is disabled or not clickable.");
	        Assert.fail("View Button is disabled or not clickable.");
	    }
	}

	public static final By clickcheckboxcustomer = By.xpath("//*[@id=\"costomerList\"]/tr[6]/td/div/label/input");
	public static final By selectallbtndelta = By.xpath(
			"(//select[@id='CustomerSpecificDelta']/following-sibling::div//div//button//input[@type='checkbox'])[1]");
	public static final By clickdeltaboxcustomer = By
			.xpath("(//*[@id=\"rmDiv\"]/div[1]/div/div/span/div/button/span)[2]");
	public static final By customervalue = By.xpath("//table[@id='rmCustomer']/tbody/tr[6]/td/div/label/input");
	public static final By numberofdeltapopulation = By.xpath(
			"(//select[@id='CustomerSpecificDelta']/following-sibling::div//div//button//input[@type='checkbox'])");

	public void verifynumebrofcustomerdeltapopulation() {
	    LoggerUtil.info("Step 1: Clicking on the Customer checkbox.");
	    clickOnElement(clickcheckboxcustomer);

	    LoggerUtil.info("Step 2: Clicking on the Delta box for Customer.");
	    clickOnElement(clickdeltaboxcustomer);

	    LoggerUtil.info("Step 3: Fetching list of delta population elements.");
	    List<WebElement> options = driver.findElements(numberofdeltapopulation);
	    int numberOfOptions = options.size();
	    LoggerUtil.info("Delta population count found: " + numberOfOptions);

	    Assert.assertEquals(numberOfOptions, 2, "Expected 2 customer delta population options, but found " + numberOfOptions);
	    LoggerUtil.info("✅ Delta population count verified successfully (Expected: 2).");

	   
	}


	public void validateOHPAndCavityDefaultsInExportedProcessSheet() throws IOException, InterruptedException {
		clickOnElement(clcikexportbutton);

		clickOnElement(exportnewdatapopupbutton);

		clickOnElement(supplierDropdown);

		Thread.sleep(4000);

		clickOnElement(supplieroptionExport);

		Thread.sleep(8000);

		clickOnElement(exportbutton);
          Thread.sleep(7000);

		FileInputStream fis = new FileInputStream(getLatestFileProcessMasterForSupplier());
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);

		String ohpLabel = "OHP N/A";
		String cavityLabel = "Process Cost Divide By No.Of Cavities";

		String ohpValue = null;
		String cavityValue = null;

		for (Row row : sheet) {
			Cell labelCell = row.getCell(0);
			if (labelCell != null && labelCell.getCellType() == CellType.STRING) {
				String cellText = labelCell.getStringCellValue().trim();

				if (cellText.equalsIgnoreCase(ohpLabel)) {
					Cell targetCell = row.getCell(1);
					ohpValue = extractCellValue(targetCell);
				}
				if (cellText.equalsIgnoreCase(cavityLabel)) {
					Cell targetCell = row.getCell(1);
					cavityValue = extractCellValue(targetCell);
				}
			}
		}

		workbook.close();
		fis.close();

		LoggerUtil.info("🔍 Validating default values in exported Process Master sheet...");
        try {
		if (!"N".equals(ohpValue)) {
			LoggerUtil.error("❌ BUG: OHP default value mismatch → Expected: 'N' | Actual: '"
					+ (ohpValue == null ? "null" : ohpValue) + "'");
			Assert.assertEquals(ohpValue, "N", "OHP default value should be 'N'");
		}

		if (!"N".equals(cavityValue)) {
			LoggerUtil.error("❌ BUG: Cavity default value mismatch → Expected: 'N' | Actual: '"
					+ (cavityValue == null ? "null" : cavityValue) + "'");
			Assert.assertEquals(cavityValue, "N", "Cavity default value should be 'N'");
		}

		LoggerUtil.info("✅ Exported process sheet default values validated successfully: OHP = N, Cavities = N");
	
	   }catch(Exception e) {
		e.getStackTrace();
		
	}
	}
	// Internal helper inside same method block
	private String extractCellValue(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue()).trim();
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue()).trim();
		case FORMULA:
			try {
				return cell.getStringCellValue().trim();
			} catch (IllegalStateException e) {
				return String.valueOf((int) cell.getNumericCellValue()).trim();
			}
		default:
			return "";
		}
	}
	
	
	public void ExportExcelDataForRead() throws InterruptedException {
		
		clickOnElement(exportbutton);
		Thread.sleep(2000);
		
		
		
		
	}

	public void validateCustomerExportProcessSheetDefaults() throws IOException, InterruptedException {
		LoggerUtil.info("Step 1: Opening exported Process sheet for Customer.");
		clickOnElement(clcikexportbutton);

		clickOnElement(exportnewdatapopupbutton);

		Thread.sleep(3000);
		clickOnElement(CustomerDropdowntBtnInExportPopUp);
		clickOnElement(customerDropdownselectionExportpopup);
		Thread.sleep(10000);
		clickOnElement(exportbutton);
		Thread.sleep(15000);
		
		FileInputStream fis = new FileInputStream(getLatestFileProcessMasterForSupplier());
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);

		// Field labels to validate
		String ohpLabel = "OHP N/A";
		String cavityLabel = "Process Cost Divide By No.Of Cavities";

		// Fields for information/logging only (not validated)
		String uomLabel = "Unit*";
		String weightLabel = "Weight Factor";
		String moduleLabel = "Module-1*";

		String ohpValue = null;
		String cavityValue = null;
		String uomValue = null;
		String weightValue = null;
		String moduleValue = null;

		for (Row row : sheet) {
			Cell labelCell = row.getCell(0);
			if (labelCell != null && labelCell.getCellType() == CellType.STRING) {
				String cellText = labelCell.getStringCellValue().trim();

				switch (cellText) {
				case "OHP N/A":
					ohpValue = extractCellValue(row.getCell(1));
					break;
				case "Process Cost Divide By No.Of Cavities":
					cavityValue = extractCellValue(row.getCell(1));
					break;
				case "Unit*":
					uomValue = extractCellValue(row.getCell(1));
					break;
				case "Weight Factor":
					weightValue = extractCellValue(row.getCell(1));
					break;
				case "Module-1*":
					moduleValue = extractCellValue(row.getCell(1));
					break;
				}
			}
		}

		workbook.close();
		fis.close();

		LoggerUtil.info("Step 2: Validating defaults for OHP and Cavity.");
		if (!"N".equals(ohpValue)) {
			LoggerUtil.error("❌ BUG: OHP default value mismatch → Expected: 'N' | Actual: '"
					+ (ohpValue == null ? "null" : ohpValue) + "'");
			Assert.assertEquals(ohpValue, "N", "OHP default value should be 'N'");
		}

		if (!"N".equals(cavityValue)) {
			LoggerUtil.error("❌ BUG: Cavity default value mismatch → Expected: 'N' | Actual: '"
					+ (cavityValue == null ? "null" : cavityValue) + "'");
			Assert.assertEquals(cavityValue, "N", "Cavity default value should be 'N'");
		}

		LoggerUtil.info("✅ Exported process sheet default values validated successfully: OHP = N, Cavities = N");

		LoggerUtil.info("ℹ️ Additional Info:");
		LoggerUtil.info(" - UOM = " + (uomValue == null ? "null" : uomValue));
		LoggerUtil.info(" - Weight Factor = " + (weightValue == null ? "null" : weightValue));
		LoggerUtil.info(" - Module-1 = " + (moduleValue == null ? "null" : moduleValue));
	}

	// Embedded utility
	private String extractCellValue1(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue()).trim();
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue()).trim();
		case FORMULA:
			try {
				return cell.getStringCellValue().trim();
			} catch (IllegalStateException e) {
				return String.valueOf((int) cell.getNumericCellValue()).trim();
			}
		default:
			return "";
		}
	}

	public void verifyMandatoryField(String baseRate, String dateSelection, String efficiencyRate, String mcTonnage) {

	    LoggerUtil.info("Step 1: Process Rate -> " + baseRate);
	    clearAndEnterText(waitForExpectedElement(EnterProcessRate), baseRate);

	    LoggerUtil.info("Step 2: Selecting Unit (index 17)");
	    selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

	    LoggerUtil.info("Step 3: Date Selection -> " + dateSelection);
	    clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);

	    LoggerUtil.info("Step 4: Efficiency Rate -> " + efficiencyRate);
	    clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);

	    LoggerUtil.info("Step 5: MC Tonnage -> " + mcTonnage);
	    clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);

	    LoggerUtil.info("Done: Mandatory fields filled.");
	}


	public void enterSpecificApplicabilityCustomerInformation1(String expectedMessage) {
	    LoggerUtil.info("🔹 Step 1: Selecting 'Cavities' checkbox");
	    clickOnElement(ClickingCavitiesCheckbox);

	    LoggerUtil.info("🔹 Step 2: Selecting 'OHP Not Applicable' checkbox");
	    clickOnElement(ohpnotapplicablecheckbox);

	    LoggerUtil.info("🔹 Step 3: Selecting Weight Factor (index 1)");
	    selectDropDownValue(weightfactorDropdown, "1", "index");

	    LoggerUtil.info("🔹 Step 4: Selecting 'RM Input - All' checkbox");
	    clickOnElement(rmInputCheckboxAll);

	    LoggerUtil.info("🔹 Step 5: Selecting 'Customer Selection' checkbox");
	    clickOnElement(customerselectioncheckbox);

	    LoggerUtil.info("🔹 Step 6: Clicking Save");
	    Base.clickOnElement(SaveBtn);

	    LoggerUtil.info("🔹 Step 7: Fetching toast message");
	    String toastText = waitForExpectedElement(toastMessage).getText();
	    LoggerUtil.info("ℹ Toast received: " + toastText);

	    try {
	        Assert.assertTrue(toastText.contains(expectedMessage),
	                "Expected message: [" + expectedMessage + "] but found: [" + toastText + "]");
	        LoggerUtil.info("✅ Toast message verified successfully.");
	    } catch (AssertionError e) {
	        LoggerUtil.error("❌ Toast verification failed. Expected: " + expectedMessage + " | Actual: " + toastText);
	        throw e;
	    }
	}


	public void verifyMandatoryFieldWithoutRate(String baseName, String dateSelection, String efficiencyRate,
            String mcTonnage) {
LoggerUtil.info("🔹 Step 1: Entering Process Name: " + baseName);
clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), baseName);

LoggerUtil.info("🔹 Step 2: Selecting Unit from dropdown (index 17)");
selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

LoggerUtil.info("🔹 Step 3: Entering Date Selection: " + dateSelection);
clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);

LoggerUtil.info("🔹 Step 4: Entering Efficiency Rate: " + efficiencyRate);
clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);

LoggerUtil.info("🔹 Step 5: Entering MC Tonnage: " + mcTonnage);
clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);

LoggerUtil.info("✅ Data entry (without Process Rate) completed. Ready for validation.");
}


	public void verifyMandatoryFieldWithoutUnit(String baseName,
            String baseRate,
            String dateSelection,
            String efficiencyRate,
            String mcTonnage) {

LoggerUtil.info("🔹 Step 1: Entering Process Name: " + baseName);
clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), baseName);

LoggerUtil.info("🔹 Step 2: Entering Process Rate: " + baseRate);
clearAndEnterText(waitForExpectedElement(EnterProcessRate), baseRate);

LoggerUtil.info("🔹 Step 3: Entering Date: " + dateSelection);
clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);

LoggerUtil.info("🔹 Step 4: Entering Efficiency Rate: " + efficiencyRate);
clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);

LoggerUtil.info("🔹 Step 5: Entering MC Tonnage: " + mcTonnage);
clearAndEnterText(waitForExpectedElement(Mctonnage), mcTonnage);

LoggerUtil.info("✅ Data entry (without selecting Unit) completed. Awaiting validation / save action.");
}


	public void verifyMandatoryFieldWithoutRm(String bsename, String bserate, String dateSelection,
            String efficiencyRate, String mctonnage) {
LoggerUtil.info("🔹 Step 1: Entering Process Name: " + bsename);
clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), bsename);

LoggerUtil.info("🔹 Step 2: Entering Process Rate: " + bserate);
clearAndEnterText(waitForExpectedElement(EnterProcessRate), bserate);

LoggerUtil.info("🔹 Step 3: Selecting Unit from dropdown (index 17)");
selectDropDownValue(unitDropDown, "Hrs.", "visibleText");

LoggerUtil.info("🔹 Step 4: Entering Date Selection: " + dateSelection);
clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);

LoggerUtil.info("🔹 Step 5: Entering Efficiency Rate: " + efficiencyRate);
clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);

LoggerUtil.info("🔹 Step 6: Entering MC Tonnage: " + mctonnage);
clearAndEnterText(waitForExpectedElement(Mctonnage), mctonnage);
}


	public void enterSpecificApplicabilityCustomerInformation1WithoutRmInput(String message) {
	    LoggerUtil.info("🔹 Step 1: Selecting 'Cavities' checkbox");
	    clickOnElement(ClickingCavitiesCheckbox);

	    LoggerUtil.info("🔹 Step 2: Selecting 'OHP Not Applicable' checkbox");
	    clickOnElement(ohpnotapplicablecheckbox);

	    LoggerUtil.info("🔹 Step 3: Selecting Weight Factor dropdown value (index 1)");
	    selectDropDownValue(weightfactorDropdown, "1", "index");

	    LoggerUtil.info("🔹 Step 4: Selecting Customer Selection checkbox");
	    clickOnElement(customerselectioncheckbox);

	    LoggerUtil.info("🔹 Step 5: Clicking on Save button");
	    Base.clickOnElement(SaveBtn);

	    String toastText = waitForExpectedElement(toastMessage).getText();
	    LoggerUtil.info("🔹 Step 6: Verifying toast message: " + toastText);

	    try {
	        Assert.assertTrue(toastText.contains(message),
	                "Expected message: [" + message + "] but found: [" + toastText + "]");
	        LoggerUtil.info("✅ Toast message verified successfully: " + toastText);
	    } catch (AssertionError e) {
	        LoggerUtil.error("❌ Toast message verification failed. Expected: " + message + ", but found: " + toastText);
	        throw e;
	    }
	}

	public void verifymandatoryfield(String bsename, String bserate, String dateSelection, String efficiencyRate,
			String mctonnage) {

		clearAndEnterText(waitForExpectedElement(EnterProcessNameValue), bsename);
		clearAndEnterText(waitForExpectedElement(EnterProcessRate), bserate);
		selectDropDownValue(unitDropDown, "Hrs.", "visibleText");
		clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
		clearAndEnterText(waitForExpectedElement(EnterEfficiencyrate), efficiencyRate);
		clearAndEnterText(waitForExpectedElement(Mctonnage), mctonnage);
	}

	public void enterSpecificApplicabilityCustomerInformation1WithoutCustomerAndSupplier(String message) {
	    LoggerUtil.info("🔹 Step 1: Selecting 'Cavities' checkbox");
	    clickOnElement(ClickingCavitiesCheckbox);

	    LoggerUtil.info("🔹 Step 2: Selecting 'OHP Not Applicable' checkbox");
	    clickOnElement(ohpnotapplicablecheckbox);

	    LoggerUtil.info("🔹 Step 3: Selecting Weight Factor dropdown value (index 1)");
	    selectDropDownValue(weightfactorDropdown, "1", "index");

	    LoggerUtil.info("🔹 Step 4: Selecting 'RM Input - All' checkbox");
	    clickOnElement(rmInputCheckboxAll);

	    LoggerUtil.info("🔹 Step 5: Clicking on Save button");
	    Base.clickOnElement(SaveBtn);

	    String toastText = waitForExpectedElement(toastMessage).getText();
	    LoggerUtil.info("🔹 Step 6: Verifying toast message: " + toastText);

	    try {
	        Assert.assertTrue(toastText.contains(message),
	                "Expected message: [" + message + "] but found: [" + toastText + "]");
	        LoggerUtil.info("✅ Toast message verified successfully: " + toastText);
	    } catch (AssertionError e) {
	        LoggerUtil.error("❌ Toast message verification failed. Expected: " + message + ", but found: " + toastText);
	        throw e;
	    }
	}


	public static final By clickibutton = By.xpath("//button[@title='Training Module']/i");
	public static final By headingverification = By.xpath("(//*[@id=\"exampleModalLabel\"])[12]");

	public void clickManualHelpButton() {

		clickOnElement(clickibutton);
		String actualvalue = waitForExpectedElement(headingverification).getText();
		LoggerUtil.info("Value Should Mastch To Expected Value = Support");
		LoggerUtil.info("Actual Value = " + actualvalue);
		Assert.assertEquals(actualvalue, "Support");

	}
	public static final By processname = By.xpath("//input[@id='processName']");
	public static final By processrate = By.xpath("//input[@id='Rate']");
	public static final By searchOnBusinessSegmentsSearchBox=By.xpath("//div[contains(@class,'multiselect-container') and contains(@class,'dropdown-menu') and contains(@class,'show')]//input[contains(@class,'multiselect-search')]");	
	public void creatingNewProcessForSupplier(String processName,
	        String processRate, String dateSelection, String message, String besineesSegments) {

	    LoggerUtil.info("Starting process detail entry for efficiency rate popup verification.");

	    try {
	        // -------- Process Details --------
	        clearAndEnterText(waitForExpectedElement(processname), processName);
	        LoggerUtil.pass("Entered process name: " + processName);

	        clearAndEnterText(waitForExpectedElement(processrate), processRate);
	        LoggerUtil.pass("Entered process rate: " + processRate);
	       

	        selectDropDownValue(unitDropDown, "41", "index");
	        LoggerUtil.pass("Selected Unit dropdown (index 41).");
	        
	        
	        clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
	        LoggerUtil.pass("Entered date: " + dateSelection);

	        // -------- Business Segment --------
	        clickOnElement(BusinessSegBox);
	        Thread.sleep(1500);

	        Base base = new Base();
	        base.sendKeysToTextBox(searchOnBusinessSegmentsSearchBox, besineesSegments);
	        selectMultiSelectValue(besineesSegments);
	        LoggerUtil.pass("Selected Business Segment: " + besineesSegments);

	        List<String> suppliersToSelect = Arrays.asList(
	                "Prabhat-3110-Gazipur"
	        );

	        selectOnlyTheseSuppliers(suppliersToSelect);


	        // -------- Save --------
	        clickOnElement(rmInputCheckboxAll);
	        clickOnElement(saveprocessbtn);
	        LoggerUtil.pass("Clicked on Save Process button.");

	    } catch (Exception e) {
	        LoggerUtil.error("Exception in creatingNewProcess: " + e.getMessage());
	    }
	}
	
	public void uncheckAllSuppliers() {
	    List<WebElement> checkboxes = getAllSupplierCheckboxes();

	    for (WebElement checkbox : checkboxes) {
	        if (checkbox.isSelected()) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	        }
	    }
	    LoggerUtil.info("All suppliers UNCHECKED successfully.");
	}
	
	public List<WebElement> getAllSupplierCheckboxes() {
	    return driver.findElements(By.xpath("//table[@id='rmSupplier']//label/input"));
	}



	public String getSupplierName(WebElement checkbox) {
	    return checkbox.findElement(By.xpath("./parent::label")).getText().trim();
	}
	
	public void checkOnlySelectedSuppliers(List<String> suppliersToCheck) {
	    List<WebElement> checkboxes = getAllSupplierCheckboxes();

	    for (WebElement checkbox : checkboxes) {
	        String supplierName = getSupplierName(checkbox);

	        if (suppliersToCheck.contains(supplierName)) {
	            if (!checkbox.isSelected()) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	                LoggerUtil.info("Checked Supplier: " + supplierName);
	            }
	        }
	    }
	}
	
	public void selectOnlyTheseSuppliers(List<String> suppliersToSelect) {

	    // Step 1: Uncheck everything first
	    uncheckAllSuppliers();

	    // Step 2: Check only required suppliers
	    checkOnlySelectedSuppliers(suppliersToSelect);
	}
	
	public void selectMultiSelectValue(String valueToSelect) {

	    String xpath = "//div[contains(@class,'multiselect-container') and contains(@class,'show')]"
	            + "//label[normalize-space()='" + valueToSelect + "']/preceding-sibling::input";

	    WebElement checkbox = driver.findElement(By.xpath(xpath));

	    if (!checkbox.isSelected()) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	    }
	}

	public double getUIRate() {
	    WebElement rateBox = driver.findElement(By.id("Rate"));
	    String val = rateBox.getAttribute("value").trim();
	    return Double.parseDouble(val);
	}

	public String getUIUOM() {
	    WebElement uom = driver.findElement(By.id("select2-uomDrop-container"));
	    return uom.getText().trim();
	}
	
	public void creatingNewProcessForSupplier2(String processName,
	        String processRate, String dateSelection, String message, String besineesSegments) {

	    LoggerUtil.info("Starting process detail entry for efficiency rate popup verification.");

	    try {
	        // -------- Process Details --------
	        clearAndEnterText(waitForExpectedElement(processname), processName);
	        LoggerUtil.pass("Entered process name: " + processName);

	        clearAndEnterText(waitForExpectedElement(processrate), processRate);
	        LoggerUtil.pass("Entered process rate: " + processRate);

	        selectDropDownValue(unitDropDown, "41", "index");
	        LoggerUtil.pass("Selected Unit dropdown (index 41).");

	        clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
	        LoggerUtil.pass("Entered date: " + dateSelection);

	        // -------- Business Segment --------
	        clickOnElement(BusinessSegBox);
	        Thread.sleep(1500);

	        Base base = new Base();
	        base.sendKeysToTextBox(searchOnBusinessSegmentsSearchBox, besineesSegments);
	        selectMultiSelectValue(besineesSegments);
	        LoggerUtil.pass("Selected Business Segment: " + besineesSegments);

	        List<String> suppliersToSelect = Arrays.asList(
	                "Roshan-3111-Gazipur"
	        );

	        selectOnlyTheseSuppliers(suppliersToSelect);


	        // -------- Save --------
	        clickOnElement(rmInputCheckboxAll);
	        clickOnElement(saveprocessbtn);
	        LoggerUtil.pass("Clicked on Save Process button.");

	    } catch (Exception e) {
	        LoggerUtil.error("Exception in creatingNewProcess: " + e.getMessage());
	    }
	}
	
	public List<WebElement> getAllCustomerCheckboxes() {
	    return driver.findElements(By.xpath("//table[@id='rmCustomer']//label/input"));
	}
	
	public String getCustomerName(WebElement checkbox) {
	    return checkbox.findElement(By.xpath("./parent::label")).getText().trim();
	}

	public void uncheckAllCustomers() {
	    List<WebElement> checkboxes = getAllCustomerCheckboxes();

	    for (WebElement cb : checkboxes) {
	        if (cb.isSelected()) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cb);
	        }
	    }
	    LoggerUtil.info("All customers UNCHECKED successfully.");
	}

	public void checkOnlySelectedCustomers(List<String> customersToSelect) {

	    List<WebElement> checkboxes = getAllCustomerCheckboxes();

	    for (WebElement cb : checkboxes) {

	        String customerName = getCustomerName(cb);

	        if (customersToSelect.contains(customerName)) {
	            if (!cb.isSelected()) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cb);
	                LoggerUtil.info("Checked Customer: " + customerName);
	            }
	        }
	    }
	}

	public void selectOnlyTheseCustomers(List<String> customersToSelect) {

	    // Step 1: Uncheck everything first
	    uncheckAllCustomers();

	    // Step 2: Check only required customers
	    checkOnlySelectedCustomers(customersToSelect);
	}

	public void creatingNewProcessForCustomer(String processName,
	        String processRate, String dateSelection, String message) {

	    LoggerUtil.info("Starting process detail entry for efficiency rate popup verification.");

	    try {
	        // -------- Process Details --------
	        clearAndEnterText(waitForExpectedElement(processname), processName);
	        LoggerUtil.pass("Entered process name: " + processName);

	        clearAndEnterText(waitForExpectedElement(processrate), processRate);
	        LoggerUtil.pass("Entered process rate: " + processRate);
	       

	        selectDropDownValue(unitDropDown, "41", "index");
	        LoggerUtil.pass("Selected Unit dropdown (index 41).");
	        
	        
	        clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
	        LoggerUtil.pass("Entered date: " + dateSelection);

	        List<String> customersForProcess1 = Arrays.asList("Prabhat-3110-Gazipur");
	        selectOnlyTheseCustomers(customersForProcess1);


	        // -------- Save --------
	        clickOnElement(rmInputCheckboxAll);
	        clickOnElement(saveprocessbtn);
	        LoggerUtil.pass("Clicked on Save Process button.");

	    } catch (Exception e) {
	        LoggerUtil.error("Exception in creatingNewProcess: " + e.getMessage());
	    }
	}
	
	public void creatingNewProcessForCustomer2(String processName,
	        String processRate, String dateSelection, String message) {

	    LoggerUtil.info("Starting process detail entry for efficiency rate popup verification.");

	    try {
	        // -------- Process Details --------
	        clearAndEnterText(waitForExpectedElement(processname), processName);
	        LoggerUtil.pass("Entered process name: " + processName);

	        clearAndEnterText(waitForExpectedElement(processrate), processRate);
	        LoggerUtil.pass("Entered process rate: " + processRate);

	        selectDropDownValue(unitDropDown, "41", "index");
	        LoggerUtil.pass("Selected Unit dropdown (index 41).");

	        clearAndEnterText(waitForExpectedElement(dateselection), dateSelection);
	        LoggerUtil.pass("Entered date: " + dateSelection);

	        List<String> customersForProcess2 = Arrays.asList("Roshan-3111-Gazipur");
	        selectOnlyTheseCustomers(customersForProcess2);

	        // -------- Save --------
	        clickOnElement(rmInputCheckboxAll);
	        clickOnElement(saveprocessbtn);
	        LoggerUtil.pass("Clicked on Save Process button.");

	    } catch (Exception e) {
	        LoggerUtil.error("Exception in creatingNewProcess: " + e.getMessage());
	    }
	}


}

	
	
