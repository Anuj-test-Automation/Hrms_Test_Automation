package com.hrms.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://183.82.103.245/nareshit/login.php");
		
		
		driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
		driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
		driver.findElement(By.name("Submit")).click();
		
		
		driver.findElement(By.xpath("//span[@class='drop'][text()='Admin']")).click();
		
		driver.findElement(By.linkText("Logout"));
		driver.close();

	}

}
