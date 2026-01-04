package com.Pages;

import java.beans.Visibility;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.Ansi.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.helper.Base;
import com.helper.LoggerUtil;

public class PoojaCastingPage extends Base {
	
	static Faker faker = new Faker();
	
	public static final String randomCustomerName = faker.letterify("???????");
	   public static String effectivedatefrommail;
	  public static String customermailname;
	  public static String entercustname ;
	static SoftAssert soft = new SoftAssert();
	DashboardPage dashboard = new DashboardPage();
	LoginPage login = new LoginPage();
	
	
	
	public static final By searchinputforshape = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By entercommdoitygroupInAddCommodity = By.xpath("//*[@id='commodityGroup']");
	public static final By savebuttonaddcommodity = By.xpath("//*[@id='tab1Save']");
	public static final By entersearchbarvalue = By.xpath("//*[@id='commodtiyTable_filter']/label/input");
	public static final By fetchingdatainaddcommoditygrp = By.xpath("//*[@id='commodtiyTable']/tbody/tr/td[2]");
	public static final By clickEditbtnOnaddcommodity = By.xpath("//*[@id='commodtiyTable']/tbody/tr[1]/td[3]/a[1]");
	public static final By saveAsnewbtn = By.xpath("//*[@id='tab1SaveAsNew']");
	public static final By updatebtnaddcommodity = By.xpath("//*[@id='tab1Save']");
	public static final By deletebtnofAddcommodity = By.xpath("//*[@id='commodtiyTable']/tbody/tr/td[3]/a[2]/i");

	public void saveaddcommdoity(String entreaddcommodityname, String entervalueforsaveasnew,
			String entervalueforupdated) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), entreaddcommodityname);
		Thread.sleep(2000);
		clickOnElement(savebuttonaddcommodity);
		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(entersearchbarvalue), entreaddcommodityname);
		Thread.sleep(7000);
		try {
			String actualvalue = waitForExpectedElement(fetchingdatainaddcommoditygrp).getText();
			String expectedvalue = entreaddcommodityname;
			Assert.assertEquals(actualvalue, expectedvalue);
			LoggerUtil.info("Expected Value Of AddCommodity is = " + entreaddcommodityname
					+ " And The Actual Value Of AddCommodity Is = " + actualvalue);
			clickOnElement(clickEditbtnOnaddcommodity);
			Thread.sleep(5000);
			clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), entervalueforsaveasnew);
			Thread.sleep(5000);
			clickOnElement(saveAsnewbtn);
			Thread.sleep(5000);
			clearAndEnterText(waitForExpectedElement(entersearchbarvalue), entervalueforsaveasnew);
			Thread.sleep(5000);
			clickOnElement(clickEditbtnOnaddcommodity);
			clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), entervalueforupdated);
			Thread.sleep(5000);
			clickOnElement(updatebtnaddcommodity);
			clearAndEnterText(waitForExpectedElement(entersearchbarvalue), entervalueforupdated);

			Thread.sleep(5000);
			String actualvalueforupdated = waitForExpectedElement(fetchingdatainaddcommoditygrp).getText();
			soft.assertEquals(actualvalueforupdated, entervalueforupdated);
			Thread.sleep(5000);
			clickOnElement(deletebtnofAddcommodity);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);

		} catch (Exception e) {
			LoggerUtil.mismatch("Add Commodity Value is mismatched.....");
			e.getMessage();

		}

	}

	public void savedatawithoutcommoditygrp() {

		try {

			Base.WaitForElementClickable(savebuttonaddcommodity, 15);
		} catch (Exception e) {

			LoggerUtil.info("Error while waiting for element to be clickable: " + e.getMessage());
		}

		try {

			clickOnElement(savebuttonaddcommodity);
			LoggerUtil.info("user Clicking Save Button Without Entering The Value In Commoditygroupfield ");
		} catch (Exception e) {

			LoggerUtil.info("Error while clicking the element: " + e.getMessage());
		}
	}
		
	
	public void Savedatawithpooja(String enteraddcomvalue) {
		
		try {
		clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), enteraddcomvalue);
		Thread.sleep(2000);
		clickOnElement(savebuttonaddcommodity);
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			LoggerUtil.info("Error While Clicking Save Button In Add Commodity = " +e.getMessage());
		}
	}
	
	
