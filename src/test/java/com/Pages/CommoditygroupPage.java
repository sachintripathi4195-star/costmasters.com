package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelFiller;
import com.helper.LoggerUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class CommoditygroupPage extends Base {

	Faker faker = new Faker();

	DashboardPage dashboard = new DashboardPage();
	
	public static String commodityGroup;
	public static String groupClassification;
	public static String specificGrade;
	public static String density;

	public static final By commoditygrouptab = By.xpath("//div[@id='exTab3']/ul/li[2]/a");
	public static final By clickcommoditygroupdrop = By.xpath("//span[@id='select2-commodityDropdown-container']");
	// public static final By droplist =
	// By.xpath("//select[@id='commodityDropdown']");
	public static final By groupclassfication = By.xpath("//input[@id='subGroupClassification']");
	public static final By specificgradevalue = By.xpath("//input[@id='SpecificGradeText']");
	public static final By Density = By.xpath("//input[@id='groupDensity']");
	public static final By savebtn = By.xpath("//button[@id='tab2Save']");
	public static final By toastmessage = By.xpath("//div[contains (@class,'toast-message')]");
	public static final By updatebtn = By.xpath("//button[@id='tab2Save']");
	public static final By searchbox = By.xpath("(//input[contains(@type,'search')])[2]");

	public void savenewcommoditygroup(String options, String groupClassification, String specificGrade, String density,
			String expectedMessage) throws InterruptedException {

		LoggerUtil.info("STEP 4: Navigating to Commodity Group tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Selecting Commodity from dropdown.");
		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		boolean foundDrodownvalue = false;
		for (WebElement comdropoptions : values) {

			String actualvalues = comdropoptions.getText().trim();

			if (actualvalues.equals(options)) {

				foundDrodownvalue = true;
				comdropoptions.click();
				break;

			}

			if (!foundDrodownvalue) {

				return;

			}

		}

		LoggerUtil.info("STEP 6: Entering Group Classification: " + groupClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), groupClassification);
		Thread.sleep(200);

		LoggerUtil.info("STEP 7: Entering Specific Grade: " + specificGrade);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		Thread.sleep(200);

		LoggerUtil.info("STEP 8: Entering Density: " + density);
		clearAndEnterText(waitForExpectedElement(Density), density);
		Thread.sleep(1000);

		LoggerUtil.info("STEP 9: Clicking Save.");
		clickOnElement(savebtn);

		LoggerUtil.info("STEP 10: Verifying success toast message.");
		String actualToast = waitForExpectedElement(toastmessage).getText().trim();
		LoggerUtil.info("→ Expected Toast: " + expectedMessage);
		LoggerUtil.info("→ Actual Toast: " + actualToast);
		Assert.assertTrue(actualToast.contains(expectedMessage), "❌ Toast validation failed!");
	}

	public static final By editbtn = By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[6]/a[1]/i");

	// In: com.costmaster.RawMaterial.Pages.CommodityGroupPage.java
	public void editAndUpdateExistingEntry(String dropdownOption, String groupClassification, String specificGrade,
			String density, String searchValue, String updatedClassification, String expectedToast)
			throws InterruptedException {

		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Open 'Commodity' dropdown and select option → " + dropdownOption);
		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		boolean foundDropdownValue = false;
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		for (WebElement opt : options) {
			String actual = opt.getText().trim();
			if (actual.equals(dropdownOption)) {
				opt.click();
				foundDropdownValue = true;
				LoggerUtil.pass("Dropdown value selected → " + actual);
				break;
			}
		}
		if (!foundDropdownValue) {
			return;
		}

		Thread.sleep(3000);

		LoggerUtil.info("STEP 6: Enter Group Classification.");
		clearAndEnterText(waitForExpectedElement(groupclassfication), groupClassification);
		LoggerUtil.pass("Entered Group Classification → " + groupClassification);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 7: Enter Specific Grade.");
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		LoggerUtil.pass("Entered Specific Grade → " + specificGrade);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 8: Enter Density.");
		clearAndEnterText(waitForExpectedElement(Density), density);
		LoggerUtil.pass("Entered Density → " + density);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 9: Click Save.");
		clickOnElement(savebtn);
		Thread.sleep(9000);

		driver.navigate().refresh();
		Thread.sleep(6000);

		LoggerUtil.info("STEP 10: Search saved entry → " + searchValue);
		clearAndEnterText(waitForExpectedElement(searchbox), searchValue);
		LoggerUtil.pass("Search typed → " + searchValue);
		Thread.sleep(5000);

		LoggerUtil.info("STEP 11: Click Edit icon for the searched row.");
		clickOnElement(editbtn);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 12: Update Group Classification.");
		clearAndEnterText(waitForExpectedElement(groupclassfication), updatedClassification);
		LoggerUtil.pass("Updated Group Classification → " + updatedClassification);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 13: Click Update to save changes.");
		clickOnElement(updatebtn);
		Thread.sleep(2000);

		String actualToast = waitForExpectedElement(toastmessage).getText().trim();
		LoggerUtil.info("Toast validation → Expected: " + expectedToast + " | Actual: " + actualToast);

		if (actualToast.contains(expectedToast)) {
			LoggerUtil.pass("PASS: Toast matched the expectation.");
		} else {
			LoggerUtil.fail("FAIL: Toast mismatch → Expected contains: " + expectedToast + " | Actual: " + actualToast);
		}
		Assert.assertTrue(actualToast.contains(expectedToast), "Toast did not contain expected text.");
	}

	public static final By saveAsnewbtn = By.xpath("//button[@id='tab2SaveAsNew']");
	public static final By verificationingroupclassificationtable = By
			.xpath("//table[@id='SubGroupTable']/tbody/tr/td[3]");

	public void EditAndsaveAsnew(String dropdownOption, String groupClassification, String specificGrade,
			String density, String searchValue, String updatedClassification, String verifySearchValue)
			throws InterruptedException {

		LoggerUtil.info("STEP 4: Navigate to 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Select Commodity from dropdown.");

		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		boolean foundDropdownValue = false;
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		for (WebElement opt : options) {
			String actual = opt.getText().trim();
			if (actual.equals(dropdownOption)) {
				opt.click();
				foundDropdownValue = true;
				LoggerUtil.pass("Dropdown value selected → " + actual);
				break;
			}
		}
		if (!foundDropdownValue) {
			return;
		}

		LoggerUtil.info("STEP 6: Entering Group Classification: " + groupClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), groupClassification);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 7: Entering Specific Grade: " + specificGrade);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 8: Entering Density: " + density);
		clearAndEnterText(waitForExpectedElement(Density), density);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 9: Clicking Save.");
		clickOnElement(savebtn);
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		LoggerUtil.info("STEP 10: Searching entry to edit using: " + searchValue);
		clearAndEnterText(waitForExpectedElement(searchbox), searchValue);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 11: Clicking Edit.");
		clickOnElement(editbtn);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 12: Updating Group Classification to: " + updatedClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), updatedClassification);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 13: Clicking 'Save As New'.");
		clickOnElement(saveAsnewbtn);
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(4000);
		LoggerUtil.info("STEP 14: Searching to verify Save As New using: " + verifySearchValue);
		clearAndEnterText(waitForExpectedElement(searchbox), verifySearchValue);
		Thread.sleep(3000);

		String actualValue = waitForExpectedElement(verificationingroupclassificationtable).getText().trim();
		String expectedValue = verifySearchValue;
		LoggerUtil.info("→ Expected Classification: " + expectedValue);
		LoggerUtil.info("→ Actual Classification from Table: " + actualValue);

		Assert.assertEquals(actualValue, expectedValue, "❌ Save As New entry does not match!");
		LoggerUtil.info("✅ Save As New entry verified successfully.");

		captureStepScreenshot("verifySaveAsnewData");
	}

	public void verifysaveduplicatespecificgrade(String dropdownOption,String firstGroupClassification, String firstDensity,String dropdownOption2
			,String secondGroupClassification, String secondDensity) throws InterruptedException {

		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Select Commodity from dropdown.");

		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		boolean foundDropdownValue = false;
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		for (WebElement opt : options) {
			String actual = opt.getText().trim();
			if (actual.equals(dropdownOption)) {
				opt.click();
				foundDropdownValue = true;
				LoggerUtil.pass("Dropdown value selected → " + actual);
				break;
			}
		}
		if (!foundDropdownValue) {
			return;
		}


		LoggerUtil.info("STEP 6: Entering data for first commodity group:");
		LoggerUtil.info("→ Group Classification: " + firstGroupClassification);
		LoggerUtil.info("→ Specific Grade: Ram");
		LoggerUtil.info("→ Density: " + firstDensity);
		clearAndEnterText(waitForExpectedElement(groupclassfication), firstGroupClassification);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), "Ram");
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(Density), firstDensity);
		clickOnElement(savebtn);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Select Commodity from dropdown.");

		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		boolean foundDropdownValue1 = false;
		List<WebElement> options1 = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		for (WebElement opt : options1) {
			String actual = opt.getText().trim();
			if (actual.equals(dropdownOption2)) {
				opt.click();
				foundDropdownValue1 = true;
				LoggerUtil.pass("Dropdown value selected → " + actual);
				break;
			}
		}
		if (!foundDropdownValue1) {
			return;
		}


		LoggerUtil.info("STEP 8: Entering data for second commodity group (duplicate Specific Grade):");
		LoggerUtil.info("→ Group Classification: " + secondGroupClassification);
		LoggerUtil.info("→ Specific Grade: Ram");
		LoggerUtil.info("→ Density: " + secondDensity);
		clearAndEnterText(waitForExpectedElement(groupclassfication), secondGroupClassification);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), "Ram");
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(Density), secondDensity);

		LoggerUtil.info("STEP 9: Attempt to save entry with duplicate Specific Grade.");
		clickOnElement(savebtn);

