package com.Pages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.helper.Base;
import com.helper.LoggerUtil;
public class ProductModelPage extends Base{
	
	public static final By clickOnProductModelBtn=By.xpath("//ul[@class='nav nav-pills']//a[text()='Product Model']");
	public static final By clickOnProductModelSaveBtn=By.xpath("//form[@id='productModelForm']//following-sibling::button[@id='modelSave']");

	public static final By listOfProductCategoryData=By.xpath("//table[.//th[normalize-space(.)='Product Category']]//tbody//tr/td[position() = count(ancestor::table//th[normalize-space(.)='Product Category']/preceding-sibling::th)+1]");
	public static final By productModelNo=By.xpath("//input[@id='modelNo']");
	public static final By productModelName=By.xpath("//input[@id='submodelName']");
	public static final By clickOnProductCategoryDrop =By.xpath("//form[@id='productModelForm']//select[@id='modelName']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By productCategoryList =By.xpath("//select[@id='modelName']//following-sibling::div//div[1]//button//label");
	public static final By clickOndProductCategoryTxt =By.xpath("//form[@id='productModelForm']//label[text()='Product Category']");
	public static final By clickOnCompanyDrop =By.xpath("//form[@id='productModelForm']//select[@id='plantName']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By companyList =By.xpath("//select[@id='plantName']//following-sibling::div//div[1]//button//label");
	public static final By clickOndCompanyNameTxt =By.xpath("//form[@id='productModelForm']//label[text()='Company Name']");
	public static final By clickOnSpecielProductCategoryDrop =By.xpath("//form[@id='productModelForm']//select[@id='specialCategory']//following-sibling::div//span[@class='multiselect-selected-text']");
	public static final By SpecielProductCategoryList =By.xpath("//select[@id='specialCategory']//following-sibling::div//div[1]//button//label");
	public static final By clickOnSpecielProductCategoryTxt =By.xpath("//form[@id='productModelForm']//label[text()='Special Product Category']");
	
	
	public void clcikOnProductModelButton() {
		clickOnElement1(clickOnProductModelBtn);
	}
	
	public void clcikOnProductModelSaveButton() {
		clickOnElement1(clickOnProductModelSaveBtn);
	}
	
	public List<String> getActiveProductCategoryNames() {
        LoggerUtil.info("Fetching Product Category names from Product Model...");
        List<String> raw = null;
		try {
			raw = getVisibleTexts(listOfProductCategoryData, 8);
		} catch (TimeoutException e) {
			
			e.printStackTrace();
		}
        // De-duplicate while preserving encounter order
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String s : raw) {
            if (s != null) {
                String v = s.trim();
                if (!v.isEmpty()) set.add(v);
            }
        }
        List<String> names = new ArrayList<>(set);
        LoggerUtil.info("Product Model categories fetched (unique): " + names);
        return names;
    }
	
	
	
	public void enterdOnCommonProductModelAdditionForm(String ProductModelNum,String ProductCategoryValue,String ProductModelName,String Company,String SpecialProductCategory) {
	
		enterdOnProductModelNum(ProductModelNum);
		selectOnProductCategoryValueByText(ProductCategoryValue);
		enterdOnProductModelName(ProductModelName);
		selectOnCompanyValueByText(Company);
		selectOnSpecialProductCategoryValueByText(SpecialProductCategory);
		clcikOnProductModelSaveButton();
	}
	
	public void enterdOnProductModelNum(String num) {
		
		sendKeysToTextBox(productModelNo, num);
		
	}
	
	public void enterdOnProductModelName(String name) {
		
		sendKeysToTextBox(productModelName, name);
		
	}
	
	/*   --------- -----------------------START PRODUCT MODEL DROPDOWN WITH THE HELP OF NUMBER-------------------------------*/
	
	public void selectedOnProductCategoryNum(int selectNumberOfProductCategory) {
		clickOnElement1(clickOnProductCategoryDrop);
		
		List<WebElement> productCategoryListOption = driver.findElements(productCategoryList);

		Set<String> selectedLabels = new HashSet<String>();
		Random rand = new Random();

		while (selectedLabels.size() < selectNumberOfProductCategory) {
			int index = rand.nextInt(productCategoryListOption.size());
			WebElement option = productCategoryListOption.get(index);
			String label = option.getText().trim().toLowerCase();

			if (!selectedLabels.contains(label)) {
				option.click(); 
				selectedLabels.add(label);
			}
		}
		clickOnElement1(clickOndProductCategoryTxt);
	}
	
	public void selectedOnCompanyNum(int selectNumberOfCompanyNum) {
		clickOnElement1(clickOnCompanyDrop);
		
		List<WebElement> companyListOption = driver.findElements(companyList);

		Set<String> selectedLabels = new HashSet<String>();
		Random rand = new Random();

		while (selectedLabels.size() < selectNumberOfCompanyNum) {
			int index = rand.nextInt(companyListOption.size());
			WebElement option = companyListOption.get(index);
			String label = option.getText().trim().toLowerCase();

			if (!selectedLabels.contains(label)) {
				option.click(); 
				selectedLabels.add(label);
			}
		}
		clickOnElement1(clickOndCompanyNameTxt);
	}
	
	public void selectOnSpecielProductCategoryNum(int SpecielProductCategoryNum) {
		clickOnElement1(clickOnSpecielProductCategoryDrop);
		
		List<WebElement> specielProductCategoryListOption = driver.findElements(SpecielProductCategoryList);

		Set<String> selectedLabels = new HashSet<String>();
		Random rand = new Random();

		while (selectedLabels.size() < SpecielProductCategoryNum) {
			int index = rand.nextInt(specielProductCategoryListOption.size());
			WebElement option = specielProductCategoryListOption.get(index);
			String label = option.getText().trim().toLowerCase();

			if (!selectedLabels.contains(label)) {
				option.click(); 
				selectedLabels.add(label);
			}
		}
		clickOnElement1(clickOnSpecielProductCategoryTxt);
	}
	
	/*   --------- -----------------------END PRODUCT MODEL DROPDOWN WITH THE HELP OF NUMBER-------------------------------*/
	
	/*   --------- -----------------------START PRODUCT MODEL DROPDOWN WITH THE HELP OF TEXT-------------------------------*/
	
	// 1) Single company label
	public void selectOnCompanyValueByText(String companyLabel) {
	    clickOnElement1(clickOnCompanyDrop);

	    List<WebElement> options = driver.findElements(companyList);
	    String target = companyLabel == null ? "" : companyLabel.trim().toLowerCase();

	    boolean matched = false;
	    for (WebElement option : options) {
	        String label = option.getText().trim().toLowerCase();
	        if (label.equals(target)) {
	            option.click();
	            LoggerUtil.info("Company selected: " + companyLabel);
	            matched = true;
	            break;
	        }
	    }
	    if (!matched) {
	        LoggerUtil.fail("Company not found in list: " + companyLabel);
	        throw new AssertionError("Company not found: " + companyLabel);
	    }
	}

	// 2) Multiple company labels (varargs)
	public void selectOnCompanyValuesByText(String... companyLabels) {
	    if (companyLabels == null || companyLabels.length == 0) {
	        LoggerUtil.fail("No company labels provided.");
	        throw new IllegalArgumentException("Provide at least one company label.");
	    }
	    clickOnElement1(clickOnCompanyDrop);

	    List<WebElement> options = driver.findElements(companyList);
	    Map<String, WebElement> optionMap = new HashMap<>();
	    for (WebElement opt : options) {
	        optionMap.put(opt.getText().trim().toLowerCase(), opt);
	    }

	    Set<String> alreadyClicked = new HashSet<>();
	    for (String label : companyLabels) {
	        String key = label == null ? "" : label.trim().toLowerCase();
	        WebElement opt = optionMap.get(key);
	        if (opt != null && !alreadyClicked.contains(key)) {
	            opt.click();
	            alreadyClicked.add(key);
	            LoggerUtil.info("Company selected: " + label);
	        } else {
	            LoggerUtil.fail("Company not found in list: " + label);
	            throw new AssertionError("Company not found: " + label);
	        }
	    }
	}
	
	// 1) Single Product Category label
	public void selectOnProductCategoryValueByText(String ProductCategoryLabels) {
	    clickOnElement1(clickOnProductCategoryDrop);

	    List<WebElement> options = driver.findElements(productCategoryList);
	    String target = ProductCategoryLabels == null ? "" : ProductCategoryLabels.trim().toLowerCase();

	    boolean matched = false;
	    for (WebElement option : options) {
	        String label = option.getText().trim().toLowerCase();
	        if (label.equals(target)) {
	            option.click();
	            LoggerUtil.info("Supplier selected: " + ProductCategoryLabels);
	            matched = true;
	            break;
	        }
	    }
	    if (!matched) {
	        LoggerUtil.fail("Supplier not found in list: " + ProductCategoryLabels);
	        throw new AssertionError("Supplier not found: " + ProductCategoryLabels);
	    }
	}

	// 2) Multiple Product Category labels (varargs)
	public void selectOnProductCategoryValuesByText(String... ProductCategoryLabels) {
	    if (ProductCategoryLabels == null || ProductCategoryLabels.length == 0) {
	        LoggerUtil.fail("No ProductCategory labels provided.");
	        throw new IllegalArgumentException("Provide at least one ProductCategory label.");
	    }
	    clickOnElement1(clickOnProductCategoryDrop);

	    List<WebElement> options = driver.findElements(productCategoryList);
	    Map<String, WebElement> optionMap = new HashMap<>();
	    for (WebElement opt : options) {
	        optionMap.put(opt.getText().trim().toLowerCase(), opt);
	    }

	    Set<String> alreadyClicked = new HashSet<>();
	    for (String label : ProductCategoryLabels) {
	        String key = label == null ? "" : label.trim().toLowerCase();
	        WebElement opt = optionMap.get(key);
	        if (opt != null && !alreadyClicked.contains(key)) {
	            opt.click();
	            alreadyClicked.add(key);
	            LoggerUtil.info("ProductCategory selected: " + label);
	        } else {
	            LoggerUtil.fail("ProductCategory not found in list: " + label);
	            throw new AssertionError("ProductCategory not found: " + label);
	        }
	    }
	}
	
	// 1) Single Special Product Category label
	public void selectOnSpecialProductCategoryValueByText(String SpecialProductCategory) {
	    clickOnElement1(clickOnSpecielProductCategoryDrop);

	    List<WebElement> options = driver.findElements(SpecielProductCategoryList);
	    String target = SpecialProductCategory == null ? "" : SpecialProductCategory.trim().toLowerCase();

	    boolean matched = false;
	    for (WebElement option : options) {
	        String label = option.getText().trim().toLowerCase();
	        if (label.equals(target)) {
	            option.click();
	            LoggerUtil.info("Special Product Category selected: " + SpecialProductCategory);
	            matched = true;
	            break;
	        }
	    }
	    if (!matched) {
	        LoggerUtil.fail("Special Product Category not found in list: " + SpecialProductCategory);
	        throw new AssertionError("Special Product Category not found: " + SpecialProductCategory);
	    }
	}

	// 2) Multiple Special Product Category labels (varargs)
	public void selectOnSpecialProductCategoryValuesByText(String... SpecialProductCategory) {
	    if (SpecialProductCategory == null || SpecialProductCategory.length == 0) {
	        LoggerUtil.fail("No Special Product Category labels provided.");
	        throw new IllegalArgumentException("Provide at least one Special Product Category label.");
	    }
	    clickOnElement1(clickOnSpecielProductCategoryDrop);

	    List<WebElement> options = driver.findElements(SpecielProductCategoryList);
	    Map<String, WebElement> optionMap = new HashMap<>();
	    for (WebElement opt : options) {
	        optionMap.put(opt.getText().trim().toLowerCase(), opt);
	    }

	    Set<String> alreadyClicked = new HashSet<>();
	    for (String label : SpecialProductCategory) {
	        String key = label == null ? "" : label.trim().toLowerCase();
	        WebElement opt = optionMap.get(key);
	        if (opt != null && !alreadyClicked.contains(key)) {
	            opt.click();
	            alreadyClicked.add(key);
	            LoggerUtil.info("Special Product Category selected: " + label);
	        } else {
	            LoggerUtil.fail("Special Product Category not found in list: " + label);
	            throw new AssertionError("Special Product Category not found: " + label);
	        }
	    }
	}
	
	/*   --------- -----------------------END PRODUCT MODEL DROPDOWN WITH THE HELP OF TEXT-------------------------------*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
