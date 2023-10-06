package com.mynop.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mynop.base.BaseClass;
import com.mynop.pageobjects.AccountCreationPage;
import com.mynop.pageobjects.IndexPage;
import com.mynop.pageobjects.LoginPage;
import com.mynop.utility.Log;

public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void registerAccountTest() {
		Log.startTestCase("registerAccountTest");
		IndexPage indexPage=new IndexPage();	
		loginPage=indexPage.clickOnLogin();
		accountCreationPage=loginPage.clickOnRegister();
		accountCreationPage.selectGender();
		accountCreationPage.enterFirstName("dinesh");
		accountCreationPage.enterLastName("chinna");
		accountCreationPage.selectDob();
		accountCreationPage.eneterEmail("kiladinesh19@gmail.com");
		accountCreationPage.clickOnNews();
		accountCreationPage.enterPassword("chinnakila19");
		accountCreationPage.enterConfirmPwd("chinnakila19");
		accountCreationPage.clickOnRegBtn();
		accountCreationPage.clickOnContinueBtn();
		Log.info("registerAccountTest testcase is passed");
		Log.endTestCase("registerAccountTest");
		
	}
}
