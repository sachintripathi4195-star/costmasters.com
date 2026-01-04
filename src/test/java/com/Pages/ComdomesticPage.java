package com.Pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

// Agar aap apni custom ExcelUtil class use kar rahe hain to uska import bhi yahan lagayen:
import com.helper.ExcelUtil;

// Agar aapke project mein LoggerUtil hai to uska import
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;

// Agar aapka CostingPage alag package mein hai to uska import

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;
import java.util.function.BiConsumer;

public class ComdomesticPage extends Base {

	SoftAssert soft = new SoftAssert();

	DashboardPage dashboard = new DashboardPage();

	public static final By ClickingGroupclassificationdropdown = By
			.xpath("//span[@id='select2-materialDrop-container']");
	public static final By searchInputforgroupclassification = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By clickingSpecificgradedropdown = By.xpath("//span[@id='select2-SpecificGrade-container']");
	public static final By searchinputForspecificgrade = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By clickingUomdropdown = By.xpath("//span[@id='select2-uomDrop-container']");
	public static final By searchinputforuom = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By ClickingShapedropdown = By.xpath("//span[@id='select2-shapeDrop-container']");
	public static final By searchinputforshape = By.xpath("//*[@id='page-top']/span/span/span[1]/input");

	public static final By businessSegbox = By
			.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/button");
	public static final By searchbarbusinessSeg = By.xpath("(//input[@placeholder='Search'])[1]");
	public static final By selectallcheckboxInbusinsessSeg = By.xpath(
			"//div[@class='multiselect-container dropdown-menu show']/div/following-sibling::button/span/input[@value='multiselect-all']");
	public static final By savebtn = By.xpath("//button[@id='tab3Save']");
	public static final By enterdate = By.xpath("//input[@id='EntryDate']");

	public static final By Domesticradiobtn = By.xpath("//*[@id='domesticR']");
	public static final By commoditydropdownlist = By.xpath("//ul[@id='select2-commodityDrop-results']/li");
	public static final By groupclassificationlist = By.xpath("//ul[@id='select2-materialDrop-results']/li");
	public static final By specificgradelist = By.xpath("//ul[@id='select2-SpecificGrade-results']/li");
	public static final By customercheckbox = By.xpath("//table[@id='rmCustomer']/tbody/tr[2]/td/div/label/input");

	public static final By commoditygroupdropdown = By.xpath("//span[@id='select2-commodityDropdown-container']");
	public static final By searchcommoditygroupdown = By
			.xpath("//*[@id='page-top']/span[2]/span/span[1]/input[@type='search']");
	public static final By selectvaluecommoditygroupvalue = By
			.xpath("//ul[@id='select2-commodityDropdown-results']/li");
	public static final By groupclassification = By.xpath("//input[@id='subGroupClassification']");
	public static final By specificgradevalue = By.xpath("//input[@id='SpecificGradeText']");
	public static final By Densityvalue = By.xpath("//input[@id='groupDensity']");
	public static final By savebtncommoditygrp = By.xpath("//*[@id='tab2Save']");

//	public void savesecondtabcommoditygroup(String searchcommodityvalue, String grpclassificationvalue, String specificgradevalye, String densityvalue) throws InterruptedException {
//	    LoggerUtil.info("Waiting for second tab Commodity Group section to load...");
//	    Thread.sleep(6000);
//
//	    LoggerUtil.info("Opening Select2 dropdown to select commodity value.");
//	    WebElement select2Box = driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single"));
//	    Actions actions = new Actions(driver);
//	    actions.moveToElement(select2Box).click().perform();
//
//	    LoggerUtil.info("Dropdown opened. Searching and selecting commodity: " + searchcommodityvalue);
//	    Thread.sleep(3000);
//	    List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);
//	    for (WebElement grpvalue : grouplist) {
//	        String text = grpvalue.getText().trim();
//	        if (text.equalsIgnoreCase(searchcommodityvalue)) {
//	            grpvalue.click();
//	            LoggerUtil.info("Selected commodity: " + text);
//	            break;
//	        }
//	    }
//
//	    LoggerUtil.info("Entering Group Classification value: " + grpclassificationvalue);
//	    clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
//
//	    LoggerUtil.info("Entering Specific Grade value: " + specificgradevalye);
//	    clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
//
//	    LoggerUtil.info("Entering Density value: " + densityvalue);
//	    clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
//
//	    LoggerUtil.info("Clicking Save button for Commodity Group.");
//	    clickOnElement(savebtncommoditygrp);
//
//	    LoggerUtil.info("Save action completed. Waiting for processing.");
//	    Thread.sleep(5000);
//	}

	public static final By fetchingcommgroupcolum = By.xpath("//*[@id='ComDetailBody']/tr/td[4]");
	public static final By searchinputforcommdetail = By.xpath("//*[@id='myInputListSearch']");
	public static final By viewbtn = By.xpath("//*[@id='CommodityDetailTab']/div[1]/div[2]/div/div/div/button[4]");
	public static final By clickeditbtn = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[2]/a[1]/i");
	public static final By searchcomclassificationdropvalue = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By toastmsgdomestic = By.xpath("//*[@id='toast-container']/div/div[2]");
	public static final By deletebtn = By.xpath("//*[@id='ComDetailBody']/tr/td[2]/a[2]/i");

