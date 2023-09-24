package com.flipkart.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.flipkart.qa.baseclass.Baseclass;

public class Screenshot extends Baseclass{
	
	public void snapShot(String scrnShotName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File imgName = new File("./screenshots/" + scrnShotName + ".png");
		
		FileUtils.copyFile(file,imgName);
		
		Reporter.log("<a href = \"   C:\\Users\\pinayak\\eclipse-workspace\\flipkart\\screenshots\\" + scrnShotName  +".png  \"> Link </a>");
	}

}
