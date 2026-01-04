package com.Pages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Base;
import com.helper.LoggerUtil;

public class OHPMaster_PageClass extends Base {

	
	
	Base base = new Base();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	
	
	//////////////////////////////////////////////////////Locators//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final By EnterPrefixValue = By.xpath("//input[@id='Prefix']");

	public static final By clickingRightHandsThreeOptionsFronUi = By
			.xpath("//div[@class='col-xl-4 viewAllOHPhide']//div[@class='accordion-item']/h2/button/div/p");

	public static final By ListCheckboxesRmModuleAndName = By.xpath("//div[@id='collapsenoIconOne']/descendant::input");

	public static final By ClickingBusinessSegDropdown = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/button");

	public static final By EneterSearchValueForBusinessSegMentForSupplier = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/descendant::input[@placeholder='Search']");

	public static final By FetchingNameListBusinessSeg = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/div/button/span/label");

	public static final By fechingCheckboxBusinesSeg = By
			.xpath("//select[@id='BusinessSegments']/following-sibling::div/div/button/span/input");

	public static final By EnetrCustomernameInSearchBox = By
			.xpath("//div[@id='collapsenoIconThree']/descendant::input[@id='myInputCustomer']");

	public static final By FetchinNameListCustomerName = By.xpath("//table[@id='rmCustomer']//td");

	public static final By FetchingCustomerCheckboxlist = By
			.xpath("//table[@id='rmCustomer']//input[@type='checkbox' and contains(@class,'chkCustomer')]");

	public static final By EnterCustomerNameSearchBox = By.xpath("//input[@id='myInputCustomer']");

	public static final By ClckingSaveButton = By.xpath("//button[@id='button']");

	public static final By clickignUpdateBtn = By.xpath("//button[@value='processSave']");
	
	public static final By ClickingViewBtn = By.xpath("//button[@id='btnView']");

	public static final By toastLocator = By
			.xpath("//*[@id='toast-container']/div/div[2]");

	public static final By EnterSearchFilter = By.xpath("//div[@id='example1_wrapper']/descendant::input");

	public static final By FetchingTableRowsLocators = By.xpath("//table[@id='example1']/tbody/tr");

	public static final By ClickingEditBtn = By.xpath("//table[@id='example1']/tbody/tr/td/a/span/i");

	public static final By clickingSaveAsNewBtn = By.xpath("//input[@id='btnSaveAsNew']");
	
	
	public static final By clickingCascadingHeading = By.xpath("//div[@id='accordioniconLeftExample']/descendant::div[normalize-space(text())='Apply Cascading']");
	
	public static final By clickingBackButtonViewPage = By.xpath("//button[@id='btnclose']");
	
	public static final By clickingExportAndImportBtnFirstStepBtn = By.xpath("//button[@id='tab1Export']");
	
	public static final By clickingExportForDownload = By.xpath("//button[@id='exportsss']");
	
	public static  final By clickingResetButton = By.xpath("//button[@id='processReset']");
	
	public static final By clickingDeleteButton = By.xpath("//table[@id='example1']//a[contains(@onclick,'DeleteOhp')]");
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public static By getCellInputByRowAndColumn(String rowName, String columnName) {
		return By.xpath("//table//tr[td[normalize-space(text())='" + rowName + "']]"
				+ "//td[count(//table//th[normalize-space(text())='" + columnName
				+ "']/preceding-sibling::th)+1]//input");
	}

	public static By getPercentageCheckboxByRowAndColumn(String rowName, String columnName) {
		return By.xpath("//table//tr[td[normalize-space(text())='" + rowName + "']]"
				+ "//td[count(//table//th[normalize-space(text())='" + columnName + "']/preceding-sibling::th)+1]"
				+ "//div[contains(@class,'CustomCheckBox')]//input[@type='checkbox']");
	}

	public static By getToggleCheckboxByRow(String rowName) {
		return By.xpath("//table//tr[td[normalize-space(text())='" + rowName + "']]"
				+ "//td[count(//table//th[normalize-space(text())='Gross RM appl.']/preceding-sibling::th)+1]"
				+ "//input[@type='checkbox']");
	}

//////////////////////////////////////////////Toggle And Percentage Generic Method ////////////////////////////////

	public void clickToggleAndPercentage(String rowName, String columnName) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

// Step 1: Toggle ON
		WebElement toggle = driver.findElement(getToggleCheckboxByRow(rowName));
		js.executeScript("arguments[0].click();", toggle);
		LoggerUtil.info("Toggle enabled for Row=" + rowName);

		Thread.sleep(4000);
// Step 2: Percentage checkbox
		WebElement percentageCheckbox = driver.findElement(getPercentageCheckboxByRowAndColumn(rowName, columnName));
		js.executeScript("arguments[0].click();", percentageCheckbox);
		LoggerUtil.info("Percentage checkbox clicked for Row=" + rowName + ", Column=" + columnName);
	}

////////////////////////////////////////////////////////////////  Right Hands Threee Options  ////////////////////////////////////////////////////////////////////////////////////	

	public static  void ClickingOptionRightHandThreeOptions(String expectedName) {
		try {
			List<WebElement> optionsNameList = driver.findElements(clickingRightHandsThreeOptionsFronUi);

			if (optionsNameList.isEmpty()) {
				LoggerUtil.error("No options found in Right Hand Three Options UI");
			} else {
				boolean clicked = false;
				for (WebElement option : optionsNameList) {
					String actualName = option.getText().trim();

					if (actualName.equalsIgnoreCase(expectedName)) {
						option.click();
						LoggerUtil.info("Clicked on Right Hand Option: " + actualName);
						clicked = true;
						break; // break after clicking
					}
				}
				if (!clicked) {
					LoggerUtil.error("Expected option not found: " + expectedName);
				}
			}
		} catch (Exception e) {
			LoggerUtil.error("Error while clicking Right Hand Three Options: " + e.getMessage());
		}
	}

