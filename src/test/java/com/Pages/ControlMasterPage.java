package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.helper.Base;
import com.helper.LoggerUtil;

public class ControlMasterPage extends Base {
	
	DashboardPage dpage = new DashboardPage ();
	ProcessMasterPage PmasterPage = new ProcessMasterPage();
	
	public static  final By userbtn  = By.xpath("//li[@class=\"slide\"]//a[@href=\"/Subscription/Users\"]");
	public static final By userauthorizationtab = By.xpath("//a[@href=\"#UserAuthorizationTab\"]");
	public static final By userideditbtn = By.xpath("//table[@id=\"example2\"]//tbody//tr[5]//td[4]//a[@href=\"/Subscription/EditUserAuthorize/729f1029-0522-4ff3-8107-e9f9a70e20ce\"]");
	public static final By estimateclick = By.xpath("//div[@id=\"jstree\"]//li[@aria-labelledby=\"261_anchor\"]//i[@class=\"jstree-icon jstree-ocl\"]");
	public static final By salesuncehckedinestimatefile = By.xpath("//li[@id=\"261\"]//ul//li//a[@id=\"262_anchor\"]//i[1]");
	public static final By customerlogoInProcessMaster = By.xpath("//h3[@id=\"cust\"]");
	public static final By updatebtn = By.xpath("//a[@id='btnSubmit']");
	public static final By CustomerColumnOnViewPage = By.xpath("//span[@id='custtProcess']");
	public static final By ViewBtn = By.xpath("//button[@onclick=\"processList(1)\"]");
	public static final By supplierColumnOnVIewPage = By.xpath("//*[@id=\"unitTable1\"]/thead/tr/th[9]");
	public static final By supplieruncheckedbtn = By.xpath("//*[@id=\"263_anchor\"]/i[1]");
	public static final By ClickingProcessMaster = By.xpath("//a[@href='/Masters/ProcessMaster/Index']");
	public static final By verifycustomerheader = By.xpath("//h3[@id='cust']");
	public void clickforsalesbutton() throws InterruptedException {
	    
		
		try {
	        LoggerUtil.info("🔵 Step 1: Clicking on User button");
	        clickOnElement(userbtn);
	        Thread.sleep(8000);

	        LoggerUtil.info("🔵 Step 2: Navigating to User Authorization Tab");
	        clickOnElement(userauthorizationtab);
	        Thread.sleep(6000);

	        LoggerUtil.info("🔵 Step 3: Clicking Edit on User ID");
	        clickOnElement(userideditbtn);
	        Thread.sleep(5000);

	        LoggerUtil.info("🔵 Step 4: Navigating to Estimate Tab");
	        clickOnElement(estimateclick);
	        Thread.sleep(6000);

	        LoggerUtil.info("🔵 Step 5: Unchecking Sales checkbox inside Estimate File");
	        clickOnElement(salesuncehckedinestimatefile);
	        Thread.sleep(4000);

	        LoggerUtil.info("🔵 Step 6: Clicking Update Button");
	        clickOnElement(updatebtn);
	        Thread.sleep(9000);

	        dpage.clickOnControlMaster();
	        Thread.sleep(3000);
	        LoggerUtil.info("🔵 Step 7: Clicking on Process Item from main dashboard/page");
	        clickOnElement(ClickingProcessMaster);

	        Thread.sleep(2000);
	        WebElement customerheader = driver.findElement(verifycustomerheader); 
	       if(!customerheader.isDisplayed()) {
	    	
	    	   LoggerUtil.pass(" Customer Header Is Not Getting ");
	       }
	       
	       else {
	    	   LoggerUtil.fail("Still Customer header is getting ");
	       }
	        
	    } catch (Exception e) {
	        LoggerUtil.logException(e);
	        throw e; // Re-throwing for test to fail in framework
	    }
	}



 
 