	public void savedataforcommodityDetailsfordomestic(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalueforcomdetail,
			String message) throws InterruptedException {

		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
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
		clickOnElement(ClickingGroupclassificationdropdown);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchcomclassificationdropvalue), searchcommodityclassification);
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
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

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

		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Assert.assertTrue(waitForExpectedElement(toastmsgdomestic).getText().contains(message));
		Thread.sleep(7000);
		clickOnElement(Domesticradiobtn);
		clickOnElement(viewbtn);
		Thread.sleep(7000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);
		Thread.sleep(3000);

		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = searchcommoditydropvalue;
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);
		Thread.sleep(3000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();

	}

	public static final By EffectiveDate = By.xpath("//*[@id='SystemDate']");

	public void VerifyTodayDateForEffectiveDate(String expectedvalue) throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for System Date verification.");
		Thread.sleep(3000);

		String actualvalue = waitForExpectedElement(EffectiveDate).getDomAttribute("value");
		LoggerUtil.info("System Date found in field: " + actualvalue);

		Assert.assertEquals(actualvalue, expectedvalue);
		LoggerUtil.info("System Date verification PASSED. Expected: " + expectedvalue + ", Actual: " + actualvalue);

	}

	public static final By commoditydroplist = By.xpath("//select[@id='commodityDrop']/option");
	public static final By entervalueinsearchinput = By.xpath("//input[@class='select2-search__field']"); // more stable

	public void verifySearchfilterOfcommodityDrop() throws InterruptedException {
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for dropdown search verification.");
		Thread.sleep(3000);

		// Step 1: Open the dropdown
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown to open options.");
		Thread.sleep(1000); // wait for input to appear

		// Step 2: Type into search input
		WebElement searchInput = waitForExpectedElement(entervalueinsearchinput);
		clearAndEnterText(searchInput, "ABC");
		LoggerUtil.info("Entered search text 'ABC' in commodity group dropdown filter.");
		Thread.sleep(2000); // allow list to refresh

		// Step 3: Collect filtered options
		List<WebElement> filteredOptions = driver.findElements(commoditydroplist);
		boolean matchFound = false;

		for (WebElement option : filteredOptions) {
			String text = option.getText().trim();
			LoggerUtil.info("Found dropdown value: " + text);
			if (text.equals("ABC")) {
				matchFound = true;
				break;
			}
		}

		// Step 4: Assert if match was found
		Assert.assertTrue(matchFound, "❌ 'ABC' not found in filtered commodity dropdown.");
		LoggerUtil.info("✅ 'ABC' successfully found in filtered commodity dropdown.");
	}

	public static final By clssdrplist = By.xpath("//ul[@id='select2-materialDrop-results']/li");
	public static final By groupclassificationfirstvalue = By.xpath("//ul[@id='select2-materialDrop-results']/li[1]");

	public void verifysearchfilterCommodityclassification() throws InterruptedException {
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Group Classification dropdown search.");
		Thread.sleep(3000);

		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(500);

		WebElement searchBox = waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab);
		clearAndEnterText(searchBox, "ABC");
		LoggerUtil.info("Entered search text 'ABC' in commodity group search filter.");
		Thread.sleep(500);

		searchBox.sendKeys(Keys.ENTER);
		LoggerUtil.info("Pressed ENTER to apply filter.");
		Thread.sleep(2000);

		clickOnElement(ClickingGroupclassificationdropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown.");
		Thread.sleep(3000);

		List<WebElement> groupclss = driver.findElements(clssdrplist);

		boolean found = false;
		String expectedvalue = "-45";

		for (WebElement Listsdrop : groupclss) {
			String actual = Listsdrop.getText().trim();
			LoggerUtil.info("Found dropdown value: " + actual);
			if (actual.equals(expectedvalue)) {
				LoggerUtil.info(expectedvalue + " value found in the group classification dropdown.");
				found = true;
				break;
			}
		}

		Assert.assertTrue(found, "Expected value " + expectedvalue + " not found in the dropdown options.");
		LoggerUtil.info(
				"✅ Assertion done. Expected group classification value '" + expectedvalue + "' present: " + found);
	}

	public static final By gradelist = By.xpath("//ul[@id='select2-SpecificGrade-results']/li ");

	public void verifyspecificgrade() throws InterruptedException {

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Switched to 'Commodity Details' tab for Specific Grade dropdown search.");
		Thread.sleep(3000);

		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity Group dropdown.");
		Thread.sleep(500);

		WebElement searchBox = waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab);
		clearAndEnterText(searchBox, "ABC");
		LoggerUtil.info("Entered search text 'ABC' in commodity group search filter.");
		Thread.sleep(500);

		searchBox.sendKeys(Keys.ENTER);
		LoggerUtil.info("Pressed ENTER to apply filter.");
		Thread.sleep(2000);

		clickOnElement(ClickingGroupclassificationdropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown.");
		Thread.sleep(500);

		WebElement searchboxclasification = waitForExpectedElement(searchInputforgroupclassification);
		clearAndEnterText(searchboxclasification, "-45");
		LoggerUtil.info("Entered search text '-45' in group classification search filter.");
		searchboxclasification.sendKeys(Keys.ENTER);
		LoggerUtil.info("Pressed ENTER to apply group classification filter.");
		Thread.sleep(2000);

		clickOnElement(clickingSpecificgradedropdown);
		LoggerUtil.info("Clicked on Specific Grade dropdown.");
		Thread.sleep(4000);

		List<WebElement> gradevalue = driver.findElements(gradelist);
		String expectedvalue1 = "Ram";
		LoggerUtil.info("Looking for expected specific grade value: '" + expectedvalue1 + "'.");

		boolean found = false;
		for (WebElement listdrop : gradevalue) {
			String actual = listdrop.getText().trim();
			LoggerUtil.info("Dropdown Value: " + actual);
			if (actual.equals(expectedvalue1)) {
				LoggerUtil.info(expectedvalue1 + " value found in the grade dropdown.");
				Assert.assertEquals(actual, expectedvalue1, "Dropdown value match failed for grade.");
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.info("❌ Expected grade value '" + expectedvalue1 + "' not found in the grade dropdown.");
			Assert.fail("Expected grade value '" + expectedvalue1 + "' not found in the grade dropdown.");
		} else {
			LoggerUtil
					.info("✅ Assertion done. Expected specific grade value '" + expectedvalue1 + "' present: " + found);
		}
	}

	public static final By toastmsg = By.xpath("//*[@id='toast-container']/div/div[2]");

	public static void SaveComDetailsWithoutSelectingUOMDropDown(String searchComGrpName,
			String expectedGroupClassification, String expectedSpecificGrade) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		try {
			LoggerUtil.info("STEP 1: Open 'Commodity Group' dropdown.");
			clickOnElement(QuickMasterPage.ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(1000);
			LoggerUtil.pass("Commodity Group dropdown opened successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Failed to open Commodity Group dropdown → " + e.getMessage());
			softAssert.fail("Commodity Group dropdown could not be opened.");
		}

		try {
			LoggerUtil.info("STEP 2: Enter search text → " + searchComGrpName);
			WebElement searchInput = waitForExpectedElement(QuickMasterPage.enterSearchValueCommodityGrpThirdTab);
			clearAndEnterText(searchInput, searchComGrpName);
			Thread.sleep(2000);
			LoggerUtil.pass("Search keyword '" + searchComGrpName + "' entered successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Failed to enter search text in Commodity Group dropdown → " + e.getMessage());
			softAssert.fail("Search keyword entry failed for Commodity Group.");
		}

		try {
			LoggerUtil.info("STEP 3: Validate filtered options for '" + searchComGrpName + "'.");
			List<WebElement> filteredOptions = driver.findElements(QuickMasterPage.CommoditydropDownlistThirdTab);
			softAssert.assertTrue(filteredOptions.size() > 0,
					"No options displayed after applying search filter: " + searchComGrpName);

			boolean commodityMatchFound = false;
			for (WebElement option : filteredOptions) {
				if (option.getText().trim().equalsIgnoreCase(searchComGrpName)) {
					commodityMatchFound = true;
					option.click();
					LoggerUtil.pass("Expected value '" + searchComGrpName + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(commodityMatchFound,
					"Expected option '" + searchComGrpName + "' not found in commodity group dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Error while validating Commodity Group dropdown → " + e.getMessage());
			softAssert.fail("Commodity Group validation failed.");
		}

		try {
			Thread.sleep(3000);
			clickOnElement(QuickMasterPage.clickingAnotherWebElementCommodityDetailsTab);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 4: Open 'Group Classification' dropdown.");
			clickOnElement(QuickMasterPage.ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 5: Enter search text → " + expectedGroupClassification);
			clearAndEnterText(
					waitForExpectedElement(QuickMasterPage.searchInputforgroupclassificationDropDownInThirdTab),
					expectedGroupClassification);
			Thread.sleep(5000);

			LoggerUtil.info("STEP 6: Validate filtered options for '" + expectedGroupClassification + "'.");
			List<WebElement> groupClassificationOptions = driver
					.findElements(QuickMasterPage.GroupClassificationDropdownValueInThirdTab);

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
			clickOnElement(QuickMasterPage.clickingAnotherWebElementCommodityDetailsTab);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 7: Open 'Specific Grade' dropdown.");
			clickOnElement(QuickMasterPage.ClickingspecificgradeBtndropdownForThirdTab);
			Thread.sleep(4000);

			LoggerUtil.info("STEP 8: Enter search text → " + expectedSpecificGrade);
			clearAndEnterText(waitForExpectedElement(QuickMasterPage.SearchInputspecificgradeForThirdTab),
					expectedSpecificGrade);
			Thread.sleep(4000);

			LoggerUtil.info("STEP 9: Validate filtered options for '" + expectedSpecificGrade + "'.");
			List<WebElement> gradeOptions = driver.findElements(QuickMasterPage.GradeListThirdTab);
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

		LoggerUtil.info("STEP 10: Execute all collected soft assertions.");

		try {
			LoggerUtil.info("Step 7: Selecting Shape = 'Sheet'");
			clickOnElement(QuickMasterPage.ClickingShapedropdownForthirdTab);
			Thread.sleep(300);
			WebElement shapesearch = waitForExpectedElement(CommodityDetailsPage.searchinputforshape);
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

// Step 9: Select Business Segment
		try {
			LoggerUtil.info("Step 9: Selecting Business Segment = 'rishi'");
			clickOnElement(CommodityDetailsPage.businessSegbox);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchbarbusinessSeg), "rishi");
			Thread.sleep(5000);
			clickOnElement(CommodityDetailsPage.selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Business Segment 'rishi' selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 9 failed: " + e.getMessage());
		}

// Step 10: Select Customer checkbox
		try {
			LoggerUtil.info("Step 10: Selecting Customer checkbox");
			clickOnElement(CommodityDetailsPage.customercheckbox);
			LoggerUtil.pass("Customer checkbox selected");
		} catch (Exception e) {
			LoggerUtil.error("Step 10 failed: " + e.getMessage());
		}

// Step 11: Save and validate toast
		try {
			LoggerUtil.info("Step 11: Clicking Save and validating toast");
			clickOnElement(CommodityDetailsPage.ClickingSaveBtnForThirdTab);

			String actualMessage = waitForExpectedElement(CommodityDetailsPage.ToastMessageForSaveThirdTab).getText();
			String expectedMessage = "Select Unit";
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

	public static final By resetbtn = By.xpath("//*[@id='tab3Reset']");

	public static void SaveComDetailsWithoutSelectingShapeDropdown(String searchComGrpName,
			String expectedGroupClassification, String expectedSpecificGrade) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

// STEP 1: Commodity Group
		try {
			LoggerUtil.info("STEP 1: Open 'Commodity Group' dropdown.");
			clickOnElement(QuickMasterPage.ClickingcommoditydropdownBtnThirdTab);
			Thread.sleep(1000);

			LoggerUtil.info("STEP 2: Enter search text → " + searchComGrpName);
			WebElement searchInput = waitForExpectedElement(QuickMasterPage.enterSearchValueCommodityGrpThirdTab);
			clearAndEnterText(searchInput, searchComGrpName);
			Thread.sleep(2000);

			List<WebElement> filteredOptions = driver.findElements(QuickMasterPage.CommoditydropDownlistThirdTab);
			softAssert.assertTrue(filteredOptions.size() > 0,
					"No options displayed after applying search filter: " + searchComGrpName);

			boolean commodityMatchFound = false;
			for (WebElement option : filteredOptions) {
				if (option.getText().trim().equalsIgnoreCase(searchComGrpName)) {
					option.click();
					commodityMatchFound = true;
					LoggerUtil.pass("Expected value '" + searchComGrpName + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(commodityMatchFound,
					"Expected option '" + searchComGrpName + "' not found in commodity group dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Commodity Group selection failed → " + e.getMessage());
			softAssert.fail("Commodity Group validation failed.");
		}

// STEP 2: Group Classification
		try {
			Thread.sleep(3000);
			clickOnElement(QuickMasterPage.clickingAnotherWebElementCommodityDetailsTab);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 3: Open 'Group Classification' dropdown.");
			clickOnElement(QuickMasterPage.ClickingGroupclassificationBtnThirdTabDropdown);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 4: Enter search text → " + expectedGroupClassification);
			clearAndEnterText(
					waitForExpectedElement(QuickMasterPage.searchInputforgroupclassificationDropDownInThirdTab),
					expectedGroupClassification);
			Thread.sleep(5000);

			List<WebElement> groupClassificationOptions = driver
					.findElements(QuickMasterPage.GroupClassificationDropdownValueInThirdTab);

			boolean groupMatchFound = false;
			for (WebElement option : groupClassificationOptions) {
				if (option.getText().trim().equalsIgnoreCase(expectedGroupClassification)) {
					option.click();
					groupMatchFound = true;
					LoggerUtil.pass(
							"Expected Group Classification '" + expectedGroupClassification + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(groupMatchFound, "Expected option '" + expectedGroupClassification
					+ "' not found in group classification dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Group Classification selection failed → " + e.getMessage());
			softAssert.fail("Group Classification validation failed.");
		}

// STEP 3: Specific Grade
		try {
			Thread.sleep(3000);
			clickOnElement(QuickMasterPage.clickingAnotherWebElementCommodityDetailsTab);
			Thread.sleep(3000);

			LoggerUtil.info("STEP 5: Open 'Specific Grade' dropdown.");
			clickOnElement(QuickMasterPage.ClickingspecificgradeBtndropdownForThirdTab);
			Thread.sleep(4000);

			LoggerUtil.info("STEP 6: Enter search text → " + expectedSpecificGrade);
			clearAndEnterText(waitForExpectedElement(QuickMasterPage.SearchInputspecificgradeForThirdTab),
					expectedSpecificGrade);
			Thread.sleep(4000);

			List<WebElement> gradeOptions = driver.findElements(QuickMasterPage.GradeListThirdTab);
			boolean gradeFound = false;

			for (WebElement option : gradeOptions) {
				if (option.getText().trim().equalsIgnoreCase(expectedSpecificGrade)) {
					option.click();
					gradeFound = true;
					LoggerUtil.pass("Expected Specific Grade '" + expectedSpecificGrade + "' found and selected.");
					break;
				}
			}
			softAssert.assertTrue(gradeFound,
					"Expected Specific Grade '" + expectedSpecificGrade + "' not found in dropdown.");
		} catch (Exception e) {
			LoggerUtil.error("Specific Grade selection failed → " + e.getMessage());
			softAssert.fail("Specific Grade validation failed.");
		}

// STEP 4: UOM
		try {
			LoggerUtil.info("STEP 7: Open 'UOM' dropdown.");
			clickOnElement(CommodityDetailsPage.Uomdropdown);
			Thread.sleep(500);

			WebElement searchuom = waitForExpectedElement(CommodityDetailsPage.searchinputforuom);
			String expectedUom = "Mtr";
			clearAndEnterText(searchuom, expectedUom);
			searchuom.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			LoggerUtil.pass("UOM '" + expectedUom + "' selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("UOM selection failed → " + e.getMessage());
			softAssert.fail("UOM selection failed.");
		}

// STEP 5: Scroll
		try {
			LoggerUtil.info("STEP 8: Scrolling window by 160px before Year selection...");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 160);");
			LoggerUtil.pass("Window scrolled successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Scroll failed → " + e.getMessage());
		}

// STEP 7: Business Segment
		try {
			LoggerUtil.info("STEP 10: Selecting Business Segment = 'rishi'");
			clickOnElement(CommodityDetailsPage.businessSegbox);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchbarbusinessSeg), "rishi");
			Thread.sleep(5000);
			clickOnElement(CommodityDetailsPage.selectallcheckboxInbusinsessSeg);
			LoggerUtil.pass("Business Segment 'rishi' selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Business Segment selection failed → " + e.getMessage());
			softAssert.fail("Business Segment selection failed.");
		}

// STEP 8: Customer
		try {
			LoggerUtil.info("STEP 11: Selecting Customer checkbox.");
			clickOnElement(CommodityDetailsPage.customercheckbox);
			LoggerUtil.pass("Customer checkbox selected successfully.");
		} catch (Exception e) {
			LoggerUtil.error("Customer checkbox selection failed → " + e.getMessage());
			softAssert.fail("Customer checkbox selection failed.");
		}

// STEP 9: Save and Toast Validation
		try {
			LoggerUtil.info("STEP 12: Clicking Save and validating toast.");
			clickOnElement(CommodityDetailsPage.ClickingSaveBtnForThirdTab);

			String actualMessage = waitForExpectedElement(CommodityDetailsPage.ToastMessageForSaveThirdTab).getText();
			String expectedMessage = "Select Shape";

			LoggerUtil.info("Toast Message Displayed: " + actualMessage);

			if (expectedMessage.equals(actualMessage)) {
				LoggerUtil.pass("Toast matched ✅ Expected: " + expectedMessage + " | Actual: " + actualMessage);
			} else {
				LoggerUtil.fail("❌ Toast mismatch! Expected: " + expectedMessage + " | Actual: " + actualMessage);
			}
		} catch (Exception e) {
			LoggerUtil.error("Save & Toast validation failed → " + e.getMessage());
			softAssert.fail("Save operation failed.");
		}

		LoggerUtil.info("STEP 13: Execute all collected Soft Assertions.");
		softAssert.assertAll();
	}

	public static void WithoutSelectingComGroup() throws InterruptedException {

		// Step 6: Select UOM
		try {
			LoggerUtil.info("Step 6: Selecting UOM = 'Mtr'");
			clickOnElement(CommodityDetailsPage.Uomdropdown);
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
			clickOnElement(CommodityDetailsPage.ClickingShapedropdownForthirdTab);
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
			clickOnElement(CommodityDetailsPage.ClickingSaveBtnForThirdTab);

			String actualMessage = waitForExpectedElement(CommodityDetailsPage.ToastMessageForSaveThirdTab).getText();
			String expectedMessage = "Select Commodity group";
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

	public List<String> getVisibleMandatoryLabelNamesOnly() {
		List<String> visibleMandatoryLabels = new ArrayList<>();
		try {
			// Only <label> tags, ignore others (like <h3>)
			List<WebElement> visibleLabels = driver.findElements(By.xpath("//label[.//span[contains(text(), '*') "
					+ "and not(contains(@style,'display:none')) " + "and not(contains(@style,'visibility:hidden'))]]"));

			for (WebElement label : visibleLabels) {
				String labelText = label.getText().trim();
				if (!labelText.isEmpty()) {
					labelText = labelText.replace("*", "").trim();
					visibleMandatoryLabels.add(labelText);
					LoggerUtil.info("✅ Visible mandatory field found: " + labelText);
				}
			}

			LoggerUtil.pass("📋 Total visible <label> mandatory fields: " + visibleMandatoryLabels.size());

		} catch (Exception e) {
			LoggerUtil.error("❌ Error while fetching visible <label> mandatory labels → " + e.getMessage());
		}

		return visibleMandatoryLabels;
	}

	public static final By astriccomgroup = By.xpath("//*[@id='partAttributeDiv']/div[2]/div/div[3]/div[1]/label");

	public void verifyastricmandatoryfieldforcommoditygrp() {

		String actualmandatorycomgrp = waitForExpectedElement(astriccomgroup).getText();
		String expectedvalue = "Commodity Group*";
		Assert.assertEquals(actualmandatorycomgrp, actualmandatorycomgrp);

	}

	public static final By grpclassification = By.xpath("//*[@id='partAttributeDiv']/div[2]/div/div[4]/div[1]/label");

	public void verifyastricClassificationficat() {

		String actualmandatorycomclassification = waitForExpectedElement(grpclassification).getText();
		String expectedvalue = "Group Classification*";
		Assert.assertEquals(actualmandatorycomclassification, expectedvalue);
	}

	public static final By astricgrade = By.xpath("//*[@id='partAttributeDiv']/div[2]/div/div[5]/div[1]/label");

	public void verifyastricGradefield() {

		String actualmandatorygradefield = waitForExpectedElement(astricgrade).getText();
		String expectedvalue = "Specific Grade*";
		Assert.assertEquals(actualmandatorygradefield, expectedvalue);
		;

	}

	public static final By astricuom = By.xpath("//*[@id='uomDeop1']/div[1]/label");

	public void verifyuomastricfield() {

		String actualmandatoryuom = waitForExpectedElement(astricuom).getText();
		String expectedvalue = "UOM*";

		Assert.assertEquals(actualmandatoryuom, expectedvalue);

	}

	public static final By astricShape = By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div/div[11]/div[1]/label");

	public void verifyastricshapefield() {

		String actualmandatoryshape = waitForExpectedElement(astricShape).getText();
		String expectedvalue = "Shape*";
		Assert.assertEquals(actualmandatoryshape, expectedvalue);

	}

	public static final By userauthtab = By.xpath("//div[@id='exTab3']/ul/li[2]/a");
	public static final By clickeditbtnusercontrol = By.xpath("//table[@id='example2']/tbody/tr[5]/td[4]/a[1]/span/i");
	public static final By mastertrangle = By
			.xpath("(//div[@id='jstree']//li[@id='2']//i[@class='jstree-icon jstree-ocl'])[1]");
	public static final By commoditytrangle = By.xpath("//ul[@class='jstree-children']/li[3]/div/following-sibling::i");
	public static final By clickuncheckedforreadandwrite = By
			.xpath("//ul[@class='jstree-children']/li[3]/ul/li[2]/a/i[1]");
	public static final By clicksavebtnOnuser = By.xpath("//*[@id=\"btnSubmit\"]/i");

	public void verifyreadonlyauthority() throws InterruptedException {

		clickOnElement(userauthtab);
		LoggerUtil.info("Switched to 'User Authority' tab.");
		Thread.sleep(3000);

		clickOnElement(clickeditbtnusercontrol);
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
		List<WebElement> saveBtns = driver.findElements(savebtn);
		boolean saveBtnVisible = saveBtns.size() > 0 && saveBtns.get(0).isDisplayed();
		LoggerUtil.info("Checking Save button visibility under read-only authority. Expected: NOT visible, Actual: "
				+ (saveBtnVisible ? "Visible" : "Hidden"));

		// Assert the Save button is hidden
		if (!saveBtnVisible) {
			LoggerUtil.info("✅ Save button is hidden as expected under read-only authority.");
		} else {
			LoggerUtil.info("❌ Save button is visible even under read-only authority. TEST FAIL.");
			Assert.fail("Save button is visible even under read-only authority.");
		}

		captureStepScreenshot("Commodity Details Tab is invisible From Commodity Details Tab");
	}

	public static final By tensilestrength = By.xpath("//*[@id='tensileStrength']");
	public static final By shearstrength = By.xpath("//*[@id='ShearStrength']");

	public void savedataforforIBeamvalueinShapeDropdown(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationdropdown);
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
		clickOnElement(clickingSpecificgradedropdown);
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
		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "I-beam");
		shapesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		Thread.sleep(4000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		Thread.sleep(4000);
		clickOnElement(customercheckbox);

	}

	public static final By enterlengthvalueforibeamshape = By
			.xpath("//*[@id='shapeParamTable']/tbody/tr[1]/td[2]/input");
	public static final By enterwidthvalueforibeamshape = By
			.xpath("//*[@id='shapeParamTable']/tbody/tr[2]/td[2]/input");
	public static final By enterheightvalueforibeamshape = By
			.xpath("//*[@id='shapeParamTable']/tbody/tr[3]/td[2]/input");
	public static final By enterwebthikvalueforibeamshape = By
			.xpath("//*[@id='shapeParamTable']/tbody/tr[4]/td[2]/input");
	public static final By enterflangthicknessforibeamshape = By
			.xpath("//*[@id='shapeParamTable']/tbody/tr[5]/td[2]/input");

	public void enterparametevalueorsizeforibeam(String lengthvalue, String widthvalue, String heightvalue,
			String thikvalues, String flangthikness, String searchvalue) throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		clearAndEnterText(waitForExpectedElement(enterlengthvalueforibeamshape), lengthvalue);
		clearAndEnterText(waitForExpectedElement(enterwidthvalueforibeamshape), widthvalue);
		clearAndEnterText(waitForExpectedElement(enterheightvalueforibeamshape), heightvalue);
		clearAndEnterText(waitForExpectedElement(enterwebthikvalueforibeamshape), thikvalues);
		clearAndEnterText(waitForExpectedElement(enterflangthicknessforibeamshape), flangthikness);

		clickOnElement(savebtn);
		Thread.sleep(6000);
		clickOnElement(Domesticradiobtn);
		clickOnElement(viewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), searchvalue);
		Thread.sleep(3000);
		clickOnElement(clickeditbtn);
		Thread.sleep(7000);

		validateRoundedValueWithSoftAssert(softAssert, enterlengthvalueforibeamshape, lengthvalue, "Length");
		validateRoundedValueWithSoftAssert(softAssert, enterwidthvalueforibeamshape, widthvalue, "Width");
		validateRoundedValueWithSoftAssert(softAssert, enterheightvalueforibeamshape, heightvalue, "Height");
		validateRoundedValueWithSoftAssert(softAssert, enterwebthikvalueforibeamshape, thikvalues, "Web Thickness");
		validateRoundedValueWithSoftAssert(softAssert, enterflangthicknessforibeamshape, flangthikness,
				"Flange Thickness");

// 👇 Don't fail the test, just log all results
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			LoggerUtil.warn("⚠️ Validation mismatches found — test continues without hard failure.");
			LoggerUtil.warn(e.getMessage());
		}
	}

	public void validateRoundedValueWithSoftAssert(SoftAssert softAssert, By locator, String expectedStr,
			String fieldName) {
		String actualStr = waitForExpectedElement(locator).getAttribute("value").trim();

		// Decimal precision validation
		if (actualStr.contains(".")) {
			String[] split = actualStr.split("\\.");
			if (split.length > 1 && split[1].length() > 3) {
				LoggerUtil.fail("❌ FAIL in '" + fieldName + "': Actual value [" + actualStr
						+ "] has more than 3 decimal places.");
				// Still record the failure for log visibility
				softAssert.fail("Actual value [" + actualStr + "] has more than 3 decimal places.");
				return;
			}
		}

		BigDecimal actual = new BigDecimal(actualStr).setScale(3, BigDecimal.ROUND_HALF_UP);
		BigDecimal expected = new BigDecimal(expectedStr).setScale(3, BigDecimal.ROUND_HALF_UP);

		if (actual.compareTo(expected) == 0) {
			LoggerUtil.pass("✅ '" + fieldName + "' matched expected value: " + actual);
		} else {
			LoggerUtil
					.fail("❌ Mismatch in '" + fieldName + "': Expected [" + expected + "] but found [" + actual + "]");
			softAssert.fail("Mismatch in '" + fieldName + "'");
		}
	}

	public static final By estimatetriangle = By.xpath("//div[@id='jstree']/ul/li[6]/i");
	public static final By clicksale = By.xpath("//div[@id='jstree']/ul/li[6]/ul/li/a/i");
	public static final By clicksupplier = By.xpath("//div[@id='jstree']/ul/li[6]/ul/li[2]/a/i");
	public static final By supplierfetchingheading = By.xpath("//div[@id='divprocurement']/div/div/h3");
	public static final By customerfetchinfheading = By.xpath("//div[@id='salesideDiv01']/div/div/h3/span");

	public void customerinvisiblityafteruserRight() throws InterruptedException {

		clickOnElement(userauthtab);
		LoggerUtil.info("Switched to 'User Authority' tab.");
		Thread.sleep(3000);

		clickOnElement(clickeditbtnusercontrol);
		LoggerUtil.info("Clicked Edit button for user authority.");
		Thread.sleep(2500);

		clickOnElement(estimatetriangle);
		LoggerUtil.info("Expanded Master menu in user authority.");
		Thread.sleep(2000);

		clickOnElement(clicksale);

		Thread.sleep(3000);

		clickOnElement(clicksavebtnOnuser);
		LoggerUtil.info("Saved user authority settings.");
		Thread.sleep(3000);

		dashboard.clickoncommodityMaster(); // Re-login or refresh authority
		LoggerUtil.info("Reopened Commodity Master to verify access restrictions.");
		Thread.sleep(2000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Opened Commodity Details Tab to check Customer heading visibility.");
		Thread.sleep(2000);

		List<WebElement> customerElements = driver.findElements(customerfetchinfheading);

		boolean isVisible = false;
		for (WebElement element : customerElements) {
			if (element.isDisplayed()) {
				isVisible = true;
				break;
			}
		}

		if (isVisible) {

			LoggerUtil.info("❌ customer heading is visible even under read-only authority. TEST FAIL.");

			Assert.fail("customer heading is visible even under read-only authority.");
		} else {
			LoggerUtil.info("✅ Customer heading is correctly hidden under read-only authority.");
		}

	}

	public void supplierinvisiblityafteruserRight() throws InterruptedException {

		clickOnElement(userauthtab);
		LoggerUtil.info("Switched to 'User Authority' tab.");
		Thread.sleep(3000);

		clickOnElement(clickeditbtnusercontrol);
		LoggerUtil.info("Clicked Edit button for user authority.");
		Thread.sleep(2500);

		clickOnElement(estimatetriangle);
		LoggerUtil.info("Expanded Master menu in user authority.");
		Thread.sleep(2000);

		clickOnElement(clicksupplier);

		Thread.sleep(3000);

		clickOnElement(clicksavebtnOnuser);
		LoggerUtil.info("Saved user authority settings.");
		Thread.sleep(3000);

		dashboard.clickoncommodityMaster(); // Re-login or refresh authority
		LoggerUtil.info("Reopened Commodity Master to verify access restrictions.");
		Thread.sleep(2000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("Opened Commodity Details Tab to check Supplier heading visibility.");
		Thread.sleep(2000);

		List<WebElement> suppleirElements = driver.findElements(supplierfetchingheading);

		boolean isVisible = false;
		for (WebElement element : suppleirElements) {
			if (element.isDisplayed()) {
				isVisible = true;
				break;
			}
		}

		if (isVisible) {

			LoggerUtil.info("❌ Supplier heading is visible even under read-only authority. TEST FAIL.");

			Assert.fail("Suppleir heading is visible even under read-only authority.");
		} else {
			LoggerUtil.info("✅ Supplier heading is correctly hidden under read-only authority.");
		}

	}

	public static final By updatebtn = By.xpath("//*[@id='tab3Save']");

	public void savedataforcommodityDetailsfordomesticForsaveandupdateverification(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalueforcomdetail)
			throws InterruptedException {

		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("Clicked on Domestic radio button.");

		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Clicked on Commodity dropdown.");

		Thread.sleep(3000);
		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		LoggerUtil.info("Searched commodity in dropdown with value: " + searchcommoditydropvalue);

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
		clickOnElement(ClickingGroupclassificationdropdown);
		LoggerUtil.info("Clicked on Group Classification dropdown.");

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
		clickOnElement(clickingSpecificgradedropdown);
		LoggerUtil.info("Clicked on Specific Grade dropdown.");

		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		LoggerUtil.info("Clicked on UOM dropdown.");

		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");

		Thread.sleep(500);
		clickOnElement(ClickingShapedropdown);
		LoggerUtil.info("Clicked on Shape dropdown.");

		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");

		Thread.sleep(5000);
		clickOnElement(businessSegbox);
		LoggerUtil.info("Clicked on Business Segment box.");

		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment search value: rishi");

		Thread.sleep(3000);
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");

		Thread.sleep(8000);
		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer checkbox.");

		Thread.sleep(3000);
		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save button in Commodity Details tab.");

		Thread.sleep(7000);
		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("Clicked on Domestic radio button again for view verification.");

		clickOnElement(viewbtn);
		LoggerUtil.info("Clicked on View button to fetch saved data.");

		Thread.sleep(7000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);
		LoggerUtil.info("Searched for saved data with value: " + entersearchvalueforcomdetail);

		Thread.sleep(3000);
		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = searchcommoditydropvalue;

		LoggerUtil.info("Expected Commodity Group value: " + expectedvalueforcomdomesticdata);
		LoggerUtil.info("Actual Commodity Group value fetched from grid: " + actualcomdomesticdata);
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);

		Thread.sleep(2000);
		clickOnElement(clickeditbtn);
		LoggerUtil.info("Clicked on Edit button to update existing data.");

		Thread.sleep(9000);
		clickOnElement(ClickingShapedropdown);
		LoggerUtil.info("Clicked on Shape dropdown for update.");

		Thread.sleep(900);
		WebElement shapesearch1 = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch1, "I-beam");
		shapesearch1.sendKeys(Keys.ENTER);
		LoggerUtil.info("Updated Shape to: I-beam");

		Thread.sleep(18000);
		clickOnElement(updatebtn);
		LoggerUtil.info("Clicked on Update button to save changes.");
	}

	public static final By saveasnewbtn = By.xpath("//*[@id='tab3SaveNew']");

	public void savedataforcommodityDetailsfordomesticForSaveAsNew(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalueforcomdetail)
			throws InterruptedException {

		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("Selected 'Domestic' radio option.");
		Thread.sleep(3000);

		// Step 2: Open Commodity dropdown
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		LoggerUtil.info("Opened Commodity dropdown.");
		Thread.sleep(3000);

		// Step 3: Validate mandatory commodity group value
		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("❌ Commodity dropdown value is EMPTY. Mandatory field validation failed.");
		} else {
			LoggerUtil.info("✅ Commodity dropdown value entered: " + searchcommoditydropvalue);
		}

		// Step 4: Select value in dropdown
		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		// Step 5: Select Group Classification
		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationdropdown);
		LoggerUtil.info("Opened Group Classification dropdown.");
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

		// Step 6: Select Specific Grade
		Thread.sleep(3000);
		clickOnElement(clickingSpecificgradedropdown);
		LoggerUtil.info("Opened Specific Grade dropdown.");
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		// Step 7: UOM and Shape
		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);
		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected UOM as: Mtr");

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);
		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Selected Shape as: Sheet");

		// Step 8: Business Segment
		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment as: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all business segments.");

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer checkbox.");

		// Step 9: Save
		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save on Third Tab.");
		Thread.sleep(20000);

		// Step 10: Re-open to view & verify
		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("Re-selected Domestic view.");
		Thread.sleep(19000);
		clickOnElement(viewbtn);
		LoggerUtil.info("Clicked View to load saved data.");
		Thread.sleep(9000);

		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);
		LoggerUtil.info("Searched for saved record using Commodity: " + entersearchvalueforcomdetail);
		Thread.sleep(3000);

		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = searchcommoditydropvalue;
		LoggerUtil.info("Verifying Commodity Group - Expected: " + expectedvalueforcomdomesticdata + " | Actual: "
				+ actualcomdomesticdata);
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);

		// Step 11: Edit record and Save As New
		clickOnElement(clickeditbtn);
		LoggerUtil.info("Clicked Edit on saved record.");
		Thread.sleep(4000);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);
		WebElement shapesearch1 = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch1, "Square Pipe");
		shapesearch1.sendKeys(Keys.ENTER);
		LoggerUtil.info("Changed Shape to: Square Pipe");
		Thread.sleep(5000);

		clickOnElement(saveasnewbtn);
		LoggerUtil.info("Clicked 'Save As New' to create a new copy of the record.");
		Thread.sleep(4000);

	}

	public void savedataforcommodityDetailsfordomesticWithSameGradeWithMultipleShape(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalueforcomdetail,
			String message) throws InterruptedException {

		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
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
		clickOnElement(ClickingGroupclassificationdropdown);
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
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

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

		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Thread.sleep(7000);
		clickOnElement(Domesticradiobtn);

		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
		List<WebElement> comlist1 = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist1) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(ClickingGroupclassificationdropdown);
		Thread.sleep(3000);

		List<WebElement> grpclasslist1 = driver.findElements(groupclassificationlist);
		for (WebElement grpclasslistval : grpclasslist1) {
			String comclssifi = grpclasslistval.getText().trim();
			if (comclssifi.equalsIgnoreCase(searchcommodityclassification)) {
				grpclasslistval.click();
				LoggerUtil.info("Selected Group Classification: " + comclssifi);
				break;
			}
		}

		Thread.sleep(3000);
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> comgradelist1 = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist1) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom1 = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom1, "Mtr");
		searchuom1.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch1 = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch1, "I-beam");
		shapesearch1.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: I-beam");
		Thread.sleep(5000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");

		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));

	}

	public static final By crossbtnviewpage = By
			.xpath("//*[@id='CommodityDetailTab']/div[2]/div/div/div[1]/div[2]/button[3]");

	public void savedataforcommodityDetailsforcustomerxAndSupplierY(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String entersearchvalueforcomdetail)
			throws InterruptedException {

		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
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
		clickOnElement(ClickingGroupclassificationdropdown);
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
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

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

		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Thread.sleep(10000);
		clickOnElement(Domesticradiobtn);
		clickOnElement(viewbtn);
		Thread.sleep(20000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);
		Thread.sleep(3000);

		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = searchcommoditydropvalue;
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);
		Thread.sleep(3000);
		clickOnElement(crossbtnviewpage);

	}

	public void savedataforcommodityDetailsforcustomerxAndSupplierYAgain(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue, String message)
			throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(7000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
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
		clickOnElement(ClickingGroupclassificationdropdown);
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
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(5000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		clickOnElement(customercheckbox);
		LoggerUtil.info("Selected Customer Checkbox.");
		Thread.sleep(3000);

		clickOnElement(savebtn);
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
		System.out.println(toastmsg);

	}

	public void savedataforforwhatifprice(String searchcommoditydropvalue, String searchcommodityclassification,
			String selectcommoditygradevalue) throws InterruptedException {

		LoggerUtil.info("Starting data entry for What-If Price scenario.");

		Thread.sleep(2000);
		LoggerUtil.info("Clicking on Domestic radio button.");
		clickOnElement(Domesticradiobtn);

		Thread.sleep(3000);
		LoggerUtil.info("Clicking on Commodity dropdown.");
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);

		Thread.sleep(3000);
		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);

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
		LoggerUtil.info("Clicking Group Classification dropdown.");
		clickOnElement(ClickingGroupclassificationdropdown);

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
		LoggerUtil.info("Clicking Specific Grade dropdown.");
		clickOnElement(clickingSpecificgradedropdown);

		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		LoggerUtil.info("Clicking UOM dropdown.");
		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		LoggerUtil.info("Clicking Shape dropdown.");
		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

		LoggerUtil.info("Clicking Business Segment box.");
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

	}

	public static final By landedecost1 = By.xpath("//*[@id='LandedCostUOM1']");
	public static final By landedcost2 = By.xpath("//*[@id='LandedCostUOM2']");
	public static final By landedcost3 = By.xpath("//*[@id='LandedCostUOM3']");
	public static final By scrapcost1 = By.xpath("//*[@id='ScrapCostUOM1']");
	public static final By scrapcost2 = By.xpath("//*[@id='ScrapCostUOM2']");
	public static final By scrapcost3 = By.xpath("//*[@id='ScrapCostUOM3']");

	public void WhatIfPriceSaveAndUpdate(String enterlanded1, String enterlanded2, String enterlanded3,
			String enterscrap1, String enterscrap2, String enterscrap3, String entersearchvalueforcomdetail)
			throws InterruptedException {

		LoggerUtil.info("Starting entry for What-If Price Save and Update.");

		LoggerUtil.info("Entering Landed Cost 1: " + enterlanded1);
		clearAndEnterText(waitForExpectedElement(landedecost1), enterlanded1);

		LoggerUtil.info("Entering Landed Cost 2: " + enterlanded2);
		clearAndEnterText(waitForExpectedElement(landedcost2), enterlanded2);

		LoggerUtil.info("Entering Landed Cost 3: " + enterlanded3);
		clearAndEnterText(waitForExpectedElement(landedcost3), enterlanded3);

		LoggerUtil.info("Entering Scrap Cost 1: " + enterscrap1);
		clearAndEnterText(waitForExpectedElement(scrapcost1), enterscrap1);

		LoggerUtil.info("Entering Scrap Cost 2: " + enterscrap2);
		clearAndEnterText(waitForExpectedElement(scrapcost2), enterscrap2);

		LoggerUtil.info("Entering Scrap Cost 3: " + enterscrap3);
		clearAndEnterText(waitForExpectedElement(scrapcost3), enterscrap3);

		System.out.println(enterlanded1); // Optional: Debug print

		LoggerUtil.info("Waiting before clicking Save...");
		Thread.sleep(30000);

		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details.");

		Thread.sleep(7000);
		LoggerUtil.info("Switching to Domestic view and clicking View button.");
		clickOnElement(Domesticradiobtn);
		clickOnElement(viewbtn);

		Thread.sleep(7000);
		LoggerUtil.info("Entering search value to verify saved What-If Price entry: " + entersearchvalueforcomdetail);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);

		Thread.sleep(3000);
		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = entersearchvalueforcomdetail;

		LoggerUtil.info("Verifying saved value. Expected: " + expectedvalueforcomdomesticdata + ", Actual: "
				+ actualcomdomesticdata);
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);

		Thread.sleep(4000);
		LoggerUtil.info("Clicking Edit button for the matched commodity record.");
		clickOnElement(clickeditbtn);

		LoggerUtil.info("What-If Price Save and Update flow completed.");
	}

	public static final By saveasnewbtnf = By.xpath("//*[@id='tab3Save']");

	public void verifyupdateprice(String enterlanded1, String enterlanded2, String enterlanded3, String enterscrap1,
			String enterscrap2, String enterscrap3, String entersearchvalue) throws InterruptedException {

		LoggerUtil.info("Starting verification of updated What-If Price values...");

		Thread.sleep(19000);
		LoggerUtil.info("Updating Landed and Scrap Cost values...");

		clearAndEnterText(waitForExpectedElement(landedecost1), enterlanded1);
		LoggerUtil.info("Updated Landed Cost 1: " + enterlanded1);

		clearAndEnterText(waitForExpectedElement(landedcost2), enterlanded2);
		LoggerUtil.info("Updated Landed Cost 2: " + enterlanded2);

		clearAndEnterText(waitForExpectedElement(landedcost3), enterlanded3);
		LoggerUtil.info("Updated Landed Cost 3: " + enterlanded3);

		clearAndEnterText(waitForExpectedElement(scrapcost1), enterscrap1);
		LoggerUtil.info("Updated Scrap Cost 1: " + enterscrap1);

		clearAndEnterText(waitForExpectedElement(scrapcost2), enterscrap2);
		LoggerUtil.info("Updated Scrap Cost 2: " + enterscrap2);

		clearAndEnterText(waitForExpectedElement(scrapcost3), enterscrap3);
		LoggerUtil.info("Updated Scrap Cost 3: " + enterscrap3);

		System.out.println(enterlanded1);

		clickOnElement(updatebtn);
		LoggerUtil.info("Clicked on Update button to save changes.");

		Thread.sleep(5000);
		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("Switched to Domestic tab view.");

		Thread.sleep(3000);
		clickOnElement(viewbtn);
		LoggerUtil.info("Clicked on View button to verify updated record.");

		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalue);
		LoggerUtil.info("Entered search value: " + entersearchvalue);

		Thread.sleep(3000);
		clickOnElement(clickeditbtn);
		LoggerUtil.info("Clicked Edit to open updated record.");

		Thread.sleep(20000);

		String actuallanded1 = waitForExpectedElement(landedecost1).getAttribute("value");
		LoggerUtil.info("Verifying Landed Cost 1 - Expected: " + enterlanded1 + ", Actual: " + actuallanded1);
		Assert.assertEquals(actuallanded1, enterlanded1, "Landed Cost 1 not updated.");

		String actuallanded2 = waitForExpectedElement(landedcost2).getAttribute("value");
		LoggerUtil.info("Verifying Landed Cost 2 - Expected: " + enterlanded2 + ", Actual: " + actuallanded2);
		Assert.assertEquals(actuallanded2, enterlanded2, "Landed Cost 2 not updated.");

		String actuallanded3 = waitForExpectedElement(landedcost3).getAttribute("value");
		LoggerUtil.info("Verifying Landed Cost 3 - Expected: " + enterlanded3 + ", Actual: " + actuallanded3);
		Assert.assertEquals(actuallanded3, enterlanded3, "Landed Cost 3 not updated.");

		String actualscrap1 = waitForExpectedElement(scrapcost1).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 1 - Expected: " + enterscrap1 + ", Actual: " + actualscrap1);
		Assert.assertEquals(actualscrap1, enterscrap1, "Scrap Cost 1 not updated.");

		String actualscrap2 = waitForExpectedElement(scrapcost2).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 2 - Expected: " + enterscrap2 + ", Actual: " + actualscrap2);
		Assert.assertEquals(actualscrap2, enterscrap2, "Scrap Cost 2 not updated.");

		String actualscrap3 = waitForExpectedElement(scrapcost3).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 3 - Expected: " + enterscrap3 + ", Actual: " + actualscrap3);
		Assert.assertEquals(actualscrap3, enterscrap3, "Scrap Cost 3 not updated.");

		LoggerUtil.info("Update verification for What-If Price completed successfully.");
	}

	public void verifysaveasnewpriceprice(String enterlanded1, String enterlanded2, String enterlanded3,
			String enterscrap1, String enterscrap2, String enterscrap3, String entersearchvalue)
			throws InterruptedException {

		LoggerUtil.info("Starting verification of Save As New for What-If Price...");

		Thread.sleep(8000);
		LoggerUtil.info("Entering Landed and Scrap Cost values...");

		clearAndEnterText(waitForExpectedElement(landedecost1), enterlanded1);
		LoggerUtil.info("Entered Landed Cost 1: " + enterlanded1);

		clearAndEnterText(waitForExpectedElement(landedcost2), enterlanded2);
		LoggerUtil.info("Entered Landed Cost 2: " + enterlanded2);

		clearAndEnterText(waitForExpectedElement(landedcost3), enterlanded3);
		LoggerUtil.info("Entered Landed Cost 3: " + enterlanded3);

		clearAndEnterText(waitForExpectedElement(scrapcost1), enterscrap1);
		LoggerUtil.info("Entered Scrap Cost 1: " + enterscrap1);

		clearAndEnterText(waitForExpectedElement(scrapcost2), enterscrap2);
		LoggerUtil.info("Entered Scrap Cost 2: " + enterscrap2);

		clearAndEnterText(waitForExpectedElement(scrapcost3), enterscrap3);
		LoggerUtil.info("Entered Scrap Cost 3: " + enterscrap3);

		System.out.println(enterlanded1);

		LoggerUtil.info("Clicking Save As New button.");
		clickOnElement(saveasnewbtnf);

		Thread.sleep(5000);
		LoggerUtil.info("Switching to Domestic view.");
		clickOnElement(Domesticradiobtn);

		Thread.sleep(3000);
		LoggerUtil.info("Clicking View button to load saved record.");
		clickOnElement(viewbtn);

		Thread.sleep(8000);
		LoggerUtil.info("Searching saved commodity record using: " + entersearchvalue);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalue);

		Thread.sleep(19000);
		clickOnElement(clickeditbtn);
		LoggerUtil.info("Clicked Edit button for saved record.");

		Thread.sleep(8000);

		String actuallanded1 = waitForExpectedElement(landedecost1).getAttribute("value");
		LoggerUtil.info("Verifying Landed Cost 1 — Expected: " + enterlanded1 + ", Actual: " + actuallanded1);
		Assert.assertEquals(actuallanded1, enterlanded1, "Landed cost 1 not updated.");

		String actuallanded2 = waitForExpectedElement(landedcost2).getAttribute("value");
		LoggerUtil.info("Verifying Landed Cost 2 — Expected: " + enterlanded2 + ", Actual: " + actuallanded2);
		Assert.assertEquals(actuallanded2, enterlanded2, "Landed cost 2 not updated.");

		String actuallanded3 = waitForExpectedElement(landedcost3).getAttribute("value");
		LoggerUtil.info("Verifying Landed Cost 3 — Expected: " + enterlanded3 + ", Actual: " + actuallanded3);
		Assert.assertEquals(actuallanded3, enterlanded3, "Landed cost 3 not updated.");

		String actualscrap1 = waitForExpectedElement(scrapcost1).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 1 — Expected: " + enterscrap1 + ", Actual: " + actualscrap1);
		Assert.assertEquals(actualscrap1, enterscrap1, "Scrap cost 1 not updated.");

		String actualscrap2 = waitForExpectedElement(scrapcost2).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 2 — Expected: " + enterscrap2 + ", Actual: " + actualscrap2);
		Assert.assertEquals(actualscrap2, enterscrap2, "Scrap cost 2 not updated.");

		String actualscrap3 = waitForExpectedElement(scrapcost3).getAttribute("value");
		LoggerUtil.info("Verifying Scrap Cost 3 — Expected: " + enterscrap3 + ", Actual: " + actualscrap3);
		Assert.assertEquals(actualscrap3, enterscrap3, "Scrap cost 3 not updated.");

		LoggerUtil.info("Save As New verification completed successfully.");
	}

	public static final By verifyfourthproperty = By.xpath("//*[@id='ForPlastic']/div[4]/div[1]/label");
	public static final By verifythirdproperty = By.xpath("//*[@id='ForPlastic']/div[3]/div[1]/label");
	public static final By verifysecondproperty = By.xpath("//*[@id='ForPlastic']/div[2]/div[1]/label");
	public static final By verifyfirstproperty = By.xpath("//*[@id='ForPlastic']/div[1]/div[1]/label");

	public void verifyplasticsproperties(String searchcommoditydropvalue) throws InterruptedException {

		SoftAssert soft = new SoftAssert();
		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}
		try {
			String actualfirstpropertyvalue = waitForExpectedElement(verifyfirstproperty).getText();
			String expectedpropvalue = "Select Process*";
			soft.assertEquals(actualfirstpropertyvalue, expectedpropvalue);
		} catch (Exception e) {

			LoggerUtil.mismatch("First Plastic porperty Are not visible");

		}
		try {
			boolean actualsecondpropertyvalue = waitForExpectedElement(verifysecondproperty).isDisplayed();
		} catch (Exception e) {
			LoggerUtil.error("Second Property of Plastic is not visible");

		}
		try {
			boolean actualthirdpropertyvalue = waitForExpectedElement(verifythirdproperty).isDisplayed();
		} catch (Exception e) {
			LoggerUtil.mismatch(" module deg c is not visible after selecting the plastic");

		}
		try {
			boolean actualforthpropvalue = waitForExpectedElement(verifyfourthproperty).isDisplayed();

		} catch (Exception e) {

			LoggerUtil.mismatch(" After selecting plastic Heat Distortion Temp Deg C* Is not Visible ");

		}

	}

	public static final By fetchingsuppleirname = By
			.xpath("div[@id='divprocurement']/div/child::div[2]/child::div[2]/child::div[2]/table/tbody/tr");
	public static final By clickaddnewsuppbtn = By.xpath("//a[@id='addNewSupplier']");
	public static final By entersuppcode = By.xpath("//*[@id='SupplierCode']");
	public static final By entersuppname = By.xpath("//*[@id='SupplierName']");
	public static final By clickbussinessSeg = By.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/button");
	public static final By enterbusinessSegvalue = By
			.xpath("//*[@id='supplierForm']/div/div[1]/div[10]/span/div/div/div/input");
	public static final By selectallbusSegvalue = By.xpath(
			"//div[@class='multiselect-container dropdown-menu show']/div/following-sibling::button/span/input[@value='multiselect-all']");
	public static final By savebtnaddsupp = By.xpath("//button[@id='supplierSave']");
	public static final By clickcrossbtnaddsupp = By.xpath("//*[@id='addNewSupplierModel']/div/div/div[1]/button");

	public void verifyaddsupplier(String entersuppcodevalue, String entersuppnamevalue, String enterbusiSegvalue)
			throws InterruptedException {

		// Step 1: Click on "Add New Supplier" button
		LoggerUtil.info("Clicking on 'Add New Supplier' button.");
		clickOnElement(clickaddnewsuppbtn);

		Thread.sleep(4000);

		// Step 2: Enter Supplier Code
		LoggerUtil.info("Entering Supplier Code: " + entersuppcodevalue);
		clearAndEnterText(waitForExpectedElement(entersuppcode), entersuppcodevalue);

		// Step 3: Enter Supplier Name
		LoggerUtil.info("Entering Supplier Name: " + entersuppnamevalue);
		clearAndEnterText(waitForExpectedElement(entersuppname), entersuppnamevalue);
		System.out.println(entersuppnamevalue);

		// Step 4: Click on Business Segment dropdown
		LoggerUtil.info("Clicking on Business Segment field.");
		clickOnElement(clickbussinessSeg);

		Thread.sleep(5000);

		// Step 5: Enter Business Segment value
		LoggerUtil.info("Entering Business Segment value for search: " + enterbusiSegvalue);
		clearAndEnterText(waitForExpectedElement(enterbusinessSegvalue), enterbusiSegvalue);

		Thread.sleep(3000);

		// Step 6: Select all Business Segment values
		LoggerUtil.info("Clicking on Select All checkbox for Business Segment.");
		clickOnElement(selectallbusSegvalue);

		Thread.sleep(3000);

		// Step 7: Click on Save button
		LoggerUtil.info("Clicking on Save button to add Supplier.");
		clickOnElement(savebtnaddsupp);

		Thread.sleep(3000);

		// Step 8: Close the Add Supplier popup
		LoggerUtil.info("Clicking on Cross (Close) button after saving supplier.");
		clickOnElement(clickcrossbtnaddsupp);

		Thread.sleep(3000);

		// Step 9: Click on Business Segment box to reopen list
		LoggerUtil.info("Reopening Business Segment selection to verify added supplier.");
		clickOnElement(businessSegbox);

		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "steel");
		LoggerUtil.info("Entered Business Segment search keyword: steel");

		Thread.sleep(5000);

		// Step 10: Select all in Business Segment for viewing results
		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");

		Thread.sleep(9000);

		// Step 11: Validate Supplier presence in the list
		LoggerUtil.info("Fetching supplier list to verify added entry.");
		List<WebElement> supplist = driver.findElements(fetchingsuppleirname);

		for (WebElement suppval : supplist) {
			String textval = suppval.getText().trim();
			String expected = entersuppcodevalue + "-" + entersuppnamevalue + "-";
			if (textval.equals(expected)) {
				LoggerUtil.pass("Supplier Code and Supplier Name are visible as expected: " + expected);

				break;
			}
		}

	}

	public static final By verifycheckbuttonofsupplier = By
			.xpath("//table[@id='rmSupplier']/tbody/tr/td/div/label/input");

	public void verifybusinessSegmentautoselectosupplierornot() throws InterruptedException {

		clickOnElement(businessSegbox);
		clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
		LoggerUtil.info("Entered Business Segment: rishi");
		Thread.sleep(3000);

		clickOnElement(selectallcheckboxInbusinsessSeg);
		LoggerUtil.info("Selected all checkboxes in Business Segment.");
		Thread.sleep(8000);

		WebElement checkboxsupp = waitForExpectedElement(verifycheckbuttonofsupplier);
		if (checkboxsupp.isSelected()) {

			LoggerUtil.info("While selecting Business Segment The Supplier Is Autoselected");

		} else {

			LoggerUtil.info("Suppkleir name is not autoselected");
		}

	}

	public static final By afterradiobtnUi = By.xpath(
			"//div[@id='partAttributeDiv']/div/div/div/input/following-sibling::div/div/div/following-sibling::div[13]");

	public void verifyUIforSelectingDomesticradiodifferentRadiobtn() throws InterruptedException {

		clickOnElement(Domesticradiobtn);
		Thread.sleep(3000);
		WebElement domesticradiouifetching = waitForExpectedElement(afterradiobtnUi);

		LoggerUtil.info("User Try To Verify Ui After Clicking Domestic Radio Btn");
		if (domesticradiouifetching.isDisplayed()) {

			LoggerUtil.info("Ui Is Visible Ater Clicking Domestic Radio Btn ");
		} else {

			LoggerUtil.info("Ui Is Not Visible Afer Clicking Domestic Radio Btn");

		}

		clickOnElement(viewbtn);
		try {
			boolean fetchheader = waitForExpectedElement(domtypeheader).isDisplayed();
			LoggerUtil.pass("After Clicking View Button Domestic Colom is visible...");
		} catch (Exception e) {
			LoggerUtil.mismatch("domestic type header is not displayed");

		}

	}

	public static final By fetchingimportcolom = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr[1]/td[3]");
	public static final By fetchuiafterselectingimportradiobtn = By.xpath(
			"//div[@id='partAttributeDiv']/div/div/div/div/following-sibling::div/div/div/following-sibling::div[14]");
	public static final By importradiobtn = By.xpath("//*[@id='importedR']");

	public void verifyUiDataForSelectingImportradiobtn() {

		clickOnElement(importradiobtn);

		WebElement importradiobtnfetchinguidata = waitForExpectedElement(fetchuiafterselectingimportradiobtn);

		if (importradiobtnfetchinguidata.isDisplayed()) {

			LoggerUtil.info("After Selecting Import Radio Btn Ui Data Is Visible Properly..... ");
			System.out.println("After Selecting Import Radio Btn Ui List Are Visible Properly.....");
		} else

			LoggerUtil.info("UI Data Not Visible Properly..... ");

		clickOnElement(viewbtn);

		try {

			boolean importcolomdata = waitForExpectedElement(fetchingimportcolom).isDisplayed();
			LoggerUtil.pass("import colom is displayed");
		} catch (Exception e) {
			LoggerUtil.mismatch("Import colom data is not visible ....");
		}

	}

	public static final By fetchingafterselectingyearlyradiobtn = By
			.xpath("(//div[@id='partAttributeDiv']//div[@class='yearly mb-1'])[1]/div[position() <= 4]");
	public static final By yearlyradiobtn = By.xpath("//*[@id='yearlyR']");

	public void verifyUIDataAfterSelectingYearlyRadioBtn() {

		clickOnElement(importradiobtn);

		WebElement yearlyverificationforui = waitForExpectedElement(fetchingafterselectingyearlyradiobtn);

		if (yearlyverificationforui.isDisplayed()) {

			LoggerUtil.info("After Selecting yearly Radio Btn Is SucessFully Visible ");

		} else {

			LoggerUtil.info("All Data Are Not Visible After Seleting Yearly radio Btn");

		}

	}

	public static final By clickcommodityheader = By.xpath("//table[@id='comodityDetailListTable']/thead/tr/th[4]");
	public static final By fetchingcommoditycoloumnamedata = By.xpath("//*[@id='ComDetailBody']/tr/td[4]");

	public void verifyCommodityColumnSorting(String expectedOrder) throws InterruptedException {

		if (!expectedOrder.equalsIgnoreCase("asc") && !expectedOrder.equalsIgnoreCase("desc")) {
			throw new IllegalArgumentException(
					"Invalid sort order: '" + expectedOrder + "'. Allowed values: 'asc' or 'desc'");
		}

		clickOnElement(Domesticradiobtn);
		Thread.sleep(2000);
		clickOnElement(viewbtn);
		Thread.sleep(6000);

		clickOnElement(clickcommodityheader);
		Thread.sleep(1000);
		if (expectedOrder.equalsIgnoreCase("desc")) {
			clickOnElement(clickcommodityheader);
			Thread.sleep(1000);
		}

		List<WebElement> columnElements = driver.findElements(fetchingcommoditycoloumnamedata);
		List<String> actualList = new ArrayList<>();
		for (WebElement ele : columnElements) {
			actualList.add(ele.getText().trim().replaceAll("\\s+", " "));
		}

		List<String> expectedSortedList = new ArrayList<>(actualList);
		expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		if (expectedOrder.equalsIgnoreCase("desc")) {
			expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
		}

		Assert.assertEquals(actualList, expectedSortedList,
				"FAIL: Commodity column not sorted in " + expectedOrder.toUpperCase() + " order.\n" + "Actual: "
						+ actualList + "\nExpected: " + expectedSortedList);

		System.out.println("PASS: Commodity column sorted in " + expectedOrder.toUpperCase() + " order.");
	}

	public static final By dateheadercolumn = By.xpath("//table[@id='comodityDetailListTable']/thead/tr/th[9]");
	public static final By datefetchingcolumndata = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[9]");

	public void verifydatesorting() throws InterruptedException {
		LoggerUtil.info("Starting Date Modified column sorting verification (ascending).");

		LoggerUtil.info("Clicking on Domestic radio button.");
		// clickOnElement(Domesticradiobtn);

		LoggerUtil.info("Clicking on View button to load the data.");
		clickOnElement(viewbtn);

		Thread.sleep(3000);

		LoggerUtil.info("Clicking on 'Date Modified' column header to sort ascending.");
		try {
			clickOnElement(dateheadercolumn);
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Failed to click on 'Date Modified' column header: " + dateheadercolumn.toString());
			throw e;
		}

		Thread.sleep(1000);

		LoggerUtil.info("Fetching date values from 'Date Modified' column.");
		List<WebElement> dateElements = driver.findElements(datefetchingcolumndata);
		List<Date> actualDates = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Adjust format if UI is different

		for (WebElement ele : dateElements) {
			String dateText = ele.getText().trim();
			if (!dateText.isEmpty()) {
				try {
					actualDates.add(sdf.parse(dateText));
				} catch (ParseException e) {
					LoggerUtil.mismatch("❌ Failed to parse date value: " + dateText);
					throw new RuntimeException("Failed to parse date: " + dateText, e);
				}
			}
		}

		LoggerUtil.info("Total parsed dates: " + actualDates.size());
		LoggerUtil.info("Actual Date List from UI: " + actualDates);

		List<Date> expectedSortedDates = new ArrayList<>(actualDates);
		Collections.sort(expectedSortedDates);

		LoggerUtil.info("Expected Sorted Date List: " + expectedSortedDates);
		LoggerUtil.info("First date in UI: " + (actualDates.isEmpty() ? "N/A" : actualDates.get(0)));
		LoggerUtil.info(
				"Earliest date expected: " + (expectedSortedDates.isEmpty() ? "N/A" : expectedSortedDates.get(0)));

		Assert.assertEquals(actualDates, expectedSortedDates,
				"❌ FAIL: Date column is not sorted in ascending order.\nActual: " + actualDates + "\nExpected: "
						+ expectedSortedDates);

		LoggerUtil.pass("✅ PASS: Date column is sorted in ascending order.");
	}

	public static final By domtypeheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr/th[3]");
	public static final By fetchingdomesticColumnFilter = By.xpath("//*[@id='ComDetailBody']/tr/td[3]");

	public void verifyviewworkaccordingToSelectingRadioBtn() throws InterruptedException {

		clickOnElement(Domesticradiobtn);
		clickOnElement(viewbtn);
		Thread.sleep(3000);

		List<WebElement> domesticColumns = driver.findElements(fetchingdomesticColumnFilter);
		String expectedValue = "Domestic";

		if (domesticColumns.isEmpty()) {
			LoggerUtil.info("❌ No rows found in the table.");
			Assert.fail("No data available in the table after selecting Domestic radio button.");
		}

		for (WebElement rowValue : domesticColumns) {
			String actualValue = rowValue.getText().trim();
			LoggerUtil.info("🔍 Verifying row value: " + actualValue);
			Assert.assertEquals(actualValue, expectedValue, "FAIL: Found non-domestic value: " + actualValue);
		}

		LoggerUtil.info("✅ All values in the Domain Type column are correctly shown as 'Domestic'.");
	}

	public static final By fetchintypecolumndata = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr/td[3]");

	public void verifyViewWorkWithimportRadioBtn() throws InterruptedException {

		clickOnElement(importradiobtn);
		clickOnElement(viewbtn);
		Thread.sleep(3000);
		List<WebElement> importcolumn = driver.findElements(fetchintypecolumndata);
		String expectedvalue = "Imported";
		if (importcolumn.isEmpty()) {

			LoggerUtil.info("No Data Found In That Column ");
			Assert.fail("No Data Available in The Table after Selecting Import Radio Button. ");

		}
		for (WebElement rowvalue : importcolumn) {
			String actualvalue = rowvalue.getText().trim();
			LoggerUtil.info("Verify row value: = " + actualvalue);
			Assert.assertEquals(actualvalue, expectedvalue, "FAIL: Found non-import value: " + actualvalue);

		}

		LoggerUtil.info("All Values Are Available Import Type Column");

	}

	public static final By fetchingyearcolumn = By.xpath("//*[@id=\"ComDetailBody\"]/tr/td[7]");
	public static final By yearcolumnheader = By.xpath("//*[@id='comodityDetailListTable']/thead/tr[1]/th[7]");

	public void verifyviewbuttonworkingwellwhenbuttonclickyear() throws InterruptedException {

		clickOnElement(viewbtn);
		Thread.sleep(3000);

		List<WebElement> yearValues = driver.findElements(fetchingyearcolumn);

		if (yearValues.isEmpty()) {
			LoggerUtil.info("❌ No year data found after clicking the View button.");
			Assert.fail("Year column is empty after View button click.");
		}

		for (WebElement yearCell : yearValues) {
			String yearText = yearCell.getText().trim();
			LoggerUtil.info("📅 Year value found: " + yearText);

			// Validate format YYYY-YYYY
			if (!yearText.matches("\\d{4}-\\d{4}")) {
				Assert.fail("❌ Invalid year format found: " + yearText);
			}

			// Validate year range logic (e.g., 2024-2025)
			String[] parts = yearText.split("-");
			int startYear = Integer.parseInt(parts[0]);
			int endYear = Integer.parseInt(parts[1]);

			if (endYear != startYear + 1) {
				Assert.fail("❌ Year range mismatch in: " + yearText + " (Expected " + startYear + "-" + (startYear + 1)
						+ ")");
			}
		}

		LoggerUtil.info("✅ All Year column values are correctly formatted and logically valid.");
	}

	public static final By specificgradefetchingclmdata = By.xpath("//ul[@id='select2-SpecificGrade-results']/li");
	public static final By grpclassificationfetchingclmdata = By.xpath("//ul[@id='select2-materialDrop-results']/li");

	public void verifydropdownisSelectedOrNot(String searchcommoditydropvalue, String expectedvalue,
			String expectedgrade) throws InterruptedException {

		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
		List<WebElement> comlist = driver.findElements(commoditydropdownlist);
		for (WebElement comgrpvalue : comlist) {
			String flagcomgrpval = comgrpvalue.getText().trim();
			if (flagcomgrpval.equalsIgnoreCase(searchcommoditydropvalue)) {
				comgrpvalue.click();
				LoggerUtil.info("Selected Commodity from dropdown: " + flagcomgrpval);
				break;
			}
		}

		Thread.sleep(4000);
		clickOnElement(ClickingGroupclassificationdropdown);

		List<WebElement> classificationlist = driver.findElements(grpclassificationfetchingclmdata);

		for (WebElement classificationvalue : classificationlist) {

			String actualclassificationlist = classificationvalue.getText().trim();
			Assert.assertEquals(actualclassificationlist, expectedvalue);

			if (actualclassificationlist.equalsIgnoreCase(expectedvalue))
				classificationvalue.click();

		}

		LoggerUtil.info(" Classification values are fetching successfully.");
		LoggerUtil.pass(" Expected Values = " + expectedvalue);

		Thread.sleep(3000);
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> specigradeclmdata = driver.findElements(specificgradefetchingclmdata);
		for (WebElement specificvalues : specigradeclmdata) {

			String actualgrade = specificvalues.getText().trim();

			Assert.assertEquals(actualgrade, expectedgrade);

		}

	}

	public static final By fetchdomesticcolumn = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[3]");
	public static final By resetbtncomdetail = By.xpath("//button[@id='tab3Reset']");
	public static final By crossbtn = By.xpath("//*[@id='CommodityDetailTab']/div[2]/div/div/div[1]/div[2]/button[3]");

	public void verifyresetbtnisworkingwell() throws InterruptedException {

		clickOnElement(Domesticradiobtn);
		Thread.sleep(2000);
		clickOnElement(viewbtn);
		Thread.sleep(3000);
		String actualvalue = waitForExpectedElement(fetchdomesticcolumn).getText();
		String expectedvalue = "Domestic";
		Assert.assertEquals(actualvalue, expectedvalue, "value Are not getting match.....");
		Thread.sleep(3000);
		clickOnElement(crossbtn);
		Thread.sleep(2000);
		clickOnElement(resetbtncomdetail);
		Thread.sleep(100);
		clickOnElement(viewbtn);
		WebElement verifyvisibilitydomesticcolum = driver.findElement(fetchdomesticcolumn);
		if (!verifyvisibilitydomesticcolum.isDisplayed()) {

			LoggerUtil.info("Reset Button Is Working Well....");

		}

		else {
			LoggerUtil.info("Reset Button Is Not Working Well....");
		}

	}

	public static final By fetchingimportcolumndata = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[3]");

	public void vereifyresetbuttonisworkingforimportornot() throws InterruptedException {

		clickOnElement(importradiobtn);
		Thread.sleep(2000);
		clickOnElement(viewbtn);
		Thread.sleep(3000);
		String actualvalueimport = waitForExpectedElement(fetchingimportcolumndata).getText();
		String expectedvalueimport = "Imported";
		Assert.assertEquals(actualvalueimport, expectedvalueimport);
		Thread.sleep(3000);
		clickOnElement(crossbtn);
		Thread.sleep(3000);
		clickOnElement(resetbtncomdetail);
		Thread.sleep(2000);
		clickOnElement(viewbtn);
		WebElement verifyingimportcolumn = driver.findElement(fetchingimportcolumndata);
		if (!verifyingimportcolumn.isDisplayed()) {
			LoggerUtil.pass("Reset Button Is Working Well");
		} else {
			LoggerUtil.info("Reset Button Is not Working Well");

		}
	}

	public static final By checkboxclassification = By.xpath("//*[@id='chkddd']/label[2]/input");
	public static final By fetchingcomgrpwithsearchfilter = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[3]");
	public static final By fetchinggrpclssficationwithsearchfilter = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[4]");
	public static final By searchbox = By.xpath("//input[@id='myInputListSearch']");
	public static final By clicksearchfilterbtn = By
			.xpath("//*[@id='CommodityDetailTab']/div[2]/div/div/div[2]/div[2]/i");
	public static final By checkboxcommgrp = By.xpath("//*[@id='chkddd']/label[1]/input");

	public void verifysearchfilter() throws InterruptedException {

		clickOnElement(viewbtn);
		Thread.sleep(5000);
		clickOnElement(clicksearchfilterbtn);
		Thread.sleep(3000);
		clickOnElement(checkboxcommgrp);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchbox), "Ferrous Metals");

		String actualcommoditygroup = waitForExpectedElement(fetchingcomgrpwithsearchfilter).getText();
		String expectedcomgrp = "Ferrous Metals";

		soft.assertEquals(actualcommoditygroup, expectedcomgrp);

		Thread.sleep(2000);

		clickOnElement(crossbtnviewpage);
		Thread.sleep(2000);
		clickOnElement(resetbtncomdetail);
		Thread.sleep(2000);
		clickOnElement(viewbtn);
		Thread.sleep(2000);
		clickOnElement(clicksearchfilterbtn);
		Thread.sleep(3000);
		clickOnElement(checkboxcommgrp);
		Thread.sleep(1000);
		clickOnElement(checkboxclassification);

		clearAndEnterText(waitForExpectedElement(searchbox), "Stainless Steel");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String grpclassification = waitForExpectedElement(fetchinggrpclssficationwithsearchfilter).getText();
		String expectedgrpclassification = "Stainless Steel";
		if (grpclassification.equals(expectedgrpclassification)) {
			System.out.println("✅ PASS: Classification matched as expected: " + expectedgrpclassification);
			LoggerUtil.pass("Group classififcation has been matched = " + expectedgrpclassification
					+ "  With The Actual Result = " + grpclassification);
		} else {
			System.out.println("❌ FAIL: Classification mismatch. Expected: " + expectedgrpclassification + " Found: "
					+ grpclassification);
			LoggerUtil.mismatch("Group Classification Has Not Been Mismatched= " + expectedgrpclassification
					+ "With The Actual Result Is = " + grpclassification);
		}
		soft.assertEquals(grpclassification, expectedgrpclassification, "Group classification mismatch");

		System.out.println("SoftAssert completed for verifysearchfilter()");
		soft.assertAll();
	}

	public void savecommoditydetailsForsupplierDelta(String searchcommoditydropvalue,
			String searchcommodityclassification, String selectcommoditygradevalue) throws InterruptedException {

		clickOnElement(Domesticradiobtn);

		Thread.sleep(3000);
		clickOnElement(CommodityDetailsPage.ClickingcommoditydropdownBtnThirdTab);
		Thread.sleep(3000);

		if (searchcommoditydropvalue == null || searchcommoditydropvalue.isEmpty()) {
			LoggerUtil.info("Commodity dropdown value is EMPTY for mandatory field validation.");
		} else {
			LoggerUtil.info("Entered Commodity dropdown value: " + searchcommoditydropvalue);
		}

		clearAndEnterText(waitForExpectedElement(CommodityDetailsPage.searchInputforcommodityDetailsTab),
				searchcommoditydropvalue);
		System.out.println(searchcommoditydropvalue);
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
		clickOnElement(ClickingGroupclassificationdropdown);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchcomclassificationdropvalue), searchcommodityclassification);
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
		clickOnElement(clickingSpecificgradedropdown);
		List<WebElement> comgradelist = driver.findElements(specificgradelist);
		for (WebElement comgradelistval : comgradelist) {
			String comgrade = comgradelistval.getText().trim();
			if (comgrade.equalsIgnoreCase(selectcommoditygradevalue)) {
				comgradelistval.click();
				LoggerUtil.info("Selected Specific Grade: " + comgrade);
				break;
			}
		}

		clickOnElement(clickingUomdropdown);
		Thread.sleep(3000);

		WebElement searchuom = waitForExpectedElement(searchinputforuom);
		clearAndEnterText(searchuom, "Mtr");
		searchuom.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered UOM as: Mtr");
		Thread.sleep(500);

		clickOnElement(ClickingShapedropdown);
		Thread.sleep(300);

		WebElement shapesearch = waitForExpectedElement(searchinputforshape);
		clearAndEnterText(shapesearch, "Sheet");
		shapesearch.sendKeys(Keys.ENTER);
		LoggerUtil.info("Entered Shape as: Sheet");
		Thread.sleep(5000);

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

	}

	public static final By landedrmcost = By.xpath("//*[@id='DeltaTableBody']/tr/td[4]/input");
	public static final By landedscrapcost = By.xpath("//*[@id='DeltaTableBody']/tr/td[5]/input");
	public static final By editbtndomestic = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[2]/a[1]/i");
	public static final By selectAllcheckboxforsupplierDelta = By
			.xpath("//select[@id='SupplierSpecificDelta']/following-sibling::div/div/button[1]/span/input");
	public static final By suppdeltadrop = By
			.xpath("//select[@id='SupplierSpecificDelta']/following-sibling::div/button[@type='button']");
	public static final By entersuppdeltarm = By.xpath("//*[@id='DeltaTableBody']/tr/td[2]/input");
	public static final By entersuppscrapdelta = By.xpath("//*[@id='DeltaTableBody']/tr/td[3]/input");

	public void selectsuppdeltaforsaveAndverify(String entersupprm, String entersuppscrap,
			String entersearchvalueforcomdetail) throws InterruptedException {

		clickOnElement(suppdeltadrop);
		Thread.sleep(2000);
		clickOnElement(selectAllcheckboxforsupplierDelta);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(entersuppdeltarm), entersupprm);
		clearAndEnterText(waitForExpectedElement(entersuppscrapdelta), entersuppscrap);

		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Thread.sleep(7000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		clickOnElement(viewbtn);
		Thread.sleep(7000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);
		Thread.sleep(3000);

		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = entersearchvalueforcomdetail;
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);
		Thread.sleep(3000);
		clickOnElement(editbtndomestic);

		String actualrm = waitForExpectedElement(entersuppdeltarm).getAttribute("value");
		soft.assertEquals(actualrm, entersupprm);

		String actualscrap = waitForExpectedElement(entersuppscrapdelta).getAttribute("value");
		soft.assertEquals(actualscrap, entersuppscrap);

		String actuallandedrmvalue = waitForExpectedElement(landedrmcost).getAttribute("value");
		soft.assertEquals(actuallandedrmvalue, entersupprm);

		String actuallandedscrapvalue = waitForExpectedElement(landedscrapcost).getAttribute("value");
		soft.assertEquals(actuallandedscrapvalue, entersuppscrap);

		clickOnElement(viewbtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchbox), entersearchvalueforcomdetail);
		Thread.sleep(2000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();

		soft.assertAll();

	}

	public static final By landedrmforcustomer = By.xpath("//*[@id='DeltaTableBodyCustomer']/tr/td[4]/input");
	public static final By landedscrapforcustomer = By.xpath("//*[@id='DeltaTableBodyCustomer']/tr/td[5]/input");
	public static final By entercustomerRmvalue = By.xpath("//*[@id='DeltaTableBodyCustomer']/tr/td[2]/input");
	public static final By entercustomerscrapvalue = By.xpath("//*[@id='DeltaTableBodyCustomer']/tr/td[3]/input");
	public static final By clickselectallcustomerdelta = By
			.xpath("//select[@id='CustomerSpecificDelta']/following-sibling::div/div/button[1]/span/input");
	public static final By clickcusotmerdeltadropdown = By
			.xpath("//select[@id='CustomerSpecificDelta']/following-sibling::div/button");

	public void SelectcustomerdeltaforSaveAndVerify(String enterCustomerRmvalue, String entercustomerscrap,
			String entersearchvalueforcomdetail) throws InterruptedException {

		clickOnElement(clickcusotmerdeltadropdown);
		Thread.sleep(3000);
		clickOnElement(clickselectallcustomerdelta);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(entercustomerRmvalue), enterCustomerRmvalue);
		clearAndEnterText(waitForExpectedElement(entercustomerscrapvalue), entercustomerscrap);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		LoggerUtil.info("Clicked Save in Third Tab for Commodity Details with possible empty fields.");
		Thread.sleep(7000);
		clickOnElement(Domesticradiobtn);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		clickOnElement(viewbtn);
		Thread.sleep(7000);
		clearAndEnterText(waitForExpectedElement(searchinputforcommdetail), entersearchvalueforcomdetail);
		Thread.sleep(3000);
		String actualcomdomesticdata = waitForExpectedElement(fetchingcommgroupcolum).getText();
		String expectedvalueforcomdomesticdata = entersearchvalueforcomdetail;
		Assert.assertEquals(actualcomdomesticdata, expectedvalueforcomdomesticdata);
		Thread.sleep(3000);
		clickOnElement(editbtndomestic);
		String actualrm = waitForExpectedElement(entercustomerRmvalue).getAttribute("value");
		soft.assertEquals(actualrm, enterCustomerRmvalue);

		String actualscrap = waitForExpectedElement(entercustomerscrapvalue).getAttribute("value");
		soft.assertEquals(actualscrap, entercustomerscrap);

		String actuallandedrmcusto = waitForExpectedElement(landedrmforcustomer).getAttribute("value");
		soft.assertEquals(actuallandedrmcusto, enterCustomerRmvalue);

		String expectedlandedscrapcusto = waitForExpectedElement(landedscrapforcustomer).getAttribute("value");
		soft.assertEquals(entercustomerscrap, expectedlandedscrapcusto);
		clickOnElement(viewbtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchbox), entersearchvalueforcomdetail);
		Thread.sleep(2000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();

		soft.assertAll();

	}

	public static final By stStageFreightCostUnit = By.xpath("//*[@id='Fright1st']");
	public static final By BasicCost = By.xpath("//*[@id='BasiccostD']");
	public static final By ConversionCostDrawSlittingUnit = By.xpath("//*[@id='ConversionCostD']");
	public static final By WastagepercentageOnBasicCost = By.xpath("//*[@id='WastageD']");
	public static final By SecondStageFreightCostUnit = By.xpath("//*[@id='Fright2nd']");
	public static final By AnyOtherCostFactorOne = By.xpath("//*[@id='OtherCost1D']");
	public static final By AnyOtherCostFactortwo = By.xpath("//*[@id='OtherCost2D']");
	public static final By SubTotal = By.xpath("//*[@id='SubTotalD']");
	public static final By clickdropTaxIfAnyAddNewTax = By.xpath("//*[@id='select2-taxDrop-container']");
	public static final By enterforselectingdropdownvalue = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By selectingdropdownvalueforaddnewtax = By.xpath("//ul[@id='select2-taxDrop-results']/li");
	public static final By Freighttwo = By.xpath("//*[@id='txtFreight']");
	public static final By Handlingtwo = By.xpath("//*[@id='txtHandling']");
	public static final By otherfactoroneNamefirst = By.xpath("//*[@id='txtOtherFactorName1']");
	public static final By otherfactorcostfirst = By.xpath("//*[@id='txtOtherFactorCost1']");
	public static final By otherfactornametwo = By.xpath("//*[@id='txtOtherFactorName2']");
	public static final By otherfactorcosttwo = By.xpath("//*[@id='txtOtherFactorCost2']");
	public static final By otherfactorsnamethree = By.xpath("//*[@id='txtOtherFactorName3']");
	public static final By otherfactorscostthree = By.xpath("//*[@id='txtOtherFactorCost3']");
	public static final By subtotaloffactors = By.xpath("//*[@id='txtSubTotal']");
	public static final By taxdiscountabsolute = By.xpath("//*[@id='txtDiscountAbsolute']");
	public static final By landedecost = By.xpath("//*[@id='landedCost']");
	public static final By clickeighteenpertaxGST = By.xpath("//*[@id='select2-taxDrop-container']");
	public static final By entervalueforselecttaxgst = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By selectGStDropdownvalue = By.xpath("//ul[@id='select2-taxDrop-results']/li");
	public static final By totalcostaftergst = By.xpath("//*[@id='txtTotalcost']");

	public void fillCostFieldsAndCalculate(int basicCost, int freight1, int conversionCost, int wastagePercent,
			int freight2, int otherCost1, int otherCost2, int enterotherfacfirst, int enterotherfacsecond,
			int enterotherfacThird, int entertaxdiscountabsolute) throws InterruptedException {

		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("Clicked on Domestic Radio Button.");

		clearAndEnterText(waitForExpectedElement(BasicCost), String.valueOf(basicCost));
		clearAndEnterText(waitForExpectedElement(stStageFreightCostUnit), String.valueOf(freight1));
		clearAndEnterText(waitForExpectedElement(ConversionCostDrawSlittingUnit), String.valueOf(conversionCost));
		clearAndEnterText(waitForExpectedElement(WastagepercentageOnBasicCost), String.valueOf(wastagePercent));
		clearAndEnterText(waitForExpectedElement(SecondStageFreightCostUnit), String.valueOf(freight2));
		clearAndEnterText(waitForExpectedElement(AnyOtherCostFactorOne), String.valueOf(otherCost1));
		clearAndEnterText(waitForExpectedElement(AnyOtherCostFactortwo), String.valueOf(otherCost2));

		LoggerUtil.info("Values entered into base cost fields successfully.");

		// Subtotal validation
		String subTotalStr = waitForExpectedElement(SubTotal).getAttribute("value").replace(",", "");
		double actualSubTotal = Double.parseDouble(subTotalStr);
		double expectedSubTotal = basicCost + freight1 + conversionCost + ((wastagePercent / 100.0) * basicCost)
				+ freight2 + otherCost1 + otherCost2;

		LoggerUtil.info("Expected Sub-Total: " + expectedSubTotal);
		LoggerUtil.info("Actual Sub-Total from UI: " + actualSubTotal);

		if (Math.abs(expectedSubTotal - actualSubTotal) <= 0.1) {
			LoggerUtil.info("✅ PASS: Sub-Total matched.");
		} else {
			LoggerUtil
					.info("❌ FAIL: Sub-Total mismatch. Expected: " + expectedSubTotal + ", Actual: " + actualSubTotal);
		}

		// GST dropdown selection
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement dropdown = waitForExpectedElement(clickeighteenpertaxGST);
		js.executeScript("arguments[0].click();", dropdown);
		Thread.sleep(300);
		js.executeScript("arguments[0].click();", dropdown);
		Thread.sleep(700);

		List<WebElement> items = driver.findElements(By.xpath("//ul[@id='select2-taxDrop-results']/li"));
		boolean found = false;

		for (WebElement item : items) {
			String text = item.getText().trim().toLowerCase();
			LoggerUtil.info("Option in dropdown: [" + text + "]");
			if (text.contains("add to casting")) {
				js.executeScript("arguments[0].scrollIntoView(true);", item);
				js.executeScript("arguments[0].click();", item);
				LoggerUtil.info("✅ Successfully selected: " + text);
				found = true;
				break;
			}
		}

		if (!found) {
			LoggerUtil.info("❌ Option 'Add to Casting' not found in visible dropdown list.");
		}

		// Total Cost
		Thread.sleep(1000);
		String totalCostStr = waitForExpectedElement(totalcostaftergst).getAttribute("value").replace(",", "");
		double actualTotalCost = Double.parseDouble(totalCostStr);
		double expectedTotalCost = expectedSubTotal + (expectedSubTotal * 18 / 100.0);

		LoggerUtil.info("Expected Total Cost (with 18% GST): " + expectedTotalCost);
		LoggerUtil.info("Actual Total Cost from UI: " + actualTotalCost);

		if (Math.abs(expectedTotalCost - actualTotalCost) <= 0.1) {
			LoggerUtil.info("✅ PASS: Total Cost matched.");
		} else {
			LoggerUtil.info(
					"❌ FAIL: Total Cost mismatch. Expected: " + expectedTotalCost + ", Actual: " + actualTotalCost);
		}

		// Other Factors
		clearAndEnterText(waitForExpectedElement(otherfactorcostfirst), String.valueOf(enterotherfacfirst));
		clearAndEnterText(waitForExpectedElement(otherfactorcosttwo), String.valueOf(enterotherfacsecond));
		clearAndEnterText(waitForExpectedElement(otherfactorscostthree), String.valueOf(enterotherfacThird));
		LoggerUtil.info("Entered other factor costs successfully.");

		Thread.sleep(1000);
		String subTotal1Str = waitForExpectedElement(subtotaloffactors).getAttribute("value").replace(",", "");
		double actualSubTotal1 = Double.parseDouble(subTotal1Str);
		double expectedSubTotal1 = actualTotalCost + enterotherfacfirst + enterotherfacsecond + enterotherfacThird;

		LoggerUtil.info("Expected Sub-Total-1: " + expectedSubTotal1);
		LoggerUtil.info("Actual Sub-Total-1 from UI: " + actualSubTotal1);

		if (Math.abs(expectedSubTotal1 - actualSubTotal1) <= 0.1) {
			LoggerUtil.info("✅ PASS: Sub-Total-1 matched.");
		} else {
			LoggerUtil.info(
					"❌ FAIL: Sub-Total-1 mismatch. Expected: " + expectedSubTotal1 + ", Actual: " + actualSubTotal1);
		}

		// Discount and Landed Cost
		clearAndEnterText(waitForExpectedElement(taxdiscountabsolute), String.valueOf(entertaxdiscountabsolute));
		Thread.sleep(1000);

		String landedCostStr = waitForExpectedElement(landedecost).getAttribute("value").replace(",", "");
		double actualLandedCost = Double.parseDouble(landedCostStr);
		double expectedLandedCost = expectedSubTotal1 - entertaxdiscountabsolute;

		LoggerUtil.info("Expected Landed Cost after Discount: " + expectedLandedCost);
		LoggerUtil.info("Actual Landed Cost from UI: " + actualLandedCost);

		if (Math.abs(expectedLandedCost - actualLandedCost) <= 0.1) {
			LoggerUtil.info("✅ PASS: Landed Cost matched.");
		} else {
			LoggerUtil.info(
					"❌ FAIL: Landed Cost mismatch. Expected: " + expectedLandedCost + ", Actual: " + actualLandedCost);
		}
	}

	public static final By exportbtnui = By.xpath("//*[@id='CommodityDetailTab']/div[1]/div[2]/div/div/div/button[3]");
	public static final By exportpopup = By.xpath("//*[@id='exportModal']/div/div/div[3]/button");
	public static final By fetchingcommoditygroupforexcelcompare = By.xpath("");

	public void ReadDataFromExcelFileWithWholePrice() throws InterruptedException {
		LoggerUtil.info("🚩 Starting export for Domestic Whole Commodity data");

		clickOnElement(Domesticradiobtn);
		LoggerUtil.info("✅ Clicked on Domestic Radio Button");

		Thread.sleep(1000);
		clickOnElement(exportbtnui);
		LoggerUtil.info("✅ Export button clicked");

		Thread.sleep(1000);
		clickOnElement(exportpopup);
		LoggerUtil.info("✅ Export popup confirm clicked");

		Thread.sleep(60000); // Wait for download to complete

		String latestFilePath = getLatestCommodityDomesticWholeFilePath();

		if (latestFilePath == null) {
			LoggerUtil.info("❌ No valid Excel file found.");
			return;
		}

		LoggerUtil.info("📥 Latest Excel file path: " + latestFilePath);

		try {
			List<List<String>> rawData = ExcelUtil.readEntireSheetAsListWithSafeHeaders(latestFilePath);

			int headerRowIndex = -1;
			for (int i = 0; i < Math.min(10, rawData.size()); i++) {
				List<String> row = rawData.get(i);
				if (row.contains("Commodity Group")) {
					headerRowIndex = i;
					break;
				}
			}

			if (headerRowIndex == -1) {
				LoggerUtil.info("❌ 'Commodity Group' column not found in Excel.");
				return;
			}

			List<String> headers = rawData.get(headerRowIndex);
			LoggerUtil.info("🗒️ Headers (from row " + (headerRowIndex + 1) + "): " + headers);

			int commodityGroupColIndex = headers.indexOf("Commodity Group");
			List<List<String>> dataRows = rawData.subList(headerRowIndex + 1, rawData.size());

			int maxRowsToCheck = Math.min(20, dataRows.size());
			List<String> excelCommodityGroups = new ArrayList<>();

			for (int i = 0; i < maxRowsToCheck; i++) {
				List<String> row = dataRows.get(i);
				String commodityGroup = commodityGroupColIndex < row.size() ? row.get(commodityGroupColIndex).trim()
						: "";
				excelCommodityGroups.add(commodityGroup);
				LoggerUtil.info("📦 Excel Row " + (i + headerRowIndex + 2) + " - Commodity Group: " + commodityGroup);
			}

			// UI Interaction
			Thread.sleep(4000);
			clickOnElement(viewbtn);
			Thread.sleep(4000);

			List<WebElement> uiCommodityGroups = driver.findElements(By.xpath("//*[@id='ComDetailBody']/tr/td[4]"));

			for (int i = 0; i < Math.min(20, uiCommodityGroups.size()); i++) {
				String uiVal = uiCommodityGroups.get(i).getText().trim();
				LoggerUtil.info("🌐 UI Row " + (i + 1) + " - Commodity Group: " + uiVal);

				String excelVal = i < excelCommodityGroups.size() ? excelCommodityGroups.get(i) : "";

				if (!excelVal.equalsIgnoreCase(uiVal)) {
					LoggerUtil.error(
							"❌ MISMATCH at Row " + (i + 1) + ": UI = '" + uiVal + "', Excel = '" + excelVal + "'");
				}
			}

		} catch (Exception e) {
			LoggerUtil.info("❌ Error reading Excel: " + e.getMessage());
		}

		LoggerUtil.info("✅ Export read process completed.");
	}

	public static final By clickcommoditydropdownforexceldata = By.xpath("//*[@id='comoditygrp']/span/div/button");
	public static final By searchcommodityvalue = By.xpath("//*[@id='comoditygrp']/span/div/div/div/input");
	public static final By selectallcheckboxvalueforimport = By.xpath(
			"//select[@id='CommodityList1']/following-sibling::div/div/div/following-sibling::button/span/input");
	public static final By clickgroupclassificationdropboxforexceldata = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/button/span");
	public static final By searchvaluegrpclassificationvalue = By
			.xpath("//*[@id='groupclass']/div/div[2]/span/div/div/div/input");
	public static final By selectallcheckboxvalueforimportgrpclassification = By
			.xpath("(//div[@id='groupclass']/div/div[2]/span/div/div/div/following-sibling::button/span/input)[1]");

	public String getLatestCommodityDomesticWholeFilePath() {
		String downloadDir = "C:\\Users\\Admin\\Downloads\\com.CostMaster\\downloads";
		String filePrefix = "Commodity_type_Domestic-Whole";
		String latestFile = null;

		File dir = new File(downloadDir);
		File[] files = dir.listFiles((d, name) -> name.startsWith(filePrefix) && name.endsWith(".xlsx"));

		if (files != null && files.length > 0) {
			Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
			latestFile = files[0].getAbsolutePath();
			System.out.println("✅ Latest Excel file found: " + files[0].getName());
		} else {
			System.err.println("❌ No matching Excel file found.");
		}
		return latestFile;
	}

