package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.application.steps.HomePageSteps;
import com.application.steps.LoginPageSteps;

public class BaseTest extends BasePage{

	public LoginPageSteps loginPage = null;
	public HomePageSteps homePage = null;

	@BeforeMethod(alwaysRun=true,dependsOnMethods="setupBrowser")
	public void initializePages() {
		WebDriver driver = new BasePage().getDriver();
		loginPage = new LoginPageSteps(driver);
		homePage = new HomePageSteps(driver);
	}

}
