package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class ShoppingCartPage extends BaseClass{
	
	@FindBy(id="termsofservice")
	WebElement selectTerms;
	
	@FindBy(xpath="//*[@name=\"checkout\"]")
	WebElement checkOutBtn;
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public BillingAddressPage clickOnCheckOut() {
		Action.click(getDriver(), selectTerms);
		Action.click(getDriver(), checkOutBtn);
		return new BillingAddressPage();
	}

}
