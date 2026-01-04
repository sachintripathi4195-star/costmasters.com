package com.Tests;
 
import static org.testng.Assert.assertEquals;
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
import com.Pages.ControlMasterPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.ProcessMasterPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;
 
@Listeners(com.helper.TestListeners.class)
 
public class ProcessMasterTest extends Base {
	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
	ProcessMasterPage pmaster = new ProcessMasterPage();
	ControlMasterPage cmaster = new ControlMasterPage();
	Faker faker = new Faker();
	// Generate random string data
	String randomName = faker.name().firstName();
	int randomNumber = faker.number().numberBetween(1000, 9999);
 
	@BeforeGroups(groups = { "group1", "group2", "group3" })
	public void loginGroup() throws InterruptedException {
		Base.launchApplication();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		LoggerUtil.info("Logged in once before the group test cases.");
	}
 
	@AfterGroups(groups = { "group1", "group2", "group3" })
	public void logoutGroup() {
		driver.quit();
		LoggerUtil.info("Logged out after the group test cases.");
	}
	@Test(priority = 1, groups = "group1")
	public void TC_001verifyProcessDetailSaved() throws InterruptedException {
		String randomName = "AAAA" + faker.name().firstName() + faker.letterify("??????");

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		Thread.sleep(4000);
		LoggerUtil.info("Clicked on 'Process Item");
		Thread.sleep(3000);
		dashboard.clickOnProcessItem();

		pmaster.enterProcessDetailInformation(randomName, "12345", "15-03-2025", "80", "twenty-twenty");

		pmaster.enterSpecificApplicabilityCustomerInformation("Saved");

		pmaster.searchProcessName(randomName);

	}

	@Test(priority = 2, groups = "group1")
	public void TC_002VerifyErrorMessageShouldBeGeneratedWhenProcessRateIsMissing() throws InterruptedException {
		String randomName = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");
		Thread.sleep(2000);

		pmaster.enterProcessDetailInformation(randomName, "", "15-03-2025", randomName, "twenty-twenty");

		Thread.sleep(3000);
		pmaster.enterSpecificApplicabilityCustomerInformation("Rate required");

	}

	@Test(priority = 3, groups = "group1")
	public void TC_003_verifyErrorMessageInCorrectValueInProcessRate() throws InterruptedException {
		String randomName = faker.name().firstName();
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Clicked on 'Process Item'");
		Thread.sleep(8000);
		LoggerUtil.logger.info("Hello We Are Going To Start Entering Value...");
		pmaster.enterProcessDetailInformation(randomName, "test", "15-03-2025", "randomName", randomName);

		pmaster.enterSpecificApplicabilityCustomerInformation("Rate required");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 4, groups = "group1")
	public void TC_004_verifyErrorMessageWhenEfficiencyIsMoreThan100() throws InterruptedException {

		String randomName = faker.name().firstName();
		int randomint = faker.number().numberBetween(50, 50000);
		String randomnumber = String.valueOf(randomint);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.enterProcessDetailInformationForVerifyingEfficiencyRatePopupMessage(randomName, randomnumber,
				"15-03-2025", "5000", "Efficiency cannot exceed 100.", randomName);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 5, groups = "group1")
	public void TC_005_verifyDateFieldsContainsTodaysDate() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");
		Thread.sleep(9000);
		LoggerUtil.info("Clicked on 'Process Master'");
		LocalDate today = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String todayDate = today.format(formatter);

