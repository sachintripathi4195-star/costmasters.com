package com.Tests;

import java.awt.AWTException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.CommodityDetailsPage;
import com.Pages.CommoditygroupPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;

@Listeners(com.helper.TestListeners.class)

public class CommodityDetailsTest extends Base {
	CommoditygroupPage comgrp = new CommoditygroupPage();
	LoginPage login;
	DashboardPage dashboard;
	CommodityDetailsPage comd;
	private ExtentTest logger;
	Faker faker = new Faker();
	Faker fakerCN = new Faker(new Locale("zh-CN"));
	SoftAssert soft = new SoftAssert();

	public void setLogger(ExtentTest logger) {
		this.logger = logger;
	}

	// Generates a character-only unique string
	String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

	String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	String randomName = faker.name().firstName() + "_" + faker.number().numberBetween(10, 99);
	String randomName1 = faker.name().firstName() + "_" + faker.number().numberBetween(10, 99);
	String randomName2 = faker.name().firstName() + "_" + faker.number().numberBetween(10, 99);
	String randomName3 = faker.name().firstName() + "_" + faker.number().numberBetween(10, 99);
	int randomNumber = faker.number().numberBetween(1000, 9999);
	int randomNumberNegative = -faker.number().numberBetween(1000, 9999);
	double randomNumber2 = faker.number().randomDouble(3, 1, 100);

	@BeforeGroups(groups = { "group1", "group2", "group3", "group4" })
	public void loginGroup() throws InterruptedException {
		Base.launchApplication();

		login = new LoginPage();
		dashboard = new DashboardPage();
		comd = new CommodityDetailsPage();

		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(7000);
		LoggerUtil.info("Logged in once before the group test cases.");
	}

	@AfterGroups(groups = { "group1", "group2", "group3", "group4" })
	public void logoutGroup() {
		driver.quit();
		LoggerUtil.info("Logged out after the group test cases.");
	}

	@Test(priority = 1, groups = "group1")
	public void TC_COM_001_SaveANewCommodityGroup() throws InterruptedException {
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

		LoggerUtil.info("Scenario End: TC_COM_001_SaveANewCommodityGroup completed.");
	}

	@Test(priority = 2, groups = "group1")
	public void TC_YRLY_002_SystemDateApplicabilityYearly() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Navigated to 'Master Data' menu tab.");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("Navigated to 'Commodity Master' main tab.");
		Thread.sleep(2000);

		LocalDate today = LocalDate.now();
		LoggerUtil.info("Preparing to verify effective date in the details tab.");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String todayDate = today.format(formatter);
		LoggerUtil.info("Today's system date (expected): " + todayDate);

