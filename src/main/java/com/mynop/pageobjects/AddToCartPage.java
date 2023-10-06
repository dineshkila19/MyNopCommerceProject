package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='qty-input']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//*[@id='add-to-cart-button-19']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[contains(text(),'shopping cart')]")
	WebElement shoppingCartBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void addToCart(String qnty) {
		Action.type(txtQuantity, qnty);
		Action.click(getDriver(), addToCartBtn);
		
	}

	public ShoppingCartPage clickOnShoppingCart() {
		Action.click(getDriver(), shoppingCartBtn);
		return new ShoppingCartPage();
	}
}
