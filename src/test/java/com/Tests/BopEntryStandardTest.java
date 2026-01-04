package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.BopEntryStandardPage;
import com.Pages.ControlMasterPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class BopEntryStandardTest extends Base {

    LoginPage login;
    DashboardPage dashboard;
    BopEntryStandardPage BentryPage;
    ControlMasterPage control;
    Faker faker = new Faker();
    
    
    @BeforeGroups(groups = {"group1", "group2", "group3", "group4", "group5"})
    public void verifyLoginPage() {
        launchApplication();
        dashboard=new DashboardPage();
        login = new LoginPage();
        BentryPage=new BopEntryStandardPage();
        control = new ControlMasterPage();
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterGroups(groups = {"group1", "group2", "group3", "group4", "group5"})
    public void verifyQuitApplication() {
        LoggerUtil.logger.info("Closing browser after grouped test execution...");
        if (driver != null) {
            driver.quit();
        }
    }

   @Test(priority=1,groups="group1")
   public void TC_BOP_001VerifyPlaceholderForDropDownFields() throws InterruptedException {
	   dashboard.clickingDashboard("Dashboard");
	 dashboard.selectMenuFormDashBoard("Master Data");
	 Thread.sleep(3000);
	 dashboard.selectBopMaster();
	 Thread.sleep(3000);
	 dashboard.clickingBopEntryTab();
	 Thread.sleep(2000);
	 BentryPage. verifyDropdownPlaceholders();
	 BentryPage.verifyDifferentTypePlaceHolders();
	 dashboard.clickingDashboard("Dashboard");
	 Thread.sleep(4000);
	 
   
   }
    
    
  @Test(priority=2,groups="group1")
  public void TC_BOP_002VerifyPlaceholderForManualEntryFields() throws InterruptedException {
	  dashboard.clickingDashboard("Dashboard");
	     dashboard.selectMenuFormDashBoard("Master Data");
		 Thread.sleep(3000);
		 
		 Thread.sleep(3000);
		 dashboard.selectBopMaster();
		 Thread.sleep(3000);
		 dashboard.clickingBopEntryTab();
		 Thread.sleep(2000);
	     BentryPage.verifyManualEntry();
	     dashboard.clickingDashboard("Dashboard");
	     
	  
	  
	  
  }
    
	@Test(priority = 3, groups = "group1")
	public void TC_BOP_003VerifyMandatoryFieldsMarkedWithAstricMarks() throws InterruptedException {
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifyAstricMarkIsAvailable();
		Thread.sleep(3000);
		 dashboard.clickingDashboard("Dashboard");
	}
    
    
    
    @Test(priority=4,groups="group1")
    public void TC_BOP_004VerifyBopTypeDropdownIsAlphabeticallySorted() throws InterruptedException {
    	 dashboard.clickingDashboard("Dashboard");
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
    	BentryPage.verifySortingFunctionalityBoptype();
    	Thread.sleep(3000);
    	 dashboard.clickingDashboard("Dashboard");
    	
    }
    
    @Test(priority=5,groups="group1")
    public void TC_BOP_005VerifyUomDropdownBehavior() throws InterruptedException {
    	 dashboard.clickingDashboard("Dashboard");
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);	
		BentryPage.verifyUomDropDownBehaviour();
    	Thread.sleep(3000);
    	 dashboard.clickingDashboard("Dashboard");
    }
    
    
    
    @Test(priority=6,groups="group1")
    public void TC_BOP_006VerifySupplierDropdownBehavior() throws InterruptedException {
    	
    	faker.number().numberBetween(10, 99);
    	double randominteger = faker.number().randomDouble(2, 50, 1000);
    	String suppliercode = String.valueOf(randominteger);
    	
    	String suppliername = "AAAA"+faker.name().firstName()+faker.letterify("????");
    	 dashboard.clickingDashboard("Dashboard");
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);	
    	
    	BentryPage.verfiySupplierSearchFunctionality(suppliercode,suppliername);
    	BentryPage.verifySuppliernameAreExistOrnot(suppliername+"-"+suppliercode);
    	Thread.sleep(3400);
    	 dashboard.clickingDashboard("Dashboard");
    }
    
    
    @Test(priority=7,groups="group1")
    public void TC_BOP_007VerifyCurrencyDropdownBehavior() throws InterruptedException {
    	 dashboard.clickingDashboard("Dashboard");
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);	

    	BentryPage.verifyCurrencyvalue();
    	Thread.sleep(3000);
    	 dashboard.clickingDashboard("Dashboard");
    	
    	
    }
    
    
    
    @Test(priority=8,groups="group1")
    public void TC_BOP_009VerifyNumericValidationForCostRelatedFields() throws InterruptedException {
    	
        int randomint = faker.number().numberBetween(1000, 9999);
        String randomName = faker.name().firstName()+faker.letterify("??");
        String partnumber = randomName+"-"+String.valueOf(randomint);
        String partDescription =randomName; 
    	String BopTypeName = faker.name().firstName()+faker.letterify("????");
    	String partcostvalue = faker.name().firstName()+faker.letterify("????");
    	String dutiesvalue = faker.name().firstName()+faker.letterify("????");
    	String frieghtinsurancevalue = faker.name().firstName()+faker.letterify("????");
    	 dashboard.clickingDashboard("Dashboard");
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		
        BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
        Thread.sleep(3000);
        dashboard.clickingBopEntryTab();
		Thread.sleep(2000);	
        BentryPage.entervalueAndVerifyNumericalValidation(BopTypeName,partDescription, partnumber,partcostvalue, dutiesvalue,frieghtinsurancevalue);
        Thread.sleep(3000);
        dashboard.clickingDashboard("Dashboard");
    }
    
    
    
    
    @Test(priority=9,groups="group1")
    public void TC_BOP_010VerifySuccessfulBopSave() throws InterruptedException {
    	
    	  int randomint = faker.number().numberBetween(1000, 9999);
    	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
          String randomName = faker.name().firstName()+faker.letterify("??");
          String partnumber = randomName+"-"+String.valueOf(randomint);
          String partDescription =randomName; 
    	String BopTypeName = faker.name().firstName()+faker.letterify("????");
    	String partcostvalue = String.valueOf(valueoftwodigit);
    	String dutiesvalue = String.valueOf(valueoftwodigit);
    	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
    	 dashboard.clickingDashboard("Dashboard");
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		
        BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
        Thread.sleep(3000);
        dashboard.clickingBopEntryTab();
		Thread.sleep(2000);	
        BopEntryStandardPage.SaveBopWithStandard(BopTypeName, partDescription, partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue,BopTypeName);	
    	
        dashboard.clickingDashboard("Dashboard");
       
    	
    	
    }
    
    
	@Test(priority = 10, groups = "group1")
	public void TC_BOP_012VerifyEditBopFunctionality() throws InterruptedException {
		String randomName = faker.name().firstName() + faker.letterify("??");
		String BopTypeName = faker.name().firstName() + faker.letterify("????");
		String BopTypeName1 = faker.name().firstName() + faker.letterify("????");
		int randomint = faker.number().numberBetween(1000, 9999);
		double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
		double secondvalueoftwodigit = faker.number().randomDouble(2, 10, 99);
		double thirdvalueoftwodigit = faker.number().randomDouble(2, 10, 99);
		String partnumber = randomName + "-" + String.valueOf(randomint);
		String updateddutiesvalue = String.valueOf(secondvalueoftwodigit);
		String updatedfrieghtinsurancevalue = String.valueOf(thirdvalueoftwodigit);
		String partDescription = randomName;
		String partcostvalue = String.valueOf(valueoftwodigit);
		String dutiesvalue = String.valueOf(valueoftwodigit);
		String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);

		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		driver.navigate().refresh();
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName1);
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.SaveBopWithStandardForUpdate(BopTypeName, partDescription, partnumber, partcostvalue, dutiesvalue,
				frieghtinsurancevalue, BopTypeName, BopTypeName1,updateddutiesvalue,updatedfrieghtinsurancevalue);
		 dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
	}
    
	
	@Test(priority=11,groups="group1")
	public void TC_BOP_013VerifyUpdateRestrictionForDuplicatePartNo() throws InterruptedException {
		String randomName = faker.name().firstName() + faker.letterify("??");
		String randomName1 = faker.name().firstName() + faker.letterify("??");
		String BopTypeName = faker.name().firstName() + faker.letterify("????");
		String BopTypeName1 = faker.name().firstName() + faker.letterify("????");
		int randomint = faker.number().numberBetween(1000, 9999);
		int randomintfopart = faker.number().numberBetween(100000, 9999999);
		double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
		double valueofthreedigit = faker.number().randomDouble(3, 10, 99);
		double secondvalueoftwodigit = faker.number().randomDouble(2, 10, 99);
		double thirdvalueoftwodigit = faker.number().randomDouble(2, 10, 99);
		String partnumber = randomName + "-" + String.valueOf(randomint);
		String.valueOf(randomintfopart);
		String.valueOf(secondvalueoftwodigit);
		String.valueOf(thirdvalueoftwodigit);
		String partDescription = randomName;
		String partDescription1 = randomName1;
		String partcostvalue = String.valueOf(valueoftwodigit);
		String partcostvalue1 = String.valueOf(valueofthreedigit);
		String dutiesvalue = String.valueOf(valueoftwodigit);
		String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		driver.navigate().refresh();
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName1);
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.SaveBopTypeForParticularPartNumber(BopTypeName, partDescription, partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue, BopTypeName);
		Thread.sleep(2999);
		BentryPage.verifyupdaterestrictionforduplicateSave(BopTypeName,BopTypeName1, partDescription1, partnumber, partcostvalue1, dutiesvalue, frieghtinsurancevalue, BopTypeName1);
	    Thread.sleep(3000);
	   
	  
	     
	}
	
	
	
	@Test(priority=15,groups="group1")
	public void TC_BOP_014VerifyAddSupplierFunctionality() throws InterruptedException {
		String suppliername = faker.name().firstName()+faker.letterify("????");
		int randomint = faker.number().numberBetween(10,99999999);
		String suppliercode = String.valueOf(randomint);
		 dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		
		BentryPage.verifyEnterSuppliername(suppliercode,suppliername);
		
		Thread.sleep(3000);
		 dashboard.clickingDashboard("Dashboard");
		
	}
	
	@Test(priority=16,groups="group1")
	public void TC_BOP_015VerifyResetButtonFunctionality() throws InterruptedException {
		
		faker.name().firstName();
		faker.letterify("????");
		int randomint = faker.number().numberBetween(10,99999999);
		String.valueOf(randomint);
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifyResetButtonFunctionality();
		dashboard.clickingDashboard("Dashboard");}
		
	
	
	
	@Test(priority=17,groups="group1")
	public void TC_BOP_016VerifySaveAsNewBopFunctionality() throws InterruptedException {
		 int randomint = faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         String randomName1 = faker.name().firstName()+faker.letterify("??");
         String partnumber = randomName+"-"+String.valueOf(randomint);
         String SaveAsNewPartnumber = randomName1+"-"+String.valueOf(randomint1);
         String partDescription =randomName; 
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	String BopTypeName1 = faker.name().firstName()+faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
   	dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName1);

		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifySaveAsnewBopFunctionality(BopTypeName, partDescription, partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue,BopTypeName,SaveAsNewPartnumber,BopTypeName1,BopTypeName1);
		dashboard.clickingDashboard("Dashboard");
		
		
		
	}
	
	
	
	@Test(priority=18,groups="group1")
	public void TC_BOP_017VerifyUniquenessInSaveAsNew() throws InterruptedException {
		
		 int randomint = faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
   	 double valueoftwodigit1 = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         String randomName1 = faker.name().firstName()+faker.letterify("??");
         String partnumber = randomName+"-"+String.valueOf(randomint);
         String.valueOf(randomint1);
         String partDescription =randomName; 
         String newpartdescriptionvalue = randomName1;
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	String BopTypeName1 = faker.name().firstName()+faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String newpartcostvalue = String.valueOf(valueoftwodigit1);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String newdutiesvalue = String.valueOf(valueoftwodigit1);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
	String newfrieghtinsurancevalue = String.valueOf(valueoftwodigit1);
	dashboard.clickingDashboard("Dashboard");
	Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName1);
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.saveBopTypeAndSaveAgainWithSamePartNoAndSupplierName(BopTypeName,partDescription,partnumber,partcostvalue,dutiesvalue,frieghtinsurancevalue,BopTypeName1,newpartdescriptionvalue,newpartcostvalue,newdutiesvalue,newfrieghtinsurancevalue);
		dashboard.clickingDashboard("Dashboard");
		
	}
	
	@Test(priority=19,groups="group1")
	public void TC_BOP_018VerifyExportFunctionality() throws InterruptedException {
		

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.VerifyExportButton();
		dashboard.clickingDashboard("Dashboard");
		
		
		
		
		
		
	}
	
	
	
	@Test(priority=20,groups="group1")
	   public void TC_BOP_020VerifyImportFunctionalityWithValidFile() throws InterruptedException{
		
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifyimportexcelfile();
		dashboard.clickingDashboard("Dashboard");
	
		
	}
	
	
	
	
	@Test(priority=21,groups="group1")
	public void TC_BOP_021VerifyImportFunctionalityWithInvalidFile() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifyImportInvalidExcelFile();
		dashboard.clickingDashboard("Dashboard");
		
		
	}
	
	
	
	
	
	@Test(priority = 23, groups = "group1")
	public void TC_BOP_025VerifyPaginationForLargeBopData() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);	
		BentryPage.verifPagination();
		dashboard.clickingDashboard("Dashboard");
		 
	}
	
	
	
	@Test(priority=24,groups="group1")
	public void TC_BOP_026VerifySavingSameBopForTwoDifferentSuppliers() throws InterruptedException {
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String suppcode = String.valueOf(randDouble);
		double randDouble1 = faker.number().randomDouble(2, 100,1000);
		String suppcode1 = String.valueOf(randDouble1);
		String suppname = faker.name().firstName()+faker.letterify("???????");
		String partdescription = faker.name().firstName()+faker.letterify("???????");
		String partnumber = faker.name().firstName()+faker.letterify("???????")+suppcode;
		String suppname1 = faker.name().firstName()+faker.letterify("???????");
		String BopTypename = faker.name().firstName()+faker.letterify("?????");
		String partcostunit = String.valueOf(randDouble);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypename);
		driver.navigate().refresh();
		Thread.sleep(3000);	
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		BentryPage.verifAddsupplier(suppcode,suppname);
		Thread.sleep(2000);
		BentryPage.verifAddsupplier(suppcode1,suppname1);
		BentryPage.saveBopForDifferentSupplier(BopTypename,partdescription,partnumber,partcostunit,suppname);
		Thread.sleep(3000);
		BentryPage.saveBopForDifferentSupplier(BopTypename,partdescription,partnumber,partcostunit,suppname1);
		
		dashboard.clickingDashboard("Dashboard");
		
	}
	
	@Test(priority=25,groups="group1")
	public void TC_BOP_027VerifySavingSameBopForSameCustomerAndSupplier() throws InterruptedException {
		
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String suppcode = String.valueOf(randDouble);
		double randDouble1 = faker.number().randomDouble(2, 100,1000);
		String.valueOf(randDouble1);
		String suppname = faker.name().firstName()+faker.letterify("???????");
		String partdescription = faker.name().firstName()+faker.letterify("???????");
		String partnumber = faker.name().firstName()+faker.letterify("???????")+suppcode;
		faker.name().firstName();
		faker.letterify("???????");
		String BopTypename = faker.name().firstName()+faker.letterify("?????");
		String partcostunit = String.valueOf(randDouble);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypename);
		driver.navigate().refresh();
		Thread.sleep(3000);	
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		BentryPage.verifAddsupplier(suppcode,suppname);
		Thread.sleep(2000);
		
		BentryPage.saveBopWithSupplier(BopTypename,partdescription,partnumber,partcostunit,suppname);
		Thread.sleep(2000);
		BentryPage.verifySavingAddCustomer(suppcode, suppname);
		Thread.sleep(2000);
		BentryPage.saveBopWithCustomer(BopTypename, partdescription, partnumber, partcostunit, suppname);
		
		dashboard.clickingDashboard("Dashboard");
		
	}
	
	@Test(priority=26,groups="group1")
	public void TC_BOP_028VerifyCompanySpecificDeltaEntry() throws InterruptedException {
		
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String dutiesvlaue = String.valueOf(randDouble);
		int randomint = faker.number().numberBetween(10, 10000);
		String deltavalue = String.valueOf(randomint);
		String frieghtinsurancevalue = String.valueOf(randDouble);
		String suppcode = String.valueOf(randDouble);
		double randDouble1 = faker.number().randomDouble(2, 100,1000);
		String.valueOf(randDouble1);
		faker.name().firstName();
		faker.letterify("???????");
		String partdescription = faker.name().firstName()+faker.letterify("???????");
		String partnumber = faker.name().firstName()+faker.letterify("???????")+suppcode;
		faker.name().firstName();
		faker.letterify("???????");
		String BopTypename = faker.name().firstName()+faker.letterify("?????");
		String partcostunit = String.valueOf(randDouble);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypename);
		driver.navigate().refresh();
		Thread.sleep(3000);	
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		BentryPage.verifyCompanySpecificDeltaValue(BopTypename, partdescription, partnumber, partcostunit, deltavalue,dutiesvlaue,frieghtinsurancevalue);
		
		dashboard.clickingDashboard("Dashboard");
		
		
	}
	
	@Test(priority=27,groups="group1")
	public void TC_BOP_029VerifyExportFunctionalityOnlyStandardBopParts() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(300);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		BentryPage.verifyExportData();
		
		dashboard.clickingDashboard("Dashboard");
		
		
	}
	
	
	@Test(priority=28,groups="group1")
	public void TC_BOP_030ValidateExportedDataMatchesFrontendTable() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		BentryPage.verifyReadAndCompareDataFromUiAndExcel();
		
		dashboard.clickingDashboard("Dashboard");
		 
		
		
		
	}
	
	
	@Test(priority=29,groups="group1")
	public void TC_BOP_032VerifyPromptOnSuccessfulExport() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(4000);
		dashboard.clickingDashboard("Dashboard");
		
		
			
	}
	
	@Test(priority=30,groups="group1")	
	public void TC_BOP_033VerifyFileImportAndUpdateRecords() throws InterruptedException{
		Faker faker = new Faker ();
		String BopTypename = faker.name().firstName()+faker.letterify("?????");
		String BopTypename1 = faker.name().firstName()+faker.letterify("?????");
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String suppcode = String.valueOf(randDouble);
		double randDouble1 = faker.number().randomDouble(2, 100,1000);
		String.valueOf(randDouble1);
		faker.name().firstName();
		faker.letterify("???????");
		String partdescription = faker.name().firstName()+faker.letterify("???????");
		String partnumber = faker.name().firstName()+faker.letterify("???????")+suppcode;
		faker.name().firstName();
		faker.letterify("???????");
		
		String partcostunit = String.valueOf(randDouble);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypename);
		Thread.sleep(6000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypename1);
		driver.navigate().refresh();
		dashboard.clickingBopEntryTab();
		BentryPage.verifyModifyBoptypeInExcelSheetAndImport(BopTypename,partdescription,partnumber,partcostunit,BopTypename1);
		dashboard.clickingDashboard("Dashboard");
		 
	}
	
	
	@Test(priority=31,groups="group1")
	public void TC_BOP_036VerifyExportedFileNamingConvention() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		BentryPage.verifyFileNamingConvention();
		
		dashboard.clickingDashboard("Dashboard");
		 
		
		
		
		
	}
	
	
	
	@Test(priority=32,groups="group1")
	public void TC_BOP_037VerifyImportWithMissingMandatoryFields() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		BentryPage.verifyImpotDataWithMissingField();
		
		
		dashboard.clickingDashboard("Dashboard");
		
		
		
		
	}
	
	
	
	@Test(priority=33,groups="group1")
	public void TC_BOP_040VerifyHandlingOfDuplicateEntriesDuringImport() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		
		BentryPage.verifyhandlingDuplicateEntries();
		dashboard.clickingDashboard("Dashboard");
	}
	
	
	
	@Test(priority=34,groups="group1")
	public void TC_BOP_042VerifySpecialCharacterHandlingDuringImport() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(3000);
		BentryPage.importSpecialCharacteInpartnumber();
		dashboard.clickingDashboard("Dashboard");
		
		
		
	}
	
	@Test(priority=35,groups="group1")
	public void TC_BOP_044VerifyPartCostUnitDutiesFreightAcceptOnlyNumeric() throws InterruptedException {
		Faker faker = new Faker ();
		String BopTypename = faker.name().firstName()+faker.letterify("?????");
		faker.name().firstName();
		faker.letterify("?????");
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String suppcode = String.valueOf(randDouble);
		double randDouble1 = faker.number().randomDouble(2, 100,1000);
		String.valueOf(randDouble1);
		faker.name().firstName();
		faker.letterify("???????");
		String partdescription = faker.name().firstName()+faker.letterify("???????");
		String partnumber = faker.name().firstName()+faker.letterify("???????")+suppcode;
		faker.name().firstName();
		faker.letterify("???????");
		String partcostvalue = faker.name().firstName()+faker.letterify("????");
		String dutiesvalue = faker.name().firstName()+faker.letterify("????");
    	String frieghtinsurancevalue = faker.name().firstName()+faker.letterify("????");
    	dashboard.clickingDashboard("Dashboard");
    	Thread.sleep(2000);
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypename);
		Thread.sleep(6000);
	
		dashboard.clickingBopEntryTab();
		driver.navigate().refresh();
		Thread.sleep(6000);
		BentryPage.verifyPartCostUnitDutiesFreightAcceptOnlyNumeric(BopTypename, partdescription, partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue);
		
		dashboard.clickingDashboard("Dashboard");
		
	}
	
	
	@Test(priority=36,groups="group1")
	public void TC_BOP_049VerifyAddCustomerFunctionality() throws InterruptedException {
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String customername = faker.name().firstName()+faker.letterify("?????");
		String CustomerCode = String.valueOf(randDouble);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		driver.navigate().refresh();
		Thread.sleep(6000);
		
		BentryPage.verifyAddNewCustomerFunctionality(CustomerCode, customername);
		dashboard.clickingDashboard("Dashboard");
		
	}
	
	
	@Test(priority=37,groups="group1")
	public void TC_BOP_050VerifyResetFunctionalityAfterAddCustomer() throws InterruptedException {
		double randDouble = faker.number().randomDouble(2, 100,1000);
		String customername = faker.name().firstName()+faker.letterify("?????");
		String CustomerCode = String.valueOf(randDouble);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		dashboard.clickingBopEntryTab();
		driver.navigate().refresh();
		Thread.sleep(6000);
		BentryPage.verifyRestFunctionality(CustomerCode, customername);
		
		dashboard.clickingDashboard("Dashboard");
		
		
	}
	
	@Test(priority=38,groups="group1")
	public void TC_BOP_051VerifySaveAsNewCreatesUniqueEntry() throws InterruptedException {
		
		
		 int randomint = faker.number().numberBetween(1000, 9999);
		 faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         String randomName1 = faker.name().firstName()+faker.letterify("??");
         String partnumber = randomName+"-"+String.valueOf(randomint);
         String SaveAsNewPartnumber = randomName1+"-"+String.valueOf(randomint1);
         String partDescription =randomName; 
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	String BopTypeName1 = faker.name().firstName()+faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
   	dashboard.clickingDashboard("Dashboard");
   	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName1);

		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.SaveAsNewWithUniqueBopTypeAndWithUniquePartNoWithPriviousSupplierNames(BopTypeName,partDescription,partnumber,partcostvalue,dutiesvalue,frieghtinsurancevalue,BopTypeName1,SaveAsNewPartnumber);
	
		dashboard.clickingDashboard("Dashboard");
		
	
	}
	
	
	
	
	
	
	@Test(priority=41,groups="group1")
	public void TC_BOP_056VerifySaveValidationWithoutMandatoryFieldsWithoutPartNumber() throws InterruptedException {
		 int randomint = faker.number().numberBetween(1000, 9999);
		 faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         String.valueOf(randomint);
         String.valueOf(randomint1);
         String partDescription =randomName; 
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	faker.name().firstName();
	faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
   	dashboard.clickingDashboard("Dashboard");
   	Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		 dashboard.clickingBopEntryTab();
			Thread.sleep(2000);	
		BentryPage.SaveBopWithStandardWithoutPartNumber(BopTypeName, partDescription, "", partcostvalue, dutiesvalue, frieghtinsurancevalue,BopTypeName);	
		dashboard.clickingDashboard("Dashboard");
	
		
		
		
	}
	@Test(priority=41,groups="group1")
	public void TC_BOP_056VerifySaveValidationWithoutMandatoryFieldsWithoutBopType() throws InterruptedException {
		 int randomint = faker.number().numberBetween(1000, 9999);
		 faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         String partnumber = randomName+"-"+String.valueOf(randomint);
         String.valueOf(randomint1);
         String partDescription =randomName; 
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	faker.name().firstName();
	faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
   	dashboard.clickingDashboard("Dashboard");
   	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		 dashboard.clickingBopEntryTab();
			Thread.sleep(2000);	
		BentryPage.SaveBopWithStandardWithoutBopType( partDescription,partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue,BopTypeName);	
		
		dashboard.clickingDashboard("Dashboard");
		
		
		
	}
	
	
	@Test(priority=41,groups="group1")
	public void TC_BOP_056VerifySaveValidationWithoutMandatoryFieldsWithoutUOM() throws InterruptedException {
		 int randomint = faker.number().numberBetween(1000, 9999);
		 faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         String partnumber = randomName+"-"+String.valueOf(randomint);
         String.valueOf(randomint1);
         String partDescription =randomName; 
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	faker.name().firstName();
	faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);

   	dashboard.clickingDashboard("Dashboard");
   	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		 dashboard.clickingBopEntryTab();
			Thread.sleep(2000);	
		BentryPage.SaveBopWithStandardWithoutUOM( BopTypeName,partDescription,partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue,BopTypeName);	
		
		dashboard.clickingDashboard("Dashboard");
		 
		
		
	}
	
	
	@Test(priority=41,groups="group1")
	public void TC_BOP_056VerifySaveValidationWithoutMandatoryFieldsWithoutSupplier() throws InterruptedException {
		 int randomint = faker.number().numberBetween(1000, 9999);
		 faker.number().numberBetween(1000, 9999);
		 int randomint1 = faker.number().numberBetween(1000, 9999);
   	  double valueoftwodigit = faker.number().randomDouble(2, 10, 99);
         String randomName = faker.name().firstName()+faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         faker.name().firstName();
		faker.letterify("??");
         String partnumber = randomName+"-"+String.valueOf(randomint);
         String.valueOf(randomint1);
         String partDescription =randomName; 
   	String BopTypeName = faker.name().firstName()+faker.letterify("????");
   	faker.name().firstName();
	faker.letterify("????");
   	String partcostvalue = String.valueOf(valueoftwodigit);
   	String dutiesvalue = String.valueOf(valueoftwodigit);
   	String frieghtinsurancevalue = String.valueOf(valueoftwodigit);
   	dashboard.clickingDashboard("Dashboard");
   	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
	
		BopEntryStandardPage.enterCreateBoptyeInFirstTab(BopTypeName);
		Thread.sleep(5000);
		 dashboard.clickingBopEntryTab();
			Thread.sleep(2000);	
		BentryPage.SaveBopWithStandardWithoutSupplier( BopTypeName,partDescription,partnumber, partcostvalue, dutiesvalue, frieghtinsurancevalue,BopTypeName);	
		
		dashboard.clickingDashboard("Dashboard");
		
		
		
	}
	
	
	
	@Test(priority=42,groups="group1")
	public void TC_BOP_053VerifyUserAuthorizationSupplierOnly() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
	
		dashboard.clickOnControlMaster();
		Thread.sleep(3000);
		dashboard.clickOnusermaster();
		control.verifyUncheckSupplierButton();
		Thread.sleep(3000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifyUserUncheckSupplierControlAuthority();
		
		dashboard.clickingDashboard("Dashboard");
		
		
	}
	
	@Test(priority=43,groups="group1")
	public void TC_BOP_054VerifyUserAuthorizationCustomerOnly() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
	
		dashboard.clickOnControlMaster();
		Thread.sleep(3000);
		dashboard.clickOnusermaster();
		control.VerifyUncheckCustomerButton();
		Thread.sleep(7000);
		dashboard.selectBopMaster();
		Thread.sleep(3000);
		dashboard.clickingBopEntryTab();
		Thread.sleep(2000);
		BentryPage.verifyUserUncheckCustomerControlAuthority();

		
		dashboard.clickingDashboard("Dashboard");
		
      		
		
		
	}
	@Test(priority=44,groups="group1")
	public void TC_BOP_024VerifySaveUpdateButtonsEnabledBasedOnRights() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);		
		dashboard.clickOnControlMaster();
		Thread.sleep(2000);
		dashboard.clickOnusermaster();
        Thread.sleep(5000);
        control.VerifyUserAuthorityUncheckedReadAndWriteForBopMaster();
        Thread.sleep(3000);
        dashboard.selectBopMaster();
        Thread.sleep(2000);
        dashboard.clickingBopEntryTab();
        Thread.sleep(3000);
        BentryPage.verifySaveButtonVisiblity();
        
        dashboard.clickingDashboard("Dashboard");
   	
		
		
		
	}
	@Test(priority=45,groups="group1")
	public void TC_BOP_024VerifySaveUpdateButtonsEnabledBasedOnRightsForAddSupplier() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);		
		dashboard.clickOnControlMaster();
		Thread.sleep(2000);
		dashboard.clickOnusermaster();
        Thread.sleep(5000);
        control.VerifyUserAuthorityUncheckedReadAndWriteForBopMaster();
        Thread.sleep(3000);
        dashboard.selectBopMaster();
        Thread.sleep(2000);
        dashboard.clickingBopEntryTab();
        Thread.sleep(3000);
        BentryPage.verifySaveButtonVisibilityOfAddSupplier();
        
		
        dashboard.clickingDashboard("Dashboard");
   	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
