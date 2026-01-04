package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.PackingPage;
import com.Pages.PoojaCastingPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class PackingTest extends Base {
	
	Faker faker = new Faker();
	SoftAssert soft = new SoftAssert();
    int	randomint = faker.number().numberBetween(10, 50);
    int randomint2 = faker.number().numberBetween(5, 10);
    String randomname = faker.name().firstName().translateEscapes();
    String randomname1 = faker.name().firstName().translateEscapes();
    String randomname2 = faker.name().firstName().translateEscapes()+"@#_$% ";
	DashboardPage  dashboard;
	LoginPage login ;
	PackingPage pack;
	
	
	
	@BeforeGroups(groups= {"group1","group2","group3","group4","group5","group6"})
	public void logingroup() {
		
		launchApplication();
		login = new LoginPage();
		dashboard=new DashboardPage();
		pack= new PackingPage();
		
		
		
		
		try {
			login.loginApplication(prop.getProperty("username"),prop.getProperty("password"));
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
	
	
	    @Test(priority=1,groups="group1")
	    public void TC_PCK_001SaveNewPackingCategory() throws InterruptedException {
	    	String randomname = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

		String.valueOf(randomint);
		String enterfactorvlaue = String.valueOf(randomint2);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(3000);
		dashboard.Packingtab();
		pack.savepackingdata(randomname,enterfactorvlaue);
		
		
		
	}
	
 	
	    @Test(priority = 2, groups = "group1")
	    public void TC_PCK_002SaveAsNewPackingCategory() throws InterruptedException {
	    	String randomname = faker.name().firstName().translateEscapes();
	        String randomname1 = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	        String enterfactorvlaue = String.valueOf(randomint2);

	        dashboard.selectMenuFormDashBoard("Master Data");
	        Thread.sleep(3000);

	        dashboard.clickoncommodityMaster();
	        Thread.sleep(3000);

	        dashboard.Packingtab();

	        // 🔴 Intentionally pass wrong expected toast to trigger mismatch
	        String wrongSaveToastExpected = "Packing category Group successful saved.";
	        String wrongDeleteToastExpected = "Packing category successfully deleted.";

	        pack.verifysaveasnew(
	            randomname,
	            enterfactorvlaue,
	            wrongSaveToastExpected,
	            randomname1,
	            wrongDeleteToastExpected
	        );
	    }

	
	    @Test(priority = 3, groups = "group1")
	    public void TC_PCK_004EditandUpdateExistingEntry() throws InterruptedException {
	    	String randomname = faker.name().firstName().translateEscapes();
	        String randomname1 = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	        String enterfactorvalue = String.valueOf(randomint2);
	        dashboard.selectMenuFormDashBoard("Master Data");
	        Thread.sleep(3000);
	        dashboard.clickoncommodityMaster();
	        Thread.sleep(3000);
	        dashboard.Packingtab();
	        Thread.sleep(2000);

	        
	        String wrongExpectedToast = "Packing category Group successful saved.";

	        pack.updatevalue(randomname, enterfactorvalue, randomname1, wrongExpectedToast,randomname);
	    }

	    
	    
	        @Test(priority=4,groups="group1")
	        public void TC_PCK_005PaginationCheckOnView() throws InterruptedException {
	        	faker.name().firstName().translateEscapes();
	            faker.name().firstName().translateEscapes();
	            faker.name().firstName().translateEscapes();

	    	String.valueOf(randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
	    	pack.pagination ();
	    	
	    }
	    
	    
	    @Test(priority=5,groups="group1")
	    public void TC_PCK_006ValidateTotalCount() throws InterruptedException {
	    	
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
	    	pack.countingpagelength();	
	    	
	    }
	    
	    
	    
	   @Test(priority=6,groups="group1")
	   public void TC_PCK_010VerifyEditLoadCorrectness() throws InterruptedException {
		   String randomname = faker.name().firstName().translateEscapes();
		    faker.name().firstName().translateEscapes();
		    faker.name().firstName().translateEscapes();

		   String enterfactorvlaue = String.valueOf(randomint2);
		   dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifyclickeditbtnandloadcorrectly(randomname,enterfactorvlaue);
		   
		   
		   
		   
	   }
	    
	    @Test(priority=7,groups="group1")
	    public void TC_PCK_011FactorNumericalValidation() throws InterruptedException {
	    	String randomname = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        String randomname2 = faker.name().firstName().translateEscapes()+"@#_$% ";

	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
	    	pack.enteralphabeticandnumericinfactorcolom(randomname,randomname2);
	    	
	    	
	    }
	    @Test(priority=7,groups="group1")
	    public void TC_PCK_012FactorNumericalValidationfornegativevalue() throws InterruptedException {
	    	 faker.number().numberBetween(10, 50);
	    	    int randomint2 = faker.number().numberBetween(5, 10);
	    	String randomname = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	    	String enterfactorvlaue = String.valueOf(-randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
	    	pack.enteralphabeticandnumericinfactorcolom(randomname,enterfactorvlaue);
	    	
	    	
	    }
	    
	    @Test(priority=8,groups="group1")
	    public void TC_PCK_013MandatoryFieldsCheck() throws InterruptedException {
	    	faker.name().firstName().translateEscapes();
	        String randomname1 = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	    	String enterfactorvlaue = String.valueOf(randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifymandatoryfield(randomname1, enterfactorvlaue);	
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    @Test(priority=8,groups="group1")
	    public void TC_PCK_013MandatoryFieldsCheckwithouttype() throws InterruptedException {
	    	faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	    	String enterfactorvlaue = String.valueOf(randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifymandatoryfieldforwithouttype( enterfactorvlaue);	
	    	
	    	
	    	
	    }
	    
	    
	    
	    @Test(priority=8,groups="group1")
	    public void TC_PCK_013MandatoryFieldsCheckwithoutfactor() throws InterruptedException {
	    	faker.name().firstName().translateEscapes();
	        String randomname1 = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	    	String.valueOf(randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifymandatoryfieldforwithoutfactor( randomname1);	
	    	
	    	
	    	
	    }
	    
	    @Test(priority=9,groups="group1")
	    public void TC_PCK_014DuplicatePackingSave() throws InterruptedException {
	    	String randomname = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();

	    	String enterfactorvlaue = String.valueOf(randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifyduplicateprompt(randomname, enterfactorvlaue);	
	    	
	    	
	    }
	    
	    
	    @Test(priority=10,groups="group1")
	    public void TC_PCK_021VerifyResetButton() throws InterruptedException {
	    	String randomname = faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        faker.name().firstName().translateEscapes();
	        faker.number().numberBetween(10, 50);
	        int randomint2 = faker.number().numberBetween(5, 10);
	    	
	    	String enterfactorvlaue = String.valueOf(randomint2);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifyresetbutton(randomname, enterfactorvlaue);
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    @Test(priority=11,groups="group1")
	    public void TC_PCK_015S_A_A_SClientSpecificDataSeparation() throws InterruptedException {
	    	 faker.number().numberBetween(10, 50);
	    	    int randomint2 = faker.number().numberBetween(5, 10);
	    	 String forfirstclientedit = faker.name().firstName().translateEscapes();
	    	 String forfirstclientsaveasnew = faker.name().firstName().translateEscapes();
	    	 faker.name().firstName().translateEscapes();
	    	String enterfactorvlaue = String.valueOf(randomint2);
	    	LoggerUtil.info("firstly user entered Rishi's I'd..");
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);	
	    	pack.savepackingdataforclientA(randomname,enterfactorvlaue);
	    	dashboard.clickOnlogoutbtn();
	    	Thread.sleep(2000);
	    	LoggerUtil.info("User Entered Munish's I'd..");
	    	login.loginApplication(prop.getProperty("username1"),prop.getProperty("password1"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);	
	    	pack.savepackingdataforclientB(randomname,enterfactorvlaue);
	    	dashboard.clickOnlogoutbtn();
	    	LoggerUtil.info("firstly user entered Rishi's I'd..");
	    	login.loginApplication(prop.getProperty("username"),prop.getProperty("password"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");           //User Enter for eidt the data in rishi's i'd
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);	
			pack.editinclientA(randomname,forfirstclientedit);
			Thread.sleep(2000);
			dashboard.clickOnlogoutbtn();
			LoggerUtil.info("User enter munish's id for verifying updated data from different client ....");
			login.loginApplication(prop.getProperty("username1"),prop.getProperty("password1"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);	
			pack.verifyupdateddatafromclientAisexsistornot(forfirstclientedit);
			dashboard.clickOnlogoutbtn();               
			LoggerUtil.info("firstly user entered Rishi's I'd..");
	    	login.loginApplication(prop.getProperty("username"),prop.getProperty("password"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");           //User Enter for eidt the data And save as new ..
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verifysaveasnewinfirstdata(forfirstclientedit,forfirstclientsaveasnew);
			Thread.sleep(3000);
			dashboard.clickOnlogoutbtn();
			Thread.sleep(3000);
			LoggerUtil.info("User enter munish's id for verifying Save As new  data from different client ....");
			login.loginApplication(prop.getProperty("username1"),prop.getProperty("password1"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);	
			pack.verifysaveasnewexistindifferentclientornot(forfirstclientsaveasnew);
			dashboard.clickOnlogoutbtn();
			LoggerUtil.info("firstly user entered Rishi's I'd..");
	    	login.loginApplication(prop.getProperty("username"),prop.getProperty("password"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");           //User Enter for eidt the data And save as new ..
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);
			pack.verfyafterdeletingdatainfirstandcheckimpactinsecondclient(randomname);
			dashboard.clickOnlogoutbtn();
			LoggerUtil.info("User enter munish's id for verifying Deletion impact from different client ....");
			login.loginApplication(prop.getProperty("username1"),prop.getProperty("password1"));   //User Save Same data in different i'd
	    	Thread.sleep(2000);
	    	dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(3000);
			dashboard.clickoncommodityMaster();
			Thread.sleep(3000);
			dashboard.Packingtab();
			Thread.sleep(2000);	
			pack.verifyafterdeletingfirstclientidshouldnotimpactinfirstid(randomname);
			
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
