package com.Pages;
 
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
 
import com.helper.Base;
import com.helper.LoggerUtil;
 
public class PCC_PageMaster extends Base{
 
	DashboardPage	dashboard = new DashboardPage();
	public static final By ClickingCompanyDropdown = By.xpath("//*[@id='CompanySel']/following-sibling::div/button");
	public static final By ClickingCustomerDropdown = By.xpath("//select[@id='customerSel']/following-sibling::div/button");
	public static final By ClickingProductModelNumber = By.xpath("//select[@id='pmSel']/following-sibling::div/button");
	public static final By ClickingSegMentDropdown = By.xpath("//select[@id='ddlSegment']/following-sibling::div/button");
	public static final By ClickingSupplierDropdown = By.xpath("//select[@id='sup']/following-sibling::div/button");
	public static final By clickingPartWiseBomWise = By.xpath("//select[@id='ddlPartWiseBOMwise']");
	public static final By clickingPartnumberDropdownbutton = By.xpath("//select[@id='partno']/following-sibling::div/button");
	public static final By EnterEffectiveStartDate = By.xpath("//input[@id='Date_of_Raising_Issue']");
	public static final By EnetrEffectiveEndDate = By.xpath("//input[@id='Effective_End_date']");
	public static final By clickingincoTerms = By.xpath("//span[@id='select2-Inco-container']");	
	public static final By clickingRmCheckbox = By.xpath("//input[@id='chkRMOnly']");
	public static final By clickingPaymentTerms = By.xpath("//span[@id='select2-Payment-container']");
	public static final By clickingPoType  = By.xpath("//span[@id='select2-PO-container']");
	public static final By clickingPurchaseGroup = By.xpath("//*[@id='select2-Purchase-container']");
    public static final By ClickingReasongroup = By.xpath("//span[@id='select2-Reason-container']"); 	
	public static final By clickingSchedulingPotype = By.xpath("//span[@id='select2-One_Time_PO-container']");
	public static final By ClickingStoragelocation = By.xpath("//span[@id='select2-StorageLocation-container']");
	public static final By EnterIncoTerms = By.xpath("//input[@id='IncoTermLocation']");
	public static final By EnterPoEndDate = By.xpath("//input[@id='POEndDate']");
	public static final By EnterDeliveryDate = By.xpath("//input[@id='DeliveryDate']");
	public static final By EnterPaymentTeamHeaderText = By.xpath("//input[@id='PaymentTermHeaderText']");
	public static final By EnterItemHeaderText = By.xpath("//input[@id='ItemHeaderText']");
	public static final By EnterPoHeaderForSupplier = By.xpath("//input[@id='POHeaderforSupplier']");

	public static final By CompanyNamelistofDropdown = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
	public static final By CompanyNameCheckboxes = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");
	public static final By CusotmerNameListofDropdown = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
	public static final By CustomerNameCheckboxes = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");
	public static final By ProductModelNameList = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
	public static final By ProductModelNameCheckboxList = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");

	public static final By SegmentNameList = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
	public static final By segmentlistcheckbox = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");

	public static final By SupplierNameList = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
	public static final By supplierCheckbocList = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");

	public static final By PartWiseBomWiseOptionValue = By.xpath("//select[@id='ddlPartWiseBOMwise']/option");

	public static final By listPartnumbercheckboxes = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/following-sibling::button/span/input");

	public static final By clickingCommodityGroupDropdown = By.xpath("//select[@id='comdrop']/following-sibling::div/button");

	public static final By CommodityGroupNamelist = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
	public static final By CommodityGroupCheckboxList = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");

	public static final By ClickingGrpClassification = By.xpath("//select[@id='subComdrop']/following-sibling::div/button");
	public static final By groupclassificationlist = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
    public static final By classificationcheckboxlist = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");	

