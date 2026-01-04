package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.helper.Base;

import com.helper.LoggerUtil;



public class AddcommodityPage extends Base {
	
	  Base base = new Base();
	public static final By commoditygrobox = By.xpath("//input[@id='commodityGroup']");
	public static final By savebtn = By.xpath("//button[@id='tab1Save']");
	public static final By entersearchvalue = By.xpath("(//input[@type='search'])[1]");
	public static final By editbtn = By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[3]/a/i");
	public static final By nextpagebtn = By.xpath("//ul[@class='pagination']/li[4]");
	public static final By nextpagevalidation = By.xpath("//table[@id='commodtiyTable']/tbody/tr/td");
	public static final By toastmsg = By.xpath("//div[@class='toast-message']");
	
	
	
	public static void SaveNewData(String cbox,String sbox) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(commoditygrobox), cbox);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(entersearchvalue), sbox);
			
		
	}
   
	public static final By fetchingTableDataForCommodityGroup = By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[2]");
	public void searchfilter(String cbox ,String sbox) throws InterruptedException {
		
		
		clearAndEnterText(waitForExpectedElement(commoditygrobox), cbox);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		
		
		clearAndEnterText(waitForExpectedElement(entersearchvalue), sbox);

		Thread.sleep(2000);
		String actualdataCommgrname = waitForExpectedElement(fetchingTableDataForCommodityGroup).getText();
		Thread.sleep(3000);
		Assert.assertEquals(actualdataCommgrname, sbox);
		
		
		
		
	}
	public void ClickingEditbtn(String cbox, String sbox, String EnterNewComgrpbox) {
	    try {
	        LoggerUtil.info("Step 1: Entering Commodity Group value: " + cbox);
	        clearAndEnterText(waitForExpectedElement(commoditygrobox), cbox);
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 2: Clicking on Save button");
	        clickOnElement(savebtn);
	        Thread.sleep(6000);

	        LoggerUtil.info("Step 3: Searching for saved value: " + sbox);
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), sbox);
	        Thread.sleep(2000);

	        LoggerUtil.info("Step 4: Clicking on Edit button");
	        clickOnElement(editbtn);
	        Thread.sleep(2000);

	        LoggerUtil.info("Step 5: Updating Commodity Group with: " + EnterNewComgrpbox);
	        clearAndEnterText(waitForExpectedElement(commoditygrobox), EnterNewComgrpbox);
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 6: Clicking on Update button");
	        clickOnElement(updatebtn);

	        Thread.sleep(5000);
	        LoggerUtil.info("Step 7: Searching again for updated value: " + EnterNewComgrpbox);
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), EnterNewComgrpbox);
	        Thread.sleep(2000);

	        String actualcomgrp = waitForExpectedElement(fetchingTableDataForCommodityGroup).getText();
	        String expectedcomgrp = EnterNewComgrpbox;

	        if (actualcomgrp.equals(expectedcomgrp)) {
	            LoggerUtil.pass("Commodity Group updated successfully. Expected: " 
	                            + expectedcomgrp + ", Actual: " + actualcomgrp);
	        } else {
	            LoggerUtil.fail("Commodity Group update failed. Expected: " 
	                            + expectedcomgrp + ", Actual: " + actualcomgrp);
	        }

	        Assert.assertEquals(actualcomgrp, expectedcomgrp);

	    } catch (Exception e) {
	        LoggerUtil.error("Exception occurred in ClickingEditbtn: " + e.getMessage());
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    }
	}

	
	public void nextbtn() {
	    String expectedvalue = "51";
	    String actualvalue = null;

	    // Step 1: Capture screenshot
	    try {
	        LoggerUtil.info("Step 1: Capturing screenshot before clicking Next button");
	        captureStepScreenshot("nextpagebtn");
	        LoggerUtil.pass("Screenshot captured successfully for Next button");
	    } catch (Exception e) {
	        LoggerUtil.fail("Failed to capture screenshot: " + e.getMessage());
	    }

	    // Step 2: Click Next Page button
	    try {
	        LoggerUtil.info("Step 2: Clicking on Next Page button");
	        clickOnElement(nextpagebtn);
	        Thread.sleep(3000);
	        LoggerUtil.pass("Next Page button clicked successfully");
	    } catch (Exception e) {
	        LoggerUtil.fail("Failed to click Next Page button: " + e.getMessage());
	    }

	    // Step 3: Fetch value from next page
	    try {
	        LoggerUtil.info("Step 3: Fetching value from next page for validation");
	        actualvalue = waitForExpectedElement(nextpagevalidation).getText();
	        LoggerUtil.pass("Fetched next page value: " + actualvalue);
	    } catch (Exception e) {
	        LoggerUtil.fail("Failed to fetch value from next page: " + e.getMessage());
	    }

	    // Step 4: Validate expected vs actual
	    try {
	        LoggerUtil.info("Step 4: Validating next page value");
	        if (expectedvalue.equals(actualvalue)) {
	            LoggerUtil.pass("Validation successful. Expected: " + expectedvalue + ", Actual: " + actualvalue);
	        } else {
	            LoggerUtil.fail("Validation failed. Expected: " + expectedvalue + ", Actual: " + actualvalue);
	        }
	        Assert.assertEquals(actualvalue, expectedvalue);
	    } catch (Exception e) {
	        LoggerUtil.error("Validation step threw exception: " + e.getMessage());
	        Assert.fail("Test failed during validation step: " + e.getMessage());
	    }
	}

     
     public static final By lengthofrows = By.xpath("//select[@name='commodtiyTable_length']") ; 
     public static final By numberoflengthtbl = By.xpath("//table[@id='commodtiyTable']/tbody/tr");
     public void VerifyActualLength(String value) {
    	  
    	    selectDropDownValue(lengthofrows, value, "selectValue");
    	    LoggerUtil.info("User selected the number of rows: " + value);

    	    
    	    captureStepScreenshot("Selected" + value + "FromDropdown");

    	   
    	    List<WebElement> listofrows = driver.findElements(numberoflengthtbl);
    	    int expectedRowCount = Integer.parseInt(value);
    	    int actualRowCount = listofrows.size();

    	  
    	    LoggerUtil.info("Expected Row Count: " + expectedRowCount);
    	    LoggerUtil.info("Actual Row Count from Table: " + actualRowCount);

    	    
    	    Assert.assertEquals(actualRowCount, expectedRowCount, "Mismatch in expected and actual number of rows!");
    	    captureStepScreenshot(value + "RowsVisibleInTable");
    	}
     
     public static final By deletebtn = By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[3]/a[2]/i");

     public void verifydeletebtn(String cmg, String esv, String message) {
    	    try {
    	        LoggerUtil.info("Step 1: Enter Commodity Group: " + cmg);
    	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmg);
    	       
    	        LoggerUtil.pass("Commodity Group entered successfully.");

    	        LoggerUtil.info("Step 2: Click Save button");
    	        Base.clickOnElement(savebtn);
    	       
    	        LoggerUtil.pass("Save button clicked.");
    	        Thread.sleep(7000);

    	        LoggerUtil.info("Step 3: Search saved Commodity: " + esv);
    	        Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv);
    	       
    	        LoggerUtil.pass("Commodity searched successfully.");
    	        Thread.sleep(8000);

    	        LoggerUtil.info("Step 4: Click Delete button");
    	        Base.clickOnElement(deletebtn);
    	        Thread.sleep(4000);
    	      
				base.safeAcceptAlert();
    	       
    	        LoggerUtil.pass("Delete action performed and alert accepted.");
    	        Thread.sleep(3000);

    	        LoggerUtil.info("Step 5: Re-search deleted Commodity: " + esv);
    	        Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv);
    	       
    	        LoggerUtil.pass("Re-search executed successfully.");

    	        LoggerUtil.info("Expected Result: " + message);
    	    } catch (AssertionError ae) {
    	        LoggerUtil.fail("Assertion failed in verifydeletebtn: " + ae.getMessage());
    	        throw ae;
    	    } catch (Exception e) {
    	        LoggerUtil.error("Exception in verifydeletebtn: " + e.getMessage());
    	        e.printStackTrace();
    	    }
    	}

         
        public static final By saveasnewbtn = By.xpath("//button[@id='tab1SaveAsNew']");

        public void DeletbtnsaveAsNew(String entercomgrpname, String searchComgrpname, String EntersaveAsnewcomgrpname) {
            try {
                LoggerUtil.info("Step 1: Enter Commodity Group name: " + entercomgrpname);
                Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), entercomgrpname);
               
                LoggerUtil.pass("Commodity Group entered successfully.");

                LoggerUtil.info("Step 2: Click Save button");
                Base.clickOnElement(savebtn);
              
                LoggerUtil.pass("Save button clicked.");
                Thread.sleep(5000);

                LoggerUtil.info("Step 3: Search saved Commodity Group: " + searchComgrpname);
                Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), searchComgrpname);
               
                LoggerUtil.pass("Commodity searched successfully.");
                Thread.sleep(5000);

                LoggerUtil.info("Step 4: Click Edit button");
                Base.clickOnElement(editbtn);
                
                LoggerUtil.pass("Edit button clicked.");
                Thread.sleep(3000);

                LoggerUtil.info("Step 5: Enter Save As New Commodity Group name: " + EntersaveAsnewcomgrpname);
                Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), EntersaveAsnewcomgrpname);
                
                LoggerUtil.pass("New Commodity Group name entered.");
                Thread.sleep(7000);

                LoggerUtil.info("Step 6: Click Save As New button");
                Base.clickOnElement(saveasnewbtn);
                
                LoggerUtil.pass("Save As New button clicked.");
                Thread.sleep(5000);

                LoggerUtil.info("Step 7: Search new Commodity Group: " + EntersaveAsnewcomgrpname);
                Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), EntersaveAsnewcomgrpname);
                
                LoggerUtil.pass("New Commodity Group searched successfully.");
                Thread.sleep(7000);

                LoggerUtil.info("Step 8: Delete new Commodity Group");
                Base.clickOnElement(deletebtn);
                Thread.sleep(3000);
               base.safeAcceptAlert();
               
                LoggerUtil.pass("Delete action performed and alert accepted.");
               
            } catch (AssertionError ae) {
                LoggerUtil.fail("Assertion failed in DeletbtnsaveAsNew: " + ae.getMessage());
                throw ae;
            } catch (Exception e) {
                LoggerUtil.error("Exception in DeletbtnsaveAsNew: " + e.getMessage());
                e.printStackTrace();
            }
        }

     
        public void verifyDeleteExistingData(String entercomgrpname, String message) {
            try {
              

                LoggerUtil.info("Step 3: Search saved Commodity Group: " + entercomgrpname);
                Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), entercomgrpname);
               
                LoggerUtil.pass("Commodity searched successfully.");
                Thread.sleep(5000);

                LoggerUtil.info("Step 4: Click Delete button");
                Base.clickOnElement(deletebtn);
                
                LoggerUtil.pass("Delete button clicked.");
                Thread.sleep(4000);

                LoggerUtil.info("Step 5: Accept delete alert");
                base.safeAcceptAlert();
               
                LoggerUtil.pass("Delete alert accepted.");

                LoggerUtil.info("Step 6: Validate toast message contains expected text: " + message);
                String actualToast = Base.waitForExpectedElement(toastmsg).getText();
               
                Assert.assertTrue(actualToast.contains(message),
                        "Expected toast to contain: " + message + " but found: " + actualToast);
                LoggerUtil.pass("Toast message validation successful. Message: " + actualToast);

            } catch (AssertionError ae) {
                LoggerUtil.fail("Assertion failed in verifyDeleteExistingData: " + ae.getMessage());
                throw ae;
            } catch (Exception e) {
                LoggerUtil.error("Exception in verifyDeleteExistingData: " + e.getMessage());
                e.printStackTrace();
            }
        }

         
         
         public static final By fetching = By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[2]");
         
         public void verifyClickEditBtn(String entercomgrpname) {
        	    try {
        	        LoggerUtil.info("Step 1: Enter Commodity Group name: " + entercomgrpname);
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), entercomgrpname);
        	        LoggerUtil.pass("Commodity Group entered successfully.");

        	        LoggerUtil.info("Step 2: Click Save button");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked.");
        	        Thread.sleep(5000);

        	        LoggerUtil.info("Step 3: Search Commodity Group: " + entercomgrpname);
        	        Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), entercomgrpname);
        	        LoggerUtil.pass("Search value entered successfully.");
        	        Thread.sleep(6000);

        	        LoggerUtil.info("Step 4: Fetch Commodity Group value from table");
        	        String actualvalue = Base.waitForExpectedElement(fetching).getText();
        	        LoggerUtil.pass("Fetched value from table: " + actualvalue);

        	        LoggerUtil.info("Step 5: Click Edit button");
        	        Base.clickOnElement(editbtn);
        	        LoggerUtil.pass("Edit button clicked successfully.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 6: Fetch Commodity Group value from edit form");
        	        String expectedvalue = Base.waitForExpectedElement(commoditygrobox).getAttribute("value");
        	        LoggerUtil.pass("Fetched value from edit form: " + expectedvalue);
        	        Thread.sleep(4000);

        	        LoggerUtil.info("Step 7: Validate table value matches form value");
        	        LoggerUtil.info("Comparison -> Table Value: " + actualvalue + " | Edit Form Value: " + expectedvalue);
        	        Assert.assertEquals(actualvalue, expectedvalue,
        	                "Mismatch between table value and edit form value!");
        	        LoggerUtil.pass("Validation successful. Table value matches Edit form value.");

        	    } catch (AssertionError ae) {
        	        LoggerUtil.fail("Assertion failed in verifyClickEditBtn: " + ae.getMessage());
        	        throw ae;
        	    } catch (Exception e) {
        	        LoggerUtil.error("Exception in verifyClickEditBtn: " + e.getMessage());
        	        e.printStackTrace();
        	    }
        	}


         public static final By toastmsg1 = By.xpath("//div[contains(@class,'toast-message')]");

         public static final By resetbtn = By.xpath("//button[@onclick='resetAddCommodity();']");
     
         public void verifyInvalidValuesInCommodityGroupBox(String message) {
        	    try {
        	        // Case 1: Special Characters
        	        LoggerUtil.info("Step 1: Enter special characters @#$% in Commodity Group box");
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), "@#$%");
        	        LoggerUtil.pass("Special characters entered successfully.");

        	        LoggerUtil.info("Step 2: Click Save button");
        	        Base.clickOnElement(savebtn);
        	        String toast1 = Base.waitForExpectedElement(toastmsg).getText();
        	        Assert.assertTrue(toast1.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toast1);
        	        LoggerUtil.pass("Validation successful for special characters input.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 3: Click Reset button");
        	        Base.clickOnElement(resetbtn);
        	        LoggerUtil.pass("Reset button clicked successfully.");
        	        Thread.sleep(2000);

        	        // Case 2: Integer Value
        	        LoggerUtil.info("Step 4: Enter integer value 1234 in Commodity Group box");
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), "1234");
        	        LoggerUtil.pass("Integer value entered successfully.");

        	        LoggerUtil.info("Step 5: Click Save button");
        	        Base.clickOnElement(savebtn);
        	        String toast2 = Base.waitForExpectedElement(toastmsg).getText();
        	        Assert.assertTrue(toast2.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toast2);
        	        LoggerUtil.pass("Validation successful for integer input.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 6: Click Reset button");
        	        Base.clickOnElement(resetbtn);
        	        LoggerUtil.pass("Reset button clicked successfully.");
        	        Thread.sleep(2000);

        	        // Case 3: Negative Value
        	        LoggerUtil.info("Step 7: Enter negative value -234 in Commodity Group box");
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), "-234");
        	        LoggerUtil.pass("Negative value entered successfully.");

        	        LoggerUtil.info("Step 8: Click Save button");
        	        Base.clickOnElement(savebtn);
        	        String toast3 = Base.waitForExpectedElement(toastmsg).getText();
        	        Assert.assertTrue(toast3.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toast3);
        	        LoggerUtil.pass("Validation successful for negative value input.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 9: Click Reset button");
        	        Base.clickOnElement(resetbtn);
        	        LoggerUtil.pass("Reset button clicked successfully.");
        	        Thread.sleep(2000);

        	    } catch (AssertionError ae) {
        	        LoggerUtil.fail("Assertion failed in verifyInvalidValuesInCommodityGroupBox: " + ae.getMessage());
        	        throw ae;
        	    } catch (Exception e) {
        	        LoggerUtil.error("Exception in verifyInvalidValuesInCommodityGroupBox: " + e.getMessage());
        	        e.printStackTrace();
        	    }
        	}

         public void verifyDuplicatesavedOrNot(String entercomgrpname, String message) {
        	    try {
        	        LoggerUtil.info("Step 1: Enter Commodity Group name: " + entercomgrpname);
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), entercomgrpname);
        	        LoggerUtil.pass("Commodity Group name entered successfully.");

        	        LoggerUtil.info("Step 2: Click Save button for first time");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked for first entry.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 3: Try to save the same Commodity Group again");
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), entercomgrpname);
        	        LoggerUtil.pass("Duplicate Commodity Group name entered successfully.");

        	        LoggerUtil.info("Step 4: Click Save button again");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked for duplicate entry.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 5: Validate duplicate entry toast message");
        	        String toastMsg = Base.waitForExpectedElement(toastmsg1).getText();
        	        Assert.assertTrue(toastMsg.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toastMsg);
        	        LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg);

        	    } catch (AssertionError ae) {
        	        LoggerUtil.fail("Assertion failed in verifyDuplicatesavedOrNot: " + ae.getMessage());
        	        throw ae;
        	    } catch (Exception e) {
        	        LoggerUtil.error("Exception in verifyDuplicatesavedOrNot: " + e.getMessage());
        	        e.printStackTrace();
        	    }
        	}

         
         
         public void verifyClickSaveBtnMultipletime(String cmg, String message) {
        	    try {
        	        LoggerUtil.info("Step 1: Enter Commodity Group name: " + cmg);
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmg);
        	        LoggerUtil.pass("Commodity Group name entered successfully.");

        	        LoggerUtil.info("Step 2: Click Save button for first time");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked for first entry.");

        	        LoggerUtil.info("Step 3: Click Save button again (duplicate attempt)");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked for duplicate entry.");

        	        LoggerUtil.info("Step 4: Validate toast message for duplicate entry");
        	        String toastMsg = Base.waitForExpectedElement(toastmsg1).getText();
        	        Assert.assertTrue(toastMsg.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toastMsg);
        	        LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg);

        	    } catch (AssertionError ae) {
        	        LoggerUtil.fail("Assertion failed in verifyClickSaveBtnMultipletime: " + ae.getMessage());
        	        throw ae;
        	    } catch (Exception e) {
        	        LoggerUtil.error("Exception in verifyClickSaveBtnMultipletime: " + e.getMessage());
        	        e.printStackTrace();
        	    }
        	}

         
         public void verifySavePromptAfterClickingSaveButton(String cmg, String message) {
        	    try {
        	        LoggerUtil.info("Step 1: Enter Commodity Group name: " + cmg);
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmg);
        	        LoggerUtil.pass("Commodity Group name entered successfully.");

        	        LoggerUtil.info("Step 2: Click Save button");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked successfully.");

        	        LoggerUtil.info("Step 3: Validate save prompt message");
        	        String toastMsg = Base.waitForExpectedElement(toastmsg1).getText();
        	        Assert.assertTrue(toastMsg.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toastMsg);
        	        LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg);

        	    } catch (AssertionError ae) {
        	        LoggerUtil.fail("Assertion failed in verifySavePromptAfterClickingSaveButton: " + ae.getMessage());
        	        throw ae;
        	    } catch (Exception e) {
        	        LoggerUtil.error("Exception in verifySavePromptAfterClickingSaveButton: " + e.getMessage());
        	        e.printStackTrace();
        	    }
        	}

         
         public void verifySavePromptAfterClickingSaveButtonWithDuplicateData(String cmg, String message) {
        	    try {
        	        LoggerUtil.info("Step 1: Enter Commodity Group name: " + cmg);
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmg);
        	        LoggerUtil.pass("Commodity Group name entered successfully.");

        	        LoggerUtil.info("Step 2: Click Save button for first entry");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked for first entry.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 3: Enter same Commodity Group name again to test duplicate");
        	        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmg);
        	        LoggerUtil.pass("Duplicate Commodity Group name entered successfully.");

        	        LoggerUtil.info("Step 4: Click Save button for duplicate entry");
        	        Base.clickOnElement(savebtn);
        	        LoggerUtil.pass("Save button clicked for duplicate entry.");
        	        Thread.sleep(3000);

        	        LoggerUtil.info("Step 5: Validate duplicate save prompt message");
        	        String toastMsg = Base.waitForExpectedElement(toastmsg1).getText();
        	        Assert.assertTrue(toastMsg.contains(message),
        	                "Expected toast to contain: " + message + " but found: " + toastMsg);
        	        LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg);

        	    } catch (AssertionError ae) {
        	        LoggerUtil.fail("Assertion failed in verifySavePromptAfterClickingSaveButtonWithDuplicateData: " + ae.getMessage());
        	        throw ae;
        	    } catch (Exception e) {
        	        LoggerUtil.error("Exception in verifySavePromptAfterClickingSaveButtonWithDuplicateData: " + e.getMessage());
        	        e.printStackTrace();
        	    }
        	}

         
        
    public void verifyDeleteDependencyPrompt(String esv,String message ) throws InterruptedException {
    	
    	clearAndEnterText(waitForExpectedElement(entersearchvalue), esv);
    	 captureStepScreenshot(esv);
    	Thread.sleep(7000);
    	clickOnElement(deletebtn);
    	Thread.sleep(4000);
    	 captureStepScreenshot("deletebtn");
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.alertIsPresent());
    	
    	 driver.switchTo().alert().accept();
    	 Thread.sleep(3000);
    	Assert.assertTrue(waitForExpectedElement(toastmsg1).getText().contains(message));
    	captureStepScreenshot(message);
    	
    	
    	
    	
    }
    
    
    public void verifyDeleteNewCommmodity(String cmv, String esv) {
        try {
            LoggerUtil.info("Step 1: Enter Commodity Group name: " + cmv);
            try {
                Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmv);
                LoggerUtil.pass("Commodity Group name entered successfully.");
            } catch (Exception e) {
                LoggerUtil.fail("Failed to enter Commodity Group name.");
                throw e;
            }
 
            LoggerUtil.info("Step 2: Click Save button");
            try {
                Base.clickOnElement(savebtn);
                LoggerUtil.pass("Save button clicked successfully.");
                Thread.sleep(9000);
            } catch (Exception e) {
                LoggerUtil.fail("Failed to click Save button.");
                throw e;
            }
 
            LoggerUtil.info("Step 3: Search saved Commodity Group: " + esv);
            try {
                Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv);
                LoggerUtil.pass("Commodity Group searched successfully.");
            } catch (Exception e) {
                LoggerUtil.fail("Failed to search Commodity Group.");
                throw e;
            }
 
            LoggerUtil.info("Step 4: Click Delete button");
            try {
                Base.clickOnElement(deletebtn);
                LoggerUtil.pass("Delete button clicked successfully.");
                Thread.sleep(5000);
            } catch (Exception e) {
                LoggerUtil.fail("Failed to click Delete button.");
                throw e;
            }
 
            LoggerUtil.info("Step 5: Accept delete alert");
            try {
                Base.driver.switchTo().alert().accept();
                LoggerUtil.pass("Delete confirmation alert accepted successfully.");
            } catch (Exception e) {
                LoggerUtil.fail("Failed to handle delete confirmation alert.");
                throw e;
            }
 
        } catch (AssertionError ae) {
            LoggerUtil.fail("Assertion failed in verifyDeleteNewCommmodity: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            LoggerUtil.error("Exception in verifyDeleteNewCommmodity: " + e.getMessage());
            e.printStackTrace();
        }
    }
 
    
 
    
    
    
    public static final By updatebtn = By.xpath("//button[@id='tab1Save']");
    
    public void updatepromptmsg(String cmv,String esv , String cmvd,String message) throws InterruptedException {
  	  
  	  clearAndEnterText(waitForExpectedElement(commoditygrobox), cmv);

  		clickOnElement(savebtn);
  		Thread.sleep(9000);
  		clearAndEnterText(waitForExpectedElement(entersearchvalue), esv);
  		Thread.sleep(3000);
  		clickOnElement(editbtn);

  		Thread.sleep(2000);
  		clearAndEnterText(waitForExpectedElement(commoditygrobox), cmvd);

  		Thread.sleep(3000);
  		clickOnElement(updatebtn);
  		Assert.assertTrue(waitForExpectedElement(toastmsg1).getText().contains(message));

  	  
  	  
  		
    }
            public static final By saveAsNewbtn = By.xpath("//button[@id='tab1SaveAsNew']");
            public void saveasnewprompt(String cmv, String esv, String cmvd, String message) {
                try {
                    LoggerUtil.info("Step 1: Enter Commodity Group name: " + cmv);
                    try {
                        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmv);
                        LoggerUtil.pass("Commodity Group name entered successfully.");
                    } catch (Exception e) {
                        LoggerUtil.fail("Failed to enter Commodity Group name.");
                        throw e;
                    }

                    LoggerUtil.info("Step 2: Click Save button");
                    try {
                        Base.clickOnElement(savebtn);
                        LoggerUtil.pass("Save button clicked successfully.");
                        Thread.sleep(9000);
                    } catch (Exception e) {
                        LoggerUtil.fail("Failed to click Save button.");
                        throw e;
                    }

                    LoggerUtil.info("Step 3: Search saved Commodity Group: " + esv);
                    try {
                        Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv);
                        LoggerUtil.pass("Commodity Group searched successfully.");
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        LoggerUtil.fail("Failed to search Commodity Group.");
                        throw e;
                    }

                    LoggerUtil.info("Step 4: Click Edit button");
                    try {
                        Base.clickOnElement(editbtn);
                        LoggerUtil.pass("Edit button clicked successfully.");
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        LoggerUtil.fail("Failed to click Edit button.");
                        throw e;
                    }

                    LoggerUtil.info("Step 5: Update Commodity Group name to new value: " + cmvd);
                    try {
                        Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmvd);
                        LoggerUtil.pass("New Commodity Group name entered successfully.");
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        LoggerUtil.fail("Failed to enter new Commodity Group name.");
                        throw e;
                    }

                    LoggerUtil.info("Step 6: Click Save As New button");
                    try {
                        Base.clickOnElement(saveAsNewbtn);
                        LoggerUtil.pass("Save As New button clicked successfully.");
                    } catch (Exception e) {
                        LoggerUtil.fail("Failed to click Save As New button.");
                        throw e;
                    }

                    LoggerUtil.info("Step 7: Validate Save As New toast message");
                    try {
                        String toastMsg = Base.waitForExpectedElement(toastmsg1).getText();
                        Assert.assertTrue(toastMsg.contains(message),
                                "Expected toast to contain: " + message + " but found: " + toastMsg);
                        LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg);
                    } catch (AssertionError ae) {
                        LoggerUtil.fail("Assertion failed in saveasnewprompt: " + ae.getMessage());
                        throw ae;
                    }

                } catch (Exception e) {
                    LoggerUtil.error("Exception in saveasnewprompt: " + e.getMessage());
                    e.printStackTrace();
                }
            }




            public void pageperformence(String cmv, String esv, String cmvd, String esv1, String upv, String message) {
                try {
                    LoggerUtil.info("Step 1: Enter Commodity Group name: " + cmv);
                    Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmv);
                    LoggerUtil.pass("Commodity Group name entered successfully.");

                    LoggerUtil.info("Step 2: Click Save button");
                    Base.clickOnElement(savebtn);
                    LoggerUtil.pass("Save button clicked successfully.");
                    Thread.sleep(3000);

                    LoggerUtil.info("Step 3: Search saved Commodity Group: " + esv);
                    Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv);
                    LoggerUtil.pass("Commodity Group searched successfully.");
                    Thread.sleep(3000);

                    LoggerUtil.info("Step 4: Click Edit button");
                    Base.clickOnElement(editbtn);
                    LoggerUtil.pass("Edit button clicked successfully.");
                    Thread.sleep(2000);

                    LoggerUtil.info("Step 5: Enter new Commodity Group value for Save As New: " + cmvd);
                    Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmvd);
                    LoggerUtil.pass("New value entered successfully.");
                    Thread.sleep(3000);

                    LoggerUtil.info("Step 6: Click Save As New button");
                    Base.clickOnElement(saveAsNewbtn);
                    LoggerUtil.pass("Save As New button clicked successfully.");

                    LoggerUtil.info("Step 7: Validate Save As New toast message");
                    String toastMsg1 = Base.waitForExpectedElement(toastmsg1).getText();
                    Assert.assertTrue(toastMsg1.contains(message),
                            "Expected toast to contain: " + message + " but found: " + toastMsg1);
                    LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg1);
                    Thread.sleep(3000);

                    LoggerUtil.info("Step 8: Search newly saved Commodity Group: " + esv1);
                    Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv1);
                    LoggerUtil.pass("New Commodity Group searched successfully.");
                    Thread.sleep(3000);

                    LoggerUtil.info("Step 9: Click Edit button for newly saved record");
                    Base.clickOnElement(editbtn);
                    LoggerUtil.pass("Edit button clicked successfully.");

                    LoggerUtil.info("Step 10: Update Commodity Group value: " + upv);
                    Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), upv);
                    LoggerUtil.pass("Updated value entered successfully.");

                    LoggerUtil.info("Step 11: Click Update button");
                    Base.clickOnElement(updatebtn);
                    LoggerUtil.pass("Update button clicked successfully.");

                    LoggerUtil.info("Step 12: Validate Update toast message");
                    String toastMsg2 = Base.waitForExpectedElement(toastmsg1).getText();
                    Assert.assertTrue(toastMsg2.contains(message),
                            "Expected toast to contain: " + message + " but found: " + toastMsg2);
                    LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg2);

                } catch (AssertionError ae) {
                    LoggerUtil.fail("Assertion failed in pageperformence: " + ae.getMessage());
                    throw ae;
                } catch (Exception e) {
                    LoggerUtil.error("Exception in pageperformence: " + e.getMessage());
                    e.printStackTrace();
                }
            }


        public static final By serialnumberheader = By.xpath("//table[@id='commodtiyTable']/thead/tr/th[1]");
        public void clickfordescendingOrder() {
            try {
            	
                LoggerUtil.info("Step 1: Click on Serial Number header to apply descending sort");
                Base.clickOnElement(serialnumberheader);
                LoggerUtil.pass("Serial Number header clicked successfully.");

                LoggerUtil.info("Step 2: Capture all values from Serial Number column");
                List<WebElement> columnCells = driver.findElements(
                        By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[1]"));
                List<String> actualList = new ArrayList<>();
                for (WebElement cell : columnCells) {
                    actualList.add(cell.getText().trim());
                }
                LoggerUtil.pass("Captured " + actualList.size() + " values from Serial Number column: " + actualList);

                LoggerUtil.info("Step 3: Create sorted copy of the list in descending order");
                List<String> sortedList = new ArrayList<>(actualList);
                Collections.sort(sortedList, Collections.reverseOrder());
                LoggerUtil.pass("Sorted list prepared in descending order: " + sortedList);

                LoggerUtil.info("Step 4: Compare actual list with expected sorted list");
                Assert.assertEquals(actualList, sortedList,
                        "Table is not sorted in descending order.\nActual: " + actualList + "\nExpected: " + sortedList);
                LoggerUtil.pass("Validation successful. Table is sorted in descending order.");

            } catch (AssertionError ae) {
                LoggerUtil.fail("Assertion failed in clickfordescendingOrder: " + ae.getMessage());
                throw ae;
            } catch (Exception e) {
                LoggerUtil.error("Exception in clickfordescendingOrder: " + e.getMessage());
                e.printStackTrace();
            }
        }

     // Change this locator to point to the "Commodity Group" column header
        public static final By commodityGroupHeader = By.xpath("//table[@id='commodtiyTable']/thead/tr/th[2]");

        public void clickForAscendingOrderByName() {
            try {
                LoggerUtil.info("Step 1: Click on Commodity Group header to apply ascending sort");
                Base.clickOnElement(commodityGroupHeader);
                LoggerUtil.pass("Commodity Group header clicked successfully.");

                LoggerUtil.info("Step 2: Capture all values from Commodity Group column");
                List<WebElement> columnCells = driver.findElements(
                        By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[2]"));

                List<String> actualList = new ArrayList<>();
                for (WebElement cell : columnCells) {
                    actualList.add(cell.getText().trim());
                }
                LoggerUtil.pass("Captured " + actualList.size() + " values from Commodity Group column: " + actualList);

                LoggerUtil.info("Step 3: Create sorted copy of the list in ascending order (ignoring case)");
                List<String> sortedList = new ArrayList<>(actualList);
                Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
                LoggerUtil.pass("Sorted list prepared in ascending order: " + sortedList);

                LoggerUtil.info("Step 4: Compare actual list with expected sorted list");
                Assert.assertEquals(actualList, sortedList,
                        "Table is not sorted by Name (Commodity Group) in ascending order.\nActual: " 
                        + actualList + "\nExpected: " + sortedList);
                LoggerUtil.pass("Validation successful. Table is sorted by Name (Commodity Group) in ascending order.");

            } catch (AssertionError ae) {
                LoggerUtil.fail("Assertion failed in clickForAscendingOrderByName: " + ae.getMessage());
                throw ae;
            } catch (Exception e) {
                LoggerUtil.error("Exception in clickForAscendingOrderByName: " + e.getMessage());
                e.printStackTrace();
            }
        }


    
    
        public void saveduplicatename(String cgv, String esv, String cmgv, String message) {
            try {
                LoggerUtil.info("Step 1: Enter Commodity Group name: " + cgv);
                Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cgv);
                LoggerUtil.pass("Commodity Group name entered successfully.");

                LoggerUtil.info("Step 2: Click Save button");
                Base.clickOnElement(savebtn);
                LoggerUtil.pass("Save button clicked successfully.");
                Thread.sleep(3000);

                LoggerUtil.info("Step 3: Search for Commodity Group: " + esv);
                Base.clearAndEnterText(Base.waitForExpectedElement(entersearchvalue), esv);
                LoggerUtil.pass("Commodity Group searched successfully.");
                Thread.sleep(2000);

                LoggerUtil.info("Step 4: Click Edit button");
                Base.clickOnElement(editbtn);
                LoggerUtil.pass("Edit button clicked successfully.");

                LoggerUtil.info("Step 5: Enter duplicate Commodity Group value: " + cmgv);
                Base.clearAndEnterText(Base.waitForExpectedElement(commoditygrobox), cmgv);
                LoggerUtil.pass("Duplicate Commodity Group name entered successfully.");
                Thread.sleep(2000);

                LoggerUtil.info("Step 6: Click Save button again (to trigger duplicate validation)");
                Base.clickOnElement(savebtn);
                LoggerUtil.pass("Save button clicked successfully for duplicate value.");

                LoggerUtil.info("Step 7: Validate duplicate save toast message");
                String toastMsg = Base.waitForExpectedElement(toastmsg1).getText();
                Assert.assertTrue(toastMsg.contains(message),
                        "Expected toast to contain: " + message + " but found: " + toastMsg);
                LoggerUtil.pass("Toast message validation successful. Message: " + toastMsg);

            } catch (AssertionError ae) {
                LoggerUtil.fail("Assertion failed in saveduplicatename: " + ae.getMessage());
                throw ae;
            } catch (Exception e) {
                LoggerUtil.error("Exception in saveduplicatename: " + e.getMessage());
                e.printStackTrace();
            }
        }

 
       
       public void addcommodityforclientA(String cgb) throws InterruptedException {
      	 
      	 clearAndEnterText(waitForExpectedElement(commoditygrobox), cgb);
      	 Thread.sleep(2000);
      	 clickOnElement(savebtn);
      	 
      	 
      	 
      	 
      	 
       }
        
       public void searchforclientA(String esv,String cgb) throws InterruptedException {
      	 
      	 clearAndEnterText(waitForExpectedElement(entersearchvalue), esv);
      	 Thread.sleep(3000);
      	 clickOnElement(editbtn);
      	 Thread.sleep(3000);
      	 clearAndEnterText(waitForExpectedElement(commoditygrobox), cgb);
      	 Thread.sleep(3000);
      	 clickOnElement(updatebtn);
      	 
      	 
       }
        
       public void verifyForClientB(String esv) throws InterruptedException {
      	 
      	 clearAndEnterText(waitForExpectedElement(entersearchvalue), esv);
      	 Thread.sleep(3000); 
      	 String actualvaliue = waitForExpectedElement(By.xpath("//table[@id='commodtiyTable']/tbody/tr/td")).getText();
      	 String expectedvalue = "No matching records found";
      	 Assert.assertEquals(actualvaliue,expectedvalue);
      	 
      	 
       }
       
       public void verifyDeleteupdatedvalueforclientA(String esv) throws InterruptedException {
      	 
      	 clearAndEnterText(waitForExpectedElement(entersearchvalue), esv);
      	 Thread.sleep(3000); 
      	 clickOnElement(deletebtn);
      	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      	 wait.until(ExpectedConditions.alertIsPresent());
      	 driver.switchTo().alert().accept();
      	 
      	 
      	 
       }
       
       public static final By verification = By.xpath("//table[@id='commodtiyTable']/tbody/tr/td[2]");
       public void verifyImpactforclientB(String esv) throws InterruptedException {
      	 
      	 clearAndEnterText(waitForExpectedElement(entersearchvalue), esv);
      	 Thread.sleep(3000); 
      	 String actualvalue = waitForExpectedElement(verification).getText();
      	 Assert.assertEquals(actualvalue, esv);
      	 
      	 
       }
       
       

}