package com.Pages;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.beans.Visibility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelFiller;
import com.helper.ExcelUtil;
import com.helper.ExtentManager;
import com.helper.LoggerUtil;

import io.reactivex.rxjava3.functions.BiConsumer;
import net.bytebuddy.asm.Advice.Argument;

public class CommodityDetailsPage extends Base { // Select Commodity Group

	Faker faker = new Faker();
	SoftAssert softAssert = new SoftAssert();
	DashboardPage dashboard = new DashboardPage();
	CommoditygroupPage comgrp = new CommoditygroupPage();

	
	public static final By ClickingcommoditydropdownBtnThirdTab = By
			.xpath("//select[@id='commodityDrop']/following-sibling::span//span[@id='select2-commodityDrop-container']");
	public static final By searchInputforcommodityDetailsTab = By.xpath("//span[@class='select2-container select2-container--default select2-container--open']//input[@type='search']");
	public static final By ClickingGroupclassificationBtnThirdTabDropdown = By
			.xpath("//span[@id='select2-materialDrop-container']");
	public static final By searchInputforgroupclassificationDropDownInThirdTab = By
			.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By ClickingspecificgradeBtndropdownForThirdTab = By
			.xpath("//select[@id='SpecificGrade']/following-sibling::span//span[@id='select2-SpecificGrade-container']");
	public static final By SearchInputspecificgradeForThirdTab = By
			.xpath("//span[@class='select2-container select2-container--default select2-container--open']//input[@type='search']");
	public static final By Uomdropdown = By.xpath("//span[@id='select2-uomDrop-container']");
	public static final By searchinputforuom = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By ClickingShapedropdownForthirdTab = By.xpath("//span[@id='select2-shapeDrop-container']");
	public static final By searchinputforshape = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By selectyeardrop = By.xpath("//*[@id='select2-Year-container']");
	public static final By searchinputyear = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By businessSegbox = By
			.xpath("//select[@id='SupplierSegment']/following-sibling::div/button");
	public static final By searchbarbusinessSeg = By.xpath("//select[@id='SupplierSegment']/following-sibling::div/descendant::input[@class='multiselect-search form-control']");
	public static final By selectallcheckboxInbusinsessSeg = By.xpath(
			"//div[@class='multiselect-container dropdown-menu show']/div/following-sibling::button/span/input[@value='multiselect-all']");
	public static final By ClickingSaveBtnForThirdTab = By.xpath("//button[@id='tab3Save']");
	public static final By enterdate = By.xpath("//input[@id='EntryDate']");
	public static final By toastmsg = By.xpath("//div[@class='toast-message']");

	public static final By customercheckbox = By.xpath("//table[@id='rmCustomer']/tbody/tr/td/div/label/input");

	public void SecondPage() throws InterruptedException {

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);

		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), "ABCDEF");

	}
	public static final By ClickingViewbtn = By.xpath("//div[@class='btn-group']/button[@onclick='comodityDetailList()']");
	public static final By EnterValueForSearchingCommodityGroupTab = By.xpath("//input[@id='myInputListSearch']");
	public static final By clicksearchfileter = By
			.xpath("//*[@id='CommodityDetailTab']/descendant::i[@class='fas fa-filter filter-icon']");
	public static final By clickGradecheckboxFilterDropdownCommodityDetailsViewTable = By
			.xpath("//*[@id='CommodityDetailTab']/descendant::div[@class='multi-select-options']/label[contains(text(),'Grade')]/input[@type='checkbox']");
//	public static final By verificationGradecolumn = By
//			.xpath("//div[@id='comodity-view-list']/div/table/tbody/tr/td[5]");
	public static final By subgroupcheckboxFilterDropdownCommodityDetailsViewTable = By.xpath("//*[@id='CommodityDetailTab']/descendant::div[@class='multi-select-options']/label[contains(text(),'Sub Group')]/input[@type='checkbox']");
//	public static final By verifysubgroupcolumn = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[4]");

//	//public void verifydatasavedOrnot() throws InterruptedException { 
//
//		clickOnElement(ClickingViewbtn);
//		Thread.sleep(4999);
//		clickOnElement(clicksearchfileter);
//		Thread.sleep(1000);
//		clickOnElement(clickGradecheckbox);
//		Thread.sleep(2000);
//		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), "-33");
//		Thread.sleep(4000);
//		String expectedvalue = "-33";
//		String actualvalue = waitForExpectedElement(verificationGradecolumn).getText();
//		Assert.assertEquals(actualvalue, expectedvalue);
//		captureStepScreenshot("User Try To Take SS For Verifying Specific Grade");
//		driver.navigate().refresh();
//		clickOnElement(ClickingViewbtn);
//		Thread.sleep(4999);
//		clickOnElement(clicksearchfileter);
//		Thread.sleep(1000);
//		clickOnElement(subgroupcheckbox);
//		Thread.sleep(2000);
//		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), "-45");
//		String actualvalue1 = waitForExpectedElement(verifysubgroupcolumn).getText();
//		String expectedvalue1 = "-45";
//		Assert.assertEquals(actualvalue1, expectedvalue1);
//		captureStepScreenshot("verify User try to Take Ss For Verifying Subgroup value Store correct value or not ");
//
//	}

	public static final By effectivedate = By.xpath("//input[@id='EntryDate']");
	public static final By systemdate = By.xpath("//input[@id='SystemDate']");

	public void verifyTodayDateForEffective(String expectedvalue) throws InterruptedException {
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' sub-tab for effective date verification.");
		Thread.sleep(2000);

		String actualvalue = waitForExpectedElement(effectivedate).getDomAttribute("value");
		LoggerUtil.info("Found effective date in input field: " + actualvalue);

		Assert.assertEquals(actualvalue, expectedvalue);
		LoggerUtil.info("Effective date verification PASSED. Expected: " + expectedvalue + ", Actual: " + actualvalue);

		captureStepScreenshot("Snapshot taken after verifying today's effective date in 'Commodity Details' tab.");
	}

	public void VerifyTodayDateForsystemdate(String expectedvalue) throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for System Date verification.");
		Thread.sleep(3000);

		String actualvalue = waitForExpectedElement(systemdate).getDomAttribute("value");
		LoggerUtil.info("System Date found in field: " + actualvalue);

		Assert.assertEquals(actualvalue, expectedvalue);
		LoggerUtil.info("System Date verification PASSED. Expected: " + expectedvalue + ", Actual: " + actualvalue);

		captureStepScreenshot("Snapshot after verifying today's system date in 'Commodity Details' tab.");
	}

	public static final By enterSearchValueCommodityDetailsTab = By.xpath("//*[@id='myInputListSearch']");
	public static final By CommoditydropDownlistThirdTab = By.xpath("//select[@id='commodityDrop']/option");

	public static final By GroupClassificationDropdownValueInThirdTab = By
			.xpath("//ul[@id='select2-materialDrop-results']/li");

	public static final By GradeListThirdTab = By.xpath("//ul[@id='select2-SpecificGrade-results']/li ");
	public static final By clickingAnotherWebElement = By.xpath("//h3[normalize-space(text())='Suppliers']");

	public void VerifySearchFilterForCommodityDetailsTab() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String searchKeyword = "Ferrous Metals";
		String expectedGroupClassification = "Stainless Steel";
		String expectedSpecificGrade = "CRCA-007";

		try {
			LoggerUtil.info("STEP 1: Open 'Commodity Group' dropdown.");
			clickOnElement(ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(1000);
			LoggerUtil.pass("Commodity Group dropdown opened successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Failed to open Commodity Group dropdown → " + e.getMessage());
			softAssert.fail("Commodity Group dropdown could not be opened.");
		}

		try {
			LoggerUtil.info("STEP 2: Enter search text → " + searchKeyword);
			WebElement searchInput = waitForExpectedElement(enterSearchValueCommodityDetailsTab);
			clearAndEnterText(searchInput, searchKeyword);
			Thread.sleep(2000);
			LoggerUtil.pass("Search keyword '" + searchKeyword + "' entered successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Failed to enter search text in Commodity Group dropdown → " + e.getMessage());
			softAssert.fail("Search keyword entry failed for Commodity Group.");
		}

		try {
			LoggerUtil.info("STEP 3: Validate filtered options for '" + searchKeyword + "'.");
			List<WebElement> filteredOptions = driver.findElements(CommoditydropDownlistThirdTab);
			softAssert.assertTrue(filteredOptions.size() > 0,
					"No options displayed after applying search filter: " + searchKeyword);

			boolean commodityMatchFound = false;
			for (WebElement option : filteredOptions) {
				if (option.getText().trim().equalsIgnoreCase(searchKeyword)) {
					commodityMatchFound = true;
					option.click();
					LoggerUtil.pass("Expected value '" + searchKeyword + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(commodityMatchFound,
					"Expected option '" + searchKeyword + "' not found in commodity group dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Error while validating Commodity Group dropdown → " + e.getMessage());
			softAssert.fail("Commodity Group validation failed.");
		}

		try {
			Thread.sleep(3000);
			clickOnElement(clickingAnotherWebElement);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 4: Open 'Group Classification' dropdown.");
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 5: Enter search text → " + expectedGroupClassification);
			clearAndEnterText(waitForExpectedElement(searchInputforgroupclassificationDropDownInThirdTab),
					expectedGroupClassification);
			Thread.sleep(5000);

			LoggerUtil.info("STEP 6: Validate filtered options for '" + expectedGroupClassification + "'.");
			List<WebElement> groupClassificationOptions = driver
					.findElements(GroupClassificationDropdownValueInThirdTab);

			boolean groupMatchFound = false;
			for (WebElement option : groupClassificationOptions) {
				if (option.getText().trim().equalsIgnoreCase(expectedGroupClassification)) {
					groupMatchFound = true;
					option.click();
					LoggerUtil.pass("Expected value '" + expectedGroupClassification + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(groupMatchFound, "Expected option '" + expectedGroupClassification
					+ "' not found in group classification dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Error while validating Group Classification dropdown → " + e.getMessage());
			softAssert.fail("Group Classification validation failed.");
		}

		try {
			Thread.sleep(3000);
			clickOnElement(clickingAnotherWebElement);
			Thread.sleep(3000);

			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
			LoggerUtil.info("Clicked on Specific Grade dropdown.");
			Thread.sleep(4000);

			clearAndEnterText(waitForExpectedElement(SearchInputspecificgradeForThirdTab), expectedSpecificGrade);
			Thread.sleep(4000);

			List<WebElement> gradeOptions = driver.findElements(GradeListThirdTab);
			boolean gradeFound = false;

			for (WebElement option : gradeOptions) {
				if (option.getText().trim().equalsIgnoreCase(expectedSpecificGrade)) {
					gradeFound = true;
					option.click();
					LoggerUtil.pass("Expected Specific Grade '" + expectedSpecificGrade + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(gradeFound,
					"Expected Specific Grade '" + expectedSpecificGrade + "' not found in dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Error while validating Specific Grade dropdown → " + e.getMessage());
			softAssert.fail("Specific Grade validation failed.");
		}

		LoggerUtil.info("STEP 7: Execute all collected soft assertions.");
		softAssert.assertAll();
	}

	public void verifysavedatawithoutUnitOfMeasurement(String expectedMessage) throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for UOM mandatory field validation.");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");
		LoggerUtil.info("Entered Effective Date: 02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(500);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		String expectedCommodity = "ABCD";
		clearAndEnterText(searchBox, expectedCommodity);
		LoggerUtil.info("Commodity Group filter: Expected = " + expectedCommodity + ", Actual = "
				+ searchBox.getAttribute("value"));
		Thread.sleep(500);

		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown.");
		Thread.sleep(500);

		WebElement searchboxclasification = waitForExpectedElement(searchInputforgroupclassificationDropDownInThirdTab);
		String expectedClassification = "ABC";
		clearAndEnterText(searchboxclasification, expectedClassification);
		LoggerUtil.info("Group Classification filter: Expected = " + expectedClassification + ", Actual = "
				+ searchboxclasification.getAttribute("value"));
		searchboxclasification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		LoggerUtil.info("Clicked on Specific Grade dropdown.");
		Thread.sleep(400);

		WebElement searchboxgrade = waitForExpectedElement(SearchInputspecificgradeForThirdTab);
		String expectedGrade = "ABC";
		clearAndEnterText(searchboxgrade, expectedGrade);
		LoggerUtil.info("Specific Grade filter: Expected = " + expectedGrade + ", Actual = "
				+ searchboxgrade.getAttribute("value"));
		searchboxgrade.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		// UOM intentionally skipped for mandatory field validation
		LoggerUtil.info("Skipped entering Unit of Measurement (UOM) to validate mandatory field.");

		clickOnElement(ClickingShapedropdownForthirdTab);
		LoggerUtil.info("Clicked on Shape dropdown.");
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		String expectedShape = "Sheet";
		clearAndEnterText(shapesearch, expectedShape);
		LoggerUtil
				.info("Shape filter: Expected = " + expectedShape + ", Actual = " + shapesearch.getAttribute("value"));
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");

		Thread.sleep(2000);
		clickOnElement(selectyeardrop);
		LoggerUtil.info("Clicked on Year dropdown.");
		Thread.sleep(3000);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		String expectedYear = "2025-2026";
		clearAndEnterText(yearsearch, expectedYear);
		LoggerUtil.info("Year filter: Expected = " + expectedYear + ", Actual = " + yearsearch.getAttribute("value"));
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked on Save button.");

		// Toast message validation
		String actualMessage = waitForExpectedElement(toastmsg).getText();
		LoggerUtil.info("Validating Toast Message after save. Expected = '" + expectedMessage + "', Actual = '"
				+ actualMessage + "'");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Toast message validation failed. Expected: " + expectedMessage + ", Actual: " + actualMessage);

		Thread.sleep(3000);
	}

	public void verifySaveDataWithoutShape(String expectedMessage) throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Shape mandatory field validation.");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");
		LoggerUtil.info("Entered Effective Date: 02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(500);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		String expectedCommodity = "ABCD";
		clearAndEnterText(searchBox, expectedCommodity);
		LoggerUtil.info("Commodity Group filter: Expected = " + expectedCommodity + ", Actual = "
				+ searchBox.getAttribute("value"));
		Thread.sleep(500);

		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown.");
		Thread.sleep(500);

		WebElement searchboxclasification = waitForExpectedElement(searchInputforgroupclassificationDropDownInThirdTab);
		String expectedClassification = "ABC";
		clearAndEnterText(searchboxclasification, expectedClassification);
		LoggerUtil.info("Group Classification filter: Expected = " + expectedClassification + ", Actual = "
				+ searchboxclasification.getAttribute("value"));
		searchboxclasification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		LoggerUtil.info("Clicked on Specific Grade dropdown.");
		Thread.sleep(400);

		WebElement searchboxgrade = waitForExpectedElement(SearchInputspecificgradeForThirdTab);
		String expectedGrade = "ABC";
		clearAndEnterText(searchboxgrade, expectedGrade);
		LoggerUtil.info("Specific Grade filter: Expected = " + expectedGrade + ", Actual = "
				+ searchboxgrade.getAttribute("value"));
		searchboxgrade.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		clickOnElement(Uomdropdown);
		LoggerUtil.info("Clicked on UOM dropdown.");
		Thread.sleep(300);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		String expectedUom = "Mtr";
		clearAndEnterText(searchuom, expectedUom);
		LoggerUtil.info("UOM filter: Expected = " + expectedUom + ", Actual = " + searchuom.getAttribute("value"));
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		// Shape field intentionally skipped for mandatory validation
		LoggerUtil.info("Shape field is intentionally left EMPTY for mandatory field validation.");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");

		clickOnElement(selectyeardrop);
		LoggerUtil.info("Clicked on Year dropdown.");
		Thread.sleep(3000);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		String expectedYear = "2025-2026";
		clearAndEnterText(yearsearch, expectedYear);
		LoggerUtil.info("Year filter: Expected = " + expectedYear + ", Actual = " + yearsearch.getAttribute("value"));
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked on Save button.");

		// Toast message validation
		String actualMessage = waitForExpectedElement(toastmsg).getText();
		LoggerUtil.info("Validating Toast Message after save. Expected = '" + expectedMessage + "', Actual = '"
				+ actualMessage + "'");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Toast message validation failed. Expected: " + expectedMessage + ", Actual: " + actualMessage);

		Thread.sleep(3000);
	}

	public void verifySaveDataWithoutselectyear(String expectedMessage) throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Year mandatory field validation.");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");
		LoggerUtil.info("Entered Effective Date: 02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(500);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		String expectedCommodity = "ABCD";
		clearAndEnterText(searchBox, expectedCommodity);
		LoggerUtil.info("Commodity Group filter: Expected = " + expectedCommodity + ", Actual = "
				+ searchBox.getAttribute("value"));
		Thread.sleep(500);

		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown.");
		Thread.sleep(500);

		WebElement searchboxclasification = waitForExpectedElement(searchInputforgroupclassificationDropDownInThirdTab);
		String expectedClassification = "ABC";
		clearAndEnterText(searchboxclasification, expectedClassification);
		LoggerUtil.info("Group Classification filter: Expected = " + expectedClassification + ", Actual = "
				+ searchboxclasification.getAttribute("value"));
		searchboxclasification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		LoggerUtil.info("Clicked on Specific Grade dropdown.");
		Thread.sleep(400);

		WebElement searchboxgrade = waitForExpectedElement(SearchInputspecificgradeForThirdTab);
		String expectedGrade = "ABC";
		clearAndEnterText(searchboxgrade, expectedGrade);
		LoggerUtil.info("Specific Grade filter: Expected = " + expectedGrade + ", Actual = "
				+ searchboxgrade.getAttribute("value"));
		searchboxgrade.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		clickOnElement(Uomdropdown);
		LoggerUtil.info("Clicked on UOM dropdown.");
		Thread.sleep(300);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		String expectedUom = "Mtr";
		clearAndEnterText(searchuom, expectedUom);
		LoggerUtil.info("UOM filter: Expected = " + expectedUom + ", Actual = " + searchuom.getAttribute("value"));
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		LoggerUtil.info("Clicked on Shape dropdown.");
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		String expectedShape = "Sheet";
		clearAndEnterText(shapesearch, expectedShape);
		LoggerUtil
				.info("Shape filter: Expected = " + expectedShape + ", Actual = " + shapesearch.getAttribute("value"));
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// Year intentionally skipped for mandatory validation
		LoggerUtil.info("Year field is intentionally left EMPTY for mandatory field validation.");

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked on Save button.");

		// Toast message validation
		String actualMessage = waitForExpectedElement(toastmsg).getText();
		LoggerUtil.info("Validating Toast Message after save. Expected = '" + expectedMessage + "', Actual = '"
				+ actualMessage + "'");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Toast message validation failed. Expected: " + expectedMessage + ", Actual: " + actualMessage);

		Thread.sleep(3000);
	}

	public static final By userauthtab = By.xpath("//div[@id='exTab3']/ul/li[2]/a");
	public static final By clickeditbtn = By.xpath("//table[@id='example2']/tbody/tr[5]/td[4]/a[1]/span/i");
	public static final By mastertrangle = By
			.xpath("(//div[@id='jstree']//li[@id='2']//i[@class='jstree-icon jstree-ocl'])[1]");
	public static final By commoditytrangle = By.xpath("//ul[@class='jstree-children']/li[3]/div/following-sibling::i");
	public static final By clickuncheckedforreadandwrite = By
			.xpath("//ul[@class='jstree-children']/li[3]/ul/li[2]/a/i[1]");
	public static final By clicksavebtnOnuser = By.xpath("//*[@id='btnSubmit']/i");

	public void verifyreadonlyauthority() throws InterruptedException {

		clickOnElement(userauthtab);
		LoggerUtil.info("Switched to 'User Authority' tab.");
		Thread.sleep(3000);

		clickOnElement(clickeditbtn);
		LoggerUtil.info("Clicked Edit button for user authority.");
		Thread.sleep(2500);

		clickOnElement(mastertrangle);
		LoggerUtil.info("Expanded Master menu in user authority.");
		Thread.sleep(2000);

		clickOnElement(commoditytrangle);
		LoggerUtil.info("Expanded Commodity menu in user authority.");
		Thread.sleep(2000);

		clickOnElement(clickuncheckedforreadandwrite); // Set to read-only
		LoggerUtil.info("Set Commodity module to Read-Only (unchecked Read/Write).");
		Thread.sleep(4000);

		clickOnElement(clicksavebtnOnuser);
		LoggerUtil.info("Saved user authority settings.");
		Thread.sleep(3000);

		dashboard.clickoncommodityMaster(); // Re-login or refresh authority
		LoggerUtil.info("Reopened Commodity Master to verify access restrictions.");
		Thread.sleep(2000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Opened Commodity Details Tab to check Save button visibility.");
		Thread.sleep(2000);

		// Try to locate the Save button
		List<WebElement> saveBtns = driver.findElements(ClickingSaveBtnForThirdTab);
		boolean saveBtnVisible = saveBtns.size() > 0 && saveBtns.get(0).isDisplayed();
		LoggerUtil.info("Checking Save button visibility under read-only authority. Expected: NOT visible, Actual: "
				+ (saveBtnVisible ? "Visible" : "Hidden"));

		// Assert the Save button is hidden
		if (!saveBtnVisible) {
			LoggerUtil.info(" Save button is hidden as expected under read-only authority.");
		} else {
			LoggerUtil.info(" Save button is visible even under read-only authority. TEST FAIL.");
			Assert.fail("Save button is visible even under read-only authority.");
		}

		captureStepScreenshot("Commodity Details Tab is invisible From Commodity Details Tab");
	}

	public static final By searchboxcomgrp = By.xpath("(//input[@type='search'])[17]");

	public void selectdropdownforthreedecimal() throws InterruptedException {
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(2000);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		clearAndEnterText(searchBox, "ABC");
		Thread.sleep(500);
		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(2000);
		WebElement searchclass = waitForExpectedElement(searchInputforgroupclassificationDropDownInThirdTab);
		clearAndEnterText(searchclass, "-45");
		Thread.sleep(2000);
		searchclass.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		WebElement searchForgrade = waitForExpectedElement(SearchInputspecificgradeForThirdTab);
		clearAndEnterText(searchForgrade, "ram");
		Thread.sleep(3000);
		searchForgrade.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuomvalue = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuomvalue, "mtr");
		Thread.sleep(3000);
		searchuomvalue.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(3000);
		WebElement searchshapeval = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(searchshapeval, "Flat");
		Thread.sleep(3000);
		searchshapeval.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement focusforScroll = driver.findElement(By.xpath("//span[@id='select2-Year-container']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", focusforScroll);

		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	/**
	 * Dynamic locator generator for Monthly RM / Scrap fields Example:
	 * getDynamicRMOrScrapLocator("Apr", "RM") → //input[@id='apr']
	 * getDynamicRMOrScrapLocator("Apr", "Scrap") → //input[@id='aprScrap']
	 */
	public static By getDynamicRMOrScrapLocator(String month, String type) {
		try {
			// Normalize month input (capitalize first letter only)
			String normalizedMonth = month.substring(0, 1).toLowerCase() + month.substring(1, 3).toLowerCase();

			// Construct dynamic ID
			String id = type.equalsIgnoreCase("Scrap") ? normalizedMonth + "Scrap" : normalizedMonth;

			// Build XPath dynamically
			String xpath = String.format("//input[@id='%s']", id);
			return By.xpath(xpath);
		} catch (Exception e) {
			LoggerUtil.error("Invalid month/type input for dynamic RM/Scrap locator → " + e.getMessage());
			throw e;
		}
	}

	public void enterdecimalvalue(String aprmval, String aprscrval, String mayrmval, String mayscrapval,
			String junermval, String junescrval, String julrmval, String julscrval, String augrmval, String augscrval,
			String seprmval, String sepscrval, String octrmval, String octscrval, String novrmval, String novscrval,
			String decrmval, String decscrval, String janrmval, String janscrval, String febrmval, String febscrval,
			String marrmval, String marscrval) throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);

		// Q1: April - June
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), aprmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), aprscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")), mayrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")), mayscrapval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")), junermval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")), junescrval);

		// Q2: July - September
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")), julrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")), julscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")), augrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")), augscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")), seprmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")), sepscrval);

		// Q3: October - December
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")), octrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")), octscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")), novrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")), novscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")), decrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")), decscrval);

		// Q4: January - March
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")), janrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")), janscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")), febrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")), febscrval);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")), marrmval);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")), marscrval);

		Thread.sleep(5000);
		LoggerUtil.info("✅ All monthly RM and Scrap decimal values entered successfully.");
	}

	public void SecondPagefordecimal() throws InterruptedException {

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);

	}

	public static final By aprilrmfetclist = By.xpath("//*[@id='ComDetailBody']/tr/td[8]");

	public void verifyAllValues(String expectedAprilRM) throws InterruptedException {
		dashboard.clickOnCommodityTabByName("Commodity Details");
		clickOnElement(ClickingViewbtn);
		Thread.sleep(4000); // Wait for the page to load
		List<WebElement> actualaprilrm = driver.findElements(aprilrmfetclist);
		// Fetch all April RM values in the table
		// String actualaprilrm = waitForExpectedElement(aprilrmfetclist).getText();
		String expectedvalue = expectedAprilRM;
		Assert.assertEquals(actualaprilrm, expectedvalue);

	}

	public void verifysavedataWithnegativedataSameOrnot() throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(500);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		clearAndEnterText(searchBox, "Alloys");
		Thread.sleep(500);
		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(500);

		WebElement searchboxclasification = waitForExpectedElement(searchInputforgroupclassificationDropDownInThirdTab);
		clearAndEnterText(searchboxclasification, "Alloys");
		searchboxclasification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		Thread.sleep(400);
		WebElement searchboxgrade = waitForExpectedElement(SearchInputspecificgradeForThirdTab);
		clearAndEnterText(searchboxgrade, "Alloys");
		searchboxgrade.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		clickOnElement(Uomdropdown);
		Thread.sleep(300);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WebElement focusforScroll = driver.findElement(By.xpath("//span[@id='select2-Year-container']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", focusforScroll);

		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	public void enternegativedata() throws InterruptedException {

		LoggerUtil.info("🟩 Starting Negative Data Entry for all RM and Scrap months...");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);

		// Q1: Apr–Jun
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), "-34.5399857845");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), "-45.6984878436");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")), "-43.473987953");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")), "-345.435368");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")), "-83.57654");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")), "-34.539885854");

		// Q2: Jul–Sep
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")), "-45.4576485");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")), "-534.57385648");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")), "-958.4587253");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")), "-297.976543");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")), "-578.542322");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")), "-44.47836");

		// Q3: Oct–Dec
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")), "-54.38734");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")), "-798.486756");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")), "-56.124558");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")), "-56.912238");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")), "-56.96876565");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")), "-873984.59878965");

		// Q4: Jan–Mar
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")), "-9834969.978974979");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")), "-57578785.874988");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")), "-6875948.878473");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")), "-5758.474676538");

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")), "-56.9687658");
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")), "-50.677487");

		Thread.sleep(5000);
		LoggerUtil.info("✅ Completed entering negative data for all months (RM & Scrap).");
	}

	public void verifyNegativeValuesInMonthlyData() throws InterruptedException {

		clickOnElement(ClickingViewbtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), "Alloys");
		Thread.sleep(2000);

	}

	public static final By selectedgroupheader = By.xpath("//*[@id='ForPlastic']/div[1]/div[1]/label");

	public void verifyplasticspecificChanges() throws InterruptedException {

		Thread.sleep(4000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Plastic-specific changes.");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");
		LoggerUtil.info("Entered Effective Date: 02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(2000);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		String expectedCommodity = "Plastics";
		clearAndEnterText(searchBox, expectedCommodity);
		LoggerUtil.info("Commodity Group filter: Expected = " + expectedCommodity + ", Actual = "
				+ searchBox.getAttribute("value"));
		Thread.sleep(3000);

		searchBox.sendKeys(Keys.ENTER);
		LoggerUtil.info("Pressed ENTER to apply commodity group filter.");
		Thread.sleep(3000);

		String expectedValue = "Select Process*";
		String actualText = waitForExpectedElement(selectedgroupheader).getText();
		LoggerUtil
				.info("Checking Mandatory Field for Plastics | Expected: " + expectedValue + ", Actual: " + actualText);

		Assert.assertEquals(actualText, expectedValue, "Plastic-specific mandatory field header mismatch!");
		LoggerUtil.info("✅ Plastic-specific mandatory field verification PASSED. Expected: " + expectedValue
				+ ", Actual: " + actualText);
	}

	public static final By cylinderdegc = By.xpath("//*[@id='ForPlastic']/div[2]/div[1]/label");

	public void verifyplasticselectedforsomechanges() throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Plastic Cylinder Deg C field verification.");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");
		LoggerUtil.info("Entered Effective Date: 02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(2000);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		String expectedCommodity = "Plastics";
		clearAndEnterText(searchBox, expectedCommodity);
		LoggerUtil.info("Commodity Group filter: Expected = " + expectedCommodity + ", Actual = "
				+ searchBox.getAttribute("value"));
		Thread.sleep(3000);

		searchBox.sendKeys(Keys.ENTER);
		LoggerUtil.info("Pressed ENTER to apply commodity group filter.");
		Thread.sleep(3000);

		String expectedValue = "Cylinder Deg C*";
		String actualText = waitForExpectedElement(cylinderdegc).getText();
		LoggerUtil.info("Checking Plastic Mandatory Field | Expected: " + expectedValue + ", Actual: " + actualText);

		Assert.assertEquals(actualText, expectedValue, "Plastic Cylinder Deg C mandatory field mismatch!");
		LoggerUtil.info("✅ Plastic Cylinder Deg C field verification PASSED. Expected: " + expectedValue + ", Actual: "
				+ actualText);
	}

	public static final By moduleDeg = By.xpath("//*[@id='ForPlastic']/div[3]/div[1]/label");

	public void verifyplasticspecificchangesformoduledegc() throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Plastic Mould Deg C field verification.");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");
		LoggerUtil.info("Entered Effective Date: 02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(2000);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		String expectedCommodity = "Plastics";
		clearAndEnterText(searchBox, expectedCommodity);
		LoggerUtil.info("Commodity Group filter: Expected = " + expectedCommodity + ", Actual = "
				+ searchBox.getAttribute("value"));
		Thread.sleep(3000);

		searchBox.sendKeys(Keys.ENTER);
		LoggerUtil.info("Pressed ENTER to apply commodity group filter.");
		Thread.sleep(3000);

		String expectedValue = "Mould Deg C*";
		String actualText = waitForExpectedElement(moduleDeg).getText();
		LoggerUtil.info("Checking Plastic Mandatory Field | Expected: " + expectedValue + ", Actual: " + actualText);

		Assert.assertEquals(actualText, expectedValue, "Plastic Mould Deg C mandatory field mismatch!");
		LoggerUtil.info("✅ Plastic Mould Deg C field verification PASSED. Expected: " + expectedValue + ", Actual: "
				+ actualText);
	}

	public static final By heatdisportion = By.xpath("//*[@id='ForPlastic']/div[4]/div[1]/label");

	public void verifyplasticSpecificChangesForHeatDisportionc() throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(enterdate), "02-05-2025");

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(2000);

		WebElement searchBox = waitForExpectedElement(searchInputforcommodityDetailsTab);
		clearAndEnterText(searchBox, "Plastics");
		Thread.sleep(3000);
		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		String expectedvalue = "Heat Distortion Temp Deg C*";
		String actualtext1 = waitForExpectedElement(heatdisportion).getText();

		Assert.assertEquals(actualtext1, expectedvalue);

	}

	public void clickbtn() {

		dashboard.clickOnCommodityTabByName("Commodity Details");

	}

	public void setInput(By locator, double value) {
		WebElement element = waitForExpectedElement(locator);
		element.clear();
		element.sendKeys(String.valueOf(value));
	}

// Utility method to get a numeric value from a field
	public double getDoubleValue(By locator) {
		WebElement element = waitForExpectedElement(locator);
		String val = element.getAttribute("value");
		return (val == null || val.trim().isEmpty()) ? 0 : Double.parseDouble(val.trim());
	}

	public void findibngaveragefromuiForFirstQ1() {
		LoggerUtil.info("🟩 Starting Q1 (April–June) RM Average Validation...");

		// Fetch RM values dynamically
		String aprilValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value")
				.trim();
		String mayValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value").trim();
		String juneValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value")
				.trim();

		LoggerUtil.info("✅ RM Values → April: " + aprilValStr + ", May: " + mayValStr + ", June: " + juneValStr);

		// Parse values safely
		double april = Double.parseDouble(aprilValStr);
		double may = Double.parseDouble(mayValStr);
		double june = Double.parseDouble(juneValStr);

		// Calculate expected Q1 average (rounded to 3 decimals)
		double expectedQ1 = Math.round(((april + may + june) / 3) * 1000.0) / 1000.0;

		// Fetch Q1 UI value (April–June RM)
		String q1UiValStr = waitForExpectedElement(getDynamicPeriodLocator("q1", "RM")).getAttribute("value").trim();

		if (q1UiValStr == null || q1UiValStr.isEmpty()) {
			LoggerUtil.mismatch("❌ Q1 RM Average is blank. Expected: " + expectedQ1);
			Assert.fail("Q1 RM Average missing in UI. Expected: " + expectedQ1);
		} else {
			double q1UiVal = Double.parseDouble(q1UiValStr);
			LoggerUtil.info("Q1 RM Average | Expected: " + expectedQ1 + ", Actual (UI): " + q1UiVal);

			// Assertion with precision tolerance
			Assert.assertEquals(q1UiVal, expectedQ1, 0.01,
					"❌ Q1 RM Average mismatch | Expected: " + expectedQ1 + ", Actual: " + q1UiVal);
			LoggerUtil.pass("✅ Q1 RM Average verified successfully. Expected: " + expectedQ1 + ", Actual: " + q1UiVal);
		}
	}

	public void findaveragefromuisecondQ2() {

		LoggerUtil.info("🟩 Starting Q2 (July–September) RM Average Validation...");

		// Fetch RM values dynamically for Q2 months
		String julyValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value")
				.trim();
		String augustValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")).getAttribute("value")
				.trim();
		String septemberValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")).getAttribute("value")
				.trim();

		LoggerUtil.info(
				"✅ RM Values → July: " + julyValStr + ", August: " + augustValStr + ", September: " + septemberValStr);

		// Parse values safely
		double july = Double.parseDouble(julyValStr);
		double august = Double.parseDouble(augustValStr);
		double september = Double.parseDouble(septemberValStr);

		// Calculate expected average (rounded to 3 decimals)
		double expectedQ2 = Math.round(((july + august + september) / 3) * 1000.0) / 1000.0;

		// Fetch UI Q2 value (July–September RM)
		String q2ActualStr = waitForExpectedElement(getDynamicPeriodLocator("q2", "RM")).getAttribute("value").trim();

		if (q2ActualStr == null || q2ActualStr.isEmpty()) {
			LoggerUtil.mismatch("❌ Q2 RM Average is blank. Expected: " + expectedQ2);
			Assert.fail("Q2 RM Average missing in UI. Expected: " + expectedQ2);
		} else {
			double q2Actual = Double.parseDouble(q2ActualStr);
			LoggerUtil.info("Q2 RM Average | Expected: " + expectedQ2 + ", Actual (UI): " + q2Actual);

			// Validate match within tolerance
			Assert.assertEquals(q2Actual, expectedQ2, 0.01,
					"❌ Q2 RM Average mismatch | Expected: " + expectedQ2 + ", Actual: " + q2Actual);
			LoggerUtil.pass("✅ Q2 RM Average verified successfully. Expected: " + expectedQ2 + ", Actual: " + q2Actual);
		}
	}

	public static final By commoditygrplist = By.xpath("//span[@class='select2-results']/ul/li");
	public static final By grpclasfic = By.xpath("//span[@class='select2-results']/ul/li");
	public static final By specificgrade = By.xpath("//span[@class='select2-results']/ul/li");
	public static final By uomlist = By.xpath("//span[@class='select2-results']/ul/li");
	public static final By shape = By.xpath("//span[@class='select2-results']/ul/li");
	public static final By yearlist = By.xpath("//span[@class='select2-results']/ul/li");

	public void selectFromDropdown(By dropdownLocator, String entervalue) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));

		List<WebElement> dropdownList = driver.findElements(dropdownLocator);
		for (WebElement item : dropdownList) {
			if (item.getText().equalsIgnoreCase(entervalue)) {
				item.click(); // Click the matching item
				System.out.println("Selected: " + entervalue); // Optional: for debugging/logging
				break; // Exit loop after selecting
			}
		}
	}

	public void SaveUpdateAndSaveAsNewData(String entervalue, String entervalue1, String entervalue2,
			String entervalue3, String entervalue4, String entervalue5) throws InterruptedException {
		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		selectFromDropdown(commoditygrplist, entervalue);
		Thread.sleep(3000);
		// Select group classification
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		selectFromDropdown(grpclasfic, entervalue1);
		Thread.sleep(3000);
		// Select specific grade
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		selectFromDropdown(specificgrade, entervalue2);
		Thread.sleep(3000);
		// Select UOM
		clickOnElement(Uomdropdown);
		selectFromDropdown(uomlist, entervalue3);
		Thread.sleep(7000);
		// Select shape
		clickOnElement(ClickingShapedropdownForthirdTab);
		selectFromDropdown(shape, "Plate");
		Thread.sleep(3000);
		// Select year
		clickOnElement(selectyeardrop);
		selectFromDropdown(yearlist, entervalue5);

	}

	public static final By commoditygroupcolumntabledata = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[3]");

	public void SecondPageforsaveupdateandnew(String searchval) throws InterruptedException {

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(5000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);

		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchval);
		Thread.sleep(4000);
		String actualvalue = waitForExpectedElement(commoditygroupcolumntabledata).getText();
		String expectedvalue = searchval;
		Thread.sleep(3000);
		Assert.assertEquals(actualvalue, expectedvalue);

	}

	public static final By ClickingEditbtnCommodityDetailsTable = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[2]/a[1]/i");
	public static final By fetchdatacomgrp = By
			.xpath("//span[@class='selection']/span/span[@id='select2-commodityDrop-container']");
	public static final By updatebtn = By.xpath("//button[@id='tab3Save']");

	public void editbtnIsWorkingornot(String searchval, String entervalue6, String entervalue7, String entervalue8,
			String entervalue9) throws InterruptedException {

//	clickOnElement(commodetailsTab);
//	
		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchval);
		Thread.sleep(4000);
		String actualvalue = waitForExpectedElement(commoditygroupcolumntabledata).getText();
		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(3000);
		captureStepScreenshot("User Wants To verify edit btn Is Working Well");

		String expectedvalue = waitForExpectedElement(fetchdatacomgrp).getText();
		Assert.assertEquals(actualvalue, expectedvalue);

		Thread.sleep(3000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		selectFromDropdown(commoditygrplist, entervalue6);
		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		selectFromDropdown(grpclasfic, entervalue7);
		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		selectFromDropdown(ClickingspecificgradeBtndropdownForThirdTab, entervalue8);
		Thread.sleep(3000);
		clickOnElement(Uomdropdown);
		Thread.sleep(4000);
		selectFromDropdown(uomlist, entervalue9);
		Thread.sleep(3000);
		clickOnElement(updatebtn);
	}

	public static final By addcommodity = By.xpath("//input[@id='commodityGroup']");
	public static final By addcomSavebtn = By.xpath("//button[@id='tab1Save']");

	public static void savedatainaddcommoditytab(String addcommodityvalue) throws InterruptedException {
		clearAndEnterText(waitForExpectedElement(addcommodity), addcommodityvalue);
		Thread.sleep(3000);
		clickOnElement(addcomSavebtn);
	}

	public static final By commoditygroupdropdown = By.xpath("//span[@id='select2-commodityDropdown-container']");
	public static final By searchcommoditygroupdown = By
			.xpath("//*[@id='page-top']/span[2]/span/span[1]/input[@type='search']");
	public static final By selectvaluecommoditygroupvalue = By
			.xpath("//ul[@id='select2-commodityDropdown-results']/li");
	public static final By groupclassification = By.xpath("//input[@id='subGroupClassification']");
	public static final By specificgradevalue = By.xpath("//input[@id='SpecificGradeText']");
	public static final By Densityvalue = By.xpath("//input[@id='groupDensity']");
	public static final By savebtncommoditygrp = By.xpath("//*[@id='tab2Save']");

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static final By EnterValueSearchBoxForCommodityGroupDropdownSecondTab = By
			.xpath("//span[@class='select2-dropdown select2-dropdown--below']//input");

	public static void savesecondtabcommoditygroup(String searchcommodityvalue, String grpclassificationvalue,
			String specificgradevalye, String densityvalue) throws InterruptedException {
		Thread.sleep(6000);

		WebElement select2Box = driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single"));
		Actions actions = new Actions(driver);
		actions.moveToElement(select2Box).click().perform();
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(1000);

		// 🔹 Step 1: Type the desired value into the Select2 search box
		WebElement searchBox = waitForExpectedElement(EnterValueSearchBoxForCommodityGroupDropdownSecondTab);
		clearAndEnterText(searchBox, searchcommodityvalue);
		LoggerUtil.info("Searched for Commodity Group: " + searchcommodityvalue);

		// 🔹 Step 2: Wait for and iterate over the filtered list
		Thread.sleep(2000); // Allow search results to load
		List<WebElement> groupList = driver.findElements(selectvaluecommoditygroupvalue);

		boolean isValueFound = false;
		for (WebElement grpValue : groupList) {
			String text = grpValue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				grpValue.click();
				LoggerUtil.pass("Selected Commodity Group value: " + searchcommodityvalue);
				isValueFound = true;
				break;
			}
		}

		// 🔹 Step 3: Handle case when value not found
		if (!isValueFound) {
			LoggerUtil.mismatch("❌ Commodity Group value not found: " + searchcommodityvalue);
			Assert.fail("Commodity Group '" + searchcommodityvalue + "' not found in dropdown list.");
		}

		Thread.sleep(1000);

		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		LoggerUtil.info("Entered Group Classification: " + grpclassificationvalue);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		LoggerUtil.info("Entered Specific Grade Value: " + specificgradevalye);

		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		LoggerUtil.info("Entered Density Value: " + densityvalue);

		clickOnElement(savebtncommoditygrp);
		LoggerUtil.info("Clicked Save in Second Tab for Commodity Group.");
		Thread.sleep(5000);
	}

	public static final By commoditydropdownlist = By.xpath(
			"//ul[@id='select2-commodityDrop-results']/li[contains(@class, 'select2-results__option')]\r\n" + "");
	public static final By groupclassificationlist = By.xpath("//ul[@id='select2-materialDrop-results']/li");
	public static final By specificgradelist = By.xpath("//ul[@id='select2-SpecificGrade-results']/li");

	public static void savedataforthreedecimal(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue,String enteryear) throws InterruptedException {

		try {
			LoggerUtil.info("STEP 1: Open 'Commodity Group' dropdown.");
			Thread.sleep(5000);
			clickOnElement(ClickingcommoditydropdownBtnThirdTab);

			LoggerUtil.info("STEP 2: Enter Commodity Group → " + searchcommoditydropvalue);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

			List<WebElement> comlist = driver.findElements(commoditydropdownlist);
			boolean comFound = false;
			for (WebElement comgrpvalue : comlist) {
				if (comgrpvalue.getText().trim().equalsIgnoreCase(searchcommoditydropvalue)) {
					comgrpvalue.click();
					comFound = true;
					LoggerUtil.pass("Commodity Group '" + searchcommoditydropvalue + "' selected successfully.");
					break;
				}
			}
			if (!comFound) {
				LoggerUtil.fail("Commodity Group '" + searchcommoditydropvalue + "' not found.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Commodity Group selection failed → " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 3: Open 'Group Classification' dropdown.");
			Thread.sleep(5000);
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
			boolean grpFound = false;
			for (WebElement grpclasslistval : grpclasslist) {
				if (grpclasslistval.getText().trim().equalsIgnoreCase(searchcommodityclassification)) {
					grpclasslistval.click();
					grpFound = true;
					LoggerUtil.pass(
							"Group Classification '" + searchcommodityclassification + "' selected successfully.");
					break;
				}
			}
			if (!grpFound) {
				LoggerUtil.fail("Group Classification '" + searchcommodityclassification + "' not found.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Group Classification selection failed → " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 4: Open 'Specific Grade' dropdown.");
			Thread.sleep(5000);
			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);

			List<WebElement> comgradelist = driver.findElements(specificgradelist);
			boolean gradeFound = false;
			for (WebElement comgradelistval : comgradelist) {
				if (comgradelistval.getText().trim().equalsIgnoreCase(selectcommoditygradevalue)) {
					comgradelistval.click();
					gradeFound = true;
					LoggerUtil.pass("Specific Grade '" + selectcommoditygradevalue + "' selected successfully.");
					break;
				}
			}
			if (!gradeFound) {
				LoggerUtil.fail("Specific Grade '" + selectcommoditygradevalue + "' not found.");
			}
		} catch (Exception e) {
			LoggerUtil.error("Specific Grade selection failed → " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 5: Select UOM = 'Mtr'");
			clickOnElement(Uomdropdown);
			Thread.sleep(3000);

			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			searchuom.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			LoggerUtil.pass("UOM 'Mtr' selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("UOM selection failed → " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 6: Select Shape = 'Sheet'");
			clickOnElement(ClickingShapedropdownForthirdTab);
			Thread.sleep(300);

			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			clearAndEnterText(shapesearch, "Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			LoggerUtil.pass("Shape 'Sheet' selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Shape selection failed → " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 7: Scroll window by 130px.");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 130);");
			Thread.sleep(2000);
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Scroll failed → " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 8: Select Year = '2025-2026'");
			clickOnElement(selectyeardrop);
			Thread.sleep(500);

			WebElement yearsearch = waitForExpectedElement(searchinputyear);
			clearAndEnterText(yearsearch, enteryear);
			yearsearch.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			LoggerUtil.pass("Year '2025-2026' selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Year selection failed → " + e.getMessage());
		}

	}

	public static final By fetchingcommoditygrpcolumn = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[3]");
	public static final By marchscrap = By.xpath("//input[@id='marScrap']");

	public static void enetrRmAndScrapValues(String enteraprilrm, String enteraprilscrap, String entermayrm,
			String entermayscrap, String enterjunerm, String enterjunescrap, String enterjulyrm, String enterjulyscrap,
			String enteraugustrm, String enteraugscrap, String enterseptemrm, String entersepscrap, String enetroctrm,
			String enteroctscrap, String enternovrm, String enternovscrap, String enterdecrm, String enterdecscrap,
			String enetrjanram, String enterjanscrap, String enterfebrm, String enterfebscrap, String entermarchrm,
			String entermarchscrap, String entersearchvalue) throws InterruptedException {

		
		SoftAssert soft = new SoftAssert();
		
		
		LoggerUtil.info("Filling RM & Scrap values for each month with 3 decimal precision...");

		// April
		LoggerUtil.info("April RM: " + enteraprilrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), enteraprilrm);
		LoggerUtil.info("April Scrap: " + enteraprilscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), enteraprilscrap);

		// May
		LoggerUtil.info("May RM: " + entermayrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")), entermayrm);
		LoggerUtil.info("May Scrap: " + entermayscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")), entermayscrap);

		// June
		LoggerUtil.info("June RM: " + enterjunerm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")), enterjunerm);
		LoggerUtil.info("June Scrap: " + enterjunescrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")), enterjunescrap);

		// July
		LoggerUtil.info("July RM: " + enterjulyrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")), enterjulyrm);
		LoggerUtil.info("July Scrap: " + enterjulyscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")), enterjulyscrap);

		// August
		LoggerUtil.info("August RM: " + enteraugustrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")), enteraugustrm);
		LoggerUtil.info("August Scrap: " + enteraugscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")), enteraugscrap);

		// September
		LoggerUtil.info("September RM: " + enterseptemrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")), enterseptemrm);
		LoggerUtil.info("September Scrap: " + entersepscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")), entersepscrap);

		// October
		LoggerUtil.info("October RM: " + enetroctrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")), enetroctrm);
		LoggerUtil.info("October Scrap: " + enteroctscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")), enteroctscrap);

		// November
		LoggerUtil.info("November RM: " + enternovrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")), enternovrm);
		LoggerUtil.info("November Scrap: " + enternovscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")), enternovscrap);

		// December
		LoggerUtil.info("December RM: " + enterdecrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")), enterdecrm);
		LoggerUtil.info("December Scrap: " + enterdecscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")), enterdecscrap);

		// January
		LoggerUtil.info("January RM: " + enetrjanram);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")), enetrjanram);
		LoggerUtil.info("January Scrap: " + enterjanscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")), enterjanscrap);

		// February
		LoggerUtil.info("February RM: " + enterfebrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")), enterfebrm);
		LoggerUtil.info("February Scrap: " + enterfebscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")), enterfebscrap);

		// March
		LoggerUtil.info("March RM: " + entermarchrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")), entermarchrm);
		LoggerUtil.info("March Scrap: " + entermarchscrap);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")), entermarchscrap);

		// --- Save & Search Flow ---
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		try {
		    clickOnElement(ClickingSaveBtnForThirdTab);
		    LoggerUtil.info("Clicked Save button for third tab.");
		    Thread.sleep(4000);

		    clickOnElement(ClickingViewbtn);
		    LoggerUtil.info("Clicked View button to verify saved data.");
		    Thread.sleep(9000);

		    clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		    LoggerUtil.info("Entered search value → " + entersearchvalue);
		    Thread.sleep(8000);

		    //  Verify saved commodity group value (soft check)
		    String expectedValue = entersearchvalue.trim();
		    String actualValue = waitForExpectedElement(fetchingcommoditygrpcolumn).getText().trim();

		    if (!expectedValue.equals(actualValue)) {
		        LoggerUtil.error(" Mismatch: Expected [" + expectedValue + "] but found [" + actualValue + "]");
		        soft.fail("Commodity Group Mismatch → Expected [" + expectedValue + "] but found [" + actualValue + "]");
		    } else {
		        LoggerUtil.pass(" Commodity Group matched correctly: " + actualValue);
		    }

		} catch (Exception e) {
		    LoggerUtil.error("⚠️ Exception during search/verify step → " + e.getMessage());
		    soft.fail("Error in verification flow: " + e.getMessage());
		}
		try {
		    clickOnElement(ClickingEditbtnCommodityDetailsTable);
		    LoggerUtil.info("Clicked Edit button to verify decimal precision.");
		    Thread.sleep(3000);

		    LoggerUtil.info("User going to verify all decimal values are saved correctly or not.");
		    // ... your further decimal-precision validation steps here ...

		} catch (Exception e) {
		    LoggerUtil.error("⚠️ Exception during Edit/Decimal validation → " + e.getMessage());
		    soft.fail("Decimal validation failed: " + e.getMessage());
		}

		// ✅ At the end of your test method
		soft.assertAll();

		try {
			LoggerUtil.info("STEP 7: Scroll window by 130px.");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 290);");
			Thread.sleep(2000);
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Scroll failed → " + e.getMessage());
		}

		// --- Verification ---
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };
		String[] rmValues = { enteraprilrm, entermayrm, enterjunerm, enterjulyrm, enteraugustrm, enterseptemrm,
				enetroctrm, enternovrm, enterdecrm, enetrjanram, enterfebrm, entermarchrm };
		String[] scrapValues = { enteraprilscrap, entermayscrap, enterjunescrap, enterjulyscrap, enteraugscrap,
				entersepscrap, enteroctscrap, enternovscrap, enterdecscrap, enterjanscrap, enterfebscrap,
				entermarchscrap };

		for (int i = 0; i < months.length; i++) {
			String actualRm = waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")).getAttribute("value");
			String actualScrap = waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap"))
					.getAttribute("value");

			LoggerUtil.info(months[i] + " RM | Expected: " + rmValues[i] + ", Actual: " + actualRm);
			Assert.assertEquals(rmValues[i], actualRm);

			LoggerUtil.info(months[i] + " Scrap | Expected: " + scrapValues[i] + ", Actual: " + actualScrap);
			Assert.assertEquals(scrapValues[i], actualScrap);
		}
		soft.assertAll();
	}

	public void savenegativevaluesforRmAndScrap(String addcomfirstTabvalue) throws InterruptedException {
		clearAndEnterText(waitForExpectedElement(addcommodity), addcomfirstTabvalue);
		Thread.sleep(2000);
		clickOnElement(addcomSavebtn);
	}

	public void savenegativevaluesinsecondtabforrmAndScrap(String searchcommodityvalue, String grpclassificationvalue,
			String specificgradevalye, String densityvalue) throws InterruptedException {
		Thread.sleep(2000);
		clickOnElement(commoditygroupdropdown);

		Thread.sleep(2000);

		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);

		for (WebElement grpvalue : grouplist) {
			String text = grpvalue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				grpvalue.click();
				System.out.println("Selected value: " + text);
				break;
			}
		}
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		Thread.sleep(1000);
		clickOnElement(savebtncommoditygrp);
		Thread.sleep(7000);
	}

	public void savenegativermandscrapthirdtab(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue) throws InterruptedException {

		Thread.sleep(5000);

		
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {

			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {

				comgrpvalue.click();
			}

		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);

		for (WebElement grpclasslistval : grpclasslist) {

			String comclssifi = grpclasslistval.getText().trim();

			if (comclssifi.equalsIgnoreCase(searchcommodityclassification))
				;
			{
				grpclasslistval.click();

				System.out.println(searchcommodityclassification);
				break;
			}

		}
		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {

			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue))
				;
			{

				comgradelistval.click();
				break;
			}

		}
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		Thread.sleep(2000);
		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	public void enternegativevaluesinrmandscrap(String enteraprilrm, String enteraprilscrap, String entermayrm,
			String entermayscrap, String enterjunerm, String enterjunescrap, String enterjulyrm, String enterjulyscrap,
			String enteraugustrm, String enteraugscrap, String enterseptemrm, String entersepscrap, String enetroctrm,
			String enteroctscrap, String enternovrm, String enternovscrap, String enterdecrm, String enterdecscrap,
			String enetrjanram, String enterjanscrap, String enterfebrm, String enterfebscrap, String entermarchrm,
			String entermarchscrap, String entersearchvalue) throws InterruptedException {

		// Data entry - untouched
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), enteraprilrm);
		LoggerUtil.info("April RM field entered: " + enteraprilrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), enteraprilscrap);
		LoggerUtil.info("April Scrap field entered: " + enteraprilscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")), entermayrm);
		LoggerUtil.info("May RM field entered: " + entermayrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")), entermayscrap);
		LoggerUtil.info("May Scrap field entered: " + entermayscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")), enterjunerm);
		LoggerUtil.info("June RM field entered: " + enterjunerm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")), enterjunescrap);
		LoggerUtil.info("June Scrap field entered: " + enterjunescrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")), enterjulyrm);
		LoggerUtil.info("July RM field entered: " + enterjulyrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")), enterjulyscrap);
		LoggerUtil.info("July Scrap field entered: " + enterjulyscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")), enteraugustrm);
		LoggerUtil.info("August RM field entered: " + enteraugustrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")), enteraugscrap);
		LoggerUtil.info("August Scrap field entered: " + enteraugscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")), enterseptemrm);
		LoggerUtil.info("September RM field entered: " + enterseptemrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")), entersepscrap);
		LoggerUtil.info("September Scrap field entered: " + entersepscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")), enetroctrm);
		LoggerUtil.info("October RM field entered: " + enetroctrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")), enteroctscrap);
		LoggerUtil.info("October Scrap field entered: " + enteroctscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")), enternovrm);
		LoggerUtil.info("November RM field entered: " + enternovrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")), enternovscrap);
		LoggerUtil.info("November Scrap field entered: " + enternovscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")), enterdecrm);
		LoggerUtil.info("December RM field entered: " + enterdecrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")), enterdecscrap);
		LoggerUtil.info("December Scrap field entered: " + enterdecscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")), enetrjanram);
		LoggerUtil.info("January RM field entered: " + enetrjanram);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")), enterjanscrap);
		LoggerUtil.info("January Scrap field entered: " + enterjanscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")), enterfebrm);
		LoggerUtil.info("February RM field entered: " + enterfebrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")), enterfebscrap);
		LoggerUtil.info("February Scrap field entered: " + enterfebscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")), entermarchrm);
		LoggerUtil.info("March RM field entered: " + entermarchrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")), entermarchscrap);
		LoggerUtil.info("March Scrap field entered: " + entermarchscrap);

		// Business segment + search + save + edit flow (unchanged)
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);
		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		Thread.sleep(4000);

		String expectedvalue = entersearchvalue;
		String actualvalue = waitForExpectedElement(fetchingcommoditygrpcolumn).getText();
		LoggerUtil
				.info("Commodity Group Search Verification | Expected: " + expectedvalue + ", Actual: " + actualvalue);
		Assert.assertEquals(expectedvalue, actualvalue);

		Thread.sleep(2000);
		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(3000);

		LoggerUtil.info("User going to verify all decimal (including negative) values are saved correctly or not");

		// 🔹 Month-by-month verification (unchanged)
		verifyNegativeMonthValue("April", enteraprilrm, enteraprilscrap);
		verifyNegativeMonthValue("May", entermayrm, entermayscrap);
		verifyNegativeMonthValue("June", enterjunerm, enterjunescrap);
		verifyNegativeMonthValue("July", enterjulyrm, enterjulyscrap);
		verifyNegativeMonthValue("August", enteraugustrm, enteraugscrap);
		verifyNegativeMonthValue("September", enterseptemrm, entersepscrap);
		verifyNegativeMonthValue("October", enetroctrm, enteroctscrap);
		verifyNegativeMonthValue("November", enternovrm, enternovscrap);
		verifyNegativeMonthValue("December", enterdecrm, enterdecscrap);
		verifyNegativeMonthValue("January", enetrjanram, enterjanscrap);
		verifyNegativeMonthValue("February", enterfebrm, enterfebscrap);
		verifyNegativeMonthValue("March", entermarchrm, entermarchscrap);
	}

	/**
	 * Reusable internal method for verifying RM and Scrap per month (supports
	 * negative values)
	 */
	private void verifyNegativeMonthValue(String month, String expectedRm, String expectedScrap) {
		String actualRm = waitForExpectedElement(getDynamicRMOrScrapLocator(month.substring(0, 3), "RM"))
				.getAttribute("value");
		String actualScrap = waitForExpectedElement(getDynamicRMOrScrapLocator(month.substring(0, 3), "Scrap"))
				.getAttribute("value");

		LoggerUtil.info(month + " RM | Expected: " + expectedRm + ", Actual: " + actualRm);
		Assert.assertEquals(expectedRm, actualRm);

		LoggerUtil.info(month + " Scrap | Expected: " + expectedScrap + ", Actual: " + actualScrap);
		Assert.assertEquals(expectedScrap, actualScrap);
	}

	public void verificationofaverageforq1() throws InterruptedException {
		

		// ---- Fetch RM Values Dynamically (April–June) ----
		String aprilVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value").trim();
		String mayVal = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value").trim();
		String juneVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q1 RM Breakdown → April: " + aprilVal + ", May: " + mayVal + ", June: " + juneVal);

		// ---- Parse & Calculate Expected Average ----
		double april = Double.parseDouble(aprilVal);
		double may = Double.parseDouble(mayVal);
		double june = Double.parseDouble(juneVal);
		double expectedQ1 = Math.round(((april + may + june) / 3) * 1000.0) / 1000.0; // 3-decimal rounding

		// ---- Fetch Actual Q1 Value (Dynamic) ----
		String q1ActualVal = waitForExpectedElement(getDynamicPeriodLocator("q1", "RM")).getAttribute("value").trim();
		LoggerUtil.info("Q1 RM Calculation | Expected (calculated): " + expectedQ1 + ", Actual (UI): "
				+ (q1ActualVal.isBlank() ? "[BLANK]" : q1ActualVal));

		// ---- Validation ----
		if (q1ActualVal.isBlank()) {
			LoggerUtil.error("❌ Q1 RM Average is blank in UI. Expected: " + expectedQ1 + ", Actual: BLANK");
			Assert.fail("Q1 RM Average is blank but should be " + expectedQ1);
		} else {
			double q1Actual = Double.parseDouble(q1ActualVal);
			Assert.assertEquals(q1Actual, expectedQ1, 0.01,
					"Q1 RM Average mismatch (expected: " + expectedQ1 + ", actual: " + q1Actual + ")");
			LoggerUtil.pass("✅ Q1 RM Average correct. Expected: " + expectedQ1 + ", Actual: " + q1Actual);
		}
	}

	public static void savedatainfirsttabforcalq1q2q3q4(String addcomfirstTabvalue) throws InterruptedException {
		clearAndEnterText(waitForExpectedElement(addcommodity), addcomfirstTabvalue);
		Thread.sleep(2000);
		clickOnElement(addcomSavebtn);
		Thread.sleep(4000);
	}

	public static void savedatasecondttabforcalculatingq1q2q3q4(String searchcommodityvalue,
			String grpclassificationvalue, String specificgradevalye, String densityvalue) throws InterruptedException {
		Thread.sleep(2000);
		clickOnElement(commoditygroupdropdown);

		Thread.sleep(2000);

		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);

		for (WebElement grpvalue : grouplist) {
			String text = grpvalue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				grpvalue.click();
				System.out.println("Selected value: " + text);
				break;
			}
		}
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		Thread.sleep(1000);
		clickOnElement(savebtncommoditygrp);
		Thread.sleep(7000);
	}

	public static final By EnterGroupClassificationSearchboxThirdTab = By.xpath("//span[@class='select2-container select2-container--default select2-container--open']//input[@type='search']");
	public static void savedatathirdtabforcalculatingq1q2q3q4(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		LoggerUtil.info("🟩 Starting method → savedatathirdtabforcalculatingq1q2q3q4");

// Commodity Group
		try {
			Thread.sleep(9000);
			clickOnElement(ClickingcommoditydropdownBtnThirdTab);
			LoggerUtil.info("STEP 1: Clicked on Commodity Group dropdown.");

			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
			LoggerUtil.info("Entered Commodity Group search value = " + searchcommoditydropvalue);

			List<WebElement> comlist = driver.findElements(commoditydropdownlist);
			boolean comFound = false;
			for (WebElement comgrpvalue : comlist) {
				if (comgrpvalue.getText().trim().equalsIgnoreCase(searchcommoditydropvalue)) {
					comgrpvalue.click();
					LoggerUtil.pass("Commodity Group '" + searchcommoditydropvalue + "' selected successfully.");
					comFound = true;
					break;
				}
			}
			softAssert.assertTrue(comFound, "Commodity Group not found: " + searchcommoditydropvalue);
		} catch (Exception e) {
			LoggerUtil.error("❌ Commodity Group selection failed → " + e.getMessage());
			softAssert.fail("Commodity Group selection failed.");
		}

// Group Classification
		try {
			Thread.sleep(6000);
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			LoggerUtil.info("STEP 2: Clicked on Group Classification dropdown.");
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(EnterGroupClassificationSearchboxThirdTab), searchcommodityclassification);
			List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
			Thread.sleep(4000);
			boolean grpFound = false;
			for (WebElement grpclasslistval : grpclasslist) {
				if (grpclasslistval.getText().trim().equalsIgnoreCase(searchcommodityclassification)) {
					grpclasslistval.click();
					LoggerUtil.pass(
							"Group Classification '" + searchcommodityclassification + "' selected successfully.");
					grpFound = true;
					break;
				}
			}
			softAssert.assertTrue(grpFound, "Group Classification not found: " + searchcommodityclassification);
		} catch (Exception e) {
			LoggerUtil.error("❌ Group Classification selection failed → " + e.getMessage());
			softAssert.fail("Group Classification selection failed.");
		}

// Specific Grade
		try {
			Thread.sleep(5000);
			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
			LoggerUtil.info("STEP 3: Clicked on Specific Grade dropdown.");

			Thread.sleep(2000);
			List<WebElement> comgradelist = driver.findElements(specificgradelist);
			boolean gradeFound = false;
			for (WebElement comgradelistval : comgradelist) {
				if (comgradelistval.getText().trim().equalsIgnoreCase(selectcommoditygradevalue)) {
					comgradelistval.click();
					LoggerUtil.pass("Specific Grade '" + selectcommoditygradevalue + "' selected successfully.");
					gradeFound = true;
					break;
				}
			}
			softAssert.assertTrue(gradeFound, "Specific Grade not found: " + selectcommoditygradevalue);
		} catch (Exception e) {
			LoggerUtil.error("❌ Specific Grade selection failed → " + e.getMessage());
			softAssert.fail("Specific Grade selection failed.");
		}

// UOM
		try {
			clickOnElement(Uomdropdown);
			LoggerUtil.info("STEP 4: Clicked on UOM dropdown.");
			Thread.sleep(3000);

			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			Thread.sleep(3000);
			LoggerUtil.info("Entered UOM = Mtr");
			searchuom.sendKeys(Keys.ENTER);
			Thread.sleep(200);

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 130);");
			LoggerUtil.info("Scrolled page after UOM selection.");
		} catch (Exception e) {
			LoggerUtil.error("❌ UOM selection failed → " + e.getMessage());
			softAssert.fail("UOM selection failed.");
		}

// Shape
		try {
			Thread.sleep(3000);
			clickOnElement(ClickingShapedropdownForthirdTab);
			LoggerUtil.info("STEP 5: Clicked on Shape dropdown.");

			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			Thread.sleep(3000);
			clearAndEnterText(shapesearch, "Sheet");
			LoggerUtil.info("Entered Shape = Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 130);");
			LoggerUtil.info("Scrolled page after Shape selection.");
		} catch (Exception e) {
			LoggerUtil.error("❌ Shape selection failed → " + e.getMessage());
			softAssert.fail("Shape selection failed.");
		}

// Year
		try {
			Thread.sleep(3000);
			clickOnElement(selectyeardrop);
			LoggerUtil.info("STEP 6: Clicked on Year dropdown.");

			Thread.sleep(2000);
			WebElement yearsearch = waitForExpectedElement(searchinputyear);

			clearAndEnterText(yearsearch, "2025-2026");
			Thread.sleep(1000);
			LoggerUtil.info("Entered Year = 2025-2026");
			yearsearch.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			LoggerUtil.pass("Year '2025-2026' selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("❌ Year selection failed → " + e.getMessage());
			softAssert.fail("Year selection failed.");
		}

		LoggerUtil.info("STEP 7: Execute all collected Soft Assertions.");
		softAssert.assertAll();
	}

	public static void enterRmandScrapvalueForcalculatingRmAndScrapvalue(String enteraprilrm, String enteraprilscrap,
			String entermayrm, String entermayscrap, String enterjunerm, String enterjunescrap, String enterjulyrm,
			String enterjulyscrap, String enteraugustrm, String enteraugscrap, String enterseptemrm,
			String entersepscrap, String enetroctrm, String enteroctscrap, String enternovrm, String enternovscrap,
			String enterdecrm, String enterdecscrap, String enetrjanram, String enterjanscrap, String enterfebrm,
			String enterfebscrap, String entermarchrm, String entermarchscrap, String entersearchvalue)
			throws InterruptedException {

		LoggerUtil.info("===== Starting RM and Scrap Entry (Dynamic Universal) =====");

		// Define month sequence (April → March)
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };

		// Define RM and Scrap values for each month
		String[] rmValues = { enteraprilrm, entermayrm, enterjunerm, enterjulyrm, enteraugustrm, enterseptemrm,
				enetroctrm, enternovrm, enterdecrm, enetrjanram, enterfebrm, entermarchrm };

		String[] scrapValues = { enteraprilscrap, entermayscrap, enterjunescrap, enterjulyscrap, enteraugscrap,
				entersepscrap, enteroctscrap, enternovscrap, enterdecscrap, enterjanscrap, enterfebscrap,
				entermarchscrap };

		// ===== STEP 1: Enter All Month Values Dynamically =====
		for (int i = 0; i < months.length; i++) {
			try {
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);
				LoggerUtil.info("Entered " + months[i] + " RM = " + rmValues[i]);

				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
				LoggerUtil.info("Entered " + months[i] + " Scrap = " + scrapValues[i]);
			} catch (Exception e) {
				LoggerUtil.error("❌ Error while entering " + months[i] + " RM/Scrap values → " + e.getMessage());
			}
		}

		LoggerUtil.pass("✅ All RM & Scrap values entered successfully for April → March.");
		Thread.sleep(3000);

		// ===== STEP 2: Business Segment and Save =====
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(6000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(5000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.pass("💾 Save button clicked successfully.");
		Thread.sleep(4000);

		driver.navigate().refresh();
		Thread.sleep(8000);

		// ===== STEP 3: View and Edit Verification =====
		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		Thread.sleep(4000);

		String actualValue = waitForExpectedElement(fetchingcommoditygrpcolumn).getText().trim();
		Assert.assertEquals(actualValue, entersearchvalue, "Commodity Group mismatch!");
		LoggerUtil.pass("Commodity Group verified: " + actualValue);

		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(4000);

		LoggerUtil.info("🔍 Verifying saved RM & Scrap values month-wise...");

		// ===== STEP 4: Validation Using SoftAssert =====
		SoftAssert softAssert = new SoftAssert();

		for (int i = 0; i < months.length; i++) {
			try {
				String actualRM = waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM"))
						.getAttribute("value").trim();
				String actualScrap = waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap"))
						.getAttribute("value").trim();

				LoggerUtil.info("Checking " + months[i] + " → Entered RM: " + rmValues[i] + ", Actual RM: " + actualRM);
				LoggerUtil.info("Checking " + months[i] + " → Entered Scrap: " + scrapValues[i] + ", Actual Scrap: "
						+ actualScrap);

				softAssert.assertEquals(actualRM, rmValues[i], months[i] + " RM mismatch!");
				softAssert.assertEquals(actualScrap, scrapValues[i], months[i] + " Scrap mismatch!");
			} catch (Exception e) {
				LoggerUtil.error("❌ Validation failed for " + months[i] + " → " + e.getMessage());
				softAssert.fail("Validation failed for " + months[i]);
			}
		}

		softAssert.assertAll();
		LoggerUtil.pass("✅ All RM & Scrap values verified successfully for April → March.");
		LoggerUtil.info("===== End of enterRmandScrapvalueForcalculatingRmAndScrapvalue =====");
	}

	public static void verifyQuarterlyRmAverageQ1() {
		LoggerUtil.info("🧾 Starting Q1 RM average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch RM Values (Apr → Jun) Dynamically ----
		String aprilVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value").trim();
		String mayVal = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value").trim();
		String juneVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value").trim();

		// ---- Q1 (Quarterly) RM Value ----
		String q1UiVal = waitForExpectedElement(getDynamicPeriodLocator("q1", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q1 RM Breakdown → Apr: " + aprilVal + ", May: " + mayVal + ", Jun: " + juneVal
				+ " | Q1 RM Total: " + q1UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!aprilVal.isEmpty() && aprilVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(aprilVal));
			count++;
			LoggerUtil.info("April RM: " + aprilVal);
		} else {
			LoggerUtil.info("April RM: Not Entered");
		}

		if (!mayVal.isEmpty() && mayVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(mayVal));
			count++;
			LoggerUtil.info("May RM: " + mayVal);
		} else {
			LoggerUtil.info("May RM: Not Entered");
		}

		if (!juneVal.isEmpty() && juneVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(juneVal));
			count++;
			LoggerUtil.info("June RM: " + juneVal);
		} else {
			LoggerUtil.info("June RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q1 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ1Value;
		try {
			uiQ1Value = new BigDecimal(q1UiVal);
		} catch (NumberFormatException e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q1 RM UI value is not numeric: " + q1UiVal);
			return;
		}

		if (q1UiVal.contains(".")) {
			String decimalPart = q1UiVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ Q1 RM UI value has more than 3 decimal places: " + q1UiVal);
				return;
			}
		}

		uiQ1Value = uiQ1Value.setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Expected Q1 RM (calculated): " + calculatedAvg);
		LoggerUtil.info("Actual Q1 RM (UI): " + uiQ1Value);

		if (!calculatedAvg.equals(uiQ1Value)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q1 RM mismatch: Expected " + calculatedAvg + ", but found " + uiQ1Value);
		} else {
			LoggerUtil.pass("✅ Q1 RM average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static final By Q2rm = By.xpath("//input[@id='q2']");

	public static void verifyQuarterlyRmAverageQ2() {
		LoggerUtil.info("🧾 Starting Q2 RM average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch RM Values (Jul → Sep) Dynamically ----
		String julyVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value").trim();
		String augustVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")).getAttribute("value").trim();
		String septemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")).getAttribute("value")
				.trim();

		// ---- Q2 (Quarterly) RM Value ----
		String q2UiVal = waitForExpectedElement(getDynamicPeriodLocator("q2", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q2 RM Breakdown → Jul: " + julyVal + ", Aug: " + augustVal + ", Sep: " + septemberVal
				+ " | Q2 RM Total: " + q2UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!julyVal.isEmpty() && julyVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(julyVal));
			count++;
			LoggerUtil.info("July RM: " + julyVal);
		} else {
			LoggerUtil.info("July RM: Not Entered");
		}

		if (!augustVal.isEmpty() && augustVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(augustVal));
			count++;
			LoggerUtil.info("August RM: " + augustVal);
		} else {
			LoggerUtil.info("August RM: Not Entered");
		}

		if (!septemberVal.isEmpty() && septemberVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(septemberVal));
			count++;
			LoggerUtil.info("September RM: " + septemberVal);
		} else {
			LoggerUtil.info("September RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q2 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ2Value;
		try {
			uiQ2Value = new BigDecimal(q2UiVal);
		} catch (NumberFormatException e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q2 RM UI value is not numeric: " + q2UiVal);
			return;
		}

		if (q2UiVal.contains(".")) {
			String decimalPart = q2UiVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ Q2 RM UI value has more than 3 decimal places: " + q2UiVal);
				return;
			}
		}

		uiQ2Value = uiQ2Value.setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q2 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q2 RM (UI): " + uiQ2Value);

		if (!uiQ2Value.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q2 RM mismatch: Expected " + calculatedAvg + ", but found " + uiQ2Value);
		} else {
			LoggerUtil.pass("✅ Q2 RM average calculation passed.");
		}

		softAssert.assertAll();
	}

//Locator for Q3

	public static void verifyQuarterlyRmAverageQ3() {
		LoggerUtil.info("🧾 Starting Q3 RM average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch RM Values (Oct → Dec) Dynamically ----
		String octoberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")).getAttribute("value")
				.trim();
		String novemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")).getAttribute("value")
				.trim();
		String decemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")).getAttribute("value")
				.trim();

		// ---- Q3 (Quarterly) RM Value ----
		String q3UiVal = waitForExpectedElement(getDynamicPeriodLocator("q3", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q3 RM Breakdown → Oct: " + octoberVal + ", Nov: " + novemberVal + ", Dec: " + decemberVal
				+ " | Q3 RM Total: " + q3UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberVal.isEmpty() && octoberVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(octoberVal));
			count++;
			LoggerUtil.info("October RM: " + octoberVal);
		} else {
			LoggerUtil.info("October RM: Not Entered");
		}

		if (!novemberVal.isEmpty() && novemberVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(novemberVal));
			count++;
			LoggerUtil.info("November RM: " + novemberVal);
		} else {
			LoggerUtil.info("November RM: Not Entered");
		}

		if (!decemberVal.isEmpty() && decemberVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(decemberVal));
			count++;
			LoggerUtil.info("December RM: " + decemberVal);
		} else {
			LoggerUtil.info("December RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q3 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ3Value;
		try {
			uiQ3Value = new BigDecimal(q3UiVal);
		} catch (NumberFormatException e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q3 RM UI value is not numeric: " + q3UiVal);
			return;
		}

		if (q3UiVal.contains(".")) {
			String decimalPart = q3UiVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ Q3 RM UI value has more than 3 decimal places: " + q3UiVal);
				return;
			}
		}

		uiQ3Value = uiQ3Value.setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q3 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q3 RM (UI): " + uiQ3Value);

		if (!uiQ3Value.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q3 RM mismatch: Expected " + calculatedAvg + ", but found " + uiQ3Value);
		} else {
			LoggerUtil.pass("✅ Q3 RM average calculation passed.");
		}

		softAssert.assertAll();
	}

//Locator for Q4
	public static void verifyQuarterlyRmAverageQ4() {
		LoggerUtil.info("🧾 Starting Q4 RM average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch RM Values (Jan → Mar) Dynamically ----
		String janVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")).getAttribute("value").trim();
		String febVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")).getAttribute("value").trim();
		String marVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value").trim();

		// ---- Q4 (Quarterly) RM Value ----
		String q4UiVal = waitForExpectedElement(getDynamicPeriodLocator("q4", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q4 RM Breakdown → Jan: " + janVal + ", Feb: " + febVal + ", Mar: " + marVal
				+ " | Q4 RM Total: " + q4UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!janVal.isEmpty() && janVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(janVal));
			count++;
			LoggerUtil.info("January RM: " + janVal);
		} else {
			LoggerUtil.info("January RM: Not Entered");
		}

		if (!febVal.isEmpty() && febVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(febVal));
			count++;
			LoggerUtil.info("February RM: " + febVal);
		} else {
			LoggerUtil.info("February RM: Not Entered");
		}

		if (!marVal.isEmpty() && marVal.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(marVal));
			count++;
			LoggerUtil.info("March RM: " + marVal);
		} else {
			LoggerUtil.info("March RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q4 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ4Value;
		try {
			uiQ4Value = new BigDecimal(q4UiVal);
		} catch (NumberFormatException e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q4 RM UI value is not numeric: " + q4UiVal);
			return;
		}

		if (q4UiVal.contains(".")) {
			String decimalPart = q4UiVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ Q4 RM UI value has more than 3 decimal places: " + q4UiVal);
				return;
			}
		}

		uiQ4Value = uiQ4Value.setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q4 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q4 RM (UI): " + uiQ4Value);

		if (!uiQ4Value.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q4 RM mismatch: Expected " + calculatedAvg + ", but found " + uiQ4Value);
		} else {
			LoggerUtil.pass("✅ Q4 RM average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyQuarterlyScrapAverageQ1() {
		LoggerUtil.info("🧾 Starting Q1 Scrap average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch Scrap Values (Apr → Jun) Dynamically ----
		String april = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")).getAttribute("value").trim();
		String may = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")).getAttribute("value").trim();
		String june = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")).getAttribute("value").trim();

		// ---- Q1 (Quarterly) Scrap Value ----
		String q1UiVal = waitForExpectedElement(getDynamicPeriodLocator("q1", "Scrap")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q1 Scrap Breakdown → Apr: " + april + ", May: " + may + ", Jun: " + june
				+ " | Q1 Scrap Total: " + q1UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!april.isEmpty() && april.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(april));
			count++;
			LoggerUtil.info("April Scrap: " + april);
		} else {
			LoggerUtil.info("April Scrap: Not Entered");
		}

		if (!may.isEmpty() && may.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(may));
			count++;
			LoggerUtil.info("May Scrap: " + may);
		} else {
			LoggerUtil.info("May Scrap: Not Entered");
		}

		if (!june.isEmpty() && june.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(june));
			count++;
			LoggerUtil.info("June Scrap: " + june);
		} else {
			LoggerUtil.info("June Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for Q1.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ1;
		try {
			uiQ1 = new BigDecimal(q1UiVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q1 Scrap UI value is not numeric.");
			return;
		}

		if (q1UiVal.contains(".") && q1UiVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch: ❌ Q1 Scrap UI has more than 3 decimal places: " + q1UiVal);
			return;
		}

		uiQ1 = uiQ1.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated Q1 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q1 Scrap (UI): " + uiQ1);

		if (!uiQ1.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q1 Scrap mismatch: Expected " + calculatedAvg + ", but found " + uiQ1);
		} else {
			LoggerUtil.pass(" Q1 Scrap average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyQuarterlyScrapAverageQ2() {
		LoggerUtil.info("🧾 Starting Q2 Scrap average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch Scrap Values (Jul → Sep) Dynamically ----
		String july = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")).getAttribute("value").trim();
		String august = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")).getAttribute("value").trim();
		String september = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")).getAttribute("value")
				.trim();

		// ---- Q2 (Quarterly) Scrap Value ----
		String q2UiVal = waitForExpectedElement(getDynamicPeriodLocator("q2", "Scrap")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q2 Scrap Breakdown → Jul: " + july + ", Aug: " + august + ", Sep: " + september
				+ " | Q2 Scrap Total: " + q2UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!july.isEmpty() && july.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(july));
			count++;
			LoggerUtil.info("July Scrap: " + july);
		} else {
			LoggerUtil.info("July Scrap: Not Entered");
		}

		if (!august.isEmpty() && august.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(august));
			count++;
			LoggerUtil.info("August Scrap: " + august);
		} else {
			LoggerUtil.info("August Scrap: Not Entered");
		}

		if (!september.isEmpty() && september.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(september));
			count++;
			LoggerUtil.info("September Scrap: " + september);
		} else {
			LoggerUtil.info("September Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for Q2.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ2;
		try {
			uiQ2 = new BigDecimal(q2UiVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch:  Q2 Scrap UI value is not numeric.");
			return;
		}

		if (q2UiVal.contains(".") && q2UiVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch:  Q2 Scrap UI has more than 3 decimal places: " + q2UiVal);
			return;
		}

		uiQ2 = uiQ2.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated Q2 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q2 Scrap (UI): " + uiQ2);

		if (!uiQ2.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch:  Q2 Scrap mismatch: Expected " + calculatedAvg + ", but found " + uiQ2);
		} else {
			LoggerUtil.pass(" Q2 Scrap average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyQuarterlyScrapAverageQ3() {
		LoggerUtil.info(" Starting Q3 Scrap average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch Scrap Values (Oct → Dec) Dynamically ----
		String october = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")).getAttribute("value")
				.trim();
		String november = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")).getAttribute("value")
				.trim();
		String december = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")).getAttribute("value")
				.trim();

		// ---- Q3 (Quarterly) Scrap Value ----
		String q3UiVal = waitForExpectedElement(getDynamicPeriodLocator("q3", "Scrap")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q3 Scrap Breakdown → Oct: " + october + ", Nov: " + november + ", Dec: " + december
				+ " | Q3 Scrap Total: " + q3UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!october.isEmpty() && october.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(october));
			count++;
			LoggerUtil.info("October Scrap: " + october);
		} else {
			LoggerUtil.info("October Scrap: Not Entered");
		}

		if (!november.isEmpty() && november.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(november));
			count++;
			LoggerUtil.info("November Scrap: " + november);
		} else {
			LoggerUtil.info("November Scrap: Not Entered");
		}

		if (!december.isEmpty() && december.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(december));
			count++;
			LoggerUtil.info("December Scrap: " + december);
		} else {
			LoggerUtil.info("December Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for Q3.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ3;
		try {
			uiQ3 = new BigDecimal(q3UiVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q3 Scrap UI value is not numeric.");
			return;
		}

		if (q3UiVal.contains(".") && q3UiVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch:  Q3 Scrap UI has more than 3 decimal places: " + q3UiVal);
			return;
		}

		uiQ3 = uiQ3.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated Q3 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q3 Scrap (UI): " + uiQ3);

		if (!uiQ3.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q3 Scrap mismatch: Expected " + calculatedAvg + ", but found " + uiQ3);
		} else {
			LoggerUtil.pass("✅ Q3 Scrap average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyQuarterlyScrapAverageQ4() {
		LoggerUtil.info("🧾 Starting Q4 Scrap average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch Scrap Values (Jan → Mar) Dynamically ----
		String jan = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")).getAttribute("value").trim();
		String feb = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")).getAttribute("value").trim();
		String mar = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")).getAttribute("value").trim();

		// ---- Q4 (Quarterly) Scrap Value (Dynamic via getDynamicPeriodLocator) ----
		String q4UiVal = waitForExpectedElement(getDynamicPeriodLocator("q4", "Scrap")).getAttribute("value").trim();

		LoggerUtil.info("✅ Q4 Scrap Breakdown → Jan: " + jan + ", Feb: " + feb + ", Mar: " + mar + " | Q4 Scrap Total: "
				+ q4UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!jan.isEmpty() && jan.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(jan));
			count++;
			LoggerUtil.info("January Scrap: " + jan);
		} else {
			LoggerUtil.info("January Scrap: Not Entered");
		}

		if (!feb.isEmpty() && feb.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(feb));
			count++;
			LoggerUtil.info("February Scrap: " + feb);
		} else {
			LoggerUtil.info("February Scrap: Not Entered");
		}

		if (!mar.isEmpty() && mar.matches("\\d+(\\.\\d+)?")) {
			sum = sum.add(new BigDecimal(mar));
			count++;
			LoggerUtil.info("March Scrap: " + mar);
		} else {
			LoggerUtil.info("March Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch:  No Scrap values entered for Q4.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiQ4;
		try {
			uiQ4 = new BigDecimal(q4UiVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch: ❌ Q4 Scrap UI value is not numeric.");
			return;
		}

		if (q4UiVal.contains(".") && q4UiVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch:  Q4 Scrap UI has more than 3 decimal places: " + q4UiVal);
			return;
		}

		uiQ4 = uiQ4.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated Q4 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q4 Scrap (UI): " + uiQ4);

		if (!uiQ4.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ Q4 Scrap mismatch: Expected " + calculatedAvg + ", but found " + uiQ4);
		} else {
			LoggerUtil.pass(" Q4 Scrap average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyHalfYearlyRmAverageH1() {
		LoggerUtil.info("🧾 Starting H1 RM average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch RM Values (April → September) Dynamically ----
		String april = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value").trim();
		String may = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value").trim();
		String june = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value").trim();
		String july = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value").trim();
		String august = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")).getAttribute("value").trim();
		String september = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")).getAttribute("value").trim();

		// ---- H1 (Half-Yearly) RM Value (Dynamic via getDynamicPeriodLocator) ----
		String h1UiVal = waitForExpectedElement(getDynamicPeriodLocator("h1", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ H1 RM Breakdown → Apr: " + april + ", May: " + may + ", Jun: " + june + ", Jul: " + july
				+ ", Aug: " + august + ", Sep: " + september + " | H1 RM Total: " + h1UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		String[] h1Months = { "April", "May", "June", "July", "August", "September" };
		String[] h1Values = { april, may, june, july, august, september };

		for (int i = 0; i < h1Values.length; i++) {
			String val = h1Values[i];
			if (!val.isEmpty() && val.matches("\\d+(\\.\\d+)?")) {
				sum = sum.add(new BigDecimal(val));
				count++;
				LoggerUtil.info("H1 RM [" + h1Months[i] + "] Value: " + val);
			}
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch:  No RM values entered for H1 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiH1;
		try {
			uiH1 = new BigDecimal(h1UiVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch:  H1 RM UI value is not numeric.");
			return;
		}

		if (h1UiVal.contains(".") && h1UiVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch:  H1 RM UI value has more than 3 decimal places: " + h1UiVal);
			return;
		}

		uiH1 = uiH1.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated H1 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected H1 RM (UI): " + uiH1);

		if (!uiH1.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch:  H1 RM mismatch: Expected " + calculatedAvg + ", but found " + uiH1);
		} else {
			LoggerUtil.pass(" H1 RM average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyHalfYearlyScrapAverageH1() {
		LoggerUtil.info("🧾 Starting H1 Scrap average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch Scrap Values (April → September) Dynamically ----
		String april = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")).getAttribute("value").trim();
		String may = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")).getAttribute("value").trim();
		String june = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")).getAttribute("value").trim();
		String july = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")).getAttribute("value").trim();
		String august = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")).getAttribute("value").trim();
		String september = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")).getAttribute("value")
				.trim();

		// ---- H1 (Half-Yearly) Scrap Value (Dynamic via getDynamicPeriodLocator) ----
		String h1ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("h1", "Scrap")).getAttribute("value").trim();

		LoggerUtil.info("✅ H1 Scrap Breakdown → Apr: " + april + ", May: " + may + ", Jun: " + june + ", Jul: " + july
				+ ", Aug: " + august + ", Sep: " + september + " | H1 Scrap Total: " + h1ScrapVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		String[] h1ScrapMonths = { "April", "May", "June", "July", "August", "September" };
		String[] h1ScrapValues = { april, may, june, july, august, september };

		for (int i = 0; i < h1ScrapValues.length; i++) {
			String val = h1ScrapValues[i];
			if (!val.isEmpty() && val.matches("\\d+(\\.\\d+)?")) {
				sum = sum.add(new BigDecimal(val));
				count++;
				LoggerUtil.info("H1 Scrap [" + h1ScrapMonths[i] + "] Value: " + val);
			}
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for H1 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiScrap;
		try {
			uiScrap = new BigDecimal(h1ScrapVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch: ❌ H1 Scrap UI value is not numeric.");
			return;
		}

		if (h1ScrapVal.contains(".") && h1ScrapVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch:  H1 Scrap UI value has more than 3 decimal places: " + h1ScrapVal);
			return;
		}

		uiScrap = uiScrap.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated H1 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected H1 Scrap (UI): " + uiScrap);

		if (!uiScrap.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch:  H1 Scrap mismatch: Expected " + calculatedAvg + ", but found " + uiScrap);
		} else {
			LoggerUtil.pass(" H1 Scrap average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void verifyHalfYearlyRmAverageH2() {
		LoggerUtil.info("🧾 Starting H2 RM average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		// ---- Fetch RM Values (October → March) Dynamically ----
		String october = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")).getAttribute("value").trim();
		String november = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")).getAttribute("value").trim();
		String december = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")).getAttribute("value").trim();
		String january = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")).getAttribute("value").trim();
		String february = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")).getAttribute("value").trim();
		String march = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value").trim();

		// ---- H2 (Half-Yearly) RM Value (Dynamic via getDynamicPeriodLocator) ----
		String h2UiVal = waitForExpectedElement(getDynamicPeriodLocator("h2", "RM")).getAttribute("value").trim();

		LoggerUtil.info("✅ H2 RM Breakdown → Oct: " + october + ", Nov: " + november + ", Dec: " + december + ", Jan: "
				+ january + ", Feb: " + february + ", Mar: " + march + " | H2 RM Total: " + h2UiVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		String[] h2Months = { "October", "November", "December", "January", "February", "March" };
		String[] h2Values = { october, november, december, january, february, march };

		for (int i = 0; i < h2Values.length; i++) {
			String val = h2Values[i];
			if (!val.isEmpty() && val.matches("\\d+(\\.\\d+)?")) {
				sum = sum.add(new BigDecimal(val));
				count++;
				LoggerUtil.info("H2 RM [" + h2Months[i] + "] Value: " + val);
			}
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch:  No RM values entered for H2 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiH2;
		try {
			uiH2 = new BigDecimal(h2UiVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch:  H2 RM UI value is not numeric.");
			return;
		}

		if (h2UiVal.contains(".") && h2UiVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch: ❌ H2 RM UI value has more than 3 decimal places: " + h2UiVal);
			return;
		}

		uiH2 = uiH2.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated H2 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected H2 RM (UI): " + uiH2);

		if (!uiH2.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch:  H2 RM mismatch: Expected " + calculatedAvg + ", but found " + uiH2);
		} else {
			LoggerUtil.pass(" H2 RM average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static final By secondHyScrap = By.xpath("//input[@id='h2Scrap']");

	public static void verifyHalfYearlyScrapAverageH2() {
		LoggerUtil.info("🧾 Starting H2 Scrap average validation based on valid entries...");

		SoftAssert softAssert = new SoftAssert();

		try {
			LoggerUtil.info("STEP 7: Scroll window by 130px.");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 290);");
			Thread.sleep(2000);
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Scroll failed → " + e.getMessage());
		}

		// ---- Fetch Scrap Values (October → March) Dynamically ----
		String october = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")).getAttribute("value")
				.trim();
		String november = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")).getAttribute("value")
				.trim();
		String december = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")).getAttribute("value")
				.trim();
		String january = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")).getAttribute("value")
				.trim();
		String february = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")).getAttribute("value")
				.trim();
		String march = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")).getAttribute("value").trim();

		// ---- H2 (Half-Yearly) Scrap Value ----
		String h2ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("H2", "Scrap")).getAttribute("value").trim();

		LoggerUtil.info("✅ H2 Scrap Breakdown → Oct: " + october + ", Nov: " + november + ", Dec: " + december
				+ ", Jan: " + january + ", Feb: " + february + ", Mar: " + march + " | H2 Scrap Total: " + h2ScrapVal);

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		String[] h2ScrapMonths = { "October", "November", "December", "January", "February", "March" };
		String[] h2ScrapValues = { october, november, december, january, february, march };

		for (int i = 0; i < h2ScrapValues.length; i++) {
			String val = h2ScrapValues[i];
			if (!val.isEmpty() && val.matches("\\d+(\\.\\d+)?")) {
				sum = sum.add(new BigDecimal(val));
				count++;
				LoggerUtil.info("H2 Scrap [" + h2ScrapMonths[i] + "] Value: " + val);
			}
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for H2 months.");
			return;
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal uiScrap;
		try {
			uiScrap = new BigDecimal(h2ScrapVal);
		} catch (Exception e) {
			LoggerUtil.mismatch("Mismatch: ❌ H2 Scrap UI value is not numeric.");
			return;
		}

		if (h2ScrapVal.contains(".") && h2ScrapVal.split("\\.")[1].length() > 3) {
			LoggerUtil.mismatch("Mismatch:  H2 Scrap UI value has more than 3 decimal places: " + h2ScrapVal);
			return;
		}

		uiScrap = uiScrap.setScale(3, RoundingMode.HALF_UP);
		LoggerUtil.info("Calculated H2 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected H2 Scrap (UI): " + uiScrap);

		if (!uiScrap.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch:  H2 Scrap mismatch: Expected " + calculatedAvg + ", but found " + uiScrap);
		} else {
			LoggerUtil.pass(" H2 Scrap average calculation passed.");
		}

		softAssert.assertAll();
	}

	public static void saveaddcommoditydata(String addcom) throws InterruptedException {
		try {
			// Step 1: Enter Add Commodity Name
			LoggerUtil.info("Step 1: Entering Add Commodity Name: " + addcom);
			try {
				clearAndEnterText(waitForExpectedElement(addcommodity), addcom);
				LoggerUtil.pass("Entered Add Commodity Name: " + addcom);
			} catch (Exception e) {
				LoggerUtil.error("Step 1 failed (enter commodity): " + e.getMessage());
				return;
			}

			// Step 2: Click Save button
			LoggerUtil.info("Step 2: Clicking Save button for Commodity Group: " + addcom);
			try {
				clickOnElement(addcomSavebtn);
				LoggerUtil.pass("Save button clicked for Commodity Group: " + addcom);
			} catch (Exception e) {
				LoggerUtil.error("Step 2 failed (click save): " + e.getMessage());
				return;
			}

			// Step 3: Wait for toast message and validate
			LoggerUtil.info("Step 3: Waiting for toast message...");
			try {
				Thread.sleep(3000);
				String actualToastmessage = waitForExpectedElement(ToastmessageForExportImportFile).getText();
				String expectedToastmessage = "Commodity Group successfully saved.";

				if (actualToastmessage.equals(expectedToastmessage)) {
					LoggerUtil.pass("Toast message matched ✅ | Expected: '" + expectedToastmessage + "' | Actual: '"
							+ actualToastmessage + "'");
				} else {
					LoggerUtil.fail("❌ Toast mismatch! Expected: '" + expectedToastmessage + "' | Actual: '"
							+ actualToastmessage + "'");
				}
			} catch (Exception e) {
				LoggerUtil.error("Step 3 failed (toast validation): " + e.getMessage());
			}

		} catch (Exception e) {
			LoggerUtil.error("Unexpected exception in saveaddcommoditydata: " + e.getMessage());
		}
	}

	public static void savedatainsecondtab(String searchcommodityvalue, String grpclassificationvalue,
			String specificgradevalye, String densityvalue) throws InterruptedException {

		Thread.sleep(4000);
		LoggerUtil.info("Opening Commodity Group dropdown.");
		clickOnElement(commoditygroupdropdown);
		Thread.sleep(7000);

		LoggerUtil.info("Searching for Commodity Group: " + searchcommodityvalue);
		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);
		for (WebElement grpvalue : grouplist) {
			String text = grpvalue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				LoggerUtil.info("Selected Commodity Group: " + text);
				grpvalue.click();
				break;
			}
		}

		LoggerUtil.info("Entering Group Classification: " + grpclassificationvalue);
		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		Thread.sleep(2000);

		LoggerUtil.info("Entering Specific Grade: " + specificgradevalye);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		Thread.sleep(2000);

		LoggerUtil.info("Entering Density: " + densityvalue);
		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		Thread.sleep(1000);

		LoggerUtil.info("Clicking Save button for Commodity Group tab.");
		clickOnElement(savebtncommoditygrp);
		Thread.sleep(7000);

		LoggerUtil.pass("✅ Data saved in second tab successfully with Commodity Group: " + searchcommodityvalue);
	}

	public static final By ToastMessageForSaveThirdTab = By.xpath("//*[@id='toast-container']/div/div[2]");

	public static void savedatainthirdtab(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue) throws InterruptedException {

// Step 1: Wai
		try {

			Thread.sleep(3000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed: " + e.getMessage());
		}

// Step 2: Open Commodity dropdown
		try {
			LoggerUtil.info("Step 2: Clicking Commodity dropdown button (Third Tab)...");
			clickOnElement(ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(3000);
			LoggerUtil.pass("Commodity dropdown opened.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed: " + e.getMessage());
		}

// Step 3: Select Commodity value
		try {
			LoggerUtil.info("Step 3: Typing & selecting Commodity value: " + searchcommoditydropvalue);
			clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

			List<WebElement> comlist = driver.findElements(commoditydropdownlist);
			boolean found = false;
			for (WebElement comgrpvalue : comlist) {
				if (comgrpvalue.getText().trim().equalsIgnoreCase(searchcommoditydropvalue)) {
					comgrpvalue.click();
					LoggerUtil.pass("Commodity selected: " + searchcommoditydropvalue);
					found = true;
					break;
				}
			}
			if (!found) {
				LoggerUtil.fail("Commodity not found: " + searchcommoditydropvalue);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed: " + e.getMessage());
		}

// Step 4: Select Group Classification
		Thread.sleep(4000);
		try {
			LoggerUtil.info("Step 4: Selecting Group Classification: " + searchcommodityclassification);
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);
      clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommodityclassification);
			
			boolean gcFound = false;
			for (WebElement grpclasslistval : driver.findElements(groupclassificationlist)) {
				if (grpclasslistval.getText().trim().equalsIgnoreCase(searchcommodityclassification)) {
					grpclasslistval.click();
					LoggerUtil.pass("Group Classification selected: " + searchcommodityclassification);
					gcFound = true;
					break;
				}
			}
			if (!gcFound) {
				LoggerUtil.fail("Group Classification not found: " + searchcommodityclassification);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed: " + e.getMessage());
		}
		Thread.sleep(7000);
// Step 5: Select Specific Grade
		try {
			LoggerUtil.info("Step 5: Selecting Specific Grade: " + selectcommoditygradevalue);
			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);

			Thread.sleep(2000);
			boolean gradeFound = false;
			for (WebElement comgradelistval : driver.findElements(specificgradelist)) {
				if (comgradelistval.getText().trim().equalsIgnoreCase(selectcommoditygradevalue)) {
					comgradelistval.click();
					LoggerUtil.pass("Specific Grade selected: " + selectcommoditygradevalue);
					gradeFound = true;
					break;
				}
			}
			if (!gradeFound) {
				LoggerUtil.fail("Specific Grade not found: " + selectcommoditygradevalue);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed: " + e.getMessage());
		}

// Step 6: Select UOM
		try {
			LoggerUtil.info("Step 6: Selecting UOM = 'Mtr'");
			clickOnElement(Uomdropdown);
			Thread.sleep(3000);
			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			searchuom.sendKeys(Keys.ENTER);
			LoggerUtil.pass("UOM set to Mtr");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed: " + e.getMessage());
		}

// Step 7: Select Shape
		try {
			LoggerUtil.info("Step 7: Selecting Shape = 'Sheet'");
			clickOnElement(ClickingShapedropdownForthirdTab);
			Thread.sleep(300);
			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			clearAndEnterText(shapesearch, "Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Shape set to Sheet");
		} catch (Exception e) {
			LoggerUtil.error("Step 7 failed: " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 8: Scrolling window by 160px before Year selection...");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 160);");
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Step 8 failed (scroll): " + e.getMessage());
		}

		Thread.sleep(4000);
// Step 8: Select Year
		try {
			LoggerUtil.info("Step 8: Selecting Year = '2025-2026'");
			clickOnElement(selectyeardrop);
			Thread.sleep(500);
			WebElement yearsearch = waitForExpectedElement(searchinputyear);
			clearAndEnterText(yearsearch, "2025-2026");
			yearsearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Year set to 2025-2026");
		} catch (Exception e) {
			LoggerUtil.error("Step 8 failed: " + e.getMessage());
		}

// Step 9: Select Business Segment
		try {
			LoggerUtil.info("Step 9: Selecting Business Segment = 'rishi'");
			clickOnElement(businessSegbox);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			Thread.sleep(5000);
			clickOnElement(selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Business Segment 'rishi' selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 9 failed: " + e.getMessage());
		}

// Step 10: Select Customer checkbox
		try {
			LoggerUtil.info("Step 10: Selecting Customer checkbox");
			clickOnElement(customercheckbox);
			LoggerUtil.pass("Customer checkbox selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 10 failed: " + e.getMessage());
		}

// Step 11: Save and validate toast
		try {
			LoggerUtil.info("Step 11: Clicking Save and validating toast");
			clickOnElement(ClickingSaveBtnForThirdTab);

			String actualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
			String expectedMessage = "Commodity details saved successfully.";
			System.out.println("Toast Message: " + actualMessage);
			LoggerUtil.info("Toast Message Displayed: " + actualMessage);

			if (expectedMessage.equals(actualMessage)) {
				LoggerUtil.pass("Toast matched ✅ Expected: " + expectedMessage + " | Actual: " + actualMessage);
			} else {
				LoggerUtil.fail("❌ Toast mismatch! Expected: " + expectedMessage + " | Actual: " + actualMessage);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 11 failed: " + e.getMessage());
		}
	}

	public static void WithoutSelectingComGroup() throws InterruptedException {

// Step 6: Select UOM
		try {
			LoggerUtil.info("Step 6: Selecting UOM = 'Mtr'");
			clickOnElement(Uomdropdown);
			Thread.sleep(3000);
			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			searchuom.sendKeys(Keys.ENTER);
			LoggerUtil.pass("UOM set to Mtr");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed: " + e.getMessage());
		}

// Step 7: Select Shape
		try {
			LoggerUtil.info("Step 7: Selecting Shape = 'Sheet'");
			clickOnElement(ClickingShapedropdownForthirdTab);
			Thread.sleep(300);
			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			clearAndEnterText(shapesearch, "Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Shape set to Sheet");
		} catch (Exception e) {
			LoggerUtil.error("Step 7 failed: " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 8: Scrolling window by 160px before Year selection...");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 160);");
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Step 8 failed (scroll): " + e.getMessage());
		}

		Thread.sleep(4000);
// Step 8: Select Year
		try {
			LoggerUtil.info("Step 8: Selecting Year = '2025-2026'");
			clickOnElement(selectyeardrop);
			Thread.sleep(500);
			WebElement yearsearch = waitForExpectedElement(searchinputyear);
			clearAndEnterText(yearsearch, "2025-2026");
			yearsearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Year set to 2025-2026");
		} catch (Exception e) {
			LoggerUtil.error("Step 8 failed: " + e.getMessage());
		}

// Step 9: Select Business Segment
		try {
			LoggerUtil.info("Step 9: Selecting Business Segment = 'rishi'");
			clickOnElement(businessSegbox);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			Thread.sleep(5000);
			clickOnElement(selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Business Segment 'rishi' selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 9 failed: " + e.getMessage());
		}

// Step 10: Select Customer checkbox
		try {
			LoggerUtil.info("Step 10: Selecting Customer checkbox");
			clickOnElement(customercheckbox);
			LoggerUtil.pass("Customer checkbox selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 10 failed: " + e.getMessage());
		}

// Step 11: Save and validate toast
		try {
			LoggerUtil.info("Step 11: Clicking Save and validating toast");
			clickOnElement(ClickingSaveBtnForThirdTab);

			String actualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
			String expectedMessage = "Select Commodity Group";
			System.out.println("Toast Message: " + actualMessage);
			LoggerUtil.info("Toast Message Displayed: " + actualMessage);

			if (expectedMessage.equals(actualMessage)) {
				LoggerUtil.pass("Toast matched ✅ Expected: " + expectedMessage + " | Actual: " + actualMessage);
			} else {
				LoggerUtil.fail("❌ Toast mismatch! Expected: " + expectedMessage + " | Actual: " + actualMessage);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 11 failed: " + e.getMessage());
		}
	}

	public static final By searchinputcommoditygrp = By
			.xpath("//div[@id='SubGroupTable_filter']/label/input[@type='search']");
	public static final By clickeditbtnforsecondtab = By.xpath("//table[@id='SubGroupTable']/tbody/tr/td[6]/a/i");
	public static final By specificgradeforsaveasnewsecondtab = By.xpath("//input[@id='SpecificGradeText']");
	public static final By saveasnewbtnforsecondtab = By.xpath("//button[@id='tab2SaveAsNew']");

	public void gobacksecodndtabforsaveAsnewspecificgrade(String searchsecondtab, String entervalueforsaveasnew)
			throws InterruptedException {

		LoggerUtil.info("Navigating back to the second tab to perform Save As New for Specific Grade.");
		driver.navigate().refresh();
		Thread.sleep(5000);
		LoggerUtil.info("Searching for Specific Grade in the second tab using value: " + searchsecondtab);
		clearAndEnterText(waitForExpectedElement(searchinputcommoditygrp), searchsecondtab);
		Thread.sleep(3000);

		LoggerUtil.info("Clicking on Edit button for the searched grade.");
		clickOnElement(clickeditbtnforsecondtab);
		Thread.sleep(3000);

		LoggerUtil.info("Clearing and entering new value for Save As New: " + entervalueforsaveasnew);
		clearAndEnterText(waitForExpectedElement(specificgradeforsaveasnewsecondtab), entervalueforsaveasnew);
		Thread.sleep(3000);

		LoggerUtil.info("Clicking on Save As New button for second tab.");
		clickOnElement(saveasnewbtnforsecondtab);

		LoggerUtil.pass(
				"✅ Save As New operation will be Sucessfully complete for Specific Grade: " + entervalueforsaveasnew);
	}

	public static final By fetchinggradedatacomdetails = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[5]");
	public static final By crossbtncomdetail = By
			.xpath("//*[@id='CommodityDetailTab']/div[2]/div/div/div[1]/div[2]/button[3]");
	public static final By specificgradelistdropincomdetails = By.xpath("//ul[@id='select2-SpecificGrade-results']/li");
	public static final By saveasnewincomdetails = By.xpath("//*[@id='tab3SaveNew']");

	public void saveasnewincommoditydeatilstab(String searchvalueforgrade,
			String selectsaveasnewspecificgradewhichisselectinscondtab,
			String searchvalueincomdetailsourdatahasbeenchangeornot) throws InterruptedException {

		LoggerUtil.info("User clicked on View button to fetch the list.");
		clickOnElement(ClickingViewbtn);
		Thread.sleep(7000);

		LoggerUtil.info("User is searching for specific grade in the Commodity Details list: " + searchvalueforgrade);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchvalueforgrade);
		Thread.sleep(8000);

		String actualgradevalue = waitForExpectedElement(fetchinggradedatacomdetails).getText();
		LoggerUtil.info("Fetched Grade from UI: " + actualgradevalue);
		LoggerUtil.info("Expected Grade to match: " + searchvalueforgrade);
		Assert.assertEquals(actualgradevalue, searchvalueforgrade, "Value does not exist in UI");

		LoggerUtil.pass("✅ Grade found in UI matches the expected: " + actualgradevalue);

		LoggerUtil.info("Clicking on Edit button to proceed for Save As New operation.");
		clickOnElement(ClickingEditbtnCommodityDetailsTable);

		Thread.sleep(17000);

		LoggerUtil.info("Opening Specific Grade dropdown.");
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		Thread.sleep(3000);

		LoggerUtil.info(
				"Entering new specific grade value in search: " + selectsaveasnewspecificgradewhichisselectinscondtab);
		clearAndEnterText(waitForExpectedElement(SearchInputspecificgradeForThirdTab),
				selectsaveasnewspecificgradewhichisselectinscondtab);

		List<WebElement> specificgradelsitvalue = driver.findElements(specificgradelistdropincomdetails);
		for (WebElement gradelist : specificgradelsitvalue) {
			String flaggradelist = gradelist.getText().trim();
			if (flaggradelist.equalsIgnoreCase(selectsaveasnewspecificgradewhichisselectinscondtab)) {
				LoggerUtil.info("Matching grade found in dropdown: " + flaggradelist + " - Selecting it.");
				gradelist.click();
				break;
			}
		}

		LoggerUtil.info("Clicking on Save As New in Commodity Details.");
		clickOnElement(saveasnewincomdetails);
		Thread.sleep(3000);

		LoggerUtil.info("Clicking on View again to validate saved data.");
		clickOnElement(ClickingViewbtn);
		Thread.sleep(4000);

		LoggerUtil.info("Searching with new grade value: " + searchvalueincomdetailsourdatahasbeenchangeornot);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab),
				searchvalueincomdetailsourdatahasbeenchangeornot);
		Thread.sleep(9000);

		String actualvalue = waitForExpectedElement(fetchinggradedatacomdetails).getText();
		LoggerUtil.info("Fetched grade from UI after save as new: " + actualvalue);
		LoggerUtil.info("Expected saved grade value: " + searchvalueincomdetailsourdatahasbeenchangeornot);
		Assert.assertEquals(actualvalue, searchvalueincomdetailsourdatahasbeenchangeornot,
				"❌ Data was not saved correctly");

		LoggerUtil.pass(" Data has been saved and verified successfully with grade: " + actualvalue);
	}

	public static void saveadcommoidtyforupdatedata(String addcom) throws InterruptedException {
		LoggerUtil.info("User Enter The Add Commodity Tab ");
		clearAndEnterText(waitForExpectedElement(addcommodity), addcom);
		LoggerUtil.info("User Enter The Commodity Group = " + addcom);
		Thread.sleep(2000);
		LoggerUtil.info("User Click The Save ");
		clickOnElement(addcomSavebtn);

	}

	public void svaecommoditygrouptabForupdatingdata(String searchcommodityvalue, String grpclassificationvalue,
			String specificgradevalye, String densityvalue) throws InterruptedException {
		Thread.sleep(4000);

		LoggerUtil.info("Clicking on commodity group dropdown");
		clickOnElement(commoditygroupdropdown);
		Thread.sleep(2000);

		LoggerUtil.info("Fetching list of available commodity groups");
		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);

		boolean groupSelected = false;
		if (grouplist != null && !grouplist.isEmpty()) {
			for (WebElement grpvalue : grouplist) {
				String text = grpvalue.getText().trim();
				// Removed excessive logging for each value to avoid log bloat
				if (text.equalsIgnoreCase(searchcommodityvalue)) {
					try {
						grpvalue.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", grpvalue);
					}
					LoggerUtil.pass("Selected commodity group: " + text);
					groupSelected = true;
					break;
				}
			}
		}

		if (!groupSelected) {
			LoggerUtil.mismatch("❌ Commodity group not found: " + searchcommodityvalue);
		}

		Thread.sleep(3000);
		LoggerUtil.info("Entering Group Classification value: " + grpclassificationvalue);
		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);

		Thread.sleep(2000);
		LoggerUtil.info("Entering Specific Grade value: " + specificgradevalye);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);

		Thread.sleep(2000);
		LoggerUtil.info("Entering Density value: " + densityvalue);
		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);

		Thread.sleep(1000);
		LoggerUtil.info("Clicking Save button to update commodity group tab");
		clickOnElement(savebtncommoditygrp);
		LoggerUtil.pass("✅ Save action performed for commodity group tab.");

		Thread.sleep(7000);
	}

	public void savedatainthirdtabForupdatingdataforverifying(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				try {
					comgrpvalue.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", comgrpvalue);
				}
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				try {
					grpclasslistval.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", grpclasslistval);
				}
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);

		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				try {
					comgradelistval.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", comgradelistval);
				}
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);
	}

	public static final By ClickingUpdatebtnComGrpSecondTab = By.xpath("//*[@id='tab2Save']");

	public void editdatainspecificgradeforverifyupdatebuttonisworkingornot(String searchsecondtab,
			String entervalueforsaveasnew) throws InterruptedException {

		LoggerUtil.info("Searching for Specific Grade in second tab using: " + searchsecondtab);
		clearAndEnterText(waitForExpectedElement(searchinputcommoditygrp), searchsecondtab);
		Thread.sleep(6000);

		LoggerUtil.info("Clicking Edit button for the selected Specific Grade entry.");
		clickOnElement(clickeditbtnforsecondtab);
		Thread.sleep(3000);

		LoggerUtil.info("Updating Specific Grade with new value: " + entervalueforsaveasnew);
		clearAndEnterText(waitForExpectedElement(specificgradeforsaveasnewsecondtab), entervalueforsaveasnew);
		Thread.sleep(3000);

		LoggerUtil.info("Clicking Update button to save the edited Specific Grade.");
		clickOnElement(ClickingUpdatebtnComGrpSecondTab);
		LoggerUtil.pass("✅ Updated Specific Grade successfully with value: " + entervalueforsaveasnew);
	}

	public static final By ClickingUpdateBtnCommoidtyDetailsTab = By.xpath("//*[@id='tab3Save']");

	public void verifyupdatebtnincommoditydeatilstab(String searchvalueforgrade,
			String selectsaveasnewspecificgradewhichisselectinscondtab) throws InterruptedException {

		LoggerUtil.info("Opening the Commodity Details tab to verify updated value.");
		clickOnElement(ClickingViewbtn);
		Thread.sleep(7000);

		LoggerUtil.info("Searching for the Specific Grade using: " + searchvalueforgrade);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchvalueforgrade);
		Thread.sleep(8000);

		LoggerUtil.info("Clicking on Edit button to verify updated value inside edit view.");
		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(17000);

		LoggerUtil.info("Opening Specific Grade dropdown to confirm updated value is present.");
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		Thread.sleep(3000);

		LoggerUtil.info("Typing the updated grade value: " + selectsaveasnewspecificgradewhichisselectinscondtab);
		clearAndEnterText(waitForExpectedElement(SearchInputspecificgradeForThirdTab),
				selectsaveasnewspecificgradewhichisselectinscondtab);

		List<WebElement> specificgradelsitvalue = driver.findElements(specificgradelistdropincomdetails);
		boolean found = false;

		for (WebElement gradelist : specificgradelsitvalue) {
			String flaggradelist = gradelist.getText().trim();
			if (flaggradelist.equalsIgnoreCase(selectsaveasnewspecificgradewhichisselectinscondtab)) {
				try {
					gradelist.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", gradelist);
				}
				LoggerUtil.pass("✅ Matching grade found in dropdown: " + flaggradelist + ", selecting it.");
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.mismatch("❌ Updated grade not found in dropdown for: "
					+ selectsaveasnewspecificgradewhichisselectinscondtab);
		}

		LoggerUtil.info("Saving the updated value by clicking Save button.");
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(5000);

		LoggerUtil.info("Re-verifying if updated Specific Grade is saved correctly.");
		clickOnElement(ClickingViewbtn);
		Thread.sleep(7000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchvalueforgrade);
		Thread.sleep(7000);

		String actualgradevalue = waitForExpectedElement(fetchingspecificgradecolumndata).getText().trim();
		String expectedgradevalue = selectsaveasnewspecificgradewhichisselectinscondtab;

		Thread.sleep(9000);
		LoggerUtil.info("Expected Grade: " + expectedgradevalue + " | Actual Grade from UI: " + actualgradevalue);
		Assert.assertEquals(actualgradevalue, expectedgradevalue,
				"❌ Mismatch after update: Grade value not saved correctly.");
		LoggerUtil.pass("✅ Update verified successfully. Grade present as expected.");
	}

	public static final By clickselectallcheckboxfrosupplierallocation = By
			.xpath("(//button[@class='dropdown-item multiselect-all'])[1]/span/input");
	public static final By clicksupplierspecificdeltadropdown = By
			.xpath("//select[@id='SupplierSpecificDelta']/following-sibling::div/button");
//0801-Celesta
	public static final By EnteringValueSupplier = By
			.xpath("//select[@id='SupplierSpecificDelta']/following-sibling::div/div/div/input");

	public static HashMap<String, String> enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(
			String enterAprilRm, String enterAprilScrap, String enterMayRm, String enterMayScrap, String enterJuneRm,
			String enterJuneScrap, String enterJulyRm, String enterJulyScrap, String enterAugustRm,
			String enterAugustScrap, String enterSeptRm, String enterSeptScrap, String enterOctRm, String enterOctScrap,
			String enterNovRm, String enterNovScrap, String enterDecRm, String enterDecScrap, String enterJanRm,
			String enterJanScrap, String enterFebRm, String enterFebScrap, String enterMarRm, String enterMarScrap)
			throws InterruptedException {

		// HashMap to store supplier data for later validation
		HashMap<String, String> storeSupplierInfo = new HashMap<>();

		try {
			LoggerUtil.info(
					"===== Starting enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation =====");

			// ---- RM & Scrap Entry for Each Month ----
			// ---- RM & Scrap Entry for Each Month (Dynamic) ----
			String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };

			String[] rmValues = { enterAprilRm, enterMayRm, enterJuneRm, enterJulyRm, enterAugustRm, enterSeptRm,
					enterOctRm, enterNovRm, enterDecRm, enterJanRm, enterFebRm, enterMarRm };

			String[] scrapValues = { enterAprilScrap, enterMayScrap, enterJuneScrap, enterJulyScrap, enterAugustScrap,
					enterSeptScrap, enterOctScrap, enterNovScrap, enterDecScrap, enterJanScrap, enterFebScrap,
					enterMarScrap };

			for (int i = 0; i < months.length; i++) {
				String month = months[i];

				// Enter RM value
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(month, "RM")), rmValues[i]);
				LoggerUtil.info("Entered " + month + " RM → " + rmValues[i]);

				// Enter Scrap value
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(month, "Scrap")), scrapValues[i]);
				LoggerUtil.info("Entered " + month + " Scrap → " + scrapValues[i]);
			}

			LoggerUtil.pass("✅ All monthly RM & Scrap values entered successfully (April → March).");

			LoggerUtil.pass("All RM and Scrap values entered successfully for April–March.");

			// ---- Business Segment Selection ----
			clickOnElement(businessSegbox);
			LoggerUtil.info("Opened Business Segment dropdown.");

			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			LoggerUtil.info("Searched Business Segment → rishi");
			Thread.sleep(6000);

			clickOnElement(selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Selected all checkboxes in Business Segment.");

			Thread.sleep(3000);
			clickOnElement(customercheckbox);
			LoggerUtil.pass("Customer checkbox selected successfully.");

			scrollToElement(waitForExpectedElement(clicksupplierspecificdeltadropdown));
			Thread.sleep(99);
			// ---- Supplier Delta Selection ----
			clickOnElement(clicksupplierspecificdeltadropdown);
			LoggerUtil.info("Opened Supplier Specific Delta dropdown.");
			Thread.sleep(99);

			// Supplier Name Entry
			String supplierName = "0801-Celesta";
			clearAndEnterText(waitForExpectedElement(EnteringValueSupplier), supplierName);
			LoggerUtil.info("Entered Supplier Name → " + supplierName);
			Thread.sleep(3000);

			// Store in HashMap for later validation
			storeSupplierInfo.put("Supplier Name", supplierName);
			LoggerUtil.pass("Stored Supplier Name in HashMap for future validation: " + supplierName);

			clickOnElement(clickselectallcheckboxfrosupplierallocation);
			LoggerUtil.pass("Supplier checkbox selected successfully for allocation.");

			LoggerUtil.pass("Supplier Allocation configuration completed successfully.");
			LoggerUtil
					.info("===== End of enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation =====");

		} catch (Exception e) {
			LoggerUtil.fail("Exception during RM & Scrap value entry or supplier allocation: " + e.getMessage());
		}

		// Return stored supplier info for use in another method
		return storeSupplierInfo;
	}

//public user enter the supplier delta for verifying delta allocation  

	/**
	 * Dynamically builds XPath for RM/Scrap Delta input field in Supplier Delta
	 * Table.
	 *
	 * @param rowType   "manual" for 1st row (Delta Entry), "final" for 2nd row
	 *                  (Supplier Specific Landed cost)
	 * @param monthName Month name (Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec,
	 *                  Jan, Feb, Mar)
	 * @param valueType "RM" or "Scrap"
	 * @return By locator for the input element
	 */
	public static By getDynamicSupplierDeltaLocator(String rowType, String monthName, String valueType) {

		// Convert month name to proper case
		String month = monthName.trim().substring(0, 1).toUpperCase() + monthName.trim().substring(1).toLowerCase();

		// Determine row type: manual or final
		String rowXPath;
		if (rowType.equalsIgnoreCase("manual")) {
			// First row: Delta Entry
			rowXPath = "//*[@id='DeltaTableBody']/tr[contains(@class,'mannualDeltaSupplier')]";
		} else if (rowType.equalsIgnoreCase("final")) {
			// Second row: Supplier Specific Landed cost
			rowXPath = "//*[@id='DeltaTableBody']/tr[contains(@class,'finalDeltas')]";
		} else {
			throw new IllegalArgumentException("Invalid rowType: use 'manual' or 'final'");
		}

		// Decide prefix class based on row type
		String prefixClass = rowType.equalsIgnoreCase("manual") ? "delta" : "LCdelta";

		// Construct input class dynamically
		String dynamicClass = String.format("%s%s%s", prefixClass, valueType, month);
		// Example output: deltaRMApr / deltaScrapMay / LCdeltaRMFeb

		// Build final XPath using contains() for flexibility
		String dynamicXPath = String.format("%s//input[contains(@class,'%s')]", rowXPath, dynamicClass);

		return By.xpath(dynamicXPath);
	}

	public static void verifyingcalculationofsupplierallocation(String suppAprilRm, String suppAprilScrap,
			String mayRmSupp, String mayScrapSupp, String juneRmSupp, String juneScrapSupp, String julyRmSupp,
			String julyScrapSupp, String augustRmSupp, String augustScrapSupp, String sepRmSupp, String sepScrapSupp,
			String octRmSupp, String octScrapSupp, String novRmSupp, String novScrapSupp, String decRmSupp,
			String decScrapSupp, String janRmSupp, String janScrapSupp, String febRmSupp, String febScrapSupp,
			String marRmSupp, String marScrapSupp, String searchVal) throws InterruptedException {

		try {
			LoggerUtil.info("===== Starting verifyingcalculationofsupplierallocation =====");

			// --- Step 1: Enter Supplier RM & Scrap Values (April–March) ---
			LoggerUtil.info("Entering Supplier RM and Scrap values month-wise...");

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "RM")),
					suppAprilRm);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "Scrap")),
					suppAprilScrap);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "RM")), mayRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "Scrap")),
					mayScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "RM")),
					juneRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "Scrap")),
					juneScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "RM")),
					julyRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "Scrap")),
					julyScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "RM")),
					augustRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "Scrap")),
					augustScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "RM")), sepRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "Scrap")),
					sepScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "RM")), octRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "Scrap")),
					octScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "RM")), novRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "Scrap")),
					novScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "RM")), decRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "Scrap")),
					decScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "RM")), janRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "Scrap")),
					janScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "RM")), febRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "Scrap")),
					febScrapSupp);

			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "RM")), marRmSupp);
			clearAndEnterText(waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "Scrap")),
					marScrapSupp);

			LoggerUtil.pass("All monthly RM and Scrap values entered successfully for supplier allocation.");

			// --- Step 2: Save the Entered Data ---
			clickOnElement(ClickingSaveBtnForThirdTab);
			LoggerUtil.info("Clicked on Save button for Supplier Allocation tab.");
			Thread.sleep(4000);

			// --- Step 3: Open View Mode ---
			clickOnElement(ClickingViewbtn);
			LoggerUtil.info("Clicked on View button to reload saved data.");
			Thread.sleep(7000);

			// --- Step 4: Search Commodity Group ---
			clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchVal);
			LoggerUtil.info("Searched for Commodity Group value: " + searchVal);
			Thread.sleep(4000);

			// --- Step 5: Read Headers Dynamically ---
			WebElement table = waitForExpectedElement(By.id("comodityDetailListTable"));
			List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));
			HashMap<String, Integer> headerMap = new HashMap<>();

			for (int i = 0; i < headers.size(); i++) {
				String headerName = headers.get(i).getText().trim();
				if (!headerName.isEmpty())
					headerMap.put(headerName, i);
			}

			LoggerUtil.info("Detected Headers: " + headerMap);

			if (!headerMap.containsKey("Commodity Group")) {
				LoggerUtil.fail("'Commodity Group' header not found in table!");
				return;
			}

			int commodityGroupIndex = headerMap.get("Commodity Group");
			int actionIndex = headerMap.containsKey("Action") ? headerMap.get("Action") : 1; // fallback

			LoggerUtil.info("'Commodity Group' column index: " + commodityGroupIndex);
			LoggerUtil.info("'Action' column index: " + actionIndex);

			// --- Step 6: Loop through rows to find matching Commodity Group ---
			List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
			boolean recordFound = false;

			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				if (cells.size() <= commodityGroupIndex)
					continue;

				String cellValue = cells.get(commodityGroupIndex).getText().trim();
				LoggerUtil.info("Found Commodity Group in row: " + cellValue);

				if (cellValue.equalsIgnoreCase(searchVal.trim())) {
					recordFound = true;
					LoggerUtil.pass("Matched Commodity Group → " + cellValue);

					// Click Edit icon dynamically under Action column
					WebElement actionCell = cells.get(actionIndex);
					WebElement editIcon = actionCell.findElement(By.xpath(".//i[contains(@class,'fa-edit')]"));

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editIcon);
					Thread.sleep(500);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);

					LoggerUtil.pass("Clicked Edit icon for Commodity Group: " + searchVal);
					Thread.sleep(14000);
					break;
				}
			}

			if (!recordFound) {
				LoggerUtil.fail("No row found in table with Commodity Group → " + searchVal);
			}

			LoggerUtil.pass(
					"verifyingcalculationofsupplierallocation executed successfully with dynamic column detection.");
			LoggerUtil.info("===== End of verifyingcalculationofsupplierallocation =====");

		} catch (Exception e) {
			LoggerUtil.fail("Exception in verifyingcalculationofsupplierallocation: " + e.getMessage());
		}
	}

	public static void verifycalculatelandedcostForSupplierAprilmonth() {
		LoggerUtil.info("🟩 Starting April Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedRmvalueForApril = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Apr", "RM"))
				.getAttribute("value").trim();

		String landedScrapvalueForApril = waitForExpectedElement(
				getDynamicSupplierDeltaLocator("final", "Apr", "Scrap")).getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String aprilrmbase = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value")
				.trim();

		String aprilscrapbase = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")).getAttribute("value")
				.trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String suppaprilRmvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "RM"))
				.getAttribute("value").trim();

		String suppaprilscrapval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "Scrap"))
				.getAttribute("value").trim();

		// Convert to BigDecimal
		BigDecimal baseRm = new BigDecimal(aprilrmbase);
		BigDecimal suppRm = new BigDecimal(suppaprilRmvalue);
		BigDecimal baseScrap = new BigDecimal(aprilscrapbase);
		BigDecimal suppScrap = new BigDecimal(suppaprilscrapval);

		BigDecimal expectedLandedRm = baseRm.add(suppRm).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrap = baseScrap.add(suppScrap).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRm = new BigDecimal(landedRmvalueForApril);
		BigDecimal uiLandedScrap = new BigDecimal(landedScrapvalueForApril);

		BigDecimal uiRoundedRm = uiLandedRm.setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiRoundedScrap = uiLandedScrap.setScale(3, RoundingMode.HALF_UP);

		// ==== Logging Proof of all values ====
		LoggerUtil.info("April RM Calculation Proof:");
		LoggerUtil.info("   ➤ Base RM: " + baseRm + " | Supplier RM: " + suppRm);
		LoggerUtil.info("   ➤ Expected RM (rounded): " + expectedLandedRm + " | UI RM (rounded): " + uiRoundedRm);
		LoggerUtil.info("April Scrap Calculation Proof:");
		LoggerUtil.info("   ➤ Base Scrap: " + baseScrap + " | Supplier Scrap: " + suppScrap);
		LoggerUtil.info(
				"   ➤ Expected Scrap (rounded): " + expectedLandedScrap + " | UI Scrap (rounded): " + uiRoundedScrap);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		// ==== Check for more than 3 decimals in UI ====
		if (landedRmvalueForApril.contains(".") && landedRmvalueForApril.split("\\.")[1].length() > 3) {
			String msg = "FAILED: April RM Landed (Supplier) - UI value (" + landedRmvalueForApril
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedScrapvalueForApril.contains(".") && landedScrapvalueForApril.split("\\.")[1].length() > 3) {
			String msg = "FAILED: April Scrap Landed (Supplier) - UI value (" + landedScrapvalueForApril
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		// ==== Assert equality ====
		if (!uiRoundedRm.equals(expectedLandedRm)) {
			String msg = "FAILED: April RM Landed (Supplier) - UI: " + uiRoundedRm + ", Expected: " + expectedLandedRm;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiRoundedScrap.equals(expectedLandedScrap)) {
			String msg = "FAILED: April Scrap Landed (Supplier) - UI: " + uiRoundedScrap + ", Expected: "
					+ expectedLandedScrap;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		// ==== Result ====
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(
					"✅ April Landed Cost (Supplier) passed. [RM: " + uiRoundedRm + ", Scrap: " + uiRoundedScrap + "]");
		}
	}

//Landedcost Validation For May Rm And scrap 

	public static void comparingLandedCostForMay() {
		LoggerUtil.info(" Starting May Landed Cost validation for Supplier...");
		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedValueMayRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "May", "RM"))
				.getAttribute("value").trim();

		String landedValueMayScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "May", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String mayValRmStr = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value")
				.trim();

		String mayValScrapStr = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")).getAttribute("value")
				.trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String suppMayValueRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "RM"))
				.getAttribute("value").trim();

		String suppMayScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmMay = new BigDecimal(mayValRmStr);
		BigDecimal suppRmMay = new BigDecimal(suppMayValueRmStr);
		BigDecimal baseScrapMay = new BigDecimal(mayValScrapStr);
		BigDecimal suppScrapMay = new BigDecimal(suppMayScrapStr);

		BigDecimal expectedLandedRmMay = baseRmMay.add(suppRmMay).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapMay = baseScrapMay.add(suppScrapMay).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmMay = new BigDecimal(landedValueMayRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapMay = new BigDecimal(landedValueMayScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("[May][Supplier] Base RM: " + baseRmMay + ", Supplier RM: " + suppRmMay);
		LoggerUtil.info("[May][Supplier] Base Scrap: " + baseScrapMay + ", Supplier Scrap: " + suppScrapMay);
		LoggerUtil.info(
				"[May][Supplier] UI RM Landed: " + uiLandedRmMay + ", Expected Landed RM: " + expectedLandedRmMay);
		LoggerUtil.info("[May][Supplier] UI Scrap Landed: " + uiLandedScrapMay + ", Expected Landed Scrap: "
				+ expectedLandedScrapMay);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedValueMayRmStr.contains(".") && landedValueMayRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: May RM Landed (Supplier) - UI value (" + landedValueMayRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedValueMayScrapStr.contains(".") && landedValueMayScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: May Scrap Landed (Supplier) - UI value (" + landedValueMayScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmMay.equals(expectedLandedRmMay)) {
			String msg = "FAILED: May RM Landed (Supplier) - UI: " + uiLandedRmMay + ", Expected: "
					+ expectedLandedRmMay;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapMay.equals(expectedLandedScrapMay)) {
			String msg = "FAILED: May Scrap Landed (Supplier) - UI: " + uiLandedScrapMay + ", Expected: "
					+ expectedLandedScrapMay;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass("✅ May Landed Cost (Supplier) passed. [RM: " + uiLandedRmMay + ", Scrap: "
					+ uiLandedScrapMay + "]");
		}
	}

	public static void verifyComparingLandedCostForJuneMonth() {
		LoggerUtil.info("🟩 Starting June Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedValueJuneRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Jun", "RM"))
				.getAttribute("value").trim();

		String landedValueJuneScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Jun", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseJuneValRmStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value")
				.trim();

		String baseJuneScrapValStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String suppJuneRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "RM"))
				.getAttribute("value").trim();

		String suppJuneScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "Scrap"))
				.getAttribute("value").trim();

		// =============================== Validation ===============================
		BigDecimal baseRmJune = new BigDecimal(baseJuneValRmStr);
		BigDecimal suppRmJune = new BigDecimal(suppJuneRmStr);
		BigDecimal baseScrapJune = new BigDecimal(baseJuneScrapValStr);
		BigDecimal suppScrapJune = new BigDecimal(suppJuneScrapStr);

		BigDecimal expectedLandedRmJune = baseRmJune.add(suppRmJune).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapJune = baseScrapJune.add(suppScrapJune).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmJune = new BigDecimal(landedValueJuneRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapJune = new BigDecimal(landedValueJuneScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("[June][Supplier] Base RM: " + baseRmJune + ", Supplier RM: " + suppRmJune);
		LoggerUtil.info("[June][Supplier] Base Scrap: " + baseScrapJune + ", Supplier Scrap: " + suppScrapJune);
		LoggerUtil.info("[June][Supplier] UI RM Landed: " + uiLandedRmJune + ", Expected RM: " + expectedLandedRmJune);
		LoggerUtil.info("[June][Supplier] UI Scrap Landed: " + uiLandedScrapJune + ", Expected Scrap: "
				+ expectedLandedScrapJune);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		// 🔸 Decimal Precision Validation
		if (landedValueJuneRmStr.contains(".") && landedValueJuneRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: June RM Landed (Supplier) - UI value (" + landedValueJuneRmStr
					+ ") has >3 decimal digits.";
			LoggerUtil.mismatch(msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedValueJuneScrapStr.contains(".") && landedValueJuneScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: June Scrap Landed (Supplier) - UI value (" + landedValueJuneScrapStr
					+ ") has >3 decimal digits.";
			LoggerUtil.mismatch(msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		// 🔸 Value Mismatch Validation
		if (!uiLandedRmJune.equals(expectedLandedRmJune)) {
			String msg = "FAILED: June RM Landed (Supplier) - UI: " + uiLandedRmJune + ", Expected: "
					+ expectedLandedRmJune;
			LoggerUtil.mismatch(msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapJune.equals(expectedLandedScrapJune)) {
			String msg = "FAILED: June Scrap Landed (Supplier) - UI: " + uiLandedScrapJune + ", Expected: "
					+ expectedLandedScrapJune;
			LoggerUtil.mismatch(msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		// 🔸 Final Assertion
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass("✅ June Landed Cost (Supplier) passed. [RM: " + uiLandedRmJune + ", Scrap: "
					+ uiLandedScrapJune + "]");
		}
	}

	public static void comparinglandedcostforjuly() {
		LoggerUtil.info("🟩 Starting July Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedValueJulyRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Jul", "RM"))
				.getAttribute("value").trim();

		String landedValueJulyScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Jul", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseJulyRmStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value")
				.trim();

		String baseJulyScrapStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String suppJulyRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "RM"))
				.getAttribute("value").trim();

		String suppJulyScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmJuly = new BigDecimal(baseJulyRmStr);
		BigDecimal suppRmJuly = new BigDecimal(suppJulyRmStr);
		BigDecimal baseScrapJuly = new BigDecimal(baseJulyScrapStr);
		BigDecimal suppScrapJuly = new BigDecimal(suppJulyScrapStr);

		BigDecimal expectedLandedRmJuly = baseRmJuly.add(suppRmJuly).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapJuly = baseScrapJuly.add(suppScrapJuly).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmJuly = new BigDecimal(landedValueJulyRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapJuly = new BigDecimal(landedValueJulyScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("[July][Supplier] Base RM: " + baseRmJuly + ", Supplier RM: " + suppRmJuly);
		LoggerUtil.info("[July][Supplier] Base Scrap: " + baseScrapJuly + ", Supplier Scrap: " + suppScrapJuly);
		LoggerUtil.info(
				"[July][Supplier] UI RM Landed: " + uiLandedRmJuly + ", Expected Landed RM: " + expectedLandedRmJuly);
		LoggerUtil.info("[July][Supplier] UI Scrap Landed: " + uiLandedScrapJuly + ", Expected Landed Scrap: "
				+ expectedLandedScrapJuly);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedValueJulyRmStr.contains(".") && landedValueJulyRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: July RM Landed (Supplier) - UI value (" + landedValueJulyRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedValueJulyScrapStr.contains(".") && landedValueJulyScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: July Scrap Landed (Supplier) - UI value (" + landedValueJulyScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmJuly.equals(expectedLandedRmJuly)) {
			String msg = "FAILED: July RM Landed (Supplier) - UI: " + uiLandedRmJuly + ", Expected: "
					+ expectedLandedRmJuly;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapJuly.equals(expectedLandedScrapJuly)) {
			String msg = "FAILED: July Scrap Landed (Supplier) - UI: " + uiLandedScrapJuly + ", Expected: "
					+ expectedLandedScrapJuly;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" July Landed Cost (Supplier) passed. [RM: " + uiLandedRmJuly + ", Scrap: "
					+ uiLandedScrapJuly + "]");
		}
	}

	public static void comparelandedcostforaugust() {
		LoggerUtil.info(" Starting August Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostAugustRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Aug", "RM"))
				.getAttribute("value").trim();

		String landedCostAugustScrapStr = waitForExpectedElement(
				getDynamicSupplierDeltaLocator("final", "Aug", "Scrap")).getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmAugustStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")).getAttribute("value")
				.trim();

		String baseScrapAugustStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmAugustStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "RM"))
				.getAttribute("value").trim();

		String supplierScrapAugustStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmAugust = new BigDecimal(baseRmAugustStr);
		BigDecimal supplierRmAugust = new BigDecimal(supplierRmAugustStr);
		BigDecimal baseScrapAugust = new BigDecimal(baseScrapAugustStr);
		BigDecimal supplierScrapAugust = new BigDecimal(supplierScrapAugustStr);

		BigDecimal expectedLandedRmAugust = baseRmAugust.add(supplierRmAugust).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapAugust = baseScrapAugust.add(supplierScrapAugust).setScale(3,
				RoundingMode.HALF_UP);

		BigDecimal uiLandedRmAugust = new BigDecimal(landedCostAugustRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapAugust = new BigDecimal(landedCostAugustScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("August RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmAugust + " | Supplier RM: " + supplierRmAugust);
		LoggerUtil.info(
				"    Expected RM (rounded): " + expectedLandedRmAugust + " | UI RM (rounded): " + uiLandedRmAugust);
		LoggerUtil.info("August Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapAugust + " | Supplier Scrap: " + supplierScrapAugust);
		LoggerUtil.info("    Expected Scrap (rounded): " + expectedLandedScrapAugust + " | UI Scrap (rounded): "
				+ uiLandedScrapAugust);

		if (!uiLandedRmAugust.equals(expectedLandedRmAugust)) {
			LoggerUtil.mismatch(" Mismatch in August RM landed cost (up to 3 decimals). Expected: "
					+ expectedLandedRmAugust + ", Actual: " + uiLandedRmAugust);
			Assert.fail("Mismatch in August RM landed cost (up to 3 decimals). Expected: " + expectedLandedRmAugust
					+ ", Actual: " + uiLandedRmAugust);
		}
		if (!uiLandedScrapAugust.equals(expectedLandedScrapAugust)) {
			LoggerUtil.mismatch(" Mismatch in August Scrap landed cost (up to 3 decimals). Expected: "
					+ expectedLandedScrapAugust + ", Actual: " + uiLandedScrapAugust);
			Assert.fail("Mismatch in August Scrap landed cost (up to 3 decimals). Expected: "
					+ expectedLandedScrapAugust + ", Actual: " + uiLandedScrapAugust);
		}
		LoggerUtil.pass(" August Landed Cost calculation passed. [RM: " + uiLandedRmAugust + ", Scrap: "
				+ uiLandedScrapAugust + "]");
	}

	public static void comparelandedcostForseptember() {
		LoggerUtil.info(" Starting September Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostSeptemberRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Sep", "RM"))
				.getAttribute("value").trim();

		String landedCostSeptemberScrapStr = waitForExpectedElement(
				getDynamicSupplierDeltaLocator("final", "Sep", "Scrap")).getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmSeptemberStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM"))
				.getAttribute("value").trim();

		String baseScrapSeptemberStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmSeptemberStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "RM"))
				.getAttribute("value").trim();

		String supplierScrapSeptemberStr = waitForExpectedElement(
				getDynamicSupplierDeltaLocator("manual", "Sep", "Scrap")).getAttribute("value").trim();

		BigDecimal baseRmSeptember = new BigDecimal(baseRmSeptemberStr);
		BigDecimal supplierRmSeptember = new BigDecimal(supplierRmSeptemberStr);
		BigDecimal baseScrapSeptember = new BigDecimal(baseScrapSeptemberStr);
		BigDecimal supplierScrapSeptember = new BigDecimal(supplierScrapSeptemberStr);

		BigDecimal expectedLandedRmSeptember = baseRmSeptember.add(supplierRmSeptember).setScale(3,
				RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapSeptember = baseScrapSeptember.add(supplierScrapSeptember).setScale(3,
				RoundingMode.HALF_UP);

		BigDecimal uiLandedRmSeptember = new BigDecimal(landedCostSeptemberRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapSeptember = new BigDecimal(landedCostSeptemberScrapStr).setScale(3,
				RoundingMode.HALF_UP);

		LoggerUtil.info("September RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmSeptember + " | Supplier RM: " + supplierRmSeptember);
		LoggerUtil.info("    Expected RM (rounded): " + expectedLandedRmSeptember + " | UI RM (rounded): "
				+ uiLandedRmSeptember);
		LoggerUtil.info("September Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapSeptember + " | Supplier Scrap: " + supplierScrapSeptember);
		LoggerUtil.info("    Expected Scrap (rounded): " + expectedLandedScrapSeptember + " | UI Scrap (rounded): "
				+ uiLandedScrapSeptember);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostSeptemberRmStr.contains(".") && landedCostSeptemberRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: September RM Landed (Supplier) - UI value (" + landedCostSeptemberRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch:  " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostSeptemberScrapStr.contains(".") && landedCostSeptemberScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: September Scrap Landed (Supplier) - UI value (" + landedCostSeptemberScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch:  " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmSeptember.equals(expectedLandedRmSeptember)) {
			String msg = "FAILED: September RM Landed (Supplier) - UI: " + uiLandedRmSeptember + ", Expected: "
					+ expectedLandedRmSeptember;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapSeptember.equals(expectedLandedScrapSeptember)) {
			String msg = "FAILED: September Scrap Landed (Supplier) - UI: " + uiLandedScrapSeptember + ", Expected: "
					+ expectedLandedScrapSeptember;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" September Landed Cost calculation passed. [RM: " + uiLandedRmSeptember + ", Scrap: "
					+ uiLandedScrapSeptember + "]");
		}
	}

	public static void comparelandedcostForoctober() {
		LoggerUtil.info(" Starting October Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostOctoberRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Oct", "RM"))
				.getAttribute("value").trim();

		String landedCostOctoberScrapStr = waitForExpectedElement(
				getDynamicSupplierDeltaLocator("final", "Oct", "Scrap")).getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmOctoberStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")).getAttribute("value")
				.trim();

		String baseScrapOctoberStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmOctoberStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "RM"))
				.getAttribute("value").trim();

		String supplierScrapOctoberStr = waitForExpectedElement(
				getDynamicSupplierDeltaLocator("manual", "Oct", "Scrap")).getAttribute("value").trim();

		BigDecimal baseRmOctober = new BigDecimal(baseRmOctoberStr);
		BigDecimal supplierRmOctober = new BigDecimal(supplierRmOctoberStr);
		BigDecimal baseScrapOctober = new BigDecimal(baseScrapOctoberStr);
		BigDecimal supplierScrapOctober = new BigDecimal(supplierScrapOctoberStr);

		BigDecimal expectedLandedRmOctober = baseRmOctober.add(supplierRmOctober).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapOctober = baseScrapOctober.add(supplierScrapOctober).setScale(3,
				RoundingMode.HALF_UP);

		BigDecimal uiLandedRmOctober = new BigDecimal(landedCostOctoberRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapOctober = new BigDecimal(landedCostOctoberScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("October RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmOctober + " | Supplier RM: " + supplierRmOctober);
		LoggerUtil.info(
				"    Expected RM (rounded): " + expectedLandedRmOctober + " | UI RM (rounded): " + uiLandedRmOctober);
		LoggerUtil.info("October Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapOctober + " | Supplier Scrap: " + supplierScrapOctober);
		LoggerUtil.info("    Expected Scrap (rounded): " + expectedLandedScrapOctober + " | UI Scrap (rounded): "
				+ uiLandedScrapOctober);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostOctoberRmStr.contains(".") && landedCostOctoberRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: October RM Landed (Supplier) - UI value (" + landedCostOctoberRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostOctoberScrapStr.contains(".") && landedCostOctoberScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: October Scrap Landed (Supplier) - UI value (" + landedCostOctoberScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmOctober.equals(expectedLandedRmOctober)) {
			String msg = "FAILED: October RM Landed (Supplier) - UI: " + uiLandedRmOctober + ", Expected: "
					+ expectedLandedRmOctober;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapOctober.equals(expectedLandedScrapOctober)) {
			String msg = "FAILED: October Scrap Landed (Supplier) - UI: " + uiLandedScrapOctober + ", Expected: "
					+ expectedLandedScrapOctober;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" October Landed Cost calculation passed. [RM: " + uiLandedRmOctober + ", Scrap: "
					+ uiLandedScrapOctober + "]");
		}
	}

	public static void comparelandedcostForNovember() {
		LoggerUtil.info(" Starting November Landed Cost validation for Supplier...");
		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostNovRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Nov", "RM"))
				.getAttribute("value").trim();

		String landedCostNovScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Nov", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmNovStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")).getAttribute("value")
				.trim();

		String baseScrapNovStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmNovStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "RM"))
				.getAttribute("value").trim();

		String supplierScrapNovStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmNov = new BigDecimal(baseRmNovStr);
		BigDecimal supplierRmNov = new BigDecimal(supplierRmNovStr);
		BigDecimal baseScrapNov = new BigDecimal(baseScrapNovStr);
		BigDecimal supplierScrapNov = new BigDecimal(supplierScrapNovStr);

		BigDecimal expectedLandedRmNov = baseRmNov.add(supplierRmNov).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapNov = baseScrapNov.add(supplierScrapNov).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmNov = new BigDecimal(landedCostNovRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapNov = new BigDecimal(landedCostNovScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("November RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmNov + " | Supplier RM: " + supplierRmNov);
		LoggerUtil.info("    Expected RM (rounded): " + expectedLandedRmNov + " | UI RM (rounded): " + uiLandedRmNov);
		LoggerUtil.info("November Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapNov + " | Supplier Scrap: " + supplierScrapNov);
		LoggerUtil.info("    Expected Scrap (rounded): " + expectedLandedScrapNov + " | UI Scrap (rounded): "
				+ uiLandedScrapNov);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostNovRmStr.contains(".") && landedCostNovRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: November RM Landed (Supplier) - UI value (" + landedCostNovRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostNovScrapStr.contains(".") && landedCostNovScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: November Scrap Landed (Supplier) - UI value (" + landedCostNovScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmNov.equals(expectedLandedRmNov)) {
			String msg = "FAILED: November RM Landed (Supplier) - UI: " + uiLandedRmNov + ", Expected: "
					+ expectedLandedRmNov;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapNov.equals(expectedLandedScrapNov)) {
			String msg = "FAILED: November Scrap Landed (Supplier) - UI: " + uiLandedScrapNov + ", Expected: "
					+ expectedLandedScrapNov;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" November Landed Cost calculation passed. [RM: " + uiLandedRmNov + ", Scrap: "
					+ uiLandedScrapNov + "]");
		}
	}

	public static void comparelandedcostForDecember() {
		LoggerUtil.info(" Starting December Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostDecRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Dec", "RM"))
				.getAttribute("value").trim();

		String landedCostDecScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Dec", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmDecStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")).getAttribute("value")
				.trim();

		String baseScrapDecStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmDecStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "RM"))
				.getAttribute("value").trim();

		String supplierScrapDecStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmDec = new BigDecimal(baseRmDecStr);
		BigDecimal supplierRmDec = new BigDecimal(supplierRmDecStr);
		BigDecimal baseScrapDec = new BigDecimal(baseScrapDecStr);
		BigDecimal supplierScrapDec = new BigDecimal(supplierScrapDecStr);

		BigDecimal expectedLandedRmDec = baseRmDec.add(supplierRmDec).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapDec = baseScrapDec.add(supplierScrapDec).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmDec = new BigDecimal(landedCostDecRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapDec = new BigDecimal(landedCostDecScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("December RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmDec + " | Supplier RM: " + supplierRmDec);
		LoggerUtil.info("    Expected RM (rounded): " + expectedLandedRmDec + " | UI RM (rounded): " + uiLandedRmDec);
		LoggerUtil.info("December Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapDec + " | Supplier Scrap: " + supplierScrapDec);
		LoggerUtil.info("    Expected Scrap (rounded): " + expectedLandedScrapDec + " | UI Scrap (rounded): "
				+ uiLandedScrapDec);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostDecRmStr.contains(".") && landedCostDecRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: December RM Landed (Supplier) - UI value (" + landedCostDecRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostDecScrapStr.contains(".") && landedCostDecScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: December Scrap Landed (Supplier) - UI value (" + landedCostDecScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmDec.equals(expectedLandedRmDec)) {
			String msg = "FAILED: December RM Landed (Supplier) - UI: " + uiLandedRmDec + ", Expected: "
					+ expectedLandedRmDec;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapDec.equals(expectedLandedScrapDec)) {
			String msg = "FAILED: December Scrap Landed (Supplier) - UI: " + uiLandedScrapDec + ", Expected: "
					+ expectedLandedScrapDec;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" December Landed Cost calculation passed. [RM: " + uiLandedRmDec + ", Scrap: "
					+ uiLandedScrapDec + "]");
		}
	}

	public static void comparelandedcostForJan() {
		LoggerUtil.info(" Starting January Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostJanRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Jan", "RM"))
				.getAttribute("value").trim();

		String landedCostJanScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Jan", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmJanStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")).getAttribute("value")
				.trim();

		String baseScrapJanStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmJanStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "RM"))
				.getAttribute("value").trim();

		String supplierScrapJanStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmJan = new BigDecimal(baseRmJanStr);
		BigDecimal supplierRmJan = new BigDecimal(supplierRmJanStr);
		BigDecimal baseScrapJan = new BigDecimal(baseScrapJanStr);
		BigDecimal supplierScrapJan = new BigDecimal(supplierScrapJanStr);

		BigDecimal expectedLandedRmJan = baseRmJan.add(supplierRmJan).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapJan = baseScrapJan.add(supplierScrapJan).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmJan = new BigDecimal(landedCostJanRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapJan = new BigDecimal(landedCostJanScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("January RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmJan + " | Supplier RM: " + supplierRmJan);
		LoggerUtil.info("    Expected RM (rounded): " + expectedLandedRmJan + " | UI RM (rounded): " + uiLandedRmJan);
		LoggerUtil.info("January Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapJan + " | Supplier Scrap: " + supplierScrapJan);
		LoggerUtil.info("    Expected Scrap (rounded): " + expectedLandedScrapJan + " | UI Scrap (rounded): "
				+ uiLandedScrapJan);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostJanRmStr.contains(".") && landedCostJanRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: January RM Landed (Supplier) - UI value (" + landedCostJanRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostJanScrapStr.contains(".") && landedCostJanScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: January Scrap Landed (Supplier) - UI value (" + landedCostJanScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmJan.equals(expectedLandedRmJan)) {
			String msg = "FAILED: January RM Landed (Supplier) - UI: " + uiLandedRmJan + ", Expected: "
					+ expectedLandedRmJan;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapJan.equals(expectedLandedScrapJan)) {
			String msg = "FAILED: January Scrap Landed (Supplier) - UI: " + uiLandedScrapJan + ", Expected: "
					+ expectedLandedScrapJan;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" January Landed Cost calculation passed. [RM: " + uiLandedRmJan + ", Scrap: "
					+ uiLandedScrapJan + "]");
		}
	}

	public static void comparelandedcostForFebruary() {
		LoggerUtil.info(" Starting February Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostFebRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Feb", "RM"))
				.getAttribute("value").trim();

		String landedCostFebScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Feb", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (Base Input Section)
		String baseRmFebStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")).getAttribute("value")
				.trim();

		String baseScrapFebStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta Row)
		String supplierRmFebStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "RM"))
				.getAttribute("value").trim();

		String supplierScrapFebStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmFeb = new BigDecimal(baseRmFebStr);
		BigDecimal supplierRmFeb = new BigDecimal(supplierRmFebStr);
		BigDecimal baseScrapFeb = new BigDecimal(baseScrapFebStr);
		BigDecimal supplierScrapFeb = new BigDecimal(supplierScrapFebStr);

		BigDecimal expectedLandedRmFeb = baseRmFeb.add(supplierRmFeb).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapFeb = baseScrapFeb.add(supplierScrapFeb).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmFeb = new BigDecimal(landedCostFebRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapFeb = new BigDecimal(landedCostFebScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("February RM Calculation Proof:");
		LoggerUtil.info("    Base RM: " + baseRmFeb + " | Supplier RM: " + supplierRmFeb);
		LoggerUtil.info("    Expected RM (rounded): " + expectedLandedRmFeb + " | UI RM (rounded): " + uiLandedRmFeb);
		LoggerUtil.info("February Scrap Calculation Proof:");
		LoggerUtil.info("    Base Scrap: " + baseScrapFeb + " | Supplier Scrap: " + supplierScrapFeb);
		LoggerUtil.info(
				"  Expected Scrap (rounded): " + expectedLandedScrapFeb + " | UI Scrap (rounded): " + uiLandedScrapFeb);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostFebRmStr.contains(".") && landedCostFebRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: February RM Landed (Supplier) - UI value (" + landedCostFebRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostFebScrapStr.contains(".") && landedCostFebScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: February Scrap Landed (Supplier) - UI value (" + landedCostFebScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmFeb.equals(expectedLandedRmFeb)) {
			String msg = "FAILED: February RM Landed (Supplier) - UI: " + uiLandedRmFeb + ", Expected: "
					+ expectedLandedRmFeb;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapFeb.equals(expectedLandedScrapFeb)) {
			String msg = "FAILED: February Scrap Landed (Supplier) - UI: " + uiLandedScrapFeb + ", Expected: "
					+ expectedLandedScrapFeb;
			LoggerUtil.mismatch("Mismatch: ❌ " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}

		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" February Landed Cost calculation passed. [RM: " + uiLandedRmFeb + ", Scrap: "
					+ uiLandedScrapFeb + "]");
		}
	}

	public static void comparelandedcostForMarch() {
		LoggerUtil.info(" Starting March Landed Cost validation for Supplier...");

		// 🔹 Supplier Landed Cost (FinalDelta Row)
		String landedCostMarchRmStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Mar", "RM"))
				.getAttribute("value").trim();

		String landedCostMarchScrapStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("final", "Mar", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Base RM & Scrap (from Base Inputs)
		String baseRmMarchStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value")
				.trim();

		String baseScrapMarchStr = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap"))
				.getAttribute("value").trim();

		// 🔹 Supplier Delta (ManualDelta row)
		String supplierRmMarchStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "RM"))
				.getAttribute("value").trim();

		String supplierScrapMarchStr = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal baseRmMarch = new BigDecimal(baseRmMarchStr);
		BigDecimal supplierRmMarch = new BigDecimal(supplierRmMarchStr);
		BigDecimal baseScrapMarch = new BigDecimal(baseScrapMarchStr);
		BigDecimal supplierScrapMarch = new BigDecimal(supplierScrapMarchStr);

		BigDecimal expectedLandedRmMarch = baseRmMarch.add(supplierRmMarch).setScale(3, RoundingMode.HALF_UP);
		BigDecimal expectedLandedScrapMarch = baseScrapMarch.add(supplierScrapMarch).setScale(3, RoundingMode.HALF_UP);

		BigDecimal uiLandedRmMarch = new BigDecimal(landedCostMarchRmStr).setScale(3, RoundingMode.HALF_UP);
		BigDecimal uiLandedScrapMarch = new BigDecimal(landedCostMarchScrapStr).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("March RM Calculation Proof:");
		LoggerUtil.info(" Base RM: " + baseRmMarch + " | Supplier RM: " + supplierRmMarch);
		LoggerUtil
				.info("   Expected RM (rounded): " + expectedLandedRmMarch + " | UI RM (rounded): " + uiLandedRmMarch);
		LoggerUtil.info("March Scrap Calculation Proof:");
		LoggerUtil.info("  Base Scrap: " + baseScrapMarch + " | Supplier Scrap: " + supplierScrapMarch);
		LoggerUtil.info(" Expected Scrap (rounded): " + expectedLandedScrapMarch + " | UI Scrap (rounded): "
				+ uiLandedScrapMarch);

		boolean isFail = false;
		StringBuilder failMsg = new StringBuilder();

		if (landedCostMarchRmStr.contains(".") && landedCostMarchRmStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: March RM Landed (Supplier) - UI value (" + landedCostMarchRmStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch:  " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (landedCostMarchScrapStr.contains(".") && landedCostMarchScrapStr.split("\\.")[1].length() > 3) {
			String msg = "FAILED: March Scrap Landed (Supplier) - UI value (" + landedCostMarchScrapStr
					+ ") has more than 3 decimal digits.";
			LoggerUtil.mismatch("Mismatch:  " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedRmMarch.equals(expectedLandedRmMarch)) {
			String msg = "FAILED: March RM Landed (Supplier) - UI: " + uiLandedRmMarch + ", Expected: "
					+ expectedLandedRmMarch;
			LoggerUtil.mismatch("Mismatch:  " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (!uiLandedScrapMarch.equals(expectedLandedScrapMarch)) {
			String msg = "FAILED: March Scrap Landed (Supplier) - UI: " + uiLandedScrapMarch + ", Expected: "
					+ expectedLandedScrapMarch;
			LoggerUtil.mismatch("Mismatch:  " + msg);
			failMsg.append(msg).append("\n");
			isFail = true;
		}
		if (isFail) {
			Assert.fail(failMsg.toString());
		} else {
			LoggerUtil.pass(" March Landed Cost calculation passed. [RM: " + uiLandedRmMarch + ", Scrap: "
					+ uiLandedScrapMarch + "]");
		}
	}

	public static final By q1forsupplierloctionRm = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[27]/input");
	public static final By q1forsupplierlocationScrap = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[28]/input");
	public static final By q2forsupplierlocationrm = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[29]/input");
	public static final By q2forsupplierlocationscrap = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[30]/input");
	public static final By q3forsupplierlocationrm = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[31]/input");
	public static final By q3forsupplierlocationscrap = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[32]/input");
	public static final By q4forsupplierlocationrm = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[33]/input");
	public static final By q4forsupplierlocationscrap = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[34]/input");

	public static void calculatefirstquaterinsupplierallocation() throws InterruptedException {
		Thread.sleep(3000);

		LoggerUtil.info("🧾 Starting Q1 RM average verification for Supplier (April to June)");

		String aprilVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "RM"))
				.getAttribute("value").trim();

		String mayVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "RM"))
				.getAttribute("value").trim();

		String juneVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "RM"))
				.getAttribute("value").trim();

		String q1ValRaw = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q1", "RM"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		LoggerUtil.info("Monthly RM values for Q1 Supplier:");

		if (!aprilVal.isEmpty()) {
			BigDecimal aprilRm = new BigDecimal(aprilVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" April RM: " + aprilRm.toPlainString());
			sum = sum.add(aprilRm);
			count++;
		}
		if (!mayVal.isEmpty()) {
			BigDecimal mayRm = new BigDecimal(mayVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" May RM: " + mayRm.toPlainString());
			sum = sum.add(mayRm);
			count++;
		}
		if (!juneVal.isEmpty()) {
			BigDecimal juneRm = new BigDecimal(juneVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" June RM: " + juneRm.toPlainString());
			sum = sum.add(juneRm);
			count++;
		}

		if (count == 0) {
			LoggerUtil.mismatch(" No RM values entered for Q1 Supplier months.");
			Assert.fail(" No values found for Q1 RM Supplier months.");
		}

		BigDecimal q1Average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);
		BigDecimal q1FromUI = new BigDecimal(q1ValRaw);

		if (q1ValRaw.contains(".")) {
			String decimalPart = q1ValRaw.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(" FAILED: Q1 RM (Supplier) - The following asserts failed: UI Q1 RM value ("
						+ q1ValRaw + ") has more than 3 decimal digits.");
				Assert.fail("UI Q1 RM value (" + q1ValRaw + ") has more than 3 decimal digits.");
			}
			q1FromUI = q1FromUI.setScale(3, RoundingMode.HALF_UP);
		} else {
			q1FromUI = q1FromUI.setScale(3, RoundingMode.HALF_UP);
		}

		LoggerUtil.info("Calculated Q1 RM Average: " + q1Average.toPlainString());
		LoggerUtil.info("UI Q1 RM Value (rounded): " + q1FromUI.toPlainString());

		if (!q1FromUI.equals(q1Average)) {
			LoggerUtil.mismatch(" FAILED: Q1 RM (Supplier) - Mismatch: UI Q1 RM value (" + q1FromUI
					+ ") != Calculated Q1 RM Average (" + q1Average + ")");
			Assert.fail(" Q1 RM (Supplier) mismatch: UI = " + q1FromUI + ", Calculated = " + q1Average);
		} else {
			LoggerUtil.info(" Completed Q1 RM Supplier average verification.");
			LoggerUtil.pass(" Q1 RM (Supplier) calculation passed.");
		}
	}

	public static void calculatefirstQuarterScrapSupplierAllocation() throws InterruptedException {
		LoggerUtil.info(" Starting Q1 Scrap average verification for Supplier (April to June)");
		Thread.sleep(3000);

		String aprilScrapVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "Scrap"))
				.getAttribute("value").trim();

		String mayScrapVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "Scrap"))
				.getAttribute("value").trim();

		String juneScrapVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "Scrap"))
				.getAttribute("value").trim();

		String q1ScrapRaw = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q1", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		LoggerUtil.info("Monthly Scrap values for Q1 Supplier:");

		if (!aprilScrapVal.isEmpty()) {
			BigDecimal aprilScrap = new BigDecimal(aprilScrapVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" April Scrap: " + aprilScrap.toPlainString());
			sum = sum.add(aprilScrap);
			count++;
		}
		if (!mayScrapVal.isEmpty()) {
			BigDecimal mayScrap = new BigDecimal(mayScrapVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" May Scrap: " + mayScrap.toPlainString());
			sum = sum.add(mayScrap);
			count++;
		}
		if (!juneScrapVal.isEmpty()) {
			BigDecimal juneScrap = new BigDecimal(juneScrapVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" June Scrap: " + juneScrap.toPlainString());
			sum = sum.add(juneScrap);
			count++;
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch:  No Scrap values entered for Q1 Supplier months.");
			Assert.fail(" No values found for Q1 Scrap Supplier months.");
		}

		BigDecimal q1ScrapAverage = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		BigDecimal q1ScrapFromUI = new BigDecimal(q1ScrapRaw);
		if (q1ScrapRaw.contains(".")) {
			String decimalPart = q1ScrapRaw.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch:  FAILED: Q1 Scrap (Supplier) - UI Q1 Scrap value (" + q1ScrapRaw
						+ ") has more than 3 decimal digits.");
				Assert.fail("UI Q1 Scrap value (" + q1ScrapRaw + ") has more than 3 decimal digits.");
			}
			q1ScrapFromUI = q1ScrapFromUI.setScale(3, RoundingMode.HALF_UP);
		} else {
			q1ScrapFromUI = q1ScrapFromUI.setScale(3, RoundingMode.HALF_UP);
		}

		LoggerUtil.info("Calculated Q1 Scrap Average: " + q1ScrapAverage.toPlainString());
		LoggerUtil.info("UI Q1 Scrap Value (rounded): " + q1ScrapFromUI.toPlainString());
		LoggerUtil.info("Total Valid Entries for Q1 Scrap Supplier: " + count);

		if (!q1ScrapFromUI.equals(q1ScrapAverage)) {
			LoggerUtil.mismatch(
					"Mismatch: FAILED: Q1 Scrap (Supplier) - UI: " + q1ScrapFromUI + ", Expected: " + q1ScrapAverage);
			Assert.fail(" Q1 Scrap (Supplier) mismatch: UI = " + q1ScrapFromUI + ", Calculated = " + q1ScrapAverage);
		} else {
			LoggerUtil.info(" Completed Q1 Scrap Supplier average verification.");
			LoggerUtil.pass(" Q1 Scrap (Supplier) calculation passed.");
		}
	}

	public static void calculateSecondquaterinsupplierallocation() throws InterruptedException {
		Thread.sleep(3000);

		LoggerUtil.info(" Starting Q2 RM average verification for Supplier (July to September)");

		String julyVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "RM"))
				.getAttribute("value").trim();

		String augustVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "RM"))
				.getAttribute("value").trim();

		String septemberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "RM"))
				.getAttribute("value").trim();

		String q2ValRaw = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q2", "RM"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		LoggerUtil.info("Monthly RM values for Q2 Supplier:");

		if (!julyVal.isEmpty()) {
			BigDecimal julyRm = new BigDecimal(julyVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" July RM: " + julyRm.toPlainString());
			sum = sum.add(julyRm);
			count++;
		}
		if (!augustVal.isEmpty()) {
			BigDecimal augustRm = new BigDecimal(augustVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" August RM: " + augustRm.toPlainString());
			sum = sum.add(augustRm);
			count++;
		}
		if (!septemberVal.isEmpty()) {
			BigDecimal septemberRm = new BigDecimal(septemberVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" September RM: " + septemberRm.toPlainString());
			sum = sum.add(septemberRm);
			count++;
		}

		if (count == 0) {
			LoggerUtil.mismatch(" No RM values entered for Q2 Supplier months.");
			Assert.fail(" No values found for Q2 RM Supplier months.");
		}

		BigDecimal q2Average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);
		BigDecimal q2FromUI = new BigDecimal(q2ValRaw);

		if (q2ValRaw.contains(".")) {
			String decimalPart = q2ValRaw.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(" FAILED: Q2 RM (Supplier) - The following asserts failed: UI Q2 RM value ("
						+ q2ValRaw + ") has more than 3 decimal digits.");
				Assert.fail("UI Q2 RM value (" + q2ValRaw + ") has more than 3 decimal digits.");
			}
			q2FromUI = q2FromUI.setScale(3, RoundingMode.HALF_UP);
		} else {
			q2FromUI = q2FromUI.setScale(3, RoundingMode.HALF_UP);
		}

		LoggerUtil.info("Calculated Q2 RM Average: " + q2Average.toPlainString());
		LoggerUtil.info("UI Q2 RM Value (rounded): " + q2FromUI.toPlainString());

		if (!q2FromUI.equals(q2Average)) {
			LoggerUtil.mismatch("FAILED: Q2 RM (Supplier) - Mismatch: UI Q2 RM value (" + q2FromUI
					+ ") != Calculated Q2 RM Average (" + q2Average + ")");
			Assert.fail(" Q2 RM (Supplier) mismatch: UI = " + q2FromUI + ", Calculated = " + q2Average);
		} else {
			LoggerUtil.info(" Completed Q2 RM Supplier average verification.");
			LoggerUtil.pass(" Q2 RM (Supplier) calculation passed.");
		}
	}

	public static void calculateSecondQ2ScrapForSupplierAllocation() {
		LoggerUtil.info(" Starting Q2 Scrap average verification for Supplier (July to September)");

		String julyScrapVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "Scrap"))
				.getAttribute("value").trim();

		String augustScrapVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "Scrap"))
				.getAttribute("value").trim();

		String septemberScrapVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "Scrap"))
				.getAttribute("value").trim();

		String q2ScrapRaw = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q2", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		LoggerUtil.info("Monthly Scrap values for Q2 Supplier:");

		if (!julyScrapVal.isEmpty()) {
			BigDecimal julyScrap = new BigDecimal(julyScrapVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" July Scrap: " + julyScrap.toPlainString());
			sum = sum.add(julyScrap);
			count++;
		}
		if (!augustScrapVal.isEmpty()) {
			BigDecimal augustScrap = new BigDecimal(augustScrapVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" August Scrap: " + augustScrap.toPlainString());
			sum = sum.add(augustScrap);
			count++;
		}
		if (!septemberScrapVal.isEmpty()) {
			BigDecimal septemberScrap = new BigDecimal(septemberScrapVal).setScale(3, RoundingMode.HALF_UP);
			LoggerUtil.info(" September Scrap: " + septemberScrap.toPlainString());
			sum = sum.add(septemberScrap);
			count++;
		}

		if (count == 0) {
			LoggerUtil.mismatch(" No Scrap values entered for Q2 Supplier months.");
			Assert.fail(" No values found for Q2 Scrap Supplier months.");
		}

		BigDecimal q2ScrapAverage = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);
		BigDecimal q2ScrapFromUI = new BigDecimal(q2ScrapRaw);

		if (q2ScrapRaw.contains(".")) {
			String decimalPart = q2ScrapRaw.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(" FAILED: Q2 Scrap (Supplier) - The following asserts failed: UI Q2 Scrap value ("
						+ q2ScrapRaw + ") has more than 3 decimal digits.");
				Assert.fail("UI Q2 Scrap value (" + q2ScrapRaw + ") has more than 3 decimal digits.");
			}
			q2ScrapFromUI = q2ScrapFromUI.setScale(3, RoundingMode.HALF_UP);
		} else {
			q2ScrapFromUI = q2ScrapFromUI.setScale(3, RoundingMode.HALF_UP);
		}

		LoggerUtil.info("Calculated Q2 Scrap Average: " + q2ScrapAverage.toPlainString());
		LoggerUtil.info("UI Q2 Scrap Value (rounded): " + q2ScrapFromUI.toPlainString());

		if (!q2ScrapFromUI.equals(q2ScrapAverage)) {
			LoggerUtil.mismatch(" FAILED: Q2 Scrap (Supplier) - Mismatch: UI Q2 Scrap value (" + q2ScrapFromUI
					+ ") != Calculated Q2 Scrap Average (" + q2ScrapAverage + ")");
			Assert.fail(" Q2 Scrap (Supplier) mismatch: UI = " + q2ScrapFromUI + ", Calculated = " + q2ScrapAverage);
		} else {
			LoggerUtil.info(" Completed Q2 Scrap Supplier average verification.");
			LoggerUtil.pass(" Q2 Scrap (Supplier) calculation passed.");
		}
	}

	public static void calculateQ3RmAverageWithValidEntries() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info(" Starting Q3 RM average calculation with valid entries count...");

		String octoberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "RM"))
				.getAttribute("value").trim();

		String novemberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "RM"))
				.getAttribute("value").trim();

		String decemberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "RM"))
				.getAttribute("value").trim();

		String q3ValRaw = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q3", "RM"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(octoberVal));
			count++;
			LoggerUtil.info("October RM: " + octoberVal);
		} else {
			LoggerUtil.info("October RM: Not Entered");
		}

		if (!novemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(novemberVal));
			count++;
			LoggerUtil.info("November RM: " + novemberVal);
		} else {
			LoggerUtil.info("November RM: Not Entered");
		}

		if (!decemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(decemberVal));
			count++;
			LoggerUtil.info("December RM: " + decemberVal);
		} else {
			LoggerUtil.info("December RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q3 months.");
			Assert.fail(" No values found for Q3 RM months.");
		}

		BigDecimal average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);
		BigDecimal expectedVal = new BigDecimal(q3ValRaw).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q3 RM Average: " + average);
		LoggerUtil.info("Expected Q3 RM (UI): " + expectedVal);
		LoggerUtil.info("Total Valid Entries: " + count);

		if (q3ValRaw.contains(".")) {
			String decimalPart = q3ValRaw.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q3 RM (Supplier) - UI Q3 RM value (" + q3ValRaw
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI value for Q3 RM (" + q3ValRaw + ") has more than 3 decimal digits.");
			}
		}

		if (!expectedVal.equals(average)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q3 RM (Supplier) - UI: " + expectedVal + ", Expected: " + average);
		}

		softAssert.assertEquals(expectedVal, average,
				"❌ Q3 RM mismatch: Expected = " + expectedVal + ", Calculated = " + average);

		LoggerUtil.info("✅ Q3 RM Average calculation completed.");
		softAssert.assertAll();
	}

	public static void calculateQ3ScrapAverageWithValidEntries() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info("🧾 Starting Q3 Scrap average calculation with valid entries count...");

		String octoberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "Scrap"))
				.getAttribute("value").trim();

		String novemberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "Scrap"))
				.getAttribute("value").trim();

		String decemberVal = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "Scrap"))
				.getAttribute("value").trim();

		String q3ValRaw = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q3", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(octoberVal));
			count++;
			LoggerUtil.info("October Scrap: " + octoberVal);
		} else {
			LoggerUtil.info("October Scrap: Not Entered");
		}

		if (!novemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(novemberVal));
			count++;
			LoggerUtil.info("November Scrap: " + novemberVal);
		} else {
			LoggerUtil.info("November Scrap: Not Entered");
		}

		if (!decemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(decemberVal));
			count++;
			LoggerUtil.info("December Scrap: " + decemberVal);
		} else {
			LoggerUtil.info("December Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for Q3 months.");
			Assert.fail("❌ No values found for Q3 Scrap months.");
		}

		BigDecimal average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);
		BigDecimal expectedVal = new BigDecimal(q3ValRaw).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q3 Scrap Average: " + average);
		LoggerUtil.info("Expected Q3 Scrap (UI): " + expectedVal);
		LoggerUtil.info("Total Valid Entries: " + count);

		if (q3ValRaw.contains(".")) {
			String decimalPart = q3ValRaw.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q3 Scrap (Supplier) - UI Q3 Scrap value (" + q3ValRaw
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI value for Q3 Scrap (" + q3ValRaw + ") has more than 3 decimal digits.");
			}
		}

		if (!expectedVal.equals(average)) {
			LoggerUtil.mismatch(
					"Mismatch: ❌ FAILED: Q3 Scrap (Supplier) - UI: " + expectedVal + ", Expected: " + average);
		}

		softAssert.assertEquals(expectedVal, average,
				"❌ Q3 Scrap mismatch: Expected = " + expectedVal + ", Calculated = " + average);

		LoggerUtil.info("✅ Q3 Scrap Average calculation completed.");
		softAssert.assertAll();
	}

	public static void calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation() {
		SoftAssert softAssert = new SoftAssert();

		String jansupprmval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "RM"))
				.getAttribute("value").trim();

		String febsupprmval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "RM"))
				.getAttribute("value").trim();

		String marhsupprmval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "RM"))
				.getAttribute("value").trim();

		String q4rmvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q4", "RM"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!jansupprmval.isEmpty()) {
			BigDecimal janRM = new BigDecimal(jansupprmval);
			sum = sum.add(janRM);
			count++;
			LoggerUtil.info("January RM: " + janRM);
		} else {
			LoggerUtil.info("January RM: Not Entered");
		}

		if (!febsupprmval.isEmpty()) {
			BigDecimal febRM = new BigDecimal(febsupprmval);
			sum = sum.add(febRM);
			count++;
			LoggerUtil.info("February RM: " + febRM);
		} else {
			LoggerUtil.info("February RM: Not Entered");
		}

		if (!marhsupprmval.isEmpty()) {
			BigDecimal marchRM = new BigDecimal(marhsupprmval);
			sum = sum.add(marchRM);
			count++;
			LoggerUtil.info("March RM: " + marchRM);
		} else {
			LoggerUtil.info("March RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q4 months.");
			Assert.fail("❌ No values found for Q4 RM months.");
		}

		BigDecimal q4AverageRM = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q4rmvalue.contains(".")) {
			String decimalPart = q4rmvalue.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q4 RM (Supplier) - UI Q4 RM value (" + q4rmvalue
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI value for Q4 RM (" + q4rmvalue + ") has more than 3 decimal digits.");
			}
		}

		BigDecimal q4RMFromUI = new BigDecimal(q4rmvalue).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Total Valid Entries for Q4 RM: " + count);
		LoggerUtil.info("Expected (UI) Q4 RM: " + q4RMFromUI);
		LoggerUtil.info("Calculated Q4 RM: " + q4AverageRM);

		if (!q4RMFromUI.equals(q4AverageRM)) {
			LoggerUtil
					.mismatch("Mismatch:  FAILED: Q4 RM (Supplier) - UI: " + q4RMFromUI + ", Expected: " + q4AverageRM);
		}

		softAssert.assertTrue(q4RMFromUI.compareTo(q4AverageRM) == 0,
				"Mismatch in Q4 RM: Expected " + q4RMFromUI + ", but Calculated " + q4AverageRM);

		softAssert.assertAll();
	}

	public static void calculateQ4ScrapAverage() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info("User Wants To Calculate Q4 average Scrap value");

		String janscrapsuppval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "Scrap"))
				.getAttribute("value").trim();

		String febscrapsuppval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "Scrap"))
				.getAttribute("value").trim();

		String marchscrapsuppval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "Scrap"))
				.getAttribute("value").trim();

		String q4ScrapValue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Q4", "Scrap"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!janscrapsuppval.isEmpty()) {
			BigDecimal janScrap = new BigDecimal(janscrapsuppval);
			sum = sum.add(janScrap);
			count++;
			LoggerUtil.info("January Scrap: " + janScrap);
		} else {
			LoggerUtil.info("January Scrap: Not Entered");
		}
		if (!febscrapsuppval.isEmpty()) {
			BigDecimal febScrap = new BigDecimal(febscrapsuppval);
			sum = sum.add(febScrap);
			count++;
			LoggerUtil.info("February Scrap: " + febScrap);
		} else {
			LoggerUtil.info("February Scrap: Not Entered");
		}
		if (!marchscrapsuppval.isEmpty()) {
			BigDecimal marchScrap = new BigDecimal(marchscrapsuppval);
			sum = sum.add(marchScrap);
			count++;
			LoggerUtil.info("March Scrap: " + marchScrap);
		} else {
			LoggerUtil.info("March Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.info(" No Scrap values entered for Q4 months.");
			Assert.fail(" No values found for Q4 Scrap months.");
		}

		BigDecimal q4ScrapAverage = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q4ScrapValue.contains(".")) {
			String decimalPart = q4ScrapValue.split("\\.")[1];
			if (decimalPart.length() > 3) {
				softAssert.fail("UI value for Q4 Scrap (" + q4ScrapValue + ") has more than 3 decimal digits.");
			}
		}

		BigDecimal q4ScrapFromUI = new BigDecimal(q4ScrapValue).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Total Valid Entries for Q4 Scrap: " + count);
		LoggerUtil.info("Expected (UI) Q4 Scrap: " + q4ScrapFromUI);
		LoggerUtil.info("Calculated Q4 Scrap: " + q4ScrapAverage);

		softAssert.assertTrue(q4ScrapFromUI.compareTo(q4ScrapAverage) == 0,
				"Mismatch in Q4 Scrap: Expected " + q4ScrapFromUI + ", but Calculated " + q4ScrapAverage);

		softAssert.assertAll();
	}

	public static final By hy1suppallocationRm = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[35]/input");
	public static final By hy1suppallocationscrap = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[36]/input");
	public static final By hy2suppallocationonrm = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[37]/input");
	public static final By hy2suppallocationonscrap = By.xpath("//*[@id='DeltaTableBody']/tr[1]/td[38]/input");

	public static void calculateFirstHalfYearOnRmAndScrapForRm() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info(" Starting HY1 RM average calculation for Supplier (April to September)");

		String supprmarilvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "RM"))
				.getAttribute("value").trim();

		String supprmmayvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "RM"))
				.getAttribute("value").trim();

		String supprmjunevalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "RM"))
				.getAttribute("value").trim();

		String supprmjulyvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "RM"))
				.getAttribute("value").trim();

		String supprmaugustvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "RM"))
				.getAttribute("value").trim();

		String supprmsepvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "RM"))
				.getAttribute("value").trim();

		String hy1rmvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "H1", "RM"))
				.getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!supprmarilvalue.isEmpty()) {
			BigDecimal april = new BigDecimal(supprmarilvalue);
			sum = sum.add(april);
			count++;
			LoggerUtil.info("April RM: " + april);
		} else {
			LoggerUtil.info("April RM: Not Entered");
		}

		if (!supprmmayvalue.isEmpty()) {
			BigDecimal may = new BigDecimal(supprmmayvalue);
			sum = sum.add(may);
			count++;
			LoggerUtil.info("May RM: " + may);
		} else {
			LoggerUtil.info("May RM: Not Entered");
		}

		if (!supprmjunevalue.isEmpty()) {
			BigDecimal june = new BigDecimal(supprmjunevalue);
			sum = sum.add(june);
			count++;
			LoggerUtil.info("June RM: " + june);
		} else {
			LoggerUtil.info("June RM: Not Entered");
		}

		if (!supprmjulyvalue.isEmpty()) {
			BigDecimal july = new BigDecimal(supprmjulyvalue);
			sum = sum.add(july);
			count++;
			LoggerUtil.info("July RM: " + july);
		} else {
			LoggerUtil.info("July RM: Not Entered");
		}

		if (!supprmaugustvalue.isEmpty()) {
			BigDecimal august = new BigDecimal(supprmaugustvalue);
			sum = sum.add(august);
			count++;
			LoggerUtil.info("August RM: " + august);
		} else {
			LoggerUtil.info("August RM: Not Entered");
		}

		if (!supprmsepvalue.isEmpty()) {
			BigDecimal september = new BigDecimal(supprmsepvalue);
			sum = sum.add(september);
			count++;
			LoggerUtil.info("September RM: " + september);
		} else {
			LoggerUtil.info("September RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch:  No RM values entered for first half-year months.");
			Assert.fail(" No values found for first half-year RM months.");
		}

		BigDecimal hy1Average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (hy1rmvalue.contains(".")) {
			String decimalPart = hy1rmvalue.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch:  FAILED: HY1 RM (Supplier) - UI HY1 RM value (" + hy1rmvalue
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI HY1 RM value (" + hy1rmvalue + ") has more than 3 decimal digits.");
			}
		}

		BigDecimal hy1RmFromUI = new BigDecimal(hy1rmvalue).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Total Valid Entries for HY1 RM: " + count);
		LoggerUtil.info("Expected (UI) HY1 RM: " + hy1RmFromUI);
		LoggerUtil.info("Calculated HY1 RM: " + hy1Average);

		if (!hy1RmFromUI.equals(hy1Average)) {
			LoggerUtil.mismatch(
					"Mismatch:  FAILED: HY1 RM (Supplier) - UI: " + hy1RmFromUI + ", Expected: " + hy1Average);
		}

		softAssert.assertTrue(hy1RmFromUI.compareTo(hy1Average) == 0,
				"Mismatch in HY1 RM: Expected " + hy1RmFromUI + ", but Calculated " + hy1Average);

		LoggerUtil.pass(" HY1 RM (Supplier) calculation passed.");
		softAssert.assertAll();
	}

	public static void calculateFirstHalfYearOnScrapForScrap() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info(" Starting HY1 Scrap average calculation for Supplier (April to September)");

		String suppscrapaprilval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Apr", "Scrap"))
				.getAttribute("value").trim();

		String suppscrapmayval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "May", "Scrap"))
				.getAttribute("value").trim();

		String suppjunescrapval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jun", "Scrap"))
				.getAttribute("value").trim();

		String suppjulyscrapval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jul", "Scrap"))
				.getAttribute("value").trim();

		String suppaugscrapval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Aug", "Scrap"))
				.getAttribute("value").trim();

		String suppsepscrapval = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Sep", "Scrap"))
				.getAttribute("value").trim();

		String hy1scrapval = waitForExpectedElement(hy1suppallocationscrap).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!suppscrapaprilval.isEmpty()) {
			BigDecimal april = new BigDecimal(suppscrapaprilval);
			sum = sum.add(april);
			count++;
			LoggerUtil.info("April Scrap: " + april);
		} else {
			LoggerUtil.info("April Scrap: Not Entered");
		}

		if (!suppscrapmayval.isEmpty()) {
			BigDecimal may = new BigDecimal(suppscrapmayval);
			sum = sum.add(may);
			count++;
			LoggerUtil.info("May Scrap: " + may);
		} else {
			LoggerUtil.info("May Scrap: Not Entered");
		}

		if (!suppjunescrapval.isEmpty()) {
			BigDecimal june = new BigDecimal(suppjunescrapval);
			sum = sum.add(june);
			count++;
			LoggerUtil.info("June Scrap: " + june);
		} else {
			LoggerUtil.info("June Scrap: Not Entered");
		}

		if (!suppjulyscrapval.isEmpty()) {
			BigDecimal july = new BigDecimal(suppjulyscrapval);
			sum = sum.add(july);
			count++;
			LoggerUtil.info("July Scrap: " + july);
		} else {
			LoggerUtil.info("July Scrap: Not Entered");
		}

		if (!suppaugscrapval.isEmpty()) {
			BigDecimal august = new BigDecimal(suppaugscrapval);
			sum = sum.add(august);
			count++;
			LoggerUtil.info("August Scrap: " + august);
		} else {
			LoggerUtil.info("August Scrap: Not Entered");
		}

		if (!suppsepscrapval.isEmpty()) {
			BigDecimal september = new BigDecimal(suppsepscrapval);
			sum = sum.add(september);
			count++;
			LoggerUtil.info("September Scrap: " + september);
		} else {
			LoggerUtil.info("September Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for first half-year months.");
			Assert.fail("❌ No values found for first half-year Scrap months.");
		}

		BigDecimal hy1Average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (hy1scrapval.contains(".")) {
			String decimalPart = hy1scrapval.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ FAILED: HY1 Scrap (Supplier) - UI HY1 Scrap value (" + hy1scrapval
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI HY1 Scrap value (" + hy1scrapval + ") has more than 3 decimal digits.");
			}
		}

		BigDecimal hy1ScrapFromUI = new BigDecimal(hy1scrapval).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Total Valid Entries for HY1 Scrap: " + count);
		LoggerUtil.info("Expected (UI) HY1 Scrap: " + hy1ScrapFromUI);
		LoggerUtil.info("Calculated HY1 Scrap: " + hy1Average);

		if (!hy1ScrapFromUI.equals(hy1Average)) {
			LoggerUtil.mismatch(
					"Mismatch:  FAILED: HY1 Scrap (Supplier) - UI: " + hy1ScrapFromUI + ", Expected: " + hy1Average);
		}

		softAssert.assertTrue(hy1ScrapFromUI.compareTo(hy1Average) == 0,
				"Mismatch in HY1 Scrap: Expected " + hy1ScrapFromUI + ", but Calculated " + hy1Average);

		LoggerUtil.pass(" HY1 Scrap (Supplier) calculation passed.");
		softAssert.assertAll();
	}

	public static void verifySecondHalfYearlyAverageForRm() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info(" Starting HY2 RM average calculation for Supplier (October to March)");

		String octoberrmsuppvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "RM"))
				.getAttribute("value").trim();

		String novemberrmsuppvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "RM"))
				.getAttribute("value").trim();

		String decemberrmsuppvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "RM"))
				.getAttribute("value").trim();

		String janrmsuppvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "RM"))
				.getAttribute("value").trim();

		String febrmsuppvlaue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "RM"))
				.getAttribute("value").trim();

		String marchrmsuppvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "RM"))
				.getAttribute("value").trim();

		String hy2rmyear = waitForExpectedElement(hy2suppallocationonrm).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberrmsuppvalue.isEmpty()) {
			BigDecimal oct = new BigDecimal(octoberrmsuppvalue);
			sum = sum.add(oct);
			count++;
			LoggerUtil.info("October RM: " + oct);
		} else {
			LoggerUtil.info("October RM: Not Entered");
		}

		if (!novemberrmsuppvalue.isEmpty()) {
			BigDecimal nov = new BigDecimal(novemberrmsuppvalue);
			sum = sum.add(nov);
			count++;
			LoggerUtil.info("November RM: " + nov);
		} else {
			LoggerUtil.info("November RM: Not Entered");
		}

		if (!decemberrmsuppvalue.isEmpty()) {
			BigDecimal dec = new BigDecimal(decemberrmsuppvalue);
			sum = sum.add(dec);
			count++;
			LoggerUtil.info("December RM: " + dec);
		} else {
			LoggerUtil.info("December RM: Not Entered");
		}

		if (!janrmsuppvalue.isEmpty()) {
			BigDecimal jan = new BigDecimal(janrmsuppvalue);
			sum = sum.add(jan);
			count++;
			LoggerUtil.info("January RM: " + jan);
		} else {
			LoggerUtil.info("January RM: Not Entered");
		}

		if (!febrmsuppvlaue.isEmpty()) {
			BigDecimal feb = new BigDecimal(febrmsuppvlaue);
			sum = sum.add(feb);
			count++;
			LoggerUtil.info("February RM: " + feb);
		} else {
			LoggerUtil.info("February RM: Not Entered");
		}

		if (!marchrmsuppvalue.isEmpty()) {
			BigDecimal mar = new BigDecimal(marchrmsuppvalue);
			sum = sum.add(mar);
			count++;
			LoggerUtil.info("March RM: " + mar);
		} else {
			LoggerUtil.info("March RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for second half-year months.");
			Assert.fail("❌ No values found for second half-year RM months.");
		}

		BigDecimal hy2Average = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (hy2rmyear.contains(".")) {
			String decimalPart = hy2rmyear.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ FAILED: HY2 RM (Supplier) - UI HY2 RM value (" + hy2rmyear
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI HY2 RM value (" + hy2rmyear + ") has more than 3 decimal digits.");
			}
		}

		BigDecimal hy2RmFromUI = new BigDecimal(hy2rmyear).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Total Valid Entries for HY2 RM: " + count);
		LoggerUtil.info("Expected (UI) HY2 RM: " + hy2RmFromUI);
		LoggerUtil.info("Calculated HY2 RM: " + hy2Average);

		if (!hy2RmFromUI.equals(hy2Average)) {
			LoggerUtil.mismatch(
					"Mismatch: ❌ FAILED: HY2 RM (Supplier) - UI: " + hy2RmFromUI + ", Expected: " + hy2Average);
		}

		softAssert.assertTrue(hy2RmFromUI.compareTo(hy2Average) == 0,
				"Mismatch in HY2 RM: Expected " + hy2RmFromUI + ", but Calculated " + hy2Average);

		LoggerUtil.pass(" HY2 RM (Supplier) calculation passed.");
		softAssert.assertAll();
	}

	public static void verifySecondHalfYearlyAverageForScrap() {
		SoftAssert softAssert = new SoftAssert();

		LoggerUtil.info(" Starting HY2 Scrap average calculation for Supplier (October to March)");

		try {
			LoggerUtil.info("STEP 7: Scroll window by 130px.");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 450);");
			Thread.sleep(2000);
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Scroll failed → " + e.getMessage());
		}

		String octoberscrapsuppvalue = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Oct", "Scrap"))
				.getAttribute("value").trim();

		String novemberscrapvaluesupp = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Nov", "Scrap"))
				.getAttribute("value").trim();

		String decemberscrapvaluesupp = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Dec", "Scrap"))
				.getAttribute("value").trim();

		String januaryscrapvaluesupp = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Jan", "Scrap"))
				.getAttribute("value").trim();

		String febscrapvaluesupp = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Feb", "Scrap"))
				.getAttribute("value").trim();

		String marchscrapvaluesupp = waitForExpectedElement(getDynamicSupplierDeltaLocator("manual", "Mar", "Scrap"))
				.getAttribute("value").trim();

		String hy2yearscrap = waitForExpectedElement(hy2suppallocationonscrap).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberscrapsuppvalue.isEmpty()) {
			BigDecimal oct = new BigDecimal(octoberscrapsuppvalue);
			sum = sum.add(oct);
			count++;
			LoggerUtil.info("October Scrap: " + oct);
		} else {
			LoggerUtil.info("October Scrap: Not Entered");
		}

		if (!novemberscrapvaluesupp.isEmpty()) {
			BigDecimal nov = new BigDecimal(novemberscrapvaluesupp);
			sum = sum.add(nov);
			count++;
			LoggerUtil.info("November Scrap: " + nov);
		} else {
			LoggerUtil.info("November Scrap: Not Entered");
		}

		if (!decemberscrapvaluesupp.isEmpty()) {
			BigDecimal dec = new BigDecimal(decemberscrapvaluesupp);
			sum = sum.add(dec);
			count++;
			LoggerUtil.info("December Scrap: " + dec);
		} else {
			LoggerUtil.info("December Scrap: Not Entered");
		}

		if (!januaryscrapvaluesupp.isEmpty()) {
			BigDecimal jan = new BigDecimal(januaryscrapvaluesupp);
			sum = sum.add(jan);
			count++;
			LoggerUtil.info("January Scrap: " + jan);
		} else {
			LoggerUtil.info("January Scrap: Not Entered");
		}

		if (!febscrapvaluesupp.isEmpty()) {
			BigDecimal feb = new BigDecimal(febscrapvaluesupp);
			sum = sum.add(feb);
			count++;
			LoggerUtil.info("February Scrap: " + feb);
		} else {
			LoggerUtil.info("February Scrap: Not Entered");
		}

		if (!marchscrapvaluesupp.isEmpty()) {
			BigDecimal mar = new BigDecimal(marchscrapvaluesupp);
			sum = sum.add(mar);
			count++;
			LoggerUtil.info("March Scrap: " + mar);
		} else {
			LoggerUtil.info("March Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for second half-year months.");
			Assert.fail("❌ No values found for second half-year Scrap months.");
		}

		BigDecimal hy2ScrapAverage = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (hy2yearscrap.contains(".")) {
			String decimalPart = hy2yearscrap.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch("Mismatch: ❌ FAILED: HY2 Scrap (Supplier) - UI HY2 Scrap value (" + hy2yearscrap
						+ ") has more than 3 decimal digits.");
				softAssert.fail("UI HY2 Scrap value (" + hy2yearscrap + ") has more than 3 decimal digits.");
			}
		}

		BigDecimal hy2ScrapFromUI = new BigDecimal(hy2yearscrap).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Total Valid Entries for HY2 Scrap: " + count);
		LoggerUtil.info("Expected (UI) HY2 Scrap: " + hy2ScrapFromUI);
		LoggerUtil.info("Calculated HY2 Scrap: " + hy2ScrapAverage);

		if (!hy2ScrapFromUI.equals(hy2ScrapAverage)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: HY2 Scrap (Supplier) - UI: " + hy2ScrapFromUI + ", Expected: "
					+ hy2ScrapAverage);
		}

		softAssert.assertTrue(hy2ScrapFromUI.compareTo(hy2ScrapAverage) == 0,
				"Mismatch in HY2 Scrap: Expected " + hy2ScrapFromUI + ", but Calculated " + hy2ScrapAverage);

		LoggerUtil.pass(" HY2 Scrap (Supplier) calculation passed.");
		softAssert.assertAll();
	}

	public static final By clickcustomerspecificdektadropdown = By
			.xpath("//select[@id='CustomerSpecificDelta']/following-sibling::div/button");
	public static final By clickselectallcheckboxforcustomerallocation = By
			.xpath("(//button[@class='dropdown-item multiselect-all'])[2]/span/input[@type='checkbox']");
	public static final By fetchingCustomerRows = By.xpath("//table[@id='rmCustomer']/tbody/tr");
	public static final By enterCustomerName = By.xpath("//input[@id='myInputCustomer']");

	public static final By EnterCustomerDeltaName = By.xpath("//select[@id='CustomerSpecificDelta']/following-sibling::div//input[@type='search']");
	public static final By CustomerDeltaLabelName = By.xpath("//select[@id='CustomerSpecificDelta']/following-sibling::div/descendant::button//label");
	
	public static void enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(String enteraprilrm,
			String enteraprilscrap, String entermayrm, String entermayscrap, String enterjunerm, String enterjunescrap,
			String enterjulyrm, String enterjulyscrap, String enteraugustrm, String enteraugscrap, String enterseptemrm,
			String entersepscrap, String enetroctrm, String enteroctscrap, String enternovrm, String enternovscrap,
			String enterdecrm, String enterdecscrap, String enetrjanram, String enterjanscrap, String enterfebrm,
			String enterfebscrap, String entermarchrm, String entermarchscrap) throws InterruptedException {
 
		LoggerUtil.info("===== Starting RM & Scrap Entry for Customer Allocation (Dynamic) =====");
 
		String custumerName = "rishicustomer-0004";
		// 🔹 April → March Dynamic Loop
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };
		String[] rmValues = { enteraprilrm, entermayrm, enterjunerm, enterjulyrm, enteraugustrm, enterseptemrm,
				enetroctrm, enternovrm, enterdecrm, enetrjanram, enterfebrm, entermarchrm };
		String[] scrapValues = { enteraprilscrap, entermayscrap, enterjunescrap, enterjulyscrap, enteraugscrap,
				entersepscrap, enteroctscrap, enternovscrap, enterdecscrap, enterjanscrap, enterfebscrap,
				entermarchscrap };
 
		for (int i = 0; i < months.length; i++) {
			try {
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
				LoggerUtil.info(months[i] + " → RM: " + rmValues[i] + ", Scrap: " + scrapValues[i]);
			} catch (Exception e) {
				LoggerUtil.error("❌ Error entering values for " + months[i] + " → " + e.getMessage());
			}
		}
 
		LoggerUtil.pass("✅ All RM & Scrap values entered successfully for April → March.");
 
		// 🔹 Business Segment Selection
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
 
		// 🔹 Customer Search & Checkbox Selection
		clearAndEnterText(waitForExpectedElement(enterCustomerName), custumerName);
		Thread.sleep(1000);
 
		List<WebElement> ListRows = driver.findElements(fetchingCustomerRows);
		boolean customerFound = false;
 
		for (int i = 0; i < ListRows.size(); i++) {
 
		    WebElement row = ListRows.get(i);
		    String styleValue = row.getAttribute("style").trim();
 
		    if (!styleValue.equals("height: 21px; display: none;")) {
 
		        WebElement checkbox = row.findElement(By.xpath(".//td/div/label/input"));
 
		        // SCROLL + WAIT + SAFE CLICK
		        safeClick(checkbox);
 
		        LoggerUtil.info("Clicked customer checkbox at row " + (i + 1));
		        customerFound = true;
		        break;
		    }
		}
 
		if (!customerFound) {
		    LoggerUtil.error("Customer "+custumerName + " not found or checkbox not visible.");
		}
 
		scrollToElement(waitForExpectedElement(clickcustomerspecificdektadropdown));
 
		// 🔹 Customer Delta Allocation
		Thread.sleep(3000);
		clickOnElement(clickcustomerspecificdektadropdown);

		clearAndEnterText(waitForExpectedElement(EnterCustomerDeltaName), custumerName);

		// SAFE WAIT — do not use presenceOfAllElementsLocatedBy
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(driver -> driver.findElements(CustomerDeltaLabelName).size() > 0);

		List<WebElement> custDeltaName = driver.findElements(CustomerDeltaLabelName);

		boolean found = false;

		for (WebElement customer : custDeltaName) {

		    String custnameText = customer.getText().trim();

		    if (custnameText.equalsIgnoreCase(custumerName)) {

		        WebElement checkbox = customer.findElement(
		            By.xpath(".//preceding-sibling::input | .//input[@type='checkbox']")
		        );

		        ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].click();", checkbox);

		        LoggerUtil.pass("Customer checkbox selected successfully → " + custnameText);
		        found = true;
		        break;
		    }
		}

		if (!found) {
		    LoggerUtil.fail("Customer not found after search → " + custumerName);
		}

		
		
 
		LoggerUtil.info("===== End of Customer Allocation (Dynamic) =====");
	}
	public static void safeClick(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }
	}
 
	public static By getDynamicCustomerDeltaLocator(String month, String type) {

	    try {
	        if (month == null || month.length() < 3) {
	            throw new IllegalArgumentException("Invalid month: " + month);
	        }

	        String normalizedMonth =
	                month.substring(0, 1).toLowerCase() +
	                month.substring(1, 3).toLowerCase();

	        String dataValue = type.equalsIgnoreCase("Scrap")
	                ? normalizedMonth + "Scrap"
	                : normalizedMonth;

	        String xpath = String.format(
	            "//*[@id='DeltaTableBodyCustomer']//tr[contains(@class,'MannualDeltaCustomer')]//input[@data-rm='%s']",
	            dataValue
	        );

	        return By.xpath(xpath);

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Invalid month/type input for Customer Delta locator → " + e.getMessage());
	        throw e;
	    }
	}



	public static void verifyingcalculationofcustomerallocation(String Custoaprilrm, String CutoScrap, String mayrmsupp,
			String mayscrapsupp, String junesupprm, String junesuppscrap, String julysupprm, String julusuppscrap,
			String augustsupprm, String augussuppscrap, String seprmsupp, String sepscrapsup, String octormsupp,
			String octscrapsup, String novrmsup, String novscrapsup, String decemberrmsup, String decscrapsup,
			String jansupprm, String janscrapsup, String febsupprm, String febscrapsup, String rmMarchsupp,
			String scrapmarchsupp, String searchval) throws InterruptedException {

		LoggerUtil.info("===== Starting Customer Allocation Entry (Dynamic) =====");

		// April
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Apr", "RM")), Custoaprilrm);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Apr", "Scrap")), CutoScrap);

		// May
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("May", "RM")), mayrmsupp);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("May", "Scrap")), mayscrapsupp);

		// June
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Jun", "RM")), junesupprm);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Jun", "Scrap")), junesuppscrap);

		// July
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Jul", "RM")), julysupprm);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Jul", "Scrap")), julusuppscrap);

		// August
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Aug", "RM")), augustsupprm);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Aug", "Scrap")), augussuppscrap);

		// September
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Sep", "RM")), seprmsupp);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Sep", "Scrap")), sepscrapsup);

		// October
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Oct", "RM")), octormsupp);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Oct", "Scrap")), octscrapsup);

		// November
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Nov", "RM")), novrmsup);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Nov", "Scrap")), novscrapsup);

		// December
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Dec", "RM")), decemberrmsup);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Dec", "Scrap")), decscrapsup);

		// January
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Jan", "RM")), jansupprm);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Jan", "Scrap")), janscrapsup);

		// February
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Feb", "RM")), febsupprm);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Feb", "Scrap")), febscrapsup);

		// March
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Mar", "RM")), rmMarchsupp);
		clearAndEnterText(waitForExpectedElement(getDynamicCustomerDeltaLocator("Mar", "Scrap")), scrapmarchsupp);

		LoggerUtil.pass("✅ Customer Allocation values entered successfully for April → March.");

		// Save
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save button.");

		Thread.sleep(4000);
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked View button.");

		Thread.sleep(7000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchval);
		LoggerUtil.info("Searched for Commodity Group → " + searchval);

		Thread.sleep(4000);
		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		LoggerUtil.pass("✅ Opened edit mode for verification.");

		Thread.sleep(18000);
		LoggerUtil.info("===== End of Customer Allocation Entry (Dynamic) =====");
	}

	public static By getDynamicCustomerLandedLocator(String month, String type) {
		try {
			// normalize month name to first 3 lowercase letters
			String normalizedMonth = month.substring(0, 1).toLowerCase() + month.substring(1, 3).toLowerCase();

			// append 'Scrap' when needed
			String dataValue = type.equalsIgnoreCase("Scrap") ? normalizedMonth + "Scrap" : normalizedMonth;

			// dynamic XPath for FinalDelta (Landed Price) row
			String xpath = String.format(
					"//*[@id='DeltaTableBodyCustomer']//tr[contains(@class,'FinalDelta')]//input[@data-rm='%s']",
					dataValue);

			return By.xpath(xpath);

		} catch (Exception e) {
			LoggerUtil.error("❌ Invalid month/type in Customer Landed locator → " + e.getMessage());
			throw e;
		}
	}
	
	private static String getCustomerLandedValue(String month, String type) {

	    By locator = getDynamicCustomerFinalDeltaLocator(month, type);

	    List<WebElement> elements = driver.findElements(locator);

	    if (elements.isEmpty()) {
	        LoggerUtil.fail("Customer Specific Landed cost missing → " + month + " " + type);
	        Assert.fail("Customer landed cost not found → " + month + " " + type);
	        return "0";
	    }

	    return elements.get(0).getAttribute("value").trim();
	}

	private static By getDynamicCustomerFinalDeltaLocator(String month, String type) {

	    String monthKey = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();

	    String className;
	    if (type.equalsIgnoreCase("RM")) {
	        className = "LCdeltaRM" + monthKey + "Customer";
	    } else {
	        className = "LCdeltaScrap" + monthKey + "Customer";
	    }

	    String xpath = String.format(
	        "//*[@id='DeltaTableBodyCustomer']//tr[contains(@class,'FinalDelta')]//input[contains(@class,'%s')]",
	        className
	    );

	    return By.xpath(xpath);
	}

	private static String getCustomerDeltaValue(String month, String type) {

	    By locator = getDynamicCustomerDeltaLocator(month, type);

	    WebElement element = waitForExpectedElement(locator);
	    return element.getAttribute("value").trim();
	}

	
	private static String getFinalCustomerValue(String month, String type) {
	    return getFinalCustomerValue(month, type, true);
	}

	private static String getFinalCustomerValue(
	        String month, String type, boolean failIfMissing) {

	    By locator = getDynamicCustomerFinalDeltaLocator(month, type);

	    List<WebElement> elements = driver.findElements(locator);

	    if (elements.isEmpty()) {
	        LoggerUtil.fail("Final customer value not found → " + month + " " + type);
	        if (failIfMissing) {
	            Assert.fail("Final customer value missing → " + month + " " + type);
	        }
	        return null; // ❗ better than "0"
	    }

	    String value = elements.get(0).getAttribute("value");

	    if (value == null || value.trim().isEmpty()) {
	        LoggerUtil.fail("Final customer value empty → " + month + " " + type);
	        if (failIfMissing) {
	            Assert.fail("Final customer value empty → " + month + " " + type);
	        }
	        return null;
	    }

	    return value.trim();
	}

	public static void verifyCalculateLandedCostForCustomerAprilMonth() {

	    // -------- READ VALUES CORRECTLY --------

	    // Final landed values (read-only row)
	    String landedAprilRm = getFinalCustomerValue("Apr", "RM");
	    String landedAprilScrap = getFinalCustomerValue("Apr", "Scrap");

	    // Customer delta values (editable delta entry row)
	    String customerAprilRm = getCustomerDeltaValue("Apr", "RM");
	    String customerAprilScrap = getCustomerDeltaValue("Apr", "Scrap");

	    // Base values
	    String baseAprilRm = waitForExpectedElement(
	            getDynamicRMOrScrapLocator("Apr", "RM"))
	            .getAttribute("value").trim();

	    String baseAprilScrap = waitForExpectedElement(
	            getDynamicRMOrScrapLocator("Apr", "Scrap"))
	            .getAttribute("value").trim();

	    // -------- BigDecimal Conversion --------
	    BigDecimal baseRmApril = new BigDecimal(baseAprilRm);
	    BigDecimal custoRmApril = new BigDecimal(customerAprilRm);
	    BigDecimal baseScrapApril = new BigDecimal(baseAprilScrap);
	    BigDecimal custoScrapApril = new BigDecimal(customerAprilScrap);

	    BigDecimal uiLandedRmApril = new BigDecimal(landedAprilRm);
	    BigDecimal uiLandedScrapApril = new BigDecimal(landedAprilScrap);

	    BigDecimal expectedLandedRmApril =
	            baseRmApril.add(custoRmApril).setScale(3, RoundingMode.HALF_UP);

	    BigDecimal expectedLandedScrapApril =
	            baseScrapApril.add(custoScrapApril).setScale(3, RoundingMode.HALF_UP);

	    BigDecimal uiRoundedRmApril =
	            uiLandedRmApril.setScale(3, RoundingMode.HALF_UP);

	    BigDecimal uiRoundedScrapApril =
	            uiLandedScrapApril.setScale(3, RoundingMode.HALF_UP);

	    // -------- Logs --------
	    LoggerUtil.info("[April][Customer] Base RM: " + baseRmApril +
	            ", Customer Delta RM: " + custoRmApril);

	    LoggerUtil.info("[April][Customer] Base Scrap: " + baseScrapApril +
	            ", Customer Delta Scrap: " + custoScrapApril);

	    // -------- Assertions --------
	    if (!uiRoundedRmApril.equals(expectedLandedRmApril)) {
	        LoggerUtil.mismatch("FAILED: April RM Landed (Customer) UI=" +
	                uiRoundedRmApril + " Expected=" + expectedLandedRmApril);
	        Assert.fail("Mismatch in April RM Landed Cost (Customer)");
	    }

	    if (!uiRoundedScrapApril.equals(expectedLandedScrapApril)) {
	        LoggerUtil.mismatch("FAILED: April Scrap Landed (Customer) UI=" +
	                uiRoundedScrapApril + " Expected=" + expectedLandedScrapApril);
	        Assert.fail("Mismatch in April Scrap Landed Cost (Customer)");
	    }

	    LoggerUtil.pass("April RM/Scrap Landed Cost (Customer) passed.");
	}


	public static void calculatemayrmandscrapforcustomer() {

	    // 🔹 Landed (Customer Specific Landed cost row)
	    String landedValueMayRmStr = getFinalCustomerValue("May", "RM");
	    String landedValueMayScrapStr = getFinalCustomerValue("May", "Scrap");

	    // 🔹 Customer Delta (Delta Entry row)
	    String customerMayRmStr = getCustomerDeltaValue("May", "RM");
	    String customerMayScrapStr = getCustomerDeltaValue("May", "Scrap");

	    // 🔹 Base (Main Monthly Inputs)
	    String baseMayRmStr = waitForExpectedElement(
	            getDynamicRMOrScrapLocator("May", "RM"))
	            .getAttribute("value").trim();

	    String baseMayScrapStr = waitForExpectedElement(
	            getDynamicRMOrScrapLocator("May", "Scrap"))
	            .getAttribute("value").trim();

	    // 🔹 BigDecimal conversion
	    BigDecimal baseRmMay = new BigDecimal(baseMayRmStr);
	    BigDecimal custoRmMay = new BigDecimal(customerMayRmStr);
	    BigDecimal baseScrapMay = new BigDecimal(baseMayScrapStr);
	    BigDecimal custoScrapMay = new BigDecimal(customerMayScrapStr);
	    BigDecimal uiLandedRmMay = new BigDecimal(landedValueMayRmStr);
	    BigDecimal uiLandedScrapMay = new BigDecimal(landedValueMayScrapStr);

	    BigDecimal expectedLandedRmMay =
	            baseRmMay.add(custoRmMay).setScale(3, RoundingMode.HALF_UP);

	    BigDecimal expectedLandedScrapMay =
	            baseScrapMay.add(custoScrapMay).setScale(3, RoundingMode.HALF_UP);

	    BigDecimal uiRoundedRmMay =
	            uiLandedRmMay.setScale(3, RoundingMode.HALF_UP);

	    BigDecimal uiRoundedScrapMay =
	            uiLandedScrapMay.setScale(3, RoundingMode.HALF_UP);

	    // 🔹 Logs
	    LoggerUtil.info("[May][Customer] Base RM: " + baseRmMay +
	            ", Customer Delta RM: " + custoRmMay);

	    LoggerUtil.info("[May][Customer] Base Scrap: " + baseScrapMay +
	            ", Customer Delta Scrap: " + custoScrapMay);

	    // 🔹 Decimal validation (max 3)
	    if (landedValueMayRmStr.contains(".")) {
	        if (landedValueMayRmStr.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch("FAILED: May RM Landed (Customer) has more than 3 decimals → "
	                    + landedValueMayRmStr);
	            Assert.fail("May RM Landed decimal precision error");
	        }
	    }

	    if (landedValueMayScrapStr.contains(".")) {
	        if (landedValueMayScrapStr.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch("FAILED: May Scrap Landed (Customer) has more than 3 decimals → "
	                    + landedValueMayScrapStr);
	            Assert.fail("May Scrap Landed decimal precision error");
	        }
	    }

	    // 🔹 Assertions
	    if (!uiRoundedRmMay.equals(expectedLandedRmMay)) {
	        LoggerUtil.mismatch("FAILED: May RM Landed (Customer) UI=" +
	                uiRoundedRmMay + " Expected=" + expectedLandedRmMay);
	        Assert.fail("Mismatch in May RM Landed Cost (Customer)");
	    }

	    if (!uiRoundedScrapMay.equals(expectedLandedScrapMay)) {
	        LoggerUtil.mismatch("FAILED: May Scrap Landed (Customer) UI=" +
	                uiRoundedScrapMay + " Expected=" + expectedLandedScrapMay);
	        Assert.fail("Mismatch in May Scrap Landed Cost (Customer)");
	    }

	    LoggerUtil.pass("May RM/Scrap Landed Cost (Customer) passed.");
	}

	public static void calculatejunermandscrapforcustomer() {

	    // 🔹 Landed (Customer Specific Landed cost row)
	    String landedValueJuneRmStr = getFinalCustomerValue("Jun", "RM");
	    String landedValueJuneScrapStr = getFinalCustomerValue("Jun", "Scrap");

	    // 🔹 Customer Delta (Delta Entry row)
	    String customerJuneRmStr = getCustomerDeltaValue("Jun", "RM");
	    String customerJuneScrapStr = getCustomerDeltaValue("Jun", "Scrap");

	    // 🔹 Base (Main Monthly Inputs)
	    String baseJuneRmStr = waitForExpectedElement(
	            getDynamicRMOrScrapLocator("Jun", "RM"))
	            .getAttribute("value").trim();

	    String baseJuneScrapStr = waitForExpectedElement(
	            getDynamicRMOrScrapLocator("Jun", "Scrap"))
	            .getAttribute("value").trim();

	    // 🔹 BigDecimal conversion
	    BigDecimal baseRmJune = new BigDecimal(baseJuneRmStr);
	    BigDecimal custoRmJune = new BigDecimal(customerJuneRmStr);
	    BigDecimal baseScrapJune = new BigDecimal(baseJuneScrapStr);
	    BigDecimal custoScrapJune = new BigDecimal(customerJuneScrapStr);
	    BigDecimal uiLandedRmJune = new BigDecimal(landedValueJuneRmStr);
	    BigDecimal uiLandedScrapJune = new BigDecimal(landedValueJuneScrapStr);

	    BigDecimal expectedLandedRmJune =
	            baseRmJune.add(custoRmJune).setScale(3, RoundingMode.HALF_UP);

	    BigDecimal expectedLandedScrapJune =
	            baseScrapJune.add(custoScrapJune).setScale(3, RoundingMode.HALF_UP);

	    BigDecimal uiRoundedRmJune =
	            uiLandedRmJune.setScale(3, RoundingMode.HALF_UP);

	    BigDecimal uiRoundedScrapJune =
	            uiLandedScrapJune.setScale(3, RoundingMode.HALF_UP);

	    // 🔹 Logs
	    LoggerUtil.info("[June][Customer] Base RM: " + baseRmJune +
	            ", Customer Delta RM: " + custoRmJune);

	    LoggerUtil.info("[June][Customer] Base Scrap: " + baseScrapJune +
	            ", Customer Delta Scrap: " + custoScrapJune);

	    // 🔹 Decimal validation (max 3)
	    if (landedValueJuneRmStr.contains(".")) {
	        if (landedValueJuneRmStr.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch("FAILED: June RM Landed (Customer) has more than 3 decimals → "
	                    + landedValueJuneRmStr);
	            Assert.fail("June RM Landed decimal precision error");
	        }
	    }

	    if (landedValueJuneScrapStr.contains(".")) {
	        if (landedValueJuneScrapStr.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch("FAILED: June Scrap Landed (Customer) has more than 3 decimals → "
	                    + landedValueJuneScrapStr);
	            Assert.fail("June Scrap Landed decimal precision error");
	        }
	    }

	    // 🔹 Assertions
	    if (!uiRoundedRmJune.equals(expectedLandedRmJune)) {
	        LoggerUtil.mismatch("FAILED: June RM Landed (Customer) UI=" +
	                uiRoundedRmJune + " Expected=" + expectedLandedRmJune);
	        Assert.fail("Mismatch in June RM Landed Cost (Customer)");
	    }

	    if (!uiRoundedScrapJune.equals(expectedLandedScrapJune)) {
	        LoggerUtil.mismatch("FAILED: June Scrap Landed (Customer) UI=" +
	                uiRoundedScrapJune + " Expected=" + expectedLandedScrapJune);
	        Assert.fail("Mismatch in June Scrap Landed Cost (Customer)");
	    }

	    LoggerUtil.pass("June RM/Scrap Landed Cost (Customer) passed.");
	}


	public static void calculatejulyrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueJulyRmStr = getFinalCustomerValue("Jul", "RM");
	        String landedValueJulyScrapStr = getFinalCustomerValue("Jul", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerJulyRmStr = getCustomerDeltaValue("Jul", "RM");
	        String customerJulyScrapStr = getCustomerDeltaValue("Jul", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseJulyRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Jul", "RM"))
	                .getAttribute("value").trim();

	        String baseJulyScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Jul", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmJuly = new BigDecimal(baseJulyRmStr);
	        BigDecimal custoRmJuly = new BigDecimal(customerJulyRmStr);
	        BigDecimal baseScrapJuly = new BigDecimal(baseJulyScrapStr);
	        BigDecimal custoScrapJuly = new BigDecimal(customerJulyScrapStr);
	        BigDecimal uiLandedRmJuly = new BigDecimal(landedValueJulyRmStr);
	        BigDecimal uiLandedScrapJuly = new BigDecimal(landedValueJulyScrapStr);

	        BigDecimal expectedLandedRmJuly =
	                baseRmJuly.add(custoRmJuly).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapJuly =
	                baseScrapJuly.add(custoScrapJuly).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmJuly =
	                uiLandedRmJuly.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapJuly =
	                uiLandedScrapJuly.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[July][Customer] Base RM: " + baseRmJuly +
	                ", Customer Delta RM: " + custoRmJuly);

	        LoggerUtil.info("[July][Customer] Base Scrap: " + baseScrapJuly +
	                ", Customer Delta Scrap: " + custoScrapJuly);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueJulyRmStr.contains(".") &&
	                landedValueJulyRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: July RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueJulyRmStr);
	            return;
	        }

	        if (landedValueJulyScrapStr.contains(".") &&
	                landedValueJulyScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: July Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueJulyScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmJuly.equals(expectedLandedRmJuly)) {
	            LoggerUtil.mismatch(
	                    "FAILED: July RM Landed (Customer) | UI = " + uiRoundedRmJuly
	                            + " | Expected = " + expectedLandedRmJuly);
	            return;
	        }

	        if (!uiRoundedScrapJuly.equals(expectedLandedScrapJuly)) {
	            LoggerUtil.mismatch(
	                    "FAILED: July Scrap Landed (Customer) | UI = " + uiRoundedScrapJuly
	                            + " | Expected = " + expectedLandedScrapJuly);
	            return;
	        }

	        LoggerUtil.pass("July RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in July Customer Landed calculation → " + e.getMessage());
	    }
	}


	

	public static void calculateaugustrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueAugustRmStr = getFinalCustomerValue("Aug", "RM");
	        String landedValueAugustScrapStr = getFinalCustomerValue("Aug", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerAugustRmStr = getCustomerDeltaValue("Aug", "RM");
	        String customerAugustScrapStr = getCustomerDeltaValue("Aug", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseAugustRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Aug", "RM"))
	                .getAttribute("value").trim();

	        String baseAugustScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Aug", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmAugust = new BigDecimal(baseAugustRmStr);
	        BigDecimal custoRmAugust = new BigDecimal(customerAugustRmStr);
	        BigDecimal baseScrapAugust = new BigDecimal(baseAugustScrapStr);
	        BigDecimal custoScrapAugust = new BigDecimal(customerAugustScrapStr);
	        BigDecimal uiLandedRmAugust = new BigDecimal(landedValueAugustRmStr);
	        BigDecimal uiLandedScrapAugust = new BigDecimal(landedValueAugustScrapStr);

	        BigDecimal expectedLandedRmAugust =
	                baseRmAugust.add(custoRmAugust).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapAugust =
	                baseScrapAugust.add(custoScrapAugust).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmAugust =
	                uiLandedRmAugust.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapAugust =
	                uiLandedScrapAugust.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[August][Customer] Base RM: " + baseRmAugust +
	                ", Customer Delta RM: " + custoRmAugust);

	        LoggerUtil.info("[August][Customer] Base Scrap: " + baseScrapAugust +
	                ", Customer Delta Scrap: " + custoScrapAugust);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueAugustRmStr.contains(".") &&
	                landedValueAugustRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: August RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueAugustRmStr);
	            return;
	        }

	        if (landedValueAugustScrapStr.contains(".") &&
	                landedValueAugustScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: August Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueAugustScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmAugust.equals(expectedLandedRmAugust)) {
	            LoggerUtil.mismatch(
	                    "FAILED: August RM Landed (Customer) | UI = " + uiRoundedRmAugust
	                            + " | Expected = " + expectedLandedRmAugust);
	            return;
	        }

	        if (!uiRoundedScrapAugust.equals(expectedLandedScrapAugust)) {
	            LoggerUtil.mismatch(
	                    "FAILED: August Scrap Landed (Customer) | UI = " + uiRoundedScrapAugust
	                            + " | Expected = " + expectedLandedScrapAugust);
	            return;
	        }

	        LoggerUtil.pass("August RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in August Customer Landed calculation → " + e.getMessage());
	    }
	}


	public static void calculateseptemberrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueSeptemberRmStr = getFinalCustomerValue("Sep", "RM");
	        String landedValueSeptemberScrapStr = getFinalCustomerValue("Sep", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerSeptemberRmStr = getCustomerDeltaValue("Sep", "RM");
	        String customerSeptemberScrapStr = getCustomerDeltaValue("Sep", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseSeptemberRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Sep", "RM"))
	                .getAttribute("value").trim();

	        String baseSeptemberScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Sep", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmSeptember = new BigDecimal(baseSeptemberRmStr);
	        BigDecimal custoRmSeptember = new BigDecimal(customerSeptemberRmStr);
	        BigDecimal baseScrapSeptember = new BigDecimal(baseSeptemberScrapStr);
	        BigDecimal custoScrapSeptember = new BigDecimal(customerSeptemberScrapStr);
	        BigDecimal uiLandedRmSeptember = new BigDecimal(landedValueSeptemberRmStr);
	        BigDecimal uiLandedScrapSeptember = new BigDecimal(landedValueSeptemberScrapStr);

	        BigDecimal expectedLandedRmSeptember =
	                baseRmSeptember.add(custoRmSeptember).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapSeptember =
	                baseScrapSeptember.add(custoScrapSeptember).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmSeptember =
	                uiLandedRmSeptember.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapSeptember =
	                uiLandedScrapSeptember.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[September][Customer] Base RM: " + baseRmSeptember +
	                ", Customer Delta RM: " + custoRmSeptember);

	        LoggerUtil.info("[September][Customer] Base Scrap: " + baseScrapSeptember +
	                ", Customer Delta Scrap: " + custoScrapSeptember);

	        // 🔹 Decimal precision check (max 3)
	        if (landedValueSeptemberRmStr.contains(".") &&
	                landedValueSeptemberRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: September RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueSeptemberRmStr);
	            return;
	        }

	        if (landedValueSeptemberScrapStr.contains(".") &&
	                landedValueSeptemberScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: September Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueSeptemberScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmSeptember.equals(expectedLandedRmSeptember)) {
	            LoggerUtil.mismatch(
	                    "FAILED: September RM Landed (Customer) | UI = " + uiRoundedRmSeptember
	                            + " | Expected = " + expectedLandedRmSeptember);
	            return;
	        }

	        if (!uiRoundedScrapSeptember.equals(expectedLandedScrapSeptember)) {
	            LoggerUtil.mismatch(
	                    "FAILED: September Scrap Landed (Customer) | UI = " + uiRoundedScrapSeptember
	                            + " | Expected = " + expectedLandedScrapSeptember);
	            return;
	        }

	        LoggerUtil.pass("September RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in September Customer Landed calculation → " + e.getMessage());
	    }
	}

	

	public static void calculateoctoberrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueOctoberRmStr = getFinalCustomerValue("Oct", "RM");
	        String landedValueOctoberScrapStr = getFinalCustomerValue("Oct", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerOctoberRmStr = getCustomerDeltaValue("Oct", "RM");
	        String customerOctoberScrapStr = getCustomerDeltaValue("Oct", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseOctoberRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Oct", "RM"))
	                .getAttribute("value").trim();

	        String baseOctoberScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Oct", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmOctober = new BigDecimal(baseOctoberRmStr);
	        BigDecimal custoRmOctober = new BigDecimal(customerOctoberRmStr);
	        BigDecimal baseScrapOctober = new BigDecimal(baseOctoberScrapStr);
	        BigDecimal custoScrapOctober = new BigDecimal(customerOctoberScrapStr);
	        BigDecimal uiLandedRmOctober = new BigDecimal(landedValueOctoberRmStr);
	        BigDecimal uiLandedScrapOctober = new BigDecimal(landedValueOctoberScrapStr);

	        BigDecimal expectedLandedRmOctober =
	                baseRmOctober.add(custoRmOctober).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapOctober =
	                baseScrapOctober.add(custoScrapOctober).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmOctober =
	                uiLandedRmOctober.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapOctober =
	                uiLandedScrapOctober.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[October][Customer] Base RM: " + baseRmOctober +
	                ", Customer Delta RM: " + custoRmOctober);

	        LoggerUtil.info("[October][Customer] Base Scrap: " + baseScrapOctober +
	                ", Customer Delta Scrap: " + custoScrapOctober);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueOctoberRmStr.contains(".") &&
	                landedValueOctoberRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: October RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueOctoberRmStr);
	            return;
	        }

	        if (landedValueOctoberScrapStr.contains(".") &&
	                landedValueOctoberScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: October Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueOctoberScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmOctober.equals(expectedLandedRmOctober)) {
	            LoggerUtil.mismatch(
	                    "FAILED: October RM Landed (Customer) | UI = " + uiRoundedRmOctober
	                            + " | Expected = " + expectedLandedRmOctober);
	            return;
	        }

	        if (!uiRoundedScrapOctober.equals(expectedLandedScrapOctober)) {
	            LoggerUtil.mismatch(
	                    "FAILED: October Scrap Landed (Customer) | UI = " + uiRoundedScrapOctober
	                            + " | Expected = " + expectedLandedScrapOctober);
	            return;
	        }

	        LoggerUtil.pass("October RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in October Customer Landed calculation → " + e.getMessage());
	    }
	}



	public static void calculatenovemberrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueNovemberRmStr = getFinalCustomerValue("Nov", "RM");
	        String landedValueNovemberScrapStr = getFinalCustomerValue("Nov", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerNovemberRmStr = getCustomerDeltaValue("Nov", "RM");
	        String customerNovemberScrapStr = getCustomerDeltaValue("Nov", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseNovemberRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Nov", "RM"))
	                .getAttribute("value").trim();

	        String baseNovemberScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Nov", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmNovember = new BigDecimal(baseNovemberRmStr);
	        BigDecimal custoRmNovember = new BigDecimal(customerNovemberRmStr);
	        BigDecimal baseScrapNovember = new BigDecimal(baseNovemberScrapStr);
	        BigDecimal custoScrapNovember = new BigDecimal(customerNovemberScrapStr);
	        BigDecimal uiLandedRmNovember = new BigDecimal(landedValueNovemberRmStr);
	        BigDecimal uiLandedScrapNovember = new BigDecimal(landedValueNovemberScrapStr);

	        BigDecimal expectedLandedRmNovember =
	                baseRmNovember.add(custoRmNovember).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapNovember =
	                baseScrapNovember.add(custoScrapNovember).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmNovember =
	                uiLandedRmNovember.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapNovember =
	                uiLandedScrapNovember.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[November][Customer] Base RM: " + baseRmNovember +
	                ", Customer Delta RM: " + custoRmNovember);

	        LoggerUtil.info("[November][Customer] Base Scrap: " + baseScrapNovember +
	                ", Customer Delta Scrap: " + custoScrapNovember);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueNovemberRmStr.contains(".") &&
	                landedValueNovemberRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: November RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueNovemberRmStr);
	            return;
	        }

	        if (landedValueNovemberScrapStr.contains(".") &&
	                landedValueNovemberScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: November Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueNovemberScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmNovember.equals(expectedLandedRmNovember)) {
	            LoggerUtil.mismatch(
	                    "FAILED: November RM Landed (Customer) | UI = " + uiRoundedRmNovember
	                            + " | Expected = " + expectedLandedRmNovember);
	            return;
	        }

	        if (!uiRoundedScrapNovember.equals(expectedLandedScrapNovember)) {
	            LoggerUtil.mismatch(
	                    "FAILED: November Scrap Landed (Customer) | UI = " + uiRoundedScrapNovember
	                            + " | Expected = " + expectedLandedScrapNovember);
	            return;
	        }

	        LoggerUtil.pass("November RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in November Customer Landed calculation → " + e.getMessage());
	    }
	}

	

	public static void calculatedecemberrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueDecemberRmStr = getFinalCustomerValue("Dec", "RM");
	        String landedValueDecemberScrapStr = getFinalCustomerValue("Dec", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerDecemberRmStr = getCustomerDeltaValue("Dec", "RM");
	        String customerDecemberScrapStr = getCustomerDeltaValue("Dec", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseDecemberRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Dec", "RM"))
	                .getAttribute("value").trim();

	        String baseDecemberScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Dec", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmDecember = new BigDecimal(baseDecemberRmStr);
	        BigDecimal custoRmDecember = new BigDecimal(customerDecemberRmStr);
	        BigDecimal baseScrapDecember = new BigDecimal(baseDecemberScrapStr);
	        BigDecimal custoScrapDecember = new BigDecimal(customerDecemberScrapStr);
	        BigDecimal uiLandedRmDecember = new BigDecimal(landedValueDecemberRmStr);
	        BigDecimal uiLandedScrapDecember = new BigDecimal(landedValueDecemberScrapStr);

	        BigDecimal expectedLandedRmDecember =
	                baseRmDecember.add(custoRmDecember).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapDecember =
	                baseScrapDecember.add(custoScrapDecember).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmDecember =
	                uiLandedRmDecember.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapDecember =
	                uiLandedScrapDecember.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[December][Customer] Base RM: " + baseRmDecember +
	                ", Customer Delta RM: " + custoRmDecember);

	        LoggerUtil.info("[December][Customer] Base Scrap: " + baseScrapDecember +
	                ", Customer Delta Scrap: " + custoScrapDecember);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueDecemberRmStr.contains(".") &&
	                landedValueDecemberRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: December RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueDecemberRmStr);
	            return;
	        }

	        if (landedValueDecemberScrapStr.contains(".") &&
	                landedValueDecemberScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: December Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueDecemberScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmDecember.equals(expectedLandedRmDecember)) {
	            LoggerUtil.mismatch(
	                    "FAILED: December RM Landed (Customer) | UI = " + uiRoundedRmDecember
	                            + " | Expected = " + expectedLandedRmDecember);
	            return;
	        }

	        if (!uiRoundedScrapDecember.equals(expectedLandedScrapDecember)) {
	            LoggerUtil.mismatch(
	                    "FAILED: December Scrap Landed (Customer) | UI = " + uiRoundedScrapDecember
	                            + " | Expected = " + expectedLandedScrapDecember);
	            return;
	        }

	        LoggerUtil.pass("December RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in December Customer Landed calculation → " + e.getMessage());
	    }
	}

	

	public static void calculatejanrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueJanuaryRmStr = getFinalCustomerValue("Jan", "RM");
	        String landedValueJanuaryScrapStr = getFinalCustomerValue("Jan", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerJanuaryRmStr = getCustomerDeltaValue("Jan", "RM");
	        String customerJanuaryScrapStr = getCustomerDeltaValue("Jan", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseJanuaryRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Jan", "RM"))
	                .getAttribute("value").trim();

	        String baseJanuaryScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Jan", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmJanuary = new BigDecimal(baseJanuaryRmStr);
	        BigDecimal custoRmJanuary = new BigDecimal(customerJanuaryRmStr);
	        BigDecimal baseScrapJanuary = new BigDecimal(baseJanuaryScrapStr);
	        BigDecimal custoScrapJanuary = new BigDecimal(customerJanuaryScrapStr);
	        BigDecimal uiLandedRmJanuary = new BigDecimal(landedValueJanuaryRmStr);
	        BigDecimal uiLandedScrapJanuary = new BigDecimal(landedValueJanuaryScrapStr);

	        BigDecimal expectedLandedRmJanuary =
	                baseRmJanuary.add(custoRmJanuary).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapJanuary =
	                baseScrapJanuary.add(custoScrapJanuary).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmJanuary =
	                uiLandedRmJanuary.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapJanuary =
	                uiLandedScrapJanuary.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[January][Customer] Base RM: " + baseRmJanuary +
	                ", Customer Delta RM: " + custoRmJanuary);

	        LoggerUtil.info("[January][Customer] Base Scrap: " + baseScrapJanuary +
	                ", Customer Delta Scrap: " + custoScrapJanuary);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueJanuaryRmStr.contains(".") &&
	                landedValueJanuaryRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: January RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueJanuaryRmStr);
	            return;
	        }

	        if (landedValueJanuaryScrapStr.contains(".") &&
	                landedValueJanuaryScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: January Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueJanuaryScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmJanuary.equals(expectedLandedRmJanuary)) {
	            LoggerUtil.mismatch(
	                    "FAILED: January RM Landed (Customer) | UI = " + uiRoundedRmJanuary
	                            + " | Expected = " + expectedLandedRmJanuary);
	            return;
	        }

	        if (!uiRoundedScrapJanuary.equals(expectedLandedScrapJanuary)) {
	            LoggerUtil.mismatch(
	                    "FAILED: January Scrap Landed (Customer) | UI = " + uiRoundedScrapJanuary
	                            + " | Expected = " + expectedLandedScrapJanuary);
	            return;
	        }

	        LoggerUtil.pass("January RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in January Customer Landed calculation → " + e.getMessage());
	    }
	}



	public static void calculatefebrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueFebRmStr = getFinalCustomerValue("Feb", "RM");
	        String landedValueFebScrapStr = getFinalCustomerValue("Feb", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerFebRmStr = getCustomerDeltaValue("Feb", "RM");
	        String customerFebScrapStr = getCustomerDeltaValue("Feb", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseFebRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Feb", "RM"))
	                .getAttribute("value").trim();

	        String baseFebScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Feb", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmFeb = new BigDecimal(baseFebRmStr);
	        BigDecimal custoRmFeb = new BigDecimal(customerFebRmStr);
	        BigDecimal baseScrapFeb = new BigDecimal(baseFebScrapStr);
	        BigDecimal custoScrapFeb = new BigDecimal(customerFebScrapStr);
	        BigDecimal uiLandedRmFeb = new BigDecimal(landedValueFebRmStr);
	        BigDecimal uiLandedScrapFeb = new BigDecimal(landedValueFebScrapStr);

	        BigDecimal expectedLandedRmFeb =
	                baseRmFeb.add(custoRmFeb).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapFeb =
	                baseScrapFeb.add(custoScrapFeb).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmFeb =
	                uiLandedRmFeb.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapFeb =
	                uiLandedScrapFeb.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[February][Customer] Base RM: " + baseRmFeb +
	                ", Customer Delta RM: " + custoRmFeb);

	        LoggerUtil.info("[February][Customer] Base Scrap: " + baseScrapFeb +
	                ", Customer Delta Scrap: " + custoScrapFeb);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueFebRmStr.contains(".") &&
	                landedValueFebRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: February RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueFebRmStr);
	            return;
	        }

	        if (landedValueFebScrapStr.contains(".") &&
	                landedValueFebScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: February Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueFebScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmFeb.equals(expectedLandedRmFeb)) {
	            LoggerUtil.mismatch(
	                    "FAILED: February RM Landed (Customer) | UI = " + uiRoundedRmFeb
	                            + " | Expected = " + expectedLandedRmFeb);
	            return;
	        }

	        if (!uiRoundedScrapFeb.equals(expectedLandedScrapFeb)) {
	            LoggerUtil.mismatch(
	                    "FAILED: February Scrap Landed (Customer) | UI = " + uiRoundedScrapFeb
	                            + " | Expected = " + expectedLandedScrapFeb);
	            return;
	        }

	        LoggerUtil.pass("February RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in February Customer Landed calculation → " + e.getMessage());
	    }
	}


	public static void calculatemarchrmandscrapforcustomer() {

	    try {
	        // 🔹 Landed (Customer Specific Landed cost row)
	        String landedValueMarchRmStr = getFinalCustomerValue("Mar", "RM");
	        String landedValueMarchScrapStr = getFinalCustomerValue("Mar", "Scrap");

	        // 🔹 Customer Delta (Delta Entry row)
	        String customerMarchRmStr = getCustomerDeltaValue("Mar", "RM");
	        String customerMarchScrapStr = getCustomerDeltaValue("Mar", "Scrap");

	        // 🔹 Base (Main Monthly Inputs)
	        String baseMarchRmStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Mar", "RM"))
	                .getAttribute("value").trim();

	        String baseMarchScrapStr = waitForExpectedElement(
	                getDynamicRMOrScrapLocator("Mar", "Scrap"))
	                .getAttribute("value").trim();

	        // 🔹 BigDecimal conversion
	        BigDecimal baseRmMarch = new BigDecimal(baseMarchRmStr);
	        BigDecimal custoRmMarch = new BigDecimal(customerMarchRmStr);
	        BigDecimal baseScrapMarch = new BigDecimal(baseMarchScrapStr);
	        BigDecimal custoScrapMarch = new BigDecimal(customerMarchScrapStr);
	        BigDecimal uiLandedRmMarch = new BigDecimal(landedValueMarchRmStr);
	        BigDecimal uiLandedScrapMarch = new BigDecimal(landedValueMarchScrapStr);

	        BigDecimal expectedLandedRmMarch =
	                baseRmMarch.add(custoRmMarch).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal expectedLandedScrapMarch =
	                baseScrapMarch.add(custoScrapMarch).setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedRmMarch =
	                uiLandedRmMarch.setScale(3, RoundingMode.HALF_UP);

	        BigDecimal uiRoundedScrapMarch =
	                uiLandedScrapMarch.setScale(3, RoundingMode.HALF_UP);

	        // 🔹 Logs
	        LoggerUtil.info("[March][Customer] Base RM: " + baseRmMarch +
	                ", Customer Delta RM: " + custoRmMarch);

	        LoggerUtil.info("[March][Customer] Base Scrap: " + baseScrapMarch +
	                ", Customer Delta Scrap: " + custoScrapMarch);

	        // 🔹 Decimal precision validation (max 3)
	        if (landedValueMarchRmStr.contains(".") &&
	                landedValueMarchRmStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: March RM Landed (Customer) has more than 3 decimals → "
	                            + landedValueMarchRmStr);
	            return;
	        }

	        if (landedValueMarchScrapStr.contains(".") &&
	                landedValueMarchScrapStr.split("\\.")[1].length() > 3) {

	            LoggerUtil.mismatch(
	                    "FAILED: March Scrap Landed (Customer) has more than 3 decimals → "
	                            + landedValueMarchScrapStr);
	            return;
	        }

	        // 🔹 Value comparison
	        if (!uiRoundedRmMarch.equals(expectedLandedRmMarch)) {
	            LoggerUtil.mismatch(
	                    "FAILED: March RM Landed (Customer) | UI = " + uiRoundedRmMarch
	                            + " | Expected = " + expectedLandedRmMarch);
	            return;
	        }

	        if (!uiRoundedScrapMarch.equals(expectedLandedScrapMarch)) {
	            LoggerUtil.mismatch(
	                    "FAILED: March Scrap Landed (Customer) | UI = " + uiRoundedScrapMarch
	                            + " | Expected = " + expectedLandedScrapMarch);
	            return;
	        }

	        LoggerUtil.pass("March RM/Scrap Landed Cost (Customer) passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception in March Customer Landed calculation → " + e.getMessage());
	    }
	}

	private static String getCustomerAggregateValue(String period, String type) {

	    By locator = getDynamicCustomerAggregateLocator(period, type);

	    WebElement element = waitForExpectedElement(locator);
	    return element.getAttribute("value").trim();
	}
	private static By getDynamicCustomerAggregateLocator(String period, String type) {

	    String className;

	    if (type.equalsIgnoreCase("RM")) {
	        className = "LCdeltaRM" + period + "Customer";
	    } else {
	        className = "LCdeltaScrap" + period + "Customer";
	    }

	    String xpath =
	        "//*[@id='DeltaTableBodyCustomer']//tr[contains(@class,'FinalDelta')]"
	        + "//input[contains(@class,'" + className + "')]";

	    return By.xpath(xpath);
	}


	public static void calculatefirstQ1forcustomerallocationForRm() {

	    LoggerUtil.info("Starting Q1 RM average verification for Customer (April to June)");

	    try {
	        String aprilVal = getCustomerDeltaValue("Apr", "RM");
	        String mayVal   = getCustomerDeltaValue("May", "RM");
	        String juneVal  = getCustomerDeltaValue("Jun", "RM");

	        String q1Val    = getCustomerAggregateValue("Q1", "RM");

	        if (aprilVal == null || mayVal == null || juneVal == null || q1Val == null) {
	            LoggerUtil.fail("Q1 RM calculation aborted – missing values");
	            return;
	        }

	        BigDecimal april = new BigDecimal(aprilVal);
	        BigDecimal may   = new BigDecimal(mayVal);
	        BigDecimal june  = new BigDecimal(juneVal);

	        BigDecimal expectedQ1 =
	                april.add(may).add(june)
	                     .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q1 RM Inputs → Apr: " + april + ", May: " + may + ", Jun: " + june);

	        // Decimal validation
	        if (q1Val.contains(".") && q1Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch("FAILED: Q1 RM has more than 3 decimals → " + q1Val);
	            return;
	        }

	        BigDecimal uiQ1 = new BigDecimal(q1Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Expected Q1 RM : " + expectedQ1);
	        LoggerUtil.info("UI Q1 RM       : " + uiQ1);

	        if (!uiQ1.equals(expectedQ1)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q1 RM mismatch | UI = " + uiQ1 + " | Expected = " + expectedQ1);
	            return;
	        }

	        LoggerUtil.pass("Q1 RM (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q1 RM calculation → " + e.getMessage());
	    }
	}


	public static void calculatefirstQ1forcustomerallocationForScrap() {

	    LoggerUtil.info("Starting Q1 Scrap average verification for Customer (April to June)");

	    try {
	        String aprilVal = getCustomerDeltaValue("Apr", "Scrap");
	        String mayVal   = getCustomerDeltaValue("May", "Scrap");
	        String juneVal  = getCustomerDeltaValue("Jun", "Scrap");

	        // ✅ IMPORTANT: Q1 uses AGGREGATE locator
	        String q1Val    = getCustomerAggregateValue("Q1", "Scrap");

	        if (aprilVal == null || mayVal == null || juneVal == null || q1Val == null) {
	            LoggerUtil.fail("Q1 Scrap calculation aborted – missing required values");
	            return;
	        }

	        BigDecimal april = new BigDecimal(aprilVal);
	        BigDecimal may   = new BigDecimal(mayVal);
	        BigDecimal june  = new BigDecimal(juneVal);

	        BigDecimal expectedQ1 =
	                april.add(may).add(june)
	                     .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q1 Customer Scrap inputs:");
	        LoggerUtil.info("April Scrap : " + april);
	        LoggerUtil.info("May Scrap   : " + may);
	        LoggerUtil.info("June Scrap  : " + june);

	        // 3-decimal validation
	        if (q1Val.contains(".") && q1Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q1 Scrap (Customer) has more than 3 decimals → " + q1Val);
	            return;
	        }

	        BigDecimal uiQ1 =
	                new BigDecimal(q1Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q1 Scrap Customer : " + expectedQ1);
	        LoggerUtil.info("UI Q1 Scrap Customer         : " + uiQ1);

	        if (!uiQ1.equals(expectedQ1)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q1 Scrap (Customer) | UI = " + uiQ1
	                    + " | Expected = " + expectedQ1);
	            return;
	        }

	        LoggerUtil.pass("Q1 Scrap (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q1 Scrap calculation (Customer) → " + e.getMessage());
	    }
	}

	public static void verifyCalculatingCustomerAllocationSecondQ2ForRm() {

	    LoggerUtil.info("Starting Q2 RM average verification for Customer (July to September)");

	    try {
	        String julyVal = getCustomerDeltaValue("Jul", "RM");
	        String augVal  = getCustomerDeltaValue("Aug", "RM");
	        String sepVal  = getCustomerDeltaValue("Sep", "RM");

	        // ✅ IMPORTANT: Q2 uses AGGREGATE locator
	        String q2Val   = getCustomerAggregateValue("Q2", "RM");

	        if (julyVal == null || augVal == null || sepVal == null || q2Val == null) {
	            LoggerUtil.fail("Q2 RM calculation aborted – missing required values");
	            return;
	        }

	        BigDecimal july      = new BigDecimal(julyVal);
	        BigDecimal august   = new BigDecimal(augVal);
	        BigDecimal september= new BigDecimal(sepVal);

	        BigDecimal expectedQ2 =
	                july.add(august).add(september)
	                    .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q2 Customer RM inputs:");
	        LoggerUtil.info("July RM      : " + july);
	        LoggerUtil.info("August RM    : " + august);
	        LoggerUtil.info("September RM : " + september);

	        // 3-decimal validation
	        if (q2Val.contains(".") && q2Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q2 RM (Customer) has more than 3 decimals → " + q2Val);
	            return;
	        }

	        BigDecimal uiQ2 =
	                new BigDecimal(q2Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q2 RM Customer : " + expectedQ2);
	        LoggerUtil.info("UI Q2 RM Customer         : " + uiQ2);

	        if (!uiQ2.equals(expectedQ2)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q2 RM (Customer) | UI = " + uiQ2
	                    + " | Expected = " + expectedQ2);
	            return;
	        }

	        LoggerUtil.pass("Q2 RM (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q2 RM calculation (Customer) → " + e.getMessage());
	    }
	}


	public static void calculatingQ2ScrapValueForCustomerAllocation() {

	    LoggerUtil.info("Starting Q2 Scrap average verification for Customer (July to September)");

	    try {
	        String julyVal = getCustomerDeltaValue("Jul", "Scrap");
	        String augVal  = getCustomerDeltaValue("Aug", "Scrap");
	        String sepVal  = getCustomerDeltaValue("Sep", "Scrap");

	        // ✅ IMPORTANT: Q2 is AGGREGATE
	        String q2Val   = getCustomerAggregateValue("Q2", "Scrap");

	        if (julyVal == null || augVal == null || sepVal == null || q2Val == null) {
	            LoggerUtil.fail("Q2 Scrap calculation aborted – missing required values");
	            return;
	        }

	        BigDecimal july      = new BigDecimal(julyVal);
	        BigDecimal august   = new BigDecimal(augVal);
	        BigDecimal september= new BigDecimal(sepVal);

	        BigDecimal expectedQ2 =
	                july.add(august).add(september)
	                    .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q2 Customer Scrap inputs:");
	        LoggerUtil.info("July Scrap      : " + july);
	        LoggerUtil.info("August Scrap    : " + august);
	        LoggerUtil.info("September Scrap : " + september);

	        // 3-decimal validation
	        if (q2Val.contains(".") && q2Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q2 Scrap (Customer) has more than 3 decimals → " + q2Val);
	            return;
	        }

	        BigDecimal uiQ2 =
	                new BigDecimal(q2Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q2 Scrap Customer : " + expectedQ2);
	        LoggerUtil.info("UI Q2 Scrap Customer         : " + uiQ2);

	        if (!uiQ2.equals(expectedQ2)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q2 Scrap (Customer) | UI = " + uiQ2
	                    + " | Expected = " + expectedQ2);
	            return;
	        }

	        LoggerUtil.pass("Q2 Scrap (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q2 Scrap calculation (Customer) → " + e.getMessage());
	    }
	}


	
	public static void calculatingQ3calculationRmforCustomer() {

	    LoggerUtil.info("Starting Q3 RM average verification for Customer (October to December)");

	    try {
	        String octVal = getCustomerDeltaValue("Oct", "RM");
	        String novVal = getCustomerDeltaValue("Nov", "RM");
	        String decVal = getCustomerDeltaValue("Dec", "RM");

	        // ✅ Q3 is AGGREGATE
	        String q3Val  = getCustomerAggregateValue("Q3", "RM");

	        if (octVal == null || novVal == null || decVal == null || q3Val == null) {
	            LoggerUtil.fail("Q3 RM calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal october  = new BigDecimal(octVal);
	        BigDecimal november = new BigDecimal(novVal);
	        BigDecimal december = new BigDecimal(decVal);

	        BigDecimal expectedQ3 =
	                october.add(november).add(december)
	                        .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q3 Customer RM inputs:");
	        LoggerUtil.info("October RM  : " + october);
	        LoggerUtil.info("November RM : " + november);
	        LoggerUtil.info("December RM : " + december);

	        // 3-decimal validation
	        if (q3Val.contains(".") && q3Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q3 RM (Customer) has more than 3 decimals → " + q3Val);
	            return;
	        }

	        BigDecimal uiQ3 =
	                new BigDecimal(q3Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q3 RM Customer : " + expectedQ3);
	        LoggerUtil.info("UI Q3 RM Customer         : " + uiQ3);

	        if (!uiQ3.equals(expectedQ3)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q3 RM (Customer) | UI = " + uiQ3
	                            + " | Expected = " + expectedQ3);
	            return;
	        }

	        LoggerUtil.pass("Q3 RM (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q3 RM calculation (Customer) → " + e.getMessage());
	    }
	}


	public static void calculatingQ3scrapvalue() {

	    LoggerUtil.info("Starting Q3 Scrap average verification for Customer (October to December)");

	    try {
	        String octVal = getCustomerDeltaValue("Oct", "Scrap");
	        String novVal = getCustomerDeltaValue("Nov", "Scrap");
	        String decVal = getCustomerDeltaValue("Dec", "Scrap");

	        // ✅ Q3 is AGGREGATE
	        String q3Val  = getCustomerAggregateValue("Q3", "Scrap");

	        if (octVal == null || novVal == null || decVal == null || q3Val == null) {
	            LoggerUtil.fail("Q3 Scrap calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal october  = new BigDecimal(octVal);
	        BigDecimal november = new BigDecimal(novVal);
	        BigDecimal december = new BigDecimal(decVal);

	        BigDecimal expectedQ3 =
	                october.add(november).add(december)
	                        .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q3 Customer Scrap inputs:");
	        LoggerUtil.info("October Scrap  : " + october);
	        LoggerUtil.info("November Scrap : " + november);
	        LoggerUtil.info("December Scrap : " + december);

	        // 3-decimal validation (UI)
	        if (q3Val.contains(".") && q3Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q3 Scrap (Customer) has more than 3 decimals → " + q3Val);
	            return;
	        }

	        BigDecimal uiQ3 =
	                new BigDecimal(q3Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q3 Scrap Customer : " + expectedQ3);
	        LoggerUtil.info("UI Q3 Scrap Customer         : " + uiQ3);

	        if (!uiQ3.equals(expectedQ3)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q3 Scrap (Customer) | UI = " + uiQ3
	                            + " | Expected = " + expectedQ3);
	            return;
	        }

	        LoggerUtil.pass("Q3 Scrap (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q3 Scrap calculation (Customer) → " + e.getMessage());
	    }
	}


	public static void calculatingQ4rmvalue() {

	    LoggerUtil.info("Starting Q4 RM average verification for Customer (January to March)");

	    try {
	        String janVal = getCustomerDeltaValue("Jan", "RM");
	        String febVal = getCustomerDeltaValue("Feb", "RM");
	        String marVal = getCustomerDeltaValue("Mar", "RM");

	        // ✅ Q4 is aggregate
	        String q4Val  = getCustomerAggregateValue("Q4", "RM");

	        if (janVal == null || febVal == null || marVal == null || q4Val == null) {
	            LoggerUtil.fail("Q4 RM calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal january  = new BigDecimal(janVal);
	        BigDecimal february = new BigDecimal(febVal);
	        BigDecimal march    = new BigDecimal(marVal);

	        BigDecimal expectedQ4 =
	                january.add(february).add(march)
	                        .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q4 Customer RM inputs:");
	        LoggerUtil.info("January RM  : " + january);
	        LoggerUtil.info("February RM : " + february);
	        LoggerUtil.info("March RM    : " + march);

	        // 3-decimal validation (UI)
	        if (q4Val.contains(".") && q4Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q4 RM (Customer) has more than 3 decimals → " + q4Val);
	            return;
	        }

	        BigDecimal uiQ4 =
	                new BigDecimal(q4Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q4 RM Customer : " + expectedQ4);
	        LoggerUtil.info("UI Q4 RM Customer         : " + uiQ4);

	        if (!uiQ4.equals(expectedQ4)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q4 RM (Customer) | UI = " + uiQ4
	                            + " | Expected = " + expectedQ4);
	            return;
	        }

	        LoggerUtil.pass("Q4 RM (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q4 RM calculation (Customer) → " + e.getMessage());
	    }
	}

	

	public static void calculatingQ4scrapvalue() {

	    LoggerUtil.info("Starting Q4 Scrap average verification for Customer (January to March)");

	    try {
	        String janVal = getCustomerDeltaValue("Jan", "Scrap");
	        String febVal = getCustomerDeltaValue("Feb", "Scrap");
	        String marVal = getCustomerDeltaValue("Mar", "Scrap");

	        // ✅ Q4 is aggregate
	        String q4Val  = getCustomerAggregateValue("Q4", "Scrap");

	        if (janVal == null || febVal == null || marVal == null || q4Val == null) {
	            LoggerUtil.fail("Q4 Scrap calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal january  = new BigDecimal(janVal);
	        BigDecimal february = new BigDecimal(febVal);
	        BigDecimal march    = new BigDecimal(marVal);

	        BigDecimal expectedQ4 =
	                january.add(february).add(march)
	                        .divide(new BigDecimal("3"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Q4 Customer Scrap inputs:");
	        LoggerUtil.info("January Scrap  : " + january);
	        LoggerUtil.info("February Scrap : " + february);
	        LoggerUtil.info("March Scrap    : " + march);

	        // 3-decimal validation (UI)
	        if (q4Val.contains(".") && q4Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q4 Scrap (Customer) has more than 3 decimals → " + q4Val);
	            return;
	        }

	        BigDecimal uiQ4 =
	                new BigDecimal(q4Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated Q4 Scrap Customer : " + expectedQ4);
	        LoggerUtil.info("UI Q4 Scrap Customer         : " + uiQ4);

	        if (!uiQ4.equals(expectedQ4)) {
	            LoggerUtil.mismatch(
	                    "FAILED: Q4 Scrap (Customer) | UI = " + uiQ4
	                            + " | Expected = " + expectedQ4);
	            return;
	        }

	        LoggerUtil.pass("Q4 Scrap (Customer) calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during Q4 Scrap calculation (Customer) → " + e.getMessage());
	    }
	}

	public static void verifycalculatefirstsixmonthaveragevalue() {

	    LoggerUtil.info("Starting HY1 (First Six Months) RM average verification for Customer (Apr to Sep)");

	    try {
	        String aprVal = getCustomerDeltaValue("Apr", "RM");
	        String mayVal = getCustomerDeltaValue("May", "RM");
	        String junVal = getCustomerDeltaValue("Jun", "RM");
	        String julVal = getCustomerDeltaValue("Jul", "RM");
	        String augVal = getCustomerDeltaValue("Aug", "RM");
	        String sepVal = getCustomerDeltaValue("Sep", "RM");

	        // ✅ H1 is aggregate
	        String hy1Val = getCustomerAggregateValue("H1", "RM");

	        if (aprVal == null || mayVal == null || junVal == null ||
	            julVal == null || augVal == null || sepVal == null || hy1Val == null) {

	            LoggerUtil.fail("HY1 RM calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal april     = new BigDecimal(aprVal);
	        BigDecimal may       = new BigDecimal(mayVal);
	        BigDecimal june      = new BigDecimal(junVal);
	        BigDecimal july      = new BigDecimal(julVal);
	        BigDecimal august    = new BigDecimal(augVal);
	        BigDecimal september = new BigDecimal(sepVal);

	        BigDecimal expectedHY1 =
	                april.add(may)
	                     .add(june)
	                     .add(july)
	                     .add(august)
	                     .add(september)
	                     .divide(new BigDecimal("6"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("HY1 Customer RM inputs:");
	        LoggerUtil.info("April RM     : " + april);
	        LoggerUtil.info("May RM       : " + may);
	        LoggerUtil.info("June RM      : " + june);
	        LoggerUtil.info("July RM      : " + july);
	        LoggerUtil.info("August RM    : " + august);
	        LoggerUtil.info("September RM : " + september);

	        // 3-decimal validation
	        if (hy1Val.contains(".") && hy1Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY1 RM (Customer) has more than 3 decimals → " + hy1Val);
	            return;
	        }

	        BigDecimal uiHY1 =
	                new BigDecimal(hy1Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated HY1 RM Customer : " + expectedHY1);
	        LoggerUtil.info("UI HY1 RM Customer         : " + uiHY1);

	        if (!uiHY1.equals(expectedHY1)) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY1 RM (Customer) | UI = " + uiHY1
	                            + " | Expected = " + expectedHY1);
	            return;
	        }

	        LoggerUtil.pass("HY1 RM (Customer) average calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during HY1 RM calculation (Customer) → " + e.getMessage());
	    }
	}


	public static void calculatehy1scrapvalue() {

	    LoggerUtil.info("Starting HY1 (First Six Months) Scrap average verification for Customer (Apr to Sep)");

	    try {
	        String aprVal = getCustomerDeltaValue("Apr", "Scrap");
	        String mayVal = getCustomerDeltaValue("May", "Scrap");
	        String junVal = getCustomerDeltaValue("Jun", "Scrap");
	        String julVal = getCustomerDeltaValue("Jul", "Scrap");
	        String augVal = getCustomerDeltaValue("Aug", "Scrap");
	        String sepVal = getCustomerDeltaValue("Sep", "Scrap");

	        // ✅ H1 is aggregate
	        String hy1Val = getCustomerAggregateValue("H1", "Scrap");

	        if (aprVal == null || mayVal == null || junVal == null ||
	            julVal == null || augVal == null || sepVal == null || hy1Val == null) {

	            LoggerUtil.fail("HY1 Scrap calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal april     = new BigDecimal(aprVal);
	        BigDecimal may       = new BigDecimal(mayVal);
	        BigDecimal june      = new BigDecimal(junVal);
	        BigDecimal july      = new BigDecimal(julVal);
	        BigDecimal august    = new BigDecimal(augVal);
	        BigDecimal september = new BigDecimal(sepVal);

	        BigDecimal expectedHY1 =
	                april.add(may)
	                     .add(june)
	                     .add(july)
	                     .add(august)
	                     .add(september)
	                     .divide(new BigDecimal("6"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("HY1 Customer Scrap inputs:");
	        LoggerUtil.info("April Scrap     : " + april);
	        LoggerUtil.info("May Scrap       : " + may);
	        LoggerUtil.info("June Scrap      : " + june);
	        LoggerUtil.info("July Scrap      : " + july);
	        LoggerUtil.info("August Scrap    : " + august);
	        LoggerUtil.info("September Scrap : " + september);

	        // 3-decimal validation
	        if (hy1Val.contains(".") && hy1Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY1 Scrap (Customer) has more than 3 decimals → " + hy1Val);
	            return;
	        }

	        BigDecimal uiHY1 =
	                new BigDecimal(hy1Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated HY1 Scrap Customer : " + expectedHY1);
	        LoggerUtil.info("UI HY1 Scrap Customer         : " + uiHY1);

	        if (!uiHY1.equals(expectedHY1)) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY1 Scrap (Customer) | UI = " + uiHY1
	                            + " | Expected = " + expectedHY1);
	            return;
	        }

	        LoggerUtil.pass("HY1 Scrap (Customer) average calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during HY1 Scrap calculation (Customer) → " + e.getMessage());
	    }
	}


	public static void verifycalculatesecondhalfyearcustomer() {

	    LoggerUtil.info("Starting HY2 (Second Half Year) RM average verification for Customer (Oct to Mar)");

	    try {
	        String octVal = getCustomerDeltaValue("Oct", "RM");
	        String novVal = getCustomerDeltaValue("Nov", "RM");
	        String decVal = getCustomerDeltaValue("Dec", "RM");
	        String janVal = getCustomerDeltaValue("Jan", "RM");
	        String febVal = getCustomerDeltaValue("Feb", "RM");
	        String marVal = getCustomerDeltaValue("Mar", "RM");

	        // ✅ HY2 is aggregate
	        String hy2Val = getCustomerAggregateValue("H2", "RM");

	        if (octVal == null || novVal == null || decVal == null ||
	            janVal == null || febVal == null || marVal == null || hy2Val == null) {

	            LoggerUtil.fail("HY2 RM calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal october  = new BigDecimal(octVal);
	        BigDecimal november = new BigDecimal(novVal);
	        BigDecimal december = new BigDecimal(decVal);
	        BigDecimal january  = new BigDecimal(janVal);
	        BigDecimal february = new BigDecimal(febVal);
	        BigDecimal march    = new BigDecimal(marVal);

	        BigDecimal expectedHY2 =
	                october.add(november)
	                       .add(december)
	                       .add(january)
	                       .add(february)
	                       .add(march)
	                       .divide(new BigDecimal("6"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("HY2 Customer RM inputs:");
	        LoggerUtil.info("October RM  : " + october);
	        LoggerUtil.info("November RM : " + november);
	        LoggerUtil.info("December RM : " + december);
	        LoggerUtil.info("January RM  : " + january);
	        LoggerUtil.info("February RM : " + february);
	        LoggerUtil.info("March RM    : " + march);

	        // 3-decimal validation
	        if (hy2Val.contains(".") && hy2Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY2 RM (Customer) has more than 3 decimals → " + hy2Val);
	            return;
	        }

	        BigDecimal uiHY2 =
	                new BigDecimal(hy2Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated HY2 RM Customer : " + expectedHY2);
	        LoggerUtil.info("UI HY2 RM Customer         : " + uiHY2);

	        if (!uiHY2.equals(expectedHY2)) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY2 RM (Customer) | UI = " + uiHY2
	                            + " | Expected = " + expectedHY2);
	            return;
	        }

	        LoggerUtil.pass("HY2 RM (Customer) average calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during HY2 RM calculation (Customer) → " + e.getMessage());
	    }
	}



	public static void calculatehalfyearscrapvalue() {

	    LoggerUtil.info("Starting HY2 (Second Half Year) Scrap average verification for Customer (Oct to Mar)");

	    try {
	        String octVal = getCustomerDeltaValue("Oct", "Scrap");
	        String novVal = getCustomerDeltaValue("Nov", "Scrap");
	        String decVal = getCustomerDeltaValue("Dec", "Scrap");
	        String janVal = getCustomerDeltaValue("Jan", "Scrap");
	        String febVal = getCustomerDeltaValue("Feb", "Scrap");
	        String marVal = getCustomerDeltaValue("Mar", "Scrap");

	        // ✅ HY2 is aggregate
	        String hy2Val = getCustomerAggregateValue("H2", "Scrap");

	        if (octVal == null || novVal == null || decVal == null ||
	            janVal == null || febVal == null || marVal == null || hy2Val == null) {

	            LoggerUtil.fail("HY2 Scrap calculation aborted – one or more required values are missing");
	            return;
	        }

	        BigDecimal october  = new BigDecimal(octVal);
	        BigDecimal november = new BigDecimal(novVal);
	        BigDecimal december = new BigDecimal(decVal);
	        BigDecimal january  = new BigDecimal(janVal);
	        BigDecimal february = new BigDecimal(febVal);
	        BigDecimal march    = new BigDecimal(marVal);

	        BigDecimal expectedHY2 =
	                october.add(november)
	                       .add(december)
	                       .add(january)
	                       .add(february)
	                       .add(march)
	                       .divide(new BigDecimal("6"), 3, RoundingMode.HALF_UP);

	        LoggerUtil.info("HY2 Customer Scrap inputs:");
	        LoggerUtil.info("October Scrap  : " + october);
	        LoggerUtil.info("November Scrap : " + november);
	        LoggerUtil.info("December Scrap : " + december);
	        LoggerUtil.info("January Scrap  : " + january);
	        LoggerUtil.info("February Scrap : " + february);
	        LoggerUtil.info("March Scrap    : " + march);

	        // 3-decimal validation
	        if (hy2Val.contains(".") && hy2Val.split("\\.")[1].length() > 3) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY2 Scrap (Customer) has more than 3 decimals → " + hy2Val);
	            return;
	        }

	        BigDecimal uiHY2 =
	                new BigDecimal(hy2Val).setScale(3, RoundingMode.HALF_UP);

	        LoggerUtil.info("Calculated HY2 Scrap Customer : " + expectedHY2);
	        LoggerUtil.info("UI HY2 Scrap Customer         : " + uiHY2);

	        if (!uiHY2.equals(expectedHY2)) {
	            LoggerUtil.mismatch(
	                    "FAILED: HY2 Scrap (Customer) | UI = " + uiHY2
	                            + " | Expected = " + expectedHY2);
	            return;
	        }

	        LoggerUtil.pass("HY2 Scrap (Customer) average calculation passed.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during HY2 Scrap calculation (Customer) → " + e.getMessage());
	    }
	}


	public void enterRmandScrapvalueForcalculatingRmAndScrapvalueWithdependondnumberofRmEntryAndNumberOfScrapEntrt(
			String enteraprilrm, String enteraprilscrap, String entermayrm, String entermayscrap, String enterjunerm,
			String enterjunescrap, String enterjulyrm, String enterjulyscrap, String enteraugustrm,
			String enteraugscrap, String enterseptemrm, String entersepscrap, String enetroctrm, String enteroctscrap,
			String enternovrm, String enternovscrap, String enterdecrm, String enterdecscrap, String enetrjanram,
			String enterjanscrap, String enterfebrm, String enterfebscrap, String entermarchrm, String entermarchscrap,
			String entersearchvalue) throws InterruptedException {

		LoggerUtil.info("===== Starting RM and Scrap Entry Using Dynamic Locators =====");

		// ✅ Step 1: Define months and corresponding RM/Scrap values
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };
		String[] rmValues = { enteraprilrm, entermayrm, enterjunerm, enterjulyrm, enteraugustrm, enterseptemrm,
				enetroctrm, enternovrm, enterdecrm, enetrjanram, enterfebrm, entermarchrm };
		String[] scrapValues = { enteraprilscrap, entermayscrap, enterjunescrap, enterjulyscrap, enteraugscrap,
				entersepscrap, enteroctscrap, enternovscrap, enterdecscrap, enterjanscrap, enterfebscrap,
				entermarchscrap };

		// ✅ Step 2: Enter RM and Scrap month-wise dynamically
		for (int i = 0; i < months.length; i++) {
			try {
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
				LoggerUtil.info(months[i] + " → RM: " + rmValues[i] + ", Scrap: " + scrapValues[i]);
			} catch (Exception e) {
				LoggerUtil.error("❌ Error while entering " + months[i] + " RM/Scrap values → " + e.getMessage());
			}
		}

		// ✅ Step 3: Save and View Flow (unchanged)
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);
		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		Thread.sleep(4000);

		String expectedvalue = entersearchvalue;
		String actualvalue = waitForExpectedElement(fetchingcommoditygrpcolumn).getText();
		Assert.assertEquals(expectedvalue, actualvalue);
		Thread.sleep(2000);

		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(3000);

		// ✅ Step 4: Validation Phase (Dynamic)
		LoggerUtil.info("✅ Starting Monthly RM and Scrap Value Verification Using Dynamic Locators");
		SoftAssert softAssert = new SoftAssert();

		for (int i = 0; i < months.length; i++) {
			String actualRm = waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")).getAttribute("value")
					.trim();
			String actualScrap = waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap"))
					.getAttribute("value").trim();

			logAndAssert(months[i], "RM", rmValues[i], actualRm, softAssert);
			logAndAssert(months[i], "Scrap", scrapValues[i], actualScrap, softAssert);
		}

		LoggerUtil.info("✅ Finished Verification for All Monthly RM and Scrap Values");
		softAssert.assertAll();
	}

	public void calculatingRmaveragdependofrandomEntriesinQ1() {
		LoggerUtil.info("🧾 Starting Q1 RM Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String aprilVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value").trim();
		String mayVal = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value").trim();
		String juneVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value").trim();
		String q1Val = waitForExpectedElement(getDynamicPeriodLocator("q1", "RM")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!aprilVal.isEmpty()) {
			sum = sum.add(new BigDecimal(aprilVal));
			count++;
			LoggerUtil.info("April RM: " + aprilVal);
		} else {
			LoggerUtil.info("April RM: Not Entered");
		}

		if (!mayVal.isEmpty()) {
			sum = sum.add(new BigDecimal(mayVal));
			count++;
			LoggerUtil.info("May RM: " + mayVal);
		} else {
			LoggerUtil.info("May RM: Not Entered");
		}

		if (!juneVal.isEmpty()) {
			sum = sum.add(new BigDecimal(juneVal));
			count++;
			LoggerUtil.info("June RM: " + juneVal);
		} else {
			LoggerUtil.info("June RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q1 months.");
			Assert.fail("❌ No values found for Q1 RM months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q1Val.contains(".")) {
			String decimalPart = q1Val.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q1 RM (UI) value (" + q1Val + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q1 RM value has more than 3 decimal digits: " + q1Val);
			}
		}

		BigDecimal expectedQ1Val = new BigDecimal(q1Val).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q1 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q1 RM (UI): " + expectedQ1Val);

		if (!expectedQ1Val.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q1 RM - UI: " + expectedQ1Val + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ1Val, calculatedAvg,
				"Q1 RM verification: Expected = " + expectedQ1Val + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q1 RM: " + count);
		LoggerUtil.pass("✅ Q1 RM Average Calculation Completed.");

		softAssert.assertAll();
	}

	public void calculatingaverageDependonNumvberOfEntriesforq2() {
		LoggerUtil.info("🧾 Starting Q2 RM Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String julyVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value").trim();
		String augustVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")).getAttribute("value").trim();
		String septemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")).getAttribute("value")
				.trim();
		String q2Val = waitForExpectedElement(getDynamicPeriodLocator("q2", "RM")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!julyVal.isEmpty()) {
			sum = sum.add(new BigDecimal(julyVal));
			count++;
			LoggerUtil.info("July RM: " + julyVal);
		} else {
			LoggerUtil.info("July RM: Not Entered");
		}

		if (!augustVal.isEmpty()) {
			sum = sum.add(new BigDecimal(augustVal));
			count++;
			LoggerUtil.info("August RM: " + augustVal);
		} else {
			LoggerUtil.info("August RM: Not Entered");
		}

		if (!septemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(septemberVal));
			count++;
			LoggerUtil.info("September RM: " + septemberVal);
		} else {
			LoggerUtil.info("September RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q2 months.");
			Assert.fail("❌ No values found for Q2 RM months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q2Val.contains(".")) {
			String decimalPart = q2Val.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q2 RM (UI) value (" + q2Val + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q2 RM value has more than 3 decimal digits: " + q2Val);
			}
		}

		BigDecimal expectedQ2Val = new BigDecimal(q2Val).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q2 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q2 RM (UI): " + expectedQ2Val);

		if (!expectedQ2Val.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q2 RM - UI: " + expectedQ2Val + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ2Val, calculatedAvg,
				"Q2 RM verification: Expected = " + expectedQ2Val + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q2 RM: " + count);
		LoggerUtil.pass("✅ Q2 RM Average Calculation Completed.");

		softAssert.assertAll();
	}

	public void calculatingAverageDependonNumvberOfEntriesForQ3() {
		LoggerUtil.info("🧾 Starting Q3 RM Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String octoberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")).getAttribute("value")
				.trim();
		String novemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")).getAttribute("value")
				.trim();
		String decemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")).getAttribute("value")
				.trim();
		String q3Val = waitForExpectedElement(getDynamicPeriodLocator("q3", "RM")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(octoberVal));
			count++;
			LoggerUtil.info("October RM: " + octoberVal);
		} else {
			LoggerUtil.info("October RM: Not Entered");
		}

		if (!novemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(novemberVal));
			count++;
			LoggerUtil.info("November RM: " + novemberVal);
		} else {
			LoggerUtil.info("November RM: Not Entered");
		}

		if (!decemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(decemberVal));
			count++;
			LoggerUtil.info("December RM: " + decemberVal);
		} else {
			LoggerUtil.info("December RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q3 months.");
			Assert.fail("❌ No values found for Q3 RM months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q3Val.contains(".")) {
			String decimalPart = q3Val.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q3 RM (UI) value (" + q3Val + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q3 RM value has more than 3 decimal digits: " + q3Val);
			}
		}

		BigDecimal expectedQ3Val = new BigDecimal(q3Val).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q3 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q3 RM (UI): " + expectedQ3Val);

		if (!expectedQ3Val.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q3 RM - UI: " + expectedQ3Val + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ3Val, calculatedAvg,
				"Q3 RM verification: Expected = " + expectedQ3Val + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q3 RM: " + count);
		LoggerUtil.pass("✅ Q3 RM Average Calculation Completed.");

		softAssert.assertAll();
	}

	public void calculatingAverageDependonNumberOfEntriesForQ4() {
		LoggerUtil.info("🧾 Starting Q4 RM Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String janVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")).getAttribute("value").trim();
		String febVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")).getAttribute("value").trim();
		String marVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value").trim();
		String q4Val = waitForExpectedElement(getDynamicPeriodLocator("q4", "RM")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!janVal.isEmpty()) {
			sum = sum.add(new BigDecimal(janVal));
			count++;
			LoggerUtil.info("January RM: " + janVal);
		} else {
			LoggerUtil.info("January RM: Not Entered");
		}

		if (!febVal.isEmpty()) {
			sum = sum.add(new BigDecimal(febVal));
			count++;
			LoggerUtil.info("February RM: " + febVal);
		} else {
			LoggerUtil.info("February RM: Not Entered");
		}

		if (!marVal.isEmpty()) {
			sum = sum.add(new BigDecimal(marVal));
			count++;
			LoggerUtil.info("March RM: " + marVal);
		} else {
			LoggerUtil.info("March RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for Q4 months.");
			Assert.fail("❌ No values found for Q4 RM months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q4Val.contains(".")) {
			String decimalPart = q4Val.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q4 RM (UI) value (" + q4Val + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q4 RM value has more than 3 decimal digits: " + q4Val);
			}
		}

		BigDecimal expectedQ4Val = new BigDecimal(q4Val).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q4 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q4 RM (UI): " + expectedQ4Val);

		if (!expectedQ4Val.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: Q4 RM - UI: " + expectedQ4Val + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ4Val, calculatedAvg,
				"Q4 RM verification: Expected = " + expectedQ4Val + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q4 RM: " + count);
		LoggerUtil.pass("✅ Q4 RM Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== Q1 Scrap ===================
	public void calculateScrapAverageDependsonNumberOfEntriesForQ1() {
		LoggerUtil.info("🧾 Starting Q1 Scrap Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String aprilVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")).getAttribute("value")
				.trim();
		String mayVal = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")).getAttribute("value").trim();
		String juneVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")).getAttribute("value")
				.trim();
		String q1Val = waitForExpectedElement(getDynamicPeriodLocator("q1", "Scrap")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!aprilVal.isEmpty() && !aprilVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(aprilVal));
			count++;
			LoggerUtil.info("April Scrap: " + aprilVal);
		} else {
			LoggerUtil.info("April Scrap: Not Entered");
		}

		if (!mayVal.isEmpty() && !mayVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(mayVal));
			count++;
			LoggerUtil.info("May Scrap: " + mayVal);
		} else {
			LoggerUtil.info("May Scrap: Not Entered");
		}

		if (!juneVal.isEmpty() && !juneVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(juneVal));
			count++;
			LoggerUtil.info("June Scrap: " + juneVal);
		} else {
			LoggerUtil.info("June Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No valid Scrap values entered for Q1 months.");
			Assert.fail("❌ No values found for Q1 Scrap months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q1Val.contains(".")) {
			String decimalPart = q1Val.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q1 Scrap (UI) value (" + q1Val + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q1 Scrap value has more than 3 decimal digits: " + q1Val);
			}
		}

		BigDecimal expectedQ1Scrap = new BigDecimal(q1Val).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q1 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q1 Scrap (UI): " + expectedQ1Scrap);

		if (!expectedQ1Scrap.equals(calculatedAvg)) {
			LoggerUtil
					.mismatch("Mismatch: ❌ FAILED: Q1 Scrap - UI: " + expectedQ1Scrap + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ1Scrap, calculatedAvg,
				"Q1 Scrap verification: Expected = " + expectedQ1Scrap + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q1 Scrap: " + count);
		LoggerUtil.pass("✅ Q1 Scrap Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== Q2 Scrap ===================
	public void calculatescrapForQ2DependsOnNumberOfEntries() {
		LoggerUtil.info("🧾 Starting Q2 Scrap Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String julyVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")).getAttribute("value")
				.trim();
		String augustVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")).getAttribute("value")
				.trim();
		String septemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")).getAttribute("value")
				.trim();
		String q2ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("q2", "Scrap")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!julyVal.isEmpty() && !julyVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(julyVal));
			count++;
			LoggerUtil.info("July Scrap: " + julyVal);
		} else {
			LoggerUtil.info("July Scrap: Not Entered");
		}

		if (!augustVal.isEmpty() && !augustVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(augustVal));
			count++;
			LoggerUtil.info("August Scrap: " + augustVal);
		} else {
			LoggerUtil.info("August Scrap: Not Entered");
		}

		if (!septemberVal.isEmpty() && !septemberVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(septemberVal));
			count++;
			LoggerUtil.info("September Scrap: " + septemberVal);
		} else {
			LoggerUtil.info("September Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No valid Scrap values entered for Q2 months.");
			Assert.fail("❌ No values found for Q2 Scrap months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);

		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q2ScrapVal.contains(".")) {
			String decimalPart = q2ScrapVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q2 Scrap (UI) value (" + q2ScrapVal + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q2 Scrap value has more than 3 decimal digits: " + q2ScrapVal);
			}
		}

		BigDecimal expectedQ2Scrap = new BigDecimal(q2ScrapVal).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q2 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q2 Scrap (UI): " + expectedQ2Scrap);

		if (!expectedQ2Scrap.equals(calculatedAvg)) {
			LoggerUtil
					.mismatch("Mismatch: ❌ FAILED: Q2 Scrap - UI: " + expectedQ2Scrap + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ2Scrap, calculatedAvg,
				"Q2 Scrap verification: Expected = " + expectedQ2Scrap + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q2 Scrap: " + count);
		LoggerUtil.pass("✅ Q2 Scrap Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== Q3 Scrap ===================
	public void calculatingaveragescrapDependonNumberOfEntriesforq3() {
		LoggerUtil.info("🧾 Starting Q3 Scrap Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String octoberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")).getAttribute("value")
				.trim();
		String novemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")).getAttribute("value")
				.trim();
		String decemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")).getAttribute("value")
				.trim();
		String q3ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("q3", "Scrap")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberVal.isEmpty() && !octoberVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(octoberVal));
			count++;
			LoggerUtil.info("October Scrap: " + octoberVal);
		} else {
			LoggerUtil.info("October Scrap: Not Entered");
		}

		if (!novemberVal.isEmpty() && !novemberVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(novemberVal));
			count++;
			LoggerUtil.info("November Scrap: " + novemberVal);
		} else {
			LoggerUtil.info("November Scrap: Not Entered");
		}

		if (!decemberVal.isEmpty() && !decemberVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(decemberVal));
			count++;
			LoggerUtil.info("December Scrap: " + decemberVal);
		} else {
			LoggerUtil.info("December Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No valid Scrap values entered for Q3 months.");
			Assert.fail("❌ No values found for Q3 Scrap months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q3ScrapVal.contains(".")) {
			String decimalPart = q3ScrapVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q3 Scrap (UI) value (" + q3ScrapVal + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q3 Scrap value has more than 3 decimal digits: " + q3ScrapVal);
			}
		}

		BigDecimal expectedQ3Scrap = new BigDecimal(q3ScrapVal).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q3 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q3 Scrap (UI): " + expectedQ3Scrap);

		if (!expectedQ3Scrap.equals(calculatedAvg)) {
			LoggerUtil
					.mismatch("Mismatch: ❌ FAILED: Q3 Scrap - UI: " + expectedQ3Scrap + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ3Scrap, calculatedAvg,
				"Q3 Scrap verification: Expected = " + expectedQ3Scrap + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q3 Scrap: " + count);
		LoggerUtil.pass("✅ Q3 Scrap Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== Q4 Scrap ===================
	public void calculatingaveragescrapDependsOnNumberOfEntriesforq4() {
		LoggerUtil.info("🧾 Starting Q4 Scrap Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String janVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")).getAttribute("value").trim();
		String febVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")).getAttribute("value").trim();
		String marchVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")).getAttribute("value")
				.trim();
		String q4ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("q4", "Scrap")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!janVal.isEmpty() && !janVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(janVal));
			count++;
			LoggerUtil.info("January Scrap: " + janVal);
		} else {
			LoggerUtil.info("January Scrap: Not Entered");
		}

		if (!febVal.isEmpty() && !febVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(febVal));
			count++;
			LoggerUtil.info("February Scrap: " + febVal);
		} else {
			LoggerUtil.info("February Scrap: Not Entered");
		}

		if (!marchVal.isEmpty() && !marchVal.equalsIgnoreCase("Scrap")) {
			sum = sum.add(new BigDecimal(marchVal));
			count++;
			LoggerUtil.info("March Scrap: " + marchVal);
		} else {
			LoggerUtil.info("March Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No valid Scrap values entered for Q4 months.");
			Assert.fail("❌ No values found for Q4 Scrap months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (q4ScrapVal.contains(".")) {
			String decimalPart = q4ScrapVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: Q4 Scrap (UI) value (" + q4ScrapVal + ") has more than 3 decimal digits.");
				softAssert.fail("UI Q4 Scrap value has more than 3 decimal digits: " + q4ScrapVal);
			}
		}

		BigDecimal expectedQ4Scrap = new BigDecimal(q4ScrapVal).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated Q4 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected Q4 Scrap (UI): " + expectedQ4Scrap);

		if (!expectedQ4Scrap.equals(calculatedAvg)) {
			LoggerUtil
					.mismatch("Mismatch: ❌ FAILED: Q4 Scrap - UI: " + expectedQ4Scrap + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedQ4Scrap, calculatedAvg,
				"Q4 Scrap verification: Expected = " + expectedQ4Scrap + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for Q4 Scrap: " + count);
		LoggerUtil.pass("✅ Q4 Scrap Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== First Half Year RM ===================
	public void calculateFirstHalfYearlyAverageDependonNumberofEntries() {
		LoggerUtil.info("🧾 Starting H1 RM Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String aprilVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value").trim();
		String mayVal = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")).getAttribute("value").trim();
		String juneVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")).getAttribute("value").trim();
		String julyVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value").trim();
		String augustVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")).getAttribute("value").trim();
		String septemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")).getAttribute("value")
				.trim();
		String h1Val = waitForExpectedElement(getDynamicPeriodLocator("h1", "RM")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!aprilVal.isEmpty()) {
			sum = sum.add(new BigDecimal(aprilVal));
			count++;
			LoggerUtil.info("April RM: " + aprilVal);
		} else {
			LoggerUtil.info("April RM: Not Entered");
		}
		if (!mayVal.isEmpty()) {
			sum = sum.add(new BigDecimal(mayVal));
			count++;
			LoggerUtil.info("May RM: " + mayVal);
		} else {
			LoggerUtil.info("May RM: Not Entered");
		}
		if (!juneVal.isEmpty()) {
			sum = sum.add(new BigDecimal(juneVal));
			count++;
			LoggerUtil.info("June RM: " + juneVal);
		} else {
			LoggerUtil.info("June RM: Not Entered");
		}
		if (!julyVal.isEmpty()) {
			sum = sum.add(new BigDecimal(julyVal));
			count++;
			LoggerUtil.info("July RM: " + julyVal);
		} else {
			LoggerUtil.info("July RM: Not Entered");
		}
		if (!augustVal.isEmpty()) {
			sum = sum.add(new BigDecimal(augustVal));
			count++;
			LoggerUtil.info("August RM: " + augustVal);
		} else {
			LoggerUtil.info("August RM: Not Entered");
		}
		if (!septemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(septemberVal));
			count++;
			LoggerUtil.info("September RM: " + septemberVal);
		} else {
			LoggerUtil.info("September RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for H1 months.");
			Assert.fail("❌ No values found for H1 RM months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (h1Val.contains(".")) {
			String decimalPart = h1Val.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: H1 RM (UI) value (" + h1Val + ") has more than 3 decimal digits.");
				softAssert.fail("UI H1 RM value has more than 3 decimal digits: " + h1Val);
			}
		}

		BigDecimal expectedH1Val = new BigDecimal(h1Val).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated H1 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected H1 RM (UI): " + expectedH1Val);

		if (!expectedH1Val.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: H1 RM - UI: " + expectedH1Val + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedH1Val, calculatedAvg,
				"H1 RM verification: Expected = " + expectedH1Val + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for H1 RM: " + count);
		LoggerUtil.pass("✅ H1 RM Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== Half Year Scrap ===================
	public void calculateHalfYearlyAverageForScrapDependsOnNumberOfEntries() {
		LoggerUtil.info("🧾 Starting H1 Scrap Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String aprilVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")).getAttribute("value")
				.trim();
		String mayVal = waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")).getAttribute("value").trim();
		String juneVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")).getAttribute("value")
				.trim();
		String julyVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")).getAttribute("value")
				.trim();
		String augustVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")).getAttribute("value")
				.trim();
		String septemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")).getAttribute("value")
				.trim();
		String h1ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("h1", "Scrap")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!aprilVal.isEmpty()) {
			sum = sum.add(new BigDecimal(aprilVal));
			count++;
			LoggerUtil.info("April Scrap: " + aprilVal);
		} else {
			LoggerUtil.info("April Scrap: Not Entered");
		}
		if (!mayVal.isEmpty()) {
			sum = sum.add(new BigDecimal(mayVal));
			count++;
			LoggerUtil.info("May Scrap: " + mayVal);
		} else {
			LoggerUtil.info("May Scrap: Not Entered");
		}
		if (!juneVal.isEmpty()) {
			sum = sum.add(new BigDecimal(juneVal));
			count++;
			LoggerUtil.info("June Scrap: " + juneVal);
		} else {
			LoggerUtil.info("June Scrap: Not Entered");
		}
		if (!julyVal.isEmpty()) {
			sum = sum.add(new BigDecimal(julyVal));
			count++;
			LoggerUtil.info("July Scrap: " + julyVal);
		} else {
			LoggerUtil.info("July Scrap: Not Entered");
		}
		if (!augustVal.isEmpty()) {
			sum = sum.add(new BigDecimal(augustVal));
			count++;
			LoggerUtil.info("August Scrap: " + augustVal);
		} else {
			LoggerUtil.info("August Scrap: Not Entered");
		}
		if (!septemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(septemberVal));
			count++;
			LoggerUtil.info("September Scrap: " + septemberVal);
		} else {
			LoggerUtil.info("September Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for H1 months.");
			Assert.fail("❌ No values found for H1 Scrap months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (h1ScrapVal.contains(".")) {
			String decimalPart = h1ScrapVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: H1 Scrap (UI) value (" + h1ScrapVal + ") has more than 3 decimal digits.");
				softAssert.fail("UI H1 Scrap value has more than 3 decimal digits: " + h1ScrapVal);
			}
		}

		BigDecimal expectedH1Scrap = new BigDecimal(h1ScrapVal).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated H1 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected H1 Scrap (UI): " + expectedH1Scrap);

		if (!expectedH1Scrap.equals(calculatedAvg)) {
			LoggerUtil
					.mismatch("Mismatch: ❌ FAILED: H1 Scrap - UI: " + expectedH1Scrap + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedH1Scrap, calculatedAvg,
				"H1 Scrap verification: Expected = " + expectedH1Scrap + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for H1 Scrap: " + count);
		LoggerUtil.pass(" H1 Scrap Average Calculation Completed.");

		softAssert.assertAll();
	}

//=================== Second Half Year RM ===================
	public void secondHalfYearlyAverageCalculationForRm() {
		LoggerUtil.info("🧾 Starting H2 RM Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String octoberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")).getAttribute("value")
				.trim();
		String novemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")).getAttribute("value")
				.trim();
		String decemberVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")).getAttribute("value")
				.trim();
		String januaryVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")).getAttribute("value")
				.trim();
		String februaryVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")).getAttribute("value")
				.trim();
		String marchVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value").trim();
		String h2RmVal = waitForExpectedElement(getDynamicPeriodLocator("h2", "RM")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(octoberVal));
			count++;
			LoggerUtil.info("October RM: " + octoberVal);
		} else {
			LoggerUtil.info("October RM: Not Entered");
		}
		if (!novemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(novemberVal));
			count++;
			LoggerUtil.info("November RM: " + novemberVal);
		} else {
			LoggerUtil.info("November RM: Not Entered");
		}
		if (!decemberVal.isEmpty()) {
			sum = sum.add(new BigDecimal(decemberVal));
			count++;
			LoggerUtil.info("December RM: " + decemberVal);
		} else {
			LoggerUtil.info("December RM: Not Entered");
		}
		if (!januaryVal.isEmpty()) {
			sum = sum.add(new BigDecimal(januaryVal));
			count++;
			LoggerUtil.info("January RM: " + januaryVal);
		} else {
			LoggerUtil.info("January RM: Not Entered");
		}
		if (!februaryVal.isEmpty()) {
			sum = sum.add(new BigDecimal(februaryVal));
			count++;
			LoggerUtil.info("February RM: " + februaryVal);
		} else {
			LoggerUtil.info("February RM: Not Entered");
		}
		if (!marchVal.isEmpty()) {
			sum = sum.add(new BigDecimal(marchVal));
			count++;
			LoggerUtil.info("March RM: " + marchVal);
		} else {
			LoggerUtil.info("March RM: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No RM values entered for H2 months.");
			Assert.fail("❌ No values found for H2 RM months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (h2RmVal.contains(".")) {
			String decimalPart = h2RmVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: H2 RM (UI) value (" + h2RmVal + ") has more than 3 decimal digits.");
				softAssert.fail("UI H2 RM value has more than 3 decimal digits: " + h2RmVal);
			}
		}

		BigDecimal expectedH2Val = new BigDecimal(h2RmVal).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated H2 RM Average: " + calculatedAvg);
		LoggerUtil.info("Expected H2 RM (UI): " + expectedH2Val);

		if (!expectedH2Val.equals(calculatedAvg)) {
			LoggerUtil.mismatch("Mismatch: ❌ FAILED: H2 RM - UI: " + expectedH2Val + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedH2Val, calculatedAvg,
				"H2 RM verification: Expected = " + expectedH2Val + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for H2 RM: " + count);
		LoggerUtil.pass("✅ H2 RM Average Calculation Completed.");

		softAssert.assertAll();
	}

/////////////////////////////////////////Dynamic Period Locators/////////////////////////////////////////////////////////////	

	public static By getDynamicPeriodLocator(String period, String type) {
		try {
			// Normalize base id — only first part in lowercase
			String id = type.equalsIgnoreCase("Scrap") ? period.toLowerCase() + "Scrap" : period.toLowerCase();

			// Build and return XPath dynamically
			String xpath = String.format("//input[@id='%s']", id);
			return By.xpath(xpath);

		} catch (Exception e) {
			LoggerUtil.error("Invalid period/type for dynamic locator → " + e.getMessage());
			throw e;
		}
	}

	public void secondHalfYearlyAverageScrapValueforDependOnNumberOfEntries() {
		LoggerUtil.info("🧾 Starting H2 Scrap Average Calculation...");

		SoftAssert softAssert = new SoftAssert();

		String octoberScrapVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap"))
				.getAttribute("value").trim();
		String novemberScrapVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap"))
				.getAttribute("value").trim();
		String decemberScrapVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap"))
				.getAttribute("value").trim();
		String januaryScrapVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap"))
				.getAttribute("value").trim();
		String februaryScrapVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap"))
				.getAttribute("value").trim();
		String marchScrapVal = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")).getAttribute("value")
				.trim();
		String h2ScrapVal = waitForExpectedElement(getDynamicPeriodLocator("h2", "Scrap")).getAttribute("value").trim();

		BigDecimal sum = BigDecimal.ZERO;
		int count = 0;

		if (!octoberScrapVal.isEmpty()) {
			sum = sum.add(new BigDecimal(octoberScrapVal));
			count++;
			LoggerUtil.info("October Scrap: " + octoberScrapVal);
		} else {
			LoggerUtil.info("October Scrap: Not Entered");
		}
		if (!novemberScrapVal.isEmpty()) {
			sum = sum.add(new BigDecimal(novemberScrapVal));
			count++;
			LoggerUtil.info("November Scrap: " + novemberScrapVal);
		} else {
			LoggerUtil.info("November Scrap: Not Entered");
		}
		if (!decemberScrapVal.isEmpty()) {
			sum = sum.add(new BigDecimal(decemberScrapVal));
			count++;
			LoggerUtil.info("December Scrap: " + decemberScrapVal);
		} else {
			LoggerUtil.info("December Scrap: Not Entered");
		}
		if (!januaryScrapVal.isEmpty()) {
			sum = sum.add(new BigDecimal(januaryScrapVal));
			count++;
			LoggerUtil.info("January Scrap: " + januaryScrapVal);
		} else {
			LoggerUtil.info("January Scrap: Not Entered");
		}
		if (!februaryScrapVal.isEmpty()) {
			sum = sum.add(new BigDecimal(februaryScrapVal));
			count++;
			LoggerUtil.info("February Scrap: " + februaryScrapVal);
		} else {
			LoggerUtil.info("February Scrap: Not Entered");
		}
		if (!marchScrapVal.isEmpty()) {
			sum = sum.add(new BigDecimal(marchScrapVal));
			count++;
			LoggerUtil.info("March Scrap: " + marchScrapVal);
		} else {
			LoggerUtil.info("March Scrap: Not Entered");
		}

		if (count == 0) {
			LoggerUtil.mismatch("Mismatch: ❌ No Scrap values entered for H2 months.");
			Assert.fail("❌ No values found for H2 Scrap months.");
		}

		LoggerUtil.info("Dividing total sum by number of valid entries: " + count);
		BigDecimal calculatedAvg = sum.divide(new BigDecimal(count), 3, RoundingMode.HALF_UP);

		if (h2ScrapVal.contains(".")) {
			String decimalPart = h2ScrapVal.split("\\.")[1];
			if (decimalPart.length() > 3) {
				LoggerUtil.mismatch(
						"Mismatch: ❌ FAILED: H2 Scrap (UI) value (" + h2ScrapVal + ") has more than 3 decimal digits.");
				softAssert.fail("UI H2 Scrap value has more than 3 decimal digits: " + h2ScrapVal);
			}
		}

		BigDecimal expectedH2Scrap = new BigDecimal(h2ScrapVal).setScale(3, RoundingMode.HALF_UP);

		LoggerUtil.info("Calculated H2 Scrap Average: " + calculatedAvg);
		LoggerUtil.info("Expected H2 Scrap (UI): " + expectedH2Scrap);

		if (!expectedH2Scrap.equals(calculatedAvg)) {
			LoggerUtil
					.mismatch("Mismatch: ❌ FAILED: H2 Scrap - UI: " + expectedH2Scrap + ", Expected: " + calculatedAvg);
		}

		Base.softAssertBigDecimalZeroOrExact(softAssert, expectedH2Scrap, calculatedAvg,
				"H2 Scrap verification: Expected = " + expectedH2Scrap + ", Calculated = " + calculatedAvg);

		LoggerUtil.info("Total Valid Entries for H2 Scrap: " + count);
		LoggerUtil.pass("✅ H2 Scrap Average Calculation Completed.");

		softAssert.assertAll();
	}

	public void savedataforverifyingcaryforwardDelta(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String searchdate)
			throws InterruptedException {

		Thread.sleep(5000);

		
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);

		for (WebElement grpclasslistval : grpclasslist) {

			String comclssifi = grpclasslistval.getText().trim();

			if (comclssifi.equalsIgnoreCase(searchcommodityclassification))
				;
			{
				grpclasslistval.click();

				System.out.println(searchcommodityclassification);
				break;
			}

		}
		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {

			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue))
				;
			{

				comgradelistval.click();
				break;
			}

		}
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, searchdate);
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	public void updateOnlyYearAndSave(String year) throws InterruptedException {
		// Open year dropdown
		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		// Enter year and select
		WebElement yearSearchBox = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearSearchBox, year);
		yearSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// Click Save
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);
	}

	public static final By tensilestrength = By.xpath("//*[@id='tensileStrength']");
	public static final By shearstrength = By.xpath("//*[@id='ShearStrength']");

	public void savedataforforIBeamvalueinShapeDropdown(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		LoggerUtil.info("Opening Commodity dropdown to select value: " + searchcommoditydropvalue);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		LoggerUtil.info("Entered value in Commodity search box: " + searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				LoggerUtil.pass("Selected Commodity: " + flagcomgrpval);
				comgrpvalue.click();
				break;
			}
		}

		Thread.sleep(3000);
		LoggerUtil.info("Opening Group Classification dropdown to select: " + searchcommodityclassification);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				LoggerUtil.pass("Selected Group Classification: " + comclssifi);
				grpclasslistval.click();
				break;
			}
		}

		Thread.sleep(3000);
		LoggerUtil.info("Opening Specific Grade dropdown to select: " + selectcommoditygradevalue);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				LoggerUtil.pass("Selected Specific Grade: " + comgrade);
				comgradelistval.click();
				break;
			}
		}

		LoggerUtil.info("Selecting UOM = Mtr");
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.pass("UOM selected as Mtr");

		LoggerUtil.info("Selecting Shape = I-beam");
		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "I-beam");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.pass("Shape selected as I-beam");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		Thread.sleep(4000);
		LoggerUtil.info("Selecting Year = 2025-2026");
		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.pass("Year selected: 2025-2026");
		Thread.sleep(3000);

		LoggerUtil.info("Opening Business Segment selection.");
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Searched for Business Segment: rishi");
		Thread.sleep(4000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.pass("All Business Segment checkboxes selected");

		Thread.sleep(4000);
		clickOnElement(customercheckbox);
		LoggerUtil.pass("Customer checkbox selected successfully");
	}



	public void enterparametevalueorsizeforibeam(String lengthvalue, String widthvalue, String heightvalue,
			String webthickness, String flangthickness, String searchvalue) throws InterruptedException {
		LoggerUtil.info("===== I-BEAM PARAMETER ENTRY AND VALIDATION STARTED =====");

// ✅ STEP 1: Wait for Table & Validate
		WebElement table = waitForExpectedElement(By.id("shapeParamTable"));
		if (table == null || !table.isDisplayed()) {
			LoggerUtil.fail("❌ I-Beam parameter table not visible!");
			Assert.fail("I-Beam parameter table not found or not visible.");
		}
		LoggerUtil.pass("✅ I-Beam shape parameter table is visible.");

		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		LoggerUtil.info("📊 Total Parameter Rows Found: " + rows.size());
		Assert.assertTrue(rows.size() > 0, "❌ No parameter rows found in shapeParamTable.");

// ✅ STEP 2: Dynamically enter all parameter values
		enterShapeParameterValue("Length", lengthvalue);
		enterShapeParameterValue("Width", widthvalue);
		enterShapeParameterValue("Height", heightvalue);
		enterShapeParameterValue("Web thickness", webthickness);
		enterShapeParameterValue("Flange thickness", flangthickness);

// ✅ STEP 3: Save operation
		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.pass("💾 Clicked Save button for I-Beam parameters.");
		Thread.sleep(6000);

// ✅ STEP 4: View operation
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("🔍 Clicked View button to verify saved I-Beam entry.");
		Thread.sleep(5000);

// ✅ STEP 5: Search for the saved record dynamically in the View table
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), searchvalue);
		LoggerUtil.info("🔎 Searching for saved I-Beam record: " + searchvalue);
		Thread.sleep(4000);

// ✅ STEP 6: Verify at least one matching row is found dynamically
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='comodityDetailListTable']//tbody/tr"));
		if (tableRows.isEmpty()) {
			LoggerUtil.fail("❌ No rows found in View table for search value: " + searchvalue);
			Assert.fail("No matching I-Beam record found for: " + searchvalue);
		}
		LoggerUtil.pass("✅ Matching I-Beam record found in View table.");

// ✅ STEP 7: Dynamically click Edit on the matched row
		boolean recordFound = false;
		for (WebElement row : tableRows) {
			String fullRowText = row.getText().trim();
			if (fullRowText.contains(searchvalue)) {
				WebElement editButton = row.findElement(By.xpath(".//a[i[contains(@class,'fa-edit')]]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
				LoggerUtil.pass("🖊️ Clicked Edit button for I-Beam record: " + searchvalue);
				recordFound = true;
				break;
			}
		}

		if (!recordFound) {
			LoggerUtil.fail("❌ Edit button not found for record: " + searchvalue);
			Assert.fail("Unable to locate Edit button for record: " + searchvalue);
		}

		Thread.sleep(7000);

// ✅ STEP 8: After edit, dynamically fetch and validate each parameter value
		LoggerUtil.info("Verifying I-Beam parameter values after reopening edit...");

		verifyParameterValue("Length", lengthvalue);
		verifyParameterValue("Width", widthvalue);
		verifyParameterValue("Height", heightvalue);
		verifyParameterValue("Web thickness", webthickness);
		verifyParameterValue("Flange thickness", flangthickness);

		LoggerUtil.pass("✅ All I-Beam parameter values matched successfully after reopening edit.");

		LoggerUtil.info("===== I-BEAM PARAMETER VALIDATION COMPLETED SUCCESSFULLY =====");
	}

	// 🔹 Enter value dynamically based on parameter name
	// 🔹 Track entered rows count
	private static int enteredParameterCount = 0;

	// 🔹 Enter values for all rows
	public static void enterShapeParameterValue(String parameterName, String valueToEnter) {
	    try {
	        String xpath = String.format(
	            "//*[@id='shapeParamTable']//tr[td[contains(normalize-space(.), '%s')]]//td[2]//input",
	            parameterName);

	        List<WebElement> inputs = driver.findElements(By.xpath(xpath));
	        LoggerUtil.info("🔍 Found " + inputs.size() + " input(s) for parameter: " + parameterName);

	        if (inputs.isEmpty()) {
	            LoggerUtil.fail("❌ No input found for parameter: " + parameterName);
	            Assert.fail("No input element found for parameter: " + parameterName);
	        }

	        for (int i = 0; i < inputs.size(); i++) {
	            WebElement input = inputs.get(i);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
	            for (int t = 0; t < 3; t++) {
	                if (input.isDisplayed()) break;
	                Thread.sleep(500);
	            }

	            clearAndEnterText(input, valueToEnter);
	            LoggerUtil.pass("✏️ Entered '" + valueToEnter + "' for parameter '" + parameterName 
	                            + "' in Row " + (i + 1));
	        }

	        enteredParameterCount = inputs.size();
	        LoggerUtil.info("✅ Stored enteredParameterCount = " + enteredParameterCount 
	                        + " for parameter '" + parameterName + "'");

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Failed to enter value for '" + parameterName + "' → " + e.getMessage());
	        Assert.fail("Unable to enter value for parameter: " + parameterName);
	    }
	}


	// 🔹 Verify all rows with full soft-assert logic and row count validation
	public static void verifyParameterValue(String parameterName, String expectedValue) {
	    SoftAssert soft = new SoftAssert();

	    try {
	        String xpath = String.format(
	            "//*[@id='shapeParamTable']//tr[td[contains(normalize-space(.), '%s')]]//td[2]//input",
	            parameterName);

	        List<WebElement> inputs = driver.findElements(By.xpath(xpath));
	        int currentRowCount = inputs.size();

	        LoggerUtil.info("📋 Verifying " + currentRowCount + " row(s) for parameter: " + parameterName);

	        // 🔸 Row count validation
	        if (enteredParameterCount > 0 && currentRowCount != enteredParameterCount) {
	            LoggerUtil.mismatch("⚠️ Row count mismatch for '" + parameterName 
	                + "' → Entered: " + enteredParameterCount + ", Found: " + currentRowCount);
	            soft.fail("Row count mismatch → Entered: " + enteredParameterCount + ", Found: " + currentRowCount);
	        }

	        if (inputs.isEmpty()) {
	            LoggerUtil.fail("❌ No rows found for parameter during verification: " + parameterName);
	            soft.fail("No input found for verification: " + parameterName);
	        }

	        for (int i = 0; i < inputs.size(); i++) {
	            WebElement input = inputs.get(i);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
	            Thread.sleep(200);

	            String actualValue = input.getAttribute("value").trim();

	            // Normalize numeric format (e.g., 300 vs 300.0000)
	            String formattedActual = actualValue.replaceAll("\\.0+$", "").replaceAll("(\\.\\d*?)0+$", "$1");

	            LoggerUtil.info("Row " + (i + 1) + " → " + parameterName 
	                            + " | Expected: " + expectedValue 
	                            + " | Actual: " + actualValue);

	            if (formattedActual.equals(expectedValue.trim())) {
	                LoggerUtil.pass("✅ Row " + (i + 1) + ": " + parameterName + " matched correctly.");
	            } else {
	                LoggerUtil.mismatch("❌ Row " + (i + 1) + ": " + parameterName 
	                    + " mismatch → Expected: " + expectedValue + ", Actual: " + actualValue);
	                soft.fail("Mismatch in " + parameterName + " at Row " + (i + 1) 
	                    + " → Expected: " + expectedValue + ", Actual: " + actualValue);
	            }
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Error verifying '" + parameterName + "' → " + e.getMessage());
	        soft.fail("Failed to verify parameter: " + parameterName);
	    }

	    soft.assertAll();
	}


	public static final By resetbtn = By.xpath("//*[@id='tab3Reset']/i");
	public static final By searchbusinessSegment = By
			.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/div/div/input");

	public void verifysavedatawithdifferentshapeoption(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		Thread.sleep(3000);
		clickOnElement(resetbtn);

	
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);

		for (WebElement grpclasslistval : grpclasslist) {

			String comclssifi = grpclasslistval.getText().trim();

			if (comclssifi.equalsIgnoreCase(searchcommodityclassification))
				;
			{
				grpclasslistval.click();

				System.out.println(searchcommodityclassification);
				break;
			}

		}
		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {

			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue))
				;
			{

				comgradelistval.click();
				break;
			}

		}
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Cylinder");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchbusinessSegment), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);

	}

	public void savedatainthirdtabforsamedifferentshape(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalue)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		LoggerUtil.info("Entering commodity dropdown value: " + searchcommoditydropvalue);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				LoggerUtil.info("Selected Commodity: " + flagcomgrpval);
				comgrpvalue.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);
		LoggerUtil.info("Selecting Group Classification: " + searchcommodityclassification);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Shape: Sheet");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Year: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected All Business Segment Checkboxes");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save");
		Thread.sleep(4000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked View");
		Thread.sleep(6000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		LoggerUtil.info("Searched for saved data using value: " + entersearchvalue);
		Thread.sleep(3000);

		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		LoggerUtil.info("Clicked Edit for verification");
		Thread.sleep(7000);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch1 = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch1, "Cylinder");
		shapesearch1.sendKeys(Keys.ENTER);
		LoggerUtil.info("Changed Shape from Sheet to Cylinder");
		Thread.sleep(5000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save after changing shape to Cylinder");
	}

	public void savedatainthirdtabforexistingvalue(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalue)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity dropdown");

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		LoggerUtil.info("Entered commodity value in dropdown search: " + searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				LoggerUtil.info("Matching commodity group found: " + flagcomgrpval);
				comgrpvalue.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown");
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				grpclasslistval.click();
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		LoggerUtil.info("Clicked on Specific Grade dropdown");
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				comgradelistval.click();
				break;
			}
		}

		clickOnElement(Uomdropdown);
		LoggerUtil.info("Clicked on UOM dropdown");
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		LoggerUtil.info("Clicked on Shape dropdown");
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Shape as: Sheet");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		clickOnElement(selectyeardrop);
		LoggerUtil.info("Clicked on Year dropdown");
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		LoggerUtil.info("Clicked on Business Segment box");
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all Business Segment checkboxes");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer checkbox");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save button on Third Tab");
		Thread.sleep(4000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View to verify data");
		Thread.sleep(6000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		LoggerUtil.info("Searched for saved entry using: " + entersearchvalue);
		Thread.sleep(3000);

		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		LoggerUtil.info("Clicked Edit to re-save with same value");
		Thread.sleep(7000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save again with same existing value");
	}

	public static final By firstpropvalofplasticprop = By.xpath("//*[@id='ForPlastic']/div[1]/div[1]/label");
	public static final By secondpropvalueofplastic = By.xpath("//*[@id='ForPlastic']/div[2]/div[1]/label");
	public static final By thirdpropvalyueofplastic = By.xpath("//*[@id='ForPlastic']/div[3]/div[1]/label");

	public void verifyplasticpropertyVisibility() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		LoggerUtil.info("Opening Commodity dropdown.");
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		LoggerUtil.info("Entering 'Plastics' in commodity dropdown search.");
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), "Plastics");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(commoditydropdownlist));
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);

		for (WebElement item : comlist) {
			String itemText = item.getText().trim();
			if (itemText.equalsIgnoreCase("Plastics")) {
				LoggerUtil.info("Selecting commodity: " + itemText);
				item.click();
				break;
			}
		}

		String expectedvalue1 = "Select Process*";
		String expectedvalue2 = "Cylinder Deg C*";
		String expectedvalue3 = "Mould Deg C*";

		LoggerUtil.info("Waiting for plastic-specific properties to be visible.");
		WebElement plasticProp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(firstpropvalofplasticprop));
		WebElement plasticProp2 = wait.until(ExpectedConditions.visibilityOfElementLocated(secondpropvalueofplastic));
		WebElement plasticProp3 = wait.until(ExpectedConditions.visibilityOfElementLocated(thirdpropvalyueofplastic));

		String actualvalue1 = plasticProp1.getText().trim();
		String actualvalue2 = plasticProp2.getText().trim();
		String actualvalue3 = plasticProp3.getText().trim();

		LoggerUtil.info("Expected: " + expectedvalue1 + " | Actual: " + actualvalue1);
		LoggerUtil.info("Expected: " + expectedvalue2 + " | Actual: " + actualvalue2);
		LoggerUtil.info("Expected: " + expectedvalue3 + " | Actual: " + actualvalue3);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualvalue1, expectedvalue1, "First plastic property label mismatch.");
		softAssert.assertEquals(actualvalue2, expectedvalue2, "Second plastic property label mismatch.");
		softAssert.assertEquals(actualvalue3, expectedvalue3, "Third plastic property label mismatch.");

		LoggerUtil.pass("All plastic-specific property labels validated successfully.");
		softAssert.assertAll();
	}

	public static final By clickaddsupplier = By.xpath("//*[@id='addNewSupplier']/span");
	public static final By entersuppcodeval = By.xpath("//*[@id='SupplierCode']");
	public static final By entersuppnameval = By.xpath("//*[@id='SupplierName']");
	public static final By clickbusinessSegdrop = By
			.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/button/span");
	public static final By enterbusinessSegvalue = By
			.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/div/div/input");
	public static final By selectallcheckboxforbusinessSegAdd = By
			.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/div/button[1]/span/input[@type='checkbox']");
	public static final By addsuppsavebtn = By.xpath("//*[@id='supplierSave']");
	public static final By crossbtninaddcommoditypopup = By
			.xpath("//*[@id='addNewSupplierModel']/div/div/div[1]/button");

	public void addnewsupplierandsaveandverifyresetbtn(String entersupcode, String entersupname)
			throws InterruptedException {

		LoggerUtil.info("Clicking on 'Add Supplier' button.");
		clickOnElement(clickaddsupplier);
		Thread.sleep(2000);

		LoggerUtil.info("Entering Supplier Code: " + entersupcode);
		clearAndEnterText(waitForExpectedElement(entersuppcodeval), entersupcode);

		LoggerUtil.info("Entering Supplier Name: " + entersupname);
		clearAndEnterText(waitForExpectedElement(entersuppnameval), entersupname);

		LoggerUtil.info("Clicking on Business Segment dropdown.");
		clickOnElement(clickbusinessSegdrop);
		Thread.sleep(3000);

		LoggerUtil.info("Searching and selecting Business Segment: plastic");
		clearAndEnterText(waitForExpectedElement(enterbusinessSegvalue), "plastic");
		Thread.sleep(4000);
		clickOnElement(selectallcheckboxforbusinessSegAdd);

		LoggerUtil.info("Clicking Save button to save new supplier.");
		clickOnElement(addsuppsavebtn);
		Thread.sleep(2000);

		LoggerUtil.info("Clicking Cross button to close the supplier popup.");
		clickOnElement(crossbtninaddcommoditypopup);
	}

	public static final By fetchsuppleirlist = By.xpath("//table[@id='rmSupplier']/tbody/tr");

	public void verifynewsupplierinmainpagewithoutrefreshingAfteraddnewsupp(String expectedSupplier)
			throws InterruptedException {
		LoggerUtil.info("Clicking on Business Segment Box.");
		clickOnElement(businessSegbox);

		LoggerUtil.info("Entering Business Segment search text: plastic");
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "plastic");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		LoggerUtil.info("Waiting for select all checkbox to become clickable.");
		wait.until(ExpectedConditions.elementToBeClickable(selectallcheckboxInbusinsessSeg));
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Clicked on Select All checkbox in Business Segment.");

		LoggerUtil.info("Waiting for supplier list to be populated.");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fetchsuppleirlist));
		List<WebElement> supplierRows = driver.findElements(fetchsuppleirlist);

		boolean found = false;
		for (WebElement row : supplierRows) {
			String actualSupplier = row.getText().trim();
			LoggerUtil.info("Verifying supplier: " + actualSupplier);
			if (actualSupplier.contains(expectedSupplier)) {
				LoggerUtil.pass("✅ Supplier found without refresh: " + actualSupplier);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.mismatch("❌ Expected supplier not found in dropdown: " + expectedSupplier);
		}

		Assert.assertTrue(found, "Expected supplier '" + expectedSupplier + "' was not found in the dropdown list.");
	}

	public static final By toastmsgforaddsupp = By.xpath("//*[@id='toast-container']/div/div[2]");

	public static void verifySavenewsupplierpromptnotification(String entersupcode, String entersupname,
			String expectedToastMessage) throws InterruptedException {

		LoggerUtil.info("Opening Add Supplier popup.");
		clickOnElement(clickaddsupplier);
		Thread.sleep(2000);

		LoggerUtil.info("Entering Supplier Code: " + entersupcode);
		clearAndEnterText(waitForExpectedElement(entersuppcodeval), entersupcode);

		LoggerUtil.info("Entering Supplier Name: " + entersupname);
		clearAndEnterText(waitForExpectedElement(entersuppnameval), entersupname);

		LoggerUtil.info("Clicking Business Segment dropdown.");
		clickOnElement(clickbusinessSegdrop);
		Thread.sleep(6000);

		LoggerUtil.info("Entering Business Segment value: plastic");
		clearAndEnterText(waitForExpectedElement(enterbusinessSegvalue), "plastic");
		Thread.sleep(4000);

		LoggerUtil.info("Selecting all checkboxes for Business Segment.");
		clickOnElement(selectallcheckboxforbusinessSegAdd);
		Thread.sleep(3000);

		LoggerUtil.info("Clicking Save button for new supplier.");
		clickOnElement(addsuppsavebtn);
		Thread.sleep(2000);

		String actualToast = waitForExpectedElement(toastmsgforaddsupp).getText().trim();
		LoggerUtil.info("Captured toast message: " + actualToast);

		if (actualToast.equals(expectedToastMessage)) {
			LoggerUtil.pass("✅ Supplier save prompt matched: " + actualToast);
		} else {
			LoggerUtil.mismatch(
					"❌ Supplier save prompt mismatch. Expected: " + expectedToastMessage + ", Actual: " + actualToast);
		}

		Assert.assertEquals(actualToast, expectedToastMessage, "Supplier save notification mismatch.");
	}

	public static void VerifyAllDataSaveAsItIsInExcelFileOrNot(String enteraprilrm, String enteraprilscrap,
			String entermayrm, String entermayscrap, String enterjunerm, String enterjunescrap, String enterjulyrm,
			String enterjulyscrap, String enteraugustrm, String enteraugscrap, String enterseptemrm,
			String entersepscrap, String enetroctrm, String enteroctscrap, String enternovrm, String enternovscrap,
			String enterdecrm, String enterdecscrap, String enetrjanram, String enterjanscrap, String enterfebrm,
			String enterfebscrap, String entermarchrm, String entermarchscrap) throws InterruptedException {
		// Q1
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), enteraprilrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), enteraprilscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")), entermayrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "Scrap")), entermayscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "RM")), enterjunerm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jun", "Scrap")), enterjunescrap);

		// Q2
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")), enterjulyrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "Scrap")), enterjulyscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "RM")), enteraugustrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Aug", "Scrap")), enteraugscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "RM")), enterseptemrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Sep", "Scrap")), entersepscrap);

		// Q3
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "RM")), enetroctrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Oct", "Scrap")), enteroctscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "RM")), enternovrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Nov", "Scrap")), enternovscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "RM")), enterdecrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Dec", "Scrap")), enterdecscrap);

		// Q4
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "RM")), enetrjanram);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap")), enterjanscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "RM")), enterfebrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Feb", "Scrap")), enterfebscrap);

		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")), entermarchrm);
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "Scrap")), entermarchscrap);

		clickOnElement(businessSegbox);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(6000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(4000);

	}

	public static BigDecimal calculateAverageFromFilledValues(String... values) {
		BigDecimal total = BigDecimal.ZERO;
		int validCount = 0;

		for (String val : values) {
			if (val != null && !val.trim().isEmpty()) {
				try {
					BigDecimal num = new BigDecimal(val.trim());
					total = total.add(num);
					validCount++;
				} catch (NumberFormatException e) {
					LoggerUtil.error("Invalid numeric value found: " + val);
				}
			}
		}

		if (validCount == 0) {
			LoggerUtil.error("No valid entries found for averaging.");
			return BigDecimal.ZERO;
		}

		return total.divide(new BigDecimal(validCount), 3, RoundingMode.HALF_UP);
	}

	// ---------- Locators ----------
	public static final By ClickingExportAndImportBtn = By
			.xpath("//div[@class='btn-group']/button[@onclick='bindExportTypeList()']");
	public static final By commodityDropdownBtn = By.xpath("//*[@id='comoditygrp']/span/div/button/span");
	public static final By commoditySearchInput = By.xpath("//*[@id='comoditygrp']/span/div/div/div/input");
	public static final By clickselectallcommoditygrp = By
			.xpath("//*[@id=\"comoditygrp\"]/span/div/div/button[1]/span/input[@type='checkbox']");
	public static final By groupClassificationDropdownBtn = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/button");
	public static final By classificationSearchInput = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/div/div/input");
	public static final By clickselectallgrpclassification = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/div/button[1]/span/input[@type='checkbox']");
	public static final By exportExcelBtn = By.xpath("//*[@id='exportModal']/div/div/div[3]/button");

	// ---------- Method ----------
	public static void exportExcelFileUsingEnterKey(String commoditySearchValue, String classificationSearchValue)
			throws InterruptedException {
		// Step 1: Open Export modal
		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(1000);

		// Step 2: Select Commodity Group using ENTER
		clickOnElement(commodityDropdownBtn);
		WebElement commodityInput = waitForExpectedElement(commoditySearchInput);
		commodityInput.clear();
		commodityInput.sendKeys(commoditySearchValue);
		Thread.sleep(500); // allow dropdown to refresh
		commodityInput.sendKeys(Keys.ENTER);
		System.out.println("✅ Commodity selected via ENTER: " + commoditySearchValue);
		clickOnElement(clickselectallcommoditygrp);
		// Step 3: Select Classification using ENTER
		clickOnElement(groupClassificationDropdownBtn);
		WebElement classificationInput = waitForExpectedElement(classificationSearchInput);
		classificationInput.clear();
		classificationInput.sendKeys(classificationSearchValue);
		Thread.sleep(500);
		classificationInput.sendKeys(Keys.ENTER);
		System.out.println("✅ Classification selected via ENTER: " + classificationSearchValue);
		clickOnElement(clickselectallgrpclassification);
		// Step 4: Export Excel
		Thread.sleep(1000);
		clickOnElement(exportExcelBtn);
		System.out.println("📁 Export Excel button clicked.");
		Thread.sleep(15000);
	}

	// 0801-Celesta
	public static final By searchsuppliername = By.xpath("//*[@id='supplierDiv']/div[2]/div/span/div/div/div/input");
	public static final By clickOnsuppdropbox = By
			.xpath("//*[@id='supplierDiv']/div[2]/div/span/div/button[@type='button']");
	public static final By newgradeadditionradiobtn = By.xpath("//*[@id='NewGradeadd']");
	public static final By clickselectallcheckbox = By
			.xpath("//*[@id=\"supplierDiv\"]/div[2]/div/span/div/div/button[1]/span/input[@type='checkbox']");

	public void clickexportbuttonForaddnewgradeaddtion() throws InterruptedException {
		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(1000);
		clickOnElement(newgradeadditionradiobtn);
		Thread.sleep(200);
		clickOnElement(clickOnsuppdropbox);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchsuppliername), "0801-Celesta");
		Thread.sleep(500);
		clickOnElement(clickselectallcheckbox);
		Thread.sleep(1000);
		clickOnElement(exportExcelBtn);
		Thread.sleep(20000);
	}

	public String getLatestNewSpecificGradeAdditionFilePath() {
		String downloadPath = System.getProperty("user.dir") + "\\downloads";
		File dir = new File(downloadPath);

		File[] matchingFiles = dir.listFiles(
				(d, name) -> name.startsWith("Commodity master yearly-New grades") && name.endsWith(".xlsx"));

		if (matchingFiles == null || matchingFiles.length == 0) {
			System.out.println("No matching 'New Specific Grade Addition' files found in: " + downloadPath);
			return null;
		}

		File latestFile = matchingFiles[0];
		for (File file : matchingFiles) {
			if (file.lastModified() > latestFile.lastModified()) {
				latestFile = file;
			}
		}

		System.out.println("Latest Grade Addition File: " + latestFile.getName());
		return latestFile.getAbsolutePath();
	}

	public void fillNewGradeAdditionExcel(String filePath) {
		int sheetIndex = 0;

		List<String> commodityGroupDropdown = Arrays.asList("commoditygroupvalue");
		List<String> typeOfMaterialDropdown = Arrays.asList("spcificagradevalue-1040");
		List<String> specificGradeDropdown = Arrays.asList("spe-gr-1040");
		List<String> shapeDropdown = Arrays.asList("Flat");
		List<String> yearDropdown = Arrays.asList("2025-2026");
		List<String> uomDropdown = Arrays.asList("Mtr");
		List<String> periodDropdown = Arrays.asList("Apr");

		System.out.println("✍️ Writing Commodity Group...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 2, 1, ExcelFiller.ValueType.DROPDOWN, commodityGroupDropdown);

		System.out.println("✍️ Writing Type of Material...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 3, 1, ExcelFiller.ValueType.DROPDOWN, typeOfMaterialDropdown);

		System.out.println("✍️ Writing Specific Grade...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 4, 1, ExcelFiller.ValueType.DROPDOWN, specificGradeDropdown);

		System.out.println("✍️ Writing Density...");
		ExcelFiller.writeExactCellValue(filePath, sheetIndex, 5, 1, "1.7");

		System.out.println("✍️ Writing Shape...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 6, 1, ExcelFiller.ValueType.DROPDOWN, shapeDropdown);

		System.out.println("✍️ Writing Year...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 7, 1, ExcelFiller.ValueType.DROPDOWN, yearDropdown);

		System.out.println("✍️ Writing Period...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 8, 1, ExcelFiller.ValueType.DROPDOWN, periodDropdown);

		System.out.println("✍️ Writing UOM...");
		ExcelFiller.setCellValue(filePath, sheetIndex, 10, 1, ExcelFiller.ValueType.DROPDOWN, uomDropdown);

		System.out.println("✍️ Writing only first RM & Scrap column values...");
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			Row headerRow = sheet.getRow(11);
			int baseRow = 12;
			int supplierRow = 13;
			int filled = 0;

			for (int col = 1; col < headerRow.getLastCellNum(); col++) {
				Cell cell = headerRow.getCell(col);
				if (cell == null)
					continue;
				String header = "";
				try {
					header = cell.getStringCellValue().trim();
				} catch (IllegalStateException ise) {
					if (cell.getCellType() == CellType.NUMERIC) {
						header = String.valueOf((int) cell.getNumericCellValue());
					}
				}
				if (header.equalsIgnoreCase("RM")) {
					ExcelFiller.writeExactCellValue(filePath, sheetIndex, baseRow, col, "525.0");
					ExcelFiller.writeExactCellValue(filePath, sheetIndex, supplierRow, col, "500.0");
					filled++;
				} else if (header.equalsIgnoreCase("Scrap")) {
					ExcelFiller.writeExactCellValue(filePath, sheetIndex, baseRow, col, "530.0");
					ExcelFiller.writeExactCellValue(filePath, sheetIndex, supplierRow, col, "505.0");
					filled++;
				}
				if (filled >= 2)
					break;
			}

			System.out.println("✅ Wrote initial RM & Scrap values only.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("✅ Excel file filled: " + filePath);
	}

	public void exportFillAndImportNewGradeAddition() throws InterruptedException {
		LoggerUtil.info("Step 1: Clicked on 'Export' button for New Grade Addition.");
		clickexportbuttonForaddnewgradeaddtion();

		String filePath = getLatestNewSpecificGradeAdditionFilePath();
		if (filePath == null) {
			LoggerUtil.error("❌ Excel file not found. Aborting test.");
			throw new RuntimeException("❌ Excel file not found.");
		}
		LoggerUtil.info("Step 2: Found exported Excel file: " + filePath);

		fillNewGradeAdditionExcel(filePath);
		LoggerUtil.info("Step 3: Filled required values in exported Excel.");

		clickOnElement(newgradeadditionradiobtn);
		Thread.sleep(3000);
		LoggerUtil.info("Step 4: Selected 'New Grade Addition' radio button.");

		WebElement input = driver.findElement(By.id("excelUpload"));
		input.sendKeys(filePath);
		LoggerUtil.info("Step 5: File uploaded using sendKeys to hidden input.");
//
//        WebElement importBtn = driver.findElement(By.xpath("//button[contains(text(),'Import')]"));
//        try {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", importBtn);
//            Thread.sleep(500);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", importBtn);
//            LoggerUtil.info("Step 6: Clicked Import button using JavaScript.");
//        } catch (Exception e) {
//            throw new RuntimeException("❌ Import button click failed via JS: " + e.getMessage());
//        }

		Thread.sleep(7000);
//        clickOnElement(By.xpath("//*[@id='exportModal']/div/div/div[1]/button"));
//        LoggerUtil.info("Step 7: Closed the import modal after upload.");

		LoggerUtil.info("✅ Step 8: Clicked Import button to confirm upload.");

//        Thread.sleep(7000);
//        clickOnElement(By.xpath("//*[@id='exportModal']/div/div/div[1]/button"));
//        LoggerUtil.info("Step 8: Closed the import modal.");

		Thread.sleep(10000);
		clickOnElement(ClickingViewbtn);
		Thread.sleep(5000);
		LoggerUtil.info("Step 8: Clicked on View to refresh list after import.");

		WebElement searchBox = waitForExpectedElement(By.xpath("//*[@id='myInputListSearch']"));
		searchBox.clear();
		searchBox.sendKeys("spcificagradevalue-1040");
		Thread.sleep(1000);
		LoggerUtil.info("Step 9: Searched for grade: spcificagradevalue-1040");

		Thread.sleep(3000);
		clickOnElement(By.xpath("//*[@id='ComDetailBody']/tr[1]/td[2]/a[1]/i"));
		LoggerUtil.info("Step 10: Clicked Edit on the first listed grade row.");
		Thread.sleep(4000);

		String rmValue = waitForExpectedElement(By.xpath("//*[@id='apr']")).getAttribute("value").trim();
		String scrapValue = waitForExpectedElement(By.xpath("//*[@id='aprScrap']")).getAttribute("value").trim();

		String expectedRM = "525";
		String expectedScrap = "530";

		LoggerUtil.info("Step 11: Expected RM from Excel = " + expectedRM + " | UI RM = " + rmValue);
		if (expectedRM.equals(rmValue)) {
			LoggerUtil.pass("✅ RM matched: " + rmValue);
		} else {
			LoggerUtil.mismatch("❌ RM mismatch → Expected: " + expectedRM + ", Found: " + rmValue);
		}

		LoggerUtil.info("Step 12: Expected Scrap from Excel = " + expectedScrap + " | UI Scrap = " + scrapValue);
		if (expectedScrap.equals(scrapValue)) {
			LoggerUtil.pass("✅ Scrap matched: " + scrapValue);
		} else {
			LoggerUtil.mismatch("❌ Scrap mismatch → Expected: " + expectedScrap + ", Found: " + scrapValue);
		}
	}

	public static final By commoditygrpheading = By.xpath("//*[@id='commgrop']/div/div[1]/label");
	public static final By commodityclassification = By.xpath("//*[@id='groupclass']/div/div[1]/label");

	public void verifyCommodityGroupAndClassificationAreInvisible() throws InterruptedException {

		LoggerUtil.info("Step 1: Open Export & Import modal for verification");
		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(1000);

		LoggerUtil.info("Step 2: Select 'New Grade Addition' radio button");
		clickOnElement(newgradeadditionradiobtn);
		Thread.sleep(500);

		boolean groupVisible = false;
		boolean classificationVisible = false;

		try {
			groupVisible = driver.findElement(commoditygrpheading).isDisplayed();
		} catch (Exception e) {
			groupVisible = false;
		}

		try {
			classificationVisible = driver.findElement(commodityclassification).isDisplayed();
		} catch (Exception e) {
			classificationVisible = false;
		}

		LoggerUtil.info("Step 3: Checking visibility of 'Commodity Group' and 'Commodity Classification'");

		if (!groupVisible && !classificationVisible) {
			LoggerUtil.pass(
					"✅ PASS: Both 'Commodity Group' and 'Commodity Classification' are correctly hidden after selecting 'New Grade Addition'.");
		} else {
			if (groupVisible) {
				LoggerUtil.mismatch("❌ FAIL: 'Commodity Group' is still visible — expected to be hidden.");
			}
			if (classificationVisible) {
				LoggerUtil.mismatch("❌ FAIL: 'Commodity Classification' is still visible — expected to be hidden.");
			}
		}
	}

	public static final By selectallbtncommclassification = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/div/button[1]/span/input");
	public static final By selectallbtncommoditygrp = By
			.xpath("//*[@id='comoditygrp']/span/div/div/button[1]/span/input");
	public static final By selectsearchvalueofcommoditygrpwhileexportexcelfile = By
			.xpath("//div[@id='comoditygrp']//input[@type='checkbox'][2]\r\n" + "");
	public static final By searchentervaluecommoditygrp = By.xpath("//*[@id='comoditygrp']/span/div/div/div/input");
	public static final By clickcommoditygroupdropbox = By.xpath("//*[@id='comoditygrp']/span/div/button/span");
	public static final By clickgrpclassificationgroupbox = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/button/span");
	public static final By searchenetrvaluecommclassification = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/div/div/input");
	public static final By selectsearchvalueofcommodityclassificationforexportingExcelFile = By
			.xpath("//div[@id='groupclass']//input[@type='checkbox'][2]");

	public void savedatathirdtabforinsertingFromExcelSheet(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws Exception {
		LoggerUtil.info("Starting third tab entry for Commodity = " + searchcommoditydropvalue);

		Thread.sleep(5000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked Commodity Dropdown.");

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		LoggerUtil.info("Searched for Commodity Group: " + searchcommoditydropvalue);

		for (WebElement comgrpvalue : driver.findElements(commoditydropdownlist)) {
			if (comgrpvalue.getText().trim().equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.pass("Selected Commodity Group from dropdown.");
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		LoggerUtil.info("Clicked Group Classification Dropdown.");

		for (WebElement grpclasslistval : driver.findElements(groupclassificationlist)) {
			if (grpclasslistval.getText().trim().equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.pass("Selected Group Classification: " + searchcommodityclassification);
				break;
			}
		}
		Thread.sleep(4000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		LoggerUtil.info("Clicked Specific Grade Dropdown.");

		for (WebElement comgradelistval : driver.findElements(specificgradelist)) {
			if (comgradelistval.getText().trim().equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.pass("Selected Specific Grade: " + selectcommoditygradevalue);
				break;
			}
		}

		Thread.sleep(4000);
		clickOnElement(Uomdropdown);
		clearAndEnterText(waitForExpectedElement(searchinputforuom), "Mtr");
		Thread.sleep(2000);
		waitForExpectedElement(By.xpath("//ul[@id='select2-uomDrop-results']/li")).click();
		LoggerUtil.info("Selected UOM: Mtr");
		Thread.sleep(4000);
		clickOnElement(ClickingShapedropdownForthirdTab);
		clearAndEnterText(waitForExpectedElement(searchinputforshape), "Sheet");
		Thread.sleep(2000);
		waitForExpectedElement(By.xpath("//ul[@id='select2-shapeDrop-results']/li")).click();
		LoggerUtil.info("Selected Shape: Sheet");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		Thread.sleep(3000);
		clickOnElement(selectyeardrop);
		clearAndEnterText(waitForExpectedElement(searchinputyear), "2025-2026");
		waitForExpectedElement(By.xpath("//ul[@id='select2-Year-results']/li")).click();
		LoggerUtil.info("Selected Year: 2025-2026");

		Thread.sleep(3000);
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(8000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.pass("Selected all Business Segments.");

		Thread.sleep(15000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.pass("Saved third tab successfully.");
		Thread.sleep(3000);
		driver.navigate().refresh();
		LoggerUtil.info("Refreshed page after save.");
	}

	private File latestExportedFile; // declared at class level

	public void importAndExportCommodityFile(String searchCommodityGroup, String searchGroupClassification)
			throws InterruptedException {
		LoggerUtil.info("Step 1: Opening Export/Import modal for Commodity.");

		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		clickOnElement(clickcommoditygroupdropbox);
		LoggerUtil.info("Step 2: Opened Commodity Group dropdown.");
		Thread.sleep(1000);

		WebElement searchBox = waitForExpectedElement(searchentervaluecommoditygrp);
		searchBox.clear();
		searchBox.sendKeys(searchCommodityGroup);
		Thread.sleep(1000);
		searchBox.sendKeys(Keys.ENTER);
		LoggerUtil.pass("Step 3: Selected Commodity Group: " + searchCommodityGroup);
		Thread.sleep(1000);

		clickOnElement(selectallbtncommoditygrp);
		LoggerUtil.info("Step 4: Selected all available entries in Commodity Group.");

		clickOnElement(clickgrpclassificationgroupbox);
		LoggerUtil.info("Step 5: Opened Group Classification dropdown.");
		Thread.sleep(1000);

		WebElement searchBoxClassification = waitForExpectedElement(searchenetrvaluecommclassification);
		searchBoxClassification.clear();
		searchBoxClassification.sendKeys(searchGroupClassification);
		Thread.sleep(1000);
		searchBoxClassification.sendKeys(Keys.ENTER);
		LoggerUtil.pass("Step 6: Selected Group Classification: " + searchGroupClassification);
		Thread.sleep(1000);

		clickOnElement(selectallbtncommclassification);
		LoggerUtil.info("Step 7: Selected all Group Classifications.");
		Thread.sleep(3000);

		clickOnElement(exportExcelBtn);
		LoggerUtil.info("Step 8: Clicked on 'Export Excel' button. Waiting for download.");
		Thread.sleep(30000); // Wait for file to export

		File latestFile = waitForLatestExportedExcelFile(30);
		if (latestFile != null) {
			LoggerUtil.pass("Step 9: Exported Excel file found: " + latestFile.getName());

			// Fill Excel file with random integers
			fillRowKtoAHWithRandomIntegers(latestFile.getAbsolutePath(), 0, 3);
			LoggerUtil.info("Step 10: Filled columns K to AH with random values in Excel.");

			// Save Excel using Robot (Ctrl+S)
			forceExcelSave(latestFile.getAbsolutePath());
			LoggerUtil.info("Step 11: Triggered Excel save operation using Robot.");

			Thread.sleep(7000); // Ensure Excel is saved

			importCommodityFileFromExcel(latestFile.getAbsolutePath());
			LoggerUtil.pass("Step 12: Imported modified Excel file successfully.");
		} else {
			LoggerUtil.mismatch("❌ No exported Excel file found. Cannot proceed with import.");
			Thread.sleep(5000);
		}
	}

	public File waitForLatestExportedExcelFile(int timeoutSeconds) {
		String downloadPath = "C:\\Users\\Admin\\Downloads\\com.CostMaster\\downloads";
		File latestFile = null;
		long startTime = System.currentTimeMillis();

		while ((System.currentTimeMillis() - startTime) < timeoutSeconds * 1000) {
			File[] files = new File(downloadPath)
					.listFiles((dir, name) -> name.contains("Commodity Type Yearly-Whole") && name.endsWith(".xlsx"));

			if (files != null && files.length > 0) {
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
				latestFile = files[0];

				long sizeBefore = latestFile.length();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {
				}
				long sizeAfter = latestFile.length();

				if (sizeBefore == sizeAfter) {
					System.out.println("✅ Latest file found: " + latestFile.getAbsolutePath());
					return latestFile;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
			}
		}

		return null;
	}

	public static void fillRowKtoAHWithRandomIntegers(String filePath, int sheetIndex, int rowIndex) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook workbook = null;

		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			Row row = sheet.getRow(rowIndex);
			if (row == null)
				row = sheet.createRow(rowIndex);

			Random random = new Random();
			for (int col = 10; col <= 33; col++) {
				Cell cell = row.getCell(col);
				if (cell == null)
					cell = row.createCell(col);

				int randomValue = random.nextInt(101);
				cell.setCellValue(randomValue);
				System.out.println("Written " + randomValue + " to row " + rowIndex + ", col " + col);
			}

			fis.close(); // IMPORTANT: Close input stream before writing

			fos = new FileOutputStream(filePath);
			workbook.write(fos);
			fos.flush(); // Ensures data is flushed
			System.out.println("✅ Excel updated successfully at: " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void importCommodityFileFromExcel(String filePath) throws InterruptedException {
		if (filePath == null) {
			System.out.println("❌ Excel commodity file path not found.");
			return;
		}

		WebElement fileInput = driver.findElement(By.xpath("//input[@id='excelUpload']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println(" Uploading commodity file: " + filePath);
		fileInput.sendKeys(filePath);

		Thread.sleep(10000); // Wait for the import to process
	}

	public static void forceExcelSave(String filePath) {
		try {
			String command = "cmd /c start excel /e \"" + filePath + "\"";
			Runtime.getRuntime().exec(command);
			System.out.println("📂 Opened Excel for save: " + filePath);
			Thread.sleep(5000);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			System.out.println("💾 Forced Excel to save and close.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final By crossbuttonforexportimportpage = By.xpath("//*[@id='exportModal']/div/div/div[1]/button");

	public void verifyMonthlyRMandScrapValuesFromExcel(String entersearchvalue, WebDriver driver, File file)
			throws InterruptedException {

		LoggerUtil.info("Step 1: Closing Export/Import modal.");
		Thread.sleep(3000);
		clickOnElement(crossbuttonforexportimportpage);

		Thread.sleep(3000);
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Step 2: Clicked 'View' button.");

		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		LoggerUtil.info("Step 3: Searched for commodity: " + entersearchvalue);

		Thread.sleep(2000);
		clickOnElement(editbtncomdetails);
		LoggerUtil.info("Step 4: Clicked on Edit icon to open the form.");
		Thread.sleep(13000);

		if (file == null || !file.exists()) {
			LoggerUtil.mismatch("❌ Excel file not found for verification.");
			Assert.fail("Excel file not found for verification");
		}

		String filePath = file.getAbsolutePath();
		int sheetIndex = 0;
		int rowIndex = 3;

		// ✅ Month order (April → March)
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };

		// ✅ Labels for logging
		String[] monthLabels = { "April RM", "April Scrap", "May RM", "May Scrap", "June RM", "June Scrap", "July RM",
				"July Scrap", "August RM", "August Scrap", "September RM", "September Scrap", "October RM",
				"October Scrap", "November RM", "November Scrap", "December RM", "December Scrap", "January RM",
				"January Scrap", "February RM", "February Scrap", "March RM", "March Scrap" };

		int columnIndex = 10;

		// ✅ Loop dynamically for each month and type
		for (int i = 0; i < months.length; i++) {

			// --- RM Validation ---
			By rmLocator = getDynamicRMOrScrapLocator(months[i], "RM");
			String rmLabel = monthLabels[i * 2];
			String actualRM = waitForExpectedElement(rmLocator).getAttribute("value").trim();
			String expectedRM = getExpectedValueFromExcel(filePath, sheetIndex, rowIndex, columnIndex);

			LoggerUtil.info("Verifying " + rmLabel + " → Expected: " + expectedRM + " | Actual: " + actualRM);
			try {
				Assert.assertEquals(actualRM, expectedRM, "❌ Mismatch at " + rmLabel + " (Column " + columnIndex + ")");
				LoggerUtil.pass("✅ " + rmLabel + " matched: " + actualRM);
			} catch (AssertionError e) {
				LoggerUtil.mismatch("❌ " + rmLabel + " mismatch → Expected: " + expectedRM + ", Found: " + actualRM);
				throw e;
			}
			columnIndex++;

			// --- Scrap Validation ---
			By scrapLocator = getDynamicRMOrScrapLocator(months[i], "Scrap");
			String scrapLabel = monthLabels[i * 2 + 1];
			String actualScrap = waitForExpectedElement(scrapLocator).getAttribute("value").trim();
			String expectedScrap = getExpectedValueFromExcel(filePath, sheetIndex, rowIndex, columnIndex);

			LoggerUtil.info("Verifying " + scrapLabel + " → Expected: " + expectedScrap + " | Actual: " + actualScrap);
			try {
				Assert.assertEquals(actualScrap, expectedScrap,
						"❌ Mismatch at " + scrapLabel + " (Column " + columnIndex + ")");
				LoggerUtil.pass("✅ " + scrapLabel + " matched: " + actualScrap);
			} catch (AssertionError e) {
				LoggerUtil.mismatch(
						"❌ " + scrapLabel + " mismatch → Expected: " + expectedScrap + ", Found: " + actualScrap);
				throw e;
			}
			columnIndex++;
		}
	}

	public void savedatathirdtabforinsertingForcomparingExcelSheetWithUi(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws Exception {

		Thread.sleep(5000);
		LoggerUtil.info("Step 1: Clicking on Commodity dropdown.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		LoggerUtil.info("Step 2: Searching and selecting Commodity Group: " + searchcommoditydropvalue);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.pass(" Selected Commodity Group: " + searchcommoditydropvalue);
				break;
			}
		}

		Thread.sleep(3000);
		LoggerUtil.info("Step 3: Clicking on Group Classification dropdown.");
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		LoggerUtil.info("Step 4: Searching and selecting Group Classification: " + searchcommodityclassification);
		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.pass(" Selected Group Classification: " + searchcommodityclassification);
				break;
			}
		}

		Thread.sleep(3000);
		LoggerUtil.info("Step 5: Clicking on Specific Grade dropdown.");
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);

		LoggerUtil.info("Step 6: Selecting Specific Grade: " + selectcommoditygradevalue);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.pass(" Selected Specific Grade: " + selectcommoditygradevalue);
				break;
			}
		}

		LoggerUtil.info("Step 7: Selecting UOM 'Mtr'.");
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		LoggerUtil.pass(" UOM 'Mtr' selected.");

		LoggerUtil.info("Step 8: Selecting Shape 'Sheet'.");
		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		LoggerUtil.pass(" Shape 'Sheet' selected.");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");

		LoggerUtil.info("Step 9: Selecting Year '2025-2026'.");
		clickOnElement(yeardropdown);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		LoggerUtil.pass(" Year '2025-2026' selected.");
	}

	///////////////////////////////////// Dynamic
	///////////////////////////////////// Quterly///////////////////////////////////////////////////////////////
	public static By getDynamicQuarterRMOrScrapLocator(String quarter, String type) {
		try {
			// Normalize quarter name (e.g., "Q1", "Q2", "Q3", "Q4")
			String normalizedQuarter = quarter.trim().toLowerCase();

			// Determine correct ID (e.g., "q1Scrap" or "q1")
			String id = type.equalsIgnoreCase("Scrap") ? normalizedQuarter + "scrap" : normalizedQuarter;

			// Build and return dynamic XPath
			String xpath = String.format("//input[@id='%s']", id);
			LoggerUtil.info("Dynamic Quarter Locator Generated → Quarter: " + quarter + ", Type: " + type + ", XPath: "
					+ xpath);

			return By.xpath(xpath);

		} catch (Exception e) {
			LoggerUtil.error("❌ Invalid input for Quarter RM/Scrap locator → " + e.getMessage());
			throw new RuntimeException("Failed to generate locator for " + quarter + " - " + type, e);
		}
	}

	public void entervaluesinrmandscrap(String enteraprilrm, String enteraprilscrap, String entermayrm,
			String entermayscrap, String enterjunerm, String enterjunescrap, String enterjulyrm, String enterjulyscrap,
			String enteraugustrm, String enteraugscrap, String enterseptemrm, String entersepscrap, String enetroctrm,
			String enteroctscrap, String enternovrm, String enternovscrap, String enterdecrm, String enterdecscrap,
			String enetrjanram, String enterjanscrap, String enterfebrm, String enterfebscrap, String entermarchrm,
			String entermarchscrap) throws InterruptedException {

		LoggerUtil.info("🔁 Starting monthly RM & Scrap value entry.");

		LoggerUtil.info("===== Starting Dynamic RM & Scrap Entry for April → March =====");

		// Month codes & values in arrays for dynamic entry
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };
		String[] rmValues = { enteraprilrm, entermayrm, enterjunerm, enterjulyrm, enteraugustrm, enterseptemrm,
				enetroctrm, enternovrm, enterdecrm, enetrjanram, enterfebrm, entermarchrm };

		String[] scrapValues = { enteraprilscrap, entermayscrap, enterjunescrap, enterjulyscrap, enteraugscrap,
				entersepscrap, enteroctscrap, enternovscrap, enterdecscrap, enterjanscrap, enterfebscrap,
				entermarchscrap };

		// Quarter grouping
		String[] quarters = { "Q1 (Apr–Jun)", "Q2 (Jul–Sep)", "Q3 (Oct–Dec)", "Q4 (Jan–Mar)" };

		try {
			for (int i = 0; i < months.length; i++) {
				// Quarter header logs
				if (i == 0)
					LoggerUtil.info("===== " + quarters[0] + " =====");
				if (i == 3)
					LoggerUtil.info("===== " + quarters[1] + " =====");
				if (i == 6)
					LoggerUtil.info("===== " + quarters[2] + " =====");
				if (i == 9)
					LoggerUtil.info("===== " + quarters[3] + " =====");

				// Month-wise logging
				LoggerUtil.info(months[i] + " → RM: " + rmValues[i] + ", Scrap: " + scrapValues[i]);

				// Dynamic RM Entry
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);

				// Dynamic Scrap Entry
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
			}

			LoggerUtil.pass("✅ All RM and Scrap values entered successfully for April → March.");

		} catch (Exception e) {
			LoggerUtil.error("❌ Exception while entering RM/Scrap values → " + e.getMessage());
		}

		LoggerUtil.info("===== End of Dynamic RM & Scrap Entry =====");

		LoggerUtil.info(" Selecting Business Segment.");
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);

		LoggerUtil.info(" Selecting customer checkbox.");
		clickOnElement(customercheckbox);
		Thread.sleep(3000);

		LoggerUtil.info(" Clicking Save button.");
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(6000);

		LoggerUtil.info(" Refreshing the page.");
		driver.navigate().refresh();
	}

	public void exportdatafromuiforreadthvalue(String searchCommodityGroup, String searchGroupClassification)
			throws InterruptedException {

		LoggerUtil.info("Step 1: Clicking on Export & Import button.");
		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Opening Commodity Group dropdown.");
		clickOnElement(clickcommoditygroupdropbox);
		Thread.sleep(1000);

		LoggerUtil.info("Step 3: Searching Commodity Group: " + searchCommodityGroup);
		WebElement searchBox = waitForExpectedElement(searchentervaluecommoditygrp);
		searchBox.clear();
		searchBox.sendKeys(searchCommodityGroup);
		Thread.sleep(1000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		clickOnElement(selectallbtncommoditygrp);
		LoggerUtil.pass("✔ Selected Commodity Group: " + searchCommodityGroup);

		LoggerUtil.info("Step 4: Opening Group Classification dropdown.");
		clickOnElement(clickgrpclassificationgroupbox);
		Thread.sleep(1000);

		LoggerUtil.info("Step 5: Searching Group Classification: " + searchGroupClassification);
		WebElement searchBoxClassification = waitForExpectedElement(searchenetrvaluecommclassification);
		searchBoxClassification.clear();
		searchBoxClassification.sendKeys(searchGroupClassification);
		Thread.sleep(1000);
		searchBoxClassification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		clickOnElement(selectallbtncommclassification);
		LoggerUtil.pass("✔ Selected Group Classification: " + searchGroupClassification);

		LoggerUtil.info("Step 6: Clicking on Export Excel button.");
		clickOnElement(exportExcelBtn);
		Thread.sleep(30000);
		LoggerUtil.pass("✔ Excel export triggered. Waiting completed.");

		File latestFile = waitForLatestExportedExcelFile(30);
		if (latestFile != null) {
			LoggerUtil.pass("✔ Latest exported file found: " + latestFile.getName());
		} else {
			LoggerUtil.error("❌ No exported Excel file found after waiting.");
		}
	}

	public static File getLatestExportedExcelFile() {
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\com.CostMaster\\downloads";
		File dir = new File(downloadPath);

		LoggerUtil.info("🔍 Scanning directory: " + dir.getAbsolutePath());

		File[] files = dir
				.listFiles((file, name) -> name.startsWith("Commodity Type Yearly-Whole") && name.endsWith(".xlsx"));

		if (files == null || files.length == 0) {
			LoggerUtil.mismatch("❌ No matching Excel files found in: " + downloadPath);
			return null;
		}

		File latestFile = files[0];
		for (File file : files) {
			if (file.lastModified() > latestFile.lastModified()) {
				latestFile = file;
			}
		}

		LoggerUtil.pass(" Latest file selected: " + latestFile.getAbsolutePath());
		return latestFile;
	}

	public List<String> readRMandScrapFromExcel(File excelFile) {
		List<String> excelValues = new ArrayList<>();

		try (Workbook workbook = WorkbookFactory.create(excelFile)) {
			LoggerUtil.info("📥 Reading Excel file: " + excelFile.getAbsolutePath());

			Sheet sheet = workbook.getSheetAt(0); // First sheet

			for (int i = 3; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell firstColumnCell = row.getCell(1);
					if (firstColumnCell != null && firstColumnCell.getCellType() == CellType.STRING
							&& !firstColumnCell.getStringCellValue().isEmpty()) {

						LoggerUtil.info("✔ Found valid row at index: " + i);

						for (int col = 10; col <= 33; col++) { // K to AH
							Cell currentCell = row.getCell(col);
							if (currentCell != null && currentCell.getCellType() == CellType.NUMERIC) {
								String value = String.format("%.3f", currentCell.getNumericCellValue());
								excelValues.add(value);
							} else {
								excelValues.add("0.000");
							}
						}

						LoggerUtil.info(" Extracted " + excelValues.size() + " RM & Scrap values from row " + (i + 1));
						break;
					}
				}
			}

		} catch (Exception e) {
			LoggerUtil.mismatch(" Error reading Excel: " + excelFile.getName() + " | " + e.getMessage());
			e.printStackTrace();
		}

		for (int i = 0; i < excelValues.size(); i++) {
			LoggerUtil.info(" Index " + i + " = " + excelValues.get(i));
		}

		return excelValues;
	}

	public static final By editbtncomdetails = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[2]/a[1]/i");

	public void entervaluesinrmandscrapforupdatingyearwise(String newenteraprilrm, String newenteraprilscrap,
			String newentermayrm, String newentermayscrap, String newenterjunerm, String newenterjunescrap,
			String newenterjulyrm, String newenterjulyscrap, String newenteraugustrm, String newenteraugscrap,
			String newenterseptemrm, String newentersepscrap, String newenetroctrm, String newenteroctscrap,
			String newenternovrm, String newenternovscrap, String newenterdecrm, String newenterdecscrap,
			String newenetrjanram, String newenterjanscrap, String newenterfebrm, String newenterfebscrap,
			String newentermarchrm, String newentermarchscrap, String newentersearchvalue) throws InterruptedException {

		LoggerUtil.info("🔁 Entering Yearly RM and Scrap Values");

		LoggerUtil.info("===== Starting Dynamic RM & Scrap Update for April → March =====");

		// Month short-forms in order
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };

		// Matching RM and Scrap arrays
		String[] rmValues = { newenteraprilrm, newentermayrm, newenterjunerm, newenterjulyrm, newenteraugustrm,
				newenterseptemrm, newenetroctrm, newenternovrm, newenterdecrm, newenetrjanram, newenterfebrm,
				newentermarchrm };

		String[] scrapValues = { newenteraprilscrap, newentermayscrap, newenterjunescrap, newenterjulyscrap,
				newenteraugscrap, newentersepscrap, newenteroctscrap, newenternovscrap, newenterdecscrap,
				newenterjanscrap, newenterfebscrap, newentermarchscrap };

		try {
			for (int i = 0; i < months.length; i++) {
				// ---- Enter RM ----
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);
				LoggerUtil.info(months[i] + " → RM: " + rmValues[i]);

				// ---- Enter Scrap ----
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
				LoggerUtil.info(months[i] + " → Scrap: " + scrapValues[i]);
			}

			LoggerUtil.pass("✅ All RM & Scrap values updated successfully for April → March.");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Error while updating RM/Scrap values → " + e.getMessage());
		}

		LoggerUtil.info("===== End of Dynamic RM & Scrap Update =====");

		LoggerUtil.info(" Selecting business segment and customer.");
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		Thread.sleep(3000);

		LoggerUtil.info(" Clicking save.");
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(6000);

		LoggerUtil.info("🔄 Refreshing page and verifying saved entry.");
		driver.navigate().refresh();
		clickOnElement(ClickingViewbtn);
		Thread.sleep(6000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), newentersearchvalue);
		LoggerUtil.info(" Searching saved entry with: " + newentersearchvalue);
		Thread.sleep(4000);

		clickOnElement(editbtncomdetails);
		LoggerUtil.info("✏ Clicked edit on matched entry.");
		Thread.sleep(5000);
	}

	public static final By yeardropdown = By.xpath("//span[@id='select2-Year-container']");

	public void fetchingyearwisepriceandupdatingdifferentyearwithdifferentpriceandverifyingafterupdating(
			String enteraprilrm, String enteraprilscrap, String entermayrm, String entermayscrap, String enterjunerm,
			String enterjunescrap, String enterjulyrm, String enterjulyscrap, String enteraugustrm,
			String enteraugscrap, String enterseptemrm, String entersepscrap, String enetroctrm, String enteroctscrap,
			String enternovrm, String enternovscrap, String enterdecrm, String enterdecscrap, String enetrjanram,
			String enterjanscrap, String enterfebrm, String enterfebscrap, String entermarchrm, String entermarchscrap,
			String entersearchvalueforupdatedyearverifying, String newenteraprilrm, String newentermarchrm,
			String newenterjanscrap, String newenterjulyrm) throws InterruptedException {

		LoggerUtil.info("📋 Validating selected year is 2025-2026.");
		String actualyearvalue = waitForExpectedElement(yeardropdown).getText();
		String expectedvalue = "2025-2026";
		Assert.assertEquals(actualyearvalue, expectedvalue, "Mismatch Year value");

		LoggerUtil.info("🔄 Changing to year: 2024-2025.");
		Thread.sleep(3000);
		clickOnElement(yeardropdown);
		Thread.sleep(3000);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2024-2025");
		yearsearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		LoggerUtil.info("✍️ Entering updated prices for year 2024-2025.");
		LoggerUtil.info("===== Starting RM and Scrap Value Entry (Dynamic) =====");

		// ✅ Define month short forms (April → March)
		String[] months = { "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar" };

		// ✅ RM & Scrap value arrays (in same order)
		String[] rmValues = { enteraprilrm, entermayrm, enterjunerm, enterjulyrm, enteraugustrm, enterseptemrm,
				enetroctrm, enternovrm, enterdecrm, enetrjanram, enterfebrm, entermarchrm };

		String[] scrapValues = { enteraprilscrap, entermayscrap, enterjunescrap, enterjulyscrap, enteraugscrap,
				entersepscrap, enteroctscrap, enternovscrap, enterdecscrap, enterjanscrap, enterfebscrap,
				entermarchscrap };

		// ✅ Loop through each month dynamically
		for (int i = 0; i < months.length; i++) {
			try {
				// Enter RM
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);
				LoggerUtil.info("Entered " + months[i] + " RM → " + rmValues[i]);

				// Enter Scrap
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
				LoggerUtil.info("Entered " + months[i] + " Scrap → " + scrapValues[i]);

			} catch (Exception e) {
				LoggerUtil.error("❌ Error entering " + months[i] + " RM/Scrap values → " + e.getMessage());
			}
		}

		LoggerUtil.pass("✅ All RM and Scrap values entered successfully for April → March.");
		LoggerUtil.info("===== End of RM and Scrap Value Entry (Dynamic) =====");
		LoggerUtil.info("💾 Saving the updated 2024-2025 prices.");
		Thread.sleep(4000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		Thread.sleep(2000);

		clickOnElement(ClickingViewbtn);
		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab),
				entersearchvalueforupdatedyearverifying);
		LoggerUtil.info("🔍 Searching saved record for 2024-2025 year.");
		Thread.sleep(3000);
		clickOnElement(editbtncomdetails);
		Thread.sleep(6000);

		LoggerUtil.info("🔁 Verifying updated values for year 2024-2025.");
		String actualupdatedyear = waitForExpectedElement(yeardropdown).getText();
		Assert.assertEquals(actualupdatedyear, "2024-2025", "updated year mismatch");

		LoggerUtil.info("===== Starting Dynamic RM & Scrap Value Verification =====");

		try {
			// ✅ April RM check
			String actualAprilRM = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value")
					.trim();
			softAssert.assertEquals(actualAprilRM, enteraprilrm, "Updated April RM mismatch");
			LoggerUtil.info("Verified April RM → Expected: " + enteraprilrm + ", Actual: " + actualAprilRM);

			// ✅ March RM check
			String actualMarchRM = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value")
					.trim();
			softAssert.assertEquals(actualMarchRM, entermarchrm, "Updated March RM mismatch");
			LoggerUtil.info("Verified March RM → Expected: " + entermarchrm + ", Actual: " + actualMarchRM);

			// ✅ January Scrap check
			String actualJanScrap = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap"))
					.getAttribute("value").trim();
			softAssert.assertEquals(actualJanScrap, enterjanscrap, "Updated January Scrap mismatch");
			LoggerUtil.info("Verified January Scrap → Expected: " + enterjanscrap + ", Actual: " + actualJanScrap);

			// ✅ July RM check
			String actualJulyRM = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value")
					.trim();
			softAssert.assertEquals(actualJulyRM, enterjulyrm, "Updated July RM mismatch");
			LoggerUtil.info("Verified July RM → Expected: " + enterjulyrm + ", Actual: " + actualJulyRM);

			LoggerUtil.pass("✅ All selected RM & Scrap values verified successfully.");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Error while verifying RM/Scrap values → " + e.getMessage());
		}

		LoggerUtil.info(" Switched back to original year: 2025-2026 to confirm old values.");

		clickOnElement(yeardropdown);
		Thread.sleep(500);
		WebElement yearsearch1 = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch1, "2025-2026");
		yearsearch1.sendKeys(Keys.ENTER);
		Thread.sleep(7000);

		try {
			// ✅ April RM
			String actualAprilRM = waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")).getAttribute("value")
					.trim();
			softAssert.assertEquals(actualAprilRM, newenteraprilrm, "Old April RM mismatch");
			LoggerUtil.info("Verified April RM → Expected: " + newenteraprilrm + ", Actual: " + actualAprilRM);

			// ✅ March RM
			String actualMarchRM = waitForExpectedElement(getDynamicRMOrScrapLocator("Mar", "RM")).getAttribute("value")
					.trim();
			softAssert.assertEquals(actualMarchRM, newentermarchrm, "Old March RM mismatch");
			LoggerUtil.info("Verified March RM → Expected: " + newentermarchrm + ", Actual: " + actualMarchRM);

			// ✅ January Scrap
			String actualJanScrap = waitForExpectedElement(getDynamicRMOrScrapLocator("Jan", "Scrap"))
					.getAttribute("value").trim();
			softAssert.assertEquals(actualJanScrap, newenterjanscrap, "Old Jan Scrap mismatch");
			LoggerUtil.info("Verified January Scrap → Expected: " + newenterjanscrap + ", Actual: " + actualJanScrap);

			// ✅ July RM
			String actualJulyRM = waitForExpectedElement(getDynamicRMOrScrapLocator("Jul", "RM")).getAttribute("value")
					.trim();
			softAssert.assertEquals(actualJulyRM, newenterjulyrm, "Old July RM mismatch");
			LoggerUtil.info("Verified July RM → Expected: " + newenterjulyrm + ", Actual: " + actualJulyRM);

			LoggerUtil.pass("✅ Updated RM & Scrap values verified successfully.");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Exception while verifying updated RM/Scrap values → " + e.getMessage());
		}

	}

	public static final By clicksearchfilterbox = By
			.xpath("//*[@id=\"CommodityDetailTab\"]/div[2]/div/div/div[2]/div[2]/i");
	public static final By clickcheckboxcommoditygroupforsearchfilter = By
			.xpath("//div[@id='chkddd']/label/input[@value='CommodityGroup']");
	public static final By clickcheckboxgroupclassificationforsearchfilter = By
			.xpath("//*[@id='chkddd']/label[2]/input[@value='CastingGrade']");
	public static final By fetchinggroupclassificationdata = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[4]");
	public static final By clickspecificgradevalueforsearchfilter = By
			.xpath("//*[@id='chkddd']/label[3]/input[@value='SpecificGrade']");
	public static final By fetchingspecificgradecolumndata = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[5]");

	public void verifysearchfilterareworkedproperarenot(String entersearchvalue, String entersearchclassification,
			String entersearchvaluespecificgradevalue) throws InterruptedException {

		// ========== Step 1: Search by Commodity Group ==========
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button for Commodity Group filter");
		Thread.sleep(6000);

		clickOnElement(clicksearchfilterbox);
		LoggerUtil.info("Clicked on Search Filter box");
		Thread.sleep(3000);

		clickOnElement(clickcheckboxcommoditygroupforsearchfilter);
		LoggerUtil.info("Selected 'Commodity Group' checkbox");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		LoggerUtil.info("Entered Commodity Group value in search box: " + entersearchvalue);

		String actualvaluecommoditygroup = waitForExpectedElement(fetchingcommoditygrpcolumn).getText();
		LoggerUtil.info("Expected Commodity Group: " + entersearchvalue + " | Actual: " + actualvaluecommoditygroup);

		Assert.assertEquals(actualvaluecommoditygroup, entersearchvalue);

		driver.navigate().refresh();
		Thread.sleep(4000);

		// ========== Step 2: Search by Group Classification ==========
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button for Group Classification filter");
		Thread.sleep(6000);

		clickOnElement(clicksearchfilterbox);
		LoggerUtil.info("Clicked on Search Filter box");
		Thread.sleep(3000);

		clickOnElement(clickcheckboxgroupclassificationforsearchfilter);
		LoggerUtil.info("Selected 'Group Classification' checkbox");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchclassification);
		LoggerUtil.info("Entered Group Classification value in search box: " + entersearchclassification);
		Thread.sleep(3000);

		String actualvalueclassification = waitForExpectedElement(fetchinggroupclassificationdata).getText();
		LoggerUtil.info("Expected Group Classification: " + entersearchclassification + " | Actual: "
				+ actualvalueclassification);

		Assert.assertEquals(actualvalueclassification, entersearchclassification);

		driver.navigate().refresh();
		Thread.sleep(4000);

		// ========== Step 3: Search by Specific Grade ==========
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button for Specific Grade filter");
		Thread.sleep(6000);

		clickOnElement(clicksearchfilterbox);
		LoggerUtil.info("Clicked on Search Filter box");
		Thread.sleep(3000);

		clickOnElement(clickspecificgradevalueforsearchfilter);
		LoggerUtil.info("Selected 'Specific Grade' checkbox");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab),
				entersearchvaluespecificgradevalue);
		LoggerUtil.info("Entered Specific Grade value in search box: " + entersearchvaluespecificgradevalue);
		Thread.sleep(3000);

		String actualspecificgradevalue = waitForExpectedElement(fetchingspecificgradecolumndata).getText();
		LoggerUtil.info("Expected Specific Grade: " + entersearchvaluespecificgradevalue + " | Actual: "
				+ actualspecificgradevalue);

		Assert.assertEquals(actualspecificgradevalue, entersearchvaluespecificgradevalue);
	}

	public static final By commoditygroupheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr[1]/th[3]");
	public static final By fetchingcommoditygroupcolumn = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[3]");
	public static final By subgroupheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr[1]/th[4]");
	public static final By fetchingsubgroupcolumn = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[4]");
	public static final By gradeheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr[1]/th[5]");
	public static final By fetchinggradecolumn = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[5]");

	public void verifysortingfunctionality() throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button to load Commodity Group data");
		Thread.sleep(6000);

		clickOnElement(commoditygroupheader);
		LoggerUtil.info("Clicked on 'Commodity Group' column header to sort");
		Thread.sleep(3000);

		List<String> actualCommodity = driver
				.findElements(By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[3]")).stream()
				.map(WebElement::getText).map(String::trim).collect(Collectors.toList());

		List<String> expectedCommodity = new ArrayList<>(actualCommodity);
		Collections.sort(expectedCommodity, String.CASE_INSENSITIVE_ORDER);

		try {
			soft.assertEquals(actualCommodity, expectedCommodity);
			LoggerUtil.info("Commodity Group sorted correctly: " + actualCommodity);
		} catch (AssertionError e) {
			LoggerUtil.info("FAIL: Commodity Group sort mismatch.\nExpected: " + expectedCommodity + "\nActual: "
					+ actualCommodity);
		}

		driver.navigate().refresh();
		Thread.sleep(3000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button to load Sub Group data");
		Thread.sleep(6000);

		clickOnElement(subgroupheader);
		LoggerUtil.info("Clicked on 'Sub Group' column header to sort");
		Thread.sleep(3000);

		List<String> actualSubGroup = driver
				.findElements(By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[4]")).stream()
				.map(WebElement::getText).map(String::trim).collect(Collectors.toList());

		List<String> expectedSubGroup = new ArrayList<>(actualSubGroup);
		Collections.sort(expectedSubGroup, String.CASE_INSENSITIVE_ORDER);

		try {
			soft.assertEquals(actualSubGroup, expectedSubGroup);
			LoggerUtil.info("Sub Group sorted correctly: " + actualSubGroup);
		} catch (AssertionError e) {
			LoggerUtil.info(
					"FAIL: Sub Group sort mismatch.\nExpected: " + expectedSubGroup + "\nActual: " + actualSubGroup);
		}

		driver.navigate().refresh();
		Thread.sleep(3000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button to load Grade data");
		Thread.sleep(6000);

		clickOnElement(gradeheader);
		LoggerUtil.info("Clicked on 'Grade' column header to sort");
		Thread.sleep(3000);

		List<String> actualGrade = driver
				.findElements(By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[5]")).stream()
				.map(WebElement::getText).map(String::trim).collect(Collectors.toList());

		List<String> expectedGrade = new ArrayList<>(actualGrade);
		Collections.sort(expectedGrade, String.CASE_INSENSITIVE_ORDER);

		try {
			soft.assertEquals(actualGrade, expectedGrade);
			LoggerUtil.info("Grade sorted correctly: " + actualGrade);
		} catch (AssertionError e) {
			LoggerUtil.info("FAIL: Grade sort mismatch.\nExpected: " + expectedGrade + "\nActual: " + actualGrade);
		}
	}

	public static final By domesticradiobtn = By.xpath("//input[@id='domesticR']");
	public static final By fetchingdomesticcolumheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr/th[3]");
	public static final By fetchingyearheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr[1]/th[7]");

	public void verifyBydefaultyearcolumn() throws InterruptedException {

		// Step 1: Select Domestic and Click View
		clickOnElement(domesticradiobtn);
		LoggerUtil.info("Clicked on 'Domestic' radio button");
		Thread.sleep(3000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button after selecting Domestic");
		Thread.sleep(5000);

		// Step 2: Validate Domestic Header "Type"
		String actualvaluedomesticHeaderName = waitForExpectedElement(fetchingdomesticcolumheader).getText();
		String expectedvaluedomesticHeaderName = "Type";
		LoggerUtil.info("Validating Domestic column header");
		LoggerUtil.info("Expected Header: " + expectedvaluedomesticHeaderName + " | Actual Header: "
				+ actualvaluedomesticHeaderName);

		Assert.assertEquals(actualvaluedomesticHeaderName, expectedvaluedomesticHeaderName);
		LoggerUtil.info("PASS: Domestic column header matches expected 'Type'");

		// Step 3: Refresh and View Default (Yearly) Mode
		driver.navigate().refresh();
		LoggerUtil.info("Page refreshed for default mode check");
		Thread.sleep(3000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View button without selecting radio (default mode)");
		Thread.sleep(5000);

		// Step 4: Check for "Year" column header
		if (driver.findElements(fetchingyearheader).size() > 0) {
			String yearColumnText = driver.findElement(fetchingyearheader).getText();
			LoggerUtil.info("Year column is displayed by default. Column Text: " + yearColumnText);
		} else {
			LoggerUtil.info("FAIL: Year column is not displayed by default");
		}
	}

	public static final By entervalueWhatIfAnalysis1 = By.xpath("//*[@id='LandedCostUOM1']");
	public static final By entervaluewhatIfAnalysis2 = By.xpath("//*[@id='LandedCostUOM2']");
	public static final By entervalueWhatIfAnalysis3 = By.xpath("//*[@id='LandedCostUOM3']");
	public static final By scrapcost1 = By.xpath("//*[@id='ScrapCostUOM1']");
	public static final By scrapcost2 = By.xpath("//*[@id='ScrapCostUOM2']");
	public static final By scrapcost3 = By.xpath("//*[@id='ScrapCostUOM3']");

	public void savedatainthirdtabForWhatIfAnalysis(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue,
			String entersavedvaluewhatifanalysis1, String entersavedvaluewhatifanalysis2,
			String entersavedvaluewhatifanalysis3, String enterscrapcost1, String enterscrapcost2,
			String enterscrapcost3, String entersearchvalue) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Select Commodity Group
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity Group: " + flagcomgrpval);
				break;
			}
		}

		// Select Group Classification
		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);
		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		// Select Specific Grade
		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		// Select UOM
		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected UOM: Mtr");
		Thread.sleep(500);

		// Select Shape
		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Shape: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		// Select Year
		clickOnElement(selectyeardrop);
		Thread.sleep(500);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Year: 2025-2026");
		Thread.sleep(3000);

		// Select Business Segment
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected Business Segment: rishi (All Checked)");
		Thread.sleep(8000);

		// Select Customer Checkbox
		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer checkbox");
		Thread.sleep(3000);

		// Enter What-If Values
		clearAndEnterText(waitForExpectedElement(entervalueWhatIfAnalysis1), entersavedvaluewhatifanalysis1);
		LoggerUtil.info("Entered What-If Price 1: " + entersavedvaluewhatifanalysis1);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(entervaluewhatIfAnalysis2), entersavedvaluewhatifanalysis2);
		LoggerUtil.info("Entered What-If Price 2: " + entersavedvaluewhatifanalysis2);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(entervalueWhatIfAnalysis3), entersavedvaluewhatifanalysis3);
		LoggerUtil.info("Entered What-If Price 3: " + entersavedvaluewhatifanalysis3);
		Thread.sleep(2000);

		// Enter Scrap Cost Values
		clearAndEnterText(waitForExpectedElement(scrapcost1), enterscrapcost1);
		LoggerUtil.info("Entered Scrap Cost 1: " + enterscrapcost1);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(scrapcost2), enterscrapcost2);
		LoggerUtil.info("Entered Scrap Cost 2: " + enterscrapcost2);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(scrapcost3), enterscrapcost3);
		LoggerUtil.info("Entered Scrap Cost 3: " + enterscrapcost3);
		Thread.sleep(3000);

		// Save and View
		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked on Save button for What-If entry");
		Thread.sleep(4000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View to verify saved What-If prices");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		LoggerUtil.info("Searched saved What-If record using Commodity Group: " + entersearchvalue);
		Thread.sleep(2000);

		clickOnElement(editbtncomdetails);
		LoggerUtil.info("Opened saved What-If record for editing");
	}

	public void updatewhatifprice(String entersavedvaluewhatifanalysis1, String entersavedvaluewhatifanalysis2,
			String entersavedvaluewhatifanalysis3, String enterscrapcost1, String enterscrapcost2,
			String enterscrapcost3, String entersearchvalue) throws InterruptedException {

		// Update What-If and Scrap Cost values
		clearAndEnterText(waitForExpectedElement(entervalueWhatIfAnalysis1), entersavedvaluewhatifanalysis1);
		LoggerUtil.info("Updated What-If Price 1: " + entersavedvaluewhatifanalysis1);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(entervaluewhatIfAnalysis2), entersavedvaluewhatifanalysis2);
		LoggerUtil.info("Updated What-If Price 2: " + entersavedvaluewhatifanalysis2);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(entervalueWhatIfAnalysis3), entersavedvaluewhatifanalysis3);
		LoggerUtil.info("Updated What-If Price 3: " + entersavedvaluewhatifanalysis3);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(scrapcost1), enterscrapcost1);
		LoggerUtil.info("Updated Scrap Cost 1: " + enterscrapcost1);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(scrapcost2), enterscrapcost2);
		LoggerUtil.info("Updated Scrap Cost 2: " + enterscrapcost2);
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(scrapcost3), enterscrapcost3);
		LoggerUtil.info("Updated Scrap Cost 3: " + enterscrapcost3);
		Thread.sleep(5000);

		// Save updated values
		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked on Save button after updating What-If & Scrap Cost");
		Thread.sleep(4000);

		// View and search to verify
		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View to validate updated values");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersearchvalue);
		LoggerUtil.info("Searched for updated record using Commodity Group: " + entersearchvalue);
		Thread.sleep(2000);

		clickOnElement(editbtncomdetails);
		LoggerUtil.info("Opened updated What-If record for verification");
		Thread.sleep(8000);

		// ========== Assertions with Logs ==========

		String expected1 = waitForExpectedElement(entervalueWhatIfAnalysis1).getAttribute("value");
		LoggerUtil.info(
				"Verifying What-If Price 1 - Expected: " + entersavedvaluewhatifanalysis1 + " | Actual: " + expected1);
		Assert.assertEquals(expected1.trim(), entersavedvaluewhatifanalysis1.trim());

		String expected2 = waitForExpectedElement(entervaluewhatIfAnalysis2).getAttribute("value");
		LoggerUtil.info(
				"Verifying What-If Price 2 - Expected: " + entersavedvaluewhatifanalysis2 + " | Actual: " + expected2);
		Assert.assertEquals(expected2, entersavedvaluewhatifanalysis2);

		String expected3 = waitForExpectedElement(entervalueWhatIfAnalysis3).getAttribute("value");
		LoggerUtil.info(
				"Verifying What-If Price 3 - Expected: " + entersavedvaluewhatifanalysis3 + " | Actual: " + expected3);
		Assert.assertEquals(expected3, entersavedvaluewhatifanalysis3);

		String expectedScrap1 = waitForExpectedElement(scrapcost1).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 1 - Expected: " + enterscrapcost1 + " | Actual: " + expectedScrap1);
		Assert.assertEquals(expectedScrap1, enterscrapcost1);

		String expectedScrap2 = waitForExpectedElement(scrapcost2).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 2 - Expected: " + enterscrapcost2 + " | Actual: " + expectedScrap2);
		Assert.assertEquals(expectedScrap2, enterscrapcost2);

		String expectedScrap3 = waitForExpectedElement(scrapcost3).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 3 - Expected: " + enterscrapcost3 + " | Actual: " + expectedScrap3);
		Assert.assertEquals(expectedScrap3, enterscrapcost3);
	}

	public static final By ClickingSaveasNewButtonForThirdTab = By.xpath("//*[@id='tab3SaveNew']");

	public void saveasnewdataInWhatIfAnalysis(String addcommodityvalue, String searchcommodityvalue,
			String grpclassificationvalue, String specificgradevalye, String densityvalue,
			String searchcommoditydropvalue, String searchcommodityclassification, String selectcommoditygradevalue,
			String entersavedvaluewhatifanalysis1, String entersavedvaluewhatifanalysis2,
			String entersavedvaluewhatifanalysis3, String enterscrapcost1, String enterscrapcost2,
			String enterscrapcost3, String entersaaveasnewvalule) throws InterruptedException {

		dashboard.clickOnAddcommodity();
		clearAndEnterText(waitForExpectedElement(addcommodity), addcommodityvalue);
		LoggerUtil.info("Entered new commodity: " + addcommodityvalue);
		Thread.sleep(16000);
		clickOnElement((addcomSavebtn));

		LoggerUtil.info("Saved new commodity group");

		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		clickOnElement(commoditygroupdropdown);
		Thread.sleep(2000);

		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);
		for (WebElement grpvalue : grouplist) {
			String text = grpvalue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				grpvalue.click();
				LoggerUtil.info("Selected commodity group from dropdown: " + text);
				break;
			}
		}

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		LoggerUtil.info("Entered Group Classification: " + grpclassificationvalue);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		LoggerUtil.info("Entered Specific Grade: " + specificgradevalye);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		LoggerUtil.info("Entered Density: " + densityvalue);
		Thread.sleep(1000);
		clickOnElement(savebtncommoditygrp);
		LoggerUtil.info("Saved Commodity Group Tab");
		Thread.sleep(7000);

		dashboard.clickOnCommodityTabByName("Commodity Details");

		// Dropdowns for What-If
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity Group: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);
		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected UOM: Mtr");
		Thread.sleep(3000);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(3000);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Shape: Sheet");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 130);");
		Thread.sleep(3000);
		clickOnElement(selectyeardrop);
		Thread.sleep(3000);
		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Year: 2025-2026");
		Thread.sleep(4000);

		// Enter What-If and Scrap Cost
		clearAndEnterText(waitForExpectedElement(entervalueWhatIfAnalysis1), entersavedvaluewhatifanalysis1);
		LoggerUtil.info("Entered What-If Price 1: " + entersavedvaluewhatifanalysis1);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(entervaluewhatIfAnalysis2), entersavedvaluewhatifanalysis2);
		LoggerUtil.info("Entered What-If Price 2: " + entersavedvaluewhatifanalysis2);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(entervalueWhatIfAnalysis3), entersavedvaluewhatifanalysis3);
		LoggerUtil.info("Entered What-If Price 3: " + entersavedvaluewhatifanalysis3);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(scrapcost1), enterscrapcost1);
		LoggerUtil.info("Entered Scrap Cost 1: " + enterscrapcost1);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(scrapcost2), enterscrapcost2);
		LoggerUtil.info("Entered Scrap Cost 2: " + enterscrapcost2);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(scrapcost3), enterscrapcost3);
		LoggerUtil.info("Entered Scrap Cost 3: " + enterscrapcost3);
		Thread.sleep(2000);

		clickOnElement(ClickingSaveasNewButtonForThirdTab);
		LoggerUtil.info("Clicked on Save As New");
		Thread.sleep(3000);

		clickOnElement(ClickingViewbtn);
		LoggerUtil.info("Clicked on View to verify saved-as-new data");
		Thread.sleep(5000);

		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), entersaaveasnewvalule);
		LoggerUtil.info("Searched saved-as-new record using: " + entersaaveasnewvalule);
		Thread.sleep(2000);

		clickOnElement(editbtncomdetails);
		LoggerUtil.info("Opened record in Edit mode");
		Thread.sleep(4000);

		// Validation: What-If & Scrap Cost fields
		String expected1 = waitForExpectedElement(entervalueWhatIfAnalysis1).getAttribute("value");
		LoggerUtil.info(
				"Verifying What-If Price 1 - Expected: " + entersavedvaluewhatifanalysis1 + " | Actual: " + expected1);
		Assert.assertEquals(expected1.trim(), entersavedvaluewhatifanalysis1.trim());

		String expected2 = waitForExpectedElement(entervaluewhatIfAnalysis2).getAttribute("value");
		LoggerUtil.info(
				"Verifying What-If Price 2 - Expected: " + entersavedvaluewhatifanalysis2 + " | Actual: " + expected2);
		Assert.assertEquals(expected2, entersavedvaluewhatifanalysis2);

		String expected3 = waitForExpectedElement(entervalueWhatIfAnalysis3).getAttribute("value");
		LoggerUtil.info(
				"Verifying What-If Price 3 - Expected: " + entersavedvaluewhatifanalysis3 + " | Actual: " + expected3);
		Assert.assertEquals(expected3, entersavedvaluewhatifanalysis3);

		String scrap1 = waitForExpectedElement(scrapcost1).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 1 - Expected: " + enterscrapcost1 + " | Actual: " + scrap1);
		Assert.assertEquals(scrap1, enterscrapcost1);

		String scrap2 = waitForExpectedElement(scrapcost2).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 2 - Expected: " + enterscrapcost2 + " | Actual: " + scrap2);
		Assert.assertEquals(scrap2, enterscrapcost2);

		String scrap3 = waitForExpectedElement(scrapcost3).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 3 - Expected: " + enterscrapcost3 + " | Actual: " + scrap3);
		Assert.assertEquals(scrap3, enterscrapcost3);
	}

	public static final By toastmsg1 = By.xpath("//*[@id='toast-container']/div/div[2]");
	public static final By groupdelta = By.xpath("//*[@id='DeltaR']");
	public static final By grpdirectcost = By.xpath("//*[@id=' DirectPriceR']");
	public static final By newgradebtn = By.xpath("//*[@id='NewGradeadd']");

	public void verifyexportandimportpromtforcomgrpandcomclassification() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		// ========== 1. Click Export without selecting anything ==========
		clickOnElement(ClickingExportAndImportBtn);
		LoggerUtil.info("Clicked on Export & Import button.");
		Thread.sleep(2000);

		clickOnElement(exportExcelBtn);
		LoggerUtil.info("Clicked on Export without selecting any group/classification.");
		String actualToast1 = waitForExpectedElement(toastmsg1).getText();
		String expectedToast1 = "Please select Commodity Group and Group Classification.";
		LoggerUtil.info("Verifying Toast 1 - Expected: " + expectedToast1 + " | Actual: " + actualToast1);
		softAssert.assertEquals(actualToast1, expectedToast1, "First toast mismatch");

		// ========== 2. Click Export from Group Delta tab ==========
		Thread.sleep(5000);
		clickOnElement(groupdelta);
		LoggerUtil.info("Navigated to Group Delta tab.");
		Thread.sleep(3000);

		clickOnElement(exportExcelBtn);
		LoggerUtil.info("Clicked Export in Group Delta without selecting any group/classification.");
		String actualToast2 = waitForExpectedElement(toastmsg1).getText();
		String expectedToast2 = "Please select Commodity Group and Group Classification.";
		LoggerUtil.info("Verifying Toast 2 - Expected: " + expectedToast2 + " | Actual: " + actualToast2);
		softAssert.assertEquals(actualToast2, expectedToast2, "Second toast mismatch");

		// ========== 3. Click Export from Group Direct Cost tab ==========
		Thread.sleep(5000);
		clickOnElement(grpdirectcost);
		LoggerUtil.info("Navigated to Group Direct Cost tab.");
		Thread.sleep(3000);

		clickOnElement(exportExcelBtn);
		LoggerUtil.info("Clicked Export in Group Direct Cost without selection.");
		String actualToast3 = waitForExpectedElement(toastmsg1).getText();
		String expectedToast3 = "Please select Commodity Group and Group Classification.";
		LoggerUtil.info("Verifying Toast 3 - Expected: " + expectedToast3 + " | Actual: " + actualToast3);
		softAssert.assertEquals(actualToast3, expectedToast3, "Third toast mismatch");

		// ========== 4. Click Export from New Grade tab ==========
		Thread.sleep(5000);
		clickOnElement(newgradebtn);
		LoggerUtil.info("Navigated to New Grade tab.");
		Thread.sleep(3000);

		clickOnElement(exportExcelBtn);
		LoggerUtil.info("Clicked Export in New Grade tab without selection.");
		String actualToast4 = waitForExpectedElement(toastmsg1).getText();
		String expectedToast4 = "Please select either customer or supplier";
		LoggerUtil.info("Verifying Toast 4 - Expected: " + expectedToast4 + " | Actual: " + actualToast4);
		softAssert.assertEquals(actualToast4, expectedToast4, "Fourth toast mismatch");

		// Final Soft Assert
		softAssert.assertAll();
		LoggerUtil.info("All toast validations completed.");
	}

	public static final By EnterIdNameForGivingAutoritySeaechbox = By
			.xpath("//div[@id='example2_filter']/label/input[@class='form-control form-control-sm']");
	public static final By clickingeditbuttonforid = By.xpath("//table[@id='example2']/tbody/tr/td[4]/a/span/i");
	public static final By estimatetriangle = By.xpath("//div[@id='jstree']/ul/li[6]/i");
	public static final By clicksale = By.xpath("//div[@id='jstree']/ul/li[6]/ul/li/a/i");
	public static final By clicksupplier = By.xpath("//div[@id='jstree']/ul/li[6]/ul/li[2]/a/i");
	public static final By supplierfetchingheading = By.xpath("//div[@id='divprocurement']/div/div/h3");
	public static final By customerfetchinfheading = By.xpath("//div[@id='salesideDiv01']/div/div/h3/span");

	public void customerinvisiblityafteruserRight() throws InterruptedException {

		// Step 1: Navigate to User Authority Tab
		clickOnElement(userauthtab);
		LoggerUtil.info("Switched to 'User Authority' tab.");
		Thread.sleep(3000);

		// Step 2: Click Edit on user authority
		clearAndEnterText(waitForExpectedElement(EnterIdNameForGivingAutoritySeaechbox), "sachindra@costmasters.in");
		Thread.sleep(3000);

		clickOnElement(clickingeditbuttonforid);
		captureStepScreenshot("User Click The Ss For Clicking id ");
		Thread.sleep(3000);

		// Step 3: Expand Master menu
		clickOnElement(estimatetriangle);
		LoggerUtil.info("Expanded 'Master' node in user authority tree.");
		Thread.sleep(2000);

		// Step 4: Click Sales permission (assumed disabling customer visibility)
		clickOnElement(clicksale);
		LoggerUtil.info("Updated Sales permission checkbox (revoked customer access).");
		Thread.sleep(3000);

		// Step 5: Save changes
		clickOnElement(clicksavebtnOnuser);
		LoggerUtil.info("Clicked on Save to apply updated user authority permissions.");
		Thread.sleep(3000);

		// Step 6: Navigate back to Commodity Master
		dashboard.clickoncommodityMaster();
		LoggerUtil.info("Reopened 'Commodity Master' to validate updated access rights.");
		Thread.sleep(2000);

		// Step 7: Open Commodity Details tab
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Navigated to 'Commodity Details' tab.");
		Thread.sleep(2000);

		// Step 8: Check Customer heading visibility
		List<WebElement> customerElements = driver.findElements(customerfetchinfheading);
		LoggerUtil.info("Fetched customer-related heading elements. Checking visibility...");

		boolean isVisible = false;
		for (WebElement element : customerElements) {
			if (element.isDisplayed()) {
				isVisible = true;
				break;
			}
		}

		// Step 9: Final Validation
		if (isVisible) {
			LoggerUtil.info("❌ Customer heading is visible even after permission restriction. TEST FAIL.");
			Assert.fail("Customer heading should not be visible under restricted user rights.");
		} else {
			LoggerUtil.info("✅ Customer heading is not visible. Access restriction is working as expected.");
		}
	}

	public void supplierinvisiblityafteruserRight() throws InterruptedException {

		// Step 1: Navigate to User Authority Tab
		clickOnElement(userauthtab);
		LoggerUtil.info("Switched to 'User Authority' tab.");
		Thread.sleep(3000);

		// Step 2: Click Edit on user authority
		clearAndEnterText(waitForExpectedElement(EnterIdNameForGivingAutoritySeaechbox), "sachindra@costmasters.in");
		Thread.sleep(3000);

		clickOnElement(clickingeditbuttonforid);
		captureStepScreenshot("User Click The Ss For Clicking id ");
		Thread.sleep(3000);

		// Step 3: Expand Master menu
		clickOnElement(estimatetriangle);
		LoggerUtil.info("Expanded 'Master' node in user authority tree.");
		Thread.sleep(2000);

		// Step 4: Revoke or adjust Supplier permissions
		clickOnElement(clicksupplier);
		LoggerUtil.info("Updated Supplier permission checkbox (revoked supplier access).");
		Thread.sleep(3000);

		// Step 5: Save authority changes
		clickOnElement(clicksavebtnOnuser);
		LoggerUtil.info("Clicked on Save to apply updated user authority permissions.");
		Thread.sleep(3000);

		// Step 6: Reopen Commodity Master to validate access effect
		dashboard.clickoncommodityMaster();
		LoggerUtil.info("Reopened 'Commodity Master' to validate supplier visibility.");
		Thread.sleep(2000);

		// Step 7: Open Commodity Details tab
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Navigated to 'Commodity Details' tab.");
		Thread.sleep(2000);

		// Step 8: Fetch and validate supplier heading visibility
		List<WebElement> suppleirElements = driver.findElements(supplierfetchingheading);
		LoggerUtil.info("Fetched supplier-related heading elements. Checking visibility...");

		boolean isVisible = false;
		for (WebElement element : suppleirElements) {
			if (element.isDisplayed()) {
				isVisible = true;
				break;
			}
		}

		// Step 9: Final assertion
		if (isVisible) {
			LoggerUtil.info("❌ Supplier heading is visible even after permission restriction. TEST FAIL.");
			Assert.fail("Supplier heading should not be visible under restricted user rights.");
		} else {
			LoggerUtil.info("✅ Supplier heading is not visible. Access restriction is working as expected.");
		}
	}

	public static final By groupdeltaradio = By.xpath("//*[@id='DeltaR']");

	public void exportdatafromuiforEnterTheValueInExcel(String searchCommodityGroup, String searchGroupClassification)
			throws InterruptedException {

		LoggerUtil.info("Step 1: Opening Export/Import modal.");
		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Selecting 'Group Delta' radio option.");
		clickOnElement(groupdeltaradio);
		Thread.sleep(2000);

		LoggerUtil.info("Step 3: Selecting Commodity Group: " + searchCommodityGroup);
		clickOnElement(clickcommoditygroupdropbox);
		Thread.sleep(1000);

		WebElement searchBox = waitForExpectedElement(searchentervaluecommoditygrp);
		searchBox.clear();
		searchBox.sendKeys(searchCommodityGroup);
		Thread.sleep(2000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		clickOnElement(selectallbtncommoditygrp);
		LoggerUtil.pass(" Commodity Group '" + searchCommodityGroup + "' selected successfully.");

		LoggerUtil.info("Step 4: Selecting Group Classification: " + searchGroupClassification);
		clickOnElement(clickgrpclassificationgroupbox);
		Thread.sleep(1000);

		WebElement searchBoxClassification = waitForExpectedElement(searchenetrvaluecommclassification);
		searchBoxClassification.clear();
		searchBoxClassification.sendKeys(searchGroupClassification);
		Thread.sleep(1000);
		searchBoxClassification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		clickOnElement(selectallbtncommclassification);
		LoggerUtil.pass(" Group Classification '" + searchGroupClassification + "' selected successfully.");

		LoggerUtil.info("Step 5: Exporting Excel...");
		clickOnElement(exportExcelBtn);
		Thread.sleep(50000); // Wait for export to finish
		LoggerUtil.pass(" Excel export triggered and wait completed.");

		clickOnElement(groupdeltaradio);
		LoggerUtil.info("Step 6: Re-selecting 'Group Delta' radio after export.");

		File latestFile = getLatestExportedExcelFileForCommoditytypedelta();

		if (latestFile != null) {
			LoggerUtil.pass(" Exported file found: " + latestFile.getName());
			writeDataToExcel(latestFile);
			LoggerUtil.pass(" Data written successfully to the exported Excel.");
		} else {
			LoggerUtil.mismatch("❌ Exported file not found after waiting. Aborting write.");
		}
	}

	public void writeDataToExcel(File excelFile) {
		Random random = new Random();

		try (FileInputStream fis = new FileInputStream(excelFile); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(4);
			if (row == null)
				row = sheet.createRow(4);

			row.createCell(4).setCellValue("2025-2026"); // Column E
			row.createCell(5).setCellValue("May"); // Column F

			int rmPrice = random.nextInt(99) + 1;
			int scrapPrice = random.nextInt(99) + 1;

			row.createCell(6).setCellValue(rmPrice); // G
			row.createCell(7).setCellValue(scrapPrice); // H

			try (FileOutputStream fos = new FileOutputStream(excelFile)) {
				workbook.write(fos);
			}

			LoggerUtil.pass("✅ Data written to Excel: RM = " + rmPrice + ", Scrap = " + scrapPrice);

		} catch (IOException e) {
			LoggerUtil.mismatch("❌ Error writing to Excel file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyDeltaSheetWithRandomAddition(File excelFile, int startRow, int endRow) {
		try (FileInputStream fis = new FileInputStream(excelFile); Workbook workbook = new XSSFWorkbook(fis)) {

			LoggerUtil.info("Opened Excel file: " + excelFile.getName());

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			Sheet yearlySheet = workbook.getSheet("Commodity Yearly (Delta)");
			Sheet deltaSheet = workbook.getSheet("Delta");

			Row yearlyRow = yearlySheet.getRow(4); // 5th row (index 4)
			double rmToAdd = getNumericCellValue(yearlyRow.getCell(6)); // G
			double scrapToAdd = getNumericCellValue(yearlyRow.getCell(7)); // H

			LoggerUtil.info("Random RM to add: " + rmToAdd + " | Random Scrap to add: " + scrapToAdd);

			for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
				Row row = deltaSheet.getRow(rowIndex);
				if (row == null) {
					LoggerUtil.mismatch("❌ Row " + (rowIndex + 1) + " is empty in Delta sheet.");
					continue;
				}

				double baseRM = getNumericCellValue(row.getCell(10)); // K
				double baseScrap = getNumericCellValue(row.getCell(11)); // L

				double expectedRM = baseRM + rmToAdd;
				double expectedScrap = baseScrap + scrapToAdd;

				double actualRM = evaluateCellSafe(row.getCell(14), evaluator, "RM", rowIndex + 1); // O
				double actualScrap = evaluateCellSafe(row.getCell(15), evaluator, "Scrap", rowIndex + 1); // P

				LoggerUtil.info("Row " + (rowIndex + 1) + ": Base RM = " + baseRM + ", Base Scrap = " + baseScrap);
				LoggerUtil.info("Expected RM = " + expectedRM + ", Actual RM = " + actualRM);
				LoggerUtil.info("Expected Scrap = " + expectedScrap + ", Actual Scrap = " + actualScrap);

				boolean rmMatch = Double.compare(actualRM, expectedRM) == 0;
				boolean scrapMatch = Double.compare(actualScrap, expectedScrap) == 0;

				if (rmMatch && scrapMatch) {
					LoggerUtil.pass("✅ Row " + (rowIndex + 1) + ": RM & Scrap match.");
				} else {
					LoggerUtil.mismatch("❌ Row " + (rowIndex + 1) + ": Value mismatch detected.");
					if (!rmMatch) {
						LoggerUtil.mismatch("   ❌ RM mismatch → Expected: " + expectedRM + ", Actual: " + actualRM);
					}
					if (!scrapMatch) {
						LoggerUtil.mismatch(
								"   ❌ Scrap mismatch → Expected: " + expectedScrap + ", Actual: " + actualScrap);
					}
				}
			}

		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Error during Delta verification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private double evaluateCellSafe(Cell cell, FormulaEvaluator evaluator, String columnLabel, int rowNum) {
		if (cell == null) {
			LoggerUtil.mismatch("❌ " + columnLabel + " cell is null at row: " + rowNum);
			return 0.0;
		}

		try {
			CellValue evaluated = evaluator.evaluate(cell);
			if (evaluated != null && evaluated.getCellType() == CellType.NUMERIC) {
				return evaluated.getNumberValue();
			} else {
				LoggerUtil.mismatch("❌ " + columnLabel + " formula not numeric or failed at row: " + rowNum);
			}
		} catch (Exception e) {
			LoggerUtil.mismatch(
					"❌ Exception while evaluating " + columnLabel + " at row " + rowNum + ": " + e.getMessage());
		}

		return 0.0;
	}

	private double getNumericCellValue(Cell cell) {
		if (cell == null)
			return 0.0;
		try {
			switch (cell.getCellType()) {
			case NUMERIC:
				return cell.getNumericCellValue();
			case STRING:
				return Double.parseDouble(cell.getStringCellValue().trim());
			default:
				return 0.0;
			}
		} catch (Exception e) {
			return 0.0;
		}
	}

	public void pressCtrlSAndRefreshUI() {
		try {
			// Trigger Ctrl + S using Actions
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
			LoggerUtil.info("✅ Ctrl + S triggered via Actions.");

			// Refresh the page after saving the file
			driver.navigate().refresh();
			LoggerUtil.info("✅ UI refreshed to reflect the saved data.");
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Failed during Ctrl + S and Refresh via Actions: " + e.getMessage());
		}
	}

	public void pressCtrlSUsingRobot() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			LoggerUtil.info("✅ Ctrl + S triggered using Robot.");
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Failed to trigger Ctrl + S using Robot: " + e.getMessage());
		}
	}

	public static final By Deltaexcelfileupload = By.xpath("(//input[@id='excelUpload'])[1]");

	public void importDeltaExcelFileExcelFileToUI(File excelFile) throws InterruptedException {

		LoggerUtil.info("Step 1: Opening Export/Import modal.");
		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Selecting 'Group Delta' radio option.");
		clickOnElement(groupdeltaradio);
		Thread.sleep(2000);

		try {
			WebElement fileInput = driver.findElement(Deltaexcelfileupload);

			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			fileInput.sendKeys(excelFile.getAbsolutePath());

			// File upload hone ka wait karein
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeToBeNotEmpty(fileInput, "value"));

			System.out.println("✅ Excel file uploaded successfully: " + excelFile.getName());
			LoggerUtil.info("✅ Excel file uploaded successfully: " + excelFile.getName());

		} catch (Exception e) {
			System.out.println("❌ Excel file upload failed: " + e.getMessage());
			LoggerUtil.info("❌ Excel file upload failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By clickcrossbtnofexcelpop = By.xpath("//*[@id='exportModal']/div/div/div[1]/button");
	public static final By fetchingsubgroup = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[4]");

	public void verifydeltavalueareupdateornot() throws InterruptedException {
		LoggerUtil.info("Step 1: Closing Excel popup.");
		clickOnElement(clickcrossbtnofexcelpop);
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Clicking 'View' to reload updated data.");
		clickOnElement(ClickingViewbtn);
		Thread.sleep(35000); // Wait for table refresh

		LoggerUtil.info("Step 3: Searching for group classification 'Genevive 39'.");
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), "Genevive 39");
		Thread.sleep(30000); // Allow table to update

		String actualvalue = waitForExpectedElement(fetchingsubgroup).getText().trim();
		String expectedvalue = "Genevive 39";

		LoggerUtil.info("Step 4: Verifying classification. Expected = " + expectedvalue + ", Actual = " + actualvalue);

		try {
			Assert.assertEquals(actualvalue, expectedvalue);
			LoggerUtil.pass("✅ Classification matched successfully: " + actualvalue);
		} catch (AssertionError e) {
			LoggerUtil.mismatch("❌ Classification mismatch. Expected: " + expectedvalue + ", Found: " + actualvalue);
			throw e;
		}

		LoggerUtil.info("Step 5: Clicking Edit to confirm entry is editable.");
		clickOnElement(editbtncomdetails);
	}

	public static final By exportExcelBtn1 = By.xpath("//*[@id='exportModal']/div/div/div[3]/button");

	public void savedatainthirdtabForimporitingGroupDelta(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String enterAprilrm,
			String enteraprilscrap) throws InterruptedException {

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		// April RM (Dynamic)
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), enterAprilrm);
		LoggerUtil.info("Entered April RM → " + enterAprilrm);
		Thread.sleep(2000);

		// April Scrap (Dynamic)
		clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), enteraprilscrap);
		LoggerUtil.info("Entered April Scrap → " + enteraprilscrap);
		Thread.sleep(2000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Thread.sleep(9000);

	}

	public void exportImportbutton(String searchCommodityGroup, String searchGroupClassification)
			throws InterruptedException {

		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		clickOnElement(groupdeltaradio);
		Thread.sleep(2000);
		clickOnElement(clickcommoditygroupdropbox);
		Thread.sleep(1000);

		WebElement searchBox = waitForExpectedElement(searchentervaluecommoditygrp);
		searchBox.clear();
		searchBox.sendKeys(searchCommodityGroup);
		Thread.sleep(2000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		clickOnElement(selectallbtncommoditygrp);

		clickOnElement(clickgrpclassificationgroupbox);
		Thread.sleep(1000);

		WebElement searchBoxClassification = waitForExpectedElement(searchenetrvaluecommclassification);
		searchBoxClassification.clear();
		searchBoxClassification.sendKeys(searchGroupClassification);
		Thread.sleep(1000);
		searchBoxClassification.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		clickOnElement(selectallbtncommclassification);

		clickOnElement(exportExcelBtn);
		Thread.sleep(50000);
		clickOnElement(groupdeltaradio);

		// Get the latest file after export is complete
		File latestFile = getLatestExportedExcelFileForCommoditytypedelta();

		if (latestFile != null) {
			// Write data into the latest file
			writeDataToExcel(latestFile);
		} else {
			System.out.println("❌ No file found after waiting.");
		}

	}

	public void writeDataToExcel1(File excelFile) {
		Random random = new Random(); // ✅ Add random generator

		try (FileInputStream fis = new FileInputStream(excelFile); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(4); // Row 5 (index 4)

			if (row == null)
				row = sheet.createRow(4); // If row doesn't exist, create it

			// Set values for columns E (index 4) and F (index 5)
			row.createCell(4).setCellValue("2025-2026"); // Column E
			row.createCell(5).setCellValue("May"); // Column F

			// ✅ Use random numbers for price (between 1 to 99)
			int rmPrice = random.nextInt(99) + 1;
			int scrapPrice = random.nextInt(99) + 1;

			row.createCell(6).setCellValue(rmPrice); // Column G (RM price)
			row.createCell(7).setCellValue(scrapPrice); // Column H (Scrap price)

			// Save the changes to the file
			try (FileOutputStream fos = new FileOutputStream(excelFile)) {
				workbook.write(fos);
			}

			System.out.println("✅ Data written successfully to the Excel file.");
			System.out.println("Random RM: " + rmPrice + ", Scrap: " + scrapPrice);

		} catch (IOException e) {
			System.out.println("❌ Error writing to the Excel file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String getCellValueSafe(Row row, int cellIndex) {
		Cell cell = row.getCell(cellIndex);
		if (cell == null) {
			return ""; // Return an empty string if the cell is null
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue()).trim();
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue()).trim();
		default:
			return ""; // Return an empty string for other cell types
		}
	}

	private double getCalculatedCellValue(FormulaEvaluator evaluator, Cell cell) {
		if (cell == null) {
			return 0.0;
		}

		// Evaluating the formula in the cell
		CellValue cellValue = evaluator.evaluate(cell);

		// If the cell is empty or formula couldn't be evaluated, return 0.0
		if (cellValue == null) {
			return 0.0;
		}

		// Return the value based on the type of the cell's evaluation result
		if (cellValue.getCellType() == CellType.NUMERIC) {
			return cellValue.getNumberValue();
		}

		// If it's not numeric, return 0.0
		return 0.0;
	}

	public void verifyMultipleRowsCalculationWithFormula(File excelFile, int startRow, int endRow) {
		final int delta = 9; // ✅ You can modify delta logic if needed
		try (FileInputStream fis = new FileInputStream(excelFile); Workbook workbook = new XSSFWorkbook(fis)) {

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			Sheet sheet = workbook.getSheet("Delta");

			for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row == null) {
					System.out.println("❌ Row " + (rowIndex + 1) + " is empty!");
					continue;
				}

				Cell cellRM = row.getCell(10); // Column K
				Cell cellScrap = row.getCell(11); // Column L
				Cell calculatedRM = row.getCell(14); // Column O
				Cell calculatedScrap = row.getCell(15); // Column P

				double rmValue = getNumericCellValue(cellRM);
				double scrapValue = getNumericCellValue(cellScrap);

				// Use the new method to safely get the calculated cell values
				double actualCalculatedRM = getCalculatedCellValue(evaluator, calculatedRM);
				double actualCalculatedScrap = getCalculatedCellValue(evaluator, calculatedScrap);

				double expectedCalculatedRM = rmValue + delta;
				double expectedCalculatedScrap = scrapValue + delta;

				System.out.println("---- Debugging Row " + (rowIndex + 1) + " ----");
				System.out.println("Column K (RM): " + rmValue);
				System.out.println("Column L (Scrap): " + scrapValue);
				System.out.println("Column O (Evaluated RM): " + actualCalculatedRM);
				System.out.println("Column P (Evaluated Scrap): " + actualCalculatedScrap);
				System.out.println("Expected Column O (RM): " + expectedCalculatedRM);
				System.out.println("Expected Column P (Scrap): " + expectedCalculatedScrap);

				boolean rmMatch = Double.compare(actualCalculatedRM, expectedCalculatedRM) == 0;
				boolean scrapMatch = Double.compare(actualCalculatedScrap, expectedCalculatedScrap) == 0;

				if (rmMatch && scrapMatch) {
					System.out.println("✅ Row " + (rowIndex + 1) + " calculation correct!");
				} else {
					System.out.println("❌ Row " + (rowIndex + 1) + " calculation mismatch!");
					if (!rmMatch) {
						System.out.println("   ❌ RM mismatch: Expected = " + expectedCalculatedRM + ", Actual = "
								+ actualCalculatedRM);
					}
					if (!scrapMatch) {
						System.out.println("   ❌ Scrap mismatch: Expected = " + expectedCalculatedScrap + ", Actual = "
								+ actualCalculatedScrap);
					}
				}
			}

		} catch (IOException e) {
			System.out.println("❌ Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By FetchingCommodityDetailsTableData = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr[1]/td[2]/following-sibling::td");

	public void verifySearchTableWithoutSearch() throws InterruptedException {
		LoggerUtil.info("===== Commodity Details Table Search Verification START =====");

		try {
			Thread.sleep(2000);
			LoggerUtil.info("Clicking on View button...");
			clickOnElement(ClickingViewbtn);

			Thread.sleep(2000);
			LoggerUtil.info("Entering search value: GI Sheet");
			clearAndEnterText(waitForExpectedElement(enterSearchValueCommodityDetailsTab), "GI Sheet");

			Thread.sleep(500);

			List<WebElement> rowsList = driver.findElements(FetchingCommodityDetailsTableData);
			if (rowsList.isEmpty()) {
				LoggerUtil.fail("Row list of Commodity Details Tab is empty. No data found for search.");
				return;
			}

			LoggerUtil.info("Total rows found: " + rowsList.size());

			boolean matchFound = false;

			for (WebElement row : rowsList) {
				List<WebElement> columns = row.findElements(By.tagName("td"));

				if (columns.size() >= 6) {
					String actualCommodityGroup = columns.get(3).getText().trim();
					String actualGroupClassification = columns.get(4).getText().trim();
					String actualSpecificGrade = columns.get(5).getText().trim();

					LoggerUtil.info("Row Data -> CommodityGroup: " + actualCommodityGroup + " | GroupClassification: "
							+ actualGroupClassification + " | SpecificGrade: " + actualSpecificGrade);

					if (actualCommodityGroup.equalsIgnoreCase("GI Sheet")
							|| actualGroupClassification.equalsIgnoreCase("GI Sheet")
							|| actualSpecificGrade.equalsIgnoreCase("GI Sheet")) {
						LoggerUtil.pass("Match found successfully in row → CommodityGroup: " + actualCommodityGroup
								+ ", GroupClassification: " + actualGroupClassification + ", SpecificGrade: "
								+ actualSpecificGrade);
						matchFound = true;
					}
				}
			}

			if (!matchFound) {
				LoggerUtil.fail("No matching record found for 'GI Sheet' in Commodity Details Tab.");
			}

		} catch (Exception e) {
			LoggerUtil.error("Error occurred while verifying search in Commodity Details Tab: " + e.getMessage());
		}

	}

	public static final By FetchingCommodityDetailsTabHeaders = By
			.xpath("//input[@id='comodityDetailID']/following-sibling::div/div/div/div/label");
	public static final By FetchingPlaceholderForEnterValueCell = By
			.xpath("//input[@id='comodityDetailID']/following-sibling::div/div/div/div/following-sibling::div/input");
	// public static final By

	public void verifyHeadersForCommodityDetailsTab() {
		LoggerUtil.info("===== Commodity Details Tab Header Verification START =====");

		try {
			List<WebElement> fetchHeadersName = driver.findElements(FetchingCommodityDetailsTabHeaders);

			if (fetchHeadersName.isEmpty()) {
				LoggerUtil.fail("No headers found in Commodity Details Tab!");
				return;
			}

			for (WebElement header : fetchHeadersName) {
				String actualPageHeader = header.getText().trim();

				LoggerUtil.info("Header found: " + actualPageHeader);

			}

		} catch (Exception e) {

			LoggerUtil.fail("Exception" + e.getCause());
		}

	}

	public static final By VerifyPlaceHolderCommodityGroupDropdown = By
			.xpath("//select[@id='commodityDrop']/following-sibling::span/span/span/span");
	public static final By VerifyPlaceHolderGroupClassificationDropdown = By
			.xpath("//span[@id='select2-materialDrop-container']/span");
	public static final By VerifyPlaceholderSpecificGradeDropdown = By
			.xpath("//span[@id='select2-SpecificGrade-container']/span");
	public static final By VeriFyPlaceholderUOMDropDown = By.xpath("//span[@id='select2-uomDrop-container']");
	public static final By VerifyPlaceholderShapeDropdown = By.xpath("//span[@id='select2-shapeDrop-container']");
	public static final By VeriFyPlaceholderUomDropdown = By.xpath("//span[@id='select2-shapeDrop-container']");
	public static final By VerifyPlacehoderSelectYear = By.xpath("//span[@id='select2-Year-container']");

	public void verifyPlaceholders() throws InterruptedException {
		LoggerUtil.info("===== Placeholder Validation START =====");

		SoftAssert soft = new SoftAssert();
		Thread.sleep(3000);

		try {
			String actualCommodityGroup = waitForExpectedElement(VerifyPlaceHolderCommodityGroupDropdown).getText()
					.trim();
			String expectedCommodityGroup = "Select";
			if (actualCommodityGroup.equals(expectedCommodityGroup)) {
				LoggerUtil.pass("Commodity Group placeholder matched: " + actualCommodityGroup);
			} else {
				LoggerUtil.fail("Commodity Group placeholder mismatch. Expected: " + expectedCommodityGroup
						+ " | Actual: " + actualCommodityGroup);
			}
			soft.assertEquals(actualCommodityGroup, expectedCommodityGroup, "Commodity Group placeholder mismatch");

			String actualGroupClassification = waitForExpectedElement(VerifyPlaceHolderGroupClassificationDropdown)
					.getText().trim();
			String expectedGroupClassification = "Select";
			if (actualGroupClassification.equals(expectedGroupClassification)) {
				LoggerUtil.pass("Group Classification placeholder matched: " + actualGroupClassification);
			} else {
				LoggerUtil.fail("Group Classification placeholder mismatch. Expected: " + expectedGroupClassification
						+ " | Actual: " + actualGroupClassification);
			}
			soft.assertEquals(actualGroupClassification, expectedGroupClassification,
					"Group Classification placeholder mismatch");

			String actualSpecificGrade = waitForExpectedElement(VerifyPlaceholderSpecificGradeDropdown).getText()
					.trim();
			String expectedSpecificGrade = "Select";
			if (actualSpecificGrade.equals(expectedSpecificGrade)) {
				LoggerUtil.pass("Specific Grade placeholder matched: " + actualSpecificGrade);
			} else {
				LoggerUtil.fail("Specific Grade placeholder mismatch. Expected: " + expectedSpecificGrade
						+ " | Actual: " + actualSpecificGrade);
			}
			soft.assertEquals(actualSpecificGrade, expectedSpecificGrade, "Specific Grade placeholder mismatch");

			String actualUOM = waitForExpectedElement(VeriFyPlaceholderUOMDropDown).getText().trim();
			String expectedUOM = "Select";
			if (actualUOM.equals(expectedUOM)) {
				LoggerUtil.pass("UOM placeholder matched: " + actualUOM);
			} else {
				LoggerUtil.fail("UOM placeholder mismatch. Expected: " + expectedUOM + " | Actual: " + actualUOM);
			}
			soft.assertEquals(actualUOM, expectedUOM, "UOM placeholder mismatch");

		} catch (Exception e) {
			LoggerUtil.error("Error during placeholder validation: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By fetchingRmPlaceholder = By.xpath("//*[@class='yearly_cs_border']/div/div/div/div[1]/input");
	public static final By FetchingLabelName = By.xpath("//*[@class='yearly_cs_border']/div/div/label");

	public void verifyPlaceHolderRm() {

		try {
			List<WebElement> labelList = driver.findElements(FetchingLabelName);
			List<WebElement> inputList = driver.findElements(fetchingRmPlaceholder);

			if (labelList.size() != inputList.size()) {
				LoggerUtil.fail("Mismatch in counts! Labels found: " + labelList.size() + " | Inputs found: "
						+ inputList.size());
				return;
			}

			LoggerUtil.info("Total fields found: " + labelList.size());

			for (int i = 0; i < labelList.size(); i++) {
				String labelName = labelList.get(i).getText().trim();
				String placeholderValue = inputList.get(i).getAttribute("placeholder");

				LoggerUtil.info(
						"Row " + (i + 1) + " => Label: [" + labelName + "] | Placeholder: [" + placeholderValue + "]");

				if (placeholderValue == null || placeholderValue.isEmpty()) {
					LoggerUtil.fail("Row " + (i + 1) + ": Placeholder missing for label '" + labelName + "'");
				} else {
					LoggerUtil.pass("Row " + (i + 1) + ": Label '" + labelName + "' has placeholder '"
							+ placeholderValue + "'");
				}
			}

		} catch (Exception e) {
			LoggerUtil.error("Error while validating RM placeholders: " + e.getMessage());

		}

	}

	public static final By FetchingPlaceholderScrapValue = By
			.xpath("//*[@class='yearly_cs_border']/div/div/div/div[2]/input");

	public void VerifyScrapValue() {

		SoftAssert soft = new SoftAssert();

		try {
			List<WebElement> fetchScrapValuePlaceholder = driver.findElements(FetchingPlaceholderScrapValue);
			List<WebElement> fetchingLabelName = driver.findElements(FetchingLabelName);

			int size = Math.min(fetchScrapValuePlaceholder.size(), fetchingLabelName.size());
			LoggerUtil.info("Total Scrap fields found: " + size);

			for (int i = 0; i < size; i++) {
				String labelName = fetchingLabelName.get(i).getText().trim();
				String placeHolderScrap = fetchScrapValuePlaceholder.get(i).getAttribute("placeholder");

				if (placeHolderScrap != null && !placeHolderScrap.isEmpty()) {
					LoggerUtil.pass("Row " + (i + 1) + " → Label: [" + labelName + "] | Placeholder: ["
							+ placeHolderScrap + "]");
				} else {
					LoggerUtil.fail("Row " + (i + 1) + " → Label: [" + labelName + "] | Placeholder missing/empty");
				}

				soft.assertTrue(placeHolderScrap != null && !placeHolderScrap.isEmpty(),
						"Placeholder missing for label: " + labelName);
			}

		} catch (Exception e) {
			LoggerUtil.error("Error during Scrap Placeholder validation: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By EnterValueSpeciFicGradeText = By.xpath("//input[@id='SpecificGradeText']");

	public void verifySpecificgradeVerification() throws InterruptedException {

		WebElement EnteringValue = driver.findElement(EnterValueSpeciFicGradeText);

		int i = 0;

		for (; i < 300; i++) {

			EnteringValue.sendKeys(String.valueOf(i));

			LoggerUtil.info("" + i);

		}
		if (i < 250) {

			LoggerUtil.fail("Grade Cell Getting More Than 250 Characters");

		} else {

			LoggerUtil.pass("Grade Cell Is not Getting More Than 250 Characters");

		}

	}

	public static final By SelcitngCommodityGroupThirdTabByIndexing = By
			.xpath("//ul[@id='select2-commodityDrop-results']/li/following-sibling::li");

	public void SaveDataWithInValidSpecificGrade(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue) throws InterruptedException {

		Thread.sleep(7000);

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);
		List<WebElement> optionsValueCommodityGroups = driver.findElements(SelcitngCommodityGroupThirdTabByIndexing);
		Thread.sleep(200);
		WebElement selectingCommodityGroupValue = optionsValueCommodityGroups.get(1);
		selectingCommodityGroupValue.click();
		Thread.sleep(299);
		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);
		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		Thread.sleep(200);
		WebElement selctingGroupClassificationValue = grpclasslist.get(2);
		Thread.sleep(200);
		selctingGroupClassificationValue.click();
		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		Thread.sleep(300);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		Thread.sleep(200);
		WebElement selctingGradeList = comgradelist.get(1);
		Thread.sleep(200);
		selctingGradeList.click();
		Thread.sleep(200);

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);
		JavascriptExecutor js0 = (JavascriptExecutor) driver;
		js0.executeScript("window.scrollBy(0, 100);");

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 130);");

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 120);");

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Thread.sleep(4000);
	}

	public void savedatainthirdtabForNegativeValues(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		Thread.sleep(3000);

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 160);");

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		String ActualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
		String expectedMessage = "InValid Density Value";
		Assert.assertEquals(expectedMessage, ActualMessage);

	}

	public void DependentDropdownCommodityGroupClassificationGrade(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		LoggerUtil.info("=== TC: Dependent Dropdown Commodity → Group Classification → Specific Grade ===");

		try {
			Thread.sleep(3000);
			clickOnElement(ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(3000);

			if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
				LoggerUtil.fail("Commodity dropdown value is EMPTY for mandatory field validation.");
			} else {
				LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
			}

			clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

			List<WebElement> comlist = driver.findElements(commoditydropdownlist);
			boolean commodityFound = false;
			for (WebElement comgrpvalue : comlist) {
				String flagcomgrpval = comgrpvalue.getText().trim();
				if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
					comgrpvalue.click();
					LoggerUtil.pass("Selected Commodity from dropdown: " + flagcomgrpval);
					commodityFound = true;
					break;
				}
			}
			if (!commodityFound) {
				LoggerUtil.fail("Commodity value not found in dropdown: " + searchcommoditydropvalue);
			}

			Thread.sleep(3000);
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
			boolean grpFound = false;
			for (WebElement grpclasslistval : grpclasslist) {
				String comclssifi = grpclasslistval.getText().trim();
				if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
					grpclasslistval.click();
					LoggerUtil.pass("Selected Group Classification: " + comclssifi);
					grpFound = true;
					break;
				}
			}
			if (!grpFound) {
				LoggerUtil.fail("Group Classification not found: " + searchcommodityclassification);
			}

			Thread.sleep(3000);
			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
			List<WebElement> comgradelist = driver.findElements(specificgradelist);
			boolean gradeFound = false;
			for (WebElement comgradelistval : comgradelist) {
				String comgrade = comgradelistval.getText().trim();
				if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
					comgradelistval.click();
					LoggerUtil.pass("Selected Specific Grade: " + comgrade);
					gradeFound = true;
					break;
				}
			}
			if (!gradeFound) {
				LoggerUtil.fail("Specific Grade not found: " + selectcommoditygradevalue);
			}

			// UOM
			clickOnElement(Uomdropdown);
			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			searchuom.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Entered UOM as: Mtr");

			// Shape
			clickOnElement(ClickingShapedropdownForthirdTab);
			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			clearAndEnterText(shapesearch, "Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Entered Shape as: Sheet");

			// Scroll
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 160);");

			// Year
			clickOnElement(selectyeardrop);
			WebElement yearsearch = waitForExpectedElement(searchinputyear);
			clearAndEnterText(yearsearch, "2025-2026");
			yearsearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Entered Year as: 2025-2026");

			// Business Segment
			clickOnElement(businessSegbox);
			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			LoggerUtil.info("Entered Business Segment search: rishi");
			clickOnElement(selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Selected all checkboxes in Business Segment.");

			// Customer Checkbox
			clickOnElement(customercheckbox);
			LoggerUtil.pass("Selected Customer Checkbox.");

			// Save and validate Toast
			clickOnElement(ClickingSaveBtnForThirdTab);
			LoggerUtil.info("Clicked Save in Third Tab for Commodity Details.");
			String actualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText().trim();
			String expectedMessage = "Commodity details saved successfully.";

			if (actualMessage.equalsIgnoreCase(expectedMessage)) {
				LoggerUtil.pass("Toast message validated successfully. Expected/Actual: " + expectedMessage + " / "
						+ actualMessage);
			} else {
				LoggerUtil.fail("Toast message mismatch. Expected: " + expectedMessage + " | Actual: " + actualMessage);
			}
			Assert.assertEquals(actualMessage, expectedMessage);

		} catch (Exception e) {
			LoggerUtil.error("Exception in DependentDropdownCommodityGroupClassificationGrade: " + e.getMessage());

			throw e;
		}
	}

	public static final By CommodityDropdownListDropdownThirdTab = By
			.xpath("//ul[@id='select2-commodityDrop-results']/li");
	public static final By EnterSearchValueClassificationThirdTab = By.xpath("//input[@class='select2-search__field']");

	public void verifySearchFilter(String searchcommoditydropvalue, String searchclassificationvalue)
			throws InterruptedException {

		Thread.sleep(7000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);
		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(CommodityDropdownListDropdownThirdTab);

		for (WebElement FlagGroup : comlist) {

			String FetchingValue = FlagGroup.getText().trim();

			if (FetchingValue.equals(searchcommoditydropvalue)) {

				LoggerUtil.pass("Commodity Group Search Filter Is Working Good ");

				FlagGroup.click();

			} else {

				LoggerUtil.error("Search Filter Is not Working Good ");
			}

			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);
			boolean grpFound = false;
			try {
				List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
				for (WebElement grpclasslistval : grpclasslist) {
					String comclssifi = grpclasslistval.getText().trim();
					if (comclssifi.equalsIgnoreCase(searchclassificationvalue)) {
						grpclasslistval.click();

						// ✅ stale avoid: do not use grpclasslistval.getText() after click
						LoggerUtil.pass("Selected Group Classification: " + searchclassificationvalue);

						// ✅ optional: verify from selected value container (fresh element)
						WebElement selected = driver.findElement(By.id("select2-commodityDrop-container"));
						LoggerUtil.info("UI shows selected value: " + selected.getText());

						grpFound = true;
						break;
					}
				}
			} catch (Exception e) {
				LoggerUtil.error("Exception while selecting Group Classification: " + e.getMessage());
			}

			if (!grpFound) {
				LoggerUtil.fail("Group Classification not found: " + searchclassificationvalue);
			}

		}

	}

	public static final By clickingCustomerCheckboxes = By
			.xpath("//table[@id='rmCustomer']/tbody/tr/td/div/label/input");
	public static final By fetchingSaveButtonCommodityDetailsTab = By.xpath("//button[@id='tab3Save']");

	public void MultiSelectCustomers() {
		try {
			LoggerUtil.info("Waiting before starting MultiSelectCustomers...");
			Thread.sleep(10000);

			By saveBtn = By.xpath("//button[@id='tab3Save']");
			WebElement element = Base.waitForExpectedElement(saveBtn);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.pageYOffset - 100);",
					element);

			js.executeScript("arguments[0].scrollIntoView(true);", element);

			js.executeScript("window.scrollBy(0, 650);");

			Thread.sleep(500);

			String buttonText = element.getText().trim();
			if (buttonText.isEmpty()) {
				buttonText = element.getAttribute("innerText").trim();
			}
			LoggerUtil.info("Forcefully scrolled to element: " + buttonText);

			List<WebElement> customerCheckboxes = driver.findElements(clickingCustomerCheckboxes);

			if (customerCheckboxes.isEmpty()) {
				LoggerUtil.fail("No customer checkboxes found!");
				return;
			}

			int clickedCount = 0;
			for (WebElement checkbox : customerCheckboxes) {
				try {
					checkbox.click();
					clickedCount++;
				} catch (Exception ex) {

					js.executeScript("arguments[0].click();", checkbox);
					clickedCount++;
				}
			}

			LoggerUtil.info("Total number of checkboxes clicked = " + clickedCount);

			if (clickedCount > 0) {
				LoggerUtil.pass("Multiple customers were successfully selected.");
			} else {
				LoggerUtil.fail("No customers were selected.");
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in MultiSelectCustomers: " + e.getMessage());
		}
	}

	public static final By HeaderVerificationOfVieWTable = By
			.xpath("//h3[contains(text(),'Commodity Description List')]");
	public static final By ClickingViewButton = By
			.xpath("//button[@onclick='comodityDetailList()' and normalize-space() = 'View']");

	public void verifyTableHeaderAndAlignment() {
		try {
			LoggerUtil.info("Waiting for table header verification process to start...");
			Thread.sleep(6000);

			// Click on View button
			LoggerUtil.info("Clicking on the View button...");
			Base.clickOnElement(ClickingViewButton);

			Thread.sleep(2000);

			// Capture actual table header
			String actualViewTableHeader = Base.waitForExpectedElement(HeaderVerificationOfVieWTable).getText();
			String expectedViewTableHeader = "Commodity Description List";

			LoggerUtil.info("Expected Table Header: " + expectedViewTableHeader);
			LoggerUtil.info("Actual Table Header: " + actualViewTableHeader);

			if (actualViewTableHeader.equals(expectedViewTableHeader)) {
				LoggerUtil.pass("Table header is displayed correctly and aligned: " + actualViewTableHeader);
			} else {
				LoggerUtil.fail("Table header mismatch! Expected: " + expectedViewTableHeader + " | Actual: "
						+ actualViewTableHeader);
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifyTableHeaderAndAlignment: " + e.getMessage());
		}
	}

	public static final By fetchingViewTableHeaderList = By.xpath("//table[@id='comodityDetailListTable']/thead/tr/th");

	public void verifyHeaderList() {
		try {
			LoggerUtil.info("Waiting before verifying header list...");
			Thread.sleep(6000);

			LoggerUtil.info("Clicking on the View button...");
			Base.clickOnElement(ClickingViewButton);

			Thread.sleep(2000);

			List<WebElement> headingList = driver.findElements(fetchingViewTableHeaderList);

			if (headingList.isEmpty()) {
				LoggerUtil.fail("No headers found in the table!");
				return;
			}

			ArrayList<String> names = new ArrayList<>();
			for (WebElement flagHeaderValue : headingList) {
				String headerName = flagHeaderValue.getText().trim();
				names.add(headerName);
			}

			LoggerUtil.info("Total number of headers found: " + names.size());

			for (int i = 0; i < names.size(); i++) {
				LoggerUtil.info("Header " + (i + 1) + ": " + names.get(i));
			}

			if (names.size() == 67) {
				LoggerUtil.pass("All 67 headers are displayed correctly.");
			} else {
				LoggerUtil.fail("Header count mismatch! Expected: 67 | Actual: " + names.size());
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifyHeaderList: " + e.getMessage());
		}
	}

	public static final By FetchingSerialNumber = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[1]");

	public void VerifyNumeberOfRowInTable() {
		try {
			LoggerUtil.info("Waiting before verifying number of rows in the table...");
			Thread.sleep(6000);

			LoggerUtil.info("Clicking on the View button...");
			Base.clickOnElement(ClickingViewButton);

			Thread.sleep(2000);

			List<WebElement> SNo = driver.findElements(FetchingSerialNumber);

			final String numberingConcept = "\\d+(\\.\\d+)?";

			if (SNo.isEmpty()) {
				LoggerUtil.fail("No rows found in the table!");
				return;
			}

			ArrayList<String> numbers = new ArrayList<>();
			boolean allNumeric = true;

			for (WebElement flagSno : SNo) {
				String serialNumber = flagSno.getText().trim();
				numbers.add(serialNumber);

				if (!serialNumber.matches(numberingConcept)) {
					allNumeric = false;
					LoggerUtil.fail("Non-numeric value found in Serial No column: " + serialNumber);
				}
			}

			if (allNumeric) {
				Collections.sort(numbers);
				LoggerUtil.pass("All serial numbers are numeric. Sorted list prepared.");
			}

			LoggerUtil.info("Total number of rows found in table: " + numbers.size());

			for (int i = 0; i < numbers.size(); i++) {
				LoggerUtil.info("Row " + (i + 1) + " Serial No: " + numbers.get(i));
			}

			if (numbers.size() > 0) {
				LoggerUtil.pass("Table row verification successful. Found " + numbers.size() + " rows.");
			} else {
				LoggerUtil.fail("Table row verification failed. No rows found.");
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in VerifyNumeberOfRowInTable: " + e.getMessage());
		}
	}

	public static final By FilterCheckboxList = By.xpath("//div[@id='chkddd']/label/input");
	public static final By FetchingColomListForCommodityGroup = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr[1]/td");

	public void verifySearchFilterColumnValue(String filterName, String searchValue, int colIndex,
			String expectedValue) {
		try {
			LoggerUtil.info("Waiting before verifying column value in table...");
			Thread.sleep(6000);

			LoggerUtil.info("Clicking on the View button...");
			Base.clickOnElement(ClickingViewButton);
			Thread.sleep(2000);

			clickOnElement(clicksearchfileter);
			LoggerUtil.info("Filter dropdown opened...");

			List<WebElement> filterCheckboxes = driver.findElements(FilterCheckboxList);
			boolean filterSelected = false;
			for (WebElement flagCheckbox : filterCheckboxes) {
				String flagName = flagCheckbox.getAttribute("value").trim();
				if (flagName.equalsIgnoreCase(filterName)) {
					flagCheckbox.click();
					LoggerUtil.info("Selected filter checkbox: " + flagName);
					filterSelected = true;
					Thread.sleep(6000);
					break;
				}
			}
			if (!filterSelected) {
				LoggerUtil.fail("Filter checkbox with name '" + filterName + "' not found!");
				return;
			}

			clearAndEnterText(waitForExpectedElement(enterSearchValueCommodityDetailsTab), searchValue);
			LoggerUtil.info("Entered search value: " + searchValue);
			Thread.sleep(3000);

			List<WebElement> cols = driver.findElements(FetchingColomListForCommodityGroup);

			if (cols.size() < colIndex) {
				LoggerUtil.fail("Invalid column index: " + colIndex + ". Table has only " + cols.size() + " columns.");
				return;
			}

			String actualValue = cols.get(colIndex - 1).getText().trim();

			LoggerUtil.info("Column " + colIndex + " => Expected: " + expectedValue + " | Actual: " + actualValue);

			if (actualValue.equals(expectedValue.trim())) {
				LoggerUtil.pass("Column " + colIndex + " value matched: " + actualValue);
			} else {
				LoggerUtil.fail("Column " + colIndex + " value mismatch! Expected: " + expectedValue + " | Actual: "
						+ actualValue);
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception in verifySearchFilterColumnValue: " + e.getMessage());
		}
	}

	public static final By clickingExportAndImportButton = By.xpath("//button[@onclick='bindExportTypeList()']");
	public static final By clickingCommodityDropdownForExportImport = By
			.xpath("//select[@id='CommodityList1']/following-sibling::div/button");
	public static final By EnterSearchValueForCommdityDropDownForExport = By
			.xpath("//div[@class='multiselect-container dropdown-menu show']/div/input");

	public static final By clickingCheckboxCommodityDropdown = By.xpath(
			"//select[@id='CommodityList1']/following-sibling::div/div/button/following-sibling::button/span/input");
	public static final By fetchingCheckboxCommodityGroupname = By.xpath(
			"//select[@id='CommodityList1']/following-sibling::div/div/button/following-sibling::button/span/label");
	public static final By clickingGroupClassificationDropdownForExportAndImport = By
			.xpath("//select[@id='CategoryList']/following-sibling::div/button");
	public static final By EnteringGroupclassificationValue = By
			.xpath("//div[@class='multiselect-container dropdown-menu show']/div/input");
	public static final By fetchingNameGroupClassification = By.xpath("//select[@id='CategoryList']/option");
	public static final By ClickingCheckboxClassification = By.xpath(
			"//select[@id='CategoryList']/following-sibling::div/div/button/following-sibling::button/span/input");
	public static final By clickingExportButtonForDownload = By.xpath("//button[@onclick='exportDetail()']");

	public void verifyFileExportFilterdData(String expectedName, String groupclassvalue) throws InterruptedException {

		Thread.sleep(7000);

		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), "plastics22");
		LoggerUtil.info("Searching for commodity: plastics22");
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFile();

		// --- Excel Validation Part ---
		String excelCellValue = ReadExcelFile(); // ye Row 4, Column B ki value de raha hai

		if (excelCellValue != null && excelCellValue.equalsIgnoreCase(expectedName)) {
			LoggerUtil.pass(" Excel value matched. Expected = " + expectedName + ", Found = " + excelCellValue);
		} else {
			LoggerUtil.fail(" Excel value mismatch. Expected = " + expectedName + ", Found = " + excelCellValue);
		}
	}

	public String ReadExcelFile() {

		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile != null) {
			String filePath = latestFile.getAbsolutePath();
			String sheetName = "commodity yearly";

			try {

				ExcelUtil.setExcelFile(filePath, sheetName);

				String cellValue = ExcelUtil.getCellData(3, 1);

				LoggerUtil.info(" Value at Row 4, Column B: " + cellValue);
				return cellValue;
			} catch (Exception e) {
				LoggerUtil.error(" Error while reading Excel: " + e.getMessage());
			}
		} else {
			LoggerUtil.fail("❌ No Commodity Type file found in downloads folder.");
		}
		return null;

	}

	public void verifySheetNameHeaderNameAndColomName(String expectedName, String groupclassvalue)
			throws InterruptedException {

		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), "plastics22");
		LoggerUtil.info("Searching for commodity: plastics22");
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFile();

		Thread.sleep(300);
		readExcelMetaData();

	}

	public void readExcelMetaData() {
		try {
			// Latest file pick karo
			File latestFile = getLatestCommodityDetailsTabFile();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Commodity Type Excel file found.");
				return;
			}

			String filePath = latestFile.getAbsolutePath();

			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				// --- 1. Sheet Name ---
				Sheet sheet = workbook.getSheetAt(0);
				String sheetName = sheet.getSheetName();
				LoggerUtil.info("📑 Sheet Name: " + sheetName);

				// --- 2. File Header (Row 1 in Excel = rowIndex 0) ---
				Row headerRow = sheet.getRow(0);
				if (headerRow != null) {
					String fileHeader = headerRow.getCell(0).toString().trim();
					LoggerUtil.info("📝 File Header: " + fileHeader);
				}

				// --- 3. Column Names (Row 3 in Excel = rowIndex 2) ---
				Row columnRow = sheet.getRow(2); // 0-based → 3rd row
				if (columnRow != null) {
					int colCount = columnRow.getLastCellNum(); // should be up to BG
					LoggerUtil.info("📊 Total Columns Found: " + colCount);

					for (int i = 0; i < colCount; i++) {
						Cell cell = columnRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						String colName = cell.toString().trim();
						LoggerUtil.info("Column " + (i + 1) + " → " + colName);
					}
				}

			}
		} catch (Exception e) {
			LoggerUtil.error("❌ Error reading Excel meta-data: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By clickingGroupDeltaRadioButtonForExportingExcelFile = By.xpath("//input[@id='DeltaR']");

	public void verifySheetNameHeaderNameAndColomNameForGroupDelta(String expectedName, String groupclassvalue)
			throws InterruptedException {

		Thread.sleep(7000);

		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), "plastics22");
		LoggerUtil.info("Searching for commodity: plastics22");
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFileGroupDelta();

		Thread.sleep(4000);
		readExcelMetaDataForGroupDelta();

	}

	public void readExcelMetaDataForGroupDelta() {
		try {
			// Latest file pick karo
			File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Commodity Type Excel file found.");
				return;
			}

			String filePath = latestFile.getAbsolutePath();

			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				// --- 1. Sheet Name ---
				Sheet sheet = workbook.getSheetAt(0);
				String sheetName = sheet.getSheetName();
				LoggerUtil.info("📑 Sheet Name: " + sheetName);

				// --- 2. File Header (Row 1 in Excel = rowIndex 0) ---
				Row headerRow = sheet.getRow(0);
				if (headerRow != null) {
					String fileHeader = headerRow.getCell(0).toString().trim();
					LoggerUtil.info("📝 File Header: " + fileHeader);
				}

				// --- 3. Column Names (Row 3 in Excel = rowIndex 2) ---
				Row columnRow = sheet.getRow(3); // 0-based → 3rd row
				if (columnRow != null) {
					int colCount = columnRow.getLastCellNum();
					LoggerUtil.info("📊 Total Columns Found: " + colCount);

					for (int i = 0; i < colCount; i++) {
						Cell cell = columnRow.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
						if (cell != null) {
							String colName = cell.toString().trim();
							if (!colName.isEmpty()) { // ✅ sirf non-empty print hoga
								LoggerUtil.info("Column " + (i + 1) + " → " + colName);
								System.out.println("Column " + (i + 1) + " → " + colName); // console print
							}
						}
					}
				}

			}
		} catch (Exception e) {
			LoggerUtil.error("❌ Error reading Excel meta-data: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By clickingDriectCostRadioButtonForExportingExcelFile = By
			.xpath("//input[@id=' DirectPriceR']");

	public void verifySheetNameHeaderNameAndColomNameForDirectCost(String expectedName, String groupclassvalue)
			throws InterruptedException {

		Thread.sleep(7000);

		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);
		clickOnElement(clickingDriectCostRadioButtonForExportingExcelFile);
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), "plastics22");
		LoggerUtil.info("Searching for commodity: plastics22");
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFileDirectCost();

		Thread.sleep(4000);
		readExcelMetaDataForDirectPrice();

	}

	public void readExcelMetaDataForDirectPrice() {
		try {
			File latestFile = getLatestCommodityDetailsTabFileDirectCost();
			if (latestFile == null) {
				LoggerUtil.fail(" No Commodity Type Excel file found.");
				return;
			}

			String filePath = latestFile.getAbsolutePath();

			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(0);
				String sheetName = sheet.getSheetName();
				LoggerUtil.info(" Sheet Name: " + sheetName);

				// header
				Row headerRow = sheet.getRow(0);
				if (headerRow != null) {
					String fileHeader = headerRow.getCell(0).toString().trim();
					LoggerUtil.info(" File Header: " + fileHeader);
				}

				// column row (maan le 4th row -> index 3)
				Row columnRow = sheet.getRow(3);
				if (columnRow != null) {
					int colCount = columnRow.getLastCellNum();
					LoggerUtil.info(" Total Columns Found (before filter): " + colCount);

					int visibleCol = 0;
					for (int i = 0; i < colCount; i++) {
						Cell cell = columnRow.getCell(i);
						if (cell != null) {
							String colName = cell.toString().trim();
							if (!colName.isEmpty()) { // yaha filter lagaya
								visibleCol++;
								LoggerUtil.info("Column " + (i + 1) + " → " + colName);
							}
						}
					}
					LoggerUtil.info(" Total Non-Empty Columns: " + visibleCol);
				}
			}
		} catch (Exception e) {
			LoggerUtil.error(" Error reading Excel meta-data: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By ClickingNewGradeAdditionRadioButtonForExportExcelFile = By
			.xpath("//input[@id='NewGradeadd']");
	public static final By clickingSupplierDropdownForExportExcelFile = By
			.xpath("//div[@id='supplierDiv']/div[2]/div/span/div/button");
	public static final By ClickingCheckboxSupplier = By
			.xpath("//select[@id='SupplierComm']/following-sibling::div/div/button/span/input");

	public void verifySheetNameHeaderNameAndColomNameForNewGradeAddition() throws InterruptedException {

		Thread.sleep(7000);

		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);
		clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		clickOnElement(clickingSupplierDropdownForExportExcelFile);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		List<WebElement> suppcheckbox = driver.findElements(ClickingCheckboxSupplier);
		Thread.sleep(2000);
		WebElement selectingcheckbox = suppcheckbox.get(1);
		selectingcheckbox.click();

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFileNewGrade();
		Thread.sleep(4000);
		readExcelMetaDataForNewGradeAddition();

	}

	public void readExcelMetaDataForNewGradeAddition() {
		try {
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();
			if (latestFile == null) {
				LoggerUtil.fail(" No Commodity Type Excel file found.");
				return;
			}

			String filePath = latestFile.getAbsolutePath();

			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(0);

				String sheetName = sheet.getSheetName();
				LoggerUtil.info(" Sheet Name: " + sheetName);

				Row headerRow = sheet.getRow(0);
				if (headerRow != null) {
					String fileHeader = headerRow.getCell(0).toString().trim();
					LoggerUtil.info(" File Header: " + fileHeader);
				}

				for (int i = 2; i <= 12; i++) {
					Row row = sheet.getRow(i);
					if (row != null) {
						Cell cell = row.getCell(0);
						String value = (cell != null) ? cell.toString().trim() : "";
						LoggerUtil.info(" Row " + (i + 1) + " -> " + value);
					}
				}

			}
		} catch (Exception e) {
			LoggerUtil.error(" Error reading Excel meta-data: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifReadExcelFile(String expectedName, String groupclassvalue) throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), expectedName);
		LoggerUtil.info("Searching for commodity: " + expectedName);
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFile();

		Thread.sleep(300);

	}

	public Map<String, String> VerifyAllDataAreInExcelFile() {
		Map<String, String> excelData = new HashMap<>();
		try {
			File latestFile = getLatestCommodityDetailsTabFile();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Commodity Type Excel file found.");
				return excelData;
			}

			String filePath = latestFile.getAbsolutePath();
			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(0);

				Row dataRow = sheet.getRow(3);
				if (dataRow == null) {
					LoggerUtil.fail(" Data row not found at index 3.");
					return excelData;
				}

				DataFormatter formatter = new DataFormatter();

				String commodityGroup = formatter.formatCellValue(dataRow.getCell(1));
				String groupClassification = formatter.formatCellValue(dataRow.getCell(2));
				String specificGrade = formatter.formatCellValue(dataRow.getCell(6));
				String density = formatter.formatCellValue(dataRow.getCell(7));

				excelData.put("Commodity Group", commodityGroup.trim());
				excelData.put("Group Classification", groupClassification.trim());
				excelData.put("Grade", specificGrade.trim());
				excelData.put("Density", density.trim());

				LoggerUtil.info("Commodity Group → " + commodityGroup);
				LoggerUtil.info("Group Classification → " + groupClassification);
				LoggerUtil.info("Grade → " + specificGrade);
				LoggerUtil.info("Density → " + density);
			}
		} catch (Exception e) {
			LoggerUtil.error("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		return excelData;
	}

	public void verifyExcelMatchesUI(String commodityGroup, String groupClassification, String grade, String density) {
		Map<String, String> excelData = VerifyAllDataAreInExcelFile();

		compareValues("Commodity Group", commodityGroup, excelData.getOrDefault("Commodity Group", ""));
		compareValues("Group Classification", groupClassification, excelData.getOrDefault("Group Classification", ""));
		compareValues("Grade", grade, excelData.getOrDefault("Grade", ""));
		compareValues("Density", density, excelData.getOrDefault("Density", ""));
	}

	private void compareValues(String fieldName, String uiValue, String excelValue) {
		if (uiValue.equalsIgnoreCase(excelValue)) {
			LoggerUtil.pass("✅ " + fieldName + " matches → UI: " + uiValue + " | Excel: " + excelValue);
		} else {
			LoggerUtil.fail("❌ " + fieldName + " mismatch → UI: " + uiValue + " | Excel: " + excelValue);
		}
	}

	public static final By clickingSupplierSpecificDelta = By
			.xpath("//select[@id='SupplierSpecificDelta']/following-sibling::div/button");
	public static final By fechingSuppliernamesForSpecificDelta = By.xpath(
			"//select[@id='SupplierSpecificDelta']/following-sibling::div/div/button/following-sibling::button/span/label");
	public static final By fetchingSupplierCheckboxForSpecificDelta = By.xpath(
			"//select[@id='SupplierSpecificDelta']/following-sibling::div/div/button/following-sibling::button/span/input");
	public static final By FetchingMonthHeadervaluesForSpecificDelta = By
			.xpath("//div[@id='part-table-delta']/table/thead/tr/th[2]/following-sibling::th");
	public static final By fetchingRmScrapHeaderValuesForSuppSpecificDelta = By
			.xpath("//div[@id='part-table-delta']/table/thead/tr[2]/th");
	public static final By EnterRmOrScrapVlaues = By
			.xpath("//table[@id='comodityRMDeltaTable']/tbody/tr[1]/td[2]/following-sibling::td/input");

	public void verifyReadDeltaValueForSpecialCharacterandText(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String monthlyname, String rmscrap,
			String enteRrmScrapValues, String EntermonthSecond, String EnterRmScrapName, String EnterPriceForScrap)
			throws InterruptedException {

		Thread.sleep(3000);

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 160);");

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(5000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		EnteringValueInBaseRmAndScrap(monthlyname, rmscrap, enteRrmScrapValues, EntermonthSecond, EnterRmScrapName,
				EnterPriceForScrap);

		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		String ActualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
		String expectedMessage = "Commodity details saved successfully.";
		Assert.assertEquals(expectedMessage, ActualMessage);

	}

	public static final By FetchingHeaderNameOfBaseBaseMonth = By
			.xpath("//input[@id='comodityDetailID']/following-sibling::div//div[@class='yearly_cs_border']//label");
	public static final By RmScrapLocator = By.xpath(
			"//input[@id='comodityDetailID']/following-sibling::div//div[@class='yearly_cs_border']//div/div/div//input");

	public void EnteringValueInBaseRmAndScrap(String Entermonthname, String EnterRmAndScrapName, String EnterPrice,
			String EntermonthSecond, String EnterRmScrapName, String EnterPriceForScrap) {

		try {

			By firstLocator = By.xpath("//label[normalize-space(text())='" + Entermonthname
					+ "']/following::input[@placeholder='" + EnterRmAndScrapName + "'][1]");
			WebElement firstElement = waitForExpectedElement(firstLocator);
			clearAndEnterText(firstElement, EnterPrice);
			LoggerUtil.info("Entered value: " + EnterPrice + " for " + Entermonthname + " - " + EnterRmAndScrapName);

			By secondLocator = By.xpath("//label[normalize-space(text())='" + EntermonthSecond
					+ "']/following::input[@placeholder='" + EnterRmScrapName + "'][1]");
			WebElement secondElement = waitForExpectedElement(secondLocator);
			clearAndEnterText(secondElement, EnterPriceForScrap);
			LoggerUtil.info(
					"Entered value: " + EnterPriceForScrap + " for " + EntermonthSecond + " - " + EnterRmScrapName);

		} catch (Exception e) {
			LoggerUtil.error("Error while entering RM/Scrap values: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyEnteringValuesForSpecificDelta(String monthlyname, String rmscrap, String enteRrmScrapValues)
			throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 4500);");

		Thread.sleep(4000);
		clickOnElement(clickingSupplierSpecificDelta);
		List<WebElement> suppname = driver.findElements(fechingSuppliernamesForSpecificDelta);
		List<WebElement> suppcheckbox = driver.findElements(fetchingSupplierCheckboxForSpecificDelta);
		for (int i = 0; i < suppname.size(); i++) {

			String flagname = suppname.get(i).getText().trim();
			if (flagname.equalsIgnoreCase("0801-Celesta")) {

				suppcheckbox.get(i).click();

				break;
			}
		}

		List<WebElement> monthnames = driver.findElements(FetchingMonthHeadervaluesForSpecificDelta);
		List<WebElement> RmScrapnames = driver.findElements(fetchingRmScrapHeaderValuesForSuppSpecificDelta);

		for (WebElement monthly : monthnames) {

			String flagmonth = monthly.getText().trim();
			if (flagmonth.equalsIgnoreCase(monthlyname)) {

				for (WebElement RmScrap : RmScrapnames) {

					String flagScrap = RmScrap.getText().trim();

					if (flagScrap.equalsIgnoreCase(rmscrap)) {

						clearAndEnterText(waitForExpectedElement(EnterRmOrScrapVlaues), enteRrmScrapValues);

						break;
					}

				}
				break;
			}

		}

	}

	public void verifReadExcelFileForGroupDelta(String expectedName, String groupclassvalue)
			throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(2000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), expectedName);
		LoggerUtil.info("Searching for commodity: " + expectedName);
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFileGroupDelta();

		Thread.sleep(3000);

	}

	public Map<String, String> VerifyGroupDeltaDataFromExcel() {
		Map<String, String> excelData = new HashMap<>();
		try {
			File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Group Delta Excel file found.");
				return excelData;
			}

			String filePath = latestFile.getAbsolutePath();
			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(1);

				Row dataRow = sheet.getRow(3);
				if (dataRow == null) {
					LoggerUtil.fail("❌ Data row not found at index 3 (Excel Row 4).");
					return excelData;
				}

				DataFormatter formatter = new DataFormatter();

				String commodityGroup = formatter.formatCellValue(dataRow.getCell(1));
				String groupClassification = formatter.formatCellValue(dataRow.getCell(2));
				String year = formatter.formatCellValue(dataRow.getCell(8));
				String month = formatter.formatCellValue(dataRow.getCell(9));
				String rmDelta = formatter.formatCellValue(dataRow.getCell(10));
				String scrapDelta = formatter.formatCellValue(dataRow.getCell(11));

				excelData.put("Commodity Group", commodityGroup.trim());
				excelData.put("Group Classification", groupClassification.trim());
				excelData.put("Year", year.trim());
				excelData.put("Month", month.trim());
				excelData.put("RM Delta", rmDelta.trim());
				excelData.put("Scrap Delta", scrapDelta.trim());

				LoggerUtil.info("Commodity Group → " + commodityGroup);
				LoggerUtil.info("Group Classification → " + groupClassification);
				LoggerUtil.info("Year → " + year);
				LoggerUtil.info("Month → " + month);
				LoggerUtil.info("RM Delta → " + rmDelta);
				LoggerUtil.info("Scrap Delta → " + scrapDelta);
			}
		} catch (Exception e) {
			LoggerUtil.error("Error reading Group Delta Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		return excelData;
	}

	public void verifyGroupDeltaMatchesUI(String uiCommodityGroup, String uiGroupClassification, String uiYear,
			String uiMonth, String uiRmDelta, String uiScrapDelta) {
		Map<String, String> excelData = VerifyGroupDeltaDataFromExcel();

		compareValues("Commodity Group", uiCommodityGroup, excelData.getOrDefault("Commodity Group", ""));
		compareValues("Group Classification", uiGroupClassification,
				excelData.getOrDefault("Group Classification", ""));
		compareValues("Year", uiYear, excelData.getOrDefault("Year", ""));
		compareValues("Month", uiMonth, excelData.getOrDefault("Month", ""));
		compareValues("RM Delta", uiRmDelta, excelData.getOrDefault("RM Delta", ""));
		compareValues("Scrap Delta", uiScrapDelta, excelData.getOrDefault("Scrap Delta", ""));
	}

	public void verifyReadDirectCostForSpecialCharacterandText(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String monthlyname, String rmscrap,
			String enteRrmScrapValues, String EntermonthSecond, String EnterRmScrapName, String EnterPriceForScrap)
			throws InterruptedException {

		Thread.sleep(3000);

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 160);");

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(5000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		EnteringValueInBaseRmAndScrap(monthlyname, rmscrap, enteRrmScrapValues, EntermonthSecond, EnterRmScrapName,
				EnterPriceForScrap);

		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		String ActualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
		String expectedMessage = "Commodity details saved successfully.";
		Assert.assertEquals(expectedMessage, ActualMessage);

	}

	public void verifReadExcelFileForGroupDirectCost(String expectedName, String groupclassvalue)
			throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingDriectCostRadioButtonForExportingExcelFile);
		Thread.sleep(2000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), expectedName);
		LoggerUtil.info("Searching for commodity: " + expectedName);
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFileDirectCost();

		Thread.sleep(3000);

	}

	public Map<String, String> VerifyDirectCostFromExcelFile() {
		Map<String, String> excelData = new HashMap<>();
		try {
			File latestFile = getLatestCommodityDetailsTabFileDirectCost();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Group Delta Excel file found.");
				return excelData;
			}

			String filePath = latestFile.getAbsolutePath();
			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(1);

				Row dataRow = sheet.getRow(3);
				if (dataRow == null) {
					LoggerUtil.fail("❌ Data row not found at index 3 (Excel Row 4).");
					return excelData;
				}

				DataFormatter formatter = new DataFormatter();

				String commodityGroup = formatter.formatCellValue(dataRow.getCell(1));
				String groupClassification = formatter.formatCellValue(dataRow.getCell(2));
				String year = formatter.formatCellValue(dataRow.getCell(8));
				String month = formatter.formatCellValue(dataRow.getCell(9));
				String rmDelta = formatter.formatCellValue(dataRow.getCell(10));
				String scrapDelta = formatter.formatCellValue(dataRow.getCell(11));

				excelData.put("Commodity Group", commodityGroup.trim());
				excelData.put("Group Classification", groupClassification.trim());
				excelData.put("Year", year.trim());
				excelData.put("Month", month.trim());
				excelData.put("RM Delta", rmDelta.trim());
				excelData.put("Scrap Delta", scrapDelta.trim());

				LoggerUtil.info("Commodity Group → " + commodityGroup);
				LoggerUtil.info("Group Classification → " + groupClassification);
				LoggerUtil.info("Year → " + year);
				LoggerUtil.info("Month → " + month);
				LoggerUtil.info("RM Delta → " + rmDelta);
				LoggerUtil.info("Scrap Delta → " + scrapDelta);
			}
		} catch (Exception e) {
			LoggerUtil.error("Error reading Group Delta Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		return excelData;
	}

	public void verifyDirectCostMatchesUI(String uiCommodityGroup, String uiGroupClassification, String uiYear,
			String uiMonth, String uiRmDelta, String uiScrapDelta) {
		Map<String, String> excelData = VerifyDirectCostFromExcelFile();

		compareValues("Commodity Group", uiCommodityGroup, excelData.getOrDefault("Commodity Group", ""));
		compareValues("Group Classification", uiGroupClassification,
				excelData.getOrDefault("Group Classification", ""));
		compareValues("Year", uiYear, excelData.getOrDefault("Year", ""));
		compareValues("Month", uiMonth, excelData.getOrDefault("Month", ""));
		compareValues("RM Delta", uiRmDelta, excelData.getOrDefault("RM Delta", ""));
		compareValues("Scrap Delta", uiScrapDelta, excelData.getOrDefault("Scrap Delta", ""));
	}

	public String verifyWriteEditExcelFileAndImportAgain() throws InterruptedException {

		Thread.sleep(3000);
		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String densityvalue = String.valueOf(number);
		String year = "2026-2027";

		// Fill Excel
		ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(densityvalue));
		ExcelFiller.setCellValue(filePath, 0, 3, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
		ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 12, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 13, ExcelFiller.ValueType.INTEGER, null);

		// Report the filled values in the logs for verification
		LoggerUtil.info("Values filled in Excel:");
		LoggerUtil.info("Density Value: " + densityvalue);
		LoggerUtil.info("Year: " + year);
		LoggerUtil.info("Column 10 (empty integer): " + "null");
		LoggerUtil.info("Column 11 (empty integer): " + "null");
		LoggerUtil.info("Column 12 (empty integer): " + "null");
		LoggerUtil.info("Column 13 (empty integer): " + "null");

		System.out.println(" filled successfully in: " + filePath);
		return latestFile.getAbsolutePath();
	}

	public void importNewPriceUopdateFile() throws InterruptedException {

		String fullPath = verifyWriteEditExcelFileAndImportAgain(); // ✅ already full absolute path

		WebElement fileInput = driver.findElement(By.id("excelUpload"));

		// Make it visible via JS
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "Import SucessFully. ";

		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);

	}

	public String WriteGroupDeltaExcelFileAndUpdate() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String Rmvalue = String.valueOf(number);
		int number1 = faker.number().numberBetween(200, 99999);
		String Scrapvalue = String.valueOf(number1);

		String year = "2026-2027";
		String period = "Aug";

		// ✅ Update Excel
		ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
		ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
		ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
		ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	// 🟢 Static variable to hold last values
	private static Map<String, String> lastEnteredGroupDeltaData;

	// 🟢 Getter method for test verification
	public Map<String, String> getLastEnteredGroupDeltaData() {
		return lastEnteredGroupDeltaData;
	}

	public void forceExcelSaveForGroupDelta(String filePath) {
		try {
			// Kill any old Excel processes first
			Runtime.getRuntime().exec("taskkill /F /IM excel.exe");
			Thread.sleep(3000);

			// Open file in Excel
			Desktop.getDesktop().open(new File(filePath));
			Thread.sleep(7000); // ensure file opened fully

			Robot robot = new Robot();

			// Ctrl + S (Save)
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			LoggerUtil.info("✅ Excel file saved with Ctrl+S.");

			Thread.sleep(4000);

			// Kill Excel instead of Alt+F4 (ensure close & unlock)
			Runtime.getRuntime().exec("taskkill /F /IM excel.exe");
			LoggerUtil.info("✅ Excel process killed after save.");

		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Error during forceExcelSaveForGroupDelta: " + e.getMessage());
		}
	}

	public void importNewGroupDeltaPriceUpdateFile(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "File imported successfully";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public static final By FetchingMonthName = By
			.xpath("//*[@id='comodityDetailID']/following-sibling::div/div//div[@class='yearly_cs_border']/div//label");
	public static final By fetchingRmScrapValue = By.xpath(
			"//*[@id='comodityDetailID']/following-sibling::div/div//div[@class='yearly_cs_border']/div//div/div//input");
	public static final By FetchingDataForCommodityDetaisUiBaseRmAndScrapPrice = By.xpath("");
	public static final By ClickingCrossButtonExportImportPopup = By.xpath(
			"//*[@id='exampleModalLabel' and contains(text(),'The type of export required for RM')]/following-sibling::button");

	public void verifyGroupDeltaDataUpdeOrnot(String EntercommodityGroupName) throws InterruptedException {
		Thread.sleep(3000);
		clickOnElement(ClickingCrossButtonExportImportPopup);
		driver.navigate().refresh();
		Thread.sleep(20000);

		clickOnElement(ClickingViewButton);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), EntercommodityGroupName);
		Thread.sleep(3000);
		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(15000);

		// Fetch all month labels
		List<WebElement> monthLabels = driver.findElements(FetchingMonthName);
		// Fetch all RM/Scrap inputs
		List<WebElement> rmScrapInputs = driver.findElements(fetchingRmScrapValue);

		// Defensive check
		if (monthLabels.size() == 0 || rmScrapInputs.size() == 0) {
			LoggerUtil.mismatch(" No month data found on UI!");
			return;
		}

		LoggerUtil.info(" ---- UI Month-wise RM & Scrap Values ----");

		for (int i = 0; i < monthLabels.size(); i++) {
			String month = monthLabels.get(i).getText().trim();

			int rmIndex = i * 2;
			int scrapIndex = i * 2 + 1;

			String rmVal = rmIndex < rmScrapInputs.size() ? rmScrapInputs.get(rmIndex).getAttribute("value").trim()
					: "";
			String scrapVal = scrapIndex < rmScrapInputs.size()
					? rmScrapInputs.get(scrapIndex).getAttribute("value").trim()
					: "";

			if (rmVal != null && !rmVal.isEmpty()) {
				LoggerUtil.info(" Month: " + month + " | RM Value: " + rmVal);
			}
			if (scrapVal != null && !scrapVal.isEmpty()) {
				LoggerUtil.info(" Month: " + month + " | Scrap Value: " + scrapVal);
			}
			if ((rmVal == null || rmVal.isEmpty()) && (scrapVal == null || scrapVal.isEmpty())) {
				LoggerUtil.info(" Month: " + month + " | No Value Found");
			}
		}
	}

	public void verifyGroupDeltaUiVsExcel(Map<String, String> excelData, String monthName, String baseRm,
			String baseScrap) {
		try {

			int expectedRmExcel = Integer.parseInt(excelData.get("rm"));
			int expectedScrapExcel = Integer.parseInt(excelData.get("scrap"));

			int baseRmVal = Integer.parseInt(baseRm);
			int baseScrapVal = Integer.parseInt(baseScrap);

			int expectedRm = baseRmVal + expectedRmExcel;
			int expectedScrap = baseScrapVal + expectedScrapExcel;

			WebElement rmElement = waitForExpectedElement(By.xpath(
					"//label[normalize-space(text())='" + monthName + "']/following::input[@placeholder='RM'][1]"));
			int uiRm = Integer.parseInt(rmElement.getAttribute("value").trim());

			WebElement scrapElement = waitForExpectedElement(By.xpath(
					"//label[normalize-space(text())='" + monthName + "']/following::input[@placeholder='Scrap'][1]"));
			int uiScrap = Integer.parseInt(scrapElement.getAttribute("value").trim());

			if (uiRm == expectedRm) {
				LoggerUtil.info(" RM Match -> UI: " + uiRm + " | Expected (Base+Excel): " + expectedRm);
			} else {
				LoggerUtil.mismatch(" RM Mismatch -> UI: " + uiRm + " | Expected (Base+Excel): " + expectedRm);
			}

			// ✅ Compare Scrap
			if (uiScrap == expectedScrap) {
				LoggerUtil.info(" Scrap Match -> UI: " + uiScrap + " | Expected (Base+Excel): " + expectedScrap);
			} else {
				LoggerUtil.mismatch(" Scrap Mismatch -> UI: " + uiScrap + " | Expected (Base+Excel): " + expectedScrap);
			}

		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Error verifying Group Delta UI vs Excel: " + e.getMessage());
		}
	}

	////////////////////////////////////////////////////////////

	public void verifEditAndReImportGroupDirectCostExcelFile(String expectedName, String groupclassvalue)
			throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);
		clickOnElement(clickingDriectCostRadioButtonForExportingExcelFile);
		Thread.sleep(2000);
		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), expectedName);
		LoggerUtil.info("Searching for commodity: " + expectedName);
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
		List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

		boolean found = false;
		for (int i = 0; i < checkboxNameList.size(); i++) {
			String flagGroupName = checkboxNameList.get(i).getText().trim();

			if (flagGroupName.equalsIgnoreCase(expectedName)) {
				checkboxListSelection.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Commodity Group: " + expectedName);
				LoggerUtil.info("Found Commodity Name: " + flagGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.fail("Commodity Group name not found in dropdown: " + expectedName);
		}

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
		LoggerUtil.info("Searching for Group Classification: " + groupclassvalue);
		Thread.sleep(3000);

		List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
		List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

		boolean founded = false;
		for (int i = 0; i < groupclassificationName.size(); i++) {
			String groupclassificationsName = groupclassificationName.get(i).getText().trim();

			if (groupclassificationsName.equals(groupclassvalue)) {
				selectingcheckboxgrpclass.get(i).click();
				LoggerUtil.pass("Clicked on checkbox for Group Classification: " + groupclassvalue);
				founded = true;
				Thread.sleep(6000);
				break;
			}
		}

		if (!founded) {
			LoggerUtil.fail("Group Classification not found in dropdown: " + groupclassvalue);
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(15000);

		getLatestCommodityDetailsTabFileDirectCost();

		Thread.sleep(300);

	}

	public Map<String, String> VerifyAllDataAreInExcelFileForGroupDirectCost() {
		Map<String, String> excelData = new HashMap<>();
		try {
			File latestFile = getLatestCommodityDetailsTabFileDirectCost();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Commodity Type Excel file found.");
				return excelData;
			}

			String filePath = latestFile.getAbsolutePath();
			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(0);

				Row dataRow = sheet.getRow(3);
				if (dataRow == null) {
					LoggerUtil.fail(" Data row not found at index 3.");
					return excelData;
				}

				DataFormatter formatter = new DataFormatter();

				String commodityGroup = formatter.formatCellValue(dataRow.getCell(1));
				String groupClassification = formatter.formatCellValue(dataRow.getCell(2));
				String specificGrade = formatter.formatCellValue(dataRow.getCell(6));
				String density = formatter.formatCellValue(dataRow.getCell(7));

				excelData.put("Commodity Group", commodityGroup.trim());
				excelData.put("Group Classification", groupClassification.trim());
				excelData.put("Grade", specificGrade.trim());
				excelData.put("Density", density.trim());

				LoggerUtil.info("Commodity Group → " + commodityGroup);
				LoggerUtil.info("Group Classification → " + groupClassification);
				LoggerUtil.info("Grade → " + specificGrade);
				LoggerUtil.info("Density → " + density);
			}
		} catch (Exception e) {
			LoggerUtil.error("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		return excelData;
	}

	public void verifyExcelMatchesUIForGroupDirectCost(String commodityGroup, String groupClassification, String grade,
			String density) {
		Map<String, String> excelData = VerifyAllDataAreInExcelFile();

		compareValues("Commodity Group", commodityGroup, excelData.getOrDefault("Commodity Group", ""));
		compareValues("Group Classification", groupClassification, excelData.getOrDefault("Group Classification", ""));
		compareValues("Grade", grade, excelData.getOrDefault("Grade", ""));
		compareValues("Density", density, excelData.getOrDefault("Density", ""));
	}

	private void compareValuesOfDirectCost(String fieldName, String uiValue, String excelValue) {
		if (uiValue.equalsIgnoreCase(excelValue)) {
			LoggerUtil.pass("✅ " + fieldName + " matches → UI: " + uiValue + " | Excel: " + excelValue);
		} else {
			LoggerUtil.fail("❌ " + fieldName + " mismatch → UI: " + uiValue + " | Excel: " + excelValue);
		}
	}

	public String WriteDirectCostExcelFileAndUpdate() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileDirectCost();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No Direct Cost file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String Rmvalue = String.valueOf(number);
		int number1 = faker.number().numberBetween(200, 99999);
		String Scrapvalue = String.valueOf(number1);

		String year = "2026-2027";
		String period = "Aug";

		// ✅ Update Excel (Direct Cost ka column mapping)
		// Year -> Column H (7)
		ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
		// Period -> Column I (8)
		ExcelFiller.setCellValue(filePath, 0, 4, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));
		// RM -> Column J (9)
		ExcelFiller.setCellValue(filePath, 0, 4, 9, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
		// Scrap -> Column K (10)
		ExcelFiller.setCellValue(filePath, 0, 4, 10, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		// 🟢 Store values in static map for later verification
		lastEnteredDirectCostData = new HashMap<>();
		lastEnteredDirectCostData.put("filePath", filePath);
		lastEnteredDirectCostData.put("year", year);
		lastEnteredDirectCostData.put("month", period);
		lastEnteredDirectCostData.put("rm", Rmvalue);
		lastEnteredDirectCostData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated (Direct Cost) -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue
				+ " | Scrap=" + Scrapvalue);

		return filePath;
	}

	// 🟢 Static variable to hold last values
	private static Map<String, String> lastEnteredDirectCostData;

	// 🟢 Getter method for test verification
	public Map<String, String> getLastEnteredDirectCostData() {
		return lastEnteredDirectCostData;
	}

	public void forceExcelSaveForDirectCost(String filePath) {
		try {

			Runtime.getRuntime().exec("taskkill /F /IM excel.exe");
			Thread.sleep(3000);

			Runtime.getRuntime().exec("cmd /c start \"\" \"excel.exe\" \"" + filePath + "\"");
			Thread.sleep(7000);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			Thread.sleep(700); // wait to ensure key is registered
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			LoggerUtil.info(" Excel file saved with Ctrl+S (Direct Cost).");

			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			Thread.sleep(500);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			LoggerUtil.info(" Excel closed after save (Direct Cost).");

			Thread.sleep(2000);

			// ✅ Kill Excel (safety cleanup)
			Runtime.getRuntime().exec("taskkill /F /IM excel.exe");
			LoggerUtil.info(" Excel process killed after save (Direct Cost).");

		} catch (Exception e) {
			LoggerUtil.mismatch(" Error during forceExcelSaveForDirectCost: " + e.getMessage());
		}
	}

	public void importNewDirectCostPriceUpdateFile(String fullPath) throws Exception {

		clickOnElement(clickingDriectCostRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		// ⚠️ Yaha Write... call nahi hoga, direct force save hoga
		forceExcelSaveForDirectCost(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading Direct Cost file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "File imported successfully";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		LoggerUtil.info("✅ Direct Cost file imported successfully");

		Thread.sleep(11000);
	}

	public void verifyDirectCostDataAfterImportUpteOrNot(String EntercommodityGroupName) throws InterruptedException {
		Thread.sleep(3000);
		clickOnElement(ClickingCrossButtonExportImportPopup);
		Thread.sleep(2000);
		clickOnElement(ClickingViewButton);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(EnterValueForSearchingCommodityGroupTab), EntercommodityGroupName);
		Thread.sleep(3000);
		clickOnElement(ClickingEditbtnCommodityDetailsTable);
		Thread.sleep(15000);

		// ✅ Fetch all month labels
		List<WebElement> monthLabels = driver.findElements(FetchingMonthName);

		// ✅ Fetch all RM/Scrap inputs
		List<WebElement> rmScrapInputs = driver.findElements(fetchingRmScrapValue);

		// Defensive check
		if (monthLabels.size() == 0 || rmScrapInputs.size() == 0) {
			LoggerUtil.mismatch("❌ No month data found on UI for Direct Cost!");
			return;
		}

		LoggerUtil.info("📊 ---- UI Month-wise RM & Scrap Values (Direct Cost) ----");

		// ✅ Loop through 12 months
		for (int i = 0; i < monthLabels.size(); i++) {
			String month = monthLabels.get(i).getText().trim();

			// Each month row → 2 inputs (RM, Scrap)
			int rmIndex = i * 2;
			int scrapIndex = i * 2 + 1;

			String rmVal = rmIndex < rmScrapInputs.size() ? rmScrapInputs.get(rmIndex).getAttribute("value").trim()
					: "";
			String scrapVal = scrapIndex < rmScrapInputs.size()
					? rmScrapInputs.get(scrapIndex).getAttribute("value").trim()
					: "";

			// ✅ Log month details
			if (rmVal != null && !rmVal.isEmpty()) {
				LoggerUtil.info("📊 Month: " + month + " | RM Value: " + rmVal);
			}
			if (scrapVal != null && !scrapVal.isEmpty()) {
				LoggerUtil.info("📊 Month: " + month + " | Scrap Value: " + scrapVal);
			}
			if ((rmVal == null || rmVal.isEmpty()) && (scrapVal == null || scrapVal.isEmpty())) {
				LoggerUtil.info("📊 Month: " + month + " | No Value Found");
			}
		}
	}

	public void verifyDirectCostUiVsExcel(Map<String, String> excelData, String monthName) {
		try {
			int expectedRm = Integer.parseInt(excelData.get("rm"));
			int expectedScrap = Integer.parseInt(excelData.get("scrap"));

			// Fetch RM value
			WebElement rmElement = waitForExpectedElement(By.xpath(
					"//label[normalize-space(text())='" + monthName + "']/following::input[@placeholder='RM'][1]"));
			int uiRm = Integer.parseInt(rmElement.getAttribute("value").trim());

			// Fetch Scrap value
			WebElement scrapElement = waitForExpectedElement(By.xpath(
					"//label[normalize-space(text())='" + monthName + "']/following::input[@placeholder='Scrap'][1]"));
			int uiScrap = Integer.parseInt(scrapElement.getAttribute("value").trim());

			if (uiRm == expectedRm) {
				LoggerUtil.info("✅ RM Match -> UI: " + uiRm + " | Excel: " + expectedRm);
			} else {
				LoggerUtil.mismatch("❌ RM Mismatch -> UI: " + uiRm + " | Excel: " + expectedRm);
			}

			if (uiScrap == expectedScrap) {
				LoggerUtil.info("✅ Scrap Match -> UI: " + uiScrap + " | Excel: " + expectedScrap);
			} else {
				LoggerUtil.mismatch(" Scrap Mismatch -> UI: " + uiScrap + " | Excel: " + expectedScrap);
			}

		} catch (Exception e) {
			LoggerUtil.mismatch(" Error verifying Direct Cost UI vs Excel: " + e.getMessage());
		}
	}

	public void verifyEnterDataCommodityDetails(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue, String monthlyname, String rmscrap, String enteRrmScrapValues,
			String EntermonthSecond, String EnterRmScrapName, String EnterPriceForScrap, String EntermonthnameThird,
			String RmScrapNamethird, String EnterRmScrapPriceThird, String EnterMonthNameFourth,
			String EnterRmScrapNameFourth, String EnterRmScrapPriceValueFourth) throws InterruptedException {

		Thread.sleep(3000);

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 160);");

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(5000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		EnteringValueInBaseRmAndScrapForInUiForNewGradeAdditionExcelFile(monthlyname, // April / May / etc.
				rmscrap, // "RM" ya "Scrap"
				enteRrmScrapValues, // e.g. "200"
				EntermonthSecond, // May
				EnterRmScrapName, // "Scrap"
				EnterPriceForScrap, // "150"
				EntermonthnameThird, // June
				RmScrapNamethird, // "RM"
				EnterRmScrapPriceThird, // "250"
				EnterMonthNameFourth, // July
				EnterRmScrapNameFourth, // "Scrap"
				EnterRmScrapPriceValueFourth // "300"
		);

		Thread.sleep(3000);

		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		String ActualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
		String expectedMessage = "Commodity details saved successfully.";
		Assert.assertEquals(expectedMessage, ActualMessage);

	}

	public void EnteringValueInBaseRmAndScrapForInUiForNewGradeAdditionExcelFile(String Entermonthname,
			String EnterRmAndScrapName, String EnterPrice, String EntermonthSecond, String EnterRmScrapName,
			String EnterPriceForScrap, String EntermonthThird, String EnterRmScrapNameForThird,
			String EnterPriceForScrapThird, String EntermonthFourth, String EnterRmScrapNameForFourth,
			String EnterPriceScrapForFourth) {

		try {

			By firstLocator = By.xpath("//label[normalize-space(text())='" + Entermonthname
					+ "']/following::input[@placeholder='" + EnterRmAndScrapName + "'][1]");
			WebElement firstElement = waitForExpectedElement(firstLocator);
			clearAndEnterText(firstElement, EnterPrice);
			LoggerUtil.info("Entered value: " + EnterPrice + " for " + Entermonthname + " - " + EnterRmAndScrapName);

			By secondLocator = By.xpath("//label[normalize-space(text())='" + EntermonthSecond
					+ "']/following::input[@placeholder='" + EnterRmScrapName + "'][1]");
			WebElement secondElement = waitForExpectedElement(secondLocator);
			clearAndEnterText(secondElement, EnterPriceForScrap);
			LoggerUtil.info(
					"Entered value: " + EnterPriceForScrap + " for " + EntermonthSecond + " - " + EnterRmScrapName);

			By ThirdLocator = By.xpath("//label[normalize-space(text())='" + EntermonthThird
					+ "']/following::input[@placeholder='" + EnterRmScrapNameForThird + "'][1]");
			WebElement ThirdElement = waitForExpectedElement(ThirdLocator);
			clearAndEnterText(ThirdElement, EnterPriceForScrapThird);
			LoggerUtil.info("Entered value: " + EnterPriceForScrapThird + " for " + EntermonthThird + " - "
					+ EnterRmScrapNameForThird);

			By FourthLocator = By.xpath("//label[normalize-space(text())='" + EntermonthFourth
					+ "']/following::input[@placeholder='" + EnterRmScrapNameForFourth + "'][1]");
			WebElement ForthElement = waitForExpectedElement(FourthLocator);
			clearAndEnterText(ForthElement, EnterPriceScrapForFourth);
			LoggerUtil.info("Entered value: " + EnterPriceScrapForFourth + " for " + EntermonthFourth + " - "
					+ EnterRmScrapNameForFourth);

		} catch (Exception e) {
			LoggerUtil.error("Error while entering RM/Scrap values: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static final By ClickingNewGradeAdditionRadioButton = By.xpath("//input[@id='NewGradeadd']");
	public static final By ClickingSupplierDropdownForExportingNewGradeAdditionFile = By
			.xpath("//select[@id='SupplierComm']/following-sibling::div/button");
	public static final By FetchingSupplierNames = By
			.xpath("//select[@id='SupplierComm']/following-sibling::div/div/button//label");
	public static final By ClickingCheckboxListButton = By
			.xpath("//select[@id='SupplierComm']/following-sibling::div/div/button//input");

	public void verifReadExcelFileForNewGradeAddition() throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(ClickingNewGradeAdditionRadioButton);
		Thread.sleep(2000);

		clickOnElement(ClickingSupplierDropdownForExportingNewGradeAdditionFile);

		Thread.sleep(2000);

		List<WebElement> Suppnameslist = driver.findElements(FetchingSupplierNames);
		List<WebElement> checkboxlist = driver.findElements(ClickingCheckboxListButton);
		Thread.sleep(200);
		for (int i = 0; i < Suppnameslist.size(); i++) {

			String TextSuppname = Suppnameslist.get(i).getText();
			if (TextSuppname.equals("0801-Celesta")) {
				Thread.sleep(3000);
				WebElement flagcheckbtn = checkboxlist.get(i);
				Thread.sleep(2000);
				flagcheckbtn.click();
				break;

			}
		}

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(12000);

		getLatestCommodityDetailsTabFileNewGrade();

		Thread.sleep(3000);

	}
	public void VerifyWriteAndEditExcelFileAndUpdate() {

	}

	public void verifyInvalidFileIsImportOrNotForPriceUpdate(String invalidFilePath) throws InterruptedException {
		try {
			Thread.sleep(3000);
			clickOnElement(clickingExportAndImportButton);
			LoggerUtil.info(" Clicked on Export and Import Button");
			Thread.sleep(3000);

			WebElement fileInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			fileInput.sendKeys(invalidFilePath);
			LoggerUtil.info(" Uploading invalid file for Price Update: " + invalidFilePath);

			Thread.sleep(6000);

			String actualToast = waitForExpectedElement(toastmsg).getText();
			LoggerUtil.info("Toast message after invalid file upload: " + actualToast);

			String expectedToast = "Unsupported file extension.";

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass(" Invalid file correctly rejected → Toast: " + actualToast);
			} else {
				LoggerUtil.fail(" Unexpected toast message → Found: " + actualToast + " | Expected: " + expectedToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Error during invalid file import verification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyInvalidFileIsImportOrNotForGroupDelta(String invalidFilePath) throws InterruptedException {
		try {
			Thread.sleep(3000);
			clickOnElement(clickingExportAndImportButton);
			LoggerUtil.info(" Clicked on Export and Import Button");
			Thread.sleep(3000);
			clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);

			Thread.sleep(3000);
			WebElement fileInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			fileInput.sendKeys(invalidFilePath);
			LoggerUtil.info(" Uploading invalid file for Price Update: " + invalidFilePath);

			Thread.sleep(6000);

			String actualToast = waitForExpectedElement(toastmsg).getText();
			LoggerUtil.info("Toast message after invalid file upload: " + actualToast);

			String expectedToast = "Unsupported file extension.";

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass(" Invalid file correctly rejected → Toast: " + actualToast);
			} else {
				LoggerUtil.fail(" Unexpected toast message → Found: " + actualToast + " | Expected: " + expectedToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Error during invalid file import verification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyInvalidFileIsImportOrNotForGroupDirectCost(String invalidFilePath) throws InterruptedException {
		try {
			Thread.sleep(3000);
			clickOnElement(clickingExportAndImportButton);
			LoggerUtil.info(" Clicked on Export and Import Button");
			Thread.sleep(3000);
			clickOnElement(clickingDriectCostRadioButtonForExportingExcelFile);

			Thread.sleep(3000);
			WebElement fileInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			fileInput.sendKeys(invalidFilePath);
			LoggerUtil.info(" Uploading invalid file for Price Update: " + invalidFilePath);

			Thread.sleep(6000);

			String actualToast = waitForExpectedElement(toastmsg).getText();
			LoggerUtil.info("Toast message after invalid file upload: " + actualToast);

			String expectedToast = "Unsupported file extension.";

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass(" Invalid file correctly rejected → Toast: " + actualToast);
			} else {
				LoggerUtil.fail(" Unexpected toast message → Found: " + actualToast + " | Expected: " + expectedToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Error during invalid file import verification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyInvalidFileIsImportOrNotForNewGradeAdditon(String invalidFilePath) throws InterruptedException {
		try {
			Thread.sleep(3000);
			clickOnElement(clickingExportAndImportButton);
			LoggerUtil.info(" Clicked on Export and Import Button");
			Thread.sleep(3000);
			clickOnElement(ClickingNewGradeAdditionRadioButton);

			Thread.sleep(3000);
			WebElement fileInput = driver.findElement(By.id("excelUpload"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			fileInput.sendKeys(invalidFilePath);
			LoggerUtil.info(" Uploading invalid file for Price Update: " + invalidFilePath);

			Thread.sleep(6000);

			String actualToast = waitForExpectedElement(toastmsg).getText();
			LoggerUtil.info("Toast message after invalid file upload: " + actualToast);

			String expectedToast = "Unsupported file extension.";

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass(" Invalid file correctly rejected → Toast: " + actualToast);
			} else {
				LoggerUtil.fail(" Unexpected toast message → Found: " + actualToast + " | Expected: " + expectedToast);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Error during invalid file import verification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String verifyWriteInvalidExcelFileAndValidateToast() throws InterruptedException {

		Thread.sleep(3000);
		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String densityvalue = String.valueOf(number);
		String year = "2026-2027";

		// Fill Excel
		ExcelFiller.setCellValue(filePath, 0, 3, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(densityvalue));
		ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
		ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.INTEGER, null);
		System.out.println(" filled successfully in: " + filePath);
		return latestFile.getAbsolutePath();

	}

	public void importInValidExcelFile() throws InterruptedException {

		String fullPath = verifyWriteInvalidExcelFileAndValidateToast();

		WebElement fileInput = driver.findElement(By.id("excelUpload"));

		// Make it visible via JS
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "Import SucessFully. ";

		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);

	}

	public static final By clickingCheckboxForGroupClassificationForSelectAll = By
			.xpath("//select[@id='CategoryList']/following-sibling::div/div/button/span/input");
	public static final By clickingCheckboxForCommodityGroupDropdown = By
			.xpath("//select[@id='CommodityList1']/following-sibling::div/div/button/span/input");
	public static final By FetchingCommGrpNameWithSelectAll = By
			.xpath("//select[@id='CommodityList1']/following-sibling::div/div/button/span/label");

	public void verifDownLoadExcelFileForPriceUpdate() throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxForCommodityGroupDropdown);
		Thread.sleep(2000);
		WebElement clickingCheckboxComgrp = checkboxListSelection.get(0);
		Thread.sleep(2000);
		clickingCheckboxComgrp.click();

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		List<WebElement> selectingcheckboxgrpclass = driver
				.findElements(clickingCheckboxForGroupClassificationForSelectAll);
		Thread.sleep(1000);
		WebElement clickingcheckboxGrpclass = selectingcheckboxgrpclass.get(0);
		Thread.sleep(2000);
		clickingcheckboxGrpclass.click();

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(35000);

		getLatestCommodityDetailsTabFile();

		Thread.sleep(300);

	}

	public String verifyWriteMoreCharactersAndSpecifyLimits() throws InterruptedException {

		Thread.sleep(3000);
		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String densityvalue = String.valueOf(number);
		String year = "2026-2027";

		// Fill Excel
		ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(densityvalue));
		ExcelFiller.setCellValue(filePath, 0, 3, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
		ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 12, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 13, ExcelFiller.ValueType.INTEGER, null);
		System.out.println(" filled successfully in: " + filePath);
		return latestFile.getAbsolutePath();

	}

	public void importInValidCharaterAndFieldLimitFile() throws InterruptedException {

		String fullPath = VerifyEnterDataSpecialCharactersAndReportToVerifyErrorInDensityAndBasePriceColom();

		WebElement fileInput = driver.findElement(By.id("excelUpload"));

		// Make it visible via JS
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "Import SucessFully. ";

		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);

	}

	public String VerifyEnterDataSpecialCharactersAndReportToVerifyErrorInDensityAndBasePriceColom()
			throws InterruptedException {

		Thread.sleep(3000);
		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String densityvalue = String.valueOf(number);
		String BasePriceRm = "@#@#$%";
		String BasePriceScrap = "@#$%";
		String BasePriceRmMAy = "@#$%";
		String BasePriceScrapMay = "@#$%";
		String BasePriceRmJune = "@#$%&";
		String BasePriceScrapJune = "@#$%";
		int targetRow = ExcelFiller.getLastRealDataRow(filePath, 0);

		ExcelFiller.setCellValue(filePath, 0, targetRow, 7, ExcelFiller.ValueType.DROPDOWN,
				Arrays.asList(densityvalue));
		ExcelFiller.setCellValue(filePath, 0, targetRow, 9, ExcelFiller.ValueType.STRING, Arrays.asList(BasePriceRm));
		ExcelFiller.setCellValue(filePath, 0, targetRow, 10, ExcelFiller.ValueType.STRING,
				Arrays.asList(BasePriceScrap));
		ExcelFiller.setCellValue(filePath, 0, targetRow, 11, ExcelFiller.ValueType.STRING,
				Arrays.asList(BasePriceRmMAy));
		ExcelFiller.setCellValue(filePath, 0, targetRow, 12, ExcelFiller.ValueType.STRING,
				Arrays.asList(BasePriceScrapMay));
		ExcelFiller.setCellValue(filePath, 0, targetRow, 13, ExcelFiller.ValueType.STRING,
				Arrays.asList(BasePriceRmJune));
		ExcelFiller.setCellValue(filePath, 0, targetRow, 13, ExcelFiller.ValueType.STRING,
				Arrays.asList(BasePriceScrapJune));

		System.out.println("Filled successfully in: " + filePath + " at row: " + targetRow);

		return filePath;

	}

	public void verifyClickAllDropdownInExportImportPopup() throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxForCommodityGroupDropdown);
		Thread.sleep(2000);
		WebElement clickingCheckboxComgrp = checkboxListSelection.get(0);
		Thread.sleep(2000);
		clickingCheckboxComgrp.click();

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		List<WebElement> selectingcheckboxgrpclass = driver
				.findElements(clickingCheckboxForGroupClassificationForSelectAll);
		Thread.sleep(1000);
		WebElement clickingcheckboxGrpclass = selectingcheckboxgrpclass.get(0);
		Thread.sleep(2000);
		clickingcheckboxGrpclass.click();

	}

	public static final By clickingCrossbuttonForExportImportPopup = By
			.xpath("//div[@id='exportModal']//button[@aria-label='Close']");
	public static final By FetchingCommodityDiscriptionHeaderName = By
			.xpath("//div[@id='partAttributeDiv']//h3[contains(text(),'Commodity Description')]");
	public static final By FetchingCommodityDropdownText = By
			.xpath("//select[@id='CommodityList1']/following-sibling::div/button");

	public static final By FetchingGroupClassification = By
			.xpath("//select[@id='CategoryList']/following-sibling::div/button");

	public void verifyCrossButtonExportImportPopup() {

		WebElement clickCrossButton = waitForExpectedElement(clickingCrossbuttonForExportImportPopup);
		WebElement fetchCommDetailsPageHeader = waitForExpectedElement(FetchingCommodityDiscriptionHeaderName);

		try {

			if (clickCrossButton.isEnabled()) {
				clickCrossButton.click();

				if (fetchCommDetailsPageHeader.getText().equals("Commodity Description")) {
					LoggerUtil.pass("Cross Button is successfully clicked and popup is closed.");
				}
			} else {
				LoggerUtil.fail("Cross button is not enabled.");
			}

			clickOnElement(clickingExportAndImportButton);
			LoggerUtil.info("Clicked on Export and Import Button.");

			WebElement fetchdropnameExportimportCommGroupPopup = waitForExpectedElement(FetchingCommodityDropdownText);
			if (fetchdropnameExportimportCommGroupPopup.getAttribute("title").equals("None selected")) {

				LoggerUtil.pass("CommodtityDropdown Has Been SucessFully Reset....");

			} else {

				LoggerUtil.fail("CommodityGroupDropdow Has Not Been SucessFully Reset....");
			}

			WebElement FetchingGroupClassificationAttribute = waitForExpectedElement(FetchingGroupClassification);
			if (FetchingGroupClassificationAttribute.getAttribute("title").equals("None selected")) {

				LoggerUtil.pass("Group Classification Has Been SucessFully Reset....");
			} else {

				LoggerUtil.fail("Group Classification Has Not Been SucessFully Reset....");

			}

		} catch (Exception e) {
			LoggerUtil.error("An error occurred while interacting with the popup and buttons: " + e.getMessage());
		}
	}

	public void verifyRestButtonFunctionality(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue) throws InterruptedException {

		try {
			Thread.sleep(3000);

			clickOnElement(ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(3000);

			if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
				LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
			} else {
				LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
			}

			clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);
			List<WebElement> comlist = driver.findElements(commoditydropdownlist);

			boolean isCommoditySelected = false;
			for (WebElement comgrpvalue : comlist) {
				String flagcomgrpval = comgrpvalue.getText().trim();
				if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
					comgrpvalue.click();
					LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
					isCommoditySelected = true;
					break;
				}
			}

			if (!isCommoditySelected) {
				LoggerUtil.fail("Commodity dropdown value not found: " + searchcommoditydropvalue);
			}

			Thread.sleep(3000);
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
			boolean isClassificationSelected = false;
			for (WebElement grpclasslistval : grpclasslist) {
				String comclssifi = grpclasslistval.getText().trim();
				if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
					grpclasslistval.click();
					LoggerUtil.info("Selected Group Classification: " + comclssifi);
					isClassificationSelected = true;
					break;
				}
			}

			if (!isClassificationSelected) {
				LoggerUtil.fail("Group Classification not found: " + searchcommodityclassification);
			}

			Thread.sleep(3000);
			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
			List<WebElement> comgradelist = driver.findElements(specificgradelist);
			boolean isGradeSelected = false;
			for (WebElement comgradelistval : comgradelist) {
				String comgrade = comgradelistval.getText().trim();
				if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
					comgradelistval.click();
					LoggerUtil.info("Selected Specific Grade: " + comgrade);
					isGradeSelected = true;
					break;
				}
			}

			if (!isGradeSelected) {
				LoggerUtil.fail("Specific Grade not found: " + selectcommoditygradevalue);
			}

			clickOnElement(Uomdropdown);
			Thread.sleep(3000);

			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			searchuom.sendKeys(Keys.ENTER);
			LoggerUtil.info("Entered UOM as: Mtr");
			Thread.sleep(500);

			clickOnElement(ClickingShapedropdownForthirdTab);
			Thread.sleep(300);

			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			clearAndEnterText(shapesearch, "Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			LoggerUtil.info("Entered Shape as: Sheet");
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 160);");

			clickOnElement(selectyeardrop);
			Thread.sleep(500);

			WebElement yearsearch = waitForExpectedElement(searchinputyear);
			clearAndEnterText(yearsearch, "2025-2026");
			yearsearch.sendKeys(Keys.ENTER);
			LoggerUtil.info("Entered Year as: 2025-2026");
			Thread.sleep(3000);

			clickOnElement(businessSegbox);
			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			LoggerUtil.info("Entered Business Segment: rishi");
			Thread.sleep(3000);

			clickOnElement(selectallcheckboxInbusinsessSeg);
			LoggerUtil.info("Selected all checkboxes in Business Segment.");
			Thread.sleep(8000);

			clickOnElement(customercheckbox);
			LoggerUtil.info("Selected Customer Checkbox.");
			Thread.sleep(3000);

			clickOnElement(resetbtn);
			LoggerUtil.pass("Reset button functionality verified successfully.");

			Thread.sleep(5000);
			vrifyResetButtonIsWorkingOrNot();

		} catch (Exception e) {
			LoggerUtil.fail("An error occurred during the Reset button functionality verification: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Select

	public static final By FetchingSupplierlist = By.xpath("//table[@id='rmSupplier']//label/input");

	public void vrifyResetButtonIsWorkingOrNot() {

		WebElement FetchingText = waitForExpectedElement(ClickingcommoditydropdownBtnThirdTab);
		if (FetchingText.getText().equalsIgnoreCase("Select")) {

			LoggerUtil.pass("Reset Button Is Working Well");

		} else {

			LoggerUtil.fail("Reset Button Is Not Working Well");
		}
		WebElement FetchingTextClassification = waitForExpectedElement(ClickingGroupclassificationBtnThirdTabDropdown);

		if (FetchingTextClassification.getText().equalsIgnoreCase("Select")) {

			LoggerUtil.pass("Reset Button Is Working Well For Classification");

		} else {

			LoggerUtil.fail("Reset Button Is Not Working Well For Classification");
		}
		WebElement FetchingSpecificGrade = waitForExpectedElement(ClickingspecificgradeBtndropdownForThirdTab);

		if (FetchingSpecificGrade.getText().equals("Select")) {

			LoggerUtil.pass("Reset Button Is Working Well For Specific Grade ");

		} else {
			LoggerUtil.fail("Specific Grafe Button Is not Working Well..");
		}
		WebElement fetchinguomDropValue = waitForExpectedElement(Uomdropdown);

		if (fetchinguomDropValue.getText().equals("Select")) {

			LoggerUtil.pass("Reset Button is working Well For UomDropDown");
		} else {

			LoggerUtil.fail("Reset Button Is not Working Well");

		}

		WebElement Fetchingshapedropdownvalue = waitForExpectedElement(ClickingShapedropdownForthirdTab);
		if (Fetchingshapedropdownvalue.getText().equals("Select")) {

			LoggerUtil.pass("Reset Button is Working Well For ShapeDropdown..");
		} else {

			LoggerUtil.fail("Reset button is not Working Well....");
		}

		List<WebElement> fetchingSuppcheckbox = driver.findElements(FetchingSupplierlist);

		boolean allCheckboxesNotVisible = true; // Assume all checkboxes are not visible initially.

		for (int i = 0; i < fetchingSuppcheckbox.size(); i++) {
			WebElement checkbox = fetchingSuppcheckbox.get(i);

			if (checkbox.isDisplayed()) {
				LoggerUtil.fail("Supplier Checkbox List Is Visible at index " + i);
				allCheckboxesNotVisible = false;
				break;
			}
		}

		if (allCheckboxesNotVisible) {
			LoggerUtil.pass("Supplier Checkbox List Is Not Visible");
		} else {
			LoggerUtil.info("At least one checkbox in the list is visible.");
		}
	}

	public static final By RmCells = By.xpath(
			"//input[@id='comodityDetailID']/following-sibling::div//div[@class='yearly_cs_border']//input[@placeholder='RM']");
	public static final By ScrapCells = By.xpath(
			"//input[@id='comodityDetailID']/following-sibling::div//div[@class='yearly_cs_border']//input[@placeholder='Scrap']");

	public void verifyBasePriceForResetFunctionality() throws InterruptedException {

		Thread.sleep(3000);

		List<WebElement> valuesRm = driver.findElements(RmCells);
		boolean resetRmCellSuccess = true;

		for (int i = 0; i < valuesRm.size() - 6; i++) {
			WebElement enteringValue = valuesRm.get(i);
			enteringValue.sendKeys("3456");
		}

		List<WebElement> valuesScrap = driver.findElements(ScrapCells);
		boolean resetScrapCellSuccess = true;

		for (int i = 0; i < valuesScrap.size() - 6; i++) {
			WebElement enteringScrapValue = valuesScrap.get(i);
			enteringScrapValue.sendKeys("345678");
		}

		clickOnElement(resetbtn);

		Thread.sleep(5000);

		for (int i = 0; i < valuesRm.size() - 6; i++) {
			WebElement enteringValue = valuesRm.get(i);

			if (enteringValue.getAttribute("value").isBlank()) {
				LoggerUtil.pass("Reset Button Is Working Well for RM Cell at index " + i);
			} else {
				LoggerUtil.fail("Reset Button Is Not Working Well for RM Cell at index " + i);
				resetRmCellSuccess = false;
			}
		}

		for (int i = 0; i < valuesScrap.size() - 6; i++) {
			WebElement enteringScrapValue = valuesScrap.get(i);

			if (enteringScrapValue.getAttribute("value").isBlank()) {
				LoggerUtil.pass("Reset Button Is Working Well for Scrap Cell at index " + i);
			} else {
				LoggerUtil.fail("Reset Button Is Not Working Well for Scrap Cell at index " + i);
				resetScrapCellSuccess = false;
			}
		}

		if (resetRmCellSuccess && resetScrapCellSuccess) {
			LoggerUtil.pass("Reset functionality worked well for both RM and Scrap cells.");
		} else {
			LoggerUtil.fail("Reset functionality failed for RM or Scrap cells.");
		}
	}

	public String verifyWriteDuplicateExcelFile() throws InterruptedException {

		Thread.sleep(3000);
		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int number = faker.number().numberBetween(200, 99999);
		String densityvalue = String.valueOf(number);
		String year = "2026-2027";

		// Fill Excel
		ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(densityvalue));
		ExcelFiller.setCellValue(filePath, 0, 3, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
		ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 12, ExcelFiller.ValueType.INTEGER, null);
		ExcelFiller.setCellValue(filePath, 0, 3, 13, ExcelFiller.ValueType.INTEGER, null);
		System.out.println(" filled successfully in: " + filePath);
		return latestFile.getAbsolutePath();

	}

	public void SaveSecondTabCommodityGroupVerifyMaximumLengeth(String searchcommodityvalue,
			String grpclassificationvalue, String specificgradevalye, String densityvalue) throws InterruptedException {
		Thread.sleep(6000);

		WebElement select2Box = driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single"));
		Actions actions = new Actions(driver);
		actions.moveToElement(select2Box).click().perform();
		Thread.sleep(3000);

		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);
		for (WebElement grpvalue : grouplist) {
			String text = grpvalue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				grpvalue.click();
				break;
			}
		}

		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		LoggerUtil.info("Entered Group Classification: " + grpclassificationvalue);

		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		LoggerUtil.info("Entered Specific Grade Value: " + specificgradevalye);

		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		LoggerUtil.info("Entered Density Value: " + densityvalue);

		clickOnElement(savebtncommoditygrp);
		LoggerUtil.info("Clicked Save in Second Tab for Commodity Group.");
		Thread.sleep(5000);
	}

	public void SaveDataInThirdTabForVerifyingMaximumLenthValuesAreDownloadedAsItIsOrNot(
			String searchcommoditydropvalue, String searchcommodityclassification, String selectcommoditygradevalue,
			String AprilRmPrice, String AprilScrapPrice, String MayRmPrice) throws InterruptedException {

		Thread.sleep(3000);

		clickOnElement(ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(5000);
		clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(6000);
		clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(Uomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdownForthirdTab);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 160);");

		clickOnElement(selectyeardrop);
		Thread.sleep(500);

		WebElement yearsearch = waitForExpectedElement(searchinputyear);
		clearAndEnterText(yearsearch, "2025-2026");
		yearsearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Year as: 2025-2026");
		Thread.sleep(3000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);
		verifyEnteringMaximumNumberInBasePrice(AprilRmPrice, AprilScrapPrice, MayRmPrice);
		Thread.sleep(3000);
		clickOnElement(ClickingSaveBtnForThirdTab);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		String ActualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
		String expectedMessage = "Commodity details saved successfully.";
		Assert.assertEquals(expectedMessage, ActualMessage);

	}

	public void verifyEnteringMaximumNumberInBasePrice(String AprilRmPrice, String AprilScrapPrice, String MayRmPrice)
			throws InterruptedException {

		LoggerUtil.info("===== Starting verifyEnteringMaximumNumberInBasePrice =====");

		try {
			// --- April RM (Dynamic) ---
			clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "RM")), AprilRmPrice);
			LoggerUtil.info("Entered April RM Price → " + AprilRmPrice);
			Thread.sleep(200);

			// --- April Scrap (Dynamic) ---
			clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("Apr", "Scrap")), AprilScrapPrice);
			LoggerUtil.info("Entered April Scrap Price → " + AprilScrapPrice);
			Thread.sleep(200);

			// --- May RM (Dynamic) ---
			clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator("May", "RM")), MayRmPrice);
			LoggerUtil.info("Entered May RM Price → " + MayRmPrice);
			Thread.sleep(200);

			LoggerUtil.pass("✅ Maximum Base Price values entered successfully (April RM/Scrap, May RM).");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Failed during Base Price entry → " + e.getMessage());
			throw e;
		}

		LoggerUtil.info("===== End of verifyEnteringMaximumNumberInBasePrice =====");
	}

	public void verifyAllLongDataDownloadCorrectlyInExcelFromUiOrNot(String commname, String classfication,
			String specificGrade, String AprilRm, String AprilScrap, String MayRm) {

		File latestExcelFile = getLatestCommodityDetailsTabFile();
		if (latestExcelFile == null) {
			System.out.println(" Excel file not found.");
			return;
		}

		int lastRow = ExcelUtil.getLastNonEmptyRow(latestExcelFile.getAbsolutePath());
		if (lastRow == -1) {
			System.out.println(" No non-empty row found in Excel.");
			return;
		}

		int[] columnsToRead = { 1, 2, 6, 10, 11, 12 };
		Map<String, String> excelData = ExcelUtil.readColumnsFromLastRow(latestExcelFile, lastRow, columnsToRead);

		String expectedB = commname;
		String expectedC = classfication;
		String expectedG = specificGrade;
		String expectedK = AprilRm;
		String expectedL = AprilScrap;
		String expectedM = MayRm;

		assertValue("B", expectedB, excelData.get("B"));
		assertValue("C", expectedC, excelData.get("C"));
		assertValue("G", expectedG, excelData.get("G"));
		assertValue("K", expectedK, excelData.get("K"));
		assertValue("L", expectedL, excelData.get("L"));
		assertValue("M", expectedM, excelData.get("M"));
	}

	private void assertValue(String column, String expected, String actual) {
		if (expected.equals(actual)) {
			System.out.println(" Column " + column + " matched. Value: " + actual);
		} else {
			System.out.println(" Column " + column + " mismatch.");
			System.out.println("   Expected: " + expected);
			System.out.println("   Actual  : " + actual);
		}
	}

	/**
	 * ✅ NEW METHOD: Verify mandatory fields are not blank in given row/columns
	 */
	public void verifyMandatoryColumns(File excelFile, int rowNumber) {
		try (FileInputStream fis = new FileInputStream(excelFile); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0);

			// header row (maan le row 3 me headers hai)
			Row headerRow = sheet.getRow(3);
			Row dataRow = sheet.getRow(rowNumber - 1); // 1-based → 0-based

			if (dataRow == null) {
				LoggerUtil.fail(" Row " + rowNumber + " is completely blank ❌");
				return;
			}

			// Column ranges: B–J (2 to 10), and AX (50)
			int[] mandatoryCols = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 50 };

			for (int colNum : mandatoryCols) {
				Cell headerCell = headerRow.getCell(colNum - 1);
				String colName = (headerCell == null) ? ("Col-" + colNum) : headerCell.toString().trim();

				Cell cell = dataRow.getCell(colNum - 1);
				String value = (cell == null) ? "" : cell.toString().trim();

				if (value.isEmpty()) {
					LoggerUtil.fail("Row " + rowNumber + " → " + colName + " = BLANK ❌");
				} else {
					LoggerUtil.info("Row " + rowNumber + " → " + colName + " = " + value + " ✅");
				}
			}

		} catch (Exception e) {
			LoggerUtil.error(" Error verifying mandatory columns: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyAllBlankFieldAreExportedBlankAreNot() {
		File latestFile = getLatestCommodityDetailsTabFile();
		if (latestFile == null) {
			throw new RuntimeException("No latest Commodity file found to verify.");
		}

		int lastRowIndex = ExcelUtil.getLastNonEmptyRow(latestFile.getAbsolutePath());
		if (lastRowIndex == -1) {
			throw new RuntimeException("No non-empty last row found in the Excel file.");
		}

		Map<String, String> excelData = ExcelUtil.readColumnsNtoAHFromLastRow(latestFile, lastRowIndex);

		for (int colIndex = 13; colIndex <= 33; colIndex++) {
			String colLetter = CellReference.convertNumToColString(colIndex);
			String cellValue = excelData.getOrDefault(colLetter, "");

			boolean isBlank = cellValue.trim().isEmpty();

			System.out.println("Column " + colLetter + " value: '" + cellValue + "'");

			assertEquals(isBlank, true, "Column " + colLetter + " is expected to be blank but found: " + cellValue);
		}
	}

	public void verifySheetNameCommodityDetails() {
		File file = null;
		try {
			LoggerUtil.info("🔍 Trying to fetch the latest downloaded Commodity Details Excel file.");
			file = getLatestCommodityDetailsTabFile();

			if (file != null && file.exists()) {
				LoggerUtil.pass("✅ Excel file found: " + file.getName());
			} else {
				LoggerUtil.fail("❌ Excel file not found or does not exist.");
				return;
			}
		} catch (Exception e) {
			LoggerUtil.error("❌ Exception while fetching latest Excel file: " + e.getMessage());
			return;
		}

		try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {

			LoggerUtil.info("📖 Reading sheet name from the Excel file.");

			String actualSheetName = workbook.getSheetName(0);
			String expectedSheetName = "Commodity Yearly";

			LoggerUtil.info("📄 Sheet name found: '" + actualSheetName + "'");

			if (actualSheetName.equals(expectedSheetName)) {
				LoggerUtil.pass("✅ Sheet name matched: " + actualSheetName);
			} else {
				LoggerUtil.mismatch(
						"❌ Sheet name mismatch! Expected: " + expectedSheetName + ", Found: " + actualSheetName);
			}

		} catch (Exception e) {
			LoggerUtil.error("❌ Exception while reading sheet name from Excel: " + e.getMessage());
		}
	}

	public void verifyDownloadedFileName() {
		File file = null;

		try {
			LoggerUtil.info(" Trying to fetch the latest downloaded Commodity Details Excel file.");
			file = getLatestCommodityDetailsTabFile();

			if (file == null || !file.exists()) {
				LoggerUtil.fail(" Excel file not found or does not exist.");
				return;
			} else {
				LoggerUtil.pass(" Excel file found: " + file.getName());
			}
		} catch (Exception e) {
			LoggerUtil.error(" Exception while fetching latest Excel file: " + e.getMessage());
			return;
		}

		try {
			String actualFileName = file.getName();
			LoggerUtil.info(" Validating file name: " + actualFileName);

			String expectedPattern = "^Commodity Type Yearly-Whole\\d{2}-\\d{2}-\\d{4}_\\d{2}-\\d{2}-\\d{2}\\.xlsx$";

			if (actualFileName.matches(expectedPattern)) {
				LoggerUtil.pass(" File name matches expected pattern.");
			} else {
				LoggerUtil.mismatch(" File name does not match expected pattern. Found: " + actualFileName);
			}

			String dateFromFilename = extractDateFromFileName(actualFileName);
			String todayDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

			LoggerUtil.info(" Extracted date from filename: " + dateFromFilename);
			LoggerUtil.info(" System today's date: " + todayDate);

			if (dateFromFilename.equals(todayDate)) {
				LoggerUtil.pass(" File name contains today's date: " + dateFromFilename);
			} else {
				LoggerUtil
						.mismatch(" File name date mismatch. Expected: " + todayDate + ", Found: " + dateFromFilename);
			}

		} catch (Exception e) {
			LoggerUtil.error(" Exception while validating file name: " + e.getMessage());
		}
	}

	private String extractDateFromFileName(String fileName) {
		try {

			Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
			Matcher matcher = datePattern.matcher(fileName);
			if (matcher.find()) {
				return matcher.group();
			}
		} catch (Exception e) {
			LoggerUtil.error(" Failed to extract date from file name: " + e.getMessage());
		}
		return "";
	}

	public String verifyWiteInvalidColoumNameAndImportAgain() throws InterruptedException {
		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			String colName = "XYZ";
			LoggerUtil.info("Step 3: Writing invalid column name '" + colName + "' in Excel...");

			ExcelFiller.setCellValue(filePath, 0, 2, 66, ExcelFiller.ValueType.STRING, Arrays.asList(colName));

			LoggerUtil.pass("Invalid column name filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing invalid column name: " + e.getMessage());
		}
		return filePath;
	}

	public void importInValidColomName() throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Getting file path with invalid column name...");
			String fullPath = verifyWiteInvalidColoumNameAndImportAgain();

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}

			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			WebElement fileInput = driver.findElement(By.id("excelUpload"));

			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			LoggerUtil.info("Step 4: Uploading file: " + fullPath);
			fileInput.sendKeys(fullPath);

			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();
			String expectedImportPopup = "Invalid Coloum Names. ";

			if (actualImportPopup.equals(expectedImportPopup)) {
				LoggerUtil.pass(
						"Popup message matched! Expected: " + expectedImportPopup + " | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail(
						"Popup message mismatch! Expected: " + expectedImportPopup + " | Actual: " + actualImportPopup);
			}

			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in importInValidColomName: " + e.getMessage());
		}
	}

	public String verifyWiteInvalidShapeDropDownValueAndImportAgain() throws InterruptedException {
		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			String shape = "XYZ";
			LoggerUtil.info("Step 3: Writing invalid shape dropdown value '" + shape + "' in Excel...");

			// Fill Excel
			ExcelFiller.setCellValue(filePath, 0, 3, 49, ExcelFiller.ValueType.STRING, Arrays.asList(shape));

			LoggerUtil.pass("Invalid shape value filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing invalid shape dropdown value: " + e.getMessage());
		}
		return filePath;
	}

	public void importFileCommDetailWhole(String message) throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Getting file path with invalid shape dropdown value...");
			String fullPath = verifyWiteInvalidShapeDropDownValueAndImportAgain();

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}

			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			WebElement fileInput = driver.findElement(By.id("excelUpload"));

			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			LoggerUtil.info("Step 4: Uploading file: " + fullPath);
			fileInput.sendKeys(fullPath);

			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			// Print actual toast message in console + log
			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass(
						"Popup message matched! Expected to contain: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("Popup message mismatch! Expected to contain: '" + message + "' | Actual: "
						+ actualImportPopup);
			}

			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in importFileCommDetailWhole: " + e.getMessage());
		}
	}

	public String verifyEnterRmAndScrapPriceValue() throws InterruptedException {
		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = faker.name().firstName() + faker.letterify("??????");
			String AprilscrapValue = faker.name().firstName() + faker.letterify("???????");

			LoggerUtil.info("Step 3: Writing RM value: '" + AprilrmValue + "' at column 10...");
			ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.STRING, Arrays.asList(AprilrmValue));

			LoggerUtil.info("Step 4: Writing Scrap value: '" + AprilscrapValue + "' at column 11...");
			ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.STRING, Arrays.asList(AprilscrapValue));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;
	}

	public void importInvalidValuesInFile(String message) throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Getting file path with invalid RM and Scrap values...");
			String fullPath = verifyEnterRmAndScrapPriceValue();

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}

			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			WebElement fileInput = driver.findElement(By.id("excelUpload"));

			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			LoggerUtil.info("Step 4: Uploading file: " + fullPath);
			fileInput.sendKeys(fullPath);

			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			// Print actual toast message in console + log
			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass(
						"Popup message matched! Expected to contain: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("Popup message mismatch! Expected to contain: '" + message + "' | Actual: "
						+ actualImportPopup);
			}

			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in importInvalidValuesInFile: " + e.getMessage());
		}
	}

	public String verifyEnterNegativeRmAndNegativeScrapPriceValue() throws InterruptedException {
		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = "-" + faker.number().digits(4);

			String AprilscrapValue = "-" + faker.number().digits(4);

			LoggerUtil.info("Step 3: Writing RM value: '" + AprilrmValue + "' at column 10...");
			ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.STRING, Arrays.asList(AprilrmValue));

			LoggerUtil.info("Step 4: Writing Scrap value: '" + AprilscrapValue + "' at column 11...");
			ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.STRING, Arrays.asList(AprilscrapValue));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;
	}

	public void importInvalidNegativeBasePriceValuesInUi(String message) throws InterruptedException {
		try {
			LoggerUtil.info("Step 1: Getting file path with invalid RM and Scrap values...");
			String fullPath = verifyEnterNegativeRmAndNegativeScrapPriceValue();

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}

			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			WebElement fileInput = driver.findElement(By.id("excelUpload"));

			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			LoggerUtil.info("Step 4: Uploading file: " + fullPath);
			fileInput.sendKeys(fullPath);

			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			// Print actual toast message in console + log
			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass(
						"Popup message matched! Expected to contain: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("Popup message mismatch! Expected to contain: '" + message + "' | Actual: "
						+ actualImportPopup);
			}

			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);

		} catch (Exception e) {
			LoggerUtil.error("Exception in importInvalidValuesInFile: " + e.getMessage());
		}
	}

	public String EnterDuplicateDataInExcelFile() {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = "-" + faker.number().digits(4);

			String AprilscrapValue = "-" + faker.number().digits(4);
			String Shape = "Sheet";
			String comgrp = faker.name().firstName() + faker.letterify("????");
			String classification = faker.name().firstName() + faker.letterify("????");
			String suppname = "0801-Celesta-";
			String BusinessSegMent = "rishi";
			String specificgrade = faker.name().firstName() + faker.number().digits(4);
			String customername = "Mk-2208-5-2208-5";
			int denval = faker.number().numberBetween(10, 999);
			String densityValue = String.valueOf(denval);
			String uomdrop = "Mtr";
			String year = "2025-2026";

			ExcelFiller.setCellValue(filePath, 0, 4, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(comgrp));
			ExcelFiller.setCellValue(filePath, 0, 5, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(comgrp));
			ExcelFiller.setCellValue(filePath, 0, 4, 2, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(classification));
			ExcelFiller.setCellValue(filePath, 0, 5, 2, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(classification));
			ExcelFiller.setCellValue(filePath, 0, 4, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppname));
			ExcelFiller.setCellValue(filePath, 0, 5, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppname));
			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(BusinessSegMent));
			ExcelFiller.setCellValue(filePath, 0, 5, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(BusinessSegMent));
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.STRING, Arrays.asList(customername));
			ExcelFiller.setCellValue(filePath, 0, 5, 5, ExcelFiller.ValueType.STRING, Arrays.asList(customername));
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade));
			ExcelFiller.setCellValue(filePath, 0, 5, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade));
			ExcelFiller.setCellValue(filePath, 0, 4, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(uomdrop));
			ExcelFiller.setCellValue(filePath, 0, 5, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(uomdrop));
			ExcelFiller.setCellValue(filePath, 0, 4, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 5, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 49, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Shape));
			ExcelFiller.setCellValue(filePath, 0, 5, 49, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Shape));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;

	}

	public void importDuplicateDataInExcelFileForImport(String message) throws InterruptedException {

		// Step 1: Get file path
		try {
			LoggerUtil.info("Step 1: Getting file path with duplicate RM and Scrap values...");
			String fullPath = EnterDuplicateDataInExcelFile();

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

		// Step 2: Locate upload input
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

		// Step 4: Upload file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			String fullPath = EnterDuplicateDataInExcelFile();
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

		// Step 5: Capture toast
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			// Print actual toast message in console + log
			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

		// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public static final By ToastmessageForExportImportFile = By.xpath("//*[@id='toast-container']/div/div[2]");

	public void verifDownloadExcelFileAndVerifyToastMessage(String expectedName, String groupclassvalue, String toast)
			throws InterruptedException {

		// Step 1: Refresh page
		try {
			LoggerUtil.info("Step 1: Refreshing page...");
			driver.navigate().refresh();
			Thread.sleep(9000);
			LoggerUtil.pass("Page refreshed successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (refresh): " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 2: Clicking Export and Import Button...");
			clickOnElement(clickingExportAndImportButton);
			Thread.sleep(3000);
			LoggerUtil.pass("Clicked Export and Import Button.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (click Export & Import): " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 3: Opening Commodity Dropdown...");
			clickOnElement(clickingCommodityDropdownForExportImport);
			Thread.sleep(2000);
			LoggerUtil.pass("Commodity Dropdown opened.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (open Commodity dropdown): " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 4: Searching commodity: " + expectedName);
			clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), expectedName);
			Thread.sleep(2000);

			List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxCommodityDropdown);
			List<WebElement> checkboxNameList = driver.findElements(fetchingCheckboxCommodityGroupname);

			boolean found = false;
			for (int i = 0; i < checkboxNameList.size(); i++) {
				String flagGroupName = checkboxNameList.get(i).getText().trim();
				if (flagGroupName.equalsIgnoreCase(expectedName)) {
					checkboxListSelection.get(i).click();
					LoggerUtil.pass("Commodity selected: " + flagGroupName);
					found = true;
					break;
				}
			}
			if (!found) {
				LoggerUtil.fail("Commodity Group not found in dropdown: " + expectedName);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (search/select Commodity): " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 5: Opening Group Classification Dropdown...");
			clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
			Thread.sleep(3000);

			LoggerUtil.info("Searching Group Classification: " + groupclassvalue);
			clearAndEnterText(waitForExpectedElement(EnteringGroupclassificationValue), groupclassvalue);
			Thread.sleep(3000);

			List<WebElement> groupclassificationName = driver.findElements(fetchingNameGroupClassification);
			List<WebElement> selectingcheckboxgrpclass = driver.findElements(ClickingCheckboxClassification);

			boolean founded = false;
			for (int i = 0; i < groupclassificationName.size(); i++) {
				String groupclassificationsName = groupclassificationName.get(i).getText().trim();
				if (groupclassificationsName.equals(groupclassvalue)) {
					selectingcheckboxgrpclass.get(i).click();
					LoggerUtil.pass("Group Classification selected: " + groupclassvalue);
					founded = true;
					Thread.sleep(6000);
					break;
				}
			}
			if (!founded) {
				LoggerUtil.fail("Group Classification not found: " + groupclassvalue);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (Group Classification): " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 6: Clicking Export button...");
			clickOnElement(clickingExportButtonForDownload);

			String actualMessage = waitForExpectedElement(ToastmessageForExportImportFile).getText();
			System.out.println("Toast Message: " + actualMessage);
			LoggerUtil.info("Toast Message Displayed: " + actualMessage);

			if (actualMessage.contains(toast)) {
				LoggerUtil.pass("Toast matched  Expected to contain: '" + toast + "' | Actual: " + actualMessage);
			} else {
				LoggerUtil.fail(" Toast mismatch! Expected to contain: '" + toast + "' | Actual: " + actualMessage);
			}

			Thread.sleep(15000);
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (Export & Toast validation): " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 7: Checking latest downloaded file...");
			File latestFile = getLatestCommodityDetailsTabFile();
			if (latestFile != null) {
				LoggerUtil.pass("Download success. File found: " + latestFile.getName());
			} else {
				LoggerUtil.fail("No file found in downloads after export.");
			}
			Thread.sleep(300);
		} catch (Exception e) {
			LoggerUtil.error("Step 7 failed (verify downloaded file): " + e.getMessage());
		}
	}

	public String WriteGroupDeltaRMAndScrapWithInvalidDataType() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Generate invalid RM and Scrap values (non-numeric)
		String Rmvalue = faker.name().firstName() + faker.letterify("?????");
		String Scrapvalue = faker.name().firstName() + faker.letterify("?????");

		String year = "2026-2027";
		String period = "Aug";

		try {
			// ✅ Update Excel with invalid values (will cause NumberFormatException)
			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			// This will throw NumberFormatException due to invalid data
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));
		} catch (NumberFormatException e) {
			// Handle exception and log it
			LoggerUtil.error("❌ NumberFormatException: Invalid data type provided for RM/Scrap values. ("
					+ e.getMessage() + ")");
			LoggerUtil.pass("✅ Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void importNewGroupDeltaWithInvalidRmAndScrap(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "Invalid Rm And Scrap Input";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public String WriteGroupDeltaRMAndScrapWithNegativeNumericNumber() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Generate random positive number
		int randomNumber = faker.number().numberBetween(200, 99999); // random number between 200 and 99999

		// Convert the random number to a String
		String Rmvalue = String.valueOf(randomNumber); // Convert integer to String
		String Scrapvalue = String.valueOf(randomNumber); // Convert integer to String

		// Make them negative
		Rmvalue = "-" + Rmvalue; // Adding negative sign
		Scrapvalue = "-" + Scrapvalue; // Adding negative sign

		String year = "2026-2027";
		String period = "Aug";

		try {
			// ✅ Update Excel with negative values
			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			// Set negative values in Excel (will be accepted as strings)
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		} catch (NumberFormatException e) {
			// Handle exception and log it
			LoggerUtil.error("❌ NumberFormatException: Invalid data type provided for RM/Scrap values. ("
					+ e.getMessage() + ")");
			LoggerUtil.pass("✅ Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void importNewGroupDeltaWithNegativeRmAndScrap(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "File imported successfully";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public String WriteGroupDeltaRMAndScrapWithMoreThanFiveDigit() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Generate random positive number
		int randomNumber = faker.number().numberBetween(99999999, 99999999); // random number between 200 and 99999

		// Convert the random number to a String
		String Rmvalue = String.valueOf(randomNumber); // Convert integer to String
		String Scrapvalue = String.valueOf(randomNumber); // Convert integer to String

		// Make them negative

		String year = "2026-2027";
		String period = "Aug";

		try {
			// ✅ Update Excel with negative values
			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			// Set negative values in Excel (will be accepted as strings)
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		} catch (NumberFormatException e) {
			// Handle exception and log it
			LoggerUtil.error("❌ NumberFormatException: Invalid data type provided for RM/Scrap values. ("
					+ e.getMessage() + ")");
			LoggerUtil.pass("✅ Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void importNewGroupDeltaWithMoreThanFiveDigit(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "File imported successfully";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public String WriteInvalidSheetNameInGroupDeltaExcelFile() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		int randomNumber = faker.number().numberBetween(99999999, 99999999); // random number between 200 and 99999

		// Convert the random number to a String
		String Rmvalue = String.valueOf(randomNumber); // Convert integer to String
		String Scrapvalue = String.valueOf(randomNumber); // Convert integer to String

		String year = "2026-2027";
		String period = "Aug";
		String sheet = faker.name().firstName();

		try {

			ExcelFiller.setCellValue(filePath, 0, 4, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(sheet));
			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		} catch (NumberFormatException e) {

			LoggerUtil.error(
					" NumberFormatException: Invalid data type provided for RM/Scrap values. (" + e.getMessage() + ")");
			LoggerUtil.pass(" Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void importInvalidSheetNameInGroupDeltaExcelFile(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "Invalid Values In Excel File.";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public String WriteGroupDeltaExcelFileInvalidMissingColomPeriod() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Generate random positive number
		int randomNumber = faker.number().numberBetween(99999999, 99999999); // random number between 200 and 99999

		// Convert the random number to a String
		String Rmvalue = String.valueOf(randomNumber); // Convert integer to String
		String Scrapvalue = String.valueOf(randomNumber); // Convert integer to String

		String year = "2026-2027";
		String period = "   ";

		try {
			// ✅ Update Excel with negative values
			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			// Set negative values in Excel (will be accepted as strings)
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		} catch (NumberFormatException e) {
			// Handle exception and log it
			LoggerUtil.error("❌ NumberFormatException: Invalid data type provided for RM/Scrap values. ("
					+ e.getMessage() + ")");
			LoggerUtil.pass("✅ Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void importNewGroupDeltaExcelFileInvalidMissingColomPeriod(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "File imported successfully";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public String VerifyGroupDeltaExcelFileImportToast() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Generate random positive number
		int randomNumber = faker.number().numberBetween(1, 999999); // random number between 200 and 99999

		// Convert the random number to a String
		String Rmvalue = String.valueOf(randomNumber); // Convert integer to String
		String Scrapvalue = String.valueOf(randomNumber); // Convert integer to String

		// Make them negative

		String year = "2026-2027";
		String period = "Aug";

		try {

			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));

			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			// Set negative values in Excel (will be accepted as strings)
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		} catch (NumberFormatException e) {
			// Handle exception and log it
			LoggerUtil.error("❌ NumberFormatException: Invalid data type provided for RM/Scrap values. ("
					+ e.getMessage() + ")");
			LoggerUtil.pass("✅ Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void VerifyImportSucessFullPrompToast(String fullPath) throws Exception {
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "File imported successfully";
		Assert.assertEquals(actualImportPopup, expectedImportPopup);

		Thread.sleep(11000);
	}

	public String VerifyGroupDeltaExcelFileWithInvalidDataForUnsucessFullFile() throws Exception {
		Thread.sleep(3000);

		File latestFile = getLatestCommodityDetailsTabFileGroupDelta();
		if (latestFile == null) {
			LoggerUtil.mismatch("❌ No GroupDelta file found.");
			return null;
		}
		String filePath = latestFile.getAbsolutePath();

		// Generate random positive number
		int randomNumber = faker.number().numberBetween(1, 999999); // random number between 200 and 99999

		// Convert the random number to a String
		String Rmvalue = String.valueOf(randomNumber); // Convert integer to String
		String Scrapvalue = String.valueOf(randomNumber); // Convert integer to String

		// Make them negative

		String year = "2026edfg-2027fghb";
		String period = "Augtghj";

		try {

			ExcelFiller.setCellValue(filePath, 0, 4, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));

			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(period));

			// Set negative values in Excel (will be accepted as strings)
			ExcelFiller.setCellValue(filePath, 0, 4, 6, ExcelFiller.ValueType.INTEGER, Arrays.asList(Rmvalue));
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.INTEGER, Arrays.asList(Scrapvalue));

		} catch (NumberFormatException e) {
			// Handle exception and log it
			LoggerUtil.error("❌ NumberFormatException: Invalid data type provided for RM/Scrap values. ("
					+ e.getMessage() + ")");
			LoggerUtil.pass("✅ Exception handled successfully - Invalid data type in RM and Scrap values");
		}

		// 🟢 Store values in static map for later verification
		lastEnteredGroupDeltaData = new HashMap<>();
		lastEnteredGroupDeltaData.put("filePath", filePath);
		lastEnteredGroupDeltaData.put("year", year);
		lastEnteredGroupDeltaData.put("month", period);
		lastEnteredGroupDeltaData.put("rm", Rmvalue);
		lastEnteredGroupDeltaData.put("scrap", Scrapvalue);

		LoggerUtil.info("✅ Excel updated -> Year=" + year + " | Month=" + period + " | RM=" + Rmvalue + " | Scrap="
				+ Scrapvalue);

		return filePath;
	}

	public void VerifyImportUnSucessFullPrompToast(String fullPath) throws Exception {
		SoftAssert soft = new SoftAssert();
		clickOnElement(clickingGroupDeltaRadioButtonForExportingExcelFile);
		Thread.sleep(4000);

		forceExcelSaveForGroupDelta(fullPath);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);
		fileInput.sendKeys(fullPath);

		String actualImportPopup = waitForExpectedElement(toastmsg).getText();
		String expectedImportPopup = "Invalid imported File";
		soft.assertEquals(actualImportPopup, expectedImportPopup);

		soft.assertAll();
		Thread.sleep(11000);
	}

	public void VerifyDownLoadExcelFileForPriceUpdate(String enterValue) throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(9000);
		clickOnElement(clickingExportAndImportButton);
		LoggerUtil.info("Clicked on Export and Import Button");
		Thread.sleep(3000);

		clickOnElement(clickingCommodityDropdownForExportImport);
		LoggerUtil.info("Commodity Dropdown opened");
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdityDropDownForExport), enterValue);

		List<WebElement> checkboxListSelection = driver.findElements(clickingCheckboxForCommodityGroupDropdown);
		Thread.sleep(2000);
		WebElement clickingCheckboxComgrp = checkboxListSelection.get(0);
		Thread.sleep(2000);
		clickingCheckboxComgrp.click();

		Thread.sleep(2000);
		clickOnElement(clickingGroupClassificationDropdownForExportAndImport);
		LoggerUtil.info("Group Classification Dropdown opened");
		Thread.sleep(3000);

		List<WebElement> selectingcheckboxgrpclass = driver
				.findElements(clickingCheckboxForGroupClassificationForSelectAll);
		Thread.sleep(1000);
		WebElement clickingcheckboxGrpclass = selectingcheckboxgrpclass.get(0);
		Thread.sleep(2000);
		clickingcheckboxGrpclass.click();

		clickOnElement(clickingExportButtonForDownload);
		Thread.sleep(35000);

		getLatestCommodityDetailsTabFile();

		Thread.sleep(300);

	}

	public String EnterNonNumericRmAndScrap() {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = "-" + faker.number().digits(4);

			String AprilscrapValue = "-" + faker.number().digits(4);
			String Shape = "Sheet";
			String comgrp = faker.name().firstName() + faker.letterify("????");
			String classification = faker.name().firstName() + faker.letterify("????");
			String suppname = "0801-Celesta-";
			String BusinessSegMent = "rishi";
			String specificgrade = faker.name().firstName() + faker.number().digits(4);
			String customername = "Mk-2208-5-2208-5";
			int denval = faker.number().numberBetween(10, 999);
			String densityValue = String.valueOf(denval);
			String uomdrop = "Mtr";
			String year = "2025-2026";
			String stringvalues = faker.name().firstName();

			ExcelFiller.setCellValue(filePath, 0, 4, 13, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));
			ExcelFiller.setCellValue(filePath, 0, 4, 14, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));
			ExcelFiller.setCellValue(filePath, 0, 4, 15, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));
			ExcelFiller.setCellValue(filePath, 0, 4, 16, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;

	}

	public void importWithInvalidBasePriceValueWithExcelSheet(String message) throws InterruptedException {

		// Step 1: Get file path
		try {
			LoggerUtil.info("Step 1: Getting file path with Non-Numeric RM and Scrap values...");
			String fullPath = EnterNonNumericRmAndScrap();

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

		// Step 2: Locate upload input
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

		// Step 4: Upload file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			String fullPath = EnterNonNumericRmAndScrap(); // ✅ FIXED
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

		// Step 5: Capture toast
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

		// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public String EnterInvalidDropdowns() {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = "-" + faker.number().digits(4);

			String AprilscrapValue = "-" + faker.number().digits(4);
			String Shape = "Sheet";
			String comgrp = faker.name().firstName() + faker.letterify("????");
			String classification = faker.name().firstName() + faker.letterify("????");
			String suppname = "0801-Celesta-";
			String BusinessSegMent = "rishi";
			String specificgrade = faker.name().firstName() + faker.number().digits(4);
			String customername = "Mk-2208-5-2208-5";
			int denval = faker.number().numberBetween(10, 999);
			String densityValue = String.valueOf(denval);
			String uomdrop = "Mtr";
			String year = "2099999999";
			String stringvalues = faker.name().firstName();

			ExcelFiller.setCellValue(filePath, 0, 4, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(year));
			ExcelFiller.setCellValue(filePath, 0, 4, 14, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));
			ExcelFiller.setCellValue(filePath, 0, 4, 15, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));
			ExcelFiller.setCellValue(filePath, 0, 4, 16, ExcelFiller.ValueType.STRING, Arrays.asList(stringvalues));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;

	}

	public void importWithInvalidValueAndDropDowns(String message) throws InterruptedException {

		// Step 1: Get file path
		try {
			LoggerUtil.info("Step 1: Getting file path with Invalid Dropdown values...");
			String fullPath = EnterInvalidDropdowns(); // ✅ FIXED

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

		// Step 2: Locate upload input
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

		// Step 4: Upload file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			String fullPath = EnterInvalidDropdowns(); // ✅ FIXED
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

		// Step 5: Capture toast
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

		// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public void savedatainthirdtabForEnteringStringValueAndCharatersInBasePrice(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String aprilrm, String aprilscrap,
			String mayrm, String Entermayscrap) throws InterruptedException {

// Step 1: Wait
		try {
			LoggerUtil.info("Step 1: Waiting for page to settle (3s)...");
			Thread.sleep(3000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed: " + e.getMessage());
		}

// Step 2: Open Commodity dropdown
		try {
			LoggerUtil.info("Step 2: Clicking Commodity dropdown button (Third Tab)...");
			clickOnElement(ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(3000);
			LoggerUtil.pass("Commodity dropdown opened.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed: " + e.getMessage());
		}

// Step 3: Select Commodity value
		try {
			LoggerUtil.info("Step 3: Typing & selecting Commodity value: " + searchcommoditydropvalue);
			clearAndEnterText(waitForExpectedElement(searchInputforcommodityDetailsTab), searchcommoditydropvalue);

			List<WebElement> comlist = driver.findElements(commoditydropdownlist);
			boolean found = false;
			for (WebElement comgrpvalue : comlist) {
				if (comgrpvalue.getText().trim().equalsIgnoreCase(searchcommoditydropvalue)) {
					comgrpvalue.click();
					LoggerUtil.pass("Commodity selected: " + searchcommoditydropvalue);
					found = true;
					break;
				}
			}
			if (!found) {
				LoggerUtil.fail("Commodity not found: " + searchcommoditydropvalue);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed: " + e.getMessage());
		}

// Step 4: Select Group Classification
		Thread.sleep(4000);
		try {
			LoggerUtil.info("Step 4: Selecting Group Classification: " + searchcommodityclassification);
			clickOnElement(ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			boolean gcFound = false;
			for (WebElement grpclasslistval : driver.findElements(groupclassificationlist)) {
				if (grpclasslistval.getText().trim().equalsIgnoreCase(searchcommodityclassification)) {
					grpclasslistval.click();
					LoggerUtil.pass("Group Classification selected: " + searchcommodityclassification);
					gcFound = true;
					break;
				}
			}
			if (!gcFound) {
				LoggerUtil.fail("Group Classification not found: " + searchcommodityclassification);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed: " + e.getMessage());
		}
		Thread.sleep(7000);
// Step 5: Select Specific Grade
		try {
			LoggerUtil.info("Step 5: Selecting Specific Grade: " + selectcommoditygradevalue);
			clickOnElement(ClickingspecificgradeBtndropdownForThirdTab);

			Thread.sleep(2000);
			boolean gradeFound = false;
			for (WebElement comgradelistval : driver.findElements(specificgradelist)) {
				if (comgradelistval.getText().trim().equalsIgnoreCase(selectcommoditygradevalue)) {
					comgradelistval.click();
					LoggerUtil.pass("Specific Grade selected: " + selectcommoditygradevalue);
					gradeFound = true;
					break;
				}
			}
			if (!gradeFound) {
				LoggerUtil.fail("Specific Grade not found: " + selectcommoditygradevalue);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed: " + e.getMessage());
		}

// Step 6: Select UOM
		try {
			LoggerUtil.info("Step 6: Selecting UOM = 'Mtr'");
			clickOnElement(Uomdropdown);
			Thread.sleep(3000);
			WebElement searchuom = waitForExpectedElement(searchinputforuom);
			clearAndEnterText(searchuom, "Mtr");
			searchuom.sendKeys(Keys.ENTER);
			LoggerUtil.pass("UOM set to Mtr");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed: " + e.getMessage());
		}

// Step 7: Select Shape
		try {
			LoggerUtil.info("Step 7: Selecting Shape = 'Sheet'");
			clickOnElement(ClickingShapedropdownForthirdTab);
			Thread.sleep(300);
			WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			clearAndEnterText(shapesearch, "Sheet");
			shapesearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Shape set to Sheet");
		} catch (Exception e) {
			LoggerUtil.error("Step 7 failed: " + e.getMessage());
		}

		try {
			LoggerUtil.info("Step 8: Scrolling window by 160px before Year selection...");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 160);");
			LoggerUtil.pass("Scroll successful.");
		} catch (Exception e) {
			LoggerUtil.error("Step 8 failed (scroll): " + e.getMessage());
		}

		Thread.sleep(4000);
// Step 8: Select Year
		try {
			LoggerUtil.info("Step 8: Selecting Year = '2025-2026'");
			clickOnElement(selectyeardrop);
			Thread.sleep(500);
			WebElement yearsearch = waitForExpectedElement(searchinputyear);
			clearAndEnterText(yearsearch, "2025-2026");
			yearsearch.sendKeys(Keys.ENTER);
			LoggerUtil.pass("Year set to 2025-2026");
		} catch (Exception e) {
			LoggerUtil.error("Step 8 failed: " + e.getMessage());
		}

// Step 9: Select Business Segment
		try {
			LoggerUtil.info("Step 9: Selecting Business Segment = 'rishi'");
			clickOnElement(businessSegbox);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			Thread.sleep(5000);
			clickOnElement(selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Business Segment 'rishi' selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 9 failed: " + e.getMessage());
		}

// Step 10: Select Customer checkbox
		try {
			LoggerUtil.info("Step 10: Selecting Customer checkbox");
			clickOnElement(customercheckbox);
			LoggerUtil.pass("Customer checkbox selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 10 failed: " + e.getMessage());
		}

		String[] months = { "Apr", "May" };
		String[] rmValues = { aprilrm, mayrm };
		String[] scrapValues = { aprilscrap, Entermayscrap };

		// Loop dynamically for April → May
		for (int i = 0; i < months.length; i++) {
			try {
				// --- Enter RM ---
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "RM")), rmValues[i]);
				LoggerUtil.info("Entered " + months[i] + " RM → " + rmValues[i]);
				Thread.sleep(3000);

				// --- Enter Scrap ---
				clearAndEnterText(waitForExpectedElement(getDynamicRMOrScrapLocator(months[i], "Scrap")),
						scrapValues[i]);
				LoggerUtil.info("Entered " + months[i] + " Scrap → " + scrapValues[i]);
				Thread.sleep(3000);

			} catch (Exception e) {
				LoggerUtil.error("❌ Error entering " + months[i] + " RM/Scrap → " + e.getMessage());
			}
		}

		try {
			LoggerUtil.info("Step 11: Clicking Save and validating toast");
			clickOnElement(ClickingSaveBtnForThirdTab);

			String actualMessage = waitForExpectedElement(ToastMessageForSaveThirdTab).getText();
			String expectedMessage = "Commodity details saved successfully.";
			System.out.println("Toast Message: " + actualMessage);
			LoggerUtil.info("Toast Message Displayed: " + actualMessage);

			if (expectedMessage.equals(actualMessage)) {
				LoggerUtil.pass("Toast matched ✅ Expected: " + expectedMessage + " | Actual: " + actualMessage);
			} else {
				LoggerUtil.fail("❌ Toast mismatch! Expected: " + expectedMessage + " | Actual: " + actualMessage);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 11 failed: " + e.getMessage());
		}
	}

	public Map<String, String> VerifyAllDataWithInvalidRmAreInExcelFile(int rowNumber) {
		Map<String, String> excelData = new HashMap<>();
		try {
			File latestFile = getLatestCommodityDetailsTabFile();
			if (latestFile == null) {
				LoggerUtil.fail("❌ No Commodity Type Excel file found.");
				return excelData;
			}

			String filePath = latestFile.getAbsolutePath();
			try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

				Sheet sheet = workbook.getSheetAt(0);

				// Excel row is 1-based, POI is 0-based
				Row dataRow = sheet.getRow(rowNumber - 1);
				if (dataRow == null) {
					LoggerUtil.fail(" Data row not found at index " + rowNumber);
					return excelData;
				}

				DataFormatter formatter = new DataFormatter();

				// existing fields
				String commodityGroup = formatter.formatCellValue(dataRow.getCell(1));
				String groupClassification = formatter.formatCellValue(dataRow.getCell(2));
				String specificGrade = formatter.formatCellValue(dataRow.getCell(6));
				String density = formatter.formatCellValue(dataRow.getCell(7));

				// new invalid RM/Scrap fields
				String aprilRm = formatter.formatCellValue(dataRow.getCell(10)); // Col K
				String aprilScrap = formatter.formatCellValue(dataRow.getCell(11)); // Col L
				String mayRm = formatter.formatCellValue(dataRow.getCell(12)); // Col M
				String mayScrap = formatter.formatCellValue(dataRow.getCell(13)); // Col N

				excelData.put("Commodity Group", commodityGroup.trim());
				excelData.put("Group Classification", groupClassification.trim());
				excelData.put("Grade", specificGrade.trim());
				excelData.put("Density", density.trim());
				excelData.put("April RM", aprilRm.trim());
				excelData.put("April Scrap", aprilScrap.trim());
				excelData.put("May RM", mayRm.trim());
				excelData.put("May Scrap", mayScrap.trim());

				LoggerUtil.info("Commodity Group → " + commodityGroup);
				LoggerUtil.info("Group Classification → " + groupClassification);
				LoggerUtil.info("Grade → " + specificGrade);
				LoggerUtil.info("Density → " + density);
				LoggerUtil.info("April RM → " + aprilRm);
				LoggerUtil.info("April Scrap → " + aprilScrap);
				LoggerUtil.info("May RM → " + mayRm);
				LoggerUtil.info("May Scrap → " + mayScrap);
			}
		} catch (Exception e) {
			LoggerUtil.error("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}
		return excelData;
	}

	public void verifyExcelMatchesUIWithInvalidRm(int rowNumber, String commodityGroup, String groupClassification,
			String grade, String density, String aprilRm, String aprilScrap, String mayRm, String mayScrap) {
		Map<String, String> excelData = VerifyAllDataWithInvalidRmAreInExcelFile(rowNumber);

		compareValues("Commodity Group", commodityGroup, excelData.getOrDefault("Commodity Group", ""));
		compareValues("Group Classification", groupClassification, excelData.getOrDefault("Group Classification", ""));
		compareValues("Grade", grade, excelData.getOrDefault("Grade", ""));
		compareValues("Density", density, excelData.getOrDefault("Density", ""));
		compareValues("April RM", aprilRm, excelData.getOrDefault("April RM", ""));
		compareValues("April Scrap", aprilScrap, excelData.getOrDefault("April Scrap", ""));
		compareValues("May RM", mayRm, excelData.getOrDefault("May RM", ""));
		compareValues("May Scrap", mayScrap, excelData.getOrDefault("May Scrap", ""));
	}

	public String EnterNegativeValueAndZeroInBase() {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = "-" + faker.number().digits(4);

			String AprilscrapValue = "-" + faker.number().digits(4);
			String Shape = "Sheet";
			String comgrp = faker.name().firstName() + faker.letterify("????");
			String classification = faker.name().firstName() + faker.letterify("????");
			String suppname = "0801-Celesta-";
			String BusinessSegMent = "rishi";
			String specificgrade = faker.name().firstName() + faker.number().digits(4);
			String customername = "Mk-2208-5-2208-5";
			int denval = faker.number().numberBetween(10, 999);
			String densityValue = String.valueOf(denval);
			String uomdrop = "Mtr";
			String year = "2099999999";
			String stringvalues = faker.name().firstName();

			int negativenumber = faker.number().numberBetween(10, 999);
			String negnumber = "- " + String.valueOf(negativenumber);

			ExcelFiller.setCellValue(filePath, 0, 3, 10, ExcelFiller.ValueType.STRING, Arrays.asList(negnumber));
			ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.STRING, Arrays.asList(negnumber));
			ExcelFiller.setCellValue(filePath, 0, 3, 12, ExcelFiller.ValueType.STRING, Arrays.asList(negnumber));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;

	}

	public void importNegativeValuesInBaseRm(String message) throws InterruptedException {

		// Step 1: Get file path with Negative and Zero RM/Scrap values
		try {
			LoggerUtil.info("Step 1: Getting file path with Negative RM and Scrap values...");
			String fullPath = EnterNegativeValueAndZeroInBase(); // FIXED: Use the method for negative values

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

		// Step 2: Locate upload input
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

		// Step 4: Upload file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			String fullPath = EnterNegativeValueAndZeroInBase(); // FIXED: Use the method for negative values
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

		// Step 5: Capture toast
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

		// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public String EnterInvalidColomName() {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFile();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Generate random RM and Scrap values
			String AprilrmValue = "-" + faker.number().digits(4);
			String AprilscrapValue = "-" + faker.number().digits(4);
			String Shape = "Sheet";
			String comgrp = faker.name().firstName() + faker.letterify("????");
			String classification = faker.name().firstName() + faker.letterify("????");
			String suppname = "0801-Celesta-";
			String BusinessSegMent = "rishi";
			String specificgrade = faker.name().firstName() + faker.number().digits(4);
			String customername = "Mk-2208-5-2208-5";
			int denval = faker.number().numberBetween(10, 999);
			String densityValue = String.valueOf(denval);
			String uomdrop = "Mtr";
			String year = "2099999999";
			String stringvalues = faker.name().firstName();

			int negativenumber = faker.number().numberBetween(10, 999);
			String negnumber = "- " + String.valueOf(negativenumber);
			String headingname = "Ram";

			// Validating the column name before setting the value
			try {
				int columnIndex = 66; // Column BO is 62, check if it is valid
				if (columnIndex > 0 && columnIndex <= 16_384) { // Checking column limit (Excel max is 16,384)
					ExcelFiller.setCellValue(filePath, 0, 2, columnIndex, ExcelFiller.ValueType.STRING,
							Arrays.asList(headingname));
					LoggerUtil.pass("Invalid column name written successfully in: " + filePath);
				} else {
					LoggerUtil.fail("❌ Invalid column index: " + columnIndex);
				}
			} catch (Exception e) {
				LoggerUtil.error("Exception while writing invalid column name: " + e.getMessage());
			}

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;
	}

	public void importInvalidColomName(String message) throws InterruptedException {

		String fullPath = null;
		try {
			LoggerUtil.info("Step 1: Getting file path with Invalid Column Name...");
			fullPath = EnterInvalidColomName(); // FIXED: Get the file path from EnterInvalidColomName method

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

		// Step 2: Locate upload input
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

		// Step 4: Upload file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			fileInput.sendKeys(fullPath); // ✅ Upload the file using the correct fullPath
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

		// Step 5: Capture toast
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

		// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public String verifyDownLoadNewGradeAdditionRemoveCommodityGroupAndYear() throws InterruptedException {
		Thread.sleep(7000);

		// Step 1: Click Export and Import Button
		try {
			LoggerUtil.info("Step 1: Clicking Export and Import Button...");
			clickOnElement(clickingExportAndImportButton);
			LoggerUtil.pass("Clicked on Export and Import Button");
			Thread.sleep(3000);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed: " + e.getMessage());
		}

		// Step 2: Click Radio Button for New Grade Addition
		try {
			LoggerUtil.info("Step 2: Clicking New Grade Addition Radio Button for Export...");
			clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
			Thread.sleep(3000);
			LoggerUtil.pass("New Grade Addition Radio Button clicked.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed: " + e.getMessage());
		}

		// Step 3: Open and Select Supplier Dropdown
		try {
			LoggerUtil.info("Step 3: Clicking Supplier Dropdown...");
			clickOnElement(clickingSupplierDropdownForExportExcelFile);
			LoggerUtil.info("Commodity Dropdown opened.");
			Thread.sleep(2000);

			List<WebElement> suppcheckbox = driver.findElements(ClickingCheckboxSupplier);
			WebElement selectingcheckbox = suppcheckbox.get(1); // Select 2nd supplier
			selectingcheckbox.click();
			LoggerUtil.pass("Supplier selected.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed: " + e.getMessage());
		}

		// Step 4: Click Export Button
		try {
			LoggerUtil.info("Step 4: Clicking Export Button for Download...");
			clickOnElement(clickingExportButtonForDownload);
			Thread.sleep(15000); // wait for download
			LoggerUtil.pass("Export button clicked, file downloading...");
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed: " + e.getMessage());
		}

		String filePath = null;
		try {
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();
			if (latestFile != null) {
				filePath = latestFile.getAbsolutePath();
			}
			Thread.sleep(4000);
			LoggerUtil.pass("Latest file fetched for New Grade Addition.");
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (fetch file): " + e.getMessage());
		}
		return filePath;
	}

	public String EnterValuesAndLeaveSomeMandatoryFieldInExcelFile(String CommodityGroupValue,
			String GroupClassificationValue, String EnterGradeValue) {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			String EnterShapeValue = "Sheet";
			String EnterYearValue = "2026-2027";
			String EnterPeriod = "Aug";
			String EnterUomValue = "Mtr";

			ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(CommodityGroupValue));
			ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(GroupClassificationValue));
			ExcelFiller.setCellValue(filePath, 0, 4, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterGradeValue));
			// ExcelFiller.setCellValue(filePath, 0, 5, 1, ExcelFiller.ValueType.STRING,
			// Arrays.asList(EnterDensityValue));
			ExcelFiller.setCellValue(filePath, 0, 6, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterShapeValue));
			ExcelFiller.setCellValue(filePath, 0, 7, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterYearValue));
			ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterPeriod));
			ExcelFiller.setCellValue(filePath, 0, 9, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterUomValue));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;

	}

	public void importInvalidNewGradeAdditionFile(String message, String CommodityGroupValue,
			String GroupClassificationValue, String EnterGradeValue) throws InterruptedException {

// Step 1: Get file path by filling Excel with some mandatory fields left empty

		clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
		Thread.sleep(3000);
		String fullPath = null;
		try {
			LoggerUtil.info("Step 1: Entering values and leaving some mandatory fields in Excel file...");
			fullPath = EnterValuesAndLeaveSomeMandatoryFieldInExcelFile(CommodityGroupValue, GroupClassificationValue,
					EnterGradeValue);

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

// Step 2: Locate upload input field
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

// Step 3: Make upload input visible using JavaScript
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

// Step 4: Upload the file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

// Step 5: Capture the toast message after the upload
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			System.out.println("Toast Message: " + actualImportPopup);
			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public String EnterInvalidSupplierName(String CommodityGroupValue, String GroupClassificationValue,
			String EnterGradeValue, String EnterDensityValue) {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			String EnterShapeValue = "Sheet";
			String EnterYearValue = "2026-2027";
			String EnterPeriod = "Aug";
			String EnterUomValue = "Mtr";
			String Suppname = faker.name().firstName();
			ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(CommodityGroupValue));
			ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(GroupClassificationValue));
			ExcelFiller.setCellValue(filePath, 0, 4, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterGradeValue));
			ExcelFiller.setCellValue(filePath, 0, 5, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterDensityValue));
			ExcelFiller.setCellValue(filePath, 0, 6, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterShapeValue));
			ExcelFiller.setCellValue(filePath, 0, 7, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterYearValue));
			ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterPeriod));
			ExcelFiller.setCellValue(filePath, 0, 9, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterUomValue));
			ExcelFiller.setCellValue(filePath, 0, 13, 0, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Suppname));

			LoggerUtil.pass("RM and Scrap values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;

	}

	public void importInvalidNewGradeAdditionFile(String message, String CommodityGroupValue,
			String GroupClassificationValue, String EnterGradeValue, String EnterDensityValue)
			throws InterruptedException {

		clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
		Thread.sleep(3000);
		String fullPath = null;
		try {
			LoggerUtil.info("Step 1: Entering values in Excel and fetching file path...");
			fullPath = EnterInvalidSupplierName(CommodityGroupValue, GroupClassificationValue, EnterGradeValue,
					EnterDensityValue);

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed: " + e.getMessage());
			return;
		}

// Step 2: Locate upload input field
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

// Step 3: Make upload input visible using JavaScript
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed: " + e.getMessage());
		}

// Step 4: Upload the file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed: " + e.getMessage());
		}

// Step 5: Capture the toast message after the upload
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);
			System.out.println("Toast Message: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed: " + e.getMessage());
		}

// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed: " + e.getMessage());
		}
	}

	public String EnterInvalidRmAndScrapDataType(String CommodityGroupValue, String GroupClassificationValue,
			String EnterGradeValue, String EnterDensityValue) {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			String EnterShapeValue = "Sheet";
			String EnterYearValue = "2026-2027";
			String EnterPeriod = "Aug";
			// String EnterUomValue = "Mtr"; // ✅ make sure this matches dropdown list in
			// Excel
			String RmPrice = faker.name().firstName();
			String ScrapPrice = faker.name().firstName();

// Fill values
			ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(CommodityGroupValue));
			ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(GroupClassificationValue));
			ExcelFiller.setCellValue(filePath, 0, 4, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterGradeValue));

// ✅ Density is plain text/number
			ExcelFiller.setCellValue(filePath, 0, 5, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterDensityValue));

			ExcelFiller.setCellValue(filePath, 0, 6, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterShapeValue));
			ExcelFiller.setCellValue(filePath, 0, 7, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterYearValue));
			ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterPeriod));

			// UOM exact string bhejo
			String EnterUomValue = "Mtr";

			// Debug print
			System.out.println("✅ Setting UOM value: " + EnterUomValue + " at Row 10 Col 2");

			// Set value
			ExcelFiller.setCellValue(filePath, 0, 10, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterUomValue));

// Invalid RM/Scrap values (string instead of number)
			ExcelFiller.setCellValue(filePath, 0, 12, 1, ExcelFiller.ValueType.STRING, Arrays.asList(RmPrice));
			ExcelFiller.setCellValue(filePath, 0, 12, 2, ExcelFiller.ValueType.STRING, Arrays.asList(ScrapPrice));

			LoggerUtil.pass("RM, Scrap, Density, and UOM values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;
	}

	public void importInvalidNewGradeAdditionFileForInvalidDataTypeRmAndScrap(String message,
			String CommodityGroupValue, String GroupClassificationValue, String EnterGradeValue,
			String EnterDensityValue) throws InterruptedException {

		clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
		Thread.sleep(3000);

// Step 1: Enter invalid RM/Scrap values in Excel
		String fullPath = null;
		try {
			LoggerUtil.info("Step 1: Entering invalid RM/Scrap values in Excel and fetching file path...");
			fullPath = EnterInvalidRmAndScrapDataType(CommodityGroupValue, GroupClassificationValue, EnterGradeValue,
					EnterDensityValue); // ✅ Correct method

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed: " + e.getMessage());
			return;
		}

// Step 2: Locate upload input field
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed: " + e.getMessage());
		}

// Step 4: Upload the file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed: " + e.getMessage());
		}

// Step 5: Capture the toast message
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed: " + e.getMessage());
		}

// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed: " + e.getMessage());
		}
	}

	public String EnterValidDataWithDuplicate(String CommodityGroupValue, String GroupClassificationValue,
			String EnterGradeValue, String EnterDensityValue) {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			// Static test values
			String EnterShapeValue = "Sheet";
			String EnterYearValue = "2026-2027";
			String EnterPeriod = "Aug";
			String EnterUomValue = "Mtr"; // must match Excel dropdown
			String RmPrice = "34";
			String ScrapPrice = "435";

			// Commodity Group duplicate
			ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(CommodityGroupValue));
			ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(CommodityGroupValue));

			// Group Classification duplicate
			ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(GroupClassificationValue));
			ExcelFiller.setCellValue(filePath, 0, 3, 3, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(GroupClassificationValue));

			// Specific Grade duplicate
			ExcelFiller.setCellValue(filePath, 0, 4, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterGradeValue));
			ExcelFiller.setCellValue(filePath, 0, 4, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterGradeValue));

			// Density duplicate
			ExcelFiller.setCellValue(filePath, 0, 5, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterDensityValue));
			ExcelFiller.setCellValue(filePath, 0, 5, 3, ExcelFiller.ValueType.STRING, Arrays.asList(EnterDensityValue));

			// Shape duplicate
			ExcelFiller.setCellValue(filePath, 0, 6, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterShapeValue));
			ExcelFiller.setCellValue(filePath, 0, 6, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterShapeValue));

			// Year duplicate
			ExcelFiller.setCellValue(filePath, 0, 7, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterYearValue));
			ExcelFiller.setCellValue(filePath, 0, 7, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterYearValue));

			// Period duplicate
			ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterPeriod));
			ExcelFiller.setCellValue(filePath, 0, 8, 3, ExcelFiller.ValueType.STRING, Arrays.asList(EnterPeriod));

			// UOM duplicate
			LoggerUtil.info("✅ Setting UOM value: " + EnterUomValue);
			ExcelFiller.setCellValue(filePath, 0, 10, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterUomValue));
			ExcelFiller.setCellValue(filePath, 0, 10, 3, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterUomValue));

			// Price values
			ExcelFiller.setCellValue(filePath, 0, 12, 1, ExcelFiller.ValueType.STRING, Arrays.asList(RmPrice));
			ExcelFiller.setCellValue(filePath, 0, 12, 3, ExcelFiller.ValueType.STRING, Arrays.asList(ScrapPrice));

			LoggerUtil.pass(
					"Duplicate Commodity Group, Classification, Grade, Density, UOM and RM/Scrap written successfully in: "
							+ filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing duplicate values: " + e.getMessage());
		}
		return filePath;
	}

	public void importDuplicateData(String message, String CommodityGroupValue, String GroupClassificationValue,
			String EnterGradeValue, String EnterDensityValue) throws InterruptedException {

		// Step 0: Select New Grade Addition option
		clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		String fullPath = null;
		try {
			LoggerUtil.info("Step 1: Entering duplicate values in Excel and fetching file path...");
			fullPath = EnterValidDataWithDuplicate(CommodityGroupValue, GroupClassificationValue, EnterGradeValue,
					EnterDensityValue); // ✅ Correct method

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed (fetch file path): " + e.getMessage());
			return;
		}

		Thread.sleep(6000);

		// Step 2: Locate upload input
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed (make input visible): " + e.getMessage());
		}

		// Step 4: Upload file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed (upload file): " + e.getMessage());
		}

		// Step 5: Validate toast message
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed (capture toast): " + e.getMessage());
		}

		// Step 6: Wait after import
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed (wait): " + e.getMessage());
		}
	}

	public String EnterValidEntries(String CommodityGroupValue, String GroupClassificationValue, String EnterGradeValue,
			String EnterDensityValue) {

		String filePath = null;
		try {
			LoggerUtil.info("Step 1: Waiting for file download...");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Fetching latest Commodity Details Tab file...");
			File latestFile = getLatestCommodityDetailsTabFileNewGrade();

			if (latestFile == null) {
				LoggerUtil.fail("No CommodityDetails Whole Excel File found.");
				return null;
			}

			filePath = latestFile.getAbsolutePath();
			LoggerUtil.pass("Latest file found: " + filePath);

			String EnterShapeValue = "Sheet";
			String EnterYearValue = "2026-2027";
			String EnterPeriod = "Aug";
			String EnterUomValue = "Mtr";
			String RmPrice = "567";
			String ScrapPrice = "456";

			// Fill values
			ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(CommodityGroupValue));
			ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN,
					Arrays.asList(GroupClassificationValue));
			ExcelFiller.setCellValue(filePath, 0, 4, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterGradeValue));

			// ✅ Density is plain text/number
			ExcelFiller.setCellValue(filePath, 0, 5, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterDensityValue));

			// 🔹 Correct way to fetch Density from Excel (row=5, col=1, sheet=0)
			// String den = ExcelUtil.getCellData(filePath, 0, 5, 1);
			// LoggerUtil.info("This is the density value = " + den);

			ExcelFiller.setCellValue(filePath, 0, 6, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterShapeValue));
			ExcelFiller.setCellValue(filePath, 0, 7, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterYearValue));
			ExcelFiller.setCellValue(filePath, 0, 8, 1, ExcelFiller.ValueType.STRING, Arrays.asList(EnterPeriod));

			// Debug print
			System.out.println("✅ Setting UOM value: " + EnterUomValue + " at Row 10 Col 2");
			ExcelFiller.setCellValue(filePath, 0, 10, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(EnterUomValue));

			// RM/Scrap valid values
			ExcelFiller.setCellValue(filePath, 0, 12, 1, ExcelFiller.ValueType.STRING, Arrays.asList(RmPrice));
			ExcelFiller.setCellValue(filePath, 0, 12, 2, ExcelFiller.ValueType.STRING, Arrays.asList(ScrapPrice));

			LoggerUtil.pass("RM, Scrap, Density, and UOM values filled successfully in: " + filePath);

		} catch (Exception e) {
			LoggerUtil.error("Exception while writing RM and Scrap values: " + e.getMessage());
		}
		return filePath;
	}

	public void importValidData(String message, String CommodityGroupValue, String GroupClassificationValue,
			String EnterGradeValue, String EnterDensityValue) throws InterruptedException {

		clickOnElement(ClickingNewGradeAdditionRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		// Step 1: Enter valid RM/Scrap values in Excel
		String fullPath = null;
		try {
			LoggerUtil.info("Step 1: Entering valid RM/Scrap values in Excel and fetching file path...");
			fullPath = EnterValidEntries(CommodityGroupValue, GroupClassificationValue, EnterGradeValue,
					EnterDensityValue); // ✅ Fixed call

			if (fullPath == null) {
				LoggerUtil.fail("No file available for upload. Skipping import.");
				return;
			}
			LoggerUtil.pass("File path fetched successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 1 failed: " + e.getMessage());
			return;
		}

		// Step 2: Locate upload input field
		WebElement fileInput = null;
		try {
			LoggerUtil.info("Step 2: Locating Excel upload input field...");
			fileInput = driver.findElement(By.id("excelUpload"));
			LoggerUtil.pass("Excel upload input field located.");
		} catch (Exception e) {
			LoggerUtil.error("Step 2 failed (locate upload input): " + e.getMessage());
			return;
		}

		// Step 3: Make upload input visible
		try {
			LoggerUtil.info("Step 3: Making upload field visible using JavaScript...");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
			LoggerUtil.pass("Upload input made visible.");
		} catch (Exception e) {
			LoggerUtil.error("Step 3 failed: " + e.getMessage());
		}

		// Step 4: Upload the file
		try {
			LoggerUtil.info("Step 4: Uploading file...");
			fileInput.sendKeys(fullPath);
			LoggerUtil.pass("File uploaded successfully: " + fullPath);
		} catch (Exception e) {
			LoggerUtil.error("Step 4 failed: " + e.getMessage());
		}

		// Step 5: Capture the toast message
		try {
			LoggerUtil.info("Step 5: Capturing import popup message...");
			String actualImportPopup = waitForExpectedElement(toastmsg).getText();

			LoggerUtil.info("Toast Message Displayed: " + actualImportPopup);

			if (actualImportPopup.contains(message)) {
				LoggerUtil.pass("Popup message matched ✅ Expected: '" + message + "' | Actual: " + actualImportPopup);
			} else {
				LoggerUtil.fail("❌ Popup message mismatch! Expected: '" + message + "' | Actual: " + actualImportPopup);
			}
		} catch (Exception e) {
			LoggerUtil.error("Step 5 failed: " + e.getMessage());
		}

		// Step 6: Post-import wait
		try {
			LoggerUtil.info("Step 6: Waiting for 11 seconds after import...");
			Thread.sleep(11000);
			LoggerUtil.pass("Wait complete.");
		} catch (Exception e) {
			LoggerUtil.error("Step 6 failed: " + e.getMessage());
		}
	}

	public static final By CkickingComgrpdropdownExportFile = By.xpath("//*[@id='comoditygrp']/span/div/button");
	public static final By clickingDirectCostRadioButtonForExportExcelFile = By.xpath("//*[@id=' DirectPriceR']");
	public static final By SearchingComGrpNameForDownLoadFile = By
			.xpath("//div[@class='multiselect-container dropdown-menu show']/div/input");
	public static final By clickingRadioButtonComgrpForExportFile = By
			.xpath("//select[@id='CommodityList1']/following-sibling::div/div/button/span/input");
	public static final By clickingGrpClassificationDrodown = By
			.xpath("//select[@id='CategoryList']/following-sibling::div/button");
	public static final By EnterSearchValueForDownloadingfile = By
			.xpath("//select[@id='CategoryList']/following-sibling::div/div/div/input");
	public static final By ClickingRadioButtonForGrpclassificationForExcelFile = By
			.xpath("//select[@id='CategoryList']/following-sibling::div/div/button//input");

	public static final By clickingExportForDownload = By.xpath("//button[@onclick='exportDetail()']");

	public void ReadDirectpriceheaderName() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		try {
			clickOnElement(ClickingExportAndImportBtn);
			Thread.sleep(3000);

			clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
			Thread.sleep(3000);

			clickOnElement(CkickingComgrpdropdownExportFile);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(SearchingComGrpNameForDownLoadFile), "Plastics22");

			Thread.sleep(5000);

			List<WebElement> RadioButtonList = driver.findElements(clickingRadioButtonComgrpForExportFile);
			Thread.sleep(3000);
			WebElement clickingRadiobutton = RadioButtonList.get(0);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickingRadiobutton);

			Thread.sleep(2000);
			clickOnElement(clickingGrpClassificationDrodown);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(EnterSearchValueForDownloadingfile), "ST");
			Thread.sleep(2000);
			clickOnElement(ClickingRadioButtonForGrpclassificationForExcelFile);

			Thread.sleep(2000);
			clickOnElement(clickingExportForDownload);
			Thread.sleep(14000);

			// ✅ Get latest file path
			String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
			Thread.sleep(2000);

			// ✅ Read header safely
			try {
				String headerName = ExcelUtil.readHeaderFromExcel(latestFilePath);
				System.out.println("🔹 Header Name Found: " + headerName); // <-- Added print
				softAssert.assertEquals(headerName.trim(), "Commodity Details - Yearly(DirectPrice)",
						"❌ Header name did not match in DirectPrice excel file!");
			} catch (Exception e) {
				System.out.println("⚠️ Exception while verifying header name: " + e.getMessage());
			}

			// ✅ Read and verify sheet name + column names (safe method)
			try {
				List<String> columnNames = ExcelUtil.readAndVerifySheetAndColumns(latestFilePath,
						"Commodity Yearly (DirectPrice)", // expected sheet name
						3 // 4th row = index 3
				);

				// ExcelUtil के अंदर sheetName भी print होगा
				System.out.println("✅ Column Names: " + columnNames);

				// ✅ Verify actual columns from Excel
				softAssert.assertTrue(columnNames.contains("Commodity Group"), "❌ Commodity Group column missing!");
				softAssert.assertTrue(columnNames.contains("Group Classification"),
						"❌ Group Classification column missing!");

			} catch (Exception e) {
				System.out.println("⚠️ Exception while reading sheet/columns: " + e.getMessage());
			}

		} catch (Exception e) {
			System.out.println("⚠️ Exception in ReadDirectpriceheaderName method: " + e.getMessage());
		} finally {
			// ✅ Assert all at the end
			softAssert.assertAll();
		}
	}

	private static Map<String, String> GrpclassComGrpDataForDirectPrice = new HashMap<>();

	public void WriteRmAndScrapValueInExcelFileAndCheckAccuracy(String EnterComGrpValue, String Enterclassficationval)
			throws InterruptedException {

		Thread.sleep(9000);

		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		clickOnElement(CkickingComgrpdropdownExportFile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(SearchingComGrpNameForDownLoadFile), EnterComGrpValue);

		Thread.sleep(5000);

		List<WebElement> RadioButtonList = driver.findElements(clickingRadioButtonComgrpForExportFile);
		Thread.sleep(3000);
		WebElement clickingRadiobutton = RadioButtonList.get(0);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickingRadiobutton);

		Thread.sleep(2000);
		clickOnElement(clickingGrpClassificationDrodown);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterSearchValueForDownloadingfile), Enterclassficationval);
		Thread.sleep(2000);
		clickOnElement(ClickingRadioButtonForGrpclassificationForExcelFile);

		Thread.sleep(2000);
		clickOnElement(clickingExportForDownload);
		Thread.sleep(14000);

		// ✅ Get latest file path
		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		Thread.sleep(2000);
		GrpclassComGrpDataForDirectPrice.put("Commditygroup", EnterComGrpValue);
		GrpclassComGrpDataForDirectPrice.put("groupclassification", Enterclassficationval);

	}

	// ===============================
	// Fill DirectPrice Excel File
	// ===============================
	private static Map<String, String> directPriceData = new HashMap<>();

	public String fillDirectPriceExcelFile() throws InterruptedException {
		Thread.sleep(3000);

		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		if (latestFilePath == null) {
			System.out.println("❌ No DirectPrice file found.");
			return null;
		}

		// Values to write
		String year = "2025-2026";
		String period = "Aug";
		String rm = faker.number().digits(4);
		String scrap = faker.number().digits(4);

		File file = new File(latestFilePath);

		try (FileInputStream fis = new FileInputStream(file); Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(4);
			if (row == null)
				row = sheet.createRow(4);

			// Write values
			row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(year);
			row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(period);
			row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(rm);
			row.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(scrap);

			try (FileOutputStream fos = new FileOutputStream(file, false)) {
				workbook.write(fos);
				fos.flush();
			}

			workbook.close();
			System.out.println("✅ Excel updated & force-saved: " + latestFilePath);

			// ✅ Store values in HashMap for later verification
			directPriceData.put("Year", year);
			directPriceData.put("Period", period);
			directPriceData.put("RM", rm);
			directPriceData.put("Scrap", scrap);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("❌ Failed to update DirectPrice Excel file");
		}

		return latestFilePath;
	}

	public static final By clickingCrossButtonCommodityDetailsTable = By
			.xpath("//button[contains(text(),'X') and @onclick='showcomodityDetailForm()']");
	public static final By EnterSearchValueForCommdetailTable = By.xpath("//div[@id='CommodityDetailTab']/descendant::input[@id='myInputListSearch']");
	public static final By clickingCrossButton = By
			.xpath("//div[@id='exportModal']/div/div/div/button[@class='btn-close']");
	public static final By clickingEditButton = By
			.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td/following-sibling::td//i");

	public void importNewProcessMasterWithCustomerFromExcel(String EnterComgrpname) throws InterruptedException {
		Thread.sleep(3000);

		// ✅ Fill and save Excel
		String fullPath = fillDirectPriceExcelFile();

		openSaveAndCloseExcel(fullPath);

		if (fullPath == null) {
			System.out.println("❌ Excel fill failed, cannot import");
			return;
		}

		Thread.sleep(6000);
		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));

		// Make it visible via JS
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("Uploading file: " + fullPath);

		fileInput.sendKeys(fullPath); // ✅ Upload file
		Thread.sleep(2000);

		// ✅ Verify toast message
		String actualmsg = waitForExpectedElement(toastmsg).getText();
		System.out.println("Toast Message: " + actualmsg);
		Assert.assertTrue(actualmsg.contains("File imported successfully"));

		Thread.sleep(5000);
		clickOnElement(clickingCrossButton);
		Thread.sleep(11000);
		clickOnElement(ClickingViewbtn);

		// ✅ Search for the commodity group
		clearAndEnterText(waitForExpectedElement(EnterSearchValueForCommdetailTable), EnterComgrpname);
		Thread.sleep(3000);

		List<WebElement> listEditButton = driver.findElements(clickingEditButton);
		if (!listEditButton.isEmpty()) {
			WebElement clickingeditbtn = listEditButton.get(0);
			Thread.sleep(2000);
			clickingeditbtn.click();
			Thread.sleep(5000);
			VerifyFetchingData();
		} else {
			System.out.println("❌ No edit button found for " + EnterComgrpname);
		}
	}

	public static final By FetchingRmData = By.xpath("//input[@id='aug']");
	public static final By fetchingScrapData = By.xpath("//input[@id='augScrap']");

	public void VerifyFetchingData() {
		String fetchingRmvlaue = waitForExpectedElement(FetchingRmData).getAttribute("value");
		String fetchingScrap = waitForExpectedElement(fetchingScrapData).getAttribute("value");

		System.out.println("UI RM Value: " + fetchingRmvlaue);
		System.out.println("UI Scrap Value: " + fetchingScrap);

		// ✅ Compare with stored HashMap values
		String expectedRm = directPriceData.get("RM");
		String expectedScrap = directPriceData.get("Scrap");

		if (fetchingRmvlaue.equals(expectedRm)) {
			System.out.println("✅ RM value matched: " + fetchingRmvlaue);
		} else {
			System.out.println("❌ RM mismatch → Expected: " + expectedRm + ", Found: " + fetchingRmvlaue);
		}

		if (fetchingScrap.equals(expectedScrap)) {
			System.out.println("✅ Scrap value matched: " + fetchingScrap);
		} else {
			System.out.println("❌ Scrap mismatch → Expected: " + expectedScrap + ", Found: " + fetchingScrap);
		}
	}

	public void openSaveAndCloseExcel(String filePath) {
		try {
			// 1. Open Excel
			Runtime.getRuntime().exec("cmd /c start excel \"" + filePath + "\"");
			Thread.sleep(5000); // Excel खुलने का wait

			// 2. Press Ctrl+S to save
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			LoggerUtil.info("✅ Excel saved with Ctrl+S");

			Thread.sleep(2000);

			// 3. Press Alt+F4 to close
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			LoggerUtil.info("✅ Excel closed successfully");

		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.mismatch("❌ Failed while handling Excel: " + e.getMessage());
		}
	}

	public String WriteRmAndScrapValueInExcelFileAndCheckAccuracyForFilterDataDirectPrice(String EnterComGrpValue,
			String Enterclassficationval) throws InterruptedException {
		Thread.sleep(9000);

		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		clickOnElement(CkickingComgrpdropdownExportFile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(SearchingComGrpNameForDownLoadFile), EnterComGrpValue);

		Thread.sleep(5000);

		List<WebElement> RadioButtonList = driver.findElements(clickingRadioButtonComgrpForExportFile);
		Thread.sleep(3000);
		WebElement clickingRadiobutton = RadioButtonList.get(0);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickingRadiobutton);

		Thread.sleep(2000);
		clickOnElement(clickingGrpClassificationDrodown);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterSearchValueForDownloadingfile), Enterclassficationval);
		Thread.sleep(2000);
		clickOnElement(ClickingRadioButtonForGrpclassificationForExcelFile);

		Thread.sleep(2000);
		clickOnElement(clickingExportForDownload);
		Thread.sleep(14000);

		// ✅ Get latest file path
		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		Thread.sleep(2000);

		// ✅ Store values in HashMap for later verification
		GrpclassComGrpDataForDirectPrice.put("Commditygroup", EnterComGrpValue);
		GrpclassComGrpDataForDirectPrice.put("groupclassification", Enterclassficationval);

		return latestFilePath; // ✅ return karo
	}

	public void readfilterdDataAsItIsInExcelSheetOrNot(String latestFilePath, String sheetName) {
		try {
			// ✅ Excel se values read karo (5th row -> index 4, B & C columns)
			List<String> rowValues = ExcelUtil.readRowBC(latestFilePath, sheetName, 4);

			String expectedCommoditygroup = rowValues.get(0); // Column B
			String expectedClassification = rowValues.get(1); // Column C

			// ✅ HashMap se actual values le rahe ho
			String actualCommoditygroup = GrpclassComGrpDataForDirectPrice.get("Commditygroup");
			String actualClassification = GrpclassComGrpDataForDirectPrice.get("groupclassification");

			// ✅ Debug prints
			System.out.println("Excel Commodity Group: " + expectedCommoditygroup);
			System.out.println("Excel Classification : " + expectedClassification);
			System.out.println("UI/HashMap Commodity Group: " + actualCommoditygroup);
			System.out.println("UI/HashMap Classification : " + actualClassification);

			// ✅ Assertions
			Assert.assertEquals(actualCommoditygroup, expectedCommoditygroup, "❌ Commodity Group mismatch!");
			Assert.assertEquals(actualClassification, expectedClassification, "❌ Group Classification mismatch!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("⚠️ Error in readfilterdDataAsItIsInExcelSheetOrNot: " + e.getMessage());
		}
	}

	public String DownLoadExcelFileForNamingConvention() throws InterruptedException {
		Thread.sleep(9000);

		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		clickOnElement(CkickingComgrpdropdownExportFile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(SearchingComGrpNameForDownLoadFile), "Plastics22");

		Thread.sleep(5000);

		List<WebElement> RadioButtonList = driver.findElements(clickingRadioButtonComgrpForExportFile);
		Thread.sleep(3000);
		WebElement clickingRadiobutton = RadioButtonList.get(0);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickingRadiobutton);

		Thread.sleep(2000);
		clickOnElement(clickingGrpClassificationDrodown);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterSearchValueForDownloadingfile), "ST");
		Thread.sleep(2000);
		clickOnElement(ClickingRadioButtonForGrpclassificationForExcelFile);

		Thread.sleep(2000);
		clickOnElement(clickingExportForDownload);
		Thread.sleep(14000);

		// ✅ Get latest file path
		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		Thread.sleep(2000);

		return latestFilePath; // ✅ return karo
	}

	public void DownloadExcelFileForInvalidColomName(String EnterComGrpValue, String Enterclassficationval)
			throws InterruptedException {

		Thread.sleep(9000);

		clickOnElement(ClickingExportAndImportBtn);
		Thread.sleep(3000);

		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(3000);

		clickOnElement(CkickingComgrpdropdownExportFile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(SearchingComGrpNameForDownLoadFile), EnterComGrpValue);

		Thread.sleep(5000);

		List<WebElement> RadioButtonList = driver.findElements(clickingRadioButtonComgrpForExportFile);
		Thread.sleep(3000);
		WebElement clickingRadiobutton = RadioButtonList.get(0);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickingRadiobutton);

		Thread.sleep(2000);
		clickOnElement(clickingGrpClassificationDrodown);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(EnterSearchValueForDownloadingfile), Enterclassficationval);
		Thread.sleep(2000);
		clickOnElement(ClickingRadioButtonForGrpclassificationForExcelFile);

		Thread.sleep(2000);
		clickOnElement(clickingExportForDownload);
		Thread.sleep(14000);

		// ✅ Get latest file path
		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		Thread.sleep(2000);
		GrpclassComGrpDataForDirectPrice.put("Commditygroup", EnterComGrpValue);
		GrpclassComGrpDataForDirectPrice.put("groupclassification", Enterclassficationval);

	}

	public String fillInvalidColom() throws InterruptedException {
		Thread.sleep(3000);

		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		if (latestFilePath == null) {
			System.out.println("❌ No DirectPrice file found.");
			return null;
		}

		File latestFile = new File(latestFilePath);
		String filePath = latestFile.getAbsolutePath();

		try {
			// ✅ Extra column (L → index 11) me value set karo
			ExcelFiller.setCellValue(filePath, 0, 3, 11, ExcelFiller.ValueType.STRING, Arrays.asList("xyz"));
			System.out.println("✅ Direct Price invalid column filled successfully in: " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("❌ Failed to fill invalid column in DirectPrice Excel");
		}

		return filePath;
	}

	public void importInvalidColumDirectPrice() throws InterruptedException {
		Thread.sleep(3000);

		// ✅ Fill Excel using NEW method
		String fullPath = fillInvalidColom();
		Thread.sleep(5000);

		if (fullPath == null) {
			System.out.println("❌ Excel fill failed, cannot import");
			return;
		}

		// ✅ Import fresh file
		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("📂 Uploading NEW file: " + fullPath);
		fileInput.sendKeys(fullPath);

		Thread.sleep(2000);

		String actualmsg = waitForExpectedElement(toastmsg).getText();
		System.out.println("Toast Message: " + actualmsg);
		Assert.assertTrue(actualmsg.contains("Invalid Coloumn"));

		Thread.sleep(5000);
		clickOnElement(clickingCrossButton);
		Thread.sleep(11000);
		clickOnElement(ClickingViewbtn);
	}

	public String fillInvalidShapeForDirectPrice() throws InterruptedException {
		Thread.sleep(3000);

		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		if (latestFilePath == null) {
			System.out.println("❌ No DirectPrice file found.");
			return null;
		}

		File latestFile = new File(latestFilePath);
		String filePath = latestFile.getAbsolutePath();

		// ✅ Values
		String shape = "unknown"; // F col
		String year = "2025-2026"; // H col
		String period = "Aug"; // I col
		String rmandscrap = faker.number().digits(4);

		try {
			// ✅ Shape → F (index 5)
			ExcelFiller.setCellValue(filePath, 0, 4, 5, ExcelFiller.ValueType.STRING, Arrays.asList(shape));

			// ✅ Year → H (index 7)
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.STRING, Arrays.asList(year));

			// ✅ Period → I (index 8)
			ExcelFiller.setCellValue(filePath, 0, 4, 8, ExcelFiller.ValueType.STRING, Arrays.asList(period));

			// ✅ RM & Scrap → J (9), K (10)
			ExcelFiller.setCellValue(filePath, 0, 4, 9, ExcelFiller.ValueType.INTEGER, Arrays.asList(rmandscrap));
			ExcelFiller.setCellValue(filePath, 0, 4, 10, ExcelFiller.ValueType.INTEGER, Arrays.asList(rmandscrap));

			System.out.println("✅ Values inserted at F, H, I, J, K successfully in: " + filePath);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("❌ Failed to fill values in DirectPrice Excel");
		}

		return filePath;
	}

	public void importInvalidshapeDropdown() throws InterruptedException {
		Thread.sleep(3000);

		// ✅ Fill Excel using NEW method
		String fullPath = fillInvalidShapeForDirectPrice();
		Thread.sleep(5000);

		if (fullPath == null) {
			System.out.println("❌ Excel fill failed, cannot import");
			return;
		}

		// ✅ Import fresh file
		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("📂 Uploading NEW file: " + fullPath);
		fileInput.sendKeys(fullPath);

		Thread.sleep(2000);

		// ✅ Validation check
		String actualmsg = waitForExpectedElement(toastmsg).getText();
		System.out.println("Toast Message: " + actualmsg);
		Assert.assertTrue(actualmsg.contains("Invalid Shape Value"));

		Thread.sleep(5000);
		clickOnElement(clickingCrossButton);
		Thread.sleep(11000);
		clickOnElement(ClickingViewbtn);
	}

	public String fillInvalidRmAndScrap() throws InterruptedException {
		Thread.sleep(3000);

		String latestFilePath = VerifyGetLatestFileForDirectPriceComGroupDetailsTab();
		if (latestFilePath == null) {
			System.out.println("❌ No DirectPrice file found.");
			return null;
		}

		File latestFile = new File(latestFilePath);
		String filePath = latestFile.getAbsolutePath();

		// ✅ Values
		String year = "2025-2026"; // H col
		String period = "Aug"; // I col

		try {
			// ✅ Year → H (index 7)
			ExcelFiller.setCellValue(filePath, 0, 4, 7, ExcelFiller.ValueType.STRING, Arrays.asList(year));

			// ✅ Period → I (index 8)
			ExcelFiller.setCellValue(filePath, 0, 4, 8, ExcelFiller.ValueType.STRING, Arrays.asList(period));

			// ✅ RM & Scrap invalid text → J (9), K (10)
			ExcelFiller.setCellValue(filePath, 0, 4, 9, ExcelFiller.ValueType.STRING, Arrays.asList("fghjk"));
			ExcelFiller.setCellValue(filePath, 0, 4, 10, ExcelFiller.ValueType.STRING, Arrays.asList("dfgh"));

			System.out.println("✅ Invalid RM & Scrap inserted successfully in: " + filePath);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("❌ Failed to fill invalid RM & Scrap in DirectPrice Excel");
		}

		return filePath;
	}

	public void importWithInvalidRmAndScrap() throws InterruptedException {
		Thread.sleep(3000);

		// ✅ Fill Excel using RM/Scrap invalid method
		String fullPath = fillInvalidRmAndScrap();
		Thread.sleep(5000);

		if (fullPath == null) {
			System.out.println("❌ Excel fill failed, cannot import");
			return;
		}

		// ✅ Import fresh file
		clickOnElement(clickingDirectCostRadioButtonForExportExcelFile);
		Thread.sleep(5000);

		WebElement fileInput = driver.findElement(By.id("excelUpload"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

		System.out.println("📂 Uploading NEW file: " + fullPath);
		fileInput.sendKeys(fullPath);

		Thread.sleep(2000);

		// ✅ Validation check for RM/Scrap invalid
		String actualmsg = waitForExpectedElement(toastmsg).getText();
		System.out.println("Toast Message: " + actualmsg);
		Assert.assertTrue(actualmsg.contains("Invalid RM or Scrap Value"));

		Thread.sleep(5000);
		clickOnElement(clickingCrossButton);
		Thread.sleep(11000);
		clickOnElement(ClickingViewbtn);
	}
	public static final By viewbtn = By.xpath("//*[@id='CommodityDetailTab']/div[1]/div[2]/div/div/div/button[4]");
	public void goToCommodityDetailsPageView() throws InterruptedException {
		clickOnElement1(viewbtn);
		Thread.sleep(10000);
			
	}
	public static final By searchbox = By.xpath("//input[@id='myInputListSearch']");
	public static final By clickSupplierChackBox = By.xpath("(//div[@id='chkddd']//label/input[contains(@value, 'Supplier')])");
	public void searchOnSupplierCommodityDetailsPageSecendTime(String searchOnSuppliervalue) throws InterruptedException {
		Thread.sleep(10000);
		clickOnElement(clicksearchfileter);
		Thread.sleep(1000);	
		clickOnElement1(clickSupplierChackBox);
		sendKeysToTextBox(searchbox, searchOnSuppliervalue);		
	}
	
	/**
	 * Extracts RM/Scrap values for each grade per entity (Supplier/Customer/Commodity) 
	 * from the Commodity Details table dynamically.
	 * 
	 * Structure: { EntityName → { Grade → { Month → { "RM": value, "Scrap": value } } } }
	 * 
	 * @param entityType Type of entity ("Supplier", "Customer", "Commodity", etc.)
	 * @param entityName Name of entity to extract data for
	 * @return Nested data map
	 */
	public Map<String, Map<String, Map<String, Map<String, Double>>>> 
	       getUiEntityMonthRmScrapMap(String entityType, String entityName) {

	    LoggerUtil.info("🔍 Extracting RM & Scrap month-wise values for " + entityType + ": '" + entityName + "' ...");
	    Map<String, Map<String, Map<String, Map<String, Double>>>> entityData = new LinkedHashMap<>();

	    try {
	        List<WebElement> rows = driver.findElements(By.cssSelector("#ComDetailBody tr"));
	        LoggerUtil.info("📋 Total rows detected in Commodity Details table for '" + entityName + "': " + rows.size());

	        List<String> months = Arrays.asList(
	                "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar"
	        );
	        Map<String, Map<String, Map<String, Double>>> gradeMap = new LinkedHashMap<>();

	        for (WebElement row : rows) {
	            try {
	                WebElement gradeCell = row.findElement(By.cssSelector("td:nth-child(5)"));
	                String grade = gradeCell.getText().trim();
	                if (grade.isEmpty()) continue;

	                List<WebElement> cells = row.findElements(By.tagName("td"));
	                int startIndex = 7; // starting index for RM/Scrap monthly data columns
	                Map<String, Map<String, Double>> monthData = new LinkedHashMap<>();

	                int monthIndex = 0;
	                for (int i = startIndex; i < cells.size(); i += 2) {
	                    if (monthIndex >= months.size()) break;

	                    String rmText = cells.get(i).getText().trim();
	                    String scrapText = (i + 1 < cells.size()) ? cells.get(i + 1).getText().trim() : "";

	                    double rmValue = 0.0, scrapValue = 0.0;
	                    try {
	                        if (!rmText.isEmpty()) rmValue = Double.parseDouble(rmText);
	                    } catch (NumberFormatException e) {
	                        LoggerUtil.warn("⚠️ Invalid RM for " + months.get(monthIndex) + " in " + entityType + ": " + e.getMessage());
	                    }

	                    try {
	                        if (!scrapText.isEmpty()) scrapValue = Double.parseDouble(scrapText);
	                    } catch (NumberFormatException e) {
	                        LoggerUtil.warn("⚠️ Invalid Scrap for " + months.get(monthIndex) + " in " + entityType + ": " + e.getMessage());
	                    }

	                    Map<String, Double> pair = new LinkedHashMap<>();
	                    pair.put("RM", rmValue);
	                    pair.put("Scrap", scrapValue);
	                    monthData.put(months.get(monthIndex), pair);

	                    monthIndex++;
	                }

	                gradeMap.put(grade, monthData);
	            } catch (Exception ex) {
	                LoggerUtil.error("❌ Error parsing " + entityType + " grade row: " + ex.getMessage());
	            }
	        }

	        entityData.put(entityName, gradeMap);
	        LoggerUtil.info("✅ Extracted UI data structure for " + entityType + ": " + entityData);

	    } catch (Exception ex) {
	        LoggerUtil.error("❌ Error extracting " + entityType + " RM/Scrap data: " + ex.getMessage());
	    }

	    return entityData;
	}

	public static final By clickCustomerChackBox = By.xpath("(//div[@id='chkddd']//label/input[contains(@value, 'Customer')])");
	public void searchOnCustomerCommodityDetailsPageSecendTime(String searchOnCustomervalue) throws InterruptedException {
		Thread.sleep(10000);
		clickOnElement(clicksearchfileter);
		Thread.sleep(1000);	
		clickOnElement1(clickCustomerChackBox);
		sendKeysToTextBox(searchbox, searchOnCustomervalue);		
	}
	
	/**
	 * Fetches all unique Grade values from the Commodity Details table
	 * AFTER supplier filtering (e.g. after searchOnSupplierCommodityDetailsPageSecendTime).
	 * It waits until the filtered rows are visible and reads td[5] for Grade.
	 */
	public List<String> getAllGradesFromFilteredTable() {
	    List<String> gradeList = new ArrayList<>();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    try {
	        LoggerUtil.info("🔍 Waiting for filtered Commodity Details table to load...");

	        // Wait until table rows appear after filter
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//table[@id='comodityDetailListTable']/tbody/tr[1]/td[5]")));

	        int lastRowCount = 0;
	        while (true) {
	            List<WebElement> rows = driver.findElements(
	                    By.xpath("//table[@id='comodityDetailListTable']/tbody/tr"));
	            int currentRowCount = rows.size();

	            if (currentRowCount == 0) {
	                LoggerUtil.warn("⚠️ No rows detected in filtered table.");
	                break;
	            }

	            if (currentRowCount == lastRowCount) {
	                break; // stop when no new rows load
	            }

	            for (int i = 1; i <= currentRowCount; i++) {
	                try {
	                    WebElement gradeCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//table[@id='comodityDetailListTable']/tbody/tr[" + i + "]/td[5]")));
	                    String gradeValue = gradeCell.getText().trim();
	                    if (!gradeValue.isEmpty() && !gradeList.contains(gradeValue)) {
	                        gradeList.add(gradeValue);
	                    }
	                } catch (StaleElementReferenceException se) {
	                    LoggerUtil.info("Row " + i + " refreshed — reloading table view...");
	                    break;
	                } catch (NoSuchElementException ignored) {
	                }
	            }

	            // Scroll to bottom to ensure all rows loaded
	            WebElement scrollDiv = driver.findElement(By.id("part-table-scroll"));
	            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollDiv);
	            Thread.sleep(1200);

	            lastRowCount = currentRowCount;
	        }

	        if (gradeList.isEmpty()) {
	            LoggerUtil.fail("❌ No Grade values found even after filtering.");
	        } else {
	           	           
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Error reading Grade values: " + e.getMessage());
	    }

	    return gradeList;
	}

	public void searchOnSupplierCommodityDetailsPageThierdTime(String searchOnSuppliervalue) throws InterruptedException {
		Thread.sleep(10000);
		sendKeysToTextBox(searchbox, searchOnSuppliervalue);		
	}
	
	public void searchOnCustomerCommodityDetailsPageThiredTime(String searchOnCustomervalue) throws InterruptedException {
		Thread.sleep(10000);
		sendKeysToTextBox(searchbox, searchOnCustomervalue);		
	}
	
	public static final By clickGradecheckbox = By
			.xpath("(//div[@id='chkddd']//label/input[contains(@value, 'Grade')])[2]");
	public void searchOnCommodityGradCommodityDetailsPage(String values) throws InterruptedException {
		clickOnElement(clicksearchfileter);
		Thread.sleep(1000);
		clickOnElement(clickGradecheckbox);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchbox), values);
		Thread.sleep(3000);
		
	}
	
	/**
	 * Clicks on the Edit button for the first row in the Commodity Detail List table.
	 * Handles dynamic DOM reloads (avoids StaleElementReferenceException).
	 */
	public void clickOnFirstEditButton() {
	    LoggerUtil.info("Attempting to click on the Edit button for the first row in Commodity Detail List table.");
	    int retryCount = 0;
	    boolean clicked = false;

	    while (retryCount < 3 && !clicked) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            // Wait until table is present and first row is visible
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='comodityDetailListTable']//tbody/tr[1]")));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='comodityDetailListTable']//tbody/tr[1]")));

	            // Re-locate Edit button (avoid stale element)
	            WebElement editButton = driver.findElement(By.xpath(
	                    "//table[@id='comodityDetailListTable']//tbody/tr[1]//a[contains(@onclick, 'editDetail')]"
	            ));

	            // Ensure it is clickable before clicking
	            wait.until(ExpectedConditions.elementToBeClickable(editButton));

	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);

	            LoggerUtil.pass("Successfully clicked on Edit button for the first row in the Commodity Detail List table.");
	            clicked = true;

	        } catch (StaleElementReferenceException stale) {
	            retryCount++;
	            LoggerUtil.info("⚠️ DOM refreshed — retrying click on Edit button. Attempt " + retryCount);
	            try {
	                Thread.sleep(1000); // small wait before reattempt
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        } catch (Exception e) {
	            LoggerUtil.fail("Failed to click on Edit button in Commodity Detail List table. " + e.getMessage());
	            e.printStackTrace();
	            break;
	        }
	    }

	    if (!clicked) {
	        LoggerUtil.fail("❌ Unable to click Edit button after multiple retry attempts.");
	    }
	}
	
	/**
	 * Unchecks a random supplier checkbox inside the Supplier list table (id="rmSupplier")
	 * and returns the supplier name text for verification.
	 */
	public String uncheckRandomCheckboxFromSupplierListAndReturnValue() {
	    try {
	        LoggerUtil.info("Attempting to uncheck a random checkbox from the Supplier multi-select list.");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // 1️⃣ Wait until at least one checkbox is present (AJAX load complete)
	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	            By.xpath("//table[@id='rmSupplier']/tbody[@id='suplierList']//input[@type='checkbox']")
	        ));

	        // 2️⃣ Wait for at least one checkbox to actually be checked (using JavaScript check)
	        List<WebElement> allCheckboxes = driver.findElements(By.xpath(
	            "//table[@id='rmSupplier']/tbody[@id='suplierList']//input[@type='checkbox']"
	        ));

	        // Give some time for @checked attributes to appear
	        Thread.sleep(2000);

	        List<WebElement> checkedCheckboxes = new ArrayList<>();
	        for (WebElement cb : allCheckboxes) {
	            Boolean isChecked = (Boolean) ((JavascriptExecutor) driver)
	                    .executeScript("return arguments[0].checked;", cb);
	            if (Boolean.TRUE.equals(isChecked)) {
	                checkedCheckboxes.add(cb);
	            }
	        }

	        if (checkedCheckboxes.isEmpty()) {
	            LoggerUtil.fail("❌ No checked checkboxes found even after AJAX load stabilization.");
	            return null;
	        }

	        // 3️⃣ Randomly pick a checked checkbox
	        Random random = new Random();
	        WebElement randomCheckbox = checkedCheckboxes.get(random.nextInt(checkedCheckboxes.size()));

	        // 4️⃣ Get supplier label text
	        WebElement label = randomCheckbox.findElement(By.xpath("./parent::label"));
	        String supplierName = label.getText().trim().replaceAll("\\s+", " ");
	        LoggerUtil.info("Selected supplier for uncheck: " + supplierName);

	        // 5️⃣ Scroll to it and click using JS
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomCheckbox);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomCheckbox);

	        // 6️⃣ Wait until it's unchecked (reconfirm via JS)
	        wait.until(driver1 -> !(Boolean) ((JavascriptExecutor) driver1)
	                .executeScript("return arguments[0].checked;", randomCheckbox));

	        LoggerUtil.pass("✅ Successfully unchecked supplier: " + supplierName);
	        return supplierName;

	    } catch (StaleElementReferenceException e) {
	        LoggerUtil.fail("⚠️ DOM refreshed during supplier uncheck. Try increasing wait time. " + e.getMessage());
	        return null;
	    } catch (Exception e) {
	        LoggerUtil.fail("❌ Failed to uncheck supplier checkbox. " + e.getMessage());
	        e.printStackTrace();
	        return null;
	    }
	}

	/**
	 * Clicks on the 'Update' button in the Commodity Details tab.
	 */
	public void clickOnUpdateButton() {
	    try {
	        LoggerUtil.info("Attempting to click on the 'Update' button.");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        // Wait until the Update button is visible and clickable
	        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("tab3Save")));

	        // Scroll into view in case it's not visible in the viewport
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updateButton);

	        // Click using JavaScript (ensures click even if overlapped)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", updateButton);

	        LoggerUtil.pass("Clicked successfully on the 'Update' button.");

	    } catch (TimeoutException e) {
	        LoggerUtil.fail("❌ Update button not clickable within timeout. " + e.getMessage());
	    } catch (Exception e) {
	        LoggerUtil.fail("❌ Failed to click on the 'Update' button. " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public static final By verificationGradecolumn = By
			.xpath("//div[@id='comodity-view-list']/div/table/tbody/tr/td[5]");
	public void searchOnCommodityGroupCommodityDetailsPage() throws InterruptedException {
		clickOnElement(clicksearchfileter);
		Thread.sleep(1000);
		clickOnElement(clickGradecheckbox);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchbox), "Adrienne 47");
		Thread.sleep(4000);
		String expectedvalue = "Adrienne 47";
		String actualvalue = waitForExpectedElement(verificationGradecolumn).getText();
		Assert.assertEquals(actualvalue, expectedvalue);
		
	}
	
	/**
     * Finds the column index (1-based) for a given column header name.
     * Handles multi-row <thead> and nested tags like <sup>.
     */
    /**
     * Finds the column index (1-based) for a given column header name.
     * Handles multi-row <thead>, <sup> tags, merged headers, and case/punctuation normalization.
     */
    private int getColumnIndex(String headerText) {
        try {
            // Normalize target header text
            String normalizedTarget = headerText
                    .replaceAll("[\\s^/_.-]", "")   // remove spaces, ^, /, _, -, .
                    .replaceAll("³", "3")
                    .replaceAll("²", "2")
                    .toLowerCase();

            // Fetch all headers from both <tr> header rows
            List<WebElement> headers = driver.findElements(
                    By.xpath("//table[@id='comodityDetailListTable']//thead//th")
            );

            for (int i = 0; i < headers.size(); i++) {
                String actualHeader = headers.get(i).getText()
                        .replaceAll("[\\s^/_.-]", "")
                        .replaceAll("³", "3")
                        .replaceAll("²", "2")
                        .toLowerCase();

                // Partial containment works for flexible match (e.g. gm/cm3 vs gm/cm^3)
                if (actualHeader.contains(normalizedTarget) || normalizedTarget.contains(actualHeader)) {
                    
                    return i + 1;
                }
            }

            LoggerUtil.warn("⚠️ Column header not found for text: " + headerText);
            return -1;

        } catch (Exception e) {
            LoggerUtil.error("❌ Error locating column header '" + headerText + "': " + e.getMessage());
            return -1;
        }
    }
	
	// In CommodityDetailsPage
    /**
     * Fetches cell text for a given column header from the first row
     * of the Commodity Detail List table.
     * Handles multi-row header, <sup> tags, and sticky column positions.
     */
    public String getCellTextByColumn(String columnHeader) {
        try {
            int colIndex = getColumnIndex(columnHeader);

            if (colIndex == -1) {
                LoggerUtil.fail("❌ Column not found with header: " + columnHeader);
                return "";
            }

            // Locate the cell by dynamic column index
            WebElement cell = driver.findElement(By.xpath(
                    "//table[@id='comodityDetailListTable']//tbody/tr[1]/td[" + colIndex + "]"
            ));

            // Scroll into view (helps when many columns)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);

            String cellText = cell.getText().trim();
            LoggerUtil.info("📘 Value under column '" + columnHeader + "': " + cellText);
            return cellText;

        } catch (Exception e) {
            LoggerUtil.error("❌ Failed to fetch cell for column '" + columnHeader + "': " + e.getMessage());
            return "";
        }
    }
    
    private By commodityDetailsTable = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr[1]/td[5]");
	 /**
    * Fetches the 'Grade' text from the first row of the Commodity Details table.
    * @return Specific Grade value as String (trimmed), or empty if not found.
    */
   public String getSpecificGradeFromFirstRow() {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           // Wait for table to be visible
           WebElement gradeCell = wait.until(
                   ExpectedConditions.visibilityOfElementLocated(commodityDetailsTable));

           String gradeText = gradeCell.getText().trim();

           if (gradeText.isEmpty()) {
               LoggerUtil.warn("⚠️ Grade cell found but text is empty.");
           } else {
               LoggerUtil.info("✅ Grade fetched successfully: " + gradeText);
           }

           return gradeText;

       } catch (Exception e) {
           LoggerUtil.error("❌ Failed to fetch Specific Grade from first row: " + e.getMessage());
           return "";
       }
   }
	
   /**
	 * Extracts all RM values (Apr–Mar) from Commodity Details UI table
	 * @return Map<GradeName, Map<Month, RMValue>>
	 */
	public Map<String, Map<String, Double>> getUiGradeMonthRmMap() {
	    LoggerUtil.info("🔍 Extracting RM month-wise values from Commodity Details UI table...");
	    Map<String, Map<String, Double>> uiGradeMonthMap = new LinkedHashMap<>();

	    // Table body
	    List<WebElement> rows = driver.findElements(By.cssSelector("#ComDetailBody tr"));
	    LoggerUtil.info("📋 Total rows detected in Commodity Details table: " + rows.size());

	    // Month order (Apr–Mar)
	    List<String> months = Arrays.asList(
	        "Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb","Mar"
	    );

	    for (WebElement row : rows) {
	        try {
	            // Extract grade
	            WebElement gradeCell = row.findElement(By.cssSelector("td:nth-child(5)"));
	            String grade = gradeCell.getText().trim();
	            if (grade.isEmpty()) continue;

	            // All <td> cells
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            // Density + Year take up space → RM starts after 7th <td>
	            // Pattern is RM,Scrap repeated for 12 months
	            int startIndex = 7; // 1-based (first 7 cells are fixed columns)
	            Map<String, Double> monthValues = new LinkedHashMap<>();

	            int monthIndex = 0;
	            for (int i = startIndex; i < cells.size(); i += 2) {
	                if (monthIndex >= months.size()) break;

	                WebElement rmCell = cells.get(i);
	                String rmText = rmCell.getText().trim();
	                double rmValue = 0.0;
	                try {
	                    if (!rmText.isEmpty()) rmValue = Double.parseDouble(rmText);
	                } catch (NumberFormatException e) {
	                    LoggerUtil.warn("⚠️ Non-numeric RM for " + grade + " " + months.get(monthIndex) + ": " + rmText);
	                }

	                monthValues.put(months.get(monthIndex), rmValue);
	                monthIndex++;
	            }

	            uiGradeMonthMap.put(grade, monthValues);
	        } catch (Exception e) {
	            LoggerUtil.error("❌ Error parsing row: " + e.getMessage());
	        }
	    }

	    LoggerUtil.info("✅ UI Grade→Month RM map extracted: " + uiGradeMonthMap);
	    return uiGradeMonthMap;
	}
	
	/**
	 * Clicks on the Delete (trash) button for the first row in the Commodity Detail List table.
	 * Handles dynamic DOM reloads and waits for confirmation popup if present.
	 */
	public void clickOnFirstDeleteButton() {
	    LoggerUtil.info("Attempting to click on the Delete button for the first row in Commodity Detail List table.");
	    int retryCount = 0;
	    boolean clicked = false;

	    while (retryCount < 3 && !clicked) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            // Wait until first row is present and visible
	            wait.until(ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//table[@id='comodityDetailListTable']//tbody/tr[1]")));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//table[@id='comodityDetailListTable']//tbody/tr[1]")));

	            // Locate delete (trash) icon
	            WebElement deleteButton = driver.findElement(By.xpath(
	                    "//table[@id='comodityDetailListTable']//tbody/tr[1]//a[contains(@onclick, 'deleteDetail')]"
	            ));

	            // Ensure it's clickable before clicking
	            wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);

	            LoggerUtil.pass("🗑️ Successfully clicked on Delete button for the first row in the Commodity Detail List table.");
	            clicked = true;

	            // Optional: handle confirmation popup if it appears
	            try {
	                WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(3));
	                alertWait.until(ExpectedConditions.alertIsPresent());
	                Alert alert = driver.switchTo().alert();
	                LoggerUtil.info("⚠️ Confirmation alert appeared: " + alert.getText());
	                alert.accept();
	                LoggerUtil.pass("✅ Delete confirmation accepted.");
	            } catch (TimeoutException te) {
	                LoggerUtil.info("No confirmation alert appeared after delete click (continuing).");
	            }

	        } catch (StaleElementReferenceException stale) {
	            retryCount++;
	            LoggerUtil.info("⚠️ DOM refreshed — retrying click on Delete button. Attempt " + retryCount);
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        } catch (Exception e) {
	            LoggerUtil.fail("❌ Failed to click on Delete button in Commodity Detail List table. " + e.getMessage());
	            e.printStackTrace();
	            break;
	        }
	    }

	    if (!clicked) {
	        LoggerUtil.fail("❌ Unable to click Delete button after multiple retry attempts.");
	    }
	}

	public void searchOnGradeCommodityDetailsPageSecendTime(String searchOnGradevalue) throws InterruptedException {
		Thread.sleep(10000);
		clickOnElement(clicksearchfileter);
		Thread.sleep(1000);	
		clickOnElement1(clickGradecheckbox);
		sendKeysToTextBox(searchbox, searchOnGradevalue);		
	}
	
	public void searchOnGradeCommodityDetailsPageThierdTime(String searchOnGradevalue) throws InterruptedException {
		
		Thread.sleep(3000);	
		sendKeysToTextBox(searchbox, searchOnGradevalue);		
	}
	
	/**
	 * Extracts month-wise RM and Scrap values (Apr–Mar) for a given customer from the Commodity Details UI table.
	 * Returns structure: { CustomerName → { Month → { "RM": value, "Scrap": value } } }
	 */
	public Map<String, Map<String, Map<String, Double>>> getUiCustomerMonthRmScrapMap(String customerName) {
	    LoggerUtil.info("🔍 Extracting RM & Scrap month-wise values for customer: '" + customerName + "' ...");
	    Map<String, Map<String, Map<String, Double>>> uiCustomerMonthMap = new LinkedHashMap<>();

	    try {
	        List<WebElement> rows = driver.findElements(By.cssSelector("#ComDetailBody tr"));
	        LoggerUtil.info("📋 Total rows detected in Commodity Details table for '" + customerName + "': " + rows.size());

	        // Month order (Apr–Mar)
	        List<String> months = Arrays.asList("Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb","Mar");

	        for (WebElement row : rows) {
	            try {
	                WebElement gradeCell = row.findElement(By.cssSelector("td:nth-child(5)"));
	                String grade = gradeCell.getText().trim();
	                if (grade.isEmpty()) continue;

	                List<WebElement> cells = row.findElements(By.tagName("td"));
	                // RM starts at td[8], Scrap next to it
	                int startIndex = 7;
	                Map<String, Map<String, Double>> monthData = new LinkedHashMap<>();

	                int monthIndex = 0;
	                for (int i = startIndex; i < cells.size(); i += 2) {
	                    if (monthIndex >= months.size()) break;

	                    String rmText = cells.get(i).getText().trim();
	                    String scrapText = (i + 1 < cells.size()) ? cells.get(i + 1).getText().trim() : "";

	                    double rmValue = 0.0, scrapValue = 0.0;
	                    try {
	                        if (!rmText.isEmpty()) rmValue = Double.parseDouble(rmText);
	                    } catch (NumberFormatException e) {
	                        LoggerUtil.warn("⚠️ Non-numeric RM value for " + months.get(monthIndex) + ": " + rmText);
	                    }

	                    try {
	                        if (!scrapText.isEmpty()) scrapValue = Double.parseDouble(scrapText);
	                    } catch (NumberFormatException e) {
	                        LoggerUtil.warn("⚠️ Non-numeric Scrap value for " + months.get(monthIndex) + ": " + scrapText);
	                    }

	                    Map<String, Double> pair = new LinkedHashMap<>();
	                    pair.put("RM", rmValue);
	                    pair.put("Scrap", scrapValue);
	                    monthData.put(months.get(monthIndex), pair);
	                    monthIndex++;
	                }

	                uiCustomerMonthMap.put(customerName, monthData);

	            } catch (Exception innerEx) {
	                LoggerUtil.error("❌ Error parsing row for '" + customerName + "': " + innerEx.getMessage());
	            }
	        }

	        LoggerUtil.info("✅ UI Customer→Month (RM+Scrap) map extracted: " + uiCustomerMonthMap);

	    } catch (Exception ex) {
	        LoggerUtil.error("❌ Error extracting RM/Scrap data: " + ex.getMessage());
	    }

	    return uiCustomerMonthMap;
	}


}
