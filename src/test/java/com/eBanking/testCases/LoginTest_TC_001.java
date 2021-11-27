package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPage;

public class LoginTest_TC_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL is opened");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
			Assert.assertTrue(true);
			logger.info("login test passed");
			
				}
		else {
			
			//Call the fail screenshot method
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		
		}
	
	}
	
}
