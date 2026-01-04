package com.Tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.AddcommodityPage;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)

public class Addcommodity extends Base {

	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
	
	AddcommodityPage Addcom = new AddcommodityPage();
	Faker faker = new Faker();

	// Generate random string data
	String randomName;
	String randomNumber;
	String randomName1;
	String randomName2;

	@BeforeClass
	public void setUpRandomData() {
		randomName = faker.name().firstName();
		randomNumber = String.valueOf(faker.number().randomNumber());
		randomName1 = faker.name().firstName();
		randomName2 = faker.name().firstName(); 
	}
	@BeforeGroups(groups = {"group1", "group2","group3"})
	public void loginGroup() throws InterruptedException {
		Base.launchApplication();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(7000);
		LoggerUtil.info("Logged in once before the group test cases.");
	}

	@AfterGroups(groups = {"group1", "group2","group3"})
	public void logoutGroup() {
		driver.quit();
		LoggerUtil.info("Logged out after the group test cases.");
	}




	@Test(priority=1,groups="group1")
	public void TC_COM_ADD_001_SaveAsNewFunctionality() throws InterruptedException {
        String CommodityGroup = faker.name().firstName()+faker.letterify("?????");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Verify The User Enter The Master Data ");
		LoggerUtil.info("Verify The User Click The Commodity Master");
		dashboard.clickoncommodityMaster();		
		LoggerUtil.info("User Enter The Add Commodity Tab");
		Addcom.SaveNewData(CommodityGroup, CommodityGroup);



	}


