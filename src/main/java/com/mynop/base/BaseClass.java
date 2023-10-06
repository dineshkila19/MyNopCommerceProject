package com.mynop.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mynop.actiondriver.Action;
import com.mynop.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public static void loadConfig() {
		DOMConfigurator.configure("log4j.xml");
		ExtentManager.setExtent();

		
		try {
			prop=new Properties();
			
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	public void launchApp(String browserName) {
		
		WebDriverManager.chromedriver().setup();
		//String browserName=prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 45);
		Action.pageLoadTimeOut(getDriver(), 55);
		getDriver().get(prop.getProperty("url"));
		
		
	}
	
	@AfterSuite(groups= {"Smoke","Sanity","Regression"})
	public static void afterSuite() {
		ExtentManager.endReport();
	}
	
	
	
	
	
	

}
