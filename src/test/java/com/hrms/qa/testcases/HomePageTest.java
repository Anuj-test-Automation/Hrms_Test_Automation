package com.hrms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hrms.qa.base.TestBase;
import com.hrms.qa.pages.AdminPage;
import com.hrms.qa.pages.HomePage;
import com.hrms.qa.pages.LeavePage;
import com.hrms.qa.pages.LoginPage;
import com.hrms.qa.pages.PIMPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	AdminPage adminPage;
	PIMPage pimPage;
	LeavePage leavePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		initialization();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		pimPage   = new PIMPage();
		leavePage = new LeavePage();
		homePage  = new HomePage();
		homePage  = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	@Test(priority=1)
	public void verifyPageTitle() {
		String title = homePage.verifyPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void verifyUsername() {
		boolean userName = homePage.verifyUserName();
		Assert.assertTrue(userName);
	}
	
	@Test(priority=3)
	public void verifyAdminLink() {
		adminPage = homePage.verifyAdminLink();
		
	}
	
	@Test(priority=4)
	public void verifyPimLink() throws Exception  {
		
		pimPage = homePage.verifyPimLink();
		
	}
	
	@Test(priority=5)
	public void verifyLeaveLink() {
		leavePage = homePage.verifyLeaveLink();
	}
	
	
	@Test(priority=6)	
	public void verifClickCheckBox() throws Exception {
		homePage.clickCheckBox();
		homePage.deleteButton();
	}
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		homePage.verifyLogout();
		driver.quit();
	}
	
	

}
