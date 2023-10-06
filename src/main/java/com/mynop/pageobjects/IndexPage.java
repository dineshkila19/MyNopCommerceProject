package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='header-lower']/div/a/img")
	WebElement myNopLogo;
	
	@FindBy(xpath="//*[@class='header-links-wrapper']/div/ul/li[2]/a")
	WebElement loginNopBtn;
	
	@FindBy(xpath="//*[@class='header-links-wrapper']/div/ul/li[1]/a")
	WebElement registerNopBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyNopLogo() {
		return Action.isDisplayed(getDriver(), myNopLogo);
	}
	
	public LoginPage clickOnLogin() {
		Action.click(getDriver(), loginNopBtn);
		return new LoginPage();
	}

}
