package com.mynop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mynop.base.BaseClass;
import com.mynop.pageobjects.HomePage;
import com.mynop.pageobjects.IndexPage;
import com.mynop.pageobjects.LoginPage;
import com.mynop.utility.Log;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() throws Throwable {
		Log.startTestCase("verifyTitle");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		String actTitle=homePage.getNopTitle();
		String expTitle="nopCommerce demo store";
		Assert.assertEquals(actTitle, expTitle);
		Log.info("verifyTitle testcase is passed");
		Log.endTestCase("verifyTitle");
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void searchProduct() {
		Log.startTestCase("searchProduct");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		homePage.searchProductBox("HTC One Mini Blue");
		Log.info("user successfully click on the product");
		Log.info("searchProduct testcase is passed");
		Log.endTestCase("searchProduct");
		
	}

}
