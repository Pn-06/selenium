package com.saucelab.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.saucelab.qa.baseclass.BaseClass;
import com.saucelab.qa.utils.Screenshot;
import com.saucelab.qa.utils.Utils;

public class ProductPage extends BaseClass{
	
	
	public String[] productnames = new String[Utils.ARRAY_SIZE];
	public String productName;
	
	//xpath
//	@FindBy(xpath = "//*[contains(@class,'inventory_item_name')]")
//	WebElement product_name;
	
	
	//constructor
	public ProductPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//actions
	public String getProductName(int index) {
		List<WebElement> rst = driver.findElements(By.xpath("//*[contains(@class,'inventory_item_name')]"));
		WebElement product = rst.get(index);
		
		productName = product.getText();
		
		Reporter.log( " getproductName function() ......");
		
		;
		
		return productName;
	}
	
	
	
	public void getProductName() {
		List<WebElement> rst = driver.findElements(By.xpath("//*[contains(@class,'inventory_item_name')]"));
		for(int i=0; i<rst.size(); i++) {
			WebElement product = rst.get(i);
			 
			 productnames[i] = product.getText();
		}
		Reporter.log( " getproductName function ......");
		
	}
	
	
	

}
