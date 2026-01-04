package com.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.PartMasterPage;
import com.Pages.ProductModelPage;
import com.Pages.SupplierMasterPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class PartMasterTest extends Base{

	LoginPage login;
	DashboardPage dashboard;
	public PartMasterPage part;

	Faker faker;
	String randomname;
	String randomname1;
	String randomname2;
	String randomname3;
	int randomnumber;

	@BeforeTest
	public void generator() {
		faker = new Faker();
		randomname = faker.name().firstName();
		randomname1 = faker.name().firstName();
		randomname2 = faker.name().firstName();
		randomnumber = faker.number().numberBetween(4, 6);
		randomname3 = faker.name().firstName();
	}

	@BeforeGroups(groups = { "group1", "group2", "group3", "group4" })
	public void setup() throws InterruptedException {

		launchApplication();
		login = new LoginPage();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
//		dashboard = new DashboardPage();
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.clickOnPartMaster();
//		Thread.sleep(1000);
	}
	
	@AfterGroups(groups = { "group1", "group2", "group3", "group4" })
	public void quit() {

		driver.quit();

	}
	
	@Test(priority=1,groups="group1")
	public void verifyPM_TC_001AllblankFieldsShouldHavePlaceholderEnter() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyPlaceholderValue();
	}
	
	@Test(priority = 2,groups="group1")
	public void PM_TC_002VerifyHeaderNamesRelevance() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyHeaderNamesRelevance();
		//part.headersShouldAccuratelyReflectFieldPurpose(randomname);
	}

	@Test(priority = 3,groups="group1")
	public void PM_TC_003VerifyMandatoryFieldsValidation() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.enterOnCommanValuPartMasterText(randomname, " ", "CPN01", "HSNC01");
		part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
		part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
		part.partMasterSaveBtn();
		String act=part.verifyToastAlertMsg("Prompt message indicating mandatory fields required.");
		if(act.equalsIgnoreCase("Prompt message indicating mandatory fields required.")) {
			LoggerUtil.pass("alert pop displayed: "+act);	
		}else {
			LoggerUtil.error("alert pop displayed: "+act);
		}
		
	}
	
	@Test(priority = 4,groups="group1")
	public void PM_TC_004PartUOMDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.partUOMDropdownOptionsShouldBeAlphabeticallyOrdered();  //fail
	}

	@Test(priority = 5,groups="group1")
	public void PM_TC_004_01CompanyNameDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.companyNameDropdownOptionsShouldBeAlphabeticallyOrdered();  //pass
	}
	
	@Test(priority = 6,groups="group1")
	public void PM_TC_004_02CustomerDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.customerDropdownOptionsShouldBeAlphabeticallyOrdered();  //fail
	}
	
	@Test(priority = 7,groups="group1")
	public void PM_TC_004_03SupplierDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.supplierDropdownOptionsShouldBeAlphabeticallyOrdered();  //fail
	}
	
	@Test(priority = 8,groups="group1")
	public void PM_TC_004_04ProductCategoryDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.productCategoryDropdownOptionsShouldBeAlphabeticallyOrdered();   //fail
	}
	
	@Test(priority = 9,groups="group1")
	public void PM_TC_004_05ProductModelNameNoDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.ProductModelNameNoDropdownOptionsShouldBeAlphabeticallyOrdered();  //sunsay
	}
	
	@Test(priority = 10,groups="group1")
	public void PM_TC_004_06SpecialProductCategoryDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.specialProductCategoryDropdownOptionsShouldBeAlphabeticallyOrdered();   //pass
	}
	
	@Test(priority = 11,groups="group1")
	public void PM_TC_005PartUOMDropdownSearchFunctionality() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.partUOMDropdownOptionsSearchFunctionality("Rs.","Rs.");
	}
	
	@Test(priority = 12,groups="group1")
	public void PM_TC_005_01CompanyNameDropdownSearchFunctionality() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.companyNameDropdownSearchFunctionality("Testing-1-Mohali-18032024","Testing-1-Mohali-18032024");
	}
	
	@Test(priority = 13,groups="group1")
	public void PM_TC_005_02CustomerDropdownSearchFunctionality() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.customerDropdownSearchFunctionality("adiydtj","adiydtj");
	}
	
	@Test(priority = 14,groups="group1")
	public void PM_TC_005_03SupplierDropdownSearchFunctionality() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.supplierDropdownSearhFunctionality("0801-Celesta","0801-Celesta");
	}
	
	@Test(priority = 15,groups="group1")
	public void PM_TC_005_04ProductCategoryDropdownSearchFunctionality() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.productCategoryDropdownSearhFunctionality("17012024","17012024");
	}
	
	@Test(priority = 16,groups="group1")
	public void PM_TC_005_05SpecielProductCategoryDropdownSearchFunctionality() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.specielProductCategoryDropdownSearhFunctionality("12345","12345");
	}
	
	@Test(priority = 17,groups="group1")
	public void PM_TC_006_01VerifyCompanyNameMultipleDropdownSelection() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.companyNameDropdownVerifyMultipleDropdownSelectionTest("Costmaster-Mohali-007","Client Company-01-Mohali-21102024");
	}
	
	@Test(priority = 18,groups="group1")
	public void PM_TC_006_02VerifyCustomerMultipleDropdownSelection() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.customerDropdownVerifyMultipleDropdownSelectionTest("aatigrb","abkbijn");
	}
	
	@Test(priority = 19,groups="group1")
	public void PM_TC_007SavePartwithSpecialCharactersandNumbers() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.enterOnCommanValuPartMasterText("jhhjs43463$$&%&", "RT01Validation", "CPN01", "HSNC01");
	    part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
	    part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
	    part.partMasterSaveBtn();
		
	}
	
	@Test(priority = 20,groups="group1")
	public void PM_TC_008PartMasterMasterDataVerifyDefaultPlaceholderText() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.VerifyeachblankfieldplaceholdeDefaulttextEnterdisplayedcorrectly();
	}
	
	@Test(priority = 21,groups = "group1")
	public void PM_TC_009PartMasterMasterDataVerifyDropdownDefaultPlaceholderDropdowndefaulttextisSelectorNoneSelected() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.CheckeachdropdownsdefaultplaceholderDropdowndefaulttextisSelectorNoneSelected();

	}
	
	@Test(priority = 22,groups = "group1")
	public void PM_TC_010VerifyDropdownAlphabeticalonSaveScreen() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.partUOMDropdownOptionsShouldBeAlphabeticallyOrdered();
		part.companyNameDropdownOptionsShouldBeAlphabeticallyOrdered();
		part.customerDropdownOptionsShouldBeAlphabeticallyOrdered();
		part.supplierDropdownOptionsShouldBeAlphabeticallyOrdered();
		part.productCategoryDropdownOptionsShouldBeAlphabeticallyOrdered();
		part.ProductModelNameNoDropdownOptionsShouldBeAlphabeticallyOrdered();
		part.specialProductCategoryDropdownOptionsShouldBeAlphabeticallyOrdered();
	}
	
	@Test(priority = 23,groups = "group1")
	public void PM_TC_011PartMaster_MasterDataVerifyDynamicSearchinDropdowns() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyDropdownPartUOMOptionsAlphabeticalOrder("Rs.");
		Thread.sleep(3000);
		part.clicknormalforanywhere();
		part.verifyDropdownCompanyNameOptionsAlphabeticalOrder("Client Company-01-Mohali-21102024");
		part.verifyDropdownCustomerOptionsAlphabeticalOrder("aatigrb");
		part.verifyDropdownSuplierOptionsAlphabeticalOrder("0801-Celesta");
		part.verifyDropdownProductCategoryOptionsAlphabeticalOrder("17012024");
		part.verifyDropdownSpecielProductCategoryOptionsAlphabeticalOrder("12345");
	}
	
	@Test(priority = 24,groups = "group1")
	public void PM_TC_012PartMaster_MasterDataVerifyFieldsAcceptAlphanumericandSpecialCharacters() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.enterOnCommanValuPartMasterText("randomname1", randomname2, "CPN01", "HSNC01");
	    part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
	    part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
	    part.partMasterSaveBtn();

	}
	
	@Test(priority = 25,groups = "group1")
	public void PM_TC_013PartMaster_MasterDataVerifyLinkingMultipleCustomerPartNos() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.enterOnCommanValuPartMasterText("randomname1", randomname2, "CPN01", "HSNC01");
		part.selectOnCompanyValue(1);
		part.selectedOnCustomersValue(2);
		part.selectOnSupplierValueByText("0801-Abe");
		part.selectOnProductCategoryValueByText("FURNITURE");
		part.selectOnProductCategoryValueByText("Misc-2410456");
	    part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
	    part.partMasterSaveBtn();

	}
	
	@Test(priority = 26,groups = "group1")
	public void PM_TC_014PartMaster_MasterDataVerifyDefaultPartUOM() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.CheckthedefaultvalueinPartUOM();
	}
	
	@Test(priority = 27,groups = "group1")
	public void PM_TC_015PartMaster_MasterDataFetchPartUOMfromUnitMaster() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyNewlyaddedUOMshouldappearinPartUOMdropdown(randomname,randomname1);
		
	}
	
	@Test(priority = 28,groups = "group1")
	public void PM_TC_017PartMaster_MasterDataCompanyDropdownDataConcatenation() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyCompanynamecodeandlocationconcatenatedcorrectly();
	}
	
	@Test(priority = 29,groups = "group1")
	public void PM_TC_018PartMaster_MasterDataCompanyDropdownMultipleSelection() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.Selectmultiplecompaniesfromdropdown();
	}
	
	@Test(priority = 30,groups = "group1")
	public void PM_TC_019PartMaster_MasterDataFetchCustomerDatafromCustomerMaster() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyNewlyaddedcustomerappearscorrectlyindropdown(randomname, randomname1, randomname2);
		
	}
	
	@Test(priority = 31,groups = "group1")
	public void PM_TC_020PartMaster_MasterDataCustomerDropdownConcatenation() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.VerifycustomerdropdownCustomerNameCodeLocationconcatenatedcorrectly(randomname2, randomname1, randomname);
	}
	
	@Test(priority = 32,groups = "group1")
	public void PM_TC_021PartMaster_MasterDataAddCustomerfromPartMaster() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.verifyCustomeraddedviaPartMasterappearscorrectlyindropdownandCustomerMaster(randomname2, randomname1, randomname);
		part.VerifycustomerdropdownCustomerNameCodeLocationconcatenatedcorrectly(randomname2, randomname1, randomname);
	}
	
	@Test(priority = 33, groups = "group1")
	public void PM_TC_022PartMaster_MasterDataPasteCustomerDatafromExcel() throws Exception {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	   // dashboard.clickOnCustomerMasterData();
	   
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();

	    List<String> pasteData = part.readCustomerPasteStrings(
	    	    "src/test/resources/PartMasterTestData/CustomerMaster_26-08-2025_17_10_56.xlsx");

	    int limit = Math.min(5, pasteData.size());
	    for (int i = 0; i < limit; i++) {
	        part.pasteText(pasteData.get(i)); 
	    }
	    part.submitCustomerNameForAllModule();
	    part.verifyCustomersAppearAndAreSelectable();
//	    String ac=part.verifyCustomersAppearAndAreSelectable();
//	    String Expected="5 Selected";
//	   Assert.assertEquals(ac, Expected, "passed");
	}

