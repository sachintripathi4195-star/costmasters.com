package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
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


public class CustomerMasterPage extends Base {
   
	
	Faker faker = new Faker();
	
	public static String customerCode;
	public static String customerName;
	public static String customerLocation;
	public static String businessDomain;
	public static String rm;
	public static String process;
	
	
	
	static String processValue;
	DashboardPage dashboard = new DashboardPage();

	public static final By BusinessDomainSegmenttab = By.xpath("//a[@href='#picklist']");
	public static final By categorytypedropdown = By.xpath("//select[@id='Type']");
	public static final By entercategorynamevalues = By.xpath("//input[@id='Name']");
	public static final By clicksearchbtn = By.xpath("//*[@id='businessdomainSegmentsTable_filter']/label/input");
	public static final By savebtn = By.xpath("//button[@id='saveBusinessDomainSegments']");
	public static final By toastmsg = By.xpath("//div[@class='toast-message']");
	public static final By editbuttonbusineesAndsegmenttab = By
			.xpath("//a[contains(@onclick, 'editbusinessDomainSegments')]");
	public static final By resetbtn = By.xpath("//button[@onclick='resetbusinessDomainSegments()']");
	public static final By clicknextbtn = By.xpath("//*[@id='businessdomainSegmentsTable_next']/a");
	public static final By deletebusinessSegment = By
			.xpath("//a[@onclick='return deletebusinessDomainSegments(8494,'2',onclick);']");
	public static final By selectdropdown = By.xpath("//*[@id='Type']");
	public static final By businedomainsegmentlengthdropdown = By
			.xpath("//*[@id='businessdomainSegmentsTable_length']/label/select");
	public static final By customercode = By.xpath("//input[@id='CustomerCode']");
	public static final By customername = By.xpath("//input[@id='CustomerName']");
	public static final By customerlocation = By.xpath("//input[@id='CustomerLocation']");
	public static final By businnessdomaidropdown = By
			.xpath("//select[@id='BusinessDomain']/following-sibling::div/button");
	public static final By businessDomainSearch = By
			.xpath("//select[@id='BusinessDomain']/following-sibling::div/button/following-sibling::div/div/input");
	public static final By businessDomainCheckBox = By
			.xpath("(//label[contains(text(), 'rishi')]/preceding-sibling::input[@type='checkbox'])[1]");
	public static final By businesssegmentdropdown = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/button");
	public static final By businesSegmentSearch = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/button/following-sibling::div/div/input");
	public static final By businessSegmentCheckBox = By
			.xpath("(//label[contains(text(), 'sachindra1')]/preceding-sibling::input[@type='checkbox'])[1]");
	public static final By customercodeheader = By.xpath("//table[@id='example1']//tr//th[2]");
	public static final By customerCodeColumn = By
			.xpath("//th[@aria-label='Customer Code: activate to sort column ascending']");
	public static final By customernameheader = By.xpath("//*[@id='example1']//tr//th[3]");
	public static final By customernameColumn = By.xpath("//*[@id='example1']/tbody/tr/td[3]");
	public static final By customerlocationheader = By
			.xpath("//*[@id='example1']//th[contains(@aria-label, 'Customer Location')]");
	public static final By customerlocationColumn = By.xpath("//*[@id='example1']/tbody/tr/td[4]");
	public static final By Businessdomainheader = By
			.xpath("//*[@id='example1']//th[contains(@aria-label,'Business Domain')]");
	public static final By Businessdomaincolumn = By.xpath("//*[@id='example1']/tbody/tr/td[5]");
	public static final By BusinessSegmentinheader = By
			.xpath("//*[@id='example1']//th[contains(@aria-label,'Business Segment')]");
	public static final By BusinessSegmentColumn = By.xpath("//*[@id='example1']/tbody/tr/td[6]");
	public static final By chooosePhotosSupplierPage = By.xpath("//input[@id=\"input-image-hidden\"]");
	public static final By searchboxincustomerpage = By.xpath("//*[@id=\"example1_filter\"]/label/input");
	public static final By clickeditbuttoncustomerpage = By.xpath("//*[@id=\"example1\"]/tbody/tr/td[7]/a[1]/span/i");
	public static final By clicksavebuttonInsupplierpage = By.xpath("//button[@id=\"btnSave\"]");
	public static final By toastmessageoncustomerpage = By.xpath("//div[@class='toast-message']");
	public static final By LengthMeasuringIncustomerPage = By.xpath("//*[@id=\"example1_length\"]/label/select");
	public static final By firstTableRowSizecustomer = By.xpath("//*[@id=\"example1\"]/tbody/tr");
	public static final By savebuttoncustomerpage = By.xpath("//button[@id='btnSave']");
	public static final By fetchtbalerowsInCustomerTab = By.xpath("//table/tbody/tr");
	public static final By processchkbox = By.xpath("//input[@class=\"Processchk\"]");
	public static final By processAllocationlist = By
			.xpath("//table[@id='processdatatable']/tbody/tr[2]/td[2]/div/input[@id='processdatackeched2']");
	public static final By ViewBtninProcessbtn = By.xpath("//button[@onclick=\"processList(1)\"]");
	public static final By SearchboxforCustomernameInprocessmaster = By
			.xpath("//input[@id=\"searchBoxProcessMaster\"]");
	public static final By searchboxbtnInprocessmaster = By.xpath("//button[@id=\"btnSearchProcess\"]");
	public static final By BusinessSegmentdropdownInProcessMaster = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/button");
	public static final By BusinessSegmentDropdownEntervalueInSearchBox = By
			.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/div/input");
	public static final By rmcheckbox = By.xpath("//input[@id=\"RM\"]");
	public static final By rmlistselect = By
			.xpath("//table[@id='rmdatatable']/tbody/tr[2]/td[2]/div/input[@id='rmdatackeched1']");
	public static final By commoditydatailstab = By
			.xpath("//ul[@class=\"nav nav-pills\"]//li[3]//a[@href=\"#CommodityDetailTab\"]");
	public static final By commoditydetailListViewbtn = By
			.xpath("//button[@onclick=\"comodityDetailList()\"]");
	public static final By commoditysearchtab = By.xpath("//input[@id=\"myInputListSearch\"]");
	public static final By commoditytablelist = By.xpath("//table[@id=\"comodityDetailListTable\"]/tbody/tr");
	public static final By clickonEditgradebtn = By.xpath("//*[@id=\"ComDetailBody\"]/tr[12]/td[2]/a[1]/i");
	public static final By clickeditforcustomer = By.xpath("//*[@id=\"unitTable1\"]/tbody/tr/td[2]/a[1]");
	public static final By clickcustomerspecificdelta = By
			.xpath("(//*[@id=\"rmDiv\"]/div[1]/div/div/span/div/button/span)[2]");
	public static final By customerSpecificDeltaSelectAll = By.xpath(
			"//select[@id='CustomerSpecificDelta']/following-sibling::div/button/following-sibling::div/button[@title=' Select all']");
	public static final By landedPriceinprocessforcustomer = By
			.xpath("//*[@id=\"DeltaTableBodyCustomer\"]/tr/td[3]/input[1]");
	public static final By processnamevalueforcustomerallocation = By
			.xpath("//table[@id='processdatatable']/tbody/tr[2]/td[3]");
	
	public static final By clickexporandimporttbtn = By.xpath("//div[@class=\"col-md-12 flex_end mb-1 footer_sticky_button cs_gap_btn\"]//button[3]");
	public static final By exportmasterallocationnewsupplire = By.xpath("//input[@id=\"newsup\"]");
	public static final By clickyearlycheckboxwhileExportingnewData = By.xpath("//input[@id=\"Yearly\"]");
	public static final By clickfirstDropdownwhileExpoertingnewfile = By
			.xpath("//*[@id=\"Domestic_YearlyRBtn\"]/div/div[3]/div/span/div/button/span");
	public static final By entervalueinfirstdropdown = By
			.xpath("//*[@id=\"Domestic_YearlyRBtn\"]/div/div[3]/div/span/div/div/div/input");
	public static final By clickfirstvalueindropdown = By.xpath("//button[@title='CRCA-007']/span/input");
	public static final By clicksecondDropdownwhileExportingNewfile = By.xpath(
			"//label[normalize-space(text())='Process']/parent::div/following-sibling::div//button[contains(@class, 'dropdown-toggle')]");
	public static final By searchvalueforsecoddropdown = By.xpath(
			"//select[@id='Processdropdown']/following-sibling::div/button/following-sibling::div//input[@class='multiselect-search form-control']");
	public static final By clickseconddropdownvalue = By.xpath(
			"(//select[@id='Processdropdown']/following-sibling::div/button/following-sibling::div//div/following-sibling::button[@title='Process-1']/span/input)[1]");
	public static final By clickthirdDropdownwhileExportingNewfile = By
			.xpath("//*[@id=\"OHPName\"]/div/div[3]/div/span/div/button/span");
	public static final By clickthirdvalue = By.xpath(
			"//label[@for='multiselect_eb6e4ore7ps_0_1']");
	public static final By exportbtn = By.xpath("//*[@id=\"exportModalForCustomers\"]/div/div/div[3]/button[1]");
	public static final By clickmasterdataforauthorisation = By.xpath("//div[@id=\"jstree\"]//li[@id=2]//i[@class=\"jstree-icon jstree-ocl\"]");
//	public static final By clickOnCustomerAllocateAuthorisation = By.xpath("(//div[@id='jstree']//ul/li)[7]/i");
	public static  final By userbtn  = By.xpath("//li[@class=\"slide\"]//a[@href=\"/Subscription/Users\"]");
	public static final By userauthorizationtab = By.xpath("//a[@href=\"#UserAuthorizationTab\"]");
	public static final By userideditbtn = By.xpath("//table[@id=\"example2\"]//tbody//tr[5]//td[4]//a[@href=\"/Subscription/EditUserAuthorize/729f1029-0522-4ff3-8107-e9f9a70e20ce\"]");
	public static final By clicktrianglecustomer = By.xpath("//ul[@class=\"jstree-children\"]//li[@id=\"39\"]//i");
	public static final By clickReadAndWriteInUserAuthorisationForCustomer= By.xpath("//li[@id='39']//li[.//a[contains(text(), 'Read & Write')]]//i[contains(@class, 'jstree-checkbox')]");
	public static final By updatebtn = By.xpath("//a[@id=\"btnSubmit\"]");
	public static final By ohpcheckbox = By.xpath("//input[@id=\"OHP\"]");
	public static final By ohpDataTableIncustomerpage = By.xpath("//table[@id=\"ohpdatatable\"]//tbody//tr[2]//td[2]//div//input[@id=\"ohpdatackeched2\"]");
	
