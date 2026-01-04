package com.Tests;
 
import static org.testng.Assert.assertEquals;
 
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
 
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.ProcessMasterPage;
import com.Pages.SupplierMasterPage;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.helper.Base;
import com.helper.LoggerUtil;
 
import quickTestPointMasterPage.QuickMasterPage;
@Listeners(com.helper.TestListeners.class)
 
 
public class SupplierMasterTest extends Base {
 
     QuickMasterPage quick = new QuickMasterPage();
	private static final char[] PhoneNumber = null;
	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
	SupplierMasterPage supplier = new SupplierMasterPage();
	ProcessMasterPage pmaster = new ProcessMasterPage();
 
	Faker faker = new Faker();
	// Generate random string data
	String randomName = faker.name().firstName();
	String randomNumber = String.valueOf(faker.number().randomNumber());
 
 
	@BeforeGroups(groups = {"group1", "group2","group3","group4"})
	public void loginGroup() throws InterruptedException {
		Base.launchApplication();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		
		LoggerUtil.info("Logged in once before the group test cases.");
	}
 
	@AfterGroups(groups = {"group1", "group2","group3","group4"})
	public void logoutGroup() {
		driver.quit();
		LoggerUtil.info("Logged out after the group test cases.");
	}
 
	@Test(priority=1,groups="group1")

	public void verifyEnterDataWithBusinessDomain() throws InterruptedException {
		String randomName = faker.name().firstName();
	
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		

		
	
		supplier.savedatawithbusinessdomain(randomName,"Business domain sucessfully saved.");
		
	}

	@Test(priority=2,groups="group1")

	public void verifyEnterDataWithBusinesssegment() throws InterruptedException {

		String randomName = faker.name().firstName();
		
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(5000);
	
		
		supplier.savedatawithbusinesssegment(randomName,"Business Segment sucessfully saved.");

	}


	@Test(priority=3,groups="group1")
	public void verifyDuplicateDataWithBusinessBomainissavedornot() throws InterruptedException {
		
		String randomName = faker.name().firstName();
		

		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(9000);
		
		
		supplier.savedatawithbusinessdomain(randomName,"Business domain sucessfully saved.");  
		Thread.sleep(3000);
		supplier.saveudplicatedata(randomName,"Business domain already exist.");


	}



	@Test (priority=4,groups="group1")
	public void verifyDuplicateDataWithBusinessSegmentSavedOrNot() throws InterruptedException {

		String randomName = faker.name().firstName()+faker.letterify("?????");
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(6000);
		
		
		supplier.savedatawithbusinesssegment(randomName,"Business Segment sucessfully saved.");
		Thread.sleep(3000);
		supplier.saveudplicatedataWithBusinessSegment(randomName, "Business Segment already exist.");

	}

	@Test (priority=5,groups="group1")
	public void verifyEditButtonIsWorkingOrNotWithBusinessDomain() throws InterruptedException {
		
		String Categoryname = faker.name().firstName()+faker.letterify("?????");

		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		Thread.sleep(4000);
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(6000);
		
		supplier.savedatawithbusinessdomain(Categoryname,"Business domain sucessfully saved.");  
		Thread.sleep(4000);
		quick.VerifyDataBusinessDomainAndSegmentAreSaveOrNot(Categoryname);
		Thread.sleep(4000);
		
		
		
		
		quick.VerifyEditButtonFunctionalityForBusinessDomAndSegTabSupp( Categoryname);


	}
	

	@Test (priority=6,groups="group1")
	public void verifyBusinessDomainSegmentLengthtable() throws InterruptedException {

		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		LoggerUtil.info("verified UserName Box Is writable & Password Box Is writable.....");
		dashboard.selectMenuFormDashBoard("Master Data");
	
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(6000);
		
		supplier.businessdomainsegmentlengthtable("25");

	}

	@Test(priority=7,groups="group1")
	public void verifyBusinessDomainSegmentLengthFOrFifty() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(6000);
		
