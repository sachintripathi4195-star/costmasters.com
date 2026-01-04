package com.Tests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.ComdomesticPage;
import com.Pages.CommodityDetailsPage;
import com.Pages.CommoditygroupPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.ProcessMasterPage;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;
@Listeners(com.helper.TestListeners.class)
public class ComdomesticTest extends Base {

	 LoginPage login;
	    DashboardPage dashboard;
	    ComdomesticPage comdo;
	    CommodityDetailsPage comd;
	    Faker faker = new Faker();

	    String randomName = faker.name().firstName();
	    String randomName1 = faker.name().firstName();
	    String randomName2 = faker.name().firstName();
	    String randomName3 = faker.name().firstName();
	    int randomNumber = faker.number().numberBetween(1000, 9999);

	
	    @BeforeGroups(groups = {"group1", "group2","group3","group4"})
	    public void loginGroup() throws InterruptedException {
	        Base.launchApplication();
	        login = new LoginPage();
	        dashboard = new DashboardPage();   
	        comdo = new ComdomesticPage();
	        comd = new CommodityDetailsPage();
	        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	        Thread.sleep(3000);
	        LoggerUtil.info("Logged in once before the group test cases.");
	    }

	    @AfterGroups(groups = {"group1", "group2","group3","group4"})
	    public void logoutGroup() {
	        driver.quit();
	        LoggerUtil.info("Logged out after the group test cases.");
	    }
	
	   
		