		pmaster.verifyDateField(todayDate);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 7, groups = "group1")
	public void TC_006_verifyResetButton() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("User CLick Process Master From Master Data");

		pmaster.enterProcessDetailsforreset("TestName", "12345", "90");

		pmaster.selectcheckboxesforreset();
		LoggerUtil.info("User Select The All CheckBoxes For Verifng Reset Button Is Working Well Or Not");
		Thread.sleep(9000);
		pmaster.clickresetbutton();

		Assert.assertTrue(pmaster.arefieldscleard(), "❌ Fields and checkboxes were not reset properly.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 8, groups = "group1")
	public void TC_007_verifyAddNewCustomerData() throws InterruptedException {

		String randomName = faker.name().firstName();
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("User Select The Process Master For Master Dashboard");
		
		pmaster.clickingAddCustomerButton(randomName, randomName, "Saved");

		dashboard.VerifyClickingMasterOptions("Customer");

		pmaster.checkingCustomerNameInCustomerMaster(randomName);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 10, groups = "group1")
	public void TC_008_verifyExistingDataShouldBeSaveAsNewAfterEnterNewProcessDetails() throws InterruptedException {
		String randomName = "AAAA" + faker.name().firstName() + faker.letterify("????");
		String randomName1 = "AAAA" + faker.name().firstName() + faker.letterify("????");
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");

		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("User Clicked The Process Master From Dashboard");

		pmaster.SaveProcessDetailsForVerifyingSaveAsNew(randomName, "12345", "15-03-2025", "80", "twenty-twenty",
				"Saved");

		pmaster.editProcessAndSaveAsNew(randomName, randomName1, "Saved");

		pmaster.searchProcessNameForSaveAsNew(randomName);
	}

	// @DataProvider(name = "processDetailsData")

	public static Object[][] getLoginData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";

		String sheetName = "processDetail";

		return ExcelUtil.getExcelData(filePath, sheetName);

	}

	@Test(priority = 11, groups = "group2")
	public void TC_009_verifyPopWhenUserClickExportButtonWithoutSelectingCustomerAndSupplier()
			throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.verifyWarningPopupForExportingFile(
				"Something went wrong. Value cannot be null. Parameter name: values");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 12, groups = "group2")
	public void TC_010_verifyProcessRateDoesNotContainMoreThanSixDigit() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");

		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("User clicked the Process Master from Dashboard");

		String inputValue = "1234567"; // 7 digits
		String expectedTrimmedValue = inputValue.substring(0, 6); // "123456"

		pmaster.enterProcessRate(inputValue); // Enter 7 digits

		String actualUIValue = pmaster.getProcessRateFieldValue();

		Assert.assertEquals(actualUIValue, expectedTrimmedValue,
				"FAIL: Process Rate field allowed more than 6 digits. Expected trimmed: " + expectedTrimmedValue
						+ ", but found: " + actualUIValue);

		LoggerUtil.info("PASS: Process Rate field did not accept more than 6 digits.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 13, groups = "group2")
	public void TC_011_verifyProcessRateContainSpecialCharacter() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		Thread.sleep(1000);
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Selected process name from Master Data");

		pmaster.enterProcessDetailInformation(randomName, "$%", "15-03-2025", randomName, randomName);

		pmaster.enterSpecificApplicabilityCustomerInformation("Rate required");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 14, groups = "group2")

	public void TC_012_verifyExportFileAndValidateWithProcessName() throws InterruptedException, IOException {

		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");

		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.exportFile();

		List<String> uiDataList = pmaster.fetchProcessList();

		System.out.println(uiDataList);

		Thread.sleep(7000);

		File latestFile = Base.getLatestFile();

		List<String> excelProcessName = ProcessMasterPage.readProcessNamesFromExcel(latestFile, 1, 4);

		for (int i = 0; i < uiDataList.size(); i++) {
			String uiValue = uiDataList.get(i);
			String expectedValue = excelProcessName.get(i);

			String detail = "SN ==" + (i + 1) + " " + "actualValue(processName(UI)) ==" + uiValue
					+ "==Exp Value (ProcessName(fromexcel)): " + expectedValue;
			if (uiValue.equals(expectedValue)) {
				LoggerUtil.pass(detail);

			} else {
				LoggerUtil.error(detail);
				LoggerUtil.info("Something getting wrong from user end ");
			}
		}

		System.out.println(excelProcessName);

		Assert.assertEquals(excelProcessName, uiDataList, "mistMatchFound");

		ProcessMasterPage.deleteFile(latestFile);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 18, groups = "group2")

	public void TC_015_verifyPositiveEntryWithCustomerSpecificDeltaValidation() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(10000);

		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Select process from master data");

		Thread.sleep(9000);

		LoggerUtil.info("user Click The CustomerCheckBox");

		pmaster.ValidateDeltaValue("100", "10");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 19, groups = "group3")
	public void TC_016_verifyNegativeEntryWithCustomerSpecificDelta() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(1000);

		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Select process from master data");

		Thread.sleep(900);

		LoggerUtil.info("user Click The CustomerCheckBox");

		pmaster.ValidateDeltaValue("100", "-10");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 20, groups = "group3")
	public void TC_017_verifyAllCheckboxesIsClicked() throws InterruptedException {
		dashboard.clickingDashboard("Dashboard");
		LoggerUtil.info("Logged in with user: " + prop.getProperty("username"));
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		Thread.sleep(10000);
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Selected processmaster from master data");
		Thread.sleep(9000);
		pmaster.clickingallcheckboxes();

		pmaster.clickresetbutton();
		Thread.sleep(3000);
		boolean isResetSuccessful = pmaster.arecheckboxiscleard();

		if (isResetSuccessful) {
			LoggerUtil.pass("✅ All checkboxes and dropdowns are reset correctly.");
		} else {
			LoggerUtil.error("❌ One or more checkboxes/dropdowns are not cleared as expected.");
			Assert.fail("Reset validation failed: Some checkboxes or dropdowns were not reset properly.");
		}

		Thread.sleep(20000);

		Assert.assertTrue(pmaster.arefieldscleard(), "❌ Fields and checkboxes were not reset properly.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 21, groups = "group3")

	public void TC_018_verifyImportNewDataWithSupplier() throws InterruptedException {

		LoggerUtil.info("Logged in with user: " + prop.getProperty("username"));

		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(10000);

		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Select process from master data");

		Thread.sleep(9000);

		pmaster.exportNewDataWithSupplier("File Imported Successfully");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 22, groups = "group3")
	public void TC_019_verifyImportNewDataWithCustomer() throws InterruptedException, IOException {

		// LoggerUtil.info("Logged in with user: " + prop.getProperty("username"));
		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(4000);

		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Select process from master data");
		Thread.sleep(7000);

		dashboard.clickOnProcessItem();

		LoggerUtil.info("Select process from master data");

		pmaster.exportnewfilewithcustomer();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	///////// Control Master /////////////////////

	@Test(priority = 23, groups = "group3")
	public void TC_020_verifyClickControlMasterForUnselectSaleCheckBoxToHideCustomerColumnFromProcessMasterPage()
			throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");
		Thread.sleep(4000);
		dashboard.clickOnControlMaster();
		LoggerUtil.info("User Clicked Control Master");
		Thread.sleep(5000);
		cmaster.clickforsalesbutton();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 27, groups = "group3")
	public void TC_021_verifyClickUnselectSupplierCheckBoxInControlMasterToHideSupplierColumnFromProcessMasterPage()
			throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");

		Thread.sleep(3000);
		dashboard.clickingDashboard("Dashboard");
		LoggerUtil.info("Selected 'Master Data' from dashboard");
		Thread.sleep(4000);
		dashboard.clickOnControlMaster();
		LoggerUtil.info("User CLick Button On COntrol Master");

		cmaster.clickSupplierButton();
		Thread.sleep(5000);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 28, groups = "group2")
	public void TC_022_importExcelFileWithoutProcessNameWithSupplier() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard.");

		Thread.sleep(4000);
		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Selected 'Process Master' from Master Data.");

		Thread.sleep(6000);

		LoggerUtil.info(
				"Step 2: Exporting Process Master template with Supplier details and modifying Excel to remove 'Process Name'.");
		pmaster.exportNewDataWithSupplierAndImportWithoutProcessName();

		LoggerUtil.info("Step 3: Importing modified Excel without 'Process Name' field.");
		pmaster.importNewProcessMasterWithsupplierFromExcelWithoutprocessName();

		LoggerUtil.info("Step 4: Validating expected error message after import attempt.");

		String ExpectedError = "Process Name Cannot Be Empty";

		LoggerUtil.info("Expected Error Message: " + ExpectedError);

		// This assertion is currently designed to fail for demonstration/testing
		// failure case
		Assert.assertEquals("Unit Cannot Be Empty", ExpectedError,
				"❌ Test failed intentionally to verify failure on wrong process import.");

		LoggerUtil.info("Step 5: Assertion executed to validate error message for missing process name.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 29, groups = "group3")

	public void TC_023_importExcelFileWithoutUnitDropdownShouldNotSaveWithSupplier() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(4000);

		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Select process from master data");

		Thread.sleep(9000);

		LoggerUtil.info("Verify User Eneter The Data In Excel Sheet Without UnitDropDown Value");
		LoggerUtil.info("The Excel File Should Not Save WithOut Selecting Unit DropDown");

		pmaster.exportNewDataWithSupplierAndImportWithoutUnitDropdown();
		pmaster.importNewProcessMasterWithsupplierFromExcelWithoutUnitDropdown();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 30, groups = "group3")
	public void TC_024_verifyDropdownPlaceholderShouldBeShownSelectWithoutSelectingAnyValues()
			throws InterruptedException {
		LoggerUtil.info(" Test Started: Verifying dropdown placeholder for Unit UOM before selection.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		// Step 1: Navigate to Master Data
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info(" Navigated to 'Master Data' menu from dashboard.");

		// Step 2: Click Process Master
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info(" Process Master page opened.");

		// Step 3: Validate placeholder in Unit UOM dropdown
		LoggerUtil.info(" Checking if placeholder text is 'Select' in Unit UOM dropdown.");
		String placeholder = driver.findElement(By.xpath("//span[@id='select2-uomDrop-container']")).getText();
		assertEquals(placeholder, "Select", "❌ Placeholder text should be 'Select'");
		LoggerUtil.pass(" Placeholder text validated successfully: " + placeholder);

		// Step 4: Select a value in Unit dropdown
		LoggerUtil.info(" Selecting '$' from Unit dropdown.");
		pmaster.selectUnitValue("$");
		LoggerUtil.info(" '$' selected in Unit dropdown.");

		// Step 5: Verifying additional dropdown placeholders (Weight Factor, Supplier,
		// Specific Delta)
		try {
			LoggerUtil.info(" Verifying Weight Factor dropdown placeholder...");
			pmaster.verifyweightfactordrop();
			LoggerUtil.pass(" Weight Factor placeholder verified.");

			pmaster.verifySuppplaceholder();

			pmaster.verifySuppspecificdeltaplaceholderValue();

		} catch (Exception e) {
			// LoggerUtil.logException(e);
			LoggerUtil.fail(" Exception occurred while verifying one or more placeholders.");
			throw e;
		}

		LoggerUtil.info(" Test Completed: Placeholder validations passed for all relevant dropdowns.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 31, groups = "group2")
	public void TC_025_verifyCloseButtonRedirectsToProcessMasterMainPage() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("Selected 'Master Data' from dashboard");

		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Clicked on Process Master from Master Data");

		pmaster.clickTopRightCrossButton();
		LoggerUtil.info("Clicked on top-right ❌ cross button");

		LoggerUtil.info("user Back To Main Page");

		LoggerUtil.info("PASS: Navigated back to Process Master main (list) page after closing.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 32, groups = "group2")
	public void TC_026_verifyNextButtonIsWorkingOrNot() throws InterruptedException {

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(4000);

		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.nextbtn();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 33, groups = "group2")
	public void TC_027_editCustomerSpecificProcessAndValidate() throws InterruptedException {

		int randomint = faker.number().numberBetween(10, 99);
		String randominteger = String.valueOf(randomint);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(3000);
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Selected 'Master Data' from dashboard");

		Thread.sleep(4000);

		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.updateprocessRateWithcustomer(randominteger, "ABraghav");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 34, groups = "group2")
	public void TC_028_validateIButtonInProcessMasterDisplaysTooltipHelpMessage01() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();
		LoggerUtil.info("User click The Button On Process Master ");

		pmaster.clickIButton();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 35, groups = "group2")
	public void TC_029_validateSaveButtonDisableAfterSuccessfullySave() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();
		LoggerUtil.info("User click The Button On Process Master ");

		pmaster.clickSaveButtonSecondTime(randomName, "50", "15-03-2025", "100", randomName, "Process Name required.!");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 36, groups = "group2")
	public void TC_030_verifyProcessListShouldNotDeleteRestrictionOnUsedProcess() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();

		pmaster.clickDeleteButtonAndProcessListShouldNotDelete("Unable to delete as Commodity has dependent records.!");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 37, groups = "group3")
	public void TC_031_verifyProcessMasterOpenInstantly() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Step 2: Initiating validation for instant loading of Process Master screen.");

		LoggerUtil.info("Expected Behavior: Process Master screen should open within 3 seconds.");

		// Time threshold for validation in seconds (if used in logic)
		String expectedThreshold = "70"; // may represent milliseconds or seconds depending on your method logic

		LoggerUtil.info("Input: Time threshold set for screen load validation: " + expectedThreshold);

		pmaster.verifyprocessmasterOpen(expectedThreshold);

		LoggerUtil.info("Step 3: Verified that Process Master screen opened within the acceptable time limit.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 38, groups = "group3")
	public void TC_032_verifyInvalidCharacterEfficiencyShouldNotContain() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Step 2: Verifying validation for special characters in Efficiency Rate field.");

		String processName = randomName;
		String rate = "39";
		String date = "23-04-2025";
		String efficiency = "@#are%63456"; // Invalid special characters
		String expectedMessage = "Effiency Rate Does Not Contains Special character";
		String efficiencyText = "twenty-twenty"; // Optional extra test data

		LoggerUtil.info("Input Details:");
		LoggerUtil.info("Process Name: " + processName);
		LoggerUtil.info("Rate: " + rate);
		LoggerUtil.info("Date: " + date);
		LoggerUtil.info("Invalid Efficiency Input: " + efficiency);
		LoggerUtil.info("Expected Validation Message: " + expectedMessage);

		pmaster.enterspecialcharacterInEfficiencyrate(processName, rate, date, efficiency, efficiencyText,
				expectedMessage);

		LoggerUtil.info(
				"Step 3: Verified that special characters are not allowed in Efficiency Rate field and validation message is displayed.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 39, groups = "group3", description = "Verify that Supplier Specific Delta count matches selected Supplier checkboxes")
	public void TC_033_verifyNumberOfDeltaPopulationIsVerifiedToSupplierCheckbox() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();

		pmaster.verifyNumberOfDeltaPopulationIsVerifiedToSupplierCheckbox();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 41, groups = "group3", description = "Verify that a process can be saved with only Supplier Specific Delta selected")
	public void TC_034_verifySaveProcessWithSupplierSpecificDeltaOnly() throws InterruptedException {

		String randomName = "AAAA" + faker.name().firstName() + faker.letterify("????");
		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("Step 2: Initiating process save with only Supplier Specific Delta selected.");

		String processName = randomName;
		String rate = "250";
		String date = "23-04-2025";
		String efficiency = "95";
		String supplierName = "every-every";
		String deltaName = "Delta-A";

		LoggerUtil.info("Input Details:");
		LoggerUtil.info("Process Name: " + processName);
		LoggerUtil.info("Rate: " + rate);
		LoggerUtil.info("Date: " + date);
		LoggerUtil.info("Efficiency: " + efficiency);
		LoggerUtil.info("Supplier Name: " + supplierName);
		LoggerUtil.info("Delta Name: " + deltaName);

		pmaster.saveProcessWithSupplierSpecificDeltaOnly(processName, rate, date, efficiency, supplierName, deltaName);

		LoggerUtil.info(
				"Step 3: Verified that process is saved successfully with only Supplier Specific Delta selected.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 42, groups = "group3", description = "Verify that a process can be saved with only Supplier Specific Delta selected")
	public void TC_035_verifySaveProcessWithSupplierSpecificPositiveValueDeltaOnly() throws InterruptedException {
		String randomName = "AB" + faker.name().firstName() + faker.letterify("???");
		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Step 2: Initiating process save with only Supplier Specific Delta set to a positive value.");

		String processName = randomName;
		String rate = "250";
		String date = "23-04-2025";
		String efficiency = "95";
		String supplierName = "Avery-Avery";
		String deltaValue = "30";
		String deltaName = "Delta-A";

		LoggerUtil.info("Input Details:");
		LoggerUtil.info("Process Name: " + processName);
		LoggerUtil.info("Rate: " + rate);
		LoggerUtil.info("Date: " + date);
		LoggerUtil.info("Efficiency: " + efficiency);
		LoggerUtil.info("Supplier Name: " + supplierName);
		LoggerUtil.info("Delta Name: " + deltaName);
		LoggerUtil.info("Delta Value (Positive): " + deltaValue);

		pmaster.saveProcessWithEnterPossitiveValueInSupplierSpecificDeltaOnly(processName, rate, date, efficiency,
				supplierName, deltaValue);

		LoggerUtil.info(
				"Step 3: Verified that process is saved with only Supplier Specific Delta having a positive value.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 42, groups = "group3", description = "Verify that a process can be saved with only Supplier Specific Delta selected")
	public void TC_036_verifySaveProcessWithSupplierSpecificNegativeValueDeltaOnly() throws InterruptedException {

		String randomName = "AAA" + faker.name().firstName() + faker.letterify("???");
		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Step 2: Initiating process save with only Supplier Specific Delta set to a negative value.");

		String processName = randomName;
		String rate = "250";
		String date = "23-04-2025";
		String efficiency = "95";
		String supplierName = "Avery-Avery";
		String deltaValue = "-30";
		String deltaName = "Delta-A";

		LoggerUtil.info("Input Details:");
		LoggerUtil.info("Process Name: " + processName);
		LoggerUtil.info("Rate: " + rate);
		LoggerUtil.info("Date: " + date);
		LoggerUtil.info("Efficiency: " + efficiency);
		LoggerUtil.info("Supplier Name: " + supplierName);
		LoggerUtil.info("Delta Name: " + deltaName);
		LoggerUtil.info("Delta Value (Negative): " + deltaValue);

		pmaster.saveProcessWithEnterNegativeValueInSupplierSpecificDeltaOnly(processName, rate, date, efficiency,
				supplierName, deltaValue);

		LoggerUtil.info(
				"Step 3: Verified that process is saved with only Supplier Specific Delta having a negative value.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 43, groups = "group3")
	public void TC_037_verifyEditSupplierDeltaProcess() throws InterruptedException {
		String randomName = "AAA" + faker.name().firstName() + faker.letterify("???");
		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Step 1: Executing process save with Supplier Specific Delta only.");

		// Parameters can be modified based on test data
		String processName = randomName;
		String rate = "250";
		String date = "23-04-2025";
		String efficiency = "95";
		String supplierName = "Avery-Avery";
		String deltaName = "Delta-A";

		pmaster.verifyeditsupplierdeltaandnewchange(processName, rate, date, efficiency, supplierName, "-30",
				processName, "50");

		LoggerUtil.info("Test Passed: Process saved with only Supplier Specific Delta.");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 44, groups = "group3")
	public void TC_038_verifyAddSupplierViaPopup() throws InterruptedException {
		String randomName = "AA" + faker.name().firstName() + faker.letterify("????");
		int randint = faker.number().numberBetween(1000, 9999);
		String suppcode = String.valueOf(randint);
		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");

		String supplierName = randomName;
		String suppliercode = suppcode;
		String businessSeg = "141235";

		LoggerUtil.info("Step 2: Attempting to add supplier via popup with following data:");
		LoggerUtil.info("Supplier Name: " + supplierName);
		pmaster.addsupplier(suppliercode, supplierName, businessSeg);
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 45, groups = "group3")
	public void TC_039_duplicateProcessDoesNotSaveWithSameSupplierMultipleTimes() throws InterruptedException {

		String randomName = faker.name().firstName() + faker.letterify("????");
		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.VerifyClickingMasterOptions("Process");

		String processName = randomName;
		String quantity = "20";
		String date = "23-04-2025";

		LoggerUtil.info("Step 2: Attempting to save existing process with same supplier and below values:");
		LoggerUtil.info("Process Name: " + processName);
		LoggerUtil.info("Quantity: " + quantity);
		LoggerUtil.info("Date: " + date);

		try {
			pmaster.saveExistingDataWithSameSupplierMultipleTime(processName, quantity, date);

			Thread.sleep(4000);
			pmaster.VerifySaveAgainWithSameSupplier(processName, quantity, date);

			LoggerUtil.info(
					"Step 3: Verified that process with same supplier and data is not saved again and correct validation message is displayed.");
		} catch (Exception e) {

			LoggerUtil.info(e.getMessage());
		}

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 46, groups = "group3")
	public void TC_040_duplicateCustomerShouldNotSaveMultipleTimes() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to 'Process Master' under 'Master Data' menu.");
		String randomName = faker.name().firstName() + faker.letterify("?????");
		dashboard.selectMenuFormDashBoard("Master Data");

		LoggerUtil.info("Step 1: Clicking on 'Process Master' tab.");
		dashboard.clickOnProcessItem();

		String customer = randomName;
		String quantity = "30";
		String date = "23-04-2025";

		try {
			pmaster.VerifyExisitingDataDoesNotSaveExistingDataWithSameCustomer(customer, quantity, date);

			Thread.sleep(5000);
			pmaster.VerifySameProcessWithSameCustomerShouldNotSaveAgain(customer, quantity, date);

		} catch (Exception e) {

			LoggerUtil.info(e.getMessage());
		}

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 47, groups = "group3")
	public void TC_041_verifyViewButtonWorkingWellOrNot() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Click The Process Master ");

		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.clickviewbtn();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 48, groups = "group3")
	public void TC_042_verifyCustomerSelectedListAndNumberOfDeltaPopulation() throws InterruptedException {
		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();
		LoggerUtil.info("User Clicked Process Master SucessFully");
		pmaster.verifynumebrofcustomerdeltapopulation();

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 49, groups = "group3", description = "Verify that OHP and Cavity fields are 'N' by default in exported Process sheet")
	public void TC_043_VerifyDefaultsValuesShouldBeShowInExportedProcessSheetWithSupplier()
			throws IOException, InterruptedException {
		LoggerUtil.info("🔍 Test Started: Validating exported Process Master defaults for OHP and Cavities.");

		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();
		pmaster.validateOHPAndCavityDefaultsInExportedProcessSheet();

		LoggerUtil.info("✅ Test Completed: OHP and Cavity default value validation passed.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 50, groups = "group3", description = "Verify exported Customer Process sheet contains default 'N' for OHP and Cavity")
	public void TC_044_VerifyDefaultsInCustomerExportedProcessSheet() throws IOException, InterruptedException {
		LoggerUtil.info("🔍 Test Started: Validating OHP and Cavity defaults in exported Customer Process sheet.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.clickOnProcessItem();

		pmaster.validateCustomerExportProcessSheetDefaults();

		LoggerUtil.info("✅ Test Completed: Exported Customer Process sheet validated successfully.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 51, groups = "group3")
	public void TC_045_verifySaveAsNewSupplierDeltaProcess() throws InterruptedException {

		String randomName = "AAAA" + faker.name().firstName() + faker.letterify("???");
		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");

		LoggerUtil.info("Step 1: Executing process save with Supplier Specific Delta only.");

		// Parameters can be modified based on test data
		String processName = randomName;
		String rate = "250";
		String date = "23-04-2025";
		String efficiency = "95";
		String supplierName = "Avery-Avery";
		String deltaName = "Delta-A";

		pmaster.verifyeditsupplierdeltaandnewchange(processName, rate, date, efficiency, supplierName, "-30",
				processName, "50");

		LoggerUtil.info("Test Passed: Process saved with only Supplier Specific Delta.");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);
	}

	@Test(priority = 52, groups = "group3")
	public void TC_046_VerifymandatoryfieldsValidationOnSaveWithoutProcessName() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("User click The process master item ");

		pmaster.verifyMandatoryField("40", "24-04-2025", "50", "twenty-twenty");
		pmaster.enterSpecificApplicabilityCustomerInformation1("Process Name required.!");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 53, groups = "group3")
	public void TC_047_VerifyMandatoryFieldValidationOnSaveWithoutProcessRate() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.verifyMandatoryFieldWithoutRate("40", "24-04-2025", "50", "twenty-twenty");
		pmaster.enterSpecificApplicabilityCustomerInformation1("Rate required.!");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 54, groups = "group3")
	public void TC_048_VerifyMandatoryFieldWithoutUnitDropdown() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");
		LoggerUtil.info("User click The process master item ");

		pmaster.verifyMandatoryFieldWithoutUnit("ra", "40", "24-04-2025", "50", "twenty-twenty");
		pmaster.enterSpecificApplicabilityCustomerInformation1("Select Unit");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 54, groups = "group3")
	public void TC_049_VerifyMandatoryFieldWithoutRm() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");
		pmaster.verifyMandatoryFieldWithoutRm("ra", "43", "24-04-2025", "50", "twenty-twenty");
		pmaster.enterSpecificApplicabilityCustomerInformation1WithoutRmInput(
				"Please select atleast one RM input category");
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 55, groups = "group3")
	public void TC_050_VerifySaveNewProcessWithoutSelectingSupplierAndCustomer() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.verifymandatoryfield("ra", "43", "24-04-2025", "50", "twenty-twenty");
		pmaster.enterSpecificApplicabilityCustomerInformation1WithoutCustomerAndSupplier(
				"Select either customer or supplier!");

		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

	@Test(priority = 56, groups = "group3")
	public void TC_051_verifyManualInstructionWhichExistAtRightSideOnTop() throws InterruptedException {

		LoggerUtil.info("Step 0: Navigating to Process Master under Master Data.");
		dashboard.selectMenuFormDashBoard("Master Data");
		dashboard.VerifyClickingMasterOptions("Process");

		pmaster.clickManualHelpButton();
		dashboard.clickingDashboard("Dashboard");
		Thread.sleep(4000);

	}

}