	public void clickSupplierButton() throws InterruptedException {
	    try {
	       

	        LoggerUtil.info("🔵 Step 2: Navigating to User Authorization Tab");
	        clickOnElement(VerifyUserAutorisationTab);

            LoggerUtil.info("🔍 Searching user ID: sachindra@costmasters.in");
            Thread.sleep(3000);
            clearAndEnterText(waitForExpectedElement(EnterIdNameForSearch), "sachindra@costmasters.in");

            LoggerUtil.info("✏️ Clicking Edit button for user...");
            Thread.sleep(2000);
            clickOnElement(clickingEditButtonForId);


	        LoggerUtil.info("🔵 Step 4: Navigating to Estimate Tab");
	        clickOnElement(estimateclick);
	        Thread.sleep(6000);

	        LoggerUtil.info("🔵 Step 5: Unchecking Supplier checkbox inside Estimate File");
	        clickOnElement(supplieruncheckedbtn);

	        LoggerUtil.info("🔵 Step 6: Clicking Update Button");
	        clickOnElement(updatebtn);
	        Thread.sleep(10000);

	        dpage.clickOnControlMaster();
	        Thread.sleep(3000);
	        LoggerUtil.info("🔵 Step 7: Clicking on Process Item from main dashboard/page");
	        clickOnElement(ClickingProcessMaster);

	        LoggerUtil.info("🔍 Step 9: Checking if Supplier column is removed from table");
	        List<WebElement> supplierColumn = driver.findElements(By.xpath("//table[@id='unitTable1']/thead/tr/th[8]"));

	        if (supplierColumn.isEmpty()) {
	            LoggerUtil.pass("✅ Supplier column has been removed successfully from the table.");
	        } else {
	            LoggerUtil.fail("❌ Supplier column is still visible in the table – expected it to be removed.");
	        }
	    } catch (Exception e) {
	        LoggerUtil.logException(e);
	        throw e;
	    }
	}

 
 
 
 
	public static final By VerifyUserAutorisationTab = By.xpath("//a[contains(text(),'User Authorization') or @href='#UserAuthorizationTab']");
    public static final By EnterIdNameForSearch = By.xpath("//div[@id='example2_filter']/label/input[@class='form-control form-control-sm']");
    public static final By clickingEditButtonForId = By.xpath("//table[@id='example2']/tbody/tr/td[4]/a/span/i");
    public static final By clickingMasterTriangle = By.xpath("//div[@id='jstree']/ul/li/i");
    public static final By clickingBOPMasterTriangle = By.xpath("//div[@id='jstree']/ul/li/ul/li[2]/i");
    public static final By clickingUserTriangle = By.xpath("//div[@id='jstree']/ul/li/ul/li[4]/i/following-sibling::ul/li[11]/i");
    public static final By ClickingReadAndWriteCheckbox = By.xpath("//div[@id='jstree']/ul/li/ul/li[2]/i/following-sibling::ul/li[2]/a/i[1]");
    public static final By ClickingUpdateButton = By.xpath("//a[@id='btnSubmit']");
    
    
    public void VerifyUserAuthorityUncheckedReadAndWriteForBopMaster() throws InterruptedException {
        try {
            LoggerUtil.info("🔍 Navigating to User Authorization tab...");
            Thread.sleep(3000);
            clickOnElement(VerifyUserAutorisationTab);

            LoggerUtil.info("🔍 Searching user ID: sachindra@costmasters.in");
            Thread.sleep(3000);
            clearAndEnterText(waitForExpectedElement(EnterIdNameForSearch), "sachindra@costmasters.in");

            LoggerUtil.info("✏️ Clicking Edit button for user...");
            Thread.sleep(2000);
            clickOnElement(clickingEditButtonForId);

            LoggerUtil.info("📂 Expanding Master section...");
            Thread.sleep(2000);
            clickOnElement(clickingMasterTriangle);

            LoggerUtil.info("📂 Expanding BOP Master submenu...");
            Thread.sleep(3000);
            clickOnElement(clickingBOPMasterTriangle);

            LoggerUtil.info("📌 Unchecking Read and Write checkbox for BOP Master...");
            Thread.sleep(4000);
            clickOnElement(ClickingReadAndWriteCheckbox);

            LoggerUtil.info("💾 Clicking Update button to save authority changes...");
            Thread.sleep(2000);
            clickOnElement(ClickingUpdateButton);

            LoggerUtil.pass("✅ User authority updated successfully: 'Read and Write' unchecked for BOP Master.");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot("UserAuthorityRWUnchecked", "");
            LoggerUtil.fail("❌ Failed to update user authority. Exception: " + e.getMessage());
            LoggerUtil.info("🖼 Screenshot saved at: " + screenshotPath);
            throw e; // Optional: rethrow if test should stop
        }
    }



