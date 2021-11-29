package com.eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.AddCustomerPage;
import com.eBanking.pageObjects.LoginPage;

public class AddCustomer_TC003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("Providing customer details");
		//Entering all the data
		addcust.clickAddNewCustomer();
		addcust.custName("Mani");
		addcust.custgender("Male");
		addcust.custdob("11", "07", "1993");
		Thread.sleep(4000);
		addcust.custaddress("145 Backers Street");
		addcust.custcity("Hyd");
		addcust.custstate("Telangana");
		addcust.custpinno("5000032");
		addcust.custtelephoneno("1234567810");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("abdcedf");
		addcust.custsubmit();
		
		
		Thread.sleep(5000);
		
		logger.info("validation Started");
		
		WebElement custide = custId1();
		addcust.CapturecustId(custide);
		
		
	boolean regmsg = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(regmsg==true)
	{
		Assert.assertTrue(true);
		logger.info("Testcase is Passed");
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
		logger.info("Testcase is failed");
	}	
	

	

	}
	
	
	
	
}
