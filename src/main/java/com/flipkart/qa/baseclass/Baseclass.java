package com.flipkart.qa.baseclass;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.flipkart.qa.utils.UtilsClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
	
	
	public static WebDriver driver;
	// ....... setup .....
	
	public void browserInitialization(String browser, String url) throws Exception {
		
		// ......... browser selection .......
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new  EdgeDriver();
		}else {
			throw new Exception("invalid browser");
		}
		
		//........ browser customize .......
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilsClass.PAGE_LOAD));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilsClass.IMPLICIT_WAIT));
		
		
		// ....... opening flipkart .......
		
		driver.get(url);
		
		
		Reporter.log("........ flipkart url loaded successful ........");
	}
	
	

}
