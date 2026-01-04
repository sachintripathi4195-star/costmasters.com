package com.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.CustomerMasterPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.SupplierMasterPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
@Listeners(com.helper.TestListeners.class)



public class CustomerMasterTest extends Base {


	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
	CustomerMasterPage customerpage = new CustomerMasterPage();
	Faker faker = new Faker();
	// Generate random string data
	String randomName = faker.name().firstName();

	@BeforeGroups(groups = {"group1", "group2","group3","group4"})
    public void loginGroup() throws InterruptedException {
        Base.launchApplication();
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
	public void TC_001_verifySaveDataWithValidCredetialInBusinessDomain() throws InterruptedException {

		String randomName = faker.name().firstName()+faker.letterify("?????");
		
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("User Clicking CustomerMaster....");
		
		customerpage.enterValuesbusinessdomain(randomName);
 
	}

	@Test(priority=2,groups="group1")
	public void verifySaveDataWithValidCredentialInBusinessSegment() throws InterruptedException {

		String CategoryName = faker.name().firstName()+faker.letterify("?????");
	
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.enterValuesbusinessSegment(CategoryName,"Business Segment sucessfully saved.");	




	}

	@Test(priority=3,groups="group1")
	public void verifySaveDataWithInvalidCredentials() throws InterruptedException {

		
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
	
		dashboard.VerifyClickingMasterOptions("Customer");
		customerpage.enterInvalidValuesbusinessSegment("@@@@","Special characters are not allowed except '/' and '-'.");	


	}

	@Test(priority=4,groups="group1")
	public void VerifyRestrictingDuplicateEntriesinBusinessDomain() throws InterruptedException{

		String CategoryName = faker.name().firstName()+faker.letterify("???????");
		
		dashboard.selectMenuFormDashBoard("Master Data");
	
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		customerpage.enterValuesbusinessdomain(CategoryName);
		Thread.sleep(4000);
		customerpage.VerifyDuplicateEntryToastMessage(CategoryName,"Business domain already exist.");

	}


	@Test(priority=5,groups="group1")
	public void VerifyRestrictingDuplicateEntriesinBusinessSegment()throws InterruptedException {;

	String categoryType = faker.name().firstName()+faker.letterify("???????");
	LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
	dashboard.selectMenuFormDashBoard("Master Data");
	
	Thread.sleep(3000);
	dashboard.VerifyClickingMasterOptions("Customer");
	customerpage.enterValuesbusinessSegment(categoryType,"Business Segment sucessfully saved.");

	customerpage.enterduplicateentrywithbusinessSegment(categoryType,"Business Segment already exist.");

	}
	@Test(priority=6,groups="group1")
	public void VerifyingexistingDataAfterupdatingToSaveProperly() throws InterruptedException {

		String categoryType = faker.name().firstName()+faker.letterify("???????");
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		Thread.sleep(2000);
		customerpage.enterValuesbusinessSegment(categoryType,"Business Segment sucessfully saved.");

		customerpage.clickEditButton(1,categoryType,"Business Segment sucessfully saved.");

	}


	@Test(priority=7,groups="group1")
	public void verifyPlaceHolderTextWhenUserDoesNotEntreAnyValue() throws InterruptedException {

		

		LoggerUtil.info("Verified UserName Box Is Writable & Password Box Is Writable...");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Open CostMasterDashBoard And Click Master");
		LoggerUtil.info("User Clicked On MasterData");

		Thread.sleep(3000);

		LoggerUtil.info("Verify User Click The Customer Master ");
		dashboard.VerifyClickingMasterOptions("Customer");
		
		
		LoggerUtil.info("User Try To Enter The Value For Validate Enter Are Available Or Not");

		 customerpage.validateShadowTextInvisible(CustomerMasterPage.entercategorynamevalues, "test");
		 
		customerpage.validateShadowTextVisible(CustomerMasterPage.entercategorynamevalues);

		Thread.sleep(3000);
	}

	@Test(priority=8,groups="group1")
	public void clicknextbutton() throws InterruptedException {

		
		LoggerUtil.info("Verified UserName Box Is Writable & Password Box Is Writable...");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Open CostMasterDashBoard And Click Master");
		LoggerUtil.info("User Clicked On MasterData");

		Thread.sleep(3000);
		
            dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.clicknextpagebutton();

	}

	@Test(priority=9,groups="group1")

	public void verifyBusinessDomainSegmentLengthtable() throws InterruptedException {

		
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.clickbuttonOnBusinessDomainSegmentTab();
		Thread.sleep(6000);	
		
		customerpage.businessdomainsegmentlengthtable("25");


	}




	@Test(priority=10,groups="group1")
	public void verifyBusinessDomainSegmentLengthFOrFifty() throws InterruptedException {

		
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Open CostMasterDashBoard And Click Master");
		LoggerUtil.info("user Click On MasterData");
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.clickbuttonOnBusinessDomainSegmentTab();
		Thread.sleep(6000);	
		
		customerpage.clickbusinessdomainsegmentlengthtableforfifty("50");



	}

	@Test(priority=11,groups="group2")
	public void verifyBusinessDomainSegmentLengthFOrSeventyFive() throws InterruptedException {

		
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Open CostMasterDashBoard And Click Master");
		LoggerUtil.info("user Click On MasterData");
		dashboard.VerifyClickingMasterOptions("Customer");
	
		customerpage.clickbuttonOnBusinessDomainSegmentTab();
		Thread.sleep(6000);	
		
		customerpage.clickbusinessdomainsegmentlengthtableforseventyfive("75");

	}


	@Test(priority=12,groups="group2")    
	public void testSortingByCustomerCode() throws InterruptedException {

		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.sortingWithCustomerCode();


		// Verify that the list is sorted in descending order
		// Assert.assertTrue(customerpage.isSortedDescending(sortedList), "customer codes are not sorted in descending order!");
	}


	@Test(priority=13,groups="group2")
	public void verifyTestSortingByCustomerName() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		LoggerUtil.info("User click The Button MasterData From Dashboard ");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage. sortingWithcustomerName();
		Thread.sleep(4000);


	}


