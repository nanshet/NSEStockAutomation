package com.nse.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nse.base.BaseTest;
import com.nse.page.HomePage;
import com.nse.page.StockPage;
import com.nse.utils.Screenshot;


public class StockSelection extends BaseTest{
	
	@Test(dataProvider = "stocks")
	public void verifyStock(String stockname) throws InterruptedException {
		
		HomePage home = new HomePage(driver, wait);
		StockPage stock = new StockPage(driver,wait);
		
		Screenshot.takeScreenshot(driver, "BeforeSearch_" + stockname);
		home.navigatetoNSE(stockname);
		home.searchStock(stockname);
		
		String stockprice = stock.verifystockprice();
		String stockhighprice= stock.verifystockhighprice();
		String stocklowprice= stock.verifystocklowprice();
		
		System.out.println("Assertion Started" +stockname);
		Assert.assertFalse(stockprice.isEmpty(),"Stock Price is Empty");
		System.out.println("Assertion done for Stock Price" +stockname);
		Assert.assertFalse(stockhighprice.isEmpty(),"Stock High Price is Empty");
		System.out.println("Assertion done for Stock High Price" +stockname);
		Assert.assertFalse(stocklowprice.isEmpty(),"Stock Low Price is Empty");
		System.out.println("Assertion done for Stock Low Price"+stockname);
		System.out.println("Assertion Done");
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