public static final By savebtncommoditygrp = By.xpath("//*[@id='tab2Save']");	
public static final By secomdtabclickcommoditydropdown = By.xpath("//*[@id='select2-commodityDropdown-container']");	
public static final By fetchingcommoditydropdownsecondtab = By.xpath("//ul[@id='select2-commodityDropdown-results']/li");	
public static final By entergrpclassificationvaluesecontab = By.xpath("//*[@id='subGroupClassification']");	
public static final By enterspecificgradevaluesecondtab = By.xpath("//*[@id='SpecificGradeText']");
public static final By enterdensityvaluesecondtab = By.xpath("//*[@id='groupDensity']");
	public void secondtabsavewithpooja() throws InterruptedException {
		
		clickOnElement(secomdtabclickcommoditydropdown);
		
		List<WebElement> comdropvalue = driver.findElements(fetchingcommoditydropdownsecondtab);
		
		for(WebElement comdroplist:comdropvalue) {
			
			String comvalue = comdroplist.getText().trim();
			if(comvalue.equalsIgnoreCase("Alloys")) {	
				comdroplist.click();
				break;
				
			}
			
		}
		
		clearAndEnterText(waitForExpectedElement(entergrpclassificationvaluesecontab), "Aluminium");
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(enterspecificgradevaluesecondtab), "Alsi9Cu3");
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(enterdensityvaluesecondtab), "2.75");
		Thread.sleep(2000);
		clickOnElement(savebtncommoditygrp);
		Thread.sleep(4000);
		
		
	}
   		
		public static final By thirdtabcomgrp = By.xpath("//*[@id='select2-commodityDrop-container']");
		public static final By thirtabclassification = By.xpath("//*[@id='select2-materialDrop-container']");
		public static final By thirdtabspecificgrade = By.xpath("//*[@id='select2-SpecificGrade-container']");
		public static final By thirduomdropdown = By.xpath("//*[@id='select2-uomDrop-container']");
		public static final By thirdtabshapedropdown = By.xpath("//*[@id='select2-shapeDrop-container']");
		public static final By yearlydropdownbox = By.xpath("//*[@id='select2-Year-container']");
		public static final By customercheckbox = By.xpath("//table[@id='rmCustomer']/tbody/tr[2]/td/div/label/input");
		public static  final By savecomdetail = By.xpath("//*[@id='tab3Save']");
		public static final By thirdtabviewbtn = By.xpath("//*[@id='CommodityDetailTab']/div[1]/div[2]/div/div/div/button[4]");
		public static final By thirdtabclickonsearchfilter = By.xpath("//*[@id='CommodityDetailTab']/div[2]/div/div/div[2]/div[2]/i");
		public static final By thirdtabcommoditygroupclickonseachfiltercheckbox = By.xpath("//input[@type='checkbox' and @value='CommodityGroup' or  @data-column='2']");
	    public static final By thirdtabentersearchvalue = By.xpath("//input[@id='myInputListSearch']");
	    public static final By clickeditbtn = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[2]/a[1]/i");
	    public static final By yearlyradiobtn = By.xpath("//*[@id='yearlyR']");
		public void Thirdtabsavewithpooja(String entercustcode, String  entercustname) throws InterruptedException {

			
			
			 LoggerUtil.info("User Click The Add customer Button...");
			  clickOnElement(addcustomerbtn);
			  Thread.sleep(4000);
			  clearAndEnterText(waitForExpectedElement(entercustomercodevalue), entercustcode);
			  Thread.sleep(4000);
			  clearAndEnterText(waitForExpectedElement(entercustomernamevalue), entercustname);
			  LoggerUtil.info("User Enter The customer Name = "+ entercustname);
			  Thread.sleep(4000);
			  clearAndEnterText(waitForExpectedElement(customerlocation), "mohali");
			  Thread.sleep(3000);
			  clickOnElement(clickbusinessSegmentdrop);
			  Thread.sleep(4000);
			  clickOnElement(checkboxbusinessSegment);
			  Thread.sleep(3000);
			  clickOnElement(clicksavebtncustomer);  
			  Thread.sleep(3000);
			  clickOnElement(clickcrossbtn);
			  Thread.sleep(8000);
			  clearAndEnterText(waitForExpectedElement(searchccusotmer),entercustcode);
			  Thread.sleep(6000);
			  clickOnElement(clickcustomercheckboxfordomestic);
			
			Thread.sleep(3000);
			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
			clickOnElement(thirdtabcomgrp);
			
			List<WebElement> comgrplist = driver.findElements(By.xpath("//ul[@id='select2-commodityDrop-results']/li"));
           
			for (int i = 1; i < comgrplist.size(); i++) {
				
				String text = comgrplist.get(i).getText().trim();
				
				System.out.println("Id " + (i + 1) + "  : " + text);

				if (text.equals("Alloys")) {
					comgrplist.get(i).click();
					LoggerUtil.info("User Click Alloys Sucessfully = Alloys ");
					break; 
					
				}
				
			}

			LoggerUtil.info("Total Number of Dropdown Values = " + comgrplist.size());
			Thread.sleep(7000);
			clickOnElement(thirtabclassification);
			LoggerUtil.info("User Click The Group classification in third tab");
			Thread.sleep(2000);
			
			List<WebElement> classificationlist = driver.findElements(By.xpath("//ul[@id='select2-materialDrop-results']/li"));
			
			for(WebElement classficationvalue:classificationlist){
				String flagvalue = classficationvalue.getText().trim();
				if(flagvalue.equalsIgnoreCase("Aluminium")) {
					
					classficationvalue.click();
					LoggerUtil.info("User Select The Classification Value = Aluminium");
					break;
				}
				
			}
			LoggerUtil.info("Total number of Dropdown value is = "+classificationlist.size());
			Thread.sleep(7000);
			clickOnElement(thirdtabspecificgrade);
			LoggerUtil.info("User Click The Specific group dropdown in third tab");
			List<WebElement> gradelsit = driver.findElements(By.xpath("//ul[@id='select2-SpecificGrade-results']/li"));
			for(WebElement gradedropvalue:gradelsit) {
				
				String flaggrade= gradedropvalue.getText().trim();
				if(flaggrade.equalsIgnoreCase("Alsi9Cu3")) {
					
					gradedropvalue.click();
					LoggerUtil.info("User click dropdown value = Alsi9Cu3");
					break;
				}
				
			}
			LoggerUtil.info("Total Number of Drodown Value is = "+ gradelsit.size());
			
			Thread.sleep(7000);

			
			clickOnElement(thirduomdropdown);
			LoggerUtil.info("User click The Third tab Drop-Down Value ");
			Thread.sleep(6000);
			
			List<WebElement> uomlist = driver.findElements(By.xpath("//ul[@id='select2-uomDrop-results']/li"));
			
			for(int i =1;i<uomlist.size();i++) {
				
				String t = uomlist.get(i).getText().trim();
				
				if(t.equalsIgnoreCase("Kg")) {
					
					uomlist.get(i).click();
					LoggerUtil.info("User Clicked The kg In Uom Dropdown Value");
					break;
				}
				
			}
			LoggerUtil.info("Total Number Of Dropdown Value is = " +uomlist.size());
			
			Thread.sleep(4000);
			clickOnElement(thirdtabshapedropdown);
			LoggerUtil.info("User Clicked the Shape Dropdown");
			Thread.sleep(1000);

			// Type "Misc." in the search box
			 WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			    clearAndEnterText(shapesearch, "Misc.");
			    shapesearch.sendKeys(Keys.ENTER);
			    LoggerUtil.info("Entered Shape as: Misc.");
			    Thread.sleep(5000);
			

			Thread.sleep(7000);
			clickOnElement(yearlydropdownbox);
			Thread.sleep(4000);
			LoggerUtil.info("User Click The Yearly Dropdown List To Select The year..... ");
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-Year-results']/li")));
			
			List<WebElement> yearlist = driver.findElements(By.xpath("//ul[@id='select2-Year-results']/li"));
			int i =0;
			for(WebElement yearvalues: yearlist) {
				
				String flagyear = yearvalues.getText().trim();
				
				System.out.println("id :"+ (i+1)+":"+flagyear);
				
				i++;
				
				if(flagyear.equals("2025-2026")) {
					
					yearvalues.click();
					LoggerUtil.info("User Click The 2025-2026 in year dropdown");
					break;
					
				}
				
			}
			LoggerUtil.info("Total Number of The year dropdown Is = " + yearlist.size() );
			Thread.sleep(3000);
			
			clickOnElement(savecomdetail);
			Thread.sleep(3000);
			clickOnElement(thirdtabviewbtn);
			Thread.sleep(7000);
			clearAndEnterText(waitForExpectedElement(thirdtabentersearchvalue), entercustname);
			Thread.sleep(6000);
			clickOnElement(clickeditbtn);
			Thread.sleep(10000);
		    boolean yearradiobtnselected = waitForExpectedElement(yearlyradiobtn).isSelected();
		    
		    if(yearradiobtnselected) {
		    	LoggerUtil.pass(" yearly Radio Button Selected After Clicking Edit Button");
		    }
		    else
		    {
		    	LoggerUtil.error("Radio Button is not Selected...");
		    	
		    }
		}
			
		
		
		
		
		
		public void secondtabsavewithpoojaForL_M_6() throws InterruptedException {
			
			clickOnElement(secomdtabclickcommoditydropdown);
			
			List<WebElement> comdropvalue = driver.findElements(fetchingcommoditydropdownsecondtab);
			
			for(WebElement comdroplist:comdropvalue) {
				
				String comvalue = comdroplist.getText().trim();
				if(comvalue.equalsIgnoreCase("Alloys")) {	
					comdroplist.click();
					break;
					
				}
				
			}
			
			clearAndEnterText(waitForExpectedElement(entergrpclassificationvaluesecontab), "Aluminium");
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(enterspecificgradevaluesecondtab), "LM6/25@pooja");
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(enterdensityvaluesecondtab), "2.75");
			Thread.sleep(2000);
			clickOnElement(savebtncommoditygrp);
			Thread.sleep(4000);
			
			
		}
		
		
		public void ThirdtabsavewithpoojaForL_M_6(String entercustcode,String entercustname) throws InterruptedException {

			
			 LoggerUtil.info("User Click The Add customer Button...");
			  clickOnElement(addcustomerbtn);
			  Thread.sleep(4000);
			  clearAndEnterText(waitForExpectedElement(entercustomercodevalue), entercustcode);
			  Thread.sleep(4000);
			  clearAndEnterText(waitForExpectedElement(entercustomernamevalue), entercustname);
			  LoggerUtil.info("User Enter The customer Name = "+ entercustname);
			  Thread.sleep(4000);
			  clearAndEnterText(waitForExpectedElement(customerlocation), "mohali");
			  Thread.sleep(3000);
			  clickOnElement(clickbusinessSegmentdrop);
			  Thread.sleep(4000);
			  clickOnElement(checkboxbusinessSegment);
			  Thread.sleep(3000);
			  clickOnElement(clicksavebtncustomer);  
			  Thread.sleep(3000);
			  clickOnElement(clickcrossbtn);
			  Thread.sleep(8000);
			  clearAndEnterText(waitForExpectedElement(searchccusotmer),entercustcode);
			  Thread.sleep(6000);
			  clickOnElement(clickcustomercheckboxfordomestic);
			
			Thread.sleep(3000);
			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
			
			clickOnElement(thirdtabcomgrp);
			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
			List<WebElement> comgrplist = driver.findElements(By.xpath("//ul[@id='select2-commodityDrop-results']/li"));
           
			for (int i = 1; i < comgrplist.size(); i++) {
				
				String text = comgrplist.get(i).getText().trim();
				
				System.out.println("Id " + (i + 1) + "  : " + text);

				if (text.equals("Alloys")) {
					comgrplist.get(i).click();
					LoggerUtil.info("User Click Alloys Sucessfully = Alloys ");
					break; 
					
				}
				
			}

			LoggerUtil.info("Total Number of Dropdown Values = " + comgrplist.size());
			Thread.sleep(7000);
			clickOnElement(thirtabclassification);
			LoggerUtil.info("User Click The Group classification in third tab");
			Thread.sleep(2000);
			
			List<WebElement> classificationlist = driver.findElements(By.xpath("//ul[@id='select2-materialDrop-results']/li"));
			
			for(WebElement classficationvalue:classificationlist){
				String flagvalue = classficationvalue.getText().trim();
				if(flagvalue.equalsIgnoreCase("Aluminium")) {
					
					classficationvalue.click();
					LoggerUtil.info("User Select The Classification Value = Aluminium");
					break;
				}
				
			}
			LoggerUtil.info("Total number of Dropdown value is = "+classificationlist.size());
			Thread.sleep(7000);
			clickOnElement(thirdtabspecificgrade);
			LoggerUtil.info("User Click The Specific group dropdown in third tab");
			List<WebElement> gradelsit = driver.findElements(By.xpath("//ul[@id='select2-SpecificGrade-results']/li"));
			for(WebElement gradedropvalue:gradelsit) {
				
				String flaggrade= gradedropvalue.getText().trim();
				if(flaggrade.equalsIgnoreCase("LM6/25@pooja")) {
					
					gradedropvalue.click();
					LoggerUtil.info("User click dropdown value = LM6/25@pooja");
					break;
				}
				
			}
			LoggerUtil.info("Total Number of Drodown Value is = "+ gradelsit.size());
			
			Thread.sleep(7000);
			
			
			
			clickOnElement(thirduomdropdown);
			LoggerUtil.info("User click The Third tab Drop-Down Value ");
			Thread.sleep(6000);
			
			List<WebElement> uomlist = driver.findElements(By.xpath("//ul[@id='select2-uomDrop-results']/li"));
			
			for(int i =1;i<uomlist.size();i++) {
				
				String t = uomlist.get(i).getText().trim();
				
				if(t.equalsIgnoreCase("Kg")) {
					
					uomlist.get(i).click();
					LoggerUtil.info("User Clicked The kg In Uom Dropdown Value");
					break;
				}
				
			}
			LoggerUtil.info("Total Number Of Dropdown Value is = " +uomlist.size());
			
			Thread.sleep(7000);
			
			// Wait for all dropdown options to be loaded
			Thread.sleep(4000);
			clickOnElement(thirdtabshapedropdown);
			LoggerUtil.info("User Clicked the Shape Dropdown");
			Thread.sleep(1000);

			// Type "Misc." in the search box
			 WebElement shapesearch = waitForExpectedElement(searchinputforshape);
			    clearAndEnterText(shapesearch, "Misc.");
			    shapesearch.sendKeys(Keys.ENTER);
			    LoggerUtil.info("Entered Shape as: Misc.");
			    Thread.sleep(5000);
			
			

			
			
			Thread.sleep(7000);
			clickOnElement(yearlydropdownbox);
			Thread.sleep(7000);
			LoggerUtil.info("User Click The Yearly Dropdown List To Select The year..... ");
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='select2-Year-results']/li")));
			List<WebElement> yearlist = driver.findElements(By.xpath("//ul[@id='select2-Year-results']/li"));
			int i =0;
			for(WebElement yearvalues: yearlist) {
				
				String flagyear = yearvalues.getText().trim();
				
				System.out.println("id :"+ (i+1)+":"+flagyear);
				
				i++;
				
				if(flagyear.equals("2025-2026")) {
					
					yearvalues.click();
					LoggerUtil.info("User Click The 2025-2026 in year dropdown");
					break;
					
				}
				
			}
			LoggerUtil.info("Total Number of The year dropdown Is = " + yearlist.size() );
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			clickOnElement(savecomdetail);
			Thread.sleep(3000);
			clickOnElement(thirdtabviewbtn);
			Thread.sleep(7000);
			clearAndEnterText(waitForExpectedElement(thirdtabentersearchvalue), entercustname);
			Thread.sleep(6000);
			clickOnElement(clickeditbtn);
			Thread.sleep(6000);
		    boolean yearradiobtnselected = waitForExpectedElement(yearlyradiobtn).isSelected();
		    
		    if(yearradiobtnselected) {
		    	LoggerUtil.pass(" yearly Radio Button Selected After Clicking Edit Button");
		    }
		    else
		    {
		    	LoggerUtil.error("Radio Button is not Selected...");
		    	
		    }
		}
		

		
		public void SavedatawithpoojaForL_M6(String enteraddcomvalue) {
			
			try {
			clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), enteraddcomvalue);
			Thread.sleep(2000);
			clickOnElement(savebuttonaddcommodity);
			Thread.sleep(2000);
			}
			catch(Exception e)
			{
				LoggerUtil.info("Error While Clicking Save Button In Add Commodity = " +e.getMessage());
			}
		}
		
		
		
		
		
		
			
		public void savefirttabwithdomestic(String enterfirtstabvalueforcommodity) throws InterruptedException {
			
			clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), enterfirtstabvalueforcommodity);
			Thread.sleep(3000);
			clickOnElement(savebuttonaddcommodity);
			
			
		}

	   public static final By entersearchvalueforcommgrptab = By.xpath("//*[@id='SubGroupTable_filter']/label/input");	
       public void savesecondtabfordomestic() throws InterruptedException {
    	   
    	   Thread.sleep(5000);
    	   
    	   clickOnElement(secomdtabclickcommoditydropdown);
    	   
    	   Thread.sleep(7000);
    	   
    	   List<WebElement> comdropvalue = driver.findElements(fetchingcommoditydropdownsecondtab);
   		
   		for(WebElement comdroplist:comdropvalue) {
   			
   			String comvalue = comdroplist.getText().trim();
   			if(comvalue.equalsIgnoreCase("Input material For Alloys")) {	
   				comdroplist.click();
   				break;
   				
   			}	
   		}
    	 LoggerUtil.info("Total Value of Second Tab in Commodity Dropdown  = " + comdropvalue.size());
   		 Thread.sleep(1999);
   		 clearAndEnterText(waitForExpectedElement(entergrpclassificationvaluesecontab), "Aluminum");
   		 LoggerUtil.info("User enter  The group classification value in second tab = " +"Aluminum");
   		 Thread.sleep(1999);
   		 clearAndEnterText(waitForExpectedElement(enterspecificgradevaluesecondtab), " Al");
   		 LoggerUtil.info("User enter The specificgrade value in second tab = " +"Al");
   		 Thread.sleep(1999);
   		 clearAndEnterText(waitForExpectedElement(enterdensityvaluesecondtab), "1");
   		LoggerUtil.info("User enter The density value in second tab = " +"1");
   		 Thread.sleep(1999);
         clickOnElement(savebtncommoditygrp);   		 
   		 Thread.sleep(7000);
   		 clearAndEnterText(waitForExpectedElement(entersearchvalueforcommgrptab), "Input material For Alloys");
   		
   		
       }
       public static final By addcustomerbtn = By.xpath("//*[@id='addNewCustomer']/span");
       public static final By entercustomercodevalue = By.xpath("//*[@id='CustomerCode']");
       public static final By entercustomernamevalue  = By.xpath("//*[@id='CustomerName']");
       public static final By clickbusinessSegmentdrop = By.xpath("//select[@id='BusinessSegments']/following-sibling::div/button/span");
       public static final By checkboxbusinessSegment = By.xpath("//select[@id='BusinessSegments']/following-sibling::div/div/button[2]/span/input[contains(@value,'5416') and starts-with (@id,'multiselect_')]");
       public static final By clicksavebtncustomer = By.xpath("//*[@id='customerSave1']");
       public static final By clickcrossbtn = By.xpath("//*[@id='addNewCustomerModel']/div/div/div[1]/button");
       public static final By searchccusotmer = By.xpath("//*[@id='myInputCustomer']");
       public static final By clickcustomercheckboxfordomestic = By.xpath("//table[@id='rmCustomer']/tbody/tr[not(contains(@style, 'display: none'))][1]//input[contains(@name,'custCheckbox')]\r\n"
       		+ "");
       public static final By thirdtabdomesticradiobtn = By.xpath("//*[@id='domesticR']");
       public static final By enterbasicCostprice = By.xpath("//*[@id='BasiccostD']");
       public static final By firststagefrieght = By.xpath("//*[@id='Fright1st']");
       public static final By conversioncast = By.xpath("//*[@id='ConversionCostD']");
       public static final By wastagepercantageonbasic = By.xpath("//*[@id='WastageD']");
       public static final By secodstagefrieghtcost = By.xpath("//*[@id='Fright2nd']");
       public static final By anyothercastfactorone = By.xpath("//*[@id='OtherCost1D']");
       public static final By anyothercostfactortwo = By.xpath("//*[@id='OtherCost2D']");
       public static final By subtotal = By.xpath("//*[@id='OtherCost2D']");
       public static final By addnewtax = By.xpath("//*[@id='taxDrop']");
       public static final By searchforaddnewtax= By.xpath("//*[@id='page-top']/span/span/span[1]/input");
       public static final By selectvalueforaddnewtax = By.xpath("//ul[@id='select2-taxDrop-results']/li");
       public static final By afterselectingGstTotalcast = By.xpath("//*[@id='txtTotalcost']");
       public static final By othercostfactor1 = By.xpath("//*[@id='txtOtherFactorCost1']");
       public static final By othercostfactor2 = By.xpath("//*[@id='txtOtherFactorCost2']");
       public static final By othercostfactor3 = By.xpath("//*[@id='txtOtherFactorCost3']");
       public static final By discountabsolute = By.xpath("//*[@id='txtDiscountAbsolute']");
       public static final By landedcost = By.xpath("//*[@id='landedCost']");
       public static final By subtotalafterenterotherfactorcost = By.xpath("//*[@id='txtSubTotal']");
       public static final By savebuttondetailstab = By.xpath("//*[@id='tab3Save']");
       public static final By entersearchvalue = By.xpath("//*[@id='myInputListSearch']");
       public static final By clickapprovaldropdown = By.xpath("//*[@id='ApprovalAlloy']");
       public static final By dropdownlistforRmapproval = By.xpath("//*[@id='ApprovalAlloy']/option");
       public static final By reasonforchange = By.xpath("//*[@id='TextAreaAlloy']");
       public static final By deviationvalue = By.xpath("//*[@id='TextAreaAlloy2']");
       public static final By entereffectivedate = By.xpath("//*[@id='EntryDatePoojaCasting']");
       public static final By clicksendkeys = By.xpath("//*[@id='WorlflowforPooja']/div[3]/button");
     
       public void SaveDataInThirdTabDomestic(String entercustcode,String entercustname,String enterbasicvalue,String enterfirststagefrieght,String enterconversioncost,String enterwastagecost,String entersecondstagefrieght,String enterothercostfactorone,String enterothercostfactortwo,String enterothercost1,String enterothercost2,String enterothercost3,String enterdiscountabsolute,String enetrsearchcustomer) throws InterruptedException {
		  
		   
		   Thread.sleep(5000);
		   clickOnElement(thirdtabdomesticradiobtn);
		   
		   Thread.sleep(3000);
		  LoggerUtil.info("User Click The Add customer Button...");
		  clickOnElement(addcustomerbtn);
		  Thread.sleep(4000);
		  clearAndEnterText(waitForExpectedElement(entercustomercodevalue), entercustcode);
		  Thread.sleep(4000);
		  clearAndEnterText(waitForExpectedElement(entercustomernamevalue), entercustname);
		  LoggerUtil.info("User Enter The customer Name = "+ entercustname);
		  Thread.sleep(4000);
		  clearAndEnterText(waitForExpectedElement(customerlocation), "mohali");
		  Thread.sleep(3000);
		  clickOnElement(clickbusinessSegmentdrop);
		  Thread.sleep(4000);
		  clickOnElement(checkboxbusinessSegment);
		  Thread.sleep(3000);
		  clickOnElement(clicksavebtncustomer);  
		  Thread.sleep(3000);
		  clickOnElement(clickcrossbtn);
		  Thread.sleep(8000);
		  clearAndEnterText(waitForExpectedElement(searchccusotmer),entercustcode);
		  Thread.sleep(6000);
		  clickOnElement(clickcustomercheckboxfordomestic);
		 
		  
			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
			 clickOnElement(thirdtabcomgrp);
			List<WebElement> comgrplist = driver.findElements(By.xpath("//ul[@id='select2-commodityDrop-results']/li"));
          
			for (int i = 1; i < comgrplist.size(); i++) {
				
				String text = comgrplist.get(i).getText().trim();
				
				System.out.println("Id " + (i + 1) + "  : " + text);

				if (text.equals("Input material For Alloys")) {
					comgrplist.get(i).click();
					LoggerUtil.info("User Click Alloys Sucessfully = Input material For Alloys ");
					break; 
					
				}
				
			}

			LoggerUtil.info("Total Number of Dropdown Values = " + comgrplist.size());
			Thread.sleep(7000);
			clickOnElement(thirtabclassification);
			LoggerUtil.info("User Click The Group classification in third tab");
			Thread.sleep(2000);
			
			List<WebElement> classificationlist = driver.findElements(By.xpath("//ul[@id='select2-materialDrop-results']/li"));
			
			for(WebElement classficationvalue:classificationlist){
				String flagvalue = classficationvalue.getText().trim();
				if(flagvalue.equalsIgnoreCase("Aluminum")) {
					
					classficationvalue.click();
					LoggerUtil.info("User Select The Classification Value = Aluminum");
					break;
				}
				
			}
			LoggerUtil.info("Total number of Dropdown value is = "+classificationlist.size());
			Thread.sleep(7000);
			clickOnElement(thirdtabspecificgrade);
			LoggerUtil.info("User Click The Specific group dropdown in third tab");
			List<WebElement> gradelsit = driver.findElements(By.xpath("//ul[@id='select2-SpecificGrade-results']/li"));
			for(WebElement gradedropvalue:gradelsit) {
				
				String flaggrade= gradedropvalue.getText().trim();
				if(flaggrade.equalsIgnoreCase("Al")) {
					
					gradedropvalue.click();
					LoggerUtil.info("User click dropdown value = Al");
					break;
				}
				
			}
			LoggerUtil.info("Total Number of Drodown Value is = "+ gradelsit.size());
			
			Thread.sleep(7000);
			
			clickOnElement(thirduomdropdown);
			LoggerUtil.info("User click The Third tab Drop-Down Value ");
			Thread.sleep(6000);
			
			List<WebElement> uomlist = driver.findElements(By.xpath("//ul[@id='select2-uomDrop-results']/li"));
			
			for(int i =1;i<uomlist.size();i++) {
				
				String t = uomlist.get(i).getText().trim();
				
				if(t.equalsIgnoreCase("Kg")) {
					
					uomlist.get(i).click();
					LoggerUtil.info("User Clicked The kg In Uom Dropdown Value");
					break;
				}
				
			}
			LoggerUtil.info("Total Number Of Dropdown Value is = " +uomlist.size());
			
			Thread.sleep(7000);
			clickOnElement(thirdtabshapedropdown);
			LoggerUtil.info("User Click The Shape Dropdown");
			
			Thread.sleep(6000);
			List<WebElement> shapedroplist = driver.findElements(By.xpath("//ul[@id='select2-shapeDrop-results']/li"));
			selectBootStrapDropDown(shapedroplist, "Misc.");
			Thread.sleep(5000);
			clearAndEnterText(driver.findElement(enterbasicCostprice), enterbasicvalue);
		    Thread.sleep(200);
		    clearAndEnterText(driver.findElement(firststagefrieght), enterfirststagefrieght);
		    Thread.sleep(200);
		    clearAndEnterText(driver.findElement(conversioncast), enterconversioncost);
		    Thread.sleep(200);
		    clearAndEnterText(driver.findElement(wastagepercantageonbasic), enterwastagecost);
		    Thread.sleep(200);
		    clearAndEnterText(driver.findElement(secodstagefrieghtcost), entersecondstagefrieght);
		    Thread.sleep(200);
		    clearAndEnterText(driver.findElement(anyothercastfactorone), enterothercostfactorone);
		    Thread.sleep(200);
		    clearAndEnterText(driver.findElement(anyothercostfactortwo), enterothercostfactortwo);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Optional: wait for modal or loader to be gone
		    // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

		    WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-taxDrop-container']")));
		    WebElement forscrollpupose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='BasiccostD']")));
		    js.executeScript("arguments[0].scrollIntoView(true);", forscrollpupose);
		    Thread.sleep(300); // settle the scroll

		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
		    } catch (ElementClickInterceptedException e) {
		        js.executeScript("arguments[0].click();", dropdown);
		    }

		    // Wait for follow-up actions
		    Thread.sleep(3000);  // Only if absolutely necessary, prefer explicit waits

    		    
            Thread.sleep(3000);            
            clearAndEnterText(waitForExpectedElement(searchforaddnewtax), "Add to cost");
            Thread.sleep(2000);
            clickOnElement(selectvalueforaddnewtax);
            Thread.sleep(1000);
            clearAndEnterText(waitForExpectedElement(othercostfactor1), enterothercost1);
            Thread.sleep(200);
            clearAndEnterText(waitForExpectedElement(othercostfactor2), enterothercost2);
            Thread.sleep(200);
            clearAndEnterText(waitForExpectedElement(othercostfactor3), enterothercost3);
            Thread.sleep(200);
            clearAndEnterText(waitForExpectedElement(discountabsolute), enterdiscountabsolute);
            Thread.sleep(2000);
            clickOnElement(savecomdetail);
           
            Thread.sleep(4000);
            clickOnElement(clickapprovaldropdown);
            Thread.sleep(4000);
            List<WebElement> dropvalue = driver.findElements(dropdownlistforRmapproval);
            Thread.sleep(2000);
            List<WebElement> approvaldroplist = driver.findElements(By.xpath("//select[@id='ApprovalAlloy']/option"));
            selectBootStrapDropDown(approvaldroplist,"Automation-Single Lvl-Grade Approval");
            Thread.sleep(4000);
            clearAndEnterText(waitForExpectedElement(reasonforchange),"This is Pooja ");
            Thread.sleep(3000);
            clearAndEnterText(waitForExpectedElement(deviationvalue),"This is Pooja class ");
            Thread.sleep(3000);
            clearAndEnterText(waitForExpectedElement(entereffectivedate),"01-01-2025");
            Thread.sleep(9000);
            
            clickOnElement(clicksendkeys);
           
          
            Thread.sleep(12000);
            approveOutlookMail("sachindra@costmasters.in","Mani@123#");
            
          

        
       }
       
       
       public static void verifyCurrentTimeMatchesUI(String actualTimeFromUI) {
    	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE M/d/yyyy h:mm a", Locale.ENGLISH);
    	    String expectedTime = LocalDateTime.now().format(formatter);

    	    System.out.println("Expected time: " + expectedTime);
    	    System.out.println("Actual time from UI: " + actualTimeFromUI);

    	    soft.assertTrue(actualTimeFromUI.contains(expectedTime),
    	        "Time mismatch! Expected: " + expectedTime + ", Actual: " + actualTimeFromUI);
    	}

       public static final By verifycurrenttimeformater = By.xpath("//*[@id='focused']/div[1]/div[2]/div[2]/div[1]");
       public static final By fetchdate = By.xpath("(//div[@class='x_mail_form_container']/div/table/tbody/tr/td[2])[1]");
       public static final By clickgofirstbtn = By.xpath("//div/button[normalize-space()='Go']");
       public static final By mailcustomername = By.xpath("//div[@class='x_mail_form_container']/div[2]/table/tbody/tr/td[3]");
       public static String approveOutlookMail(String username, String password) throws InterruptedException {
           // Open Outlook Login page
           driver.get("https://outlook.office365.com/"); 
           
           // Enter the username (email)
           clearAndEnterText(waitForExpectedElement(By.id("i0116")), username);
           
           // Click next button
           clickOnElement(By.id("idSIButton9"));
           
           // Wait for password field to appear
           Thread.sleep(3000);
           
           // Enter the password
           clearAndEnterText(waitForExpectedElement(By.id("i0118")), password);
           
           // Click on 'Sign In' button
           clickOnElement(By.id("idSIButton9"));
           
           // Wait for "Stay signed in" checkbox and ensure it's clickable
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased wait time
           WebElement staySignedInCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
           
           // If the checkbox is not already selected, click it
           if (!staySignedInCheckbox.isSelected()) {
               clickOnElement(By.id("idSIButton9"));
           }
           
           // Wait for the inbox page to load
           Thread.sleep(15000);
           
           // Locate all emails in the inbox with 'Approval Mail' in the subject
           List<WebElement> emails = driver.findElements(By.xpath("//span[contains(text(),'Approval Mail')]"));

           // Check if there are emails and select the latest one (first email in the list)
           if (!emails.isEmpty()) {
               WebElement latestEmail = emails.get(0); // The first email in the list is the latest
               // Wait for the email to be clickable
               WebDriverWait emailWait = new WebDriverWait(driver, Duration.ofSeconds(15));
               emailWait.until(ExpectedConditions.elementToBeClickable(latestEmail));
               
               // Forcefully click the latest email using JavaScript (ensure it's in view and clickable)
               JavascriptExecutor js = (JavascriptExecutor) driver;
             //  js.executeScript("arguments[0].scrollIntoView(true);", latestEmail); // Scroll to the email if it's not in view
               js.executeScript("arguments[0].click();", latestEmail); // Force click the email
           }
           
           
           Thread.sleep(3000);
           String actualdatetime = waitForExpectedElement(verifycurrenttimeformater).getText();
           
           verifyCurrentTimeMatchesUI(actualdatetime);
           
          
           
           // Wait for the email to load
           Thread.sleep(17000);
           
           // Get the current window handle (the original window)
           String originalWindow = driver.getWindowHandle();
           
           // Switch to the new tab (there should now be at least 2 windows)
           for (String windowHandle : driver.getWindowHandles()) {
               if (!windowHandle.equals(originalWindow)) {
                   driver.switchTo().window(windowHandle);  // Switch to the new window
                   break;
               }
           }

           // Wait for the "Approve" button to be visible and clickable
           WebElement approveButton = driver.findElement(By.xpath("//div/a[normalize-space()='Approve']"));
           WebDriverWait approveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
           approveWait.until(ExpectedConditions.elementToBeClickable(approveButton));
           
           // Force click the "Approve" button using JavaScript
           JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        
           jsExec.executeScript("arguments[0].click();", approveButton);

           // Wait for the approval process to finish
           Thread.sleep(8000);
           
           // Switch back to the original window (Inbox)
           driver.switchTo().window(originalWindow);
           
           // Wait for the inbox to reload after navigating back
           Thread.sleep(15000);
           
           // Wait for the email list to reload and ensure the second email is clickable
           List<WebElement> emails1 = driver.findElements(By.xpath("//span[contains(text(),'Commodity-Workflow')]"));
           
           // Ensure the email list is loaded and the emails are clickable
           WebDriverWait waitForEmails = new WebDriverWait(driver, Duration.ofSeconds(15));
           waitForEmails.until(ExpectedConditions.visibilityOfAllElements(emails1));

           // Now, check if there are emails and select the latest one
           if (!emails1.isEmpty()) {
               WebElement latestEmail1 = emails1.get(0); // The first email in the list is the latest
               // Wait for the email to be clickable
               WebDriverWait emailWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
               emailWait1.until(ExpectedConditions.elementToBeClickable(latestEmail1));
               
               // Forcefully click the latest email using JavaScript
               JavascriptExecutor js1 = (JavascriptExecutor) driver;
            
               js1.executeScript("arguments[0].click();", latestEmail1);
           }
           
           // Wait for the email to load
           Thread.sleep(12000);
           
           // Perform actions on the second mail (Approve it)
           WebElement approveButton1 = driver.findElement(By.xpath("//div/a[normalize-space()='Approve']"));
           WebDriverWait approveWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
           approveWait1.until(ExpectedConditions.elementToBeClickable(approveButton1));
           
           // Force click the "Approve" button using JavaScript
           JavascriptExecutor jsExec1 = (JavascriptExecutor) driver;
       
           jsExec1.executeScript("arguments[0].click();", approveButton1);

           // Wait for the approval process to finish
           Thread.sleep(21000);
           
           driver.switchTo().window(originalWindow);
      
           
           // After the second approval, check for the final approval (confirmation) email
           List<WebElement> finalApprovalEmails = driver.findElements(By.xpath("//span[contains(text(),'Commodity Workflow')]"));
           
           if (!finalApprovalEmails.isEmpty()) {
               WebElement finalEmail = finalApprovalEmails.get(0);
               WebDriverWait finalEmailWait = new WebDriverWait(driver, Duration.ofSeconds(15));
               finalEmailWait.until(ExpectedConditions.elementToBeClickable(finalEmail));
               
               // Force click the final approval email using JavaScript
               JavascriptExecutor jsFinal = (JavascriptExecutor) driver;
               
               jsFinal.executeScript("arguments[0].click();", finalEmail);
               Thread.sleep(4000);
                customermailname = waitForExpectedElement(mailcustomername).getText();
                effectivedatefrommail = waitForExpectedElement(fetchdate).getText();
               LoggerUtil.info(customermailname);
               return customermailname;
           }
   		return originalWindow;

           
           
           
           
          
   		
          
           
       
       }
       
      
       public static final By domesticradiobtn = By.xpath("//*[@id='domesticR']");
       public static final By scrollelement = By.id("part-table-scroll");
       public static final By uieffectivedate = By.xpath("//*[@id='ComDetailBody']/tr/td[9]");
       public static final By customercheckboxfilter = By.xpath("//*[@id='chkddd']/label/input[@type='checkbox' and @value='Customer']");
       public static final By clickfilterbtn = By.xpath("//*[@id='CommodityDetailTab']/div[2]/div/div/div[2]/div[2]/i");
       public static final By viewbtn = By.xpath("//*[@id='CommodityDetailTab']/div[1]/div[2]/div/div/div/button[4]");
       public static final By searchvalue = By.xpath("//input[@id='myInputListSearch']");
       public static final By fetchingcustomernmae = By.xpath("//*[@id='ComDetailBody']/tr[1]/td[12]");
       public void verifysavedatainviewtable(String entercustomername) throws InterruptedException {
    	   
    	   clickOnElement(domesticradiobtn);
    	   clickOnElement(viewbtn);
    	   Thread.sleep(4000);
    	   clickOnElement(clickfilterbtn);
    	   Thread.sleep(4000);
    	   clickOnElement(customercheckboxfilter);
    	  Thread.sleep(5000);

    	  Thread.sleep(4000); // or better
    	  JavascriptExecutor js = (JavascriptExecutor) driver;

    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	  WebElement scrollDiv = wait.until(ExpectedConditions.presenceOfElementLocated(scrollelement));
    	  js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollDiv);


    	  clearAndEnterText(waitForExpectedElement(searchvalue), entercustomername);
    	  
    	 
    	  Thread.sleep(10000);
  
    	  
    	  String actualcustomernamevalue = waitForExpectedElement(fetchingcustomernmae).getText();
    	  String actualeffectivedate = waitForExpectedElement(uieffectivedate).getText();
    	  try { 
    	  soft.assertEquals(customermailname, actualcustomernamevalue);
    	  soft.assertEquals(effectivedatefrommail,actualeffectivedate );  
    	
    	  LoggerUtil.info("Customername from  mail =  "  +customermailname+  " Customer Name From Ui = " +actualcustomernamevalue );
    	  LoggerUtil.pass("customermailname and actualcustomernamevalue has been equal....");
    	 
    	  soft.assertAll();
    	  }
    	  catch(Exception e ) {
    		  
    		  System.out.println("The customer nane has not been matched....");
    		  
    	  }
    	  
       }
       
       
       
       
       
       
       
       public void SavedatawithpoojaforSilicon(String enteraddcomvalue) {
   		
   		try {
   		clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), enteraddcomvalue);
   		Thread.sleep(2000);
   		clickOnElement(savebuttonaddcommodity);
   		Thread.sleep(2000);
   		}
   		catch(Exception e)
   		{
   			LoggerUtil.info("Error While Clicking Save Button In Add Commodity = " +e.getMessage());
   		}
   	}
       
       
       
       
           public void savesecondtabfordomesticWithSilicon(String entergrpclassvalue,String enterspecificgradevalue) throws InterruptedException {
    	   
    	   Thread.sleep(5000);
    	   
    	   clickOnElement(secomdtabclickcommoditydropdown);
    	   
    	   Thread.sleep(7000);
    	   
    	   List<WebElement> comdropvalue = driver.findElements(fetchingcommoditydropdownsecondtab);
   		
   		   for(WebElement comdroplist:comdropvalue) {
   			
   			String comvalue = comdroplist.getText().trim();
   			if(comvalue.equalsIgnoreCase("Input material For Alloys")) {	
   				comdroplist.click();
   				break;
   				
   			}	
   		}
    	 LoggerUtil.info("Total Value of Second Tab in Commodity Dropdown  = " + comdropvalue.size());
   		 Thread.sleep(1999);
   		 clearAndEnterText(waitForExpectedElement(entergrpclassificationvaluesecontab), entergrpclassvalue);
   		 LoggerUtil.info("User enter  The group classification value in second tab = " + entergrpclassvalue);
   		 Thread.sleep(1999);
   		 clearAndEnterText(waitForExpectedElement(enterspecificgradevaluesecondtab), enterspecificgradevalue);
   		 LoggerUtil.info("User enter The specificgrade value in second tab = " + enterspecificgradevalue);
   		 Thread.sleep(1999);
   		 clearAndEnterText(waitForExpectedElement(enterdensityvaluesecondtab), "1");
   		LoggerUtil.info("User enter The density value in second tab = " +"1");
   		 Thread.sleep(1999);
         clickOnElement(savebtncommoditygrp);   		 
   		 Thread.sleep(7000);
   		 clearAndEnterText(waitForExpectedElement(entersearchvalueforcommgrptab), "Input material For Alloys");
   		
   		
       }
       
       
       
       
       public static final By customerlocation = By.xpath("//input[@id='CustomerLocation']");
           public void SaveDataInThirdTabDomesticForSilicon(String entercuscode,String entercustname,String enterbasicvalue,String enterfirststagefrieght,String enterconversioncost,String enterwastagecost,String entersecondstagefrieght,String enterothercostfactorone,String enterothercostfactortwo,String enterothercost1,String enterothercost2,String enterothercost3,String enterdiscountabsolute,String enetrsearchcustomer) throws InterruptedException {
     		  
    		   Thread.sleep(5000);
    		   clickOnElement(thirdtabdomesticradiobtn);
    		   
    		   Thread.sleep(3000);
    		  LoggerUtil.info("User Click The Add customer Button...");
    		  clickOnElement(addcustomerbtn);
    		  Thread.sleep(4000);
    		  clearAndEnterText(waitForExpectedElement(entercustomercodevalue), entercuscode);
    		  Thread.sleep(4000);
    		  clearAndEnterText(waitForExpectedElement(entercustomernamevalue),entercustname);
    		  LoggerUtil.info("User Enter The customer Name = "+ entercustname);
    		  Thread.sleep(4000);
    		  clearAndEnterText(waitForExpectedElement(customerlocation), "mohali");
    		  Thread.sleep(3000);
    		  clickOnElement(clickbusinessSegmentdrop);
    		  Thread.sleep(4000);
    		  clickOnElement(checkboxbusinessSegment);
    		  Thread.sleep(3000);
    		  clickOnElement(clicksavebtncustomer);  
    		  Thread.sleep(3000);
    		  clickOnElement(clickcrossbtn);
    		  Thread.sleep(8000);
    		  clearAndEnterText(waitForExpectedElement(searchccusotmer), entercuscode);
    		  Thread.sleep(6000);
    		  clickOnElement(clickcustomercheckboxfordomestic);
    		   
    			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
    			 clickOnElement(thirdtabcomgrp);
    			List<WebElement> comgrplist = driver.findElements(By.xpath("//ul[@id='select2-commodityDrop-results']/li"));
              
    			for (int i = 1; i < comgrplist.size(); i++) {
    				
    				String text = comgrplist.get(i).getText().trim();
    				
    				System.out.println("Id " + (i + 1) + "  : " + text);

    				if (text.equals("Input material For Alloys")) {
    					comgrplist.get(i).click();
    					LoggerUtil.info("User Click Alloys Sucessfully = Input material For Alloys ");
    					break; 
    					
    				}
    				
    			}

    			LoggerUtil.info("Total Number of Dropdown Values = " + comgrplist.size());
    			Thread.sleep(7000);
    			clickOnElement(thirtabclassification);
    			LoggerUtil.info("User Click The Group classification in third tab");
    			Thread.sleep(2000);
    			
    			List<WebElement> classificationlist = driver.findElements(By.xpath("//ul[@id='select2-materialDrop-results']/li"));
    			
    			for(WebElement classficationvalue:classificationlist){
    				String flagvalue = classficationvalue.getText().trim();
    				if(flagvalue.equalsIgnoreCase("Silicon")) {
    					
    					classficationvalue.click();
    					LoggerUtil.info("User Select The Classification Value = Silicon");
    					break;
    				}
    				
    			}
    			LoggerUtil.info("Total number of Dropdown value is = "+classificationlist.size());
    			Thread.sleep(7000);
    			clickOnElement(thirdtabspecificgrade);
    			LoggerUtil.info("User Click The Specific group dropdown in third tab");
    			List<WebElement> gradelsit = driver.findElements(By.xpath("//ul[@id='select2-SpecificGrade-results']/li"));
    			for(WebElement gradedropvalue:gradelsit) {
    				
    				String flaggrade= gradedropvalue.getText().trim();
    				if(flaggrade.equalsIgnoreCase("si")) {
    					
    					gradedropvalue.click();
    					LoggerUtil.info("User click dropdown value = si");
    					break;
    				}
    				
    			}
    			LoggerUtil.info("Total Number of Drodown Value is = "+ gradelsit.size());
    			
    			Thread.sleep(7000);
    			
    			clickOnElement(thirduomdropdown);
    			LoggerUtil.info("User click The Third tab Drop-Down Value ");
    			Thread.sleep(6000);
    			
    			List<WebElement> uomlist = driver.findElements(By.xpath("//ul[@id='select2-uomDrop-results']/li"));
    			
    			for(int i =1;i<uomlist.size();i++) {
    				
    				String t = uomlist.get(i).getText().trim();
    				
    				if(t.equalsIgnoreCase("Kg")) {
    					
    					uomlist.get(i).click();
    					LoggerUtil.info("User Clicked The kg In Uom Dropdown Value");
    					break;
    				}
    				
    			}
    			LoggerUtil.info("Total Number Of Dropdown Value is = " +uomlist.size());
    			
    			Thread.sleep(7000);
    			clickOnElement(thirdtabshapedropdown);
    			LoggerUtil.info("User Click The Shape Dropdown");
    			
    			Thread.sleep(6000);
    			List<WebElement> shapedroplist = driver.findElements(By.xpath("//ul[@id='select2-shapeDrop-results']/li"));
    			selectBootStrapDropDown(shapedroplist, "Misc.");
    			Thread.sleep(5000);
    			clearAndEnterText(driver.findElement(enterbasicCostprice), enterbasicvalue);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(firststagefrieght), enterfirststagefrieght);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(conversioncast), enterconversioncost);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(wastagepercantageonbasic), enterwastagecost);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(secodstagefrieghtcost), entersecondstagefrieght);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(anyothercastfactorone), enterothercostfactorone);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(anyothercostfactortwo), enterothercostfactortwo);
    		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    		    JavascriptExecutor js = (JavascriptExecutor) driver;

    		    // Optional: wait for modal or loader to be gone
    		    // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

    		    WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-taxDrop-container']")));
    		    WebElement forscrollpupose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='BasiccostD']")));
    		    js.executeScript("arguments[0].scrollIntoView(true);", forscrollpupose);
    		    Thread.sleep(300); // settle the scroll

    		    try {
    		        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
    		    } catch (ElementClickInterceptedException e) {
    		        js.executeScript("arguments[0].click();", dropdown);
    		    }

    		    // Wait for follow-up actions
    		    Thread.sleep(3000);  // Only if absolutely necessary, prefer explicit waits

        		    
                Thread.sleep(3000);            
                clearAndEnterText(waitForExpectedElement(searchforaddnewtax), "Add to cost");
                Thread.sleep(2000);
                clickOnElement(selectvalueforaddnewtax);
                Thread.sleep(1000);
                clearAndEnterText(waitForExpectedElement(othercostfactor1), enterothercost1);
                Thread.sleep(200);
                clearAndEnterText(waitForExpectedElement(othercostfactor2), enterothercost2);
                Thread.sleep(200);
                clearAndEnterText(waitForExpectedElement(othercostfactor3), enterothercost3);
                Thread.sleep(200);
                clearAndEnterText(waitForExpectedElement(discountabsolute), enterdiscountabsolute);
                Thread.sleep(2000);
                clickOnElement(savecomdetail);
               
                Thread.sleep(4000);
                clickOnElement(clickapprovaldropdown);
                Thread.sleep(4000);
                List<WebElement> dropvalue = driver.findElements(dropdownlistforRmapproval);
                Thread.sleep(2000);
                List<WebElement> approvaldroplist = driver.findElements(By.xpath("//select[@id='ApprovalAlloy']/option"));
                selectBootStrapDropDown(approvaldroplist,"Automation-Single Lvl-Grade Approval");
                Thread.sleep(4000);
                clearAndEnterText(waitForExpectedElement(reasonforchange),"This is Pooja ");
                Thread.sleep(3000);
                clearAndEnterText(waitForExpectedElement(deviationvalue),"This is Pooja class ");
                Thread.sleep(3000);
                clearAndEnterText(waitForExpectedElement(entereffectivedate),"01-01-2025");
                Thread.sleep(9000);
                
                clickOnElement(clicksendkeys);
               
              
                Thread.sleep(12000);
                approveOutlookMail("sachindra@costmasters.in","Mani@123#");
                
              

            
           }
		

       
           public void verifysavedatainviewtableForSilicon(String searchcustomername) throws InterruptedException {
        	   
        	   clickOnElement(domesticradiobtn);
        	   clickOnElement(viewbtn);
        	   Thread.sleep(4000);
        	   clickOnElement(clickfilterbtn);
        	   Thread.sleep(4000);
        	   clickOnElement(customercheckboxfilter);
        	  Thread.sleep(5000);

        	  Thread.sleep(4000); // or better
        	  JavascriptExecutor js = (JavascriptExecutor) driver;

        	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	  WebElement scrollDiv = wait.until(ExpectedConditions.presenceOfElementLocated(scrollelement));
        	  js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollDiv);


        	  clearAndEnterText(waitForExpectedElement(searchvalue), searchcustomername);
        	  
        	 
        	  Thread.sleep(10000);
      
        	  
        	  String actualcustomernamevalue = waitForExpectedElement(fetchingcustomernmae).getText();
        	  String actualeffectivedate = waitForExpectedElement(uieffectivedate).getText();
        	  try { 
        	  soft.assertEquals(customermailname, actualcustomernamevalue);
        	  soft.assertEquals(effectivedatefrommail,actualeffectivedate );  
        	
        	  LoggerUtil.info("Customername from  mail =  "  +customermailname+  " Customer Name From Ui = " +actualcustomernamevalue );
        	  LoggerUtil.pass("customermailname and actualcustomernamevalue has been equal....");
        	 
        	  soft.assertAll();
        	  }
        	  catch(Exception e ) {
        		  
        		  System.out.println("The customer nane has not been matched....");
        		  
        	  }
        	  
           }
       
       
       
           public void SavedatawithpoojaforCopper(String enteraddcomvalue) {
          		
          		try {
          		clearAndEnterText(waitForExpectedElement(entercommdoitygroupInAddCommodity), enteraddcomvalue);
          		Thread.sleep(2000);
          		clickOnElement(savebuttonaddcommodity);
          		Thread.sleep(2000);
          		}
          		catch(Exception e)
          		{
          			LoggerUtil.info("Error While Clicking Save Button In Add Commodity = " +e.getMessage());
          		}
          	}
       
       
       
           public void savesecondtabfordomesticWithCopper(String entergrpclassvalue,String enterspecificgradevalue) throws InterruptedException {
        	   
        	   Thread.sleep(5000);
        	   
        	   clickOnElement(secomdtabclickcommoditydropdown);
        	   
        	   Thread.sleep(7000);
        	   
        	   List<WebElement> comdropvalue = driver.findElements(fetchingcommoditydropdownsecondtab);
       		
       		   for(WebElement comdroplist:comdropvalue) {
       			
       			String comvalue = comdroplist.getText().trim();
       			if(comvalue.equalsIgnoreCase("Input material For Alloys")) {	
       				comdroplist.click();
       				break;
       				
       			}	
       		}
        	 LoggerUtil.info("Total Value of Second Tab in Commodity Dropdown  = " + comdropvalue.size());
       		 Thread.sleep(1999);
       		 clearAndEnterText(waitForExpectedElement(entergrpclassificationvaluesecontab), entergrpclassvalue);
       		 LoggerUtil.info("User enter  The group classification value in second tab = " + entergrpclassvalue);
       		 Thread.sleep(1999);
       		 clearAndEnterText(waitForExpectedElement(enterspecificgradevaluesecondtab), enterspecificgradevalue);
       		 LoggerUtil.info("User enter The specificgrade value in second tab = " + enterspecificgradevalue);
       		 Thread.sleep(1999);
       		 clearAndEnterText(waitForExpectedElement(enterdensityvaluesecondtab), "1");
       		LoggerUtil.info("User enter The density value in second tab = " +"1");
       		 Thread.sleep(1999);
             clickOnElement(savebtncommoditygrp);   		 
       		 Thread.sleep(7000);
       		 clearAndEnterText(waitForExpectedElement(entersearchvalueforcommgrptab), "Input material For Alloys");
       		
       		
           }
       
       
       
           public void SaveDataInThirdTabDomesticForCopper(String entercuscode,String entercustname,String enterbasicvalue,String enterfirststagefrieght,String enterconversioncost,String enterwastagecost,String entersecondstagefrieght,String enterothercostfactorone,String enterothercostfactortwo,String enterothercost1,String enterothercost2,String enterothercost3,String enterdiscountabsolute,String enetrsearchcustomer) throws InterruptedException {
      		  
    		   Thread.sleep(5000);
    		   clickOnElement(thirdtabdomesticradiobtn);
    		   
    		   Thread.sleep(3000);
    		  LoggerUtil.info("User Click The Add customer Button...");
    		  clickOnElement(addcustomerbtn);
    		  Thread.sleep(4000);
    		  clearAndEnterText(waitForExpectedElement(entercustomercodevalue), entercuscode);
    		  Thread.sleep(4000);
    		  clearAndEnterText(waitForExpectedElement(entercustomernamevalue),entercustname);
    		  LoggerUtil.info("User Enter The customer Name = "+ entercustname);
    		  Thread.sleep(4000);
    		  clearAndEnterText(waitForExpectedElement(customerlocation), "mohali");
    		  Thread.sleep(3000);
    		  clickOnElement(clickbusinessSegmentdrop);
    		  Thread.sleep(4000);
    		  clickOnElement(checkboxbusinessSegment);
    		  Thread.sleep(3000);
    		  clickOnElement(clicksavebtncustomer);  
    		  Thread.sleep(3000);
    		  clickOnElement(clickcrossbtn);
    		  Thread.sleep(8000);
    		  clearAndEnterText(waitForExpectedElement(searchccusotmer), entercuscode);
    		  Thread.sleep(6000);
    		  clickOnElement(clickcustomercheckboxfordomestic);
    		   
    			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
    			 clickOnElement(thirdtabcomgrp);
    			List<WebElement> comgrplist = driver.findElements(By.xpath("//ul[@id='select2-commodityDrop-results']/li"));
              
    			for (int i = 1; i < comgrplist.size(); i++) {
    				
    				String text = comgrplist.get(i).getText().trim();
    				
    				System.out.println("Id " + (i + 1) + "  : " + text);

    				if (text.equals("Input material For Alloys")) {
    					comgrplist.get(i).click();
    					LoggerUtil.info("User Click Alloys Sucessfully = Input material For Alloys ");
    					break; 
    					
    				}
    				
    			}

    			LoggerUtil.info("Total Number of Dropdown Values = " + comgrplist.size());
    			Thread.sleep(7000);
    			clickOnElement(thirtabclassification);
    			LoggerUtil.info("User Click The Group classification in third tab");
    			Thread.sleep(2000);
    			
    			List<WebElement> classificationlist = driver.findElements(By.xpath("//ul[@id='select2-materialDrop-results']/li"));
    			
    			for(WebElement classficationvalue:classificationlist){
    				String flagvalue = classficationvalue.getText().trim();
    				if(flagvalue.equalsIgnoreCase("Copper")) {
    					
    					classficationvalue.click();
    					LoggerUtil.info("User Select The Classification Value = Copper");
    					break;
    				}
    				
    			}
    			LoggerUtil.info("Total number of Dropdown value is = "+classificationlist.size());
    			Thread.sleep(7000);
    			clickOnElement(thirdtabspecificgrade);
    			LoggerUtil.info("User Click The Specific group dropdown in third tab");
    			List<WebElement> gradelsit = driver.findElements(By.xpath("//ul[@id='select2-SpecificGrade-results']/li"));
    			for(WebElement gradedropvalue:gradelsit) {
    				
    				String flaggrade= gradedropvalue.getText().trim();
    				if(flaggrade.equalsIgnoreCase("cu")) {
    					
    					gradedropvalue.click();
    					LoggerUtil.info("User click dropdown value = cu");
    					break;
    				}
    				
    			}
    			LoggerUtil.info("Total Number of Drodown Value is = "+ gradelsit.size());
    			
    			Thread.sleep(7000);
    			
    			clickOnElement(thirduomdropdown);
    			LoggerUtil.info("User click The Third tab Drop-Down Value ");
    			Thread.sleep(6000);
    			
    			List<WebElement> uomlist = driver.findElements(By.xpath("//ul[@id='select2-uomDrop-results']/li"));
    			
    			for(int i =1;i<uomlist.size();i++) {
    				
    				String t = uomlist.get(i).getText().trim();
    				
    				if(t.equalsIgnoreCase("Kg")) {
    					
    					uomlist.get(i).click();
    					LoggerUtil.info("User Clicked The kg In Uom Dropdown Value");
    					break;
    				}
    				
    			}
    			LoggerUtil.info("Total Number Of Dropdown Value is = " +uomlist.size());
    			
    			Thread.sleep(7000);
    			clickOnElement(thirdtabshapedropdown);
    			LoggerUtil.info("User Click The Shape Dropdown");
    			
    			Thread.sleep(6000);
    			List<WebElement> shapedroplist = driver.findElements(By.xpath("//ul[@id='select2-shapeDrop-results']/li"));
    			selectBootStrapDropDown(shapedroplist, "Misc.");
    			Thread.sleep(5000);
    			clearAndEnterText(driver.findElement(enterbasicCostprice), enterbasicvalue);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(firststagefrieght), enterfirststagefrieght);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(conversioncast), enterconversioncost);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(wastagepercantageonbasic), enterwastagecost);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(secodstagefrieghtcost), entersecondstagefrieght);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(anyothercastfactorone), enterothercostfactorone);
    		    Thread.sleep(200);
    		    clearAndEnterText(driver.findElement(anyothercostfactortwo), enterothercostfactortwo);
    		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    		    JavascriptExecutor js = (JavascriptExecutor) driver;

    		    // Optional: wait for modal or loader to be gone
    		    // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

    		    WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-taxDrop-container']")));
    		    WebElement forscrollpupose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='BasiccostD']")));
    		    js.executeScript("arguments[0].scrollIntoView(true);", forscrollpupose);
    		    Thread.sleep(300); // settle the scroll

    		    try {
    		        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
    		    } catch (ElementClickInterceptedException e) {
    		        js.executeScript("arguments[0].click();", dropdown);
    		    }

    		    // Wait for follow-up actions
    		    Thread.sleep(3000);  // Only if absolutely necessary, prefer explicit waits

        		    
                Thread.sleep(3000);            
                clearAndEnterText(waitForExpectedElement(searchforaddnewtax), "Add to cost");
                Thread.sleep(2000);
                clickOnElement(selectvalueforaddnewtax);
                Thread.sleep(1000);
                clearAndEnterText(waitForExpectedElement(othercostfactor1), enterothercost1);
                Thread.sleep(200);
                clearAndEnterText(waitForExpectedElement(othercostfactor2), enterothercost2);
                Thread.sleep(200);
                clearAndEnterText(waitForExpectedElement(othercostfactor3), enterothercost3);
                Thread.sleep(200);
                clearAndEnterText(waitForExpectedElement(discountabsolute), enterdiscountabsolute);
                Thread.sleep(2000);
                clickOnElement(savecomdetail);
               
                Thread.sleep(4000);
                clickOnElement(clickapprovaldropdown);
                Thread.sleep(4000);
                List<WebElement> dropvalue = driver.findElements(dropdownlistforRmapproval);
                Thread.sleep(2000);
                List<WebElement> approvaldroplist = driver.findElements(By.xpath("//select[@id='ApprovalAlloy']/option"));
                selectBootStrapDropDown(approvaldroplist,"Automation-Single Lvl-Grade Approval");
                Thread.sleep(4000);
                clearAndEnterText(waitForExpectedElement(reasonforchange),"This is Pooja ");
                Thread.sleep(3000);
                clearAndEnterText(waitForExpectedElement(deviationvalue),"This is Pooja class ");
                Thread.sleep(3000);
                clearAndEnterText(waitForExpectedElement(entereffectivedate),"01-01-2025");
                Thread.sleep(9000);
                
                clickOnElement(clicksendkeys);
               
              
                Thread.sleep(12000);
                approveOutlookMail("sachindra@costmasters.in","Mani@123#");
                
              

            
           }
       
           
        public void verifysavedatainviewtableForCopper(String searchcustomername) throws InterruptedException {
        	   
        	   clickOnElement(domesticradiobtn);
        	   clickOnElement(viewbtn);
        	   Thread.sleep(4000);
        	   clickOnElement(clickfilterbtn);
        	   Thread.sleep(4000);
        	   clickOnElement(customercheckboxfilter);
        	  Thread.sleep(5000);

        	  Thread.sleep(4000); // or better
        	  JavascriptExecutor js = (JavascriptExecutor) driver;

        	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	  WebElement scrollDiv = wait.until(ExpectedConditions.presenceOfElementLocated(scrollelement));
        	  js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollDiv);


        	  clearAndEnterText(waitForExpectedElement(searchvalue), searchcustomername);
        	  
        	 
        	  Thread.sleep(10000);
      
        	  
        	  String actualcustomernamevalue = waitForExpectedElement(fetchingcustomernmae).getText();
        	  String actualeffectivedate = waitForExpectedElement(uieffectivedate).getText();
        	  try { 
        	  soft.assertEquals(customermailname, actualcustomernamevalue);
        	  soft.assertEquals(effectivedatefrommail,actualeffectivedate );  
        	
        	  LoggerUtil.info("Customername from  mail =  "  +customermailname+  " Customer Name From Ui = " +actualcustomernamevalue );
        	  LoggerUtil.pass("customermailname and actualcustomernamevalue has been equal....");
        	 
        	  soft.assertAll();
        	  }
        	  catch(Exception e ) {
        		  
        		  System.out.println("The customer nane has not been matched....");
        		  
        	  }
        	  
           }
       
           
           
           
        public void savesecondtabfordomesticWithFuel(String entergrpclassvalue,String enterspecificgradevalue) throws InterruptedException {
     	   
     	   Thread.sleep(5000);
     	   
     	   clickOnElement(secomdtabclickcommoditydropdown);
     	   
     	   Thread.sleep(7000);
     	   
     	   List<WebElement> comdropvalue = driver.findElements(fetchingcommoditydropdownsecondtab);
    		
    		   for(WebElement comdroplist:comdropvalue) {
    			
    			String comvalue = comdroplist.getText().trim();
    			if(comvalue.equalsIgnoreCase("Input material For Alloys")) {	
    				comdroplist.click();
    				break;
    				
    			}	
    		}
     	 LoggerUtil.info("Total Value of Second Tab in Commodity Dropdown  = " + comdropvalue.size());
    		 Thread.sleep(1999);
    		 clearAndEnterText(waitForExpectedElement(entergrpclassificationvaluesecontab), entergrpclassvalue);
    		 LoggerUtil.info("User enter  The group classification value in second tab = " + entergrpclassvalue);
    		 Thread.sleep(1999);
    		 clearAndEnterText(waitForExpectedElement(enterspecificgradevaluesecondtab), enterspecificgradevalue);
    		 LoggerUtil.info("User enter The specificgrade value in second tab = " + enterspecificgradevalue);
    		 Thread.sleep(1999);
    		 clearAndEnterText(waitForExpectedElement(enterdensityvaluesecondtab), "1");
    		LoggerUtil.info("User enter The density value in second tab = " +"1");
    		 Thread.sleep(1999);
          clickOnElement(savebtncommoditygrp);   		 
    		 Thread.sleep(7000);
    		 clearAndEnterText(waitForExpectedElement(entersearchvalueforcommgrptab), "Input material For Alloys");
    		
    		
        }
           
           
        public void SaveDataInThirdTabDomesticForFuel(String entercuscode,String entercustname,String enterbasicvalue,String enterfirststagefrieght,String enterconversioncost,String enterwastagecost,String entersecondstagefrieght,String enterothercostfactorone,String enterothercostfactortwo,String enterothercost1,String enterothercost2,String enterothercost3,String enterdiscountabsolute,String enetrsearchcustomer) throws InterruptedException {
    		  
 		   Thread.sleep(5000);
 		   clickOnElement(thirdtabdomesticradiobtn);
 		   
 		   Thread.sleep(3000);
 		  LoggerUtil.info("User Click The Add customer Button...");
 		  clickOnElement(addcustomerbtn);
 		  Thread.sleep(4000);
 		  clearAndEnterText(waitForExpectedElement(entercustomercodevalue), entercuscode);
 		  Thread.sleep(4000);
 		  clearAndEnterText(waitForExpectedElement(entercustomernamevalue),entercustname);
 		  LoggerUtil.info("User Enter The customer Name = "+ entercustname);
 		  Thread.sleep(4000);
 		  clearAndEnterText(waitForExpectedElement(customerlocation), "mohali");
 		  Thread.sleep(3000);
 		  clickOnElement(clickbusinessSegmentdrop);
 		  Thread.sleep(4000);
 		  clickOnElement(checkboxbusinessSegment);
 		  Thread.sleep(3000);
 		  clickOnElement(clicksavebtncustomer);  
 		  Thread.sleep(3000);
 		  clickOnElement(clickcrossbtn);
 		  Thread.sleep(8000);
 		  clearAndEnterText(waitForExpectedElement(searchccusotmer), entercuscode);
 		  Thread.sleep(6000);
 		  clickOnElement(clickcustomercheckboxfordomestic);
 		   
 			LoggerUtil.info("User Click Third Tab DropDown Commodity Group");
 			 clickOnElement(thirdtabcomgrp);
 			List<WebElement> comgrplist = driver.findElements(By.xpath("//ul[@id='select2-commodityDrop-results']/li"));
           
 			for (int i = 1; i < comgrplist.size(); i++) {
 				
 				String text = comgrplist.get(i).getText().trim();
 				
 				System.out.println("Id " + (i + 1) + "  : " + text);

 				if (text.equals("Input material For Alloys")) {
 					comgrplist.get(i).click();
 					LoggerUtil.info("User Click Alloys Sucessfully = Input material For Alloys ");
 					break; 
 					
 				}
 				
 			}

 			LoggerUtil.info("Total Number of Dropdown Values = " + comgrplist.size());
 			Thread.sleep(7000);
 			clickOnElement(thirtabclassification);
 			LoggerUtil.info("User Click The Group classification in third tab");
 			Thread.sleep(2000);
 			
 			List<WebElement> classificationlist = driver.findElements(By.xpath("//ul[@id='select2-materialDrop-results']/li"));
 			
 			for(WebElement classficationvalue:classificationlist){
 				String flagvalue = classficationvalue.getText().trim();
 				if(flagvalue.equalsIgnoreCase("Fuel")) {
 					
 					classficationvalue.click();
 					LoggerUtil.info("User Select The Classification Value = Fuel");
 					break;
 				}
 				
 			}
 			LoggerUtil.info("Total number of Dropdown value is = "+classificationlist.size());
 			Thread.sleep(7000);
 			clickOnElement(thirdtabspecificgrade);
 			LoggerUtil.info("User Click The Specific group dropdown in third tab");
 			List<WebElement> gradelsit = driver.findElements(By.xpath("//ul[@id='select2-SpecificGrade-results']/li"));
 			for(WebElement gradedropvalue:gradelsit) {
 				
 				String flaggrade= gradedropvalue.getText().trim();
 				if(flaggrade.equalsIgnoreCase("Fuel")) {
 					
 					gradedropvalue.click();
 					LoggerUtil.info("User click dropdown value = Fuel");
 					break;
 				}
 				
 			}
 			LoggerUtil.info("Total Number of Drodown Value is = "+ gradelsit.size());
 			
 			Thread.sleep(7000);
 			
 			clickOnElement(thirduomdropdown);
 			LoggerUtil.info("User click The Third tab Drop-Down Value ");
 			Thread.sleep(6000);
 			
 			List<WebElement> uomlist = driver.findElements(By.xpath("//ul[@id='select2-uomDrop-results']/li"));
 			
 			for(int i =1;i<uomlist.size();i++) {
 				
 				String t = uomlist.get(i).getText().trim();
 				
 				if(t.equalsIgnoreCase("Kg")) {
 					
 					uomlist.get(i).click();
 					LoggerUtil.info("User Clicked The kg In Uom Dropdown Value");
 					break;
 				}
 				
 			}
 			LoggerUtil.info("Total Number Of Dropdown Value is = " +uomlist.size());
 			
 			Thread.sleep(7000);
 			clickOnElement(thirdtabshapedropdown);
 			LoggerUtil.info("User Click The Shape Dropdown");
 			
 			Thread.sleep(6000);
 			List<WebElement> shapedroplist = driver.findElements(By.xpath("//ul[@id='select2-shapeDrop-results']/li"));
 			selectBootStrapDropDown(shapedroplist, "Misc.");
 			Thread.sleep(5000);
 			clearAndEnterText(driver.findElement(enterbasicCostprice), enterbasicvalue);
 		    Thread.sleep(200);
 		    clearAndEnterText(driver.findElement(firststagefrieght), enterfirststagefrieght);
 		    Thread.sleep(200);
 		    clearAndEnterText(driver.findElement(conversioncast), enterconversioncost);
 		    Thread.sleep(200);
 		    clearAndEnterText(driver.findElement(wastagepercantageonbasic), enterwastagecost);
 		    Thread.sleep(200);
 		    clearAndEnterText(driver.findElement(secodstagefrieghtcost), entersecondstagefrieght);
 		    Thread.sleep(200);
 		    clearAndEnterText(driver.findElement(anyothercastfactorone), enterothercostfactorone);
 		    Thread.sleep(200);
 		    clearAndEnterText(driver.findElement(anyothercostfactortwo), enterothercostfactortwo);
 		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 		    JavascriptExecutor js = (JavascriptExecutor) driver;

 		    // Optional: wait for modal or loader to be gone
 		    // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

 		    WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-taxDrop-container']")));
 		    WebElement forscrollpupose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='BasiccostD']")));
 		    js.executeScript("arguments[0].scrollIntoView(true);", forscrollpupose);
 		    Thread.sleep(300); // settle the scroll

 		    try {
 		        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
 		    } catch (ElementClickInterceptedException e) {
 		        js.executeScript("arguments[0].click();", dropdown);
 		    }

 		    // Wait for follow-up actions
 		    Thread.sleep(3000);  // Only if absolutely necessary, prefer explicit waits

     		    
             Thread.sleep(3000);            
             clearAndEnterText(waitForExpectedElement(searchforaddnewtax), "Add to cost");
             Thread.sleep(2000);
             clickOnElement(selectvalueforaddnewtax);
             Thread.sleep(1000);
             clearAndEnterText(waitForExpectedElement(othercostfactor1), enterothercost1);
             Thread.sleep(200);
             clearAndEnterText(waitForExpectedElement(othercostfactor2), enterothercost2);
             Thread.sleep(200);
             clearAndEnterText(waitForExpectedElement(othercostfactor3), enterothercost3);
             Thread.sleep(200);
             clearAndEnterText(waitForExpectedElement(discountabsolute), enterdiscountabsolute);
             Thread.sleep(2000);
             clickOnElement(savecomdetail);
            
             Thread.sleep(4000);
             clickOnElement(clickapprovaldropdown);
             Thread.sleep(4000);
             List<WebElement> dropvalue = driver.findElements(dropdownlistforRmapproval);
             Thread.sleep(2000);
             List<WebElement> approvaldroplist = driver.findElements(By.xpath("//select[@id='ApprovalAlloy']/option"));
             selectBootStrapDropDown(approvaldroplist,"Automation-Single Lvl-Grade Approval");
             Thread.sleep(4000);
             clearAndEnterText(waitForExpectedElement(reasonforchange),"This is Pooja ");
             Thread.sleep(3000);
             clearAndEnterText(waitForExpectedElement(deviationvalue),"This is Pooja class ");
             Thread.sleep(3000);
             clearAndEnterText(waitForExpectedElement(entereffectivedate),"01-01-2025");
             Thread.sleep(9000);
             
             clickOnElement(clicksendkeys);
            
           
             Thread.sleep(12000);
             approveOutlookMail("sachindra@costmasters.in","Mani@123#");
             
           

         
        }
           
           
        public void verifysavedatainviewtableForFuel(String searchcustomername) throws InterruptedException {
     	   
     	   clickOnElement(domesticradiobtn);
     	   clickOnElement(viewbtn);
     	   Thread.sleep(4000);
     	   clickOnElement(clickfilterbtn);
     	   Thread.sleep(4000);
     	   clickOnElement(customercheckboxfilter);
     	  Thread.sleep(5000);

     	  Thread.sleep(4000); // or better
     	  JavascriptExecutor js = (JavascriptExecutor) driver;

     	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	  WebElement scrollDiv = wait.until(ExpectedConditions.presenceOfElementLocated(scrollelement));
     	  js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollDiv);


     	  clearAndEnterText(waitForExpectedElement(searchvalue), searchcustomername);
     	  
     	 
     	  Thread.sleep(10000);
   
     	  
     	  String actualcustomernamevalue = waitForExpectedElement(fetchingcustomernmae).getText();
     	  String actualeffectivedate = waitForExpectedElement(uieffectivedate).getText();
     	  try { 
     	  soft.assertEquals(customermailname, actualcustomernamevalue);
     	  soft.assertEquals(effectivedatefrommail,actualeffectivedate );  
     	
     	  LoggerUtil.info("Customername from  mail =  "  +customermailname+  " Customer Name From Ui = " +actualcustomernamevalue );
     	  LoggerUtil.pass("customermailname and actualcustomernamevalue has been equal....");
     	 
     	  soft.assertAll();
     	  }
     	  catch(Exception e ) {
     		  
     		  System.out.println("The customer nane has not been matched....");
     		  
     	  }
     	  
        }
           
        public static final By commoditydropdowncasting = By.xpath("//*[@id='select2-drpCom-container']");
    	public static final By groupclassificationcasting = By.xpath("//*[@id='select2-drpSubCom-container']");
    	
		public static final By Alluminiummaxvalue = By
				.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='Aluminum']]//input[@class='max']");

		public static final By coppermaxvalue = By.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='Copper']]//input[@class='max']");

		public static final By silconmaxvalue = By.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='Silicon']]//input[@class='max']\r\n"
				+ "");

		public static final By zincmaxvalue = By.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='Zinc']]//input[@class='max']\r\n"
				+ "");

		

		public static final By iccmaxoverhead = By.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='ICC']]//input[@class='max']\r\n"
				+ "");

		public static final By meltingmaxoverhead = By
				.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='Melting loss']]//input[@class='max']\r\n"
						+ "");


		public static final By fuelconsumable = By.xpath("//tbody[@id='parameterrightsideBody']//tr[td[1][normalize-space()='fuel']]//input[@class='max']\r\n"
				+ "");

		
		public static final By clickconsumableradio = By.xpath("//*[@id='Consumables']");
		public static final By addbtn = By.xpath("//*[@id='addlefttoright']");
		public static final By alloyingradiobtn = By.xpath("//*[@id='alloying']");
		public static final By compositioncheckbox = By.xpath("//table[@id='compListAssnTable']/tbody/tr/td/input");
		public static final By compostionitemsearch = By.xpath("//*[@id='compListAssnTable_filter']/label/input");
		public static final By clickcheckboxcomgrade = By
				.xpath(" //table[@id='gradeListTable']/tbody/tr/td/input[2]");
		public static final By searchclass = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
		public static final By searchcomgrp = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
		public static final By savebtn = By.xpath("//*[@id='SaveParameterDesc']");
		public static final By viewbt = By
				.xpath("//*[@id='2b']/div/div/div/div[1]/div[3]/div/div[2]/div[2]/button[3]");
		public static final By searchbox = By.xpath("//*[@id='compSavedViewListTable_filter']/label/input");
		public static final By overheadradiobtn = By.xpath("//*[@id='Overheads']");
		public static final By consumableradiobtn = By.xpath("//*[@id='Consumables']");
		public static final By clickeditbtncastingalloy = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr/td[5]/a[1]/i");
		public static final By fetchingcommoditygradedata = By.xpath("//table[@id='gradeListTable']/tbody/tr/td[2]");
		public static final By checkboxcommoditygrade = By.xpath("./preceding-sibling::td/input[@type='checkbox']");
		public static final By fetchingaftersearchdataincastingalloyentries = By.xpath("//table[@id='compSavedViewListTable']/tbody/tr/td[4]");		 
        public static final By alloyingheadingname = By.xpath("//*[@id='castingAlloc']/div[3]/label/label"); 
		public static final By alloyingformaxheading = By.xpath("//table[@id='parameterrightside']/tbody/tr/td[normalize-space()='Alloying Elements']");
        public static final By alloyingformaxheadingforcopper = By.xpath("//table[@id='parameterrightside']/tbody/tr[2]/td[normalize-space()='Alloying Elements']");
		public static final By siliconmaxheading = By.xpath("//table[@id='parameterrightside']/tbody/tr[3]/td[normalize-space()='Alloying Elements']");
		public static final By zincmaxheading = By.xpath("//table[@id='parameterrightside']/tbody/tr[4]/td[normalize-space()='Alloying Elements']");
        public static final By ICCheadingformax = By.xpath("//table[@id='parameterrightside']/tbody/tr[5]/td[normalize-space()='Overheads']");
		public static final By meltinglossformxheading = By.xpath("//table[@id='parameterrightside']/tbody/tr[6]/td[normalize-space()='Overheads']");
		public static final By fuelheadingformax = By.xpath("//table[@id='parameterrightside']/tbody/tr[7]/td[normalize-space()='Consumables']");
		
		
		
        public static final By overheadradiobtnheading = By.xpath("//*[@id='castingAlloc']/div[9]/label/label");
        public static final By consumableheading = By.xpath("//*[@id='castingAlloc']/div[4]/label/label");
        
        public static final By selectallradiobtn = By.xpath("//*[@id='selectAllAssnParam']");
		public void savenewcompositionentrt(String enteralmax,String entercoppmax,String entersilmax,String enterzinmax,String entermaxoverheadal,String entermaxcopperoverhead,String entericcmaxoverhead,String entermeltingoverhead,String entersiliconmax,String enterzincoverhead,String enteralconsumble,String entercopperconsumable,String enterfuelconsumble,String enterICCconsumble,String entermeltingconsumble,String entersiliconconsumble,String enterzincconsumble,String customername,String searchboxincastingalloys ) throws InterruptedException {
		
     clickOnElement(commoditydropdowncasting);
	
     clearAndEnterText(waitForExpectedElement(searchcomgrp), "Alloys");
     
     List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
     
     for(WebElement grplist:commdroplistvalue) {
    	 
    	String flagGrp = grplist.getText().trim();
    	
    	if(flagGrp.equalsIgnoreCase("Alloys")) {
    		
    		grplist.click();
    		break;
    	}
    	else {
    		
    		System.out.println("Value is not available in the dropdown...");
    	}
     }
     
     Thread.sleep(4000);
	
     clickOnElement(groupclassificationcasting);
     
     Thread.sleep(3000);
     WebElement shapesearch = waitForExpectedElement(searchclass);
	    clearAndEnterText(shapesearch, "Aluminium");
	    shapesearch.sendKeys(Keys.ENTER);
	    LoggerUtil.info("Entered Shape as: Aluminium");
	    Thread.sleep(5000);
     
	 
	    List<WebElement> commodityGradeList = driver.findElements(fetchingcommoditygradedata);

	    for (WebElement flagGrade : commodityGradeList) {
	        String textGrade = flagGrade.getText().trim();

	        if (textGrade.equals("Alsi9Cu3-" + customername)) {
	            // Find the corresponding checkbox using XPath relative to the matched grade text
	            WebElement checkbox = flagGrade.findElement(By.xpath("./preceding-sibling::td/input[@type='checkbox']"));

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	            wait.until(ExpectedConditions.elementToBeClickable(checkbox));

	            checkbox.click();
	            Thread.sleep(3000);
	            break; // Assuming only one match is expected
	        }
	    }

	    
	
    
     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "copper");
     Thread.sleep(2000);
     clickOnElement(compositioncheckbox);

     Thread.sleep(2000);
     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "silicon");
     Thread.sleep(2000);
     clickOnElement(compositioncheckbox);
     Thread.sleep(3000);
