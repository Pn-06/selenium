package com.saucelab.qa.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.saucelab.qa.utils.Utils;

public class BaseClass {
	public static WebDriver driver;
	
	public void setBrowser(String browser, String url) throws Exception {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Desktop\\Drivers\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else {
			throw new Exception("Invalid Browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		
		driver.get(url);
		
	}

}
