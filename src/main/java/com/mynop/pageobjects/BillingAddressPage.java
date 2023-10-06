package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class BillingAddressPage extends BaseClass{
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement txtLastName;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement txtEmail;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryId;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement txtCity;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement txtAddress1;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement txtZipCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//*[@id='billing-buttons-container']/button[4]")
	WebElement continueBtn;
	
	public BillingAddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterFirstName(String fname) {
		Action.type(txtFirstName, fname);
	}
	public void enterLastName(String lname) {
		Action.type(txtLastName, lname);
	}
	public void enterEmail(String uemail) {
		Action.type(txtEmail, uemail);
	}
	public void selectCountry() {
		Action.selectByVisibleText(countryId, "India");
	}
	public void enterCity(String ucity) {
		Action.type(txtCity, ucity);
	}
	public void enterAddress1(String uadd) {
		Action.type(txtAddress1, uadd);
	}
	public void enterZipCode(String uzip) {
		Action.type(txtZipCode, uzip);
	}
	public void enterPhoneNumber(String uph) {
		Action.type(txtPhoneNumber, uph);
	}
	public ShippingAddressPage clickOnContinue() {
		Action.click(getDriver(), continueBtn);
		return new ShippingAddressPage();
	}
	
	
	
	
	
	

}
