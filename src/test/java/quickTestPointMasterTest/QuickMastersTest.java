package quickTestPointMasterTest;

import java.awt.AWTException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.BopEntryImportedPage;
import com.Pages.BopEntryStandardPage;
import com.Pages.CommodityDetailsPage;
import com.Pages.CommoditygroupPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.SupplierMasterPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;

@Listeners(com.helper.TestListeners.class)
public class QuickMastersTest extends Base {

	
	
	 
	
	static Faker faker = new Faker();

	DashboardPage dashboard;
	CommoditygroupPage commodity;
	QuickMasterPage quick;
	Actions action;
	SupplierMasterPage supplier = new SupplierMasterPage();

	@BeforeGroups(groups = { "group1", "group2", "group3", "group4" })
	public void VerifyLogingButton() {

		launchApplication();

		LoginPage login = new LoginPage();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = new DashboardPage();
		 action = new Actions(driver);
		commodity = new CommoditygroupPage();
		quick = new QuickMasterPage();

	}

	@AfterGroups(groups = { "group1", "group2", "group3", "group4" })
	public void QuitBrowser() {

		driver.quit();

	}

//	@Test(priority = 1, groups = "group1")
//	public void TC_COM_001SaveANewCommodityGroup() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//
//		Thread.sleep(2000);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
//				"Commodity Group Saved Successfully");
//
//	}
//
//	@Test(priority = 2, groups = "group1")
//	public void TC_COM_002EditAndUpdateExistingCommodityGroup() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//		String updatedSpecificGrade = faker.name().firstName() + faker.letterify("????????");
//		Thread.sleep(2000);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		quick.editandupdateexistingentry(commodityGroup, groupClassification, specificGrade, density, commodityGroup,
//				updatedSpecificGrade);
//		Thread.sleep(2999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		quick.validateFilteredRow(commodityGroup, commodityGroup, groupClassification, updatedSpecificGrade, density);
//
//	}
//
//	@Test(priority = 3, groups = "group1")
//	public void TC_COM_003SaveAsNewForCommodityGroup() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//		String SaveAsNewSpecificGrade = faker.name().firstName() + faker.letterify("????????");
//		Thread.sleep(2000);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		quick.SaveAsNewCommodityGroup(commodityGroup, groupClassification, specificGrade, density, commodityGroup,
//				SaveAsNewSpecificGrade);
//		Thread.sleep(2999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		quick.validateFilteredRow(SaveAsNewSpecificGrade, commodityGroup, groupClassification, SaveAsNewSpecificGrade,
//				density);
//
//	}
//
//	@Test(priority = 4, groups = "group1")
//	public void TC_COM_014ExportFormatAndFilterValidation() throws InterruptedException, IOException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		faker.name().firstName();
//		faker.letterify("????");
//		faker.name().firstName();
//		faker.letterify("????");
//		faker.number().digits(5);
//		faker.name().firstName();
//		faker.letterify("????????");
//		Thread.sleep(2000);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		quick.verifyCommodityGroupFileStructure();
//
//	}
//
//	@Test(priority = 5, groups = "group1")
//	public void TC_COM_019PostImportViewTableValidation() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//		faker.name().firstName();
//		faker.letterify("????????");
//		Thread.sleep(2000);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		QuickMasterPage.verifyDownLoadExcelFile();
//		Thread.sleep(2000);
//		QuickMasterPage.ImportExcelFileCommodityGroup(commodityGroup, groupClassification, specificGrade, density,
//				"Commodity group file successfully imported");
//
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		QuickMasterPage.verifyMatchingDataAllAreImportedCorrectly(commodityGroup);
//
//	}
//
/////////////////////////////////////////////////////////////////Commodity Details ///////////////////////////////////////////////////////////////////////////	
//	@Test(priority = 6, groups = "group1")
//	public void TC_CD_003DropdownCommodityGroupClassificationSpecificGrade() throws InterruptedException {
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(2000);
//		QuickMasterPage.VerifySearchFilterForCommodityDetailsTab();
//
//	}
//
//	@Test(priority = 7, groups = "group1")
//	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutUOM() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//
//		Thread.sleep(2000);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
//				"Commodity Group Saved Successfully");
//		Thread.sleep(3000);
//
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		QuickMasterPage.SaveComDetailsWithoutSelectingUOMDropDown(commodityGroup, groupClassification, specificGrade);
//
//	}
//
//	@Test(priority = 7, groups = "group1")
//	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutShape() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//
//		Thread.sleep(2000);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
//				"Commodity Group Saved Successfully");
//		Thread.sleep(3000);
//
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		QuickMasterPage.SaveComDetailsWithoutSelectingShapeDropdown(commodityGroup, groupClassification, specificGrade);
//
//	}
//
//	@Test(priority = 7, groups = "group1")
//	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutCommodityGroup()
//			throws InterruptedException {
//
//		Thread.sleep(2000);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		CommodityDetailsPage.WithoutSelectingComGroup();
//
//	}
//
//	@Test(priority = 8, groups = "group1")
//	public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutYear() throws InterruptedException {
//
//		String commodityGroup = faker.name().firstName() + faker.letterify("????????");
//		String groupClassification = faker.name().firstName() + faker.letterify("????");
//		String specificGrade = faker.name().firstName() + faker.letterify("????");
//		String density = faker.number().digits(5);
//
//		dashboard.clickingDashboard("Dashboard");
//		Thread.sleep(2000);
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
//		Thread.sleep(3999);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(2000);
//		QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
//				"Commodity Group Saved Successfully");
//		Thread.sleep(3000);
//
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		QuickMasterPage.SaveComDetailsWithoutSelectingYearDropDown(commodityGroup, groupClassification, specificGrade);
//
//	}
//
//	////////////////////////////////////////// Threee Decimal Rm And Scrap
//	////////////////////////////////////////// ////////////////////////////////////////////////////////////
//
//	@Test(priority = 9, groups = "group1")
//	public HashMap<String, String> TC_CD_009SaveRmScrapPricesWith3DecimalPrecision() throws Throwable {
//
//		LoggerUtil.info("===== Starting TC_CD_009SaveRmScrapPricesWith3DecimalPrecision =====");
//
//		HashMap<String, String> CommodityDetailsInfo = new HashMap<>();
//
//		try {
//			// Generate random test data
//			String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//			String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//			String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//			String densityvalue = String.valueOf(faker.number().randomDouble(3, 1, 100));
//			String Year = "2025-2026";
//			// Navigate
//			dashboard.clickingDashboard("Dashboard");
//			dashboard.selectMenuFormDashBoard("Master Data");
//			LoggerUtil.info("User clicked Master Data successfully");
//
//			Thread.sleep(2000);
//			dashboard.VerifyClickingMasterOptions("Commodity");
//			LoggerUtil.info("User entered Commodity Master");
//
//			Thread.sleep(3000);
//			dashboard.clickOnAddcommodity();
//
//			// Step 1️⃣ - Save data in Add Commodity tab
//			CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
//			LoggerUtil.pass("Saved Commodity Group value: " + commoditygroupvalue);
//			Thread.sleep(4000);
//
//			// Step 2️⃣ - Save data in Commodity Group tab
//			dashboard.clickOncommoditygroup();
//			CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//					specificgragevalue, densityvalue);
//			LoggerUtil.pass("Saved Group Classification, Specific Grade, and Density successfully.");
//			Thread.sleep(2000);
//
//			// Step 3️⃣ - Save data in Commodity Details tab
//			dashboard.clickOnCommodityTabByName("Commodity Details");
//			CommodityDetailsPage.savedataforthreedecimal(commoditygroupvalue, groupclassificationvalue,
//					specificgragevalue, Year);
//			Thread.sleep(3000);
//
//			// Generate RM and Scrap random values (3-decimal precision)
//			String random1 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//			String random2 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//			String random3 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//
//			// Step 4️⃣ - Enter RM and Scrap values
//			CommodityDetailsPage.enetrRmAndScrapValues(random1, random2, random3, random1, random2, random3, random1,
//					random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
//					random1, random2, random3, random1, random2, random3, commoditygroupvalue);
//
//			LoggerUtil.pass("✅ Entered RM and Scrap values with 3-decimal precision successfully.");
//
//			// Step 5️⃣ - Store all key data in HashMap
//			CommodityDetailsInfo.put("CommodityGroup", commoditygroupvalue);
//			CommodityDetailsInfo.put("GroupClassification", groupclassificationvalue);
//			CommodityDetailsInfo.put("SpecificGrade", specificgragevalue);
//			CommodityDetailsInfo.put("Density", densityvalue);
//			CommodityDetailsInfo.put("Year-Data", Year);
//			CommodityDetailsInfo.put("RandomValue1", random1);
//			CommodityDetailsInfo.put("RandomValue2", random2);
//			CommodityDetailsInfo.put("RandomValue3", random3);
//
//			LoggerUtil.info("✅ Stored all generated and saved data into HashMap.");
//
//		} catch (Exception e) {
//			LoggerUtil.error("❌ Exception in TC_CD_009SaveRmScrapPricesWith3DecimalPrecision → " + e.getMessage());
//			throw e;
//		}
//
//		LoggerUtil.info("===== Completed TC_CD_009SaveRmScrapPricesWith3DecimalPrecision =====");
//		return CommodityDetailsInfo;
//	}
//
//	//////////////////////////////////////// Negative Values
//	//////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////
//	@Test(priority = 10, groups = "group1")
//	public void TC_CD_010SaveNegativeValuesForRmAndScrap() throws InterruptedException {
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User clicked the Master Data successfully");
//
//		Thread.sleep(2000);
//
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		LoggerUtil.info("User entered the Commodity Master");
//		Thread.sleep(3000);
//		dashboard.clickOnAddcommodity();
//		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
//		Thread.sleep(4000);
//		dashboard.clickOncommoditygroup();
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(2000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		// driver.navigate().refresh();
//		CommodityDetailsPage.savedataforthreedecimal(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				"2025-2026");
//		Thread.sleep(3000);
//		String random1 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
//		String random2 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
//		String random3 = String.valueOf(-faker.number().randomDouble(3, 1, 100));
//
//		CommodityDetailsPage.enetrRmAndScrapValues(random1, random2, random3, random1, random2, random3, random1,
//				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
//				random1, random2, random3, random1, random2, random3, commoditygroupvalue);
//
//	}
//
/////////////////////////////////////////Calculation Q1-Q4 And H1-H2////////////////////////////////////////////////////////////////	
//
//	@Test(priority = 11, groups = "group1")
//	public void TC_CD_011QuarterlyAndHalfYearlyCalculationsForRmAndScrap() throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User clicked the Master Data successfully");
//		Thread.sleep(2000);
//
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		LoggerUtil.info("User entered the Commodity Master");
//		Thread.sleep(3000);
//
//		dashboard.clickOnAddcommodity();
//		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(4000);
//
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//
//		// Generate reusable randoms
//		String random1 = String.valueOf(faker.number().numberBetween(1000, 9999));
//		String random2 = String.valueOf(faker.number().numberBetween(1000, 9999));
//		String random3 = String.valueOf(faker.number().numberBetween(1000, 9999));
//
//		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalue(random1, random2, random3, random1,
//				random2, random3, random1, random2, random3, random1, random2, random3, random1, random2, random3,
//				random1, random2, random3, random1, random2, random3, random1, random2, random3, commoditygroupvalue);
//
//		// Quarterly RM
//		try {
//			CommodityDetailsPage.verifyQuarterlyRmAverageQ1();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q1 RM failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyQuarterlyRmAverageQ2();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q2 RM failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyQuarterlyRmAverageQ3();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q3 RM failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyQuarterlyRmAverageQ4();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q4 RM failed: " + e.getMessage());
//		}
//
//		// Quarterly Scrap
//		try {
//			CommodityDetailsPage.verifyQuarterlyScrapAverageQ1();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q1 Scrap failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyQuarterlyScrapAverageQ2();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q2 Scrap failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyQuarterlyScrapAverageQ3();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q3 Scrap failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyQuarterlyScrapAverageQ4();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ Q4 Scrap failed: " + e.getMessage());
//		}
//
//		// Half-Yearly RM
//		try {
//			CommodityDetailsPage.verifyHalfYearlyRmAverageH1();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ H1 RM failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyHalfYearlyRmAverageH2();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ H2 RM failed: " + e.getMessage());
//		}
//
//		// Half-Yearly Scrap
//		try {
//			CommodityDetailsPage.verifyHalfYearlyScrapAverageH1();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ H1 Scrap failed: " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifyHalfYearlyScrapAverageH2();
//		} catch (Exception e) {
//			LoggerUtil.mismatch("❌ H2 Scrap failed: " + e.getMessage());
//		}
//
//	}
//
//	/////////////////////////////////////// Delta Calculation For Supplier Specific
//	/////////////////////////////////////// Location//////////////////////////////////////////////
//
//	@Test(priority = 12, groups = "group1")
//	public void TC_CD_013SpecificDeltaSupplierAllocation() throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		dashboard.clickOnAddcommodity();
//		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
//		Thread.sleep(5000);
//
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(4000);
//
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//
//		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
//				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
//				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);
//
//		String randomsupp1 = String.valueOf(faker.number().numberBetween(1000, 9999));
//		String randomsupp2 = String.valueOf(faker.number().numberBetween(1000, 9999));
//		String randomsupp3 = String.valueOf(faker.number().numberBetween(1000, 9999));
//		String randomsupp4 = String.valueOf(faker.number().numberBetween(1000, 9999));
//
//		CommodityDetailsPage.verifyingcalculationofsupplierallocation(randomsupp1, randomsupp2, randomsupp3,
//				randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp2, randomsupp3,
//				randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp2, randomsupp3,
//				randomsupp4, randomsupp1, randomsupp2, randomsupp3, randomsupp4, commoditygroupvalue);
//
//		Thread.sleep(16000);
//
//		// Handling assertion failures for all steps
//		try {
//			CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: April Landed Cost (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparingLandedCostForMay();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: May Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: June Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparinglandedcostforjuly();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: July Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostforaugust();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: August Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForseptember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: September Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForoctober();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: October Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForNovember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: November Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForDecember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: December Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForJan();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: January Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForFebruary();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: February Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForMarch();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: March Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 Scrap Average (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ4ScrapAverage();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 Scrap Average (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Second Half Year RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Second Half Year Scrap (Supplier) - " + e.getMessage());
//		}
//
//	}
//
/////////////////////////////////////Supplier Delta Price Validation For Upto fOUR Decimal Precison//////////////////// 	
//	@Test(priority = 13, groups = "group1")
//	public void TC_CD_012DeltaPricesValidationWith3To4DecimalPrecision() throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		dashboard.clickOnAddcommodity();
//		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
//		Thread.sleep(5000);
//
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(4000);
//
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//
//		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
//				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
//				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);
//
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//
//		String suprandom1 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
//		String suprandom2 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
//		String suprandom3 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
//		String suprandom4 = String.valueOf(faker.number().randomDouble(4, 100, 234567));
//
//		QuickMasterPage.verifyingcalculationofsupplierallocation(suprandom1, suprandom2, suprandom4, suprandom3,
//				suprandom3, suprandom1, suprandom2, suprandom1, suprandom1, suprandom1, suprandom2, suprandom1,
//				suprandom4, suprandom3, suprandom1, suprandom3, suprandom1, suprandom1, suprandom3, suprandom2,
//				suprandom2, suprandom1, suprandom1, suprandom1, commoditygroupvalue);
//
//		Thread.sleep(16000);
//
//		// Handling assertion failures for all steps
//		try {
//			CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: April Landed Cost (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparingLandedCostForMay();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: May Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: June Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparinglandedcostforjuly();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: July Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostforaugust();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: August Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForseptember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: September Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForoctober();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: October Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForNovember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: November Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForDecember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: December Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForJan();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: January Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForFebruary();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: February Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForMarch();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: March Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 Scrap Average (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ4ScrapAverage();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 Scrap Average (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Second Half Year RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Second Half Year Scrap (Supplier) - " + e.getMessage());
//		}
//
//	}
//
//////////////////////////////////////Customer Allocation Delta Unto FourDecimal ////////////////////////////////////////////////////////////////////////////////////////////////
//
//	@Test(priority = 14, groups = "group1")
//	public void TC_CD_014NegativeDeltaValueImpactInQuarterlyAndHalfYearlyCustomerAllocationForNegative()
//			throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		faker.name().firstName();
//
//		// calculating customer Allocation For Possitive Number And Negative Number Both
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		dashboard.clickOnAddcommodity();
//		Thread.sleep(2000);
//		CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(4000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//
//		// Generate random data
//		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(random1, random2,
//				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
//				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);
//
//		String randomsupp1 = String.valueOf(-faker.number().numberBetween(100, 999));
//		String randomsupp2 = String.valueOf(-faker.number().numberBetween(100, 999));
//		String randomsupp3 = String.valueOf(-faker.number().numberBetween(100, 999));
//		String randomsupp4 = String.valueOf(-faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.verifyingcalculationofcustomerallocation(randomsupp1, randomsupp4, randomsupp3,
//				randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp2, randomsupp2, randomsupp4,
//				randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp4, randomsupp3,
//				randomsupp4, randomsupp4, randomsupp2, randomsupp1, randomsupp1, commoditygroupvalue);
//
//		// Call each method inside try-catch
//		try {
//			CommodityDetailsPage.verifyCalculateLandedCostForCustomerAprilMonth();
//		} catch (AssertionError e) {
//			LoggerUtil.fail("❌ Failed: April Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatemayrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: May RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatejunermandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: June RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatejulyrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: July RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateaugustrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: August RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateseptemberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: September RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateoctoberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: October RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatenovemberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: November RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatedecemberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: December RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatejanrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: January RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefebrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: February RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatemarchrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: March RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifyCalculatingCustomerAllocationSecondQ2ForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingQ2ScrapValueForCustomerAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 Scrap - " + e.getMessage());
//		}
//
//		// Q3: October, November, December
//		try {
//			CommodityDetailsPage.calculatingQ3calculationRmforCustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingQ3scrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 Scrap - " + e.getMessage());
//		}
//
//		// Q4: January, February, March
//		try {
//			CommodityDetailsPage.calculatingQ4rmvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingQ4scrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifycalculatefirstsixmonthaveragevalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year RM (Customer) - " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.calculatehy1scrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("Failed: First Half Year Scrap (Customer) - " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifycalculatesecondhalfyearcustomer();
//		} catch (AssertionError e) {
//			System.err.println("Failed: Second Half Year RM (Customer) - " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.calculatehalfyearscrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌Failed: Second Half Year Scrap (Customer) - " + e.getMessage());
//		}
//
//	}
//
//////////////////////////////////Supplier Allocation For Negative Values///////////////////////////////////////////////////////////////////		
//
//	@Test(priority = 15, groups = "group1")
//	public void TC_CD_014NegativeDeltaValueImpactInQuarterlyAndHalfYearly() throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		dashboard.clickOnAddcommodity();
//		CommodityDetailsPage.savedatainaddcommoditytab(commoditygroupvalue);
//		Thread.sleep(5000);
//
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(4000);
//
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//
//		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
//				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
//				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);
//
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//		String.valueOf(faker.number().numberBetween(1000, 9999));
//
//		String suprandom1 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
//		String suprandom2 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
//		String suprandom3 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
//		String suprandom4 = String.valueOf(-faker.number().randomDouble(4, 100, 234567));
//
//		QuickMasterPage.verifyingcalculationofsupplierallocation(suprandom1, suprandom2, suprandom4, suprandom3,
//				suprandom3, suprandom1, suprandom2, suprandom1, suprandom1, suprandom1, suprandom2, suprandom1,
//				suprandom4, suprandom3, suprandom1, suprandom3, suprandom1, suprandom1, suprandom3, suprandom2,
//				suprandom2, suprandom1, suprandom1, suprandom1, commoditygroupvalue);
//
//		Thread.sleep(16000);
//
//		// Handling assertion failures for all steps
//		try {
//			CommodityDetailsPage.verifycalculatelandedcostForSupplierAprilmonth();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: April Landed Cost (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparingLandedCostForMay();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: May Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifyComparingLandedCostForJuneMonth();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: June Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparinglandedcostforjuly();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: July Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostforaugust();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: August Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForseptember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: September Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForoctober();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: October Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForNovember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: November Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForDecember();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: December Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForJan();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: January Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForFebruary();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: February Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.comparelandedcostForMarch();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: March Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstquaterinsupplierallocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQuarterScrapSupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateSecondquaterinsupplierallocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateSecondQ2ScrapForSupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ3RmAverageWithValidEntries();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ3ScrapAverageWithValidEntries();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 Scrap Average (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingrmandscrapforFourthquarterQ4ForsupplierAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateQ4ScrapAverage();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 Scrap Average (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateFirstHalfYearOnRmAndScrapForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateFirstHalfYearOnScrapForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year Scrap (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifySecondHalfYearlyAverageForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Second Half Year RM (Supplier) - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifySecondHalfYearlyAverageForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Second Half Year Scrap (Supplier) - " + e.getMessage());
//		}
//
//	}
//
//////////////////////////////////////////////////Customer Allocation For Negative Values/////////////////////////////////////////////////////////////////////// 		
//
//	@Test(priority = 16, groups = "group1")
//	public void TC_CD_013SpecificDeltaCustomerAllocation() throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		faker.name().firstName();
//
//		// calculating customer Allocation For Possitive Number And Negative Number Both
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(2000);
//		dashboard.clickOnAddcommodity();
//		Thread.sleep(2000);
//		CommodityDetailsPage.saveadcommoidtyforupdatedata(commoditygroupvalue);
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		CommodityDetailsPage.savedatasecondttabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(4000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//
//		// Generate random data
//		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforcustomerAllocation(random1, random2,
//				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
//				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4);
//
//		String randomsupp1 = String.valueOf(-faker.number().numberBetween(100, 999));
//		String randomsupp2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String randomsupp3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String randomsupp4 = String.valueOf(-faker.number().numberBetween(100, 999));
//
//		CommodityDetailsPage.verifyingcalculationofcustomerallocation(randomsupp1, randomsupp4, randomsupp3,
//				randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp2, randomsupp2, randomsupp4,
//				randomsupp1, randomsupp1, randomsupp2, randomsupp3, randomsupp4, randomsupp1, randomsupp4, randomsupp3,
//				randomsupp4, randomsupp4, randomsupp2, randomsupp1, randomsupp1, commoditygroupvalue);
//
//		// Call each method inside try-catch
//		try {
//			CommodityDetailsPage.verifyCalculateLandedCostForCustomerAprilMonth();
//		} catch (AssertionError e) {
//			LoggerUtil.fail("❌ Failed: April Landed Cost - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatemayrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: May RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatejunermandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: June RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatejulyrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: July RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateaugustrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: August RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateseptemberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: September RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculateoctoberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: October RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatenovemberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: November RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatedecemberrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: December RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatejanrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: January RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefebrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: February RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatemarchrmandscrapforcustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: March RM/Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatefirstQ1forcustomerallocationForScrap();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q1 Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifyCalculatingCustomerAllocationSecondQ2ForRm();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingQ2ScrapValueForCustomerAllocation();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q2 Scrap - " + e.getMessage());
//		}
//
//		// Q3: October, November, December
//		try {
//			CommodityDetailsPage.calculatingQ3calculationRmforCustomer();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingQ3scrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q3 Scrap - " + e.getMessage());
//		}
//
//		// Q4: January, February, March
//		try {
//			CommodityDetailsPage.calculatingQ4rmvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 RM - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.calculatingQ4scrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: Q4 Scrap - " + e.getMessage());
//		}
//
//		try {
//			CommodityDetailsPage.verifycalculatefirstsixmonthaveragevalue();
//		} catch (AssertionError e) {
//			System.err.println("❌ Failed: First Half Year RM (Customer) - " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.calculatehy1scrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("Failed: First Half Year Scrap (Customer) - " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.verifycalculatesecondhalfyearcustomer();
//		} catch (AssertionError e) {
//			System.err.println("Failed: Second Half Year RM (Customer) - " + e.getMessage());
//		}
//		try {
//			CommodityDetailsPage.calculatehalfyearscrapvalue();
//		} catch (AssertionError e) {
//			System.err.println("❌Failed: Second Half Year Scrap (Customer) - " + e.getMessage());
//		}
//
//	}
//
//	//////////////// SaveUpdateAndSaveAsNew(CommodityDetails)/////////////////////////////////
//
//	@Test(priority = 17, groups = "group1")
//	public void TC_CD_015SaveCommodityDetails() throws InterruptedException {
//		HashMap<String, String> Comdetailsname = new HashMap<String, String>();
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		LoggerUtil.info("Scenario Start: TC_COM_001_SaveANewCommodityGroup - Save a new Commodity Group.");
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		dashboard.clickOnAddcommodity();
//
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		Thread.sleep(5000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//		Comdetailsname.put("commoditygroupvalue", commoditygroupvalue);
//		Comdetailsname.put("GroupClassification", groupclassificationvalue);
//		Comdetailsname.put("SpecificGrade", specificgragevalue);
//
//		QuickMasterPage.verifyFetchinganmeComdetailsTab(Comdetailsname, commoditygroupvalue);
//
//	}
//
//	@Test(priority = 18, groups = "group1")
//	public void TC_CD_015UpdtaedCommodityDetails() throws InterruptedException {
//		HashMap<String, String> Comdetailsname = new HashMap<String, String>();
//		HashMap<String, String> UpdatedComdetailsname = new HashMap<String, String>();
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String updatedClassification = faker.name().firstName() + "" + faker.letterify("???????");
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		LoggerUtil.info("===== Scenario Start: TC_CD_015UpdtaedCommodityDetails =====");
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		dashboard.clickOnAddcommodity();
//
//		// Step 1: Save Commodity Group first time
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		LoggerUtil.pass("Step 1: Commodity Group saved successfully with value → " + commoditygroupvalue);
//
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//
//		// Step 2: Save classification first time
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		LoggerUtil.pass("Step 2: First Group Classification saved → " + groupclassificationvalue);
//
//		Thread.sleep(5000);
//
//		// Step 3: Save classification second time (reserve for update)
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, updatedClassification, specificgragevalue,
//				densityvalue);
//		LoggerUtil.pass("Step 3: Second Group Classification (reserved for update) saved → " + updatedClassification);
//
//		Thread.sleep(5000);
//
//		// Step 4: Save details in 3rd tab
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//		LoggerUtil.pass("Step 4: Commodity Details saved in 3rd tab with Group: " + commoditygroupvalue
//				+ ", Classification: " + groupclassificationvalue + ", Specific Grade: " + specificgragevalue);
//
//		// Prepare expected values before update
//		Comdetailsname.put("commoditygroupvalue", commoditygroupvalue);
//		Comdetailsname.put("GroupClassification", groupclassificationvalue);
//		Comdetailsname.put("SpecificGrade", specificgragevalue);
//
//		// Step 5: Verify update with reserved classification
//		QuickMasterPage.VerifyUpdatedCommodityHasBeenSucessFullyUpdatedOrNot(Comdetailsname, commoditygroupvalue,
//				updatedClassification, specificgragevalue, "Commodity details saved successfully.");
//
//		// Prepare expected values after update
//		UpdatedComdetailsname.put("Commodity Group", commoditygroupvalue);
//		UpdatedComdetailsname.put("Group classification", updatedClassification);
//		UpdatedComdetailsname.put("Specific Grade", specificgragevalue);
//
//		// Step 6: Verify fetched updated data
//		QuickMasterPage.VerifyFetchingUpdatedData(UpdatedComdetailsname, updatedClassification);
//
//		LoggerUtil.info("===== Scenario End: TC_CD_015UpdtaedCommodityDetails =====");
//	}
//
//	@Test(priority = 19, groups = "group1")
//	public void TC_CD_015SaveAsNew() throws InterruptedException {
//		HashMap<String, String> Comdetailsname = new HashMap<String, String>();
//		HashMap<String, String> SaveAsNewComdetailsname = new HashMap<String, String>();
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String SaveAsNewClassification = faker.name().firstName() + "" + faker.letterify("???????");
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		LoggerUtil.info("===== Scenario Start: TC_CD_015SaveAsNew =====");
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		dashboard.clickOnAddcommodity();
//
//		// Step 1: Save Commodity Group first time
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		LoggerUtil.pass("Step 1: Commodity Group saved successfully with value → " + commoditygroupvalue);
//
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//
//		// Step 2: Save classification first time
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue, densityvalue);
//		LoggerUtil.pass("Step 2: First Group Classification saved → " + groupclassificationvalue);
//
//		Thread.sleep(5000);
//
//		// Step 3: Save classification second time (Save As New reserved entry)
//		CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, SaveAsNewClassification,
//				specificgragevalue, densityvalue);
//		LoggerUtil.pass("Step 3: Save As New Classification saved → " + SaveAsNewClassification);
//
//		Thread.sleep(5000);
//
//		// Step 4: Save details in 3rd tab
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		CommodityDetailsPage.savedatainthirdtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//		LoggerUtil.pass("Step 4: Commodity Details saved in 3rd tab with Group: " + commoditygroupvalue
//				+ ", Classification: " + groupclassificationvalue + ", Specific Grade: " + specificgragevalue);
//
//		// Prepare expected values before Save As New
//		Comdetailsname.put("commoditygroupvalue", commoditygroupvalue);
//		Comdetailsname.put("GroupClassification", groupclassificationvalue);
//		Comdetailsname.put("SpecificGrade", specificgragevalue);
//
//		// Step 5: Verify Save As New entry creation
//		QuickMasterPage.VerifySaveAsNewDataHasBeenSucessFullyCreatedNewEntryOrNot(Comdetailsname, commoditygroupvalue,
//				SaveAsNewClassification, specificgragevalue, "Commodity details saved successfully.");
//
//		// Prepare expected values for Save As New verification
//		SaveAsNewComdetailsname.put("Commodity Group", commoditygroupvalue);
//		SaveAsNewComdetailsname.put("Group classification", SaveAsNewClassification);
//		SaveAsNewComdetailsname.put("Specific Grade", specificgragevalue);
//
//		// Step 6: Verify fetched Save As New data
//		QuickMasterPage.VerifyFetchingSaveAsNewData(SaveAsNewComdetailsname, SaveAsNewClassification);
//
//		Thread.sleep(4000);
//		QuickMasterPage.verifyOldDataAsItIsOrNot(Comdetailsname, commoditygroupvalue, SaveAsNewClassification,
//				specificgragevalue);
//
//		LoggerUtil.info("===== Scenario End: TC_CD_015SaveAsNew =====");   
//	}
//
//	@Test(priority = 20, groups = "group1")
//	public void TC_CD_023SupplierSavePromptValidation() throws InterruptedException {
//
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//
//		dashboard.clickingDashboard("Dashboard");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(2000);
//		CommodityDetailsPage.verifySavenewsupplierpromptnotification(commoditygroupvalue, groupclassificationvalue,
//				"Supplier saved sucessfully.");
//
//	}
//
//	@Test(priority = 21, groups = "group1")
//	public void TC_CD_023CustomerSavePromptValidation() throws InterruptedException {
//
//		String CustomerName = faker.name().firstName() + faker.letterify("??????");
//		String Customercode = faker.number().digits(5);
//
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(2000);
//		QuickMasterPage.VerifyAddCustomerToast(CustomerName, Customercode, "Customer Saved successfully.");
//
//	}
//
//	@Test(priority = 22, groups = "group1")
//	public void TC_CD_024ExportPriceUpdate() throws InterruptedException, IOException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> FetchingBaseRmAndScrapPrices = new HashMap<String, String>();
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 3: Click on Add Commodity");
//		dashboard.clickOnAddcommodity();
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(2000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//
//		// Random values generate karo
//		String random1 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random2 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random3 = String.valueOf(faker.number().numberBetween(100, 999));
//		String random4 = String.valueOf(faker.number().numberBetween(100, 999));
//
//		QuickMasterPage.enterRmandScrapvalueForcalculatingRmAndScrapvalueforsupplierAllocation(random1, random2,
//				random3, random4, random1, random2, random3, random4, random1, random2, random3, random4, random1,
//				random2, random3, random4, random1, random2, random3, random4, random1, random2, random3, random4,
//				"Commodity details saved successfully.");
//
//		FetchingBaseRmAndScrapPrices.put("April Rm", random1);
//		FetchingBaseRmAndScrapPrices.put("April Scrap", random2);
//		FetchingBaseRmAndScrapPrices.put("May Rm", random3);
//		FetchingBaseRmAndScrapPrices.put("May Scrap", random4);
//		FetchingBaseRmAndScrapPrices.put("June Rm", random1);
//		FetchingBaseRmAndScrapPrices.put("June Scrap", random2);
//		FetchingBaseRmAndScrapPrices.put("July Rm", random3);
//		FetchingBaseRmAndScrapPrices.put("July Scrap", random4);
//		FetchingBaseRmAndScrapPrices.put("August Rm", random1);
//		FetchingBaseRmAndScrapPrices.put("August Scrap", random2);
//		FetchingBaseRmAndScrapPrices.put("September Rm", random3);
//		FetchingBaseRmAndScrapPrices.put("September Scrap", random4);
//		FetchingBaseRmAndScrapPrices.put("October Rm", random1);
//		FetchingBaseRmAndScrapPrices.put("October Scrap", random2);
//		FetchingBaseRmAndScrapPrices.put("November Rm", random3);
//		FetchingBaseRmAndScrapPrices.put("November Scrap ", random4);
//		FetchingBaseRmAndScrapPrices.put("December Rm", random1);
//		FetchingBaseRmAndScrapPrices.put("December Scrap", random2);
//		FetchingBaseRmAndScrapPrices.put("Jan Rm", random3);
//		FetchingBaseRmAndScrapPrices.put("Jan Scrap", random4);
//		FetchingBaseRmAndScrapPrices.put("Feb Rm", random1);
//		FetchingBaseRmAndScrapPrices.put("Feb Scrap", random2);
//		FetchingBaseRmAndScrapPrices.put("March Rm", random3);
//		FetchingBaseRmAndScrapPrices.put("March Scrap", random4);
//
//		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNot(FetchComDetailsNameAndSpecificGrade,
//				commoditygroupvalue);
//
//		QuickMasterPage.VerifyExcelAndUiDataHasBeenEqualOrNotForPriceUpdate(FetchComDetailsNameAndSpecificGrade,
//				FetchingBaseRmAndScrapPrices);
//
//	}
//
//	@Test(priority = 23, groups = "group1")
//	public void TC_CD_025ExportGroupDelta() throws InterruptedException, FileNotFoundException, IOException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> fetchingRmAndScrapValues = new HashMap<String, String>();
//		double AprilRmDouble = faker.number().randomDouble(3, 100, 999);
//		String AprilValue = String.valueOf(AprilRmDouble);
//		double AprilScrapDouble = faker.number().randomDouble(3, 100, 999);
//		String AprilScrapValue = String.valueOf(AprilScrapDouble);
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 3: Click on Add Commodity");
//		dashboard.clickOnCommodityTabByName("Add Commodity");
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOnCommodityTabByName("Commodity Group");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		Thread.sleep(2000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//
//		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue,
//				"Commodity details saved successfully.");
//
//		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
//		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
//
//		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade,
//				commoditygroupvalue);
//
//		QuickMasterPage.ReadingValueInSecondSheetAndVerifyAllUiValueDownLoadAccuratelyoRNotInGroupDeltaExcelFile(
//				fetchingRmAndScrapValues);
//
//		HashMap<String, String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFile();
//		Thread.sleep(3000);
//
//		QuickMasterPage.VerifyReflectionOnSecondSheet(FetchingRmAndScrapData, fetchingRmAndScrapValues);
//
//	}
//
//	@Test(priority = 24, groups = "group1")
//	public void TC_CD_026ExportGroupDirectCost() throws InterruptedException, FileNotFoundException, IOException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> fetchingRmAndScrapValues = new HashMap<String, String>();
//
//		String AprilValue = faker.number().digits(3);
//
//		String AprilScrapValue = faker.number().digits(3);
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 3: Click on Add Commodity");
//		dashboard.clickOnCommodityTabByName("Add Commodity");
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOnCommodityTabByName("Commodity Group");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//
//		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue,
//				"Commodity details saved successfully.");
//
//		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
//		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
//
//		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyInUiOrNotForDirectPrice(FetchComDetailsNameAndSpecificGrade,
//				commoditygroupvalue);
//
//		Thread.sleep(2000);
//		QuickMasterPage.ReadingValueInSecondSheetAndVerifyAllUiValueDownLoadAccuratelyoRNotInDirectPriceExcelFile(
//				fetchingRmAndScrapValues);
//		Thread.sleep(3000);
//		HashMap<String, String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDirectPriceExcelFile();
//		Thread.sleep(3000);
//
//		QuickMasterPage.VerifyReflectionOnSecondSheetForDirectprice(FetchingRmAndScrapData);
//	}
//
//////////////////////////////Doubt 27th Scenario for New Grade Addition ////////////////////////////////////////	
//
////	@Test(priority=61,groups="group1")
//	public void TC_CD_027ExportNewGradeAddition() throws InterruptedException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> fetchingRmAndScrapValues = new HashMap<String, String>();
//
//		String AprilValue = faker.number().digits(3);
//
//		String AprilScrapValue = faker.number().digits(3);
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 3: Click on Add Commodity");
//		dashboard.clickOnCommodityTabByName("Add Commodity");
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOnCommodityTabByName("Commodity Group");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//
//		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue,
//				"Commodity details saved successfully.");
//
//		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
//		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
//
//	}
//
//	@Test(priority = 25, groups = "group1")
//	public void TC_CD_028ImportGroupDeltaExcelFileAndValidateAllDataHasBeenLoadedCorrectlyOrNot()
//			throws InterruptedException, FileNotFoundException, IOException, AWTException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> fetchingRmAndScrapValues = new HashMap<String, String>();
//
//		String AprilValue = faker.number().digits(3);
//		String AprilScrapValue = faker.number().digits(3);
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 3: Click on Add Commodity");
//		dashboard.clickOnCommodityTabByName("Add Commodity");
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(6000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOnCommodityTabByName("Commodity Group");
//		Thread.sleep(5000);
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		Thread.sleep(2000);
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//
//		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue,
//				"Commodity details saved successfully.");
//
//		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
//		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
//
//		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyOrNotForGroupDelta(FetchComDetailsNameAndSpecificGrade,
//				commoditygroupvalue);
//
//		HashMap<String, String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDeltaFile();
//		Thread.sleep(3000);
//
//		QuickMasterPage.importGroupDeltaFileAndCheckImpactOnUi();
//
//		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
//		Thread.sleep(2000);
//		QuickMasterPage.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromGroupDeltaExcelFile(
//				fetchingRmAndScrapValues, FetchingRmAndScrapData);
//
//	}
//
//	@Test(priority = 26, groups = "group1")
//	public void TC_CD_028ImportDirectPriceExcelFileAndValidateAllDataHasBeenLoadedCorrectlyOrNot()
//			throws InterruptedException, FileNotFoundException, IOException, AWTException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> fetchingRmAndScrapValues = new HashMap<String, String>();
//
//		String AprilValue = faker.number().digits(3);
//
//		String AprilScrapValue = faker.number().digits(3);
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 3: Click on Add Commodity");
//		dashboard.clickOnCommodityTabByName("Add Commodity");
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOnCommodityTabByName("Commodity Group");
//		Thread.sleep(3000);
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//
//		QuickMasterPage.EnteringRmAndScrapInUiAndSaveData(AprilValue, AprilScrapValue,
//				"Commodity details saved successfully.");
//
//		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
//		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
//		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyInUiOrNotForDirectPrice(FetchComDetailsNameAndSpecificGrade,
//				commoditygroupvalue);
//
//		Thread.sleep(2000);
//		QuickMasterPage.ReadingValueInSecondSheetAndVerifyAllUiValueDownLoadAccuratelyoRNotInDirectPriceExcelFile(
//				fetchingRmAndScrapValues);
//		Thread.sleep(3000);
//		HashMap<String, String> FetchingRmAndScrapData = QuickMasterPage.fillCommodityGroupDirectPriceExcelFile();
//		Thread.sleep(3000);
//
//		QuickMasterPage.VerifyReflectionOnSecondSheetForDirectprice(FetchingRmAndScrapData);
//
//		QuickMasterPage.importDirectPriceExcelFileAndCheckImpactOnUi();
//
//		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
//		Thread.sleep(2000);
//
//		QuickMasterPage
//				.verifyRmPriceAndScrapPriceAreCorrectlyUploadedOrNotFromDirectPriceExcelFile(FetchingRmAndScrapData);
//	}
//
//	@Test(priority = 27, groups = "group1")
//	public void TC_CD_028ImportNewGradeAdditionExcelFileAndValidateAllDataHasBeenLoadedCorrectlyOrNot()
//			throws InterruptedException, FileNotFoundException, IOException, AWTException {
//
//		HashMap<String, String> FetchComDetailsNameAndSpecificGrade = new HashMap<String, String>();
//		HashMap<String, String> fetchingRmAndScrapValues = new HashMap<String, String>();
//
//		String AprilValue = faker.number().digits(3);
//
//		String AprilScrapValue = faker.number().digits(3);
//		String commoditygroupvalue = faker.name().firstName() + faker.letterify("?????");
//
//		String groupclassificationvalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String specificgragevalue = faker.name().firstName() + " " + faker.number().numberBetween(10, 99);
//		String densityvalue = faker.number().digits(4);
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Add Commodity");
//
//		Thread.sleep(3000);
//		CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 4: Fill Commodity Group details");
//		dashboard.clickOnCommodityTabByName("Commodity Group");
//
//		CommodityDetailsPage.savedatainsecondtab(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 5: Fill Q1-Q4 base data in Commodity Details tab");
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		CommodityDetailsPage.savedatathirdtabforcalculatingq1q2q3q4(commoditygroupvalue, groupclassificationvalue,
//				specificgragevalue);
//		Thread.sleep(3000);
//		FetchComDetailsNameAndSpecificGrade.put("Commodity GroupValue-Ui", commoditygroupvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Group Classification-Ui", groupclassificationvalue);
//		FetchComDetailsNameAndSpecificGrade.put("Specific Grade-Ui", specificgragevalue);
//		FetchComDetailsNameAndSpecificGrade.put("Density-From-Ui", densityvalue);
//		QuickMasterPage.SaveNewGradeAddition("Commodity details saved successfully.");
//
//		fetchingRmAndScrapValues.put("April-Rm", AprilValue);
//		fetchingRmAndScrapValues.put("April-Scrap", AprilScrapValue);
//
//		QuickMasterPage.VerifyAllDataHasBeenSavedAccuratelyInUiOrNotForNewGradeAddition(
//				FetchComDetailsNameAndSpecificGrade, commoditygroupvalue, "Mk-2208-5-Mohali");
//
//		fetchingRmAndScrapValues.put("CustomerName", "Mk-2208-5-Mohali");
//
//		QuickMasterPage.VerifyReadExcelDataForCustomerNameAsItIsFromUiOrNot(fetchingRmAndScrapValues);
//
//		HashMap<String, String> FetchingRmAndScrapData = QuickMasterPage
//				.FillingNewGradeAdditionForExcelFile(FetchComDetailsNameAndSpecificGrade);
//
//		QuickMasterPage.importNewGradeAdditionExcelFileAndCheckImpactOnUi();
//
//		QuickMasterPage.VerifyExcelDataValueSavedInUiOrNot(FetchComDetailsNameAndSpecificGrade, commoditygroupvalue);
//		Thread.sleep(5000);
//
//		QuickMasterPage.VerifyValidateAllDataFromNewGradeExcelFileHasBeenImportedCorrectlyOrNot(FetchingRmAndScrapData,
//				FetchComDetailsNameAndSpecificGrade);
//
//	}
//
//	@Test(priority = 28, groups = "group1")
//	public void TC_CD_033ViewDomesticToggle() throws InterruptedException {
//		dashboard.clickingDashboard("Dashboard");
//
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		clickOnElement(QuickMasterPage.ClickingDomesticRadionBtn);
//
//		Thread.sleep(2000);
//		QuickMasterPage.verifyRadioButtonsIsDependOnYearlyDomesticAndImported("Type", "Domestic");
//
//	}
//
//	@Test(priority = 29, groups = "group1")
//	public void TC_CD_033ViewImportedToggle() throws InterruptedException {
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		clickOnElement(QuickMasterPage.ClickingImportedRadioBtn);
//
//		Thread.sleep(2000);
//		QuickMasterPage.verifyRadioButtonsIsDependOnYearlyDomesticAndImported("Type", "Imported");
//
//	}
//
//	@Test(priority = 30, groups = "group1")
//	public void TC_CD_033YealryToggle() throws InterruptedException {
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		clickOnElement(QuickMasterPage.clickingYearlyRadioBtn);
//
//		Thread.sleep(2000);
//		QuickMasterPage.verifyYearColumnForYearlyToggle("Year");
//
//	}
//
//	@Test(priority = 31, groups = "group1")
//	public void TC_CD_098ViewSearchResultMatchesTotalCount() throws InterruptedException {
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		clickOnElement(QuickMasterPage.clickingYearlyRadioBtn);
//
//		quick.VerifySearchInputForCommodityDetailsTab("Plastics");
//
//	}
//
//	@Test(priority = 32, groups = "group1")
//	public void TC_CD_098ViewSearchResultHalfMatchesTotalCount() throws InterruptedException {
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		clickOnElement(QuickMasterPage.clickingYearlyRadioBtn);
//
//		quick.VerifySearchInputForCommodityDetailsTab("Pla");
//
//	}
//
//	@Test(priority = 33, groups = "group1")
//	public void TC_CD_098ViewSearchResultHalfValuesWithSpecialCharacter() throws InterruptedException {
//
//		dashboard.clickingDashboard("Dashboard");
//		LoggerUtil.info("Step 1: Navigate to Master Data tab from dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//
//		LoggerUtil.info("Step 2: Click on Commodity Master");
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		Thread.sleep(4000);
//		clickOnElement(QuickMasterPage.clickingYearlyRadioBtn);
//
//		quick.VerifySearchInputForCommodityDetailsTab("Pla@#$%^");
//
//	}
//
///////////////////////////////////////Bop Entry Standard//////////////////////////////////////////////	
//
//	@Test(priority = 34, groups = "group1")
//	public void TC_BOP_010VerifySuccessfulBopSaveForStandard() throws InterruptedException {
//
//		int randomint = faker.number().numberBetween(1000, 9999);
//		double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
//		String randomName = faker.name().firstName() + faker.letterify("??");
//		String partnumber = randomName + "-" + String.valueOf(randomint);
//		String partDescription = randomName;
//		String BopTypeName = faker.name().firstName() + faker.letterify("????");
//		String partcostvalue = String.valueOf(valueoftwodigit);
//		String dutiesvalue = String.valueOf(valueoftwodigit);
//		String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("BOP");
//		Thread.sleep(3000);
//
//		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
//		Thread.sleep(3000);
//		dashboard.clickingBopEntryTab();
//		Thread.sleep(2000);
//		BopEntryStandardPage.SaveBopWithStandard(BopTypeName, partDescription, partnumber, partcostvalue, dutiesvalue,
//				frieghtinsurancevalue, BopTypeName);
//
//	}
//
///////////////////////////////////////////////Bop Entry Imported///////////////////////////////////////////////////////////	
//
//	@Test(priority = 35, groups = "group1")
//	public void TC_BOP_010VerifySuccessfulBopSaveForImported() throws InterruptedException {
//
//		String Bopname = faker.name().firstName() + faker.letterify("???");
//		String PartDescription = faker.name().firstName() + faker.letterify("??????");
//
//		int EnterTextWithEx = faker.number().numberBetween(10, 99);
//		String.valueOf(EnterTextWithEx);
//		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
//		String.valueOf(EnterValueWithMisc);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("BOP");
//		Thread.sleep(1000);
//		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
//		Thread.sleep(3000);
//		dashboard.clickingBopEntryTab();
//		Thread.sleep(3000);
//		BopEntryImportedPage.verifyBopImportWithMandatoryValues(Bopname, PartDescription, PartDescription);
//
//	}
////////////////////////////////////////////////Bop Entry Inhouse/////////////////////////////////////////////////////////
//	
//
//	@Test(priority = 36, groups = "group1")
//	public void TC_BOP_010VerifySuccessfulBopSaveForInhouse() throws InterruptedException {
//		new HashMap<String, String>();
//
//		String Bopname = faker.name().firstName() + faker.letterify("???");
//		faker.name().firstName();
//		faker.letterify("??????");
//
//		String partdescriptionvalue = faker.name().firstName() + faker.letterify("??????");
//		String partnumber = faker.name().firstName() + faker.letterify("???????");
//
//		int EnterTextWithEx = faker.number().numberBetween(10, 99);
//		String.valueOf(EnterTextWithEx);
//		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
//		String.valueOf(EnterValueWithMisc);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("BOP");
//		Thread.sleep(1000);
//		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
//		Thread.sleep(7000);
//		dashboard.clickingBopEntryTab();
//		Thread.sleep(3000);
//		quick.VerifySaveBopDataForInhouse(Bopname, partdescriptionvalue, partnumber, "Kg", "2025-2026", "Apr",
//				"Chris 57"  );
//		Thread.sleep(2999);
//
//	}
//
//	@Test(priority = 37, groups = "group1")
//	public void TC_BOP_012VerifyEditBopFunctionalityForStandard() throws InterruptedException {
//
//		String randomName = faker.name().firstName() + faker.letterify("??");
//		String BopTypeName = faker.name().firstName() + faker.letterify("????");
//		String BopTypeName1 = faker.name().firstName() + faker.letterify("????");
//		int randomint = faker.number().numberBetween(1000, 9999);
//		double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
//		double secondvalueoftwodigit = faker.number().randomDouble(2, 10, 99);
//		double thirdvalueoftwodigit = faker.number().randomDouble(2, 10, 99);
//		String partnumber = randomName + "-" + String.valueOf(randomint);
//		String updateddutiesvalue = String.valueOf(secondvalueoftwodigit);
//		String updatedfrieghtinsurancevalue = String.valueOf(thirdvalueoftwodigit);
//		String partDescription = randomName;
//		String partcostvalue = String.valueOf(valueoftwodigit);
//		String dutiesvalue = String.valueOf(valueoftwodigit);
//		String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("BOP");
//		Thread.sleep(3000);
//
//		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
//		driver.navigate().refresh();
//		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName1);
//		Thread.sleep(3000);
//		dashboard.clickingBopEntryTab();
//		Thread.sleep(2000);
//		BopEntryStandardPage.SaveBopWithStandardForUpdate(BopTypeName, partDescription, partnumber, partcostvalue,
//				dutiesvalue, frieghtinsurancevalue, BopTypeName, BopTypeName1, updateddutiesvalue,
//				updatedfrieghtinsurancevalue);
//
//		Thread.sleep(3000);
//
//	}
//
//	@Test(priority = 38, groups = "group1")
//	public void TC_BOP_012VerifyEditBopFunctionalityForImported() throws InterruptedException {
//		String BopCategory = "Imported";
//		String Bopname = faker.name().firstName() + faker.letterify("??????");
//		String Bopname1 = faker.name().firstName() + faker.letterify("????????");
//		String PartDescription = faker.name().firstName() + faker.letterify("??????");
//		String partnumber = faker.number().digits(3);
//		int EnterTextWithEx = faker.number().numberBetween(10, 99);
//		String.valueOf(EnterTextWithEx);
//		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
//		String.valueOf(EnterValueWithMisc);
//		dashboard.clickingDashboard("Dashboard");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("BOP");
//		Thread.sleep(1000);
//		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
//		Thread.sleep(3000);
//
//		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname1);
//		Thread.sleep(3000);
//		dashboard.clickingBopEntryTab();
//		try {
//			Thread.sleep(3000);
//			quick.VerifySaveAndUpdateImported(Bopname, BopCategory, PartDescription, partnumber, Bopname1);
//			Thread.sleep(2000);
//
//		} catch (Exception e) {
//
//			e.getMessage();
//		}
//
//	}
//
////////////////////////////////////////////////////////////////////////Supplier  Master //////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	@Test(priority = 39, groups = "group2")
//	public void Sup_006VerifyThatWhenAUserCreatesANewBusinessDomain() throws InterruptedException {
//
//		new HashMap<String, String>();
//
//		String Categoryname = faker.name().firstName();
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		supplier.clickbusinessseganddomainpage();
//
//		supplier.savedatawithbusinessdomain(Categoryname, "Business domain sucessfully saved.");
//
//		Thread.sleep(5000);
//
//		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
//
//	}
//
//	@Test(priority = 40, groups = "group2")
//	public void Sup_006VerifyThatWhenAUserCreatesANewBusinessSegment() throws InterruptedException {
//
//		new HashMap<String, String>();
//
//		String Categoryname = faker.name().firstName() + faker.letterify("???????????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		supplier.clickbusinessseganddomainpage();
//
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//
//		Thread.sleep(5000);
//
//		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
//
//	}
//
//	@Test(priority = 41, groups = "group2")
//	public void Sup_007VerifyDuplicateEntryBusinessDomain() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("???????????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		Thread.sleep(4000);
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(4000);
//
//		supplier.savedatawithbusinessdomain(Categoryname, "Business domain sucessfully saved.");
//		Thread.sleep(4000);
//		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
//		Thread.sleep(4000);
//		supplier.saveudplicatedata(Categoryname, "Business domain already exist.");
//
//	}
//
//	@Test(priority = 42, groups = "group2")
//	public void Sup_007VerifyDuplicateEntryBusinessSegment() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("???????????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(4000);
//
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//		Thread.sleep(4000);
//		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
//		Thread.sleep(4000);
//		supplier.saveudplicatedataWithBusinessSegment(Categoryname, "Business Segment already exist.");
//
//	}
//
//	@Test(priority = 43, groups = "group2")
//	public void verifyEditButtonIsWorkingOrNotWithBusinessDomain() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		Thread.sleep(4000);
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(6000);
//
//		supplier.savedatawithbusinessdomain(Categoryname, "Business domain sucessfully saved.");
//		Thread.sleep(4000);
//
//		quick.VerifyEditButtonFunctionalityForBusinessDomAndSegTabSupp(Categoryname);
//
//	}
//
//	@Test(priority = 44, groups = "group2")
//	public void verifyEditButtonIsWorkingOrNotWithBusinessSegMent() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		Thread.sleep(4000);	
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(6000);
//
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//		Thread.sleep(4000);
//
//		quick.VerifyEditButtonFunctionalityForBusinessDomAndSegTabSupp(Categoryname);
//
//	}
//
//	@Test(priority = 45, groups = "group2")
//	public void VerifyResetButtonIsWorkingOrNot() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		Thread.sleep(4000);
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(6000);
//		quick.VerifyResetButtonInBusinessDomainAndSegmentForm("Business Segments", Categoryname);
//
//	}
//
//	@Test(priority = 46, groups = "group2")
//	public void Sup018AfterCreatingANewSupplierInTheSupplierMasterTheUserShouldBeAbleToAllocateRawMaterial()
//	        throws InterruptedException {
// 
//	    String SuppCode = faker.number().digits(3);
//	    String suppname = faker.name().firstName() + faker.letterify("??????");
//	    String location = faker.country().name().replaceAll("[^A-Za-z]", "");
//	    String Emailid = "gfhjfhjs@gmail.com";
//	    String Emailid2 = "rftgh@gmail.com";
//	    String managrname = faker.name().fullName();
//	    faker.phoneNumber().phoneNumber();
//	    faker.phoneNumber().phoneNumber();
// 
//	    LoggerUtil.info("verify User Enter UserName And UserPassWord ");
//	    LoggerUtil.info("User Click LoginButton Sucessfully");
// 
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    LoggerUtil.info("User Select Master Data From Dashboard");
// 
//	    Thread.sleep(4000);
//	    dashboard.VerifyClickingMasterOptions("Supplier");
// 
//	    // ✅ YAHAN SE HASHMAP AAYEGA – DIRECT FROM SUPPLIER PAGE (BEFORE SAVE)
//	    HashMap<String, String> rowDataInSupplierPage = supplier.entersuppliervalueforrminput(
//	            SuppCode, suppname, location, Emailid, Emailid2, managrname);
// 
//	    LoggerUtil.info("🔍 DEBUG: HashMap received in Test → " + rowDataInSupplierPage);
// 
//	
//	    Thread.sleep(5000);
// 
//	    dashboard.VerifyClickingMasterOptions("Commodity");
//	    Thread.sleep(4000);
//	    dashboard.clickOnCommodityTabByName("Commodity Details");
//	    Thread.sleep(4000);
// 
//	    // Ye Commodity Details VIEW table se map hai (13.000, 14.000, 20.000 waala)
//	    Map<String, String> rowDataInCommodityDetailsViewTablePage =
//	            quick.verifySupplierAllocationForCommodityDetailsPage(suppname);
// 
//	    // Final cross-validation
//	    quick.VerifyFetchingUiData(rowDataInSupplierPage,
//	            rowDataInCommodityDetailsViewTablePage,
//	            suppname, SuppCode, location);
//	}
// 
//	
//	@Test(priority = 47, groups = "group2")
//	public void Sup_018_SupplierAllocationforProcessMaster() throws InterruptedException {
//
//		String SuppCode = faker.number().digits(3);
//		String suppname = faker.name().firstName() + faker.letterify("??????");
//		String location = faker.country().name();
//		String Emailid = "gfhjfhjs@gmail.com";
//		String Emailid2 = "rftgh@gmail.com";
//		String managrname = faker.name().fullName();
//		faker.phoneNumber().phoneNumber();
//		faker.phoneNumber().phoneNumber();
//
//		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
//		LoggerUtil.info("User Click LoginButton Sucessfully");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User Select Master Data From Dashboard");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		supplier.entersuppliervalueforProcessInPut(SuppCode, suppname, location, Emailid, Emailid2, managrname);
//
//		QuickMasterPage.TableColoumnValueVerifyFetchDataFromSupplierPageForProcessAllocation();
//
//		dashboard.VerifyClickingMasterOptions("Process");
//		quick.VerifySupplierAllocationInProcessMaster(suppname);
//
//	}
//
//	@Test(priority = 48, groups = "group2")
//	public void Sup_018_SupplierAllocationforOhpMaster() throws InterruptedException {
//
//		String SuppCode = faker.number().digits(3);
//		String suppname = faker.name().firstName() + faker.letterify("??????");
//		String location = faker.country().name();
//		String Emailid = "gfhjfhjs@gmail.com";
//		String Emailid2 = "rftgh@gmail.com";
//		String managrname = faker.name().fullName();
//		faker.phoneNumber().phoneNumber();
//		faker.phoneNumber().phoneNumber();
//
//		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
//		LoggerUtil.info("User Click LoginButton Sucessfully");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User Select Master Data From Dashboard");
//
//		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		Thread.sleep(3000);
//		supplier.entersuppliervalueforOHPInput(SuppCode, suppname, location, Emailid, Emailid2, managrname);
//
//		Thread.sleep(3000);
//		quick.VerifyOhpDataFetchingFromSupplierOhpAllocation();
//
//		
//		// Set up WebDriverWait with a 10-second timeout
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement ohpOption = null;
//
//		Thread.sleep(3000);
//		try {
//		    // Wait for the element to be clickable and store a reference to it
//		    ohpOption = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='OHP']")));
//		    
//		    // Scroll the element into view to ensure it's visible
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ohpOption);
//
//		    // Click the element using JavaScript
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ohpOption);
//		} catch (StaleElementReferenceException e) {
//		    // Handle the exception by re-locating the element
//		    System.out.println("Element is stale, retrying...");
//		    
//		    // Re-locate the element after the DOM update
//		    ohpOption = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='OHP']")));
//		    
//		    // Scroll into view and click again
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ohpOption);
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ohpOption);
//		}
//
//		Thread.sleep(3000);
//
//          String QuerrySearch = suppname+"-"+SuppCode;
//
//
//          Thread.sleep(3000);
//		quick.VerifySupplierNameHasBeenAllocateOrNot(QuerrySearch);
//	}
//
//	@Test(priority = 49, groups = "group2")
//	public void Sup_019ButtonsAppearanceAfterClickOnEditButtons() throws InterruptedException {
//
//		String SuppCode = faker.number().digits(3);
//		String suppname = faker.name().firstName() + faker.letterify("??????");
//		String location = faker.country().name();
//		String Emailid = "gfhjfhjs@gmail.com";
//		String Emailid2 = "rftgh@gmail.com";
//		String managrname = faker.name().fullName();
//		faker.phoneNumber().phoneNumber();
//		faker.phoneNumber().phoneNumber();
//
//		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
//		LoggerUtil.info("User Click LoginButton Sucessfully");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User Select Master Data From Dashboard");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		HashMap<String, String> StoredSupplierinfo = quick.StoredSupplierinfoVerifyEditButtons(SuppCode, suppname,
//				location, Emailid, Emailid2, managrname);
//
//		quick.VerifyEditButtonFunctionality(suppname, StoredSupplierinfo);
//
//	}
//
//	@Test(priority = 50, groups = "group2")
//	public void Sup_019ButtonsAppearanceAfterClickOnEditButtonsForUpdate() throws InterruptedException {
//
//		String SuppCode = faker.number().digits(3);
//		String suppname = faker.name().firstName() + faker.letterify("??????");
//		String UpdateSuppCode = faker.number().digits(3);
//		String Updatesuppname = faker.name().firstName() + faker.letterify("??????");
//		String location = faker.country().name();
//		String Emailid = "gfhjfhjs@gmail.com";
//		String Emailid2 = "rftgh@gmail.com";
//		String managrname = faker.name().fullName();
//		faker.phoneNumber().phoneNumber();
//		faker.phoneNumber().phoneNumber();
//
//		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
//		LoggerUtil.info("User Click LoginButton Sucessfully");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User Select Master Data From Dashboard");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		HashMap<String, String> StoredSupplierinfo = quick.StoredSupplierinfoVerifyEditButtons(SuppCode, suppname,
//				location, Emailid, Emailid2, managrname);
//
//		quick.VerifyEditButtonFunctionality(suppname, StoredSupplierinfo);
//
//		quick.UpdateButtonFuctionality(UpdateSuppCode, Updatesuppname, StoredSupplierinfo);
//
//	}
//
//	@Test(priority = 51, groups = "group2")
//	public void Sup_019ButtonsAppearanceAfterClickOnEditButtonsForSaveAsNew() throws InterruptedException {
//
//		String SuppCode = faker.number().digits(3);
//		String suppname = faker.name().firstName() + faker.letterify("??????");
//		String SaveAsNewSuppCode = faker.number().digits(3);
//		String SaveAsNewsuppname = faker.name().firstName() + faker.letterify("??????");
//		String location = faker.country().name();
//		String Emailid = "gfhjfhjs@gmail.com";
//		String Emailid2 = "rftgh@gmail.com";
//		String managrname = faker.name().fullName();
//		faker.phoneNumber().phoneNumber();
//		faker.phoneNumber().phoneNumber();
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("User Select Master Data From Dashboard");
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//
//		HashMap<String, String> StoredSupplierinfo = quick.StoredSupplierinfoVerifyEditButtons(SuppCode, suppname,
//				location, Emailid, Emailid2, managrname);
//
//		quick.VerifyEditButtonFunctionality(suppname, StoredSupplierinfo);
//		
//		quick.SaveAsNewButtonFuctionality(SaveAsNewSuppCode, SaveAsNewsuppname, StoredSupplierinfo);
//
//	}
//
//	@Test(priority = 52, groups = "group2")
//	public void Sup_019ButtonsAppearanceAfterClickOnEditButtonsForResetButtonFunctionality()
//			throws InterruptedException {
//
//		String SuppCode = faker.number().digits(3);
//		String suppname = faker.name().firstName() + faker.letterify("??????");
//		faker.number().digits(3);
//		faker.name().firstName();
//		faker.letterify("??????");
//		String location = faker.country().name();
//		faker.name().fullName();
//		faker.phoneNumber().phoneNumber();
//		faker.phoneNumber().phoneNumber();
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//		quick.VerifyResetButtonFunctionality(SuppCode, suppname, location);
//
//	}
//
//	@Test(priority = 53, groups = "group2")
//	public void Sup_019ButtonsAppearanceExportAndHeaderNameExcelFile() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//		LoggerUtil.info(" Supplier Master Excel export initiated");
//
//		HashMap<String, Integer> ColoumnsName = quick.ReadTableAndMatchWithExcelSheet();
//		quick.ExportSupplierexcelfile(ColoumnsName);
//
//	}
//
//	// @Test(priority=70,groups="group2")
//	public void Sup_019ImportExcelFileTryToValidateUiUpdateOrNot()
//			throws InterruptedException, IOException, AWTException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//		LoggerUtil.info("📤 Supplier Master Excel export initiated");
//
//		HashMap<String, Integer> ColoumnsName = quick.ReadTableAndMatchWithExcelSheet();
//		quick.exportandimportnewdata(ColoumnsName);
//
//		quick.importNewSupplierMasterExcel();
//
//	}
//
//	@Test(priority = 54, groups = "group2")
//	public void Sup_032PreventDeletionOfSupplierWithCostingEntries() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier')]")));
//		action.moveToElement(supplierOption).click().perform();
//
//		supplier.deletecostingdatainsupplierpage("Data Already Being Used in Costing!");
//
//	}
//	/////////////////////////////////////////////////////////// Customer
//	/////////////////////////////////////////////////////////// Master///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	@Test(priority = 55, groups = "group2")
//	public void Cust_006VerifyThatWhenAUserCreatesANewBusinessDomainForCustomerMaster() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		supplier.savedatawithbusinessdomain(Categoryname, "Business domain sucessfully saved.");
//
//		Thread.sleep(5000);
//
//		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
//
//	}
//
//	@Test(priority = 56, groups = "group2")
//	public void Cust_006VerifyThatWhenAUserCreatesANewBusinessSegMentForCustomerMaster() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//
//		Thread.sleep(5000);
//
//		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
//
//	}
//
//	@Test(priority = 57, groups = "group2")
//	public void Cust_015DuplicateDetectionWithWhitespaceCaseVariationsForBusinessSegMent() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		Thread.sleep(3000);
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//
//		String WithWhiteSpace = "         " + Categoryname + "   ";
//
//		supplier.saveudplicatedataWithBusinessSegment(WithWhiteSpace, "Business Segment already exist.");
//		Thread.sleep(3999);
//
//	}
//
//	@Test(priority = 58, groups = "group2")
//	public void Cust_015DuplicateDetectionWithWhitespaceCaseVariationsForBusinessDomain() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		supplier.savedatawithbusinessdomain(Categoryname, "Business domain sucessfully saved.");
//
//		String WithWhiteSpace = "         " + Categoryname + "   ";
//
//		supplier.saveudplicatedata(WithWhiteSpace, "Business domain already exist.");
//
//	}
//
//	@Test(priority = 59, groups = "group2")
//	public void Cust017SearchBoxPartialSpecialEmptyBusinessDomian() throws InterruptedException {
//		SoftAssert soft = new SoftAssert();
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		dashboard.VerifyClickingMasterOptions("Customer");
//		supplier.clickbusinessseganddomainpage();
//		supplier.savedatawithbusinessdomain(Categoryname, "Business domain sucessfully saved.");
//
//		Thread.sleep(6000);
//
//		HashMap<String, String> actualValues = quick.VerifyDataSaveOrNotInBusinessDomainAndSegMent(Categoryname);
//
//		String CategoryTypeValue = actualValues.get("Category Type");
//		soft.assertEquals(CategoryTypeValue, "Business Domain", " Mismatch: Category Type value not matching!");
//
//		String CategoryNameValue = actualValues.get("Category Name");
//		soft.assertEquals(CategoryNameValue, Categoryname, " Mismatch: Category Name value not matching!");
//
//		soft.assertAll();
//	}
//
//	@Test(priority = 60, groups = "group2")
//	public void Cust017SearchBoxPartialSpecialEmptyBusinessSegSegment() throws InterruptedException {
//
//		SoftAssert soft = new SoftAssert();
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//
//		Thread.sleep(5000);
//		HashMap<String, String> actualValues = quick.VerifyDataSaveOrNotInBusinessDomainAndSegMent(Categoryname);
//
//		String CategoryTypeValue = actualValues.get("Category Type");
//		soft.assertEquals(CategoryTypeValue, "Business Segments", " Mismatch: Category Type value not matching!");
//
//		String CategoryNameValue = actualValues.get("Category Name");
//		soft.assertEquals(CategoryNameValue, Categoryname, " Mismatch: Category Name value not matching!");
//
//		soft.assertAll();
//
//	}
//
//	@Test(priority = 61, groups = "group2")
//	public void Cust019ResetButtonUnsavedData() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		quick.VerifyResetButtonFunctionality(Categoryname);
//
//	}
//
//	@Test(priority = 62, groups = "group2")
//	public void Cust020DeleteConfirmationDependencyMessage() throws InterruptedException {
//
//		faker.name().firstName();
//		faker.letterify("?????");
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		supplier.clickbusinessseganddomainpage();
//
//		quick.VerifyDeleteCastingData("MK-18102", "Data Already Being Used in Costing");
//
//	}
//
//	@Test(priority = 63, groups = "group2")
//	public void Cust_027AllActionButtonsForEdit() throws InterruptedException {
//
//		String Categoryname = faker.name().firstName() + faker.letterify("?????");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		Thread.sleep(4000);
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(6000);
//
//		supplier.savedatawithbusinesssegment(Categoryname, "Business Segment sucessfully saved.");
//		Thread.sleep(4000);
//
//		quick.VerifyEditButtonFunctionalityForBusinessDomAndSegTabSupp(Categoryname);
//
//	}
//
//	@Test(priority = 64, groups = "group2")
//	public void Cust027AllActionsButtonsForSaveButton() throws InterruptedException {
//
//		String CustomerCode = faker.number().digits(3);
//		String Customername = faker.name().firstName() + faker.letterify("??????");
//		String CustomerLocation = faker.country().capital();
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		quick.SaveNewCustomer(CustomerCode, Customername, CustomerLocation, "Customer Profiles successfully saved.");
//
//		QuickMasterPage.VerifyDeleteButton(Customername, "Customer Profile Successfully Deleted");
//
//	}
//
//	@Test(priority = 65, groups = "group2")
//	public void Cust027AllActionButtonsForEditButton() throws InterruptedException {
//		HashMap<String, String> StoreNewCustomerInfo = new HashMap<>();
//		String CustomerCode = faker.number().digits(3);
//		String Customername = faker.name().firstName() + faker.letterify("??????");
//		String rawLocation = faker.country().capital();
//		String CustomerLocation = rawLocation.replaceAll("'/', '-',''', and '_'.", "");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//		Thread.sleep(8000);
//		quick.SaveNewCustomer(CustomerCode, Customername, CustomerLocation, "Customer Profiles successfully saved.");
//
//		StoreNewCustomerInfo.put("Customer Code", CustomerCode);
//		StoreNewCustomerInfo.put("Customer Name", Customername);
//		StoreNewCustomerInfo.put("Customer Location", CustomerLocation);
//		StoreNewCustomerInfo.put("Business Domain", "rishi");
//		StoreNewCustomerInfo.put("Business Segment", "sachindra1");
//		Thread.sleep(7000);
//
//		HashMap<String, String> TablesValue = QuickMasterPage.VerifyEditButton(Customername);
//		Thread.sleep(5000);
//		quick.VerifyFetchingValueFromAllCell(TablesValue);
//		Thread.sleep(5000);
//		QuickMasterPage.VerifyDeleteButton(Customername, "Customer Profile Successfully Deleted");
//
//	}
//
//	@Test(priority = 66, groups = "group2")
//	public void Cust027AllActionButtonsForDeleteButton() throws InterruptedException {
//
//		String CustomerCode = faker.number().digits(3);
//		String Customername = faker.name().firstName() + faker.letterify("??????");
//		String rawLocation = faker.country().capital();
//		String CustomerLocation = rawLocation.replaceAll("'/', '-',''', and '_'.", "");
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//		Thread.sleep(8000);
//		quick.SaveNewCustomer(CustomerCode, Customername, CustomerLocation, "Customer Profiles successfully saved.");
//		Thread.sleep(5000);
//		QuickMasterPage.VerifyDeleteButton(Customername, "Customer Profile Successfully Deleted");
//
//	}
//
//	@Test(priority = 67, groups = "group2")
//	public void Cust027AllActionButtonsForSaveAsNewButton() throws InterruptedException {
//
//		String CustomerCode = faker.number().digits(3);
//		String SaveAsnewCustomerCode = faker.number().digits(4);
//		String Customername = faker.name().firstName() + faker.letterify("??????");
//		String SaveAsNewCustomerName = faker.name().firstName() + faker.letterify("??????");
//		String rawLocation = faker.country().capital();
//		String CustomerLocation = rawLocation.replaceAll("'/', '-',''', and '_'.", "");
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//		Thread.sleep(8000);
//		quick.SaveNewCustomer(CustomerCode, Customername, CustomerLocation, "Customer Profiles successfully saved.");
//		Thread.sleep(4000);
//		QuickMasterPage.VerifyEditButton(Customername);
//		Thread.sleep(5000);
//		HashMap<String, String> saveAsNewCustomerInfo = QuickMasterPage.VerifySaveAsNewData(SaveAsnewCustomerCode,
//				SaveAsNewCustomerName, "New Customer Profiles successfully saved.");
//		Thread.sleep(5000);
//		QuickMasterPage.VerifySaveAsNewDataButtonAndVerifyTableData(SaveAsNewCustomerName);
//		Thread.sleep(4000);
//		quick.VerifyFetchingSaveAsNewValueForSaveAsNew(saveAsNewCustomerInfo);
//
//	}
//
//	@Test(priority = 68, groups = "group2")
//	public void Cust027AllActionButtonsForExportButton() throws Exception {
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		quick.VerifyDownloadExcelFileAndExportButton("File Exported Successfully");
//
//		quick.VerifyReadCustomerMasterExcelFile();
//
//	}
//
//	@Test(priority = 69, groups = "group2")
//	public void Cust027AllActionButtonsForImportButton() throws InterruptedException, IOException, AWTException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		quick.VerifyImportButton();
//
//		HashMap<String, String> CustomerDataFromExcel = QuickMasterPage.ExcelFillerValueInCustomerExcelFile();
//		File file = getLatestCustomerMasterFIle();
//
//		String latestfile = file.getAbsolutePath();
//
//		ExcelUtil.openSaveCloseExcelFile(latestfile);
//
//		quick.ImportCustomerExcelFile("SucessFully.");
//
//		String customerNanme = CustomerDataFromExcel.get("Customer-Name");
//
//		QuickMasterPage.VerifyEditButton(customerNanme);
//
//		quick.VerifyAllFetchedImportedSucessFullyOrNot(CustomerDataFromExcel);
//	}
//
//	@Test(priority = 70, groups = "group2")
//	public void Cust_042PreventDeletionOfCustomerWithCostingEntries() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		quick.PreventDeletionOfCustomerWithCostingEntries("Mk-2208-5", "Data Already Being Used in Costing!");
//
//	}
//
//	@Test(priority = 71, groups = "group2")
//	public void Cust_045VerifyDataConsistencyBetweenFrontendAndExportedExcelSheet() throws InterruptedException {
//
//		HashMap<String, String> expected = new HashMap<>();
//		String CustomerCode = faker.number().digits(3);
//		String Customername = faker.name().firstName() + faker.letterify("??????");
//		String CustomerLocation = faker.country().capital();
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") + prop.getProperty("password"));
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(8000);
//		dashboard.VerifyClickingMasterOptions("Customer");
//
//		quick.SaveNewCustomer(CustomerCode, Customername, CustomerLocation, "Customer Profiles successfully saved.");
//
//		// Keys must match Excel headers exactly
//		expected.put("Customer Code", CustomerCode);
//		expected.put("Customer Name", Customername);
//		expected.put("Customer Location", CustomerLocation);
//		expected.put("Business Domain", "rishi");
//		expected.put("Business Segments", "sachindra1");
//
//		Thread.sleep(6000);
//		quick.VerifyDownloadExcelFileAndExportButton("File Exported Successfully");
//		Thread.sleep(15000);
//
//		quick.VeriDataConsistencyExcelFile(expected);
//	}
//
//	@Test(priority = 72, groups = "group2")
//	public void Cust_047VerifyingDuplicateEntryAndNewEntryAdditionViaExcelImport()
//			throws InterruptedException, IOException, AWTException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		
//		dashboard.VerifyClickingMasterOptions("Customer");
//		Thread.sleep(8000);
//		quick.VerifyImportButton();
//
//		// Excel filler method return karta hai -> {Original, Duplicate}
//		Map<String, HashMap<String, String>> allData = QuickMasterPage.VerifyDuplicateDataInExcelFileAndCheckUi();
//
//		HashMap<String, String> originalData = allData.get("Original");
//		HashMap<String, String> duplicateData = allData.get("Duplicate");
//
//		File file = getLatestCustomerMasterFIle();
//		String latestfile = file.getAbsolutePath();
//
//		ExcelUtil.openSaveCloseExcelFile(latestfile);
//		quick.ImportCustomerExcelFile("File Imported Successfully");
//
//		Thread.sleep(7000);
//		QuickMasterPage.VerifyEditButtonForDuplicateAndUniqueData(originalData);
//
//		quick.VerifyAllFetchedImportedSucessFullyOrNotForDuplicateAndUniqueData(allData);
//
//		QuickMasterPage.VerifyForDuplicateData(duplicateData);
//
//	}
//	////////////////////////////////////////////////////// Process Master
//	////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	@Test(priority = 73, groups = "group2")
//	public void PM_01VerifyMasterOpensInstantaneously() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(2000);
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.VerifyProcessMasterLoadTime();
//
//	}
//
//	@Test(priority = 74, groups = "group2")
//	public void PM_07VerifyMandatoryFieldsValidationOnSaveWithoutProcessName() throws InterruptedException {
//
//		String processRate = faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		long startTime = System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		long Endtime = System.currentTimeMillis();
//
//		long loadTime = Endtime - startTime;
//
//		LoggerUtil.info("Total Load Time = " + loadTime);
//
//		quick.VerifySaveWithoutMandatoryFieldForProcessName(processRate, "rishi", "Process Name required.!");
//
//	}
//
//	@Test(priority = 75, groups = "group2")
//	public void PM_07VerifyMandatoryFieldsValidationOnSaveWithoutProcessRate() throws InterruptedException {
//
//		String processName = faker.name().firstName();
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		long startTime = System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		long Endtime = System.currentTimeMillis();
//
//		long loadTime = Endtime - startTime;
//
//		LoggerUtil.info("Total Load Time = " + loadTime);
//
//		quick.VerifySaveWithoutMandatoryFieldForProcessRate(processName, "rishi", "Rate required.!");
//
//	}
//
//	@Test(priority = 76, groups = "group2")
//	public void PM_07VerifyMandatoryFieldsValidationOnSaveWithoutUnit() throws InterruptedException {
//
//		String processName = faker.name().firstName();
//
//		String processRate = faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		long startTime = System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		long Endtime = System.currentTimeMillis();
//
//		long loadTime = Endtime - startTime;
//
//		LoggerUtil.info("Total Load Time = " + loadTime);
//
//		quick.VerifySaveWithoutMandatoryFieldForWithoutUnit(processName, processRate, "rishi", "Select Unit");
//
//	}
//
//	@Test(priority = 77, groups = "group2")
//	public void PM_07VerifyMandatoryFieldsValidationOnSaveWithoutRmInputCategory() throws InterruptedException {
//
//		String processName = faker.name().firstName();
//
//		String processRate = faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		Thread.sleep(3000);
//		long startTime = System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		long Endtime = System.currentTimeMillis();
//
//		long loadTime = Endtime - startTime;
//
//		LoggerUtil.info("Total Load Time = " + loadTime);
//
//		quick.VerifySaveWithoutMandatoryFieldForWithoutRmInput(processName, processRate, "rishi",
//				"Please select atleast one RM input category");
//
//	}
//
//	@Test(priority = 78, groups = "group2")
//	public void PM_07VerifyMandatoryFieldsValidationOnSaveWithoutSupplier() throws InterruptedException {
//
//		String processName = faker.name().firstName();
//
//		String processRate = faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		long startTime = System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		long Endtime = System.currentTimeMillis();
//
//		long loadTime = Endtime - startTime;
//
//		LoggerUtil.info("Total Load Time = " + loadTime);
//
//		quick.VerifySaveWithoutMandatoryFieldSupplier(processName, processRate, "rishi",
//				"Select either customer or supplier!");
//
//	}
//
//	@Test(priority = 79, groups = "group2")
//	public void PM_16SaveAProcessWithSupplierSpecificDelta() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		String deltaprice = faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		QuickMasterPage.VerifySaveProcessWithSupplierSpecificDelta(processName, processRate, "rishi", deltaprice,
//				"Process Details Saved successfully.");
//		quick.FetchingDataProcessMaster(processName);
//		quick.VerifyFetchingDataFromUi(processName, processRate, deltaprice, "rishi");
//
//	}
//
//	@Test(priority = 80, groups = "group2")
//	public void PM_17SaveAprocessWithCustomerSpecificDelta() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		String deltaprice = faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.VeifyAndSaveCustomerSpecificDelta(processName, processRate, "123-123-123", "2208-3-2208-3-Mohali",
//				"Select all", deltaprice, "Process Details Saved successfully.");
//
//		quick.FetchingDataProcessMaster(processName);
//
//		quick.VerifyFetchingDataFromUiForCustomerSpecificDelta(processName, processRate, "123-123-123",
//				"2208-3-2208-3-Mohali");
//
//	}
//
//	@Test(priority = 81, groups = "group2")
//
//	public void PM_18SaveWithNegativeDeltavaluesSupplier() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		String deltaprice = "-" + faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		QuickMasterPage.VerifySaveProcessWithSupplierSpecificDelta(processName, processRate, "rishi", deltaprice,
//				"Process Details Saved successfully.");
//		quick.FetchingDataProcessMaster(processName);
//		quick.VerifyFetchingDataFromUi(processName, processRate, deltaprice, "rishi");
//
//	}
//
//	@Test(priority = 82, groups = "group2")
//
//	public void PM_18SaveWithNegativeDeltavaluesCustomer() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		String deltaprice = "-" + faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		System.currentTimeMillis();
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.VeifyAndSaveCustomerSpecificDelta(processName, processRate, "123-123-123", "2208-3-2208-3-Mohali",
//				"Select all", deltaprice, "Process Details Saved successfully.");
//
//		quick.FetchingDataProcessMaster(processName);
//
//		quick.VerifyFetchingDataFromUiForCustomerSpecificDelta(processName, processRate, "123-123-123",
//				"2208-3-2208-3-Mohali");
//
//	}
//
//	@Test(priority = 83, groups = "group2")
//	public void PM_26ValidateDeleteFunctionality() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		String deltaprice = faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		QuickMasterPage.VerifySaveProcessWithSupplierSpecificDelta(processName, processRate, "rishi", deltaprice,
//				"Process Details Saved successfully.");
//
//		quick.VerifyDeleteFunctionalityWithNewData(processName, processName, processRate, "rishi");
//
//	}
//
//	@Test(priority = 84, groups = "group2")
//	public void PM_27DeleteProcessUsedInCostingShouldShowPrompt() throws InterruptedException {
//
//		faker.name().firstName();
//		faker.letterify("??????");
//		faker.number().digits(3);
//		faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.VerifyDeleteFunctionalityWithNewData("21112024");
//
//	}
//
//	@Test(priority = 85, groups = "group2")
//	public void PM_30CheckResetButtonSupplier() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		QuickMasterPage.VerifySaveProcessWithSupplierSpecificDeltaForResetButton(processName, processRate, "rishi", processRate);
//
//	}
//
//	@Test(priority = 86, groups = "group2")
//	public void PM_30CheckResetButtonCustomer() throws InterruptedException {
//
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		String deltaprice = faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		Thread.sleep(300);
//		dashboard.VerifyClickingMasterOptions("Process");
//		quick.VeifyAndSaveCustomerSpecificDeltaForResetButton(processName, processRate, "123-123-123",
//				"2208-3-2208-3-Mohali", "Select all", deltaprice);
//
//	}
//
//	@Test(priority = 87, groups = "group2")
//	public void PM_31CheckSaveAsNewSupplier() throws InterruptedException {
//		String newprocessname = faker.name().firstName() + faker.letterify("??????");
//		String newprocessRate = faker.number().digits(3);
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.VerifySaveForSupplier(processName, processRate, "rishi");
//
//		quick.VerifyEnterNewDataInProcessNameAndSaveAsNew(newprocessname, newprocessRate, "rishi");
//
//	}
//
//	@Test(priority = 88, groups = "group2")
//	public void PM_33UpdateButtonFunctionality() throws InterruptedException {
//
//		faker.name().firstName();
//		faker.letterify("??????");
//		String newprocessRate = faker.number().digits(3);
//		String processName = faker.name().firstName() + faker.letterify("??????");
//		faker.number().digits(3);
//		String processRate = faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.VerifySaveForCustomer(processName, processRate, "123-123-123",
//				"2208-3-2208-3-Mohali");
//
//		quick.VerifyUpdateButtonForUpdatingValues(processName, newprocessRate, "Mk-2208-5-2208-5-Mohali", "302-Raj-");
//
//	}
//
//	@Test(priority = 89, groups = "group2")
//	public void PM_36ValidateExportButtonFuntionality() throws InterruptedException {
//
//		faker.name().firstName();
//		faker.letterify("??????");
//		faker.number().digits(3);
//		faker.name().firstName();
//		faker.letterify("??????");
//		faker.number().digits(3);
//		faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		quick.ClickingExportButtonAndItShouldShowWithinSecond();
//
//	}
//
//	@Test(priority = 90, groups = "group2")
//	public void PM_49ValidateImportButton() throws InterruptedException, IOException, AWTException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Process");
//
//		HashMap<String, String> storeSuppliername = quick.VerifyExportOrDownloadExcelFileProcessMaster("0801-Celesta-");
//
//		HashMap<String, String> storeExcelinfoProcessMaster = quick.WriteExcelFileForSupplierProcessMaster();
//
//		quick.VeifySaveAndImportExcelFile(storeExcelinfoProcessMaster);
//
//		quick.VerifyExcelImportedFileSaveOrNotInTable(storeExcelinfoProcessMaster);
//
//		quick.VerifyUiDataAndExcelData(storeExcelinfoProcessMaster, storeSuppliername);
//	}
//
////////////////////////////////////////////////////////////Part Master /////////////////////////////////////////////////////////////////////
//
//	@Test(priority = 91, groups = "group2")
//	public void PT_01OpeningTheMaster() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.VerifyFetchingHeaderAndPageLoadTime();
//	}
//
//	@Test(priority = 92, groups = "group2")
//	public void PT_02SavingThePartBothType() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//	}
//
//	@Test(priority = 93, groups = "group2")
//	public void PT_03SavingThePartProcurmentType() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//
//	}
//
//	@Test(priority = 94, groups = "group2")
//	public void PT_04SavingThePartSalesType() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
//				DataProp.getProperty("ProductCategoryNamePartMaster"),
//				DataProp.getProperty("ProductModelName&No.PartMaster"),
//				DataProp.getProperty("SpecialProductCategoryPartMaster"));
//
//	}
//
//	@Test(priority = 95, groups = "group2")
//	public void PT_05ViewThePartMastersForCustomerSideProductCategoryColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
//				DataProp.getProperty("ProductCategoryNamePartMaster"),
//				DataProp.getProperty("ProductModelName&No.PartMaster"),
//				DataProp.getProperty("SpecialProductCategoryPartMaster"));
//		
//		
//		quick.VerifyViewAndSearchFunctionality("Product Category", DataProp.getProperty("ProductCategoryNamePartMaster"));
//
//	}
//
//	@Test(priority = 96, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeForCompanyNameColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
//
//	}
//
//	@Test(priority = 97, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeForPartDescriptionColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Part Description", partDescription);
//
//	}
//
//	@Test(priority = 98, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeForPartNumberColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Part No.", partnumber);
//
//	}
//
//	@Test(priority = 99, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeProductCategoryColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//
//		quick.VerifyViewAndSearchFunctionality("Product Category", "rishi");
//
//	}
//
//	@Test(priority = 100, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypePartUomColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Part UOM", "Hourly");
//
//	}
//
//	@Test(priority = 101, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeCostingTypeColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Costing Type", "Procurement");
//
//	}
//
//	@Test(priority = 102, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypePartModelNameAndNumberColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Product Model Name and No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
//
//	}
//
//	@Test(priority = 103, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeSpecialProductCategoryColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		quick.VerifyViewAndSearchFunctionality("Special Product Category", "ACCESSORIES");
//
//	}
//
//	@Test(priority = 104, groups = "group2")
//	public void PT_05ViewThePartMastersForBothTypeCustomerColoumn() throws InterruptedException {
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//		
//		
//		quick.VerifyViewAndSearchFunctionality("Customer", DataProp.getProperty("CustomerNamePartMaster"));
//
//	}
//
//	@Test(priority = 105, groups = "group2")
//	public void PT_07SavedDataValidation() throws InterruptedException {
//
//		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//
//		storePartMasterInfo.put("Part Number", partnumber);
//		storePartMasterInfo.put("Part Description", partDescription);
//		storePartMasterInfo.put("Part Uom", "Hourly");
//		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
//		storePartMasterInfo.put("Supplier Name", "0801 - Celesta");
//		storePartMasterInfo.put("Customer Name", "rishicustomer-Tbilisi-0004");
//		storePartMasterInfo.put("Product Category Name", "rishi");
//		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
//		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");
//
//		quick.VerifyViewAndSearchFunctionalityForWhoelRowData(partDescription, storePartMasterInfo);
//
//	}
//
//	@Test(priority = 106, groups = "group2")
//	public void PT_08UpdatingThePart() throws InterruptedException {
//
//		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
//
//		String updatepartnumber = faker.number().digits(2)+ "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//		String updatePartDescription = faker.name().firstName() + faker.number().digits(3);
//
//		HashMap<String, String> storeupdatedDataInfo = new HashMap<String, String>();
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//
//		storePartMasterInfo.put("Part Number", partnumber);
//		storePartMasterInfo.put("Part Description", partDescription);
//		storePartMasterInfo.put("Part Uom", "Hourly");
//		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
//		storePartMasterInfo.put("Supplier Name", "0801 - Celesta");
//		storePartMasterInfo.put("Customer Name", "rishicustomer-Tbilisi-0004");
//		storePartMasterInfo.put("Product Category Name", "rishi");
//		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
//		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");
//
//		quick.VerifyViewAndSearchFunctionality(partDescription);
//
//		quick.ValidateDataFromTable(storePartMasterInfo);
//		quick.EnterNewPartDescriptionAndReplacepriviousData(updatepartnumber, updatePartDescription);
//		storeupdatedDataInfo.put("Updated-PartNumber", updatepartnumber);
//		storeupdatedDataInfo.put("Updated-PartDescription", updatePartDescription);
//		Thread.sleep(2000);
//		quick.VerifyViewAndSearchFunctionality(updatePartDescription);
//		quick.ValidateDataFromTableForUpdated(storePartMasterInfo, storeupdatedDataInfo);
//
//	}
//
//	@Test(priority = 107, groups = "group2")
//	public void PT_09SaveAsNew() throws InterruptedException {
//
//		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
//
//		String SaveAsNewpartnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//		String SaveAsNewPartDescription = faker.name().firstName() + faker.number().digits(5);
//
//		HashMap<String, String> storeupdatedDataInfo = new HashMap<String, String>();
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//
//		storePartMasterInfo.put("Part Number", partnumber);
//		storePartMasterInfo.put("Part Description", partDescription);
//		storePartMasterInfo.put("Part Uom", "Hourly");
//		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
//		storePartMasterInfo.put("Supplier Name", "0801 - Celesta");
//		storePartMasterInfo.put("Customer Name", "rishicustomer-Tbilisi-0004");
//		storePartMasterInfo.put("Product Category Name", "rishi");
//		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
//		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");
//
//		quick.VerifyViewAndSearchFunctionality(partDescription);
//
//		quick.ValidateDataFromTable(storePartMasterInfo);
//		quick.EnterNewPartDescriptionAndReplacepriviousDataForSaveAsNew(SaveAsNewpartnumber, SaveAsNewPartDescription);
//		storeupdatedDataInfo.put("SaveAsNew-PartNumber", SaveAsNewpartnumber);
//		storeupdatedDataInfo.put("SaveAsNew-PartDescription", SaveAsNewPartDescription);
//		Thread.sleep(2000);
//		quick.VerifyViewAndSearchFunctionality(SaveAsNewPartDescription);
//		quick.ValidateDataFromTableForSaveAsNew(storePartMasterInfo, storeupdatedDataInfo);
//
//	}
//
//	@Test(priority = 108, groups = "group2")
//	public void PT_10DeleteTheSavedPartHavingBom() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		String CostingValue = "12112024-3-NFC-OC";
//
//		quick.VerifyViewAndSearchFunctionality(CostingValue);
//		quick.VerifyViewAndColoumnNameAndColoumnValues("Part No.", "12112024-3-NFC-OC");
//
//	}
//
//	@Test(priority = 109, groups = "group2")
//	public void PT_11DeleteTheSavedPartNoDependantReport() throws InterruptedException {
//
//		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
//
//		faker.number().digits(2);
//		faker.name().firstName();
//		faker.number().digits(5);
//
//		new HashMap<String, String>();
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
//				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
//				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
//
//		storePartMasterInfo.put("Part Number", partnumber);
//		storePartMasterInfo.put("Part Description", partDescription);
//		storePartMasterInfo.put("Part Uom", "Hourly");
//		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
//		storePartMasterInfo.put("Supplier Name", "0801-Abe");
//		storePartMasterInfo.put("Customer Name", "rishicustomer-Tbilisi-0004");
//		storePartMasterInfo.put("Product Category Name", "rishi");
//		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
//		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");
//
//		quick.VerifyViewAndSearchFunctionality(partDescription);
//
//		quick.DeleteDataFromTableWihoutCostingData(storePartMasterInfo);
//
//	}
//
//	@Test(priority = 110, groups = "group2")
//	public void PT_12ExportPartMasterOnly() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.VerifyExportExcelFileForPartMaster(DataProp.getProperty("CompanyNamePartMaster"));
//
//	}
//
//	@Test(priority = 111, groups = "group2")
//	public void PT_14ExportOldCostingOnly() throws InterruptedException {
//
//		String numberofparts = "1";
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.VerifyExportAndDownloadExcelFileForOldCosting(DataProp.getProperty("CompanyNamePartMaster"),
//				DataProp.getProperty("RadioButtonByNameForSupplierPartMaster"),
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"),
//				DataProp.getProperty("ProductCategoryNamePartMaster"),
//				DataProp.getProperty("ProductModelName&No.PartMaster"),
//				DataProp.getProperty("SpecialProductCategoryPartMaster"), numberofparts, "2025-2026",
//				DataProp.getProperty("CommodityGroupDropdownPartMaster"), "Select all");
//
//	}

////	@Test(priority = 112, groups = "group2", enabled = true)
////	public void PT_15ImportOldCostingOnly() throws Throwable {
////
////		LoggerUtil.info("===== Starting PT_15ImportOldCostingOnly =====");
////		String numberofparts = "1";
////
////		HashMap<String, String> CommodityDetailsInfo = TC_CD_009SaveRmScrapPricesWith3DecimalPrecision();
////
////		String FromDetailsTabComgroup = CommodityDetailsInfo.get("CommodityGroup");
////		String FromDetailsTabGroupClassification = CommodityDetailsInfo.get("GroupClassification");
////		String FromDetailsTabGrade = CommodityDetailsInfo.get("SpecificGrade");
////		String FromDetailsTabYearValue = CommodityDetailsInfo.get("Year-Data");
////
////		dashboard.selectMenuFormDashBoard("Master Data");
////		Thread.sleep(3000);
////		dashboard.VerifyClickingMasterOptions("Part Master");
////
////		quick.VerifyExportAndDownloadExcelFileForOldCosting(DataProp.getProperty("CompanyNamePartMaster"),
////				DataProp.getProperty("RadioButtonByNameForSupplierPartMaster"),
////				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"),
////				DataProp.getProperty("ProductCategoryNamePartMaster"),
////				DataProp.getProperty("ProductModelName&No.PartMaster"),
////				DataProp.getProperty("SpecialProductCategoryPartMaster"), numberofparts, FromDetailsTabYearValue,
////				FromDetailsTabComgroup, FromDetailsTabGroupClassification);
////
////		LoggerUtil.pass(" Export completed successfully. Proceeding to precision validation...");
////
////		HashMap<String, String> StoreOldCostingInfo = quick.VerifyFillExcelFilepartMasterOldCasting(
////				FromDetailsTabComgroup, FromDetailsTabGroupClassification, FromDetailsTabGrade,
////				FromDetailsTabYearValue);
////
////		File file = getLatestOldCostingFile();
////
////		String filesave = file.getAbsolutePath();
////
////		ExcelUtil.openSaveCloseExcelFile(filesave);
////
////		quick.ImportExcelSheet();
////		driver.navigate().refresh();
////
////		// Verify it’s not empty before use
////		if (StoreOldCostingInfo == null || StoreOldCostingInfo.isEmpty()) {
////			LoggerUtil.error("❌ Old Costing Info map is empty. Excel may not have been filled properly.");
////		} else {
////			quick.VerifyDataHasBeenUpdatedOrNot(StoreOldCostingInfo);
////		}
////		quick.VerifyFetchDataInPartAttribute();
////
////		quick.verifyAssemblyCostData(StoreOldCostingInfo);
////
////	}

//	@Test(priority = 113, groups = "group2")
//	public void PT_16ExportDetailedCostingOnly() throws InterruptedException {
//
//		String numberofparts = "1";
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		Thread.sleep(2999);
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.VerifyExportAndDownloadExcelFileForDetailsCosting(DataProp.getProperty("CompanyNamePartMaster"),
//				DataProp.getProperty("RadioButtonByNameForSupplierPartMaster"),
//				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"),
//				DataProp.getProperty("ProductCategoryNamePartMaster"),
//				DataProp.getProperty("ProductModelName&No.PartMaster"),
//				DataProp.getProperty("SpecialProductCategoryPartMaster"), numberofparts, "2025-2026", "Leighqxtpy",
//				"Sasha 64", "File exported successfully");
//
//	}

	//@Test(priority = 116, groups = "group2")
	public void PT_17ImportDetailedCostingOnly() throws InterruptedException {

		String numberofparts = "1";
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(2999);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.VerifyExportAndDownloadExcelFileForDetailsCosting(DataProp.getProperty("CompanyNamePartMaster"),
				DataProp.getProperty("RadioButtonByNameForSupplierPartMaster"),
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"), numberofparts, "2025-2026", "Leighqxtpy",
				"Sasha 64", "File exported successfully");

	}

//	@Test(priority = 115, groups = "group2")
//	public void PT_18ResetButtonFunctionality() throws InterruptedException {
//
//		new HashMap<String, String>();
//
//		faker.number().digits(2);
//		faker.name().firstName();
//		faker.number().digits(5);
//
//		new HashMap<String, String>();
//
//		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
//
//		String partDescription = faker.name().firstName() + faker.number().digits(3);
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Part Master");
//
//		quick.EnterValueInBothTypeSideAndVerifyResetButton(partnumber, partDescription,
//				DataProp.getProperty("PartUomPartMaster"), DataProp.getProperty("CompanyNamePartMaster"),
//				DataProp.getProperty("RadioButtonByNameForBoth"), DataProp.getProperty("SupplierNamePartMaster"),
//				DataProp.getProperty("CustomerNamePartMaster"), DataProp.getProperty("ProductCategoryNamePartMaster"),
//				DataProp.getProperty("ProductModelName&No.PartMaster"),
//				DataProp.getProperty("SpecialProductCategoryPartMaster"));
//
//		quick.VerifyResetButtonFunctionality();
//
//	}

//////////////////////////////////////////////////////////////////////////Costing////////////////////////////////////////////////////////////////////////////////////////////	

	@Test(priority = 110, groups = "group3")
	public void PT_C_01SaveStandardShapesForCustomerSide() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));
		
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalculationUiData = quick.VerifySaveDataPriceCalculationTabStandardShapesCustomerSide("Standard Shapes",
				"Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007", "Direct Entry", "1.2",
				"0.9848");

		Thread.sleep(1500);
		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabStandardShapes(priceCalculationUiData);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

		

	}

	@Test(priority = 111, groups = "group3")
	public void PT_C_16StandardShapesSalesForUpdate() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<>();
		 
	    String partnumber = faker.number().digits(2) + "-"
	            + faker.number().digits(2) + "-"
	            + faker.number().digits(2);

	    String partDescription = faker.name().firstName()
	            + faker.number().digits(3);

	    // =====================================================
	    // STEP 1 → Navigate to Part Master
	    // =====================================================
	    Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(400);
	    dashboard.VerifyClickingMasterOptions("Part Master");

	    // =====================================================
	    // STEP 2 → CREATE PART (SALES SIDE)
	    // =====================================================
	    quick.EnterValueInSalessSideAndSave(
	            partnumber,
	            partDescription,
	            "Hourly",
	            DataProp.getProperty("CompanyNamePartMaster"),
	            "Sales",
	            DataProp.getProperty("CustomerNamePartMaster"),
	            DataProp.getProperty("ProductCategoryNamePartMaster"),
	            DataProp.getProperty("ProductModelName&No.PartMaster"),
	            DataProp.getProperty("SpecialProductCategoryPartMaster")
	    );

	    storePartMasterInfo.put("Part Number", partnumber);
	    storePartMasterInfo.put("Part Description", partDescription);
	    storePartMasterInfo.put("Part Uom", "Hourly");
	    storePartMasterInfo.put("Company Name",
	            DataProp.getProperty("CompanyNamePartMaster"));
	    storePartMasterInfo.put("Customer Name",
	            DataProp.getProperty("CustomerNamePartMaster"));
	    storePartMasterInfo.put("Product Category Name",
	            DataProp.getProperty("ProductCategoryNamePartMaster"));
	    storePartMasterInfo.put("Product Model Name & No.",
	            DataProp.getProperty("ProductModelName&No.PartMaster"));
	    storePartMasterInfo.put("Special Product Category",
	            DataProp.getProperty("SpecialProductCategoryPartMaster"));

	    // =====================================================
	    // STEP 3 → VERIFY PART SAVED (SALES)
	    // =====================================================
	    quick.VerifyPartNumberAreSavedOrNotWithSalesSide(
	            "Part No.", partnumber, partDescription);
	    Thread.sleep(1000);

	    // =====================================================
	    // STEP 4 → PART ATTRIBUTE (FETCH + SAVE)
	    // =====================================================
	    Map<String, String> partAttributeSaved =
	            quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
	    Thread.sleep(1500);

	    // =====================================================
	    // STEP 5 → PRICE CALCULATION SAVE (CUSTOMER SIDE)
	    // =====================================================
	    HashMap<String, String> priceCalculationUiData = quick.VerifySaveDataPriceCalculationTabStandardShapesCustomerSide("Standard Shapes",
				"Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007", "Direct Entry", "1.2",
				"0.9848");



	    // =====================================================
	    // STEP 6 → BOP ENTRY
	    // =====================================================
	    quick.clickAddBopAndVerifyTable();
	    Thread.sleep(1500);

	    // =====================================================
	    // STEP 7 → TOOLING ENTRY
	    // =====================================================
	    quick.EnterToolingCost(partnumber);
	    Thread.sleep(1000);

	    // =====================================================
	    // STEP 8 → UPDATE PART ATTRIBUTES (CUSTOMER SIDE)
	    // =====================================================
	    Map<String, String> partAttributeUpdated =
	            quick.verifyUpdateDataAndSaveInPartAttributesCustomerSide("Plastics");

	    // =====================================================
	    // STEP 9 → UPDATE PRICE CALCULATION (NUMERIC ONLY)
	    // =====================================================
	    HashMap<String, String> priceCalculationUpdated =
	            quick.UpdatePriceCalculationTabStandardShapes();

	    // MERGE SAVE + UPDATE (VERY IMPORTANT)
	    priceCalculationUiData.putAll(priceCalculationUpdated);


	    // =====================================================
	    // STEP 10 → BOP UPDATE
	    // =====================================================
	    HashMap<String, String> bopUpdatedData =
	            quick.clickAddBopAndVerifyTableForUpdate();
	    Thread.sleep(1500);

	    // =====================================================
	    // STEP 11 → TOOLING UPDATE
	    // =====================================================
	    HashMap<String, String> toolingUpdatedData =
	            quick.updateExistingToolingCostValues();

	    // =====================================================
	    // STEP 12 → GO BACK & RELOAD PART MASTER
	    // =====================================================
	    dashboard.clickingDashboard("home");
	    Thread.sleep(2000);

	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(400);
	    dashboard.VerifyClickingMasterOptions("Part Master");
	    Thread.sleep(2500);

	    // =====================================================
	    // STEP 13 → VERIFY PART AGAIN (SALES)
	    // =====================================================
	    Map<String, String> verifiedPartData =
	            quick.VerifyPartNumberAreSavedOrNotWithSalesSide(
	                    "Part No.", partnumber, partDescription);

	    // =====================================================
	    // STEP 14 → MERGE ATTRIBUTE DATA FOR VALIDATION
	    // =====================================================
	    Map<String, String> combinedAttributeData = new HashMap<>();
	    combinedAttributeData.putAll(verifiedPartData);
	    combinedAttributeData.putAll(partAttributeUpdated);

	    quick.verifyPartAttributeDataHasBeenSaveOrNotCustomerSide(
	            combinedAttributeData);

	    // =====================================================
	    // STEP 15 → VALIDATE PRICE CALCULATION (MERGED MAP)
	    // =====================================================
	    quick.validatePriceCalculationTabStandardShapes(priceCalculationUiData);
	    
	    
	 // ************* BOP VALIDATION *************
	 		 quick.validateBopTable(bopUpdatedData);
	  
	 		// ************* TOOLING VALIDATION *************
	 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
	  
	  
	
	}

	

	@Test(priority = 112, groups = "group3")
	public void PT_C_07ExportingAllTheTemplates() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInSalessSideAndSave(
	            partnumber,
	            partDescription,
	            "Hourly",
	            DataProp.getProperty("CompanyNamePartMaster"),
	            "Sales",
	            DataProp.getProperty("CustomerNamePartMaster"),
	            DataProp.getProperty("ProductCategoryNamePartMaster"),
	            DataProp.getProperty("ProductModelName&No.PartMaster"),
	            DataProp.getProperty("SpecialProductCategoryPartMaster")
	    );

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));
          Thread.sleep(2000);
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(2000);
		quick.VerifyThreeBarFunctionality("Standard Shapes", partnumber);

	}

	@Test(priority = 113, groups = "group3")
	public void PT_C_07CopyCostingForCustomer() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		 
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
 
		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
  
		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		dashboard.VerifyClickingMasterOptions("Bill of Material");
 
		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");
 
		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);
 
		quick.importBOMExcelFile();
		Thread.sleep(6000);
 
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
 
		dashboard.selectMenuFormDashBoard("Master Data");
 
		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);
 
		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);
 
		// ************* PRICE CALCULATION (WiringHarness) *************
		HashMap<String, String> priceCalculationUiData = quick.VerifySaveDataPriceCalculationTabStandardShapesCustomerSide("Standard Shapes",
				"Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007", "Direct Entry", "1.2",
				"0.9848");

 
		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
 
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
 
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);
 
		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);
 
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
 
		dashboard.selectMenuFormDashBoard("Master Data");
 
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);
 
		LoggerUtil.info("Validating For CopyCasting Value");
 
		// ************* VERIFY PART SAVED *************
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1, partDescription1);
		
		
		quick.validateCopiedPartAttributes(partattributeuidata);
 
		quick.validatePriceCalculationTabStandardShapes(priceCalculationUiData);
		quick.validateBopTable(bopMap);
 
		quick.validateBopInHouseTable(BOPInhouseData);
 
	
 
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();	
		
 
	}

	@Test(priority = 114, groups = "group3")
	public void PT_C_02StandardshapesProcurementSaveAndValidate() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		 
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
 
		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
 
		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");
 
		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
 
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);
 
		HashMap<String, String> priceCalculationUiData = quick
				.VerifySaveDataPriceCalculationTabStandardShapesSupplierSide("Standard Shapes",
						"Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007", "Direct Entry", "1.2",
						"0.9848");
 
		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
 
		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);
 
		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
 
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);
 
		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);
 
		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);
 
		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);
 
		quick.validatePriceCalculationTabStandardShapes(priceCalculationUiData);
 
		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);
 
		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);
 
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
	}
	
	
	@Test(priority=115,groups="group3")
	public void PT_C_05StandardShapesProcurementForUpdate() throws InterruptedException {
		
		HashMap<String, String> storePartMasterInfo = new HashMap<>();
		 
	    String partnumber = faker.number().digits(2) + "-"
	            + faker.number().digits(2) + "-"
	            + faker.number().digits(2);

	    String partDescription = faker.name().firstName() + faker.number().digits(3);
	    Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(399);
	    dashboard.VerifyClickingMasterOptions("Part Master");

	    // ************* CREATE PART *************
	    quick.EnterValueInBothTypeSideAndSave(
	            partnumber,
	            partDescription,
	            "Hourly",
	            DataProp.getProperty("CompanyNamePartMaster"),
	            "Procurement",
	            DataProp.getProperty("SupplierNamePartMaster"),
	            DataProp.getProperty("CustomerNamePartMaster"),
	            "rishi",
	            DataProp.getProperty("ProductModelName&No.PartMaster"),
	            "ACCESSORIES"
	    );

	    storePartMasterInfo.put("Part Number", partnumber);
	    storePartMasterInfo.put("Part Description", partDescription);
	    storePartMasterInfo.put("Part Uom", "Hourly");
	    storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
	    storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
	    storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
	    storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
	    storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
	    storePartMasterInfo.put("Special Product Category",
	            DataProp.getProperty("SpecialProductCategoryPartMaster"));

	    // ************* VERIFY PART SAVE *************
	    quick.VerifyPartNumberAreSavedOrNotWithSupplierSide(
	            "Part No.", partnumber, partDescription);
	    Thread.sleep(1000);

	    // ************* PART ATTRIBUTE (SAVE) *************
	    Map<String, String> partattributeuidata =
	            quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
	    Thread.sleep(1500);

	    // ************* PRICE CALCULATION SAVE (CAPTURE MAP) *************
	    HashMap<String, String> priceCalculationUiData = quick
				.VerifySaveDataPriceCalculationTabStandardShapesSupplierSide("Standard Shapes",
						"Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007", "Direct Entry", "1.2",
						"0.9848");
	    // ************* BOP ENTRY *************
	    quick.clickAddBopAndVerifyTable();
	    Thread.sleep(1500);

	    // ************* TOOLING ENTRY *************
	    quick.EnterToolingCost(partnumber);
	    Thread.sleep(1000);

	    // =====================================================
	    // **************** UPDATE FLOW ****************
	    // =====================================================

	    // PART ATTRIBUTE UPDATE
	    Map<String, String> partattributeUpdated =
	            quick.verifyUpdateDataInPartAttributes("Plastics");

	    // PRICE CALCULATION UPDATE (NUMERIC ONLY)
	    HashMap<String, String> priceCalculationUpdated =
	            quick.UpdatePriceCalculationTabStandardShapes();

	    // MERGE SAVE + UPDATE (VERY IMPORTANT)
	    priceCalculationUiData.putAll(priceCalculationUpdated);

	    // BOP UPDATE
	    HashMap<String, String> bopUpdatedData =
	            quick.clickAddBopAndVerifyTableForUpdate();
	    Thread.sleep(1500);

	    // TOOLING UPDATE
	    HashMap<String, String> toolingUpdatedData =
	            quick.updateExistingToolingCostValues();

	    // ************* BACK TO HOME → RELOAD PART MASTER *************
	    dashboard.clickingDashboard("home");
	    Thread.sleep(2000);

	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(399);
	    dashboard.VerifyClickingMasterOptions("Part Master");
	    Thread.sleep(2500);

	    // ************* VERIFY PART AGAIN *************
	    Map<String, String> verifiedPartData =
	            quick.VerifyPartNumberAreSavedOrNotWithSupplierSide(
	                    "Part No.", partnumber, partDescription);

	    // ************* MERGE ATTRIBUTE DATA FOR VALIDATION *************
	    Map<String, String> combinedData = new HashMap<>();
	    combinedData.putAll(verifiedPartData);
	    combinedData.putAll(partattributeUpdated);

	    quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEndForUpdate(combinedData);

	    // ************* PRICE CALCULATION VALIDATION (MERGED MAP) *************
	    quick.validatePriceCalculationTabStandardShapes(priceCalculationUiData);

	  
	    quick.validateBopTable(bopUpdatedData);
		  
 		// ************* TOOLING VALIDATION *************
 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
	

		
		
		
	}
	
	
	
	
	
	

	@Test(priority=116,groups="group3")
	public void PT_C_08StandardShapesProcurementCopyCasting() throws InterruptedException {
		
		
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
 
		String partDescription = faker.name().firstName() + faker.number().digits(3);
 
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
 
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
 
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
 
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));
 
		dashboard.VerifyClickingMasterOptions("Bill of Material");
 
		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");
 
		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);
 
		quick.importBOMExcelFile();
		Thread.sleep(6000);
 
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
 
		dashboard.selectMenuFormDashBoard("Master Data");
 
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);
 
		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);
 
		
		 // ************* PRICE CALCULATION SAVE (CAPTURE MAP) *************
	    HashMap<String, String> priceCalculationUiData = quick
				.VerifySaveDataPriceCalculationTabStandardShapesSupplierSide("Standard Shapes",
						"Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007", "Direct Entry", "1.2",
						"0.9848");
 
		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);
 
		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);
 
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
 
		dashboard.selectMenuFormDashBoard("Master Data");
 
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);
 
		LoggerUtil.info("Validating For CopyCasting Value");
 
		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);
 
		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);
 
		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);
 
		// ************* PRICE CALC VALIDATION *************
		 quick.validatePriceCalculationTabStandardShapes(priceCalculationUiData);
 
 
		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopMap);
		// *********************Bop Inhouse********************
		quick.validateBopInHouseTable(BOPInhouseData);
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}


	////////////////////////////////////////////////////////// ForgingProcurement////////////////////////////////////////////////////

	@Test(priority = 117, groups = "group3")
	public void PT_C_24ModuleAccessValidationForgingProcurement() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FORGING) *************
		HashMap<String, String> priceCalculationUi = quick.SavePriceCalculationTabForgingProcurement("Forging", "Sheet", "Ferrous Metals",
				"Stainless Steel", "2021-2022", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabForging(priceCalculationUi);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
	}

	
	
	
	
	@Test(priority = 118, groups = "group3")
	public void PT_C_27UpdatingForgingPartForProcurment() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FORGING) *************
		HashMap<String, String> priceCalci =	quick.SavePriceCalculationTabForgingProcurement("Forging", "Sheet", "Ferrous Metals", "Stainless Steel", "2021-2022",
				"Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ***********************Insert new Data //

		LoggerUtil.info("User Starts To Update Data");

		HashMap<String, String> map = quick.VerifyUpdatePriceCalculationValueForForging();
		priceCalci.putAll(map);

		HashMap<String, String> bopUpdatedData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolingUpdatedData = quick.updateExistingToolingCostValues();

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		LoggerUtil.info("Validating For Updated Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabForging(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopUpdatedData);
		  
 		// ************* TOOLING VALIDATION *************
 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
	}
	
	
	
	
	
	
	
	
	
	

	@Test(priority = 119, groups = "group3")
	public void PT_C_29ExportingAllTheTemplates() throws InterruptedException {

		new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionalityForging("Forging", partnumber);

	}

	@Test(priority = 120, groups = "group3")
	public void PT_C_30CopyCostingProcurnmentForging() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FORGING) *************
		HashMap<String, String> priceCalci =quick.SavePriceCalculationTabForgingProcurement("Forging", "Sheet", "Ferrous Metals",
				"Stainless Steel", "2021-2022", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		Thread.sleep(150);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabForging(priceCalci);
		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	@Test(priority = 121, groups = "group3")
	public void PT_C_34SaveDataForgingSales() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FORGING) *************
		HashMap<String, String> priceCalci = quick.SavePriceCalculationTabForgingCustomerSide("Forging", "Sheet",
				"Ferrous Metals", "Stainless Steel", "2021-2022", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		Thread.sleep(150);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabForging(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	@Test(priority = 122, groups = "group3")
	public void PT_C_38UpdatingThePartForgingSales() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FORGING) *************
	HashMap<String,String> priceCalci= 	quick.SavePriceCalculationTabForgingCustomerSide("Forging", "Sheet", "Ferrous Metals", "Stainless Steel",
				"2021-2022", "Jan", "CRCA-007");

	
		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		
		

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART Updated *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		Map<String, String> partattributeupdatedData = quick
				.verifyUpdateDataAndSaveInPartAttributesCustomerSide("Plastics");

		HashMap<String, String> map = quick.VerifyUpdatePriceCalculationValueForForging();
		priceCalci.putAll(map);

		HashMap<String, String> bopUpdatedData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolingUpdatedData = quick.updateExistingToolingCostValues();

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);

		quick.validateUpdatedPartAttributesCustomerSide(partattributeupdatedData);

		quick.validatePriceCalculationTabForging(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopUpdatedData);
		  
 		// ************* TOOLING VALIDATION *************
 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);

	}

	@Test(priority = 123, groups = "group3")
	public void PT_C_40ExportingAllTheTemplatesForgingSales() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		Thread.sleep(3000);
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionalityForging("Forging", partnumber);

	}

	@Test(priority = 124, groups = "group3")
	public void PT_C_41CopyCostingForgingSalesSide() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FORGING) *************
		HashMap<String,String> priceCalci= 	quick.SavePriceCalculationTabForgingCustomerSide("Forging", "Sheet", "Ferrous Metals", "Stainless Steel",
				"2021-2022", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		Thread.sleep(1500);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);

		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* BACK TO HOME → reload Part Master *************

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1,
				partDescription1);
		Thread.sleep(1000);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.verifyPartAttributeDataHasBeenSaveOrNotCustomerSide(partattributeuidata);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabForging(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	///////////////////////////// FerousCastingProcurnmentSide
	///////////////////////////// ////////////////////////////////////////////

	@Test(priority = 125, groups = "group3")
	public void PT_C_45ModuleAccessValidationFerrousProcurement() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationFerrousCasetingProcurmentSide(
				"Ferrous Casting", "Steel", "2025-2026", "Apr", "Ferrous Casting");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
			HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationFerrousCasting(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
		
		
		
	}

	@Test(priority = 126, groups = "group3")
	public void PT_C_27UpdatingFerrousCastingPartForProcurment() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FerrousCasting) *************
		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationFerrousCasetingProcurmentSide(
				"Ferrous Casting", "Steel", "2025-2026", "Apr", "Ferrous Casting");


		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ***********************Insert new Data //

		LoggerUtil.info("User Starts To Update Data");

		Map<String, String> partattributeUpdated = quick.verifyUpdateDataInPartAttributes("Plastics");

		HashMap<String, String> map =
			    quick.updatePriceCalculationFerrousCasting();

			

			priceCalci.putAll(map);

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolData = quick.updateExistingToolingCostValues();

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		LoggerUtil.info("Validating For Updated Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeUpdated);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEndForUpdate(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationFerrousCasting(priceCalci);


		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyUpdatedToolingCostValues(toolData);

	}

	@Test(priority = 127, groups = "group3")
	public void PT_C_29ExportingAllTheTemplatesForFerrousCasting() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionalityFerrousCasting("Ferrous Casting", partnumber);

	}

	@Test(priority = 128, groups = "group3")
	public void PT_C_30CopyCostingProcurnmentFerrousCasting() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);
		
		// ************* PRICE CALCULATION (FerrousCasting) *************
		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationFerrousCasetingProcurmentSide(
				"Ferrous Casting", "Steel", "2025-2026", "Apr", "Ferrous Casting");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationFerrousCasting(priceCalci);
		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopMap);
		// *********************Bop Inhouse********************
		quick.validateBopInHouseTable(BOPInhouseData);
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

