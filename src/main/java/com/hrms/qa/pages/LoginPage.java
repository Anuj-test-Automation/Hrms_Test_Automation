package com.hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	//Page Factory or OR(Object Repository)
	@FindBy(name="txtUserName")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement submitBtn;
	
	@FindBy(xpath="//font[@face='tahoma']")
	WebElement introTxt;
	
	@FindBy(linkText="OrangeHRM")
	WebElement projectLink;
	
	
	//initialization of objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateIntroTxt() {
		return introTxt.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws Exception {
		username.sendKeys(un);
		Thread.sleep(1000);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(1000);
		
		return new HomePage();
	}
}
