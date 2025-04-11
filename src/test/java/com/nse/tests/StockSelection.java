package com.nse.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nse.base.BaseTest;
import com.nse.page.HomePage;
import com.nse.page.StockPage;
import com.nse.utils.ExtentReportManager;
import com.nse.utils.Screenshot;


public class StockSelection extends BaseTest{
	
	@Test(dataProvider = "stocks")
	public void verifyStock(String stockname) throws InterruptedException {
		test = ExtentReportManager.createTest("Stock Name:" +stockname);
		
		HomePage home = new HomePage(driver, wait);
		StockPage stock = new StockPage(driver,wait);
		
		Screenshot.takeScreenshot(driver, "BeforeSearch_" + stockname);
		test.info("Navigating to NSE website");
		home.navigatetoNSE(stockname);
		test.info("Search for the Stock Name");
		home.searchStock(stockname);
		
		test.info("Verify the Stock Current Price");
		String stockprice = stock.verifystockprice();
		test.info("Verify the Stock High Price");
		String stockhighprice= stock.verifystockhighprice();
		test.info("Verify the Stock Low Price");
		String stocklowprice= stock.verifystocklowprice();
		
	
		Assert.assertFalse(stockprice.isEmpty(),"Stock Price is Empty");
		test.info("Stock Price is available");
		Assert.assertFalse(stockhighprice.isEmpty(),"Stock High Price is Empty");
		test.info("Stock High Price is available");
		Assert.assertFalse(stocklowprice.isEmpty(),"Stock Low Price is Empty");
		test.info("Stock Low Price is available");
		test.info("All Validations Done");
		Screenshot.takeScreenshot(driver, "AfterSearch_" +stockname);
		
		
		
		
	}
	@DataProvider(name = "stocks")
	public Object[][]stocks(){
		return new Object[][] {
			{"TATAMOTORS"},
            {"COALINDIA"},
            {"BAJAJFINSV"},
		};
		
		
	}
}