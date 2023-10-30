package com.hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.qa.base.TestBase;

public class PIMPage extends TestBase {
	
	
	@FindBy(name="txtEmpLastName")
	WebElement empLastNameTextBox;
	
	@FindBy(name="txtEmpFirstName")
	WebElement empFirstNameTextBox;
	
	@FindBy(xpath="//input[@name='photofile']")
	WebElement empImageFile;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement newEmpSaveButton;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimLink;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement addButton;
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateNameTxtBoxes() {
		driver.switchTo().frame(0);
		empFirstNameTextBox.isDisplayed();
		empLastNameTextBox.isDisplayed();
		driver.switchTo().defaultContent();
	}
	
	public void validateSaveButton() {
		driver.switchTo().frame(0);
		newEmpSaveButton.isDisplayed();
		driver.switchTo().defaultContent();
		
	}
	
	public void addEmployee(String firstName, String lastName) {
		pimLink.click();
		driver.switchTo().frame(0);
		addButton.click();
		empFirstNameTextBox.sendKeys(firstName);
		empLastNameTextBox.sendKeys(lastName);
		newEmpSaveButton.click();
		driver.switchTo().defaultContent();
	}

}
