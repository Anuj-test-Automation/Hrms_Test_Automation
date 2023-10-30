package com.hrms.qa.base;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.hrms.qa.util.WebEventListener;

import com.hrms.qa.util.TestUtil;

//import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() {
		
		
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("src\\main\\java\\com\\hrms\\qa\\config\\config.properties");
		prop.load(ip);
		
		}catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	public static void initialization() throws Exception {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
	          //WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equals("FF")) {
				// WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		/*if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else {
			System.out.println("Browser Not available");
		}
		*/
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		
	}

}
