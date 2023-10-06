package com.mynop.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mynop.base.BaseClass;
import com.mynop.dataprovider.DataProviders;
import com.mynop.pageobjects.IndexPage;
import com.mynop.pageobjects.LoginPage;
import com.mynop.utility.Log;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "NopLoginData", dataProviderClass=DataProviders.class, groups= {"Smoke","Sanity"})
	public void loginTest(String email,String password) {
		Log.startTestCase("loginTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		//loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.login(email, password);
		Log.info("successfully entered login credentials");
		Log.info("loginTest testcase is passed");
		Log.endTestCase("loginTest");
	}

}
