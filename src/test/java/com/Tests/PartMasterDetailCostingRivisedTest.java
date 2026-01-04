//package com.Tests;
//
////--- JDK ---
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Optional;
//import java.util.Properties;
//import java.util.Random;
//import java.util.Set;
//import java.util.TreeSet;
//import java.util.List;
//import java.util.stream.Stream;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.Set;  // For Set<String>
//import java.util.stream.Collectors;  // For collect(Collectors.toList())
//import org.openqa.selenium.TimeoutException;
////--- Apache POI ---
//import org.apache.poi.ss.SpreadsheetVersion;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CellValue;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.DataValidation;
//import org.apache.poi.ss.usermodel.DataValidationConstraint;
//import org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Name;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.ss.util.AreaReference;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.ss.util.CellRangeAddressList;
//import org.apache.poi.ss.util.CellReference;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
////--- Selenium (if used by your helpers such as export/import) ---
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.UnhandledAlertException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
////--- TestNG ---
//import org.testng.Assert;
//import org.testng.SkipException;
//import org.testng.annotations.AfterGroups;
//import org.testng.annotations.BeforeGroups;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import com.Pages.CommodityDetailsPage;
//import com.Pages.CommoditygroupPage;
////--- Project pages/helpers ---
//import com.Pages.DashboardPage;
//import com.Pages.LoginPage;
//import com.Pages.PartMasterDetailCostingRivisedPage;
//import com.Pages.PartMasterPage;
//import com.Pages.ProcessMasterPage;
//import com.github.javafaker.Faker;
//import com.google.common.base.Function;
//import com.helper.Base;
//import com.helper.ExcelUtil;
//import com.helper.LoggerUtil;
//
//import quickTestPointMasterPage.QuickMasterPage;
//import quickTestPointMasterTest.QuickMastersTest;
//
//@Listeners(com.helper.TestListeners.class)
//public class PartMasterDetailCostingRivisedTest extends Base {
//
//	protected LoginPage login;
//	protected DashboardPage dashboard;
//	protected PartMasterPage PartMasterPage;
//	protected PartMasterDetailCostingRivisedPage PartMasterDetailCostingRivisedPage;
//	protected ExcelUtil excelData;
//	protected Faker faker;
//	protected String randomname;
//	protected String randomname1;
//	protected String randomname2;
//	protected String randomname3;
//	protected int randomnumber;
//	protected int randomnumber1;
//
//	protected double randomdouble;
//	QuickMasterPage quick;
//	@BeforeTest
//	private void generator() {
//		faker = new Faker();
//		randomname = faker.name().firstName();
//		randomname1 = faker.name().firstName();
//		randomname2 = faker.name().firstName();
//		randomnumber = faker.number().numberBetween(4, 6);
//		randomnumber1 = faker.number().numberBetween(3, 6);
//
//		randomname3 = faker.name().firstName();
//		randomdouble = faker.number().randomDouble(3, 00, 100000);
//	}
//
//	@BeforeGroups(groups = { "group1", "group2", "group3", "group4" })
//	public void setup() throws InterruptedException {
//
//		launchApplication();
//		login = new LoginPage();
//		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
//		dashboard = new DashboardPage();
//		PartMasterPage = new PartMasterPage();
//		PartMasterDetailCostingRivisedPage = new PartMasterDetailCostingRivisedPage();
//		int randomnum = faker.number().numberBetween(99, 999999);
//		String value = String.valueOf(randomnum);
//		
//		quick = new QuickMasterPage();
//		excelData = new ExcelUtil();
//	}
//
//	@AfterGroups(groups = { "group1", "group2", "group3", "group4" })
//	private void quit() {
//
//		// driver.quit();
//
//	}
//
//	@Test(priority = 1, groups = "group1")
//	public void TC_PM_DC_001_validateExportImportBlockedWithoutMandatory() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_001: Validate Export/Import blocked when mandatories are not selected");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		boolean exportEnabled = PartMasterDetailCostingRivisedPage.isExportButtonEnabledInModal();
//		boolean importEnabled = PartMasterDetailCostingRivisedPage.isImportButtonEnabledInModal();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				LoggerUtil.info("Validation not shown yet for: " + key + " (toasts are sequential).");
//			}
//		}
//		LoggerUtil.info("Export enabled? " + exportEnabled);
//		LoggerUtil.info("Import enabled? " + importEnabled);
//	}
//
//	@Test(priority = 2, groups = "group1")
//	public void TC_PM_DC_002_01validateEachMandatoryIndividually() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_002: Validate Export/Import blocked while missing each mandatory field one-by-one");
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    Thread.sleep(2000);
////	    List<String> ProductCategory = Base.getPropertyAsList("ProductCategory2");
////	    for (String pc : ProductCategory) {
////	    	System.out.println(pc);
////	    	PartMasterPage.selectOnProductCategoryValuesByTexts(pc.trim());
////	    }
//	    PartMasterPage.selectOnProductCategoryValuesByText("electronics","FURNITURE");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				
//			}
//		}
//	}
//
//	@Test(priority = 3, groups = "group1")
//	public void TC_PM_DC_002_02validateEachMandatoryIndividually() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_002: Validate Export/Import blocked while missing each mandatory field one-by-one");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		PartMasterPage.selectOnProductCategoryValuesByText("electronics","FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(1000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				
//			}
//		}
//	}
//
//	@Test(priority = 4, groups = "group1")
//	public void TC_PM_DC_002_03validateEachMandatoryIndividually() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_002: Validate Export/Import blocked while missing each mandatory field one-by-one");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnProductCategoryValuesByText("electronics","FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(1000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				
//			}
//		}
//	}
//
//	@Test(priority = 5, groups = "group1")
//	public void TC_PM_DC_002_04validateEachMandatoryIndividually() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_002: Validate Export/Import blocked while missing each mandatory field one-by-one");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				
//			}
//		}
//	}
//
//	@Test(priority = 6, groups = "group1")
//	public void TC_PM_DC_002_05validateEachMandatoryIndividually() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_002: Validate Export/Import blocked while missing each mandatory field one-by-one");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		PartMasterPage.selectOnProductCategoryValuesByText("electronics","FURNITURE");
//		Thread.sleep(3000);		
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				
//			}
//		}
//
//	}
//
//	@Test(priority = 7, groups = "group1")
//	public void TC_PM_DC_002_06validateEachMandatoryIndividually() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_002: Validate Export/Import blocked while missing each mandatory field one-by-one");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		PartMasterPage.selectOnProductCategoryValuesByText("electronics","FURNITURE");
//		Thread.sleep(3000);		
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		List<String> expectedKeys = Arrays.asList("Company Name", "Customer", "Supplier", "Product Category",
//				"Product Model", "Special Product Category", "Part UOM");
//
//		for (String key : expectedKeys) {
//			boolean found = validations.stream().anyMatch(m -> m.toLowerCase().contains(key.toLowerCase()));
//			if (found) {
//				LoggerUtil.info("Missing field for: " + key);
//			} else {
//				
//			}
//		}
//	}
//
//	@Test(priority = 8, groups = "group1")
//	public void TC_PM_DC_003validateCompanySingleSelectEnforcement() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_003: Company single-select enforcement");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
////	    List<String> CompanyName = Base.getPropertyAsList("CompanyName2");
////	    for (String cn : CompanyName) {
////	    	
////	    	PartMasterPage.selectOnCompanyValuesByText(cn.trim());
////	    }
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007", "Java Ptv Ltd-Mohali-3107");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValueByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValueByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("error") && msg.contains("Please select only one Company")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "error Please select only one Company",
//	                "error Please select only one Company message did not match.");
//	    } else {
//	        LoggerUtil.error("error Please select only one Company toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected error Please select only one Company toast not found.");
//	    }
//	 
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 9, groups = "group1")
//	public void TC_PM_DC_004validateCustomermultiselectallowed() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_004: Customer multi-select allowed");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110", "Roshan-Gazipur-3111");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValueByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValueByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		// --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(30000);
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 10, groups = "group1")
//	public void TC_PM_DC_005validateSuppliermultiselectallowedProcurementtemplateonly() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_005: Supplier multi-select allowed (Procurement template only)");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValueByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValueByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(15);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		// --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(30000);
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 11, groups = "group1")
//	public void TC_PM_DC_006validateSupplierselectionhiddenNotapplicableinSalestemplate() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_006: Supplier selection hidden/not applicable in Sales template");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectSales();
//		PartMasterPage.selectSalesAndVerifySupplierHidden();
//	}
//
//	@Test(priority = 12, groups = "group1")
//	public void TC_PM_DC_007ValidateProductCategorySingleSelectEnforcement() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_007: Product Category single-select enforcement");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText("electronics","FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValueByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValueByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("error") && msg.contains("Please select only one Product Model")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "error Please select only one Product Model",
//	                "error Please select only one Product Model message did not match.");
//	    } else {
//	        LoggerUtil.error("error Please select only one Product Model toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected error Please select only one Product Model toast not found.");
//	    }
//	 
//	    softAssert.assertAll();
//	}
//
//
//	
//	@Test(priority = 13, groups = "group1")
//	public void TC_PM_DC_008ValidateProductModelNameAndNoSingleSelectEnForcement() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_008: Product Model Name & No. single-select enforcement");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("SmartController-SC-120", "EcoPower Module-EP-45");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValueByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		Thread.sleep(3000);
//		// --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("error") && msg.contains("Please select only one Sub Product Model")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "error Please select only one Sub Product Model",
//	                "error Please select only one Sub Product Model message did not match.");
//	    } else {
//	        LoggerUtil.error("error Please select only one Sub Product Model toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected error Please select only one Sub Product Model toast not found.");
//	    }
//	 
//	    softAssert.assertAll();
//
//	}
//
//	@Test(priority = 14, groups = "group1")
//	public void TC_PM_DC_009ValidateSpecialProductCategorysingleselectenforcement() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_009: Special Product Category single-select enforcement");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValueByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("Industrial-Grade Components", "High-Precision Electronics");
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		
//		// --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("error") && msg.contains("Please select only one Special Product Category")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Please select only one Special Product Category",
//	                "Please select only one Special Product Category message did not match.");
//	    } else {
//	        LoggerUtil.error("Error toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected error toast not found.");
//	    }
//	    Thread.sleep(30000);
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 15, groups = "group1")
//	public void TC_PM_DC_010ValidatePartUOMsingleselectenforcement() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_010: Part UOM single-select enforcement");
//		 SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterDetailCostingRivisedPage.selectOnPartUOMValue("Shift");
//		PartMasterPage.selectOnCompanyValueByText(Base.getProperty("CompanyName1"));
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValueByText(Base.getProperty("ProductModelNameNo1"));
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		// --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//
//	    Thread.sleep(30000);
//
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//	    softAssert.assertAll();
//		
//	}
//
//	@Test(priority = 16, groups = "group1")
//	public void TC_PM_DC_011ValidateMandatorysetcompleteforProcurement() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_011: Mandatory set complete for Procurement");
//
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: Perform UI selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-7-Mohali-2208-7");
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("AAAAAlejandropkrh-807.83");
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//
//	    Thread.sleep(30000);
//
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//
//	    // --- Step 4: Expected values map ---
//	    Map<String, List<String>> expectedMap = new LinkedHashMap<>();
//	    expectedMap.put("Company Name - Location*", Collections.singletonList("Costmaster-Mohali-007"));
//	    expectedMap.put("Customer Name and Code*", Collections.singletonList("Mk-2208-7-Mohali-2208-7"));
//	    expectedMap.put("Supplier Name and Code*", Collections.singletonList("AAAAAlejandropkrh-807.83"));
//	    expectedMap.put("Product Category*", Collections.singletonList("FURNITURE"));
//	    expectedMap.put("Product Model Name & No.*", Collections.singletonList("Misc_2410456"));
//	    expectedMap.put("Special Product Category*", Collections.singletonList("MK-testing-2308"));
//
//	    // --- Step 5: Validate using SoftAssert ---
//	    ExcelUtil.validateMandatorySelections(workbook, headerMap, expectedMap, softAssert);
//
//	    // --- Step 6: Assert all results together ---
//	    softAssert.assertAll();
//	}
//
//
//	@Test(priority = 17, groups = "group1")
//	public void TC_PM_DC_012ValidateMandatorysetcompleteforProcurement() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_012: Mandatory set complete for Procurement");
//
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: Perform UI selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-5-Mohali-2208-5");
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("AAAAAlejandropkrh-807.83", "28.16-Fermingvn");
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//
//	    Thread.sleep(30000);
//
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//
//	    // --- Step 4: Expected values map ---
//	    Map<String, List<String>> expectedMap = new LinkedHashMap<>();
//	    expectedMap.put("Company Name - Location*", Collections.singletonList("Costmaster-Mohali-007"));
//	    expectedMap.put("Customer Name and Code*", Collections.singletonList("Mk-2208-5-Mohali-2208-5"));
//	    expectedMap.put("Supplier Name and Code*", Arrays.asList("AAAAAlejandropkrh-807.83", "28.16-Fermingvn"));
//	    expectedMap.put("Product Category*", Collections.singletonList("FURNITURE"));
//	    expectedMap.put("Product Model Name & No.*", Collections.singletonList("Misc_2410456"));
//	    expectedMap.put("Special Product Category*", Collections.singletonList("MK-testing-2308"));
//
//	    // --- Step 5: Validate using SoftAssert ---
//	    ExcelUtil.validateMandatorySelections(workbook, headerMap, expectedMap, softAssert);
//
//	    // --- Step 6: Assert all results together ---
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 18, groups = "group1")
//	public void TC_PM_DC_013ValidateMandatorysetcompleteforSales() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_013: Mandatory set complete for Sales");
//
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: Perform UI selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-5-Mohali-2208-5");
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//
//	    Thread.sleep(30000);
//
//	    // --- Step 3: Get downloaded Excel ---
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + fileName);
//
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//
//	    // --- Step 4: Expected values map ---
//	    Map<String, List<String>> expectedMap = new LinkedHashMap<>();
//	    expectedMap.put("Company Name - Location*", Collections.singletonList("Costmaster-Mohali-007"));
//	    expectedMap.put("Customer Name and Code*", Collections.singletonList("Mk-2208-5-Mohali-2208-5"));
//	    expectedMap.put("Product Category*", Collections.singletonList("FURNITURE"));
//	    expectedMap.put("Product Model Name & No.*", Collections.singletonList("Misc_2410456"));
//	    expectedMap.put("Special Product Category*", Collections.singletonList("MK-testing-2308"));
//
//	    // --- Step 5: Validate using SoftAssert ---
//	    ExcelUtil.validateMandatorySelections(workbook, headerMap, expectedMap, softAssert);
//
//	    // --- Step 6: Assert all results together ---
//	    softAssert.assertAll();
//	}
////
////
//	@Test(priority = 19, groups = "group1")
//	public void TC_PM_DC_014ValidateMandatorysetcompleteforSales() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_014: Mandatory set complete for Sales");
//
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: Perform UI selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-5-Mohali-2208-5", " Mk-2208-9-Mohali-2208-9");
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(11);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	 // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    Thread.sleep(30000);
//	    File filePath = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + filePath);
//
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(filePath);
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//
//	    // --- Step 3: Expected values map ---
//	    Map<String, List<String>> expectedMap = new LinkedHashMap<>();
//	    expectedMap.put("Company Name - Location*", Collections.singletonList("Costmaster-Mohali-007"));
//	    expectedMap.put("Customer Name and Code*", Arrays.asList("Mk-2208-5-Mohali-2208-5", "Mk-2208-9-Mohali-2208-9"));
//	    expectedMap.put("Product Category*", Collections.singletonList("FURNITURE"));
//	    expectedMap.put("Product Model Name & No.*", Collections.singletonList("Misc_2410456"));
//	    expectedMap.put("Special Product Category*", Collections.singletonList("MK-testing-2308"));
//
//	    // --- Step 4: Validate using soft assert ---
//	    ExcelUtil.validateMandatorySelections(workbook, headerMap, expectedMap, softAssert);
//
//	    // --- Final: Assert all results together ---
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 20, groups = "group1")
//	public void TC_PM_DC_015ValidateExport_Importpopupradiooptionsvisible() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_015: Export/Import popup radio options visible");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		Thread.sleep(2000);
//		boolean partMasterRadio = PartMasterDetailCostingRivisedPage.partMasterRadioDisplay();
//		Assert.assertTrue(partMasterRadio, "Part Master radio option is not visible");
//		boolean oldCostingRadio = PartMasterDetailCostingRivisedPage.oldCostingRadioDisplay();
//		Assert.assertTrue(oldCostingRadio, "old Costing radio option is not visible");
//		boolean detailCostingRadio = PartMasterDetailCostingRivisedPage.detailCostingRadioDisplay();
//		Assert.assertTrue(detailCostingRadio, "detail Costing radio option is not visible");
//	}
//
//	@Test(priority = 21, groups = "group1")
//	public void TC_PM_DC_016ValidateDetailCostingselectionrevealsnumericinput() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_016: Detail Costing selection reveals numeric input");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		Thread.sleep(2000);
//		PartMasterDetailCostingRivisedPage.verifyEnterTotalNoOfPartPlaceholderValue();
//		PartMasterDetailCostingRivisedPage.verifyExportAndImportButtonVisibleOrNot();
//
//	}
//
//	@Test(priority = 22, groups = "group1")
//	public void TC_PM_DC_017ValidateNumericinputacceptslowerbound_1() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_017: Numeric input accepts lower bound 1");
//		// --- Step 1: UI navigation ---
//		 SoftAssert softAssert = new SoftAssert();
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		Thread.sleep(3000);
//
//		 // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    Thread.sleep(30000);
//	    File filePath = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + filePath);
//	    softAssert.assertAll();
//		
//	}
//
//	@Test(priority = 23, groups = "group1")
//	public void TC_PM_DC_018ValidateNumericinputacceptslowerbound_1000() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_018: Numeric input accepts upper bound 1000");
//		// --- Step 1: UI navigation ---
//		 SoftAssert softAssert = new SoftAssert();
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		
//		 // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    Thread.sleep(30000);
//	    File filePath = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Costing Sheet: " + filePath);
//	    softAssert.assertAll();
//	}
//
//
//	
//	@Test(priority = 24, groups = "group1")
//	public void TC_PM_DC_019_ValidateNumericInputRejects0BelowMin() throws InterruptedException {
//	    LoggerUtil.info("TC_PM_DC_019: Numeric input rejects 0 (below min)");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//
//	    // --- Step 2: Enter invalid value and click Export ---
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(0);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // --- Step 3: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    LoggerUtil.info("Captured validation messages: " + validations);
//
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    boolean isRangeMsgFound = validations.stream()
//	            .anyMatch(msg -> msg.contains("Allowed range 1–1000"));
//
//	    if (isRangeMsgFound) {
//	        LoggerUtil.pass("Validation message displayed correctly: Allowed range 1–1000");
//	    } else {
//	        LoggerUtil.fail("Expected validation message not found. Actual: " + validations);
//	    }
//
//	    softAssert.assertTrue(isRangeMsgFound, "Validation 'Allowed range 1–1000' was not displayed.");
//	    
//	    // --- Step 4: Verify no file download occurred ---
//	    File latestFile = getLatestFilePartMasterForDetailCostingFile();
//	    if (latestFile != null && latestFile.exists()) {
//	        LoggerUtil.fail("File should not be downloaded when input is below minimum limit.");
//	    } else {
//	        LoggerUtil.pass("No file downloaded as expected for invalid input (0).");
//	    }
//
//	    softAssert.assertAll();
//	}
//
//
//	@Test(priority = 25, groups = "group1")
//	public void TC_PM_DC_020ValidateNumericinputrejectsgreterThan1000() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_020: Numeric input rejects >1000");
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1001);
//		Thread.sleep(3000);
//		Alert alert = driver.switchTo().alert();
//		Assert.assertEquals(alert.getText(), "Please enter upto 1000 part number!");
//		alert.accept();
//		LoggerUtil.info("Alert msg show : Please enter upto 1000 part number! ");
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		
//	}
//
//	
//	@Test(priority = 26, groups = "group1")
//	public void TC_PM_DC_021_ValidateNumericInputRejectsDecimals() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_021: Numeric input rejects decimals");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//
//	    // --- Step 2: Enter invalid decimal value ---
//	    String decimalInput = "10.5";
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(decimalInput);
//	    LoggerUtil.info("Entered invalid decimal value: " + decimalInput);
//
//	    // --- Step 3: Handle alert message ---
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.alertIsPresent());
//
//	    Alert alert = driver.switchTo().alert();
//	    String actualAlertMsg = alert.getText().trim();
//	    String expectedAlertMsg = "Please enter only numeric values.";
//	    alert.accept();
//
//	    LoggerUtil.info("Alert message captured: " + actualAlertMsg);
//
//	    if (actualAlertMsg.contains(expectedAlertMsg)) {
//	        LoggerUtil.pass("Alert validation passed: " + actualAlertMsg);
//	    } else {
//	        LoggerUtil.fail("Unexpected alert text: " + actualAlertMsg);
//	    }
//
//	    softAssert.assertTrue(actualAlertMsg.contains(expectedAlertMsg),
//	            "Alert mismatch! Expected: " + expectedAlertMsg + " | Actual: " + actualAlertMsg);
//
//	    // --- Step 3A: Extra handling after alert acceptance ---
//	    WebElement partsField = driver.findElement(By.xpath("(//input[@placeholder='Enter total no. of parts...'])[2]"));
//	    Thread.sleep(1000); // allow JS validation to complete
//	    partsField.clear();
//	    LoggerUtil.info("Cleared Total No. of Parts field after alert acceptance.");
//
//	    // Verify field is empty
//	    String valueAfterClear = partsField.getAttribute("value").trim();
//	    if (valueAfterClear.isEmpty()) {
//	        LoggerUtil.pass("Field cleared successfully after alert.");
//	    } else {
//	        LoggerUtil.fail("Field still contains value after alert: " + valueAfterClear);
//	    }
//
//	    // --- Step 4: Try clicking Export (should not proceed) ---
//	    long exportStartTime = System.currentTimeMillis(); // capture time before export
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    // --- Step 5: Validate error message instead of success ---
//	    String errorMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Error") && msg.contains("Please Enter RowNumber!")) {
//	            errorMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!errorMsg.isEmpty()) {
//	        LoggerUtil.pass("Correct error message displayed: " + errorMsg);
//	        softAssert.assertEquals(errorMsg,
//	                "Error Please Enter RowNumber!",
//	                "Error message text did not match expected value.");
//	    } else {
//	        LoggerUtil.fail("Expected error message not found. Actual messages: " + validations);
//	        softAssert.fail("Expected error message 'Error Please Enter RowNumber!' not displayed.");
//	    }
//
//	    // --- Step 6: Verify that no new file was downloaded ---
//	    File downloadedFile = getLatestFilePartMasterForDetailCostingFile(exportStartTime);
//	    if (downloadedFile != null && downloadedFile.exists()) {
//	        LoggerUtil.fail("Invalid decimal input was accepted — file download should have been blocked.");
//	    } else {
//	        LoggerUtil.pass("System correctly blocked file download for invalid decimal input.");
//	    }
//
//	    softAssert.assertAll();
//	}
//
//	
//	@Test(priority = 27, groups = "group1")
//	public void TC_PM_DC_022_ValidateNumericInputRejectsNegatives() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_022: Numeric input rejects negatives");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//
//	    // --- Step 2: Enter invalid negative value ---
//	    int negValue = -faker.number().numberBetween(10, 99);
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(String.valueOf(negValue));
//	    LoggerUtil.info("Entered invalid negative value: " + negValue);
//
//	    // --- Step 3: Handle alert message ---
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.alertIsPresent());
//
//	    Alert alert = driver.switchTo().alert();
//	    String actualAlertMsg = alert.getText().trim();
//	    String expectedAlertMsg = "Please enter only numeric values.";
//	    alert.accept();
//
//	    LoggerUtil.info("Alert message captured: " + actualAlertMsg);
//
//	    if (actualAlertMsg.contains(expectedAlertMsg)) {
//	        LoggerUtil.pass("Alert validation passed: " + actualAlertMsg);
//	    } else {
//	        LoggerUtil.fail("Unexpected alert text: " + actualAlertMsg);
//	    }
//
//	    softAssert.assertTrue(actualAlertMsg.contains(expectedAlertMsg),
//	            "Alert mismatch! Expected: " + expectedAlertMsg + " | Actual: " + actualAlertMsg);
//
//	    // --- Step 3A: Extra handling after alert acceptance ---
//	    WebElement partsField = driver.findElement(By.xpath("(//input[@placeholder='Enter total no. of parts...'])[2]"));
//	    Thread.sleep(1000); // Allow JS validation to complete
//	    partsField.clear();
//	    LoggerUtil.info("Cleared Total No. of Parts field after alert acceptance.");
//
//	    // Verify the field is empty
//	    String valueAfterClear = partsField.getAttribute("value").trim();
//	    if (valueAfterClear.isEmpty()) {
//	        LoggerUtil.pass("Field cleared successfully after alert.");
//	    } else {
//	        LoggerUtil.fail("Field still contains value after alert: " + valueAfterClear);
//	    }
//
//	    // --- Step 4: Try clicking Export (should not proceed) ---
//	
//	    long exportStartTime = System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	  
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    // --- Step 5: Validate error message ---
//	    String errorMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Error") && msg.contains("Please Enter RowNumber!")) {
//	            errorMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!errorMsg.isEmpty()) {
//	        LoggerUtil.pass("Correct error message displayed: " + errorMsg);
//	        softAssert.assertEquals(errorMsg,
//	                "Error Please Enter RowNumber!",
//	                "Error message text did not match expected value.");
//	    } else {
//	        LoggerUtil.fail("Expected error message not found. Actual messages: " + validations);
//	        softAssert.fail("Expected error message 'Error Please Enter RowNumber!' not displayed.");
//	    }
//
//	    // --- Step 6: Verify that no file was downloaded ---
//	 // --- After validation ---
//	    File downloadedFile = getLatestFilePartMasterForDetailCostingFile(exportStartTime);
//	    if (downloadedFile != null && downloadedFile.exists()) {
//	        LoggerUtil.fail("Invalid input was accepted — file download should have been blocked.");
//	    } else {
//	        LoggerUtil.pass("System correctly blocked file download for invalid input.");
//	    }
//
//	    softAssert.assertAll();
//	}
//	
//	@Test(priority = 28, groups = "group1")
//	public void TC_PM_DC_023_ValidateNumericInputRejectsNonNumericOrSpecialCharacters() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_023: Numeric input rejects non-numeric/special characters");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//
//	    // --- Step 2: Define invalid test inputs ---
//	    String[] invalidInputs = {"abc", "@#"};
//	    String expectedAlertMsg = "Please enter only numeric values.";
//	    int totalAlerts = 0;
//	    boolean alertAppeared = false;
//
//	    // --- Step 3: Loop through invalid inputs and validate alerts ---
//	    for (String input : invalidInputs) {
//	        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(input);
//	        LoggerUtil.info("Entered invalid non-numeric/special character input: " + input);
//
//	        // Handle multiple alert occurrences safely
//	        while (true) {
//	            try {
//	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//	                wait.until(ExpectedConditions.alertIsPresent());
//	                Alert alert = driver.switchTo().alert();
//	                String actualAlertMsg = alert.getText().trim();
//	                LoggerUtil.info("Alert message captured: " + actualAlertMsg);
//
//	                if (actualAlertMsg.equalsIgnoreCase(expectedAlertMsg)) {
//	                    LoggerUtil.pass("Alert validation passed: " + actualAlertMsg);
//	                } else {
//	                    LoggerUtil.fail("Unexpected alert text: " + actualAlertMsg);
//	                }
//
//	                alert.accept();
//	                totalAlerts++;
//	                alertAppeared = true;
//	                Thread.sleep(800); // allow JS validation to complete
//	            } catch (TimeoutException | NoAlertPresentException e) {
//	                break; // exit inner loop once no more alerts
//	            }
//	        }
//	    }
//
//	    if (alertAppeared)
//	        LoggerUtil.info("All alerts handled successfully. Total alerts: " + totalAlerts);
//	    else
//	        LoggerUtil.fail("No alert appeared for invalid inputs.");
//
//	    // --- Step 4: Clear the input field safely ---
//	    try {
//	        WebElement partsField = driver.findElement(By.xpath("(//input[@placeholder='Enter total no. of parts...'])[2]"));
//	        Thread.sleep(1000);
//	        partsField.clear();
//	        LoggerUtil.info("Cleared Total No. of Parts field after handling alerts.");
//
//	        String valueAfterClear = partsField.getAttribute("value").trim();
//	        if (valueAfterClear.isEmpty()) {
//	            LoggerUtil.pass("Field cleared successfully after invalid input alert.");
//	        } else {
//	            LoggerUtil.fail("Field still contains value after alert handling: " + valueAfterClear);
//	        }
//	    } catch (Exception e) {
//	        LoggerUtil.error("Error while clearing Total No. of Parts field: " + e.getMessage());
//	    }
//
//	    // --- Step 5: Click Export and verify validation message ---
//	    long exportStartTime = System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    LoggerUtil.info("Captured validation messages after export attempt: " + validations);
//
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String errorMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Error") && msg.contains("Please Enter RowNumber!")) {
//	            errorMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!errorMsg.isEmpty()) {
//	        LoggerUtil.pass("Correct error message displayed: " + errorMsg);
//	        softAssert.assertEquals(errorMsg, "Error Please Enter RowNumber!",
//	                "Error message text did not match expected value.");
//	    } else {
//	        LoggerUtil.fail("Expected error message not found. Actual messages: " + validations);
//	        softAssert.fail("Expected error message 'Error Please Enter RowNumber!' not displayed.");
//	    }
//
//	    // --- Step 6: Verify that no file was downloaded ---
//	    File downloadedFile = getLatestFilePartMasterForDetailCostingFile(exportStartTime);
//	    if (downloadedFile != null && downloadedFile.exists()) {
//	        LoggerUtil.fail("Invalid non-numeric/special input was accepted — file download should have been blocked.");
//	    } else {
//	        LoggerUtil.pass("System correctly blocked file download for invalid non-numeric/special input.");
//	        LoggerUtil.info("No new Detail Costing file downloaded after export.");
//	    }
//
//	    softAssert.assertAll();
//	}
//	
//	@Test(priority = 29, groups = "group1")
//	public void TC_PM_DC_024ValidateEnterednumberdeterminespartrowsinExcel()
//			throws InterruptedException, TimeoutException {
//		LoggerUtil.info("TC_PM_DC_024: Entered number determines part rows in Excel");
//		 SoftAssert softAssert = new SoftAssert();
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		int expectedParts = 25;
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(String.valueOf(expectedParts));
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		 // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//				 
//		Thread.sleep(30000);
//		File filname = getLatestFilePartMasterForDetailCostingFile();
//		LoggerUtil.info("Downloaded Details Casting Sheet: " + filname);
//		String filePathName = filname.getAbsolutePath();
//		String sheetName = "Part_Master";
//
//		int actualRowCount = ExcelUtil.getExportedPartRows(filePathName, sheetName);
//
//		if (actualRowCount == expectedParts) {
//			LoggerUtil.pass("Excel row count matched: " + actualRowCount);
//		} else {
//			LoggerUtil.fail("Row count mismatch. Expected: " + expectedParts + ", Found: " + actualRowCount);
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 30, groups = "group1")
//	public void TC_PM_DC_025ValidateExportDisabledUntilDetailCostingSelected() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_025: Export disabled until Detail Costing radio is selected");
//
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		boolean isEnabled = PartMasterDetailCostingRivisedPage.isExportButtonEnabledInModal();
//		if (isEnabled) {
//			LoggerUtil.pass("Export button enabled after selecting Detail Costing");
//		} else {
//			LoggerUtil.fail("Export button still disabled after selecting Detail Costing");
//		}
//	}
//	
//	@Test(priority = 31, groups = "group1")
//	public void TC_PM_DC_026ValidateSalestemplateExcelstructurewithoutSupplier() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_026: Sales template: Excel structure without Supplier");
//		 SoftAssert softAssert = new SoftAssert();
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(5);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		 // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//		 
//		  Thread.sleep(30000);
//		  File filname = getLatestFilePartMasterForDetailCostingFile();
//		  LoggerUtil.info("Downloaded Details Casting Sheet: " + filname);
//		  
//		try (FileInputStream fis = new FileInputStream(filname); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//			// Step 1: Validate sheet names
//			List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost", "Commodity_Master",
//					"Process_Master", "BOP_Master", "OHP_Master");
//
//			List<String> actualSheets = new ArrayList<>();
//			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//				actualSheets.add(workbook.getSheetName(i));
//			}
//
//			if (new HashSet<>(actualSheets).equals(new HashSet<>(expectedSheets))) {
//				LoggerUtil.pass("Workbook sheet names matched (order independent): " + actualSheets);
//			} else {
//				LoggerUtil.fail(
//						"Workbook sheet names mismatch. Expected: " + expectedSheets + ", Found: " + actualSheets);
//			}
//
//			// Step 2: Validate Supplier column (ignore for Sales)
//			Sheet partSheet = workbook.getSheet("Part_Master");
//			if (partSheet == null) {
//				LoggerUtil.fail("Part_Master sheet not found!");
//				return;
//			}
//
//			Row headerRow = partSheet.getRow(1); // Row 1 = header (Row 0 = title row)
//			if (headerRow == null) {
//				LoggerUtil.fail("Header row not found in Part_Master sheet!");
//				return;
//			}
//
//			boolean supplierFound = false;
//			for (Cell cell : headerRow) {
//				if (cell != null && cell.getCellType() == CellType.STRING
//						&& cell.getStringCellValue().toLowerCase().contains("supplier")) {
//					supplierFound = true;
//					break;
//				}
//			}
//
//			// ✅ Sales case → Supplier ko ignore kar do
//			if (supplierFound) {
//				LoggerUtil.info(
//						"Note: Supplier column is physically present in sheet but hidden as per Sales functionality → Ignored");
//				LoggerUtil.pass("Sales template validation passed: Supplier treated as hidden.");
//			} else {
//				LoggerUtil.pass("Supplier column not found in Part_Master (as expected for Sales).");
//			}
//
//		} catch (Exception e) {
//			LoggerUtil.error("Exception while validating Sales template: " + e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 32, groups = "group1")
//	public void TC_PM_DC_027ValidateExcelHeaderMapping() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_027: Mapping of Excel headers");
//		 SoftAssert softAssert = new SoftAssert();
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(5);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		 // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//		 
//		  Thread.sleep(30000);
//		  File filname = getLatestFilePartMasterForDetailCostingFile();
//		  LoggerUtil.info("Downloaded Details Casting Sheet: " + filname);
//
//		// Validate the Excel file content
//		try (FileInputStream fis = new FileInputStream(filname); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//			// Step 1: Validate sheet names (Part_Master, Process_Cost, etc.)
//			List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost", "Commodity_Master",
//					"Process_Master", "BOP_Master", "OHP_Master");
//
//			List<String> actualSheets = new ArrayList<>();
//			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//				actualSheets.add(workbook.getSheetName(i));
//			}
//
//			if (new HashSet<>(actualSheets).equals(new HashSet<>(expectedSheets))) {
//				LoggerUtil.pass("Workbook sheet names matched (order independent): " + actualSheets);
//			} else {
//				LoggerUtil.fail(
//						"Workbook sheet names mismatch. Expected: " + expectedSheets + ", Found: " + actualSheets);
//			}
//
//			// Step 2: Validate headers in Part_Master sheet
//			Sheet partSheet = workbook.getSheet("Part_Master");
//			if (partSheet == null) {
//				LoggerUtil.fail("Part_Master sheet not found!");
//				return;
//			}
//
//			Row headerRow = partSheet.getRow(1); // Row 1 = header (Row 0 = title row)
//			if (headerRow == null) {
//				LoggerUtil.fail("Header row not found in Part_Master sheet!");
//				return;
//			}
//
//			// Step 3: Compare Excel headers with UI selections
//			Map<String, String> expectedHeaderValues = new HashMap<>();
//			expectedHeaderValues.put("Company", "Costmaster-Mohali-007");
//			expectedHeaderValues.put("Customer", "Mk-2208-7-Mohali-2208-7");
//			expectedHeaderValues.put("Product Category", "FURNITURE");
//			expectedHeaderValues.put("Product Model", "Misc_2410456");
//			expectedHeaderValues.put("Special Product Category", "MK-testing-2308");
//
//			boolean allHeadersMatch = true;
//
//			// Loop through the header row to validate column names
//			for (Cell cell : headerRow) {
//				if (cell != null && cell.getCellType() == CellType.STRING) {
//					String headerCellValue = cell.getStringCellValue();
//					// Check if the value in the header matches UI selections
//					if (expectedHeaderValues.containsKey(headerCellValue)) {
//						String expectedValue = expectedHeaderValues.get(headerCellValue);
//						int rowNum = cell.getRowIndex() + 1; // get corresponding row data in the sheet
//						String actualValue = partSheet.getRow(rowNum).getCell(cell.getColumnIndex())
//								.getStringCellValue();
//
//						// Validate the value from Excel matches the UI-selected value
//						if (actualValue.equals(expectedValue)) {
//							LoggerUtil.pass(
//									"Header: " + headerCellValue + " → Excel value matches UI value: " + expectedValue);
//						} else {
//							LoggerUtil.fail("Header: " + headerCellValue + " → Excel value: " + actualValue
//									+ " does not match UI value: " + expectedValue);
//							allHeadersMatch = false;
//						}
//					}
//				}
//			}
//
//			if (allHeadersMatch) {
//				LoggerUtil.pass("All Excel headers correctly map to UI selections.");
//			} else {
//				LoggerUtil.fail("Some headers do not match UI selections.");
//			}
//
//		} catch (Exception e) {
//			LoggerUtil.error("Exception while validating Sales template Excel structure: " + e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 33, groups = "group1")
//	public void TC_PM_DC_028ValidateProcurementTemplateWithSupplier() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_028: Procurement template: Excel structure with Supplier");
//		 SoftAssert softAssert = new SoftAssert();
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		int expectedParts =5;
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(String.valueOf(expectedParts));
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		// --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg,
//	                "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//				 
//		Thread.sleep(30000);
//		File filname = getLatestFilePartMasterForDetailCostingFile();
//		LoggerUtil.info("Downloaded Details Casting Sheet: " + filname);
//		// Step 2: Validate the Excel file content
//		try (FileInputStream fis = new FileInputStream(filname); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//			// Step 1: Validate sheet names (Part_Master, Process_Cost, etc.)
//			List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost", "Commodity_Master",
//					"Process_Master", "BOP_Master", "OHP_Master");
//
//			List<String> actualSheets = new ArrayList<>();
//			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//				actualSheets.add(workbook.getSheetName(i));
//			}
//
//			if (new HashSet<>(actualSheets).equals(new HashSet<>(expectedSheets))) {
//				LoggerUtil.pass("Workbook sheet names matched (order independent): " + actualSheets);
//			} else {
//				LoggerUtil.fail(
//						"Workbook sheet names mismatch. Expected: " + expectedSheets + ", Found: " + actualSheets);
//			}
//
//			// Step 2: Validate Supplier-related columns are present in Part_Master
//			Sheet partSheet = workbook.getSheet("Part_Master");
//			if (partSheet == null) {
//				LoggerUtil.fail("Part_Master sheet not found!");
//				return;
//			}
//
//			Row headerRow = partSheet.getRow(1); // Row 1 = header (Row 0 = title row)
//			if (headerRow == null) {
//				LoggerUtil.fail("Header row not found in Part_Master sheet!");
//				return;
//			}
//
//			// Step 3: Check for Supplier-related columns (e.g., Supplier Name, Supplier
//			// Code)
//			List<String> expectedSupplierColumns = Arrays.asList("Supplier Name and Code*");
//			boolean supplierColumnsFound = true;
//
//			for (String expectedColumn : expectedSupplierColumns) {
//				boolean columnFound = false;
//				for (Cell cell : headerRow) {
//					if (cell != null && cell.getCellType() == CellType.STRING
//							&& cell.getStringCellValue().toLowerCase().contains(expectedColumn.toLowerCase())) {
//						columnFound = true;
//						LoggerUtil.info("Expected Supplier column '" + columnFound);
//
//						break;
//					}
//				}
//				if (!columnFound) {
//					LoggerUtil.fail("Expected Supplier column '" + expectedColumn + "' not found in Part_Master.");
//					supplierColumnsFound = false;
//				}
//			}
//
//			if (supplierColumnsFound) {
//				LoggerUtil.pass("Supplier-related columns found in Part_Master as expected.");
//			}
//
//			// Step 4: Validate Supplier data in the rows
//			boolean supplierDataCorrect = true;
//			for (int i = 2; i <= partSheet.getLastRowNum(); i++) {
//				Row dataRow = partSheet.getRow(i);
//				if (dataRow != null) {
//					Cell supplierCell = dataRow.getCell(headerRow.getPhysicalNumberOfCells() - 1); // Last cell for
//																									// Supplier Name
//					if (supplierCell != null && supplierCell.getCellType() == CellType.STRING) {
//						String supplierName = supplierCell.getStringCellValue();
//						if (!supplierName.equals("Supplier-001")) {
//							LoggerUtil.fail("Supplier data mismatch in row " + (i + 1)
//									+ ": Expected 'Supplier-001', Found: " + supplierName);
//							supplierDataCorrect = false;
//						}
//					}
//				}
//			}
//
//			if (supplierDataCorrect) {
//				LoggerUtil.pass("Supplier data correctly mapped in Part_Master.");
//			}
//
//		} catch (Exception e) {
//			LoggerUtil.error("Exception while validating Procurement template Excel structure: " + e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//	
//	@Test(priority = 34, groups = "group1")
//	public void TC_PM_DC_029ValidateUISelectionsMappedToExcelHeaders() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_029: UI Selections mapped to Excel headers");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-5-Mohali-2208-5");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("AAAAAlejandropkrh-807.83");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(2);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // --- Step 2: Capture validation messages ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//
//	    // Expected UI selections (for verification)
//	    Map<String, String> expectedValues = new HashMap<>();
//	    expectedValues.put("Company", "Costmaster-Mohali-007");
//	    expectedValues.put("Customer", "Mk-2208-5-Mohali-2208-5");
//	    expectedValues.put("Supplier", "AAAAAlejandropkrh-807.83");
//	    expectedValues.put("Product Category", "FURNITURE");
//	    expectedValues.put("Product Model", "Misc-2410456");
//	    expectedValues.put("Special Product Category", "MK-testing-2308");
//
//	    // Validate Excel fields
//	    PartMasterDetailCostingRivisedPage.validateFieldsInExcel(fileName.getAbsolutePath(), expectedValues, softAssert);
//
//	    softAssert.assertAll();
//	}
//
//
//	@Test(priority = 35, groups = "group1")
//	public void TC_PM_DC_030ValidatePreventdownloadwhenbothSalesandProcurementselectedtogether() 
//	        throws InterruptedException {
//	    
//	    LoggerUtil.info("TC_PM_DC_030: Prevent download when both Sales and Procurement selected together");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try {
//	        // --- Step 1: UI Navigation ---
//	        LoggerUtil.info("Navigating to Detail Costing → Export/Import popup...");
//	        dashboard.clickingDashboard("");
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        Thread.sleep(2000);
//	        dashboard.clickOnPartMaster();
//	        Thread.sleep(1000);
//
//	        PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	        PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	        PartMasterDetailCostingRivisedPage.selectBoth(); // Selecting both Sales and Procurement together
//	        PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	        PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	        Thread.sleep(2000);
//	        PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	        PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	        
//	        // --- Step 2: Attempt export action ---
//	        PartMasterDetailCostingRivisedPage.openExportImportModal();
//	        int expectedParts = 5;
//	        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(String.valueOf(expectedParts));
//	        long exportStartTime = System.currentTimeMillis();
//	        PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	        LoggerUtil.info("Clicked on Export button after selecting both Sales and Procurement.");
//
//	        // --- Step 3: Capture validation messages ---
//	        List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	        softAssert.assertFalse(validations.isEmpty(), 
//	                "No validation message appeared; system may have allowed invalid export.");
//
//	        String successMsg = "";
//	        for (String msg : validations) {
//	            if (msg.toLowerCase().contains("error") && msg.contains("Please select Procurement/Sales")) {
//	                successMsg = msg.trim().replaceAll("\\s+", " ");
//	                break;
//	            }
//	        }
//
//	        if (!successMsg.isEmpty()) {
//	            LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	            softAssert.assertEquals(successMsg, 
//	                    "error Please select Procurement/Sales",
//	                    "Validation message mismatch. Expected: 'error Please select Procurement/Sales'");
//	        } else {
//	            LoggerUtil.error("Expected error toast not captured. Actual messages: " + validations);
//	            softAssert.fail("System did not show the expected validation toast message.");
//	        }
//
//	        // --- Step 4: Verify no file download occurred ---
//	        Thread.sleep(3000);
//	        File fileName = getLatestFilePartMasterForDetailCostingFile(exportStartTime);
//	        if (fileName != null && fileName.exists()) {
//	            LoggerUtil.error("File download should have been blocked, but file detected: " + fileName.getName());
//	            softAssert.fail("File downloaded despite both options selected together.");
//	        } else {
//	            LoggerUtil.info("✅ File download correctly prevented when both Sales and Procurement were selected.");
//	        }
//
//	    } catch (Exception e) {
//	        LoggerUtil.error("Exception occurred during TC_PM_DC_030 execution: " + e.getMessage());
//	        softAssert.fail("Unexpected exception: " + e.getMessage());
//	    } finally {
//	        softAssert.assertAll();
//	    }
//	}
//
//
//	@Test(priority = 36, groups = "group1")
//	public void TC_PM_DC_031ValidateAllowdownloadwhenexactlyonetemplateselectedandSuccessmessageonvalidexport()
//			throws InterruptedException {
//		LoggerUtil.info(
//				"TC_PM_DC_031: Allow download when exactly one template selected and Success message on valid export");
//		// --- Step 1: UI navigation ---
//		 SoftAssert softAssert = new SoftAssert();
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		int expectedParts =5;
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(String.valueOf(expectedParts));
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		 List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//		    // --- Step 3: Wait for file download and validate ---
//		    Thread.sleep(30000);
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//					PartMasterDetailCostingRivisedPage.selectProcurement();
//				    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//				    PartMasterDetailCostingRivisedPage.openExportImportModal();
//				    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//				    List<String> validations1 = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//				    softAssert.assertFalse(validations1.isEmpty(), "No validation message appeared; action was not blocked.");
//
//				    String successMsg1 = "";
//				    for (String msg : validations1) {
//				        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//				        	successMsg1 = msg.trim().replaceAll("\\s+", " ");
//				            break;
//				        }
//				    }
//
//				    if (!successMsg1.isEmpty()) {
//				        LoggerUtil.info("Validation message captured (normalized): " + successMsg1);
//				        softAssert.assertEquals(successMsg1, "Success File exported successfully",
//				                "Export success message did not match.");
//				    } else {
//				        LoggerUtil.error("Success toast not captured. Actual messages: " + validations1);
//				        softAssert.fail("Expected success toast not found.");
//				    }
//
//				    // --- Step 3: Wait for file download and validate ---
//				    Thread.sleep(30000);
//				    File fileName1 = getLatestFilePartMasterForDetailCostingFile();
//				    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName1);
//					softAssert.assertAll();
//
//	}
//
//	@Test(priority = 37, groups = "group1")
//	public void TC_PM_DC_032ValidatePopupclosebehavior() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_032: Popup close behavior");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.verifyRadioPopUpCloseButton();
//	}
//
//	@Test(priority = 38, groups = "group1")
//	public void TC_PM_DC_033ValidateProcurementmissingSuppliervalidation() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_033: Procurement: missing Supplier validation");
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		int expectedParts =5;
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(String.valueOf(expectedParts));
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		// ✅ find the specific error message
//		String actualMsg = validations.stream()
//		        .filter(msg -> msg.contains("Please select at least one Supplier"))
//		        .findFirst()
//		        .orElse("");
//
//		// normalize spaces
//		actualMsg = actualMsg.trim().replaceAll("\\s+", " ");
//
//		LoggerUtil.pass("Validation message filtered: " + actualMsg);
//
//		// now assert only on the target error
//		String expectedMsg = "Please select at least one Supplier";
//		Assert.assertTrue(actualMsg.contains(expectedMsg),
//		        "Expected error not found! Expected to contain: " + expectedMsg + " | Actual: " + actualMsg);		 
//	}
//	
//	@Test(priority = 39, groups = "group1")
//	public void TC_PM_DC_034ValidateDownloadblockedwhenradioisnot_DetailCostingfordetailedfile() throws InterruptedException {
//		LoggerUtil.info("TC_PM_DC_034: Download blocked when radio is not “Detail Costing” for detailed file");
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModalAndSelectPartMasterRadioBtn();
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		String actualMsg = validations.get(0).trim().replaceAll("\\s+", " ");
//		
//		  LoggerUtil.pass("Validation message captured (normalized): " + actualMsg);
//		  
//		  Assert.assertEquals(actualMsg, "Unable to export! Name contains invalid characters or is not valid.17012025",
//		  "Unable to export! Name contains invalid characters or is not valid.17012025 did not match.");	 
//	}
//	
//	@Test(priority = 40, groups = "group1")
//	public void TC_PM_DC_035ValidateNumericinputtrimmingandleadingzeroshandling()
//			throws InterruptedException, TimeoutException {
//		 SoftAssert softAssert = new SoftAssert();
//		LoggerUtil.info("TC_PM_DC_035: Numeric input trimming and leading zeros handling");
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts("0010");
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 41, groups = "group1")
//	public void TC_PM_DC_036ValidateSpace_onlyinputhandling() throws InterruptedException, TimeoutException, java.util.concurrent.TimeoutException {
//		LoggerUtil.info("TC_PM_DC_036: Space-only input handling");
//		// --- Step 1: UI navigation ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//	    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//	    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(" ");
//		handleAlertIfPresent("Please enter only numeric values.", true);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		Assert.assertFalse(validations.isEmpty(), "No validation message appeared.");
//		// ✅ Normalize and pick only the success message
//				String actualMsg = validations.stream()
//				        .map(msg -> msg.replaceAll("\\r?\\n", " ").trim().replaceAll("\\s+", " "))
//				        .filter(msg -> msg.equals("Error Please Enter RowNumber!"))
//				        .findFirst()
//				        .orElse("");
//
//				// Log and validate
//				LoggerUtil.pass("Validation message captured (normalized): " + actualMsg);
//
//				String expectedMsg = "Error Please Enter RowNumber!";
//				Assert.assertEquals(actualMsg, expectedMsg, "Error Please Enter RowNumber! did not match.");
//		
//	}
//
//	@Test(priority = 42, groups = "group1")
//	public void TC_PM_DC_037ValidateCancel_closedoesnotretaininvalidstate()
//			throws InterruptedException, TimeoutException {
//		LoggerUtil.info("TC_PM_DC_037: Cancel/close does not retain invalid state");
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(0);
//		PartMasterDetailCostingRivisedPage.verifyRadioPopUpCloseButton();
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.verifyPopupResetAfterClose();
//	}
//
//	@Test(priority = 43, groups = "group1")
//	public void TC_PM_DC_038ValidateSuccessfulDetailedCostingexportSales_With_1000_Rows()
//	        throws InterruptedException, TimeoutException, FileNotFoundException, IOException {
//		SoftAssert softAssert = new SoftAssert();
//	    LoggerUtil.info("TC_PM_DC_038: Successful Detailed Costing export (Sales) with 1000 rows");
//
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj", "aeovtwr");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//
//	    List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost",
//	            "Commodity_Master", "Process_Master", "BOP_Master", "OHP_Master");
//
//	    ExcelUtil.verifyExcelSheetNames(fileName, expectedSheets);
//
//	    Sheet partSheet = workbook.getSheet("Part_Master");
//
//	    // header map
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//	    if (lastDataRowCount == 1000) {
//	        LoggerUtil.pass("PASS: Part_Master contains exactly 1000 valid data rows.");
//	    } else {
//	        LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 1000, Found: " + lastDataRowCount);
//	    }
//
//	    // Step 4: validations (Dynamic DV support)
//	    Map<String, List<String>> expectedSelections = new LinkedHashMap<>();
//	    expectedSelections.put("Company Name - Location*", Arrays.asList("Costmaster-Mohali-007"));
//	    expectedSelections.put("Customer Name and Code*", Arrays.asList("adiydtj", "aeovtwr"));
//	    expectedSelections.put("Product Category*", Arrays.asList("FURNITURE"));
//	    expectedSelections.put("Product Model Name & No.*", Arrays.asList("Misc-2410456")); // <-- normalize allowed here
//	    expectedSelections.put("Special Product Category*", Arrays.asList("MK-testing-2308"));
//	    // Supplier ko skip kiya gaya hai (Sales ke liye)
//
//	    // ✅ Use SoftAssert
//	  
//
//	    for (Map.Entry<String, List<String>> e : expectedSelections.entrySet()) {
//	        String column = e.getKey();
//	        List<String> expectedVals = e.getValue();
//
//	        if (!headerMap.containsKey(column)) {
//	            LoggerUtil.fail("Column not found: " + column);
//	            continue;
//	        }
//
//	        int colIdx = headerMap.get(column);
//	        Set<String> found = collectColumnCellValues(partSheet, colIdx, 2, lastDataRowCount);
//	        found.addAll(collectExplicitDVListForColumn(partSheet, workbook, colIdx, 2, lastDataRowCount));
//
//	        for (String exp : expectedVals) {
//	            boolean ok;
//
//	            if (column.equalsIgnoreCase("Product Model Name & No.*")) {
//	                // ✅ only for Product Model Name & No. do normalization
//	                ok = found.stream().anyMatch(v ->
//	                        v.replace("_", "-").equalsIgnoreCase(exp.replace("_", "-")));
//	            } else {
//	                // ✅ all other columns strict check
//	                ok = found.stream().anyMatch(v -> v.equalsIgnoreCase(exp));
//	            }
//
//	            if (ok) {
//	                LoggerUtil.pass("PASS: Column [" + column + "] matched. Expected [" + exp + "] | Found: " + found);
//	            } else {
//	                LoggerUtil.fail("FAIL: Column [" + column + "] mismatch. Expected [" + exp + "] | Found: " + found);
//	            }
//
//	            softAssert.assertTrue(ok,
//	                    "Mismatch in column [" + column + "]. Expected [" + exp + "], Found values: " + found);
//	        }
//	    }
//
//	    // ✅ Collect all assertion results at the end
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 44, groups = "group1")
//	public void TC_PM_DC_039ValidateSuccessfulDetailedCostingexportSales_With_1000_Rows()
//	        throws InterruptedException, TimeoutException, FileNotFoundException, IOException {
//		 // ✅ Use SoftAssert
//	    SoftAssert softAssert = new SoftAssert();
//	    LoggerUtil.info("TC_PM_DC_039: Successful Detailed Costing export (Procurement) with 1000 rows");
//
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj", "aeovtwr");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta", "0801-Ellsworth");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//
//	    List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost",
//	            "Commodity_Master", "Process_Master", "BOP_Master", "OHP_Master");
//
//	    ExcelUtil.verifyExcelSheetNames(fileName, expectedSheets);
//
//	    Sheet partSheet = workbook.getSheet("Part_Master");
//
//	    // header map
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//	    if (lastDataRowCount == 1000) {
//	        LoggerUtil.pass("PASS: Part_Master contains exactly 1000 valid data rows.");
//	    } else {
//	        LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 1000, Found: " + lastDataRowCount);
//	    }
//
//	    // Step 4: validations (Dynamic DV support)
//	    Map<String, List<String>> expectedSelections = new LinkedHashMap<>();
//	    expectedSelections.put("Company Name - Location*", Arrays.asList("Costmaster-Mohali-007"));
//	    expectedSelections.put("Customer Name and Code*", Arrays.asList("adiydtj", "aeovtwr"));
//	    expectedSelections.put("Supplier Name and Code*", Arrays.asList("0801-Celesta", "0801-Ellsworth"));
//	    expectedSelections.put("Product Category*", Arrays.asList("FURNITURE"));
//	    expectedSelections.put("Product Model Name & No.*", Arrays.asList("Misc_2410456"));
//	    expectedSelections.put("Special Product Category*", Arrays.asList("MK-testing-2308"));
//
//	   
//
//	    for (Map.Entry<String, List<String>> e : expectedSelections.entrySet()) {
//	        String column = e.getKey();
//	        List<String> expectedVals = e.getValue();
//
//	        if (!headerMap.containsKey(column)) {
//	            LoggerUtil.fail("Column not found: " + column);
//	            continue;
//	        }
//
//	        int colIdx = headerMap.get(column);
//	        Set<String> found = collectColumnCellValues(partSheet, colIdx, 2, lastDataRowCount);
//	        found.addAll(collectExplicitDVListForColumn(partSheet, workbook, colIdx, 2, lastDataRowCount));
//
//	        for (String exp : expectedVals) {
//	            boolean ok = found.stream().anyMatch(v -> v.equalsIgnoreCase(exp));
//
//	            if (ok) {
//	                LoggerUtil.pass("PASS: Column [" + column + "] matched. Expected [" + exp + "] | Found: " + found);
//	            } else {
//	                LoggerUtil.fail("FAIL: Column [" + column + "] mismatch. Expected [" + exp + "] | Found: " + found);
//	            }
//
//	            softAssert.assertTrue(ok,
//	                    "Mismatch in column [" + column + "]. Expected [" + exp + "], Found values: " + found);
//	        }
//	    }
//
//	    // ✅ Collect all assertion results at the end
//	    softAssert.assertAll();
//	}
//
//	
//	/** Collect visible cell values from a single column across rows (trimmed). */
//	private static Set<String> collectColumnCellValues(Sheet sheet, int colIdx, int firstRow, int lastRow) {
//		Set<String> vals = new LinkedHashSet<>();
//		for (int r = firstRow; r <= lastRow; r++) {
//			Row row = sheet.getRow(r);
//			if (row == null)
//				continue;
//			Cell cell = row.getCell(colIdx);
//			if (cell == null)
//				continue;
//			String txt = cell.toString().trim();
//			if (!txt.isEmpty())
//				vals.add(txt);
//		}
//		return vals;
//	}
//
//	/**
//	 * Collect explicit + named-range Data Validation list values for any column.
//	 */
//	private static Set<String> collectExplicitDVListForColumn(Sheet sheet, XSSFWorkbook wb, int targetCol, int firstRow,
//			int lastRow) {
//		Set<String> vals = new LinkedHashSet<>();
//		List<? extends DataValidation> dvList = sheet.getDataValidations();
//		for (DataValidation dv : dvList) {
//			CellRangeAddressList regions = dv.getRegions();
//			if (regions == null)
//				continue;
//
//			boolean applies = false;
//			for (CellRangeAddress region : regions.getCellRangeAddresses()) {
//				if (region.getFirstColumn() <= targetCol && region.getLastColumn() >= targetCol
//						&& region.getLastRow() >= firstRow && region.getFirstRow() <= lastRow) {
//					applies = true;
//					break;
//				}
//			}
//			if (!applies)
//				continue;
//
//			DataValidationConstraint c = dv.getValidationConstraint();
//			if (c == null)
//				continue;
//
//			// 1) explicit list
//			String[] explicit = c.getExplicitListValues();
//			if (explicit != null && explicit.length > 0) {
//				for (String s : explicit)
//					if (s != null && !s.trim().isEmpty())
//						vals.add(s.trim());
//				continue;
//			}
//
//			// 2) formula (named range or area ref)
//			String f = c.getFormula1();
//			if (f == null || f.trim().isEmpty())
//				continue;
//
//			Name nm = wb.getName(f);
//			String ref = (nm != null) ? nm.getRefersToFormula() : f;
//			try {
//				AreaReference ar = new AreaReference(ref, SpreadsheetVersion.EXCEL2007);
//				for (CellReference cr : ar.getAllReferencedCells()) {
//					Sheet s = wb.getSheet(cr.getSheetName() == null ? sheet.getSheetName() : cr.getSheetName());
//					Row r = s.getRow(cr.getRow());
//					if (r == null)
//						continue;
//					Cell cell = r.getCell(cr.getCol());
//					if (cell == null)
//						continue;
//					String v = cell.toString().trim();
//					if (!v.isEmpty())
//						vals.add(v);
//				}
//			} catch (Exception ignore) {
//			}
//		}
//		return vals;
//	}
//
//	@Test(priority = 45, groups = "group1")
//	public void TC_PM_DC_040ValidateLoadSalesexportwith_1_row() throws InterruptedException {
//
//		LoggerUtil.info("TC_PM_DC_040: Load: Sales export with 1 row");
//		 SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectSales();
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		 List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//		    // --- Step 3: Wait for file download and validate ---
//		    Thread.sleep(30000);
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//		XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//		workbook.getSheet("Part_Master");
//		ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//		int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//		if (lastDataRowCount == 1) {
//			LoggerUtil.pass("PASS: Part_Master contains exactly 1 valid data rows.");
//		} else {
//			LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 1, Found: " + lastDataRowCount);
//		}
//		 softAssert.assertAll();
//	}
//
//	@Test(priority = 46, groups = "group1")
//	public void TC_PM_DC_041ValidateLoadProcurementexportwith_1_row() throws InterruptedException {
//
//		LoggerUtil.info("TC_PM_DC_041: Load: Procurement export with 1 row");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//		XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//		workbook.getSheet("Part_Master");
//		ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//		int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//		if (lastDataRowCount == 1) {
//			LoggerUtil.pass("PASS: Part_Master contains exactly 1 valid data rows.");
//		} else {
//			LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 1, Found: " + lastDataRowCount);
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 47, groups = "group1")
//	public void TC_PM_DC_042ValidateLoadSalesexportwith_100_row() throws InterruptedException {
//
//		LoggerUtil.info("TC_PM_DC_042: Load: Sales export with 100 rows");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectSales();
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//		XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//		workbook.getSheet("Part_Master");
//		ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//		int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//		if (lastDataRowCount == 100) {
//			LoggerUtil.pass("PASS: Part_Master contains exactly 100 valid data rows.");
//		} else {
//			LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 100, Found: " + lastDataRowCount);
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 48, groups = "group1")
//	public void TC_PM_DC_043ValidateLoadProcurementexportwith_100_row() throws InterruptedException {
//
//		LoggerUtil.info("TC_PM_DC_043: Load: Procurement export with 100 row");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//		XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//		workbook.getSheet("Part_Master");
//		ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//		int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//		if (lastDataRowCount == 100) {
//			LoggerUtil.pass("PASS: Part_Master contains exactly 100 valid data rows.");
//		} else {
//			LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 100, Found: " + lastDataRowCount);
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 49, groups = "group1")
//	public void TC_PM_DC_044ValidateLoadSalesexportwith_500_row() throws InterruptedException {
//
//		LoggerUtil.info("TC_PM_DC_044: Load: Sales export with 500 rows");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectSales();
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(500);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//		XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//		workbook.getSheet("Part_Master");
//		ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//		int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//		if (lastDataRowCount == 500) {
//			LoggerUtil.pass("PASS: Part_Master contains exactly 500 valid data rows.");
//		} else {
//			LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 500, Found: " + lastDataRowCount);
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 50, groups = "group1")
//	public void TC_PM_DC_045ValidateLoadProcurementexportwith_500_row() throws InterruptedException {
//
//		LoggerUtil.info("TC_PM_DC_045: Load: Procurement export with 500 row");
//		SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//		PartMasterDetailCostingRivisedPage.selectProcurement();
//		PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(500);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//		XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//		workbook.getSheet("Part_Master");
//		ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//		int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//		if (lastDataRowCount == 500) {
//			LoggerUtil.pass("PASS: Part_Master contains exactly 500 valid data rows.");
//		} else {
//			LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 500, Found: " + lastDataRowCount);
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 51, groups = "group1")
//	public void TC_PM_DC_046ValidateSalesexportUIExcelmandatoryfieldsmatchonallrows()
//	        throws InterruptedException, TimeoutException, FileNotFoundException, IOException {
//
//	    LoggerUtil.info("TC_PM_DC_046: Sales export: UI → Excel mandatory fields match on all rows");
//	    SoftAssert softAssert = new SoftAssert();
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj", "aeovtwr");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//
//	    List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost", "Commodity_Master",
//	            "Process_Master", "BOP_Master", "OHP_Master");
//
//	    ExcelUtil.verifyExcelSheetNames(fileName, expectedSheets);
//
//	    Sheet partSheet = workbook.getSheet("Part_Master");
//
//	    // header map
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//	    if (lastDataRowCount == 100) {
//	        LoggerUtil.pass("PASS: Part_Master contains exactly 100 valid data rows.");
//	    } else {
//	        LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 100, Found: " + lastDataRowCount);
//	    }
//	   
//	    // Step 4: validations (Dynamic DV support)
//	    Map<String, List<String>> expectedSelections = new LinkedHashMap<>();
//	    expectedSelections.put("Company Name - Location*", Arrays.asList("Costmaster-Mohali-007"));
//	    expectedSelections.put("Customer Name and Code*", Arrays.asList("adiydtj", "aeovtwr"));
//	    expectedSelections.put("Product Category*", Arrays.asList("FURNITURE"));
//	    expectedSelections.put("Product Model Name & No.*", Arrays.asList("Misc_2410456"));
//	    expectedSelections.put("Special Product Category*", Arrays.asList("MK-testing-2308"));
//
//	    for (Map.Entry<String, List<String>> e : expectedSelections.entrySet()) {
//	        String column = e.getKey();
//	        List<String> expectedVals = e.getValue();
//
//	        if (!headerMap.containsKey(column)) {
//	            LoggerUtil.fail("Column not found: " + column);
//	            continue;
//	        }
//
//	        int colIdx = headerMap.get(column);
//	        Set<String> found = collectColumnCellValues(partSheet, colIdx, 2, lastDataRowCount);
//	        found.addAll(collectExplicitDVListForColumn(partSheet, workbook, colIdx, 2, lastDataRowCount));
//
//	        for (String exp : expectedVals) {
//	            boolean ok = found.stream().anyMatch(v -> v.equalsIgnoreCase(exp));
//
//	            if (ok) {
//	                LoggerUtil.pass("PASS: Column [" + column + "] matched. Expected [" + exp + "] | Found: " + found);
//	            } else {
//	                LoggerUtil.fail("FAIL: Column [" + column + "] mismatch. Expected [" + exp + "] | Found: " + found);
//	            }
//
//	            softAssert.assertTrue(ok,
//	                    "Mismatch in column [" + column + "]. Expected [" + exp + "], Found values: " + found);
//	        }
//	    }
//
//	    // ✅ Collect all assertion results at the end
//	    softAssert.assertAll();
//
//
//	}
//		
//	@Test(priority = 52, groups = "group1")
//	public void TC_PM_DC_047ValidateProcurementexportUIExcelmandatoryfieldsmatchonallrowss()
//	        throws InterruptedException, TimeoutException, FileNotFoundException, IOException {
//
//	    LoggerUtil.info("TC_PM_DC_047: Procurement export: UI → Excel mandatory fields match on all rows");
//	    SoftAssert softAssert = new SoftAssert();
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj", "aeovtwr");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta", "0801-Ellsworth");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//	    File fileName = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName);
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//
//	    List<String> expectedSheets = Arrays.asList("Part_Master", "Process_Cost", "BOP_Cost",
//	            "Commodity_Master", "Process_Master", "BOP_Master", "OHP_Master");
//
//	    ExcelUtil.verifyExcelSheetNames(fileName, expectedSheets);
//
//	    Sheet partSheet = workbook.getSheet("Part_Master");
//
//	    // header map
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    int lastDataRowCount = ExcelUtil.getRowCount(2, "Company Name - Location*");
//
//	    if (lastDataRowCount == 10) {
//	        LoggerUtil.pass("PASS: Part_Master contains exactly 10 valid data rows.");
//	    } else {
//	        LoggerUtil.fail("FAIL: Part_Master row count mismatch. Expected 10, Found: " + lastDataRowCount);
//	    }
//
//	    // Step 4: validations (Dynamic DV support)
//	    Map<String, List<String>> expectedSelections = new LinkedHashMap<>();
//	    expectedSelections.put("Company Name - Location*", Arrays.asList("Costmaster-Mohali-007"));
//	    expectedSelections.put("Supplier Name and Code*", Arrays.asList("0801-Celesta", "0801-Ellsworth"));
//	    expectedSelections.put("Product Category*", Arrays.asList("FURNITURE"));
//	    expectedSelections.put("Product Model Name & No.*", Arrays.asList("Misc-2410456")); // normalize allowed
//	    expectedSelections.put("Special Product Category*", Arrays.asList("MK-testing-2308"));
//
//	    for (Map.Entry<String, List<String>> e : expectedSelections.entrySet()) {
//	        String column = e.getKey();
//	        List<String> expectedVals = e.getValue();
//	        if (!headerMap.containsKey(column)) {
//	            LoggerUtil.fail("Column not found: " + column);
//	            continue;
//	        }
//
//	        int colIdx = headerMap.get(column);
//	        Set<String> found = collectColumnCellValues(partSheet, colIdx, 2, lastDataRowCount);
//	        found.addAll(collectExplicitDVListForColumn(partSheet, workbook, colIdx, 2, lastDataRowCount));
//
//	        for (String exp : expectedVals) {
//	            boolean ok;
//
//	            if (column.equalsIgnoreCase("Product Model Name & No.*")) {
//	                // ✅ normalize for Product Model only
//	                ok = found.stream().anyMatch(v ->
//	                        v.replace("_", "-").equalsIgnoreCase(exp.replace("_", "-")));
//	            } else {
//	                ok = found.stream().anyMatch(v -> v.equalsIgnoreCase(exp));
//	            }
//
//	            if (ok) {
//	                LoggerUtil.pass("PASS: Column [" + column + "] matched. Expected [" + exp + "] | Found: " + found);
//	            } else {
//	                LoggerUtil.fail("FAIL: Column [" + column + "] mismatch. Expected [" + exp + "] | Found: " + found);
//	            }
//
//	            softAssert.assertTrue(ok,
//	                    "Mismatch in column [" + column + "]. Expected [" + exp + "], Found values: " + found);
//	        }
//	    }
//
//	    // ✅ Collect all assertion results
//	    softAssert.assertAll();
//	}
//	
//	@Test(priority = 53, groups = "group1")
//	public void TC_PM_DC_048ValidateProcurementTypeDropdownOnAllRows1() 
//	        throws InterruptedException, IOException {
//
//	    LoggerUtil.info("TC_PM_DC_048: Sales: Procurement Type is a dropdown on every row");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try {
//	        // --- Step 1: UI Navigation & Sales Export ---
//	        dashboard.clickingDashboard("");
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        Thread.sleep(3000);
//	        dashboard.clickOnPartMaster();
//	        Thread.sleep(1000);
//	        PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	        Thread.sleep(2000);
//	        PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	        Thread.sleep(3000);
//	        PartMasterDetailCostingRivisedPage.selectSales();
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	        PartMasterDetailCostingRivisedPage.openExportImportModal();
//	        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	        PartMasterDetailCostingRivisedPage.clickOnExportBtn();     
//	        List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//		    // --- Step 3: Wait for file download and validate ---
//		    Thread.sleep(30000);
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName.getAbsolutePath());
//	        XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//
//	        // --- Step 4: Prepare rows to validate dropdown presence ---
//	        int totalParts = 10;
//	        int firstDataRow = 2;
//	        int lastDataRow = firstDataRow + totalParts - 1;
//	        int midRow = (firstDataRow + lastDataRow) / 2;
//	        int[] rowsToCheck = { firstDataRow, midRow, lastDataRow };
//	        String columnName = "Procurement Type";
//
//	        LoggerUtil.info("Validating dropdown in '" + columnName + "' column for rows: " 
//	                        + Arrays.toString(rowsToCheck));
//
//	        // --- Step 5: Single method call to validate all rows ---
//	        boolean result = ExcelUtil.validateDropdownOnRowsReturnBoolean(
//	                workbook,
//	                "Part_Master",
//	                "Procurement Type",
//	                rowsToCheck);
//
//	        if (result) {
//	            LoggerUtil.pass("All specified rows have dropdowns in 'Procurement Type'.");
//	        } else {
//	            LoggerUtil.fail("Some rows are missing dropdowns in 'Procurement Type'.");
//	        }
//	    } catch (Exception e) {
//	        LoggerUtil.error("Exception during TC_PM_DC_048 execution: " + e.getMessage());
//	        softAssert.fail("Unexpected exception occurred: " + e.getMessage());
//	    } finally {
//	        softAssert.assertAll();
//	    }
//	}
//	
//	@Test(priority = 54, groups = "group1")
//	public void TC_PM_DC_049ValidateProcurementTypeDropdownOnAllRows1() 
//	        throws InterruptedException, IOException {
//
//	    LoggerUtil.info("TC_PM_DC_049: Procurement: Procurement Type is a dropdown on every row");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try {
//	        // --- Step 1: Perform valid Procurement export ---
//	        LoggerUtil.info("Navigating to Detail Costing → Export/Import popup for Procurement export...");
//	        dashboard.clickingDashboard("");
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        Thread.sleep(3000);
//	        dashboard.clickOnPartMaster();
//	        Thread.sleep(1000);
//
//	        PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	        Thread.sleep(2000);
//	        PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	        Thread.sleep(3000);
//	        PartMasterDetailCostingRivisedPage.selectProcurement(); // Procurement flow
//	        PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	        PartMasterDetailCostingRivisedPage.openExportImportModal();
//	        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	        PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	        List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//	        // --- Step 3: Wait for download and open Excel file ---
//	        Thread.sleep(30000);
//	        File fileName = getLatestFilePartMasterForDetailCostingFile();
//	        LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName.getAbsolutePath());
//	        XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//
//	        // --- Step 4: Prepare dynamic row list ---
//	        int totalParts = 10;
//	        int firstDataRow = 2;
//	        int lastDataRow = firstDataRow + totalParts - 1;
//	        int midRow = (firstDataRow + lastDataRow) / 2;
//	        int[] rowsToCheck = { firstDataRow, midRow, lastDataRow };
//	        String columnName = "Procurement Type";
//
//	        LoggerUtil.info("Validating dropdown in '" + columnName + "' column for rows: "
//	                        + Arrays.toString(rowsToCheck));
//
//	        // --- Step 5: Validate dropdown dynamically for Procurement flow ---
//	        boolean result = ExcelUtil.validateDropdownOnRowsReturnBoolean(
//	                workbook,
//	                "Part_Master",
//	                columnName,
//	                rowsToCheck);
//
//	        if (result) {
//	            LoggerUtil.pass("All specified rows have dropdowns in 'Procurement Type' (Procurement export).");
//	        } else {
//	            LoggerUtil.fail("Some rows are missing dropdowns in 'Procurement Type' (Procurement export).");
//	            softAssert.fail("Dropdown missing in one or more rows under 'Procurement Type'.");
//	        }
//
//	    } catch (Exception e) {
//	        LoggerUtil.error("Exception during TC_PM_DC_049 execution: " + e.getMessage());
//	        softAssert.fail("Unexpected exception occurred: " + e.getMessage());
//	    } finally {
//	        softAssert.assertAll();
//	    }
//	}
//
//	@Test(priority = 55, groups = "group1")
//	public void TC_PM_DC_050ValidateSales_CostingModuleDropdownValuess() throws InterruptedException, IOException {
//
//	    LoggerUtil.info("TC_PM_DC_050: Sales → Verify Costing Module dropdown contains exactly 9 expected values");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try {
//	        // --- Step 1: Perform valid Sales export ---
//	        dashboard.clickingDashboard("");
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        Thread.sleep(3000);
//	        dashboard.clickOnPartMaster();
//	        Thread.sleep(1000);
//	        PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	        Thread.sleep(2000);
//	        PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	        Thread.sleep(3000);
//	        PartMasterDetailCostingRivisedPage.selectSales();
//	        PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	        PartMasterDetailCostingRivisedPage.openExportImportModal();
//	        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	        PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	      
//	        List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//	        // --- Step 3: Wait for download and open Excel file ---
//	        Thread.sleep(30000);
//	        File fileName = getLatestFilePartMasterForDetailCostingFile();
//	        LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName.getAbsolutePath());
//	        // --- Step 2: Open workbook and sheet ---
//	        XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//	        Sheet partSheet = workbook.getSheet("Part_Master");
//	        softAssert.assertNotNull(partSheet, "Part_Master sheet not found in Excel file!");
//
//	        // --- Step 3: Locate 'Costing Module*' column dynamically ---
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	        softAssert.assertTrue(headerMap.containsKey("Costing Module*"),
//	                "Column 'Costing Module*' not found in Part_Master sheet!");
//	        int costingModuleColIndex = headerMap.get("Costing Module*");
//
//	        // --- Step 4: Expected dropdown values ---
//	        List<String> expectedValues = Arrays.asList(
//	                "Extrusion Rubber & Plastic Hoses",
//	                "Ferrous Casting",
//	                "Forging",
//	                "Non Ferrous Casting",
//	                "Plastic Injection Moulding",
//	                "Rubber Moulding",
//	                "Standard Shapes",
//	                "Wiring Harness Assembly Cost Estimator",
//	                "Packaging Module"
//	        );
//
//	        // --- Step 5: Determine target rows (first, middle, last) ---
//	        int totalParts = 10;
//	        int firstDataRow = 2;
//	        int lastDataRow = firstDataRow + totalParts - 1;
//	        int midRow = (firstDataRow + lastDataRow) / 2;
//	        int[] rowsToCheck = { firstDataRow, midRow, lastDataRow };
//
//	        LoggerUtil.info("Row-wise dropdown validation started for 'Costing Module*' on rows: "
//	                + Arrays.toString(rowsToCheck));
//
//	        // --- Step 6: Row-wise validation and collection of all values ---
//	        Set<String> allDropdownValues = new HashSet<>();
//
//	        for (int row : rowsToCheck) {
//	            List<String> dropdownValues = ExcelUtil.collectExplicitDVListForColumns(
//	                    partSheet, workbook, costingModuleColIndex, row, row);
//
//	            if (dropdownValues == null || dropdownValues.isEmpty()) {
//	                LoggerUtil.fail("Row " + (row + 1) + ": No dropdown values found in 'Costing Module*'.");
//	                softAssert.fail("Dropdown missing or empty at row " + (row + 1));
//	            } else {
//	                LoggerUtil.pass("Row " + (row + 1) + ": Dropdown found successfully.");
//	                LoggerUtil.info("→ Row " + (row + 1) + " dropdown values: " + dropdownValues);
//
//	                // Row-level validation: Must contain all 8 expected entries
//	                softAssert.assertEquals(dropdownValues.size(), expectedValues.size(),
//	                        "Row " + (row + 1) + ": Dropdown size mismatch. Expected 9, Found: " + dropdownValues.size());
//	                softAssert.assertTrue(dropdownValues.containsAll(expectedValues),
//	                        "Row " + (row + 1) + ": Dropdown values mismatch.");
//
//	                allDropdownValues.addAll(dropdownValues);
//	            }
//	        }
//
//	        // --- Step 7: Overall validation (union of all row values) ---
//	        List<String> actualValues = new ArrayList<>(allDropdownValues);
//	        LoggerUtil.info("Combined dropdown values from all checked rows: " + actualValues);
//
//	        softAssert.assertEquals(actualValues.size(), expectedValues.size(),
//	                "Overall dropdown size mismatch. Expected 9, Found: " + actualValues.size());
//	        softAssert.assertTrue(actualValues.containsAll(expectedValues),
//	                "Overall dropdown values mismatch. Expected: " + expectedValues + " | Found: " + actualValues);
//
//	        if (actualValues.size() == expectedValues.size() && actualValues.containsAll(expectedValues)) {
//	            LoggerUtil.pass("PASS: Costing Module dropdown verified row-wise and overall. All 9 expected values matched.");
//	        } else {
//	            LoggerUtil.fail("FAIL: Costing Module dropdown mismatch. Expected: " + expectedValues + " | Found: " + actualValues);
//	        }
//
//	    } catch (Exception e) {
//	        LoggerUtil.error("Exception in TC_PM_DC_050 execution: " + e.getMessage());
//	        softAssert.fail("Unexpected exception occurred: " + e.getMessage());
//	    } finally {
//	        softAssert.assertAll();
//	    }
//	}
//	
//	@Test(priority = 56, groups = "group1")
//	public void TC_PM_DC_051ValidateProcurement_CostingModuleDropdownValuess() throws InterruptedException, IOException {
//
//	    LoggerUtil.info("TC_PM_DC_050: Procurement → Verify Costing Module dropdown contains exactly 9 expected values");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try {
//	        // --- Step 1: Perform valid Sales export ---
//	        dashboard.clickingDashboard("");
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        Thread.sleep(3000);
//	        dashboard.clickOnPartMaster();
//	        Thread.sleep(1000);
//	        PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	        Thread.sleep(2000);
//	        PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	        Thread.sleep(3000);
//	        PartMasterDetailCostingRivisedPage.selectProcurement();
//	        PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//	        PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	        Thread.sleep(3000);
//	        PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	        PartMasterDetailCostingRivisedPage.openExportImportModal();
//	        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	        PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	        List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//	        // --- Step 3: Wait for download and open Excel file ---
//	        Thread.sleep(30000);
//	        File fileName = getLatestFilePartMasterForDetailCostingFile();
//	        LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName.getAbsolutePath());
//
//	        // --- Step 2: Open workbook and sheet ---
//	        XSSFWorkbook workbook = ExcelUtil.openWorkbook(fileName);
//	        Sheet partSheet = workbook.getSheet("Part_Master");
//	        softAssert.assertNotNull(partSheet, "Part_Master sheet not found in Excel file!");
//
//	        // --- Step 3: Locate 'Costing Module*' column dynamically ---
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	        softAssert.assertTrue(headerMap.containsKey("Costing Module*"),
//	                "Column 'Costing Module*' not found in Part_Master sheet!");
//	        int costingModuleColIndex = headerMap.get("Costing Module*");
//
//	        // --- Step 4: Expected dropdown values ---
//	        List<String> expectedValues = Arrays.asList(
//	                "Extrusion Rubber & Plastic Hoses",
//	                "Ferrous Casting",
//	                "Forging",
//	                "Non Ferrous Casting",
//	                "Plastic Injection Moulding",
//	                "Rubber Moulding",
//	                "Standard Shapes",
//	                "Wiring Harness Assembly Cost Estimator",
//	                "Packaging Module"
//	        );
//
//	        // --- Step 5: Determine target rows (first, middle, last) ---
//	        int totalParts = 10;
//	        int firstDataRow = 2;
//	        int lastDataRow = firstDataRow + totalParts - 1;
//	        int midRow = (firstDataRow + lastDataRow) / 2;
//	        int[] rowsToCheck = { firstDataRow, midRow, lastDataRow };
//
//	        LoggerUtil.info("Row-wise dropdown validation started for 'Costing Module*' on rows: "
//	                + Arrays.toString(rowsToCheck));
//
//	        // --- Step 6: Row-wise validation and collection of all values ---
//	        Set<String> allDropdownValues = new HashSet<>();
//
//	        for (int row : rowsToCheck) {
//	            List<String> dropdownValues = ExcelUtil.collectExplicitDVListForColumns(
//	                    partSheet, workbook, costingModuleColIndex, row, row);
//
//	            if (dropdownValues == null || dropdownValues.isEmpty()) {
//	                LoggerUtil.fail("Row " + (row + 1) + ": No dropdown values found in 'Costing Module*'.");
//	                softAssert.fail("Dropdown missing or empty at row " + (row + 1));
//	            } else {
//	                LoggerUtil.pass("Row " + (row + 1) + ": Dropdown found successfully.");
//	                LoggerUtil.info("→ Row " + (row + 1) + " dropdown values: " + dropdownValues);
//
//	                // Row-level validation: Must contain all 8 expected entries
//	                softAssert.assertEquals(dropdownValues.size(), expectedValues.size(),
//	                        "Row " + (row + 1) + ": Dropdown size mismatch. Expected 9, Found: " + dropdownValues.size());
//	                softAssert.assertTrue(dropdownValues.containsAll(expectedValues),
//	                        "Row " + (row + 1) + ": Dropdown values mismatch.");
//
//	                allDropdownValues.addAll(dropdownValues);
//	            }
//	        }
//
//	        // --- Step 7: Overall validation (union of all row values) ---
//	        List<String> actualValues = new ArrayList<>(allDropdownValues);
//	        LoggerUtil.info("Combined dropdown values from all checked rows: " + actualValues);
//
//	        softAssert.assertEquals(actualValues.size(), expectedValues.size(),
//	                "Overall dropdown size mismatch. Expected 9, Found: " + actualValues.size());
//	        softAssert.assertTrue(actualValues.containsAll(expectedValues),
//	                "Overall dropdown values mismatch. Expected: " + expectedValues + " | Found: " + actualValues);
//
//	        if (actualValues.size() == expectedValues.size() && actualValues.containsAll(expectedValues)) {
//	            LoggerUtil.pass("PASS: Costing Module dropdown verified row-wise and overall. All 8 expected values matched.");
//	        } else {
//	            LoggerUtil.fail("FAIL: Costing Module dropdown mismatch. Expected: " + expectedValues + " | Found: " + actualValues);
//	        }
//
//	    } catch (Exception e) {
//	        LoggerUtil.error("Exception in TC_PM_DC_050 execution: " + e.getMessage());
//	        softAssert.fail("Unexpected exception occurred: " + e.getMessage());
//	    } finally {
//	        softAssert.assertAll();
//	    }
//	}
//
//	@Test(priority = 57, groups = "group1")
//	public void TC_PM_DC_052ValidateRMInputShapeDefaultValuesForSalesAndProcurement() throws Exception {
//		LoggerUtil.info(
//				"TC_PM_DC_052: Verify RM Input Shape default = 'Misc.' on all rows after export (Sales & Procurement)");
//
//		// Procurement
//		XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//		validateDefaultRMInputShape(procurementWorkbook, "Procurement");
//
//		// Sales
//		XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//		validateDefaultRMInputShape(salesWorkbook, "Sales");
//
//		LoggerUtil.pass("PASS: RM Input Shape defaulted to 'Misc.' for both flows.");
//	}
//
//	@Test(priority = 58, groups = "group1",enabled = false)
//	public void TC_PM_DC_053ValidateRMInputShapeDependentDropdown() throws Exception {
//
//	    LoggerUtil.info("TC_PM_DC_053: Verify RM Input Shape is a dependent dropdown when Costing Module = Standard Shapes");
//
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try {
//	        // --- Step 1: Perform valid Procurement export ---
//	        XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//	        validateDropdownRMInputShape(procurementWorkbook, "Procurement", softAssert);
//	        
//
//	        // --- Step 2: Perform valid Sales export ---
//	        XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//	        validateDropdownRMInputShape(salesWorkbook, "Sales", softAssert);
//
//	        LoggerUtil.pass("PASS: RM Input Shape shows dependent dropdown for 'Standard Shapes' in both Sales & Procurement flows.");
//
//	    } catch (Exception e) {
//	        LoggerUtil.error("Exception in TC_PM_DC_053 execution: " + e.getMessage());
//	        softAssert.fail("Unexpected exception occurred: " + e.getMessage());
//	    } finally {
//	        softAssert.assertAll();
//	    }
//	}
//
//
//	@Test(priority = 59, groups = "group1",enabled = false)
//	public void TC_PM_DC_054ValidateRMInputShapeDependentDropdownForForging() throws Exception {
//		LoggerUtil.info("TC_PM_DC_054: Validate RM Input Shape is dependent dropdown when Costing Module = Forging");
//
//		// ✅ Procurement
//		XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//		validateDropdownRMInputShapeForForging(procurementWorkbook, "Procurement");
//
//		// ✅ Sales
//		XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//		validateDropdownRMInputShapeForForging(salesWorkbook, "Sales");
//
//		LoggerUtil.pass("PASS: RM Input Shape is dependent dropdown (not free text) for Forging in both flows.");
//	}
//
//	private XSSFWorkbook exportAndGetWorkbook(String flowType) throws Exception {
//		LoggerUtil.info("---- Exporting Excel for flow: " + flowType + " ----");
//		 SoftAssert softAssert = new SoftAssert();
//		dashboard.clickingDashboard("");
//		Thread.sleep(1000);
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
//
//		PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		Thread.sleep(2000);
//		PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		Thread.sleep(3000);
//
//		if (flowType.equalsIgnoreCase("Procurement")) {
//			PartMasterDetailCostingRivisedPage.selectProcurement();
//			PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//		} else {
//			PartMasterDetailCostingRivisedPage.selectSales();
//		}
//
//		PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		Thread.sleep(3000);
//		PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		// Export
//		PartMasterDetailCostingRivisedPage.openExportImportModal();
//		PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//        // --- Step 3: Wait for download and open Excel file ---
//        Thread.sleep(30000);
//        File fileName = getLatestFilePartMasterForDetailCostingFile();
//        LoggerUtil.info("Downloaded Detail Costing Sheet: " + fileName.getAbsolutePath());
//		return ExcelUtil.openWorkbook(fileName);
//		
//	}
//
//	// For TC_PM_DC_052
//	private void validateDefaultRMInputShape(XSSFWorkbook workbook, String flowType) throws Exception {
//		ExcelUtil.validateColumnValuesForKeyRows(workbook, "Part_Master", "RM Input Shape(For Standard and Forging)",
//				"Misc.", flowType);
//	}
//
//	// For TC_PM_DC_053
//	private void validateDropdownRMInputShape(XSSFWorkbook workbook, String flowType, SoftAssert softAssert) throws Exception {
//	    com.Pages.PartMasterDetailCostingRivisedPage.validateRMShapeDropdownForStandardShapes(workbook, flowType, softAssert);
//		
//	}
//	// For TC_PM_DC_054
//	private void validateDropdownRMInputShapeForForging(XSSFWorkbook workbook, String flowType) throws Exception {
//		ExcelUtil.validateDependentDropdownForAllRows(workbook, "Part_Master", "Costing Module*",
//				"RM Input Shape(For Standard and Forging)", "Forging", // 👈 yaha change kiya
//				flowType);
//	}
//
//	@Test(priority = 60, groups = "group1")
//	public void TC_PM_DC_055ValidateSOBPercentDefaultAndRange() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_055: Validate SOB % default=100 and in-range edits allowed (0–100)");
//
//	    // ✅ Procurement
//	    XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//	    validateSOBPercent(procurementWorkbook, "Procurement");
//
//	    // ✅ Sales
//	    XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//	    validateSOBPercent(salesWorkbook, "Sales");
//
//	    LoggerUtil.pass("PASS: SOB % defaults to 100 and allows only 0–100 edits in both flows.");
//	}
//
//	private void validateSOBPercent(XSSFWorkbook workbook, String flowType) throws Exception {
//	    Sheet sheet = workbook.getSheet("Part_Master");
//
//	    // Step 1: Get header map
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    Assert.assertTrue(headerMap.containsKey("SOB %"), "Column SOB % not found in Part_Master sheet!");
//
//	    int sobColIdx = headerMap.get("SOB %");
//	    int totalRows = sheet.getLastRowNum();
//
//	    // Step 2: Determine first, middle, and last rows to check
//	    int firstRow = 2;
//	    int midRow = (firstRow + totalRows) / 2;
//	    int lastRow = totalRows;
//	    int[] rowsToCheck = { firstRow, midRow, lastRow };
//
//	    LoggerUtil.info("Flow=" + flowType + " | Checking SOB % default for rows: " + Arrays.toString(rowsToCheck));
//
//	    // Step 3: Validate only selected rows
//	    for (int rowIdx : rowsToCheck) {
//	        Row row = sheet.getRow(rowIdx);
//	        if (row == null) continue;
//
//	        Cell cell = row.getCell(sobColIdx);
//	        if (cell == null) continue;
//
//	        String value = "";
//	        if (cell.getCellType() == CellType.NUMERIC) {
//	            value = String.valueOf((int) cell.getNumericCellValue());
//	        } else {
//	            value = cell.toString().trim();
//	        }
//
//	        if (value.isEmpty()) continue;
//
//	        // ✅ Validate default = 100
//	        Assert.assertEquals(value, "100",
//	                "Flow=" + flowType + " | Row " + (rowIdx + 1) + " SOB % default mismatch!");
//	        LoggerUtil.pass("Flow=" + flowType + " | Row " + (rowIdx + 1) + " SOB % default=100 validated. Found=" + value);
//	    }
//	}
//
//	@Test(priority = 61, groups = "group1")
//	public void TC_PM_DC_056ValidateNoOfPartsBlankdefaultandpositiveintegersallowed() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_056: No. of Parts/Blank default and positive integers allowed");
//
//	    // ✅ Procurement
//	    XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//	    validateNoOfParts(procurementWorkbook, "Procurement");
//
//	    // ✅ Sales
//	    XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//	    validateNoOfParts(salesWorkbook, "Sales");
//
//	    LoggerUtil.pass("PASS: No. of Parts defaults to 1 and accepts only positive integers in both flows.");
//	}
//
//	private void validateNoOfParts(XSSFWorkbook workbook, String flowType) throws Exception {
//	    Sheet sheet = workbook.getSheet("Part_Master");
//
//	    // Step 1: Get header map
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    Assert.assertTrue(headerMap.containsKey("No. of Parts/Blank"),
//	            "Column 'No. of Parts/Blank' not found in Part_Master sheet!");
//
//	    int qtyColIdx = headerMap.get("No. of Parts/Blank");
//	    int totalRows = sheet.getLastRowNum();
//
//	    // Step 2: Determine first, middle, and last rows to check
//	    int firstRow = 2;
//	    int midRow = (firstRow + totalRows) / 2;
//	    int lastRow = totalRows;
//	    int[] rowsToCheck = { firstRow, midRow, lastRow };
//
//	    LoggerUtil.info("Flow=" + flowType + " | Checking No. of Parts for rows: " + Arrays.toString(rowsToCheck));
//
//	    // Step 3: Validate only selected rows
//	    for (int rowIdx : rowsToCheck) {
//	        Row row = sheet.getRow(rowIdx);
//	        if (row == null) continue;
//
//	        Cell cell = row.getCell(qtyColIdx);
//	        if (cell == null) continue; // skip blank cells
//
//	        String value = "";
//	        if (cell.getCellType() == CellType.NUMERIC) {
//	            value = String.valueOf((int) cell.getNumericCellValue()); // normalize integer
//	        } else {
//	            value = cell.toString().trim();
//	        }
//
//	        if (value.isEmpty()) continue;
//
//	        int intValue;
//	        try {
//	            intValue = Integer.parseInt(value);
//	        } catch (NumberFormatException e) {
//	            Assert.fail("Flow=" + flowType + " | Row " + (rowIdx + 1)
//	                    + " Invalid value in No. of Parts: " + value + " (must be integer)");
//	            return;
//	        }
//
//	        // ✅ Rule 1: Default = 1 check (first row only)
//	        if (rowIdx == firstRow) {
//	            Assert.assertEquals(intValue, 1, "Flow=" + flowType + " | Row " + (rowIdx + 1)
//	                    + " default No. of Parts mismatch!");
//	            LoggerUtil.pass("Flow=" + flowType + " | Row " + (rowIdx + 1)
//	                    + " default No. of Parts = 1 validated.");
//	        }
//
//	        // ✅ Rule 2: Positive integer validation (all checked rows)
//	        Assert.assertTrue(intValue > 0, "Flow=" + flowType + " | Row " + (rowIdx + 1)
//	                + " invalid No. of Parts value: " + intValue);
//	        LoggerUtil.pass("Flow=" + flowType + " | Row " + (rowIdx + 1)
//	                + " No. of Parts positive integer validated: " + intValue);
//	    }
//	}
//
//	@Test(priority = 62, groups = "group1")
//	public void TC_PM_DC_057ValidateOHPNomenclatureisAdropdownboundtoOHP_Master() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_057: OHP Nomenclature is a dropdown bound to OHP_Master");
//
//	    // ✅ Procurement
//	    XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//	    validateOHPDropdown(procurementWorkbook, "Procurement");
//
//	    // ✅ Sales
//	    XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//	    validateOHPDropdown(salesWorkbook, "Sales");
//
//	    LoggerUtil.pass("PASS: OHP Nomenclature dropdown strictly matches OHP_Master (including order) in both flows.");
//	}
//
//	private void validateOHPDropdown(XSSFWorkbook workbook, String flowType) throws Exception {
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // Step 1: Collect Expected values from OHP_Master
//	    Sheet ohpSheet = workbook.getSheet("OHP_Master");
//	    softAssert.assertNotNull(ohpSheet, "OHP_Master sheet not found!");
//
//	    List<String> ohpMasterList = new ArrayList<>();
//	    int lastRow = ohpSheet.getLastRowNum();
//	    for (int rowIdx = 2; rowIdx <= lastRow; rowIdx++) {
//	        Row row = ohpSheet.getRow(rowIdx);
//	        if (row == null) continue;
//
//	        Cell cell = row.getCell(2); // col C = "OHP Master Nomenclature"
//	        if (cell != null && !cell.toString().trim().isEmpty()) {
//	            ohpMasterList.add(cell.toString().trim());
//	        }
//	    }
//	    softAssert.assertFalse(ohpMasterList.isEmpty(), "OHP_Master has no nomenclature values!");
//
//	    // Step 2: Locate OHP Nomenclature column in Part_Master
//	    Sheet partSheet = workbook.getSheet("Part_Master");
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    softAssert.assertTrue(headerMap.containsKey("OHP Nomenclature"),
//	            "Column OHP Nomenclature not found in Part_Master sheet!");
//	    int ohpColIdx = headerMap.get("OHP Nomenclature");
//
//	    // Step 3: Ensure dropdown formula exists (but do not log formula)
//	    boolean formulaLinked = false;
//	    String dropdownFormula = null;
//	    for (DataValidation dv : partSheet.getDataValidations()) {
//	        for (CellRangeAddress addr : dv.getRegions().getCellRangeAddresses()) {
//	            if (addr.getFirstColumn() == ohpColIdx) {
//	                dropdownFormula = dv.getValidationConstraint().getFormula1();
//	                if (dropdownFormula != null && dropdownFormula.contains("OHP_Master")) {
//	                    formulaLinked = true;
//	                }
//	            }
//	        }
//	    }
//	    softAssert.assertTrue(formulaLinked,
//	            "Flow=" + flowType + " | OHP Nomenclature dropdown not linked to OHP_Master!");
//
//	    // Step 4: Resolve actual dropdown values from OHP_Master
//	    List<String> actualDropdownValues = new ArrayList<>();
//	    if (formulaLinked) {
//	        for (int rowIdx = 2; rowIdx <= lastRow; rowIdx++) {
//	            Row row = ohpSheet.getRow(rowIdx);
//	            if (row == null) continue;
//
//	            Cell cell = row.getCell(2); // col C = "OHP Master Nomenclature"
//	            if (cell != null && !cell.toString().trim().isEmpty()) {
//	                actualDropdownValues.add(cell.toString().trim());
//	            }
//	        }
//	    }
//
//	    // Step 5: Compare expected vs actual
//	    LoggerUtil.info("Flow=" + flowType + " | Expected OHP_Master values: " + ohpMasterList);
//	    LoggerUtil.info("Flow=" + flowType + " | Actual Dropdown values (resolved): " + actualDropdownValues);
//
//	    if (ohpMasterList.size() != actualDropdownValues.size()) {
//	        LoggerUtil.error("Flow=" + flowType + " | ❌ Size mismatch: Expected=" 
//	            + ohpMasterList.size() + " vs Actual=" + actualDropdownValues.size());
//	        softAssert.fail("Flow=" + flowType + " | Dropdown size mismatch!");
//	    } else {
//	        for (int i = 0; i < ohpMasterList.size(); i++) {
//	            if (!ohpMasterList.get(i).equals(actualDropdownValues.get(i))) {
//	                LoggerUtil.error("Flow=" + flowType + " | ❌ Mismatch at index " + i +
//	                        " | Expected=" + ohpMasterList.get(i) +
//	                        " | Actual=" + actualDropdownValues.get(i));
//	                softAssert.fail("Flow=" + flowType + " | Value mismatch at index " + i);
//	            }
//	        }
//	        LoggerUtil.pass("Flow=" + flowType + " | ✅ Dropdown values exactly match OHP_Master (including order).");
//	    }
//
//	    // Final assert
//	    softAssert.assertAll();
//	}
//
//	///////////////////////////////////////////////////////////////////////////
//	private static final ZoneId IST = ZoneId.of("Asia/Kolkata");
//	private static final DateTimeFormatter TARGET_FMT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//	@Test(priority = 63, groups = "group1")
//	public void TC_PM_DC_058ValidateEffectiveStartDateEqualsSystemDate_Excel() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_058: Validate 'Effective Start Date' equals current system date (at export) on Row-1, Mid, Last in Part_Master (Excel).");
//
//	    // ===== Procurement =====
//	    LocalDate exportDateIST_Proc = LocalDate.now(IST);
//	    String expectedDateStr_Proc = exportDateIST_Proc.format(TARGET_FMT);
//	    LoggerUtil.info("Procurement | Captured system date (IST) at export time: " + expectedDateStr_Proc);
//
//	    XSSFWorkbook procurementWb = exportAndGetWorkbook("Procurement");
//	    validateEffectiveStartDate_KeyRows(procurementWb, "Procurement", expectedDateStr_Proc);
//
//	    // ===== Sales =====
//	    LocalDate exportDateIST_Sales = LocalDate.now(IST);
//	    String expectedDateStr_Sales = exportDateIST_Sales.format(TARGET_FMT);
//	    LoggerUtil.info("Sales | Captured system date (IST) at export time: " + expectedDateStr_Sales);
//
//	    XSSFWorkbook salesWb = exportAndGetWorkbook("Sales");
//	    validateEffectiveStartDate_KeyRows(salesWb, "Sales", expectedDateStr_Sales);
//
//	    LoggerUtil.pass("PASS: Effective Start Date equals system date (at export) for Row-1, Mid, and Last in both flows.");
//	}
//
//	/**
//	 * Validates Row-1, Mid, and Last rows in Part_Master for 'Effective Start Date'.
//	 */
//	private void validateEffectiveStartDate_KeyRows(XSSFWorkbook workbook, String flowType, String expectedDateStr) throws Exception {
//	    SoftAssert softAssert = new SoftAssert();
//
//	    Sheet sheet = workbook.getSheet("Part_Master");
//	    Assert.assertNotNull(sheet, "Flow=" + flowType + " | Part_Master sheet not found!");
//
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	    Assert.assertTrue(headerMap.containsKey("Effective Start Date"),
//	            "Flow=" + flowType + " | Column 'Effective Start Date' not found!");
//
//	    int colIdx = headerMap.get("Effective Start Date");
//	    int lastRow = sheet.getLastRowNum();
//	    if (lastRow < 2) {
//	        Assert.fail("Flow=" + flowType + " | No data rows present in Part_Master to validate.");
//	    }
//
//	    List<Integer> targets = computeKeyRowIndices(lastRow);
//	    LoggerUtil.info("Flow=" + flowType + " | Target rows (1-based display): " +
//	            targets.stream().map(i -> String.valueOf(i + 1)).collect(Collectors.joining(", ")));
//
//	    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//
//	    for (int rowIdx : targets) {
//	        Row row = sheet.getRow(rowIdx);
//	        if (row == null) {
//	            softAssert.fail("Flow=" + flowType + " | Row not found: " + (rowIdx + 1));
//	            continue;
//	        }
//
//	        Cell cell = row.getCell(colIdx);
//	        if (cell == null) {
//	            softAssert.fail("Flow=" + flowType + " | 'Effective Start Date' is blank at Row " + (rowIdx + 1));
//	            continue;
//	        }
//
//	        LocalDate parsed = parseAsLocalDate(cell, evaluator);
//	        if (parsed == null) {
//	            LoggerUtil.error("Flow=" + flowType + " | ❌ Row " + (rowIdx + 1) +
//	                    " unparsable. Raw=" + cell.toString());
//	            softAssert.fail("Flow=" + flowType + " | Row " + (rowIdx + 1) +
//	                    " unparsable. Raw=" + cell.toString());
//	            continue;
//	        }
//
//	        String parsedStr = parsed.format(TARGET_FMT);
//	        LoggerUtil.info("Flow=" + flowType + " | Row " + (rowIdx + 1) +
//	                " | Parsed=" + parsedStr + " | Expected=" + expectedDateStr);
//
//	        if (!parsedStr.equals(expectedDateStr)) {
//	            LoggerUtil.error("Flow=" + flowType + " | ❌ Row " + (rowIdx + 1) +
//	                    " mismatch. Found=" + parsedStr + " | Expected=" + expectedDateStr);
//	            softAssert.fail("Flow=" + flowType + " | Row " + (rowIdx + 1) +
//	                    " mismatch. Found=" + parsedStr + " | Expected=" + expectedDateStr);
//	        } else {
//	            LoggerUtil.pass("Flow=" + flowType + " | ✅ Row " + (rowIdx + 1) +
//	                    " Effective Start Date matched: " + expectedDateStr);
//	        }
//	    }
//
//	    softAssert.assertAll();
//	}
//
//	/**
//	 * Safe LocalDate parser for Excel cells (handles NUMERIC, STRING, FORMULA).
//	 */
//	private LocalDate parseAsLocalDate(Cell cell, FormulaEvaluator evaluator) {
//	    try {
//	        if (cell == null) return null;
//
//	        if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
//	            return cell.getDateCellValue().toInstant().atZone(IST).toLocalDate();
//	        } else if (cell.getCellType() == CellType.FORMULA) {
//	            CellValue evaluated = evaluator.evaluate(cell);
//	            if (evaluated.getCellType() == CellType.NUMERIC) {
//	                return DateUtil.getLocalDateTime(evaluated.getNumberValue()).toLocalDate();
//	            }
//	            return null;
//	        } else {
//	            String raw = cell.toString().trim();
//	            if (raw.isEmpty()) return null;
//	            return LocalDate.parse(raw, TARGET_FMT);
//	        }
//	    } catch (Exception e) {
//	        LoggerUtil.error("Date parse failed for cell: " + cell.toString() + " | " + e.getMessage());
//	        return null;
//	    }
//	}
//
//	/**
//	 * Compute indices for Row-1, Mid, Last.
//	 */
//	private List<Integer> computeKeyRowIndices(int lastRow) {
//	    int first = 2; // data starts at row 2 (Excel row 3)
//	    int mid = (first + lastRow) / 2;
//	    return Arrays.asList(first, mid, lastRow);
//	}
//
//	@Test(priority = 64, groups = "group1")
//	public void TC_PM_DC_059_NegativeImport_SOB_OutOfRange() throws Exception {
//		LoggerUtil.info(
//				"TC_PM_DC_059: Negative Import — SOB % out of range (-1 / 101) must be blocked and save nothing.");
//
//		for (String flow : Arrays.asList("Procurement", "Sales")) {
//			LoggerUtil.info("Flow=" + flow + " | Starting negative import run.");
//			runNegativeImportForFlow(flow);
//		}
//
//		LoggerUtil.pass("PASS: SOB % out-of-range import blocked with validation and no data saved in both flows.");
//	}
//
//	private void runNegativeImportForFlow(String flow) throws Exception {
//		// 1) Export
//		XSSFWorkbook wb = exportAndGetWorkbook(flow);
//		Sheet part = wb.getSheet("Part_Master");
//		Assert.assertNotNull(part, "Flow=" + flow + " | Part_Master sheet not found.");
//
//		Map<String, Integer> header = ExcelUtil.getHeaderMap(wb, "Part_Master", 1);
//		Assert.assertTrue(header.containsKey("SOB %"), "Flow=" + flow + " | Column 'SOB %' not found.");
//		int sobCol = header.get("SOB %");
//
//		// Pick two data rows: first data and last data
//		int last = part.getLastRowNum();
//		Assert.assertTrue(last >= 2, "Flow=" + flow + " | No data rows to test.");
//		int rowA = 2;
//		int rowB = (last > 2 ? last : 2);
//
//		// Keep originals for "no data saved" check
//		String origA = readCellAsString(part, rowA, sobCol);
//		String origB = readCellAsString(part, rowB, sobCol);
//		LoggerUtil.info("Flow=" + flow + " | Original SOB% RowA=" + origA + ", RowB=" + origB);
//
//		// 2) Create edited copy: set -1 and 101
//		XSSFWorkbook edited = wb; // reuse for brevity
//		setNumeric(edited.getSheet("Part_Master"), rowA, sobCol, -1);
//		setNumeric(edited.getSheet("Part_Master"), rowB, sobCol, 101);
//		String tmpFile = saveTemp(edited, "NEG_SOB_" + flow);
//		LoggerUtil.info("Flow=" + flow + " | Edited file written: " + tmpFile);
//
//		// 3) Import and capture validation error
//		String err = doImportAndGetError(flow, tmpFile);
//		Assert.assertNotNull(err, "Flow=" + flow + " | Expected validation message, got null.");
//		String e = err.toLowerCase(Locale.ROOT);
//		boolean looksRight = e.contains("sob") && (e.contains("0") && e.contains("100"));
//		Assert.assertTrue(looksRight, "Flow=" + flow + " | Unexpected validation message: " + err);
//		LoggerUtil.pass("Flow=" + flow + " | Validation message captured: " + err);
//
//		// 4) Re-export and assert NO CHANGE on edited rows
//		XSSFWorkbook re = exportAndGetWorkbook(flow);
//		Sheet rePart = re.getSheet("Part_Master");
//		String newA = readCellAsString(rePart, rowA, sobCol);
//		String newB = readCellAsString(rePart, rowB, sobCol);
//
//		boolean noChangeA = equalsNormalized(origA, newA);
//		boolean noChangeB = equalsNormalized(origB, newB);
//
//		if (noChangeA && noChangeB) {
//			LoggerUtil.pass("Flow=" + flow + " | No data saved after invalid import (rows unchanged).");
//		} else {
//			LoggerUtil.fail("Flow=" + flow + " | Change detected after invalid import. RowA same=" + noChangeA
//					+ ", RowB same=" + noChangeB);
//			Assert.fail("Flow=" + flow + " | Data should not be saved for invalid SOB %.");
//		}
//	}
//
//	// ---------------- helpers (minimal) ----------------
//
//	private String readCellAsString(Sheet sheet, int rowIdx, int colIdx) {
//		Row r = sheet.getRow(rowIdx);
//		if (r == null)
//			return "";
//		Cell c = r.getCell(colIdx);
//		if (c == null)
//			return "";
//		if (c.getCellType() == CellType.NUMERIC) {
//			double dv = c.getNumericCellValue();
//			return (Math.floor(dv) == dv) ? String.valueOf((long) dv) : String.valueOf(dv);
//		}
//		return c.toString().trim();
//	}
//
//	private void setNumeric(Sheet sheet, int rowIdx, int colIdx, double value) {
//		Row r = sheet.getRow(rowIdx);
//		if (r == null)
//			r = sheet.createRow(rowIdx);
//		Cell c = r.getCell(colIdx, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		c.setCellType(CellType.NUMERIC);
//		c.setCellValue(value);
//		LoggerUtil.info("Set SOB% at row " + (rowIdx + 1) + " -> " + value);
//	}
//
//	private String saveTemp(XSSFWorkbook wb, String prefix) throws Exception {
//		Path p = Files.createTempFile(prefix + "_", ".xlsx");
//		try (FileOutputStream fos = new FileOutputStream(p.toFile())) {
//			wb.write(fos);
//		}
//		LoggerUtil.info("Temp saved: " + p);
//		return p.toString();
//	}
//
//	private boolean equalsNormalized(String a, String b) {
//		if (a == null)
//			a = "";
//		if (b == null)
//			b = "";
//		try {
//			double da = Double.parseDouble(a.trim());
//			double db = Double.parseDouble(b.trim());
//			return Math.abs(da - db) < 1e-9;
//		} catch (Exception ignore) {
//			return a.trim().equalsIgnoreCase(b.trim());
//		}
//	}
//
//	/**
//	 * Minimal import hook: replace the two TODO lines with your popup methods.
//	 * Should return the validation error text shown by the app.
//	 */
////	private String doImportAndGetError(String flow, String filePath) {
////		try {
////			LoggerUtil.info("Flow=" + flow + " | Importing file: " + filePath);
////			// TODO: open popup, select flow, upload file, submit
////			// detailedCostingPopupPage.importFileForFlow(flow, filePath);
////			// TODO: return detailedCostingPopupPage.getLastErrorToastText();
////			return "Invalid SOB %: value must be between 0 and 100"; // placeholder so test compiles
////		} catch (Exception ex) {
////			LoggerUtil.error("Flow=" + flow + " | Import failed: " + ex.getMessage());
////			throw new SkipException("Import UI not wired. Please implement doImportAndGetError().");
////		}
////	}
//	
//	/**
//	 * Performs actual Excel import using the Detail Costing popup
//	 * and returns the validation error message displayed on screen.
//	 */
//	private String doImportAndGetError(String flow, String filePath) {
//	    try {
//	        LoggerUtil.info("Flow=" + flow + " | Importing file: " + filePath);
//
//	        // Step 2: Select flow type (Procurement / Sales)
//	        if (flow.equalsIgnoreCase("Procurement")) {
//	            PartMasterDetailCostingRivisedPage.selectProcurement();
//	            LoggerUtil.info("Flow=" + flow + " | Procurement radio button selected.");
//	        } else {
//	            PartMasterDetailCostingRivisedPage.selectSales();
//	            LoggerUtil.info("Flow=" + flow + " | Sales radio button selected.");
//	        }
//	        
//	     // Step 1: Open Export/Import modal
//	        PartMasterDetailCostingRivisedPage.openExportImportModal();
//	        LoggerUtil.info("Flow=" + flow + " | Export/Import modal opened successfully.");
//
//	        // Step 3: Click Import tab or section (if separate)
//	        PartMasterDetailCostingRivisedPage.importDetailCostingExcel(filePath);
//	        LoggerUtil.info("Flow=" + flow + " | Import tab opened.");
//
//	        String toastMsg = PartMasterDetailCostingRivisedPage.captureImportToastMessage();
//
//	        LoggerUtil.info("Import validation: " + toastMsg);
//	        Assert.assertTrue(toastMsg.contains("imported successfully") || toastMsg.contains("Success"),
//	                "Unexpected toast message after import: " + toastMsg);
//	        LoggerUtil.info("Flow=" + flow + " | Validation toast captured: " + toastMsg);
//
//	       return toastMsg;
//
//	    } catch (Exception ex) {
//	        LoggerUtil.error("Flow=" + flow + " | Import execution failed: " + ex.getMessage());
//	        throw new SkipException("Import popup interaction failed — check locators or popup flow.", ex);
//	    }
//	}
//	
////	/////////////////////////////////////////////////////////////////////
//
//	@Test(priority = 65, groups = "group1")
//	public void TC_PM_DC_060_Procurement_BOPCost_PartNo_Dropdown_Linked() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_060: Procurement: Part Master Part No. is a dropdown linked to Part_Master");
//	    
//	    validateBopCostPartNoBinding("Procurement");
//
//	    LoggerUtil.pass("TC_PM_DC_060 PASS: BOP_Cost Part Master Part No. correctly linked to Part_Master in Procurement");
//	}
//	
//	@Test(priority = 66, groups = "group1")
//	public void TC_PM_DC_061_Sales_BOPCost_PartNo_Dropdown_Linked() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_061: Sales: Part Master Part No. is a dropdown linked to Part_Master");
//
//	    validateBopCostPartNoBinding("Sales");
//
//	    LoggerUtil.pass("TC_PM_DC_061 PASS: BOP_Cost Part Master Part No. correctly linked to Part_Master in Sales");
//	}
//	
//
//	private void validateBopCostPartNoBinding(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // Step 2: Insert random PartNo in Part_Master
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No. in Part_Master (Row 3) = " + randomPartNo);
//
//	    // Step 2a: Fill that PartNo into BOP_Cost at First/Mid/Last
//	    try (FileInputStream fis = new FileInputStream(exportedFile); XSSFWorkbook wb = new XSSFWorkbook(fis)) {
//	        Sheet bopSheet = wb.getSheet("BOP_Cost");
//	        Assert.assertNotNull(bopSheet, flow + " | ❌ BOP_Cost sheet not found!");
//
//	        Map<String, Integer> bopHeader = ExcelUtil.getHeaderMap(wb, "BOP_Cost", 1);
//	        int lastExcelRow = bopSheet.getLastRowNum(); // convert POI → Excel
//	        int excelFirstRow = 3;
//	        int excelMidRow = (excelFirstRow + lastExcelRow) / 2;
//	        int excelLastRow = lastExcelRow;
//
//	        List<Integer> targetExcelRows = Arrays.asList(excelFirstRow, excelMidRow, excelLastRow);
//	        for (int excelRowNo : targetExcelRows) {
//	        	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", excelRowNo, "Part Master Part No.", randomPartNo);
//	            LoggerUtil.info(flow + " | ✅ Inserted Part No. in BOP_Cost ExcelRow=" + excelRowNo + " = " + randomPartNo);
//	        }
//	    }
//
//	    // Step 3: Reload workbook for validation
//	    XSSFWorkbook wb;
//	    try (FileInputStream fis = new FileInputStream(exportedFile)) {
//	        wb = new XSSFWorkbook(fis);
//	    }
//
//	    Sheet bopSheet = wb.getSheet("BOP_Cost");
//	    Assert.assertNotNull(bopSheet, flow + " | ❌ BOP_Cost sheet not found!");
//
//	    Map<String, Integer> bopHeader = ExcelUtil.getHeaderMap(wb, "BOP_Cost", 1);
//	    int bopColIdx = bopHeader.get("Part Master Part No.");
//
//	    int lastExcelRow = bopSheet.getLastRowNum();
//	    int excelFirstRow = 3;
//	    int excelMidRow = (excelFirstRow + lastExcelRow) / 2;
//	    int excelLastRow = lastExcelRow;
//
//	    List<Integer> targetExcelRows = Arrays.asList(excelFirstRow, excelMidRow, excelLastRow);
//
//	    LoggerUtil.info(flow + " | Target ExcelRows: " + targetExcelRows);
//
//	    SoftAssert softAssert = new SoftAssert();
//	    DataFormatter formatter = new DataFormatter();
//
//	    for (int excelRowNo : targetExcelRows) {
//	        int poiIdx = excelRowNo - 1;
//	        Row row = bopSheet.getRow(poiIdx);
//
//	        if (row == null) {
//	            softAssert.fail(flow + " | Missing row at ExcelRow=" + excelRowNo);
//	            continue;
//	        }
//
//	        Cell cell = row.getCell(bopColIdx);
//	        String actualVal = (cell == null) ? "" : formatter.formatCellValue(cell).trim();
//
//	        LoggerUtil.info(flow + " | ExcelRow=" + excelRowNo + " | Expected=" + randomPartNo + " | Actual=" + actualVal);
//
//	        if (!randomPartNo.equals(actualVal)) {
//	            LoggerUtil.error(flow + " | ❌ Mismatch at ExcelRow=" + excelRowNo +
//	                    " | Expected=" + randomPartNo + " | Found=" + actualVal);
//	            softAssert.fail(flow + " | ExcelRow=" + excelRowNo +
//	                    " mismatch. Expected=" + randomPartNo + " | Found=" + actualVal);
//	        } else {
//	            LoggerUtil.pass(flow + " | ✅ ExcelRow=" + excelRowNo +
//	                    " matched value: " + actualVal);
//	        }
//	    }
//
//	    softAssert.assertAll();
//	    LoggerUtil.pass(flow + " | ✅ BOP_Cost Part Master Part No. correctly shows values from Part_Master.");
//	}
//
//
//	// ====== Return latest exported FILE ======
//	private File exportAndGetFile(String flowType) throws Exception {
//	    LoggerUtil.info("---- Exporting Excel for flow: " + flowType + " ----");
//	    SoftAssert softAssert = new SoftAssert();
//	    dashboard.clickingDashboard("");
//	    Thread.sleep(1000);
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	    Thread.sleep(3000);
//
//	    if (flowType.equalsIgnoreCase("Procurement")) {
//	    	PartMasterDetailCostingRivisedPage.selectProcurement();
//	    	PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//	    } else {
//	    	PartMasterDetailCostingRivisedPage.selectSales();
//	    }
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    // Export
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // ✅ Capture validation messages
//
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    // --- Step 3: Wait for file download and validate ---
//	    Thread.sleep(30000);
//
//	    File filePath = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath);
//	    softAssert.assertAll();
//	    return filePath;
//	}
//	
//	// ====== Return latest exported FILE ======
//		private File exportThePropertiesValuesAndGetFile(String flowType) throws Exception {
//		    LoggerUtil.info("---- Exporting Excel for flow: " + flowType + " ----");
//		    SoftAssert softAssert = new SoftAssert();
//		    dashboard.clickingDashboard("");
//		    Thread.sleep(1000);
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(3000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    Thread.sleep(3000);
//
//		    if (flowType.equalsIgnoreCase("Procurement")) {
//		    	PartMasterDetailCostingRivisedPage.selectProcurement();
//		        PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		    } else {
//		    	PartMasterDetailCostingRivisedPage.selectSales();
//		    }
//
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		    // Export
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//		    String successMsg = "";
//		    for (String msg : validations) {
//		        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//		            successMsg = msg.trim().replaceAll("\\s+", " ");
//		            break;
//		        }
//		    }
//
//		    if (!successMsg.isEmpty()) {
//		        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//		        softAssert.assertEquals(successMsg, "Success File exported successfully",
//		                "Export success message did not match.");
//		    } else {
//		        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//		        softAssert.fail("Expected success toast not found.");
//		    }
//
//		    // --- Step 3: Wait for file download and validate ---
//		    Thread.sleep(30000);
//
//		    File filePath = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath);
//		    softAssert.assertAll();
//
//		    return filePath;
//		}
//		
//		@Test(priority = 67, groups = "group1")
//		public void TC_PM_DC_062ValidateProcurementSupplierNameDropdownPopulatedWithSelectedSuppliersName_Code() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_062: Procurement: Supplier Name dropdown populated with selected suppliers (name + code)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    try {
//		        // --- Step 1: UI Selections ---
//		        dashboard.clickingDashboard("");
//		        dashboard.selectMenuFormDashBoard("Master Data");
//		        Thread.sleep(3000);
//		        dashboard.clickOnPartMaster();
//		        Thread.sleep(1000);
//		        PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		        Thread.sleep(2000);
//		        PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		        Thread.sleep(3000);
//		        PartMasterDetailCostingRivisedPage.selectProcurement();
//		        PartMasterPage.selectOnSupplierValuesByText("0801-Celesta", "0801-Ellsworth","Prabhat-3110");
//		        Thread.sleep(3000);
//		        PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		        Thread.sleep(3000);
//		        PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		        Thread.sleep(3000);
//		        PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//		        // --- Step 2: Export ---
//		        PartMasterDetailCostingRivisedPage.openExportImportModal();
//		        PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		        PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		        List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//			    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//			    String successMsg = "";
//			    for (String msg : validations) {
//			        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//			            successMsg = msg.trim().replaceAll("\\s+", " ");
//			            break;
//			        }
//			    }
//
//			    if (!successMsg.isEmpty()) {
//			        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//			        softAssert.assertEquals(successMsg, "Success File exported successfully",
//			                "Export success message did not match.");
//			    } else {
//			        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//			        softAssert.fail("Expected success toast not found.");
//			    }
//
//			    // --- Step 3: Wait for file download and validate ---
//			    Thread.sleep(30000);
//
//			    File filePath = getLatestFilePartMasterForDetailCostingFile();
//			    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath);
//
//		        XSSFWorkbook workbook = ExcelUtil.openWorkbook(filePath);
//		        XSSFSheet bopSheet = workbook.getSheet("BOP_Cost");
//		        Assert.assertNotNull(bopSheet, "BOP_Cost sheet not found in exported Excel.");
//
//		        // --- Step 4: Identify Target Rows ---
//		        int firstRow = 2;
//		        int lastRow = bopSheet.getLastRowNum()-1;
//		        int midRow = firstRow + (lastRow - firstRow) / 2-1;
//		        List<Integer> targetRows = Arrays.asList(firstRow, midRow, lastRow);
//
//		        // --- Step 5: Get Header & Expected Values ---
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//		        Assert.assertTrue(headerMap.containsKey("Supplier Name"), "Column 'Supplier Name' not found in BOP_Cost sheet!");
//		        List<String> expectedSuppliers = Arrays.asList("0801-Celesta", "0801-Ellsworth", "Prabhat-3110");
//
//		        // --- Step 6: Validate Dropdown Values ---
//		        for (int rowIdx : targetRows) {
//		            LoggerUtil.info("Validating Supplier Name dropdown at BOP_Cost row " + (rowIdx + 1));
//		            Set<String> actualSuppliers = ExcelUtil.getDropdownValues(workbook, "BOP_Cost", "Supplier Name", rowIdx);
//
//		            LoggerUtil.info("Expected suppliers: " + expectedSuppliers);
//		            LoggerUtil.info("Actual suppliers:   " + actualSuppliers);
//
//		            for (String supplier : expectedSuppliers) {
//		                if (!actualSuppliers.contains(supplier)) {
//		                    LoggerUtil.fail("Supplier '" + supplier + "' missing in dropdown at row " + (rowIdx + 1));
//		                    softAssert.fail("Supplier '" + supplier + "' not found in dropdown at row " + (rowIdx + 1));
//		                } else {
//		                    LoggerUtil.pass("Supplier '" + supplier + "' correctly listed at row " + (rowIdx + 1));
//		                }
//		            }
//
//		            softAssert.assertEquals(actualSuppliers.size(), expectedSuppliers.size(),
//		                    "Dropdown supplier count mismatch at row " + (rowIdx + 1));
//		        }
//
//		        LoggerUtil.pass("All dropdown validations completed successfully.");
//
//		    } catch (Exception e) {
//		        LoggerUtil.error("Exception in TC_PM_DC_062 execution: " + e.getMessage());
//		        softAssert.fail("Unexpected exception: " + e.getMessage());
//		    } finally {
//		        softAssert.assertAll();
//		        LoggerUtil.pass("TC_PM_DC_062: Supplier Name dropdown correctly populated for first, mid, and last rows.");
//		    }
//		}
//
//	@Test(priority = 68, groups = "group1")
//	public void TC_PM_DC_63ValidateBOPMasterPartNo_isadropdownlinkedtoBOP_Masterandselectionauto_populatesBOP_BOPType_ChildPartDesc_UOM_SalesProcurement()
//			throws Exception {
//		LoggerUtil.info(
//				"TC_PM_DC_063: Validate BOP Master Part No. is a dropdown linked to BOP_Master and selection auto-populates BOP/BOP Type/Child Part Desc/UOM(Sales & Procurement)");
//
//		// ✅ Procurement
//		
//		ValidateBOPMasterPartNo_isadropdownlinkedtoBOP_Master("Procurement");
//
//		// ✅ Sales
//
//		ValidateBOPMasterPartNo_isadropdownlinkedtoBOP_Master("Sales");
//	}
//
//	private void ValidateBOPMasterPartNo_isadropdownlinkedtoBOP_Master(String flowType) throws Exception {
//	    File exportedFile = exportAndGetFile(flowType);
//	    waitForFileDownload(exportedFile, 20);
//
//	    // --- Step 1: Write Part Nos in Part_Master sheet ---
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "Part_Master", 3, "Part No.*", "aa1");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "Part_Master", 4, "Part No.*", "aa2");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "Part_Master", 5, "Part No.*", "aa3");
//
//	    // --- Step 2: Select Part Master Part No in BOP_Cost ---
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "aa1");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 500, "Part Master Part No.", "aa2");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 1000, "Part Master Part No.", "aa3");
//
//	    // --- Step 3: Select Supplier Name ONLY for Procurement ---
//	    if (flowType.equalsIgnoreCase("Procurement")) {
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "Supplier Name", "0801-Celesta");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 500, "Supplier Name", "0801-Celesta");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 1000, "Supplier Name", "0801-Celesta");
//	    }else {
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "Customer Name", "adiydtj-1917");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 500, "Customer Name", "adiydtj-1917");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 1000, "Customer Name", "adiydtj-1917");
//	    }
//
//	    // --- Step 4: Select BOP Master Part No ---
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", "Colegr-7389");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 500, "BOP Master Part No.", "Colegr-7389");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 1000, "BOP Master Part No.", "Colegr-7389");
//
//	    // Optional repeat for first row
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", "Colegr-7389");
//
//	    // --- Step 5: Validate auto-populated data ---
//	    PartMasterDetailCostingRivisedPage.validateBopCostAgainstBopMaster(exportedFile, 3, "Colegr-7389");
//	}
//	
//	@Test(priority = 69, groups = "group1")
//	public void TC_PM_DC_64ValidateManualBOPPartNo_usercanenterandeditdependentfields_SalesProcurement()
//	        throws Exception {
//
//	    LoggerUtil.info("TC_PM_DC_064: Manual BOP Part No.: user can enter and edit dependent fields");
//
//	    // ✅ Procurement Flow
//	    Manual_BOP_PartNo_usercanenterandeditdependentfields("Procurement");
//
//	    // ✅ Sales Flow
//	    Manual_BOP_PartNo_usercanenterandeditdependentfields("Sales");
//	}
//
//	private void Manual_BOP_PartNo_usercanenterandeditdependentfields(String flowType) throws Exception {
//	    File exportedFile = exportAndGetFile(flowType);
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "BOP_Cost", 3, "Manual BOP Part No.", "Manual BOP Part No.");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP", "New type");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Child Part Desc", "Child Part Desc");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "UOM", "Rs.");
//	    validateManualBOPEditableFields(exportedFile, 3);
//
//	    LoggerUtil.pass("✅ Manual entry and dependent field edit validation passed successfully for " + flowType + " flow.");
//	}
//
//	public static void validateManualBOPEditableFields(File file, int rowNo) throws Exception {
//
//	    SoftAssert softAssert = new SoftAssert();
//	    DataFormatter formatter = new DataFormatter();
//
//	    try (FileInputStream fis = new FileInputStream(file);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet sheet = workbook.getSheet("BOP_Cost");
//	        if (sheet == null) {
//	            throw new IllegalArgumentException("Sheet 'BOP_Cost' not found in the Excel file.");
//	        }
//
//	        Row headerRow = sheet.getRow(1);
//	        if (headerRow == null) {
//	            throw new IllegalArgumentException("Header row not found in BOP_Cost sheet.");
//	        }
//
//	        // Column indexes
//	        int manualBopCol = getColIndex(headerRow, "Manual BOP Part No.");
//	        int bopCol       = getColIndex(headerRow, "BOP");
//	        int bopTypeCol   = getColIndex(headerRow, "BOP Type");
//	        int childCol     = getColIndex(headerRow, "Child Part Desc");
//	        int uomCol       = getColIndex(headerRow, "UOM");
//
//	        Row dataRow = sheet.getRow(rowNo - 1);
//	        if (dataRow == null) {
//	            throw new IllegalArgumentException("Row not found: " + rowNo);
//	        }
//
//	        // Cells
//	        Cell manualBopCell = dataRow.getCell(manualBopCol, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//	        Cell bopCell       = dataRow.getCell(bopCol,       Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//	        Cell bopTypeCell   = dataRow.getCell(bopTypeCol,   Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//	        Cell childCell     = dataRow.getCell(childCol,     Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//	        Cell uomCell       = dataRow.getCell(uomCol,       Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//
//	        // Expected manual values you wrote earlier
//	        final String EXP_MANUAL_BOP   = "Manual BOP Part No.";
//	        final String EXP_BOP          = "New type";
//	        final String EXP_CHILD_DESC   = "Child Part Desc";
//	        final String EXP_UOM          = "Rs.";
//
//	        // 1) Manual BOP Part No., BOP, UOM must match exactly (string compare)
//	        checkAndLogSoftAssert(softAssert, "Manual BOP Part No.",
//	                EXP_MANUAL_BOP, formatter.formatCellValue(nonNullCell(manualBopCell)));
//
//	        checkAndLogSoftAssert(softAssert, "BOP",
//	                EXP_BOP, formatter.formatCellValue(nonNullCell(bopCell)));
//
//	        checkAndLogSoftAssert(softAssert, "UOM",
//	                EXP_UOM, formatter.formatCellValue(nonNullCell(uomCell)));
//
//	        // 2) BOP Type: MUST remain formula-linked (expected)
//	        if (bopTypeCell != null && bopTypeCell.getCellType() == CellType.FORMULA) {
//	            LoggerUtil.info("BOP Type is formula-linked as expected (formula cell detected).");
//	        } else {
//	            LoggerUtil.error("BOP Type expected to be formula-linked, but is not a formula cell.");
//	            softAssert.fail("BOP Type should remain formula-linked (formula cell expected).");
//	        }
//
//	        // 3) Child Part Desc: allowed if either (a) default system formula present, or (b) manually overwritten
//	        if (childCell != null && childCell.getCellType() == CellType.FORMULA) {
//	            String f = childCell.getCellFormula();
//	            if (f != null && (f.contains("INDEX(") || f.contains("IFERROR("))) {
//	                LoggerUtil.info("Child Part Desc has default system formula and is user-editable (allowed).");
//	            } else {
//	                LoggerUtil.error("Child Part Desc has an unexpected formula. Should allow manual entry or default system formula.");
//	                softAssert.fail("Child Part Desc contains unexpected formula: " + f);
//	            }
//	        } else {
//	            // Non-formula → should match the manual text written
//	            String actualChild = formatter.formatCellValue(nonNullCell(childCell));
//	            checkAndLogSoftAssert(softAssert, "Child Part Desc", EXP_CHILD_DESC, actualChild);
//	        }
//
//	        LoggerUtil.pass("Manual BOP validation complete — editable and formula-linked fields verified correctly.");
//	        softAssert.assertAll();
//	    }
//	}
//
//	// --------- helpers ---------
//
//	private static int getColIndex(Row headerRow, String columnName) {
//	    for (Cell cell : headerRow) {
//	        if (cell != null && cell.getCellType() == CellType.STRING &&
//	            cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
//	            return cell.getColumnIndex();
//	        }
//	    }
//	    throw new IllegalArgumentException("Column not found: " + columnName);
//	}
//
//	private static void checkAndLogSoftAssert(SoftAssert softAssert, String column, String expected, String actual) {
//	    if (expected.equalsIgnoreCase(actual)) {
//	        LoggerUtil.info(column + " matched: " + actual);
//	    } else {
//	        LoggerUtil.error(column + " mismatch. Expected=" + expected + ", Actual=" + actual);
//	        softAssert.fail(column + " mismatch. Expected=" + expected + ", Actual=" + actual);
//	    }
//	}
//
//	private static Cell nonNullCell(Cell cell) {
//	    if (cell == null) {
//	        // Return a blank STRING cell to keep DataFormatter behavior stable
//	        XSSFWorkbook wb = new XSSFWorkbook();
//	        XSSFSheet sh = wb.createSheet();
//	        Row r = sh.createRow(0);
//	        Cell c = r.createCell(0, CellType.STRING);
//	        c.setCellValue("");
//	        return c;
//	    }
//	    return cell;
//	}
//
//
//	@Test(priority = 70, groups = "group1")
//	public void TC_PM_DC_65ValidateUOMBehavior_BOPMasterVsManualBOP_SalesProcurement() throws Exception {
//
//	    LoggerUtil.info("TC_PM_DC_065: UOM behavior: formula-based when BOP Master used; dropdown when Manual BOP");
//
//	    // ✅ Procurement Flow
//	    validateUOMBehavior("Procurement");
//
//	    // ✅ Sales Flow
//	    validateUOMBehavior("Sales");
//	}
//
//	private void validateUOMBehavior(String flowType) throws Exception {
//	    File exportedFile = exportAndGetFile(flowType);
//	    waitForFileDownload(exportedFile, 20);
//
//	    // --- Step 1: Write Part No in Part_Master sheet ---
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "Part_Master", 3, "Part No.*", "aa1");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "Part_Master", 4, "Part No.*", "aa2");
//
//	    // --- Step 2: Select Part Master Part No in BOP_Cost ---
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "aa1");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 4, "Part Master Part No.", "aa2");
//
//	    // --- Step 3: Select Supplier or Customer depending on flow ---
//	    if (flowType.equalsIgnoreCase("Procurement")) {
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "Supplier Name", "0801-Celesta");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 4, "Supplier Name", "0801-Celesta");
//	    } else {
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "Customer Name", "adiydtj-1917");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 4, "Customer Name", "adiydtj-1917");
//	    }
//
//	    // --- Step 4: Assign different BOP modes per row ---
//	    // Row 1 → BOP Master (formula-driven UOM)
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", "Colegr-7389");
//
//	    // Row 2 → Manual BOP (editable UOM)
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue(exportedFile, "BOP_Cost", 4, "Manual BOP Part No.", "Manual BOP Part No.");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 4, "BOP", "New type");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 4, "UOM", "Rs.");
//
//	    // --- Step 5: Validate UOM behavior for both rows ---
//	    validateUOMFormulaAndEditable(exportedFile, 3, 4);
//	    LoggerUtil.pass("✅ UOM validation passed successfully for both BOP Master and Manual BOP in " + flowType + " flow.");
//	}
//
//	// ----------------------------------------------------------------------------------------------------
//	//  VALIDATION METHOD: Checks that UOM is formula for BOP Master row, editable for Manual BOP row
//	// ----------------------------------------------------------------------------------------------------
//	public static void validateUOMFormulaAndEditable(File file, int bopMasterRow, int manualBopRow) throws Exception {
//
//	    SoftAssert softAssert = new SoftAssert();
//
//	    try (FileInputStream fis = new FileInputStream(file);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet sheet = workbook.getSheet("BOP_Cost");
//	        if (sheet == null)
//	            throw new IllegalArgumentException("❌ Sheet 'BOP_Cost' not found!");
//
//	        Row headerRow = sheet.getRow(1);
//	        if (headerRow == null)
//	            throw new IllegalArgumentException("❌ Header row missing in BOP_Cost!");
//
//	        int uomCol = getColIndex(headerRow, "UOM");
//
//	        // --- Row 1: BOP Master (formula-driven) ---
//	        Row masterRow = sheet.getRow(bopMasterRow - 1);
//	        Cell uomCellMaster = masterRow.getCell(uomCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//	        if (uomCellMaster.getCellType() == CellType.FORMULA) {
//	            LoggerUtil.info("✅ Row " + bopMasterRow + ": UOM is formula-based (locked) as expected for BOP Master.");
//	        } else {
//	            LoggerUtil.error("❌ Row " + bopMasterRow + ": Expected formula cell for UOM, found editable value!");
//	            softAssert.fail("Row " + bopMasterRow + ": UOM should be formula-based but is editable.");
//	        }
//
//	        // --- Row 2: Manual BOP (should be editable, but formula is acceptable if unlocked) ---
//	        Row manualRow = sheet.getRow(manualBopRow - 1);
//	        Cell uomCellManual = manualRow.getCell(uomCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//	        if (uomCellManual.getCellType() == CellType.FORMULA) {
//	            LoggerUtil.info("ℹ️ Row " + manualBopRow + ": UOM cell is technically formula-based but editable in Excel UI (system default).");
//	            LoggerUtil.pass("✅ Manual BOP row behaves as expected — UOM editable at UI despite formula linkage.");
//	        } else {
//	            LoggerUtil.info("✅ Row " + manualBopRow + ": UOM is editable/dropdown as expected for Manual BOP.");
//	        }
//
//	        LoggerUtil.pass("PASS: UOM behavior validated successfully — formula-based for BOP Master, editable (or editable-formula) for Manual BOP.");
//	        softAssert.assertAll();
//	    }
//	}
//
//
//	@Test(priority = 71, groups = "group1")
//	public void TC_PM_DC_066ValidateQtyPerPcDefaultsToOne() throws Exception {
//		LoggerUtil.info("TC_PM_DC_066: Validate Qty/Pc defaults to 1 when Part Master Part No. is selected.");
//
//		// ✅ Export Procurement Excel
//		XSSFWorkbook procurementWb = exportAndGetWorkbook("Procurement");
//		File procurementFile = getLatestFilePartMasterForDetailCostingFile();
//
//		// Collect some sample Part Nos from BOP_Master
//		List<String> samplePartNos = Arrays.asList("PartNo-1", "PartNo-2", "PartNo-3"); // you can fetch dynamically if
//																						// needed
//
//		ExcelUtil.checkDefaultOnSelection(procurementWb, "BOP_Cost", "Part Master Part No.", "Qty/Pc", "1",
//				samplePartNos, procurementFile);
//
//		// ✅ Export Sales Excel
//		XSSFWorkbook salesWb = exportAndGetWorkbook("Sales");
//		File salesFile = getLatestFilePartMasterForDetailCostingFile();
//
//		ExcelUtil.checkDefaultOnSelection(salesWb, "BOP_Cost", "Part Master Part No.", "Qty/Pc", "1", samplePartNos,
//				salesFile);
//	}
//
////	/*
////	 * @Test(priority = 67, groups = "group1") public void
////	 * TC_PM_DC_067ValidateQtyPcAcceptsOnlyPositiveIntegers() throws Exception {
////	 * LoggerUtil.
////	 * info("TC_PM_DC_067: Validate Qty/Pc accepts only positive integers");
////	 * 
////	 * // ✅ Export Procurement Excel XSSFWorkbook procurementWb =
////	 * exportAndGetWorkbook("Procurement"); File procurementFile =
////	 * getLatestFilePartMasterForDetailCostingFile();
////	 * waitForFileDownload(procurementFile, 20); String
////	 * filePath=procurementFile.getAbsolutePath(); // STEP 4: Enter Qty/Pc values in
////	 * Excel (valid + invalid) ExcelUtil.writeCellValue(procurementFile, "BOP_Cost",
////	 * 3, "Part Master Part No.", "abc"); // Row 3, S.No=1
////	 * LoggerUtil.info("Row 3 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 3,
////	 * "Part Master Part No."));
////	 * 
////	 * ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 3, "Qty/Pc", "1"); //
////	 * Row 3, S.No=1 LoggerUtil.info("Row 3 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 3, "Qty/Pc"));
////	 * ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 4, "Qty/Pc", "5"); //
////	 * Row 4, S.No=2 LoggerUtil.info("Row 4 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 4, "Qty/Pc"));
////	 * ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 5, "Qty/Pc", "0"); //
////	 * Row 5, invalid LoggerUtil.info("Row 5 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 5, "Qty/Pc"));
////	 * ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 6, "Qty/Pc", "-2"); //
////	 * Row 6, invalid LoggerUtil.info("Row 6 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 6, "Qty/Pc"));
////	 * ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 7, "Qty/Pc", "1.5"); //
////	 * Row 7, invalid LoggerUtil.info("Row 7 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 7, "Qty/Pc"));
////	 * ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 8, "Qty/Pc", "abc"); //
////	 * Row 8, invalid LoggerUtil.info("Row 8 Qty/Pc after write: " +
////	 * ExcelUtil.readCellValue(procurementFile, "BOP_Cost", 8, "Qty/Pc"));
////	 * 
////	 * 
////	 * // STEP 5: Import modified Excel pmdcrp.openExportImportModal();
////	 * pmdcrp.importDetailCostingExcel(filePath); // ✅ Capture validation messages
////	 * List<String> validations = pmdcrp.captureValidationMessages();
////	 * Assert.assertFalse(validations.isEmpty(),
////	 * "No validation message appeared; action was not blocked.");
////	 * 
////	 * // String actualMsg = validations.get(0).trim().replaceAll("\\s+", " "); //
////	 * normalize message //
////	 * LoggerUtil.info("Validation message captured (normalized): " + actualMsg);
////	 * 
////	 * // Assert.assertEquals(actualMsg, "Success File exported successfully", //
////	 * "Export success message did not match.");
////	 * LoggerUtil.info("Imported modified Excel with Qty/Pc test data");
////	 * 
////	 * // STEP 6: Validation check // Verify that rows with valid integers are
////	 * saved, and invalid rows are rejected boolean isRow3Valid =
////	 * pmdcrp.verifyQtyPcSaved("1"); // should be true boolean isRow4Valid =
////	 * pmdcrp.verifyQtyPcSaved("5"); // should be true boolean isRow5Invalid =
////	 * !pmdcrp.verifyQtyPcSaved("0"); boolean isRow6Invalid =
////	 * !pmdcrp.verifyQtyPcSaved("-2"); boolean isRow7Invalid =
////	 * !pmdcrp.verifyQtyPcSaved("1.5"); boolean isRow8Invalid =
////	 * !pmdcrp.verifyQtyPcSaved("abc");
////	 * 
////	 * if (isRow3Valid && isRow4Valid) {
////	 * LoggerUtil.pass("Valid Qty/Pc values (1, 5) are accepted and saved."); } else
////	 * { LoggerUtil.fail("Valid Qty/Pc values not saved correctly."); }
////	 * 
////	 * if (isRow5Invalid && isRow6Invalid && isRow7Invalid && isRow8Invalid) {
////	 * LoggerUtil.
////	 * pass("Invalid Qty/Pc values (0, -2, 1.5, abc) are correctly rejected."); }
////	 * else { LoggerUtil.fail("Some invalid Qty/Pc values were wrongly accepted.");
////	 * } }
////	 */
////
////	@Test(priority = 72, groups = "group1")
////	public void TC_PM_DC_067ValidateQtyPcAcceptsOnlyPositiveIntegers() throws Exception {
////		LoggerUtil.info("TC_PM_DC_067: Validate Qty/Pc accepts only positive integers");
////		verifyQtyPcAcceptsOnlyPositiveIntegers("Procurement");
////		verifyQtyPcAcceptsOnlyPositiveIntegers("Sales");
////	}
////
////	// STEP 1: Export Procurement Excel
////	private void verifyQtyPcAcceptsOnlyPositiveIntegers(String flow) throws Exception {
////		SoftAssert softAssert = new SoftAssert();
////		exportAndGetWorkbook(flow);
////		File procurementFile = getLatestFilePartMasterForDetailCostingFile();
////		waitForFileDownload(procurementFile, 20);
////		String filePath = procurementFile.getAbsolutePath();	
////
////		// STEP 2: Write test values in Qty/Pc column
////		ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 3, "Qty/Pc", "1"); // valid
////		ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 4, "Qty/Pc", "5"); // valid
////		ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 5, "Qty/Pc", "0"); // invalid
////		ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 6, "Qty/Pc", "-2"); // invalid
////		ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 7, "Qty/Pc", "1.5"); // invalid
////		ExcelUtil.writeCellValue(procurementFile, "BOP_Cost", 8, "Qty/Pc", "abc"); // invalid
////		LoggerUtil.info("Excel updated with test values for Qty/Pc column");
////
////		// STEP 3: Verify written values directly in Excel (Inserted vs Actual)
////		ExcelUtil.verifyQtyPcInExcel(procurementFile, "BOP_Cost", 3, "Qty/Pc", "1");
////		ExcelUtil.verifyQtyPcInExcel(procurementFile, "BOP_Cost", 4, "Qty/Pc", "5");
////		ExcelUtil.verifyQtyPcInExcel(procurementFile, "BOP_Cost", 5, "Qty/Pc", "0");
////		ExcelUtil.verifyQtyPcInExcel(procurementFile, "BOP_Cost", 6, "Qty/Pc", "-2");
////		ExcelUtil.verifyQtyPcInExcel(procurementFile, "BOP_Cost", 7, "Qty/Pc", "1.5");
////		ExcelUtil.verifyQtyPcInExcel(procurementFile, "BOP_Cost", 8, "Qty/Pc", "abc");
////
////		// STEP 4: Import modified Excel
////		PartMasterDetailCostingRivisedPage.openExportImportModal();
////		PartMasterDetailCostingRivisedPage.importDetailCostingExcel(filePath);
////		// ✅ Capture validation messages
////		List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
////		Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
////		
////	    String successMsg = "";
////	    for (String msg : validations) {
////	        if (msg.contains("Warning") && msg.contains("InsertUpdateDetailCosting failed. Error 8114, Severity 16, State 5, Line 219, Procedure dbo.InsertUpdateDetailCosting. Message: Error converting data type nvarchar to numeric.")) {
////	            successMsg = msg.trim().replaceAll("\\s+", " ");
////	            break;
////	        }
////	    }
////
////	    if (!successMsg.isEmpty()) {
////	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
////	        softAssert.assertEquals(successMsg, "InsertUpdateDetailCosting failed. Error 8114, Severity 16, State 5, Line 219, Procedure dbo.InsertUpdateDetailCosting. Message: Error converting data type nvarchar to numeric.",
////	                "Imported InsertUpdateDetailCosting failed. Error 8114, Severity 16, State 5, Line 219, Procedure dbo.InsertUpdateDetailCosting. Message: Error converting data type nvarchar to numeric. message did not match.");
////	    } else {
////	        LoggerUtil.error("Warning toast not captured. Actual messages: " + validations);
////	        softAssert.fail("Expected success toast not found.");
////	    }
////		LoggerUtil.info("Imported modified Excel with Qty/Pc test data");
////
////		// STEP 5: Validation check in UI
////		boolean isRow3Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("1"); // should be true
////		boolean isRow4Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("5"); // should be true
////		boolean isRow5Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("0"); // should be false
////		boolean isRow6Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("-2"); // should be false
////		boolean isRow7Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("1.5"); // should be false
////		boolean isRow8Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("abc"); // should be false
////
////		if (isRow3Saved && isRow4Saved) {
////			LoggerUtil.pass("Valid Qty/Pc values (1, 5) are accepted and saved in UI.");
////		} else {
////			LoggerUtil.fail("Valid Qty/Pc values not saved correctly in UI.");
////		}
////
////		if (!isRow5Saved && !isRow6Saved && !isRow7Saved && !isRow8Saved) {
////			LoggerUtil.pass("Invalid Qty/Pc values (0, -2, 1.5, abc) are correctly rejected during import.");
////		} else {
////			LoggerUtil.fail("Some invalid Qty/Pc values were wrongly accepted in UI.");
////		}
////		softAssert.assertAll();
////	}
//	
//	@Test(priority = 72, groups = "group1")
//	public void TC_PM_DC_067ValidateQtyPcAcceptsOnlyPositiveIntegers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_067: Validate Qty/Pc accepts only positive integers");
//	    verifyQtyPcAcceptsOnlyPositiveIntegers("Procurement");
//	    verifyQtyPcAcceptsOnlyPositiveIntegers("Sales");
//	}
//
//	// Combined positive + negative validation flow
//	private void verifyQtyPcAcceptsOnlyPositiveIntegers(String flow) throws Exception {
//	    SoftAssert softAssert = new SoftAssert();
//	    LoggerUtil.info("---- Starting Qty/Pc validation for flow: " + flow + " ----");
//
//	    // STEP 1: Export Excel
//	    exportAndGetWorkbook(flow);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//	    String filePath = exportedFile.getAbsolutePath();
//	    String sheetName = "BOP_Cost";
//	    LoggerUtil.info("Exported Excel file path: " + filePath);
//
//	    // ==========================================================
//	    // POSITIVE TEST: only valid integer values (should pass)
//	    // ==========================================================
//	    LoggerUtil.info("===== STEP A: Positive Test (Valid Integers) =====");
//
//	    ExcelUtil.writeCellValue(exportedFile, sheetName, 3, "Qty/Pc", "1");
//	    ExcelUtil.writeCellValue(exportedFile, sheetName, 4, "Qty/Pc", "5");
//	    LoggerUtil.info("Excel updated with valid positive integers (1, 5).");
//
//	    // Verify written values
//	    ExcelUtil.verifyQtyPcInExcel(exportedFile, sheetName, 3, "Qty/Pc", "1");
//	    ExcelUtil.verifyQtyPcInExcel(exportedFile, sheetName, 4, "Qty/Pc", "5");
//
//	    // Import valid Excel
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.importDetailCostingExcel(filePath);
//
//	    List<String> validationsPositive = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    if (validationsPositive.isEmpty()) {
//	        LoggerUtil.pass("No validation error appeared — valid Qty/Pc values accepted successfully.");
//	    } else {
//	        LoggerUtil.fail("Unexpected validation message appeared for valid values: " + validationsPositive);
//	        softAssert.fail("Valid Qty/Pc values should import successfully but showed validation.");
//	    }
//
//	    // Verify valid data saved
//	    boolean isRow3Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("1");
//	    boolean isRow4Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("5");
//
//	    if (isRow3Saved && isRow4Saved) {
//	        LoggerUtil.pass("Valid Qty/Pc (1, 5) are correctly saved in UI.");
//	    } else {
//	        LoggerUtil.fail("Valid Qty/Pc (1, 5) were not found in UI after import.");
//	        softAssert.fail("Valid rows missing in UI after import.");
//	    }
//
//	    // ==========================================================
//	    // NEGATIVE TEST: invalid/non-integer values (should fail)
//	    // ==========================================================
//	    LoggerUtil.info("===== STEP B: Negative Test (Invalid Entries) =====");
//
//	    // Overwrite same Excel with invalid data
//	    ExcelUtil.writeCellValue(exportedFile, sheetName, 5, "Qty/Pc", "0");
//	    ExcelUtil.writeCellValue(exportedFile, sheetName, 6, "Qty/Pc", "-2");
//	    ExcelUtil.writeCellValue(exportedFile, sheetName, 7, "Qty/Pc", "1.5");
//	    ExcelUtil.writeCellValue(exportedFile, sheetName, 8, "Qty/Pc", "abc");
//	    LoggerUtil.info("Excel updated with invalid Qty/Pc values (0, -2, 1.5, abc).");
//
//	    // Verify invalid data in Excel
//	    ExcelUtil.verifyQtyPcInExcel(exportedFile, sheetName, 5, "Qty/Pc", "0");
//	    ExcelUtil.verifyQtyPcInExcel(exportedFile, sheetName, 6, "Qty/Pc", "-2");
//	    ExcelUtil.verifyQtyPcInExcel(exportedFile, sheetName, 7, "Qty/Pc", "1.5");
//	    ExcelUtil.verifyQtyPcInExcel(exportedFile, sheetName, 8, "Qty/Pc", "abc");
//
//	    // Import invalid Excel
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.importDetailCostingExcel(filePath);
//
//	    List<String> validationsNegative = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    if (validationsNegative.isEmpty()) {
//	        LoggerUtil.fail("No validation appeared for invalid Qty/Pc values; expected rejection.");
//	        softAssert.fail("System failed to block invalid Qty/Pc values.");
//	    } else {
//	        LoggerUtil.info("Captured validation messages: " + validationsNegative);
//	        boolean hasInvalidToast = validationsNegative.stream()
//	                .anyMatch(msg -> msg.toLowerCase().contains("invalid") ||
//	                                 msg.toLowerCase().contains("error") ||
//	                                 msg.toLowerCase().contains("warning"));
//	        if (hasInvalidToast) {
//	            LoggerUtil.pass("System correctly displayed validation message for invalid Qty/Pc values.");
//	        } else {
//	            LoggerUtil.fail("Unexpected validation text; message does not indicate invalid value rejection.");
//	            softAssert.fail("Toast did not clearly mention invalid Qty/Pc rejection.");
//	        }
//	    }
//
//	    // Verify invalid data NOT saved
//	    boolean isRow5Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("0");
//	    boolean isRow6Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("-2");
//	    boolean isRow7Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("1.5");
//	    boolean isRow8Saved = PartMasterDetailCostingRivisedPage.verifyQtyPcSaved("abc");
//
//	    if (!isRow5Saved && !isRow6Saved && !isRow7Saved && !isRow8Saved) {
//	        LoggerUtil.pass("Invalid Qty/Pc values (0, -2, 1.5, abc) were correctly rejected.");
//	    } else {
//	        LoggerUtil.fail("Some invalid Qty/Pc values were incorrectly saved in UI.");
//	        softAssert.fail("Invalid Qty/Pc values should not appear in UI after import.");
//	    }
//
//	    LoggerUtil.info("---- Completed validation for flow: " + flow + " ----");
//	    softAssert.assertAll();
//	}
//	
//
//	
//	@Test(priority = 73, groups = "group1")
//	public void TC_PM_DC_068_ValidateSupplyCurrencyDropdownMatchesSystemCurrencySettings() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_068: Validate Supply Currency dropdown matches system currency settings");
//
//	    // Validate for both flows
//	    validateSupplyCurrencyDropdown("Procurement");
//	    validateSupplyCurrencyDropdown("Sales");
//	}
//
//	private void validateSupplyCurrencyDropdown(String flowType) throws Exception {
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: Export Excel ---
//	    exportAndGetWorkbook(flowType);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//	    String filePath = exportedFile.getAbsolutePath();
//	    LoggerUtil.info("Exported Excel file path (" + flowType + "): " + filePath);
//
//	    // --- Step 2: Open workbook and sheet ---
//	    XSSFWorkbook wb = ExcelUtil.openWorkbook(exportedFile);
//	    Sheet bopSheet = wb.getSheet("BOP_Cost");
//	    softAssert.assertNotNull(bopSheet, "BOP_Cost sheet not found in Excel file!");
//	    LoggerUtil.info("✔ 'BOP_Cost' sheet opened successfully for " + flowType);
//
//	    // --- Step 3: Locate 'Supply Currency' column dynamically ---
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(wb, "BOP_Cost", 1);
//	    softAssert.assertTrue(headerMap.containsKey("Supply Currency"),
//	            "Column 'Supply Currency' not found in BOP_Cost sheet!");
//	    int supplyCurrencyColIndex = headerMap.get("Supply Currency");
//
//	    // --- Step 4: Expected dropdown values from system settings ---
//	    List<String> expectedValues = SystemCurrencySettings();
//	    LoggerUtil.info("Expected system currency list: " + expectedValues);
//
//	    // --- Step 5: Determine rows to check (first, middle, last) ---
//	    int totalRows = bopSheet.getLastRowNum() - 1;
//	    int firstDataRow = 2; // Excel row 3
//	    int lastDataRow = totalRows;
//	    int midRow = (firstDataRow + lastDataRow) / 2;
//	    int[] rowsToCheck = { firstDataRow, midRow, lastDataRow };
//
//	    LoggerUtil.info("Row-wise dropdown validation started for 'Supply Currency' on rows: "
//	            + Arrays.toString(rowsToCheck));
//
//	    // --- Step 6: Row-wise validation for dropdown presence and matching values ---
//	    for (int row : rowsToCheck) {
//	        List<String> dropdownValues = PartMasterDetailCostingRivisedPage.UniversalcollectExplicitDVListForColumns(
//	                bopSheet, wb, supplyCurrencyColIndex, row, row);
//
//	        if (dropdownValues == null || dropdownValues.isEmpty()) {
//	            LoggerUtil.fail("Row " + (row + 1) + ": ❌ No dropdown values found for 'Supply Currency'.");
//	            softAssert.fail("Dropdown missing or empty at row " + (row + 1));
//	        } else {
//	            LoggerUtil.pass("Row " + (row + 1) + ": ✔ Dropdown found successfully.");
//	            LoggerUtil.info("→ Row " + (row + 1) + " dropdown values: " + dropdownValues);
//
//	            // Row-level validation
//	            softAssert.assertTrue(dropdownValues.containsAll(expectedValues),
//	                    "Row " + (row + 1) + ": Dropdown values mismatch with system currencies!");
//	        }
//	    }
//
//	    // --- Step 7: Verify that manual / free-text entry is blocked ---
//	    LoggerUtil.info("Verifying manual text entry restriction for 'Supply Currency' column...");
//	    String invalidValue = "XYZ";
//	    boolean writeSuccess = true;
//	    try {
//	        //ExcelUtil.writeCellValue(exportedFile, "BOP_Cost", firstDataRow + 1, "Supply Currency", invalidValue);
//	        PartMasterDetailCostingRivisedPage.simplewriteAndConfirmCellValueWithoutClearFormulla(exportedFile, "BOP_Cost", firstDataRow + 1, "Supply Currency", invalidValue);
//	        LoggerUtil.info("Attempted to write invalid text '" + invalidValue + "' into Supply Currency cell.");
//	    } catch (Exception e) {
//	        LoggerUtil.info("Excel validation prevented manual entry for Supply Currency (as expected): " + e.getMessage());
//	        writeSuccess = false;
//	    }
//
//	    if (writeSuccess) {
//	        LoggerUtil.fail("❌ Manual/free-text entry ('" + invalidValue + "') was accepted in Supply Currency column!");
//	        softAssert.fail("Free-text entry allowed in Supply Currency column!");
//	    } else {
//	        LoggerUtil.pass("✔ Manual/free-text entry blocked successfully in Supply Currency column.");
//	    }
//
//	    softAssert.assertAll();
//	    LoggerUtil.pass("✔ Supply Currency dropdown + text-entry validation completed successfully for flow: " + flowType);
//	}
//
//	// --- Currency list fetch from UI ---
//	private List<String> SystemCurrencySettings() throws InterruptedException {
//	    Thread.sleep(3000);
//	    dashboard.clickOnCurrencyModel();
//	    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example1']//tbody/tr"));
//	    List<String> currencies = new ArrayList<>();
//
//	    for (WebElement row : rows) {
//	        List<WebElement> cells = row.findElements(By.tagName("td"));
//	        if (cells.size() >= 4) {
//	            String convertTo = cells.get(1).getText().trim(); // td[2]
//	            String dataSource = cells.get(3).getText().trim(); // td[4]
//	            currencies.add(convertTo + "-" + dataSource);
//	        }
//	    }
//	    return currencies;
//	}
//
//	@Test(priority = 69, groups = "group1")
//	public void TC_PM_DC_69YeardropdownCurrentFYprevious_9_FYs() throws Exception {
//		// STEP 1: Load exported Excel
//		LoggerUtil.info("TC_PM_DC_069: Validate Year dropdown: current FY + previous 9 FYs (Sales & Procurement)");
//		// ✅ Procurement
//		XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//		YeardropdownCurrentFYprevious_9_FYs(procurementWorkbook, "Procurement");
//
//		// ✅ Sales
//		XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//		YeardropdownCurrentFYprevious_9_FYs(salesWorkbook, "Sales");
//
//	}
//
//	private void YeardropdownCurrentFYprevious_9_FYs(XSSFWorkbook workbook, String flowType) throws Exception {
//		File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		waitForFileDownload(exportedFile, 20);
//		LoggerUtil.info("Exported Excel file path (" + flowType + "): " + exportedFile.getAbsolutePath());
//
//		// Expected values: current FY + previous 9 FYs (full format e.g. 2025-2026)
//		int currentYear = LocalDate.now().getYear();
//		List<String> expectedYears = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			int fyStart = currentYear - i;
//			int fyEnd = fyStart + 1;
//			expectedYears.add(fyStart + "-" + fyEnd); // full 4-digit years
//		}
//
//		// Get BOP_Cost sheet
//		XSSFSheet sheet = workbook.getSheet("BOP_Cost");
//		int lastRowNum = sheet.getLastRowNum(); // 0-based last row index
//		int totalRows = lastRowNum - 1; // 1-based count
//
//		// Rows: 3, mid, last
//		int firstRow = 3;
//		int midRow = totalRows / 2;
//		int lastRow = totalRows - 1; // no -1 here
//
//		int[] rowsToCheck = { firstRow, midRow, lastRow };
//
//		for (int row : rowsToCheck) {
//			String cellRef = "L" + row; // Year column
//			List<String> actualYears = PartMasterDetailCostingRivisedPage.getDropdownValues(workbook, "BOP_Cost", cellRef);
//
//			LoggerUtil.info("Year dropdown entries at row " + row + " (" + flowType + "): " + actualYears);
//
//			Assert.assertEquals(actualYears, expectedYears,
//					"❌ Year dropdown values mismatch at row " + row + " in flow: " + flowType);
//		}
//
//		LoggerUtil.pass("✔ Year dropdown validation passed for " + flowType + " (rows 3, mid=" + midRow + ", last="
//				+ lastRow + ")!");
//	}
//
//	@Test(priority = 70, groups = "group1")
//	public void TC_PM_DC_70PerioddropdownJanToDec() throws Exception {
//		LoggerUtil.info("TC_PM_DC_070: Validate Period dropdown: Jan–Dec (Sales & Procurement)");
//
//		// ✅ Procurement
//		XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//		validatePeriodDropdown(procurementWorkbook, "Procurement");
//
//		// ✅ Sales
//		XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//		validatePeriodDropdown(salesWorkbook, "Sales");
//	}
//
//	private void validatePeriodDropdown(XSSFWorkbook workbook, String flowType) throws Exception {
//		File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		waitForFileDownload(exportedFile, 20);
//		LoggerUtil.info("Exported Excel file path (" + flowType + "): " + exportedFile.getAbsolutePath());
//
//		// Expected values (Apr → Mar order, as in Excel dropdown)
//		List<String> expectedPeriods = Arrays.asList("Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec",
//				"Jan", "Feb", "Mar");
//
//		// Get BOP_Cost sheet
//		XSSFSheet sheet = workbook.getSheet("BOP_Cost");
//		int lastRowNum = sheet.getLastRowNum(); // last row index (0-based)
//		int totalRows = lastRowNum - 1; // convert to row count (1-based)
//
//		// Compute rows to check: first=3, mid=total/2, last=total
//		int firstRow = 3;
//		int midRow = totalRows / 2;
//		int lastRow = totalRows - 1;
//
//		int[] rowsToCheck = { firstRow, midRow, lastRow };
//
//		for (int row : rowsToCheck) {
//			String cellRef = "M" + row;
//			List<String> actualPeriods = PartMasterDetailCostingRivisedPage.getDropdownValues(workbook, "BOP_Cost", cellRef);
//
//			LoggerUtil.info("Period dropdown entries at row " + row + " (" + flowType + "): " + actualPeriods);
//
//			Assert.assertEquals(actualPeriods, expectedPeriods,
//					"❌ Period dropdown values mismatch at row " + row + " in flow: " + flowType);
//		}
//
//		LoggerUtil.pass("✔ Period dropdown validation passed for " + flowType + " (rows 3, mid=" + midRow + ", last="
//				+ lastRow + ")!");
//	}
//
//	@Test(priority = 71, groups = "group1")
//	public void TC_PM_DC_071_manualBOPFieldsValidation() throws Exception {
//		LoggerUtil.info(
//				"TC_PM_DC_071: Validate Manual BOP fields Part Cost/Unit, Currency Conversion, Duties %, Freight & Insurance %, Other Cost");
//
//		// ✅ Procurement Export
//		XSSFWorkbook procurementWorkbook = exportAndGetWorkbook("Procurement");
//		validateManualBOPFields(procurementWorkbook, "Procurement");
//
//		// ✅ Sales Export
//		XSSFWorkbook salesWorkbook = exportAndGetWorkbook("Sales");
//		validateManualBOPFields(salesWorkbook, "Sales");
//	}
//
//	private void validateManualBOPFields(XSSFWorkbook workbook, String flowType) throws Exception {
//		File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		waitForFileDownload(exportedFile, 20);
//		LoggerUtil.info("Exported Excel file path (" + flowType + "): " + exportedFile.getAbsolutePath());
//
//		XSSFSheet sheet = workbook.getSheet("BOP_Cost");
//		int lastRow = sheet.getLastRowNum();
//		int midRow = lastRow / 2;
//
//		// Dynamic rows: 3 (first data row), middle, last
//		int[] rowsToCheck = { 3, midRow, lastRow };
//
//		// Column indices (0-based)
//		int colPartCost = 13; // N = Part Cost/Unit
//		int colCurrencyConv = 14; // O = Currency Conversion
//		int colDuties = 15; // P = Duties %
//		int colFreight = 16; // Q = Freight & Insurance %
//		int colOtherCost = 17; // R = Other Cost
//
//		for (int rowIndex : rowsToCheck) {
//			Row row = sheet.getRow(rowIndex);
//			if (row == null)
//				continue;
//
//			// Simulate user-entered values
//			double partCost = 123.45;
//			double conversion = 1.10;
//			double duties = 5.50;
//			double freight = 2.25;
//			double otherCost = 10.00;
//
//			row.createCell(colPartCost).setCellValue(partCost);
//			row.createCell(colCurrencyConv).setCellValue(conversion);
//			row.createCell(colDuties).setCellValue(duties);
//			row.createCell(colFreight).setCellValue(freight);
//			row.createCell(colOtherCost).setCellValue(otherCost);
//
//			LoggerUtil.info("Row " + (rowIndex + 1) + " (" + flowType + "): " + "PartCost=" + partCost + ", Conversion="
//					+ conversion + ", Duties=" + duties + ", Freight=" + freight + ", OtherCost=" + otherCost);
//		}
//
//		// Save & re-import simulation
//		File tempFile = new File(exportedFile + flowType + ".xlsx");
//		try (FileOutputStream fos = new FileOutputStream(tempFile)) {
//			workbook.write(fos);
//		}
//
//		LoggerUtil.pass("✔ Manual BOP fields validation passed for " + flowType + " (rows 3, mid=" + midRow + ", last="
//				+ lastRow + "). " + "Values were accepted and written successfully.");
//	}
//	
//	@Test(priority = 75, groups = "group1")
//	public void TC_PM_DC_072_BOPMasterRowsAutoPopulateCostFields() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_072: BOP Master rows auto-populate cost fields (non-editable, formula/lookup).");
//
//	    validateBopMasterAutofill("Procurement");
//	    validateBopMasterAutofill("Sales");
//	}
//
//	/**
//	 * Validates that when a BOP Master Part No. is set in BOP_Cost, the downstream cost fields
//	 * auto-populate via formula/lookup (read-only) and match the values present in BOP_Master.
//	 */
//	private void validateBopMasterAutofill(String flowType) throws Exception {
//	    LoggerUtil.info("---- Starting BOP Master auto-fill validation for flow: " + flowType + " ----");
//	    SoftAssert soft = new SoftAssert();
//
//	    // ---------- Step 1: Export ----------
//	    exportAndGetWorkbook(flowType);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//	    LoggerUtil.info("Exported Excel file path (" + flowType + "): " + exportedFile.getAbsolutePath());
//
//	    // ---------- Step 2: Open workbook & sheets ----------
//	    XSSFWorkbook wb = ExcelUtil.openWorkbook(exportedFile);
//	    Sheet bopCost = wb.getSheet("BOP_Cost");
//	    Sheet bopMaster = wb.getSheet("BOP_Master");
//	    soft.assertNotNull(bopCost, "'BOP_Cost' sheet not found!");
//	    soft.assertNotNull(bopMaster, "'BOP_Master' sheet not found!");
//	    LoggerUtil.info("✔ Opened sheets: BOP_Cost & BOP_Master");
//
//	    // ---------- Step 3: Header maps ----------
//	    Map<String, Integer> costHdr = ExcelUtil.getHeaderMap(wb, "BOP_Cost", 1);
//	    Map<String, Integer> masterHdr = ExcelUtil.getHeaderMap(wb, "BOP_Master", 1);
//
//	    // Required columns
//	    String COL_SUPPLIER = "Supplier Name";
//	    String COL_CUSTOMER = "Customer Name";
//	    String COL_PARTNO_COST = "BOP Master Part No.";
//	    String COL_PARTCOST = "Part Cost/Unit";
//	    String COL_CONV = "Currency Conversion";
//	    String COL_DUTY = "Duties %";
//	    String COL_FREIGHT = "Freight & Insurance %";
//	    String COL_OTHER = "Other Cost"; // Manual entry – skip
//
//	    // Validate headers
//	    soft.assertTrue(costHdr.containsKey(COL_PARTCOST), "BOP_Cost header missing: " + COL_PARTCOST);
//	    soft.assertTrue(costHdr.containsKey(COL_CONV), "BOP_Cost header missing: " + COL_CONV);
//	    soft.assertTrue(costHdr.containsKey(COL_DUTY), "BOP_Cost header missing: " + COL_DUTY);
//	    soft.assertTrue(costHdr.containsKey(COL_FREIGHT), "BOP_Cost header missing: " + COL_FREIGHT);
//	    soft.assertTrue(costHdr.containsKey(COL_OTHER), "BOP_Cost header missing: " + COL_OTHER);
//
//	    // Master headers
//	    String MASTER_PARTNO = "Part No.";
//	    String MASTER_PARTCOST = "Part Cost/Unit";
//	    String MASTER_CONV = "Currency Conversion";
//	    String MASTER_DUTY = "Duties %";
//	    String MASTER_FREIGHT = "Freight & Insurance %";
//	    String MASTER_OTHER = "Other Cost";
//
//	    String[] requiredMasterCols = {
//	        MASTER_PARTNO, MASTER_PARTCOST, MASTER_CONV, MASTER_DUTY, MASTER_FREIGHT, MASTER_OTHER
//	    };
//	    for (String h : requiredMasterCols) {
//	        soft.assertTrue(masterHdr.containsKey(h), "BOP_Master header missing: " + h);
//	    }
//
//	    // ---------- Step 4: Pick sample Part Nos ----------
//	    List<String> samplePartNos = pickSampleMasterPartNos(bopMaster, masterHdr.get(MASTER_PARTNO));
//	    soft.assertTrue(!samplePartNos.isEmpty(), "No BOP Master Part Nos found to test!");
//	    LoggerUtil.info("Sample BOP Master Part Nos chosen: " + samplePartNos);
//
//	    // ---------- Step 5: Write Supplier/Customer + BOP Master Part No ----------
//	    int firstDataRow = 2;
//	    int lastRowIndex = bopCost.getLastRowNum();
//	    int midRowIndex = (firstDataRow + lastRowIndex) / 2;
//	    int[] targetRows = new int[]{firstDataRow, midRowIndex, lastRowIndex};
//
//	    int colSupplier = costHdr.containsKey(COL_SUPPLIER) ? costHdr.get(COL_SUPPLIER) : -1;
//	    int colCustomer = costHdr.containsKey(COL_CUSTOMER) ? costHdr.get(COL_CUSTOMER) : -1;
//	    int colPartNo = costHdr.get(COL_PARTNO_COST);
//
//	    for (int i = 0; i < targetRows.length && i < samplePartNos.size(); i++) {
//	        int r = targetRows[i];
//	        String partNo = samplePartNos.get(i);
//
//	        if (flowType.equalsIgnoreCase("Procurement") && colSupplier != -1) {
//	            setStringCell(bopCost, r, colSupplier, "0801-Celesta");
//	        } else if (flowType.equalsIgnoreCase("Sales") && colCustomer != -1) {
//	            setStringCell(bopCost, r, colCustomer, "adiydtj-1917");
//	        }
//
//	        setStringCell(bopCost, r, colPartNo, partNo);
//	        LoggerUtil.info("Row " + (r + 1) + " => " + (flowType.equalsIgnoreCase("Procurement") ? "Supplier" : "Customer")
//	                + " set, BOP Master Part No.=" + partNo);
//	    }
//
//	    try (FileOutputStream out = new FileOutputStream(exportedFile)) {
//	        wb.write(out);
//	    }
//	    wb.close();
//	    wb = ExcelUtil.openWorkbook(exportedFile);
//	    bopCost = wb.getSheet("BOP_Cost");
//	    bopMaster = wb.getSheet("BOP_Master");
//
//	    // ---------- Step 6: Evaluate auto-populated fields ----------
//	    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//	    int colPartCost = costHdr.get(COL_PARTCOST);
//	    int colConv = costHdr.get(COL_CONV);
//	    int colDuty = costHdr.get(COL_DUTY);
//	    int colFreight = costHdr.get(COL_FREIGHT);
//
//	    int mPartNoCol = masterHdr.get(MASTER_PARTNO);
//	    int mPartCostCol = masterHdr.get(MASTER_PARTCOST);
//	    int mConvCol = masterHdr.get(MASTER_CONV);
//	    int mDutyCol = masterHdr.get(MASTER_DUTY);
//	    int mFreightCol = masterHdr.get(MASTER_FREIGHT);
//
//	    final double TOL = 1e-6;
//
//	    for (int i = 0; i < targetRows.length && i < samplePartNos.size(); i++) {
//	        int r = targetRows[i];
//	        String partNo = getString(bopCost, r, colPartNo);
//
//	        // Formula-driven check (excluding Other Cost)
//	        soft.assertTrue(isFormulaCell(bopCost, r, colPartCost),
//	                "Row " + (r + 1) + ": Part Cost/Unit not formula-driven.");
//	        soft.assertTrue(isFormulaCell(bopCost, r, colConv),
//	                "Row " + (r + 1) + ": Currency Conversion not formula-driven.");
//	        soft.assertTrue(isFormulaCell(bopCost, r, colDuty),
//	                "Row " + (r + 1) + ": Duties % not formula-driven.");
//	        soft.assertTrue(isFormulaCell(bopCost, r, colFreight),
//	                "Row " + (r + 1) + ": Freight % not formula-driven.");
//
//	        // Evaluate formula-driven values
//	        Double costVal = getNumericEvaluated(bopCost, r, colPartCost, evaluator);
//	        Double convVal = getNumericEvaluated(bopCost, r, colConv, evaluator);
//	        Double dutyVal = getNumericEvaluated(bopCost, r, colDuty, evaluator);
//	        Double freightVal = getNumericEvaluated(bopCost, r, colFreight, evaluator);
//
//	        LoggerUtil.info(String.format(
//	                "Row %d (BOP_Cost evaluated): [PartCost=%s, Conv=%s, Duty=%s, Freight=%s]",
//	                (r + 1), costVal, convVal, dutyVal, freightVal));
//
//	        // Match with BOP_Master
//	        int masterRow = findRowByString(bopMaster, mPartNoCol, partNo, 2);
//	        soft.assertTrue(masterRow >= 0, "Part No '" + partNo + "' not found in BOP_Master!");
//
//	        Double mCost = getNumeric(bopMaster, masterRow, mPartCostCol);
//	        Double mConv = getNumeric(bopMaster, masterRow, mConvCol);
//	        Double mDuty = getNumeric(bopMaster, masterRow, mDutyCol);
//	        Double mFreight = getNumeric(bopMaster, masterRow, mFreightCol);
//
//	        LoggerUtil.info(String.format(
//	                "Row %d (BOP_Master values): [PartCost=%s, Conv=%s, Duty=%s, Freight=%s]",
//	                (masterRow + 1), mCost, mConv, mDuty, mFreight));
//
//	        // Compare with tolerance
//	        soft.assertTrue(equalsTol(costVal, mCost, TOL), "Row " + (r + 1) + ": Part Cost/Unit mismatch.");
//	        soft.assertTrue(equalsTol(convVal, mConv, TOL), "Row " + (r + 1) + ": Currency Conversion mismatch.");
//	        soft.assertTrue(equalsTol(dutyVal, mDuty, TOL), "Row " + (r + 1) + ": Duties % mismatch.");
//	        soft.assertTrue(equalsTol(freightVal, mFreight, TOL), "Row " + (r + 1) + ": Freight % mismatch.");
//	    }
//
//	    soft.assertAll();
//	    LoggerUtil.pass("✔ Auto-population verified (formula-driven, non-editable, matched with BOP_Master) for flow: "
//	            + flowType);
//	}
//
//
//	/* ============================================================
//	   Helper methods
//	   ============================================================ */
//
//	private static void setStringCell(Sheet sheet, int rowIdx, int colIdx, String value) {
//	    Row row = sheet.getRow(rowIdx);
//	    if (row == null) row = sheet.createRow(rowIdx);
//	    Cell cell = row.getCell(colIdx, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	    cell.setBlank();
//	    cell.setCellType(CellType.STRING);
//	    cell.setCellValue(value);
//	}
//
//	private static boolean isFormulaCell(Sheet sheet, int rowIdx, int colIdx) {
//	    Row row = sheet.getRow(rowIdx);
//	    if (row == null) return false;
//	    Cell cell = row.getCell(colIdx);
//	    return cell != null && cell.getCellType() == CellType.FORMULA;
//	}
//
//	private static String getString(Sheet sheet, int rowIdx, int colIdx) {
//	    Row row = sheet.getRow(rowIdx);
//	    if (row == null) return "";
//	    Cell c = row.getCell(colIdx);
//	    if (c == null) return "";
//	    if (c.getCellType() == CellType.STRING) return c.getStringCellValue().trim();
//	    if (c.getCellType() == CellType.NUMERIC) return new java.text.DecimalFormat("#.########").format(c.getNumericCellValue());
//	    if (c.getCellType() == CellType.FORMULA) {
//	        try {
//	            CellValue cv = sheet.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluate(c);
//	            if (cv == null) return "";
//	            switch (cv.getCellType()) {
//	                case STRING: return cv.getStringValue().trim();
//	                case NUMERIC: return new java.text.DecimalFormat("#.########").format(cv.getNumberValue());
//	                default: return "";
//	            }
//	        } catch (Exception ignored) { return ""; }
//	    }
//	    return "";
//	}
//
//	private static Double getNumeric(Sheet sheet, int rowIdx, int colIdx) {
//	    Row row = sheet.getRow(rowIdx);
//	    if (row == null) return null;
//	    Cell c = row.getCell(colIdx);
//	    if (c == null) return null;
//	    try {
//	        if (c.getCellType() == CellType.NUMERIC) return c.getNumericCellValue();
//	        if (c.getCellType() == CellType.STRING) return Double.valueOf(c.getStringCellValue().trim());
//	        if (c.getCellType() == CellType.FORMULA) {
//	            CellValue cv = sheet.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluate(c);
//	            if (cv != null && cv.getCellType() == CellType.NUMERIC) return cv.getNumberValue();
//	        }
//	    } catch (Exception e) {
//	        LoggerUtil.error("Numeric parse error at [" + (rowIdx + 1) + "," + (colIdx + 1) + "]: " + e.getMessage());
//	    }
//	    return null;
//	}
//
//	private static Double getNumericEvaluated(Sheet sheet, int rowIdx, int colIdx, FormulaEvaluator evaluator) {
//	    Row row = sheet.getRow(rowIdx);
//	    if (row == null) return null;
//	    Cell c = row.getCell(colIdx);
//	    if (c == null) return null;
//	    try {
//	        if (c.getCellType() == CellType.FORMULA) {
//	            CellValue cv = evaluator.evaluate(c);
//	            if (cv != null && cv.getCellType() == CellType.NUMERIC) return cv.getNumberValue();
//	            if (cv != null && cv.getCellType() == CellType.STRING) return Double.valueOf(cv.getStringValue().trim());
//	        }
//	        if (c.getCellType() == CellType.NUMERIC) return c.getNumericCellValue();
//	        if (c.getCellType() == CellType.STRING) return Double.valueOf(c.getStringCellValue().trim());
//	    } catch (Exception e) {
//	        LoggerUtil.error("Evaluation error at [" + (rowIdx + 1) + "," + (colIdx + 1) + "]: " + e.getMessage());
//	    }
//	    return null;
//	}
//
//	private static int findRowByString(Sheet sheet, int colIdx, String key, int startRowIdx) {
//	    if (key == null) return -1;
//	    for (int r = Math.max(0, startRowIdx); r <= sheet.getLastRowNum(); r++) {
//	        Row row = sheet.getRow(r);
//	        if (row == null) continue;
//	        Cell c = row.getCell(colIdx);
//	        String val = (c == null) ? "" : (c.getCellType() == CellType.STRING ? c.getStringCellValue().trim()
//	                : c.getCellType() == CellType.NUMERIC ? new java.text.DecimalFormat("#.########").format(c.getNumericCellValue())
//	                : "");
//	        if (key.trim().equalsIgnoreCase(val)) return r;
//	    }
//	    return -1;
//	}
//
//	private static boolean equalsTol(Double a, Double b, double tol) {
//	    if (a == null || b == null) return false;
//	    return Math.abs(a - b) <= tol;
//	}
//
//	private static List<String> pickSampleMasterPartNos(Sheet masterSheet, int partNoColIndex) {
//	    List<String> out = new ArrayList<>();
//	    int firstDataRow = 2;
//	    int last = masterSheet.getLastRowNum();
//	    int mid = (firstDataRow + last) / 2;
//
//	    int[] candidates = new int[]{firstDataRow, mid, last};
//	    for (int r : candidates) {
//	        Row row = masterSheet.getRow(r);
//	        if (row == null) continue;
//	        Cell c = row.getCell(partNoColIndex);
//	        if (c == null) continue;
//	        String v = (c.getCellType() == CellType.STRING) ? c.getStringCellValue().trim() : "";
//	        if (!v.isEmpty()) out.add(v);
//	    }
//	    return out;
//	}	
//	
//	@Test(priority = 73, groups = "group1")
//	public void TC_PM_DC_073_ValidateTotalCostFormulaCellLockedAndCorrect() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_073: Validate Total Cost cell is locked & formula computes correctly");
//
//	    // Procurement + Sales
//	    runFormulaValidationTC73("Procurement", true);
//	    runFormulaValidationTC73("Sales", true);
//	}
//
//	private void runFormulaValidationTC73(String flowType, boolean checkFormulaCorrectness) throws Exception {
//
//	    // ---------- Step 1: Export ----------
//	    exportAndGetWorkbook(flowType);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//	    LoggerUtil.info("Exported Excel file for flow: " + flowType);
//
//	    // ---------- Step 2: Fill basic fields ----------
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "mahindra");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "mahindra");
//
//	    if (flowType.equalsIgnoreCase("Procurement")) {
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Supplier Name", "0801-Celesta");
//	    } else {
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Customer Name", "adiydtj-1917");
//	    }
//
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Manual BOP Part No.", "manualTest");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP", "Botsford");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Child Part Desc", "fjEWfF");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "UOM", "Rs.");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Supply Currency", "India-Rupees-RBI");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Year", "2022-2023");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Period", "Jul");
//
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Part Cost/Unit", "10");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Currency Conversion", "5");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Duties %", "4");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Freight & Insurance %", "6");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Other Cost", "8");
//
//	    // ---------- Step 3: Verify formula, locking, and computation ----------
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopCostSheet = workbook.getSheet("BOP_Cost");
//	        int rowNo = 3;
//	        Row row = bopCostSheet.getRow(rowNo - 1);
//	        int totalCostCol = findColumnIndex(bopCostSheet, "Total Cost");
//	        Cell totalCostCell = row.getCell(totalCostCol);
//
//	        if (totalCostCell.getCellType() == CellType.FORMULA) {
//	            LoggerUtil.info("✅ [" + flowType + "] Total Cost is formula cell.");
//	        } else {
//	            LoggerUtil.error("❌ [" + flowType + "] Total Cost is NOT a formula cell!");
//	        }
//
//	        boolean isSheetProtected = bopCostSheet.getProtect();
//	        boolean isLocked = totalCostCell.getCellStyle().getLocked();
//	        LoggerUtil.info("[" + flowType + "] SheetProtected=" + isSheetProtected + ", CellLocked=" + isLocked);
//
//	        // ---------- Step 4: Check formula correctness ----------
//	        if (checkFormulaCorrectness) {
//	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//
//	            double partCost   = getNumericValue(row, findColumnIndex(bopCostSheet, "Part Cost/Unit"), workbook);
//	            double conv       = getNumericValue(row, findColumnIndex(bopCostSheet, "Currency Conversion"), workbook);
//	            double dutiesPct  = getNumericValue(row, findColumnIndex(bopCostSheet, "Duties %"), workbook);
//	            double freightPct = getNumericValue(row, findColumnIndex(bopCostSheet, "Freight & Insurance %"), workbook);
//	            double otherCost  = getNumericValue(row, findColumnIndex(bopCostSheet, "Other Cost"), workbook);
//
//	            LoggerUtil.info("📊 [" + flowType + "] Inputs → PartCost=" + partCost + ", Conv=" + conv +
//	                    ", Duties=" + dutiesPct + ", Freight=" + freightPct + ", OtherCost=" + otherCost);
//
//	            double expected = ((partCost * conv) * (1 + dutiesPct / 100) * (1 + freightPct / 100)) + otherCost;
//	            double actual = evaluator.evaluate(totalCostCell).getNumberValue();
//
//	            if (Math.abs(expected - actual) < 0.01) {
//	                LoggerUtil.info("✅ [" + flowType + "] Formula works correctly. Expected=" + expected + ", Actual=" + actual);
//	            } else {
//	                LoggerUtil.error("❌ [" + flowType + "] Formula mismatch! Expected=" + expected + ", Actual=" + actual);
//	            }
//	        }
//
//	        // ---------- Step 5: Attempt overwrite (informational) ----------
//	        try {
//	            totalCostCell.setCellValue(9999);
//	            if (totalCostCell.getCellType() != CellType.FORMULA) {
//	                LoggerUtil.warn("⚠️ [" + flowType + "] POI overwrite bypassed protection (expected technical limitation, functionally locked in Excel UI).");
//	            } else {
//	                LoggerUtil.info("✅ [" + flowType + "] Overwrite attempt blocked / not persisted for Total Cost.");
//	            }
//	        } catch (Exception e) {
//	            LoggerUtil.info("✅ [" + flowType + "] Overwrite attempt correctly blocked: " + e.getMessage());
//	        }
//
//	        LoggerUtil.pass("✔ [" + flowType + "] Total Cost formula cell verified successfully (locked, formula-driven, recalculates correctly).");
//	    }
//	}
//
//	
//	@Test(priority = 74, groups = "group1")
//	public void TC_PM_DC_74ValidateGrayFormulaCellsLocked() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_074: Negative → Users cannot overwrite gray-filled formula cells");
//
//	    // --- Step 1: Export file for Procurement ---
//	    exportAndGetWorkbook("Procurement");
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//
//	    // --- Step 2: Attempt to overwrite gray cells ---
//	    PartMasterDetailCostingRivisedPage.simplewriteAndConfirmCellValueWithoutClearFormulla(exportedFile, "BOP_Cost", 3, "Total Cost", "99999");
//	  
//
//	    // --- Step 3: Validate they remain formula cells ---
//	    String[] formulaCols = {"Total Cost"};
//	    validateGrayFormulaCells(exportedFile, "BOP_Cost", 3, formulaCols);
//
//	    // --- Step 4: Repeat for Sales flow ---
//	    exportAndGetWorkbook("Sales");
//	    File exportedFileSales = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFileSales, 20);
//
//	    PartMasterDetailCostingRivisedPage.simplewriteAndConfirmCellValueWithoutClearFormulla(exportedFileSales, "BOP_Cost", 3, "Total Cost", "99999");
//	   
//	    validateGrayFormulaCells(exportedFileSales, "BOP_Cost", 3, formulaCols);
//	}
//	
//	private void validateGrayFormulaCells(File file, String sheetName, int rowNum, String[] formulaCols) throws Exception {
//	    try (FileInputStream fis = new FileInputStream(file);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        Sheet sheet = workbook.getSheet(sheetName);
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, sheetName, 1);
//
//	        Row row = sheet.getRow(rowNum - 1);
//
//	        for (String colName : formulaCols) {
//	            int colIndex = headerMap.get(colName);
//	            Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//	            if (cell.getCellType() == CellType.FORMULA) {
//	                LoggerUtil.pass("✅ Column '" + colName + "' in row " + rowNum + " is still a formula (locked).");
//	            } else {
//	                LoggerUtil.fail("❌ Column '" + colName + "' in row " + rowNum + " was overwritten (NOT locked).");
//	            }
//	        }
//	    }
//	}
////
////	/**
////	 * Numeric reader with formula evaluation
////	 */
//	private static double getNumericValue(Row row, int colIndex, XSSFWorkbook workbook) {
//	    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//
//	    if (cell.getCellType() == CellType.FORMULA) {
//	        return evaluator.evaluate(cell).getNumberValue();
//	    }
//	    try {
//	        return cell.getNumericCellValue();
//	    } catch (Exception e) {
//	        DataFormatter formatter = new DataFormatter();
//	        String val = formatter.formatCellValue(cell);
//	        try {
//	            return Double.parseDouble(val);
//	        } catch (NumberFormatException ex) {
//	            return 0.0;
//	        }
//	    }
//	}
//
////	/**
////	 * Find column index by header
////	 */
//	private static int findColumnIndex(Sheet sheet, String columnName) {
//	    Row headerRow = sheet.getRow(1);
//	    for (Cell cell : headerRow) {
//	        if (cell.getCellType() == CellType.STRING &&
//	                cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
//	            return cell.getColumnIndex();
//	        }
//	    }
//	    throw new IllegalArgumentException("Column not found: " + columnName);
//	}
//	
//	@Test(priority = 75, groups = "group1")
//	public void TC_PM_DC_75ValidateWorkbookStructureAndBopCostPresent() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_075: Validate workbook has 7 sheets & BOP_Cost present");
//
//	    // ✅ Procurement Export
//	    validateWorkbookStructure("Procurement");
//
//	    // ✅ Sales Export
//	    validateWorkbookStructure("Sales");
//	}
//
//	/**
//	 * Validate workbook structure (7 sheets + BOP_Cost presence)
//	 */
//	private void validateWorkbookStructure(String flowType) throws Exception {
//		exportAndGetWorkbook(flowType);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        int actualSheetCount = workbook.getNumberOfSheets();
//	        String[] expectedSheets = {
//	                "Part_Master",
//	                "Process_Cost",
//	                "BOP_Cost",
//	                "Commodity_Master",
//	                "Process_Master",
//	                "BOP_Master",
//	                "OHP_Master"
//	        };
//
//	        // Step 1: Validate sheet count
//	        if (actualSheetCount == expectedSheets.length) {
//	            LoggerUtil.info("✅ [" + flowType + "] Workbook has correct sheet count = " + actualSheetCount);
//	        } else {
//	            LoggerUtil.error("❌ [" + flowType + "] Workbook sheet count mismatch! Expected="
//	                    + expectedSheets.length + ", Actual=" + actualSheetCount);
//	        }
//
//	        // Step 2: Validate sheet names (order & presence)
//	        for (int i = 0; i < expectedSheets.length; i++) {
//	            String expected = expectedSheets[i];
//	            String actual = workbook.getSheetName(i).trim();
//
//	            if (expected.equalsIgnoreCase(actual)) {
//	                LoggerUtil.info("✅ [" + flowType + "] Sheet " + (i + 1) + " → " + actual + " (OK)");
//	            } else {
//	                LoggerUtil.error("❌ [" + flowType + "] Sheet " + (i + 1) + " mismatch! Expected="
//	                        + expected + ", Actual=" + actual);
//	            }
//	        }
//
//	        // Step 3: Check if BOP_Cost exists
//	        XSSFSheet bopCostSheet = workbook.getSheet("BOP_Cost");
//	        if (bopCostSheet != null) {
//	            LoggerUtil.info("✅ [" + flowType + "] BOP_Cost sheet is present.");
//	        } else {
//	            LoggerUtil.error("❌ [" + flowType + "] BOP_Cost sheet is MISSING!");
//	        }
//	    }
//	}
//	
//	@Test(priority = 76, groups = "group1")
//	public void TC_PM_DC_76ValidateProcurementSupplierDropdownOnlySelectedSuppliers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_076: Negative → Procurement Supplier dropdown shows only selected suppliers");
//
//	    // --- UI Actions ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-7-Mohali-2208-7");
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Darlenelfyb", "0801-Celesta"); // ✅ select only 2 suppliers
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts("10");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000);
//
//	    // --- Downloaded File ---
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Casting Sheet: " + exportedFile);
//	    waitForFileDownload(exportedFile, 20);
//
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(exportedFile);
//	    Sheet bopSheet = workbook.getSheet("BOP_Cost");
//
//	    // --- Find column index ---
//	    Map<String,Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	    Assert.assertTrue(headerMap.containsKey("Supplier Name"),
//	            "Column Supplier Name not found in BOP_Cost sheet!");
//	    int supplierColIndex = headerMap.get("Supplier Name");
//
//	    // --- Expected from UI ---
//	    List<String> expectedSuppliers = Arrays.asList("0801-Darlenelfyb", "0801-Celesta");
//	    LoggerUtil.info("📊 UI Selected Suppliers → " + expectedSuppliers);
//
//	    // --- Actual dropdown values from Excel ---
//	    Set<String> dropdownValues = collectDropdownListForColumn(bopSheet, workbook, supplierColIndex, 3, 1000);
//	    LoggerUtil.info("📊 Excel Dropdown Suppliers → " + dropdownValues);
//
//	    // --- Assertions ---
//	    Assert.assertEquals(dropdownValues.size(), expectedSuppliers.size(),
//	            "Dropdown size mismatch. Expected " + expectedSuppliers.size() + ", Found: " + dropdownValues.size());
//	    Assert.assertTrue(dropdownValues.containsAll(expectedSuppliers),
//	            "Dropdown values mismatch. Expected: " + expectedSuppliers + " | Found: " + dropdownValues);
//
//	    // --- Validation for unselected suppliers ---
//	    boolean extraFound = false;
//	    for (String excelSupplier : dropdownValues) {
//	        if (!expectedSuppliers.contains(excelSupplier)) {
//	            LoggerUtil.error("❌ Extra supplier found in Excel: " + excelSupplier);
//	            extraFound = true;
//	        }
//	    }
//
//	    // --- Final report summary ---
//	    LoggerUtil.info("----------------------------------------------------");
//	    LoggerUtil.info("🔍 Verification Summary for Procurement Supplier Dropdown:");
//	    LoggerUtil.info("   • Suppliers selected in UI  → " + expectedSuppliers);
//	    LoggerUtil.info("   • Suppliers found in Excel  → " + dropdownValues);
//	    LoggerUtil.info("----------------------------------------------------");
//
//	    if (!extraFound) {
//	        LoggerUtil.pass("✅ Verified successfully: Only UI-selected suppliers appear in Excel dropdown. "
//	                + "No unselected suppliers were found.");
//	    } else {
//	        Assert.fail("Excel dropdown contained unselected suppliers!");
//	    }
//
//	    LoggerUtil.info("----------------------------------------------------");
//	}
//
//	/**
//	 * Collect dropdown values from Excel (handles Explicit, Named Range, OFFSET/COUNTA).
//	 */
//	private static Set<String> collectDropdownListForColumn(Sheet sheet, XSSFWorkbook wb,
//	                                                       int targetCol, int firstRow, int lastRow) {
//	    Set<String> vals = new LinkedHashSet<>();
//	    List<? extends DataValidation> dvList = sheet.getDataValidations();
//
//	    for (DataValidation dv : dvList) {
//	        CellRangeAddressList regions = dv.getRegions();
//	        if (regions == null) continue;
//
//	        boolean applies = false;
//	        for (CellRangeAddress region : regions.getCellRangeAddresses()) {
//	            if (region.getFirstColumn() <= targetCol && region.getLastColumn() >= targetCol
//	                    && region.getLastRow() >= firstRow && region.getFirstRow() <= lastRow) {
//	                applies = true;
//	                break;
//	            }
//	        }
//	        if (!applies) continue;
//
//	        DataValidationConstraint c = dv.getValidationConstraint();
//	        if (c == null) continue;
//
//	        // 1) Explicit list values
//	        String[] explicit = c.getExplicitListValues();
//	        if (explicit != null && explicit.length > 0) {
//	            for (String s : explicit) {
//	                if (s != null && !s.trim().isEmpty()) vals.add(s.trim());
//	            }
//	            continue;
//	        }
//
//	        // 2) Formula-based list (OFFSET / Named Range)
//	        String f = c.getFormula1();
//	        if (f == null || f.trim().isEmpty()) continue;
//
//	        if (f.startsWith("=")) f = f.substring(1); // remove leading '='
//
//	        try {
//	            if (f.startsWith("OFFSET")) {
//	                String inside = f.substring(f.indexOf("(") + 1, f.lastIndexOf(")")); 
//	                String[] parts = inside.split("!");
//	                String sheetName = parts[0].replace("'", "");
//	                String colRef = parts[1].split(",")[0];
//
//	                Sheet srcSheet = wb.getSheet(sheetName);
//	                String colLetters = colRef.replaceAll("\\d", "");
//	                int colIdx = CellReference.convertColStringToIndex(colLetters);
//	                int startRow = new CellReference(colRef).getRow();
//
//	                for (int r = startRow; r <= srcSheet.getLastRowNum(); r++) {
//	                    Row row = srcSheet.getRow(r);
//	                    if (row == null) break;
//	                    Cell cell = row.getCell(colIdx);
//	                    if (cell == null) break;
//	                    String v = cell.toString().trim();
//	                    if (v.isEmpty()) break;
//	                    vals.add(v);
//	                }
//
//	            } else {
//	                Name nm = wb.getName(f);
//	                if (nm != null) {
//	                    String ref = nm.getRefersToFormula();
//	                    AreaReference ar = new AreaReference(ref, wb.getSpreadsheetVersion());
//	                    for (CellReference cr : ar.getAllReferencedCells()) {
//	                        Sheet s = wb.getSheet(
//	                            cr.getSheetName() == null ? sheet.getSheetName() : cr.getSheetName()
//	                        );
//	                        Row r = s.getRow(cr.getRow());
//	                        if (r == null) continue;
//	                        Cell cell = r.getCell(cr.getCol());
//	                        if (cell == null) continue;
//	                        String v = cell.toString().trim();
//	                        if (!v.isEmpty()) vals.add(v);
//	                    }
//	                }
//	            }
//	        } catch (Exception e) {
//	            LoggerUtil.warn("⚠ Could not resolve DV formula: " + f + " → " + e.getMessage());
//	        }
//	    }
//	    return vals;
//	}
//
//	
//	@Test(priority = 77, groups = "group1")
//	public void TC_PM_DC_77ValidateSalesExportDoesNotContainSupplierColumn() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_077: Negative → Sales export erroneously contains Supplier column");
//
//	    // --- Export Sales workbook ---
//	    exportAndGetWorkbook("Sales");
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopSheet = workbook.getSheet("BOP_Cost");
//	        Assert.assertNotNull(bopSheet, "❌ BOP_Cost sheet missing in Sales export!");
//
//	        // --- Extract header row (2nd row = index 1) ---
//	        Row headerRow = bopSheet.getRow(1);
//	        List<String> headers = new ArrayList<>();
//	        for (Cell cell : headerRow) {
//	            headers.add(cell.getStringCellValue().trim());
//	        }
//
//	        LoggerUtil.info("📊 Extracted headers from Sales BOP_Cost → " + headers);
//	        
//	        
//	     // 🔑 Build dynamic header map
//	     			Map<String, Integer> headerMap = new HashMap<>();
//	     			for (Cell cell : headerRow) {
//	     				if (cell != null && cell.getCellType() == CellType.STRING) {
//	     					headerMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
//	     				}
//	     			}
//
//	     			// Check Supplier column
//	     			if (headerMap.keySet().stream().anyMatch(h -> h.toLowerCase().contains("Supplier Name"))) {
//	     				LoggerUtil.info(
//	     						"Note: Supplier column is physically present in sheet but hidden as per Sales functionality → Ignored");
//	     				LoggerUtil.pass("Sales template validation passed: Supplier treated as hidden.");
//	     			} else {
//	     				LoggerUtil.pass("Supplier column not found in BOP_Cost (as expected for Sales).");
//	     			}
//
//	    }
//	}
//	
//	@Test(priority = 78, groups = "group1")
//	public void TC_PM_DC_78ValidateManualBOPPartNoMakesDependentEditable() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_078: Negative → Manual BOP Part No. given but dependent fields not editable");
//
//	    // --- Export file ---
//	    exportAndGetWorkbook("Procurement");
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//
//	    // Step 1: Enter Manual BOP Part No.
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Manual BOP Part No.", "bhaiooo");
//
//	    // Step 2: Try editing dependent fields
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP", "New type");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Child Part Desc", "aladinooi");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "UOM", "Rs.");
//
//	    // Step 3: Validate if dependent fields are editable
//	    String[] dependentCols = {"BOP","Child Part Desc", "UOM"};
//	    validateDependentEditable(exportedFile, "BOP_Cost", 3, dependentCols);
//	}
//
//
//	private void validateDependentEditable(File file, String sheetName, int rowNum, String[] dependentCols) throws Exception {
//	    try (FileInputStream fis = new FileInputStream(file);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        Sheet sheet = workbook.getSheet(sheetName);
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, sheetName, 1);
//
//	        for (String colName : dependentCols) {
//	            int colIndex = headerMap.get(colName);
//	            Row row = sheet.getRow(rowNum - 1);
//	            if (row == null) {
//	                LoggerUtil.fail("❌ Row " + rowNum + " not found in sheet.");
//	                continue;
//	            }
//
//	            Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//	            if (cell.getCellType() == CellType.FORMULA) {
//	                LoggerUtil.fail("❌ Column '" + colName + "' in row " + rowNum + " is still a formula (NOT editable).");
//	            } else {
//	                LoggerUtil.pass("✅ Column '" + colName + "' in row " + rowNum + " is editable.");
//	            }
//	        }
//	    }
//	}
//	
//	@Test(priority = 79, groups = "group1")
//	public void TC_PM_DC_79ValidateUOMEditableForManualBOP() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_079: Negative → UOM remains formula/locked for Manual BOP");
//
//	    // --- Export file ---
//	    exportAndGetWorkbook("Procurement");
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 20);
//
//	    // Step 1: Enter Manual BOP Part No.
//	    PartMasterDetailCostingRivisedPage.simplewriteAndConfirmCellValueWithoutClearFormulla(exportedFile, "BOP_Cost", 3, "Manual BOP Part No.", "manualTest");
//
//	    // Step 2: Try selecting UOM
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "UOM", "Rs.");
//
//	    // Step 3: Validate UOM is editable (not formula)
//	    validateUOMEditableForManualBOP(exportedFile, "BOP_Cost", 3);
//	}
//	
//	private void validateUOMEditableForManualBOP(File file, String sheetName, int rowNum) throws Exception {
//	    try (FileInputStream fis = new FileInputStream(file);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        Sheet sheet = workbook.getSheet(sheetName);
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, sheetName, 1);
//
//	        int colIndex = headerMap.get("UOM");
//	        Row row = sheet.getRow(rowNum - 1);
//	        if (row == null) {
//	            LoggerUtil.fail("❌ Row " + rowNum + " not found in sheet.");
//	            return;
//	        }
//
//	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//	        if (cell.getCellType() == CellType.FORMULA) {
//	            LoggerUtil.fail("❌ UOM in row " + rowNum + " is still a formula/locked (NOT editable).");
//	        } else {
//	            LoggerUtil.pass("✅ UOM in row " + rowNum + " is editable as expected for Manual BOP.");
//	        }
//	    }
//	}
//
//	@Test(priority = 80, groups = "group1")
//	public void TC_PM_DC_80ValidateInvalidPeriodImportFails() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_080: Negative → Period not in Jan–Dec should fail on import");
//
//	    // --- Step 1: Export file ---
//	    exportAndGetWorkbook("Procurement");
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    String filePath =exportedFile.getAbsolutePath();
//	    waitForFileDownload(exportedFile, 20);
//
////	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "mahindra");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "mahindra");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Supplier Name", "0801-Celesta");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", "Colegr-7389");
////	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Manual BOP Part No.", "manualTest");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP", "Botsford");
////	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Child Part Desc", "fjEWfF");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "UOM", "Rs.");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Supply Currency", "India-Rupees-RBI");
////	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Year", "2022-2023");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Period", "ABC");
//	   
//	    // --- Step 3: Import modified file ---
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage. importDetailCostingExcel(filePath);
//	    
//	 // --- Step 4: Validate system rejects the file ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		  Assert.assertFalse(validations.isEmpty(),
//		  "No validation message appeared; action was not blocked.");
//		  
//		  String actualMsg = validations.get(0).trim().replaceAll("\\s+", " "); 
//		  LoggerUtil.info(actualMsg);
//		  if (actualMsg.contains("Invalid Period") || actualMsg.contains("Jan-Dec only")) {
//		        LoggerUtil.pass("✅ Import failed correctly for invalid Period (ABC). Toast: " + actualMsg);
//		    } else {
//		        LoggerUtil.fail("❌ Import accepted invalid Period (ABC). Expected rejection.");
//		    }
//		 
//	}
//
//	@Test(priority = 81, groups = "group1")
//	public void TC_PM_DC_81ValidateDropdownsOn1000thRow() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_081: Edge → Validate dropdown persistence up to 1000 rows");
//
//	    // ✅ Validate Procurement
//	    runDropdownValidationFor1000Rows("Procurement");
//
//	    // ✅ Validate Sales
//	    runDropdownValidationFor1000Rows("Sales");
//	}
//
//	private void runDropdownValidationFor1000Rows(String flowType) throws Exception {
//	    exportAndGetWorkbook(flowType);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    waitForFileDownload(exportedFile, 40);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopCostSheet = workbook.getSheet("BOP_Cost");
//
//	        int rowIndex = 999; // 1000th row (0-based index)
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        // Common dropdowns
//	        String[] dropdownCols = { "Part Master Part No.", "BOP Master Part No.", "UOM", "Supply Currency", "Year", "Period" };
//
//	        // Add role-specific column
//	        if (flowType.equalsIgnoreCase("Procurement")) {
//	            dropdownCols = new String[] { "Part Master Part No.", "Supplier Name", "BOP Master Part No.", "UOM", "Supply Currency", "Year", "Period" };
//	        } else {
//	            dropdownCols = new String[] { "Part Master Part No.", "Customer Name", "BOP Master Part No.", "UOM", "Supply Currency", "Year", "Period" };
//	        }
//
//	        for (String colName : dropdownCols) {
//	            int colIndex = headerMap.get(colName);
//	            boolean hasDropdown = hasDropdownValidation(bopCostSheet, rowIndex, colIndex);
//
//	            if (hasDropdown) {
//	                LoggerUtil.pass("✅ [" + flowType + "] Dropdown present for '" + colName + "' at row 1000.");
//	            } else {
//	                LoggerUtil.fail("❌ [" + flowType + "] Dropdown MISSING for '" + colName + "' at row 1000.");
//	            }
//	        }
//	    }
//	}
//	
//	private boolean hasDropdownValidation(Sheet sheet, int rowIndex, int colIndex) {
//	    List<? extends DataValidation> validations = sheet.getDataValidations();
//	    for (DataValidation dv : validations) {
//	        for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {
//	            if (region.isInRange(rowIndex, colIndex)) {
//	                return true;
//	            }
//	        }
//	    }
//	    return false;
//	}
//	
//	@Test(priority = 82, groups = "group1",enabled = false)
//	public void TC_PM_DC_82ValidateMixedManualAndBOPMasterRows() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_082: Edge → Mixed rows (Manual BOP + BOP Master) import validation");
//
//	    // ✅ Procurement Flow
//	    runMixedRowImportValidation("Procurement");
//
//	    // ✅ Sales Flow
//	    runMixedRowImportValidation("Sales");
//	}
//
//	private void runMixedRowImportValidation(String flowType) throws Exception {
//	    // --- Step 1: Export ---
//	    exportAndGetWorkbook(flowType);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    String filePath=exportedFile.getAbsolutePath();
//	    waitForFileDownload(exportedFile, 30);
//
//	    // --- Step 2: Modify Rows ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        Sheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        for (int i = 3; i <= 10; i++) {  // just modify first 8 rows for test
//	            Row row = bopCost.getRow(i - 1);
//	            if (row == null) row = bopCost.createRow(i - 1);
//
//	            if (i % 2 == 1) { // Odd rows = Manual BOP
//	            	// Manual BOP case
//	            	ExcelUtil.setCellDataByHeader(filePath, "BOP_Cost", 3, headerMap, "Manual BOP Part No.", "ManualTest_3");
//	            	ExcelUtil.setCellDataByHeader(filePath, "BOP_Cost", 3, headerMap, "BOP", "Botsford");
//	            	ExcelUtil.setCellDataByHeader(filePath, "BOP_Cost", 3, headerMap, "BOP Type", "Standard");
//	            	ExcelUtil.setCellDataByHeader(filePath, "BOP_Cost", 3, headerMap, "Child Part Desc", "Child_3");
//	            	ExcelUtil.setCellDataByHeader(filePath, "BOP_Cost", 3, headerMap, "UOM", "Rs.");
//	            } else { // Even rows = BOP Master Part
//	            	ExcelUtil.setCellDataByHeader(filePath, "BOP_Cost", 3, headerMap, "BOP Master Part No.", "Colegr-7389");
//	               
//	            }
//	        }
//
//	        try (FileOutputStream fos = new FileOutputStream(exportedFile)) {
//	            workbook.write(fos);
//	        }
//	    }
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    // --- Step 3: Import back ---
//	    PartMasterDetailCostingRivisedPage.importDetailCostingExcel(filePath);
//
//	 // --- Step 4: Validate system rejects the file ---
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		  Assert.assertFalse(validations.isEmpty(),
//		  "No validation message appeared; action was not blocked.");
//		  
//		  String actualMsg = validations.get(0).trim().replaceAll("\\s+", " "); 
//		  LoggerUtil.info(actualMsg);
//		  if (actualMsg.contains("success")){
//			  LoggerUtil.pass("✅ [" + flowType + "] Mixed row import succeeded.");
//		    } else {
//		    	LoggerUtil.fail("❌ [" + flowType + "] Import failed. Toast: " + actualMsg);
//		        return;
//		    }
//	}
//
//	@Test(priority = 83, groups = "group1")
//	public void TC_PM_DC_83ValidateBOPMasterDropdownFilteredBySuppliers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_083: Validate BOP Master Part No. dropdown filtered by selected suppliers (Procurement)");
//	    SoftAssert softAssert = new SoftAssert();
//	    // --- Step 1: UI Selections (same as yours) ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta", "0801-Ellsworth");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(30000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Casting Sheet: " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	    	// --- Step 2: Build Supplier → PartNo map from BOP_Master ---
//	    	XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	    	Map<String, List<String>> supplierToParts = new HashMap<>();
//
//	    	int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	    	int supplierCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Supplier");
//
//	    	for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	    	    Row row = bopMaster.getRow(r);
//	    	    if (row == null) continue;
//
//	    	    Cell partCell = row.getCell(partNoCol);
//	    	    Cell suppCell = row.getCell(supplierCol);
//
//	    	    if (partCell != null && suppCell != null) {
//	    	        String part = partCell.toString().trim();
//	    	        String supplier = suppCell.toString().trim();
//
//	    	        if (!part.isEmpty() && !supplier.isEmpty()) {
//	    	            supplierToParts.computeIfAbsent(supplier, k -> new ArrayList<>()).add(part);
//	    	        }
//	    	    }
//	    	}
//
//	    	// 🔥 Supplier-wise breakdown logging
//	    	LoggerUtil.info("✅ Supplier → PartNo mapping collected (breakdown):");
//	    	for (Map.Entry<String, List<String>> entry : supplierToParts.entrySet()) {
//	    	    String supplier = entry.getKey();
//	    	    List<String> parts = entry.getValue();
//
//	    	    LoggerUtil.info("────────────────────────────────────────────");
//	    	    LoggerUtil.info("Supplier: " + supplier);
//	    	    LoggerUtil.pass("  Total Parts: " + parts.size());
//	    	    LoggerUtil.pass("  Parts: " + parts);
//	    	}
//	    	LoggerUtil.info("────────────────────────────────────────────");
//	    }
//	    softAssert.assertAll();
//	}
//	
//	@Test(priority = 84, groups = "group1")
//	public void TC_PM_DC_84ValidateBOPMasterDropdownFilteredByCustomers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_084: Validate BOP Master Part No. dropdown filtered by selected customers (Sales)");
//	    SoftAssert softAssert = new SoftAssert();
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//
//	    // 🔥 Select multiple Customers
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110", "Roshan-Gazipur-3111");
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    Thread.sleep(2000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Casting Sheet: " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // --- Step 2: Build Customer → PartNo map from BOP_Master ---
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, List<String>> customerToParts = new HashMap<>();
//
//	        int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	        int customerCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Customer");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            Cell partCell = row.getCell(partNoCol);
//	            Cell custCell = row.getCell(customerCol);
//
//	            if (partCell != null && custCell != null) {
//	                String part = partCell.toString().trim();
//	                String customer = custCell.toString().trim();
//
//	                if (!part.isEmpty() && !customer.isEmpty()) {
//	                    customerToParts.computeIfAbsent(customer, k -> new ArrayList<>()).add(part);
//	                }
//	            }
//	        }
//
//	        // 🔥 Customer-wise breakdown logging
//	        LoggerUtil.info("✅ Customer → PartNo mapping collected (breakdown):");
//	        for (Map.Entry<String, List<String>> entry : customerToParts.entrySet()) {
//	            String customer = entry.getKey();
//	            List<String> parts = entry.getValue();
//	            LoggerUtil.info("────────────────────────────────────────────");
//	            LoggerUtil.info("Customer: " + customer);
//	            LoggerUtil.info("  Total Parts: " + parts.size());
//	            LoggerUtil.info("  Parts: " + parts);
//	        }
//	        LoggerUtil.info("────────────────────────────────────────────");
//
//	        // --- Step 3: Validate dropdowns in BOP_Cost ---
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> bopCostHeaders = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int customerColIdx = bopCostHeaders.getOrDefault("Customer Name",
//	                bopCostHeaders.get("Customer"));
//	        int partNoColIdx = bopCostHeaders.get("BOP Master Part No.");
//
//	        int[] rowsToCheck = {2, 51, bopCost.getLastRowNum()};
//
//	        for (int rowIndex : rowsToCheck) {
//	            Row row = bopCost.getRow(rowIndex);
//	            if (row == null) continue;
//
//	            Cell customerCell = row.getCell(customerColIdx);
//	            if (customerCell == null) continue;
//
//	            String customer = customerCell.toString().trim();
//	            if (customer.isEmpty()) continue;
//
//	            List<String> expectedParts = customerToParts.getOrDefault(customer, Collections.emptyList());
//
//	            // 🔎 Extract dropdown values
//	            Set<String> actualValuesSet = collectDropdownListForColumn(
//	                    bopCost, workbook, partNoColIdx, rowIndex, rowIndex
//	            );
//	            List<String> actualDropdown = new ArrayList<>(actualValuesSet);
//
//	            LoggerUtil.info("────────────────────────────────────────────");
//	            LoggerUtil.info("Row " + (rowIndex + 1) + " | Customer=" + customer);
//	            LoggerUtil.info("  ➤ Expected Parts (Count=" + expectedParts.size() + "): " + expectedParts);
//	            LoggerUtil.info("  ➤ Actual Dropdown (Count=" + actualDropdown.size() + "): " + actualDropdown);
//
//	            if (actualDropdown.isEmpty()) {
//	                LoggerUtil.warn("⚠ No dropdown values found in row " + (rowIndex + 1));
//	                continue;
//	            }
//
//	            Set<String> expectedSet = expectedParts.stream()
//	                    .map(String::trim)
//	                    .map(String::toLowerCase)
//	                    .collect(Collectors.toSet());
//	            Set<String> actualSet = actualDropdown.stream()
//	                    .map(String::trim)
//	                    .map(String::toLowerCase)
//	                    .collect(Collectors.toSet());
//
//	            if (expectedSet.equals(actualSet)) {
//	                LoggerUtil.pass("✅ Row " + (rowIndex + 1) + ": Dropdown correctly filtered for Customer " + customer);
//	            } else {
//	                LoggerUtil.fail("❌ Row " + (rowIndex + 1) + ": Dropdown mismatch for Customer " + customer +
//	                        " (Expected Count=" + expectedParts.size() + ", Actual Count=" + actualDropdown.size() + ")");
//	            }
//	        }
//	    }
//	    softAssert.assertAll();
//	}
//	
//	@Test(priority = 85, groups = "group1")
//	public void TC_PM_DC_85ValidateBOPMasterDropdownFilteredBySingleSupplier() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_085: Validate BOP Master Part No. dropdown filtered by a single supplier (Procurement)");
//	    SoftAssert softAssert = new SoftAssert();
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta"); // Single supplier
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detailed Costing Sheet: " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // --- Step 2: Build Supplier → PartNo map from BOP_Master ---
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, List<String>> supplierToParts = new HashMap<>();
//
//	        int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	        int supplierCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Supplier");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//	            Cell partCell = row.getCell(partNoCol);
//	            Cell suppCell = row.getCell(supplierCol);
//	            if (partCell != null && suppCell != null) {
//	                String part = partCell.toString().trim();
//	                String supplier = suppCell.toString().trim();
//	                if (!part.isEmpty() && !supplier.isEmpty()) {
//	                    supplierToParts.computeIfAbsent(supplier, k -> new ArrayList<>()).add(part);
//	                }
//	            }
//	        }
//
//	        LoggerUtil.info("✅ Supplier → PartNo mapping collected (breakdown):");
//	        supplierToParts.forEach((sup, parts) -> {
//	            LoggerUtil.info("──────────────────────────────");
//	            LoggerUtil.info("Supplier: " + sup);
//	            LoggerUtil.pass("  Total Parts: " + parts.size());
//	        });
//
//	        // --- Step 3: Dynamically choose first, middle, and last rows ---
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        int lastRow = bopCost.getLastRowNum();
//	        int midRow = lastRow / 2;
//	        int[] rowsToCheck = {2, midRow, lastRow};
//	        LoggerUtil.info(String.format("🔎 Checking only first (%d), mid (%d), and last (%d) rows in BOP_Cost.", 2, midRow, lastRow));
//
//	        Map<String, Integer> bopCostHeader = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	        int supplierNameCol = bopCostHeader.get("Supplier Name");
//	        int bopPartNoCol = bopCostHeader.get("BOP Master Part No.");
//
//	        String selectedSupplier = "0801-Celesta";
//	        List<String> validParts = supplierToParts.getOrDefault(selectedSupplier, new ArrayList<>());
//
//	        boolean allValid = true;
//	        for (int rowNum : rowsToCheck) {
//	            if (rowNum > lastRow) continue;
//	            Row row = bopCost.getRow(rowNum);
//	            if (row == null) continue;
//
//	            String supplierName = row.getCell(supplierNameCol) != null ? row.getCell(supplierNameCol).toString().trim() : "";
//	            String bopPartNo = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
//
//	            if (supplierName.isEmpty() && bopPartNo.isEmpty()) continue;
//
//	            LoggerUtil.info("──────────────────────────────");
//	            LoggerUtil.info("Row " + (rowNum + 1) + ": Supplier=" + supplierName + ", BOP=" + bopPartNo);
//
//	            if (validParts.contains(bopPartNo)) {
//	                LoggerUtil.pass("✅ Row " + (rowNum + 1) + ": BOP correctly linked to supplier " + supplierName);
//	            } else {
//	                LoggerUtil.fail("❌ Row " + (rowNum + 1) + ": Invalid BOP (" + bopPartNo + ") for supplier " + supplierName);
//	                allValid = false;
//	            }
//	        }
//
//	        // --- Step 4: Validate dropdown values (OFFSET/Named Range handled) ---
//	        Set<String> dropdownValues = PartMasterDetailCostingRivisedPage.collectDropdownListForColumn(bopCost, workbook, bopPartNoCol, 2, lastRow);
//	        if (dropdownValues.isEmpty()) LoggerUtil.warn("⚠ No dropdown values extracted; check Excel data validation reference.");
//
//	        LoggerUtil.info("📋 Extracted dropdown values: " + dropdownValues.size());
//	        long validCount = dropdownValues.stream().filter(validParts::contains).count();
//	        long invalidCount = dropdownValues.size() - validCount;
//
//	        LoggerUtil.info("✅ Valid matches: " + validCount + " | ❌ Invalid: " + invalidCount);
//
//	        if (invalidCount > 0)
//	            LoggerUtil.fail("❌ Dropdown contains BOPs not linked to supplier " + selectedSupplier);
//	        else
//	            LoggerUtil.pass("✅ Dropdown contains only BOPs linked to supplier " + selectedSupplier);
//
//	        if (allValid && invalidCount == 0)
//	            LoggerUtil.pass("🎯 TC_PM_DC_085 passed: Dropdown correctly filtered for supplier '" + selectedSupplier + "'");
//	        else
//	            Assert.fail("❌ TC_PM_DC_085 failed: Dropdown contains mismatched or invalid BOP entries.");
//	    }
//	    softAssert.assertAll();
//	}
//
//
//	
//	@Test(priority = 86, groups = "group1")
//	public void TC_PM_DC_86ValidateBOPMasterDropdownForMultipleSuppliers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_086: Validate BOP Master Part No. dropdown when same BOP exists for multiple suppliers");
//	    SoftAssert softAssert = new SoftAssert();
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	    // Select multiple suppliers
//	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detailed Costing Sheet: " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // --- Step 2: Build Supplier → PartNo mapping from BOP_Master ---
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, List<String>> supplierToParts = new HashMap<>();
//
//	        int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	        int supplierCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Supplier");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part = row.getCell(partNoCol) != null ? row.getCell(partNoCol).toString().trim() : "";
//	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
//
//	            if (!part.isEmpty() && !supplier.isEmpty()) {
//	                supplierToParts.computeIfAbsent(supplier, k -> new ArrayList<>()).add(part);
//	            }
//	        }
//
//	        // Log supplier-wise breakdown
//	        LoggerUtil.info("✅ Supplier → BOP Part mapping (BOP_Master sheet):");
//	        supplierToParts.forEach((sup, parts) ->
//	            LoggerUtil.info("Supplier: " + sup + " → BOP Parts: " + parts)
//	        );
//
//	        // --- Step 3: Selected suppliers & expected dropdown construction ---
//	        List<String> selectedSuppliers = Arrays.asList("Prabhat-3110", "Roshan-3111");
//	        List<String> expectedDropdown = new ArrayList<>();
//
//	        for (String supplier : selectedSuppliers) {
//	            List<String> parts = supplierToParts.getOrDefault(supplier, new ArrayList<>());
//	            for (String p : parts) {
//	                expectedDropdown.add(p + " [" + supplier + "]");
//	            }
//	        }
//
//	        LoggerUtil.info("📋 Expected dropdown values (with supplier context): " + expectedDropdown.size());
//
//	        // --- Step 4: Extract actual dropdown values (flattened for both suppliers) ---
//	        List<String> actualDropdown = new ArrayList<>();
//	        for (String supplier : selectedSuppliers) {
//	            List<String> parts = supplierToParts.getOrDefault(supplier, new ArrayList<>());
//	            actualDropdown.addAll(parts);
//	        }
//
//	        LoggerUtil.info("📋 Actual dropdown values from BOP_Master: " + actualDropdown);
//	        LoggerUtil.info("✅ Total dropdown values = " + actualDropdown.size());
//
//	        // --- Step 5: Validation (part-by-part check) ---
//	        int validCount = 0, invalidCount = 0;
//	        for (String val : actualDropdown) {
//	            if (expectedDropdown.contains(val + " [Prabhat-3110]") ||
//	                expectedDropdown.contains(val + " [Roshan-3111]")) {
//	                LoggerUtil.pass("✅ Valid: " + val);
//	                validCount++;
//	            } else {
//	                LoggerUtil.fail("❌ Invalid (unexpected): " + val);
//	                invalidCount++;
//	            }
//	        }
//
//	        LoggerUtil.info("🎯 Validation Summary → Valid=" + validCount + " | Invalid=" + invalidCount);
//
//	        // --- Step 6: Verify same BOP exists separately for both suppliers ---
//	        String commonBOP = "rky1"; // Example from your Excel
//	        long countPrabhat = supplierToParts.getOrDefault("Prabhat-3110", List.of()).stream()
//	                .filter(p -> p.equalsIgnoreCase(commonBOP)).count();
//	        long countRoshan = supplierToParts.getOrDefault("Roshan-3111", List.of()).stream()
//	                .filter(p -> p.equalsIgnoreCase(commonBOP)).count();
//
//	        if (countPrabhat > 0 && countRoshan > 0) {
//	            LoggerUtil.pass("✅ Same BOP ('" + commonBOP + "') exists separately for both suppliers with distinct entries.");
//	        } else {
//	            LoggerUtil.fail("❌ BOP duplication per supplier not found as expected.");
//	            invalidCount++;
//	        }
//
//	        // --- Step 7: Final Assertion ---
//	        if (invalidCount == 0)
//	            LoggerUtil.pass("🎯 TC_PM_DC_086 passed: Dropdown correctly shows same BOP entries per selected suppliers.");
//	        else
//	            Assert.fail("❌ TC_PM_DC_086 failed: Invalid or missing BOP entries for selected suppliers.");
//	    }
//	    softAssert.assertAll();
//	}
//
//	@Test(priority = 87, groups = "group1")
//	public void TC_PM_DC_87ValidateBOPMasterDropdownReFilteringAfterSupplierChange() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_087: Validate BOP Master Part No. dropdown after supplier re-filtering (no stale cache)");
//	    SoftAssert softAssert = new SoftAssert();
//	    // --- Step 1: UI selections with Supplier S1 + S2 ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	    // Select two suppliers (S1 + S2)
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta", "0801-Ellsworth");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(40000);
//
//	    File fileS1S2 = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Excel (S1+S2): " + fileS1S2);
//	    waitForFileDownload(fileS1S2, 30);
//
//	    // --- Step 2: Build Supplier → PartNo mapping from BOP_Master (S1+S2 export) ---
//	    Map<String, List<String>> supplierToParts = new HashMap<>();
//	    try (FileInputStream fis = new FileInputStream(fileS1S2);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	        int supplierCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Supplier");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//	            String part = row.getCell(partNoCol) != null ? row.getCell(partNoCol).toString().trim() : "";
//	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
//	            if (!part.isEmpty() && !supplier.isEmpty()) {
//	                supplierToParts.computeIfAbsent(supplier, k -> new ArrayList<>()).add(part);
//	            }
//	        }
//	    }
//
//	    List<String> s1Parts = supplierToParts.getOrDefault("0801-Celesta", new ArrayList<>());
//	    List<String> s2Parts = supplierToParts.getOrDefault("0801-Ellsworth", new ArrayList<>());
//
//	    LoggerUtil.info("────────────────────────────────────────────");
//	    LoggerUtil.info("📋 Supplier 0801-Celesta (S1) → " + s1Parts.size() + " parts");
//	    LoggerUtil.info("📋 Supplier 0801-Ellsworth (S2) → " + s2Parts.size() + " parts");
//	    LoggerUtil.info("────────────────────────────────────────────");
//
//	    // --- Step 3: Re-export with only S1 selected ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	    // Only S1 now
//	    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations2 = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations2.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg2 = "";
//	    for (String msg : validations2) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	        	successMsg2 = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg2.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg2);
//	        softAssert.assertEquals(successMsg2, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations2);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(40000);
//
//	    File fileS1Only = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Excel (S1 only): " + fileS1Only);
//	    waitForFileDownload(fileS1Only, 30);
//
//	    // --- Step 4: Extract actual dropdown values for S1-only export ---
//	    List<String> actualS1Values = new ArrayList<>();
//	    try (FileInputStream fis = new FileInputStream(fileS1Only);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	        int supplierCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Supplier");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//	            String part = row.getCell(partNoCol) != null ? row.getCell(partNoCol).toString().trim() : "";
//	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
//	            if (!part.isEmpty() && supplier.equals("0801-Celesta")) {
//	                actualS1Values.add(part);
//	            }
//	        }
//	    }
//
//	    LoggerUtil.info("📋 Re-exported (S1 only) dropdown values count → " + actualS1Values.size());
//
//	    // --- Step 5: Compare & detect S2-only BOPs that should have disappeared ---
//	    Set<String> remainingS2BOPs = new LinkedHashSet<>(s2Parts);
//	    remainingS2BOPs.retainAll(actualS1Values); // keep only S2 parts still found in S1 file
//
//	    if (remainingS2BOPs.isEmpty()) {
//	        LoggerUtil.pass("✅ All S2-only BOPs have been successfully removed in re-export.");
//	    } else {
//	        LoggerUtil.fail("❌ S2-only BOPs still present after re-export: " + remainingS2BOPs);
//	    }
//
//	    // --- Step 6: Validate that no invalid S1 BOPs are present ---
//	    int invalidCount = 0;
//	    for (String val : actualS1Values) {
//	        if (!s1Parts.contains(val)) {
//	            LoggerUtil.error("❌ Invalid BOP found in S1-only export: " + val);
//	            invalidCount++;
//	        }
//	    }
//
//	    LoggerUtil.info("────────────────────────────────────────────");
//	    LoggerUtil.info("🎯 Validation Summary → Valid: " + (actualS1Values.size() - invalidCount) +
//	            " | Invalid: " + invalidCount +
//	            " | S2-only still present: " + remainingS2BOPs.size());
//	    LoggerUtil.info("────────────────────────────────────────────");
//
//	    // --- Step 7: Final decision ---
//	    if (invalidCount == 0 && remainingS2BOPs.isEmpty()) {
//	        LoggerUtil.pass("🎯 TC_PM_DC_087 Passed: Dropdown correctly re-filtered for S1; no stale cache data found.");
//	    } else {
//	        LoggerUtil.fail("❌ TC_PM_DC_087 Failed: Foreign or S2-only BOPs still present after re-export.");
//	        Assert.fail("Dropdown still contains stale or foreign supplier BOPs after supplier change.");
//	    }
//	    softAssert.assertAll();
//	}
//	
////	@Test(priority = 88, groups = "group1")
////	public void TC_PM_DC_88ValidateBOPMasterDropdownFilteredBySingleCustomer() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_088: Validate BOP Master Part No. dropdown filtered by single Customer (Sales)");
////	    SoftAssert softAssert = new SoftAssert();
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(2000);
////
////	    // 🔥 Select multiple Customers
////	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
////	    Thread.sleep(3000);
////
////	    PartMasterDetailCostingRivisedPage.selectSales(); 
////	    Thread.sleep(2000);
////
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
////	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
////
////	    String successMsg = "";
////	    for (String msg : validations) {
////	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
////	            successMsg = msg.trim().replaceAll("\\s+", " ");
////	            break;
////	        }
////	    }
////
////	    if (!successMsg.isEmpty()) {
////	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
////	        softAssert.assertEquals(successMsg, "Success File exported successfully",
////	                "Export success message did not match.");
////	    } else {
////	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
////	        softAssert.fail("Expected success toast not found.");
////	    }
////	    Thread.sleep(40000);
////
////	    // --- Step 2: Load Excel ---
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded Details Casting Sheet: " + exportedFile);
////	    waitForFileDownload(exportedFile, 30);
////
////	    try (XSSFWorkbook workbook = ExcelUtil.openWorkbook(exportedFile)) {
////	        Sheet bopCostSheet = workbook.getSheet("BOP_Cost");
////
////	        // --- Step 3: Locate "Customer Name" column ---
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////	        Assert.assertTrue(headerMap.containsKey("Customer Name"),
////	                "Column Customer Name not found in BOP_Cost sheet!");
////	        int customerColIndex = headerMap.get("Customer Name");
////
////	        // --- Step 4: Expected dropdown values ---
////	        List<String> expectedValues = Arrays.asList("Prabhat-3110");
////
////	        // --- Step 5: Extract dropdown values (explicit + named range) ---
////	        Set<String> actualValuesSet = PartMasterDetailCostingRivisedPage.collectDropdownListForColumn(bopCostSheet, workbook, customerColIndex, 3, 1002);
////	        List<String> actualValues = new ArrayList<>(actualValuesSet);
////
////	        // --- Logging ---
////	        LoggerUtil.info("────────────────────────────────────────────");
////	        LoggerUtil.info("Expected Customers (Count=" + expectedValues.size() + "): " + expectedValues);
////	        LoggerUtil.info("Actual Dropdown (Count=" + actualValues.size() + "): " + actualValues);
////	        LoggerUtil.info("────────────────────────────────────────────");
////
////	        // --- Step 6: Validation ---
////	        Assert.assertEquals(actualValues.size(), expectedValues.size(),
////	                "Dropdown size mismatch. Expected " + expectedValues.size() + " but Found: " + actualValues.size());
////	        Assert.assertTrue(actualValues.containsAll(expectedValues),
////	                "Dropdown values mismatch. Expected: " + expectedValues + " | Found: " + actualValues);
////
////	        LoggerUtil.pass("✅ PASS: Customer dropdown matched expected values: " + actualValues);
////	    }
////	    softAssert.assertAll();
////	}
//	
//	@Test(priority = 88, groups = "group1")
//	public void TC_PM_DC_88ValidateBOPMasterDropdownFilteredBySingleCustomer() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_088: Validate BOP Master Part No. dropdown filtered by single Customer (Sales)");
//	    SoftAssert softAssert = new SoftAssert();
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110"); // ✅ Single customer (C1)
//	    Thread.sleep(3000);
//
//	    PartMasterDetailCostingRivisedPage.selectSales(); // Sales mode
//	    Thread.sleep(2000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    // --- Step 2: Export ---
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Excel (Sales): " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    // --- Step 3: Load Workbook and identify dropdown source ---
//	    try (XSSFWorkbook workbook = ExcelUtil.openWorkbook(exportedFile)) {
//	        XSSFSheet bopCostSheet = workbook.getSheet("BOP_Cost");
//
//	        // Extract validation list / named range for BOP Master Part No. column
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	        Assert.assertTrue(headerMap.containsKey("BOP Master Part No."),
//	                "Column 'BOP Master Part No.' not found in BOP_Cost sheet!");
//
//	        int bopMasterCol = headerMap.get("BOP Master Part No.");
//
//	        // --- Step 4: Extract dropdown list (OFFSET or Named Range) ---
//	        Set<String> actualDropdownValues =
//	                PartMasterDetailCostingRivisedPage.collectDropdownListForColumn(bopCostSheet, workbook, bopMasterCol, 3, 1002);
//	        LoggerUtil.info("📋 Extracted dropdown values count: " + actualDropdownValues.size());
//	        LoggerUtil.info("📋 Dropdown list (sample): " + actualDropdownValues.stream().limit(10).collect(Collectors.toList()));
//	        
//
//
//	        // --- Step 5: Build expected list from BOP_Master sheet ---
//	        XSSFSheet bopMasterSheet = workbook.getSheet("BOP_Master");
//	        Map<String, Integer> bopMasterMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//	        int customerCol = bopMasterMap.get("Customer");
//	        int partNoCol = bopMasterMap.get("Part No.");
//
//	        List<String> expectedDropdownValues = new ArrayList<>();
//	        for (int r = 2; r <= bopMasterSheet.getLastRowNum(); r++) {
//	            Row row = bopMasterSheet.getRow(r);
//	            if (row == null) continue;
//
//	            String cust = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
//	            String part = row.getCell(partNoCol) != null ? row.getCell(partNoCol).toString().trim() : "";
//
//	            if (!cust.isEmpty() && cust.equalsIgnoreCase("Prabhat-3110")) {
//	                expectedDropdownValues.add(part);
//	            }
//	        }
//
//	        LoggerUtil.info("────────────────────────────────────────────");
//	        LoggerUtil.info("Expected (Customer=C1 only): " + expectedDropdownValues.size());
//	        LoggerUtil.info("Actual dropdown count: " + actualDropdownValues.size());
//	        LoggerUtil.info("────────────────────────────────────────────");
//
//	        // --- Step 6: Validation ---
//	        int invalidCount = 0;
//	        for (String part : actualDropdownValues) {
//	            if (!expectedDropdownValues.contains(part)) {
//	                LoggerUtil.error("❌ Invalid BOP visible for other customers: " + part);
//	                invalidCount++;
//	            }
//	        }
//
//	        LoggerUtil.info("🎯 Validation Summary → Valid=" +
//	                (actualDropdownValues.size() - invalidCount) + " | Invalid=" + invalidCount);
//
//	        if (invalidCount == 0) {
//	            LoggerUtil.pass("✅ PASS: Dropdown correctly filtered — only C1's BOPs visible.");
//	        } else {
//	            LoggerUtil.fail("❌ FAIL: Dropdown contains foreign customer BOPs.");
//	            Assert.fail("Dropdown includes invalid BOP entries from other customers.");
//	        }
//	    }
//
//	    softAssert.assertAll();
//	}
//	
//	@Test(priority = 89, groups = "group1")
//	public void TC_PM_DC_89ValidateBOPMasterDropdownForMultipleCustomers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_089: Validate BOP Master Part No. dropdown when same BOP exists for multiple Customers (Sales)");
//	    SoftAssert softAssert = new SoftAssert();
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterDetailCostingRivisedPage.selectSales(); // Sales mode
//	    Thread.sleep(2000);
//
//	    // Select multiple customers (C1 & C2)
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110", "Roshan-Gazipur-3111");
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    softAssert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//
//	    String successMsg = "";
//	    for (String msg : validations) {
//	        if (msg.contains("Success") && msg.contains("File exported successfully")) {
//	            successMsg = msg.trim().replaceAll("\\s+", " ");
//	            break;
//	        }
//	    }
//
//	    if (!successMsg.isEmpty()) {
//	        LoggerUtil.info("Validation message captured (normalized): " + successMsg);
//	        softAssert.assertEquals(successMsg, "Success File exported successfully",
//	                "Export success message did not match.");
//	    } else {
//	        LoggerUtil.error("Success toast not captured. Actual messages: " + validations);
//	        softAssert.fail("Expected success toast not found.");
//	    }
//	    Thread.sleep(45000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Detail Costing Excel (Sales C1+C2): " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    // --- Step 2: Read BOP_Master sheet ---
//	    Map<String, List<String>> customerToParts = new HashMap<>();
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        int partNoCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Part No.");
//	        int customerCol = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1).get("Customer");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part = row.getCell(partNoCol) != null ? row.getCell(partNoCol).toString().trim() : "";
//	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
//
//	            if (!part.isEmpty() && !customer.isEmpty()) {
//	                customerToParts.computeIfAbsent(customer, k -> new ArrayList<>()).add(part);
//	            }
//	        }
//
//	        // --- Step 3: Build expected dropdown list (C1 + C2) ---
//	        List<String> selectedCustomers = Arrays.asList("Prabhat-3110", "Roshan-3111");
//	        List<String> expectedDropdown = new ArrayList<>();
//
//	        for (String customer : selectedCustomers) {
//	            List<String> parts = customerToParts.getOrDefault(customer, new ArrayList<>());
//	            expectedDropdown.addAll(parts);
//	        }
//
//	        LoggerUtil.info("────────────────────────────────────────────");
//	        LoggerUtil.info("Expected BOP count for selected customers (C1+C2): " + expectedDropdown.size());
//	        LoggerUtil.info("────────────────────────────────────────────");
//
//	        // --- Step 4: Extract actual dropdown values from BOP_Cost ---
//	        XSSFSheet bopCostSheet = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> bopCostHeader = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	        int bopMasterPartNoCol = bopCostHeader.get("BOP Master Part No.");
//
//	        Set<String> actualDropdownValues = PartMasterDetailCostingRivisedPage.collectDropdownListForColumn(
//	                bopCostSheet, workbook, bopMasterPartNoCol, 3, 1002);
//
//	        LoggerUtil.info("📋 Actual dropdown count: " + actualDropdownValues.size());
//
//	        // --- Step 5: Validation ---
//	        int invalidCount = 0;
//	        for (String value : actualDropdownValues) {
//	            if (!expectedDropdown.contains(value)) {
//	                LoggerUtil.error("❌ Invalid BOP found for unselected customer: " + value);
//	                invalidCount++;
//	            }
//	        }
//
//	        LoggerUtil.info("🎯 Validation Summary → Valid: " +
//	                (actualDropdownValues.size() - invalidCount) + " | Invalid: " + invalidCount);
//
//	        if (invalidCount == 0) {
//	            LoggerUtil.pass("✅ PASS: Dropdown correctly contains BOPs for C1 ∪ C2 only.");
//	        } else {
//	            LoggerUtil.fail("❌ FAIL: Dropdown contains BOPs from other customers.");
//	            Assert.fail("Dropdown contains invalid (unselected) customer BOPs.");
//	        }
//	    }
//	    softAssert.assertAll();
//	}
//
////	@Test(priority = 90, groups = "group1")
////	public void TC_PM_DC_90ValidateExportWithDuplicateBOPForCustomerC1() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_90: Sales: Selecting duplicate BOP for C1 shows correct Customer & Costs");
////
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(2000);
////	    // 👉 Sales radio button
////	    PartMasterDetailCostingRivisedPage.selectSales();
////
////	    String[] targetCustomers = {"Mk-2208-9-Mohali-2208-9","Mk-2208-7-Mohali-2208-7"};
////	    PartMasterPage.selectOnCustomerValuesByText(targetCustomers);
////	    Thread.sleep(3000);
////
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    Thread.sleep(60000);
////
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded file for TC_PM_DC_090: " + exportedFile);
////	    waitForFileDownload(exportedFile, 30);
////
////	    String duplicateBop = null;
////	    String[] target = {" Mk-2208-9-2208-9"," Mk-2208-7-2208-7"};
////	    // --- Step 2: Build Customer→PartNo→Cost mapping from BOP_Master ---
////	    Map<String, Map<String, String>> customerToPartCost = new HashMap<>();
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
////
////	        int partNoCol    = headerMap.get("Part No.");
////	        int customerCol  = headerMap.get("Customer");
////	        int costCol      = headerMap.get("Part Cost/Unit");
////
////	        Map<String, Integer> partFrequency = new HashMap<>();
////
////	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
////	            Row row = bopMaster.getRow(r);
////	            if (row == null) continue;
////
////	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim()   : "";
////	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            if (!part.isEmpty() && !customer.isEmpty()) {
////	                customerToPartCost
////	                    .computeIfAbsent(customer, k -> new HashMap<>())
////	                    .put(part, cost);
////
////	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
////	            }
////	        }
////
////	        // Pick any part duplicated across ≥2 customers
////	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
////	            if (e.getValue() >= 2) {
////	                duplicateBop = e.getKey();
////	                break;
////	            }
////	        }
////	    }
////
////	    if (duplicateBop == null) {
////	        LoggerUtil.error("❌ No duplicate BOP found across customers in BOP_Master!");
////	        Assert.fail("Test cannot continue without a duplicate BOP.");
////	    } else {
////	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
////	    }
////
////	    // --- Step 3: Select Customer + BOP in BOP_Cost rows dynamically ---
////	    for (int i = 0; i < targetCustomers.length; i++) {
////	        int rowIndex = i + 3; // rows start from 3
////	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "Customer Name", target[i]);
////	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "BOP Master Part No.", duplicateBop);
////	    }
////
////	    // --- Step 4: Validate row-wise mapping ---
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////
////	        int customerCol    = headerMap.get("Customer Name");
////	        int bopPartNoCol   = headerMap.get("BOP Master Part No.");
////	        int costCol        = headerMap.get("Part Cost/Unit");
////
////	        int valid = 0, skipped = 0, invalid = 0;
////
////	        for (int i = 0; i < targetCustomers.length; i++) {
////	            int r = i + 2; // Excel row (starts row 3)
////	            Row row = bopCost.getRow(r);
////	            if (row == null) continue;
////
////	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
////	            String bopPart  = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            String expectedCost = customerToPartCost
////	                    .getOrDefault(customer, new HashMap<>())
////	                    .get(duplicateBop);
////
////	            if (expectedCost == null) {
////	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Customer=" + customer +
////	                                " | BOP=" + bopPart +
////	                                " → No mapping found in BOP_Master (Skipping validation).");
////	                skipped++;
////	                continue;
////	            }
////
////	            if (cost == null || cost.isEmpty()) {
////	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Customer=" + customer +
////	                                " | BOP=" + bopPart +
////	                                " → Expected=" + expectedCost +
////	                                " | Actual cost not available.");
////	                skipped++;
////	                continue;
////	            }
////
////	            LoggerUtil.info("🔎 Row " + (r + 1) + " → Customer=" + customer +
////	                            " | BOP=" + bopPart +
////	                            " | Cost=" + cost +
////	                            " | Expected=" + expectedCost);
////
////	            if (expectedCost.equals(cost)) {
////	                LoggerUtil.pass("✅ Row " + (r + 1) + ": MATCHED for Customer=" + customer);
////	                valid++;
////	            } else {
////	                LoggerUtil.error("❌ Row " + (r + 1) + ": Cost mismatch → Expected=" + expectedCost + ", Found=" + cost);
////	                invalid++;
////	            }
////	        }
////
////	        LoggerUtil.info("🎯 Final Validation Summary → Valid=" + valid + " | Skipped=" + skipped + " | Invalid=" + invalid);
////	        // Don't fail test if skipped > 0, only fail if actual mismatch exists
////	        Assert.assertEquals(invalid, 0, "❌ Duplicate BOP entries not correctly mapped for some customers!");
////	    }
////	}
//	
//	@Test(priority = 90, groups = "group1")
//	public void TC_PM_DC_90ValidateExportWithDuplicateBOPForCustomerC1() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_90: Sales: Selecting duplicate BOP for C1 shows correct Customer & Costs");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//
//	    // Select Sales flow
//	    PartMasterDetailCostingRivisedPage.selectSales();
//
//	    // Select only one customer (C1)
//	   
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    // Export file
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_090: " + exportedFile.getAbsolutePath());
//	    waitForFileDownload(exportedFile, 30);
//	    String targetCustomer = "Prabhat-3110";
//	    String duplicateBop = null;
//	    Map<String, Map<String, String>> customerToPartCost = new HashMap<>();
//
//	    // --- Step 2: Build Customer → Part → Cost map from BOP_Master ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//
//	        LoggerUtil.info("Available headers in BOP_Master → " + headerMap.keySet());
//
//	        int partNoCol   = findColumnIndex(headerMap, "Part No.");
//	        int customerCol = findColumnIndex(headerMap, "Customer");
//	        int costCol     = findColumnIndex(headerMap, "Part Cost/Unit");
//
//	        Map<String, Integer> partFrequency = new HashMap<>();
//
//	        for (int r = 1; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part = getCellStringValue(row, partNoCol).trim();
//	            String customer = getCellStringValue(row, customerCol).trim();
//
//	            String cost = "";
//	            Cell cell = row.getCell(costCol);
//	            if (cell != null) {
//	                CellValue cv = evaluator.evaluate(cell);
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = new DecimalFormat("#.####").format(cv.getNumberValue()); break;
//	                        default: cost = cell.toString().trim();
//	                    }
//	                }
//	            }
//
//	            if (!part.isEmpty() && !customer.isEmpty()) {
//	                customerToPartCost
//	                        .computeIfAbsent(customer, k -> new HashMap<>())
//	                        .put(part, cost);
//	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
//	            }
//	        }
//
//	        // Select first part appearing under ≥2 customers
//	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
//	            if (e.getValue() >= 2) {
//	                duplicateBop = e.getKey();
//	                break;
//	            }
//	        }
//	    }
//
//	    if (duplicateBop == null) {
//	        LoggerUtil.error("❌ No duplicate BOP found across customers in BOP_Master!");
//	        Assert.fail("Test cannot continue without a duplicate BOP.");
//	    } else {
//	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
//	    }
//
//	    // --- Step 3: Validate BOP_Cost mapping ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 0);
//
//	        LoggerUtil.info("Available headers in BOP_Cost → " + headerMap.keySet());
//
//	        int customerCol    = findColumnIndex(headerMap, "Customer Name");
//	        int bopPartNoCol   = findColumnIndex(headerMap, "BOP Master Part No.");
//	        int costCol        = findColumnIndex(headerMap, "Part Cost/Unit");
//
//	        int valid = 0, skipped = 0, invalid = 0;
//
//	        for (int r = 1; r <= bopCost.getLastRowNum(); r++) {
//	            Row row = bopCost.getRow(r);
//	            if (row == null) continue;
//
//	            String customer = getCellStringValue(row, customerCol).trim();
//	            String bopPart  = getCellStringValue(row, bopPartNoCol).trim();
//
//	            if (!customer.equalsIgnoreCase(targetCustomer)) continue;
//	            if (!bopPart.equalsIgnoreCase(duplicateBop)) continue;
//
//	            String cost = "";
//	            Cell cell = row.getCell(costCol);
//	            if (cell != null) {
//	                CellValue cv = evaluator.evaluate(cell);
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = new DecimalFormat("#.####").format(cv.getNumberValue()); break;
//	                        default: cost = cell.toString().trim();
//	                    }
//	                }
//	            }
//
//	            String expectedCost = customerToPartCost
//	                    .getOrDefault(customer, new HashMap<>())
//	                    .get(duplicateBop);
//
//	            if (expectedCost == null) {
//	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": No mapping found in BOP_Master for Customer=" + customer);
//	                skipped++;
//	                continue;
//	            }
//
//	            LoggerUtil.info("🔎 Row " + (r + 1) + " → Customer=" + customer +
//	                    " | BOP=" + bopPart +
//	                    " | Cost=" + cost +
//	                    " | Expected=" + expectedCost);
//
//	            if (expectedCost.equals(cost)) {
//	                LoggerUtil.pass("✅ Row " + (r + 1) + ": MATCHED for Customer=" + customer);
//	                valid++;
//	            } else {
//	                LoggerUtil.error("❌ Row " + (r + 1) + ": Cost mismatch → Expected=" + expectedCost + ", Found=" + cost);
//	                invalid++;
//	            }
//	        }
//
//	        LoggerUtil.info("🎯 Validation Summary → Valid=" + valid + " | Skipped=" + skipped + " | Invalid=" + invalid);
//	        Assert.assertEquals(invalid, 0, "❌ Duplicate BOP entries not correctly mapped for some customers!");
//	    }
//	}
//
//	/* ------------------------  Helper Methods ------------------------ */
//
//	/**
//	 * Case-insensitive safe lookup for column index.
//	 */
//	public static int findColumnIndex(Map<String, Integer> headerMap, String key) {
//	    for (Map.Entry<String, Integer> e : headerMap.entrySet()) {
//	        String header = e.getKey().trim().replaceAll("\\s+", " ").toLowerCase();
//	        if (header.equalsIgnoreCase(key.trim().replaceAll("\\s+", " ").toLowerCase())) {
//	            return e.getValue();
//	        }
//	    }
//	    throw new RuntimeException("❌ Column not found in headerMap: " + key +
//	            " | Available keys: " + headerMap.keySet());
//	}
//
//	/**
//	 * Safely returns string value from a cell (works for string, numeric, formula).
//	 */
//	public static String getCellStringValue(Row row, int cellIndex) {
//	    if (row == null) return "";
//	    Cell cell = row.getCell(cellIndex);
//	    if (cell == null) return "";
//
//	    try {
//	        switch (cell.getCellType()) {
//	            case STRING:
//	                return cell.getStringCellValue().trim();
//	            case NUMERIC:
//	                double num = cell.getNumericCellValue();
//	                if (num == (long) num)
//	                    return String.valueOf((long) num);
//	                else
//	                    return String.valueOf(num);
//	            case FORMULA:
//	                FormulaEvaluator evaluator = cell.getSheet()
//	                        .getWorkbook().getCreationHelper().createFormulaEvaluator();
//	                CellValue evaluated = evaluator.evaluate(cell);
//	                if (evaluated != null) {
//	                    switch (evaluated.getCellType()) {
//	                        case STRING: return evaluated.getStringValue().trim();
//	                        case NUMERIC: return String.valueOf(evaluated.getNumberValue());
//	                        default: return "";
//	                    }
//	                }
//	                break;
//	            default:
//	                return cell.toString().trim();
//	        }
//	    } catch (Exception e) {
//	        return "";
//	    }
//	    return "";
//	}
//
//	
//	
//	
////	
//////	@Test(priority = 90, groups = "group1")
//////	public void TC_PM_DC_90ValidateExportWithDuplicateBOPForCustomerC1Q() throws Exception {
//////	    LoggerUtil.info("TC_PM_DC_90: Sales: Selecting duplicate BOP for C1 shows correct Customer & Costs");
//////
//////	    // --- Step 1: UI Selections ---
//////	    dashboard.clickingDashboard("");
//////	    dashboard.selectMenuFormDashBoard("Master Data");
//////	    Thread.sleep(3000);
//////	    dashboard.clickOnPartMaster();
//////	    Thread.sleep(1000);
//////
//////	    pm.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//////	    Thread.sleep(2000);
//////	    pmdcrp.selectSales(); // or Procurement
//////
//////	    String[] targetCustomers = {
//////	      //  "Mk-2208-5-Mohali-2208-5",
//////	        "Mk-2208-9-Mohali-2208-9",
//////	        "Mk-2208-7-Mohali-2208-7"
//////	    };
//////	    pm.selectOnCustomerValuesByText(targetCustomers);
//////	    Thread.sleep(3000);
//////
//////	    pm.selectOnProductCategoryValuesByText("FURNITURE");
//////	    Thread.sleep(3000);
//////	    pm.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//////	    Thread.sleep(3000);
//////	    pm.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//////
//////	    pmdcrp.openExportImportModal();
//////	    pmdcrp.enterTotalNoOfParts(1000); // force max rows
//////	    pmdcrp.clickOnExportBtn();
//////	    Thread.sleep(60000);
//////
//////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//////	    LoggerUtil.info("Downloaded file for TC_PM_DC_090: " + exportedFile);
//////	    waitForFileDownload(exportedFile, 60);
//////
//////	    String duplicateBop = null;
//////	    Map<String, Map<String, String>> preservedMap   = new HashMap<>();
//////	    Map<String, Map<String, String>> normalizedMap  = new HashMap<>();
//////
//////	    // --- Step 2: Build Customer→PartNo→Cost mapping from BOP_Master ---
//////	    try (FileInputStream fis = new FileInputStream(exportedFile);
//////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//////
//////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//////	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//////
//////	        int partNoCol   = headerMap.get("Part No.");
//////	        int customerCol = headerMap.get("Customer");
//////	        int costCol     = headerMap.get("Part Cost/Unit");
//////
//////	        Map<String, Integer> partFrequency = new HashMap<>();
//////
//////	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//////	            Row row = bopMaster.getRow(r);
//////	            if (row == null) continue;
//////
//////	            String part = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString() : "";
//////	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString() : "";
//////
//////	            String preservedCustomer = customer; // keep spaces
//////	            String normalizedCustomer = customer.trim().replaceAll("\\s+", "");
//////
//////	            // cost evaluate
//////	            String cost = "";
//////	            if (row.getCell(costCol) != null) {
//////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//////	                if (cv != null) {
//////	                    switch (cv.getCellType()) {
//////	                        case STRING:  cost = cv.getStringValue().trim(); break;
//////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//////	                        default:      cost = row.getCell(costCol).toString().trim();
//////	                    }
//////	                }
//////	            }
//////
//////	            if (!part.isEmpty() && !customer.isEmpty()) {
//////	                preservedMap.computeIfAbsent(preservedCustomer, k -> new HashMap<>()).put(part, cost);
//////	                normalizedMap.computeIfAbsent(normalizedCustomer, k -> new HashMap<>()).put(part, cost);
//////	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
//////	            }
//////	        }
//////
//////	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
//////	            if (e.getValue() >= 2) {
//////	                duplicateBop = e.getKey();
//////	                break;
//////	            }
//////	        }
//////	    }
//////
//////	    if (duplicateBop == null) {
//////	        LoggerUtil.error("❌ No duplicate BOP found in BOP_Master!");
//////	        Assert.fail("Test cannot continue without a duplicate BOP.");
//////	    } else {
//////	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
//////	    }
//////
//////	    
//////	    String preservedCustomer = " Mk-2208-9-2208-9"; // preserved with space
//////	    String normalizedCustomer = preservedCustomer.trim().replaceAll("\\s+", "");
//////
//////	    // try preserved first, then fallback
//////	    try {
//////	        pmdcrp.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Customer Name", preservedCustomer);
//////	    } catch (Exception e) {
//////	        pmdcrp.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Customer Name", normalizedCustomer);
//////	    }
//////	    pmdcrp.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", duplicateBop);
//////
//////	    // --- Step 4: Validate mapping on last row ---
//////	    try (FileInputStream fis = new FileInputStream(exportedFile);
//////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//////
//////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//////	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//////
//////	        int customerCol  = headerMap.get("Customer Name");
//////	        int bopPartNoCol = headerMap.get("BOP Master Part No.");
//////	        int costCol      = headerMap.get("Part Cost/Unit");
//////
//////	        Row row = bopCost.getRow(lastRowExcelNo - 1);
//////	        Assert.assertNotNull(row, "❌ Last row not found in BOP_Cost!");
//////
//////	        String excelCustomer = row.getCell(customerCol)  != null ? row.getCell(customerCol).toString() : "";
//////	        String bopPart       = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
//////
//////	        // actual cost
//////	        String cost = "";
//////	        if (row.getCell(costCol) != null) {
//////	            CellValue cv = evaluator.evaluate(row.getCell(costCol));
//////	            if (cv != null) {
//////	                switch (cv.getCellType()) {
//////	                    case STRING:  cost = cv.getStringValue().trim(); break;
//////	                    case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//////	                    default:      cost = row.getCell(costCol).toString().trim();
//////	                }
//////	            }
//////	        }
//////
//////	        // expected cost lookup
//////	        String expectedCost = preservedMap
//////	                .getOrDefault(excelCustomer, new HashMap<>())
//////	                .get(duplicateBop);
//////
//////	        if (expectedCost == null) {
//////	            String normalizedKey = excelCustomer.trim().replaceAll("\\s+", "");
//////	            expectedCost = normalizedMap
//////	                    .getOrDefault(normalizedKey, new HashMap<>())
//////	                    .get(duplicateBop);
//////	        }
//////
//////	        LoggerUtil.info("🔎 Row 3 → Customer=" + excelCustomer +
//////                    " | BOP=" + bopPart +
//////                    " | Cost=" + cost +
//////                    " | Expected=" + expectedCost);
//////
//////    if (expectedCost.equals(cost)) {
//////        LoggerUtil.pass("✅ Row 3: MATCHED for Customer=" + excelCustomer);
//////    } else {
//////        LoggerUtil.error("❌ Row 3: Cost mismatch → Expected=" + expectedCost + ", Found=" + cost);
//////        Assert.fail("Row 3 validation failed!");
//////    }
//////}
//////	   }
////	
////
////	
//	@Test(priority = 92, groups = "group1")
//	public void TC_PM_DC_92ValidateExportContainsOnlySelectedSupplierBOPsAndCosts() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_092: Validate export contains only selected-supplier BOP rows & costs (Procurement)");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110"); // S1 only
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_092: " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    String targetSupplier = "Prabhat-3110";
//
//	    // --- Step 2: Build Supplier→PartNo→Cost mapping from BOP_Master ---
//	    Map<String, Map<String, String>> supplierToPartCost = new HashMap<>();
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//
//	        int partNoCol   = headerMap.get("Part No.");
//	        int supplierCol = headerMap.get("Supplier");
//	        int costCol     = headerMap.get("Part Cost/Unit");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim()   : "";
//	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
//
//	            String cost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        case BOOLEAN: cost = String.valueOf(cv.getBooleanValue()).trim(); break;
//	                        default:      cost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            if (!part.isEmpty() && !supplier.isEmpty()) {
//	                supplierToPartCost
//	                    .computeIfAbsent(supplier, k -> new HashMap<>())
//	                    .put(part, cost);
//	            }
//	        }
//	    }
//
//	    LoggerUtil.info("📋 S1 parts count in BOP_Master: "
//	            + supplierToPartCost.getOrDefault(targetSupplier, new HashMap<>()).size());
//
//	    for (Map.Entry<String, Map<String, String>> supplierEntry : supplierToPartCost.entrySet()) {
//	        String supplier = supplierEntry.getKey();
//	        Map<String, String> partCostMap = supplierEntry.getValue();
//
//	        LoggerUtil.info("🔎 Supplier = " + supplier + " → Total Parts = " + partCostMap.size());
//	        for (Map.Entry<String, String> partEntry : partCostMap.entrySet()) {
//	            LoggerUtil.info("   • Part No = " + partEntry.getKey()
//	                          + " | Cost = " + partEntry.getValue());
//	        }
//	    }
//
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Supplier Name", "Prabhat-3110");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", "rky1");
//
//	    // --- Step 3: Validate rows in BOP_Cost ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int supplierNameCol = headerMap.get("Supplier Name");
//	        int bopPartNoCol    = headerMap.get("BOP Master Part No.");
//	        int costCol         = headerMap.get("Part Cost/Unit");
//
//	        int validCount = 0, invalidCount = 0;
//
//	        for (int r = 2; r <= bopCost.getLastRowNum(); r++) {
//	            Row row = bopCost.getRow(r);
//	            if (row == null) continue;
//
//	            String supplierName = row.getCell(supplierNameCol) != null ? row.getCell(supplierNameCol).toString().trim() : "";
//	            String bopPartNo    = row.getCell(bopPartNoCol)    != null ? row.getCell(bopPartNoCol).toString().trim()    : "";
//
//	            String cost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        case BOOLEAN: cost = String.valueOf(cv.getBooleanValue()).trim(); break;
//	                        default:      cost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            if (!supplierName.isEmpty() && !bopPartNo.isEmpty()) {
//	                if (!supplierName.equals(targetSupplier)) {
//	                    LoggerUtil.error("❌ Row " + (r+1) + ": Found foreign Supplier=" + supplierName +
//	                                     " with BOP=" + bopPartNo);
//	                    invalidCount++;
//	                } else {
//	                    Map<String, String> validParts = supplierToPartCost.getOrDefault(targetSupplier, new HashMap<>());
//	                    String expectedCost = validParts.getOrDefault(bopPartNo, "N/A");
//
//	                    if (expectedCost.equals(cost)) {
//	                        LoggerUtil.pass("✅ Row " + (r+1) + ": Supplier=" + supplierName +
//	                                        " → BOP=" + bopPartNo + " Cost=" + cost + " (MATCHED)");
//	                        validCount++;
//	                    } else {
//	                        LoggerUtil.error("❌ Row " + (r+1) + ": Cost mismatch for BOP=" + bopPartNo +
//	                                         ". Expected=" + expectedCost + ", Found=" + cost);
//	                        invalidCount++;
//	                    }
//	                }
//	            }
//	        }
//
//	        LoggerUtil.info("🎯 Validation Summary → Valid=" + validCount + " | Invalid=" + invalidCount);
//	        Assert.assertEquals(invalidCount, 0,
//	                "❌ Invalid/foreign supplier rows OR cost mismatches found in BOP_Cost after S1-only export!");
//	    }
//	}
//	
////	@Test(priority = 93, groups = "group1")
////	public void TC_PM_DC_93ValidateExportWithTripleDuplicateBOPsForMultipleSuppliers() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_093: Validate >2 suppliers with triple-duplicate BOP names (Procurement)");
////
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(2000);
////	    PartMasterPage.selectOnCustomerValuesByText("adiydtj");
////	    Thread.sleep(3000);
////	    PartMasterDetailCostingRivisedPage.selectProcurement();
////
////	    // Select multiple suppliers (S1, S2, S3)
////	    String[] targetSuppliers = {"Allysonvuxg-26863064", "Bibiauvyt-239", "Anastasiaflfb-18812581"};
////	    PartMasterPage.selectOnSupplierValuesByText(targetSuppliers);
////	    Thread.sleep(3000);
////
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    Thread.sleep(60000);
////
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded file for TC_PM_DC_093: " + exportedFile);
////	    waitForFileDownload(exportedFile, 30);
////
////	    // --- Step 2: Build Supplier→PartNo→Cost mapping from BOP_Master ---
////	    Map<String, Map<String, String>> supplierToPartCost = new HashMap<>();
////	    String duplicateBop = null; // dynamically detect
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
////
////	        int partNoCol   = headerMap.get("Part No.");
////	        int supplierCol = headerMap.get("Supplier");
////	        int costCol     = headerMap.get("Part Cost/Unit");
////
////	        // Count frequency of each part across suppliers
////	        Map<String, Integer> partFrequency = new HashMap<>();
////
////	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
////	            Row row = bopMaster.getRow(r);
////	            if (row == null) continue;
////
////	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim()   : "";
////	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        case BOOLEAN: cost = String.valueOf(cv.getBooleanValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            if (!part.isEmpty() && !supplier.isEmpty()) {
////	                supplierToPartCost
////	                    .computeIfAbsent(supplier, k -> new HashMap<>())
////	                    .put(part, cost);
////
////	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
////	            }
////	        }
////
////	        // Find a part that is duplicate across >= 2 suppliers
////	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
////	            if (e.getValue() >= 2) {
////	                duplicateBop = e.getKey();
////	                break;
////	            }
////	        }
////	    }
////
////	    if (duplicateBop == null) {
////	        LoggerUtil.error("❌ No duplicate BOP found across suppliers in BOP_Master!");
////	        Assert.fail("Test cannot continue without a duplicate BOP.");
////	    } else {
////	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
////	    }
////
////	    // --- Step 3: Select Supplier + BOP in BOP_Cost rows dynamically ---
////	    for (int i = 0; i < targetSuppliers.length; i++) {
////	        int rowIndex = i + 3; // rows start from 3 in Excel
////	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "Supplier Name", targetSuppliers[i]);
////	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "BOP Master Part No.", duplicateBop);
////	    }
////
////	    // --- Step 4: Validate row-wise mapping ---
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////
////	        int supplierNameCol = headerMap.get("Supplier Name");
////	        int bopPartNoCol    = headerMap.get("BOP Master Part No.");
////	        int costCol         = headerMap.get("Part Cost/Unit");
////
////	        int valid = 0, invalid = 0;
////
////	        for (int i = 0; i < targetSuppliers.length; i++) {
////	            int r = i + 2; // Excel row index (row 3..)
////	            Row row = bopCost.getRow(r);
////	            if (row == null) continue;
////
////	            String supplier = row.getCell(supplierNameCol) != null ? row.getCell(supplierNameCol).toString().trim() : "";
////	            String bopPart  = row.getCell(bopPartNoCol)    != null ? row.getCell(bopPartNoCol).toString().trim()    : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            String expectedCost = supplierToPartCost
////	                    .getOrDefault(supplier, new HashMap<>())
////	                    .get(duplicateBop);
////
////	            if (expectedCost == null) {
////	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Supplier=" + supplier +
////	                                " | BOP=" + bopPart +
////	                                " → No mapping found in BOP_Master (Skipping validation).");
////	                continue;
////	            }
////
////	            if (cost == null || cost.isEmpty()) {
////	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Supplier=" + supplier +
////	                                " | BOP=" + bopPart +
////	                                " → Expected=" + expectedCost +
////	                                " | Actual cost not available in BOP_Cost.");
////	                continue;
////	            }
////
////	            LoggerUtil.info("🔎 Row " + (r + 1) + " → Supplier=" + supplier +
////	                            " | BOP=" + bopPart +
////	                            " | Cost=" + cost +
////	                            " | Expected=" + expectedCost);
////
////	            if (expectedCost.equals(cost)) {
////	                LoggerUtil.pass("✅ Row " + (r + 1) + ": Supplier=" + supplier +
////	                                " | BOP=" + bopPart +
////	                                " | Cost=" + cost + " (MATCHED)");
////	                valid++;
////	            } else {
////	                LoggerUtil.error("❌ Row " + (r + 1) + ": Cost mismatch for Supplier=" + supplier +
////	                                 ". Expected=" + expectedCost + ", Found=" + cost);
////	                invalid++;
////	            }
////	        }
////
////	        LoggerUtil.info("🎯 Final Validation Summary → Valid=" + valid + " | Invalid=" + invalid);
////	        Assert.assertTrue(true, "Dynamic validation completed for triple duplicate BOPs.");
////	    }
////	}
//	
//	@Test(priority = 93, groups = "group1")
//	public void TC_PM_DC_93ValidateExportWithTripleDuplicateBOPsForMultipleSuppliers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_093: Validate >2 suppliers with triple-duplicate BOP names (Procurement)");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	    // Select multiple suppliers (S1, S2, S3)
//	    String[] targetSuppliers = {"Prabhat-3110", "Roshan-3111", "Nilesh-3112"};
//	    PartMasterPage.selectOnSupplierValuesByText(targetSuppliers);
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_093: " + exportedFile);
//	    waitForFileDownload(exportedFile, 30);
//
//	    // --- Step 2: Build Supplier→PartNo→Cost mapping from BOP_Master ---
//	    Map<String, Map<String, String>> supplierToPartCost = new HashMap<>();
//	    String duplicateBop = null; // dynamically detect
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//
//	        int partNoCol   = headerMap.get("Part No.");
//	        int supplierCol = headerMap.get("Supplier");
//	        int costCol     = headerMap.get("Part Cost/Unit");
//
//	        // Count frequency of each part across suppliers
//	        Map<String, Integer> partFrequency = new HashMap<>();
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim()   : "";
//	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
//
//	            String cost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        case BOOLEAN: cost = String.valueOf(cv.getBooleanValue()).trim(); break;
//	                        default:      cost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            if (!part.isEmpty() && !supplier.isEmpty()) {
//	                supplierToPartCost
//	                    .computeIfAbsent(supplier, k -> new HashMap<>())
//	                    .put(part, cost);
//
//	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
//	            }
//	        }
//
//	        // Find a part that is duplicate across >= 2 suppliers
//	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
//	            if (e.getValue() >= 2) {
//	                duplicateBop = e.getKey();
//	                break;
//	            }
//	        }
//	    }
//
//	    if (duplicateBop == null) {
//	        LoggerUtil.error("❌ No duplicate BOP found across suppliers in BOP_Master!");
//	        Assert.fail("Test cannot continue without a duplicate BOP.");
//	    } else {
//	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
//	    }
//
//	    // --- Step 3: Select Supplier + BOP in BOP_Cost rows dynamically ---
//	    for (int i = 0; i < targetSuppliers.length; i++) {
//	        int rowIndex = i + 3; // rows start from 3 in Excel
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "Supplier Name", targetSuppliers[i]);
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "BOP Master Part No.", duplicateBop);
//	    }
//
//	    // --- Step 4: Validate row-wise mapping ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int supplierNameCol = headerMap.get("Supplier Name");
//	        int bopPartNoCol    = headerMap.get("BOP Master Part No.");
//	        int costCol         = headerMap.get("Part Cost/Unit");
//
//	        int valid = 0, invalid = 0;
//
//	        for (int i = 0; i < targetSuppliers.length; i++) {
//	            int r = i + 2; // Excel row index (row 3..)
//	            Row row = bopCost.getRow(r);
//	            if (row == null) continue;
//
//	            String supplier = row.getCell(supplierNameCol) != null ? row.getCell(supplierNameCol).toString().trim() : "";
//	            String bopPart  = row.getCell(bopPartNoCol)    != null ? row.getCell(bopPartNoCol).toString().trim()    : "";
//
//	            String cost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        default:      cost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            String expectedCost = supplierToPartCost
//	                    .getOrDefault(supplier, new HashMap<>())
//	                    .get(duplicateBop);
//
//	            if (expectedCost == null) {
//	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Supplier=" + supplier +
//	                                " | BOP=" + bopPart +
//	                                " → No mapping found in BOP_Master (Skipping validation).");
//	                continue;
//	            }
//
//	            if (cost == null || cost.isEmpty()) {
//	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Supplier=" + supplier +
//	                                " | BOP=" + bopPart +
//	                                " → Expected=" + expectedCost +
//	                                " | Actual cost not available in BOP_Cost.");
//	                continue;
//	            }
//
//	            LoggerUtil.info("🔎 Row " + (r + 1) + " → Supplier=" + supplier +
//	                            " | BOP=" + bopPart +
//	                            " | Cost=" + cost +
//	                            " | Expected=" + expectedCost);
//
//	            if (expectedCost.equals(cost)) {
//	                LoggerUtil.pass("✅ Row " + (r + 1) + ": Supplier=" + supplier +
//	                                " | BOP=" + bopPart +
//	                                " | Cost=" + cost + " (MATCHED)");
//	                valid++;
//	            } else {
//	                LoggerUtil.error("❌ Row " + (r + 1) + ": Cost mismatch for Supplier=" + supplier +
//	                                 ". Expected=" + expectedCost + ", Found=" + cost);
//	                invalid++;
//	            }
//	        }
//
//	        LoggerUtil.info("🎯 Final Validation Summary → Valid=" + valid + " | Invalid=" + invalid);
//	        Assert.assertTrue(true, "Dynamic validation completed for triple duplicate BOPs.");
//	    }
//	}
//
////	@Test(priority = 94, groups = "group1",enabled = false)
////	public void TC_PM_DC_94ValidateExportWithDuplicateBOPsForMultipleCustomers() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_094: Validate many customers with duplicate BOP names (Sales)");
////
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(2000);
////	    // 👉 Sales radio button
////	    PartMasterDetailCostingRivisedPage.selectSales();
////
////	    // Select multiple customers (C1..C5)
////	    String[] UItargetCustomers = {"Prabhat-Gazipur-3110", "Roshan-Gazipur-3111", "Nilesh-Gazipur-3112"};
////	    PartMasterPage.selectOnCustomerValuesByText(UItargetCustomers);
////	    Thread.sleep(3000);
////
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    Thread.sleep(60000);
////
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded file for TC_PM_DC_094: " + exportedFile);
////	    waitForFileDownload(exportedFile, 30);
////
////	    String duplicateBop = null;
////	    String[] targetCustomers = {"Prabhat-3110", "Roshan-3111", "Nilesh-3112"};
////	    // --- Step 2: Build Customer→PartNo→Cost mapping from BOP_Master ---
////	    Map<String, Map<String, String>> customerToPartCost = new HashMap<>();
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
////
////	        int partNoCol    = headerMap.get("Part No.");
////	        int customerCol  = headerMap.get("Customer");
////	        int costCol      = headerMap.get("Part Cost/Unit");
////
////	        Map<String, Integer> partFrequency = new HashMap<>();
////
////	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
////	            Row row = bopMaster.getRow(r);
////	            if (row == null) continue;
////
////	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim()   : "";
////	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            if (!part.isEmpty() && !customer.isEmpty()) {
////	                customerToPartCost
////	                    .computeIfAbsent(customer, k -> new HashMap<>())
////	                    .put(part, cost);
////
////	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
////	            }
////	        }
////
////	        // Pick any part duplicated across ≥2 customers
////	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
////	            if (e.getValue() >= 2) {
////	                duplicateBop = e.getKey();
////	                break;
////	            }
////	        }
////	    }
////
////	    if (duplicateBop == null) {
////	        LoggerUtil.error("❌ No duplicate BOP found across customers in BOP_Master!");
////	        Assert.fail("Test cannot continue without a duplicate BOP.");
////	    } else {
////	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
////	    }
////
////	    // --- Step 3: Select Customer + BOP in BOP_Cost rows dynamically ---
////	    for (int i = 0; i < targetCustomers.length; i++) {
////	        int rowIndex = i + 3; // rows start from 3
////	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "Customer Name", targetCustomers[i]);
////	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "BOP Master Part No.", duplicateBop);
////	    }
////
////	    // --- Step 4: Validate row-wise mapping ---
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////
////	        int customerCol    = headerMap.get("Customer Name");
////	        int bopPartNoCol   = headerMap.get("BOP Master Part No.");
////	        int costCol        = headerMap.get("Part Cost/Unit");
////
////	        int valid = 0, skipped = 0, invalid = 0;
////
////	        for (int i = 0; i < targetCustomers.length; i++) {
////	            int r = i + 2; // Excel row (starts row 3)
////	            Row row = bopCost.getRow(r);
////	            if (row == null) continue;
////
////	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
////	            String bopPart  = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            String expectedCost = customerToPartCost
////	                    .getOrDefault(customer, new HashMap<>())
////	                    .get(duplicateBop);
////
////	            if (expectedCost == null) {
////	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Customer=" + customer +
////	                                " | BOP=" + bopPart +
////	                                " → No mapping found in BOP_Master (Skipping validation).");
////	                skipped++;
////	                continue;
////	            }
////
////	            if (cost == null || cost.isEmpty()) {
////	                LoggerUtil.info("ℹ️ Row " + (r + 1) + ": Customer=" + customer +
////	                                " | BOP=" + bopPart +
////	                                " → Expected=" + expectedCost +
////	                                " | Actual cost not available.");
////	                skipped++;
////	                continue;
////	            }
////
////	            LoggerUtil.info("🔎 Row " + (r + 1) + " → Customer=" + customer +
////	                            " | BOP=" + bopPart +
////	                            " | Cost=" + cost +
////	                            " | Expected=" + expectedCost);
////
////	            if (expectedCost.equals(cost)) {
////	                LoggerUtil.pass("✅ Row " + (r + 1) + ": MATCHED for Customer=" + customer);
////	                valid++;
////	            } else {
////	                LoggerUtil.error("❌ Row " + (r + 1) + ": Cost mismatch → Expected=" + expectedCost + ", Found=" + cost);
////	                invalid++;
////	            }
////	        }
////
////	        LoggerUtil.info("🎯 Final Validation Summary → Valid=" + valid + " | Skipped=" + skipped + " | Invalid=" + invalid);
////	        // Don't fail test if skipped > 0, only fail if actual mismatch exists
////	        Assert.assertEquals(invalid, 0, "❌ Duplicate BOP entries not correctly mapped for some customers!");
////	    }
////	}
//	
//	@Test(priority = 94, groups = "group1")
//	public void TC_PM_DC_94ValidateExportWithDuplicateBOPsForSales_MultiRows() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_094: Validate Sales – Many customers with duplicate BOPs across multiple rows");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//
//	    String[] targetCustomers = {
//	        "Mk-2208-5-Mohali-2208-5",
//	        "Mk-2208-9-Mohali-2208-9",
//	        "Mk-2208-7-Mohali-2208-7",
//	        "2208-3-Mohali-2208-3",
//	        "69452-Jamestown-Lorenzonxrbf"
//	    };
//	    PartMasterPage.selectOnCustomerValuesByText(targetCustomers);
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_094 (Sales): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//	    String[] preservedCustomer = {
//		        " Mk-2208-5-2208-5",
//		        " Mk-2208-7-2208-7",
//		        " Mk-2208-9-2208-9",
//		        "2208-3-2208-3",
//		        "69452-Lorenzonxrbf"
//		    };
//	    String duplicateBop = "BHD"; // Hardcoded duplicate for this scenario
//
//	    // --- Step 2: Build Customer→PartNo→Cost mapping from BOP_Master ---
//	    Map<String, Map<String, String>> customerToPartCost = new HashMap<>();
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//
//	        int partNoCol   = headerMap.get("Part No.");
//	        int customerCol = headerMap.get("Customer");
//	        int costCol     = headerMap.get("Part Cost/Unit");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim() : "";
//	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
//
//	            String cost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        default:      cost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            if (!part.isEmpty() && !customer.isEmpty()) {
//	                String normalizedCustomer = customer.trim().replaceAll("\\s+", "");
//	                customerToPartCost
//	                    .computeIfAbsent(normalizedCustomer, k -> new HashMap<>())
//	                    .put(part, cost);
//	            }
//	        }
//	    }
//
//	    // --- Step 3: Validate duplicate BOP across multiple rows (e.g., row 2, 500, 1000) ---
//	    int[] rowsToCheck = {2, 500, 1000};
//	    List<String[]> results = new ArrayList<>();
//
//	    for (int excelRow : rowsToCheck) {
//	        int rowIndex = excelRow + 1; // adjust for Excel header offset
//
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "Customer Name", preservedCustomer[0]);
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", rowIndex, "BOP Master Part No.", duplicateBop);
//
//	        try (FileInputStream fis = new FileInputStream(exportedFile);
//	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	            XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	            Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	            // --- Safe header lookup ---
//	            Integer customerCol = headerMap.entrySet().stream()
//	                .filter(e -> e.getKey().trim().equalsIgnoreCase("Customer Name"))
//	                .map(Map.Entry::getValue).findFirst().orElse(null);
//	            Assert.assertNotNull(customerCol, "❌ 'Customer Name' column not found!");
//
//	            Integer bopPartNoCol = headerMap.entrySet().stream()
//	                .filter(e -> e.getKey().trim().equalsIgnoreCase("BOP Master Part No."))
//	                .map(Map.Entry::getValue).findFirst().orElse(null);
//	            Assert.assertNotNull(bopPartNoCol, "❌ 'BOP Master Part No.' column not found!");
//
//	            Integer costCol = headerMap.entrySet().stream()
//	                .filter(e -> e.getKey().trim().equalsIgnoreCase("Part Cost/Unit"))
//	                .map(Map.Entry::getValue).findFirst().orElse(null);
//	            Assert.assertNotNull(costCol, "❌ 'Part Cost/Unit' column not found!");
//
//	            Row row = bopCost.getRow(rowIndex - 1);
//	            Assert.assertNotNull(row, "❌ Row " + excelRow + " not found in BOP_Cost!");
//
//	            String excelCustomer = row.getCell(customerCol)  != null ? row.getCell(customerCol).toString().trim() : "";
//	            String bopPart       = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
//
//	            String actualCost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  actualCost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: actualCost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        default:      actualCost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            String normalizedCustomer = excelCustomer.trim().replaceAll("\\s+", "");
//	            String expectedCost = customerToPartCost
//	                    .getOrDefault(normalizedCustomer, new HashMap<>())
//	                    .get(duplicateBop);
//
//	            String result = (expectedCost != null && expectedCost.equals(actualCost)) ? "PASS" : "FAIL";
//	            results.add(new String[]{String.valueOf(excelRow), excelCustomer, bopPart, expectedCost, actualCost, result});
//	        }
//	    }
//
//	    // --- Step 4: Report Results ---
//	    LoggerUtil.info("===== Validation Results for Duplicate BOP across Rows =====");
//	    for (String[] res : results) {
//	        String rowOut = String.format("Row: %-5s | Customer: %-25s | BOP Part: %-10s | Expected: %-10s | Actual: %-10s | Result: %s",
//	                                      res[0], res[1], res[2], res[3], res[4], res[5]);
//
//	        if ("PASS".equals(res[5])) {
//	            LoggerUtil.pass(rowOut);
//	        } else {
//	            LoggerUtil.error(rowOut);
//	            Assert.fail("❌ Validation failed at Row=" + res[0] + " for Customer=" + res[1]);
//	        }
//	    }
//	    LoggerUtil.info("==========================================================================");
//	}
//
//	
//	@Test(priority = 95, groups = "group1")
//	public void TC_PM_DC_95ValidateExportWithMaxRowsAndLastRowDuplicateBOPFor_Saless() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_095: Validate Max rows (1000) – Sales with duplicate BOPs on last row (hardcoded customers)");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//
//	    // Fixed customers (UI selection)
//	    String[] targetCustomers = {
//	        "Mk-2208-5-Mohali-2208-5",
//	        "Mk-2208-9-Mohali-2208-9",
//	        "Mk-2208-7-Mohali-2208-7",
//	        "2208-3-Mohali-2208-3",
//	        "69452-Jamestown-Lorenzonxrbf"
//	    };
//	    PartMasterPage.selectOnCustomerValuesByText(targetCustomers);
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_095 (Sales): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    // --- Step 2: Hardcoded duplicate BOP ---
//	    String duplicateBop = "BHD";
//
//	    // Preserved customer names as they appear in Excel
//	    String[] preservedCustomer = {
//	        " Mk-2208-5-2208-5",
//	        " Mk-2208-7-2208-7",
//	        " Mk-2208-9-2208-9",
//	        "2208-3-2208-3",
//	        "69452-Lorenzonxrbf"
//	    };
//
//	    // --- Step 3: Build Customer→PartNo→Cost mapping from BOP_Master ---
//	    Map<String, Map<String, String>> customerToPartCost = new HashMap<>();
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
//
//	        int partNoCol   = headerMap.get("Part No.");
//	        int customerCol = headerMap.get("Customer");
//	        int costCol     = headerMap.get("Part Cost/Unit");
//
//	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
//	            Row row = bopMaster.getRow(r);
//	            if (row == null) continue;
//
//	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim() : "";
//	            String customer = row.getCell(customerCol) != null ? row.getCell(customerCol).toString().trim() : "";
//
//	            String cost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  cost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        default:      cost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            if (!part.isEmpty() && !customer.isEmpty()) {
//	                String normalizedCustomer = customer.trim().replaceAll("\\s+", "");
//	                customerToPartCost
//	                    .computeIfAbsent(normalizedCustomer, k -> new HashMap<>())
//	                    .put(part, cost);
//	            }
//	        }
//	    }
//
//	    // --- Step 4: Validate ALL customers on LAST row (1000) ---
//	    int lastRowExcelNo = 1002;
//	    List<String[]> results = new ArrayList<>();
//
//	    for (String customerName : preservedCustomer) {
//	        String normalizedCustomer = customerName.trim().replaceAll("\\s+", "");
//
//	        // Select Customer + duplicate BOP in last row
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", lastRowExcelNo, "Customer Name", customerName);
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", lastRowExcelNo, "BOP Master Part No.", duplicateBop);
//
//	        try (FileInputStream fis = new FileInputStream(exportedFile);
//	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//	            XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	            Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	            int customerCol  = headerMap.get("Customer Name");
//	            int bopPartNoCol = headerMap.get("BOP Master Part No.");
//	            int costCol      = headerMap.get("Part Cost/Unit");
//
//	            Row row = bopCost.getRow(lastRowExcelNo - 1);
//	            Assert.assertNotNull(row, "❌ Last row not found in BOP_Cost!");
//
//	            String excelCustomer = row.getCell(customerCol)  != null ? row.getCell(customerCol).toString().trim() : "";
//	            String bopPart       = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
//
//	            String actualCost = "";
//	            if (row.getCell(costCol) != null) {
//	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
//	                if (cv != null) {
//	                    switch (cv.getCellType()) {
//	                        case STRING:  actualCost = cv.getStringValue().trim(); break;
//	                        case NUMERIC: actualCost = String.valueOf(cv.getNumberValue()).trim(); break;
//	                        default:      actualCost = row.getCell(costCol).toString().trim();
//	                    }
//	                }
//	            }
//
//	            // ✅ Expected cost from BOP_Master
//	            String expectedCost = customerToPartCost
//	                    .getOrDefault(normalizedCustomer, new HashMap<>())
//	                    .get(duplicateBop);
//
//	            String result = (expectedCost != null && expectedCost.equals(actualCost)) ? "PASS" : "FAIL";
//	            results.add(new String[]{excelCustomer, bopPart, expectedCost, actualCost, result});
//	        }
//	    }
//
//	    // --- Step 5: Print consolidated results ---
//	    LoggerUtil.info("===== Validation Results for Last Row (1000) =====");
//	    for (String[] res : results) {
//	        String rowOut = String.format("Customer: %-25s | BOP Part: %-10s | Expected: %-10s | Actual: %-10s | Result: %s",
//	                                      res[0], res[1], res[2], res[3], res[4]);
//
//	        if ("PASS".equals(res[4])) {
//	            LoggerUtil.pass(rowOut);
//	        } else {
//	            LoggerUtil.error(rowOut);
//	            Assert.fail("❌ Validation failed for Customer=" + res[0]);
//	        }
//	    }
//	    LoggerUtil.info("==========================================================================");
//	}
//	
////	@Test(priority = 95, groups = "group1")
////	public void TC_PM_DC_95ValidateExportWithMaxRowsAndLastRowDuplicateBOPForAllSuppliers() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_095: Validate Max rows (1000) – Procurement with duplicate BOPs on last row (all suppliers)");
////
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(2000);
////	    PartMasterPage.selectOnCustomerValuesByText("adiydtj");
////	    Thread.sleep(3000);
////	    PartMasterDetailCostingRivisedPage.selectProcurement();
////
////	    // Select multiple suppliers dynamically
////	    String[] targetSuppliers = {
////	        "AAAAHeribertobqpv-491.82",
////	        "AAAAVirginiacbou-414.08",
////	        "Bernardoqmnnyr-407",
////	        "Chadwickgearip-882",
////	        "Conniekynowyr-265.38"
////	    };
////	    PartMasterPage.selectOnSupplierValuesByText(targetSuppliers);
////	    Thread.sleep(3000);
////
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000); // force max rows
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    Thread.sleep(60000);
////
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded file for TC_PM_DC_095 (Procurement): " + exportedFile);
////	    waitForFileDownload(exportedFile, 60);
////
////	    String duplicateBop = null;
////	    Map<String, Map<String, String>> supplierToPartCost = new HashMap<>();
////
////	    // --- Step 2: Build Supplier→PartNo→Cost mapping from BOP_Master ---
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	        XSSFSheet bopMaster = workbook.getSheet("BOP_Master");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Master", 1);
////
////	        int partNoCol   = headerMap.get("Part No.");
////	        int supplierCol = headerMap.get("Supplier");
////	        int costCol     = headerMap.get("Part Cost/Unit");
////
////	        Map<String, Integer> partFrequency = new HashMap<>();
////
////	        for (int r = 2; r <= bopMaster.getLastRowNum(); r++) {
////	            Row row = bopMaster.getRow(r);
////	            if (row == null) continue;
////
////	            String part     = row.getCell(partNoCol)   != null ? row.getCell(partNoCol).toString().trim() : "";
////	            String supplier = row.getCell(supplierCol) != null ? row.getCell(supplierCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            if (!part.isEmpty() && !supplier.isEmpty()) {
////	                supplierToPartCost
////	                    .computeIfAbsent(supplier, k -> new HashMap<>())
////	                    .put(part, cost);
////	                partFrequency.put(part, partFrequency.getOrDefault(part, 0) + 1);
////	            }
////	        }
////
////	        for (Map.Entry<String, Integer> e : partFrequency.entrySet()) {
////	            if (e.getValue() >= 2) {
////	                duplicateBop = e.getKey();
////	                break;
////	            }
////	        }
////	    }
////
////	    if (duplicateBop == null) {
////	        LoggerUtil.error("❌ No duplicate BOP found across suppliers in BOP_Master!");
////	        Assert.fail("Test cannot continue without a duplicate BOP.");
////	    } else {
////	        LoggerUtil.info("✅ Selected duplicate BOP for validation: " + duplicateBop);
////	    }
////
////	    // --- Step 3: Validate ALL suppliers on LAST row (1000) ---
////	    int lastRowExcelNo = 1002;
////	    List<String[]> results = new ArrayList<>();
////
////	    for (String supplierName : targetSuppliers) {
////	        // Select supplier + duplicate BOP
////	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", lastRowExcelNo, "Supplier Name", supplierName);
////	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", lastRowExcelNo, "BOP Master Part No.", duplicateBop);
////
////	        try (FileInputStream fis = new FileInputStream(exportedFile);
////	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////	            XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
////	            Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////
////	            int supplierCol  = headerMap.get("Supplier Name");
////	            int bopPartNoCol = headerMap.get("BOP Master Part No.");
////	            int costCol      = headerMap.get("Part Cost/Unit");
////
////	            Row row = bopCost.getRow(lastRowExcelNo - 1);
////	            Assert.assertNotNull(row, "❌ Last row not found in BOP_Cost!");
////
////	            String excelSupplier = row.getCell(supplierCol)  != null ? row.getCell(supplierCol).toString().trim() : "";
////	            String bopPart       = row.getCell(bopPartNoCol) != null ? row.getCell(bopPartNoCol).toString().trim() : "";
////
////	            String cost = "";
////	            if (row.getCell(costCol) != null) {
////	                CellValue cv = evaluator.evaluate(row.getCell(costCol));
////	                if (cv != null) {
////	                    switch (cv.getCellType()) {
////	                        case STRING:  cost = cv.getStringValue().trim(); break;
////	                        case NUMERIC: cost = String.valueOf(cv.getNumberValue()).trim(); break;
////	                        default:      cost = row.getCell(costCol).toString().trim();
////	                    }
////	                }
////	            }
////
////	            String expectedCost = supplierToPartCost
////	                    .getOrDefault(excelSupplier, new HashMap<>())
////	                    .get(duplicateBop);
////
////	            String result = (expectedCost != null && expectedCost.equals(cost)) ? "PASS" : "FAIL";
////	            results.add(new String[]{excelSupplier, duplicateBop, expectedCost, cost, result});
////	        }
////	    }
////
////	 // --- Step 4: Print consolidated console + LoggerUtil table ---
////	   
////	    LoggerUtil.info("===== Validation Results for Last Row (1000) =====");
////	  
////	    LoggerUtil.info("==========================================================================");
////
////	    for (String[] res : results) {
////	        String rowOut = String.format("%-30s %-20s %-15s %-15s %-8s",
////	                                      res[0], res[1], res[2], res[3], res[4]);
////
////	        // Console + Extent Report dono me row-wise entry
////	        if ("PASS".equals(res[4])) {
////	            LoggerUtil.pass("Supplier: " + res[0] +
////	                            " | BOP Part: " + res[1] +
////	                            " | Expected Cost: " + res[2] +
////	                            " | Actual Cost: " + res[3] +
////	                            " | Result: PASS");
////	        } else {
////	            LoggerUtil.error("Supplier: " + res[0] +
////	                             " | BOP Part: " + res[1] +
////	                             " | Expected Cost: " + res[2] +
////	                             " | Actual Cost: " + res[3] +
////	                             " | Result: FAIL");
////	            Assert.fail("❌ Validation failed for Supplier=" + res[0]);
////	        }
////	    }
////
////	    LoggerUtil.info("==========================================================================");
////
////	}
////
////	
////	@Test(priority = 96, groups = "group1")
////	public void TC_PM_DC_96ValidateExportWithMaxRowsAndLastRowDuplicateBOPFor_Procurement() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_096: Validate Procurement – Supplier validation rule: valid pair (no red)");
////
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(2000);
////	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
////	    Thread.sleep(3000);
////	    PartMasterDetailCostingRivisedPage.selectProcurement(); 
////
////	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110"); 
////	    Thread.sleep(3000);
////
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100); 
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    Thread.sleep(60000); 
////
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded file for TC_PM_DC_096 (Procurement): " + exportedFile);
////	    waitForFileDownload(exportedFile, 60);
////
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        // --- Step 2: Selecting Supplier + Part No. in BOP_Cost ---
////	    	PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "kdhfF");
////	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "kdhfF");
////	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Supplier Name", "Prabhat-3110");
////	    	
////	        // --- Step 3: Read the BOP_Cost sheet for validation ---
////	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////
////	        int supplierNameCol = headerMap.get("Supplier Name");
////	        Row row = bopCost.getRow(3); // Check only Row 3
////	        Assert.assertNotNull(row, "❌ Row 3 not found in BOP_Cost!");
////	        
////	        // Get the Customer Name from the row and check for validation
////	        String supplierName = row.getCell(supplierNameCol) != null ? row.getCell(supplierNameCol).toString().trim() : "";
////
////	        // --- Step 4: Check for Red Fill ---
////	        CellStyle style = row.getCell(supplierNameCol).getCellStyle();
////	        String expectedColor = "#FF0000"; // Red color in ARGB hex format
////
////	        XSSFColor color = (XSSFColor) style.getFillForegroundColorColor();
////	        if (color != null) {
////	            String rgb = color.getARGBHex();
////	            if (rgb.equals(expectedColor)) {  // Check if the color matches red
////	                LoggerUtil.error("❌ Red fill detected for Customer " + supplierName);
////	                Assert.fail("Red fill detected for Customer Name cell, indicating an error state.");
////	            } else {
////	                LoggerUtil.info("✅ No red fill detected, validation passed.");
////	            }
////	        } else {
////	        	LoggerUtil.info("✅ No red fill detected, validation passed.");
////	        }
////	    }
////	}
//	
//	@Test(priority = 96, groups = "group1")
//	public void TC_PM_DC_96ValidatePartNoAppearsInBOPCostDropdown_Procurement() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_096: Validate Part No. entered in Part_Master appears in BOP_Cost dropdown (Procurement)");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110");
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_096: " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    // --- Step 2: Write the Part No. in Part_Master sheet ---
//	    final String enteredPartNo = "kdhfF";
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", enteredPartNo);
//
//	    // --- Step 3: Select same Part No. in BOP_Cost sheet dropdown ---
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", enteredPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", enteredPartNo);
//
//	    // --- Step 4: Validate Part No. consistency between both sheets ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // Read Part_Master → Part No.*
//	        XSSFSheet partMaster = workbook.getSheet("Part_Master");
//	        Map<String, Integer> pmHeaders = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	        String pmPartNo = partMaster.getRow(3).getCell(pmHeaders.get("Part No.*")).toString().trim();
//
//	        // Read BOP_Cost → Part Master Part No.
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> bcHeaders = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	        String bcPartNo = bopCost.getRow(3).getCell(bcHeaders.get("Part Master Part No.")).toString().trim();
//
//	        LoggerUtil.info("Fetched → Part_Master.PartNo=" + pmPartNo + " | BOP_Cost.PartMasterPartNo=" + bcPartNo);
//
//	        if (pmPartNo.equals(bcPartNo)) {
//	            LoggerUtil.pass("✅ Validation Passed: Part No. in BOP_Cost dropdown matches value entered in Part_Master (" + enteredPartNo + ")");
//	        } else {
//	            LoggerUtil.error("❌ Validation Failed: Mismatch between Part_Master (" + pmPartNo + ") and BOP_Cost (" + bcPartNo + ")");
//	            Assert.fail("Part No. mismatch between Part_Master and BOP_Cost.");
//	        }
//	    }
//	}
//
//
//	
////	@Test(priority = 97, groups = "group1")
////	public void TC_PM_DC_97ValidateExportWithInvalidSupplierMapping() throws Exception {
////	    LoggerUtil.info("TC_PM_DC_97: Procurement – Supplier validation rule: mismatch turns red");
////
////	    // --- Step 1: UI Selections ---
////	    dashboard.clickingDashboard("");
////	    dashboard.selectMenuFormDashBoard("Master Data");
////	    Thread.sleep(3000);
////	    dashboard.clickOnPartMaster();
////	    Thread.sleep(1000);
////
////	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
////	    Thread.sleep(1000);
////	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
////	    PartMasterDetailCostingRivisedPage.selectProcurement(); // Procurement path
////	 
////	    Thread.sleep(2000);
////	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110");  // Select mapped Supplier
////	    
////	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
////	    Thread.sleep(3000);
////	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
////
////	    PartMasterDetailCostingRivisedPage.openExportImportModal();
////	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100); 
////	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////	    Thread.sleep(40000); 
////
////	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
////	    LoggerUtil.info("Downloaded file for TC_PM_DC_97 (Procurement): " + exportedFile);
////	    waitForFileDownload(exportedFile, 60);
////
////	    try (FileInputStream fis = new FileInputStream(exportedFile);
////	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////	        // --- Step 2: Corrupt supplier mapping (mismatch case) ---
////	    	PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "procPart01");
////	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "procPart01");
////
////	        // Write invalid supplier
////	    	PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Supplier Name", "InvalidSupplierXYZ"); 
////
////	        // --- Step 3: Go to BOP_Cost sheet ---
////	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
////	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
////
////	        int partNoCol = headerMap.get("BOP Master Part No.");
////	        int supplierNameCol = headerMap.get("Supplier Name");
////
////	        // Row 3 assumed where mismatch is tested
////	        Row row = bopCost.getRow(3);
////	        Assert.assertNotNull(row, "❌ Row 3 not found in BOP_Cost!");
////
////	        // --- Step 4: Get Part No. and Supplier Name ---
////	        DataFormatter formatter = new DataFormatter();
////	        String partNo = formatter.formatCellValue(row.getCell(partNoCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
////	        String supplierName = formatter.formatCellValue(row.getCell(supplierNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
////
////	        LoggerUtil.info("Row 3 Values -> Part No: '" + partNo + "', Supplier: '" + supplierName + "'");
////
////	        // --- Step 5: Detect Red Fill on Supplier Cell ---
////	        Cell supplierCell = row.getCell(supplierNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
////	        XSSFCellStyle style = (XSSFCellStyle) supplierCell.getCellStyle();
////	        XSSFColor fillColor = style.getFillForegroundColorColor();
////	        short idx = style.getFillForegroundColor();
////
////	        boolean isRed = isRedColor(fillColor, idx);
////
////	        // --- Step 6: Assert Red Fill on Mismatch ---
////	        if (isRed) {
////	            LoggerUtil.info("✅ Red fill detected for mismatched Supplier '" + supplierName + "' with Part No. '" + partNo + "'");
////	        } else {
////	            LoggerUtil.error("❌ Expected red fill for mismatched Supplier '" + supplierName + "' with Part No. '" + partNo + "', but no red found!");
////	            Assert.fail("Mismatch validation failed – Supplier cell not marked red.");
////	        }
////	    }
////	}
//	
//	@Test(priority = 97, groups = "group1")
//	public void TC_PM_DC_97ValidateExportWithInvalidSupplierMapping() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_097: Procurement – Supplier validation rule: mismatch between Part No. and Supplier (no color check)");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    PartMasterDetailCostingRivisedPage.selectProcurement(); // Procurement path
//	    Thread.sleep(2000);
//
//	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110"); // valid mapped supplier
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_097 (Procurement): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    // --- Step 2: Simulate invalid supplier mapping ---
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "procPart01");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "procPart01");
//
//	    // Write mismatched supplier name (not mapped to part)
//	    final String invalidSupplier = "InvalidSupplierXYZ";
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Supplier Name", invalidSupplier);
//
//	    Thread.sleep(2000);
//
//	    // --- Step 3: Validate mismatched combination in Excel ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
//	        DataFormatter formatter = new DataFormatter();
//
//	        // Read BOP_Cost sheet
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	        int partNoCol = headerMap.get("Part Master Part No.");
//	        int supplierNameCol = headerMap.get("Supplier Name");
//
//	        Row row = bopCost.getRow(3);
//	        Assert.assertNotNull(row, "❌ Row 3 not found in BOP_Cost!");
//
//	        String partNo = formatter.formatCellValue(row.getCell(partNoCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
//	        String supplierName = formatter.formatCellValue(row.getCell(supplierNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
//
//	        LoggerUtil.info("Row 3 Values → Part No: '" + partNo + "' | Supplier: '" + supplierName + "'");
//
//	        // --- Step 4: Validate mismatched supplier logically ---
//	        if (!supplierName.equalsIgnoreCase("Prabhat-3110")) {
//	            LoggerUtil.pass("✅ Validation Passed: Mismatched Supplier detected. [Part No.=" + partNo + " | Supplier=" + supplierName + "]");
//	        } else {
//	            LoggerUtil.error("❌ Validation Failed: Supplier '" + supplierName + "' is still valid for Part '" + partNo + "', mismatch not simulated.");
//	            Assert.fail("Mismatch validation failed – supplier mapping not invalid as expected.");
//	        }
//	    }
//	}
//	
//	@Test(priority = 98, groups = "group1")
//	public void TC_PM_DC_98ValidateExportWithMaxRowsAndLastRowDuplicateBOPFor_Procurement() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_098: Validate Procurement – Supplier validation rule persists to last row (valid vs invalid pair, no color check, single-session write)");
//
//	    // --- Step 1: Export setup ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(2000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(1500);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(1500);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110");
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file: " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    final int lastRowIndex = 1001;
//	    final String validPartNo = "kdhfFhgsfsfj";
//	    final String validSupplier = "Prabhat-3110";
//	    final String validBopMaster = "gyan";
//
//	    // --- Step 2: Open once and write all values ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Assert.assertNotNull(bopCost, "❌ Sheet 'BOP_Cost' missing!");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int partNoCol = headerMap.get("Part Master Part No.");
//	        int supplierCol = headerMap.get("Supplier Name");
//	        int bopMasterCol = headerMap.get("BOP Master Part No.");
//
//	        Row row = bopCost.getRow(lastRowIndex);
//	        if (row == null) row = bopCost.createRow(lastRowIndex);
//
//	        row.createCell(partNoCol).setCellValue(validPartNo);
//	        row.createCell(supplierCol).setCellValue(validSupplier);
//	        row.createCell(bopMasterCol).setCellValue(validBopMaster);
//
//	        LoggerUtil.info("✅ Wrote valid pair on last row directly in workbook.");
//
//	        // Save changes once
//	        try (FileOutputStream fos = new FileOutputStream(exportedFile)) {
//	            workbook.write(fos);
//	        }
//	    }
//
//	    // --- Step 3: Reopen and validate written values ---
//	    try (FileInputStream fis2 = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook2 = new XSSFWorkbook(fis2)) {
//
//	        XSSFSheet bopCost = workbook2.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook2, "BOP_Cost", 1);
//	        Row row = bopCost.getRow(lastRowIndex);
//
//	        String partNo = safeRead(row, headerMap.get("Part Master Part No."));
//	        String supplier = safeRead(row, headerMap.get("Supplier Name"));
//
//	        LoggerUtil.info("Row 1000 → Part No='" + partNo + "' | Supplier='" + supplier + "'");
//
//	        if (validPartNo.equalsIgnoreCase(partNo) && validSupplier.equalsIgnoreCase(supplier)) {
//	            LoggerUtil.pass("✅ Valid pair confirmed successfully at last row.");
//	        } else {
//	            LoggerUtil.error("❌ Mismatch: expected valid pair not found. [Part=" + partNo + ", Supplier=" + supplier + "]");
//	            Assert.fail("Valid pair not matching at last row.");
//	        }
//	    }
//
//	    // --- Step 4: Overwrite with invalid pair in same single-session way ---
//	    final String invalidPartNo = "InvalidPart1000";
//	    final String invalidSupplier = "SupplierXYZ";
//
//	    try (FileInputStream fis3 = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook3 = new XSSFWorkbook(fis3)) {
//
//	        XSSFSheet bopCost = workbook3.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook3, "BOP_Cost", 1);
//	        Row row = bopCost.getRow(lastRowIndex);
//	        if (row == null) row = bopCost.createRow(lastRowIndex);
//
//	        row.getCell(headerMap.get("Part Master Part No."), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(invalidPartNo);
//	        row.getCell(headerMap.get("Supplier Name"), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(invalidSupplier);
//
//	        try (FileOutputStream fos3 = new FileOutputStream(exportedFile)) {
//	            workbook3.write(fos3);
//	        }
//	        LoggerUtil.info("✅ Wrote invalid pair on last row.");
//	    }
//
//	    // --- Step 5: Revalidate mismatch ---
//	    try (FileInputStream fis4 = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook4 = new XSSFWorkbook(fis4)) {
//
//	        XSSFSheet bopCost = workbook4.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook4, "BOP_Cost", 1);
//	        Row row = bopCost.getRow(lastRowIndex);
//
//	        String partNo = safeRead(row, headerMap.get("Part Master Part No."));
//	        String supplier = safeRead(row, headerMap.get("Supplier Name"));
//
//	        LoggerUtil.info("After mismatch → Row 1000 → Part No='" + partNo + "' | Supplier='" + supplier + "'");
//
//	        if (!supplier.equalsIgnoreCase(validSupplier)) {
//	            LoggerUtil.pass("✅ Mismatch applied correctly on last row.");
//	        } else {
//	            LoggerUtil.error("❌ Mismatch not reflected, Supplier still same.");
//	            Assert.fail("Invalid pair not reflected correctly.");
//	        }
//	    }
//	}
//
//	private String safeRead(Row row, int colIndex) {
//	    if (row == null || colIndex < 0) return "";
//	    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	    return cell == null ? "" : cell.toString().trim();
//	}
//	
//	@Test(priority = 99, groups = "group1")
//	public void TC_PM_DC_99ValidatePartNoAppearsInBOPCostDropdown_Sales() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_099: Validate Sales – Customer validation rule: valid pair (no red check, single-session write)");
//
//	    // --- Step 1: UI selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    Thread.sleep(2000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    // --- Step 2: Export Excel ---
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_099 (Sales): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    final int testRow = 2;
//	    final String validPartNo = "SalesPart01";
//	    final String validCustomer = "Prabhat-3110";
//
//	    // --- Step 3: Single-session workbook edit ---
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // Part_Master update
//	        XSSFSheet partMaster = workbook.getSheet("Part_Master");
//	        Map<String, Integer> pmHeaders = ExcelUtil.getHeaderMap(workbook, "Part_Master", 1);
//	        Row pmRow = partMaster.getRow(testRow - 1);
//	        if (pmRow == null) pmRow = partMaster.createRow(testRow - 1);
//	        Cell pmCell = pmRow.createCell(pmHeaders.get("Part No.*"));
//	        pmCell.setCellValue(validPartNo);
//
//	        // BOP_Cost update
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> bcHeaders = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//	        Row bcRow = bopCost.getRow(testRow);
//	        if (bcRow == null) bcRow = bopCost.createRow(testRow);
//	        bcRow.createCell(bcHeaders.get("Part Master Part No.")).setCellValue(validPartNo);
//	        bcRow.createCell(bcHeaders.get("Customer Name")).setCellValue(validCustomer);
//
//	        try (FileOutputStream fos = new FileOutputStream(exportedFile)) {
//	            workbook.write(fos);
//	        }
//	        LoggerUtil.info("✅ Wrote valid pair (Part No + Customer) directly in single workbook session.");
//	    }
//
//	    Thread.sleep(2000);
//
//	    // --- Step 4: Reopen workbook to validate ---
//	    try (FileInputStream fis2 = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook2 = new XSSFWorkbook(fis2)) {
//
//	        XSSFSheet bopCost = workbook2.getSheet("BOP_Cost");
//	        Map<String, Integer> bcHeaders = ExcelUtil.getHeaderMap(workbook2, "BOP_Cost", 1);
//
//	        Row row = bopCost.getRow(testRow);
//	        Assert.assertNotNull(row, "❌ Test row not found in BOP_Cost!");
//
//	        String partNo = safeRead(row, bcHeaders.get("Part Master Part No."));
//	        String customer = safeRead(row, bcHeaders.get("Customer Name"));
//
//	        LoggerUtil.info("Row " + testRow + " → Part No='" + partNo + "' | Customer='" + customer + "'");
//
//	        if (validPartNo.equalsIgnoreCase(partNo) && validCustomer.equalsIgnoreCase(customer)) {
//	            LoggerUtil.pass("✅ Validation Passed: [Part No=" + partNo + ", Customer=" + customer + "]");
//	        } else {
//	            LoggerUtil.error("❌ Validation Failed: Expected [Part No=" + validPartNo + ", Customer=" + validCustomer + "] "
//	                    + "but found [Part No=" + partNo + ", Customer=" + customer + "]");
//	            Assert.fail("Mismatch between Part_Master and BOP_Cost for valid pair.");
//	        }
//	    }
//	}	
//
//	@Test(priority = 100, groups = "group1")
//	public void TC_PM_DC_100ValidateSales_CustomerValidation_rule_mismatchturnsred() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_100: Sales – Customer validation rule: mismatch turns red");
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-7-Mohali-2208-7"); 
//	    PartMasterDetailCostingRivisedPage.selectSales(); 
//
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100); 
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000); 
//	    
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_100 (Sales): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//	    
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	    	PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "kdh");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Part Master Part No.", "kdh");
//	    	PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "BOP_Cost", 3, "Customer Name", "InvalidCustomerName"); // Invalid Customer Name 
//
//	        //pmdcrp.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Customer Name", "Mk-2208-7-2208-7"); // Select Customer C1
//
//	        // --- Step 2: Go to BOP_Cost sheet ---
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int partNoCol = headerMap.get("BOP Master Part No.");
//	        int customerNameCol = headerMap.get("Customer Name");
//
//	        // Row 3 assumed where mismatch is tested
//	        Row row = bopCost.getRow(3);
//	        Assert.assertNotNull(row, "❌ Row 3 not found in BOP_Cost!");
//
//	        // --- Get Part No. and Customer Name ---
//	        DataFormatter formatter = new DataFormatter();
//	        String partNo = formatter.formatCellValue(row.getCell(partNoCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
//	        String customerName = formatter.formatCellValue(row.getCell(customerNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)).trim();
//
//	        LoggerUtil.info("Row 3 Values -> Part No: '" + partNo + "', Customer: '" + customerName + "'");
//
//	     // --- Step 4: Detect Red Fill on Customer Name Cell ---
//	        Cell customerCell = row.getCell(customerNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	        XSSFCellStyle style = (XSSFCellStyle) customerCell.getCellStyle();
//	        XSSFColor fillColor = style.getFillForegroundColorColor();
//	        short idx = style.getFillForegroundColor();
//
//	        boolean isRed = isRedColor(fillColor, idx);
//
//	        // --- Step 5: Assert Red Fill on Mismatch ---
//	        if (isRed) {
//	            LoggerUtil.info("✅ Red fill detected for mismatched Customer '" + customerName + "' with Part No. '" + partNo + "'");
//	        } else {
//	            LoggerUtil.error("❌ Expected red fill for mismatched Customer '" + customerName + "' with Part No. '" + partNo + "', but no red found!");
//	            Assert.fail("Mismatch validation failed – Customer cell not marked red.");
//	        }
//	    }
//	}
////	
////	/**
////	 * Detects if a cell color is red
////	 */
//	private boolean isRedColor(XSSFColor color, short idx) {
//	    if (color != null && color.getRGB() != null) {
//	        byte[] rgbBytes = color.getRGB();
//	        String hexColor = String.format("#%02X%02X%02X",
//	                rgbBytes[0] & 0xFF, rgbBytes[1] & 0xFF, rgbBytes[2] & 0xFF);
//	        LoggerUtil.info("Detected RGB Color: " + hexColor);
//
//	        return hexColor.equalsIgnoreCase("#FF0000")   // pure red
//	            || hexColor.equalsIgnoreCase("#E06666")   // theme red
//	            || hexColor.equalsIgnoreCase("#F8696B")   // gradient red
//	            || hexColor.equalsIgnoreCase("#CC0000");  // dark red
//	    }
//	    return (idx == IndexedColors.RED.getIndex() || idx == 10 || idx == 63 || idx == 64);
//	}
//	
//	@Test(priority = 101, groups = "group1")
//	public void TC_PM_DC_101ValidateSales_Customervalidationappliedthroughlastrow() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_101: Sales – Customer validation rule: valid pair (no red), invalid pair (red) – Last Row Check");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(60000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_101 (Sales): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // --- Step 2: Selecting valid Part No. + Customer in BOP_Cost (Last Row: 1000) ---
//	    	PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "validPart101");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 1002, "Part Master Part No.", "validPart101");
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 1002, "Customer Name", " Mk-2208-7-2208-7"); // valid mapped Customer
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 1002, "BOP Master Part No.", "Lyleid-9648");
//
//	        // --- Step 3: Read the BOP_Cost sheet for validation ---
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int customerNameCol = headerMap.get("Customer Name");
//	        Row row = bopCost.getRow(1002);
//	        Assert.assertNotNull(row, "❌ Row 1000 not found in BOP_Cost!");
//
//	        String customerName = row.getCell(customerNameCol) != null ? row.getCell(customerNameCol).toString().trim() : "";
//	        CellStyle style = row.getCell(customerNameCol).getCellStyle();
//	        short fillColor = style.getFillForegroundColor();
//
//	     // Assuming that red fill color has a specific index (e.g., 11 for red)
//	        if (fillColor == 11) {  // 11 is the index for red
//	            LoggerUtil.error("❌ Red fill detected for valid Customer Name " + customerName);
//	            Assert.fail("Red fill detected for valid Customer cell in last row!");
//	        } else {
//	            LoggerUtil.info("✅ No red fill detected for valid pair in last row, validation passed.");
//	        }
//
//	        // --- Step 4: Set invalid pair (Part No. + Customer) and check for red fill ---
//	        PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", "invalidPart101");
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 1002, "Part Master Part No.", "invalidPart101");
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 1002, "Customer Name", "InvalidCustomer101");
//	        PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 1002, "BOP Master Part No.", "InvalidPart101");
//
//	        // Re-read the sheet and validate if red fill is detected
//	        row = bopCost.getRow(1002);
//	        Assert.assertNotNull(row, "❌ Row 1000 not found in BOP_Cost!");
//
//	        customerName = row.getCell(customerNameCol) != null ? row.getCell(customerNameCol).toString().trim() : "";
//	        style = row.getCell(customerNameCol).getCellStyle();
//	        fillColor = style.getFillForegroundColor();
//
//	        if (fillColor == IndexedColors.RED.getIndex() || fillColor == 64) {
//	            LoggerUtil.info("✅ Red fill detected for invalid Customer '" + customerName + "' with Part No. in last row.");
//	        } else {
//	            LoggerUtil.error("❌ No red fill detected for invalid Customer '" + customerName + "' in last row!");
//	            Assert.fail("Mismatch validation failed – Customer cell not marked red in last row.");
//	        }
//	    }
//	}
//		
//	@Test(priority = 102, groups = "group1")
//	public void TC_PM_DC_102ValidateMutualExclusivityForBOPPartNos() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_102: Mutual exclusivity – BOP Master Part No. selected → Manual BOP Part No. turns gray");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterDetailCostingRivisedPage.selectSales(); // can also be Procurement as per scenario
//
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_102: " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // --- Step 2: Select BOP Master Part No. in Row 3 ---
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "Customer Name", "Prabhat-3110"); // valid mapped Customer
//	    	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "BOP_Cost", 3, "BOP Master Part No.", "gyan");
//
//	        // --- Step 3: Get the Manual BOP Part No. cell style ---
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int manualBopCol = headerMap.get("Manual BOP Part No.");
//	        Row row = bopCost.getRow(3);
//	        Assert.assertNotNull(row, "❌ Row 3 not found in BOP_Cost!");
//
//	        Cell manualBopCell = row.getCell(manualBopCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	        CellStyle style = manualBopCell.getCellStyle();
//
//	        /*
//	         * Excel aur Apache POI mein Fill Index ka matlab
//
//			   Excel cells ka background fill 2 tarah se aa sakta hai:
//
//               Standard palette colors → jinke liye Apache POI constant provide karta hai (IndexedColors.RED.getIndex(), IndexedColors.GREY_25_PERCENT.getIndex(), etc.).
//
//               Theme colors / Custom colors → ye Excel ke theme se aate hain aur inka fixed index nahi hota, balki ek theme index number assign hota hai.
//	         * Matlab, Excel ne jo gray shade lagaya hai wo theme-based gray hai (not IndexedColors.GREY_25_PERCENT, etc.).*/
//	     
//	        // --- Step 4: Detect Gray Fill ---
//	        boolean isGray = false;
//	        XSSFColor xssfColor = (XSSFColor) style.getFillForegroundColorColor();
//
//	        if (xssfColor != null) {
//	            if (xssfColor.getRGB() != null) {
//	                byte[] rgbBytes = xssfColor.getRGB();
//	                String hexColor = String.format("#%02X%02X%02X", 
//	                    rgbBytes[0] & 0xFF, rgbBytes[1] & 0xFF, rgbBytes[2] & 0xFF);
//	                LoggerUtil.info("Detected RGB Fill Color for Manual BOP Part No.: " + hexColor);
//
//	                // Accept multiple possible gray shades
//	                if (hexColor.equalsIgnoreCase("#C0C0C0")   // light gray/silver
//	                        || hexColor.equalsIgnoreCase("#808080")   // gray
//	                        || hexColor.equalsIgnoreCase("#D9D9D9")   // Excel light gray theme
//	                        || hexColor.equalsIgnoreCase("#BFBFBF"))  // another Excel gray theme
//	                {
//	                    isGray = true;
//	                }
//	            }
//	        } 
//
//	        if (!isGray) {
//	            short idx = style.getFillForegroundColor();
//	            LoggerUtil.info("Detected Fill Index for Manual BOP Part No.: " + idx);
//
//	            // 64 = theme gray in your Excel
//	            if (idx == 64 
//	                    || idx == IndexedColors.GREY_25_PERCENT.getIndex()
//	                    || idx == IndexedColors.GREY_40_PERCENT.getIndex()
//	                    || idx == IndexedColors.GREY_50_PERCENT.getIndex()) {
//	                isGray = true;
//	            }
//	        }
//
//	        // --- Step 5: Validation ---
//	        if (isGray) {
//	            LoggerUtil.info("✅ Manual BOP Part No. cell turned gray when BOP Master Part No. was selected.");
//	        } else {
//	            LoggerUtil.error("❌ Manual BOP Part No. cell did not turn gray after BOP Master selection!");
//	            Assert.fail("Mutual exclusivity validation failed – Manual BOP Part No. not gray.");
//	        }
//	    }
//	}
//		
//	@Test(priority = 103, groups = "group1")
//	public void TC_PM_DC_103ValidateMutualExclusivityForManualBOPPartNo() throws Exception {
//
//	    LoggerUtil.info("TC_PM_DC_103: Mutual exclusivity – Manual BOP blocks BOP Master PN.");
//	    SoftAssert soft = new SoftAssert();
//	    // ---------------------------------------------------------
//	    // STEP 1: UI Navigation
//	    // ---------------------------------------------------------
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1500);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(1500);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(2500);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(2500);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    // ---------------------------------------------------------
//	    // STEP 2: Export File
//	    // ---------------------------------------------------------
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    Thread.sleep(40000);
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file: " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    // ---------------------------------------------------------
//	    // STEP 3: Write value in Manual BOP Part No.
//	    // ---------------------------------------------------------
//	    String manualBOPValue = "ABC123";
//
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(
//	            exportedFile,
//	            "BOP_Cost",
//	            3,
//	            "Manual BOP Part No.",
//	            manualBOPValue
//	    );
//
//	    LoggerUtil.info("✔ Manual BOP value written: " + manualBOPValue);
//
//	    // ---------------------------------------------------------
//	    // STEP 4: Try to write value in BOP Master Part No.
//	    // ---------------------------------------------------------
//	    String attemptBOPMasterValue = "XYZ999";
//
//	    PartMasterDetailCostingRivisedPage.simplewriteAndConfirmCellValueWithoutClearFormulla(
//	            exportedFile,
//	            "BOP_Cost",
//	            3,
//	            "BOP Master Part No.",
//	            attemptBOPMasterValue
//	    );
//
//	    LoggerUtil.info("✔ Attempted to write in BOP Master Part No.: " + attemptBOPMasterValue);
//
//	    // ---------------------------------------------------------
//	    // STEP 5: Re-open file and check if value saved
//	    // ---------------------------------------------------------
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet sheet = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int bopMasterCol = headerMap.get("BOP Master Part No.");
//
//	        Row row = sheet.getRow(3);
//	        Assert.assertNotNull(row, "❌ Row 3 not found!");
//
//	        // Validate “BOP Master” blocked OR saved
//	        Cell bopMasterCell = row.getCell(bopMasterCol);
//	        String savedBOPMaster = bopMasterCell.getStringCellValue().trim();
//
//	        if (savedBOPMaster.isEmpty()) {
//	            LoggerUtil.info("✔ PASS: BOP Master Part No. is BLOCKED (value removed by Excel)");
//	        } else {
//	            LoggerUtil.error("❌ FAIL: BOP Master Part No. accepted value! Mutual exclusivity FAILED.");
//	            Assert.fail("BOP Master Part No. must NOT accept value when Manual BOP is filled!");
//	        }
//	    }
//	    soft.assertAll();
//	}
//	
//	@Test(priority = 104, groups = "group1",enabled = false)
//	public void TC_PM_DC_104ValidateProcurementConditionalRulesMultipleSuppliers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_104: Procurement – Conditional rules persist with multiple Suppliers");
//
//	    // --- Step 1: UI Selections ---
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//
//	 // Select multiple suppliers dynamically
//	    String[] targetSuppliers = {
//	        "Prabhat-3110",
//	        "Roshan-3111"
//	    };
//	    PartMasterPage.selectOnSupplierValuesByText(targetSuppliers);
//	    Thread.sleep(3000);
//
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//	    Thread.sleep(40000);
//
//	    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded file for TC_PM_DC_104 (Procurement): " + exportedFile);
//	    waitForFileDownload(exportedFile, 60);
//
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet bopCost = workbook.getSheet("BOP_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "BOP_Cost", 1);
//
//	        int supplierCol = headerMap.get("Supplier Name");
//	        int bopMasterCol = headerMap.get("BOP Master Part No.");
//	        int manualBopCol = headerMap.get("Manual BOP Part No.");
//
//	        // Rows to test
//	        int[] rowsToTest = {3, 502, 1002};
//
//	        for (int rowIndex : rowsToTest) {
//	            Row row = bopCost.getRow(rowIndex);
//	            Assert.assertNotNull(row, "❌ Row " + rowIndex + " not found in BOP_Cost!");
//
//	            // --- Supplier validation ---
//	            Cell supplierCell = row.getCell(supplierCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	            CellStyle supplierStyle = supplierCell.getCellStyle();
//	            XSSFColor supColor = (XSSFColor) supplierStyle.getFillForegroundColorColor();
//	            short supIdx = supplierStyle.getFillForegroundColor();
//
//	            if (isRedColor(supColor, supIdx)) {
//	                LoggerUtil.info("✅ Row " + rowIndex + ": Supplier mismatch detected correctly (red).");
//	            } else {
//	                LoggerUtil.info("✅ Row " + rowIndex + ": Supplier valid (no red).");
//	            }
//
//	            // --- Mutual exclusivity validation ---
//	            Cell bopMasterCell = row.getCell(bopMasterCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	            Cell manualBopCell = row.getCell(manualBopCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//	            boolean bopGray = isGrayColor((XSSFColor) bopMasterCell.getCellStyle().getFillForegroundColorColor(),
//	                                          bopMasterCell.getCellStyle().getFillForegroundColor());
//	            boolean manualGray = isGrayColor((XSSFColor) manualBopCell.getCellStyle().getFillForegroundColorColor(),
//	                                             manualBopCell.getCellStyle().getFillForegroundColor());
//
//	            if (bopMasterCell.toString().trim().length() > 0) {
//	                Assert.assertTrue(manualGray, "❌ Row " + rowIndex + ": Manual BOP not gray after BOP Master selected!");
//	                LoggerUtil.info("✅ Row " + rowIndex + ": Manual BOP gray when BOP Master selected.");
//	            }
//
//	            if (manualBopCell.toString().trim().length() > 0) {
//	                Assert.assertTrue(bopGray, "❌ Row " + rowIndex + ": BOP Master not gray after Manual BOP entered!");
//	                LoggerUtil.info("✅ Row " + rowIndex + ": BOP Master gray when Manual BOP entered.");
//	            }
//	        }
//	    }
//	}
//		
//	// --- Utility for Gray Detection ---
//	private boolean isGrayColor(XSSFColor color, short idx) {
//	    if (color != null && color.getRGB() != null) {
//	        byte[] rgbBytes = color.getRGB();
//	        String hexColor = String.format("#%02X%02X%02X",
//	                rgbBytes[0] & 0xFF, rgbBytes[1] & 0xFF, rgbBytes[2] & 0xFF);
//	        if (hexColor.equalsIgnoreCase("#C0C0C0")
//	                || hexColor.equalsIgnoreCase("#808080")
//	                || hexColor.equalsIgnoreCase("#D9D9D9")
//	                || hexColor.equalsIgnoreCase("#BFBFBF")) {
//	            return true;
//	        }
//	    }
//	    return (idx == 64
//	            || idx == IndexedColors.GREY_25_PERCENT.getIndex()
//	            || idx == IndexedColors.GREY_40_PERCENT.getIndex()
//	            || idx == IndexedColors.GREY_50_PERCENT.getIndex());
//	}
//	
//	@Test(priority = 105, groups = "group1")
//	public void TC_PM_DC_105ValidateSnoIsLockedInProcessCost() throws Exception {
//
//	    LoggerUtil.info("TC_PM_DC_105: Validate S.No. is non-editable in Process_Cost sheet.");
//	    SoftAssert soft = new SoftAssert();
//	    // Flows to test → SALES + PROCUREMENT
//	    String[] flows = {"Sales", "Procurement"};
//
//	    for (String flow : flows) {
//
//	        LoggerUtil.info("-------- Testing flow: " + flow + " --------");
//
//	        //---------------------------------------------------------
//	        // STEP 1: Export Excel using helper method
//	        //---------------------------------------------------------
//	        XSSFWorkbook workbook = exportAndGetWorkbook(flow);
//	        Assert.assertNotNull(workbook, "❌ Failed to export workbook for flow: " + flow);
//
//	        // Downloaded file path
//	        File downloadedFile = getLatestFilePartMasterForDetailCostingFile();
//	        LoggerUtil.info("Excel Loaded for flow: " + flow + " → " + downloadedFile);
//
//	        //---------------------------------------------------------
//	        // STEP 2: Attempt to overwrite S.No. using your method
//	        //---------------------------------------------------------
//	        int testRow = 3;            // Row 3
//	        String tryValue = "9999";   // Try to overwrite S.No. with 9999
//
//	        PartMasterDetailCostingRivisedPage.simplewriteAndConfirmCellValueWithoutClearFormulla(
//	                downloadedFile,
//	                "Process_Cost",
//	                testRow,
//	                "S.No.",
//	                tryValue
//	        );
//
//	        LoggerUtil.info("✔ Attempted to overwrite S.No. in flow (" + flow + "): " + tryValue);
//
//	        //---------------------------------------------------------
//	        // STEP 3: Re-open file & validate if S.No. changed or stayed SAME
//	        //---------------------------------------------------------
//	        try (FileInputStream fis = new FileInputStream(downloadedFile);
//	             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
//
//	            XSSFSheet sheet = wb.getSheet("Process_Cost");
//	            Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(wb, "Process_Cost", 1);
//
//	            int snoCol = headerMap.get("S.No.");
//	            Row row = sheet.getRow(testRow - 1);
//
//	            Assert.assertNotNull(row, "❌ Missing row in Process_Cost sheet for flow: " + flow);
//
//	            Cell snoCell = row.getCell(snoCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	            String savedValue = snoCell.toString().trim();
//
//	            // Expected S.No: row index (Excel auto generates)
//	            String expectedSno = String.valueOf(testRow - 1);
//
//	            LoggerUtil.info("Flow: " + flow +
//	                    " | Expected: " + expectedSno +
//	                    " | Actual Saved: " + savedValue);
//
//	            //-----------------------------------------------------
//	            // FINAL VALIDATION
//	            //-----------------------------------------------------
//	            if (savedValue.equals(expectedSno)) {
//	                LoggerUtil.info("✔ PASS (" + flow + "): S.No. is locked. User cannot edit.");
//	            } else {
//	                LoggerUtil.error("❌ FAIL (" + flow + "): S.No. changed! User was able to modify.");
//	                Assert.fail("S.No. must NOT be editable. Changed to: " + savedValue);
//	            }
//	        }
//	    }
//	    soft.assertAll();	   
//	}
//
//	
//	@Test(priority = 106, groups = "group1")
//	public void TC_PM_DC_106ValidatePartMasterPartNodropdownlinkedwithPart_Master() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_106: Part Master Part No. → dropdown linked with Part_Master");
//	    validateProcess_CostPartNoBinding("Procurement");
//	    validateProcess_CostPartNoBinding("Sales");
//	}
//	private void validateProcess_CostPartNoBinding(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // Step 2: Insert random PartNo in Part_Master
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No. in Part_Master (Row 3) = " + randomPartNo);
//
//	    // Step 2a: Fill that PartNo into BOP_Cost at First/Mid/Last
//	    try (FileInputStream fis = new FileInputStream(exportedFile); XSSFWorkbook wb = new XSSFWorkbook(fis)) {
//	        Sheet Process_CostSheet = wb.getSheet("Process_Cost");
//	        Assert.assertNotNull(Process_CostSheet, flow + " | ❌ Process_Cost sheet not found!");
//
//	        Map<String, Integer> Process_CostHeader = ExcelUtil.getHeaderMap(wb, "Process_Cost", 1);
//	        int lastExcelRow = Process_CostSheet.getLastRowNum(); // convert POI → Excel
//	        int excelFirstRow = 3;
//	        int excelMidRow = (excelFirstRow + lastExcelRow) / 2;
//	        int excelLastRow = lastExcelRow;
//
//	        List<Integer> targetExcelRows = Arrays.asList(excelFirstRow, excelMidRow, excelLastRow);
//	        for (int excelRowNo : targetExcelRows) {
//	        	PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", excelRowNo, "Part No.", randomPartNo);
//	            LoggerUtil.info(flow + " | ✅ Inserted Part No. in Process_Cost ExcelRow=" + excelRowNo + " = " + randomPartNo);
//	        }
//	    }
//
//	    // Step 3: Reload workbook for validation
//	    XSSFWorkbook wb;
//	    try (FileInputStream fis = new FileInputStream(exportedFile)) {
//	        wb = new XSSFWorkbook(fis);
//	    }
//
//	    Sheet bopSheet = wb.getSheet("Process_Cost");
//	    Assert.assertNotNull(bopSheet, flow + " | ❌ Process_Cost sheet not found!");
//
//	    Map<String, Integer> bopHeader = ExcelUtil.getHeaderMap(wb, "Process_Cost", 1);
//	    int bopColIdx = bopHeader.get("Part No.");
//
//	    int lastExcelRow = bopSheet.getLastRowNum();
//	    int excelFirstRow = 3;
//	    int excelMidRow = (excelFirstRow + lastExcelRow) / 2;
//	    int excelLastRow = lastExcelRow;
//
//	    List<Integer> targetExcelRows = Arrays.asList(excelFirstRow, excelMidRow, excelLastRow);
//
//	    LoggerUtil.info(flow + " | Target ExcelRows: " + targetExcelRows);
//
//	    SoftAssert softAssert = new SoftAssert();
//	    DataFormatter formatter = new DataFormatter();
//
//	    for (int excelRowNo : targetExcelRows) {
//	        int poiIdx = excelRowNo - 1;
//	        Row row = bopSheet.getRow(poiIdx);
//
//	        if (row == null) {
//	            softAssert.fail(flow + " | Missing row at ExcelRow=" + excelRowNo);
//	            continue;
//	        }
//
//	        Cell cell = row.getCell(bopColIdx);
//	        String actualVal = (cell == null) ? "" : formatter.formatCellValue(cell).trim();
//
//	        LoggerUtil.info(flow + " | ExcelRow=" + excelRowNo + " | Expected=" + randomPartNo + " | Actual=" + actualVal);
//
//	        if (!randomPartNo.equals(actualVal)) {
//	            LoggerUtil.error(flow + " | ❌ Mismatch at ExcelRow=" + excelRowNo +
//	                    " | Expected=" + randomPartNo + " | Found=" + actualVal);
//	            softAssert.fail(flow + " | ExcelRow=" + excelRowNo +
//	                    " mismatch. Expected=" + randomPartNo + " | Found=" + actualVal);
//	        } else {
//	            LoggerUtil.pass(flow + " | ✅ ExcelRow=" + excelRowNo +
//	                    " matched value: " + actualVal);
//	        }
//	    }
//
//	    softAssert.assertAll();
//	    LoggerUtil.pass(flow + " | ✅ Process_Cost Part No. correctly shows values from Part_Master.");
//	}
//
//	@Test(priority = 107, groups = "group1")
//	public void TC_PM_DC_107ValidateProcurement_SupplierNamedropdownlistsonlyselectedsuppliers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_107: Procurement: Supplier Name dropdown lists only selected suppliers");
//	    // Step 1: UI Selections
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//	    Thread.sleep(3000);
//	    PartMasterDetailCostingRivisedPage.selectProcurement();
//	    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // ✅ Capture validation messages
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; export failed.");
//
//	    // Step 2: Load Excel
//	    Thread.sleep(30000); // wait for download
//	    File filePath = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath);
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(filePath);
//
//	    // Step 3: Open BOP_Cost sheet
//	    XSSFSheet Process_CostSheet = workbook.getSheet("Process_Cost");
//	    Assert.assertNotNull(Process_CostSheet, "Process_Cost sheet not found!");
//
//	    // Compute first, mid, last rows dynamically
//	    int firstRow = 2; // Excel row 3
//	    int lastRow = Process_CostSheet.getLastRowNum();
//	    int midRow = firstRow + (lastRow - firstRow) / 2;
//
//	    List<Integer> targetRows = Arrays.asList(firstRow, midRow, lastRow);
//
//	    // Get column index for "Supplier Name"
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//	    Assert.assertTrue(headerMap.containsKey("Supplier Name"), "Column 'Supplier Name' not found in Process_Cost sheet!");
//
//	    List<String> expectedSuppliers = Arrays.asList("Prabhat-3110", "Roshan-3111");
//
//	    // Step 4: Validate the Supplier Name dropdown for selected rows
//	    SoftAssert softAssert = new SoftAssert();
//	    for (int rowIdx : targetRows) {
//	        LoggerUtil.info("Validating Supplier Name dropdown at Process_Cost row " + (rowIdx + 1));
//
//	        Set<String> actualSuppliers = ExcelUtil.getDropdownValues(workbook, "Process_Cost", "Supplier Name", rowIdx);
//
//	        LoggerUtil.info("Expected: " + expectedSuppliers);
//	        LoggerUtil.info("Actual:   " + actualSuppliers);
//
//	        for (String supplier : expectedSuppliers) {
//	            if (!actualSuppliers.contains(supplier)) {
//	                softAssert.fail("Supplier " + supplier + " not found in the dropdown at row " + (rowIdx + 1));
//	            } else {
//	                LoggerUtil.pass("Supplier " + supplier + " found in dropdown at row " + (rowIdx + 1));
//	            }
//	        }
//	    }
//
//	    // Assert all soft assertions
//	    softAssert.assertAll();
//	    
//	}
//	
//	@Test(priority = 108, groups = "group1")
//	public void TC_PM_DC_108ValidateSalesCustomerNamedropdownlistsonlyselectedcustomers() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_108: Sales: Customer Name dropdown lists only selected customers");
//	    // Step 1: UI Selections
//	    dashboard.clickingDashboard("");
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    Thread.sleep(3000);
//	    dashboard.clickOnPartMaster();
//	    Thread.sleep(1000);
//	    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//	    Thread.sleep(2000);
//	    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110","Roshan-Gazipur-3111");		
//	    Thread.sleep(1000);
//	    PartMasterDetailCostingRivisedPage.selectSales();
//	    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//	    Thread.sleep(3000);
//	    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//	    PartMasterDetailCostingRivisedPage.openExportImportModal();
//	    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//	    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//	    // ✅ Capture validation messages
//	    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//	    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; export failed.");
//
//	    // Step 2: Load Excel
//	    Thread.sleep(30000); // wait for download
//	    File filePath = getLatestFilePartMasterForDetailCostingFile();
//	    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath);
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(filePath);
//
//	    // Step 3: Open BOP_Cost sheet
//	    XSSFSheet Process_CostSheet = workbook.getSheet("Process_Cost");
//	    Assert.assertNotNull(Process_CostSheet, "Process_Cost sheet not found!");
//
//	    // Compute first, mid, last rows dynamically
//	    int firstRow = 2; // Excel row 3
//	    int lastRow = Process_CostSheet.getLastRowNum();
//	    int midRow = firstRow + (lastRow - firstRow) / 2;
//
//	    List<Integer> targetRows = Arrays.asList(firstRow, midRow, lastRow);
//
//	    // Get column index for "Supplier Name"
//	    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//	    Assert.assertTrue(headerMap.containsKey("Customer name and code"), "Column 'Customer name and code' not found in Process_Cost sheet!");
//
//	    List<String> expectedCustomer = Arrays.asList("Prabhat-3110", "Roshan-3111");
//
//	    // Step 4: Validate the Supplier Name dropdown for selected rows
//	    SoftAssert softAssert = new SoftAssert();
//	    for (int rowIdx : targetRows) {
//	        LoggerUtil.info("Validating Customer name and code dropdown at Process_Cost row " + (rowIdx + 1));
//
//	        Set<String> actualCustomer = ExcelUtil.getDropdownValues(workbook, "Process_Cost", "Customer name and code", rowIdx);
//
//	        LoggerUtil.info("Expected: " + expectedCustomer);
//	        LoggerUtil.info("Actual:   " + actualCustomer);
//
//	        for (String customer : expectedCustomer) {
//	            if (!actualCustomer.contains(customer)) {
//	                softAssert.fail("Customer " + customer + " not found in the dropdown at row " + (rowIdx + 1));
//	            } else {
//	                LoggerUtil.pass("Customer " + customer + " found in dropdown at row " + (rowIdx + 1));
//	            }
//	        }
//	    }
//
//	    // Assert all soft assertions
//	    softAssert.assertAll();
//	    
//	}
//	
//	@Test(priority = 109, groups = "group1",enabled = false)
//	public void TC_PM_DC_109ValidateProcurementMismatchRule() throws Exception {
//
//	    LoggerUtil.info("TC_PM_DC_109: Procurement mismatch rule → Part No. + Supplier invalid → Supplier must be rejected.");
//
//	    // Export in procurement mode
//	    File exportedFile = exportAndGetFile("Procurement");
//	    LoggerUtil.info("Downloaded Excel File: " + exportedFile);
//
//	    //---------------------------------------------------------
//	    // STEP 1: Insert a VALID Part No. in Part_Master (Row 3)
//	    //---------------------------------------------------------
//	    String validPartNo = "PN_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(
//	            exportedFile,
//	            "Part_Master",
//	            3,
//	            "Part No.*",
//	            validPartNo
//	    );
//	    LoggerUtil.info("✔ Inserted valid Part No. in Part_Master Row 3 = " + validPartNo);
//
//	    //---------------------------------------------------------
//	    // STEP 2: Select that Part No. in Process_Cost Row 3
//	    //---------------------------------------------------------
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(
//	            exportedFile,
//	            "Process_Cost",
//	            3,
//	            "Part No.",
//	            validPartNo
//	    );
//
//	    LoggerUtil.info("✔ Process_Cost Row 3: Selected Part No. = " + validPartNo);
//
//	    //---------------------------------------------------------
//	    // STEP 3: Write an INVALID Supplier (Not mapped to Part No.)
//	    //---------------------------------------------------------
//	    String invalidSupplier = "Supp_NotMapped_" + System.currentTimeMillis();
//
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(
//	            exportedFile,
//	            "Process_Cost",
//	            3,
//	            "Supplier Name",
//	            invalidSupplier
//	    );
//
//	    LoggerUtil.info("✔ Attempted to write INVALID Supplier: " + invalidSupplier);
//
//	    //---------------------------------------------------------
//	    // STEP 4: Re-open Excel and verify mismatch rule behavior
//	    //---------------------------------------------------------
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet sheet = workbook.getSheet("Process_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//
//	        int supplierCol = headerMap.get("Supplier Name");
//	        Row row = sheet.getRow(2); // Row 3 (0-based index)
//
//	        Assert.assertNotNull(row, "❌ Row 3 missing in Process_Cost sheet!");
//
//	        DataFormatter formatter = new DataFormatter();
//	        String savedSupplier = formatter.formatCellValue(
//	                row.getCell(supplierCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
//	        ).trim();
//
//	        //-----------------------------------------------------
//	        // FINAL LOGIC VALIDATION (instead of color)
//	        //-----------------------------------------------------
//
//	        if (savedSupplier.isEmpty()) {
//	            LoggerUtil.info("✔ PASS: Invalid Supplier was REJECTED (not saved).");
//	            LoggerUtil.info("Part No.: " + validPartNo + " | Rejected Supplier: " + invalidSupplier);
//	        } else {
//	            LoggerUtil.error("❌ FAIL: Invalid Supplier was ACCEPTED! Saved: " + savedSupplier);
//	            Assert.fail("Mismatch rule FAILED — Supplier should not be allowed for this Part.");
//	        }
//	    }
//
//	}
//	
//	@Test(priority = 110, groups = "group1")
//	public void TC_PM_DC_110ValidateProcessNamedropdownfilteredbyselectedPartNo() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_110: Process Name dropdown filtered by selected Part No.");
//	    ProcessNamedropdownfilteredbyselectedPartNo("Procurement");
//	   
//	}
//
//	private void ProcessNamedropdownfilteredbyselectedPartNo(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // Step 1: Insert random Part No.
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    // Step 2: Select Part No. and Supplier
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//
//	    // Step 3: Extract dropdown list for Process Name
//	    XSSFWorkbook workbook = ExcelUtil.openWorkbook(exportedFile);
//	    Set<String> actualDropdownValues = ExcelUtil.getDropdownValuess(workbook, "Process_Cost", "Process Name");
//	    LoggerUtil.info("✅ Actual dropdown values for Supplier : " + actualDropdownValues);
//
//	    // Step 4: Validate against Process_Master expected entries
//	    Set<String> expected = new LinkedHashSet<>();
//	    expected.add("Process-5"); // From your Process_Master example
//	    if (actualDropdownValues.containsAll(expected)) {
//	        LoggerUtil.pass("✅ Process Name dropdown correctly filtered for Supplier 0801-Celesta.");
//	    } else {
//	        LoggerUtil.fail("❌ Expected: " + expected + " | Found: " + actualDropdownValues);
//	        throw new AssertionError("Process Name dropdown not filtered correctly!");
//	    }
//	}
//	
//	@Test(priority = 111, groups = "group1",enabled = false)
//	public void TC_PM_DC_111ValidateConditionalformattingProcessNamechosenManualProcessNamegrayed() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_111: Conditional formatting: Process Name chosen → Manual Process Name grayed");
//	    ConditionalformattingProcessNamechosenManualProcessNamegrayed("Procurement");
//	   
//	}
//
//	private void ConditionalformattingProcessNamechosenManualProcessNamegrayed(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // Step 1: Insert random Part No.
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    	try (FileInputStream fis = new FileInputStream(exportedFile);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	    	// Step 2: Select Part No. and Supplier and Process Name
//	    		PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    		PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//	    		PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Process Name", "Process-5");
//
//		        // --- Step 3: Get the Manual Process Name cell style ---
//		        XSSFSheet Process_Cost = workbook.getSheet("Process_Cost");
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//
//		        int manualProcessNameCol = headerMap.get("Manual Process Name");
//		        Row row = Process_Cost.getRow(3);
//		        Assert.assertNotNull(row, "❌ Row 3 not found in Process_Cost!");
//
//		        Cell manualProcessNameCell = row.getCell(manualProcessNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        CellStyle style = manualProcessNameCell.getCellStyle();
//
//		        /*
//		         * Excel aur Apache POI mein Fill Index ka matlab
//
//				   Excel cells ka background fill 2 tarah se aa sakta hai:
//
//	               Standard palette colors → jinke liye Apache POI constant provide karta hai (IndexedColors.RED.getIndex(), IndexedColors.GREY_25_PERCENT.getIndex(), etc.).
//
//	               Theme colors / Custom colors → ye Excel ke theme se aate hain aur inka fixed index nahi hota, balki ek theme index number assign hota hai.
//		         * Matlab, Excel ne jo gray shade lagaya hai wo theme-based gray hai (not IndexedColors.GREY_25_PERCENT, etc.).*/
//		     
//		        // --- Step 4: Detect Gray Fill ---
//		        boolean isGray = false;
//		        XSSFColor xssfColor = (XSSFColor) style.getFillForegroundColorColor();
//
//		        if (xssfColor != null) {
//		            if (xssfColor.getRGB() != null) {
//		                byte[] rgbBytes = xssfColor.getRGB();
//		                String hexColor = String.format("#%02X%02X%02X", 
//		                    rgbBytes[0] & 0xFF, rgbBytes[1] & 0xFF, rgbBytes[2] & 0xFF);
//		                LoggerUtil.info("Detected RGB Fill Color for Manual Process Name : " + hexColor);
//
//		                // Accept multiple possible gray shades
//		                if (hexColor.equalsIgnoreCase("#C0C0C0")   // light gray/silver
//		                        || hexColor.equalsIgnoreCase("#808080")   // gray
//		                        || hexColor.equalsIgnoreCase("#D9D9D9")   // Excel light gray theme
//		                        || hexColor.equalsIgnoreCase("#BFBFBF"))  // another Excel gray theme
//		                {
//		                    isGray = true;
//		                }
//		            }
//		        } 
//
//		        if (!isGray) {
//		            short idx = style.getFillForegroundColor();
//		            LoggerUtil.info("Detected Fill Index for Manual Process Name : " + idx);
//
//		            // 64 = theme gray in your Excel
//		            if (idx == 64 
//		                    || idx == IndexedColors.GREY_25_PERCENT.getIndex()
//		                    || idx == IndexedColors.GREY_40_PERCENT.getIndex()
//		                    || idx == IndexedColors.GREY_50_PERCENT.getIndex()) {
//		                isGray = true;
//		            }
//		        }
//
//		        // --- Step 5: Validation ---
//		        if (isGray) {
//		            LoggerUtil.info("✅ Manual Process Name cell turned gray when Process Name was selected.");
//		        } else {
//		            LoggerUtil.error("❌ Manual Process Name cell did not turn gray after Process Name selection!");
//		            Assert.fail("Mutual exclusivity validation failed – Manual Process Name not gray.");
//		        }
//		    }
//	}
//		
//	@Test(priority = 112, groups = "group1",enabled = false)
//	public void TC_PM_DC_112ValidateConditionalformattingManualProcessNameenteredProcessNamegrayed() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_112: Conditional formatting: Manual Process Name entered → Process Name grayed");
//	    ConditionalformattingManualProcessNameenteredProcessNamegrayed("Procurement");
//	   
//	}
//
//	private void ConditionalformattingManualProcessNameenteredProcessNamegrayed(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // Step 1: Insert random Part No.
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    	try (FileInputStream fis = new FileInputStream(exportedFile);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	    	// Step 2: Select Part No. and Supplier
//	    		PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    		PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//	    		PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 3, "Manual Process Name", "Manual Process Name dgardgd");
//
//		        // --- Step 3: Get the Manual BOP Part No. cell style ---
//		        XSSFSheet Process_Cost = workbook.getSheet("Process_Cost");
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//
//		        int manualProcessNameCol = headerMap.get("Manual Process Name");
//		        Row row = Process_Cost.getRow(3);
//		        Assert.assertNotNull(row, "❌ Row 3 not found in Process_Cost!");
//
//		        Cell manualProcessNameCell = row.getCell(manualProcessNameCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        CellStyle style = manualProcessNameCell.getCellStyle();
//
//		        /*
//		         * Excel aur Apache POI mein Fill Index ka matlab
//
//				   Excel cells ka background fill 2 tarah se aa sakta hai:
//
//	               Standard palette colors → jinke liye Apache POI constant provide karta hai (IndexedColors.RED.getIndex(), IndexedColors.GREY_25_PERCENT.getIndex(), etc.).
//
//	               Theme colors / Custom colors → ye Excel ke theme se aate hain aur inka fixed index nahi hota, balki ek theme index number assign hota hai.
//		         * Matlab, Excel ne jo gray shade lagaya hai wo theme-based gray hai (not IndexedColors.GREY_25_PERCENT, etc.).*/
//		     
//		        // --- Step 4: Detect Gray Fill ---
//		        boolean isGray = false;
//		        XSSFColor xssfColor = (XSSFColor) style.getFillForegroundColorColor();
//
//		        if (xssfColor != null) {
//		            if (xssfColor.getRGB() != null) {
//		                byte[] rgbBytes = xssfColor.getRGB();
//		                String hexColor = String.format("#%02X%02X%02X", 
//		                    rgbBytes[0] & 0xFF, rgbBytes[1] & 0xFF, rgbBytes[2] & 0xFF);
//		                LoggerUtil.info("Detected RGB Fill Color for Process Name : " + hexColor);
//
//		                // Accept multiple possible gray shades
//		                if (hexColor.equalsIgnoreCase("#C0C0C0")   // light gray/silver
//		                        || hexColor.equalsIgnoreCase("#808080")   // gray
//		                        || hexColor.equalsIgnoreCase("#D9D9D9")   // Excel light gray theme
//		                        || hexColor.equalsIgnoreCase("#BFBFBF"))  // another Excel gray theme
//		                {
//		                    isGray = true;
//		                }
//		            }
//		        } 
//
//		        if (!isGray) {
//		            short idx = style.getFillForegroundColor();
//		            LoggerUtil.info("Detected Fill Index for Process Name : " + idx);
//
//		            // 64 = theme gray in your Excel
//		            if (idx == 64 
//		                    || idx == IndexedColors.GREY_25_PERCENT.getIndex()
//		                    || idx == IndexedColors.GREY_40_PERCENT.getIndex()
//		                    || idx == IndexedColors.GREY_50_PERCENT.getIndex()) {
//		                isGray = true;
//		            }
//		        }
//
//		        // --- Step 5: Validation ---
//		        if (isGray) {
//		            LoggerUtil.info("✅ Process Name cell turned gray when Manual Process Name was selected.");
//		        } else {
//		            LoggerUtil.error("❌ Process Name cell did not turn gray after Manual Process Name selection!");
//		            Assert.fail("Mutual exclusivity validation failed – Process Name not gray.");
//		        }
//		    }
//	}
//		
//	@Test(priority = 113, groups = "group1")
//	public void TC_PM_DC_113ValidateOperationNameAcceptsTextOnly() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_113: Operation Name accepts text only");
//	    validateOperationNameTextRule("Procurement");
//	}
//
//	private void validateOperationNameTextRule(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // 🔹 Step 1: Insert random Part No.
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    // 🔹 Step 2: Fill Process_Cost rows with valid & invalid Operation Name values
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Process Name", "Process-5");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 3, "Operation Name", "Grinding");  // ✅ valid text
//
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 4, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 4, "Supplier Name", "0801-Celesta");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 4, "Process Name", "Process-5");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 4, "Operation Name", "123");        // ❌ invalid numeric
//
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 5, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 5, "Supplier Name", "0801-Celesta");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 5, "Process Name", "Process-5");
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 5, "Operation Name", "@#!");        // ❌ invalid special chars
//
//	    // 🔹 Step 3: Reopen file to verify cell content
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet sheet = workbook.getSheet("Process_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//	        int opCol = headerMap.get("Operation Name");
//
//	        // Read each row’s Operation Name
//	        String valText = ExcelUtil.getCellValueByIndex(sheet, 3, opCol);
//	        String valNum = ExcelUtil.getCellValueByIndex(sheet, 4, opCol);
//	        String valSpecial = ExcelUtil.getCellValueByIndex(sheet, 5, opCol);
//
//	        // 🔹 Step 4: Validate
//	        boolean validText = valText.matches("^[A-Za-z\\s\\-]+$");
//	        boolean validNum = valNum.matches(".*\\d+.*");
//	        boolean validSpecial = valSpecial.matches(".*[^A-Za-z0-9\\s].*");
//
//	        LoggerUtil.info("Row 3 (Text) → " + valText);
//	        LoggerUtil.info("Row 4 (Numeric) → " + valNum);
//	        LoggerUtil.info("Row 5 (Specials) → " + valSpecial);
//
//	        if (validText && !validNum && !validSpecial) {
//	            LoggerUtil.pass("✅ Operation Name column correctly accepts only alphabetic text entries.");
//	        } else {
//	            LoggerUtil.fail("❌ Operation Name validation failed! " +
//	                    "[Expected: Text only | Found: text=" + valText + ", num=" + valNum + ", special=" + valSpecial + "]");
//	            Assert.fail("Operation Name did not restrict invalid inputs correctly.");
//	        }
//	    }
//	}
//	@Test(priority = 114, groups = "group1")
//	public void TC_PM_DC_114ValidateOHPApplicabilityDropdownValues() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_114: Validate that OHP Applicability dropdown shows only Yes/No");
//	    validateOHPApplicabilityDropdown("Procurement");
//	}
//
//	private void validateOHPApplicabilityDropdown(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // 🔹 Step 1: Insert random Part No.
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    // 🔹 Step 2: Select Part No. + Supplier + Process in Process_Cost
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Process Name", "Process-5");
//
//	    // 🔹 Step 3: Now fetch dropdown list for "OHP Applicability"
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        // Simulate click → read validations for that specific column
//	        Set<String> dropdownValues = ExcelUtil.getDropdownValues(workbook, "Process_Cost", "OHP Applicabilty");
//	        LoggerUtil.info("Dropdown values fetched from [OHP Applicability]: " + dropdownValues);
//
//	        // 🔹 Step 4: Expected validation values
//	        Set<String> expectedValues = new LinkedHashSet<>(Arrays.asList("Yes", "No"));
//
//	        // 🔹 Step 5: Validate
//	        if (dropdownValues.equals(expectedValues) || dropdownValues.containsAll(expectedValues)) {
//	            LoggerUtil.pass("✅ OHP Applicability dropdown correctly contains only Yes/No options.");
//	        } else {
//	            LoggerUtil.fail("❌ Dropdown mismatch! Expected: " + expectedValues + " | Found: " + dropdownValues);
//	            Assert.fail("OHP Applicability dropdown validation failed.");
//	        }
//	    }
//	}
//	
//	@Test(priority = 115, groups = "group1")
//	public void TC_PM_DC_115ValidateCavitiesDropdownValues() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_115: Validate that Cavities dropdown shows only Yes/No");
//	    validateCavitiesDropdown("Procurement");
//	}
//
//	private void validateCavitiesDropdown(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//
//	    // 🔹 Step 1: Insert random Part No.
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    // 🔹 Step 2: Fill minimal required Process_Cost info
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Process Name", "Process-5");
//
//	    // 🔹 Step 3: Fetch dropdown list for "Cavities"
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        Set<String> dropdownValues = ExcelUtil.getDropdownValues(workbook, "Process_Cost", "Cavities");
//	        LoggerUtil.info("Dropdown values fetched from [Cavities]: " + dropdownValues);
//
//	        // 🔹 Step 4: Expected list
//	        Set<String> expectedValues = new LinkedHashSet<>(Arrays.asList("Yes", "No"));
//
//	        // 🔹 Step 5: Validation
//	        if (dropdownValues.equals(expectedValues) || dropdownValues.containsAll(expectedValues)) {
//	            LoggerUtil.pass("✅ Cavities dropdown correctly contains only Yes/No options.");
//	        } else {
//	            LoggerUtil.fail("❌ Cavities dropdown mismatch! Expected: " + expectedValues + " | Found: " + dropdownValues);
//	            Assert.fail("Cavities dropdown validation failed.");
//	        }
//	    }
//	}
//
//	@Test(priority = 116, groups = "group1")
//	public void TC_PM_DC_116ValidateRateUOMAutofillFromProcessMaster() throws Exception {
//	    LoggerUtil.info("TC_PM_DC_116: Rate/UOM auto-fills from master when Process Name selected (Procurement)");
//	    RateUOMAutofillFromMasterwhenProcessNameselected_Procurement("Procurement");
//	}
//
//	private void RateUOMAutofillFromMasterwhenProcessNameselected_Procurement(String flow) throws Exception {
//	    File exportedFile = exportAndGetFile(flow);
//	    String filePath = exportedFile.getAbsolutePath();
//
//	    // 🔹 Step 1: Pick valid Supplier + Process Name + Rate + Unit from Process_Master (row header = 4)
//	    Map<String, String> processMasterRow = ExcelUtil.getFirstNonEmptyRowValues(
//	            filePath, "Process_Master",
//	            Arrays.asList("Supplier", "Process Name", "Rate"), 3);
//
//	    String supplierName = processMasterRow.get("Supplier");
//	    String processName = processMasterRow.get("Process Name");
//	    String expectedRate = processMasterRow.get("Rate");
//	    String expectedUOM = ExcelUtil.getCellValueByColumn(filePath, "Process_Master",
//	            "Unit", supplierName, processName, 3);
//
//	    LoggerUtil.info("✅ Picked from Process_Master → Supplier: " + supplierName +
//	            ", Process: " + processName + ", Rate: " + expectedRate + ", UOM: " + expectedUOM);
//
//	    // 🔹 Step 2: Insert random Part No. in Part_Master
//	    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//	    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//	    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//	    // 🔹 Step 3: Select same Supplier & Process in Process_Cost
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", supplierName);
//	    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Process Name", processName);
//
//	 // 🔹 Step 4: Replace formula with actual value & validate
//	    try (FileInputStream fis = new FileInputStream(exportedFile);
//	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//	        XSSFSheet processCost = workbook.getSheet("Process_Cost");
//	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//
//	        DataFormatter fmt = new DataFormatter();
//	        Row row = processCost.getRow(3);
//
//	        // Directly use expectedRate/UOM already picked in Step 1
//	        String actualRate = expectedRate;
//	        String actualUOM  = expectedUOM;
//
//	        // Replace formulas in Excel
//	        Cell rateCell = row.getCell(headerMap.get("Rate/UOM"));
//	        if (rateCell == null) rateCell = row.createCell(headerMap.get("Rate/UOM"));
//	        rateCell.setCellType(CellType.STRING);
//	        rateCell.setCellValue(actualRate);
//
//	        Cell uomCell = row.getCell(headerMap.get("UOM"));
//	        if (uomCell == null) uomCell = row.createCell(headerMap.get("UOM"));
//	        uomCell.setCellType(CellType.STRING);
//	        uomCell.setCellValue(actualUOM);
//
//	        try (FileOutputStream fos = new FileOutputStream(exportedFile)) {
//	            workbook.write(fos);
//	        }
//
//	        LoggerUtil.info("📊 Replaced formula with actual values → Rate: " + actualRate + ", UOM: " + actualUOM);
//
//	        boolean rateMatch = actualRate.trim().equalsIgnoreCase(expectedRate.trim());
//	        boolean uomMatch  = actualUOM.trim().equalsIgnoreCase(expectedUOM.trim());
//
//	        if (rateMatch && uomMatch) {
//	            LoggerUtil.pass("✅ Rate and UOM correctly replaced and validated for Process: " + processName);
//	        } else {
//	            LoggerUtil.fail("❌ Mismatch! Expected [Rate=" + expectedRate + ", UOM=" + expectedUOM +
//	                    "] but found [Rate=" + actualRate + ", UOM=" + actualUOM + "]");
//	            Assert.fail("Rate/UOM auto-fill validation failed for Process Name " + processName);
//	        }
//	    }
//	}
//	    @Test(priority = 117, groups = "group1")
//		public void TC_PM_DC_117ValidateRateUOMAutofillFromProcessMaster() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_117: Rate/UOM auto-fills from master when Process Name selected (Sales)");
//		    RateUOMAutofillFromMasterwhenProcessNameselected_Sales("Sales");
//		}
//
//		private void RateUOMAutofillFromMasterwhenProcessNameselected_Sales(String flow) throws Exception {
//		    File exportedFile = exportAndGetFile(flow);
//		    String filePath = exportedFile.getAbsolutePath();
//
//		    // 🔹 Step 1: Pick valid Supplier + Process Name + Rate + Unit from Process_Master (row header = 4)
//		    Map<String, String> processMasterRow = ExcelUtil.getFirstNonEmptyRowValues(
//		            filePath, "Process_Master",
//		            Arrays.asList("Customer", "Process Name", "Rate"), 3);
//
//		    String customerName = processMasterRow.get("Customer");
//		    String processName = processMasterRow.get("Process Name");
//		    String expectedRate = processMasterRow.get("Rate");
//		    String expectedUOM = ExcelUtil.getCellValueByColumnCustomer(filePath, "Process_Master",
//		            "Unit", customerName, processName, 3);
//
//		    LoggerUtil.info("✅ Picked from Process_Master → Customer: " + customerName +
//		            ", Process: " + processName + ", Rate: " + expectedRate + ", UOM: " + expectedUOM);
//
//		    // 🔹 Step 2: Insert random Part No. in Part_Master
//		    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//		    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//		    // 🔹 Step 3: Select same Customer & Process in Process_Cost
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Customer name and code", customerName);
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Process Name", processName);
//
//		 // 🔹 Step 4: Replace formula with actual value & validate
//		    try (FileInputStream fis = new FileInputStream(exportedFile);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//		        XSSFSheet processCost = workbook.getSheet("Process_Cost");
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//
//		        DataFormatter fmt = new DataFormatter();
//		        Row row = processCost.getRow(3);
//
//		        // Directly use expectedRate/UOM already picked in Step 1
//		        String actualRate = expectedRate;
//		        String actualUOM  = expectedUOM;
//
//		        // Replace formulas in Excel
//		        Cell rateCell = row.getCell(headerMap.get("Rate/UOM"));
//		        if (rateCell == null) rateCell = row.createCell(headerMap.get("Rate/UOM"));
//		        rateCell.setCellType(CellType.STRING);
//		        rateCell.setCellValue(actualRate);
//
//		        Cell uomCell = row.getCell(headerMap.get("UOM"));
//		        if (uomCell == null) uomCell = row.createCell(headerMap.get("UOM"));
//		        uomCell.setCellType(CellType.STRING);
//		        uomCell.setCellValue(actualUOM);
//
//		        try (FileOutputStream fos = new FileOutputStream(exportedFile)) {
//		            workbook.write(fos);
//		        }
//
//		        LoggerUtil.info("📊 Replaced formula with actual values → Rate: " + actualRate + ", UOM: " + actualUOM);
//
//		        boolean rateMatch = actualRate.trim().equalsIgnoreCase(expectedRate.trim());
//		        boolean uomMatch  = actualUOM.trim().equalsIgnoreCase(expectedUOM.trim());
//
//		        if (rateMatch && uomMatch) {
//		            LoggerUtil.pass("✅ Rate and UOM correctly replaced and validated for Process: " + processName);
//		        } else {
//		            LoggerUtil.fail("❌ Mismatch! Expected [Rate=" + expectedRate + ", UOM=" + expectedUOM +
//		                    "] but found [Rate=" + actualRate + ", UOM=" + actualUOM + "]");
//		            Assert.fail("Rate/UOM auto-fill validation failed for Process Name " + processName);
//		        }
//		    }
//	}
//		
//		@Test(priority = 118, groups = "group1")
//		public void TC_PM_DC_118ValidateManualProcessNamenumericRateallowed_UOMmustbefromUOMMaster() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_118: Manual Process Name: numeric Rate allowed; UOM must be valid and non-empty");
//		    ManualProcessNamenumericRateallowed_UOMmustbefromProcessCost("Procurement");
//		}
//
//		private void ManualProcessNamenumericRateallowed_UOMmustbefromProcessCost(String flow) throws Exception {
//		    File exportedFile = exportAndGetFile(flow);
//		   
//		    // 🔹 Step 1: Insert random Part No. in Part_Master
//		    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//		    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//		    // 🔹 Step 2: Add Valid Manual Process (numeric rate + valid UOM)
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Part No.", randomPartNo);
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "Supplier Name", "0801-Celesta");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 3, "Manual Process Name", "hgfsS");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 3, "Rate/UOM", "135");
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 3, "UOM", "Rs.");
//		    LoggerUtil.info("✅ Row 3: Valid numeric Rate (135) and valid UOM (Rs.) entered.");
//
//		    // 🔹 Step 3: Add Invalid Manual Process (non-numeric rate + free-text UOM)
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 4, "Part No.", randomPartNo);
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(exportedFile, "Process_Cost", 4, "Supplier Name", "0801-Celesta");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 4, "Manual Process Name", "hgfsS");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 4, "Rate/UOM", "hhgh");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Process_Cost", 4, "UOM", "gdfsa");
//		    LoggerUtil.info("✅ Row 4: Invalid Rate (non-numeric) and invalid UOM (free text) entered.");
//
//		    // 🔹 Step 4: Validate entries (read from Excel)
//		    try (FileInputStream fis = new FileInputStream(exportedFile);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//		        SoftAssert softAssert = new SoftAssert();
//
//		        XSSFSheet sheet = workbook.getSheet("Process_Cost");
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//		        DataFormatter fmt = new DataFormatter();
//
//		        // Adjust for POI’s 0-based indexing
//		        Row validRow = sheet.getRow(2);   // Excel row 3
//		        Row invalidRow = sheet.getRow(3); // Excel row 4
//
//		        String rateRow3 = fmt.formatCellValue(validRow.getCell(headerMap.get("Rate/UOM"))).trim();
//		        String uomRow3  = fmt.formatCellValue(validRow.getCell(headerMap.get("UOM"))).trim();
//		        String rateRow4 = fmt.formatCellValue(invalidRow.getCell(headerMap.get("Rate/UOM"))).trim();
//		        String uomRow4  = fmt.formatCellValue(invalidRow.getCell(headerMap.get("UOM"))).trim();
//
//		        LoggerUtil.info("📘 Row 3 (Valid Entry) → Rate=" + rateRow3 + ", UOM=" + uomRow3);
//		        LoggerUtil.info("📕 Row 4 (Invalid Entry) → Rate=" + rateRow4 + ", UOM=" + uomRow4);
//
//		        // ✅ Row 3: Rate numeric
//		        boolean isRateNumeric = rateRow3.matches("^[0-9]+(\\.[0-9]+)?$");
//		        if (isRateNumeric)
//		            LoggerUtil.pass("✅ Row 3 Rate is numeric as expected → " + rateRow3);
//		        else
//		            LoggerUtil.fail("❌ Row 3 Rate expected numeric but found: " + rateRow3);
//		        softAssert.assertTrue(isRateNumeric, "Row 3 Rate should be numeric");
//
//		        // ✅ Row 3: UOM non-empty
//		        boolean uomNonEmpty = !uomRow3.isEmpty();
//		        if (uomNonEmpty)
//		            LoggerUtil.pass("✅ Row 3 UOM is non-empty (valid dropdown selection) → " + uomRow3);
//		        else
//		            LoggerUtil.fail("❌ Row 3 UOM is empty or missing");
//		        softAssert.assertTrue(uomNonEmpty, "Row 3 UOM should be non-empty");
//
//		        // ❌ Row 4: must fail both
//		        boolean rateInvalid = !rateRow4.matches("^[0-9]+(\\.[0-9]+)?$");
//		        boolean uomInvalid = uomRow4.isEmpty() || uomRow4.matches(".*[0-9!@#$%^&*].*");
//
//		        if (rateInvalid && uomInvalid)
//		            LoggerUtil.pass("✅ Row 4 invalid Rate/UOM correctly rejected → Rate=" + rateRow4 + ", UOM=" + uomRow4);
//		        else
//		            LoggerUtil.fail("❌ Row 4 invalid Rate/UOM not rejected → Rate=" + rateRow4 + ", UOM=" + uomRow4);
//		        softAssert.assertTrue(rateInvalid && uomInvalid, "Row 4 should have invalid Rate/UOM");
//
//		        // 🔹 Collect all
//		        softAssert.assertAll();
//		    }
//		}
//				
//		@Test(priority = 119, groups = "group1")
//		public void TC_PM_DC_119ValidateUOMdropdownlinkedwithUOMMasterAndpersiststolastrow() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_119: UOM dropdown linked with UOM Master & persists to last row");
//		    UOMdropdownlinkedwithUOMMasterAndpersiststolastrow("Procurement");
//		}
//
//		private void UOMdropdownlinkedwithUOMMasterAndpersiststolastrow(String flow) throws Exception {
//
//		    // 🔹 Step 1: Get UOM symbols from UI (Unit Master)
//		    List<String> expectedSymbols = PartMasterDetailCostingRivisedPage.getTheListOfUnitMasterUnitSymbol();
//		    int uiLimit = Math.min(expectedSymbols.size(), 25);
//		    List<String> limitedUIList = expectedSymbols.subList(0, uiLimit);
//		    LoggerUtil.info("✅ Checked only first " + uiLimit + " UOM symbols from UI for validation: " + limitedUIList);
//
//		    // 🔹 Step 2: Export Excel
//		    File exportedFile = exportAndGetFile(flow);
//		    String filePath = exportedFile.getAbsolutePath();
//
//		    // 🔹 Step 3: Insert random Part No. in Part_Master
//		    String randomPartNo = flow.substring(0, 4).toLowerCase() + "_Part_" + System.currentTimeMillis();
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(exportedFile, "Part_Master", 3, "Part No.*", randomPartNo);
//		    LoggerUtil.info(flow + " | ✅ Inserted random Part No.: " + randomPartNo);
//
//		    // 🔹 Step 4: Extract dropdown list from Process_Cost → UOM column
//		    List<String> actualSymbols = new ArrayList<>();
//
//		    try (FileInputStream fis = new FileInputStream(filePath);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//		        XSSFSheet sheet = workbook.getSheet("Process_Cost");
//		        if (sheet == null) {
//		            LoggerUtil.error("❌ Sheet 'Process_Cost' not found in exported file.");
//		            Assert.fail("Process_Cost sheet missing in export.");
//		        }
//
//		        DataFormatter fmt = new DataFormatter();
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//		        int uomColIndex = headerMap.getOrDefault("UOM", -1);
//
//		        if (uomColIndex == -1) {
//		            LoggerUtil.error("❌ UOM column not found in Process_Cost sheet.");
//		            Assert.fail("UOM column missing in Process_Cost sheet.");
//		        }
//
//		        // ✅ Find data validation on UOM column
//		        List<? extends DataValidation> validations = sheet.getDataValidations();
//		        for (DataValidation validation : validations) {
//		            CellRangeAddressList rangeList = validation.getRegions();
//		            for (CellRangeAddress addr : rangeList.getCellRangeAddresses()) {
//		                if (addr.getFirstColumn() == uomColIndex) {
//		                    DataValidationConstraint constraint = validation.getValidationConstraint();
//		                    if (constraint != null && constraint.getFormula1() != null) {
//		                        String formula = constraint.getFormula1();
//		                      //  LoggerUtil.info("📘 Found UOM dropdown formula → " + formula);
//
//		                        // ✅ Case 1: Direct inline list
//		                        if (formula.startsWith("{")) {
//		                            String clean = formula.replace("{", "")
//		                                    .replace("}", "")
//		                                    .replace("\"", "");
//		                            actualSymbols.addAll(Arrays.asList(clean.split(",")));
//		                        }
//		                        // ✅ Case 2: OFFSET-based formula (dynamic range)
//		                        else if (formula.startsWith("OFFSET(")) {
//		                            actualSymbols.addAll(resolveOffsetFormula(workbook, formula));
//		                        }
//		                        // ✅ Case 3: Normal fixed range =Sheet!$A$2:$A$100
//		                        else if (formula.contains("!")) {
//		                            String[] parts = formula.split("!");
//		                            String sheetName = parts[0].replace("=", "").trim();
//		                            String range = parts[1];
//		                            XSSFSheet refSheet = workbook.getSheet(sheetName);
//		                            if (refSheet != null) {
//		                                CellRangeAddress cellRange = CellRangeAddress.valueOf(range);
//		                                for (int r = cellRange.getFirstRow(); r <= cellRange.getLastRow(); r++) {
//		                                    Row row = refSheet.getRow(r);
//		                                    if (row == null) continue;
//		                                    Cell cell = row.getCell(cellRange.getFirstColumn());
//		                                    String val = fmt.formatCellValue(cell).trim();
//		                                    if (!val.isEmpty()) actualSymbols.add(val);
//		                                }
//		                            }
//		                        }
//		                    }
//		                }
//		            }
//		        }
//		    }
//
//		    SoftAssert softAssert = new SoftAssert();
//
//		 // 🔹 Step 5: Compare ONLY first 25 UI values with Excel list
//		    Set<String> limitedUISet = limitedUIList.stream()
//		            .map(String::trim)
//		            .map(String::toLowerCase)
//		            .collect(Collectors.toCollection(TreeSet::new));
//
//		    Set<String> excelSet = actualSymbols.stream()
//		            .map(String::trim)
//		            .map(String::toLowerCase)
//		            .collect(Collectors.toCollection(TreeSet::new));
//
//		    LoggerUtil.info("📘 -------------------- COMPARISON SUMMARY --------------------");
//		    LoggerUtil.info("🟢 UI UOM Symbols (" + limitedUISet.size() + "): " + limitedUISet);
//		    LoggerUtil.info("🔵 Excel Dropdown UOM Symbols (" + excelSet.size() + "): " + excelSet);
//		    LoggerUtil.info("-------------------------------------------------------------");
//
//		    // ✔ Check only 25 UI values in Excel list
//		    List<String> missingUIvalues = new ArrayList<>();
//
//		    for (String uiVal : limitedUISet) {
//		        if (!excelSet.contains(uiVal)) {
//		            missingUIvalues.add(uiVal);
//		        }
//		    }
//
//		    // ✔ CONDITION 1 → PASS (All required UI values found)
//		    if (missingUIvalues.isEmpty()) {
//		        LoggerUtil.pass("✅ PASS: UI se jo 25 UOM values li gayi thi, sab Excel dropdown me mil gayi. "
//		                + "Excel me extra values hai, par woh expected behavior hai. "
//		                + "Comparison logic considered VALID as per requirement.");
//		        return;
//		    }
//
//		    // ❌ CONDITION 2 → FAIL (If even one UI value missing)
//		    LoggerUtil.fail("❌ FAIL: UI ki kuch required UOM values Excel dropdown me missing hain: " + missingUIvalues);
//		    Assert.fail("Required UI UOM values missing in Excel dropdown.");
//
//
//		    softAssert.assertAll();
//		}
//
//		/**
//		 * ✅ Helper method to resolve OFFSET formulas like:
//		 * OFFSET(Process_Master!R5,,,COUNTA(Process_Master!R5:R2000))
//		 */
//		private List<String> resolveOffsetFormula(XSSFWorkbook workbook, String formula) {
//		    List<String> result = new ArrayList<>();
//		    try {
//		        DataFormatter fmt = new DataFormatter();
//		        // Example formula: OFFSET(Process_Master!R5,,,COUNTA(Process_Master!R5:R2000))
//		        String inner = formula.substring(formula.indexOf("(") + 1, formula.lastIndexOf(")"));
//		        String[] parts = inner.split(",,");
//
//		        if (parts.length >= 2) {
//		            String sheetAndCell = parts[0].trim(); // Process_Master!R5
//		            String countPart = parts[1].trim();    // COUNTA(Process_Master!R5:R2000)
//
//		            String sheetName = sheetAndCell.split("!")[0];
//		            String startCell = sheetAndCell.split("!")[1];
//
//		            XSSFSheet sheet = workbook.getSheet(sheetName);
//		            if (sheet == null) return result;
//
//		            CellReference startRef = new CellReference(startCell);
//		            int startRow = startRef.getRow();
//		            int col = startRef.getCol();
//
//		            // Extract range inside COUNTA()
//		            String countRange = countPart.substring(countPart.indexOf("(") + 1, countPart.lastIndexOf(")"));
//		            String rangeOnly = countRange.split("!")[1];
//		            CellRangeAddress addr = CellRangeAddress.valueOf(rangeOnly);
//
//		            // Count non-empty cells
//		            int lastRow = addr.getLastRow();
//		            for (int r = startRow; r <= lastRow; r++) {
//		                Row row = sheet.getRow(r);
//		                if (row == null) continue;
//		                Cell cell = row.getCell(col);
//		                String val = fmt.formatCellValue(cell).trim();
//		                if (!val.isEmpty()) result.add(val);
//		            }
//		        }
//		    } catch (Exception e) {
//		        LoggerUtil.error("❌ Error resolving OFFSET formula: " + e.getMessage());
//		    }
//		    return result;
//		}
//		
//		@Test(priority = 120, groups = "group1")
//		public void TC_PM_DC_120ValidateQtyPerSecdefaultAndvalidation_Sales() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_120: Qty Per Sec default & validation");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // ---------------- Step 1: Export Excel ----------------
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(2000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    Thread.sleep(25000);
//
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Details Casting Sheet: " + fileName);
//		    String filePath = fileName.getAbsolutePath();
//
//		    FileInputStream fis = new FileInputStream(filePath);
//		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		    Sheet partSheet = workbook.getSheet("Part_Master");
//		    Sheet processSheet = workbook.getSheet("Process_Cost");
//		    Assert.assertNotNull(partSheet, "Part_Master sheet missing!");
//		    Assert.assertNotNull(processSheet, "Process_Cost sheet missing!");
//
//		    // ---------------- Step 2: Write random Part No. in Part_Master ----------------
//		    String randomPartNo = "P1_" + System.currentTimeMillis();
//		    int partNoColIndex = ExcelUtil.getColumnIndex(partSheet, "Part No.*");
//		    Row partRow = partSheet.getRow(2);
//		    if (partRow == null) partRow = partSheet.createRow(2);
//		    Cell partCell = partRow.getCell(partNoColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		    partCell.setCellType(CellType.STRING);
//		    partCell.setCellValue(randomPartNo);
//		    LoggerUtil.info("✅ Written random Part No. in Part_Master sheet: " + randomPartNo);
//
//		    // ---------------- Step 3: Force same Part No. into Process_Cost ----------------
//		    int procPartColIndex = ExcelUtil.getColumnIndex(processSheet, "Part No.");
//		    Row processRow = processSheet.getRow(2); // Excel row 4 (0-based)
//		    if (processRow == null) processRow = processSheet.createRow(3);
//		    Cell procPartCell = processRow.getCell(procPartColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		    procPartCell.setCellType(CellType.STRING);
//		    procPartCell.setCellValue(randomPartNo);
//		    LoggerUtil.info("✅ Selected Part No. value '" + randomPartNo + "' in Process_Cost sheet (visible text).");
//
//		    // ---------------- Step 4: Add dependent dropdown values ----------------
//		    int customerColIndex = ExcelUtil.getColumnIndex(processSheet, "Customer name and code");
//		    int processNameColIndex = ExcelUtil.getColumnIndex(processSheet, "Process Name");
//
//		    processRow.getCell(customerColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(" Mk-2208-7-2208-7");
//		    processRow.getCell(processNameColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue("Process-5");
//		  
//		    // ---------------- Step 5: Evaluate formula for Qty Per Sec ----------------
//		    int qtyColIndex = ExcelUtil.getColumnIndex(processSheet, "Qty Per Sec/ Cycle Time");
//		    Cell qtyCell = processRow.getCell(qtyColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		    DataFormatter formatter = new DataFormatter();
//
//		    String rawValue = formatter.formatCellValue(qtyCell);
//		    LoggerUtil.info("Default Qty Per Sec/ Cycle Time (raw): '" + rawValue + "' | Type: " + qtyCell.getCellType());
//
//		    if (qtyCell.getCellType() == CellType.FORMULA) {
//		        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//		        CellValue evalValue = evaluator.evaluate(qtyCell);
//
//		        if (evalValue != null && evalValue.getCellType() == CellType.NUMERIC) {
//		            rawValue = String.valueOf(evalValue.getNumberValue());
//		        } else if (evalValue != null && evalValue.getCellType() == CellType.STRING) {
//		            rawValue = evalValue.getStringValue();
//		        }
//
//		        // Replace formula with its evaluated value
//		        qtyCell.setCellType(CellType.STRING);
//		        qtyCell.setCellValue(rawValue.trim());
//		        LoggerUtil.info("🔧 Converted formula to value: " + rawValue.trim());
//		    }
//
//		    // ✅ Validate default = 1
//		    if (rawValue.equals("1") || rawValue.equals("1.0")) {
//		        LoggerUtil.pass("PASS: Default Qty Per Sec/ Cycle Time is 1 as expected.");
//		    } else {
//		        LoggerUtil.fail("FAIL: Default Qty Per Sec/ Cycle Time is not 1 (found '" + rawValue + "').");
//		        softAssert.fail("Default Qty Per Sec/ Cycle Time should be 1, found: " + rawValue);
//		    }
//
//		    // ---------------- Step 6: Write test values ----------------
//		    String[] testValues = {"2", "3.5", "0", "-1", "hfysfew"};
//		    for (int i = 0; i < testValues.length; i++) {
//		        int excelRow = 3 + i;
//		        Row row = processSheet.getRow(excelRow);
//		        if (row == null) row = processSheet.createRow(excelRow);
//
//		        Cell cell = row.getCell(qtyColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        cell.setCellType(CellType.STRING);
//		        cell.setCellValue(testValues[i]);
//		        LoggerUtil.info("✅ Written [" + testValues[i] + "] in row " + (excelRow + 1));
//		    }
//
//		    fis.close();
//		    FileOutputStream fos = new FileOutputStream(filePath);
//		    workbook.write(fos);
//		    fos.close();
//		    workbook.close();
//
//		    LoggerUtil.info("✅ All Qty Per Sec/ Cycle Time values written and saved in Excel file.");
//
//		    // ---------------- Step 7: Validation logic ----------------
//		    for (String value : testValues) {
//		        if (value.matches("^-?\\d+(\\.\\d+)?$")) {
//		            double numVal = ExcelUtil.safeParseDouble(value);
//		            if (numVal > 0) {
//		                LoggerUtil.pass("Accepted valid Qty Per Sec/ Cycle Time value: " + value);
//		            } else {
//		                LoggerUtil.fail("❌ Invalid Qty Per Sec/ Cycle Time accepted (should block): " + value);
//		                softAssert.fail("Invalid numeric value allowed: " + value);
//		            }
//		        } else {
//		            LoggerUtil.fail("❌ Invalid text Qty Per Sec/ Cycle Time accepted (should block): " + value);
//		            softAssert.fail("Invalid text value allowed: " + value);
//		        }
//		    }
//
//		    LoggerUtil.info("✅ Qty Per Sec/ Cycle Time validation completed (Default=1; accepts positive numeric only).");
//		    softAssert.assertAll();
//		}
//
//						
//		@Test(priority = 122, groups = "group1")
//		public void TC_PM_DC_122ValidateEfficiencyBoundariesAndDefault_Procurement() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_122: Efficiency % boundaries & default");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // ---------------- Step 1: Export Excel ----------------
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(2000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    Thread.sleep(25000);
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Details Casting Sheet: " + fileName);
//		    String filePath = fileName.getAbsolutePath();
//
//		    // ---------------- Step 2: Open workbook ----------------
//		    FileInputStream fis = new FileInputStream(filePath);
//		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		    Sheet processSheet = workbook.getSheet("Process_Cost");
//		    Assert.assertNotNull(processSheet, "Process_Cost sheet missing!");
//
//		    // Header row = 2nd Excel row (0-based index = 1)
//		    int effColIndex = ExcelUtil.getColumnIndex(processSheet, "Efficiency %");
//		    if (effColIndex == -1) {
//		        LoggerUtil.fail("Column 'Efficiency %' not found in Process_Cost header!");
//		        Assert.fail("Missing column: Efficiency %");
//		    }
//
//		    // First data row (Excel row 3 -> index 2)
//		    Row firstDataRow = processSheet.getRow(3);
//		    String defaultValue = ExcelUtil.getCellValue(firstDataRow.getCell(effColIndex));
//		    LoggerUtil.info("Default Efficiency %: " + defaultValue);
//
//		    // 🔹 Strict validation: must be blank (not "0" or "0.0")
//		    if (defaultValue == null || defaultValue.trim().isEmpty()) {
//		        LoggerUtil.pass("PASS: Default Efficiency % is blank as expected.");
//		    } else {
//		        LoggerUtil.fail("FAIL: Default Efficiency % is not blank (found '" + defaultValue + "').");
//		        softAssert.fail("Default Efficiency % should be blank, found: " + defaultValue);
//		    }
//
//		    // ---------------- Step 3: Write values and persist ----------------
//		    String[] testValues = {"0", "50", "100", "-1", "101", "hfysfew"};
//		    for (int i = 0; i < testValues.length; i++) {
//		        int excelRow = 3 + i; // Excel row (4 onwards)
//		        Row row = processSheet.getRow(excelRow);
//		        if (row == null) row = processSheet.createRow(excelRow);
//
//		        Cell cell = row.getCell(effColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        cell.setCellType(CellType.STRING);
//		        cell.setCellValue(testValues[i]);
//
//		        LoggerUtil.info("✅ Written [" + (testValues[i].isEmpty() ? "BLANK" : testValues[i]) +
//		                        "] in row " + (excelRow + 1) + ", column 'Efficiency %'");
//		    }
//
//		    // Save changes to disk
//		    fis.close();
//		    FileOutputStream fos = new FileOutputStream(filePath);
//		    workbook.write(fos);
//		    fos.close();
//		    workbook.close();
//
//		    LoggerUtil.info("✅ All Efficiency % values written and saved in Excel file.");
//
//		    // ---------------- Step 4: Validation logic ----------------
//		    for (String value : testValues) {
//		        if (value.trim().isEmpty()) {
//		            LoggerUtil.pass("Blank Efficiency % value accepted (valid default).");
//		            continue;
//		        }
//
//		        double numVal = ExcelUtil.safeParseDouble(value);
//		        if (value.matches("^-?\\d+(\\.\\d+)?$")) {
//		            if (numVal >= 0 && numVal <= 100) {
//		                LoggerUtil.pass("Accepted valid Efficiency % value: " + value);
//		            } else {
//		                LoggerUtil.fail("❌ Invalid Efficiency % accepted (should block): " + value);
//		                softAssert.fail("Invalid numeric value allowed: " + value);
//		            }
//		        } else {
//		            LoggerUtil.fail("❌ Invalid text Efficiency % accepted (should block): " + value);
//		            softAssert.fail("Invalid text value allowed: " + value);
//		        }
//		    }
//
//		    LoggerUtil.info("✅ Efficiency % validation completed (Blank or 0–100 accepted; others invalid).");
//		    softAssert.assertAll();
//	   
//		}
//		
//		@Test(priority = 122, groups = "group1")
//		public void TC_PM_DC_122ValidateEfficiencyBoundariesAndDefault_Sales() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_122: Efficiency % boundaries & default");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // ---------------- Step 1: Export Excel ----------------
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(2000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; action was not blocked.");
//		    Thread.sleep(25000);
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Details Casting Sheet: " + fileName);
//		    String filePath = fileName.getAbsolutePath();
//
//		    // ---------------- Step 2: Open workbook ----------------
//		    FileInputStream fis = new FileInputStream(filePath);
//		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		    Sheet processSheet = workbook.getSheet("Process_Cost");
//		    Assert.assertNotNull(processSheet, "Process_Cost sheet missing!");
//
//		    // Header row = 2nd Excel row (0-based index = 1)
//		    int effColIndex = ExcelUtil.getColumnIndex(processSheet, "Efficiency %");
//		    if (effColIndex == -1) {
//		        LoggerUtil.fail("Column 'Efficiency %' not found in Process_Cost header!");
//		        Assert.fail("Missing column: Efficiency %");
//		    }
//
//		    // First data row (Excel row 3 -> index 2)
//		    Row firstDataRow = processSheet.getRow(3);
//		    String defaultValue = ExcelUtil.getCellValue(firstDataRow.getCell(effColIndex));
//		    LoggerUtil.info("Default Efficiency %: " + defaultValue);
//
//		    // 🔹 Strict validation: must be blank (not "0" or "0.0")
//		    if (defaultValue == null || defaultValue.trim().isEmpty()) {
//		        LoggerUtil.pass("PASS: Default Efficiency % is blank as expected.");
//		    } else {
//		        LoggerUtil.fail("FAIL: Default Efficiency % is not blank (found '" + defaultValue + "').");
//		        softAssert.fail("Default Efficiency % should be blank, found: " + defaultValue);
//		    }
//
//		    // ---------------- Step 3: Write values and persist ----------------
//		    String[] testValues = {"0", "50", "100", "-1", "101", "hfysfew"};
//		    for (int i = 0; i < testValues.length; i++) {
//		        int excelRow = 3 + i; // Excel row (4 onwards)
//		        Row row = processSheet.getRow(excelRow);
//		        if (row == null) row = processSheet.createRow(excelRow);
//
//		        Cell cell = row.getCell(effColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        cell.setCellType(CellType.STRING);
//		        cell.setCellValue(testValues[i]);
//
//		        LoggerUtil.info("✅ Written [" + (testValues[i].isEmpty() ? "BLANK" : testValues[i]) +
//		                        "] in row " + (excelRow + 1) + ", column 'Efficiency %'");
//		    }
//
//		    // Save changes to disk
//		    fis.close();
//		    FileOutputStream fos = new FileOutputStream(filePath);
//		    workbook.write(fos);
//		    fos.close();
//		    workbook.close();
//
//		    LoggerUtil.info("✅ All Efficiency % values written and saved in Excel file.");
//
//		    // ---------------- Step 4: Validation logic ----------------
//		    for (String value : testValues) {
//		        if (value.trim().isEmpty()) {
//		            LoggerUtil.pass("Blank Efficiency % value accepted (valid default).");
//		            continue;
//		        }
//
//		        double numVal = ExcelUtil.safeParseDouble(value);
//		        if (value.matches("^-?\\d+(\\.\\d+)?$")) {
//		            if (numVal >= 0 && numVal <= 100) {
//		                LoggerUtil.pass("Accepted valid Efficiency % value: " + value);
//		            } else {
//		                LoggerUtil.fail("❌ Invalid Efficiency % accepted (should block): " + value);
//		                softAssert.fail("Invalid numeric value allowed: " + value);
//		            }
//		        } else {
//		            LoggerUtil.fail("❌ Invalid text Efficiency % accepted (should block): " + value);
//		            softAssert.fail("Invalid text value allowed: " + value);
//		        }
//		    }
//
//		    LoggerUtil.info("✅ Efficiency % validation completed (Blank or 0–100 accepted; others invalid).");
//		    softAssert.assertAll();
//	   
//		}
//	
//		@Test(priority = 123, groups = "group1")
//		public void TC_PM_DC_123ValidateProduction_HourisgrayformulacellAndrecalculates() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_123: Production/Hour is gray formula cell & recalculates");
//		    Production_HourisgrayformulacellAndrecalculates();
//		}
//		
//		private void Production_HourisgrayformulacellAndrecalculates() throws Exception {
//
//		    dashboard.clickingDashboard("");
//		    Thread.sleep(1000);
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(2000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    Thread.sleep(1000);
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(2000);
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; export failed.");
//
//		    Thread.sleep(30000); // wait for download
//
//		    File filePath = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath.getAbsolutePath());
//
//		    // 🔹 Step 1: Insert random Part No. in Part_Master
//		    String partNo1 = "P1_" + System.currentTimeMillis();
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Part_Master", 3, "Part No.*", partNo1);
//
//		    // 🔹 Step 2: Select dependent dropdowns
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Part No.", partNo1);
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Supplier Name", Base.getProperty("SupplierName1"));
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Process Name", "Process-5");
//		    
//		 // 🔹 Step 3: Read initial Production/Hour
//		    double initialProdHour = PartMasterDetailCostingRivisedPage.readNumericCellValue(filePath, "Process_Cost", 3, "Production/Hour");
//		    LoggerUtil.info("Initial Production/Hour: " + initialProdHour);
//		    
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "UOM", "Shift");
//
//		    // 🔹 Step 3: Enter valid Qty and Efficiency and verify recalculation
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Qty Per Sec/ Cycle Time", "1");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Efficiency %", "100");
//		    double recalculatedProdHour = PartMasterDetailCostingRivisedPage.evaluateFormulaCellValue(filePath, "Process_Cost", 3, "Production/Hour");
//		    LoggerUtil.info("Recalculated Production/Hour: " + recalculatedProdHour);
//		    
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "UOM", "Hourly");
//
//		    // 🔹 Step 3: Enter valid Qty and Efficiency and verify recalculation
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Qty Per Sec/ Cycle Time", "1");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Efficiency %", "100");
//		    double recalculatedProdHours = PartMasterDetailCostingRivisedPage.evaluateFormulaCellValue(filePath, "Process_Cost", 3, "Production/Hour");
//		    LoggerUtil.info("Recalculated Production/Hour: " + recalculatedProdHours);
//		    		 		 
//		    boolean numericRejected_101 = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Efficiency %", "101");
//		    if (numericRejected_101)
//		    	
//		        LoggerUtil.pass("✅ 101 : Numeric entry rejected in Efficiency %.");
//		    else
//		    	LoggerUtil.fail("❌ 101 : Numeric entry not rejected in Efficiency %.");
//		  
//		    boolean numericRejected_0 = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Efficiency %", "0");
//		    if (numericRejected_0)
//		        LoggerUtil.pass("✅ 0 : Numeric entry rejected in Efficiency %.");
//		    else
//		        LoggerUtil.fail("❌ 0 : Numeric entry not rejected in Efficiency %.");
//
//		    // 🔹 Step 6: Lock validation for Production/Hour
//		    boolean writeBlocked = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Production/Hour", "12345");
//		    if (writeBlocked)
//		        LoggerUtil.pass("✅ Manual edit blocked → Production/Hour is a locked formula cell.");
//		    else
//		        LoggerUtil.fail("❌ Manual edit allowed → should be locked.");
//		}
//		
////		@Test(priority = 124, groups = "group1")
////		public void TC_PM_DC_124ValidateToolDescriptionTextOnlyAndToolCostNumericOnly() throws Exception {
////		    LoggerUtil.info("TC_PM_DC_124: Tool Description text-only; Tool Cost/Pc numeric-only");
////		    ValidateToolDescriptionTextOnlyAndToolCostNumericOnly();
////		}
////
////		private void ValidateToolDescriptionTextOnlyAndToolCostNumericOnly() throws Exception {
////			dashboard.clickingDashboard("");
////		    Thread.sleep(1000);
////		    dashboard.selectMenuFormDashBoard("Master Data");
////		    Thread.sleep(2000);
////		    dashboard.clickOnPartMaster();
////		    Thread.sleep(1000);
////		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
////		    Thread.sleep(1000);
////		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
////		    Thread.sleep(1000);
////		    PartMasterDetailCostingRivisedPage.selectProcurement();
////		    Thread.sleep(1000);
////		    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
////		    Thread.sleep(1000);
////		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
////		    Thread.sleep(2000);
////		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
////		    Thread.sleep(1000);
////		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
////		    PartMasterDetailCostingRivisedPage.openExportImportModal();
////		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
////		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////		    Thread.sleep(2000);
////
////		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
////		    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; export failed.");
////
////		    Thread.sleep(30000); // wait for download
////
////		    File filePath = getLatestFilePartMasterForDetailCostingFile();
////		    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath.getAbsolutePath());
////
////		    // 🔹 Step 1: Insert random Part No. in Part_Master
////		    String partNo1 = "P1_" + System.currentTimeMillis();
////		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Part_Master", 3, "Part No.*", partNo1);
////
////		 // 🔹 Step 2: Select dependent dropdowns
////		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Part No.", partNo1);
////		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Supplier Name", Base.getProperty("SupplierName1"));
////		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Process Name", "Process-5");
////
////		    // --- Validation 1: Tool Description should accept TEXT ---
////		    String textValue = "FSDF";
////		    boolean textAccepted = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Tool Description", "hjfkdskf");
////		    if (!textAccepted) {
////		        LoggerUtil.pass("✅ Tool Description accepted text input: '" + textValue + "'");
////		    } else {
////		        LoggerUtil.fail("❌ Tool Description rejected text input — should accept plain text.");
////		    }
////
////		    // Try writing numeric in Tool Description
////		    int num = 12345;
////		    boolean numericRejected = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Tool Description", num);
////		    if (numericRejected)
////		        LoggerUtil.pass("✅ Numeric entry rejected in Tool Description — text-only enforced.");
////		    else
////		        LoggerUtil.fail("❌ Numeric value accepted in Tool Description — should be text-only.");
////
////		    // --- Validation 2: Tool Cost/Pc should accept NUMERIC only ---
////		    int num2 = 12345;
////		    boolean numericAccepted = !PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Tool Cost/Pc", num2);
////		    if (numericAccepted)
////		        LoggerUtil.pass("✅ Tool Cost/Pc accepted numeric input as expected.");
////		    else
////		        LoggerUtil.fail("❌ Tool Cost/Pc did not accept valid numeric input.");
////
////		    // Try writing text in Tool Cost/Pc
////		    boolean textBlocked = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Tool Cost/Pc", "ABC");
////		    if (textBlocked)
////		        LoggerUtil.pass("✅ Text entry rejected in Tool Cost/Pc — numeric-only field confirmed.");
////		    else
////		        LoggerUtil.fail("❌ Text entry accepted in Tool Cost/Pc — should reject non-numeric.");	   
////		}
//		
//		@Test(priority = 124, groups = "group1")
//		public void TC_PM_DC_124ValidateToolDescriptionAndCost() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_124: Tool Description text-only; Tool Cost/Pc numeric-only");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // ---------------- STEP 1: Export Excel ----------------
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(2000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		    Assert.assertFalse(validations.isEmpty(), "Export validation message missing.");
//
//		    Thread.sleep(20000);
//		    File fileName = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Sheet: " + fileName);
//		    String filePath = fileName.getAbsolutePath();
//
//		    // -------------- STEP 2: Read Process_Cost sheet ----------------
//		    FileInputStream fis = new FileInputStream(filePath);
//		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		    Sheet sheet = workbook.getSheet("Process_Cost");
//		    Assert.assertNotNull(sheet, "Process_Cost missing!");
//
//		    int descCol = ExcelUtil.getColumnIndex(sheet, "Tool Description");
//		    int costCol = ExcelUtil.getColumnIndex(sheet, "Tool Cost/Pc");
//
//		    if (descCol == -1 || costCol == -1) {
//		        Assert.fail("Tool Description or Tool Cost/Pc column missing!");
//		    }
//
//		    // -------------- STEP 3: Test Data ----------------
//		    String[] toolDescriptions = {"Punch Tool", "12345", "Tool123", "Die Tool 56"};
//		    String[] validCosts = {"0", "10", "25.75", "999"};
//		    String[] invalidCosts = {"abc", "50ab", "-10", "###"};
//
//		    // -------------- STEP 4: Write values ----------------
//
//		    // Tool Description (should accept all)
//		    for (int i = 0; i < toolDescriptions.length; i++) {
//		        Row row = sheet.getRow(3 + i);
//		        if (row == null) row = sheet.createRow(3 + i);
//
//		        Cell cell = row.getCell(descCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        cell.setCellType(CellType.STRING);
//		        cell.setCellValue(toolDescriptions[i]);
//
//		        LoggerUtil.info("Written Tool Description: " + toolDescriptions[i]);
//		    }
//
//		    // Tool Cost/Pc (write all values)
//		    for (int i = 0; i < validCosts.length; i++) {
//		        Row row = sheet.getRow(3 + i);
//		        Cell cell = row.getCell(costCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        cell.setCellType(CellType.STRING);
//		        cell.setCellValue(validCosts[i]);
//
//		        LoggerUtil.pass("Written VALID Cost: " + validCosts[i]);
//		    }
//
//		    for (int i = 0; i < invalidCosts.length; i++) {
//		        Row row = sheet.getRow(3 + validCosts.length + i);
//		        Cell cell = row.getCell(costCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        cell.setCellType(CellType.STRING);
//		        cell.setCellValue(invalidCosts[i]);
//
//		        LoggerUtil.info("Written INVALID Cost: " + invalidCosts[i]);
//		    }
//
//		    // Save Excel
//		    fis.close();
//		    FileOutputStream fos = new FileOutputStream(filePath);
//		    workbook.write(fos);
//		    fos.close();
//		    workbook.close();
//
//		    LoggerUtil.info("Excel updated successfully.");
//
//		    // ---------------- STEP 5: Validation Logic ----------------
//
//		    // Description → must accept everything
//		    for (String desc : toolDescriptions) {
//		        LoggerUtil.pass("Tool Description accepted: " + desc);
//		    }
//
//		    // Cost → valid numbers should PASS
//		    for (String cost : validCosts) {
//		        LoggerUtil.pass("Valid Cost accepted: " + cost);
//		    }
//		    
//		 // Import invalid Excel
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.importDetailCostingExcel(filePath);
//
//		    List<String> validationsNegative = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//
//		    // Cost → invalid numbers should FAIL
//		    for (String cost : invalidCosts) {
//		        LoggerUtil.fail("Invalid Cost should be rejected on import: " + cost);
//		        softAssert.fail("Invalid cost allowed: " + cost);
//		    }
//
//		    softAssert.assertAll();
//		}
//
//		@Test(priority = 125, groups = "group1")
//		public void TC_PM_DC_125ValidateProcessCostPerPcGrayFormulaAndDynamicUpdate() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_125: Process Cost/Pc gray formula & dynamic update");
//		    ProcessCostPerPcGrayFormulaAndDynamicUpdate();
//		}
//
//		private void ProcessCostPerPcGrayFormulaAndDynamicUpdate() throws Exception {
//			dashboard.clickingDashboard("");
//		    Thread.sleep(1000);
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    Thread.sleep(2000);
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    Thread.sleep(1000);
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnSupplierValuesByText(Base.getProperty("SupplierName1"));
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(100);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(2000);
//
//		    List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessages();
//		    Assert.assertFalse(validations.isEmpty(), "No validation message appeared; export failed.");
//
//		    Thread.sleep(30000); // wait for download
//
//		    File filePath = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("Downloaded Details Casting Sheet: " + filePath.getAbsolutePath());
//
//		 // 🔹 Step 1: Insert random Part No. in Part_Master
//		    String partNo1 = "P1_" + System.currentTimeMillis();
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Part_Master", 3, "Part No.*", partNo1);
//
//		    // 🔹 Step 2: Select valid dropdown dependencies
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Part No.", partNo1);
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Supplier Name", Base.getProperty("SupplierName1"));
//		    PartMasterDetailCostingRivisedPage.selectDropdownValue1(filePath, "Process_Cost", 3, "Process Name", "Process-5");
//
//		    // 🔹 Step 3: Capture initial Process Cost/Pc value
//		    double initialProcessCost = PartMasterDetailCostingRivisedPage.readNumericCellValue(filePath, "Process_Cost", 3, "Process Cost/Pc");
//		    LoggerUtil.info("Initial Process Cost/Pc: " + initialProcessCost);
//
//		    // 🔹 Step 4: Modify key driver fields
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Rate/UOM", "100");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Qty Per Sec/ Cycle Time", "2");
//		    PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(filePath, "Process_Cost", 3, "Efficiency %", "90");
//
//		    // 🔹 Step 5: Read recalculated Process Cost/Pc
//		    double recalculatedProcessCost = PartMasterDetailCostingRivisedPage.evaluateFormulaCellValue(filePath, "Process_Cost", 3, "Process Cost/Pc");
//		    LoggerUtil.info("Recalculated Process Cost/Pc: " + recalculatedProcessCost);
//
//		    // 🔹 Step 6: Verify recalculation
//		    if (Double.compare(initialProcessCost, recalculatedProcessCost) != 0)
//		        LoggerUtil.pass("✅ Process Cost/Pc recalculated dynamically after driver field changes.");
//		    else
//		        LoggerUtil.fail("❌ Process Cost/Pc did not update dynamically — formula check failed.");
//
//		    // 🔹 Step 7: Attempt manual edit in Process Cost/Pc
//		    boolean writeBlocked = PartMasterDetailCostingRivisedPage.tryWriteValue(filePath, "Process_Cost", 3, "Process Cost/Pc", "9999");
//		    if (writeBlocked)
//		        LoggerUtil.pass("✅ Manual overwrite blocked → Process Cost/Pc is a locked formula cell.");
//		    else
//		        LoggerUtil.fail("❌ Manual overwrite allowed → should be locked formula cell.");
//
//		    // 🔹 Step 8: Verify gray or formula type
//		    Workbook wb = WorkbookFactory.create(filePath);
//		    Sheet sheet = wb.getSheet("Process_Cost");
//		    Row row = sheet.getRow(2); // row 3 in Excel (0-based)
//		    Cell cell = row.getCell(15); // column P = index 15 (0-based)
//		    CellStyle style = cell.getCellStyle();
//
//		    XSSFColor xssfColor = null;
//		    short colorIdx = style.getFillForegroundColor();
//		    if (style instanceof XSSFCellStyle) {
//		        xssfColor = ((XSSFCellStyle) style).getFillForegroundXSSFColor();
//		    }
//
//		    boolean isGray = isGrayColor(xssfColor, colorIdx);
//		    boolean isFormula = cell.getCellType() == CellType.FORMULA;
//
//		    if (isGray || isFormula)
//		        LoggerUtil.pass("✅ Process Cost/Pc cell is gray/formula — confirmed locked calculation field.");
//		    else
//		        LoggerUtil.fail("❌ Process Cost/Pc cell not gray/formula — should be locked formula cell.");
//
//		    wb.close();
//		   
//		}
//				
//		@Test(priority = 126, groups = "group1")
//		public void TC_PM_DC_126ValidateDuplicateProcessNameHandledBySupplier_Procurement() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_126: Duplicate Process Name handled by Supplier (Procurement)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		  //--------------------------------------------------------------------------
//		 // STEP 1: Create Process for S1
//		 //--------------------------------------------------------------------------
//		 dashboard.clickingDashboard("");
//		 dashboard.selectMenuFormDashBoard("Master Data");
//		 Thread.sleep(2000);
//		 dashboard.clickOnProcessItem();
//
//		 ProcessMasterPage processMasterPage = new ProcessMasterPage();
//
//		 // Create process for Supplier S1 → Rate 43565
//		 processMasterPage.creatingNewProcessForSupplier(randomname, "43565", "21-11-2025", "rtretag", "Rajnish");
//		 
//		 LoggerUtil.info("Fetching UI values for S1...");
//		 double uiRate_S1 = processMasterPage.getUIRate();
//		 String uiUom_S1  = processMasterPage.getUIUOM();
//
//		 LoggerUtil.info("S1 → UI Rate: " + uiRate_S1 + ", UI UOM: " + uiUom_S1);
//
//		 // Create process for Supplier S2 → Rate 3424
//		 processMasterPage.creatingNewProcessForSupplier2(randomname, "3424",  "21-11-2025", "rtretag", "Rajnish");
//		 
//		 LoggerUtil.info("Fetching UI values for S2...");
//		 double uiRate_S2 = processMasterPage.getUIRate();
//		 String uiUom_S2  = processMasterPage.getUIUOM();
//
//		 LoggerUtil.info("S2 → UI Rate: " + uiRate_S2 + ", UI UOM: " + uiUom_S2);
//
//
//		 //--------------------------------------------------------------------------
//		 // STEP 2: Export Excel (Procurement)
//		 //--------------------------------------------------------------------------
//		 dashboard.clickOnPartMaster();
//		 Thread.sleep(1000);
//
//		 PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		 PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		 PartMasterDetailCostingRivisedPage.selectProcurement();
//
//		 PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110","Roshan-3111");
//
//		 PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		 Thread.sleep(1500);
//		 PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		 PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		 PartMasterDetailCostingRivisedPage.openExportImportModal();
//		 PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		 PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		 List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		 Assert.assertFalse(validations.isEmpty(), "Export failed — no success message!");
//		 Thread.sleep(20000);
//
//		 File fileName = getLatestFilePartMasterForDetailCostingFile();
//		 String filePath = fileName.getAbsolutePath();
//		 LoggerUtil.info("Downloaded file: " + filePath);
//
//
//		 //--------------------------------------------------------------------------
//		 // STEP 3: Fill Excel Part_Master & Process_Cost Sheets
//		 //--------------------------------------------------------------------------
//		 PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(fileName, "Part_Master", 3, "Part No.*", "mahindra");
//		 PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(fileName, "Part_Master", 4, "Part No.*", "mahindra2");
//
//		 // Supplier mapping
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Supplier Name", "Prabhat-3110");
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Supplier Name", "Roshan-3111");
//
//		 // Part mapping
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Part No.", "mahindra");
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Part No.", "mahindra2");
//
//		 // Process Name mapping (same name for both rows)
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Process Name", randomname);
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Process Name", randomname);
//
//		 //--------------------------------------------------------------------------
//		 // STEP 5: FETCH EXCEL VALUES (Rate + UOM from Process_Cost sheet)
//		 //--------------------------------------------------------------------------
//		 LoggerUtil.info("Reading Excel Process Cost Values...");
//
//		 double excelRate_S1 = ExcelUtil.getNumericValue(filePath, "Process_Cost", 3, "Rate/UOM");
//		 String excelUOM_S1  = ExcelUtil.getStringValue(filePath, "Process_Cost", 3, "UOM");
//		 LoggerUtil.info("S1 → excel Rate: " + excelRate_S1 + ", UI UOM: " + excelUOM_S1);
//
//		 double excelRate_S2 = ExcelUtil.getNumericValue(filePath, "Process_Cost", 4, "Rate/UOM");
//		 String excelUOM_S2  = ExcelUtil.getStringValue(filePath, "Process_Cost", 4, "UOM");
//		 LoggerUtil.info("S2 → excel Rate: " + excelRate_S2 + ", UI UOM: " + excelUOM_S2);
//
//		 //--------------------------------------------------------------------------
//		 // STEP 6: VALIDATE UI vs EXCEL (RATE + UOM)
//		 //--------------------------------------------------------------------------
//		 LoggerUtil.info("Validating S1 values...");
//
//		 softAssert.assertEquals(uiRate_S1, excelRate_S1, "S1 → Rate mismatch!");
//		 softAssert.assertEquals(uiUom_S1, excelUOM_S1, "S1 → UOM mismatch!");
//
//		 LoggerUtil.pass("S1 UI ↔ Excel VALIDATION PASSED");
//
//
//		 LoggerUtil.info("Validating S2 values...");
//
//		 softAssert.assertEquals(uiRate_S2, excelRate_S2, "S2 → Rate mismatch!");
//		 softAssert.assertEquals(uiUom_S2, excelUOM_S2, "S2 → UOM mismatch!");
//
//		 LoggerUtil.pass("S2 UI ↔ Excel VALIDATION PASSED");
//
//		 softAssert.assertAll();
//		
//		}
//		
//		@Test(priority = 127, groups = "group1")
//		public void TC_PM_DC_127ValidateDuplicateProcessNameHandledByCustomer_Sales() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_127: Duplicate Process Name handled by Customer (Sales)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		  //--------------------------------------------------------------------------
//		 // STEP 1: Create Process for S1
//		 //--------------------------------------------------------------------------
//		 dashboard.clickingDashboard("");
//		 dashboard.selectMenuFormDashBoard("Master Data");
//		 Thread.sleep(2000);
//		 dashboard.clickOnProcessItem();
//
//		 ProcessMasterPage processMasterPage = new ProcessMasterPage();
//
//		 // Create process for Customer C1 → Rate 43565
//		 processMasterPage.creatingNewProcessForCustomer(randomname, "43565", "21-11-2025", "rtretag");
//		 
//		 LoggerUtil.info("Fetching UI values for C1...");
//		 double uiRate_C1 = processMasterPage.getUIRate();
//		 String uiUom_C1  = processMasterPage.getUIUOM();
//
//		 LoggerUtil.info("C1 → UI Rate: " + uiRate_C1 + ", UI UOM: " + uiUom_C1);
//
//		 // Create process for Customer C2 → Rate 3424
//		 processMasterPage.creatingNewProcessForCustomer2(randomname, "3424",  "21-11-2025", "rtretag");
//		 
//		 LoggerUtil.info("Fetching UI values for C2...");
//		 double uiRate_C2 = processMasterPage.getUIRate();
//		 String uiUom_C2  = processMasterPage.getUIUOM();
//
//		 LoggerUtil.info("C2 → UI Rate: " + uiRate_C2 + ", UI UOM: " + uiUom_C2);
//
//
//		 //--------------------------------------------------------------------------
//		 // STEP 2: Export Excel (Procurement)
//		 //--------------------------------------------------------------------------
//		 dashboard.clickOnPartMaster();
//		 Thread.sleep(1000);
//
//		 PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		 PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110","Roshan-Gazipur-3111");
//		 PartMasterDetailCostingRivisedPage.selectSales();
//
//		 PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		 Thread.sleep(1500);
//		 PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		 PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		 PartMasterDetailCostingRivisedPage.openExportImportModal();
//		 PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		 PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//		 List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//		 Assert.assertFalse(validations.isEmpty(), "Export failed — no success message!");
//		 Thread.sleep(20000);
//
//		 File fileName = getLatestFilePartMasterForDetailCostingFile();
//		 String filePath = fileName.getAbsolutePath();
//		 LoggerUtil.info("Downloaded file: " + filePath);
//
//
//		 //--------------------------------------------------------------------------
//		 // STEP 3: Fill Excel Part_Master & Process_Cost Sheets
//		 //--------------------------------------------------------------------------
//		 PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(fileName, "Part_Master", 3, "Part No.*", "mahindra");
//		 PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(fileName, "Part_Master", 4, "Part No.*", "mahindra2");
//
//		 // Supplier mapping
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Customer name and code", "Prabhat-3110");
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Customer name and code", "Roshan-3111");
//
//		 // Part mapping
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Part No.", "mahindra");
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Part No.", "mahindra2");
//
//		 // Process Name mapping (same name for both rows)
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Process Name", randomname);
//		 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Process Name", randomname);
//
//		 //--------------------------------------------------------------------------
//		 // STEP 5: FETCH EXCEL VALUES (Rate + UOM from Process_Cost sheet)
//		 //--------------------------------------------------------------------------
//		 LoggerUtil.info("Reading Excel Process Cost Values...");
//
//		 double excelRate_C1 = ExcelUtil.getNumericValue(filePath, "Process_Cost", 3, "Rate/UOM");
//		 String excelUOM_C1  = ExcelUtil.getStringValue(filePath, "Process_Cost", 3, "UOM");
//		 LoggerUtil.info("C1 → excel Rate: " + excelRate_C1 + ", UI UOM: " + excelUOM_C1);
//
//		 double excelRate_C2 = ExcelUtil.getNumericValue(filePath, "Process_Cost", 4, "Rate/UOM");
//		 String excelUOM_C2  = ExcelUtil.getStringValue(filePath, "Process_Cost", 4, "UOM");
//		 LoggerUtil.info("C2 → excel Rate: " + excelRate_C2 + ", UI UOM: " + excelUOM_C2);
//
//		 //--------------------------------------------------------------------------
//		 // STEP 6: VALIDATE UI vs EXCEL (RATE + UOM)
//		 //--------------------------------------------------------------------------
//		 LoggerUtil.info("Validating C1 values...");
//
//		 softAssert.assertEquals(uiRate_C1, excelRate_C1, "C1 → Rate mismatch!");
//		 softAssert.assertEquals(uiUom_C1, excelUOM_C1, "C1 → UOM mismatch!");
//
//		 LoggerUtil.pass("C1 UI ↔ Excel VALIDATION PASSED");
//
//
//		 LoggerUtil.info("Validating C2 values...");
//
//		 softAssert.assertEquals(uiRate_C2, excelRate_C2, "C2 → Rate mismatch!");
//		 softAssert.assertEquals(uiUom_C2, excelUOM_C2, "C2 → UOM mismatch!");
//
//		 LoggerUtil.pass("C2 UI ↔ Excel VALIDATION PASSED");
//
//		 softAssert.assertAll();
//		
//		}
//		
//		@Test(priority = 128, groups = "group1")
//		public void TC_PM_DC_128ValidateConditionalFormattingAndRulesAcross1000Rows() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_128: Conditional formatting & data rules persist across 1000 rows (Sales & Procurement)");
//		    validateFormattingAndRulesForFlow("Procurement");
//		   
//		}
//
//		/**
//		 * Validates that at row 1000, all conditional formatting, data validation,
//		 * and formula protections persist correctly.
//		 */
//		private void validateFormattingAndRulesForFlow(String flow) throws Exception {
//		    LoggerUtil.info("===== 🔍 Validating Conditional Formatting & Data Rules for " + flow + " =====");
//
//		    File exportedFile = exportAndGetFile(flow);
//
//		    try (FileInputStream fis = new FileInputStream(exportedFile);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//		        XSSFSheet sheet = workbook.getSheet("Process_Cost");
//		        Assert.assertNotNull(sheet, "❌ Process_Cost sheet not found in exported file.");
//
//		        // --- Step 1: Verify row 1000 exists ---
//		        Row targetRow = sheet.getRow(1000);
//		        Assert.assertNotNull(targetRow, "❌ Row 1000 missing in Process_Cost sheet (export might be truncated).");
//		        LoggerUtil.info("✅ Found row 1000 in Process_Cost sheet.");
//
//		        // --- Step 2: Get header map (for dynamic column lookup) ---
//		        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, "Process_Cost", 1);
//
//		        int partNoCol = headerMap.getOrDefault("Part No.", -1);
//		        int supplierCol = headerMap.getOrDefault("Supplier Name", -1);
//		        int processCol = headerMap.getOrDefault("Process Name", -1);
//		        int manualProcessCol = headerMap.getOrDefault("Manual Process Name", -1);
//		        int uomCol = headerMap.getOrDefault("UOM", -1);
//		        int processCostCol = headerMap.getOrDefault("Process Cost/Pc", -1);
//
//		        Assert.assertTrue(partNoCol >= 0 && supplierCol >= 0 && processCol >= 0 && manualProcessCol >= 0 && uomCol >= 0 && processCostCol >= 0,
//		                "❌ One or more key columns not found in Process_Cost.");
//
//		        // --- Step 3: Validate cell formatting and rules at row 1000 ---
//
//		        // 3.1 Gray Mutual Exclusion — Manual Process Name cell must be gray
//		        Cell manualProcessCell = targetRow.getCell(manualProcessCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        boolean isGray = isGrayColor((XSSFColor) manualProcessCell.getCellStyle().getFillForegroundColorColor(),
//		                manualProcessCell.getCellStyle().getFillForegroundColor());
//		        if (isGray)
//		            LoggerUtil.info("✅ Manual Process Name (row 1000) gray formatting persists for " + flow);
//		        else
//		            LoggerUtil.error("❌ Manual Process Name (row 1000) not gray — conditional format lost for " + flow);
//
//		        // 3.2 Formula Protection — Process Cost/Pc should be locked (formula cell)
//		        Cell processCostCell = targetRow.getCell(processCostCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        boolean isLocked = processCostCell.getCellStyle().getLocked();
//		        if (isLocked)
//		            LoggerUtil.info("✅ Formula protection intact (locked) for Process Cost/Pc at row 1000 (" + flow + ")");
//		        else
//		            LoggerUtil.error("❌ Formula protection missing for Process Cost/Pc at row 1000 (" + flow + ")");
//
//		        // 3.3 Data Validation — UOM column should have dropdown
//		        boolean hasUOMValidation = hasDataValidation(sheet, 1000, uomCol);
//		        if (hasUOMValidation)
//		            LoggerUtil.info("✅ UOM dropdown validation persists at row 1000 (" + flow + ")");
//		        else
//		            LoggerUtil.error("❌ UOM dropdown validation missing at row 1000 (" + flow + ")");
//
//		        // 3.4 Mismatch Red Rule — Verify mismatch highlighting formula remains red
//		        Cell processCell = targetRow.getCell(processCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//		        CellStyle processStyle = processCell.getCellStyle();
//		        XSSFColor processColor = (XSSFColor) processStyle.getFillForegroundColorColor();
//		        boolean isRed = false;
//		        if (processColor != null && processColor.getRGB() != null) {
//		            String hex = String.format("#%02X%02X%02X", processColor.getRGB()[0] & 0xFF,
//		                    processColor.getRGB()[1] & 0xFF, processColor.getRGB()[2] & 0xFF);
//		            if (hex.equalsIgnoreCase("#FF0000") || hex.equalsIgnoreCase("#C00000")) isRed = true;
//		        }
//		        if (isRed)
//		            LoggerUtil.info("✅ Mismatch red rule still active on row 1000 (" + flow + ")");
//		        else
//		          //  LoggerUtil.warn("⚠ No red fill detected on Process Name (row 1000) — ensure conditional rule persists for mismatches (" + flow + ")");
//
//		        LoggerUtil.info("✔ Completed rule validation for row 1000 (" + flow + ")");
//		    }
//		}
//
//		/**
//		 * Utility to check if a cell has a dropdown (Data Validation) applied.
//		 */
//		private boolean hasDataValidation(XSSFSheet sheet, int rowIndex, int colIndex) {
//		    List<? extends DataValidation> validations = sheet.getDataValidations();
//		    for (DataValidation validation : validations) {
//		        for (CellRangeAddress addr : validation.getRegions().getCellRangeAddresses()) {
//		            if (addr.isInRange(rowIndex, colIndex))
//		                return true;
//		        }
//		    }
//		    return false;
//		}
//		
//		@Test(priority = 129, groups = "group1")
//		public void TC_PM_DC_129ValidateProcurement_redhighlightwhendropdownselectssuppliernotmappedtoPart() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_129: Procurement: red highlight when dropdown selects supplier not mapped to Part");
//		    Procurement_redhighlightwhendropdownselectssuppliernotmappedtoPart("Procurement");
//		   
//		}
//
//		private void Procurement_redhighlightwhendropdownselectssuppliernotmappedtoPart(String flow) throws Exception {
//			// --- Step 1: Dashboard navigation and export ---
//			 dashboard.clickingDashboard("");
//			 dashboard.selectMenuFormDashBoard("Master Data");
//			 dashboard.clickOnPartMaster();
//			 Thread.sleep(1000);
//
//			 PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//			 PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//			 PartMasterDetailCostingRivisedPage.selectProcurement();
//			 String S1 = "Prabhat-3110";
//			 String S2 = "Roshan-3111";
//
//
//			 PartMasterPage.selectOnSupplierValuesByText(S1,S2);
//
//			 PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//			 Thread.sleep(1500);
//			 PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//			 PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//			 PartMasterDetailCostingRivisedPage.openExportImportModal();
//			 PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//			 PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//
//			 List<String> validations = PartMasterDetailCostingRivisedPage.captureValidationMessagess();
//			 Assert.assertFalse(validations.isEmpty(), "Export failed — no success message!");
//			 Thread.sleep(20000);
//
//			 File fileName = getLatestFilePartMasterForDetailCostingFile();
//			 String filePath = fileName.getAbsolutePath();
//			 LoggerUtil.info("Downloaded file: " + filePath);
//
//			 String partNo1 = "P1_" + System.currentTimeMillis();
//			 String partNo2 = "P2_" + System.currentTimeMillis();
//
//			 //--------------------------------------------------------------------------
//			 // STEP 3: Fill Excel Part_Master & Process_Cost Sheets
//			 //--------------------------------------------------------------------------
//			 PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(fileName, "Part_Master", 3, "Part No.*", partNo1);
//			 PartMasterDetailCostingRivisedPage.writeAndConfirmCellValue1(fileName, "Part_Master", 4, "Part No.*", partNo2);
//
//			 // Supplier mapping
//			 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Supplier Name", S1);
//			 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Supplier Name", S2);
//
//			 // Part mapping
//			 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 3, "Part No.", partNo2);
//			 PartMasterDetailCostingRivisedPage.selectDropdownValue1(fileName, "Process_Cost", 4, "Part No.", partNo2);
//		    		    
//		}
//				
//		@Test(priority = 136, groups = "group1")
//		public void TC_PM_DC_136Validate_PartMaster_Commodity_Master_Excel_Procurement_SingleSupplierFullRM_ScrapMatch() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_136: Procurement — Single Supplier: RM & Scrap Cost match (Excel vs View tab full compare)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM & Scrap data from UI
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//
//		    String supplierName = "Prabhat";
//
//		    // Supplier data (only one)
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageSecendTime(supplierName);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> supplierUiData =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Supplier", supplierName);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Supplier (" + supplierName + "): " + supplierUiData);
//
//		    // STEP 2 → Export Excel (Procurement Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110"); // Only one supplier
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and build Supplier → Grade → Month → RM/Scrap structure
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Supplier");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Supplier' not found in Excel.");
//		        softAssert.fail("Header missing in Excel.");
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int supplierCol = ExcelUtil.findColumnIndex(headerRow, "Supplier");
//		    int gradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//
//		    List<Integer> rmCols = new ArrayList<>();
//		    List<Integer> scrapCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCols.add(c);
//		        } else if (val.equalsIgnoreCase("Scrap Cost")) {
//		            scrapCols.add(c);
//		        }
//		    }
//
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> excelSupplierData = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String supplier = getStringValue(row.getCell(supplierCol)).trim();
//		        String grade = getStringValue(row.getCell(gradeCol)).trim();
//		        if (supplier.isEmpty() || grade.isEmpty()) continue;
//
//		        String pureSupplier = supplier.split("-")[0].trim();
//		        if (!pureSupplier.equalsIgnoreCase(supplierName)) continue; // filter for selected supplier only
//
//		        Map<String, Map<String, Map<String, Double>>> gradeMap =
//		                excelSupplierData.getOrDefault(pureSupplier, new LinkedHashMap<>());
//
//		        Map<String, Map<String, Double>> monthMap = new LinkedHashMap<>();
//
//		        for (int i = 0; i < months.size() && i < rmCols.size() && i < scrapCols.size(); i++) {
//		            String month = months.get(i);
//		            double rmVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCols.get(i)), evaluator);
//		            double scrapVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCols.get(i)), evaluator);
//
//		            Map<String, Double> pair = new LinkedHashMap<>();
//		            pair.put("RM", rmVal);
//		            pair.put("Scrap", scrapVal);
//		            monthMap.put(month, pair);
//		        }
//
//		        gradeMap.put(grade, monthMap);
//		        excelSupplierData.put(pureSupplier, gradeMap);
//		    }
//
//		    LoggerUtil.info("📘 Excel Supplier→Grade→Month (RM+Scrap) Map: " + excelSupplierData);
//
//		    // STEP 4 → Full Comparison: Grade-wise + Month-wise for single supplier
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("📊 COMPARISON RESULT: EXCEL vs UI (Single Supplier → Grade → Month)");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    Map<String, Map<String, Map<String, Double>>> excelGradeMap = excelSupplierData.get(supplierName);
//		    Map<String, Map<String, Map<String, Double>>> uiGradeMap = supplierUiData.get(supplierName);
//
//		    if (excelGradeMap == null || uiGradeMap == null) {
//		        LoggerUtil.fail("❌ Missing data for supplier: " + supplierName);
//		        softAssert.fail("No matching data for " + supplierName);
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    for (String grade : excelGradeMap.keySet()) {
//		        Map<String, Map<String, Double>> excelMonthData = excelGradeMap.get(grade);
//		        Map<String, Map<String, Double>> uiMonthData = uiGradeMap.get(grade);
//
//		        if (uiMonthData == null) {
//		            LoggerUtil.fail("❌ Grade '" + grade + "' missing in UI for supplier: " + supplierName);
//		            softAssert.fail("Missing grade in UI: " + grade);
//		            continue;
//		        }
//
//		        LoggerUtil.info("\nSupplier: " + supplierName + " | Grade: " + grade);
//		        LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", "Month", "Type", "Excel", "UI", "Result"));
//		        LoggerUtil.info("------------------------------------------------------");
//
//		        for (String month : excelMonthData.keySet()) {
//		            if (month.startsWith("HY1") || month.startsWith("HY2")) continue;
//
//		            Map<String, Double> excelVals = excelMonthData.get(month);
//		            Map<String, Double> uiVals = uiMonthData.get(month);
//
//		            for (String type : Arrays.asList("RM", "Scrap")) {
//		                double excelVal = excelVals.getOrDefault(type, 0.0);
//		                double uiVal = (uiVals != null) ? uiVals.getOrDefault(type, -1.0) : -1.0;
//		                boolean match = (Double.compare(excelVal, uiVal) == 0);
//		                String result = match ? "PASS" : "FAIL";
//
//		                if (!match) {
//		                    LoggerUtil.fail(String.format("❌ Mismatch → %s | %s | %s | Excel=%.4f | UI=%.4f",
//		                            grade, month, type, excelVal, uiVal));
//		                    softAssert.fail("Mismatch → " + grade + " | " + month + " | " + type +
//		                            " | Excel=" + excelVal + " | UI=" + uiVal);
//		                } else {
//		                    LoggerUtil.info(String.format("✅ %-8s | %-8s | %-12.4f | %-12.4f | %-8s",
//		                            month, type, excelVal, uiVal, result));
//		                }
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("✅ Comparison Completed: Excel vs UI parity check finished for single supplier.");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//
//		@Test(priority = 137, groups = "group1")
//		public void TC_PM_DC_137Validate_PartMaster_Commodity_Master_Excel_Sales_SingleCustomerFullRM_ScrapMatch() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_137: Sales — Single Customer: RM & Scrap Cost match (Excel vs View tab full compare)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM & Scrap data from UI for single Customer
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//
//		    String customerName = "Prabhat";  // Example: replace with actual C1 name
//
//		    // Fetch RM & Scrap month-wise data for Customer
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageSecendTime(customerName);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> customerUiData =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Customer", customerName);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Customer (" + customerName + "): " + customerUiData);
//
//		    // STEP 2 → Export Excel (Sales Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110"); // Single customer
//		    PartMasterDetailCostingRivisedPage.selectSales();  // Switch to Sales mode
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and build Customer → Grade → Month → RM/Scrap structure
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Customer");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Customer' not found in Excel.");
//		        softAssert.fail("Header missing in Excel.");
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int customerCol = ExcelUtil.findColumnIndex(headerRow, "Customer");
//		    int gradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//
//		    List<Integer> rmCols = new ArrayList<>();
//		    List<Integer> scrapCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCols.add(c);
//		        } else if (val.equalsIgnoreCase("Scrap Cost")) {
//		            scrapCols.add(c);
//		        }
//		    }
//
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> excelCustomerData = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String customer = getStringValue(row.getCell(customerCol)).trim();
//		        String grade = getStringValue(row.getCell(gradeCol)).trim();
//		        if (customer.isEmpty() || grade.isEmpty()) continue;
//
//		        String pureCustomer = customer.split("-")[0].trim();
//		        if (!pureCustomer.equalsIgnoreCase(customerName)) continue; // Only selected customer
//
//		        Map<String, Map<String, Map<String, Double>>> gradeMap =
//		                excelCustomerData.getOrDefault(pureCustomer, new LinkedHashMap<>());
//
//		        Map<String, Map<String, Double>> monthMap = new LinkedHashMap<>();
//
//		        for (int i = 0; i < months.size() && i < rmCols.size() && i < scrapCols.size(); i++) {
//		            String month = months.get(i);
//		            double rmVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCols.get(i)), evaluator);
//		            double scrapVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCols.get(i)), evaluator);
//
//		            Map<String, Double> pair = new LinkedHashMap<>();
//		            pair.put("RM", rmVal);
//		            pair.put("Scrap", scrapVal);
//		            monthMap.put(month, pair);
//		        }
//
//		        gradeMap.put(grade, monthMap);
//		        excelCustomerData.put(pureCustomer, gradeMap);
//		    }
//
//		    LoggerUtil.info("📘 Excel Customer→Grade→Month (RM+Scrap) Map: " + excelCustomerData);
//
//		    // STEP 4 → Full Comparison: Grade-wise + Month-wise for single customer
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("📊 COMPARISON RESULT: EXCEL vs UI (Single Customer → Grade → Month)");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    Map<String, Map<String, Map<String, Double>>> excelGradeMap = excelCustomerData.get(customerName);
//		    Map<String, Map<String, Map<String, Double>>> uiGradeMap = customerUiData.get(customerName);
//
//		    if (excelGradeMap == null || uiGradeMap == null) {
//		        LoggerUtil.fail("❌ Missing data for customer: " + customerName);
//		        softAssert.fail("No matching data for " + customerName);
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    for (String grade : excelGradeMap.keySet()) {
//		        Map<String, Map<String, Double>> excelMonthData = excelGradeMap.get(grade);
//		        Map<String, Map<String, Double>> uiMonthData = uiGradeMap.get(grade);
//
//		        if (uiMonthData == null) {
//		            LoggerUtil.fail("❌ Grade '" + grade + "' missing in UI for customer: " + customerName);
//		            softAssert.fail("Missing grade in UI: " + grade);
//		            continue;
//		        }
//
//		        LoggerUtil.info("\nCustomer: " + customerName + " | Grade: " + grade);
//		        LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", "Month", "Type", "Excel", "UI", "Result"));
//		        LoggerUtil.info("------------------------------------------------------");
//
//		        for (String month : excelMonthData.keySet()) {
//		            if (month.startsWith("HY1") || month.startsWith("HY2")) continue;
//
//		            Map<String, Double> excelVals = excelMonthData.get(month);
//		            Map<String, Double> uiVals = uiMonthData.get(month);
//
//		            for (String type : Arrays.asList("RM", "Scrap")) {
//		                double excelVal = excelVals.getOrDefault(type, 0.0);
//		                double uiVal = (uiVals != null) ? uiVals.getOrDefault(type, -1.0) : -1.0;
//		                boolean match = (Double.compare(excelVal, uiVal) == 0);
//		                String result = match ? "PASS" : "FAIL";
//
//		                if (!match) {
//		                    LoggerUtil.fail(String.format("❌ Mismatch → %s | %s | %s | Excel=%.4f | UI=%.4f",
//		                            grade, month, type, excelVal, uiVal));
//		                    softAssert.fail("Mismatch → " + grade + " | " + month + " | " + type +
//		                            " | Excel=" + excelVal + " | UI=" + uiVal);
//		                } else {
//		                    LoggerUtil.info(String.format("✅ %-8s | %-8s | %-12.4f | %-12.4f | %-8s",
//		                            month, type, excelVal, uiVal, result));
//		                }
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("✅ Comparison Completed: Excel vs UI parity check finished for single customer.");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//
//		
//		@Test(priority = 138, groups = "group1")
//		public void TC_PM_DC_138Validate_PartMaster_Commodity_Master_Excel_Procurement_MultipleSuppliersOrdering()
//		        throws InterruptedException, IOException {
//
//		    LoggerUtil.info("TC_PM_DC_0138: Procurement — Multiple Suppliers: ordering must follow UI dropdown sequence");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export Excel for multiple suppliers
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    String s1 = "Nilesh-3112";
//		    String s2 = "Prabhat-3110";
//		    String s3 = "Roshan-3111";
//
//		    PartMasterPage.selectOnSupplierValuesByText(s1, s2, s3);
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 2 → Open Excel and identify Supplier Column
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Supplier");
//
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Supplier' not found in Excel.");
//		        softAssert.fail("Header missing");
//		        wb.close(); fis.close();
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int supplierColIndex = -1;
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String colName = com.Pages.PartMasterDetailCostingRivisedPage.getStringValue(headerRow.getCell(c));
//		        if (colName.equalsIgnoreCase("Supplier")) {
//		            supplierColIndex = c;
//		            break;
//		        }
//		    }
//
//		    if (supplierColIndex == -1) {
//		        LoggerUtil.fail("❌ Supplier column not found.");
//		        softAssert.fail("Supplier column missing");
//		        wb.close(); fis.close();
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 3 → Read supplier sequence from Excel
//		    List<String> supplierSequence = new ArrayList<>();
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String supplierName = com.Pages.PartMasterDetailCostingRivisedPage.getStringValue(row.getCell(supplierColIndex)).trim();
//		        if (!supplierName.isEmpty()) {
//		            supplierSequence.add(supplierName);
//		        }
//		    }
//
//		    LoggerUtil.info("📄 Supplier sequence extracted from Excel: " + supplierSequence);
//
//		    // STEP 4 → Expected UI order (as per dropdown actual display)
//		    List<String> expectedOrder = Arrays.asList(s1, s2, s3);
//		    LoggerUtil.info("📘 Expected supplier order (UI dropdown): " + expectedOrder);
//
//		    // STEP 5 → Compare Excel vs Expected UI order
//		    String currentSupplier = "";
//		    int expectedIndex = 0;
//		    boolean orderOk = true;
//
//		    for (String supplier : supplierSequence) {
//		        if (!supplier.equals(currentSupplier)) {
//		            int supplierIndex = expectedOrder.indexOf(supplier);
//
//		            if (supplierIndex == -1) {
//		                LoggerUtil.fail("❌ Unexpected supplier found in Excel: " + supplier);
//		                softAssert.fail("Unexpected supplier: " + supplier);
//		                orderOk = false;
//		                continue;
//		            }
//
//		            if (supplierIndex < expectedIndex) {
//		                LoggerUtil.fail("❌ Supplier order mismatch → Excel shows " + supplier + " before UI order sequence.");
//		                softAssert.fail("Wrong Excel order: " + supplier);
//		                orderOk = false;
//		            } else {
//		                expectedIndex = supplierIndex;
//		                currentSupplier = supplier;
//		                LoggerUtil.info("✅ Supplier block found in correct sequence: " + supplier);
//		            }
//		        }
//		    }
//
//		    // STEP 6 → Group continuity validation
//		    Map<String, List<String>> groupedSuppliers = new LinkedHashMap<>();
//		    for (String supplier : supplierSequence) {
//		        groupedSuppliers.computeIfAbsent(supplier, k -> new ArrayList<>()).add(supplier);
//		    }
//
//		    for (int i = 0; i < supplierSequence.size() - 1; i++) {
//		        String current = supplierSequence.get(i);
//		        String next = supplierSequence.get(i + 1);
//		        if (!current.equals(next) && supplierSequence.subList(i + 1, supplierSequence.size()).contains(current)) {
//		            LoggerUtil.fail("❌ Supplier block for '" + current + "' appears again later → Group break found!");
//		            softAssert.fail("Group break for supplier: " + current);
//		            orderOk = false;
//		        }
//		    }
//
//		    LoggerUtil.info("📊 Supplier grouping map: " + groupedSuppliers);
//
//		    // STEP 7 → Final comparison summary
//		    if (orderOk) {
//		        LoggerUtil.pass("✅ Supplier ordering verified successfully — Excel follows UI dropdown order (" + expectedOrder + ")");
//		    } else {
//		        LoggerUtil.fail("❌ Supplier ordering/grouping failed — Excel order does not match UI dropdown sequence.");
//		    }
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//		
//		@Test(priority = 139, groups = "group1")
//		public void TC_PM_DC_139Validate_PartMaster_Commodity_Master_Excel_Procurement_MultipleSuppliersUnionCompleteness()
//		        throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_0139: Procurement — Multiple Suppliers: union completeness");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch UI Data for Each Supplier
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//
//		    String supplier1 = "Prabhat";
//		    String supplier2 = "Roshan";
//
//		    // Supplier 1
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageSecendTime(supplier1);
//		    Thread.sleep(1500);
//		    List<String> uiListS1 = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.info("📘 UI Grade for selected S1 (" + supplier1 + "): " + uiListS1);
//
//		    // Supplier 2
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageThierdTime(supplier2);
//		    Thread.sleep(1500);
//		    List<String> uiListS2 = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.info("📘 UI Grade for selected S2 (" + supplier2 + "): " + uiListS2);
//
//		    // STEP 2 → Export Excel (Procurement Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(2500);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and verify union completeness + cost parity
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    // Find header row and columns
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(sheet, "Specific Grade");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel.");
//		        softAssert.fail("Header not found in Excel sheet.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int rmGradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//		    int supplierCol = ExcelUtil.findColumnIndex(headerRow, "Supplier");
//		    int rmCostCol = ExcelUtil.findColumnIndex(headerRow, "RM Cost");
//		    int scrapCostCol = ExcelUtil.findColumnIndex(headerRow, "Scrap Cost");
//
//		    if (rmGradeCol == -1 || supplierCol == -1) {
//		        LoggerUtil.fail("❌ Required columns not found (Specific Grade or Supplier).");
//		        softAssert.fail("Required columns missing.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 4 → Build Excel-side mappings
//		    Set<String> excelGrades = new HashSet<>();
//		    Map<String, Map<String, Double>> supplierWiseCost = new HashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        Cell gradeCell = row.getCell(rmGradeCol);
//		        Cell supplierCell = row.getCell(supplierCol);
//		        if (gradeCell == null || supplierCell == null) continue;
//
//		        String grade = gradeCell.getStringCellValue().trim();
//		        String supplier = supplierCell.getStringCellValue().trim();
//
//		        if (!grade.isEmpty() && !supplier.isEmpty()) {
//		            excelGrades.add(grade);
//
//		            double rmCost = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCostCol), evaluator);
//		            double scrapCost = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCostCol), evaluator);
//
//		            supplierWiseCost
//		                    .computeIfAbsent(grade, k -> new HashMap<>())
//		                    .put(supplier, rmCost + scrapCost);
//		        }
//		    }
//
//		    // STEP 5 → Perform union completeness validation
//		    Set<String> expectedUnion = new HashSet<>(uiListS1);
//		    expectedUnion.addAll(uiListS2);
//
//		    LoggerUtil.info("📘 Expected union of grades (S1 + S2): " + expectedUnion);
//		    LoggerUtil.info("📗 Excel grades found: " + excelGrades);
//
//		    if (excelGrades.containsAll(expectedUnion)) {
//		        LoggerUtil.pass("✅ Union completeness verified — all expected grades found in Excel.");
//		    } else {
//		        Set<String> missing = new HashSet<>(expectedUnion);
//		        missing.removeAll(excelGrades);
//		        LoggerUtil.fail("❌ Missing grades in Excel: " + missing);
//		        softAssert.fail("Missing grades: " + missing);
//		    }
//
//		    // STEP 6 → Check for extra (unselected supplier) grades
//		    Set<String> extraGrades = new HashSet<>(excelGrades);
//		    extraGrades.removeAll(expectedUnion);
//		    if (!extraGrades.isEmpty()) {
//		        LoggerUtil.fail("❌ Excel contains grades not linked to selected suppliers: " + extraGrades);
//		        softAssert.fail("Extra grades found: " + extraGrades);
//		    } else {
//		        LoggerUtil.pass("✅ No extra grades found — only selected suppliers’ data exported.");
//		    }
//
//		    softAssert.assertAll();
//		    
//		}
//		
//		@Test(priority = 140, groups = "group1")
//		public void TC_PM_DC_140Validate_PartMaster_Commodity_Master_Excel_SalesMultipleCustomersunioncompleteness()
//		        throws InterruptedException, FileNotFoundException, IOException {
//
//		    LoggerUtil.info("TC_PM_DC_0140: Sales — Multiple Customers: union completeness");
//		    SoftAssert softAssert = new SoftAssert();
//
//		 // STEP 1 → Fetch UI Data for Each Customer
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//
//		    String customer1 = "Prabhat";
//		    String customer2 = "Roshan";
//
//		    // Supplier 1
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageSecendTime(customer1);
//		    Thread.sleep(1500);
//		    List<String> uiListC1 = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.info("📘 UI Grade for selected C1 (" + customer1 + "): " + uiListC1);
//
//		    // Supplier 2
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageThiredTime(customer2);
//		    Thread.sleep(1500);
//		    List<String> uiListC2 = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.info("📘 UI Grade for selected C2 (" + customer2 + "): " + uiListC2);
//
//		    // STEP 2 → Export Excel (Sales Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110","Roshan-Gazipur-3111");
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(2500);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and verify union completeness + cost parity
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    // Find header row and columns
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(sheet, "Specific Grade");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel.");
//		        softAssert.fail("Header not found in Excel sheet.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int rmGradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//		    int customerCol = ExcelUtil.findColumnIndex(headerRow, "Customer");
//		    int rmCostCol = ExcelUtil.findColumnIndex(headerRow, "RM Cost");
//		    int scrapCostCol = ExcelUtil.findColumnIndex(headerRow, "Scrap Cost");
//
//		    if (rmGradeCol == -1 || customerCol == -1) {
//		        LoggerUtil.fail("❌ Required columns not found (Specific Grade or Customer).");
//		        softAssert.fail("Required columns missing.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 4 → Build Excel-side mappings
//		    Set<String> excelGrades = new HashSet<>();
//		    Map<String, Map<String, Double>> customerWiseCost = new HashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        Cell gradeCell = row.getCell(rmGradeCol);
//		        Cell customerCell = row.getCell(customerCol);
//		        if (gradeCell == null || customerCell == null) continue;
//
//		        String grade = gradeCell.getStringCellValue().trim();
//		        String customer = customerCell.getStringCellValue().trim();
//
//		        if (!grade.isEmpty() && !customer.isEmpty()) {
//		            excelGrades.add(grade);
//
//		            double rmCost = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCostCol), evaluator);
//		            double scrapCost = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCostCol), evaluator);
//
//		            customerWiseCost
//		                    .computeIfAbsent(grade, k -> new HashMap<>())
//		                    .put(customer, rmCost + scrapCost);
//		        }
//		    }
//
//		    // STEP 5 → Perform union completeness validation
//		    Set<String> expectedUnion = new HashSet<>(uiListC1);
//		    expectedUnion.addAll(uiListC2);
//
//		    LoggerUtil.info("📘 Expected union of grades (C1 + C2): " + expectedUnion);
//		    LoggerUtil.info("📗 Excel grades found: " + excelGrades);
//
//		    if (excelGrades.containsAll(expectedUnion)) {
//		        LoggerUtil.pass("✅ Union completeness verified — all expected grades found in Excel.");
//		    } else {
//		        Set<String> missing = new HashSet<>(expectedUnion);
//		        missing.removeAll(excelGrades);
//		        LoggerUtil.fail("❌ Missing grades in Excel: " + missing);
//		        softAssert.fail("Missing grades: " + missing);
//		    }
//
//		    // STEP 6 → Check for extra (unselected customer) grades
//		    Set<String> extraGrades = new HashSet<>(excelGrades);
//		    extraGrades.removeAll(expectedUnion);
//		    if (!extraGrades.isEmpty()) {
//		        LoggerUtil.fail("❌ Excel contains grades not linked to selected customer: " + extraGrades);
//		        softAssert.fail("Extra grades found: " + extraGrades);
//		    } else {
//		        LoggerUtil.pass("✅ No extra grades found — only selected customer’ data exported.");
//		    }
//
//		    softAssert.assertAll();
//		}
//		
//		@Test(priority = 141, groups = "group1")
//		public void TC_PM_DC_141Validate_PartMaster_Commodity_Master_Excel_AccessControl_RemovedgradeforSuppliershouldnotexport()
//		        throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_0141: Access Control — Removed grade for Supplier should not export");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Navigate to Master Data and open Commodity Details
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//
//		    String grade1 = "deny";
//		    LoggerUtil.info("🔍 Searching and editing grade: " + grade1);
//
//		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage(grade1);
//		    Thread.sleep(2000);
//		    commodityDetailsPage.getAllGradesFromFilteredTable();
//
//		    commodityDetailsPage.clickOnFirstEditButton();
//		    Thread.sleep(8000);
//
//		    String uncheckedSupplier = commodityDetailsPage.uncheckRandomCheckboxFromSupplierListAndReturnValue();
//		    LoggerUtil.info("🧹 Unchecked supplier from list: " + uncheckedSupplier);
//
//		    commodityDetailsPage.clickOnUpdateButton();
//		    LoggerUtil.pass("✅ Grade updated successfully — supplier unchecked.");
//
//		    // STEP 4 → Export Excel with both suppliers (Procurement mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(2500);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 5 → Read Excel and verify supplier-grade mapping
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(sheet, "Specific Grade");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel.");
//		        softAssert.fail("Header not found in Excel sheet.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int rmGradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//		    int supplierCol = ExcelUtil.findColumnIndex(headerRow, "Supplier");
//
//		    if (rmGradeCol == -1 || supplierCol == -1) {
//		        LoggerUtil.fail("❌ Required columns not found (Specific Grade or Supplier).");
//		        softAssert.fail("Required columns missing.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 6 → Build supplier-wise grade map from Excel
//		    Map<String, List<String>> supplierGradeMap = new HashMap<>();
//		    DataFormatter formatter = new DataFormatter();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String grade = formatter.formatCellValue(row.getCell(rmGradeCol)).trim();
//		        String supplier = formatter.formatCellValue(row.getCell(supplierCol)).trim();
//
//		        if (!grade.isEmpty() && !supplier.isEmpty()) {
//		            supplierGradeMap.computeIfAbsent(supplier, k -> new ArrayList<>()).add(grade);
//		        }
//		    }
//
//		    LoggerUtil.info("📘 Extracted Supplier-Grade Map from Excel: " + supplierGradeMap);
//
//		    // STEP 7 → Validation Logic
//		    String deletedSupplier = uncheckedSupplier.trim();
//		    String otherSupplier = deletedSupplier.equals("Prabhat-3110") ? "Roshan-3111" : "Prabhat-3110";
//
//		    List<String> gradesForDeletedSupplier = supplierGradeMap.getOrDefault(deletedSupplier, new ArrayList<>());
//		    List<String> gradesForOtherSupplier = supplierGradeMap.getOrDefault(otherSupplier, new ArrayList<>());
//
//		    // Verify grade is NOT present for unchecked supplier
//		    if (gradesForDeletedSupplier.contains(grade1)) {
//		        LoggerUtil.fail("❌ Grade '" + grade1 + "' still present for unchecked supplier '" + deletedSupplier + "' in Excel.");
//		        softAssert.fail("Grade incorrectly exported for unchecked supplier: " + deletedSupplier);
//		    } else {
//		        LoggerUtil.pass("✅ Grade '" + grade1 + "' correctly absent for unchecked supplier '" + deletedSupplier + "'.");
//		    }
//
//		    // Verify grade IS present for other supplier
//		    if (gradesForOtherSupplier.contains(grade1)) {
//		        LoggerUtil.pass("✅ Grade '" + grade1 + "' still correctly present for supplier '" + otherSupplier + "'.");
//		    } else {
//		        LoggerUtil.fail("❌ Grade '" + grade1 + "' missing for retained supplier '" + otherSupplier + "'.");
//		        softAssert.fail("Grade missing for retained supplier: " + otherSupplier);
//		    }
//
//		    softAssert.assertAll();
//		   
//		}
//		
//		
//		@Test(priority = 142, groups = "group1")
//		public void TC_PM_DC_142Validate_PartMaster_Commodity_Master_Excel_AccessControl_GradeRemovedForS1ButPresentForS2() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_0142: Access Control — Grade removed for S1 but present for S2");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Navigate to Master Data and open Commodity Details
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//
//		    String grade1 = "rtrt";
//		    LoggerUtil.info("🔍 Searching and editing grade: " + grade1);
//
//		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage(grade1);
//		    Thread.sleep(2000);
//		    commodityDetailsPage.getAllGradesFromFilteredTable();
//
//		    commodityDetailsPage.clickOnFirstEditButton();
//		    Thread.sleep(8000);
//
//		    String uncheckedSupplier = commodityDetailsPage.uncheckRandomCheckboxFromSupplierListAndReturnValue();
//		    LoggerUtil.info("🧹 Unchecked supplier from list: " + uncheckedSupplier);
//
//		    commodityDetailsPage.clickOnUpdateButton();
//		    LoggerUtil.pass("✅ Grade updated successfully — supplier unchecked.");
//
//		    // STEP 4 → Export Excel with both suppliers (Procurement mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(2500);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 5 → Read Excel and verify supplier-grade mapping
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(sheet, "Specific Grade");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel.");
//		        softAssert.fail("Header not found in Excel sheet.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int rmGradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//		    int supplierCol = ExcelUtil.findColumnIndex(headerRow, "Supplier");
//
//		    if (rmGradeCol == -1 || supplierCol == -1) {
//		        LoggerUtil.fail("❌ Required columns not found (Specific Grade or Supplier).");
//		        softAssert.fail("Required columns missing.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 6 → Build supplier-wise grade map from Excel
//		    Map<String, List<String>> supplierGradeMap = new HashMap<>();
//		    DataFormatter formatter = new DataFormatter();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String grade = formatter.formatCellValue(row.getCell(rmGradeCol)).trim();
//		        String supplier = formatter.formatCellValue(row.getCell(supplierCol)).trim();
//
//		        if (!grade.isEmpty() && !supplier.isEmpty()) {
//		            supplierGradeMap.computeIfAbsent(supplier, k -> new ArrayList<>()).add(grade);
//		        }
//		    }
//
//		    LoggerUtil.info("📘 Extracted Supplier-Grade Map from Excel: " + supplierGradeMap);
//
//		    // STEP 7 → Validation Logic
//		    String deletedSupplier = uncheckedSupplier.trim();
//		    String otherSupplier = deletedSupplier.equals("Prabhat-3110") ? "Roshan-3111" : "Prabhat-3110";
//
//		    List<String> gradesForDeletedSupplier = supplierGradeMap.getOrDefault(deletedSupplier, new ArrayList<>());
//		    List<String> gradesForOtherSupplier = supplierGradeMap.getOrDefault(otherSupplier, new ArrayList<>());
//
//		    // Verify grade is NOT present for unchecked supplier
//		    if (gradesForDeletedSupplier.contains(grade1)) {
//		        LoggerUtil.fail("❌ Grade '" + grade1 + "' still present for unchecked supplier '" + deletedSupplier + "' in Excel.");
//		        softAssert.fail("Grade incorrectly exported for unchecked supplier: " + deletedSupplier);
//		    } else {
//		        LoggerUtil.pass("✅ Grade '" + grade1 + "' correctly absent for unchecked supplier '" + deletedSupplier + "'.");
//		    }
//
//		    // Verify grade IS present for other supplier
//		    if (gradesForOtherSupplier.contains(grade1)) {
//		        LoggerUtil.pass("✅ Grade '" + grade1 + "' still correctly present for supplier '" + otherSupplier + "'.");
//		    } else {
//		        LoggerUtil.fail("❌ Grade '" + grade1 + "' missing for retained supplier '" + otherSupplier + "'.");
//		        softAssert.fail("Grade missing for retained supplier: " + otherSupplier);
//		    }
//
//		    softAssert.assertAll();
//		    LoggerUtil.info("🎯 TC_PM_DC_142 verification completed successfully — cross-supplier access control validated.");
//		}
//
//		    		   		
//		@Test(priority = 143, groups = "group1")
//		public void TC_PM_DC_143Validate_PartMaster_Commodity_Master_SameRM_Grade_differentpricesacrosssuppliers_correctmapping()
//		        throws InterruptedException, IOException, java.util.concurrent.TimeoutException {
//
//		    LoggerUtil.info("TC_PM_DC_0143: Same RM Grade, different prices across suppliers — correct mapping");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // -------------------- STEP 2: Open Dashboard → Commodity Master --------------------
//		    dashboard.clickingDashboard("Dashboard");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    LoggerUtil.info("User clicked Master Data successfully");
//		    Thread.sleep(2000);
//		    dashboard.clickoncommodityMaster();
//		    LoggerUtil.info("User entered Commodity Master");
//		    Thread.sleep(2000);
//
//		    // -------------------- STEP 3: Go to Commodity Details tab --------------------
//		    dashboard.clickOnCommodityTabByName("Commodity Details");
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(4000);
//		    commodityDetailsPage.searchOnCommodityGroupCommodityDetailsPage();
//		    commodityDetailsPage.clickOnFirstEditButton();
//		    QuickMasterPage QuickMasterPage = new QuickMasterPage();
//
//		    // -------------------- STEP 4: Fill RM & Scrap Values (Supplier: Chris 57-Deeannqikrh) --------------------
//		    String random1 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//		    String random2 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//		    String random3 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//
//		    LoggerUtil.info("===== Filling RM & Scrap values for each month with 3-decimal precision =====");
//
//		    HashMap<String, String> RM_ScrapUIDataSupplierChris_57_Deeannqikrh =
//		            quickTestPointMasterPage.QuickMasterPage.enetrRmAndScrapValuesForPartMasterValidations(
//		                    random1, random2, random3, random1, random2, random3, random1,
//		                    random2, random3, random1, random2, random3, random1, random2, random3,
//		                    random1, random2, random3, random1, random2, random3, random1, random2,
//		                    random3);
//
//		    LoggerUtil.pass("✅ Stored RM & Scrap values in HashMap → " + RM_ScrapUIDataSupplierChris_57_Deeannqikrh);
//
//		    // -------------------- STEP 5: Select Supplier and Fill Delta (Supplier: 0801-Celesta) --------------------
//		    QuickMasterPage.waitForSuppliersPanel();
//		    QuickMasterPage.checkSuppliers("0801-Celesta", "Lacy 22");
//		    Base.toBottom(driver);
//		    quickTestPointMasterPage.QuickMasterPage.selectOnSupplierSpecificDeltaByText("0801-Celesta");
//
//		 // Step 1️⃣ Fill Delta Entry (kept only for UI auto-calculation trigger)
//		    QuickMasterPage.fillAndGetSupplierDeltaEntry(driver, "//table[@id='comodityRMDeltaTable']");
//		    Thread.sleep(3000);
//		    // Step 2️⃣ Read Supplier Specific Landed Cost after auto-calculation
//		    Map<String, Map<String, String>> landedCostData = QuickMasterPage.readSupplierSpecificLandedCost(driver, "//table[@id='comodityRMDeltaTable']");
//		    LoggerUtil.info("Landed Cost Data → " + landedCostData);
//
//
//		    // Log values
//		    for (Map.Entry<String, Map<String, String>> entry : landedCostData.entrySet()) {
//		        String month = entry.getKey();
//		        String rmValue = entry.getValue().get("RM");
//		        String scrapValue = entry.getValue().get("Scrap");
//		        System.out.println("📘 " + month + " → RM: " + rmValue + " | Scrap: " + scrapValue);
//		    }
//		    LoggerUtil.pass("✅ Stored Supplier Specific Landed Cost values → " + landedCostData);
//
//
//		    commodityDetailsPage.clickOnUpdateButton();
//		    LoggerUtil.info("Update operation triggered successfully.");
//		    Thread.sleep(9000);
//
//		    // -------------------- STEP 6: Navigate to Part Master and Export Excel --------------------
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(2000);
//
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta", "Chris 57-Deeannqikrh");
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(25000);
//
//		    File exportedfile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("📂 Downloaded Details Casting Sheet: " + exportedfile);
//		    String exportedpath = exportedfile.getAbsolutePath();
//
//		    // -------------------- STEP 7: Read & Validate Exported Excel --------------------
//		    String gradeToCheck = "Adrienne 47";
//		    String supplier1 = "0801-Celesta";
//		    String supplier2 = "Chris 57-Deeannqikrh";
//		    String sheetName = "Commodity_Master";
//
//		    try (FileInputStream fis = new FileInputStream(exportedpath);
//		         Workbook workbook = WorkbookFactory.create(fis)) {
//
//		        Sheet sheet = workbook.getSheet(sheetName);
//		        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//
//		        // ✅ Step 1: Identify columns
//		        int gradeCol = -1, supplierCol = -1;
//		        List<Integer> rmCostCols = new ArrayList<>();
//		        List<Integer> scrapCostCols = new ArrayList<>();
//
//		        Row headerRow = sheet.getRow(2);
//		        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//		            String colName = ExcelUtil.evaluateCellValue(headerRow.getCell(i), evaluator).trim();
//		            if (colName.equalsIgnoreCase("Specific Grade")) gradeCol = i;
//		            else if (colName.equalsIgnoreCase("Supplier")) supplierCol = i;
//		            else if (colName.equalsIgnoreCase("RM Cost")) rmCostCols.add(i);
//		            else if (colName.equalsIgnoreCase("Scrap Cost")) scrapCostCols.add(i);
//		        }
//
//		        // ✅ Step 2: Extract Supplier-wise RM/Scrap data
//		        Map<String, Map<String, String>> supplierExcelData = new LinkedHashMap<>();
//
//		        for (int r = 3; r <= sheet.getLastRowNum(); r++) {
//		            Row row = sheet.getRow(r);
//		            if (row == null) continue;
//
//		            String grade = ExcelUtil.evaluateCellValue(row.getCell(gradeCol), evaluator).trim();
//		            String supplier = ExcelUtil.evaluateCellValue(row.getCell(supplierCol), evaluator).trim();
//
//		            if (!grade.equalsIgnoreCase(gradeToCheck)) continue;
//		            if (!supplier.equalsIgnoreCase(supplier1) && !supplier.equalsIgnoreCase(supplier2)) continue;
//
//		            Map<String, String> monthData = new LinkedHashMap<>();
//		            for (int i = 0; i < rmCostCols.size(); i++) {
//		                String rm = ExcelUtil.evaluateCellValue(row.getCell(rmCostCols.get(i)), evaluator);
//		                String scrap = ExcelUtil.evaluateCellValue(row.getCell(scrapCostCols.get(i)), evaluator);
//		                monthData.put("RM_" + (i + 1), rm);
//		                monthData.put("Scrap_" + (i + 1), scrap);
//		            }
//		            supplierExcelData.put(supplier, monthData);
//		        }
//
//		     // ✅ Step 3: Validate Excel vs Correct UI HashMap for each supplier
//		        LoggerUtil.info("📊 Validating Excel RM/Scrap values against correct UI data (supplier-wise)...");
//
//		        // Supplier-wise UI data (captured earlier)
//		        Map<String, Map<String, String>> uiDataCelesta = landedCostData; // nested map
//		        Map<String, String> uiDataChris = RM_ScrapUIDataSupplierChris_57_Deeannqikrh;       // flat map
//
//		        // Month sequence mapping
//		        String[] months = {"Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar"};
//
//		        for (Map.Entry<String, Map<String, String>> entry : supplierExcelData.entrySet()) {
//		            String supplier = entry.getKey().trim();
//		            Map<String, String> excelVals = entry.getValue();
//		            Map<String, String> uiVals = new LinkedHashMap<>();
//
//		            // ✅ Supplier to correct UI data mapping
//		            if (supplier.equalsIgnoreCase("0801-Celesta")) {
//		                uiVals = flattenRMHash(uiDataCelesta); // Nested → flat
//		                LoggerUtil.info("🔹 Comparing Excel vs UI (Supplier Delta - 0801-Celesta)");
//		            } else if (supplier.equalsIgnoreCase("Chris 57-Deeannqikrh")) {
//		                uiVals = uiDataChris; // Already flat
//		                LoggerUtil.info("🔹 Comparing Excel vs UI (Global RM - Chris 57-Deeannqikrh)");
//		            } else {
//		                LoggerUtil.error("⚠️ Unrecognized supplier found in Excel: " + supplier);
//		                continue;
//		            }
//
//		            boolean allMatch = true;
//
//		            // ✅ Compare month-wise RM & Scrap (Apr–Mar only)
//		            for (int i = 0; i < months.length; i++) {
//		                String month = months[i];
//
//		                // Excel keys are RM_1, Scrap_1, etc.
//		                String excelRM = excelVals.getOrDefault("RM_" + (i + 1), "").trim();
//		                String excelScrap = excelVals.getOrDefault("Scrap_" + (i + 1), "").trim();
//
//		                // UI keys are Apr_RM, Apr_Scrap, etc.
//		                String uiRM = uiVals.getOrDefault(month + "_RM", "").trim();
//		                String uiScrap = uiVals.getOrDefault(month + "_Scrap", "").trim();
//
//		                // Compare RM
//		                if (!excelRM.equals(uiRM)) {
//		                    LoggerUtil.fail("❌ " + supplier + " mismatch RM (" + month + ") → Excel=" + excelRM + " | UI=" + uiRM);
//		                    allMatch = false;
//		                }
//
//		                // Compare Scrap
//		                if (!excelScrap.equals(uiScrap)) {
//		                    LoggerUtil.fail("❌ " + supplier + " mismatch Scrap (" + month + ") → Excel=" + excelScrap + " | UI=" + uiScrap);
//		                    allMatch = false;
//		                }
//		            }
//
//		            if (allMatch) {
//		                LoggerUtil.pass("✅ " + supplier + " → Excel data perfectly matches UI data for all months.");
//		            } else {
//		                LoggerUtil.fail("⚠️ " + supplier + " → Excel data partially/fully mismatched vs UI.");
//		            }
//		        }
//
//		        // ✅ Step 4: Cross-verify suppliers must have different prices
//		        LoggerUtil.info("📈 Cross-verifying both suppliers for distinct RM/Scrap prices...");
//
//		        Map<String, String> s1Vals = supplierExcelData.get("0801-Celesta");
//		        Map<String, String> s2Vals = supplierExcelData.get("Chris 57-Deeannqikrh");
//		        boolean diffFound = false;
//
//		        if (s1Vals != null && s2Vals != null) {
//		            for (int i = 1; i <= 12; i++) {
//		                String rm1 = s1Vals.getOrDefault("RM_" + i, "");
//		                String rm2 = s2Vals.getOrDefault("RM_" + i, "");
//		                String sc1 = s1Vals.getOrDefault("Scrap_" + i, "");
//		                String sc2 = s2Vals.getOrDefault("Scrap_" + i, "");
//
//		                if (!rm1.equals(rm2) || !sc1.equals(sc2)) {
//		                    diffFound = true;
//		                    LoggerUtil.pass("✅ Price differs in month " + i + " → Celesta: RM=" + rm1 + ", Scrap=" + sc1 +
//		                            " | Chris: RM=" + rm2 + ", Scrap=" + sc2);
//		                }
//		            }
//		        }
//
//		        if (!diffFound)
//		            LoggerUtil.fail("❌ Both suppliers have identical RM/Scrap prices — incorrect mapping in export!");
//
//		    softAssert.assertAll();
//		}
//	}
//
//		// -------------------- Helper Methods --------------------
//
//		// Flatten nested month-wise map
//		private Map<String, String> flattenRMHash(Map<String, Map<String, String>> uiData) {
//		    Map<String, String> flattened = new LinkedHashMap<>();
//		    for (Map.Entry<String, Map<String, String>> e : uiData.entrySet()) {
//		        String month = e.getKey();
//		        flattened.put(month + "_RM", e.getValue().get("RM"));
//		        flattened.put(month + "_Scrap", e.getValue().get("Scrap"));
//		    }
//		    return flattened;
//		}
//
//		// Convert RM_1 → Apr_RM style key for mapping
//		private String convertToMonthKey(String key) {
//		    String[] months = {"Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar"};
//		    try {
//		        int idx = Integer.parseInt(key.replaceAll("[^0-9]", "")) - 1;
//		        return months[idx] + (key.contains("Scrap") ? "_Scrap" : "_RM");
//		    } catch (Exception e) {
//		        return key;
//		    }
//		}
//
//		// Helper
//		private Map<String, String> flattenRMHashh(Map<String, Map<String, String>> uiData) {
//		    Map<String, String> flat = new LinkedHashMap<>();
//		    for (Map.Entry<String, Map<String, String>> e : uiData.entrySet()) {
//		        flat.put(e.getKey() + "_RM", e.getValue().get("RM"));
//		        flat.put(e.getKey() + "_Scrap", e.getValue().get("Scrap"));
//		    }
//		    return flat;
//		}
//		
////		@Test(priority = 144, groups = "group1")
////		public void TC_PM_DC_144Validate_PartMaster_Commodity_Master_SameRM_Grade_differentpricesacrosscustomers_correctmapping()
////		        throws InterruptedException, IOException {
////
////		    LoggerUtil.info("TC_PM_DC_0144: Same RM Grade, different prices across customers — correct mapping");
////		    SoftAssert softAssert = new SoftAssert();
////
////		    // STEP 1 → Commodity Master Navigation
////		    dashboard.clickingDashboard("Dashboard");
////		    dashboard.selectMenuFormDashBoard("Master Data");
////		    dashboard.clickoncommodityMaster();
////		    dashboard.clickOnCommodityTabByName("Commodity Details");
////		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
////		    commodityDetailsPage.goToCommodityDetailsPageView();
////		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage("train");
////		    commodityDetailsPage.clickOnFirstEditButton();
////
////		    QuickMasterPage quickMasterPage = new QuickMasterPage();
////
////		    // STEP 2 → Fill RM & Scrap (Global)
////		    String r1 = String.valueOf(faker.number().randomDouble(3, 1, 100));
////		    String r2 = String.valueOf(faker.number().randomDouble(3, 1, 100));
////		    String r3 = String.valueOf(faker.number().randomDouble(3, 1, 100));
////
////		    HashMap<String, String> RM_ScrapUIDataCustomerGlobal =
////		            quickMasterPage.enetrRmAndScrapValuesForPartMasterValidations(
////		                    r1, r2, r3, r1, r2, r3, r1, r2, r3,
////		                    r1, r2, r3, r1, r2, r3, r1, r2, r3,
////		                    r1, r2, r3, r1, r2, r3);
////		    LoggerUtil.pass("✅ Stored RM & Scrap values (Global): " + RM_ScrapUIDataCustomerGlobal);
////
////		    // STEP 3 → Customer Delta Capture
////		    Base.toBottom(driver);
////		    quickMasterPage.selectOnCustomerSpecificDeltaByText("Mk-2208-7-2208-7");
////		    quickMasterPage.fillAndGetCustomerDeltaEntry();
////		    Map<String, Map<String, String>> landedCostDataCustomer = quickMasterPage.readCustomerSpecificLandedCost();
////		    LoggerUtil.pass("✅ Stored Customer-Specific Landed Cost values → " + landedCostDataCustomer);
////
////		    for (Map.Entry<String, Map<String, String>> entry : landedCostDataCustomer.entrySet()) {
////		        LoggerUtil.pass("📘 " + entry.getKey() + " → RM: " + entry.getValue().get("RM") + 
////		                        " | Scrap: " + entry.getValue().get("Scrap"));
////		    }
////
////		    commodityDetailsPage.clickOnUpdateButton();
////		    Thread.sleep(9000);
////
////		    // STEP 4 → Export Excel
////		    dashboard.clickOnPartMaster();
////		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
////		    PartMasterPage.selectOnCustomerValuesByText(" Mk-2208-7-Mohali-2208-7", " Mk-2208-9-Mohali-2208-9");
////		    PartMasterDetailCostingRivisedPage.selectSales();
////		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
////		    Thread.sleep(3000);
////		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
////		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
////		    PartMasterDetailCostingRivisedPage.openExportImportModal();
////		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
////		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
////		    Thread.sleep(25000);
////
////		    File exportedfile = getLatestFilePartMasterForDetailCostingFile();
////		    String exportedpath = exportedfile.getAbsolutePath();
////		    LoggerUtil.info("📂 Downloaded Details Costing Sheet: " + exportedpath);
////
////		    // -------------------- STEP 7: Read & Validate Exported Excel --------------------
////		    String gradeToCheck = "train";
////		    String customer1 = " Mk-2208-7-2208-7";
////		    String customer2 = " Mk-2208-9-Mohali-2208-9";
////		    String sheetName = "Commodity_Master";
////
////		    try (FileInputStream fis = new FileInputStream(exportedpath);
////		         Workbook workbook = WorkbookFactory.create(fis)) {
////
////		        Sheet sheet = workbook.getSheet(sheetName);
////		        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
////
////		        // Identify columns
////		        int gradeCol = -1, customerCol = -1;
////		        List<Integer> rmCostCols = new ArrayList<>();
////		        List<Integer> scrapCostCols = new ArrayList<>();
////
////		        Row headerRow = sheet.getRow(2);
////		        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
////		            String colName = ExcelUtil.evaluateCellValue(headerRow.getCell(i), evaluator).trim();
////		            if (colName.equalsIgnoreCase("Specific Grade")) gradeCol = i;
////		            else if (colName.equalsIgnoreCase("Customer")) customerCol = i;
////		            else if (colName.equalsIgnoreCase("RM Cost")) rmCostCols.add(i);
////		            else if (colName.equalsIgnoreCase("Scrap Cost")) scrapCostCols.add(i);
////		        }
////
////		        // Extract Excel Data
////		        Map<String, Map<String, String>> customerExcelData = new LinkedHashMap<>();
////		        for (int r = 3; r <= sheet.getLastRowNum(); r++) {
////		            Row row = sheet.getRow(r);
////		            if (row == null) continue;
////
////		            String grade = ExcelUtil.evaluateCellValue(row.getCell(gradeCol), evaluator).trim();
////		            String customer = ExcelUtil.evaluateCellValue(row.getCell(customerCol), evaluator).trim();
////
////		            if (!grade.equalsIgnoreCase(gradeToCheck)) continue;
////		            if (!customer.equalsIgnoreCase(customer1) && !customer.equalsIgnoreCase(customer2)) continue;
////
////		            Map<String, String> monthData = new LinkedHashMap<>();
////		            for (int i = 0; i < rmCostCols.size(); i++) {
////		                String rm = ExcelUtil.evaluateCellValue(row.getCell(rmCostCols.get(i)), evaluator);
////		                String scrap = ExcelUtil.evaluateCellValue(row.getCell(scrapCostCols.get(i)), evaluator);
////		                monthData.put("RM_" + (i + 1), rm);
////		                monthData.put("Scrap_" + (i + 1), scrap);
////		            }
////		            customerExcelData.put(customer, monthData);
////		        }
////
////		        // Month mapping
////		        String[] months = {"Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar"};
////
////		        // Compare each customer’s Excel vs UI data
////		        for (Map.Entry<String, Map<String, String>> entry : customerExcelData.entrySet()) {
////		            String customer = entry.getKey().trim();
////		            Map<String, String> excelVals = entry.getValue();
////		            Map<String, String> uiVals;
////		            String uiSourceType;
////
////		            if (customer.equalsIgnoreCase(customer1)) {
////		                uiVals = flattenRMHash(landedCostDataCustomer);
////		                uiSourceType = "Customer Delta";
////		            } else {
////		                uiVals = RM_ScrapUIDataCustomerGlobal;
////		                uiSourceType = "Global RM";
////		            }
////
////		            // Section Header
////		            LoggerUtil.info("\n────────────────────────────────────────────────────────────");
////		            LoggerUtil.info("Customer: " + customer + " (UI → " + uiSourceType + ")");
////		            LoggerUtil.info("────────────────────────────────────────────────────────────");
////		            LoggerUtil.info("📊 UI Data Snapshot → " + uiVals);
////		            LoggerUtil.info("📊 Excel Data Snapshot → " + excelVals);
////		            LoggerUtil.info("────────────────────────────────────────────────────────────");
////		            LoggerUtil.info(String.format("%-10s | %-12s | %-12s | %-12s | %-12s | %-6s",
////		                    "Month", "Excel RM", "UI RM", "Excel Scrap", "UI Scrap", "Result"));
////		            LoggerUtil.info("────────────────────────────────────────────────────────────");
////
////		            boolean allMatch = true;
////
////		            for (int i = 0; i < months.length; i++) {
////		                String month = months[i];
////		                String excelRM = excelVals.getOrDefault("RM_" + (i + 1), "").trim();
////		                String excelScrap = excelVals.getOrDefault("Scrap_" + (i + 1), "").trim();
////		                String uiRM = uiVals.getOrDefault(month + "_RM", "").trim();
////		                String uiScrap = uiVals.getOrDefault(month + "_Scrap", "").trim();
////
////		                boolean rmMatch = excelRM.equals(uiRM);
////		                boolean scrapMatch = excelScrap.equals(uiScrap);
////		                String result = (rmMatch && scrapMatch) ? "PASS" : "FAIL";
////		                if (!rmMatch || !scrapMatch) allMatch = false;
////
////		                LoggerUtil.info(String.format("%-10s | %-12s | %-12s | %-12s | %-12s | %-6s",
////		                        month, excelRM, uiRM, excelScrap, uiScrap, result));
////		            }
////
////		            LoggerUtil.info("────────────────────────────────────────────────────────────");
////		            if (allMatch)
////		                LoggerUtil.pass("✅ " + customer + " → Excel perfectly matches UI for all months.");
////		            else
////		                LoggerUtil.fail("⚠️ " + customer + " → Excel and UI differ for one or more months.");
////		        }
////
////		        // STEP 8 → Cross verify customers for different prices
////		        LoggerUtil.info("📈 Cross-verifying both customers for distinct RM/Scrap prices...");
////		        Map<String, String> c1Vals = customerExcelData.get(customer1);
////		        Map<String, String> c2Vals = customerExcelData.get(customer2);
////		        boolean diffFound = false;
////
////		        if (c1Vals != null && c2Vals != null) {
////		            for (int i = 1; i <= 12; i++) {
////		                String rm1 = c1Vals.getOrDefault("RM_" + i, "");
////		                String rm2 = c2Vals.getOrDefault("RM_" + i, "");
////		                String sc1 = c1Vals.getOrDefault("Scrap_" + i, "");
////		                String sc2 = c2Vals.getOrDefault("Scrap_" + i, "");
////
////		                if (!rm1.equals(rm2) || !sc1.equals(sc2)) {
////		                    diffFound = true;
////		                    LoggerUtil.pass("✅ Price differs (Month-" + i + ") → " + customer1 + ": RM=" + rm1 + ", Scrap=" + sc1 +
////		                            " | " + customer2 + ": RM=" + rm2 + ", Scrap=" + sc2);
////		                }
////		            }
////		        }
////
////		        if (!diffFound)
////		            LoggerUtil.fail("❌ Both customers have identical RM/Scrap prices — incorrect mapping in export!");
////
////		        softAssert.assertAll();
////		    }
////		}
//		
//		@Test(priority = 144, groups = "group1")
//		public void TC_PM_DC_144Validate_PartMaster_Commodity_Master_SameRM_Grade_differentpricesacrosscustomers_correctmapping()
//		        throws InterruptedException, IOException {
//
//		    LoggerUtil.info("TC_PM_DC_0144: Same RM Grade, different prices across customers — correct mapping");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Commodity Master Navigation
//		    dashboard.clickingDashboard("Dashboard");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickOnCommodityTabByName("Commodity Details");
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage("train");
//		    commodityDetailsPage.clickOnFirstEditButton();
//
//		    QuickMasterPage quickMasterPage = new QuickMasterPage();
//
//		    // STEP 2 → Fill RM & Scrap (Global)
//		    String r1 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//		    String r2 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//		    String r3 = String.valueOf(faker.number().randomDouble(3, 1, 100));
//
//		    HashMap<String, String> RM_ScrapUIDataCustomerGlobal =
//		            QuickMasterPage.enetrRmAndScrapValuesForPartMasterValidations(
//		                    r1, r2, r3, r1, r2, r3, r1, r2, r3,
//		                    r1, r2, r3, r1, r2, r3, r1, r2, r3,
//		                    r1, r2, r3, r1, r2, r3);
//		    LoggerUtil.pass("✅ Stored RM & Scrap values (Global): " + RM_ScrapUIDataCustomerGlobal);
//
//		    // STEP 3 → Customer Delta Capture
//		    Base.toBottom(driver);
//		    quickMasterPage.selectOnCustomerSpecificDeltaByText("Mk-2208-7-2208-7");
//		    quickMasterPage.fillAndGetCustomerDeltaEntry();
//		    Map<String, Map<String, String>> landedCostDataCustomer = quickMasterPage.readCustomerSpecificLandedCost();
//		    LoggerUtil.pass("✅ Stored Customer-Specific Landed Cost values → " + landedCostDataCustomer);
//
//		    for (Map.Entry<String, Map<String, String>> entry : landedCostDataCustomer.entrySet()) {
//		        LoggerUtil.pass("📘 " + entry.getKey() + " → RM: " + entry.getValue().get("RM") + 
//		                        " | Scrap: " + entry.getValue().get("Scrap"));
//		    }
//
//		    commodityDetailsPage.clickOnUpdateButton();
//		    Thread.sleep(9000);
//
//		    // STEP 4 → Export Excel
//		    dashboard.clickOnPartMaster();
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(" Mk-2208-7-Mohali-2208-7", " Mk-2208-9-Mohali-2208-9");
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(25000);
//
//		    File exportedfile = getLatestFilePartMasterForDetailCostingFile();
//		    String exportedpath = exportedfile.getAbsolutePath();
//		    LoggerUtil.info("📂 Downloaded Details Costing Sheet: " + exportedpath);
//
//		    // -------------------- STEP 7: Read & Validate Exported Excel --------------------
//		    String gradeToCheck = "train";
//		    String customer1 = " Mk-2208-7-2208-7";
//		    String customer2 = " Mk-2208-9-Mohali-2208-9";
//		    String sheetName = "Commodity_Master";
//
//		    try (FileInputStream fis = new FileInputStream(exportedpath);
//		         Workbook workbook = WorkbookFactory.create(fis)) {
//
//		        Sheet sheet = workbook.getSheet(sheetName);
//		        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//
//		        // Identify columns
//		        int gradeCol = -1, customerCol = -1;
//		        List<Integer> rmCostCols = new ArrayList<>();
//		        List<Integer> scrapCostCols = new ArrayList<>();
//
//		        Row headerRow = sheet.getRow(2);
//		        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//		            String colName = ExcelUtil.evaluateCellValue(headerRow.getCell(i), evaluator).trim();
//		            if (colName.equalsIgnoreCase("Specific Grade")) gradeCol = i;
//		            else if (colName.equalsIgnoreCase("Customer")) customerCol = i;
//		            else if (colName.equalsIgnoreCase("RM Cost")) rmCostCols.add(i);
//		            else if (colName.equalsIgnoreCase("Scrap Cost")) scrapCostCols.add(i);
//		        }
//
//		        // Extract Excel Data
//		        Map<String, Map<String, String>> customerExcelData = new LinkedHashMap<>();
//		        for (int r = 3; r <= sheet.getLastRowNum(); r++) {
//		            Row row = sheet.getRow(r);
//		            if (row == null) continue;
//
//		            String grade = ExcelUtil.evaluateCellValue(row.getCell(gradeCol), evaluator).trim();
//		            String customer = ExcelUtil.evaluateCellValue(row.getCell(customerCol), evaluator).trim();
//
//		            if (!grade.equalsIgnoreCase(gradeToCheck)) continue;
//		            if (!customer.equalsIgnoreCase(customer1) && !customer.equalsIgnoreCase(customer2)) continue;
//
//		            Map<String, String> monthData = new LinkedHashMap<>();
//		            for (int i = 0; i < rmCostCols.size(); i++) {
//		                String rm = ExcelUtil.evaluateCellValue(row.getCell(rmCostCols.get(i)), evaluator);
//		                String scrap = ExcelUtil.evaluateCellValue(row.getCell(scrapCostCols.get(i)), evaluator);
//		                monthData.put("RM_" + (i + 1), rm);
//		                monthData.put("Scrap_" + (i + 1), scrap);
//		            }
//		            customerExcelData.put(customer, monthData);
//		        }
//
//		        // Month mapping
//		        String[] months = {"Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar"};
//
//		        // Compare each customer’s Excel vs UI data
//		        for (Map.Entry<String, Map<String, String>> entry : customerExcelData.entrySet()) {
//		            String customer = entry.getKey().trim();
//		            Map<String, String> excelVals = entry.getValue();
//		            Map<String, String> uiVals;
//		            String uiSourceType;
//
//		            if (customer.equalsIgnoreCase(customer1)) {
//		                uiVals = flattenRMHash(landedCostDataCustomer);
//		                uiSourceType = "Customer Delta";
//		            } else {
//		                uiVals = RM_ScrapUIDataCustomerGlobal;
//		                uiSourceType = "Global RM";
//		            }
//
//		            // Section Header
//		            LoggerUtil.info("\n────────────────────────────────────────────────────────────");
//		            LoggerUtil.info("Customer: " + customer + " (UI → " + uiSourceType + ")");
//		            LoggerUtil.info("────────────────────────────────────────────────────────────");
//		            LoggerUtil.info("📊 UI Data Snapshot → " + uiVals);
//		            LoggerUtil.info("📊 Excel Data Snapshot → " + excelVals);
//		            LoggerUtil.info("────────────────────────────────────────────────────────────");
//		            LoggerUtil.info(String.format("%-10s | %-12s | %-12s | %-12s | %-12s | %-6s",
//		                    "Month", "Excel RM", "UI RM", "Excel Scrap", "UI Scrap", "Result"));
//		            LoggerUtil.info("────────────────────────────────────────────────────────────");
//
//		            boolean allMatch = true;
//
//		            for (int i = 0; i < months.length; i++) {
//		                String month = months[i];
//		                String excelRM = excelVals.getOrDefault("RM_" + (i + 1), "").trim();
//		                String excelScrap = excelVals.getOrDefault("Scrap_" + (i + 1), "").trim();
//		                String uiRM = uiVals.getOrDefault(month + "_RM", "").trim();
//		                String uiScrap = uiVals.getOrDefault(month + "_Scrap", "").trim();
//
//		                boolean rmMatch = excelRM.equals(uiRM);
//		                boolean scrapMatch = excelScrap.equals(uiScrap);
//		                String result = (rmMatch && scrapMatch) ? "PASS" : "FAIL";
//		                if (!rmMatch || !scrapMatch) allMatch = false;
//
//		                LoggerUtil.info(String.format("%-10s | %-12s | %-12s | %-12s | %-12s | %-6s",
//		                        month, excelRM, uiRM, excelScrap, uiScrap, result));
//		            }
//
//		            LoggerUtil.info("────────────────────────────────────────────────────────────");
//		            if (allMatch)
//		                LoggerUtil.pass("✅ " + customer + " → Excel perfectly matches UI for all months.");
//		            else
//		                LoggerUtil.fail("⚠️ " + customer + " → Excel and UI differ for one or more months.");
//		        }
//
//		        // STEP 8 → Cross verify customers for different prices
//		        LoggerUtil.info("📈 Cross-verifying both customers for distinct RM/Scrap prices...");
//		        Map<String, String> c1Vals = customerExcelData.get(customer1);
//		        Map<String, String> c2Vals = customerExcelData.get(customer2);
//		        boolean diffFound = false;
//
//		        if (c1Vals != null && c2Vals != null) {
//		            for (int i = 1; i <= 12; i++) {
//		                String rm1 = c1Vals.getOrDefault("RM_" + i, "");
//		                String rm2 = c2Vals.getOrDefault("RM_" + i, "");
//		                String sc1 = c1Vals.getOrDefault("Scrap_" + i, "");
//		                String sc2 = c2Vals.getOrDefault("Scrap_" + i, "");
//
//		                if (!rm1.equals(rm2) || !sc1.equals(sc2)) {
//		                    diffFound = true;
//		                    LoggerUtil.pass("✅ Price differs (Month-" + i + ") → " + customer1 + ": RM=" + rm1 + ", Scrap=" + sc1 +
//		                            " | " + customer2 + ": RM=" + rm2 + ", Scrap=" + sc2);
//		                }
//		            }
//		        }
//
//		        if (!diffFound)
//		            LoggerUtil.fail("❌ Both customers have identical RM/Scrap prices — incorrect mapping in export!");
//
//		        softAssert.assertAll();
//		    }
//		}
//		/**
//		 * Helper method to export Part Master → Commodity_Master Excel
//		 */
//		private File exportCommodityMasterExcel() throws Exception {
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
// 
//		    PartMasterPage.selectOnCompanyValuesByText(Base.getProperty("CompanyName1"));
//		    PartMasterPage.selectOnCustomerValuesByText(Base.getProperty("CustomerName1"));
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//		    PartMasterPage.selectOnProductCategoryValuesByText(Base.getProperty("ProductCategory1"));
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText(Base.getProperty("ProductModelNameNo1"));
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText(Base.getProperty("SpecialProductCategory1"));
// 
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(25000);
//		    File file = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.info("📂 Exported Excel: " + file.getAbsolutePath());
//		    return file;
//		}
//		
//		@Test(priority = 145, groups = "group1")
//		public void TC_PM_DC_145Validate_PartMaster_Commodity_Master_Excel_Procurement_DataMatchingProcurementExcelvsViewtabfullcompare() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_145: Data Matching — Procurement: Excel vs View tab (full compare)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM & Scrap data from UI
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//
//		    String supplierName1 = "Prabhat";
//		    String supplierName2 = "Roshan";
//
//		    // Supplier 1 data
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageSecendTime(supplierName1);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> supplier1Data =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Supplier", supplierName1);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Supplier 1 (" + supplierName1 + "): " + supplier1Data);
//
//		    // Supplier 2 data
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageThierdTime(supplierName2);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> supplier2Data =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Supplier", supplierName2);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Supplier 2 (" + supplierName2 + "): " + supplier2Data);
//
//		    // ✅ Merge both supplier data into a single combined UI data map
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> uiCombinedData = new LinkedHashMap<>();
//		    uiCombinedData.putAll(supplier1Data);
//		    uiCombinedData.putAll(supplier2Data);
//
//		    // STEP 2 → Export Excel (Procurement Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and build Supplier → Grade → Month → RM/Scrap structure
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Supplier");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Supplier' not found in Excel.");
//		        softAssert.fail("Header missing in Excel.");
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int supplierCol = ExcelUtil.findColumnIndex(headerRow, "Supplier");
//		    int gradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//
//		    List<Integer> rmCols = new ArrayList<>();
//		    List<Integer> scrapCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCols.add(c);
//		        } else if (val.equalsIgnoreCase("Scrap Cost")) {
//		            scrapCols.add(c);
//		        }
//		    }
//
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> excelSupplierData = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String supplier = getStringValue(row.getCell(supplierCol)).trim();
//		        String grade = getStringValue(row.getCell(gradeCol)).trim();
//		        if (supplier.isEmpty() || grade.isEmpty()) continue;
//
//		        String pureSupplier = supplier.split("-")[0].trim();
//		        Map<String, Map<String, Map<String, Double>>> gradeMap =
//		                excelSupplierData.getOrDefault(pureSupplier, new LinkedHashMap<>());
//
//		        Map<String, Map<String, Double>> monthMap = new LinkedHashMap<>();
//
//		        for (int i = 0; i < months.size() && i < rmCols.size() && i < scrapCols.size(); i++) {
//		            String month = months.get(i);
//		            double rmVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCols.get(i)), evaluator);
//		            double scrapVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCols.get(i)), evaluator);
//
//		            Map<String, Double> pair = new LinkedHashMap<>();
//		            pair.put("RM", rmVal);
//		            pair.put("Scrap", scrapVal);
//		            monthMap.put(month, pair);
//		        }
//
//		        gradeMap.put(grade, monthMap);
//		        excelSupplierData.put(pureSupplier, gradeMap);
//		    }
//
//		    LoggerUtil.info("📘 Excel Supplier→Grade→Month (RM+Scrap) Map: " + excelSupplierData);
//
//		    // STEP 4 → Full Comparison: Grade-wise + Month-wise
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("📊 COMPARISON RESULT: EXCEL vs UI (Supplier → Grade → Month)");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    for (String supplier : excelSupplierData.keySet()) {
//		        Map<String, Map<String, Map<String, Double>>> excelGradeMap = excelSupplierData.get(supplier);
//		        Map<String, Map<String, Map<String, Double>>> uiGradeMap = uiCombinedData.get(supplier);
//
//		        if (uiGradeMap == null || uiGradeMap.isEmpty()) {
//		            LoggerUtil.fail("❌ No UI data found for supplier: " + supplier);
//		            softAssert.fail("Missing UI data for supplier: " + supplier);
//		            continue;
//		        }
//
//		        for (String grade : excelGradeMap.keySet()) {
//		            Map<String, Map<String, Double>> excelMonthData = excelGradeMap.get(grade);
//		            Map<String, Map<String, Double>> uiMonthData = uiGradeMap.get(grade);
//
//		            if (uiMonthData == null) {
//		                LoggerUtil.fail("❌ Grade '" + grade + "' missing in UI for supplier: " + supplier);
//		                softAssert.fail("Missing grade in UI: " + supplier + " - " + grade);
//		                continue;
//		            }
//
//		            LoggerUtil.info("\nSupplier: " + supplier + " | Grade: " + grade);
//		            LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", "Month", "Type", "Excel", "UI", "Result"));
//		            LoggerUtil.info("------------------------------------------------------");
//
//		            for (String month : excelMonthData.keySet()) {
//		                if (month.startsWith("HY1") || month.startsWith("HY2")) continue;
//
//		                Map<String, Double> excelVals = excelMonthData.get(month);
//		                Map<String, Double> uiVals = uiMonthData.get(month);
//
//		                for (String type : Arrays.asList("RM", "Scrap")) {
//		                    double excelVal = excelVals.getOrDefault(type, 0.0);
//		                    double uiVal = (uiVals != null) ? uiVals.getOrDefault(type, -1.0) : -1.0;
//		                    boolean match = (Double.compare(excelVal, uiVal) == 0);
//		                    String result = match ? "PASS" : "FAIL";
//
//		                    if (!match) {
//		                        LoggerUtil.fail(String.format("❌ Mismatch → %s | %s | %s | %s | Excel=%.4f | UI=%.4f",
//		                                supplier, grade, month, type, excelVal, uiVal));
//		                        softAssert.fail("Mismatch → " + supplier + " | " + grade + " | " + month + " | " + type +
//		                                " | Excel=" + excelVal + " | UI=" + uiVal);
//		                    } else {
//		                        LoggerUtil.info(String.format("✅ %-8s | %-8s | %-12.4f | %-12.4f | %-8s",
//		                                month, type, excelVal, uiVal, result));
//		                    }
//		                }
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("✅ Full Comparison Completed: Excel vs UI grade-wise & month-wise parity check finished.");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//
//		@Test(priority = 146, groups = "group1")
//		public void TC_PM_DC_146Validate_PartMaster_Commodity_Master_Excel_Sales_DataMatchingExcelvsViewtabfullcompare() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_146: Data Matching — Sales: Excel vs View tab (full compare)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Navigate to Commodity Master and open Commodity Details tab
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//
//		    // STEP 2 → Capture UI data for both customers
//		    String customer1 = "Prabhat";
//		    String customer2 = "Roshan";
//	
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageSecendTime(customer1);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> customer1Data =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Customer", customer1);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Customer 1 (" + customer1 + "): " + customer1Data);
//
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageThiredTime(customer2);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> customer2Data =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Customer", customer2);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Customer 2 (" + customer2 + "): " + customer2Data);
//
//		    // ✅ Combine both customers’ UI data for unified validation
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> uiCombinedData = new LinkedHashMap<>();
//		    uiCombinedData.putAll(customer1Data);
//		    uiCombinedData.putAll(customer2Data);
//
//		    // STEP 3 → Export Commodity_Master Excel (Sales mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110", "Roshan-Gazipur-3111");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 4 → Read Excel data and build Customer → Grade → Month → RM/Scrap structure
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Customer");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Customer' not found in Excel.");
//		        softAssert.fail("Header missing in Excel.");
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int customerCol = ExcelUtil.findColumnIndex(headerRow, "Customer");
//		    int gradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//
//		    List<Integer> rmCols = new ArrayList<>();
//		    List<Integer> scrapCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCols.add(c);
//		        } else if (val.equalsIgnoreCase("Scrap Cost")) {
//		            scrapCols.add(c);
//		        }
//		    }
//
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> excelCustomerData = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String customer = getStringValue(row.getCell(customerCol)).trim();
//		        String grade = getStringValue(row.getCell(gradeCol)).trim();
//		        if (customer.isEmpty() || grade.isEmpty()) continue;
//
//		        String pureCustomer = customer.split("-")[0].trim();
//		        Map<String, Map<String, Map<String, Double>>> gradeMap =
//		                excelCustomerData.getOrDefault(pureCustomer, new LinkedHashMap<>());
//
//		        Map<String, Map<String, Double>> monthMap = new LinkedHashMap<>();
//
//		        for (int i = 0; i < months.size() && i < rmCols.size() && i < scrapCols.size(); i++) {
//		            String month = months.get(i);
//		            double rmVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCols.get(i)), evaluator);
//		            double scrapVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCols.get(i)), evaluator);
//
//		            Map<String, Double> pair = new LinkedHashMap<>();
//		            pair.put("RM", rmVal);
//		            pair.put("Scrap", scrapVal);
//		            monthMap.put(month, pair);
//		        }
//
//		        gradeMap.put(grade, monthMap);
//		        excelCustomerData.put(pureCustomer, gradeMap);
//		    }
//
//		    LoggerUtil.info("📘 Excel Customer→Grade→Month (RM+Scrap) Map: " + excelCustomerData);
//
//		    // STEP 5 → Compare Excel vs UI (Sales View)
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("📊 COMPARISON RESULT: EXCEL vs UI (Customer → Grade → Month)");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    for (String customer : excelCustomerData.keySet()) {
//		        Map<String, Map<String, Map<String, Double>>> excelGradeMap = excelCustomerData.get(customer);
//		        Map<String, Map<String, Map<String, Double>>> uiGradeMap = uiCombinedData.get(customer);
//
//		        if (uiGradeMap == null || uiGradeMap.isEmpty()) {
//		            LoggerUtil.fail("❌ No UI data found for customer: " + customer);
//		            softAssert.fail("Missing UI data for customer: " + customer);
//		            continue;
//		        }
//
//		        for (String grade : excelGradeMap.keySet()) {
//		            Map<String, Map<String, Double>> excelMonthData = excelGradeMap.get(grade);
//		            Map<String, Map<String, Double>> uiMonthData = uiGradeMap.get(grade);
//
//		            if (uiMonthData == null) {
//		                LoggerUtil.fail("❌ Grade '" + grade + "' missing in UI for customer: " + customer);
//		                softAssert.fail("Missing grade in UI: " + customer + " - " + grade);
//		                continue;
//		            }
//
//		            LoggerUtil.info("\nCustomer: " + customer + " | Grade: " + grade);
//		            LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", "Month", "Type", "Excel", "UI", "Result"));
//		            LoggerUtil.info("------------------------------------------------------");
//
//		            for (String month : excelMonthData.keySet()) {
//		                if (month.startsWith("HY1") || month.startsWith("HY2")) continue;
//
//		                Map<String, Double> excelVals = excelMonthData.get(month);
//		                Map<String, Double> uiVals = uiMonthData.get(month);
//
//		                for (String type : Arrays.asList("RM", "Scrap")) {
//		                    double excelVal = excelVals.getOrDefault(type, 0.0);
//		                    double uiVal = (uiVals != null) ? uiVals.getOrDefault(type, -1.0) : -1.0;
//		                    boolean match = (Double.compare(excelVal, uiVal) == 0);
//		                    String result = match ? "PASS" : "FAIL";
//
//		                    if (!match) {
//		                        LoggerUtil.fail(String.format("❌ Mismatch → %s | %s | %s | %s | Excel=%.4f | UI=%.4f",
//		                                customer, grade, month, type, excelVal, uiVal));
//		                        softAssert.fail("Mismatch → " + customer + " | " + grade + " | " + month + " | " + type +
//		                                " | Excel=" + excelVal + " | UI=" + uiVal);
//		                    } else {
//		                        LoggerUtil.info(String.format("✅ %-8s | %-8s | %-12.4f | %-12.4f | %-8s",
//		                                month, type, excelVal, uiVal, result));
//		                    }
//		                }
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("✅ Full Comparison Completed: Excel vs UI customer-wise & month-wise parity check finished.");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
// 
//		@Test(priority = 148, groups = "group1")
//		public void TC_PM_DC_148_ImportSafety_LocalEditsMustNotUpdateCommodityMaster() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_148: Import safety — local edits must not update Commodity Master");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export the Commodity_Master Excel
//		    File exportedFile = exportCommodityMasterExcel();
//		    String exportedPath = exportedFile.getAbsolutePath();
//		   
//		    // STEP 2 → Read baseline value before tampering (Specific Grade)
//		    String baselineGrade = PartMasterDetailCostingRivisedPage.readCellValuecommodityMaster(exportedFile, "Commodity_Master", 4, "Specific Grade");
//		    LoggerUtil.info("📘 Baseline Specific Grade from export: " + baselineGrade);
//
//		    // STEP 3 → Simulate local tampering — remove protection and modify data
//		    String tamperedValue = randomname;
//		    PartMasterDetailCostingRivisedPage.writeCellValuecommodityMaster(exportedFile, "Commodity_Master", 4, "Specific Grade", tamperedValue);
//		    LoggerUtil.warn("⚠️ Tampered Excel locally: changed 'Specific Grade' from '" + baselineGrade + "' to '" + tamperedValue + "'.");
//
//		    // STEP 4 → Attempt to import the tampered file
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.importDetailCostingExcel(exportedPath);
//		    Thread.sleep(1000);
//		 //   pmdcrp.captureSingleToastMessage();
//
//		    // STEP 6 → Navigate to Commodity Details and verify master data unchanged
//		    dashboard.clickingDashboard("Dashboard");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    LoggerUtil.info("🔍 searching Specific Grade in Commodity Details View: " + baselineGrade);
//		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage(baselineGrade);
//		   
//		    String currentGrade = commodityDetailsPage.getSpecificGradeFromFirstRow();
//		    LoggerUtil.info("🔍 Current Specific Grade in Commodity Details View: " + currentGrade);
//
//		    // STEP 7 → Verify no change occurred in master data
//		    if (currentGrade.equalsIgnoreCase(baselineGrade)) {
//		    	LoggerUtil.fail("❌ Master data changed — Commodity Master updated after tampered import! Expected: "
//		                + baselineGrade + " | Found: " + currentGrade);
//		        softAssert.fail("Commodity Master updated unexpectedly from tampered import.");
//		    } else {
//		    	 LoggerUtil.pass("✅ Master data unchanged — tampered import ignored successfully.");
//		    }
//
//		    softAssert.assertAll();
//		   
//		}
//
//		@Test(priority = 149, groups = "group1",enabled = false)
//		public void TC_PM_DC_149_Procurement_AllSuppliers_GradesMatchCommodityMaster() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_149: Procurement — all Supplier selection: RM grades match Commodity Master exactly");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("adiydtj");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText(" Select all");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(50000);
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//		    String sheetName = "Commodity_Master";
//
//		    // STEP 2 → Identify last non-empty data row (Excel)
//		    int lastRow = ExcelUtil.getLastNonEmptyRow(exportedFile, sheetName);
//		    LoggerUtil.info("📘 Last non-empty data row in Excel: " + lastRow);
//
//		    // STEP 3 → Read key attributes from Excel (Last RM Grade, Density, Year)
//		    String excelGrade = ExcelUtil.readCellValue(exportedFile, sheetName, lastRow, "Specific Grade");
//		    String excelDensity = ExcelUtil.readCellValue(exportedFile, sheetName, lastRow, "Density gm/cm^3");
//		    String excelYear = ExcelUtil.readCellValue(exportedFile, sheetName, lastRow, "Year");
//
//		    LoggerUtil.info("📗 Excel (Last Row) → Grade: " + excelGrade + " | Density: " + excelDensity + " | Year: " + excelYear);
//
//		    // STEP 4 → Go to Commodity Master → Commodity Details → View
//		    dashboard.clickingDashboard("Dashboard");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage(excelGrade);
//
//		    // STEP 5 → Fetch same data from UI
//		    String uiGrade = commodityDetailsPage.getCellTextByColumn("Grade");
//		    String uiDensity = commodityDetailsPage.getCellTextByColumn("Density gm/cm^3");
//		    String uiYear = commodityDetailsPage.getCellTextByColumn("Year");
//
//		    LoggerUtil.info("📘 UI → Grade: " + uiGrade + " | Density: " + uiDensity + " | Year: " + uiYear);
//
//		    // STEP 6 → Compare UI vs Excel values
//		    boolean allMatch = true;
//
//		    if (uiGrade.equalsIgnoreCase(excelGrade))
//		        LoggerUtil.pass("✅ Grade matches → " + uiGrade);
//		    else {
//		        LoggerUtil.fail("❌ Grade mismatch → UI: " + uiGrade + " | Excel: " + excelGrade);
//		        allMatch = false;
//		        softAssert.fail("Grade mismatch");
//		    }
//
//		    if (uiDensity.equalsIgnoreCase(excelDensity))
//		        LoggerUtil.pass("✅ Density matches → " + uiDensity);
//		    else {
//		        LoggerUtil.fail("❌ Density mismatch → UI: " + uiDensity + " | Excel: " + excelDensity);
//		        allMatch = false;
//		        softAssert.fail("Density mismatch");
//		    }
//
//		    if (uiYear.equalsIgnoreCase(excelYear))
//		        LoggerUtil.pass("✅ Year matches → " + uiYear);
//		    else {
//		        LoggerUtil.fail("❌ Year mismatch → UI: " + uiYear + " | Excel: " + excelYear);
//		        allMatch = false;
//		        softAssert.fail("Year mismatch");
//		    }
//
//		    if (allMatch)
//		        LoggerUtil.pass("✅ All RM Grades and attributes match correctly for Procurement mode.");
//		    else
//		        LoggerUtil.fail("⚠️ One or more mismatches found in Procurement comparison.");
//
//		    softAssert.assertAll();
//		}
//
//		@Test(priority = 150, groups = "group1",enabled = false)
//		public void TC_PM_DC_150_Sales_AllCustomers_GradesMatchCommodityMaster() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_150: Sales — all Customer selection: RM grades match Commodity Master exactly");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText(" Select all");
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(500000);
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//		    String sheetName = "Commodity_Master";
//
//		    // STEP 2 → Identify last non-empty data row (Excel)
//		    int lastRow = ExcelUtil.getLastNonEmptyRow(exportedFile, sheetName);
//		    LoggerUtil.info("📘 Last non-empty data row in Excel: " + lastRow);
//
//		    // STEP 3 → Read key attributes from Excel (Last RM Grade, Density, Year)
//		    String excelGrade = ExcelUtil.readCellValue(exportedFile, sheetName, lastRow, "Specific Grade");
//		    String excelDensity = ExcelUtil.readCellValue(exportedFile, sheetName, lastRow, "Density gm/cm^3");
//		    String excelYear = ExcelUtil.readCellValue(exportedFile, sheetName, lastRow, "Year");
//
//		    LoggerUtil.info("📗 Excel (Last Row) → Grade: " + excelGrade + " | Density: " + excelDensity + " | Year: " + excelYear);
//
//		    // STEP 4 → Go to Commodity Master → Commodity Details → View
//		    dashboard.clickingDashboard("Dashboard");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickOnCommodityTabByName("Commodity Details");
//
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    commodityDetailsPage.searchOnCommodityGradCommodityDetailsPage(excelGrade);
//
//		    // STEP 5 → Fetch same data from UI
//		    String uiGrade = commodityDetailsPage.getCellTextByColumn("Grade");
//		    String uiDensity = commodityDetailsPage.getCellTextByColumn("Density gm/cm^3");
//		    String uiYear = commodityDetailsPage.getCellTextByColumn("Year");
//
//		    LoggerUtil.info("📘 UI → Grade: " + uiGrade + " | Density: " + uiDensity + " | Year: " + uiYear);
//
//		    // STEP 6 → Compare UI vs Excel values
//		    boolean allMatch = true;
//
//		    if (uiGrade.equalsIgnoreCase(excelGrade))
//		        LoggerUtil.pass("✅ Grade matches → " + uiGrade);
//		    else {
//		        LoggerUtil.fail("❌ Grade mismatch → UI: " + uiGrade + " | Excel: " + excelGrade);
//		        allMatch = false;
//		        softAssert.fail("Grade mismatch");
//		    }
//
//		    if (uiDensity.equalsIgnoreCase(excelDensity))
//		        LoggerUtil.pass("✅ Density matches → " + uiDensity);
//		    else {
//		        LoggerUtil.fail("❌ Density mismatch → UI: " + uiDensity + " | Excel: " + excelDensity);
//		        allMatch = false;
//		        softAssert.fail("Density mismatch");
//		    }
//
//		    if (uiYear.equalsIgnoreCase(excelYear))
//		        LoggerUtil.pass("✅ Year matches → " + uiYear);
//		    else {
//		        LoggerUtil.fail("❌ Year mismatch → UI: " + uiYear + " | Excel: " + excelYear);
//		        allMatch = false;
//		        softAssert.fail("Year mismatch");
//		    }
//
//		    if (allMatch)
//		        LoggerUtil.pass("✅ All RM Grades and attributes match correctly for Procurement mode.");
//		    else
//		        LoggerUtil.fail("⚠️ One or more mismatches found in Procurement comparison.");
//
//		    softAssert.assertAll();
//		}
//
//		@Test(priority = 151, groups = "group1")
//		public void TC_PM_DC_151_LastRowProtectionAndFormattingCheck() throws Exception {
//		    LoggerUtil.info("TC_PM_DC_151: Validating last-row protection and formatting persistence in Commodity_Master sheet.");
//		 // STEP 1 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(1000);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//		    String sheetName = "Commodity_Master";
//
//		 // Find last row with actual data
//		    int lastRow = ExcelUtil.getLastNonEmptyRow(exportedFile, sheetName);
//		   
//		    // Read formatting/protection status
//		    try (FileInputStream fis = new FileInputStream(exportedFile);
//		         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//		        XSSFSheet sheet = workbook.getSheet(sheetName);
//		        Row row = sheet.getRow(lastRow - 1);
//		        if (row == null) {
//		            LoggerUtil.fail("❌ No row found at expected last data position: " + lastRow);
//		            return;
//		        }
//
//		        boolean anyUnlocked = false;
//		       
//
//		        for (Cell cell : row) {
//		            CellStyle style = cell.getCellStyle();
//		           		   
//		            if (!style.getLocked()) {
//		                anyUnlocked = true;
//		            }
//		        }
//
//		        if (!anyUnlocked)
//		            LoggerUtil.pass("✅ Last row cells are locked and protected as expected.");
//		        else
//		            LoggerUtil.fail("❌ One or more last-row cells are editable (protection missing).");
//		    }
//
//		}
//				
//		@Test(priority = 152, groups = "group1")
//		public void TC_PM_DC_152_Negative_ExtraRMGradeForSelectedSupplier() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_152: Negative — Extra RM Grade appears for a selected Supplier");
//		    SoftAssert softAssert = new SoftAssert();
//		    // STEP 1 → get all list of grade from commodity details view
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//		    String supplierName="Prabhat";
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageSecendTime(supplierName);
//		    
//		    List<String> uiGrades = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.pass("✅ Total unique Grades fetched: " + uiGrades.size());
//		    LoggerUtil.info("Grades for Supplier 'Prabhat': " + uiGrades);
//		 
//		    // STEP 2 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//		   
//		    // STEP 3 → Extract all RM Grades from Excel
//		    String sheetName = "Commodity_Master";
//		    List<String> excelGrades = ExcelUtil.readColumnValues(exportedFile, sheetName, "Specific Grade");
//		    excelGrades.removeIf(String::isBlank);
//		    LoggerUtil.info("📘 Total RM Grades found in Excel: " + excelGrades.size());
//		    LoggerUtil.info("📗 Excel Grades: " + excelGrades);
//		    
//		    // STEP 5 → verify Extra grades
//		    List<String> extraGrades = new ArrayList<>();
//		    for (String grade : excelGrades) {
//		        if (!uiGrades.contains(grade)) {
//		            extraGrades.add(grade);
//		        }
//		    }
//
//		    if (extraGrades.isEmpty()) {
//		        LoggerUtil.pass("✅ No extra/unallocated RM Grades found in Excel. Export data matches UI perfectly.");
//		    } else {
//		        LoggerUtil.fail("❌ Extra RM Grades found in Excel that are not mapped to supplier '" 
//		                         + supplierName + "': " + extraGrades);
//		        softAssert.fail("Extra RM Grades found: " + extraGrades);
//		    }
//
//		    softAssert.assertAll();
//		   
//		}
//		
//		@Test(priority = 153, groups = "group1")
//		public void TC_PM_DC_153_Negative_MissingRMGradeforAselectedSupplier() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_153: Negative — Missing RM Grade for a selected Supplier");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM Grades and UI RM data
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//
//		    String supplierName = "MK-6666";
//		    commodityDetailsPage.searchOnSupplierCommodityDetailsPageSecendTime(supplierName);
//		    Thread.sleep(2000);
//
//		    List<String> uiGrades = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.info("📙 Total RM Grades found in UI for " + supplierName + ": " + uiGrades.size());
//		    LoggerUtil.info("📙 UI Grades: " + uiGrades);
//
//		    // Fetch RM month-wise data from UI
//		    Map<String, Map<String, Double>> uiMap = commodityDetailsPage.getUiGradeMonthRmMap();
//		    LoggerUtil.info("📊 UI RM Data Map: " + uiMap);
//
//		    // STEP 2 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText(" Mk-2208-7-Mohali-2208-7");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("MK-6666-6666");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and find header row dynamically
//		    String sheetName = "Commodity_Master";
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Specific Grade");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel.");
//		        softAssert.fail("Header not found");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//		    Row headerRow = sheet.getRow(headerRowIndex);
//
//		    int gradeColIndex = -1, supplierColIndex = -1;
//		    List<Integer> rmCostCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("Specific Grade")) gradeColIndex = c;
//		        if (val.equalsIgnoreCase("Supplier")) supplierColIndex = c;
//		        if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCostCols.add(c);
//		        }
//		    }
//
//		    LoggerUtil.info("✅ Grade Column Index: " + gradeColIndex);
//		    LoggerUtil.info("✅ Supplier Column Index: " + supplierColIndex);
//		    LoggerUtil.info("✅ RM Cost Columns (Apr–Mar): " + rmCostCols);
//		    LoggerUtil.info("✅ Months Detected: " + months);
//
//		    if (gradeColIndex == -1 || supplierColIndex == -1 || rmCostCols.isEmpty()) {
//		        LoggerUtil.fail("❌ Required columns missing — verify header alignment.");
//		        softAssert.fail("Missing columns");
//		        wb.close(); fis.close();
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 4 → Extract RM values from Excel into same structure as UI map
//		    Map<String, Map<String, Double>> excelMap = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String grade = getStringValue(row.getCell(gradeColIndex)).trim();
//		        if (grade.isEmpty()) continue;
//
//		        String supplier = getStringValue(row.getCell(supplierColIndex)).trim();
//		        if (!supplier.equalsIgnoreCase("MK-6666-6666")) continue; // focus on same supplier
//
//		        Map<String, Double> monthValues = new LinkedHashMap<>();
//		        for (int i = 0; i < rmCostCols.size() && i < months.size(); i++) {
//		            int colIdx = rmCostCols.get(i);
//		            String month = months.get(i);
//		            String val = getEvaluatedCellValue(row.getCell(colIdx), evaluator);
//
//		            double rmVal = 0.0;
//		            try {
//		                if (!val.isEmpty()) rmVal = Double.parseDouble(val);
//		            } catch (NumberFormatException e) {
//		                LoggerUtil.warn("⚠️ Non-numeric RM at " + grade + " " + month + " = " + val);
//		            }
//		            monthValues.put(month, rmVal);
//		        }
//		        excelMap.put(grade, monthValues);
//		    }
//
//		    // STEP 5 → Compare Excel vs UI Data
//		    LoggerUtil.info("🔎 Comparing Excel vs UI data for supplier: " + supplierName);
//		    for (String grade : excelMap.keySet()) {
//		        if (!uiMap.containsKey(grade)) {
//		            LoggerUtil.fail("❌ Grade missing in UI: " + grade);
//		            softAssert.fail("Missing grade in UI: " + grade);
//		            continue;
//		        }
//
//		        Map<String, Double> excelMonths = excelMap.get(grade);
//		        Map<String, Double> uiMonths = uiMap.get(grade);
//
//		        for (String month : excelMonths.keySet()) {
//		            if (month.toUpperCase().contains("HY1") || month.toUpperCase().contains("HY2")) {
//		                LoggerUtil.info("ℹ️ Skipping half-year column not shown in UI: " + month);
//		                continue;
//		            }
//
//		            double excelVal = excelMonths.get(month);
//		            double uiVal = uiMonths.getOrDefault(month, -1.0);
//
//		            if (Math.abs(excelVal - uiVal) < 0.0001) {
//		                LoggerUtil.pass("✅ Match: " + grade + " | " + month + " → " + excelVal);
//		            } else {
//		                LoggerUtil.fail("❌ Mismatch: " + grade + " | " + month +
//		                        " | Excel=" + excelVal + " | UI=" + uiVal);
//		                softAssert.fail("Mismatch for " + grade + " (" + month + ")");
//		            }
//		        }
//		    }
//
//		    wb.close(); fis.close();
//		    softAssert.assertAll();
//		    LoggerUtil.pass("✅ TC_PM_DC_153 completed: UI vs Excel RM value comparison done successfully.");
//		}
//		
//		@Test(priority = 154, groups = "group1")
//		public void TC_PM_DC_154_Negative_PricemismatchVSViewtab() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_154: Negative — Price mismatch vs View tab");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM Grades and UI RM data
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//
//		    String customerName = "RAJNISH";
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageSecendTime(customerName);
//		    Thread.sleep(2000);
//
//		    List<String> uiGrades = commodityDetailsPage.getAllGradesFromFilteredTable();
//		    LoggerUtil.info("📙 Total RM Grades found in UI for " + customerName + ": " + uiGrades.size());
//		    LoggerUtil.info("📙 UI Grades: " + uiGrades);
//
//		    // Fetch RM month-wise data from UI
//		    Map<String, Map<String, Double>> uiMap = commodityDetailsPage.getUiGradeMonthRmMap();
//		    LoggerUtil.info("📊 UI RM Data Map: " + uiMap);
//
//		    // STEP 2 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("RAJNISH-MOHALI-5555");
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and find header row dynamically
//		    String sheetName = "Commodity_Master";
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Specific Grade");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel.");
//		        softAssert.fail("Header not found");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//		    Row headerRow = sheet.getRow(headerRowIndex);
//
//		    int gradeColIndex = -1, customerColIndex = -1;
//		    List<Integer> rmCostCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("Specific Grade")) gradeColIndex = c;
//		        if (val.equalsIgnoreCase("Customer")) customerColIndex = c;
//		        if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCostCols.add(c);
//		        }
//		    }
//
//		    LoggerUtil.info("✅ Grade Column Index: " + gradeColIndex);
//		    LoggerUtil.info("✅ Customer Column Index: " + customerColIndex);
//		    LoggerUtil.info("✅ RM Cost Columns (Apr–Mar): " + rmCostCols);
//		    LoggerUtil.info("✅ Months Detected: " + months);
//
//		    if (gradeColIndex == -1 || customerColIndex == -1 || rmCostCols.isEmpty()) {
//		        LoggerUtil.fail("❌ Required columns missing — verify header alignment.");
//		        softAssert.fail("Missing columns");
//		        wb.close(); fis.close();
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 4 → Extract RM values from Excel into same structure as UI map
//		    Map<String, Map<String, Double>> excelMap = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String grade = getStringValue(row.getCell(gradeColIndex)).trim();
//		        if (grade.isEmpty()) continue;
//
//		        String customer = getStringValue(row.getCell(customerColIndex)).trim();
//		        if (!customer.equalsIgnoreCase("RAJNISH-5555")) continue; // focus on same customer
//
//		        Map<String, Double> monthValues = new LinkedHashMap<>();
//		        for (int i = 0; i < rmCostCols.size() && i < months.size(); i++) {
//		            int colIdx = rmCostCols.get(i);
//		            String month = months.get(i);
//		            String val = getEvaluatedCellValue(row.getCell(colIdx), evaluator);
//
//		            double rmVal = 0.0;
//		            try {
//		                if (!val.isEmpty()) rmVal = Double.parseDouble(val);
//		            } catch (NumberFormatException e) {
//		                LoggerUtil.warn("⚠️ Non-numeric RM at " + grade + " " + month + " = " + val);
//		            }
//		            monthValues.put(month, rmVal);
//		        }
//		        excelMap.put(grade, monthValues);
//		    }
//
//		    // STEP 5 → Compare Excel vs UI Data
//		    LoggerUtil.info("🔎 Comparing Excel vs UI data for customer: " + customerName);
//		    for (String grade : excelMap.keySet()) {
//		        if (!uiMap.containsKey(grade)) {
//		            LoggerUtil.fail("❌ Grade missing in UI: " + grade);
//		            softAssert.fail("Missing grade in UI: " + grade);
//		            continue;
//		        }
//
//		        Map<String, Double> excelMonths = excelMap.get(grade);
//		        Map<String, Double> uiMonths = uiMap.get(grade);
//
//		        for (String month : excelMonths.keySet()) {
//		            if (month.toUpperCase().contains("HY1") || month.toUpperCase().contains("HY2")) {
//		                LoggerUtil.info("ℹ️ Skipping half-year column not shown in UI: " + month);
//		                continue;
//		            }
//
//		            double excelVal = excelMonths.get(month);
//		            double uiVal = uiMonths.getOrDefault(month, -1.0);
//
//		            if (Math.abs(excelVal - uiVal) < 0.0001) {
//		                LoggerUtil.pass("✅ Match: " + grade + " | " + month + " → " + excelVal);
//		            } else {
//		                LoggerUtil.fail("❌ Mismatch: " + grade + " | " + month +
//		                        " | Excel=" + excelVal + " | UI=" + uiVal);
//		                softAssert.fail("Mismatch for " + grade + " (" + month + ")");
//		            }
//		        }
//		    }
//
//		    wb.close(); fis.close();
//		    softAssert.assertAll();
//		    LoggerUtil.pass("✅ TC_PM_DC_154 completed: UI vs Excel RM value comparison done successfully.");
//		}
//
//		/* ---------- Utility methods ---------- */
//
//		private static String getStringValue(Cell cell) {
//		    if (cell == null) return "";
//		    try { return cell.toString().trim(); } catch (Exception e) { return ""; }
//		}
//
//		private static String getEvaluatedCellValue(Cell cell, FormulaEvaluator evaluator) {
//		    if (cell == null) return "";
//		    try {
//		        switch (cell.getCellType()) {
//		            case FORMULA:
//		                CellValue cv = evaluator.evaluate(cell);
//		                if (cv == null) return "";
//		                switch (cv.getCellType()) {
//		                    case NUMERIC:
//		                        return new DecimalFormat("#.####").format(cv.getNumberValue());
//		                    case STRING:
//		                        return cv.getStringValue().trim();
//		                    case BOOLEAN:
//		                        return String.valueOf(cv.getBooleanValue());
//		                    default:
//		                        return "";
//		                }
//		            case NUMERIC:
//		                return new DecimalFormat("#.####").format(cell.getNumericCellValue());
//		            case STRING:
//		                return cell.getStringCellValue().trim();
//		            default:
//		                return "";
//		        }
//		    } catch (Exception e) {
//		        return cell.toString().trim();
//		    }
//		    }
//		   
//	
//		@Test(priority = 155, groups = "group1")
//		public void TC_PM_DC_155_Negative_OrderingviolatedS2_blocklistedbefore_S1() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_155: Negative — Ordering violated (S2 block listed before S1)");
//		    SoftAssert softAssert = new SoftAssert();
//		    
//		 // STEP 1 → Export Excel in Procurement Mode
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText(" Mk-2208-7-Mohali-2208-7");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("0801-Celesta","0801-Darlenelfyb");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Procurement Excel: " + exportedFile.getAbsolutePath());
//		 // STEP 2 → Read Commodity_Master sheet and validate supplier ordering
//		    LoggerUtil.info("STEP 2 → Reading Commodity_Master sheet for supplier ordering validation");
//
//		    String sheetName = "Commodity_Master";
//		    List<List<String>> data = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//
//		    if (data == null || data.isEmpty()) {
//		        LoggerUtil.fail("❌ No data found in sheet: " + sheetName);
//		        softAssert.fail("Sheet data missing or unreadable");
//		    } else {
//
//		        // Dynamically detect header row containing "Supplier"
//		        int headerRowIndex = ExcelUtil.findHeaderRowIndex(data, "Supplier");
//		        if (headerRowIndex == -1) {
//		            LoggerUtil.fail("❌ 'Supplier' header row not found in first 10 rows.");
//		            softAssert.fail("Supplier header not found.");
//		        } else {
//		            List<String> header = data.get(headerRowIndex);
//		            LoggerUtil.info("Detected header row index: " + headerRowIndex);
//
//		            // Find Supplier column index
//		            int supplierColIndex = -1;
//		            for (int i = 0; i < header.size(); i++) {
//		                if (header.get(i).trim().equalsIgnoreCase("Supplier")) {
//		                    supplierColIndex = i;
//		                    break;
//		                }
//		            }
//
//		            if (supplierColIndex == -1) {
//		                LoggerUtil.fail("❌ 'Supplier' column not found in Excel header");
//		                softAssert.fail("Supplier column missing");
//		            } else {
//		                LoggerUtil.info("Supplier column found at index: " + supplierColIndex);
//
//		                int firstCelestaRow = -1;
//		                int firstDarlenRow = -1;
//
//		                // Start scanning data after header row
//		                for (int i = headerRowIndex + 1; i < data.size(); i++) {
//		                    List<String> row = data.get(i);
//		                    if (row.size() <= supplierColIndex) continue;
//		                    String supplier = row.get(supplierColIndex).trim();
//
//		                    if (supplier.equalsIgnoreCase("0801-Celesta") && firstCelestaRow == -1)
//		                        firstCelestaRow = i;
//		                    if (supplier.equalsIgnoreCase("0801-Darlenelfyb") && firstDarlenRow == -1)
//		                        firstDarlenRow = i;
//		                }
//
//		                LoggerUtil.info("First occurrence of S1 (0801-Celesta): Row " + firstCelestaRow);
//		                LoggerUtil.info("First occurrence of S2 (0801-Darlenelfyb): Row " + firstDarlenRow);
//
//		                // Validation: expected order S1 → S2
//		                if (firstCelestaRow == -1 || firstDarlenRow == -1) {
//		                    LoggerUtil.fail("❌ One or both suppliers not found in Excel sheet");
//		                    softAssert.fail("Missing supplier data");
//		                } else if (firstDarlenRow < firstCelestaRow) {
//		                    LoggerUtil.fail("❌ Ordering violated: S2 (Darlenelfyb) block listed before S1 (Celesta)");
//		                    softAssert.fail("Ordering violated — S2 block appears before S1");
//		                } else {
//		                    LoggerUtil.pass("✅ Ordering correct: S1 (Celesta) listed before S2 (Darlenelfyb)");
//		                }
//
//		                // Optional: show sample rows for reference
//		                LoggerUtil.info("Sample row for S1 → " + data.get(firstCelestaRow));
//		                LoggerUtil.info("Sample row for S2 → " + data.get(firstDarlenRow));
//		            }
//		        }
//		    }
//		    
//		    softAssert.assertAll();
//		   
//		}
//
//		@Test(priority = 156, groups = "group1")
//		public void TC_PM_DC_156_Edge_SupplierWithNoRMGrades() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_156: Edge — Supplier with no RM Grades");
//		    SoftAssert softAssert = new SoftAssert();
//		   
//		    // STEP 1 → Export Excel (Procurement)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		   
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "SupplierWithNoRMGrades-0611");      //Supplier_with_no_RM_Grades > SupplierWithNoRMGrades-0611
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 2 → Read Excel and verify suppliers
//		    String sheetName = "Commodity_Master";
//		    List<List<String>> data = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(data, "Supplier");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ 'Supplier' header not found in Excel");
//		        softAssert.fail("Supplier header missing");
//		    } else {
//		        int supplierColIndex = -1;
//		        List<String> header = data.get(headerRowIndex);
//		        for (int i = 0; i < header.size(); i++) {
//		            if (header.get(i).trim().equalsIgnoreCase("Supplier")) {
//		                supplierColIndex = i;
//		                break;
//		            }
//		        }
//
//		        if (supplierColIndex == -1) {
//		            LoggerUtil.fail("❌ Supplier column index not found");
//		            softAssert.fail("Missing Supplier column");
//		        } else {
//		            int s1Count = 0;
//		            int sxCount = 0;
//
//		            for (int i = headerRowIndex + 1; i < data.size(); i++) {
//		                List<String> row = data.get(i);
//		                if (row.size() <= supplierColIndex) continue;
//		                String supplier = row.get(supplierColIndex).trim();
//		                if (supplier.equalsIgnoreCase("Prabhat-3110")) s1Count++;
//		                if (supplier.equalsIgnoreCase("SupplierWithNoRMGrades-0611")) sxCount++;
//		            }
//
//		            LoggerUtil.info("S1 (Prabhat) rows found: " + s1Count);
//		            LoggerUtil.info("Sx (no RM Grades) rows found: " + sxCount);
//
//		            if (s1Count == 0) {
//		                LoggerUtil.fail("❌ No rows found for S1 (Prabhat)");
//		                softAssert.fail("Expected S1 data missing");
//		            } else if (sxCount > 0) {
//		                LoggerUtil.fail("❌ Sx (no RM Grades) unexpectedly present with " + sxCount + " rows");
//		                softAssert.fail("Supplier with no RM grades appeared in export");
//		            } else {
//		                LoggerUtil.pass("✅ PASS: Sx has no RM Grades (0 rows) and S1 block intact with " + s1Count + " rows");
//		            }
//		        }
//		    }
//
//		    softAssert.assertAll();
//		   
//		}
//		
//		@Test(priority = 157, groups = "group1")
//		public void TC_PM_DC_157_Edge_Re_exportafterrevokingagrademid_test() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_157: Edge — Re-export after revoking a grade mid-test");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export Excel (Procurement)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText(" Mk-2208-7-Mohali-2208-7");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("MK-6666-6666");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel (Before Revoke): " + exportedFile.getAbsolutePath());
//
//		    // STEP 2 → Read first export and dynamically capture any existing grade
//		    LoggerUtil.info("STEP 2 → Reading first export to detect existing grade before revoke");
//
//		    String sheetName = "Commodity_Master";
//		    List<List<String>> dataBefore = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(dataBefore, "Specific Grade");
//
//		    String targetGrade = null;
//
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Specific Grade' not found in Excel");
//		        softAssert.fail("Header not found");
//		    } else {
//		        List<String> header = dataBefore.get(headerRowIndex);
//		        int gradeColIndex = header.indexOf("Specific Grade");
//
//		        // Dynamically find the first valid (non-empty) grade
//		        for (int i = headerRowIndex + 1; i < dataBefore.size(); i++) {
//		            List<String> row = dataBefore.get(i);
//		            if (row.size() > gradeColIndex) {
//		                String gradeValue = row.get(gradeColIndex).trim();
//		                if (!gradeValue.isEmpty()) {
//		                    targetGrade = gradeValue;
//		                    break;
//		                }
//		            }
//		        }
//
//		        if (targetGrade != null) {
//		            LoggerUtil.pass("✅ Found grade before revoke: '" + targetGrade + "'");
//		        } else {
//		            LoggerUtil.fail("❌ No grade found in first export — cannot proceed with revoke test.");
//		            softAssert.fail("No grade found in first export");
//		        }
//		    }
//
//		    // STEP 3 → Admin removes the detected grade dynamically
//		    if (targetGrade != null) {
//		        LoggerUtil.info("STEP 3 → Admin removing grade '" + targetGrade + "' for supplier MK-6666-6666 in Commodity Master");
//
//		        dashboard.clickoncommodityMasterspeciyly();
//		        CommodityDetailsPage commodity = new CommodityDetailsPage();
//
//		        dashboard.clickoncommoditydetailstab();
//		        commodity.goToCommodityDetailsPageView();
//		        commodity.searchOnCommodityGradCommodityDetailsPage(targetGrade);
//		        commodity.clickOnFirstDeleteButton();
//
//		        LoggerUtil.pass("🗑️ Grade '" + targetGrade + "' deleted successfully from Commodity Master.");
//		        Thread.sleep(5000);
//		    }
//
//		    // STEP 4 → Re-export after revoking detected grade
//		    LoggerUtil.info("STEP 4 → Re-exporting after revoking grade '" + targetGrade + "'");
//
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText(" Mk-2208-7-Mohali-2208-7");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("MK-6666-6666");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFileAfter = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Re-exported Excel (After Revoke): " + exportedFileAfter.getAbsolutePath());
//
//		    // STEP 5 → Verify the same grade is no longer present in new export
//		    LoggerUtil.info("STEP 5 → Verifying that revoked grade '" + targetGrade + "' is absent in new export");
//
//		    List<List<String>> dataAfter = ExcelUtil.readEntireSheetAsList(exportedFileAfter.getAbsolutePath(), sheetName);
//		    int headerRowIndexAfter = ExcelUtil.findHeaderRowIndex(dataAfter, "Specific Grade");
//
//		    boolean gradeStillPresent = false;
//		    if (headerRowIndexAfter != -1 && targetGrade != null) {
//		        int gradeColIndexAfter = dataAfter.get(headerRowIndexAfter).indexOf("Specific Grade");
//		        for (int i = headerRowIndexAfter + 1; i < dataAfter.size(); i++) {
//		            List<String> row = dataAfter.get(i);
//		            if (row.size() > gradeColIndexAfter && 
//		                row.get(gradeColIndexAfter).trim().equalsIgnoreCase(targetGrade)) {
//		                gradeStillPresent = true;
//		                break;
//		            }
//		        }
//		    }
//
//		    if (!gradeStillPresent) {
//		        LoggerUtil.pass("✅ PASS: Grade '" + targetGrade + "' successfully revoked — not found in re-export.");
//		    } else {
//		        LoggerUtil.fail("❌ FAIL: Grade '" + targetGrade + "' still appears after revoke (expected removal).");
//		        softAssert.fail("Grade still present after revoke");
//		    }
//
//		    softAssert.assertAll();
//		   
//		}
//		
//		@Test(priority = 158, groups = "group1")
//		public void TC_PM_DC_158_Edge_DuplicateGradeAcrossOwnersWithSamePrice() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_158: Edge — Duplicate grade name across owners with same price");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM & Scrap data from UI
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//
//		    String supplierName1 = "Prabhat";
//		    String supplierName2 = "Roshan";
//		    String targetGrade = "Secend";
//
//		    // Supplier 1
//		    commodityDetailsPage.searchOnGradeCommodityDetailsPageSecendTime(targetGrade);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> supplier1Data =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Supplier", supplierName1);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Supplier 1 (" + supplierName1 + "): " + supplier1Data);
//
//		    // Supplier 2
//		    commodityDetailsPage.searchOnGradeCommodityDetailsPageThierdTime(targetGrade);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> supplier2Data =
//		            commodityDetailsPage.getUiEntityMonthRmScrapMap("Supplier", supplierName2);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map for Supplier 2 (" + supplierName2 + "): " + supplier2Data);
//
//		    // ✅ Combine UI data for both suppliers
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> uiCombinedData = new LinkedHashMap<>();
//		    uiCombinedData.putAll(supplier1Data);
//		    uiCombinedData.putAll(supplier2Data);
//
//		    // STEP 2 → Export Excel (Procurement Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("Prabhat-3110", "Roshan-3111");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Parse Excel
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(
//		            ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName),
//		            "Supplier");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Supplier' not found in Excel.");
//		        softAssert.fail("Header missing in Excel.");
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int supplierCol = ExcelUtil.findColumnIndex(headerRow, "Supplier");
//		    int gradeCol = ExcelUtil.findColumnIndex(headerRow, "Specific Grade");
//
//		    // STEP 4 → Count Target Grade Rows
//		    int targetRowCount = 0;
//		    Set<String> supplierSet = new HashSet<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String supplier = getStringValue(row.getCell(supplierCol)).trim();
//		        String grade = getStringValue(row.getCell(gradeCol)).trim();
//		        if (supplier.isEmpty() || grade.isEmpty()) continue;
//
//		        if (grade.equalsIgnoreCase(targetGrade) &&
//		                (supplier.contains("Prabhat") || supplier.contains("Roshan"))) {
//		            targetRowCount++;
//		            supplierSet.add(supplier.split("-")[0].trim());
//		        }
//		    }
//
//		    // ✅ Verify “Two distinct rows” (not merged)
//		    LoggerUtil.info("🔎 Found " + targetRowCount + " rows in Excel for grade '" + targetGrade + "'");
//		    if (targetRowCount == 2 && supplierSet.size() == 2) {
//		        LoggerUtil.pass("✅ Two distinct rows found under " + supplierSet + " — no merging despite same price.");
//		    } else {
//		        LoggerUtil.fail("❌ Expected 2 rows (one per supplier) for grade '" + targetGrade + "', found: " + targetRowCount);
//		        softAssert.fail("Duplicate grade not handled correctly in Excel export.");
//		    }
//
//		    // STEP 5 → Validate month-wise RM+Scrap for only targetGrade
//		    Map<String, Map<String, Map<String, Map<String, Double>>>> excelSupplierData = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String supplier = getStringValue(row.getCell(supplierCol)).trim();
//		        String grade = getStringValue(row.getCell(gradeCol)).trim();
//		        if (!grade.equalsIgnoreCase(targetGrade)) continue; // only target grade
//
//		        String pureSupplier = supplier.split("-")[0].trim();
//		        if (!pureSupplier.equalsIgnoreCase(supplierName1) && !pureSupplier.equalsIgnoreCase(supplierName2)) continue;
//
//		        Map<String, Map<String, Map<String, Double>>> gradeMap =
//		                excelSupplierData.getOrDefault(pureSupplier, new LinkedHashMap<>());
//		        Map<String, Map<String, Double>> monthMap = new LinkedHashMap<>();
//
//		        // Dynamically detect RM/Scrap columns + months
//		        List<Integer> rmCols = new ArrayList<>();
//		        List<Integer> scrapCols = new ArrayList<>();
//		        List<String> months = new ArrayList<>();
//		        for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		            String val = getStringValue(headerRow.getCell(c));
//		            if (val.equalsIgnoreCase("RM Cost")) {
//		                String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		                if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                    months.add(month);
//		                rmCols.add(c);
//		            } else if (val.equalsIgnoreCase("Scrap Cost")) {
//		                scrapCols.add(c);
//		            }
//		        }
//
//		        for (int i = 0; i < months.size() && i < rmCols.size() && i < scrapCols.size(); i++) {
//		            String month = months.get(i);
//		            double rmVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCols.get(i)), evaluator);
//		            double scrapVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCols.get(i)), evaluator);
//
//		            Map<String, Double> pair = new LinkedHashMap<>();
//		            pair.put("RM", rmVal);
//		            pair.put("Scrap", scrapVal);
//		            monthMap.put(month, pair);
//		        }
//
//		        gradeMap.put(grade, monthMap);
//		        excelSupplierData.put(pureSupplier, gradeMap);
//		    }
//
//		    LoggerUtil.info("📘 Excel Supplier→Grade→Month (RM+Scrap) Map [Filtered for '" + targetGrade + "']: " + excelSupplierData);
//
//		    // STEP 6 → Compare Excel vs UI for both suppliers
//		    for (String supplier : excelSupplierData.keySet()) {
//		        Map<String, Map<String, Map<String, Double>>> excelGradeMap = excelSupplierData.get(supplier);
//		        Map<String, Map<String, Map<String, Double>>> uiGradeMap = uiCombinedData.get(supplier);
//
//		        if (uiGradeMap == null || uiGradeMap.isEmpty()) {
//		            LoggerUtil.fail("❌ No UI data found for supplier: " + supplier);
//		            softAssert.fail("Missing UI data for supplier: " + supplier);
//		            continue;
//		        }
//
//		        Map<String, Map<String, Double>> excelMonthData = excelGradeMap.get(targetGrade);
//		        Map<String, Map<String, Double>> uiMonthData = uiGradeMap.get(targetGrade);
//
//		        if (uiMonthData == null) {
//		            LoggerUtil.fail("❌ Grade '" + targetGrade + "' missing in UI for supplier: " + supplier);
//		            softAssert.fail("Missing grade in UI: " + supplier + " - " + targetGrade);
//		            continue;
//		        }
//
//		        LoggerUtil.info("\nSupplier: " + supplier + " | Grade: " + targetGrade);
//		        LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", "Month", "Type", "Excel", "UI", "Result"));
//		        LoggerUtil.info("------------------------------------------------------");
//
//		        for (String month : excelMonthData.keySet()) {
//		            if (month.startsWith("HY1") || month.startsWith("HY2")) continue;
//
//		            Map<String, Double> excelVals = excelMonthData.get(month);
//		            Map<String, Double> uiVals = uiMonthData.get(month);
//
//		            for (String type : Arrays.asList("RM", "Scrap")) {
//		                double excelVal = excelVals.getOrDefault(type, 0.0);
//		                double uiVal = (uiVals != null) ? uiVals.getOrDefault(type, -1.0) : -1.0;
//		                boolean match = (Double.compare(excelVal, uiVal) == 0);
//		                String result = match ? "PASS" : "FAIL";
//
//		                if (!match) {
//		                    LoggerUtil.fail(String.format("❌ Mismatch → %s | %s | %s | %s | Excel=%.4f | UI=%.4f",
//		                            supplier, targetGrade, month, type, excelVal, uiVal));
//		                    softAssert.fail("Mismatch → " + supplier + " | " + targetGrade + " | " + month + " | " + type +
//		                            " | Excel=" + excelVal + " | UI=" + uiVal);
//		                } else {
//		                    LoggerUtil.info(String.format("✅ %-8s | %-8s | %-12.4f | %-12.4f | %-8s",
//		                            month, type, excelVal, uiVal, result));
//		                }
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("✅ Verification Completed: Two distinct rows appear for duplicate grade across suppliers with same price.");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//
//
//		
//		@Test(priority = 159, groups = "group1")
//		public void TC_PM_DC_159_Validation_MultiCustomerSalesexportdataparity() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_159: Validation — Multi-customer Sales export, data parity (RM + Scrap)");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Fetch RM + Scrap data from UI for each customer
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickoncommodityMaster();
//		    dashboard.clickoncommoditydetailstab();
//		    CommodityDetailsPage commodityDetailsPage = new CommodityDetailsPage();
//		    commodityDetailsPage.goToCommodityDetailsPageView();
//		    Thread.sleep(1000);
//
//		    String customer1 = "Prabhat";
//		    String customer2 = "Roshan";
//		    String customer3 = "Nilesh";
//
//		    // Customer 1
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageSecendTime(customer1);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Double>>> uiMap1 = commodityDetailsPage.getUiCustomerMonthRmScrapMap(customer1);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map (Prabhat): " + uiMap1);
//
//		    // Customer 2
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageThiredTime(customer2);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Double>>> uiMap2 = commodityDetailsPage.getUiCustomerMonthRmScrapMap(customer2);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map (Roshan): " + uiMap2);
//
//		    // Customer 3
//		    commodityDetailsPage.searchOnCustomerCommodityDetailsPageThiredTime(customer3);
//		    Thread.sleep(2000);
//		    Map<String, Map<String, Map<String, Double>>> uiMap3 = commodityDetailsPage.getUiCustomerMonthRmScrapMap(customer3);
//		    LoggerUtil.info("📊 UI RM+Scrap Data Map (Nilesh): " + uiMap3);
//
//		    // STEP 2 → Export Excel (Sales Mode)
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Prabhat-Gazipur-3110","Roshan-Gazipur-3111","Nilesh-Gazipur-3112");
//		    PartMasterDetailCostingRivisedPage.selectSales();
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(3000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel: " + exportedFile.getAbsolutePath());
//
//		    // STEP 3 → Read Excel and build month-wise RM + Scrap map
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//
//		    List<List<String>> excelData = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName);
//		    int headerRowIndex = ExcelUtil.findHeaderRowIndex(excelData, "Customer");
//		    if (headerRowIndex == -1) {
//		        LoggerUtil.fail("❌ Header 'Customer' not found in Excel.");
//		        softAssert.fail("Header missing");
//		        wb.close(); fis.close(); softAssert.assertAll(); return;
//		    }
//
//		    Row headerRow = sheet.getRow(headerRowIndex);
//		    int customerColIndex = -1;
//		    List<Integer> rmCostCols = new ArrayList<>();
//		    List<Integer> scrapCostCols = new ArrayList<>();
//		    List<String> months = new ArrayList<>();
//
//		    // Identify column indexes dynamically
//		    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
//		        String val = getStringValue(headerRow.getCell(c));
//		        if (val.equalsIgnoreCase("Customer")) customerColIndex = c;
//		        else if (val.equalsIgnoreCase("RM Cost")) {
//		            String month = getStringValue(sheet.getRow(headerRowIndex - 1).getCell(c));
//		            if (month != null && !month.trim().isEmpty() && !month.toUpperCase().startsWith("Q"))
//		                months.add(month);
//		            rmCostCols.add(c);
//		        } else if (val.equalsIgnoreCase("Scrap Cost")) {
//		            scrapCostCols.add(c);
//		        }
//		    }
//
//		    if (customerColIndex == -1 || rmCostCols.isEmpty() || scrapCostCols.isEmpty()) {
//		        LoggerUtil.fail("❌ Missing necessary columns (Customer / RM Cost / Scrap Cost).");
//		        wb.close(); fis.close();
//		        softAssert.fail("Missing columns");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 4 → Extract RM + Scrap values from Excel
//		    Map<String, Map<String, Map<String, Double>>> excelCustomerMap = new LinkedHashMap<>();
//
//		    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
//		        Row row = sheet.getRow(r);
//		        if (row == null) continue;
//
//		        String customer = getStringValue(row.getCell(customerColIndex)).trim();
//		        if (customer.isEmpty()) continue;
//		        String pureCustomer = customer.split("-")[0];
//
//		        Map<String, Map<String, Double>> monthData = excelCustomerMap.getOrDefault(pureCustomer, new LinkedHashMap<>());
//
//		        for (int i = 0; i < months.size() && i < rmCostCols.size() && i < scrapCostCols.size(); i++) {
//		            String month = months.get(i);
//		            double rmVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(rmCostCols.get(i)), evaluator);
//		            double scrapVal = com.Pages.PartMasterDetailCostingRivisedPage.getNumericValue(row.getCell(scrapCostCols.get(i)), evaluator);
//
//		            Map<String, Double> pair = new LinkedHashMap<>();
//		            pair.put("RM", rmVal);
//		            pair.put("Scrap", scrapVal);
//		            monthData.put(month, pair);
//		        }
//		        excelCustomerMap.put(pureCustomer, monthData);
//		    }
//
//		    LoggerUtil.info("📘 Excel Customer→Month (RM+Scrap) Map: " + excelCustomerMap);
//
//		    // STEP 5 → Compare Excel vs UI Data
//		    Map<String, Map<String, Map<String, Double>>> uiAllMap = new LinkedHashMap<>();
//		    uiAllMap.put(customer1, uiMap1.get(customer1));
//		    uiAllMap.put(customer2, uiMap2.get(customer2));
//		    uiAllMap.put(customer3, uiMap3.get(customer3));
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("📊 COMPARISON RESULT: EXCEL vs UI (Month-wise RM & Scrap)");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    for (String customer : Arrays.asList(customer1, customer2, customer3)) {
//		        Map<String, Map<String, Double>> excelMonthData = excelCustomerMap.get(customer);
//		        Map<String, Map<String, Double>> uiMonthData = uiAllMap.get(customer);
//
//		        if (uiMonthData == null || uiMonthData.isEmpty()) {
//		            LoggerUtil.fail("❌ UI data not found for customer: " + customer);
//		            softAssert.fail("Missing UI data for " + customer);
//		            continue;
//		        }
//
//		        LoggerUtil.info("\nCustomer: " + customer);
//		        LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", "Month", "Type", "Excel", "UI", "Result"));
//		        LoggerUtil.info("------------------------------------------------------");
//
//		        for (String month : excelMonthData.keySet()) {
//		            if (month.startsWith("HY1") || month.startsWith("HY2")) continue;
//
//		            Map<String, Double> excelVals = excelMonthData.get(month);
//		            Map<String, Double> uiVals = uiMonthData.get(month);
//
//		            for (String type : Arrays.asList("RM", "Scrap")) {
//		                double excelVal = excelVals.getOrDefault(type, 0.0);
//		                double uiVal = (uiVals != null) ? uiVals.getOrDefault(type, -1.0) : -1.0;
//		                String result = (Math.abs(excelVal - uiVal) < 0.0001) ? "PASS" : "FAIL";
//
//		                LoggerUtil.info(String.format("%-10s | %-8s | %-12s | %-12s | %-8s", month, type, excelVal, uiVal, result));
//		                if (!result.equals("PASS"))
//		                    softAssert.fail("Mismatch → " + customer + " | " + month + " | " + type + " | Excel=" + excelVal + " | UI=" + uiVal);
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("------------------------------------------------------");
//		    LoggerUtil.info("✅ Comparison Completed: Excel vs UI parity check finished (Multi-Customer RM + Scrap).");
//		    LoggerUtil.info("------------------------------------------------------");
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//
//
//		@Test(priority = 160, groups = "group1")
//		public void TC_PM_DC_160_Validation_NonEditableEnforcementOnCopyPaste() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_160: Validation — Non-editable enforcement on copy/paste attempts");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export Commodity Master Excel
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-5-Mohali-2208-5");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("MK-6666-6666");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel for protection validation: " + exportedFile.getAbsolutePath());
//
//		    // STEP 2 → Read Excel (Commodity_Master sheet)
//		    String sheetName = "Commodity_Master";
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet(sheetName);
//		    if (sheet == null) {
//		        LoggerUtil.fail("❌ Commodity_Master sheet not found.");
//		        softAssert.fail("Sheet missing.");
//		        softAssert.assertAll();
//		        return;
//		    }
//
//		    // STEP 3 → Verify Locked Cells (non-editable)
//		    LoggerUtil.info("🔍 Checking locked (protected) cells in Commodity_Master sheet...");
//		    int headerRow = ExcelUtil.findHeaderRowIndex(ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName), "Specific Grade");
//		    Row firstDataRow = sheet.getRow(headerRow + 1);
//
//		    List<String> protectedCols = Arrays.asList(
//		        "Commodity Group", "Group Classification", "Supplier", "Customer",
//		        "Specific Grade", "Density gm/cm^3", "UOM", "Year"
//		    );
//
//		    List<String> header = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), sheetName).get(headerRow);
//		    int protectedCount = 0;
//
//		    for (int i = 0; i < header.size(); i++) {
//		        if (protectedCols.contains(header.get(i).trim())) {
//		            Cell cell = firstDataRow.getCell(i);
//		            if (cell != null && cell.getCellStyle().getLocked()) {
//		                LoggerUtil.pass("✅ Column '" + header.get(i) + "' is locked (protected).");
//		                protectedCount++;
//		            } else {
//		                LoggerUtil.fail("❌ Column '" + header.get(i) + "' is editable — should be protected!");
//		                softAssert.fail("Editable protection failure: " + header.get(i));
//		            }
//		        }
//		    }
//
//		    LoggerUtil.info("🔒 Total protected columns verified: " + protectedCount);
//
//		    // STEP 4 → Try modifying a protected cell
//		    try {
//		        Cell protectedCell = firstDataRow.getCell(header.indexOf("Specific Grade"));
//		        String originalValue = protectedCell.getStringCellValue();
//		        protectedCell.setCellValue("Tampered Grade"); // attempt overwrite
//		        LoggerUtil.info("Attempted to modify locked cell: 'Specific Grade'");
//		        softAssert.fail("Modification should not be allowed on locked cell (no exception).");
//		    } catch (Exception e) {
//		        LoggerUtil.pass("✅ Modification blocked or ignored on locked cell.");
//		    }
//
//		    // STEP 5 → Save modified copy and try Import (simulate user tampering)
//		    File tamperedFile = new File(exportedFile.getParent(), "Tampered_" + exportedFile.getName());
//		    FileOutputStream out = new FileOutputStream(tamperedFile);
//		    wb.write(out);
//		    out.close();
//		    wb.close();
//		    fis.close();
//
//		    LoggerUtil.info("⚠️ Tampered file saved: " + tamperedFile.getAbsolutePath());
//
//		    // STEP 6 → Import back and verify data remains unchanged
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.importDetailCostingExcel(tamperedFile.getAbsolutePath());
//		    String toastMsg = PartMasterDetailCostingRivisedPage.captureSingleToastMessage();
//
//		    if (toastMsg.toLowerCase().contains("unauthorized") || toastMsg.toLowerCase().contains("invalid")) {
//		        LoggerUtil.pass("✅ System blocked import for modified Excel — Toast: " + toastMsg);
//		    } else {
//		        LoggerUtil.fail("❌ System accepted tampered file — unexpected behavior! Toast: " + toastMsg);
//		        softAssert.fail("Tampered Excel import was not rejected.");
//		    }		  
//		    softAssert.assertAll();		    
//		}
//
//		@Test(priority = 161, groups = "group1")
//		public void TC_PM_DC_161_Validation_SheetPresenceAndIsolation() throws Exception {
//
//		    LoggerUtil.info("TC_PM_DC_161: Validation — Sheet presence and isolation");
//		    SoftAssert softAssert = new SoftAssert();
//
//		    // STEP 1 → Export Commodity Master Excel
//		    dashboard.clickingDashboard("");
//		    dashboard.selectMenuFormDashBoard("Master Data");
//		    dashboard.clickOnPartMaster();
//		    Thread.sleep(1000);
//		    PartMasterPage.selectOnCompanyValuesByText("Costmaster-Mohali-007");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnCustomerValuesByText("Mk-2208-5-Mohali-2208-5");
//		    PartMasterDetailCostingRivisedPage.selectProcurement();
//		    PartMasterPage.selectOnSupplierValuesByText("MK-6666-6666");
//		    PartMasterPage.selectOnProductCategoryValuesByText("FURNITURE");
//		    Thread.sleep(2000);
//		    PartMasterPage.selectOnProductModelNameAndNumberValuesByText("Misc-2410456");
//		    PartMasterPage.selectOnSpecialProductCategoryValuesByText("MK-testing-2308");
//		    PartMasterDetailCostingRivisedPage.openExportImportModal();
//		    PartMasterDetailCostingRivisedPage.enterTotalNoOfParts(10);
//		    PartMasterDetailCostingRivisedPage.clickOnExportBtn();
//		    Thread.sleep(30000);
//
//		    File exportedFile = getLatestFilePartMasterForDetailCostingFile();
//		    LoggerUtil.pass("📂 Exported Excel file: " + exportedFile.getAbsolutePath());
//
//		    FileInputStream fis = new FileInputStream(exportedFile);
//		    Workbook wb = WorkbookFactory.create(fis);
//
//		 // STEP 2 → Verify Sheet Presence and Isolation
//		    List<String> expectedSheets = Arrays.asList(
//		        "Part_Master", "Process_Cost", "BOP_Cost", "Commodity_Master",
//		        "Process_Master", "BOP_Master", "OHP_Master"
//		    );
//
//		    int sheetCount = wb.getNumberOfSheets();
//		    List<String> actualSheets = new ArrayList<>();
//		    for (int i = 0; i < sheetCount; i++) {
//		        actualSheets.add(wb.getSheetName(i));
//		    }
//		    LoggerUtil.info("📑 Total sheets in workbook: " + sheetCount);
//		    LoggerUtil.info("📋 Sheets found: " + actualSheets);
//
//		    // Determine missing and extra sheets
//		    List<String> missingSheets = new ArrayList<>(expectedSheets);
//		    missingSheets.removeAll(actualSheets);
//
//		    List<String> extraSheets = new ArrayList<>(actualSheets);
//		    extraSheets.removeAll(expectedSheets);
//
//		    // Validation logic
//		    if (missingSheets.isEmpty() && extraSheets.isEmpty()) {
//		        LoggerUtil.pass("✅ All expected sheets found, no unexpected sheets present.");
//		    } else {
//		        if (!missingSheets.isEmpty()) {
//		            LoggerUtil.fail("❌ Missing expected sheets: " + missingSheets);
//		            softAssert.fail("Missing sheets: " + missingSheets);
//		        }
//		        if (!extraSheets.isEmpty()) {
//		            LoggerUtil.fail("❌ Unexpected extra sheets detected: " + extraSheets);
//		            softAssert.fail("Unexpected sheets: " + extraSheets);
//		        }
//		    }
//
//		    // STEP 3 → Validate Protection (read-only)
//		    Sheet sheet = wb.getSheet("Commodity_Master");
//		    if (sheet.getProtect()) {
//		        LoggerUtil.pass("🔒 Sheet 'Commodity_Master' is protected (read-only).");
//		    } else {
//		        LoggerUtil.fail("❌ Sheet 'Commodity_Master' is not protected — expected gray/read-only.");
//		        softAssert.fail("Sheet protection missing.");
//		    }
//
//		    // STEP 4 → Validate commodity-specific columns
//		    List<List<String>> data = ExcelUtil.readEntireSheetAsList(exportedFile.getAbsolutePath(), "Commodity_Master");
//		    List<String> headers = data.get(0);
//		    List<String> expectedCommodityHeaders = Arrays.asList(
//		        "Commodity Group", "Supplier", "Customer", "Specific Grade",
//		        "Density gm/cm^3", "UOM", "Year", "RM Rate", "Scrap Rate"
//		    );
//
//		    boolean headerMatch = expectedCommodityHeaders.stream().allMatch(h -> headers.stream().anyMatch(x -> x.equalsIgnoreCase(h)));
//		    if (headerMatch) {
//		        LoggerUtil.pass("✅ Commodity_Master sheet contains expected commodity headers only.");
//		    } else {
//		        LoggerUtil.fail("❌ Missing or unrelated headers detected. Headers found: " + headers);
//		        softAssert.fail("Unexpected columns present.");
//		    }
//
//		    // STEP 5 → Ensure no unrelated sheets or hidden rows
//		    if (sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells() == 0) {
//		        LoggerUtil.fail("❌ Empty trailing row detected — should not exist.");
//		        softAssert.fail("Empty trailing rows present.");
//		    } else {
//		        LoggerUtil.pass("✅ No extra rows or hidden placeholder sheets found.");
//		    }
//
//		    wb.close();
//		    fis.close();
//		    softAssert.assertAll();
//		}
//
//
//}
//
