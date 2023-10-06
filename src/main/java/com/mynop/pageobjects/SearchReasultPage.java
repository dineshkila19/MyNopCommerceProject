package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class SearchReasultPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='product-item']/div[2]/h2/a")
	WebElement htcProduct;
	
	public SearchReasultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddToCartPage clickOnHTC() {
		Action.click(getDriver(), htcProduct);
		return new AddToCartPage();
	}

}
