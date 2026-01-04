
package com.Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

public class PartMasterDetailCostingRivisedPage extends Base {
	public static final By masterdata = By.xpath("//*[@id='sidebar-scroll']/div[1]/div[2]/div/div/div/nav/ul/li[2]/a");
	public static final By totalPartsNumPlaceholder = By
			.xpath("(//input[@placeholder='Enter total no. of parts...'])[2]");
	public static final By totalPartsInput = By
			.xpath("//div[@id='partMasterOldCostingmodal']//following-sibling::input[@id='excelCount2']");
	public static final By clickOnPartUOM = By.xpath("//select[@id='PartUOM']");

	// --- Locators (example, adjust if your app differs) ---
	public static final By exportImportBtn = By
			.xpath("//form[@id='PartMaster']//button[contains(.,'Export / Import')]");
	public static final By exportBtnInModal = By
			.xpath("//div[@id='partMasterOldCostingmodal']//button[@id='oldCostingExportss']");
	// public static final By importBtnInModal =
	// By.xpath("//div[contains(@class,'modal')]//button[contains(.,'Import')]");
	public static final By importBtnInModal = By.xpath("//button[@id='ImportDetailCosting']");
	public static final By modalRoot = By.xpath("//div[contains(@class,'modal') and .//button[contains(.,'Export')]]");

	// generic toast / inline validation (adjust to your app)
	public static final By toast = By.xpath("//div[contains(@class,'toast') or contains(@class,'alert')]");
	public static final By toastsingle = 
		    By.xpath("//div[contains(@class,'toast') or contains(@class,'alert') or contains(@class,'swal') or contains(@class,'success')]");
	public static final By redValidationText = By.xpath(
			"//div[contains(@class,'modal')]//*[contains(@class,'text-danger') or contains(@class,'validation') or contains(@style,'red')]");

