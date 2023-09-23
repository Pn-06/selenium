package com.saucelab.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.saucelab.qa.baseclass.BaseClass;
import com.saucelab.qa.utils.Excel;
import com.saucelab.qa.utils.Screenshot;

public class CheckoutPage extends BaseClass{
	Screenshot scrn;
	
	//xpath
	@FindBy(xpath = "//*[contains(@id,'checkout')]")
	WebElement check_out;
	
	
	@FindBy(xpath = "//*[contains(@id,'first-name')]")
	WebElement firstname;
	
	@FindBy(xpath = "//*[contains(@id,'last-name')]")
	WebElement lastname;
	
	@FindBy(xpath = "//*[contains(@id,'postal-code')]")
	WebElement postalcode;
	
	
	@FindBy(xpath = "//*[contains(@class,'header_secondary_container')]")
	WebElement checkout_page_;
	
	@FindBy(xpath = "//*[contains(@id,'continue')]")
	WebElement continue0;
	
	
	//constructor
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
		
		scrn = new Screenshot();
		
	}
	
	//actions
	
	public void verifyCheckOutPage() throws Exception {
		String checkout_page = checkout_page_.getText();
		
		if(checkout_page.equals("Checkout: Your Information")) {
			Reporter.log(" ..... user is in checkout page .....");
		}else {
			Reporter.log(" ..... user is not in checkout page .....");
		}
		scrn.takeScreenshot("verifyCheckOutPage");
	}
	
	public void clickCheckOut() throws Exception {
		check_out.click();
		Reporter.log("Clicked on checkout");
		scrn.takeScreenshot("clickCheckOut");
	}
	
	public void addCheckOutDetails(int row , int col) throws Exception {
		addFirstName(row,col);
		col++;
		addLastName(row,col);
		col++;
		addPostalCode(row,col);
		
		Reporter.log(" ..... user added checkoutdetails .....");
		scrn.takeScreenshot("addCheckOutDetails");
	}
	
	public void addFirstName(int row, int col) throws Exception {
		Excel.createExcel("C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\excel\\user_data.xlsx", "user");
		String first_name = Excel.getCellData(row, col);
		firstname.click();
		firstname.sendKeys(first_name);
	}
	
	public void addLastName(int row, int col) throws Exception {
		Excel.createExcel("C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\excel\\user_data.xlsx", "user");
		String last_name = Excel.getCellData(row, col);
		lastname.click();
		lastname.sendKeys(last_name);
	}
	
	public void addPostalCode(int row, int col) throws Exception {
		Excel.createExcel("C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\excel\\user_data.xlsx", "user");
		int postal_code = Excel.getNumericCellData(row, col);
		
		postalcode.click();
		postalcode.sendKeys(String.valueOf(postal_code));
	}
	
	public void clickContinue() throws Exception {
		continue0.click();
		Reporter.log(" ..... user Clicked Continue .....");
		scrn.takeScreenshot("clickContinue");
	}

}