	   @Test(priority=1,groups="group1")
	   public void TC_DI_001SaveRmGradeWithEffectiveDateDomesticImported() throws InterruptedException {
	
		   String commoditygroupvalue = faker.lorem().characters(10, false, false);
			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
		   dashboard.selectMenuFormDashBoard("Master Data");
		   Thread.sleep(3000);
		   dashboard.VerifyClickingMasterOptions("Commodity");
		   Thread.sleep(3000);
		   dashboard.clickOnAddcommodity();
		   Thread.sleep(2000);
		   CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		   Thread.sleep(3000);
		   dashboard.clickOncommoditygroup();
		   Thread.sleep(5000);
		   CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
					densityvalue);
		   Thread.sleep(2000);
		   dashboard.clickOnCommodityTabByName("Commodity Details");
		   Thread.sleep(3000);
		   comdo.savedataforcommodityDetailsfordomestic(commoditygroupvalue, groupclassificationvalue, specificgragevalue,commoditygroupvalue,"Commodity details saved successfully.");
		   
		   
		   
		   
	   }
	    
	   @Test(priority=2,groups="group1")
	   public void TC_DI_002SystemDateApplicabilityDomesticImported() throws InterruptedException {
		   
		   dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to 'Master Data' menu tab.");
	        Thread.sleep(3000);

	        dashboard.VerifyClickingMasterOptions("Commodity");
	        LoggerUtil.info("Navigated to 'Commodity Master' main tab.");
	        Thread.sleep(2000);

	        LocalDate today = LocalDate.now();
	        LoggerUtil.info("Preparing to verify system date in the details tab.");
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String todayDate = today.format(formatter);
	        LoggerUtil.info("Today's system date (expected): " + todayDate);

	        comdo.VerifyTodayDateForEffectiveDate(todayDate);
		   
		   
		   
		   
	   }
	   
	   
	   @Test(priority=3,groups="group1")
	   public void TC_DI_003DropdownValidationCommodityGroupClassificationSpecificGrade() throws InterruptedException {
		   
		   dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("Navigated to 'Master Data' menu tab.");
	        Thread.sleep(3000);

	        dashboard.VerifyClickingMasterOptions("Commodity");
	        LoggerUtil.info("Navigated to 'Commodity Master' main tab.");
	        Thread.sleep(2000);
	        
	        dashboard.clickOnCommodityTabByName("Commodity Details");
	        
	        
	        clickOnElement(ComdomesticPage.Domesticradiobtn);
		   
		    Thread.sleep(1000); // wait for input to appear

	      QuickMasterPage.VerifySearchFilterForCommodityDetailsTab();  
		   
		   
		   
	   }
	   @Test(priority = 4, groups = "group1")
		public void TC_CD_004MandatoryFieldValidationSaveWithEmptyFieldsWithOutCommodityGroup()
				throws InterruptedException {

			Thread.sleep(2000);

			dashboard.clickingDashboard("Dashboard");
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
			dashboard.VerifyClickingMasterOptions("Commodity");

			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			 clickOnElement(ComdomesticPage.Domesticradiobtn);
			   
			    Thread.sleep(1000); // wait for input to appear

			    ComdomesticPage.WithoutSelectingComGroup();

		}
	   

	   @Test(priority=5, groups="group1")
	    public void TC_YRLY_004MandatoryFieldValidationSaveWithoutUOM() throws InterruptedException {
	        
		   String commodityGroup = faker.name().firstName() + faker.letterify("????????");
			String groupClassification = faker.name().firstName() + faker.letterify("????");
			String specificGrade = faker.name().firstName() + faker.letterify("????");
			String density = faker.number().digits(5);

			Thread.sleep(2000);
			dashboard.clickingDashboard("Dashboard");
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
			dashboard.VerifyClickingMasterOptions("Commodity");
			Thread.sleep(2000);
			QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
			Thread.sleep(3999);
			dashboard.clickOncommoditygroup();
			Thread.sleep(2000);
			QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
					"Commodity Group Saved Successfully");
			Thread.sleep(3000);

			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			clickOnElement(ComdomesticPage.Domesticradiobtn);
			   
		    Thread.sleep(1000); 
		    ComdomesticPage.SaveComDetailsWithoutSelectingUOMDropDown(commodityGroup, groupClassification, specificGrade);

	    }

			
	   @Test(priority=6,groups="group1")
	   public void TC_YRLY_004MandatoryFieldValidationSaveWithoutCommoditygroupwithoutShape() throws InterruptedException 
	   {
		   
		   
		   String commodityGroup = faker.name().firstName() + faker.letterify("????????");
			String groupClassification = faker.name().firstName() + faker.letterify("????");
			String specificGrade = faker.name().firstName() + faker.letterify("????");
			String density = faker.number().digits(5);

			Thread.sleep(2000);
			dashboard.clickingDashboard("Dashboard");
			dashboard.selectMenuFormDashBoard("Master Data");
			Thread.sleep(2000);
			dashboard.VerifyClickingMasterOptions("Commodity");
			Thread.sleep(2000);
			QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
			Thread.sleep(3999);
			dashboard.clickOncommoditygroup();
			Thread.sleep(2000);
			QuickMasterPage.verifyNewCommGrpName(commodityGroup, groupClassification, specificGrade, density,
					"Commodity Group Saved Successfully");
			Thread.sleep(3000);

			dashboard.clickOnCommodityTabByName("Commodity Details");
			Thread.sleep(3000);
			clickOnElement(ComdomesticPage.Domesticradiobtn);
			   
		    Thread.sleep(1000); 
		    ComdomesticPage.SaveComDetailsWithoutSelectingShapeDropdown(commodityGroup, groupClassification, specificGrade);
		   
	   }
	   
	   
	   @Test(priority=7,groups="group1")
	   public void TC_DI_005AsteriskMarkingOnMandatoryFields() throws InterruptedException {
		   
		   dashboard.selectMenuFormDashBoard("Master Data");
	        LoggerUtil.info("User Clicked the Master Data successfully for mandatory validation.");
	        Thread.sleep(2000);
	        dashboard.VerifyClickingMasterOptions("Commodity");
	        Thread.sleep(3000);
	        dashboard.clickOnCommodityTabByName("Commodity Details");
	        Thread.sleep(3000);

	        List<String> requiredFields =comdo. getVisibleMandatoryLabelNamesOnly();
	        LoggerUtil.info("All mandatory fields: " + requiredFields);

		   
	   }
	   
	   
	 
	   
	   
	  
	  
	   
    
	   
	   
        @Test(priority=20,groups="group2")
        public void  TC_YRLY_017ShapeSelectionIBeamCorrectValueTableDisplay() throws InterruptedException {
      	  
        	String commoditygroupvalue = faker.lorem().characters(10, false, false);
    		String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
    		String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
    		String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
    		
    		
      	  dashboard.selectMenuFormDashBoard("Master Data");
      	  Thread.sleep(3000);
      	dashboard.VerifyClickingMasterOptions("Commodity");
      	  Thread.sleep(3000);
      	  dashboard.clickOnAddcommodity();
      	  
      	CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
      	  Thread.sleep(4000);
      	  dashboard.clickOncommoditygroup();
      	  Thread.sleep(3000);
      	CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
				densityvalue);
      	  Thread.sleep(3000);
      	dashboard.clickOnCommodityTabByName("Commodity Details");
      	  comdo.savedataforforIBeamvalueinShapeDropdown(commoditygroupvalue,groupclassificationvalue,specificgragevalue);
      	  String random1 = String.valueOf(faker.number().numberBetween(100, 999));
      	    String random2 = String.valueOf(faker.number().numberBetween(100, 999));
      	    String random3 = String.valueOf(faker.number().numberBetween(100, 999));
      	    String random4 = String.valueOf(faker.number().numberBetween(100, 999));
      	    String random5 = String.valueOf(faker.number().numberBetween(100, 999));
      	    
      	  comdo.enterparametevalueorsizeforibeam(random1,random2,random3,random4,random5,commoditygroupvalue);
      	  
      	  
      	 
        }

	   
	   
