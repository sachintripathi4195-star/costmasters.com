package com.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.CommodityDetailsPage;
import com.Pages.Commodity_AddCostingPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;
@Listeners(com.helper.TestListeners.class)
public class Commodity_AddCostingTest extends Base {


	LoginPage login;
	DashboardPage dashboard;
	CommodityDetailsPage comd;
	Commodity_AddCostingPage comad;
	Faker faker = new Faker();

	String randomName = faker.name().firstName();
	String randomName1 = faker.name().firstName();
	String randomName2 = faker.name().firstName();
	String randomName3 = faker.name().firstName();
	int randomNumber = faker.number().numberBetween(1000, 9999);
	int randomNumberNegative = -faker.number().numberBetween(1000, 9999);
	double randomNumber2 = faker.number().randomDouble(3,1,100);
	@BeforeGroups(groups = {"group1", "group2", "group3"})
	public void loginGroup() throws InterruptedException {
		Base.launchApplication();

		login = new LoginPage();
		dashboard = new DashboardPage();   
		comd = new CommodityDetailsPage();
		comad = new Commodity_AddCostingPage();

		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(7000);
		LoggerUtil.info("Logged in once before the group test cases.");
	}

	@AfterGroups(groups = {"group1", "group2", "group3"})
	public void logoutGroup() {
		driver.quit();
		LoggerUtil.info("Logged out after the group test cases.");
	}	



	@Test(priority=1,groups="group1")
	public void TC_CE_001_SaveNewCastingElement() throws InterruptedException {
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);
		comad.savedata(randomName,randomName,randomName);



	}


	@Test(priority=2,groups="group1")
	public void TC_CE_002SaveAsNewCastingElement() throws InterruptedException {
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		comad.saveasnew(randomName,randomName,randomName,randomName1,randomName1);	




	}

	@Test(priority=3,groups="group1")
	public void TC_CE_003SearchCastingElement() throws InterruptedException {
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
        comad.verifysearchfilter(randomName, randomName1, randomName);



	}

   @Test(priority=4,groups="group1")
   public void TC_CE_004EditAndUpdateExistingCastingElement() throws InterruptedException {
	   String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
	   
	   Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	  
	   comad.verifyupdatebtn(randomName, randomName1, randomName, randomName1, randomName);
	   
	   
	   
   }
   
	@Test(priority=5,groups="group1")
	public void TC_CE_005PaginationValidationInTable() throws InterruptedException {
		
		
		
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	  
		comad.verifypagination();	
	}
	
	@Test(priority=6,groups="group1")
	public void TC_CE_006_TotalCountValidationInViewTable() throws InterruptedException {
		
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	  
		comad.verifytotalcountrow("25");
		
		
		
	}
	
	
	@Test(priority=6,groups="group1")
	public void TC_CE_006_TotalCountValidationInViewTable50() throws InterruptedException {
		
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	  
		comad.verifytotalcountrow50("50");
		
		
		
	}
	
	@Test(priority=6,groups="group1")
	public void TC_CE_006_TotalCountValidationInViewTable75() throws InterruptedException {
		
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	  
		comad.verifytotalcountrow50("75");
		
		
		
	}
	
	@Test(priority=7,groups="group1")
	public void TC_CE_010EditAllDataShouldAppearAfterClickingEdit() throws InterruptedException {
		

		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	  
		comad.verifyeditbtn();
		
		

	}

	
	@Test(priority=8,groups="group1")
	public void TC_CE_011InvalidCharactersRestrictionInFields() throws InterruptedException {
		
		

		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		
		comad.number(String.valueOf(randomNumber), String.valueOf(randomNumber),"ivalid input");
		
		
		
	}
	
	@Test(priority=9,groups="group1")
	public void TC_CE_007DeleteCastingElementAfterNewSave() throws InterruptedException {
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
        dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		
		comad.deletenewsavecatingvalue(randomName, randomName, randomName,"Casting Elements Deleted Successfully");
		
		
		
		
	}
	

	@Test(priority=10,groups="group1")
	public void TC_CE_008DeleteCastingElementAfterSaveAsNew() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
		 dashboard.selectMenuFormDashBoard("Master Data");
			
			dashboard.clickoncommodityMaster();
			
			dashboard.clickadcastingtab();
			Thread.sleep(3000);	
		comad.saveasnewandDelete(randomName,randomName,randomName,randomName1,randomName1);
		
		
	
		
	}
	
	
	@Test(priority=11,groups="group1")
	public void TC_CE_012DuplicateCastingElementSaveCheck() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
		   dashboard.selectMenuFormDashBoard("Master Data");
		   
			dashboard.clickoncommodityMaster();
			
			dashboard.clickadcastingtab();
			Thread.sleep(3000);	
		    comad.verifyexisistingdatasaveornot(randomName, randomName, randomName, randomName,"Casting Elements Group Already Saved");
		 
		
		
		
		
		
	}
	
	@Test(priority=12,groups="group1")
	public void TC_CE_013_SaveNewCastingElementAndValidateInOnlineRecords() throws InterruptedException {
		
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
		 dashboard.selectMenuFormDashBoard("Master Data");
		   
			dashboard.clickoncommodityMaster();
			
			dashboard.clickadcastingtab();
			Thread.sleep(3000);	
		
		   comad.savedatahassavedasitisOrnot(randomName,randomName,randomName);
		
		
		
		
	}
	
	@Test(priority=13,groups="group1")
	public void TC_CE_015PromptAfterSaveSuccess() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);
		comad.validatepromptmessage(randomName, randomName, "Casting Elements Saved Successfully");
		
		
		
		
	}
	
	
	
	
	@Test(priority=14,groups="group1")
	public void TC_CE_016_PromptOnAlreadyExistingCastingElementSave() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		comad.verifyexistingdatasaveornot(randomName, randomName, randomName, randomName, "Casting Elements Group Already Saved");
		
	
		
	}
	
	@Test(priority=15,groups="group1")
	public void TC_CE_017PromptOnDeletewithDependency() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		
		comad.verifydeletedependenciesdata("ICC","Can't be deleted Casting Element due to dependent data");
		
		
		
