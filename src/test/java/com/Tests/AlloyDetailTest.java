package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.helper.Base;

@Listeners(com.helper.TestListeners.class)
public class AlloyDetailTest extends Base {
	LoginPage log ;
	DashboardPage dash;
	@BeforeGroups(groups= {"group1","group2"})
	public void setup() {
	 
		log=new LoginPage();
		dash = new DashboardPage();
		launchApplication();
		log.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		
		
			
		}	
		
	@AfterGroups(groups= {"group1","group2"})	
  public void closebrowser() {
	  
	  driver.quit();
	  
  }
		
	
	@Test(groups = "group1")
	public void testlogin() throws InterruptedException {
		dash.selectMenuFormDashBoard("Master Data");
		Thread.sleep(200);

		dash.clickoncommodityMaster();
		Thread.sleep(1000);
		dash.AlloydetailTab();
		Thread.sleep(3000); 

	}
	
	
	

}
