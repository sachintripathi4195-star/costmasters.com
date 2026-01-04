package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.BOPPage;
import com.Pages.CurrencyPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.helper.Base;

@Listeners(com.helper.TestListeners.class)
public class BOPTest extends Base{

	LoginPage login;
	DashboardPage dashboard;
	BOPPage bop;
	String randomname;
	String randomname1;
	String randomname2;
	int randomint;
	int randomint1;
	int randomint2;
	int randomint3;
	int randomint4;
	int randomint5;
	int randomint6;
	int randomint7;
	int random;
	
	
	@BeforeMethod
	public void generator() {
	       Faker faker = new Faker();		
	       randomint =  faker.number().randomDigit();
	       random = faker.number().numberBetween(10, 99);
		   randomname = faker.name().lastName();
		   randomname1 = faker.name().lastName();
		   randomname2 = faker.name().lastName();
		   randomint1 = faker.number().numberBetween(10, 99);
		   randomint2 = faker.number().numberBetween(10, 99);
		   randomint3 = faker.number().numberBetween(10, 99);
		   randomint4 = faker.number().numberBetween(10, 99);
		   randomint5 = faker.number().numberBetween(10, 99);
		   randomint6 = faker.number().numberBetween(10, 99);
		   randomint7 = faker.number().numberBetween(10, 99);
		   
		}
		
	
	
	
	@BeforeGroups(groups= {"group1","group2","group3","group4","group5"})
	public void setup() {
		launchApplication();
		login = new LoginPage();
		dashboard = new DashboardPage();
		bop = new BOPPage();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterGroups(groups= {"group1","group2","group3","group4","group5"})
	public void Quit() {
		
		driver.quit();
		
	}
	
	//@Test(priority=1,groups="group1",enabled=false)
	public void BOP_001VerifyBopTypeMasterPageLoadTime() throws InterruptedException {
	
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=2,groups="group1")
	public void BOP_002_VerifySaveFunctionalityForNewBopType() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.entervalues(randomname);
		dashboard.ClickingBopTypeTab();
		
	}
	
	@Test(priority=3,groups="group1")
	public void BOP_003_VerifyDynamicSearchFunctionality() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.verifysearchfunctionality(randomname);
		dashboard.ClickingBopTypeTab();
		
		
	}
	
	@Test(priority=4,groups="group1")
	public void BOP_004_VerifyUpdateFunctionalityForExistingBopType() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
        bop.updatebuttonfunctionality(randomname, randomname1);		
	
        dashboard.ClickingBopTypeTab();
	}
	
	@Test(priority=5,groups="group1")
	public void BOP_005VerifyDuplicateNameRestrictionWhileUpdating() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.verifyduplicatename(randomname);
		dashboard.ClickingBopTypeTab();
	}
	
	@Test(priority=6,groups="group1")
	public void BOP_006VerifyResetButtonFunctionality() throws InterruptedException {
	
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.RestButton(randomname);
		dashboard.ClickingBopTypeTab();
		
	}
	
	@Test(priority=7,groups="group1")
	public void BOP_007VerifyPlaceholderPresenceInBopTypeField() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.verifyPlaceholder();
		dashboard.ClickingBopTypeTab();
		
	}
	
	
	@Test(priority=8,groups="group1")
	public void BOP_008VerifyMandatoryStarMarkOnBopTypeField() throws InterruptedException {
     

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
        bop.verifyastrickmarkavailable();
        dashboard.ClickingBopTypeTab();
		
		
	}
	
	
	
	@Test(priority=9,groups="group1")
	public void BOP_009VerifySortingFunctionalityOfTableColumns() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.verifysortingfunctionality();
		dashboard.ClickingBopTypeTab();
		
	}
	
	
	@Test(priority=10,groups="group1")
	public void BOP_010VerifySuccessfulDeletionOfUnusedBopType() throws InterruptedException {
   
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
        bop.VerifySucessfullydeletedData(randomname);  
        dashboard.ClickingBopTypeTab();
		
		
	}
	
	
	@Test(priority=11,groups="group1")
	public void BOP_011VerifyPreventionOfDeletionIfBopTypeIsDependent() throws InterruptedException{
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.verifyPreventionDeletion();
		dashboard.ClickingBopTypeTab();
	}
	
	
	@Test(priority=12,groups="group1")
	public void BOP_012VerifyBlankSearchBehavior() throws InterruptedException {
	
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
        bop.verifysearchbehavioandconfirmafteRemovesearchboxPageShouldBeLoadFully(randomname);              
        dashboard.ClickingBopTypeTab();
     		
		
		
	}
	
	@Test(priority=13,groups="group1")
	public void BOP_013VerifyEntryOfSpecialCharactersInBopTypeField() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(1000);
		dashboard.clickingOnlyBopMaster();
		Thread.sleep(2000);
		dashboard.selectBopMaster();
		Thread.sleep(2000);
		bop.verifyspecialcharacterRestriction();
		dashboard.ClickingBopTypeTab();
		
	}
	
	
	
}