////////////////////////////////////////////////////////////CheckBoxesGenricforRmModule/////////////////////////////////////////////////////////////	
	public void clickingCheckRmModules(String modulename1, String modulename2, String modulename3) {
		try {
			List<WebElement> checkboxes = driver.findElements(
					By.xpath("//div[@id='suplierListRM']//input[@type='checkbox' and contains(@class,'chkRm')]"));

			if (checkboxes.isEmpty()) {
				LoggerUtil.error("No RM Module checkboxes found!");
				return;
			}

			int clickedCount = 0;

			for (WebElement checkbox : checkboxes) {
				String actualName = checkbox.getAttribute("data-rmname").trim();

				if (actualName.equalsIgnoreCase(modulename1) || actualName.equalsIgnoreCase(modulename2)
						|| actualName.equalsIgnoreCase(modulename3)) {
					if (!checkbox.isSelected()) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
						LoggerUtil.info("Clicked on RM Module checkbox: " + actualName);
					} else {
						LoggerUtil.info("Checkbox already selected: " + actualName);
					}

					clickedCount++;

					if (clickedCount == 3) {
						break;
					}
				}
			}

			if (clickedCount < 2) {
				LoggerUtil.error("Could not find both modules. Found only " + clickedCount);
			}

		} catch (Exception e) {
			LoggerUtil.error("Error while clicking RM Module checkboxes: " + e.getMessage());
		}
	}
////////////////////////////////////////////////////Entering Value in CasCading//////////////////////////////////////	
	
	public void enterValueInCascadingCell(String rowName, String colName, String value) {
	    try {
	        WebElement cellInput = waitForExpectedElement(getCellInputByRowAndColumnForCasCading(rowName, colName));
	        clearAndEnterText(cellInput, value);
	        LoggerUtil.pass("Entered value '" + value + "' in Row='" + rowName + "', Column='" + colName + "' (Cascading)");
	    } catch (Exception e) {
	        LoggerUtil.error("Failed to enter value in Row='" + rowName + "', Column='" + colName + "' (Cascading) → " + e.getMessage());
	    }
	}



	// Generic locator for a cell input based on Row Name & Column Name
	public By getCellInputByRowAndColumnForCasCading(String rowName, String colName) {
	    String xpath = "//table[@id='cascadingtable']//tr[td[normalize-space()='" + rowName + "']]"
	                 + "/td[count(//table[@id='cascadingtable']//th[normalize-space()='" + colName + "']/preceding-sibling::th)+1]"
	                 + "//input";
	    return By.xpath(xpath);
	}

	
	
	
/////////////////////////////////////////////////////BusinessSegMent Checkbox////////////////////////
	public void VerifyClickingBusinessSegCheckbox(String searchBusinessSegName) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(EneterSearchValueForBusinessSegMentForSupplier),
				searchBusinessSegName);
		Thread.sleep(7000);

		List<WebElement> businessSegNames = driver.findElements(FetchingNameListBusinessSeg);
		List<WebElement> businessSegCheckboxes = driver.findElements(fechingCheckboxBusinesSeg);

		if (businessSegNames.size() != businessSegCheckboxes.size()) {
			LoggerUtil.error("Mismatch in Business Segment names and checkboxes count!");
			return;
		}

		boolean clicked = false;

		for (int i = 0; i < businessSegNames.size(); i++) {
			String actualName = businessSegNames.get(i).getText().trim();

			if (actualName.equalsIgnoreCase(searchBusinessSegName)) {
				WebElement checkbox = businessSegCheckboxes.get(i);

				if (!checkbox.isSelected()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
					LoggerUtil.info("Clicked Business Segment checkbox: " + actualName);
				} else {
					LoggerUtil.info("Checkbox already selected for Business Segment: " + actualName);
				}

				clicked = true;
				break;
			}
		}

		if (!clicked) {
			LoggerUtil.error("Business Segment not found: " + searchBusinessSegName);
		}
	}

/////////////////////////////////////////////////////////Customer Name And CheckBoxes/////////////////////////////////////////////////		
	public void VerifyClickingCustomerCheckboxes(String expectedCustomerName) {
		try {
			clearAndEnterText(waitForExpectedElement(EnterCustomerNameSearchBox), expectedCustomerName);
			Thread.sleep(2000); // thoda wait do after search

			List<WebElement> nameCells = driver.findElements(FetchinNameListCustomerName);
			List<WebElement> checkboxes = driver.findElements(FetchingCustomerCheckboxlist);

			if (nameCells.isEmpty() || checkboxes.isEmpty()) {
				LoggerUtil.error("No customers or checkboxes found!");
				return;
			}

			boolean found = false;

			for (int i = 0; i < nameCells.size(); i++) {
				String actualName = nameCells.get(i).getText().trim();

				if (actualName.equalsIgnoreCase(expectedCustomerName)) {
					WebElement checkbox = checkboxes.get(i);

					if (!checkbox.isSelected()) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
						LoggerUtil.info("Clicked checkbox for customer: " + actualName);
					} else {
						LoggerUtil.info("Checkbox already selected for customer: " + actualName);
					}

					found = true;
					break;
				}
			}

			if (!found) {
				LoggerUtil.error("Customer not found in list: " + expectedCustomerName);
			}
		} catch (Exception e) {
			LoggerUtil.error("Error while verifying customer checkboxes: " + e.getMessage());
		}
	}
