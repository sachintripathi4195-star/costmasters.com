package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.helper.Base;

public class Commodity_AddCostingPage extends Base {

	
	DashboardPage dashboard = new DashboardPage();
	
	
	public static final By compositionitemname = By.xpath("//input[@id='CompositionName']");
	public static final By symbol = By.xpath("//input[@id='CompositionSymbol']");
	public static final By savebtn = By.xpath("//button[@id='tab4Save']");
	public static final By seacrhbox = By.xpath("//div[@id='compListTable_filter']/label/input[@type='search']");
	public static final By fetchingdatacolumncomponame = By.xpath("//table[@id='compListTable']/tbody/tr/td[2]");
	
	public void savedata(String componame,String symbvalue,String searchvalue) throws InterruptedException {		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symbvalue);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
		String actualvalue = waitForExpectedElement(fetchingdatacolumncomponame).getText();
		String expectedvalue = searchvalue;
         Assert.assertEquals(actualvalue, expectedvalue);    
         Thread.sleep(3000);
         clickOnElement(deletebtn);
         driver.switchTo().alert().accept();
		
		
		
	}
	
	public static final By editbtn = By.xpath("//table[@id='compListTable']/tbody/tr/td[4]/a[1]/i[1]");
	//public static final By saveasnew = By.xpath("//button[@id='tab4Save']");
	public void saveasnew(String compname,String sym,String search,String compname1,String searchvalue1) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), compname);
		clearAndEnterText(waitForExpectedElement(symbol), sym);
		Thread.sleep(1000);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), search);
		Thread.sleep(3000);
		clickOnElement(editbtn);
		Thread.sleep(1000);
		clearAndEnterText(waitForExpectedElement(compositionitemname), compname1);
		clickOnElement(saveasnewbutton);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue1);
		String actualvalue = waitForExpectedElement(fetchingdatacolumncomponame).getText();
		String expectedvalue = searchvalue1;
         Assert.assertEquals(actualvalue, expectedvalue);  
         Thread.sleep(3000);
         clickOnElement(deletebtn);
         driver.switchTo().alert().accept();
		
		
		
	}
	
	
	public void verifysearchfilter(String componame,String symbvalue,String searchvalue) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symbvalue);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
		String actualvalue = waitForExpectedElement(fetchingdatacolumncomponame).getText();
		String expectedvalue = searchvalue;
         Assert.assertEquals(actualvalue, expectedvalue);   
         Thread.sleep(3000);
         clickOnElement(deletebtn);
         driver.switchTo().alert().accept();
		
	
	}
	
	public static final By novaluefound = By.xpath("//table[@id='compListTable']");
	public static final By updatebtn = By.xpath("//button[@id='tab4Save'][1]");
	
	public void verifyupdatebtn(String componame, String symbvalue, String searchvalue, String componame1, String searchvalue1) throws InterruptedException {

	    clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
	    clearAndEnterText(waitForExpectedElement(symbol), symbvalue);
	    clickOnElement(savebtn);

	    Thread.sleep(4000);

	    clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
	    Thread.sleep(3000);
	    clickOnElement(editbtn);
        Thread.sleep(2000);
	    clearAndEnterText(waitForExpectedElement(compositionitemname), componame1);
	    clickOnElement(updatebtn);
          Thread.sleep(4000);
	    clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue1);
	    String actualvalue = waitForExpectedElement(novaluefound).getText();
	   
             Thread.sleep(3000);
	    Assert.assertNotEquals(actualvalue, searchvalue, "Old value should not be present after update.");
	   
	}
    
	public static final By nexpagefetching = By.xpath("//table[@id='compListTable']/tbody/tr/td");
	public static final By nextbtn = By.xpath("//*[@id='compListTable_next']/a");
	public void verifypagination() throws InterruptedException {
		
	clickOnElement(nextbtn);
	Thread.sleep(2000);
	String actualvalue = waitForExpectedElement(nexpagefetching).getText();	
	String expectedvalue = "26";
	Assert.assertEquals(actualvalue,expectedvalue);
		
		
		
	}
	
	public static final By totalrow = By.xpath("//table[@id='compListTable']/tbody/tr/td[1]");
	public static final By countrowdrop = By.xpath("//select[@name='compListTable_length']/option");
	public static final By lengthdropdown = By.xpath("//select[@name='compListTable_length']");
	public void verifytotalcountrow(String value) {

	    // Dropdown se value select karo (jaise 25)
	    List<WebElement> count = driver.findElements(countrowdrop);
	    selectBootStrapDropDown(count, value);

	    // Scroll last row tak kar do taaki lazy-loaded data aa jaye
	    WebElement element = driver.findElement(By.xpath("//table[@id='compListTable']/tbody/tr[last()]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    captureStepScreenshot("User taking screenshot according to Lentgh dropdown value");

	    // Total rows count karo
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='compListTable']/tbody/tr"));
	    String actualvalue = String.valueOf(rows.size());
	    String expectedvalue = value;

	    Assert.assertEquals(actualvalue, expectedvalue);
	}

	
	public void verifytotalcountrow50(String value) {

	    // Dropdown se value select karo (jaise 25)
	    List<WebElement> count = driver.findElements(countrowdrop);
	    selectBootStrapDropDown(count, value);

	    // Scroll last row tak kar do taaki lazy-loaded data aa jaye
	    WebElement element = driver.findElement(By.xpath("//table[@id='compListTable']/tbody/tr[last()]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    captureStepScreenshot("User taking screenshot according to Lentgh dropdown value");

	    // Total rows count karo
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='compListTable']/tbody/tr"));
	    String actualvalue = String.valueOf(rows.size());
	    String expectedvalue = value;

	    Assert.assertEquals(actualvalue, expectedvalue);
	}

	public void verifytotalcountrow75(String value) {

	    // Dropdown se value select karo (jaise 25)
	    List<WebElement> count = driver.findElements(countrowdrop);
	    selectBootStrapDropDown(count, value);

	    // Scroll last row tak kar do taaki lazy-loaded data aa jaye
	    WebElement element = driver.findElement(By.xpath("//table[@id='compListTable']/tbody/tr[last()]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    captureStepScreenshot("User taking screenshot according to Lentgh dropdown value");

	    // Total rows count karo
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='compListTable']/tbody/tr"));
	    String actualvalue = String.valueOf(rows.size());
	    String expectedvalue = value;

	    Assert.assertEquals(actualvalue, expectedvalue);
	}

	public void verifyeditbtn () throws InterruptedException {
		
		
		clickOnElement(editbtn);
		Thread.sleep(3000);
		String actualvalue = waitForExpectedElement(compositionitemname).getAttribute("value");
		Thread.sleep(3000);
		String expectedvalue = waitForExpectedElement(fetchingdatacolumncomponame).getText();
		Assert.assertEquals(actualvalue, expectedvalue);
		
		
		
	}
	
	public void number(String componame,String symbname,String message) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symbname);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
		Thread.sleep(3000);
		
		
		
		
		
		
	}
	public static final By toastmsg = By.xpath("//div[@class='toast-message']");
	public static final By deletebtn = By.xpath("//table[@id='compListTable']/tbody/tr/td[4]/a[2]/i");
	public void deletenewsavecatingvalue(String componame,String symb,String searchvalue,String message) throws InterruptedException {
		
	clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
	clearAndEnterText(waitForExpectedElement(symbol), symb);
	Thread.sleep(3000);
	clickOnElement(savebtn);
	Thread.sleep(3000);
	clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
	Thread.sleep(3000);
	clickOnElement(deletebtn);
	driver.switchTo().alert().accept();
	Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));	
		
		
	}
	
	
	public void saveasnewandDelete(String componame , String symb , String searchvalue, String componame1,String searchvalue1) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		Thread.sleep(3000);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
		Thread.sleep(3000);	
		clickOnElement(editbtn);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame1);
		Thread.sleep(2000);
		clickOnElement(saveasnewbutton);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue1);
		Thread.sleep(3000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
		
		
		
		
		
		
	}
	
	
	
	public void verifyexisistingdatasaveornot(String componame,String symb,String componame1,String symb1,String message) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		driver.navigate().refresh();
        clearAndEnterText(waitForExpectedElement(compositionitemname),componame1);
        clearAndEnterText(waitForExpectedElement(symbol), symb1);
        clickOnElement(savebtn);
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
		
	}
	
	public void savedatahassavedasitisOrnot(String componame,String symb,String searchvalue) {
		
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		clickOnElement(savebtn);
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
		String actualvalue = waitForExpectedElement(fetchingdatacolumncomponame).getText();
		String expectedvalue = searchvalue;
		Assert.assertEquals(actualvalue,expectedvalue);
		
		
		
		
	}
	
	
	
	public void validatepromptmessage(String componame,String symb,String message) {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		clickOnElement(savebtn);
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
		
		
		
	}
	
	public void verifyexistingdatasaveornot(String componame,String symb,String componame1,String symb1,String message) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		driver.navigate().refresh();
        clearAndEnterText(waitForExpectedElement(compositionitemname),componame1);
        clearAndEnterText(waitForExpectedElement(symbol), symb1);
        clickOnElement(savebtn);
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
		
		
		
		
	}