//	@Test(priority = 32,groups = "group1")
//	public void PM_TC_023PartMaster_MasterDataCustomerAutoselectafterSubmit() throws InterruptedException, IOException {
//		dashboard = new DashboardPage();
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    dashboard.clickOnPartMaster();
//	    part = new PartMasterPage();
//	    part.clickOnCustomePasteIcon();
//
//	    List<String> pasteData = part.readCustomerPasteStrings(
//	        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\CustomerMaster_11-08-2025_10_07_33.xlsx");
//
//	    int limit = Math.min(2, pasteData.size());
//	    for (int i = 0; i < limit; i++) {
//	        part.pasteText(pasteData.get(i)); 
//	    }
//	    part.submitCustomerNameForAllModule();
//	}
	
	@Test(priority = 32, groups = "group1")
	public void PM_TC_023PartMaster_MasterDataCustomerAutoselectafterSubmit() throws Exception {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();

	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();

	    List<String> pasteData = part.readCustomerPasteStrings(
	        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\CustomerMaster_11-08-2025_10_07_33.xlsx"
	    );

	    int limit = Math.min(2, pasteData.size());
	    for (int i = 0; i < limit; i++) {
	        part.pasteText(pasteData.get(i));     // your existing paste into textarea
	    }
	    part.submitCustomerNameForAllModule();     // click Submit

	    // Validate auto-selection for the FIRST pasted line (adjust if your product selects “last” instead)
	    part.verifyCustomerAutoSelectedAfterSubmit(pasteData.get(0));
	}

	
	@Test(priority = 33,groups = "group1")
	public void PM_TC_024PartMaster_MasterDataCustomerVerifyCustomerCountinPopup() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();

	    List<String> pasteData = part.readCustomerPasteStrings(
	        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\CustomerMaster_11-08-2025_10_07_33.xlsx");

	    int limit = Math.min(2, pasteData.size());
	    for (int i = 0; i < limit; i++) {
	        part.pasteText(pasteData.get(i)); 
	    }
	    part.submitCustomerNameForAllModule();
	}
	
	@Test(priority = 33,groups = "group1")
	public void PM_TC_025PartMaster_MasterDataCustomerMissingCustomerWarning() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();

	    List<String> pasteData = part.readCustomerPasteStringsWrongs(
	        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\CustomerMaster_11-08-2025_10_07_33.xlsx");

	    int limit = Math.min(2, pasteData.size());
	    for (int i = 0; i < limit; i++) {
	        part.pasteText(pasteData.get(i)); 
	    }
	    part.submitCustomerNameForAllModule();
	    Thread.sleep(3000);
	   String actualMsg= part.verifyCustomerMissingWarning();
	   String expectedMsg="These Customer are missing. Please check or add them to the master list.";
	   Assert.assertEquals(actualMsg, expectedMsg, "with clickable link redirecting to Customer Master.!");
	   LoggerUtil.info("Actual Value = "+actualMsg+ " || and || Expected Value = " + expectedMsg);
  }
	
	@Test(priority = 34,groups = "group1")
	public void PM_TC_026PartMaster_MasterDataClosePopupbyClickingOutside() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();
	    part.clickOutsideCustomerPopup();          // perform the outside click

	    boolean closed = part.verifyCustomerPopupClosedAfterOutsideClick();
	    if (closed) {
	        LoggerUtil.pass("Customer popup closed successfully by clicking outside.");
	    } else {
	        LoggerUtil.error("Customer popup did not close by clicking outside.");
	        org.testng.Assert.fail("Customer popup did not close by clicking outside.");
	    }
	    

  }
	@Test(priority = 35,groups = "group1")
	public void PM_TC_027PartMaster_MasterDataClickcloseicononcustomerpopup() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();
	    part.clickOnCustomePasteCloseIconBT();
	    boolean closed = part.waitUntilCustomerPopupClosed();
	    if (closed) {
	        LoggerUtil.pass("Customer popup closed successfully.");
	    } else {
	        LoggerUtil.error("Customer popup did not close as expected.");
	        org.testng.Assert.fail("Customer popup did not close as expected.");
	    }

  }
	
	@Test(priority = 36,groups = "group1")
	public void PM_TC_028PartMaster_MasterDataCustomerPastePlaceholder() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnCustomePasteIcon();
	    String actualPlaceholder = part.getCustomerPastePlaceholderText();
        LoggerUtil.info("Fetched placeholder text: '" + actualPlaceholder + "'.");

        String expectedPlaceholder = "Paste";
        Assert.assertEquals(actualPlaceholder.trim(), expectedPlaceholder, 
            "Placeholder text did not match.");

        LoggerUtil.pass("PM_TC_028: Placeholder text is correctly displayed as '" + expectedPlaceholder + "'.");

  }
	
	@Test(priority = 37,groups = "group1")
	public void PM_TC_029PartMaster_MasterDataSingleandMultipleCustomerSelection() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.customerDropdownVerifyMultipleDropdownSelectionTest("aatigrb","abkbijn");
	    

  }
	@Test(priority = 38,groups = "group1")
	public void PM_TC_030PartMaster_MasterDataDefaultRadioButtonSelection() throws InterruptedException, IOException {
		 LoggerUtil.info("PM_TC_030: Start - Validate default radio button selection is 'Both'.");
		    try {
		        dashboard = new DashboardPage();
		        dashboard.selectMenuFormDashBoard("Master Data");
		        LoggerUtil.info("Navigated to 'Master Data'.");

		        dashboard.clickOnPartMaster();
		        LoggerUtil.info("Opened 'Part Master'.");

		        part = new PartMasterPage();
		        part.verifyDefaultRadioButtonIsBoth();   // core validation
		        LoggerUtil.info("PM_TC_030: End.");
		    } catch (Exception e) {
		        LoggerUtil.error("PM_TC_030: Unexpected error - " + e.getMessage());
		        throw e;
		    }
		}
	
	@Test(priority = 39, groups = "group1")
	public void PM_TC_031PartMaster_MasterData_SalesSelectionHidesSupplierDropdown() throws Exception {
	    LoggerUtil.info("PM_TC_031: Start - Validate that selecting 'Sales' hides the Supplier dropdown.");
	    try {
	        dashboard = new DashboardPage();
	        dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to Master Data.");

	        dashboard.clickOnPartMaster();
	        LoggerUtil.info("Opened Part Master.");

	        part = new PartMasterPage();
	        part.selectSalesAndVerifySupplierHidden();

	        LoggerUtil.info("PM_TC_031: End.");
	    } catch (Exception e) {
	        LoggerUtil.error("PM_TC_031: Unexpected error - " + e.getMessage());
	        throw e;
	    }
	}
	
	@Test(priority = 40, groups = "group1")
	public void PM_TC_032PartMaster_MasterData_SalesSelectionHidesCustomerPartNo() throws Exception {
	    LoggerUtil.info("PM_TC_032: Start - Validate that selecting 'Sales' hides the 'Customer Part No.' field.");
	    try {
	        dashboard = new DashboardPage();
	        dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to 'Master Data'.");

	        dashboard.clickOnPartMaster();
	        LoggerUtil.info("Opened 'Part Master'.");

	        part = new PartMasterPage();
	        part.selectSalesAndVerifyCustomerPartNoHidden();

	        LoggerUtil.info("PM_TC_032: End.");
	    } catch (Exception e) {
	        LoggerUtil.error("PM_TC_032: Unexpected error - " + e.getMessage());
	        throw e;
	    }
	}
	
	@Test(priority = 42, groups = "group1")
	public void PM_TC_034PartMaster_MasterData_FetchSupplierFromSupplierMaster() throws Exception {
	    LoggerUtil.info("PM_TC_034: Start - Validate that supplier added in Supplier Master appears in Part Master > Supplier dropdown.");
	    try {
	        
	        dashboard = new DashboardPage();
	        dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to 'Master Data'.");

	        dashboard.clickonsuppliermaster(); 
	        LoggerUtil.info("Opened 'Supplier Master'.");

	        SupplierMasterPage supplier = new SupplierMasterPage();
	      //  supplier.entersuppliervalueforrminput(randomname, randomname1, randomname2);
	        
	        LoggerUtil.info("Created supplier: " + supplier);

	        dashboard.clickOnPartMaster();
	        LoggerUtil.info("Opened 'Part Master'.");

	        part = new PartMasterPage();
	        part.verifySupplierPresentInDropdown(randomname, randomname1, randomname2);
	        LoggerUtil.info("PM_TC_034: End.");
	    } catch (Exception e) {
	        LoggerUtil.error("PM_TC_034: Unexpected error - " + e.getMessage());
	        throw e;
	    }
	}
	
	@Test(priority = 42, groups = "group1")
	public void PM_TC_035PartMaster_MasterData_SupplierDropdownConcatenation() throws Exception {
	    LoggerUtil.info("PM_TC_035: Start - Validate that Supplier Dropdown Concatenation in Part Master > Supplier dropdown.");
	    try {
	        
	        dashboard = new DashboardPage();
	        dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to 'Master Data'.");

	        dashboard.clickonsuppliermaster(); 
	        LoggerUtil.info("Opened 'Supplier Master'.");

	        SupplierMasterPage supplier = new SupplierMasterPage();
	     //   supplier.entersuppliervalueforrminput(randomname, randomname1, randomname2);
	        
	        LoggerUtil.info("Created supplier: " + supplier);

	        dashboard.clickOnPartMaster();
	        LoggerUtil.info("Opened 'Part Master'.");

	        part = new PartMasterPage();
	        part.verifySupplierDropdownConcatenation(randomname, randomname1);
	        LoggerUtil.info("PM_TC_035: End.");
	    } catch (Exception e) {
	        LoggerUtil.error("PM_TC_035: Unexpected error - " + e.getMessage());
	        throw e;
	    }
	}
	@Test(priority = 43, groups = "group1")
	public void PM_TC_036PartMaster_MasterData_AddSupplierViaPartMasterAndVerifyEverywhere() throws Exception {
	    LoggerUtil.info("PM_TC_036: Start - Add Supplier via Part Master and verify in dropdown & Supplier Master.");
	    try {
	        // Test data (align with your existing random variables if you already set them)
	        String supplierName = randomname1;     // e.g., "Acme"
	        String supplierCode = randomname;      // e.g., "ACM001"
	        String supplierLocation = randomname2; // Optional, used on Supplier Master grid or details

	        // 1) Navigate to Part Master and open the +Supplier popup
	        DashboardPage dashboard = new DashboardPage();
	        dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to 'Master Data'.");
	        dashboard.clickOnPartMaster();
	        LoggerUtil.info("Opened 'Part Master'.");

	        PartMasterPage part = new PartMasterPage();

	        // 2) Add supplier via Part Master (+Supplier)
	        part.openAddSupplierPopup(); // <— Page method to click "+Supplier"
	        part.fillAndSaveSupplierFromPartMaster(supplierName, supplierCode,supplierLocation);
	        LoggerUtil.pass("Supplier added via Part Master popup: " + supplierName + " - " + supplierCode);

	        // 3) Validate dropdown entry in Part Master (Name-Code concatenation)
	        part.verifySupplierDropdownConcatenation(supplierName, supplierCode); // robust Name-Code check
	        LoggerUtil.pass("Verified in Part Master dropdown: " + supplierName + "-" + supplierCode);   
	        part.verifySupplierPresentInDropdown(randomname, randomname1, randomname2);
	        LoggerUtil.info("PM_TC_036: End.");
	    } catch (Exception e) {
	        LoggerUtil.error("PM_TC_036: Unexpected error - " + e.getMessage());
	        throw e;
	    }
	}

	
	@Test(priority = 36,groups = "group1")
	public void PM_TC_043PartMaster_MasterDataSupplierPastePlaceholder() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnSupplierPasteIcon();
	    String actualPlaceholder = part.getSupplierPastePlaceholderText();
        LoggerUtil.info("Fetched placeholder text: '" + actualPlaceholder + "'.");

        String expectedPlaceholder = "Paste";
        Assert.assertEquals(actualPlaceholder.trim(), expectedPlaceholder, 
            "Placeholder text did not match.");

        LoggerUtil.pass("PM_TC_043: Placeholder text is correctly displayed as '" + expectedPlaceholder + "'.");

  }
	
	@Test(priority = 31, groups = "group1")
	public void PM_TC_037PartMaster_MasterDataPasteSupplierfromExcel() throws Exception {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnSupplierPasteIcon();

	    List<String> pasteData = part.readSupplierPasteStrings(
	        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\SupplierMaster_13-08-2025_15_59_55.xlsx");

	    int limit = Math.min(5, pasteData.size());
	    for (int i = 0; i < limit; i++) {
	        part.pasteTextSupplier(pasteData.get(i)); 
	    }
	    part.submitSupplierNameForAllModule();
	  //  String ac=part.verifyCustomersAppearAndAreSelectable();
	    String Expected="5 Selected";
	   //Assert.assertEquals(ac, Expected, "passed");
	}
	
	@Test(priority = 32, groups = "group1")
	public void PM_TC_038PartMaster_MasterDataAutoselectSupplierafterSubmit() throws Exception {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();

	    part = new PartMasterPage();
	    part.clickOnSupplierPasteIcon();

	    List<String> pasteData = part.readSupplierPasteStrings(
		        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\SupplierMaster_13-08-2025_15_59_55.xlsx");

		    int limit = Math.min(5, pasteData.size());
		    for (int i = 0; i < limit; i++) {
		        part.pasteTextSupplier(pasteData.get(i)); 
		    }
		    part.submitSupplierNameForAllModule();

	    // Validate auto-selection for the FIRST pasted line (adjust if your product selects “last” instead)
	    part.verifySupplierAutoSelectedAfterSubmit(pasteData.get(0));
	}
	
	@Test(priority = 33,groups = "group1")
	public void PM_TC_040PartMaster_MasterDataMissingSupplierWarning() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnSupplierPasteIcon();

	    List<String> pasteData = part.readSupplierPasteStrings(
		        "C:\\Users\\user\\Downloads\\com.CostMaster\\testdata\\SupplierMaster_13-08-2025_15_59_55.xlsx");

		    int limit = Math.min(5, pasteData.size());
		    for (int i = 0; i < limit; i++) {
		        part.pasteTextSupplier(pasteData.get(i)); 
		    }
		    part.submitSupplierNameForAllModule();
	    Thread.sleep(3000);
	   String actualMsg= part.verifySupplierMissingWarning();
	   String expectedMsg="These suppliers are missing. Please check or add them to the master list.";
	   Assert.assertEquals(actualMsg, expectedMsg, "with clickable link redirecting to Supplier Master.!");
	   LoggerUtil.pass("Actual Value = "+actualMsg+ " || and || Expected Value = " + expectedMsg);
  }
	
	@Test(priority = 34,groups = "group1")
	public void PM_TC_041PartMaster_CloseSupplierPopupByClickingOutside() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnSupplierPasteIcon();
	    part.validateSupplierPopupCloseByOutsideClick(); 

  }
	@Test(priority = 34,groups = "group1")
	public void PM_TC_042PartMaster_CloseSupplierPopupviaIcon() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.clickOnSupplierPasteIcon();
	    part.validateSupplierPopupCloseByIcon(); 

  }
	/*@Test(priority = 34,groups = "group1")
	public void PM_TC_044PartMaster_VerifyProductCategoryfetchfromProductModel() throws InterruptedException, IOException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnProductModel();
	    ProductModelPage productModelPage= new ProductModelPage();
	    productModelPage.clcikOnProductModelButton();
	    List<String> expectedCategories = null;
	    try {
	    	  expectedCategories = productModelPage.getActiveProductCategoryNames();
		} catch (TimeoutException e) {
			
			e.printStackTrace();
		}
	    Assert.assertFalse(expectedCategories.isEmpty(), "No Product Model categories found to compare.");
        LoggerUtil.pass("Collected expected categories from Product Model: " + expectedCategories);
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    String ex=  part.getProductCategoryOptionsFromOpenDropdown();
	    Assert.assertEquals(expectedCategories,ex);
	  }*/
	 ProductModelPage productModelPage=null;
	@Test(priority = 34, groups = "group1")
	public void PM_TC_044PartMaster_VerifyProductCategoryfetchfromProductModel() throws Exception {
	    dashboard = new DashboardPage();

	    // Step 1: Navigate to Product Model and collect expected categories
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnProductModel();

	    productModelPage = new ProductModelPage();
	    productModelPage.clcikOnProductModelButton();

	    List<String> expectedCategories = productModelPage.getActiveProductCategoryNames();
	    Assert.assertFalse(expectedCategories.isEmpty(), "No Product Model categories found to compare.");
	    LoggerUtil.pass("Collected expected categories from Product Model: " + expectedCategories);

	    // Step 2: Navigate to Part Master and read Product Category dropdown options
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();

	    List<String> partMasterOptions = part.getProductCategoryOptionsFromOpenDropdown();
	    Assert.assertFalse(partMasterOptions.isEmpty(), "Part Master Product Category dropdown returned no options.");
	    LoggerUtil.pass("Collected Part Master Product Category options: " + partMasterOptions);

	    // Step 3: Validation — Part Master must contain all categories shown in Product Model
	    boolean containsAll = partMasterOptions.containsAll(expectedCategories);
	    if (!containsAll) {
	        // Compute missing items for precise diagnosis
	        List<String> missing = new ArrayList<>();
	        for (String c : expectedCategories) {
	            if (!partMasterOptions.contains(c)) missing.add(c);
	        }
	        LoggerUtil.error("Missing in Part Master dropdown (but present in Product Model): " + missing);
	    }
	    Assert.assertTrue(containsAll, "Part Master dropdown does not include all Product Model categories.");
	    LoggerUtil.pass("Validation passed: Part Master Product Category is dynamically fetched from Product Model.");
	}
	
	@Test(priority = 37, groups = "group1")
	public void PM_TC_045PartMaster_VerifyMultipleAllocationOfProductCategory() throws Exception {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.fillMandatoryForNewPart(randomname1, randomname2, randomname1, randomname2, 1, 1, 1,3,1,1);
	    Thread.sleep(5000);
	    part.partMasterViewBtn();
	    Thread.sleep(5000);
	    part.searchBoxPartMaster(randomname1);
	    Thread.sleep(5000);
	    part.partMasterEditBtn();
	    Thread.sleep(5000);
	    part.verifyMultipleAllocationOfProductCategoryPersisted(3);
	}

	@Test(priority = 38, groups = "group1")
	public void PM_TC_046PartMaster_VerifyProductModelDependencyOnProductCategory() throws InterruptedException {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    productModelPage = new ProductModelPage();
	    productModelPage.clcikOnProductModelButton();
	    dashboard.clickOnPartMaster();

	    part = new PartMasterPage();

	    // Precondition: fill mandatory fields minimally (you can reuse your method).
	    // Choose any valid counts; Product Category will be changed inside the verifier anyway.
	    part.fillMandatoryForNewPart(randomname1, randomname2, randomname1, randomname2, 1, 1, 1, 2, 1, 1);

	    // Open the saved part for a stable page state (optional if already on edit)
	    part.partMasterViewBtn();
	    part.searchBoxPartMaster(randomname1);
	    part.partMasterEditBtn();

	    // Dependency validation (UI-only, no backend assumptions)
	    part.verifyProductModelDependsOnProductCategory_UIOnly();
	}
	
	@Test(priority = 38, groups = "group1")
	public void PM_TC_047PartMaster_VerifyProductModelDependencyOnProductCategory() {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnProductModel();
	    productModelPage = new ProductModelPage();
	    productModelPage.clcikOnProductModelButton();
	   // productModelPage.enterdOnCommonProductModelAdditionForm(randomname1,"electronics",randomname1,"Costmaster-Mohali","Misc");
	  //  productModelPage.enterdOnCommonProductModelAdditionForm(randomname1,"electronics",randomname1,"Costmaster-Mohali","Misc-2");
	    productModelPage.enterdOnCommonProductModelAdditionForm(randomname1,"electronics",randomname1,"Costmaster-Mohali","PC-2410-02");

	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();

	    
	    part.enterOnCommanValuPartMasterText(randomname3, randomname2, randomname1, randomname);

	    // Open the saved part for a stable page state (optional if already on edit)
	    part.partMasterViewBtn();
	    part.searchBoxPartMaster(randomname1);
	    part.partMasterEditBtn();

	    // Dependency validation (UI-only, no backend assumptions)
	    part.verifyProductModelDependsOnProductCategory_UIOnly();
	}
	@Test(priority = 38, groups = "group1")
	public void PM_TC_048PartMaster_VerifymultipleselectioninSpecialProductCategory() throws InterruptedException {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.enterOnCommanValuPartMasterText(randomname, "RT01Validation", "CPN01", "HSNC01");
	    part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
	    part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
	    part.partMasterSaveBtn();
	    part.partMasterViewBtn();
	    Thread.sleep(4000);
	    part.searchBtnPartMasterFilterIcon("Part No.");
	    Thread.sleep(4000);
	    part.searchBoxPartMaster(randomname);
	    part.partMasterEditBtn();
	    part.verifyMultipleSelectionInSpecialProductCategory("MK-testing-2308","PC-2410-02");
	}
	
	@Test(priority = 38, groups = "group1")
	public void PM_TC_049PartMaster_VerifysuccesspromptonSave() throws InterruptedException {
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.enterOnCommanValuPartMasterText(randomname, "RT01Validation", "CPN01", "HSNC01");
	    part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
	    part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
	    part.partMasterSaveBtn();
	   
	}
	
	@Test(priority = 38, groups = "group1")
	public void PM_TC_050PartMaster_Verifysearchingpartwithallfilters(){
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.partMasterViewBtn();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    part.searchBtnPartMasterFilterIcon("Part No.");
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    part.searchBoxPartMaster("1012");
	   
	}
	
	/*@Test(priority = 38, groups = "group1")
	public void PM_TC_051PartMaster_Editandupdatealldetailsofpart() throws InterruptedException{
	    dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.partMasterViewBtn();
	    Thread.sleep(5000);
		part.searchBtnPartMasterFilterIcon("Part No.");
	    Thread.sleep(4000);
		part.searchBoxPartMaster("1012");
	    Thread.sleep(4000);
	    part.getPartMasterDetails("Part No.","1012");
	    Thread.sleep(4000);
		part.partMasterEditBtn();
		part.enterOnCommanValuPartMasterText(randomname, "RT01Validation", "CPN01", "HSNC01");
		part.partMasterSaveBtn();
		part.partMasterViewBtn();
		part.getPartMasterDetails("Part No.","1012");
		
	}*/
	
	@Test(priority = 38, groups = "group1")
	public void PM_TC_051PartMaster_Editandupdatealldetailsofpart() throws InterruptedException {
		dashboard = new DashboardPage();
	    dashboard.selectMenuFormDashBoard("Master Data");
	    dashboard.clickOnPartMaster();
	    part = new PartMasterPage();
	    part.partMasterViewBtn();
	    Thread.sleep(5000);
		part.searchBtnPartMasterFilterIcon("Part No.");
	    Thread.sleep(4000);
		part.searchBoxPartMaster("12112024");
	    Thread.sleep(4000);
	    Map<String,String> before = part.getRowDataBy("Part No.", "12112024");
	    LoggerUtil.info("Before Edit → " + before);
	    String expectedPartNo = "12112024";  
	    String expectedPartDescription = randomname;              
	    String expectedCustomerPartNo = "CPN01";              
	    String expectedHSN            = "HSNC01";             

	    part.partMasterEditBtn();
	    part.enterOnCommanValuPartMasterText(expectedPartNo,expectedPartDescription,expectedCustomerPartNo,expectedHSN);
	    part.partMasterSaveBtn();
	    part.partMasterViewBtn();
	    Map<String,String> after = part.getRowDataBy("Part No.", "12112024");
	    LoggerUtil.info("After Edit → " + after);
	    validateCell("Part No. ", expectedPartNo, after);
	    validateCell("Part Description", expectedPartDescription,after);
	    validateCell("Customer Part No.",expectedCustomerPartNo, after);
	    validateCell("HSN Code",expectedHSN,after);

	    LoggerUtil.info("PASS: PM_TC_051 - Part updated and reflected in View.");
	}
	private void validateCell(String header, String expected, Map<String,String> row) {
	    String actual = null;
	    for (String k : row.keySet()){
	        if (k.equalsIgnoreCase(header)) { actual = row.get(k); break; }
	    }
	    if (actual == null) {
	        LoggerUtil.error("FAIL: Header not found in row → " + header);
	        Assert.fail("Header not found: " + header);
	        return;
	    }
	    if (expected.equalsIgnoreCase(actual)) {
	        LoggerUtil.info("PASS: " + header + " | Expected = [" + expected + "] | Actual = [" + actual + "]");
	    } else {
	        LoggerUtil.error("FAIL: " + header + " | Expected = [" + expected + "] | Actual = [" + actual + "]");
	        Assert.fail(header + " mismatch.");
	    }
	}

	@Test(priority = 50,groups="group1")
	public void PM_TC_0052Verifyuniqueconstraintforpartsave() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.enterOnCommanValuPartMasterText("12112024", "fjdsf", "CPN01", "HSNC01");
		part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
		part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
		part.partMasterSaveBtn();
		String act=part.verifyToastAlertMsg("Prompt message indicating mandatory fields required.");
		if(act.equalsIgnoreCase("Prompt message indicating mandatory fields required.")) {
			LoggerUtil.pass("alert pop displayed: "+act);	
		}else {
			LoggerUtil.error("alert pop displayed: "+act);
		}
		
	}
	
	@Test(priority = 50,groups="group1")
	public void PM_TC_0053Verifyviewscreenmatchessaveddetails() throws InterruptedException {
		dashboard = new DashboardPage();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		part = new PartMasterPage();
		part.enterOnCommanValuPartMasterText("12112024545", "fjds5f", "CPN01", "HSNC01");
		part.enterOnCommanDropPartMasterText("Costmaster-Mohali-007", "fgnbjhrtvh-knrkjghj4rgy-dsf1", "0801-Abe", "FURNITURE", "Misc-2410456");
		part.selectOnSpecialProductCategoryValuesByText("MK-testing-2308","PC-2410-02");
		part.partMasterSaveBtn();
		part.partMasterViewBtn();
	    Thread.sleep(5000);
		part.searchBtnPartMasterFilterIcon("Part No.");
	    Thread.sleep(4000);
		part.searchBoxPartMaster("12112024545");
	    Thread.sleep(4000);
	    Map<String,String> before = part.getRowDataBy("Part No.", "12112024545");
	    
	   
	    String expectedPartNo = "12112024545";  
	    String expectedPartDescription = "fjds5f";              
	    String expectedCustomerPartNo = "CPN01";              
	    String expectedHSN            = "HSNC01";             
	    String companyValuText ="Costmaster-Mohali-007";
	    String customerValueText ="fgnbjhrtvh-knrkjghj4rgy-dsf1";
	    String supplierValueText="0801-Abe";
	    String productCategoryValueText="FURNITURE";
	    String productModelNameAndNumberValueText="Misc-2410456";
	    
	   
	    Map<String,String> after = part.getRowDataBy("Part No.", "12112024");
	    LoggerUtil.info("After Edit → " + after);
	    validateCell("Part No. ", expectedPartNo, after);
	    validateCell("Part Description", expectedPartDescription,after);
	    validateCell("Customer Part No.",expectedCustomerPartNo, after);
	    validateCell("HSN Code",expectedHSN,after);

	    LoggerUtil.info("PASS: PM_TC_051 - Part updated and reflected in View.");
		
	}
	

}
	

