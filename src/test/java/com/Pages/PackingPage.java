package com.Pages;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.helper.Base;
import com.helper.LoggerUtil;

public class PackingPage extends Base {

	public static final By clickikngcategorydropdown = By.xpath("//span[@id='select2-cat111-container']");

	public static final By categorydroplist = By.xpath("//ul[@id='select2-cat111-results']/li");

	public static final By entertype = By.xpath("//input[@id='matType']");

	public static final By enterfactorname = By.xpath("//input[@id='FactorText']");

	public static final By savebutton = By.xpath("//button[@id='tabpackSave']");
	public static final By deletebtn = By.xpath("//*[@id='PackingTable']/tbody/tr[1]/td[5]/a[2]/i");
	public static final By clickeditbtn = By.xpath("//*[@id=\"PackingTable\"]/tbody/tr[1]/td[5]/a[1]/i");
	public static final By entersearchvalue = By.xpath("//*[@id='PackingTable_filter']//input[@type='search']");
	public static final By fetchingdatacategorycolom = By.xpath("//table[@id='PackingTable']/tbody/tr/td[2]");
	public static final By fettchingdatatypecolom = By.xpath("//table[@id='PackingTable']/tbody/tr/td[3]");
	public static final By toastmsg = By.xpath("//*[@id='toast-container']/div/div[2]");
	public static final By saveasnewbtn = By.xpath("//button[@id='tabpackSaveasnew']");

	public void savepackingdata(String entervaluefortype, String enterfacvalue) throws InterruptedException {
	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Packing Category save flow...");

	        clickOnElement(clickikngcategorydropdown);
	        LoggerUtil.info("Clicked on Category dropdown");
	        Thread.sleep(3000);

	        List<WebElement> categorylist = driver.findElements(categorydroplist);
	        selectBootStrapDropDown(categorylist, "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type value: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor value: " + enterfacvalue);

	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked on Save button");

	         Thread.sleep(5000);
	        // ✅ Toast handling in safe try-catch
	        try {
	            List<WebElement> toastList = driver.findElements(toastmsg);
	            if (!toastList.isEmpty()) {
	                String actualsavedmsg = toastList.get(0).getText().trim();
	                String expectedsavedmsg = "Packing category Group successful saved.";
	                soft.assertEquals(actualsavedmsg, expectedsavedmsg);
	                LoggerUtil.pass("Save Toast displayed: " + actualsavedmsg);
	            } else {
	                LoggerUtil.error("Save Toast not found after clicking Save");
	                
	            }
	        } catch (Exception e) {
	            LoggerUtil.error("Error while checking Save Toast: " + e.getMessage());
	            
	        }

	        Thread.sleep(5000);
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        LoggerUtil.info("Searched for saved Type: " + entervaluefortype);

	        String expectedCategoryData = "Ply";
	        String actualCategoryData = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String expectedValueForType = entervaluefortype;
	        String actualValueForType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        if (expectedCategoryData.equals(actualCategoryData) && expectedValueForType.equals(actualValueForType)) {
	            LoggerUtil.pass("Saved data verified in table → Category: " + actualCategoryData + " | Type: " + actualValueForType);

	            Thread.sleep(5000);
	            clickOnElement(deletebtn);
	            driver.switchTo().alert().accept();
	            LoggerUtil.info("Clicked Delete and accepted alert");

	            // ✅ Toast check for delete
	            try {
	                List<WebElement> toastList = driver.findElements(toastmsg);
	                if (!toastList.isEmpty()) {
	                    String actualdeletemsg = toastList.get(0).getText().trim();
	                    String expecteddeletemsg = "Packing category successfully deleted.";
	                    soft.assertEquals(actualdeletemsg, expecteddeletemsg);
	                    LoggerUtil.pass("Delete Toast displayed: " + actualdeletemsg);
	                } else {
	                    LoggerUtil.error("Delete Toast not found after deletion");
	                   
	                }
	            } catch (Exception e) {
	                LoggerUtil.error("Error while checking Delete Toast: " + e.getMessage());
	             
	            }

	            soft.assertAll();
	        } else {
	            LoggerUtil.error("Mismatch in saved data → Expected: " 
	                    + expectedCategoryData + " | " + expectedValueForType 
	                    + " but Found: " + actualCategoryData + " | " + actualValueForType);
	           
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savepackingdata flow: " + e.getMessage());
	       
	        throw e;
	    }
	}

