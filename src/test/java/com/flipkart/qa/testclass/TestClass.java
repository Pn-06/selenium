package com.flipkart.qa.testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.appliances.Appliances;
import com.flipkart.qa.baseclass.Baseclass;

public class TestClass extends Baseclass{
	
	Appliances appliances;
	
	
	//constructor
	
	public TestClass() {
		super();
	}
	
	@Parameters({ "browser_flag" , "url"})
	
	@BeforeMethod
	public void browserset(String browser_flag, String url) throws Exception {
		this.browserInitialization(browser_flag, url);
		
		appliances =new Appliances();
	}
	
	
	@Test
	public void test001() throws Exception {
		appliances.clickOnAppliances();
		appliances.verifyAppliancesPage();
		appliances.clickOnProduct(0);
		appliances.clickOnItem(0);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
