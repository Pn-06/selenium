package com.filpkart.qa.Testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.filpkart.qa.Baseclass.BaseClass;
import com.filpkart.qa.Pages.Product;

public class TestClass extends BaseClass{
	Product pd;
	
	public TestClass() {
		super();
	}
	
	
	@Parameters({"browse"})
	@BeforeMethod
	
	public void setBrowserdetails(String browse ) {
		this.setBrowser(browse);
		
		pd = new Product();
	}
	
	@Test(priority =1)
	public void test() throws Exception {
		pd.productSearch("Laptop");
		pd.selectItem(0);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		
	}

}
