package com.hrms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.qa.base.TestBase;

public class HomePage extends TestBase{
	

	@FindBy(xpath="//div[@id='companyLogoHeader']")
	WebElement companyLogo;
	
	@FindBy(xpath="//li[text()='Welcome nareshit']")
	WebElement verifyUser;
	
	@FindBy(linkText="Logout")
	WebElement linkLogout;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminLink;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimLink;
	
	@FindBy(xpath="//span[text()='Leave']")
    WebElement leaveLink;	
	
	@FindBy(xpath="//input[@value=\"Delete\"]")
	WebElement deleteButton;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement addButton;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		
		return verifyUser.isDisplayed();
	}
	
	public AdminPage verifyAdminLink() {
		
		adminLink.click();
		return new AdminPage();
	}
	
	public PIMPage verifyPimLink() throws Exception {
		
		pimLink.click();
		return new PIMPage();
	}
	
	public LeavePage verifyLeaveLink() {
		
		leaveLink.click();
		return new LeavePage();
	}
	public void verifyLogout() throws Exception {
		
		linkLogout.click();
		Thread.sleep(2000);
		
	}
	
	public void clickCheckBox() throws Exception {
		
		pimLink.click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		for(int checkBoxNumber=1;checkBoxNumber<=10;checkBoxNumber = checkBoxNumber+2) {
			
			driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr["+checkBoxNumber+"]/td[1]/input")).click();
			Thread.sleep(1000);
		}
		driver.switchTo().defaultContent();
		
		
	}
	
	public void deleteButton() throws Exception {
		driver.switchTo().frame(0);
		deleteButton.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
	
	public void navigateToAddEmployeePage() throws Exception {
		
		pimLink.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		addButton.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
	
	
}