	public void verifysaveasnew(
	        String entervaluefortype,
	        String enterfacvalue,
	        String message,
	        String enternewvaluefortype,
	        String deleteMessageExpected) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        // Step 1: Select category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type & Factor, then Save
	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type value: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor value: " + enterfacvalue);

	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button");
	        Thread.sleep(6000);

	        // Step 3: Validate saved data in grid
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        Thread.sleep(3000);
	        String actualCategory = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String actualType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        if ("Ply".equals(actualCategory) && entervaluefortype.equals(actualType)) {
	            clickOnElement(clickeditbtn);
	            LoggerUtil.info("Clicked Edit button successfully");
	        } else {
	            LoggerUtil.mismatch("Grid Data Mismatch After Save",
	                    "Expected: Category='Ply', Type='" + entervaluefortype + "'",
	                    "Actual: Category='" + actualCategory + "', Type='" + actualType + "'");
	            soft.fail("Save validation failed.");
	        }

	        // Step 4: Change category to "Flute" and Save As New
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(5000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Flute");
	        LoggerUtil.info("Changed Category to: Flute");

	        clearAndEnterText(waitForExpectedElement(entertype), enternewvaluefortype);
	        LoggerUtil.info("Entered new Type value: " + enternewvaluefortype);

	        clickOnElement(saveasnewbtn);
	        LoggerUtil.info("Clicked Save As New button");

	        Thread.sleep(5000);
	        // ✅ Safe toast check
	        String actualSaveToast = "";
	        List<WebElement> saveToastList = driver.findElements(toastmsg);
	        if (!saveToastList.isEmpty()) {
	            actualSaveToast = saveToastList.get(0).getText().trim();
	            if (actualSaveToast.contains(message)) {
	                LoggerUtil.pass("Save As New Toast displayed: " + actualSaveToast);
	            } else {
	                LoggerUtil.mismatch("Save As New Toast Mismatch", message, actualSaveToast);
	                soft.fail("Save As New toast validation failed.");
	            }
	        } else {
	            LoggerUtil.error("Save As New Toast not found");
	            soft.fail("Save As New toast missing.");
	        }

	        Thread.sleep(6000);
	        // Step 5: Validate "Save As New" data
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), enternewvaluefortype);
	        Thread.sleep(3000);
	        String actualCategoryNew = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String actualTypeNew = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        if ("Flute".equals(actualCategoryNew) && enternewvaluefortype.equals(actualTypeNew)) {
	            LoggerUtil.pass("Save As New data verified: Category='Flute', Type='" + actualTypeNew + "'");
	        } else {
	            LoggerUtil.mismatch("Grid Data Mismatch After Save As New",
	                    "Expected: Category='Flute', Type='" + enternewvaluefortype + "'",
	                    "Actual: Category='" + actualCategoryNew + "', Type='" + actualTypeNew + "'");
	            soft.fail("Save As New grid validation failed.");
	        }

	        Thread.sleep(5000);
	        // Step 6: Delete the Save As New entry and validate toast
	        clickOnElement(deletebtn);
	        driver.switchTo().alert().accept();
	        LoggerUtil.info("Clicked Delete and accepted alert");
	        Thread.sleep(2000);

	        String deleteMsg = "";
	        List<WebElement> deleteToastList = driver.findElements(toastmsg);
	        if (!deleteToastList.isEmpty()) {
	            deleteMsg = deleteToastList.get(0).getText().trim();
	            if (deleteMsg.contains(deleteMessageExpected)) {
	                LoggerUtil.pass("Delete Toast displayed: " + deleteMsg);
	            } else {
	                LoggerUtil.mismatch("Delete Toast Mismatch", deleteMessageExpected, deleteMsg);
	                soft.fail("Delete toast validation failed.");
	            }
	        } else {
	            LoggerUtil.error("Delete Toast not found");
	            soft.fail("Delete toast missing.");
	        }

	        // ✅ Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifysaveasnew flow: " + e.getMessage());
	        throw e;
	    }
	}

	public void updatevalue(
	        String entervaluefortype,
	        String enterfacvalue,
	        String enternewvaluefortype,
	        String expectedToastMessage,
	        String enterpriviousvalue) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        // Step 1: Select "Ply" category and create an entry
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor: " + enterfacvalue);

	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button");
	        Thread.sleep(3000);

	        // Step 2: Validate saved entry appears in grid
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        Thread.sleep(3000);
	        String actualCategory = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String actualType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        if ("Ply".equals(actualCategory) && entervaluefortype.equals(actualType)) {
	            clickOnElement(clickeditbtn);
	            LoggerUtil.info("Clicked Edit button successfully...");
	        } else {
	            LoggerUtil.mismatch("Initial Save Mismatch",
	                    "Expected Category='Ply', Type='" + entervaluefortype + "'",
	                    "Actual Category='" + actualCategory + "', Type='" + actualType + "'");
	            soft.fail("Initial save data mismatch.");
	        }

	        // Step 3: Update the entry - change category to Flute and update Type
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(2000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Flute");
	        LoggerUtil.info("Changed Category to: Flute");

	        clearAndEnterText(waitForExpectedElement(entertype), enternewvaluefortype);
	        LoggerUtil.info("Updated Type value: " + enternewvaluefortype);

	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button for Update");
	        Thread.sleep(5000);

	        // ✅ Toast handling with findElements (safe)
	        List<WebElement> updateToastList = driver.findElements(toastmsg);
	        if (!updateToastList.isEmpty()) {
	            String actualUpdateToast = updateToastList.get(0).getText().trim();
	            if (actualUpdateToast.contains(expectedToastMessage)) {
	                LoggerUtil.pass("Update Toast matched: " + actualUpdateToast);
	            } else {
	                LoggerUtil.mismatch("Update Toast Mismatch", expectedToastMessage, actualUpdateToast);
	                soft.fail("Update toast validation failed.");
	            }
	        } else {
	            LoggerUtil.error("Update Toast not found after clicking Save");
	            soft.fail("Update toast missing.");
	        }

	        // Step 4: Verify updated record in grid
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), enternewvaluefortype);
	        Thread.sleep(3000);
	        String actualUpdatedCategory = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String actualUpdatedType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        Thread.sleep(5000);
	        if ("Flute".equals(actualUpdatedCategory) && enternewvaluefortype.equals(actualUpdatedType)) {
	            LoggerUtil.pass("Updated record verified in grid → Category='Flute', Type='" + actualUpdatedType + "'");
	            clickOnElement(deletebtn);
	            driver.switchTo().alert().accept();
	            LoggerUtil.info("Clicked Delete and confirmed alert");
	        } else {
	            LoggerUtil.mismatch("Updated Grid Mismatch",
	                    "Expected Category='Flute', Type='" + enternewvaluefortype + "'",
	                    "Actual Category='" + actualUpdatedCategory + "', Type='" + actualUpdatedType + "'");
	            soft.fail("Grid mismatch after update.");
	        }

	        // Step 5: Validate previous value is not present
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), enterpriviousvalue);
	        Thread.sleep(2000);
	        String actualvalue = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        Thread.sleep(3000);
	        if (enterpriviousvalue.equals(actualvalue)) {
	            LoggerUtil.error("Previous value still exists after update: " + actualvalue);
	            soft.fail("Previous value should not exist after update.");
	        } else {
	            LoggerUtil.pass("Previous value not found. Update applied correctly.");
	        }

	        // ✅ Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in updatevalue flow: " + e.getMessage());
	        throw e;
	    }
	}


	public static final By nextbtn = By.xpath("//li[@id='PackingTable_next']/a");
	public static final By nextContainer = By.xpath("//li[@id='PackingTable_next']");
	public static final By currentpagerow = By.xpath("//table[@id='PackingTable']/tbody/tr");
	public static final By pagerowafterclickingnextbtn = By.xpath("//table[@id='PackingTable']/tbody/tr");

	public void pagination() {
	    int totalRowCounter = 0;

	    try {
	        LoggerUtil.info("Starting pagination validation...");

	        for (int page = 1;; page++) {
	            List<WebElement> currentPageRows = driver.findElements(currentpagerow);
	            int rowCount = currentPageRows.size();

	            LoggerUtil.info("Page " + page + " contains " + rowCount + " rows.");

	            for (int i = 1; i <= rowCount; i++) {
	                totalRowCounter++;
	                LoggerUtil.info("Row " + totalRowCounter + " processed successfully.");
	            }

	            WebElement next = driver.findElement(nextContainer);
	            String classValue = next.getAttribute("class");

	            if (classValue.contains("disabled")) {
	                LoggerUtil.info("Reached last page → Pagination completed. Total rows processed: " + totalRowCounter);
	                break;
	            }

	            int previousCount = rowCount;
	            LoggerUtil.info("Moving to next page: " + (page + 1));
	            clickOnElement(nextbtn);

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(driver -> driver.findElements(currentpagerow).size() != previousCount);
	        }

	        LoggerUtil.pass("Pagination validated successfully. Total rows: " + totalRowCounter);

	    } catch (Exception e) {
	        LoggerUtil.error("Error occurred during pagination: " + e.getMessage());
	        throw e;
	    }
	}


	public static final By validatetotalcountnumber = By.xpath("//select[@name='PackingTable_length']");
	public static final By valuescounttable = By.xpath("//select[@name='PackingTable_length']/option");

	public void countingpagelength() throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting Page Length validation...");

	        // Step 1: Open dropdown for page length
	        clickOnElement(validatetotalcountnumber);
	        LoggerUtil.info("Clicked on page length dropdown");
	        Thread.sleep(2000);

	        // Step 2: Select "25" from dropdown
	        List<WebElement> countingvalues = driver.findElements(valuescounttable);
	        selectBootStrapDropDown(countingvalues, "25");
	        LoggerUtil.info("Selected page length: 25");

	        // Step 3: Count rows in current page
	        List<WebElement> currentPageRows = driver.findElements(currentpagerow);
	        int totalrows = currentPageRows.size();
	        LoggerUtil.info("Total rows fetched in current page: " + totalrows);

	        // Step 4: Validate row count matches expected page length
	        if (totalrows == 25) {
	            LoggerUtil.pass("Page length validation passed → Found 25 rows in current page.");
	        } else {
	            LoggerUtil.error("Page length validation failed → Expected 25 rows but found " + totalrows);
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in countingpagelength: " + e.getMessage());
	        throw e;
	    }
	}


	public void verifyclickeditbtnandloadcorrectly(String entervaluefortype, String enterfacvalue)
	        throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        // Step 1: Create entry with category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor: " + enterfacvalue);

	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button");
	        Thread.sleep(4000);

	        // Step 2: Validate saved entry in grid
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        Thread.sleep(4000);
	        String actualCategory = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String actualType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        if ("Ply".equals(actualCategory) && entervaluefortype.equals(actualType)) {
	            clickOnElement(clickeditbtn);
	            LoggerUtil.info("Clicked Edit button successfully");
	        } else {
	            LoggerUtil.mismatch("Grid Data Mismatch After Save",
	                    "Expected: Category='Ply', Type='" + entervaluefortype + "'",
	                    "Actual: Category='" + actualCategory + "', Type='" + actualType + "'");
	            soft.fail("Save validation failed.");
	        }

	        // Step 3: Validate loaded values after Edit
	        Thread.sleep(5000);
	        String actualCategoryDropdown = waitForExpectedElement(clickikngcategorydropdown).getText().trim();
	        String expectedCategoryDropdown = "Ply";

	        String actualTypeName = waitForExpectedElement(entertype).getAttribute("value").trim();
	        String expectedTypeName = entervaluefortype;

	        String actualFactorRaw = waitForExpectedElement(enterfactorname).getAttribute("value").trim();
	        entervaluefortype.trim();

	        BigDecimal actualFactor = new BigDecimal(actualFactorRaw).stripTrailingZeros();
	        BigDecimal expectedFactor = new BigDecimal(enterfacvalue.trim()).stripTrailingZeros();

	        LoggerUtil.info("Edit Form Loaded Values → Category: " + actualCategoryDropdown
	                + " | Type: " + actualTypeName
	                + " | Factor: " + actualFactor);

	        if (actualCategoryDropdown.equals(expectedCategoryDropdown)
	                && actualTypeName.equals(expectedTypeName)
	                && actualFactor.compareTo(expectedFactor) == 0) {

	            LoggerUtil.pass("After clicking Edit, values loaded correctly → "
	                    + "Category='" + expectedCategoryDropdown
	                    + "', Type='" + expectedTypeName
	                    + "', Factor='" + expectedFactor + "'");

	            clickOnElement(deletebtn);
	            driver.switchTo().alert().accept();
	            LoggerUtil.info("Record deleted successfully after validation.");

	        } else {
	            LoggerUtil.mismatch("Edit Form Values Mismatch",
	                    "Expected: Category='" + expectedCategoryDropdown
	                            + "', Type='" + expectedTypeName
	                            + "', Factor='" + expectedFactor + "'",
	                    "Actual: Category='" + actualCategoryDropdown
	                            + "', Type='" + actualTypeName
	                            + "', Factor='" + actualFactor + "'");
	            soft.fail("Edit load validation failed.");
	        }

	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifyclickeditbtnandloadcorrectly: " + e.getMessage());
	        throw e;
	    }
	}


	public void enteralphabeticandnumericinfactorcolom(String entervaluefortype, String enterfacvalue)
	        throws InterruptedException {

	    try {
	        LoggerUtil.info("Starting validation for alphabetic/numeric entry in Factor column...");

	        // Step 1: Select category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type value
	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type value: " + entervaluefortype);

	        // Step 3: Enter Factor value (invalid input)
	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor value: " + enterfacvalue);

	        // Step 4: Try saving
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button with invalid Factor input");

	        // Step 5: Validate Toast Message
	        String expectedToast = "Please Enter Factor";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            LoggerUtil.info("Toast displayed: " + actualToast);

	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Validation passed → Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Factor Toast Mismatch", expectedToast, actualToast);
	                Assert.fail("Incorrect toast displayed for invalid Factor input.");
	            }
	        } else {
	            LoggerUtil.error("Toast not displayed after invalid Factor input.");
	            Assert.fail("Toast missing after invalid Factor input.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in enteralphabeticandnumericinfactorcolom: " + e.getMessage());
	        throw e;
	    }
	}


	public void verifymandatoryfield(String entertypevalue, String enterfactornamevalue) throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting mandatory field validation for Category...");

	        // Step 1: Enter Type and Factor without selecting Category
	        clearAndEnterText(waitForExpectedElement(entertype), entertypevalue);
	        LoggerUtil.info("Entered Type: " + entertypevalue);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfactornamevalue);
	        LoggerUtil.info("Entered Factor: " + enterfactornamevalue);

	        // Step 2: Click Save
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save without selecting Category");

	        // Step 3: Validate toast message
	        String expectedToast = "Please select a valid category.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            LoggerUtil.info("Toast displayed: " + actualToast);

	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Mandatory field validation passed → Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Mandatory Field Toast Mismatch", expectedToast, actualToast);
	                Assert.fail("Incorrect toast displayed for missing Category.");
	            }
	        } else {
	            LoggerUtil.error("No toast displayed when Category was missing.");
	            Assert.fail("Toast missing for mandatory Category field.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifymandatoryfield: " + e.getMessage());
	        throw e;
	    }
	}


	public void verifymandatoryfieldforwithouttype(String enterfactornamevalue) throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting mandatory field validation for missing Type...");

	        // Step 1: Select Category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Factor but leave Type blank
	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfactornamevalue);
	        LoggerUtil.info("Entered Factor: " + enterfactornamevalue);

	        // Step 3: Click Save
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save without entering Type");

	        // Step 4: Validate toast message
	        String expectedToast = "Please Enter Type";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            LoggerUtil.info("Toast displayed: " + actualToast);

	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Mandatory field validation passed → Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Mandatory Field Toast Mismatch", expectedToast, actualToast);
	                Assert.fail("Incorrect toast displayed for missing Type.");
	            }
	        } else {
	            LoggerUtil.error("No toast displayed when Type was missing.");
	            Assert.fail("Toast missing for mandatory Type field.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifymandatoryfieldforwithouttype: " + e.getMessage());
	        throw e;
	    }
	}


	public void verifymandatoryfieldforwithoutfactor(String entertypevalue) throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting mandatory field validation for missing Factor...");

	        // Step 1: Select Category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type but leave Factor blank
	        clearAndEnterText(waitForExpectedElement(entertype), entertypevalue);
	        LoggerUtil.info("Entered Type: " + entertypevalue);

	        // Step 3: Click Save
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save without entering Factor");

	        // Step 4: Validate toast message
	        String expectedToast = "Please Enter Factor";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            LoggerUtil.info("Toast displayed: " + actualToast);

	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Mandatory field validation passed → Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Mandatory Field Toast Mismatch", expectedToast, actualToast);
	                Assert.fail("Incorrect toast displayed for missing Factor.");
	            }
	        } else {
	            LoggerUtil.error("No toast displayed when Factor was missing.");
	            Assert.fail("Toast missing for mandatory Factor field.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifymandatoryfieldforwithoutfactor: " + e.getMessage());
	        throw e;
	    }
	}


	public void verifyduplicateprompt(String entervaluefortype, String enterfacvalue) throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting duplicate entry validation...");

	        // Step 1: Select Category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type & Factor
	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor: " + enterfacvalue);

	        // Step 3: Save entry
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button for first entry");
	        Thread.sleep(4000);

	        // Step 4: Search and Edit same entry
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        Thread.sleep(2000);
	        clickOnElement(clickeditbtn);
	        LoggerUtil.info("Clicked Edit button on saved entry");

	        // Step 5: Try saving duplicate
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button again to trigger duplicate prompt");

	        // Step 6: Validate duplicate toast
	        String expectedToast = "Packing category Group already saved";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            LoggerUtil.info("Toast displayed: " + actualToast);

	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Duplicate prompt validation passed → Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Duplicate Prompt Mismatch", expectedToast, actualToast);
	                Assert.fail("Incorrect toast displayed for duplicate entry.");
	            }
	        } else {
	            LoggerUtil.error("No toast displayed for duplicate entry attempt.");
	            Assert.fail("Toast missing for duplicate entry validation.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifyduplicateprompt: " + e.getMessage());
	        throw e;
	    }
	}


	public static final By resetbtn = By.xpath("(//button[@id='btnrest'])[2]");

	public void verifyresetbutton(String entervaluefortype, String enterfacvalue) throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting Reset Button validation...");

	        // Step 1: Select Category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type & Factor
	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor: " + enterfacvalue);

	        // Step 3: Save entry
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button");
	        Thread.sleep(4000);

	        // Step 4: Search & Edit the entry
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        Thread.sleep(2000);
	        clickOnElement(clickeditbtn);
	        LoggerUtil.info("Clicked Edit button");

	        // Step 5: Click Reset
	        clickOnElement(resetbtn);
	        LoggerUtil.info("Clicked Reset button");
	        Thread.sleep(3000);

	        // Step 6: Validate all fields cleared
	        String categorydrop = waitForExpectedElement(clickikngcategorydropdown).getText().trim();
	        String entertypebox = waitForExpectedElement(entertype).getAttribute("value").trim();
	        String enterfactortypebox = waitForExpectedElement(enterfactorname).getAttribute("value").trim();

	        if (categorydrop.isEmpty() && entertypebox.isEmpty() && enterfactortypebox.isEmpty()) {
	            LoggerUtil.pass("Reset Button validation passed → All fields cleared successfully.");
	        } else {
	            LoggerUtil.mismatch("Reset Button validation failed",
	                    "Expected: All fields empty",
	                    "Actual: Category='" + categorydrop + "', Type='" + entertypebox + "', Factor='" + enterfactortypebox + "'");
	            Assert.fail("Reset button did not clear all fields.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifyresetbutton: " + e.getMessage());
	        throw e;
	    }
	}


	public void savepackingdataforclientA(String entervaluefortype, String enterfacvalue) throws InterruptedException {
	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Save Packing Data flow for Client A...");

	        // Step 1: Select Category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type & Factor
	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor: " + enterfacvalue);

	        // Step 3: Save
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button");
	        Thread.sleep(3000);

	        // Step 4: Search the saved record
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        LoggerUtil.info("Searched for saved Type: " + entervaluefortype);
	        Thread.sleep(2000);

	        // Step 5: Validate saved data
	        String expectedCategoryData = "Ply";
	        String actualCategoryData = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();

	        String expectedValueForType = entervaluefortype;
	        String actualValueForType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        soft.assertEquals(actualCategoryData, expectedCategoryData, "Category mismatch!");
	        soft.assertEquals(actualValueForType, expectedValueForType, "Type mismatch!");

	        if (expectedCategoryData.equals(actualCategoryData) && expectedValueForType.equals(actualValueForType)) {
	            LoggerUtil.pass("Save validation passed → Category: " + actualCategoryData + " | Type: " + actualValueForType);
	        } else {
	            LoggerUtil.mismatch("Save validation failed",
	                    "Expected: Category='" + expectedCategoryData + "', Type='" + expectedValueForType + "'",
	                    "Actual: Category='" + actualCategoryData + "', Type='" + actualValueForType + "'");
	        }

	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savepackingdataforclientA: " + e.getMessage());
	        throw e;
	    }
	}


	public void savepackingdataforclientB(String entervaluefortype, String enterfacvalue) throws InterruptedException {
	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Save Packing Data flow for Client B...");

	        // Step 1: Select Category "Ply"
	        clickOnElement(clickikngcategorydropdown);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(categorydroplist), "Ply");
	        LoggerUtil.info("Selected Category: Ply");

	        // Step 2: Enter Type & Factor
	        clearAndEnterText(waitForExpectedElement(entertype), entervaluefortype);
	        LoggerUtil.info("Entered Type: " + entervaluefortype);

	        clearAndEnterText(waitForExpectedElement(enterfactorname), enterfacvalue);
	        LoggerUtil.info("Entered Factor: " + enterfacvalue);

	        // Step 3: Save
	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button");
	        Thread.sleep(3000);

	        // Step 4: Search the saved record
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        LoggerUtil.info("Searched for saved Type: " + entervaluefortype);
	        Thread.sleep(2000);

	        // Step 5: Validate saved data
	        String expectedCategoryData = "Ply";
	        String actualCategoryData = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();

	        String expectedValueForType = entervaluefortype;
	        String actualValueForType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        soft.assertEquals(actualCategoryData, expectedCategoryData, "Category mismatch!");
	        soft.assertEquals(actualValueForType, expectedValueForType, "Type mismatch!");

	        if (expectedCategoryData.equals(actualCategoryData) && expectedValueForType.equals(actualValueForType)) {
	            LoggerUtil.pass("Save validation passed → Category: " + actualCategoryData + " | Type: " + actualValueForType);
	        } else {
	            LoggerUtil.mismatch("Save validation failed",
	                    "Expected: Category='" + expectedCategoryData + "', Type='" + expectedValueForType + "'",
	                    "Actual: Category='" + actualCategoryData + "', Type='" + actualValueForType + "'");
	        }

	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savepackingdataforclientB: " + e.getMessage());
	        throw e;
	    }
	}

	public void editinclientA(String entervaluefortype, String enterupdatetypevalue) throws InterruptedException {
	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Edit validation for Client A...");

	        // Step 1: Search the existing entry
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), entervaluefortype);
	        LoggerUtil.info("Searched for entry: " + entervaluefortype);
	        Thread.sleep(2000);

	        // Step 2: Validate existing record
	        String expectedCategory = "Ply";
	        String actualCategory = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String expectedType = entervaluefortype;
	        String actualType = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        soft.assertEquals(actualCategory, expectedCategory, "Category mismatch before edit!");
	        soft.assertEquals(actualType, expectedType, "Type mismatch before edit!");

	        if (expectedCategory.equals(actualCategory) && expectedType.equals(actualType)) {
	            LoggerUtil.info("Existing entry verified → Category: " + actualCategory + " | Type: " + actualType);
	        } else {
	            LoggerUtil.mismatch("Existing entry mismatch before edit",
	                    "Expected: Category='" + expectedCategory + "', Type='" + expectedType + "'",
	                    "Actual: Category='" + actualCategory + "', Type='" + actualType + "'");
	        }

	        // Step 3: Edit entry
	        clickOnElement(clickeditbtn);
	        LoggerUtil.info("Clicked Edit button");
	        Thread.sleep(2000);

	        clearAndEnterText(waitForExpectedElement(entertype), enterupdatetypevalue);
	        LoggerUtil.info("Updated Type value: " + enterupdatetypevalue);

	        clickOnElement(savebutton);
	        LoggerUtil.info("Clicked Save button after edit");
	        Thread.sleep(3000);

	        // Step 4: Verify updated record
	        clearAndEnterText(waitForExpectedElement(entersearchvalue), enterupdatetypevalue);
	        LoggerUtil.info("Searched for updated entry: " + enterupdatetypevalue);
	        Thread.sleep(2000);

	        String updatedCategoryExpected = "Ply";
	        String updatedCategoryActual = waitForExpectedElement(fetchingdatacategorycolom).getText().trim();
	        String updatedTypeExpected = enterupdatetypevalue;
	        String updatedTypeActual = waitForExpectedElement(fettchingdatatypecolom).getText().trim();

	        soft.assertEquals(updatedCategoryActual, updatedCategoryExpected, "Category mismatch after edit!");
	        soft.assertEquals(updatedTypeActual, updatedTypeExpected, "Type mismatch after edit!");

	        if (updatedCategoryExpected.equals(updatedCategoryActual) && updatedTypeExpected.equals(updatedTypeActual)) {
	            LoggerUtil.pass("Edit validation passed → Category: " + updatedCategoryActual + " | Type: " + updatedTypeActual);
	        } else {
	            LoggerUtil.mismatch("Edit validation failed",
	                    "Expected: Category='" + updatedCategoryExpected + "', Type='" + updatedTypeExpected + "'",
	                    "Actual: Category='" + updatedCategoryActual + "', Type='" + updatedTypeActual + "'");
	        }

	        // Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in editinclientA: " + e.getMessage());
	        throw e;
	    }
	}

	public static final By fetchingupdateddatafromdifferentclient = By
			.xpath("//table[@id='PackingTable']/tbody/tr/td[1]");

	public void verifyupdateddatafromclientAisexsistornot(String enterupdatetypevalue) throws InterruptedException {

		new SoftAssert();
		clearAndEnterText(waitForExpectedElement(entersearchvalue), enterupdatetypevalue);
		Thread.sleep(2000);
		String ecpectedcategorydata = "Ply";
		String actualcategorydata = waitForExpectedElement(fetchingupdateddatafromdifferentclient).getText();

		if (!ecpectedcategorydata.equals(actualcategorydata)) {

			LoggerUtil.pass("Finally first client data has not been updated..");

		}

		else {

			LoggerUtil.error("First client data has been updated in second client..");
		}

	}