//     waitForExpectedElement(compostionitemsearch).clear();
     Thread.sleep(5000);
     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "aluminum");
     Thread.sleep(2000);
     clickOnElement(compositioncheckbox);
     Thread.sleep(3000);
//     waitForExpectedElement(compostionitemsearch).clear();
     Thread.sleep(5000);
     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "zinc");
     Thread.sleep(2000);
     clickOnElement(compositioncheckbox);
     waitForExpectedElement(compostionitemsearch).clear(); 
     Thread.sleep(4000);

     clickOnElement(compostionitemsearch);
     
     
     String actualheadingnameofradio = waitForExpectedElement(alloyingheadingname).getText();
     String nameheadingofalloying = "Alloying Elements";
     
     if(actualheadingnameofradio.equals(nameheadingofalloying)) {
     clickOnElement(alloyingradiobtn);
     }
     waitForExpectedElement(compostionitemsearch).clear(); 
     Thread.sleep(4000);
     clickOnElement(compostionitemsearch);
     Thread.sleep(6000);
     clickOnElement(addbtn);
     Thread.sleep(4000);
     
       clickOnElement(selectallradiobtn);
       clickOnElement(selectallradiobtn);
   Thread.sleep(3000);
   
   String actualoverheadradiobtn = waitForExpectedElement(overheadradiobtnheading).getText();
   String expectedheading = "Overheads";
   soft.assertEquals(actualoverheadradiobtn, expectedheading);
   
   if(actualoverheadradiobtn.equals(expectedheading)) {
   clickOnElement(overheadradiobtn);
   }
   Thread.sleep(2000);
   
   clearAndEnterText(waitForExpectedElement(compostionitemsearch), "Melting loss");
   Thread.sleep(200);
   clickOnElement(compositioncheckbox);
   Thread.sleep(2000);
   clearAndEnterText(waitForExpectedElement(compostionitemsearch), "ICC");
   Thread.sleep(2000);
   clickOnElement(compositioncheckbox);
    Thread.sleep(3000);
    waitForExpectedElement(compostionitemsearch).clear(); 
    Thread.sleep(4000);
    clickOnElement(compostionitemsearch);
    Thread.sleep(6000);
    clickOnElement(addbtn);
    Thread.sleep(4000);
    clickOnElement(selectallradiobtn);
    clickOnElement(selectallradiobtn);
    Thread.sleep(5000);
    String consumableheadingforRadiobtn = waitForExpectedElement(consumableheading).getText();
    String expectedheadingForConsumable = "Consumables";
    soft.assertEquals(consumableheadingforRadiobtn, expectedheadingForConsumable);
    if(consumableheadingforRadiobtn.equals(expectedheadingForConsumable)) {
    clickOnElement(consumableradiobtn);
    }
    Thread.sleep(2000); 
    clearAndEnterText(waitForExpectedElement(compostionitemsearch), "fuel");
	   Thread.sleep(200);
	   clickOnElement(compositioncheckbox);
	   Thread.sleep(3000);
	    waitForExpectedElement(compostionitemsearch).clear(); 
        Thread.sleep(4000);
        clickOnElement(compostionitemsearch);
        Thread.sleep(6000);
        clickOnElement(addbtn);
    
        clickOnElement(selectallradiobtn);
        clickOnElement(selectallradiobtn);
    Thread.sleep(3000);
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
    
    // Wait for the field to be clickable
