package com.saucelab.qa.utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.saucelab.qa.baseclass.BaseClass;

public class Screenshot extends BaseClass{
	
	public void takeScreenshot(String imgName) throws Exception {
		File scrn = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("./screenshot/" +imgName +".png");
		
		FileUtils.copyFile(scrn, destFile);
		
		Reporter.log(" <a  href =  \" C:\\Users\\HP\\eclipse-workspace\\saucelabdemo\\screenshot\\" +imgName + ".png \" > link </a> ");
	}

}