		supplier.clickbusinessdomainsegmentlengthtableforfifty("50");
	}
	@Test(priority=8,groups="group1")
	public void verifyBusinessDomainSegmentLengthFOrSeventyFive() throws InterruptedException {
		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(6000);
		
		supplier.clickbusinessdomainsegmentlengthtableforseventyfive("75");
	}


	@Test (priority =9,groups="group1")
	public void verifyNextButtonIsClickableOrNot() throws InterruptedException {
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickonsuppliermaster();
		
		Thread.sleep(4000);
		supplier.clickbusinessseganddomainpage();
		supplier.findsecondpagefirstrowtwentysixthnumber();

	}


	@Test(priority=10,groups="group1")

	public void verifyCostingCouldNotDeleteWithBusinessDOmain() throws InterruptedException {


		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");

		dashboard.clickonsuppliermaster();
		
		supplier.entersuppliertab("002","rahul","haryana","rishi");


	}

	@Test(priority = 12, groups = "group2")
	public void verifySaveDataWithInvalidEmailIdInCostingShouldNotBeSaved() throws InterruptedException {

		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");

		dashboard.clickonsuppliermaster();
		

		boolean isValidationWorked = supplier.userEnterWithInValiDataInSupplierPage(
				"00234", "Adesh", "haryana", "ADITYA",
				"arpit.com", "rahul.com", "6306384195", "8317028283",
				"Enter valid email"
				);

		Assert.assertTrue(isValidationWorked, "Invalid email prompt not shown — Validation failed!");
	}
	@Test(priority = 13, groups = "group2")
	public void verifyUserDataSaveAsItIsInSupplierListOrNot() throws Exception {
     
		int randnumber = faker.number().numberBetween(10, 900);
		String suppcode = String.valueOf(randnumber);
		String suppname = faker.name().firstName()+faker.letterify("?????");
        String Supplocation = faker.address().cityName();
        String suppmanagername = faker.name().firstName()+faker.letterify("????");
        PhoneNumber contactnumber = faker.phoneNumber();
        String phone1 = String.valueOf(contactnumber);
        
        PhoneNumber Contactnumber2 = faker.phoneNumber();
        String phone2 = String.valueOf(Contactnumber2);
		LoggerUtil.info(" [Login] Logging into application and navigating to Supplier Master menu...");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("✅ Clicked on 'Master Data' from Dashboard.");

		dashboard.clickonsuppliermaster();
		LoggerUtil.info("✅ Clicked on 'Supplier Master' tab from side menu.");

		LoggerUtil.info(" [Action] Navigating to Supplier List and verifying saved data...");

		// Expected data that should be present in table
		String expectedSupplierCode = suppcode;
		String expectedSupplierName = suppname;
		String expectedSupplierLocation = Supplocation;
		String expectedBusinessDomain = "rishi";
		String expectedBusinessSegments = "sachindra1";

		supplier.userEnterWithInValiDataInSupplierPage(
				suppcode, suppname, Supplocation, suppmanagername,
				"@arpit.com", "@rahul.com", "8888888888"," 7777777777",
				"Enter valid email"
				);

Thread.sleep(9000);
		// Table verification
		boolean isDataPresent = supplier.IsDataSavedAsItIsInTableOrNot(
				expectedSupplierCode,
				expectedSupplierName,
				expectedSupplierLocation,
				expectedBusinessDomain,
				expectedBusinessSegments
				);

		if (isDataPresent) {
			
		} else {
			LoggerUtil.error(" [Failure] Expected supplier data was not found in the table.");
			LoggerUtil.error(" Data mismatch or not saved correctly. Please recheck test inputs or data entry flow.");
		}

		Assert.assertTrue(isDataPresent,
				" [Assertion Failed] Supplier data not matched in table. Expected:\n" +
						" • Code: " + expectedSupplierCode + "\n" +
						" • Name: " + expectedSupplierName + "\n" +
						" • Location: " + expectedSupplierLocation + "\n" +
						" • Domain: " + expectedBusinessDomain + "\n" +
						" • Segment: " + expectedBusinessSegments
				);
	}



	
	@Test(priority=16,groups="group2")
	public void VerifyPlaceholderNameIsVisibleOrnotWithoutAnyEntry() throws InterruptedException {
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickonsuppliermaster();
		
		supplier.validateShadowText(SupplierMasterPage.suupliercode,"test");
		supplier.validateShadowText(SupplierMasterPage.suupliercode,"");
	}
	@Test(priority=16,groups="group2")
	public void VerifyPlaceholderNameIsVisibleOrnotWithoutAnyEntryForSupplierName() throws InterruptedException {
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickonsuppliermaster();
		
		supplier.validateShadowText(SupplierMasterPage.suppliername,"test");
		supplier.validateShadowText(SupplierMasterPage.suppliername,"");
	}
	
	@Test(priority=16,groups="group2")
	public void VerifyPlaceholderNameIsVisibleOrnotWithoutAnyEntryForSupplierLocation() throws InterruptedException {
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickonsuppliermaster();
		
		supplier.validateShadowText(SupplierMasterPage.supplerlocation,"test");
		supplier.validateShadowText(SupplierMasterPage.supplerlocation,"");
	}
	
	@Test(priority=17,groups="group2")
	public void VerifyEditAndRestButtonToCheckNewEntriesAreSavedOrNot() throws InterruptedException {
		
		String randomName = faker.name().firstName()+faker.letterify("??????");
		String updaterRandomName = faker.name().firstName()+faker.letterify("????");
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		Thread.sleep(3000);
		supplier.clickbusinessseganddomainpage();
		Thread.sleep(4000);
		supplier.savedatawithbusinessdomain(randomName,"Business domain sucessfully saved.");
		
		supplier.verifySearchValueandResetButtonIsWorkingOrNot(randomName, randomName,randomName);
	}
	@Test(priority = 18, groups = "group2")
	public void verifyAfterClickingEditButtonAllDataEnterASWellInParticularBoxOrNot() throws InterruptedException {

		LoggerUtil.info(" [START] Test: Verify Edit Button loads correct data in fields.");

		LoggerUtil.info(" Step 1: Logging in and navigating to 'Master Data > Supplier Master'...");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info(" Clicked on 'Master Data'.");

		dashboard.clickonsuppliermaster();
		LoggerUtil.info(" Clicked on 'Supplier Master' tab.");

		LoggerUtil.info(" Step 2: Searching Supplier by Name → 'Ankesh'");
		supplier.verifyClickingEditButtonWorksCorrectly("Ankesh");

		LoggerUtil.info(" Step 3: Clicked on [Edit] icon for Supplier 'Ankesh'");

		// Fetch data from the form fields
		Map<String, String> actualData = supplier.getSupplierDataAfterEdit();
		String actualCode = actualData.get("code");
		String actualName = actualData.get("name");

		// Define expected values
		String expectedCode = "003";
		String expectedName = "Ankesh";

		LoggerUtil.info("📋 Step 4: Comparing Expected vs Actual Data:");
		LoggerUtil.info("➡️ Supplier Code → Expected: '" + expectedCode + "' | Actual: '" + actualCode + "'");
		LoggerUtil.info("➡️ Supplier Name → Expected: '" + expectedName + "' | Actual: '" + actualName + "'");

		boolean isMatch = actualCode.equals(expectedCode) && actualName.equals(expectedName);

		if (isMatch) {
			LoggerUtil.info(" [PASS] All values matched correctly after clicking Edit.");
		} else {
			LoggerUtil.error(" [FAIL] Mismatch found in values after Edit action!");
			if (!actualCode.equals(expectedCode)) {
				LoggerUtil.error(" Supplier Code Mismatch → Expected: '" + expectedCode + "' but got: '" + actualCode + "'");
			}
			if (!actualName.equals(expectedName)) {
				LoggerUtil.error(" Supplier Name Mismatch → Expected: '" + expectedName + "' but got: '" + actualName + "'");
			}
		}

		Assert.assertTrue(isMatch, "Assertion failed — Supplier Code/Name did not match after Edit.");
		LoggerUtil.info("[END] Test execution complete.");
	}

	@Test(priority = 19, groups = "group2")
	public void VerifyPopMessageForSpecialCharacterInSupplierCode() throws InterruptedException {

		String suppliername = faker.name().firstName()+faker.letterify("?????");
		String supplierLocation = faker.address().state();
		LoggerUtil.info("🟩 [START] Test: Verify validation message for special character in Supplier Code");

		LoggerUtil.info("🔐 Step 1: Logging in and navigating to 'Master Data > Supplier Master'...");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("✅ Clicked on 'Master Data' from dashboard.");
		dashboard.clickonsuppliermaster();
		LoggerUtil.info("✅ Clicked on 'Supplier Master' tab from side menu.");

		LoggerUtil.info("📝 Step 2: Filling supplier form with invalid Supplier Code...");
		Thread.sleep(5000);
		
		String supplierCode = "@";
		
		String expectedMessage = "Special characters are not allowed except '/', '-', '_', and '.'.";

		LoggerUtil.info("➡️ Entered Supplier Name: " + suppliername);
		LoggerUtil.info("➡️ Entered Invalid Supplier Code: " + supplierCode);
		LoggerUtil.info("➡️ Entered Location: " + supplierLocation);
		
		Thread.sleep(4000);

		String actualMessage = supplier.EnterInvalidDataInSupplierCOde(suppliername, supplierCode, supplierLocation);

		LoggerUtil.info("📋 Step 3: Validating error message...");
		LoggerUtil.info("➡️ Expected Message: " + expectedMessage);
		LoggerUtil.info("➡️ Actual Message: " + actualMessage);
		Thread.sleep(3000);
		if (actualMessage.contains(expectedMessage)) {
			LoggerUtil.info("✅ [PASS] Correct validation message appeared for special character.");
		} else {
			LoggerUtil.error("❌ [FAIL] Incorrect or missing validation message for invalid supplier code.");
		}
		Thread.sleep(3000);
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"❌ Assertion failed — Expected message not found!\nExpected: " + expectedMessage + "\nActual: " + actualMessage);

		LoggerUtil.info("🟦 [END] Test execution complete.");
	}

	@Test(priority=20,groups="group2")
	public void verifyLengthTableInSupplierPage() throws InterruptedException {

		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.lengthmeasuringinsupplierpage("25");
	}
	@Test(priority=21,groups="group3")
	public void verifyPopUpWhenUserChooseInvalidPhoto() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		supplier.selectFile();
	}
	@Test(priority=22,groups="group3")
	public void verifyNextButtonIsWorkingProperlyOrNot() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickonsuppliermaster();
		
		supplier.clicknextbuttonInsupplier();
	}
	@Test(priority=25,groups="group3")
	public void verifyTestSortingBySupplierName() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		dashboard.clickonsuppliermaster();
		
		supplier. sortingWithSupplierName();
		
		List<String> suppliernames = supplier.getSupplierName();
		Thread.sleep(4000);
	}
	@Test(priority=26,groups="group3")
	public void verifySortingButtonIsWorkingInSupplierLocation() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		
		dashboard.clickonsuppliermaster();
		
		supplier.sortingWithSupplierLocation();
		
		List<String> sortedLocations = supplier.getSupplierLocation();
		Thread.sleep(4000);
		Assert.assertTrue(supplier.isSortedDescending(sortedLocations),
				"Sorting failed: Supplier Location column is not in descending order");
		
	}

	@Test(priority=27,groups="group3")
	public void verifySortingButtonIsWorkingInBusinessDomain() throws InterruptedException {
		

		dashboard.selectMenuFormDashBoard("Master Data");
		

		dashboard.clickonsuppliermaster();
		

		
		supplier.sortingWithBusinessDomain();

		
		List<String> sortedDomains = supplier.getBusinessDomain();

		Assert.assertTrue(supplier.isSortedDescending(sortedDomains),
				"Sorting failed: Business Domain column is not in descending order");

		LoggerUtil.info("Business Domain sorting verified successfully.");
	}

	@Test(priority=28,groups="group3")
	public void verifySortingButtonIsWorkingInBusinessSegment() throws InterruptedException {
		LoggerUtil.info("User entered username and password successfully");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User selected 'Master Data' from Dashboard");

		dashboard.clickonsuppliermaster();
		LoggerUtil.info("User navigated to 'Supplier Master' page");

		LoggerUtil.info("Clicking on 'Business Segment' header for sorting");
		supplier.sortingWithBusinessSegment();

		LoggerUtil.info("Verifying if the Business Segment column is sorted in descending order");
		List<String> sortedSegments = supplier.getBusinessSegment();

		Assert.assertTrue(supplier.isSortedDescending(sortedSegments),
				"Sorting failed: Business Segment column is not in descending order");

		LoggerUtil.info("Business Segment sorting verified successfully.");
	}

	@Test(priority = 29, groups = "group3")
	public void verifyExportExcelFileAndValidateWithUIData() throws InterruptedException {
	    LoggerUtil.info("🟩 [START] verifyExportExcelFileAndValidateWithUIData test execution started");

	    dashboard.selectMenuFormDashBoard("Master Data");
	    LoggerUtil.info("➡ Navigated to 'Master Data' from Dashboard");
	    Thread.sleep(3000);

	    dashboard.clickonsuppliermaster();
	    LoggerUtil.info("➡ Clicked on 'Supplier Master'");
	    Thread.sleep(3000);

	    supplier.exportexcelfile();
	    LoggerUtil.info("📤 Supplier Master Excel export initiated");
	    Thread.sleep(9000);

	    File latestFile = Base.getLatestSupplierMasterFile();
	    LoggerUtil.info("📂 Latest exported Excel file found: " + latestFile.getAbsolutePath());

	    List<String> excelSupplierCode = SupplierMasterPage.getSortedSupplierCodes(latestFile.getAbsolutePath());
	    LoggerUtil.info("📊 Extracted Supplier Codes from Excel: " + excelSupplierCode.size());

	    List<String> uiDataList = supplier.fetchSupplierList();
	    Collections.sort(uiDataList);
	    LoggerUtil.info("📊 Extracted Supplier Codes from UI: " + uiDataList.size());

	    int comparisonSize = Math.min(25, Math.min(uiDataList.size(), excelSupplierCode.size()));
	    List<String> excelTop25 = excelSupplierCode.subList(0, comparisonSize);

	    LoggerUtil.info("🔎 Validating top " + comparisonSize + " records between UI and Excel");

	    for (int i = 0; i < comparisonSize; i++) {
	        String uiValue = uiDataList.get(i).trim().replaceAll("^0+(?!$)", "");
	        String expectedValue = excelTop25.get(i).trim().replaceAll("^0+(?!$)", "");

	        String detail = "SN == " + (i + 1)
	                + " | actualValue == " + uiValue
	                + " | expectedValue == " + expectedValue;

	        if (uiValue.equals(expectedValue)) {
	            LoggerUtil.pass("✅ Match Found → " + detail);
	        } else {
	            LoggerUtil.error("❌ Mismatch → " + detail);
	        }
	    }

	    LoggerUtil.info("🟦 [END] verifyExportExcelFileAndValidateWithUIData test execution completed");
	}

	@Test(priority=31,groups="group3")
	public void importnewexcelfile() throws InterruptedException {
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickonsuppliermaster();
		supplier.exportandimportnewdata();
	}
	@Test(priority=33,groups="group3")
	public void VerifySupplierAllocationInOHPMaster() throws InterruptedException {
		LoggerUtil.info("Verify User Click The LoginButton ");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Verify User Click The Master Data From The DashBoard ");
	 	Thread.sleep(3000);
		dashboard.clickonsuppliermaster();
		supplier.verifyingohpallocation("s001", "supplier222", "mohali");
		LoggerUtil.info("Verify User Fill The All Valid Credential In Supplier Page");
		LoggerUtil.info("Verify User Is User Click The Button On View Page");
		LoggerUtil.info("Verify Enter The supplier code");
		LoggerUtil.info("User Is Not getting Supplier Name Or Suppplier Code Properly = s001 ");
		Thread.sleep(3000);
		dashboard.clickOnOHPMaster();
		LoggerUtil.info("That's Whhy nUser Is Getting Error");
		supplier.verifyingAllocationInOhp("supplier222","sachindra1");
		Thread.sleep(6000);
	}
	@Test(priority=34,groups="group3")
	public void VerifySupplierMasterDoesNotSaveWithoutSelectiongSupplierName() throws InterruptedException {
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickonsuppliermaster();
		
		supplier.VerifyWithoutSelectingSupplierName("004","chandigarh","Required Supplier Name.!");
	}
	@Test (priority=35,groups="group3")
	public void verifySupplierMasterDoesNotSaveWithoutSelectingSupplierLocation() throws InterruptedException {
		Thread.sleep(4000);
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickonsuppliermaster();
		
		supplier.verifyWithoutSelectingSupplierLocation("004","supname","Required Supplier Location.!");
	}

	@Test(priority=36,groups="group3")
	public void verifysupplierMasterDoesNotSaveWithoutSelectingBusinessDomain() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickonsuppliermaster();
		
		supplier.verifyWithoutSelectingBusinessDomain("004","supname","chandigarh","Required Business Domain.!");
	}