//    WebElement inputAlmaxfield = wait1.until(ExpectedConditions.elementToBeClickable(Alluminiummaxvalue));
//    inputAlmaxfield.sendKeys( enteralmax);

    WebElement inputAlmaxfield = waitForExpectedElement(Alluminiummaxvalue);
    clearAndEnterText(inputAlmaxfield, enteralmax);
    inputAlmaxfield.sendKeys(Keys.ENTER);
    
    Thread.sleep(5000);
    
//   // Set the value using JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor) driver;

    Thread.sleep(2000);  // Optional: wait for processing after value is entered

    Thread.sleep(2000);
//    WebElement inputcoppermaxfield=waitForExpectedElement(coppermaxvalue);
//    js.executeScript("arguments[0].value='" + entercoppmax + "';", inputcoppermaxfield);
    
    enterValueAndPressEnter(coppermaxvalue,entercoppmax);

    System.out.println("Entering Copper Max: " + entercoppmax);
    Thread.sleep(2000);
//    WebElement inputsiliconmax=waitForExpectedElement(silconmaxvalue);
//    js.executeScript("arguments[0].value='" + entersilmax + "';", inputsiliconmax);
//    Thread.sleep(2000);
   enterValueAndPressEnter(silconmaxvalue, entersilmax);
    
    Thread.sleep(2000);