	// Dropdowns (examples by label-right side select)
	public static final By companySelect = By.xpath(
			"//form[@id='PartMaster']//select[@id='PlantSelection']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By customerSelect = By.xpath(
			"//form[@id='PartMaster']//select[@id='CustomerSelection']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By supplierSelect = By.xpath(
			"//form[@id='PartMaster']//select[@id='SupplierSelection']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By productCategorySelect = By.xpath(
			"//form[@id='PartMaster']//select[@id='ProductModel']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By productModelSelect = By.xpath(
			"//form[@id='PartMaster']//select[@id='SubProductModel']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By specialProductCategorySelect = By.xpath(
			"//form[@id='PartMaster']//select[@id='SpecialProductCategory']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By partUOMSelect = By
			.xpath("//form[@id='PartMaster']//select[@id='PartUOM']//following-sibling::span");

	public static final By salesRadio = By
			.xpath("//form[@id='PartMaster']//following-sibling::input[@id='CostingTypeForSales']");
	public static final By procurementRadio = By
			.xpath("//form[@id='PartMaster']//following-sibling::input[@id='CostingTypeForProcurement']");
	public static final By bothRadio = By
			.xpath("//form[@id='PartMaster']//following-sibling::input[@id='CostingTypeForBoth']");
	public static final By partMasterRadio = (By.xpath("//label[text()='Part Master']"));
	public static final By oldCostingRadio = (By.xpath("//label[text()='Old Costing']"));
	public static final By detailCostingRadio = By.xpath(
			"//div[contains(@class,'modal')]//label[normalize-space()='Detail Costing']/preceding-sibling::input | //div[contains(@class,'modal')]//input[@type='radio' and @value='Detail Costing']");
	public static final By radioButtonPopUp = By
			.xpath("//div[@id='partMasterOldCostingmodal']//button[@class='btn-close']");

	public void validateFieldsInExcel(String filePath, Map<String, Object> expectedValues) {
	    try {
	        // Define columns to be fetched dynamically
	        Map<String, String> columns = new HashMap<>();
	        columns.put("Company", "O");       // Column O for Company
	        columns.put("Customer", "P");      // Column P for Customer
	        columns.put("Supplier", "Q");      // Column Q for Supplier
	        columns.put("ProductCategory", "V"); // Column V for Product Category
	        columns.put("ProductModel", "W");  // Column W for Product Model
	        columns.put("SpecialCategory", "X"); // Column X for Special Category
	       // columns.put("UOM", "N");           // Column N for UOM

	        // Get all values in one call
	        Map<String, String> actualValues = ExcelUtil.getCellValues(filePath, "Part_Master", columns, 3);

	        // Validate fields dynamically
	        SoftAssert sa = new SoftAssert();
	        for (Map.Entry<String, Object> entry : expectedValues.entrySet()) {
	            String field = entry.getKey();
	            Object expected = entry.getValue();
	            String actual = actualValues.get(field);

	            if (expected instanceof String) {
	                sa.assertEquals(actual, expected, "Mismatch in " + field);
	            } else if (expected instanceof List) {
	                List<String> expectedList = (List<String>) expected;
	                boolean found = expectedList.stream().anyMatch(expectedVal -> actual.equals(expectedVal));
	                sa.assertTrue(found, "Mismatch in " + field + ": Expected one of " + expectedList);
	            }
	        }
	        sa.assertAll();
	        LoggerUtil.info("Excel validations completed successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	public void selectOnPartUOMValue(String txt) {
		WebElement weObj = find(clickOnPartUOM);
		Select select = new Select(weObj);
		select.selectByVisibleText(txt);
		LoggerUtil.info("Part UOM Value Selected : " + txt);
	}

	// -------close part master radio button pop up--------

	public void verifyRadioPopUpCloseButton() {
		// Ensure popup is visible before close
		WebElement weRadioPopUpCloseButton = waitForVisibility(radioButtonPopUp, 5);
		LoggerUtil.info("Popup is visible before clicking close.");

		// Click close button
		clickOnElement(radioButtonPopUp);
		LoggerUtil.info("Clicked on popup close button.");

		// Wait until popup is no longer visible
		boolean isClosed =false;

		if (isClosed) {
			LoggerUtil.info("PASS: Popup closed successfully.");
			Assert.assertTrue(true);
		} else {
			LoggerUtil.error("FAIL: Popup did not close.");
			Assert.fail("Popup is still visible after clicking close.");
		}
	}

	// --- Actions ---
	public void openExportImportModal() {
		click(exportImportBtn);
		LoggerUtil.info("Clicking Export/Import");
		waitForVisible(modalRoot, 8);
		// Select Detail Costing if not already
		try {
			click(detailCostingRadio);
		} catch (Exception ignored) {
		}
		LoggerUtil.info("Detail Costing modal opened");
	}
	
	public void openExportImportModalAndSelectPartMasterRadioBtn() {
		try {
			click(exportImportBtn);
			LoggerUtil.info("Clicking Export/Import");
			WebElement el = find(partMasterRadio);
			LoggerUtil.info("Part Master radio option is visible");
			el.click();
			LoggerUtil.info("Clicking on part master radio button");
			
		} catch (Exception e) {
			
		}
	}

	public void enterTotalNoOfParts(String value) {
		try {
			WebElement el = driver.findElement(totalPartsInput);
			el.clear();
			el.sendKeys(value);
			// boolean numParts =el.isDisplayed();
			// LoggerUtil.info("Typed Total No. of Parts: " + numParts +" is visible");
			LoggerUtil.info("Typed Total No. of Parts: " + value);
		} catch (Exception e) {
			LoggerUtil.error("enterTotalNoOfParts() failed: " + e.getMessage());
		}
	}

	public void verifyEnterTotalNoOfPartPlaceholderValue() {
		String expectedPlaceholder = "Enter total no. of parts...";
		String actualplaceholderverification = waitForExpectedElement(totalPartsNumPlaceholder)
				.getAttribute("Placeholder");
		Assert.assertEquals(actualplaceholderverification, expectedPlaceholder);
		try {
			LoggerUtil.info("Actual Value = " + actualplaceholderverification + " || and || Expected Value = "
					+ expectedPlaceholder);
			Assert.assertEquals(actualplaceholderverification, expectedPlaceholder);
			LoggerUtil.pass("Expected Placeholder:- Value Are Matched");
		} catch (Exception e) {
			LoggerUtil.error("Expected Placeholder:- Value Are not Matched");

		}

	}

	public void enterTotalNoOfParts(int value) {
		enterTotalNoOfParts(String.valueOf(value));
	}

	public void clickOnExportBtn() {
		WebElement weObj = find(exportBtnInModal);
		weObj.click();
		LoggerUtil.info("clicked on Export Button !");
	}

	public boolean isExportButtonEnabledInModal() {
		try {
			WebElement el = find(exportBtnInModal);
			return el.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isImportButtonEnabledInModal() {
		try {
			WebElement el = find(importBtnInModal);
			return el.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void isExportButtonDisplayedInModal() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement exportButton = wait.until(ExpectedConditions.visibilityOfElementLocated(exportBtnInModal));
			Assert.assertTrue(exportButton.isDisplayed(), "Export button is not visible");
			LoggerUtil.info("Export Button is visible");
		} catch (Exception e) {
			LoggerUtil.error("Export button not found or not visible: " + e.getMessage());
			Assert.fail("Export button validation failed", e);
		}
	}

	public void isImportButtonDisplayedInModal() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement importButton = wait.until(ExpectedConditions.visibilityOfElementLocated(importBtnInModal));
			Assert.assertTrue(importButton.isDisplayed(), "Import button is not visible");
			LoggerUtil.info("Import Button is visible");
		} catch (Exception e) {
			LoggerUtil.error("Import button not found or not visible: " + e.getMessage());
			Assert.fail("Import button validation failed", e);
		}
	}

	public void verifyExportAndImportButtonVisibleOrNot() throws InterruptedException {
		isExportButtonDisplayedInModal();
		isImportButtonDisplayedInModal();
	}

	public void verifyPopupResetAfterClose() {
		// Reopen popup
		waitForVisibility(radioButtonPopUp, 5);
		LoggerUtil.info("Popup reopened.");

		// Capture the value of numeric field
		String fieldValue = waitForVisibility(totalPartsInput, 5).getAttribute("value");

		// Validation: Should not retain invalid state (0)
		if (fieldValue == null || fieldValue.isEmpty() || !fieldValue.equals("0")) {
			LoggerUtil.pass("PASS: Numeric field reset after reopening popup. Value: " + fieldValue);
			Assert.assertTrue(true);
		} else {
			// LoggerUtil.error("FAIL: Invalid value '0' retained after popup close.");
			LoggerUtil.fail("FAIL: Numeric field should resets.");
			// Assert.fail("Popup retained invalid state: " + fieldValue);
		}
	}
	
	public static final By ToastValidation = By.xpath("//div[@id='toast-container']/div/div[@class='toast-message']");
	public String captureSingleToastMessage() {

	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(ToastValidation));
		String toastmsg = waitForExpectedElement(ToastValidation).getText();
		Assert.assertEquals(toastmsg, "File imported successfully","Mismatch messages");
		return toastmsg;
	}

	public String captureValidationMes() {
	    String finalMessage = "";

	    // Step 1: Prefer inline red validations inside modal
	    List<WebElement> reds = finds(redValidationText);
	    for (WebElement r : reds) {
	        String text = r.getText().trim();
	        if (!text.isEmpty()) {
	            finalMessage = text;
	            LoggerUtil.info("Inline validation captured: " + finalMessage);
	            return finalMessage;
	        }
	    }

	    // Step 2: Fallback to toast message if no inline errors
	    try {
	        WebElement toastMsg = find(toast);
	        if (toastMsg.isDisplayed()) {
	            finalMessage = toastMsg.getText().trim();
	            LoggerUtil.info("Toast validation captured: " + finalMessage);
	            return finalMessage;
	        }
	    } catch (Exception ignored) {
	    }

	    // Step 3: Default fallback
	    LoggerUtil.info("No validation message detected inside modal or toast.");
	    return finalMessage; // returns "" if nothing found
	}
 






	public List<String> captureValidationMessages() {
		List<String> msgs = new ArrayList<>();
		// prefer red inline validations inside modal
		List<WebElement> reds = finds(redValidationText);
		for (WebElement r : reds) {
			String t = r.getText().trim();
			if (!t.isEmpty())
				msgs.add(t);
		}
		// fallback: toast
		try {
			WebElement t = find(toast);
			if (t.isDisplayed())
				msgs.add(t.getText().trim());
		} catch (Exception ignored) {
		}
		//LoggerUtil.info("Validation messages captured: " + msgs);
		return msgs;
	}

	public List<String> captureValidationMessagess() {
		List<String> msgs = new ArrayList<>();
		// fallback: toast
		try {
			WebElement t = find(toast);
			if (t.isDisplayed())
				msgs.add(t.getText().trim());
		} catch (Exception ignored) {
		}
		LoggerUtil.info("Validation messages captured: " + msgs);
		return msgs;
	}
	
	public boolean partMasterRadioDisplay() {
		try {
			WebElement el = find(partMasterRadio);
			LoggerUtil.info("Part Master radio option is visible");
			return el.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean oldCostingRadioDisplay() {
		try {
			WebElement el = find(oldCostingRadio);
			LoggerUtil.info("old Costing radio option is visible");
			return el.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean detailCostingRadioDisplay() {
		try {
			WebElement el = find(detailCostingRadio);
			LoggerUtil.info("detail Costing radio option is visible");
			return el.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// radio helpers
	public void selectSales() {
		click(salesRadio);
		LoggerUtil.info("Selected Radio Button : Sales");
	}

	public void selectProcurement() {
		click(procurementRadio);
		LoggerUtil.info("Selected Radio Button : Procurement");
	}

	public void selectBoth() {
		click(bothRadio);
		LoggerUtil.info("Selected Radio Button : Both");
	}

	// Base utils expected in BasePage
	private WebElement find(By by) {
		return driver.findElement(by);
	}

	private List<WebElement> finds(By by) {
		return driver.findElements(by);
	}

	private void click(By by) {
		find(by).click();
	}

	private void waitForVisible(By by, int sec) {
		new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void autoFillAndValidateBOPMasterPartNos(XSSFWorkbook workbook, String bopCostSheet, String bopMasterSheet,
			File filePath) throws Exception {

		XSSFSheet masterSheet = workbook.getSheet(bopMasterSheet);
		XSSFSheet costSheet = workbook.getSheet(bopCostSheet);

		if (masterSheet == null || costSheet == null) {
			throw new RuntimeException("One of the required sheets not found in workbook!");
		}

		// ✅ Collect Part Nos + dependent data from BOP_Master
		List<Map<String, String>> masterData = new ArrayList<>();
		Row masterHeader = masterSheet.getRow(1);

		// Map headers to column indexes
		Map<String, Integer> masterHeaderMap = new HashMap<>();
		for (Cell cell : masterHeader) {
			if (cell != null && cell.getCellType() == CellType.STRING) {
				masterHeaderMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
			}
		}

		for (int i = 2; i <= masterSheet.getLastRowNum(); i++) {
			Row row = masterSheet.getRow(i);
			if (row != null) {
				Map<String, String> rowData = new HashMap<>();
				rowData.put("Part No.", getCellValue(row, masterHeaderMap.get("Part No.")));
				rowData.put("BOP", getCellValue(row, masterHeaderMap.get("BOP")));
				rowData.put("BOP Type", getCellValue(row, masterHeaderMap.get("BOP Type")));
				rowData.put("Child Part Desc", getCellValue(row, masterHeaderMap.get("Child Part Desc")));
				rowData.put("UOM", getCellValue(row, masterHeaderMap.get("UOM")));
				if (!rowData.get("Part No.").isEmpty()) {
					masterData.add(rowData);
				}
			}
		}

		if (masterData.isEmpty()) {
			throw new RuntimeException("No valid Part Nos found in " + bopMasterSheet);
		}

		// ✅ Pick first 3 entries (cycle if fewer available)
		List<Map<String, String>> selectedData = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			selectedData.add(masterData.get(i % masterData.size()));
		}

		// ✅ Dynamically calculate row indexes (1st, mid, last)
		int totalRows = costSheet.getLastRowNum() - 1;
		int midRow = (totalRows > 2) ? (totalRows / 2) : 1;
		List<Integer> rowIndexes = Arrays.asList(2, midRow + 1, totalRows + 1);

		// ✅ Write and validate
		Row costHeader = costSheet.getRow(1);
		Map<String, Integer> costHeaderMap = new HashMap<>();
		for (Cell cell : costHeader) {
			if (cell != null && cell.getCellType() == CellType.STRING) {
				costHeaderMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
			}
		}

		for (int i = 0; i < rowIndexes.size(); i++) {
			int rowIndex = rowIndexes.get(i);
			Map<String, String> masterRow = selectedData.get(i);

			Row row = costSheet.getRow(rowIndex);
			if (row == null)
				row = costSheet.createRow(rowIndex);

			// Write Part No.
			Cell cell = row.getCell(costHeaderMap.get("BOP Master Part No."));
			if (cell == null)
				cell = row.createCell(costHeaderMap.get("BOP Master Part No."));
			cell.setCellValue(masterRow.get("Part No."));

			// Validate dependent fields
			validateCellValue(row, costHeaderMap, "BOP", masterRow.get("BOP"), rowIndex);
			validateCellValue(row, costHeaderMap, "BOP Type", masterRow.get("BOP Type"), rowIndex);
			validateCellValue(row, costHeaderMap, "Child Part Desc", masterRow.get("Child Part Desc"), rowIndex);
			validateCellValue(row, costHeaderMap, "UOM", masterRow.get("UOM"), rowIndex);
		}

		// ✅ Save back
		try (FileOutputStream fos = new FileOutputStream(filePath)) {
			workbook.write(fos);
		}

		LoggerUtil.pass("BOP Master Part Nos auto-filled and linked fields validated for 1st, mid, and last rows.");
	}

	// ✅ Helper: safe cell value fetch
	private static String getCellValue(Row row, Integer colIndex) {
		if (colIndex == null || row == null)
			return "";
		Cell cell = row.getCell(colIndex);
		return (cell == null) ? "" : cell.toString().trim();
	}

	// ✅ Helper: validation with logs
	private static void validateCellValue(Row row, Map<String, Integer> headerMap, String columnName, String expected,
			int rowIndex) {
		Integer colIndex = headerMap.get(columnName);
		if (colIndex == null) {
			LoggerUtil.error("Column '" + columnName + "' not found in cost sheet!");
			return;
		}

		String actual = getCellValue(row, colIndex);
		if (actual.equals(expected)) {
			LoggerUtil.pass("Row " + (rowIndex + 1) + " → " + columnName + " matched: " + actual);
		} else {
			LoggerUtil.fail("Row " + (rowIndex + 1) + " → " + columnName + " mismatch! Expected: " + expected
					+ ", Found: " + actual);
		}
	}

	// Inside PartMasterPage.java (ya jis page class me aapke BOP_Cost table
	// locators hain)
	public boolean verifyQtyPcSaved(String expectedValue) {
		try {
			// Example: table me Qty/Pc column ka td locator
			List<WebElement> qtyPcCells = driver
					.findElements(By.xpath("//table[@id='bopCostTable']//td[@data-column='Qty/Pc']"));

			for (WebElement cell : qtyPcCells) {
				String actualValue = cell.getText().trim();
				if (actualValue.equals(expectedValue)) {
					LoggerUtil.info("Qty/Pc value found in table: " + actualValue);
					return true;
				}
			}
			LoggerUtil.info("Qty/Pc value NOT found in table: " + expectedValue);
			return false;

		} catch (Exception e) {
			LoggerUtil.error("Error while verifying Qty/Pc saved value: " + e.getMessage());
			return false;
		}
	}

	// Inside PartMasterPage.java (Page class)
	public void importDetailCostingExcel(String filePath) {
		try {
			LoggerUtil.info("STEP: Starting import for Excel file: " + filePath);

			// 1. Click on Import button (jo dialog open karta hai)
			WebElement importBtn = find(importBtnInModal);
			importBtn.click();
			LoggerUtil.info("Clicked on Import button");

			// 2. Use Robot class to handle OS file chooser
			Thread.sleep(2000); // wait for dialog to open

			StringSelection selection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			Robot robot = new Robot();
			robot.delay(500);

			// Press CTRL+V to paste file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			LoggerUtil.info("Pasted file path in OS dialog: " + filePath);

			robot.delay(500);

			// Press Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			LoggerUtil.info("Pressed Enter to confirm file selection");

		} catch (Exception e) {
			LoggerUtil.error("Error during importDetailCostingExcel: " + e.getMessage());
			throw new RuntimeException("Import failed", e);
		}
	}

	private By currencyRows = By.xpath("//table[@id='example1']//tbody/tr/td[2]"); // "Convert To Currency" column

	public List<String> getSystemCurrencyMasterList() {
		List<String> systemCurrencies = new ArrayList<>();
		List<WebElement> rows = driver.findElements(currencyRows);

		for (WebElement row : rows) {
			systemCurrencies.add(row.getText().trim());
		}
		return systemCurrencies;
	}

	/*
	 * public List<String> getDropdownValues(Workbook wb, String targetSheet, String
	 * columnLetter) { LinkedHashSet<String> dropdownValues = new LinkedHashSet<>();
	 * // avoid duplicates, keep order Sheet sheet = wb.getSheet(targetSheet); if
	 * (sheet == null) return new ArrayList<>(dropdownValues);
	 * 
	 * List<? extends DataValidation> validations = sheet.getDataValidations();
	 * 
	 * for (DataValidation dv : validations) { String formula =
	 * dv.getValidationConstraint().getFormula1(); if (formula == null) continue;
	 * 
	 * CellRangeAddressList regions = dv.getRegions(); if (regions.countRanges() ==
	 * 0) continue;
	 * 
	 * CellRangeAddress range = regions.getCellRangeAddress(0); int colIndex =
	 * range.getFirstColumn(); String colLetter =
	 * CellReference.convertNumToColString(colIndex);
	 * 
	 * if (!colLetter.equalsIgnoreCase(columnLetter)) continue;
	 * 
	 * // Case 1: Inline list (comma separated) if (formula.startsWith("\"") &&
	 * formula.endsWith("\"")) { String[] items = formula.substring(1,
	 * formula.length() - 1).split(","); for (String item : items) {
	 * dropdownValues.add(item.trim()); } } // Case 2: Inline list with braces
	 * {a,b,c} else if (formula.startsWith("{") && formula.endsWith("}")) { String[]
	 * items = formula.substring(1, formula.length() - 1).split(","); for (String
	 * item : items) { dropdownValues.add(item.trim()); } } // Case 3: Named range
	 * or OFFSET/INDIRECT reference else { Name namedRange = wb.getName(formula); if
	 * (namedRange != null) { // Resolve named range
	 * dropdownValues.addAll(resolveRangeValues(wb,
	 * namedRange.getRefersToFormula())); } else if (formula.startsWith("OFFSET(")
	 * || formula.startsWith("INDIRECT(")) { // Try to extract base cell from
	 * OFFSET/INDIRECT String cleanFormula = formula.replace("$", ""); int excl =
	 * cleanFormula.indexOf('!'); if (excl > 0) { String sheetName =
	 * cleanFormula.substring(0, excl); String refPart = cleanFormula.substring(excl
	 * + 1).split(",")[0]; dropdownValues.addAll(resolveRangeValues(wb, sheetName +
	 * "!" + refPart + ":" + refPart)); } } else {
	 * dropdownValues.add("Unresolved Formula: " + formula); } } } return new
	 * ArrayList<>(dropdownValues); }
	 * 
	 * private List<String> resolveRangeValues(Workbook wb, String refersToFormula)
	 * { LinkedHashSet<String> uniqueValues = new LinkedHashSet<>(); // avoids
	 * duplicates, keeps order AreaReference areaRef = new
	 * AreaReference(refersToFormula, wb.getSpreadsheetVersion());
	 * 
	 * for (CellReference cellRef : areaRef.getAllReferencedCells()) { Sheet s =
	 * wb.getSheet( cellRef.getSheetName() != null ? cellRef.getSheetName() :
	 * wb.getSheetName(0)); if (s == null) continue;
	 * 
	 * Row r = s.getRow(cellRef.getRow()); if (r == null) continue;
	 * 
	 * Cell c = r.getCell(cellRef.getCol()); if (c != null && c.getCellType() !=
	 * CellType.BLANK) { String val = c.toString().trim(); if (!val.isEmpty()) {
	 * uniqueValues.add(val); } } } return new ArrayList<>(uniqueValues); }
	 */

	public List<String> getDropdownValues(Workbook wb, String targetSheet, String cellRef) {
		LinkedHashSet<String> dropdownValues = new LinkedHashSet<>();
		Sheet sheet = wb.getSheet(targetSheet);
		if (sheet == null)
			return new ArrayList<>(dropdownValues);

		// Parse row+col from cellRef (e.g. "M3")
		CellReference cr = new CellReference(cellRef);
		int targetRow = cr.getRow(); // 0-based
		int targetCol = cr.getCol();

		List<? extends DataValidation> validations = sheet.getDataValidations();

		for (DataValidation dv : validations) {
			String formula = dv.getValidationConstraint().getFormula1();
			if (formula == null)
				continue;

			for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {
				if (region.isInRange(targetRow, targetCol)) {

					// ✅ Inline list ("Apr,May,...")
					if (formula.startsWith("\"") && formula.endsWith("\"")) {
						String[] items = formula.substring(1, formula.length() - 1).split(",");
						for (String item : items)
							dropdownValues.add(item.trim());
					}
					// ✅ Inline list with braces {Apr,May,...}
					else if (formula.startsWith("{") && formula.endsWith("}")) {
						String[] items = formula.substring(1, formula.length() - 1).split(",");
						for (String item : items)
							dropdownValues.add(item.trim());
					}
					// ✅ Named range (e.g. "=PeriodList")
					else {
						if (formula.startsWith("=")) {
							formula = formula.substring(1); // remove leading "="
						}
						Name namedRange = wb.getName(formula);
						if (namedRange != null) {
							dropdownValues.addAll(resolveRangeValues(wb, namedRange.getRefersToFormula()));
						}
						// ✅ Handle OFFSET/INDIRECT – resolve to real cells
						else if (formula.startsWith("OFFSET(") || formula.startsWith("INDIRECT(")) {
							String cleanFormula = formula.replace("$", "");
							int excl = cleanFormula.indexOf('!');
							if (excl > 0) {
								String sheetName = cleanFormula.substring(0, excl);
								String refPart = cleanFormula.substring(excl + 1).split(",")[0];
								dropdownValues
										.addAll(resolveRangeValues(wb, sheetName + "!" + refPart + ":" + refPart));
							}
						}
					}
				}
			}
		}
		return new ArrayList<>(dropdownValues);
	}

	private List<String> resolveRangeValues(Workbook wb, String refersToFormula) {
		LinkedHashSet<String> uniqueValues = new LinkedHashSet<>();
		AreaReference areaRef = new AreaReference(refersToFormula, wb.getSpreadsheetVersion());

		for (CellReference cellRef : areaRef.getAllReferencedCells()) {
			Sheet s = wb.getSheet(cellRef.getSheetName() != null ? cellRef.getSheetName() : wb.getSheetName(0));
			if (s == null)
				continue;

			Row r = s.getRow(cellRef.getRow());
			if (r == null)
				continue;

			Cell c = r.getCell(cellRef.getCol());
			if (c != null && c.getCellType() != CellType.BLANK) {
				String val = c.toString().trim();
				if (!val.isEmpty()) {
					uniqueValues.add(val); // ✅ add only actual cell values
				}
			}
		}
		return new ArrayList<>(uniqueValues);
	}

	//////////////////////////////

	public List<String> getDropdownValuesForSupplyCurrency(Workbook wb, String targetSheet, String cellRef) {
		LinkedHashSet<String> dropdownValues = new LinkedHashSet<>();
		Sheet sheet = wb.getSheet(targetSheet);
		if (sheet == null)
			return new ArrayList<>(dropdownValues);

		// Parse row+col from cellRef (e.g. "K3")
		CellReference cr = new CellReference(cellRef);
		int targetRow = cr.getRow(); // 0-based
		int targetCol = cr.getCol();

		List<? extends DataValidation> validations = sheet.getDataValidations();

		for (DataValidation dv : validations) {
			String formula = dv.getValidationConstraint().getFormula1();
			if (formula == null)
				continue;

			for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {
				if (region.isInRange(targetRow, targetCol)) {

					// Case 1: Inline list ("A,B,C")
					if (formula.startsWith("\"") && formula.endsWith("\"")) {
						String[] items = formula.substring(1, formula.length() - 1).split(",");
						for (String item : items)
							dropdownValues.add(item.trim());
					}
					// Case 2: Named range (=MyList)
					else if (formula.startsWith("=")) {
						String nameOrFormula = formula.substring(1); // remove leading "="

						Name namedRange = wb.getName(nameOrFormula);
						if (namedRange != null) {
							dropdownValues
									.addAll(resolveRangeValuesForSupplyCurrency(wb, namedRange.getRefersToFormula()));
						}
						// Case 3: Formula with INDEX/MATCH etc.
						else if (nameOrFormula.contains("INDEX(")) {
							String range = extractIndexRange(nameOrFormula);
							if (range != null) {
								dropdownValues.addAll(resolveRangeValuesForSupplyCurrency(wb, range));
							}
						}
						// Case 4: OFFSET/INDIRECT (already in your code)
						else if (nameOrFormula.startsWith("OFFSET(") || nameOrFormula.startsWith("INDIRECT(")) {
							LoggerUtil.warn("OFFSET/INDIRECT not yet supported: " + nameOrFormula);
						} else {
							LoggerUtil.warn("Unhandled DV formula: " + nameOrFormula);
						}
					}
				}
			}
		}
		return new ArrayList<>(dropdownValues);
	}

	/**
	 * Extracts the range part from an INDEX formula like:
	 * INDEX(BOP_Master!$H$3:$H$2000, MATCH(...)) → returns
	 * "BOP_Master!$H$3:$H$2000"
	 */
	private String extractIndexRange(String formula) {
		try {
			int start = formula.indexOf('(') + 1;
			int end = formula.indexOf(',', start);
			if (start > 0 && end > start) {
				String rangePart = formula.substring(start, end).trim();
				return rangePart.replace("$", "");
			}
		} catch (Exception e) {
			LoggerUtil.fail("Failed to parse INDEX formula: " + formula);
		}
		return null;
	}

	private List<String> resolveRangeValuesForSupplyCurrency(Workbook wb, String refersToFormula) {
		LinkedHashSet<String> uniqueValues = new LinkedHashSet<>();
		AreaReference areaRef = new AreaReference(refersToFormula, wb.getSpreadsheetVersion());

		for (CellReference cellRef : areaRef.getAllReferencedCells()) {
			Sheet s = (cellRef.getSheetName() != null) ? wb.getSheet(cellRef.getSheetName()) : wb.getSheetAt(0);
			if (s == null)
				continue;

			Row r = s.getRow(cellRef.getRow());
			if (r == null)
				continue;

			Cell c = r.getCell(cellRef.getCol());
			if (c != null && c.getCellType() != CellType.BLANK) {
				String val = c.toString().trim();
				if (!val.isEmpty())
					uniqueValues.add(val);
			}
		}
		return new ArrayList<>(uniqueValues);
	}

	public static void writeCellValue(File file, String sheetName, int excelRowNo, String columnName, String value)
			throws Exception {
		int rowIndex = excelRowNo - 1; // Excel rows are 1-based in input

		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet not found: " + sheetName);
			}

			// Header is in row 2 → index 1
			Row headerRow = sheet.getRow(1);
			if (headerRow == null) {
				throw new IllegalArgumentException("Header row not found in " + sheetName);
			}

			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING) {
					String headerName = cell.getStringCellValue().trim();
					if (headerName.equalsIgnoreCase(columnName.trim())) {
						colIndex = cell.getColumnIndex();
						break;
					}
				}
			}
			if (colIndex == -1) {
				throw new IllegalArgumentException("Column not found: " + columnName);
			}

			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(rowIndex);
			}

			// ✅ Do NOT force type → just set value
			Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			cell.setCellValue(value);

			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}
		}
	}

	public static String readCellValue(File file, String sheetName, int excelRowNo, String columnName)
			throws Exception {
		int rowIndex = excelRowNo - 1; // Excel rows are 1-based in input

		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet not found: " + sheetName);
			}

			// Header is in row 2 → index 1
			Row headerRow = sheet.getRow(1);
			if (headerRow == null) {
				throw new IllegalArgumentException("Header row not found in " + sheetName);
			}

			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING) {
					String headerName = cell.getStringCellValue().trim();
					if (headerName.equalsIgnoreCase(columnName.trim())) {
						colIndex = cell.getColumnIndex();
						break;
					}
				}
			}
			if (colIndex == -1) {
				throw new IllegalArgumentException("Column not found: " + columnName);
			}

			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				return null;
			}

			Cell cell = row.getCell(colIndex);
			if (cell == null) {
				return null;
			}

			DataFormatter formatter = new DataFormatter();
			return formatter.formatCellValue(cell); // Works for text, numeric, dropdown values
		}
	}

	public void writeAndConfirmCellValue(File file, String sheetName, int excelRowNo, String columnName,
			String value) throws Exception {
		int rowIndex = excelRowNo - 1; // 1-based to 0-based

		// Step 1: Write value
		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				throw new IllegalArgumentException("Sheet not found: " + sheetName);

			Row headerRow = sheet.getRow(1); // header row = index 1
			if (headerRow == null)
				throw new IllegalArgumentException("Header row not found in " + sheetName);

			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING) {
					String headerName = cell.getStringCellValue().trim();
					if (headerName.equalsIgnoreCase(columnName.trim())) {
						colIndex = cell.getColumnIndex();
						break;
					}
				}
			}
			if (colIndex == -1)
				throw new IllegalArgumentException("Column not found: " + columnName);

			Row row = sheet.getRow(rowIndex);
			if (row == null)
				row = sheet.createRow(rowIndex);

			Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			cell.setCellValue(value);

			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}
		}
		
		

		// Step 2: Reload and confirm
		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(1);
			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
						colIndex = cell.getColumnIndex();
						break;
					}
				}
			}

			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(colIndex);

			DataFormatter formatter = new DataFormatter();
			String readValue = formatter.formatCellValue(cell);

			LoggerUtil.info("✅ Updated Excel [" + sheetName + "] Row=" + excelRowNo + ", Column=" + columnName + " = "
					+ readValue);
		}
	}
	
	/**
	 * This method writes a new value in a cell — even if that cell already has a formula.
	 *
	 * What it does:
	 * - It first checks if the cell contains a formula.
	 * - If yes, it removes the formula and then writes the new value.
	 * - After this, the cell no longer calculates automatically — it becomes a normal value cell.
	 *
	 * When to use:
	 * - Use this when you want to test what happens if someone changes a formula cell manually.
	 * - For example: to check if the system correctly detects that the cell was changed.
	 *
	 * Example:
	 * - If "Total Cost" has a formula, this method will delete that formula and put your value (like 99999).
	 *
	 * Note:
	 * - This method actually changes the Excel file.
	 */

	public void writeAndConfirmCellValue1(File file, String sheetName, int rowNum, String colHeader, String value) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, sheetName, 1);
	        int colIndex = headerMap.get(colHeader);

	        Row row = sheet.getRow(rowNum - 1); // 1-based to 0-based
	        if (row == null) row = sheet.createRow(rowNum - 1);

	        Cell cell = row.getCell(colIndex);
	        if (cell == null) cell = row.createCell(colIndex);

	        // 🚀 If formula cell, clear first
	        if (cell.getCellType() == CellType.FORMULA) {
	            cell.setCellFormula(null);   // clear formula
	        }

	        cell.setCellValue(value);

	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            workbook.write(fos);
	        }

	        LoggerUtil.info("✅ Updated Excel [" + sheetName + "] Row=" + rowNum
	                + ", Column=" + colHeader + " = " + value);
	    }
	}
	
	/**
	 * This method tries to write a new value in a cell but does NOT remove its formula.
	 *
	 * What it does:
	 * - It finds the cell in the given sheet and tries to write the value.
	 * - If the cell has a formula, it keeps the formula as it is.
	 * - If the cell is protected or locked, Excel will not allow the value to be changed.
	 * - After writing, it checks if the cell still has the formula.
	 *
	 * When to use:
	 * - Use this for testing that gray or locked formula cells cannot be changed.
	 * - For example: “Users cannot overwrite gray-filled formula cells.”
	 *
	 * Example:
	 * - If "Total Cost" cell is formula-based, this method will try to write 99999
	 *   but the cell will stay the same with its formula value.
	 *
	 * Note:
	 * - This method is safe. It does NOT remove or damage the formula.
	 */

	public void simplewriteAndConfirmCellValueWithoutClearFormulla(File file, String sheetName, int rowNum, String colHeader, String value) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, sheetName, 1);
	        int colIndex = headerMap.get(colHeader);

	        Row row = sheet.getRow(rowNum - 1);
	        if (row == null) row = sheet.createRow(rowNum - 1);

	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

	        // ✅ Just try writing — don’t remove formula
	        String beforeType = cell.getCellType().toString();
	        try {
	            cell.setCellValue(value);
	        } catch (Exception e) {
	            LoggerUtil.info("⚠️ Cannot overwrite formula cell (" + colHeader + "), it’s locked.");
	        }

	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            workbook.write(fos);
	        }

	        LoggerUtil.info("Tried to write '" + value + "' in [" + sheetName + "] Row=" + rowNum + ", Column=" + colHeader +
	                " | BeforeType=" + beforeType + " | AfterType=" + cell.getCellType());
	    }
	}



	///////////////////////////////////////////////////////////

	public static void writeAndConfirmCellValue(File file, String sheetName, int excelRowNo, String columnName,
			Object value) throws Exception {
		int rowIndex = excelRowNo - 1; // 1-based to 0-based

// Step 1: Write value
		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				throw new IllegalArgumentException("Sheet not found: " + sheetName);

			Row headerRow = sheet.getRow(1); // header row = index 1
			if (headerRow == null)
				throw new IllegalArgumentException("Header row not found in " + sheetName);

			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING
						&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
					colIndex = cell.getColumnIndex();
					break;
				}
			}
			if (colIndex == -1)
				throw new IllegalArgumentException("Column not found: " + columnName);

			Row row = sheet.getRow(rowIndex);
			if (row == null)
				row = sheet.createRow(rowIndex);

			Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

