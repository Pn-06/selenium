package com.saucelab.qa.pages;

import org.openqa.selenium.support.PageFactory;
import  org.testng.Assert;
import org.testng.Reporter;

import com.saucelab.qa.baseclass.BaseClass;
import com.saucelab.qa.utils.Screenshot;

public class HomePage extends BaseClass{
	Screenshot scrn;
	
	public String actualTitle = driver.getTitle();
	
	//constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
		scrn = new Screenshot();
	}
	
	public void verifyHomePage() throws Exception {
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle);
		scrn.takeScreenshot("title");
		Reporter.log("....... Title got verified .........");
	}

}