public void verifysaveasnewinfirstdata(String enterupdatetypevalue,String entervalueforsaveasnew) throws InterruptedException {
	
	clearAndEnterText(waitForExpectedElement(entersearchvalue), enterupdatetypevalue);
	Thread.sleep(4000);
	clickOnElement(clickeditbtn);
	clickOnElement(clickikngcategorydropdown);
	Thread.sleep(3000);
	List<WebElement> categorylist = driver.findElements(categorydroplist);
	selectBootStrapDropDown(categorylist, "Ply");
	Thread.sleep(2000);
	clearAndEnterText(waitForExpectedElement(entertype), entervalueforsaveasnew);
	Thread.sleep(4000);
	clickOnElement(saveasnewbtn);
	
}

     
public void verifysaveasnewexistindifferentclientornot(String entersaveasnewtypevalue) throws InterruptedException {

	clearAndEnterText(waitForExpectedElement(entersearchvalue), entersaveasnewtypevalue);
	Thread.sleep(2000);
	String ecpectedcategorydata = "Ply";
	String actualcategorydata = waitForExpectedElement(fetchingupdateddatafromdifferentclient).getText();

	if (!ecpectedcategorydata.equals(actualcategorydata)) {

		LoggerUtil.pass("Finally first client data has not been Saved As new Entry..");

	}

	else {

		LoggerUtil.error("First client data has been saved in second client..");
	}

}

