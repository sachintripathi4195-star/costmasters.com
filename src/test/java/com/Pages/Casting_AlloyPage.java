package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.helper.Base;
import com.helper.LoggerUtil;

public class Casting_AlloyPage extends Base{
	
	SoftAssert sf = new SoftAssert();
	
	public static final By commoditydropdown = By.xpath("//*[@id='select2-drpCom-container']");
	public static final By groupclassification = By.xpath("//*[@id='select2-drpSubCom-container']");
	
	
	
	public void verifyplaceholdervalue() {
	    // Use explicit wait instead of Thread.sleep
	  
		try {
		WebElement commodityElement = waitForExpectedElement(commoditydropdown);
	    String actualvalue = commodityElement.getAttribute("title");
	    String expectedcondition = "Select";
	    
	    // Log actual and expected values for debugging
	    System.out.println("Actual Placeholder Title: " + actualvalue);
	    System.out.println("Expected Placeholder Title: " + expectedcondition);
	    
	    // Perform Soft Assertion
	    sf.assertEquals(actualvalue, expectedcondition, "Placeholder title is incorrect.");
		}
	    catch(Exception e)
		{
	    	LoggerUtil.info(e.getMessage());
	    	
		}
		try {
		// Another explicit wait for the second element (no sleep)
	    WebElement groupElement = waitForExpectedElement(groupclassification);
	    String actualclass = groupElement.getText();
	    String expectedclassvalue = "Select";
	    
	    // Log actual and expected values for debugging
	    System.out.println("Actual Group Classification: " + actualclass);
	    System.out.println("Expected Group Classification: " + expectedclassvalue);
	    
	    // Perform Soft Assertion
	    sf.assertEquals(actualclass, expectedclassvalue, "Group classification is incorrect.");
		}
		
		catch(Exception e)
		{
			LoggerUtil.mismatch("Group Classification value is mimatched...");
		}
	    // Final assertion check
	    sf.assertAll();  // This will report all the failed assertions at once
	}

	
	
	public static final By Alluminiummaxvalue = By.xpath("//table[@id='parameterrightside']/tbody/tr[1]/td[5]/input");
	
	public static final By coppermaxvalue = By.xpath("//table[@id='parameterrightside']/tbody/tr[2]/td[5]/input");
	
	public static final By silconmaxvalue = By.xpath("//table[@id='parameterrightside']/tbody/tr[3]/td[5]/input");
	
	public static final By zincmaxvalue = By.xpath("//table[@id='parameterrightside']/tbody/tr[4]/td[5]/input");
	
	public static final By alluminiumMaxoverhead = By.xpath("//table[@id='parameterrightside']/tbody/tr[5]/td[5]/input");
	
	public static final By coppermaxoverhead = By.xpath("//table[@id='parameterrightside']/tbody/tr[6]/td[5]/input");
	
	public static final By iccmaxoverhead = By.xpath("//table[@id='parameterrightside']/tbody/tr[7]/td[5]/input");
	
	public static final By meltingmaxoverhead = By.xpath("//table[@id='parameterrightside']/tbody/tr[8]/td[5]/input");
	
	public static final By siliconmaxoverhead = By.xpath("//table[@id='parameterrightside']/tbody/tr[9]/td[5]/input");
	
	public static final By zincmaxoverhead = By.xpath("//table[@id='parameterrightside']/tbody/tr[10]/td[5]/input");
	
	public static final By aluminumconsumble = By.xpath("//table[@id='parameterrightside']/tbody/tr[11]/td[5]/input");
	
	public static final By copperconsumble = By.xpath("//table[@id='parameterrightside']/tbody/tr[12]/td[5]/input");
	
	public static final By fuelconsumable = By.xpath("//table[@id='parameterrightside']/tbody/tr[13]/td[5]/input");
	
	public static final By ICCconsumable = By.xpath("//table[@id='parameterrightside']/tbody/tr[14]/td[5]/input");
	
	public static final By meltinglossconsumable = By.xpath("//table[@id='parameterrightside']/tbody/tr[15]/td[5]/input");
	
	public static final By siliconconsumable = By.xpath("//table[@id='parameterrightside']/tbody/tr[16]/td[5]/input");
	
