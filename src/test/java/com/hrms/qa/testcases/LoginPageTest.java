package com.hrms.qa.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.hrms.qa.base.TestBase;
import com.hrms.qa.pages.HomePage;
import com.hrms.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception{
	
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
	}
	@Test(priority=2)
	public void validateIntroTxt() {
		boolean text = loginPage.validateIntroTxt();
		Assert.assertTrue(text);
	}
	
	@Test(priority=3)
	public void loginTest() throws Exception {
		
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