//	@Test(priority=37,groups="group4")
//	public void verifySupplierMasterDoesNotSaveWithoutSelectingBusinessSegment() throws InterruptedException {
//		dashboard.selectMenuFormDashBoard("Master Data");
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("Verify User Click The Dashboard ");
//		LoggerUtil.info("Verify User The Master Data ");
//		LoggerUtil.info("User Click The Supplier Name = supname");
//		LoggerUtil.info("User CLick The Supplier Code = 004" );
//		LoggerUtil.info("'Verify user Enter The Supplier Location = Chandigarh");
//		LoggerUtil.info("User Select The Business Domain DropDown = rishi");
//		LoggerUtil.info("Verify User Get PopUp when user Click The Save Button ");
//		LoggerUtil.info("Required Business Segment.!");
//		supplier.verifyWithoutSelectingBusinessDomain("004","supname","chandigarh","Required Business Domain.!");
//	}
//	@Test(priority = 39, groups = "group4")
//	public void importDuplicateExcelData() throws InterruptedException {
//
//		LoggerUtil.info("🟩 [START] Test: Verify system shows validation when duplicate supplier data is imported from Excel.");
//
//		// Step 1: Navigate to Supplier Master
//		LoggerUtil.info("🔐 Step 1: Navigating to 'Master Data > Supplier Master'...");
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("✅ Clicked on 'Master Data'.");
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("✅ Clicked on 'Supplier Master' tab.");
//
//		// Step 2: Export and fill Excel with valid data
//		LoggerUtil.info("📥 Step 2: Exporting and generating supplier data Excel...");
//		supplier.exportandimportnewdata();
//		LoggerUtil.info("✅ Excel generated and filled with supplier data.");
//
//		// Store duplicate data used in Excel (these should match fillSupplierSheet() values)
//		String supplierCode = supplier.supplierCode; // assuming these are stored in class
//		String supplierName = supplier.supplierName;
//		String supplierLocation = "Text-905";
//		String businessDomain = "rishi123";
//		String businessSegment = "sachindra1";
//
//		Thread.sleep(3000); // Wait for Excel ready
//
//		// Step 3: Import same Excel again to simulate duplicate
//		LoggerUtil.info("📤 Step 3: Re-importing same Excel file to simulate duplicate scenario...");
//		supplier.importNewSupplierMasterExcel();
//
//		// Step 4: Capture toast message
//		LoggerUtil.info("📋 Step 4: Validating toast message for duplicate entry...");
//		String actualMessage = supplier.getDuplicateAlertText();
//		String expectedMessage = "Supplier already exists";
//
//		// Step 5: Log duplicated data for audit
//		LoggerUtil.info("📝 Duplicate attempted with the following data:");
//		LoggerUtil.info("➡️ Supplier Code: " + supplierCode);
//		LoggerUtil.info("➡️ Supplier Name: " + supplierName);
//		LoggerUtil.info("➡️ Location: " + supplierLocation);
//		LoggerUtil.info("➡️ Business Domain: " + businessDomain);
//		LoggerUtil.info("➡️ Business Segment: " + businessSegment);
//
//		LoggerUtil.info("➡️ Expected Toast: " + expectedMessage);
//		LoggerUtil.info("➡️ Actual Toast: " + actualMessage);
//
//		if (actualMessage.contains(expectedMessage) || actualMessage.contains("Duplicate")) {
//			LoggerUtil.info("✅ [PASS] Duplicate validation message appeared as expected.");
//		} else {
//			LoggerUtil.error("❌ [FAIL] No duplicate warning or incorrect toast message.");
//		}
//
//		// Assertion
//		Assert.assertTrue(actualMessage.contains(expectedMessage) || actualMessage.contains("Duplicate"),
//				"❌ Assertion Failed — Duplicate message not shown correctly.\nExpected: " + expectedMessage + "\nActual: " + actualMessage
//				);
//
//		LoggerUtil.info("🟦 [END] Test complete — duplicate import validation finished.");
//	}
//	@Test(priority = 40, groups = "group4")
//	public void VerifyThatWhenUserUpdatesTheCategoryTypeOrCategoryNameTheChangesReflectInAllRelevantDropdownsAcrossCommodityMasters() throws InterruptedException {
//		dashboard.selectMenuFormDashBoard("Master Data");
//
//		LoggerUtil.info("🟩 [START] Test: Verify updated Category Name reflects in Business Segment dropdown of other masters.");
//
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("✅ Clicked on 'Supplier Master' from dashboard.");
//
//		LoggerUtil.info("🔧 Step 1: Updating Category Name to 'kumar' in Business Domain/Segment Tab...");
//		supplier.checktheuserupdatethecategorynameandtypethechangeswillreflectsinothermastersDropdown("kumar");
//
//		LoggerUtil.info("🔄 Step 2: Navigating to 'Commodity Master'...");
//		dashboard.clickOnCommodityMaster();
//
//		LoggerUtil.info("🔍 Step 3: Verifying updated category in Business Segment dropdown...");
//		supplier.verifyIncommoditydetailsTabBusinessSegment("kumar");
//
//		LoggerUtil.info("🟦 [END] Test execution complete for category update propagation.");
//	}
//
//	@Test(priority=41,groups="group4")
//	public void VerifyThatWhenUserUpdatesTheCategoryTypeOrCategoryNameTheChangesReflectInAllRelevantDropdownsAcrossProcessMasters() throws InterruptedException {
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("🟩 [START] Test: Verify updated Category Name reflects in Business Segment dropdown of other masters.");
//
//		LoggerUtil.info("🔧 Step 1: Updating Category Name to 'kumar' in Business Domain/Segment Tab...");
//		Thread.sleep(8000);
//		LoggerUtil.info("Verify User Click The Process Item");
//		LoggerUtil.info("Vrify User Click The Business Segment DropDown");
//		LoggerUtil.info("Verify The User Enter The Value Which Is Created in Supplier Master In Business Domain And Segment Tab = kumar " );
//		LoggerUtil.info("Verify The User Enter The Same Value in process Master business Segment DropDown = Kumar ");
//		dashboard.clickOnProcessItem();
//		supplier.verifyInProcessMAsterTabBusinessSegmentDropDown("kumar");
//	}
//	@Test(priority = 42, groups = "group3")
//	public void verifyBusinessDomainDropdownPlaceholderShouldBeSelectWithoutSelectingAnyValue() throws InterruptedException {
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("Navigated to Master Data");
//
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("Opened Supplier Master");
//
//		Thread.sleep(3000); // allow page to load completely
//		LoggerUtil.info("Verify The Business Domain and Segment Dropdown Placeholder ");
//		LoggerUtil.info("Verify Without Selecting PlaceHolder Value Should be Displayed = None selected" );
//
//		// Get placeholder text from the bootstrap multiselect dropdown
//		String placeholder = driver.findElement(By.xpath("//button[contains(@class,'multiselect') and contains(@class,'dropdown-toggle')]")).getAttribute("title");
//		assertEquals(placeholder, "None selected", "Placeholder should be 'None selected'");
//		LoggerUtil.info("Verified placeholder text: " + placeholder);
//	}
//
//	@Test(priority = 43, groups = "group4")
//	public void verifyDataAutoFillandAllocationsForProcessAfterClickingTheEditButton() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("Navigated to Master Data");
//
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("Opened Supplier Master");
//
//		supplier.clickEditButtonForProcessAllocation();
//		LoggerUtil.info("Clicked Edit on first row");
//
//		// 🔹 Supplier Code
//		String expectedCode = "007";
//		String actualCode = supplier.getSupplierCode();
//		Assert.assertEquals(actualCode, expectedCode, "Supplier Code mismatch");
//		LoggerUtil.info("✅ Supplier Code matched. Expected: " + expectedCode + ", Actual: " + actualCode);
//
//		// 🔹 Supplier Name
//		String expectedName = "Testing1";
//		String actualName = supplier.getSupplierName1();
//		Assert.assertEquals(actualName, expectedName, "Supplier Name mismatch");
//		LoggerUtil.info("✅ Supplier Name matched. Expected: " + expectedName + ", Actual: " + actualName);
//
//		// 🔹 Supplier Location
//		String expectedLocation = "Mohali";
//		String actualLocation = supplier.getSupplierLocation1();
//		Assert.assertEquals(actualLocation, expectedLocation, "Supplier Location mismatch");
//		LoggerUtil.info("✅ Supplier Location matched. Expected: " + expectedLocation + ", Actual: " + actualLocation);
//
//	}
//
//
//	@Test(priority = 44, groups = "group4")
//	public void verifyDataAutoFillandAllocationsForRMTabAfterClickingTheEditButton() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("Navigated to Master Data");
//
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("Opened Supplier Master");
//		supplier.clickEditButtonForProcessAllocation();
//		LoggerUtil.info("Clicked Edit on first row");
//		String expectedCode = "007";
//		String actualCode = supplier.getSupplierCode1();
//		Assert.assertEquals(actualCode, expectedCode, "Supplier Code mismatch");
//		LoggerUtil.info("✅ Supplier Code matched. Expected: " + expectedCode + ", Actual: " + actualCode);
//
//		// 🔹 Supplier Name
//		String expectedName = "Testing1";
//		String actualName = supplier.getSupplierName11();
//		Assert.assertEquals(actualName, expectedName, "Supplier Name mismatch");
//		LoggerUtil.info("✅ Supplier Name matched. Expected: " + expectedName + ", Actual: " + actualName);
//
//		// 🔹 Supplier Location
//		String expectedLocation = "Mohali";
//		String actualLocation = supplier.getSupplierLocation11();
//		Assert.assertEquals(actualLocation, expectedLocation, "Supplier Location mismatch");
//		LoggerUtil.info("✅ Supplier Location matched. Expected: " + expectedLocation + ", Actual: " + actualLocation);
//
//		// 🔹 Process Checkbox
//		Assert.assertTrue(supplier.isProcessCheckboxSelected1(), "Process checkbox is not selected");
//		LoggerUtil.info("✅ rm checkbox is selected");
//
//	}
//	@Test(priority=45,groups="group4")
//	public void VerifyingUserCAnReadOnlyFromUserAuthorizationinSupplierMaster() throws InterruptedException{
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("✅ Navigated to 'Master Data'");
//		LoggerUtil.info("Verify User Click The ControlMaster Button");
//		LoggerUtil.info("Verify User Click UserControl ");
//		LoggerUtil.info("Verify User AuthorisationTab");
//		LoggerUtil.info("Verify User Click The edit button ");
//		LoggerUtil.info("User Click The Unselect The Read&Write Authority To user");
//		LoggerUtil.info("Go Back TO The SupplierMaster Tab And Check The Save Button Are Availble Or Not");
//		LoggerUtil.info("The Save Button Should not Be There");
//		LoggerUtil.info("Sucessfully The Save Button Is Invisible In Supplierer MasterPage");
//		dashboard.clickOnControlMaster();
//		supplier.clickUserButtonTocheckUserAuthorization();
//	}
//	@Test(priority=46,groups="group4")
//	public void VerifyingUserCanReadWriteAuthorizationinSupplierMaster() throws InterruptedException{
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnControlMaster();
//		Thread.sleep(4000);
//		supplier.clickusercontrolbtntocheckusercanreadandwriteornot();
//		Thread.sleep(9000);
//		LoggerUtil.info("✅ Navigated to 'Master Data'");
//		LoggerUtil.info("Verify User Click The ControlMaster Button");
//		LoggerUtil.info("Verify User Click UserControl ");
//		LoggerUtil.info("Verify User AuthorisationTab");
//		LoggerUtil.info("Verify User Click The edit button ");
//		LoggerUtil.info("User Click The Unselect The Read Authority To user");
//		LoggerUtil.info("Go Back TO The SupplierMaster Tab And Check The Save Button Are Availble Or Not");
//		LoggerUtil.info("The Save Button Should Be There");
//		LoggerUtil.info("Sucessfully The Save Button Is Invisible In Supplierer MasterPage");
//		dashboard.clickOnsuppliermaster();
//		Thread.sleep(6000);
//		supplier.enterdatainsuppliermaster("005","raj","mohali");
//	}
//	
//	@Test(priority=47,groups="group4")
//	public void verifyingduplicateEntryDoesNotSaveInSupllierPage() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The Master Page");
//		LoggerUtil.info("User Enter The Supplier Page");
//		LoggerUtil.info("Verify User Click The Edit Button ");
//		LoggerUtil.info("After Clciking The Edit Button All Data Automatically filled the his column");
//		LoggerUtil.info("User Click The Save Button");
//		LoggerUtil.info("User Expected = Supplier profiles already exist");
//
//		supplier.verifyduplicateentry("Supplier Profiles already exist");
//
//	}
//	@Test(priority=48,groups="group4")
//	public void verifyCheckUpdatePrompt() throws InterruptedException {
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The Master Page");
//		LoggerUtil.info("User Enter The Supplier Page");
//		LoggerUtil.info("Verify User Click The Edit Button ");
//		LoggerUtil.info("After Clciking The Edit Button All Data Automatically filled the his column");
//		LoggerUtil.info("After Clicking Edit Button User Remove The Privious Code ");
//		LoggerUtil.info("User Enter The  New Supplier Code = 007");
//		LoggerUtil.info("User Click The Update Button");
//		LoggerUtil.info("User Should Get Pop Supplier Profiles updated sucessfully");
//		supplier.verifyupdatebtnisworkingwell("007","Supplier Profiles Updated successfully.");
//
//
//	}
//
//
//	@Test(priority=49,groups="group4")
//	public void verifySaveAsNewPrompt() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The Master Page");
//		LoggerUtil.info("User Enter The Supplier Page");
//		LoggerUtil.info("Verify User Click The Edit Button ");
//		LoggerUtil.info("After Clciking The Edit Button All Data Automatically filled the his column");
//		LoggerUtil.info("After Clicking Edit Button User Remove The Privious Code ");
//		LoggerUtil.info("User Enter The New Supplier Code");
//		LoggerUtil.info("User Click The Save AS New Button And User Getting = supplier profiles already exist");
//		supplier.clickbtnsaveasnew("hariyom","Supplier Profiles already exist");
//
//
//
//	}
//
//	@Test(priority=50,groups="group4")
//	public void checksavepromtinSupplierPage() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The Master Page");
//		LoggerUtil.info("User Enter The Supplier Page");
//		LoggerUtil.info("User Enter The Suppleir code = 00");
//		LoggerUtil.info("User Enter The Supplier Name = "+ randomName);
//		LoggerUtil.info("User Enter The Supplier Location");
//		LoggerUtil.info("User Select The Business Domain = rishi");
//		LoggerUtil.info("User Select The Business Segment = sachindra");
//		LoggerUtil.info("User Click The Save Button");
//		LoggerUtil.info("User Should Get The Sucessfully saved !");
//		supplier.ckicksavebtn("00",randomName,"mohali");
//
//
//
//
//	}
//
//
//
//	@Test(priority=51,groups="group4")
//	public void verifyDuplicatedataFromExcelShouldNotImpoort() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The Export And Import Button ");
//		LoggerUtil.info("User Import The exisisting Data Which Is Already exsisting in excel sheet");
//		LoggerUtil.info("User Click The Import Button ");
//		LoggerUtil.info("User Should get popup supplier already exist");
//		supplier.importduplicatedata("Supplier Already Exist");
//
//
//
//	}
	@Test(priority=52,groups="group4")
	public void VerifyPopupDescriptionShouldBeThereWhenUserClickTheDeleteButton() throws InterruptedException {


		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(6000);
		dashboard.VerifyClickingMasterOptions("Supplier");
		
		supplier.deletecostingdatainsupplierpage(" Data Already Being Used in Costing");


	}
