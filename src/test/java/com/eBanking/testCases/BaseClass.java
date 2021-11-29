package com.eBanking.testCases;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBanking.utilities.ReadConfig;

public class BaseClass {

	
	ReadConfig readconfig = new ReadConfig();
	
	//Common stuff for all the test cases
	
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
			
    public static Logger logger;
    
    //Running from diff browsers
   
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
	
	logger = Logger.getLogger("ebanking");
	PropertyConfigurator.configure("log4j.properties");
	
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());	
	driver = new ChromeDriver();
	}
	else if(br.equals("firefox"))
	{
		
		System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxPath());	
		driver = new FirefoxDriver();
	}
	
	else if(br.equals("edge"))
	{

		System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());	
		driver = new EdgeDriver();
	}
	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(baseURL);

	}
	 
	@AfterClass
	public void tearDown()
	{
			driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	//Every time it generates random string
		public String randomstring()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(8);
			return(generatedString);
		}
		
		public static String randomNum()
		{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		
		return (generatedString2);
		}
	
		public static WebElement custId1()
		{
		WebElement custId1 = driver.findElement(By.xpath("//table[@id='customer']//tr[4]/td[2]"));
		
		//WebElement custId2 = driver.findElement(By.xpath("//input[@name= 'cusid']"));
		
		return custId1;

		
		}
		
	
		
		}