	public static final By zincconsumable =By.xpath("//table[@id='parameterrightside']/tbody/tr[17]/td[5]/input");
	
	
	
	
	public static final By clickconsumableradio = By.xpath("//*[@id='Consumables']");
	public static final By addbtn = By.xpath("//*[@id='addlefttoright']");
	public static final By alloyingradiobtn = By.xpath("//*[@id='alloying']");
	public static final By compositioncheckbox = By.xpath("//table[@id='compListAssnTable']/tbody/tr/td/input");
	public static final By compostionitemsearch = By.xpath("//*[@id='compListAssnTable_filter']/label/input");
    public static final By clickcheckboxcomgrade = By.xpath("//table[@id='gradeListTable']/tbody/tr[23]/td/input[2]");   
	public static final By searchclass = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By searchcomgrp = By.xpath("//*[@id='page-top']/span/span/span[1]/input");
	public static final By savebtn = By.xpath("//*[@id='SaveParameterDesc']");
	public static final By viewbtn = By.xpath("//*[@id='2b']/div/div/div/div[1]/div[3]/div/div[2]/div[2]/button[3]");
	public static final By searchbox = By.xpath("//*[@id='compSavedViewListTable_filter']/label/input");
	public static final By overheadradiobtn = By.xpath("//*[@id='Overheads']");
	public static final By consumableradiobtn = By.xpath("//*[@id='Consumables']");
	public static final By clickeditbtn = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr/td[5]/a[1]/i");
	public void savenewcompositionentrt(String enteralmax,String entercoppmax,String entersilmax,String enterzinmax,String entermaxoverheadal,String entermaxcopperoverhead,String entericcmaxoverhead,String entermeltingoverhead,String entersiliconmax,String enterzincoverhead,String enteralconsumble,String entercopperconsumable,String enterfuelconsumble,String enterICCconsumble,String entermeltingconsumble,String entersiliconconsumble,String enterzincconsumble ) throws InterruptedException {
		
	     clickOnElement(commoditydropdown);
		
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
		
         clickOnElement(groupclassification);
         
         Thread.sleep(3000);
         clearAndEnterText(waitForExpectedElement(searchclass),"Aluminium");
         Thread.sleep(200);
         List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

         for(WebElement classificationlist:claslist) {
        	 
        	 String flagclss = classificationlist.getText().trim();
        	 
        	 if(flagclss.equalsIgnoreCase("Aluminium")) {
        		 classificationlist.click();
        		 break;
        		 
        	 }
        	  
         }
        clickOnElement(clickcheckboxcomgrade);
        Thread.sleep(3000);
        
         clearAndEnterText(waitForExpectedElement(compostionitemsearch), "copper");
         Thread.sleep(2000);
         clickOnElement(compositioncheckbox);
    
         Thread.sleep(2000);
         clearAndEnterText(waitForExpectedElement(compostionitemsearch), "silicon");
         Thread.sleep(2000);
         clickOnElement(compositioncheckbox);
         Thread.sleep(3000);
//         waitForExpectedElement(compostionitemsearch).clear();
         Thread.sleep(5000);
         clearAndEnterText(waitForExpectedElement(compostionitemsearch), "aluminum");
         Thread.sleep(2000);
         clickOnElement(compositioncheckbox);
         Thread.sleep(3000);
//         waitForExpectedElement(compostionitemsearch).clear();
         Thread.sleep(5000);
         clearAndEnterText(waitForExpectedElement(compostionitemsearch), "zinc");
         Thread.sleep(2000);
         clickOnElement(compositioncheckbox);
         waitForExpectedElement(compostionitemsearch).clear(); 
         Thread.sleep(4000);
         clickOnElement(compostionitemsearch);
         
         clickOnElement(alloyingradiobtn);
         waitForExpectedElement(compostionitemsearch).clear(); 
         Thread.sleep(4000);
         clickOnElement(compostionitemsearch);
         Thread.sleep(6000);
         clickOnElement(addbtn);
           
	   Thread.sleep(3000);
	   clickOnElement(overheadradiobtn);
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
	    Thread.sleep(2000);
	    clickOnElement(consumableradiobtn);
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
	    
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // Wait for the field to be clickable
        WebElement inputAlmaxfield = wait.until(ExpectedConditions.elementToBeClickable(Alluminiummaxvalue));
        inputAlmaxfield.sendKeys( enteralmax);

//       // Set the value using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(2000);  // Optional: wait for processing after value is entered

        Thread.sleep(2000);
        WebElement inputcoppermaxfield=waitForExpectedElement(coppermaxvalue);
        js.executeScript("arguments[0].value='" + entercoppmax + "';", inputcoppermaxfield);

        Thread.sleep(2000);
        WebElement inputsiliconmax=waitForExpectedElement(silconmaxvalue);
        js.executeScript("arguments[0].value='" + entersilmax + "';", inputsiliconmax);
        Thread.sleep(2000);

        Thread.sleep(2000);
        WebElement inputzincvalue=waitForExpectedElement(zincmaxvalue);
  	    js.executeScript("arguments[0].value='"+ enterzinmax +"';" ,inputzincvalue); 
	    
	    Thread.sleep(8000);
	    
	    WebElement inputoverheadAl = waitForExpectedElement(alluminiumMaxoverhead);
	    js.executeScript("arguments[0].value='"+entermaxoverheadal+"';",inputoverheadAl);
	    
	    WebElement inputcopperoverhead = waitForExpectedElement(coppermaxoverhead);
	    js.executeScript("arguments[0].value='"+entermaxcopperoverhead+"';", inputcopperoverhead);
	    
	    WebElement inputiccmaxoverhead = waitForExpectedElement(iccmaxoverhead);
	    js.executeScript("arguments[0].value='"+entericcmaxoverhead+"';", inputiccmaxoverhead);
	    
	    WebElement inputmeltingmaxoeverhead = waitForExpectedElement(meltingmaxoverhead);
	    js.executeScript("arguments[0].value='"+entermeltingoverhead+"';", inputmeltingmaxoeverhead);
	    
	    WebElement inputsiliconmaxoverhead = waitForExpectedElement(siliconmaxoverhead);
	    js.executeScript("arguments[0].value='"+entersiliconmax+"';", inputsiliconmaxoverhead);
	    
	    WebElement inputzincmaxoverhead = waitForExpectedElement(zincmaxoverhead);
	    js.executeScript("arguments[0].value='"+enterzincoverhead+"';", inputzincmaxoverhead);
	    
	    WebElement inputaAlconsumble = waitForExpectedElement(aluminumconsumble);
	    js.executeScript("arguments[0].value='"+enteralconsumble+"';", inputaAlconsumble);
	    
	    WebElement inputcopperconsumabel = waitForExpectedElement(copperconsumble);
	    js.executeScript("arguments[0].value='"+entercopperconsumable+"';", inputcopperconsumabel);
	    
	    WebElement inputfuelconsumable = waitForExpectedElement(fuelconsumable);
	    js.executeScript("arguments[0].value='"+enterfuelconsumble+"';" , inputfuelconsumable);
	    
	    WebElement inputICCconsumable = waitForExpectedElement(ICCconsumable);
	    js.executeScript("arguments[0].value='"+enterICCconsumble+"';" , inputICCconsumable);
	    
	    WebElement inputMeltinglsosconsumable = waitForExpectedElement(meltinglossconsumable);
	    js.executeScript("arguments[0].value='"+entermeltingconsumble+"';" , inputMeltinglsosconsumable);
	    
	    WebElement inputsiliconconsumable = waitForExpectedElement(siliconconsumable);
	    js.executeScript("arguments[0].value='"+entersiliconconsumble+"';" , inputsiliconconsumable);
	    
	    WebElement inputzincconsumable = waitForExpectedElement(zincconsumable);
	    js.executeScript("arguments[0].value='"+enterzincconsumble+"';" , inputzincconsumable);
	    
	    Thread.sleep(1800);
	    
	    
	    WebElement savebtncasting = waitForExpectedElement(savebtn);
	    js.executeScript("arguments[0].click();",savebtncasting );
	    
	    Thread.sleep(6000);
	    
//	    LM25-POOJA CASTINGS PVT LTD
	    Thread.sleep(2000);
	    WebElement viewbtncasting = waitForExpectedElement(viewbtn);
	    js.executeScript("arguments[0].click();",viewbtncasting);
	    
	    clearAndEnterText(waitForExpectedElement(searchbox), "LM25-POOJA CASTINGS PVT LTD");
	    
	    Thread.sleep(4000);
	    
	    clickOnElement(clickeditbtn);
	    Thread.sleep(3000);
	    
	   
	   
	    
	}
	
	
	public static final By updatebtn = By.xpath("//*[@id='SaveParameterDesc']");
	public void SaveAndupdatedata(String enteralmax,String entercoppmax,String entersilmax,String enterzinmax,String entermaxoverheadal,String entermaxcopperoverhead,String entericcmaxoverhead,String entermeltingoverhead,String entersiliconmax,String enterzincoverhead,String enteralconsumble,String entercopperconsumable,String enterfuelconsumble,String enterICCconsumble,String entermeltingconsumble,String entersiliconconsumble,String enterzincconsumble) throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
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
		
        clickOnElement(groupclassification);
        
        Thread.sleep(3000);
        clearAndEnterText(waitForExpectedElement(searchclass),"Aluminium");
        Thread.sleep(200);
        List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

        for(WebElement classificationlist:claslist) {
       	 
       	 String flagclss = classificationlist.getText().trim();
       	 
       	 if(flagclss.equalsIgnoreCase("Aluminium")) {
       		 classificationlist.click();
       		 break;
       		 
       	 }
       	  
        }
       clickOnElement(clickcheckboxcomgrade);
       Thread.sleep(3000);
       
        clearAndEnterText(waitForExpectedElement(compostionitemsearch), "copper");
        Thread.sleep(2000);
        clickOnElement(compositioncheckbox);
   
        Thread.sleep(2000);
        clearAndEnterText(waitForExpectedElement(compostionitemsearch), "silicon");
        Thread.sleep(2000);
        clickOnElement(compositioncheckbox);
        Thread.sleep(3000);
//        waitForExpectedElement(compostionitemsearch).clear();
        Thread.sleep(5000);
        clearAndEnterText(waitForExpectedElement(compostionitemsearch), "aluminum");
        Thread.sleep(2000);
        clickOnElement(compositioncheckbox);
        Thread.sleep(3000);
//        waitForExpectedElement(compostionitemsearch).clear();
        Thread.sleep(5000);
        clearAndEnterText(waitForExpectedElement(compostionitemsearch), "zinc");
        Thread.sleep(2000);
        clickOnElement(compositioncheckbox);
        waitForExpectedElement(compostionitemsearch).clear(); 
        Thread.sleep(4000);
        clickOnElement(compostionitemsearch);
        