//		ICC
	public void verifydeletedependenciesdata(String searchvalue,String message) throws InterruptedException {
		
		
		clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
		Thread.sleep(3000);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
		Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
		
		
		
		
		
	}
	
	public void verifydeletepromp(String componame,String symb,String searchvalue,String message) throws InterruptedException {
	
	clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
	clearAndEnterText(waitForExpectedElement(symbol), symb);
	Thread.sleep(3000);
	clickOnElement(savebtn);
	Thread.sleep(3000);
	clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
	Thread.sleep(3000);
	clickOnElement(deletebtn);
	driver.switchTo().alert().accept();
	Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));	
		
	
	
}
	
	
	public void verifyupdateprompt(String componame ,String symbvalue,String searchvalue,String componame1,String message) throws InterruptedException {
	
	 clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
    clearAndEnterText(waitForExpectedElement(symbol), symbvalue);
    clickOnElement(savebtn);

    Thread.sleep(4000);

    clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
    Thread.sleep(3000);
    clickOnElement(editbtn);
    Thread.sleep(2000);
    clearAndEnterText(waitForExpectedElement(compositionitemname), componame1);
    clickOnElement(updatebtn);
    Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
      Thread.sleep(4000);
	
	
	
 
	}
	
	public static final By saveasnewbutton = By.xpath("(//button[@id='tab4Save'])[2]");
	
	public void verifysaveasnewprompt(String compname,String sym,String search ,String compname1,String message) throws InterruptedException {
	
	clearAndEnterText(waitForExpectedElement(compositionitemname), compname);
	clearAndEnterText(waitForExpectedElement(symbol), sym);
	Thread.sleep(1000);
	clickOnElement(savebtn);
	Thread.sleep(3000);
	clearAndEnterText(waitForExpectedElement(seacrhbox), search);
	Thread.sleep(3000);
	clickOnElement(editbtn);
	Thread.sleep(1000);
	clearAndEnterText(waitForExpectedElement(compositionitemname), compname1);
	clickOnElement(saveasnewbutton);
	Assert.assertTrue(waitForExpectedElement(toastmsg).getText().contains(message));
	Thread.sleep(9000);
	
	}
	
	
	public static final By resetbtn = By.xpath("//button[@onclick='resetComposition()']");
	public void resetbtn(String compname,String sym,String search) throws InterruptedException {
		
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), compname);
		clearAndEnterText(waitForExpectedElement(symbol), sym);
		Thread.sleep(1000);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(seacrhbox), search);
		Thread.sleep(3000);
		clickOnElement(editbtn);
		Thread.sleep(1000);	
		clickOnElement(resetbtn);
		Thread.sleep(2000);
		String actualValueAfterReset = waitForExpectedElement(compositionitemname).getAttribute("value");
		Assert.assertEquals(actualValueAfterReset, "", "Reset button did not clear the composition name field.");
		
		
		
	}
	
	
	public void saveDataFromClientA(String componame,String symb) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		Thread.sleep(1000);
		clickOnElement(savebtn);
		Thread.sleep(3000);
		
	}
	
  public void saveDataFromClientB(String searchvalue,String componame , String symb) throws InterruptedException {
	  
	  clearAndEnterText(waitForExpectedElement(seacrhbox), searchvalue);
	  captureStepScreenshot("User Wants To check befor saving The data in different client id or client B Should not exist in client B ");
	  clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(symbol), symb);
		Thread.sleep(1000);
		clickOnElement(savebtn);
		Thread.sleep(3000);
	    
	  
  }
	
	public static final By udpdatebutton = By.xpath("(//button[@id='tab4Save'])[1]");
	
	public void EditDataInClientA(String search, String componame ) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(seacrhbox), search);
		Thread.sleep(3000);
		clickOnElement(editbtn);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(compositionitemname), componame);
		clickOnElement(udpdatebutton);
		Thread.sleep(3000);
		
		
		
		
		
	}
	
	
	public void verifyingchangedDataShouldNotchangeInclientB(String search) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(seacrhbox), search);
		Thread.sleep(3000);
		String expectedvalue =  search;
		String actualvalue= waitForExpectedElement(fetchingdatacolumncomponame).getText();		
		Assert.assertEquals(actualvalue, expectedvalue);
		Thread.sleep(2000);
		
		
		
	}
	
	
	public void deleteEditedDataInclientA(String search) throws InterruptedException {
		
		clearAndEnterText(waitForExpectedElement(seacrhbox), search);
		Thread.sleep(3000);
		clickOnElement(deletebtn);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
	}
	
   public void verifydeletedDataShouldNotDeleteInclientB(String search) throws InterruptedException {
	   
	  clearAndEnterText(waitForExpectedElement(seacrhbox), search);
	  Thread.sleep(3000);
	  String expectedvalue =search;
	  String actualvalue = waitForExpectedElement(fetchingdatacolumncomponame).getText();
	  Assert.assertEquals(expectedvalue, actualvalue);
	     
	   
   }
	
	
	
	
	
}
