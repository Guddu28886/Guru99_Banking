package com.guru99.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Home_Page {
	
	WebDriver driver;
	public Home_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getLogoutLink()
	{
		return driver.findElement(By.linkText("Log out"));
	}

}
