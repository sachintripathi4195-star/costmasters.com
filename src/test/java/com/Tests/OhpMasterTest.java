package com.Tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.OhpMasterPage;
import com.Pages.SupplierMasterPage;
import com.helper.Base;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)

public class OhpMasterTest extends Base {

	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
	SupplierMasterPage supplier = new SupplierMasterPage();	
	OhpMasterPage ohp = new OhpMasterPage();
	
	@BeforeMethod
	public void launch(Method method) {
		Base.launchApplication();
	}
	
	
	
	@Test(priority=1)
	public void VerifySupplierAllocationInOHPMasterInOHPSupplierShouldSame() throws InterruptedException {
		login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));	
		LoggerUtil.info("verify User Enter UserName And UserPassWord ");
		LoggerUtil.info("User Click LoginButton Sucessfully");
		dashboard.selectMenuFormDashBoard("Master Data");
		LoggerUtil.info("User Select Master Data From Dashboard");
		LoggerUtil.info("verify Fill All Column In supplier Page");
		LoggerUtil.info("Verifu user Check Process Check Box");
		LoggerUtil.info("User Select One from Process Allocation Table ");
		LoggerUtil.info("User Click The Save Button On Supplier Page");
		LoggerUtil.info("User Quit the Supplier Page ");
		dashboard.clickonsuppliermaster();
		supplier.entersuppliervalueforohpallocation("009","Ronaldo","Bihar");
		Thread.sleep(9000);
		dashboard.clickOnOHPMaster();
		Thread.sleep(6000);
		ohp.clickbutton("Ronaldo");
		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
