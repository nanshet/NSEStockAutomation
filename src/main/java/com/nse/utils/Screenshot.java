package com.nse.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot{
	
	
	public static void takeScreenshot(WebDriver driver, String stockname) {
		
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		 try {
			FileUtils.copyFile(src, new File("screenshots/" + stockname +"_"+timestamp+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}