        clickOnElement(alloyingradiobtn);
        waitForExpectedElement(compostionitemsearch).clear(); 
        Thread.sleep(4000);
        clickOnElement(compostionitemsearch);
        Thread.sleep(6000);
        clickOnElement(addbtn);
          
	   Thread.sleep(3000);
	   clickOnElement(overheadradiobtn);
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
	    Thread.sleep(2000);
	    clickOnElement(consumableradiobtn);
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
	    
       Thread.sleep(3000);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       
       // Wait for the field to be clickable
       WebElement inputAlmaxfield = wait.until(ExpectedConditions.elementToBeClickable(Alluminiummaxvalue));
       inputAlmaxfield.sendKeys( enteralmax);

//      // Set the value using JavascriptExecutor
       JavascriptExecutor js = (JavascriptExecutor) driver;

       Thread.sleep(2000);  // Optional: wait for processing after value is entered

       Thread.sleep(2000);
       WebElement inputcoppermaxfield=waitForExpectedElement(coppermaxvalue);
       js.executeScript("arguments[0].value='" + entercoppmax + "';", inputcoppermaxfield);

       Thread.sleep(2000);
       WebElement inputsiliconmax=waitForExpectedElement(silconmaxvalue);
       js.executeScript("arguments[0].value='" + entersilmax + "';", inputsiliconmax);
       Thread.sleep(2000);

       Thread.sleep(2000);
       WebElement inputzincvalue=waitForExpectedElement(zincmaxvalue);
 	    js.executeScript("arguments[0].value='"+ enterzinmax +"';" ,inputzincvalue); 
	    
	    Thread.sleep(8000);
	    
	    WebElement inputoverheadAl = waitForExpectedElement(alluminiumMaxoverhead);
	    js.executeScript("arguments[0].value='"+entermaxoverheadal+"';",inputoverheadAl);
	    
	    WebElement inputcopperoverhead = waitForExpectedElement(coppermaxoverhead);
	    js.executeScript("arguments[0].value='"+entermaxcopperoverhead+"';", inputcopperoverhead);
	    
	    WebElement inputiccmaxoverhead = waitForExpectedElement(iccmaxoverhead);
	    js.executeScript("arguments[0].value='"+entericcmaxoverhead+"';", inputiccmaxoverhead);
	    
	    WebElement inputmeltingmaxoeverhead = waitForExpectedElement(meltingmaxoverhead);
	    js.executeScript("arguments[0].value='"+entermeltingoverhead+"';", inputmeltingmaxoeverhead);
	    
	    WebElement inputsiliconmaxoverhead = waitForExpectedElement(siliconmaxoverhead);
	    js.executeScript("arguments[0].value='"+entersiliconmax+"';", inputsiliconmaxoverhead);
	    
	    WebElement inputzincmaxoverhead = waitForExpectedElement(zincmaxoverhead);
	    js.executeScript("arguments[0].value='"+enterzincoverhead+"';", inputzincmaxoverhead);
	    
	    WebElement inputaAlconsumble = waitForExpectedElement(aluminumconsumble);
	    js.executeScript("arguments[0].value='"+enteralconsumble+"';", inputaAlconsumble);
	    
	    WebElement inputcopperconsumabel = waitForExpectedElement(copperconsumble);
	    js.executeScript("arguments[0].value='"+entercopperconsumable+"';", inputcopperconsumabel);
	    
	    WebElement inputfuelconsumable = waitForExpectedElement(fuelconsumable);
	    js.executeScript("arguments[0].value='"+enterfuelconsumble+"';" , inputfuelconsumable);
	    
	    WebElement inputICCconsumable = waitForExpectedElement(ICCconsumable);
	    js.executeScript("arguments[0].value='"+enterICCconsumble+"';" , inputICCconsumable);
	    
	    WebElement inputMeltinglsosconsumable = waitForExpectedElement(meltinglossconsumable);
	    js.executeScript("arguments[0].value='"+entermeltingconsumble+"';" , inputMeltinglsosconsumable);
	    
	    WebElement inputsiliconconsumable = waitForExpectedElement(siliconconsumable);
	    js.executeScript("arguments[0].value='"+entersiliconconsumble+"';" , inputsiliconconsumable);
	    
	    WebElement inputzincconsumable = waitForExpectedElement(zincconsumable);
	    js.executeScript("arguments[0].value='"+enterzincconsumble+"';" , inputzincconsumable);
	    
	    Thread.sleep(1800);
	    
	    
	    WebElement savebtncasting = waitForExpectedElement(savebtn);
	    js.executeScript("arguments[0].click();",savebtncasting );
	    
	    Thread.sleep(6000);
	    
//	    LM25-POOJA CASTINGS PVT LTD
	    Thread.sleep(2000);
	    WebElement viewbtncasting = waitForExpectedElement(viewbtn);
	    js.executeScript("arguments[0].click();",viewbtncasting);
	    
	    clearAndEnterText(waitForExpectedElement(searchbox), "LM25-POOJA CASTINGS PVT LTD");
	    
	    Thread.sleep(4000);
	    
	    clickOnElement(clickeditbtn);
	    Thread.sleep(6000);
	    
	    WebElement inputAlmaxfield1 = wait.until(ExpectedConditions.elementToBeClickable(Alluminiummaxvalue));
	     clearAndEnterText(waitForExpectedElement(Alluminiummaxvalue), "78.1234");
	    Thread.sleep(6000);
	   clickOnElement(updatebtn);
		
	   Thread.sleep(2000);
	 
	    js.executeScript("arguments[0].click();",viewbtncasting);
	    
	    Thread.sleep(5000);
        clearAndEnterText(waitForExpectedElement(searchbox), "LM25-POOJA CASTINGS PVT LTD");
	    
	    Thread.sleep(6000);
	    
