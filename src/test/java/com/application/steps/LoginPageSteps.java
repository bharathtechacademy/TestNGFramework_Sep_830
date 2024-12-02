package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void launchApplication() {		
		launchApplication(prop.getProperty("url"));
		Assert.assertEquals(getTitle(), prop.getProperty("url"));
		log("pass","Application is launched successfully");
	}
	
	public void verifyLoginHeader(String expHeader) {
		Assert.assertEquals(getElementText(loginPageHeader), expHeader);
		log("pass","Application Login Header is displayed as expected");
	}
	
	public void enterCredentials(String username, String password) {
		enterText(businessEmailTxtb, username);
		enterText(passwordTxtb, password);
		log("info","Credentials are entered successfully");
	}
	
	public void clickOnLoginButton() {
		click(loginBtn);
		log("info","Clicked on the Login Button");
	}
	

}
