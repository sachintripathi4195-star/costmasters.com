package com.Pages;

import org.openqa.selenium.By;

import com.helper.Base;

public class LoginPage extends Base {
  
	
	
	By userName = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	By loginBtn = By.xpath("//button[@type='submit']");

	public void loginApplication(String uname, String pass) {
		
		clearAndEnterText(waitForExpectedElement(userName), uname);
		clearAndEnterText(waitForExpectedElement(password), pass); 
		clickOnElement(loginBtn);
        long starttime = System.currentTimeMillis();


	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