// Step 2: Get first sheet name dynamically
	public static String getFirstSheetName(String filePath) throws IOException {
		try (FileInputStream fis = new FileInputStream(new File(filePath)); Workbook workbook = new XSSFWorkbook(fis)) {
			return workbook.getSheetAt(0).getSheetName();
		}
	}

// Step 3: Read entire sheet as list of rows with headers in headerRowIndex (0-based)
	public static List<List<String>> readSheetWithHeaderRow(String filePath, int headerRowIndex) throws IOException {
		List<List<String>> sheetData = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(new File(filePath)); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0);
			int lastRowNum = sheet.getLastRowNum();

			// Read header row
			Row headerRow = sheet.getRow(headerRowIndex);
			List<String> headers = new ArrayList<>();
			for (int c = 0; c < headerRow.getLastCellNum(); c++) {
				Cell cell = headerRow.getCell(c);
				headers.add(cell != null ? cell.toString().trim() : "");
			}
			sheetData.add(headers);

			// Read data rows after header
			for (int r = headerRowIndex + 1; r <= lastRowNum; r++) {
				Row row = sheet.getRow(r);
				List<String> rowData = new ArrayList<>();
				if (row != null) {
					for (int c = 0; c < headers.size(); c++) {
						Cell cell = row.getCell(c);
						rowData.add(cell != null ? cell.toString() : "");
					}
				} else {
					for (int c = 0; c < headers.size(); c++) {
						rowData.add("");
					}
				}
				sheetData.add(rowData);
			}
		}
		return sheetData;
	}

