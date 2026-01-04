package com.Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.BOPEntryPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.helper.Base;

@Listeners(com.helper.TestListeners.class)
public class BOPEntryTest extends Base{

     Faker faker = new Faker();
	LoginPage login;
	DashboardPage dashboard;
	BOPEntryPage bentry;
 	@BeforeGroups(groups= {"group1","group2","group3","group4"})
 	public void LaunchApplication() {
 		
 		launchApplication();
 		
 		login = new LoginPage();
 		dashboard = new DashboardPage();
 		bentry = new BOPEntryPage();
 		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
 		
 		
 		
 		
 		
 	}
	  
                            	            
	@AfterGroups(groups= {"group1","group2","group3","group4"})
	public void QuitApplication() {
		
		driver.quit();
		
		
	}
	
	
	@Test(priority=1,groups="group1")
	public void TC_BOP_IH_001VerifyPlaceholderForDropDownFields() throws InterruptedException {
		
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		
		bentry.verifyPlaceHolder();
	}
	
	
	@Test(priority=2,groups="group1")
	public void TC_BOP_IH_001VerifyMandatoryFieldsMarkedWith() throws InterruptedException{
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		bentry.verifyAstricMarkShouldBeAvailableWithMandatoryField();
		
		
	}
	
	
	@Test(priority=3,groups="group1")
	public void TC_BOP_IH_002VerifyBopTypeDropdownIsAlphabeticallySorted() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		bentry.BoptypeDropdownSortedOrNot();
		
		
	}
	
	@Test(priority=4,groups="group1")
	public void TC_BOP_IH_003VerifyDefaultBopCategoryAsInhouse() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		bentry.VerifyBopCategoryDefaultSelection();
		
		
		
		
	}
	
	
	
	
	
	
	
 @Test(priority=5,groups="group1")
 public void TC_BOP_IH_004VerifyUomDropdownBehavior() throws InterruptedException {
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
	   bentry.verifyUomDropdownSortedOrNot();
	 
	
 }


 
 @Test(priority=6,groups="group1")
 public void TC_BOP_IH_005VerifySupplierDropdownBehavior() throws InterruptedException {
	 
	 String randomName = faker.name().firstName()+faker.letterify("????");
	 int randint = faker.number().numberBetween(0000, 9999);
	 String randomint = String.valueOf(randint);
	 
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
	 
	 bentry.verifysupplierdropdownbehaviour(randomint, randomName);
	 
	 
 }
 
 @Test(priority=7,groups="group1")
 public void TC_BOP_IH_006ValidateNumericOnlyFieldsForGrossWtFinishWtProcessCostOtherCost() throws InterruptedException {
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
	 
	 
	 
	 
 }
 
 
 @Test(priority=8,groups="group1")
 public void TC_BOP_IH_007ValidateCommodityGroupDropdownBehavior() throws InterruptedException {
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
	 bentry.verifyCommodityDropdownBehaviour();
	 Thread.sleep(3000);
	 bentry.verifyFetchingDataInCommodityGroupFromBopEntry();
	
	 
	 
	 
 }
 
 
 @Test(priority=9,groups="group1")
 public void TC_BOP_IH_008ValidateRMGroupClassificationIsDependentAndSearchable() throws InterruptedException {
	 
	 String commoditygroup = faker.name().firstName()+faker.letterify("????");
	 String classification = faker.name().firstName()+faker.letterify("????");
	 String specificgrade = faker.name().firstName()+faker.letterify("????");
	 int randomint = faker.number().numberBetween(10,99);
	 String densityvalue = String.valueOf(randomint);
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
	 dashboard.clickoncommodityMaster();
	 bentry.verifyCommodityGroupClassificationDependency(commoditygroup, classification, specificgrade, densityvalue);

 }
 
 
 
 @Test(priority=10,groups="group1")
 public void TC_BOP_IH_010ValidateRmRateKgScrapCostKgFetchFromCommodityMaster() throws InterruptedException {
	 
	 String commoditygroup = faker.name().firstName()+faker.letterify("????");
	 String classification = faker.name().firstName()+faker.letterify("????");
	 String specificgrade = faker.name().firstName()+faker.letterify("????");
	 int randomint = faker.number().numberBetween(10,99);
	 String densityvalue = String.valueOf(randomint);
	 String basicCostValue = String.valueOf(randomint);
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
	 dashboard.clickoncommodityMaster();
  bentry.verifySavecommodityRmAndScrapWithSupplierItShouldAppearInBopEntryTab(commoditygroup, classification, specificgrade, densityvalue, basicCostValue); 
	 Thread.sleep(3000);
	 bentry.verifyfetchingDataFromCommodityDetailsToBopMaster(commoditygroup, classification);
	 
	 
	 
 }
 
 
 
 @Test(priority=11,groups="group1")
 public void TC_BOP_IH_011VerifyRmCostFieldIsNonEditable() throws InterruptedException {
	 
	 dashboard.selectMenuFormDashBoard("Master Data");
	 Thread.sleep(2000);
	 dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
 
		Thread.sleep(3000);
    	 bentry.verifyRmCostIsReadOnly();
	 
	 
	 
 }
 
 
	@Test(priority = 12, groups = "group1")
	public void TC_BOP_IH_012_VerifyExportShowsOnlyInhouseBops() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();

		Thread.sleep(3000);
		bentry.verifyAlldataMatchesInExcelSheetColom();

	} 
 
      @Test(priority=13,groups="group1")
      public void TC_BOP_IH_013ValidateExportedFileDataAgainstFrontendRecords() throws InterruptedException, IOException {
    	  

  		dashboard.selectMenuFormDashBoard("Master Data");
  		Thread.sleep(2000);
  		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();

  		Thread.sleep(3000);
 
        bentry.verifiyReadData();     	  
    	  
    	  
    	  
    	  
      }
	
	
	
	@Test(priority=14,groups="group1")
	public void TC_BOP_IH_015VerifyExportPromptAppears() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
  		Thread.sleep(2000);
  		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();

  		Thread.sleep(3000);
		
		bentry.verifytoastmsg ();
		
		
		
		
	}
	
	@Test(priority=15,groups="group1")
	public void TC_BOP_IH_018ImportFileWithMissingMandatoryFields() throws InterruptedException {
		
         int randomint = faker.number().numberBetween(10,99);
         String randomcode = faker.letterify("??");
         String Suppliercode = String.valueOf(randomint)+randomcode;
         String suppliername = faker.name().firstName()+faker.letterify("????");
		dashboard.selectMenuFormDashBoard("Master Data");
  		Thread.sleep(2000);
  		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();

  		Thread.sleep(3000);
		
  		bentry.importExcelfillMissingMandatoryField();
		
		
		
	}
	
	@Test(priority=16,groups="group1")
	public void TC_BOP_IH_019ImportFileWithInvalidDataTypes() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
  		Thread.sleep(2000);
  		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();

  		Thread.sleep(3000);
		bentry.importExcelFileWithInvalidDataType();
		
		
		
		
	}
	
 
	@Test(priority=17,groups="group1")
	public void TC_BOP_IH_021ImportFileWithDuplicateEntries() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();
  		Thread.sleep(3000);
  		bentry.verifyImportDuplicateData();
		
		
		
		
	}
	
	
	@Test(priority=18,groups="group1")
	public void TC_BOP_IH_023ImportFileWithInvalidDropdownValues() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();
  		Thread.sleep(3000);
		bentry.verifyImportInvalidDropdown();
		
		
		
		
		
	}
	
	
	@Test(priority=19,groups="group1")
	public void TC_BOP_IH_024ImportFileWithSpecialCharactersInPartNo() throws InterruptedException{
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();
  		Thread.sleep(3000);
		bentry.importWithInvalidPartNumeberExcelFile();
		
		
		
	}
	
	
	
	@Test(priority=20,groups="group1")
	public void TC_BOP_IH_026VerifyBopCategoryDefaultValueAsInhouse() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();
  		Thread.sleep(3000);
  		bentry.verifyDefaultValueinBopCategory();
		
		
	}
	
	
	@Test(priority=21,groups="group1")
	public void TC_BOP_IH_027VerifyUomDropdownBehavior() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();
  		Thread.sleep(3000);
		bentry.UomDropdownBehaviour();
		
		
		
		
		
	}
	
	
	@Test(priority=22,groups="group1")
	public void TC_BOP_IH_025VerifyBopTypeDropdownIsAlphabeticallySortedFromBopTypeTab() throws InterruptedException {
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		dashboard.clickingBopEntryTab();
  		Thread.sleep(3000);
		bentry.verifyBopTypeDropDown();
		
		
	}
	
	
	@Test(priority=23,groups="group1")
	public void TC_BOP_IH_029VerifyNumericOnlyValidationForGrossWtFinishWtProcessCostOtherCost() throws InterruptedException {
		
		String BopTypeName = faker.name().firstName()+faker.letterify("???><");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
  		bentry.verifyNumericValueEnteringBopTypeFirstTab(BopTypeName);
		
		
		
		
	}
	
	
	
	
	@Test(priority=24,groups="group1")
	public void TC_BOP_IH_030VerifyCommodityGroupDropdownFetchedFromCommodityMaster() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		bentry.fetchingCommodityDropdownfromCommodityMaster();
		
	}
	
	@Test(priority=25,groups="group1")
	public void TC_BOP_IH_031VerifyRmGroupClassificationDependentDropdown() throws InterruptedException {
		
		 String commoditygroup = faker.name().firstName()+faker.letterify("????");
		 String classification = faker.name().firstName()+faker.letterify("????");
		 String specificgrade = faker.name().firstName()+faker.letterify("????");
		 int randomint = faker.number().numberBetween(10,99);
		 String densityvalue = String.valueOf(randomint);
		 
		 dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
		 dashboard.clickoncommodityMaster();
		 bentry.verifyCommodityGroupClassificationDependencyForCustomer(commoditygroup, classification, specificgrade, densityvalue);

	}
	
	@Test(priority = 26, groups = "group1")
	public void TC_BOP_IH_032VerifyBehaviorOfSpecificGradeDropdownBasedOnDomesticYearlySelection()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		bentry.verifySpecificGradeDropDownValue();

	}
	
	
	
	@Test(priority=27,groups="group1")
	public void TC_BOP_IH_033VerifyRmRateKgAndScrapCostKgFetchFromCommodityMaster() throws InterruptedException {
		 String commoditygroup = faker.name().firstName()+faker.letterify("????");
		 String classification = faker.name().firstName()+faker.letterify("????");
		 String specificgrade = faker.name().firstName()+faker.letterify("????");
		 int randomint = faker.number().numberBetween(10,99);
		 String densityvalue = String.valueOf(randomint);
		 String basicCostValue = String.valueOf(randomint);
		 
		 dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
		 dashboard.clickoncommodityMaster();
		
		bentry.verifySavecommodityRmAndScrapWithCustomerItShouldAppearInBopEntryTab(commoditygroup, classification, specificgrade, densityvalue, basicCostValue);
		
		
	}
	
	
	@Test(priority=28,groups="group1")
	public void TC_BOP_IH_034VerifyRmCostFieldIsFrozen() throws InterruptedException {
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		bentry.RmFieldFrozenOrNot();
		
		
		
		
		
	}
	
	
	@Test(priority=30,groups="group1")
	public void TC_BOP_IH_037VerifyAddSupplierFunctionality() throws InterruptedException {
		
		String randomname = faker.name().firstName()+faker.letterify("????");
		double randomint = faker.number().randomDouble(2,10, 99);
		String customercode = String.valueOf(randomint); 

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		
		bentry.verifyCustomerAddCustomerFunctionality(customercode, randomname);
		
	}
	
	@Test(priority=30,groups="group1")
	public void TC_BOP_IH_038VerifyResetButtonClearsData() throws InterruptedException {
		

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		
		bentry.verifyResetButtonFuctionality();
		
		
	}
	
	
	@Test(priority=31,groups="group1")
	public void TC_BOP_IH_043VerifyExportSuccessPrompt() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		bentry.verifyExportprompt();
		
		
	}
	
	@Test(priority=32,groups="group1")
	public void TC_BOP_IH_045VerifyFileNamingConventionDuringExport() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
		bentry.verifyFileNamingConvention();
		
		
		
		
	}
	
    @Test(priority=33,groups="group1")
    public void TC_BOP_IH_046ImportWithMissingMandatoryFields() throws InterruptedException {
	 
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
  		Thread.sleep(2000);
 
  		dashboard.clickingBopEntryTab();
           		
		Thread.sleep(2000);
	 
		bentry.importWithMissingField();
	 
	 
	 
     }
	
	
	
	
	
	
	
	
	
	
	
	
 
}










