package com.application.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;

public class ApplicationTest extends BaseTest{

	@Test(priority = 1)
	public void verifyLoginPageHeader() {
		loginPage.launchApplication();
		loginPage.verifyLoginHeader("LOG IN TO YOUR ACCOUNT");
	}

	@Test(priority = 2)
	public void verifyLoginFeature(String username, String password) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username, password);
		loginPage.clickOnLoginButton();
		homePage.verifyLoginIsSuccessful();
	}

}