	public static final By clickviewbtnohptable = By.xpath("//button[@id=\"btnView\"]");
	public static final By ClickEditBtnOnOhpTable = By.xpath("//table[@id='example1']/tbody/tr[2]/td[6]/a/span/i[@class = 'fas fa-edit']");
	

	public void selectdropdownbusinessDomainSegmenttab(String value) {
	    try {
	        LoggerUtil.info("Step 1: Locating Business Domain Segment dropdown...");
	        WebElement dropdown = waitForExpectedElement(categorytypedropdown);

	        LoggerUtil.info("Step 2: Clicking on dropdown...");
	        dropdown.click();

	        LoggerUtil.info("Step 3: Selecting value '" + value + "' from dropdown...");
	        selectDropDownValue(categorytypedropdown, value, "selectValue");

	        LoggerUtil.pass("Value '" + value + "' selected successfully from Business Domain Segment dropdown.");

	    } catch (Exception e) {
	        LoggerUtil.error("Exception while selecting value from Business Domain Segment dropdown: " + e.getMessage());
	    }
	}


	public void clickbuttonOnBusinessDomainSegmentTab() throws InterruptedException {

		clickOnElement(BusinessDomainSegmenttab);
		Thread.sleep(3000);
		selectdropdownbusinessDomainSegmenttab("2");
		Thread.sleep(4000);

	}

