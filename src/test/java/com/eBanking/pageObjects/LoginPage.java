package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver ldriver;   //local driver

//Constructor

public LoginPage(WebDriver rdriver)   //Remote driver
{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
}

    @FindBy(name = "uid")
    @CacheLookup  //Selenium to keep a cache of the WebElement instead of searching for the WebElement every time from the WebPage.
    WebElement txtUserName;
    
    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;
    
    
    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement lnkLogout;
    
    
    //Action methods
    public void setUserName(String uname)
    {
    	txtUserName.sendKeys(uname);
    }
    
    
    public void setPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }
    
    public void clickSubmit()
    {
    	btnLogin.click();
    }
    
    public void clickLogout()
    {
    	lnkLogout.click();
    }
}
