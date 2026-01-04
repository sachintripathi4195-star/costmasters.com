package com.Tests;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import com.helper.LoggerUtil;
@Listeners(com.helper.TestListeners.class)
public class LinkdienReadingData {

	
	 static  WebDriver driver;
	 public static void main(String[] args) throws InterruptedException {
		
		 driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		driver.get("https://www.linkedin.com/posts/neeraj-jamwal-446410129_procurement-purchaseprofessionals-vendordevelopment-activity-7336004908883615744-ywHv?utm_source=share&utm_medium=member_desktop&rcm=ACoAABEbBHoBtYjKrfg1iqfWn5qWpzIyf4GrdR4");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement clicksigninbtn = driver.findElement(By.xpath("//button[contains(@class, 'sign-in-modal__outlet-btn')]"));
		
		js.executeScript("arguments[0].click();", clicksigninbtn);
		 
		Thread.sleep(3000);
		
		WebElement enteremail = driver.findElement(By.xpath("//input[@name='session_key']"));
		enteremail.sendKeys("anuragsharma51@ymail.com");
		
		WebElement enterpassword = driver.findElement(By.xpath("//input[@name='session_password']"));
		enterpassword.sendKeys("Anurag@2299#");
		
		WebElement clickloginbtn = driver.findElement(By.xpath("//button[contains(.,'Sign in') and @type='submit']"));
		
		
		js.executeScript("arguments[0].click();", clickloginbtn);
		
		Thread.sleep(4000);
//		WebElement mostrecentbtn = driver.findElement(By.xpath("//button[@id='ember64']/span/following-sibling::span[normalize-space()='Most recent']"));
//		js.executeScript("arguments[0].click();", args)
		Thread.sleep(4999);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		String commentvaluexpath ="//*[@class='comments-comment-list__container']/article/div/following-sibling::div/div/following-sibling::div/section/div/div/span/div/span";
        String nameXPath = "//*[@class=\"comments-comment-list__container\"]/article/div/div/a[2]/h3/span[@class='comments-comment-meta__description-title']";

        
        boolean loadMoreExists = true;
        int commentsPrinted = 0;

        
        while (loadMoreExists) {
            try {
                
                List<WebElement> comments = driver.findElements(By.xpath(commentvaluexpath));
                List<WebElement> names = driver.findElements(By.xpath(nameXPath));
                
               
                for (int i = 0; i < comments.size(); i++) {
                    String commentText = comments.get(i).getText().trim();
                    String commenterName = names.get(i).getText().trim();
                    if (!commentText.isEmpty() && !commenterName.isEmpty()) {
                        System.out.println(commenterName + ": " + commentText);  // Print name and comment
                        LoggerUtil.info(commenterName + ": " + commentText);
                        commentsPrinted++;
                    }
                }

                
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

               
                WebElement loadMoreButton = driver.findElement(By.xpath("//*[normalize-space()='Load more comments']/button/following-sibling::button/span"));
                
                if (loadMoreButton.isDisplayed()) {
                    loadMoreButton.click();
                    System.out.println("Clicked 'Load more comments'...");

                   
                    Thread.sleep(4000);  
                } else {
                    loadMoreExists = false;  
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException encountered. Retrying...");
                
                WebElement loadMoreButton = driver.findElement(By.xpath("//*[normalize-space()='Load more comments']/button/following-sibling::button/span"));
                loadMoreButton.click();
                Thread.sleep(4000);
            } catch (NoSuchElementException e) {
                
                loadMoreExists = false;
                System.out.println("No more comments to load.");
            }
        }

        System.out.println("Successfully printed " + commentsPrinted + " comments.");
        driver.quit();  
    }
	
	
	
	
	
}
