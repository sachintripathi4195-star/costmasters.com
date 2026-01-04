package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelFiller;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

public class BOPEntryPage extends Base {

	Faker faker = new Faker();
	ComdomesticPage comdomestic = new ComdomesticPage();
	DashboardPage dashboard = new DashboardPage();
	public static final By ClickOnBopTypeDropdown = By.xpath("//span[@id='select2-BopEntry_BopType-container']");
	public static final By ListofBopTypeDropDown = By.xpath("//ul[@id='select2-BopEntry_BopType-results']//li");
	
	
	public static final By EnterBopTypeForFirstTab = By.xpath("//input[@id='BopType_BopTypeName']");
	public static final By SaveButtonBopTypeInFirstTab = By.xpath("//button[@id='SaveBOP']");

	public void EnterBopTypeValue(String EnterBopValue) throws InterruptedException {
		clearAndEnterText(waitForExpectedElement(EnterBopTypeForFirstTab), EnterBopValue);
		Thread.sleep(3000);
		clickOnElement(SaveButtonBopTypeInFirstTab);

	}

	public void clickingdropdownbopEntryDropdown(String value) throws InterruptedException {

		Thread.sleep(3000);
		clickOnElement(ClickOnBopTypeDropdown);
		Thread.sleep(3000);
		List<WebElement> listvalueBoptype = driver.findElements(ListofBopTypeDropDown);
		selectBootStrapDropDown(listvalueBoptype, value);

	}

	// Select
	public static final By verifyBopTypePlaceHolder = By.xpath("//span[@id='select2-BopEntry_BopType-container']");
	public static final By uomdropdown = By.xpath("//span[@id='select2-BopEntry_UomInHouse-container']");
	public static final By ClickingCommoditygroupdropdown = By
			.xpath("//span[@id='select2-BopEntry_CommodityGroupInhouse-container']");
	public static final By Rmspecificgradedropdown = By.xpath("//span[@id='select2-BopEntry_RmGrade-container']");
	public static final By suppliernameAndcodedropdown = By
			.xpath("//span[@id='select2-BopEntry_SupplierInhouse-container']");
	public static final By Rmgroupclassification = By
			.xpath("//span[@id='select2-BopEntry_TypeofMaterialInhouse-container']");
	public static final By EnterValuePartdescription = By.xpath("//input[@id='BopEntry_ChildPartDescInHouse']");
	public static final By EnterPartnumberValue = By.xpath("//input[@id='BopEntry_PartNoInHouse']");

	public void verifyPlaceHolder() {
		SoftAssert softAssert = new SoftAssert();
		String expected = "Select";
		String dropdownName;
		String actualValue;
		String WriteFieldName;
		String actulaWritefield;
		String expectedWriteField = "Enter";

		try {

			dropdownName = "BopType";
			switch (dropdownName) {
			case "BopType":
				actualValue = waitForExpectedElement(verifyBopTypePlaceHolder).getAttribute("title").trim();
				LoggerUtil.logger.info("BOP Type Placeholder: " + actualValue);
				softAssert.assertEquals(actualValue, expected, "Mismatch in BOP Type Placeholder");
				break;
			}

			dropdownName = "UOM";
			switch (dropdownName) {
			case "UOM":
				actualValue = waitForExpectedElement(uomdropdown).getText().trim();
				LoggerUtil.logger.info("UOM Placeholder: " + actualValue);
				softAssert.assertEquals(actualValue, expected, "Mismatch in UOM Placeholder");
				break;
			}

			dropdownName = "CommodityGroup";
			switch (dropdownName) {
			case "CommodityGroup":
				actualValue = waitForExpectedElement(ClickingCommoditygroupdropdown).getText().trim();
				LoggerUtil.logger.info("Commodity Group Placeholder: " + actualValue);
				softAssert.assertEquals(actualValue, expected, "Mismatch in Commodity Group Placeholder");
				break;
			}

			dropdownName = "RMGrade";
			switch (dropdownName) {
			case "RMGrade":
				actualValue = waitForExpectedElement(Rmspecificgradedropdown).getText().trim();
				LoggerUtil.logger.info("RM Grade Placeholder: " + actualValue);
				softAssert.assertEquals(actualValue, expected, "Mismatch in RM Grade Placeholder");
				break;
			}

			dropdownName = "Supplier";
			switch (dropdownName) {
			case "Supplier":
				actualValue = waitForExpectedElement(suppliernameAndcodedropdown).getText().trim();
				LoggerUtil.logger.info("Supplier Placeholder: " + actualValue);
				softAssert.assertEquals(actualValue, expected, "Mismatch in Supplier Placeholder");
				break;
			}

			dropdownName = "RMGroup";
			switch (dropdownName) {
			case "RMGroup":
				actualValue = waitForExpectedElement(Rmgroupclassification).getText().trim();
				LoggerUtil.logger.info("RM Group Classification Placeholder: " + actualValue);
				softAssert.assertEquals(actualValue, expected, "Mismatch in RM Group Classification Placeholder");
				break;
			}

			WriteFieldName = "Part Description";
			switch (WriteFieldName) {
			case "Part Description":

				actulaWritefield = waitForExpectedElement(EnterValuePartdescription).getAttribute("placeholder");
				LoggerUtil.logger.info("Part Description Placeholder: " + actulaWritefield);
				softAssert.assertEquals(actulaWritefield, expectedWriteField,
						" Part Description Placeholder Is Mismatched ");

			}

			WriteFieldName = "Part Numberhouse";
			switch (WriteFieldName) {
			case "Part Numberhouse":
				actulaWritefield = waitForExpectedElement(EnterValuePartdescription).getAttribute("placeholder");
				LoggerUtil.logger.info("Part NumberHouse Placeholder: " + actulaWritefield);
				softAssert.assertEquals(actulaWritefield, expectedWriteField,
						" Part Number House Placeholder Is Mismatched ");

			}

		} catch (Exception e) {
			LoggerUtil.logger.error("Exception while verifying placeholders: " + e.getMessage());
		}

		softAssert.assertAll();
	}

	public static final By AstricMarkBopType = By
			.xpath("(//label[contains(text(),'BOP Type')]/following-sibling::span)[2]");
	public static final By AstricMArkBopCategory = By
			.xpath("//label[contains(text(),'BOP Category')]/following-sibling::span");
	public static final By AstricMarkPartDiscription = By
			.xpath("(//label[contains(text(),'Part Description')]/following-sibling::span)[1]");
	public static final By AstricMarkUOM = By.xpath("(//label[contains(text(),'UOM')]/following-sibling::span)[1]");
	public static final By AstrickMarkCommodityGroup = By
			.xpath("(//label[contains(text(),'Commodity Group')]/following-sibling::span)[1]");
	public static final By AstricMarkRmSpecificGrade = By
			.xpath("(//label[contains(text(),'RM Specific Grade')]/following-sibling::span)[1]");
	public static final By AstricMarkPartNumber = By
			.xpath("(//label[contains(text(),'Part No.')]/following-sibling::span)[1]");
	public static final By AstricMarkSupplierNameAndCode = By
			.xpath("(//label[contains(text(),'Supplier Name&code')]/following-sibling::span)[1]");
	public static final By AstricMarkRmGroupClassification = By
			.xpath("(//label[contains(text(),'RM Group Classification')]/following-sibling::span)[1]");

	public void verifyAstricMarkShouldBeAvailableWithMandatoryField() {
		SoftAssert soft = new SoftAssert();
		String expected = "*";
		String mandatory;
		String actual;

		try {

			mandatory = "Bop Type";
			switch (mandatory) {
			case "Bop Type":
				actual = waitForExpectedElement(AstricMarkBopType).getText().trim();
				LoggerUtil.info("BOP Type Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for BOP Type");
				break;
			}

			mandatory = "Bop Category";
			switch (mandatory) {
			case "Bop Category":
				actual = waitForExpectedElement(AstricMArkBopCategory).getText().trim();
				LoggerUtil.info("BOP Category Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for BOP Category");
				break;
			}

			mandatory = "Part Description";
			switch (mandatory) {
			case "Part Description":
				actual = waitForExpectedElement(AstricMarkPartDiscription).getText().trim();
				LoggerUtil.info("Part Description Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for Part Description");
				break;
			}

			mandatory = "UOM";
			switch (mandatory) {
			case "UOM":
				actual = waitForExpectedElement(AstricMarkUOM).getText().trim();
				LoggerUtil.info("UOM Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for UOM");
				break;
			}

			mandatory = "Commodity Group";
			switch (mandatory) {
			case "Commodity Group":
				actual = waitForExpectedElement(AstrickMarkCommodityGroup).getText().trim();
				LoggerUtil.info("Commodity Group Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for Commodity Group");
				break;
			}

			mandatory = "RM Specific Grade";
			switch (mandatory) {
			case "RM Specific Grade":
				actual = waitForExpectedElement(AstricMarkRmSpecificGrade).getText().trim();
				LoggerUtil.info("RM Specific Grade Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for RM Specific Grade");
				break;
			}

			mandatory = "Part Number";
			switch (mandatory) {
			case "Part Number":
				actual = waitForExpectedElement(AstricMarkPartNumber).getText().trim();
				LoggerUtil.info("Part Number Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for Part Number");
				break;
			}

			mandatory = "Supplier Name";
			switch (mandatory) {
			case "Supplier Name":
				actual = waitForExpectedElement(AstricMarkSupplierNameAndCode).getText().trim();
				LoggerUtil.info("Supplier Name Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for Supplier Name & Code");
				break;
			}

			mandatory = "RM Group";
			switch (mandatory) {
			case "RM Group":
				actual = waitForExpectedElement(AstricMarkRmGroupClassification).getText().trim();
				LoggerUtil.info("RM Group Classification Astric Mark: " + actual);
				soft.assertEquals(actual, expected, "❌ Astric mark missing for RM Group Classification");
				break;
			}

		} catch (Exception e) {
			LoggerUtil.fail("Exception while verifying asterisk marks: " + e.getMessage());
		}

		soft.assertAll();
	}

	public void BoptypeDropdownSortedOrNot() {
		SoftAssert soft = new SoftAssert();

		try {

			clickOnElement(ClickOnBopTypeDropdown);
			Thread.sleep(1000);

			List<WebElement> listvalueBoptype = driver.findElements(ListofBopTypeDropDown);
			List<String> actualList = new ArrayList<>();
			for (WebElement options : listvalueBoptype) {
				actualList.add(options.getText().trim());
			}

			List<String> sortedList = new ArrayList<>(actualList);
			Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

			LoggerUtil.info("Original Order: " + actualList);
			LoggerUtil.info("Sorted Order:   " + sortedList);

			soft.assertEquals(actualList, sortedList, "❌ BOP Type dropdown is not sorted alphabetically.");
		} catch (Exception e) {
			LoggerUtil.error("Exception while verifying BOP Type dropdown sorting: " + e.getMessage());
			soft.fail("Exception occurred: " + e.getMessage());
		}

		soft.assertAll();
	}

	public static final By clickinguomdropdown = By.xpath("//span[@id='select2-BopEntry_UomInHouse-container']");

	public static final By optionsuomdropdown = By.xpath("//ul[@id='select2-BopEntry_UomInHouse-results']/li");

	public void verifyUomDropdownSortedOrNot() {
		SoftAssert softAssert = new SoftAssert();

		try {

			clickOnElement(clickinguomdropdown);
			Thread.sleep(1000);

			List<WebElement> listvalueuom = driver.findElements(optionsuomdropdown);
			List<String> actualList = new ArrayList<>();
			for (WebElement option : listvalueuom) {
				actualList.add(option.getText().trim());
			}

			List<String> sortedList = new ArrayList<>(actualList);
			Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

			LoggerUtil.info("Original UOM Order: " + actualList);
			LoggerUtil.info("Expected Sorted Order: " + sortedList);

			softAssert.assertEquals(actualList, sortedList, "❌ UOM dropdown is not sorted alphabetically.");
		} catch (Exception e) {
			LoggerUtil.error("Exception while verifying UOM dropdown sorting: " + e.getMessage());
			softAssert.fail("Exception occurred during sorting check.");
		}

		softAssert.assertAll();
	}

	public static final By AddSupplierButton = By
			.xpath("(//a[@id='addNewSupplier2' and @class='addNewSupplier']/span[contains(text(),'+ Supplier')])[1]");

	public static final By EnterNewSupplierName = By.xpath("//input[@id='SupplierName']");
	public static final By EnterNewSupplierCode = By.xpath("//input[@id='SupplierCode']");
	public static final By clickingBusinessSegDrop = By.xpath(
			"//div[@class='col-md-6 mb-1']/span/select[@id='supBusinessSegments']/following-sibling::div/button/span");
	public static final By selectingoptionBusinessSeg = By.xpath(
			"//div[@class='multiselect-container dropdown-menu show']/button[2]/span/input[starts-with(@id,'multiselect_')]");
	public static final By SaveAddNewSupplierButton = By.xpath("//button[@id='supplierSave']");

