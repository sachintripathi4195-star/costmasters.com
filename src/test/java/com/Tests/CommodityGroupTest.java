package com.Tests;

import java.io.File;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.AddcommodityPage;
import com.Pages.CommoditygroupPage;
import com.Pages.ControlMasterPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.ProcessMasterPage;
import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

import quickTestPointMasterPage.QuickMasterPage;

@Listeners(com.helper.TestListeners.class)
public class CommodityGroupTest extends Base {

    LoginPage login;
    DashboardPage dashboard;
    ProcessMasterPage pmaster;
    CommoditygroupPage commodity;
    Faker faker = new Faker();

    String randomName = faker.name().firstName();
    String randomName1 = faker.name().firstName();
    String randomName2 = faker.name().firstName();
    String randomName3 = faker.name().firstName();
    int randomNumber = faker.number().numberBetween(1000, 9999);

    @BeforeGroups(groups = {"group1", "group2", "group3"})
    public void loginGroup() throws InterruptedException {
        Base.launchApplication();
        
        login = new LoginPage();
        dashboard = new DashboardPage();
        pmaster = new ProcessMasterPage();
        commodity = new CommoditygroupPage();

        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(7000);
        LoggerUtil.info("Logged in once before the group test cases.");
    }

    @AfterGroups(groups = {"group1", "group2", "group3"})
    public void logoutGroup() {
        driver.quit();
        LoggerUtil.info("Logged out after the group test cases.");
    }

