package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.WireDataEntryPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;



@Listeners(com.helper.TestListeners.class)
public class WireDataEntryTest extends Base{
	
	LoginPage login ;
	DashboardPage dashboard;
	WireDataEntryPage wire;
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
	
	@BeforeTest()
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
		login= new LoginPage();
		dashboard  = new DashboardPage();
		wire= new WireDataEntryPage();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterGroups(groups= {"group1","group2","group3","group4","group5"})
	public void Quit() {
		
		driver.quit();
	}

	
	@Test(priority=1,groups="group1")
	public void TC_WDE_001SaveNewWireDetails() throws InterruptedException {
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(randomname);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savenewdatawiredataentry(randomname,randomintz,randomintz1,randomintz,randomintz1,randomintz,randomintz1,randomintz,statnumber);
		
	}
	
	@Test(priority=2,groups="group1")
	public void TC_WDE_002SaveAsNewWireDetails() throws InterruptedException {
		
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentryForSaveAsNew(randomname,randomname1);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savenewdatawiredataentryforsaveAsnew(randomname,randomintz,randomintz1,randomintz12,randomintz1,randomintz,randomintz1,randomintz,statnumber,randomname1);
		
		
		
		
	}
	
	
	@Test(priority=3,groups="group1")
	public void TC_WDE_004EditAndUpdateWireDetails() throws InterruptedException {
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentryForSaveAsNew(randomname,randomname1);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savenewdatawiredataentryforUpdate(randomname,randomintz,randomintz1,randomintz12,randomintz1,randomintz,randomintz1,randomintz,statnumber,randomname1);
	}
	
	
	
	
	@Test(priority=4,groups="group1")
	public void TC_WDE_007DeleteNewSavedWireDetail() throws InterruptedException {
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(randomname);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savenewdatawiredataentryfordeletion(randomname,randomintz,randomintz1,randomintz,randomintz1,randomintz,randomintz1,randomintz,statnumber);
		
		
		
	}
	
	@Test(priority=5,groups="group1")
	public void TC_WDE_008DeleteSaveAsNewWireDetail() throws InterruptedException {
		
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentryForSaveAsNew(randomname,randomname1);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savenewdatawiredataentryforsaveAsnewFroDeletion(randomname,randomintz,randomintz1,randomintz12,randomintz1,randomintz,randomintz1,randomintz,statnumber,randomname1);
		
	}
	
	@Test(priority=6,groups="group1")
	public void TC_WDE_011DuplicateEntryValidation() throws InterruptedException {
	
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(randomname);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
        wire.savenewdatawiredataentryforverificationDuplication(randomname,randomintz,randomintz1,randomintz,randomintz1,randomintz,randomintz1,randomintz,statnumber);
		
		
		
		
	}
	
	
	
	@Test(priority = 7, groups = "group1")
	public void TC_WDE_012_ResetButtonFunctionality() throws InterruptedException {

	    generator();
       
	    Faker faker = new Faker();
	   
	    String wirename = "AAA"+faker.name().firstName()+faker.letterify("???");
	    
	    String thickness = String.valueOf(randomint);
	    String conductors = String.valueOf(randomint1);
	    String std = String.valueOf(randomint2);
	    String max = String.valueOf(randomint3);
	    String screenThickness = String.valueOf(randomint4);
	    String jacketThickness = String.valueOf(randomint5);
	    String insulator = String.valueOf(randomint6);
	    String numConductors = String.valueOf(randomint7);

	    
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(2000);
	    dashboard.clickoncommodityMaster();
	    Thread.sleep(1000);

	    
	    wire.savenewwiredataentry(wirename);
	    Thread.sleep(6000);
	    driver.navigate().refresh();

	    
	    dashboard.clickingwiredataentrytab();
	    Thread.sleep(7000);

	   
	    wire.savenewdatawiredataentry(wirename, thickness, conductors, std, max, screenThickness, jacketThickness, insulator, numConductors);

	    
	    wire.verifyresetbuttonfunctionality(wirename, insulator, insulator, thickness, numConductors, std, insulator);
	}

	@Test(priority=8,groups="group1")
	public void TC_WDE_016FieldValidationBlankS_T_DOrMAX() throws InterruptedException {
		 generator();

		   
		    String wireName = randomname;
		    String thickness = String.valueOf(randomint);
		    String conductors = String.valueOf(randomint1);
		    String std = String.valueOf(randomint2);
		    String max = String.valueOf(randomint3);
		    String screenThickness = String.valueOf(randomint4);
		    String jacketThickness = String.valueOf(randomint5);
		    String insulator = String.valueOf(randomint6);
		    String numConductors = String.valueOf(randomint7);

		    
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(2000);
		    dashboard.clickoncommodityMaster();
		    Thread.sleep(1000);

		    
		    wire.savenewwiredataentry(wireName);
		    Thread.sleep(6000);
		    driver.navigate().refresh();

		    
		    dashboard.clickingwiredataentrytab();
		    Thread.sleep(7000);

		   
		    wire.savenewdatawiredataentryForSTD(wireName, thickness, conductors, std, max, screenThickness, jacketThickness, insulator, numConductors);
		
		
		
	}
	
