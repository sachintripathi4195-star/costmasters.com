package com.Pages;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;
import com.helper.Base;

public class UnitMasterPage extends Base{
public static final By enterOnUnitNameTxt =By.xpath("//input[@id='unitName']");
	
	public static final By enterOnUnitSymbolTxt =By.xpath("//input[@id='unitSymbol']");
	
	public static final By clickedOnSaveButton =By.xpath("//button[@id='uomSave']");
	
	
	
	public void enterdOnUnitNameTxtAndUnitSymbolTxt(String UnitName,String UnitSymbol ) {
		sendKeysToTextBox(enterOnUnitNameTxt, UnitName);
		sendKeysToTextBox(enterOnUnitSymbolTxt, UnitSymbol);
	}
	
	public void clickedOnSaveBT() {
		clickOnElement1(clickedOnSaveButton);
	}
}