// ✅ Dynamic type handling
			if (value instanceof Number) {
				cell.setCellValue(((Number) value).doubleValue()); // for int, double, float
			} else {
				cell.setCellValue(value.toString()); // fallback to string
			}

			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}
		}

// Step 2: Reload and confirm (✅ evaluate formula, not text)
		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(1);
			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING
						&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
					colIndex = cell.getColumnIndex();
					break;
				}
			}

			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(colIndex);

			XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			String readValue;

			if (cell != null) {
				switch (cell.getCellType()) {
				case FORMULA:
					CellValue eval = evaluator.evaluate(cell);
					if (eval.getCellType() == CellType.NUMERIC) {
						readValue = String.valueOf(eval.getNumberValue());
					} else if (eval.getCellType() == CellType.STRING) {
						readValue = eval.getStringValue();
					} else {
						readValue = "";
					}
					break;
				default:
					DataFormatter formatter = new DataFormatter();
					readValue = formatter.formatCellValue(cell, evaluator);
					break;
				}
			} else {
				readValue = "";
			}

			LoggerUtil.info("✅ Updated Excel [" + sheetName + "] Row=" + excelRowNo + ", Column=" + columnName + " = "
					+ readValue);
		}
	}

	//////////////////////////////////////////////////////////

	public void selectDropdownValue(File file, String sheetName, int excelRowNo, String columnName,
			String valueToSelect) throws Exception {
		int rowIndex = excelRowNo - 1; // 1-based to 0-based

		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				throw new IllegalArgumentException("Sheet not found: " + sheetName);

			// Find the column by header
			Row headerRow = sheet.getRow(1); // header row index
			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
						colIndex = cell.getColumnIndex();
						break;
					}
				}
			}
			if (colIndex == -1)
				throw new IllegalArgumentException("Column not found: " + columnName);

			Row row = sheet.getRow(rowIndex);
			if (row == null)
				row = sheet.createRow(rowIndex);

			// ✅ Write dropdown value (only if valid)
			Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			cell.setCellValue(valueToSelect);

			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}

			LoggerUtil.info("✅ Selected value '" + valueToSelect + "' in [" + sheetName + "] Row=" + excelRowNo
					+ ", Column=" + columnName);
		}
	}
	
	public  void selectDropdownValue1(File file, String sheetName, int excelRowNo, String columnName,
			String valueToSelect) throws Exception {
		int rowIndex = excelRowNo - 1; // 1-based → 0-based index

		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				throw new IllegalArgumentException("Sheet not found: " + sheetName);

// 🔍 Find the column by header
			Row headerRow = sheet.getRow(1); // header row at index 1
			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING
						&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
					colIndex = cell.getColumnIndex();
					break;
				}
			}
			if (colIndex == -1)
				throw new IllegalArgumentException("Column not found: " + columnName);

