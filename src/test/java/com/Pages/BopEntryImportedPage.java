package com.Pages;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.helper.Base;

import com.helper.ExcelFiller;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

public class BopEntryImportedPage extends Base {
	DashboardPage dashboard = new DashboardPage();

	Faker faker = new Faker();
	public static final By AstricMArkBopCategory = By
			.xpath("//label[contains(text(),'BOP Category')]/following-sibling::span");

	public static final By AstricMarkBopType = By
			.xpath("(//label[contains(text(),'BOP Type')]/following-sibling::span)[2]");
	public static final By AstricMarkSupplier = By
			.xpath("(//label[contains(text(),'Supplier')]/following-sibling::span)[3]");
	public static final By optionBopCategoryDropdownvalue = By
			.xpath("//ul[@id='select2-BopEntry_BopEntryType-results']/li");
	public static final By ClickingBopCategoryDropdown = By
			.xpath("//span[@id='select2-BopEntry_BopEntryType-container']");

	public void verifyingAstricMark() throws InterruptedException {

		Thread.sleep(7000);
		SoftAssert soft = new SoftAssert();
		LoggerUtil.info("Starting test: Verify asterisk (*) mark for mandatory fields.");

		// Step 1: Select 'Imported' in BOP Category dropdown
		LoggerUtil.info("Clicking on BOP Category dropdown.");
		clickOnElement(ClickingBopCategoryDropdown);
		Thread.sleep(2000);

		List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
		LoggerUtil.info("Selecting 'Imported' from BOP Category options.");
		selectBootStrapDropDown(optionsBop, "Imported");
		Thread.sleep(2000);

		// Step 2: Verify asterisk mark for BOP Category
		String actualBopCategory = waitForExpectedElement(AstricMArkBopCategory).getText();
		String expectedBopCategory = "*";
		if (actualBopCategory.equals(expectedBopCategory)) {
			LoggerUtil.pass("BOP Category asterisk validated successfully. Value: '" + actualBopCategory + "'");
		} else {
			LoggerUtil.fail("BOP Category asterisk mismatch. Expected: '" + expectedBopCategory + "', Actual: '"
					+ actualBopCategory + "'");
		}
		soft.assertEquals(actualBopCategory, expectedBopCategory, "Mismatch in BOP Category asterisk mark");

		// Step 3: Verify asterisk mark for BOP Type
		String actualBopType = waitForExpectedElement(AstricMarkBopType).getText();
		String expectedBopType = "*";
		if (actualBopType.equals(expectedBopType)) {
			LoggerUtil.pass("BOP Type asterisk validated successfully. Value: '" + actualBopType + "'");
		} else {
			LoggerUtil.fail(
					"BOP Type asterisk mismatch. Expected: '" + expectedBopType + "', Actual: '" + actualBopType + "'");
		}
		soft.assertEquals(actualBopType, expectedBopType, "Mismatch in BOP Type asterisk mark");

		// Step 4: Verify asterisk mark for Supplier
		String actualSupplierAstric = waitForExpectedElement(AstricMarkSupplier).getText();
		String expectedSupplierAstric = "*";
		if (actualSupplierAstric.equals(expectedSupplierAstric)) {
			LoggerUtil.pass("Supplier asterisk validated successfully. Value: '" + actualSupplierAstric + "'");
		} else {
			LoggerUtil.fail("Supplier asterisk mismatch. Expected: '" + expectedSupplierAstric + "', Actual: '"
					+ actualSupplierAstric + "'");
		}
		soft.assertEquals(actualSupplierAstric, expectedSupplierAstric, "Mismatch in Supplier asterisk mark");

		soft.assertAll();
		LoggerUtil.info("Test completed: Asterisk validation for all mandatory fields.");
	}

	public static final By ClickOnBopTypeDropdown = By.xpath("//span[@id='select2-BopEntry_BopType-container']");
	public static final By ListofBopTypeDropDown = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li");

