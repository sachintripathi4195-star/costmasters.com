package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelFiller;
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;

public class SupplierMasterPage extends Base {

	Faker faker = new Faker();
	// Declare variables to reuse for UI validation
	public static String supplierCode;
	public static String supplierName;
	public static String supplierLocation;
	public static String businessDomain;
	public static String rm;
	public static String process;

	ProcessMasterPage pmaster = new ProcessMasterPage();
	DashboardPage dashboard = new DashboardPage();

	public static final By BusinessDomainSegments = By.xpath("//*[@id='exTab3']/ul/li[1]/a");
	public static final By CategoryTypeDropdownBusinessSegAndDomain = By.xpath("//*[@id='Type']");
	public static final By enetrcategoryname = By.xpath("//input[@id='Name']");
	public static final By savebutton = By.xpath("//button[@id='saveBusinessDomainSegments']");
	public static final By toastmessagesupplierpage = By.xpath("//div[@class='toast-message']");
	public static final By ImportToastMsgSupplierPage = By.xpath("//div[@id='toast-container']/div/div");
	public static final By edit_buttons = By.xpath("//a[contains(@onclick, 'editbusinessDomainSegments')]");
	public static final By businedomainsegmentlengthdropdown = By
			.xpath("//*[@id='businessdomainSegmentsTable_length']/label/select");
	public static final By clicknextbutton = By.xpath("//li[@id='businessdomainSegmentsTable_next']");
	public static final By findingnextpageoftwentysixthrownumer = By
			.xpath("//*[@id='businessdomainSegmentsTable']/tbody/tr[1]/td[1]");
	public static final By firsttablerowsize = By.xpath("//table[@id='businessdomainSegmentsTable']/tbody/tr");
	public static final By searchboxbusinessSegmentAndDomainTab = By
			.xpath("//*[@id='businessdomainSegmentsTable_filter']/label/input");
	public static final By numberofentriesdropdown = By.xpath("//select[@name='businessdomainSegmentsTable_length']");
	public static final By ResetButtonBusinessdomainAndSegment = By
			.xpath("//*[@id='picklist']/div/div[1]/div[3]/button[2]");

	// Edit Button Is Valid FOr Particular Data In Business Segment/Domain List
	public static final By ClickEditbtnBusinessDomainSegment = By
			.xpath("//*[@id='businessdomainSegmentsTable']/tbody/tr/td[4]/a[1]");
	// Edit Button Is Valid for Particular Row//
	public static final By clickeditbuttonsupplierpage = By.xpath("//*[@id='example1']/tbody/tr/td[7]/a[1]/span/i");

	public static final By suppliersecondtab = By.xpath("//ul[@class='nav nav-pills']/li[2]/a");

	public static final By suupliercode = By.xpath("//input[@id='SupplierCode']");

	public static final By suppliername = By.xpath("//input[@id='SupplierName']");

	public static final By supplerlocation = By.xpath("//input[@id='SupplierLocation']");

	public static final By businnessdomaidropdown = By
			.xpath("//select[@id='BusinessDomain']/following-sibling::div/button");

	public static final By businessDomainSearch = By
			.xpath("//select[@id='BusinessDomain']/following-sibling::div/button/following-sibling::div/div/input");

	public static final By businesssegmentdropdown = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/button");

	public static final By businesSegmentSearch = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/button/following-sibling::div/div/input");

	public static final By businessDomainCheckBox = By
			.xpath("(//label[contains(text(), 'rishi')]/preceding-sibling::input[@type='checkbox'])[1]");

	public static final By businessSegmentCheckBox = By
			.xpath("(//label[contains(text(), 'sachindra1')]/preceding-sibling::input[@type='checkbox'])[1]");

	public static final By clickingSavebuttonSupplierMasterPage = By.xpath("//button[@id='btnSave']");

	public static final By searchboxsuppleirPage = By.xpath("//*[@id='example1_filter']/label/input");

	public static final By searchbutton = By.xpath("//div[@id='businessdomainSegmentsTable_filter']//input");

	public static final By deletebtnBusinessDomainSegMentTab = By
			.xpath("//table[@id='businessdomainSegmentsTable']/tbody/tr/td[4]/a[2]/i");

	public static final By deletebusinessSegment = By
			.xpath("//a[@onclick='return deletebusinessDomainSegments(8497,'3',onclick);']");

	public static final By toastmessage = By.xpath("//div[@class='toast-message']");

	public static final By managernamefield = By.xpath("//input[@id='ManagerName']");

	public static final By Emailid1 = By.xpath("//input[@id='Email1']");

	public static final By Emailid2 = By.xpath("//input[@id='Email2']");
	public static final By contact = By.xpath("//input[@id='Contact']");
	public static final By contact1 = By.xpath("//input[@id='Contact1']");
	public static final By saveasnewbutton = By.xpath("//button[@id='btnSaveAsNew']");
	public static final By updatebutton = By.xpath("//button[@id='btnUpdate']");
	public static final By fetchtbalerowsInSupplierTab = By.xpath("//table/tbody/tr");

	public static final By Rmcheckbox = By.xpath("//input[@id='RM']");

	// public static final By selectallbusinessdomain =
	// By.xpath("//button[@class=\"dropdown-item
	// multiselect-all\"]/span//input[@id=\"multiselect_14ioc10jg0a_0_0\"]");
	public static final By selectallbusinessSegment = By
			.xpath("//button[@class='dropdown-item multiselect-all']/span//input[@id='multiselect_14ioc10jg0a_0_0']");
	public static final By ClickingRmCheckbox = By.xpath("//input[@id='RM']");
	public static final By rmlistselect = By
			.xpath("//table[@id='rmdatatable']/tbody/tr[1]/td//input[@type='checkbox']");
	public static final By commoditydatailstab = By
			.xpath("//ul[@class='nav nav-pills']//li[3]//a[@href='#CommodityDetailTab']");
	public static final By commoditydetailListViewbtn = By
			.xpath("//div[@class='btn-group']//button[4][@onclick='comodityDetailList()']");
	public static final By commoditysearchtab = By.xpath("//input[@id='myInputListSearch']");
	public static final By commoditytablelist = By.xpath("//table[@id='comodityDetailListTable']/tbody/tr");
	public static final By backbtn = By.xpath("//button[@onclick='showcomodityDetailForm()']");
	public static final By clickonEditgradebtn = By.xpath(
			"//table[@class='table table-striped table-bordered partTable2']//tbody//tr//td[2]//a[@onclick='return editDetail(13792);']");
	public static final By entersupplierdropdownoncommoditytab = By
			.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/div/div/input");
	public static final By processchkbox = By.xpath("//input[@class='Processchk']");
	public static final By processAllocationlistsupplierPageTable = By.xpath("//table[@id='processdatatable']/tbody/tr[1]/td/div/input[@type='checkbox']");
	public static final By ViewBtninProcessbtn = By.xpath("//button[@onclick='processList(1)']");
	public static final By SearchboxforProcessnameInprocessmaster = By.xpath("//input[@id='searchBoxProcessMaster']");
	public static final By searchboxbtnInprocessmaster = By.xpath("//input[@id='searchBoxProcess1']");
	public static final By BusinessSegmentdropdownInProcessMaster = By
			.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/button");
	public static final By BusinessSegmentDropdownEntervalueInSearchBox = By
			.xpath("//*[@id='partAttributeDiv']/div[2]/div[1]/div[2]/span/div/div/div/input");
	public static final By OHPcheckbox = By.xpath("//input[@id='OHP']");
	public static final By OhpSupplierAllocationList = By
			.xpath("//table[@id='ohpdatatable']/tbody/tr[1]/descendant::input[@type='checkbox']");
	public static final By LengthMeasuringInSupplierPage = By.xpath("//*[@id='example1_length']/label/select");
	public static final By firstTableRowSizeSupplier = By.xpath("//*[@id='example1']/tbody/tr");
	public static final By chooosePhotosSupplierPage = By.xpath("//input[@id='input-image-hidden']");
	public static final By clicknextbtnsupplier = By.xpath("//*[@id='example1_next']/a");
	// public static final By suppliercodeheader =
	// By.xpath("//*[@id=\"example1\"]/thead/tr/th[2]");
	public static final By SupplierCodeColumn = By.xpath("//table[@id='example1']/tbody/tr/td[2]");
	public static final By suppliernameheader = By.xpath("//*[@id='example1']//th[contains(text(), 'Supplier Name')]");
	public static final By SuppliernameColumn = By.xpath("//*[@id='example1']/tbody/tr/td[3]");
	public static final By supplierlocationheader = By
			.xpath("//*[@id='example1']//th[contains(@aria-label, 'Supplier Location')]");
	public static final By supplierlocationColumn = By.xpath("//*[@id='example1']/tbody/tr/td[4]");
	public static final By Businessdomainheader = By
			.xpath("//*[@id='example1']//th[contains(@aria-label,'Business Domain')]");
	public static final By Businessdomaincolumn = By.xpath("//*[@id='example1']/tbody/tr/td[5]");
	public static final By BusinessSegmentinheader = By
			.xpath("//*[@id='example1']//th[contains(@aria-label,'Business Segment')]");
	public static final By BusinessSegmentColumn = By.xpath("//*[@id='example1']/tbody/tr/td[6]");
	public static final By clickexporandimporttbtn = By.xpath(
			"//div[@class='col-md-12  form-group  align-items-center d-flex justify-content-end footer_sticky_button cs_gap_btn ']//button[4]");
	public static final By exportbtn = By.xpath("//*[@id='exportModalForSuppliers']/div/div/div[3]/button[1]");
	public static final By suppliercodelist = By.xpath("//table[@id='example1']/tbody/tr/td[2]\r\n" + "");
	public static final By suppliercodeheader = By.xpath("//table[@id='example1']//tr//th[2]");
	public static final By userbtn = By.xpath("//li[@class='slide']//a[@href=\"/Subscription/Users\"]");
	public static final By userauthorizationtab = By.xpath("//a[@href='#UserAuthorizationTab']");
	public static final By userideditbtn = By.xpath(
			"//table[@id='example2']//tbody//tr[5]//td[4]//a[@href=\"/Subscription/EditUserAuthorize/729f1029-0522-4ff3-8107-e9f9a70e20ce\"]");
	public static final By clickmasterdataforauthorisation = By
			.xpath("//div[@id='jstree']//li[@id=2]//i[@class='jstree-icon jstree-ocl']");
	public static final By clicksupplierforuserauthorisation = By.xpath(
			"//div[@id='jstree']//ul[@class='jstree-children']//li[@id='46']/i[contains(@class, 'jstree-icon') and contains(@class, 'jstree-ocl')]");
	public static final By unselectreadandrightforuserauthorisation = By.xpath("//*[@id='123_anchor']/i[1]");
	public static final By clickupdatebuttonforforuserauthorisation = By.xpath("//a[@id='btnSubmit']");
	public static final By uselectreadbtn = By.xpath("//*[@id='122_anchor']/i[1]");
	public static final By clickdropdwnwhileexportingnewexcelfile = By.xpath(
			"//select[@id='SegmentForExport']/following-sibling::div//button[contains(@class, 'multiselect') and contains(@class, 'dropdown-toggle')]");
	public static final By exportmasterallocationnewsupplire = By.xpath("//input[@id='newsup']");
	public static final By clickdropdiwnselectallwhileexportingnewfile = By
			.xpath("(//button[@title='141235']/span/input)[2]");
	public static final By enterdatadropdownvalue = By
			.xpath("//*[@id='ExprtSuppsegmensts']/div/div[3]/div/span/div/div/div/input");
	public static final By clickyearlycheckboxwhileExportingnewData = By.xpath("//input[@id='Yearly']");
	public static final By clickfirstDropdownwhileExpoertingnewfile = By
			.xpath("//*[@id='Domestic_YearlyRBtn']/div/div[3]/div/span/div/button/span");
	public static final By entervalueinfirstdropdown = By
			.xpath("//*[@id='Domestic_YearlyRBtn']/div/div[3]/div/span/div/div/div/input");
	public static final By clickfirstvalueindropdown = By.xpath("//button[@title='CRCA-007']/span/input");
	public static final By clicksecondDropdownwhileExportingNewfile = By.xpath(
			"//label[normalize-space(text())='Process']/parent::div/following-sibling::div//button[contains(@class, 'dropdown-toggle')]");
	public static final By clickthirdDropdownwhileExportingNewfile = By
			.xpath("//*[@id='OHPName']/div/div[3]/div/span/div/button/span");
	public static final By searchvalueforsecoddropdown = By.xpath(
			"//select[@id='ProcessdropdownSupp']/following-sibling::div/button/following-sibling::div//input[@class='multiselect-search form-control']");
	public static final By clickseconddropdownvalue = By.xpath(
			"//select[@id='ProcessdropdownSupp']/following-sibling::div/div/button/descendant::input");
	public static final By searchvalueforthirddropdown = By.xpath(
			"//select[@id='ohpSuppliernew']/following-sibling::div/button/following-sibling::div//input[@class='multiselect-search form-control']");
	public static final By clickthirdvalue = By.xpath(
			"(//select[@id='ohpSuppliernew']/following-sibling::div/button/following-sibling::div//div/following-sibling::button)[2]/span/input");
	public static final By searchboxinsupplierpage = By.xpath("(//input[@class='form-control form-control-sm'])[1]");
	public static final By ohpcheckbox = By.xpath("//input[@id='OHP']");
	public static final By ohpDataTableInsupplierpage = By
			.xpath("//table[@id='ohpdatatable']//tbody//tr[2]//td[2]//div//input[@id='ohpdatackeched2']");
	public static final By clickviewbtnohptable = By.xpath("//button[@id='btnView']");

