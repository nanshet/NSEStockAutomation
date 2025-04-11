package com.nse.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportManager{
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public static ExtentReports getInstance() {
		
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Extent-reports.html");
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Environment", "QA");
			
		}
		return extent;
	}
	
	public static ExtentTest createTest(String testName) {
		test = getInstance().createTest(testName);
		return test;
		
	}
	
	public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}