package com.eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.XLUtils;

public class LoginTest_TC_02_DDT extends BaseClass{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
		
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	
	//For alert
	public boolean isAlertPresent()  //user defined method created to check alert is present or not
	{
		try {
			driver.switchTo().alert(); //if we  
		return true;	
		}
		catch(NoAlertPresentException e) {
			return false;
			
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		
	String path = System.getProperty("user.dir")+"/src/test/java/com/eBanking/testData/LoginData.xlsx";

	int rownum = XLUtils.getRowCount(path, "Sheet1");
	int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String logindata[][] = new String[rownum][colcount];
	
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
//In excel we have eliminated 1st row, but the 2d array index starts with 0
			
		  logindata[i-1][j] = XLUtils.getCellData(path,"Sheet1", i, j);	
		
		}
			
	}
	return logindata;
	
	}
	
}