	public static final By Ohpsearhbox = By.xpath("//input[@class='form-control form-control-sm']");

	public static final By clickeditbtnohppage = By.xpath("//table[@id='example1']/tbody/tr/td[6]/a/span/i");

	public void clickbusinessseganddomainpage() {

		clickOnElement(BusinessDomainSegments);
	}

	public void businessDomainSelectDropdownByValue() throws InterruptedException {
	    LoggerUtil.info("Step 1: Waiting for dropdown presence");

	    WebElement dropdown = waitForElement(CategoryTypeDropdownBusinessSegAndDomain, 20);

	    LoggerUtil.info("Step 2: Dropdown found. Selecting value 'Business Domain'");

	    Select select = new Select(dropdown);
	    select.selectByVisibleText("Business Domain");

	    LoggerUtil.pass("Business Domain dropdown value selected successfully.");
	}


	public void savedatawithbusinessdomain(String categoryname, String message) throws InterruptedException {
		LoggerUtil.info("Step 1: Waiting before saving data");
		Thread.sleep(6000);

		LoggerUtil.info("Step 2: Selecting Business Domain dropdown value");
		businessDomainSelectDropdownByValue();

		LoggerUtil.info("Step 3: Enter category name: " + categoryname);
		clearAndEnterText(waitForExpectedElement(enetrcategoryname), categoryname);

		LoggerUtil.info("Step 4: Click on Save button");
		clickOnElement(savebutton);

		String actualToast = waitForExpectedElement(toastmessage).getText();
		LoggerUtil.info("Step 5: Verifying toast message. Expected: " + message + " | Actual: " + actualToast);

		if (actualToast.contains(message)) {
			LoggerUtil.pass("Toast message verified successfully.");
		} else {
			LoggerUtil.fail("Toast message mismatch. Expected: " + message + " | Actual: " + actualToast);
		}
	}

	public void businesssegmentSelectDropdownByValue() throws InterruptedException {
	    LoggerUtil.info("Step 1: Waiting for Business Segment dropdown");

	    // Wait for dropdown using custom wait (NO ExpectedConditions)
	    WebElement businessSegmentDropdown = waitForElement(CategoryTypeDropdownBusinessSegAndDomain, 20);

	    LoggerUtil.info("Step 2: Clicking on Business Segment dropdown");
	    businessSegmentDropdown.click();

	    LoggerUtil.info("Step 3: Selecting value '3' from Business Segment dropdown");
	    selectDropDownValueWithoutExpectedConditions(businessSegmentDropdown, "Business Segments");

	    LoggerUtil.pass("Business Segment dropdown value '3' selected successfully.");
	}
	private void selectDropDownValueWithoutExpectedConditions(WebElement dropdown, String visibleText) {
	    Select select = new Select(dropdown);
	    select.selectByVisibleText(visibleText);
	}

	public void savedatawithbusinesssegment(String categoryname, String message) throws InterruptedException {
		LoggerUtil.info("Step 1: Waiting before entering Business Segment data");
		
		Thread.sleep(3000);

		LoggerUtil.info("Step 2: Selecting Business Segment dropdown value");
		businesssegmentSelectDropdownByValue();
		Thread.sleep(2000);
		LoggerUtil.info("Step 3: Entering category name: " + categoryname);
		clearAndEnterText(waitForExpectedElement(enetrcategoryname), categoryname);

		LoggerUtil.info("Step 4: Clicking on Save button");
		clickOnElement(savebutton);

		String actualToast = waitForExpectedElement(toastmessage).getText();
		LoggerUtil.info("Step 5: Verifying toast message. Expected: " + message + " | Actual: " + actualToast);

		if (actualToast.contains(message)) {
			LoggerUtil.pass("Toast message verified successfully.");
		} else {
			LoggerUtil.fail("Toast message mismatch. Expected: " + message + " | Actual: " + actualToast);
		}
		
	}

	public void saveudplicatedata(String categoryname, String message) throws InterruptedException {
		LoggerUtil.info("Step 1: Waiting before saving duplicate data");
		
Thread.sleep(4000);
LoggerUtil.info("Step 2: Selecting Business Domain dropdown value");
		businessDomainSelectDropdownByValue();

		LoggerUtil.info("Step 3: Entering category name: " + categoryname);
		clearAndEnterText(waitForExpectedElement(enetrcategoryname), categoryname);

		LoggerUtil.info("Step 4: Clicking on Save button");
		clickOnElement(savebutton);

		String actualToast = waitForExpectedElement(toastmessage).getText();
		LoggerUtil.info("Step 5: Verifying toast message. Expected: " + message + " | Actual: " + actualToast);

		if (actualToast.contains(message)) {
			LoggerUtil.pass("Toast message verified successfully. Duplicate data handled.");
		} else {
			LoggerUtil.fail("Toast message mismatch. Expected: " + message + " | Actual: " + actualToast);
		}
	}

	public void saveudplicatedataWithBusinessSegment(String categoryname, String message) throws InterruptedException {
		LoggerUtil.info("Step 1: Waiting before saving duplicate data");
		
		Thread.sleep(4000);

		LoggerUtil.info("Step 2: Selecting Business Segment dropdown value");
		businesssegmentSelectDropdownByValue();

		LoggerUtil.info("Step 3: Entering category name: " + categoryname);
		clearAndEnterText(waitForExpectedElement(enetrcategoryname), categoryname);

		LoggerUtil.info("Step 4: Clicking on Save button");
		clickOnElement(savebutton);

		String actualToast = waitForExpectedElement(toastmessage).getText();
		LoggerUtil.info("Step 5: Verifying toast message. Expected: " + message + " | Actual: " + actualToast);

		if (actualToast.contains(message)) {
			LoggerUtil.pass("Toast message verified successfully. Duplicate data handled.");
		} else {
			LoggerUtil.fail("Toast message mismatch. Expected: " + message + " | Actual: " + actualToast);
		}
	}

	public void clickEditButton(int rowIndex, String categoryname, String message) throws InterruptedException {
		LoggerUtil.info("STEP 1: Fetching all edit buttons from the page.");
		List<WebElement> buttons = driver.findElements(edit_buttons);

		if (!buttons.isEmpty() && rowIndex < buttons.size()) {
			LoggerUtil.info("STEP 2: Clicking on Edit button at row index: " + rowIndex);
			buttons.get(rowIndex).click();
		} else {
			LoggerUtil.error("Invalid row index or no edit buttons found. RowIndex: " + rowIndex);
			Assert.fail("Edit button not found or invalid index.");
			return;
		}

		LoggerUtil.info("STEP 3: Entering category name: " + categoryname);
		clearAndEnterText(waitForExpectedElement(enetrcategoryname), categoryname);

		

		LoggerUtil.info("STEP 4: Clicking on Save button.");
		clickOnElement(savebutton);

		

		String actualToast = waitForExpectedElement(toastmessage).getText();
		LoggerUtil.info("STEP 5: Validating toast message. Expected: " + message + " | Actual: " + actualToast);

		if (actualToast.contains(message)) {
			LoggerUtil.pass("Toast message verified successfully after editing data.");
		} else {
			LoggerUtil.fail("Toast message mismatch. Expected: " + message + " | Actual: " + actualToast);
		}
	}

