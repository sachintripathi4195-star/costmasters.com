package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.CurrencyPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.helper.Base;

@Listeners(com.helper.TestListeners.class)
public class CurrencyMasterTest extends Base{

	LoginPage login;
	DashboardPage dashboard;
	CurrencyPage curr;
	@BeforeGroups(groups= {"group1","group2","group3","group4","group5"})
	public void setup() {
		launchApplication();
		login = new LoginPage();
		dashboard = new DashboardPage();
		curr = new CurrencyPage();
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterGroups(groups= {"group1","group2","group3",})
	public void Quit() {
		
		driver.quit();
		
	}
	
	@Test(priority=1,groups="group1")
	public void CUR_001_ValidateSaveWithoutSelectingMandatoryFieldsWithoutConvertToCurrency() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		curr.verifysavedataandfetch("RBI");
		
		
	}
	
	
	
	@Test(priority=1,groups="group1")
	public void CUR_001_ValidateSaveWithoutSelectingMandatoryFields() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.verifysavedataandfetchWithoutDataSource();
		
		
	}
	
	
	@Test(priority=2,groups="group1")
	public void CUR_002AddValidCurrencyMapping() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.savevalidcurrency("Singapore-Dollars");
		
		
	}
	
	
	@Test(priority=3,groups="group1")
	public void CUR_003CheckDuplicateCurrencyMapping() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.verifyduplicatedata("Singapore-Dollars");
		
		
	}
	
	
	@Test(priority=4,groups="group1")
	public void CUR_004ValidateBaseCurrencyIsNonEditable() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
        curr.verifybasecurrencyisreadable();
      		
		
		
		
	}
	
	@Test(priority=5,groups="group1")
	public void CUR_005SearchFunctionalityForCurrencyName() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.searchchfunctionality();

	}
	
	
	@Test(priority=6,groups="group1")
	public void CUR_007PlaceholderForDropDownCell() throws InterruptedException{
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		dashboard.currencydataadditiontab();
		curr.findingplaceholdervalueforfiscalyear();
		
	}
	
	@Test(priority=7,groups="group1")
	public void CUR_008FiscalYearDropdownInput() throws InterruptedException {
	
	dashboard.selectMenuFormDashBoard("Master Data");
	Thread.sleep(100);
	dashboard.clickingcurrencymaster();
	Thread.sleep(2000);
	dashboard.currencydataadditiontab();
	curr.verifyyearareinassendingornot();
	
	}
	
	
	
	@Test(priority = 8, groups = "group1")
	public void CUR_011BaseCurrencyCell() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
        curr.verifyBaseCurrencyCell();
        
		
		
		
	}
	
	@Test(priority = 9, groups = "group1")
	public void CUR_012DataSourceDrop_Down() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
        curr.verifydatasourcelist();
		
		
		
	}
	
	
	@Test(priority = 9, groups = "group1")
	public void CUR_015TableSortingPagination() throws InterruptedException{
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.verifySortingConvertToCurrency();
		
	}
		
	@Test(priority=10,groups="group1")
	public void CUR_015TableSortingPaginationForDataSource() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.verifySortingForBaseSource();
		
	}
	
	
	@Test(priority=11,groups="group1")
	public void CUR_017SearchFunctionality() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.verifysearchfunctionality();
		
		
	}
	
	
	@Test(priority=12,groups="group1")
	public void CUR_021DeleteButton() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(2000);
		curr.deletebtn("Singapore-Dollars");
		
		
	}
	
	@Test(priority=13,groups="group1")
	public void CUR_023MissingFiscalYearPromptCheck() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		curr.missingpromptcheck();
		
		
		
		
	}
	
	@Test(priority=14,groups="group1")
	public void CUR_024LoadTableWithFiscalYearSelected() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();	
		curr.loadingtable();
		
	}
	
	
	@Test(priority=15,groups="group1")
	public void CUR_025AllowOnlyNumericInput() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		curr.verifynumericinputinsecondtabletab();
		
		
	}
	@Test(priority=15,groups="group1")
	public void CUR_025VerifyAlphabeticallyValueSavedOrNot() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		curr.verifyalphabetic();
		
	}
	
	
	@Test(priority=16,groups="group1")
	public void CUR_026RejectNegativeNumbers() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		  curr.verifynegativenumber(); 
		
		
	}
	
	@Test(priority=17,groups="group1")
	public void CUR_027AcceptDecimalUptoThreePoints() throws InterruptedException {
		
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		curr.ThreeDecimalupto();
		
		
		
		
	}
	
	@Test(priority=18,groups="group1")
	public void CUR_029ValidateResetButton() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		curr.verifyResetButtonFunctionality();
		
	}
	
	
	@Test(priority=19,groups="group1")
	public void CUR_036WithoutSelectingYearCheckSaveButton() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();	
		curr.verifySaveButtonIsVisible();
		
		
	}
	
	@Test(priority=20,groups="group1")
	public void CUR_030ExportValidation() throws InterruptedException, IOException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();	
		curr.ExportDataEnterValue();
		curr.verifyuiandexceldata();
		
	}
	
	
	@Test(priority = 21, groups = "group1")
	public void CUR_031ExportValidation() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		dashboard.currencydataadditiontab();
		curr.verifyexportdataandvalidatewithui();

	}
	
	
	
	@Test(priority=22,groups="group1")
	public void CUR_034NewCurrencyAddedDynamicColumnCheck() throws InterruptedException, IOException {
    
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(100);
		dashboard.clickingcurrencymaster();
		Thread.sleep(200);
		curr.verifyDataHasBeenSavedAndVerifyExcelHeader("RBI");
        Thread.sleep(3000);
        dashboard.currencydataadditiontab();
        Thread.sleep(3000);
        curr.verifyexportdataandvalidatewithuiAndCompareColomDataWithHeaderName("RBI");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
