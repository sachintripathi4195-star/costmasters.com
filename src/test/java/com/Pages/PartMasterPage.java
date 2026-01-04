package com.Pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;

import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;
public class PartMasterPage extends Base{
	public static final By enterOnPartNumber =By.xpath("//input[@id='PartNo']");
	public static final By enterOnPartDescription =By.xpath("//input[@id='PartDescription']");
	public static final By enterOnCustomerPartNumber =By.xpath("//input[@id='CustomerPartNo']");
	public static final By enterOnHSNCode =By.xpath("//input[@id='HSN_Code']");
	public static final By selectOnPartUOM =By.xpath("//span[@id='select2-PartUOM-container']");
	public static final By clickOnCompanyDropdown =By.xpath("//select[@id='PlantSelection']/ancestor::div/span[@class='multiselect-native-select']");
	public static final By ListOfPartUom = By.xpath("//ul[@id='select2-PartUOM-results']/li");
	public static final By ListOfCompanyDropdown =By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]");
    public static final By ListOfCheckBoxCompanyDropDown =By.xpath("//div[@class='multiselect-container dropdown-menu show']/div/following-sibling::button/following-sibling::button/span/label");
   public static final  By ListOfCheckBoxCompanyText=By.xpath("//div[@class='multiselect-container dropdown-menu show']/div/following-sibling::button/following-sibling::button/span/label");
    public static final By PartMasterPMSave	=By.xpath("//button[@id='modelSave']");
    public static final By toastMessage	=By.xpath("//div[@class='toast-message']");
   // public static final By optionElements =By.cssSelector("ul.select2-results__options li");
    
	public 	SoftAssert soft;
	
	public void verifyPlaceholderValue() {
				
		soft = new SoftAssert();
		String actualEnterOnPartNumber = waitForExpectedElement(enterOnPartNumber).getAttribute("placeholder");
		String ExpectedEnterOnPartNumber = "Enter";				
		try {
		LoggerUtil.info("Actual Value = "+actualEnterOnPartNumber+ " || and || Expected Value = " + ExpectedEnterOnPartNumber);
	
		soft.assertEquals(actualEnterOnPartNumber, ExpectedEnterOnPartNumber,"EnterOnPartNumber:- Placeholder Value Are Mismatched");		
		LoggerUtil.pass("EnterOnPartNumber:- Value Are Matched");
		}catch(Exception e) {
			LoggerUtil.error("EnterOnPartNumber:- PlaceHolder Value Are Mismatched");
			
		}
		String actualEnterOnPartDescription = waitForExpectedElement(enterOnPartDescription).getAttribute("placeholder");
		String ExpectedEnterOnPartDescription = "Enter";				
		try {
		LoggerUtil.info("Actual Value = "+actualEnterOnPartDescription+ " || and || Expected Value = " + ExpectedEnterOnPartDescription);
	
		soft.assertEquals(actualEnterOnPartDescription, ExpectedEnterOnPartDescription,"EnterOnPartDescription Placeholder Value Are Mismatched");		
		LoggerUtil.pass("EnterOnPartDescription:- Value Are Matched");
		}catch(Exception e) {
			LoggerUtil.error("EnterOnPartDescription:- PlaceHolder Value Are Mismatched");
			
		}		
		String actualEnterOnCustomerPartNumber = waitForExpectedElement(enterOnCustomerPartNumber).getAttribute("placeholder");
		String ExpectdEnenterOnCustomerPartNumber = "Enter";				
		try {
		LoggerUtil.info("Actual Value = "+actualEnterOnCustomerPartNumber+ " || and || Expected Value = " + ExpectdEnenterOnCustomerPartNumber);
	
		soft.assertEquals(actualEnterOnCustomerPartNumber, ExpectdEnenterOnCustomerPartNumber,"EnterOnCustomerPartNumber Placeholder Value Are Mismatched");		
		LoggerUtil.pass("EnterOnCustomerPartNumber:- Value Are Matched");
		}catch(Exception e) {
			LoggerUtil.error("EnterOnCustomerPartNumber:- PlaceHolder Value Are Mismatched");
			
		}
		String actualEnterOnHSNCode = waitForExpectedElement(enterOnHSNCode).getAttribute("placeholder");
		String ExpectdEnterOnHSNCode = "Enter";				
		try {
		LoggerUtil.info("Actual Value = "+actualEnterOnHSNCode+ " || and || Expected Value = " + ExpectdEnterOnHSNCode);
	
		soft.assertEquals(actualEnterOnHSNCode, ExpectdEnterOnHSNCode,"EnterOnHSNCode Placeholder Value Are Mismatched");		
		LoggerUtil.pass("EnterOnHSNCode:- Value Are Matched");
		}catch(Exception e) {
			LoggerUtil.error("EnterOnHSNCode:- PlaceHolder Value Are Mismatched");
			
		}
		
    }
	
	
	public void verifyHeaderNamesRelevance() {
	    LoggerUtil.info("PM_TC_002 - Verify Header Names Relevance");

	    // Expected header labels as per the UI
	    Map<String, String> expectedHeaders = new LinkedHashMap<>();
	    expectedHeaders.put("Part No.", "Part No.");
	    expectedHeaders.put("Part Description", "Part Description");
	    expectedHeaders.put("Customer Part No.", "Customer Part No.");
	    expectedHeaders.put("HSN Code", "HSN Code");
	    expectedHeaders.put("Part UOM", "Part UOM");
	    expectedHeaders.put("Company Name", "Company Name");
	    expectedHeaders.put("Customer", "Customer");
	    expectedHeaders.put("Supplier", "Supplier");
	    expectedHeaders.put("Product Category", "Product Category");
	    expectedHeaders.put("Product Model Name & No.", "Product Model Name & No.");
	    expectedHeaders.put("Special Product Category", "Special Product Category");

	    SoftAssert softAssert = new SoftAssert();

	    for (Map.Entry<String, String> entry : expectedHeaders.entrySet()) {
	        String headerLabel = entry.getKey(); // used in XPath search
	        String expectedValue = entry.getValue(); // expected label to compare

	        try {
	            // Locate the label containing the expected key text (even if it includes '*')
	           // WebElement labelElement = driver.findElement(By.xpath("//label[contains(normalize-space(),'" + headerLabel + "')]"));
	        	WebElement labelElement = driver.findElement(By.xpath("//label[normalize-space(text())='" + headerLabel + "']"));
	            String actualLabel = labelElement.getText().replace("*", "").trim(); // remove * for matching

	            LoggerUtil.info("Verifying header: '" + headerLabel + "' -> Actual on UI: '" + actualLabel + "'");
	            softAssert.assertEquals(actualLabel, expectedValue, "Header mismatch for: " + headerLabel);
	        } catch (NoSuchElementException e) {
	            LoggerUtil.error("Header label not found on screen: " + headerLabel);
	            softAssert.fail("Missing header: " + headerLabel);
	        }
	    }

	    softAssert.assertAll();
	}

	
	public void headersShouldAccuratelyReflectFieldPurpose(String txt) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(enterOnPartNumber), txt);
		try {
			LoggerUtil.info("PartNumber :-"+txt+ ":- is filled sucesfully");		
			LoggerUtil.pass("PartNumber :-"+txt+ ":- is filled sucesfully");
			}catch(Exception e) {
				LoggerUtil.error("PartNumber :-"+txt+ ":- is not filled sucesfully");
			}
		clearAndEnterText(waitForExpectedElement(enterOnPartDescription), txt);
		try {
			LoggerUtil.info("PartDescription :-"+txt+ ":- is filled sucesfully");		
			LoggerUtil.pass("PartDescription :-"+txt+ ":- is filled sucesfully");
			}catch(Exception e) {
				LoggerUtil.error("PartDescription :-"+txt+ ":- is not filled sucesfully");
			}
		clearAndEnterText(waitForExpectedElement(enterOnCustomerPartNumber), txt);
		try {
			LoggerUtil.info("CustomerPartNumber :-"+txt+ ":- is filled sucesfully");		
			LoggerUtil.pass("CustomerPartNumber :-"+txt+ ":- is filled sucesfully");
			}catch(Exception e) {
				LoggerUtil.error("CustomerPartNumber :-"+txt+ ":- is not filled sucesfully");
			}
		clearAndEnterText(waitForExpectedElement(enterOnHSNCode), txt);
		try {
			LoggerUtil.info("HSNCode :-"+txt+ ":- is filled sucesfully");		
			LoggerUtil.pass("HSNCode :-"+txt+ ":- is filled sucesfully");
			}catch(Exception e) {
				LoggerUtil.error("HSNCode :-"+txt+ ":- is not filled sucesfully");
			}
		clickOnElement(selectOnPartUOM);
		try {
			LoggerUtil.info("clicked on Part UOM");		
			LoggerUtil.pass("clicked on Part UOM");		
			}catch(Exception e) {
				LoggerUtil.error("NOT clicked on Part UOM");		
			}
		Thread.sleep(3000);
		List<WebElement> OptionsPartUom = driver.findElements(ListOfPartUom);
		Thread.sleep(2000);
		selectBootStrapDropDown(OptionsPartUom, "Abc");
		try {
			LoggerUtil.info("Select on Abc dropdwon");		
			LoggerUtil.pass("Select on Abc dropdwon");		
			}catch(Exception e) {
				LoggerUtil.error("not Selected on Abc dropdwon");		
			}
		clickOnElement(selectOnPartUOM);
		try {
			LoggerUtil.info("clicked on Part UOM");		
			LoggerUtil.pass("clicked on Part UOM");		
			}catch(Exception e) {
				LoggerUtil.error("NOT clicked on Part UOM");		
			}
		Thread.sleep(3000);
		List<WebElement> OptionsPartUom1 = driver.findElements(ListOfPartUom);
		Thread.sleep(2000);
		selectBootStrapDropDown(OptionsPartUom1, "Abc");
		try {
			LoggerUtil.info("Select on Abc dropdwon");		
			LoggerUtil.pass("Select on Abc dropdwon");		
			}catch(Exception e) {
				LoggerUtil.error("not Selected on Abc dropdwon");		
			}
		clickOnElement(clickOnCompanyDropdown);
		try {
			LoggerUtil.info("clicked on CompanyDropdown");		
			LoggerUtil.pass("clicked on CompanyDropdown");		
			}catch(Exception e) {
				LoggerUtil.error("NOT clicked on CompanyDropdown");		
			}
		Thread.sleep(3000);
		List<WebElement> OptionsPartUom2 = driver.findElements(ListOfCheckBoxCompanyDropDown);
		Thread.sleep(2000);
		
		int index = 2; // jis index par click karna hai (3rd element)

		for (int i = 0; i < OptionsPartUom2.size(); i++) {
		    if (i == index) {
		        WebElement checkbox = OptionsPartUom2.get(i);
		        checkbox.click();
		        break;
		    }
		}
	}
		
		public String verifyToastAlertMsg(String txt) {
			WebElement we=waitForVisibility(toastMessage, 3);
			String acMsg=we.getText();
			return acMsg;
		}
		
		///not used this methis end////
		public void partUOMDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(selectOnPartUOM);
			try {
				LoggerUtil.info("clicked on Part UOM");		
				LoggerUtil.pass("clicked on Part UOM");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Part UOM");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsPartUom = driver.findElements(ListOfPartUom);
			Thread.sleep(2000);
           
            List<String> originalList = new ArrayList<>();
            for (WebElement option : OptionsPartUom) {
                String text = option.getText().trim();
               
                if (!text.isEmpty()) {
                    originalList.add(text);
                }
            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Dropdown options are alphabetically ordered.");		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}
		public void companyNameDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(clickOnCompanyDropdown);
			try {
				LoggerUtil.info("clicked on Company Name Dropdown");		
				LoggerUtil.pass("clicked on Company Name Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Company Name Dropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsCompanyNameDropDown = driver.findElements(ListOfCheckBoxCompanyText);
			Thread.sleep(2000);
           
	            List<String> originalList = new ArrayList<>();
	            for (WebElement option : OptionsCompanyNameDropDown) {
	                String text = option.getText().trim();
	               
	                if (!text.isEmpty()) {
	                    originalList.add(text);
	                }
	            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Comapny Name Dropdown options are alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}

		public static final By clickoncustomerdrop = By.xpath("//select[@id='CustomerSelection']/following-sibling::div/button[@class='multiselect dropdown-toggle custom-select text-center']");
        public static final By customerotions = By.xpath("//select[@id='CustomerSelection']/option"); 
        
        public void customerDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(clickoncustomerdrop);
			try {
				LoggerUtil.info("clicked on Customer Dropdown");		
				LoggerUtil.pass("clicked on Customer Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Customer Dropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsCustomerNameDropDown = driver.findElements(customerotions);
			Thread.sleep(2000);
           
	            List<String> originalList = new ArrayList<>();
	            for (WebElement option : OptionsCustomerNameDropDown) {
	                String text = option.getText().trim();
	               
	                if (!text.isEmpty()) {
	                    originalList.add(text);
	                }
	            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Customer Dropdown options are alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Customer Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}
		public static final By clickOnSupplierDrop = By.xpath("//select[@id='SupplierSelection']/following-sibling::div/button[@class='multiselect dropdown-toggle custom-select text-center']");
		public static final By listOnSupplierDrop = By.xpath("//select[@id='SupplierSelection']/option");
		
		public void supplierDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(clickOnSupplierDrop);
			try {
				LoggerUtil.info("clicked on supplier Dropdown");		
				LoggerUtil.pass("clicked on supplier Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on supplier Dropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsSupplierNameDropDown = driver.findElements(listOnSupplierDrop);
			Thread.sleep(2000);
           
	            List<String> originalList = new ArrayList<>();
	            for (WebElement option : OptionsSupplierNameDropDown) {
	                String text = option.getText().trim();
	               
	                if (!text.isEmpty()) {
	                    originalList.add(text);
	                }
	            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Supplier Dropdown options are alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Supplier Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}
		public static final By clickOnProductCategoryDrop = By.xpath("//select[@id='ProductModel']/following::div[contains(@class,'btn-group')][1]//button/span[text()='None selected']");
		public static final By listOnProductCategoryDrop = By.xpath("//select[@id='ProductModel']/option");
		public static final By listOnProductCategoryDrops = By.xpath("//input[contains(@id,'multiselect_yks3qe3olgd_0_1')]/following-sibling::label[@class='form-check-label']");

		public void productCategoryDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(clickOnProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on Product Category Dropdown");		
				LoggerUtil.pass("clicked on Product CategoryDropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Product CategoryDropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsProductCategoryDropDown = driver.findElements(listOnProductCategoryDrop);
			Thread.sleep(2000);
           
	            List<String> originalList = new ArrayList<>();
	            for (WebElement option : OptionsProductCategoryDropDown) {
	                String text = option.getText().trim();
	               
	                if (!text.isEmpty()) {
	                    originalList.add(text);
	                }
	            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Product Category Dropdown options are alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Product Category Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}
		
		
	    // Items inside the *open* dropdown menu for Product Category
	    private static final By openDropdownLabels =
	            By.xpath("//select[@id='ProductModel']/following::div[contains(@class,'btn-group')][1]//button//span//label");

	    /** Returns a de-duplicated, trimmed list of all visible Product Category options in Part Master */
	    public List<String> getProductCategoryOptionsFromOpenDropdown() {
	        LoggerUtil.info("Opening Product Category dropdown in Part Master...");
	        clickOnElement(clickOnProductCategoryDrop);

	        waitForVisibility(openDropdownLabels, 10);

	        List<WebElement> listItems = driver.findElements(openDropdownLabels);
	        LinkedHashSet<String> options = new LinkedHashSet<>();
	        for (WebElement el : listItems) {
	            String text = el.getText().trim();
	            // Filter out helper items like "Select all"
	            if (!text.isEmpty() && !"Select all".equalsIgnoreCase(text)) {
	                options.add(text);
	            }
	        }
	        List<String> result = new ArrayList<>(options);
	        LoggerUtil.info("Part Master Product Category options fetched: " + result);
	        return result;
	    }
		
		public static final By clickOnProductModelNameNoDrop = By.xpath("//select[@id='SubProductModel']/following-sibling::div/button[@class='multiselect dropdown-toggle custom-select text-center']");
		public static final By listOnProductModelNameNoDrop = By.xpath("//select[@id='SubProductModel']/option");

		public void ProductModelNameNoDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(clickOnProductModelNameNoDrop);
			try {
				LoggerUtil.info("clicked on Product Model Name & No Dropdown");		
				LoggerUtil.pass("clicked on Product Model Name & No Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Product Model Name & No Dropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsProductModelNameNoDropDown = driver.findElements(listOnProductModelNameNoDrop);
			Thread.sleep(2000);
           
	            List<String> originalList = new ArrayList<>();
	            for (WebElement option : OptionsProductModelNameNoDropDown) {
	                String text = option.getText().trim();
	               
	                if (!text.isEmpty()) {
	                    originalList.add(text);
	                }
	            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Product Model Name No Dropdown options are alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Product Model Name No Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}
		
		public static final By clickOnSpecialProductCategoryDrop = By.xpath("//select[@id='SpecialProductCategory']/following-sibling::div/button[@class='multiselect dropdown-toggle custom-select text-center']");
		public static final By listOnSpecialProductCategoryDrop = By.xpath("//select[@id='SpecialProductCategory']/option");

		public void specialProductCategoryDropdownOptionsShouldBeAlphabeticallyOrdered() throws InterruptedException {
			
			clickOnElement(clickOnSpecialProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on Special Product Category Dropdown");		
				LoggerUtil.pass("clicked on Special Product Category Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Special Product Category Dropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsSpecialProductCategoryDropDown = driver.findElements(listOnSpecialProductCategoryDrop);
			Thread.sleep(2000);
           
	            List<String> originalList = new ArrayList<>();
	            for (WebElement option : OptionsSpecialProductCategoryDropDown) {
	                String text = option.getText().trim();
	               
	                if (!text.isEmpty()) {
	                    originalList.add(text);
	                }
	            }

            List<String> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

            if (originalList.equals(sortedList)) {
                System.out.println("Dropdown options are alphabetically ordered.");
                LoggerUtil.info("Special Product Category Dropdown options are alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);		
    			LoggerUtil.pass("Dropdown options are alphabetically ordered.");
            } else {
                System.out.println("Dropdown options are NOT alphabetically ordered.");
                System.out.println("Original: " + originalList);
                System.out.println("Sorted: " + sortedList);
				LoggerUtil.error("Special Product Category Dropdown options are NOT alphabetically ordered."+ " Original: " + originalList+" Sorted: "+ sortedList);	

            }
           
		}
		public static final By enterdOnPartUOM =By.xpath("//input[@class='select2-search__field']");
		
		public void partUOMDropdownOptionsSearchFunctionality(String searchTerm,String value) throws InterruptedException {
			
			clickOnElement(selectOnPartUOM);
			try {
				LoggerUtil.info("clicked on Part UOM");		
				LoggerUtil.pass("clicked on Part UOM");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Part UOM");		
				}
			   clearAndEnterText(waitForExpectedElement(enterdOnPartUOM), searchTerm);
			try {
				LoggerUtil.info(searchTerm+ "searchTerm on Part UOM");		
				LoggerUtil.pass(searchTerm+ "searchTerm on Part UOM");		
				}catch(Exception e) {
					LoggerUtil.error(searchTerm+ "NOT searchTerm on Part UOM");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsPartUom = driver.findElements(ListOfPartUom);
			Thread.sleep(2000);
			selectBootStrapDropDown(OptionsPartUom, value);
		}
		
		/////////////////////dfhefjkjk//////////////////////////////
		
		
		public void CheckthedefaultvalueinPartUOM() throws InterruptedException {

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement weObjPartUOM = wait.until(ExpectedConditions.elementToBeClickable(selectOnPartUOM));
			    weObjPartUOM.click();
			    WebElement selectedOption = driver.findElement(By.xpath("//span[@id='select2-PartUOM-container']"));
			    String defaultValue = selectedOption.getText();
			    Assert.assertEquals(defaultValue, "Nos.");
			    LoggerUtil.info("Expected value 'Nos.' And Actual Valu is "+defaultValue);	
			}
		
		DashboardPage dashboard;
		UnitMasterPage unitMasterPage;
		public void verifyNewlyaddedUOMshouldappearinPartUOMdropdown(String UnitName,String UnitSymbol) {
		 
			    dashboard= new DashboardPage();
			    dashboard.clickOnUnitMaster();
			    unitMasterPage =new UnitMasterPage();
			    unitMasterPage.enterdOnUnitNameTxtAndUnitSymbolTxt(UnitName,UnitSymbol);
			    unitMasterPage.clickedOnSaveBT();
			    dashboard.clickOnPartMaster();
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement partUOMDropdown = wait.until(ExpectedConditions.elementToBeClickable(selectOnPartUOM));
			    partUOMDropdown.click();
			    List<WebElement> options = driver.findElements(ListOfPartUom); 
			    String expectedUOM = UnitSymbol; 

			    boolean uomFound = false;
			    for (WebElement option : options) {
			        if (option.getText().equals(expectedUOM)) {
			            uomFound = true;
			            break;
			        }
						

			    }

			    Assert.assertTrue(uomFound, "The newly added UOM should be present in the Part UOM dropdown.");
			    LoggerUtil.info(expectedUOM+ "The newly added UOM should be present in the Part UOM dropdown.");	

			}
		
		public void verifySupplierPresentInDropdown(String supplierCode, String supplierNode, String supplierLocation) {
		    clickOnElement(clickOnSupplierDrop);
		    try {
		        LoggerUtil.info("Clicked on Supplier Dropdown");
		        LoggerUtil.pass("Clicked on Supplier Dropdown");
		    } catch (Exception e) {
		        LoggerUtil.error("NOT clicked on Supplier Dropdown");
		    }

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    List<WebElement> optionsSupplierNameDropDown = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOnSupplierDrop));

		    String expectedSupplier = supplierNode + "-" + supplierCode; // Include location if needed

		    boolean supplierFound = false;
		    for (WebElement option : optionsSupplierNameDropDown) {
		        if (option.getText().trim().equalsIgnoreCase(expectedSupplier)) {
		            supplierFound = true;
		            break;
		        }
		    }

		    Assert.assertTrue(supplierFound, "The newly added Supplier should be present in the Supplier dropdown.");
		    LoggerUtil.pass(expectedSupplier + " - The newly added Supplier is present in the Supplier dropdown.");
		}

		public void verifySupplierDropdownConcatenation(String expectedName, String expectedCode) {
		    clickOnElement(clickOnSupplierDrop);
		    LoggerUtil.info("Clicked on Supplier Dropdown");

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    List<WebElement> supplierOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOnSupplierDrop));

		    boolean matchFound = false;
		    String expectedConcatenation = expectedName + "-" + expectedCode;

		    for (WebElement option : supplierOptions) {
		    	if (option.getText().trim().equalsIgnoreCase(expectedConcatenation)) {
		    		matchFound = true;
		    		break;
		    	}
		        String actualText = option.getText().trim();

		        if (actualText.equals(expectedConcatenation)) {
		            // Check concatenation format
		            if (actualText.contains("-")) {
		                String[] parts = actualText.split("-", 2); // Split into [name, code]
		                String actualName = parts[0].trim();
		                String actualCode = parts[1].trim();

		                Assert.assertEquals(actualName, expectedName, "Supplier name mismatch");
		                Assert.assertEquals(actualCode, expectedCode, "Supplier code mismatch");

		                LoggerUtil.pass("Dropdown option correctly formatted: " + actualText);
		                matchFound = true;
		                break;
		            } else {
		                LoggerUtil.error("Dropdown option does not contain expected '-' separator: " + actualText);
		            }
		        }
		    }

		    Assert.assertTrue(matchFound, "Expected supplier not found in dropdown: " + expectedConcatenation);
		}

		public static final By btnAddSupplier =By.xpath("//a[@id='addNewSupplier']");
		public void openAddSupplierPopup() {
		    clickOnElement(btnAddSupplier);
		    LoggerUtil.info("Clicked '+Supplier' to open add-supplier popup.");
		}
		public static final By txtSupplierCode =By.xpath("(//input[@id='SupplierCode'])[1]");
		public static final By txtSupplierName =By.xpath("(//input[@id='SupplierName'])[1]");
		public static final By txtSupplierLocation =By.xpath("(//input[@name='SupplierLocation'])[1]");
		public static final By businessDomainDDBtn =By.xpath("//select[@id='supBusinessDomain']/following-sibling::div/button");
		public static final By businessDomainSearch =By.xpath("(//label[normalize-space(text())='Business Domain']/following::input)[1]");
		public static final By businessDomainSegmentsDDBtn =By.xpath("//select[@id='supBusinessSegments']/following-sibling::div/button");
		public static final By businessDomainSegmentsSearch =By.xpath("(//label[contains(.,'Business Segments*')]/following::input)[1]");
		public static final By supplierSavepartmastBtn =By.xpath("//button[@id='supplierSavepartmast']");
		public static final By listOfBesinessDomainCheckBOX =By.xpath("//select[@id='supBusinessDomain']/following-sibling::div[contains(@class,'btn-group')]//button");
		public static final By listOfBesinessSegmentsCheckBOX =By.xpath("//select[@id='supBusinessSegments']/following-sibling::div[contains(@class,'btn-group')]//button");

		public void fillAndSaveSupplierFromPartMaster(String name, String code,String location) {
			clearAndEnterText(waitForExpectedElement(txtSupplierCode), code);
			clearAndEnterText(waitForExpectedElement(txtSupplierName), name);
			clearAndEnterText(waitForExpectedElement(txtSupplierLocation), location);
			clickOnElement(businessDomainDDBtn);
			clearAndEnterText(waitForExpectedElement(businessDomainSearch), "Ai");
			List<WebElement> weObj=driver.findElements(listOfBesinessDomainCheckBOX);
			selectBootstrapDropdownValue(weObj, "Ai");
			clickOnElement(businessDomainSegmentsDDBtn);
			clearAndEnterText(waitForExpectedElement(businessDomainSegmentsSearch), "Barry");
			List<WebElement> weObjSegments=driver.findElements(listOfBesinessSegmentsCheckBOX);
			selectBootstrapDropdownValue(weObjSegments, "Barry");
			clickOnElement(supplierSavepartmastBtn);
		}
		
		CustomerMasterPage CustomerMasterPage;
		public void verifyNewlyaddedcustomerappearscorrectlyindropdown(String CustomerCode,String CustomerName,String CustomerLocation) {
			 
		    dashboard= new DashboardPage();
		    dashboard.clickOnCustomerMasterData();
		    CustomerMasterPage =new CustomerMasterPage();
		    CustomerMasterPage.VerifyCheckSavePrompt(CustomerCode, CustomerLocation, CustomerName);
		    dashboard.clickOnPartMaster();
		    clickOnElement(clickoncustomerdrop);
		    List<WebElement> options = driver.findElements(customerotions); 
		    String expectedCustomer = CustomerName+"-"+CustomerLocation+"-"+CustomerCode; 

		    boolean CustomerFounf = false;
		    for (WebElement option : options) {
		        if (option.getText().equals(expectedCustomer)) {
		        	CustomerFounf = true;
		            break;
		        }
		    }

		    Assert.assertTrue(CustomerFounf, "The newly added Customer should be present in the Customer dropdown.");
		    LoggerUtil.info(expectedCustomer+ "The newly added Customer should be present in the Customer dropdown.");	

		}
		public static final By clickOnCreateNewCustomerPlusButtonSaveBT=By.xpath("(//button[@id='customerSave']//i)[1]");
		public static final By customercode = By.xpath("//input[@id='CustomerCode']");
		public static final By customername = By.xpath("//input[@id='CustomerName']");
		public static final By customerlocation = By.xpath("//input[@id='CustomerLocation']");
		public void VerifyCustomerMasterPlusButtonCreateNewCustomerPage(String cucode, String clocation, String cname) {
	        // Enter values in fields
	        clearAndEnterText(waitForExpectedElement(customercode), cucode);
	        clearAndEnterText(waitForExpectedElement(customerlocation), clocation);
	        clearAndEnterText(waitForExpectedElement(customername), cname);

	        // Click save
	        clickOnElement(clickOnCreateNewCustomerPlusButtonSaveBT);

	        // Wait for toast presence in DOM (whether visible or not)
	       

	    }
	    
		
		
		public void addedNewCustomer(String cucode, String clocation, String cname) {
	    	VerifyCustomerMasterPlusButtonCreateNewCustomerPage(cucode, clocation, cname);
	    }
		public void VerifycustomerdropdownCustomerNameCodeLocationconcatenatedcorrectly(String CustomerCode,String CustomerName,String CustomerLocation){
 
		    dashboard= new DashboardPage();
		    dashboard.clickOnCustomerMasterData();
		    CustomerMasterPage =new CustomerMasterPage();
		    CustomerMasterPage.VerifyCheckSavePrompt(CustomerCode, CustomerLocation, CustomerName);
		    dashboard.clickOnPartMaster();
		    clickOnElement(clickoncustomerdrop);
		    List<WebElement> options = driver.findElements(customerotions); 
		   // String expectedCustomer = CustomerName+"-"+CustomerLocation+"-"+CustomerCode; 
		    String expectedCustomer = CustomerName+"-"+CustomerCode+"-"+CustomerLocation; 

		    try {

		        List<String> actualDropdownValues = new ArrayList<>();
		        for (WebElement element : options) {
		            String val = element.getText().trim();
		            LoggerUtil.info("Dropdown value found: " + val);
		            actualDropdownValues.add(val);
		        }

		        List<String> expectedDropdownValues = Arrays.asList(
		        		expectedCustomer   
		        );

		        for (String expected : expectedDropdownValues) {
		            if (actualDropdownValues.contains(expected)) {
		                LoggerUtil.pass("✅ Match found for: " + expected);
		            } else {
		                LoggerUtil.error("❌ Mismatch or missing: " + expected);
		            }
		        }
		    } catch (Exception e) {
		        LoggerUtil.error("Error during customer dropdown validation: " + e.getMessage());
		    }
		
		}
		
		public static final By enterdOnCompanyName =By.xpath("//div[contains(@class,'multiselect-container') and contains(@class,'dropdown-menu') and contains(@class,'show')]//input[@type='search' and contains(@class,'multiselect-search') and @placeholder='Search']");
		
		public void companyNameDropdownSearchFunctionality(String searchTerm,String value) throws InterruptedException {
			
			clickOnElement(clickOnCompanyDropdown);
			try {
				LoggerUtil.info("clicked on Company Name Dropdown");		
				LoggerUtil.pass("clicked on Company Name Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Company Name Dropdown");		
				}
			   clearAndEnterText(waitForExpectedElement(enterdOnCompanyName), searchTerm);
			try {
				LoggerUtil.info(searchTerm+ "searchTerm on Company Name");		
				LoggerUtil.pass(searchTerm+ "searchTerm on Company Name");		
				}catch(Exception e) {
					LoggerUtil.error(searchTerm+ "NOT searchTerm on Company Name");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsCustomerName = driver.findElements(ListOfCheckBoxCompanyText);
			Thread.sleep(2000);
			selectBootStrapDropDown(OptionsCustomerName, value);
		}
		
		public void Selectmultiplecompaniesfromdropdown() {
		   
		    clickOnElement(clickOnCompanyDropdown);
		    List<WebElement> OptionsCustomerName = driver.findElements(ListOfCheckBoxCompanyText);
		    int limit = Math.min(2, OptionsCustomerName.size());  
		    for (int i = 0; i < limit; i++) {
		        WebElement we = OptionsCustomerName.get(i);
		        we.click();  
		    }
		    LoggerUtil.info("Dropdown allows multiple selections and displays them properly.");
		}

		
		public static final By searchOnCustomerTxt =By.xpath("//div[@class='multiselect-container dropdown-menu show']/div/input");
		public static final By customerotions1 =By.xpath("//select[@id='CustomerSelection']/option");

		public void customerDropdownSearchFunctionality(String searchTerm,String value) throws InterruptedException {
			
			clickOnElement(clickoncustomerdrop);
			List<WebElement> OptionsCustomerName = driver.findElements(customerotions1);
			
			System.out.println(OptionsCustomerName);
			
			Thread.sleep(3000);
			try {
				LoggerUtil.info("clicked on Customer Dropdown");		
				LoggerUtil.pass("clicked on Customer Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Customer Dropdown");		
				}
			Thread.sleep(5000);
			   clearAndEnterText(waitForExpectedElement(searchOnCustomerTxt), searchTerm);
			try {
				LoggerUtil.info(searchTerm+ " searchTerm on Customer");		
				LoggerUtil.pass(searchTerm+ " searchTerm on Customer");		
				}catch(Exception e) {
					LoggerUtil.error(searchTerm+ " NOT searchTerm on Customer");		
				}
			Thread.sleep(5000);
			
			selectBootStrapDropDownAdvanced(OptionsCustomerName, value);
		}
		
		public static final By searchOnSupplierTxt =By.xpath("//div [@class='multiselect-container dropdown-menu show'][1]/div/input");
		public static final By checkboxsupplier = By.xpath("//*[@id='SupplierSelection']/following-sibling::div/div/button/span/input");
	
		public static final By selectsupplier = By.xpath("//*[@id='SupplierSelection']/following-sibling::div/div/button/span/label");
		public void supplierDropdownSearhFunctionality(String searchTerm,String value) throws InterruptedException {
			
		    
			clickOnElement(clickOnSupplierDrop);
			List<WebElement> OptionsSupplierName = driver.findElements(selectsupplier);
			Thread.sleep(1000);
			List<WebElement> optchecksupp = driver.findElements(checkboxsupplier);
			try {
				LoggerUtil.info("clicked on supplier Dropdown");		
				LoggerUtil.pass("clicked on supplier Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on supplier Dropdown");		
				}
			Thread.sleep(3000);
		    clearAndEnterText(waitForExpectedElement(searchOnSupplierTxt), searchTerm);
			        Thread.sleep(2000);
			   try {
				LoggerUtil.info(searchTerm+ " searchTerm on supplier");		
				LoggerUtil.pass(searchTerm+ " searchTerm on supplier");		
				}catch(Exception e) {
					LoggerUtil.error(searchTerm+ " NOT searchTerm on supplier");		
				}
			Thread.sleep(4000);		
			selectBootStrapDropDown(OptionsSupplierName,value);
		
		}
		public static final By searchProduct =By.xpath("//div[@class='multiselect-container dropdown-menu show']/div[1]/input");
		public void productCategoryDropdownSearhFunctionality(String searchTerm,String value) throws InterruptedException {
			
		    
			clickOnElement(clickOnProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on Product Category Dropdown");		
				LoggerUtil.pass("clicked on Product CategoryDropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Product CategoryDropdown");		
				}
			Thread.sleep(3000);
		//	List<WebElement> OptionsProductCategoryDropDown = driver.findElements(listOnProductCategoryDrop);
			Thread.sleep(2000);
		    clearAndEnterText(waitForExpectedElement(searchProduct), searchTerm);
			        Thread.sleep(2000);
			        try {
						LoggerUtil.info(searchTerm+ " searchTerm on supplier");		
						LoggerUtil.pass(searchTerm+ " searchTerm on supplier");		
						}catch(Exception e) {
							LoggerUtil.error(searchTerm+ " NOT searchTerm on supplier");		
						}
				}
		
		public static final By searchSpecielProduct =By.xpath("//select[contains(@id, 'SpecialProductCategory')]/following-sibling::div//input[@class='multiselect-search form-control']");
		public void specielProductCategoryDropdownSearhFunctionality(String searchTerm,String value) throws InterruptedException {
			
		    
			clickOnElement(clickOnSpecialProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on Speciel Product Category Dropdown");		
				LoggerUtil.pass("clicked on Speciel Product CategoryDropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Speciel Product Category Dropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsSpecielProductCategoryDropDown = driver.findElements(listOnSpecialProductCategoryDrop);
			Thread.sleep(2000);
		    clearAndEnterText(waitForExpectedElement(searchSpecielProduct), searchTerm);
			        Thread.sleep(2000);
			        try {
						LoggerUtil.info(searchTerm+ " searchTerm on supplier");		
						LoggerUtil.pass(searchTerm+ " searchTerm on supplier");		
						}catch(Exception e) {
							LoggerUtil.error(searchTerm+ " NOT searchTerm on supplier");		
						}
			        Thread.sleep(4000);		
					selectBootStrapDropDown(OptionsSpecielProductCategoryDropDown,value);
				}
		
		public void companyNameDropdownVerifyMultipleDropdownSelectionTest(String oprion1,String option2) throws InterruptedException {
		    clickOnElement(clickOnCompanyDropdown);
		    try {
		        LoggerUtil.info("clicked on Company Name Dropdown");		
		        LoggerUtil.pass("clicked on Company Name Dropdown");		
		    } catch(Exception e) {
		        LoggerUtil.error("NOT clicked on Company Name Dropdown");		
		    }
		    Thread.sleep(3000);
		    List<WebElement> OptionsCompanyNameDropDown = driver.findElements(ListOfCheckBoxCompanyText);
		    Thread.sleep(2000);
		    for (WebElement option : OptionsCompanyNameDropDown) {
		        String text = option.getText().trim();
		        if (text.equals(oprion1) || text.equals(option2)) {
		            if (!option.isSelected()) {
		                option.click();
				        LoggerUtil.info("PASS: Multiple selections verified. Selected: " + text);

		            }else {
				        LoggerUtil.error("FAIL: Multiple selections not as expected. Selected: " + option + ", Expected: " + text);
				       
				    }

		        }
		        
		    }
		}
		
	public CompanyControlMasterPage CompanyControlMasterPage;
	public UsersControlMasterPage UsersControlMasterPage;
	public void verifyCompanynamecodeandlocationconcatenatedcorrectly() throws InterruptedException {
		
		dashboard= new DashboardPage();
	    dashboard.clickOnControlMaster();
	    dashboard.clickOnCompanyControlMaster();
	    CompanyControlMasterPage= new CompanyControlMasterPage();
	    CompanyControlMasterPage.selectOnCompanyDD("java");
	    CompanyControlMasterPage.enterOnCustomerCodeTxt("032166768548327328");
	    CompanyControlMasterPage.enterOnCustomerNameTxt("TATA-MOTERS");
	  
	    CompanyControlMasterPage.enterOnLocationTxt("Mohali");
	    CompanyControlMasterPage.clickOnSaveBT();
	    Thread.sleep(8000);
	    dashboard.clickOnCompanyControlMaster();
	    Thread.sleep(2000);
	    
	    dashboard.clickOnUserMasterBT();
	    UsersControlMasterPage= new UsersControlMasterPage();
	    UsersControlMasterPage.clickOnUserAuthorizationBT();
	    UsersControlMasterPage.clickOnUserAuthorizationEditBT();
	    UsersControlMasterPage.selectOnCompanySelectionDD();
	    Thread.sleep(2000);
	    UsersControlMasterPage.clickOnUpdateBtn();
	    dashboard.selectMenuFormDashBoard("Master Data");
		Thread.sleep(3000);
		dashboard.clickOnPartMaster();
		Thread.sleep(1000);
		
		    try {
		        clickOnElement(clickOnCompanyDropdown);
		        LoggerUtil.info("Clicked on Company Name Dropdown");
		        Thread.sleep(3000);

		        List<WebElement> optionsCompany = driver.findElements(ListOfCheckBoxCompanyText);
		        List<String> actualDropdownValues = new ArrayList<>();
		        for (WebElement element : optionsCompany) {
		            String val = element.getText().trim();
		            LoggerUtil.info("Dropdown value found: " + val);
		            actualDropdownValues.add(val);
		        }

		        // Assuming you know expected values
		        List<String> expectedDropdownValues = Arrays.asList(
		            
		            "TATA Motors-Ahmedabad-CMP123"
		           
		        );

		        for (String expected : expectedDropdownValues) {
		            if (actualDropdownValues.contains(expected)) {
		                LoggerUtil.pass("✅ Match found for: " + expected);
		            } else {
		                LoggerUtil.error("❌ Mismatch or missing: " + expected);
		            }
		        }
		    } catch (Exception e) {
		        LoggerUtil.error("Error during company dropdown validation: " + e.getMessage());
		    }
		}

		
		public void customerDropdownVerifyMultipleDropdownSelectionTest(String option1, String option2) throws InterruptedException {
		    clickOnElement(clickoncustomerdrop);
		    try {
		        LoggerUtil.info("clicked on Customer Dropdown");        
		        LoggerUtil.pass("clicked on Customer Dropdown");        
		    } catch(Exception e) {
		        LoggerUtil.error("NOT clicked on Customer Dropdown");        
		    }
		    Thread.sleep(3000);
		    List<WebElement> OptionsCustomerDropDown = driver.findElements(By.cssSelector("button.multiselect-option.dropdown-item"));
		    Thread.sleep(2000);
		    for (WebElement optionButton : OptionsCustomerDropDown) {
		        WebElement label = optionButton.findElement(By.cssSelector("label.form-check-label"));
		        String text = label.getText().trim();

		        if (text.equals(option1) || text.equals(option2)) {
		            WebElement checkbox = optionButton.findElement(By.cssSelector("input[type='checkbox']"));
		            if (!checkbox.isSelected()) {
		                label.click(); 
		                LoggerUtil.info("Selected: " + text);
		            }
		        }
		    }
		    List<String> selectedList = new ArrayList<>();
		    for (WebElement optionButton : OptionsCustomerDropDown) {
		        WebElement label = optionButton.findElement(By.cssSelector("label.form-check-label"));
		        WebElement checkbox = optionButton.findElement(By.cssSelector("input[type='checkbox']"));
		        if (checkbox.isSelected()) {
		            String text = label.getText().trim();
		            if (!text.isEmpty()) {
		                selectedList.add(text);
		            }
		        }
		    }
		    List<String> expectedSelected = Arrays.asList(option1, option2);
		    if (selectedList.containsAll(expectedSelected) && selectedList.size() == expectedSelected.size()) {
		        LoggerUtil.info("PASS: Multiple selections verified. Selected: " + selectedList);
		    } else {
		        LoggerUtil.error("FAIL: Multiple selections not as expected. Selected: " + selectedList + ", Expected: " + expectedSelected);
		    }
		}
		public void verifySavePartwithSpecialCharactersandNumbers(String partNumber,String partDescription) throws InterruptedException {
			clearAndEnterText(waitForExpectedElement(enterOnPartNumber), partNumber);
			try {
				LoggerUtil.info("PartNumber :-"+partNumber+ ":- is filled sucesfully");		
				LoggerUtil.pass("PartNumber :-"+partNumber+ ":- is filled sucesfully");
				}catch(Exception e) {
					LoggerUtil.error("PartNumber :-"+partNumber+ ":- is not filled sucesfully");
				}
			clearAndEnterText(waitForExpectedElement(enterOnPartDescription), partDescription);
			try {
				LoggerUtil.info("PartDescription :-"+partDescription+ ":- is filled sucesfully");		
				LoggerUtil.pass("PartDescription :-"+partDescription+ ":- is filled sucesfully");
				}catch(Exception e) {
					LoggerUtil.error("PartDescription :-"+partDescription+ ":- is not filled sucesfully");
				}
			clickOnElement(selectOnPartUOM);
			try {
				LoggerUtil.info("clicked on Part UOM");		
				LoggerUtil.pass("clicked on Part UOM");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Part UOM");		
				}
			clearAndEnterText(waitForExpectedElement(enterdOnPartUOM), "Rs.");
			clickOnElement(enterdOnPartUOM);
			Thread.sleep(3000);
			List<WebElement> OptionsPartUom = driver.findElements(ListOfPartUom);
			Thread.sleep(2000);
			selectBootStrapDropDown(OptionsPartUom, "Rs.");
			clickOnElement(clickOnCompanyDropdown);
			try {
				LoggerUtil.info("clicked on Company Name Dropdown");		
				LoggerUtil.pass("clicked on Company Name Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Company Name Dropdown");		
				}
			Thread.sleep(3000);
			clearAndEnterText(waitForExpectedElement(enterdOnCompanyName), "Costmaster-Mohali-007");
			clickOnElement(enterdOnCompanyName);
			Thread.sleep(3000);
			List<WebElement> OptionsPartUom1 = driver.findElements(ListOfCheckBoxCompanyText);
			Thread.sleep(2000);
			selectBootStrapDropDown(OptionsPartUom1, "Costmaster-Mohali-007");
			
			clickOnElement(clickoncustomerdrop);
			try {
				LoggerUtil.info("clicked on Customer Dropdown");		
				LoggerUtil.pass("clicked on Customer Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Customer Dropdown");		
				}
			Thread.sleep(5000);
			   clearAndEnterText(waitForExpectedElement(searchOnCustomerTxt), "CN-Dec.-testing-006-CL-Dec. testing-17122024-006");
			   clickOnElement(searchOnCustomerTxt);
			   Thread.sleep(3000);
			List<WebElement> OptionsCustomerName = driver.findElements(customerotions1);
			Thread.sleep(2000);
			selectBootStrapDropDown(OptionsCustomerName, "CN-Dec.-testing-006-CL-Dec. testing-17122024-006");
			clickOnElement(clickOnSupplierDrop);
			List<WebElement> OptionsSupplierName = driver.findElements(selectsupplier);
			Thread.sleep(1000);
			List<WebElement> optchecksupp = driver.findElements(checkboxsupplier);
			try {
				LoggerUtil.info("clicked on supplier Dropdown");		
				LoggerUtil.pass("clicked on supplier Dropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on supplier Dropdown");		
				}
			Thread.sleep(3000);
		    clearAndEnterText(waitForExpectedElement(searchOnSupplierTxt), " Testing1-007");
			        Thread.sleep(2000);
			   try {
				LoggerUtil.info(" Testing1-007"+ " searchTerm on supplier");		
				LoggerUtil.pass(" Testing1-007"+ " searchTerm on supplier");		
				}catch(Exception e) {
					LoggerUtil.error(" Testing1-007"+ " NOT searchTerm on supplier");		
				}
			Thread.sleep(4000);		
			selectBootStrapDropDown(OptionsSupplierName," Testing1-007");
			clickOnElement(clickOnProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on Product Category Dropdown");		
				LoggerUtil.pass("clicked on Product CategoryDropdown");		
				}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Product CategoryDropdown");		
				}
			Thread.sleep(3000);
			List<WebElement> OptionsProductCategoryDropDown = driver.findElements(listOnProductCategoryDrop);
			Thread.sleep(2000);
		    clearAndEnterText(waitForExpectedElement(searchProduct), "17012024");
			        Thread.sleep(2000);
			        try {
						LoggerUtil.info("17012024"+ " searchTerm on supplier");		
						LoggerUtil.pass("17012024"+ " searchTerm on supplier");		
						}catch(Exception e) {
							LoggerUtil.error("17012024"+ " NOT searchTerm on supplier");		
						}
			        Thread.sleep(4000);		
					selectBootStrapDropDown(OptionsProductCategoryDropDown," Testing1-007");
					clickOnElement(clickOnSpecialProductCategoryDrop);
					try {
						LoggerUtil.info("clicked on Special Product Category Dropdown");		
						LoggerUtil.pass("clicked on Special Product Category Dropdown");		
						}catch(Exception e) {
							LoggerUtil.error("NOT clicked on Special Product Category Dropdown");		
						}
					Thread.sleep(3000);
					List<WebElement> OptionsSpecialProductCategoryDropDown = driver.findElements(listOnSpecialProductCategoryDrop);
					Thread.sleep(2000);
					clearAndEnterText(waitForExpectedElement(searchSpecielProduct), "12345");
			        Thread.sleep(2000);
			        try {
						LoggerUtil.info("12345"+ " searchTerm on supplier");		
						LoggerUtil.pass("12345"+ " searchTerm on supplier");		
						}catch(Exception e) {
							LoggerUtil.error("12345"+ " NOT searchTerm on supplier");		
						}
			        Thread.sleep(4000);		
					selectBootStrapDropDown(OptionsSpecialProductCategoryDropDown,"12345");
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		public void enterdOnPartNumberData(String partTxt) {
			sendKeysToTextBox(enterOnPartNumber, partTxt);
			try {
				LoggerUtil.info("PartNumber :-"+partTxt+ ":- is filled sucesfully");		
				}catch(Exception e) {
					LoggerUtil.error("PartNumber :-"+partTxt+ ":- is not filled sucesfully");
				}
		}
		
		public void enterdOnPartDescription(String partDescription) {
			sendKeysToTextBox(enterOnPartDescription, partDescription);
			try {
				LoggerUtil.info("PartDescription :-"+partDescription+ ":- is filled sucesfully");		
				}catch(Exception e) {
					LoggerUtil.error("PartDescription :-"+partDescription+ ":- is not filled sucesfully");
				}
		}
		
		public void enterdOnCustomerPartNo(String CustomerPartNo) {
			sendKeysToTextBox(enterOnCustomerPartNumber, CustomerPartNo);
			try {
				LoggerUtil.info("CustomerPartNo :-"+CustomerPartNo+ ":- is filled sucesfully");		
				}catch(Exception e) {
					LoggerUtil.error("CustomerPartNo :-"+CustomerPartNo+ ":- is not filled sucesfully");
				}
		}
		
		public void enterdOnHSNCode(String HSNCode) {
			sendKeysToTextBox(enterOnHSNCode, HSNCode);
			try {
				LoggerUtil.info("HSNCode :-"+HSNCode+ ":- is filled sucesfully");		
				}catch(Exception e) {
					LoggerUtil.error("HSNCode :-"+HSNCode+ ":- is not filled sucesfully");
				}
		}
		
		public void selectOnpartUOMDropdownOptions(String selectOnpartUOMDropdownValue){
			
			clickOnElement1(selectOnPartUOM);
			try {
				LoggerUtil.info("clicked on Part UOM");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Part UOM");		
				}
			
			List<WebElement> OptionsPartUom1 = driver.findElements(ListOfPartUom);
			
			selectBootStrapDropDown(OptionsPartUom1, selectOnpartUOMDropdownValue);
			try {
				LoggerUtil.info("Select on "+selectOnpartUOMDropdownValue+" dropdwon");				
				}catch(Exception e) {
					LoggerUtil.error("Not Select on "+selectOnpartUOMDropdownValue+" dropdwon");		
				}
		}
		public static final By clickOnCompanyCeckBox =By.xpath("//input[contains(@value,'5117')]");
		public void selectOnCompanyNameDropdownOptions(String selectOnCompanyNameDropdownOptions){
			
			clickOnElement1(clickOnCompanyDropdown);
			try {
				LoggerUtil.info("clicked on Company Name");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Company Name");		
				}
			
			clickOnElement1(clickOnCompanyCeckBox);
			try {
				LoggerUtil.info("clicked on Company Name");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Company Name");		
				}
			
//			List<WebElement> CompanyNameDropdownOptions = driver.findElements(ListOfCheckBoxCompanyDropDown);
//			
//			selectBootStrapDropDown(CompanyNameDropdownOptions, selectOnCompanyNameDropdownOptions);
//			try {
//				LoggerUtil.info("Select on "+selectOnCompanyNameDropdownOptions+" dropdwon");				
//				}catch(Exception e) {
//					LoggerUtil.error("Not Select on "+selectOnCompanyNameDropdownOptions+" dropdwon");		
//				}
		}
		public static final By selectOnCustomerCeckBox =By.xpath("//input[contains(@value,'5841')]");
		public void selectOnCustomerDropdownOptions(String selectOnCustomerDropdownOptions){
			
			clickOnElement1(clickoncustomerdrop);
			try {
				LoggerUtil.info("clicked on Customer");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Customer");		
				}
			
			clickOnElement1(selectOnCustomerCeckBox);
			try {
				LoggerUtil.info("clicked on Customer");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Customer");		
				}
			
			
//			List<WebElement> OptionsCustomerDropDown = driver.findElements(By.cssSelector("button.multiselect-option.dropdown-item"));
//			
//			selectBootStrapDropDown(OptionsCustomerDropDown, selectOnCustomerDropdownOptions);
//			try {
//				LoggerUtil.info("Select on "+selectOnCustomerDropdownOptions+" dropdwon");				
//				}catch(Exception e) {
//					LoggerUtil.error("Not Select on "+selectOnCustomerDropdownOptions+" dropdwon");		
//				}
		}
		
		public void selectOnSupplierDropdownOptions(String selectOnSupplierDropdownOptions){
			
			clickOnElement1(clickOnSupplierDrop);
			try {
				LoggerUtil.info("clicked on Supplier Dropdown");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Supplier Dropdown");		
				}
			
			List<WebElement> OptionsSupplierName = driver.findElements(selectsupplier);			
			selectBootStrapDropDown(OptionsSupplierName, selectOnSupplierDropdownOptions);
			try {
				LoggerUtil.info("Select on "+selectOnSupplierDropdownOptions+" dropdwon");				
				}catch(Exception e) {
					LoggerUtil.error("Not Select on "+selectOnSupplierDropdownOptions+" dropdwon");		
				}
		}
		public static final By clickOnProductCeckBox =By.xpath("//input[contains(@value,'4374')]");

		public void selectOnProductCategoryDropdownOptions(String selectOnProductCategoryDropdownOptions){
			
			clickOnElement1(clickOnProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on Product Category Dropdown");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on Product Category Dropdown");		
				}
			clickOnElement1(clickOnProductCeckBox);
			try {
				LoggerUtil.info("clicked on ProductCeckBox Dropdown");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on ProductCeckBox Dropdown");		
				}
			
			
			List<WebElement> OptionsProductCategoryDropDown = driver.findElements(listOnProductCategoryDrop);	
			System.out.println(OptionsProductCategoryDropDown);
			
			selectBootstrapDropdownValue(OptionsProductCategoryDropDown, selectOnProductCategoryDropdownOptions);
			
			try {
				LoggerUtil.info("Select on "+selectOnProductCategoryDropdownOptions+" dropdwon");				
				}catch(Exception e) {
					LoggerUtil.error("Not Select on "+selectOnProductCategoryDropdownOptions+" dropdwon");		
				}
		}
		public static final By clickOnSpecielProductCeckBox =By.xpath("//input[contains(@value,'4396')]");
		public void selectOnSpecielProductCategoryDropdownOptions(String selectOnSpecielProductCategoryDropdownOptions){
			
			clickOnElement1(clickOnSpecialProductCategoryDrop);
			try {
				LoggerUtil.info("clicked on selectOnSpecielProductCategoryDropdownOptions Dropdown");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on selectOnSpecielProductCategoryDropdownOptions Dropdown");		
				}
			
			clickOnElement1(clickOnSpecielProductCeckBox);
			try {
				LoggerUtil.info("clicked on SpecielOnSpecielProductCategoryDropdownOptions Dropdown");		
						}catch(Exception e) {
					LoggerUtil.error("NOT clicked on SpecielOnSpecielProductCategoryDropdownOptions Dropdown");		
				}
			
			List<WebElement> OptionsSupplierName = driver.findElements(listOnSpecialProductCategoryDrop);			
			selectBootStrapDropDown(OptionsSupplierName, selectOnSpecielProductCategoryDropdownOptions);
			try {
				LoggerUtil.info("Select on "+selectOnSpecielProductCategoryDropdownOptions+" dropdwon");				
				}catch(Exception e) {
					LoggerUtil.error("Not Select on "+selectOnSpecielProductCategoryDropdownOptions+" dropdwon");		
				}
		}
		
		public void VerifyeachblankfieldplaceholdeDefaulttextEnterdisplayedcorrectly() {
			String actualEnterOnPartNumber = waitForExpectedElement(enterOnPartNumber).getAttribute("placeholder");
			String ExpectedEnterOnPartNumber = "Enter";				
			try {
			LoggerUtil.info("Actual Value = "+actualEnterOnPartNumber+ " || and || Expected Value = " + ExpectedEnterOnPartNumber);
		
			soft.assertEquals(actualEnterOnPartNumber, ExpectedEnterOnPartNumber,"EnterOnPartNumber:- Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnPartNumber:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnPartNumber:- PlaceHolder Value Are Mismatched");
				
			}
			String actualEnterOnPartDescription = waitForExpectedElement(enterOnPartDescription).getAttribute("placeholder");
			String ExpectedEnterOnPartDescription = "Enter";				
			try {
			LoggerUtil.info("Actual Value = "+actualEnterOnPartDescription+ " || and || Expected Value = " + ExpectedEnterOnPartDescription);
		
			soft.assertEquals(actualEnterOnPartDescription, ExpectedEnterOnPartDescription,"EnterOnPartDescription Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnPartDescription:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnPartDescription:- PlaceHolder Value Are Mismatched");
				
			}		
			String actualEnterOnCustomerPartNumber = waitForExpectedElement(enterOnCustomerPartNumber).getAttribute("placeholder");
			String ExpectdEnenterOnCustomerPartNumber = "Enter";				
			try {
			LoggerUtil.info("Actual Value = "+actualEnterOnCustomerPartNumber+ " || and || Expected Value = " + ExpectdEnenterOnCustomerPartNumber);
		
			soft.assertEquals(actualEnterOnCustomerPartNumber, ExpectdEnenterOnCustomerPartNumber,"EnterOnCustomerPartNumber Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnCustomerPartNumber:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnCustomerPartNumber:- PlaceHolder Value Are Mismatched");
				
			}
			String actualEnterOnHSNCode = waitForExpectedElement(enterOnHSNCode).getAttribute("placeholder");
			String ExpectdEnterOnHSNCode = "Enter";				
			try {
			LoggerUtil.info("Actual Value = "+actualEnterOnHSNCode+ " || and || Expected Value = " + ExpectdEnterOnHSNCode);
		
			soft.assertEquals(actualEnterOnHSNCode, ExpectdEnterOnHSNCode,"EnterOnHSNCode Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnHSNCode:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnHSNCode:- PlaceHolder Value Are Mismatched");
				
			}
			
	    }
		
		public static final By clickOnCompanyDDTxt =By.xpath("//select[@id='PlantSelection']/following-sibling::div//span[@class='multiselect-selected-text']");
		public static final By clickOnCustomerDDTxt =By.xpath("//select[@id='CustomerSelection']/following-sibling::div//span[@class='multiselect-selected-text']");
		public static final By clickOnSupplierDDTxt =By.xpath("//select[@id='SupplierSelection']/following-sibling::div//span[@class='multiselect-selected-text']");
		public static final By clickOnProductCategoryDDTxt =By.xpath("//select[@id='ProductModel']/following-sibling::div//span[@class='multiselect-selected-text']");
		public static final By clickOnProductModelBameAndNumberDDTxt =By.xpath("//select[@id='SubProductModel']/following-sibling::div//span[@class='multiselect-selected-text']");
		public static final By clickOnSpecielProductCategoryDDTxt =By.xpath("//select[@id='SubProductModel']/following-sibling::div//span[@class='multiselect-selected-text']");

		public void CheckeachdropdownsdefaultplaceholderDropdowndefaulttextisSelectorNoneSelected() {
			String ExpectdCompanyPlaceHolder = "None Selected";	
			String actualCompanyPlaceHolder =  verifyDropdownPlaceholder(clickOnCompanyDDTxt, ExpectdCompanyPlaceHolder);
			
			try {
				
			LoggerUtil.info("Actual Value = "+actualCompanyPlaceHolder+ " || and || Expected Value = " + ExpectdCompanyPlaceHolder);
		
			soft.assertEquals(actualCompanyPlaceHolder, ExpectdCompanyPlaceHolder,"EnterOnCompanyPlaceHolder Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnCompanyPlaceHolder:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnCompanyPlaceHolder:- PlaceHolder Value Are Mismatched");
				
			}
			
			String ExpectdCustomerPlaceHolder = "None Selected";
			String actualCustomerPlaceHolder =  verifyDropdownPlaceholder(clickOnCustomerDDTxt, ExpectdCompanyPlaceHolder);
			try {
			LoggerUtil.info("Actual Value = "+actualCustomerPlaceHolder+ " || and || Expected Value = " + ExpectdCustomerPlaceHolder);
		
			soft.assertEquals(actualCustomerPlaceHolder, ExpectdCustomerPlaceHolder,"EnterOnCustomerPlaceHolder Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnCustomerPlaceHolder:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnCustomerPlaceHolder:- PlaceHolder Value Are Mismatched");
				
			}
			
			String ExpectdSupplierPlaceHolder = "None Selected";
			String actualSupplierPlaceHolder =  verifyDropdownPlaceholder(clickOnSupplierDDTxt, ExpectdSupplierPlaceHolder);
			try {
			LoggerUtil.info("Actual Value = "+actualSupplierPlaceHolder+ " || and || Expected Value = " + ExpectdSupplierPlaceHolder);
		
			soft.assertEquals(actualSupplierPlaceHolder, ExpectdSupplierPlaceHolder,"EnterOnSupplierPlaceHolder Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnSupplierPlaceHolder:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnSupplierPlaceHolder:- PlaceHolder Value Are Mismatched");
				
			}
			String ExpectdProductCategoryPlaceHolder = "None Selected";	
			String actualProductCategoryPlaceHolder =  verifyDropdownPlaceholder(clickOnProductCategoryDDTxt, ExpectdProductCategoryPlaceHolder);
						
			try {
			LoggerUtil.info("Actual Value = "+actualProductCategoryPlaceHolder+ " || and || Expected Value = " + ExpectdProductCategoryPlaceHolder);
		
			soft.assertEquals(actualProductCategoryPlaceHolder, ExpectdProductCategoryPlaceHolder,"EnterOnProductCategoryPlaceHolder Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnProductCategoryPlaceHolder:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnProductCategoryPlaceHolder:- PlaceHolder Value Are Mismatched");
				
			}
			String ExpectdProductModelNameNoPlaceHolder = "None Selected";
			String actualProductModelNameAndNumberPlaceHolder =  verifyDropdownPlaceholder(clickOnProductModelBameAndNumberDDTxt, ExpectdProductCategoryPlaceHolder);
				
			try {
			LoggerUtil.info("Actual Value = "+actualProductModelNameAndNumberPlaceHolder+ " || and || Expected Value = " + ExpectdProductModelNameNoPlaceHolder);
		
			soft.assertEquals(actualProductModelNameAndNumberPlaceHolder, ExpectdProductModelNameNoPlaceHolder,"EnterOnProductModelNameNoPlacePlaceHolder Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnProductModelNameNoPlacePlaceHolder:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnProductModelNameNoPlacePlaceHolder:- PlaceHolder Value Are Mismatched");
				
			}
			
			String ExpectdSpecialProductCategoryPlaceHolder = "None Selected";	
			String actualSpecielProductCategoryPlaceHolder =  verifyDropdownPlaceholder(clickOnSpecielProductCategoryDDTxt, ExpectdProductCategoryPlaceHolder);

			try {
			LoggerUtil.info("Actual Value = "+actualSpecielProductCategoryPlaceHolder+ " || and || Expected Value = " + ExpectdSpecialProductCategoryPlaceHolder);
		
			soft.assertEquals(actualSpecielProductCategoryPlaceHolder, ExpectdSpecialProductCategoryPlaceHolder,"EnterOnSpecialProductCategoryPlaceHolder Placeholder Value Are Mismatched");		
			LoggerUtil.pass("EnterOnSpecialProductCategoryPlaceHolder:- Value Are Matched");
			}catch(Exception e) {
				LoggerUtil.error("EnterOnSpecialProductCategoryPlaceHolder:- PlaceHolder Value Are Mismatched");
				
			}
		}
		
		
			public void verifyDropdownPartUOMOptionsAlphabeticalOrder(String searchTerm) {
			   
//				try {
//			        // Step 1: Click the dropdown using reusable method
//			        clickOnElement(selectOnPartUOM);
//			        LoggerUtil.info("Clicked on " + dropdownName + " dropdown");
//			        LoggerUtil.pass("Clicked on " + dropdownName + " dropdown");
//			    } catch (Exception e) {
//			        LoggerUtil.error("Failed to click on " + dropdownName + " dropdown: " + e.getMessage());
//			        return;
//			    }

				clickOnElement(selectOnPartUOM);
				try {
					LoggerUtil.info("clicked on Part UOM");		
					LoggerUtil.pass("clicked on Part UOM");		
					}catch(Exception e) {
						LoggerUtil.error("NOT clicked on Part UOM");		
					}
				   clearAndEnterText(waitForExpectedElement(enterdOnPartUOM), searchTerm);
				try {
					LoggerUtil.info(searchTerm+ "searchTerm on Part UOM");		
					LoggerUtil.pass(searchTerm+ "searchTerm on Part UOM");		
					}catch(Exception e) {
						LoggerUtil.error(searchTerm+ "NOT searchTerm on Part UOM");		
					}
			    try {
			        // Optional wait (3s for animation)
			        Thread.sleep(3000);

			        // Step 2: Capture all option elements
			        List<WebElement> options = driver.findElements(ListOfPartUom);
			        List<String> originalList = new ArrayList<>();

			        for (WebElement option : options) {
			            String text = option.getText().trim();
			            if (!text.isEmpty()) {
			                originalList.add(text);
			            }
			        }

			        // Step 3: Create a sorted version and compare
			        List<String> sortedList = new ArrayList<>(originalList);
			        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

			        if (originalList.equals(sortedList)) {
			            LoggerUtil.info(searchTerm + " dropdown options are alphabetically ordered.");
			            LoggerUtil.pass(searchTerm + " dropdown options are alphabetically ordered.");
			        } else {
			            LoggerUtil.error(searchTerm + " dropdown options are NOT alphabetically ordered.\n" +
			                "Original: " + originalList + "\nSorted: " + sortedList);
			        }

			    } catch (Exception ex) {
			        LoggerUtil.error("Error while verifying alphabetical order of " + searchTerm + " dropdown: " + ex.getMessage());
			    }
			}

			public static final By clickOn =By.xpath("//form[@id='PartMaster']");

			
			public void clicknormalforanywhere() {
				clickOnElement(clickOn);
			}
			
			public void verifyDropdownCompanyNameOptionsAlphabeticalOrder(String searchTerm) {
				   
				clickOnElement1(clickOnCompanyDropdown);
				try {
					LoggerUtil.info("clicked on Company Name");		
					LoggerUtil.pass("clicked on Company Name");		
					}catch(Exception e) {
						LoggerUtil.error("NOT clicked on Name");		
					}
				   clearAndEnterText(waitForExpectedElement(enterdOnCompanyName), searchTerm);
				try {
					LoggerUtil.info(searchTerm+ "searchTerm on Company Name");		
					LoggerUtil.pass(searchTerm+ "searchTerm on Company Name");		
					}catch(Exception e) {
						LoggerUtil.error(searchTerm+ "NOT searchTerm on Company Name");		
					}
			    try {
			        // Optional wait (3s for animation)
			        Thread.sleep(3000);

			        // Step 2: Capture all option elements
			        List<WebElement> options = driver.findElements(ListOfCompanyDropdown);
			        List<String> originalList = new ArrayList<>();

			        for (WebElement option : options) {
			            String text = option.getText().trim();
			            if (!text.isEmpty()) {
			                originalList.add(text);
			            }
			        }

			        // Step 3: Create a sorted version and compare
			        List<String> sortedList = new ArrayList<>(originalList);
			        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

			        if (originalList.equals(sortedList)) {
			            LoggerUtil.info(searchTerm + " dropdown options are alphabetically ordered.");
			            LoggerUtil.pass(searchTerm + " dropdown options are alphabetically ordered.");
			        } else {
			            LoggerUtil.error(searchTerm + " dropdown options are NOT alphabetically ordered.\n" +
			                "Original: " + originalList + "\nSorted: " + sortedList);
			        }

			    } catch (Exception ex) {
			        LoggerUtil.error("Error while verifying alphabetical order of " + searchTerm + " dropdown: " + ex.getMessage());
			    }
			}
		
			public void verifyDropdownCustomerOptionsAlphabeticalOrder(String searchTerm) {
				   
				clickOnElement(clickoncustomerdrop);
				try {
					LoggerUtil.info("clicked on Customer");		
					LoggerUtil.pass("clicked on Customer");		
					}catch(Exception e) {
						LoggerUtil.error("NOT clicked on Customer");		
					}
				   clearAndEnterText(waitForExpectedElement(searchOnCustomerTxt), searchTerm);
				try {
					LoggerUtil.info(searchTerm+ "searchTerm on Customer");		
					LoggerUtil.pass(searchTerm+ "searchTerm on Customer");		
					}catch(Exception e) {
						LoggerUtil.error(searchTerm+ "NOT searchTerm on Customer");		
					}
			    try {
			        // Optional wait (3s for animation)
			        Thread.sleep(3000);

			        // Step 2: Capture all option elements
			        List<WebElement> options = driver.findElements(customerotions);
			        List<String> originalList = new ArrayList<>();

			        for (WebElement option : options) {
			            String text = option.getText().trim();
			            if (!text.isEmpty()) {
			                originalList.add(text);
			            }
			        }

			        // Step 3: Create a sorted version and compare
			        List<String> sortedList = new ArrayList<>(originalList);
			        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

			        if (originalList.equals(sortedList)) {
			            LoggerUtil.info(searchTerm + " dropdown options are alphabetically ordered.");
			            LoggerUtil.pass(searchTerm + " dropdown options are alphabetically ordered.");
			        } else {
			            LoggerUtil.error(searchTerm + " dropdown options are NOT alphabetically ordered.\n" +
			                "Original: " + originalList + "\nSorted: " + sortedList);
			        }

			    } catch (Exception ex) {
			        LoggerUtil.error("Error while verifying alphabetical order of " + searchTerm + " dropdown: " + ex.getMessage());
			    }
			}
		
				public void verifyDropdownSuplierOptionsAlphabeticalOrder(String searchTerm) {
					   
					clickOnElement(clickOnSupplierDrop);
					try {
						LoggerUtil.info("clicked on Suplier");		
						LoggerUtil.pass("clicked on Suplier");		
						}catch(Exception e) {
							LoggerUtil.error("NOT clicked on Suplier");		
						}
					   clearAndEnterText(waitForExpectedElement(searchOnSupplierTxt), searchTerm);
					try {
						LoggerUtil.info(searchTerm+ "searchTerm on Suplier");		
						LoggerUtil.pass(searchTerm+ "searchTerm on Suplier");		
						}catch(Exception e) {
							LoggerUtil.error(searchTerm+ "NOT searchTerm on Suplier");		
						}
				    try {
				        // Optional wait (3s for animation)
				        Thread.sleep(3000);
	
				        // Step 2: Capture all option elements
				        List<WebElement> options = driver.findElements(selectsupplier);
				        List<String> originalList = new ArrayList<>();
	
				        for (WebElement option : options) {
				            String text = option.getText().trim();
				            if (!text.isEmpty()) {
				                originalList.add(text);
				            }
				        }
	
				        // Step 3: Create a sorted version and compare
				        List<String> sortedList = new ArrayList<>(originalList);
				        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
	
				        if (originalList.equals(sortedList)) {
				            LoggerUtil.info(searchTerm + " dropdown options are alphabetically ordered.");
				            LoggerUtil.pass(searchTerm + " dropdown options are alphabetically ordered.");
				        } else {
				            LoggerUtil.error(searchTerm + " dropdown options are NOT alphabetically ordered.\n" +
				                "Original: " + originalList + "\nSorted: " + sortedList);
				        }
	
				    } catch (Exception ex) {
				        LoggerUtil.error("Error while verifying alphabetical order of " + searchTerm + " dropdown: " + ex.getMessage());
				    }
				}
			

				public void verifyDropdownProductCategoryOptionsAlphabeticalOrder(String searchTerm) {
					   
					clickOnElement(clickOnProductCategoryDrop);
					try {
						LoggerUtil.info("clicked on ProductCategory");		
						LoggerUtil.pass("clicked on ProductCategory");		
						}catch(Exception e) {
							LoggerUtil.error("NOT clicked on ProductCategory");		
						}
					   clearAndEnterText(waitForExpectedElement(searchProduct), searchTerm);
					try {
						LoggerUtil.info(searchTerm+ "searchTerm on ProductCategory");		
						LoggerUtil.pass(searchTerm+ "searchTerm on ProductCategory");		
						}catch(Exception e) {
							LoggerUtil.error(searchTerm+ "NOT searchTerm on ProductCategory");		
						}
				    try {
				        // Optional wait (3s for animation)
				        Thread.sleep(3000);

				        // Step 2: Capture all option elements
				        List<WebElement> options = driver.findElements(selectsupplier);
				        List<String> originalList = new ArrayList<>();

				        for (WebElement option : options) {
				            String text = option.getText().trim();
				            if (!text.isEmpty()) {
				                originalList.add(text);
				            }
				        }

				        // Step 3: Create a sorted version and compare
				        List<String> sortedList = new ArrayList<>(originalList);
				        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

				        if (originalList.equals(sortedList)) {
				            LoggerUtil.info(searchTerm + " dropdown options are alphabetically ordered.");
				            LoggerUtil.pass(searchTerm + " dropdown options are alphabetically ordered.");
				        } else {
				            LoggerUtil.error(searchTerm + " dropdown options are NOT alphabetically ordered.\n" +
				                "Original: " + originalList + "\nSorted: " + sortedList);
				        }

				    } catch (Exception ex) {
				        LoggerUtil.error("Error while verifying alphabetical order of " + searchTerm + " dropdown: " + ex.getMessage());
				    }
				}
			
				public void verifyDropdownSpecielProductCategoryOptionsAlphabeticalOrder(String searchTerm) {
					   
					clickOnElement(clickOnSpecialProductCategoryDrop);
					try {
						LoggerUtil.info("clicked on SpecielProductCategory");		
						LoggerUtil.pass("clicked on SpecielProductCategory");		
						}catch(Exception e) {
							LoggerUtil.error("NOT clicked on SpecielProductCategory");		
						}
					   clearAndEnterText(waitForExpectedElement(searchSpecielProduct), searchTerm);
					try {
						LoggerUtil.info(searchTerm+ "searchTerm on SpecielProductCategory");		
						LoggerUtil.pass(searchTerm+ "searchTerm on SpecielProductCategory");		
						}catch(Exception e) {
							LoggerUtil.error(searchTerm+ "NOT searchTerm on SpecielProductCategory");
						}
				    try {
				        // Optional wait (3s for animation)
				        Thread.sleep(3000);

				        // Step 2: Capture all option elements
				        List<WebElement> options = driver.findElements(listOnSpecialProductCategoryDrop);
				        List<String> originalList = new ArrayList<>();

				        for (WebElement option : options) {
				            String text = option.getText().trim();
				            if (!text.isEmpty()) {
				                originalList.add(text);
				            }
				        }

				        // Step 3: Create a sorted version and compare
				        List<String> sortedList = new ArrayList<>(originalList);
				        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

				        if (originalList.equals(sortedList)) {
				            LoggerUtil.info(searchTerm + " dropdown options are alphabetically ordered.");
				            LoggerUtil.pass(searchTerm + " dropdown options are alphabetically ordered.");
				        } else {
				            LoggerUtil.error(searchTerm + " dropdown options are NOT alphabetically ordered.\n" +
				                "Original: " + originalList + "\nSorted: " + sortedList);
				        }

				    } catch (Exception ex) {
				        LoggerUtil.error("Error while verifying alphabetical order of " + searchTerm + " dropdown: " + ex.getMessage());
				    }
				}
				public static final By clickOnCustomerPlusButton =By.xpath("//a[@id='addNewCustomer']/span[1]/span[1]");
				public void clickOnCustomerPlusButton() {
					clickOnElement(clickOnCustomerPlusButton);
			}
				public void verifyCustomeraddedviaPartMasterappearscorrectlyindropdownandCustomerMaster(String CustomerCode,String CustomerName,String Location) {
					clickOnCustomerPlusButton();
					CustomerMasterPage =new CustomerMasterPage();
					CustomerMasterPage.addedNewCustomer(CustomerCode, CustomerName, Location);
				}
				public static final By clickOnCustomePasteIconBT =By.xpath("//button[@data-target='#copyPasteForcustomersallModule']");
				public void clickOnCustomePasteIcon() {
					clickOnElement(clickOnCustomePasteIconBT);
				}
				
				public static final By clickOnSupplierPasteIconBT =By.xpath("//button[@data-target='#copyPasteForSuppliersallModule']");
				public void clickOnSupplierPasteIcon() {
					clickOnElement(clickOnSupplierPasteIconBT);
				}
				private static final By customerModalRoot1 =
				        By.xpath("//h5[normalize-space()='Customer List']/ancestor::div[contains(@class,'modal')]");

				// NEW: Bootstrap backdrop
				private static final By modalBackdrop1 = By.cssSelector("div.modal-backdrop");

				/** Click outside the popup (backdrop or body). */
				public void clickOutsideCustomerPopup() {
				    LoggerUtil.info("Attempting outside click to close the Customer popup.");
				    try {
				        List<WebElement> backs = driver.findElements(modalBackdrop1);
				        if (!backs.isEmpty()) {
				            try {
				                backs.get(0).click();
				                LoggerUtil.info("Clicked on backdrop.");
				            } catch (Exception e) {
				                LoggerUtil.info("Direct click failed; retrying via JS on backdrop.");
				                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backs.get(0));
				            }
				        } else {
				            LoggerUtil.info("Backdrop not found. Clicking on body offset.");
				            WebElement body = driver.findElement(By.tagName("body"));
				            new org.openqa.selenium.interactions.Actions(driver)
				                    .moveToElement(body, 5, 5).click().perform();
				        }
				    } catch (Exception e) {
				        LoggerUtil.error("Error while clicking outside: " + e.getMessage());
				    }
				}
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				public static final By supplierPopupRoot =By.xpath("//div[@class='modal-content']//textarea[@id='SelectedSuppliersForAllModule']");
				public static final By popupCloseBtn =By.xpath("//button[@onclick='Suppliermodulesclose()']");

				public void validateSupplierPopupCloseByOutsideClick() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			        // Ensure popup is visible before attempting to close
			        LoggerUtil.info("Waiting for Supplier popup to become visible.");
			        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(supplierPopupRoot));
			       WebElement weObj= driver.findElement(supplierPopupRoot);
			      boolean we= weObj.isDisplayed();
			     String test= weObj.getText();
			      if(we==true) {
			    	  LoggerUtil.pass(test+"Supplier popup is visible.");
			      }else {
			    	  LoggerUtil.pass(test+"Supplier popup is not visible.");
			      }
			        

			        clickOutsideByCoordinates(popup);
			        // Validation: modal should disappear
			        LoggerUtil.info("Waiting for Supplier popup to close.");
			        boolean closed = wait.until(ExpectedConditions.invisibilityOfElementLocated(supplierPopupRoot));
			        Assert.assertTrue(closed, "Supplier popup should close after clicking outside.");
			        LoggerUtil.pass("Supplier popup closed successfully by clicking outside.");
			    }

			    /** Click at a point guaranteed to be outside the modal’s bounding box (right side with fallback to left). */
			    private void clickOutsideByCoordinates(WebElement popup) {
			        Rectangle r = popup.getRect();
			        int outsidePadding = 40;

			        // Try to click to the RIGHT of the modal
			        int targetX = r.getWidth() + outsidePadding; // offset from popup's left edge
			        int targetY = r.getHeight() / 2;             // mid-height

			        Actions actions = new Actions(driver);
			        try {
			            // moveToElement offsets are relative to the **top-left** corner of the element
			            actions.moveToElement(popup, targetX, targetY).click().perform();
			            LoggerUtil.info("Clicked outside (right side) of the modal.");
			            return;
			        } catch (MoveTargetOutOfBoundsException ignore) {
			            // Fallback: click to the LEFT of the modal
			        }

			        try {
			            actions.moveToElement(popup, -outsidePadding, targetY).click().perform();
			            LoggerUtil.info("Clicked outside (left side) of the modal.");
			        } catch (Exception e) {
			            // Final fallback: JS click on an element under a viewport coordinate outside the modal
			            LoggerUtil.info("Falling back to JS elementFromPoint click outside the modal.");
			            JavascriptExecutor js = (JavascriptExecutor) driver;
			            // Compute a viewport-safe coordinate to the right of the modal
			            Long vw = (Long) js.executeScript("return window.innerWidth;");
			            Long vh = (Long) js.executeScript("return window.innerHeight;");
			            long vx = Math.min(vw - 5, r.getX() + r.getWidth() + outsidePadding);
			            long vy = Math.min(vh - 5, r.getY() + r.getHeight() / 2);
			            js.executeScript(
			                "var el = document.elementFromPoint(arguments[0], arguments[1]); if(el){ el.click(); }",
			                vx, vy
			            );
			        }
			    }
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////

				/** Verify modal closed after outside click; logs all checks and returns boolean. */
				public boolean verifyCustomerPopupClosedAfterOutsideClick() {
				    WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				    WebDriverWait wait5  = new WebDriverWait(driver, Duration.ofSeconds(5));

				    boolean modalGone = false, backdropGone = false, bodyUnlocked = false, bgClickable = false;

				    // 1) Modal container invisible/removed
				    try {
				        wait10.until(ExpectedConditions.invisibilityOfElementLocated(customerModalRoot1));
				        modalGone = true;
				        LoggerUtil.pass("Modal is invisible/removed.");
				    } catch (TimeoutException te) {
				        LoggerUtil.error("Modal did not become invisible within timeout.");
				    }

				    // 2) Backdrop invisible/removed
				    try {
				        wait5.until(ExpectedConditions.invisibilityOfElementLocated(modalBackdrop1));
				        backdropGone = true;
				        LoggerUtil.pass("Backdrop disappeared.");
				    } catch (TimeoutException te) {
				        backdropGone = driver.findElements(modalBackdrop1).isEmpty();
				        if (backdropGone) {
				            LoggerUtil.pass("Backdrop not present in DOM.");
				        } else {
				            LoggerUtil.error("Backdrop still present after timeout.");
				        }
				    }

				    // 3) Body unlocked (no 'modal-open')
				    try {
				        bodyUnlocked = !(Boolean)((JavascriptExecutor)driver)
				                .executeScript("return document.body.classList.contains('modal-open');");
				        if (bodyUnlocked) {
				            LoggerUtil.pass("Body unlocked (no 'modal-open').");
				        } else {
				            LoggerUtil.error("Body still locked ('modal-open' present).");
				        }
				    } catch (Exception e) {
				        LoggerUtil.error("JS check for 'modal-open' failed: " + e.getMessage());
				        bodyUnlocked = false;
				    }

				    // 4) Background control is clickable again (paste icon behind modal)
				    try {
				        wait5.until(ExpectedConditions.elementToBeClickable(clickOnCustomePasteIconBT));
				        bgClickable = true;
				        LoggerUtil.pass("Background is clickable again (paste icon enabled).");
				    } catch (TimeoutException te) {
				        LoggerUtil.error("Background still not clickable (paste icon disabled).");
				    }

				    boolean allOk = modalGone && backdropGone && bodyUnlocked && bgClickable;

				    // Optional hint if your modal uses a static backdrop (outside click will not close)
				    if (!allOk) {
				        try {
				            WebElement modal = driver.findElement(customerModalRoot1);
				            String isStatic = modal.getAttribute("data-bs-backdrop");
				            if (isStatic != null && isStatic.equalsIgnoreCase("static")) {
				                LoggerUtil.info("Note: Modal configured with a static backdrop; outside click will not close it by design.");
				            }
				        } catch (Exception ignored) { }
				        LoggerUtil.error(String.format(
				            "Outside-click close verification failed. modalGone=%s, backdropGone=%s, bodyUnlocked=%s, bgClickable=%s",
				            modalGone, backdropGone, bodyUnlocked, bgClickable));
				    }
				    return allOk;
				}

				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				public static final By clickOnCustomePasteCloseIconBT =By.xpath("//h5[text()='Customer List']/following-sibling::button[@aria-label='Close']");
				public void clickOnCustomePasteCloseIconBT() {
					clickOnElement(clickOnCustomePasteCloseIconBT);
				}
				public static final By disabledOnCustomerList =By.xpath("//h5[normalize-space(text())='Customer List']");
				private static final By customerModalRoot =
				        By.xpath("//h5[normalize-space()='Customer List']/ancestor::div[contains(@class,'modal')]");
				private static final By modalBackdrop =
				        By.cssSelector("div.modal-backdrop");

				public boolean waitUntilCustomerPopupClosed() {
				    WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				    WebDriverWait wait5  = new WebDriverWait(driver, Duration.ofSeconds(5));

				    boolean modalGone = false, backdropGone = false, bodyUnlocked = false, bgClickable = false;

				    // 1) Modal invisible/removed
				    try {
				        wait10.until(ExpectedConditions.invisibilityOfElementLocated(customerModalRoot));
				        modalGone = true;
				        LoggerUtil.pass("Modal is invisible/removed.");
				    } catch (TimeoutException te) {
				        LoggerUtil.error("Modal did not become invisible within timeout.");
				    }

				    // 2) Backdrop invisible/removed
				    try {
				        wait5.until(ExpectedConditions.invisibilityOfElementLocated(modalBackdrop));
				        backdropGone = true;
				        LoggerUtil.pass("Backdrop disappeared.");
				    } catch (TimeoutException te) {
				        // Fallback: no elements found means it's gone
				        backdropGone = driver.findElements(modalBackdrop).isEmpty();
				        if (backdropGone) {
				            LoggerUtil.pass("Backdrop not present in DOM.");
				        } else {
				            LoggerUtil.error("Backdrop still present after timeout.");
				        }
				    }

				    // 3) Body unlocked (Bootstrap removes 'modal-open')
				    try {
				        bodyUnlocked = !(Boolean) ((JavascriptExecutor) driver)
				                .executeScript("return document.body.classList.contains('modal-open');");
				        if (bodyUnlocked) {
				            LoggerUtil.pass("Body unlocked (no 'modal-open' class).");
				        } else {
				            LoggerUtil.error("Body still locked ('modal-open' still present).");
				        }
				    } catch (Exception e) {
				        LoggerUtil.error("JS check for 'modal-open' failed: " + e.getMessage());
				        bodyUnlocked = false;
				    }

				    // 4) Background control clickable (paste icon enabled)
				    try {
				        // Ensure this locator exists in your class; otherwise pick any always-visible control behind the modal
				        wait5.until(ExpectedConditions.elementToBeClickable(clickOnCustomePasteIconBT));
				        bgClickable = true;
				        LoggerUtil.pass("Background is clickable again (paste icon enabled).");
				    } catch (TimeoutException te) {
				        LoggerUtil.error("Background still not clickable (paste icon disabled).");
				    }

				    boolean allOk = modalGone && backdropGone && bodyUnlocked && bgClickable;
				    if (!allOk) {
				        LoggerUtil.error(String.format(
				            "Customer popup close verification failed. modalGone=%s, backdropGone=%s, bodyUnlocked=%s, bgClickable=%s",
				            modalGone, backdropGone, bodyUnlocked, bgClickable));
				    }
				    return allOk;
				}
				/**
				 * Reads customer data from Excel and returns a list of strings in
				 * "Customer Name-Customer Code-Customer Location" format.
				 * Skips header row and any incomplete rows.
				 *
				 * @param filePath path to the Excel file
				 * @return List of customer strings for paste functionality
				 */
				public List<String> readCustomerPasteStrings(String filePath) throws IOException {
				    try (FileInputStream fis = new FileInputStream(filePath);
				         Workbook wb = new XSSFWorkbook(fis)) {

				        Sheet sheet = wb.getSheetAt(0); // or wb.getSheet("Customer List")
				        if (sheet == null) return Collections.emptyList();

				        Set<String> result = new LinkedHashSet<>(); // preserves order, removes duplicates
				        DataFormatter fmt = new DataFormatter();

				        // Column indexes: B=1 (Customer Code), C=2 (Customer Name), D=3 (Customer Location)
				        final int CODE_COL = 1, NAME_COL = 2, LOC_COL = 3;

				        for (int r = 2; r <= sheet.getLastRowNum(); r++) { // start at 1 to skip header
				            Row row = sheet.getRow(r);
				            if (row == null) continue;

				            String code = fmt.formatCellValue(row.getCell(CODE_COL)).trim();
				            String name = fmt.formatCellValue(row.getCell(NAME_COL)).trim();
				            String loc  = fmt.formatCellValue(row.getCell(LOC_COL)).trim();

				            if (code.isEmpty() || name.isEmpty() || loc.isEmpty()) continue;

				            // If you want to strip "Customer Code-" prefix, uncomment next line:
				            // code = code.replace("Customer Code-", "").trim();

				            //result.add(name + "-" + code + "-" + loc);
				            
				            result.add(name + "-" + loc + "-" + code);
				        }
				        return new ArrayList<>(result);
				    }
				    
				}
				
				public List<String> readSupplierPasteStrings(String filePath) throws IOException {
				    try (FileInputStream fis = new FileInputStream(filePath);
				         Workbook wb = new XSSFWorkbook(fis)) {

				        Sheet sheet = wb.getSheetAt(0);
				        if (sheet == null) return Collections.emptyList();

				        Set<String> result = new LinkedHashSet<>(); // preserves order, removes duplicates
				        DataFormatter fmt = new DataFormatter();

				        // Column indexes: B=1 (Customer Code), C=2 (Customer Name), D=3 (Customer Location)
				        final int CODE_COL = 1, NAME_COL = 2, LOC_COL = 3;

				        for (int r = 2; r <= sheet.getLastRowNum(); r++) { // start at 1 to skip header
				            Row row = sheet.getRow(r);
				            if (row == null) continue;

				            String code = fmt.formatCellValue(row.getCell(CODE_COL)).trim();
				            String name = fmt.formatCellValue(row.getCell(NAME_COL)).trim();
				            String loc  = fmt.formatCellValue(row.getCell(LOC_COL)).trim();

				            if (code.isEmpty() || name.isEmpty() || loc.isEmpty()) continue;

				            // If you want to strip "Customer Code-" prefix, uncomment next line:
				            // code = code.replace("Customer Code-", "").trim();

				            result.add(name + "-" + code + "-" + loc);
				            
				            //result.add(code + "-" + name + "-" + loc);
				        }
				        return new ArrayList<>(result);
				    }
				    
				}
				
				public List<String> readCustomerPasteStringsWrongs(String filePath) throws IOException {
				    try (FileInputStream fis = new FileInputStream(filePath);
				         Workbook wb = new XSSFWorkbook(fis)) {

				        Sheet sheet = wb.getSheetAt(0); // or wb.getSheet("Customer List")
				        if (sheet == null) return Collections.emptyList();

				        Set<String> result = new LinkedHashSet<>(); // preserves order, removes duplicates
				        DataFormatter fmt = new DataFormatter();

				        // Column indexes: B=1 (Customer Code), C=2 (Customer Name), D=3 (Customer Location)
				        final int CODE_COL = 1, NAME_COL = 2, LOC_COL = 3;

				        for (int r = 2; r <= sheet.getLastRowNum(); r++) { // start at 1 to skip header
				            Row row = sheet.getRow(r);
				            if (row == null) continue;

				            String code = fmt.formatCellValue(row.getCell(CODE_COL)).trim();
				            String name = fmt.formatCellValue(row.getCell(NAME_COL)).trim();
				            String loc  = fmt.formatCellValue(row.getCell(LOC_COL)).trim();

				            if (code.isEmpty() || name.isEmpty() || loc.isEmpty()) continue;

				            // If you want to strip "Customer Code-" prefix, uncomment next line:
				            // code = code.replace("Customer Code-", "").trim();

				            result.add(name + "-" + code + "-" + loc);
				            
				           // result.add(name + "-" + loc + "-" + code);
				        }
				        return new ArrayList<>(result);
				    }
				    
				}
				public void pasteTopNFromExcel(String filePath, int n) throws Exception {
				    List<String> all = readCustomerPasteStrings(filePath);
			    
			        if (all.isEmpty()) {
			            throw new IllegalStateException("No customer rows found in Excel: " + filePath);
			        }
			        int limit = Math.max(n, all.size());
			        for (int i = 0; i < limit; i++) {
			            pasteText(all.get(i));
			        }
			    }
				public static final By pastOnCustomerList =By.xpath("//textarea[@id='SelectedCustmerForAllModule']");

				public void pasteText(String value) {
					 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				     WebElement ta = wait.until(ExpectedConditions.visibilityOfElementLocated(pastOnCustomerList));

				    // paste via clipboard (if required by your app)
				    StringSelection sel = new StringSelection(value);
				    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
				    ta.click();
				    new Actions(driver).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

				    // wait until pasted content appears (textarea accumulates text)
				    wait.until(d -> {
				        String cur = ta.getAttribute("value");
				        return cur != null && cur.contains(value);
				    });

				    // add a newline for the next entry
				    addNewLine(ta);
				}

				public static final By pastOnSupplierList =By.xpath("//textarea[@id='SelectedSuppliersForAllModule']");

				public void pasteTextSupplier(String value) {
					 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				     WebElement ta = wait.until(ExpectedConditions.visibilityOfElementLocated(pastOnSupplierList));

				    // paste via clipboard (if required by your app)
				    StringSelection sel = new StringSelection(value);
				    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
				    ta.click();
				    new Actions(driver).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

				    // wait until pasted content appears (textarea accumulates text)
				    wait.until(d -> {
				        String cur = ta.getAttribute("value");
				        return cur != null && cur.contains(value);
				    });

				    // add a newline for the next entry
				    addNewLine(ta);
				}

				
				private void addNewLine(WebElement ta) {
				    // Try ENTER first
				    try {
				        ta.sendKeys(Keys.ENTER);
				        return;
				    } catch (Exception ignored) { }

				    // Fallbacks for apps that intercept ENTER:
				    try { ta.sendKeys(Keys.RETURN); return; } catch (Exception ignored) { }
				    try { ta.sendKeys("\n"); return; } catch (Exception ignored) { }

				    // Last-resort: JS append newline and fire input event
				    ((JavascriptExecutor) driver).executeScript(
				        "var el=arguments[0]; el.value += '\\n'; el.dispatchEvent(new Event('input',{bubbles:true}));",
				        ta
				    );
				}
				public static final By submitCustomerNameForAllModule =By.xpath("//button[@id='SubmitCustomernameForAllModule']");

				public void submitCustomerNameForAllModule() {
					clickOnElement(submitCustomerNameForAllModule);
				}
				
				
				
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////
				
				public static final By customerDropdownBtn =By.xpath("(//button[contains(@class,'multiselect dropdown-toggle')]//span)[2]");

				public void verifyCustomerAutoSelectedAfterSubmit(String pastedLine) throws InterruptedException {
				    
					clickOnElement1(customerDropdownBtn);
					
					List<WebElement> OptionsCustomerName = driver.findElements(customerotions1);
					
					Thread.sleep(3000);
					
					selectBootStrapDropDownAdvanced(OptionsCustomerName, pastedLine);
					LoggerUtil.pass("Dropdown caption reflects customer selection (name present): " + pastedLine);
				
					
				}

				////////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////

				public static final By supplierDropdownBtn =By.xpath("(//button[contains(@class,'multiselect dropdown-toggle')]//span)[3]");

				public void verifySupplierAutoSelectedAfterSubmit(String pastedLine) throws InterruptedException {

					clickOnElement1(supplierDropdownBtn);

					List<WebElement> OptionsCustomerName = driver.findElements(listOnSupplierDrop);

					Thread.sleep(3000);

					selectBootStrapDropDownAdvanced(OptionsCustomerName, pastedLine);
					LoggerUtil.pass("Dropdown caption reflects Supplier selection (name present): " + pastedLine);


				}

				////////////////////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				
				
				
				public static final By submitSupplierNameForAllModule =By.xpath("//button[@id='SubmitSuppliersnameForAllModule']");

				public void submitSupplierNameForAllModule() {
					clickOnElement(submitSupplierNameForAllModule);
				}
				/*public static final By countOfCustomerSelected =By.xpath("//input[@id='CustomerDisable']/following-sibling::span[1]");
				public String verifyCustomersAppearAndAreSelectable() {
				WebElement	weObj=driver.findElement(countOfCustomerSelected);
					String ac=getAttributeValue(weObj, "5 selected");
					return ac;
				}*/
				
				public void verifyCustomersAppearAndAreSelectable() {
					driver.findElement(By.xpath(
							"//form[@id='PartMaster']//select[@id='CustomerSelection']//following-sibling::div//span[@class='multiselect-selected-text']"))
							.click();
					List<WebElement> CustomerListOption = driver
							.findElements(By.xpath("//select[@id='CustomerSelection']//following-sibling::div//div[1]//button"));
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < 5) {
						int index = rand.nextInt(CustomerListOption.size());
						WebElement option = CustomerListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); // Click the label to select
							selectedLabels.add(label);
						}
					}
		 
					WebElement ele = driver.findElement(By.xpath(
							"//form[@id='PartMaster']//select[@id='CustomerSelection']//following-sibling::div//span[@class='multiselect-selected-text']"));
					String selecteditemCountActual = ele.getText();
					selecteditemCountActual = selecteditemCountActual.toLowerCase();
					String[] itemActual = selecteditemCountActual.split(",\\s*");
		 
					int randomIndex = new Random().nextInt(3);
		 
					Assert.assertTrue(selectedLabels.contains(itemActual[randomIndex]));
					System.out.println(selectedLabels.toString());
					System.out.println(itemActual[randomIndex]);
				}
				
				
				
				public static final By coustomerMisingTxt =By.xpath("//a[normalize-space(text())='These Customer are missing. Please check or add them to the master list.']");
				public String verifyCustomerMissingWarning() {
					WebElement	weObj=driver.findElement(coustomerMisingTxt);
					String ActualTxt=weObj.getText();
						return ActualTxt;
					}
				public static final By supplierMisingTxt =By.xpath("//a[normalize-space(text())='These suppliers are missing. Please check or add them to the master list.']");
				public String verifySupplierMissingWarning() {
					WebElement	weObj=driver.findElement(supplierMisingTxt);
					String ActualTxt=weObj.getText();
						return ActualTxt;
					}
				
				public static final By customerPasteTextarea =By.xpath("(//textarea[@placeholder='Paste'])[1]");

				public String getCustomerPastePlaceholderText() {
					WebElement	weObj=driver.findElement(customerPasteTextarea);
			        return weObj.getDomAttribute("placeholder");
			    }
				
				public static final By SupplierPasteTextarea =By.xpath("//textarea[@id='SelectedSuppliersForAllModule']");

				public String getSupplierPastePlaceholderText() {
					WebElement	weObj=driver.findElement(SupplierPasteTextarea);
			        return weObj.getDomAttribute("placeholder");
			    }
				
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////
				 // --- Flexible finders (work with common label-input patterns) ---
//			    private WebElement findRadioByLabel1(String labelText) {
//			        // Try: <label> contains text and holds the <input>
//			        List<WebElement> candidates = driver.findElements(By.xpath(
//			            "//label[normalize-space()='" + labelText + "']"
//			          + "[.//input[@type='radio']]"
//			        ));
//			        if (!candidates.isEmpty()) return candidates.get(0).findElement(By.xpath(".//input[@type='radio']"));
//
//			        // Try: <input> followed/preceded by label with text
//			        candidates = driver.findElements(By.xpath(
//			            "//label[normalize-space()='" + labelText + "']/preceding-sibling::input[@type='radio']"
//			          + " | //label[normalize-space()='" + labelText + "']/following-sibling::input[@type='radio']"
//			        ));
//			        if (!candidates.isEmpty()) return candidates.get(0);
//
//			        // Last resort: value attribute equals text (e.g., value='Both')
//			        candidates = driver.findElements(By.xpath("//input[@type='radio' and translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')="
//			                                                + "translate('" + labelText + "','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')]"));
//			        return candidates.isEmpty() ? null : candidates.get(0);
//			    }

			    // --- Core validation for PM_TC_030 ---
			    public void verifyDefaultRadioButtonIsBoth() {
			        try {
			            // Wait for the radio group area to be present (anchored near the Customer section)
			        	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
			            wait.until(ExpectedConditions.presenceOfElementLocated(
			                By.xpath("//*[normalize-space()='Customer' or normalize-space()='Sales' or normalize-space()='Procurement' or normalize-space()='Both']"))
			            );

			            WebElement bothRadio = findRadioByLabel("Both");
			            WebElement salesRadio = findRadioByLabel("Sales");
			            WebElement procurementRadio = findRadioByLabel("Procurement");

			            if (bothRadio == null) {
			                LoggerUtil.error("Radio button 'Both' not found.");
			                return;
			            }
			            LoggerUtil.info("Located radio buttons. "
			                    + "Sales=" + (salesRadio != null) + ", Procurement=" + (procurementRadio != null) + ", Both=" + (bothRadio != null));

			            // Do not click anything — check default state immediately after page load
			            boolean isBothSelected = bothRadio.isSelected();
			            boolean isSalesSelected = (salesRadio != null) && salesRadio.isSelected();
			            boolean isProcSelected  = (procurementRadio != null) && procurementRadio.isSelected();

			            if (isBothSelected && !isSalesSelected && !isProcSelected) {
			                LoggerUtil.pass("Default selection is correct: 'Both' is selected by default and other options are unselected.");
			            } else if (isBothSelected) {
			                LoggerUtil.pass("Default selection shows 'Both' selected (other options selection state may vary by DOM).");
			                if (isSalesSelected || isProcSelected) {
			                    LoggerUtil.info("Note: Another radio also appears selected; please review markup for exclusive grouping (same 'name' attribute).");
			                }
			            } else {
			                LoggerUtil.error("Default selection is incorrect. Expected: 'Both' selected. "
			                        + "Actual -> Sales: " + isSalesSelected + ", Procurement: " + isProcSelected + ", Both: " + isBothSelected);
			            }
			        } catch (TimeoutException te) {
			            LoggerUtil.error("Timeout while waiting for radio buttons: " + te.getMessage());
			        } catch (Exception e) {
			            LoggerUtil.error("Error during default radio validation: " + e.getMessage());
			        }
			    }
			    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 // --- Stable radio finder (fix the name and use this one) ---
			    private WebElement findRadioByLabel(String labelText) {
			        // <label> wraps <input>
			        List<WebElement> radios = driver.findElements(By.xpath(
			            "//label[normalize-space()='" + labelText + "'][.//input[@type='radio']]/input[@type='radio']"
			        ));
			        if (!radios.isEmpty()) return radios.get(0);

			        // <input> adjacent to its label
			        radios = driver.findElements(By.xpath(
			            "//input[@type='radio' and (following-sibling::label[normalize-space()='" + labelText + "'] " +
			            " or preceding-sibling::label[normalize-space()='" + labelText + "'])]"
			        ));
			        if (!radios.isEmpty()) return radios.get(0);

			        // fallback by @value
			        radios = driver.findElements(By.xpath(
			            "//input[@type='radio' and translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')=" +
			            "translate('" + labelText + "','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')]"
			        ));
			        return radios.isEmpty() ? null : radios.get(0);
			    }

			    // --- Use ONE reliable locator for the Supplier group container ---
			    private final By supplierGroup = By.xpath("//div[@id='supplierDiv']");

			    // --- Correct visibility check: USE the By you pass ---
			    private boolean isCurrentlyVisible(By by) {
			        try {
			            WebElement el = driver.findElement(by);
			            if (el.isDisplayed()) return true;

			            String disp = el.getCssValue("display");
			            String vis  = el.getCssValue("visibility");
			            String op   = el.getCssValue("opacity");
			            String aria = el.getAttribute("aria-hidden");

			            return !"none".equalsIgnoreCase(disp)
			                    && !"hidden".equalsIgnoreCase(vis)
			                    && !"0".equals(op)
			                    && !"true".equalsIgnoreCase(aria);
			        } catch (NoSuchElementException e) {
			            return false; // removed from DOM => not visible
			        }
			    }

			    // --- Helper: comprehensive hidden check (handles stale/removed/CSS-hidden) ---
			    private boolean isHiddenOrRemoved(WebDriver d, By by) {
			        try {
			            List<WebElement> els = d.findElements(by);
			            if (els.isEmpty()) return true; // removed

			            WebElement el = els.get(0);
			            if (!el.isDisplayed()) return true;

			            // Extra CSS checks via JS
			            String res = (String)((JavascriptExecutor)d).executeScript(
			                "var e=arguments[0], s=getComputedStyle(e); " +
			                "return s.display+'|'+s.visibility+'|'+s.opacity+'|'+(e.offsetParent===null);", el);
			            String[] p = res.split("\\|");
			            boolean hiddenStyle = "none".equalsIgnoreCase(p[0]) ||
			                                  "hidden".equalsIgnoreCase(p[1]) ||
			                                  "0".equals(p[2]) ||
			                                  Boolean.parseBoolean(p[3]);
			            return hiddenStyle;
			        } catch (StaleElementReferenceException sere) {
			            return true; // became stale => removed/replaced
			        } catch (Exception ex) {
			            LoggerUtil.error("Hidden-check exception: " + ex.getMessage());
			            return false;
			        }
			    }

			    // --- Core flow for PM_TC_031 (revised) ---
			    public void selectSalesAndVerifySupplierHidden() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			        // Baseline: Supplier visible before switching to "Sales"
			        try {
			            wait.until(ExpectedConditions.presenceOfElementLocated(supplierGroup));
			            boolean initiallyVisible = isCurrentlyVisible(supplierGroup);
			            LoggerUtil.info("Baseline - Supplier group visible: " + initiallyVisible);
			        } catch (Exception e) {
			            LoggerUtil.error("Baseline presence check failed: " + e.getMessage());
			        }

			        // Click "Sales"
			        try {
			            WebElement sales = findRadioByLabel("Sales");
			            if (sales == null) {
			                LoggerUtil.error("Radio button 'Sales' not found.");
			                return;
			            }
			            if (!sales.isSelected()) {
			                sales.click();
			                LoggerUtil.info("Clicked 'Sales' radio button.");
			            } else {
			                LoggerUtil.info("'Sales' was already selected.");
			            }
			        } catch (Exception e) {
			            LoggerUtil.error("Error selecting 'Sales' radio: " + e.getMessage());
			            return;
			        }

			        // Wait until Supplier group is hidden or removed
			        boolean hidden = false;
			        try {
			            hidden = wait.until(driver -> isHiddenOrRemoved(driver, supplierGroup));
			            LoggerUtil.info("Wait condition result (Supplier hidden/removed): " + hidden);
			        } catch (TimeoutException te) {
			            LoggerUtil.info("Timeout while waiting for Supplier to hide. Performing final explicit check.");
			            hidden = isHiddenOrRemoved(driver, supplierGroup);
			        } catch (Exception e) {
			            LoggerUtil.error("Error during hide wait: " + e.getMessage());
			            hidden = isHiddenOrRemoved(driver, supplierGroup);
			        }

			        if (hidden) {
			            LoggerUtil.pass("Supplier dropdown/control is hidden after selecting 'Sales' (as expected).");
			        } else {
			            LoggerUtil.error("Supplier dropdown/control is still visible after selecting 'Sales'.");
			        }
			    }
			    
			    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 // ---------- Robust resolver for the 'Customer Part No.' row ----------
			    private By resolveCustomerPartNoRow() {
			        List<By> attempts = Arrays.asList(
			            // Your labeled id (if present)
			            By.xpath("(//label[@id='customerpart'])[1]/ancestor::div[contains(@class,'row')][1]"),
			            // By visible text (fallback)
			            By.xpath("(//label[normalize-space()='Customer Part No.' or normalize-space()='Customer Part No'])[1]"
			                   + "/ancestor::div[contains(@class,'row')][1]")
			        );
			        for (By by : attempts) {
			            if (!driver.findElements(by).isEmpty()) return by;
			        }
			        // Last resort: non-matching locator (caller will handle)
			        return By.xpath("//*[(false)]");
			    }

			    // ---------- Single radio finder by visible label/value ----------
			    private WebElement findRadioByLabel3(String labelText) {
			        List<WebElement> radios = driver.findElements(By.xpath(
			            "//label[normalize-space()='" + labelText + "'][.//input[@type='radio']]/input[@type='radio']"
			        ));
			        if (!radios.isEmpty()) return radios.get(0);

			        radios = driver.findElements(By.xpath(
			            "//input[@type='radio' and (following-sibling::label[normalize-space()='" + labelText + "'] "
			          + " or preceding-sibling::label[normalize-space()='" + labelText + "'])]"
			        ));
			        if (!radios.isEmpty()) return radios.get(0);

			        radios = driver.findElements(By.xpath(
			            "//input[@type='radio' and translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')="
			          + "translate('" + labelText + "','ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')]"
			        ));
			        return radios.isEmpty() ? null : radios.get(0);
			    }

			    // ---------- Hidden/removed check ----------
			    private boolean isHiddenOrRemovedCustomerPartNum(WebDriver d, By by) {
			        try {
			            List<WebElement> els = d.findElements(by);
			            if (els.isEmpty()) return true;      // removed from DOM
			            WebElement el = els.get(0);
			            if (!el.isDisplayed()) return true;  // Selenium visibility

			            String res = (String)((JavascriptExecutor)d).executeScript(
			                "var e=arguments[0], s=getComputedStyle(e);"
			              + "return s.display+'|'+s.visibility+'|'+s.opacity+'|'+(e.offsetParent===null);", el);
			            String[] p = res.split("\\|");
			            boolean hiddenStyle = "none".equalsIgnoreCase(p[0]) ||
			                                  "hidden".equalsIgnoreCase(p[1]) ||
			                                  "0".equals(p[2]) ||
			                                  Boolean.parseBoolean(p[3]);
			            return hiddenStyle;
			        } catch (StaleElementReferenceException sere) {
			            return true; // replaced/removed
			        } catch (Exception ex) {
			            LoggerUtil.error("Hidden-check exception: " + ex.getMessage());
			            return false;
			        }
			    }

			    // ---------- Core flow for PM_TC_032 ----------
			    public void selectSalesAndVerifyCustomerPartNoHidden() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			        // Resolve target row once
			        By customerPartNoRow = resolveCustomerPartNoRow();
			        if (driver.findElements(customerPartNoRow).isEmpty()) {
			            LoggerUtil.error("'Customer Part No.' row not found. Verify locator.");
			            return;
			        }

			        // Baseline presence/visibility (before switching)
			        try {
			            wait.until(ExpectedConditions.presenceOfElementLocated(customerPartNoRow));
			            boolean baselineVisible = driver.findElement(customerPartNoRow).isDisplayed();
			            LoggerUtil.info("Baseline - 'Customer Part No.' visible: " + baselineVisible);
			        } catch (Exception e) {
			            LoggerUtil.error("Baseline presence check failed for 'Customer Part No.': " + e.getMessage());
			        }

			        // Select "Sales" radio
			        try {
			            WebElement sales = findRadioByLabel3("Sales");
			            if (sales == null) {
			                LoggerUtil.error("Radio button 'Sales' not found.");
			                return;
			            }
			            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", sales);
			            if (!sales.isSelected()) sales.click();
			            LoggerUtil.info("Selected 'Sales' radio.");
			        } catch (Exception e) {
			            LoggerUtil.error("Error selecting 'Sales' radio: " + e.getMessage());
			            return;
			        }

			        // Wait until the row is hidden or removed
			        boolean hidden;
			        try {
			            hidden = wait.until(d -> isHiddenOrRemovedCustomerPartNum(d, customerPartNoRow));
			            LoggerUtil.info("Hidden/removed wait result: " + hidden);
			        } catch (TimeoutException te) {
			            LoggerUtil.info("Timeout while waiting; performing final explicit hidden check.");
			            hidden = isHiddenOrRemovedCustomerPartNum(driver, customerPartNoRow);
			        } catch (Exception e) {
			            LoggerUtil.error("Error while waiting for hide: " + e.getMessage());
			            hidden = isHiddenOrRemovedCustomerPartNum(driver, customerPartNoRow);
			        }

			        if (hidden) {
			            LoggerUtil.pass("'Customer Part No.' field is hidden after selecting 'Sales'.");
			        } else {
			            LoggerUtil.error("'Customer Part No.' field is still visible after selecting 'Sales'.");
			        }
			    }
			    
			    public void validateSupplierPopupCloseByIcon() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			        LoggerUtil.info("Waiting for Supplier popup to be visible.");
			        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(supplierPopupRoot));
			        LoggerUtil.pass("Supplier popup is visible.");

			        WebElement closeBtn =driver.findElement(popupCloseBtn);
			       // WebElement closeBtn = findCloseIconWithin(popup);
			        Assert.assertNotNull(closeBtn, "Close icon/button not found in Supplier popup header.");

			        // Try normal click; fall back to Actions and then JS if needed.
			        try {
			            closeBtn.click();
			            LoggerUtil.info("Clicked close icon (direct click).");
			        } catch (Exception e1) {
			            try {
			                new Actions(driver).moveToElement(closeBtn).click().perform();
			                LoggerUtil.info("Clicked close icon (Actions fallback).");
			            } catch (Exception e2) {
			                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
			                LoggerUtil.info("Clicked close icon (JS fallback).");
			            }
			        }

			        LoggerUtil.info("Waiting for Supplier popup to close.");
			        boolean closed = wait.until(ExpectedConditions.invisibilityOfElementLocated(supplierPopupRoot));
			        Assert.assertTrue(closed, "Supplier popup should close after clicking the close icon.");
			        LoggerUtil.pass("Supplier popup closed successfully via close icon.");
			    }

			    public void VerifyProductCategoryfetchfromProductModel() {
			    	clickOnElement(clickOnProductCategoryDrop);
			    	
			    }
			    ////////////////////////////////////////////////////////////////////////////////////////////////////
				public static final By clickOnPartUOM =By.xpath("//select[@id='PartUOM']");
				private void selectOnPartUOMValue() {

			      WebElement weObj=  driver.findElement(By.xpath("//select[@id='PartUOM']"));
			      Select select =new Select(weObj);
			      select.selectByVisibleText("TON");
			    }
				
				/*   --------- -----------------------START PART MASTER DROPDOWN WITH THE HELP OF NUMBER-------------------------------*/
				
				public static final By clickOnCustomerDrop =By.xpath("//form[@id='PartMaster']//select[@id='CustomerSelection']//following-sibling::div//span[@class='multiselect-selected-text']");
				public static final By CustomerList =By.xpath("//select[@id='CustomerSelection']//following-sibling::div//div[1]//button");
				public static final By clickOndCustomerTxt =By.xpath("//div[@class='col-sm-4']//label[text()='Customer ']");

				public void selectedOnCustomersValue(int selectNumCustomer) {
					clickOnElement1(clickOnCustomerDrop);
					
					List<WebElement> CustomerListOption = driver.findElements(CustomerList);
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < selectNumCustomer) {
						int index = rand.nextInt(CustomerListOption.size());
						WebElement option = CustomerListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); 
							selectedLabels.add(label);
						}
					}
					clickOnElement1(clickOndCustomerTxt);
		 
				/*	WebElement ele = driver.findElement(clickOnCustomerDrop);
					String selecteditemCountActual = ele.getText();
					selecteditemCountActual = selecteditemCountActual.toLowerCase();
					String[] itemActual = selecteditemCountActual.split(",\\s*");
		 
					int randomIndex = new Random().nextInt(3);
		 
					Assert.assertTrue(selectedLabels.contains(itemActual[randomIndex])); */
					
			    }
				
				public static final By clickOndCompanyDrop =By.xpath("//form[@id='PartMaster']//select[@id='PlantSelection']//following-sibling::div//span[@class='multiselect-selected-text']");
				public static final By CompanyList =By.xpath("//select[@id='PlantSelection']//following-sibling::div//div[1]//button//label");
				
				public void selectOnCompanyValue(int selectNumberOfCompany) {
					clickOnElement1(clickOndCompanyDrop);
					
					List<WebElement> CompanyListOption = driver.findElements(CompanyList);
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < selectNumberOfCompany) {
						int index = rand.nextInt(CompanyListOption.size());
						WebElement option = CompanyListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); 
							selectedLabels.add(label);
						}
					}
					
				}
				
				public static final By clickOndSupplierDrop =By.xpath("//form[@id='PartMaster']//select[@id='SupplierSelection']//following-sibling::div//span[@class='multiselect-selected-text']");
				public static final By SupplierList =By.xpath("//select[@id='SupplierSelection']//following-sibling::div//div[1]//button//label");
				public static final By clickOndSupplierTxt =By.xpath("//div[@class='col-sm-4']//label[text()='Supplier']");

				private void selectOnSupplierValue(int selectNumberOfSupplier) {
					clickOnElement1(clickOndSupplierDrop);
					
					List<WebElement> supplierListOption = driver.findElements(SupplierList);
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < selectNumberOfSupplier) {
						int index = rand.nextInt(supplierListOption.size());
						WebElement option = supplierListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); 
							selectedLabels.add(label);
						}
					}
					clickOnElement1(clickOndSupplierTxt);
				}
				
				public static final By clickOndProductCategoryDrop =By.xpath("//form[@id='PartMaster']//select[@id='ProductModel']//following-sibling::div//span[@class='multiselect-selected-text']");
				public static final By productCategoryList =By.xpath("//select[@id='ProductModel']//following-sibling::div//div[1]//button//label");
				public static final By clickOndProductCategoryTxt =By.xpath("//div[@class='col-sm-4']//label[text()='Product Category']");

				private void selectOnProductCategoryValue(int selectNumberOfProductCategory) {
					clickOnElement1(clickOndProductCategoryDrop);
					
					List<WebElement> productCategoryListOption = driver.findElements(productCategoryList);
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < selectNumberOfProductCategory) {
						int index = rand.nextInt(productCategoryListOption.size());
						WebElement option = productCategoryListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); 
							selectedLabels.add(label);
						}
					}
					clickOnElement1(clickOndProductCategoryTxt);
				}
				
				
				public static final By clickOndProductModelNameAndNumberDrop =By.xpath("//form[@id='PartMaster']//select[@id='SubProductModel']//following-sibling::div//span[@class='multiselect-selected-text']");
				public static final By productModelNameAndNumberList =By.xpath("//select[@id='SubProductModel']//following-sibling::div//div[1]//button//label");
				public static final By clickOndProductModelNameAndNumberTxt =By.xpath("//label[contains(normalize-space(.), 'Product Model Name & No.')]");

				private void selectOnProductModelNameAndNumberValue(int selectNumberOfProductModelNameAndNum) {
					clickOnElement1(clickOndProductModelNameAndNumberDrop);
					
					List<WebElement> productModelNameAndNumListOption = driver.findElements(productModelNameAndNumberList);
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < selectNumberOfProductModelNameAndNum) {
						int index = rand.nextInt(productModelNameAndNumListOption.size());
						WebElement option = productModelNameAndNumListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); 
							selectedLabels.add(label);
						}
					}
					clickOnElement1(clickOndProductModelNameAndNumberTxt);
				}
				
				
				public static final By clickOndSpecielProductCategoryDrop =By.xpath("//form[@id='PartMaster']//select[@id='SpecialProductCategory']//following-sibling::div//span[@class='multiselect-selected-text']");
				public static final By specielProductCategoryList =By.xpath("//select[@id='SpecialProductCategory']//following-sibling::div//div[1]//button//label");
				private void selectOnSpecielProductCategoryValue(int selectNumberOfSpecielProductCategory) {
					clickOnElement1(clickOndSpecielProductCategoryDrop);
					
					List<WebElement> specielProductCategoryListOption = driver.findElements(specielProductCategoryList);
		 
					Set<String> selectedLabels = new HashSet<String>();
					Random rand = new Random();
		 
					while (selectedLabels.size() < selectNumberOfSpecielProductCategory) {
						int index = rand.nextInt(specielProductCategoryListOption.size());
						WebElement option = specielProductCategoryListOption.get(index);
						String label = option.getText().trim().toLowerCase();
		 
						if (!selectedLabels.contains(label)) {
							option.click(); 
							selectedLabels.add(label);
						}
					}
					
				}
				
				/*   --------- -----------------------END PART MASTER DROPDOWN WITH THE HELP OF NUMBER-------------------------------*/
				
				
				/*   --------- -----------------------START PART MASTER DROPDOWN WITH THE HELP OF TEXT-------------------------------*/
				
				// 1) Single company label
				public void selectOnCompanyValueByText(String companyLabel) {
				    clickOnElement1(clickOndCompanyDrop);

				    List<WebElement> options = driver.findElements(CompanyList);
				    String target = companyLabel == null ? "" : companyLabel.trim().toLowerCase();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String label = option.getText().trim().toLowerCase();
				        if (label.equals(target)) {
				            option.click();
				            LoggerUtil.info("Company selected: " + companyLabel);
				            matched = true;
				            break;
				        }
				    }
				    if (!matched) {
				        LoggerUtil.fail("Company not found in list: " + companyLabel);
				        throw new AssertionError("Company not found: " + companyLabel);
				    }
				}

				// 2) Multiple company labels (varargs)
				public void selectOnCompanyValuesByText(String... companyLabels) {
				    if (companyLabels == null || companyLabels.length == 0) {
				        LoggerUtil.fail("No company labels provided.");
				        throw new IllegalArgumentException("Provide at least one company label.");
				    }
				    clickOnElement1(clickOndCompanyDrop);

				    List<WebElement> options = driver.findElements(CompanyList);
				    Map<String, WebElement> optionMap = new HashMap<>();
				    for (WebElement opt : options) {
				        optionMap.put(opt.getText().trim().toLowerCase(), opt);
				    }

				    Set<String> alreadyClicked = new HashSet<>();
				    for (String label : companyLabels) {
				        String key = label == null ? "" : label.trim().toLowerCase();
				        WebElement opt = optionMap.get(key);
				        if (opt != null && !alreadyClicked.contains(key)) {
				            opt.click();
				            alreadyClicked.add(key);
				            LoggerUtil.info("Company selected: " + label);
				        } else {
				            LoggerUtil.fail("Company not found in list: " + label);
				            throw new AssertionError("Company not found: " + label);
				        }
				    }
				}
				
				// 1) Single company label
				public void selectOnCustomerValueByText(String customerLabels) {
				    clickOnElement1(clickOnCustomerDrop);

				    List<WebElement> options = driver.findElements(CustomerList);
				    String target = customerLabels == null ? "" : customerLabels.trim().toLowerCase();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String label = option.getText().trim().toLowerCase();
				        if (label.equals(target)) {
				            option.click();
				            LoggerUtil.info("Customer selected: " + customerLabels);
				            matched = true;
				            break;
				        }
				    }
				    if (!matched) {
				        LoggerUtil.fail("Customer not found in list: " + customerLabels);
				        throw new AssertionError("Customer not found: " + customerLabels);
				    }
				    clickOnElement1(clickOndCustomerTxt);
				}

				// 2) Multiple customer labels (varargs)
				public void selectOnCustomerValuesByText(String... customerLabels) {
				    if (customerLabels == null || customerLabels.length == 0) {
				        LoggerUtil.fail("No customer labels provided.");
				        throw new IllegalArgumentException("Provide at least one customer label.");
				    }
				    clickOnElement1(clickOnCustomerDrop);

				    List<WebElement> options = driver.findElements(CustomerList);
				    Map<String, WebElement> optionMap = new HashMap<>();
				    for (WebElement opt : options) {
				        optionMap.put(opt.getText().trim().toLowerCase(), opt);
				    }

				    Set<String> alreadyClicked = new HashSet<>();
				    for (String label : customerLabels) {
				        String key = label == null ? "" : label.trim().toLowerCase();
				        WebElement opt = optionMap.get(key);
				        if (opt != null && !alreadyClicked.contains(key)) {
				            opt.click();
				            alreadyClicked.add(key);
				            LoggerUtil.info("Customer selected: " + label);
				        } else {
				            LoggerUtil.fail("Customer not found in list: " + label);
				            throw new AssertionError("Customer not found: " + label);
				        }
				    }
				}
				
				// 1) Single supplier label
				public void selectOnSupplierValueByText(String supplierLabels) {
				    clickOnElement1(clickOnSupplierDrop);

				    List<WebElement> options = driver.findElements(SupplierList);
				    String target = supplierLabels == null ? "" : supplierLabels.trim().toLowerCase();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String label = option.getText().trim().toLowerCase();
				        if (label.equals(target)) {
				            option.click();
				            LoggerUtil.info("Supplier selected: " + supplierLabels);
				            matched = true;
				            break;
				        }
				    }
				    if (!matched) {
				        LoggerUtil.fail("Supplier not found in list: " + supplierLabels);
				        throw new AssertionError("Supplier not found: " + supplierLabels);
				    }
				    clickOnElement1(clickOndSupplierTxt);
				}

				// 2) Multiple supplier labels (varargs)
				public void selectOnSupplierValuesByText(String... supplierLabels) {
				    if (supplierLabels == null || supplierLabels.length == 0) {
				        LoggerUtil.fail("No supplier labels provided.");
				        throw new IllegalArgumentException("Provide at least one supplier label.");
				    }
				    clickOnElement1(clickOnSupplierDrop);

				    List<WebElement> options = driver.findElements(SupplierList);
				    Map<String, WebElement> optionMap = new HashMap<>();
				    for (WebElement opt : options) {
				        optionMap.put(opt.getText().trim().toLowerCase(), opt);
				    }

				    Set<String> alreadyClicked = new HashSet<>();
				    for (String label : supplierLabels) {
				        String key = label == null ? "" : label.trim().toLowerCase();
				        WebElement opt = optionMap.get(key);
				        if (opt != null && !alreadyClicked.contains(key)) {
				            opt.click();
				            alreadyClicked.add(key);
				            LoggerUtil.info("Supplier selected: " + label);
				        } else {
				            LoggerUtil.fail("Supplier not found in list: " + label);
				            throw new AssertionError("Supplier not found: " + label);
				        }
				    }
				}
				
				// 1) Single Product Category label
				public void selectOnProductCategoryValueByText(String ProductCategoryLabels) {
				    clickOnElement1(clickOnProductCategoryDrop);

				    List<WebElement> options = driver.findElements(productCategoryList);
				    String target = ProductCategoryLabels == null ? "" : ProductCategoryLabels.trim().toLowerCase();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String label = option.getText().trim().toLowerCase();
				        if (label.equals(target)) {
				            option.click();
				            LoggerUtil.info("Supplier selected: " + ProductCategoryLabels);
				            matched = true;
				            break;
				        }
				    }
				    if (!matched) {
				        LoggerUtil.fail("Supplier not found in list: " + ProductCategoryLabels);
				        throw new AssertionError("Supplier not found: " + ProductCategoryLabels);
				    }
				}

				// 2) Multiple Product Category labels (varargs)
				public void selectOnProductCategoryValuesByText(String... ProductCategoryLabels) {
				    if (ProductCategoryLabels == null || ProductCategoryLabels.length == 0) {
				        LoggerUtil.fail("No ProductCategory labels provided.");
				        throw new IllegalArgumentException("Provide at least one ProductCategory label.");
				    }
				    clickOnElement1(clickOnProductCategoryDrop);

				    List<WebElement> options = driver.findElements(productCategoryList);
				    Map<String, WebElement> optionMap = new HashMap<>();
				    for (WebElement opt : options) {
				        optionMap.put(opt.getText().trim().toLowerCase(), opt);
				    }

				    Set<String> alreadyClicked = new HashSet<>();
				    for (String label : ProductCategoryLabels) {
				        String key = label == null ? "" : label.trim().toLowerCase();
				        WebElement opt = optionMap.get(key);
				        if (opt != null && !alreadyClicked.contains(key)) {
				            opt.click();
				            alreadyClicked.add(key);
				            LoggerUtil.info("ProductCategory selected: " + label);
				        } else {
				            LoggerUtil.fail("ProductCategory not found in list: " + label);
				            throw new AssertionError("ProductCategory not found: " + label);
				        }
				    }
				    clickOnElement1(clickOndProductCategoryTxt);
				}
				
				// 1) Single Product Model Name And Number label
				public void selectOnProductModelNameAndNumberValueByText(String ProductModelNameAndNumberLabels) {
				    clickOnElement1(clickOnProductModelNameNoDrop);

				    List<WebElement> options = driver.findElements(productModelNameAndNumberList);
				    String target = ProductModelNameAndNumberLabels == null ? "" : ProductModelNameAndNumberLabels.trim().toLowerCase();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String label = option.getText().trim().toLowerCase();
				        if (label.equals(target)) {
				            option.click();
				            LoggerUtil.info("Product Model Name And Number selected: " + ProductModelNameAndNumberLabels);
				            matched = true;
				            break;
				        }
				    }
				    if (!matched) {
				        LoggerUtil.fail("Product Model Name And Number not found in list: " + ProductModelNameAndNumberLabels);
				        throw new AssertionError("Product Model Name And Number not found: " + ProductModelNameAndNumberLabels);
				    }
				    clickOnElement1(clickOndProductModelNameAndNumberTxt);
				}

				// 2) Multiple Product Model Name And Number labels (varargs)
				public void selectOnProductModelNameAndNumberValuesByText(String... ProductModelNameAndNumberLabels) {
				    if (ProductModelNameAndNumberLabels == null || ProductModelNameAndNumberLabels.length == 0) {
				        LoggerUtil.fail("No Product Model Name And Number labels provided.");
				        throw new IllegalArgumentException("Provide at least one Product Model Name And Number label.");
				    }
				    clickOnElement1(clickOnProductModelNameNoDrop);

				    List<WebElement> options = driver.findElements(productModelNameAndNumberList);
				    Map<String, WebElement> optionMap = new HashMap<>();
				    for (WebElement opt : options) {
				        optionMap.put(opt.getText().trim().toLowerCase(), opt);
				    }

				    Set<String> alreadyClicked = new HashSet<>();
				    for (String label : ProductModelNameAndNumberLabels) {
				        String key = label == null ? "" : label.trim().toLowerCase();
				        WebElement opt = optionMap.get(key);
				        if (opt != null && !alreadyClicked.contains(key)) {
				            opt.click();
				            alreadyClicked.add(key);
				            LoggerUtil.info("Product Model Name And Number selected: " + label);
				        } else {
				            LoggerUtil.fail("Product Model Name And Number not found in list: " + label);
				            throw new AssertionError("Product Model Name And Number not found: " + label);
				        }
				    }
				}
				
				// 1) Single Special Product Category label
				public void selectOnSpecialProductCategoryValueByText(String SpecialProductCategory) {
				    clickOnElement1(clickOnSpecialProductCategoryDrop);

				    List<WebElement> options = driver.findElements(specielProductCategoryList);
				    String target = SpecialProductCategory == null ? "" : SpecialProductCategory.trim().toLowerCase();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String label = option.getText().trim().toLowerCase();
				        if (label.equals(target)) {
				            option.click();
				            LoggerUtil.info("Special Product Category selected: " + SpecialProductCategory);
				            matched = true;
				            break;
				        }
				    }
				    if (!matched) {
				        LoggerUtil.fail("Special Product Category not found in list: " + SpecialProductCategory);
				        throw new AssertionError("Special Product Category not found: " + SpecialProductCategory);
				    }
				}

				// 2) Multiple Special Product Category labels (varargs)
				public void selectOnSpecialProductCategoryValuesByText(String... SpecialProductCategory) {
				    if (SpecialProductCategory == null || SpecialProductCategory.length == 0) {
				        LoggerUtil.fail("No Special Product Category labels provided.");
				        throw new IllegalArgumentException("Provide at least one Special Product Category label.");
				    }
				    clickOnElement1(clickOnSpecialProductCategoryDrop);

				    List<WebElement> options = driver.findElements(specielProductCategoryList);
				    Map<String, WebElement> optionMap = new HashMap<>();
				    for (WebElement opt : options) {
				        optionMap.put(opt.getText().trim().toLowerCase(), opt);
				    }

				    Set<String> alreadyClicked = new HashSet<>();
				    for (String label : SpecialProductCategory) {
				        String key = label == null ? "" : label.trim().toLowerCase();
				        WebElement opt = optionMap.get(key);
				        if (opt != null && !alreadyClicked.contains(key)) {
				            opt.click();
				            alreadyClicked.add(key);
				            LoggerUtil.info("Special Product Category selected: " + label);
				        } else {
				            LoggerUtil.fail("Special Product Category not found in list: " + label);
				            throw new AssertionError("Special Product Category not found: " + label);
				        }
				    }
				}
				
				
				
				/*   --------- -----------------------END PART MASTER DROPDOWN WITH THE HELP OF TEXT-------------------------------*/
				
				public static final By partMasterSaveBtn =By.xpath("//form[@id='PartMaster']//following-sibling::button[@id='modelSave']");
				public void partMasterSaveBtn() throws InterruptedException {
					clickOnElement1(partMasterSaveBtn);
					Thread.sleep(2000);
				}
				
				public static final By partMasterViewBtn =By.xpath("//form[@id='PartMaster']//following-sibling::button[@id='modelView']");
				public void partMasterViewBtn() {
					clickOnElement1(partMasterViewBtn);
				}
				
				public static final By searchBtnPartMasterFilterIcon =By.xpath("//div//input[@id='searchBoxPartMaster']/following-sibling::i");
				public static final By searchBtnPartMasterFilterIconLabelList =By.xpath("//div[@id='chkPartMaster']//label");

				public void searchBtnPartMasterFilterIcon(String target) {
				    LoggerUtil.info("Opening Part Master filter and selecting: " + target);
				    clickOnElement1(searchBtnPartMasterFilterIcon);
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				            searchBtnPartMasterFilterIconLabelList
				    ));

				    String wanted = target == null ? "" : target.trim();

				    boolean matched = false;
				    for (WebElement option : options) {
				        String labelText = option.getText() == null ? "" : option.getText().trim();
				        if (labelText.equalsIgnoreCase(wanted)) {
				            option.click();
				            LoggerUtil.info("Filter value selected: " + labelText);
				            matched = true;
				            break;
				        }
				    }

				    if (!matched) {
				        LoggerUtil.fail("Filter value not found in list: " + wanted);
				        throw new AssertionError("Filter option not found: " + wanted);
				    }
				}

				
				public static final By searchBoxPartMaster =By.xpath("//input[@id='searchBoxPartMaster']");
				public static final By searchBtnPartMaster =By.xpath("//button[@id='btnSearchPart']");
				public void searchBoxPartMaster(String txt) {
					sendKeysToTextBox(searchBoxPartMaster, txt);
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					clickOnElement1(searchBtnPartMaster);
				}
				
				public static final By partMasterEditBtn =By.xpath("//table[@id='modelTable']/tbody//td/a[contains(@onclick,'editModel')]");
				public void partMasterEditBtn() {
					clickOnElement1(partMasterEditBtn);
				}
				
				
				private static final By productCategoryCheckedRows = By.xpath(
					    "//select[@id='ProductModel']//following-sibling::div" +
					    "//*[self::li or self::button][contains(@class,'active') or contains(@class,'selected') " +
					    " or .//input[@type='checkbox' and (@checked='true' or @aria-checked='true')]]"
					);
				
				private Set<String> lastSelectedProductCategories = new LinkedHashSet<>();
				
				public void verifyMultipleAllocationOfProductCategoryPersisted(int expectedCount) {
				   
				    clickOnElement1(clickOndProductCategoryDrop);
				    Set<String> after = readCheckedProductCategoryLabels();
				    clickOnElement1(clickOndProductCategoryTxt);

				    // Count check (optional but useful for the test case)
				    if (after.size() == expectedCount) {
				        LoggerUtil.pass("Count OK. Expected " + expectedCount + ", found " + after.size());
				    } else {
				        LoggerUtil.fail("Count mismatch. Expected " + expectedCount + ", found " + after.size());
				    }
				    
				    // Set equality check (order-independent)
				    if (after.equals(lastSelectedProductCategories)) {
				        LoggerUtil.pass("All selected Product Categories are saved and displayed: " + after);
				    } else {
				        LoggerUtil.fail("Saved vs Displayed mismatch.\nSelected before Save: " 
				                        + lastSelectedProductCategories + "\nAfter reload: " + after);
				    }
				}

				private Set<String> readCheckedProductCategoryLabels() {
				    List<WebElement> rows = driver.findElements(productCategoryCheckedRows);
				    Set<String> labels = new LinkedHashSet<>();
				    for (WebElement r : rows) {
				        String t;
				        try {
				            t = r.findElement(By.xpath(".//label")).getText().trim();
				        } catch (NoSuchElementException e) {
				            t = r.getText().trim();
				        }
				        if (!t.equalsIgnoreCase("Select all") && !t.isBlank()) {
				            labels.add(t);
				        }
				    }
				    LoggerUtil.info("Currently checked Product Categories: " + labels);
				    return labels;
				}
				
				
			    public void fillMandatoryForNewPart(String partNo, String partDesc, String customerPartNum,String hsnCode,int numCompany,
                    int numCustomer, int numSupplier, int numProductCategory,int numProductModelNameAndNum,int numSpecielProductCategory) throws InterruptedException{
			    	sendKeysToTextBox(enterOnPartNumber, partNo);
			    	sendKeysToTextBox(enterOnPartDescription, partDesc);
			    	sendKeysToTextBox(enterOnCustomerPartNumber, customerPartNum);
			    	sendKeysToTextBox(enterOnHSNCode, hsnCode);
			    	selectOnPartUOMValue();
			    	selectOnCompanyValue(numCompany);
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	selectedOnCustomersValue(numCustomer);
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	selectOnSupplierValue(numSupplier);
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	selectOnProductCategoryValue(numProductCategory);
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	selectOnProductModelNameAndNumberValue(numProductModelNameAndNum);
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	selectOnSpecielProductCategoryValue(numSpecielProductCategory);
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	  partMasterSaveBtn();
			    	try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			    	
}
			    /** Core validator for PM_TC_046 (black-box dependency). */
			   
			    private static final By pc_AllChecked = By.xpath(
			        "//select[@id='ProductModel']//following-sibling::div//*[self::li or self::button][contains(@class,'active') or contains(@class,'selected') "
			      + " or .//input[@type='checkbox' and (@checked='true' or @aria-checked='true')]]"
			    );
			    private static final By pc_SelectAllCb = By.xpath(
			        "//select[@id='ProductModel']//following-sibling::div//*[.='Select all' or .//label[normalize-space()='Select all']]//input[@type='checkbox']"
			    );

			    private static final By pm_ListItems = productModelNameAndNumberList; // reuse

			    private void openProductCategory()  { clickOnElement1(clickOndProductCategoryDrop); }
			    private void closeProductCategory() { clickOnElement1(clickOndProductCategoryTxt); }
			    private void openProductModel()     { clickOnElement1(clickOndProductModelNameAndNumberDrop); }
			    private void closeProductModel()    { clickOnElement1(clickOndProductModelNameAndNumberTxt); }

			    /** Unselect all Product Categories (tries “Select all”; falls back to clicking each selected). */
			    private void clearAllProductCategories() {
			        openProductCategory();
			        List<WebElement> selectAll = driver.findElements(pc_SelectAllCb);
			        if (!selectAll.isEmpty()) {
			            WebElement cb = selectAll.get(0);
			            if (cb.isSelected()) cb.click();   // unselect all
			            else { cb.click(); cb.click(); }   // toggle twice to ensure clear
			        } else {
			            // Fallback: click each checked row to uncheck
			            List<WebElement> checked = driver.findElements(pc_AllChecked);
			            for (WebElement row : checked) {
			                row.click();
			            }
			        }
			        closeProductCategory();
			    }

			    /** Click a Product Category by visible label text. */
			    private void selectSingleProductCategoryByLabel(String label) {
			        clearAllProductCategories();
			        openProductCategory();
			        List<WebElement> all = driver.findElements(productCategoryList);
			        boolean clicked = false;
			        for (WebElement el : all) {
			            String txt = el.getText().trim();
			            if (txt.equalsIgnoreCase(label)) {
			                el.click();
			                clicked = true;
			                break;
			            }
			        }
			        closeProductCategory();
			        if (!clicked) {
			            LoggerUtil.fail("Product Category not found: " + label);
			            throw new AssertionError("Category not found: " + label);
			        }
			    }

			    /** Select two categories (union case). */
			    private void selectTwoProductCategoriesByLabel(String labelA, String labelB) {
			        clearAllProductCategories();
			        openProductCategory();
			        List<WebElement> all = driver.findElements(productCategoryList);
			        int hit = 0;
			        for (WebElement el : all) {
			            String txt = el.getText().trim();
			            if (txt.equalsIgnoreCase(labelA) || txt.equalsIgnoreCase(labelB)) {
			                el.click(); hit++;
			            }
			        }
			        closeProductCategory();
			        if (hit < 2) {
			            LoggerUtil.fail("Could not select both categories: " + labelA + " & " + labelB);
			            throw new AssertionError("Missing category for union selection");
			        }
			    }

			    /** Read all visible Product Model labels from the dropdown (no selection; just options shown). */
			    private Set<String> readVisibleProductModelOptions() {
			        openProductModel();
			        List<WebElement> rows = driver.findElements(pm_ListItems);
			        Set<String> labels = new LinkedHashSet<>();
			        for (WebElement r : rows) {
			            String t = r.getText().trim();
			            if (!t.isBlank() && !t.equalsIgnoreCase("Select all")) labels.add(t);
			        }
			        LoggerUtil.info("Visible Product Models: " + labels);
			        closeProductModel();
			        return labels;
			    }

			    /** Pick two distinct Product Categories by reading the first two labels from the list. */
			    private String[] pickTwoCategoryLabelsFromList() {
			        openProductCategory();
			        List<WebElement> all = driver.findElements(productCategoryList);
			        List<String> labels = new ArrayList<>();
			        for (WebElement el : all) {
			            String t = el.getText().trim();
			            if (!t.isBlank() && !t.equalsIgnoreCase("Select all")) labels.add(t);
			            if (labels.size() == 2) break;
			        }
			        closeProductCategory();
			        if (labels.size() < 2) {
			            throw new AssertionError("Not enough Product Categories available to run dependency test.");
			        }
			        return new String[]{ labels.get(0), labels.get(1) };
			    }
			    /** Core validator for PM_TC_046 (black-box dependency). */
			    public void verifyProductModelDependsOnProductCategory_UIOnly() {
			       
			        String[] cats = pickTwoCategoryLabelsFromList();
			        String catA = cats[0], catB = cats[1];
			        LoggerUtil.info("Testing dependency with categories: " + catA + " and " + catB);

			        // 1) Only A
			        selectSingleProductCategoryByLabel(catA);
			        Set<String> setA = readVisibleProductModelOptions();

			        // 2) Only B
			        selectSingleProductCategoryByLabel(catB);
			        Set<String> setB = readVisibleProductModelOptions();

			        // 3) A + B together
			        selectTwoProductCategoriesByLabel(catA, catB);
			        Set<String> setAB = readVisibleProductModelOptions();

			        // Expectation: setAB == union(setA, setB)
			        Set<String> union = new LinkedHashSet<>(setA);
			        union.addAll(setB);

			        if (setAB.equals(union)) {
			            LoggerUtil.pass("Union property OK: Models(A+B) == Models(A) ∪ Models(B)");
			        } else {
			            LoggerUtil.fail("Union property FAILED.\nA: " + setA + "\nB: " + setB + "\nA+B shown: " + setAB + "\nExpected union: " + union);
			            throw new AssertionError("Product Model union mismatch");
			        }

			        // Negative checks: exclusives must not leak across
			        Set<String> onlyB = new LinkedHashSet<>(setB); onlyB.removeAll(setA);
			        Set<String> onlyA = new LinkedHashSet<>(setA); onlyA.removeAll(setB);

			        selectSingleProductCategoryByLabel(catA);
			        Set<String> afterA = readVisibleProductModelOptions();
			        if (afterA.stream().anyMatch(onlyB::contains)) {
			            LoggerUtil.fail("Leakage: Models exclusive to " + catB + " are visible under only " + catA);
			            throw new AssertionError("Negative check failed (A shows B-only models)");
			        } else {
			            LoggerUtil.pass("Negative check A OK: No B-only models under only " + catA);
			        }

			        selectSingleProductCategoryByLabel(catB);
			        Set<String> afterB = readVisibleProductModelOptions();
			        if (afterB.stream().anyMatch(onlyA::contains)) {
			            LoggerUtil.fail("Leakage: Models exclusive to " + catA + " are visible under only " + catB);
			            throw new AssertionError("Negative check failed (B shows A-only models)");
			        } else {
			            LoggerUtil.pass("Negative check B OK: No A-only models under only " + catB);
			        }
			    }
			    public void enterOnCommanValuPartMasterText(String partNo,String partDesc,String customerPartNum,String hsnCode) {
			    	sendKeysToTextBox(enterOnPartNumber, partNo);
			    	sendKeysToTextBox(enterOnPartDescription, partDesc);
			    	sendKeysToTextBox(enterOnCustomerPartNumber, customerPartNum);
			    	sendKeysToTextBox(enterOnHSNCode, hsnCode);
			    	selectOnPartUOMValue();
			    	
			    }
			    public void enterOnCommanDropPartMasterText(String companyValuText,String customerValueText,String supplierValueText,String productCategoryValueText,String productModelNameAndNumberValueText) {
			    	selectOnCompanyValueByText(companyValuText);
			    	selectOnCustomerValueByText(customerValueText);
			    	selectOnSupplierValueByText(supplierValueText);
			    	selectOnProductCategoryValuesByText(productCategoryValueText);
			    	try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			    	selectOnProductModelNameAndNumberValueByText(productModelNameAndNumberValueText);
			    	
			    	
			    }
			    
			   
			    public void verifyMultipleSelectionInSpecialProductCategory(String... SpecialProductCategory) {
			        if (SpecialProductCategory == null || SpecialProductCategory.length == 0) {
			            LoggerUtil.fail("No Special Product Category labels provided.");
			            throw new IllegalArgumentException("Provide at least one Special Product Category label.");
			        }

			        clickOnElement1(clickOnSpecialProductCategoryDrop);

			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
			        // Wait until options are visible at least once
			        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(specielProductCategoryList));

			        Set<String> alreadyClicked = new HashSet<>();
			        for (String label : SpecialProductCategory) {
			            final String wanted = normalize(label);

			            boolean foundAndClicked = false;

			            // Re-query options each time (UI may re-render after every click)
			            List<WebElement> options = wait.until(
			                ExpectedConditions.visibilityOfAllElementsLocatedBy(specielProductCategoryList)
			            );

			            for (WebElement opt : options) {
			                String txt = normalize(opt.getText());
			                if (txt.equals(wanted) && !alreadyClicked.contains(wanted)) {
			                    // Bring the option into view before clicking
			                    try {
			                        ((JavascriptExecutor) driver)
			                            .executeScript("arguments[0].scrollIntoView({block:'nearest'});", opt);
			                    } catch (Exception ignored) {}

			                    try {
			                        opt.click();
			                    } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			                        // Fallback: try clicking a child control (label/span/input) if present
			                        try {
			                            WebElement clickTarget = opt.findElement(By.xpath(".//input|.//label|.//span"));
			                            clickTarget.click();
			                        } catch (Exception ex) {
			                            LoggerUtil.fail("Unable to click Special Product Category option: " + label + " due to " + e.getClass().getSimpleName());
			                            throw e;
			                        }
			                    }

			                    LoggerUtil.info("Special Product Category selected: " + label);
			                    alreadyClicked.add(wanted);
			                    foundAndClicked = true;
			                    break;
			                }
			            }

			            if (!foundAndClicked) {
			                LoggerUtil.fail("Special Product Category not found in list: " + label);
			                throw new AssertionError("Special Product Category not found: " + label);
			            }
			        }
			    }

			    /** Normalizes label text safely for comparison. */
			    private String normalize(String s) {
			        if (s == null) return "";
			        return s.replace('\n', ' ')
			                .replaceAll("\\s+", " ")
			                .trim()
			                .toLowerCase(Locale.ROOT);
			    }
			    
			    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			    
			 // Locators already defined
			    /*public static final By partMasterTable        = By.id("modelTable");
			    public static final By partMasterHeaderCells  = By.xpath("//table[@id='modelTable']//thead/tr/th");
			    public static final By partMasterBodyRows     = By.xpath("//table[@id='modelTable']//tbody/tr");
			    public static final By partMasterTableDetails = By.xpath("//table[@id='modelTable']/tbody/tr/td");

			    public void getPartMasterDetails(String data,String value) {
			        List<WebElement> headers = driver.findElements(partMasterHeaderCells);
			        List<WebElement> rows = driver.findElements(partMasterBodyRows);

			      
			        int Index = -1;
			        for (int i = 0; i < headers.size(); i++) {
			            if (headers.get(i).getText().trim().equalsIgnoreCase(data)) {
			            	Index = i;
			                break;
			            }
			        }

			        if (Index == -1) {
			            System.out.println(data+ "column not found!");
			            return;
			        }

			      
			        for (WebElement row : rows) {
			            List<WebElement> cells = row.findElements(By.tagName("td"));
			            
			            if (cells.size() > Index) {
			                String partMasterValue = cells.get(Index).getText().trim();
			                if (partMasterValue.equals(value)) {
			                   
			                    System.out.println("Row for" +data+" "+value);
			                    for (int j = 0; j < Math.min(headers.size(), cells.size()); j++) {
			                        String header = headers.get(j).getText().trim();
			                        String actualValue = cells.get(j).getText().trim();
			                        System.out.println(header + " : " + actualValue);
			                        LoggerUtil.info("Fetched row for " + searchHeader + " = " + searchValue);
			                    }
			                    break;
			                }
			            }
			        }
			    }  */ 
			    
			    
			 // Locators (as given)
			    public static final By partMasterTable        = By.id("modelTable");
			    public static final By partMasterHeaderCells  = By.xpath("//table[@id='modelTable']//thead/tr/th");
			    public static final By partMasterBodyRows     = By.xpath("//table[@id='modelTable']//tbody/tr");
			    public static final By partMasterTableDetails = By.xpath("//table[@id='modelTable']/tbody/tr/td");

			    

			    private void waitForTableReady() {
			        new WebDriverWait(driver, Duration.ofSeconds(10))
			            .until(ExpectedConditions.presenceOfElementLocated(partMasterTable));
			        new WebDriverWait(driver, Duration.ofSeconds(10))
			            .until(d -> !d.findElements(partMasterBodyRows).isEmpty());
			    }

			    private String norm(String s){ return s == null ? "" : s.replace('\u00A0',' ').trim(); }

			    /** Returns a case-insensitive header->index map. */
			    private Map<String,Integer> headerIndexMap() {
			        List<WebElement> headers = driver.findElements(partMasterHeaderCells);
			        Map<String,Integer> map = new LinkedHashMap<>();
			        for (int i=0;i<headers.size();i++){
			            String h = norm(headers.get(i).getText());
			            if(!h.isEmpty()) map.put(h.toLowerCase(Locale.ROOT), i);
			        }
			        return map;
			    }

			    /** Returns whole row as header->value for the row where searchHeader == searchValue. */
			    public Map<String,String> getRowDataBy(String searchHeader, String searchValue) {
			        waitForTableReady();

			        List<WebElement> headerEls = driver.findElements(partMasterHeaderCells);
			        Map<String,Integer> hmap = headerIndexMap();

			        Integer idx = hmap.get(norm(searchHeader).toLowerCase(Locale.ROOT));
			        if (idx == null) throw new NoSuchElementException("Header not found: " + searchHeader);

			        List<WebElement> rows = driver.findElements(partMasterBodyRows);
			        WebElement match = null;
			        for (WebElement r : rows) {
			            List<WebElement> cells = r.findElements(By.tagName("td"));
			            if (cells.size() > idx && norm(cells.get(idx).getText()).equals(searchValue)) {
			                match = r; break;
			            }
			        }
			        if (match == null)
			            throw new NoSuchElementException("No row found where \""+searchHeader+"\" = \""+searchValue+"\"");

			        List<WebElement> cells = match.findElements(By.tagName("td"));
			        int count = Math.min(headerEls.size(), cells.size());

			        Map<String,String> out = new LinkedHashMap<>();
			        for (int i=0;i<count;i++){
			            String h = norm(headerEls.get(i).getText());
			            String v = norm(cells.get(i).getText());
			            out.put(h, v);
			        }
			        LoggerUtil.info("Fetched row for " + searchHeader + " = " + searchValue);
			        return out;
			    }

			    /** Convenience: gets a single cell value from the matched row. */
			    public String getCellBy(String searchHeader, String searchValue, String targetHeader){
			        Map<String,String> row = getRowDataBy(searchHeader, searchValue);
			        for (String k : row.keySet()){
			            if (k.equalsIgnoreCase(targetHeader)) return row.get(k);
			        }
			        throw new NoSuchElementException("Target header not found: " + targetHeader);
			    }

}		    
			 
			    	

			    
			    
			    
			    
			    
			    