	@Test(priority=14,groups="group2")
	public void verifySortingButtonIsWorkingInCustomerLocation() throws InterruptedException {
		

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User selected 'Master Data' from Dashboard");

		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("User navigated to 'Supplier Master' page");

		LoggerUtil.info("Clicking on 'Supplier Location' header for sorting");
		customerpage.sortingWithcustomerLocation();

		LoggerUtil.info("Verifying if the Supplier Location column is sorted in descending order");
		List<String> sortedLocations = customerpage.getcustomerLocation();

		Thread.sleep(4000);
		Assert.assertTrue(customerpage.isSortedDescending(sortedLocations), 
				"Sorting failed: Supplier Location column is not in descending order");

		LoggerUtil.info("Supplier Location sorting verified successfully.");
	}


	@Test(priority=15,groups="group2")
	public void verifySortingButtonIsWorkingInBusinessDomain() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User selected 'Master Data' from Dashboard");

		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("User navigated to 'Supplier Master' page");

		LoggerUtil.info("Clicking on 'Business Domain' header for sorting");
		customerpage.sortingWithBusinessDomain();

		LoggerUtil.info("Verifying if the Business Domain column is sorted in descending order");
		List<String> sortedDomains = customerpage.getBusinessDomain();

		Assert.assertTrue(customerpage.isSortedDescending(sortedDomains), 
				"Sorting failed: Business Domain column is not in descending order");

