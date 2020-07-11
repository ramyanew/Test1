package com.iggroup.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.iggroup.listeners.CustomListener;
import com.iggroup.utilities.ExcelReader;
import com.iggroup.utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	
	public static ExtentReports rep= ExtentReports.getInstance();
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp()
	{
		if(driver==null)
		{
			//FileInputStream fis;
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(System.getProperty("user.dir"));
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//	Properties OR= new Properties();
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
				driver= new ChromeDriver();
									
			}else if(config.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\chromedriver.exe");
				driver= new FirefoxDriver();
			}
			
			driver.get(config.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		}
		
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
	}
	
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
			
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			CustomListener.testReport.get().log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
			//CustomListeners.testReport.get().log(Status.FAIL, CustomListeners.testReport.get().addScreenCaptureFromPath(TestUtil.screenshotName));

		}

	}

}