	public void sortingBopTypeDropDown() throws InterruptedException {
		LoggerUtil.info("=== Test Started: Verify BOP Type dropdown sorting (excluding 'Select') ===");

		try {
			Thread.sleep(7000);
			LoggerUtil.info("Clicking on the BOP Type dropdown.");
			clickOnElement(ClickOnBopTypeDropdown);
			Thread.sleep(2000);

			LoggerUtil.info("Fetching all values from the BOP Type dropdown.");
			List<WebElement> optionsOfBopType = driver.findElements(ListofBopTypeDropDown);
			ArrayList<String> actualList = new ArrayList<>();

			for (WebElement option : optionsOfBopType) {
				String text = option.getText().trim();
				actualList.add(text);
				LoggerUtil.info("Captured option: " + text);
			}

			// Exclude "Select" from sorting comparison
			String placeholder = "Select";
			List<String> sortableItems = new ArrayList<>(actualList);
			sortableItems.remove(placeholder);

			List<String> sortedExpected = new ArrayList<>(sortableItems);
			Collections.sort(sortedExpected, String.CASE_INSENSITIVE_ORDER);

			LoggerUtil.info("Actual Order (excluding placeholder): " + sortableItems);
			LoggerUtil.info("Expected Sorted Order: " + sortedExpected);

			if (sortableItems.equals(sortedExpected)) {
				LoggerUtil.pass("Dropdown values are correctly sorted alphabetically, excluding 'Select'.");
			} else {
				LoggerUtil.fail("Dropdown values are not sorted correctly (excluding 'Select').");
				LoggerUtil.info("Mismatch details:");
				for (int i = 0; i < sortedExpected.size(); i++) {
					if (!sortableItems.get(i).equalsIgnoreCase(sortedExpected.get(i))) {
						LoggerUtil.info("Mismatch at position " + (i + 1) + ": Actual = '" + sortableItems.get(i)
								+ "', Expected = '" + sortedExpected.get(i) + "'");
					}
				}
			}

			// Final assertion to fail test if not sorted
			Assert.assertEquals(sortableItems, sortedExpected,
					"Dropdown values are not sorted correctly (excluding 'Select').");

		} catch (Exception e) {
			LoggerUtil.fail("Exception occurred: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

		LoggerUtil.info("=== Test Completed: BOP Type dropdown sorting (excluding 'Select') ===");
	}

	public void verifyDefaultBopCategoryDropValue() throws InterruptedException {
		LoggerUtil.info("=== Test Started: Verify default value of BOP Category dropdown ===");

		try {
			Thread.sleep(7000);
			// Step 1: Click on BOP Category dropdown
			LoggerUtil.info("Clicking on BOP Category dropdown.");
			clickOnElement(ClickingBopCategoryDropdown);
			Thread.sleep(5000); // Can be replaced with WebDriverWait

			// Step 2: Read default selected value
			LoggerUtil.info("Reading the default selected value from the BOP Category dropdown.");
			String actualValue = waitForExpectedElement(ClickingBopCategoryDropdown).getText().trim();
			String expectedValue = "Imported";

			LoggerUtil.info("Expected Default Value: '" + expectedValue + "'");
			LoggerUtil.info("Actual Default Value  : '" + actualValue + "'");

			// Step 3: Compare and log result
			if (actualValue.equals(expectedValue)) {
				LoggerUtil.pass("Default BOP Category value is correct: '" + actualValue + "'");
			} else {
				LoggerUtil.fail("Default BOP Category value is incorrect. Expected: '" + expectedValue
						+ "', but found: '" + actualValue + "'");
			}

			// Final assertion
			Assert.assertEquals(actualValue, expectedValue, "Mismatch in default BOP Category dropdown value.");

		} catch (Exception e) {
			LoggerUtil.fail("Exception occurred while verifying default BOP Category value: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

		LoggerUtil.info("=== Test Completed: Default BOP Category dropdown value verification ===");
	}

	public static final By ClickingAddSupplierButton = By
			.xpath("(//a[@onclick=\"addNewSupplier('Imported')\"]/span)[1]");
	public static final By EnterValueSupplierCode = By.xpath("//input[@id='SupplierCode']");
	public static final By EnterValueSupplierName = By.xpath("//input[@id='SupplierName']");
	public static final By clickingBusinessSegment = By
			.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[4]");
	public static final By clickCheckboxForBusinessSegValue = By
			.xpath("//div[@class='multiselect-container dropdown-menu show']/button[2]/span/input");
	public static final By saveButtonForSuppleir = By.xpath("//button[@id='supplierSave']");
	public static final By crossButtonForAddSupplier = By
			.xpath("(//h5[@id='exampleModalLabel']/following-sibling::button[@class='btn-close'])[1]");
	public static final By clickingSupplierDropdown = By.xpath("//span[@id='select2-BopEntry_Supplier-container']");
	public static final By supplierlistoption = By.xpath("//ul[@id='select2-BopEntry_Supplier-results']/li");
	public static final By EnterSuppliernamevalue = By.xpath("//input[@class='select2-search__field']");

	public void EnteringSupplierValue(String enterSupplierCodeValue, String enteringSupplierName)
			throws InterruptedException {
		LoggerUtil.info("=== Test Started: Enter and verify new Supplier entry ===");

		try {
			Thread.sleep(7000);
			// Step 1: Select 'Imported' from BOP Category dropdown
			LoggerUtil.info("Clicking BOP Category dropdown.");
			clickOnElement(ClickingBopCategoryDropdown);
			Thread.sleep(2000);

			LoggerUtil.info("Selecting 'Imported' from BOP Category options.");
			List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
			selectBootStrapDropDown(optionsBop, "Imported");
			Thread.sleep(2000);

			// Step 2: Click Add Supplier
			LoggerUtil.info("Clicking on 'Add Supplier' button.");
			clickOnElement(ClickingAddSupplierButton);
			Thread.sleep(500);

			// Step 3: Enter Supplier Code and Name
			LoggerUtil.info("Entering Supplier Code: " + enterSupplierCodeValue);
			clearAndEnterText(waitForExpectedElement(EnterValueSupplierCode), enterSupplierCodeValue);

			LoggerUtil.info("Entering Supplier Name: " + enteringSupplierName);
			clearAndEnterText(waitForExpectedElement(EnterValueSupplierName), enteringSupplierName);
			Thread.sleep(2000);

			// Step 4: Select Business Segment
			LoggerUtil.info("Selecting Business Segment.");
			clickOnElement(clickingBusinessSegment);
			Thread.sleep(200);
			clickOnElement(clickCheckboxForBusinessSegValue);
			Thread.sleep(2000);

			// Step 5: Click Save and accept alert
			LoggerUtil.info("Clicking Save button for Supplier.");
			clickOnElement(saveButtonForSuppleir);
			Thread.sleep(2000);

			driver.navigate().refresh();
			LoggerUtil.info("User Refresing The Page ....");
			// Step 6: Search newly added supplier in dropdown

			dashboard.clickingBopEntryTab();
			Thread.sleep(200);
			Thread.sleep(7000);
			// Step 1: Select 'Imported' from BOP Category dropdown
			LoggerUtil.info("Clicking BOP Category dropdown.");
			clickOnElement(ClickingBopCategoryDropdown);
			LoggerUtil.info("Selecting 'Imported' from BOP Category options.");
			List<WebElement> optionsBop1 = driver.findElements(optionBopCategoryDropdownvalue);
			selectBootStrapDropDown(optionsBop1, "Imported");

			Thread.sleep(7000);
			LoggerUtil.info("Clicking Supplier dropdown to verify saved value.");
			clickOnElement(clickingSupplierDropdown);
			Thread.sleep(7000);

			LoggerUtil.info("Entering Supplier name in search: " + enteringSupplierName);
			clearAndEnterText(waitForExpectedElement(EnterSuppliernamevalue), enteringSupplierName);
			Thread.sleep(2000);

			// Step 7: Validate newly added supplier is displayed
			List<WebElement> optionSupplier = driver.findElements(supplierlistoption);
			WebElement firstMatch = optionSupplier.get(0);
			String actualValue = firstMatch.getText().trim();
			String expectedValue = enteringSupplierName;

			LoggerUtil.info("Expected Supplier Name: '" + expectedValue + "'");
			LoggerUtil.info("Actual Supplier Name  : '" + actualValue + "'");

			if (actualValue.equals(expectedValue)) {
				LoggerUtil.pass("Successfully saved and verified Supplier Name: '" + actualValue + "'");
			} else {
				LoggerUtil.fail(
						"Supplier Name mismatch. Expected: '" + expectedValue + "', Found: '" + actualValue + "'");
			}

			Assert.assertEquals(actualValue, expectedValue, "Mismatch in saved Supplier Name.");

		} catch (Exception e) {
			LoggerUtil.fail("Exception occurred while adding/verifying Supplier: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

		LoggerUtil.info("=== Test Completed: Supplier entry creation and verification ===");
	}

	public static final By clickingIncoTermsDropdown = By.xpath("//span[@id='select2-BopEntry_Icnoterms-container']");
	public static final By EnterSearchValueIncoTermsDropdown = By.xpath("//input[@class='select2-search__field']");
	public static final By listvalueofIncoterms = By.xpath("//ul[@id='select2-BopEntry_Icnoterms-results']/li");

	public void verifyIncotermsDropdown() throws InterruptedException {

		Thread.sleep(7000);

		LoggerUtil.info("Clicking BOP Category dropdown.");
		clickOnElement(ClickingBopCategoryDropdown);
		Thread.sleep(2000);

		LoggerUtil.info("Selecting 'Imported' from BOP Category options.");
		List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
		selectBootStrapDropDown(optionsBop, "Imported");
		Thread.sleep(2000);

		clickOnElement(clickingIncoTermsDropdown);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(EnterSearchValueIncoTermsDropdown), "INCO Term_INCO Term");
		List<WebElement> optionvalueofincoterms = driver.findElements(listvalueofIncoterms);

		WebElement flageincoterms = optionvalueofincoterms.get(0);
		String actualvalueofflag = flageincoterms.getText();
		String expectedvalueofFlag = "INCO Term_INCO Term";

		Assert.assertEquals(actualvalueofflag, expectedvalueofFlag, "Values Are Mismatched...");

	}

	public static void SelectingImportOption() throws InterruptedException {
		Thread.sleep(7000);
		
		clickOnElement(ClickingBopCategoryDropdown);
		List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
		selectBootStrapDropDown(optionsBop, "Imported");
	}

	public static final By clickingCurrency1Dropdown = By
			.xpath("//span[@id='select2-BopEntry_CurrencyConversion-container']");
	public static final By CurrencyDropdownoptions = By
			.xpath("//ul[@id='select2-BopEntry_CurrencyConversion-results']/li/following-sibling::li");

	public static final By clickingCurrencyDropdown2 = By
			.xpath("//span[@id='select2-BopEntry_CurrencyConversion1-container']");
	public static final By optionsCurrencyDrop2Value = By
			.xpath("//ul[@id='select2-BopEntry_CurrencyConversion1-results']/li/following-sibling::li");

	public void VerifyCurrencyDropdownbehaviour() {
		LoggerUtil.info("Starting: VerifyCurrencyDropdownbehaviour");

		SoftAssert softAssert = new SoftAssert();

		try {
			// ===== Currency 1 =====
			SelectingImportOption();
			Thread.sleep(4000);
			LoggerUtil.info("Opening Currency 1 dropdown.");
			clickOnElement(clickingCurrency1Dropdown);

			List<WebElement> listValueCurrency = driver.findElements(CurrencyDropdownoptions);
			ArrayList<String> actualValues = new ArrayList<>();
			for (WebElement flagvalue : listValueCurrency) {
				actualValues.add(flagvalue.getText().trim());
			}
			LoggerUtil.info("Currency 1 - Actual: " + actualValues);

			ArrayList<String> expectedValues = new ArrayList<>(actualValues);
			Collections.sort(expectedValues, String.CASE_INSENSITIVE_ORDER);
			LoggerUtil.info("Currency 1 - Expected: " + expectedValues);

			if (actualValues.equals(expectedValues)) {
				LoggerUtil.pass("Currency 1 dropdown is sorted (case-insensitive).");
			} else {
				LoggerUtil.fail("Currency 1 dropdown is NOT sorted (case-insensitive).");
			}
			softAssert.assertEquals(actualValues, expectedValues,
					"Currency 1 dropdown values are not sorted (case-insensitive).");

			// ===== Currency 2 =====
			LoggerUtil.info("Opening Currency 2 dropdown.");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropdown2);

			List<WebElement> currency2Options = driver.findElements(optionsCurrencyDrop2Value);
			ArrayList<String> actualValuesCurrency2 = new ArrayList<>();
			for (WebElement opt : currency2Options) {
				actualValuesCurrency2.add(opt.getText().trim());
			}
			LoggerUtil.info("Currency 2 - Actual: " + actualValuesCurrency2);

			ArrayList<String> expectedValuesCurrency2 = new ArrayList<>(actualValuesCurrency2);
			Collections.sort(expectedValuesCurrency2, String.CASE_INSENSITIVE_ORDER);
			LoggerUtil.info("Currency 2 - Expected: " + expectedValuesCurrency2);

			if (actualValuesCurrency2.equals(expectedValuesCurrency2)) {
				LoggerUtil.pass("Currency 2 dropdown is sorted (case-insensitive).");
			} else {
				LoggerUtil.fail("Currency 2 dropdown is NOT sorted (case-insensitive).");
			}
			softAssert.assertEquals(actualValuesCurrency2, expectedValuesCurrency2,
					"Currency 2 dropdown values are not sorted (case-insensitive).");

		} catch (Exception ex) {
			LoggerUtil.error("Exception in VerifyCurrencyDropdownbehaviour: " + ex.getMessage());
			softAssert.fail("Exception occurred: " + ex.getMessage());
		}

		// This will mark test fail if any soft assertions failed but will run all
		// checks
		softAssert.assertAll();

		LoggerUtil.info("Completed: VerifyCurrencyDropdownbehaviour");
	}

	public static final By EnterBopNameFirstTab = By.xpath("//input[@id='BopType_BopTypeName']");
	public static final By saveButtonFirstTabBopType = By.xpath("//button[@id='SaveBOP']");

	public static void EnterBopNameInFirstTab(String enterBopTypeValue) throws InterruptedException {
		LoggerUtil.info("=== Test Started: Enter BOP Name in First Tab ===");

		try {
			LoggerUtil.info("Entering BOP Name: " + enterBopTypeValue);
			clearAndEnterText(waitForExpectedElement(EnterBopNameFirstTab), enterBopTypeValue);
			Thread.sleep(2000);

			LoggerUtil.info("Clicking Save button for BOP Name.");
			clickOnElement(saveButtonFirstTabBopType);
			Thread.sleep(7000);

			LoggerUtil.pass("BOP Name entered and saved successfully: " + enterBopTypeValue);
		} catch (Exception e) {
			LoggerUtil.fail("Exception while entering/saving BOP Name: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

		Thread.sleep(6000);
		LoggerUtil.info("=== Test Completed: BOP Name Entry in First Tab ===");
	}

	public static final By EnterValueInternationalFrieght = By.xpath("//input[@id='BopEntry_International']");
	public static final By EnterShipmentQTy = By.xpath("//input[@id='reqe']");
	public static final By spotrate = By.xpath("//input[@id='exwork']");
	public static final By ButtonSaveBopEntrySave = By.xpath("//button[@id='SaveBOPEntry']");
	public static final By toastmsg = By.xpath("//div[@id='toast-container']/div/div[2][@class='toast-message']");
	public static final By SearchInSecondTab = By.xpath("(//input[@class='form-control form-control-sm'])[2]");
	public static final By deletebtnsecondtab = By.xpath("//*[@id='table1']/tbody/tr/td[10]/a[2]/i");
	public static final By scrolldown = By.xpath("//*[@id='Imported']/div/div[2]/div[2]/div[8]/div[5]/label/span");

	public void verifyValidationForShippingDetailsField(String bopValue, String enterFreightValue,
			String enterShipmentQty, String enterSpotRate, String enterSupplierCodeValue, String enteringSupplierName,
			String enterSearchValue) {

		SoftAssert soft = new SoftAssert();
		LoggerUtil.info("=== Test Started: Verify validation and flow for Shipping Details tab ===");

		try {
			// Page setup
			LoggerUtil.info("Refreshing the page.");
			driver.navigate().refresh();
			waitForElement(ClickOnBopTypeDropdown, 15);
			Thread.sleep(5000);

			// Select BOP Type
			try {
				LoggerUtil.info("Selecting BOP Type: " + bopValue);
				clickOnElement(ClickOnBopTypeDropdown);
				List<WebElement> options = driver.findElements(ListofBopTypeDropDown);
				selectBootStrapDropDown(options, bopValue);
			} catch (Exception e) {
				LoggerUtil.error("Failed to select BOP Type: " + e.getMessage());
				soft.fail("BOP Type selection failed.");
			}

			// Select BOP Category
			try {
				LoggerUtil.info("Selecting 'Imported' in BOP Category.");
				clickOnElement(ClickingBopCategoryDropdown);
				List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
				selectBootStrapDropDown(optionsBop, "Imported");
			} catch (Exception e) {
				LoggerUtil.error("Failed to select BOP Category: " + e.getMessage());
				soft.fail("BOP Category dropdown issue.");
			}

			// Shipping details entry
			try {
				LoggerUtil.info("Entering International Freight: " + enterFreightValue);
				clearAndEnterText(waitForExpectedElement(EnterValueInternationalFrieght), enterFreightValue);

				LoggerUtil.info("Entering Shipment Quantity: " + enterShipmentQty);
				clearAndEnterText(waitForExpectedElement(EnterShipmentQTy), enterShipmentQty);

				LoggerUtil.info("Entering Spot Rate: " + enterSpotRate);
				clearAndEnterText(waitForExpectedElement(spotrate), enterSpotRate);
			} catch (Exception e) {
				LoggerUtil.error("Error entering shipping details: " + e.getMessage());
				soft.fail("Shipping details fields failed.");
			}

			// Select Supplier
			try {
				LoggerUtil.info("Selecting supplier from dropdown.");
				clickOnElement(clickingSupplierDropdown);
				List<WebElement> supplierOptions = driver.findElements(supplierlistoption);

				if (!supplierOptions.isEmpty()) {
					supplierOptions.get(0).click();
				} else {
					LoggerUtil.warn("No suppliers found.");
					soft.fail("Supplier list is empty.");
				}
			} catch (Exception e) {
				LoggerUtil.error("Failed to select supplier: " + e.getMessage());
				soft.fail("Supplier selection failed.");
			}

			// Save and Toast Validation
			try {
				LoggerUtil.info("Clicking Save on BOP Entry.");
				clickOnElement(ButtonSaveBopEntrySave);

				String actualPopup = waitForExpectedElement(toastmsg).getText();
				String expectedPopup = "Invalid Entries.";
				soft.assertEquals(actualPopup, expectedPopup, "Toast mismatch for invalid shipping data.");

				LoggerUtil.pass("Toast validation successful. Message: " + actualPopup);
			} catch (Exception e) {
				LoggerUtil.error("Save or toast validation failed: " + e.getMessage());
				soft.fail("Save operation or toast handling failed.");
			}

			// Search and delete
			try {

				Thread.sleep(7000);

				LoggerUtil.info("Searching for BOP Value: " + enterSearchValue);
				clearAndEnterText(waitForExpectedElement(SearchInSecondTab), enterSearchValue);
				waitForElement(deletebtnsecondtab, 5);

				LoggerUtil.info("Clicking Delete.");
				clickOnElement(deletebtnsecondtab);
				driver.switchTo().alert().accept();

				String deletedToast = waitForExpectedElement(toastmsg).getText();
				String expectedDeleteToast = "BOP Entry deleted successfully."; // Replace with actual message
				soft.assertEquals(deletedToast, expectedDeleteToast, "Delete toast mismatch.");

				LoggerUtil.pass("Delete operation completed successfully. Toast: " + deletedToast);
			} catch (Exception e) {
				LoggerUtil.error("Failed to delete entry: " + e.getMessage());
				soft.fail("Entry deletion failed.");
			}

		} catch (Exception e) {
			LoggerUtil.fail("Test failed due to exception: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test execution halted due to exception.");
		}

		LoggerUtil.info("=== Test Completed: Shipping Details tab validation ===");
		soft.assertAll();
	}

	public static final By EnterExwork = By.xpath("//input[@id='exworktotal']");
	public static final By Enterothermisc = By.xpath("//input[@id='OTHERMISC']");

	public void ExWorkAndOtherMiscFieldsAcceptSpecialcharacterAndText(String bopValue, String enterForExworkvalue,
			String enterFormiscvalue) {
		SoftAssert soft = new SoftAssert();
		LoggerUtil.info("=== Starting ExWork and Misc Field Numeric Validation Test ===");

		try {
			LoggerUtil.info("Refreshing the page.");
			driver.navigate().refresh();
			Thread.sleep(7000);
			waitForElement(ClickOnBopTypeDropdown, 10);
		} catch (Exception e) {
			LoggerUtil.error("Page failed to refresh or element not found: " + e.getMessage());
			soft.fail("Page refresh or BOP dropdown element issue.");
		}

		try {
			LoggerUtil.info("Selecting BOP Type: " + bopValue);
			clickOnElement(ClickOnBopTypeDropdown);
			List<WebElement> options = driver.findElements(ListofBopTypeDropDown);
			selectBootStrapDropDown(options, bopValue);
		} catch (Exception e) {
			LoggerUtil.error("Failed to select BOP Type: " + e.getMessage());
			soft.fail("BOP Type dropdown selection failed.");
		}

		try {
			Thread.sleep(6000);
			LoggerUtil.info("Selecting BOP Category: Imported");
			clickOnElement(ClickingBopCategoryDropdown);
			List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
			selectBootStrapDropDown(optionsBop, "Imported");
		} catch (Exception e) {
			LoggerUtil.error("Failed to select BOP Category: " + e.getMessage());
			soft.fail("BOP Category dropdown selection failed.");
		}

		try {
			LoggerUtil.info("Selecting Supplier from dropdown.");
			clickOnElement(clickingSupplierDropdown);
			List<WebElement> optionSupplier = driver.findElements(supplierlistoption);
			if (!optionSupplier.isEmpty()) {
				optionSupplier.get(0).click();
			} else {
				LoggerUtil.warn("No suppliers found in the dropdown.");
				soft.fail("No supplier available to select.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Failed to select supplier: " + e.getMessage());
			soft.fail("Supplier dropdown interaction failed.");
		}

		try {
			LoggerUtil.info("Entering numeric values for Ex-Work and Other Misc fields.");
			clearAndEnterText(waitForExpectedElement(EnterExwork), enterForExworkvalue);
			clearAndEnterText(waitForExpectedElement(Enterothermisc), enterFormiscvalue);

			clickOnElement(ButtonSaveBopEntrySave);
			String actualPopup = waitForExpectedElement(toastmsg).getText();
			String expectedPopup = "invalid Data.!";

			soft.assertEquals(actualPopup, expectedPopup, "Invalid data popup message mismatch.");
			LoggerUtil.pass("Validation popup displayed as expected: " + actualPopup);
		} catch (Exception e) {
			LoggerUtil.error("Error during Save operation or toast validation: " + e.getMessage());
			soft.fail("Save button or toast message failed.");
		}

		try {
			LoggerUtil.info("Searching for entry to delete: " + bopValue);
			clearAndEnterText(waitForExpectedElement(SearchInSecondTab), bopValue);
			clickOnElement(deletebtnsecondtab);
			driver.switchTo().alert().accept();

			String actualDeleteMsg = waitForExpectedElement(toastmsg).getText();
			String expectedDeleteMsg = "BOP Entry deleted successfully."; // Confirm actual message

			soft.assertEquals(actualDeleteMsg, expectedDeleteMsg, "Delete confirmation popup mismatch.");
			LoggerUtil.pass("Entry deleted successfully with popup: " + actualDeleteMsg);
		} catch (Exception e) {
			LoggerUtil.error("Error during entry deletion: " + e.getMessage());
			soft.fail("Delete operation failed.");
		}

		LoggerUtil.info("=== ExWork and Other Misc Numeric Field Validation Test Completed ===");
		soft.assertAll();
	}

	public void ExWorkAndOtherMiscFieldsAcceptNumericOnly(String bopValue, String enterForExworkvalue,
			String enterFormiscvalue) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		LoggerUtil.info("=== Starting ExWork and Misc Field Numeric Validation Test ===");

		try {
			LoggerUtil.info("Refreshing the page.");
			driver.navigate().refresh();
			Thread.sleep(7000);
			waitForElement(ClickOnBopTypeDropdown, 10);
		} catch (Exception e) {
			LoggerUtil.error("Page failed to refresh or element not found: " + e.getMessage());
			soft.fail("Page refresh or BOP dropdown element issue.");
		}

		try {
			LoggerUtil.info("Selecting BOP Type: " + bopValue);
			clickOnElement(ClickOnBopTypeDropdown);
			List<WebElement> options = driver.findElements(ListofBopTypeDropDown);
			selectBootStrapDropDown(options, bopValue);
		} catch (Exception e) {
			LoggerUtil.error("Failed to select BOP Type: " + e.getMessage());
			soft.fail("BOP Type dropdown selection failed.");
		}

		try {
			LoggerUtil.info("Selecting BOP Category: Imported");
			clickOnElement(ClickingBopCategoryDropdown);
			List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
			selectBootStrapDropDown(optionsBop, "Imported");
		} catch (Exception e) {
			LoggerUtil.error("Failed to select BOP Category: " + e.getMessage());
			soft.fail("BOP Category dropdown selection failed.");
		}

		try {
			LoggerUtil.info("Selecting Supplier from dropdown.");
			clickOnElement(clickingSupplierDropdown);
			List<WebElement> optionSupplier = driver.findElements(supplierlistoption);
			if (!optionSupplier.isEmpty()) {
				optionSupplier.get(0).click();
			} else {
				LoggerUtil.warn("No suppliers found in the dropdown.");
				soft.fail("No supplier available to select.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Failed to select supplier: " + e.getMessage());
			soft.fail("Supplier dropdown interaction failed.");
		}

		try {
			LoggerUtil.info("Entering numeric values for Ex-Work and Other Misc fields.");
			clearAndEnterText(waitForExpectedElement(EnterExwork), enterForExworkvalue);
			clearAndEnterText(waitForExpectedElement(Enterothermisc), enterFormiscvalue);

			clickOnElement(ButtonSaveBopEntrySave);
			String actualPopup = waitForExpectedElement(toastmsg).getText();
			String expectedPopup = "Bop Entry Saved Sucessfully.";

			soft.assertEquals(actualPopup, expectedPopup, "Invalid data popup message mismatch.");
			LoggerUtil.pass("Validation popup displayed as expected: " + actualPopup);
		} catch (Exception e) {
			LoggerUtil.error("Error during Save operation or toast validation: " + e.getMessage());
			soft.fail("Save button or toast message failed.");
		}

		Thread.sleep(4999);

		try {
			LoggerUtil.info("Searching for entry to delete: " + bopValue);
			clearAndEnterText(waitForExpectedElement(SearchInSecondTab), bopValue);
			clickOnElement(deletebtnsecondtab);
			driver.switchTo().alert().accept();

			String actualDeleteMsg = waitForExpectedElement(toastmsg).getText();
			String expectedDeleteMsg = "BOP Entry deleted successfully."; // Confirm actual message

			soft.assertEquals(actualDeleteMsg, expectedDeleteMsg, "Delete confirmation popup mismatch.");
			LoggerUtil.pass("Entry deleted successfully with popup: " + actualDeleteMsg);
		} catch (Exception e) {
			LoggerUtil.error("Error during entry deletion: " + e.getMessage());
			soft.fail("Delete operation failed.");
		}

		LoggerUtil.info("=== ExWork and Other Misc Numeric Field Validation Test Completed ===");
		soft.assertAll();
	}

	public static final By EnteringInterNationalFrieghtValue = By.xpath("//input[@id='BopEntry_International']");
	public static final By EnteringInterNationFrieghtRightSide = By.xpath("//input[@id='BopEntry_Toimported']");
	public static final By EnteringShipmentQuality = By.xpath("//input[@id='reqe']");
	public static final By EnteringSpotRateForExpenseConversion = By.xpath("//input[@id='exwork']");
	public static final By EnteringExWork = By.xpath("//input[@id='exworktotal']");
	public static final By EnteringOtherMisc = By.xpath("//input[@id='OTHERMISC']");
	public static final By EnteringCurrencyConversion1 = By.xpath("//input[@id='ocean']");
	public static final By EnteringInternationalFrieght = By.xpath("//input[@id='internationocean']");
	public static final By EnteringInternationalFrieghtAsPerAsPerOnSpotConversion = By
			.xpath("//input[@id='interocean']");
	public static final By EnteringCvdValue = By.xpath("//input[@id='Cvd1']");
	public static final By EnteringCustomsEduCess = By.xpath("//input[@id='customer']");
	public static final By EnterInsurancevalue = By.xpath("//input[@id='insura11']");

	// Left Side Locators
	public static final By EnteringUnitPriceQuantity = By.xpath("//input[@id='unit']");
	public static final By EnteringTotalShipmentValue = By.xpath("//input[@id='total']");
	public static final By EnteringOtherMiscSpotConversionRateDifferent = By.xpath("//input[@id='exworktotal1']");
	public static final By EnteringCurrencyConversion2 = By.xpath("//input[@id='ocean2']");
	public static final By EnteringLandingAsperDutyConversion = By.xpath("//input[@id='landing1']");
	public static final By EnteringBasicDutyValue = By.xpath("//input[@id='basicduty']");
	public static final By EnteringEducessOnCvd = By.xpath("//input[@id='edu']");
	public static final By EnteringCustSecHiEduCessCvd = By.xpath("//input[@id='customersec']");
	public static final By EnteringIgstValue = By.xpath("//input[@id='igst']");
	public static final By EnteringBankLcValue = By.xpath("//input[@id='bankac1']");
	public static final By EnteringTargetMonthValue = By.xpath("//input[@id='banklc']");
	public static final By EnteringLandedCostNetvalue = By.xpath("//input[@id='landedcost']");

	public static final By clickingBopEntryDropDown = By.xpath(
			"//select[@id='BopEntry_BopEntryType']/following-sibling::span/span/span/span[@id='select2-BopEntry_BopEntryType-container']");
	public static final By SelectingBopEntryValues = By.xpath("//ul[@id='select2-BopEntry_BopEntryType-results']/li");
	public static final By fetchingvalueTotalLandedCost = By.xpath("//input[@id='totalINR']");

	public void EnteringValuesForValidateLandedCost() throws InterruptedException {
		LoggerUtil.info("Starting: EnteringValuesForValidateLandedCost");

		try {
			// Open BOP Entry dropdown and select "Imported"
			LoggerUtil.info("Clicking BOP Entry dropdown.");
			clickOnElement(clickingBopEntryDropDown);

			LoggerUtil.info("Selecting 'Imported' from BOP entries.");
			List<WebElement> BopEntriesSelection = driver.findElements(SelectingBopEntryValues);
			selectBootStrapDropDown(BopEntriesSelection, "Imported");

			// ===== Right side entries =====
			clearAndEnterText(waitForExpectedElement(EnteringShipmentQuality), "10");
			LoggerUtil.info("Shipment Quantity = 10");

			clearAndEnterText(waitForExpectedElement(EnteringSpotRateForExpenseConversion), "5.5");
			LoggerUtil.info("Spot Rate for Expense Conversion = 5.5");

			clearAndEnterText(waitForExpectedElement(EnteringExWork), "2");
			LoggerUtil.info("Ex-Work = 2");

			clearAndEnterText(waitForExpectedElement(EnteringOtherMisc), "1.5");
			LoggerUtil.info("Other Misc. = 1.5");

			clearAndEnterText(waitForExpectedElement(EnteringCurrencyConversion1), "82.34");
			LoggerUtil.info("Currency Conversion (Right) = 82.34");

			clearAndEnterText(waitForExpectedElement(EnteringInternationalFrieght), "12.53");
			LoggerUtil.info("International Freight = 12.53");

			clearAndEnterText(waitForExpectedElement(EnteringInternationalFrieghtAsPerAsPerOnSpotConversion), "25");
			LoggerUtil.info("Int. Freight as per Spot Conversion = 25");

			clearAndEnterText(waitForExpectedElement(EnteringCvdValue), "1");
			LoggerUtil.info("CVD = 1");

			clearAndEnterText(waitForExpectedElement(EnteringCustomsEduCess), "4.5");
			LoggerUtil.info("Customs Edu. Cess = 4.5");

			clearAndEnterText(waitForExpectedElement(EnterInsurancevalue), "3.2");
			LoggerUtil.info("Insurance = 3.2");

			// ===== Left side entries =====
			clearAndEnterText(waitForExpectedElement(EnteringUnitPriceQuantity), "2340");
			LoggerUtil.info("Unit Price/Quantity = 2340");

			clearAndEnterText(waitForExpectedElement(EnteringTotalShipmentValue), "5");
			LoggerUtil.info("Total Shipment Value = 5");

			clearAndEnterText(waitForExpectedElement(EnteringOtherMiscSpotConversionRateDifferent), "12");
			LoggerUtil.info("Other Misc. (Spot Conv. Rate Different) = 12");

			clearAndEnterText(waitForExpectedElement(EnteringCurrencyConversion2), "82.4");
			LoggerUtil.info("Currency Conversion (Left) = 82.4");

			clearAndEnterText(waitForExpectedElement(EnteringLandingAsperDutyConversion), "2.5");
			LoggerUtil.info("Landing as per Duty Conversion = 2.5");

			clearAndEnterText(waitForExpectedElement(EnteringBasicDutyValue), "1");
			LoggerUtil.info("Basic Duty = 1");

			clearAndEnterText(waitForExpectedElement(EnteringEducessOnCvd), "2.5");
			LoggerUtil.info("Edu. Cess on CVD = 2.5");

			clearAndEnterText(waitForExpectedElement(EnteringCustSecHiEduCessCvd), "3.5");
			LoggerUtil.info("Customs Sec. Hi Edu. Cess (CVD) = 3.5");

			clearAndEnterText(waitForExpectedElement(EnteringIgstValue), "1");
			LoggerUtil.info("IGST = 1");

			clearAndEnterText(waitForExpectedElement(EnteringBankLcValue), "2");
			LoggerUtil.info("Bank LC = 2");

			clearAndEnterText(waitForExpectedElement(EnteringTargetMonthValue), "24");
			LoggerUtil.info("Target Month = 24");

			clearAndEnterText(waitForExpectedElement(EnteringLandedCostNetvalue), "82.340");
			LoggerUtil.info("Landed Cost Net Value = 82.340");

			// ===== Fetch calculated value & validate =====
			String actualTotalLandedCost = waitForExpectedElement(fetchingvalueTotalLandedCost).getAttribute("value");
			LoggerUtil.info("Fetched Total Landed Cost (UI) = " + actualTotalLandedCost);

			String ExpectedvalueLandedCost = "16920.622";
			LoggerUtil.info("Expected Total Landed Cost = " + ExpectedvalueLandedCost);

			// Keep your BigDecimal logic exactly as is
			BigDecimal actualcost = new BigDecimal(actualTotalLandedCost);
			actualcost.setScale(3, BigDecimal.ROUND_HALF_UP);
			BigDecimal Expectedcost = new BigDecimal(ExpectedvalueLandedCost);
			Expectedcost.setScale(3, BigDecimal.ROUND_HALF_UP);

			if (actualcost.compareTo(Expectedcost) == 0) {
				LoggerUtil.pass("Total Landed Cost matched. Expected: " + Expectedcost + " | Actual: " + actualcost);
			} else {
				LoggerUtil.fail("Total Landed Cost mismatch. Expected: " + Expectedcost + " | Actual: " + actualcost);
			}

			Assert.assertEquals(actualcost, Expectedcost, "Total Landed Cost mismatch.");
			LoggerUtil.info("Completed: EnteringValuesForValidateLandedCost");

		} catch (Exception ex) {
			LoggerUtil.error("Exception in EnteringValuesForValidateLandedCost: " + ex.getMessage());
			throw ex;
		}
	}

	public static final By FetchingTotalShipmentValue = By.xpath("//input[@id='total_shippment']");

	public void verifyShipmentValueAutoCalculated(String shipval, String unitval) throws InterruptedException {
		LoggerUtil.info("Starting: verifyShipmentValueAutoCalculated");

		try {
			Thread.sleep(7000);

			LoggerUtil.info("Selecting 'Imported' in BOP Category.");
			clickOnElement(ClickingBopCategoryDropdown);
			List<WebElement> optionsBop = driver.findElements(optionBopCategoryDropdownvalue);
			selectBootStrapDropDown(optionsBop, "Imported");

			LoggerUtil.info("Entering Shipment Qty = " + shipval);
			clearAndEnterText(waitForExpectedElement(EnterShipmentQTy), shipval);

			LoggerUtil.info("Entering Unit Price/Quantity = " + unitval);
			clearAndEnterText(waitForExpectedElement(EnteringUnitPriceQuantity), unitval);

			// Calculate expected total shipment value
			int shipment = Integer.parseInt(shipval);
			int unitprice = Integer.parseInt(unitval);
			int expectedtotship = shipment * unitprice;
			BigDecimal expectedvalue = new BigDecimal(expectedtotship).setScale(3, BigDecimal.ROUND_HALF_UP);
			LoggerUtil.info("Expected Total Shipment Value (BigDecimal) = " + expectedvalue);

			// Fetch actual total shipment value from UI
			String actualfetchingTotatalshipmentValue = waitForExpectedElement(FetchingTotalShipmentValue)
					.getAttribute("value");
			BigDecimal actualvalue = new BigDecimal(actualfetchingTotatalshipmentValue).setScale(3,
					BigDecimal.ROUND_HALF_UP);
			LoggerUtil.info("Actual Total Shipment Value (BigDecimal) = " + actualvalue);

			// Compare and log
			if (actualvalue.equals(expectedvalue)) {
				LoggerUtil
						.pass("Total Shipment Value matched. Expected: " + expectedvalue + " | Actual: " + actualvalue);
			} else {
				LoggerUtil.fail(
						"Total Shipment Value mismatch. Expected: " + expectedvalue + " | Actual: " + actualvalue);
			}

			// Hard assert
			Assert.assertEquals(actualvalue, expectedvalue, "Total Shipment Value mismatch.");

			LoggerUtil.info("Completed: verifyShipmentValueAutoCalculated");
		} catch (Exception ex) {
			LoggerUtil.error("Exception in verifyShipmentValueAutoCalculated: " + ex.getMessage());
			throw ex;
		}
	}

	public static final By FetchingTotalLandedCostValue = By.xpath("//input[@id='totalINR']");
	public static final By FetchingInsuranceImpactValue = By.xpath("//*[@id='insura12']");

	public void verifyInsuranceValue() throws InterruptedException {
		LoggerUtil.info("Starting: verifyInsuranceValue");
		SoftAssert soft = new SoftAssert();

		try {
			Thread.sleep(7000);

			// --- Open & select Imported ---
			LoggerUtil.info("Clicking BOP Entry dropdown.");
			clickOnElement(clickingBopEntryDropDown);

			LoggerUtil.info("Selecting 'Imported' from BOP entries.");
			List<WebElement> BopEntriesSelection = driver.findElements(SelectingBopEntryValues);
			selectBootStrapDropDown(BopEntriesSelection, "Imported");

			// ===== Right side entries =====
			clearAndEnterText(waitForExpectedElement(EnteringShipmentQuality), "10");
			LoggerUtil.info("Shipment Quantity = 10");

			clearAndEnterText(waitForExpectedElement(EnteringSpotRateForExpenseConversion), "5.5");
			LoggerUtil.info("Spot Rate for Expense Conversion = 5.5");

			clearAndEnterText(waitForExpectedElement(EnteringExWork), "2");
			LoggerUtil.info("Ex-Work = 2");

			clearAndEnterText(waitForExpectedElement(EnteringOtherMisc), "1.5");
			LoggerUtil.info("Other Misc. = 1.5");

			clearAndEnterText(waitForExpectedElement(EnteringCurrencyConversion1), "82.34");
			LoggerUtil.info("Currency Conversion (Right) = 82.34");

			clearAndEnterText(waitForExpectedElement(EnteringInternationalFrieght), "12.53");
			LoggerUtil.info("International Freight = 12.53");

			clearAndEnterText(waitForExpectedElement(EnteringInternationalFrieghtAsPerAsPerOnSpotConversion), "25");
			LoggerUtil.info("Int. Freight as per Spot Conversion = 25");

			clearAndEnterText(waitForExpectedElement(EnteringCvdValue), "1");
			LoggerUtil.info("CVD = 1");

			clearAndEnterText(waitForExpectedElement(EnteringCustomsEduCess), "4.5");
			LoggerUtil.info("Customs Edu. Cess = 4.5");

			clearAndEnterText(waitForExpectedElement(EnterInsurancevalue), "3.2");
			LoggerUtil.info("Insurance = 3.2");

			// ===== Left side entries =====
			clearAndEnterText(waitForExpectedElement(EnteringUnitPriceQuantity), "2340");
			LoggerUtil.info("Unit Price/Quantity = 2340");

			clearAndEnterText(waitForExpectedElement(EnteringTotalShipmentValue), "5");
			LoggerUtil.info("Total Shipment Value = 5");

			clearAndEnterText(waitForExpectedElement(EnteringOtherMiscSpotConversionRateDifferent), "12");
			LoggerUtil.info("Other Misc. (Spot Conv. Rate Different) = 12");

			clearAndEnterText(waitForExpectedElement(EnteringCurrencyConversion2), "82.4");
			LoggerUtil.info("Currency Conversion (Left) = 82.4");

			clearAndEnterText(waitForExpectedElement(EnteringLandingAsperDutyConversion), "2.5");
			LoggerUtil.info("Landing as per Duty Conversion = 2.5");

			clearAndEnterText(waitForExpectedElement(EnteringBasicDutyValue), "1");
			LoggerUtil.info("Basic Duty = 1");

			clearAndEnterText(waitForExpectedElement(EnteringEducessOnCvd), "2.5");
			LoggerUtil.info("Edu. Cess on CVD = 2.5");

			clearAndEnterText(waitForExpectedElement(EnteringCustSecHiEduCessCvd), "3.5");
			LoggerUtil.info("Customs Sec. Hi Edu. Cess (CVD) = 3.5");

			clearAndEnterText(waitForExpectedElement(EnteringIgstValue), "1");
			LoggerUtil.info("IGST = 1");

			clearAndEnterText(waitForExpectedElement(EnteringBankLcValue), "2");
			LoggerUtil.info("Bank LC = 2");

			clearAndEnterText(waitForExpectedElement(EnteringTargetMonthValue), "24");
			LoggerUtil.info("Target Month = 24");

			clearAndEnterText(waitForExpectedElement(EnteringLandedCostNetvalue), "82.340");
			LoggerUtil.info("Landed Cost Net Value = 82.340");

			// --- Change Insurance to 4 and validate impact ---
			Thread.sleep(4000);
			clearAndEnterText(waitForExpectedElement(EnterInsurancevalue), "4");
			LoggerUtil.info("Updated Insurance = 4");

			// Impact value
			String actualfetchingimpactValue = waitForExpectedElement(FetchingInsuranceImpactValue)
					.getAttribute("value");
			BigDecimal actualimpact = new BigDecimal(actualfetchingimpactValue).setScale(3, BigDecimal.ROUND_HALF_UP);

			String expectedvalue = "4680";
			BigDecimal expectedimpact = new BigDecimal(expectedvalue).setScale(3, BigDecimal.ROUND_HALF_UP);

			if (actualimpact.equals(expectedimpact)) {
				LoggerUtil.pass("Insurance Impact matched. Expected: " + expectedimpact + " | Actual: " + actualimpact);
			} else {
				LoggerUtil
						.fail("Insurance Impact mismatch. Expected: " + expectedimpact + " | Actual: " + actualimpact);
			}
			soft.assertEquals(actualimpact, expectedimpact, "Insurance Impact mismatch.");

			// Total Landed Cost
			String actualValueTotalLandedCost = waitForExpectedElement(FetchingTotalLandedCostValue)
					.getAttribute("value");
			BigDecimal actualLandedcost = new BigDecimal(actualValueTotalLandedCost).setScale(3,
					BigDecimal.ROUND_HALF_UP);
			LoggerUtil.info("According To UI (Total Landed Cost) = " + actualLandedcost);

			String expectedValue = "17229.8023"; // will round to 17229.802 at 3 d.p.
			BigDecimal expectedlandedcostvalue = new BigDecimal(expectedValue).setScale(3, BigDecimal.ROUND_HALF_UP);
			LoggerUtil.info("According To Excel Sheet (Total Landed Cost) = " + expectedlandedcostvalue);

			if (actualLandedcost.equals(expectedlandedcostvalue)) {
				LoggerUtil.pass("Total Landed Cost matched. Expected: " + expectedlandedcostvalue + " | Actual: "
						+ actualLandedcost);
			} else {
				LoggerUtil.fail("Total Landed Cost mismatch. Expected: " + expectedlandedcostvalue + " | Actual: "
						+ actualLandedcost);
			}
			soft.assertEquals(actualLandedcost, expectedlandedcostvalue, "Total Landed Cost mismatch.");

		} catch (Exception ex) {
			LoggerUtil.error("Exception in verifyInsuranceValue: " + ex.getMessage());
			soft.fail("Exception occurred: " + ex.getMessage());
		}

		// Report all soft assertion results at the end
		soft.assertAll();
		LoggerUtil.info("Completed: verifyInsuranceValue");

	}

	public static final By optionsBoptype = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li");

	public static void clickingAndSelectingBopType(String value) throws InterruptedException {
		
		Thread.sleep(4000);
		clickOnElement(ClickOnBopTypeDropdown);
		Thread.sleep(9000);
		List<WebElement> valuesofBoptype = driver.findElements(optionsBoptype);

		selectBootStrapDropDown(valuesofBoptype, value);

	}

	public static final By EnterPartDescriptionValue = By.xpath("//input[@id='BopEntry_PartDescriptionImported']");
	public static final By EnterPartNumberValue = By.xpath("//input[@id='BopEntry_partnoimported']");
	public static final By ClickingSaveButton = By.xpath("//button[@id='SaveBOPEntry']");

	public static final By TotastmsgForOneLine = By.xpath("//div[@id='toast-container']/div");
	public static final By EnterSearchValue = By
			.xpath("//div[@id='table1_filter']//input[@class='form-control form-control-sm']");
	public static final By FetchingBopTypeName = By.xpath("//table[@id='table1']/tbody/tr/td[1]");

	public static void verifyBopImportWithMandatoryValues(String value, String partDescription, String partNumber)
			throws InterruptedException {
		LoggerUtil.info("Starting: verifyBopImportWithMandatoryValues");
		SoftAssert soft = new SoftAssert();

		try {
			driver.navigate().refresh();
			Thread.sleep(4000);

			// Select Import Option
			SelectingImportOption();
			LoggerUtil.info("Import option selected.");

			// Select BOP Type
			clickingAndSelectingBopType(value);
			LoggerUtil.info("BOP Type selected: " + value);
			Thread.sleep(4000);
			clearAndEnterText(waitForExpectedElement(EnterPartDescriptionValue), partDescription);
			LoggerUtil.info("Entered Part Description: " + partDescription);

			// Enter Part Number
			clearAndEnterText(waitForExpectedElement(EnterPartNumberValue), partNumber);
			LoggerUtil.info("Entered Part Number: " + partNumber);
			Thread.sleep(4000);
			// Select Supplier
			clickOnElement(clickingSupplierDropdown);
			Thread.sleep(2000);
			clickWithRetry(supplierlistoption, 3);
			// Enter Part Description

			Thread.sleep(7000);
			// Save
			clickOnElement(ClickingSaveButton);
			LoggerUtil.info("Clicked Save button.");

			String actualSavePopup = waitForExpectedElement(TotastmsgForOneLine).getText();
			String expectedPopup = "BOP Entry Saved Successfully";

			if (actualSavePopup.equals(expectedPopup)) {
				LoggerUtil.pass("Save popup matched. Expected: " + expectedPopup + " | Actual: " + actualSavePopup);
			} else {
				LoggerUtil.fail("Save popup mismatch. Expected: " + expectedPopup + " | Actual: " + actualSavePopup);
			}
			soft.assertEquals(actualSavePopup, expectedPopup, "Save popup message mismatch.");

			// Refresh and Search
			driver.navigate().refresh();
			Thread.sleep(6000);

			clearAndEnterText(waitForExpectedElement(EnterSearchValue), value);
			LoggerUtil.info("Searched with BOP Type: " + value);

			String actualDataFetching = waitForExpectedElement(FetchingBopTypeName).getText();

			if (value.equals(actualDataFetching)) {
				LoggerUtil.pass("BOP Type value matched. Expected: " + value + " | Actual: " + actualDataFetching);
			} else {
				LoggerUtil.fail("BOP Type value mismatch. Expected: " + value + " | Actual: " + actualDataFetching);
			}
			soft.assertEquals(actualDataFetching, value, "BOP Type search result mismatch.");

		} catch (Exception ex) {
			LoggerUtil.error("Exception in verifyBopImportWithMandatoryValues: " + ex.getMessage());
			soft.fail("Exception occurred: " + ex.getMessage());
		}

		soft.assertAll();
		LoggerUtil.info("Completed: verifyBopImportWithMandatoryValues");
	}

	
	public static void openBopTypeDropdown() {
	
		
		By dropdownBox = By.xpath("//span[@class='select2-selection select2-selection--single']");
		By dropdownInput = By.xpath(
				"//span[@class='select2-dropdown select2-dropdown--below']//input[@class='select2-search__field']");
		By options = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li");

		try {
			// Step 1: Hide UniversalSearch (always)
			try {
				WebElement searchBox = driver.findElement(By.id("UniversalSearch"));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", searchBox);
				LoggerUtil.info("UniversalSearch hidden to avoid intercept.");
			} catch (Exception ignore) {
				LoggerUtil.info("UniversalSearch not found, skipping hide.");
			}

			// Step 2: Click dropdown span
			WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(dropdownBox));

			try {
				
				Actions action = new Actions(driver);
				action.moveToElement(dropdown).click().perform();
				//dropdown.click();
				LoggerUtil.pass("Clicked BOP Type dropdown via Selenium.");
				
				
				
			} catch (Exception e) {
				LoggerUtil.error("Click intercepted, retrying via JS: " + e.getMessage());
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
				LoggerUtil.pass("BOP Type dropdown clicked via JS.");
			}

			// Step 3: Ensure dropdown input appears (forces Select2 list to open)
			WebElement input = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(dropdownInput));
			input.sendKeys(Keys.ARROW_DOWN); // force open
			LoggerUtil.info("Forced dropdown open using input field.");

			// Step 4: Wait for options to be visible
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(options));
			LoggerUtil.pass("BOP Type dropdown options are visible.");

		} catch (Exception e) {
			LoggerUtil.error("❌ Failed to open BOP Type dropdown: " + e.getMessage());
		}
	}

	public static final By clickingEditBtn = By.xpath("//*[@id='table1']/tbody/tr[1]/td[10]/a[1]/span/i");
	public static final By clickingUpdateBtn = By
			.xpath("//button[@value='UpdateBOPEntry' and normalize-space()='Update']");

	public static void verifyAndUpdateBopWithImported(String value, String oldvalue) throws InterruptedException {
		
		SoftAssert soft = new SoftAssert();
		Thread.sleep(2000);
		clickOnElement(clickingEditBtn);
		Thread.sleep(6000);
		openBopTypeDropdown();
		Thread.sleep(9000);
		List<WebElement> valuesofBoptype = driver.findElements(optionsBoptype);

		selectBootStrapDropDown(valuesofBoptype, value);

		Thread.sleep(2000);
		clickOnElement(clickingUpdateBtn);
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(6000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValue), value);
		LoggerUtil.info("Searched with BOP Type: " + value);

		String actualDataFetching = waitForExpectedElement(FetchingBopTypeName).getText();
		try {
			if (value.equals(actualDataFetching)) {
				LoggerUtil.pass("BOP Type value matched. Expected: " + value + " | Actual: " + actualDataFetching);
			} else {
				LoggerUtil.fail("BOP Type value mismatch. Expected: " + value + " | Actual: " + actualDataFetching);
			}

			soft.assertEquals(actualDataFetching, value, "BOP Type search result mismatch.");

			
			Thread.sleep(3000);
			WebElement searchbox = driver.findElement(EnterSearchValue);
			searchbox.sendKeys(Keys.CLEAR);
			Thread.sleep(2000);
			
			clearAndEnterText(waitForExpectedElement(EnterSearchValue), oldvalue);
			LoggerUtil.info("Searched with BOP Type: " + oldvalue);

			String actualOldData = waitForExpectedElement(FetchingBopTypeName).getText();

			if (oldvalue.equals(actualOldData)) {
				LoggerUtil.pass("BOP Type value matched. Expected: " + oldvalue + " | Actual: " + actualOldData);
			} else {
				LoggerUtil.fail("BOP Type value mismatch. Expected: " + oldvalue + " | Actual: " + actualOldData);
			}

			soft.assertEquals(actualOldData, oldvalue, "BOP Type search result match. ");

		} catch (Exception e) {

		}
		soft.assertAll();

	}
	
	
	
	
	   public static final By ReadBoptypeData = By.xpath("//table[@id='table1']/tbody/tr/td[1]");  
	public static final By ClickingCrossButton = By.xpath("//button[@onclick='dataloadagain()']");
	public static final By ClickingExportButton = By.xpath("//button[@onclick='Boppopupforexport()']");
	public static final By ClickingExportForDownload = By.xpath("//button[@id='exportOldButton']");
	public void verifyUiAndExcelDataForImported() throws InterruptedException {
	    try {
	        // Step 1: Select Import Option
	        SelectingImportOption();
	        LoggerUtil.info("Import option selected.");
	        Thread.sleep(2000);

	        // Step 2: Export Excel
	        clickOnElement(ClickingExportButton);
	        LoggerUtil.info("Clicked Export button for Imported.");
	        Thread.sleep(2000);

	        clickOnElement(ClickingExportForDownload);
	        LoggerUtil.info("Clicked Download button for Imported export.");
	        Thread.sleep(20000);

	        // Step 3: Fetch Latest Exported File
	        File downloadedFile = getLatestExportedExcelFileForBopImported();
	        LoggerUtil.info("✅ Downloaded file: " + downloadedFile.getAbsolutePath());

	        // Step 4: Close popup
	        clickOnElement(ClickingCrossButton);
	        LoggerUtil.info("Closed export popup.");
	        Thread.sleep(2000);

	        // Step 5: Fetch UI Data
	        List<WebElement> bopTypeNames = driver.findElements(ReadBoptypeData);
	        List<String> uiData = new ArrayList<>();
	        for (WebElement element : bopTypeNames) {
	            String value = element.getText().trim();
	            uiData.add(value);
	            LoggerUtil.info("Fetched UI Data: " + value);
	        }

	        // Step 6: Fetch Excel Data (Column B)
	        String filePath = downloadedFile.getAbsolutePath();
	        List<String> excelData = ExcelUtil.getExcelDataFromColumnB(filePath, "BOP_Procurement_Imported");

	        // Step 7: Compare UI vs Excel
	        for (int i = 0; i < excelData.size(); i++) {
	            String excelValue = excelData.get(i);
	            if (i < uiData.size()) {
	                String uiValue = uiData.get(i);
	                if (excelValue.equals(uiValue)) {
	                    LoggerUtil.pass("Row " + (i + 3) + " ✅ Match: " + excelValue);
	                } else {
	                    LoggerUtil.fail("Row " + (i + 3) + " ❌ Mismatch | Excel: " 
	                                    + excelValue + " | UI: " + uiValue);
	                }
	            }
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Exception in verifyUiAndExcelDataForImported: " + e.getMessage());
	    }
	}
	   public static final By clickingDownLoadForNewExcelFile = By.xpath("//button[@id='exportButtonBop']");
	public static final By clickingCheckboxSupplierDropdownoptions = By.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/div/button/span/input");
  public static final By clickingSupplierDropdownForExportingNewFile = By.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/button");
   public static final By ClickignExportNewDataRadioButton = By.xpath("//input[@id='BOPflexRadioDefault2']");
    public static final By clickingCrossBtnForNewFile = By.xpath("//button[@onclick='dataloadagain()']");
    public void verifyImportFileWithValidDetiails() throws InterruptedException {
        // Step 1: Select Import Option
        SelectingImportOption();
        LoggerUtil.info("Import option selected.");
        Thread.sleep(2000);

        // Step 2: Export Excel
        clickOnElement(ClickingExportButton);
        LoggerUtil.info("Clicked Export button for Imported.");
        Thread.sleep(3000);

        clickOnElement(ClickignExportNewDataRadioButton);
        Thread.sleep(2000);

        clickOnElement(clickingSupplierDropdownForExportingNewFile);
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(clickingCheckboxSupplierDropdownoptions);
        WebElement selectingoption = options.get(2);
        selectingoption.click();
        LoggerUtil.info("Supplier selected for export: " + selectingoption.getText());

        Thread.sleep(3000);
        clickOnElement(clickingDownLoadForNewExcelFile);
        LoggerUtil.info("Clicked Download button for Imported export.");

        Thread.sleep(20000);

        // Step 3: Fetch Latest Exported File
        File downloadedFile = getLatestExportedExcelFileForBopImported();
        LoggerUtil.info(" Downloaded file: " + downloadedFile.getAbsolutePath());

      
        String fileName = downloadedFile.getName();

        // Extract the date-time part by removing prefix and extension
        String dateTimePartExcel = fileName
                .replace("BOP_Procurement_Imported", "")
                .replace(".xlsx", "")
                .trim();

        LoggerUtil.info(" Extracted Date-Time from file: " + dateTimePartExcel);

        // Step 4: Get current date and time (same format)
        String actualTime = getTodayWithCurrentTime(); // e.g., 16-08-2025 15_34_04
        LoggerUtil.info(" Current Date-Time: " + actualTime);

     // Step 5: Strict comparison of date + time
        if (dateTimePartExcel.equals(actualTime)) {
            LoggerUtil.pass("✅ File timestamp matches exactly with system time: " + actualTime);
        } else {
            LoggerUtil.fail("❌ File timestamp mismatch! Expected: " 
                    + actualTime + " | Found in file: " + dateTimePartExcel);
        }

        Thread.sleep(2000);

        // Step 6: Close Popup
        clickOnElement(clickingCrossBtnForNewFile);
        LoggerUtil.info("Closed export popup.");
        Thread.sleep(2000);
    }

	
	
	
	
	
	
	
	
	
	
	

	  public String fillingFile() throws InterruptedException {
	    	Thread.sleep(3000);
			File latestFile = getLatestBOPProcurementStandardFile();
			if (latestFile == null) {
				System.out.println("No ProcessMaster file found.");
				return null;
			}
	    	
			String filePath = latestFile.getAbsolutePath();
	    	
			String bopdropdown = "Bolt";
			String childprtdes = faker.letterify("????");
			int randomint = faker.number().numberBetween(10, 90);
			String partno = String.valueOf(randomint);
			String UOM = "Kg";
			String Supplier = "0801-Abe";
			String supplycurrency = "India-Rupees-RBI";
			String yeardropdown = "2021-2022";
			String period = "May";		
			String partcost = String.valueOf(randomint);
			double floatvalue = faker.number().randomDouble(2, 100, 999);
			double floatvalue1 = faker.number().randomDouble(2, 100, 999);
			String Duties = String.valueOf(floatvalue);
			String frieghtAndInsurance = String.valueOf(floatvalue1);
			
			
			ExcelFiller.setCellValue(filePath, 0, 2, 1,ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));
			ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
			ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));		
			ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN,Arrays.asList(UOM) );
			ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Supplier));
			ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(supplycurrency));
			ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(yeardropdown));
			ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
			ExcelFiller.setCellValue(filePath, 0, 2, 10, ExcelFiller.ValueType.STRING,Arrays.asList(partcost));
			ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));	
			ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));
		
			return latestFile.getAbsolutePath();
			
			
			
	    	
	    }
    

    

	
	  public void verifyReadFileNamingConvention() throws InterruptedException {

		   
		    String TodataDateAndTime = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss").format(new Date());

		   
		    SelectingImportOption();
		    LoggerUtil.info("Import option selected.");
		    Thread.sleep(2000);

		    
		    clickOnElement(ClickingExportButton);
		    LoggerUtil.info("Clicked Export button for Imported.");
		    Thread.sleep(3000);

		    clickOnElement(ClickignExportNewDataRadioButton);
		    Thread.sleep(2000);

		    clickOnElement(clickingSupplierDropdownForExportingNewFile);
		    Thread.sleep(2000);

		    List<WebElement> options = driver.findElements(clickingCheckboxSupplierDropdownoptions);
		    WebElement selectingoption = options.get(2);
		    selectingoption.click();
		    LoggerUtil.info("Supplier selected for export: " + selectingoption.getText());

		    Thread.sleep(3000);
		    clickOnElement(clickingDownLoadForNewExcelFile);
		    LoggerUtil.info("Clicked Download button for Imported export.");

		    Thread.sleep(20000);

		    
		    File downloadedFile = getLatestExportedExcelFileForBopImported();
		    LoggerUtil.info("✅ Downloaded file: " + downloadedFile.getAbsolutePath());

		    String fileName = downloadedFile.getName();

		   
		    if (fileName.startsWith("BOP_Procurement_Imported")) {
		        LoggerUtil.pass(" File name starts correctly with 'BOP_Procurement_Imported'");
		    } else {
		        LoggerUtil.fail(" File name prefix is incorrect!");
		    }

		  
		    if (fileName.endsWith(".xlsx")) {
		        LoggerUtil.pass(" File name ends correctly with '.xlsx'");
		    } else {
		        LoggerUtil.fail(" File name suffix is incorrect!");
		    }

		    String verifyingTodayDateAndTime = fileName
		            .replace("BOP_Procurement_Imported", "")
		            .replace(".xlsx", "")
		            .trim();

		    if (TodataDateAndTime.equals(verifyingTodayDateAndTime)) {
		        LoggerUtil.pass(" File timestamp matches system time: " + TodataDateAndTime);
		    } else {
		        LoggerUtil.fail(" File timestamp mismatch! Expected: " 
		                + TodataDateAndTime + " | Found: " + verifyingTodayDateAndTime);
		    }
		}

	
	
	  public void verifySaveDataWithImportWithoutBopType( String partDescription, String partNumber)
				throws InterruptedException {
			LoggerUtil.info("Starting: verifyBopImportWithMandatoryValues");
			SoftAssert soft = new SoftAssert();

			try {
				driver.navigate().refresh();
				Thread.sleep(4000);

				
				SelectingImportOption();
				LoggerUtil.info("Import option selected.");

			
				Thread.sleep(4000);
				clearAndEnterText(waitForExpectedElement(EnterPartDescriptionValue), partDescription);
				LoggerUtil.info("Entered Part Description: " + partDescription);

				
				clearAndEnterText(waitForExpectedElement(EnterPartNumberValue), partNumber);
				LoggerUtil.info("Entered Part Number: " + partNumber);
				Thread.sleep(4000);
				
				clickOnElement(clickingSupplierDropdown);
				Thread.sleep(2000);
				clickWithRetry(supplierlistoption, 3);
				

				Thread.sleep(7000);
				
				clickOnElement(ClickingSaveButton);
				LoggerUtil.info("Clicked Save button.");

				String actualSavePopup = waitForExpectedElement(TotastmsgForOneLine).getText();
				String expectedPopup = "Required\r\n"
						+ "Please Select BOP Type";
				
			String 	expected = expectedPopup.trim().replaceAll("\\s+", " ");
			String	actual   = actualSavePopup.trim().replaceAll("\\s+", " ");
						
				if (actual.equals(expected)) {
					LoggerUtil.pass("Save popup matched. Expected: " + expected + " | Actual: " + actual);
				} else {
					LoggerUtil.fail("Save popup mismatch. Expected: " + expected + " | Actual: " + actual);
				}
				soft.assertEquals(actual, expected, "Save popup message mismatch.");

				// Refresh and Search
				driver.navigate().refresh();
				Thread.sleep(6000);

				

				
			

			} catch (Exception ex) {
				LoggerUtil.error("Exception in verifyBopImportWithMandatoryValues: " + ex.getMessage());
				soft.fail("Exception occurred: " + ex.getMessage());
			}

			soft.assertAll();
			LoggerUtil.info("Completed: verifyBopImportWithMandatoryValues");
		}

	
	
	
	

}