	@Test(priority=8,groups="group1")
	public void TC_WDE_016FieldValidationBlankMAX() throws InterruptedException {
		 generator();

		   
		    String wireName = randomname;
		    String thickness = String.valueOf(randomint);
		    String conductors = String.valueOf(randomint1);
		    String std = String.valueOf(randomint2);
		    String max = String.valueOf(randomint3);
		    String screenThickness = String.valueOf(randomint4);
		    String jacketThickness = String.valueOf(randomint5);
		    String insulator = String.valueOf(randomint6);
		    String numConductors = String.valueOf(randomint7);

		    
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(2000);
		    dashboard.clickoncommodityMaster();
		    Thread.sleep(1000);

		    
		    wire.savenewwiredataentry(wireName);
		    Thread.sleep(6000);
		    driver.navigate().refresh();

		    
		    dashboard.clickingwiredataentrytab();
		    Thread.sleep(7000);

		   
		    wire.savenewdatawiredataentryForMax(wireName, thickness, conductors, std, max, screenThickness, jacketThickness, insulator, numConductors);
		
		
		
	}
	
	
	@Test(priority=9,groups="group1")
	public void TC_WDE_017WireCoreInsulatorDependency() throws InterruptedException {
		generator()	;
		String randomintz = String .valueOf(randomint);
		String randomintz1 = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(randomname);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savenewdatawiredataentryWireCoreIsGreaterTheanInsulator(randomname,randomintz,randomintz1,randomintz,randomintz1,randomintz,randomintz1,randomintz,statnumber);
		
	}
	
	
	@Test(priority=10,groups="group1")
	public void TC_WDE_015FieldValidationNumericPrecision() throws InterruptedException {
		 String wireName = randomname;
		  Faker faker = new Faker();
		  
		  double randomdouble = faker.number().randomDouble(4, 1000, 15000);
		  String alldoublevalue = String.valueOf(randomdouble);
		  int randomint1 = faker.number().numberBetween(10, 99);
		 int randomint = faker.number().numberBetween(10, 99);
		 String numconductors = String.valueOf(randomint);
		 String insulator = String.valueOf(randomint1);
		    String conductors = getRandomDecimalWithPrecision(4, 50, 200);
		    String std = getRandomDecimalWithPrecision(4, 10, 99);
		    String max = getRandomDecimalWithPrecision(4, 10, 99);
		    String screenThickness = getRandomDecimalWithPrecision(4, 18, 99);
		    String jacketThickness = getRandomDecimalWithPrecision(4, 32, 99);
		   
		    String thickness = getRandomDecimalWithPrecision(4, 70, 99);
			
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
			dashboard.clickoncommodityMaster();;
			Thread.sleep(1000);
			wire.savenewwiredataentry(randomname);
			Thread.sleep(6000);
			driver.navigate().refresh();
			dashboard.clickingwiredataentrytab();
			Thread.sleep(7000);
			 wire.savenewdatawiredataentryForuptoFourDecimal(wireName,alldoublevalue,alldoublevalue,alldoublevalue,numconductors,alldoublevalue,alldoublevalue,alldoublevalue,alldoublevalue,alldoublevalue,numconductors,numconductors,alldoublevalue );
			
			
		
		
	}
	
	@Test(priority=11,groups="group1")
	public void TC_WDE_014SaveWithMandatoryFieldsOnly() throws InterruptedException {
		generator()	;
	    String wirename = randomname;
		String otherdiaofwire = String .valueOf(randomint);
		String STD = String.valueOf(randomint1);
		String randomintz12 = String.valueOf(randomint2);
		String statnumber = String.valueOf(random);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(wirename);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savewithmandatoryfield(wirename, otherdiaofwire, STD
				);
		
		
		
		
	}
	
	
	@Test(priority=12,groups="group1")
	public void TC_WDE_013SAASValidationForMulticlient() throws InterruptedException {
		
		generator()	;
		
	    String wirename = randomname;
	    String wirename1 = randomname1;
		String wiresaveasnew = randomname2;
	    String outerdiaofwire = String .valueOf(randomint);
		String wirenormal = String.valueOf(randomint2);
		String numberofconductor = String.valueOf(random);
		String conductordiamm = String.valueOf(randomint2);
		String STD = String.valueOf(randomint1);
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(wirename);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savewithmandatoryfieldDataForClientA(wirename, outerdiaofwire, wirenormal, numberofconductor, conductordiamm, STD);
		Thread.sleep(2000);
		dashboard.clickOnlogoutbtn();
		LoggerUtil.info("User Login From Different client i'd...");
		login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(wirename);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.savewithmandatoryfieldDataForClientA(wirename, outerdiaofwire, wirenormal, numberofconductor, conductordiamm, STD);
		Thread.sleep(2000);
		dashboard.clickOnlogoutbtn();
		LoggerUtil.info("User Login From personal i'd  for updating data..");
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(wirename1);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.updatingdataforclientA(wirename, wirename1);
		Thread.sleep(3000);
		dashboard.clickOnlogoutbtn();
		Thread.sleep(3000);
		LoggerUtil.info("User Login From Different client i'd...");
		login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		
		Thread.sleep(4000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		
		wire.verifyupdatingdatafromclientAisSaveInClientBOrNot(wirename1);
		Thread.sleep(3000);
		dashboard.clickOnlogoutbtn();
		LoggerUtil.info("User Login From personal i'd  for Save As New data..");
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		Thread.sleep(1000);
		wire.savenewwiredataentry(wirename1);
		Thread.sleep(6000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		wire.SaveAsNewdataforclientA(wirename1, wiresaveasnew);
		Thread.sleep(3000);
		dashboard.clickOnlogoutbtn();
		LoggerUtil.info("User Login From Different client i'd...");
		login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();;
		
		Thread.sleep(4000);
		driver.navigate().refresh();
		dashboard.clickingwiredataentrytab();
		Thread.sleep(7000);
		
		wire.verifyupdatingdatafromclientAisSaveInClientBOrNot(wiresaveasnew);
		Thread.sleep(3000);
		dashboard.clickOnlogoutbtn();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