	    clickOnElement(clickeditbtn);
	    Thread.sleep(10000);
	    
	    
	}
	
	public static final By fetchingandverifyvalue = By.xpath("//*[@id='compListAssnTable']/tbody/tr/td[2]");
	public static final By searchinputvalueforcomposition = By.xpath("//*[@id='compListAssnTable_filter']/label/input");
	public void searchcompositionitemverifysearchfilter() throws InterruptedException {
	   
		    clearAndEnterText(waitForExpectedElement(searchinputvalueforcomposition), "zinc");
		    Thread.sleep(3000);
		    String actualvaluecompositionvlaue = waitForExpectedElement(fetchingandverifyvalue).getText();
		    String expectedcompositionvalue = "zinc";
		  try {
		    if(actualvaluecompositionvlaue.equalsIgnoreCase(expectedcompositionvalue)) {
		    	
		    	LoggerUtil.pass("values Are Matched SucessFully .." +"actualvalue = " + actualvaluecompositionvlaue + "  expectedvalue  = " + expectedcompositionvalue);
		    }
		    
		    else {
		    	
		    	LoggerUtil.mismatch("searchfilter is not working well.."+ "actual value = "+  actualvaluecompositionvlaue +  "  expectedvalue =  " +  expectedcompositionvalue  );
		    }
		  }
		  catch(Exception e)
		  {
			  
			  
			  
		  }
		  
		  
		  clearAndEnterText(waitForExpectedElement(searchinputvalueforcomposition), "Copper");
		  Thread.sleep(3000);
		  String actualvalueofcompo =waitForExpectedElement(fetchingandverifyvalue).getText();
		  String expectedvalue = "copper";
		  
		  
		 try { 
		  if(actualvalueofcompo.equalsIgnoreCase(expectedvalue)) {
			  
			  LoggerUtil.pass("values Are Matched SucessFully .." +"actualvalue =  " + actualvalueofcompo  + " expectedvalue  = " + expectedvalue);
		  }
		  
		  else {
			  
			  
			  LoggerUtil.mismatch("searchfilter is not working well.."+ "actual value = " +  actualvalueofcompo + "  expectedvalue =  " +  expectedvalue  );
		  }
		 }
		 catch(Exception e)
		 {
			 
			 
			 
		 }
		  
		 
		  }
	
	
	public static final By fetchingviewcommgrpvalue = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr[1]/td[2]");
	public void verifysearhfiletr() throws InterruptedException {
		
		
		clickOnElement(viewbtn);
		Thread.sleep(3000);
		clearAndEnterText(waitForExpectedElement(searchbox), "Ferrous Metals ");
		String actualvalueoftable = waitForExpectedElement(fetchingviewcommgrpvalue).getText();
		String expectedvalueoftable = "Ferrous Metals";
		try {
		if(actualvalueoftable.equalsIgnoreCase(expectedvalueoftable)){
			
			LoggerUtil.pass("Values are matched = " +"Actual value = " + actualvalueoftable + "  Expected value =  " +  expectedvalueoftable );
			
		}
		
		else {
			
			LoggerUtil.mismatch("values Are not matched =  "+ " Actual Value = " +actualvalueoftable + " Expected Value = "+ expectedvalueoftable);
		}
		}
		
		catch(Exception e) {
			
			
			
		}
		
		
	}
	
	public static final By calculationnumberofrows = By.xpath("//*[@id=\"compSavedViewListTable\"]/tbody/tr/td[1]");
	public static final By clicknumberofcountpages = By.xpath("//*[@id='compSavedViewListTable_length']/label/select");
	

	public void pagecounting(String value) throws InterruptedException {
		 clickOnElement(viewbtn);
		 Thread.sleep(5000);
	    clickOnElement(clicknumberofcountpages);
	    
	    
	    Thread.sleep(3000);
	    List<WebElement> numberOfDropdownValue = driver.findElements(By.xpath("//*[@id='compSavedViewListTable_length']/label/select/option"));
	    selectBootStrapDropDown(numberOfDropdownValue, value);
	    Thread.sleep(3000);  // Allow time for pagination to reflect new value

	    List<WebElement> numberOfRows = driver.findElements(calculationnumberofrows);
	    
	    
	    int expectedRowCount = Integer.parseInt(value);
	    
	    if (numberOfRows.size() == expectedRowCount) {
	        LoggerUtil.pass("Pagination matches expected value: " + value);
	    } else {
	        LoggerUtil.mismatch("Pagination does not match expected value. Expected: " + value + ", Actual: " + numberOfRows.size());
	    }
	}
	
	// Element locators
	public static final By dropdownPageSize = By.xpath("//*[@id='compSavedViewListTable_length']/label/select");
	public static final By nextButton = By.xpath("//*[@id='compSavedViewListTable_next']/a");
	public static final By firstRowSerialNumber = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr[1]/td[1]");

	public void verifyPaginationStartsFrom26() throws InterruptedException {

		 clickOnElement(viewbtn);
		 Thread.sleep(5000);
	    // Set page size to 25 entries per page
	    clickOnElement(dropdownPageSize);
	    List<WebElement> options = driver.findElements(By.xpath("//*[@id='compSavedViewListTable_length']/label/select/option"));
	    selectBootStrapDropDown(options, "25");
	    
	    // Explicit wait for page to load 25 rows
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='compSavedViewListTable']/tbody/tr"), 25));

	    // Click Next button
	    if(waitForExpectedElement(nextButton).isEnabled()) {
	        clickOnElement(nextButton);

	        // Wait for next page to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowSerialNumber));

	        // Verify the first row serial number on second page is 26
	        String firstSerialNumberOnNextPage = waitForExpectedElement(firstRowSerialNumber).getText();

	        if (firstSerialNumberOnNextPage.equals("26")) {
	            LoggerUtil.pass("Pagination working correctly, next page starts from entry 26.");
	        } else {
	            LoggerUtil.mismatch("Pagination mismatch, expected entry 26 but found: " + firstSerialNumberOnNextPage);
	        }
	    } else {
	    	LoggerUtil.mismatch("Next button is disabled, cannot move to next page.");
	    }
	}
    
	
	
	public static final By compositionlistitemchekbox2 = By.xpath("//*[@id='1174']");
	public static final By compositionlistitemchekbox = By.xpath("//*[@id='1175']");
	public static final By toastmessage = By.xpath("//*[@id='toast-container']/div/div[2]");
	//Composition item successfully deleted.
	//adolph
	//marth
	public static final By compositionitemlistaddbtn = By.xpath("//*[@id='addlefttoright']");
	public static final By deletebtn = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr[1]/td[5]/a[2]/i");
	public static final By specificgrade = By.xpath("//div[@id='gradeAssnList']/table/tbody/tr/td/input[2]");
	public void deletevalidation(String message) throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "adolph");
	     
       List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
       
       for(WebElement grplist:commdroplistvalue) {
      	 
      	String flagGrp = grplist.getText().trim();
      	
      	if(flagGrp.equalsIgnoreCase("adolph")) {
      		
      		grplist.click();
      		break;
      	}
      	else {
      		
      		System.out.println("Value is not available in the dropdown...");
      	}
       }
       
       Thread.sleep(4000);
		
       clickOnElement(groupclassification);
       
       Thread.sleep(3000);
       clearAndEnterText(waitForExpectedElement(searchclass),"martha");
       Thread.sleep(200);
       List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

       for(WebElement classificationlist:claslist) {
      	 
      	 String flagclss = classificationlist.getText().trim();
      	 
      	 if(flagclss.equalsIgnoreCase("martha")) {
      		 classificationlist.click();
      		 break;
      		 
      	 }
      	  
       }
		
       clickOnElement(specificgrade);
       clickOnElement(compositionlistitemchekbox);
       Thread.sleep(3000);
       clickOnElement(compositionlistitemchekbox2);
       Thread.sleep(3000);
       clickOnElement(compositionitemlistaddbtn);
       
       Thread.sleep(5000);
       clickOnElement(savebtn);
       
       Thread.sleep(2000);
       clickOnElement(viewbtn);
       Thread.sleep(2000);
       clearAndEnterText(waitForExpectedElement(searchbox), "adolph");
       Thread.sleep(4000);
       clickOnElement(deletebtn);
       driver.switchTo().alert().accept();
       Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
		
	}
	
	public static final By saveasnewbtn = By.xpath("//*[@id='SaveNewTab5']");
	public static final By editbutton = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr[1]/td[5]/a[1]/i");
	public void deletesaveasnewentry(String message) throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
       List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
       
       for(WebElement grplist:commdroplistvalue) {
      	 
      	String flagGrp = grplist.getText().trim();
      	
      	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
      		
      		grplist.click();
      		break;
      	}
      	else {
      		
      		System.out.println("Value is not available in the dropdown...");
      	}
       }
       
       Thread.sleep(4000);
		
       clickOnElement(groupclassification);
       
       Thread.sleep(3000);
       clearAndEnterText(waitForExpectedElement(searchclass),"Automation");
       Thread.sleep(200);
       List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

       for(WebElement classificationlist:claslist) {
      	 
      	 String flagclss = classificationlist.getText().trim();
      	 
      	 if(flagclss.equalsIgnoreCase("Automation")) {
      		 classificationlist.click();
      		 break;
      		 
      	 }
      	  
       }
		
       clickOnElement(specificgrade);
       clickOnElement(compositionlistitemchekbox);
       Thread.sleep(3000);
       clickOnElement(compositionlistitemchekbox2);
       Thread.sleep(3000);
       clickOnElement(compositionitemlistaddbtn);
       
       Thread.sleep(5000);
       clickOnElement(savebtn);
       
       Thread.sleep(2000);
       clickOnElement(viewbtn);
       Thread.sleep(2000);
       clearAndEnterText(waitForExpectedElement(searchbox), "CastingalloysEntries");
       Thread.sleep(4000);
       clickOnElement(editbutton);
       Thread.sleep(5000);
       
    clickOnElement(groupclassification);
       
       Thread.sleep(3000);
       clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
       Thread.sleep(200);
       List<WebElement> claslist1 = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

       for(WebElement classificationlist:claslist1) {
      	 
      	 String flagclss = classificationlist.getText().trim();
      	 
      	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
      		 classificationlist.click();
      		 break;
      		 
      	 }
      	  
       }
       Thread.sleep(4000);
       clickOnElement(specificgrade);
       Thread.sleep(3000);
       clickOnElement(saveasnewbtn);
       Thread.sleep(3000);
      
       clickOnElement(viewbtn);
       Thread.sleep(2000);
       clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
       Thread.sleep(4000);
       clickOnElement(deletebtn);
       driver.switchTo().alert().accept();
       Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
		
	}
	
	
	public static final By searchvalueinalloydetailtab = By.xpath("//*[@id='AlloyTable_filter']/label/input");
	public void verifydeletion() {
		
		clearAndEnterText(waitForExpectedElement(searchvalueinalloydetailtab), "");
		
		
	}
	
	public static final By enterfirstrowminvalue = By.xpath("//table[@id='parameterrightside']/tbody/tr/td[3]/input");
	public static final By checkboxcommgradecheckbox = By.xpath("//*[@id='14720']");
	public static final By fetchingvaluecommgrpdrp = By.xpath("//*[@id='select2-drpCom-container']");
	public static final By fetchingvaluegrpclassification = By.xpath("//*[@id='select2-drpSubCom-container']");
	public void verifyeditbtnIsworkingornot() throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
      List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
      
      for(WebElement grplist:commdroplistvalue) {
     	 
     	String flagGrp = grplist.getText().trim();
     	
     	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
     		
     		grplist.click();
     		break;
     	}
     	else {
     		
     		System.out.println("Value is not available in the dropdown...");
     	}
      }
      
      Thread.sleep(4000);
		
      clickOnElement(groupclassification);
      
      Thread.sleep(3000);
      clearAndEnterText(waitForExpectedElement(searchclass),"Automation");
      Thread.sleep(200);
      List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

      for(WebElement classificationlist:claslist) {
     	 
     	 String flagclss = classificationlist.getText().trim();
     	 
     	 if(flagclss.equalsIgnoreCase("Automation")) {
     		 classificationlist.click();
     		 break;
     		 
     	 }
     	  
      }
		
      clickOnElement(specificgrade);
      clickOnElement(compositionlistitemchekbox);
      Thread.sleep(3000);
      clickOnElement(compositionlistitemchekbox2);
      Thread.sleep(3000);
      clickOnElement(compositionitemlistaddbtn);
      
      Thread.sleep(5000);
      clickOnElement(savebtn);
      
      Thread.sleep(2000);
      clickOnElement(viewbtn);
      Thread.sleep(2000);
      clearAndEnterText(waitForExpectedElement(searchbox), "CastingalloysEntries");
      Thread.sleep(5000);
      
		if (waitForExpectedElement(editbutton).isEnabled()) {
			clickOnElement(editbutton);
			Thread.sleep(5000);
			String comgrpfetchvalue = waitForExpectedElement(fetchingvaluecommgrpdrp).getText();
			String grpclassificationfetchingvalue = waitForExpectedElement(fetchingvaluegrpclassification).getText();

			if (comgrpfetchvalue.equalsIgnoreCase("CastingalloysEntries")
					&& grpclassificationfetchingvalue.equalsIgnoreCase("Automation")) {

				LoggerUtil.pass(" Commodity Group Value is Fully loaded Properly");
				LoggerUtil.pass("Group classification value is fully loaded properly");
				
				boolean checkcommoditygradecheckbox = waitForExpectedElement(checkboxcommgradecheckbox).isSelected();
				Assert.assertEquals(checkcommoditygradecheckbox, true);
				
				LoggerUtil.pass("commodity group checkbox is clicked..");

			} 
			
			   
			
			
			else {

				LoggerUtil.mismatch("Commodity Group Value is not fully loaded..");
				LoggerUtil.mismatch("Group classification Value is not fully loaded..");
			}
		
			
	}
		
		else {
			
			LoggerUtil.error("Edit Button Is Disabled..");
			
		}

	}
	
	
	
	public void verifynumericsymbolandalphabetics(String message) throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
     List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
     
     for(WebElement grplist:commdroplistvalue) {
    	 
    	String flagGrp = grplist.getText().trim();
    	
    	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
    		
    		grplist.click();
    		break;
    	}
    	else {
    		
    		    LoggerUtil.error("Value is not available in the dropdown...");
    	}
     }
     
     Thread.sleep(4000);
		
     clickOnElement(groupclassification);
     
     Thread.sleep(3000);
     clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
     Thread.sleep(200);
     List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

     for(WebElement classificationlist:claslist) {
    	 
    	 String flagclss = classificationlist.getText().trim();
    	 
    	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
    		 classificationlist.click();
    		 break;
    		 
    	 }
    	 else {
    		 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
    	 }
    	 
     }
		
     clickOnElement(specificgrade);
     clickOnElement(compositionlistitemchekbox);
     Thread.sleep(3000);
     clickOnElement(compositionlistitemchekbox2);
     Thread.sleep(3000);
     clickOnElement(compositionitemlistaddbtn);
     clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "-@_abced");
     
     Thread.sleep(5000);
     clickOnElement(savebtn);
   
     Thread.sleep(3000);
     clickOnElement(viewbtn);
     Thread.sleep(2000);
     clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
     Thread.sleep(2000);
     clickOnElement(editbutton);
     
     String actualvalue = waitForExpectedElement(enterfirstrowminvalue).getAttribute("value");
     String expectedvalue = "abced";
     
     if((!actualvalue.equals(expectedvalue))) {
    	 
    	 LoggerUtil.pass("The values Are mismatched ...");
    	 LoggerUtil.info("This is actual value  = "+ actualvalue);
    	 LoggerUtil.info("This is expectedvalue = " + expectedvalue);
    	 
     }
     else {
    	 
    	 LoggerUtil.error("The values Are matched");
    	 LoggerUtil.info("This is actual value  = "+ actualvalue);
    	 LoggerUtil.info("This is expectedvalue = " + expectedvalue);
    	 
     }
       
     
     Thread.sleep(3000);
     clickOnElement(viewbtn);
     Thread.sleep(2000);
     clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
     Thread.sleep(2000);
     clickOnElement(deletebtn);
     driver.switchTo().alert().accept();
     Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
     
		
		
	}
	
	