// Optional: Validate popup/message for duplicate entry
		WebElement toast = waitForExpectedElement(toastmessage); // Adjust locator if needed
		String toastText = toast.getText().trim();
		LoggerUtil.info("Toast Message Received: " + toastText);
		Assert.assertTrue(toastText.contains("already exists") || toastText.contains("duplicate"),
				"❌ No duplicate validation message displayed.");

		LoggerUtil.info("✅ Duplicate validation message verified successfully.");
	}

	public static final By exportbtn = By.xpath("//button[@id='tab2Export']");

	public void saveDataAndExportWithExcelFile(String entergroupclsficationvalue, String Denvalue)
			throws InterruptedException {

		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);
		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));

		WebElement comgrp = values.get(1);
		comgrp.click();

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(groupclassfication), entergroupclsficationvalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), "-33");
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(Density), Denvalue);
		captureStepScreenshot("capture puicture negative number");
		clickOnElement(savebtn);
		Thread.sleep(3000);

	}

	public void specialcharacterInGroupclassfication(String specificGrade, String density, String expectedMessage)
			throws InterruptedException {

		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Open dropdown and select Commodity 'ABC'.");
		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		WebElement flagvalue = options.get(1);
		flagvalue.click();

		Thread.sleep(3000);

		LoggerUtil.info("STEP 6: Enter special characters in 'Group Classification': @@@@");
		clearAndEnterText(waitForExpectedElement(groupclassfication), "@@@@");
		Thread.sleep(2000);

		LoggerUtil.info("STEP 7: Enter valid Specific Grade: " + specificGrade);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 8: Enter valid Density: " + density);
		clearAndEnterText(waitForExpectedElement(Density), density);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 10: Click Save to trigger validation.");
		clickOnElement(savebtn);

		LoggerUtil.info("STEP 11: Verifying validation toast message for special character entry.");
		String actualMessage = waitForExpectedElement(toastmessage).getText().trim();
		LoggerUtil.info("→ Expected Message: " + expectedMessage);
		LoggerUtil.info("→ Actual Message: " + actualMessage);

		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"❌ Validation message mismatch for special character.");
		LoggerUtil.info("✅ Validation message correctly triggered for special character in Group Classification.");
	}

	public static final By serialnumber = By.xpath("//table[@id='SubGroupTable']/thead/tr/th[1]");
	// public static final By serialnumbercolumn =
	// By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[1]");
	public static final By CommodityGroupheader = By.xpath("//table[@id='SubGroupTable']/thead/tr/th[2]");
	public static final By GroupClassificationheader = By.xpath("//table[@id='SubGroupTable']/thead/tr/th[3]");

	public void verifysorting() {
		
		SoftAssert soft = new SoftAssert();
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
				Thread.sleep(2000);
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			// -------- Sort by S.No (1st column) --------
			LoggerUtil.info("STEP 5: Click on 'S.No' column header to sort descending.");
			try {
				Base.clickOnElement(serialnumber);
				Thread.sleep(2000);

				List<WebElement> columnCells = Base.driver
						.findElements(By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[1]"));
				List<String> actualList = columnCells.stream().map(e -> e.getText().trim())
						.collect(Collectors.toList());

				List<String> expectedList = new ArrayList<>(actualList);
				Collections.sort(expectedList, Collections.reverseOrder());

				LoggerUtil.info("STEP 6: Comparing actual vs expected S.No descending order.");
				soft.assertEquals(actualList, expectedList,
						"❌ S.No column is not sorted in descending order.\nActual: " + actualList + "\nExpected: "
								+ expectedList);
				LoggerUtil.pass("S.No column is sorted correctly in descending order.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed in S.No sorting: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Failed while validating S.No sorting.");
				throw e;
			}

			// -------- Sort by Commodity Group (2nd column) --------
			LoggerUtil.info("STEP 7: Refresh and sort by 'Commodity Group'.");
			try {
				Base.driver.navigate().refresh();
				Thread.sleep(2000);

				Base.clickOnElement(CommodityGroupheader);
				Base.clickOnElement(CommodityGroupheader); // second click for descending
				Thread.sleep(2000);

				List<WebElement> columnCells1 = Base.driver
						.findElements(By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[2]"));
				List<String> actualList1 = columnCells1.stream().map(e -> e.getText().trim())
						.collect(Collectors.toList());

				List<String> expectedList1 = new ArrayList<>(actualList1);
				Collections.sort(expectedList1, Collections.reverseOrder());

				LoggerUtil.info("STEP 8: Verifying 'Commodity Group' descending sort.");
				soft.assertEquals(actualList1, expectedList1,
						"❌ Commodity Group column is not sorted in descending order.\nActual: " + actualList1
								+ "\nExpected: " + expectedList1);
				LoggerUtil.pass("Commodity Group column is sorted correctly in descending order.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed in Commodity Group sorting: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Failed while validating Commodity Group sorting.");
				throw e;
			}

			// -------- Sort by Group Classification (3rd column) --------
			LoggerUtil.info("STEP 9: Refresh and sort by 'Group Classification'.");
			try {
				Base.driver.navigate().refresh();
				Thread.sleep(2000);

				Base.clickOnElement(GroupClassificationheader);
				Base.clickOnElement(GroupClassificationheader); // second click for descending
				Thread.sleep(2000);

				List<WebElement> columnCells2 = Base.driver
						.findElements(By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[3]"));
				List<String> actualList2 = columnCells2.stream().map(e -> e.getText().trim().toLowerCase())
						.collect(Collectors.toList());

				List<String> expectedList2 = new ArrayList<>(actualList2);
				Collections.sort(expectedList2, Collections.reverseOrder());

				LoggerUtil.info("STEP 10: Verifying 'Group Classification' descending sort.");
				LoggerUtil.info("→ Actual Data: " + actualList2);
				LoggerUtil.info("→ Expected Sorted Descending: " + expectedList2);

				soft.assertEquals(actualList2, expectedList2,
						"❌ Group Classification column is not sorted in descending order.\nActual: " + actualList2
								+ "\nExpected: " + expectedList2);
				LoggerUtil.pass("Group Classification column is sorted correctly in descending order.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed in Group Classification sorting: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Failed while validating Group Classification sorting.");
				throw e;
			}

			LoggerUtil.info("✅ All table sorting validations passed successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifysorting: " + e.getMessage());
			e.printStackTrace();
		}
		soft.assertAll();
	}

	public static final By nextpageverification = By.xpath("//table[@id='SubGroupTable']/tbody/tr[1]/td[1]");
	public static final By nextpagebtn = By
			.xpath("//div[contains(@id,'SubGroupTable_paginate')]/ul/li[contains(@id,'SubGroupTable_next')]");

	public void verifypagination() {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Base.waitForExpectedElement(commoditygrouptab);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Click on 'Next Page' button to go to page 2.");
			try {
				Base.clickOnElement(nextpagebtn);
				LoggerUtil.pass("Next Page button clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Next Page button.");
				throw e;
			}

			LoggerUtil.info("STEP 6: Validate if table navigated to next page.");
			try {
				String actualValue = Base.waitForExpectedElement(nextpageverification).getText().trim();
				String expectedValue = "26"; // assumed first record number on page 2

				LoggerUtil.info("→ Expected first entry on next page: " + expectedValue);
				LoggerUtil.info("→ Actual value from page: " + actualValue);

				Assert.assertEquals(actualValue, expectedValue,
						"❌ Pagination failed: Next page did not load expected data.");
				LoggerUtil.pass("Pagination to next page validated successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while validating pagination: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while validating pagination.");
				throw e;
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifypagination: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By searchfiltertabledata = By.xpath("//table[@id='SubGroupTable']/tbody/tr[1]/td[3]");

	public void VerifysearchFilter(String options,String grpClassificationVal, String specGradeVal, String densityVal,
			String searchVal) throws InterruptedException {
		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Selecting Commodity from dropdown.");
		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		boolean foundDrodownvalue = false;
		for (WebElement comdropoptions : values) {

			String actualvalues = comdropoptions.getText().trim();

			if (actualvalues.equals(options)) {

				foundDrodownvalue = true;
				comdropoptions.click();
				break;

			}

			if (!foundDrodownvalue) {

				return;

			}

		}
		LoggerUtil.info("STEP 6: Fill and save a new commodity group entry.");
		LoggerUtil.info("→ Group Classification: " + grpClassificationVal);
		LoggerUtil.info("→ Specific Grade: " + specGradeVal);
		LoggerUtil.info("→ Density: " + densityVal);
		clearAndEnterText(waitForExpectedElement(groupclassfication), grpClassificationVal);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specGradeVal);
		clearAndEnterText(waitForExpectedElement(Density), densityVal);
		clickOnElement(savebtn);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 7: Search the saved entry using: " + searchVal);
		clearAndEnterText(waitForExpectedElement(searchbox), searchVal);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 8: Verifying if search result matches expected value.");
		String actualValue = waitForExpectedElement(searchfiltertabledata).getText().trim();
		String expectedValue = searchVal;

		LoggerUtil.info("→ Expected Value: " + expectedValue);
		LoggerUtil.info("→ Actual Value from Table: " + actualValue);

		Assert.assertEquals(actualValue, expectedValue, "❌ Search result mismatch.");

		LoggerUtil.info("✅ Search functionality working as expected for input: " + searchVal);
		// Optional Screenshot
		
	}

	public static final By verifybtn = By.xpath("//div[@id='exTab3']/ul/li/following::a");
	public static final By backtotopbtn = By.xpath("//div[@id='back-to-top']");

	public void verifybackTotopbtn() {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 980);");

			LoggerUtil.info("STEP 5: Click on 'Back To Top' button.");
			try {
				Base.clickOnElement(backtotopbtn);
				Thread.sleep(2000);
				LoggerUtil.pass("Back To Top button clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Back To Top button.");
				throw e;
			}

			LoggerUtil.info(
					"STEP 6: Verify if user has been scrolled to the top by checking visibility of 'Commodity Group' header.");
			try {
				String actualValue = Base.waitForExpectedElement(verifybtn).getText().trim();
				String expectedValue = "Commodity Group";

				LoggerUtil.info("→ Expected Header Text: " + expectedValue);
				LoggerUtil.info("→ Actual Header Text: " + actualValue);

				Assert.assertEquals(actualValue, expectedValue,
						"❌ Back to Top button did not scroll to the expected section.");
				LoggerUtil.pass("Back To Top functionality verified successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying Back To Top button: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying Back To Top button.");
				throw e;
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifybackTotopbtn: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyautofilleddensity(String options,String groupClassification, String gradeVal, String densityVal,
			String searchKeyword) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Open dropdown and select Commodity: ABC");
			LoggerUtil.info("STEP 5: Selecting Commodity from dropdown.");
			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
			boolean foundDrodownvalue = false;
			for (WebElement comdropoptions : values) {

				String actualvalues = comdropoptions.getText().trim();

				if (actualvalues.equals(options)) {

					foundDrodownvalue = true;
					comdropoptions.click();
					break;

				}

				if (!foundDrodownvalue) {

					return;

				}

			}

			LoggerUtil.info("STEP 6: Save new entry for Group Classification.");
			try {
				LoggerUtil.info("→ Group Classification: " + groupClassification);
				LoggerUtil.info("→ Specific Grade: " + gradeVal);
				LoggerUtil.info("→ Density: " + densityVal);

				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClassification);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), gradeVal);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), densityVal);
				Base.clickOnElement(savebtn);
				Thread.sleep(4000);
				driver.navigate().refresh();
				Thread.sleep(6000);
				LoggerUtil.pass("New entry saved successfully with given Group Classification, Grade, and Density.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed while entering/saving new Group Classification details.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Search and click Edit to verify if Density auto-fills.");
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(searchbox), searchKeyword);
				Thread.sleep(2000);
				Base.clickOnElement(editbtn);
				Thread.sleep(2000);
				LoggerUtil.pass("Edit button clicked successfully for searched entry.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed while searching and clicking Edit.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Verify Density auto-filled correctly.");
			try {
				String actualDensity = Base.waitForExpectedElement(Density).getAttribute("value").trim();
				LoggerUtil.info("→ Expected Density: " + densityVal);
				LoggerUtil.info("→ Actual Density: " + actualDensity);

				Assert.assertEquals(actualDensity, densityVal, "❌ Density value did not auto-fill as expected.");
				LoggerUtil.pass("Density auto-filled correctly in Edit form.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while validating Density autofill: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception while verifying Density autofill.");
				throw e;
			}

			LoggerUtil.info("✅ Density autofill verification completed successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifyautofilleddensity: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void exportdeta() {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(2000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Click on Export button to download Excel template.");
			try {
				Base.clickOnElement(exportbtn);
				Thread.sleep(10000); // wait for file to download
				LoggerUtil.pass("Export button clicked successfully. Excel template download initiated.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click Export button or download did not start.");
				throw e;
			}

			LoggerUtil.info("STEP 6: Fill values manually in the downloaded Excel.");
			try {
				importNewCommoditymasterExcel(); // this internally fills and imports
				LoggerUtil.pass("Excel file filled and imported successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed while filling/importing Excel file.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Validate successful import.");
			try {
				// Add validation logic if import shows a toast or confirmation message
				LoggerUtil.pass("Manual entry import validation completed successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed while validating import after Excel upload.");
				throw e;
			}

			LoggerUtil.info("✅ Export and import functionality tested successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in exportdeta: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String fillCommoditySheet() {
		File latestFile = getLatestNewSpecificGradeFileForCommodityGroup();
		if (latestFile == null) {
			System.out.println("No SupplierMaster file found.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();

		// Values to write
		commodityGroup = "Ferrous Metals";
		groupClassification = faker.name().firstName();
		specificGrade = "Anuij";
		density = String.valueOf(faker.number().randomDouble(2, 1, 15));

		// Log values being written
		LoggerUtil.info("Writing to Excel:");
		System.out.println("Commodity Group: " + commodityGroup);
		LoggerUtil.info("Commodity Group: " + commodityGroup);
		System.out.println("Group Classification: " + groupClassification);
		LoggerUtil.info("Group Classification: " + groupClassification);
		System.out.println("Specific Grade: " + specificGrade);
		LoggerUtil.info("Specific Grade: " + specificGrade);
		System.out.println("Density: " + density);
		LoggerUtil.info("Density: " + density);

		// Write values (make sure your ExcelFiller closes file properly internally)
		ExcelFiller.writeExactCellValue(filePath, 0, 3, 1, commodityGroup);
		ExcelFiller.writeExactCellValue(filePath, 0, 3, 2, groupClassification);
		ExcelFiller.writeExactCellValue(filePath, 0, 3, 3, specificGrade);
		ExcelFiller.writeExactCellValue(filePath, 0, 3, 4, density);

		// Verify contents
		verifyCommoditySheet(filePath);

		System.out.println("Excel filled successfully: " + filePath);
		return latestFile.getName();
	}

	public void importNewCommoditymasterExcel() throws InterruptedException {
		String fileName = fillCommoditySheet();
		String fullPath = System.getProperty("user.dir") + "/downloads/" + fileName;

		LoggerUtil.info("→ File prepared: " + fileName);
		File file = new File(fullPath);
		if (!file.exists()) {
			LoggerUtil.info("❌ File not found at: " + fullPath);
			return;
		}

		LoggerUtil.info("STEP 8: Uploading the file via input.");
		WebElement fileInput = driver.findElement(By.id("attachmentcommodity"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
		fileInput.sendKeys(fullPath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(fileInput, "value"));
	}

	public void verifyCommoditySheet(String filePath) {
		try {
			LoggerUtil.info("STEP 1: Start verifying written Excel data at path: " + filePath);

			boolean isCommodityGroupCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 1, commodityGroup);
			boolean isGroupClassificationCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 2, groupClassification);
			boolean isSpecificGradeCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 3, specificGrade);
			boolean isDensityCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 4, density);

			LoggerUtil.info("STEP 2: Expected vs Actual Value Check:");

			if (isCommodityGroupCorrect) {
				LoggerUtil.pass("Commodity Group value MATCHED.");
			} else {
				LoggerUtil.fail("Commodity Group value MISMATCH.");
			}

			if (isGroupClassificationCorrect) {
				LoggerUtil.pass("Group Classification value MATCHED.");
			} else {
				LoggerUtil.fail("Group Classification value MISMATCH.");
			}

			if (isSpecificGradeCorrect) {
				LoggerUtil.pass("Specific Grade value MATCHED.");
			} else {
				LoggerUtil.fail("Specific Grade value MISMATCH.");
			}

			if (isDensityCorrect) {
				LoggerUtil.pass("Density value MATCHED.");
			} else {
				LoggerUtil.fail("Density value MISMATCH.");
			}

			if (isCommodityGroupCorrect && isGroupClassificationCorrect && isSpecificGradeCorrect && isDensityCorrect) {
				LoggerUtil.info("✅ All Excel values verified successfully.");
			} else {
				LoggerUtil.error("❌ One or more Excel values did not match expected results.");
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifyCommoditySheet: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By clickcommoditydropdownthirdtab = By.xpath("//*[@id='select2-commodityDrop-container']");
	public static final By searchimimportvaluesecondtab = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By commoditydroplistthirdtab = By.xpath("//ul[@id='select2-commodityDrop-results']/li");
	public static final By groupclassificationdropdown = By.xpath("//span[@id='select2-materialDrop-container']");
	public static final By searchgroupclassification = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By groupclassificationlist = By.xpath("//ul[@id='select2-materialDrop-results']/li");

	public void verifycomoditysheetTocommodityDetails(String filePath) {
		try {
			LoggerUtil.info("STEP 1: Open Commodity dropdown in third tab.");
			try {
				Base.clickOnElement(clickcommoditydropdownthirdtab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity dropdown opened successfully in third tab.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to open Commodity dropdown in third tab.");
				throw e;
			}

			LoggerUtil.info("STEP 2: Search imported Commodity Group: " + commodityGroup);
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(searchimimportvaluesecondtab), commodityGroup);
				Thread.sleep(1000);
				LoggerUtil.pass("Entered Commodity Group in search box successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter Commodity Group in search box.");
				throw e;
			}

			LoggerUtil.info("STEP 3: Validate if imported Commodity Group appears in dropdown list.");
			boolean valueFound = false;
			try {
				List<WebElement> comlist = Base.driver.findElements(commoditydroplistthirdtab);
				for (WebElement comgrpvalue : comlist) {
					String flagcomgrpval = comgrpvalue.getText().trim();
					if (flagcomgrpval.equalsIgnoreCase(commodityGroup)) {
						comgrpvalue.click();
						LoggerUtil.pass("Selected Commodity from dropdown: " + flagcomgrpval);
						valueFound = true;
						break;
					}
				}
				if (!valueFound) {
					return;
				}
			} catch (Exception e) {
				LoggerUtil.fail("Exception while validating Commodity Group in dropdown.");
				throw e;
			}

			LoggerUtil.info("STEP 4: Open Group Classification dropdown in third tab.");
			boolean isSelected = false;
			try {
				WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(groupclassificationdropdown)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(groupclassificationlist));
				LoggerUtil.pass("Group Classification dropdown opened successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to open Group Classification dropdown.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Validate imported Group Classification value: " + groupClassification);
			try {
				List<WebElement> grpclasslist = Base.driver.findElements(groupclassificationlist);
				for (WebElement grpclasslistval : grpclasslist) {
					String comclssifi = grpclasslistval.getText().trim();
					if (comclssifi.equalsIgnoreCase(groupClassification) && comclssifi.matches(groupClassification)) {
						grpclasslistval.click();
						LoggerUtil.pass("Selected Group Classification in third tab: " + groupClassification);
						isSelected = true;
						break;
					}
				}
				if (!isSelected) {
					LoggerUtil.fail("Group Classification value not found: " + groupClassification);
					LoggerUtil.error("Imported values not found in Commodity Details Tab.");
				}
			} catch (Exception e) {
				LoggerUtil.fail("Exception while validating Group Classification dropdown.");
				throw e;
			}

			if (valueFound && isSelected) {
				LoggerUtil.info("✅ Commodity and Group Classification successfully verified in Commodity Details tab.");
			} else {
				LoggerUtil.error("❌ One or more imported values could not be verified in Commodity Details tab.");
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifycomoditysheetTocommodityDetails: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clicksavebutton(String options,String groupClassification, String gradeVal, String density, String expectedMessage) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}
			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
			boolean foundDrodownvalue = false;
			for (WebElement comdropoptions : values) {

				String actualvalues = comdropoptions.getText().trim();

				if (actualvalues.equals(options)) {

					foundDrodownvalue = true;
					comdropoptions.click();
					break;

				}

				if (!foundDrodownvalue) {

					return;

				}

			}
			try {
				LoggerUtil.info("→ Group Classification: " + groupClassification);
				LoggerUtil.info("→ Specific Grade: " + gradeVal);
				LoggerUtil.info("→ Density: " + density);

				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClassification);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), gradeVal);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density);
				LoggerUtil.pass("Form values entered successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter form values for new commodity group.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Click Save to submit the entry.");
			try {
				Base.clickOnElement(savebtn);
				Thread.sleep(2000);
				LoggerUtil.pass("Save button clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click Save button.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Verifying success prompt message.");
			try {
				String actualMessage = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Actual Prompt: " + actualMessage);
				LoggerUtil.info("→ Expected Prompt: " + expectedMessage);

				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"❌ Expected success prompt not found after saving.\nExpected: " + expectedMessage + "\nActual: "
								+ actualMessage);
				LoggerUtil.pass("Success prompt displayed correctly after saving.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying success prompt: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying success prompt.");
				throw e;
			}

			LoggerUtil.info("✅ Commodity group saved successfully and prompt validated.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in clicksavebutton: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void SaveDuplicatevalue(String options,String groupClassification, String specificGrade, String density,
			String expectedMessage) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
			boolean foundDrodownvalue = false;
			for (WebElement comdropoptions : values) {

				String actualvalues = comdropoptions.getText().trim();

				if (actualvalues.equals(options)) {

					foundDrodownvalue = true;
					comdropoptions.click();
					break;

				}

				if (!foundDrodownvalue) {

					return;

				}

			}

			LoggerUtil.info("STEP 6: Enter details for first save.");
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClassification);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specificGrade);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density);
				LoggerUtil.pass("First entry values entered successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter values for first save.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Click Save button for first entry.");
			try {
				Base.clickOnElement(savebtn);
				Thread.sleep(6000);
				LoggerUtil.pass("First entry saved successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to save first entry.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Re-open 'Commodity Group' tab to attempt duplicate save.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab re-opened successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to re-open Commodity Group tab.");
				throw e;
			}

			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			List<WebElement> values1 = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
			boolean foundDrodownvalue1 = false;
			for (WebElement comdropoptions : values1) {

				String actualvalues = comdropoptions.getText().trim();

				if (actualvalues.equals(options)) {

					foundDrodownvalue1 = true;
					comdropoptions.click();
					break;

				}

				if (!foundDrodownvalue1) {

					return;

				}

			}

			LoggerUtil.info("STEP 10: Enter duplicate values for validation.");
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClassification);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specificGrade);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density);
				LoggerUtil.pass("Duplicate entry values entered successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter duplicate values.");
				throw e;
			}

			LoggerUtil.info("STEP 11: Click Save button for duplicate entry.");
			try {
				Base.clickOnElement(savebtn);
				Thread.sleep(2000);
				LoggerUtil.pass("Save button clicked for duplicate entry.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click Save button for duplicate entry.");
				throw e;
			}

			LoggerUtil.info("STEP 12: Validate toast message for duplicate entry.");
			try {
				String actualMessage = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Actual Toast Message: " + actualMessage);
				LoggerUtil.info("→ Expected Toast Message: " + expectedMessage);

				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"❌ Validation failed: Expected toast message not found for duplicate entry.\nExpected: "
								+ expectedMessage + "\nActual: " + actualMessage);
				LoggerUtil.pass("Duplicate validation message verified successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while validating duplicate toast message: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying duplicate toast message.");
				throw e;
			}

			LoggerUtil.info("✅ Duplicate entry validation completed successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in SaveDuplicatevalue: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By deletebtn = By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[6]/a[2]/i");

	public void deleteData(String searchValue, String expectedMessage) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Search for the commodity to delete: " + searchValue);
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(searchbox), searchValue);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity search value entered successfully: " + searchValue);
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter commodity search value.");
				throw e;
			}

			LoggerUtil.info("STEP 6: Click on delete button.");
			try {
				Base.clickOnElement(deletebtn);
				Thread.sleep(1000);
				LoggerUtil.pass("Delete button clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click delete button.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Accept delete confirmation alert.");
			try {
				Base.driver.switchTo().alert().accept();
				Thread.sleep(2000);
				LoggerUtil.pass("Delete confirmation alert accepted successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to handle delete confirmation alert.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Verify toast message for deletion failure due to dependency.");
			try {
				String actualMessage = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Actual Message: " + actualMessage);
				LoggerUtil.info("→ Expected Message: " + expectedMessage);

				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"❌ Delete dependency validation message mismatch.\nExpected: " + expectedMessage + "\nActual: "
								+ actualMessage);
				LoggerUtil.pass("Delete dependency validation message verified successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying delete dependency message: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying delete dependency toast message.");
				throw e;
			}

			LoggerUtil.info("✅ Delete failure due to dependency verified successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in deleteData: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deletenormaldata(String options,String groupClassification, String specificGrade, String density, String searchValue,
			String expectedMessage) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
			boolean foundDrodownvalue = false;
			for (WebElement comdropoptions : values) {

				String actualvalues = comdropoptions.getText().trim();

				if (actualvalues.equals(options)) {

					foundDrodownvalue = true;
					comdropoptions.click();
					break;

				}

				if (!foundDrodownvalue) {

					return;

				}

			}

			LoggerUtil.info("STEP 6: Enter Group Classification, Specific Grade, and Density, then save.");
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClassification);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specificGrade);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density);
				Base.clickOnElement(savebtn);
				Thread.sleep(5000);
				LoggerUtil.pass("New commodity details saved successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter and save new commodity details.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Search the saved entry for deletion.");
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(searchbox), searchValue);
				Thread.sleep(5000);
				driver.navigate().refresh();
				Thread.sleep(5000);
				LoggerUtil.pass("Saved entry searched successfully with value: " + searchValue);
			} catch (Exception e) {
				LoggerUtil.fail("Failed to search saved entry for deletion.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Click on delete icon and accept the alert.");
			try {
				Base.clickOnElement(deletebtn);
				Thread.sleep(1000);
				Base.driver.switchTo().alert().accept();
				Thread.sleep(2000);
				LoggerUtil.pass("Delete button clicked and confirmation alert accepted successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to delete record or accept alert.");
				throw e;
			}

			LoggerUtil.info("STEP 9: Verify toast message after deletion.");
			try {
				String actualMessage = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Actual Toast: " + actualMessage);
				LoggerUtil.info("→ Expected Toast: " + expectedMessage);

				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"❌ Deletion failed or wrong toast message displayed.\nExpected: " + expectedMessage
								+ "\nActual: " + actualMessage);
				LoggerUtil.pass("Deletion toast message verified successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying deletion toast message: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying deletion toast message.");
				throw e;
			}

			LoggerUtil.info("✅ Commodity data deleted successfully and prompt validated.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in deletenormaldata: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void commoditygroupupdatesucessfully(String options,String originalGroupClassification, String specificGrade,
			String density, String searchValue, String updatedGroupClassification) throws InterruptedException {

		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);

		List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		boolean foundDrodownvalue = false;
		for (WebElement comdropoptions : values) {

			String actualvalues = comdropoptions.getText().trim();

			if (actualvalues.equals(options)) {

				foundDrodownvalue = true;
				comdropoptions.click();
				break;

			}

			if (!foundDrodownvalue) {

				return;

			}

		}
		LoggerUtil.info("→ Group Classification: " + originalGroupClassification);
		LoggerUtil.info("→ Specific Grade: " + specificGrade);
		LoggerUtil.info("→ Density: " + density);
		clearAndEnterText(waitForExpectedElement(groupclassfication), originalGroupClassification);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		clearAndEnterText(waitForExpectedElement(Density), density);
		clickOnElement(savebtn);
		Thread.sleep(5000);

		LoggerUtil.info("STEP 7: Search for the saved entry to update.");
		clearAndEnterText(waitForExpectedElement(searchbox), searchValue);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 8: Click on Edit.");
		clickOnElement(editbtn);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 9: Update Group Classification to: " + updatedGroupClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), updatedGroupClassification);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 10: Click on Update button.");
		clickOnElement(updatebtn);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 11: Verify toast message for update success.");
		String actualMessage = waitForExpectedElement(toastmessage).getText().trim();
		String expectedMessage = "Commodity Group Updated Successfully";
		LoggerUtil.info("→ Actual Message: " + actualMessage);
		LoggerUtil.info("→ Expected Message: " + expectedMessage);

		Assert.assertTrue(actualMessage.contains(expectedMessage), "❌ Update failed or message not as expected.");

		LoggerUtil.info("✅ Commodity Group update prompt verified successfully.");
		captureStepScreenshot("CommodityGroup_Update_Success");
	}

	public static final By resetbtn = By.xpath("//button[@id='btnrest']");

	public void promptmissingforgrpclassification(String specGrade1, String density1, String message1,
			String groupClass2, String density2, String message2, String groupClass3, String specGrade3,
			String message3) {
		try {
// -------- Case 1: Missing Group Classification --------
			LoggerUtil.info("STEP 4: Start case: Missing Group Classification.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				clickOnElement(clickcommoditygroupdrop);
				Thread.sleep(3000);
				List<WebElement> options = Base.driver
						.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
				options.get(1).click();
				Thread.sleep(3000);

				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specGrade1);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density1);
				Base.clickOnElement(savebtn);
				Thread.sleep(2000);

				String toast1 = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Toast for Missing Group Classification: " + toast1);

				Assert.assertTrue(toast1.contains(message1),
						"❌ Missing Group Classification validation failed.\nExpected: " + message1 + "\nActual: "
								+ toast1);
				LoggerUtil.pass("Prompt verified for missing Group Classification.");
				Base.clickOnElement(resetbtn);
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed in Missing Group Classification case: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception in Missing Group Classification case.");
				throw e;
			}

