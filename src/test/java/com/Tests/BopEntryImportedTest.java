package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.BopEntryImportedPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.helper.Base;

@Listeners(com.helper.TestListeners.class)
public class BopEntryImportedTest extends Base {
	
	LoginPage login= new LoginPage();
	DashboardPage dashboard= new DashboardPage();
	BopEntryImportedPage  bimp =new BopEntryImportedPage();
	Faker faker = new Faker();
	
	
	@BeforeGroups(groups= {"group1","group2","group3","group4"})
	public void loging() {
		
		launchApplication();
		 login = new LoginPage();
		 dashboard = new DashboardPage();
		 bimp = new BopEntryImportedPage();
		 login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
   
		 
		
		
	}
	
	@AfterGroups(groups= {"group1","group2","group3","group4"})
	public void quitApp() {
		
		driver.quit();
		
	}
	
	
	@Test(priority=1,groups="group1")
	public void TC_BOP_IMP_001VerifyMandatoryFieldsWithMark() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		bimp.verifyingAstricMark();
		
		
	}
	@Test(priority=2,groups="group1")
	public void TC_BOP_IMP_002VerifyBopTypeDropdownAlphabeticalOrder() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
	    Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		bimp.sortingBopTypeDropDown();
		
		 
		
	}
	
	
	@Test(priority=3,groups="group1")
	public void TC_BOP_IMP_003VerifyBopCategoryDefaultToImported() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		bimp.verifyDefaultBopCategoryDropValue();
		
	
		
	}
	
	
	
	
	@Test(priority=3,groups="group1")
	public void TC_BOP_IMP_004VerifySupplierDropdownDynamicSearchAndDisplayNameAndCode() throws InterruptedException {
		String suppliername =faker.name().firstName()+faker.letterify("???");
		double randomint = faker.number().randomDouble(2, 10, 99);
		String suppliercode = String.valueOf(randomint);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(200);
		bimp.EnteringSupplierValue(suppliercode,suppliername);
		
		
		  
		
		
	}
	
	@Test(priority=4,groups="group1")
	public void TC_BOP_IMP_005VerifyContainerAndIncotermsDropdownAlphabeticalAndSearchable() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
	    Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(200);
		bimp.verifyIncotermsDropdown();
		
		
		   
		
		
		
	}
	
	
	
	@Test(priority=5,groups="group1")
	public void TC_BOP_IMP_006VerifyCurrencyConversionDropdownsBehavior() throws Exception {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
        bimp.VerifyCurrencyDropdownbehaviour();
		
      
	}
	
	
	
	@Test(priority=6,groups="group1")
	public void TC_BOP_IMP_007VerifyNumericValidationForShippingDetailsFields() throws InterruptedException {
	
		String Suppliername =faker.name().firstName()+faker.letterify("???");
		String Bopname =faker.name().firstName()+faker.letterify("???");
		String EnterFrieghtvalue =faker.name().firstName()+faker.letterify("???");
		String Entershipmentvalue =faker.name().firstName()+faker.letterify("???");
		String Enterspotratevalue =faker.name().firstName()+faker.letterify("???");
		double randomint = faker.number().randomDouble(2, 10, 99);
		String suppliercode = String.valueOf(randomint);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		
		bimp.verifyValidationForShippingDetailsField(Bopname,EnterFrieghtvalue,Entershipmentvalue,Enterspotratevalue,Suppliername,suppliercode,Bopname);
	}
	
	
	@Test(priority=6,groups="group1")
	public void TC_BOP_IMP_007VerifyNumericValidationForShippingDetailsFieldsForSpecialCharacter() throws InterruptedException {
	
		
		String Suppliername =faker.name().firstName()+faker.letterify("???");
		String Bopname =faker.name().firstName()+faker.letterify("???");
		String EnterFrieghtvalue ="@#$%";
		String Entershipmentvalue ="@#$%^";
		String Enterspotratevalue ="@#$%^&*";
		double randomint = faker.number().randomDouble(2, 10, 99);
		String suppliercode = String.valueOf(randomint);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		
		bimp.verifyValidationForShippingDetailsField(Bopname,EnterFrieghtvalue,Entershipmentvalue,Enterspotratevalue,Suppliername,suppliercode,Bopname);
		
		
		
	}
	
	@Test(priority=6,groups="group1")
	public void TC_BOP_IMP_007VerifyNumericValidationForShippingDetailsFieldsForText() throws InterruptedException {
	
		
		String Suppliername =faker.name().firstName()+faker.letterify("???");
		String Bopname =faker.name().firstName()+faker.letterify("???");
		String EnterFrieghtvalue =faker.name().firstName()+faker.letterify("???");
		String Entershipmentvalue =faker.name().firstName()+faker.letterify("???");
		String Enterspotratevalue =faker.name().firstName()+faker.letterify("???");
		double randomint = faker.number().randomDouble(2, 10, 99);
		String suppliercode = String.valueOf(randomint);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		
		bimp.verifyValidationForShippingDetailsField(Bopname,EnterFrieghtvalue,Entershipmentvalue,Enterspotratevalue,Suppliername,suppliercode,Bopname);
		
		
		
	}
			
	@Test(priority=7,groups="group1")
	public void TC_BOP_IMP_010VerifyExWorkAndOtherMiscFieldsAcceptNumericOnlyForText() throws InterruptedException {
		
		String Bopname =faker.name().firstName()+faker.letterify("???");
		String EnterwithEx = faker.name().firstName()+faker.letterify("???");
		String EnterWithMisc = faker.name().firstName()+faker.letterify("???");
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		
		bimp.ExWorkAndOtherMiscFieldsAcceptSpecialcharacterAndText(Bopname,EnterwithEx,EnterWithMisc);
		
	
		
		
	}
	
	@Test(priority=7,groups="group1")
	public void TC_BOP_IMP_010VerifyExWorkAndOtherMiscFieldsAcceptNumericOnlyForSpecialCharacter() throws InterruptedException {
		
		String Bopname =faker.name().firstName()+faker.letterify("???");
		String EnterwithEx = "@#$%";
		String EnterWithMisc = "!@#$%^&*";
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		
		bimp.ExWorkAndOtherMiscFieldsAcceptSpecialcharacterAndText(Bopname,EnterwithEx,EnterWithMisc);
		
		
		
	}
	
	
	
	@Test(priority=7,groups="group1")
	public void TC_BOP_IMP_010VerifyExWorkAndOtherMiscFieldsAcceptNumericOnly() throws InterruptedException {
		
		String Bopname =faker.name().firstName()+faker.letterify("???");
		
		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String EnterwithEx = String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String EnterWithMisc = String.valueOf(EnterValueWithMisc);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(6000);
		dashboard.clickingBopEntryTab();
		
		bimp.ExWorkAndOtherMiscFieldsAcceptNumericOnly(Bopname,EnterwithEx,EnterWithMisc);
		
		
		
		
	}
	
	@Test(priority=8,groups="group1")
	public void TC_BOP_IMP_013VerifyLandedCostAndCostPerPcCalculations() throws InterruptedException {
		faker.name().firstName();
		faker.letterify("???");
		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		
		
		dashboard.clickingBopEntryTab();
		
		bimp.EnteringValuesForValidateLandedCost ();
		
	}
	
	
	@Test(priority=9,groups="group1")
	public void TC_BOP_IMP_008VerifyTotalShipmentValueAutoCalculation() throws InterruptedException {
		
		faker.name().firstName();
		faker.letterify("???");
		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String shipvalue = String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String unitvalue= String.valueOf(EnterValueWithMisc);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		
		
		dashboard.clickingBopEntryTab();
		bimp.verifyShipmentValueAutoCalculated(shipvalue, unitvalue);
		
		
		
	}
	
	@Test(priority = 10, groups = "group1")
	public void TC_BOP_IMP_011VerifyInsuranceCifAssessableValueCalculations() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);

		dashboard.clickingBopEntryTab();
		bimp.verifyInsuranceValue();

	}

	@Test(priority = 11, groups = "group1")
	public void TC_BOP_IMP_014VerifySaveFunctionalityWithValidInputs() throws InterruptedException {

		String Bopname = faker.name().firstName() + faker.letterify("???");
		String PartDescription = faker.name().firstName() + faker.letterify("??????");

		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		BopEntryImportedPage.verifyBopImportWithMandatoryValues(Bopname, PartDescription, PartDescription);

	}
	
	@Test(priority=12,groups="group1")
	public void TC_BOP_IMP_015VerifyUpdateFunctionalityInImportedBop() throws InterruptedException {
		

		String Bopname = faker.name().firstName() + faker.letterify("??????");
		String Bopname1 = faker.name().firstName() + faker.letterify("????????");
		String PartDescription = faker.name().firstName() + faker.letterify("??????");

		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname);
		Thread.sleep(3000);

		BopEntryImportedPage.EnterBopNameInFirstTab(Bopname1);
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		try {
		Thread.sleep(3000);
		BopEntryImportedPage.verifyBopImportWithMandatoryValues(Bopname, PartDescription, PartDescription);
        Thread.sleep(2000);
        bimp. verifyAndUpdateBopWithImported(Bopname1,Bopname);
		}catch(Exception e) {
			
			e.getMessage();
		}
		
		
	}
	
	
	@Test(priority=13,groups="group1")
	public void TC_BOP_IMP_016VerifyExportFunctionalityExistingBopParts() throws InterruptedException {
		
		faker.name().firstName();
		faker.letterify("??????");
		faker.name().firstName();
		faker.letterify("????????");
		faker.name().firstName();
		faker.letterify("??????");

		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		bimp.verifyUiAndExcelDataForImported();
	}
	
	@Test(priority=14,groups="group1")
	public void TC_BOP_IMP_017VerifyImportFunctionalityWithValidData() throws InterruptedException {
		
		
		faker.name().firstName();
		faker.letterify("??????");
		faker.name().firstName();
		faker.letterify("????????");
		faker.name().firstName();
		faker.letterify("??????");

		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
        bimp.verifyImportFileWithValidDetiails(); 
		
		
		
	}
	
	@Test(priority=15,groups="group1")
	public void TC_BOP_IMP_019VerifyExportFileNamingConventionForImportedTab() throws InterruptedException {
		
		faker.name().firstName();
		faker.letterify("??????");
		faker.name().firstName();
		faker.letterify("????????");
		faker.name().firstName();
		faker.letterify("??????");

		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		bimp.verifyReadFileNamingConvention();
		
		
	}
	
	
	@Test(priority=16,groups="group1")
	public void TC_BOP_IMP_027NegativeSavewithoutFillingMandatoryFieldsWithoutBopType() throws InterruptedException {
		
		
		faker.name().firstName();
		faker.letterify("???");
		String PartDescription = faker.name().firstName() + faker.letterify("??????");

		int EnterTextWithEx = faker.number().numberBetween(10, 99);
		String.valueOf(EnterTextWithEx);
		int EnterValueWithMisc = faker.number().numberBetween(10, 99);
		String.valueOf(EnterValueWithMisc);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(1000);
	
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		bimp.verifySaveDataWithImportWithoutBopType(PartDescription, PartDescription);

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
