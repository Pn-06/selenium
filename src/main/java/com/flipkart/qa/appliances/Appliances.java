package com.flipkart.qa.appliances;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.flipkart.qa.baseclass.Baseclass;
import com.flipkart.qa.utils.Screenshot;

public class Appliances extends Baseclass{
	
	// xpath
	@FindBy(xpath = "//span[contains(text(),'✕')]")
	WebElement close;
	
	@FindBy(xpath = "//*[text() = 'Appliances']")
	WebElement appliances;
	
//	@FindBy(xpath = "//img[@class = 'kJjFO0 _3DIhEh' and @alt = 'dd']")
//	WebElement product;
	
	@FindBy(xpath = "//h1[@class= 'yhB1nd']//span")
	WebElement itemTitle;
	
	@FindBy(xpath = "//button[text() = 'Buy Now']")
	WebElement buyNow;
	
	@FindBy(xpath = "//*[contains(text() , 'Login or Signup')]")
	WebElement loginSignup;
	
	Screenshot scrn = new Screenshot();
			
	//constructor
	
	public Appliances() {
		PageFactory.initElements(driver, this);
	}
	
	//  action
	
	public void clickOnAppliances() throws Exception {
		this.close.click();
		
		this.appliances.click();
		Thread.sleep(2000);
		
		Reporter.log(".... user clicked on appliances ....");
		scrn.snapShot("appliances");
	}
	
	public void verifyAppliancesPage() throws Exception {
		
		String title = driver.getTitle();
		
		//Boolean wait = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.titleContains(title));
		
		if(title.equals("Tv & Appliances Big Saving Days Sale: 4th - 10th May | Upto 75% Off")) {
			
			Reporter.log(".... user is in appliances page ....");
			scrn.snapShot("AppliancesPage");
			
		}else {
			Reporter.log(".... user is not in appliances page ....");
		}
	}
	
	public void clickOnProduct(int index) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,1200)");
		
		List<WebElement> result = driver.findElements(By.xpath("//div[@class='_1pVhAI']//div//a"));
		
		
		
		if(index >= 0 && index < result.size()) {
			WebElement product = result.get(index);
			product.click();
			
			Reporter.log(".... product Clicked ....");
			
		}else {
			Reporter.log(".... invalid indexing ....");
		}
		scrn.snapShot("product");
		
	}
	
	
	
	public void clickOnItem(int index) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,1200)");
		
		String parent =driver.getWindowHandle();
		
		List<WebElement> result = driver.findElements(By.xpath("//*[@class='_2n7i6c']//div//a"));
		
		if(index >= 0 && index < result.size()) {
			WebElement item = result.get(index);
			item.click();
			Reporter.log(".... item Clicked ....");
			scrn.snapShot("item");
			
			
			
			Set<String> handles = driver.getWindowHandles();
			Iterator it = handles.iterator();
			
			while(it.hasNext()) {
				driver.switchTo().window((String) it.next());
				
//				String title = itemTitle.getText();
//				Reporter.log("Item name is :" + title);

				
				
			}
			//Thread.sleep(3000);
			this.clickOnBuyNow();
			//Thread.sleep(3000);
			
			String login_text = loginSignup.getText();
			Assert.assertEquals(login_text, "LOGIN OR SIGNUP");
			Reporter.log("...loginsignuppage....");
			scrn.snapShot("loginsignuppage");
			driver.close();
				
			driver.switchTo().window(parent);
			
		}else {
			Reporter.log(".... invalid indexing ....");
		}
		
		
	}
	
	public void clickOnBuyNow() throws Exception {
		buyNow.click();
		Reporter.log(".... buy now Clicked ....");
		scrn.snapShot("buynow");
	}
	
	

}