    @Test(priority = 1, groups = "group1")
    public void TC_COM_001_SaveANewCommodityGroup() throws InterruptedException {
    	
    	String CommdityGroup= faker.name().firstName()+faker.letterify("??????");
    	String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
    	String density = faker.name().firstName()+faker.letterify("????");
        LoggerUtil.info("STEP 1: Click on 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Click on 'Commodity Master' from Master Data menu.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
       
        String expectedToast = "Commodity Group Saved Successfully";
 
        LoggerUtil.info("STEP 3: Start filling new Commodity Group form with:");
        LoggerUtil.info("→ Group Classification: " + groupClassification);
        LoggerUtil.info("→ Specific Grade: " + specificGrade);
        LoggerUtil.info("→ Density: " + density);
        
        AddcommodityPage.SaveNewData(CommdityGroup,CommdityGroup);
 
        Thread.sleep(6000);
        commodity.savenewcommoditygroup(CommdityGroup,groupClassification, specificGrade, density, expectedToast);
    }
 
 
    @Test(priority = 2, groups = "group1")
    public void TC_COM_002_Edit_And_Update_Existing_Commodity_Group() throws InterruptedException {
    	
    	String CommdityGroup= faker.name().firstName()+faker.letterify("??????");
    	String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
    	String density = faker.name().firstName()+faker.letterify("????");
    	String UpdatedClassification = faker.name().firstName()+faker.letterify("????");
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' under Master Data.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Start editing existing Commodity Group entry.");
        LoggerUtil.info("→ New Group Classification: " + groupClassification);
        LoggerUtil.info("→ New Specific Grade: " + specificGrade);
        LoggerUtil.info("→ New Density: " + density);
        LoggerUtil.info("→ Search Existing Entry Using: " + groupClassification);
        LoggerUtil.info("→ Updated Classification: " + UpdatedClassification);
 
        AddcommodityPage.SaveNewData(CommdityGroup,CommdityGroup);
        Thread.sleep(6000);
        
        commodity.editAndUpdateExistingEntry(
        	    CommdityGroup,               // dropdownOption
        	    groupClassification,         // groupClassification
        	    specificGrade,               // specificGrade
        	    density,                     // density
        	    groupClassification,               // ✅ searchValue hona chahiye (ya jo bhi value search karni ho)
        	    UpdatedClassification,       // updatedClassification
        	    "Commodity Group Updated Successfully"
        	);
 
    }
 
    @Test(priority = 3, groups = "group1")
    public void TC_COM_003_Save_As_NewForCommodityGroup() throws InterruptedException {
    	String CommdityGroup= faker.name().firstName()+faker.letterify("??????");
    	String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
    	String density = faker.name().firstName()+faker.letterify("????");
    	String UpdatedClassification = faker.name().firstName()+faker.letterify("????");
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' via dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' section.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        AddcommodityPage.SaveNewData(CommdityGroup,CommdityGroup);
        Thread.sleep(6000);
 
        commodity.EditAndsaveAsnew(CommdityGroup,groupClassification, specificGrade, density, groupClassification, UpdatedClassification, UpdatedClassification);
    }
 
 
    @Test(priority = 4, groups = "group1")
    public void TC_COM_004_DuplicateSpecificGradeAcrossGroupsValidation() throws InterruptedException {
    	
    	String CommdityGroup = faker.name().firstName()+faker.letterify("?????????");
    	String CommdityGroup1 = faker.name().firstName()+faker.letterify("?????????");
       String firstclassification = faker.name().firstName()+faker.letterify("???????");
    	String densityfirst  = faker.number().digits(4);
    	String densitysecond = faker.number().digits(4);
    	String secondclassification = faker.name().firstName()+faker.letterify("?????????");
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' via Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Click on 'Commodity Master'.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        AddcommodityPage.SaveNewData(CommdityGroup,CommdityGroup);
        Thread.sleep(7000);
        AddcommodityPage.SaveNewData(CommdityGroup,CommdityGroup);
        Thread.sleep(7000);
        
       
        commodity.verifysaveduplicatespecificgrade(CommdityGroup,firstclassification, densityfirst,CommdityGroup1 ,secondclassification, densitysecond);
    }
    
    
    
    
    @Test(priority = 6, groups = "group1")
    public void TC_COM_005_FieldEntryValidationForSpecialCharactersAndNumerics1() throws InterruptedException {
        
    	String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
    	String density = faker.name().firstName()+faker.letterify("????");
    	String UpdatedClassification = faker.name().firstName()+faker.letterify("????");
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
      
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' from menu.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Start validation for special characters in 'Group Classification' field.");
        commodity.specialcharacterInGroupclassfication(randomName, randomName1,
            "Group Classification Does Not Allow Special Character");
    }
 
    
    
    @Test(priority = 7, groups = "group1")
    public void TC_COM_006_TableViewSortingFunctionality() throws InterruptedException {
       
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master'.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Start verifying table sorting on different columns.");
        commodity.verifysorting();
    }
 
 
    @Test(priority = 8, groups = "group1")
    public void TC_COM_008_CheckPaginationInViewTable() throws InterruptedException {
    	dashboard.clickingDashboard("");
    	
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' from Master Data.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Start pagination validation on view table.");
        commodity.verifypagination();
    }
 
 
    @Test(priority = 9, groups = "group1")
    public void TC_COM_009_SearchFunctionalityInViewTable() throws InterruptedException {
    	String comgrpvalue = faker.name().firstName()+faker.letterify("???????");
    	String groupclassificationval = faker.name().firstName()+faker.letterify("???????");
    	String specificgrade = faker.name().firstName()+faker.letterify("?????");
    	String densityvalue = faker.number().digits(5);
    	dashboard.clickingDashboard("");
        LoggerUtil.info("STEP 1: Navigate to 'Master Data' via dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' from Master Data.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
      
 
        commodity.VerifysearchFilter(comgrpvalue,groupclassificationval, specificgrade, densityvalue, groupclassificationval);
    }
 
    
    @Test(priority = 10, groups = "group1")
    public void TC_COM_010_BackToTopButtonFunctionality() throws InterruptedException {
      
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' from the Master Data menu.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Validate 'Back To Top' button functionality.");
        commodity.verifybackTotopbtn();
    }
 
    
    
    @Test(priority=11,groups="group1")
    public void TC_COM_011_ValidateSaveWithNumericalAndSymbolDataInCommodityGroupField() throws InterruptedException {
    	
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("Verify User Click The Master Data ");
        LoggerUtil.info("Verify User Click The Commodity Master");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
    	commodity.verifysaveInvalidDataIncommoditgroup("@@@", randomName2, randomName1,"Special Character Are Not Allowed In Group Classification");
    	
    	
    	
    	
    	
    	
    }
 
    
    
    @Test(priority=11,groups="group1")
     public void TC_COM_011_ValidateSaveWithNumericalAndSymbolDataInCommodityGroupField1() throws InterruptedException {
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("Verify User Click The Master Data ");
    	LoggerUtil.info("Verify User Click The Commodity Master");
    	dashboard.clickoncommodityMaster();
    	LoggerUtil.info("User Click The Add commodity Tab");
    	
    	Thread.sleep(3000);
    	commodity.AddCommodity("@@@");
    	
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
    @Test(priority=11,groups="group1")
    public void TC_COM_013_AutoPopulateDensityValueForExistingGroupClassification() throws InterruptedException {
    	
    	String comgrpvalue = faker.name().firstName()+faker.letterify("?????");
    	String groupclassififcation = faker.name().firstName()+faker.letterify("??????");
    	String specificgrade = faker.name().firstName()+faker.letterify("????");
    	String densityvalue = faker.number().digits(4);
    	
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("Verify User Click The Master Data ");
        LoggerUtil.info("Verify User Click The Commodity Master");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
        commodity.verifyautofilleddensity(comgrpvalue,groupclassififcation, specificgrade, densityvalue, groupclassififcation);
    	
    	
    	
    	
    }
    
    @Test(priority=12,groups="group1")
    public void TC_COM_017_ManualEntryInExportedFile() throws InterruptedException {
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("Verify User Click The Master Data ");
        LoggerUtil.info("Verify User Click The Commodity Master");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        commodity.exportdeta();
    	
    	
    	
   
    	
    }
    
    @Test(priority=12,groups="group1")
    public void TC_COM_017_ManualEntryInExportedFileVerifyDataDataHasBeenSavedOrNot() throws InterruptedException {
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("Verify User Click The Master Data ");
        LoggerUtil.info("Verify User Click The Commodity Master");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        commodity.exportdeta();
        
        Thread.sleep(6000);
        dashboard.clickOnCommodityTabByName("Commodity Details");
        
        File latestFile = getLatestNewSpecificGradeFileForCommodityGroup();
	   

	    String filePath = latestFile.getAbsolutePath();

    	commodity.verifycomoditysheetTocommodityDetails(filePath);
    	
    	
   
    	
    }
    
    
    
    @Test(priority=13,groups="group1")
    public void TC_COM_021_ValidatePromptOnSuccessfulSave() throws InterruptedException {
    	
    	String comgrpvalue = faker.name().firstName()+faker.letterify("??????");
    	String groupclassification = faker.name().firstName()+faker.letterify("??????");
    	String specificgrade = faker.name().firstName()+faker.letterify("????");
    	String densityvalue = faker.number().digits(5);
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("Verify User Click The Master Data ");
        LoggerUtil.info("Verify User Click The Commodity Master");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
        commodity.clicksavebutton(comgrpvalue,groupclassification,specificgrade,densityvalue,"Commodity Group Saved Successfully");
    	
    	
    	
    	
    	
    	
    }
 
   
 
    @Test(priority = 14, groups = "group1")
    public void TC_COM_022_ValidatePromptForDuplicateCommodity() throws InterruptedException {
    	
    	String comgrpvalue = faker.name().firstName()+faker.letterify("?????");
    	String groupclssification = faker.name().firstName()+faker.letterify("?????");
    	String specificgrade =faker.name().firstName()+faker.letterify("?????");
    	String densityvalue = faker.number().digits(5);
    	dashboard.clickingDashboard("");
        LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' section.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
       
 
        commodity.SaveDuplicatevalue(comgrpvalue,groupclssification, specificgrade, densityvalue, "Commodity Group already exist !");
    }
 
 
    
    @Test(priority = 15, groups = "group1")
    public void TC_COM_023_ValidatePromptOnDeleteFailureDueToDependency() throws InterruptedException {
       
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' section from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' module.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Attempt to delete commodity group that has dependency.");
        LoggerUtil.info("→ Commodity Group to delete: Ferrous Metals");
        LoggerUtil.info("→ Expected Prompt: Can't be Deleted commodity due to dependent data!");
 
        commodity.deleteData("Ferrous Metals", "Can't be Deleted commodity due to dependent data!");
    }
 
 
    
    @Test(priority = 16, groups = "group1")
    public void TC_COM_024_ValidatePromptOnSuccessfulDelete() throws InterruptedException {
    	
    	String comgrpvalue = faker.name().firstName()+faker.letterify("???????");
    	String groupclassification = faker.name().firstName()+faker.letterify("???????");
    	String specificgrade = faker.name().firstName()+faker.letterify("?????");
    	String density = faker.number().digits(5);
    	
    	
    	dashboard.clickingDashboard("");
        LoggerUtil.info("STEP 1: Navigate to 'Master Data' section.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' module.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
       
     
 
        commodity.deletenormaldata(comgrpvalue,groupclassification, specificgrade, density, groupclassification, "Commodity group deleted successfully");
    }
 
    
    @Test(priority = 17, groups = "group1")
    public void TC_COM_025_ValidatePromptOnSuccessfulUpdate() throws InterruptedException {
    	String comgrpvalue = faker.name().firstName()+faker.letterify("???????");
    	String groupclassification = faker.name().firstName()+faker.letterify("?????");
    	String specificgrade = faker.name().firstName()+faker.letterify("?????");
    	String density = faker.number().digits(5);
    	String updatedgroupclassification = faker.name().firstName()+faker.letterify("?????");
    	dashboard.clickingDashboard("");
        LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' section.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Create and update a Commodity Group.");
        LoggerUtil.info("→ Original Group Classification: " + randomName);
        LoggerUtil.info("→ Specific Grade: " + randomName1);
        LoggerUtil.info("→ Density: " + randomName2);
        LoggerUtil.info("→ Search Value: " + randomName);
        LoggerUtil.info("→ Updated Classification: " + randomName3);
 
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
        commodity.commoditygroupupdatesucessfully(comgrpvalue,groupclassification, specificgrade, density, groupclassification, updatedgroupclassification);
    }
 
    
    
    @Test(priority = 18, groups = "group1")
    public void TC_COM_027_PromptOnMissingMandatoryFields() throws InterruptedException {
       
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' screen.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Begin validation for missing mandatory fields.");
        
        commodity.promptmissingforgrpclassification(
            randomName, randomName1, "Group classification is Required",   // Missing Group Classification
            randomName, randomName1, "Specific Grade is Required",        // Missing Specific Grade
            randomName, randomName1, "Density is Required"                // Missing Density
        );
    }
 
 
    @Test(priority = 19, groups = "group1")
    public void TC_COM_031_ValidateDensityValueAppearsInViewTable() throws InterruptedException {
    	String comgrpvalue = faker.name().firstName()+faker.letterify("???????");
    	String groupclassification = faker.name().firstName()+faker.letterify("?????");
    	String specificgrade = faker.name().firstName()+faker.letterify("?????");
    	String density = faker.number().digits(5);
       
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' via Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' screen.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 3: Begin validation to check if Density value appears correctly in view table.");
        LoggerUtil.info("→ Expected Density Value: 12321");
 
        AddcommodityPage.SaveNewData(comgrpvalue,comgrpvalue);
        Thread.sleep(6000);
        commodity.densityvaluevalidate(comgrpvalue,groupclassification,specificgrade,density);
    }
 
    
    @Test(priority = 20, groups = "group1")
    public void TC_COM_032_ResetButtonFunctionalityAfterEdit() throws InterruptedException {
        
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' section.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' module.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(2000);
 
        LoggerUtil.info("STEP 3: Verify 'Reset' button functionality after clicking 'Edit'.");
        commodity.VerifyRestFunctionality();
    }
 
    
 
    
    
    
    @Test(priority = 22, groups = "group1",enabled=false)
    public void TC_COM_034_SAASAddSameCommodityForDifferentClients() throws InterruptedException {
 
        LoggerUtil.info("STEP 1: Login as Client A (Rishi).");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
 
        LoggerUtil.info("STEP 2: Save commodity data under Client A.");
        commodity.saveDataForClientA(randomName, randomName1, randomName2);
        Thread.sleep(4000);
 
        LoggerUtil.info("STEP 3: Logout Client A.");
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 4: Login as Client B (Shiv Sir).");
        login.loginApplication(prop.getProperty("username3"), prop.getProperty("password3"));
        Thread.sleep(4000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(5000);
        dashboard.clickoncommodityMaster();
 
        LoggerUtil.info("STEP 5: Save same commodity data under Client B.");
        commodity.saveDataForClientB(randomName, randomName1, randomName2);
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 6: Logout Client B.");
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 7: Login again as Client A (Rishi) to update the entry.");
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
 
        LoggerUtil.info("STEP 8: Update commodity under Client A.");
        commodity.editsavedDataForClientA(randomName, randomName3);
        Thread.sleep(4000);
 
        LoggerUtil.info("STEP 9: Logout Client A.");
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 10: Login as Client B (Shiv Sir) to verify data remains unchanged.");
        login.loginApplication(prop.getProperty("username3"), prop.getProperty("password3"));
        Thread.sleep(4000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(5000);
        dashboard.clickoncommodityMaster();
 
        LoggerUtil.info("STEP 11: Verify unchanged data under Client B.");
        commodity.verifysavedDataInClientB(randomName);
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 12: Logout Client B.");
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 13: Login as Client A (Rishi) to delete updated record.");
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
        dashboard.clickoncommodityMaster();
 
        LoggerUtil.info("STEP 14: Delete the updated commodity under Client A.");
        commodity.verifydeletebtnInClientA(randomName3);
        Thread.sleep(4000);
 
        LoggerUtil.info("STEP 15: Logout Client A.");
        dashboard.clickOnlogoutbtn();
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 16: Login again as Client B (Shiv Sir) to confirm data still exists.");
        login.loginApplication(prop.getProperty("username3"), prop.getProperty("password3"));
        Thread.sleep(4000);
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(5000);
        dashboard.clickoncommodityMaster();
 
        LoggerUtil.info("STEP 17: Re-verify data under Client B.");
        commodity.verifysavedDataInClientB(randomName);
        Thread.sleep(3000);
 
        LoggerUtil.info("✅ Test complete: Client A & B can handle same commodity data independently.");
    }
 
    @Test(priority = 23, groups = "group1")
    public void TC_COM_028_ValidatePromptOnSuccessfulExport() throws InterruptedException {
        
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);
 
        LoggerUtil.info("STEP 2: Open 'Commodity Master' section.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(2000);
 
        LoggerUtil.info("STEP 3: Trigger export and verify success prompt.");
        commodity.verifySucessfullPromt("Commodity group File Succcessfully Exported");
    }
    
    @Test(priority = 24, groups = "group1")
    public void TC_COM_030_ImportFileValidationForMissingColumns() throws InterruptedException {
    	String commodityGroup = faker.name().firstName()+faker.letterify("????????");
		String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
        String density = faker.number().digits(5);
    	String SaveAsNewSpecificGrade = faker.name().firstName()+faker.letterify("????????");
    	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
		Thread.sleep(3999);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyDownLoadExcelFile();
		Thread.sleep(2000);
		QuickMasterPage.ImportExcelFileCommodityGroup(commodityGroup, groupClassification, "", density,"All fields are mandatory");

		Thread.sleep(3000);
	}


    @Test(priority = 25, groups = "group1")
    public void TC_COM_018_ExportDataPasteValidationPrompt() throws InterruptedException {
        
    	String commodityGroup = faker.name().firstName()+faker.letterify("????????");
		String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
        String density = faker.number().digits(5);
    	String SaveAsNewSpecificGrade = faker.name().firstName()+faker.letterify("????????");
    	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
		Thread.sleep(3999);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyDownLoadExcelFile();
		Thread.sleep(2000);
		QuickMasterPage.ImportExcelFileCommodityGroup(commodityGroup, groupClassification, specificGrade, "@#$%^","All fields are mandatory");

		Thread.sleep(3000);
		
		
		

    }

    
    
    

    @Test(priority=5,groups="group1")
	public void TC_COM_019PostImportViewTableValidation() throws InterruptedException {
		
		
		String commodityGroup = faker.name().firstName()+faker.letterify("????????");
		String groupClassification = faker.name().firstName()+faker.letterify("????");
    	String specificGrade = faker.name().firstName()+faker.letterify("????");
        String density = faker.number().digits(5);
    	String SaveAsNewSpecificGrade = faker.name().firstName()+faker.letterify("????????");
    	Thread.sleep(2000);
		dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(2000);
		dashboard.clickoncommodityMaster();
		Thread.sleep(2000);
		QuickMasterPage.SaveNewCommodityGroupNameFirstTab(commodityGroup);
		Thread.sleep(3999);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyDownLoadExcelFile();
		Thread.sleep(2000);
		QuickMasterPage.ImportExcelFileCommodityGroup(commodityGroup, groupClassification, specificGrade, density,"Commodity group file successfully imported");

		Thread.sleep(3000);
		
		Thread.sleep(3000);
		dashboard.clickOncommoditygroup();
		Thread.sleep(2000);
		QuickMasterPage.verifyMatchingDataAllAreImportedCorrectly(commodityGroup);
		
		
		
		
	}
    @Test(priority = 26, groups = "group1")
    public void TC_COM_035_UserRightsValidationReadOnly() throws InterruptedException {
        
    	dashboard.clickingDashboard("");
    	LoggerUtil.info("STEP 1: Navigate to 'Master Data' from Dashboard.");
        dashboard.selectMenuFormDashBoard("Master Data");
        Thread.sleep(3000);

        LoggerUtil.info("STEP 2: Open 'Control Master' and set user access to ReadOnly.");
        dashboard.clickOnControlMaster();
        Thread.sleep(3000);
        dashboard.selectControlMaster("Users");
        Thread.sleep(3000);
        ControlMasterPage.VerifyClickingForUnselectWriteAuthorityForCommodityGroup(); // assumes this method sets rights
         Thread.sleep(3000);
        LoggerUtil.info("STEP 3: Open 'Commodity Master' with ReadOnly rights.");
        dashboard.clickoncommodityMaster();
        Thread.sleep(2000);

        LoggerUtil.info("STEP 4: Validate that Save button is not visible under ReadOnly mode.");
        commodity.verifysavebuttonInUserAuthorization();
    }

    
    
    
}