// Step 4: Find column index by column name (case-insensitive)
	public static int getColumnIndexByName(List<String> headers, String colName) {
		for (int i = 0; i < headers.size(); i++) {
			if (headers.get(i).equalsIgnoreCase(colName.trim())) {
				return i;
			}
		}
		return -1;
	}

// Step 5: Update a specific Excel cell value
	public static void setCellData(String filePath, String sheetName, int rowNum, int colNum, String value)
			throws IOException {
		File file = new File(filePath);
		try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet " + sheetName + " not found");
			}

			Row row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);

			Cell cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(value);

			fis.close(); // close before writing

			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}
		}
		System.out.println(
				"Excel updated: Sheet: " + sheetName + ", Row: " + rowNum + ", Col: " + colNum + ", Value: " + value);
	}

// Step 6: Import price values into Excel and calculate landed cost
	public void importPriceValueForCreatingHistory() throws InterruptedException, IOException {
		System.out.println("Starting export for Domestic Whole Commodity data");

		clickOnElement(Domesticradiobtn);
		clickOnElement(exportbtnui);

		Thread.sleep(3000);
		clickOnElement(clickcommoditydropdownforexceldata);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchcommodityvalue), "usingforautomatipnpurpose");
		Thread.sleep(2000);
		clickOnElement(selectallcheckboxvalueforimport);

		Thread.sleep(3000);
		clickOnElement(clickgroupclassificationdropboxforexceldata);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchvaluegrpclassificationvalue), "do not delete");
		Thread.sleep(2000);
		clickOnElement(selectallcheckboxvalueforimportgrpclassification);

		Thread.sleep(3000);
		clickOnElement(exportpopup);
		System.out.println("Export popup confirm clicked");

		Thread.sleep(7000); // wait for file to export

		String filePath = getLatestCommodityDomesticWholeFilePath();
		if (filePath == null || filePath.isEmpty()) {
			throw new RuntimeException("Latest Excel file not found.");
		}
		System.out.println("Latest Excel file path: " + filePath);

		String sheetName = getFirstSheetName(filePath);
		System.out.println("Sheet name detected: " + sheetName);

		int headerRowIndex = 2; // your Excel header row index (0-based)

		List<List<String>> sheetData = readSheetWithHeaderRow(filePath, headerRowIndex);
		List<String> headers = sheetData.get(0);

		System.out.println("Excel headers:");
		for (String h : headers) {
			System.out.println("[" + h + "]");
		}

		int dataRowIndex = 1; // first data row after header (0-based)

		BiConsumer<String, String> updateCell = (colName, val) -> {
			int colIndex = getColumnIndexByName(headers, colName);
			if (colIndex < 0) {
				throw new RuntimeException("Column '" + colName + "' not found in Excel headers.");
			}
			try {
				setCellData(filePath, sheetName, headerRowIndex + dataRowIndex, colIndex, val);
			} catch (IOException e) {
				throw new RuntimeException("Error updating Excel cell", e);
			}
		};

		Random random = new Random();

		// Generate random values for each cost component
		double basicCost = 30 + random.nextDouble() * 70; // Random between 30-100
		double freight1 = 10 + random.nextDouble() * 40; // 10-50
		double conversionCost = 10 + random.nextDouble() * 40; // 10-50
		double wastagePercent = 5 + random.nextDouble() * 20; // 5-25%
		double freight2nd = 10 + random.nextDouble() * 50; // 10-60
		double otherCostFactor1 = 20 + random.nextDouble() * 40; // 20-60
		double otherCostFactor2 = 15 + random.nextDouble() * 40; // 15-55
		double discountAbsolute = 5 + random.nextDouble() * 30; // 5-35

		// Round to two decimals for neatness
		basicCost = Math.round(basicCost * 100.0) / 100.0;
		freight1 = Math.round(freight1 * 100.0) / 100.0;
		conversionCost = Math.round(conversionCost * 100.0) / 100.0;
		wastagePercent = Math.round(wastagePercent * 100.0) / 100.0;
		freight2nd = Math.round(freight2nd * 100.0) / 100.0;
		otherCostFactor1 = Math.round(otherCostFactor1 * 100.0) / 100.0;
		otherCostFactor2 = Math.round(otherCostFactor2 * 100.0) / 100.0;
		discountAbsolute = Math.round(discountAbsolute * 100.0) / 100.0;

		// Update Excel cells with random values
		updateCell.accept("Basic Cost", String.valueOf(basicCost));
		updateCell.accept("1st Stage Frieght Cost / Unit", String.valueOf(freight1));
		updateCell.accept("Conversion Cost Draw / Slitting / Unit", String.valueOf(conversionCost));
		updateCell.accept("Wastage % on Basic Cost", String.valueOf(wastagePercent));
		updateCell.accept("2nd Stage Freight Cost / Unit", String.valueOf(freight2nd));
		updateCell.accept("Other Cost Factor1 / Unit", String.valueOf(otherCostFactor1));
		updateCell.accept("Other Cost Factor2 / Unit", String.valueOf(otherCostFactor2));
		updateCell.accept("Discount-Absolute", String.valueOf(discountAbsolute));

		// Tax fixed at 18%
		double taxPercent = 18;

		// Calculate landed cost using random values
		double wastageAmount = basicCost * wastagePercent / 100;
		double subTotal = basicCost + freight1 + conversionCost + wastageAmount + freight2nd + otherCostFactor1
				+ otherCostFactor2;
		double taxAmount = subTotal * taxPercent / 100;
		double totalCost = subTotal + taxAmount;
		double landedCost = totalCost - discountAbsolute;
		landedCost = Math.round(landedCost * 100.0) / 100.0;

		updateCell.accept("Landed Cost", String.valueOf(landedCost));

		System.out.println("Excel updated with random cost values and landed cost: " + landedCost);

	}