		comd.verifyTodayDateForEffective(todayDate);
	}

	@Test(priority = 3, groups = "group1")
	public void TC_YRLY_002_SystemDateApplicabilityYearly1() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Navigated to 'Master Data' menu tab.");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("Navigated to 'Commodity Master' main tab.");
		Thread.sleep(2000);

		LocalDate today = LocalDate.now();
		LoggerUtil.info("Preparing to verify system date in the details tab.");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String todayDate = today.format(formatter);
		LoggerUtil.info("Today's system date (expected): " + todayDate);

		comd.VerifyTodayDateForsystemdate(todayDate);
	}

	@Test(priority = 4, groups = "group1")
	public void TC_YRLY_003DropdownCommodityGroupClassificationSpecificGrade()
			throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
        dashboard.clickOnCommodityTabByName("Commodity Details");  
		
		Thread.sleep(2000);
		QuickMasterPage.VerifySearchFilterForCommodityDetailsTab();
	}

	 
	@Test(priority = 5, groups = "group1")
	public void TC_YRLY_004MandatoryFieldValidationSaveWithEmptyFields() throws InterruptedException {

		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data successfully for mandatory validation.");
		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.WithoutSelectingComGroup();
	}

	@Test(priority = 7, groups = "group1")
	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutUOM() throws InterruptedException {

		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
		String groupClassification = faker.name().firstName() + faker.letterify("????");
		String specificGrade = faker.name().firstName() + faker.letterify("????");
		String density = faker.number().digits(5);

		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
		Thread.sleep(3999);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
				"Commodity Group Saved Successfully");
		Thread.sleep(3000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		QuickMasterPage.SaveComDetailsWithoutSelectingUOMDropDown(commodityGroup, groupClassification, specificGrade);

	}

	@Test(priority = 7, groups = "group1")
	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutShape() throws InterruptedException {

		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
		String groupClassification = faker.name().firstName() + faker.letterify("????");
		String specificGrade = faker.name().firstName() + faker.letterify("????");
		String density = faker.number().digits(5);

		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
		Thread.sleep(3999);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
				"Commodity Group Saved Successfully");
		Thread.sleep(3000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		QuickMasterPage.SaveComDetailsWithoutSelectingShapeDropdown(commodityGroup, groupClassification, specificGrade);

	}

	@Test(priority = 8, groups = "group1")
	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutYear() throws InterruptedException {

		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
		String groupClassification = faker.name().firstName() + faker.letterify("????");
		String specificGrade = faker.name().firstName() + faker.letterify("????");
		String density = faker.number().digits(5);

		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
		Thread.sleep(3999);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
				"Commodity Group Saved Successfully");
		Thread.sleep(3000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		QuickMasterPage.SaveComDetailsWithoutSelectingYearDropDown(commodityGroup, groupClassification, specificGrade);

	}
	@Test(priority = 9, groups = "group1")
	public void TC_YRLY_005MandatoryFieldsPlasticSpecificChanges() throws InterruptedException {

		Thread.sleep(8000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data Successfully");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master tab.");

		comd.verifyplasticspecificChanges();
	}

	@Test(priority = 9, groups = "group1")
	public void TC_YRLY_005MandatoryFieldsPlasticSpecificChangesCylinderDegC() throws InterruptedException {

		Thread.sleep(8000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data Successfully");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master tab.");

		comd.verifyplasticselectedforsomechanges();
	}

	@Test(priority = 9, groups = "group1")
	public void TC_YRLY_005MandatoryFieldsPlasticSpecificChangesMouldDegC() throws InterruptedException {

		Thread.sleep(8000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data Successfully");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master tab.");

		comd.verifyplasticspecificchangesformoduledegc();
	}

	@Test(priority = 9, groups = "group2")
	public void TC_CD_009SaveRmScrapPricesWith3DecimalPrecision() throws Throwable {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicked the Master Data successfully");

		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		// driver.navigate().refresh();
		CommodityDetailsPage.savedataforthreedecimal(commoditygroupvalue, groupclassificationvalue, specificgragevalue,"2025-2026");
		Thread.sleep(3000);
		String random1 = String.valueOf(faker.number().randomDouble(3, 1, 100));
		String random2 = String.valueOf(faker.number().randomDouble(3, 1, 100));
		String random3 = String.valueOf(faker.number().randomDouble(3, 1, 100));

		CommodityDetailsPage.enetrRmAndScrapValues(random1, random2, random3, random1, random2, random3, random1,
				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
				random1, random2, random3, random1, random2, random3, commoditygroupvalue);

	}
	
	
	
	
	
	@Test(priority = 10, groups = "group1")
	public void TC_CD_010SaveNegativeValuesForRmAndScrap() throws InterruptedException {
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicked the Master Data successfully");

		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		// driver.navigate().refresh();
		CommodityDetailsPage.savedataforthreedecimal(commoditygroupvalue, groupclassificationvalue, specificgragevalue,"2025-2026");
		Thread.sleep(3000);
		String random1 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
		String random2 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
		String random3 = String.valueOf(-faker.number().randomDouble(3, 1, 100));

		CommodityDetailsPage.enetrRmAndScrapValues(random1, random2, random3, random1, random2, random3, random1,
				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
				random1, random2, random3, random1, random2, random3, commoditygroupvalue);

	}
	@Test(priority = 9, groups = "group1")
	public void TC_YRLY_010SaveNegativeValuesForRmAndScrapWithoutdecimal() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.number().digits(4);

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicked the Master Data successfully");

		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		// driver.navigate().refresh();
		CommodityDetailsPage.savedataforthreedecimal(commoditygroupvalue, groupclassificationvalue, specificgragevalue,"2025-2026");
		Thread.sleep(3000);
		String random1 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
		String random2 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
		String random3 = String.valueOf(-faker.number().randomDouble(3, 1, 100));

		CommodityDetailsPage.enetrRmAndScrapValues(random1, random2, random3, random1, random2, random3, random1,
				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
				random1, random2, random3, random1, random2, random3, commoditygroupvalue);
	}

	@Test(priority = 11, groups = "group2")
	public void TC_CD_011QuarterlyAndHalfYearlyCalculationsForRmAndScrap() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicked the Master Data successfully");
		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master");
		Thread.sleep(3000);

		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(3000);

		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(4000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue);

		// Generate reusable randoms
		String random1 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String random2 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String random3 = String.valueOf(faker.number().numberBetween(1000, 9999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalue(random1, random2, random3, random1,
				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
				random1, random2, random3, random1, random2, random3, random1, random2, random3, commoditygroupvalue);

		// Quarterly RM
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q1 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q2 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ3();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q3 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ4();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q4 RM failed: " + e.getMessage());
		}

		// Quarterly Scrap
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q1 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q2 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ3();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q3 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ4();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q4 Scrap failed: " + e.getMessage());
		}

		// Half-Yearly RM
		try {
			CommodityDetailsPage.verifyHalfYearlyRmAverageH1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H1 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyHalfYearlyRmAverageH2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H2 RM failed: " + e.getMessage());
		}

		// Half-Yearly Scrap
		try {
			CommodityDetailsPage.verifyHalfYearlyScrapAverageH1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H1 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyHalfYearlyScrapAverageH2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H2 Scrap failed: " + e.getMessage());
		}

	}
	@Test(priority = 10, groups = "group1", enabled = false)
	public void TC_YRLY_011QuarterlyAndHalfYearlyCalculationsForRmAndScrapWithPossitiveNumberForDecimalMoreThanThreeDigit()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.number().digits(4);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicked the Master Data successfully");
		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master");
		Thread.sleep(3000);

		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainfirsttabforcalq1q2q3q4(commoditygroupvalue);
		Thread.sleep(3000);

		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		Thread.sleep(4000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

		// Generate reusable randoms
		String random1 = String.valueOf(faker.number().randomDouble(4, 1, 100));
		String random2 = String.valueOf(faker.number().randomDouble(4, 1, 100));
		String random3 = String.valueOf(faker.number().randomDouble(4, 1, 100));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalue(random1, random2, random3, random1, random2, random3,
				random1, random2, random3, random1, random2, random3, random1, random2, random3, random1, random2,
				random3, random1, random2, random3, random1, random2, random3, commoditygroupvalue);

		// Quarterly RM
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q1 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q2 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ3();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q3 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ4();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q4 RM failed: " + e.getMessage());
		}

		// Quarterly Scrap
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q1 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q2 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ3();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q3 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ4();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q4 Scrap failed: " + e.getMessage());
		}

		// Half-Yearly RM
		try {
			CommodityDetailsPage.verifyHalfYearlyRmAverageH1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H1 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyHalfYearlyRmAverageH2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H2 RM failed: " + e.getMessage());
		}

		// Half-Yearly Scrap
		try {
			CommodityDetailsPage.verifyHalfYearlyScrapAverageH1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H1 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyHalfYearlyScrapAverageH2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H2 Scrap failed: " + e.getMessage());
		}
	}

	
	@Test(priority = 13, groups = "group2")
	public void TC_CD_012DeltaPricesValidationWith3To4DecimalPrecision() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(5000);

		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(4000);

		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue);

		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(faker.number().numberBetween(100, 999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);

		String randomsupp1 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String randomsupp2 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String randomsupp3 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String randomsupp4 = String.valueOf(faker.number().numberBetween(1000, 9999));

		String suprandom1 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
		String suprandom2 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
		String suprandom3 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
		String suprandom4 = String.valueOf(faker.number().randomDouble(4, 100, 234567));

		QuickMasterPage.verifyingcalculationofsupplierallocation(suprandom1, suprandom2, suprandom4, suprandom3,
				suprandom3, suprandom1, suprandom2, suprandom1, suprandom1, suprandom1, suprandom2, suprandom1,
				suprandom4, suprandom3, suprandom1, suprandom3, suprandom1, suprandom1, suprandom3, suprandom2,
				suprandom2, suprandom1, suprandom1, suprandom1, commoditygroupvalue);

		Thread.sleep(16000);

		// Handling assertion failures for all steps
		try {
			CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: April Landed Cost (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparingLandedCostForMay();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: May Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: June Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparinglandedcostforjuly();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: July Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostforaugust();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: August Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForseptember();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: September Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForoctober();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: October Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForNovember();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: November Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForDecember();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: December Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForJan();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: January Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForFebruary();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: February Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForMarch();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: March Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 Scrap (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 Scrap (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 Scrap Average (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateQ4ScrapAverage();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 Scrap Average (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year Scrap (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Second Half Year RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Second Half Year Scrap (Supplier) - " + e.getMessage());
		}

	}
	int randomsupp = faker.number().numberBetween(1000, 9999);

	@Test(priority = 12, groups = "group2")
	public void TC_CD_013SpecificDeltaSupplierAllocation() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(5000);

		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(4000);

		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue);

		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(faker.number().numberBetween(100, 999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);

		String randomsupp1 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String randomsupp2 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String randomsupp3 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String randomsupp4 = String.valueOf(faker.number().numberBetween(1000, 9999));

		CommodityDetailsPage.verifyingcalculationofsupplierallocation(randomsupp1, randomsupp2, randomsupp3,
				randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp2, randomsupp3,
				randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp2, randomsupp3,
				randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, commoditygroupvalue);

		Thread.sleep(16000);

		// Handling assertion failures for all steps
		try {
			CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: April Landed Cost (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparingLandedCostForMay();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: May Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: June Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparinglandedcostforjuly();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: July Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostforaugust();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: August Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForseptember();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: September Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForoctober();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: October Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForNovember();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: November Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForDecember();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: December Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForJan();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: January Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForFebruary();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: February Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.comparelandedcostForMarch();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: March Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 Scrap (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 Scrap (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 Scrap Average (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateQ4ScrapAverage();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 Scrap Average (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year Scrap (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Second Half Year RM (Supplier) - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Second Half Year Scrap (Supplier) - " + e.getMessage());
		}

	}


	@Test(priority = 14, groups = "group1")
	public void TC_YRLY_013SpecificDeltaSupplierCustomerAllocationForCustomerWithPossitiveNumber()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

//  calculating customer Allocation For Possitive Number
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		Thread.sleep(4000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

		// Generate random data
		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(faker.number().numberBetween(100, 999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(random1, random2, random3, random4,
				random1, random2, random3, random4, random1, random2, random3, random4, random1, random2, random3,
				random4, random1, random2, random3, random4, random1, random2, random3, random4);

		String randomsupp1 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp2 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp3 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp4 = String.valueOf(faker.number().numberBetween(100, 999));

		CommodityDetailsPage.verifyingcalculationofcustomerallocation(randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1,
				randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1,
				randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1,
				randomsupp2, randomsupp3, randomsupp4, commoditygroupvalue);

		// Call each method inside try-catch
		try {
			CommodityDetailsPage.verifyCalculateLandedCostForCustomerAprilMonth();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: April Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatemayrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: May RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejunermandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: June RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejulyrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: July RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateaugustrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: August RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateseptemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: September RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateoctoberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: October RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatenovemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: November RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatedecemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: December RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejanrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: January RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefebrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: February RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatemarchrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: March RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifyCalculatingCustomerAllocationSecondQ2ForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ2ScrapValueForCustomerAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 Scrap - " + e.getMessage());
		}

		// Q3: October, November, December
		try {
			CommodityDetailsPage.calculatingQ3calculationRmforCustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ3scrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 Scrap - " + e.getMessage());
		}

		// Q4: January, February, March
		try {
			CommodityDetailsPage.calculatingQ4rmvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ4scrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifycalculatefirstsixmonthaveragevalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year RM (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatehy1scrapvalue();
		} catch (AssertionError e) {
			System.err.println("Failed: First Half Year Scrap (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifycalculatesecondhalfyearcustomer();
		} catch (AssertionError e) {
			System.err.println("Failed: Second Half Year RM (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatehalfyearscrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌Failed: Second Half Year Scrap (Customer) - " + e.getMessage());
		}
	}

	@Test(priority = 10, groups = "group1")
	public void TC_YRLY_011QuarterlyAndHalfYearlyCalculationsForRmAndScrapForRandomEntries()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicked the Master Data successfully");
		Thread.sleep(2000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User entered the Commodity Master");
		Thread.sleep(3000);

		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainfirsttabforcalq1q2q3q4(commoditygroupvalue);
		Thread.sleep(3000);

		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		Thread.sleep(4000);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

		// Generate reusable randoms
		String random1 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String random2 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String random3 = String.valueOf("");

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalue(random3, random2, random3, random2, random2, random2,
				random1, random2, random3, random1, random3, random3, random2, random2, random2, random1, random2,
				random3, random1, random2, random2, random3, random2, random2, commoditygroupvalue);

		// Quarterly RM
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q1 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q2 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ3();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q3 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyRmAverageQ4();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q4 RM failed: " + e.getMessage());
		}

		// Quarterly Scrap
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q1 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q2 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ3();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q3 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyQuarterlyScrapAverageQ4();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ Q4 Scrap failed: " + e.getMessage());
		}

		// Half-Yearly RM
		try {
			CommodityDetailsPage.verifyHalfYearlyRmAverageH1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H1 RM failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyHalfYearlyRmAverageH2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H2 RM failed: " + e.getMessage());
		}

		// Half-Yearly Scrap
		try {
			CommodityDetailsPage.verifyHalfYearlyScrapAverageH1();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H1 Scrap failed: " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyHalfYearlyScrapAverageH2();
		} catch (Exception e) {
			LoggerUtil.mismatch("❌ H2 Scrap failed: " + e.getMessage());
		}
	}

////////////////////////////////////Customer Allocation Delta Unto FourDecimal ////////////////////////////////////////////////////////////////////////////////////////////////

@Test(priority = 14, groups = "group2")
public void TC_CD_014NegativeDeltaValueImpactInQuarterlyAndHalfYearlyCustomerAllocationForNegative()
throws InterruptedException {

String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
String updatedspecificgradevalue = faker.name().firstName();

// calculating customer Allocation For Possitive Number And Negative Number Both
dashboard.selectMenuFormDashBoard("Master Data");
Thread.sleep(3000);
dashboard.VerifyClickingMasterOptions("Commodity");
Thread.sleep(2000);
dashboard.clickOnAddcommodity();
Thread.sleep(2000);
CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
Thread.sleep(3000);
dashboard.clickOncommoditygroup();
CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
specificgragevalue, densityvalue);
Thread.sleep(4000);
dashboard.clickOnCommodityTabByName("Commodity Details");
Thread.sleep(3000);
CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
specificgragevalue);

// Generate random data
String random1 = String.valueOf(faker.number().numberBetween(100, 999));
String random2 = String.valueOf(faker.number().numberBetween(100, 999));
String random3 = String.valueOf(faker.number().numberBetween(100, 999));
String random4 = String.valueOf(faker.number().numberBetween(100, 999));

CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(random1, random2,
random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);

String randomsupp1 = String.valueOf(-faker.number().numberBetween(100, 999));
String randomsupp2 = String.valueOf(-faker.number().numberBetween(100, 999));
String randomsupp3 = String.valueOf(-faker.number().numberBetween(100, 999));
String randomsupp4 = String.valueOf(-faker.number().numberBetween(100, 999));

CommodityDetailsPage.verifyingcalculationofcustomerallocation(randomsupp1, randomsupp4, randomsupp3,
randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp2, randomsupp2, randomsupp4,
randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp4, randomsupp3,
randomsupp4, randomsupp4, randomsupp2, randomsupp1, randomsupp1, commoditygroupvalue);

// Call each method inside try-catch
try {
CommodityDetailsPage.verifyCalculateLandedCostForCustomerAprilMonth();
} catch (AssertionError e) {
LoggerUtil.fail("❌ Failed: April Landed Cost - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatemayrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: May RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatejunermandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: June RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatejulyrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: July RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculateaugustrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: August RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculateseptemberrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: September RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculateoctoberrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: October RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatenovemberrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: November RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatedecemberrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: December RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatejanrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: January RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatefebrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: February RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatemarchrmandscrapforcustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: March RM/Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatefirstQ1forcustomerallocationForRm();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q1 RM - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatefirstQ1forcustomerallocationForScrap();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q1 Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.verifyCalculatingCustomerAllocationSecondQ2ForRm();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q2 RM - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatingQ2ScrapValueForCustomerAllocation();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q2 Scrap - " + e.getMessage());
}

// Q3: October, November, December
try {
CommodityDetailsPage.calculatingQ3calculationRmforCustomer();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q3 RM - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatingQ3scrapvalue();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q3 Scrap - " + e.getMessage());
}

// Q4: January, February, March
try {
CommodityDetailsPage.calculatingQ4rmvalue();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q4 RM - " + e.getMessage());
}

try {
CommodityDetailsPage.calculatingQ4scrapvalue();
} catch (AssertionError e) {
System.err.println("❌ Failed: Q4 Scrap - " + e.getMessage());
}

try {
CommodityDetailsPage.verifycalculatefirstsixmonthaveragevalue();
} catch (AssertionError e) {
System.err.println("❌ Failed: First Half Year RM (Customer) - " + e.getMessage());
}
try {
CommodityDetailsPage.calculatehy1scrapvalue();
} catch (AssertionError e) {
System.err.println("Failed: First Half Year Scrap (Customer) - " + e.getMessage());
}
try {
CommodityDetailsPage.verifycalculatesecondhalfyearcustomer();
} catch (AssertionError e) {
System.err.println("Failed: Second Half Year RM (Customer) - " + e.getMessage());
}
try {
CommodityDetailsPage.calculatehalfyearscrapvalue();
} catch (AssertionError e) {
System.err.println("❌Failed: Second Half Year Scrap (Customer) - " + e.getMessage());
}

}

@Test(priority = 13, groups = "group2")
public void TC_CD_014NegativeDeltaValueImpactInQuarterlyAndHalfYearly() throws InterruptedException {

	String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	dashboard.selectMenuFormDashBoard("Master Data");
	Thread.sleep(3000);
	dashboard.VerifyClickingMasterOptions("Commodity");
	Thread.sleep(2000);
	dashboard.clickOnAddcommodity();
	CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
	Thread.sleep(5000);

	dashboard.clickOncommoditygroup();
	Thread.sleep(3000);

	CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
			specificgragevalue, densityvalue);
	Thread.sleep(4000);

	Thread.sleep(3000);
	dashboard.clickOnCommodityTabByName("Commodity Details");
	Thread.sleep(3000);
	CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
			specificgragevalue);

	String random1 = String.valueOf(faker.number().numberBetween(100, 999));
	String random2 = String.valueOf(faker.number().numberBetween(100, 999));
	String random3 = String.valueOf(faker.number().numberBetween(100, 999));
	String random4 = String.valueOf(faker.number().numberBetween(100, 999));

	CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
			random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
			random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);

	String randomsupp1 = String.valueOf(faker.number().numberBetween(1000, 9999));
	String randomsupp2 = String.valueOf(faker.number().numberBetween(1000, 9999));
	String randomsupp3 = String.valueOf(faker.number().numberBetween(1000, 9999));
	String randomsupp4 = String.valueOf(faker.number().numberBetween(1000, 9999));

	String suprandom1 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
	String suprandom2 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
	String suprandom3 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
	String suprandom4 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));

	QuickMasterPage.verifyingcalculationofsupplierallocation(suprandom1, suprandom2, suprandom4, suprandom3,
			suprandom3, suprandom1, suprandom2, suprandom1, suprandom1, suprandom1, suprandom2, suprandom1,
			suprandom4, suprandom3, suprandom1, suprandom3, suprandom1, suprandom1, suprandom3, suprandom2,
			suprandom2, suprandom1, suprandom1, suprandom1, commoditygroupvalue);

	Thread.sleep(16000);

	// Handling assertion failures for all steps
	try {
		CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: April Landed Cost (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparingLandedCostForMay();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: May Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: June Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparinglandedcostforjuly();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: July Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostforaugust();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: August Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForseptember();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: September Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForoctober();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: October Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForNovember();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: November Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForDecember();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: December Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForJan();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: January Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForFebruary();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: February Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.comparelandedcostForMarch();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: March Landed Cost - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q1 RM (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q1 Scrap (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q2 RM (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q2 Scrap (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q3 RM (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q3 Scrap Average (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q4 RM (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateQ4ScrapAverage();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Q4 Scrap Average (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: First Half Year RM (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: First Half Year Scrap (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Second Half Year RM (Supplier) - " + e.getMessage());
	}

	try {
		CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
	} catch (AssertionError e) {
		System.err.println("❌ Failed: Second Half Year Scrap (Supplier) - " + e.getMessage());
	}

}

	@Test(priority = 16, groups = "group2", enabled = false)
	public void TC_YRLY_013SpecificDeltaSupplierCustomerAllocationWithNegativeAndPossitiveBothForCustomerAllocation()
			throws InterruptedException {
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		

//calculating customer Allocation For Possitive Number And Negative Number Both 
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		Thread.sleep(4000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

// Generate random data
		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(faker.number().numberBetween(100, 999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(random1, random2, random3, random4,
				random1, random2, random3, random4, random1, random2, random3, random4, random1, random2, random3,
				random4, random1, random2, random3, random4, random1, random2, random3, random4);

		String randomsupp1 = String.valueOf(-faker.number().numberBetween(100, 999));
		String randomsupp2 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp3 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp4 = String.valueOf(-faker.number().numberBetween(100, 999));

		CommodityDetailsPage.verifyingcalculationofcustomerallocation(randomsupp1, randomsupp4, randomsupp3, randomsupp1, randomsupp1,
				randomsupp2, randomsupp3, randomsupp4, randomsupp2, randomsupp2, randomsupp4, randomsupp1, randomsupp1,
				randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp4, randomsupp3, randomsupp4, randomsupp4,
				randomsupp2, randomsupp1, randomsupp1, commoditygroupvalue);

// Call each method inside try-catch
		try {
			CommodityDetailsPage.verifyCalculateLandedCostForCustomerAprilMonth();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: April Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatemayrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: May RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejunermandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: June RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejulyrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: July RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateaugustrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: August RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateseptemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: September RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateoctoberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: October RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatenovemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: November RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatedecemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: December RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejanrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: January RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefebrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: February RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatemarchrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: March RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifyCalculatingCustomerAllocationSecondQ2ForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ2ScrapValueForCustomerAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 Scrap - " + e.getMessage());
		}

// Q3: October, November, December
		try {
			CommodityDetailsPage.calculatingQ3calculationRmforCustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ3scrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 Scrap - " + e.getMessage());
		}

// Q4: January, February, March
		try {
			CommodityDetailsPage.calculatingQ4rmvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ4scrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifycalculatefirstsixmonthaveragevalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year RM (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatehy1scrapvalue();
		} catch (AssertionError e) {
			System.err.println("Failed: First Half Year Scrap (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifycalculatesecondhalfyearcustomer();
		} catch (AssertionError e) {
			System.err.println("Failed: Second Half Year RM (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatehalfyearscrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌Failed: Second Half Year Scrap (Customer) - " + e.getMessage());
		}
	}

	@Test(priority = 14, groups = "group2")
	public void TC_CD_013SpecificDeltaCustomerAllocation() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String updatedspecificgradevalue = faker.name().firstName();

		// calculating customer Allocation For Possitive Number And Negative Number Both
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(4000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue);

		// Generate random data
		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(faker.number().numberBetween(100, 999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(random1, random2,
				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);

		String randomsupp1 = String.valueOf(-faker.number().numberBetween(100, 999));
		String randomsupp2 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp3 = String.valueOf(faker.number().numberBetween(100, 999));
		String randomsupp4 = String.valueOf(-faker.number().numberBetween(100, 999));

		CommodityDetailsPage.verifyingcalculationofcustomerallocation(randomsupp1, randomsupp4, randomsupp3,
				randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp2, randomsupp2, randomsupp4,
				randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp4, randomsupp3,
				randomsupp4, randomsupp4, randomsupp2, randomsupp1, randomsupp1, commoditygroupvalue);

		// Call each method inside try-catch
		try {
			CommodityDetailsPage.verifyCalculateLandedCostForCustomerAprilMonth();
		} catch (AssertionError e) {
			LoggerUtil.fail("❌ Failed: April Landed Cost - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatemayrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: May RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejunermandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: June RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejulyrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: July RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateaugustrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: August RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateseptemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: September RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculateoctoberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: October RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatenovemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: November RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatedecemberrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: December RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatejanrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: January RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefebrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: February RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatemarchrmandscrapforcustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: March RM/Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForScrap();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q1 Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifyCalculatingCustomerAllocationSecondQ2ForRm();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ2ScrapValueForCustomerAllocation();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q2 Scrap - " + e.getMessage());
		}

		// Q3: October, November, December
		try {
			CommodityDetailsPage.calculatingQ3calculationRmforCustomer();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ3scrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q3 Scrap - " + e.getMessage());
		}

		// Q4: January, February, March
		try {
			CommodityDetailsPage.calculatingQ4rmvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 RM - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.calculatingQ4scrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: Q4 Scrap - " + e.getMessage());
		}

		try {
			CommodityDetailsPage.verifycalculatefirstsixmonthaveragevalue();
		} catch (AssertionError e) {
			System.err.println("❌ Failed: First Half Year RM (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatehy1scrapvalue();
		} catch (AssertionError e) {
			System.err.println("Failed: First Half Year Scrap (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifycalculatesecondhalfyearcustomer();
		} catch (AssertionError e) {
			System.err.println("Failed: Second Half Year RM (Customer) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatehalfyearscrapvalue();
		} catch (AssertionError e) {
			System.err.println("❌Failed: Second Half Year Scrap (Customer) - " + e.getMessage());
		}

	}

	@Test(priority = 17, groups = "group2")
	public void TC_YRLY_013SpecificDeltaSupplierCustomerAllocationForSupplierOnlyNegative()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String updatedspecificgradevalue = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		Thread.sleep(4000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

		String random1 = String.valueOf(-faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(-faker.number().numberBetween(100, 999));

		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2, random3, random4,
				random1, random2, random3, random4, random1, random2, random3, random4, random1, random2, random3,
				random4, random1, random2, random3, random4, random1, random2, random3, random4);

		String randomsupp1 = String.valueOf(-faker.number().numberBetween(1000, 9999));
		String randomsupp2 = String.valueOf(-faker.number().numberBetween(1000, 9999));
		String randomsupp3 = String.valueOf(-faker.number().numberBetween(1000, 9999));
		String randomsupp4 = String.valueOf(-faker.number().numberBetween(1000, 9999));

		CommodityDetailsPage.verifyingcalculationofsupplierallocation(randomsupp3, randomsupp1, randomsupp1, randomsupp3, randomsupp2,
				randomsupp4, randomsupp2, randomsupp4, randomsupp4, randomsupp2, randomsupp4, randomsupp1, randomsupp1,
				randomsupp3, randomsupp2, randomsupp3, randomsupp3, randomsupp2, randomsupp3, randomsupp2, randomsupp1,
				randomsupp1, randomsupp1, randomsupp4, commoditygroupvalue);

		Thread.sleep(4000);

		// Utility method for error logging
		Consumer<String> mismatchLogger = label -> LoggerUtil.mismatch("❌ FAILED: " + label);

		// Continue verifications without stopping on mismatch
		try {
			CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
		} catch (AssertionError e) {
			mismatchLogger.accept("April RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparingLandedCostForMay();
		} catch (AssertionError e) {
			mismatchLogger.accept("May RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
		} catch (AssertionError e) {
			mismatchLogger.accept("June RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparinglandedcostforjuly();
		} catch (AssertionError e) {
			mismatchLogger.accept("July RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostforaugust();
		} catch (AssertionError e) {
			mismatchLogger.accept("August RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForseptember();
		} catch (AssertionError e) {
			mismatchLogger.accept("September RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForoctober();
		} catch (AssertionError e) {
			mismatchLogger.accept("October RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForNovember();
		} catch (AssertionError e) {
			mismatchLogger.accept("November RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForDecember();
		} catch (AssertionError e) {
			mismatchLogger.accept("December RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForJan();
		} catch (AssertionError e) {
			mismatchLogger.accept("January RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForFebruary();
		} catch (AssertionError e) {
			mismatchLogger.accept("February RM/Scrap Landed Cost - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.comparelandedcostForMarch();
		} catch (AssertionError e) {
			mismatchLogger.accept("March RM/Scrap Landed Cost - " + e.getMessage());
		}

		// Explicit checks for Q1/Q2 with assertion for scale > 3
		try {
			CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
		} catch (AssertionError e) {
			if (e.getMessage().contains("scale")) {
				LoggerUtil.mismatch("❌ FAILED: Q1 RM (Supplier) - " + e.getMessage());
			} else {
				LoggerUtil.mismatch("❌ FAILED: Q1 RM (Supplier) - " + e.getMessage());
			}
		}

		try {
			CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
		} catch (AssertionError e) {
			if (e.getMessage().contains("scale")) {
				LoggerUtil.mismatch("❌ FAILED: Q1 Scrap (Supplier) - " + e.getMessage());
			} else {
				LoggerUtil.mismatch("❌ FAILED: Q1 Scrap (Supplier) - " + e.getMessage());
			}
		}

		try {
			CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
		} catch (AssertionError e) {
			if (e.getMessage().contains("scale")) {
				LoggerUtil.mismatch("❌ FAILED: Q2 RM (Supplier) - " + e.getMessage());
			} else {
				LoggerUtil.mismatch("❌ FAILED: Q2 RM (Supplier) - " + e.getMessage());
			}
		}

		try {
			CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
		} catch (AssertionError e) {
			if (e.getMessage().contains("scale")) {
				LoggerUtil.mismatch("❌ FAILED: Q2 Scrap (Supplier) - " + e.getMessage());
			} else {
				LoggerUtil.mismatch("❌ FAILED: Q2 Scrap (Supplier) - " + e.getMessage());
			}
		}

		try {
			CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
		} catch (AssertionError e) {
			mismatchLogger.accept("Q3 RM (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
		} catch (AssertionError e) {
			mismatchLogger.accept("Q3 Scrap Average (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
		} catch (AssertionError e) {
			mismatchLogger.accept("Q4 RM (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculateQ4ScrapAverage();
		} catch (AssertionError e) {
			mismatchLogger.accept("Q4 Scrap Average (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
		} catch (AssertionError e) {
			mismatchLogger.accept("First Half Year RM (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
		} catch (AssertionError e) {
			mismatchLogger.accept("First Half Year Scrap (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
		} catch (AssertionError e) {
			mismatchLogger.accept("Second Half Year RM (Supplier) - " + e.getMessage());
		}
		try {
			CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
		} catch (AssertionError e) {
			mismatchLogger.accept("Second Half Year Scrap (Supplier) - " + e.getMessage());
		}
	}
	@Test(priority = 15, groups = "group1")
	public void TC_CD_015SaveCommodityDetails() throws InterruptedException {
		HashMap<String, String> Comdetailsname = new HashMap<String, String>();
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		Thread.sleep(5000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(4000);
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Comdetailsname.put("commoditygroupvalue", commoditygroupvalue);
		Comdetailsname.put("GroupClassification", groupclassificationvalue);
		Comdetailsname.put("SpecificGrade", specificgragevalue);

		QuickMasterPage.verifyFetchinganmeComdetailsTab(Comdetailsname, commoditygroupvalue);

	}

	@Test(priority = 16, groups = "group2")
	public void TC_CD_015UpdtaedCommodityDetails() throws InterruptedException {
		HashMap<String, String> Comdetailsname = new HashMap<String, String>();
		HashMap<String, String> UpdatedComdetailsname = new HashMap<String, String>();

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String updatedClassification = faker.name().firstName() + "" + faker.letterify("???????");
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		LoggerUtil.info("===== Scenario Start: TC_CD_015UpdtaedCommodityDetails =====");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		// Step 1: Save Commodity Group first time
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		LoggerUtil.pass("Step 1: Commodity Group saved successfully with value → " + commoditygroupvalue);

		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		// Step 2: Save classification first time
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		LoggerUtil.pass("Step 2: First Group Classification saved → " + groupclassificationvalue);

		Thread.sleep(5000);

		// Step 3: Save classification second time (reserve for update)
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, updatedClassification, specificgragevalue,
				densityvalue);
		LoggerUtil.pass("Step 3: Second Group Classification (reserved for update) saved → " + updatedClassification);

		Thread.sleep(5000);

		// Step 4: Save details in 3rd tab
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(4000);
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		LoggerUtil.pass("Step 4: Commodity Details saved in 3rd tab with Group: " + commoditygroupvalue
				+ ", Classification: " + groupclassificationvalue + ", Specific Grade: " + specificgragevalue);

		// Prepare expected values before update
		Comdetailsname.put("commoditygroupvalue", commoditygroupvalue);
		Comdetailsname.put("GroupClassification", groupclassificationvalue);
		Comdetailsname.put("SpecificGrade", specificgragevalue);

		// Step 5: Verify update with reserved classification
		QuickMasterPage.VerifyUpdatedCommodityHasBeenSucessFullyUpdatedOrNot(Comdetailsname, commoditygroupvalue,
				updatedClassification, specificgragevalue, "Commodity details saved successfully.");

		// Prepare expected values after update
		UpdatedComdetailsname.put("Commodity Group", commoditygroupvalue);
		UpdatedComdetailsname.put("Group classification", updatedClassification);
		UpdatedComdetailsname.put("Specific Grade", specificgragevalue);

		// Step 6: Verify fetched updated data
		QuickMasterPage.VerifyFetchingUpdatedData(UpdatedComdetailsname, updatedClassification);

		LoggerUtil.info("===== Scenario End: TC_CD_015UpdtaedCommodityDetails =====");
	}

	@Test(priority = 16, groups = "group2")
	public void TC_CD_015SaveAsNew() throws InterruptedException {
		HashMap<String, String> Comdetailsname = new HashMap<String, String>();
		HashMap<String, String> SaveAsNewComdetailsname = new HashMap<String, String>();

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String SaveAsNewClassification = faker.name().firstName() + "" + faker.letterify("???????");
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		LoggerUtil.info("===== Scenario Start: TC_CD_015SaveAsNew =====");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		// Step 1: Save Commodity Group first time
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		LoggerUtil.pass("Step 1: Commodity Group saved successfully with value → " + commoditygroupvalue);

		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);

		// Step 2: Save classification first time
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, densityvalue);
		LoggerUtil.pass("Step 2: First Group Classification saved → " + groupclassificationvalue);

		Thread.sleep(5000);

		// Step 3: Save classification second time (Save As New reserved entry)
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, SaveAsNewClassification,
				specificgragevalue, densityvalue);
		LoggerUtil.pass("Step 3: Save As New Classification saved → " + SaveAsNewClassification);

		Thread.sleep(5000);

		// Step 4: Save details in 3rd tab
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(4000);
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		LoggerUtil.pass("Step 4: Commodity Details saved in 3rd tab with Group: " + commoditygroupvalue
				+ ", Classification: " + groupclassificationvalue + ", Specific Grade: " + specificgragevalue);

		// Prepare expected values before Save As New
		Comdetailsname.put("commoditygroupvalue", commoditygroupvalue);
		Comdetailsname.put("GroupClassification", groupclassificationvalue);
		Comdetailsname.put("SpecificGrade", specificgragevalue);

		// Step 5: Verify Save As New entry creation
		QuickMasterPage.VerifySaveAsNewDataHasBeenSucessFullyCreatedNewEntryOrNot(Comdetailsname, commoditygroupvalue,
				SaveAsNewClassification, specificgragevalue, "Commodity details saved successfully.");

		// Prepare expected values for Save As New verification
		SaveAsNewComdetailsname.put("Commodity Group", commoditygroupvalue);
		SaveAsNewComdetailsname.put("Group classification", SaveAsNewClassification);
		SaveAsNewComdetailsname.put("Specific Grade", specificgragevalue);

		// Step 6: Verify fetched Save As New data
		QuickMasterPage.VerifyFetchingSaveAsNewData(SaveAsNewComdetailsname, SaveAsNewClassification);

		Thread.sleep(4000);
		QuickMasterPage.verifyOldDataAsItIsOrNot(Comdetailsname, commoditygroupvalue, SaveAsNewClassification,
				specificgragevalue);

		LoggerUtil.info("===== Scenario End: TC_CD_015SaveAsNew =====");
	}

	@Test(priority = 20, groups = "group2")
	public void TC_YRLY_017ShapeSelectionIBeamCorrectValueTableDisplay() throws InterruptedException {
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		comd.savedataforforIBeamvalueinShapeDropdown(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
		String random5 = String.valueOf(faker.number().numberBetween(100, 999));

		comd.enterparametevalueorsizeforibeam(random1, random2, random3, random4, random5, commoditygroupvalue);

	}

	@Test(priority = 21, groups = "group2")
	public void TC_YRLY_018SameGradeWithMultipleShapeEntries() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		comd.savedatainthirdtabforsamedifferentshape(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				commoditygroupvalue);
		Thread.sleep(4000);

	}

	@Test(priority = 21, groups = "group1")
	public void TC_YRLY_019DuplicateGradeCheckWithSameSupplierCustomer() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.savedatainthirdtabforexistingvalue(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				commoditygroupvalue);

	}

	@Test(priority = 22, groups = "group1")
	public void TC_YRLY_020PlasticPropertiesVisibilityForPlastics() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Click The Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User click The commoidty master");
		Thread.sleep(2000);
		LoggerUtil.info("User Enter The Commodity details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifyplasticpropertyVisibility();

	}

	@Test(priority = 23, groups = "group1")
	public void TC_YRLY_021AddNewSupplierAndResetFields() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String updatedspecificgradevalue = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Click The Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User click The commoidty master");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User Enter The Commodity details tab");
		Thread.sleep(3000);
		comd.addnewsupplierandsaveandverifyresetbtn(commoditygroupvalue, specificgragevalue);

	}

	@Test(priority = 24, groups = "group1")
	public void TC_YRLY_022NewSupplierAppearsInstantlyInDropdownWithoutRefresh() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String updatedspecificgradevalue = faker.name().firstName();

		// Step 1: Navigate to Commodity Master > Details Tab
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		// Step 2: Add New Supplier
		comd.addnewsupplierandsaveandverifyresetbtn(commoditygroupvalue, specificgragevalue);

		// Step 3: Construct expected supplier display name
		String expectedSupplierDisplayName = specificgragevalue + "-" + commoditygroupvalue + "-";

		// Step 4: Verify new supplier appears without refresh
		comd.verifynewsupplierinmainpagewithoutrefreshingAfteraddnewsupp(expectedSupplierDisplayName);
	}

	@Test(priority = 25, groups = "group1")
	public void TC_YRLY_023SupplierSavePromptValidation() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		CommodityDetailsPage.verifySavenewsupplierpromptnotification(commoditygroupvalue, groupclassificationvalue,
				" Supplier saved sucessfully.");

	}

	@Test(priority = 57, groups = "group1")
	public void TC_CD_023CustomerSavePromptValidation() throws InterruptedException {

		String CustomerName = faker.name().firstName()+faker.letterify("??????");
		String Customercode = faker.number().digits(5);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		QuickMasterPage.VerifyAddCustomerToast(CustomerName,Customercode,"Customer Saved successfully.");
		
	}
	
	
	
	@Test(priority = 26, groups = "group1")
	public void TC_YRLY_024ExportPriceUpdate() throws InterruptedException, IOException {

		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String,String> FetchingBaseRmAndScrapPrices = new HashMap<String ,String >();
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String densityvalue =faker.number().digits(4);
			
			LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Click on Commodity Master");
			dashboard.VerifyClickingMasterOptions("Commodity");
			Thread.sleep(3000);

			LoggerUtil.info("Step 3: Click on Add Commodity");
			dashboard.clickOnAddcommodity();
			Thread.sleep(3000);
			CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
			Thread.sleep(3000);

			LoggerUtil.info("Step 4: Fill Commodity Group details");
			dashboard.clickOncommoditygroup();
			Thread.sleep(3000);
			CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
			Thread.sleep(3000);

			LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(2000);
			CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
			Thread.sleep(3000);
			FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
			FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
			FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
			
			// Random values generate karo
			String random1 = String.valueOf(faker.number().numberBetween(100, 999));
			String random2 = String.valueOf(faker.number().numberBetween(100, 999));
			String random3 = String.valueOf(faker.number().numberBetween(100, 999));
			String random4 = String.valueOf(faker.number().numberBetween(100, 999));

			QuickMasterPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(    
			    random1, random2,   
			    random3, random4,   
			    random1, random2,   
			    random3, random4,   
			    random1, random2,   
			    random3, random4,   
			    random1, random2,   
			    random3, random4,   
			    random1, random2,  
			    random3, random4,   
			    random1, random2,   
			    random3, random4,"Commodity details saved successfully."    
			);
			
			FetchingBaseRmAndScrapPrices.put("April Rm", random1);
			FetchingBaseRmAndScrapPrices.put("April Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("May Rm", random3);
			FetchingBaseRmAndScrapPrices.put("May Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("June Rm", random1);
			FetchingBaseRmAndScrapPrices.put("June Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("July Rm", random3);
			FetchingBaseRmAndScrapPrices.put("July Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("August Rm", random1);
			FetchingBaseRmAndScrapPrices.put("August Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("September Rm", random3);
			FetchingBaseRmAndScrapPrices.put("September Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("October Rm", random1);
			FetchingBaseRmAndScrapPrices.put("October Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("November Rm", random3);
			FetchingBaseRmAndScrapPrices.put("November Scrap ", random4);
			FetchingBaseRmAndScrapPrices.put("December Rm", random1);
			FetchingBaseRmAndScrapPrices.put("December Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("Jan Rm", random3);
			FetchingBaseRmAndScrapPrices.put("Jan Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("Feb Rm", random1);
			FetchingBaseRmAndScrapPrices.put("Feb Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("March Rm", random3);
			FetchingBaseRmAndScrapPrices.put("March Scrap", random4);
			
			
		   QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		   
		   QuickMasterPage.VerifyExcelAndUiDataHasBeenEqualOrNotForPriceUpdate(FetchComDetailsNameAndSpecificGrade,FetchingBaseRmAndScrapPrices);
	}

	
	@Test(priority = 26, groups = "group1")
	public void TC_YRLY_024ExportPriceUpdateForNegativePrice() throws InterruptedException, IOException {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String,String> FetchingBaseRmAndScrapPrices = new HashMap<String ,String >();
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String densityvalue =faker.number().digits(4);
			
			LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);

			LoggerUtil.info("Step 2: Click on Commodity Master");
			dashboard.VerifyClickingMasterOptions("Commodity");
			Thread.sleep(3000);

			LoggerUtil.info("Step 3: Click on Add Commodity");
			dashboard.clickOnAddcommodity();
			Thread.sleep(3000);
			CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
			Thread.sleep(3000);

			LoggerUtil.info("Step 4: Fill Commodity Group details");
			dashboard.clickOncommoditygroup();
			Thread.sleep(3000);
			CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
			Thread.sleep(3000);

			LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(2000);
			CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
			Thread.sleep(3000);
			FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
			FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
			FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
			
			// Random values generate karo
			String random1 = String.valueOf(-faker.number().numberBetween(100, 999));
			String random2 = String.valueOf(-faker.number().numberBetween(100, 999));
			String random3 = String.valueOf(-faker.number().numberBetween(100, 999));
			String random4 = String.valueOf(-faker.number().numberBetween(100, 999));

			QuickMasterPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(    
			    random1, random2,   
			    random3, random4,   
			    random1, random2,   
			    random3, random4,   
			    random1, random2,   
			    random3, random4,   
			    random1, random2,   
			    random3, random4,   
			    random1, random2,  
			    random3, random4,   
			    random1, random2,   
			    random3, random4,"Commodity details saved successfully."    
			);
			
			FetchingBaseRmAndScrapPrices.put("April Rm", random1);
			FetchingBaseRmAndScrapPrices.put("April Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("May Rm", random3);
			FetchingBaseRmAndScrapPrices.put("May Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("June Rm", random1);
			FetchingBaseRmAndScrapPrices.put("June Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("July Rm", random3);
			FetchingBaseRmAndScrapPrices.put("July Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("August Rm", random1);
			FetchingBaseRmAndScrapPrices.put("August Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("September Rm", random3);
			FetchingBaseRmAndScrapPrices.put("September Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("October Rm", random1);
			FetchingBaseRmAndScrapPrices.put("October Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("November Rm", random3);
			FetchingBaseRmAndScrapPrices.put("November Scrap ", random4);
			FetchingBaseRmAndScrapPrices.put("December Rm", random1);
			FetchingBaseRmAndScrapPrices.put("December Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("Jan Rm", random3);
			FetchingBaseRmAndScrapPrices.put("Jan Scrap", random4);
			FetchingBaseRmAndScrapPrices.put("Feb Rm", random1);
			FetchingBaseRmAndScrapPrices.put("Feb Scrap", random2);
			FetchingBaseRmAndScrapPrices.put("March Rm", random3);
			FetchingBaseRmAndScrapPrices.put("March Scrap", random4);
			
			
		   QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		   
		   QuickMasterPage.VerifyExcelAndUiDataHasBeenEqualOrNotForPriceUpdate(FetchComDetailsNameAndSpecificGrade,FetchingBaseRmAndScrapPrices);
		
		
		
	}

	@Test(priority=59,groups="group1")
	public void TC_CD_025ExportGroupDelta() throws InterruptedException, FileNotFoundException, IOException {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		double AprilRmDouble =  faker.number().randomDouble(3, 100, 999);
		String AprilValue = String.valueOf(AprilRmDouble);
		double AprilScrapDouble =  faker.number().randomDouble(3, 100, 999);
		String AprilScrapValue = String.valueOf(AprilScrapDouble);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 4: Fill Commodity Group Tab");
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		Thread.sleep(2000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
		
		
		
		
		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		QuickMasterPage.ReadingValueInSecondSheetAndVerifyAllUiValueDownLoadAccuratelyoRNotInGroupDeltaExcelFile(fetchingRmAndScrapValues);
		
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFile();
		Thread.sleep(3000);
		
		QuickMasterPage.VerifyReflectionOnSecondSheet(FetchingRmAndScrapData, fetchingRmAndScrapValues);

	}
	
	@Test(priority=60,groups="group1")
	public void TC_CD_026ExportGroupDirectCost() throws InterruptedException, FileNotFoundException, IOException {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		
		String AprilValue = faker.number().digits(3);
	
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 4: Fill Commodity Group ");
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
		
		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyInUiOrNotForDirectPrice(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		Thread.sleep(2000);
		QuickMasterPage.ReadingValueInSecondSheetAndVerifyAllUiValueDownLoadAccuratelyoRNotInDirectPriceExcelFile(fetchingRmAndScrapValues);
		Thread.sleep(3000);
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDirectPriceExcelFile();
			Thread.sleep(3000);
			
			QuickMasterPage.VerifyReflectionOnSecondSheetForDirectprice(FetchingRmAndScrapData);
	}
	
	
	
	

	
	@Test(priority=62,groups="group1")
	public void TC_CD_028ImportGroupDeltaExcelFileAndValidateAllDataHasBeenLoadedCorrectlyOrNot() throws InterruptedException, FileNotFoundException, IOException, AWTException {
		
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		String AprilValue = faker.number().digits(3);
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(6000);

		
		dashboard.clickOncommoditygroup();
		Thread.sleep(5000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		Thread.sleep(2000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
		
		
      QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		
		
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFile();
		Thread.sleep(3000);
		
		QuickMasterPage.importGroupDeltaFileAndCheckImpactOnUi();
		
		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		Thread.sleep(2000);
		QuickMasterPage.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromGroupDeltaExcelFile(fetchingRmAndScrapValues, FetchingRmAndScrapData);
		
		
	}
	@Test(priority=63,groups="group1")
	public void TC_CD_028ImportDirectPriceExcelFileAndValidateAllDataHasBeenLoadedCorrectlyOrNot() throws InterruptedException, FileNotFoundException, IOException, AWTException {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		
		String AprilValue = faker.number().digits(3);
	
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);

		
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);	
        QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyInUiOrNotForDirectPrice(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		Thread.sleep(2000);
		QuickMasterPage.ReadingValueInSecondSheetAndVerifyAllUiValueDownLoadAccuratelyoRNotInDirectPriceExcelFile(fetchingRmAndScrapValues);
		Thread.sleep(3000);
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDirectPriceExcelFile();
			Thread.sleep(3000);
			
			QuickMasterPage.VerifyReflectionOnSecondSheetForDirectprice(FetchingRmAndScrapData);

		    QuickMasterPage.importDirectPriceExcelFileAndCheckImpactOnUi();
		   
		    QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
			Thread.sleep(2000);
		
		QuickMasterPage.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromDirectPriceExcelFile(FetchingRmAndScrapData);
	}
	@Test(priority=64,groups="group1")
	public void TC_CD_028ImportNewGradeAdditionExcelFileAndValidateAllDataHasBeenLoadedCorrectlyOrNot() throws InterruptedException, FileNotFoundException, IOException, AWTException {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		
		String AprilValue = faker.number().digits(3);
	
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 4: Fill Commodity Group details");
		dashboard.clickOncommoditygroup();
		Thread.sleep(3000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		FetchComDetailsNameAndSpecificGrade.put("Density-From-Ui",densityvalue);
        QuickMasterPage.SaveNewGradeAddition("Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);	
		
		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyInUiOrNotForNewGradeAddition(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue,"Mk-2208-5-Mohali");
	
		fetchingRmAndScrapValues.put("CustomerName", "Mk-2208-5-Mohali");
		
		QuickMasterPage.VerifyReadExcelDataForCustomerNameAsItIsFromUiOrNot(fetchingRmAndScrapValues);
		
		
			HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.FillingNewGradeAdditionForExcelFile(FetchComDetailsNameAndSpecificGrade);
		
		QuickMasterPage.importNewGradeAdditionExcelFileAndCheckImpactOnUi();
		
		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		Thread.sleep(5000);
		
		QuickMasterPage.VerifyValidateAllDataFromNewGradeExcelFileHasBeenImportedCorrectlyOrNot(
                 FetchingRmAndScrapData,
                 FetchComDetailsNameAndSpecificGrade);
		
		
		
	}
	@Test(priority=65,groups="group1")
	public void TC_CD_033ViewDomesticToggle() throws InterruptedException {
		
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(4000);
		  clickOnElement(QuickMasterPage.ClickingDomesticRadionBtn);
		  
  	    Thread.sleep(2000);
		QuickMasterPage.verifyRadioButtonsIsDependOnYearlyDomesticAndImported("Type","Domestic");
	
	}
	
	
	@Test(priority=65,groups="group1")
	public void TC_CD_033ViewImportedToggle() throws InterruptedException {
		
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(4000);
		  clickOnElement(QuickMasterPage.ClickingImportedRadioBtn);
		  
  	    Thread.sleep(2000);
		QuickMasterPage.verifyRadioButtonsIsDependOnYearlyDomesticAndImported("Type","Imported");
	
	}
	
	
	
	
	@Test(priority = 30, groups = "group1")
	public void TC_YRLY_034_ViewYearwiseDropdownAndLastPricePull() throws Exception {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		int densityInt = faker.number().numberBetween(1000, 9999);
		String densityValue = String.valueOf(densityInt);

		String random1 = String.format("%.3f", faker.number().randomDouble(3, 10, 100));
		String random2 = String.format("%.3f", faker.number().randomDouble(3, 10, 100));
		String random3 = String.format("%.3f", faker.number().randomDouble(3, 10, 100));
		String random11 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String random21 = String.valueOf(faker.number().numberBetween(1000, 9999));
		String random31 = String.valueOf(faker.number().numberBetween(1000, 9999));

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityValue);
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.savedatathirdtabforinsertingForcomparingExcelSheetWithUi(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue);
		Thread.sleep(2000);

		comd.entervaluesinrmandscrapforupdatingyearwise(random1, random2, random3, random1, random2, random3, random1,
				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
				random1, random2, random3, random1, random2, random3, commoditygroupvalue);
		comd.fetchingyearwisepriceandupdatingdifferentyearwithdifferentpriceandverifyingafterupdating(

				random31, random21, random11, random21, random31, random11, random11, random31, random21, random31,
				random21, random31, random21, random11, random31, random11, random31, random21, random31, random21,
				random31, random11, random11, random31, commoditygroupvalue, random1, random2, random2, random1);

	}

	@Test(priority = 31, groups = "group2")
	public void TC_YRLY_035ViewMatchTotalCountAfterSearch() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User clicking commoditydetails tab");
		Thread.sleep(2000);
		comd.verifysearchfilterareworkedproperarenot("ABCDEF", "ABC", "CRCA");

	}

	@Test(priority = 32, groups = "group2")
	public void TC_YRLY_036ViewSortingFunctionality() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User clicking commoditydetails tab");
		Thread.sleep(2000);
		comd.verifysortingfunctionality();

	}

	@Test(priority = 33, groups = "group2")
	public void TC_YRLY_037ViewDefaultViewModeIsYearly() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User clicking commoditydetails tab");
		Thread.sleep(2000);
		comd.verifyBydefaultyearcolumn();

	}

	int whatif1 = faker.number().numberBetween(1000, 9999);
	int whatif2 = faker.number().numberBetween(1000, 9999);
	int whatif3 = faker.number().numberBetween(1000, 9999);
	int scrapcost1 = faker.number().numberBetween(1000, 9999);
	int scrapcost2 = faker.number().numberBetween(1000, 9999);
	int scrapcost3 = faker.number().numberBetween(1000, 9999);
	String groupclassificationvalue1 = faker.name().firstName() + faker.number().numberBetween(10, 99);

	@Test(priority = 34, groups = "group2")
	public void TC_YRLY_038WhatIfPricesSaveUpdateAndSaveAsNew() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		

		String whatif1 = String.valueOf(faker.number().numberBetween(10, 99));
		String whatif2 = String.valueOf(faker.number().numberBetween(10, 99));
		String whatif3 = String.valueOf(faker.number().numberBetween(10, 99));
		String scrapcost1 = String.valueOf(faker.number().numberBetween(10, 99));
		String scrapcost2 = String.valueOf(faker.number().numberBetween(10, 99));
		String scrapcost3 = String.valueOf(faker.number().numberBetween(1, 9));
		String whatif11 = String.valueOf(faker.number().numberBetween(100, 999));
		String whatif21 = String.valueOf(faker.number().numberBetween(100, 999));
		String whatif31 = String.valueOf(faker.number().numberBetween(100, 990));
		String scrapcost11 = String.valueOf(faker.number().numberBetween(100, 909));
		String scrapcost21 = String.valueOf(faker.number().numberBetween(100, 909));
		String scrapcost31 = String.valueOf(faker.number().numberBetween(10, 90));
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(2000);
		System.out.println(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.savedatainthirdtabForWhatIfAnalysis(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				whatif1, whatif2, whatif3, scrapcost1, scrapcost2, scrapcost3, commoditygroupvalue);
		comd.updatewhatifprice(whatif11, whatif21, whatif31, scrapcost11, scrapcost21, scrapcost31,
				commoditygroupvalue);

	}

	String commoditygroupvaluesaveasnew = faker.name().firstName();
	String groupclassificationvaluesaveasnew = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	String specificgragevaluesaveasnew = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	String densityvaluesaveasnew = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	@Test(priority = 24, groups = "group2")
	public void TC_YRLY_038WhatIfPricesSaveUpdateAndSaveAsNewForsaveAsNew() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String updatedspecificgradevalue = faker.name().firstName();
		String whatif1 = String.valueOf(faker.number().numberBetween(10, 99));
		String whatif2 = String.valueOf(faker.number().numberBetween(10, 99));
		String whatif3 = String.valueOf(faker.number().numberBetween(10, 99));
		String scrapcost1 = String.valueOf(faker.number().numberBetween(10, 99));
		String scrapcost2 = String.valueOf(faker.number().numberBetween(10, 99));
		String scrapcost3 = String.valueOf(faker.number().numberBetween(1, 9));
		String whatif11 = String.valueOf(faker.number().numberBetween(100, 999));
		String whatif21 = String.valueOf(faker.number().numberBetween(100, 999));
		String whatif31 = String.valueOf(faker.number().numberBetween(100, 990));
		String scrapcost11 = String.valueOf(faker.number().numberBetween(100, 909));
		String scrapcost21 = String.valueOf(faker.number().numberBetween(100, 909));
		String scrapcost31 = String.valueOf(faker.number().numberBetween(10, 90));

		String commoditygroupvaluesaveasnew = faker.name().firstName();
		String groupclassificationvaluesaveasnew = faker.name().firstName() + " "
				+ faker.number().numberBetween(10, 99);
		String specificgragevaluesaveasnew = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvaluesaveasnew = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		Thread.sleep(3000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
		Thread.sleep(2000);
		System.out.println(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		Thread.sleep(7000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.savedatainthirdtabForWhatIfAnalysis(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				whatif1, whatif2, whatif3, scrapcost1, scrapcost2, scrapcost3, commoditygroupvalue);

		Thread.sleep(2000);
		comd.saveasnewdataInWhatIfAnalysis(commoditygroupvaluesaveasnew, commoditygroupvaluesaveasnew,
				groupclassificationvalue, specificgragevalue, densityvalue, commoditygroupvaluesaveasnew,
				groupclassificationvalue, specificgragevalue, whatif1, whatif2, whatif3, scrapcost1, scrapcost2,
				scrapcost3, commoditygroupvaluesaveasnew);

	}

	@Test(priority = 25, groups = "group2")
	public void TC_YRLY_043ValidationForMissingCommodityGroupClassificationDuringExportImport()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);
		comd.verifyexportandimportpromtforcomgrpandcomclassification();

	}

	@Test(priority = 21, groups = "group4",enabled=false)
	public void TC_DI_006UserRightsSupplierAndCustomerVisibility() throws InterruptedException {

		Thread.sleep(8000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data successfully.");
		Thread.sleep(3000);
		dashboard.clickOnControlMaster();
		LoggerUtil.info("User entered the Control Master tab.");
		dashboard.clickOnusermaster();
		LoggerUtil.info("User entered the User Master tab.");
		Thread.sleep(3000);
		comd.customerinvisiblityafteruserRight();

	}

	@Test(priority = 21, groups = "group4",enabled=false)
	public void TC_DI_006UserRightsSupplierAndCustomerVisibilityForSupplierVisibility() throws InterruptedException {

		Thread.sleep(8000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data successfully.");
		Thread.sleep(3000);
		dashboard.clickOnControlMaster();
		LoggerUtil.info("User entered the Control Master tab.");
		dashboard.clickOnusermaster();
		LoggerUtil.info("User entered the User Master tab.");
		Thread.sleep(3000);
		comd.supplierinvisiblityafteruserRight();

	}

//		 @Test(priority=22,groups="group1")
//		 public void TC_YRLY_029ImportDeltaYearChangedBehavior() throws InterruptedException {			 
//			String randomNumber11= String.valueOf(randomNumber);
//		String randomNumber12=	 String.valueOf(randomNumber2);
//		Thread.sleep(3000);
//		 dashboard.selectMenuFormDashBoard("Master Data");
//		 LoggerUtil.info("User clicked The Master Data");
//		 dashboard.clickoncommodityMaster();
//		 dashboard.clickOnAddcommodity();
//		 Thread.sleep(2000);
//		  comd.saveaddcommoditydata(commoditygroupvalue);
//	        dashboard.clickOncommoditygroup();
//	        comd.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//	        Thread.sleep(3000);
//	        dashboard.clickoncommoditydetailstab();
//           Thread.sleep(2000);
//           comd.savedatainthirdtabForimporitingGroupDelta(commoditygroupvalue, groupclassificationvalue, specificgragevalue, randomNumber11, randomNumber12);
//	       driver.navigate().refresh();
//           comd.exportImportbutton(commoditygroupvalue, groupclassificationvalue);
//           comd.validateYearlyAndDeltaSheetCalculationsforSameYear(getLatestExportedExcelFileForCommoditytypedelta(),4,8);		 
//		 }

	@Test(priority = 40, groups = "group4",enabled=false)
	public void TC_YRLY_008UserRightsReadOnlyAccessRestriction() throws InterruptedException {
		Thread.sleep(8000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Clicked the Master Data successfully.");
		Thread.sleep(3000);
		dashboard.clickOnControlMaster();
		LoggerUtil.info("User entered the Control Master tab.");
		dashboard.clickOnusermaster();
		LoggerUtil.info("User entered the User Master tab.");
		comd.verifyreadonlyauthority();
	}

	@Test(priority = 41, groups = "group4")
	public void TC_CD_083SearchFieldDataPersistenceAfterNavigationWithoutReset() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);

		comd.verifySearchTableWithoutSearch();

	}

	@Test(priority = 42, groups = "group4")
	public void TC_CD_084PlaceholderTextValidationAllFieldsFindingAllHeadersNames() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);
		comd.verifyHeadersForCommodityDetailsTab();

	}

	@Test(priority = 43, groups = "group4")
	public void TC_CD_084PlaceholderTextValidationAllFields() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);
		comd.verifyPlaceholders();

	}

	@Test(priority = 43, groups = "group4")
	public void TC_CD_084PlaceholderTextValidationAllFieldsForRmPlaceHolders() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);
		comd.verifyPlaceHolderRm();

	}

	@Test(priority = 43, groups = "group4")
	public void TC_CD_084PlaceholderTextValidationAllFieldsForScrapPlaceHolders() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);
		comd.VerifyScrapValue();

	}

	@Test(priority = 44, groups = "group4")
	public void TC_CD_085CharacterLimitGradeFieldForSpecificGradeField() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		dashboard.clickOncommoditygroup();
		LoggerUtil.info("User click The commodity details tab");
		Thread.sleep(2000);

		comd.verifySpecificgradeVerification();

	}

	@Test(priority = 44, groups = "group4")
	public void TC_CD_086SpecialCharWhitespaceGradeField() throws InterruptedException {
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, "@#$%", densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, "@#$%");

	}

	@Test(priority = 45, groups = "group4")
	public void TC_CD_088NumericRangeDensityFieldForNegativeOil() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int negdensityvalue = faker.number().numberBetween(-1, -9999);
		String EnteringNegativeValues = String.valueOf(negdensityvalue);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				EnteringNegativeValues);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		comd.savedatainthirdtabForNegativeValues(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

	}

	@Test(priority = 46, groups = "group4")
	public void TC_CD_0881NumericRangeDensityFieldForPosstiveData() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int densityvalue = faker.number().numberBetween(10, 99);
		String EnteringDensityValue = String.valueOf(densityvalue);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				EnteringDensityValue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

	}

	@Test(priority = 47, groups = "group4")
	public void TC_CD_087NumericOnlyEnforcementDensityFieldForSpecialCharacter() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, "@#$");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

	}

	@Test(priority = 47, groups = "group4")
	public void TC_CD_087NumericOnlyEnforcementDensityFieldForText() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, "abc");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

	}

	@Test(priority = 48, groups = "group4")
	public void TC_CD_090DependentDropdownCommodityGroupClassificationGrade() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int densityvalue = faker.number().numberBetween(10, 99);
		String EnteringDensityValue = String.valueOf(densityvalue);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");

		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup("Plastics", groupclassificationvalue, specificgragevalue, "abc");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab("Plastics", groupclassificationvalue, specificgragevalue);

	}

	@Test(priority = 49, groups = "group4")
	public void TC_CD_091SearchFilterInDropdownGroupClassificationSupplier() throws InterruptedException {

		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		comd.verifySearchFilter("Ferrous", "Steel");

	}

	@Test(priority = 50, groups = "group4")
	public void TC_CD_093MultiSelectDropdownSupplierCustomer() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.MultiSelectCustomers();

	}

	@Test(priority = 51, groups = "group4")
	public void TC_CD_094TableHeaderNameAlignmentCount() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifyTableHeaderAndAlignment();

	}

	@Test(priority = 51, groups = "group4")
	public void TC_CD_094TableHeaderNameAlignmentCountForTableHeadings() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifyHeaderList();

	}

	@Test(priority = 52, groups = "group4")
	public void TC_CD_097PaginationRecordCountSNoAcrossPages() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("user clicking commoditymaster");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.VerifyNumeberOfRowInTable();

	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForCommodityGroup() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		comd.verifySearchFilterColumnValue("CommodityGroup", "Alloys", 3, "Alloys");
	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForClassification() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		comd.verifySearchFilterColumnValue("CastingGrade", "Stainless Steel", 4, "Stainless Steel");
	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForSpecificGrade() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		comd.verifySearchFilterColumnValue("SpecificGrade", "Steel-1", 5, "Steel-1");
	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForCommodityGroupForPartial()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		comd.verifySearchFilterColumnValue("CommodityGroup", "All", 3, "Alloys");
	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForClassificationForPartial()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		

		comd.verifySearchFilterColumnValue("CastingGrade", "Stainless", 4, "Stainless Steel");
	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForSpecificGradeForPartial()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");

		
		comd.verifySearchFilterColumnValue("SpecificGrade", "Steel-", 5, "Steel-1");
	}

	@Test(priority = 53, groups = "group4")
	public void TC_CD_098TableSearchPartialFullSpecialCharacterForCommodityGroupForSpecialCharacter()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);

		comd.verifySearchFilterColumnValue("CommodityGroup", "@#$%", 3, "  ");
	}

	@Test(priority = 54, groups = "group4")
	public void TC_CD_099FilterExportOnlyFilteredData() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifyFileExportFilterdData("Plastics22", "ST");

	}

	@Test(priority = 55, groups = "group4")
	public void TC_CD_100_01ExportFileSheetNameHeaderColumnOrderFormat() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifySheetNameHeaderNameAndColomName("Plastics22", "ST");

	}

	@Test(priority = 55, groups = "group4")
	public void TC_CD_100_02ExportFileSheetNameHeaderColumnOrderFormatForCommodityGroupDelta()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifySheetNameHeaderNameAndColomNameForGroupDelta("Plastics22", "ST");

	}

	@Test(priority = 55, groups = "group4")
	public void TC_CD_100_03ExportFileSheetNameHeaderColumnOrderFormatForCommodityDriectCost()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifySheetNameHeaderNameAndColomNameForDirectCost("Plastics22", "ST");

	}

	@Test(priority = 55, groups = "group4")
	public void TC_CD_100_04ExportFileSheetNameHeaderColumnOrderFormatForCommodityNewGradeAddition()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User clicking master data ");
		Thread.sleep(3000);

		dashboard.VerifyClickingMasterOptions("Commodity");
		LoggerUtil.info("User clicking commodity master");

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifySheetNameHeaderNameAndColomNameForNewGradeAddition();

	}

//	@Test(priority = 56, groups = "group4")
	public void TC_CD_101ExportedDataUnicodeSpecialCharNumericForPriceUpdateStringAndNumericValue()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);
		comd.VerifyAllDataAreInExcelFile();
		comd.verifyExcelMatchesUI(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);

	}

	@Test(priority = 56, groups = "group4")
	public void TC_CD_101_01ExportedDataUnicodeSpecialCharNumericForPriceUpdateOnlyDensityNumericValue()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);
		comd.VerifyAllDataAreInExcelFile();
		comd.verifyExcelMatchesUI(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

	}

	@Test(priority = 56, groups = "group4")
	public void TC_CD_101_02ExportedDataUnicodeSpecialCharNumericForPriceUpdateOnlyReadingGroupDeltaExcelFileAndComparingWithUi()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);
		int randnum = faker.number().numberBetween(10, 678);
		String rmscrap = String.valueOf(randnum);
		int randnum1 = faker.number().numberBetween(10, 678);
		String SecondScrap = String.valueOf(randnum);

		

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);

		dashboard.clickOncommoditygroup();

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);
		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", rmscrap, "Apr", "Scrap", SecondScrap);
		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", rmscrap,
				SecondScrap);

	}

	@Test(priority = 56, groups = "group4")
	public void TC_CD_101_03ExportedDataUnicodeSpecialCharNumericForPriceUpdateOnlyReadingExcelFileComparingWithUiGroupDirectCostUi()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);
		int randnum = faker.number().numberBetween(10, 678);
		String rmscrap = String.valueOf(randnum);
		int randnum1 = faker.number().numberBetween(10, 678);
		String SecondScrap = String.valueOf(randnum);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);

		dashboard.clickOncommoditygroup();

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);
		comd.verifyReadDirectCostForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", rmscrap, "Apr", "Scrap", SecondScrap);
		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDirectCost(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyDirectCostFromExcelFile();
		Thread.sleep(3000);
		comd.verifyDirectCostMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", rmscrap,
				SecondScrap);

	}

	@Test(priority = 57, groups = "group4")
	public void TC_CD_102_01ExportedFileEditCopyPasteSaveBackForPriceUpdate() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);
		comd.VerifyAllDataAreInExcelFile();
		comd.verifyExcelMatchesUI(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		Thread.sleep(3000);
		comd.verifyWriteEditExcelFileAndImportAgain();
		Thread.sleep(3000);
		comd.importNewPriceUopdateFile();

	}

	@Test(priority = 58, groups = "group1")
	public void TC_CD_102_02ExportedFileEditCopyPasteSaveBackForGroupDelta() throws Exception {

		String year = "2026-2027";
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		String baseRm = "200";
		String baseScrap = "150";

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);

		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", baseRm, "Apr", "Scrap", baseScrap);

		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", baseRm,
				baseScrap);
		Thread.sleep(3000);

		String fullPath = comd.WriteGroupDeltaExcelFileAndUpdate();

		comd.importNewGroupDeltaPriceUpdateFile(fullPath);

		Thread.sleep(2000);

		comd.verifyGroupDeltaDataUpdeOrnot(commoditygroupvalue);

		Map<String, String> excelData = comd.getLastEnteredGroupDeltaData();
		comd.verifyGroupDeltaUiVsExcel(excelData, "Aug", baseRm, baseScrap);

	}

	@Test(priority = 59, groups = "group4")
	public void TC_CD_102_03ExportedFileEditCopyPasteSaveBackGroupDirectCost() throws Exception {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		LoggerUtil.info("Scenario Start: TC_CD_102_03ExportedFileEditCopyPasteSaveBackGroupDirectCost");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");

		comd.verifyReadDirectCostForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", "200", "Apr", "Scrap", "150");

		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDirectCost(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);

		String fullPath = comd.WriteDirectCostExcelFileAndUpdate();

		comd.importNewDirectCostPriceUpdateFile(fullPath);

		comd.verifyDirectCostDataAfterImportUpteOrNot(commoditygroupvalue);

		Map<String, String> excelData = comd.getLastEnteredDirectCostData();
		comd.verifyDirectCostUiVsExcel(excelData, "Aug");
	}

	// @Test(priority = 59, groups="group4")
	public void TC_CD_102_04ExportedFileEditCopyPasteSaveBackGroupDirectCost() throws Exception {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		LoggerUtil.info("Scenario Start: TC_CD_102_04ExportedFileEditCopyPasteSaveBackGroupDirectCost");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");

		comd.verifyEnterDataCommodityDetails(commoditygroupvalue, groupclassificationvalue, specificgragevalue, "Apr",
				"RM", "200", "Apr", "Scrap", "150", "May", "RM", "140", "May", "Scrap", "240");

		Thread.sleep(3000);
		comd.verifReadExcelFileForNewGradeAddition();
		Thread.sleep(3000);

//              String fullPath = comd.WriteDirectCostExcelFileAndUpdate();   
//
//              
//              comd.importNewDirectCostPriceUpdateFile(fullPath);
//
//              
//              comd.verifyDirectCostDataAfterImportUpteOrNot(commoditygroupvalue);
//
//              
//              Map<String, String> excelData = comd.getLastEnteredDirectCostData();
//              comd.verifyDirectCostUiVsExcel(excelData, "Aug");
	}

	@Test(priority = 60, groups = "group4")
	public void TC_CD_103_01ImportInvalidFileTypeMissingChangedColumnsPriceUpdate() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifyInvalidFileIsImportOrNotForPriceUpdate("C:\\Users\\Admin\\Documents\\cUSTOMERdATA.txt");

	}

	@Test(priority = 60, groups = "group4")
	public void TC_CD_103_02ImportInvalidFileTypeMissingChangedColumnsGroupDelta() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifyInvalidFileIsImportOrNotForGroupDelta("C:\\Users\\Admin\\Documents\\cUSTOMERdATA.txt");

	}

	@Test(priority = 60, groups = "group4")
	public void TC_CD_103_03ImportInvalidFileTypeMissingChangedColumnsGroupDirectCost() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifyInvalidFileIsImportOrNotForGroupDirectCost("C:\\Users\\Admin\\Documents\\cUSTOMERdATA.txt");

	}

	@Test(priority = 60, groups = "group4")
	public void TC_CD_103_04ImportInvalidFileTypeMissingChangedColumnsNewGradeAddition() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifyInvalidFileIsImportOrNotForNewGradeAdditon("C:\\Users\\Admin\\Documents\\cUSTOMERdATA.txt");

	}

	@Test(priority = 61, groups = "group4")
	public void TC_CD_103ImportInvalidFileTypeMissingChangedColumnsForPriceUpdateOrWholeExcelFile()
			throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);

		comd.verifyWriteInvalidExcelFileAndValidateToast();
		Thread.sleep(2000);
		comd.importInValidExcelFile();

	}

	////////////////////////////// Invalid Scenario 104
	////////////////////////////// /////////////////////////////////////////

	// @Test(priority=62,groups="group4")
	public void TC_CD_104ImportExceedFieldLimits() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifDownLoadExcelFileForPriceUpdate();

	}

	@Test(priority = 63, groups = "group4")
	public void TC_CD_105ImportSpecialCharactersUnicode() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifDownLoadExcelFileForPriceUpdate();
		Thread.sleep(2000);
		comd.VerifyEnterDataSpecialCharactersAndReportToVerifyErrorInDensityAndBasePriceColom();
		Thread.sleep(2000);

		comd.importInValidCharaterAndFieldLimitFile();

	}

	@Test(priority = 64, groups = "group4")
	public void TC_CD_108ModalCancelCloseStateReset() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(2000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(2000);
		comd.verifyClickAllDropdownInExportImportPopup();

		comd.verifyCrossButtonExportImportPopup();

	}

	@Test(priority = 65, groups = "group4")
	public void TC_CD_109ResetButtonAllFieldsEditModeAfterSave() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		comd.verifyRestButtonFunctionality(commoditygroupvalue, groupclassificationvalue, specificgragevalue);

	}

	@Test(priority = 65, groups = "group4")
	public void TC_CD_109_01ResetButtonAllFieldsEditModeAfterSaveForBaseRmScrapPrice() throws InterruptedException {

		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");

		dashboard.clickOnCommodityTabByName("Commodity Details");

		comd.verifyBasePriceForResetFunctionality();

	}

	 @Test(priority=172,groups="group4")
	   public void TC_CD_120ExportDirectPriceHeaderPresenceOrderNaming() throws InterruptedException {
		   
		   dashboard.selectMenuFormDashBoard("Master Data");  
		   Thread.sleep(3000);
		   dashboard.VerifyClickingMasterOptions("Commodity");
		   
		   
		   Thread.sleep(3000);		   
		   dashboard.clickOnCommodityTabByName("Commodity Details");
		   
		   comd.ReadDirectpriceheaderName();
		   
		   
	   }
	   
	   @Test(priority=173,groups="group4")
	   public void TC_CD_121ExportDirectPriceDataExportAccuracy() throws InterruptedException {
		   
			String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		  
		   		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		   		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		   		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		   		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");
		   
		   		dashboard.selectMenuFormDashBoard("Master Data");
		   		dashboard.VerifyClickingMasterOptions("Commodity");
		   		dashboard.clickOnAddcommodity();
		  
		   		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		   		dashboard.clickOncommoditygroup();
		   		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
		   				densityvalue);
		   		dashboard.clickOnCommodityTabByName("Commodity Details");
		   		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		       
		        driver.navigate().refresh();
		        comd.WriteRmAndScrapValueInExcelFileAndCheckAccuracy(commoditygroupvalue, groupclassificationvalue);
		        Thread.sleep(2000);
		        comd.importNewProcessMasterWithCustomerFromExcel(commoditygroupvalue);
		        
	   }
	   
	   
	   @Test(priority=174, groups="group4")
	   public void TC_CD_127ExportDirectPriceFilteredDataOnly() throws InterruptedException {
	      
	       String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	       String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	       String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	       String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	       LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");
	      
	       dashboard.selectMenuFormDashBoard("Master Data");
	       dashboard.VerifyClickingMasterOptions("Commodity");
	       dashboard.clickOnAddcommodity();
	     
	       CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	       dashboard.clickOncommoditygroup();
	       CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
	       dashboard.clickOnCommodityTabByName("Commodity Details");
	       CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	      
	       driver.navigate().refresh();

	       // ✅ Get file path from Write method
	       String latestFilePath = comd.WriteRmAndScrapValueInExcelFileAndCheckAccuracyForFilterDataDirectPrice(commoditygroupvalue, groupclassificationvalue);

	       Thread.sleep(2000);

	       // ✅ Pass filePath & SheetName to verification method
	       comd.readfilterdDataAsItIsInExcelSheetOrNot(latestFilePath, "Commodity Yearly (DirectPrice)");
	   }

	@Test(priority=175,groups="group4")
	public void TC_CD_130ExportDirectPriceDownloadFileName() throws InterruptedException {
		
		
		 dashboard.selectMenuFormDashBoard("Master Data");
		 Thread.sleep(4000);
		 dashboard.VerifyClickingMasterOptions("Commodity");
	       dashboard.clickOnCommodityTabByName("Commodity Details");
			comd.DownLoadExcelFileForNamingConvention();
		
	}
	
	
	@Test(priority=176,groups="group4")
	public void TC_CD_133ImportDirectPriceExtraUnrecognizedColumns() throws InterruptedException {
		
		
		 dashboard.selectMenuFormDashBoard("Master Data");
		 Thread.sleep(4000);
		 dashboard.VerifyClickingMasterOptions("Commodity");
	       dashboard.clickOnCommodityTabByName("Commodity Details");
	       comd.DownloadExcelFileForInvalidColomName("Plastics22","ST");
	       comd.importInvalidColumDirectPrice();
		
		
		
	}
	@Test(priority=177,groups="group4")
	public void TC_CD_134ImportDirectPriceAllowedValueSetsDropdownMappings() throws InterruptedException {
		
		 String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	       String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	       String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	       String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	      
	       dashboard.selectMenuFormDashBoard("Master Data");
	       dashboard.VerifyClickingMasterOptions("Commodity");
	       dashboard.clickOnAddcommodity();
	     
	       CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	       dashboard.clickOncommoditygroup();
	       CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
	       dashboard.clickOnCommodityTabByName("Commodity Details");
	       CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	      
	       driver.navigate().refresh();

	       //  Get file path from Write method
	       comd.DownloadExcelFileForInvalidColomName(commoditygroupvalue,groupclassificationvalue);

	       Thread.sleep(2000);
	       

	       comd.importInvalidshapeDropdown();
	       
		
		
		
		
	}
	
	@Test(priority=178,groups="group4")
	public void TC_CD_135ImportDirectPriceNumericValidationRmScrap() throws InterruptedException {
		
		
		 String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	       String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	       String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	       String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	      
	       dashboard.selectMenuFormDashBoard("Master Data");
	       dashboard.VerifyClickingMasterOptions("Commodity");
	       dashboard.clickOnAddcommodity();
	     
	       CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	       dashboard.clickOncommoditygroup();
	       CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
	       dashboard.clickOnCommodityTabByName("Commodity Details");
	       CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	      
	       driver.navigate().refresh();

	       //  Get file path from Write method
	       comd.DownloadExcelFileForInvalidColomName(commoditygroupvalue,groupclassificationvalue);

	       Thread.sleep(2000);
	       

	       comd.importWithInvalidRmAndScrap();
	       
		
		
		
		
		
		
	}

	@Test(priority = 72, groups = "group4")
	public void TC_CD_136ImportPriceUpdateNegativeZeroValueHandling() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(2000);

		comd.importInvalidNegativeBasePriceValuesInUi("Invalid Base Price Values.");

	}
 
	
	@Test(priority = 73, groups = "group4")
	public void TC_CD_137ImportPriceUpdateDuplicateRowDetection() throws InterruptedException {

		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(4000);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(2000);
		comd.importDuplicateDataInExcelFileForImport("Improting Duplicate Values In Excel file");

	}

	@Test(priority=74,groups="group4")
	public void TC_CD_139ImportPriceUpdatePartialSaveWithMixedValidInvalid() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(1000);
		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(1000);
		comd.verifDownloadExcelFileAndVerifyToastMessage("plastics22", "ST","File exported successfully");
		
      		
		
	}
