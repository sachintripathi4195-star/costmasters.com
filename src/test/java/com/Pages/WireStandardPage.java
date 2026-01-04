package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.helper.Base;
import com.helper.LoggerUtil;


public class WireStandardPage extends Base{
	
	public static final By wirename = By.xpath("//input[@id='WireName']");
	public static final By savebtn = By.xpath("//button[@id='tab6Save']");
	public static final By searchinput = By.xpath("//div[@id='commodtiyTable111_filter']/label/input[@type='search']");
	public static final By toastmsg = By.xpath("//*[@id='toast-container']/div/div[2]");
	public static final By fetchingwirenamefromclm = By.xpath("//table[@id='commodtiyTable111']/tbody/tr/td[2]");
	public static final By deletebtn = By.xpath("//*[@id='commodtiyTable111']/tbody/tr[1]/td[3]/a[2]/i");
	public static final By editbtn = By.xpath("//*[@id='commodtiyTable111']/tbody/tr[1]/td[3]/a[1]/i");
	public static final By saveasnewbtn = By.xpath("//*[@id='tab6SaveAsNew']");
	public static final By updatebtn = By.xpath("");
	
	public void savenewwirename(String enterwirename,String entersearchvalue) throws InterruptedException {
		
		SoftAssert soft = new SoftAssert();
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(4000);
		System.out.println(waitForExpectedElement(toastmsg).getText());
		String actualpopup = "Wire Name successfully saved.";
		String expectedpopup = waitForExpectedElement(toastmsg).getText();
        try {
		if(actualpopup.equals(expectedpopup)) {
			
			LoggerUtil.pass("popupmsg is correct");
			System.out.println(waitForExpectedElement(toastmsg).getText());
			clearAndEnterText(waitForExpectedElement(searchinput), entersearchvalue);
			String actualname = waitForExpectedElement(fetchingwirenamefromclm).getText();
			String expectedwirename = entersearchvalue;
			
			soft.assertEquals(actualname, expectedwirename);
			clickOnElement(deletebtn);
			driver.switchTo().alert().accept();
		}
	    
		else {
			 
			LoggerUtil.mismatch("popup msg is incorrect");
			LoggerUtil.mismatch(waitForExpectedElement(toastmsg).getText());
		}
        }catch(Exception e)
        {
        	
        }
		
        
        
		
		soft.assertAll();
		
	}
	
	
	
	
	
	
	public void verifysaveasnewdata(String enterwirename, String enterwirename1) throws InterruptedException {

		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		LoggerUtil.info(waitForExpectedElement(toastmsg).getText());
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		Thread.sleep(2000);
		String actualwirename = waitForExpectedElement(fetchingwirenamefromclm).getText();
		String expectedwire = enterwirename;
		if (actualwirename.equals(expectedwire)) {

			clickOnElement(editbtn);
			clearAndEnterText(waitForExpectedElement(wirename), enterwirename1);
			clickOnElement(saveasnewbtn);
			Thread.sleep(2000);
			clearAndEnterText(waitForExpectedElement(searchinput), enterwirename1);
			String actualwirename1 = waitForExpectedElement(fetchingwirenamefromclm).getText();
			String expecteedwirename1 = enterwirename1;
			if (actualwirename1.equals(expecteedwirename1)) {

				LoggerUtil.pass("The save as new button functionality has been working good...");
				Thread.sleep(2000);
				clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
				Thread.sleep(2000);

				if (actualwirename.equals(expectedwire)) {
					LoggerUtil.pass("Privious value Alread exist..");

				} else {

					LoggerUtil.error("Privious data has not been save.. ");
				}

			} else {

				LoggerUtil.error("data are not save..");

			}

		} else {

			LoggerUtil.error("Wire has not been save or saerching filter is not working good.");
		}

		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		Thread.sleep(1000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename1);
		Thread.sleep(3000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();

	}
	
	public void verifysearchinput(String enetrwirename) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enetrwirename);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(searchinput), enetrwirename);
		Thread.sleep(200);
		String actualwire = waitForExpectedElement(fetchingwirenamefromclm).getText();
		String expectedwire = enetrwirename;
		Assert.assertEquals(actualwire, expectedwire);
		
		
	}
	
	
	
	
	public void verifyupdatefunctionality(String enetrwirename,String enetrwirename1) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enetrwirename);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		Thread.sleep(4000);	
		clearAndEnterText(waitForExpectedElement(searchinput), enetrwirename);
		Thread.sleep(200);
		clickOnElement(editbtn);
		clearAndEnterText(waitForExpectedElement(wirename), enetrwirename1);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchinput), enetrwirename1);
		Thread.sleep(2000);
		String actualvalue = waitForExpectedElement(fetchingwirenamefromclm).getText();
		String expectedvalue = enetrwirename1;
		if(actualvalue.equals(expectedvalue)) {
			
			LoggerUtil.pass("Updated functionality has been working well");
			clearAndEnterText(waitForExpectedElement(searchinput), enetrwirename);
			String actualpriviousvalue = waitForExpectedElement(By.xpath("//*[@id='commodtiyTable111']/tbody/tr/td")).getText();
			String expectedvalue1 = "No matching records found";
			if(actualpriviousvalue.equals(expectedvalue1)){
				LoggerUtil.pass("Privious value before updation does not exisist there");
				
			}else {
				
				LoggerUtil.error("privious data before updation should not exisit there");
			}
			
			
		}else {
			
			LoggerUtil.error("Updated function has not been working well");
		}
		
		
		
		
	}
	
	public static final By nextbtn = By.xpath("//li[@id='commodtiyTable111_next']/a");
	public static final By nextContainer = By.xpath("//li[@id='commodtiyTable111_next']");
	public static final By currentpagerow = By.xpath("//table[@id='commodtiyTable111']/tbody/tr/td");
	
	
	public void pagination() {
		int totalRowCounter = 0;

		for (int page = 1;; page++) {

			List<WebElement> currentPageRows = driver.findElements(currentpagerow);
			int rowCount = currentPageRows.size();

			for (int i = 1; i <= rowCount; i++) {
				totalRowCounter++;
				System.out.println("Row " + totalRowCounter);
			}

			WebElement next = driver.findElement(nextContainer);
			String classValue = next.getAttribute("class");

			if (classValue.contains("disabled")) {
				break;
			}

			int previousCount = rowCount;
			clickOnElement(nextbtn);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(driver -> driver.findElements(currentpagerow).size() != previousCount);
		}

	}

	
	public static final By currentpagerow1 = By.xpath("//table[@id='commodtiyTable111']/tbody/tr/td[1]");
	public static final By validatetotalcountnumber = By.xpath("//select[@name='commodtiyTable111_length' and @aria-controls='commodtiyTable111']");
	public static final By valuescounttable = By.xpath("//select[@name='PackingTable_length']/option");
	public void countingpagelength() throws InterruptedException {

		clickOnElement(validatetotalcountnumber);
		Thread.sleep(2000);
		List<WebElement> countingvalues = driver.findElements(valuescounttable);
		selectBootStrapDropDown(countingvalues, "25");
		List<WebElement> currentPageRows = driver.findElements(currentpagerow1);
		int totalrows = currentPageRows.size();
		String pagerow = String.valueOf(totalrows);

		if (pagerow.equals("25")) {

			LoggerUtil.pass("Total Length of Row in Current Page..." + totalrows);
			LoggerUtil.pass("Page length counting has been passed..." + totalrows);
		}

		else {

			LoggerUtil.error("page length is not working properly");
		}

	}
	
	
	
	
	public void verifydeletenewdata(String enterwirename,String enterseaecgvalue) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterseaecgvalue);
		Thread.sleep(2000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
		LoggerUtil.info(waitForExpectedElement(toastmsg).getText());
		Thread.sleep(3000);
	}
	
	
	public void verifydeletesaveasnewdata(String enterwirename,String enterwirename1) throws InterruptedException {
		
		
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		Thread.sleep(2000);
		clickOnElement(editbtn);
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename1);
		clickOnElement(saveasnewbtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename1);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
	
	public void verifyeditfunctionality(String enterwirename) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(4000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		Thread.sleep(2000);
		clickOnElement(editbtn);
		String actualvalue = waitForExpectedElement(wirename).getAttribute("value");
		String expectedvalue = enterwirename;
		if(actualvalue.equals(expectedvalue)) {
			
			LoggerUtil.pass("Edit button functionality has been working correct.");
			Thread.sleep(2000);
			clickOnElement(deletebtn);
			driver.switchTo().alert().accept();
		}
		else {
			
			LoggerUtil.error("Edit button functionality has not been working correct");
		}
		
	}
	
	public void enterinvaliddata() {
		
		clearAndEnterText(waitForExpectedElement(wirename), "@#%_");
		clickOnElement(savebtn);
		String actualpopup = waitForExpectedElement(toastmsg).getText();
		String expectedpopup = "Please Enter Standard Name.";
		Assert.assertEquals(actualpopup, expectedpopup);		
		
		
	}
	
	
	
	public void enternegativevalues() {
	
	clearAndEnterText(waitForExpectedElement(wirename), "-7385");
	clickOnElement(savebtn);
	String actualpopup = waitForExpectedElement(toastmsg).getText();
	String expectedpopup = "Wire Name already saved.";
	Assert.assertEquals(actualpopup, expectedpopup,"Incorrect Prompt msg");		
	
	}
	
	
	
	
	public void duplicatename(String enterwirename) throws InterruptedException {
		
		
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(5000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		Thread.sleep(2000);
		clickOnElement(editbtn);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		String actualmsg = waitForExpectedElement(toastmsg).getText();
		String expectedmsg = "Wire Name already saved.";
		Assert.assertEquals(actualmsg, expectedmsg,"Duplicate prompt is not correct");
		
	}
	
	
	public void promptdeleteonsucess(String enterwirename) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(6000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
		String actualmsg = waitForExpectedElement(toastmsg).getText();
		String expectedmsg = "Wire Name successfully deleted.";
		Assert.assertEquals(actualmsg, expectedmsg,"Delete Promp msg is not correct");
		System.out.println(actualmsg);
		
	}
	
	
	
	public void verifyupdateprompt(String enetrwirename,String enetrwirename1) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enetrwirename);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		Thread.sleep(4000);	
		clearAndEnterText(waitForExpectedElement(searchinput), enetrwirename);
		Thread.sleep(2000);
		clickOnElement(editbtn);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(wirename), enetrwirename1);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		String actualmsg = waitForExpectedElement(toastmsg).getText();
		String expectedmsg = "Wire Name successfully updated.";
		Assert.assertEquals(actualmsg, expectedmsg);
		System.out.println(waitForExpectedElement(toastmsg).getText());
		
		
		
		
	}
	
	public static final By resetbtn = By.xpath("//*[@id='tab6Clear']");
	public void resetbtnfunctionality(String enterwirename) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
		Thread.sleep(2000);
		clickOnElement(editbtn);
		Thread.sleep(1000);
		clickOnElement(resetbtn);
		String actualvalue = waitForExpectedElement(wirename).getAttribute("value");
		if(actualvalue.isEmpty()) {
			LoggerUtil.pass("reset button functionality is working good,,,");
			
			
		}
		else {
			
			LoggerUtil.error("reset button functionality is not working well");
		}
		
	}
	
	
	public void datasavedinclientA(String enterwirename) throws InterruptedException {
	
		clearAndEnterText(waitForExpectedElement(wirename), enterwirename);
		Thread.sleep(2000);
		clickOnElement(savebtn);
		Thread.sleep(2000);
	 	
		
		
	}
	
	public static final By fetchingdataindifferentclient = By.xpath("//*[@id='commodtiyTable111']/tbody/tr/td");
  public void datasaveinclientB(String enetrwirename) throws InterruptedException {
	  
	  clearAndEnterText(waitForExpectedElement(searchinput), enetrwirename);
	  String actualvalue = waitForExpectedElement(fetchingdataindifferentclient).getText();
	  if(!enetrwirename.equals(actualvalue)) {
		  
		  LoggerUtil.pass("first client data is not getting in different client i'd...");
		  Thread.sleep(3000);
	  }
	  else {
		  
		  
		  LoggerUtil.error("first client data is getting ...");
	  }
	  
	  
  }
  
	public void EditAndUpdatedatainclientA(String enetersearchvalue,String enetrwirename) throws InterruptedException {
		
	clearAndEnterText(waitForExpectedElement(searchinput), enetersearchvalue);
	Thread.sleep(2000);
	clickOnElement(editbtn);
	clearAndEnterText(waitForExpectedElement(wirename), enetrwirename);
	Thread.sleep(2000);
	clickOnElement(savebtn);
	
		
		
	}
  
  
  public void verifysaveasnewdatainfirstclient(String enterwirename,String enternewwire) throws InterruptedException {
	  
	  clearAndEnterText(waitForExpectedElement(searchinput), enterwirename);
	  Thread.sleep(2000);
	  clickOnElement(editbtn);
	  Thread.sleep(2000);
	  clearAndEnterText(waitForExpectedElement(wirename), enternewwire);
	  Thread.sleep(2000);
	  clickOnElement(saveasnewbtn);
	  Thread.sleep(3000);
	  clearAndEnterText(waitForExpectedElement(searchinput), enternewwire);
	  Thread.sleep(2000);
	  String actualString = waitForExpectedElement(fetchingwirenamefromclm).getText();
	  String expectedstring = enternewwire;
	  if(actualString.equals(expectedstring)) {
		  
		  LoggerUtil.pass("Save as new has been sucessfully saved");
	  }
	  else {
		  
		  LoggerUtil.error("There is some kind of error  save as new data is not fetching ");
	  }
	  
  }
   
  
  
  
  
  
  
  
  
  
	

}