//    WebElement inputzincvalue=waitForExpectedElement(zincmaxvalue);
//	    js.executeScript("arguments[0].value='"+ enterzinmax +"';" ,inputzincvalue); 
    
	    
	    enterValueAndPressEnter(zincmaxvalue, enterzinmax);
    Thread.sleep(8000);
    
   
    
//    WebElement inputiccmaxoverhead = waitForExpectedElement(iccmaxoverhead);
//    js.executeScript("arguments[0].value='"+entericcmaxoverhead+"';", inputiccmaxoverhead);
//    Thread.sleep(4000);
    
    enterValueAndPressEnter(iccmaxoverhead, entericcmaxoverhead);
    
//    WebElement inputmeltingmaxoeverhead = waitForExpectedElement(meltingmaxoverhead);
//    js.executeScript("arguments[0].value='"+entermeltingoverhead+"';", inputmeltingmaxoeverhead);
    
    enterValueAndPressEnter(meltingmaxoverhead, entermeltingoverhead);
  
//    WebElement inputfuelconsumable = waitForExpectedElement(fuelconsumable);
//    js.executeScript("arguments[0].value='"+enterfuelconsumble+"';" , inputfuelconsumable);
    
      enterValueAndPressEnter(fuelconsumable, enterfuelconsumble);
    
    Thread.sleep(1800);
    
    
    WebElement savebtncasting = waitForExpectedElement(savebtn);
    js.executeScript("arguments[0].click();",savebtncasting );
    
    Thread.sleep(6000);
    

    Thread.sleep(2000);
    WebElement viewbtncasting = waitForExpectedElement(viewbt);
    js.executeScript("arguments[0].click();",viewbtncasting);
    
    clearAndEnterText(waitForExpectedElement(searchbox), searchboxincastingalloys);
    
    Thread.sleep(4000);
    
    String actualcastingalloydata = waitForExpectedElement(fetchingaftersearchdataincastingalloyentries).getText();
    String expecteddata = "Alsi9Cu3-" + customername;
    
    
    Assert.assertEquals(actualcastingalloydata, expecteddata);
    
    
    
    Thread.sleep(9000);
    clickOnElement(clickeditbtncastingalloy);
    Thread.sleep(6000);
    
    String expectedalllloyingvalue = waitForExpectedElement(alloyingheadingname).getText();
    String actualvalueforalloyingmax = waitForExpectedElement(alloyingformaxheading).getText();
    String aluminiummaxdubblevalue = waitForExpectedElement(Alluminiummaxvalue).getAttribute("value");
    String expectedalminiummaxvalue = enteralmax;
    
    String expectedcoppermaxvalue =entercoppmax;
    String actualvalueforcopper = waitForExpectedElement(coppermaxvalue).getAttribute("value");
   String actualvalueforalloyingformaxcopper = waitForExpectedElement(alloyingformaxheadingforcopper).getText(); 
   
   String actualheadingforsilicon = waitForExpectedElement(siliconmaxheading).getText();
   
   String expectedentermaxvalueforsilicon = entersilmax;
   String actualmaxvalueforsilicon = waitForExpectedElement(silconmaxvalue).getAttribute("value");
   
   
   String actualheadingforzinc = waitForExpectedElement(zincmaxheading).getText();
   String expectedentermaxvalueforzinc = enterzinmax;
   String actualmaxvalueforzinc = waitForExpectedElement(zincmaxvalue).getAttribute("value");
   
   String expectedvalueheadingforoverhead = waitForExpectedElement(overheadradiobtnheading).getText(); 
   String actualheadingformeltingloss = waitForExpectedElement(ICCheadingformax).getText();
   String expectedmaxvalueforICC = entericcmaxoverhead;
   String actualvaluemaxforICC = waitForExpectedElement(iccmaxoverhead).getAttribute("value");
   
   String actualheadingformeltinglossoverhead = waitForExpectedElement(meltinglossformxheading).getText();
   String expectedmaxvalueformeltingloss = entermeltingoverhead;
   String actualmaxvalueformeltingloss = waitForExpectedElement(meltingmaxoverhead).getAttribute("value");
   
   
   String expectedvalueheadingforconsumable = waitForExpectedElement(consumableheading).getText(); 
   String actualheadingforconsumable = waitForExpectedElement(fuelheadingformax).getText();
   String expectedmaxvalueforconsumable = enterfuelconsumble;
   String actualmaxvalueforconsumable = waitForExpectedElement(fuelconsumable).getAttribute("value");
   
   
   
   
   try {
	    if (expectedalllloyingvalue.equals(actualvalueforalloyingmax)) {
	        soft.assertEquals(aluminiummaxdubblevalue, expectedalminiummaxvalue, "Mismatch in Aluminium Max value");
	        LoggerUtil.pass("Aluminium Max Value matched: Expected = " + expectedalminiummaxvalue + ", Actual = " + aluminiummaxdubblevalue);
	    } else {
	        LoggerUtil.mismatch("Alloying header mismatch for Aluminium: Expected = " + expectedalllloyingvalue + ", Actual = " + actualvalueforalloyingmax);
	        soft.fail("Header mismatch for Aluminium");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in Aluminium validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}

	try {
	    if (actualvalueforalloyingformaxcopper.equals(expectedalllloyingvalue)) {
	        soft.assertEquals(expectedcoppermaxvalue, actualvalueforcopper, "Mismatch in Copper Max value");
	        LoggerUtil.pass("Copper Max Value matched: Expected = " + expectedcoppermaxvalue + ", Actual = " + actualvalueforcopper);
	    } else {
	        LoggerUtil.mismatch("Alloying header mismatch for Copper: Expected = " + expectedalllloyingvalue + ", Actual = " + actualvalueforalloyingformaxcopper);
	        soft.fail("Header mismatch for Copper");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in Copper validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}

	try {
	    if (expectedalllloyingvalue.equals(actualheadingforsilicon)) {
	        soft.assertEquals(expectedentermaxvalueforsilicon, actualmaxvalueforsilicon, "Mismatch in Silicon Max value");
	        LoggerUtil.pass("Silicon Max Value matched: Expected = " + expectedentermaxvalueforsilicon + ", Actual = " + actualmaxvalueforsilicon);
	    } else {
	        LoggerUtil.mismatch("Alloying header mismatch for Silicon: Expected = " + expectedalllloyingvalue + ", Actual = " + actualheadingforsilicon);
	        soft.fail("Header mismatch for Silicon");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in Silicon validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}

	try {
	    if (expectedalllloyingvalue.equals(actualheadingforzinc)) {
	        soft.assertEquals(expectedentermaxvalueforzinc, actualmaxvalueforzinc, "Mismatch in Zinc Max value");
	        LoggerUtil.pass("Zinc Max Value matched: Expected = " + expectedentermaxvalueforzinc + ", Actual = " + actualmaxvalueforzinc);
	    } else {
	        LoggerUtil.mismatch("Alloying header mismatch for Zinc: Expected = " + expectedalllloyingvalue + ", Actual = " + actualheadingforzinc);
	        soft.fail("Header mismatch for Zinc");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in Zinc validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}

	try {
	    if (expectedvalueheadingforoverhead.equals(actualheadingformeltingloss)) {
	        soft.assertEquals(expectedmaxvalueforICC, actualvaluemaxforICC, "Mismatch in ICC Max value");
	        LoggerUtil.pass("ICC Max Value matched: Expected = " + expectedmaxvalueforICC + ", Actual = " + actualvaluemaxforICC);
	    } else {
	        LoggerUtil.mismatch("Header mismatch for ICC: Expected = " + expectedvalueheadingforoverhead + ", Actual = " + actualheadingformeltingloss);
	        soft.fail("Header mismatch for ICC");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in ICC validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}

	try {
	    if (expectedvalueheadingforoverhead.equals(actualheadingformeltinglossoverhead)) {
	        soft.assertEquals(expectedmaxvalueformeltingloss, actualmaxvalueformeltingloss, "Mismatch in Melting Loss value");
	        LoggerUtil.pass("Melting Loss Max Value matched: Expected = " + expectedmaxvalueformeltingloss + ", Actual = " + actualmaxvalueformeltingloss);
	    } else {
	        LoggerUtil.mismatch("Header mismatch for Melting Loss: Expected = " + expectedvalueheadingforoverhead + ", Actual = " + actualheadingformeltinglossoverhead);
	        soft.fail("Header mismatch for Melting Loss");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in Melting Loss validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}

	try {
	    if (expectedvalueheadingforconsumable.equals(actualheadingforconsumable)) {
	        soft.assertEquals(expectedmaxvalueforconsumable, actualmaxvalueforconsumable, "Mismatch in Fuel/Consumable Max value");
	        LoggerUtil.pass("Fuel Max Value matched: Expected = " + expectedmaxvalueforconsumable + ", Actual = " + actualmaxvalueforconsumable);
	    } else {
	        LoggerUtil.mismatch("Header mismatch for Fuel: Expected = " + expectedvalueheadingforconsumable + ", Actual = " + actualheadingforconsumable);
	        soft.fail("Header mismatch for Fuel");
	    }
	} catch (Exception e) {
	    LoggerUtil.error("Exception in Fuel validation: " + e.getMessage());
	    soft.fail("Exception: " + e.getMessage());
	}


   
   
   
   
   
   
   
   
   
}
		
		
		public void savenewcompositionentrtForLm_6(String enteralmax,String entercoppmax,String entersilmax,String enterzinmax,String entermaxoverheadal,String entermaxcopperoverhead,String entericcmaxoverhead,String entermeltingoverhead,String entersiliconmax,String enterzincoverhead,String enteralconsumble,String entercopperconsumable,String enterfuelconsumble,String enterICCconsumble,String entermeltingconsumble,String entersiliconconsumble,String enterzincconsumble,String customername,String searchboxincastingalloys ) throws InterruptedException {
			
		     clickOnElement(commoditydropdowncasting);
			
		     clearAndEnterText(waitForExpectedElement(searchcomgrp), "Alloys");
		     
		     List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
		     
		     for(WebElement grplist:commdroplistvalue) {
		    	 
		    	String flagGrp = grplist.getText().trim();
		    	
		    	if(flagGrp.equalsIgnoreCase("Alloys")) {
		    		
		    		grplist.click();
		    		break;
		    	}
		    	else {
		    		
		    		System.out.println("Value is not available in the dropdown...");
		    	}
		     }
		     
		     Thread.sleep(4000);
			
		     clickOnElement(groupclassificationcasting);
		     
		     Thread.sleep(3000);
		     WebElement shapesearch = waitForExpectedElement(searchclass);
			    clearAndEnterText(shapesearch, "Aluminium");
			    shapesearch.sendKeys(Keys.ENTER);
			    LoggerUtil.info("Entered Shape as: Aluminium");
			    Thread.sleep(5000);
		     
			 
			    List<WebElement> commodityGradeList = driver.findElements(fetchingcommoditygradedata);

			    for (WebElement flagGrade : commodityGradeList) {
			        String textGrade = flagGrade.getText().trim();

			        if (textGrade.equals("LM6/25@pooja-" + customername)) {
			            // Find the corresponding checkbox using XPath relative to the matched grade text
			            WebElement checkbox = flagGrade.findElement(By.xpath("./preceding-sibling::td/input[@type='checkbox']"));

			            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			            wait.until(ExpectedConditions.elementToBeClickable(checkbox));

			            checkbox.click();
			            Thread.sleep(3000);
			            break; // Assuming only one match is expected
			        }
			    }

			    
			
		    
		     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "copper");
		     Thread.sleep(2000);
		     clickOnElement(compositioncheckbox);

		     Thread.sleep(2000);
		     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "silicon");
		     Thread.sleep(2000);
		     clickOnElement(compositioncheckbox);
		     Thread.sleep(3000);
//		     waitForExpectedElement(compostionitemsearch).clear();
		     Thread.sleep(5000);
		     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "aluminum");
		     Thread.sleep(2000);
		     clickOnElement(compositioncheckbox);
		     Thread.sleep(3000);
//		     waitForExpectedElement(compostionitemsearch).clear();
		     Thread.sleep(5000);
		     clearAndEnterText(waitForExpectedElement(compostionitemsearch), "zinc");
		     Thread.sleep(2000);
		     clickOnElement(compositioncheckbox);
		     waitForExpectedElement(compostionitemsearch).clear(); 
		     Thread.sleep(4000);

		     clickOnElement(compostionitemsearch);
		     
		     
		     String actualheadingnameofradio = waitForExpectedElement(alloyingheadingname).getText();
		     String nameheadingofalloying = "Alloying Elements";
		     
		     if(actualheadingnameofradio.equals(nameheadingofalloying)) {
		     clickOnElement(alloyingradiobtn);
		     }
		     waitForExpectedElement(compostionitemsearch).clear(); 
		     Thread.sleep(4000);
		     clickOnElement(compostionitemsearch);
		     Thread.sleep(6000);
		     clickOnElement(addbtn);
		     Thread.sleep(4000);
		     
		       clickOnElement(selectallradiobtn);
		       clickOnElement(selectallradiobtn);
		   Thread.sleep(3000);
		   
		   String actualoverheadradiobtn = waitForExpectedElement(overheadradiobtnheading).getText();
		   String expectedheading = "Overheads";
		   soft.assertEquals(actualoverheadradiobtn, expectedheading);
		   
		   if(actualoverheadradiobtn.equals(expectedheading)) {
		   clickOnElement(overheadradiobtn);
		   }
		   Thread.sleep(2000);
		   
		   clearAndEnterText(waitForExpectedElement(compostionitemsearch), "Melting loss");
		   Thread.sleep(200);
		   clickOnElement(compositioncheckbox);
		   Thread.sleep(2000);
		   clearAndEnterText(waitForExpectedElement(compostionitemsearch), "ICC");
		   Thread.sleep(2000);
		   clickOnElement(compositioncheckbox);
		    Thread.sleep(3000);
		    waitForExpectedElement(compostionitemsearch).clear(); 
		    Thread.sleep(4000);
		    clickOnElement(compostionitemsearch);
		    Thread.sleep(6000);
		    clickOnElement(addbtn);
		    Thread.sleep(4000);
		    clickOnElement(selectallradiobtn);
		    clickOnElement(selectallradiobtn);
		    Thread.sleep(5000);
		    String consumableheadingforRadiobtn = waitForExpectedElement(consumableheading).getText();
		    String expectedheadingForConsumable = "Consumables";
		    soft.assertEquals(consumableheadingforRadiobtn, expectedheadingForConsumable);
		    if(consumableheadingforRadiobtn.equals(expectedheadingForConsumable)) {
		    clickOnElement(consumableradiobtn);
		    }
		    Thread.sleep(2000); 
		    clearAndEnterText(waitForExpectedElement(compostionitemsearch), "fuel");
			   Thread.sleep(200);
			   clickOnElement(compositioncheckbox);
			   Thread.sleep(3000);
			    waitForExpectedElement(compostionitemsearch).clear(); 
		        Thread.sleep(4000);
		        clickOnElement(compostionitemsearch);
		        Thread.sleep(6000);
		        clickOnElement(addbtn);
		    
		        clickOnElement(selectallradiobtn);
		        clickOnElement(selectallradiobtn);
		    Thread.sleep(3000);
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		    
		    // Wait for the field to be clickable
//		    WebElement inputAlmaxfield = wait1.until(ExpectedConditions.elementToBeClickable(Alluminiummaxvalue));
//		    inputAlmaxfield.sendKeys( enteralmax);

		    WebElement inputAlmaxfield = waitForExpectedElement(Alluminiummaxvalue);
		    clearAndEnterText(inputAlmaxfield, enteralmax);
		    inputAlmaxfield.sendKeys(Keys.ENTER);
		    
		    Thread.sleep(5000);
		    
		//   // Set the value using JavascriptExecutor
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    Thread.sleep(2000);  // Optional: wait for processing after value is entered

		    Thread.sleep(2000);
//		    WebElement inputcoppermaxfield=waitForExpectedElement(coppermaxvalue);
//		    js.executeScript("arguments[0].value='" + entercoppmax + "';", inputcoppermaxfield);
		    
		    enterValueAndPressEnter(coppermaxvalue,entercoppmax);

		    System.out.println("Entering Copper Max: " + entercoppmax);
		    Thread.sleep(2000);
//		    WebElement inputsiliconmax=waitForExpectedElement(silconmaxvalue);
//		    js.executeScript("arguments[0].value='" + entersilmax + "';", inputsiliconmax);
//		    Thread.sleep(2000);
		   enterValueAndPressEnter(silconmaxvalue, entersilmax);
		    
		    Thread.sleep(2000);
//		    WebElement inputzincvalue=waitForExpectedElement(zincmaxvalue);
//			    js.executeScript("arguments[0].value='"+ enterzinmax +"';" ,inputzincvalue); 
		    
			    
			    enterValueAndPressEnter(zincmaxvalue, enterzinmax);
		    Thread.sleep(8000);
		    
		   
		    
//		    WebElement inputiccmaxoverhead = waitForExpectedElement(iccmaxoverhead);
//		    js.executeScript("arguments[0].value='"+entericcmaxoverhead+"';", inputiccmaxoverhead);
//		    Thread.sleep(4000);
		    
		    enterValueAndPressEnter(iccmaxoverhead, entericcmaxoverhead);
		    
//		    WebElement inputmeltingmaxoeverhead = waitForExpectedElement(meltingmaxoverhead);
//		    js.executeScript("arguments[0].value='"+entermeltingoverhead+"';", inputmeltingmaxoeverhead);
		    
		    enterValueAndPressEnter(meltingmaxoverhead, entermeltingoverhead);
		  
//		    WebElement inputfuelconsumable = waitForExpectedElement(fuelconsumable);
//		    js.executeScript("arguments[0].value='"+enterfuelconsumble+"';" , inputfuelconsumable);
		    
		      enterValueAndPressEnter(fuelconsumable, enterfuelconsumble);
		    
		    Thread.sleep(1800);
		    
		    
		    WebElement savebtncasting = waitForExpectedElement(savebtn);
		    js.executeScript("arguments[0].click();",savebtncasting );
		    
		    Thread.sleep(6000);
		    

		    Thread.sleep(2000);
		    WebElement viewbtncasting = waitForExpectedElement(viewbt);
		    js.executeScript("arguments[0].click();",viewbtncasting);
		    
		    clearAndEnterText(waitForExpectedElement(searchbox), "LM6/25@pooja-"+searchboxincastingalloys);
		    
		    Thread.sleep(4000);
		    
		    String actualcastingalloydata = waitForExpectedElement(fetchingaftersearchdataincastingalloyentries).getText();
		    String expecteddata = "LM6/25@pooja-" + customername;
		    
		    
		    Assert.assertEquals(actualcastingalloydata, expecteddata);
		    
		    
		    
		    Thread.sleep(9000);
		    clickOnElement(clickeditbtncastingalloy);
		    Thread.sleep(6000);
		    
		    String expectedalllloyingvalue = waitForExpectedElement(alloyingheadingname).getText();
		    String actualvalueforalloyingmax = waitForExpectedElement(alloyingformaxheading).getText();
		    String aluminiummaxdubblevalue = waitForExpectedElement(Alluminiummaxvalue).getAttribute("value");
		    String expectedalminiummaxvalue = enteralmax;
		    
		    String expectedcoppermaxvalue =entercoppmax;
		    String actualvalueforcopper = waitForExpectedElement(coppermaxvalue).getAttribute("value");
		   String actualvalueforalloyingformaxcopper = waitForExpectedElement(alloyingformaxheadingforcopper).getText(); 
		   
		   String actualheadingforsilicon = waitForExpectedElement(siliconmaxheading).getText();
		   
		   String expectedentermaxvalueforsilicon = entersilmax;
		   String actualmaxvalueforsilicon = waitForExpectedElement(silconmaxvalue).getAttribute("value");
		   
		   
		   String actualheadingforzinc = waitForExpectedElement(zincmaxheading).getText();
		   String expectedentermaxvalueforzinc = enterzinmax;
		   String actualmaxvalueforzinc = waitForExpectedElement(zincmaxvalue).getAttribute("value");
		   
		   String expectedvalueheadingforoverhead = waitForExpectedElement(overheadradiobtnheading).getText(); 
		   String actualheadingformeltingloss = waitForExpectedElement(ICCheadingformax).getText();
		   String expectedmaxvalueforICC = entericcmaxoverhead;
		   String actualvaluemaxforICC = waitForExpectedElement(iccmaxoverhead).getAttribute("value");
		   
		   String actualheadingformeltinglossoverhead = waitForExpectedElement(meltinglossformxheading).getText();
		   String expectedmaxvalueformeltingloss = entermeltingoverhead;
		   String actualmaxvalueformeltingloss = waitForExpectedElement(meltingmaxoverhead).getAttribute("value");
		   
		   
		   String expectedvalueheadingforconsumable = waitForExpectedElement(consumableheading).getText(); 
		   String actualheadingforconsumable = waitForExpectedElement(fuelheadingformax).getText();
		   String expectedmaxvalueforconsumable = enterfuelconsumble;
		   String actualmaxvalueforconsumable = waitForExpectedElement(fuelconsumable).getAttribute("value");
		   
		   
		   
		   
		   try {
			    if (expectedalllloyingvalue.equals(actualvalueforalloyingmax)) {
			        soft.assertEquals(aluminiummaxdubblevalue, expectedalminiummaxvalue, "Mismatch in Aluminium Max value");
			        LoggerUtil.pass("Aluminium Max Value matched: Expected = " + expectedalminiummaxvalue + ", Actual = " + aluminiummaxdubblevalue);
			    } else {
			        LoggerUtil.mismatch("Alloying header mismatch for Aluminium: Expected = " + expectedalllloyingvalue + ", Actual = " + actualvalueforalloyingmax);
			        soft.fail("Header mismatch for Aluminium");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in Aluminium validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

			try {
			    if (actualvalueforalloyingformaxcopper.equals(expectedalllloyingvalue)) {
			        soft.assertEquals(expectedcoppermaxvalue, actualvalueforcopper, "Mismatch in Copper Max value");
			        LoggerUtil.pass("Copper Max Value matched: Expected = " + expectedcoppermaxvalue + ", Actual = " + actualvalueforcopper);
			    } else {
			        LoggerUtil.mismatch("Alloying header mismatch for Copper: Expected = " + expectedalllloyingvalue + ", Actual = " + actualvalueforalloyingformaxcopper);
			        soft.fail("Header mismatch for Copper");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in Copper validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

			try {
			    if (expectedalllloyingvalue.equals(actualheadingforsilicon)) {
			        soft.assertEquals(expectedentermaxvalueforsilicon, actualmaxvalueforsilicon, "Mismatch in Silicon Max value");
			        LoggerUtil.pass("Silicon Max Value matched: Expected = " + expectedentermaxvalueforsilicon + ", Actual = " + actualmaxvalueforsilicon);
			    } else {
			        LoggerUtil.mismatch("Alloying header mismatch for Silicon: Expected = " + expectedalllloyingvalue + ", Actual = " + actualheadingforsilicon);
			        soft.fail("Header mismatch for Silicon");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in Silicon validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

			try {
			    if (expectedalllloyingvalue.equals(actualheadingforzinc)) {
			        soft.assertEquals(expectedentermaxvalueforzinc, actualmaxvalueforzinc, "Mismatch in Zinc Max value");
			        LoggerUtil.pass("Zinc Max Value matched: Expected = " + expectedentermaxvalueforzinc + ", Actual = " + actualmaxvalueforzinc);
			    } else {
			        LoggerUtil.mismatch("Alloying header mismatch for Zinc: Expected = " + expectedalllloyingvalue + ", Actual = " + actualheadingforzinc);
			        soft.fail("Header mismatch for Zinc");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in Zinc validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

			try {
			    if (expectedvalueheadingforoverhead.equals(actualheadingformeltingloss)) {
			        soft.assertEquals(expectedmaxvalueforICC, actualvaluemaxforICC, "Mismatch in ICC Max value");
			        LoggerUtil.pass("ICC Max Value matched: Expected = " + expectedmaxvalueforICC + ", Actual = " + actualvaluemaxforICC);
			    } else {
			        LoggerUtil.mismatch("Header mismatch for ICC: Expected = " + expectedvalueheadingforoverhead + ", Actual = " + actualheadingformeltingloss);
			        soft.fail("Header mismatch for ICC");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in ICC validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

			try {
			    if (expectedvalueheadingforoverhead.equals(actualheadingformeltinglossoverhead)) {
			        soft.assertEquals(expectedmaxvalueformeltingloss, actualmaxvalueformeltingloss, "Mismatch in Melting Loss value");
			        LoggerUtil.pass("Melting Loss Max Value matched: Expected = " + expectedmaxvalueformeltingloss + ", Actual = " + actualmaxvalueformeltingloss);
			    } else {
			        LoggerUtil.mismatch("Header mismatch for Melting Loss: Expected = " + expectedvalueheadingforoverhead + ", Actual = " + actualheadingformeltinglossoverhead);
			        soft.fail("Header mismatch for Melting Loss");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in Melting Loss validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

			try {
			    if (expectedvalueheadingforconsumable.equals(actualheadingforconsumable)) {
			        soft.assertEquals(expectedmaxvalueforconsumable, actualmaxvalueforconsumable, "Mismatch in Fuel/Consumable Max value");
			        LoggerUtil.pass("Fuel Max Value matched: Expected = " + expectedmaxvalueforconsumable + ", Actual = " + actualmaxvalueforconsumable);
			    } else {
			        LoggerUtil.mismatch("Header mismatch for Fuel: Expected = " + expectedvalueheadingforconsumable + ", Actual = " + actualheadingforconsumable);
			        soft.fail("Header mismatch for Fuel");
			    }
			} catch (Exception e) {
			    LoggerUtil.error("Exception in Fuel validation: " + e.getMessage());
			    soft.fail("Exception: " + e.getMessage());
			}

		   
		   
		   
		   
		   
		   
		   
		   
		   
		}
		
		
		
		
		
		
		
		
		
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