//	  @Test(priority=21,groups="group1") 
//      public void TC_DI_006UserRightsSupplierAndCustomerVisibility() throws InterruptedException {
//    	  
//		  Thread.sleep(8000);
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        LoggerUtil.info("User Clicked the Master Data successfully.");
//	        Thread.sleep(3000);
//	        dashboard.clickOnControlMaster();
//	        LoggerUtil.info("User entered the Control Master tab.");
//	        dashboard.clickOnusermaster();
//	        LoggerUtil.info("User entered the User Master tab.");
//	        Thread.sleep(3000);
//	        comdo.customerinvisiblityafteruserRight();
//    	  
//      }
//	   
//	   
//	   
//	  @Test(priority=21,groups="group1") 
//      public void TC_DI_006UserRightsSupplierAndCustomerVisibilityForSupplierVisibility() throws InterruptedException {
//    	  
//		  Thread.sleep(8000);
//	        dashboard.selectMenuFormDashBoard("Master Data");
//	        LoggerUtil.info("User Clicked the Master Data successfully.");
//	        Thread.sleep(3000);
//	        dashboard.clickOnControlMaster();
//	        LoggerUtil.info("User entered the Control Master tab.");
//	        dashboard.clickOnusermaster();
//	        LoggerUtil.info("User entered the User Master tab.");
//	        Thread.sleep(3000);
//	        comdo.supplierinvisiblityafteruserRight();
//    	  
//      }
//	   
//	   
//	   
	  @Test(priority=22,groups="group1")
	  public void TC_DI_013SaveUpdateAndSaveAsNewValidationForSaveAndUpdateVerification() throws InterruptedException {
		  
		  String commoditygroupvalue = faker.lorem().characters(10, false, false);
			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
		  
		  dashboard.selectMenuFormDashBoard("Master Data");
		   Thread.sleep(3000);
		   dashboard.VerifyClickingMasterOptions("Commodity");
		   
		   Thread.sleep(2000);
		   CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		   Thread.sleep(3000);
		   dashboard.clickOncommoditygroup();
		   Thread.sleep(5000);
		   CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
					densityvalue);
		   Thread.sleep(2000);
		   dashboard.clickOnCommodityTabByName("Commodity Details");
		   Thread.sleep(3000);
		   comdo.savedataforcommodityDetailsfordomesticForsaveandupdateverification(commoditygroupvalue, groupclassificationvalue, specificgragevalue,commoditygroupvalue);
		   
		  
		  
	  }
	   
	   
	  @Test(priority=22,groups="group1")
	  public void TC_DI_013SaveUpdateAndSaveAsNewValidationForSaveAsNew() throws InterruptedException {
		  
		  
		  String commoditygroupvalue = faker.lorem().characters(10, false, false);
			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
		  
		  dashboard.selectMenuFormDashBoard("Master Data");
		   Thread.sleep(3000);
		   dashboard.VerifyClickingMasterOptions("Commodity");
		   Thread.sleep(3000);
		   dashboard.clickOnAddcommodity();
		   Thread.sleep(2000);
		   CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		   Thread.sleep(3000);
		   dashboard.clickOncommoditygroup();
		   Thread.sleep(5000);
		   CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
					densityvalue);
		   Thread.sleep(2000);
		   dashboard.clickOnCommodityTabByName("Commodity Details");
		   Thread.sleep(3000);
	       comdo.savedataforcommodityDetailsfordomesticForSaveAsNew(commoditygroupvalue, groupclassificationvalue, specificgragevalue,commoditygroupvalue);
	 
	  }  
	
	  
	  @Test(priority=23,groups="group1")
	  public void TC_DI_016MultipleShapeEntriesForSameGrade() throws InterruptedException {
		  
		  String commoditygroupvalue = faker.lorem().characters(10, false, false);
			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
		  
		  dashboard.selectMenuFormDashBoard("Master Data");
		   Thread.sleep(3000);
		   dashboard.VerifyClickingMasterOptions("Commodity");
		   Thread.sleep(3000);
		   dashboard.clickOnAddcommodity();
		   Thread.sleep(2000);
		   CommodityDetailsPage.saveaddcommoditydata(commoditygroupvalue);
		   Thread.sleep(3000);
		   dashboard.clickOncommoditygroup();
		   Thread.sleep(5000);
		   CommodityDetailsPage.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
					densityvalue);
		   Thread.sleep(2000);
		   dashboard.clickOnCommodityTabByName("Commodity Details");
		   Thread.sleep(3000);
		  comdo.savedataforcommodityDetailsfordomesticWithSameGradeWithMultipleShape(commoditygroupvalue, groupclassificationvalue, specificgragevalue,commoditygroupvalue,"Commodity details saved successfully.");
		  
		 
	  }
