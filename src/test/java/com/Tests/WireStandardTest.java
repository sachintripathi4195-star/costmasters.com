package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.WireStandardPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class WireStandardTest extends Base{

	LoginPage login;
	DashboardPage dashboard;
	WireStandardPage wire;
    	Faker faker;
	    String randomname;
    	String randomname1;
    	String randomname2;
    	
	@BeforeTest
	public void generator()
	{
		 faker = new Faker();
		 randomname = faker.name().firstName();
		 randomname1 = faker.name().firstName();
		 randomname2= faker.name().firstName();
		
	}
	
	
	
	@BeforeGroups(groups= {"group1","group2","group3","group4"})
	public void setup() {
		
		launchApplication();
		login = new LoginPage();
		dashboard = new DashboardPage();
		wire = new WireStandardPage();
		
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterGroups(groups= {"group1","group2","group3","group4"})
	public void quit() {
		
		driver.quit();
		
	}
	
	
	@Test(priority=1,groups="group1")
	public void TC_WIRE_001SaveNewWireName() throws InterruptedException {
		
		generator();
    	
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.savenewwirename(randomname,randomname);
	  	
		
		
	}
	
	@Test(priority = 2, groups = "group1")
	public void TC_WIRE_002SaveAsNewWireName() throws InterruptedException {

		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.verifysaveasnewdata(randomname, randomname1);

	}
	
	
	@Test(priority=3,groups="group1")
	public void TC_WIRE_003SearchFunctionality() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.verifysearchinput(randomname);
		
		
		
	}
	
	@Test(priority=4,groups="group1")
	public void TC_WIRE_004EditAndUpdateExistingWireName() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.verifyupdatefunctionality(randomname,randomname1);
		
		
		
	}
	
	
	@Test(priority=5,groups="group1")
	public void TC_WIRE_005PaginationCheck() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.pagination();
		
	}
	
	
	
	@Test(priority=6,groups="group1")
	public void TC_WIRE_006ValidateTotalCount() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.countingpagelength();	
		
		
		
	}
	
	
	@Test(priority=7,groups="group1")
	public void TC_WIRE_007DeleteWireNameNewSave() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.verifydeletenewdata(randomname, randomname);
		
		
		
	}
	
	
	
	
	@Test(priority = 8, groups = "group1")
	public void TC_WIRE_008DeleteWireNameAfterSaveAsNew() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.verifydeletesaveasnewdata(randomname, randomname1);

	}
	
	
	
	
	
	@Test(priority=10,groups="group1")
	public void TC_WIRE_010VerifyEditLoad() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.verifyeditfunctionality(randomname);
		
		
		
	}
	
	
	@Test(priority=11,groups="group1")
	public void TC_WIRE_011FieldValidationSpecialCharacters() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.enterinvaliddata();
		
		
		
		
	}
	
	@Test(priority=12,groups="group1")
	public void TC_WIRE_012FieldValidationNegativeValues() throws InterruptedException {
		generator();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.enternegativevalues();
	
	}
	
    @Test(priority=13,groups="group1")
    public void TC_WIRE_014DuplicateWireNamePrevention() throws InterruptedException {
    	generator();
    	dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
		wire.duplicatename(randomname);
    	
    	
    	
    }
	
	
   @Test(priority=14,groups="group1")
   public void TC_WIRE_018PromptOnDeleteSuccess() throws InterruptedException {
	   generator();
	   dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);   
	   wire.promptdeleteonsucess(randomname);
	   
	   
	   
	   
   }
	
   @Test(priority=15,groups="group1")
   public void TC_WIRE_017PromptOnUpdate() throws InterruptedException {
	   generator(); 
	   dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(4000);
		dashboard.clickingwirestandardtab();
		Thread.sleep(2000);
	   wire.verifyupdateprompt(randomname, randomname1);
	   
   }
   
   
   
   @Test(priority=16,groups="group1")
   public void TC_WIRE_020ResetButtonValidation() throws InterruptedException {
	   generator();
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.resetbtnfunctionality(randomname);
  
   }
   
   
   @Test(priority=17,groups="group1")
   public void TC_WIRE_015SAASDataIsolation() throws InterruptedException {
       generator();	   
       LoggerUtil.info("user enter data from rishi's i'd ..");
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.datasavedinclientA(randomname);
	   dashboard.clickOnlogoutbtn();
	   Thread.sleep(2000);
	   LoggerUtil.info("User enter the from different client name..");
	   login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.datasaveinclientB(randomname);
	   dashboard.clickOnlogoutbtn();
	   LoggerUtil.info("user enter for updating data in rishi's i'd");
	   login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.EditAndUpdatedatainclientA(randomname,randomname1);
	   dashboard.clickOnlogoutbtn();
	   LoggerUtil.info("User enter the from different client name..");
	   login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.datasaveinclientB(randomname1);
	   dashboard.clickOnlogoutbtn();
	   LoggerUtil.info("user enter for Save as new wire in rishi's i'd");
	   login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.verifysaveasnewdatainfirstclient(randomname1,randomname2);
	   dashboard.clickOnlogoutbtn();
	   LoggerUtil.info("User enter the from different client name..");
	   login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));
	   dashboard.selectMenuFormDashBoard("Master Data");
	   Thread.sleep(3000);
	   dashboard.clickoncommodityMaster();
	   Thread.sleep(3000);
	   dashboard.clickingwirestandardtab();
	   Thread.sleep(2000);
	   wire.datasaveinclientB(randomname2);
	   dashboard.clickOnlogoutbtn();
	   
   }
   
   
   
   
   
   
   
   
   
   
	
	
}
