package com.iggroup.testcases;

import java.io.IOException;

//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.iggroup.base.TestBase;

public class BankManagerLoginTest extends TestBase
{
	@Test
	public void loginAsBankManager() throws InterruptedException, IOException
	{
		
		verifyEquals("abc", "xyz");
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustomer"))),"Not Proper Login");
		Reporter.log("Test Case is passed ");
		//Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login not successful");
	}

	
}