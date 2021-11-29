package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	
	WebDriver ldriver;
	
	//constructor
	
	public EditCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Edit Customer')]")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

//	@FindBy(how = How.XPATH, using = "//table[@id='customer']//tr[4]/td[2]")
//	@CacheLookup
//	WebElement custId;
	
	@FindBy(how = How.XPATH, using ="//input[@name= 'cusid']")
	@CacheLookup
	WebElement customerId2;
	
	
	public void clickEditCustomer() { //
		lnkEditCustomer.click();
			
	}
	
	public void custemailid(String editemailid) {
		txtemailid.sendKeys(editemailid);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	public void EditCustId(String editCust)
	{
		customerId2.sendKeys(editCust);
	}


}
