package com.saucelab.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.saucelab.qa.baseclass.BaseClass;
import com.saucelab.qa.utils.Excel;
import com.saucelab.qa.utils.Screenshot;
import com.saucelab.qa.utils.Utils;

public class LoginPage extends BaseClass{
	
	Screenshot scrn;
	
	//xpath
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id = 'password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name = 'login-button']")
	WebElement login;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement error;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn'] ")
	WebElement menuButton;
	
	@FindBy(xpath = "//a[@id = 'logout_sidebar_link'] ")
	WebElement logout;
	
	//constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
		scrn= new Screenshot();
	}
	
	//actions
	
	public void addLoginCredentials(int row, int col) throws Exception {
		Excel.createExcel("C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\excel\\user_data.xlsx", "user");
		addUsername(row,col);
		col++;
		addPassword(row,col);
		
		clickLogin();
		
		
	}
	
	public void addUsername(int row , int cell) throws Exception {
		Excel.createExcel("C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\excel\\user_data.xlsx", "user");
		String usernameData = Excel.getCellData(row, cell);
		
		username.click();
		
		username.sendKeys(usernameData);
	}
	
	public void addPassword(int row , int cell) throws Exception {
		Excel.createExcel("C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\excel\\user_data.xlsx", "user");
		String passwordData = Excel.getCellData(row, cell);
		password.click();
		
		password.sendKeys(passwordData);
	}
	
	public void clickLogin() throws Exception {
		login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		

	}
	
	public void verifyPageURL() throws Exception {
		String actualURL = driver.getCurrentUrl();
		//System.out.print(actualURL);
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		
		if(actualURL.equals(expectedURL)) {
			Reporter.log("......... Logged in successfully ..........");
		}else {
			Reporter.log("......... failed to login might be username or password is incorrect .........");
		}
		scrn.takeScreenshot("verify_page_url");
	}
	
	public void clickLogoutButton() {
		menuButton.click();
		logout.click();
	}

}
