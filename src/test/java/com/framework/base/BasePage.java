package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {
	
	// This class will have browser related common functions and configuration related details
	
	private static WebDriver driver = null;	
	
	//method to launch the browser
	@BeforeMethod(alwaysRun=true)
	@Parameters(value="browser")
	public void setupBrowser(String browserName) {		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			Assert.fail("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	//method to terminate the browser
	@AfterMethod(alwaysRun=true)
	public void terminateBrowser() {
		driver.quit();
	}
	
	//method to share browser session details with other classes
	public WebDriver getDriver() {
		return driver;
	}

}
