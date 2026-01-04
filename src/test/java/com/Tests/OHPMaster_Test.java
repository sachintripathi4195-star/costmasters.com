package com.Tests;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.OHPMaster_PageClass;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;

@Listeners(com.helper.TestListeners.class)
public class OHPMaster_Test extends Base {

	LoginPage login;
	OHPMaster_PageClass ohp;
	DashboardPage dashboard;
	Faker faker = new Faker();

	@BeforeGroups(groups = { "group1", "group2", "group3", "group4" })
	public void LoginApplication() {

		launchApplication();
		login = new LoginPage();
		ohp = new OHPMaster_PageClass();
		dashboard = new DashboardPage();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterGroups(groups = { "group1", "group2", "group3", "group4" })
	public void ClosedApplication() {

		driver.quit();

	}

	@Test(priority = 1, groups = "group1")
	public void TC_OHP_01_OpeningOfOhpMaster() throws InterruptedException {

		dashboard.clickingDashboard("");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(4000);
		dashboard.VerifyClickingMasterOptions("OHP");
		QuickMasterPage.VerifyTitlePageOfOhpMaster("OHP");

	}

	@Test(priority = 2, groups = "group1")
	public void TC_OHP_02AdditionOfOhNorm() throws InterruptedException {

		String prefixname = faker.name().firstName() + faker.letterify("????????");
		String RejectionRmCell = faker.number().digits(2);
		String RmPcCellForOverhead = faker.number().digits(2);
		String RmForIccCell = faker.number().digits(2);
		String BopForProfitCell = faker.number().digits(2);
		dashboard.clickingDashboard("");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(4000);
		dashboard.VerifyClickingMasterOptions("OHP");

		ohp.EnteringValueForAdditionOfNorms(prefixname, "Rejection", "RM", RejectionRmCell, "Overhead",
				"RM + Process cost", RmPcCellForOverhead, "ICC", RmForIccCell, "Profit", "BOP", BopForProfitCell,
				"Ferrous Casting", "Forging", "Non Ferrous Casting", "rishi", "Mk-2208-7-Mohali");
	}

	@Test(priority = 3, groups = "group1")
	public void TC_OHP_04UpdateOhp() throws InterruptedException {

	    String prefixname = faker.name().firstName() + faker.letterify("????????");
	    String RejectionRmCell = faker.number().digits(2);
	    String RmPcCellForOverhead = faker.number().digits(2);
	    String RmForIccCell = faker.number().digits(2);
	    String BopForProfitCell = faker.number().digits(2);

	    dashboard.clickingDashboard("");
	    Thread.sleep(3000);
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(4000);
	    dashboard.VerifyClickingMasterOptions("OHP");

	    ohp.EnteringValueForAdditionOfNorms(
	            prefixname, 
	            "Rejection", "RM", RejectionRmCell, 
	            "Overhead", "RM + Process cost", RmPcCellForOverhead, 
	            "ICC", RmForIccCell, 
	            "Profit", "BOP", BopForProfitCell,
	            "Ferrous Casting", "Forging", "Non Ferrous Casting", 
	            "rishi", "Mk-2208-7-Mohali"
	    );

	    ohp.VerifyUpdatedValueOnPrefix(
	            prefixname,                  // prefix value
	            "rishi",                     // business segment
	            "Mk-2208-7-Mohali",          // customer name
	            "Rejection", "RM", RejectionRmCell,  // rejection row-col-val
	            "Overhead", "RM + Process cost", RmPcCellForOverhead, // overhead row-col-val
	            "ICC", RmForIccCell,         // icc row-val
	            "Profit", "BOP", BopForProfitCell   // profit row-col-val
	    );
	}

	
	@Test(priority=4,groups="group1")
	public void TC_OHP_05SaveAsNewOhp() throws InterruptedException {
		
		String EnterNewPrefixForSaveAsNew = faker.name().firstName()+faker.letterify("??????");
		String prefixname = faker.name().firstName() + faker.letterify("????????");
		String RejectionRmCell = faker.number().digits(2);
		String RmPcCellForOverhead = faker.number().digits(2);
		String RmForIccCell = faker.number().digits(2);
		String BopForProfitCell = faker.number().digits(2);
		dashboard.clickingDashboard("");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(4000);
		dashboard.VerifyClickingMasterOptions("OHP");

		ohp.EnteringValueForAdditionOfNorms(prefixname, "Rejection", "RM", RejectionRmCell, "Overhead",
				"RM + Process cost", RmPcCellForOverhead, "ICC", RmForIccCell, "Profit", "BOP", BopForProfitCell,
				"Ferrous Casting", "Forging", "Non Ferrous Casting", "rishi", "Mk-2208-7-Mohali");	
		
		
		 ohp.VerifySaveAsNewValueOnPrefix(
				 EnterNewPrefixForSaveAsNew,
		                         
		            "rishi",                     
		            "Mk-2208-7-Mohali",          
		            "Rejection", "RM", RejectionRmCell, 
		            "Overhead", "RM + Process cost", RmPcCellForOverhead, 
		            "ICC", RmForIccCell,         
		            "Profit", "BOP", BopForProfitCell   
		    );
		
		
	}
	
	
	@Test(priority=5,groups="group1")
	public void TC_OHP_06SaveOhpWithCascadingFactors() throws InterruptedException {
		

		String cascadingforprofitoverhead = faker.number().digits(2);
		String cascadingForIccAndPacking = faker.number().digits(2);
		String prefixname = faker.name().firstName() + faker.letterify("????????");
		String RejectionRmCell = faker.number().digits(2);
		String RmPcCellForOverhead = faker.number().digits(2);
		String RmForIccCell = faker.number().digits(2);
		String BopForProfitCell = faker.number().digits(2);
		dashboard.clickingDashboard("");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(4000);
		dashboard.VerifyClickingMasterOptions("OHP");

		ohp.EnteringValueForSavingCasCadingValues(prefixname, "Rejection", "RM", RejectionRmCell, "Overhead",
				"RM + Process cost", RmPcCellForOverhead, "ICC", RmForIccCell, "Profit", "BOP", BopForProfitCell,
				"Ferrous Casting", "Forging", "Non Ferrous Casting", "rishi", "Mk-2208-7-Mohali","Profit","Overhead",cascadingforprofitoverhead,"ICC","Packing",cascadingForIccAndPacking);
		
		
		
		
		
		
	}
	
	
	
	
	
	@Test(priority = 7, groups = "group1")
	public void TC_OHP_08ExistingDataValidationInExport() throws InterruptedException {
	  
		
	    dashboard.clickingDashboard("");
	    Thread.sleep(3000);
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(4000);
	    dashboard.VerifyClickingMasterOptions("OHP");

	   
	    int maxEntries = ohp.getMaxEntriesFromTable();
	    LoggerUtil.info("Fetched maximum entries from UI table: " + maxEntries);

	    
	    clickOnElement(OHPMaster_PageClass.clickingBackButtonViewPage);
	    LoggerUtil.info("Clicked Back button on View Page");
	    Thread.sleep(2000);

	    clickOnElement(OHPMaster_PageClass.clickingExportAndImportBtnFirstStepBtn);
	    LoggerUtil.info("Clicked Export/Import main button");

	    clickOnElement(OHPMaster_PageClass.clickingExportForDownload);
	    LoggerUtil.info("Clicked Export button for download");

	   
			String exportFile = getLatestOHPFile();
		


	
	    LoggerUtil.pass("Latest OHP export file downloaded: " + exportFile);

	   
	    int rowCount = ExcelUtil.getLastNonEmptyRowOnlyOHPMasterFile(exportFile);
	    LoggerUtil.info("Row count fetched from Excel file: " + rowCount);

	   
	    if (rowCount == maxEntries) {
	        LoggerUtil.pass("Export validation success → UI rows = " + maxEntries + ", Excel rows = " + rowCount);
	    } else {
	        LoggerUtil.mismatch("Export validation mismatch → UI rows = " + maxEntries + ", Excel rows = " + rowCount);
	    }
	}

	
	//@Test(priority=8,groups="group1")
	public void TC_OHP_09NewDataAdditionTemplateValidation() throws InterruptedException {
		
		 dashboard.clickingDashboard("");
		    Thread.sleep(3000);
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(4000);
		    dashboard.VerifyClickingMasterOptions("OHP");

		ohp.VerifyExportAndReadExcelData();
		
		
	}
	
	@Test(priority=9,groups="group1")
	public void TC_OHP_010ResetButton() throws InterruptedException, TimeoutException {
		String prefixname = faker.name().firstName() + faker.letterify("????????");
		String RejectionRmCell = faker.number().digits(2);
		String RmPcCellForOverhead = faker.number().digits(2);
		String RmForIccCell = faker.number().digits(2);
		String BopForProfitCell = faker.number().digits(2);
		
		 dashboard.clickingDashboard("");
		    Thread.sleep(3000);
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(4000);
		    dashboard.VerifyClickingMasterOptions("OHP");	
		    ohp.VerifyResetButtonFuntionality(prefixname, "Rejection", "RM", RejectionRmCell, "Overhead",
					"RM + Process cost", RmPcCellForOverhead, "ICC", RmForIccCell, "Profit", "BOP", BopForProfitCell,
					"Ferrous Casting", "Forging", "Non Ferrous Casting", "rishi", "Mk-2208-7-Mohali");
		
	}
	
	
	@Test(priority=10,groups="group1")
	public void TC_OHP_011DeleteOhpWithRependantRecord() throws InterruptedException {
		
		 dashboard.clickingDashboard("");
		    Thread.sleep(3000);
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(4000);
		    dashboard.VerifyClickingMasterOptions("OHP");	
		     ohp.VerifyDeleteDependentData("jk ohp");
		     
		
		
	}
	
	@Test(priority=11,groups="group1")
	public void TC_OHP_012DeleteOhpWithoutDependantRecord() throws InterruptedException {
		
		
		String prefixname = faker.name().firstName() + faker.letterify("????????");
		String RejectionRmCell = faker.number().digits(2);
		String RmPcCellForOverhead = faker.number().digits(2);
		String RmForIccCell = faker.number().digits(2);
		String BopForProfitCell = faker.number().digits(2);
		dashboard.clickingDashboard("");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(4000);
		dashboard.VerifyClickingMasterOptions("OHP");

		ohp.EnteringValueForAdditionOfNorms(prefixname, "Rejection", "RM", RejectionRmCell, "Overhead",
				"RM + Process cost", RmPcCellForOverhead, "ICC", RmForIccCell, "Profit", "BOP", BopForProfitCell,
				"Ferrous Casting", "Forging", "Non Ferrous Casting", "rishi", "Mk-2208-7-Mohali");
		
		ohp.DeleteRandomData(prefixname);
		
	}
	
	
	
	
	
	
	
}
