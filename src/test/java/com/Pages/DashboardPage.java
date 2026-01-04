package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.helper.Base;
import com.helper.LoggerUtil;

public class DashboardPage extends Base {

	public static final By menuItems = By.xpath("//ul[@class='main-menu active']/li/a[@class='side-menu__item']/span");
	
	public static final By clickinghomeBtn = By.xpath("//aside[@id='sidebar']/div/a/div[@class='desktop-logo']");
	public static final By MasterData_process = By.xpath("//a[@href='/Masters/ProcessMaster/Index']");
	public static final By Customermaster = By
			.xpath("//*[@id=\"sidebar-scroll\"]/div[1]/div[2]/div/div/div/nav/ul/li[2]/ul/li[6]/a");
	public static final By suppliermaster = By
			.xpath("//*[@id=\"sidebar-scroll\"]/div[1]/div[2]/div/div/div/nav/ul/li[2]/ul/li[13]");
	public static final By controlmaster = By
			.xpath("//ul[contains(@class, 'slide-menu child')]//a[contains(text(), 'Control Master')]");
	public static final By controlmaster1 = By.xpath(
			"//li[@class='slide has-sub open active']/a/following-sibling::ul/li[4]//a[@href='javascript:void(0);']");
	public static final By commoditymaster = By
			.xpath("//ul[@class=\"slide-menu child1 active\"]//li[3]//a[@href=\"/Masters/CommodityMaster/Index\"]");
	public static final By OHPMaster = By.xpath("//a[@href=\"/Masters/OHP/Index\"]");
	public static final By CommodityMaster = By.xpath("//a[@href='/Masters/CommodityMaster/Index']");
	public static final By masterdata = By.xpath("//*[@id='sidebar-scroll']/div[1]/div[2]/div/div/div/nav/ul/li[2]/a");
    public static final By ListOptionControlMaster = By.xpath("//ul[contains(@class,'slide-menu')]/li/a\r\n"
    		+ "");
	
	public void selectMenuFormDashBoard(String value) {
		try {
			List<WebElement> menuItemsList = driver.findElements(menuItems);
			selectBootStrapDropDown(menuItemsList, value);
			LoggerUtil.info("Master Data  Is Displayed On Dashboard....");
		} catch (Exception e) {
			e.getMessage();
			LoggerUtil.info("Master Data  Is Not Displayed On Dashboard");

		}
	}
	
public  void selectControlMaster(String value) {
	List<WebElement> Controloptions = driver.findElements(ListOptionControlMaster);
	selectBootStrapDropDown(Controloptions, value);
	LoggerUtil.info("Control Master Data Has been Displayed..");
}
	
	
	public void clickingDashboard(String value) {
		
		
		
		try {
			clickOnElement(clickinghomeBtn);
		}catch(Exception e) {
			
			e.getMessage();
			LoggerUtil.fail("Dashboard Is not DisPlayed...");
			
			
		}
	}
	

	public void clickOnProcessItem() {
		clickOnElement(MasterData_process);
	}

	public void clickoncustomermaster() {
		clickOnElement(Customermaster);

	}

	public void clickonsuppliermaster() {

		clickOnElement(suppliermaster);

	}

	public void clickOnControlMaster() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(controlmaster));

		try {
			waitForExpectedElement(controlmaster).click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click();", waitForExpectedElement(controlmaster));
		}

	}

	public void clickoncommodityMaster() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommodityMaster));

			try {
				waitForExpectedElement(CommodityMaster).click();
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", waitForExpectedElement(CommodityMaster));
			}
			LoggerUtil.info("Commodity Master is Displayed");
		} catch (Exception e) {
			e.getMessage();
			LoggerUtil.info("Commodity Master Is Not Visible");
		}

	}