//		Can't be deleted Casting Element due to dependent data
		
	}
	
	@Test(priority=16,groups="group1")
	public void TC_CE_018PromptOnSuccessfulDelete() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		comad.verifydeletepromp(randomName, randomName, randomName, "Casting Elements Deleted Successfully");
		
		
		
	
		
	}
	
	@Test(priority=17,groups="group1")
	public void TC_CE_019PromptOnUpdateSuccess() throws InterruptedException{
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		comad.verifyupdateprompt(randomName,randomName,randomName,randomName1,"Casting Element Successfully Updated");
		
	}
	

	@Test(priority=18,groups="group1")
	public void TC_CE_020PromptOnSaveAsNewSuccess() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);		
		comad.verifysaveasnewprompt(randomName,randomName,randomName,randomName1,"Casting Elements Saved Successfully");
		
			
	}
	
	
	
	@Test(priority=19,groups="group1")
	public void voidTC_CE_021ResetButtonFunctionality() throws InterruptedException {
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		
		dashboard.selectMenuFormDashBoard("Master Data");
		   
		dashboard.clickoncommodityMaster();
		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
		
		comad.resetbtn(randomName, randomName, randomName);
		
		
		
		
	}
	@Test(priority=20,groups="group1")
	public void TC_CE_014SAASValidateCastingElementsForDifferentClients() throws InterruptedException{
		String randomName = faker.name().firstName();
		String randomName1 = faker.name().firstName();
		String randomName2 = faker.name().firstName();
		String randomName3 = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");		   
		dashboard.clickoncommodityMaster();		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);	
	    comad.saveDataFromClientA(randomName, randomName);
		dashboard.clickOnlogoutbtn();
		                     
		LoggerUtil.info("STEP 4: Login as Client B (Shiv Sir).");
		login.loginApplication(prop.getProperty("username1"), prop.getProperty("password1"));
//		Base.safeAcceptAlert();
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickoncommodityMaster();
		dashboard.clickadcastingtab();
        Thread.sleep(2000);
        comad.saveDataFromClientB(randomName, randomName, randomName);
        dashboard.clickOnlogoutbtn();
		
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password")); //Loggin with rishi And Edit Data
        dashboard.selectMenuFormDashBoard("Master Data");		   
		dashboard.clickoncommodityMaster();		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);
        comad.EditDataInClientA(randomName, randomName1); 
        dashboard.clickOnlogoutbtn();
        
        login.loginApplication(prop.getProperty("username1"), prop.getProperty("password1"));  //Loggin With client B Shiv For verifying The changes should Not There
//		Base.safeAcceptAlert();
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickoncommodityMaster();
		dashboard.clickadcastingtab();
        Thread.sleep(2000);
        comad.verifyingchangedDataShouldNotchangeInclientB(randomName);
        dashboard.clickOnlogoutbtn();
        
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password")); //Loggin with rishi And Edit Data going to delete edit data
        dashboard.selectMenuFormDashBoard("Master Data");		   
		dashboard.clickoncommodityMaster();		
		dashboard.clickadcastingtab();
		Thread.sleep(3000);
        comad.deleteEditedDataInclientA(randomName1);
        dashboard.clickOnlogoutbtn();
        
        
        login.loginApplication(prop.getProperty("username1"), prop.getProperty("password1"));  //Loggin With client B Shiv For verifying The changes should Not There
//		Base.safeAcceptAlert();
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickoncommodityMaster();
		dashboard.clickadcastingtab();
        Thread.sleep(2000);
        comad.verifydeletedDataShouldNotDeleteInclientB(randomName);
        
	}
 
	
	
	
	}
	
	


