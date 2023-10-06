package com.mynop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mynop.actiondriver.Action;
import com.mynop.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//*[@name='q']")
	WebElement searchProductBox;
	
	@FindBy(xpath="//*[@class='button-1 search-box-button']")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getNopTitle() throws Throwable {
		String getTitle=Action.getTitle(getDriver());
		return getTitle;
	}
	
	public SearchReasultPage searchProductBox(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchBtn);
		return new SearchReasultPage();
	}

}
