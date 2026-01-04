package com.Tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.PCC_PageMaster;
import com.helper.Base;
import com.helper.ExcelUtil;
import com.helper.LoggerUtil;

@Listeners(com.helper.TestListeners.class)
public class PCC_Test extends Base {

    LoginPage login;
    DashboardPage dashboard;
    PCC_PageMaster Pcc;

    @BeforeGroups(groups = {"group1","group2","group3"})
    public void VerifyLoginAndOpenPCCPage() throws InterruptedException {
        launchApplication();
        login = new LoginPage();
        dashboard = new DashboardPage();
        Pcc = new PCC_PageMaster();

        login.loginApplication(prop.getProperty("username3"), prop.getProperty("password3"));

        LoggerUtil.info("Opening PCC Change Impact page once after login...");
        safeSelectMenu("Price Approvals");
        Thread.sleep(4000);
        dashboard.ClickingPcc();
        Thread.sleep(3000);
        dashboard.clickingPccChangeImpacat();
        Thread.sleep(2000);
    }

    @AfterGroups(groups = {"group1","group2","group3"})
    public void verifyLogout() {
        driver.quit();
    }

    public void safeSelectMenu(String menuName) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                LoggerUtil.info("Trying to click menu: " + menuName + " (Attempt " + (i + 1) + ")");
                dashboard.selectMenuFormDashBoard(menuName);
                LoggerUtil.pass("Menu found and clicked: " + menuName);
                return;
            } catch (Exception e) {
                LoggerUtil.error("Failed to click menu on attempt " + (i + 1) + ": " + e.getMessage());
                try { Thread.sleep(3000); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
            }
        }
        LoggerUtil.fail("Could not find menu: " + menuName + " after " + retries + " attempts.");
    }

   
   
    @Test(priority = 1, groups = "group1")
    public void selectAllDropdownsOnce() throws InterruptedException {
        Pcc.reselectAllMandatoryDropdowns();
    }

    
    @Test(priority = 2, dataProvider = "partNumbers", groups = "group1",
          dependsOnMethods = "selectAllDropdownsOnce")
    public void changeOnlyPartNumber(String partNumber) throws InterruptedException {
        Pcc.onlyChangePartNumber(partNumber);
        Thread.sleep(2000); 
        Pcc.searchPartNumberInDatabaseAndSubmit();
    }

  
    @DataProvider(name = "partNumbers")
    public Object[][] getAllPartNumbers() throws IOException {
        final String filePath = "C:\\Users\\Admin\\Downloads\\com.CostMaster\\testdata\\DetailCost_Sheet94105-08-2025 05_42_39.xlsx";
        final String sheetName = "Sheet1"; 
        final int columnIndex = 0;         

        
        List<String> partList = ExcelUtil.readColumnAsList(filePath, sheetName, columnIndex);

        
        int startIndex = 500;                        
        if (startIndex < 0) startIndex = 0;
        if (startIndex > partList.size()) startIndex = partList.size();

        List<String> slice = partList.subList(startIndex, partList.size());

        // Build Object[][]
        Object[][] data = new Object[slice.size()][1];
        for (int i = 0; i < slice.size(); i++) {
            data[i][0] = slice.get(i);
        }
        return data;
    }

    @DataProvider(name = "firstPartNumber")
    public Object[][] getFirstPartNumber() throws IOException {
        final String filePath = "C:\\Users\\Admin\\Downloads\\com.CostMaster\\testdata\\DetailCost_Sheet94105-08-2025 05_42_39.xlsx";
        final String sheetName = "Sheet1";
        final int columnIndex = 0;

        List<String> partList = ExcelUtil.readColumnAsList(filePath, sheetName, columnIndex);
        if (partList == null || partList.isEmpty()) {
            throw new IllegalStateException("No part numbers found in the provided file/sheet/column.");
        }
        return new Object[][] { { partList.get(0) } };
    }
}