//
//	@Test(priority=53,groups="group4")
//	public void verifyClickingonEditShouldEnableDataModificationTheRequiredButtonsShouldAppearForFurtherActions() throws InterruptedException{
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The master data");
//		LoggerUtil.info("User Click The Supplier Master  ");
//		LoggerUtil.info("User Try To Check After Clicking Edit Button All Buttons Are Working Well");
//		LoggerUtil.info("Sucessfully All Buttons Are Working Well");
//		supplier.clickeditbtnandcheckotherbtnareworkingsimilarly();
//
//
//
//
//	}
//
//	@Test(priority=54,groups="group4")
//	public void deltedeltavalueinprocessmaster() throws InterruptedException {
//
//		dashboard.selectMenuFormDashBoard("Master Data");
//		Thread.sleep(6000);
//		//dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("User Click The master data");
//		LoggerUtil.info("User Click The Process Master  ");
//		LoggerUtil.info("User Click The View Button ");
//		LoggerUtil.info("User Click The Search Box And Search Value = Text-778-2-Text-979 ");
//		LoggerUtil.info("User click Edit Button ");
//		LoggerUtil.info("User Remove The Delta Process In Process Master Page");
//		LoggerUtil.info("User Click The Update Button");
//		LoggerUtil.info("User Go Back To The Supplier master");
//		LoggerUtil.info("User Search The Suppleir name in Supplier Page = Text-778-2-Text-979 ");
//		LoggerUtil.info("User is Not Getting Supplier name In The Supplier Master");
//		supplier.updatedeltavalueinprocessmaster("Text-778-2-Text-979");
//
//	}
//
//
//  
//	@Test(priority = 55, groups = "group4")
//	public void verifyDefaultDropdownPlaceholderInSupplierMaster() throws InterruptedException {
//
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    LoggerUtil.info("User clicked on 'Master Data' from the dashboard");
//
//	    dashboard.clickOnsuppliermaster();  // Assuming this navigates to Supplier Master
//	    LoggerUtil.info("User clicked on 'Supplier Master'");
//
//	   
//	    LoggerUtil.info("User clicked on the 'Business Domain/Segments' tab");
//
//	    // Fetch the default value of the dropdown
//	    String defaultValue = supplier.getCategoryDropdownDefaultValue();
//
//	    LoggerUtil.info("User checked the default value of Category Type dropdown = " + defaultValue);
//
//	    if (defaultValue.equalsIgnoreCase("Select")) {
//	        LoggerUtil.info("✅ PASS: Default value is 'Select'");
//	    } else {
//	        LoggerUtil.error("❌ FAIL: Expected 'Select', but found: " + defaultValue);
//	        Assert.fail("Default dropdown value mismatch: Expected 'Select', Found: " + defaultValue);
//	    }
//
//	    Thread.sleep(2000);  // Optional delay if needed
//	}
//	@Test(priority = 52, groups = "group4")
//	public void verifyCategoryNamePlaceholderInSupplierMaster() throws InterruptedException {
//
//	    dashboard.selectMenuFormDashBoard("Master Data");
//	    LoggerUtil.info("User clicked on 'Master Data' from the dashboard");
//
//	    dashboard.clickOnsuppliermaster();
//	    LoggerUtil.info("User clicked on 'Supplier Master'");
//
//	  
//	    LoggerUtil.info("User clicked on the 'Business Domain/Segments' tab");
//
//	    String placeholder = supplier.getCategoryNamePlaceholder();
//	    LoggerUtil.info("User fetched the placeholder for Category Name field = " + placeholder);
//
//	    if (placeholder.equalsIgnoreCase("Enter")) {
//	        LoggerUtil.info("✅ PASS: Placeholder is 'Enter'");
//	    } else {
//	        LoggerUtil.error("❌ FAIL: Expected placeholder 'Enter', but found: " + placeholder);
//	        Assert.fail("Incorrect placeholder in Category Name field");
//	    }
//
//	    Thread.sleep(2000);
//	}
//
//	
//	
//	@Test(priority=53,groups="group4")
//	public void verifySpecialCharacterInSupplierMasterBusinessDomainAndSegTabInCategoryName() throws InterruptedException {
//
//		LoggerUtil.info("Logged in with user&passwork " + prop.getProperty("username") +prop.getProperty("password"));
//		dashboard.selectMenuFormDashBoard("Master Data");
//		LoggerUtil.info("Open CostMasterDashBoard And Click Master");
//		LoggerUtil.info("user Click On MasterData");
//		dashboard.clickOnsuppliermaster();
//		LoggerUtil.info("verified Supplier Master Is Clickable ");
//		LoggerUtil.info("verified User Clicked On SupplierMaster");
//		LoggerUtil.info("User Click Business Segment DomainPage");
//		supplier.clickbusinessseganddomainpage();
//		Thread.sleep(9000);
//		LoggerUtil.info("User Select Business Domain From Dropdown ");
//		LoggerUtil.info("user Enter With This Category Name: " + randomName);
//		LoggerUtil.info("User Is Getting PopUP While Saving The Value");
//		supplier.businessDomainSelectDropdownByValue();
//		supplier.savedatawithbusinessdomain("@","Special characters are not allowed except '/' and '-'.");
//
//
//	}

}