public void verifynumericsymbol(String message) throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
     List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
     
     for(WebElement grplist:commdroplistvalue) {
    	 
    	String flagGrp = grplist.getText().trim();
    	
    	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
    		
    		grplist.click();
    		break;
    	}
    	else {
    		
    		    LoggerUtil.error("Value is not available in the dropdown...");
    	}
     }
     
     Thread.sleep(4000);
		
     clickOnElement(groupclassification);
     
     Thread.sleep(3000);
     clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
     Thread.sleep(200);
     List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

     for(WebElement classificationlist:claslist) {
    	 
    	 String flagclss = classificationlist.getText().trim();
    	 
    	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
    		 classificationlist.click();
    		 break;
    		 
    	 }
    	 else {
    		 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
    	 }
    	 
     }
		
     clickOnElement(specificgrade);
     clickOnElement(compositionlistitemchekbox);
     Thread.sleep(3000);
     clickOnElement(compositionlistitemchekbox2);
     Thread.sleep(3000);
     clickOnElement(compositionitemlistaddbtn);
     clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "$*+76.68%");
     
     Thread.sleep(5000);
     clickOnElement(savebtn);
   
     Thread.sleep(3000);
     clickOnElement(viewbtn);
     Thread.sleep(2000);
     clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
     Thread.sleep(2000);
     clickOnElement(editbutton);
     
     String actualvalue = waitForExpectedElement(enterfirstrowminvalue).getAttribute("value");
     String expectedvalue = "$*+76.68%";
     
     if((!actualvalue.equals(expectedvalue))) {
    	 
    	 LoggerUtil.pass("The values Are mismatched ...");
    	 LoggerUtil.info("This is actual value  = "+ actualvalue);
    	 LoggerUtil.info("This is expectedvalue = " + expectedvalue);
    	 
     }
     else {
    	 
    	 LoggerUtil.error("The values Are matched");
    	 LoggerUtil.info("This is actual value  = "+ actualvalue);
    	 LoggerUtil.info("This is expectedvalue = " + expectedvalue);
    	 
     }
       
     
     Thread.sleep(3000);
     clickOnElement(viewbtn);
     Thread.sleep(2000);
     clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
     Thread.sleep(2000);
     clickOnElement(deletebtn);
     driver.switchTo().alert().accept();
     Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
     
		
		
	}
	
     
      public static final By enterfirstrowmaxvalue = By.xpath("//table[@id='parameterrightside']/tbody/tr/td[5]/input");
      public void verifymaximumvaluealwaysgreaterthantomaximumvalue(String message) throws InterruptedException {
    	  
    	  clickOnElement(commoditydropdown);
  		
 	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
 	     
      List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
      
      for(WebElement grplist:commdroplistvalue) {
     	 
     	String flagGrp = grplist.getText().trim();
     	
     	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
     		
     		grplist.click();
     		break;
     	}
     	else {
     		
     		    LoggerUtil.error("Value is not available in the dropdown...");
     	}
      }
      
      Thread.sleep(4000);
 		
      clickOnElement(groupclassification);
      
      Thread.sleep(3000);
      clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
      Thread.sleep(200);
      List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

      for(WebElement classificationlist:claslist) {
     	 
     	 String flagclss = classificationlist.getText().trim();
     	 
     	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
     		 classificationlist.click();
     		 break;
     		 
     	 }
     	 else {
     		 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
     	 }
     	 
      }
 		
      clickOnElement(specificgrade);
      clickOnElement(compositionlistitemchekbox);
      Thread.sleep(3000);
      clickOnElement(compositionlistitemchekbox2);
      Thread.sleep(3000);
      clickOnElement(compositionitemlistaddbtn);
      clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "17");
      Thread.sleep(3000);
      clearAndEnterText(waitForExpectedElement(enterfirstrowmaxvalue), "10");
      Thread.sleep(5000);
      clickOnElement(savebtn);
    Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
  
    	  
      }



   public void verifyduplicatepromptarevisiblearenot(String message) throws InterruptedException {
	   
	   
	   clickOnElement(commoditydropdown);
		
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
		
       clickOnElement(groupclassification);
       
       Thread.sleep(3000);
       clearAndEnterText(waitForExpectedElement(searchclass),"Aluminium");
       Thread.sleep(200);
       List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

       for(WebElement classificationlist:claslist) {
      	 
      	 String flagclss = classificationlist.getText().trim();
      	 
      	 if(flagclss.equalsIgnoreCase("Aluminium")) {
      		 classificationlist.click();
      		 break;
      		 
      	 }
      	  
       }
      clickOnElement(clickcheckboxcomgrade);
      Thread.sleep(3000);
      
       clearAndEnterText(waitForExpectedElement(compostionitemsearch), "copper");
       Thread.sleep(2000);
       clickOnElement(compositioncheckbox);
  
       Thread.sleep(2000);
       clearAndEnterText(waitForExpectedElement(compostionitemsearch), "silicon");
       Thread.sleep(2000);
       clickOnElement(compositioncheckbox);
       Thread.sleep(3000);
//       waitForExpectedElement(compostionitemsearch).clear();
       Thread.sleep(5000);
       clearAndEnterText(waitForExpectedElement(compostionitemsearch), "aluminum");
       Thread.sleep(2000);
       clickOnElement(compositioncheckbox);
       Thread.sleep(3000);
//       waitForExpectedElement(compostionitemsearch).clear();
       Thread.sleep(5000);
       clearAndEnterText(waitForExpectedElement(compostionitemsearch), "zinc");
       Thread.sleep(2000);
       clickOnElement(compositioncheckbox);
       waitForExpectedElement(compostionitemsearch).clear(); 
       Thread.sleep(4000);
       clickOnElement(compostionitemsearch);
       
       clickOnElement(alloyingradiobtn);
       waitForExpectedElement(compostionitemsearch).clear(); 
       Thread.sleep(4000);
       clickOnElement(compostionitemsearch);
       Thread.sleep(6000);
       clickOnElement(addbtn);
         
	   Thread.sleep(3000);
	   clickOnElement(overheadradiobtn);
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
	    Thread.sleep(2000);
	    clickOnElement(consumableradiobtn);
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
	clickOnElement(savebtn);
	
	Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));  
	   
   }


    public static final By fetchingGroupclassification = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr[1]/td[3]");
   public void verifyefficiencyofsavingprocessofdata() throws InterruptedException {
	   
	   
	   clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
   List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
   
   for(WebElement grplist:commdroplistvalue) {
  	 
  	String flagGrp = grplist.getText().trim();
  	
  	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
  		
  		grplist.click();
  		break;
  	}
  	else {
  		
  		    LoggerUtil.error("Value is not available in the dropdown...");
  	}
   }
   
   Thread.sleep(4000);
		
   clickOnElement(groupclassification);
   
   Thread.sleep(3000);
   clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
   Thread.sleep(200);
   List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

   for(WebElement classificationlist:claslist) {
  	 
  	 String flagclss = classificationlist.getText().trim();
  	 
  	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
  		 classificationlist.click();
  		 break;
  		 
  	 }
  	 else {
  		 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
  	 }
  	 
   }
		
   clickOnElement(specificgrade);
   clickOnElement(compositionlistitemchekbox);
   Thread.sleep(3000);
   clickOnElement(compositionlistitemchekbox2);
   Thread.sleep(3000);
   clickOnElement(compositionitemlistaddbtn);
   clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "$*+76.68%");
   
   Thread.sleep(5000);
   clickOnElement(savebtn);
 
   Thread.sleep(3000);
   clickOnElement(viewbtn);
   Thread.sleep(2000);
   clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
   Thread.sleep(2000);
   String actualvalue = waitForExpectedElement(fetchingGroupclassification).getText();
   String expectedvalue = "Automation1.1";
   
   Assert.assertEquals(actualvalue, expectedvalue);
   
   LoggerUtil.info("Data Are Saved As of his repecitive time ");
   clickOnElement(deletebtn);
   driver.switchTo().alert().accept();
   
	   
	   
   }




 public void verifysavepromt(String message) throws InterruptedException {
	   
	   
	   clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
   List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
   
   for(WebElement grplist:commdroplistvalue) {
  	 
  	String flagGrp = grplist.getText().trim();
  	
  	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
  		
  		grplist.click();
  		break;
  	}
  	else {
  		
  		    LoggerUtil.error("Value is not available in the dropdown...");
  	}
   }
   
   Thread.sleep(4000);
		
   clickOnElement(groupclassification);
   
   Thread.sleep(3000);
   clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
   Thread.sleep(200);
   List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

   for(WebElement classificationlist:claslist) {
  	 
  	 String flagclss = classificationlist.getText().trim();
  	 
  	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
  		 classificationlist.click();
  		 break;
  		 
  	 }
  	 else {
  		 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
  	 }
  	 
   }
		
   clickOnElement(specificgrade);
   clickOnElement(compositionlistitemchekbox);
   Thread.sleep(3000);
   clickOnElement(compositionlistitemchekbox2);
   Thread.sleep(3000);
   clickOnElement(compositionitemlistaddbtn);
   clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "$*+76.68%");
   
   Thread.sleep(5000);
   clickOnElement(savebtn);
  Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
  LoggerUtil.info("After Saving The new Data The prompt is Showing = "+waitForExpectedElement(toastmessage).getText());
  
   Thread.sleep(3000);
   clickOnElement(viewbtn);
   Thread.sleep(2000);
   clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
   Thread.sleep(2000);
   String actualvalue = waitForExpectedElement(fetchingGroupclassification).getText();
   String expectedvalue = "Automation1.1";
   
   Assert.assertEquals(actualvalue, expectedvalue);
   
   LoggerUtil.info("Data Are Saved As of his repecitive time ");
   clickOnElement(deletebtn);
   driver.switchTo().alert().accept();
   
	   
	   
   }


 public void deletingDataSucessfully(String message) throws InterruptedException {
	 
	 
	 clickOnElement(commoditydropdown);
		
     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
     
List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));