		LoggerUtil.info("Business Domain sorting verified successfully.");
	}


	@Test(priority=16,groups="group2")
	public void verifySortingButtonIsWorkingInBusinessSegment() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User selected 'Master Data' from Dashboard");

		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("User navigated to 'Supplier Master' page");

		LoggerUtil.info("Clicking on 'Business Segment' header for sorting");
		customerpage.sortingWithBusinessSegment();

		LoggerUtil.info("Verifying if the Business Segment column is sorted in descending order");
		List<String> sortedSegments = customerpage.getBusinessSegment();

		Assert.assertTrue(customerpage.isSortedDescending(sortedSegments), 
				"Sorting failed: Business Segment column is not in descending order");

		LoggerUtil.info("Business Segment sorting verified successfully.");
	}



	@Test(priority=17,groups="group2")
	public void verifyInvalidChoosePhoto() throws InterruptedException {
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.selectFile("Only PNG and JPG formats are allowed");
		Thread.sleep(4000);
	}

	@Test (priority=18,groups="group2")
	public void verifyAfterClickingEditButtonAllDataEnterASWellInParticularBoxOrNot() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		LoggerUtil.info("User Click The Save Button On Supplier Page");	
		dashboard.VerifyClickingMasterOptions("Customer"); 
		
		customerpage. verifyClickingEditButtonWorksCorrectly("Ankesh");

	}
	@Test(priority=19,groups="group2")
	public void VerifyPopMessageForSpecialCharacterInCustomerCode() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		LoggerUtil.info("User Click The Save Button On Supplier Page");	
		dashboard.VerifyClickingMasterOptions("Customer");  
		
		customerpage.EnterInvalidDataInSupplierCOde("arun","@","mohali");

	}




	@Test(priority=20,groups="group2")
	public void verifyLengthOfTableArePresentInCustomerPageAccordingToUser() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.VerifyClickingMasterOptions("Customer"); 
		
		customerpage.lengthmeasuringincustomererpage("25");

	}

	@Test(priority=21,groups="group3")
	public void verifyLengthOfTableArePresentInCustomerPageAccordingToUserMoreThanTwentyFive() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.VerifyClickingMasterOptions("Customer"); 
		
		customerpage.lengthmeasuringincustomererpage("50");

	}


	@Test(priority=22,groups="group3") 
	public void verifyLengthOfTableArePresentInCustomerPageAccordingToUserMoreThanFifty() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.VerifyClickingMasterOptions("Customer"); 
		
		customerpage.lengthmeasuringincustomererpage("75");

	}

	@Test(priority=23,groups="group3")
	public void verifyCostingCouldNotDeleteWithBusinessDOmain() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");

		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.deletingcostingsegmentdata("002","rahul","haryana","rishi");


	}


	@Test(priority = 24,groups="group3")
	public void verifyCustomerAllocationOfProcessMaster() throws InterruptedException {
		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.enterCustomerValueForProcessAllocation("004", "Ritik", "Noida");

	}

	@Test(priority = 25,groups="group3")
	public void verifyCustomerAllocationOfCommodity() throws InterruptedException {

		
		// Navigate to Customer Master
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("✅ Navigated to 'Master Data'");

		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("✅ Clicked on 'Customer Master'");

		// Enter customer details and save
		LoggerUtil.info("📝 Entering customer details: Code - R009, Name - Ronaldo123, Location - Bihar");
		customerpage.entercustomervalueforrminput("R118", "Ronaldo123", "noida");

		Thread.sleep(5000); // Wait for save to complete

		// Navigate to Commodity Master
		dashboard.clickoncommodityMaster();
		Thread.sleep(3000);

		// Search for "plastic" and open 12th row in edit
		customerpage.commoditytab();
		Thread.sleep(2000);

		customerpage.clickEditIn12thRow();
		Thread.sleep(4000); // Wait for edit page to load

		// Validate if supplier (custcode) is selected
		customerpage.searchAndVerifySelection("R009");
	}

	private CustomerMasterPage commoditytab() {
		return customerpage;
	}


	@Test(priority=25,groups="group3")
	public void ImportAndWriteNewExcelFile() throws InterruptedException {

		
		// Navigate to Customer Master
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("✅ Navigated to 'Master Data'");

		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("✅ Clicked on 'Customer Master'"); 

		
		customerpage.ExportandImportForNewExcelFile();

	}

	@Test(priority=26,groups="group3")
	public void VerifyUserCanNotSaveAnyDataAfterUncheckedReadAndWrite() throws InterruptedException {


		
		// Navigate to Customer Master
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickOnControlMaster();
		customerpage.clickUserButtonTocheckUserAuthorization();
	}




	@Test(priority=27,groups="group3")
	public void VerifyPlaceholderNameIsVisibleOrnotWithoutAnyEntry() throws InterruptedException {

		
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");	
		dashboard.VerifyClickingMasterOptions("Customer");
		customerpage.validateShadowTextInvisible(CustomerMasterPage.customercode ,"test");
		
		customerpage.validateShadowTextVisible1(CustomerMasterPage.customercode );

	}

	
	@Test(priority=28,groups="group3")
	public void verifyCustomerAllocationOfOHP() throws InterruptedException {
		
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(8000);
		LoggerUtil.info("User Select Master Data From Dashboard");	
		dashboard.VerifyClickingMasterOptions("Customer");	
		Thread.sleep(8000);
		
		LoggerUtil.info("verify User Enter The customer location Sucessfully");
		customerpage.UserCLickOhPCheckBox("c001", "customer222", "mohali");
		
		Thread.sleep(7000);
		dashboard.clickOnOHPMaster();
		LoggerUtil.info("User Is Getting Checked Customer Which Is Selected In Customer Page ");
		customerpage.verifyingAllocationInOhp();
		
		
		
		
	}
	
	@Test(priority = 29, groups = "group3")
	public void verifyCustomerAllocationForRm() throws InterruptedException {

	    LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(8000);

	    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
	    dashboard.VerifyClickingMasterOptions("Customer");
	    Thread.sleep(8000);

	   

	    // Actual execution of steps (all logic handled in the page method)
	    customerpage.verifyUserEnterThevalueForRmAllocation("ram001", "ram", "mohali", "ram");

	    LoggerUtil.info("✅ Test Case Passed: Customer RM Allocation verified successfully and checkbox is selected.");
	}

		@Test(priority=30,groups="group3")
		public void verifyWithoutCustomerCodeShouldNotSave() throws InterruptedException {
			
			

		    LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(2000);
            
		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(3000);
		   
		    
		    customerpage.Savewithoutcustomercode("raghav","mohali","Required Customer Code.!");
			
					
		}

		
		@Test(priority=31,groups="group3")
		public void verifyWithoutCustomerNameShouldNotSave() throws InterruptedException {
			
			LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");
		    Thread.sleep(8000);

		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    LoggerUtil.info("User Try To Save Data Without Customer Name");
		    LoggerUtil.info("User Enter The Customer Code Value ");
		    LoggerUtil.info("User Enter The Customer Location ");
		    LoggerUtil.info("User Click The Save Button ");
		    LoggerUtil.info("User Getting PopUp");
		    Thread.sleep(8000);
			customerpage. SaveWithoutCustomerName("c001","mohali","Required Customer Name.!");
			
				
		}
		
		@Test(priority=32,groups="group3")
		public void verifygeneratepopupwithoutsavinglocation() throws InterruptedException {
			

			LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");
		   

		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		  
		    customerpage.savewithoutcustomerlocation("cus001","customer112","Required Customer Location.!");
			
			
			
		}
		
		
		@Test(priority=33,groups = "group4")
		public void verifyinvalidGstNumberDoesNotSaveInCustomerPage() throws InterruptedException {
			
			LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");
		   

		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(2000);
		  
			
			customerpage.saveDataWithoutValidGSTNumber("cust112","customer419","lucknow","27ABCDE1234F","Please EnterValidGstNumber");
			
			
		}

		
		@Test(priority=34,groups ="group4")
		public void verifyStateDropDownInCustomerPageIsWorkingWellOrNot() throws InterruptedException {
			LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");
		   

		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
			
		    customerpage.selectstatedropdown("Andhra Pradesh");
		    
			
		}
		
		
		@Test(priority = 35, groups = "group4")
		public void VerifyThatWhenUserUpdatesTheCategoryTypeOrCategoryNameTheChangesReflectInAllRelevantDropdownsFoeBusinessSegmentAcrossCommodityMasters() throws InterruptedException {

		    dashboard.selectMenuFormDashBoard("Master Data");
		    LoggerUtil.info("  Navigated to 'Master Data' menu from the dashboard.");

		    LoggerUtil.info("  Opening 'Customer Master' to update Business Segment category.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(4000);

		    LoggerUtil.info("  Editing an existing customer record to update Category Type to 'categorytype'.");
		    customerpage.clickeditbtnandupdatecategorynameandcategorytype("categorytype");
		    Thread.sleep(7000);

		    LoggerUtil.info(" Navigating to 'Commodity Master' to verify updated Category Type.");
		    dashboard.clickoncommodityMaster();

		    LoggerUtil.info("  Verifying that the updated Category Type 'categorytype' is reflected in the Business Segment dropdown under the Commodity Details tab.");
		    customerpage.verifybusinessSegmentDropdownInCommodityDetailsTab("categorytype");
		}

		
		
		
		@Test(priority = 36, groups = "group4")
		public void VerifyResetButtonIsWorkingOrNotInCustomerPage() throws InterruptedException {

		    LoggerUtil.info(" Navigating to 'Master Data' section from the dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");

		    LoggerUtil.info(" Clicking on 'Customer Master' to access customer records.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(4000);

		    LoggerUtil.info(" Entering sample data into customer form fields: Customer Code = 'cust001', Customer Name = 'there', Customer Short Name = 'four'.");
		    LoggerUtil.info(" Clicking on the 'Reset' button to verify if all input fields are cleared properly.");

		    customerpage.verifyUserClickResetButton("cust001", "there", "four");

		    LoggerUtil.info(" Verifying that all fields have been cleared and no residual values remain after clicking reset.");
		}

		@Test(priority = 37, groups = "group4")
		public void verifyDropdownPlaceholdersInCustomerMaster() throws InterruptedException {

		    LoggerUtil.info(" Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");

		    LoggerUtil.info(" Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(3000);

		    LoggerUtil.info(" Verifying placeholder text for Business Domain dropdown.");
		    customerpage.verifyDropdownPlaceholderText(CustomerMasterPage.businessDomainDropdown, "None Selected", "Business Domain");

		    LoggerUtil.info(" Verifying placeholder text for Business Segment dropdown.");
		    customerpage.verifyDropdownPlaceholderText(CustomerMasterPage.businessSegmentDropdown, "None Selected", "Business Segment");

		    LoggerUtil.info(" Verifying placeholder text for State dropdown.");
		    customerpage.verifyStateDropdownPlaceholder1("Select");

		    LoggerUtil.info(" All dropdown placeholders verified successfully on Customer Master page.");
		}

		@Test(priority = 38, groups = "group4")
		public void verifyCategoryTypeDropdownPlaceholderInCustomerMaster() throws InterruptedException {

		    LoggerUtil.info(" Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");

		    LoggerUtil.info(" Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(3000);

		    LoggerUtil.info(" Clicking on 'Business Domain/Segments' tab.");
		    

		    LoggerUtil.info(" Verifying placeholder text for 'Category Type' dropdown.");
		    customerpage. getCategoryDropdownDefaultValue();

		    LoggerUtil.info("✅ Category Type dropdown placeholder verified successfully.");
		}

		@Test(priority = 40, groups = "group4")
		public void verifyCategoryNameTextboxPlaceholderInCustomerMaster() throws InterruptedException {

		    LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");

		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(3000);

		    LoggerUtil.info("Step 3: Clicking on 'Business Domain/Segments' tab.");
		   

		    LoggerUtil.info("Step 4: Verifying placeholder text for 'Category Name' textbox.");
		    customerpage.verifyTextboxPlaceholderText(CustomerMasterPage.categoryNameTextbox, "Enter", "Category Name");

		    LoggerUtil.info("✅ Category Name textbox placeholder verified successfully.");
		}
     
		@Test(priority = 41, groups = "group4")
		public void verifyUpdatedCategoryTypeAndNameReflectsInAllMasters() throws InterruptedException {

		    LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
		    dashboard.selectMenuFormDashBoard("Master Data");

		    LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
		    dashboard.VerifyClickingMasterOptions("Customer");
		    Thread.sleep(4000);

		    LoggerUtil.info("Step 3: Editing and updating Category Type and Category Name.");
		    customerpage.clickeditbtnandupdatecategorynameandcategorytype1( "UpdatedName123");
		    Thread.sleep(7000); // Wait for update to reflect

		    LoggerUtil.info("Step 4: Navigating to 'Commodity Master' to verify reflection.");
		    dashboard.clickoncommodityMaster();

		    LoggerUtil.info("Step 5: Verifying updated Category Type/Name in Business Segment dropdown of Commodity Master.");
		    customerpage.verifybusinessSegmentDropdownInCommodityDetailsTab1("UpdatedName123");

		    LoggerUtil.info("✅ Updated Category Type and Name reflected successfully across all relevant masters.");
		}

		@Test(priority=42,groups="group4")
		public void verifySaveDataWithValidCredentialInBusinessSegmentAndItShouldAlreadyAppearInTableWithoutRefreshing() throws InterruptedException {

			
			LoggerUtil.info("Logged in with user&passwork     " + prop.getProperty("username")      +prop.getProperty("password"));
			LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
			dashboard.selectMenuFormDashBoard("Master Data");
			LoggerUtil.info("Open CostMasterDashBoard And Click Master");
			LoggerUtil.info("user Click On MasterData");
			Thread.sleep(3000);
			dashboard.VerifyClickingMasterOptions("Customer");
			
			customerpage.enterValuesbusinessSegment(randomName,"Business Segment sucessfully saved.");	
			LoggerUtil.info("User Enter The Value Which Is saved By User "+ randomName);
			LoggerUtil.info("Finally User Getting Value Without Refreshing Page");
             Thread.sleep(3000);
             customerpage.SearchBusinessSegValue(randomName);
              


		}
		@Test(priority=43,groups="group4")
		public void verifySaveDataWithValidCredentialInBusinessDomainAndItShouldAlreadyAppearInTableWithoutRefreshing() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork     " + prop.getProperty("username")      +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Open CostMasterDashBoard ");
		LoggerUtil.info("user Click On MasterData");
		LoggerUtil.info("User Click The CustomerMaster");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.enterValuesbusinessSegment(randomName,"Business Domain sucessfully saved.");	
		LoggerUtil.info("User Enter The Value Which Is saved By User "+ randomName);
		LoggerUtil.info("Finally User Getting Value Without Refreshing Page");
         Thread.sleep(3000);
        
         
         
	}
		
		
		
		
		@Test(priority=44,groups="group4")
		public void verifyplaceholdervalue() throws InterruptedException {
			
			LoggerUtil.info("Logged in with user&passwork     " + prop.getProperty("username")      +prop.getProperty("password"));
			LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
			dashboard.selectMenuFormDashBoard("Master Data");
		
			Thread.sleep(3000);
			dashboard.VerifyClickingMasterOptions("Customer");
			customerpage.verifyCustomerCodePlaceholder("Enter");
			
			
			
		}
		
		
		
		
		@Test(priority =45,groups="group4")
		public void verifyDefaultBusinessDomainDropdownInCustomer() throws InterruptedException {
			LoggerUtil.info("Logged in with user&passwork     " + prop.getProperty("username")      +prop.getProperty("password"));
			LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
			dashboard.selectMenuFormDashBoard("Master Data");
			
			Thread.sleep(3000);
			dashboard.VerifyClickingMasterOptions("Customer");
		    Assert.assertTrue(customerpage.isBusinessDomainDefaultValueSelectInCustomer(),
		        "Default value for Business Domain dropdown should be 'Select'");
		}
		
		
		@Test(priority=46,groups="group4")
		public void verifyDeleteButtonIsWorkingProperly() throws InterruptedException {
			
			LoggerUtil.info("Logged in with user&passwork     " + prop.getProperty("username")      +prop.getProperty("password"));
			LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
			dashboard.selectMenuFormDashBoard("Master Data");
			LoggerUtil.info("Open CostMasterDashBoard ");
			LoggerUtil.info("user Click On MasterData");
			LoggerUtil.info("User Click The CustomerMaster");
			Thread.sleep(3000);
			dashboard.VerifyClickingMasterOptions("Customer");
		
			customerpage.deletebutton("0099999",randomName,"mohali","0099999");
			
			
			
		}
		
		@Test(priority=47,groups="group4")
		public void verifyEditAndUpdateBtn() throws InterruptedException {
			LoggerUtil.info("Logged in with user&passwork     " + prop.getProperty("username")      +prop.getProperty("password"));
			LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
			dashboard.selectMenuFormDashBoard("Master Data");
			
			Thread.sleep(3000);
			dashboard.VerifyClickingMasterOptions("Customer");
			
			customerpage.updatebtn(randomName,randomName,"Customer Profiles Updated successfully.");
			
			
			
		}
		
		@Test(priority =48,groups="group4")
		public void verifySaveAsNewBtn() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
	
		customerpage.clickSaveAsNewbtn("Customer Profiles already exist");
		}

		@Test(priority=49,groups="group4")
		public void dataAlreadyUsedIncosting() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.deletecostingdata("Data Already Being Used in Costing!");
		}
		@Test(priority=50,groups="group4")
		public void excelduplicateentry() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		
		customerpage.duplicateentrry();
		}
		
		
		
		
		/////////////////////////////////////////////////////////////////////
		@Test(priority = 51, groups = "group4")
		public void validateWithUiAndExcel() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("🟡 Starting validation between UI and Excel data...");

		// Step 1: Get latest downloaded Customer Master Excel file
		File latestFile = Base.getLatestCustomerMasterFIle();
		LoggerUtil.info("📁 Latest Excel File: " + latestFile.getAbsolutePath());

		// Step 2: Get customer codes from Excel
		List<String> excelCustomerCodes = customerpage.getSortedCustomerCodes(latestFile.getAbsolutePath());
		LoggerUtil.info("📊 Excel Data (sorted): " + excelCustomerCodes);

		// Step 3: Get customer codes from UI
		List<String> uiDataList = customerpage.fetchCustomerList();
		Collections.sort(uiDataList);
		LoggerUtil.info("🖥️ UI Data (sorted): " + uiDataList);

		// Step 4: Limit to top 25 for comparison
		int comparisonSize = Math.min(25, Math.min(uiDataList.size(), excelCustomerCodes.size()));
		List<String> excelTop25 = excelCustomerCodes.subList(0, comparisonSize);
		List<String> uiTop25 = uiDataList.subList(0, comparisonSize);

		LoggerUtil.info("🔢 Comparing top " + comparisonSize + " records between UI and Excel...");

		// Step 5: Compare records
		for (int i = 0; i < comparisonSize; i++) {
		String uiValue = uiTop25.get(i).trim().replaceAll("[^a-zA-Z0-9]", "");
		String expectedValue = excelTop25.get(i).trim().replaceAll("[^a-zA-Z0-9]", "");

		String detail = "SN = " + (i + 1) + " | UI: " + uiValue + " | Excel: " + expectedValue;

		if (uiValue.equalsIgnoreCase(expectedValue)) {
		LoggerUtil.pass("✅ MATCHED: " + detail);
		} else {
		LoggerUtil.info("❌ MISMATCH: " + detail);
		}
		}

		LoggerUtil.info("🟢 Validation between UI and Excel completed.");
		LoggerUtil.info("Ui And Excel Data Are Not Matching Randomly . ");
		}

		@Test(priority=52,groups="group4")
		public void clickeditbtnandcheckallcheckbox() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Open CostMasterDashBoard ");
		LoggerUtil.info("user Click On MasterData");
		LoggerUtil.info("User Click The CustomerMaster");
		Thread.sleep(3000);
		dashboard.VerifyClickingMasterOptions("Customer");
		LoggerUtil.info("user search click The edit button which is allocating the checkboxes");
		LoggerUtil.info("User verify All check boxes are clicked sucessfully");
		LoggerUtil.info("Rm , Commodity , Process are clicked sucessfully");
		customerpage.checkbox("17122024-003");
		}
		@Test(priority=53,groups="group3")
		public void VerifyUserCanNotRead() throws InterruptedException {


		// Navigate to Customer Master
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickOnControlMaster();
		customerpage.clickUserButtonTocheckUserAuthorization();
		}

		
       @Test(priority=54,groups="group3")
       public void verifyWhenUserCreateNewBusinessDomainItShouldApperInBusinessDomainAndSegmentTable() throws InterruptedException {
    	   
    	   dashboard.selectMenuFormDashBoard("Master Data");
   		   LoggerUtil.info(" Navigated to 'Master Data'");
   		   dashboard.VerifyClickingMasterOptions("Customer");
   		  
   		   customerpage.createNewEntryOfBusinessDomain( randomName ,"Business domain sucessfully saved.",randomName);
    	   
    	   
    	   
       
    	   
       }
		
       @Test(priority=33, groups = "group3")
       public void verifyCheckSavePrompt() throws InterruptedException {

           LoggerUtil.info("Step 1: Navigating to 'Master Data' from Dashboard.");
           dashboard.selectMenuFormDashBoard("Master Data");

           LoggerUtil.info("Step 2: Clicking on 'Customer Master' section.");
           dashboard.VerifyClickingMasterOptions("Customer");

           Thread.sleep(8000);

          

           customerpage.VerifyCheckSavePrompt(randomName, randomName, "lucknow");
       }
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