//     public void clickOncontrolmaster1() {
//    	 
//    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//    	 wait.until(ExpectedConditions.elementToBeClickable(controlmaster));
//    	 
//    	 try {
//    		 waitForExpectedElement(controlmaster).click();
//    	 }catch (Exception e)   {JavascriptExecutor js = (JavascriptExecutor) driver;
//    	  js.executeScript("argument[0].click();",waitForExpectedElement(controlmaster));
//    	 }
//    	 
//    	 
//    	 
//    	 
//    	 
//     }

	public void clickOnOHPMaster() {

		clickOnElement(OHPMaster);

	}

	public void clickOnCommodityMaster2() {

		clickOnElement(CommodityMaster);

	}

	public static final By Logoutbtn = By.xpath("//form[@id='logoutForm']/a");

	public void clickOnlogoutbtn() {

		clickOnElement(Logoutbtn);

	}

	public static final By userinucontrolmaster = By
			.xpath("//ul[@class='slide-menu child2 custom_add_scroll']/li[13]/a");

	public void clickOnusermaster() {

		clickOnElement(userinucontrolmaster);

	}

	public static final By AddcastingElement = By.xpath("//div[@id='exTab3']/ul/li[4]/a");

	public void clickadcastingtab() throws InterruptedException {

		Thread.sleep(4000);
		clickOnElement(AddcastingElement);

	}

	

	public static final By addcommoditytab = By.xpath("//div[@id='exTab3']/ul/li/a[@href='#CommodityTabMaterial']");

	public void clickOnAddcommodity() {
		clickOnElement(addcommoditytab);
	}

	public static final By commoditygrouptab = By.xpath("//div[@id='exTab3']/ul/li[2]/a");

	public void clickOncommoditygroup() {
		clickOnElement(commoditygrouptab);
	}

	public static final By Addcastingelementtab = By.xpath("//*[@id='exTab3']/ul/li[4]/a");

	public void clickAddcastingTab() {
		WebElement addCastingElement = waitForExpectedElement(Addcastingelementtab); // Ensure this returns the correct
																						// WebElement

		if (addCastingElement != null) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", addCastingElement); // Corrected syntax for clicking
		} else {
			System.out.println("Element not found or not clickable.");

		}

	}

	public static final By clickcastingAlloytab = By.xpath("//*[@id='exTab3']/ul/li[5]/a");

	public void castingalloytab() {
		WebElement castingalloytab = waitForExpectedElement(clickcastingAlloytab);

		WebDriverWait castwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		castwait.until(ExpectedConditions.elementToBeClickable(castingalloytab));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", castingalloytab);

	}

	public static final By Alloydetailstab = By.xpath("//*[@id='AlloyDetails']");

	public void AlloydetailTab() {
		WebElement alloydetailtab = waitForExpectedElement(Alloydetailstab);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", alloydetailtab);

	}

	public static final By taballoydetails = By.xpath("//li[normalize-space()='Alloy Details']");

	public void Alloydetailstab() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(taballoydetails));
		WebElement tabclickalloy = waitForExpectedElement(taballoydetails);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", tabclickalloy);

	}

	public static final By packingtab = By.xpath("//*[@id='Pakingtab']");

	public void Packingtab() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(packingtab));
		clickOnElement(packingtab);

	}

	public static final By standardtabcommodity = By.xpath("//*[@id='exTab3']/ul/li[9]/a");

	public void clickingwirestandardtab() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(standardtabcommodity)).click();
		;

	}

	public static final By wiredataEntrytab = By.xpath("//*[@id='exTab3']/ul/li[10]/a");

	public void clickingwiredataentrytab() {

		clickOnElement(wiredataEntrytab);

	}

	public static final By clickcurrencymaster = By
			.xpath("//*[@id='sidebar-scroll']/div[1]/div[2]/div/div/div/nav/ul/li[2]/ul/li[5]/a");

	public void clickingcurrencymaster() {

		clickOnElement(clickcurrencymaster);

	}

	public static final By CurrencyDataAdditiontab = By.xpath("//a[normalize-space()='Currency Data Addition']");

	public void currencydataadditiontab() {

		clickOnElement(CurrencyDataAdditiontab);

	}

	public static final By CurrencyAddition = By
			.xpath("//a[normalize-space()='Currency Addition' and @class='active']");

	public void CurrencyAddition() throws InterruptedException {

		fluentWait(CurrencyAddition, 6, 500);
		clickOnElement(CurrencyAddition);

	}

	public static final By ClickingOnBopMaster = By.xpath("//a[@href='/Masters/BOP/Index']");

	public void selectBopMaster() throws InterruptedException {

		clickOnElement(ClickingOnBopMaster);

	}

	public static final By ClickOnBopType = By.xpath("//*[@id='exTab3']/ul/li[1]/a");

	public void ClickingBopTypeTab() {

		clickOnElement(ClickOnBopType);

	}

	public void clickingOnlyBopMaster() {

		clickOnElement(ClickingOnBopMaster);

	}

	public static final By ClickOnBopEntryTab = By.xpath("//div[@id='exTab3']/ul/li[2]/a");

	public void clickingBopEntryTab() {

		clickOnElement(ClickOnBopEntryTab);

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static final By clickingMasterOptions = By.xpath("//ul[@class='main-menu']/li/ul[@class='slide-menu child1 active']/li/a[contains(text(),'')]");

	public void VerifyClickingMasterOptions(String Expectedvalues) throws InterruptedException {
	    Actions action = new Actions(driver);

	    try {
	        
	        WebElement masterDataMenu = driver.findElement(
	            By.xpath("//span[normalize-space(text())='Master Data']")
	        );
	        if (!driver.findElement(By.xpath("//span[normalize-space(text())='Master Data']/parent::a/following-sibling::ul"))
	                .isDisplayed()) {
	            action.moveToElement(masterDataMenu).click().perform();
	            LoggerUtil.info("Expanded Master Data menu");
	           
	        }

	      
	        List<WebElement> mastersDataOptions = driver.findElements(
	            By.xpath("//span[normalize-space(text())='Master Data']/parent::a/following-sibling::ul/li/a")
	        );

	        boolean found = false;

	      
	        for (WebElement option : mastersDataOptions) {
	            String actualText = option.getText().trim();
	            if (actualText.equalsIgnoreCase(Expectedvalues)) {
	                action.moveToElement(option).click().perform();
	                LoggerUtil.pass("Clicked Master Option: " + Expectedvalues);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            LoggerUtil.mismatch("Master Option not found: " + Expectedvalues);
	        }

	    } catch (Exception e) {
	        LoggerUtil.error("Error while clicking Master Option: " + e.getMessage());
	    }
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Generic locator for all tabs under exTab3
	public static final By AllTabsUnderExTab3 = By.xpath("//div[@id='exTab3']/ul/li/a");

	public void clickOnCommodityTabByName(String tabName) {

	    try {
	        LoggerUtil.info("STEP: Attempting to click tab → " + tabName);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AllTabsUnderExTab3));

	        List<WebElement> allTabs = driver.findElements(AllTabsUnderExTab3);

	        if (allTabs.isEmpty()) {
	            LoggerUtil.fail("❌ No tabs found under Commodity section.");
	            Assert.fail("Tab list is empty. UI might not be loaded.");
	        }

	        for (WebElement tab : allTabs) {
	            String actualText = tab.getText().trim();

	            if (actualText.equalsIgnoreCase(tabName)) {

	                try {
	                    wait.until(ExpectedConditions.elementToBeClickable(tab));
	                    tab.click();
	                } catch (Exception clickEx) {
	                    LoggerUtil.warn("Normal click failed. Retrying using JS click for tab: " + tabName);
	                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
	                }

	                LoggerUtil.pass("✅ Successfully clicked on tab: " + tabName);
	                return;
	            }
	        }

	        // If loop completes and tab not found
	        LoggerUtil.fail("❌ Tab not found with name: " + tabName);
	        Assert.fail("Tab not present in UI: " + tabName);

	    } catch (Exception e) {
	        LoggerUtil.error(
	                "❌ Failed while clicking tab: " + tabName
	                        + " | Reason: " + e.getMessage());
	        Assert.fail("Exception occurred while clicking tab: " + tabName, e);
	    }
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final By ClickingPccMaster = By.xpath("//a[@href='javascript:void(0);']/following-sibling::ul[@class='slide-menu child1']/li[2]/a[contains(text(),'PCC')]");
	
	public void ClickingPcc() {
		
		clickOnElement(ClickingPccMaster);
		
		
	}
	
	public static final By ClickingPccChangeImpact = By.xpath("//a[@href='javascript:void(0);']/following-sibling::ul[@class='slide-menu child1']/li[2]/a[contains(text(),'PCC')]/following-sibling::ul/li[5]/a[contains(text(),'PCC Change Impact')]");
	
	public void clickingPccChangeImpacat() {
		
		
		clickOnElement(ClickingPccChangeImpact);
		
	}
	
	public static final By clickOnUnitMaster =By.xpath("//a[normalize-space(text())='Unit']");
    public void clickOnUnitMaster() {
   	 clickOnElement(clickOnUnitMaster);
    }
    
    public static final By clickOnPartMaster =By.xpath("//a[contains(text(),'Part Master')]");
    public void clickOnPartMaster() {
   	 clickOnElement(clickOnPartMaster);
    }
    
    public static final By clickOnCustomerMasterData=By.xpath("//a[normalize-space(text())='Customer']");
 	public void clickOnCustomerMasterData() {
 		clickOnElement(clickOnCustomerMasterData);
 	}
 	
 	 public static final By clickOnCompanyControlMaster =By.xpath("//a[normalize-space(text())='Company']");
     public void clickOnCompanyControlMaster() {
    	 clickOnElement(clickOnCompanyControlMaster);

     }
     
     public static final By userControlMasterBT=By.xpath("//li[@class='slide']//a[contains(text(),'Users')]");
  	 public void clickOnUserMasterBT() {
     	 clickOnElement(userControlMasterBT);
      }
  	
  	public static final By clickOnProductModel=By.xpath("//a[normalize-space(text())='Product Model']");
 	public void clickOnProductModel() {
 		clickOnElement(clickOnProductModel);
 	}
  	
 	public static final By clickOnCurrencyModel=By.xpath("//a[normalize-space(text())='Currency']");
 	public void clickOnCurrencyModel() {
 		clickOnElement(clickOnCurrencyModel);
 	}
 	
 	public static final By commoditydetailstab = By.xpath("//div[@id='exTab3']/ul/li[3]/a");

	public void clickoncommoditydetailstab() {

		clickOnElement(commoditydetailstab);

	}
 	
	public void clickoncommodityMasterspeciyly() {
		Base base=new Base();
		base.clickOnElement1(CommodityMaster);

	}
 	
 	
 	
 	
   		 
    }

