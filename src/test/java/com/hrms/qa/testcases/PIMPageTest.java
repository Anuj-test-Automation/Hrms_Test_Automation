package com.hrms.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.qa.base.TestBase;
import com.hrms.qa.pages.HomePage;
import com.hrms.qa.pages.LoginPage;
import com.hrms.qa.pages.PIMPage;
import com.hrms.qa.util.TestUtil;

public class PIMPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	PIMPage pimPage;
	TestUtil testUtil;
	String sheetName = "HRMS";
	
	public PIMPageTest() {
		super();
	}
	
		@BeforeMethod
		public void setUp() throws Exception {
			
			initialization();
			loginPage = new LoginPage();
			homePage = new HomePage();
			pimPage = new PIMPage();
			testUtil = new TestUtil();
			homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
			homePage.navigateToAddEmployeePage(); 
		
      	}
		
		@Test(priority=1)
				
		public void verifyNameTextBoxes() {
			pimPage.validateNameTxtBoxes();
		}
		
		@Test(priority=2)
		public void verifySaveButton() {
			pimPage.validateSaveButton();
		}
		
		@DataProvider
		public Object[][] getHrmsTestData() throws InvalidFormatException{
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		@Test(priority=3, dataProvider="getHrmsTestData")
		public void verifyAddEmployee(String firstName, String lastName) {
			pimPage.addEmployee(firstName, lastName);
		}
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			homePage.verifyLogout();
			driver.quit();
		}

}
