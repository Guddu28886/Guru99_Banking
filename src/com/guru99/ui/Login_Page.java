package com.guru99.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	
	WebDriver driver;
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getUserName()
	{
		return driver.findElement(By.name("uid"));
	}
	public WebElement getPassword()
	{
		return driver.findElement(By.name("password"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.name("btnLogin"));
	}

}