    public static final By clickingGradeDropdown = By.xpath("//select[@id='gradedrop']/following-sibling::div/button");
    public static final By clickingGradeNameList= By.xpath("//div[@class='multiselect-container dropdown-menu show']/button");
    public static final By clickinggradecheckboxlist = By.xpath("//div[@class='multiselect-container dropdown-menu show']/button/span/input");

    public static final By clickingyeardropdown = By.xpath("//select[@id='Year']/following-sibling::span/span/span/span[@id='select2-Year-container']");
    public static final By yearListvalue = By.xpath("//ul[@id='select2-Year-results']/li");

    public static final By clickingperiodDropdown = By.xpath("//span[@id='select2-supMonth-container']");
    public static final By periodDroplistvalue = By.xpath("//ul[@id='select2-supMonth-results']/li");
    public static final By ClickingIncoContaineDropdown = By.xpath("//span[@id='select2-Inco-container']");
    public static final By IncoCotainerDropdownlistvalue = By.xpath("//ul[@id='select2-Inco-results']/li");
    public static final By ClickingPaymentTerm = By.xpath("//span[@id='select2-Payment-container']");
    public static final By paymenttermdropdownlist = By.xpath("//ul[@id='select2-Payment-results']/li");
    public static final By clickingPoTypeDropdown = By.xpath("//span[@id='select2-PO-container']");
    public static final By PoTypeDropdownValue = By.xpath("//ul[@id='select2-PO-results']/li");
    public static final By clickingpurchasegroupDropdown = By.xpath("//span[@id='select2-Purchase-container']");
    public static final By purchasegroupvalue = By.xpath("//ul[@id='select2-Purchase-results']/li");
    public static final By clickingReasonGroupdropdown = By.xpath("//span[@id='select2-Reason-container']");
    public static final By Reasongroupdropdownvalue = By.xpath("//ul[@id='select2-Reason-results']/li");    
    public static final By clickingscheduingPotypeDropdown = By.xpath("//span[@id='select2-One_Time_PO-container']");
    public static final By valueschedulingpotype = By.xpath("//ul[@id='select2-One_Time_PO-results']//li");
    public static final By clickingStorageLocationDropdown = By.xpath("//span[@id='select2-StorageLocation-container']");
    public static final By valuesOfStorageLocation = By.xpath("//ul[@id='select2-StorageLocation-results']/li");

    public static final By clickingViewButton = By.xpath("//button[@id='tab2Save']");
    public static final By clickingyesbutton = By.xpath("//button[@id='SendPCCApi']");
    public static final By clickingApprovalnameDropdown = By.xpath("//select[@id='Approval']");
    public static final By valuesOfApprovalnanme = By.xpath("//select[@id='Approval']/option");
    public static final By clickingfinalSubmit = By.xpath("//button[@id='btnsubmit']");

		public static final By clickingdatabaseofPartnumber = By.xpath("(//button[@id='pvc1']/i)[1]");
		 public static final By clickingSubmitButton = By.xpath("//button[@id='SubmitPartNoForAllModule']/i");
		 public static final By partNumberInputBox = By.xpath("//textarea[@id='SelectedPartNoForAllModule']");
 
	 public static final By clickingopendPriceApproval = By.xpath("//li[@class='slide has-sub open']/a/span[contains(text(),'Price Approvals')]");
	 public static final By clickingPccOption = By.xpath("//li[@class='slide has-sub active open']/a[normalize-space()='PCC']");
	 public static final By clickingheaderForRefresh = By.xpath("//aside[@id='sidebar']/div/a/div[@class='desktop-logo']");
		
	 public static final By clickingResetButton = By.xpath("//button[@onclick='resetdataSupp()']");
	 