for(WebElement grplist:commdroplistvalue) {
	 
	String flagGrp = grplist.getText().trim();
	
	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
		
		grplist.click();
		break;
	}
	else {
		
		    LoggerUtil.error("Value is not available in the dropdown...");
	}
}

Thread.sleep(4000);
	
clickOnElement(groupclassification);

Thread.sleep(3000);
clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
Thread.sleep(200);
List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

for(WebElement classificationlist:claslist) {
	 
	 String flagclss = classificationlist.getText().trim();
	 
	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
		 classificationlist.click();
		 break;
		 
	 }
	 else {
		 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
	 }
	 
}
	
clickOnElement(specificgrade);
clickOnElement(compositionlistitemchekbox);
Thread.sleep(3000);
clickOnElement(compositionlistitemchekbox2);
Thread.sleep(3000);
clickOnElement(compositionitemlistaddbtn);
clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "$*+76.68%");

Thread.sleep(5000);
clickOnElement(savebtn);

Thread.sleep(3000);
clickOnElement(viewbtn);
Thread.sleep(2000);
clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
Thread.sleep(2000);
String actualvalue = waitForExpectedElement(fetchingGroupclassification).getText();
String expectedvalue = "Automation1.1";

Assert.assertEquals(actualvalue, expectedvalue);