//	  String commoditygroupval = faker.name().firstName();
//		String groupclassificationval = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//	  @Test(priority=24,groups="group1")
//	  public void TC_DI_017UniqueSupplierCustomerEntryForSameGrade() throws InterruptedException {
//		  
//		  String commoditygroupvalue = faker.lorem().characters(10, false, false);
//			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		  
//		  
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(3000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savedataforcommodityDetailsforcustomerxAndSupplierY(commoditygroupvalue, groupclassificationvalue, specificgragevalue,commoditygroupvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(5000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(4000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   comdo.savedataforcommodityDetailsforcustomerxAndSupplierYAgain(commoditygroupvalue, groupclassificationvalue,specificgragevalue,"Same records already exist for selected values.");
//		  
//
//	  }
//	  int whatif1 = faker.number().numberBetween(1000, 9999);
//		int whatif2 = faker.number().numberBetween(1000, 9999);
//		int whatif3 = faker.number().numberBetween(1000, 9999);
//		int scrapcost1 =faker.number().numberBetween(1000, 9999);
//		int scrapcost2 =faker.number().numberBetween(1000, 9999);
//		int scrapcost3 = faker.number().numberBetween(1000, 9999);
//	  @Test(priority=25,groups="group1")
//	  public void TC_DI_018WhatIfPricesSaveUpdate() throws InterruptedException {
//		  	  String whatif1 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String whatif2 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String whatif3 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String scrapcost1 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String scrapcost2 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String scrapcost3 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	 String whatif11 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	 String whatif12 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	  
//		  	String commoditygroupvalue = faker.lorem().characters(10, false, false);
//			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		  	 
//		  	 
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(3000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savedataforforwhatifprice(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//		   comdo.WhatIfPriceSaveAndUpdate(whatif1,whatif2,whatif3,scrapcost1,scrapcost2,scrapcost3,commoditygroupvalue);
//		   Thread.sleep(2000);  
//		   comdo.verifyupdateprice(whatif11, whatif12, whatif3, scrapcost1, scrapcost2, scrapcost3, commoditygroupvalue);
//		  
//		  
//	  
//	  }
//	  
//	  @Test(priority=25,groups="group1")
//	  public void TC_DI_018WhatIfPricesSaveAsNew() throws InterruptedException {
//		  	  String whatif1 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String whatif2 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String whatif3 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String scrapcost1 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String scrapcost2 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	String scrapcost3 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	 String whatif11 = String.valueOf( faker.number().numberBetween(1000, 9999));  
//		  	 String whatif12 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	 String whatif13 = String.valueOf( faker.number().numberBetween(1000, 9999));
//		  	 
//		  	 
//		  	String commoditygroupvalue = faker.lorem().characters(10, false, false);
//			String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//			String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//			String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		  	 
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(3000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savedataforforwhatifprice(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//		   comdo.WhatIfPriceSaveAndUpdate(whatif1,whatif2,whatif3,scrapcost1,scrapcost2,scrapcost3,commoditygroupvalue);
//		   Thread.sleep(2000);  
//		   comdo.verifysaveasnewpriceprice(whatif11, whatif12, whatif13, scrapcost1, scrapcost2, scrapcost3, commoditygroupvalue);
//		  
//		  
//	  
//	  }
//	  
//	  @Test(priority=26,groups="group1")
//	  public void TC_DI_020PlasticPropertiesVisibilityWhenPlasticSelected() throws InterruptedException {
//		  
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000); 
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.verifyplasticsproperties("plastics");
//		  
//	  }
//	  
//	  @Test(priority=27,groups="group1")
//	  public void TC_DI_021AddNewSupplierAndResetFields() throws InterruptedException {
//		  String suppcode = faker.name().firstName();
//		  	String suppname = faker.name().firstName();
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000); 
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.verifyaddsupplier(suppcode,suppcode,"steel");
//		  
//		  
//		  
//		  
//	  }
//	  
//	  @Test(priority=28,groups="group1")
//	  public void TC_DI_024_SupplierSelectionByBusinessSegment() throws InterruptedException {
//		  
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000); 
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		  comdo.verifybusinessSegmentautoselectosupplierornot();
//		  
//	  }
//	  
//	  @Test(priority=29,groups="group1")
//	  public void TC_DI_031_ViewToggleBetweenDomesticYearlyImportedForDomesticYear() throws InterruptedException {
//		  
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000); 
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.verifyUIforSelectingDomesticradiodifferentRadiobtn();
//		  
//		  
//		  
//		  
//	  }
//	  
//	  @Test(priority=30,groups="group1")
//	  public void TC_DI_031_ViewToggleBetweenDomesticYearlyImportedForImport() throws InterruptedException {
//		  
//		dashboard.selectMenuFormDashBoard("Master Data");  
//		 Thread.sleep(3000); 
//		 dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		  comdo.verifyUiDataForSelectingImportradiobtn();
//		  
//		  
//	  }
//	  
//		@Test(priority = 31, groups = "group1")
//		public void TC_DI_031_ViewToggleBetweenDomesticYearlyImportedForYearly() throws InterruptedException {
//
//			dashboard.selectMenuFormDashBoard("Master Data");
//			Thread.sleep(3000);
//			dashboard.VerifyClickingMasterOptions("Commodity");
//			Thread.sleep(3000);
//			dashboard.clickOnCommodityTabByName("Commodity Details");
//			Thread.sleep(3000);
//			comdo.verifyUIDataAfterSelectingYearlyRadioBtn();
//
//		}
//	  
//	  
//		
//		@Test(priority=32,groups="group1")
//		public void TC_DI_033_ViewSortingByNameDateModified() throws InterruptedException {
//			
//			dashboard.selectMenuFormDashBoard("Master Data");
//			Thread.sleep(3000);
//			dashboard.VerifyClickingMasterOptions("Commodity");
//			Thread.sleep(3000);
//			dashboard.clickOnCommodityTabByName("Commodity Details");
//			Thread.sleep(3000);
//			comdo.verifyCommodityColumnSorting("asc");
//
//			
//			
//			
//		}
//		
//		
//		@Test(priority=32,groups="group1")
//		public void TC_DI_033_ViewSortingByNameDateModifiedForDescendingOrderCommodityName() throws InterruptedException {
//			
//			dashboard.selectMenuFormDashBoard("Master Data");
//			Thread.sleep(3000);
//			dashboard.VerifyClickingMasterOptions("Commodity");
//			Thread.sleep(3000);
//			dashboard.clickOnCommodityTabByName("Commodity Details");
//			Thread.sleep(3000);
//			comdo.verifyCommodityColumnSorting("desc");
//
//		
//		}
//		
//	
//		
//@Test(priority=34,groups="group1")	
//public void TC_DI_037ViewSearchWorksWithYearlyDomesticImportedFilterForDomestic() throws InterruptedException {
//	
//	dashboard.selectMenuFormDashBoard("Master Data");
//	Thread.sleep(3000);
//	dashboard.VerifyClickingMasterOptions("Commodity");
//	Thread.sleep(3000);
//	dashboard.clickOnCommodityTabByName("Commodity Details");
//	Thread.sleep(3000);	
//	comdo.verifyviewworkaccordingToSelectingRadioBtn();
//	
//}
//		
//@Test(priority=35,groups="group1")
//public void TC_DI_037ViewSearchWorksWithYearlyDomesticImportedFilterForImported() throws InterruptedException {
//	dashboard.selectMenuFormDashBoard("Master Data");
//	Thread.sleep(3000);
//	dashboard.VerifyClickingMasterOptions("Commodity");
//	Thread.sleep(3000);
//	dashboard.clickOnCommodityTabByName("Commodity Details");
//	Thread.sleep(3000);	
//	comdo.verifyViewWorkWithimportRadioBtn();
//	
//}
//		
//@Test(priority=36,groups="group1")
//public void TC_DI_037ViewSearchWorksWithYearlyDomesticImportedFilterForByDefaultYearly() throws InterruptedException {
//	dashboard.selectMenuFormDashBoard("Master Data");
//	Thread.sleep(3000);
//	dashboard.VerifyClickingMasterOptions("Commodity");
//	Thread.sleep(2000);
//	dashboard.clickOnCommodityTabByName("Commodity Details");
//	Thread.sleep(3000);
//	comdo.verifyviewbuttonworkingwellwhenbuttonclickyear();
//
//	
//}
//		
//		
//@Test(priority=37,groups="group1")
//public void TC_DI_036ViewAutomaticDropdownsBasedOnPreviousSelection() throws InterruptedException {
//	
//	String commoditygroupvalue = faker.lorem().characters(10, false, false);
//	String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//	String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//	String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//	
//	
//	dashboard.selectMenuFormDashBoard("Master Data");
//	   Thread.sleep(3000);
//	   dashboard.VerifyClickingMasterOptions("Commodity");
//	   Thread.sleep(3000);
//	   dashboard.clickOnAddcommodity();
//	   Thread.sleep(2000);
//	   comdo.saveaddcommoditydata(commoditygroupvalue);
//	   Thread.sleep(3000);
//	   dashboard.clickOncommoditygroup();
//	   Thread.sleep(5000);
//	   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//	   Thread.sleep(2000);
//	   dashboard.clickOnCommodityTabByName("Commodity Details");
//	   Thread.sleep(3000);
//	   comdo.verifydropdownisSelectedOrNot(commoditygroupvalue,groupclassificationvalue,specificgragevalue);
//	
//}
//	@Test(priority=38,groups="group1")	
//   public void TC_DI_038ViewResetClearsData() throws InterruptedException {
//		
//		
//		
//		dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		 	Thread.sleep(2000);
//		 	comdo.verifyresetbtnisworkingwell();
//	
//	}
//		
//	@Test(priority=39,groups="group1")
//	public void TC_DI_038ViewResetClearsDataForImport() throws InterruptedException {
//		
//		dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		 	Thread.sleep(2000);
//		comdo.vereifyresetbuttonisworkingforimportornot();
//		
//		
//		
//	}
//	
//	@Test(priority=40,groups="group1")
//	public void TC_DI_034ViewSearchResultMatchesTotalCountSearchFilterForCommodityGroup() throws InterruptedException {
//		
//		dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		 	Thread.sleep(2000);
//		comdo.verifysearchfilter();
//		
//			
//	}
//	
//	
//	
//	 int randomNumber1 = faker.number().numberBetween(1000, 9999);
//	 int randomNumber2 = faker.number().numberBetween(1000, 9999);
//	@Test(priority=41,groups="group1")	
//    public void TC_DI_010_SpecificDeltaSupplieAndCustomerAllocationForSupplierAllocation() throws InterruptedException {
//	
//		String commoditygroupvalue = faker.lorem().characters(10, false, false);
//		String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		
//		String suppdeltarm = String.valueOf(randomNumber1);
//		String suppdeltadeltascrap = String.valueOf(randomNumber2);
//		 dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(3000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savecommoditydetailsForsupplierDelta(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//	       Thread.sleep(2000);
//	       comdo.selectsuppdeltaforsaveAndverify(suppdeltarm, suppdeltadeltascrap, commoditygroupvalue);
//	
//}
//	@Test(priority=42,groups="group1")
//	public void TC_DI_010_SpecificDeltaSupplieAndCustomerAllocationForSupplierAllocationForCustomer() throws InterruptedException {
//		
//		String commoditygroupvalue = faker.lorem().characters(10, false, false);
//		String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		
//		String custodeltarm = String.valueOf(randomNumber1);
//		String custodeltadeltascrap = String.valueOf(randomNumber2);
//		 dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(3000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savecommoditydetailsForsupplierDelta(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//	       Thread.sleep(2000);
//		
//	       comdo.SelectcustomerdeltaforSaveAndVerify(custodeltarm, custodeltadeltascrap, commoditygroupvalue);
//	        
//	}
//	  
//	@Test(priority = 43, groups = "group1")
//	public void TC_DI_011_NegativeValuesInSpecificDeltaForSupplierDelta() throws InterruptedException {
//       
//		
//		
//		String commoditygroupvalue = faker.lorem().characters(10, false, false);
//		String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		
//		String suppdeltarm = String.valueOf(-randomNumber1);
//		String suppdeltadeltascrap = String.valueOf(-randomNumber2);
//		
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(3000);
//		dashboard.VerifyClickingMasterOptions("Commodity");
//		Thread.sleep(3000);
//		dashboard.clickOnAddcommodity();
//		Thread.sleep(2000);
//		comdo.saveaddcommoditydata(commoditygroupvalue);
//		Thread.sleep(3000);
//		dashboard.clickOncommoditygroup();
//		Thread.sleep(5000);
//		comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue,
//				densityvalue);
//		Thread.sleep(2000);
//		dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savecommoditydetailsForsupplierDelta(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//		   comdo.selectsuppdeltaforsaveAndverify(suppdeltarm, suppdeltadeltascrap, commoditygroupvalue);
//		
//	}
//	
//	
//	@Test(priority=42,groups="group1")
//	public void TC_DI_011_NegativeValuesInSpecificDeltaForCustomerDelta() throws InterruptedException {
//		
//		String commoditygroupvalue = faker.lorem().characters(10, false, false);
//		String groupclassificationvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String specificgragevalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);
//		String densityvalue = faker.name().firstName()+" " +faker.number().numberBetween(10,99);	
//		
//		String custodeltarm = String.valueOf(-randomNumber1);
//		String custodeltadeltascrap = String.valueOf(-randomNumber2);
//		 dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnAddcommodity();
//		   Thread.sleep(2000);
//		   comdo.saveaddcommoditydata(commoditygroupvalue);
//		   Thread.sleep(3000);
//		   dashboard.clickOncommoditygroup();
//		   Thread.sleep(5000);
//		   comdo.savesecondtabcommoditygroup(commoditygroupvalue, groupclassificationvalue, specificgragevalue, densityvalue);
//		   Thread.sleep(2000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.savecommoditydetailsForsupplierDelta(commoditygroupvalue, groupclassificationvalue, specificgragevalue);
//	       Thread.sleep(2000);
//		
//	       comdo.SelectcustomerdeltaforSaveAndVerify(custodeltarm, custodeltadeltascrap, commoditygroupvalue);
//	        
//	}
//	 int basicos = faker.number().numberBetween(10, 99);
//	 int freightcos = faker.number().numberBetween(10, 99);
//	 int conversioncos =  faker.number().numberBetween(10, 99);
//	 int wastagecos = faker.number().numberBetween(10, 99);
//	 int freight2cos =  faker.number().numberBetween(10, 99);
//	 int other1cos =  faker.number().numberBetween(10, 99);
//	 int other2cos =  faker.number().numberBetween(10, 99);
//	 int enterotherfacfirst = faker.number().numberBetween(10, 99);
//	 int enterotherfacsecond = faker.number().numberBetween(10, 99);
//	 int enterotherfacThird = faker.number().numberBetween(10, 99);
//	 int entertaxdiscountabsolute= faker.number().numberBetween(10,99);
//	 @Test(priority = 43, groups = "group2")
//	 public void TC_DI_014_EditableFieldsTensileShearPrices() throws InterruptedException {
//
//	     LoggerUtil.info("Started execution of TC_DI_014_EditableFieldsTensileShearPrices");
//
//	     try {
//	         dashboard.selectMenuFormDashBoard("Master Data");
//	         LoggerUtil.info("Selected 'Master Data' from dashboard.");
//	         Thread.sleep(3000);
//
//	         dashboard.VerifyClickingMasterOptions("Commodity");
//	         LoggerUtil.info("Clicked on 'Commodity Master'.");
//	         Thread.sleep(3000);
//
//	         dashboard.clickOnCommodityTabByName("Commodity Details");
//	         LoggerUtil.info("Clicked on 'Commodity Details' tab.");
//	         Thread.sleep(3000);
//
//	         comdo.fillCostFieldsAndCalculate(
//	             basicos, freightcos, conversioncos, wastagecos,
//	             freight2cos, other1cos, other2cos,
//	             enterotherfacfirst, enterotherfacsecond, enterotherfacThird,
//	             entertaxdiscountabsolute
//	         );
//
//	         LoggerUtil.info("✅ Test case TC_DI_014 passed.");
//
//	     } catch (Exception e) {
//	         LoggerUtil.info("❌ Test case TC_DI_014 failed. Exception: " + e.getMessage());
//	         Assert.fail("Test failed due to: " + e.getMessage());
//	     }
//	 }
//
//
//	
//     @Test(priority=44,groups="group2")
//	 public void TC_DI_028_ExportWholeNewgradeadditionDataFetchingForWhole() throws InterruptedException{
//	
//    	 dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.ReadDataFromExcelFileWithWholePrice();
//	
//}
//	
//	
//	@Test(priority=45,groups="group2")
//	public void TC_DI_027ImportWholeNewGradeAdditionHistoryCreation() throws InterruptedException, IOException {
//		
//		
//		dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000);
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		  comdo.importPriceValueForCreatingHistory();
//		  Thread.sleep(2000);
//		 comdo.verifyLandedCostInExcel();
//		 Thread.sleep(200);
//		 
//		 comdo.uploadExcelFile();
//			
//	}
//	
//	
//	 @Test(priority = 24, groups = "group1")
//	   public void TC_DI_022NewSupplierAppearsInstantlyInDropdownWithoutRefresh() throws InterruptedException {
//	       
//		 String suppcode = faker.name().firstName();
//		  	String suppname = faker.name().firstName();
//		  dashboard.selectMenuFormDashBoard("Master Data");
//		   Thread.sleep(3000); 
//		   dashboard.VerifyClickingMasterOptions("Commodity");
//		   Thread.sleep(3000);
//		   dashboard.clickOnCommodityTabByName("Commodity Details");
//		   Thread.sleep(3000);
//		   comdo.verifyaddsupplier(suppcode,suppcode,"steel");
//	   }
//
//	
	
	
	
	
	 
	
	
	
	  
	  
	  
}