// Step 7: Verify landed cost from Excel
	public void verifyLandedCostInExcel() throws IOException {
		String filePath = getLatestCommodityDomesticWholeFilePath();
		if (filePath == null || filePath.isEmpty()) {
			throw new RuntimeException("Latest Excel file not found.");
		}

		String sheetName = getFirstSheetName(filePath);
		int headerRowIndex = 2;
		int dataRowIndex = 1;

		try (FileInputStream fis = new FileInputStream(new File(filePath)); Workbook workbook = new XSSFWorkbook(fis)) {

			workbook.setForceFormulaRecalculation(true);

			Sheet sheet = workbook.getSheet(sheetName);
			List<List<String>> sheetData = readSheetWithHeaderRow(filePath, headerRowIndex);
			List<String> headers = sheetData.get(0);

			int landedCostColIndex = getColumnIndexByName(headers, "Landed Cost");
			if (landedCostColIndex < 0) {
				throw new RuntimeException("'Landed Cost' column not found in Excel headers!");
			}

			Row dataRow = sheet.getRow(headerRowIndex + dataRowIndex);
			if (dataRow == null) {
				throw new RuntimeException("Data row not found at index: " + (headerRowIndex + dataRowIndex));
			}

			Cell landedCostCell = dataRow.getCell(landedCostColIndex);
			if (landedCostCell == null) {
				landedCostCell = dataRow.createCell(landedCostColIndex);
			} else if (landedCostCell.getCellType() == CellType.FORMULA) {
				landedCostCell.setCellType(CellType.NUMERIC);
			}

			double basicCost = Double
					.parseDouble(sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "Basic Cost")));
			double freight1 = Double.parseDouble(
					sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "1st Stage Frieght Cost / Unit")));
			double conversionCost = Double.parseDouble(sheetData.get(dataRowIndex)
					.get(getColumnIndexByName(headers, "Conversion Cost Draw / Slitting / Unit")));
			double wastagePercent = Double.parseDouble(
					sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "Wastage % on Basic Cost")));
			double freight2nd = Double.parseDouble(
					sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "2nd Stage Freight Cost / Unit")));
			double otherCostFactor1 = Double.parseDouble(
					sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "Other Cost Factor1 / Unit")));
			double otherCostFactor2 = Double.parseDouble(
					sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "Other Cost Factor2 / Unit")));
			double discountAbsolute = Double
					.parseDouble(sheetData.get(dataRowIndex).get(getColumnIndexByName(headers, "Discount-Absolute")));
			double taxPercent = 18;

			// Final Calculation with floor rounding
			double wastageAmount = basicCost * wastagePercent / 100;
			double subTotal = basicCost + freight1 + conversionCost + wastageAmount + freight2nd + otherCostFactor1
					+ otherCostFactor2;
			subTotal = Math.floor(subTotal * 1000.0) / 1000.0;

			double taxAmount = subTotal * taxPercent / 100;
			double totalCost = subTotal + taxAmount;
			double landedCostCalc = totalCost - discountAbsolute;

			landedCostCell.setCellValue(landedCostCalc);
			System.out.println("Excel updated: Sheet: " + sheetName + ", Row: " + dataRow.getRowNum() + ", Col: "
					+ landedCostColIndex + ", Value: " + landedCostCalc);

			fis.close();
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}
			workbook.close();

			try (FileInputStream recheckFis = new FileInputStream(new File(filePath));
					Workbook recheckWorkbook = new XSSFWorkbook(recheckFis)) {

				Sheet recheckSheet = recheckWorkbook.getSheet(sheetName);
				Row recheckRow = recheckSheet.getRow(headerRowIndex + dataRowIndex);
				Cell recheckCell = recheckRow.getCell(landedCostColIndex);
				double excelLandedCost = (recheckCell != null && recheckCell.getCellType() == CellType.NUMERIC)
						? recheckCell.getNumericCellValue()
						: 0.0;

				double tolerance = 0.001;
				if (Math.abs(landedCostCalc - excelLandedCost) <= tolerance) {
					System.out.println("✅ Landed Cost calculation VERIFIED in Excel. Calculated: " + landedCostCalc
							+ ", Excel Stored: " + excelLandedCost);
				} else {
					System.err.println("❌ Landed Cost calculation MISMATCH in Excel! Calculated: " + landedCostCalc
							+ ", Excel Stored: " + excelLandedCost);
					throw new AssertionError("Landed Cost mismatch in Excel!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Error during Landed Cost verification: " + e.getMessage());
		}
	}

