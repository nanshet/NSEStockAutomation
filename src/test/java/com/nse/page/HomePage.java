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

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    // Locators
    By searchBox = By.xpath(".//div[@class=\"rbt\"]/div/input[@role=\"combobox\"]");
    By searchbtn = By.xpath(".//span[@class=\"input-group-text search_icon\"]");
    By stockinfopage = By.xpath(".//th[text()=\"Order book\"]");
    By dropdown = By.xpath(".//div[@class=\"rbt-menu dropdown-menu show\"]");
    By stockNme = By.xpath(".//div[@class=\"autocompleteList\"]//p/span[contains(text(),\"Tata Motors\")]");

    
    
    public HomePage(WebDriver driver, WebDriverWait wait) {
       this.driver = driver;
       this.wait = wait;
    }

    
    public void navigatetoNSE(String stockName) {
    	
    	
    	driver.get("https://www.nseindia.com/");
    	WebElement search = driver.findElement(searchBox);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        wait.until(ExpectedConditions.titleContains("NSE"));
        logger.info("Navigate to URL successfully");
        System.out.println("Navigate to URL successfully");
    }
    
    public void searchStock(String stockName) throws InterruptedException {
    	
        WebElement search = driver.findElement(searchBox);
        WebElement searchbutton = driver.findElement(searchbtn);
        search.click();
        search.sendKeys(stockName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement dropdownlist = driver.findElement(dropdown);
        wait.until(ExpectedConditions.visibilityOf(dropdownlist));
        By stockn = By.xpath(".//a[@class=\"dropdown-item\"]/div/p/span[text()='"+stockName+"']");
        WebElement stockname = driver.findElement(stockn);
        wait.until(ExpectedConditions.elementToBeClickable(stockname));
        String txt = stockname.getText();
        System.out.println("Stock name found: " + txt);
        stockname.click();
        logger.info("Search Stocks successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockinfopage));
        System.out.println("stockinfopage is visible");
    
       
    }
}