clickOnElement(deletebtn);
driver.switchTo().alert().accept();
Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
LoggerUtil.info("After clicking Delete Button prompt is Showing = "+waitForExpectedElement(toastmessage).getText());


 }

   public void updateprompt(String message) throws InterruptedException {
	   
	   clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
	List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));

	for(WebElement grplist:commdroplistvalue) {
		 
		String flagGrp = grplist.getText().trim();
		
		if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
			
			grplist.click();
			break;
		}
		else {
			
			    LoggerUtil.error("Value is not available in the dropdown...");
		}
	}

	Thread.sleep(4000);
		
	clickOnElement(groupclassification);

	Thread.sleep(3000);
	clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
	Thread.sleep(200);
	List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

	for(WebElement classificationlist:claslist) {
		 
		 String flagclss = classificationlist.getText().trim();
		 
		 if(flagclss.equalsIgnoreCase("Automation1.1")) {
			 classificationlist.click();
			 break;
			 
		 }
		 else {
			 LoggerUtil.error("Automation value is not finding in group classification dropdown..");
		 }
		 
	}
		
	clickOnElement(specificgrade);
	clickOnElement(compositionlistitemchekbox);
	Thread.sleep(3000);
	clickOnElement(compositionlistitemchekbox2);
	Thread.sleep(3000);
	clickOnElement(compositionitemlistaddbtn);
	clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "$*+76.68%");

	Thread.sleep(5000);
	clickOnElement(savebtn);

	Thread.sleep(3000);
	clickOnElement(viewbtn);
	Thread.sleep(2000);
	clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
	Thread.sleep(2000);
	String actualvalue = waitForExpectedElement(fetchingGroupclassification).getText();
	String expectedvalue = "Automation1.1";

	Assert.assertEquals(actualvalue, expectedvalue);

	clickOnElement(editbutton);
	Thread.sleep(4000);
	clearAndEnterText(waitForExpectedElement(enterfirstrowminvalue), "81.987"); 
	  Thread.sleep(3000);
	  clickOnElement(updatebtn);
	  Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
	  System.out.println(waitForExpectedElement(toastmessage).getText());
	  Thread.sleep(3000);
		clickOnElement(viewbtn);
		Thread.sleep(2000);
		clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
		Thread.sleep(2000);
		String actualvalue1 = waitForExpectedElement(fetchingGroupclassification).getText();
		String expectedvalue1 = "Automation1.1";

		Assert.assertEquals(actualvalue1, expectedvalue1);
		clickOnElement(deletebtn);
		driver.switchTo().alert().accept();
	   
   }

   public void verifySaveAsnewPrompt(String message) throws InterruptedException {
		
		clickOnElement(commoditydropdown);
		
	     clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	     
      List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
      
      for(WebElement grplist:commdroplistvalue) {
     	 
     	String flagGrp = grplist.getText().trim();
     	
     	if(flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
     		
     		grplist.click();
     		break;
     	}
     	else {
     		
     		System.out.println("Value is not available in the dropdown...");
     	}
      }
      
      Thread.sleep(4000);
		
      clickOnElement(groupclassification);
      
      Thread.sleep(3000);
      clearAndEnterText(waitForExpectedElement(searchclass),"Automation");
      Thread.sleep(200);
      List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

      for(WebElement classificationlist:claslist) {
     	 
     	 String flagclss = classificationlist.getText().trim();
     	 
     	 if(flagclss.equalsIgnoreCase("Automation")) {
     		 classificationlist.click();
     		 break;
     		 
     	 }
     	  
      }
		
      clickOnElement(specificgrade);
      clickOnElement(compositionlistitemchekbox);
      Thread.sleep(3000);
      clickOnElement(compositionlistitemchekbox2);
      Thread.sleep(3000);
      clickOnElement(compositionitemlistaddbtn);
      
      Thread.sleep(5000);
      clickOnElement(savebtn);
      
      Thread.sleep(2000);
      clickOnElement(viewbtn);
      Thread.sleep(2000);
      clearAndEnterText(waitForExpectedElement(searchbox), "CastingalloysEntries");
      Thread.sleep(4000);
      clickOnElement(editbutton);
      Thread.sleep(5000);
      
      clickOnElement(groupclassification);
      
      Thread.sleep(3000);
      clearAndEnterText(waitForExpectedElement(searchclass),"Automation1.1");
      Thread.sleep(200);
      List<WebElement> claslist1 = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));

      for(WebElement classificationlist:claslist1) {
     	 
     	 String flagclss = classificationlist.getText().trim();
     	 
     	 if(flagclss.equalsIgnoreCase("Automation1.1")) {
     		 classificationlist.click();
     		 break;
     		 
     	 }
     	  
      }
      Thread.sleep(4000);
      clickOnElement(specificgrade);
      Thread.sleep(3000);
      clickOnElement(saveasnewbtn);
      Assert.assertTrue(waitForExpectedElement(toastmessage).getText().contains(message));
      captureScreenshot(driver,"Taking Screent shot while Clicking Save as new button = ");
      LoggerUtil.info("Save as new  sucessfully has been showing = "+message);
      Thread.sleep(3000);
      System.out.println(waitForExpectedElement(toastmessage).getText());
      clickOnElement(viewbtn);
      Thread.sleep(2000);
      clearAndEnterText(waitForExpectedElement(searchbox), "Automation1.1");
      Thread.sleep(4000);
      clickOnElement(deletebtn);
      driver.switchTo().alert().accept();
    
		
	}

	
   public static final By resetbtn = By.xpath("//*[@id='clearallparameters']");
   public static final By specificgradeui = By.xpath("//div[@id='gradeAssnList']");
   public static final By compositionitemlistbody = By.xpath("//tbody[@id='parameterrightsideBody']/tr");
   public void verifyResetButton() throws InterruptedException {
	    // Some actions before the reset button logic
	    clickOnElement(commoditydropdown);
	    clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
	    
	    // Handle commodity dropdown value selection
	    List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
	    for (WebElement grplist : commdroplistvalue) {
	        String flagGrp = grplist.getText().trim();
	        if (flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
	            grplist.click();
	            break;
	        } else {
	            System.out.println("Value is not available in the dropdown...");
	        }
	    }

	    // Wait for 5 seconds
	    Thread.sleep(5000);
	    clickOnElement(groupclassification);
	    Thread.sleep(5000);
	    clearAndEnterText(waitForExpectedElement(searchclass), "Automation");

	    List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));
	    for (WebElement classificationlist : claslist) {
	        String flagclss = classificationlist.getText().trim();
	        if (flagclss.equalsIgnoreCase("Automation")) {
	            classificationlist.click();
	            break;
	        }
	    }

	    clickOnElement(specificgrade);
	    clickOnElement(compositionlistitemchekbox);
	    Thread.sleep(3000);
	    clickOnElement(compositionlistitemchekbox2);
	    Thread.sleep(3000);
	    clickOnElement(compositionitemlistaddbtn);
	    Thread.sleep(5000);
	    clickOnElement(savebtn);
	    Thread.sleep(2000);
	    clickOnElement(viewbtn);
	    Thread.sleep(2000);
	    clearAndEnterText(waitForExpectedElement(searchbox), "CastingalloysEntries");
	    Thread.sleep(4000);
	    clickOnElement(editbutton);
	    Thread.sleep(5000);

	    // Wait for the reset button to be enabled
	    WebElement resetButton = waitForExpectedElement(resetbtn);

	    // Check if reset button is enabled before clicking it
	    if (resetButton.isEnabled()) {
	    	Thread.sleep(2000);
	        clickOnElement(resetbtn);
	        
	       

	        // Validate if both elements are not displayed (i.e., reset was successful)
	        WebElement gradeui = waitForExpectedElement(specificgradeui);
	        List<WebElement> compolistuibody = driver.findElements(compositionitemlistbody);
	        if (!gradeui.isDisplayed() && !((WebElement) compolistuibody).isDisplayed()) { 
	            LoggerUtil.pass("Reset Button is Working Well...");
	            LoggerUtil.pass("Specific grade table is not showing...");
	            LoggerUtil.pass("Composition item list is not showing");
	        } else {
	            LoggerUtil.info("Reset Button is not Working...");
	        }
	    } else {
	        LoggerUtil.error("Reset Button Is Not Clickable...");
	    }
	}


	   
	public static final By fetchingdataforgroupclassification = By.xpath("//*[@id='compSavedViewListTable']/tbody/tr[1]/td[3]");   
	public void verifysavingdataforclientAandclientB(String searchclassificationvalue) throws InterruptedException {
		
		
		 clickOnElement(commoditydropdown);
		    clearAndEnterText(waitForExpectedElement(searchcomgrp), "CastingalloysEntries");
		    
		    // Handle commodity dropdown value selection
		    List<WebElement> commdroplistvalue = driver.findElements(By.xpath("//ul[@id='select2-drpCom-results']/li"));
		    for (WebElement grplist : commdroplistvalue) {
		        String flagGrp = grplist.getText().trim();
		        if (flagGrp.equalsIgnoreCase("CastingalloysEntries")) {
		            grplist.click();
		            break;
		        } else {
		            System.out.println("Value is not available in the dropdown...");
		        }
		    }

		    // Wait for 5 seconds
		    Thread.sleep(5000);
		    clickOnElement(groupclassification);
		    Thread.sleep(5000);
		    clearAndEnterText(waitForExpectedElement(searchclass), "Automation");

		    List<WebElement> claslist = driver.findElements(By.xpath("//ul[@id='select2-drpSubCom-results']/li"));
		    for (WebElement classificationlist : claslist) {
		        String flagclss = classificationlist.getText().trim();
		        if (flagclss.equalsIgnoreCase("Automation")) {
		            classificationlist.click();
		            break;
		        }
		    }

		    clickOnElement(specificgrade);
		    clickOnElement(compositionlistitemchekbox);
		    Thread.sleep(3000);
		    clickOnElement(compositionlistitemchekbox2);
		    Thread.sleep(3000);
		    clickOnElement(compositionitemlistaddbtn);
		    Thread.sleep(5000);
		    clickOnElement(savebtn);
		    Thread.sleep(2000);
		    clickOnElement(viewbtn);
		    Thread.sleep(2000);
		    clearAndEnterText(waitForExpectedElement(searchbox), searchclassificationvalue);
		    Thread.sleep(4000);
		   String actualvalue = waitForExpectedElement(fetchingdataforgroupclassification).getText();
		   Assert.assertEquals(actualvalue, searchclassificationvalue);
		   if(actualvalue.equalsIgnoreCase(searchclassificationvalue)) {
				 
				 LoggerUtil.pass("Data has  Been Saved ....");
				 
			 }
			 else {
				   LoggerUtil.error("Data has not been save .... ");
				 
			 }
		
		
		
		
		
		
	}
	   
   
   
   public void verifyInSecondIdthedatahasbeenSaveOrNot(String searchclassificationvalue) throws InterruptedException {
	   
	   
	   clickOnElement(viewbtn);
	    Thread.sleep(2000);
	    clearAndEnterText(waitForExpectedElement(searchbox), searchclassificationvalue);
	    Thread.sleep(4000);
	   String actualvalue = waitForExpectedElement(fetchingdataforgroupclassification).getText();
	   Assert.assertNotSame(actualvalue, searchclassificationvalue);
	 if(!actualvalue.equalsIgnoreCase(searchclassificationvalue)) {
		 
		 LoggerUtil.pass("Data has Not Been Saved In Second Client DataBase");
		 
	 }
	 else {
		   LoggerUtil.error("Data Should not been saved in Clent B ");
		 
	 }
	 
	 
	 
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