public void verfyafterdeletingdatainfirstandcheckimpactinsecondclient(String searchvaluefordeleting)
		throws InterruptedException {

	clearAndEnterText(waitForExpectedElement(entersearchvalue), searchvaluefordeleting);
	Thread.sleep(2000);
	
	clickOnElement(deletebtn);
	driver.switchTo().alert().accept();
   
	System.out.println(waitForExpectedElement(toastmsg).getText());
	String expected = "Packing category successfully deleted.";
	String acctualdeletedmsg = waitForExpectedElement(toastmsg).getText();
	if(expected.equals(acctualdeletedmsg)) {
		LoggerUtil.pass("data deleting popup is correct..");
	}
	
	else {
		
		LoggerUtil.error("Deleted popup is not correct");
	}

}



public void verifyafterdeletingfirstclientidshouldnotimpactinfirstid(String searchvaluefordeleting) throws InterruptedException {
	
	clearAndEnterText(waitForExpectedElement(entersearchvalue), searchvaluefordeleting);
	Thread.sleep(2000);
	String actualvaluetype = waitForExpectedElement(fettchingdatatypecolom).getText();
	String expectedtypeString = searchvaluefordeleting;
	if(actualvaluetype.equals(expectedtypeString)) {
		
		LoggerUtil.pass("Everything is fine data did not delete from different client");
		
	}
	
	else {
		
		LoggerUtil.mismatch("data has been deleted..");
		
	}
}





}
