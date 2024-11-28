package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.base.BasePage;

public class WebCommons {
	
	// This class will have common functions related to selenium web actions
	public WebDriver driver = new BasePage().getDriver();
	
	
	//method to launch the application
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	//method to scroll to element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",element);
	}
	
	//method to click on the element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	//method to click on the hidden element
	public void jsClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",element);
	}
	
	//method to enter text into textbox element
	public void enterText(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}
	
	//method to select checkbox
	public void checkbox(WebElement element, boolean status) {
		scrollToElement(element);
		if(element.isSelected()!=status) {
			element.click();
		}
	}
	
	//method to select option from dropdown
	public void selectOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select s = new Select(dropdown);
		if(selectBy.equalsIgnoreCase("ByVisibleText")) {
			s.selectByVisibleText(option);
		}else if(selectBy.equalsIgnoreCase("ByValue")) {
			s.selectByValue(option);
		}else if(selectBy.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(option));
		}		
	}
	
	//method wait using java
	public void wait(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//method to wait using implicit wait
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}	
	
	//method to wait using explicit wait
	public void waitForElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec) );
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//method to wait using explicit wait
	public void waitForElement(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec) );
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//method to take screenshot of window
	public static String takeWindowScreenshot(WebDriver driver, String screenshotNameAndFromat) throws IOException {
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotNameAndFromat;
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	//method to take screenshot of element
	public static String takeElementScreenshot(WebElement element, String screenshotNameAndFromat) throws IOException {
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotNameAndFromat;
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	//method to handle alerts
	public void alert(String action) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		if(action.equalsIgnoreCase("accept")) {
			alert.accept();
		}else if(action.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}else {
			Assert.fail("Invalid Action");
		}
	}
	
}