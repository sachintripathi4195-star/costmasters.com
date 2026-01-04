package com.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.helper.Base;

public class UsersControlMasterPage extends Base{
public static final By clickOnUserAuthorizationBT =By.xpath("//a[normalize-space(text())='User Authorization']");
	
	public static final By clickOnUserAuthorizationEditBT =By.xpath("//a[contains(@href,'/Subscription/EditUserAuthorize/118a9')]");
	
	public static final By clickOnUserAuthorizatinCompanySelectionBT =By.xpath("//button[contains(@class,'multiselect dropdown')]");

	public static final By clickOnTheCompanySelectionSelectAllCheckBox=By.xpath("//input[contains(@id,'multiselect_')]");

	public static final By clickOnUpdateBtn=By.xpath("//a[@id='btnSubmit']");
	public void clickOnUserAuthorizationBT() {
		clickOnElement1(clickOnUserAuthorizationBT);
	}
	
	public void clickOnUserAuthorizationEditBT() {
		clickOnElement1(clickOnUserAuthorizationEditBT);
	}
	
	public void clcikOnCompanySelection() {
		clickOnElement1(clickOnUserAuthorizationEditBT);
	}
	
	public void selectOnCompanySelectionDD() throws InterruptedException {
		clickOnElement1(clickOnUserAuthorizatinCompanySelectionBT);
		Thread.sleep(5000);
		clickOnElement1(clickOnTheCompanySelectionSelectAllCheckBox);		
			
	}
	
	public void clickOnUpdateBtn() {
		clickOnElement1(clickOnUpdateBtn);
	}

}
