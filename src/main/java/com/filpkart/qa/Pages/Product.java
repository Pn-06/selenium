package com.filpkart.qa.Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.filpkart.qa.Baseclass.BaseClass;

public class Product extends BaseClass{
	//Elements
	@FindBy(xpath = "*//input[@placeholder='Search for Products, Brands and More']")
	WebElement search;
	
	@FindBy(xpath = " *//button[text()='Add to cart'] ")
	WebElement cart;
	
	@FindBy(xpath = "*//span[text()='Place Order']")
	WebElement placeOrder;
	
	
	
	//constructor
	public Product() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Product searching
	public void productSearch(String productName) {
		search.click();
		search.sendKeys(productName);
		search.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Laptop- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	
	//selecting Item
	public void selectItem(int index) throws Exception {
		

		List<WebElement> rslt = driver.findElements(By.xpath(" *//div[@class='_1AtVbE col-12-12']/div/div/div "));
		
		if(index >=0 && index < rslt.size()) {
			
			WebElement item = rslt.get(index);
			item.click();
			
			String mainPage = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			
			for(String page : handles) {
				if(!page.equals(mainPage)) {
					driver.switchTo().window(page);
					
					break;
				}
			}
			
			clickToCart();
			clickPlaceOrder();
			
			driver.close();
			driver.switchTo().window(mainPage);

			
		}
			
	}		
		
	
	
	//next operations
	public void clickToCart() {
		cart.click();
		
	}
	
	public void clickPlaceOrder() {
		placeOrder.click();
		
	}

	
	
}
