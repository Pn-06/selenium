package com.saucelab.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.saucelab.qa.baseclass.BaseClass;
import com.saucelab.qa.utils.Screenshot;

public class AddToCart extends BaseClass{
	Screenshot scrn;
	ProductPage productpage;
	public String[] Aproductnames = new String[10];
	
	//xpath
	@FindBy(xpath = "//*[contains(text(),'Add to cart')")
	WebElement add_to_cart;
	
	@FindBy(xpath = "//*[contains(@class,'shopping_cart_link')]")
	WebElement shopping_cart_icon;
	
	
	@FindBy(xpath = "//*[contains(@class,'shopping_cart_badge')]")
	WebElement cart_badges;
	
	
	
	
	//constructor
	public AddToCart() {
		PageFactory.initElements(driver, this);
		
		productpage = new ProductPage();
		scrn = new Screenshot();
	}
	
	
	
	
	//actions
	public void clickAddToCart(int index) throws Exception {
		List<WebElement> rst = driver.findElements(By.xpath("//*[contains(text(),'Add to cart')]"));
		WebElement addCartbutton = rst.get(index);
		addCartbutton.click();
		
		
		scrn.takeScreenshot("addtocart");
		Reporter.log( " product got added to cart ......");
		
		
	}
	
	public int getCartDetails() {
		String count = cart_badges.getText();
		int actualcount = Integer.parseInt(count);
		
		return actualcount;
		//System.out.println(count);
	}
	
	
	
	public void clickAddToCart() throws Exception {
		List<WebElement> rst = driver.findElements(By.xpath("//*[contains(text(),'Add to cart')]"));
		int count =0;
		
		for (int i =0 ; i<rst.size() ; i++) {
			WebElement addCartbutton = rst.get(i);
			addCartbutton.click();
			count++;
		}
		if(count == getCartDetails()) {
			Reporter.log( count + " got added to cart ......");
		}else {
			Reporter.log( " count of item added is mismatched ......");
		}
		scrn.takeScreenshot("addtocart");
		Reporter.log( " product got added to cart ......");
	}
	
	public void clickShoppingCart() throws Exception {
		shopping_cart_icon.click();
		Reporter.log("..... Clicked on shopping cart .....");
		scrn.takeScreenshot("ShoppingCart");
	}
	
	public void verifyProductName(int index) throws Exception {
		String name = productpage.getProductName(index);
		if(productpage.productName.equals(name)) {
			Reporter.log(".... name got matched ..... ");
		}else {
			Reporter.log(".... name mismatched ..... ");
		}
		scrn.takeScreenshot("verifyProductName");
	}
	
	public void verifyProductName() throws Exception {
		
		List<WebElement> rst = driver.findElements(By.xpath("//*[contains(@class,'inventory_item_name')]"));
		for(int i=0; i<rst.size(); i++) {
			WebElement product = rst.get(i);
			 
			Aproductnames[i] = product.getText();
			
			if(Aproductnames[i].equals(productpage.getProductName(i))) {
				Reporter.log(".... name got matched ..... ");
			}else {
				Reporter.log(".... name mismatched ..... ");
			}
		}
		scrn.takeScreenshot("verifyProductName");
	}

}
