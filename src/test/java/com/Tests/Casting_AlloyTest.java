package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.Casting_AlloyPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.github.javafaker.Faker;
import com.github.javafaker.Number;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class Casting_AlloyTest extends Base {

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
	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
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

	@BeforeMethod
	public void Generatenumber() {
		genraterandomnumber();
	}

	@BeforeGroups(groups = { "group1", "group2", "group3" })
	public void Login() throws InterruptedException {

		launchApplication();
		Thread.sleep(300);
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterGroups(groups = { "group1", "group2", "group3" })
	public void logout() {

		driver.quit();
	}

	@Test(groups = "group1")
	public void TC_CA_001PlaceholderValidations() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(200);
		dashboard.clickoncommodityMaster();
		Thread.sleep(300);
		dashboard.castingalloytab();
		cast.verifyplaceholdervalue();

	}

	@Test(groups = "group1")
	public void TC_CA_002SaveNewCompositionEntry() throws InterruptedException {
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
		// Pass the generated random values as arguments
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
		cast.savenewcompositionentrt(intvaluemax, intvaluemax1, intvaluemax2, intvaluemax3, intvaluemaxover1,
				intmaxover2, intmaxover3, intmaxover4, intmaxover5, intmaxover6, intmaxconsumable1, intmaxcon2,
				intmaxcon3, intmaxcon4, intmaxcon5, intmaxcon6, intmaxcon7);
	}

	@Test(groups = "group1")
	public void TC_CA_003UdateExistingEntry() throws InterruptedException {
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

		// Pass the generated random values as arguments
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
		cast.SaveAndupdatedata(intvaluemax, intvaluemax1, intvaluemax2, intvaluemax3, intvaluemaxover1, intmaxover2,
				intmaxover3, intmaxover4, intmaxover5, intmaxover6, intmaxconsumable1, intmaxcon2, intmaxcon3,
				intmaxcon4, intmaxcon5, intmaxcon6, intmaxcon7);

	}

	@Test(groups = "group1")
	public void TC_CA_005SearchCompositionItem() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.searchcompositionitemverifysearchfilter();

	}

	@Test(groups = "group1")
	public void TC_CA_005SearchCommodityWiseCompositionList() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifysearhfiletr();

	}

	@Test(groups = "group1")
	public void TC_CA_009TotalCountValidationInTable() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.pagecounting("50");

	}

	@Test(groups = "group1")
	public void TC_CA_008PaginationCheckOnViewMode() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifyPaginationStartsFrom26();

	}

	@Test(groups = "group1")
	public void TC_CA_010DeleteCompositionEntryAfterSave() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.deletevalidation("Composition item successfully deleted.");

	}

	@Test(groups = "group1")
	public void TC_CA_011DeleteCompositionEntryAfterSaveAsNew() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.deletesaveasnewentry("Composition item successfully deleted.");

	}

	@Test(groups = "group1")
	public void TC_CA_012DependencyCheckOnDeletion() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.AlloydetailTab();

	}

	@Test(groups = "group1")
	public void TC_CA_013EditLoadAllDataShouldAppearCorrectly() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifyeditbtnIsworkingornot();

	}

	@Test(groups = "group1")
	public void TC_CA_014NumericalAndSymbolValidationInMinMax() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifynumericsymbolandalphabetics("Composition item successfully deleted.");

	}

	@Test(groups = "group1")
	public void TC_CA_015NegativeValuesValidationInMinMax() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifynumericsymbol("Composition item successfully deleted.");

	}

	@Test(groups = "group1")
	public void TC_CA_016MinValueGreaterThanMaxValueValidation() throws InterruptedException {
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifymaximumvaluealwaysgreaterthantomaximumvalue("Max value should be greater than the Min value");

		
	}

	@Test(groups = "group1")
	public void TC_CA_018DuplicateCompositionMappingSave() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifyduplicatepromptarevisiblearenot("Details already added for selected items");

	}

	@Test(groups = "group1")
	public void TC_CA_019SaveNewEntryAndValidateInTable() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifyefficiencyofsavingprocessofdata();

	}

	@Test(groups = "group1")
	public void TC_CA_021PromptAfterSaveSuccess() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifysavepromt("Composition Item successfully Saved");

	}

	@Test(groups = "group1")
	public void TC_CA_024PromptOnSuccessfulDelete() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.deletingDataSucessfully("Composition item successfully deleted.");

	}

	@Test(groups = "group1")
	public void TC_CA_025PromptOnSuccessfulUpdate() throws InterruptedException {

		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.updateprompt("Composition item successfully updated.");

	}
	
	
	@Test(groups="group1")
	public void TC_CA_026PromptOnSaveAsNew() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();
		cast.verifySaveAsnewPrompt("Compostion Item successfully created as a new entry");

	}
	
	
	@Test(groups="group1")
	public void TC_CA_027ResetButtonFunctionality() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();	
		cast.verifyResetButton();

	}
	
	@Test(groups="group1",enabled = false)
	public void TC_CA_020SAASDifferentClientsCompositionSeparation() throws InterruptedException {
		
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();	
		cast.verifysavingdataforclientAandclientB("Automation");
		dashboard.clickOnlogoutbtn();
		LoggerUtil.info("Data Has Been Saved In Cliet A (Rishi Sir I'd)");
		LoggerUtil.info("User Loggedout From Rishi Sir  id... ");
		LoggerUtil.info("User Login From Client B (Munish Sir Id)");
		
		login.loginApplication(prop.getProperty("username2"), prop.getProperty("password2"));   //Munish Sir I'd
		Thread.sleep(2000);
		closeChromeAlertWithRobot();
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		dashboard.castingalloytab();	
		cast.verifyInSecondIdthedatahasbeenSaveOrNot("Automation");
		
		      
		

	} 
	
	
	
	
	
	
	
	
	

}