// -------- Case 2: Missing Specific Grade --------
			LoggerUtil.info("STEP 5: Start case: Missing Specific Grade.");
			try {
				List<WebElement> options1 = Base.driver
						.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
				options1.get(1).click();
				Thread.sleep(3000);

				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClass2);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density2);
				Base.clickOnElement(savebtn);
				Thread.sleep(2000);

				String toast2 = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Toast for Missing Specific Grade: " + toast2);

				Assert.assertTrue(toast2.contains(message2),
						"❌ Missing Specific Grade validation failed.\nExpected: " + message2 + "\nActual: " + toast2);
				LoggerUtil.pass("Prompt verified for missing Specific Grade.");
				Base.clickOnElement(resetbtn);
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed in Missing Specific Grade case: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception in Missing Specific Grade case.");
				throw e;
			}

// -------- Case 3: Missing Density --------
			LoggerUtil.info("STEP 6: Start case: Missing Density.");
			try {
				Base.clickOnElement(clickcommoditygroupdrop);
				Thread.sleep(3000);
				List<WebElement> options2 = Base.driver
						.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
				options2.get(1).click();

				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClass3);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specGrade3);
				Base.clickOnElement(savebtn);
				Thread.sleep(2000);

				String toast3 = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Toast for Missing Density: " + toast3);

				Assert.assertTrue(toast3.contains(message3),
						"❌ Missing Density validation failed.\nExpected: " + message3 + "\nActual: " + toast3);
				LoggerUtil.pass("Prompt verified for missing Density.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed in Missing Density case: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception in Missing Density case.");
				throw e;
			}

			LoggerUtil.info("✅ All missing field validation prompts verified successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in promptmissingforgrpclassification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By frtchdenvalue = By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[5]");

	public void densityvaluevalidate(String options,String originalGroupClassification, String specificGrade, String density) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}
			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			List<WebElement> values = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
			boolean foundDrodownvalue = false;
			for (WebElement comdropoptions : values) {

				String actualvalues = comdropoptions.getText().trim();

				if (actualvalues.equals(options)) {

					foundDrodownvalue = true;
					comdropoptions.click();
					break;

				}

				if (!foundDrodownvalue) {

				return;

				}

			}

			LoggerUtil.info("STEP 6: Enter Group Classification, Specific Grade, and Density, then save.");
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), originalGroupClassification);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specificGrade);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density);
				Base.clickOnElement(savebtn);
				Thread.sleep(5000);
				LoggerUtil.pass("Commodity saved successfully with Group Classification, Specific Grade, and Density.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter/save commodity details.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Search for the saved entry to verify Density value: " + density);
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(searchbox), density);
				Thread.sleep(3000);
				LoggerUtil.pass("Search performed successfully for density value: " + density);
			} catch (Exception e) {
				LoggerUtil.fail("Failed to search for saved entry by density.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Fetch and validate the Density value from the table.");
			try {
				String actualDensity = Base.waitForExpectedElement(frtchdenvalue).getText().trim();
				LoggerUtil.info("→ Actual Density Value from Table: " + actualDensity);
				LoggerUtil.info("→ Expected Density Value: " + density);

				Assert.assertEquals(actualDensity, density,
						"❌ Density value in table does not match the expected value.\nExpected: " + density
								+ "\nActual: " + actualDensity);
				LoggerUtil.pass("Density value verified successfully in the table.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying density value: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while fetching/verifying density value.");
				throw e;
			}

			LoggerUtil.info("✅ Density value validation completed successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in densityvaluevalidate: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void VerifyRestFunctionality() {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Click on Edit button to load entry into the form.");
			try {
				Base.clickOnElement(editbtn);
				Thread.sleep(3000);
				LoggerUtil.pass("Edit button clicked successfully. Entry loaded into form.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Edit button.");
				throw e;
			}

			LoggerUtil.info("STEP 6: Click on Reset button to clear the form.");
			try {
				Base.clickOnElement(resetbtn);
				LoggerUtil.pass("Reset button clicked successfully. Form cleared/restored.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Reset button.");
				throw e;
			}

			LoggerUtil
					.info("✅ Reset functionality executed. Form should now be cleared or restored to original state.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in VerifyRestFunctionality: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By useridauth = By.xpath("//table[@id='example2']/tbody/tr[5]/td[4]/a/span/i");
	public static final By usrauthtab = By.xpath("//div[@id='exTab3']/ul/li[2]/a[@href='#UserAuthorizationTab']");
	public static final By userbtn = By.xpath("//li[@class=\"slide\"]//a[@href=\"/Subscription/Users\"]");
	public static final By mastertriangle = By.xpath("//div[@id='jstree']/ul/li/div[1]/following-sibling::i");
	public static final By commoditytriangle = By.xpath("//*[@id=\"36\"]/i");
	public static final By clickreadAndWrite = By.xpath("//*[@id=\"107_anchor\"]/i[1]");
	public static final By updatebtn1 = By.xpath(
			"//div[@class='footer_sticky_button cs_gap_btn d-flex justify-content-end align-items-center mt-1']/a[@id='btnSubmit']");

	public void verifyclickforreadonly() throws InterruptedException {

		clickOnElement(userbtn);
		captureStepScreenshot("user clickthe User btn");
		Thread.sleep(3000);
		clickOnElement(usrauthtab);
		captureStepScreenshot("User Try to click the User Auth");
		Thread.sleep(2000);
		clickOnElement(useridauth);
		captureStepScreenshot("User Click The Ss For Clicking id ");
		Thread.sleep(3000);
		clickOnElement(mastertriangle);
		captureStepScreenshot("User Click The Master Triangle ");
		Thread.sleep(2000);
		clickOnElement(commoditytriangle);
		captureStepScreenshot("User Click The commodity triangle ");
		Thread.sleep(2000);

		clickOnElement(clickreadAndWrite);
		captureStepScreenshot("User unselect The read&write authorization ");
		Thread.sleep(3000);
		clickOnElement(updatebtn1);
		captureStepScreenshot("User click The update button  ");

	}

	public void verifysavebuttonInUserAuthorization() throws InterruptedException {
		LoggerUtil.info("STEP 5: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(2000);

		LoggerUtil.info("STEP 6: Check visibility of 'Save' button.");
		boolean isSaveButtonVisible = !Base.driver.findElements(savebtn).isEmpty();

		if (isSaveButtonVisible) {
			LoggerUtil.info("❌ FAIL: Save button is visible for a ReadOnly user.");

			LoggerUtil.info("✅ PASS: Save button is not visible, as expected for ReadOnly access.");
		}

		Assert.assertFalse(isSaveButtonVisible, "❌ Save button should NOT be visible for ReadOnly users.");
	}

	public void saveDataForClientA(String groupClassification, String specificGrade, String densityValue)
			throws InterruptedException {
		LoggerUtil.info("Client A: STEP 1 - Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);
		LoggerUtil.info("Client A: STEP 2 - Open commodity dropdown and select 'ABC'.");
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		WebElement flagvalue = options.get(1);
		flagvalue.click();

		LoggerUtil.info("Client A: STEP 3 - Enter Group Classification: " + groupClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), groupClassification);
		Thread.sleep(2000);

		LoggerUtil.info("Client A: STEP 4 - Enter Specific Grade: " + specificGrade);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		Thread.sleep(2000);

		LoggerUtil.info("Client A: STEP 5 - Enter Density: " + densityValue);
		clearAndEnterText(waitForExpectedElement(Density), densityValue);
		Thread.sleep(2000);

		LoggerUtil.info("Client A: STEP 6 - Click on 'Save' button.");
		clickOnElement(savebtn);
		Thread.sleep(4000);

		LoggerUtil.info("✅ Client A: Data saved successfully.");
	}

	public void saveDataForClientB(String groupClassification, String specificGrade, String densityValue)
			throws InterruptedException {
		LoggerUtil.info("Client B: STEP 1 - Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("Client B: STEP 2 - Open commodity dropdown and select 'ABC'.");
		clickOnElement(clickcommoditygroupdrop);
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
		WebElement flagvalue = options.get(1);
		flagvalue.click();

		LoggerUtil.info("Client B: STEP 3 - Enter Group Classification: " + groupClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), groupClassification);
		Thread.sleep(2000);

		LoggerUtil.info("Client B: STEP 4 - Enter Specific Grade: " + specificGrade);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificGrade);
		Thread.sleep(2000);

		LoggerUtil.info("Client B: STEP 5 - Enter Density: " + densityValue);
		clearAndEnterText(waitForExpectedElement(Density), densityValue);
		Thread.sleep(2000);

		LoggerUtil.info("Client B: STEP 6 - Click on 'Save' button.");
		clickOnElement(savebtn);
		Thread.sleep(4000);

		LoggerUtil.info("✅ Client B: Data saved successfully.");
	}

	public void editsavedDataForClientA(String searchValue, String updatedGroupClassification)
			throws InterruptedException {
		LoggerUtil.info("Client A: STEP 1 - Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("Client A: STEP 2 - Search for entry with Group Classification: " + searchValue);
		clearAndEnterText(waitForExpectedElement(searchbox), searchValue);
		Thread.sleep(3000);

		LoggerUtil.info("Client A: STEP 3 - Click on 'Edit' button for the matched entry.");
		clickOnElement(editbtn);
		Thread.sleep(3000);

		LoggerUtil.info("Client A: STEP 4 - Update Group Classification to: " + updatedGroupClassification);
		clearAndEnterText(waitForExpectedElement(groupclassfication), updatedGroupClassification);
		Thread.sleep(2000);

		LoggerUtil.info("Client A: STEP 5 - Click on 'Update' button to save changes.");
		clickOnElement(updatebtn);
		Thread.sleep(3000);

		LoggerUtil.info(
				"✅ Client A: Entry updated successfully with new Group Classification: " + updatedGroupClassification);
	}

	public static final By verificationingroupclassificationtableinClientB = By
			.xpath("//table[@id='SubGroupTable']/tbody/tr/td[3]");

	public void verifysavedDataInClientB(String expectedGroupClassification) throws InterruptedException {
		LoggerUtil.info("Client B: STEP 1 - Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("Client B: STEP 2 - Search for Group Classification: " + expectedGroupClassification);
		clearAndEnterText(waitForExpectedElement(searchbox), expectedGroupClassification);
		Thread.sleep(3000);

		LoggerUtil.info("Client B: STEP 3 - Fetch displayed Group Classification value from table.");
		String actualValue = waitForExpectedElement(verificationingroupclassificationtableinClientB).getText().trim();

		LoggerUtil.info("→ Expected: " + expectedGroupClassification);
		LoggerUtil.info("→ Actual: " + actualValue);

		Assert.assertEquals(actualValue, expectedGroupClassification,
				"❌ Mismatch in displayed Group Classification value in Client B's table.");

		LoggerUtil.info("✅ Group Classification value verified successfully for Client B.");
		captureStepScreenshot("ClientB_VerifyGroupClassification");
	}

	public void verifydeletebtnInClientA(String groupClassificationToDelete) throws InterruptedException {
		LoggerUtil.info("Client A: STEP 1 - Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("Client A: STEP 2 - Search for Group Classification: " + groupClassificationToDelete);
		clearAndEnterText(waitForExpectedElement(searchbox), groupClassificationToDelete);
		Thread.sleep(3000);

		LoggerUtil.info("Client A: STEP 3 - Click on 'Delete' button for the searched entry.");
		clickOnElement(deletebtn);
		Thread.sleep(1000);

		LoggerUtil.info("Client A: STEP 4 - Accept browser alert to confirm deletion.");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		LoggerUtil.info("✅ Client A: Delete action completed for Group Classification: " + groupClassificationToDelete);
		captureStepScreenshot("ClientA_DeletionOf_" + groupClassificationToDelete);
	}

	public void verifysaveInvalidDataIncommoditgroup(String groupClass, String specificGrade, String density,
			String expectedMessage) {
		try {
			LoggerUtil.info("STEP 4: Open 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab opened successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to open Commodity Group tab.");
				throw e;
			}

			clickOnElement(clickcommoditygroupdrop);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 5: Open dropdown and select Commodity: ABC");
			try {
				List<WebElement> options = Base.driver
						.findElements(By.xpath("//select[@id='commodityDropdown']/option"));
				WebElement flagvalue = options.get(1);
				flagvalue.click();
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity 'ABC' selected successfully from dropdown.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to select Commodity 'ABC' from dropdown.");
				throw e;
			}

			LoggerUtil.info("STEP 6: Fill form with invalid group classification value.");
			try {
				LoggerUtil.info("→ Group Classification: " + groupClass);
				LoggerUtil.info("→ Specific Grade: " + specificGrade);
				LoggerUtil.info("→ Density: " + density);

				Base.clearAndEnterText(Base.waitForExpectedElement(groupclassfication), groupClass);
				Base.clearAndEnterText(Base.waitForExpectedElement(specificgradevalue), specificGrade);
				Base.clearAndEnterText(Base.waitForExpectedElement(Density), density);
				LoggerUtil.pass("Form filled with invalid data successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to fill form with invalid data.");
				throw e;
			}

			LoggerUtil.info("STEP 7: Click Save to trigger validation.");
			try {
				Base.clickOnElement(savebtn);
				Thread.sleep(2000);
				LoggerUtil.pass("Save button clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click Save button.");
				throw e;
			}

			LoggerUtil.info("STEP 8: Verify toast message for invalid character validation.");
			try {
				String actualMessage = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Actual Message: " + actualMessage);
				LoggerUtil.info("→ Expected Message: " + expectedMessage);

				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"❌ Validation failed: Expected message not found in toast.\nExpected: " + expectedMessage
								+ "\nActual: " + actualMessage);
				LoggerUtil.pass("Special character validation message verified successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying toast message: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying toast message.");
				throw e;
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifysaveInvalidDataIncommoditgroup: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifySucessfullPromt(String expectedMessage) {
		try {
			LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
			try {
				Base.clickOnElement(commoditygrouptab);
				Thread.sleep(3000);
				LoggerUtil.pass("Commodity Group tab clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Commodity Group tab.");
				throw e;
			}

			LoggerUtil.info("STEP 5: Click on 'Export' button.");
			try {
				Base.clickOnElement(exportbtn);
				Thread.sleep(3000); // wait for toast to appear if async
				LoggerUtil.pass("Export button clicked successfully.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Export button.");
				throw e;
			}

			LoggerUtil.info("STEP 6: Validate the success toast message.");
			try {
				String actualMessage = Base.waitForExpectedElement(toastmessage).getText().trim();
				LoggerUtil.info("→ Expected Toast: " + expectedMessage);
				LoggerUtil.info("→ Actual Toast: " + actualMessage);

				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"❌ Export success prompt not displayed as expected.\nExpected: " + expectedMessage
								+ "\nActual: " + actualMessage);
				LoggerUtil.pass("Export success prompt verified successfully.");
			} catch (AssertionError ae) {
				LoggerUtil.fail("Assertion failed while verifying export prompt: " + ae.getMessage());
				throw ae;
			} catch (Exception e) {
				LoggerUtil.fail("Exception occurred while verifying export toast message.");
				throw e;
			}

			LoggerUtil.info("✅ Export functionality validated with success prompt.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifySucessfullPromt: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyimportvalidationFormissingcolumn() throws InterruptedException {
		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Export the Commodity Group Excel template.");
		clickOnElement(exportbtn);
		Thread.sleep(10000); // Wait for download

		LoggerUtil.info("STEP 6: Import the Excel file after removing 'Specific Grade' column.");
		importNewCommoditymasterExcelWithoutFillingColumnspecificgrade();

		LoggerUtil.info("STEP 7: Capture screenshot for missing column validation.");
		captureStepScreenshot("Import_Validation_Missing_SpecificGrade");

		LoggerUtil.info("✅ Import validation executed. Please confirm toast/prompt validation if UI supports it.");
		Thread.sleep(5000);
	}

	public String fillCommoditySheetWithoutcolumn() {
		File latestFile = getLatestNewSpecificGradeFileForCommodityGroup();
		if (latestFile == null) {
			LoggerUtil.info("❌ No Commodity Group file found for processing.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();

		try (FileInputStream fis = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			LoggerUtil.info("Processing Excel file to remove 'Specific Grade' column...");
			XSSFSheet sheet = workbook.getSheetAt(0);
			int columnToRemove = 3; // "Specific Grade" column index (0-based)

			for (Row row : sheet) {
				int lastCellNum = row.getLastCellNum();

				// Shift values left from the column to remove
				for (int i = columnToRemove; i < lastCellNum - 1; i++) {
					Cell next = row.getCell(i + 1);
					Cell current = row.getCell(i);
					if (current == null)
						current = row.createCell(i);
					if (next != null) {
						current.setCellValue(next.toString());
					} else {
						current.setBlank();
					}
				}

				// Remove the last cell which is now redundant
				if (lastCellNum > columnToRemove) {
					row.removeCell(row.getCell(lastCellNum - 1));
				}
			}

			// Save changes back to file
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}

			LoggerUtil.info("✅ 'Specific Grade' column removed and Excel updated successfully.");
			return latestFile.getName();

		} catch (IOException e) {
			LoggerUtil.info("❌ Error while processing Excel file: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void importNewCommoditymasterExcelWithoutFillingColumnspecificgrade() throws InterruptedException {
		LoggerUtil.info("STEP 1: Start preparing Excel file without 'Specific Grade' column.");
		String fileName = fillCommoditySheetWithoutcolumn();

		String fullPath = System.getProperty("user.dir") + "/downloads/" + fileName;
		LoggerUtil.info("→ Excel file prepared at: " + fullPath);

		File file = new File(fullPath);
		if (!file.exists()) {
			LoggerUtil.info("❌ File does not exist: " + fullPath);
			return;
		}

		LoggerUtil.info("STEP 2: Locate file input element for import.");
		WebElement fileInput = driver.findElement(By.id("attachmentcommodity"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		LoggerUtil.info("STEP 3: Uploading the file.");
		fileInput.sendKeys(fullPath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(fileInput, "value"));

		LoggerUtil.info("✅ File uploaded successfully. Proceed to import validation.");

		// Optional: Click Import button and validate response
		// clickOnElement(importbtn); // if required
		// validateToast("Specific Grade column is missing"); // optional toast check
	}

	public void verifyCommoditySheet1(String filePath) {
		LoggerUtil.info("📂 Verifying written Excel data at path: " + filePath);

		boolean isCommodityGroupCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 1, commodityGroup);
		boolean isGroupClassificationCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 2, groupClassification);
		boolean isDensityCorrect = ExcelFiller.verifyCellValue(filePath, 0, 3, 3, density); // Density now shifted to
																							// index 3

		LoggerUtil.info("🔍 Expected vs Actual Value Check:");
		LoggerUtil.info("→ Commodity Group: " + (isCommodityGroupCorrect ? "✔ MATCH" : "❌ MISMATCH"));
		LoggerUtil.info("→ Group Classification: " + (isGroupClassificationCorrect ? "✔ MATCH" : "❌ MISMATCH"));
		LoggerUtil.info("→ Density: " + (isDensityCorrect ? "✔ MATCH" : "❌ MISMATCH"));

		if (!isCommodityGroupCorrect || !isGroupClassificationCorrect || !isDensityCorrect) {
			LoggerUtil.info("❌ Excel data verification failed.");
		} else {
			LoggerUtil.info("✅ Excel data verified successfully.");
		}
	}

	public void exportdetaWithinvalidDensity(String expectedMessage) throws InterruptedException {
		LoggerUtil.info("STEP 4: Click on 'Commodity Group' tab.");
		clickOnElement(commoditygrouptab);
		Thread.sleep(3000);

		LoggerUtil.info("STEP 5: Click on 'Export' button to download template.");
		clickOnElement(exportbtn);
		Thread.sleep(15000); // wait for file download

		LoggerUtil.info("STEP 6: Inject invalid Density value into Excel.");
		importNewCommoditymasterExcelWithInvalidColumn(); // fills in 'abc' or similar text
		Thread.sleep(4000);

		LoggerUtil.info("STEP 7: Validate toast message for invalid data.");
		String actualMessage = waitForExpectedElement(toastmessage).getText().trim();
		LoggerUtil.info("→ Actual Toast: " + actualMessage);
		LoggerUtil.info("→ Expected Toast: " + expectedMessage);

		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"❌ Validation toast mismatch for invalid density column.");

		LoggerUtil.info("✅ Validation for invalid density column triggered successfully.");
		captureStepScreenshot("InvalidDensityColumn_Validation");
	}

	public String fillCommoditySheetWithInvalidDensity() {
	    File latestFile = getLatestNewSpecificGradeFileForCommodityGroup();
	    if (latestFile == null) {
	        LoggerUtil.info("❌ No Commodity Group file found to modify.");
	        return null;
	    }

	    String filePath = latestFile.getAbsolutePath();

	    // Values to write
	     commodityGroup = "Ferrous Metals";
	     groupClassification = faker.name().firstName();
	     specificGrade = "Anuij";
	     density = "@@#$%"; // invalid non-numeric input

	    // Log values being written
	    LoggerUtil.info("✍ Writing invalid data to Excel:");
	    LoggerUtil.info("→ Commodity Group: " + commodityGroup);
	    LoggerUtil.info("→ Group Classification: " + groupClassification);
	    LoggerUtil.info("→ Specific Grade: " + specificGrade);
	    LoggerUtil.info("→ Density (INVALID): " + density);

	    // Write to Excel
	    ExcelFiller.writeExactCellValue(filePath, 0, 3, 1, commodityGroup);      // Column B
	    ExcelFiller.writeExactCellValue(filePath, 0, 3, 2, groupClassification); // Column C
	    ExcelFiller.writeExactCellValue(filePath, 0, 3, 3, specificGrade);       // Column D
	    ExcelFiller.writeExactCellValue(filePath, 0, 3, 4, density);             // Column E

	    // Optional: verify what was written
	    verifyCommoditySheet(filePath);

	    LoggerUtil.info("✅ Excel filled with invalid density value. File path: " + filePath);
	    return filePath; // ✅ Return absolute path, not just filename
	}

	public void importNewCommoditymasterExcelWithInvalidColumn() throws InterruptedException {

	    // ✅ Get full absolute path from Excel filler
	    String fullPath = fillCommoditySheetWithInvalidDensity(); 
	    if (fullPath == null) {
	        throw new RuntimeException("❌ No file found to upload for Commodity Group.");
	    }

	    WebElement fileInput = driver.findElement(By.id("attachmentcommodity"));

	    // ✅ Make hidden input visible for upload
	    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

	    LoggerUtil.info("📤 Uploading file: " + fullPath);

	    // ✅ Always provide absolute path here
	    fileInput.sendKeys(fullPath);

	    Thread.sleep(11000); // wait for upload to complete
	}


	public static final By Addcommoditygroup = By.xpath("//input[@id='commodityGroup']");
	public static final By savebtnAdd = By.xpath("//button[@id='tab1Save']");

	public void AddCommodity(String acomgrp) {
		try {
			LoggerUtil.info("STEP 1: Enter Commodity Group name: " + acomgrp);
			try {
				Base.clearAndEnterText(Base.waitForExpectedElement(Addcommoditygroup), acomgrp);
				LoggerUtil.pass("Commodity Group name entered successfully: " + acomgrp);
				Thread.sleep(3000);
			} catch (Exception e) {
				LoggerUtil.fail("Failed to enter Commodity Group name.");
				throw e;
			}

			LoggerUtil.info("STEP 2: Click on Save button to add Commodity Group.");
			try {
				Base.clickOnElement(savebtnAdd);
				LoggerUtil.pass("Save button clicked successfully for adding Commodity Group.");
			} catch (Exception e) {
				LoggerUtil.fail("Failed to click on Save button while adding Commodity Group.");
				throw e;
			}

			LoggerUtil.info("✅ Commodity Group addition process completed successfully.");

		} catch (Exception e) {
			LoggerUtil.error("Exception in AddCommodity: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
