package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='button-1 register-button']")
	WebElement nopRegBtn;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@class='returning-wrapper fieldset']/form/div[3]/button")
	WebElement loginBTN;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public AccountCreationPage clickOnRegister() {
		Action.click(getDriver(), nopRegBtn);
		return new AccountCreationPage();
	}
	public HomePage login(String uemail,String upwd) {
		Action.type(txtEmail, uemail);
		Action.type(txtPassword, upwd);
		Action.click(getDriver(), loginBTN);
		return new HomePage();
	}

}
