package com.Tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.helper.Base;
import com.helper.LoggerUtil;

public class GroupInitializer extends Base {

    public static LoginPage login;
    public static DashboardPage dashboard;
    

    @BeforeGroups(groups = {"group1", "group2", "group3", "group4"})
    public void LaunchApplication() {
        launchApplication();
        login = new LoginPage();
        dashboard = new DashboardPage();
        login.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        LoggerUtil.info("✅ Login successful for group execution.");
    }

    @AfterGroups(groups = {"group1", "group2", "group3", "group4"})
    public void QuitApplication() {
        driver.quit();
        LoggerUtil.info("🛑 Driver quit after group execution.");
    }
}
