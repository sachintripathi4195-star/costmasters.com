package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.helper.Base;
import com.helper.LoggerUtil;

public class BOPPage extends Base {

	public static final By EnterBopType = By.xpath("//input[@id='BopType_BopTypeName']");
	public static final By SaveButtonBopType = By.xpath("//button[@id='SaveBOP']");
	public static final By searchvalueBop = By
			.xpath("//div[@id='table2_filter']//input[@class='form-control form-control-sm']");
	public static final By fetchBopTypeValue = By.xpath("//table[@id='table2']/tbody/tr/td[2]");
	public static final By deleteButtonBopType = By.xpath("//*[@id='table2']/tbody/tr/td[3]/a[2]/i");
	public static final By toastmsgBopType = By.xpath("//div[@id='toast-container']/div/div[@class='toast-title']");
	public static final By EditybuttonBopType = By.xpath("//*[@id='table2']/tbody/tr[1]/td[3]/a[1]/span/i");

	public void entervalues(String enterbopname) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
		Thread.sleep(300);
		clickOnElement(SaveButtonBopType);
		System.out.println(waitForExpectedElement(toastmsgBopType).getText());
		LoggerUtil.info("After Saving The Bop Type The Toast Message Is Getting = "
				+ waitForExpectedElement(toastmsgBopType).getText());
		String actualtoastforsave = waitForExpectedElement(toastmsgBopType).getText();
		String expectedtoastforsave = "BOP Type name saved successfully";
		soft.assertEquals(actualtoastforsave, expectedtoastforsave, "Mismatch Toast Value");
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
		Thread.sleep(2000);
		String actualvalueBop = waitForExpectedElement(fetchBopTypeValue).getText();
		String expectedvalueBop = enterbopname;
		if (actualvalueBop.equals(expectedvalueBop)) {

			LoggerUtil.info("Values Are Matched...");
			LoggerUtil.pass("Actual value = " + actualvalueBop + " || Expected Value Has Been  = " + enterbopname);
			LoggerUtil.info(" After Saving The Data User Wants To Delete The Data .... ");
			clickOnElement(deleteButtonBopType);
			driver.switchTo().alert().accept();

		} else {

			LoggerUtil.error("Value Are Mismatched ");
		}

