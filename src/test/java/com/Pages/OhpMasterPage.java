package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Base;
import com.helper.LoggerUtil;

public class OhpMasterPage extends Base{

	
	
	
	
	public static final By ViewbtnOhpPage = By.xpath("//div[@class=\"footer_sticky_button box-footer cs_gap_btn flex_end\"]//button[@id=\"btnView\"]");
	public static final By EntervaluesearchboxInView = By.xpath("//div[@id=\"example1_filter\"]/label/input");
	public static final By clcikeditbtnForRonaldo = By.xpath("//*[@id=\"ohpDetails1\"]/tr/td[6]/a[1]/span/i");
	
	
	public void clickbutton(String entervaluesinsearchbox) {

		clickOnElement(ViewbtnOhpPage);
		clearAndEnterText(waitForExpectedElement(EntervaluesearchboxInView), entervaluesinsearchbox);
		clickOnElement(clcikeditbtnForRonaldo);
		
		
		
		
		
		
		 
	    }
	
	
	
}
	

