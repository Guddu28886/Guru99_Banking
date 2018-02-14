package com.guru99.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.utils.Util;

public class Launch_Browsers {
		
	public static WebDriver getBrowserDriver()
	{
		WebDriver driver=null;
		System.setProperty("webdriver.firefox.marionette", Util.fireFoxDriverPath);
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