    public void verifyUncheckSupplierButton() throws InterruptedException {
        LoggerUtil.info("Test Started: verifyUncheckSupplierButton");

        try {
            LoggerUtil.info("🔵 Step 2: Navigating to User Authorization Tab");
            clickOnElement(VerifyUserAutorisationTab);

            LoggerUtil.info("🔍 Searching user ID: sachindra@costmasters.in");
            Thread.sleep(3000);
            clearAndEnterText(waitForExpectedElement(EnterIdNameForSearch), "sachindra@costmasters.in");

            LoggerUtil.info("✏️ Clicking Edit button for user...");
            Thread.sleep(2000);
            clickOnElement(clickingEditButtonForId);

            LoggerUtil.info("🔵 Step 4: Navigating to Estimate Tab");
            clickOnElement(estimateclick);
            Thread.sleep(6000);

            LoggerUtil.info("🔵 Step 5: Unchecking Supplier checkbox inside Estimate File");
            clickOnElement(supplieruncheckedbtn);

            LoggerUtil.info("🔵 Step 6: Clicking Update Button");
            clickOnElement(updatebtn);
            Thread.sleep(10000);

            LoggerUtil.info("➡️ Navigating back to Control Master to complete flow");
            dpage.clickOnControlMaster();
            Thread.sleep(3000);

            LoggerUtil.pass("Supplier checkbox unchecked and update action completed successfully.");

        } catch (Exception e) {
            LoggerUtil.error("Error in verifyUncheckSupplierButton: " + e.getMessage());
            LoggerUtil.fail("Test Failed: verifyUncheckSupplierButton");
            throw e;
        }
    }


	
    
      public void VerifyUncheckCustomerButton() throws InterruptedException {
	    
		
		try {
			 LoggerUtil.info("🔵 Step 2: Navigating to User Authorization Tab");
	            clickOnElement(VerifyUserAutorisationTab);

	            LoggerUtil.info("🔍 Searching user ID: sachindra@costmasters.in");
	            Thread.sleep(3000);
	            clearAndEnterText(waitForExpectedElement(EnterIdNameForSearch), "sachindra@costmasters.in");

	            LoggerUtil.info("✏️ Clicking Edit button for user...");
	            Thread.sleep(2000);
	            clickOnElement(clickingEditButtonForId);

	        LoggerUtil.info("🔵 Step 4: Navigating to Estimate Tab");
	        clickOnElement(estimateclick);
	        Thread.sleep(6000);

	        LoggerUtil.info("🔵 Step 5: Unchecking Sales checkbox inside Estimate File");
	        clickOnElement(salesuncehckedinestimatefile);
	        Thread.sleep(4000);

	        LoggerUtil.info("🔵 Step 6: Clicking Update Button");
	        clickOnElement(updatebtn);
	        Thread.sleep(9000);

	        dpage.clickOnControlMaster();
	        Thread.sleep(3000);
	     
	        
	    } catch (Exception e) {
	        LoggerUtil.logException(e);
	        throw e; // Re-throwing for test to fail in framework
	    }
	}


    public static final By ClickingCommodityTriangle = By.xpath("//ul[@class='jstree-children']/li[3]/i");
    public static final By clickingReadAndWriteCheckbox = By.xpath("//ul[@class='jstree-children']/li[3]/ul/descendant::a[2]/i");
    public static void VerifyClickingForUnselectWriteAuthorityForCommodityGroup() throws InterruptedException {
    	
    	
    	 clickOnElement(VerifyUserAutorisationTab);

         LoggerUtil.info("🔍 Searching user ID: sachindra@costmasters.in");
         Thread.sleep(3000);
         clearAndEnterText(waitForExpectedElement(EnterIdNameForSearch), "sachindra@costmasters.in");

         LoggerUtil.info("✏️ Clicking Edit button for user...");
         Thread.sleep(2000);
         clickOnElement(clickingEditButtonForId);

         LoggerUtil.info("📂 Expanding Master section...");
         Thread.sleep(2000);
         clickOnElement(clickingMasterTriangle);
            Thread.sleep(3000);
            clickOnElement(clickingReadAndWriteCheckbox);
            Thread.sleep(3000);
            
         
            clickOnElement(ClickingUpdateButton);
            Thread.sleep(4000);
            
    	
    	
    }
 
 
 
 
 
 
 
 
}