	@Test(priority=2,groups="group1")
	public void TC_COM_ADD_002_SearchFunctionality() throws InterruptedException {
		  String CommodityGroup = faker.name().firstName()+faker.letterify("?????");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Verify The User Enter The Master Data ");
		LoggerUtil.info("Verify The User Click The Commodity Master");
		dashboard.clickoncommodityMaster();
		Addcom.searchfilter(CommodityGroup,CommodityGroup);



	}
	@Test(priority=3,groups="group1")
	public void TC_COM_ADD_003_EditAndUpdateExistingCommodity() throws InterruptedException {

		String updatedcomgrp = faker.name().firstName()+faker.letterify("??????");
		  String CommodityGroup = faker.name().firstName()+faker.letterify("?????");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Verify The User Enter The Master Data ");
		LoggerUtil.info("Verify The User Click The Commodity Master");
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		Addcom.ClickingEditbtn(CommodityGroup,CommodityGroup,updatedcomgrp);



	}
	@Test(priority=4,groups="group1")
	public void  TC_COM_ADD_004_TablePagination() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickoncommodityMaster();
		Addcom.nextbtn();


	}

	@Test(priority=5,groups="group1")
	public void TC_COM_ADD_005_VerifyTotalCount() {

		
		dashboard.selectMenuFormDashBoard("Master Data");
	
		dashboard.clickoncommodityMaster();
		
		Addcom.VerifyActualLength("25");


	}
	@Test(priority=6,groups="group1")
	public void TC_COM_ADD_006_DeleteAfterNewSave() throws InterruptedException {
		
		  String CommodityGroup = faker.name().firstName()+faker.letterify("?????");
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();  
		Addcom.verifydeletebtn(CommodityGroup,CommodityGroup,"Commodity Group Successfully Deleted");



	}

	@Test(priority=7,groups="group1")
	public void TC_COM_ADD_007_DeleteAfterSaveAsNew() throws InterruptedException {
		
		String CommodityGroup = faker.name().firstName()+faker.letterify("?????");
		String CommodityGroupnew = faker.name().firstName()+faker.letterify("?????");
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();  
		Addcom.DeletbtnsaveAsNew(CommodityGroup, CommodityGroup, CommodityGroupnew);


	}

	@Test(priority=8,groups="group1")
	public void TC_COM_ADD_008_DeleteWhenUsedInOtherModules() throws InterruptedException {

		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();  
		Addcom.verifyDeleteExistingData("Ferrous Metals","Can't Be Deleted Commodity Group Due To Dependent Data");



	}

	@Test(priority=9,groups="group1")
	public void TC_COM_ADD_009_EditExistingDataAppearsCorrectly() throws InterruptedException {

		String comgrp = faker.name().firstName()+faker.letterify("?????");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();  
		Addcom.verifyClickEditBtn(comgrp);   
	}

	@Test(priority=10,groups="group1")
	public void TC_COM_ADD_010_FieldValidationForNumericSymbolicValues() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();  
		Addcom.verifyInvalidValuesInCommodityGroupBox("Commodity Group cannot contain numbers, negative values, or symbols (except hyphen).");




	}

	@Test(priority=11,groups="group1")
	public void TC_COM_ADD_012_PreventDuplicateNames() {
		String comgrp = faker.name().firstName()+faker.letterify("?????");
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();     
		Addcom.verifyDuplicatesavedOrNot(comgrp,"Commodity Group Already Exists");





	}

	@Test(priority=12,groups="group2")
	public void TC_COM_ADD_014_CheckOnlineDuplicateAtSave() {
		String comgrp = faker.name().firstName()+faker.letterify("?????");
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		
		Addcom.verifyClickSaveBtnMultipletime(comgrp,"Commodity Group Already Exists");



	}

	@Test(priority=13,groups="group2")
	public void TC_COM_ADD_016_PromptAfterSuccessfulSave() {
		String comgrp = faker.name().firstName()+faker.letterify("?????");
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		
		Addcom.verifySavePromptAfterClickingSaveButton(comgrp,"Commodity Group successfully saved.");



	}

	@Test(priority=14,groups="group2")
	public void TC_COM_ADD_017_PromptAfterSavingDuplicate() {

       String comgrpname = faker.name().firstName();
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		
		Addcom.verifySavePromptAfterClickingSaveButtonWithDuplicateData(comgrpname, "Commodity Group Already Exists");




	}

	@Test(priority=15,groups="group2")
	public void TC_COM_ADD_019_PromptAfterSuccessfulDelete() throws InterruptedException {
		 String comgrpname = faker.name().firstName();
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		Thread.sleep(5000);
		Addcom.verifyDeleteNewCommmodity(comgrpname, comgrpname);







	}


	@Test(priority=16,groups="group2")
	public void TC_COM_ADD_020_PromptAfterUpdate() throws InterruptedException {

		 String comgrpname = faker.name().firstName();
		 String updatedcomgrpname = faker.name().firstName();
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		Addcom.updatepromptmsg(comgrpname,comgrpname,updatedcomgrpname,"Commodity Group successfully saved.");

	}

	@Test(priority=17,groups="group2")
	public void TC_COM_ADD_021_SaveAsNewPrompt() throws InterruptedException {
		 String comgrpname = faker.name().firstName()+faker.letterify("????????");
		 String SaveAsNewcomgrpname = faker.name().firstName()+faker.letterify("????????");
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();  
		Addcom.saveasnewprompt(comgrpname,comgrpname,SaveAsNewcomgrpname,"Commodity Group successfully saved.");  


	}

	@Test(priority=18,groups="group2")
	public void TC_COM_ADD_022_PagePerformanceCheck() throws InterruptedException {

		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();    

	}

	@Test(priority=18,groups="group2")
	public void TC_COM_ADD_022_PagePerformanceCheck1() throws InterruptedException {
		 String comgrpname = faker.name().firstName()+faker.letterify("????????");
		 String SaveAsNewcomgrpname = faker.name().firstName()+faker.letterify("????????");
		 String updatedcomgrp = faker.name().firstName()+faker.letterify("??????????");
		
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();   
		Addcom.pageperformence(comgrpname,comgrpname,SaveAsNewcomgrpname,comgrpname,updatedcomgrp,"Commodity Group successfully saved.");

	}

	@Test(priority=19,groups="group2")
	public void TC_COM_ADD_025_AscendingOrderInTable1() throws InterruptedException{

		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster(); 
		Addcom.clickfordescendingOrder();


	}
	@Test(priority=19, groups="group2")
	public void TC_COM_ADD_025_AscendingOrderInTable() throws InterruptedException {
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		Addcom.clickForAscendingOrderByName(); 
	}


	@Test(priority=20,groups="group2")
	public void TC_COM_ADD_026_PreventDuplicateOnEdit() throws InterruptedException{
		 String comgrpname = faker.name().firstName()+faker.letterify("????????");

		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();    
		Addcom.saveduplicatename(comgrpname,comgrpname,comgrpname,"Commodity Group Already Exists"); 




	}



	




	@Test(priority = 21, groups = "group2")
	public void TC_COM_ADD_015_SAASAddSameCommodityAcrossClients() throws InterruptedException {

		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		Addcom.addcommodityforclientA(randomName);
		Thread.sleep(3000);
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
        login.loginApplication(prop.getProperty("username1"), prop.getProperty("password1"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Addcom.addcommodityforclientA(randomName);
        Thread.sleep(5000);
        dashboard.clickOnlogoutbtn();
        Thread.sleep(5000);
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		Thread.sleep(3000);
        Addcom.searchforclientA(randomName,randomName1);
        System.out.print(randomName1);
        Thread.sleep(3000);
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
        login.loginApplication(prop.getProperty("username1"), prop.getProperty("password1"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        Addcom.verifyForClientB(randomName1);
        Thread.sleep(3000);
        dashboard.clickOnlogoutbtn();
        Thread.sleep(4000);
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickoncommodityMaster();
		Thread.sleep(3000);
		Addcom.verifyDeleteupdatedvalueforclientA(randomName1);
		Thread.sleep(3000);
		dashboard.clickOnlogoutbtn();
        Thread.sleep(4000);
        login.loginApplication(prop.getProperty("username1"), prop.getProperty("password1"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        Addcom.verifyImpactforclientB(randomName);
        
        
        
        
        
        
        
	}


}



