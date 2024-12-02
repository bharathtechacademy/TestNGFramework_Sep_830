package com.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class HomePageElements extends WebCommons{
	
	@FindBy(xpath="//span[text()='Application Hub']")
	public WebElement homePageHeaderLink;
	
	@FindBy(xpath="//span[text()='Users']")
	public WebElement usersLink;

}