	 public static final By clickingCrossButton = By.xpath("//*[@id='page-top']/div[3]/div[1]/div/div[11]/div/div/div[3]/button");
	 public void searchPartNumberInDatabaseAndSubmit() throws InterruptedException {
			    LoggerUtil.info(" Clicking View button...");
			    clickOnElement(clickingViewButton);
			    Thread.sleep(2000);
 
			    LoggerUtil.info("✔ Clicking Yes to confirm View...");
			    clickOnElement(clickingyesbutton);
			    Thread.sleep(3000);
 
			 			    
			    Thread.sleep(3000);
			    clickOnElement(clickingApprovalnameDropdown);
			    Thread.sleep(2000);
			    List<WebElement> approvallistvalue = driver.findElements(valuesOfApprovalnanme);
			    selectBootStrapDropDown(approvallistvalue, "CBC");
			    Thread.sleep(4000);
			    clickOnElement(clickingfinalSubmit);
			    Thread.sleep(4000);
			    clickOnElement(clickingCrossButton);
			    Thread.sleep(20000);
				clickOnElement(clickingResetButton);
				
				
				
				
				
			    
				}
	 
		
		
		
		
		
		
	    public void clickWithFallback(WebElement element, String type, String value) {
	        try {
	            element.click();
	            LoggerUtil.pass("✅ " + type + " selected: " + value);
	        } catch (Exception e) {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", element);
	            LoggerUtil.pass("✅ " + type + " selected with JS click: " + value);
	        }
	    }
	 
	    public void selectSingleWithLabel(List<WebElement> labels, List<WebElement> checkboxes, String matchText, String labelType) {
	        for (int i = 0; i < labels.size(); i++) {
	            if (labels.get(i).getText().trim().equalsIgnoreCase(matchText)) {
	                clickWithFallback(checkboxes.get(i), labelType, matchText);
	                break;
	            }
	        }
	    }
	 
	 
		
		
	    public void safeSelectMenu(String menuName) {
		    int retries = 3;
		    for (int i = 0; i < retries; i++) {
		        try {
		            LoggerUtil.info("🔄 Trying to click menu: " + menuName + " (Attempt " + (i + 1) + ")");
		            dashboard.selectMenuFormDashBoard(menuName);
		            LoggerUtil.pass("✅ Menu found and clicked: " + menuName);
		            return;
		        } catch (Exception e) {
		            LoggerUtil.error("❌ Failed to click menu on attempt " + (i + 1) + ": " + e.getMessage());
		            try {
		                Thread.sleep(3000); // wait before retry
		            } catch (InterruptedException ie) {
		                Thread.currentThread().interrupt();
		            }
		        }
		    }
		    LoggerUtil.fail("🚫 Could not find menu: " + menuName + " after " + retries + " attempts.");
		}
		
	    
	    public void onlyChangePartNumber(String partNumber) throws InterruptedException {
	        clickOnElement(clickingdatabaseofPartnumber);
	        Thread.sleep(3000);

	        LoggerUtil.info("✏️ Changing Part Number to: " + partNumber);
	        clearAndEnterText(waitForExpectedElement(partNumberInputBox), partNumber);
	        Thread.sleep(2000);

	        LoggerUtil.info("📤 Clicking Submit button...");
	        clickOnElement(clickingSubmitButton);
	        Thread.sleep(15000);
	    }

	 
			
	    String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			public static final By clickingSupplierDataBase = By.xpath("//button[@formnovalidate='formnovalidate' and @data-bs-original-title='Supplier Selection']");
			public static final By EnterSuppliername = By.xpath("//textarea[@id='SelectedSuppliersForAllModule']");
	        public static final By ClickingSubmitbuttonSupplier = By.xpath("//button[@id='SubmitSuppliersnameForAllModule']");
			
