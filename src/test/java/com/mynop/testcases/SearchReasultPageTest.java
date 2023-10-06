package com.mynop.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mynop.base.BaseClass;
import com.mynop.pageobjects.HomePage;
import com.mynop.pageobjects.IndexPage;
import com.mynop.pageobjects.LoginPage;
import com.mynop.pageobjects.SearchReasultPage;
import com.mynop.utility.Log;

public class SearchReasultPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchReasultPage searchReasultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void SearchReasultPageTest() {
		Log.startTestCase("SearchReasultPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		searchReasultPage=homePage.searchProductBox("HTC One Mini Blue");
		searchReasultPage.clickOnHTC();
		Log.info("user clicks the htc");
		Log.info("SearchReasultPageTest testcase is passed");
		Log.endTestCase("SearchReasultPageTest");
	}
	

}