////////////////////////////////////////////////////////////////////////////////////////FerousCastingSalesSide////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(priority = 129, groups = "group3")
	public void PT_C_57ModuleAccessValidationFerrousSales() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationFerrousCastingCustomerSide(
				"Ferrous Casting", "Steel", "2025-2026", "Apr", "Ferrous Casting");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationFerrousCasting(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
	}

	@Test(priority = 130, groups = "group3")
	public void PT_C_60UpdatingFerrousCastingPartForSales() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationFerrousCastingCustomerSide(
				"Ferrous Casting", "Steel", "2025-2026", "Apr", "Ferrous Casting");

		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ***********************Insert new Data
		// //////////////////////////////////////////////////////

		LoggerUtil.info("User Starts To Update Data");

		Map<String, String> partattributeUpdated = quick
				.verifyFetchDataAndWriteInPartAttributesCustomerSideForUpdate("Plastics");

		HashMap<String, String> map =
			    quick.updatePriceCalculationFerrousCasting();

			// 🔥 FORCE correct dropdown expected values
			
			priceCalci.putAll(map);

		
		

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolData = quick.updateExistingToolingCostValues();
		
		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		////////////////////////////////// LoggerUtil.info("Validating For Updated
		////////////////////////////////// Value");/////////////////////////////

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);
		Thread.sleep(1000);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeUpdated);
		combinedData.putAll(verifiedPartData);

		quick.ValidatePartAttributeDataSucessFullyUpdatedOrNot(partattributeUpdated);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationFerrousCasting(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyUpdatedToolingCostValues(toolData);

	}

	@Test(priority = 131, groups = "group3")
	public void PT_C_62ExportingAllTheTemplates() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionalityFerrousCasting("Ferrous Casting", partnumber);

	}

	@Test(priority = 132, groups = "group3")
	public void PT_C_63CopyCostingForFerrousSalesSide() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FerrousCasting) *************
		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationFerrousCastingCustomerSide(
				"Ferrous Casting", "Steel", "2025-2026", "Apr", "Ferrous Casting");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1, partDescription1);
		quick.validateCopiedPartAttributes(partattributeuidata);
		
		quick.validatePriceCalculationFerrousCasting(priceCalci);

		quick.validateBopTable(bopMap);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + partnumber);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	
	
	
	
	
	@Test(priority = 133, groups = "group3")
	public void PT_C_68NonFerrousCastingProcurement() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationNONFerrousCaseting(
				"Non Ferrous Casting", "Non-Ferrous Casting", "Aluminum", "2023-2024", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		quick.validatePriceCalculationNonFerrousCasting(priceCalci);
		
		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	@Test(priority = 134, groups = "group3")
	public void PT_C_71NonFerrousCastingProcurmentUpdates() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationNONFerrousCaseting(
				"Non Ferrous Casting", "Non-Ferrous Casting", "Aluminum", "2023-2024", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		////// *** Updating All Saved Data

		Map<String, String> partattributeUpdated = quick.verifyUpdateDataInPartAttributes("Plastics");

		Map<String, String> priceCalculationUpdated = quick.updatePriceCalculationNonFerrousCasting();
		
		priceCalci.putAll(priceCalculationUpdated);

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolData = quick.updateExistingToolingCostValues();

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(verifiedPartData);
		combinedData.putAll(partattributeUpdated);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEndForUpdate(combinedData);

		quick.validatePriceCalculationNonFerrousCasting(priceCalci);
		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyUpdatedToolingCostValues(toolData);

	}

	@Test(priority = 135, groups = "group3")
	public void PT_C_29ExportingAllTheTemplatesWithProcurnment() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionalityFerrousCasting("Non Ferrous Casting", partnumber);

	}

	@Test(priority = 136, groups = "group3")
	public void PT_C_74CopyCostingProcurnmentNonFerrousCasting() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (Non FerrousCasting) *************
		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationNONFerrousCaseting(
				"Non Ferrous Casting", "Non-Ferrous Casting", "Aluminum", "2023-2024", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationNonFerrousCasting(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopMap);
		// *********************Bop Inhouse********************
		quick.validateBopInHouseTable(BOPInhouseData);
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

///////////////////////////////////////////////////////Non Ferrous Casting Sales /////////////////////////////////////////////////////////////////////////	

	@Test(priority = 137, groups = "group3")
	public void PT_C_57ModuleAccessValidationNonFerrousCastingSales() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationNONFerrousCasetingSalesSide(
				"Non Ferrous Casting", "Non-Ferrous Casting", "Aluminum", "2023-2024", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationNONFerrousCasting(priceCalci);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
	}

	@Test(priority = 138, groups = "group3")
	public void PT_C_60UpdatingNonFerrousCastingPartForSales() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationNONFerrousCasetingSalesSide(
				"Non Ferrous Casting", "Non-Ferrous Casting", "Aluminum", "2023-2024", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
 
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		////// *** Updating All Saved Data

		LoggerUtil.info("User Starts To Update Data");

		Map<String, String> partattributeUpdated = quick
				.verifyFetchDataAndWriteInPartAttributesCustomerSideForUpdate("Plastics");

		Map<String, String> priceCalculationUpdated = quick.updateNonFerrousCastingValuesPriceCalculation();
		priceCalci.putAll(priceCalculationUpdated);

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolData = quick.updateExistingToolingCostValues();

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		LoggerUtil.info("=======================================================================================");

		LoggerUtil.info("Validate Updated Value has been saved or not");

		LoggerUtil.info("=======================================================================================");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);
		Thread.sleep(1000);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeUpdated);
		combinedData.putAll(verifiedPartData);

		quick.ValidatePartAttributeDataSucessFullyUpdatedOrNot(partattributeUpdated);

		quick.validatePriceCalculationNONFerrousCasting(priceCalci);
		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyUpdatedToolingCostValues(toolData);

	}

	@Test(priority = 139, groups = "group3")
	public void PT_C_62ExportingAllTheTemplatesNonSale() throws InterruptedException {
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", "ACCESSORIES");

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionalityFerrousCasting("Non Ferrous Casting", partnumber);

	}

	@Test(priority = 140, groups = "group3")
	public void PT_C_85CopyCostingForNonFerrousSalesSide() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (FerrousCasting) *************
		HashMap<String, String> priceCalci = quick.VeirfySaveDataPriceCalCulalationNONFerrousCasetingSalesSide(
				"Non Ferrous Casting", "Non-Ferrous Casting", "Aluminum", "2023-2024", "Jan", "CRCA-007");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1, partDescription1);
		quick.validateCopiedPartAttributes(partattributeuidata);

		quick.validatePriceCalculationNONFerrousCasting(priceCalci);

		quick.validateBopTable(bopMap);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + partnumber);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}
	
	
	
	@Test(priority = 141, groups = "group3")
	public void PT_C_89WirringHarnessProcurementSave() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		Map<String, String> priceCalciData = quick
				.SavePriceCalCulationForWiringHarnessProcurmentSide("Wiring Harness Assembly Cost Estimator");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		quick.ValidateWiringHarnesPriceCalculation(priceCalciData);
		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	@Test(priority = 142, groups = "group3")
	public void PT_C_93UpdatingThePartWiringHarnessProcurnmentSide() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		quick.SavePriceCalCulationForWiringHarnessProcurmentSide("Wiring Harness Assembly Cost Estimator");

		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		////// *** Updating All Saved Data

		Map<String, String> partattributeUpdated = quick.verifyUpdateDataInPartAttributes("Plastics");

		Map<String, String> priceCalculationUpdated = quick.UpdateWiringHarnessPriceCalculation();

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolData = quick.updateExistingToolingCostValues();

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(verifiedPartData);
		combinedData.putAll(partattributeUpdated);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEndForUpdate(combinedData);

		quick.ValidateWiringHarnesPriceCalculation(priceCalculationUpdated);
		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		 quick.VerifyUpdatedToolingCostValues(toolData);

	}
	
	@Test(priority = 143, groups = "group3")
	public void PT_C_95ExportingAllTheTemplatesForSupplier() throws InterruptedException {

		

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionality("Wiring Harness Assembly Cost Estimator", partnumber);

	}
	
	
	

	@Test(priority = 144, groups = "group3")
	public void PT_C_96CopyCostingWiringHarnessProcurnmentSide() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);
 
		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION ( WiringHarnessProcurnment Side)
		// *************
		Map<String, String> priceCalciData = quick
				.SavePriceCalCulationForWiringHarnessProcurmentSide("Wiring Harness Assembly Cost Estimator");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.ValidateWiringHarnesPriceCalculation(priceCalciData);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopMap);
		// *********************Bop Inhouse********************
		quick.validateBopInHouseTable(BOPInhouseData);
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	@Test(priority = 145, groups = "group3")
	public void PT_C_100WiringHarnessSalesSaveAndValidate() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> priceCalcidata = quick
				.SavePriceCalCulationForWiringHarnessCustomerSide("Wiring Harness Assembly Cost Estimator");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		
		

		// ************* PRICE CALC VALIDATION *************
		quick.ValidateWiringHarnesPriceCalculation(priceCalcidata);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	@Test(priority = 146, groups = "group3")
	public void PT_C_104WirringHarnessSalesUpdatingThePart() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));
		
		
		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		quick.SavePriceCalCulationForWiringHarnessCustomerSide("Wiring Harness Assembly Cost Estimator");

		// ************* BOP ENTRY *************
		quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		////// *** Updating All Saved Data

		Map<String, String> partattributeUpdated = quick.verifyUpdateDataAndSaveInPartAttributesCustomerSide("Plastics");

		Map<String, String> priceCalculationUpdated = quick.UpdateWiringHarnessPriceCalculation();

		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTableForUpdate();
		Thread.sleep(1500);

		HashMap<String, String> toolData = quick.updateExistingToolingCostValues();

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(verifiedPartData);
		combinedData.putAll(partattributeUpdated);

		quick.verifyPartAttributeDataHasBeenSaveOrNotCustomerSide(combinedData);


		quick.ValidateWiringHarnesPriceCalculation(priceCalculationUpdated);
		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);

		// ************* TOOLING VALIDATION *************
	
		 
		 
		 quick.VerifyUpdatedToolingCostValues(toolData);
			

	}
	
	
	
	
	@Test(priority = 147, groups = "group3")
	public void PT_C_106ExportingAllTheTemplatesForCustomer() throws InterruptedException {

		

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionality("Wiring Harness Assembly Cost Estimator", partnumber);

	}
	
	
	
	
	
	
	
	@Test(priority = 148, groups = "group3")
	public void PT_C_107WirringHarnessSalesCopyCostingSales() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (WiringHarness) *************
		HashMap<String, String> PriceCalciData = quick
				.SavePriceCalCulationForWiringHarnessCustomerSide("Wiring Harness Assembly Cost Estimator");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1, partDescription1);
		quick.validateCopiedPartAttributes(partattributeuidata);

		quick.ValidateWiringHarnesPriceCalculation(PriceCalciData);

		quick.validateBopTable(bopMap);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + partnumber);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}
	
	
	
	
	
	
	
	
	
	
	

	@Test(priority = 149, groups = "group3")
	public void PlasticInjectionModuleAccessValidationProcurementSide() throws InterruptedException {

		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabPlasticForProcurnment("Plastic Injection Moulding", "Metal-001");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		quick.validatePriceCalculationTabPlastic(expectedData);

		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

	}

	
	
	
	@Test(priority = 150, groups = "group3")
	public void PT_C_115PlasticInjectionProcurementForUpdate() throws InterruptedException {

	    HashMap<String, String> storePartMasterInfo = new HashMap<>();

	    String partnumber = faker.number().digits(2) + "-" 
	            + faker.number().digits(2) + "-" 
	            + faker.number().digits(2);

	    String partDescription = faker.name().firstName() + faker.number().digits(3);
	    Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(399);
	    dashboard.VerifyClickingMasterOptions("Part Master");

	    // ************* CREATE PART *************
	    quick.EnterValueInBothTypeSideAndSave(
	            partnumber,
	            partDescription,
	            "Hourly",
	            DataProp.getProperty("CompanyNamePartMaster"),
	            "Procurement",
	            DataProp.getProperty("SupplierNamePartMaster"),
	            DataProp.getProperty("CustomerNamePartMaster"),
	            "rishi",
	            DataProp.getProperty("ProductModelName&No.PartMaster"),
	            "ACCESSORIES"
	    );

	    storePartMasterInfo.put("Part Number", partnumber);
	    storePartMasterInfo.put("Part Description", partDescription);
	    storePartMasterInfo.put("Part Uom", "Hourly");
	    storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
	    storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
	    storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
	    storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
	    storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
	    storePartMasterInfo.put("Special Product Category",
	            DataProp.getProperty("SpecialProductCategoryPartMaster"));

	    // ************* VERIFY PART SAVE *************
	    quick.VerifyPartNumberAreSavedOrNotWithSupplierSide(
	            "Part No.", partnumber, partDescription);
	    Thread.sleep(1000);

	    // ************* PART ATTRIBUTE (SAVE) *************
	    Map<String, String> partattributeuidata =
	            quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
	    Thread.sleep(1500);

	    // ************* PRICE CALCULATION SAVE (CAPTURE MAP) *************
	    HashMap<String, String> priceCalculationSaved =
	            quick.SavePriceCalculationTabPlasticForProcurnment(
	                    "Plastic Injection Moulding", "Metal-001");

	    // ************* BOP ENTRY *************
	    quick.clickAddBopAndVerifyTable();
	    Thread.sleep(1500);

	    // ************* TOOLING ENTRY *************
	    quick.EnterToolingCost(partnumber);
	    Thread.sleep(1000);

	    // =====================================================
	    // **************** UPDATE FLOW ****************
	    // =====================================================

	    // PART ATTRIBUTE UPDATE
	    Map<String, String> partattributeUpdated =
	            quick.verifyUpdateDataInPartAttributes("Plastics");

	    // PRICE CALCULATION UPDATE (NUMERIC ONLY)
	    HashMap<String, String> priceCalculationUpdated =
	            quick.UpdatePriceCalculationTabPlastic();

	    // MERGE SAVE + UPDATE (VERY IMPORTANT)
	    priceCalculationSaved.putAll(priceCalculationUpdated);

	    // BOP UPDATE
	    HashMap<String, String> bopUpdatedData =
	            quick.clickAddBopAndVerifyTableForUpdate();
	    Thread.sleep(1500);

	    // TOOLING UPDATE
	    HashMap<String, String> toolingUpdatedData =
	            quick.updateExistingToolingCostValues();

	    // ************* BACK TO HOME → RELOAD PART MASTER *************
	    dashboard.clickingDashboard("home");
	    Thread.sleep(2000);

	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(399);
	    dashboard.VerifyClickingMasterOptions("Part Master");
	    Thread.sleep(2500);

	    // ************* VERIFY PART AGAIN *************
	    Map<String, String> verifiedPartData =
	            quick.VerifyPartNumberAreSavedOrNotWithSupplierSide(
	                    "Part No.", partnumber, partDescription);

	    // ************* MERGE ATTRIBUTE DATA FOR VALIDATION *************
	    Map<String, String> combinedData = new HashMap<>();
	    combinedData.putAll(verifiedPartData);
	    combinedData.putAll(partattributeUpdated);

	    quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEndForUpdate(combinedData);

	    // ************* PRICE CALCULATION VALIDATION (MERGED MAP) *************
	    quick.validatePriceCalculationTabPlastic(priceCalculationSaved);

	    quick.validateBopTable(bopUpdatedData);
		  
 		// ************* TOOLING VALIDATION *************
 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
	}

	
	
	
	
	@Test(priority = 151, groups = "group3")
	public void PT_C_117ExportingAllTheTemplatesForSupplier() throws InterruptedException {

		

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		 quick.EnterValueInBothTypeSideAndSave(
		            partnumber,
		            partDescription,
		            "Hourly",
		            DataProp.getProperty("CompanyNamePartMaster"),
		            "Procurement",
		            DataProp.getProperty("SupplierNamePartMaster"),
		            DataProp.getProperty("CustomerNamePartMaster"),
		            "rishi",
		            DataProp.getProperty("ProductModelName&No.PartMaster"),
		            "ACCESSORIES"
		    );
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionality("Plastic Injection Moulding", partnumber);

	}
	
	
	@Test(priority=152,groups="group3")
	public void PT_C_118PlasticInjectionProcurementCopyCosting() throws InterruptedException {
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION ( WiringHarnessProcurnment Side)
		// *************
		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabPlasticForProcurnment("Plastic Injection Moulding", "Metal-001");
		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		 quick.validatePriceCalculationTabPlastic(expectedData);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopMap);
		// *********************Bop Inhouse********************
		quick.validateBopInHouseTable(BOPInhouseData);
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();


	}
	
	
	@Test(priority=153,groups="group3")
	public void PT_C_122SavePlasticInjectionSales() throws InterruptedException {
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabPlasticForCustomer("Plastic Injection Moulding", "Metal-001");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		// ************* PRICE CALC VALIDATION *************
		 quick.validatePriceCalculationTabPlastic(expectedData);

		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
		
		
		
	}
	
	@Test(priority = 154, groups = "group3")
	public void PT_C_126UpdatePlasticInjectionSales() throws InterruptedException {

	    HashMap<String, String> storePartMasterInfo = new HashMap<>();

	    String partnumber = faker.number().digits(2) + "-"
	            + faker.number().digits(2) + "-"
	            + faker.number().digits(2);

	    String partDescription = faker.name().firstName()
	            + faker.number().digits(3);

	    // =====================================================
	    // STEP 1 → Navigate to Part Master
	    // =====================================================
	    Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
	    
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(400);
	    dashboard.VerifyClickingMasterOptions("Part Master");

	    // =====================================================
	    // STEP 2 → CREATE PART (SALES SIDE)
	    // =====================================================
	    quick.EnterValueInSalessSideAndSave(
	            partnumber,
	            partDescription,
	            "Hourly",
	            DataProp.getProperty("CompanyNamePartMaster"),
	            "Sales",
	            DataProp.getProperty("CustomerNamePartMaster"),
	            DataProp.getProperty("ProductCategoryNamePartMaster"),
	            DataProp.getProperty("ProductModelName&No.PartMaster"),
	            DataProp.getProperty("SpecialProductCategoryPartMaster")
	    );

	    storePartMasterInfo.put("Part Number", partnumber);
	    storePartMasterInfo.put("Part Description", partDescription);
	    storePartMasterInfo.put("Part Uom", "Hourly");
	    storePartMasterInfo.put("Company Name",
	            DataProp.getProperty("CompanyNamePartMaster"));
	    storePartMasterInfo.put("Customer Name",
	            DataProp.getProperty("CustomerNamePartMaster"));
	    storePartMasterInfo.put("Product Category Name",
	            DataProp.getProperty("ProductCategoryNamePartMaster"));
	    storePartMasterInfo.put("Product Model Name & No.",
	            DataProp.getProperty("ProductModelName&No.PartMaster"));
	    storePartMasterInfo.put("Special Product Category",
	            DataProp.getProperty("SpecialProductCategoryPartMaster"));

	    // =====================================================
	    // STEP 3 → VERIFY PART SAVED (SALES)
	    // =====================================================
	    quick.VerifyPartNumberAreSavedOrNotWithSalesSide(
	            "Part No.", partnumber, partDescription);
	    Thread.sleep(1000);

	    // =====================================================
	    // STEP 4 → PART ATTRIBUTE (FETCH + SAVE)
	    // =====================================================
	    Map<String, String> partAttributeSaved =
	            quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
	    Thread.sleep(1500);

	    // =====================================================
	    // STEP 5 → PRICE CALCULATION SAVE (CUSTOMER SIDE)
	    // =====================================================
	    HashMap<String, String> priceCalculationSaved =
	            quick.SavePriceCalculationTabPlasticForCustomer(
	                    "Plastic Injection Moulding",
	                    "Metal-001"
	            );

	    // =====================================================
	    // STEP 6 → BOP ENTRY
	    // =====================================================
	    quick.clickAddBopAndVerifyTable();
	    Thread.sleep(1500);

	    // =====================================================
	    // STEP 7 → TOOLING ENTRY
	    // =====================================================
	    quick.EnterToolingCost(partnumber);
	    Thread.sleep(1000);

	    // =====================================================
	    // STEP 8 → UPDATE PART ATTRIBUTES (CUSTOMER SIDE)
	    // =====================================================
	    Map<String, String> partAttributeUpdated =
	            quick.verifyUpdateDataAndSaveInPartAttributesCustomerSide("Plastics");

	    // =====================================================
	    // STEP 9 → UPDATE PRICE CALCULATION (NUMERIC ONLY)
	    // =====================================================
	    HashMap<String, String> priceCalculationUpdated =
	            quick.UpdatePriceCalculationTabPlastic();

	    // 🔴 VERY IMPORTANT → MERGE SAVE + UPDATE
	    priceCalculationSaved.putAll(priceCalculationUpdated);

	    // =====================================================
	    // STEP 10 → BOP UPDATE
	    // =====================================================
	    HashMap<String, String> bopUpdatedData =
	            quick.clickAddBopAndVerifyTableForUpdate();
	    Thread.sleep(1500);

	    // =====================================================
	    // STEP 11 → TOOLING UPDATE
	    // =====================================================
	    HashMap<String, String> toolingUpdatedData =
	            quick.updateExistingToolingCostValues();

	    // =====================================================
	    // STEP 12 → GO BACK & RELOAD PART MASTER
	    // =====================================================
	    dashboard.clickingDashboard("home");
	    Thread.sleep(2000);

	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(400);
	    dashboard.VerifyClickingMasterOptions("Part Master");
	    Thread.sleep(2500);

	    // =====================================================
	    // STEP 13 → VERIFY PART AGAIN (SALES)
	    // =====================================================
	    Map<String, String> verifiedPartData =
	            quick.VerifyPartNumberAreSavedOrNotWithSalesSide(
	                    "Part No.", partnumber, partDescription);

	    // =====================================================
	    // STEP 14 → MERGE ATTRIBUTE DATA FOR VALIDATION
	    // =====================================================
	    Map<String, String> combinedAttributeData = new HashMap<>();
	    combinedAttributeData.putAll(verifiedPartData);
	    combinedAttributeData.putAll(partAttributeUpdated);

	    quick.verifyPartAttributeDataHasBeenSaveOrNotCustomerSide(
	            combinedAttributeData);

	    // =====================================================
	    // STEP 15 → VALIDATE PRICE CALCULATION (MERGED MAP)
	    // =====================================================
	    quick.validatePriceCalculationTabPlastic(priceCalculationSaved);
	    
	    
	    quick.validateBopTable(bopUpdatedData);
		  
 		// ************* TOOLING VALIDATION *************
 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
	    

	   
	}
	
	
	@Test(priority = 155, groups = "group3")
	public void PT_C_117ExportingAllTheTemplatesPlasticsForCustomer() throws InterruptedException {

		

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		 quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
			Thread.sleep(1000);
		quick.VerifyThreeBarFunctionality("Plastic Injection Moulding", partnumber);

	}
	
	
	
	

	@Test(priority=156,groups="group3")
	public void PT_C_129PlasticInjectionSalesCopyCasting() throws InterruptedException {
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (WiringHarness) *************
		 HashMap<String, String> priceCalculationSaved =
		            quick.SavePriceCalculationTabPlasticForCustomer(
		                    "Plastic Injection Moulding",
		                    "Metal-001"
		            );

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1, partDescription1);
		quick.validateCopiedPartAttributes(partattributeuidata);

		 quick.validatePriceCalculationTabPlastic(priceCalculationSaved);

		quick.validateBopTable(bopMap);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + partnumber);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();	
		
		
		
		
	}
	
	@Test(priority=157,groups="group3")
	public void PT_C_134RubberMoldingProcurementSave() throws InterruptedException {
		
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"), "ACCESSORIES");

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabRubberMouldingForProcurnment("Rubber Moulding", "Rb001");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber, partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		quick.validatePriceCalculationTabRubberMoulding(expectedData);

		// ************* BOP VALIDATION *************
		 quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();

		
		
		
	}
	
	
	
	@Test(priority=158,groups="group3")
	public void PT_C_137RubberMoldingProcurementUpdatingThePart() throws InterruptedException {
		
		 HashMap<String, String> storePartMasterInfo = new HashMap<>();

		    String partnumber = faker.number().digits(2) + "-" 
		            + faker.number().digits(2) + "-" 
		            + faker.number().digits(2);

		    String partDescription = faker.name().firstName() + faker.number().digits(3);
		    Thread.sleep(2000);
			dashboard.clickingDashboard("home");
			Thread.sleep(2000);
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(399);
		    dashboard.VerifyClickingMasterOptions("Part Master");

		    // ************* CREATE PART *************
		    quick.EnterValueInBothTypeSideAndSave(
		            partnumber,
		            partDescription,
		            "Hourly",
		            DataProp.getProperty("CompanyNamePartMaster"),
		            "Procurement",
		            DataProp.getProperty("SupplierNamePartMaster"),
		            DataProp.getProperty("CustomerNamePartMaster"),
		            "rishi",
		            DataProp.getProperty("ProductModelName&No.PartMaster"),
		            "ACCESSORIES"
		    );

		    storePartMasterInfo.put("Part Number", partnumber);
		    storePartMasterInfo.put("Part Description", partDescription);
		    storePartMasterInfo.put("Part Uom", "Hourly");
		    storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		    storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		    storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		    storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		    storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		    storePartMasterInfo.put("Special Product Category",
		            DataProp.getProperty("SpecialProductCategoryPartMaster"));

		    // ************* VERIFY PART SAVE *************
		    quick.VerifyPartNumberAreSavedOrNotWithSupplierSide(
		            "Part No.", partnumber, partDescription);
		    Thread.sleep(1000);

		    // ************* PART ATTRIBUTE (SAVE) *************
		    Map<String, String> partattributeuidata =
		            quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		    Thread.sleep(1500);

		    // ************* PRICE CALCULATION SAVE (CAPTURE MAP) *************
		    HashMap<String, String> priceCalculationSaved =
		            quick.SavePriceCalculationTabRubberMouldingForProcurnment("Rubber Moulding", "Rb001");

		    // ************* BOP ENTRY *************
		    quick.clickAddBopAndVerifyTable();
		    Thread.sleep(1500);

		    // ************* TOOLING ENTRY *************
		    quick.EnterToolingCost(partnumber);
		    Thread.sleep(1000);

		    // =====================================================
		    // **************** UPDATE FLOW ****************
		    // =====================================================

		    // PART ATTRIBUTE UPDATE
		    Map<String, String> partattributeUpdated =
		            quick.verifyUpdateDataInPartAttributes("Plastics");

		    // PRICE CALCULATION UPDATE (NUMERIC ONLY)
		    HashMap<String, String> priceCalculationUpdated =
		            quick.UpdatePriceCalculationTabRubberMoulding();

		    // MERGE SAVE + UPDATE (VERY IMPORTANT)
		    priceCalculationSaved.putAll(priceCalculationUpdated);

		    // BOP UPDATE
		    HashMap<String, String> bopUpdatedData =
		            quick.clickAddBopAndVerifyTableForUpdate();
		    Thread.sleep(1500);

		    // TOOLING UPDATE
		    HashMap<String, String> toolingUpdatedData =
		            quick.updateExistingToolingCostValues();

		    // ************* BACK TO HOME → RELOAD PART MASTER *************
		    dashboard.clickingDashboard("home");
		    Thread.sleep(2000);

		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(399);
		    dashboard.VerifyClickingMasterOptions("Part Master");
		    Thread.sleep(2500);

		    // ************* VERIFY PART AGAIN *************
		    Map<String, String> verifiedPartData =
		            quick.VerifyPartNumberAreSavedOrNotWithSupplierSide(
		                    "Part No.", partnumber, partDescription);

		    // ************* MERGE ATTRIBUTE DATA FOR VALIDATION *************
		    Map<String, String> combinedData = new HashMap<>();
		    combinedData.putAll(verifiedPartData);
		    combinedData.putAll(partattributeUpdated);

		    quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEndForUpdate(combinedData);

		    // ************* PRICE CALCULATION VALIDATION (MERGED MAP) *************
		    quick.validatePriceCalculationTabRubberMoulding(priceCalculationSaved);

		  
	
		
			 quick.validateBopTable(bopUpdatedData);
			  
		 		// ************* TOOLING VALIDATION *************
		 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
		
		
		
		
		
	}
	
	
	@Test(priority = 159, groups = "group3")
	public void PT_C_117ExportingAllTheTemplatesForSupplierRubber() throws InterruptedException {

		

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		 quick.EnterValueInBothTypeSideAndSave(
		            partnumber,
		            partDescription,
		            "Hourly",
		            DataProp.getProperty("CompanyNamePartMaster"),
		            "Procurement",
		            DataProp.getProperty("SupplierNamePartMaster"),
		            DataProp.getProperty("CustomerNamePartMaster"),
		            "rishi",
		            DataProp.getProperty("ProductModelName&No.PartMaster"),
		            "ACCESSORIES"
		    );
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		quick.VerifyThreeBarFunctionality("Rubber Moulding", partnumber);

	}
	
	@Test(priority=160,groups="group3")
	public void PT_C_140RubberMoldingProcurementCopyCasting() throws InterruptedException {
		
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);

		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		quick.EnterValueInBothTypeSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInBothTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Procurement",
				DataProp.getProperty("SupplierNamePartMaster"), DataProp.getProperty("CustomerNamePartMaster"), "rishi",
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost-Procurement");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributes("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION ( WiringHarnessProcurnment Side)
		// *************
		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabRubberMouldingForProcurnment("Rubber Moulding", "Rb001");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);
		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);
		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForSupplier("Should Cost-Procurement", "Rishicustomer-Tbilisi",
				"0801-Celesta", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSupplierSide("Part No.",
				partnumber1, partDescription1);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyDataHasBeenSavedCorrectlyOrNotForSupplierEnd(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabRubberMoulding(expectedData);


		// ************* BOP VALIDATION *************
		quick.validateBopTable(bopMap);
		// *********************Bop Inhouse********************
		quick.validateBopInHouseTable(BOPInhouseData);
		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
		
	}
	
	@Test(priority=161,groups="group3")
	public void PT_C_145RubberMoldingSalesModuleAccessValidation() throws InterruptedException {
		
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);

		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabRubberMouldingForCustomer("Rubber Moulding", "Rb001");

		// ************* BOP ENTRY *************
		HashMap<String, String> BOPData = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		HashMap<String, String> toolData = quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		// ************* BACK TO HOME → reload Part Master *************
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(2500);

		// ************* VERIFY PART SAVED *************
		Map<String, String> verifiedPartData = quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber,
				partDescription);

		// ************* MERGE DATA FOR ATTRIBUTE VALIDATION *************
		Map<String, String> combinedData = new HashMap<>();
		combinedData.putAll(partattributeuidata);
		combinedData.putAll(verifiedPartData);

		quick.VeirfyPriceAttributeHasBeenSavedCorrectlyOrNotForCustomer(combinedData);

		// ************* PRICE CALC VALIDATION *************
		quick.validatePriceCalculationTabRubberMoulding(expectedData);


		// ************* BOP VALIDATION *************
		quick.validateBopTable(BOPData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + toolData);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();
		
		
		
		
		
		
	}
	
	@Test(priority=162,groups="group3")
	public void PT_C_148RubberMoldingUpdatingThePartForSales() throws InterruptedException {
		
		 HashMap<String, String> storePartMasterInfo = new HashMap<>();

		    String partnumber = faker.number().digits(2) + "-"
		            + faker.number().digits(2) + "-"
		            + faker.number().digits(2);

		    String partDescription = faker.name().firstName()
		            + faker.number().digits(3);

		    // =====================================================
		    // STEP 1 → Navigate to Part Master
		    // =====================================================
		    Thread.sleep(2000);
			dashboard.clickingDashboard("home");
			Thread.sleep(2000);
		    
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(400);
		    dashboard.VerifyClickingMasterOptions("Part Master");

		    // =====================================================
		    // STEP 2 → CREATE PART (SALES SIDE)
		    // =====================================================
		    quick.EnterValueInSalessSideAndSave(
		            partnumber,
		            partDescription,
		            "Hourly",
		            DataProp.getProperty("CompanyNamePartMaster"),
		            "Sales",
		            DataProp.getProperty("CustomerNamePartMaster"),
		            DataProp.getProperty("ProductCategoryNamePartMaster"),
		            DataProp.getProperty("ProductModelName&No.PartMaster"),
		            DataProp.getProperty("SpecialProductCategoryPartMaster")
		    );

		    storePartMasterInfo.put("Part Number", partnumber);
		    storePartMasterInfo.put("Part Description", partDescription);
		    storePartMasterInfo.put("Part Uom", "Hourly");
		    storePartMasterInfo.put("Company Name",
		            DataProp.getProperty("CompanyNamePartMaster"));
		    storePartMasterInfo.put("Customer Name",
		            DataProp.getProperty("CustomerNamePartMaster"));
		    storePartMasterInfo.put("Product Category Name",
		            DataProp.getProperty("ProductCategoryNamePartMaster"));
		    storePartMasterInfo.put("Product Model Name & No.",
		            DataProp.getProperty("ProductModelName&No.PartMaster"));
		    storePartMasterInfo.put("Special Product Category",
		            DataProp.getProperty("SpecialProductCategoryPartMaster"));

		    // =====================================================
		    // STEP 3 → VERIFY PART SAVED (SALES)
		    // =====================================================
		    quick.VerifyPartNumberAreSavedOrNotWithSalesSide(
		            "Part No.", partnumber, partDescription);
		    Thread.sleep(1000);

		    // =====================================================
		    // STEP 4 → PART ATTRIBUTE (FETCH + SAVE)
		    // =====================================================
		    Map<String, String> partAttributeSaved =
		            quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		    Thread.sleep(1500);

		    // =====================================================
		    // STEP 5 → PRICE CALCULATION SAVE (CUSTOMER SIDE)
		    // =====================================================
		    HashMap<String, String> priceCalculationSaved = quick
					.SavePriceCalculationTabRubberMouldingForCustomer("Rubber Moulding", "Rb001");


		    // =====================================================
		    // STEP 6 → BOP ENTRY
		    // =====================================================
		    quick.clickAddBopAndVerifyTable();
		    Thread.sleep(1500);

		    // =====================================================
		    // STEP 7 → TOOLING ENTRY
		    // =====================================================
		    quick.EnterToolingCost(partnumber);
		    Thread.sleep(1000);

		    // =====================================================
		    // STEP 8 → UPDATE PART ATTRIBUTES (CUSTOMER SIDE)
		    // =====================================================
		    Map<String, String> partAttributeUpdated =
		            quick.verifyUpdateDataAndSaveInPartAttributesCustomerSide("Plastics");

		    // =====================================================
		    // STEP 9 → UPDATE PRICE CALCULATION (NUMERIC ONLY)
		    // =====================================================
		    HashMap<String, String> priceCalculationUpdated =
		            quick.UpdatePriceCalculationTabRubberMoulding();

		    // MERGE SAVE + UPDATE (VERY IMPORTANT)
		    priceCalculationSaved.putAll(priceCalculationUpdated);


		    // =====================================================
		    // STEP 10 → BOP UPDATE
		    // =====================================================
		    HashMap<String, String> bopUpdatedData =
		            quick.clickAddBopAndVerifyTableForUpdate();
		    Thread.sleep(1500);

		    // =====================================================
		    // STEP 11 → TOOLING UPDATE
		    // =====================================================
		    HashMap<String, String> toolingUpdatedData =
		            quick.updateExistingToolingCostValues();

		    // =====================================================
		    // STEP 12 → GO BACK & RELOAD PART MASTER
		    // =====================================================
		    dashboard.clickingDashboard("home");
		    Thread.sleep(2000);

		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(400);
		    dashboard.VerifyClickingMasterOptions("Part Master");
		    Thread.sleep(2500);

		    // =====================================================
		    // STEP 13 → VERIFY PART AGAIN (SALES)
		    // =====================================================
		    Map<String, String> verifiedPartData =
		            quick.VerifyPartNumberAreSavedOrNotWithSalesSide(
		                    "Part No.", partnumber, partDescription);

		    // =====================================================
		    // STEP 14 → MERGE ATTRIBUTE DATA FOR VALIDATION
		    // =====================================================
		    Map<String, String> combinedAttributeData = new HashMap<>();
		    combinedAttributeData.putAll(verifiedPartData);
		    combinedAttributeData.putAll(partAttributeUpdated);

		    quick.verifyPartAttributeDataHasBeenSaveOrNotCustomerSide(
		            combinedAttributeData);

		    // =====================================================
		    // STEP 15 → VALIDATE PRICE CALCULATION (MERGED MAP)
		    // =====================================================
		    quick.validatePriceCalculationTabRubberMoulding(priceCalculationSaved);
		
		    
			 quick.validateBopTable(bopUpdatedData);
			  
		 		// ************* TOOLING VALIDATION *************
		 		 quick.VerifyUpdatedToolingCostValues(toolingUpdatedData);
		    
		
		
	}
	
	@Test(priority=163,groups="group3")
	public void PT_C_150RubberMoldingSalesForSalesExportAllTemplates() throws InterruptedException {
		
		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		 quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
			Thread.sleep(1000);
		quick.VerifyThreeBarFunctionality("Rubber Moulding", partnumber);
		
		
		
	}
	
	
	
	@Test(priority=164,groups="group3")
	public void PT_C_154CopyCostingRubberModulingSalesSide() throws InterruptedException {
		
		
		
		HashMap<String, String> storePartMasterInfo = new HashMap<String, String>();

		String partnumber = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);
		String partnumber1 = faker.number().digits(2) + "-" + faker.number().digits(2) + "-" + faker.number().digits(2);

		String partDescription = faker.name().firstName() + faker.number().digits(3);
		String partDescription1 = faker.name().firstName() + faker.number().digits(3);
	
		Thread.sleep(2000);
		dashboard.clickingDashboard("home");
		Thread.sleep(2000);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");

		// ************* CREATE PART *************
		quick.EnterValueInSalessSideAndSave(partnumber, partDescription, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		quick.EnterValueInsalesTypeSideAndSaveForCopyCosting(partnumber1, partDescription1, "Hourly",
				DataProp.getProperty("CompanyNamePartMaster"), "Sales", DataProp.getProperty("CustomerNamePartMaster"),
				DataProp.getProperty("ProductCategoryNamePartMaster"),
				DataProp.getProperty("ProductModelName&No.PartMaster"),
				DataProp.getProperty("SpecialProductCategoryPartMaster"));

		storePartMasterInfo.put("Part Number", partnumber);
		storePartMasterInfo.put("Part Description", partDescription);
		storePartMasterInfo.put("Part Uom", "Hourly");
		storePartMasterInfo.put("Company Name", DataProp.getProperty("CompanyNamePartMaster"));
		storePartMasterInfo.put("Supplier Name", DataProp.getProperty("SupplierNamePartMaster"));
		storePartMasterInfo.put("Customer Name", DataProp.getProperty("CustomerNamePartMaster"));
		storePartMasterInfo.put("Product Category Name", DataProp.getProperty("ProductCategoryNamePartMaster"));
		storePartMasterInfo.put("Product Model Name & No.", DataProp.getProperty("ProductModelName&No.PartMaster"));
		storePartMasterInfo.put("Special Product Category", DataProp.getProperty("SpecialProductCategoryPartMaster"));

		dashboard.VerifyClickingMasterOptions("Bill of Material");

		quick.VerifySelectingBopAndExportingFile("Should Cost–Sales");

		quick.fillBom(partnumber, partDescription, partnumber1, partDescription1);

		quick.importBOMExcelFile();
		Thread.sleep(6000);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3999);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		// -------- Verify Saved ----------
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber, partDescription);
		Thread.sleep(1000);
		// ************* PART ATTRIBUTE *************
		Map<String, String> partattributeuidata = quick.verifyFetchDataAndWriteInPartAttributesCustomerSide("Plastics");
		Thread.sleep(1500);

		// ************* PRICE CALCULATION (WiringHarness) *************
		HashMap<String, String> expectedData = quick
				.SavePriceCalculationTabRubberMouldingForCustomer("Rubber Moulding", "Rb001");

		// ************* BOP ENTRY *************
		HashMap<String, String> bopMap = quick.clickAddBopAndVerifyTable();
		Thread.sleep(1500);

		HashMap<String, String> BOPInhouseData = quick.VerifyEnterValueInBopForInHouse("Partno-002-Part Desc-2812",
				"2");
		Thread.sleep(1500);

		// ************* TOOLING ENTRY *************
		quick.EnterToolingCost(partnumber);
		Thread.sleep(1000);

		quick.clickingThreeBarAndCopyAllCostingForCustomer("Should Cost–Sales", "Rishicustomer - Tbilisi", partnumber1);

		dashboard.clickingDashboard("home");
		Thread.sleep(2000);

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(399);
		dashboard.VerifyClickingMasterOptions("Part Master");
		Thread.sleep(3000);

		LoggerUtil.info("Validating For CopyCasting Value");

		// ************* VERIFY PART SAVED *************
		quick.VerifyPartNumberAreSavedOrNotWithSalesSide("Part No.", partnumber1, partDescription1);
		
		
		quick.validateCopiedPartAttributes(partattributeuidata);

		quick.validatePriceCalculationTabRubberMoulding(expectedData);
		quick.validateBopTable(bopMap);

		quick.validateBopInHouseTable(BOPInhouseData);

		LoggerUtil.info("Tooling COST MAP FROM EnterToolingCost(): " + partnumber);

		// ************* TOOLING VALIDATION *************
		quick.VerifyToolingCostValidation();	
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