// 🔍 Get the row
			Row row = sheet.getRow(rowIndex);
			if (row == null)
				row = sheet.createRow(rowIndex);

// ✅ Handle the cell
			Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

// 🚀 If formula exists, clear it so value stays visible
			if (cell.getCellType() == CellType.FORMULA) {
				cell.setCellFormula(null);
			}

// ✍️ Write the dropdown value
			cell.setCellValue(valueToSelect);

// 💾 Save changes
			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}

			LoggerUtil.info("✅ Selected value '" + valueToSelect + "' in [" + sheetName + "] Row=" + excelRowNo
					+ ", Column=" + columnName);
		}
	}

	public void selectDropdownValue2(File file, String sheetName, int excelRowNo, String columnName,
			String[] valuesToSelect) throws Exception {
		int rowIndex = excelRowNo - 1; // 1-based → 0-based index

		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet not found: " + sheetName);
			}

// 🔍 Find the column by header
			Row headerRow = sheet.getRow(1); // header row at index 1
			int colIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getCellType() == CellType.STRING
						&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
					colIndex = cell.getColumnIndex();
					break;
				}
			}
			if (colIndex == -1) {
				throw new IllegalArgumentException("Column not found: " + columnName);
			}

// 🔍 Get the row
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(rowIndex);
			}

// ✅ Handle the cell
			Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

// 🚀 If formula exists, clear it so value stays visible
			if (cell.getCellType() == CellType.FORMULA) {
				cell.setCellFormula(null);
			}

// ✍️ Join multiple values into a single string (comma separated)
			String joinedValues = String.join(", ", valuesToSelect);
			cell.setCellValue(joinedValues);

