package com.iggroup.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iggroup.base.TestBase;
import com.iggroup.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomer(String firstName, String lastName, String postCode,String alertText) throws InterruptedException {
		driver.findElement(By.cssSelector("addCustBtn_CSS")).click();
		driver.findElement(By.cssSelector("firstname_CSS")).sendKeys(firstName);
		driver.findElement(By.xpath("lastname_XPATH")).sendKeys(lastName);
		driver.findElement(By.cssSelector("postcode_CSS")).sendKeys(postCode);
		driver.findElement(By.cssSelector("addbtn_CSS")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains("alerttext"));
		alert.accept();

		Thread.sleep(2000);

	}

}
