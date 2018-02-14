package com.guru99.banking;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.config.Launch_Browsers;
import com.guru99.ui.Home_Page;
import com.guru99.ui.Login_Page;
import com.guru99.utils.GetData;
import com.guru99.utils.Util;

public class Guru99_Bank_Main {

	@DataProvider(name="Gurutest")
	public Object[][] getData()
	{
		Object[][] data=new Object[4][2];
		int lastRowIndex=GetData.lastRowIndex("Login_Data", "Login");
		//int lastCellIndex=GetData.lastCellIndex("Login_Data", "Login",lastRowIndex);
		for(int i=1;i<=lastRowIndex;i++)
		{
			data[i-1][0]=GetData.fromExcel("Login_Data", "Login", i, 0);
		}
		for(int j=1;j<=lastRowIndex;j++)
		{
			data[j-1][1]=GetData.fromExcel("Login_Data", "Login", j, 1);
		}
		return data;
	}
	
	@Test(dataProvider="Gurutest")
	public static void Run(String uname,String pwd) throws InterruptedException, IOException {
		
		WebDriver driver=Launch_Browsers.getBrowserDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		driver.get(Util.baseUrl);
		Login_Page login=new Login_Page(driver);
		Home_Page home=new Home_Page(driver);
		
				
				login.getUserName().sendKeys(uname);
				login.getPassword().sendKeys(pwd);
				login.getLoginButton().click();
				try{
					Alert alt=driver.switchTo().alert();
					System.out.println(alt.getText());
					alt.accept();
					//System.out.println("Test Case SS"+i+" Failed");		
				}
				catch(NoAlertPresentException e)
				{	
					EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
					File src=edriver.getScreenshotAs(OutputType.FILE);
					File trg=new File("D://Workspace/Guru99_Banking/screenshots/Screen.jpg");
					FileUtils.copyFile(src, trg);
					wait.until(ExpectedConditions.visibilityOf(home.getLogoutLink()));
					System.out.println(driver.getTitle());
					home.getLogoutLink().click();
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alt=driver.switchTo().alert();
					System.out.println(alt.getText());
					alt.accept();
					//System.out.println("Test Case SS"+i+" Passed");
				}
			
		
		driver.close();
	}

}

/**
 * SS1: Enter valid userid & password 
 *      Expected: Login successful home page shown 
 * SS2: Enter invalid userid & valid password 
 * SS3: Enter valid userid & invalid password 
 * SS4: Enter invalid userid & invalid password 
 *      Expected: A pop-up “User or Password is not valid” is shown
 * 
 * @throws Exception
 */