			public void reselectAllMandatoryDropdowns() throws InterruptedException {
	    	
	    	Thread.sleep(5000);
	    	 WaitForElementClickable(ClickingCompanyDropdown, 30); // Explicit wait up to 30 sec
	 
	    	    Thread.sleep(1000); // Optional buffer
	    	    clickOnElement(ClickingCompanyDropdown);
	        
	        Thread.sleep(3000);
	        List<WebElement> companies = driver.findElements(CompanyNamelistofDropdown);
	        List<WebElement> companyCheckboxes = driver.findElements(CompanyNameCheckboxes);
	        for (int i = 0; i < companies.size(); i++) {
	            if (companies.get(i).getAttribute("title").trim().equals("EDC-Pune")) {
	                clickWithFallback(companyCheckboxes.get(i), "Company", "EDC-Pune");
	                break;
	            }
	        }
	 
	        // Customer
	        Thread.sleep(5000);
	        clickOnElement(ClickingCustomerDropdown);
	        Thread.sleep(4000);
	        List<WebElement> customers = driver.findElements(CusotmerNameListofDropdown);
	        List<WebElement> customerCheckboxes = driver.findElements(CustomerNameCheckboxes);
	        for (int i = 0; i < customers.size(); i++) {
	            if (customers.get(i).getAttribute("title").trim().equals("CAAS-100 Parts-01-Mohali")) {
	                clickWithFallback(customerCheckboxes.get(i), "Customer", "CAAS-100 Parts-01-Mohali");
	                break;
	            }
	        }
	 
	        // Product Model
	        Thread.sleep(5000);
	        clickOnElement(ClickingProductModelNumber);
	        Thread.sleep(4000);
	        List<WebElement> modelNames = driver.findElements(ProductModelNameList);
	        List<WebElement> modelCheckboxes = driver.findElements(ProductModelNameCheckboxList);
	        for (int i = 0; i < modelNames.size(); i++) {
	            if (modelNames.get(i).getAttribute("title").trim().equals("Honda-12348")) {
	                modelCheckboxes.get(i).click();
	                break;
	            }
	        }
	 
	        // Segment
	        Thread.sleep(5000);
	        clickOnElement(ClickingSegMentDropdown);
	        Thread.sleep(3000);
	        List<WebElement> segmentNames = driver.findElements(SegmentNameList);
	        List<WebElement> segmentCheckboxes = driver.findElements(segmentlistcheckbox);
	        for (int i = 0; i < segmentNames.size(); i++) {
	            if (segmentNames.get(i).getAttribute("title").trim().equals("Select all")) {
	                segmentCheckboxes.get(i).click();
	                break;
	            }
	        }
	 
	        Thread.sleep(7000);
	       
	       clickOnElement(clickingSupplierDataBase);
	       Thread.sleep(2000);
	 
	       clearAndEnterText(waitForExpectedElement(EnterSuppliername), "EDC-Supplier-0808");
	        Thread.sleep(2000);
	        clickOnElement(ClickingSubmitbuttonSupplier);
	        
	        
	        
	 
	        Thread.sleep(5000);
	        // Part Wise
	        clickOnElement(clickingPartWiseBomWise);
	        Thread.sleep(3000);
	        selectBootStrapDropDown(driver.findElements(PartWiseBomWiseOptionValue), "Part Wise");
	        
	       
	 
	        Thread.sleep(5000);
	        // Effective Dates
	        clearAndEnterText(waitForExpectedElement(EnterEffectiveStartDate), todayDate);
	        Thread.sleep(3000);
	     // Get the Effective End Date input field element
	        WebElement endDateInput = waitForExpectedElement(EnetrEffectiveEndDate);
	 
	        // Get tomorrow's date and format it as 'yyyy-MM-dd' (required format for <input type="date">)
	        String tomorrowDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	 
	        // Use JavaScript to set the value of the input field (bypassing browser UI)
	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView(true);" +  // Scroll the element into view
	            "arguments[0].removeAttribute('readonly');" +  // Remove readonly if set
	            "arguments[0].setAttribute('value', '" + tomorrowDate + "');" +  // Set the date value
	            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +  // Trigger input event
	            "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",  // Trigger change event
	            endDateInput);  // Apply the script to the endDateInput element
	 
