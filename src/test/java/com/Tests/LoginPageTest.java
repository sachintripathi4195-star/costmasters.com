package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class LoginPageTest extends Base {

LoginPage login = new LoginPage();
DashboardPage dashboard = new DashboardPage();

@BeforeMethod

public void launch() {
Base.launchApplication();
}

@Test(dataProvider = "ExcelData")
public void verifyUserLogin(String uname, String pass) throws InterruptedException {
LoggerUtil.logger.info("Starting valid login test...");
login.loginApplication(uname, pass);
Thread.sleep(4000);
dashboard.selectMenuFormDashBoard("Master Data");
dashboard.clickOnProcessItem();
       
}

@DataProvider(name = "ExcelData")
public static Object[][] getLoginData() throws IOException {
String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
String sheetName ="Login";
return ExcelUtil.getExcelData(filePath, sheetName);
}

@AfterMethod
public void tearDown() {
driver.quit();

}

}