package com.Pages;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.helper.Base;
import com.helper.LoggerUtil;

public class WireDataEntryPage extends Base {

	DashboardPage dashboard = new DashboardPage();

	public static final By wirename = By.xpath("//input[@id='WireName']");
	public static final By savebtn = By.xpath("//button[@id='tab6Save']");
	public static final By clickwiredrop = By.xpath("//span[@id='select2-StandardDropdown-container']");

	public void savenewwiredataentry(String enterwirename) throws InterruptedException {
		dashboard.clickingwirestandardtab();
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		LoggerUtil.info(enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);

	}

	public static final By otherdiawithwire = By.xpath("//input[@id='OutsideDia']");
	public static final By wirenormalsize = By.xpath("//input[@id='WireSelection']");
	public static final By Thickness = By.xpath("//input[@id='ThikofVinyl']");
	public static final By numberofconductors = By.xpath("//input[@id='NoOfCunductors']");
	public static final By STD = By.xpath("//input[@id='Std']");
	public static final By conductorydiamm = By.xpath("//input[@id='CundoctorDia']");
	public static final By max = By.xpath("//input[@id='Max']");
	public static final By thicknessScreening = By.xpath("//input[@id='ThicknessofScreening']");
	public static final By thicknessjacket = By.xpath("//input[@id='ThicknessofJacket']");
	public static final By insulator = By.xpath("//input[@id='NoofInsulators']");
	public static final By wirenumber = By.xpath("//input[@id='NoofWireCore']");
	public static final By bedding = By.xpath("//input[@id='Bedding']");
	public static final By savebtnwiredataentry = By.xpath("//button[@id='tab7Save']");
	public static final By searchboxwiredataentry = By.xpath("//*[@id='WiringDataEntry_filter']/label/input");
	public static final By seacgboxforwiredrop = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By fetchingcolom = By.xpath("//*[@id='WiringDataEntry']/tbody/tr[1]/td[1]");
	public static final By toastmsg = By.xpath("//*[@id='toast-container']/div/div[2]");

