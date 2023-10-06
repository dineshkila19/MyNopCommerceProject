package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy(id="gender-male")
	WebElement selectGender;
	
	@FindBy(id="FirstName")
	WebElement txtFirstname;
	
	@FindBy(id="LastName")
	WebElement txtLastname;
	
	@FindBy(xpath="//*[@name='DateOfBirthDay']")
	WebElement date;
	
	@FindBy(xpath="//*[@name='DateOfBirthMonth']")
	WebElement month;
	
	@FindBy(xpath="//*[@name='DateOfBirthYear']")
	WebElement year;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Newsletter")
	WebElement clickNews;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(id="ConfirmPassword")
	WebElement txtCpassword;
	
	@FindBy(id="register-button")
	WebElement regButton;
	
	@FindBy(xpath="//*[@class='button-1 register-continue-button']")
	WebElement continueBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectGender() {
		Action.click(getDriver(), txtFirstname);
	}
	public void enterFirstName(String fname) {
		Action.type(txtFirstname, fname);
	}
	public void enterLastName(String lname) {
		Action.type(txtLastname, lname);
	}
	public void selectDob() {
		Action.selectByIndex(date, 19);
		Action.selectByValue(month, "June");
		Action.selectByVisibleText(year, "1995");
	}
	public void eneterEmail(String uemail) {
		Action.type(txtEmail, uemail);
	}
	public void clickOnNews() {
		Action.click(getDriver(), clickNews);
	}
	public void enterPassword(String upwd) {
		Action.type(txtPassword, upwd);
	}
	public void enterConfirmPwd(String cpwd) {
		Action.type(txtCpassword, cpwd);
	}
	public void clickOnRegBtn() {
		Action.click(getDriver(), regButton);
	
	}
	public void clickOnContinueBtn() {
		Action.click(getDriver(), continueBtn);
	}
	
	
	
	
	
	

}
