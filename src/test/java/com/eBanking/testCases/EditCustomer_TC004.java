package com.eBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.EditCustomerPage;
import com.eBanking.pageObjects.LoginPage;

public class EditCustomer_TC004 extends BaseClass {

	@Test
	
	public void EditNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
	
		
		EditCustomerPage editcust = new EditCustomerPage(driver);
		
		logger.info("Editing customer details");
		
	
		
		
		//String editcusId = customerId2.SendKeys(custId1);
		//editcust.EditCustId(baseURL);

		
		editcust.custsubmit();
		
		editcust.custemailid("test123@gmail.com");
		Thread.sleep(5000);
		
		logger.info("validation Started");
		
		boolean updmsg = driver.getPageSource().contains("Customer details updated Successfully!!!");
		
		if(updmsg ==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase is Passed");
		}
		else
		{
			captureScreen(driver,"EditCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase is failed");
		}	
		
	}
}
