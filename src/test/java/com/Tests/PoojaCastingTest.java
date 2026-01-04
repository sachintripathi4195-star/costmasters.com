package com.Tests;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.Casting_AlloyPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.PoojaCastingPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class PoojaCastingTest extends Base{
	
	DashboardPage  dashboard;
	LoginPage login ;
	PoojaCastingPage pooja;
	static Faker faker = new Faker();
	
	 public static int customerCode = faker.number().numberBetween(1000, 9999);
     public static String custcode = String.valueOf(customerCode);
     public static  String customername = faker.letterify("???????");
     public static String bsicpricevalue = String.valueOf(faker.number().numberBetween(1, 9));
     public static  String firstfreightvalue = String.valueOf(faker.number().numberBetween(1, 9));
     public static String conversioncost = String.valueOf(faker.number().numberBetween(1, 9));
     public static  String wastagecost = String.valueOf(faker.number().numberBetween(1, 9));
     public static  String secondwastage = String.valueOf(faker.number().numberBetween(1, 9));
     public static  String enterothercostfactorone = String.valueOf(faker.number().numberBetween(1, 9));
     public static String othercostfactortwo = String.valueOf(faker.number().numberBetween(10, 99));
     public static  String othercostvaluefirst = String.valueOf(faker.number().numberBetween(1, 9));
     public static String othercostvaluesecond = String.valueOf(faker.number().numberBetween(1, 9));
     public static String othercostvaluethird = String.valueOf(faker.number().numberBetween(1, 9));
     public static String discountvalue = String.valueOf(faker.number().numberBetween(1, 9));
	
  // Declare class-level variables for random values
 	String randomName;
 	String randomName1;
 	double randomNumbermin;
 	double randomNumbermax;
 	double randomNumbermin1;
 	double randomNumbermax1;
 	double randomNumbermin2;
 	double randomNumbermax2;
 	double randomNumbermin3;
 	double randomNumbermax3;
 	int randinteger;
 	double randomNumbermax4;
 	double randomNumbermax5;
 	double randomNumbermax6;
 	Faker fake = new Faker();
 	
 	Casting_AlloyPage cast = new Casting_AlloyPage();

 	public void genraterandomnumber() {

 		randomName = fake.letterify("????").toUpperCase();
 		randomName1 = fake.letterify("?????").toLowerCase();

 		randinteger = fake.number().numberBetween(10, 50);

 		randomNumbermin = fake.number().numberBetween(1, 9) / 100.0;
 		randomNumbermax = fake.number().numberBetween(10000, 99999) / 1000.0;

 		randomNumbermin1 = fake.number().numberBetween(1, 9) / 100.0;
 		randomNumbermax1 = fake.number().numberBetween(10000, 99999) / 1000.0;
 		randomNumbermin2 = fake.number().numberBetween(1, 9) / 100.0;
 		randomNumbermax2 = fake.number().numberBetween(10000, 99999) / 1000.0;

 		randomNumbermin3 = fake.number().numberBetween(1, 9) / 100.0;
 		randomNumbermax3 = fake.number().numberBetween(10000, 99999) / 1000.0;

 		randomNumbermax4 = fake.number().numberBetween(10000, 99999) / 1000.0;

 		randomNumbermax5 = fake.number().numberBetween(10000, 99999) / 1000.0;

 		randomNumbermax6 = fake.number().numberBetween(10000, 99999) / 1000.0;

 	}

	
	@BeforeClass(groups = "group1")
	    public void setup() {
	        // Generate random customer name using Faker or any other method
	       
	      
		      custcode = String.valueOf(customerCode);
	        
	    }
	
	String Alloy = faker.letterify("???????");
	String randomname1 =  faker.letterify("???????");
	String randomname =  faker.letterify("???????");
	@BeforeGroups(groups= {"group1","group2","group3","group4","group5","group6"})
	public void logingroup() {
		String customername = faker.letterify("???????");
		login = new LoginPage();
		dashboard=new DashboardPage();
		pooja = new PoojaCastingPage();
		launchApplication();
		login.loginApplication(prop.getProperty("username"),prop.getProperty("password"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        LoggerUtil.info("Logged in once before the group test cases.");
		
		
	}
	
	@AfterGroups(groups= {"group1","group2","group3","group4","group5","group6"})
	public void quit() {
		driver.quit();
		LoggerUtil.info("User Logged out after Completing The senario");
		
		
	}
	
	
	@Test(groups="group1",enabled=false)
	public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCost() throws InterruptedException {
		
	dashboard.selectMenuFormDashBoard("Master Data");
	
	dashboard.clickoncommodityMaster();
	Thread.sleep(15);
	dashboard.clickOnAddcommodity();
	pooja.saveaddcommdoity(Alloy,randomname,randomname1);
	
	
	}
	
	 @Test(groups="group1",enabled=false)
	 public void TC_CG_002MandatoryFieldValidation() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.clickOnAddcommodity();
		Thread.sleep(2000);
		pooja.savedatawithoutcommoditygrp();
		
		
		
	}
	
	 
	
	 @Test(groups="group1")
	 public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCosts() throws InterruptedException {
		 
		 dashboard.selectMenuFormDashBoard("Master Data");
		 Thread.sleep(3000);
		 dashboard.clickoncommodityMaster();
		 Thread.sleep(200);
		 dashboard.clickOnAddcommodity();
		 Thread.sleep(200);
		 pooja.Savedatawithpooja("Alloys");
		 dashboard.clickOncommoditygroup();
		 Thread.sleep(3000);
		 pooja.secondtabsavewithpooja();
		 Thread.sleep(3000);
		 dashboard.clickOnCommodityTabByName("Commodity Details");
		 Thread.sleep(3000);
		 pooja.Thirdtabsavewithpooja(custcode,customername);
		 
	 }
	 
	 
	 
	 @Test(groups = "group1",dependsOnMethods ={"TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCosts"})
		public void TC_CA_002SaveNewCompositionEntry() throws InterruptedException {
			// Pass the generated random values as arguments
		 genraterandomnumber();
			String intvaluemax = String.valueOf(randomNumbermax);
			String intvaluemax1 = String.valueOf(randomNumbermax1);
			String intvaluemax2 = String.valueOf(randomNumbermax2);
			String intvaluemax3 = String.valueOf(randomNumbermax3);
			String intvaluemaxover1 = String.valueOf(randomNumbermax);
			String intmaxover2 = String.valueOf(randomNumbermax1);
			String intmaxover3 = String.valueOf(randomNumbermax2);
			String intmaxover4 = String.valueOf(randomNumbermax3);
			String intmaxover5 = String.valueOf(randomNumbermax3);
			String intmaxover6 = String.valueOf(randomNumbermax4);
			String intmaxconsumable1 = String.valueOf(randomNumbermax6);
			String intmaxcon2 = String.valueOf(randomNumbermax4);
			String intmaxcon3 = String.valueOf(randomNumbermax2);
			String intmaxcon4 = String.valueOf(randomNumbermax1);
			String intmaxcon5 = String.valueOf(randomNumbermax6);
			String intmaxcon6 = String.valueOf(randomNumbermax2);
			String intmaxcon7 = String.valueOf(randomNumbermax5);
			// Call the method to save new composition with these dynamic values
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(2000);
			dashboard.castingalloytab();
			pooja.savenewcompositionentrt(intvaluemax, intvaluemax1, intvaluemax2, intvaluemax3, intvaluemaxover1,
					intmaxover2, intmaxover3, intmaxover4, intmaxover5, intmaxover6, intmaxconsumable1, intmaxcon2,
					intmaxcon3, intmaxcon4, intmaxcon5, intmaxcon6, intmaxcon7,customername,customername);
		}
	 
	 
	 
	 
	 
	 
	 
	 @Test(groups="group1")
	 public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsFor_L_M6() throws InterruptedException {
		 
		 dashboard.selectMenuFormDashBoard("Master Data");
		 Thread.sleep(3000);
		 dashboard.clickoncommodityMaster();
		 Thread.sleep(200);
		 dashboard.clickOnAddcommodity();
		 Thread.sleep(200);
		 pooja.Savedatawithpooja("Alloys");
		 dashboard.clickOncommoditygroup();
		 Thread.sleep(3000);
		 pooja.secondtabsavewithpoojaForL_M_6();
		 Thread.sleep(3000);
		 dashboard.clickOnCommodityTabByName("Commodity Details");
		 Thread.sleep(3000);
		 pooja.ThirdtabsavewithpoojaForL_M_6(custcode,customername);
		 
	 }
	 
	 @Test(groups = "group1",dependsOnMethods ={"TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsFor_L_M6"})
		public void TC_CA_002SaveNewCompositionEntryForL_M6() throws InterruptedException {
			// Pass the generated random values as arguments
		    genraterandomnumber();
			String intvaluemax = String.valueOf(randomNumbermax);
			String intvaluemax1 = String.valueOf(randomNumbermax1);
			String intvaluemax2 = String.valueOf(randomNumbermax2);
			String intvaluemax3 = String.valueOf(randomNumbermax3);
			String intvaluemaxover1 = String.valueOf(randomNumbermax);
			String intmaxover2 = String.valueOf(randomNumbermax1);
			String intmaxover3 = String.valueOf(randomNumbermax2);
			String intmaxover4 = String.valueOf(randomNumbermax3);
			String intmaxover5 = String.valueOf(randomNumbermax3);
			String intmaxover6 = String.valueOf(randomNumbermax4);
			String intmaxconsumable1 = String.valueOf(randomNumbermax6);
			String intmaxcon2 = String.valueOf(randomNumbermax4);
			String intmaxcon3 = String.valueOf(randomNumbermax2);
			String intmaxcon4 = String.valueOf(randomNumbermax1);
			String intmaxcon5 = String.valueOf(randomNumbermax6);
			String intmaxcon6 = String.valueOf(randomNumbermax2);
			String intmaxcon7 = String.valueOf(randomNumbermax5);
			// Call the method to save new composition with these dynamic values
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(2000);
			dashboard.castingalloytab();
			pooja.savenewcompositionentrtForLm_6(intvaluemax, intvaluemax1, intvaluemax2, intvaluemax3, intvaluemaxover1,
					intmaxover2, intmaxover3, intmaxover4, intmaxover5, intmaxover6, intmaxconsumable1, intmaxcon2,
					intmaxcon3, intmaxcon4, intmaxcon5, intmaxcon6, intmaxcon7,customername,customername);
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 @Test(priority=1,groups = "group1")
	 public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomestic() throws InterruptedException {
	    
	     // ✅ Step 2: Generate random input data for testing
//	     int customerCode = faker.number().numberBetween(1000, 9999);
//	     String custcode = String.valueOf(customerCode);
//	     String customername = faker.letterify("???????");
//	     String bsicpricevalue = String.valueOf(faker.number().numberBetween(1, 9));
//	     String firstfreightvalue = String.valueOf(faker.number().numberBetween(1, 9));
//	     String conversioncost = String.valueOf(faker.number().numberBetween(1, 9));
//	     String wastagecost = String.valueOf(faker.number().numberBetween(1, 9));
//	     String secondwastage = String.valueOf(faker.number().numberBetween(1, 9));
//	     String enterothercostfactorone = String.valueOf(faker.number().numberBetween(1, 9));
//	     String othercostfactortwo = String.valueOf(faker.number().numberBetween(10, 99));
//	     String othercostvaluefirst = String.valueOf(faker.number().numberBetween(1, 9));
//	     String othercostvaluesecond = String.valueOf(faker.number().numberBetween(1, 9));
//	     String othercostvaluethird = String.valueOf(faker.number().numberBetween(1, 9));
//	     String discountvalue = String.valueOf(faker.number().numberBetween(1, 9));

	     
	     dashboard.selectMenuFormDashBoard("Master Data");
	     Thread.sleep(3000);
	     dashboard.clickoncommodityMaster();
	     Thread.sleep(3000);
	     dashboard.clickOnAddcommodity();
	     Thread.sleep(2000);
	     pooja.savefirttabwithdomestic("Input material For Alloys");
	     Thread.sleep(4000);
	     dashboard.clickOncommoditygroup();
	     Thread.sleep(3000);
	     pooja.savesecondtabfordomestic();
	     Thread.sleep(4000);
	     dashboard.clickOnCommodityTabByName("Commodity Details");

	     LoggerUtil.info("User Enter Values In Third Tab In Commodity Master");

	     // ✅ Step 4: Call Page method & pass the separate Outlook session driver for mail approval
	     pooja.SaveDataInThirdTabDomestic(
	    		 custcode,customername,bsicpricevalue, firstfreightvalue,
	         conversioncost, wastagecost, secondwastage, enterothercostfactorone,
	         othercostfactortwo, othercostvaluefirst, othercostvaluesecond,
	         othercostvaluethird, discountvalue, customername
	         
	     );
	     
	     
	     
	 }
	    
		@Test(priority = 2, groups = "group2", dependsOnMethods ={"TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomestic"})
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticForConfirmingCustomerNameInUi()
				throws InterruptedException {

			Thread.sleep(4000);
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(4000);
			pooja.verifysavedatainviewtable(customername);

		}
	 

		@Test(priority = 3, groups = "group2")
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticWithSilicon()throws InterruptedException {
				

			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			pooja.SavedatawithpoojaforSilicon("Input material For Alloys");
			Thread.sleep(4000);
			dashboard.clickOncommoditygroup();
			Thread.sleep(5000);
			pooja.savesecondtabfordomesticWithSilicon("Silicon","si");
			Thread.sleep(5000);
			dashboard.clickOnCommodityTabByName("Commodity Details");
		    Thread.sleep(2000);
			LoggerUtil.info("User Enter Values In Third Tab In Commodity Master");
            pooja.SaveDataInThirdTabDomesticForSilicon( custcode,customername, bsicpricevalue, firstfreightvalue,
	         conversioncost, wastagecost, secondwastage, enterothercostfactorone,
	         othercostfactortwo, othercostvaluefirst, othercostvaluesecond,
	         othercostvaluethird, discountvalue, customername
	         ); 
			
			
		}
	   
	 
		@Test(priority = 4, groups = "group3", dependsOnMethods ={"TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticWithSilicon"})
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticForConfirmingCustomerNameInUiForSilicon ()
				throws InterruptedException {

			Thread.sleep(4000);
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(4000);
			pooja.verifysavedatainviewtableForSilicon(customername);

		}
	  

		@Test(priority = 5, groups = "group3")
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticWithCopper()throws InterruptedException {
				

			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			pooja.SavedatawithpoojaforCopper("Input material For Alloys");
			Thread.sleep(4000);
			dashboard.clickOncommoditygroup();
			Thread.sleep(5000);
			pooja.savesecondtabfordomesticWithCopper("Copper","cu");
			Thread.sleep(5000);
			dashboard.clickOnCommodityTabByName("Commodity Details");
		    Thread.sleep(2000);
			LoggerUtil.info("User Enter Values In Third Tab In Commodity Master");
            pooja.SaveDataInThirdTabDomesticForCopper( "3830","nznftvh", bsicpricevalue, firstfreightvalue,
	         conversioncost, wastagecost, secondwastage, enterothercostfactorone,
	         othercostfactortwo, othercostvaluefirst, othercostvaluesecond,
	         othercostvaluethird, discountvalue, "nznftvh"
	         ); 
			
			
		}
	   
		
		
		@Test(priority = 6, groups = "group4", dependsOnMethods ={"TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticWithCopper"})
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticForConfirmingCustomerNameInUiForCopper()
				throws InterruptedException {

			Thread.sleep(4000);
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(4000);
			pooja.verifysavedatainviewtableForSilicon("nznftvh");

		}
		
		
		
		@Test(priority = 7, groups = "group4")
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticWithFuel()throws InterruptedException {
				

			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			pooja.SavedatawithpoojaforCopper("Input material For Alloys");
			Thread.sleep(4000);
			dashboard.clickOncommoditygroup();
			Thread.sleep(5000);
			pooja.savesecondtabfordomesticWithFuel("Fuel","Fuel");
			Thread.sleep(5000);
			dashboard.clickOnCommodityTabByName("Commodity Details");
		    Thread.sleep(2000);
			LoggerUtil.info("User Enter Values In Third Tab In Commodity Master");
            pooja.SaveDataInThirdTabDomesticForFuel( custcode,customername, bsicpricevalue, firstfreightvalue,
	         conversioncost, wastagecost, secondwastage, enterothercostfactorone,
	         othercostfactortwo, othercostvaluefirst, othercostvaluesecond,
	         othercostvaluethird, discountvalue, customername
	         ); 
			
			
		}
		
		@Test(priority = 8, groups = "group5", dependsOnMethods ={"TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticWithFuel"})
		public void TC_AD_001ValidateExportedAlloySheetReflectsAllAlloyOverheadCostsForDomesticForConfirmingCustomerNameInUiForFuel()
				throws InterruptedException {

			Thread.sleep(4000);
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(4000);
			pooja.verifysavedatainviewtableForFuel(customername);

		}
		
		
		
		
		
		
		
		
		
		
		
	 

}