	public void enterValuesbusinessdomain(String categoryname) throws InterruptedException {
	    try {
	        LoggerUtil.logger.info("Navigating to Business Domain/Segment tab...");
	        clickOnElement(BusinessDomainSegmenttab);
	        Thread.sleep(3000);

	        LoggerUtil.logger.info("Selecting business domain segment from dropdown...");
	        selectdropdownbusinessDomainSegmenttab("2"); // Assuming '2' is index or value
	        Thread.sleep(4000);

	        LoggerUtil.logger.info("Entering Category Name: " + categoryname);
	        clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);

	        LoggerUtil.logger.info("Clicking on Save button...");
	        clickOnElement(savebtn);

	        // Wait briefly for toast to appear
	        Thread.sleep(2000); // Replace with proper wait if needed
	        String actualmsg = waitForExpectedElement(toastmessage).getText().trim();
	        String expectedmsg = "Business domain sucessfully saved.";

	        LoggerUtil.logger.info("Expected Toast Message: " + expectedmsg);
	        LoggerUtil.logger.info("Actual Toast Message: " + actualmsg);

	        Assert.assertEquals(actualmsg, expectedmsg, "❌ Toast Message mismatch. Business domain save failed.");

	        LoggerUtil.logger.info("✅ Business domain saved successfully. Toast message verified.");

	    } catch (Exception e) {
	        LoggerUtil.logger.error("❌ Exception while entering Business Domain: " + e.getMessage());
	        Assert.fail("Exception while saving Business Domain.");
	    }
	}


	public void enterValuesbusinessSegment(String categoryname, String message) throws InterruptedException {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Business Domain Segment tab...");
	        try {
	            clickOnElement(BusinessDomainSegmenttab);
	            LoggerUtil.pass("Clicked on Business Domain Segment tab.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Business Domain Segment tab: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 2: Waiting for 3 seconds...");
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 3: Selecting dropdown value '3'...");
	        try {
	            selectdropdownbusinessDomainSegmenttab("3");
	            LoggerUtil.pass("Dropdown value '3' selected successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to select dropdown value: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 4: Waiting for 4 seconds...");
	        Thread.sleep(4000);

	        LoggerUtil.info("Step 5: Entering category name value: '" + categoryname + "'...");
	        try {
	            clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);
	            LoggerUtil.pass("Category name '" + categoryname + "' entered successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to enter category name: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 6: Clicking on Save button...");
	        try {
	            clickOnElement(savebtn);
	            LoggerUtil.pass("Save button clicked successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Save button: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 7: Capturing and validating toast message...");
	        try {
	            String actualToast = waitForExpectedElement(toastmsg).getText();
	            System.out.println("Toast Message: " + actualToast);
	            LoggerUtil.info("Toast Message Displayed: " + actualToast);

	            if (actualToast.contains(message)) {
	                LoggerUtil.pass("Toast message matched! Expected to contain: '" + message + "' | Actual: " + actualToast);
	            } else {
	                LoggerUtil.fail("Toast message mismatch! Expected to contain: '" + message + "' | Actual: " + actualToast);
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to capture or validate toast message: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected exception in enterValuesbusinessSegment: " + e.getMessage());
	    }
	}

	public void enterInvalidValuesbusinessSegment(String categoryname, String message) throws InterruptedException {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Business Domain Segment tab...");
	        try {
	            clickOnElement(BusinessDomainSegmenttab);
	            LoggerUtil.pass("Clicked on Business Domain Segment tab.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Business Domain Segment tab: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 2: Waiting for 3 seconds...");
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 3: Selecting dropdown value '3'...");
	        try {
	            selectdropdownbusinessDomainSegmenttab("3");
	            LoggerUtil.pass("Dropdown value '3' selected successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to select dropdown value: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 4: Waiting for 4 seconds...");
	        Thread.sleep(4000);

	        LoggerUtil.info("Step 5: Entering invalid category name value: '" + categoryname + "'...");
	        try {
	            clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);
	            LoggerUtil.pass("Invalid category name '" + categoryname + "' entered successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to enter category name: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 6: Clicking on Save button...");
	        try {
	            clickOnElement(savebtn);
	            LoggerUtil.pass("Save button clicked successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Save button: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 7: Capturing and validating toast message...");
	        try {
	            String actualToast = waitForExpectedElement(toastmsg).getText();
	            System.out.println("Toast Message: " + actualToast);
	            LoggerUtil.info("Toast Message Displayed: " + actualToast);

	            if (actualToast.contains(message)) {
	                LoggerUtil.pass("Toast message matched! Expected to contain: '" + message + "' | Actual: " + actualToast);
	            } else {
	                LoggerUtil.fail("Toast message mismatch! Expected to contain: '" + message + "' | Actual: " + actualToast);
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to capture or validate toast message: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected exception in enterInvalidValuesbusinessSegment: " + e.getMessage());
	    }
	}


	public void VerifyDuplicateEntryToastMessage(String categoryname, String message) throws InterruptedException {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Business Domain Segment tab...");
	        try {
	            clickOnElement(BusinessDomainSegmenttab);
	            LoggerUtil.pass("Clicked on Business Domain Segment tab.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Business Domain Segment tab: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 2: Waiting for 3 seconds...");
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 3: Selecting dropdown value '2'...");
	        try {
	            selectdropdownbusinessDomainSegmenttab("2");
	            LoggerUtil.pass("Dropdown value '2' selected successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to select dropdown value: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 4: Waiting for 4 seconds...");
	        Thread.sleep(4000);

	        LoggerUtil.info("Step 5: Entering category name value: '" + categoryname + "'...");
	        try {
	            clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);
	            LoggerUtil.pass("Category name '" + categoryname + "' entered successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to enter category name: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 6: Clicking on Save button...");
	        try {
	            clickOnElement(savebtn);
	            LoggerUtil.pass("Save button clicked successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Save button: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 7: Capturing and validating duplicate entry toast message...");
	        try {
	            String actualToast = waitForExpectedElement(toastmsg).getText();
	            System.out.println("Toast Message: " + actualToast);
	            LoggerUtil.info("Toast Message Displayed: " + actualToast);

	            if (actualToast.contains(message)) {
	                LoggerUtil.pass("Duplicate entry toast message matched! Expected to contain: '" 
	                                + message + "' | Actual: " + actualToast);
	            } else {
	                LoggerUtil.fail("Duplicate entry toast message mismatch! Expected to contain: '" 
	                                + message + "' | Actual: " + actualToast);
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to capture or validate duplicate entry toast message: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected exception in VerifyDuplicateEntryToastMessage: " + e.getMessage());
	    }
	}


	public void enterduplicateentrywithbusinessSegment(String categoryname, String message) throws InterruptedException {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Business Domain Segment tab...");
	        try {
	            clickOnElement(BusinessDomainSegmenttab);
	            LoggerUtil.pass("Clicked on Business Domain Segment tab.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Business Domain Segment tab: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 2: Waiting for 3 seconds...");
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 3: Selecting dropdown value '3'...");
	        try {
	            selectdropdownbusinessDomainSegmenttab("3");
	            LoggerUtil.pass("Dropdown value '3' selected successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to select dropdown value: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 4: Waiting for 4 seconds...");
	        Thread.sleep(4000);

	        LoggerUtil.info("Step 5: Entering category name value: '" + categoryname + "'...");
	        try {
	            clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);
	            LoggerUtil.pass("Category name '" + categoryname + "' entered successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to enter category name: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 6: Clicking on Save button...");
	        try {
	            clickOnElement(savebtn);
	            LoggerUtil.pass("Save button clicked successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Save button: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 7: Capturing and validating duplicate entry toast message...");
	        try {
	            String actualToast = waitForExpectedElement(toastmsg).getText();
	            System.out.println("Toast Message: " + actualToast);
	            LoggerUtil.info("Toast Message Displayed: " + actualToast);

	            if (actualToast.contains(message)) {
	                LoggerUtil.pass("Duplicate entry toast message matched! Expected to contain: '" 
	                                + message + "' | Actual: " + actualToast);
	            } else {
	                LoggerUtil.fail("Duplicate entry toast message mismatch! Expected to contain: '" 
	                                + message + "' | Actual: " + actualToast);
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to capture or validate toast message: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected exception in enterduplicateentrywithbusinessSegment: " + e.getMessage());
	    }
	}


	public void clickEditButton(int rowIndex, String categoryname, String message) {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Business Domain Segment tab...");
	        try {
	            clickOnElement(BusinessDomainSegmenttab);
	            LoggerUtil.pass("Clicked on Business Domain Segment tab.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Business Domain Segment tab: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 2: Locating edit buttons in Business Domain Segment table...");
	        List<WebElement> buttons = driver.findElements(editbuttonbusineesAndsegmenttab);

	        if (!buttons.isEmpty() && rowIndex < buttons.size()) {
	            try {
	                buttons.get(rowIndex).click();
	                LoggerUtil.pass("Clicked on edit button at row index: " + rowIndex);
	            } catch (Exception e) {
	                LoggerUtil.error("Failed to click on edit button at row index " + rowIndex + ": " + e.getMessage());
	                return;
	            }
	        } else {
	            LoggerUtil.fail("Invalid row index or no edit buttons found.");
	            return;
	        }

	        LoggerUtil.info("Step 3: Entering category name value: '" + categoryname + "'...");
	        try {
	            clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);
	            LoggerUtil.pass("Category name '" + categoryname + "' entered successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to enter category name: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 4: Selecting dropdown value '3'...");
	        try {
	            selectdropdownbusinessDomainSegmenttab("3");
	            LoggerUtil.pass("Dropdown value '3' selected successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to select dropdown value: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 5: Clicking on Save button...");
	        try {
	            clickOnElement(savebtn);
	            LoggerUtil.pass("Save button clicked successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Save button: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 6: Capturing and validating toast message...");
	        try {
	            String actualToast = waitForExpectedElement(toastmsg).getText();
	            System.out.println("Toast Message: " + actualToast);
	            LoggerUtil.info("Toast Message Displayed: " + actualToast);

	            if (actualToast.contains(message)) {
	                LoggerUtil.pass("Toast message matched! Expected to contain: '" 
	                                + message + "' | Actual: " + actualToast);
	            } else {
	                LoggerUtil.fail("Toast message mismatch! Expected to contain: '" 
	                                + message + "' | Actual: " + actualToast);
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to capture or validate toast message: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected exception in clickEditButton: " + e.getMessage());
	    }
	}

	public void clickbusinessSegdomtab() {
		clickOnElement(BusinessDomainSegmenttab);

	}

	public void validateShadowTextVisible(By ele) throws InterruptedException {
	    LoggerUtil.info("Step 1: Waiting for element visibility...");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	        LoggerUtil.pass("Element found and visible.");

	        LoggerUtil.info("Step 2: Checking 'aria-invalid' attribute for visibility...");
	        try {
	            boolean isInvalid = wait.until(driver -> {
	                String attrValue = element.getDomAttribute("aria-invalid");
	                System.out.println("Updated aria-invalid value: " + attrValue);
	                LoggerUtil.info("Updated aria-invalid value: " + attrValue);
	                return attrValue != null && Boolean.parseBoolean(attrValue);
	            });

	            if (isInvalid) {
	                LoggerUtil.pass("Validation passed! Shadow text is visible. aria-invalid = true");
	            } else {
	                LoggerUtil.fail("Validation failed! Expected shadow text visible but got aria-invalid = false");
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed while validating 'aria-invalid' attribute: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error while waiting for element visibility: " + e.getMessage());
	    }
	}


	public void clicknextpagebutton() {
		clickOnElement(BusinessDomainSegmenttab);
		clickOnElement(clicknextbtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));
		System.out.println("Total Rows in Table: " + rows.size());
		System.out.println("hello we are going to open secoond page");
		Assert.assertEquals(rows.size(), 25, "❌ Table does NOT have 25 rows!");

	}

	public void businessdomainsegmentlengthtable(String value) {

		WebElement lengthdropdown = waitForExpectedElement(selectdropdown);
		lengthdropdown.click();
		selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

		// Find all rows inside tbody
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));

		// Print and verify rows count
		System.out.println("Total Rows in Table: " + rows.size());
		Assert.assertEquals(rows.size(), 25, "❌ Table does NOT have 25 rows!");

	}

	public void clickbusinessdomainsegmentlengthtableforfifty(String value) {

		WebElement lengthdropdown = waitForExpectedElement(selectdropdown);
		lengthdropdown.click();
		selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

		// Find all rows inside tbody
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));

		// Print and verify rows count
		System.out.println("Total Rows in Table: " + rows.size());
		Assert.assertEquals(rows.size(), 50, "❌ Table does NOT have 50 rows!");

	}

	public void clickbusinessdomainsegmentlengthtableforseventyfive(String value) {

		WebElement lengthdropdown = waitForExpectedElement(selectdropdown);
		lengthdropdown.click();
		selectDropDownValue(businedomainsegmentlengthdropdown, value, "selectValue");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessdomainSegmentsTable")));

		// Find all rows inside tbody
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='businessdomainSegmentsTable']//tbody/tr"));

		// Print and verify rows count
		System.out.println("Total Rows in Table: " + rows.size());
		Assert.assertEquals(rows.size(), 75, "❌ Table does NOT have 75 rows!");

	}

	public void sortingWithCustomerCode() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(customercodeheader)).click();

		// Ensure table gets updated before fetching new data
		try {
			Thread.sleep(2000); // Small delay to let table update
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<String> getcustomerCodes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for table data to change after sorting
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(customerCodeColumn)));

		return driver.findElements(customerCodeColumn).stream().map(WebElement::getText).map(String::trim) // Trim
				// whitespace
				.map(String::toLowerCase) // Normalize case for accurate comparison
				.collect(Collectors.toList());
	}

	public boolean isSortedDescending(List<String> codes) {
		// Debugging: Print original list
		System.out.println("Original Codes: " + codes);

		List<String> sortedList = new ArrayList<>(codes); // Copy original list
		sortedList.sort(Comparator.reverseOrder()); // Sort in descending order

		// Debugging: Print sorted list
		System.out.println("Sorted Codes: " + sortedList);

		// Manually compare each element
		for (int i = 0; i < codes.size(); i++) {
			if (!codes.get(i).equals(sortedList.get(i))) {
				System.out.println("Mismatch at index " + i + ": " + codes.get(i) + " != " + sortedList.get(i));
				return false; // 🔥 Test will fail if even one mismatch is found
			}
		}

		return true;
	}

	public void sortingWithcustomerName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(customernameheader));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			List<String> currentValues = getcustomerName();

			header.click();
			header.click();

			wait.until(driver -> {
				try {
					List<String> newValues = getcustomerName();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			List<String> updatedValues = getcustomerName();

			if (isSortedDescendingforname(updatedValues)) {
				break;
			}
		}
	}

	public List<String> getcustomerName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(customernameColumn));
		if (elements.isEmpty()) {
			throw new NoSuchElementException("Customer Name column has no data.");
		}
		return elements.stream().map(WebElement::getText).map(String::trim).map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	public boolean isSortedDescendingforname(List<String> names) {
		System.out.println("Original Names: " + names);
		List<String> sortedList = new ArrayList<>(names);
		sortedList.sort(Comparator.reverseOrder());
		System.out.println("Sorted Names: " + sortedList);
		return names.equals(sortedList);
	}

	public void sortingWithcustomerLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(customerlocationheader));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			List<String> currentValues = getcustomerLocation();

			header.click();
			header.click();

			wait.until(driver -> {
				try {
					List<String> newValues = getcustomerLocation();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			List<String> updatedValues = getcustomerLocation();

			if (isSortedDescending(updatedValues)) {
				break;
			}
		}
	}

	public List<String> getcustomerLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(customerlocationColumn));
		if (elements.isEmpty()) {
			throw new NoSuchElementException("customer Location column has no data.");
		}
		return elements.stream().map(WebElement::getText).map(String::trim).map(String::toLowerCase)
				.collect(Collectors.toList());
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Businessdomaincolumn));
		if (elements.isEmpty()) {
			throw new NoSuchElementException("Business Domain column has no data.");
		}
		return elements.stream().map(WebElement::getText).map(String::trim).map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	public void sortingWithBusinessSegment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement header = wait.until(ExpectedConditions.elementToBeClickable(BusinessSegmentinheader));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			List<String> currentValues = getBusinessSegment();

			header.click();

			wait.until(driver -> {
				try {
					List<String> newValues = getBusinessSegment();
					return !newValues.equals(currentValues);
				} catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
					return false;
				}
			});

			List<String> updatedValues = getBusinessSegment();

			if (isSortedDescending(updatedValues)) {
				break;
			}
		}
	}

	public List<String> getBusinessSegment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> elements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BusinessSegmentColumn));
		if (elements.isEmpty()) {
			throw new NoSuchElementException("Business Segment column has no data.");
		}
		return elements.stream().map(WebElement::getText).map(String::trim).map(String::toLowerCase)
				.collect(Collectors.toList());
	}

	public void selectFile(String message) {

		waitForExpectedElement(chooosePhotosSupplierPage)
		.sendKeys(System.getProperty("user.dir") + "/src/test/resources/env.properties");
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));

	}

	public void verifyClickingEditButtonWorksCorrectly(String enterSearchValue) throws InterruptedException {
		// Search for supplier
		clearAndEnterText(waitForExpectedElement(searchboxincustomerpage), enterSearchValue);
		Thread.sleep(2000); // Use WebDriverWait instead of Thread.sleep for better stability

		// Click on Edit button
		clickOnElement(clickeditbuttoncustomerpage);

		// Fetch values after clicking Edit
		String actualSupplierCode = waitForExpectedElement(customercode).getDomAttribute("value");
		String actualSupplierName = waitForExpectedElement(customername).getDomAttribute("value");

		// Print values for debugging
		System.out.println("Customer Code: " + actualSupplierCode);
		System.out.println("Customer Name: " + actualSupplierName);
	}

	public boolean verifyAutoFilledData(String expectedSupplierName, String expectedSupplierCode) {
		// Fetch the actual values after clicking Edit
		String actualcustomercode = waitForExpectedElement(customercode).getDomAttribute("value");
		String actualcustomername = waitForExpectedElement(customername).getDomAttribute("value");

		// Verify if actual values match expected values
		boolean isNameCorrect = actualcustomername.equals(getcustomerName());
		Object expectedcustomercode = null;
		boolean isCodeCorrect = actualcustomercode.equals(expectedcustomercode);

		return isNameCorrect && isCodeCorrect;
	}

	public void EnterInvalidDataInSupplierCOde(String cname, String Ccode, String clocation) {

		clearAndEnterText(waitForExpectedElement(customername), cname);
		clearAndEnterText(waitForExpectedElement(customercode), Ccode);
		clearAndEnterText(waitForExpectedElement(customerlocation), clocation);
		clickOnElement(businnessdomaidropdown);

		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");

		clickOnElement(businessDomainCheckBox);

		clickOnElement(businesssegmentdropdown);

		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");

		clickOnElement(businessSegmentCheckBox);

		clickOnElement(clicksavebuttonInsupplierpage);
		

	}

	public void lengthmeasuringincustomererpage(String numberRecord) {

		WebElement lengthdropdown = waitForExpectedElement(LengthMeasuringIncustomerPage);
		selectDropDownValue(LengthMeasuringIncustomerPage, numberRecord, "selectValue");

		int expectedNumberRecordValue = Integer.parseInt(numberRecord);

		List<WebElement> testList = driver.findElements(firstTableRowSizecustomer);

		int actualRecord = testList.size();

		Assert.assertEquals(actualRecord, expectedNumberRecordValue);

	}

	public void lengthmeasuringincustomererpageforFifty(String numberRecord) {

		WebElement lengthdropdown = waitForExpectedElement(LengthMeasuringIncustomerPage);
		selectDropDownValue(LengthMeasuringIncustomerPage, numberRecord, "selectValue");

		int expectedNumberRecordValue = Integer.parseInt(numberRecord);

		List<WebElement> testList = driver.findElements(firstTableRowSizecustomer);

		int actualRecord = testList.size();

		Assert.assertEquals(actualRecord, expectedNumberRecordValue);

	}

	public void lengthmeasuringincustomererpageforSeventyFifty(String numberRecord) {

		WebElement lengthdropdown = waitForExpectedElement(LengthMeasuringIncustomerPage);
		selectDropDownValue(LengthMeasuringIncustomerPage, numberRecord, "selectValue");

		int expectedNumberRecordValue = Integer.parseInt(numberRecord);

		List<WebElement> testList = driver.findElements(firstTableRowSizecustomer);

		int actualRecord = testList.size();

		Assert.assertEquals(actualRecord, expectedNumberRecordValue);

	}

	public void deletingcostingsegmentdata(String supplierCode, String supplierNode, String supplierlocation,
			String search) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(customercode), supplierCode);

		clearAndEnterText(waitForExpectedElement(customername), supplierNode);

		clearAndEnterText(waitForExpectedElement(customerlocation), supplierlocation);

		clickOnElement(businnessdomaidropdown);

		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");

		clickOnElement(businessDomainCheckBox);

		clickOnElement(businesssegmentdropdown);

		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");

		clickOnElement(businessSegmentCheckBox);

		clickOnElement(savebuttoncustomerpage);

		clickOnElement(BusinessDomainSegmenttab);

		Thread.sleep(5000);

		clearAndEnterText(waitForExpectedElement(clicksearchbtn), search);

		clickOnElement(deletebusinessSegment);

		driver.switchTo().alert().accept();

		Thread.sleep(4000);

		Assert.assertEquals(waitForExpectedElement(toastmsg).getText(), "Data Already Being Used in Costing!");

	}

	public void userEnterWithInValiDataInSupplierPage(String Customercode, String Customername, String Customerlocation,
			String message) {

		clearAndEnterText(waitForExpectedElement(customercode), Customercode);
		clearAndEnterText(waitForExpectedElement(customername), Customername);
		clearAndEnterText(waitForExpectedElement(customerlocation), Customerlocation);
		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);
		clickOnElement(savebuttoncustomerpage);
		Assert.assertTrue(waitForExpectedElement(toastmessageoncustomerpage).getText().contains(message));

	}

	public boolean IsDataSavedAsItIsiNTableOrNot(String customercode, String customername, String customerlocation,
			String businessDomain, String businessSegments) {

		List<WebElement> rowslist = driver.findElements(fetchtbalerowsInCustomerTab);

		for (WebElement row : rowslist) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			if (columns.size() >= 6 && columns.get(1).getText().equals(customercode)
					&& columns.get(2).getText().equals(customername)
					&& columns.get(3).getText().equals(customerlocation)
					&& columns.get(4).getText().equals(businessDomain)
					&& columns.get(5).getText().equals(businessSegments)) {

				return true; // Data found
			}
		}

		return false;

	}

	public void enterCustomerValueForProcessAllocation(String custCode, String custNode, String custlocation)
			throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(customercode), custCode);

		clearAndEnterText(waitForExpectedElement(customername), custNode);

		clearAndEnterText(waitForExpectedElement(customerlocation), custlocation);

		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);
		Thread.sleep(5000);
		clickOnElement(processchkbox);
		Thread.sleep(4000);
		clickOnElement(processAllocationlist);
		processValue = waitForExpectedElement(processnamevalueforcustomerallocation).getText();

		clickOnElement(savebuttoncustomerpage);
		Thread.sleep(5000);
		dashboard.clickOnProcessItem();

		clickOnElement(ViewBtninProcessbtn);
		clearAndEnterText(waitForExpectedElement(SearchboxforCustomernameInprocessmaster), processValue);
		Thread.sleep(3000);
		clickOnElement(searchboxbtnInprocessmaster);
		String clickeditbtnInProcessMaster = "//tbody/tr[td[contains(., '" + processValue + "')]]/td[2]/a[1]";
		driver.findElement(By.xpath(clickeditbtnInProcessMaster)).click();
		Thread.sleep(3000);
		String deltaValueElement = waitForExpectedElement(
				By.xpath("//table[@id=\"comodityRMDeltaTableCustomer\"]//tbody//td[2]//input"))
				.getDomAttribute("value");
		double deltaValueDouble = Double.parseDouble(deltaValueElement);
		int deltaValueInt = (int) deltaValueDouble;
		System.out.println(deltaValueInt);
		String landedpriceElement = waitForExpectedElement(
				By.xpath("(//table[@id=\"comodityRMDeltaTableCustomer\"]//tbody//td[3]//input)[2]"))
				.getDomAttribute("value");
		System.out.println(landedpriceElement);
		double landedPriceDouble = Double.parseDouble(landedpriceElement);
		int landedPriceInt = (int)landedPriceDouble;
		System.out.println(landedPriceInt);
		Assert.assertEquals(3000+deltaValueInt, landedPriceInt);
	}

	
	
	public void entercustomervalueforrminput(String custCode, String custNode, String custlocation)
			throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(customercode), custCode);

		clearAndEnterText(waitForExpectedElement(customername), custNode);

		clearAndEnterText(waitForExpectedElement(customerlocation), custlocation);

		clickOnElement(businnessdomaidropdown);
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		clickOnElement(businessDomainCheckBox);
		clickOnElement(businesssegmentdropdown);
		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");
		clickOnElement(businessSegmentCheckBox);

		clickOnElement(rmcheckbox);
		Thread.sleep(4000);
		clickOnElement(rmlistselect);
		Thread.sleep(4000);
		clickOnElement(savebuttoncustomerpage);

	}

	public void commoditytab() {
		clickOnElement(commoditydatailstab);
		waitForExpectedElement(commoditydetailListViewbtn).click();
		waitForExpectedElement(commoditysearchtab).clear();
		waitForExpectedElement(commoditysearchtab).sendKeys("Alloying Elements");
	}

	public boolean isDataPresent(String searchText) {
		List<WebElement> rows = driver.findElements(commoditytablelist);
		for (WebElement row : rows) {
			if (row.getText().contains(searchText)) {
				System.out.println("✅ Data Found: " + row.getText());
				return true;
			}
		}
		System.out.println("❌ Data Not Found in Table!");
		return false;
	}

	public void clickEditIn12thRow() {
		clickOnElement(By.xpath("//table[@id=\"comodityDetailListTable\"]//tbody//tr[2]//td[2]//a//i"));
	}

	public void searchAndVerifySelection(String custcode) throws InterruptedException {
		// Wait for search bar in Customer section
		WebElement searchInput = waitForExpectedElement(By.xpath("//input[@id='myInputCustomer']"));
		searchInput.clear();
		Thread.sleep(8000);
		searchInput.sendKeys(custcode);
		Thread.sleep(8000);
		// Wait for checkbox with dynamic label (text match) and validate selection
		WebElement supplierCheckbox = waitForExpectedElement(
				By.xpath("//label[contains(normalize-space(), 'Ronaldo123-R009')]/input[@type='checkbox']"));
		Assert.assertTrue(supplierCheckbox.isSelected());


	}
	
	public void ExportandImportForNewExcelFile() throws InterruptedException {
		
		
		clickOnElement(clickexporandimporttbtn);
   		clickOnElement(exportmasterallocationnewsupplire);	
   		Thread.sleep(4000);
   		clickOnElement(clickyearlycheckboxwhileExportingnewData);
   		Thread.sleep(4000);
   		clickOnElement(clickfirstDropdownwhileExpoertingnewfile);
   		clearAndEnterText(waitForExpectedElement(entervalueinfirstdropdown), "CRCA-007");
   		clickOnElement(clickfirstvalueindropdown);
   		clickOnElement(clicksecondDropdownwhileExportingNewfile);
   		clearAndEnterText(waitForExpectedElement(searchvalueforsecoddropdown), "Process-1");
   		clickOnElement(clickseconddropdownvalue);
   		Thread.sleep(2000);
   		clickOnElement(exportbtn);
   		Thread.sleep(4000);
   		fillCustomerSheet();
   		Thread.sleep(4000);
   		importNewCustomerMasterExcel();
		
		
	}
	
	public String fillCustomerSheet() {
   		File latestFile = getLatestCustomerMasterFIle();
   		if (latestFile == null) {
   		System.out.println("No SupplierMaster file found.");
   		return null;
   		}

   		String filePath = latestFile.getAbsolutePath();

   		// Values to write
   		customerCode = faker.name().firstName();
   		customerName = faker.name().lastName();
   		customerLocation = "Mohali";
   		businessDomain = "rishi123";
   		rm = "Yes";
   		process = "Yes";

   		// Fill Excel
   		ExcelFiller.setCellValue(filePath, 0, 2, 1, ExcelFiller.ValueType.INTEGER, null);
   		ExcelFiller.setCellValue(filePath, 0, 2, 2, ExcelFiller.ValueType.STRING, null);
   		ExcelFiller.setCellValue(filePath, 0, 2, 3, ExcelFiller.ValueType.STRING, null);
   		ExcelFiller.setCellValue(filePath, 0, 2, 4, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(businessDomain));
   		ExcelFiller.setCellValue(filePath, 0, 2, 6, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(rm));
   		ExcelFiller.setCellValue(filePath, 0, 2, 7, ExcelFiller.ValueType.DROPDOWN, Arrays.asList(process));
   		

   		System.out.println("Supplier data filled successfully in: " + filePath);
   		return latestFile.getName();
   		}
   		public void importNewCustomerMasterExcel() throws InterruptedException {
   		String fileName = fillCustomerSheet();
   		String fullPath = System.getProperty("user.dir") + "/downloads/" + fileName;

   		WebElement fileInput = driver.findElement(By.id("excelUploadNew"));

   		// Make it visible via JS
   		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

   		// Send file path
   		fileInput.sendKeys(fullPath);

   		// Confirm import
   		Thread.sleep(7000);
   		// WebElement importBtn = driver.findElement(By.xpath("//button[text()='Import']"));
   		// importBtn.click();
   		}
	
	
	
	public void clickUserButtonTocheckUserAuthorization() throws InterruptedException {
		
		clickOnElement(userbtn);
		clickOnElement(userauthorizationtab);
		clickOnElement(userideditbtn);
		clickOnElement(clickmasterdataforauthorisation);
		Thread.sleep(3000);
	//	clickOnElement(clickOnCustomerAllocateAuthorisation);
		clickOnElement(clicktrianglecustomer);
		Thread.sleep(4000);
		clickOnElement(clickReadAndWriteInUserAuthorisationForCustomer);
		Thread.sleep(3000);
		clickOnElement(updatebtn);
		Thread.sleep(3000);
	//	dashboard.clickOnControlMaster();
		Thread.sleep(4000);
		dashboard.VerifyClickingMasterOptions("Customer");
		
		List<WebElement> saveBtnList = driver.findElements(By.xpath("//button[@id=\"btnSave\"]"));

		if (saveBtnList.size() == 0 || !saveBtnList.get(0).isDisplayed()) {
		    System.out.println("✅ Save button is not visible — verified successfully.");
		} else {
		    System.out.println("❌ Save button is visible — test failed.");
		}
		
		
	}
	
	
	public void validateShadowTextInvisible(By ele, String enterText) {
	    try {
	        LoggerUtil.info("Step 1: Clicking on Business Domain Segment tab...");
	        try {
	            clickOnElement(BusinessDomainSegmenttab);
	            LoggerUtil.pass("Clicked on Business Domain Segment tab.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to click on Business Domain Segment tab: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 2: Entering text '" + enterText + "' in the field...");
	        try {
	            clearAndEnterText(waitForExpectedElement(ele), enterText);
	            LoggerUtil.pass("Entered text '" + enterText + "' successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to enter text in the field: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 3: Pressing TAB to trigger validation...");
	        try {
	            pressTab();
	            LoggerUtil.pass("TAB key pressed successfully.");
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to press TAB key: " + e.getMessage());
	            return;
	        }

	        LoggerUtil.info("Step 4: Checking 'aria-invalid' attribute value...");
	        try {
	            String value = waitForExpectedElement(ele).getDomAttribute("aria-invalid");
	            boolean actualValue = Boolean.parseBoolean(value);

	            if (!actualValue) {
	                LoggerUtil.pass("Validation passed! Shadow text is invisible. aria-invalid = " + value);
	            } else {
	                LoggerUtil.fail("Validation failed! Shadow text still visible. aria-invalid = " + value);
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Failed to fetch or validate 'aria-invalid' attribute: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected exception in validateShadowTextInvisible: " + e.getMessage());
	    }
	}

   	 public void validateShadowTextVisible1(By ele) throws InterruptedException {
   	 clickOnElement(ele);
   	 pressBackSpace();
   	 pressBackSpace();
   	 pressBackSpace();
   	 pressBackSpace();
   	 Thread.sleep(2000);
   	 String value = waitForExpectedElement(ele).getDomAttribute("aria-invalid");
   	 boolean actualValue = Boolean.parseBoolean(value);
   	 Assert.assertTrue(actualValue);

   	 }
	
	public void UserCLickOhPCheckBox(String cname , String Ccode , String clocation) throws InterruptedException {
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(customername), cname);
		clearAndEnterText(waitForExpectedElement(customercode), Ccode);
		clearAndEnterText(waitForExpectedElement(customerlocation), clocation);
		clickOnElement(ohpcheckbox);
		Thread.sleep(3500);
		clickOnElement(ohpDataTableIncustomerpage);
		clickOnElement(savebuttoncustomerpage);
			
		
	}
	
	
	public void verifyingAllocationInOhp() throws InterruptedException {
		
		
	clickOnElement(clickviewbtnohptable);
	Thread.sleep(3000);
	clickOnElement(ClickEditBtnOnOhpTable);	
	
	WebElement searchcustomercode = driver.findElement(By.xpath("//input[@id=\"myInputCustomer\"]"));
	searchcustomercode.sendKeys("c001");
	WebElement customercodeischeckedornotInOhp = driver.findElement(By.xpath("//table[@id=\"rmCustomer\"]/tbody/tr[152]/td/input[@id=\"customerList_151__IsCheck\"]"));
	Assert.assertTrue(customercodeischeckedornotInOhp.isSelected());	
	}
	
	private static final By SelectRmTableList  =  By.xpath("(//table[@id='rmdatatable']/tbody/tr/td[2]/div/input[@id='rmdatackeched1'])[1]");	
	private static final By rmcheckbox1 = By.xpath("(//input[@id='RM'])[1]");
	private static final By commoditydetailstab = By.xpath("//div[@id=\"exTab3\"]//ul//li[3]//a[@href=\"#CommodityDetailTab\"]");
	private static final By viewbtnOncommoditydetailstab = By.xpath("//button[@onclick=\"comodityDetailList()\"]/i");
	private static final By searcboxincommoditydetails = By.xpath("//input[@id=\"myInputListSearch\"]");
	private static final By clickeditbtn = By.xpath("(//table[@id=\"comodityDetailListTable\"]/tbody/tr/td[2]/a/i)[1]");
	private static final By commoditydetailstabusinessSegDrop = By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/button/span");
	private static final By SearchbusinessSegnameincommodityDrop = By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/div/input");
	public void verifyUserEnterThevalueForRmAllocation(String cname , String Ccode , String clocation,String searchcommoditydetails) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(customername), cname);
		clearAndEnterText(waitForExpectedElement(customercode), Ccode);
		clearAndEnterText(waitForExpectedElement(customerlocation), clocation);	
		

		clickOnElement(businnessdomaidropdown);
		
		clearAndEnterText(waitForExpectedElement(businessDomainSearch), "rishi");
		
		clickOnElement(businessDomainCheckBox);

		clickOnElement(businesssegmentdropdown);

		clearAndEnterText(waitForExpectedElement(businesSegmentSearch), "sachindra1");

		clickOnElement(businessSegmentCheckBox);
		
		clickOnElement(rmcheckbox1);
		Thread.sleep(3000);
		clickOnElement(SelectRmTableList);
		
		clickOnElement(savebuttoncustomerpage);
		Thread.sleep(3000);
		
		dashboard.clickoncommodityMaster();
		
		Thread.sleep(7000);
		
		clickOnElement(commoditydatailstab);
		
		clickOnElement(viewbtnOncommoditydetailstab);
		
		clearAndEnterText(waitForExpectedElement(searcboxincommoditydetails), searchcommoditydetails);
		Thread.sleep(6000);
		
		clickOnElement(clickeditbtn);
		Thread.sleep(4000);
		
		clickOnElement(commoditydetailstabusinessSegDrop);

		clearAndEnterText(waitForExpectedElement(SearchbusinessSegnameincommodityDrop), "sachindra1");
		Thread.sleep(4000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Try clicking the dropdown safely
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//button[contains(@class, 'multiselect-option')]")));

		try {
		    dropdown.click();
		} catch (ElementNotInteractableException e) {
		    // Use JS Click if normal click fails
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", dropdown);
		}

		// Step 2: Wait for the checkbox to appear
		WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.xpath("//input[@type='checkbox' and @value='8497']")));

		// Step 3: Validate checkbox state
		boolean isChecked = checkbox.isSelected();
		System.out.println("Checkbox selected: " + isChecked);

		// Step 4: Assert if needed
		Assert.assertTrue(isChecked, "Expected checkbox to be selected");

		
		
		
		
	}
	
	
	public void Savewithoutcustomercode(String custname,String custlocation,String message) {
		
		
		clearAndEnterText(waitForExpectedElement(customername), custname);
		clearAndEnterText(waitForExpectedElement(customerlocation), custlocation);
		clickOnElement(savebuttoncustomerpage);
		Assert.assertTrue(waitForExpectedElement(toastmessageoncustomerpage).getText().contains(message));
		
		
		
		
		
		
	}
	
	
	public void SaveWithoutCustomerName(String custcode , String custlocation,String message) {
		
		clearAndEnterText(waitForExpectedElement(customercode), custcode);
		clearAndEnterText(waitForExpectedElement(customerlocation), custlocation);
		clickOnElement(savebuttoncustomerpage);
		Assert.assertTrue(waitForExpectedElement(toastmessageoncustomerpage).getText().contains(message));
		
		
		
		
	}
	
	
	public void savewithoutcustomerlocation(String custcode,String custname,String message) {
		
		clearAndEnterText(waitForExpectedElement(customercode), custcode);
		clearAndEnterText(waitForExpectedElement(customername), custname);
		clickOnElement(savebuttoncustomerpage);
		Assert.assertTrue(waitForExpectedElement(toastmessageoncustomerpage).getText().contains(message));
		
		
		
	}
	
	private static final By custgst = By.xpath("//input[@id=\"GSt\"]");
	
	public void saveDataWithoutValidGSTNumber(String custcode , String custname, String custlocation, String Custgst, String message) {
		
		clearAndEnterText(waitForExpectedElement(customercode), custcode);
	
		clearAndEnterText(waitForExpectedElement(customername), custname);
		
		clearAndEnterText(waitForExpectedElement(customerlocation), custlocation);
		
		clearAndEnterText(waitForExpectedElement(custgst), Custgst);
		
		clickOnElement(savebuttoncustomerpage);
		
		Assert.assertTrue(waitForExpectedElement(toastmessageoncustomerpage).getText().contains(message));
		
	}
	
	
	private static final By selectstatedropdown = By.xpath("//select[@id='State']");
	public void selectstatedropdown(String value) {
		
	clickOnElement(selectstatedropdown);	
	selectDropDownValue(selectstatedropdown, value, "selectValue");
		
		
		
		
	}
	private static final  By editbtn  = By.xpath("//table[@id='businessdomainSegmentsTable']/tbody/tr/td[4]/a/i");
	
	
	
	public void clickeditbtnandupdatecategorynameandcategorytype(String catname) {
		
		clickOnElement(BusinessDomainSegmenttab);
		
		clickOnElement(editbtn);
		
		clearAndEnterText(waitForExpectedElement(entercategorynamevalues), catname);
		
		clickOnElement(savebtn);
		
	
	}
	private static By commoditydetailstabbusinessSegDrop = By.xpath("(//button[@data-toggle='dropdown'])[3]");
	private static By businessSegDomainSearchBar = By.xpath("//input[@class=\"multiselect-search form-control\"]");
	private static By dropdownvalueinbusinessSegmentcommodity = By
			.xpath("(//button[@class='multiselect-option dropdown-item']//span/label['categorytype'])[1]");
	
    public void verifybusinessSegmentDropdownInCommodityDetailsTab(String businessSegvalue) throws InterruptedException {
    	
    	clickOnElement(commoditydatailstab);
    	Thread.sleep(3000);
    	clickOnElement(commoditydetailstabbusinessSegDrop);
    	Thread.sleep(4000);
    	clearAndEnterText(waitForExpectedElement(businessSegDomainSearchBar), businessSegvalue);
    	
    	Assert.assertEquals("categorytype", "categorytype");
    	
    	
    	
    }
     public static final By businessSegmentDropdown = By.xpath("//button[contains(@class,'dropdown-toggle') and contains(@title, 'None selected')]");

    private static By businessSegSearchBar = By.xpath("//div[contains(@class,'multiselect-container')]//input[@type='search' and contains(@class,'form-control')]");

    private static By dropdownvalueinbusinessSegmentprocess = By
			.xpath("(//button[@class='multiselect-option dropdown-item']//span/label['categorytype'])[1]");
	
	public void verifybusinessSegmentDropdownInProcessMaster(String segvalue) throws InterruptedException {
		
         clickOnElement( businessSegmentDropdown );
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(businessSegSearchBar), segvalue);
		Thread.sleep(3000);
		Assert.assertEquals("categorytype", "categorytype");
		
		
	}
	
	public static final By resetbtncustomerpage = By.xpath("//*[@id=\"frm_customercreation\"]/div[2]/button[4]"); 
	
	public void verifyUserClickResetButton(String custcode, String custname, String custloca) {
	    // Step 1: Enter initial values
	    clearAndEnterText(waitForExpectedElement(customercode), custcode);
	    clearAndEnterText(waitForExpectedElement(customername), custname);
	    clearAndEnterText(waitForExpectedElement(customerlocation), custloca);

	    // Step 2: Click Reset button
	    clickOnElement(resetbtncustomerpage);

	    // Step 3: Verify fields are cleared
	    String actualCustCode = waitForExpectedElement(customercode).getAttribute("value");
	    String actualCustName = waitForExpectedElement(customername).getAttribute("value");
	    String actualCustLoc = waitForExpectedElement(customerlocation).getAttribute("value");

	    Assert.assertEquals(actualCustCode, "", "Customer Code field not cleared");
	    Assert.assertEquals(actualCustName, "", "Customer Name field not cleared");
	    Assert.assertEquals(actualCustLoc, "", "Customer Location field not cleared");
	}

	
	
	 public static final By businessDomainDropdown = By.xpath("(//button[contains(@title,'None selected')])[1]");
	    public static final By businessSegmentDropdown1 = By.xpath("(//button[contains(@title,'None selected')])[2]");
	    public static final By stateDropdown = By.xpath("//select[@id='State']");

	    // ------------------- Methods ----------------------

	    public void verifyDropdownPlaceholderText(By locator, String expectedPlaceholder, String dropdownName) {
	        String actualPlaceholder = waitForExpectedElement(locator).getText().trim();
	        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
	                "Placeholder mismatch for: " + dropdownName);
	    }

	    public void verifyStateDropdownPlaceholder1(String expectedPlaceholder) {
	        Select select = new Select(waitForExpectedElement(stateDropdown));
	        String actualText = select.getFirstSelectedOption().getText().trim();
	        Assert.assertEquals(actualText, expectedPlaceholder, "Placeholder mismatch for State dropdown");
	    }

	    
	    public static final By categoryTypeDropdown = By.id("Type");

	    public String getCategoryDropdownDefaultValue() {
	        clickOnElement(BusinessDomainSegmenttab);
	        WebElement dropdownElement = driver.findElement(categoryTypeDropdown);
	        Select dropdown = new Select(dropdownElement);
	        return dropdown.getFirstSelectedOption().getText().trim();
	    }

	    public boolean isDefaultValueSelect() {
	        String defaultText = getCategoryDropdownDefaultValue();
	        return defaultText.equalsIgnoreCase("Select");
	    }
	    
	    
	    public static final By categoryNameTextbox = By.id("Name");

	    public void verifyTextboxPlaceholderText(By locator, String expectedPlaceholder, String fieldName) {
	    clickOnElement(BusinessDomainSegmenttab);
	        WebElement element = driver.findElement(locator);
	        String actualPlaceholder = element.getAttribute("placeholder").trim();

	        LoggerUtil.info("Verifying placeholder for '" + fieldName + "' textbox: Expected = '" + expectedPlaceholder + "', Actual = '" + actualPlaceholder + "'");
	        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, fieldName + " textbox placeholder mismatch.");
	    }

	    public void clickeditbtnandupdatecategorynameandcategorytype1( String updatedName) throws InterruptedException {
	    	clickOnElement(BusinessDomainSegmenttab);
	        WebElement editBtn = driver.findElement(By.xpath("//table[@id='businessdomainSegmentsTable']/tbody/tr[2]/td[4]/a[1]/i"));
	        editBtn.click();
	        Thread.sleep(2000);

	        WebElement nameField = driver.findElement(By.xpath("//input[@id=\"Name\"]"));
	        nameField.clear();
	        nameField.sendKeys(updatedName);

	        driver.findElement(By.xpath("//*[@id=\"saveBusinessDomainSegments\"]")).click();
	    }
        public static final By validatevalue = By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/button[60]/span/label");   
	    public static final By commoditydetailstab1 = By.xpath("//*[@id=\"exTab3\"]/ul/li[3]/a");
	    public static final By searchvalueinbusinessSegDropdown = By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/div/input");
	    public void verifybusinessSegmentDropdownInCommodityDetailsTab1(String expectedValue) throws InterruptedException {
	        LoggerUtil.info("Navigating to 'Commodity Details' tab.");
	        clickOnElement(commoditydetailstab1);
	        Thread.sleep(3000);

	        LoggerUtil.info("Clicking on the Business Segment dropdown.");
	        WebElement dropdownBtn = driver.findElement(By.xpath("//*[@id=\"partAttributeDiv\"]/div[2]/div[1]/div[2]/span/div/div/button/span"));
	        dropdownBtn.click();
	        Thread.sleep(1000);

	        LoggerUtil.info("Typing into search field inside dropdown.");
	        WebElement searchInput = waitForExpectedElement(searchvalueinbusinessSegDropdown);
	        clearAndEnterText(searchInput, expectedValue);
	        Thread.sleep(2000);

	        LoggerUtil.info("Fetching matching dropdown values to validate.");
	        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span/label"));

//	        boolean matchFound = dropdownOptions.stream()
//	            .anyMatch(option -> option.getText().trim().equalsIgnoreCase(expectedValue));
//
//	        Assert.assertTrue(matchFound, "Expected value '" + expectedValue + "' not found in Business Segment dropdown.");
	    }

	    public static final By searchvalue = By.xpath("//*[@id='businessdomainSegmentsTable_filter']/label/input");

	   public void SearchBusinessSegValue(String searchvalueseg) {
		   
		   clearAndEnterText(waitForExpectedElement(searchvalue), searchvalueseg);
		   
		   

	   }
	    
		public void searchBusinessDomvalue(String searchvaluedom) throws InterruptedException {
			
			Thread.sleep(4000);
			
			clearAndEnterText(waitForExpectedElement(searchvalue),searchvaluedom);
			
		}
		
		
		
		public static final By customerCodeInput = By.xpath("//input[@id='CustomerCode']");

		public void verifyCustomerCodePlaceholder(String expectedPlaceholder) {
		    WebElement inputField = waitForExpectedElement(customerCodeInput);
			String actualPlaceholder = inputField.getAttribute("placeholder").trim();

			LoggerUtil.info("Verifying placeholder for 'Customer Code' field. Expected: '" + expectedPlaceholder + "', Actual: '" + actualPlaceholder + "'");
			Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Mismatch in Customer Code placeholder.");
		}
		
		
		 public String getBusinessDomainDefaultValueInCustomer() {
		       
		        WebElement dropdownDisplayed = driver.findElement(businessDomainDropdown);
		        return dropdownDisplayed.getText().trim();
		    }

		    // Validate if default value is "Select"
		    public boolean isBusinessDomainDefaultValueSelectInCustomer() {
		        String defaultText = getBusinessDomainDefaultValueInCustomer();
		        return defaultText.equalsIgnoreCase("None Selected") ;
		    }
		    
		    
		    public static final By searchvaluincustomerpage = By.xpath("(//input[@type='search'])[3]");
		    public static final By deletebtncustpage = By.xpath("//table[@id='example1']/tbody/tr/td[7]/a[2]/span/i");
		
		public void deletebutton(String code ,String name, String location ,String searchcustomervalue) throws InterruptedException {
			
			clearAndEnterText(waitForExpectedElement(customercode), code);
			clearAndEnterText(waitForExpectedElement(customername), name);
			clearAndEnterText(waitForExpectedElement(customerlocation),location);
			clickOnElement(savebuttoncustomerpage);
			Thread.sleep(4000);
			clearAndEnterText(waitForExpectedElement(searchvaluincustomerpage), searchcustomervalue);
			
			Thread.sleep(3000);
			clickOnElement(deletebtncustpage);
			
		}
		    public static final By clickeditforupdate = By.xpath("//table[@id='example1']/tbody/tr/td[7]/a/span/i");
		    public static final By update = By.xpath("//button[@id='btnUpdate']");
		    public void updatebtn(String custucode,String custuname,String message) throws InterruptedException {
		    	
		    clickOnElement(clickeditforupdate);	
		    Thread.sleep(3000);
		    clearAndEnterText(waitForExpectedElement(customercode), custucode);
		    clearAndEnterText(waitForExpectedElement(customername),custuname);
		    	Thread.sleep(4000);
		    	clickOnElement(update);
		    	Assert.assertTrue(waitForExpectedElement(toastmessageoncustomerpage).getText().contains(message));
		    	
		    	
		    	
		    }
		    public static final By toastmessage = By.xpath("//div[@class='toast-message']");
		    public static final By Duplicatetoastmessage = By.xpath("//div[@class='toast-message']");
		    public static final By clickeditforSaveasnew = By.xpath("//table[@id='example1']/tbody/tr/td[7]/a/span/i");
		    public static final By saveasnewbtn = By.xpath("//button[@id='btnSaveAsNew']");
		    public void clickSaveAsNewbtn(String message) throws InterruptedException {

		    clickOnElement(clickeditforSaveasnew);
		    Thread.sleep(4000);
		    clickOnElement(saveasnewbtn);
		    LoggerUtil.info("The PopUp Message = Customer Profiles already exist ");
		    Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));

		    }
		    public static final By deletedata = By.xpath("//*[@id='example1']/tbody/tr[23]/td[7]/a[2]/span/i");
		    public void deletecostingdata(String message) throws InterruptedException {
		    clickOnElement(deletedata);
		    Thread.sleep(4000);
		    driver.switchTo().alert().accept();
		    Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
		    }
		    public static final By thirddropdownvalue = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button[2]/span/input");
		    public void duplicateentrry() throws InterruptedException {
		    clickOnElement(By.xpath("//button[@data-target='#exportModalForCustomers']"));
		    // clickOnElement(exportmasterallocationnewsupplire);
		    // Thread.sleep(4000);
		    // clickOnElement(clickyearlycheckboxwhileExportingnewData);
		    // Thread.sleep(4000);
		    // clickOnElement(clickfirstDropdownwhileExpoertingnewfile);
		    // clearAndEnterText(waitForExpectedElement(entervalueinfirstdropdown), "CRCA-007");
		    // clickOnElement(clickfirstvalueindropdown);
		    // clickOnElement(clicksecondDropdownwhileExportingNewfile);
		    // clearAndEnterText(waitForExpectedElement(searchvalueforsecoddropdown), "Process-1");
		    // clickOnElement(clickseconddropdownvalue);
		    // Thread.sleep(2000);
		    // clickOnElement(thirddropdownvalue);
		    // Thread.sleep(2000);
		    // clickOnElement(exportbtn);
		    // Thread.sleep(4000);
		    // fillCustomerSheet();
		    // Thread.sleep(4000);
		    // importNewCustomerMasterExcel();
		    Thread.sleep(5000);
		    importNewCustomerMasterDuplicateExcel();
		    }
		    public void importNewCustomerMasterDuplicateExcel() throws InterruptedException {
		    String fullPath = System.getProperty("user.dir") + "/downloads/CustomerMaster_23-04-2025_09_24_12.xlsx";

		    WebElement fileInput = driver.findElement(By.id("excelUploadNew"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
		    fileInput.sendKeys(fullPath);

		    }
		   
		    public static final By exportsecondbtn = By.xpath("//button[@onclick='ExportNewAddition()']");
		    public void expxortfile() throws InterruptedException {
		    	Thread.sleep(3000);
		    clickOnElement(By.xpath("//button[@data-target='#exportModalForCustomers']"));
		    clickOnElement(exportsecondbtn);
		    Thread.sleep(5000);
		    //clickOnElement(customercodeheader);
		    // Thread.sleep(3000);
		    // clickOnElement(customercodeheader);
		    //
		    }
		    public static final By customercodelist = By.xpath("//table[@id='example1']/tbody/tr/td[2]");
		    public static List<String> readCustomerCodeFromExcel(File file, int columnIndex, int startRow) throws IOException {

		    List<String> customerCode = new ArrayList<>();

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

		    customerCode.add(cell.toString().trim());

		    count++;

		    }

		    }
		    workbook.close();

		    fis.close();

		    return customerCode;
		    }

		    public List<String> fetchCustomerList() {

		    List<WebElement> customercodeElements = driver.findElements(customercodelist);

		    List<String> uiData = new ArrayList<>();

		    for (WebElement ele : customercodeElements) {

		    uiData.add(ele.getText().trim());

		    }

		    return uiData;

		    }

		    public static List<String> getSortedCustomerCodes(String filePath) {
		    List<String> customerCodes = new ArrayList<>();

		    try (FileInputStream fis = new FileInputStream(filePath)) {
		    Workbook workbook = new XSSFWorkbook(fis);
		    Sheet sheet = workbook.getSheetAt(0); // First sheet
		    int customerColIndex = -1;
		    Row headerRow = null;

		    // Try first few rows to find header
		    for (int rowIndex = 0; rowIndex <= 5; rowIndex++) {
		    Row row = sheet.getRow(rowIndex);
		    if (row != null) {
		    for (Cell cell : row) {
		    if (cell.getCellType() == CellType.STRING) {
		    String header = cell.getStringCellValue().trim();
		    if (header.equalsIgnoreCase("Customer Code")) { // Fix: match ignoring case and spaces
		    customerColIndex = cell.getColumnIndex();
		    headerRow = row;
		    break;
		    }
		    }
		    }
		    }
		    if (customerColIndex != -1) break; // Stop if found
		    }

		    if (customerColIndex == -1) {
		    throw new RuntimeException("Customer Code column not found in the first 5 rows!");
		    }

		    // Extract values
		    int startRow = headerRow.getRowNum() + 1;
		    for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
		    Row row = sheet.getRow(i);
		    if (row != null) {
		    Cell cell = row.getCell(customerColIndex);
		    if (cell != null && cell.getCellType() == CellType.STRING) {
		    String value = cell.getStringCellValue().trim();
		    if (!value.isEmpty()) {
		    customerCodes.add(value);
		    }
		    }
		    }
		    }

		    Collections.sort(customerCodes); // Sort alphabetically
		    } catch (Exception e) {
		    e.printStackTrace();
		    throw new RuntimeException("Error while reading or processing the Excel file.", e);
		    }
		    return customerCodes;
		    }
		    public static final By rmcheckboxes = By.xpath("//*[@id='RM']");
		    public static final By editbtnforcheckbox = By.xpath("//*[@id='example1']/tbody/tr/td[7]/a[1]/span/i");
		    public void checkbox(String searchval) {
		    clearAndEnterText(waitForExpectedElement(searchboxincustomerpage), searchval);
		    clickOnElement(editbtnforcheckbox);
		    // Wait for checkbox to be visible
		    WebElement checkbox = waitForExpectedElement(rmcheckboxes);

		    // Check if checkbox is selected or not
		    boolean isSelectedBefore = checkbox.isSelected();
		    // Optional: If you are expecting it to be clicked programmatically after edit, wait a bit
		    try {
		    Thread.sleep(1000); // or use a proper wait if dynamic
		    } catch (InterruptedException e) {
		    e.printStackTrace();
		    }

		    boolean isSelectedAfter = checkbox.isSelected();

		    if (isSelectedAfter && !isSelectedBefore) {
		    System.out.println("Checkbox was clicked after edit.");
		    } else if (!isSelectedAfter && isSelectedBefore) {
		    System.out.println("Checkbox was unclicked after edit.");
		    } else if (isSelectedAfter) {
		    System.out.println("Checkbox was already selected.");
		    } else {
		    System.out.println("Checkbox was not clicked.");
		    }
		    }

		     public static final By searchbarinbusinessdomainSeg = By.xpath("//div[@id='businessdomainSegmentsTable_filter']//label/input[@type='search']");
		    public void createNewEntryOfBusinessDomain(String categoryname, String message,String businessSegValue) throws InterruptedException {

				clickOnElement(BusinessDomainSegmenttab);
				Thread.sleep(3000);
				selectdropdownbusinessDomainSegmenttab("2");
				Thread.sleep(4000);
				clearAndEnterText(waitForExpectedElement(entercategorynamevalues), categoryname);
				clickOnElement(savebtn);
				Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
				Thread.sleep(3000);
				clearAndEnterText(waitForExpectedElement(searchbarinbusinessdomainSeg), businessSegValue);
				Thread.sleep(4000);
				
				

			}
		    
		    
		    public void VerifyCheckSavePrompt(String cucode, String clocation, String cname) {
		        // Enter values in fields
		        clearAndEnterText(waitForExpectedElement(customercode), cucode);
		        clearAndEnterText(waitForExpectedElement(customerlocation), clocation);
		        clearAndEnterText(waitForExpectedElement(customername), cname);

		        // Click save
		        clickOnElement(savebuttoncustomerpage);

		        // Wait for toast presence in DOM (whether visible or not)
		       

		    }
		    public static final By clickOnCreateNewCustomerPlusButtonSaveBT=By.xpath("(//button[@id='customerSave']//i)[1]");
		    public void VerifyCustomerMasterPlusButtonCreateNewCustomerPage(String cucode, String clocation, String cname) {
		        // Enter values in fields
		        clearAndEnterText(waitForExpectedElement(customercode), cucode);
		        clearAndEnterText(waitForExpectedElement(customerlocation), clocation);
		        clearAndEnterText(waitForExpectedElement(customername), cname);

		        // Click save
		        clickOnElement(clickOnCreateNewCustomerPlusButtonSaveBT);

		        // Wait for toast presence in DOM (whether visible or not)
		       

		    }
		    public void addedNewCustomer(String cucode, String clocation, String cname) {
		    	VerifyCustomerMasterPlusButtonCreateNewCustomerPage(cucode, clocation, cname);
		    }

}

