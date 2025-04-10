package com.nse.page;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.internal.org.jline.utils.Log;

public class StockPage {
    WebDriver driver;
    WebDriverWait wait;
    
    private static final Logger logger = LogManager.getLogger(StockPage.class);
    
    By StockCurrentPrice= By.xpath(".//span[@id=\"quoteLtp\"]");
    By StockHighPrice = By.xpath(".//span[@id=\"week52highVal\"]");
    By StockLowPrice = By.xpath(".//span[@id=\"week52lowVal\"]");
    
    
   
    public StockPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public String verifystockprice() {
    	logger.info("Verify Stock Current price");
    	System.out.println("Verify Stock Current price");
    	 WebElement currentPrice = driver.findElement(StockCurrentPrice);
         wait.until(ExpectedConditions.visibilityOf(currentPrice));
        return driver.findElement(StockCurrentPrice).getText();
    	
    	
    }
    
    public String verifystockhighprice() {
    	logger.info("Verify Stock High Current price");
    	System.out.println("Verify Stock High Current price");
        wait.until(ExpectedConditions.visibilityOfElementLocated(StockHighPrice));
        return driver.findElement(StockHighPrice).getText();
    	
    	
    }
    
    public String verifystocklowprice() {
    	logger.info("Verify Stock Low Current price");
    	System.out.println("Verify Stock Low Current price");
        wait.until(ExpectedConditions.visibilityOfElementLocated(StockLowPrice));
        return driver.findElement(StockLowPrice).getText();
    	
    	
    }
}