		soft.assertAll();
	}

	public void verifysearchfunctionality(String enterbopname) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
		Thread.sleep(300);
		clickOnElement(SaveButtonBopType);
		LoggerUtil.info("Before Searching The Data User Want to Save ");
		LoggerUtil.info(" User Save The Data  = " + enterbopname);
		LoggerUtil.info(" User Going To validate Search Functionality ");
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
		Thread.sleep(2000);
		String actualvalueBop = waitForExpectedElement(fetchBopTypeValue).getText();
		String expectedvalueBop = enterbopname;
		if (actualvalueBop.equals(expectedvalueBop)) {

			LoggerUtil.info(" Search Functionality Is Working Correctky ");
			LoggerUtil.pass("Actual value = " + actualvalueBop + " || Expected Value Has Been  = " + enterbopname);
			clickOnElement(deleteButtonBopType);
			driver.switchTo().alert().accept();

		} else {
			LoggerUtil.error("Value Are Mismatched ");
		}
	}

	public static final By updatebutton = By.xpath("//button[@id='UpdateBOP']");

	public void updatebuttonfunctionality(String enterbopname, String entervalueforupdation)
			throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		LoggerUtil.info(" Step 1: Entering BOP Name → " + enterbopname);
		clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
		Thread.sleep(300);

		LoggerUtil.info(" Step 2: Clicking Save Button");
		clickOnElement(SaveButtonBopType);

		LoggerUtil.info(" Step 3: Searching Saved BOP → " + enterbopname);
		clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
		Thread.sleep(2000);

		String actualvalueBop = waitForExpectedElement(fetchBopTypeValue).getText();
		String expectedvalueBop = enterbopname;

		if (actualvalueBop.equals(expectedvalueBop)) {

			LoggerUtil.pass(" Initial Save Successful — Actual: '" + actualvalueBop + "' || Expected: '"
					+ expectedvalueBop + "'");

			LoggerUtil.info(" Step 4: Clicking Edit Button to update BOP");
			clickOnElement(EditybuttonBopType);
			Thread.sleep(3000);

			LoggerUtil.info(" Step 5: Entering Updated BOP Value → " + entervalueforupdation);
			clearAndEnterText(waitForExpectedElement(EnterBopType), entervalueforupdation);

			LoggerUtil.info(" Step 6: Clicking Update Button");
			clickOnElement(updatebutton);

			// ✅ Toast Verification
			String actualUpdatedToast = waitForExpectedElement(toastmsgBopType).getText();
			String expectedUpdatedToast = "BOP Type name updated successfully";
			LoggerUtil.info(" Toast After Update: " + actualUpdatedToast);

			soft.assertEquals(actualUpdatedToast, expectedUpdatedToast, "❌ Updated Toast Message Mismatch");
			LoggerUtil.pass(" Toast Message Verified Successfully: '" + actualUpdatedToast + "'");

			Thread.sleep(5000);

			LoggerUtil.info(" Step 7: Searching Updated BOP Value → " + entervalueforupdation);
			clearAndEnterText(waitForExpectedElement(searchvalueBop), entervalueforupdation);

			String actualUpdatedValue = waitForExpectedElement(fetchBopTypeValue).getText();
			String expectedUpdatedValue = entervalueforupdation;

			if (actualUpdatedValue.equals(expectedUpdatedValue)) {
				LoggerUtil.pass(" BOP Update Verified — Actual: '" + actualUpdatedValue + "' || Expected: '"
						+ expectedUpdatedValue + "'");
				clickOnElement(deleteButtonBopType);
				driver.switchTo().alert().accept();
			} else {
				LoggerUtil.error(" BOP Update Verification Failed — Actual: '" + actualUpdatedValue + "' || Expected: '"
						+ expectedUpdatedValue + "'");
			}

		} else {
			LoggerUtil.error(
					" Initial Save Failed — Actual: '" + actualvalueBop + "' || Expected: '" + expectedvalueBop + "'");
		}

		soft.assertAll();

	}

	public void verifyduplicatename(String enterbopname) throws InterruptedException {

	    LoggerUtil.info(" Step 1: Entering BOP Name → " + enterbopname);
	    clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
	    Thread.sleep(300);

	    LoggerUtil.info(" Step 2: Clicking Save Button");
	    clickOnElement(SaveButtonBopType);
	    Thread.sleep(4000);

	    LoggerUtil.info(" Step 3: Searching saved BOP: " + enterbopname);
	    clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
	    Thread.sleep(2000);

	    String actualvalueBop = waitForExpectedElement(fetchBopTypeValue).getText();
	    String expectedvalueBop = enterbopname;

	    String actualduplicatepopup = null;
	    String expectedDuplicatepopup = null;

	    if (actualvalueBop.equals(expectedvalueBop)) {

	        LoggerUtil.pass(" Initial Save Successful — Actual: '" + actualvalueBop + "' || Expected: '" + expectedvalueBop + "'");

	        LoggerUtil.info(" Step 4: Clicking Edit Button");
	        clickOnElement(EditybuttonBopType);
	        Thread.sleep(3000);

	        LoggerUtil.info(" Step 5: Entering Duplicate BOP Name Again → " + enterbopname);
	        clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);

	        LoggerUtil.info(" Step 6: Clicking Update Button (Expecting Duplication Validation)");
	        clickOnElement(updatebutton);

	        actualduplicatepopup = waitForExpectedElement(toastmsgBopType).getText();
	        LoggerUtil.info(" Step 7: Toast Message Captured → " + actualduplicatepopup);
	        expectedDuplicatepopup="Name already exists";
	        LoggerUtil.info(" Step 8: Toast Message Should Be → " + expectedDuplicatepopup);
	        if (actualduplicatepopup.equals(expectedDuplicatepopup)) {
	            LoggerUtil.pass(" Duplicate Popup Verified — Actual: '" + actualduplicatepopup + "' || Expected: '" + expectedDuplicatepopup + "'");
	        } else {
	            LoggerUtil.mismatch(" Duplicate Popup Mismatch — Actual: '" + actualduplicatepopup + "' || Expected: '" + expectedDuplicatepopup + "'");
	        }

	    } else {
	        LoggerUtil.mismatch(" Initial Save Failed — Actual: '" + actualvalueBop + "' || Expected: '" + expectedvalueBop + "'");
	    }
	    
	    
	    clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
	    Thread.sleep(2000);
	    clickOnElement(deleteButtonBopType);
	    driver.switchTo().alert().accept();
	
	}

	public static final By ResetButtonBopType = By.xpath("//button[@onclick='refreshdata();']");

	public void RestButton(String enterbopname) throws InterruptedException {

	    LoggerUtil.info(" Step 1: Entering BOP Name → " + enterbopname);
	    clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
	    Thread.sleep(300);

	    LoggerUtil.info(" Step 2: Clicking Save Button");
	    clickOnElement(SaveButtonBopType);
	    Thread.sleep(4000);

	    LoggerUtil.info(" Step 3: Searching Saved BOP → " + enterbopname);
	    clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
	    Thread.sleep(2000);

	    String actualsavedvalueforreset = waitForExpectedElement(fetchBopTypeValue).getText();
	    String expectedvalueforreset = enterbopname;

	    if (actualsavedvalueforreset.equals(expectedvalueforreset)) {

	        LoggerUtil.pass(" Initial Save Verified — Actual: '" + actualsavedvalueforreset + "' || Expected: '" + expectedvalueforreset + "'");

	        LoggerUtil.info(" Step 4: Clicking Edit Button");
	        clickOnElement(EditybuttonBopType);
	        Thread.sleep(2000);

	        LoggerUtil.info(" Step 5: Clicking Reset Button");
	        clickOnElement(ResetButtonBopType);
	        Thread.sleep(100);

	        LoggerUtil.info(" Step 6: Verifying that BOP input field is cleared after reset");
	        String fieldValue = waitForExpectedElement(EnterBopType).getAttribute("value");

	        if (fieldValue.isEmpty()) {
	            LoggerUtil.pass(" Reset Successful — BOP input field is empty after clicking Reset.");
	        } else {
	            LoggerUtil.mismatch(" Reset Failed — BOP input field still contains: '" + fieldValue + "'");
	        }

	    } else {
	        LoggerUtil.mismatch(" Save Verification Failed — Actual: '" + actualsavedvalueforreset + "' || Expected: '" + expectedvalueforreset + "'");
	    }
	}


	public void verifyPlaceholder() {

	    LoggerUtil.info("🟢 Step 1: Fetching placeholder attribute from BOP input field");
	    String actualplaceholder = waitForExpectedElement(EnterBopType).getAttribute("placeholder");
	    String expectedplaceholder = "Enter";

	    LoggerUtil.info("🟢 Step 2: Comparing actual vs expected placeholder values");
	    LoggerUtil.info("Actual Placeholder: '" + actualplaceholder + "' || Expected Placeholder: '" + expectedplaceholder + "'");

	    if (actualplaceholder.equals(expectedplaceholder)) {
	        LoggerUtil.pass("✅ Placeholder Matched — Actual: '" + actualplaceholder + "' || Expected: '" + expectedplaceholder + "'");
	    } else {
	        LoggerUtil.fail("❌ Placeholder Mismatch — Actual: '" + actualplaceholder + "' || Expected: '" + expectedplaceholder + "'");
	    }
	}

	public static final By Astricmark = By.xpath("//div[@id='boptype']/div/div/div/div/div/span[@class='mandatoryField']");
	
	public void verifyastrickmarkavailable() {
		
		String actualmark = waitForExpectedElement(Astricmark).getText();
		String expectedmark = "*";
		if(actualmark.equals(expectedmark)) {
			LoggerUtil.info("The Astric Mark Is = " + waitForExpectedElement(Astricmark).getText());
		 	LoggerUtil.info("User Verifying Astric mark is Available");
            LoggerUtil.pass("Astric mark is available...");   
 		}
		else {
			
			LoggerUtil.error("Astric mark is not available..");
		}
	}
	public void clickOnDataTableHeader(By headerLocator) throws InterruptedException {
	    WebElement header = waitForExpectedElement(headerLocator);

	    // Scroll to the header if needed
	  
	    Thread.sleep(500);

	    try {
	        LoggerUtil.info("Trying click via Actions class (DataTables header)");
	        new Actions(driver).moveToElement(header).click().perform();
	        LoggerUtil.pass("✅ Clicked DataTable header via Actions");
	    } catch (Exception e) {
	        LoggerUtil.error("❌ Actions click failed: " + e.getMessage());
	    }

	    Thread.sleep(1500); // Allow table to re-render
	}

	public static final By boptypecolomlist = By.xpath("//table[@id='table2']/tbody/tr/td[2]");
	public static final By ClickHeaderBopTypeColom = By.xpath("//table[@id='table2']/thead/tr/th[2]");
	public void verifysortingfunctionality() throws InterruptedException {
	    LoggerUtil.info("🟢 Step 1: Clicking BOP Type column header using JavaScript to trigger sort");
	    
	    clickOnDataTableHeader(ClickHeaderBopTypeColom);
	    


	    LoggerUtil.info("🟢 Step 2: Waiting for table to update after sorting");
	    Thread.sleep(2000); // or use WebDriverWait if you have a refresh indicator

	    LoggerUtil.info("🟢 Step 3: Fetching all BOP Type column values");
	    List<WebElement> columnElements = driver.findElements(boptypecolomlist);
	    List<String> actualValues = new ArrayList<>();
	    for (WebElement ele : columnElements) {
	        actualValues.add(ele.getText().trim());
	    }

	    LoggerUtil.info("🔎 Actual UI Values: " + actualValues);

	    LoggerUtil.info("🟢 Step 4: Sorting expected list in case-sensitive descending order");
	    List<String> expectedSortedList = new ArrayList<>(actualValues);
	    expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed());


	    LoggerUtil.info("🔎 Expected Sorted Order: " + expectedSortedList);

	    if (actualValues.equals(expectedSortedList)) {
	        LoggerUtil.pass("✅ BOP Type column sorted in descending order as expected.");
	    } else {
	        LoggerUtil.mismatch("❌ Sorting mismatch — UI did not sort as expected after header click.");
	    }
  
	}

          public void VerifySucessfullydeletedData(String enterbopname) throws InterruptedException {
        	  
        	  clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
        	  Thread.sleep(2000);
        	  clickOnElement(SaveButtonBopType);
        	  Thread.sleep(1000);
        	  clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
        	  Thread.sleep(5000);
        	  clickOnElement(deleteButtonBopType);
        	  driver.switchTo().alert().accept();
        	  LoggerUtil.info("The Deletion popup message is = "+waitForExpectedElement(toastmsgBopType).getText());
        	  String actualdeletionpopup = waitForExpectedElement(toastmsgBopType).getText();
        	  String expectedDeletionpopup = "BOP Type Successfully Deleted";
        	  Assert.assertEquals(actualdeletionpopup, expectedDeletionpopup);
        	  
        	  
        	  
          }
	
            public static final By totastforpriventiondeletion = By.xpath("//div[@class='toast toast-error']/div[2]");
            public void verifyPreventionDeletion() throws InterruptedException {

                LoggerUtil.info(" Step 1: Searching for BOP Type with dependencies → 'Bolt'");
                clearAndEnterText(waitForExpectedElement(searchvalueBop), "Bolt");
                Thread.sleep(5000);

                LoggerUtil.info(" Step 2: Clicking Delete button");
                clickOnElement(deleteButtonBopType);

                LoggerUtil.info(" Step 3: Accepting browser alert for delete confirmation");
                driver.switchTo().alert().accept();

                LoggerUtil.info(" Step 4: Capturing toast message after deletion attempt");
                String actualPreventionToast = waitForExpectedElement(totastforpriventiondeletion).getText();
                String expectedPreventionToast = "Unable to delete as BOP Type has dependent records.!";

                LoggerUtil.info(" Actual Toast Message: '" + actualPreventionToast + "'");
                LoggerUtil.info(" Expected Toast Message: '" + expectedPreventionToast + "'");

                if (actualPreventionToast.equals(expectedPreventionToast)) {
                    LoggerUtil.pass(" Prevention Deletion Verified — Toast Message Matched.");
                } else {
                    LoggerUtil.fail(" Toast Mismatch — Actual: '" + actualPreventionToast + "' || Expected: '" + expectedPreventionToast + "'");
                }
            }

            
            public static final By fetchingdataWholeData = By.xpath("//table[@id='table2']/tbody/tr");
            public void verifysearchbehavioandconfirmafteRemovesearchboxPageShouldBeLoadFully(String enterbopname) throws InterruptedException {

                LoggerUtil.info(" Step 1: Fetching full row count before search");
                List<WebElement> fullPageRowsBeforeSearch = driver.findElements(fetchingdataWholeData);
                int originalRowCount = fullPageRowsBeforeSearch.size();
                LoggerUtil.info("Total Rows Before Search: " + originalRowCount);

                LoggerUtil.info(" Step 2: Creating new entry with BOP Name → " + enterbopname);
                clearAndEnterText(waitForExpectedElement(EnterBopType), enterbopname);
                Thread.sleep(2000);
                clickOnElement(SaveButtonBopType);
                Thread.sleep(1000);

                LoggerUtil.info(" Step 3: Searching the new BOP Name");
                clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
                Thread.sleep(3000);

                String actualValue = waitForExpectedElement(fetchBopTypeValue).getText();
                String expectedValue = enterbopname;

                if (actualValue.equals(expectedValue)) {
                    LoggerUtil.pass(" Search functionality working — Actual: '" + actualValue + "' || Expected: '" + expectedValue + "'");
                } else {
                    LoggerUtil.error(" Search mismatch — Actual: '" + actualValue + "' || Expected: '" + expectedValue + "'");
                }

                LoggerUtil.info(" Step 4: Clearing the search box to reload full data");
                WebElement searchBox = waitForExpectedElement(searchvalueBop);
                searchBox.clear();
                searchBox.sendKeys(Keys.BACK_SPACE); 


                LoggerUtil.info(" Step 5: Fetching row count after clearing search box");
                List<WebElement> rowsAfterClearingSearch = driver.findElements(fetchingdataWholeData);
                int finalRowCount = rowsAfterClearingSearch.size();

                LoggerUtil.info("Row Count After Clearing Search: " + finalRowCount);

                if (finalRowCount == originalRowCount + 1) {
                    LoggerUtil.pass(" Page reloaded correctly — All rows visible after clearing search (newly added row included).");
                } else {
                    LoggerUtil.mismatch(" Page did not reload fully — Expected rows: " + (originalRowCount + 1) + ", but found: " + finalRowCount);
                }
                
                
                clearAndEnterText(waitForExpectedElement(searchvalueBop), enterbopname);
                Thread.sleep(3000);
                clickOnElement(deleteButtonBopType);
                driver.switchTo().alert().accept();
                
                
                
                
                
            }
            
            
            
            
            
            
            public void verifyspecialcharacterRestriction() throws InterruptedException {

                LoggerUtil.info(" Step 1: Entering BOP Type with special characters → '@$!mjdh'");
                clearAndEnterText(waitForExpectedElement(EnterBopType), "@$!mjdh");
                Thread.sleep(200);

                LoggerUtil.info(" Step 2: Clicking Save Button");
                clickOnElement(SaveButtonBopType);

                String actualPopup = waitForExpectedElement(toastmsgBopType).getText();
                String expectedPopup = "Invalid Bop Type Name.!";

                LoggerUtil.info(" Captured Toast Message: '" + actualPopup + "'");
                LoggerUtil.info(" Expected Toast Message: '" + expectedPopup + "'");

                if (actualPopup.equals(expectedPopup)) {
                    LoggerUtil.pass(" Special character restriction validated successfully — toast matched.");
                } else {
                    LoggerUtil.error(" Toast mismatch — Actual: '" + actualPopup + "' || Expected: '" + expectedPopup + "'");
                }

                LoggerUtil.info(" Step 3: Attempting cleanup — searching and deleting invalid BOP if it was saved");
                clearAndEnterText(waitForExpectedElement(searchvalueBop), "@$!mjdh");
                Thread.sleep(2000);
                clickOnElement(deleteButtonBopType);
                driver.switchTo().alert().accept();
                LoggerUtil.pass(" Cleanup executed — delete triggered on special-character BOP type (if existed).");
            }

            
            
            
            
            
            
            

}