///////////////////////////////////////////////Delta Price Excel File////////////////////////////////////////////////////////	
	
	
	
	@Test(priority = 77, groups = "group4")
	public void TC_CD_143ExportDeltaWithUnicodeExportFile()
			throws InterruptedException {
		String commoditygroupvalue = fakerCN.name().fullName();
		
		String groupclassificationvalue = fakerCN.name().fullName();
		String specificgragevalue = fakerCN.name().fullName();
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);
		int randnum = faker.number().numberBetween(10, 678);
		String rmscrap = String.valueOf(randnum);
		int randnum1 = faker.number().numberBetween(10, 678);
		String SecondScrap = String.valueOf(randnum);

		

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);

		dashboard.clickOncommoditygroup();

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);
		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", rmscrap, "Apr", "Scrap", SecondScrap);
		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", rmscrap,
				SecondScrap);

	}

	@Test(priority = 77, groups = "group4")
	public void TC_CD_143DeltaExportForSpecialCharacter() throws InterruptedException {
		String commoditygroupvalue = "@#$%";

		String groupclassificationvalue = "#$%^&";
		String specificgragevalue = "$%^&";
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);
		int randnum = faker.number().numberBetween(10, 678);
		String rmscrap = String.valueOf(randnum);
		int randnum1 = faker.number().numberBetween(10, 678);
		String SecondScrap = String.valueOf(randnum);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);

		dashboard.clickOncommoditygroup();

		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);
		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", rmscrap, "Apr", "Scrap", SecondScrap);
		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", rmscrap,
				SecondScrap);

	}
	
	@Test(priority=78,groups="group4")
	public void TC_CD_145AndTC_CD_147ImportDeltaDataTypeNumericValidationWithMoreThanFourDigitAlsoCoverd() throws Exception {
		
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		String AprilValue = faker.number().digits(3);
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(6000);

		LoggerUtil.info("Step 4: Fill Commodity Group details");
		dashboard.clickOncommoditygroup();
		Thread.sleep(5000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		Thread.sleep(2000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
		
		
      QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		
		
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFile();
		Thread.sleep(3000);
		
		QuickMasterPage.importGroupDeltaFileAndCheckImpactOnUi();
		
		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		Thread.sleep(2000);
		QuickMasterPage.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromGroupDeltaExcelFile(fetchingRmAndScrapValues, FetchingRmAndScrapData);
		
		
		
		
		
		
		
		
		
	}
	
	
	@Test(priority=79,groups="group4")
	public void TC_CD_146ImportDeltaNegativeZeroExtremeValueValidation() throws Exception {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		String AprilValue = faker.number().digits(3);
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(6000);

		LoggerUtil.info("Step 4: Fill Commodity Group details");
		dashboard.clickOncommoditygroup();
		Thread.sleep(5000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		Thread.sleep(2000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
		
		
      QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		
		
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFileForNegativeNumbers();
		Thread.sleep(3000);
		
		QuickMasterPage.importGroupDeltaFileAndCheckImpactOnUi();
		
		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		Thread.sleep(2000);
		QuickMasterPage.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromGroupDeltaExcelFile(fetchingRmAndScrapValues, FetchingRmAndScrapData);
		
		

		
	}
	
	
	
	
	
	@Test(priority=80,groups="group4")
	public void TC_CD_147ImportDeltaAllowedValueSetsDropdowns() throws Exception {
		
		String year = "2026-2027";
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		String baseRm = "200";
		String baseScrap = "150";

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);

		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", baseRm, "Apr", "Scrap", baseScrap);

		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", baseRm,
				baseScrap);
		Thread.sleep(3000);

		String fullPath = comd.WriteInvalidSheetNameInGroupDeltaExcelFile();

		comd.importInvalidSheetNameInGroupDeltaExcelFile(fullPath);

		Thread.sleep(2000);

		comd.verifyGroupDeltaDataUpdeOrnot(commoditygroupvalue);

		Map<String, String> excelData = comd.getLastEnteredGroupDeltaData();
		comd.verifyGroupDeltaUiVsExcel(excelData, "Aug", baseRm, baseScrap);
		
		
	}
	
	////////Wrong Scenario ////////By Gurujot sir /////////
	//@Test(priority=81,groups="group4")
	public void TC_CD_148ImportDeltaDuplicateBlankRowHandling() throws Exception {

		String year = "2026-2027";
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		String baseRm = "200";
		String baseScrap = "150";

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);

		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", baseRm, "Apr", "Scrap", baseScrap);

		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", baseRm,
				baseScrap);
		Thread.sleep(3000);

		String fullPath = comd.WriteInvalidSheetNameInGroupDeltaExcelFile();

		comd.importInvalidSheetNameInGroupDeltaExcelFile(fullPath);

		Thread.sleep(2000);

		comd.verifyGroupDeltaDataUpdeOrnot(commoditygroupvalue);

		Map<String, String> excelData = comd.getLastEnteredGroupDeltaData();
		comd.verifyGroupDeltaUiVsExcel(excelData, "Aug", baseRm, baseScrap);
		
	}
	
	@Test(priority=82,groups="group4")
	public void TC_CD_149ImportDeltaInvalidMissingColumns() throws Exception {
		
		HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
		HashMap<String , String> fetchingRmAndScrapValues = new HashMap<String,String>();
		
		String AprilValue = faker.number().digits(3);
		String AprilScrapValue = faker.number().digits(3);
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue =faker.number().digits(4);
		
		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Click on Commodity Master");
		dashboard.VerifyClickingMasterOptions("Commodity");
		Thread.sleep(3000);

		LoggerUtil.info("Step 3: Click on Add Commodity");
		dashboard.clickOnAddcommodity();
		Thread.sleep(3000);
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(6000);

		LoggerUtil.info("Step 4: Fill Commodity Group details");
		dashboard.clickOncommoditygroup();
		Thread.sleep(5000);
		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
		Thread.sleep(3000);

		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
		dashboard.clickOnCommodityTabByName("Commodity Details");
		
		Thread.sleep(2000);
		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
		Thread.sleep(3000);
		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
		
		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue, "Commodity details saved successfully.");
		
		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
		
		
      QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		
		
		
		 HashMap<String,String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFileForInValidMissingColumn();
		Thread.sleep(3000);
		
		QuickMasterPage.importGroupDeltaFileAndCheckImpactOnUi();
		
		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
		Thread.sleep(2000);
		QuickMasterPage.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromGroupDeltaExcelFile(fetchingRmAndScrapValues, FetchingRmAndScrapData);
	}

	
	


	
	@Test(priority=84,groups="group4")
	public void TC_CD_151ImportDeltaSucessErrorPrompt() throws Exception {
		
		String commoditygroupvalue = faker.name().firstName() +faker.letterify("?????");
		
		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);
		String denvalueSecond = String.valueOf(randomnumber);

		String baseRm = "200";
		String baseScrap = "150";

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();
		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		Thread.sleep(5000);
		
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
		Thread.sleep(8000);
		
		dashboard.clickOnCommodityTabByName("Commodity Details");

		Thread.sleep(5000);

		comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
				specificgragevalue, "Apr", "RM", baseRm, "Apr", "Scrap", baseScrap);

		Thread.sleep(3000);
		comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
		Thread.sleep(3000);
		comd.VerifyGroupDeltaDataFromExcel();
		Thread.sleep(3000);
		comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", baseRm,
				baseScrap);
		Thread.sleep(3000);
		String fullPath = comd.VerifyGroupDeltaExcelFileImportToast();
		comd.VerifyImportSucessFullPrompToast(fullPath);
		comd.verifyGroupDeltaDataUpdeOrnot(commoditygroupvalue);
		Map<String, String> excelData = comd.getLastEnteredGroupDeltaData();
		comd.verifyGroupDeltaUiVsExcel(excelData, "Aug", baseRm, baseScrap);
	
	}
	
	    @Test(priority=85,groups="group4")
	    public void TC_CD_151ImportDeltaSuccessErrorPrompt() throws Exception {
	    	
	    	String year = "2026-2027";
			String commoditygroupvalue = faker.name().firstName() +faker.letterify("?????");
			
			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			
			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			
			int randomnumber = faker.number().numberBetween(100, 999999999);
			String denvalue = String.valueOf(randomnumber);
			String denvalueSecond = String.valueOf(randomnumber);

			String baseRm = "200";
			String baseScrap = "150";

			dashboard.selectMenuFormDashBoard("Master Data");
			dashboard.VerifyClickingMasterOptions("Commodity");
			dashboard.clickOnAddcommodity();
			CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
			Thread.sleep(5000);
			
			dashboard.clickOncommoditygroup();
			CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
			Thread.sleep(8000);
			
			dashboard.clickOnCommodityTabByName("Commodity Details");

			Thread.sleep(5000);

			comd.verifyReadDeltaValueForSpecialCharacterandText(commoditygroupvalue, groupclassificationvalue,
					specificgragevalue, "Apr", "RM", baseRm, "Apr", "Scrap", baseScrap);

			Thread.sleep(3000);
			comd.verifReadExcelFileForGroupDelta(commoditygroupvalue, groupclassificationvalue);
			Thread.sleep(3000);
			comd.VerifyGroupDeltaDataFromExcel();
			Thread.sleep(3000);
			comd.verifyGroupDeltaMatchesUI(commoditygroupvalue, groupclassificationvalue, "2025-2026", "Apr", baseRm,
					baseScrap);
			Thread.sleep(3000);
			String fullPath = comd.VerifyGroupDeltaExcelFileWithInvalidDataForUnsucessFullFile();
			comd.VerifyImportUnSucessFullPrompToast(fullPath);
			comd.verifyGroupDeltaDataUpdeOrnot(commoditygroupvalue);
			Map<String, String> excelData = comd.getLastEnteredGroupDeltaData();
			comd.verifyGroupDeltaUiVsExcel(excelData, "Aug", baseRm, baseScrap);
	
	    }
	
	    /////////////////////Price Update Excel File //////////////////////////////
	    
	    @Test(priority=86,groups="group4")
	    public void TC_CD_154ExportPriceUpdateMandatoryFieldsNonBlank() throws InterruptedException, IOException {

	    	HashMap<String,String> FetchComDetailsNameAndSpecificGrade = new HashMap<String ,String >();	
	    	HashMap<String,String> FetchingBaseRmAndScrapPrices = new HashMap<String ,String >();
	    	String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

	    		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	    		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	    		String densityvalue =faker.number().digits(4);
	    		
	    		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
	    		dashboard.selectMenuFormDashBoard("Master Data");
	    		Thread.sleep(3000);

	    		LoggerUtil.info("Step 2: Click on Commodity Master");
	    		dashboard.VerifyClickingMasterOptions("Commodity");
	    		Thread.sleep(3000);

	    		LoggerUtil.info("Step 3: Click on Add Commodity");
	    		dashboard.clickOnAddcommodity();
	    		Thread.sleep(3000);
	    		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	    		Thread.sleep(3000);

	    		LoggerUtil.info("Step 4: Fill Commodity Group details");
	    		dashboard.clickOncommoditygroup();
	    		Thread.sleep(3000);
	    		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
	    		Thread.sleep(3000);

	    		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
	    		dashboard.clickOnCommodityTabByName("Commodity Details");
	    		Thread.sleep(2000);
	    		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	    		Thread.sleep(3000);
	    		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
	    		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
	    		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui",specificgragevalue);
	    		
	    		// Random values generate karo
	    		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
	    		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
	    		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
	    		String random4 = String.valueOf(faker.number().numberBetween(100, 999));

	    		QuickMasterPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(    
	    		    random1, random2,   
	    		    random3, random4,   
	    		    random1, random2,   
	    		    random3, random4,   
	    		    random1, random2,   
	    		    random3, random4,   
	    		    random1, random2,   
	    		    random3, random4,   
	    		    random1, random2,  
	    		    random3, random4,   
	    		    random1, random2,   
	    		    random3, random4,"Commodity details saved successfully."    
	    		);
	    		
	    		FetchingBaseRmAndScrapPrices.put("April Rm", random1);
	    		FetchingBaseRmAndScrapPrices.put("April Scrap", random2);
	    		FetchingBaseRmAndScrapPrices.put("May Rm", random3);
	    		FetchingBaseRmAndScrapPrices.put("May Scrap", random4);
	    		FetchingBaseRmAndScrapPrices.put("June Rm", random1);
	    		FetchingBaseRmAndScrapPrices.put("June Scrap", random2);
	    		FetchingBaseRmAndScrapPrices.put("July Rm", random3);
	    		FetchingBaseRmAndScrapPrices.put("July Scrap", random4);
	    		FetchingBaseRmAndScrapPrices.put("August Rm", random1);
	    		FetchingBaseRmAndScrapPrices.put("August Scrap", random2);
	    		FetchingBaseRmAndScrapPrices.put("September Rm", random3);
	    		FetchingBaseRmAndScrapPrices.put("September Scrap", random4);
	    		FetchingBaseRmAndScrapPrices.put("October Rm", random1);
	    		FetchingBaseRmAndScrapPrices.put("October Scrap", random2);
	    		FetchingBaseRmAndScrapPrices.put("November Rm", random3);
	    		FetchingBaseRmAndScrapPrices.put("November Scrap ", random4);
	    		FetchingBaseRmAndScrapPrices.put("December Rm", random1);
	    		FetchingBaseRmAndScrapPrices.put("December Scrap", random2);
	    		FetchingBaseRmAndScrapPrices.put("Jan Rm", random3);
	    		FetchingBaseRmAndScrapPrices.put("Jan Scrap", random4);
	    		FetchingBaseRmAndScrapPrices.put("Feb Rm", random1);
	    		FetchingBaseRmAndScrapPrices.put("Feb Scrap", random2);
	    		FetchingBaseRmAndScrapPrices.put("March Rm", random3);
	    		FetchingBaseRmAndScrapPrices.put("March Scrap", random4);
	    		
	    		
	    	   QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
	    	   
	    	   QuickMasterPage.VerifyExcelAndUiDataHasBeenEqualOrNotForPriceUpdate(FetchComDetailsNameAndSpecificGrade,FetchingBaseRmAndScrapPrices);


	    }
	    
	    
	    @Test(priority=87,groups="group4")
	    public void TC_CD_155ExportPriceUpdateNumericTypeFormatRMScrap() throws InterruptedException {
	    	
	    	
	    	
	    	
	    	 String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
		        String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		        String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		        String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

		      String stringvalue = faker.name().firstName()+faker.letterify("??????????");
		        dashboard.selectMenuFormDashBoard("Master Data");
		        dashboard.VerifyClickingMasterOptions("Commodity");
		        dashboard.clickOnAddcommodity();

		        CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		        dashboard.clickOncommoditygroup();
		        Thread.sleep(4000);
		        CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
		                densityvalue);
		        dashboard.clickOnCommodityTabByName("Commodity Details");
		        Thread.sleep(3000);
		        comd.savedatainthirdtabForEnteringStringValueAndCharatersInBasePrice(commoditygroupvalue, groupclassificationvalue, specificgragevalue,stringvalue,stringvalue,stringvalue,stringvalue);
		        Thread.sleep(3000);
	    	
		        comd.verifyExcelMatchesUIWithInvalidRm(4, commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue,
		        		stringvalue, stringvalue, stringvalue, stringvalue);
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    
	    

	    @Test(priority=87,groups="group4")
	    public void TC_CD_159ExportPriceUpdateNumericTypeFormatRMScrap() throws InterruptedException {
	        String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	        String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	        String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	        String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	      
	        dashboard.selectMenuFormDashBoard("Master Data");
	        dashboard.VerifyClickingMasterOptions("Commodity");
	        dashboard.clickOnAddcommodity();

	        CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	        dashboard.clickOncommoditygroup();
	        CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
	                densityvalue);
	        dashboard.clickOnCommodityTabByName("Commodity Details");
	        CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	        Thread.sleep(3000);
	        comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);

	        
	        comd.importWithInvalidBasePriceValueWithExcelSheet("Invalid Data Type Base Price.");
	    }

    @Test(priority=88,groups="group4")
    public void TC_CD_158ImportPriceUpdateValueSetEnforcement() throws InterruptedException {
    	
    	String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
        String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
        String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
        String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

      
        dashboard.selectMenuFormDashBoard("Master Data");
        dashboard.VerifyClickingMasterOptions("Commodity");
        dashboard.clickOnAddcommodity();

        CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
        dashboard.clickOncommoditygroup();
        CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
                densityvalue);
        dashboard.clickOnCommodityTabByName("Commodity Details");
        CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
        Thread.sleep(3000);
        comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);

        
        comd.importWithInvalidValueAndDropDowns("Invalid Values");	
    	
    	
    	
    	
    	
    }
	    
	    @Test(priority=88,groups="group4")
	    public void TC_CD_160ImportPriceUpdateNegativeZeroHandling() throws InterruptedException {
	    	
	    	String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	        String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	        String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	        String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	      
	        dashboard.selectMenuFormDashBoard("Master Data");
	        dashboard.VerifyClickingMasterOptions("Commodity");
	        dashboard.clickOnAddcommodity();

	        CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	        dashboard.clickOncommoditygroup();
	        CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
	                densityvalue);
	        dashboard.clickOnCommodityTabByName("Commodity Details");
	        CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	        Thread.sleep(3000);
	        comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);

	        
	        comd.importNegativeValuesInBaseRm("Invalid Values");	
	    	
	    	
	    	
	    	
	    	
	    }
	   @Test(priority=89,groups="group4")
	   public void TC_CD_162ImportPriceUpdateExtraUnrecognizedColumns() throws InterruptedException {
		   
			String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
	        String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	        String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
	        String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);

	      
	        dashboard.selectMenuFormDashBoard("Master Data");
	        dashboard.VerifyClickingMasterOptions("Commodity");
	        dashboard.clickOnAddcommodity();

	        CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
	        dashboard.clickOncommoditygroup();
	        CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
	                densityvalue);
	        dashboard.clickOnCommodityTabByName("Commodity Details");
	        CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
	        Thread.sleep(3000);
	        comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);

	        
	        comd.importInvalidColomName("Invalid Values");	  
		   
		   
		   
		   
		   
	   }
	   
	   
	  @Test(priority=166,groups="group4")
	  public void TC_CD_166ImportPriceUpdateEditInExcelAndImportBackPriceUpdate() throws InterruptedException {
		  
		  
		  String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			int randomnumber = faker.number().numberBetween(100, 999999999);
			String denvalue = String.valueOf(randomnumber);

			

			dashboard.selectMenuFormDashBoard("Master Data");
			dashboard.VerifyClickingMasterOptions("Commodity");
			dashboard.clickOnAddcommodity();

			CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
			dashboard.clickOncommoditygroup();
			CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
			dashboard.clickOnCommodityTabByName("Commodity Details");
			CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
			Thread.sleep(3000);
			comd.verifReadExcelFile(commoditygroupvalue, groupclassificationvalue);
			comd.VerifyAllDataAreInExcelFile();
			comd.verifyExcelMatchesUI(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);
			Thread.sleep(3000);
			comd.verifyWriteEditExcelFileAndImportAgain();
			Thread.sleep(3000);
			comd.importNewPriceUopdateFile();
		  
  
	  }
	   
	   //////////////////////////////New Grade Addition ///////////////////////////////////////////
	   
	   
	   @Test(priority=167,groups="group4")
	   public void TC_CD_171ImportNewGradeAdditionMandatoryFieldEnforcement() throws InterruptedException {
		   
		   
			  String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

				String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
				String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
				String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
				int randomnumber = faker.number().numberBetween(100, 999999999);
				String denvalue = String.valueOf(randomnumber);

				

				dashboard.selectMenuFormDashBoard("Master Data");
				dashboard.VerifyClickingMasterOptions("Commodity");
				dashboard.clickOnAddcommodity();

				CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
				dashboard.clickOncommoditygroup();
				CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

				dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			comd.verifyDownLoadNewGradeAdditionRemoveCommodityGroupAndYear();
            Thread.sleep(3000);
            comd.importInvalidNewGradeAdditionFile("Something went wrong.",commoditygroupvalue,groupclassificationvalue,specificgragevalue);
   
	   }
	   
	   @Test(priority=168,groups="group4")
	   public void TC_CD_172ImportNewGradeAdditionDropdownValueEnforcement() throws InterruptedException {
		   
		   

			  String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

				String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
				String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
				String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
				int randomnumber = faker.number().numberBetween(100, 999999999);
				String denvalue = String.valueOf(randomnumber);

				

				dashboard.selectMenuFormDashBoard("Master Data");
				dashboard.VerifyClickingMasterOptions("Commodity");
				dashboard.clickOnAddcommodity();

				CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
				dashboard.clickOncommoditygroup();
				CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, denvalue);

				dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			comd.verifyDownLoadNewGradeAdditionRemoveCommodityGroupAndYear();
         Thread.sleep(3000);
         comd.importInvalidNewGradeAdditionFile("Something went wrong.",commoditygroupvalue,groupclassificationvalue,specificgragevalue,denvalue);	   
 
	   }

		@Test(priority = 169, groups = "group4")
		public void TC_CD_173ImportNewGradeAdditionNumericTypeBoundaryValidation() throws InterruptedException {

			String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			int randomnumber = faker.number().numberBetween(100, 999999999);
			String denvalue = String.valueOf(randomnumber);

			dashboard.selectMenuFormDashBoard("Master Data");
			dashboard.VerifyClickingMasterOptions("Commodity");
			dashboard.clickOnAddcommodity();

			CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
			dashboard.clickOncommoditygroup();
			CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
					denvalue);

			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			comd.verifyDownLoadNewGradeAdditionRemoveCommodityGroupAndYear();
			Thread.sleep(3000);
			comd.importInvalidNewGradeAdditionFileForInvalidDataTypeRmAndScrap("Something went wrong.", commoditygroupvalue,
					groupclassificationvalue, specificgragevalue, denvalue);

		}

	   @Test(priority=170,groups="group4")
	   public void TC_CD_175ImportNewGradeAdditionDuplicateGradeCheck() throws InterruptedException {
		   
		   String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
			int randomnumber = faker.number().numberBetween(100, 999999999);
			String denvalue = String.valueOf(randomnumber);

			dashboard.selectMenuFormDashBoard("Master Data");
			dashboard.VerifyClickingMasterOptions("Commodity");
			dashboard.clickOnAddcommodity();

			CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
			dashboard.clickOncommoditygroup();
			CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
					denvalue);

			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			comd.verifyDownLoadNewGradeAdditionRemoveCommodityGroupAndYear();
			Thread.sleep(3000);
			comd.importDuplicateData("Something went wrong.", commoditygroupvalue,
					groupclassificationvalue, specificgragevalue, denvalue);
		   
		   
	   }
	   
	   
	   
	@Test(priority=171,groups="group4")
	public void TC_CD_179ImportNewGradeAdditionSuccessErrorPrompts() throws InterruptedException {
		
		
		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");

		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
		int randomnumber = faker.number().numberBetween(100, 999999999);
		String denvalue = String.valueOf(randomnumber);

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Commodity");
		dashboard.clickOnAddcommodity();

		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		dashboard.clickOncommoditygroup();
		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				denvalue);

		dashboard.clickOnCommodityTabByName("Commodity Details");
		Thread.sleep(3000);
		comd.verifyDownLoadNewGradeAdditionRemoveCommodityGroupAndYear();
		Thread.sleep(3000);
		comd.importValidData("Something went wrong.", commoditygroupvalue,
				groupclassificationvalue, specificgragevalue, denvalue);

		
		
		
		
		
		
		
		
	}
	   
	   
	   
	   
	   
	
	
}