////////////////////////////////////////////////////////////////////SearchBox//////////////////////////////////////////////////////////////////////////////////////////////

	public void VerifySearchFilter(String EnterSearchValue, String ExpectedPrefix, String ExpectedBusinessSegment,
	        String ExpectedCustname) {
	    try {
	        LoggerUtil.info("Step 1: Entering search value: " + EnterSearchValue);
	        clearAndEnterText(waitForExpectedElement(EnterSearchFilter), EnterSearchValue);

	        LoggerUtil.info("Step 2: Fetching all rows from the data table...");
	        List<WebElement> Rows = driver.findElements(FetchingTableRowsLocators);

	        if (Rows.isEmpty()) {
	            LoggerUtil.fail("No rows found in the table after entering search value: " + EnterSearchValue);
	            return;
	        }

	        for (int i = 0; i < Rows.size(); i++) {
	            WebElement Row = Rows.get(i);
	            List<WebElement> Coloumn = Row.findElements(By.tagName("td"));

	            String actualPrefix = Coloumn.get(1).getText().trim();
	            String FetchingSupplierName = Coloumn.get(2).getText().trim();
	            String fetchingBusinessSegment = Coloumn.get(3).getText().trim();
	            String FetchingCustomername = Coloumn.get(4).getText().trim();

	            LoggerUtil.info("Row " + (i + 1) + " → Prefix: " + actualPrefix + ", Supplier: " + FetchingSupplierName
	                    + ", BusinessSegment: " + fetchingBusinessSegment + ", Customer: " + FetchingCustomername);

	            try {
	                if (actualPrefix.contains(ExpectedPrefix)) {
	                    LoggerUtil.pass("Row " + (i + 1) + " - Prefix matched successfully. Expected: " + ExpectedPrefix
	                            + ", Found: " + actualPrefix);
	                } else {
	                    LoggerUtil.fail("Row " + (i + 1) + " - Prefix mismatch. Expected: " + ExpectedPrefix
	                            + ", Found: " + actualPrefix);
	                }
	            } catch (Exception e) {
	                LoggerUtil.error("Error validating Prefix in row " + (i + 1) + ": " + e.getMessage());
	            }

	            try {
	                LoggerUtil.info(" Supplier Name = " + FetchingSupplierName);
	            } catch (Exception e) {
	                LoggerUtil.fail("Supplier name is not showing");
	            }

	            try {
	                if (fetchingBusinessSegment.contains(ExpectedBusinessSegment)) {
	                    LoggerUtil.pass("Row " + (i + 1) + " - Business Segment matched successfully. Expected: "
	                            + ExpectedBusinessSegment + ", Found: " + fetchingBusinessSegment);
	                } else {
	                    LoggerUtil.fail("Row " + (i + 1) + " - Business Segment mismatch. Expected: "
	                            + ExpectedBusinessSegment + ", Found: " + fetchingBusinessSegment);
	                }
	            } catch (Exception e) {
	                LoggerUtil.error("Error validating Business Segment in row " + (i + 1) + ": " + e.getMessage());
	            }

	            try {
	                if (FetchingCustomername.contains(ExpectedCustname)) {
	                    LoggerUtil.pass("Row " + (i + 1) + " - Customer matched successfully. Expected: "
	                            + ExpectedCustname + ", Found: " + FetchingCustomername);

	                   
	                   
	                    LoggerUtil.pass("Clicked Edit button successfully for Row " + (i + 1));

	                    Thread.sleep(3000);
	                } else {
	                    LoggerUtil.fail("Row " + (i + 1) + " - Customer mismatch. Expected: " + ExpectedCustname
	                            + ", Found: " + FetchingCustomername);
	                }
	            } catch (Exception e) {
	                LoggerUtil.error("Error validating Customer in row " + (i + 1) + ": " + e.getMessage());
	            }
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Unexpected error in VerifySearchFilter: " + e.getMessage());
	    }
	}

////////////////////////////Fetching All Saved Data From Ui/////////////////////////////////////////////////////////////
	
	
	public void AfterClickingEditButtonAllDataAsItIsInParticularUi(
	        String rowRejection, String colRm,
	        String rowOverhead, String colRm2, String cellValOverhead,
	        String rowICC, String rowProfit, String colBOP, String ExpectedName,
	        String ExpectedValueRejectionAndRm, String ExpectedRmAndOverhead,
	        String ExpectedRowIccAndColoumnRm, String ExpectedRowProfitAndBopColoumn) throws InterruptedException {

		Thread.sleep(3000);
	    String ActualPrefixName = waitForExpectedElement(EnterPrefixValue).getAttribute("value").trim();
	    if (ActualPrefixName.equals(ExpectedName)) {
	        LoggerUtil.pass("Prefix value fetched correctly. Expected: " + ExpectedName + ", Found: " + ActualPrefixName);
	    } else {
	        LoggerUtil.error("Prefix mismatch. Expected: " + ExpectedName + ", Found: " + ActualPrefixName);
	    }

	    String ActualRowRejectionAndrm = waitForExpectedElement(getCellInputByRowAndColumn(rowRejection, colRm)).getAttribute("value");
	    String ActualOverheadAndRm = waitForExpectedElement(getCellInputByRowAndColumn(rowOverhead, colRm2)).getAttribute("value");
	    String ActualRowICCAndColRm = waitForExpectedElement(getCellInputByRowAndColumn(rowICC, colRm)).getAttribute("value");
	    String ActualProfitAndBopCellColoumn = waitForExpectedElement(getCellInputByRowAndColumn(rowProfit, colBOP)).getAttribute("value");

	    try {
	        BigDecimal RowRejectionAndrm = new BigDecimal(ActualRowRejectionAndrm).setScale(3, RoundingMode.HALF_UP);
	        BigDecimal RejectionAndRmCell = new BigDecimal(ExpectedValueRejectionAndRm).setScale(3, RoundingMode.HALF_UP);
	        if (RowRejectionAndrm.equals(RejectionAndRmCell)) {
	            LoggerUtil.pass("Rejection + RM matched. Expected: " + RejectionAndRmCell + ", Found: " + RowRejectionAndrm);
	        } else {
	            LoggerUtil.error("Rejection + RM mismatch. Expected: " + RejectionAndRmCell + ", Found: " + RowRejectionAndrm);
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Error parsing Rejection + RM values: " + e.getMessage());
	    }

	    try {
	        BigDecimal RowOverheadAndRm = new BigDecimal(ActualOverheadAndRm).setScale(3, RoundingMode.HALF_UP);
	        BigDecimal RmAndOverheadcell = new BigDecimal(ExpectedRmAndOverhead).setScale(3, RoundingMode.HALF_UP);
	        if (RowOverheadAndRm.equals(RmAndOverheadcell)) {
	            LoggerUtil.pass("Overhead + RM matched. Expected: " + RmAndOverheadcell + ", Found: " + RowOverheadAndRm);
	        } else {
	            LoggerUtil.error("Overhead + RM mismatch. Expected: " + RmAndOverheadcell + ", Found: " + RowOverheadAndRm);
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Error parsing Overhead + RM values: " + e.getMessage());
	    }

	    try {
	        BigDecimal RowIccAndColoumn = new BigDecimal(ActualRowICCAndColRm).setScale(3, RoundingMode.HALF_UP);
	        BigDecimal IccRmCell = new BigDecimal(ExpectedRowIccAndColoumnRm).setScale(3, RoundingMode.HALF_UP);
	        if (RowIccAndColoumn.equals(IccRmCell)) {
	            LoggerUtil.pass("ICC + RM matched. Expected: " + IccRmCell + ", Found: " + RowIccAndColoumn);
	        } else {
	            LoggerUtil.error("ICC + RM mismatch. Expected: " + IccRmCell + ", Found: " + RowIccAndColoumn);
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Error parsing ICC + RM values: " + e.getMessage());
	    }

	    try {
	        BigDecimal RowProfitAndBopColoumnVal = new BigDecimal(ActualProfitAndBopCellColoumn).setScale(3, RoundingMode.HALF_UP);
	        BigDecimal RowProfitAndBopCell = new BigDecimal(ExpectedRowProfitAndBopColoumn).setScale(3, RoundingMode.HALF_UP);
	        if (RowProfitAndBopColoumnVal.equals(RowProfitAndBopCell)) {
	            LoggerUtil.pass("Profit + BOP matched. Expected: " + RowProfitAndBopCell + ", Found: " + RowProfitAndBopColoumnVal);
	        } else {
	            LoggerUtil.error("Profit + BOP mismatch. Expected: " + RowProfitAndBopCell + ", Found: " + RowProfitAndBopColoumnVal);
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Error parsing Profit + BOP values: " + e.getMessage());
	    }
	}

///////////////////////////////////////////////Fetching Toggle Clicked Or not From Ui After Saving Data///////////////////////////////////////////
	
	public void checkToggleAndPercentageAreSavedAsItIs(String rowName) {
	    try {
	        // Step 1: Locate toggle
	        WebElement toggle = driver.findElement(getToggleCheckboxByRow(rowName));

	        // Step 2: Fetch value attribute
	        String actualToggleForRow = toggle.getAttribute("value");
	        LoggerUtil.info("Toggle attribute value for Row=" + rowName + " is: " + actualToggleForRow);

	        // Step 3: Decide toggle state
	        boolean isToggleOn = "true".equalsIgnoreCase(actualToggleForRow) 
	                          || "on".equalsIgnoreCase(actualToggleForRow) 
	                          || "1".equals(actualToggleForRow);

	        // Step 4: Log result
	        if (isToggleOn) {
	            LoggerUtil.pass("Toggle is ENABLED and saved correctly for Row=" + rowName);
	        } else {
	            LoggerUtil.fail("Toggle is DISABLED or not saved correctly for Row=" + rowName);
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error while verifying toggle for Row=" + rowName + " → " + e.getMessage());
	    }
	}

///////////////////////////////////////////////////	
	
	public void clickToggleDisable(String rowName) {
	    try {
	        // Step 1: Locate toggle
	        WebElement toggle = driver.findElement(getToggleCheckboxByRow(rowName));

	        // Step 2: Fetch value attribute
	        String actualToggleForRow = toggle.getAttribute("value");
	        LoggerUtil.info("Toggle attribute value for Row=" + rowName + " is: " + actualToggleForRow);

	        // Step 3: Decide toggle state
	        boolean isToggleOn = "false".equalsIgnoreCase(actualToggleForRow) 
	                          || "off".equalsIgnoreCase(actualToggleForRow) 
	                          || "0".equals(actualToggleForRow);

	        // Step 4: Log result
	        if (isToggleOn) {
	            LoggerUtil.pass("Toggle is DISABLED and saved correctly for Row=" + rowName);
	        } else {
	            LoggerUtil.fail("Toggle is ENABLED or not saved correctly for Row=" + rowName);
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error while verifying toggle for Row=" + rowName + " → " + e.getMessage());
	    }
	}
	
	
	
	
	
	///////////////////////////////////////////After Clicking Edit Button Finding Cascading Value From Table Are Saved Sucessfully ///////////////////////////////////////////////////////////
	
	
	public void FetchingCascadingValueFromUiHasBeenSavedOrNot(
	        String rowName,
	        String colName,
	        String EnteringValueWhileSaving) throws InterruptedException {

	    try {
	        Thread.sleep(2000);

	        WebElement cellInput = waitForExpectedElement(getCellInputByRowAndColumnForCasCading(rowName, colName));
	        String actualCascadingValue = cellInput.getAttribute("value").trim();

	        BigDecimal FetchingActualValue = new BigDecimal(actualCascadingValue).setScale(3, RoundingMode.HALF_UP);
	        BigDecimal ExpectedValue = new BigDecimal(EnteringValueWhileSaving).setScale(3, RoundingMode.HALF_UP);

	        if (FetchingActualValue.compareTo(ExpectedValue) == 0) {
	            LoggerUtil.pass("Cascading value matched → Row='" + rowName + "', Column='" + colName
	                    + "', Expected='" + ExpectedValue + "', Found='" + FetchingActualValue + "'");
	        } else {
	            LoggerUtil.mismatch("Cascading value mismatch → Row='" + rowName + "', Column='" + colName
	                    + "', Expected='" + ExpectedValue + "', Found='" + FetchingActualValue + "'");
	        }
	    } catch (Exception e) {
	        LoggerUtil.error("Error while verifying cascading value → Row='" + rowName + "', Column='" + colName
	                + "' → " + e.getMessage());
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void EnteringValueForAdditionOfNorms(
	        String prefixValue, String rowRejection, String colRm, String cellValRejection,
	        String rowOverhead, String colRm2, String cellValOverhead,
	        String rowICC, String cellValICC,
	        String rowProfit, String colBOP, String cellValProfit,
	        String modulename1, String modulename2, String modulename3,
	        String searchBusinessSegName, String expectedCustomerName) throws InterruptedException {

	    try {
	        // 1. Prefix field fill
	        clearAndEnterText(waitForExpectedElement(EnterPrefixValue), prefixValue);
	        LoggerUtil.info("Entered Prefix Value: " + prefixValue);

	        // 2. Rejection + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowRejection, colRm)), cellValRejection);
	        LoggerUtil.info("Entered value '" + cellValRejection + "' in Row=" + rowRejection + ", Column=" + colRm);
	        Thread.sleep(2000);

	        // 3. Overhead + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowOverhead, colRm2)), cellValOverhead);
	        LoggerUtil.info("Entered value '" + cellValOverhead + "' in Row=" + rowOverhead + ", Column=" + colRm2);

	        // 4. ICC + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowICC, colRm)), cellValICC);
	        LoggerUtil.info("Entered value '" + cellValICC + "' in Row=" + rowICC + ", Column=" + colRm);

	        // 5. Profit + BOP cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowProfit, colBOP)), cellValProfit);
	        LoggerUtil.info("Entered value '" + cellValProfit + "' in Row=" + rowProfit + ", Column=" + colBOP);

	        // 6. Click Toggle + Percentage for Rejection + RM
	        clickToggleAndPercentage("Rejection", "RM");

	        // 7. Click Toggle + Percentage for ICC + RM
	        clickToggleAndPercentage("ICC", "RM");

	        // 8. Click RM Module option
	        ClickingOptionRightHandThreeOptions("RM Module");
	        clickingCheckRmModules(modulename1, modulename2, modulename3);

	        // 9. Click Supplier → Business Segment
	        ClickingOptionRightHandThreeOptions("Supplier");
	        Thread.sleep(2000);
	        clickOnElement(ClickingBusinessSegDropdown);
	        VerifyClickingBusinessSegCheckbox(searchBusinessSegName);
             Thread.sleep(4000);
	        // 10. Supplier → Customer
	        ClickingOptionRightHandThreeOptions("Supplier");
	        Thread.sleep(2000);
	        ClickingOptionRightHandThreeOptions("Customer");
	        Thread.sleep(5000);
	        VerifyClickingCustomerCheckboxes(expectedCustomerName);

	        // 11. Save
	        clickOnElement(ClckingSaveButton);
	        LoggerUtil.pass("Clicked Save button successfully");

	        Thread.sleep(4000);
	       
	        clickOnElement(ClickingViewBtn);
	        
	        VerifySearchFilter(prefixValue,prefixValue,searchBusinessSegName,expectedCustomerName);
	        
	        Thread.sleep(2000);
	   
	        clickOnElement(ClickingEditBtn);
	        
	        Thread.sleep(2000);
	        
	        AfterClickingEditButtonAllDataAsItIsInParticularUi(
	        	    rowRejection, colRm, 
	        	    rowOverhead, colRm2, cellValOverhead, 
	        	    rowICC, rowProfit, colBOP, 
	        	    prefixValue,                // Expected prefix value
	        	    cellValRejection, 
	        	    cellValOverhead, 
	        	    cellValICC, 
	        	    cellValProfit
	        	);

	        
	       
	        
	        
	        
	        Thread.sleep(5000);
	    } catch (Exception e) {
	        LoggerUtil.error("Error while executing EnteringValueForAdditionOfNorms: " + e.getMessage());
	        throw e; // rethrow so test will fail properly
	    }
	}

	
	public void VerifyUpdatedValueOnPrefix(
	        String prefixValue, 
	        String searchBusinessSegName, 
	        String expectedCustomerName,
	        String rowRejection, String colRm, String cellValRejection,
	        String rowOverhead, String colRm2, String cellValOverhead,
	        String rowICC, String cellValICC,
	        String rowProfit, String colBOP, String cellValProfit
	) throws InterruptedException {
	    
	    // Step 1: Check existing toggle state
	    checkToggleAndPercentageAreSavedAsItIs("Rejection");
	    checkToggleAndPercentageAreSavedAsItIs("ICC");

	    // Step 2: Disable Rejection toggle and update
	    LoggerUtil.info("User trying to click Rejection Row Toggle Off and then Update");
	    clickToggleAndPercentage("Rejection", "RM");
	    Thread.sleep(2000);

	    clickOnElement1(clickignUpdateBtn);
	    LoggerUtil.pass("Clicked Update button successfully");

	    Thread.sleep(3000);

	    clickOnElement(ClickingViewBtn);
	    LoggerUtil.pass("Clicked View button successfully");

	    // Step 3: Verify row in search results
	    VerifySearchFilter(prefixValue, prefixValue, searchBusinessSegName, expectedCustomerName);
	    Thread.sleep(2000);

	    // Step 4: Open Edit again
	    clickOnElement(ClickingEditBtn);
	    LoggerUtil.pass("Clicked Edit button again");
	    Thread.sleep(2000);

	    // Step 5: Verify all values in Edit mode
	    AfterClickingEditButtonAllDataAsItIsInParticularUi(
	        rowRejection, colRm, 
	        rowOverhead, colRm2, cellValOverhead, 
	        rowICC, rowProfit, colBOP, 
	        prefixValue,          // Expected prefix value
	        cellValRejection, 
	        cellValOverhead, 
	        cellValICC, 
	        cellValProfit
	    );

	    // Step 6: Toggle disable again for cleanup
	    clickToggleDisable("Rejection");
	    LoggerUtil.pass("Disabled Rejection toggle again for reset");
	}

	
	
	
	
	public void VerifySaveAsNewValueOnPrefix(
	        String EnetringPrefixValueForSaveAsNew,
	        
	       
	        String searchBusinessSegName, 
	        String expectedCustomerName,
	        String rowRejection, String colRm, String cellValRejection,
	        String rowOverhead, String colRm2, String cellValOverhead,
	        String rowICC, String cellValICC,
	        String rowProfit, String colBOP, String cellValProfit
	) throws InterruptedException {
	    try {
	        // Step 1: Verify toggles are ON initially
	        checkToggleAndPercentageAreSavedAsItIs("Rejection");
	        checkToggleAndPercentageAreSavedAsItIs("ICC");

	        // Step 2: Disable Rejection toggle
	        LoggerUtil.info("Step 2: User trying to click Rejection Row Toggle Off");
	        clickToggleAndPercentage("Rejection", "RM");
	        Thread.sleep(2000);

	        // Step 3: Enter new Prefix for Save As New
	        clearAndEnterText(waitForExpectedElement(EnterPrefixValue), EnetringPrefixValueForSaveAsNew);
	        LoggerUtil.pass("Entered Prefix value for Save As New: " + EnetringPrefixValueForSaveAsNew);

	        // Step 4: Click Save As New
	        clickOnElement1(clickingSaveAsNewBtn);
	        LoggerUtil.pass("Clicked Save As New button successfully");
	        Thread.sleep(3000);

	        // Step 5: Click View to reload table
	        clickOnElement(ClickingViewBtn);
	        LoggerUtil.pass("Clicked View button successfully");
	        Thread.sleep(2000);

	        // Step 6: Verify newly saved row in table
	        VerifySearchFilter(
	                EnetringPrefixValueForSaveAsNew, 
	                EnetringPrefixValueForSaveAsNew, 
	                searchBusinessSegName, 
	                expectedCustomerName
	        );
	        LoggerUtil.pass("Verified newly saved row in table with Prefix: " + EnetringPrefixValueForSaveAsNew);
	        Thread.sleep(2000);

	        // Step 7: Open Edit for newly saved row
	        clickOnElement(ClickingEditBtn);
	        LoggerUtil.pass("Clicked Edit button successfully for saved row");
	        Thread.sleep(2000);

	        // Step 8: Verify all values in Edit mode
	        AfterClickingEditButtonAllDataAsItIsInParticularUi(
	            rowRejection, colRm, 
	            rowOverhead, colRm2, cellValOverhead, 
	            rowICC, rowProfit, colBOP, 
	            EnetringPrefixValueForSaveAsNew,          // Expected prefix value
	            cellValRejection, 
	            cellValOverhead, 
	            cellValICC, 
	            cellValProfit
	        );
	        LoggerUtil.pass("Verified all values successfully in Edit mode after Save As New");

	       
	        clickToggleDisable("Rejection");
	        LoggerUtil.pass("Disabled Rejection toggle again for cleanup");
	        
	        checkToggleAndPercentageAreSavedAsItIs("ICC");
	        
	        
	        
	    } catch (Exception e) {
	        LoggerUtil.error("Error while executing VerifySaveAsNewValueOnPrefix: " + e.getMessage());
	        throw e; // rethrow so test fails properly
	    }
	}



	public void EnteringValueForSavingCasCadingValues(
	        String prefixValue, String rowRejection, String colRm, String cellValRejection,
	        String rowOverhead, String colRm2, String cellValOverhead,
	        String rowICC, String cellValICC,
	        String rowProfit, String colBOP, String cellValProfit,
	        String modulename1, String modulename2, String modulename3,
	        String searchBusinessSegName, String expectedCustomerName,String EnteringRowNameForCascading,String EnteringColoumnNameCascading,String EnetrCellValueForCasCading,String EnteringRowNameICCForCascading,String EnteringColoumnNamepackingCascading,String EnetrCellForICCAndPacking ) throws InterruptedException {

	
	        // 1. Prefix field fill
	        clearAndEnterText(waitForExpectedElement(EnterPrefixValue), prefixValue);
	        LoggerUtil.info("Entered Prefix Value: " + prefixValue);

	        // 2. Rejection + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowRejection, colRm)), cellValRejection);
	        LoggerUtil.info("Entered value '" + cellValRejection + "' in Row=" + rowRejection + ", Column=" + colRm);
	        Thread.sleep(2000);

	        // 3. Overhead + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowOverhead, colRm2)), cellValOverhead);
	        LoggerUtil.info("Entered value '" + cellValOverhead + "' in Row=" + rowOverhead + ", Column=" + colRm2);

	        // 4. ICC + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowICC, colRm)), cellValICC);
	        LoggerUtil.info("Entered value '" + cellValICC + "' in Row=" + rowICC + ", Column=" + colRm);

	        // 5. Profit + BOP cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowProfit, colBOP)), cellValProfit);
	        LoggerUtil.info("Entered value '" + cellValProfit + "' in Row=" + rowProfit + ", Column=" + colBOP);

	        // 6. Click Toggle + Percentage for Rejection + RM
	        clickToggleAndPercentage("Rejection", "RM");

	        // 7. Click Toggle + Percentage for ICC + RM
	        clickToggleAndPercentage("ICC", "RM");

	        // 8. Click RM Module option
	        ClickingOptionRightHandThreeOptions("RM Module");
	        clickingCheckRmModules(modulename1, modulename2, modulename3);

	        // 9. Click Supplier → Business Segment
	        ClickingOptionRightHandThreeOptions("Supplier");
	        Thread.sleep(2000);
	        clickOnElement(ClickingBusinessSegDropdown);
	        VerifyClickingBusinessSegCheckbox(searchBusinessSegName);
             Thread.sleep(4000);
	        // 10. Supplier → Customer
	        ClickingOptionRightHandThreeOptions("Supplier");
	        Thread.sleep(2000);
	        ClickingOptionRightHandThreeOptions("Customer");
	        Thread.sleep(5000);
	        VerifyClickingCustomerCheckboxes(expectedCustomerName);
	
	        LoggerUtil.info("User Clicking CasCading heading..");
	        
	        clickOnElement(clickingCascadingHeading);
	        
	        enterValueInCascadingCell(EnteringRowNameForCascading, EnteringColoumnNameCascading,EnetrCellValueForCasCading);
	
	        enterValueInCascadingCell(EnteringRowNameICCForCascading, EnteringColoumnNamepackingCascading,EnetrCellForICCAndPacking); 
	        
	        
	        clickOnElement(ClckingSaveButton);
	        
	        Thread.sleep(4000);
		       
	        clickOnElement(ClickingViewBtn);
	        
	        VerifySearchFilter(prefixValue,prefixValue,searchBusinessSegName,expectedCustomerName);
	        
	        Thread.sleep(2000);
	   
	        clickOnElement(ClickingEditBtn);
	        
	        Thread.sleep(2000);
	        
	        AfterClickingEditButtonAllDataAsItIsInParticularUi(
	        	    rowRejection, colRm, 
	        	    rowOverhead, colRm2, cellValOverhead, 
	        	    rowICC, rowProfit, colBOP, 
	        	    prefixValue,                // Expected prefix value
	        	    cellValRejection, 
	        	    cellValOverhead, 
	        	    cellValICC, 
	        	    cellValProfit
	        	);
	        clickOnElement(clickingCascadingHeading);
	        
	        FetchingCascadingValueFromUiHasBeenSavedOrNot(EnteringRowNameForCascading, EnteringColoumnNameCascading,EnetrCellValueForCasCading);
	        
	        FetchingCascadingValueFromUiHasBeenSavedOrNot(EnteringRowNameICCForCascading, EnteringColoumnNamepackingCascading,EnetrCellForICCAndPacking);
	
	}
	
	    
	public int getMaxEntriesFromTable() throws InterruptedException {
		
		int maxEntries=0;
		clickOnElement(ClickingViewBtn);
		Thread.sleep(3000);
		
	    try {
	        WebElement infoElement = waitForExpectedElement(By.id("example1_info"));
	        String infoText = infoElement.getText(); // "Showing 1 to 25 of 202 entries"

	        // Regex se last number extract karenge
	        String totalEntries = infoText.replaceAll(".*of\\s+(\\d+)\\s+entries.*", "$1");

	         maxEntries = Integer.parseInt(totalEntries.trim());
	        LoggerUtil.pass("Maximum entries found: " + maxEntries);
	        return maxEntries;
	    } catch (Exception e) {
	        LoggerUtil.error("Failed to fetch maximum entries → " + e.getMessage());
	        return maxEntries;
	    }
	}

	

	
	public static final By slectingDropdownForExportFile = By.xpath("//div[@id='DataShows']/descendant::select[@name='ohpForExisting']");
	
	public void VerifyExportAndReadExcelData() throws InterruptedException {
		
		Thread.sleep(399);
		clickOnElement(clickingExportAndImportBtnFirstStepBtn);
		Thread.sleep(300);
		selectDropDownValue(slectingDropdownForExportFile, "New Data Mass Upload", "visibleText");
		Thread.sleep(3000);
		
		
		
	}
	
	public void VerifyResetButtonFuntionality(
	        String prefixValue, String rowRejection, String colRm, String cellValRejection,
	        String rowOverhead, String colRm2, String cellValOverhead,
	        String rowICC, String cellValICC,
	        String rowProfit, String colBOP, String cellValProfit,
	        String modulename1, String modulename2, String modulename3,
	        String searchBusinessSegName, String expectedCustomerName) throws TimeoutException {

	    try {
	    	
	        // 1. Prefix
	        clearAndEnterText(waitForExpectedElement(EnterPrefixValue), prefixValue);
	        LoggerUtil.info("Entered Prefix Value: " + prefixValue);

	        // 2. Rejection + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowRejection, colRm)), cellValRejection);
	        LoggerUtil.info("Entered value '" + cellValRejection + "' in Row=" + rowRejection + ", Column=" + colRm);

	        // 3. Overhead + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowOverhead, colRm2)), cellValOverhead);
	        LoggerUtil.info("Entered value '" + cellValOverhead + "' in Row=" + rowOverhead + ", Column=" + colRm2);

	        // 4. ICC + RM cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowICC, colRm)), cellValICC);
	        LoggerUtil.info("Entered value '" + cellValICC + "' in Row=" + rowICC + ", Column=" + colRm);

	        // 5. Profit + BOP cell fill
	        clearAndEnterText(waitForExpectedElement(getCellInputByRowAndColumn(rowProfit, colBOP)), cellValProfit);
	        LoggerUtil.info("Entered value '" + cellValProfit + "' in Row=" + rowProfit + ", Column=" + colBOP);

	        // 6. Toggle + Percentage actions
	        clickToggleAndPercentage("Rejection", "RM");
	       // clickToggleAndPercentage("ICC", "RM");

	        // 7. RM Module
	        ClickingOptionRightHandThreeOptions("RM Module");
	        clickingCheckRmModules(modulename1, modulename2, modulename3);

	        // 8. Supplier → Business Segment
	        ClickingOptionRightHandThreeOptions("Supplier");
	        clickOnElement(ClickingBusinessSegDropdown);
	        VerifyClickingBusinessSegCheckbox(searchBusinessSegName);

	        // 9. Supplier → Customer
	        ClickingOptionRightHandThreeOptions("Supplier");
	        Thread.sleep(4000);
	        ClickingOptionRightHandThreeOptions("Customer");
	        VerifyClickingCustomerCheckboxes(expectedCustomerName);
	        
	        
	        
	        WebElement checkbox = driver.findElement(By.id("RejectionPercent2"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", checkbox);

	        // Step 2: Confirm state before reset
	        boolean beforeReset = driver.findElement(By.id("RejectionPercent2")).isSelected();
	        LoggerUtil.info("Before reset state (RejectionPercent2): " + beforeReset);



	        boolean isClickable;
	        wait.until(ExpectedConditions.elementToBeClickable(clickingResetButton));
			
	        isClickable=true;
	        
	        if(isClickable) {
	        	
	        	LoggerUtil.info("Reset Button is Clickable....");
	        	clickOnElement(clickingResetButton);
	        	
	        	
	        }else {
	        	LoggerUtil.error("Reset Button is not clickable....");
	        }

			Thread.sleep(3000);
	     // --- After clicking Reset button ---

	     // 1. Verify text fields are cleared
	     String prefix = waitForExpectedElement(EnterPrefixValue).getAttribute("value");
	     LoggerUtil.info("Prefix field after reset: [" + prefix + "]");
	     if(prefix.isEmpty()) {
	         LoggerUtil.pass("Reset cleared Prefix field");
	     } else {
	         LoggerUtil.fail("Reset did not clear Prefix field, found: " + prefix);
	     }

	     String actualValueForRejectionAndRmColoumn =
	             waitForExpectedElement(getCellInputByRowAndColumn(rowRejection, colRm)).getAttribute("value");
	     LoggerUtil.info("Rejection+RM cell after reset: [" + actualValueForRejectionAndRmColoumn + "]");

	     String actualValueForOverheadAndRmcell =
	             waitForExpectedElement(getCellInputByRowAndColumn(rowOverhead, colRm2)).getAttribute("value");
	     LoggerUtil.info("Overhead+RM cell after reset: [" + actualValueForOverheadAndRmcell + "]");

	     String actualIccAndRmcell =
	             waitForExpectedElement(getCellInputByRowAndColumn(rowICC, colRm)).getAttribute("value");
	     LoggerUtil.info("ICC+RM cell after reset: [" + actualIccAndRmcell + "]");

	     String actualProfitBopCell =
	             waitForExpectedElement(getCellInputByRowAndColumn(rowProfit, colBOP)).getAttribute("value");
	     LoggerUtil.info("Profit+BOP cell after reset: [" + actualProfitBopCell + "]");

	     // 2. Verify toggle is unchecked
	     String toggleRow = "Rejection";
	     WebElement toggle = driver.findElement(getToggleCheckboxByRow(toggleRow));
	     if (!toggle.isSelected()) {
	         LoggerUtil.pass("Reset cleared Toggle at row: " + toggleRow);
	     } else {
	         LoggerUtil.fail("Reset did NOT clear Toggle at row: " + toggleRow);
	     }

	     
	     boolean afterReset = driver.findElement(By.id("RejectionPercent2")).isSelected();
	     LoggerUtil.info("After reset state (RejectionPercent2): " + afterReset);

	     // Step 5: Validate result
	     if (beforeReset && !afterReset) {
	         LoggerUtil.pass("Reset cleared RejectionPercent2 checkbox successfully");
	     } else if (beforeReset && afterReset) {
	         LoggerUtil.fail("Reset did NOT clear RejectionPercent2 checkbox");
	     } else {
	         LoggerUtil.info("RejectionPercent2 checkbox was never selected before reset");
	     }
	    }catch (Exception e) {
	        LoggerUtil.error("Error in VerifyResetButtonFuntionality: " + e.getMessage());
	    }
	}

	
//	OHP Child Part -
	
	
	public void VerifyDeleteDependentData(String EnterSearchvalue) {
	    try {
	        LoggerUtil.info("Step 1: Clicking on View button");
	        clickOnElement(ClickingViewBtn);
	        Thread.sleep(5000);

	        LoggerUtil.info("Step 2: Entering search value: " + EnterSearchvalue);
	        clearAndEnterText(waitForExpectedElement(EnterSearchFilter), EnterSearchvalue);
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 3: Clicking on Delete button for searched record");
	        clickOnElement(clickingDeleteButton);

	        LoggerUtil.info("Step 4: Capturing and accepting alert");
	        Alert alert = Base.driver.switchTo().alert();
	        String alertMsg = alert.getText().trim();
	        LoggerUtil.info("Alert Message: " + alertMsg);
	        alert.accept();

	        // Step 5: Validate alert message
	        if (alertMsg.contains("Are you sure you want to delete this")) {
	            LoggerUtil.pass("Correct alert message displayed → " + alertMsg);
	        } else {
	            LoggerUtil.fail("Unexpected alert message displayed → " + alertMsg);
	        }

	        LoggerUtil.info("Step 6: Capturing toast message after delete");
	        String actualToast = waitForExpectedElement(toastLocator).getText().trim();
	        LoggerUtil.info("Toast message displayed: " + actualToast);

	        // Step 7: Validate toast message
	        if (actualToast.contains("Unable to delete as OHP has dependent records")) {
	            LoggerUtil.pass("Correct toast message displayed → " + actualToast);
	        } else {
	            LoggerUtil.fail("Unexpected toast message displayed → " + actualToast);
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error in VerifyDeleteDependentData: " + e.getMessage());
	    }
	}

	
	
	
	public void DeleteRandomData(String EnterSearchvalue) throws InterruptedException {
		
		  clickOnElement(ClickingViewBtn);
	        Thread.sleep(5000);

	        LoggerUtil.info("Step 2: Entering search value: " + EnterSearchvalue);
	        clearAndEnterText(waitForExpectedElement(EnterSearchFilter), EnterSearchvalue);
	        Thread.sleep(3000);

	        LoggerUtil.info("Step 3: Clicking on Delete button for searched record");
	        clickOnElement(clickingDeleteButton);

	        LoggerUtil.info("Step 4: Capturing and accepting alert");
	        Alert alert = Base.driver.switchTo().alert();
	        String alertMsg = alert.getText().trim();
	        LoggerUtil.info("Alert Message: " + alertMsg);
	        alert.accept();
		   String actualtoast = waitForExpectedElement(toastLocator).getText();
		   System.out.println(actualtoast);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	

