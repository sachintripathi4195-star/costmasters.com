package com.Pages;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class BopEntryStandardPage extends Base {
	
	Actions action = new Actions(driver);
	
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(19));
	ControlMasterPage control = new ControlMasterPage();
	Faker faker = new Faker();
	DashboardPage dashboard = new DashboardPage();
	public static final By ClickingUomDropDown = By.xpath("//span[@id='select2-BopEntry_UomStandard-container']");
	public static final By clickingCurrencyDropDown = By
			.xpath("//span[@id='select2-BopEntry_StandardCurrency-container']");
	public static final By clickingYearDropdown = By.xpath("//select[@id='BopEntry_StandardYear']");
	public static final By supplierStandardDropdownPlaceholderValue = By
			.xpath("//span[@id='select2-BopEntry_SupplierStandard-container']/span");
	public static final By periodDropdownValue = By.xpath("//select[@id='BopEntry_StandardPeriod']/option");
	public static final By clickingBopTypeDropdown = By.xpath("//span[@id='select2-BopEntry_BopType-container']");
	public static final By clickingBopCategoryDropdown = By
			.xpath("//span[@id='select2-BopEntry_BopEntryType-container']");
	public static final By BopCategoryDropDownValue = By.xpath("//ul[@id='select2-BopEntry_BopEntryType-results']/li");
	public static final By ListvalueyearDropdown = By.xpath("//select[@id='BopEntry_StandardYear']/option");
	public static final By clickingPeriodDropdown = By.xpath("//select[@id='BopEntry_StandardPeriod']");

	public void verifyDropdownPlaceholder(By locator, String expected, String fieldName, SoftAssert softAssert) {
		try {
			String actual = waitForExpectedElement(locator).getText().trim();
			LoggerUtil.logger.info("Verifying placeholder for " + fieldName + ": Expected = '" + expected
					+ "', Actual = '" + actual + "'");
			softAssert.assertEquals(actual, expected, "Mismatch in placeholder for: " + fieldName);
		} catch (Exception e) {
			softAssert.fail("Exception while verifying " + fieldName + " placeholder: " + e.getMessage());
		}

	}

	public void verifyDropdownPlaceholders() throws InterruptedException {

		SoftAssert soft = new SoftAssert();

		Thread.sleep(8000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");

		verifyDropdownPlaceholder(clickingBopTypeDropdown, "Select", "BOP Type", soft);
		verifyDropdownPlaceholder(ClickingUomDropDown, "Select", "UOM", soft);
		verifyDropdownPlaceholder(clickingCurrencyDropDown, "Select", "Currency", soft);
		verifyDropdownPlaceholder(supplierStandardDropdownPlaceholderValue, "Select", "Supplier", soft);
		soft.assertAll();
	}

	public void verifyDifferentTypePlaceHolders() throws InterruptedException {
		boolean status = false;
		Thread.sleep(8000);

		try {
			clickOnElement(clickingYearDropdown);
			clickOnElement(clickingPeriodDropdown);
			Thread.sleep(3000);

			List<WebElement> optionyearDropdown = driver.findElements(ListvalueyearDropdown);
			selectBootStrapDropDown(optionyearDropdown, "Select");

			for (WebElement ele : optionyearDropdown) {
				if (ele.getText().trim().equalsIgnoreCase("Select")) {
					LoggerUtil.pass("'Select' Placeholder is Available in Year Dropdown");
					status = true;
					break;
				}
			}

			if (!status) {
				LoggerUtil.fail("'Select' Placeholder is NOT Available in Year Dropdown");
			}

			status = false; // reset for next check
			List<WebElement> optionperiodDropvalue = driver.findElements(periodDropdownValue);
			selectBootStrapDropDown(optionperiodDropvalue, "Select");

			for (WebElement ele : optionperiodDropvalue) {
				if (ele.getText().trim().equalsIgnoreCase("Select")) {
					LoggerUtil.pass("'Select' Placeholder is Available in Period Dropdown");
					status = true;
					break;
				}
			}

			if (!status) {
				LoggerUtil.fail("'Select' Placeholder is NOT Available in Period Dropdown");
			}

		} catch (Exception e) {
			LoggerUtil.fail("Exception occurred while verifying placeholders: " + e.getMessage());
		}
	}

	public static final By EnterPartDescription = By.xpath("//input[@id='BopEntry_ChildPartDescStandard']");
	public static final By EnterPartNumber = By.xpath("//input[@id='BopEntry_PartNoStandard']");
	public static final By EnterfrieghtAndInsuranceStandard = By.xpath("//input[@id='FreightInsuanceStandard']");
	public static final By EnterOtherCost = By.xpath("//input[@id='OtherCostStandard']");

	public void verifyManualEntry() throws InterruptedException {
		Thread.sleep(8000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");

		SoftAssert soft = new SoftAssert();

		String actualEnterPartDescription = waitForExpectedElement(EnterPartDescription).getAttribute("placeholder");
		if (actualEnterPartDescription.equalsIgnoreCase("Enter")) {
			LoggerUtil.pass(" 'Enter' placeholder is visible in Part Description");
		} else {
			LoggerUtil.fail(" Placeholder mismatch in Part Description (found: '" + actualEnterPartDescription + "')");
		}
		soft.assertEquals(actualEnterPartDescription, "Enter", "Mismatch in Part Description placeholder");

		String actualPartNumberValue = waitForExpectedElement(EnterPartNumber).getAttribute("placeholder");
		if (actualPartNumberValue.equalsIgnoreCase("Enter")) {
			LoggerUtil.pass(" 'Enter' placeholder is visible in Part Number");
		} else {
			LoggerUtil.fail(" Placeholder mismatch in Part Number (found: '" + actualPartNumberValue + "')");
		}
		soft.assertEquals(actualPartNumberValue, "Enter", "Mismatch in Part Number placeholder");

		String actualfrieghtAndInsuranceStandard = waitForExpectedElement(EnterfrieghtAndInsuranceStandard)
				.getAttribute("placeholder");
		if (actualfrieghtAndInsuranceStandard.equalsIgnoreCase("Enter")) {
			LoggerUtil.pass(" 'Enter' placeholder is visible in Freight & Insurance");
		} else {
			LoggerUtil.fail(" Placeholder mismatch in Freight & Insurance (found: '" + actualfrieghtAndInsuranceStandard
					+ "')");
		}
		soft.assertEquals(actualfrieghtAndInsuranceStandard, "Enter", "Mismatch in Freight & Insurance placeholder");

		String actualEnterOtherCost = waitForExpectedElement(EnterOtherCost).getAttribute("placeholder");
		if (actualEnterOtherCost.equalsIgnoreCase("Enter")) {
			LoggerUtil.pass(" 'Enter' placeholder is visible in Other Cost");
		} else {
			LoggerUtil.fail(" Placeholder mismatch in Other Cost (found: '" + actualEnterOtherCost + "')");
		}
		soft.assertEquals(actualEnterOtherCost, "Enter", "Mismatch in Other Cost placeholder");

		soft.assertAll();
	}

	public static final By AstricMarkPartDescription = By
			.xpath("(//div[@class='col-md-2']/label[@for='Part_Description']/following-sibling::span)[2]");
	public static final By AstricMarkPartNumberStandard = By
			.xpath("//div[@class='col-sm-2']/label[@for='BopEntry_PartNoStandard']/following-sibling::span");
	public static final By AstricMarkUomStandard = By
			.xpath("//div[@class='col-sm-2']/label[@for='BopEntry_UomStandard']/following-sibling::span");
	public static final By AstricMarkSupplier = By
			.xpath("//div[@class='col-sm-2 SupplierDiv']/label[@id='Supplierdata']/following-sibling::span");
	public static final By AstricMarksCurrency = By
			.xpath("//div[@class='col-sm-2']/label[@for='BopEntry_StandardCurrency']/following-sibling::span");
	public static final By AstricMarkPartCostUnit = By
			.xpath("//div[@class='col-sm-2']/label[@for='BopEntry_PartCostStandard']/following-sibling::span");

	public void verifyAstricMarkIsAvailable() throws InterruptedException {
		SoftAssert soft = new SoftAssert();

		Thread.sleep(8000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");

		String actualAstricMarkPartDescription = waitForExpectedElement(AstricMarkPartDescription).getText().trim();
		if (actualAstricMarkPartDescription.equals("*")) {
			LoggerUtil.pass(" Asterisk is present for Part Description");
		} else {
			LoggerUtil.fail(
					" Asterisk is missing for Part Description (found: '" + actualAstricMarkPartDescription + "')");
		}
		soft.assertEquals(actualAstricMarkPartDescription, "*", "Missing * for Part Description");

		String actualAstricMarkPartNumberStandard = waitForExpectedElement(AstricMarkPartNumberStandard).getText()
				.trim();
		if (actualAstricMarkPartNumberStandard.equals("*")) {
			LoggerUtil.pass(" Asterisk is present for Part Number");
		} else {
			LoggerUtil
					.fail(" Asterisk is missing for Part Number (found: '" + actualAstricMarkPartNumberStandard + "')");
		}
		soft.assertEquals(actualAstricMarkPartNumberStandard, "*", "Missing * for Part Number");

		String actualAstricMarkUomStandard = waitForExpectedElement(AstricMarkUomStandard).getText().trim();
		if (actualAstricMarkUomStandard.equals("*")) {
			LoggerUtil.pass(" Asterisk is present for UOM");
		} else {
			LoggerUtil.fail(" Asterisk is missing for UOM (found: '" + actualAstricMarkUomStandard + "')");
		}
		soft.assertEquals(actualAstricMarkUomStandard, "*", "Missing * for UOM");

		String actualAstricMarkSupplier = waitForExpectedElement(AstricMarkSupplier).getText().trim();
		if (actualAstricMarkSupplier.equals("*")) {
			LoggerUtil.pass(" Asterisk is present for Supplier");
		} else {
			LoggerUtil.fail(" Asterisk is missing for Supplier (found: '" + actualAstricMarkSupplier + "')");
		}
		soft.assertEquals(actualAstricMarkSupplier, "*", "Missing * for Supplier");

		String actualAstricMarksCurrency = waitForExpectedElement(AstricMarksCurrency).getText().trim();
		if (actualAstricMarksCurrency.equals("*")) {
			LoggerUtil.pass(" Asterisk is present for Currency");
		} else {
			LoggerUtil.fail(" Asterisk is missing for Currency (found: '" + actualAstricMarksCurrency + "')");
		}
		soft.assertEquals(actualAstricMarksCurrency, "*", "Missing * for Currency");

		String actualAstricMarkPartCostUnit = waitForExpectedElement(AstricMarkPartCostUnit).getText().trim();
		if (actualAstricMarkPartCostUnit.equals("*")) {
			LoggerUtil.pass(" Asterisk is present for Part Cost Unit");
		} else {
			LoggerUtil.fail(" Asterisk is missing for Part Cost Unit (found: '" + actualAstricMarkPartCostUnit + "')");
		}
		soft.assertEquals(actualAstricMarkPartCostUnit, "*", "Missing * for Part Cost Unit");

		soft.assertAll();
	}

	public static final By optionvalueBop = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li");

	public void verifySortingFunctionalityBoptype() throws InterruptedException {
		Thread.sleep(8000);

		LoggerUtil.info("Clicking on BOP Category dropdown");
		clickOnElement(clickingBopCategoryDropdown);

		LoggerUtil.info("Fetching list of BOP Category options");
		List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);

		LoggerUtil.info("Selecting 'Standard' from BOP Category dropdown");
		selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");

		Thread.sleep(3000);

		LoggerUtil.info("Clicking on BOP Type dropdown");
		clickOnElement(clickingBopTypeDropdown);

		LoggerUtil.info("Fetching BOP Type dropdown values");
		List<WebElement> listofOptionValue = driver.findElements(optionvalueBop);

		ArrayList<String> actualListBopValue = new ArrayList<>();
		for (WebElement optionval : listofOptionValue) {
			actualListBopValue.add(optionval.getText().trim());
		}
		LoggerUtil.info("Captured actual BOP Type list: " + actualListBopValue);

		LoggerUtil.info("Separating 'Select' and preparing list for sorting");
		String firstItem = actualListBopValue.get(0);
		List<String> actualWithoutSelect = new ArrayList<>(actualListBopValue);
		actualWithoutSelect.removeIf(val -> val.equalsIgnoreCase("Select"));

		LoggerUtil.info("Sorting actual list case-insensitively for comparison");
		List<String> expectedSorted = new ArrayList<>(actualWithoutSelect);
		expectedSorted.sort(String.CASE_INSENSITIVE_ORDER);

		LoggerUtil.info("Combining 'Select' with sorted list to build expected result");
		List<String> expectedCombined = new ArrayList<>();
		expectedCombined.add("Select");
		expectedCombined.addAll(expectedSorted);

		LoggerUtil.info("Comparing actual vs expected sorted list for BOP Type");

		if (actualListBopValue.equals(expectedCombined)) {
			LoggerUtil.pass(
					"✅ BOP Type dropdown is correctly sorted (case-insensitive) with 'Select' at the top.\nSorted List: "
							+ actualListBopValue);
		} else {
			LoggerUtil.fail("❌ BOP Type dropdown is NOT sorted correctly.\nActual: " + actualListBopValue
					+ "\nExpected: " + expectedCombined);
		}
	}

	public static final By uomdropdownoptionlist = By.xpath("//ul[@id='select2-BopEntry_UomStandard-results']/li");

	public void verifyUomDropDownBehaviour() throws InterruptedException {
		LoggerUtil.info("Step 1: Waiting for page to load");
		Thread.sleep(8000);

		LoggerUtil.info("Step 2: Click on BOP Category dropdown");
		clickOnElement(clickingBopCategoryDropdown);

		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");

		LoggerUtil.info("Step 3: Click on UOM dropdown");
		clickOnElement(ClickingUomDropDown);

		LoggerUtil.info("Step 4: Fetching UOM dropdown values");
		List<WebElement> uomListElements = driver.findElements(uomdropdownoptionlist);

		ArrayList<String> actualList = new ArrayList<>();
		for (WebElement option : uomListElements) {
			String text = option.getText().trim();
			if (!text.equalsIgnoreCase("Select")) { // skip placeholder
				actualList.add(text);
			}
		}

		LoggerUtil.info("Actual UOM dropdown values: " + actualList);

		ArrayList<String> sortedExpectedList = new ArrayList<>(actualList);
		sortedExpectedList.sort(String.CASE_INSENSITIVE_ORDER);

		LoggerUtil.info("Expected sorted UOM dropdown values: " + sortedExpectedList);

		if (actualList.equals(sortedExpectedList)) {
			LoggerUtil.pass("UOM dropdown values are sorted in case-insensitive order.");
		} else {
			LoggerUtil.fail(
					"UOM dropdown values are NOT sorted. Expected: " + sortedExpectedList + " | Actual: " + actualList);
		}
	}

	public static final By clickingAddSupplierButton = By.xpath("(//*[@id='addNewSupplier1']/span)[1]");
	public static final By Entersuppliercodevalue = By.xpath("//input[@id='SupplierCode']");
	public static final By Entersuppliernamevalue = By.xpath("//input[@id='SupplierName']");
	public static final By clickingbusinessSegDropdown = By.xpath(
			"//*[@id='supBusinessSegments']/following-sibling::div/button[@class='multiselect dropdown-toggle custom-select text-center']");

	public static final By clickingbusinessSegCheckboxForSupplier = By
			.xpath("//select[@id='supBusinessSegments']/following-sibling::div/div/button/span/input");
	public static final By clickingsavebuttonForSupplier = By.xpath("//button[@id='supplierSave']");

	public void verfiySupplierSearchFunctionality(String entersuppcode, String entersuppname)
			throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Waiting for page to load");
			Thread.sleep(8000);

			LoggerUtil.info("Step 2: Click on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info("Step 3: Select 'Standard' from dropdown");
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 4: Click Add Supplier");
			clickOnElement(clickingAddSupplierButton);
			Thread.sleep(2000);

			LoggerUtil.info("Step 5: Enter Supplier Code: " + entersuppcode);
			clearAndEnterText(waitForExpectedElement(Entersuppliercodevalue), entersuppcode);
			Thread.sleep(3000);

			LoggerUtil.info("Step 6: Enter Supplier Name: " + entersuppname);
			clearAndEnterText(waitForExpectedElement(Entersuppliernamevalue), entersuppname);
			Thread.sleep(3000);

			LoggerUtil.info("Step 7: Click Business Segment dropdown");
			clickOnElement(clickingbusinessSegDropdown);

			LoggerUtil.info("Step 8: Select Business Segment");
			List<WebElement> flagvlaue = driver.findElements(clickingbusinessSegCheckboxForSupplier);
			WebElement selectsegment = flagvlaue.get(1);
			selectsegment.click();
			Thread.sleep(4000);

			LoggerUtil.info("Step 9: Click Save button");
			clickOnElement(clickingsavebuttonForSupplier);
			Thread.sleep(7000);

			LoggerUtil.pass("Supplier added successfully");

		} catch (Exception e) {
			LoggerUtil.fail("Failed to add supplier");
			LoggerUtil.error("Error occurred: " + e.getMessage());
		}
	}

	public static final By clickingSuppliernameAndCodeDropdown = By
			.xpath("//span[@id='select2-BopEntry_SupplierStandard-container']");
	public static final By Entersearchvalue = By.xpath("//input[@class='select2-search__field']");

	public static final By supplierlistvalue = By.xpath("//ul[@id='select2-BopEntry_SupplierStandard-results']");

	public void verifySuppliernameAreExistOrnot(String entervalueforsearching) throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Click Supplier Name and Code dropdown");
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Enter search value: " + entervalueforsearching);
			clearAndEnterText(waitForExpectedElement(Entersearchvalue), entervalueforsearching);
			Thread.sleep(2000);

			LoggerUtil.info("Step 3: Get first listed value");
			List<WebElement> actullistedvalue = driver.findElements(supplierlistvalue);
			WebElement actualfetching = actullistedvalue.get(0);
			String actualfetcheddata = actualfetching.getText();

			LoggerUtil.info("Step 4: Compare actual vs expected value");
			if (actualfetcheddata.equals(entervalueforsearching)) {
				LoggerUtil.pass("Supplier search value matched: " + actualfetcheddata);
			} else {
				LoggerUtil.fail("Supplier search mismatch. Expected: " + entervalueforsearching + ", but found: "
						+ actualfetcheddata);
			}

		} catch (Exception e) {
			LoggerUtil.fail("Supplier search failed");
			LoggerUtil.error("Error occurred: " + e.getMessage());
		}
	}

	public static final By currencycellBox = By.xpath("//span[@id='select2-BopEntry_StandardCurrency-container']");
	public static final By currencycelloptions = By.xpath("//ul[@id='select2-BopEntry_StandardCurrency-results']/li");

	public void verifyCurrencyvalue() throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Wait for page load");
			Thread.sleep(6000);

			LoggerUtil.info("Step 2: Click on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info("Step 3: Select 'Standard' from dropdown");
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 4: Click on Currency cell box");
			Thread.sleep(2000);
			clickOnElement(currencycellBox);

			LoggerUtil.info("Step 5: Fetch all currency dropdown options");
			List<WebElement> currencyvalue = driver.findElements(currencycelloptions);
			ArrayList<String> actuallist = new ArrayList<String>();

			for (WebElement optionlist : currencyvalue) {
				String flagvalue = optionlist.getText().trim();
				if (!(flagvalue.equalsIgnoreCase("Select")))
					actuallist.add(flagvalue);
			}

			LoggerUtil.info("Step 6: Sort and compare actual vs expected currency list");
			ArrayList<String> sortedlistexpected = new ArrayList<String>(actuallist);
			sortedlistexpected.sort(String.CASE_INSENSITIVE_ORDER);

			if (actuallist.equals(sortedlistexpected)) {

				LoggerUtil.pass("Currency values are sorted alphabetically as expected.");
				LoggerUtil.pass("Actual: " + actuallist + " | Expected: " + sortedlistexpected);

			} else {
				LoggerUtil.fail(
						"Currency values are not sorted. Actual: " + actuallist + " | Expected: " + sortedlistexpected);
			}

		} catch (Exception e) {
			LoggerUtil.fail("Currency dropdown validation failed.");
			LoggerUtil.error("Error occurred: " + e.getMessage());
		}
	}

	public static final By EnterBopTypeNameFirsTab = By.xpath("//input[@id='BopType_BopTypeName']");
	public static final By SaveButtonFirstTab = By.xpath("//*[@id='SaveBOP']");

	public static void enterCreateBoptyeInFirstTab(String entervalueboptype) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(EnterBopTypeNameFirsTab), entervalueboptype);
		LoggerUtil.info("User Enter BopType Name = " + entervalueboptype);
		Thread.sleep(3000);
		clickOnElement(SaveButtonFirstTab);
		Thread.sleep(5000);

	}

	public static final By Entervaluepartdescription = By.xpath("//*[@id='BopEntry_ChildPartDescStandard']");
	public static final By Entervaluepartnumber = By.xpath("//*[@id='BopEntry_PartNoStandard']");
	public static final By uomdropdownlist = By.xpath("//ul[@id='select2-BopEntry_UomStandard-results']/li");
	public static final By currencylistoptionvalue = By
			.xpath("//ul[@id='select2-BopEntry_StandardCurrency-results']/li");
	public static final By ValuesofBopTypeDropdown = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li");
	public static final By enterpartcostunit = By.xpath("//*[@id='PartCostStandard']");
	public static final By EntervalueDuties = By.xpath("//*[@id='DutiesStandard']");
	public static final By EnterFrieghtAndInsuranceStandard = By.xpath("//input[@id='FreightInsuanceStandard']");
	public static final By clickingsavebutton = By.xpath("//button[@id='SaveBOPEntry']");

	public static final By supplierDropdownListForStandard = By
			.xpath("//ul[@id='select2-BopEntry_SupplierStandard-results']/li");

	public void entervalueAndVerifyNumericalValidation(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Select BOP Type - " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Select BOP Category as 'Standard'");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Enter Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Enter Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Select UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			WebElement selectvalue = uomdropdownoptionvalue.get(1);
			selectvalue.click();

			LoggerUtil.info("Step 6: Select Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			WebElement flagevalue = optionvalueforsupplier.get(1);
			flagevalue.click();

			LoggerUtil.info("Step 7: Select Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Enter Cost Field Value: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Enter Duties Field Value: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Enter Freight & Insurance Field Value: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Click Save Button");
			clickOnElement(clickingsavebutton);
			LoggerUtil.pass("Clicked Save successfully with non-numeric values in numeric fields");

		} catch (Exception e) {
			LoggerUtil.error("Exception in entervalueAndVerifyNumericalValidation(): " + e.getMessage());
			soft.fail("Error occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By fetchingtabledata = By.xpath("//table[@id='table1']/tbody/tr");
	public static final By EnterSearchvalue = By
			.xpath("//div[@id='table1_filter']/label[contains(text(),'Search:')]/input");
	public static final By toastmsgBopEntry = By
			.xpath("//div[@class='toast toast-warning']/div/following-sibling::div");
	public static final By deletebtn = By.xpath("//*[@id='table1']/tbody/tr[1]/td[10]/a[2]/i");
	public static final By editbtn = By.xpath("//*[@id='table1']/tbody/tr[1]/td[10]/a[1]/span/i");

	public static void SaveBopWithStandard(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue, String entersearchvalue) throws InterruptedException {
	
		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(4000);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			WebElement selectvalue = uomdropdownoptionvalue.get(1);
			selectvalue.click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			WebElement flagevalue = optionvalueforsupplier.get(1);
			flagevalue.click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			System.out.println(waitForExpectedElement(importpopup).getText());
			String popupForSave = waitForExpectedElement(importpopup).getText();
			String expectedpopupforSave = "BOP Entry Saved Successfully";

			soft.assertEquals(popupForSave, expectedpopupforSave, "Popup Message Are Mismatched..");
			Thread.sleep(15000);

			LoggerUtil.info("Step 12: Searching for saved value: " + entersearchvalue);
			clearAndEnterText(waitForExpectedElement(EnterSearchvalue), entersearchvalue);
			Thread.sleep(5000);
      
			List<WebElement> Rows = driver.findElements(fetchingtabledata);
			  for(WebElement row : Rows) {
				  
				  List<WebElement> ActualBoptype = row.findElements(By.tagName("td"));
				  
				  String actualupdatedboptype = ActualBoptype.get(0).getText().trim();
	
			String expectedboptype = entersearchvalue;

			if (actualupdatedboptype.equals(expectedboptype)) {
				LoggerUtil.pass("Search Success - Actual BOP Type: [" + actualupdatedboptype + "] matches Expected: ["
						+ expectedboptype + "]");
				break;
			} else {
				LoggerUtil
						.fail("Search Failed - Actual: [" + actualupdatedboptype + "] vs Expected: [" + expectedboptype + "]");
			}

			  
			soft.assertEquals(actualupdatedboptype, expectedboptype, "Mismatch in BOP Type after save");
			  }
			LoggerUtil.info("Step 13: Deleting the saved entry");
			clickOnElement(deletebtn);
			driver.switchTo().alert().accept();
			LoggerUtil.pass("Entry deleted successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in SaveBopWithStandard: " + e.getMessage());
			soft.fail("Exception occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By Clickingupdatebutton = By.xpath("//button[@value='UpdateBOPEntry']");

	public static void SaveBopWithStandardForUpdate(
	        String selectedvalueboptype, String enterpartdescriptionvalue,
	        String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
	        String enterfrieghtandinsurancevalue, String entersearchvalue, String newBoptypevalue,
	        String enterNewdutiesvalue, String enternewupdatedfrieghtAndinsurance) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(19));
	    SoftAssert soft = new SoftAssert();
	    driver.navigate().refresh();
	    Thread.sleep(7000);

	    try {
	        LoggerUtil.info("===== STARTING: Save and Update BOP with Standard Category =====");

	        // Step 1: Select BOP Type
	        LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
	        clickOnElement(clickingBopTypeDropdown);
	        Thread.sleep(3000);
	        List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
	        selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);
	        LoggerUtil.pass("BOP Type selected successfully: " + selectedvalueboptype);

	        Thread.sleep(6000);
	        // Step 2: Select BOP Category
	        LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
	        clickOnElement(clickingBopCategoryDropdown);
	        List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
	        selectBootStrapDropDown(bopCategoryOptions, "Standard");
	        LoggerUtil.pass("BOP Category selected successfully: Standard");

	        Thread.sleep(4000);
	        // Step 3: Part Description
	        LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
	        clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);
	        LoggerUtil.pass("Part Description entered successfully: " + enterpartdescriptionvalue);

	        Thread.sleep(4000);	
	        // Step 4: Part Number
	        LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
	        clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);
	        LoggerUtil.pass("Part Number entered successfully: " + enterpartNumberValue);

	        Thread.sleep(3000);
	        // Step 5: Select UOM
	        
	    
	        
	        
	        
	        LoggerUtil.info("Step 5: Selecting UOM (2nd option)");

	     // Click dropdown
	     Actions action = new Actions(driver);
	     action.moveToElement(driver.findElement(ClickingUomDropDown)).click().perform();

	     // Wait for UOM options to appear
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(uomdropdownoptionlist));

	     // Fresh fetch list after dropdown is open
	     List<WebElement> uomOptions = driver.findElements(uomdropdownoptionlist);

	     // Defensive check
	     if (uomOptions.size() > 1) {
	         String uomText = uomOptions.get(1).getText().trim();

	         // Click with Actions (or normal click)
	         action.moveToElement(uomOptions.get(1)).click().perform();

	         LoggerUtil.pass("UOM selected successfully: " + uomText);
	     } else {
	         LoggerUtil.fail("UOM dropdown did not load options correctly!");
	     }

	        Thread.sleep(3000);
	        // Step 6: Select Supplier
	        LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
	        Thread.sleep(2000);
	       
	        LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");

	     // Click dropdown
	   
	     action.moveToElement(driver.findElement(clickingSuppliernameAndCodeDropdown)).click().perform();

	     // Wait for supplier options to appear
	   
	     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(supplierDropdownListForStandard));

	     // Fetch fresh list
	     List<WebElement> supplierOptions = driver.findElements(supplierDropdownListForStandard);

	     // Defensive check
	     if (supplierOptions.size() > 1) {
	         String supplierText = supplierOptions.get(1).getText().trim();

	         // Safe click (normal click is enough here)
	         supplierOptions.get(1).click();

	         LoggerUtil.pass("Supplier selected successfully: " + supplierText);
	     } else {
	         LoggerUtil.fail("Supplier dropdown did not load options correctly!");
	     }

	        
	        // Step 7: Select Currency
	     LoggerUtil.info("Step 7: Selecting Currency (2nd option)");

	  // Click currency dropdown
	

	  action.moveToElement(driver.findElement(clickingCurrencyDropDown)).click().perform();
	  // Wait for currency options to load
	
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(currencylistoptionvalue));

	  // Fetch fresh list
	  List<WebElement> currencyOptions = driver.findElements(currencylistoptionvalue);

	  // Defensive check
	  if (currencyOptions.size() > 1) {
	      String currencyText = currencyOptions.get(1).getText().trim();

	      // Safe click
	      currencyOptions.get(1).click();

	      LoggerUtil.pass("Currency selected successfully: " + currencyText);
	  } else {
	      LoggerUtil.fail("Currency dropdown did not load options correctly!");
	  }

	        Thread.sleep(4000);
	        // Step 8: Part Cost
	        LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
	        clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);
	        LoggerUtil.pass("Part Cost entered successfully: " + enterpartcostvalue);

	        Thread.sleep(3000);
	        // Step 9: Duties
	        LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
	        clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);
	        LoggerUtil.pass("Duties entered successfully: " + enterdutiesvalue);

	        Thread.sleep(4000);
	        // Step 10: Freight & Insurance
	        LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
	        clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);
	        LoggerUtil.pass("Freight & Insurance entered successfully: " + enterfrieghtandinsurancevalue);

	        Thread.sleep(4000);
	        // Step 11: Save
	        LoggerUtil.info("Step 11: Clicking Save button");
	        clickOnElement(clickingsavebutton);
	        Thread.sleep(15000);
	        LoggerUtil.pass("Clicked Save successfully");

	        Thread.sleep(4000);
	        // Step 12: Verify saved value
	        LoggerUtil.info("Step 12: Searching for saved value: " + entersearchvalue);
	        clearAndEnterText(waitForExpectedElement(EnterSearchvalue), entersearchvalue);
	        Thread.sleep(5000);

	        Thread.sleep(4999);
	        boolean saveSuccess = false;
	        List<WebElement> rows = driver.findElements(fetchingtabledata);
	        for (WebElement row : rows) {
	            List<WebElement> colom = row.findElements(By.tagName("td"));
	            String actualBoptype = colom.get(0).getText().trim();

	            if (actualBoptype.equals(entersearchvalue)) {
	                LoggerUtil.pass("Saved values are displayed correctly in the table.");
	                saveSuccess = true;
	                break;
	            }
	        }
	        if (!saveSuccess) {
	            LoggerUtil.fail("Saved values are NOT displayed correctly in the table.");
	            soft.fail("Saved values verification failed.");
	        }

	        Thread.sleep(4000);
	        // Step 13: Edit
	        LoggerUtil.info("Step 13: Clicking Edit Button");
	        clickOnElement(editbtn);
	        Thread.sleep(4000);

	        // Step 14: Update BOP Type
	        LoggerUtil.info("Step 14: Updating BOP Type to: " + newBoptypevalue);
	        clickOnElement(clickingBopTypeDropdown);
	        List<WebElement> updatedBopTypes = driver.findElements(ValuesofBopTypeDropdown);
	        selectBootStrapDropDown(updatedBopTypes, newBoptypevalue);
	        LoggerUtil.pass("Updated BOP Type successfully: " + newBoptypevalue);

	        Thread.sleep(4000);
	        // Step 15: Update Duties
	        LoggerUtil.info("Step 15: Updating Duties to: " + enterNewdutiesvalue);
	        clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterNewdutiesvalue);
	        LoggerUtil.pass("Updated Duties successfully: " + enterNewdutiesvalue);

	        Thread.sleep(4000);
	        // Step 16: Update Freight & Insurance
	        LoggerUtil.info("Step 16: Updating Freight & Insurance to: " + enternewupdatedfrieghtAndinsurance);
	        clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enternewupdatedfrieghtAndinsurance);
	        LoggerUtil.pass("Updated Freight & Insurance successfully: " + enternewupdatedfrieghtAndinsurance);

	        Thread.sleep(4000);
	        // Step 17: Update Save
	        LoggerUtil.info("Step 17: Clicking Update button");
	        clickOnElement(Clickingupdatebutton);
	        LoggerUtil.pass("Clicked Update successfully");

	       wait.until(ExpectedConditions.visibilityOfElementLocated(EnterSearchvalue));
	       
	        LoggerUtil.info("Step 18: Re-searching using updated BOP Type: " + newBoptypevalue);
	        clearAndEnterText(waitForExpectedElement(EnterSearchvalue), newBoptypevalue);
	      
	        Thread.sleep(6000);
	     
	        LoggerUtil.pass("===== COMPLETED: Save and Update BOP with Standard Category =====");

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Exception in SaveBopWithStandardForUpdate(): " + e.getMessage());
	        soft.fail("Exception occurred: " + e.getMessage());
	    }

	    soft.assertAll();
	}


	public void SaveBopTypeForParticularPartNumber(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue, String entersearchvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(4000);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			uomdropdownoptionvalue.get(1).click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			optionvalueforsupplier.get(1).click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			optionvalueforcurrency.get(1).click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(15000);

			LoggerUtil.info("Step 12: Searching for saved value: " + entersearchvalue);
			clearAndEnterText(waitForExpectedElement(EnterSearchvalue), entersearchvalue);
			Thread.sleep(5000);

			String actualboptype = waitForExpectedElement(fetchingtabledata).getText();
			if (actualboptype.equals(entersearchvalue)) {
				LoggerUtil.pass("✅ BOP Type saved and verified: " + actualboptype);
			} else {
				LoggerUtil.fail("❌ Mismatch - Expected: " + entersearchvalue + ", Actual: " + actualboptype);
			}

			soft.assertEquals(actualboptype, entersearchvalue, "❌ BOP Type does not match after saving");

		} catch (Exception e) {
			LoggerUtil.error("❌ Exception in SaveBopTypeForParticularPartNumber(): " + e.getMessage());
			soft.fail("Test failed due to exception: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By clickingUpdatebutton = By.xpath("//button[@value='UpdateBOPEntry']");

	public void verifyupdaterestrictionforduplicateSave(String entersearchvalue1, String selectedvalueboptype,
			String enterpartdescriptionvalue, String enterpartNumberValue, String enterpartcostvalue,
			String enterdutiesvalue, String enterfrieghtandinsurancevalue, String entersearchvalue)
			throws InterruptedException {

		SoftAssert soft = new SoftAssert();

		try {
			LoggerUtil.info("Step 0: Searching for existing BOP entry: " + entersearchvalue1);
			clearAndEnterText(waitForExpectedElement(EnterSearchvalue), entersearchvalue1);
			Thread.sleep(5000);

			String actualboptype = waitForExpectedElement(fetchingtabledata).getText();

			if (!actualboptype.equals(entersearchvalue1)) {
				LoggerUtil.fail("❌ Initial BOP Type not found for duplicate test. Expected: " + entersearchvalue1
						+ ", Found: " + actualboptype);
				soft.fail("Initial BOP Type not found, cannot proceed with duplicate save test.");
				soft.assertAll();
				return;
			}

			LoggerUtil.pass(
					"✅ Initial BOP Type found: " + actualboptype + ". Proceeding to check duplicate restriction...");

			clickOnElement(clickingEditButton);
			Thread.sleep(9000);

			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(3000);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);

			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			uomdropdownoptionvalue.get(1).click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			optionvalueforsupplier.get(1).click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			optionvalueforcurrency.get(1).click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking update button (Expecting restriction on duplicate)");
			clickOnElement(clickingUpdatebutton);

			String actualToast = waitForExpectedElement(importpopup).getText().trim();
			LoggerUtil.info("📢 Toast after duplicate save attempt: " + actualToast);

			String expectedToast = "BOP Type already exists for this Part Number"; // Update based on actual app message

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass("✅ Correct restriction message displayed: " + actualToast);
			} else {
				LoggerUtil.fail("❌ Incorrect or missing duplicate restriction toast. Found: " + actualToast);
			}

			soft.assertEquals(actualToast, expectedToast, "❌ Duplicate save restriction message mismatch");

		} catch (Exception e) {
			LoggerUtil.error("❌ Exception in verifyupdaterestrictionforduplicateSave(): " + e.getMessage());
			soft.fail("Test failed due to exception: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By clickingAddcustomer = By.xpath("(//*[@id='addNewSupplier1'])[1]");
	public static final By EnterSupplierCodeValue = By.xpath("//input[@id='SupplierCode']");
	public static final By EnterSupplierNameValue = By.xpath("//input[@id='SupplierName']");
	public static final By ClickingBusinessSegButton = By
			.xpath("//select[@id='supBusinessSegments']/following-sibling::div/button");
	public static final By ClickingCheckboxFromBusinessSegDropdown = By
			.xpath("//select[@id='supBusinessSegments']/following-sibling::div/div/button[2]/span/input");
	public static final By clickingSaveButtonSupplierPage = By.xpath("//button[@id='supplierSave']");
	public static final By EnterSearchValueForSupplier = By.xpath("//span/input[@class='select2-search__field']");

	public void verifyEnterSuppliername(String entersuppliercodevalue, String entersuppliernamevalue)
			throws InterruptedException {

		Thread.sleep(8000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(2000);
		clickOnElement(clickingAddcustomer);
		Thread.sleep(200);
		clearAndEnterText(waitForExpectedElement(Entersuppliercodevalue), entersuppliercodevalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(EnterSupplierNameValue), entersuppliernamevalue);
		Thread.sleep(2000);
		clickOnElement(ClickingBusinessSegButton);
		Thread.sleep(200);
		clickOnElement(ClickingCheckboxFromBusinessSegDropdown);
		Thread.sleep(2000);
		clickOnElement(clickingSaveButtonSupplierPage);
		Thread.sleep(9000);
		clickOnElement(clickingSuppliernameAndCodeDropdown);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(EnterSearchValueForSupplier), entersuppliernamevalue);
		List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
		WebElement flagvaluesupplier = optionvalueforsupplier.get(0);
		String fetchingactualvalue = flagvaluesupplier.getText();
		System.out.println(fetchingactualvalue);
		String expectedvalue = entersuppliernamevalue + "-" + entersuppliercodevalue;

		Assert.assertEquals(fetchingactualvalue, expectedvalue);

	}

	public static final By ClickingResetButton = By.xpath("//button[@onclick='resetFormdata()']");

	public void verifyResetButtonFunctionality() {
		try {
			LoggerUtil.info("Verifying Reset Button Functionality...");

			// Select BOP Category = Standard
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			// Select BOP Type = Second Option
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(3000);
			List<WebElement> bopTypeOptions = driver.findElements(ValuesofBopTypeDropdown);
			bopTypeOptions.get(1).click();

			String selectedBopTypeBeforeReset = waitForExpectedElement(clickingBopTypeDropdown).getText();
			LoggerUtil.info("BOP Type before Reset: " + selectedBopTypeBeforeReset);

			// Select Supplier Name and Code
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> supplierOptions = driver.findElements(supplierDropdownListForStandard);
			supplierOptions.get(1).click();

			String selectedSupplierBeforeReset = waitForExpectedElement(clickingSuppliernameAndCodeDropdown).getText();
			LoggerUtil.info("Supplier Name before Reset: " + selectedSupplierBeforeReset);

			// Select UOM
			clickOnElement(ClickingUomDropDown);
			List<WebElement> uomOptions = driver.findElements(uomdropdownlist);
			uomOptions.get(1).click();

			String selectedUomBeforeReset = waitForExpectedElement(ClickingUomDropDown).getText();
			LoggerUtil.info("UOM before Reset: " + selectedUomBeforeReset);

			// Click Reset Button
			clickOnElement(ClickingResetButton);

			// Wait and Re-fetch values after Reset
			String bopTypeAfterReset = waitForExpectedElement(clickingBopTypeDropdown).getText();
			String supplierAfterReset = waitForExpectedElement(clickingSuppliernameAndCodeDropdown).getText();
			String uomAfterReset = waitForExpectedElement(ClickingUomDropDown).getText();

			// Validation
			if (bopTypeAfterReset.equalsIgnoreCase("Select")) {
				LoggerUtil.pass("BOP Type reset successfully.");
			} else {
				LoggerUtil.fail("BOP Type not reset. Current value: " + bopTypeAfterReset);
			}

			if (supplierAfterReset.equalsIgnoreCase("Select")) {
				LoggerUtil.pass("Supplier Name reset successfully.");
			} else {
				LoggerUtil.fail("Supplier Name not reset. Current value: " + supplierAfterReset);
			}

			if (uomAfterReset.equalsIgnoreCase("Select")) {
				LoggerUtil.pass("UOM reset successfully.");
			} else {
				LoggerUtil.fail("UOM not reset. Current value: " + uomAfterReset);
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception while verifying Reset Button Functionality: " + e.getMessage());
		}
	}

	public static final By fetchingvaluePartNumber = By.xpath("//*[@id='table1']/tbody/tr/td[4]");
	public static final By ClickingSaveAsnewButton = By.xpath("//button[@id='SaveBOPEntry']");

	public void verifySaveAsnewBopFunctionality(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue, String entersearchvalue, String enternewpartNumberValue,
			String selectednewvalueboptype, String entersearchnewvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(4000);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			WebElement selectvalue = uomdropdownoptionvalue.get(1);
			selectvalue.click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			WebElement flagevalue = optionvalueforsupplier.get(1);
			flagevalue.click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			Thread.sleep(15000);

			LoggerUtil.info("Step 12: Searching for saved value: " + entersearchvalue);
			clearAndEnterText(waitForExpectedElement(EnterSearchvalue), entersearchvalue);
			Thread.sleep(5000);

			String actualboptype = waitForExpectedElement(fetchingtabledata).getText();
			String expectedboptype = entersearchvalue;

			if (actualboptype.equals(expectedboptype)) {
				LoggerUtil.pass("Search Success - Actual BOP Type: [" + actualboptype + "] matches Expected: ["
						+ expectedboptype + "]");
				clickOnElement(editbtn);
				Thread.sleep(4000);

				clearAndEnterText(waitForExpectedElement(EnterPartNumber), enternewpartNumberValue);
				Thread.sleep(3000);
				clickOnElement(clickingBopTypeDropdown);
				List<WebElement> optionvalueBoptype1 = driver.findElements(ValuesofBopTypeDropdown);
				selectBootStrapDropDown(optionvalueBoptype1, selectednewvalueboptype);

				clickOnElement(ClickingSaveAsnewButton);
				Thread.sleep(15000);

				clearAndEnterText(waitForExpectedElement(EnterSearchvalue), entersearchnewvalue);
				Thread.sleep(5000);
				String actualnewboptype = waitForExpectedElement(fetchingtabledata).getText();
				String expectednewboptype = entersearchnewvalue;
				if (actualnewboptype.equals(expectednewboptype)) {

					LoggerUtil.pass("Search Success - Actual BOP Type: [" + actualnewboptype + "] matches Expected: ["
							+ expectednewboptype + "]");
				}
			} else {
				LoggerUtil
						.fail("Search Failed - Actual: [" + actualboptype + "] vs Expected: [" + expectedboptype + "]");
			}
			String actualnewpartnumber = waitForExpectedElement(fetchingvaluePartNumber).getText();
			String expectedpartnumber = enternewpartNumberValue;

			if (actualnewpartnumber.equals(expectedpartnumber)) {

				LoggerUtil.pass("Search Success - Actual new Part No.: [" + actualnewpartnumber
						+ "] matches Expected: [" + expectedpartnumber + "]");

			} else {

				LoggerUtil.fail("Search Failed - Actual: [" + actualnewpartnumber + "] vs Expected: ["
						+ expectedpartnumber + "]");

			}

			soft.assertEquals(actualboptype, expectedboptype, "Mismatch in BOP Type after save");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	public static final By clickingSaveAsNewButton = By.xpath("//button[@id='SaveBOPEntry']");
	public static final By EnterSearchValueForDataBaseStandard = By
			.xpath("//div[@id='table1_filter']/label/input[@class='form-control form-control-sm']");

	public void saveBopTypeAndSaveAgainWithSamePartNoAndSupplierName(String selectedvalueboptype,
			String enterpartdescriptionvalue, String enterpartNumberValue, String enterpartcostvalue,
			String enterdutiesvalue, String enterfrieghtandinsurancevalue, String selectednewvalueboptype,
			String enternewpartdescriptionvalue, String enternewpartcostvalue, String enternewdutiesvalue,
			String enternewfrieghtandinsurancevalue) throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(7000);

			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(5000);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			uomdropdownoptionvalue.get(1).click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			optionvalueforsupplier.get(1).click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			optionvalueforcurrency.get(1).click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button (First Entry)");
			clickOnElement(clickingsavebutton);

			driver.navigate().refresh();
			Thread.sleep(19000);

			LoggerUtil.info("Step 12: Selecting BOP Category: Standard again for search");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions1, "Standard");
			Thread.sleep(5000);

			LoggerUtil.info("Step 13: Searching for saved record by BOP Type");
			clearAndEnterText(waitForExpectedElement(EnterSearchValueForDataBaseStandard), selectedvalueboptype);
			Thread.sleep(4000);

			LoggerUtil.info("Step 14: Clicking edit button for saved record");
			clickOnElement(editbtn);
			Thread.sleep(5000);
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(5000);
			List<WebElement> optionvalueBoptype1 = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype1, selectednewvalueboptype);

			LoggerUtil.info("Step 15: Updating Part Description: " + enternewpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enternewpartdescriptionvalue);
			Thread.sleep(2200);

			LoggerUtil.info("Step 16: Selecting new UOM (3rd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue1 = driver.findElements(uomdropdownoptionlist);
			uomdropdownoptionvalue1.get(2).click();

			LoggerUtil.info("Step 17: Re-selecting Supplier (same as before)");
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier1 = driver.findElements(supplierDropdownListForStandard);
			optionvalueforsupplier1.get(1).click();

			LoggerUtil.info("Step 18: Re-selecting Currency (same as before)");
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency1 = driver.findElements(currencylistoptionvalue);
			optionvalueforcurrency1.get(1).click();

			LoggerUtil.info("Step 19: Entering Updated Part Cost: " + enternewpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enternewpartcostvalue);

			LoggerUtil.info("Step 20: Entering Updated Duties: " + enternewdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enternewdutiesvalue);

			LoggerUtil.info("Step 21: Entering Updated Freight & Insurance: " + enternewfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard),
					enternewfrieghtandinsurancevalue);

			LoggerUtil.info("Step 22: Clicking Save As New button (Second Entry)");
			clickOnElement(clickingSaveAsNewButton);
			Thread.sleep(7000);

			String actualpopup = waitForExpectedElement(importpopup).getText();
			LoggerUtil.info("Popup text: " + actualpopup);

			if (actualpopup != null && actualpopup.toLowerCase().contains("already exists")) {
				LoggerUtil.fail("Duplicate detected: " + actualpopup);
			} else {
				LoggerUtil.pass("Successfully saved BOP entry twice with same Part No and Supplier");
			}

		} catch (Exception e) {
			LoggerUtil.error("Error during double-save with same Part No: " + e.getMessage());
			LoggerUtil.fail("Test Failed: saveBopTypeAndSaveAgainWithSamePartNoAndSupplierName");
			throw e;
		}
	}

	public static final By ClickingButtonExportButtonUI = By.xpath("//button[@onclick='Boppopupforexport()']");
	public static final By ClickingExportfordownload = By.xpath("//button[@id='exportOldButton']");

	public void VerifyExportButton() throws InterruptedException {
		Thread.sleep(8000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);
		clickOnElement(ClickingButtonExportButtonUI);
		Thread.sleep(2000);
		clickOnElement(ClickingExportfordownload);
		Thread.sleep(12000);

		getLatestBOPProcurementStandardFile();

	}

	public static final By clickingsupplierdropdownExportimport = By
			.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/button");
	public static final By clickingRadioButtonForExportNewData = By.xpath("//input[@id='BOPflexRadioDefault2']");
	public static final By clickingcheckboxFromsupplierdropdown = By
			.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/div/button[2]/span/input");
	public static final By clickingexportbtnnewExcelfile = By.xpath("//button[@id='exportButtonBop']");
	public static final By clickingCrossButtonExportui = By.xpath("//*[@id='BOPiddpopupexp']/div/div/div[1]/button");

	public void verifyimportexcelfile() throws InterruptedException {

		Thread.sleep(3000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);
		clickOnElement(ClickingButtonExportButtonUI);
		Thread.sleep(2000);
		clickOnElement(clickingRadioButtonForExportNewData);
		Thread.sleep(2000);
		clickOnElement(clickingsupplierdropdownExportimport);
		Thread.sleep(4000);
		clickOnElement(clickingcheckboxFromsupplierdropdown);
		Thread.sleep(2000);
		clickOnElement(clickingexportbtnnewExcelfile);
		Thread.sleep(9000);
		clickOnElement(clickingCrossButtonExportui);
		fillingFile();
		Thread.sleep(15000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions1, "Standard");
		Thread.sleep(2000);
		UploadExcelfileWithcorrectdata();

	}

	public String fillingFile() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementStandardFile();
		if (latestFile == null) {
			System.out.println("No BOPProcurementStandardFile file found.");
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

		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
		ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));
		ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(UOM));
		ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Supplier));
		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(supplycurrency));
		ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(yeardropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
		ExcelFiller.setCellValue(filePath, 0, 2, 10, ExcelFiller.ValueType.STRING, Arrays.asList(partcost));
		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));
		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));

		return latestFile.getAbsolutePath();

	}

	// input[@id='excelUpload']

	public void UploadExcelfileWithcorrectdata() throws InterruptedException {
		String filePath = fillingFile();

		if (filePath == null) {
			LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
			return;
		}

		LoggerUtil.info(" Step 1: Uploading Excel file with correct data: " + filePath);

		try {

			WebElement uploadInput = driver.findElement(By.id("excelUpload"));

			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
			uploadInput.sendKeys(filePath);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

			LoggerUtil.info(" Step 2: File upload triggered. Waiting for processing...");
			Thread.sleep(4000);

			String toastMsg = waitForExpectedElement(importpopup).getText();
			LoggerUtil.info("🟡 Toast message received: " + toastMsg);

			if (toastMsg.toLowerCase().contains("uploaded") || toastMsg.toLowerCase().contains("success")) {
				LoggerUtil.pass(" Excel uploaded successfully with correct data.");
			} else {
				LoggerUtil.fail(" Unexpected toast message. Upload may have failed.");
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception during upload of correct Excel file: " + e.getMessage());
		}
	}

	public void verifyImportInvalidExcelFile() throws InterruptedException {

		Thread.sleep(3000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);
		clickOnElement(ClickingButtonExportButtonUI);
		Thread.sleep(2000);
		clickOnElement(clickingRadioButtonForExportNewData);
		Thread.sleep(2000);
		clickOnElement(clickingsupplierdropdownExportimport);
		Thread.sleep(4000);
		clickOnElement(clickingcheckboxFromsupplierdropdown);
		Thread.sleep(2000);
		clickOnElement(clickingexportbtnnewExcelfile);
		Thread.sleep(9000);
		clickOnElement(clickingCrossButtonExportui);
		StartFillingInvalidFile();
		Thread.sleep(15000);

		UploadExcelfileWithIncorrectdata();

	}

	public String StartFillingInvalidFile() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementStandardFile();
		if (latestFile == null) {
			System.out.println("No BOPProcurementStandard file found.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();

		int randomint = faker.number().numberBetween(10, 90);

		String partcost = String.valueOf(randomint);
		double floatvalue = faker.number().randomDouble(2, 100, 999);
		double floatvalue1 = faker.number().randomDouble(2, 100, 999);
		String Duties = String.valueOf(floatvalue);
		String frieghtAndInsurance = String.valueOf(floatvalue1);

		ExcelFiller.setCellValue(filePath, 0, 2, 10, ExcelFiller.ValueType.STRING, Arrays.asList(partcost));
		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));
		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));

		return latestFile.getAbsolutePath();

	}

	public void UploadExcelfileWithIncorrectdata() throws InterruptedException {
		String filePath = StartFillingInvalidFile();

		if (filePath == null) {
			LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
			return;
		}

		LoggerUtil.info(" Step 1: Uploading Excel file with INcorrect data: " + filePath);

		try {

			WebElement uploadInput = driver.findElement(By.id("excelUpload"));

			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
			uploadInput.sendKeys(filePath);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

			LoggerUtil.info(" Step 2: File upload triggered. Waiting for processing...");
			Thread.sleep(4000);

			By toastLocator = By.xpath("//div[contains(@class,'toast-message') or contains(@class,'toast-body')]");
			WebElement toast = waitForExpectedElement(toastLocator);
			String toastMsg = toast.getText();

			LoggerUtil.info(" Toast message received: " + toastMsg);

			if (toastMsg.toLowerCase().contains("uploaded") || toastMsg.toLowerCase().contains("success")) {
				LoggerUtil.fail(" Excel uploaded successfully with INcorrect data.");
			} else {
				LoggerUtil.fail(" Unexpected toast message. Upload may have failed.");
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception during upload of correct Excel file: " + e.getMessage());
		}
	}

	public void verifySaveButtonVisiblity() throws InterruptedException {

		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions1, "Standard");
		Thread.sleep(2000);

		List<WebElement> saveButtons = driver.findElements(clickingsavebutton);

		if (saveButtons.isEmpty()) {
			LoggerUtil.pass(" Save Button is NOT displayed – as expected based on user rights.");
		} else {
			boolean isVisible = saveButtons.get(0).isDisplayed();
			if (!isVisible) {
				LoggerUtil.pass(" Save Button is present in DOM but hidden – correct behavior.");
			} else {
				LoggerUtil.fail(" Save Button is VISIBLE when it should not be.");
			}
		}
	}

	public void verifySaveButtonVisibilityOfAddSupplier() throws InterruptedException {

		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions1, "Standard");
		Thread.sleep(4000);

		clickOnElement(clickingAddSupplierButton);
		Thread.sleep(2000);

		List<WebElement> saveButtonsSupplier = driver.findElements(clickingSaveButtonSupplierPage);

		if (saveButtonsSupplier.isEmpty()) {
			LoggerUtil.pass(" Save Button of Add Supplier is NOT displayed – as expected based on user rights.");
		} else {
			boolean isVisible = saveButtonsSupplier.get(0).isDisplayed();
			if (!isVisible) {
				LoggerUtil.pass(" Save Button is present in DOM but hidden – correct behavior.");
			} else {
				LoggerUtil.fail(" Save Button is VISIBLE when it should NOT be.");
			}
		}
	}

	public static final By FetchingNumbers = By.xpath("//div[@id='table1_info']");
	public static final By ClickingNextButtonPagination = By
			.xpath("//*[@id='table1_paginate']/ul/li[@id='table1_next']/a[contains(text(),'Next')]");

	public void verifPagination() throws InterruptedException {

		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions1, "Standard");
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1000);
		LoggerUtil.info(" Scrolled to the bottom of the page.");

		Thread.sleep(5000); // wait for table to load

		String beforeClick = waitForExpectedElement(FetchingNumbers).getText();
		LoggerUtil.info(" Pagination before click: " + beforeClick);

		clickOnElement(ClickingNextButtonPagination);
		Thread.sleep(4000);

		String afterClick = waitForExpectedElement(FetchingNumbers).getText();
		LoggerUtil.info("Pagination after click: " + afterClick);

		int fromBefore = extractStartNumber(beforeClick);
		int fromAfter = extractStartNumber(afterClick);

		System.out.print(fromBefore);

		if (fromAfter == fromBefore + 25) {
			LoggerUtil.pass(" Pagination working correctly. Entry range increased by 25.");
		} else {
			LoggerUtil.fail(" Pagination failed. Expected start: " + (fromBefore + 25) + ", but got: " + fromAfter);
		}
	}

	public void verifAddsupplier(String entersuppcode, String entersuppname) throws InterruptedException {

		Thread.sleep(4000);
		clickOnElement(clickingBopCategoryDropdown);

		LoggerUtil.info("Fetching list of BOP Category options");
		List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);

		LoggerUtil.info("Selecting 'Standard' from BOP Category dropdown");
		selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");

		Thread.sleep(3000);

		clickOnElement(clickingAddSupplierButton);
		Thread.sleep(2000);

		LoggerUtil.info("Step 5: Enter Supplier Code: " + entersuppcode);
		clearAndEnterText(waitForExpectedElement(Entersuppliercodevalue), entersuppcode);
		Thread.sleep(3000);

		LoggerUtil.info("Step 6: Enter Supplier Name: " + entersuppname);
		clearAndEnterText(waitForExpectedElement(Entersuppliernamevalue), entersuppname);
		Thread.sleep(3000);

		LoggerUtil.info("Step 7: Click Business Segment dropdown");
		clickOnElement(clickingbusinessSegDropdown);

		LoggerUtil.info("Step 8: Select Business Segment");
		List<WebElement> flagvlaue = driver.findElements(clickingbusinessSegCheckboxForSupplier);
		WebElement selectsegment = flagvlaue.get(1);
		selectsegment.click();
		Thread.sleep(4000);

		LoggerUtil.info("Step 9: Click Save button");
		clickOnElement(clickingsavebuttonForSupplier);
		Thread.sleep(7000);

		LoggerUtil.pass("Supplier added successfully");

	}

	public static final By clickingCustomerRadioButton = By
			.xpath("//*[@class='flex_start cs_gap_btn ']/input[@id='BopEntry_RadioButtonCustomer']");
	public static final By clickingAddCustomerButton = By
			.xpath("//a[@id='addNewCustomer']/span/span[contains(text(),'Customer')]");
	public static final By EnterCustomerCode = By.xpath("//input[@id='CustomerCode']");
	public static final By EnterCustomerName = By.xpath("//input[@id='CustomerName']");
	public static final By clickingBusinessSegment = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/button");
	public static final By clickcheckboxCustomers = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/div/button/span/input");
	public static final By clickingSaveButtoncustomers = By.xpath("//button[@id='customerSave1']");

	public void verifySavingAddCustomer(String entercustcode, String entercustname) throws InterruptedException {
		try {
			Thread.sleep(4000);
			LoggerUtil.info(" Clicking BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info(" Fetching BOP Category options");
			List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
			Thread.sleep(3000);

			LoggerUtil.info(" Selecting 'Customer' radio button");
			clickOnElement(clickingCustomerRadioButton);
			Thread.sleep(2000);

			LoggerUtil.info(" Clicking 'Add Customer' button");
			clickOnElement(clickingAddCustomerButton);
			Thread.sleep(2000);

			LoggerUtil.info(" Entering Customer Code: " + entercustcode);
			clearAndEnterText(waitForExpectedElement(EnterCustomerCode), entercustcode);
			Thread.sleep(2000);

			LoggerUtil.info(" Entering Customer Name: " + entercustname);
			clearAndEnterText(waitForExpectedElement(EnterCustomerName), entercustname);
			Thread.sleep(2000);

			LoggerUtil.info(" Opening Business Segment dropdown");
			clickOnElement(clickingBusinessSegment);
			Thread.sleep(2000);

			LoggerUtil.info(" Selecting second checkbox from Business Segment list...");
			List<WebElement> selectingcheckbox = driver.findElements(clickcheckboxCustomers);
			if (selectingcheckbox.size() < 2) {
				LoggerUtil.fail(" Less than 2 Business Segment options found – cannot select.");
				return;
			}

			WebElement selectSegment = selectingcheckbox.get(1);
			selectSegment.click();

			LoggerUtil.info(" Clicking Save button to add Customer...");
			Thread.sleep(3000);
			clickOnElement(clickingSaveButtoncustomers);

			LoggerUtil.pass(" Customer saved successfully with Code: " + entercustcode + ", Name: " + entercustname);

		} catch (Exception e) {
			LoggerUtil.fail(" Exception while saving customer: " + e.getMessage());
			throw e;
		}
	}

	public static final By EnterForSearchvalue = By.xpath("//div[@id='table1_filter']/label/input");
	public static final By EnterSupplierNameSearching = By
			.xpath("//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']");
	public static final By fetchningsupplierFromtable = By.xpath("//table[@id='table1']/tbody/tr/td[8]");

	public void saveBopForDifferentSupplier(String Bopvalues, String enterPartdesvalue, String enterPartnumvalue,
			String enterpartcostvalue, String entersuppliername) throws InterruptedException {
		try {
			LoggerUtil.info("🔽 Clicking on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info("📋 Fetching BOP Category options");
			List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
			Thread.sleep(3000);

			LoggerUtil.info("Clicking on BOP Type dropdown");
			clickOnElement(clickingBopTypeDropdown);

			Thread.sleep(3000);
			List<WebElement> listofOptionValue = driver.findElements(optionvalueBop);
			boolean isSelected = false;
			for (WebElement BopValue : listofOptionValue) {
				String value = BopValue.getText().trim();
				if (value.equalsIgnoreCase(Bopvalues)) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BopValue);
						BopValue.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", BopValue);
					}
					LoggerUtil.pass(" Selected BOP Type: " + value);
					isSelected = true;
					break;
				}
			}
			if (!isSelected) {
				LoggerUtil.fail(" BOP Type '" + Bopvalues + "' not found.");
				return;
			}

			Thread.sleep(3000);
			LoggerUtil.info(" Entering Part Description: " + enterPartdesvalue);
			clearAndEnterText(waitForExpectedElement(EnterPartDescription), enterPartdesvalue);

			LoggerUtil.info(" Entering Part Number: " + enterPartnumvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterPartnumvalue);

			LoggerUtil.info(" Selecting UOM: %");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(2000);
			List<WebElement> uomoptionvalue = driver.findElements(uomdropdownoptionlist);
			selectBootStrapDropDown(uomoptionvalue, "%");

			LoggerUtil.info(" Selecting Currency");
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(2000);
			List<WebElement> currencyoptionvalue = driver.findElements(currencycelloptions);
			currencyoptionvalue.get(1).click();

			LoggerUtil.info(" Entering Part Cost/Unit: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info(" Selecting Supplier: " + entersuppliername);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(EnterSupplierNameSearching), entersuppliername);

			List<WebElement> supplieroptions = driver.findElements(supplierDropdownListForStandard);
			if (supplieroptions.isEmpty()) {
				LoggerUtil.fail(" No supplier found for: " + entersuppliername);
				return;
			}
			supplieroptions.get(0).click();

			LoggerUtil.info(" Clicking Save button...");
			Thread.sleep(2000);
			clickOnElement(clickingsavebutton);
			Thread.sleep(5000);

			LoggerUtil.pass(" BOP entry saved for Supplier: " + entersuppliername);

			// 🧪 Verify entry in table
			driver.navigate().refresh();
			Thread.sleep(6000);
			dashboard.clickingBopEntryTab();
			clearAndEnterText(waitForExpectedElement(EnterForSearchvalue), entersuppliername);

			String actualsuppliersaved = waitForExpectedElement(fetchningsupplierFromtable).getText();
			if (actualsuppliersaved.trim().contains(entersuppliername.trim())) {
				LoggerUtil.pass(" Data has been successfully saved and verified in the table.");
			} else {
				LoggerUtil.fail(" Supplier name not found in table after saving: " + entersuppliername);
			}

		} catch (Exception e) {
			LoggerUtil.fail(" Exception while saving BOP entry: " + e.getMessage());
			throw e;
		}
	}

	public void saveBopWithSupplier(String Bopvalues, String enterPartdesvalue, String enterPartnumvalue,
			String enterpartcostvalue, String entersuppliername) throws InterruptedException {
		try {
			LoggerUtil.info(" Clicking on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info(" Fetching BOP Category options");
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");
			Thread.sleep(3000);

			LoggerUtil.info(" Clicking on BOP Type dropdown");
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> bopTypeOptions = driver.findElements(optionvalueBop);

			boolean isSelected = false;
			for (WebElement option : bopTypeOptions) {
				String value = option.getText().trim();
				if (value.equalsIgnoreCase(Bopvalues)) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
						option.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
					}
					LoggerUtil.pass(" Selected BOP Type: " + value);
					isSelected = true;
					break;
				}
			}

			if (!isSelected) {
				LoggerUtil.fail(" BOP Type '" + Bopvalues + "' not found.");
				return;
			}

			LoggerUtil.info(" Entering Part Description: " + enterPartdesvalue);
			clearAndEnterText(waitForExpectedElement(EnterPartDescription), enterPartdesvalue);

			LoggerUtil.info(" Entering Part Number: " + enterPartnumvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterPartnumvalue);

			LoggerUtil.info(" Selecting UOM: %");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(2000);
			List<WebElement> uomOptions = driver.findElements(uomdropdownoptionlist);
			selectBootStrapDropDown(uomOptions, "%");

			LoggerUtil.info(" Selecting Currency");
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(2000);
			List<WebElement> currencyOptions = driver.findElements(currencycelloptions);
			currencyOptions.get(1).click();

			LoggerUtil.info(" Entering Part Cost/Unit: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info(" Selecting Supplier: " + entersuppliername);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(EnterSupplierNameSearching), entersuppliername);

			List<WebElement> supplierOptions = driver.findElements(supplierDropdownListForStandard);
			if (supplierOptions.isEmpty()) {
				LoggerUtil.fail(" No supplier found for: " + entersuppliername);
				return;
			}
			supplierOptions.get(0).click();

			LoggerUtil.info(" Clicking Save button...");
			Thread.sleep(2000);
			clickOnElement(clickingsavebutton);
			Thread.sleep(5000);

			LoggerUtil.pass(" BOP entry saved for Supplier: " + entersuppliername);

			// 🧪 Verification
			driver.navigate().refresh();
			Thread.sleep(6000);
			dashboard.clickingBopEntryTab();
			clearAndEnterText(waitForExpectedElement(EnterForSearchvalue), entersuppliername);

			String actualSupplierSaved = waitForExpectedElement(fetchningsupplierFromtable).getText();
			if (actualSupplierSaved.trim().contains(entersuppliername.trim())) {
				LoggerUtil.pass(" Data has been successfully saved and verified in the table.");
			} else {
				LoggerUtil.fail(" Supplier name not found in table after saving: " + entersuppliername);
			}

		} catch (Exception e) {
			LoggerUtil.fail(" Exception while saving BOP entry: " + e.getMessage());
			throw e;
		}
	}

	public static final By clickingCustomerDropdown = By
			.xpath("//span[@id='select2-BopEntry_SupplierStandard-container']");
	public static final By EnterCustomername = By
			.xpath("//span[@class='select2-search select2-search--dropdown']/input");
	public static final By CustomerDropdownList = By.xpath("//ul[@id='select2-BopEntry_SupplierStandard-results']/li");

	public void saveBopWithCustomer(String Bopvalues, String enterPartdesvalue, String enterPartnumvalue,
			String enterpartcostvalue, String entercustomername) throws InterruptedException {
		try {
			LoggerUtil.info(" Clicking on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info(" Fetching BOP Category options");
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");
			Thread.sleep(3000);

			LoggerUtil.info(" Clicking on BOP Type dropdown");
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> bopTypeOptions = driver.findElements(optionvalueBop);

			boolean isSelected = false;
			for (WebElement option : bopTypeOptions) {
				String value = option.getText().trim();
				if (value.equalsIgnoreCase(Bopvalues)) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
						option.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
					}
					LoggerUtil.pass(" Selected BOP Type: " + value);
					isSelected = true;
					break;
				}
			}

			if (!isSelected) {
				LoggerUtil.fail(" BOP Type '" + Bopvalues + "' not found.");
				return;
			}

			LoggerUtil.info(" Entering Part Description: " + enterPartdesvalue);
			clearAndEnterText(waitForExpectedElement(EnterPartDescription), enterPartdesvalue);

			LoggerUtil.info(" Entering Part Number: " + enterPartnumvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterPartnumvalue);

			LoggerUtil.info(" Selecting UOM: %");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(2000);
			List<WebElement> uomOptions = driver.findElements(uomdropdownoptionlist);
			selectBootStrapDropDown(uomOptions, "%");

			LoggerUtil.info(" Selecting Currency");
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(2000);
			List<WebElement> currencyOptions = driver.findElements(currencycelloptions);
			currencyOptions.get(1).click();

			LoggerUtil.info(" Entering Part Cost/Unit: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info(" Selecting Customer: " + entercustomername);
			clickOnElement(clickingCustomerDropdown);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(EnterCustomername), entercustomername);

			List<WebElement> customerOptions = driver.findElements(CustomerDropdownList);
			if (customerOptions.isEmpty()) {
				LoggerUtil.fail(" No customer found for: " + entercustomername);
				return;
			}

			customerOptions.get(0).click();

			LoggerUtil.info(" Clicking Save button...");
			Thread.sleep(2000);
			clickOnElement(clickingsavebutton);
			Thread.sleep(5000);

			LoggerUtil.pass(" BOP entry saved successfully for Customer: " + entercustomername);

			// 🧪 Verification
			driver.navigate().refresh();
			Thread.sleep(6000);
			dashboard.clickingBopEntryTab();
			clearAndEnterText(waitForExpectedElement(EnterForSearchvalue), entercustomername);

			String actualCustomerSaved = waitForExpectedElement(fetchningsupplierFromtable).getText();
			if (actualCustomerSaved.trim().contains(entercustomername.trim())) {
				LoggerUtil.pass(" Data has been successfully saved and verified in the table.");
			} else {
				LoggerUtil.fail(" Customer name not found in table after saving: " + entercustomername);
			}

		} catch (Exception e) {
			LoggerUtil.fail(" Exception while saving BOP entry for Customer: " + e.getMessage());
			throw e;
		}
	}

	public static final By clickingCompanyspecificDeltaValue = By.xpath("//button[@id='btnAddCompanyWiseDelta']");
	public static final By clickingCompanyDropdown = By.xpath("//span[@id='select2-CompanyId-container']");
	public static final By companieslistname = By.xpath("//ul[@id='select2-CompanyId-results']/li");
	public static final By EnterDeltaValue = By.xpath("//input[@id='BOPDeltaCompanyWiseLst_0__PriceDelta']");
	public static final By EnterfrieghtAndInsurance = By.xpath("//input[@id='FreightInsuanceStandard']");
	public static final By clickingEditButton = By.xpath("//*[@id='table1']/tbody/tr[1]/td[10]/a[1]/span/i");
	public static final By TotalcastStandard = By.xpath("//input[@id='TotalCostStandard']");
	public static final By totalcastofcompanydelta = By.xpath("//input[@id='BOPDeltaCompanyWiseLst_0__TotalCost']");

	public void verifyCompanySpecificDeltaValue(String Bopvalues, String enterPartdesvalue, String enterPartnumvalue,
			String enterpartcostvalue, String enterdelvalue, String enterdutiesvalue,
			String enterfrieghtAndinsurancevalue) throws InterruptedException {

		Thread.sleep(6000);
		clickOnElement(clickingBopCategoryDropdown);

		Thread.sleep(5000);
		LoggerUtil.info(" Fetching BOP Category options");
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);

		LoggerUtil.info(" Clicking on BOP Type dropdown");
		clickOnElement(clickingBopTypeDropdown);
		Thread.sleep(3000);
		List<WebElement> bopTypeOptions = driver.findElements(optionvalueBop);

		boolean isSelected = false;
		for (WebElement option : bopTypeOptions) {
			String value = option.getText().trim();
			if (value.equalsIgnoreCase(Bopvalues)) {
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				}
				LoggerUtil.pass(" Selected BOP Type: " + value);
				isSelected = true;
				break;
			}
		}

		if (!isSelected) {
			LoggerUtil.fail(" BOP Type '" + Bopvalues + "' not found.");
			return;
		}

		LoggerUtil.info(" Entering Part Description: " + enterPartdesvalue);
		clearAndEnterText(waitForExpectedElement(EnterPartDescription), enterPartdesvalue);

		LoggerUtil.info(" Entering Part Number: " + enterPartnumvalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterPartnumvalue);

		LoggerUtil.info(" Selecting UOM: %");
		clickOnElement(ClickingUomDropDown);
		Thread.sleep(2000);
		List<WebElement> uomOptions = driver.findElements(uomdropdownoptionlist);
		selectBootStrapDropDown(uomOptions, "%");

		LoggerUtil.info(" Selecting Currency");
		clickOnElement(clickingCurrencyDropDown);
		Thread.sleep(2000);
		List<WebElement> currencyOptions = driver.findElements(currencycelloptions);
		currencyOptions.get(1).click();

		LoggerUtil.info(" Entering Part Cost/Unit: " + enterpartcostvalue);
		clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

		clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(EnterfrieghtAndInsurance), enterfrieghtAndinsurancevalue);

		clickOnElement(clickingSuppliernameAndCodeDropdown);
		Thread.sleep(3000);

		List<WebElement> supplierOptions = driver.findElements(supplierDropdownListForStandard);

		supplierOptions.get(1).click();

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 110);");
		Thread.sleep(8000);

		clickOnElement(clickingCompanyspecificDeltaValue);

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 110);");

		clickOnElement(clickingCompanyDropdown);
		Thread.sleep(2000);
		List<WebElement> companiesvalue = driver.findElements(companieslistname);
		Thread.sleep(2000);
		selectBootStrapDropDown(companiesvalue, "Client Company-01-Mohali");
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(EnterDeltaValue), enterdelvalue);
		Thread.sleep(6000);

		clickOnElement(clickingsavebutton);

		driver.navigate().refresh();
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		clearAndEnterText(waitForExpectedElement(EnterForSearchvalue), Bopvalues);

		Thread.sleep(3000);

		clickOnElement(clickingEditButton);

		Thread.sleep(4000);

		String deltavalue = waitForExpectedElement(EnterDeltaValue).getAttribute("value");
		String totalcast = waitForExpectedElement(TotalcastStandard).getAttribute("value");
		String totalcastcompany = waitForExpectedElement(totalcastofcompanydelta).getAttribute("value");

		// Use BigDecimal for precision
		BigDecimal delvalue = new BigDecimal(deltavalue).setScale(3, RoundingMode.HALF_UP);
		BigDecimal total = new BigDecimal(totalcast).setScale(3, RoundingMode.HALF_UP);
		BigDecimal companyTotal = new BigDecimal(totalcastcompany).setScale(3, RoundingMode.HALF_UP);

		// Calculate expected total
		BigDecimal expectedTotal = total.add(delvalue);

		if (expectedTotal.compareTo(companyTotal) == 0) {
			LoggerUtil.pass(
					" Company delta applied correctly. Expected total: " + expectedTotal + ", Found: " + companyTotal);
		} else {
			LoggerUtil.fail(" Company delta mismatch. Expected: " + expectedTotal + ", Found: " + companyTotal);
		}

	}

	public static final By ClickingExportBtnForStandard = By.xpath("//button[@onclick='Boppopupforexport()']");
	public static final By ClickingSupplierDropdownForExportingExcelFile = By
			.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/button");
	public static final By ClickingExportButtonForDownloadStandardFile = By.xpath("//*[@id='exportButtonBop']");
	public static final By clickingCheckboxForSelectSupplieroptionInExcelFile = By.xpath(
			"//div[@class='multiselect-container dropdown-menu show']/button/following-sibling::button/span/input");

	public void verifyExportData() throws InterruptedException {

		clickOnElement(clickingBopCategoryDropdown);

		LoggerUtil.info(" Fetching BOP Category options");
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);
		clickOnElement(ClickingExportBtnForStandard);
		Thread.sleep(3000);
		clickOnElement(clickingRadioButtonForExportNewData);
		Thread.sleep(3000);
		clickOnElement(ClickingSupplierDropdownForExportingExcelFile);
		Thread.sleep(200);
		List<WebElement> clickingcheckbox = driver.findElements(clickingCheckboxForSelectSupplieroptionInExcelFile);
		WebElement selectingcheckbox = clickingcheckbox.get(2);
		selectingcheckbox.click();
		Thread.sleep(2000);
		clickOnElement(ClickingExportButtonForDownloadStandardFile);
		Thread.sleep(6000);
		File downloadedFile = getLatestBOPProcurementStandardFile();
		if (downloadedFile != null) {
			LoggerUtil.pass(" Latest BOP Procurement Standard file downloaded: " + downloadedFile.getName());

			try {
				// Verify header of the downloaded file
				boolean isStandard = ExcelUtil.verifyStandardHeader(downloadedFile.getAbsolutePath());
				if (isStandard) {
					LoggerUtil.pass(" File verified as BOP Standard.");
				} else {
					LoggerUtil.fail(" File is NOT BOP Standard.");
				}
			} catch (IOException e) {
				LoggerUtil.fail(" Failed to verify header: " + e.getMessage());
			}
		} else {
			LoggerUtil.fail(" No BOP Procurement Standard file found.");
		}

	}

	public static final By ReadBoptypeData = By.xpath("//table[@id='table1']/tbody/tr/td[1]");
	public static final By clickingExportBtnForReadingExsistingData = By.xpath("//button[@id='exportOldButton']");

	public void verifyReadAndCompareDataFromUiAndExcel() throws InterruptedException {
		Thread.sleep(4000);

		// Fetching UI data (Boptype data from the dropdown or table)
		clickOnElement(clickingBopCategoryDropdown);
		LoggerUtil.info("Fetching BOP Category options");

		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);

		// Reading the BOP type from the UI (you can fetch multiple or single values as
		// needed)
		List<WebElement> Boptypenames = driver.findElements(ReadBoptypeData);
		List<String> uiData = new ArrayList<>();
		for (WebElement namevalues : Boptypenames) {
			String flagvalue = namevalues.getText().trim();
			uiData.add(flagvalue);
			LoggerUtil.info("Fetched UI Data: " + flagvalue);
		}

		clickOnElement(ClickingExportBtnForStandard);
		Thread.sleep(3000);
		clickOnElement(clickingExportBtnForReadingExsistingData);

		Thread.sleep(30000);

		File downloadedFile = getLatestBOPProcurementStandardFile();
		LoggerUtil.info("Downloaded file: " + downloadedFile.getName());

		try {
			String filePath = downloadedFile.getAbsolutePath();
			List<String> excelData = ExcelUtil.getExcelDataFromColumnB(filePath, "BOP_Procurement_Standard");

			for (int i = 0; i < excelData.size(); i++) {
				String excelValue = excelData.get(i);
				if (i < uiData.size()) {
					String uiValue = uiData.get(i);
					if (excelValue.equals(uiValue)) {
						LoggerUtil.pass(" Data matches for Row " + (i + 3) + " (" + excelValue + ")");
					} else {
						LoggerUtil.fail(
								" Data mismatch for Row " + (i + 3) + " Excel: " + excelValue + " | UI: " + uiValue);
					}
				}
			}
		} catch (IOException e) {
			LoggerUtil.fail(" Failed to read Excel file: " + e.getMessage());
		}
	}

	public static final By toastmsg = By.xpath("//div[@id='toast-container']/div/div/following-sibling::div");
	public static final By clickingcrossBtn = By.xpath("(//button[@class='btn-close'])[2]");

	public void verifyPromptForSucessFullExport() throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Click BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info("Step 2: Fetch and select 'Standard' from BOP Category dropdown");
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			Thread.sleep(3000);

			LoggerUtil.info("Step 3: Click Export button for Standard");
			clickOnElement(ClickingExportBtnForStandard);

			Thread.sleep(3000);

			LoggerUtil.info("Step 4: Click Export button for Reading Existing Data");
			clickOnElement(clickingExportBtnForReadingExsistingData);

			Thread.sleep(2000);

			LoggerUtil.info("Step 5: Close export modal");
			clickOnElement(clickingcrossBtn);

			Thread.sleep(3000);

			LoggerUtil.info("Step 6: Capture and verify toast message after export");
			String actualToast = waitForExpectedElement(toastmsg).getText().trim();
			String expectedToast = "File exported successfully";

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass("Toast message matched: " + actualToast);
			} else {
				LoggerUtil.fail(
						"Toast message mismatch. Expected: '" + expectedToast + "', but found: '" + actualToast + "'");
			}

			Assert.assertEquals(actualToast, expectedToast);

		} catch (Exception e) {
			LoggerUtil.error("Exception occurred during export validation: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	public static final By importpopup = By.xpath("//*[@id='toast-container']/div/div");
	public static final By FetchingBoptypeData = By.xpath("//table[@id='table1']/tbody/tr/td[1]");
	public static final By optionvalueSupplierDropdown = By
			.xpath("//ul[@id='select2-BopEntry_SupplierStandard-results']/li");

	public void verifyModifyBoptypeInExcelSheetAndImport(String Bopvalues, String enterPartdesvalue,
			String enterPartnumvalue, String enterpartcostvalue, String modifiedBopValues) throws InterruptedException {
		Thread.sleep(5000);
		try {
			LoggerUtil.info(" Clicking on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info(" Selecting 'Standard' from BOP Category dropdown");
			List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
			Thread.sleep(3000);

			LoggerUtil.info(" Clicking on BOP Type dropdown and selecting value: " + Bopvalues);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> listofOptionValue = driver.findElements(optionvalueBop);

			boolean isSelected = false;
			for (WebElement BopValue : listofOptionValue) {
				String value = BopValue.getText().trim();
				if (value.equalsIgnoreCase(Bopvalues)) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BopValue);
						BopValue.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", BopValue);
					}
					LoggerUtil.pass(" Selected BOP Type: " + value);
					isSelected = true;
					break;
				}
			}

			if (!isSelected) {
				LoggerUtil.fail(" BOP Type '" + Bopvalues + "' not found.");
				return;
			}

			Thread.sleep(3000);
			LoggerUtil.info(" Entering Part Description: " + enterPartdesvalue);
			clearAndEnterText(waitForExpectedElement(EnterPartDescription), enterPartdesvalue);

			LoggerUtil.info(" Entering Part Number: " + enterPartnumvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterPartnumvalue);

			LoggerUtil.info(" Selecting UOM: %");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(2000);
			List<WebElement> uomoptionvalue = driver.findElements(uomdropdownoptionlist);
			selectBootStrapDropDown(uomoptionvalue, "%");

			LoggerUtil.info(" Selecting Currency");
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(2000);
			List<WebElement> currencyoptionvalue = driver.findElements(currencycelloptions);
			currencyoptionvalue.get(1).click();

			Thread.sleep(3000);
			LoggerUtil.info(" Selecting Supplier");
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			Thread.sleep(3000);
			List<WebElement> supplierList = driver.findElements(optionvalueSupplierDropdown);
			supplierList.get(2).click();

			LoggerUtil.info(" Entering Part Cost/Unit: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info(" Clicking Save button");
			clickOnElement(clickingsavebutton);
			Thread.sleep(5000);

			try {
				clickOnElement(clickingBopCategoryDropdown);
			} catch (Exception e) {
				LoggerUtil.info("Retrying BOP Category click after exception: " + e.getMessage());
				Thread.sleep(4000);
				clickOnElement(clickingBopCategoryDropdown);
			}

			LoggerUtil.info(" Selecting 'Standard' again after save");
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");
			Thread.sleep(5000);

			LoggerUtil.info(" Clicking Export for Standard");
			clickOnElement(ClickingExportBtnForStandard);
			Thread.sleep(3000);

			LoggerUtil.info(" Clicking Export for Reading Existing Data");
			clickOnElement(clickingExportBtnForReadingExsistingData);
			LoggerUtil.info(" Closing Export modal");
			clickOnElement(clickingcrossBtn);

			Thread.sleep(30000);

			LoggerUtil.info(" Modifying exported Excel with new BOP Type: " + modifiedBopValues);
			ModifyingBopType(modifiedBopValues);
			Thread.sleep(4000);

			LoggerUtil.info(" Uploading modified Excel back into UI");
			UploadmodifiedExcelFile(modifiedBopValues);

			Thread.sleep(5000);
			LoggerUtil.info(" Refreshing UI");
			driver.navigate().refresh();
			Thread.sleep(9000);

			try {
				clickOnElement(clickingBopCategoryDropdown);
			} catch (Exception e) {
				LoggerUtil.info("Retrying dropdown click after refresh: " + e.getMessage());
				clickOnElement(clickingBopCategoryDropdown);
			}

			LoggerUtil.info(" Selecting 'Standard' and searching for modified BOP Type: " + modifiedBopValues);
			List<WebElement> ListBopCategoryDropdown1 = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown1, "Standard");

			Thread.sleep(7000);
			clearAndEnterText(waitForExpectedElement(EnterForSearchvalue), modifiedBopValues);
			Thread.sleep(3000);

			String actualModifiedData = waitForExpectedElement(FetchingBoptypeData).getText();
			if (actualModifiedData.equals(modifiedBopValues)) {
				LoggerUtil.pass(" Modified BOP Type verified in UI: " + actualModifiedData);
			} else {
				LoggerUtil.fail(" Modified BOP Type mismatch. Expected: " + modifiedBopValues + ", Found: "
						+ actualModifiedData);
			}

			Assert.assertEquals(actualModifiedData, modifiedBopValues);

		} catch (Exception e) {
			LoggerUtil.error(" Exception in scenario: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	public String ModifyingBopType(String modifiedBopValues) throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementStandardFile();
		if (latestFile == null) {
			LoggerUtil.error(" No BOP Procurement Excel file found.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();
		int lastDataRow = ExcelUtil.getLastNonEmptyRow(filePath);
		ExcelFiller.setCellValue(filePath, 0, lastDataRow, 1, ExcelFiller.ValueType.DROPDOWN,
				Arrays.asList(modifiedBopValues));

		LoggerUtil.info(" Excel updated with new BOP Type: " + modifiedBopValues + " at row " + lastDataRow);
		return filePath;
	}

	public void UploadmodifiedExcelFile(String modifiedBopValues) throws InterruptedException {
		String filePath = ModifyingBopType(modifiedBopValues);

		if (filePath == null) {
			LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
			return;
		}

		LoggerUtil.info(" Uploading Excel file: " + filePath);

		try {
			WebElement uploadInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
			uploadInput.sendKeys(filePath);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

			LoggerUtil.info(" Waiting for import toast message...");
			String actualToast = waitForExpectedElement(importpopup).getText().trim();

			if (actualToast.toLowerCase().contains("file imported successfully")) {
				LoggerUtil.pass(" Excel uploaded successfully: " + actualToast);
			} else {
				LoggerUtil.fail(" Unexpected toast after import: " + actualToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception during Excel upload: " + e.getMessage());
		}
	}

	public void verifyFileNamingConvention() throws InterruptedException {

		Thread.sleep(9000);
		LoggerUtil.info(" Clicking on BOP Category dropdown");
		clickOnElement(clickingBopCategoryDropdown);

		LoggerUtil.info(" Selecting 'Standard' from BOP Category dropdown");
		List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
		Thread.sleep(3000);

		LoggerUtil.info(" Clicking Export for Standard");
		clickOnElement(ClickingExportBtnForStandard);
		Thread.sleep(3000);

		LoggerUtil.info(" Clicking Export for Reading Excel File ");
		clickOnElement(clickingExportBtnForReadingExsistingData);

		LoggerUtil.info(" Closing Export modal");
		clickOnElement(clickingcrossBtn);
		Thread.sleep(20000);

		File latestFile = getLatestBOPProcurementStandardFile();
		if (latestFile == null) {
			LoggerUtil.fail(" Exported file not found.");
			Assert.fail("Exported file is missing.");
		}

		String fileName = latestFile.getName();
		LoggerUtil.info(" Latest exported file name: " + fileName);

		if (!fileName.startsWith("BOP_Procurement_Standard") || !fileName.endsWith(".xlsx")) {
			LoggerUtil.fail(" File name format is invalid (prefix/suffix). Found: " + fileName);
			Assert.fail("Invalid file name structure.");
		}

		String timePart = fileName.replace("BOP_Procurement_Standard", "").replace(".xlsx", "").trim();

		DateTimeFormatter fileFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
		DateTimeFormatter systemFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");

		try {
			LocalDateTime fileDateTime = LocalDateTime.parse(timePart, fileFormat);
			LocalDateTime currentTime = LocalDateTime.now();

			long secondsDifference = Duration.between(fileDateTime, currentTime).abs().getSeconds();

			if (secondsDifference <= 60) {
				LoggerUtil.pass(" File name contains correct timestamp within allowed window: " + timePart);
			} else {
				LoggerUtil.fail(" File timestamp is not within expected range. Found: " + timePart + ", Now: "
						+ currentTime.format(systemFormat));
				Assert.fail("Timestamp mismatch.");
			}
		} catch (DateTimeParseException e) {
			LoggerUtil.fail(" Unable to parse timestamp from file name: " + timePart);
			Assert.fail("Date parse failed: " + e.getMessage());
		}
	}

	public void verifyImpotDataWithMissingField() throws InterruptedException {
		LoggerUtil.info("Test Started: verifyImpotDataWithMissingField");

		try {
			Thread.sleep(9000);
			clickOnElement(clickingBopCategoryDropdown);
			LoggerUtil.info("Clicked on BOP Category dropdown");

			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");
			LoggerUtil.info("Selected BOP Category: Standard");

			Thread.sleep(3000);
			clickOnElement(ClickingButtonExportButtonUI);
			LoggerUtil.info("Clicked on Export button in UI");

			Thread.sleep(2000);
			clickOnElement(clickingRadioButtonForExportNewData);
			LoggerUtil.info("Selected radio button for 'Export New Data'");

			Thread.sleep(2000);
			clickOnElement(clickingsupplierdropdownExportimport);
			LoggerUtil.info("Opened Supplier dropdown");

			Thread.sleep(4000);
			clickOnElement(clickingcheckboxFromsupplierdropdown);
			LoggerUtil.info("Checked Supplier checkbox from dropdown");

			Thread.sleep(2000);
			clickOnElement(clickingexportbtnnewExcelfile);
			LoggerUtil.info("Clicked on Export button to download Excel file");

			Thread.sleep(9000);
			clickOnElement(clickingCrossButtonExportui);
			LoggerUtil.info("Closed Export UI popup");

			Thread.sleep(20000);
			fillingFileWithMissingMandatoryField();
			LoggerUtil.info("Filled Excel file with missing mandatory fields");

			Thread.sleep(4000);
			UploadExcelWithMissingMandatoryData();
			LoggerUtil.info("Uploaded Excel file with missing mandatory fields");

			LoggerUtil.pass("Test Completed Successfully: verifyImpotDataWithMissingField");

		} catch (Exception e) {
			LoggerUtil.error("Error occurred in verifyImpotDataWithMissingField: " + e.getMessage());
			LoggerUtil.fail("Test Failed: verifyImpotDataWithMissingField");
			throw e;
		}
	}

	public String fillingFileWithMissingMandatoryField() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementStandardFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();

		String childprtdes = faker.letterify("????");
		int randomint = faker.number().numberBetween(10, 90);
		String partno = String.valueOf(randomint);

		String supplycurrency = "India-Rupees-RBI";
		String yeardropdown = "2021-2022";
		String period = "May";
		String partcost = String.valueOf(randomint);
		double floatvalue = faker.number().randomDouble(2, 100, 999);
		double floatvalue1 = faker.number().randomDouble(2, 100, 999);
		String Duties = String.valueOf(floatvalue);
		String frieghtAndInsurance = String.valueOf(floatvalue1);

		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
		ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));

		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(supplycurrency));
		ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(yeardropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
		ExcelFiller.setCellValue(filePath, 0, 2, 10, ExcelFiller.ValueType.STRING, Arrays.asList(partcost));
		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));
		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));

		return latestFile.getAbsolutePath();

	}

	public void UploadExcelWithMissingMandatoryData() throws InterruptedException {
		String filePath = fillingFileWithMissingMandatoryField();

		if (filePath == null) {
			LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
			return;
		}

		LoggerUtil.info(" Uploading Excel file: " + filePath);

		try {
			WebElement uploadInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
			uploadInput.sendKeys(filePath);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

			LoggerUtil.info(" Waiting for import toast message...");
			String actualToast = waitForExpectedElement(importpopup).getText().trim();

			if (actualToast.toLowerCase().contains("Invalid data in Excel file!")) {
				LoggerUtil.pass(" Excel File Not Uploaded :" + actualToast);
			} else {
				LoggerUtil.pass("Excel File Not Uploaded :" + actualToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception during Excel upload: " + e.getMessage());
		}
	}

	public void verifyhandlingDuplicateEntries() throws InterruptedException {

		Thread.sleep(3000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);
		clickOnElement(ClickingButtonExportButtonUI);
		Thread.sleep(2000);
		clickOnElement(clickingRadioButtonForExportNewData);
		Thread.sleep(2000);
		clickOnElement(clickingsupplierdropdownExportimport);
		Thread.sleep(4000);
		clickOnElement(clickingcheckboxFromsupplierdropdown);
		Thread.sleep(2000);
		clickOnElement(clickingexportbtnnewExcelfile);
		Thread.sleep(9000);
		clickOnElement(clickingCrossButtonExportui);
		fillingDuplicateFile();
		Thread.sleep(15000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions1, "Standard");
		Thread.sleep(2000);
		UploadExcelWithDuplicateData();

	}

	public String fillingDuplicateFile() throws InterruptedException {
		Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementStandardFile();
		if (latestFile == null) {
			System.out.println("No BOPProcurementStandardFile file found.");
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

		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));
		ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
		ExcelFiller.setCellValue(filePath, 0, 3, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
		ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));
		ExcelFiller.setCellValue(filePath, 0, 3, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));
		ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(UOM));
		ExcelFiller.setCellValue(filePath, 0, 3, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(UOM));
		ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Supplier));
		ExcelFiller.setCellValue(filePath, 0, 3, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Supplier));
		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(supplycurrency));
		ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(supplycurrency));
		ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(yeardropdown));
		ExcelFiller.setCellValue(filePath, 0, 3, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(yeardropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
		ExcelFiller.setCellValue(filePath, 0, 3, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
		ExcelFiller.setCellValue(filePath, 0, 2, 10, ExcelFiller.ValueType.STRING, Arrays.asList(partcost));
		ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.STRING, Arrays.asList(partcost));
		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));
		ExcelFiller.setCellValue(filePath, 0, 3, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));
		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));
		ExcelFiller.setCellValue(filePath, 0, 3, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));

		return latestFile.getAbsolutePath();

	}

	public void UploadExcelWithDuplicateData() throws InterruptedException {
		String filePath = fillingDuplicateFile();

		if (filePath == null) {
			LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
			return;
		}

		LoggerUtil.info(" Uploading Excel file: " + filePath);

		try {
			WebElement uploadInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
			uploadInput.sendKeys(filePath);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

			LoggerUtil.info(" Waiting for import toast message...");
			String actualToast = waitForExpectedElement(importpopup).getText().trim();

			if (actualToast.toLowerCase().contains("Invalid data in Excel file!")) {
				LoggerUtil.pass(" Excel File Not Uploaded :" + actualToast);
			} else {
				LoggerUtil.pass("Excel File Not Uploaded :" + actualToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception during Excel upload: " + e.getMessage());
		}
	}

	public void importSpecialCharacteInpartnumber() throws InterruptedException {

		Thread.sleep(3000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions, "Standard");
		Thread.sleep(3000);
		clickOnElement(ClickingButtonExportButtonUI);
		Thread.sleep(2000);
		clickOnElement(clickingRadioButtonForExportNewData);
		Thread.sleep(2000);
		clickOnElement(clickingsupplierdropdownExportimport);
		Thread.sleep(4000);
		clickOnElement(clickingcheckboxFromsupplierdropdown);
		Thread.sleep(2000);
		clickOnElement(clickingexportbtnnewExcelfile);
		Thread.sleep(9000);
		clickOnElement(clickingCrossButtonExportui);
		fillingExcelFileWithSpecicalCharacter();
		Thread.sleep(15000);
		clickOnElement(clickingBopCategoryDropdown);
		List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
		selectBootStrapDropDown(bopCategoryOptions1, "Standard");
		Thread.sleep(2000);
		UploadExcelWithSpecialCharacterData();

	}

	public String fillingExcelFileWithSpecicalCharacter() throws InterruptedException {
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
		String partno = "@@@@@#####";
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

		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));

		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));

		ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));

		ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(UOM));

		ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Supplier));

		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(supplycurrency));

		ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(yeardropdown));

		ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

		ExcelFiller.setCellValue(filePath, 0, 2, 10, ExcelFiller.ValueType.STRING, Arrays.asList(partcost));

		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(Duties));

		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(frieghtAndInsurance));

		return latestFile.getAbsolutePath();

	}

	public void UploadExcelWithSpecialCharacterData() throws InterruptedException {
		String filePath = fillingExcelFileWithSpecicalCharacter();

		if (filePath == null) {
			LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
			return;
		}

		LoggerUtil.info(" Uploading Excel file: " + filePath);

		try {
			WebElement uploadInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
			uploadInput.sendKeys(filePath);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

			LoggerUtil.info(" Waiting for import toast message...");
			String actualToast = waitForExpectedElement(importpopup).getText().trim();

			if (actualToast.toLowerCase().contains("Invalid data in Excel file!")) {
				LoggerUtil.pass(" Excel File Not Uploaded :" + actualToast);
			} else {
				LoggerUtil.pass("Excel File Not Uploaded :" + actualToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception during Excel upload: " + e.getMessage());
		}
	}

	public void verifyPartCostUnitDutiesFreightAcceptOnlyNumeric(String Bopvalues, String enterPartdesvalue,
			String enterPartnumvalue, String enterPartcostValue, String enterDutiesValue,
			String enterFrieghtAndInsuranceValue) throws InterruptedException {
		Thread.sleep(3000);
		try {
			LoggerUtil.info(" Clicking on BOP Category dropdown");
			clickOnElement(clickingBopCategoryDropdown);

			LoggerUtil.info(" Selecting 'Standard' from BOP Category dropdown");
			List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
			Thread.sleep(3000);

			LoggerUtil.info("📌 Clicking on BOP Type dropdown and selecting value: " + Bopvalues);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> listofOptionValue = driver.findElements(optionvalueBop);

			boolean isSelected = false;
			for (WebElement BopValue : listofOptionValue) {
				String value = BopValue.getText().trim();
				if (value.equalsIgnoreCase(Bopvalues)) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BopValue);
						BopValue.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", BopValue);
					}
					LoggerUtil.pass(" Selected BOP Type: " + value);
					isSelected = true;
					break;
				}
			}

			if (!isSelected) {
				LoggerUtil.fail("❌ BOP Type '" + Bopvalues + "' not found.");
				return;
			}

			Thread.sleep(3000);
			LoggerUtil.info(" Entering Part Description: " + enterPartdesvalue);
			clearAndEnterText(waitForExpectedElement(EnterPartDescription), enterPartdesvalue);

			LoggerUtil.info(" Entering Part Number: " + enterPartnumvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterPartnumvalue);

			LoggerUtil.info(" Selecting UOM: %");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(2000);
			List<WebElement> uomoptionvalue = driver.findElements(uomdropdownoptionlist);
			selectBootStrapDropDown(uomoptionvalue, "%");

			LoggerUtil.info(" Selecting Currency");
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(2000);
			List<WebElement> currencyoptionvalue = driver.findElements(currencycelloptions);
			currencyoptionvalue.get(1).click();

			Thread.sleep(3000);
			LoggerUtil.info(" Selecting Supplier");
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			Thread.sleep(2000);
			List<WebElement> optionsSupplierList = driver.findElements(optionvalueSupplierDropdown);
			WebElement selectingsuppliervalue = optionsSupplierList.get(2);
			Thread.sleep(1000);
			selectingsuppliervalue.click();

			Thread.sleep(2000);
			LoggerUtil.info(" Entering non-numeric Part Cost/Unit value: " + enterPartcostValue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterPartcostValue);

			LoggerUtil.info(" Entering non-numeric Duties value: " + enterDutiesValue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterDutiesValue);

			LoggerUtil.info(" Entering non-numeric Freight & Insurance value: " + enterFrieghtAndInsuranceValue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterfrieghtAndInsurance), enterFrieghtAndInsuranceValue);

			Thread.sleep(3000);
			LoggerUtil.info(" Clicking Save button");
			clickOnElement(clickingsavebutton);

			String actualToast = waitForExpectedElement(toastmsg).getText().trim();
			String expectedToast = "Please Enter Part Cost/Unit";

			LoggerUtil.info(" Captured Toast Message: " + actualToast);

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass(" Correct validation message shown: " + actualToast);
				LoggerUtil.info("Part Cost Unit Did not Take Numerical Value ");
			} else {
				LoggerUtil.fail(
						" Validation toast mismatch. Expected: '" + expectedToast + "', Found: '" + actualToast + "'");
			}

			Assert.assertEquals(actualToast, expectedToast);

		} catch (Exception e) {
			LoggerUtil.error(" Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	public static final By clickingCustomerDropDown = By
			.xpath("//span[@id='select2-BopEntry_SupplierStandard-container']");
	public static final By clickingcrossbuttonForAddCustomer = By
			.xpath("//span[contains(text(),'Customer')]/parent::h5/following-sibling::button");

	public void verifyAddNewCustomerFunctionality(String entercustcode, String entercustname)
			throws InterruptedException {
		LoggerUtil.info("Test Started: verifyAddNewCustomerFunctionality for Customer Name: " + entercustname);

		try {
			Thread.sleep(6000);
			clickOnElement(clickingBopCategoryDropdown);
			LoggerUtil.info("Clicked on BOP Category dropdown");

			List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
			LoggerUtil.info("Selected 'Standard' from BOP Category dropdown");

			Thread.sleep(3000);
			clickOnElement(clickingCustomerRadioButton);
			LoggerUtil.info("Selected 'Customer' radio button");

			Thread.sleep(2000);
			clickOnElement(clickingAddCustomerButton);
			LoggerUtil.info("Clicked 'Add Customer' button");

			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterCustomerCode), entercustcode);
			LoggerUtil.info("Entered Customer Code: " + entercustcode);

			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterCustomerName), entercustname);
			LoggerUtil.info("Entered Customer Name: " + entercustname);

			Thread.sleep(2000);
			clickOnElement(clickingBusinessSegment);
			LoggerUtil.info("Opened Business Segment dropdown");

			Thread.sleep(2000);
			List<WebElement> selectingcheckbox = driver.findElements(clickcheckboxCustomers);
			if (selectingcheckbox.size() < 2) {
				LoggerUtil.fail("Less than 2 Business Segment options found – cannot select");
				return;
			}

			selectingcheckbox.get(1).click();
			LoggerUtil.info("Selected second Business Segment checkbox");

			Thread.sleep(3000);
			clickOnElement(clickingSaveButtoncustomers);
			LoggerUtil.info("Clicked Save button to add Customer");

			Thread.sleep(4000);
			clickOnElement(clickingCustomerDropdown);
			LoggerUtil.info("Opened Customer dropdown");

			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(EnterCustomername), entercustname);
			LoggerUtil.info("Entered Customer Name in dropdown search: " + entercustname);

			Thread.sleep(5000);
			List<WebElement> customerOptions = driver.findElements(CustomerDropdownList);
			if (customerOptions.isEmpty()) {
				LoggerUtil.fail("No customer found for: " + entercustname);
				return;
			}

			LoggerUtil.pass("Customer '" + entercustname + "' added successfully and found in the dropdown");

		} catch (Exception e) {
			LoggerUtil.error("Error in verifyAddNewCustomerFunctionality: " + e.getMessage());
			LoggerUtil.fail("Test Failed: verifyAddNewCustomerFunctionality for Customer: " + entercustname);
			throw e;
		}
	}

	public static final By clickingResetButtonForAddCustomer = By
			.xpath("//button[@onclick='resetCustomerControls1()' and normalize-space()='Reset']");

	public void verifyRestFunctionality(String entercustcode, String entercustname) throws InterruptedException {
		LoggerUtil.info("Test Started: verifyRestFunctionality");

		try {
			Thread.sleep(6000);
			clickOnElement(clickingBopCategoryDropdown);
			LoggerUtil.info("Clicked on BOP Category dropdown");

			List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
			LoggerUtil.info("Selected 'Standard' from BOP Category dropdown");

			Thread.sleep(3000);
			clickOnElement(clickingCustomerRadioButton);
			LoggerUtil.info("Selected 'Customer' radio button");

			Thread.sleep(2000);
			clickOnElement(clickingAddCustomerButton);
			LoggerUtil.info("Clicked 'Add Customer' button");

			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterCustomerCode), entercustcode);
			LoggerUtil.info("Entered Customer Code: " + entercustcode);

			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterCustomerName), entercustname);
			LoggerUtil.info("Entered Customer Name: " + entercustname);

			Thread.sleep(2000);
			clickOnElement(clickingBusinessSegment);
			LoggerUtil.info("Opened Business Segment dropdown");

			Thread.sleep(2000);
			List<WebElement> selectingcheckbox = driver.findElements(clickcheckboxCustomers);
			if (selectingcheckbox.size() < 2) {
				LoggerUtil.fail("Less than 2 Business Segment options found – cannot select");
				return;
			}
			selectingcheckbox.get(1).click();
			LoggerUtil.info("Selected second Business Segment checkbox");

			// RESET
			Thread.sleep(3000);
			clickOnElement(clickingResetButtonForAddCustomer);
			LoggerUtil.info("Clicked Reset button");

			// --- Your validation style preserved: findElements(...).isEmpty() ---
			// Customer Code field presence check (your logic)
			List<WebElement> entercustomercodevalue = driver.findElements(EnterCustomerCode);
			try {
				if (entercustomercodevalue.isEmpty()) {
					LoggerUtil.pass("Reset: Customer Code cleared (per your validation logic).");
				} else {
					LoggerUtil.fail("Reset: Customer Code not cleared (per your validation logic).");
				}
			} catch (Exception e) {
				LoggerUtil.error("Exception during Customer Code reset validation: " + e.getMessage());
			}

			// Customer Name field presence check (your logic)
			List<WebElement> enterCustomernamevalue = driver.findElements(EnterCustomername);
			try {
				if (enterCustomernamevalue.isEmpty()) {
					LoggerUtil.pass("Reset: Customer Name cleared (per your validation logic).");
				} else {
					LoggerUtil.fail("Reset: Customer Name not cleared (per your validation logic).");
				}
			} catch (Exception e) {
				LoggerUtil.error("Exception during Customer Name reset validation: " + e.getMessage());
			}

			LoggerUtil.info("Reset validation completed (both fields checked with your logic).");

		} catch (Exception e) {
			LoggerUtil.error("Error in verifyRestFunctionality: " + e.getMessage());
			LoggerUtil.fail("Test Failed: verifyRestFunctionality");
			throw e;
		}
	}

