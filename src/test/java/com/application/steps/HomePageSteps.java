package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void verifyLoginIsSuccessful() {
		waitForElement(homePageHeaderLink,30);
		log("pass","Application Login is Successful");
	}

}
