package com.mynop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mynop.base.BaseClass;
import com.mynop.pageobjects.IndexPage;
import com.mynop.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	
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
	public void verifyMyNopLogo() {
		Log.startTestCase("verifyMyNopLogo");
		IndexPage indexPage=new IndexPage();
		boolean reasult = indexPage.validateMyNopLogo();
		Assert.assertTrue(reasult);
		Log.info("verifyMyNopLogo testcase is passed");
		Log.endTestCase("verifyMyNopLogo");
	}

}
