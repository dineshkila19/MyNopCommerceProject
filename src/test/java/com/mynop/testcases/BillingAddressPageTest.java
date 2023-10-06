package com.mynop.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mynop.base.BaseClass;
import com.mynop.pageobjects.AddToCartPage;
import com.mynop.pageobjects.BillingAddressPage;
import com.mynop.pageobjects.HomePage;
import com.mynop.pageobjects.IndexPage;
import com.mynop.pageobjects.LoginPage;
import com.mynop.pageobjects.SearchReasultPage;
import com.mynop.pageobjects.ShoppingCartPage;
import com.mynop.utility.Log;

public class BillingAddressPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchReasultPage searchReasultPage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	BillingAddressPage billingAddressPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void BillingAddressPageTest() throws InterruptedException {
		Log.startTestCase("BillingAddressPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		searchReasultPage=homePage.searchProductBox("HTC One Mini Blue");
		addToCartPage=searchReasultPage.clickOnHTC();
		addToCartPage.addToCart("3");
		Thread.sleep(2000);
		shoppingCartPage=addToCartPage.clickOnShoppingCart();
		billingAddressPage=shoppingCartPage.clickOnCheckOut();
		billingAddressPage.enterFirstName("dinesh");
		billingAddressPage.enterLastName("kila");
		billingAddressPage.enterEmail("kiladinesh19@gmail.com");
		billingAddressPage.selectCountry();
		billingAddressPage.enterCity("Tirupati");
		billingAddressPage.enterAddress1("Ragigunta");
		billingAddressPage.enterZipCode("517644");
		billingAddressPage.enterPhoneNumber("9089786756");
		Log.info("user successfully entered billing address");
		billingAddressPage.clickOnContinue();
		Log.info("BillingAddressPageTest testcase is passed");
		Log.endTestCase("BillingAddressPageTest");
	}
	

}
