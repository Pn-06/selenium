package com.saucelab.qa.testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucelab.qa.baseclass.BaseClass;
import com.saucelab.qa.pages.AddToCart;
import com.saucelab.qa.pages.CheckoutPage;
import com.saucelab.qa.pages.HomePage;
import com.saucelab.qa.pages.LoginPage;
import com.saucelab.qa.pages.ProductPage;

public class TestClass extends BaseClass{
	
	HomePage homepage;
	LoginPage loginpage;
	AddToCart addtocart;
	ProductPage productpage;
	CheckoutPage checkoutpage;
	
	public TestClass() {
		super();
		
		
	}
	
	
	
	@Parameters({ "browser_flag" , "url" })
	@BeforeMethod
	public void callBrowser(String browser_flag,String url) throws Exception {
		setBrowser(browser_flag,url);
		
		homepage = new HomePage();
		loginpage = new LoginPage();
		addtocart = new AddToCart();
		productpage = new ProductPage();
		checkoutpage = new CheckoutPage();
	}
	
	
	@Test(priority =1)
	public void test_user_01() throws Exception {
		homepage.verifyHomePage();

		loginpage.addLoginCredentials(1,0);
		loginpage.verifyPageURL();
		productpage.getProductName();
		
		//productpage.getProductName(5);
		
		addtocart.clickAddToCart();
		
		addtocart.getCartDetails();
		
		//addtocart.clickAddToCart(5);
		
		
		addtocart.clickShoppingCart();
		addtocart.verifyProductName();
		checkoutpage.clickCheckOut();
		checkoutpage.verifyCheckOutPage();
		checkoutpage.addCheckOutDetails(1, 2);
		checkoutpage.clickContinue();
		
		
		
		//addtocart.verifyProductName(3);
		
		
	}
	
	@Test(priority =2)
	public void test_user_02() throws Exception {
		homepage.verifyHomePage();

		loginpage.addLoginCredentials(2,0);
		loginpage.verifyPageURL();
		
	}
//	
//	@Test(priority =1)
//	public void test_user_03() throws Exception {
//		homepage.verifyHomePage();
//
//		loginpage.addLoginCredentials(3,0);
//		loginpage.verifyPageURL();
//		//productpage.getProductName();
//		
//		productpage.getProductName(2);
//		
//		//addtocart.clickAddToCart();
//		
//		addtocart.clickAddToCart(2);
//		
//		addtocart.clickShoppingCart();
//		addtocart.verifyProductName();
//		checkoutpage.clickCheckOut();
//		checkoutpage.verifyCheckOutPage();
//		checkoutpage.addCheckOutDetails(1, 2);
//		checkoutpage.clickContinue();
//		
//		
//		
//		//addtocart.verifyProductName(3);
//		
//		
//	}
//	
	
	
	@Test(priority =3)
	public void test_user_03() throws Exception {
		homepage.verifyHomePage();

		loginpage.addLoginCredentials(4,0);
		loginpage.verifyPageURL();
		//productpage.getProductName();
		
		productpage.getProductName(3);
		
		//addtocart.clickAddToCart();
		
		addtocart.clickAddToCart(3);
		
		addtocart.clickShoppingCart();
		addtocart.verifyProductName();
		checkoutpage.clickCheckOut();
		checkoutpage.verifyCheckOutPage();
		checkoutpage.addCheckOutDetails(4, 2);
		checkoutpage.clickContinue();
		
		
		
		//addtocart.verifyProductName(3);
		
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
