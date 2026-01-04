package com.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.helper.Base;

public class CompanyControlMasterPage extends Base{

	public static final By enterOnCompanyNameTxt =By.xpath("//input[@id='CompanyName']");
	
	public static final By enterOnCompanyCodeTxt =By.xpath("//input[@id='CompanyCode']");
	
	public static final By enterOnLocationTxt =By.xpath("//input[@id='Location']");
	
	public static final By clickOnSaveBT =By.xpath("//button[@id='Addmachinedetail']");

	
	public static final By clickedOnCompanyGroupDD=By.xpath("//span[@id='select2-CompanyId-container']");
	
	public static final By selectOnCompanyDD=By.xpath("//ul[@id='select2-CompanyId-results']/li");
	
	
	
	
	public void selectOnCompanyDD(String companyDD) throws InterruptedException {
	    // Click on the Company dropdown to expand it
	    clickOnElement1(clickedOnCompanyGroupDD); 
	    
	    // Wait briefly to allow dropdown options to load (replace with explicit wait in production)
	    Thread.sleep(1000); 

	    // Fetch all options under the dropdown
	    List<WebElement> companyNameDropdownOptions = driver.findElements(selectOnCompanyDD);

	    // Loop through the options to find and click the desired one
	    for (WebElement option : companyNameDropdownOptions) {
	        String optionText = option.getText().trim();
	        if (optionText.equalsIgnoreCase(companyDD.trim())) {
	            option.click(); // Click on the matching option
	            return;
	        }
	    }

	    // If no match is found, throw an exception
	    throw new RuntimeException("Company '" + companyDD + "' not found in the dropdown.");
	}

	
	public void enterOnCustomerNameTxt(String CompanyName) {
		sendKeysToTextBox(enterOnCompanyNameTxt, CompanyName);
	}
	
	public void enterOnCustomerCodeTxt(String CompanyCode) {
		sendKeysToTextBox(enterOnCompanyCodeTxt, CompanyCode);

	}
	
	public void enterOnLocationTxt(String Location) {
		sendKeysToTextBox(enterOnLocationTxt, Location);

	}
	
	public void clickOnSaveBT() {
		clickOnElement1(clickOnSaveBT);
	}
	
	

	
}