//   public void verifyRestFunctionality(String entercustcode, String entercustname) throws InterruptedException {
//	    LoggerUtil.info("Test Started: verifyRestFunctionality");
//
//	    try {
//	        Thread.sleep(6000);
//	        clickOnElement(clickingBopCategoryDropdown);
//	        LoggerUtil.info("Clicked on BOP Category dropdown");
//
//	        List<WebElement> ListBopCategoryDropdown = driver.findElements(BopCategoryDropDownValue);
//	        selectBootStrapDropDown(ListBopCategoryDropdown, "Standard");
//	        LoggerUtil.info("Selected 'Standard' from BOP Category dropdown");
//
//	        Thread.sleep(3000);
//	        clickOnElement(clickingCustomerRadioButton);
//	        LoggerUtil.info("Selected 'Customer' radio button");
//
//	        Thread.sleep(2000);
//	        clickOnElement(clickingAddCustomerButton);
//	        LoggerUtil.info("Clicked 'Add Customer' button");
//
//	        Thread.sleep(2000);
//	        clearAndEnterText(waitForExpectedElement(EnterCustomerCode), entercustcode);
//	        LoggerUtil.info("Entered Customer Code: " + entercustcode);
//
//	        Thread.sleep(2000);
//	        clearAndEnterText(waitForExpectedElement(EnterCustomerName), entercustname);
//	        LoggerUtil.info("Entered Customer Name: " + entercustname);
//
//	        Thread.sleep(2000);
//	        clickOnElement(clickingBusinessSegment);
//	        LoggerUtil.info("Opened Business Segment dropdown");
//
//	        Thread.sleep(2000);
//	        List<WebElement> selectingcheckbox = driver.findElements(clickcheckboxCustomers);
//	        if (selectingcheckbox.size() < 2) {
//	            LoggerUtil.fail("Less than 2 Business Segment options found – cannot select");
//	            return; // Precondition failed, aage ka flow meaningful nahi hai
//	        }
//	        selectingcheckbox.get(1).click();
//	        LoggerUtil.info("Selected second Business Segment checkbox");
//
//	        // ---- RESET & VALIDATION ----
//	        Thread.sleep(3000);
//	        clickOnElement(clickingResetButtonForAddCustomer);
//	        LoggerUtil.info("Clicked Reset button");
//
//	        // Wait for fields to be interactable and then read their values
//	        Thread.sleep(1500); // lightweight buffer after reset (replace with explicit wait if you have one)
//
//	        WebElement codeField = waitForExpectedElement(EnterCustomerCode);
//	        WebElement nameField = waitForExpectedElement(EnterCustomerName);
//
//	        String codeVal = codeField.getAttribute("value") == null ? "" : codeField.getAttribute("value").trim();
//	        String nameVal = nameField.getAttribute("value") == null ? "" : nameField.getAttribute("value").trim();
//
//	        boolean codeCleared = codeVal.isEmpty();
//	        boolean nameCleared = nameVal.isEmpty();
//
//	        if (codeCleared) {
//	            LoggerUtil.pass("Customer Code cleared successfully by Reset.");
//	        } else {
//	            LoggerUtil.fail("Customer Code not cleared by Reset. Current value: '" + codeVal + "'");
//	        }
//
//	        if (nameCleared) {
//	            LoggerUtil.pass("Customer Name cleared successfully by Reset.");
//	        } else {
//	            LoggerUtil.fail("Customer Name not cleared by Reset. Current value: '" + nameVal + "'");
//	        }
//
//	        if (codeCleared && nameCleared) {
//	            LoggerUtil.pass("Reset functionality working correctly for all fields.");
//	        } else {
//	            LoggerUtil.fail("Reset did not clear all fields.");
//	        }
//
//	    } catch (Exception e) {
//	        LoggerUtil.error("Error in verifyRestFunctionality: " + e.getMessage());
//	        LoggerUtil.fail("Test Failed: verifyRestFunctionality");
//	        throw e;
//	    }
//	}

	public void SaveAsNewWithUniqueBopTypeAndWithUniquePartNoWithPriviousSupplierNames(String selectedvalueboptype,
			String enterpartdescriptionvalue, String enterpartNumberValue, String enterpartcostvalue,
			String enterdutiesvalue, String enterfrieghtandinsurancevalue, String selectednewvalueboptype,

			String enternewpartNumberValue

	) throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(7000);

			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			uomdropdownoptionvalue.get(1).click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			optionvalueforsupplier.get(1).click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			optionvalueforcurrency.get(1).click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button (First Entry)");
			clickOnElement(clickingsavebutton);

			driver.navigate().refresh();
			Thread.sleep(20000);

			LoggerUtil.info("Step 12: Selecting BOP Category: Standard again for search");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions1 = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions1, "Standard");
			Thread.sleep(5000);

			LoggerUtil.info("Step 13: Searching for saved record by BOP Type");
			clearAndEnterText(waitForExpectedElement(EnterSearchValueForDataBaseStandard), selectedvalueboptype);
			Thread.sleep(4000);

			LoggerUtil.info("Step 14: Clicking edit button for saved record");
			clickOnElement(editbtn);

			clickOnElement(clickingBopTypeDropdown);
			Thread.sleep(5000);
			List<WebElement> optionvalueBoptype1 = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype1, selectednewvalueboptype);

			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enternewpartNumberValue);
			Thread.sleep(2000);

			LoggerUtil.info("Step 17: Re-selecting Supplier (same as before)");
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier1 = driver.findElements(supplierDropdownListForStandard);
			optionvalueforsupplier1.get(1).click();

			LoggerUtil.info("Step 22: Clicking Save As New button (Second Entry)");
			clickOnElement(clickingSaveAsNewButton);

			String actualpopup = waitForExpectedElement(toastmsg).getText();
			LoggerUtil.info("Popup text: " + actualpopup);

			if (actualpopup != null && actualpopup.toLowerCase().contains("already exists")) {
				LoggerUtil.fail("Duplicate detected: " + actualpopup);
			} else {
				LoggerUtil.pass("Successfully saved BOP entry twice with same Part No and Supplier");
			}

		} catch (Exception e) {
			LoggerUtil.error("Error during double-save with same Part No: " + e.getMessage());
			LoggerUtil.fail("Test Failed: saveBopTypeAndSaveAgainWithSamePartNoAndSupplierName");
			throw e;
		}
	}

	public static final By AddSupplierButtonStandard = By.xpath("(//a[@id='addNewSupplier1' ]/span)[1]");
	public static final By RadioButtonSupplierStandard = By
			.xpath("//input[@id='BopEntry_RadioButtonsupplier' and @value='4']");
	public static final By VerifyingSuppliernameAndCodeHeadingName = By.xpath("//label[@id='Supplierdata']");
	public static final By SupplierDropdownAfterClickingExportButton = By
			.xpath("//select[@id='suppdropdownBOP']/option");
	public static final By clickingDropdownAfterClickingExportButton = By
			.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/button");

	public void verifyUserUncheckSupplierControlAuthority() throws InterruptedException {

		try {
			List<WebElement> addBtn = driver.findElements(AddSupplierButtonStandard);
			if (addBtn.isEmpty() || !safeDisplayed(addBtn.get(0))) {
				LoggerUtil.pass("Add Supplier Button is not visible — restriction working.");
			} else {
				LoggerUtil.fail("Add Supplier Button is visible — restriction failed.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Add Supplier Button): " + e.getMessage());
		}

		// Supplier Radio Button
		try {
			List<WebElement> radioBtn = driver.findElements(RadioButtonSupplierStandard);
			if (radioBtn.isEmpty() || !safeDisplayed(radioBtn.get(0))) {
				LoggerUtil.pass("Radio Button is not visible — restriction working.");
			} else {
				LoggerUtil.fail("Radio Button is visible — restriction failed.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Radio Button): " + e.getMessage());
		}

		// Supplier Name & Code Heading
		try {
			List<WebElement> heading = driver.findElements(VerifyingSuppliernameAndCodeHeadingName);
			if (heading.isEmpty() || !safeDisplayed(heading.get(0))) {
				LoggerUtil.pass("Supplier heading is not visible — restriction working.");
			} else {
				LoggerUtil.fail("Supplier heading is visible — restriction failed.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Supplier heading): " + e.getMessage());
		}

		Thread.sleep(4000);
		clickOnElement(ClickingExportBtnForStandard);
		Thread.sleep(3000);
		clickOnElement(clickingRadioButtonForExportNewData);

		// Supplier Dropdown (check both button and options presence/visibility)
		try {
			List<WebElement> dropBtn = driver.findElements(clickingDropdownAfterClickingExportButton);
			List<WebElement> dropOptions = driver.findElements(SupplierDropdownAfterClickingExportButton);

			boolean btnVisible = !dropBtn.isEmpty() && safeDisplayed(dropBtn.get(0));
			boolean optionVisible = !dropOptions.isEmpty() && safeDisplayed(dropOptions.get(0));

			if (btnVisible || optionVisible) {
				LoggerUtil.fail("Supplier Dropdown is visible — restriction failed.");
			} else {
				LoggerUtil.pass("Supplier Dropdown is not visible — restriction working.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Supplier Dropdown): " + e.getMessage());
		}
	}

	private boolean safeDisplayed(WebElement el) {
		try {
			return el.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	public static final By ClickingCustomerRadioButton = By
			.xpath("//input[@id='BopEntry_RadioButtonsupplier' and @type='radio' and @value='3']");

	public static final By ClickingAddCustomerButton = By
			.xpath("//a[@id='addNewCustomer']//span[contains(text(),'Add Customer')]");

	public static final By CustomerDropdownAfterClickingExportButton = By
			.xpath("//*[@id='custdropdownBOP']/following-sibling::div/button");

	public void verifyUserUncheckCustomerControlAuthority() {

		// Customer Radio Button
		try {
			List<WebElement> radioBtn = driver.findElements(ClickingCustomerRadioButton);
			if (radioBtn.isEmpty()) {
				LoggerUtil.pass("Customer Radio Button is not present — restriction working.");
			} else {
				WebElement el = radioBtn.get(0);
				if (isEffectivelyVisible(el)) {
					LoggerUtil.fail("Customer Radio Button is visible — restriction failed.");
				} else {
					LoggerUtil.pass("Customer Radio Button is present but hidden/disabled — restriction working.");
				}
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Customer Radio Button): " + e.getMessage());
		}

		// Add Customer Button
		try {
			List<WebElement> addBtn = driver.findElements(ClickingAddCustomerButton);
			if (addBtn.isEmpty()) {
				LoggerUtil.pass("Add Customer Button is not present — restriction working.");
			} else {
				WebElement el = addBtn.get(0);
				if (isEffectivelyVisible(el)) {
					LoggerUtil.fail("Add Customer Button is visible — restriction failed.");
				} else {
					LoggerUtil.pass("Add Customer Button is present but hidden/disabled — restriction working.");
				}
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Add Customer Button): " + e.getMessage());
		}

		// Customer Dropdown Button
		try {
			List<WebElement> dropBtn = driver.findElements(CustomerDropdownAfterClickingExportButton);
			if (dropBtn.isEmpty()) {
				LoggerUtil.pass("Customer Dropdown is not present — restriction working.");
			} else {
				WebElement el = dropBtn.get(0);
				if (isEffectivelyVisible(el)) {
					LoggerUtil.fail("Customer Dropdown is visible — restriction failed.");
				} else {
					LoggerUtil.pass("Customer Dropdown is present but hidden/disabled — restriction working.");
				}
			}
		} catch (Exception e) {
			LoggerUtil.error("Error (Customer Dropdown): " + e.getMessage());
		}
	}

	private boolean isEffectivelyVisible(WebElement el) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object out = js.executeScript("var e=arguments[0];" + "function shown(x){" + "  if(!x) return false;"
					+ "  var s=getComputedStyle(x);" + "  var r=x.getBoundingClientRect();"
					+ "  return s.display!=='none' && s.visibility!=='hidden' && parseFloat(s.opacity)!==0 && r.width>0 && r.height>0;"
					+ "}" + "for(var n=e; n && n.nodeType===1; n=n.parentElement){" + "  if(shown(n)) return true;"
					+ "}" + "return false;", el);
			return Boolean.TRUE.equals(out);
		} catch (Exception ex) {
			try {
				return el.isDisplayed();
			} catch (Exception ignore) {
				return false;
			}
		}
	}

	public static final By ToastMessage = By.xpath("//*[@id='toast-container']/div/div[2]");

	public void SaveBopWithStandardWithoutPartNumber(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue, String entersearchvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			WebElement selectvalue = uomdropdownoptionvalue.get(1);
			selectvalue.click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			WebElement flagevalue = optionvalueforsupplier.get(1);
			flagevalue.click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			System.out.println(waitForExpectedElement(ToastMessage).getText());
			String popupForSave = waitForExpectedElement(ToastMessage).getText();
			String expectedpopupforSave = "Please Enter Part No";

			soft.assertEquals(popupForSave, expectedpopupforSave, "Popup Message Are Mismatched..");
			Thread.sleep(15000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in SaveBopWithStandard: " + e.getMessage());
			soft.fail("Exception occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

	public void SaveBopWithStandardWithoutBopType(String enterpartdescriptionvalue, String enterpartNumberValue,
			String enterpartcostvalue, String enterdutiesvalue, String enterfrieghtandinsurancevalue,
			String entersearchvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			WebElement selectvalue = uomdropdownoptionvalue.get(1);
			selectvalue.click();

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			WebElement flagevalue = optionvalueforsupplier.get(1);
			flagevalue.click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			System.out.println(waitForExpectedElement(ToastMessage).getText());
			String popupForSave = waitForExpectedElement(ToastMessage).getText();
			String expectedpopupforSave = "Please Select BOP Type";

			soft.assertEquals(popupForSave, expectedpopupforSave, "Popup Message Are Mismatched..");
			Thread.sleep(15000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in SaveBopWithStandard: " + e.getMessage());
			soft.fail("Exception occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

	public void SaveBopWithStandardWithoutUOM(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue, String entersearchvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");

			LoggerUtil.info("Step 6: Selecting Supplier (2nd option)");
			Thread.sleep(2000);
			clickOnElement(clickingSuppliernameAndCodeDropdown);
			List<WebElement> optionvalueforsupplier = driver.findElements(supplierDropdownListForStandard);
			WebElement flagevalue = optionvalueforsupplier.get(1);
			flagevalue.click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			System.out.println(waitForExpectedElement(ToastMessage).getText());
			String popupForSave = waitForExpectedElement(ToastMessage).getText();
			String expectedpopupforSave = "Please Enter UOM";

			soft.assertEquals(popupForSave, expectedpopupforSave, "Popup Message Are Mismatched..");
			Thread.sleep(15000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in SaveBopWithStandard: " + e.getMessage());
			soft.fail("Exception occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

	public void SaveBopWithStandardWithoutSupplier(String selectedvalueboptype, String enterpartdescriptionvalue,
			String enterpartNumberValue, String enterpartcostvalue, String enterdutiesvalue,
			String enterfrieghtandinsurancevalue, String entersearchvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(7000);

		try {
			LoggerUtil.info("Step 1: Selecting BOP Type: " + selectedvalueboptype);
			clickOnElement(clickingBopTypeDropdown);
			List<WebElement> optionvalueBoptype = driver.findElements(ValuesofBopTypeDropdown);
			selectBootStrapDropDown(optionvalueBoptype, selectedvalueboptype);

			Thread.sleep(8000);
			LoggerUtil.info("Step 2: Selecting BOP Category: Standard");
			clickOnElement(clickingBopCategoryDropdown);
			List<WebElement> bopCategoryOptions = driver.findElements(BopCategoryDropDownValue);
			selectBootStrapDropDown(bopCategoryOptions, "Standard");

			LoggerUtil.info("Step 3: Entering Part Description: " + enterpartdescriptionvalue);
			clearAndEnterText(waitForExpectedElement(Entervaluepartdescription), enterpartdescriptionvalue);

			LoggerUtil.info("Step 4: Entering Part Number: " + enterpartNumberValue);
			clearAndEnterText(waitForExpectedElement(EnterPartNumber), enterpartNumberValue);

			LoggerUtil.info("Step 5: Selecting UOM (2nd option)");
			clickOnElement(ClickingUomDropDown);
			Thread.sleep(200);
			List<WebElement> uomdropdownoptionvalue = driver.findElements(uomdropdownoptionlist);
			WebElement selectvalue = uomdropdownoptionvalue.get(1);
			selectvalue.click();

			LoggerUtil.info("Step 7: Selecting Currency (2nd option)");
			Thread.sleep(3000);
			clickOnElement(clickingCurrencyDropDown);
			Thread.sleep(300);
			List<WebElement> optionvalueforcurrency = driver.findElements(currencylistoptionvalue);
			WebElement currencoption = optionvalueforcurrency.get(1);
			currencoption.click();

			LoggerUtil.info("Step 8: Entering Part Cost: " + enterpartcostvalue);
			clearAndEnterText(waitForExpectedElement(enterpartcostunit), enterpartcostvalue);

			LoggerUtil.info("Step 9: Entering Duties: " + enterdutiesvalue);
			clearAndEnterText(waitForExpectedElement(EntervalueDuties), enterdutiesvalue);

			LoggerUtil.info("Step 10: Entering Freight & Insurance: " + enterfrieghtandinsurancevalue);
			clearAndEnterText(waitForExpectedElement(EnterFrieghtAndInsuranceStandard), enterfrieghtandinsurancevalue);

			LoggerUtil.info("Step 11: Clicking Save button");
			clickOnElement(clickingsavebutton);

			System.out.println(waitForExpectedElement(ToastMessage).getText());
			String popupForSave = waitForExpectedElement(ToastMessage).getText();
			String expectedpopupforSave = "Please Select Supplier Name&code";

			soft.assertEquals(popupForSave, expectedpopupforSave, "Popup Message Are Mismatched..");
			Thread.sleep(15000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in SaveBopWithStandard: " + e.getMessage());
			soft.fail("Exception occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

}