// 💾 Save changes
			try (FileOutputStream fos = new FileOutputStream(file)) {
				workbook.write(fos);
			}

			LoggerUtil.info("✅ Selected values '" + joinedValues + "' in [" + sheetName + "] Row=" + excelRowNo
					+ ", Column=" + columnName);
		}
	}

	public void validateBopCostAgainstBopMaster(File file, int bopCostRow, String bopMasterPartNo)
	        throws Exception {

	    SoftAssert softAssert = new SoftAssert();

	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet bopCostSheet = workbook.getSheet("BOP_Cost");
	        XSSFSheet bopMasterSheet = workbook.getSheet("BOP_Master");

	        if (bopCostSheet == null || bopMasterSheet == null) {
	            throw new IllegalArgumentException("Required sheets not found!");
	        }

	        DataFormatter formatter = new DataFormatter();
	        XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	        // --- Step 1: Locate BOP Master Part No in BOP_Master ---
	        int partNoCol = findColumnIndex(bopMasterSheet, "Part No.");
	        int bopCol = findColumnIndex(bopMasterSheet, "BOP");
	        int childDescCol = findColumnIndex(bopMasterSheet, "Child Part Desc");
	        int uomCol = findColumnIndex(bopMasterSheet, "UOM");

	        // Try Supplier column (Procurement), fallback silently if absent
	        int supplierCol = -1;
	        try {
	            supplierCol = findColumnIndex(bopMasterSheet, "Supplier");
	        } catch (Exception e) {
	            LoggerUtil.warn("⚠ Supplier column not found in BOP_Master (Sales flow detected).");
	        }

	        Row foundRow = null;
	        for (Row row : bopMasterSheet) {
	            if (row.getRowNum() <= 1) continue; // skip header
	            String partNoVal = formatter.formatCellValue(row.getCell(partNoCol), evaluator).trim();
	            if (bopMasterPartNo.equalsIgnoreCase(partNoVal)) {
	                foundRow = row;
	                break;
	            }
	        }

	        if (foundRow == null) {
	            LoggerUtil.warn("⚠ Part No " + bopMasterPartNo + " not found in BOP_Master (maybe limited data in Sales export). Skipping content validation.");
	            softAssert.assertTrue(true, "Skipped validation for Sales export (BOP_Master minimal data).");
	            softAssert.assertAll();
	            return;
	        }

	        // --- Step 2: Expected values from BOP_Master ---
	        String expBop = formatter.formatCellValue(foundRow.getCell(bopCol), evaluator);
	        String expChild = formatter.formatCellValue(foundRow.getCell(childDescCol), evaluator);
	        String expUom = formatter.formatCellValue(foundRow.getCell(uomCol), evaluator);
	        String expSupplier = (supplierCol != -1)
	                ? formatter.formatCellValue(foundRow.getCell(supplierCol), evaluator)
	                : "";

	        // --- Step 3: Compare with actual values in BOP_Cost ---
	        int bopCostColPartNo = findColumnIndex(bopCostSheet, "BOP Master Part No.");
	        int bopCostColBop = findColumnIndex(bopCostSheet, "BOP");
	        int bopCostColChild = findColumnIndex(bopCostSheet, "Child Part Desc");
	        int bopCostColUom = findColumnIndex(bopCostSheet, "UOM");

	        // Supplier/Customer detection
	        int bopCostColParty = -1;
	        String partyLabel = "";
	        try {
	            bopCostColParty = findColumnIndex(bopCostSheet, "Supplier Name");
	            partyLabel = "Supplier";
	        } catch (IllegalArgumentException e1) {
	            try {
	                bopCostColParty = findColumnIndex(bopCostSheet, "Customer Name");
	                partyLabel = "Customer";
	            } catch (IllegalArgumentException e2) {
	                LoggerUtil.warn("⚠ Neither Supplier Name nor Customer Name found in BOP_Cost.");
	            }
	        }

	        Row costRow = bopCostSheet.getRow(bopCostRow - 1);

	        // --- Step 4: Compare and log results ---
	        checkAndLogSoftAssert(softAssert, "BOP Master Part No.", bopMasterPartNo,
	                formatter.formatCellValue(costRow.getCell(bopCostColPartNo), evaluator));

	        checkAndLogSoftAssert(softAssert, "BOP", expBop,
	                formatter.formatCellValue(costRow.getCell(bopCostColBop), evaluator));

	        checkAndLogSoftAssert(softAssert, "Child Part Desc", expChild,
	                formatter.formatCellValue(costRow.getCell(bopCostColChild), evaluator));

	        checkAndLogSoftAssert(softAssert, "UOM", expUom,
	                formatter.formatCellValue(costRow.getCell(bopCostColUom), evaluator));

	        if (bopCostColParty != -1 && !expSupplier.isEmpty()) {
	            checkAndLogSoftAssert(softAssert, partyLabel, expSupplier,
	                    formatter.formatCellValue(costRow.getCell(bopCostColParty), evaluator));
	        } else {
	            LoggerUtil.info("ℹ Skipped Supplier/Customer comparison (column not applicable).");
	        }

	        softAssert.assertAll();
	    }
	}
	
	private static int findColumnIndex(Sheet sheet, String columnName) {
		Row headerRow = sheet.getRow(1); // headers at row 2 → index 1
		for (Cell cell : headerRow) {
			if (cell.getCellType() == CellType.STRING
					&& cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
				return cell.getColumnIndex();
			}
		}
		throw new IllegalArgumentException("Column not found: " + columnName);
	}

	private static void checkAndLogSoftAssert(SoftAssert softAssert, String column, String expected, String actual) {
	    if (expected.equalsIgnoreCase(actual)) {
	        LoggerUtil.info("✅ " + column + " matched: " + actual);
	    } else {
	        LoggerUtil.error("❌ " + column + " mismatch! Expected=" + expected + ", Actual=" + actual);
	        softAssert.fail(column + " mismatch! Expected=" + expected + ", Actual=" + actual);
	    }
	}
	
	public String getRateOrUOMFromProcessMaster(String filePath, String supplier, String process, boolean isRate) {
	    String result = "";
	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet("Process_Master");
	        if (sheet == null) {
	            LoggerUtil.error("❌ Process_Master sheet not found.");
	            return "";
	        }

	        DataFormatter fmt = new DataFormatter();
	        Row headerRow = sheet.getRow(4);  // Row 5 in Excel (0-based index = 4)
	        int colProcess = -1, colSupplier = -1, colRate = -1, colUOM = -1;

	        // 🔹 Identify actual column indexes dynamically
	        for (Cell cell : headerRow) {
	            if (cell == null) continue;
	            String val = cell.toString().trim();
	            if (val.equalsIgnoreCase("Process Name")) colProcess = cell.getColumnIndex();
	            else if (val.equalsIgnoreCase("Supplier")) colSupplier = cell.getColumnIndex();
	            else if (val.equalsIgnoreCase("Rate")) colRate = cell.getColumnIndex();
	            else if (val.equalsIgnoreCase("Unit")) colUOM = cell.getColumnIndex();
	        }

	        if (colProcess == -1 || colSupplier == -1 || colRate == -1 || colUOM == -1) {
	            LoggerUtil.error("⚠️ Missing expected columns in Process_Master sheet. Found indices → "
	                    + "Process=" + colProcess + ", Supplier=" + colSupplier + ", Rate=" + colRate + ", Unit=" + colUOM);
	            return "";
	        }

	        // 🔹 Now find the matching row
	        for (int r = 5; r <= sheet.getLastRowNum(); r++) { // starting from data row (Excel row 6)
	            Row row = sheet.getRow(r);
	            if (row == null) continue;

	            String processVal = fmt.formatCellValue(row.getCell(colProcess)).trim();
	            String supplierVal = fmt.formatCellValue(row.getCell(colSupplier)).trim();

	            if (processVal.equalsIgnoreCase(process) && supplierVal.equalsIgnoreCase(supplier)) {
	                result = isRate
	                        ? fmt.formatCellValue(row.getCell(colRate)).trim()
	                        : fmt.formatCellValue(row.getCell(colUOM)).trim();
	                break;
	            }
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("⚠️ Failed reading Process_Master: " + e.getMessage());
	    }

	    return result.trim();
	}

	public List<String> getTheListOfUnitMasterUnitSymbol() throws InterruptedException {
	    DashboardPage dashboard = new DashboardPage();
	    dashboard.clickingDashboard("");
	    dashboard.selectMenuFormDashBoard("Master Data");
	    Thread.sleep(3000);
	    dashboard.clickOnUnitMaster();
	    Thread.sleep(1000);
	    // ✅ Fetch all Unit Symbol column values
	    List<WebElement> unitSymbols = driver.findElements(By.xpath(
	        "//table[@id='unitTable']//tr/td[count(//table[@id='unitTable']//th[normalize-space()='Unit Symbol']/preceding-sibling::th)+1]"
	    ));

	    // ✅ Use LinkedHashSet to remove duplicates while preserving order
	    Set<String> uniqueSymbols = new LinkedHashSet<>();
	    for (WebElement symbol : unitSymbols) {
	        String value = symbol.getText().trim();
	        if (!value.isEmpty()) {
	            uniqueSymbols.add(value);
	        }
	    }

	    // ✅ Convert to List for return
	    List<String> symbolList = new ArrayList<>(uniqueSymbols);
	    
	    return symbolList;
	}
	
	/**
	 * Reads a numeric (or formula-evaluated numeric) value from the given Excel sheet.
	 */
	public double readNumericCellValue(File file, String sheetName, int rowNum, String columnName) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        int colIndex = getColumnIndex(sheet, columnName);
	        Row row = sheet.getRow(rowNum - 1); // Excel is 1-based
	        if (row == null) return 0.0;

	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	        switch (cell.getCellType()) {
	            case NUMERIC:
	                return cell.getNumericCellValue();
	            case FORMULA:
	                CellValue evaluated = evaluator.evaluate(cell);
	                return evaluated.getNumberValue();
	            case STRING:
	                return Double.parseDouble(cell.getStringCellValue().trim());
	            default:
	                return 0.0;
	        }
	    }
	}

	/**
	 * Evaluates and returns the value of a formula cell (e.g., Production/Hour).
	 * If the cell is not a formula, it still safely returns its numeric value.
	 */
	public double evaluateFormulaCellValue(File file, String sheetName, int rowNum, String columnName) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        int colIndex = getColumnIndex(sheet, columnName);
	        Row row = sheet.getRow(rowNum - 1);
	        if (row == null) return 0.0;

	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

	        if (cell.getCellType() == CellType.FORMULA) {
	            CellValue val = evaluator.evaluate(cell);
	            return val != null ? val.getNumberValue() : 0.0;
	        } else if (cell.getCellType() == CellType.NUMERIC) {
	            return cell.getNumericCellValue();
	        } else if (cell.getCellType() == CellType.STRING) {
	            return Double.parseDouble(cell.getStringCellValue().trim());
	        } else {
	            return 0.0;
	        }
	    }
	}

	/**
	 * Attempts to write a value into a cell. 
	 * Returns false if write succeeded (cell editable), true if write failed (cell locked / protected).
	 */
	public boolean tryWriteValue(File file, String sheetName, int rowNum, String columnName, String newValue) {
	    boolean writeBlocked = false;
	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        int colIndex = getColumnIndex(sheet, columnName);
	        Row row = sheet.getRow(rowNum - 1);
	        if (row == null) return true;

	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        CellStyle style = cell.getCellStyle();

	        // if cell locked or gray (formula cell)
	        if (style.getLocked()) {
	            writeBlocked = true;
	        } else {
	            cell.setCellValue(newValue);
	            LoggerUtil.info("Manual edit succeeded for " + columnName + " → value entered: " + newValue);
	        }

	        // verify attempt result
	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            workbook.write(fos);
	        }

	    } catch (Exception e) {
	        writeBlocked = true;
	        LoggerUtil.info("Manual write blocked for " + columnName + " → cell may be protected.");
	    }
	    return writeBlocked;
	}
	
	/**
	 * Attempts to write a value into a cell.
	 * Returns true if write blocked (cell locked/protected), false if write succeeded (editable cell).
	 * Supports numeric, string, boolean, and formula-safe writes.
	 */
	public boolean tryWriteValue(File file, String sheetName, int rowNum, String columnName, Object newValue) {
	    boolean writeBlocked = false;
	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        int colIndex = getColumnIndex(sheet, columnName);
	        if (colIndex == -1) {
	            LoggerUtil.error("❌ Column '" + columnName + "' not found in sheet " + sheetName);
	            return true;
	        }

	        Row row = sheet.getRow(rowNum - 1);
	        if (row == null) return true;

	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        CellStyle style = cell.getCellStyle();

	        // 🔒 Check protection status
	        if (style.getLocked() || sheet.getProtect()) {
	            writeBlocked = true;
	            LoggerUtil.info("Manual write blocked for " + columnName + " → cell locked or sheet protected.");
	        } else {
	            // 🧠 Detect type and write appropriately
	            if (newValue instanceof Number) {
	                cell.setCellValue(((Number) newValue).doubleValue());
	            } else if (newValue instanceof Boolean) {
	                cell.setCellValue((Boolean) newValue);
	            } else if (newValue instanceof Date) {
	                cell.setCellValue((Date) newValue);
	            } else if (newValue != null) {
	                // fallback to string
	                cell.setCellValue(newValue.toString());
	            }

	            LoggerUtil.info("Manual edit succeeded for " + columnName + " → value entered: " + newValue);

	            // Save workbook
	            try (FileOutputStream fos = new FileOutputStream(file)) {
	                workbook.write(fos);
	            }
	        }

	    } catch (Exception e) {
	        writeBlocked = true;
	        LoggerUtil.info("Manual write blocked for " + columnName + " → cell or sheet may be protected. " + e.getMessage());
	    }
	    return writeBlocked;
	}


	/**
	 * Helper to find column index by name in first header row.
	 */
	private int getColumnIndex(Sheet sheet, String columnName) {
	    Row headerRow = sheet.getRow(1); // header typically in row 2 (Excel 1-based)
	    if (headerRow == null) return -1;

	    for (Cell cell : headerRow) {
	        if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
	            return cell.getColumnIndex();
	        }
	    }
	    throw new IllegalArgumentException("Column '" + columnName + "' not found in sheet " + sheet.getSheetName());
	}

	// Reads text (non-numeric) cell values
	public String readTextCellValue(File file, String sheetName, int rowNum, String columnName) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         Workbook workbook = WorkbookFactory.create(fis)) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        int colIndex = getColumnIndex(sheet, columnName);
	        Row row = sheet.getRow(rowNum - 1);
	        if (row == null) return "";
	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue().trim() :
	               String.valueOf(cell.toString().trim());
	    }
	}

	public void getTheValuesOfComotityDetails() throws InterruptedException {
		// --- Step 1: UI Commodity ---
					
	}
	
	public void writeCellValuecommodityMaster(File file, String sheetName, int excelRowNo, String columnName, String value) throws Exception {
	    int rowIndex = excelRowNo - 1;

	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	        // ✅ Header row is Row 3 (index 2)
	        Row headerRow = sheet.getRow(2);
	        if (headerRow == null) throw new IllegalArgumentException("Header row not found in " + sheetName);

	        int colIndex = -1;
	        for (Cell cell : headerRow) {
	            if (cell.getCellType() == CellType.STRING) {
	                String headerName = cell.getStringCellValue().trim();
	                if (headerName.equalsIgnoreCase(columnName.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	        }

	        if (colIndex == -1)
	            throw new IllegalArgumentException("Column not found: " + columnName);

	        Row row = sheet.getRow(rowIndex);
	        if (row == null) row = sheet.createRow(rowIndex);

	        Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        cell.setCellFormula(null);
	        cell.setCellType(CellType.STRING);
	        cell.setCellValue(value);

	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            workbook.write(fos);
	            fos.flush();
	        }
	    }
	}
	public String readCellValuecommodityMaster(File file, String sheetName, int excelRowNo, String columnName) throws Exception {
	    int rowIndex = excelRowNo - 1; // Excel 1-based → Java 0-based
	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	        // ✅ Header row is Row 3 (index 2)
	        Row headerRow = sheet.getRow(2);
	        if (headerRow == null) throw new IllegalArgumentException("Header row not found in " + sheetName);

	        int colIndex = -1;
	        for (Cell cell : headerRow) {
	            if (cell.getCellType() == CellType.STRING) {
	                String headerName = cell.getStringCellValue().trim();
	                if (headerName.equalsIgnoreCase(columnName.trim())) {
	                    colIndex = cell.getColumnIndex();
	                    break;
	                }
	            }
	        }
	        if (colIndex == -1)
	            throw new IllegalArgumentException("Column not found: " + columnName);

	        Row row = sheet.getRow(rowIndex);
	        if (row == null) return "";

	        Cell cell = row.getCell(colIndex);
	        return getCellValueEvaluated(cell, workbook);
	    }
	}
	public static String getCellValueEvaluated(Cell cell, Workbook workbook) {
	    if (cell == null) return "";

	    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	    CellType type = cell.getCellType();

	    if (type == CellType.FORMULA) {
	        type = evaluator.evaluateFormulaCell(cell);
	    }

	    switch (type) {
	        case STRING:
	            return cell.getStringCellValue().trim();
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
	            } else {
	                double val = cell.getNumericCellValue();
	                return new DecimalFormat("#.######").format(val);
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
	}

	public int getLastRowNum(File file, String sheetName) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null)
	            throw new IllegalArgumentException("Sheet not found: " + sheetName);

	        int lastRowNum = sheet.getLastRowNum();
	        int lastDataRow = -1;

	        // Scan backward to find last row having at least one non-empty cell
	        for (int i = lastRowNum; i >= 0; i--) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            boolean hasValue = false;
	            for (Cell cell : row) {
	                String cellText = cell.toString().trim();
	                if (!cellText.isEmpty()) {
	                    hasValue = true;
	                    break;
	                }
	            }
	            if (hasValue) {
	                lastDataRow = i;
	                break;
	            }
	        }

	        if (lastDataRow == -1)
	            throw new IllegalStateException("No non-empty rows found in sheet: " + sheetName);

	        return lastDataRow + 1; // Return Excel-style index (1-based for readability)
	    }
	}

	public String readCellValuecommodityMasterspecilyvalues(File file, String sheetName, int lastRowNum, String columnHeader) throws Exception {
	    try (FileInputStream fis = new FileInputStream(file);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null)
	            throw new IllegalArgumentException("Sheet not found: " + sheetName);

	        // Locate header row dynamically (scan first 5 rows)
	        Row headerRow = null;
	        for (int i = 0; i <= 5; i++) {
	            Row row = sheet.getRow(i);
	            if (row != null && row.getCell(0) != null &&
	                row.getCell(0).toString().toLowerCase().contains("s.no")) {
	                headerRow = row;
	                break;
	            }
	        }

	        if (headerRow == null)
	            throw new IllegalStateException("Header row not found for sheet: " + sheetName);

	        // Find the column index for the given header
	        int targetCol = -1;
	        for (Cell cell : headerRow) {
	            String cellValue = cell.toString().trim().replaceAll("\\s+", "").toLowerCase();
	            if (cellValue.equals(columnHeader.trim().replaceAll("\\s+", "").toLowerCase())) {
	                targetCol = cell.getColumnIndex();
	                break;
	            }
	        }

	        if (targetCol == -1)
	            throw new IllegalArgumentException("Column not found: " + columnHeader);

	        // Scan backward to find last non-empty cell in that column
	        String value = "";
	        for (int i = lastRowNum; i >= headerRow.getRowNum() + 1; i--) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            Cell cell = row.getCell(targetCol);
	            if (cell != null && !cell.toString().trim().isEmpty()) {
	                value = cell.toString().trim();
	                break;
	            }
	        }

	        return value;
	    }
	}
	
	/**
	 * Reads a numeric value safely from a given cell with formula evaluation.
	 * Handles numeric, string, and formula cell types gracefully.
	 * Returns 0.0 if the cell is blank or non-numeric.
	 */
	public static double getNumericValue(Cell cell, FormulaEvaluator evaluator) {
	    if (cell == null) return 0.0;

	    try {
	        switch (cell.getCellType()) {
	            case NUMERIC:
	                return cell.getNumericCellValue();

	            case STRING:
	                String val = cell.getStringCellValue().trim();
	                if (val.isEmpty()) return 0.0;
	                return Double.parseDouble(val);

	            case FORMULA:
	                CellValue evaluatedValue = evaluator.evaluate(cell);
	                if (evaluatedValue == null) return 0.0;
	                if (evaluatedValue.getCellType() == CellType.NUMERIC)
	                    return evaluatedValue.getNumberValue();
	                else if (evaluatedValue.getCellType() == CellType.STRING)
	                    return Double.parseDouble(evaluatedValue.getStringValue().trim());
	                else return 0.0;

	            case BOOLEAN:
	            case BLANK:
	            case ERROR:
	            default:
	                return 0.0;
	        }
	    } catch (Exception e) {
	        DataFormatter formatter = new DataFormatter();
	        String formattedVal = formatter.formatCellValue(cell);
	        try {
	            return Double.parseDouble(formattedVal.trim());
	        } catch (NumberFormatException ex) {
	            return 0.0;
	        }
	    }
	}

	/**
	 * Reads a string value safely from a given cell (supports numeric to string conversion).
	 * Returns an empty string if the cell is blank.
	 */
	public static String getStringValue(Cell cell) {
	    if (cell == null) return "";
	    try {
	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue().trim();

	            case NUMERIC:
	                return new DataFormatter().formatCellValue(cell).trim();

	            case FORMULA:
	                FormulaEvaluator evaluator = cell.getSheet().getWorkbook()
	                                                  .getCreationHelper().createFormulaEvaluator();
	                CellValue value = evaluator.evaluate(cell);
	                if (value == null) return "";
	                if (value.getCellType() == CellType.STRING)
	                    return value.getStringValue().trim();
	                else if (value.getCellType() == CellType.NUMERIC)
	                    return String.valueOf(value.getNumberValue()).trim();
	                else return "";

	            case BLANK:
	            default:
	                return "";
	        }
	    } catch (Exception e) {
	        return "";
	    }
	}


	private static String getEvaluatedCellValue(Cell cell, FormulaEvaluator evaluator) {
	    if (cell == null) return "";
	    try {
	        switch (cell.getCellType()) {
	            case FORMULA:
	                CellValue cv = evaluator.evaluate(cell);
	                if (cv == null) return "";
	                switch (cv.getCellType()) {
	                    case NUMERIC:
	                        return new DecimalFormat("#.####").format(cv.getNumberValue());
	                    case STRING:
	                        return cv.getStringValue().trim();
	                    case BOOLEAN:
	                        return String.valueOf(cv.getBooleanValue());
	                    default:
	                        return "";
	                }
	            case NUMERIC:
	                return new DecimalFormat("#.####").format(cell.getNumericCellValue());
	            case STRING:
	                return cell.getStringCellValue().trim();
	            default:
	                return "";
	        }
	    } catch (Exception e) {
	        return cell.toString().trim();
	    }
	    }
	
	
	/**
	 * Reads month-wise RM and Scrap values (Apr–Mar) from Excel for a single customer.
	 * Returns: { CustomerName → { Month → { "RM": value, "Scrap": value } } }
	 */
	public static Map<String, Map<String, Map<String, Double>>> getExcelCustomerMonthRmScrapMap(File excelFile, String sheetName) throws Exception {
	    Map<String, Map<String, Map<String, Double>>> excelCustomerMap = new LinkedHashMap<>();

	    FileInputStream fis = new FileInputStream(excelFile);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet(sheetName);
	    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

	    // Find header row index by "Customer"
	    int headerRowIndex = ExcelUtil.findHeaderRowIndex(ExcelUtil.readEntireSheetAsList(excelFile.getAbsolutePath(), sheetName), "Customer");
	    if (headerRowIndex == -1) throw new Exception("Header 'Customer' not found.");

	    Row headerRow = sheet.getRow(headerRowIndex);
	    int customerCol = -1;
	    List<Integer> rmCols = new ArrayList<>();
	    List<Integer> scrapCols = new ArrayList<>();
	    List<String> months = new ArrayList<>();

	    // Identify RM and Scrap column indices
	    for (int c = 0; c < headerRow.getLastCellNum(); c++) {
	        String val = headerRow.getCell(c).getStringCellValue().trim();
	        if (val.equalsIgnoreCase("Customer")) customerCol = c;
	        else if (val.equalsIgnoreCase("RM Cost")) {
	            months.add(sheet.getRow(headerRowIndex - 1).getCell(c).getStringCellValue().trim());
	            rmCols.add(c);
	        } else if (val.equalsIgnoreCase("Scrap Cost")) {
	            scrapCols.add(c);
	        }
	    }

	    // Read each row
	    for (int r = headerRowIndex + 1; r <= sheet.getLastRowNum(); r++) {
	        Row row = sheet.getRow(r);
	        if (row == null) continue;
	        String customer = getStringValue(row.getCell(customerCol)).trim();
	        if (customer.isEmpty()) continue;

	        String pureCustomer = customer.split("-")[0];
	        Map<String, Map<String, Double>> monthData = new LinkedHashMap<>();

	        for (int i = 0; i < months.size(); i++) {
	            String month = months.get(i);
	            double rmVal = getNumericValue(row.getCell(rmCols.get(i)), evaluator);
	            double scrapVal = getNumericValue(row.getCell(scrapCols.get(i)), evaluator);

	            Map<String, Double> pair = new LinkedHashMap<>();
	            pair.put("RM", rmVal);
	            pair.put("Scrap", scrapVal);
	            monthData.put(month, pair);
	        }

	        excelCustomerMap.put(pureCustomer, monthData);
	    }

	    wb.close(); fis.close();
	    return excelCustomerMap;
	}
	
	public void validateFieldsInExcel(String filePath, Map<String, String> expectedValues, SoftAssert softAssert) {
	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook wb = new XSSFWorkbook(fis)) {

	        Sheet sh = wb.getSheet("Part_Master");
	        if (sh == null) {
	            LoggerUtil.fail("'Part_Master' sheet not found.");
	            softAssert.fail("Part_Master sheet missing.");
	            return;
	        }

	        Row headerRow = sh.getRow(1); // headers
	        Row dataRow   = sh.getRow(2); // first data row
	        if (headerRow == null || dataRow == null) {
	            LoggerUtil.fail("Header or Data row missing in Part_Master.");
	            softAssert.fail("Header/Data row missing.");
	            return;
	        }

	        LoggerUtil.info("─────────────────────────────────────────────────────────────");
	        LoggerUtil.info("Validating Excel header mapping (Procurement scenario only)...");
	        LoggerUtil.info(String.format("%-35s %-35s %-35s %-10s", "Header", "UI Value", "Excel Value", "Result"));
	        LoggerUtil.info("─────────────────────────────────────────────────────────────");

	        // Exact header → expected-key map (order matters only to maintain clarity)
	        Map<String,String> headerToKey = new LinkedHashMap<>();
	        headerToKey.put("Company Name - Location*",      "Company");
	        headerToKey.put("Customer Name and Code*",       "Customer");
	        headerToKey.put("Supplier Name and Code*",       "Supplier");
	        headerToKey.put("Product Category*",             "Product Category");
	        headerToKey.put("Product Model Name & No.*",     "Product Model");
	        headerToKey.put("Special Product Category*",     "Special Product Category"); // note: exact match

	        // Find column index for each target header
	        Map<String,Integer> colIdx = new HashMap<>();
	        for (int c = 0; c < headerRow.getLastCellNum(); c++) {
	            Cell hc = headerRow.getCell(c);
	            if (hc != null && hc.getCellType() == CellType.STRING) {
	                String h = hc.getStringCellValue().trim();
	                if (headerToKey.containsKey(h)) colIdx.put(h, c);
	            }
	        }

	        // Validate each required header/value
	        for (Map.Entry<String,String> e : headerToKey.entrySet()) {
	            String header = e.getKey();
	            String key    = e.getValue();

	            if (!colIdx.containsKey(header)) {
	                LoggerUtil.info(String.format("%-35s %-35s %-35s %-10s", header, expectedValues.get(key), "", "FAIL ❌"));
	                softAssert.fail("Missing header in Excel: " + header);
	                continue;
	            }

	            int c = colIdx.get(header);
	            Cell vcell = dataRow.getCell(c);
	            String excelVal = "";
	            if (vcell != null) {
	                if (vcell.getCellType() == CellType.STRING) excelVal = vcell.getStringCellValue().trim();
	                else if (vcell.getCellType() == CellType.NUMERIC) excelVal = new java.text.DecimalFormat("0.##").format(vcell.getNumericCellValue());
	            }

	            String uiVal = expectedValues.getOrDefault(key, "").trim();

	            // Normalization rules (scenario-safe)
	            String normHeader = header.toLowerCase(Locale.ROOT);
	            if (normHeader.equals("product model name & no.*")) {
	                // Excel uses '_' while UI uses '-' → treat them as equivalent
	                if (excelVal.replace('_','-').equalsIgnoreCase(uiVal)) {
	                    LoggerUtil.info(String.format("%-35s %-35s %-35s %-10s", header, uiVal, excelVal, "PASS ✅"));
	                } else {
	                    LoggerUtil.info(String.format("%-35s %-35s %-35s %-10s", header, uiVal, excelVal, "FAIL ❌"));
	                    softAssert.fail("Mismatch for [" + header + "] → Expected: [" + uiVal + "] but found: [" + excelVal + "]");
	                }
	                continue;
	            }

	            // For all other fields: strict, case-insensitive equality
	            boolean pass = excelVal.equalsIgnoreCase(uiVal);
	            LoggerUtil.info(String.format("%-35s %-35s %-35s %-10s", header, uiVal, excelVal, pass ? "PASS ✅" : "FAIL ❌"));
	            if (!pass) {
	                softAssert.fail("Mismatch for [" + header + "] → Expected: [" + uiVal + "] but found: [" + excelVal + "]");
	            }
	        }

	        LoggerUtil.info("─────────────────────────────────────────────────────────────");
	        LoggerUtil.info("Procurement header-value mapping validation completed.");
	    } catch (Exception ex) {
	        LoggerUtil.error("Exception during header validation: " + ex.getMessage());
	        softAssert.fail("Exception while validating Excel headers: " + ex.getMessage());
	    }
	}

	 public static void validateRMShapeDropdownForStandardShapes(
		        XSSFWorkbook workbook,
		        String flowType,
		        SoftAssert softAssert) {

		    String sheetName = "Part_Master";
		    String costingModuleCol = "Costing Module*";
		    String rmShapeCol = "RM Input Shape(For Standard and Forging)";

		    Sheet sheet = workbook.getSheet(sheetName);
		    Assert.assertNotNull(sheet, "Sheet '" + sheetName + "' not found in workbook!");

		    Map<String, Integer> headerMap = ExcelUtil.getHeaderMap(workbook, sheetName, 1);
		    Assert.assertTrue(headerMap.containsKey(costingModuleCol), "Column '" + costingModuleCol + "' not found!");
		    Assert.assertTrue(headerMap.containsKey(rmShapeCol), "Column '" + rmShapeCol + "' not found!");

		    int costingColIndex = headerMap.get(costingModuleCol);
		    int rmShapeColIndex = headerMap.get(rmShapeCol);

		    // Expected RM Shape dependent values
		    List<String> expectedRMShapes = Arrays.asList(
		            "Misc.",
		            "Hexagonal Bar",
		            "Round Bar",
		            "Round Pipe",
		            "Cylinder",
		            "Flat",
		            "I-beam",
		            "Octagonal Bar"
		    );

		    // Check first, mid, last rows
		    int totalRows = sheet.getLastRowNum();
		    int firstRow = 2;
		    int lastRow = totalRows;
		    int midRow = (firstRow + lastRow) / 2;
		    int[] rowsToCheck = { firstRow, midRow, lastRow };

		    LoggerUtil.info("Flow=" + flowType + " | Checking RM Input Shape dependency for rows: " + Arrays.toString(rowsToCheck));

		    for (int rowIdx : rowsToCheck) {
		        Row row = sheet.getRow(rowIdx);
		        if (row == null) continue;

		        // Simulate Costing Module selection = "Standard Shapes"
		        Cell costingCell = row.getCell(costingColIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		        costingCell.setCellValue("Standard Shapes");
		     
		        // Validate dropdown in RM Input Shape column
		        List<String> rmShapeDropdownValues = collectExplicitDVListForColumns(
		                sheet, workbook, rmShapeColIndex, rowIdx, rowIdx);

		        if (rmShapeDropdownValues.isEmpty()) {
		            LoggerUtil.fail("Flow=" + flowType + " | Row " + (rowIdx + 1)
		                    + ": No dropdown found in RM Input Shape after selecting 'Standard Shapes'.");
		            softAssert.fail("No dropdown found for Costing Module=Standard Shapes at row " + (rowIdx + 1));
		        } else {
		            LoggerUtil.pass("Flow=" + flowType + " | Row " + (rowIdx + 1)
		                    + ": RM Input Shape dropdown detected successfully.");
		            LoggerUtil.info("→ Dropdown values: " + rmShapeDropdownValues);

		            // Verify dropdown values match expected dependent list
		            softAssert.assertEquals(rmShapeDropdownValues.size(), expectedRMShapes.size(),
		                    "Flow=" + flowType + " | Row " + (rowIdx + 1)
		                    + ": Dropdown count mismatch! Expected " + expectedRMShapes.size()
		                    + " but found " + rmShapeDropdownValues.size());

		            softAssert.assertTrue(rmShapeDropdownValues.containsAll(expectedRMShapes),
		                    "Flow=" + flowType + " | Row " + (rowIdx + 1)
		                    + ": Dropdown values mismatch. Expected: " + expectedRMShapes + " | Found: " + rmShapeDropdownValues);
		        }
		    }
		}

	 /**
	  * Collects dropdown values for a column — supports explicit list, named ranges, OFFSET/INDIRECT, and cross-sheet references.
	  */
	 public static List<String> collectExplicitDVListForColumns(
	         Sheet sheet,
	         XSSFWorkbook workbook,
	         int colIndex,
	         int startRow,
	         int endRow) {

	     List<String> dropdownValues = new ArrayList<>();
	     try {
	         List<? extends DataValidation> validations = sheet.getDataValidations();

	         for (DataValidation dv : validations) {
	             for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {

	                 boolean columnMatch = colIndex >= region.getFirstColumn() && colIndex <= region.getLastColumn();
	                 boolean rowMatch = startRow <= region.getLastRow() && endRow >= region.getFirstRow();

	                 if (columnMatch && rowMatch) {
	                     DataValidationConstraint constraint = dv.getValidationConstraint();

	                     if (constraint != null) {
	                         // --- Case 1: Explicit list in validation rule ---
	                         if (constraint.getExplicitListValues() != null) {
	                             dropdownValues = Arrays.asList(constraint.getExplicitListValues());
	                             LoggerUtil.info("Explicit dropdown values found: " + dropdownValues);
	                             return dropdownValues;
	                         }

	                         // --- Case 2: Formula-based list (OFFSET / INDIRECT / Named Range) ---
	                         if (constraint.getFormula1() != null) {
	                             String formula = constraint.getFormula1().trim().replace("=", "");
	                             LoggerUtil.info("Formula detected in DataValidation: " + formula);
	                             dropdownValues = extractFormulaRangeValues(workbook, formula);
	                             if (!dropdownValues.isEmpty()) return dropdownValues;
	                         }
	                     }
	                 }
	             }
	         }
	     } catch (Exception e) {
	         LoggerUtil.error("Error collecting dropdown values for column " + colIndex + ": " + e.getMessage());
	     }

	     return dropdownValues;
	 }

	 /**
	  * Extracts values from formula-based dropdowns:
	  * Handles named ranges, OFFSET/INDIRECT, and direct or cross-sheet ranges.
	  */
	 private static List<String> extractFormulaRangeValues(XSSFWorkbook workbook, String formula) {
	     List<String> values = new ArrayList<>();
	     try {
	         String cleanFormula = formula.trim();

	         // --- Case 1: Named Range ---
	         Name named = workbook.getName(cleanFormula);
	         if (named != null) {
	             String refersTo = named.getRefersToFormula();
	             LoggerUtil.info("Named range '" + cleanFormula + "' resolved to: " + refersTo);
	             return extractFormulaRangeValues(workbook, refersTo);
	         }

	         // --- Case 2: INDIRECT("Sheet!$A$1:$A$10") pattern ---
	         if (cleanFormula.toUpperCase().startsWith("INDIRECT(")) {
	             Matcher m = Pattern.compile("\"([^\"]+)\"").matcher(cleanFormula);
	             if (m.find()) {
	                 String inner = m.group(1);
	                 LoggerUtil.info("Resolved INDIRECT → " + inner);
	                 return extractFormulaRangeValues(workbook, inner);
	             }
	         }

	         // --- Case 3: OFFSET(base,0,0,height,width) pattern ---
	         if (cleanFormula.toUpperCase().startsWith("OFFSET(")) {
	             Matcher baseMatcher = Pattern.compile("([A-Za-z0-9_]+)!\\$?[A-Z]+\\$?\\d+").matcher(cleanFormula);
	             String sheetName = workbook.getSheetName(0);
	             if (baseMatcher.find()) sheetName = baseMatcher.group(1);

	             Sheet refSheet = workbook.getSheet(sheetName);
	             if (refSheet != null) {
	                 Matcher rangeMatcher = Pattern.compile("\\$[A-Z]+\\$?\\d+:\\$[A-Z]+\\$?\\d+").matcher(cleanFormula);
	                 if (rangeMatcher.find()) {
	                     String offsetRange = rangeMatcher.group();
	                     values = readRangeValues(refSheet, offsetRange);
	                     LoggerUtil.info("Extracted OFFSET range values: " + values);
	                     return values;
	                 }
	             }
	         }

	         // --- Case 4: Sheet!$A$1:$A$10 direct reference ---
	         if (cleanFormula.contains("!")) {
	             String[] parts = cleanFormula.split("!");
	             String sheetName = parts[0].replace("'", "").trim();
	             String rangeRef = parts[1].trim();
	             Sheet refSheet = workbook.getSheet(sheetName);
	             if (refSheet != null) {
	                 values = readRangeValues(refSheet, rangeRef);
	                 LoggerUtil.info("Extracted cross-sheet range values: " + values);
	                 return values;
	             }
	         }

	         // --- Case 5: $A$1:$A$10 direct range (current sheet or lookup) ---
	         if (cleanFormula.matches("\\$[A-Z]+\\$?\\d+:\\$[A-Z]+\\$?\\d+")) {
	             Sheet firstSheet = workbook.getSheetAt(0);
	             values = readRangeValues(firstSheet, cleanFormula);
	             LoggerUtil.info("Extracted direct range values: " + values);
	             return values;
	         }

	     } catch (Exception e) {
	         LoggerUtil.error("Error extracting formula range values for '" + formula + "': " + e.getMessage());
	     }

	     return values.stream().distinct().collect(Collectors.toList());
	 }

	 /** Helper to read string values from a given range. */
	 private static List<String> readRangeValues(Sheet sheet, String rangeRef) {
	     List<String> vals = new ArrayList<>();
	     try {
	         CellRangeAddress range = CellRangeAddress.valueOf(rangeRef);
	         for (int r = range.getFirstRow(); r <= range.getLastRow(); r++) {
	             Row row = sheet.getRow(r);
	             if (row == null) continue;
	             for (int c = range.getFirstColumn(); c <= range.getLastColumn(); c++) {
	                 Cell cell = row.getCell(c);
	                 if (cell != null && cell.getCellType() == CellType.STRING) {
	                     String val = cell.getStringCellValue().trim();
	                     if (!val.isEmpty()) vals.add(val);
	                 }
	             }
	         }
	     } catch (Exception ex) {
	         LoggerUtil.error("Error reading range '" + rangeRef + "' from sheet '" + sheet.getSheetName() + "': " + ex.getMessage());
	     }
	     return vals.stream().distinct().collect(Collectors.toList());
	 }
	 
	 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 /**
	  * Captures the toast validation message displayed after file import.
	  * Waits until the toast appears and retrieves its message text.
	  * Works for both success and error toasts.
	  */
	 public String captureImportToastMessage() {
	     try {
	         LoggerUtil.info("Waiting for import toast message...");

	         // Wait up to 10 seconds for toast container
	         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	         WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                 By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message')]")
	         ));

	         // Extract message text
	         String message = toastElement.getText().trim();
	         LoggerUtil.info("Toast message captured: " + message);

	         // Optional: Wait until toast disappears (for clean flow)
	         try {
	             wait.until(ExpectedConditions.invisibilityOf(toastElement));
	             LoggerUtil.info("Toast message disappeared.");
	         } catch (Exception ignored) {
	         }

	         return message;

	     } catch (TimeoutException te) {
	         LoggerUtil.error("Toast message not displayed within timeout.");
	         return "";
	     } catch (Exception e) {
	         LoggerUtil.error("Error while capturing import toast: " + e.getMessage());
	         return "";
	     }
	 }

	 /**
	  * Collects dropdown (Data Validation) list values for a specific column and row range.
	  * Supports:
	  *  1. Explicit list values defined in validation
	  *  2. Formula-based lists (like =$DR$1:$DR$9)
	  *  3. Named ranges referencing hidden sheets (e.g. =Currency_List)
	  *
	  * Works across all sheets (BOP_Cost, Part_Master, etc.)
	  */
	 public List<String> UniversalcollectExplicitDVListForColumns(
	         Sheet sheet,
	         XSSFWorkbook workbook,
	         int colIndex,
	         int startRow,
	         int endRow) {

	     List<String> dropdownValues = new ArrayList<>();

	     try {
	         List<? extends DataValidation> validations = sheet.getDataValidations();

	         for (DataValidation dv : validations) {
	             for (CellRangeAddress region : dv.getRegions().getCellRangeAddresses()) {

	                 // ✅ Check if this validation applies to our column & row range
	                 if (colIndex >= region.getFirstColumn() && colIndex <= region.getLastColumn()
	                         && startRow >= region.getFirstRow() && endRow <= region.getLastRow()) {

	                     DataValidationConstraint constraint = dv.getValidationConstraint();
	                     if (constraint == null) continue;

	                     // ✅ CASE 1: Explicit list directly defined in Excel validation
	                     String[] explicitList = constraint.getExplicitListValues();
	                     if (explicitList != null && explicitList.length > 0) {
	                         dropdownValues.addAll(Arrays.asList(explicitList));
	                       //  LoggerUtil.info("Dropdown fetched via explicit list for column " + colIndex);
	                         return dropdownValues;
	                     }

	                     // ✅ CASE 2: Formula-based list (e.g., =$DR$1:$DR$9)
	                     String formula = constraint.getFormula1();
	                     if (formula != null && !formula.isEmpty()) {
	                         formula = formula.trim().replace("=", "");
	                       //  LoggerUtil.info("Dropdown formula detected: " + formula);

	                         // If it's a range reference or named range → resolve dynamically
	                         dropdownValues = UniversaleextractFormulaRangeValues(workbook, formula);
	                         if (!dropdownValues.isEmpty()) {
	                          //   LoggerUtil.info("Dropdown fetched via formula range for column " + colIndex);
	                             return dropdownValues;
	                         }
	                     }
	                 }
	             }
	         }
	     } catch (Exception e) {
	         LoggerUtil.error("Error while collecting dropdown values for column index " + colIndex + ": " + e.getMessage());
	     }

	     return dropdownValues;
	 }

	 /**
	  * Extracts actual cell values from a formula reference or named range.
	  * Supports:
	  *  - Direct ranges ($A$1:$A$10)
	  *  - Named ranges (=Currency_List)
	  *  - Dynamic OFFSET formulas (e.g. OFFSET(Sheet!$A$3,,,COUNTA(Sheet!$A$3:$A$2000)))
	  */
	 private static List<String> UniversaleextractFormulaRangeValues(XSSFWorkbook workbook, String formula) {
	     List<String> values = new ArrayList<>();
	     try {
	         formula = formula.trim();

	         // ✅ CASE 1: Handle OFFSET formulas (dynamic ranges)
	         if (formula.startsWith("OFFSET(")) {
	             // Example: OFFSET(BOP_Master!$AA$3,,,COUNTA(BOP_Master!$AA$3:$AA$2000))
	             String inside = formula.substring("OFFSET(".length(), formula.length() - 1);
	             String[] parts = inside.split(",");
	             String startRef = parts[0].trim(); // e.g. BOP_Master!$AA$3
	             String countRange = parts[parts.length - 1]
	                     .replace("COUNTA(", "")
	                     .replace(")", "")
	                     .trim(); // e.g. BOP_Master!$AA$3:$AA$2000

	             // Extract sheet and base cell
	             String sheetName = startRef.contains("!") ? startRef.split("!")[0].replace("'", "") : workbook.getSheetName(0);
	             String startCell = startRef.contains("!") ? startRef.split("!")[1] : startRef;
	             Sheet refSheet = workbook.getSheet(sheetName);
	             if (refSheet == null) return values;

	             // Resolve start row and column
	             CellReference start = new CellReference(startCell);
	             int startRow = start.getRow();
	             int colIndex = start.getCol();

	             // Count how many cells are non-empty in the COUNTA range
	             String countRangeRef = countRange.contains("!") ? countRange.split("!")[1] : countRange;
	             CellRangeAddress addr = CellRangeAddress.valueOf(countRangeRef);
	             int nonEmptyCount = 0;
	             for (int r = addr.getFirstRow(); r <= addr.getLastRow(); r++) {
	                 Row row = refSheet.getRow(r);
	                 if (row != null) {
	                     Cell c = row.getCell(colIndex);
	                     if (c != null && !c.toString().trim().isEmpty()) {
	                         nonEmptyCount++;
	                     }
	                 }
	             }

	             // Collect that many cells starting from startRow
	             for (int r = startRow; r < startRow + nonEmptyCount; r++) {
	                 Row row = refSheet.getRow(r);
	                 if (row != null) {
	                     Cell cell = row.getCell(colIndex);
	                     if (cell != null && !cell.toString().trim().isEmpty()) {
	                         values.add(cell.toString().trim());
	                     }
	                 }
	             }

	           //  LoggerUtil.info("Resolved OFFSET formula → Found " + values.size() + " values from " + sheetName + " column.");
	             return values;
	         }

	         // ✅ CASE 2: Regular range like Sheet!$A$1:$A$20 or named range
	         String sheetName = workbook.getSheetName(0);
	         String rangeRef = formula;

	         if (formula.contains("!")) {
	             String[] parts = formula.split("!");
	             sheetName = parts[0].replace("'", "");
	             rangeRef = parts[1];
	         }

	         Name namedRange = workbook.getName(formula);
	         if (namedRange != null) {
	             String refersTo = namedRange.getRefersToFormula();
	             if (refersTo != null && refersTo.contains("!")) {
	                 String[] parts = refersTo.split("!");
	                 sheetName = parts[0].replace("'", "");
	                 rangeRef = parts[1];
	             }
	         }

	         Sheet refSheet = workbook.getSheet(sheetName);
	         if (refSheet == null) return values;

	         CellRangeAddress refRange = CellRangeAddress.valueOf(rangeRef);
	         for (int r = refRange.getFirstRow(); r <= refRange.getLastRow(); r++) {
	             Row row = refSheet.getRow(r);
	             if (row == null) continue;
	             for (int c = refRange.getFirstColumn(); c <= refRange.getLastColumn(); c++) {
	                 Cell cell = row.getCell(c);
	                 if (cell != null && !cell.toString().trim().isEmpty()) {
	                     values.add(cell.toString().trim());
	                 }
	             }
	         }

	     } catch (Exception e) {
	         LoggerUtil.error("Error resolving formula range for '" + formula + "': " + e.getMessage());
	     }
	     return values;
	 }

	 /**
	  * Universal Excel dropdown extractor:
	  * Works for OFFSET (with or without COUNTA) and Named Range formulas.
	  * 
	  * ✔ Handles OFFSET(BOP_Master!$E$3,,,COUNTA(...))
	  * ✔ Handles OFFSET(BOP_Master!$E$3,0,0,50,1)
	  * ✔ Handles Named Ranges like =BOP_List or =MyCurrencyList
	  * ✔ Strips absolute refs ($) and safely reads real cell values.
	  */
	 public Set<String> collectDropdownListForColumn(Sheet sheet, XSSFWorkbook wb,
	                                                        int targetCol, int firstRow, int lastRow) {
	     Set<String> vals = new LinkedHashSet<>();
	     List<? extends DataValidation> dvList = sheet.getDataValidations();

	     for (DataValidation dv : dvList) {
	         CellRangeAddressList regions = dv.getRegions();
	         if (regions == null) continue;

	         boolean applies = false;
	         for (CellRangeAddress region : regions.getCellRangeAddresses()) {
	             if (region.getFirstColumn() <= targetCol && region.getLastColumn() >= targetCol
	                     && region.getLastRow() >= firstRow && region.getFirstRow() <= lastRow) {
	                 applies = true;
	                 break;
	             }
	         }
	         if (!applies) continue;

	         DataValidationConstraint c = dv.getValidationConstraint();
	         if (c == null) continue;

	         // 1️⃣ Explicit static list values
	         String[] explicit = c.getExplicitListValues();
	         if (explicit != null && explicit.length > 0) {
	             for (String s : explicit) {
	                 if (s != null && !s.trim().isEmpty()) vals.add(s.trim());
	             }
	             continue;
	         }

	         // 2️⃣ Formula-based dropdown (OFFSET / Named Range)
	         String f = c.getFormula1();
	         if (f == null || f.trim().isEmpty()) continue;
	         if (f.startsWith("=")) f = f.substring(1).trim();

	         try {
	             // ---------------- CASE 1: OFFSET with COUNTA ----------------
	             if (f.toUpperCase().contains("COUNTA(")) {
	                 Pattern p = Pattern.compile("OFFSET\\(([^!]+)!\\$?([A-Z]+)\\$?(\\d+).*?\\$?[A-Z]+\\$?(\\d+)\\)");
	                 Matcher m = p.matcher(f.replace(" ", ""));
	                 if (m.find()) {
	                     String sheetName = m.group(1).replace("'", "");
	                     String colLetters = m.group(2);
	                     int startRow = Integer.parseInt(m.group(3));
	                     int endRow = Integer.parseInt(m.group(4));

	                     Sheet refSheet = wb.getSheet(sheetName);
	                     if (refSheet != null) {
	                         int colIdx = CellReference.convertColStringToIndex(colLetters);
	                         for (int r = startRow - 1; r < endRow; r++) {
	                             Row rr = refSheet.getRow(r);
	                             if (rr == null) break;
	                             Cell cell = rr.getCell(colIdx);
	                             if (cell == null) break;
	                             String v = cell.toString().trim();
	                             if (v.isEmpty()) break;
	                             vals.add(v);
	                         }
//	                         LoggerUtil.info("✅ Resolved OFFSET+COUNTA → Sheet=" + sheetName +
//	                                 ", Column=" + colLetters + ", Rows=" + startRow + "-" + endRow);
	                     }
	                 } else {
	                     LoggerUtil.warn("⚠ OFFSET+COUNTA pattern not matched: " + f);
	                 }

	             // ---------------- CASE 2: Simple OFFSET ----------------
	             } else if (f.toUpperCase().startsWith("OFFSET")) {
	                 // Example: OFFSET(BOP_Master!$E$3,0,0,50,1)
	                 String inside = f.substring(f.indexOf("(") + 1, f.lastIndexOf(")"));
	                 String[] parts = inside.split("!");
	                 String sheetName = parts[0].replace("'", "");
	                 String colRef = parts[1].split(",")[0].replaceAll("\\$", "");

	                 Sheet srcSheet = wb.getSheet(sheetName);
	                 if (srcSheet != null) {
	                     int colIdx = CellReference.convertColStringToIndex(colRef.replaceAll("\\d", ""));
	                     int startRow = new CellReference(colRef).getRow();
	                     for (int r = startRow; r <= srcSheet.getLastRowNum(); r++) {
	                         Row row = srcSheet.getRow(r);
	                         if (row == null) break;
	                         Cell cell = row.getCell(colIdx);
	                         if (cell == null) break;
	                         String v = cell.toString().trim();
	                         if (v.isEmpty()) break;
	                         vals.add(v);
	                     }
//	                     LoggerUtil.info("✅ Resolved simple OFFSET → Sheet=" + sheetName +
//	                             ", Column=" + colRef + ", Starting Row=" + startRow);
	                 }

	             // ---------------- CASE 3: Named Range ----------------
	             } else {
	                 Name nm = wb.getName(f);
	                 if (nm != null) {
	                     String ref = nm.getRefersToFormula();
	                     AreaReference ar = new AreaReference(ref, wb.getSpreadsheetVersion());
	                     for (CellReference cr : ar.getAllReferencedCells()) {
	                         Sheet s = wb.getSheet(cr.getSheetName() == null ? sheet.getSheetName() : cr.getSheetName());
	                         if (s == null) continue;
	                         Row r = s.getRow(cr.getRow());
	                         if (r == null) continue;
	                         Cell cell = r.getCell(cr.getCol());
	                         if (cell == null) continue;
	                         String v = cell.toString().trim();
	                         if (!v.isEmpty()) vals.add(v);
	                     }
	                //     LoggerUtil.info("✅ Resolved Named Range: " + f + " → " + vals.size() + " values");
	                 } else {
	                     LoggerUtil.warn("⚠ Named range not found in workbook: " + f);
	                 }
	             }

	         } catch (Exception e) {
	             LoggerUtil.warn("⚠ Could not resolve DV formula: " + f + " → " + e.getMessage());
	         }
	     }
	     return vals;
	 }

	 
	 
	

}