	public static final By clickingSupplierNameAndCodeDropdown = By
			.xpath("//span[@id='select2-BopEntry_SupplierInhouse-container']");
	public static final By searchFuntionalityoFSupplierSearch = By.xpath("//input[@class='select2-search__field']");

	public static final By FetchingDataInSupplierNameAndCodeDropDown = By
			.xpath("//ul[@id='select2-BopEntry_SupplierInhouse-results']/li");

	public void verifysupplierdropdownbehaviour(String enterSuppcodevalue, String entersuppnamevalue)
			throws InterruptedException {
		try {
			LoggerUtil.info("🔹 Starting Supplier creation and dropdown validation...");

			LoggerUtil.info("Clicking on 'Add Supplier' button...");
			clickOnElement(AddSupplierButton);
			Thread.sleep(2000);

			LoggerUtil.info("Entering Supplier Code: " + enterSuppcodevalue);
			clearAndEnterText(waitForExpectedElement(EnterNewSupplierCode), enterSuppcodevalue);

			LoggerUtil.info("Entering Supplier Name: " + entersuppnamevalue);
			clearAndEnterText(waitForExpectedElement(EnterNewSupplierName), entersuppnamevalue);
			Thread.sleep(200);

			LoggerUtil.info("Selecting Business Segment from dropdown...");
			clickOnElement(clickingBusinessSegDrop);
			Thread.sleep(3000);
			clickOnElement(selectingoptionBusinessSeg);
			Thread.sleep(2000);

			LoggerUtil.info("Clicking Save to add new Supplier...");
			clickOnElement(SaveAddNewSupplierButton);
			Thread.sleep(7000);

			LoggerUtil.info("Opening Supplier dropdown to search newly added supplier...");
			clickOnElement(clickingSupplierNameAndCodeDropdown);
			Thread.sleep(3000);

			LoggerUtil.info("Searching supplier using value: " + entersuppnamevalue + "-" + enterSuppcodevalue);
			clearAndEnterText(waitForExpectedElement(searchFuntionalityoFSupplierSearch),
					entersuppnamevalue + "-" + enterSuppcodevalue);
			Thread.sleep(2000);

			String actualData = waitForExpectedElement(FetchingDataInSupplierNameAndCodeDropDown).getText().trim();
			LoggerUtil.info("Fetched dropdown value: " + actualData);
			String expectedData = entersuppnamevalue + "-" + enterSuppcodevalue;

			Assert.assertEquals(actualData, expectedData, "❌ Supplier dropdown search result mismatch.");
			LoggerUtil.info("✅ Supplier dropdown search result verified successfully.");

		} catch (Exception e) {
			LoggerUtil.error("❌ Exception during supplier dropdown verification: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	public static final By BopCategoryDropdownDefaultValue = By
			.xpath("//span[@id='select2-BopEntry_BopEntryType-container']");

	public void VerifyBopCategoryDefaultSelection() {
		try {
			LoggerUtil.info("🔹 Verifying default selection for BOP Category dropdown...");

			String actualValue = waitForExpectedElement(BopCategoryDropdownDefaultValue).getText().trim();
			String expectedValue = "InHouse";

			LoggerUtil.info("Expected Default Value: " + expectedValue);
			LoggerUtil.info("Actual Default Value from UI: " + actualValue);

			Assert.assertEquals(actualValue, expectedValue, "❌ Default value mismatch in BOP Category dropdown.");
			LoggerUtil.info("✅ Default BOP Category is correctly set to 'InHouse'.");

		} catch (Exception e) {
			LoggerUtil.error("❌ Exception during BOP Category default selection check: " + e.getMessage());
			Assert.fail("Exception occurred while verifying BOP Category default selection.");
		}
	}

	public static final By optionscommgrouplist = By
			.xpath("//ul[@id='select2-BopEntry_CommodityGroupInhouse-results']/li");

	public void verifyCommodityDropdownBehaviour() throws InterruptedException {

		clickOnElement(ClickingCommoditygroupdropdown);
		Thread.sleep(2000);
		List<WebElement> commoditygrouplist = driver.findElements(optionscommgrouplist);
		int Size = commoditygrouplist.size();
		System.out.println(Size);
		List<String> actullistvalue = new ArrayList<String>();
		for (WebElement flagcomgrp : commoditygrouplist) {

			actullistvalue.add(flagcomgrp.getText().trim());

		}

		List<String> sortedlist = new ArrayList<String>(actullistvalue);
		Collections.sort(sortedlist, String.CASE_INSENSITIVE_ORDER);

		LoggerUtil.info("The Actual Value of Commodity Group Drop = " + actullistvalue);
		LoggerUtil.info("The Expected Value of Commodity Group Drop  " + sortedlist);

		Assert.assertEquals(sortedlist, actullistvalue);

		clickOnElement(ClickingCommoditygroupdropdown);
	}

	public static final By clickcommoditydropdownCommoditygrouptab = By
			.xpath("//span[@id='select2-commodityDropdown-container']");
	public static final By fetchingcommoditygroupdropdataingrouptab = By
			.xpath("//ul[@id='select2-commodityDropdown-results']/li/following-sibling::li");

	public void verifyFetchingDataInCommodityGroupFromBopEntry() throws InterruptedException {

		clickOnElement(ClickingCommoditygroupdropdown);
		Thread.sleep(2000);
		List<WebElement> commoditygrouplist = driver.findElements(optionscommgrouplist);
		List<String> actuallistBopEntry = new ArrayList<String>();
		for (WebElement flagcomvalue : commoditygrouplist) {

			actuallistBopEntry.add(flagcomvalue.getText().trim());

		}
		LoggerUtil.logger.info("Fetched Commodity Group values from BOP Entry: " + actuallistBopEntry);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		clickOnElement(clickcommoditydropdownCommoditygrouptab);
		Thread.sleep(2000);
		List<WebElement> commdrop = driver.findElements(fetchingcommoditygroupdropdataingrouptab);
		List<String> actuallistcommoditymaster = new ArrayList<String>();
		for (WebElement optioncomMaster : commdrop) {

			actuallistcommoditymaster.add(optioncomMaster.getText().trim());

		}

		LoggerUtil.info("Fetching Commoditygroup Value From CommodityMaster = " + actuallistcommoditymaster);

		Assert.assertEquals(actuallistBopEntry, actuallistcommoditymaster);

	}

	public static final By enterclassificationvalue = By.xpath("//input[@id='subGroupClassification']");
	public static final By enterspecificgrade = By.xpath("//input[@id='SpecificGradeText']");
	public static final By enterdensityvalue = By.xpath("//input[@id='groupDensity']");
	public static final By entercommoditynamefirstTabCommodityMaster = By.xpath("//input[@id='commodityGroup']");
	public static final By savebuttonfirsttabcommoditymaster = By.xpath("//button[@id='tab1Save']");
	public static final By savebuttonsecondtabcommoditygroup = By.xpath("//button[@id='tab2Save']");
	public static final By clickingclassficationdropdowninbopentry = By
			.xpath("//span[@id='select2-BopEntry_TypeofMaterialInhouse-container']");
	public static final By classificationlistBopentry = By
			.xpath("//ul[@id='select2-BopEntry_TypeofMaterialInhouse-results']/li");

	public void verifyCommodityGroupClassificationDependency(String commodityName, String classificationValue,
			String specificGradeValue, String densityValue) throws InterruptedException {
		try {
			LoggerUtil.info("Starting test: verifyCommodityGroupClassificationDependency");

			dashboard.clickOnAddcommodity();
			LoggerUtil.info("Clicked on Add Commodity");

			clearAndEnterText(waitForExpectedElement(entercommoditynamefirstTabCommodityMaster), commodityName);
			LoggerUtil.info("Entered Commodity Name: " + commodityName);

			clickOnElement(savebuttonfirsttabcommoditymaster);
			LoggerUtil.info("Clicked Save button on Commodity Master tab");
			Thread.sleep(7000);

			dashboard.clickOncommoditygroup();
			LoggerUtil.info("Navigated to Commodity Group tab");

			clickOnElement(clickcommoditydropdownCommoditygrouptab);
			LoggerUtil.info("Clicked Commodity dropdown in Commodity Group tab");
			Thread.sleep(8000);

			List<WebElement> commdrop = driver.findElements(fetchingcommoditygroupdropdataingrouptab);
			boolean commodityFound = false;

			Thread.sleep(8000);
			for (WebElement optionCommodityGroupList : commdrop) {
				if (optionCommodityGroupList.getText().trim().equals(commodityName)) {
					optionCommodityGroupList.click();
					LoggerUtil.pass("Selected commodity: " + commodityName);
					commodityFound = true;
					break;
				}
			}

			if (!commodityFound) {
				LoggerUtil.fail("Commodity not found in dropdown: " + commodityName);
			}

			clearAndEnterText(waitForExpectedElement(enterclassificationvalue), classificationValue);
			LoggerUtil.info("Entered Classification Value: " + classificationValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterspecificgrade), specificGradeValue);
			LoggerUtil.info("Entered Specific Grade Value: " + specificGradeValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterdensityvalue), densityValue);
			LoggerUtil.info("Entered Density Value: " + densityValue);
			Thread.sleep(3000);

			clickOnElement(savebuttonsecondtabcommoditygroup);
			LoggerUtil.info("Clicked Save button on Commodity Group tab");
			Thread.sleep(3000);

			dashboard.selectBopMaster();
			LoggerUtil.info("Selected BOP Master");
			Thread.sleep(7000);

			dashboard.clickingBopEntryTab();
			LoggerUtil.info("Clicked on BOP Entry Tab");
			Thread.sleep(25000);

			clickOnElement(ClickingCommoditygroupdropdown);
			LoggerUtil.info("Clicked Commodity Group dropdown in BOP Entry");
			Thread.sleep(25000);

			List<WebElement> commodityGroupList = driver.findElements(optionscommgrouplist);
			commodityFound = false;

			Thread.sleep(25000);
			for (WebElement commGroup : commodityGroupList) {
				if (commGroup.getText().trim().equals(commodityName)) {
					commGroup.click();
					LoggerUtil.pass("Commodity matched and selected in BOP Entry: " + commodityName);
					commodityFound = true;
					break;
				}
			}

			if (!commodityFound) {
				LoggerUtil.fail("Commodity not found in BOP Entry dropdown: " + commodityName);
			}

			clickOnElement(clickingclassficationdropdowninbopentry);
			LoggerUtil.info("Clicked Classification dropdown in BOP Entry");
			Thread.sleep(2000);

			List<WebElement> classificationList = driver.findElements(classificationlistBopentry);
			boolean classificationFound = false;

			for (WebElement optionClassification : classificationList) {
				if (optionClassification.getText().trim().equals(classificationValue)) {
					optionClassification.click();
					LoggerUtil.pass("Classification matched and selected in BOP Entry: " + classificationValue);
					classificationFound = true;
					break;
				}
			}

			if (!classificationFound) {
				LoggerUtil.fail("Classification not found in BOP Entry dropdown: " + classificationValue);
			}

			LoggerUtil.pass("Test verifyCommodityGroupClassificationDependency passed successfully.");

		} catch (Exception e) {
			LoggerUtil.fail(
					"Test verifyCommodityGroupClassificationDependency failed due to exception: " + e.getMessage());
			takeScreenshot("verifyCommodityGroupClassificationDependency", "");
		}
	}

	public static final By commodityDropdownlistincommoditydetails = By.xpath("//ul[@id='select2-commodityDrop-results']/li");
	public static final By commoditydropdownDomestic = By.xpath("//span[@id='select2-commodityDrop-container']");
	public static final By  verifydoemsticradiobtnforCommodityDetails = By.xpath("//input[@id='domesticR']");
	public static final By ClickingGroupclassificationdropdown = By.xpath("//span[@id='select2-materialDrop-container']");
	public static final By listcommoditygroupclassification = By.xpath("//ul[@id='select2-materialDrop-results']/li");
	public static final By clickingSpecificgradedropdown = By.xpath("//span[@id='select2-SpecificGrade-container']");
	public static final By listspecificgrade = By.xpath("//ul[@id='select2-SpecificGrade-results']/li");
	public static final By clickingUomdropdown = By.xpath("//span[@id='select2-uomDrop-container']");
	public static final By Listuomdropdown = By.xpath("//ul[@id='select2-uomDrop-results']/li");
	public static final By ClickingShapedropdown = By.xpath("//span[@id='select2-shapeDrop-container']");
	public static final By searchinputforshape = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By Listofshapedropdown = By.xpath("//ul[@id='select2-shapeDrop-results']/li");
	public static final By EntervalueinBasicCost = By.xpath("//input[@id='BasiccostD']");
	public static final By Enterfirststagefreightcost = By.xpath("//input[@id='Fright1st']");
	public static final By EnterConversioncost = By.xpath("//input[@id='ConversionCostD']");
	public static final By EnterDiscountAbsolute = By.xpath("//input[@id='txtDiscountAbsolute']");
	public static final By fetchinglandedcost = By.xpath("//input[@id='landedCost']");
	public static final By clickingbusinessSegbox = By.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/button");
	public static final By searchbarbusinessSeg = By.xpath("(//input[@placeholder='Search'])[1]");
	public static final By selectallcheckboxInbusinsessSeg = By.xpath("//div[@class='multiselect-container dropdown-menu show']/div/following-sibling::button/span/input[@value='multiselect-all']");
	public static final By Savebuttoncommoditydetails = By.xpath("//button[@id='tab3Save']"); 
	public void verifySavecommodityRmAndScrapWithSupplierItShouldAppearInBopEntryTab(String commodityName,
			String classificationValue, String specificGradeValue, String densityValue,String Enterbasiccostvalue) {
		try {
			LoggerUtil.info("Starting test: verifySavecommodityRmAndScrapWithSupplierItShouldAppearInBopEntryTab");

			dashboard.clickOnAddcommodity();
			LoggerUtil.info("Clicked on Add Commodity");

			clearAndEnterText(waitForExpectedElement(entercommoditynamefirstTabCommodityMaster), commodityName);
			LoggerUtil.info("Entered Commodity Name: " + commodityName);

			clickOnElement(savebuttonfirsttabcommoditymaster);
			LoggerUtil.info("Clicked Save button on Commodity Master tab");
			Thread.sleep(7000);

			dashboard.clickOncommoditygroup();
			LoggerUtil.info("Navigated to Commodity Group tab");

			clickOnElement(clickcommoditydropdownCommoditygrouptab);
			LoggerUtil.info("Clicked Commodity dropdown in Commodity Group tab");
			Thread.sleep(8000);

			List<WebElement> commdrop = driver.findElements(fetchingcommoditygroupdropdataingrouptab);
			boolean commodityFound = false;

			Thread.sleep(8000);
			for (WebElement optionCommodityGroupList : commdrop) {
				if (optionCommodityGroupList.getText().trim().equals(commodityName)) {
					optionCommodityGroupList.click();
					LoggerUtil.pass("Selected commodity: " + commodityName);
					commodityFound = true;
					break;
				}
			}

			if (!commodityFound) {
				LoggerUtil.fail("Commodity not found in dropdown: " + commodityName);
			}

			clearAndEnterText(waitForExpectedElement(enterclassificationvalue), classificationValue);
			LoggerUtil.info("Entered Classification Value: " + classificationValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterspecificgrade), specificGradeValue);
			LoggerUtil.info("Entered Specific Grade Value: " + specificGradeValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterdensityvalue), densityValue);
			LoggerUtil.info("Entered Density Value: " + densityValue);
			Thread.sleep(3000);

			clickOnElement(savebuttonsecondtabcommoditygroup);
			LoggerUtil.info("Clicked Save button on Commodity Group tab");
			Thread.sleep(5000);
			
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			clickOnElement(verifydoemsticradiobtnforCommodityDetails);
			Thread.sleep(200);
			 clickOnElement(commoditydropdownDomestic);	
			Thread.sleep(25000);
			 List<WebElement> thirdtabcommoditygrouplist = driver.findElements(commodityDropdownlistincommoditydetails);
			Thread.sleep(2000);
			 for(WebElement optioncommoditygroup:thirdtabcommoditygrouplist) {
				
				   String optionthirdtabcommoditygroup = optioncommoditygroup.getText().trim();
				   
				   if(optionthirdtabcommoditygroup.equals(commodityName)) {
					   
					   optioncommoditygroup.click();
					   
					   break;
					   
				   }
				
			}
			
			Thread.sleep(3000);

		    clickOnElement(ClickingGroupclassificationdropdown);
		    Thread.sleep(9000);
		    
			List<WebElement> optionclassification = driver.findElements(listcommoditygroupclassification);
			for(WebElement listvalueclassification:optionclassification) {
				
				String flagevalueclassification = listvalueclassification.getText().trim();
				
				if(flagevalueclassification.equals(classificationValue)) {
					
					listvalueclassification.click();
					break;
					
				}
				
			}
			
			Thread.sleep(4000);
			clickOnElement(clickingSpecificgradedropdown);
			Thread.sleep(3000);
			List<WebElement> optionspecificgradethirdtab = driver.findElements(listspecificgrade);
			for(WebElement listedspecificgradevalue :optionspecificgradethirdtab) {
				
				String flagevaluespecificgrade = listedspecificgradevalue.getText().trim();
				
				if(flagevaluespecificgrade.equals(specificGradeValue)) {
					
					listedspecificgradevalue.click();
					
					break;
				}
				
			}
			
			Thread.sleep(2000);
			clickOnElement(clickingUomdropdown);
			Thread.sleep(3000);
			List<WebElement> uomoptions = driver.findElements(Listuomdropdown);
			Thread.sleep(2000);
			selectBootStrapDropDown(uomoptions, "Kg");
			Thread.sleep(2000);
			
			
			Thread.sleep(2000);
			 clickOnElement(ClickingShapedropdown);
			    LoggerUtil.info("Clicked on Shape dropdown.");
			    
			    Thread.sleep(300);
			    WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			    clearAndEnterText(shapesearch, "Sheet");
			    shapesearch.sendKeys(Keys.ENTER);
			    LoggerUtil.info("Entered Shape as: Sheet");
			
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EntervalueinBasicCost), Enterbasiccostvalue);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(Enterfirststagefreightcost), Enterbasiccostvalue);
			Thread.sleep(2999);
			clearAndEnterText(waitForExpectedElement(EnterConversioncost), Enterbasiccostvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterDiscountAbsolute), Enterbasiccostvalue);
			
			Thread.sleep(3000);
			
			clickOnElement(clickingbusinessSegbox);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(searchbarbusinessSeg), "rishi");
			Thread.sleep(2000);
			clickOnElement(selectallcheckboxInbusinsessSeg);
			Thread.sleep(15000);
			clickOnElement(Savebuttoncommoditydetails);
			Thread.sleep(3000);
	

		} catch (Exception e) {
			LoggerUtil.fail(
					"Test verifySavecommodityRmAndScrapWithSupplierItShouldAppearInBopEntryTab failed due to exception: "
							+ e.getMessage());

		}
	}

	
	public static final By clickingsuppliernamecodedropdown = By.xpath("//span[@id='select2-BopEntry_SupplierInhouse-container']");  
	
	public static final By listvaluesuplliernamecode = By.xpath("//ul[@id='select2-BopEntry_SupplierInhouse-results']/li");
	public void verifyfetchingDataFromCommodityDetailsToBopMaster(String commodityName, String classificationValue) throws InterruptedException {
		
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		
	    try {
	        LoggerUtil.info("Starting test: verifyfetchingDataFromCommodityDetailsToBopMaster");

	        clickOnElement(ClickingCommoditygroupdropdown);
	        LoggerUtil.info("Clicked Commodity Group dropdown in BOP Entry");
	        Thread.sleep(25000);

	        List<WebElement> commodityGroupList = driver.findElements(optionscommgrouplist);
	        boolean commodityFound = false;

	        Thread.sleep(25000);
	        for (WebElement commGroup : commodityGroupList) {
	            if (commGroup.getText().trim().equals(commodityName)) {
	                commGroup.click();
	                LoggerUtil.pass("Commodity matched and selected in BOP Entry: " + commodityName);
	                commodityFound = true;
	                break;
	            }
	        }

	        if (!commodityFound) {
	            LoggerUtil.fail("Commodity not found in BOP Entry dropdown: " + commodityName);
	        }

	        clickOnElement(clickingclassficationdropdowninbopentry);
	        LoggerUtil.info("Clicked Classification dropdown in BOP Entry");
	        Thread.sleep(15000);

	        List<WebElement> classificationList = driver.findElements(classificationlistBopentry);
	        boolean classificationFound = false;

	        for (WebElement optionClassification : classificationList) {
	            if (optionClassification.getText().trim().equals(classificationValue)) {
	                optionClassification.click();
	                LoggerUtil.pass("Classification matched and selected in BOP Entry: " + classificationValue);
	                classificationFound = true;
	                break;
	            }
	        }

	        if (!classificationFound) {
	            LoggerUtil.fail("Classification not found in BOP Entry dropdown: " + classificationValue);
	        }

	        LoggerUtil.pass("Test verifyfetchingDataFromCommodityDetailsToBopMaster executed successfully.");

	    } catch (Exception e) {
	        LoggerUtil.fail("Test verifyfetchingDataFromCommodityDetailsToBopMaster failed due to exception: " + e.getMessage());
	    }
	    
	    
	    Thread.sleep(3000);
	    clickOnElement(clickingsuppliernamecodedropdown);
	    Thread.sleep(3000);
	    List<WebElement> Listsupplier = driver.findElements(listvaluesuplliernamecode);
	    for(WebElement optionsuppliervalue:Listsupplier) {
	    	
	    	String flagesuppliervalue = optionsuppliervalue.getText().trim();
	    	
	    	if(flagesuppliervalue.equals("0801")) {
	    		
	    		optionsuppliervalue.click();
	    		break;
	    		
	    		
	    	}
	    			
	    	
	    }
	    
	    Thread.sleep(19000);
	    
	}

		
	public static final By RmCostField = By.xpath("//input[@id='RmCostInHouse']");

	
	public void verifyRmCostIsReadOnly() {
	    try {
	        LoggerUtil.info("Starting test: verifyRmCostIsReadOnly");

	        WebElement rmCostField = waitForExpectedElement(RmCostField);

	        String readonlyAttr = rmCostField.getAttribute("readonly");

	        // Updated condition
	        if (readonlyAttr != null && (readonlyAttr.equals("true") || readonlyAttr.equals("readonly"))) {
	            LoggerUtil.pass("RM Cost field is correctly set as read-only.");
	        } else {
	            LoggerUtil.fail("RM Cost field is writable, expected read-only.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.fail("Test verifyRmCostIsReadOnly failed due to exception: " + e.getMessage());
	    }
	}

		

	
	
	public static final By textheadingBop = By.xpath("(//label[@for='BOP_Type'])[2]");
	public static final By textheadingpartdescription = By.xpath("(//label[@for='Part_Description'])[1]");
	public static final By textheadingpartnumber = By.xpath("//label[@for='BopEntry_PartNoInHouse']");
	public static final By textheadinguom = By.xpath("//label[@for='BopEntry_UomInHouse']");
	public static final By textheadingsuppliername = By.xpath("//label[@id='Supplierdata1']");
	public static final By textheadingcommoditygroupname = By.xpath("//label[@for='BopEntry_CommodityGroupInhouse']");
	public static final By textheadingRmgroupAndClassification = By
			.xpath("//label[@for='BopEntry_TypeofMaterialInhouse']");
	public static final By textheadforRmSpecificAndGrade = By.xpath("//label[@for='BopEntry_RmGrade']");

	public static final By textheadingforRmRateKg = By.xpath("//label[@for='BopEntry_RmRateInHouse']");
	public static final By textheadingforscrapcost = By.xpath("//label[@for='BopEntry_ScrapCostInHouse']");
	public static final By textheadingforfinishWt = By.xpath("//label[@for='BopEntry_FinishWtInHouse']");

	public static final By textheadingprocesscost = By.xpath("//label[@for='BopEntry_ProcessCostInHouse']");
	public static final By textheadingtotalcost = By.xpath("//label[@for='BopEntry_PartCostInHouse']");

	public static final By textheadinggrossweight = By.xpath("//label[@for='BopEntry_GrossWtInHouse']");

	public static final By textheadingRmCost = By.xpath("//label[@for='BopEntry_RmCostInHouse']");
	public static final By textheadingothercost = By.xpath("//label[@for='BopEntry_OtherCostInHouse']");	
	
	public static final By clickingUIExportButton = By.xpath("//button[@class='btn btn-primary pull-right']");
    public static final By clickingExportButtonforDownload = By.xpath("//button[@id='exportOldButton']"); 
	
    public void verifyAlldataMatchesInExcelSheetColom() throws InterruptedException {
        List<String> uiheadings = new ArrayList<>();
        uiheadings.add(waitForExpectedElement(textheadingBop).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingpartdescription).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingpartnumber).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadinguom).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingsuppliername).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingcommoditygroupname).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingRmgroupAndClassification).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadforRmSpecificAndGrade).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingforRmRateKg).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingforscrapcost).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadinggrossweight).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingforfinishWt).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingRmCost).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingprocesscost).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingothercost).getText().trim());
        uiheadings.add(waitForExpectedElement(textheadingtotalcost).getText().trim());

        Thread.sleep(3000);
        clickOnElement(clickingUIExportButton);
        Thread.sleep(8000);
        clickOnElement(clickingExportButtonforDownload);
        Thread.sleep(3000);

        File file = null;
        int attempts = 0;
        while ((file == null || file.getName().startsWith("~$")) && attempts < 10) {
            Thread.sleep(1000);
            file = getLatestBOPProcurementInhouseFile();
            attempts++;
        }

        List<String> excelHeadings = readExcelHeaderRow(file);

        for (int i = 0; i < uiheadings.size(); i++) {
            String uiHeading = uiheadings.get(i);
            String excelHeading = (i < excelHeadings.size()) ? excelHeadings.get(i) : "MISSING";

            if (uiHeading.equalsIgnoreCase(excelHeading)) {
                LoggerUtil.pass("Matched at column " + (i + 1) + ": UI = '" + uiHeading + "'");
            } else {
                LoggerUtil.fail("Mismatch at column " + (i + 1) + ": UI = '" + uiHeading + "', Excel = '" + excelHeading + "'");
            }
        }
    }

    public List<String> readExcelHeaderRow(File file) {
        List<String> headings = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            Sheet sheet = workbook.getSheetAt(0);

            int detectedHeaderRowIndex = detectHeaderRow(sheet);
            LoggerUtil.info("Detected Excel header row index: " + detectedHeaderRowIndex);
            Row row = sheet.getRow(detectedHeaderRowIndex);

            if (row == null) {
                LoggerUtil.fail("Header row not found at detected index: " + detectedHeaderRowIndex);
                return headings;
            }

            for (int col = 1; col <= 17; col++) { // 17 columns A to Q
                Cell cell = row.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String value = getCellValueWithEval(cell, evaluator);
                headings.add(value.trim());
            }

        } catch (Exception e) {
            LoggerUtil.fail("Error reading header row: " + e.getMessage());
        }

        return headings;
    }

    public String getCellValueWithEval(Cell cell, FormulaEvaluator evaluator) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                CellValue evaluated = evaluator.evaluate(cell);
                if (evaluated == null) return "";
                switch (evaluated.getCellType()) {
                    case STRING:
                        return evaluated.getStringValue();
                    case NUMERIC:
                        return String.valueOf(evaluated.getNumberValue());
                    case BOOLEAN:
                        return String.valueOf(evaluated.getBooleanValue());
                    default:
                        return "";
                }
            default:
                return "";
        }
    }

    public int detectHeaderRow(Sheet sheet) {
        for (int i = 0; i <= 10; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            int nonEmptyCount = 0;
            for (int c = 0; c <= 16; c++) {
                Cell cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (!cell.toString().trim().isEmpty()) {
                    nonEmptyCount++;
                }
            }

            // Skip merged/title row (e.g., BOP InHouse Details)
            if (nonEmptyCount >= 8) {
                String firstCell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                if (firstCell.trim().equalsIgnoreCase("S.No.") || firstCell.toLowerCase().contains("part") || firstCell.toLowerCase().contains("bop")) {
                    return i;
                }
            }
        }
        return 0; // fallback
    }


	public static final By fetchingdatafromui = By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]");
	public static final By searchbox = By
			.xpath("//div[@id='table1_filter']/label/input[@class='form-control form-control-sm']");

	public static final By crossbuttonExportimport = By.xpath("//div[@id='BOPiddpopupexp']/div/div[@class='modal-content']/div/button[@class='btn-close']");
	public void verifiyReadData() throws InterruptedException, IOException {
	    Thread.sleep(3000);
	    clickOnElement(clickingUIExportButton);
	    Thread.sleep(8000);
	    clickOnElement(clickingExportButtonforDownload);
	    Thread.sleep(7000);
	    
	    clickOnElement(crossbuttonExportimport);
	    Thread.sleep(2000);

	    WebElement search = waitForExpectedElement(searchbox);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", search);
	    Thread.sleep(3000);
	    search.clear();
	    search.sendKeys("inhouse");

	    Thread.sleep(4000);
	    String actualdataBopTypeFromUi = waitForExpectedElement(fetchingdatafromui).getText();
	    System.out.println(actualdataBopTypeFromUi);

	    File latestFile = getLatestBOPProcurementInhouseFile(); // ✅ Fix
	    LoggerUtil.pass("✅ File downloaded: " + latestFile.getName());

	    readRow3ColumnsAtoR(latestFile.getAbsolutePath()); // ✅ Fix
	}

	public static void readRow3ColumnsAtoR(String filePath) {
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheetAt(0);  // first sheet
	        Row row = sheet.getRow(2);  // Row 3 (0-based index)

	        if (row == null) {
	            LoggerUtil.error("Row 3 is empty or missing.");
	            return;
	        }

	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	        StringBuilder rowData = new StringBuilder();

	        for (int col = 0; col <= 17; col++) {  // A to R
	            Cell cell = row.getCell(col);
	            String cellValue = getEvaluatedValue(cell, evaluator);
	            rowData.append(cellValue).append(" | ");
	        }

	        // ✅ Add this block for assertion and report
	        Assert.assertTrue(rowData.toString().contains("InHouse"), "❌ 'InHouse' value not found in Row 3");
	        LoggerUtil.pass("✅ 'InHouse' text is present in the exported Excel row");

	        LoggerUtil.pass("✅ Extracted Row Data: 📄 Row 3 Data: " + rowData.toString());

	    } catch (Exception e) {
	        LoggerUtil.error("❌ Error reading Excel: " + e.getMessage());
	    }
	}

	public static String getCellValueAsString(Cell cell) {
	    if (cell == null) return "";
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue().trim();
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue().toString();
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula();
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
	}


	private static String getEvaluatedValue(Cell cell, FormulaEvaluator evaluator) {
	    if (cell == null) return "";
	    CellType cellType = cell.getCellType();

	    if (cellType == CellType.FORMULA) {
	        CellValue evaluated = evaluator.evaluate(cell);
	        switch (evaluated.getCellType()) {
	            case STRING: return evaluated.getStringValue().trim();
	            case NUMERIC: return String.valueOf(evaluated.getNumberValue());
	            case BOOLEAN: return String.valueOf(evaluated.getBooleanValue());
	            default: return "";
	        }
	    } else {
	        return getCellValueAsString(cell); // your existing helper
	    }
	}

    
    
    public static final By toastmsg = By.xpath("//*[@id='toast-container']/div/div[2]");
    
    public void verifytoastmsg () throws InterruptedException {
    	
    	 Thread.sleep(3000);
 	    clickOnElement(clickingUIExportButton);
 	    Thread.sleep(8000);
 	    clickOnElement(clickingExportButtonforDownload);
 	    Thread.sleep(5000);
 	    String actualtoastmsg = waitForExpectedElement(toastmsg).getText();
 	    String expectedtoastmsg = "File exported successfully";
 	    Assert.assertEquals(actualtoastmsg, expectedtoastmsg);
    	
    	
    	
    }
    
    public static final By clickRadioButtonforNewExportingNewButton = By.xpath("//input[@id='BOPflexRadioDefault2']");
    public static final By clickingbusinessSegmentFromBopEntry = By.xpath("//select[@id='supBusinessSegments']/following-sibling::div/button/span");
    public static final By clickingcheckboxbusinessSegMent = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button[2]/span/input");
    public static final By clickingsavebutton = By.xpath("//button[@id='supplierSave']");
    public static final By clickingsupplierDropdown = By.xpath("//select[@id='suppdropdownBOP']/following-sibling::div/button");
    public static final By searchvaluesupplier = By.xpath("(//div[@class='multiselect-filter d-flex align-items-center']/input[@class='multiselect-search form-control'])[1]");
    public static final By supplieroptions = By.xpath("//select[@id='suppdropdownBOP']/option");
    public static final By clickingSuppliercheckbox = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button[3]/span/input");
    public static final By clickingExportAfterSelectingSuppplier = By.xpath("//button[@id='exportButtonBop']");
    public void importExcelfillMissingMandatoryField( ) throws InterruptedException {
    	
   
    clickOnElement(clickingUIExportButton);	
    Thread.sleep(9000); 
    clickOnElement(clickRadioButtonforNewExportingNewButton);	
    Thread.sleep(2000);
    clickOnElement(clickingsupplierDropdown);
    Thread.sleep(10000);
    //Mathildewiim-37-
      clickOnElement(clickingSuppliercheckbox);
   
  
    	clickOnElement(clickingExportAfterSelectingSuppplier);
    
    
    Thread.sleep(5000);
    
    String filePath = FillingBopProcurement(); 
    Thread.sleep(8000);
    Thread.sleep(8000);
    clickOnElement(crossbuttonExportimport);
    Thread.sleep(5000);
    UploadExcelfileWithMissingMandatoryField();
    
    
    }
    
    public String FillingBopProcurement() throws InterruptedException {
    	
    	Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementInhouseFile();
		if (latestFile == null) {
			System.out.println("No BOPProcurementInhouse file found.");
			return null;
		}
    	
		String filePath = latestFile.getAbsolutePath();
    	
		String bopdropdown = "Bolt";
		String childprtdes = faker.letterify("????");
		int randomint = faker.number().numberBetween(10, 90);
		String partno = String.valueOf(randomint);
		String Commoditydropdown = "Ferrous Metals";
		String Rmgroupclassificationdropdown = "Steel";
		String specificgrade = "CRCA-1";
		String grosswt = "Kg";
		String finishwt = "Kg";
		String processcost = "50";
		String othercost = "10";
		
		ExcelFiller.setCellValue(filePath, 0, 2, 1,ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 2, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(partno));		
		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN,Arrays.asList(Commoditydropdown) );
		ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade));
		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING,Arrays.asList(grosswt));
		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));
		ExcelFiller.setCellValue(filePath, 0, 2, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));
		ExcelFiller.setCellValue(filePath, 0, 2, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));
	
		return latestFile.getAbsolutePath();
		
		
		
    	
    }
    
    
    public static final By importbtn = By.xpath("(//input[@id='excelUpload'])[1]");
    
    
    public void UploadExcelfileWithMissingMandatoryField() throws InterruptedException {
        String filePath = FillingBopProcurement();  // Get the filled Excel file path
        if (filePath == null) {
            LoggerUtil.error("❌ Excel file path not found. Cannot proceed with upload.");
            return;
        }

        LoggerUtil.info("🟢 Step: Uploading file with missing mandatory fields...");

        //  Make hidden file input visible using JavaScript
        WebElement uploadInput = driver.findElement(By.id("excelUpload"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);

        // Use sendKeys directly (no waitForExpectedElement, it's hidden originally)
        uploadInput.sendKeys(filePath);

        //  Optionally, re-hide the input after upload
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

        Thread.sleep(4000);  // Wait for processing

        //  Validate toast or error
        String expectedErrorPart = "Input string was not in a correct format.";
        String toastText = waitForExpectedElement(toastmsg).getText();

        if (toastText.toLowerCase().contains(expectedErrorPart.toLowerCase())) {
            LoggerUtil.pass("Invalid popup getting = " + toastText);
        } else {
            LoggerUtil.fail("❌ Unexpected toast after Excel upload: " + toastText);
        }
    }


    
    public void importExcelFileWithInvalidDataType( ) throws InterruptedException {
    	
    	   
        clickOnElement(clickingUIExportButton);	
        Thread.sleep(9000); 
        clickOnElement(clickRadioButtonforNewExportingNewButton);	
        Thread.sleep(2000);
        clickOnElement(clickingsupplierDropdown);
        Thread.sleep(10000);
        //Mathildewiim-37-
          clickOnElement(clickingSuppliercheckbox);
       
      
        	clickOnElement(clickingExportAfterSelectingSuppplier);
        
        
        Thread.sleep(5000);
        
        String filePath = InvalidDataTypeFillingBopProcurement(); 
        Thread.sleep(8000);
        Thread.sleep(8000);
        clickOnElement(crossbuttonExportimport);
        Thread.sleep(5000);
        
        UploadExcelfileWithInvalidDataType();
        
        }

    public String InvalidDataTypeFillingBopProcurement() throws InterruptedException {

    	Thread.sleep(3000);
    	File latestFile = getLatestBOPProcurementInhouseFile();
    	if (latestFile == null) {
    		System.out.println("No Bop Master file found.");
    		return null;
    	}

    	String filePath = latestFile.getAbsolutePath();

    	// Your static test data
    	String bopdropdown = "Bolt";
    	String childprtdes = faker.letterify("????");
    	int randomint = faker.number().numberBetween(10, 90);
    	String partno = String.valueOf(randomint);
    	String Uom = "Rs.@@@";
    	String suppliername = "0801-Celesta";
    	String Commoditydropdown = "Ferrous Metals";
    	String Rmgroupclassificationdropdown = "Steel";
    	String specificgrade = "CRCA-1";
    	String grosswt = "@@";
    	String finishwt = "@34";
    	String processcost = "pmth";
    	String othercost = "xyzz";

    	// Corrected column mappings (skipping S.No.)
    	ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));  // BOP *
    	ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));   // Child Part Desc *
    	ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));        // Part No. *
    	ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Uom));         // UOM *
    	ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppliername));// Supplier *
    	ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Commoditydropdown)); // Commodity Group *
    	ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown)); // RM Group Classification *
    	ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade)); // RM Specific Grade *
    	ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(grosswt));       // Gross Wt (Kgs)
    	ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));      // Finish Wt (Kgs)
    	ExcelFiller.setCellValue(filePath, 0, 2, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));   // Process Cost *
    	ExcelFiller.setCellValue(filePath, 0, 2, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));     // Other Cost *

    	return latestFile.getAbsolutePath();
    }

 public void UploadExcelfileWithInvalidDataType() throws InterruptedException {
     String filePath = InvalidDataTypeFillingBopProcurement();  // Get the filled Excel file path
     if (filePath == null) {
         LoggerUtil.error("❌ Excel file path not found. Cannot proceed with upload.");
         return;
     }

     LoggerUtil.info("🟢 Step: Uploading file with Duplicate Data");

     //  Make hidden file input visible using JavaScript
     WebElement uploadInput = driver.findElement(By.id("excelUpload"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);

     // Use sendKeys directly (no waitForExpectedElement, it's hidden originally)
     uploadInput.sendKeys(filePath);

     //  Optionally, re-hide the input after upload
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

     Thread.sleep(4000);  // Wait for processing

     //  Validate toast or error
     String expectedErrorPart = "Input string was not in a correct format.";
     String toastText = waitForExpectedElement(toastmsg).getText();

     if (toastText.toLowerCase().contains(expectedErrorPart.toLowerCase())) {
         LoggerUtil.pass("Invalid popup getting = " + toastText);
     } else {
         LoggerUtil.fail("❌ Unexpected toast after Excel upload: " + toastText);
     }
 }

 
    public void verifyImportDuplicateData() throws InterruptedException {
    	
    	
    	clickOnElement(clickingUIExportButton);	
        Thread.sleep(9000); 
        clickOnElement(clickRadioButtonforNewExportingNewButton);	
        Thread.sleep(2000);
        clickOnElement(clickingsupplierDropdown);
        Thread.sleep(10000);
        //Mathildewiim-37-
          clickOnElement(clickingSuppliercheckbox);
       
      
        	clickOnElement(clickingExportAfterSelectingSuppplier);
        
        
        Thread.sleep(5000);
    	
        FillingDuplicateDataInExcelSheet();
        Thread.sleep(8000);
        
        UploadExcelfileWithDuplicateData();
        
        
    }
 
 
 
 public String FillingDuplicateDataInExcelSheet() throws InterruptedException {
	 
		Thread.sleep(3000);
    	File latestFile = getLatestBOPProcurementInhouseFile();
    	if (latestFile == null) {
    		System.out.println("No Bop Master file found.");
    		return null;
    	}

    	String filePath = latestFile.getAbsolutePath();

    	String bopdropdown = "Bolt";
    	String childprtdes = "M 171 bolt ";
    	int randomint = faker.number().numberBetween(10, 90);
    	String partno = String.valueOf(randomint);
    	String Uom = "Rs.";
    	String suppliername = "0801-Celesta";
    	String Commoditydropdown = "Ferrous Metals";
    	String Rmgroupclassificationdropdown = "Steel";
    	String specificgrade = "CRCA-1";
    	String grosswt = "3";
    	String finishwt = "2";
    	String processcost = "0";
    	String othercost = "0";

    	ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));  // BOP *
    	
    	ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));   // Child Part Desc *
    	ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));        // Part No. *
    	ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Uom));         // UOM *
    	ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppliername));// Supplier *
    	ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Commoditydropdown)); // Commodity Group *
    	ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown)); // RM Group Classification *
    	ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade)); // RM Specific Grade *
    	ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(grosswt));       // Gross Wt (Kgs)
    	ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));      // Finish Wt (Kgs)
    	ExcelFiller.setCellValue(filePath, 0, 2, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));   // Process Cost *
    	ExcelFiller.setCellValue(filePath, 0, 2, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));     // Other Cost *

    	LoggerUtil.info("User Enter The Same Value In Next Row ");
        ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));  // BOP *   	
    	ExcelFiller.setCellValue(filePath, 0, 3, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));   // Child Part Desc *
    	ExcelFiller.setCellValue(filePath, 0, 3, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));        // Part No. *
    	ExcelFiller.setCellValue(filePath, 0, 3, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Uom));         // UOM *
    	ExcelFiller.setCellValue(filePath, 0, 3, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppliername));// Supplier *
    	ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Commoditydropdown)); // Commodity Group *
    	ExcelFiller.setCellValue(filePath, 0, 3, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown)); // RM Group Classification *
    	ExcelFiller.setCellValue(filePath, 0, 3, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade)); // RM Specific Grade *
    	ExcelFiller.setCellValue(filePath, 0, 3, 12, ExcelFiller.ValueType.STRING, Arrays.asList(grosswt));       // Gross Wt (Kgs)
    	ExcelFiller.setCellValue(filePath, 0, 3, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));      // Finish Wt (Kgs)
    	ExcelFiller.setCellValue(filePath, 0, 3, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));   // Process Cost *
    	ExcelFiller.setCellValue(filePath, 0, 3, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));     // Other Cost *
    	return latestFile.getAbsolutePath();
    }
 
 
 
 public void UploadExcelfileWithDuplicateData() throws InterruptedException {
     String filePath = FillingDuplicateDataInExcelSheet();  // Get the filled Excel file path
     if (filePath == null) {
         LoggerUtil.error("❌ Excel file path not found. Cannot proceed with upload.");
         return;
     }

     LoggerUtil.info("🟢 Step: Uploading file with invalid Data Type");

     //  Make hidden file input visible using JavaScript
     WebElement uploadInput = driver.findElement(By.id("excelUpload"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);

     // Use sendKeys directly (no waitForExpectedElement, it's hidden originally)
     uploadInput.sendKeys(filePath);

     //  Optionally, re-hide the input after upload
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

     Thread.sleep(4000);  // Wait for processing

     //  Validate toast or error
     String expectedErrorPart = "Duplicate Data Could Not Upload.";
     String toastText = waitForExpectedElement(toastmsg).getText();

     if (toastText.toLowerCase().contains(expectedErrorPart.toLowerCase())) {
         LoggerUtil.pass("Invalid popup getting = " + toastText);
     } else {
         LoggerUtil.fail("❌ Unexpected toast after Excel upload: " + toastText);
     }
 }

 public void verifyImportInvalidDropdown() throws InterruptedException {
 	
 	
 	clickOnElement(clickingUIExportButton);	
     Thread.sleep(9000); 
     clickOnElement(clickRadioButtonforNewExportingNewButton);	
     Thread.sleep(2000);
     clickOnElement(clickingsupplierDropdown);
     Thread.sleep(10000);
     //Mathildewiim-37-
       clickOnElement(clickingSuppliercheckbox);
    
   
     	clickOnElement(clickingExportAfterSelectingSuppplier);
     
     
     Thread.sleep(5000);
     importingFileWithInvalidDropdowns();
     
     Thread.sleep(8000);
     
     UploadExcelfileWithInValidDropdownValues();
     
     
 }
 public String importingFileWithInvalidDropdowns() throws InterruptedException {
	 
	 Thread.sleep(3000);
 	File latestFile = getLatestBOPProcurementInhouseFile();
 	if (latestFile == null) {
 		System.out.println("No Bop Master file found.");
 		return null;
 	}

 	String filePath = latestFile.getAbsolutePath();

 	String bopdropdown = "Bo";
 	String childprtdes = "M 171 bolt ";
 	int randomint = faker.number().numberBetween(10, 90);
 	String partno = String.valueOf(randomint);
 	String Uom = "Rs@@.";
 	String suppliername = "0801-Celesta@@@";
 	String Commoditydropdown = "Ferrous Metals@!#";
 	String Rmgroupclassificationdropdown = "Steel111!!!!";
 	String specificgrade = "CRCA1";
 	String grosswt = "3";
 	String finishwt = "2";
 	String processcost = "0";
 	String othercost = "0";
	 
 	ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));  // BOP *	
	ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));   // Child Part Desc *
	ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));        // Part No. *
	ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Uom));         // UOM *
	ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppliername));// Supplier *
	ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Commoditydropdown)); // Commodity Group *
	ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown)); // RM Group Classification *
	ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade)); // RM Specific Grade *
	ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(grosswt));       // Gross Wt (Kgs)
	ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));      // Finish Wt (Kgs)
	ExcelFiller.setCellValue(filePath, 0, 2, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));   // Process Cost *
	ExcelFiller.setCellValue(filePath, 0, 2, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));     // Other Cost *
	 
	return latestFile.getAbsolutePath();
	 
 }
 
 public void UploadExcelfileWithInValidDropdownValues() throws InterruptedException {
     String filePath = importingFileWithInvalidDropdowns();  // Get the filled Excel file path
     if (filePath == null) {
         LoggerUtil.error("❌ Excel file path not found. Cannot proceed with upload.");
         return;
     }

     LoggerUtil.info("🟢 Step: Uploading file with invalid Data Type");

     //  Make hidden file input visible using JavaScript
     WebElement uploadInput = driver.findElement(By.id("excelUpload"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);

     // Use sendKeys directly (no waitForExpectedElement, it's hidden originally)
     uploadInput.sendKeys(filePath);

     //  Optionally, re-hide the input after upload
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

     Thread.sleep(4000);  // Wait for processing

     //  Validate toast or error
     String expectedErrorPart = "Invalid Data In Sheet.";
     String toastText = waitForExpectedElement(toastmsg).getText();

     if (toastText.toLowerCase().contains(expectedErrorPart.toLowerCase())) {
         LoggerUtil.pass("Invalid popup getting = " + toastText);
     } else {
         LoggerUtil.fail("❌ Unexpected toast after Excel upload: " + toastText);
     }
 }

 
	public void importWithInvalidPartNumeberExcelFile() throws InterruptedException {

		clickOnElement(clickingUIExportButton);
		Thread.sleep(9000);
		clickOnElement(clickRadioButtonforNewExportingNewButton);
		Thread.sleep(2000);
		clickOnElement(clickingsupplierDropdown);
		Thread.sleep(10000);
		
		clickOnElement(clickingSuppliercheckbox);

		clickOnElement(clickingExportAfterSelectingSuppplier);

		Thread.sleep(5000);

		fillingInvalidPartNo();
		Thread.sleep(4000);
		UploadExcelfileWithInvalidPartNumber();
		
	}
 
 
 public String fillingInvalidPartNo() throws InterruptedException {
	Thread.sleep(3000);
	File latestFile = getLatestBOPProcurementInhouseFile();
	if (latestFile == null) {
		System.out.println("No Bop Master file found.");
		return null;
	}

	String filePath = latestFile.getAbsolutePath();

	String bopdropdown = "Bolt";
	String childprtdes = "M 171 bolt ";
	int randomint = faker.number().numberBetween(10, 90);
	String partno = "@@@###@#$&*";
	String Uom = "Rs.";
	String suppliername = "0801-Celesta";
	String Commoditydropdown = "Ferrous Metals";
	String Rmgroupclassificationdropdown = "Steel";
	String specificgrade = "CRCA-1";
	String grosswt = "3";
	String finishwt = "2";
	String processcost = "0";
	String othercost = "0";

	ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));  // BOP *
	
	ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));   // Child Part Desc *
	ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.STRING, Arrays.asList(partno));        // Part No. *
	ExcelFiller.setCellValue(filePath, 0, 2, 5, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Uom));         // UOM *
	ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(suppliername));// Supplier *
	ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Commoditydropdown)); // Commodity Group *
	ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown)); // RM Group Classification *
	ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade)); // RM Specific Grade *
	ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING, Arrays.asList(grosswt));       // Gross Wt (Kgs)
	ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));      // Finish Wt (Kgs)
	ExcelFiller.setCellValue(filePath, 0, 2, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));   // Process Cost *
	ExcelFiller.setCellValue(filePath, 0, 2, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));     // Other Cost *

	return latestFile.getAbsolutePath();
 
 
 }
 
 
 public void UploadExcelfileWithInvalidPartNumber() throws InterruptedException {
     String filePath = fillingInvalidPartNo();  // Get the filled Excel file path
     if (filePath == null) {
         LoggerUtil.error(" Excel file path not found. Cannot proceed with upload.");
         return;
     }

     LoggerUtil.info(" Step: Uploading file with invalid Data ");

     //  Make hidden file input visible using JavaScript
     WebElement uploadInput = driver.findElement(By.id("excelUpload"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);

     // Use sendKeys directly (no waitForExpectedElement, it's hidden originally)
     uploadInput.sendKeys(filePath);

     
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

     Thread.sleep(4000);  // Wait for processing

     //  Validate toast or error
     String expectedErrorPart = "Input string was not in a correct format.";
     String toastText = waitForExpectedElement(toastmsg).getText();

     if (toastText.toLowerCase().contains(expectedErrorPart.toLowerCase())) {
         LoggerUtil.pass("Invalid popup getting = " + toastText);
     } else {
         LoggerUtil.fail(" Unexpected toast after Excel upload: " + toastText);
     }
 }

 
 
 
 
    public static final By verifydefaultvalueofBopCategory = By.xpath("//span[@id='select2-BopEntry_BopEntryType-container']");
    public void verifyDefaultValueinBopCategory() throws InterruptedException {
        LoggerUtil.info("🔍 Step: Verifying default value in BOP Category dropdown...");

        Thread.sleep(2000);
   	 clickOnElement(RadioButtonClickingCustomerSales);
   	 Thread.sleep(2000);

        String actualDefaultValueBopCategory = waitForExpectedElement(verifydefaultvalueofBopCategory).getText().trim();
        String expectedDefaultValueBopCategory = "InHouse";

        if (actualDefaultValueBopCategory.equals(expectedDefaultValueBopCategory)) {
            LoggerUtil.pass("✅ Default value for BOP Category is as expected: '" + actualDefaultValueBopCategory + "'");
        } else {
            LoggerUtil.fail("❌ Mismatch in default BOP Category. Expected: '" + expectedDefaultValueBopCategory +
                            "', but found: '" + actualDefaultValueBopCategory + "'");
            Assert.fail("Mismatch in default BOP Category.");
        }
    }

 
 
 
    public static final By RadioButtonClickingCustomerSales = By.xpath("//input[@id='BopEntry_RadioButtonsupplier' and @data-val-number='The field RadioButtonsupplier must be a number.']");
    public static final By clickingUomDropDown = By.xpath("//span[@id='select2-BopEntry_UomInHouse-container']"); 
    public static final By uomdroplist = By.xpath("//ul[@id='select2-BopEntry_UomInHouse-results']/li");
     public void UomDropdownBehaviour() throws InterruptedException {
    	 
    	 Thread.sleep(2000);
    	 clickOnElement(RadioButtonClickingCustomerSales);
    	 Thread.sleep(2000);
    	 clickOnElement(clickingUomDropDown);
    	 Thread.sleep(2000);
    	 
    	 List<WebElement> optiondropUom = driver.findElements(uomdroplist);
    	 ArrayList<String> actualList = new ArrayList<String>();
    	 
    	 for(WebElement flagvalue:optiondropUom) {
    		 
    		 actualList.add(flagvalue.getText().trim());
    		 
    	 }
    	List<String> sortedlist = new ArrayList<String>(actualList);
    	Collections.sort(sortedlist,String.CASE_INSENSITIVE_ORDER);
    	
    	
    	LoggerUtil.info("After Sorting The List = " +sortedlist);
    	LoggerUtil.info("Before Sorting The List = "+actualList);
    	
    	Assert.assertEquals(sortedlist, actualList);
    	
    	
    	
    	 
    	 
     }

	public static final By Boptypedropdownlist = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li");
 public static final By BopdropdownlistForCustomerRadio = By.xpath("//ul[@id='select2-BopEntry_BopType-results']/li"); 
  public void verifyBopTypeDropDown() throws InterruptedException {
	 
	  clickOnElement(RadioButtonClickingCustomerSales);
	  Thread.sleep(2000);
	  clickOnElement(ClickOnBopTypeDropdown);
	 Thread.sleep(2000);
	 List<WebElement>  optionsBoptypedropdown = driver.findElements(Boptypedropdownlist); 
	 ArrayList<String> actuallist = new ArrayList<String>();
	 
	 for(WebElement listBoptype:optionsBoptypedropdown) {
		 
		 actuallist.add(listBoptype.getText().trim());
	 }
		 List<String> sortedlist = new ArrayList<String>(actuallist);
		 Collections.sort(sortedlist,String.CASE_INSENSITIVE_ORDER);
		 
		 LoggerUtil.info("Befor Sorting Bop Type Dropdown list = " +actuallist);
		 LoggerUtil.info("After Sorting Bop Type Dropdown list = " +sortedlist);
  
  }
 
 
 
    public void verifyNumericValueEnteringBopTypeFirstTab(String EnterBopValue) throws InterruptedException {
    	
    	clearAndEnterText(waitForExpectedElement(EnterBopTypeForFirstTab), EnterBopValue);
    	Thread.sleep(2000);
    	clickOnElement(SaveButtonBopTypeInFirstTab);
    	
    	
    	
    	
    }
 
    public static final By Entringpartnumber = By.xpath("//input[@id='BopEntry_PartNoInHouse']");

	public void verifyNumericValueEnterInSecondTab(String Boptypevalue, String EnteringValueinPartDescription,
			String EnteringValueinpartnumber, String enteruomdropdownvalue) throws InterruptedException {
		clickOnElement(RadioButtonClickingCustomerSales);
		Thread.sleep(2000);
		clickOnElement(ClickOnBopTypeDropdown);
		Thread.sleep(3000);

		List<WebElement> optionsBoptypedropdown = driver.findElements(Boptypedropdownlist);

		Thread.sleep(3000);
		for (WebElement flagvalue : optionsBoptypedropdown) {

			String listvalue = flagvalue.getText().trim();

			if (listvalue.equals(Boptypevalue)) {

				flagvalue.click();
				break;

			}
		}

		clearAndEnterText(waitForExpectedElement(EnterValuePartdescription), EnteringValueinPartDescription);

		Thread.sleep(200);
		clearAndEnterText(waitForExpectedElement(Entringpartnumber), EnteringValueinpartnumber);
		Thread.sleep(200);
		clickOnElement(clickingUomDropDown);
		Thread.sleep(2000);
		clickOnElement(clickingUomDropDown);
		Thread.sleep(2000);

		List<WebElement> optiondropUom = driver.findElements(uomdroplist);

		selectBootStrapDropDown(optiondropUom, enteruomdropdownvalue);

		clickOnElement(ClickingCommoditygroupdropdown);

		Thread.sleep(2000);
		List<WebElement> ListCommodityDropdownlist = driver.findElements(optionscommgrouplist);

		WebElement clickingfirstoption = ListCommodityDropdownlist.get(0);

		Thread.sleep(2000);

		clickingfirstoption.click();
		
		clickOnElement(clickingclassficationdropdowninbopentry);
		Thread.sleep(2000);
		List<WebElement> Listgroupclassification = driver.findElements(classificationlistBopentry);
		
		
		WebElement  clickingfirstoptionofclassification = Listgroupclassification.get(0);
		
		clickingfirstoptionofclassification.click();
		
		
		
		
		
		
		

	}
 
 
	public void fetchingCommodityDropdownfromCommodityMaster() throws InterruptedException {
		
		clickOnElement(RadioButtonClickingCustomerSales);
		Thread.sleep(2000);
		clickOnElement(ClickingCommoditygroupdropdown);
		Thread.sleep(2000);
		List<WebElement> commoditygrouplist = driver.findElements(optionscommgrouplist);
		List<String> actuallistBopEntry = new ArrayList<String>();
		for (WebElement flagcomvalue : commoditygrouplist) {

			actuallistBopEntry.add(flagcomvalue.getText().trim());

		}
		LoggerUtil.logger.info("Fetched Commodity Group values from BOP Entry: " + actuallistBopEntry);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		clickOnElement(clickcommoditydropdownCommoditygrouptab);
		Thread.sleep(2000);
		List<WebElement> commdrop = driver.findElements(fetchingcommoditygroupdropdataingrouptab);
		List<String> actuallistcommoditymaster = new ArrayList<String>();
		for (WebElement optioncomMaster : commdrop) {

			actuallistcommoditymaster.add(optioncomMaster.getText().trim());

		}

		LoggerUtil.info("Fetching Commoditygroup Value From CommodityMaster = " + actuallistcommoditymaster);

		Assert.assertEquals(actuallistBopEntry, actuallistcommoditymaster);
		
		
	}
 
 
	public void verifyCommodityGroupClassificationDependencyForCustomer(String commodityName, String classificationValue,
			String specificGradeValue, String densityValue) throws InterruptedException {
		try {
			LoggerUtil.info("Starting test: verifyCommodityGroupClassificationDependency");

			dashboard.clickOnAddcommodity();
			LoggerUtil.info("Clicked on Add Commodity");

			clearAndEnterText(waitForExpectedElement(entercommoditynamefirstTabCommodityMaster), commodityName);
			LoggerUtil.info("Entered Commodity Name: " + commodityName);

			clickOnElement(savebuttonfirsttabcommoditymaster);
			LoggerUtil.info("Clicked Save button on Commodity Master tab");
			Thread.sleep(7000);

			dashboard.clickOncommoditygroup();
			LoggerUtil.info("Navigated to Commodity Group tab");

			clickOnElement(clickcommoditydropdownCommoditygrouptab);
			LoggerUtil.info("Clicked Commodity dropdown in Commodity Group tab");
			Thread.sleep(8000);

			List<WebElement> commdrop = driver.findElements(fetchingcommoditygroupdropdataingrouptab);
			boolean commodityFound = false;

			Thread.sleep(8000);
			for (WebElement optionCommodityGroupList : commdrop) {
				if (optionCommodityGroupList.getText().trim().equals(commodityName)) {
					optionCommodityGroupList.click();
					LoggerUtil.pass("Selected commodity: " + commodityName);
					commodityFound = true;
					break;
				}
			}

			if (!commodityFound) {
				LoggerUtil.fail("Commodity not found in dropdown: " + commodityName);
			}

			clearAndEnterText(waitForExpectedElement(enterclassificationvalue), classificationValue);
			LoggerUtil.info("Entered Classification Value: " + classificationValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterspecificgrade), specificGradeValue);
			LoggerUtil.info("Entered Specific Grade Value: " + specificGradeValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterdensityvalue), densityValue);
			LoggerUtil.info("Entered Density Value: " + densityValue);
			Thread.sleep(3000);

			clickOnElement(savebuttonsecondtabcommoditygroup);
			LoggerUtil.info("Clicked Save button on Commodity Group tab");
			Thread.sleep(3000);

			dashboard.selectBopMaster();
			LoggerUtil.info("Selected BOP Master");
			Thread.sleep(7000);

			dashboard.clickingBopEntryTab();
			LoggerUtil.info("Clicked on BOP Entry Tab");
			Thread.sleep(25000);

			clickOnElement(RadioButtonClickingCustomerSales);
			
			clickOnElement(ClickingCommoditygroupdropdown);
			LoggerUtil.info("Clicked Commodity Group dropdown in BOP Entry");
			Thread.sleep(25000);

			List<WebElement> commodityGroupList = driver.findElements(optionscommgrouplist);
			commodityFound = false;

			Thread.sleep(25000);
			for (WebElement commGroup : commodityGroupList) {
				if (commGroup.getText().trim().equals(commodityName)) {
					commGroup.click();
					LoggerUtil.pass("Commodity matched and selected in BOP Entry: " + commodityName);
					commodityFound = true;
					break;
				}
			}

			if (!commodityFound) {
				LoggerUtil.fail("Commodity not found in BOP Entry dropdown: " + commodityName);
			}

			clickOnElement(clickingclassficationdropdowninbopentry);
			LoggerUtil.info("Clicked Classification dropdown in BOP Entry");
			Thread.sleep(2000);

			List<WebElement> classificationList = driver.findElements(classificationlistBopentry);
			boolean classificationFound = false;

			for (WebElement optionClassification : classificationList) {
				if (optionClassification.getText().trim().equals(classificationValue)) {
					optionClassification.click();
					LoggerUtil.pass("Classification matched and selected in BOP Entry: " + classificationValue);
					classificationFound = true;
					break;
				}
			}

			if (!classificationFound) {
				LoggerUtil.fail("Classification not found in BOP Entry dropdown: " + classificationValue);
			}

			LoggerUtil.pass("Test verifyCommodityGroupClassificationDependency passed successfully.");

		} catch (Exception e) {
			LoggerUtil.fail(
					"Test verifyCommodityGroupClassificationDependency failed due to exception: " + e.getMessage());
			takeScreenshot("verifyCommodityGroupClassificationDependency", "");
		}
	}

 
	public static final By searchfunctionalityCommodityDropdownvalueBopEntryTab = By.xpath("//input[@class='select2-search__field']");
	public static final By searchFunctionalityGroupClassificationValueBopEntryTab = By.xpath("//input[@class='select2-search__field']");
	public static final By searchFunctionaliryspecificgradevalueBopEntryTab = By.xpath("//input[@class='select2-search__field']");
    public static final By clickingCustomerDropDownBopEntryTab = By.xpath("//span[@id='select2-BopEntry_SupplierInhouse-container']"); 
    public static final By searchcustomernameForBopEntryTab = By.xpath("//input[@class='select2-search__field']");
    public static final By customeroptionsForBopEntryTab = By.xpath("//ul[@id='select2-BopEntry_SupplierInhouse-results']/li");
    public static final By searchspecificgradevalueBopEntryTab = By.xpath("//input[@class='select2-search__field']");
    public static final By specificgradeoptionsInBopEntryTab = By.xpath("//ul[@id='select2-BopEntry_RmGrade-results']/li");
    public static final By clickingspecificgradedropdownBopEntry = By.xpath("//span[@id='select2-BopEntry_RmGrade-container']");
    
    public void verifySpecificGradeDropDownValue() throws InterruptedException {

        LoggerUtil.info("Step 1: Selecting 'Customer Sales' radio button.");
        clickOnElement(RadioButtonClickingCustomerSales);

        Thread.sleep(3000);
        LoggerUtil.info("Step 2: Clicking Commodity Group dropdown.");
        clickOnElement(ClickingCommoditygroupdropdown);

        Thread.sleep(2000);
        LoggerUtil.info("Step 3: Searching for Commodity Group 'ABCD'.");
        clearAndEnterText(waitForExpectedElement(searchfunctionalityCommodityDropdownvalueBopEntryTab), "ABCD");
        Thread.sleep(2000);

        List<WebElement> ListCommodityDropdownlist = driver.findElements(optionscommgrouplist);
        if (ListCommodityDropdownlist.isEmpty()) {
            LoggerUtil.error("Commodity dropdown options not found.");
            Assert.fail("Commodity dropdown is empty.");
        }
        WebElement clickingfirstoption = ListCommodityDropdownlist.get(0);
        try {
            clickingfirstoption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickingfirstoption);
        }

        LoggerUtil.info("Step 4: Clicking Group Classification dropdown.");
        clickOnElement(clickingclassficationdropdowninbopentry);
        Thread.sleep(2000);
        clearAndEnterText(waitForExpectedElement(searchFunctionalityGroupClassificationValueBopEntryTab), "AAutomation");
        Thread.sleep(3000);

        List<WebElement> Listgroupclassification = driver.findElements(classificationlistBopentry);
        if (Listgroupclassification.isEmpty()) {
            LoggerUtil.error("Group Classification options not found.");
            Assert.fail("Classification dropdown is empty.");
        }
        WebElement clickingfirstoptionofclassification = Listgroupclassification.get(0);
        clickingfirstoptionofclassification.click();

        LoggerUtil.info("Step 5: Clicking Customer dropdown.");
        clickOnElement(clickingCustomerDropDownBopEntryTab);
        Thread.sleep(2000);
        clearAndEnterText(waitForExpectedElement(searchcustomernameForBopEntryTab), "302");
        Thread.sleep(3000);

        List<WebElement> ListCustomerName = driver.findElements(customeroptionsForBopEntryTab);
        if (ListCustomerName.isEmpty()) {
            LoggerUtil.error("Customer options not found.");
            Assert.fail("Customer dropdown is empty.");
        }
        WebElement selectingfirstCustomeroption = ListCustomerName.get(0);
        selectingfirstCustomeroption.click();

        LoggerUtil.info("Step 6: Clicking Specific Grade dropdown.");
        clickOnElement(clickingspecificgradedropdownBopEntry);
        Thread.sleep(2000);
        clearAndEnterText(waitForExpectedElement(searchspecificgradevalueBopEntryTab), "002");
        Thread.sleep(2000);

        List<WebElement> Listvalueofspecificgrade = driver.findElements(specificgradeoptionsInBopEntryTab);
        if (Listvalueofspecificgrade.isEmpty()) {
            LoggerUtil.error("Specific Grade options not found.");
            Assert.fail("Specific Grade dropdown is empty.");
        }
        WebElement selectingfirstoptionvalue = Listvalueofspecificgrade.get(0);
        selectingfirstoptionvalue.click();

        String actualvalue = selectingfirstoptionvalue.getText().trim();
        String expectedvalue = "002";
        LoggerUtil.info("Step 7: Verifying selected Specific Grade value: Expected = " + expectedvalue + ", Actual = " + actualvalue);
        Assert.assertEquals(actualvalue, expectedvalue, "❌ Specific Grade value mismatch.");
        LoggerUtil.info(" Specific Grade value matched successfully.");
    }

    public static final By searchCustomerNameInCommodityDetails = By.xpath("//input[@id='myInputCustomer']");
    public static final By clickingcheckboxcustomerincommoditydetails = By.xpath("//table[@id='rmCustomer']/tbody/tr[2]/td/div/label/input");
    public static final By Anyothercostfactor2InCommodityDetails = By.xpath("//input[@id='OtherCost2D']");
    public void verifySavecommodityRmAndScrapWithCustomerItShouldAppearInBopEntryTab(String commodityName,
			String classificationValue, String specificGradeValue, String densityValue,String Enterbasiccostvalue) throws InterruptedException {
		try {
			LoggerUtil.info("Starting test: verifySavecommodityRmAndScrapWithSupplierItShouldAppearInBopEntryTab");

			dashboard.clickOnAddcommodity();
			LoggerUtil.info("Clicked on Add Commodity");

			clearAndEnterText(waitForExpectedElement(entercommoditynamefirstTabCommodityMaster), commodityName);
			LoggerUtil.info("Entered Commodity Name: " + commodityName);

			clickOnElement(savebuttonfirsttabcommoditymaster);
			LoggerUtil.info("Clicked Save button on Commodity Master tab");
			Thread.sleep(7000);

			dashboard.clickOncommoditygroup();
			LoggerUtil.info("Navigated to Commodity Group tab");

			clickOnElement(clickcommoditydropdownCommoditygrouptab);
			LoggerUtil.info("Clicked Commodity dropdown in Commodity Group tab");
			Thread.sleep(8000);

			List<WebElement> commdrop = driver.findElements(fetchingcommoditygroupdropdataingrouptab);
			boolean commodityFound = false;

			Thread.sleep(8000);
			for (WebElement optionCommodityGroupList : commdrop) {
				if (optionCommodityGroupList.getText().trim().equals(commodityName)) {
					optionCommodityGroupList.click();
					LoggerUtil.pass("Selected commodity: " + commodityName);
					commodityFound = true;
					break;
				}
			}

			if (!commodityFound) {
				LoggerUtil.fail("Commodity not found in dropdown: " + commodityName);
			}

			clearAndEnterText(waitForExpectedElement(enterclassificationvalue), classificationValue);
			LoggerUtil.info("Entered Classification Value: " + classificationValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterspecificgrade), specificGradeValue);
			LoggerUtil.info("Entered Specific Grade Value: " + specificGradeValue);
			Thread.sleep(2000);

			clearAndEnterText(waitForExpectedElement(enterdensityvalue), densityValue);
			LoggerUtil.info("Entered Density Value: " + densityValue);
			Thread.sleep(3000);

			clickOnElement(savebuttonsecondtabcommoditygroup);
			LoggerUtil.info("Clicked Save button on Commodity Group tab");
			Thread.sleep(5000);
			
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			clickOnElement(verifydoemsticradiobtnforCommodityDetails);
			Thread.sleep(200);
			 clickOnElement(commoditydropdownDomestic);	
			Thread.sleep(25000);
			 List<WebElement> thirdtabcommoditygrouplist = driver.findElements(commodityDropdownlistincommoditydetails);
			Thread.sleep(2000);
			 for(WebElement optioncommoditygroup:thirdtabcommoditygrouplist) {
				
				   String optionthirdtabcommoditygroup = optioncommoditygroup.getText().trim();
				   
				   if(optionthirdtabcommoditygroup.equals(commodityName)) {
					   
					   optioncommoditygroup.click();
					   
					   break;
					   
				   }
				
			}
			
			Thread.sleep(3000);

		    clickOnElement(ClickingGroupclassificationdropdown);
		    Thread.sleep(9000);
		    
			List<WebElement> optionclassification = driver.findElements(listcommoditygroupclassification);
			for(WebElement listvalueclassification:optionclassification) {
				
				String flagevalueclassification = listvalueclassification.getText().trim();
				
				if(flagevalueclassification.equals(classificationValue)) {
					
					listvalueclassification.click();
					break;
					
				}
				
			}
			
			Thread.sleep(4000);
			clickOnElement(clickingSpecificgradedropdown);
			Thread.sleep(3000);
			List<WebElement> optionspecificgradethirdtab = driver.findElements(listspecificgrade);
			for(WebElement listedspecificgradevalue :optionspecificgradethirdtab) {
				
				String flagevaluespecificgrade = listedspecificgradevalue.getText().trim();
				
				if(flagevaluespecificgrade.equals(specificGradeValue)) {
					
					listedspecificgradevalue.click();
					
					break;
				}
				
			}
			
			Thread.sleep(2000);
			clickOnElement(clickingUomdropdown);
			Thread.sleep(3000);
			List<WebElement> uomoptions = driver.findElements(Listuomdropdown);
			Thread.sleep(2000);
			selectBootStrapDropDown(uomoptions, "Kg");
			Thread.sleep(2000);
			
			
			Thread.sleep(2000);
			 clickOnElement(ClickingShapedropdown);
			    LoggerUtil.info("Clicked on Shape dropdown.");
			    
			    Thread.sleep(300);
			    WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			    clearAndEnterText(shapesearch, "Sheet");
			    shapesearch.sendKeys(Keys.ENTER);
			    LoggerUtil.info("Entered Shape as: Sheet");
			
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EntervalueinBasicCost), Enterbasiccostvalue);
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(Enterfirststagefreightcost), Enterbasiccostvalue);
			Thread.sleep(2999);
			clearAndEnterText(waitForExpectedElement(EnterConversioncost), Enterbasiccostvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(EnterDiscountAbsolute), Enterbasiccostvalue);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(Anyothercostfactor2InCommodityDetails), Enterbasiccostvalue);
			Thread.sleep(100);
			
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(searchCustomerNameInCommodityDetails), "302-Raj");
			Thread.sleep(2000);
			clickOnElement(clickingcheckboxcustomerincommoditydetails);
			
			Thread.sleep(15000);
			clickOnElement(Savebuttoncommoditydetails);
			Thread.sleep(3000);
	

		} catch (Exception e) {
			LoggerUtil.fail(
					"Test verifySavecommodityRmAndScrapWithSupplierItShouldAppearInBopEntryTab failed due to exception: "
							+ e.getMessage());

		}
	
 
       
              dashboard.selectBopMaster();
              
		     Thread.sleep(2000);

		     dashboard.clickingBopEntryTab();
		     Thread.sleep(3000);
		     clickOnElement(RadioButtonClickingCustomerSales);
		     Thread.sleep(2000);
		     clickOnElement(ClickingCommoditygroupdropdown);
		     Thread.sleep(2000);
		     clearAndEnterText(waitForExpectedElement(searchfunctionalityCommodityDropdownvalueBopEntryTab), commodityName);
		        Thread.sleep(2000);
		     List<WebElement> commoditygrouplist = driver.findElements(optionscommgrouplist);
              
		     WebElement clickfirstoption = commoditygrouplist.get(0);
		     Thread.sleep(1000);
		     clickfirstoption.click();
             Thread.sleep(200);
             
             clickOnElement(clickingclassficationdropdowninbopentry);
             Thread.sleep(2000);
             clearAndEnterText(waitForExpectedElement(searchFunctionalityGroupClassificationValueBopEntryTab), classificationValue);
             Thread.sleep(3000);

             List<WebElement> Listgroupclassification = driver.findElements(classificationlistBopentry);

             WebElement clickingfirstoptiongroupclassfication = Listgroupclassification.get(0);
             
             clickingfirstoptiongroupclassfication.click();
             Thread.sleep(2000);
             
		     
		     clickOnElement(clickingCustomerDropDownBopEntryTab);
		     Thread.sleep(2000);
		     clearAndEnterText(waitForExpectedElement(searchcustomernameForBopEntryTab), "302");
		     List<WebElement> searchingvalueofCustomername  = driver.findElements(customeroptionsForBopEntryTab);
		     Thread.sleep(2000);
		     WebElement clcikingfirstoptions = searchingvalueofCustomername.get(0);
		     Thread.sleep(200);
		     clcikingfirstoptions.click();
		     
		     Thread.sleep(200);
		     clickOnElement(clickingCustomerDropDownBopEntryTab);
		     Thread.sleep(2000);
		     clearAndEnterText(waitForExpectedElement(searchcustomernameForBopEntryTab), "select");
		     List<WebElement> searchingvalueofCustomername1  = driver.findElements(customeroptionsForBopEntryTab);
		     Thread.sleep(2000);
		     WebElement clcikingfirstoptions1 = searchingvalueofCustomername1.get(0);
		     Thread.sleep(200);
		     clcikingfirstoptions1.click();
		     
		     clickOnElement(clickingCustomerDropDownBopEntryTab);
		     Thread.sleep(2000);
		     clearAndEnterText(waitForExpectedElement(searchcustomernameForBopEntryTab), "302");
		     List<WebElement> searchingvalueofCustomername11  = driver.findElements(customeroptionsForBopEntryTab);
		     Thread.sleep(2000);
		     WebElement clcikingfirstoptions11 = searchingvalueofCustomername11.get(0);
		     Thread.sleep(200);
		     clcikingfirstoptions11.click();
		     Thread.sleep(2000);
		     clickOnElement(clickingspecificgradedropdownBopEntry);
             Thread.sleep(2000);
             clearAndEnterText(waitForExpectedElement(searchspecificgradevalueBopEntryTab), specificGradeValue);
             Thread.sleep(2000);

             List<WebElement> Listvalueofspecificgrade = driver.findElements(specificgradeoptionsInBopEntryTab);
             
             WebElement clickingfirstoptionspecificgrade = Listvalueofspecificgrade.get(0);
             
             clickingfirstoptionspecificgrade.click();
            		 
		     Thread.sleep(3000);
		     
		     String actualvalue = clickingfirstoptionspecificgrade.getText().trim();
		        String expectedvalue = specificGradeValue;
		        LoggerUtil.info("Step 7: Verifying selected Specific Grade value: Expected = " + expectedvalue + ", Actual = " + actualvalue);
		        Assert.assertEquals(actualvalue, expectedvalue, "❌ Specific Grade value mismatch.");
		        LoggerUtil.info(" Specific Grade value matched successfully.");
		     
		     
		     
    
    }
    
    
    public static final By RmFieldBopEntry = By.xpath("//input[@id='RmCostInHouse']");
    public void RmFieldFrozenOrNot() {
    	
     String CheckRmisEditable = waitForExpectedElement(RmFieldBopEntry).getAttribute("readonly");
     if(!CheckRmisEditable.isEmpty()) {
    	 
    	 LoggerUtil.pass("field is not editable...");
    	 
     }
    	
     else {
    	 
    	 LoggerUtil.fail("Field is Editable");
     }
    	
    	
    	
    }
    
    
    public static final By ClickingAddCustomerButton = By.xpath("//a[@id='addNewCustomer1' ]/span[contains(text(),' +  Customer')]");
    public static final By enterCustomerCode = By.xpath("//input[@id='CustomerCode']");
    public static final By entercustomername = By.xpath("//input[@id='CustomerName']");
    public static final By clickingsavebuttonforAddCustomerBopEnterTab = By.xpath("//button[@id='customerSave1']");
    public void verifyCustomerAddCustomerFunctionality(String entercustomercode,String enterCustomername) throws InterruptedException {
    	Thread.sleep(2000);
    	clickOnElement(RadioButtonClickingCustomerSales);
    	Thread.sleep(2000);
    	clickOnElement(ClickingAddCustomerButton);
    	
     clearAndEnterText(waitForExpectedElement(enterCustomerCode), entercustomercode);
     clearAndEnterText(waitForExpectedElement(entercustomername), enterCustomername);
     Thread.sleep(2000);
     clickOnElement(clickingsavebuttonforAddCustomerBopEnterTab);
    	Thread.sleep(2000);
    	 clickOnElement(clickingCustomerDropDownBopEntryTab);
	     Thread.sleep(2000);
	     clearAndEnterText(waitForExpectedElement(searchcustomernameForBopEntryTab),enterCustomername);
	     List<WebElement> searchingvalueofCustomername11  = driver.findElements(customeroptionsForBopEntryTab);
	     Thread.sleep(2000);
	     WebElement clcikingfirstoptions11 = searchingvalueofCustomername11.get(0);
	     Thread.sleep(200);
	     String actualmsg = clcikingfirstoptions11.getText();
	     clcikingfirstoptions11.click();	
    	
	     
    	if(actualmsg.equals(enterCustomername)) {
    		LoggerUtil.pass("Values Are getting After SAve From Add Customer ");
    		
    	}
    	else {
    		
    		LoggerUtil.fail("Values Are Not Getting After Save Customer From Add Customer Button");
    	}
    	
    }
    
    public static final By optionBoptypeDropdownvalue = By.xpath("//ul[@id='select2-BopEntry_BopEntryType-results']/li");
    public static final By BopCategoryDropdown = By.xpath("//span[@id='select2-BopEntry_BopEntryType-container']");
    public static final By ResetButtonBopType = By.xpath("//button[@onclick='resetFormdata()']");
        
    public void verifyResetButtonFuctionality() throws InterruptedException {
    	
    	clearAndEnterText(waitForExpectedElement(EnterValuePartdescription), "56876");
    	String actualvalueofPartdescription = waitForExpectedElement(EnterValuePartdescription).getText();
    	Thread.sleep(2999);
    	clearAndEnterText(waitForExpectedElement(EnterPartnumberValue), "456789");
    	Thread.sleep(2000);
    	  String actualvalueofpartnumber = waitForExpectedElement(EnterPartnumberValue).getText();
    	clickOnElement(BopCategoryDropdown);
    	
    	List<WebElement> optionsBop = driver.findElements(optionBoptypeDropdownvalue);
    	selectBootStrapDropDown(optionsBop, "Standard");
    	Thread.sleep(2000);
    	String actualvalueofBopcategoryDropdown = waitForExpectedElement(BopCategoryDropdown).getText();
      
        
        		
    	
    	clickOnElement(ResetButtonBopType);
    	 String ExpectedvalueofBopcategoryDropdown = waitForExpectedElement(BopCategoryDropdown).getText();
    	String ExpectedvalueofPartdescription = waitForExpectedElement(EnterValuePartdescription).getText();
        String Expectedvalueofpartnumber = waitForExpectedElement(EnterPartnumberValue).getText();
      
    	
    	
    	
    	
        if(!actualvalueofPartdescription.equals(ExpectedvalueofPartdescription)) {
        	LoggerUtil.pass("Reset Button is working Well PartDescription Value Has Been Removed... ");
        	
        	
        if(!actualvalueofpartnumber.equals(Expectedvalueofpartnumber)){
        	LoggerUtil.pass("Reset Button is working Well PartDescription Value Has Been Removed... ");
        	
        	
        }
        	
        if(!actualvalueofBopcategoryDropdown.equals(ExpectedvalueofBopcategoryDropdown)) {
        	
        	LoggerUtil.pass("Reset Button is Working Well BopCategoryDropDowb Value has been removed...");
        	
        	
        }
        else {
        	
        	LoggerUtil.error("Value Has Not been Removed....");
        	
        }
        
        }
        
        
    }
    
    
    
   public void verifyExportprompt() throws InterruptedException {
	   
	clickOnElement(RadioButtonClickingCustomerSales);
	Thread.sleep(2000);
	clickOnElement(clickingUIExportButton);
	Thread.sleep(2000);
	clickOnElement(clickingExportButtonforDownload);
	 String actualpop = waitForExpectedElement(toastmsg).getText();
	 System.out.println(actualpop);
	 String expectedpopup = "File exported successfully";  
	 Assert.assertEquals(actualpop, expectedpopup);  
	   
   }
    
    
   public void verifyFileNamingConvention() throws InterruptedException {
	    
	    LoggerUtil.logger.info("Step 1: Selecting Customer Sales radio button.");
	    clickOnElement(RadioButtonClickingCustomerSales);

	    LoggerUtil.logger.info("Step 2: Clicking Export button.");
	    Thread.sleep(2000);
	    clickOnElement(clickingUIExportButton);

	    LoggerUtil.logger.info("Step 3: Confirming Export for download.");
	    Thread.sleep(2000);
	    clickOnElement(clickingExportButtonforDownload);

	    LoggerUtil.logger.info("Step 4: Waiting for file download.");
	    Thread.sleep(5000); // give time for file to download

	    File downloadedFile = getLatestBOPProcurementInhouseFileForCustomer();

	    Assert.assertNotNull(downloadedFile, "❌ Exported file not found in Downloads folder.");

	    String fileName = downloadedFile.getName();
	    LoggerUtil.logger.info("✅ Exported File Name: " + fileName);

	    Assert.assertTrue(fileName.contains("BOP_Sale_InHouse"), "❌ File name does not contain 'BOP_Sale_InHouse'");
	    Assert.assertTrue(fileName.endsWith(".xlsx"), "❌ File does not end with '.xlsx'");

	    LoggerUtil.logger.info("✅ File naming convention verified successfully.");
	}

    
    
    public void importWithMissingField() throws InterruptedException {
    	
    	clickOnElement(RadioButtonClickingCustomerSales);

	    LoggerUtil.logger.info("Step 2: Clicking Export button.");
	    Thread.sleep(2000);
	    clickOnElement(clickingUIExportButton);

	    LoggerUtil.logger.info("Step 3: Confirming Export for download.");
	    Thread.sleep(2000);
	    clickOnElement(clickingExportButtonforDownload);

	    LoggerUtil.logger.info("Step 4: Waiting for file download.");
	    Thread.sleep(15000); // give time for file to download

	    File downloadedFile = getLatestBOPProcurementInhouseFileForCustomer();

	    System.out.println(downloadedFile);
	    
    	Thread.sleep(2000);
    	fillingFile();
    	Thread.sleep(6000);
    	UploadExcelfileWithMissingMandatoryFieldForCustomer();     	
    	
    }
    
    public String fillingFile() throws InterruptedException {
    	Thread.sleep(3000);
		File latestFile = getLatestBOPProcurementInhouseFile();
		if (latestFile == null) {
			System.out.println("No ProcessMaster file found.");
			return null;
		}
    	
		String filePath = latestFile.getAbsolutePath();
    	
		String bopdropdown = "Bolt";
		String childprtdes = faker.letterify("????");
		int randomint = faker.number().numberBetween(10, 90);
		String partno = String.valueOf(randomint);
		String Commoditydropdown = "Ferrous Metals";
		String Rmgroupclassificationdropdown = "Steel";
		String specificgrade = "CRCA-1";
		String grosswt = "Kg";
		String finishwt = "Kg";
		String processcost = "50";
		String othercost = "10";
		
		ExcelFiller.setCellValue(filePath, 0, 2, 1,ExcelFiller.ValueType.DROPDOWN, Arrays.asList(bopdropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 2, ExcelFiller.ValueType.STRING, Arrays.asList(childprtdes));
		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, Arrays.asList(partno));		
		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN,Arrays.asList(Commoditydropdown) );
		ExcelFiller.setCellValue(filePath, 0, 2, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(Rmgroupclassificationdropdown));
		ExcelFiller.setCellValue(filePath, 0, 2, 9, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(specificgrade));
		ExcelFiller.setCellValue(filePath, 0, 2, 12, ExcelFiller.ValueType.STRING,Arrays.asList(grosswt));
		ExcelFiller.setCellValue(filePath, 0, 2, 13, ExcelFiller.ValueType.STRING, Arrays.asList(finishwt));
		ExcelFiller.setCellValue(filePath, 0, 2, 15, ExcelFiller.ValueType.STRING, Arrays.asList(processcost));
		ExcelFiller.setCellValue(filePath, 0, 2, 16, ExcelFiller.ValueType.STRING, Arrays.asList(othercost));
	
		return latestFile.getAbsolutePath();
		
		
		
    	
    }
    
    
    
    
    
    public void UploadExcelfileWithMissingMandatoryFieldForCustomer() throws InterruptedException {
        String filePath = fillingFile();  // Get the filled Excel file path
        if (filePath == null) {
            LoggerUtil.error("❌ Excel file path not found. Cannot proceed with upload.");
            return;
        }

        LoggerUtil.info("🟢 Step: Uploading file with missing mandatory fields...");

        //  Make hidden file input visible using JavaScript
        WebElement uploadInput = driver.findElement(By.id("excelUpload"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);

        // Use sendKeys directly (no waitForExpectedElement, it's hidden originally)
        uploadInput.sendKeys(filePath);

        //  Optionally, re-hide the input after upload
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", uploadInput);

        Thread.sleep(4000);  // Wait for processing

        //  Validate toast or error
        String expectedErrorPart = "Input string was not in a correct format.";
        String toastText = waitForExpectedElement(toastmsg).getText();

        if (toastText.toLowerCase().contains(expectedErrorPart.toLowerCase())) {
            LoggerUtil.pass("Invalid popup getting = " + toastText);
        } else {
            LoggerUtil.fail("❌ Unexpected toast after Excel upload: " + toastText);
        }
    }


    
    
    
}