	public void savenewdatawiredataentry(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Wire Data Entry save flow...");

	        // Step 1: Select Wire from dropdown
	        clickOnElement(clickwiredrop);
	        Thread.sleep(3000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Fill all fields
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All input fields filled successfully.");

	        // Step 3: Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button for Wire Data Entry");

	        // Step 4: Validate toast message
	        String expectedToast = "Wire details successfully saved.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            LoggerUtil.info("Toast displayed: " + actualToast);

	            soft.assertEquals(actualToast, expectedToast, "Toast message mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Correct toast displayed after save: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Save Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("Toast not displayed after saving wire data entry.");
	            soft.fail("Toast missing after save.");
	        }

	        // Step 5: Search & validate grid entry
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        LoggerUtil.info("Searched for saved Wire entry: " + entervalue);
	        Thread.sleep(2000);

	        String actualValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedValue = entervalue;

	        soft.assertEquals(actualValue, expectedValue, "Grid value mismatch!");
	        if (expectedValue.equals(actualValue)) {
	            LoggerUtil.pass("Grid validation passed → Found saved wire: " + actualValue);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedValue, actualValue);
	        }

	        // Final assert
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentry: " + e.getMessage());
	        throw e;
	    }
	}


	public void savenewwiredataentryForSaveAsNew(String enterwirename, String enterwirename1)
	        throws InterruptedException {
	    try {
	        LoggerUtil.info("Starting Save As New flow for Wire Data Entry...");

	        // Step 1: Navigate to Wire Standard tab
	        dashboard.clickingwirestandardtab();
	        LoggerUtil.info("Navigated to Wire Standard tab");

	        // Step 2: Enter first wire name and Save
	        clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
	        LoggerUtil.info("Entered Wire Name: " + enterwirename);
	        clickOnElement(savebtn);
	        LoggerUtil.info("Clicked Save button for first Wire Name");
	        Thread.sleep(2000);

	        // Validate first save toast
	        String expectedSaveToast = "Wire details successfully saved.";
	        List<WebElement> firstToast = driver.findElements(toastmsg);
	        if (!firstToast.isEmpty()) {
	            String actualSaveToast = firstToast.get(0).getText().trim();
	            if (expectedSaveToast.equals(actualSaveToast)) {
	                LoggerUtil.pass("First Save toast validated: " + actualSaveToast);
	            } else {
	                LoggerUtil.mismatch("First Save Toast Mismatch", expectedSaveToast, actualSaveToast);
	            }
	        } else {
	            LoggerUtil.error("Toast not displayed after first Wire save.");
	        }

	        // Step 3: Enter second wire name and Save As New
	        clearAndEnterText(waitForExpectedElement(wirename), enterwirename1);
	        LoggerUtil.info("Entered new Wire Name for Save As New: " + enterwirename1);
	        clickOnElement(savebtn);
	        LoggerUtil.info("Clicked Save button for Save As New Wire Name");
	        Thread.sleep(2000);

	        // Validate Save As New toast
	        String expectedSaveAsNewToast = "Wire details successfully saved.";
	        List<WebElement> secondToast = driver.findElements(toastmsg);
	        if (!secondToast.isEmpty()) {
	            String actualSaveAsNewToast = secondToast.get(0).getText().trim();
	            if (expectedSaveAsNewToast.equals(actualSaveAsNewToast)) {
	                LoggerUtil.pass("Save As New toast validated: " + actualSaveAsNewToast);
	            } else {
	                LoggerUtil.mismatch("Save As New Toast Mismatch", expectedSaveAsNewToast, actualSaveAsNewToast);
	            }
	        } else {
	            LoggerUtil.error("Toast not displayed after Save As New Wire entry.");
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewwiredataentryForSaveAsNew: " + e.getMessage());
	        throw e;
	    }
	}


	public static final By saveasnewbtn = By.xpath("//button[@id='tab7SaveAsNew']");
	public static final By editbtn = By.xpath("//*[@id='WiringDataEntry']/tbody/tr[1]/td[14]/a[1]/i");

	public void savenewdatawiredataentryforsaveAsnew(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors,
	        String entervalueforsaveasnew) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Save As New Wire Data Entry flow...");

	        // Step 1: Select Wire and create initial entry
	        clickOnElement(clickwiredrop);
	        Thread.sleep(3000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All input fields filled successfully for first save.");

	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button for first Wire entry");
	        Thread.sleep(2000);

	        // Step 2: Search and edit entry
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);
	        clickOnElement(editbtn);
	        LoggerUtil.info("Clicked Edit button for first Wire entry");

	        // Step 3: Change wire name and Save As New
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox1 = driver.findElement(seacgboxforwiredrop);
	        inputbox1.sendKeys(entervalueforsaveasnew);
	        inputbox1.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Entered new Wire Name for Save As New: " + entervalueforsaveasnew);

	        clickOnElement(saveasnewbtn);
	        LoggerUtil.info("Clicked Save As New button");
	        Thread.sleep(2000);

	        // Step 4: Validate Save As New toast
	        String expectedPopup = "Wire Details successfully created as a new entry.";
	        List<WebElement> toastList = driver.findElements(toastmsg);
	        if (!toastList.isEmpty()) {
	            String actualPopup = toastList.get(0).getText().trim();
	            soft.assertEquals(actualPopup, expectedPopup, "Save As New toast mismatch!");
	            if (expectedPopup.equals(actualPopup)) {
	                LoggerUtil.pass("Save As New toast validated: " + actualPopup);
	            } else {
	                LoggerUtil.mismatch("Save As New Toast Mismatch", expectedPopup, actualPopup);
	            }
	        } else {
	            LoggerUtil.error("No toast displayed after Save As New action.");
	            soft.fail("Save As New toast missing.");
	        }

	        // Step 5: Validate new entry in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalueforsaveasnew);
	        Thread.sleep(2000);

	        String actualData = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedData = entervalueforsaveasnew;

	        soft.assertEquals(actualData, expectedData, "Grid data mismatch after Save As New!");
	        if (expectedData.equals(actualData)) {
	            LoggerUtil.pass("Grid validation passed → Found saved wire: " + actualData);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedData, actualData);
	        }

	        // Final assert
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryforsaveAsnew: " + e.getMessage());
	        throw e;
	    }
	}


	public void savenewdatawiredataentryforUpdate(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors,
	        String entervalueforsaveasnew) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Wire Data Entry Update flow...");

	        // Step 1: Select Wire and create initial entry
	        clickOnElement(clickwiredrop);
	        Thread.sleep(3000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Fill fields
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All input fields filled successfully for initial Wire entry.");

	        // Save initial entry
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button for initial Wire entry");
	        Thread.sleep(2000);

	        // Step 2: Search & edit
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);
	        clickOnElement(editbtn);
	        LoggerUtil.info("Clicked Edit button for Wire entry");

	        // Step 3: Update wire name
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox1 = driver.findElement(seacgboxforwiredrop);
	        inputbox1.sendKeys(entervalueforsaveasnew);
	        inputbox1.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Updated Wire Name to: " + entervalueforsaveasnew);

	        // Save update
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button after update");
	        Thread.sleep(2000);

	        // Step 4: Validate update toast
	        String expectedToast = "Wire details successfully updated.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "Update toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Update toast validated: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Update Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("No toast displayed after updating wire entry.");
	            soft.fail("Update toast missing.");
	        }

	        // Step 5: Validate updated record in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalueforsaveasnew);
	        Thread.sleep(2000);

	        String actualData = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedData = entervalueforsaveasnew;

	        soft.assertEquals(actualData, expectedData, "Grid data mismatch after update!");
	        if (expectedData.equals(actualData)) {
	            LoggerUtil.pass("Grid validation passed → Updated wire found: " + actualData);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedData, actualData);
	        }

	        // Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryforUpdate: " + e.getMessage());
	        throw e;
	    }
	}

	public static final By deletebtn = By.xpath("//*[@id='WiringDataEntry']/tbody/tr[1]/td[14]/a[2]/i");

	public void savenewdatawiredataentryfordeletion(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Wire Data Entry Save & Delete flow...");

	        // Step 1: Select Wire and fill fields
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All fields filled successfully.");

	        // Step 2: Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button for Wire entry");

	        String expectedSaveToast = "Wire details successfully saved.";
	        List<WebElement> saveToastList = driver.findElements(toastmsg);
	        if (!saveToastList.isEmpty()) {
	            String actualSaveToast = saveToastList.get(0).getText().trim();
	            soft.assertEquals(actualSaveToast, expectedSaveToast, "Save toast mismatch!");
	            if (expectedSaveToast.equals(actualSaveToast)) {
	                LoggerUtil.pass("Save toast validated: " + actualSaveToast);
	            } else {
	                LoggerUtil.mismatch("Save Toast Mismatch", expectedSaveToast, actualSaveToast);
	            }
	        } else {
	            LoggerUtil.error("Save toast not displayed.");
	            soft.fail("Save toast missing.");
	        }

	        Thread.sleep(4000);
	        // Step 3: Search and verify saved entry
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);
	        String actualValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedValue = entervalue;

	        soft.assertEquals(actualValue, expectedValue, "Grid mismatch after save!");
	        if (expectedValue.equals(actualValue)) {
	            LoggerUtil.pass("Grid validation passed → Found saved wire: " + actualValue);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedValue, actualValue);
	        }

	        Thread.sleep(5000);
	        // Step 4: Delete entry
	        clickOnElement(deletebtn);
	        driver.switchTo().alert().accept();
	        LoggerUtil.info("Clicked Delete and accepted confirmation alert");

	        String expectedDeleteToast = "Wire details successfully deleted.";
	        List<WebElement> deleteToastList = driver.findElements(toastmsg);
	        if (!deleteToastList.isEmpty()) {
	            String actualDeleteToast = deleteToastList.get(0).getText().trim();
	            soft.assertEquals(actualDeleteToast, expectedDeleteToast, "Delete toast mismatch!");
	            if (expectedDeleteToast.equals(actualDeleteToast)) {
	                LoggerUtil.pass("Delete toast validated: " + actualDeleteToast);
	            } else {
	                LoggerUtil.mismatch("Delete Toast Mismatch", expectedDeleteToast, actualDeleteToast);
	            }
	        } else {
	            LoggerUtil.error("Delete toast not displayed.");
	            soft.fail("Delete toast missing.");
	        }

	        // Final assertions
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryfordeletion: " + e.getMessage());
	        throw e;
	    }
	}


	public void savenewdatawiredataentryforsaveAsnewFroDeletion(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors,
	        String entervalueforsaveasnew) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Save As New + Delete flow for Wire Data Entry...");

	        // Step 1: Create initial Wire entry
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("Filled all fields for initial Wire entry.");

	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button for initial Wire entry");
	        Thread.sleep(6000);

	        // Step 2: Edit and Save As New
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);
	        clickOnElement(editbtn);
	        LoggerUtil.info("Clicked Edit button for Wire entry");

	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox1 = driver.findElement(seacgboxforwiredrop);
	        inputbox1.sendKeys(entervalueforsaveasnew);
	        inputbox1.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Entered new Wire Name for Save As New: " + entervalueforsaveasnew);

	        clickOnElement(saveasnewbtn);
	        LoggerUtil.info("Clicked Save As New button");

	        String expectedSaveAsNewToast = "Wire Details successfully created as a new entry.";
	        List<WebElement> saveAsNewToastList = driver.findElements(toastmsg);
	        if (!saveAsNewToastList.isEmpty()) {
	            String actualSaveAsNewToast = saveAsNewToastList.get(0).getText().trim();
	            soft.assertEquals(actualSaveAsNewToast, expectedSaveAsNewToast, "Save As New toast mismatch!");
	            if (expectedSaveAsNewToast.equals(actualSaveAsNewToast)) {
	                LoggerUtil.pass("Save As New toast validated: " + actualSaveAsNewToast);
	            } else {
	                LoggerUtil.mismatch("Save As New Toast Mismatch", expectedSaveAsNewToast, actualSaveAsNewToast);
	            }
	        } else {
	            LoggerUtil.error("Save As New toast not displayed.");
	            soft.fail("Save As New toast missing.");
	        }

	        // Step 3: Validate new entry in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalueforsaveasnew);
	        Thread.sleep(2000);

	        String actualGridData = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedGridData = entervalueforsaveasnew;

	        soft.assertEquals(actualGridData, expectedGridData, "Grid mismatch after Save As New!");
	        if (expectedGridData.equals(actualGridData)) {
	            LoggerUtil.pass("Grid validation passed → Found saved wire: " + actualGridData);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedGridData, actualGridData);
	        }

	        // Step 4: Delete the Save As New entry
	        clickOnElement(deletebtn);
	        driver.switchTo().alert().accept();
	        LoggerUtil.info("Clicked Delete and confirmed alert for Save As New entry");

	        String expectedDeleteToast = "Wire details successfully deleted.";
	        List<WebElement> deleteToastList = driver.findElements(toastmsg);
	        if (!deleteToastList.isEmpty()) {
	            String actualDeleteToast = deleteToastList.get(0).getText().trim();
	            soft.assertEquals(actualDeleteToast, expectedDeleteToast, "Delete toast mismatch!");
	            if (expectedDeleteToast.equals(actualDeleteToast)) {
	                LoggerUtil.pass("Delete toast validated: " + actualDeleteToast);
	            } else {
	                LoggerUtil.mismatch("Delete Toast Mismatch", expectedDeleteToast, actualDeleteToast);
	            }
	        } else {
	            LoggerUtil.error("Delete toast not displayed.");
	            soft.fail("Delete toast missing.");
	        }

	        // Final assertions
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryforsaveAsnewFroDeletion: " + e.getMessage());
	        throw e;
	    }
	}

	public static final By resetbtn = By.xpath("//*[@id='tab7Form']/div[5]/div/div/button[5]");

	public void savenewdatawiredataentryforverificationDuplication(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Wire Data Entry duplication validation...");

	        // Step 1: Select Wire and fill all fields
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All fields filled successfully for first save.");

	        // Step 2: Save the entry
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button");

	        String expectedSaveToast = "Wire details successfully saved.";
	        List<WebElement> saveToastList = driver.findElements(toastmsg);
	        if (!saveToastList.isEmpty()) {
	            String actualSaveToast = saveToastList.get(0).getText().trim();
	            soft.assertEquals(actualSaveToast, expectedSaveToast, "Save toast mismatch!");
	            if (expectedSaveToast.equals(actualSaveToast)) {
	                LoggerUtil.pass("First Save toast validated: " + actualSaveToast);
	            } else {
	                LoggerUtil.mismatch("Save Toast Mismatch", expectedSaveToast, actualSaveToast);
	            }
	        } else {
	            LoggerUtil.error("Save toast not displayed.");
	            soft.fail("Save toast missing.");
	        }

	        // Step 3: Verify saved entry in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);
	        String actualGridValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedGridValue = entervalue;

	        soft.assertEquals(actualGridValue, expectedGridValue, "Grid mismatch after save!");
	        if (expectedGridValue.equals(actualGridValue)) {
	            LoggerUtil.pass("Grid validation passed → Found saved wire: " + actualGridValue);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedGridValue, actualGridValue);
	        }

	        // Step 4: Attempt duplicate Save As New
	        clickOnElement(editbtn);
	        LoggerUtil.info("Clicked Edit button for saved entry");
	        Thread.sleep(2000);

	        clickOnElement(saveasnewbtn);
	        LoggerUtil.info("Clicked Save As New button to trigger duplication");

	        String expectedDuplicateToast = "Wire details already saved.";
	        List<WebElement> duplicateToastList = driver.findElements(toastmsg);
	        if (!duplicateToastList.isEmpty()) {
	            String actualDuplicateToast = duplicateToastList.get(0).getText().trim();
	            soft.assertEquals(actualDuplicateToast, expectedDuplicateToast, "Duplicate toast mismatch!");
	            if (expectedDuplicateToast.equals(actualDuplicateToast)) {
	                LoggerUtil.pass("Duplicate validation passed → Correct toast displayed: " + actualDuplicateToast);
	            } else {
	                LoggerUtil.mismatch("Duplicate Toast Mismatch", expectedDuplicateToast, actualDuplicateToast);
	            }
	        } else {
	            LoggerUtil.error("Duplicate toast not displayed.");
	            soft.fail("Duplicate toast missing.");
	        }

	        // Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryforverificationDuplication: " + e.getMessage());
	        throw e;
	    }
	}


	public void verifyresetbuttonfunctionality(
	        String priviouswirename,
	        String priviousouterdia,
	        String privinominalsize,
	        String priviousthickness,
	        String priviousconductors,
	        String priviousSTD,
	        String priviousdiamm) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Clicking Edit button for wire entry...");
	        clickOnElement(editbtn);
	        Thread.sleep(5000);

	        LoggerUtil.info("Verifying pre-filled values before Reset...");

	        String actualWireName = waitForExpectedElement(clickwiredrop).getText().trim();
	        soft.assertEquals(actualWireName, priviouswirename, "Wire Name mismatch → Expected: " + priviouswirename + " | Actual: " + actualWireName);

	        String actualOuterDia = waitForExpectedElement(otherdiawithwire).getAttribute("value").trim();
	        if (new BigDecimal(actualOuterDia).compareTo(new BigDecimal(priviousouterdia)) != 0) {
	            soft.fail("Outer Dia mismatch → Expected: " + priviousouterdia + " | Actual: " + actualOuterDia);
	        }

	        String actualNominalSize = waitForExpectedElement(wirenormalsize).getAttribute("value").trim();
	        if (new BigDecimal(actualNominalSize).compareTo(new BigDecimal(privinominalsize)) != 0) {
	            soft.fail("Nominal Size mismatch → Expected: " + privinominalsize + " | Actual: " + actualNominalSize);
	        }

	        String actualThickness = waitForExpectedElement(Thickness).getAttribute("value").trim();
	        if (new BigDecimal(actualThickness).compareTo(new BigDecimal(priviousthickness)) != 0) {
	            soft.fail("Thickness mismatch → Expected: " + priviousthickness + " | Actual: " + actualThickness);
	        }

	        String actualConductors = waitForExpectedElement(numberofconductors).getAttribute("value").trim();
	        soft.assertEquals(actualConductors, priviousconductors, "Conductors mismatch → Expected: " + priviousconductors + " | Actual: " + actualConductors);

	        String actualSTD = waitForExpectedElement(STD).getAttribute("value").trim();
	        if (new BigDecimal(actualSTD).compareTo(new BigDecimal(priviousSTD)) != 0) {
	            soft.fail("STD mismatch → Expected: " + priviousSTD + " | Actual: " + actualSTD);
	        }

	        String actualDiaMM = waitForExpectedElement(conductorydiamm).getAttribute("value").trim();
	        if (new BigDecimal(actualDiaMM).compareTo(new BigDecimal(priviousdiamm)) != 0) {
	            soft.fail("Dia MM mismatch → Expected: " + priviousdiamm + " | Actual: " + actualDiaMM);
	        }

	        LoggerUtil.info("Clicking Reset button...");
	        clickOnElement(resetbtn);
	        Thread.sleep(2000);

	        LoggerUtil.info("Validating that fields are cleared after Reset...");

	        soft.assertEquals(waitForExpectedElement(clickwiredrop).getText().trim(), "Select", "Wire Name not reset.");
	        soft.assertEquals(waitForExpectedElement(otherdiawithwire).getAttribute("value").trim(), "", "Outer Dia not cleared.");
	        soft.assertEquals(waitForExpectedElement(wirenormalsize).getAttribute("value").trim(), "", "Nominal Size not cleared.");
	        soft.assertEquals(waitForExpectedElement(Thickness).getAttribute("value").trim(), "", "Thickness not cleared.");
	        soft.assertEquals(waitForExpectedElement(numberofconductors).getAttribute("value").trim(), "", "Conductors not cleared.");
	        soft.assertEquals(waitForExpectedElement(STD).getAttribute("value").trim(), "", "STD not cleared.");
	        soft.assertEquals(waitForExpectedElement(conductorydiamm).getAttribute("value").trim(), "", "Dia MM not cleared.");

	        LoggerUtil.pass("Reset button functionality validated → All fields cleared successfully.");
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in verifyresetbuttonfunctionality: " + e.getMessage());
	        throw e;
	    }
	}


	public void savenewdatawiredataentryForSTD(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting STD field mandatory validation...");

	        // Step 1: Select Wire
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Fill all fields except STD
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        // Intentionally skipping STD to trigger validation
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All fields filled except STD.");

	        // Step 3: Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button to trigger STD validation");

	        // Step 4: Validate toast
	        String expectedToast = "Please fill  STD Field.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "STD validation toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("STD Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("No toast displayed for missing STD field.");
	            soft.fail("STD validation toast missing.");
	        }

	        Thread.sleep(5000);
	        // Step 5: Verify that record was not saved in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);

	        String actualGridValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedGridValue = entervalue;

	        // If STD is mandatory, ideally grid should NOT contain this record
	        if (expectedGridValue.equals(actualGridValue)) {
	            LoggerUtil.error("❌ Record appeared in grid even though STD was missing → Possible bug.");
	            soft.fail("Grid should not contain entry without STD.");
	        } else {
	            LoggerUtil.pass("✅ Grid correctly did not contain entry without STD.");
	        }

	        // Final assertions
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryForSTD: " + e.getMessage());
	        throw e;
	    }
	}


	public void savenewdatawiredataentryForMax(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Max field mandatory validation...");

	        // Step 1: Select Wire
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Fill all fields except Max
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        // Intentionally skipping Max
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);
	        LoggerUtil.info("All fields filled except Max.");

	        // Step 3: Click Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button to trigger Max field validation");

	        // Step 4: Validate toast
	        String expectedToast = "Please fill Max Field.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "Max validation toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Max Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("No toast displayed for missing Max field.");
	            soft.fail("Max validation toast missing.");
	        }

	        // Step 5: Verify record is NOT saved in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);

	        String actualGridValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedGridValue = entervalue;

	        if (expectedGridValue.equals(actualGridValue)) {
	            LoggerUtil.error("❌ Record appeared in grid even though Max field was missing → Possible bug.");
	            soft.fail("Grid should not contain entry without Max value.");
	        } else {
	            LoggerUtil.pass("✅ Grid correctly did not contain entry without Max value.");
	        }

	        // Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryForMax: " + e.getMessage());
	        throw e;
	    }
	}

	public void savenewdatawiredataentryWireCoreIsGreaterTheanInsulator(
	        String entervalue,
	        String enterthickvalue,
	        String enterconductorvalue,
	        String enterSTDvalue,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjack,
	        String enterinsulatorvalue,
	        String entervaluenumconductors) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting validation for Wire Core > Insulator scenario...");

	        // Step 1: Select Wire
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Fill fields (intentionally making Wire Core > Insulator)
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjack);

	        // Intentionally wrong values
	        clearAndEnterText(waitForExpectedElement(insulator), "2");
	        LoggerUtil.info("Entered Insulator = 2");

	        clearAndEnterText(waitForExpectedElement(wirenumber), "79");
	        LoggerUtil.info("Entered Wire Core = 79");

	        clearAndEnterText(waitForExpectedElement(bedding), enterinsulatorvalue);

	        // Step 3: Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save to trigger Wire Core > Insulator validation");

	        // Step 4: Validate toast
	        String expectedToast = "invalid wire core value.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "Wire Core > Insulator validation toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Correct validation toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Validation Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("No toast displayed for Wire Core > Insulator validation.");
	            soft.fail("Validation toast missing.");
	        }

	        // Step 5: Verify record is NOT saved in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);

	        String actualGridValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        if (entervalue.equals(actualGridValue)) {
	            LoggerUtil.error("❌ Record appeared in grid even though Wire Core > Insulator → Possible bug.");
	            soft.fail("Grid should not contain entry when Wire Core > Insulator.");
	        } else {
	            LoggerUtil.pass("✅ Grid correctly does not contain entry when Wire Core > Insulator.");
	        }

	        // Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryWireCoreIsGreaterTheanInsulator: " + e.getMessage());
	        throw e;
	    }
	}


	public void savenewdatawiredataentryForuptoFourDecimal(
	        String entervalue,
	        String entervalueotherdiawithwire,
	        String entervaluewirenormalsize,
	        String enterthickvalue,
	        String entervaluenumconductors,
	        String enterSTDvalue,
	        String entervalueforconductordia,
	        String entermaxvalue,
	        String enterthickscreen,
	        String enterthickjacket,
	        String enterinsulatorvalue,
	        String enternumberofwirecore,
	        String enterbedding) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting Wire Data Entry save test for up to 4 decimal precision...");

	        // Step 1: Select Wire
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputbox = driver.findElement(seacgboxforwiredrop);
	        inputbox.sendKeys(entervalue);
	        inputbox.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Fill fields with values (including decimals)
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), entervalueotherdiawithwire);
	        clearAndEnterText(waitForExpectedElement(wirenormalsize), entervaluewirenormalsize);
	        clearAndEnterText(waitForExpectedElement(Thickness), enterthickvalue);
	        clearAndEnterText(waitForExpectedElement(numberofconductors), entervaluenumconductors);
	        clearAndEnterText(waitForExpectedElement(STD), enterSTDvalue);
	        clearAndEnterText(waitForExpectedElement(conductorydiamm), entervalueforconductordia);
	        clearAndEnterText(waitForExpectedElement(max), entermaxvalue);
	        clearAndEnterText(waitForExpectedElement(thicknessScreening), enterthickscreen);
	        clearAndEnterText(waitForExpectedElement(thicknessjacket), enterthickjacket);
	        clearAndEnterText(waitForExpectedElement(insulator), enterinsulatorvalue);
	        clearAndEnterText(waitForExpectedElement(wirenumber), enternumberofwirecore);
	        clearAndEnterText(waitForExpectedElement(bedding), enterbedding);
	        LoggerUtil.info("All fields filled with decimal values where applicable.");

	        // Step 3: Save entry
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button");

	        String expectedToast = "Wire details successfully saved.";
	        List<WebElement> toastList = driver.findElements(toastmsg);
	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "Save toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Save toast validated: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Save Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("Save toast not displayed.");
	            soft.fail("Save toast missing.");
	        }

	        
	        // Step 4: Validate saved record in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        Thread.sleep(2000);

	        String actualGridValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedGridValue = entervalue;

	        soft.assertEquals(actualGridValue, expectedGridValue, "Grid mismatch after save!");
	        if (expectedGridValue.equals(actualGridValue)) {
	            LoggerUtil.pass("Grid validation passed → Saved wire found: " + actualGridValue);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedGridValue, actualGridValue);
	        }

	        // ✅ Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savenewdatawiredataentryForuptoFourDecimal: " + e.getMessage());
	        throw e;
	    }
	}


	public void savewithmandatoryfield(String entervalue, String enterouterdiaofwire, String enterSTD)
	        throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting save test with only mandatory fields...");

	        // Step 1: Select Wire
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputsearch = driver.findElement(seacgboxforwiredrop);
	        inputsearch.sendKeys(entervalue);
	        inputsearch.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Enter mandatory fields
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterouterdiaofwire);
	        LoggerUtil.info("Entered Outer Dia: " + enterouterdiaofwire);

	        clearAndEnterText(waitForExpectedElement(STD), enterSTD);
	        LoggerUtil.info("Entered STD: " + enterSTD);

	        // Step 3: Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button");

	        // Step 4: Validate toast
	        String expectedToast = "Wire details successfully saved.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "Save toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Correct toast displayed: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Toast Mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("No toast displayed after saving with mandatory fields.");
	            soft.fail("Toast missing for mandatory field save.");
	        }

	        // ✅ Final assertion
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savewithmandatoryfield: " + e.getMessage());
	        throw e;
	    }
	}

	public void savewithmandatoryfieldDataForClientA(
	        String entervalue,
	        String enterouterdiaofwire,
	        String enterwirenormalvalue,
	        String enternumberofconductor,
	        String entercondiamm,
	        String enterSTD) throws InterruptedException {

	    SoftAssert soft = new SoftAssert();

	    try {
	        LoggerUtil.info("Starting save test with mandatory fields for Client A...");

	        // Step 1: Select Wire
	        clickOnElement(clickwiredrop);
	        Thread.sleep(2000);
	        WebElement inputsearch = driver.findElement(seacgboxforwiredrop);
	        inputsearch.sendKeys(entervalue);
	        inputsearch.sendKeys(Keys.ENTER);
	        LoggerUtil.info("Selected Wire: " + entervalue);

	        // Step 2: Enter mandatory fields for Client A
	        clearAndEnterText(waitForExpectedElement(otherdiawithwire), enterouterdiaofwire);
	        LoggerUtil.info("Entered Outer Dia: " + enterouterdiaofwire);

	        clearAndEnterText(waitForExpectedElement(wirenormalsize), enterwirenormalvalue);
	        LoggerUtil.info("Entered Wire Normal Size: " + enterwirenormalvalue);

	        clearAndEnterText(waitForExpectedElement(numberofconductors), enternumberofconductor);
	        LoggerUtil.info("Entered Number of Conductors: " + enternumberofconductor);

	        clearAndEnterText(waitForExpectedElement(conductorydiamm), entercondiamm);
	        LoggerUtil.info("Entered Conductor Dia MM: " + entercondiamm);

	        clearAndEnterText(waitForExpectedElement(STD), enterSTD);
	        LoggerUtil.info("Entered STD: " + enterSTD);

	        // Step 3: Save
	        clickOnElement(savebtnwiredataentry);
	        LoggerUtil.info("Clicked Save button");

	        // Step 4: Validate toast
	        String expectedToast = "Wire details successfully saved.";
	        List<WebElement> toastList = driver.findElements(toastmsg);

	        if (!toastList.isEmpty()) {
	            String actualToast = toastList.get(0).getText().trim();
	            soft.assertEquals(actualToast, expectedToast, "Save toast mismatch!");
	            if (expectedToast.equals(actualToast)) {
	                LoggerUtil.pass("Toast validated successfully: " + actualToast);
	            } else {
	                LoggerUtil.mismatch("Toast mismatch", expectedToast, actualToast);
	            }
	        } else {
	            LoggerUtil.error("Save toast not displayed for Client A mandatory fields.");
	            soft.fail("Save toast missing.");
	        }

	        // Step 5: Validate saved entry in grid
	        clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), entervalue);
	        LoggerUtil.info("Searched for saved wire: " + entervalue);
	        Thread.sleep(2000);

	        String actualGridValue = waitForExpectedElement(fetchingcolom).getText().trim();
	        String expectedGridValue = entervalue;

	        soft.assertEquals(actualGridValue, expectedGridValue, "Grid data mismatch!");
	        if (expectedGridValue.equals(actualGridValue)) {
	            LoggerUtil.pass("Grid validation passed → Found wire: " + actualGridValue);
	        } else {
	            LoggerUtil.mismatch("Grid validation failed", expectedGridValue, actualGridValue);
	        }

	        // Final assertions
	        soft.assertAll();

	    } catch (Exception e) {
	        LoggerUtil.error("Error in savewithmandatoryfieldDataForClientA: " + e.getMessage());
	        throw e;
	    }
	}

	public void updatingdataforclientA(String enterpriviousvalue, String enternewvalue) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), enterpriviousvalue);
		Thread.sleep(3000);
		clickOnElement(editbtn);
		Thread.sleep(4000);
		clickOnElement(clickwiredrop);
		Thread.sleep(3000);
		WebElement inputsearch = driver.findElement(seacgboxforwiredrop);
		Thread.sleep(1000);
		inputsearch.sendKeys(enternewvalue);
		inputsearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		clickOnElement(savebtnwiredataentry);

	}

	public void verifyupdatingdatafromclientAisSaveInClientBOrNot(String enterupdatedvalue)
			throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), enterupdatedvalue);
		Thread.sleep(3000);
		String actualdata = waitForExpectedElement(fetchingcolom).getText();
		String expecteddata = enterupdatedvalue;

		if (!actualdata.equals(expecteddata)) {

			LoggerUtil.pass("Data Has Not Been Matched in different client i'd after updating the data..");

		} else {

			LoggerUtil.error("data has been Matched After updating different client i'd...");

		}

	}

	public void SaveAsNewdataforclientA(String enterpriviousvalue, String enternewvalue) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(searchboxwiredataentry), enterpriviousvalue);
		Thread.sleep(3000);
		clickOnElement(editbtn);
		Thread.sleep(4000);
		clickOnElement(clickwiredrop);
		Thread.sleep(3000);
		WebElement inputsearch = driver.findElement(seacgboxforwiredrop);
		Thread.sleep(1000);
		inputsearch.sendKeys(enternewvalue);
		inputsearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		clickOnElement(saveasnewbtn);

	}

}