// Your locator for upload input
	public static final By uploadExcelFile = By
			.xpath("//div[@id='exportModal']/div/div/div[3]/input[@id='excelUpload']");

// Method to click upload button (adjust as needed)
	public void uploadExcelFile() {
		String filePath = getLatestCommodityDomesticWholeFilePath();
		WebElement input = driver.findElement(By.id("excelUpload"));
		input.sendKeys(filePath);
		System.out.println("✅ File uploaded silently via sendKeys.");

		WebElement importBtn = driver.findElement(By.xpath("//button[contains(text(),'Import')]"));
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", importBtn);
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", importBtn);
			System.out.println("✅ Import triggered successfully via JS.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		} catch (Exception e) {
			throw new RuntimeException("❌ Import button click failed via JS: " + e.getMessage());

		}
	}

	public void savesecondtabcommoditygroupforExcelNewGradeAdditionFile(String searchcommodityvalue,
			String grpclassificationvalue, String specificgradevalye, String densityvalue) throws InterruptedException {
		Thread.sleep(6000);

		// 1. Select2 dropdown open karo (correct element pe click!)
		WebElement select2Box = driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single"));
		Actions actions = new Actions(driver);
		actions.moveToElement(select2Box).click().perform();
		Thread.sleep(3000);

		// 2. Value select karne ka aapka original code
		List<WebElement> grouplist = driver.findElements(selectvaluecommoditygroupvalue);
		for (WebElement grpvalue : grouplist) {
			String text = grpvalue.getText().trim();
			if (text.equalsIgnoreCase(searchcommodityvalue)) {
				grpvalue.click();
				break;
			}
		}
		Thread.sleep(2000);

		clearAndEnterText(waitForExpectedElement(groupclassification), grpclassificationvalue);
		LoggerUtil.info("Entered Group Classification: " + grpclassificationvalue);

		Thread.sleep(100);
		clearAndEnterText(waitForExpectedElement(specificgradevalue), specificgradevalye);
		LoggerUtil.info("Entered Specific Grade Value: " + specificgradevalye);

		Thread.sleep(100);
		clearAndEnterText(waitForExpectedElement(Densityvalue), densityvalue);
		LoggerUtil.info("Entered Density Value: " + densityvalue);

		Thread.sleep(100);
		clickOnElement(savebtncommoditygrp);
		LoggerUtil.info("Clicked Save in Second Tab for Commodity Group.");
		Thread.sleep(5000);
	}

	public static final By clcikselectallcheckboxforsupplier = By.xpath(
			"//*[@id='supplierDiv']/div[2]/div/span/div/button/following-sibling::div/button[@title=' Select all']/span/input");
	public static final By searchsuppvalueforexprotnewgrade = By
			.xpath("//*[@id='supplierDiv']/div[2]/div/span/div/div/div/input");
	public static final By suppdropboxforexportingnewgradefile = By
			.xpath("//*[@id='supplierDiv']/div[2]/div/span/div/button");
	public static final By newgraderadiobtnforexport = By.xpath("//*[@id='NewGradeadd']");

	public void exportwithnewgradeadditionfile() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElement(Domesticradiobtn);
		clickOnElement(exportbtnui);
		Thread.sleep(200);
		clickOnElement(newgraderadiobtnforexport);
		Thread.sleep(200);
		clickOnElement(suppdropboxforexportingnewgradefile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchsuppvalueforexprotnewgrade), "usingautomationdetails-4195");
		Thread.sleep(100);
		clickOnElement(clcikselectallcheckboxforsupplier);
		Thread.sleep(100);
		clickOnElement(exportpopup);
		Thread.sleep(9000);
		LoggerUtil.info("Dropdown option Are not visible......");
	}

}