	public void businessdomainsegmentlengthtable(String value) {
		try {
			LoggerUtil.info("STEP 1: Opening dropdown to select table length value: " + value);
			WebElement lengthdropdown = waitForExpectedElement(CategoryTypeDropdownBusinessSegAndDomain);
			lengthdropdown.click();

			LoggerUtil.info("STEP 2: Selecting value '" + value + "' from length dropdown.");
			selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");

			LoggerUtil.info("STEP 3: Waiting for business domain segments table to be visible.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

			LoggerUtil.info("STEP 4: Fetching all rows from the table.");
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));
			int rowCount = rows.size();
			LoggerUtil.info("Total Rows in Table: " + rowCount);

			LoggerUtil.info("STEP 5: Verifying table row count is 25.");
			Assert.assertEquals(rowCount, 25, " Table does NOT have 25 rows!");
			LoggerUtil.pass(" Table has exactly 25 rows as expected.");

		} catch (Exception e) {
			LoggerUtil.fail(
					" Exception occurred while verifying business domain segment table length: " + e.getMessage());
			throw e;
		}
	}

	public void clickbusinessdomainsegmentlengthtableforfifty(String value) {
		try {
			LoggerUtil.info("STEP 1: Opening dropdown to select table length value: " + value);
			WebElement lengthdropdown = waitForExpectedElement(CategoryTypeDropdownBusinessSegAndDomain);
			lengthdropdown.click();

			LoggerUtil.info("STEP 2: Selecting value '" + value + "' from length dropdown.");
			selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");

			LoggerUtil.info("STEP 3: Waiting for business domain segments table to be visible.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

			LoggerUtil.info("STEP 4: Fetching all rows from the table.");
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));
			int rowCount = rows.size();
			LoggerUtil.info("Total Rows in Table: " + rowCount);

			LoggerUtil.info("STEP 5: Verifying table row count is 50.");
			Assert.assertEquals(rowCount, 50, " Table does NOT have 50 rows!");
			LoggerUtil.pass(" Table has exactly 50 rows as expected.");

		} catch (Exception e) {
			LoggerUtil.fail(" Exception occurred while verifying business domain segment table length for 50: "
					+ e.getMessage());
			throw e;
		}
	}

	public void clickbusinessdomainsegmentlengthtableforseventyfive(String value) {
		try {
			LoggerUtil.info("STEP 1: Opening dropdown to select table length value: " + value);
			WebElement lengthdropdown = waitForExpectedElement(CategoryTypeDropdownBusinessSegAndDomain);
			lengthdropdown.click();

			LoggerUtil.info("STEP 2: Selecting value '" + value + "' from length dropdown.");
			selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");

			LoggerUtil.info("STEP 3: Waiting for business domain segments table to be visible.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

			LoggerUtil.info("STEP 4: Fetching all rows from the table.");
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));
			int rowCount = rows.size();
			LoggerUtil.info("Total Rows in Table: " + rowCount);

			LoggerUtil.info("STEP 5: Verifying table row count is 75.");
			Assert.assertEquals(rowCount, 75, " Table does NOT have 75 rows!");
			LoggerUtil.pass(" Table has exactly 75 rows as expected.");

		} catch (Exception e) {
			LoggerUtil.fail(" Exception occurred while verifying business domain segment table length for 75: "
					+ e.getMessage());
			throw e;
		}
	}

	public void findsecondpagefirstrowtwentysixthnumber() {
		try {
			LoggerUtil.info("STEP 1: Clicking on the 'Next' button to go to the second page.");
			clickOnElement(clicknextbutton);

			LoggerUtil.info("STEP 2: Waiting for 'businessdomainSegmentsTable' to be visible.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

			LoggerUtil.info("STEP 3: Fetching all rows from the second page of the table.");
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));
			int rowCount = rows.size();
			LoggerUtil.info(" Rows found on second page: " + rowCount);

		
			if (rowCount == 25) {
				LoggerUtil.pass(" Table has exactly 25 rows on the second page as expected.");
			} else if (rowCount == 0) {
				LoggerUtil.fail(" No rows found on the second page. Expected 25 rows!");
				Assert.fail("Table is empty on second page.");
			} else {
				LoggerUtil.fail(" Unexpected number of rows found: " + rowCount + ". Expected 25 rows.");
				Assert.fail("Row count mismatch on second page.");
			}

		} catch (Exception e) {
			LoggerUtil.fail(" Exception occurred while verifying second page table rows: " + e.getMessage());
			throw e;
		}
	}

	public void validateNumeberOfRecordOnPage(String numberRecord) throws InterruptedException {

		WebElement lengthdropdown = waitForExpectedElement(numberofentriesdropdown);
		selectDropDownValue(numberofentriesdropdown, "visibleText", numberRecord);

		int expectedNumberRecordValue = Integer.parseInt(numberRecord);

		List<WebElement> testList = driver.findElements(firsttablerowsize);

		int actualRecord = testList.size();

		Assert.assertEquals(actualRecord, expectedNumberRecordValue);

	}

	public void entersuppliertab(String supplierCode, String supplierNode, String supplierlocation, String search)
			throws InterruptedException {
		try {
			LoggerUtil.info("STEP 1: Navigating to Supplier Tab.");
			clickOnElement(suppliersecondtab);

			LoggerUtil.info("STEP 2: Entering Supplier Code: " + supplierCode);
			clearAndEnterText(waitForExpectedElement(suupliercode), supplierCode);

			LoggerUtil.info("STEP 3: Entering Supplier Name: " + supplierNode);
			clearAndEnterText(waitForExpectedElement(suppliername), supplierNode);

			LoggerUtil.info("STEP 4: Entering Supplier Location: " + supplierlocation);
			clearAndEnterText(waitForExpectedElement(supplerlocation), supplierlocation);

			LoggerUtil.info("STEP 5: Selecting Business Domain.");
			clickOnElement(businnessdomaidropdown);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
			clickOnElement(businessDomainCheckBox);

			LoggerUtil.info("STEP 6: Selecting Business Segment.");
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);

			LoggerUtil.info("STEP 7: Saving supplier details.");
			clickOnElement(clickingSavebuttonSupplierMasterPage);

			LoggerUtil.info("STEP 8: Navigating to Business Domain Segments.");
			clickOnElement(BusinessDomainSegments);

			Thread.sleep(5000);
			LoggerUtil.info("STEP 9: Searching for Supplier: " + search);
			clearAndEnterText(waitForExpectedElement(searchbutton), search);

			LoggerUtil.info("STEP 10: Clicking delete button for searched supplier.");
			clickOnElement(deletebtnBusinessDomainSegMentTab);
			Thread.sleep(5000);

			LoggerUtil.info("STEP 11: Accepting delete confirmation alert.");
			driver.switchTo().alert().accept();
			Thread.sleep(5000);

			LoggerUtil.info("STEP 12: Verifying toast message after delete action.");
			String actualToast = waitForExpectedElement(toastmessage).getText();
			String expectedToast = "Data Already Being Used in Costing!";

			if (actualToast.equals(expectedToast)) {
				LoggerUtil.pass(" Correct toast message displayed: " + actualToast);
			} else {
				LoggerUtil.fail(
						" Incorrect toast message! Expected: '" + expectedToast + "' but Found: '" + actualToast + "'");
				Assert.fail("Toast message mismatch.");
			}

		} catch (Exception e) {
			LoggerUtil.fail(" Exception occurred while entering Supplier tab details: " + e.getMessage());
			throw e;
		}
	}

	public void deletingcostingsegmentdata(String supplierCode, String supplierNode, String supplierlocation,
	        String search) throws InterruptedException {

	    LoggerUtil.info("Step 1: Clicking on Supplier second tab");
	    clickOnElement(suppliersecondtab);

	    LoggerUtil.info("Step 2: Entering Supplier Code: " + supplierCode);
	    clearAndEnterText(waitForExpectedElement(suupliercode), supplierCode);

	    LoggerUtil.info("Step 3: Entering Supplier Name: " + supplierNode);
	    clearAndEnterText(waitForExpectedElement(suppliername), supplierNode);

	    LoggerUtil.info("Step 4: Entering Supplier Location: " + supplierlocation);
	    clearAndEnterText(waitForExpectedElement(supplerlocation), supplierlocation);

	    LoggerUtil.info("Step 5: Selecting Business Domain");
	    clickOnElement(businnessdomaidropdown);
	    clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
	    clickOnElement(businessDomainCheckBox);

	    LoggerUtil.info("Step 6: Selecting Business Segment");
	    clickOnElement(businesssegmentdropdown);
	    clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
	    clickOnElement(businessSegmentCheckBox);

	    LoggerUtil.info("Step 7: Clicking Save button on Supplier Master Page");
	    clickOnElement(clickingSavebuttonSupplierMasterPage);

	    LoggerUtil.info("Step 8: Clicking Business Domain Segments tab");
	    clickOnElement(BusinessDomainSegments);

	    LoggerUtil.info("Step 9: Waiting before performing search");
	  

	    LoggerUtil.info("Step 10: Entering search value: " + search);
	    clearAndEnterText(waitForExpectedElement(searchbutton), search);

	    LoggerUtil.info("Step 11: Clicking delete button for Business Segment");
	    clickOnElement(deletebusinessSegment);

	    LoggerUtil.info("Step 12: Handling confirmation alert");
	    driver.switchTo().alert().accept();

	    LoggerUtil.info("Step 13: Waiting for toast message");
	   

	    String actualToast = waitForExpectedElement(toastmessage).getText();
	    String expectedToast = "Data Already Being Used in Costing!";

	    LoggerUtil.info("Step 14: Validating toast message");
	    if (actualToast.equals(expectedToast)) {
	        LoggerUtil.pass("Toast message verified successfully → " + actualToast);
	    } else {
	        LoggerUtil.mismatch("Toast message mismatch!", expectedToast, actualToast);
	    }
	}


	public boolean userEnterWithInValiDataInSupplierPage(String supcode, String supname, String suplocation,
			String managername, String mail1, String mail2, String contact, String contact1, String expectedErrorMsg) {
		try {
			LoggerUtil.info("STEP 1: Entering Supplier Code: " + supcode);
			clearAndEnterText(waitForExpectedElement(suupliercode), supcode);

			LoggerUtil.info("STEP 2: Entering Supplier Name: " + supname);
			clearAndEnterText(waitForExpectedElement(suppliername), supname);

			LoggerUtil.info("STEP 3: Entering Supplier Location: " + suplocation);
			clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);

			LoggerUtil.info("STEP 4: Selecting Business Domain.");
			clickOnElement(businnessdomaidropdown);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
			clickOnElement(businessDomainCheckBox);

			LoggerUtil.info("STEP 5: Selecting Business Segment.");
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);

			LoggerUtil.info("STEP 6: Entering Manager Name: " + managername);
			clearAndEnterText(waitForExpectedElement(managernamefield), managername);

			LoggerUtil.info("STEP 7: Entering Email ID 1: " + mail1);
			clearAndEnterText(waitForExpectedElement(Emailid1), mail1);

			LoggerUtil.info("STEP 8: Entering Email ID 2: " + mail2);
			clearAndEnterText(waitForExpectedElement(Emailid2), mail2);

			LoggerUtil.info("STEP 9: Entering Contact 1: " + contact);
			clearAndEnterText(waitForExpectedElement(this.contact), contact);

			LoggerUtil.info("STEP 10: Entering Contact 2: " + contact1);
			clearAndEnterText(waitForExpectedElement(this.contact1), contact1);

			LoggerUtil.info("STEP 11: Clicking Save button.");
			clickOnElement(clickingSavebuttonSupplierMasterPage);

			LoggerUtil.info("STEP 12: Capturing Toast/Error message after save.");
			String actualMsg = waitForExpectedElement(toastmessage).getText();

			if (actualMsg.contains(expectedErrorMsg)) {
				LoggerUtil.pass(" Validation Passed. Expected error message found: " + actualMsg);
				return true;
			} else {
				LoggerUtil.fail(
						" Validation Failed. Expected: '" + expectedErrorMsg + "' but Found: '" + actualMsg + "'");
				return false;
			}

		} catch (Exception e) {
			LoggerUtil.fail(" Exception occurred while validating supplier data entry: " + e.getMessage());
			throw e;
		}
	}
	public void waitForSupplierTableToLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // 1️⃣ Wait for DataTable wrapper
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("example1_wrapper")));

	    // 2️⃣ Wait for search box
	    wait.until(ExpectedConditions.presenceOfElementLocated(EnterSearchValueInSupplierMaster));

	    // 3️⃣ Wait for table body
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//table[@id='example1']//tbody")));

	    // 4️⃣ Wait until at least one row OR "No records"
	    wait.until(driver -> {
	        List<WebElement> rows =
	                driver.findElements(By.xpath("//table[@id='example1']//tbody/tr"));
	        return !rows.isEmpty();
	    });

	    LoggerUtil.info("Supplier table loaded and ready.");
	}

	public static final By EnterSearchValueInSupplierMaster = By.xpath("//div[@id='example1_filter']/label/input");

	public boolean IsDataSavedAsItIsInTableOrNot(
	        String supplierCode,
	        String supplierName,
	        String supplierLocation,
	        String businessDomain,
	        String businessSegments) throws Exception {

	    try {

	        LoggerUtil.info("===== Starting Supplier Table Data Verification =====");

	        // =====================================================
	        // STEP 0: Check if Supplier table/search box is loaded
	        // (Known issue handling – user cannot proceed)
	        // =====================================================
	        if (driver.findElements(EnterSearchValueInSupplierMaster).isEmpty()) {

	            LoggerUtil.warn(
	                    "KNOWN ISSUE: Supplier table/search input not loaded. "
	                  + "User cannot verify saved data. Exiting verification.");

	            return false; // ⛔ EXIT safely
	        }

	        // =====================================================
	        // STEP 1: Wait for table to load
	        // =====================================================
	        waitForSupplierTableToLoad();

	        // =====================================================
	        // STEP 2: Search supplier safely
	        // =====================================================
	        WebElement searchBox = waitForExpectedElement(EnterSearchValueInSupplierMaster);
	        searchBox.clear();
	        searchBox.sendKeys(supplierName);

	        Thread.sleep(1500); // allow DataTable filter

	        LoggerUtil.info("STEP 1: Fetching rows after search.");

	        List<WebElement> rowsList =
	                driver.findElements(By.xpath("//table[@id='example1']//tbody/tr"));

	        // =====================================================
	        // STEP 3: No rows found
	        // =====================================================
	        if (rowsList.isEmpty()) {
	            LoggerUtil.fail("No rows found after search for supplier: " + supplierName);
	            return false;
	        }

	        LoggerUtil.info("STEP 2: Iterating rows to verify supplier data.");

	        // =====================================================
	        // STEP 4: Iterate rows
	        // =====================================================
	        for (WebElement row : rowsList) {

	            // Handle "No matching records found"
	            if (row.getText().toLowerCase().contains("no matching")) {
	                LoggerUtil.fail("No matching records found for supplier: " + supplierName);
	                return false;
	            }

	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            if (columns.size() < 6) {
	                LoggerUtil.info("Skipping row with insufficient columns: " + columns.size());
	                continue;
	            }

	            String actualCode = columns.get(1).getText().trim();
	            String actualName = columns.get(2).getText().trim();
	            String actualLocation = columns.get(3).getText().trim();
	            String actualDomain = columns.get(4).getText().trim();
	            String actualSegment = columns.get(5).getText().trim();

	            LoggerUtil.info(
	                    "Row -> Code=" + actualCode +
	                    ", Name=" + actualName +
	                    ", Location=" + actualLocation +
	                    ", Domain=" + actualDomain +
	                    ", Segment=" + actualSegment
	            );

	            // =====================================================
	            // STEP 5: Match verification
	            // =====================================================
	            if (actualCode.equals(supplierCode)
	                    && actualName.equals(supplierName)
	                    && actualLocation.equals(supplierLocation)
	                    && actualDomain.equals(businessDomain)
	                    && actualSegment.equals(businessSegments)) {

	                LoggerUtil.pass("Supplier data verified successfully in table.");
	                return true;
	            }
	        }

	        // =====================================================
	        // STEP 6: Data not found
	        // =====================================================
	        LoggerUtil.fail("Supplier data NOT found in table.");
	        return false;

	    } catch (Exception e) {
	        LoggerUtil.fail("Exception during supplier table verification: " + e.getMessage());
	        throw e;
	    }
	}


	public void entersuppliervalueforProcessInPut(String supplierCode, String supplierNode, String supplierlocation,
			String EnterEmailid, String EnterEmailid2, String Entermanagernamefield) throws InterruptedException {

		try {
// Supplier Tab
			clickOnElement(suppliersecondtab);
			LoggerUtil.pass(" Clicked on Supplier second tab");

// Supplier Code
			clearAndEnterText(waitForExpectedElement(suupliercode), supplierCode);
			LoggerUtil.pass(" Entered Supplier Code: " + supplierCode);

// Supplier Name
			clearAndEnterText(waitForExpectedElement(suppliername), supplierNode);
			LoggerUtil.pass(" Entered Supplier Name: " + supplierNode);

// Supplier Location
			clearAndEnterText(waitForExpectedElement(supplerlocation), supplierlocation);
			LoggerUtil.pass(" Entered Supplier Location: " + supplierlocation);

// Business Domain
			clickOnElement(businnessdomaidropdown);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
			clickOnElement(businessDomainCheckBox);
			LoggerUtil.pass(" Selected Business Domain: rishi");

// Business Segment
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);
			LoggerUtil.pass(" Selected Business Segment: sachindra1");


// Process Allocation
			clickOnElement(processchkbox);
			Thread.sleep(4000);
			LoggerUtil.pass(" Clicked Process Allocation checkbox");

			Thread.sleep(4000);

			clickOnElement(processAllocationlistsupplierPageTable);
			LoggerUtil.pass(" Selected Process from dropdown/list");

			Thread.sleep(6000);



// Save Supplier
			WebElement clickingSavebtn = driver.findElement(By.xpath("//button[@onclick='savesupplier()']"));
			clickingSavebtn.click();
			LoggerUtil.pass("✅ Clicked Save button for Supplier");

			Thread.sleep(3000);

		} catch (Exception e) {
			LoggerUtil.error("❌ Error during Supplier RM input process: " + e.getMessage());
		}
	}
	

	public HashMap<String, String> entersuppliervalueforrminput(String supplierCode, String supplierNode,
	        String supplierlocation, String EnterEmailid, String EnterEmailid2, String Entermanagernamefield)
	        throws InterruptedException {
 
	    HashMap<String, String> rowDataInSupplierPage = new HashMap<>();
 
	    try {
	        // Supplier Tab
	        clickOnElement(suppliersecondtab);
	        LoggerUtil.pass("✅ Clicked on Supplier second tab");
 
	        // Supplier Code
	        clearAndEnterText(waitForExpectedElement(suupliercode), supplierCode);
	        LoggerUtil.pass("✅ Entered Supplier Code: " + supplierCode);
 
	        // Supplier Name
	        clearAndEnterText(waitForExpectedElement(suppliername), supplierNode);
	        LoggerUtil.pass("✅ Entered Supplier Name: " + supplierNode);
 
	        // Supplier Location
	        clearAndEnterText(waitForExpectedElement(supplerlocation), supplierlocation);
	        LoggerUtil.pass("✅ Entered Supplier Location: " + supplierlocation);
 
	        // Business Domain
	        clickOnElement(businnessdomaidropdown);
	        clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
	        clickOnElement(businessDomainCheckBox);
	        LoggerUtil.pass("✅ Selected Business Domain: rishi");
 
	        // Business Segment
	        clickOnElement(businesssegmentdropdown);
	        clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
	        clickOnElement(businessSegmentCheckBox);
	        LoggerUtil.pass("✅ Selected Business Segment: sachindra1");
 
	        // RM Allocation Checkbox
	        clickOnElement(ClickingRmCheckbox);
	        LoggerUtil.pass("✅ Clicked RM Allocation checkbox");
 
	        Thread.sleep(3000);
 
	        // Select RM from list
	        clickOnElement(rmlistselect);
	        LoggerUtil.pass("✅ Selected RM from dropdown/list");
 
	        Thread.sleep(2500);
 
	        // Select checkbox inside RM table first row
	        try {
	            WebElement tableCheckbox = driver.findElement(
	                By.xpath("//table[@id='rmdatatable']//tbody/tr[1]//input[@type='checkbox']"));
 
	            if (!tableCheckbox.isSelected()) {
	                tableCheckbox.click();
	                LoggerUtil.pass("✔ RM Allocation checkbox selected in table (Row 1)");
	            } else {
	                LoggerUtil.pass("✔ RM Allocation checkbox already selected in table");
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("❌ RM Allocation table checkbox NOT FOUND: " + e.getMessage());
	        }
 
	        Thread.sleep(2500);
 
	        // Fetch RM data after selecting checkbox
	        rowDataInSupplierPage = QuickMasterPage.verifyFetchingRmDataInSupplierMasterTableForVerifyRmAllocation();
	        LoggerUtil.pass("✅ RM Data Stored in HashMap Successfully → " + rowDataInSupplierPage);
 
	        // Save Supplier
	        WebElement clickingSavebtn = driver.findElement(By.xpath("//button[@onclick='savesupplier()']"));
	        clickingSavebtn.click();
	        LoggerUtil.pass("✅ Clicked Save button for Supplier");
 
	        Thread.sleep(3000);
 
	    } catch (Exception e) {
	        LoggerUtil.error("❌ Error during Supplier RM input process: " + e.getMessage());
	    }
 
	    // ⛔ MOST IMPORTANT PART
	    return rowDataInSupplierPage;
	}
 

	////////////////////////////////////////////////////////OHP Master//////////////////////////////////////////////////////////////////
	
	
	public static final By clickingOhpCheckbox = By.xpath("//input[@id='OHP']");
	
	public static final By clickinglist = By.xpath("//input[@id='ohpdatackeched2']");
	
	public void entersuppliervalueforOHPInput(String supplierCode, String supplierNode, String supplierlocation,
			String EnterEmailid, String EnterEmailid2, String Entermanagernamefield) throws InterruptedException {

		try {
// Supplier Tab
			clickOnElement(suppliersecondtab);
			LoggerUtil.pass("✅ Clicked on Supplier second tab");

// Supplier Code
			clearAndEnterText(waitForExpectedElement(suupliercode), supplierCode);
			LoggerUtil.pass("✅ Entered Supplier Code: " + supplierCode);

// Supplier Name
			clearAndEnterText(waitForExpectedElement(suppliername), supplierNode);
			LoggerUtil.pass("✅ Entered Supplier Name: " + supplierNode);

// Supplier Location
			clearAndEnterText(waitForExpectedElement(supplerlocation), supplierlocation);
			LoggerUtil.pass("✅ Entered Supplier Location: " + supplierlocation);

// Business Domain
			clickOnElement(businnessdomaidropdown);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
			clickOnElement(businessDomainCheckBox);
			LoggerUtil.pass("✅ Selected Business Domain: rishi");

// Business Segment
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);
			LoggerUtil.pass("✅ Selected Business Segment: sachindra1");


// Ohp Allocation
			clickOnElement(clickingOhpCheckbox);
			Thread.sleep(4000);
			LoggerUtil.pass("✅ Clicked Ohp Allocation checkbox");

			Thread.sleep(4000);

			clickOnElement(OhpSupplierAllocationList);
			LoggerUtil.pass("✅ Selected Ohp from dropdown/list");

			Thread.sleep(6000);




			Thread.sleep(3000);

		} catch (Exception e) {
			LoggerUtil.error("❌ Error during Supplier RM input Ohp: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	public boolean isDataPresent(String searchText) throws InterruptedException {
		List<WebElement> rows = driver.findElements(commoditytablelist);
		Thread.sleep(4000);
		for (WebElement row : rows) {
			if (row.getText().contains(searchText)) {
				System.out.println("✅ Data Found: " + row.getText());
				return true;
			}
		}
		System.out.println(" Data Not Found in Table!");
		return false;
	}

	public void searchAndEditGrade(String grade) throws InterruptedException {
		// Step 1: Search for the grade in the search bar
		clearAndEnterText(waitForExpectedElement(commoditysearchtab), grade);
		Thread.sleep(2000); // wait for the table to update after searching

		// Step 2: Locate the row containing the grade
		String gradeXpath = "//table//tr[td[contains(text(),'" + grade + "')]]//button[contains(text(),'Edit')]";

		Thread.sleep(3000);
		clickOnElement(clickonEditgradebtn);

	}

	public void searchAndVerifySelection(String supplierName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout

		// Wait for the dropdown to be visible
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/button")));
		if (dropdown != null && dropdown.isDisplayed()) {
			System.out.println("Dropdown is visible");

			// Click to open the dropdown
			dropdown.click();

			// Wait for the search input box
			WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/div/input")));
			searchInput.sendKeys(supplierName);

			// Wait for the results to populate and check the selection
			Thread.sleep(500); // Consider using an explicit wait for the checkbox

			// Find the checkbox based on the supplier name
			WebElement supplierCheckbox = driver.findElement(By.xpath(
					"//button[@class='multiselect-option dropdown-item active']//label[text()='sachindra1']/preceding-sibling::input"));

			if (supplierCheckbox.isSelected()) {
				System.out.println("✅ Supplier '" + supplierName + "' is selected.");
			} else {
				System.out.println("❌ Supplier '" + supplierName + "' is not selected.");
			}
		} else {
			System.out.println("Dropdown is not visible.");
		}
	}

	public static final By clickeditbtnInProcessTable = By.xpath("//table[@id='unitTable1']/tbody/tr[1]/td[2]/a/i");

	

	public void entersuppliervalueforohpallocation(String supplierCode, String supplierNode, String supplierlocation)
			throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(suupliercode), supplierCode);

		clearAndEnterText(waitForExpectedElement(suppliername), supplierNode);

		clearAndEnterText(waitForExpectedElement(supplerlocation), supplierlocation);

		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);
		Thread.sleep(5000);
		clickOnElement(OHPcheckbox);
		Thread.sleep(4000);
		clickOnElement(OhpSupplierAllocationList);
		Thread.sleep(5000);
		clickOnElement(clickingSavebuttonSupplierMasterPage);

	}

	public void validateShadowText(By ele, String enterText) {
		try {
			if (enterText != null && !enterText.trim().isEmpty()) {
				// Case 1: Enter text → aria-invalid = false
				LoggerUtil.info("STEP 1: Entering text '" + enterText + "' into field: " + ele);
				clearAndEnterText(waitForExpectedElement(ele), enterText);

				LoggerUtil.info("STEP 2: Pressing TAB to shift focus.");
				pressTab();

				String value = waitForExpectedElement(ele).getDomAttribute("aria-invalid");
				LoggerUtil.info("Captured 'aria-invalid' value after entering text: " + value);

				boolean actualValue = Boolean.parseBoolean(value);

				if (!actualValue) {
					LoggerUtil.pass("✅ Validation Passed → aria-invalid is FALSE when value is entered in " + ele);
				} else {
					LoggerUtil.fail("❌ Validation Failed → aria-invalid is TRUE even after entering value in " + ele);
				}

				Assert.assertFalse(actualValue);

			} else {
				// Case 2: Blank value → aria-invalid = true
				LoggerUtil.info("STEP 1: Clearing value from element: " + ele);
				clearAndEnterText(waitForExpectedElement(ele), ""); // blank

				LoggerUtil.info("STEP 2: Pressing TAB to shift focus.");
				pressTab();

				String value = waitForExpectedElement(ele).getDomAttribute("aria-invalid");
				LoggerUtil.info("Captured 'aria-invalid' value after blank input: " + value);

				boolean actualValue = Boolean.parseBoolean(value);

				if (actualValue) {
					LoggerUtil.pass("✅ Validation Passed → aria-invalid is TRUE when field is blank: " + ele);
				} else {
					LoggerUtil.fail("❌ Validation Failed → aria-invalid is FALSE even though field is blank: " + ele);
				}

				Assert.assertTrue(actualValue);
			}

		} catch (Exception e) {
			LoggerUtil.fail("❌ Exception occurred while validating shadow text: " + e.getMessage());
			throw e;
		}
	}

	public void verifySearchValueandResetButtonIsWorkingOrNot(String searchvalues, String entername,
			String searchnewvalues) throws InterruptedException {
		try {
			Thread.sleep(5000);

			LoggerUtil.info("STEP 2: Searching with value → " + searchvalues);
			clearAndEnterText(waitForExpectedElement(searchboxbusinessSegmentAndDomainTab), searchvalues);

			LoggerUtil.info("STEP 3: Clicking 'Edit' button.");
			clickOnElement(ClickEditbtnBusinessDomainSegment);

			LoggerUtil.info("STEP 4: Clicking 'Reset' button.");
			clickOnElement(ResetButtonBusinessdomainAndSegment);

			LoggerUtil.info("STEP 5: Entering new Category Name → " + entername);
			clearAndEnterText(waitForExpectedElement(enetrcategoryname), entername);

			LoggerUtil.info("STEP 6: Selecting dropdown value.");
			selectDropDownValue(CategoryTypeDropdownBusinessSegAndDomain, "2", "selectValue");

			LoggerUtil.info("STEP 7: Clicking 'Save' button.");
			clickOnElement(savebutton);

			LoggerUtil.info("STEP 8: Validating error message.");
			String actualToast = waitForExpectedElement(toastmessage).getText();
			if (actualToast.equals("Business domain already exist.")) {
				LoggerUtil.pass("Correct error message displayed: " + actualToast);
			} else {
				LoggerUtil.fail("Incorrect error message. Expected: 'Business domain already exist.' but found: "
						+ actualToast);
			}
			Assert.assertEquals(actualToast, "Business domain already exist.");

			LoggerUtil.info("STEP 9: Searching with new value → " + searchnewvalues);
			clearAndEnterText(waitForExpectedElement(searchboxbusinessSegmentAndDomainTab), searchnewvalues);

			LoggerUtil.info("STEP 10: Waiting for business domain table.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

			LoggerUtil.info("STEP 11: Scrolling to table.");
			WebElement table = driver.findElement(By.id("businessdomainSegmentsTable"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
			Thread.sleep(2000);

			LoggerUtil.info("STEP 12: Checking at least one row present.");
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr")));

			LoggerUtil.info("STEP 13: Locating saved value → " + entername);
			WebElement savedvalues = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//table[@id='businessdomainSegmentsTable']//tbody//tr/td[contains(text(), '" + entername
							+ "')]")));

			String actualvalues = savedvalues.getText();
			if (actualvalues.equals(entername)) {
				LoggerUtil.pass("✅ Saved value found. Expected: " + entername + " | Actual: " + actualvalues);
			} else {
				LoggerUtil.fail("❌ Saved value mismatch. Expected: " + entername + " | Actual: " + actualvalues);
			}

			Assert.assertEquals(actualvalues, entername);
			LoggerUtil.pass("Test completed successfully ✅");

		} catch (Exception e) {
			LoggerUtil.fail("❌ Exception: " + e.getMessage());
			throw e;
		}
	}

	public void verifyClickingEditButtonWorksCorrectly(String enterSearchValue) throws InterruptedException {
		LoggerUtil.info("🔍 Searching supplier in grid: " + enterSearchValue);

		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(searchboxsuppleirPage), enterSearchValue);
		Thread.sleep(2000); // Can be improved with WebDriverWait if needed

		LoggerUtil.info("🖱️ Clicking on the Edit icon for supplier: " + enterSearchValue);
		clickOnElement(clickeditbuttonsupplierpage);

		LoggerUtil.info("✅ Edit button clicked and form fields loaded.");
	}

	public Map<String, String> getSupplierDataAfterEdit() {
		LoggerUtil.info("📤 Fetching values from 'Supplier Code' and 'Supplier Name' fields...");

		Map<String, String> supplierData = new HashMap<>();

		String actualSupplierCode = waitForExpectedElement(suupliercode).getDomAttribute("value");
		String actualSupplierName = waitForExpectedElement(suppliername).getDomAttribute("value");

		LoggerUtil.info("📦 Extracted Values After Edit:");
		LoggerUtil.info("➡️ Supplier Code: " + actualSupplierCode);
		LoggerUtil.info("➡️ Supplier Name: " + actualSupplierName);

		supplierData.put("code", actualSupplierCode);
		supplierData.put("name", actualSupplierName);

		return supplierData;
	}

	public String EnterInvalidDataInSupplierCOde(String sname, String scode, String slocation)
			throws InterruptedException {

		LoggerUtil.info("STEP 1: Enter Supplier Name → " + sname);
		clearAndEnterText(waitForExpectedElement(suppliername), sname);

		LoggerUtil.info("STEP 2: Enter Supplier Code → " + scode);
		clearAndEnterText(waitForExpectedElement(suupliercode), scode);

		LoggerUtil.info("STEP 3: Enter Supplier Location → " + slocation);
		clearAndEnterText(waitForExpectedElement(supplerlocation), slocation);

		LoggerUtil.info("STEP 4: Selecting Business Domain");
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);

		LoggerUtil.info("STEP 5: Selecting Business Segment");
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);

	
		LoggerUtil.info("STEP 8: Clicking Save button");
		clickOnElement(clickingSavebuttonSupplierMasterPage);

		LoggerUtil.info("STEP 9: Capturing toast message");
		String toastMsg;
		try {
			toastMsg = waitForExpectedElement(toastmessagesupplierpage).getText();
			LoggerUtil.pass("Toast message captured successfully → " + toastMsg);
		} catch (Exception e) {
			toastMsg = "❌ Toast message not found.";
			LoggerUtil.error("Failed to capture toast message. Exception: " + e.getMessage());
		}

		return toastMsg;
	}

	public void lengthmeasuringinsupplierpage(String numberRecord) {
		LoggerUtil.info("🟩 [START] Verifying number of records displayed in Supplier Page for dropdown value: "
				+ numberRecord);

		LoggerUtil.info("STEP 1: Selecting dropdown value → " + numberRecord);
		WebElement lengthdropdown = waitForExpectedElement(LengthMeasuringInSupplierPage);
		selectDropDownValue(LengthMeasuringInSupplierPage, "visibleText", numberRecord);

		int expectedNumberRecordValue = Integer.parseInt(numberRecord);
		LoggerUtil.info(" Expected number of records: " + expectedNumberRecordValue);

		LoggerUtil.info("STEP 2: Capturing actual number of records from table rows...");
		List<WebElement> testList = driver.findElements(firstTableRowSizeSupplier);
		int actualRecord = testList.size();
		LoggerUtil.info(" Actual number of records displayed: " + actualRecord);

		LoggerUtil.info("STEP 3: Validating actual vs expected record count...");
		if (actualRecord == expectedNumberRecordValue) {
			LoggerUtil.pass(" Record count validation passed. Expected = Actual = " + actualRecord);
		} else {
			LoggerUtil.error(" Record count validation failed. Expected: " + expectedNumberRecordValue + " | Actual: "
					+ actualRecord);
		}

		Assert.assertEquals(actualRecord, expectedNumberRecordValue, " Assertion failed — record count mismatch!");

		LoggerUtil.info("🟦 [END] Verification complete for Supplier Page record length.");
	}

	public void clicknextbuttonInsupplier() {
		LoggerUtil.info("🟩 [START] Navigating to next page in Supplier table...");

		LoggerUtil.info("STEP 1: Clicking on 'Next' button in Supplier Page.");
		clickOnElement(clicknextbtnsupplier);

		LoggerUtil.info("STEP 2: Waiting for table (id='example1') to load...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example1")));

		LoggerUtil.info("STEP 3: Capturing all rows from the second page of the table.");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"example1\"]//tbody/tr"));
		int actualRowCount = rows.size();
		LoggerUtil.info("➡️ Total Rows in Table (Page 2): " + actualRowCount);

		LoggerUtil.info("STEP 4: Validating that table contains 25 rows.");
		if (actualRowCount == 25) {
			LoggerUtil.pass("✅ Table row count validation passed. Found 25 rows as expected.");
		} else {
			LoggerUtil.error("❌ Table row count validation failed. Expected: 25 | Actual: " + actualRowCount);
		}

		Assert.assertEquals(actualRowCount, 25, "❌ Assertion Failed — Table does NOT have 25 rows!");

		LoggerUtil.info("🟦 [END] Next page validation in Supplier table completed.");
	}

	public void selectFile() {
		LoggerUtil.info(" [START] Uploading file in Supplier Page...");

		String filePath = System.getProperty("user.dir") + "/src/test/resources/env.properties";
		LoggerUtil.info("STEP 1: Preparing file path → " + filePath);

		try {
			LoggerUtil.info("STEP 2: Sending file path to file upload element...");
			waitForExpectedElement(chooosePhotosSupplierPage).sendKeys(filePath);
			LoggerUtil.pass(" File uploaded successfully → " + filePath);
		} catch (Exception e) {
			LoggerUtil.error(" File upload failed. Exception: " + e.getMessage());
			Assert.fail("File upload failed due to exception: " + e.getMessage());
		}

		LoggerUtil.info("  File upload process completed.");
	}

	public void sortingWithSupplierCode() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(suppliercodeheader)).click();

		// Ensure table gets updated before fetching new data
		try {
			Thread.sleep(2000); // Small delay to let table update
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<String> getSupplierCodes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for table data to change after sorting
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(SupplierCodeColumn)));

		return driver.findElements(SupplierCodeColumn).stream().map(WebElement::getText).map(String::trim) // Trim
				// whitespace
				.map(String::toLowerCase) // Normalize case for accurate comparison
				.collect(Collectors.toList());
	}

	public boolean isSortedDescending(List<String> codes) {
		LoggerUtil.info(" [START] Verifying if list is sorted in descending order...");
		LoggerUtil.info(" Original Codes: " + codes);

		List<String> sortedList = new ArrayList<>(codes);
		sortedList.sort(Comparator.reverseOrder());

		LoggerUtil.info(" Expected Sorted Codes (Descending): " + sortedList);

		for (int i = 0; i < codes.size(); i++) {
			if (!codes.get(i).equals(sortedList.get(i))) {
				LoggerUtil.error(
						" Mismatch at index " + i + " → Actual: " + codes.get(i) + " | Expected: " + sortedList.get(i));
				LoggerUtil.fail("Codes are NOT sorted in descending order.");
				LoggerUtil.info(" [END] Descending order verification failed.");
				return false;
			}
		}

		LoggerUtil.pass(" Codes are sorted in descending order.");
		LoggerUtil.pass(" Descending order verification successful.");
		LoggerUtil.info(" [END] Descending order verification completed successfully.");

		return true;
	}

	public void sortingWithSupplierName() {
		LoggerUtil.info("🟩 [START] Test: Verify sorting functionality for Supplier Name column.");

		LoggerUtil.info("STEP 1: Waiting for Supplier Name header to be clickable...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(suppliernameheader));

		int maxRetries = 3;
		boolean isSorted = false;

		for (int i = 0; i < maxRetries; i++) {
			LoggerUtil.info("➡️ Attempt " + (i + 1) + " to check sorting...");

			List<String> currentValues = getSupplierName();
			LoggerUtil.info("📋 Current Supplier Names: " + currentValues);

			LoggerUtil.info("STEP 2: Clicking on Supplier Name header to trigger sorting...");
			header.click();
			header.click();

			LoggerUtil.info("STEP 3: Waiting for updated supplier name list after sorting...");
			wait.until(driver -> {
				try {
					List<String> newValues = getSupplierName();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			List<String> updatedValues = getSupplierName();
			LoggerUtil.info(" Updated Supplier Names after sorting: " + updatedValues);

			if (isSortedDescendingforsuppliername(updatedValues)) {
				LoggerUtil.pass(" Supplier Names are sorted in descending order successfully.");
				isSorted = true;
				break;
			} else {
				LoggerUtil.warn(" Supplier Names are not sorted correctly. Retrying...");
			}
		}

		if (!isSorted) {
			LoggerUtil.error(" Sorting verification failed for Supplier Name column.");
			Assert.fail("Supplier Names were not sorted in descending order even after retries.");
		}

		LoggerUtil.info(" [END] Sorting test for Supplier Name column completed.");
	}

	public List<String> getSupplierName() {
		LoggerUtil.info(" [START] Fetching Supplier Names from Supplier table...");

		LoggerUtil.info("STEP 1: Waiting for Supplier Name column elements to be visible...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SuppliernameColumn));

		if (elements.isEmpty()) {
			LoggerUtil.error("❌ Supplier Name column has no data.");
			throw new NoSuchElementException("Supplier Name column has no data.");
		}

		LoggerUtil.info("STEP 2: Extracting text values from Supplier Name column.");
		List<String> supplierNames = elements.stream().map(WebElement::getText).map(String::trim)
				.map(String::toLowerCase).collect(Collectors.toList());

		LoggerUtil.info(" Total Supplier Names Fetched: " + supplierNames.size());
		LoggerUtil.info(" Supplier Names List: " + supplierNames);

		LoggerUtil.pass(" Successfully fetched supplier names from Supplier table.");
		LoggerUtil.info(" [END] Supplier name fetching complete.");

		return supplierNames;
	}

	public boolean isSortedDescendingforsuppliername(List<String> names) {
		LoggerUtil.info(" [START] Verifying if Supplier Names are sorted in descending order...");

		if (names == null || names.isEmpty()) {
			LoggerUtil.error(" Supplier Name list is null or empty.");
			return false;
		}

		LoggerUtil.info(" Original Supplier Names: " + names);

		// Create sorted copy for comparison
		List<String> sortedList = new ArrayList<>(names);
		sortedList.sort(Comparator.reverseOrder());

		LoggerUtil.info(" Expected Descending Sorted Names: " + sortedList);

		if (names.equals(sortedList)) {
			LoggerUtil.pass(" Supplier Names are correctly sorted in descending order.");
			LoggerUtil.info(" [END] Descending sort verification for Supplier Names PASSED.");
			return true;
		} else {
			LoggerUtil.error(" Supplier Names are NOT sorted in descending order.");
			LoggerUtil.info(" [END] Descending sort verification for Supplier Names FAILED.");
			return false;
		}
	}

	public void sortingWithSupplierLocation() {
		LoggerUtil.info(" [START] Test: Verify sorting functionality for Supplier Location column.");

		LoggerUtil.info("STEP 1: Waiting for Supplier Location header to be clickable...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(supplierlocationheader));

		int maxRetries = 3;
		boolean isSorted = false;

		for (int i = 0; i < maxRetries; i++) {
			LoggerUtil.info(" Attempt " + (i + 1) + " to check sorting...");

			List<String> currentValues = getSupplierLocation();
			LoggerUtil.info(" Current Supplier Locations: " + currentValues);

			LoggerUtil.info("STEP 2: Clicking on Supplier Location header to trigger sorting...");
			header.click();
			header.click();

			LoggerUtil.info("STEP 3: Waiting for updated supplier location list after sorting...");
			wait.until(driver -> {
				try {
					List<String> newValues = getSupplierLocation();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			List<String> updatedValues = getSupplierLocation();
			LoggerUtil.info(" Updated Supplier Locations after sorting: " + updatedValues);

			if (isSortedDescending(updatedValues)) {
				LoggerUtil.pass(" Supplier Locations are sorted in descending order successfully.");
				isSorted = true;
				break;
			} else {
				LoggerUtil.warn(" Supplier Locations are not sorted correctly. Retrying...");
			}
		}

		if (!isSorted) {
			LoggerUtil.error(" Sorting verification failed for Supplier Location column.");
			Assert.fail("Supplier Locations were not sorted in descending order even after retries.");
		}

		LoggerUtil.info(" [END] Sorting test for Supplier Location column completed.");
	}

	public List<String> getSupplierLocation() {
		LoggerUtil.info("🟩 [START] Fetching Supplier Location column data...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(supplierlocationColumn));

		if (elements.isEmpty()) {
			LoggerUtil.error("❌ Supplier Location column has no data.");
			throw new NoSuchElementException("Supplier Location column has no data.");
		}

		List<String> supplierLocations = elements.stream().map(WebElement::getText).map(String::trim)
				.map(String::toLowerCase).collect(Collectors.toList());

		LoggerUtil.info("📋 Extracted Supplier Locations: " + supplierLocations);
		LoggerUtil.pass("✅ Successfully fetched Supplier Location column data.");
		LoggerUtil.info("🟦 [END] Supplier Location data fetch completed.");

		return supplierLocations;
	}

	public void sortingWithBusinessDomain() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(Businessdomainheader));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			List<String> currentValues = getBusinessDomain();

			header.click();

			wait.until(driver -> {
				try {
					List<String> newValues = getBusinessDomain();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			List<String> updatedValues = getBusinessDomain();

			if (isSortedDescending(updatedValues)) {
				break;
			}
		}
	}

	public List<String> getBusinessDomain() {
		LoggerUtil.info("🟩 [START] Fetching Business Domain column data...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Businessdomaincolumn));

		if (elements.isEmpty()) {
			LoggerUtil.error("❌ Business Domain column has no data.");
			throw new NoSuchElementException("Business Domain column has no data.");
		}

		List<String> businessDomains = elements.stream().map(WebElement::getText).map(String::trim)
				.map(String::toLowerCase).collect(Collectors.toList());

		LoggerUtil.info("📋 Extracted Business Domains: " + businessDomains);
		LoggerUtil.pass("✅ Successfully fetched Business Domain column data.");
		LoggerUtil.info("🟦 [END] Business Domain data fetch completed.");

		return businessDomains;
	}

	public void sortingWithBusinessSegment() {
		LoggerUtil.info("🟩 [START] Sorting verification for Business Segment column");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(BusinessSegmentinheader));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			List<String> currentValues = getBusinessSegment();
			LoggerUtil.info(" Current Business Segment Values (before click): " + currentValues);

			header.click();
			LoggerUtil.info(" Clicked on Business Segment header to apply sorting");

			boolean sortingChanged = wait.until(driver -> {
				try {
					List<String> newValues = getBusinessSegment();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			if (!sortingChanged) {
				LoggerUtil.warn(" Sorting did not change after clicking header. Retrying...");
				continue;
			}

			List<String> updatedValues = getBusinessSegment();
			LoggerUtil.info(" Updated Business Segment Values (after click): " + updatedValues);

			if (isSortedDescending(updatedValues)) {
				LoggerUtil.pass(" Business Segment column sorted in descending order successfully.");
				break;
			} else {
				LoggerUtil.error(" Business Segment column is NOT sorted in descending order.");
			}
		}

		LoggerUtil.info(" [END] Sorting verification for Business Segment column completed");
	}

	public List<String> getBusinessSegment() {
		LoggerUtil.info("🟩 [START] Fetching Business Segment column values");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BusinessSegmentColumn));

		if (elements.isEmpty()) {
			LoggerUtil.error("❌ Business Segment column has no data.");
			throw new NoSuchElementException("Business Segment column has no data.");
		}

		List<String> businessSegments = elements.stream().map(WebElement::getText).map(String::trim)
				.map(String::toLowerCase).collect(Collectors.toList());

		LoggerUtil.info("📋 Extracted Business Segment values: " + businessSegments);
		LoggerUtil.info("🟦 [END] Business Segment values fetched successfully");

		return businessSegments;
	}

	public void exportexcelfile() throws InterruptedException {

		clickOnElement(clickexporandimporttbtn);
		Thread.sleep(2000);
		clickOnElement(exportbtn);
		Thread.sleep(5000);
		clickOnElement(suppliercodeheader);

	}

	public static List<String> readSupplierCodeFromExcel(File file, int columnIndex, int startRow) throws IOException {

		List<String> SupplierCode = new ArrayList<>();

		FileInputStream fis = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0); // Read first sheet

		int count = 0;

		for (Row row : sheet) {

			if (row.getRowNum() < startRow)

				continue; // Skip first 3 rows

			if (count >= 25)

				break;

			Cell cell = row.getCell(columnIndex);

			if (cell != null) {

				SupplierCode.add(cell.toString().trim());

				count++;

			}

		}
		workbook.close();

		fis.close();

		return SupplierCode;
	}

	public List<String> fetchSupplierList() {
		LoggerUtil.info("🔎 Fetching supplier codes from UI...");

		List<WebElement> suppliercodeElements = driver.findElements(suppliercodelist);
		List<String> uiData = new ArrayList<>();

		if (suppliercodeElements.isEmpty()) {
			LoggerUtil.error("❌ No supplier codes found in UI.");
			throw new NoSuchElementException("Supplier code list is empty on UI.");
		}

		LoggerUtil.info("📊 Total supplier codes found: " + suppliercodeElements.size());

		for (WebElement ele : suppliercodeElements) {
			String value = ele.getText().trim();
			if (!value.isEmpty()) {
				uiData.add(value);
				LoggerUtil.info("📌 Extracted Supplier Code: " + value);
			}
		}

		LoggerUtil.pass("✅ Successfully fetched supplier codes from UI. Count: " + uiData.size());
		return uiData;
	}

	public static List<String> getSortedSupplierCodes(String filePath) {
		List<String> supplierCodes = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath)) {
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0); // First sheet
			int supplierColIndex = -1;
			Row headerRow = null;

			LoggerUtil.info("📂 Reading Excel file: " + filePath);

			// Try first few rows to find header
			for (int rowIndex = 0; rowIndex <= 5; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row == null)
					continue;

				LoggerUtil.info("🔎 Checking row: " + rowIndex);

				for (Cell cell : row) {
					String header = "";
					if (cell.getCellType() == CellType.STRING) {
						header = cell.getStringCellValue().replaceAll("[\\u00A0\\s]", "").toLowerCase();
					}
					LoggerUtil.info("➡ Found Header Candidate: '" + header + "'");

					if (header.equals("suppliercode")) {
						supplierColIndex = cell.getColumnIndex();
						headerRow = row;
						LoggerUtil.pass("✅ Supplier Code column found at index " + supplierColIndex + " (Row: "
								+ rowIndex + ")");
						break;
					}
				}

				if (supplierColIndex != -1)
					break; // Stop if found
			}

			if (supplierColIndex == -1) {
				LoggerUtil.error("❌ Supplier Code column not found in first 5 rows!");
				throw new RuntimeException("Supplier Code column not found in any of the first 5 rows!");
			}

			// Extract values from the identified column
			int startRow = headerRow.getRowNum() + 1;
			for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell cell = row.getCell(supplierColIndex);
					if (cell != null && cell.getCellType() == CellType.STRING) {
						String value = cell.getStringCellValue().trim();
						if (!value.isEmpty()) {
							supplierCodes.add(value);
							LoggerUtil.info("📌 Extracted Supplier Code: " + value);
						}
					}
				}
			}

			Collections.sort(supplierCodes);
			LoggerUtil.pass("📊 Total Supplier Codes extracted and sorted: " + supplierCodes.size());

		} catch (Exception e) {
			LoggerUtil.error("❌ Error while reading or processing the Excel file → " + e.getMessage());
			throw new RuntimeException("Error while reading or processing the Excel file.", e);
		}

		return supplierCodes;
	}

	public void clickUserButtonTocheckUserAuthorization() throws InterruptedException {

		clickOnElement(userbtn);
		Thread.sleep(4000);
		clickOnElement(userauthorizationtab);
		Thread.sleep(3000);
		clickOnElement(userideditbtn);
		Thread.sleep(5000);
		clickOnElement(clickmasterdataforauthorisation);
		Thread.sleep(3000);
		clickOnElement(clicksupplierforuserauthorisation);
		Thread.sleep(4000);
		clickOnElement(unselectreadandrightforuserauthorisation);
		Thread.sleep(3000);
		clickOnElement(clickupdatebuttonforforuserauthorisation);

		Thread.sleep(4000);
		dashboard.clickonsuppliermaster();

		List<WebElement> savebutton2 = driver.findElements(By.xpath("//button[@id=\"btnSave\"]"));
		if (savebutton2.isEmpty()) {
			System.out.println("✅ Save button is not present for Read-Only user. Test Passed.");
		} else {
			System.out.println("❌ Save button is present! Test Failed.");
		}

	}

	public void clickusercontrolbtntocheckusercanreadandwriteornot() throws InterruptedException {

		clickOnElement(userbtn);
		Thread.sleep(8000);
		clickOnElement(userauthorizationtab);
		Thread.sleep(6000);
		clickOnElement(userideditbtn);
		Thread.sleep(5000);
		clickOnElement(clickmasterdataforauthorisation);
		clickOnElement(clicksupplierforuserauthorisation);
		Thread.sleep(4000);
		clickOnElement(uselectreadbtn);
		clickOnElement(clickupdatebuttonforforuserauthorisation);
		Thread.sleep(9000);

	}

	public void enterdatainsuppliermaster(String supcode, String supname, String suplocation)
			throws InterruptedException {
		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
		clearAndEnterText(waitForExpectedElement(suppliername), supname);
		clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);
		Thread.sleep(5000);
		clickOnElement(clickingSavebuttonSupplierMasterPage);

	}

	public void exportandimportnewdata() throws InterruptedException {
		LoggerUtil.info(" Clicking on Export & Import button.");
		clickOnElement(clickexporandimporttbtn);

		LoggerUtil.info("Clicking on 'Export Master Allocation - New Supplier'.");
		clickOnElement(exportmasterallocationnewsupplire);

		LoggerUtil.info("Selecting dropdown while exporting new Excel file.");
		clickOnElement(clickdropdwnwhileexportingnewexcelfile);
		Thread.sleep(2000);

		LoggerUtil.info("Entering data in dropdown → 141235");
		clearAndEnterText(waitForExpectedElement(enterdatadropdownvalue), "141235");

		Thread.sleep(2000);
		LoggerUtil.info("Selecting 'All' option in dropdown.");
		clickOnElement(clickdropdiwnselectallwhileexportingnewfile);

		Thread.sleep(2000);
		LoggerUtil.info("Selecting yearly checkbox.");
		clickOnElement(clickyearlycheckboxwhileExportingnewData);
		Thread.sleep(6000);

		LoggerUtil.info("Selecting first dropdown value (Material = CRCA-007).");
		clickOnElement(clickfirstDropdownwhileExpoertingnewfile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(entervalueinfirstdropdown), "CRCA-007");
		clickOnElement(clickfirstvalueindropdown);
		Thread.sleep(2000);
		LoggerUtil.info("Selecting second dropdown value (Process = Process-1).");
		clickOnElement(clicksecondDropdownwhileExportingNewfile);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchvalueforsecoddropdown), "Process-1");
		Thread.sleep(2000);
		clickOnElement(clickseconddropdownvalue);
		Thread.sleep(2000);
		LoggerUtil.info("Selecting third dropdown value.");
		clickOnElement(clickthirdDropdownwhileExportingNewfile);
		Thread.sleep(2000);
		clickOnElement(clickthirdvalue);
		Thread.sleep(2000);

		LoggerUtil.info("Clicking on Export button.");
		clickOnElement(exportbtn);
		Thread.sleep(2000);

		LoggerUtil.info("Filling Supplier Excel Sheet with new data.");
		fillSupplierSheet();
		Thread.sleep(2000);

		LoggerUtil.info("Importing newly filled Supplier Master Excel file.");
		importNewSupplierMasterExcel();

		// ✅ final reporting
		try {
			LoggerUtil.pass("Export & Import process completed successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Export & Import process failed.");
			LoggerUtil.error("Error details: " + e.getMessage());
			throw e;
		}

	}

	public String fillSupplierSheet() {
		LoggerUtil.info("STEP 1: Fetching latest Supplier Master Excel file.");

		File latestFile = getLatestSupplierMasterFile();
		if (latestFile == null) {
			LoggerUtil.fail("No Supplier Master file found in downloads directory.");
			return null;
		}

		String filePath = latestFile.getAbsolutePath();
		LoggerUtil.info("Latest Supplier Master file found: " + filePath);

		try {

			supplierCode = faker.name().lastName();
			supplierName = faker.name().lastName();
			supplierLocation = "Text-905";
			businessDomain = "rishi123";
			rm = "Yes";
			process = "Yes";

			LoggerUtil.info("STEP 2: Writing supplier data → Code: " + supplierCode + ", Name: " + supplierName
					+ ", Location: " + supplierLocation + ", Domain: " + businessDomain + ", RM: " + rm + ", Process: "
					+ process);

			// Fill Excel
			ExcelFiller.setCellValue(filePath, 0, 3, 1, ExcelFiller.ValueType.INTEGER, null);
			ExcelFiller.setCellValue(filePath, 0, 3, 2, ExcelFiller.ValueType.STRING, null);
			ExcelFiller.setCellValue(filePath, 0, 3, 3, ExcelFiller.ValueType.STRING, null);
			ExcelFiller.setCellValue(filePath, 0, 3, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(businessDomain));
			ExcelFiller.setCellValue(filePath, 0, 3, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(rm));
			ExcelFiller.setCellValue(filePath, 0, 3, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(process));
			ExcelFiller.setCellValue(filePath, 0, 3, 8, ExcelFiller.ValueType.DROPDOWN, Arrays.asList("Yes"));

			return latestFile.getName();

		} catch (Exception e) {
			LoggerUtil.error("Error occurred while filling Supplier Excel Sheet → " + e.getMessage());
			LoggerUtil.fail("Failed to update Supplier Master Excel file: " + latestFile.getName());
			return null;
		}

	}

	public void importNewSupplierMasterExcel() throws InterruptedException {
		LoggerUtil.info("===== SUPPLIER MASTER IMPORT: START =====");

		LoggerUtil.info("STEP 1: Preparing Supplier Master Excel for import.");
		String fileName = fillSupplierSheet();
		if (fileName == null) {
			LoggerUtil.fail("Supplier Master Excel creation failed. Import aborted.");
			LoggerUtil.info("===== SUPPLIER MASTER IMPORT: END (ABORTED) =====");
			return;
		}

		String fullPath = System.getProperty("user.dir") + "/downloads/" + fileName;
		LoggerUtil.info("Excel file ready for import: " + fullPath);

		try {
			LoggerUtil.info("STEP 2: Locating Excel upload input element (id=excelUploadSup).");
			WebElement fileInput = driver.findElement(By.id("excelUploadSup"));

			LoggerUtil.info("STEP 3: Making file input visible via JavaScript.");
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

			LoggerUtil.info("STEP 4: Uploading file → " + fileName);
			fileInput.sendKeys(fullPath);

			LoggerUtil.info("STEP 5: Waiting for processing...");
			Thread.sleep(5000);

			// Toast handle karna hai try-catch ke andar
			final String expectedToast = "File imported successfully";
			String actualToast = "(toast not found)";

			try {
				LoggerUtil.info("STEP 6: Capturing import toast message for report.");
				actualToast = waitForExpectedElement(ImportToastMsgSupplierPage).getText().trim();
				LoggerUtil.info("Toast captured → \"" + actualToast + "\"");

				if (expectedToast.equalsIgnoreCase(actualToast)) {
					LoggerUtil.pass("Toast validation PASSED | Expected: \"" + expectedToast + "\" | Actual: \""
							+ actualToast + "\"");
				} else {
					LoggerUtil.fail("Toast validation FAILED | Expected: \"" + expectedToast + "\" | Actual: \""
							+ actualToast + "\"");
				}
			} catch (Exception toastEx) {
				LoggerUtil.error("Toast capture failed: " + toastEx.getMessage());
				LoggerUtil.fail("Toast validation SKIPPED | Expected: \"" + expectedToast + "\" | Actual: \""
						+ actualToast + "\"");
			}

			// Input phir se hide karna hai to
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", fileInput);
			} catch (Exception ignore) {
				// ignore
			}

			LoggerUtil.pass("Supplier Master Excel import flow completed for file → " + fileName);
		} catch (Exception e) {
			LoggerUtil.error("Error during Supplier Master Excel import: " + e.getMessage());
			LoggerUtil.fail("Failed to import Supplier Master Excel file → " + fileName);
		}

		LoggerUtil.info("===== SUPPLIER MASTER IMPORT: END =====");
	}

	public static final By fetchingdataFromsuppname = By.xpath("//table[@id='example1']/tbody/tr/td[3]");

	public void verifyingohpallocation(String supname, String supcode, String suplocation) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(suppliername), supname);
		clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
		clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);

		clickOnElement(ohpcheckbox);
		Thread.sleep(3500);
		clickOnElement(ohpDataTableInsupplierpage);
		clickOnElement(clickingSavebuttonSupplierMasterPage);

	}

	private static final By searchbusinessSegValue = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[2]/span/div/div/div/input");
	private static final By clickbusinessSeg = By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[2]/span/div/button");
	private static final By checkbox = By.xpath("//input[@id=\"multiselect_w090kk8jcxh_0_24\"]");

	public void verifyingAllocationInOhp(String supname, String searchbusinessSegval) throws InterruptedException {

		clickOnElement(clickviewbtnohptable);

		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(Ohpsearhbox), supname);
		clickOnElement(clickeditbtnohppage);
		Thread.sleep(3000);
		clickOnElement(clickbusinessSeg);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchbusinessSegValue), searchbusinessSegval);
		Assert.assertTrue(ischeckboxSelected(), "The Business Segment Checkbox Is Selected");

	}

	private boolean ischeckboxSelected() {

		return false;
	}

	public void VerifyWithoutSelectingSupplierName(String supcode, String suplocation, String message) {
		LoggerUtil.info("Test Started: VerifyWithoutSelectingSupplierName");

		try {
			LoggerUtil.info("STEP 1: Entering Supplier Code → " + supcode);
			clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
			LoggerUtil.pass("Supplier Code entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Code. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 2: Entering Supplier Location → " + suplocation);
			clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);
			LoggerUtil.pass("Supplier Location entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Location. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 3: Selecting Business Domain.");
			clickOnElement(businnessdomaidropdown);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
			clickOnElement(businessDomainCheckBox);
			LoggerUtil.pass("Business Domain selected successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to select Business Domain. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 4: Selecting Business Segment.");
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);
			LoggerUtil.pass("Business Segment selected successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to select Business Segment. Error: " + e.getMessage());
		}

		

		try {
			LoggerUtil.info("STEP 6: Clicking Save button.");
			clickOnElement(clickingSavebuttonSupplierMasterPage);
			LoggerUtil.pass("Save button clicked successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to click Save button. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 7: Verifying Toast Message contains → " + message);
			String actualToast = waitForExpectedElement(toastmessagesupplierpage).getText();
			if (actualToast.contains(message)) {
				LoggerUtil.pass("Toast message verified successfully. Message: " + actualToast);
			} else {
				LoggerUtil.mismatch("Expected: " + message + " | Found: " + actualToast);
			}
			Assert.assertTrue(actualToast.contains(message));
		} catch (Exception e) {
			LoggerUtil.fail("Failed to verify Toast Message. Error: " + e.getMessage());
		}

		LoggerUtil.info("Test Completed: VerifyWithoutSelectingSupplierName");
	}

	public void verifyWithoutSelectingSupplierLocation(String supname, String supcode, String message) {
		LoggerUtil.info("Test Started: verifyWithoutSelectingSupplierLocation");

		try {
			LoggerUtil.info("STEP 1: Entering Supplier Name → " + supname);
			clearAndEnterText(waitForExpectedElement(suppliername), supname);
			LoggerUtil.pass("Supplier Name entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Name. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 2: Entering Supplier Code → " + supcode);
			clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
			LoggerUtil.pass("Supplier Code entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Code. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 3: Selecting Business Domain.");
			clickOnElement(businnessdomaidropdown);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
			clickOnElement(businessDomainCheckBox);
			LoggerUtil.pass("Business Domain selected successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to select Business Domain. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 4: Selecting Business Segment.");
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);
			LoggerUtil.pass("Business Segment selected successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to select Business Segment. Error: " + e.getMessage());
		}

		

		try {
			LoggerUtil.info("STEP 6: Clicking Save button.");
			clickOnElement(clickingSavebuttonSupplierMasterPage);
			LoggerUtil.pass("Save button clicked successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to click Save button. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 7: Verifying Toast Message contains → " + message);
			String actualToast = waitForExpectedElement(toastmessagesupplierpage).getText();
			if (actualToast.contains(message)) {
				LoggerUtil.pass("Toast message verified successfully. Message: " + actualToast);
			} else {
				LoggerUtil.mismatch("Expected: " + message + " | Found: " + actualToast);
			}
			Assert.assertTrue(actualToast.contains(message));
		} catch (Exception e) {
			LoggerUtil.fail("Failed to verify Toast Message. Error: " + e.getMessage());
		}

		LoggerUtil.info("Test Completed: verifyWithoutSelectingSupplierLocation");
	}

	public void verifyWithoutSelectingBusinessDomain(String supname, String supcode, String suplocation,
			String message) {
		LoggerUtil.info("Test Started: verifyWithoutSelectingBusinessDomain");

		try {
			LoggerUtil.info("STEP 1: Entering Supplier Name → " + supname);
			clearAndEnterText(waitForExpectedElement(suppliername), supname);
			LoggerUtil.pass("Supplier Name entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Name. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 2: Entering Supplier Code → " + supcode);
			clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
			LoggerUtil.pass("Supplier Code entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Code. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 3: Entering Supplier Location → " + suplocation);
			clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);
			LoggerUtil.pass("Supplier Location entered successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to enter Supplier Location. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 4: Selecting Business Segment.");
			clickOnElement(businesssegmentdropdown);
			clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
			clickOnElement(businessSegmentCheckBox);
			LoggerUtil.pass("Business Segment selected successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to select Business Segment. Error: " + e.getMessage());
		}

		

		try {
			LoggerUtil.info("STEP 6: Clicking Save button.");
			clickOnElement(clickingSavebuttonSupplierMasterPage);
			LoggerUtil.pass("Save button clicked successfully.");
		} catch (Exception e) {
			LoggerUtil.fail("Failed to click Save button. Error: " + e.getMessage());
		}

		try {
			LoggerUtil.info("STEP 7: Verifying Toast Message contains → " + message);
			String actualToast = waitForExpectedElement(toastmessagesupplierpage).getText();
			if (actualToast.contains(message)) {
				LoggerUtil.pass("Toast message verified successfully. Message: " + actualToast);
			} else {
				LoggerUtil.mismatch("Expected: " + message + " | Found: " + actualToast);
			}
			Assert.assertTrue(actualToast.contains(message));
		} catch (Exception e) {
			LoggerUtil.fail("Failed to verify Toast Message. Error: " + e.getMessage());
		}

		LoggerUtil.info("Test Completed: verifyWithoutSelectingBusinessDomain");
	}

	public void withoutSelectingBusinessSegment(String supname, String supcode, String suplocation, String message) {

		clearAndEnterText(waitForExpectedElement(suppliername), supname);
		clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
		clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		Assert.assertTrue(waitForExpectedElement(toastmessagesupplierpage).getText().contains(message));

	}

	public void UserSaveTheSupplierWithInvalidPhoneNumber(String supcode, String supname, String suplocation) {

		clearAndEnterText(waitForExpectedElement(suppliername), supname);
		clearAndEnterText(waitForExpectedElement(suupliercode), supcode);
		clearAndEnterText(waitForExpectedElement(supplerlocation), suplocation);
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);
		// clearAndEnterText(waitForExpectedElement(), suplocation);

	}

	public String getDuplicateAlertText() {
		try {
			LoggerUtil.info("⏳ Waiting for duplicate alert toast...");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement toast = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
			LoggerUtil.info("📋 Toast message found: " + toast.getText());
			return toast.getText();
		} catch (Exception e) {
			LoggerUtil.error("❌ Duplicate toast message not found within timeout!");
			return "";
		}
	}

	///
	private static By editbtnbusinessdomainsegmentTab = By
			.xpath("//table[@id='businessdomainSegmentsTable']/tbody/tr[2]/td[4]/a/i");
	private static By clickcommoditydetailstab = By.xpath("//a[@href=\"#CommodityDetailTab\"]");

	public void checktheuserupdatethecategorynameandtypethechangeswillreflectsinothermastersDropdown(
			String entercatname) throws InterruptedException {

		clickOnElement(BusinessDomainSegments);
		Thread.sleep(3000);
		clickOnElement(editbtnbusinessdomainsegmentTab);
		clearAndEnterText(waitForExpectedElement(enetrcategoryname), entercatname);
		clickOnElement(savebutton);

	}

	private static By commoditydetailstab = By.xpath("//a[@href=\"#CommodityDetailTab\"]");
	private static By commoditydetailstabbusinessSegDrop = By.xpath("(//button[@data-toggle='dropdown'])[3]");
	private static By businessSegDomainSearchBar = By.xpath("//input[@class=\"multiselect-search form-control\"]");
	private static By dropdownvalueinbusinessSegmentcommodity = By
			.xpath("(//button[@class='multiselect-option dropdown-item']//span/label['kumar'])[1]");

	public void verifyIncommoditydetailsTabBusinessSegment(String enterval) throws InterruptedException {

		clickOnElement(commoditydatailstab);
		Thread.sleep(4000);

		clickOnElement(commoditydetailstabbusinessSegDrop);
		clearAndEnterText(waitForExpectedElement(businessSegDomainSearchBar), enterval);

		String expected = "kumar";
		String actual = "";

		if (waitForExpectedElement(dropdownvalueinbusinessSegmentcommodity).isDisplayed()) {
			actual = "kumar"; // You can enhance this to fetch exact label text if needed

			// Assertion
			if (actual.equals(expected)) {
				LoggerUtil.info(" [PASS] Business Segment dropdown value matched.");
				LoggerUtil.info(" Expected: " + expected);
				LoggerUtil.info(" Actual  : " + actual);
			}

			Assert.assertEquals(actual, expected, " Mismatch in Business Segment dropdown value.");
		} else {
			LoggerUtil.error(" [FAIL] Business Segment dropdown did not show the updated category: " + enterval);
			Assert.fail("Dropdown value not displayed for: " + enterval);
		}
	}

	public static final By businessSegDropProcessMaster = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/button");
	public static final By businessSegDropProcessMasteEntervalue = By
			.xpath("(//input[@class='multiselect-search form-control'])[1]");
	public static final By businessSegDroplistvalukumar = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/button[19]/span/label");

	public void verifyInProcessMAsterTabBusinessSegmentDropDown(String processmasterbusSeg) {

		clickOnElement(businessSegDropProcessMaster);
		clearAndEnterText(waitForExpectedElement(businessSegDropProcessMasteEntervalue), processmasterbusSeg);
		String actual = "kumar";
		String expected = "kumar";

		if (waitForExpectedElement(businessSegDroplistvalukumar).isDisplayed()) {

			Assert.assertEquals(actual.trim().toLowerCase(), expected.trim().toLowerCase(),
					"Mismatch in Business Segment");

		}

	}

	private static final By businessDomainDropdown = By
			.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]");
	private static final By businessDomainDropdownOptions = By.xpath("//ul[@id='select2-BusinessDomain-results']/li");

	public void selectBusinessDomain(String value) {
		Base.clickOnElement(businessDomainDropdown); // Click to open dropdown
		List<WebElement> options = Base.driver.findElements(businessDomainDropdownOptions);
		selectBootStrapDropDown(options, value);
	}

	private static final By editButtonFirstRow = By.xpath("//table[@id='example1']/tbody/tr[1]/td[7]/a[1]/span/i");
	private static final By supplierCodeField = By.xpath("//input[@id='SupplierCode']");
	private static final By supplierNameField = By.xpath("//input[@id='SupplierName']");
	private static final By supplierLocationField = By.xpath("//input[@id='SupplierLocation']");
	private static final By processCheckbox = By.xpath("//input[@id=\"Process\"]");

	// Actions
	public void clickEditButtonForProcessAllocation() {
		clickOnElement(editButtonFirstRow);
	}

	public String getSupplierCode() {
		return waitForExpectedElement(supplierCodeField).getAttribute("value").trim();
	}

	public String getSupplierName1() {
		return waitForExpectedElement(supplierNameField).getAttribute("value").trim();
	}

	public String getSupplierLocation1() {
		return waitForExpectedElement(supplierLocationField).getAttribute("value").trim();
	}

	public boolean isProcessCheckboxSelected() {
		return waitForExpectedElement(processCheckbox).isSelected();
	}

	private static final By clickeditbtnfiestrow = By.xpath("//TABLE[@id=\"example1\"]/tbody/tr[1]/td[7]/a[1]/span/i");
	private static final By supplierCodeField1 = By.xpath("//input[@id='SupplierCode']");
	private static final By supplierNameField1 = By.xpath("//input[@id='SupplierName']");
	private static final By supplierLocationField1 = By.xpath("//input[@id='SupplierLocation']");
	private static final By rmcheck = By.xpath("//input[@id=\"RM\"]");

	public void clickEditButtonForRmAllocation1() {
		clickOnElement(clickeditbtnfiestrow);
	}

	public String getSupplierCode1() {
		return waitForExpectedElement(supplierCodeField).getAttribute("value").trim();
	}

	public String getSupplierName11() {
		return waitForExpectedElement(supplierNameField).getAttribute("value").trim();
	}

	public String getSupplierLocation11() {
		return waitForExpectedElement(supplierLocationField).getAttribute("value").trim();
	}

	public boolean isProcessCheckboxSelected1() {
		return waitForExpectedElement(rmcheck).isSelected();
	}

	public static final By saveasnewbtn = By.xpath("//button[@id='btnSaveAsNew']");

	public void verifyduplicateentry(String message) throws InterruptedException {
		clickOnElement(editButtonFirstRow);
		Thread.sleep(4000);
		clickOnElement(saveasnewbtn);
		LoggerUtil.info("User Getting Popup = This Supplier Page Is Already Exist");
		Assert.assertTrue(waitForExpectedElement(toastmessagesupplierpage).getText().contains(message));
	}

	public static final By updatebtn = By.xpath("//*[@id=\"btnUpdate\"]");

	public void verifyupdatebtnisworkingwell(String supliercode, String message) throws InterruptedException {
		clickOnElement(editButtonFirstRow);
		clearAndEnterText(waitForExpectedElement(supplierCodeField), supliercode);
		Thread.sleep(3000);
		clickOnElement(updatebtn);
		Assert.assertTrue(waitForExpectedElement(toastmessagesupplierpage).getText().contains(message));
	}

	private static final By editButton = By.xpath("//table[@id='example1']/tbody/tr[8]/td[7]/a[1]/span/i");

	public void clickbtnsaveasnew(String supcode, String message) throws InterruptedException {
		clickOnElement(editButton);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(supplierCodeField), supcode);
		clickOnElement(saveasnewbtn);
		Assert.assertTrue(waitForExpectedElement(toastmessagesupplierpage).getText().contains(message));
	}

	public void ckicksavebtn(String scode, String sname, String slocation) {
		clearAndEnterText(waitForExpectedElement(supplierCodeField), scode);
		clearAndEnterText(waitForExpectedElement(suppliername), sname);
		clearAndEnterText(waitForExpectedElement(supplerlocation), slocation);
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);
		clickOnElement(clickingSavebuttonSupplierMasterPage);
	}

	public void importduplicatedata(String message) throws InterruptedException {
		clickOnElement(clickexporandimporttbtn);
		Thread.sleep(2000);
		importDuplicatesupplierrsheet();
		Thread.sleep(3000);
		Assert.assertTrue(waitForExpectedElement(toastmessagesupplierpage).getText().contains(message));
	}

	public void importDuplicatesupplierrsheet() throws InterruptedException {
		String fullPath = "C:\\Users\\Admin\\Downloads\\com.CostMaster\\downloads\\SupplierMaster_22-04-2025_08_53_08.xlsx";
		WebElement fileInput = driver.findElement(By.id("excelUploadNewSup"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
		fileInput.sendKeys(fullPath);

		Thread.sleep(7000);
	}

	private static final By deletebtncosting = By.xpath("//table[@id='example1']/descendant::i[@title='Delete']");

	public void deletecostingdatainsupplierpage(String message) throws InterruptedException {

	    // STEP 1: Search
	    clearAndEnterText(waitForExpectedElement(searchboxinsupplierpage), "Celesta");
	    Thread.sleep(3000);

	    // STEP 2: Check whether delete button is visible (table loaded or not)
	    if (driver.findElements(deletebtncosting).isEmpty()
	            || !driver.findElement(deletebtncosting).isDisplayed()) {

	        LoggerUtil.error(
	                "Delete button not visible after search. "
	              + "Possibly no data loaded or known table issue. Exiting method.");

	        return; // ⛔ EXIT — do NOT proceed further
	    }

	    // STEP 3: Click delete
	    clickOnElement(deletebtncosting);
	    LoggerUtil.info("Delete button clicked");

	    // STEP 4: Handle confirmation alert
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        LoggerUtil.info("Alert text: " + alert.getText());
	        alert.accept();
	        LoggerUtil.pass("Alert accepted successfully");

	    } catch (NoAlertPresentException e) {
	        LoggerUtil.error("Expected delete confirmation alert was not present.");
	        return; // ⛔ EXIT safely
	    }

	    // STEP 5: Capture toast message
	    WebElement toastElement = waitForExpectedElement(toastmessagesupplierpage);
	    String actualToast = toastElement.getText().trim();
	    LoggerUtil.info("Toast message displayed: [" + actualToast + "]");

	    // STEP 6: Validate toast message
	    if (actualToast.contains(message)) {
	        LoggerUtil.pass(
	                "Toast message matched. Expected to contain: [" + message + "], Actual: [" + actualToast + "]");
	    } else {
	        LoggerUtil.error(
	                "Toast message mismatch! Expected to contain: [" + message + "], Actual: [" + actualToast + "]");
	        Assert.fail("Toast message mismatch!");
	    }
	}


	public static final By importexportbtn = By.xpath("//button[contains(text(),'Export/Import')]");
	private static final By editsupplierrow = By.xpath("//table[@id='example1']/tbody/tr[4]/td[7]/a[1]/span/i");
	public static final By heading = By.xpath("(//h5[@id='exampleModalLabel'])[1]");

	public void clickeditbtnandcheckotherbtnareworkingsimilarly() throws InterruptedException {
		clickOnElement(editsupplierrow);
		Thread.sleep(3000);
		clickOnElement(importexportbtn);
		Thread.sleep(3000);
		String popupHeading = waitForExpectedElement(heading).getText();
		String expectedvalue = "Export to Excel";
		Assert.assertEquals(popupHeading, expectedvalue);
	}

	public static final By viewprocess = By.xpath("//button[@onclick='processList(1)']");
	public static final By editbtn = By.xpath("//table[@id='unitTable1']/tbody/tr[1]/td[2]/a/i[@class='fas fa-edit']");
	public static final By deltaprocess = By.xpath("(//input[@id='deltaRMApr'])[1]");
	public static final By updateprocessbtn = By.xpath("//button[@id='processSave']");
	public static final By searchsuppliermaster = By.xpath("(//input[@type='search'])[3]");
	public static final By searchsuppliernameinsearchbar = By.xpath("//table[@id='example1']/tbody/tr[1]/td[3]");

	public void updatedeltavalueinprocessmaster(String searchvalue) throws InterruptedException {
		dashboard.clickOnProcessItem();
		clickOnElement(viewprocess);
		Thread.sleep(7000);
		clickOnElement(editbtn);
		waitForExpectedElement(deltaprocess).clear();
		clickOnElement(updateprocessbtn);
		Thread.sleep(3000);
		dashboard.clickonsuppliermaster();
		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(searchsuppliermaster), searchvalue);
		String actualvalue = waitForExpectedElement(searchsuppliernameinsearchbar).getText();
		Assert.assertEquals(actualvalue, "Text-778-2-Text-979");
	}

	public static final By categoryTypeDropdown = By.id("Type");

	public String getCategoryDropdownDefaultValue() {
		clickOnElement(BusinessDomainSegments);
		WebElement dropdownElement = driver.findElement(categoryTypeDropdown);
		Select dropdown = new Select(dropdownElement);
		return dropdown.getFirstSelectedOption().getText().trim();
	}

	public boolean isDefaultValueSelect() {
		String defaultText = getCategoryDropdownDefaultValue();
		return defaultText.equalsIgnoreCase("Select");
	}

	// Locator for Category Name input field
	By categoryNameInput = By.xpath("//input[@placeholder='Enter']");

	// Get placeholder value from Category Name input
	public String getCategoryNamePlaceholder() {
		return driver.findElement(categoryNameInput).getAttribute("placeholder").trim();
	}

	public boolean isCategoryNamePlaceholderCorrect() {
		return getCategoryNamePlaceholder().equalsIgnoreCase("Enter");
	}
	// Locator for the Category Name input field

	// Enter value in Category Name
	public void enterCategoryName(String text, String value) throws InterruptedException {

		clickOnElement(BusinessDomainSegments);
		Thread.sleep(3000);
		driver.findElement(categoryNameInput).clear();
		driver.findElement(categoryNameInput).sendKeys(text);
		selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");
	}

	// Click Save button
	By saveBtn = By.xpath("//button[contains(text(),'Save')]");

	public void clickSaveButton() {
		driver.findElement(saveBtn).click();
	}

	// Get alert or error validation message (assumes client-side alert/validation
	// message)
	public String getValidationMessage() {
		// You can customize this based on how error is shown (toast, inline, alert,
		// etc.)
		try {
			return driver.findElement(By.cssSelector(".invalid-feedback, .text-danger")).getText().trim();
		} catch (Exception e) {
			return "";
		}
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