	        LoggerUtil.info("📅 Set Effective End Date via JS: " + tomorrowDate);
	 
	 
	 
	        Thread.sleep(5000);
	        // RM Checkbox
	        clickOnElement(clickingRmCheckbox);
	 
	        Thread.sleep(5000);
	        // Commodity Group
	        clickOnElement(clickingCommodityGroupDropdown);
	        selectSingleWithLabel(driver.findElements(CommodityGroupNamelist), driver.findElements(CommodityGroupCheckboxList), "Select all", "Commodity Group");
	 
	        Thread.sleep(5000);
	        // Group Classification
	        clickOnElement(ClickingGrpClassification);
	        selectSingleWithLabel(driver.findElements(groupclassificationlist), driver.findElements(classificationcheckboxlist), "Select all", "Group Classification");
	 
	        Thread.sleep(5000);
	        // Grade
	        clickOnElement(clickingGradeDropdown);
	        selectSingleWithLabel(driver.findElements(clickingGradeNameList), driver.findElements(clickinggradecheckboxlist), "Select all", "Grade");
	 
	        Thread.sleep(5000);
	        // Year
	        clickOnElement(clickingyeardropdown);
	        selectBootStrapDropDown(driver.findElements(yearListvalue), "2024-2025");
	 
	        Thread.sleep(5000);
	        // Period
	        clickOnElement(clickingperiodDropdown);
	        selectBootStrapDropDown(driver.findElements(periodDroplistvalue), "May");
	 
	        Thread.sleep(5000);
	        // Inco
	        clickOnElement(ClickingIncoContaineDropdown);
	        selectBootStrapDropDown(driver.findElements(IncoCotainerDropdownlistvalue), "0001-CAAS");
	 
	        Thread.sleep(5000);
	        // Payment Term
	        clickOnElement(ClickingPaymentTerm);
	        selectBootStrapDropDown(driver.findElements(paymenttermdropdownlist), "3-CAAS-2");
	 
	        Thread.sleep(5000);
	        // PO Type
	        clickOnElement(clickingPoTypeDropdown);
	        selectBootStrapDropDown(driver.findElements(PoTypeDropdownValue), "2-CAAS-1");
	 
	        Thread.sleep(5000);
	        // Purchase Group
	        clickOnElement(clickingpurchasegroupDropdown);
	        selectBootStrapDropDown(driver.findElements(purchasegroupvalue), "4-CAAS-3");
	 
	        Thread.sleep(5000);
	        // Reason Group
	        clickOnElement(clickingReasonGroupdropdown);
	        selectBootStrapDropDown(driver.findElements(Reasongroupdropdownvalue), "5-CAAS-4");
	 
	        Thread.sleep(5000);
	        // Scheduling PO Type
	        clickOnElement(clickingscheduingPotypeDropdown);
	        selectBootStrapDropDown(driver.findElements(valueschedulingpotype), "One time PO");
	 
	        Thread.sleep(3000);
	        // Storage Location
	        clickOnElement(clickingStorageLocationDropdown);
	        selectBootStrapDropDown(driver.findElements(valuesOfStorageLocation), "CAAS-6");
	 
	        LoggerUtil.info("✅ All dropdowns reselected.");
	        
	     
	        
	        
	        
	        
	    }
	 
	 
			
			
			
			
			public void setEffectiveEndDate() {
			    // Get today's date in 'yyyy-MM-dd' format
			    String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			    
			    // If you want the next day's date:
			    String tomorrowDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	 
			    // Get the date input field
			    WebElement endDateInput = waitForExpectedElement(By.id("Effective_End_date"));
			    
			    // Use JavaScript to set the value of the date input
			    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + tomorrowDate + "';", endDateInput);
	 
			    LoggerUtil.info("📅 Set Effective End Date via JS: " + tomorrowDate);
			}
		
		
		
		
		
		
		
		
	}
	 